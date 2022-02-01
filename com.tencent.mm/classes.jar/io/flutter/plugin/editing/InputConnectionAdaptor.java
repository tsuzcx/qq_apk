package io.flutter.plugin.editing;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.CursorAnchorInfo.Builder;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.android.AndroidKeyProcessor;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;

class InputConnectionAdaptor
  extends BaseInputConnection
  implements ListenableEditingState.EditingStateWatcher
{
  private static final String TAG = "InputConnectionAdaptor";
  private FlutterTextUtils flutterTextUtils;
  private final AndroidKeyProcessor keyProcessor;
  private final int mClient;
  private CursorAnchorInfo.Builder mCursorAnchorInfoBuilder;
  private final ListenableEditingState mEditable;
  private final EditorInfo mEditorInfo;
  private ExtractedTextRequest mExtractRequest;
  private ExtractedText mExtractedText;
  private final View mFlutterView;
  private InputMethodManager mImm;
  private final Layout mLayout;
  private boolean mMonitorCursorUpdate;
  private final TextInputChannel textInputChannel;
  
  public InputConnectionAdaptor(View paramView, int paramInt, TextInputChannel paramTextInputChannel, AndroidKeyProcessor paramAndroidKeyProcessor, ListenableEditingState paramListenableEditingState, EditorInfo paramEditorInfo)
  {
    this(paramView, paramInt, paramTextInputChannel, paramAndroidKeyProcessor, paramListenableEditingState, paramEditorInfo, new FlutterJNI());
    AppMethodBeat.i(189745);
    AppMethodBeat.o(189745);
  }
  
  public InputConnectionAdaptor(View paramView, int paramInt, TextInputChannel paramTextInputChannel, AndroidKeyProcessor paramAndroidKeyProcessor, ListenableEditingState paramListenableEditingState, EditorInfo paramEditorInfo, FlutterJNI paramFlutterJNI)
  {
    super(paramView, true);
    AppMethodBeat.i(189734);
    this.mMonitorCursorUpdate = false;
    this.mExtractedText = new ExtractedText();
    this.mFlutterView = paramView;
    this.mClient = paramInt;
    this.textInputChannel = paramTextInputChannel;
    this.mEditable = paramListenableEditingState;
    this.mEditable.addEditingStateListener(this);
    this.mEditorInfo = paramEditorInfo;
    this.keyProcessor = paramAndroidKeyProcessor;
    this.flutterTextUtils = new FlutterTextUtils(paramFlutterJNI);
    this.mLayout = new DynamicLayout(this.mEditable, new TextPaint(), 2147483647, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.mImm = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    AppMethodBeat.o(189734);
  }
  
  private static int clampIndexToEditable(int paramInt, Editable paramEditable)
  {
    AppMethodBeat.i(9952);
    int i = Math.max(0, Math.min(paramEditable.length(), paramInt));
    if (i != paramInt) {
      Log.d("flutter", "Text selection index was clamped (" + paramInt + "->" + i + ") to remain in bounds. This may not be your fault, as some keyboards may select outside of bounds.");
    }
    AppMethodBeat.o(9952);
    return i;
  }
  
  private boolean doPerformContextMenuAction(int paramInt)
  {
    AppMethodBeat.i(189796);
    if (paramInt == 16908319)
    {
      setSelection(0, this.mEditable.length());
      AppMethodBeat.o(189796);
      return true;
    }
    int i;
    int j;
    Object localObject;
    if (paramInt == 16908320)
    {
      i = Selection.getSelectionStart(this.mEditable);
      j = Selection.getSelectionEnd(this.mEditable);
      if (i != j)
      {
        paramInt = Math.min(i, j);
        i = Math.max(i, j);
        localObject = this.mEditable.subSequence(paramInt, i);
        ((ClipboardManager)this.mFlutterView.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", (CharSequence)localObject));
        this.mEditable.delete(paramInt, i);
        setSelection(paramInt, paramInt);
      }
      AppMethodBeat.o(189796);
      return true;
    }
    if (paramInt == 16908321)
    {
      paramInt = Selection.getSelectionStart(this.mEditable);
      i = Selection.getSelectionEnd(this.mEditable);
      if (paramInt != i)
      {
        localObject = this.mEditable.subSequence(Math.min(paramInt, i), Math.max(paramInt, i));
        ((ClipboardManager)this.mFlutterView.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", (CharSequence)localObject));
      }
      AppMethodBeat.o(189796);
      return true;
    }
    if (paramInt == 16908322)
    {
      localObject = ((ClipboardManager)this.mFlutterView.getContext().getSystemService("clipboard")).getPrimaryClip();
      if (localObject != null)
      {
        localObject = ((ClipData)localObject).getItemAt(0).coerceToText(this.mFlutterView.getContext());
        i = Math.max(0, Selection.getSelectionStart(this.mEditable));
        j = Math.max(0, Selection.getSelectionEnd(this.mEditable));
        paramInt = Math.min(i, j);
        i = Math.max(i, j);
        if (paramInt != i) {
          this.mEditable.delete(paramInt, i);
        }
        this.mEditable.insert(paramInt, (CharSequence)localObject);
        paramInt = ((CharSequence)localObject).length() + paramInt;
        setSelection(paramInt, paramInt);
      }
      AppMethodBeat.o(189796);
      return true;
    }
    AppMethodBeat.o(189796);
    return false;
  }
  
  private CursorAnchorInfo getCursorAnchorInfo()
  {
    AppMethodBeat.i(189765);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(189765);
      return null;
    }
    if (this.mCursorAnchorInfoBuilder == null)
    {
      this.mCursorAnchorInfoBuilder = new CursorAnchorInfo.Builder();
      this.mCursorAnchorInfoBuilder.setSelectionRange(this.mEditable.getSelectionStart(), this.mEditable.getSelectionEnd());
      int i = this.mEditable.getComposingStart();
      int j = this.mEditable.getComposingEnd();
      if ((i < 0) || (j <= i)) {
        break label131;
      }
      this.mCursorAnchorInfoBuilder.setComposingText(i, this.mEditable.toString().subSequence(i, j));
    }
    for (;;)
    {
      CursorAnchorInfo localCursorAnchorInfo = this.mCursorAnchorInfoBuilder.build();
      AppMethodBeat.o(189765);
      return localCursorAnchorInfo;
      this.mCursorAnchorInfoBuilder.reset();
      break;
      label131:
      this.mCursorAnchorInfoBuilder.setComposingText(-1, "");
    }
  }
  
  private ExtractedText getExtractedText(ExtractedTextRequest paramExtractedTextRequest)
  {
    AppMethodBeat.i(189754);
    this.mExtractedText.startOffset = 0;
    this.mExtractedText.partialStartOffset = -1;
    this.mExtractedText.partialEndOffset = -1;
    this.mExtractedText.selectionStart = this.mEditable.getSelectionStart();
    this.mExtractedText.selectionEnd = this.mEditable.getSelectionEnd();
    ExtractedText localExtractedText = this.mExtractedText;
    if ((paramExtractedTextRequest == null) || ((paramExtractedTextRequest.flags & 0x1) == 0)) {}
    for (paramExtractedTextRequest = this.mEditable.toString();; paramExtractedTextRequest = this.mEditable)
    {
      localExtractedText.text = paramExtractedTextRequest;
      paramExtractedTextRequest = this.mExtractedText;
      AppMethodBeat.o(189754);
      return paramExtractedTextRequest;
    }
  }
  
  private boolean isSamsung()
  {
    AppMethodBeat.i(189776);
    if ((this.mImm.getCurrentInputMethodSubtype() == null) || (Build.VERSION.SDK_INT < 21) || (!Build.MANUFACTURER.equals("samsung")))
    {
      AppMethodBeat.o(189776);
      return false;
    }
    Object localObject = this.mFlutterView.getContext().getContentResolver();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG("default_input_method").cG(localObject);
    boolean bool = ((String)com.tencent.mm.hellhoundlib.a.a.a(new Object(), ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "io/flutter/plugin/editing/InputConnectionAdaptor", "isSamsung", "()Z", "android/provider/Settings$Secure", "getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;")).contains("Samsung");
    AppMethodBeat.o(189776);
    return bool;
  }
  
  public boolean beginBatchEdit()
  {
    AppMethodBeat.i(9945);
    this.mEditable.beginBatchEdit();
    boolean bool = super.beginBatchEdit();
    AppMethodBeat.o(9945);
    return bool;
  }
  
  public boolean clearMetaKeyStates(int paramInt)
  {
    AppMethodBeat.i(189879);
    boolean bool = super.clearMetaKeyStates(paramInt);
    AppMethodBeat.o(189879);
    return bool;
  }
  
  public void closeConnection()
  {
    AppMethodBeat.i(189889);
    super.closeConnection();
    this.mEditable.removeEditingStateListener(this);
    AppMethodBeat.o(189889);
  }
  
  public boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(9947);
    boolean bool = super.commitText(paramCharSequence, paramInt);
    AppMethodBeat.o(9947);
    return bool;
  }
  
  public boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9948);
    if (this.mEditable.getSelectionStart() == -1)
    {
      AppMethodBeat.o(9948);
      return true;
    }
    boolean bool = super.deleteSurroundingText(paramInt1, paramInt2);
    AppMethodBeat.o(9948);
    return bool;
  }
  
  public boolean deleteSurroundingTextInCodePoints(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189836);
    boolean bool = super.deleteSurroundingTextInCodePoints(paramInt1, paramInt2);
    AppMethodBeat.o(189836);
    return bool;
  }
  
  public void didChangeEditingState(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(189936);
    this.mImm.updateSelection(this.mFlutterView, this.mEditable.getSelectionStart(), this.mEditable.getSelectionEnd(), this.mEditable.getComposingStart(), this.mEditable.getComposingEnd());
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(189936);
      return;
    }
    if (this.mExtractRequest != null) {
      this.mImm.updateExtractedText(this.mFlutterView, this.mExtractRequest.token, getExtractedText(this.mExtractRequest));
    }
    if (this.mMonitorCursorUpdate)
    {
      CursorAnchorInfo localCursorAnchorInfo = getCursorAnchorInfo();
      this.mImm.updateCursorAnchorInfo(this.mFlutterView, localCursorAnchorInfo);
    }
    AppMethodBeat.o(189936);
  }
  
  public boolean endBatchEdit()
  {
    AppMethodBeat.i(9946);
    boolean bool = super.endBatchEdit();
    this.mEditable.endBatchEdit();
    AppMethodBeat.o(9946);
    return bool;
  }
  
  public boolean finishComposingText()
  {
    AppMethodBeat.i(189857);
    boolean bool = super.finishComposingText();
    AppMethodBeat.o(189857);
    return bool;
  }
  
  public Editable getEditable()
  {
    return this.mEditable;
  }
  
  public ExtractedText getExtractedText(ExtractedTextRequest paramExtractedTextRequest, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(189863);
    if ((paramInt & 0x1) != 0)
    {
      paramInt = 1;
      if (this.mExtractRequest != null) {
        break label96;
      }
      label23:
      if (paramInt == i)
      {
        StringBuilder localStringBuilder = new StringBuilder("The input method toggled text monitoring ");
        if (paramInt == 0) {
          break label101;
        }
        localObject = "on";
        label49:
        Log.d("InputConnectionAdaptor", (String)localObject);
      }
      if (paramInt == 0) {
        break label109;
      }
    }
    label96:
    label101:
    label109:
    for (Object localObject = paramExtractedTextRequest;; localObject = null)
    {
      this.mExtractRequest = ((ExtractedTextRequest)localObject);
      paramExtractedTextRequest = getExtractedText(paramExtractedTextRequest);
      AppMethodBeat.o(189863);
      return paramExtractedTextRequest;
      paramInt = 0;
      break;
      i = 0;
      break label23;
      localObject = "off";
      break label49;
    }
  }
  
  public boolean performContextMenuAction(int paramInt)
  {
    AppMethodBeat.i(189910);
    beginBatchEdit();
    boolean bool = doPerformContextMenuAction(paramInt);
    endBatchEdit();
    AppMethodBeat.o(189910);
    return bool;
  }
  
  public boolean performEditorAction(int paramInt)
  {
    AppMethodBeat.i(9954);
    switch (paramInt)
    {
    case 6: 
    default: 
      this.textInputChannel.done(this.mClient);
    }
    for (;;)
    {
      AppMethodBeat.o(9954);
      return true;
      this.textInputChannel.newline(this.mClient);
      continue;
      this.textInputChannel.unspecifiedAction(this.mClient);
      continue;
      this.textInputChannel.go(this.mClient);
      continue;
      this.textInputChannel.search(this.mClient);
      continue;
      this.textInputChannel.send(this.mClient);
      continue;
      this.textInputChannel.next(this.mClient);
      continue;
      this.textInputChannel.previous(this.mClient);
    }
  }
  
  public boolean performPrivateCommand(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(189917);
    this.textInputChannel.performPrivateCommand(this.mClient, paramString, paramBundle);
    AppMethodBeat.o(189917);
    return true;
  }
  
  public boolean requestCursorUpdates(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(189871);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(189871);
      return false;
    }
    if ((paramInt & 0x1) != 0) {
      this.mImm.updateCursorAnchorInfo(this.mFlutterView, getCursorAnchorInfo());
    }
    if ((paramInt & 0x2) != 0) {
      bool = true;
    }
    StringBuilder localStringBuilder;
    if (bool != this.mMonitorCursorUpdate)
    {
      localStringBuilder = new StringBuilder("The input method toggled cursor monitoring ");
      if (!bool) {
        break label108;
      }
    }
    label108:
    for (String str = "on";; str = "off")
    {
      Log.d("InputConnectionAdaptor", str);
      this.mMonitorCursorUpdate = bool;
      AppMethodBeat.o(189871);
      return true;
    }
  }
  
  public boolean sendKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(9953);
    if ((this.keyProcessor != null) && (!this.keyProcessor.isPendingEvent(paramKeyEvent)) && (this.keyProcessor.onKeyEvent(paramKeyEvent)))
    {
      AppMethodBeat.o(9953);
      return true;
    }
    int i;
    if (paramKeyEvent.getAction() == 0)
    {
      if (paramKeyEvent.getKeyCode() == 21)
      {
        i = Selection.getSelectionStart(this.mEditable);
        j = Selection.getSelectionEnd(this.mEditable);
        if ((i == j) && (!paramKeyEvent.isShiftPressed()))
        {
          i = Math.max(this.flutterTextUtils.getOffsetBefore(this.mEditable, i), 0);
          setSelection(i, i);
        }
        for (;;)
        {
          AppMethodBeat.o(9953);
          return true;
          setSelection(i, Math.max(this.flutterTextUtils.getOffsetBefore(this.mEditable, j), 0));
        }
      }
      if (paramKeyEvent.getKeyCode() == 22)
      {
        i = Selection.getSelectionStart(this.mEditable);
        j = Selection.getSelectionEnd(this.mEditable);
        if ((i == j) && (!paramKeyEvent.isShiftPressed()))
        {
          i = Math.min(this.flutterTextUtils.getOffsetAfter(this.mEditable, i), this.mEditable.length());
          setSelection(i, i);
        }
        for (;;)
        {
          AppMethodBeat.o(9953);
          return true;
          setSelection(i, Math.min(this.flutterTextUtils.getOffsetAfter(this.mEditable, j), this.mEditable.length()));
        }
      }
      if (paramKeyEvent.getKeyCode() == 19)
      {
        if ((Selection.getSelectionStart(this.mEditable) == Selection.getSelectionEnd(this.mEditable)) && (!paramKeyEvent.isShiftPressed()))
        {
          Selection.moveUp(this.mEditable, this.mLayout);
          i = Selection.getSelectionStart(this.mEditable);
          setSelection(i, i);
        }
        for (;;)
        {
          AppMethodBeat.o(9953);
          return true;
          Selection.extendUp(this.mEditable, this.mLayout);
          setSelection(Selection.getSelectionStart(this.mEditable), Selection.getSelectionEnd(this.mEditable));
        }
      }
      if (paramKeyEvent.getKeyCode() == 20)
      {
        if ((Selection.getSelectionStart(this.mEditable) == Selection.getSelectionEnd(this.mEditable)) && (!paramKeyEvent.isShiftPressed()))
        {
          Selection.moveDown(this.mEditable, this.mLayout);
          i = Selection.getSelectionStart(this.mEditable);
          setSelection(i, i);
        }
        for (;;)
        {
          AppMethodBeat.o(9953);
          return true;
          Selection.extendDown(this.mEditable, this.mLayout);
          setSelection(Selection.getSelectionStart(this.mEditable), Selection.getSelectionEnd(this.mEditable));
        }
      }
      if (((paramKeyEvent.getKeyCode() == 66) || (paramKeyEvent.getKeyCode() == 160)) && ((0x20000 & this.mEditorInfo.inputType) == 0))
      {
        performEditorAction(this.mEditorInfo.imeOptions & 0xFF);
        AppMethodBeat.o(9953);
        return true;
      }
      i = paramKeyEvent.getUnicodeChar();
      if (i == 0)
      {
        AppMethodBeat.o(9953);
        return false;
      }
      int k = Math.max(0, Selection.getSelectionStart(this.mEditable));
      int m = Math.max(0, Selection.getSelectionEnd(this.mEditable));
      int j = Math.min(k, m);
      k = Math.max(k, m);
      if (j != k) {
        this.mEditable.delete(j, k);
      }
      this.mEditable.insert(j, String.valueOf((char)i));
      setSelection(j + 1, j + 1);
      AppMethodBeat.o(9953);
      return true;
    }
    if ((paramKeyEvent.getAction() == 1) && ((paramKeyEvent.getKeyCode() == 59) || (paramKeyEvent.getKeyCode() == 60)))
    {
      i = Selection.getSelectionEnd(this.mEditable);
      setSelection(i, i);
      AppMethodBeat.o(9953);
      return true;
    }
    AppMethodBeat.o(9953);
    return false;
  }
  
  public boolean setComposingRegion(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9949);
    boolean bool = super.setComposingRegion(paramInt1, paramInt2);
    AppMethodBeat.o(9949);
    return bool;
  }
  
  public boolean setComposingText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(9950);
    beginBatchEdit();
    if (paramCharSequence.length() == 0) {}
    for (boolean bool = super.commitText(paramCharSequence, paramInt);; bool = super.setComposingText(paramCharSequence, paramInt))
    {
      endBatchEdit();
      AppMethodBeat.o(9950);
      return bool;
    }
  }
  
  public boolean setSelection(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9951);
    beginBatchEdit();
    boolean bool = super.setSelection(paramInt1, paramInt2);
    endBatchEdit();
    AppMethodBeat.o(9951);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.editing.InputConnectionAdaptor
 * JD-Core Version:    0.7.0.1
 */