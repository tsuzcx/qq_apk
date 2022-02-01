package io.flutter.plugin.b;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
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
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

final class a
  extends BaseInputConnection
{
  private final Layout JKx;
  private final io.flutter.embedding.engine.c.k MZw;
  private final int Ndj;
  private final Editable Ndk;
  private final EditorInfo Ndl;
  private int Ndm;
  private InputMethodManager Ndn;
  private final boolean Ndo;
  private final View vkY;
  
  public a(View paramView, int paramInt, io.flutter.embedding.engine.c.k paramk, Editable paramEditable, EditorInfo paramEditorInfo)
  {
    super(paramView, true);
    AppMethodBeat.i(197806);
    this.vkY = paramView;
    this.Ndj = paramInt;
    this.MZw = paramk;
    this.Ndk = paramEditable;
    this.Ndl = paramEditorInfo;
    this.Ndm = 0;
    this.JKx = new DynamicLayout(this.Ndk, new TextPaint(), 2147483647, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.Ndn = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    boolean bool1 = bool2;
    if (this.Ndn.getCurrentInputMethodSubtype() != null)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 21) {
        if (Build.MANUFACTURER.equals("samsung")) {
          break label145;
        }
      }
    }
    label145:
    for (bool1 = bool2;; bool1 = Settings.Secure.getString(this.vkY.getContext().getContentResolver(), "default_input_method").contains("Samsung"))
    {
      this.Ndo = bool1;
      AppMethodBeat.o(197806);
      return;
    }
  }
  
  private static int a(int paramInt, Editable paramEditable)
  {
    AppMethodBeat.i(9952);
    int i = Math.max(0, Math.min(paramEditable.length(), paramInt));
    if (i != paramInt)
    {
      new StringBuilder("Text selection index was clamped (").append(paramInt).append("->").append(i).append(") to remain in bounds. This may not be your fault, as some keyboards may select outside of bounds.");
      io.flutter.a.giF();
    }
    AppMethodBeat.o(9952);
    return i;
  }
  
  private void gjK()
  {
    AppMethodBeat.i(9944);
    if (this.Ndm > 0)
    {
      AppMethodBeat.o(9944);
      return;
    }
    int i = Selection.getSelectionStart(this.Ndk);
    int j = Selection.getSelectionEnd(this.Ndk);
    int k = BaseInputConnection.getComposingSpanStart(this.Ndk);
    int m = BaseInputConnection.getComposingSpanEnd(this.Ndk);
    this.Ndn.updateSelection(this.vkY, i, j, k, m);
    io.flutter.embedding.engine.c.k localk = this.MZw;
    int n = this.Ndj;
    String str = this.Ndk.toString();
    new StringBuilder("Sending message to update editing state: \nText: ").append(str).append("\nSelection start: ").append(i).append("\nSelection end: ").append(j).append("\nComposing start: ").append(k).append("\nComposing end: ").append(m);
    io.flutter.a.giD();
    HashMap localHashMap = new HashMap();
    localHashMap.put("text", str);
    localHashMap.put("selectionBase", Integer.valueOf(i));
    localHashMap.put("selectionExtent", Integer.valueOf(j));
    localHashMap.put("composingBase", Integer.valueOf(k));
    localHashMap.put("composingExtent", Integer.valueOf(m));
    localk.vOr.a("TextInputClient.updateEditingState", Arrays.asList(new Serializable[] { Integer.valueOf(n), localHashMap }), null);
    AppMethodBeat.o(9944);
  }
  
  public final boolean beginBatchEdit()
  {
    AppMethodBeat.i(9945);
    this.Ndm += 1;
    boolean bool = super.beginBatchEdit();
    AppMethodBeat.o(9945);
    return bool;
  }
  
  public final boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(9947);
    boolean bool = super.commitText(paramCharSequence, paramInt);
    gjK();
    AppMethodBeat.o(9947);
    return bool;
  }
  
  public final boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9948);
    if (Selection.getSelectionStart(this.Ndk) == -1)
    {
      AppMethodBeat.o(9948);
      return true;
    }
    boolean bool = super.deleteSurroundingText(paramInt1, paramInt2);
    gjK();
    AppMethodBeat.o(9948);
    return bool;
  }
  
  public final boolean endBatchEdit()
  {
    AppMethodBeat.i(9946);
    boolean bool = super.endBatchEdit();
    this.Ndm -= 1;
    gjK();
    AppMethodBeat.o(9946);
    return bool;
  }
  
  public final boolean finishComposingText()
  {
    AppMethodBeat.i(197807);
    boolean bool = super.finishComposingText();
    if ((this.Ndo) && (Build.VERSION.SDK_INT >= 21))
    {
      Object localObject = new CursorAnchorInfo.Builder();
      ((CursorAnchorInfo.Builder)localObject).setComposingText(-1, "");
      localObject = ((CursorAnchorInfo.Builder)localObject).build();
      this.Ndn.updateCursorAnchorInfo(this.vkY, (CursorAnchorInfo)localObject);
    }
    gjK();
    AppMethodBeat.o(197807);
    return bool;
  }
  
  public final Editable getEditable()
  {
    return this.Ndk;
  }
  
  public final boolean performContextMenuAction(int paramInt)
  {
    AppMethodBeat.i(197808);
    if (paramInt == 16908319)
    {
      setSelection(0, this.Ndk.length());
      AppMethodBeat.o(197808);
      return true;
    }
    int i;
    int j;
    Object localObject;
    if (paramInt == 16908320)
    {
      i = Selection.getSelectionStart(this.Ndk);
      j = Selection.getSelectionEnd(this.Ndk);
      if (i != j)
      {
        paramInt = Math.min(i, j);
        i = Math.max(i, j);
        localObject = this.Ndk.subSequence(paramInt, i);
        ((ClipboardManager)this.vkY.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", (CharSequence)localObject));
        this.Ndk.delete(paramInt, i);
        setSelection(paramInt, paramInt);
      }
      AppMethodBeat.o(197808);
      return true;
    }
    if (paramInt == 16908321)
    {
      paramInt = Selection.getSelectionStart(this.Ndk);
      i = Selection.getSelectionEnd(this.Ndk);
      if (paramInt != i)
      {
        localObject = this.Ndk.subSequence(Math.min(paramInt, i), Math.max(paramInt, i));
        ((ClipboardManager)this.vkY.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", (CharSequence)localObject));
      }
      AppMethodBeat.o(197808);
      return true;
    }
    if (paramInt == 16908322)
    {
      localObject = ((ClipboardManager)this.vkY.getContext().getSystemService("clipboard")).getPrimaryClip();
      if (localObject != null)
      {
        localObject = ((ClipData)localObject).getItemAt(0).coerceToText(this.vkY.getContext());
        i = Math.max(0, Selection.getSelectionStart(this.Ndk));
        j = Math.max(0, Selection.getSelectionEnd(this.Ndk));
        paramInt = Math.min(i, j);
        i = Math.max(i, j);
        if (paramInt != i) {
          this.Ndk.delete(paramInt, i);
        }
        this.Ndk.insert(paramInt, (CharSequence)localObject);
        paramInt = ((CharSequence)localObject).length() + paramInt;
        setSelection(paramInt, paramInt);
      }
      AppMethodBeat.o(197808);
      return true;
    }
    AppMethodBeat.o(197808);
    return false;
  }
  
  public final boolean performEditorAction(int paramInt)
  {
    AppMethodBeat.i(9954);
    io.flutter.embedding.engine.c.k localk;
    switch (paramInt)
    {
    case 6: 
    default: 
      localk = this.MZw;
      paramInt = this.Ndj;
      io.flutter.a.giD();
      localk.vOr.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.done" }), null);
    }
    for (;;)
    {
      AppMethodBeat.o(9954);
      return true;
      localk = this.MZw;
      paramInt = this.Ndj;
      io.flutter.a.giD();
      localk.vOr.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.newline" }), null);
      continue;
      localk = this.MZw;
      paramInt = this.Ndj;
      io.flutter.a.giD();
      localk.vOr.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.unspecified" }), null);
      continue;
      localk = this.MZw;
      paramInt = this.Ndj;
      io.flutter.a.giD();
      localk.vOr.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.go" }), null);
      continue;
      localk = this.MZw;
      paramInt = this.Ndj;
      io.flutter.a.giD();
      localk.vOr.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.search" }), null);
      continue;
      localk = this.MZw;
      paramInt = this.Ndj;
      io.flutter.a.giD();
      localk.vOr.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.send" }), null);
      continue;
      localk = this.MZw;
      paramInt = this.Ndj;
      io.flutter.a.giD();
      localk.vOr.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.next" }), null);
      continue;
      localk = this.MZw;
      paramInt = this.Ndj;
      io.flutter.a.giD();
      localk.vOr.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.previous" }), null);
    }
  }
  
  public final boolean sendKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(9953);
    int i;
    if (paramKeyEvent.getAction() == 0)
    {
      int j;
      if (paramKeyEvent.getKeyCode() == 67)
      {
        i = a(Selection.getSelectionStart(this.Ndk), this.Ndk);
        j = a(Selection.getSelectionEnd(this.Ndk), this.Ndk);
        if (j > i)
        {
          Selection.setSelection(this.Ndk, i);
          this.Ndk.delete(i, j);
          gjK();
          AppMethodBeat.o(9953);
          return true;
        }
        if (i <= 0) {
          break label762;
        }
        if (this.JKx.isRtlCharAt(this.JKx.getLineForOffset(i))) {}
        try
        {
          Selection.extendRight(this.Ndk, this.JKx);
          for (;;)
          {
            i = a(Selection.getSelectionStart(this.Ndk), this.Ndk);
            j = a(Selection.getSelectionEnd(this.Ndk), this.Ndk);
            Selection.setSelection(this.Ndk, Math.min(i, j));
            this.Ndk.delete(Math.min(i, j), Math.max(i, j));
            gjK();
            AppMethodBeat.o(9953);
            return true;
            Selection.extendLeft(this.Ndk, this.JKx);
          }
        }
        catch (IndexOutOfBoundsException paramKeyEvent)
        {
          for (;;)
          {
            Selection.setSelection(this.Ndk, i, i - 1);
          }
        }
      }
      if (paramKeyEvent.getKeyCode() == 21)
      {
        i = Selection.getSelectionStart(this.Ndk);
        j = Selection.getSelectionEnd(this.Ndk);
        if ((i == j) && (!paramKeyEvent.isShiftPressed()))
        {
          i = Math.max(i - 1, 0);
          setSelection(i, i);
        }
        for (;;)
        {
          AppMethodBeat.o(9953);
          return true;
          setSelection(i, Math.max(j - 1, 0));
        }
      }
      if (paramKeyEvent.getKeyCode() == 22)
      {
        i = Selection.getSelectionStart(this.Ndk);
        j = Selection.getSelectionEnd(this.Ndk);
        if ((i == j) && (!paramKeyEvent.isShiftPressed()))
        {
          i = Math.min(i + 1, this.Ndk.length());
          setSelection(i, i);
        }
        for (;;)
        {
          AppMethodBeat.o(9953);
          return true;
          setSelection(i, Math.min(j + 1, this.Ndk.length()));
        }
      }
      if (paramKeyEvent.getKeyCode() == 19)
      {
        if ((Selection.getSelectionStart(this.Ndk) == Selection.getSelectionEnd(this.Ndk)) && (!paramKeyEvent.isShiftPressed()))
        {
          Selection.moveUp(this.Ndk, this.JKx);
          i = Selection.getSelectionStart(this.Ndk);
          setSelection(i, i);
        }
        for (;;)
        {
          AppMethodBeat.o(9953);
          return true;
          Selection.extendUp(this.Ndk, this.JKx);
          setSelection(Selection.getSelectionStart(this.Ndk), Selection.getSelectionEnd(this.Ndk));
        }
      }
      if (paramKeyEvent.getKeyCode() == 20)
      {
        if ((Selection.getSelectionStart(this.Ndk) == Selection.getSelectionEnd(this.Ndk)) && (!paramKeyEvent.isShiftPressed()))
        {
          Selection.moveDown(this.Ndk, this.JKx);
          i = Selection.getSelectionStart(this.Ndk);
          setSelection(i, i);
        }
        for (;;)
        {
          AppMethodBeat.o(9953);
          return true;
          Selection.extendDown(this.Ndk, this.JKx);
          setSelection(Selection.getSelectionStart(this.Ndk), Selection.getSelectionEnd(this.Ndk));
        }
      }
      if (((paramKeyEvent.getKeyCode() == 66) || (paramKeyEvent.getKeyCode() == 160)) && ((0x20000 & this.Ndl.inputType) == 0))
      {
        performEditorAction(this.Ndl.imeOptions & 0xFF);
        AppMethodBeat.o(9953);
        return true;
      }
      i = paramKeyEvent.getUnicodeChar();
      if (i != 0)
      {
        int k = Math.max(0, Selection.getSelectionStart(this.Ndk));
        int m = Math.max(0, Selection.getSelectionEnd(this.Ndk));
        j = Math.min(k, m);
        k = Math.max(k, m);
        if (j != k) {
          this.Ndk.delete(j, k);
        }
        this.Ndk.insert(j, String.valueOf((char)i));
        setSelection(j + 1, j + 1);
      }
      AppMethodBeat.o(9953);
      return true;
    }
    label762:
    if ((paramKeyEvent.getAction() == 1) && ((paramKeyEvent.getKeyCode() == 59) || (paramKeyEvent.getKeyCode() == 60)))
    {
      i = Selection.getSelectionEnd(this.Ndk);
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
    gjK();
    AppMethodBeat.o(9949);
    return bool;
  }
  
  public final boolean setComposingText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(9950);
    if (paramCharSequence.length() == 0) {}
    for (boolean bool = super.commitText(paramCharSequence, paramInt);; bool = super.setComposingText(paramCharSequence, paramInt))
    {
      gjK();
      AppMethodBeat.o(9950);
      return bool;
    }
  }
  
  public final boolean setSelection(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9951);
    boolean bool = super.setSelection(paramInt1, paramInt2);
    gjK();
    AppMethodBeat.o(9951);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */