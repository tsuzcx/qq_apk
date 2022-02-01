package io.flutter.plugin.editing;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
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
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.b.m;
import io.flutter.plugin.a.k;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

final class b
  extends BaseInputConnection
  implements c.a
{
  private final Layout WoF;
  private ExtractedText Yje;
  private final m aaqg;
  private final int aauV;
  private final io.flutter.embedding.android.a aauW;
  private final c aauX;
  private final EditorInfo aauY;
  private ExtractedTextRequest aauZ;
  private boolean aava;
  private CursorAnchorInfo.Builder aavb;
  private InputMethodManager aavc;
  private a aavd;
  private final View cpg;
  
  public b(View paramView, int paramInt, m paramm, io.flutter.embedding.android.a parama, c paramc, EditorInfo paramEditorInfo)
  {
    this(paramView, paramInt, paramm, parama, paramc, paramEditorInfo, new FlutterJNI());
    AppMethodBeat.i(253692);
    AppMethodBeat.o(253692);
  }
  
  private b(View paramView, int paramInt, m paramm, io.flutter.embedding.android.a parama, c paramc, EditorInfo paramEditorInfo, FlutterJNI paramFlutterJNI)
  {
    super(paramView, true);
    AppMethodBeat.i(253691);
    this.aava = false;
    this.Yje = new ExtractedText();
    this.cpg = paramView;
    this.aauV = paramInt;
    this.aaqg = paramm;
    this.aauX = paramc;
    this.aauX.a(this);
    this.aauY = paramEditorInfo;
    this.aauW = parama;
    this.aavd = new a(paramFlutterJNI);
    this.WoF = new DynamicLayout(this.aauX, new TextPaint(), 2147483647, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.aavc = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    AppMethodBeat.o(253691);
  }
  
  private ExtractedText a(ExtractedTextRequest paramExtractedTextRequest)
  {
    AppMethodBeat.i(253693);
    this.Yje.startOffset = 0;
    this.Yje.partialStartOffset = -1;
    this.Yje.partialEndOffset = -1;
    this.Yje.selectionStart = Selection.getSelectionStart(this.aauX);
    this.Yje.selectionEnd = Selection.getSelectionEnd(this.aauX);
    ExtractedText localExtractedText = this.Yje;
    if ((paramExtractedTextRequest == null) || ((paramExtractedTextRequest.flags & 0x1) == 0)) {}
    for (paramExtractedTextRequest = this.aauX.toString();; paramExtractedTextRequest = this.aauX)
    {
      localExtractedText.text = paramExtractedTextRequest;
      paramExtractedTextRequest = this.Yje;
      AppMethodBeat.o(253693);
      return paramExtractedTextRequest;
    }
  }
  
  private CursorAnchorInfo iBp()
  {
    AppMethodBeat.i(253694);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(253694);
      return null;
    }
    if (this.aavb == null)
    {
      this.aavb = new CursorAnchorInfo.Builder();
      this.aavb.setSelectionRange(Selection.getSelectionStart(this.aauX), Selection.getSelectionEnd(this.aauX));
      int i = BaseInputConnection.getComposingSpanStart(this.aauX);
      int j = BaseInputConnection.getComposingSpanEnd(this.aauX);
      if ((i < 0) || (j <= i)) {
        break label131;
      }
      this.aavb.setComposingText(i, this.aauX.toString().subSequence(i, j));
    }
    for (;;)
    {
      CursorAnchorInfo localCursorAnchorInfo = this.aavb.build();
      AppMethodBeat.o(253694);
      return localCursorAnchorInfo;
      this.aavb.reset();
      break;
      label131:
      this.aavb.setComposingText(-1, "");
    }
  }
  
  public final void Je(boolean paramBoolean)
  {
    AppMethodBeat.i(253709);
    this.aavc.updateSelection(this.cpg, Selection.getSelectionStart(this.aauX), Selection.getSelectionEnd(this.aauX), BaseInputConnection.getComposingSpanStart(this.aauX), BaseInputConnection.getComposingSpanEnd(this.aauX));
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(253709);
      return;
    }
    if (this.aauZ != null) {
      this.aavc.updateExtractedText(this.cpg, this.aauZ.token, a(this.aauZ));
    }
    if (this.aava)
    {
      CursorAnchorInfo localCursorAnchorInfo = iBp();
      this.aavc.updateCursorAnchorInfo(this.cpg, localCursorAnchorInfo);
    }
    AppMethodBeat.o(253709);
  }
  
  public final boolean beginBatchEdit()
  {
    AppMethodBeat.i(9945);
    this.aauX.ian();
    boolean bool = super.beginBatchEdit();
    AppMethodBeat.o(9945);
    return bool;
  }
  
  public final boolean clearMetaKeyStates(int paramInt)
  {
    AppMethodBeat.i(253704);
    boolean bool = super.clearMetaKeyStates(paramInt);
    AppMethodBeat.o(253704);
    return bool;
  }
  
  public final void closeConnection()
  {
    AppMethodBeat.i(253705);
    super.closeConnection();
    this.aauX.b(this);
    AppMethodBeat.o(253705);
  }
  
  public final boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(9947);
    boolean bool = super.commitText(paramCharSequence, paramInt);
    AppMethodBeat.o(9947);
    return bool;
  }
  
  public final boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9948);
    if (Selection.getSelectionStart(this.aauX) == -1)
    {
      AppMethodBeat.o(9948);
      return true;
    }
    boolean bool = super.deleteSurroundingText(paramInt1, paramInt2);
    AppMethodBeat.o(9948);
    return bool;
  }
  
  public final boolean deleteSurroundingTextInCodePoints(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253697);
    boolean bool = super.deleteSurroundingTextInCodePoints(paramInt1, paramInt2);
    AppMethodBeat.o(253697);
    return bool;
  }
  
  public final boolean endBatchEdit()
  {
    AppMethodBeat.i(9946);
    boolean bool = super.endBatchEdit();
    this.aauX.iao();
    AppMethodBeat.o(9946);
    return bool;
  }
  
  public final boolean finishComposingText()
  {
    AppMethodBeat.i(253698);
    boolean bool = super.finishComposingText();
    AppMethodBeat.o(253698);
    return bool;
  }
  
  public final Editable getEditable()
  {
    return this.aauX;
  }
  
  public final ExtractedText getExtractedText(ExtractedTextRequest paramExtractedTextRequest, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(253700);
    if ((paramInt & 0x1) != 0)
    {
      paramInt = 1;
      if (this.aauZ != null) {
        break label92;
      }
      label23:
      if (paramInt == i)
      {
        StringBuilder localStringBuilder = new StringBuilder("The input method toggled text monitoring ");
        if (paramInt == 0) {
          break label97;
        }
        localObject = "on";
        label49:
        localStringBuilder.append((String)localObject);
        io.flutter.b.iAe();
      }
      if (paramInt == 0) {
        break label105;
      }
    }
    label92:
    label97:
    label105:
    for (Object localObject = paramExtractedTextRequest;; localObject = null)
    {
      this.aauZ = ((ExtractedTextRequest)localObject);
      paramExtractedTextRequest = a(paramExtractedTextRequest);
      AppMethodBeat.o(253700);
      return paramExtractedTextRequest;
      paramInt = 0;
      break;
      i = 0;
      break label23;
      localObject = "off";
      break label49;
    }
  }
  
  public final boolean performContextMenuAction(int paramInt)
  {
    AppMethodBeat.i(253707);
    beginBatchEdit();
    boolean bool;
    if (paramInt == 16908319)
    {
      setSelection(0, this.aauX.length());
      bool = true;
    }
    for (;;)
    {
      endBatchEdit();
      AppMethodBeat.o(253707);
      return bool;
      int i;
      int j;
      Object localObject;
      if (paramInt == 16908320)
      {
        i = Selection.getSelectionStart(this.aauX);
        j = Selection.getSelectionEnd(this.aauX);
        if (i != j)
        {
          paramInt = Math.min(i, j);
          i = Math.max(i, j);
          localObject = this.aauX.subSequence(paramInt, i);
          ((ClipboardManager)this.cpg.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", (CharSequence)localObject));
          this.aauX.delete(paramInt, i);
          setSelection(paramInt, paramInt);
        }
        bool = true;
      }
      else if (paramInt == 16908321)
      {
        paramInt = Selection.getSelectionStart(this.aauX);
        i = Selection.getSelectionEnd(this.aauX);
        if (paramInt != i)
        {
          localObject = this.aauX.subSequence(Math.min(paramInt, i), Math.max(paramInt, i));
          ((ClipboardManager)this.cpg.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", (CharSequence)localObject));
        }
        bool = true;
      }
      else if (paramInt == 16908322)
      {
        localObject = ((ClipboardManager)this.cpg.getContext().getSystemService("clipboard")).getPrimaryClip();
        if (localObject != null)
        {
          localObject = ((ClipData)localObject).getItemAt(0).coerceToText(this.cpg.getContext());
          i = Math.max(0, Selection.getSelectionStart(this.aauX));
          j = Math.max(0, Selection.getSelectionEnd(this.aauX));
          paramInt = Math.min(i, j);
          i = Math.max(i, j);
          if (paramInt != i) {
            this.aauX.delete(paramInt, i);
          }
          this.aauX.insert(paramInt, (CharSequence)localObject);
          paramInt = ((CharSequence)localObject).length() + paramInt;
          setSelection(paramInt, paramInt);
        }
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final boolean performEditorAction(int paramInt)
  {
    AppMethodBeat.i(9954);
    m localm;
    switch (paramInt)
    {
    case 6: 
    default: 
      localm = this.aaqg;
      paramInt = this.aauV;
      io.flutter.b.iAd();
      localm.aKT.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.done" }), null);
    }
    for (;;)
    {
      AppMethodBeat.o(9954);
      return true;
      localm = this.aaqg;
      paramInt = this.aauV;
      io.flutter.b.iAd();
      localm.aKT.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.newline" }), null);
      continue;
      localm = this.aaqg;
      paramInt = this.aauV;
      io.flutter.b.iAd();
      localm.aKT.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.unspecified" }), null);
      continue;
      localm = this.aaqg;
      paramInt = this.aauV;
      io.flutter.b.iAd();
      localm.aKT.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.go" }), null);
      continue;
      localm = this.aaqg;
      paramInt = this.aauV;
      io.flutter.b.iAd();
      localm.aKT.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.search" }), null);
      continue;
      localm = this.aaqg;
      paramInt = this.aauV;
      io.flutter.b.iAd();
      localm.aKT.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.send" }), null);
      continue;
      localm = this.aaqg;
      paramInt = this.aauV;
      io.flutter.b.iAd();
      localm.aKT.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.next" }), null);
      continue;
      localm = this.aaqg;
      paramInt = this.aauV;
      io.flutter.b.iAd();
      localm.aKT.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.previous" }), null);
    }
  }
  
  public final boolean performPrivateCommand(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(253708);
    m localm = this.aaqg;
    int i = this.aauV;
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", paramString);
    if (paramBundle != null)
    {
      paramString = new HashMap();
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramBundle.get(str);
        if ((localObject instanceof byte[])) {
          paramString.put(str, paramBundle.getByteArray(str));
        } else if ((localObject instanceof Byte)) {
          paramString.put(str, Byte.valueOf(paramBundle.getByte(str)));
        } else if ((localObject instanceof char[])) {
          paramString.put(str, paramBundle.getCharArray(str));
        } else if ((localObject instanceof Character)) {
          paramString.put(str, Character.valueOf(paramBundle.getChar(str)));
        } else if ((localObject instanceof CharSequence[])) {
          paramString.put(str, paramBundle.getCharSequenceArray(str));
        } else if ((localObject instanceof CharSequence)) {
          paramString.put(str, paramBundle.getCharSequence(str));
        } else if ((localObject instanceof float[])) {
          paramString.put(str, paramBundle.getFloatArray(str));
        } else if ((localObject instanceof Float)) {
          paramString.put(str, Float.valueOf(paramBundle.getFloat(str)));
        }
      }
      localHashMap.put("data", paramString);
    }
    localm.aKT.a("TextInputClient.performPrivateCommand", Arrays.asList(new Serializable[] { Integer.valueOf(i), localHashMap }), null);
    AppMethodBeat.o(253708);
    return true;
  }
  
  public final boolean requestCursorUpdates(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(253703);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(253703);
      return false;
    }
    if ((paramInt & 0x1) != 0) {
      this.aavc.updateCursorAnchorInfo(this.cpg, iBp());
    }
    if ((paramInt & 0x2) != 0) {
      bool = true;
    }
    StringBuilder localStringBuilder;
    if (bool != this.aava)
    {
      localStringBuilder = new StringBuilder("The input method toggled cursor monitoring ");
      if (!bool) {
        break label104;
      }
    }
    label104:
    for (String str = "on";; str = "off")
    {
      localStringBuilder.append(str);
      io.flutter.b.iAe();
      this.aava = bool;
      AppMethodBeat.o(253703);
      return true;
    }
  }
  
  public final boolean sendKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(9953);
    if ((this.aauW != null) && (!this.aauW.k(paramKeyEvent)) && (this.aauW.j(paramKeyEvent)))
    {
      AppMethodBeat.o(9953);
      return true;
    }
    int i;
    if (paramKeyEvent.getAction() == 0)
    {
      if (paramKeyEvent.getKeyCode() == 21)
      {
        i = Selection.getSelectionStart(this.aauX);
        j = Selection.getSelectionEnd(this.aauX);
        if ((i == j) && (!paramKeyEvent.isShiftPressed()))
        {
          i = Math.max(this.aavd.r(this.aauX, i), 0);
          setSelection(i, i);
        }
        for (;;)
        {
          AppMethodBeat.o(9953);
          return true;
          setSelection(i, Math.max(this.aavd.r(this.aauX, j), 0));
        }
      }
      if (paramKeyEvent.getKeyCode() == 22)
      {
        i = Selection.getSelectionStart(this.aauX);
        j = Selection.getSelectionEnd(this.aauX);
        if ((i == j) && (!paramKeyEvent.isShiftPressed()))
        {
          i = Math.min(this.aavd.s(this.aauX, i), this.aauX.length());
          setSelection(i, i);
        }
        for (;;)
        {
          AppMethodBeat.o(9953);
          return true;
          setSelection(i, Math.min(this.aavd.s(this.aauX, j), this.aauX.length()));
        }
      }
      if (paramKeyEvent.getKeyCode() == 19)
      {
        if ((Selection.getSelectionStart(this.aauX) == Selection.getSelectionEnd(this.aauX)) && (!paramKeyEvent.isShiftPressed()))
        {
          Selection.moveUp(this.aauX, this.WoF);
          i = Selection.getSelectionStart(this.aauX);
          setSelection(i, i);
        }
        for (;;)
        {
          AppMethodBeat.o(9953);
          return true;
          Selection.extendUp(this.aauX, this.WoF);
          setSelection(Selection.getSelectionStart(this.aauX), Selection.getSelectionEnd(this.aauX));
        }
      }
      if (paramKeyEvent.getKeyCode() == 20)
      {
        if ((Selection.getSelectionStart(this.aauX) == Selection.getSelectionEnd(this.aauX)) && (!paramKeyEvent.isShiftPressed()))
        {
          Selection.moveDown(this.aauX, this.WoF);
          i = Selection.getSelectionStart(this.aauX);
          setSelection(i, i);
        }
        for (;;)
        {
          AppMethodBeat.o(9953);
          return true;
          Selection.extendDown(this.aauX, this.WoF);
          setSelection(Selection.getSelectionStart(this.aauX), Selection.getSelectionEnd(this.aauX));
        }
      }
      if (((paramKeyEvent.getKeyCode() == 66) || (paramKeyEvent.getKeyCode() == 160)) && ((0x20000 & this.aauY.inputType) == 0))
      {
        performEditorAction(this.aauY.imeOptions & 0xFF);
        AppMethodBeat.o(9953);
        return true;
      }
      i = paramKeyEvent.getUnicodeChar();
      if (i == 0)
      {
        AppMethodBeat.o(9953);
        return false;
      }
      int k = Math.max(0, Selection.getSelectionStart(this.aauX));
      int m = Math.max(0, Selection.getSelectionEnd(this.aauX));
      int j = Math.min(k, m);
      k = Math.max(k, m);
      if (j != k) {
        this.aauX.delete(j, k);
      }
      this.aauX.insert(j, String.valueOf((char)i));
      setSelection(j + 1, j + 1);
      AppMethodBeat.o(9953);
      return true;
    }
    if ((paramKeyEvent.getAction() == 1) && ((paramKeyEvent.getKeyCode() == 59) || (paramKeyEvent.getKeyCode() == 60)))
    {
      i = Selection.getSelectionEnd(this.aauX);
      setSelection(i, i);
      AppMethodBeat.o(9953);
      return true;
    }
    AppMethodBeat.o(9953);
    return false;
  }
  
  public final boolean setComposingRegion(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9949);
    boolean bool = super.setComposingRegion(paramInt1, paramInt2);
    AppMethodBeat.o(9949);
    return bool;
  }
  
  public final boolean setComposingText(CharSequence paramCharSequence, int paramInt)
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
  
  public final boolean setSelection(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9951);
    beginBatchEdit();
    boolean bool = super.setSelection(paramInt1, paramInt2);
    endBatchEdit();
    AppMethodBeat.o(9951);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.editing.b
 * JD-Core Version:    0.7.0.1
 */