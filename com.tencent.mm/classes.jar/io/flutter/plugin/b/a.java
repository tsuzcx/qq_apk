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
  private final Layout JpI;
  private final io.flutter.embedding.engine.c.k MCr;
  private final View MGd;
  private final int MGe;
  private final Editable MGf;
  private final EditorInfo MGg;
  private int MGh;
  private InputMethodManager MGi;
  private final boolean MGj;
  
  public a(View paramView, int paramInt, io.flutter.embedding.engine.c.k paramk, Editable paramEditable, EditorInfo paramEditorInfo)
  {
    super(paramView, true);
    AppMethodBeat.i(213224);
    this.MGd = paramView;
    this.MGe = paramInt;
    this.MCr = paramk;
    this.MGf = paramEditable;
    this.MGg = paramEditorInfo;
    this.MGh = 0;
    this.JpI = new DynamicLayout(this.MGf, new TextPaint(), 2147483647, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.MGi = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    boolean bool1 = bool2;
    if (this.MGi.getCurrentInputMethodSubtype() != null)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 21) {
        if (Build.MANUFACTURER.equals("samsung")) {
          break label145;
        }
      }
    }
    label145:
    for (bool1 = bool2;; bool1 = Settings.Secure.getString(this.MGd.getContext().getContentResolver(), "default_input_method").contains("Samsung"))
    {
      this.MGj = bool1;
      AppMethodBeat.o(213224);
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
      io.flutter.a.gec();
    }
    AppMethodBeat.o(9952);
    return i;
  }
  
  private void gfi()
  {
    AppMethodBeat.i(9944);
    if (this.MGh > 0)
    {
      AppMethodBeat.o(9944);
      return;
    }
    int i = Selection.getSelectionStart(this.MGf);
    int j = Selection.getSelectionEnd(this.MGf);
    int k = BaseInputConnection.getComposingSpanStart(this.MGf);
    int m = BaseInputConnection.getComposingSpanEnd(this.MGf);
    this.MGi.updateSelection(this.MGd, i, j, k, m);
    io.flutter.embedding.engine.c.k localk = this.MCr;
    int n = this.MGe;
    String str = this.MGf.toString();
    new StringBuilder("Sending message to update editing state: \nText: ").append(str).append("\nSelection start: ").append(i).append("\nSelection end: ").append(j).append("\nComposing start: ").append(k).append("\nComposing end: ").append(m);
    io.flutter.a.gea();
    HashMap localHashMap = new HashMap();
    localHashMap.put("text", str);
    localHashMap.put("selectionBase", Integer.valueOf(i));
    localHashMap.put("selectionExtent", Integer.valueOf(j));
    localHashMap.put("composingBase", Integer.valueOf(k));
    localHashMap.put("composingExtent", Integer.valueOf(m));
    localk.vCn.a("TextInputClient.updateEditingState", Arrays.asList(new Serializable[] { Integer.valueOf(n), localHashMap }), null);
    AppMethodBeat.o(9944);
  }
  
  public final boolean beginBatchEdit()
  {
    AppMethodBeat.i(9945);
    this.MGh += 1;
    boolean bool = super.beginBatchEdit();
    AppMethodBeat.o(9945);
    return bool;
  }
  
  public final boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(9947);
    boolean bool = super.commitText(paramCharSequence, paramInt);
    gfi();
    AppMethodBeat.o(9947);
    return bool;
  }
  
  public final boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9948);
    if (Selection.getSelectionStart(this.MGf) == -1)
    {
      AppMethodBeat.o(9948);
      return true;
    }
    boolean bool = super.deleteSurroundingText(paramInt1, paramInt2);
    gfi();
    AppMethodBeat.o(9948);
    return bool;
  }
  
  public final boolean endBatchEdit()
  {
    AppMethodBeat.i(9946);
    boolean bool = super.endBatchEdit();
    this.MGh -= 1;
    gfi();
    AppMethodBeat.o(9946);
    return bool;
  }
  
  public final boolean finishComposingText()
  {
    AppMethodBeat.i(213225);
    boolean bool = super.finishComposingText();
    if ((this.MGj) && (Build.VERSION.SDK_INT >= 21))
    {
      Object localObject = new CursorAnchorInfo.Builder();
      ((CursorAnchorInfo.Builder)localObject).setComposingText(-1, "");
      localObject = ((CursorAnchorInfo.Builder)localObject).build();
      this.MGi.updateCursorAnchorInfo(this.MGd, (CursorAnchorInfo)localObject);
    }
    gfi();
    AppMethodBeat.o(213225);
    return bool;
  }
  
  public final Editable getEditable()
  {
    return this.MGf;
  }
  
  public final boolean performContextMenuAction(int paramInt)
  {
    AppMethodBeat.i(213226);
    if (paramInt == 16908319)
    {
      setSelection(0, this.MGf.length());
      AppMethodBeat.o(213226);
      return true;
    }
    int i;
    int j;
    Object localObject;
    if (paramInt == 16908320)
    {
      i = Selection.getSelectionStart(this.MGf);
      j = Selection.getSelectionEnd(this.MGf);
      if (i != j)
      {
        paramInt = Math.min(i, j);
        i = Math.max(i, j);
        localObject = this.MGf.subSequence(paramInt, i);
        ((ClipboardManager)this.MGd.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", (CharSequence)localObject));
        this.MGf.delete(paramInt, i);
        setSelection(paramInt, paramInt);
      }
      AppMethodBeat.o(213226);
      return true;
    }
    if (paramInt == 16908321)
    {
      paramInt = Selection.getSelectionStart(this.MGf);
      i = Selection.getSelectionEnd(this.MGf);
      if (paramInt != i)
      {
        localObject = this.MGf.subSequence(Math.min(paramInt, i), Math.max(paramInt, i));
        ((ClipboardManager)this.MGd.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", (CharSequence)localObject));
      }
      AppMethodBeat.o(213226);
      return true;
    }
    if (paramInt == 16908322)
    {
      localObject = ((ClipboardManager)this.MGd.getContext().getSystemService("clipboard")).getPrimaryClip();
      if (localObject != null)
      {
        localObject = ((ClipData)localObject).getItemAt(0).coerceToText(this.MGd.getContext());
        i = Math.max(0, Selection.getSelectionStart(this.MGf));
        j = Math.max(0, Selection.getSelectionEnd(this.MGf));
        paramInt = Math.min(i, j);
        i = Math.max(i, j);
        if (paramInt != i) {
          this.MGf.delete(paramInt, i);
        }
        this.MGf.insert(paramInt, (CharSequence)localObject);
        paramInt = ((CharSequence)localObject).length() + paramInt;
        setSelection(paramInt, paramInt);
      }
      AppMethodBeat.o(213226);
      return true;
    }
    AppMethodBeat.o(213226);
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
      localk = this.MCr;
      paramInt = this.MGe;
      io.flutter.a.gea();
      localk.vCn.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.done" }), null);
    }
    for (;;)
    {
      AppMethodBeat.o(9954);
      return true;
      localk = this.MCr;
      paramInt = this.MGe;
      io.flutter.a.gea();
      localk.vCn.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.newline" }), null);
      continue;
      localk = this.MCr;
      paramInt = this.MGe;
      io.flutter.a.gea();
      localk.vCn.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.unspecified" }), null);
      continue;
      localk = this.MCr;
      paramInt = this.MGe;
      io.flutter.a.gea();
      localk.vCn.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.go" }), null);
      continue;
      localk = this.MCr;
      paramInt = this.MGe;
      io.flutter.a.gea();
      localk.vCn.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.search" }), null);
      continue;
      localk = this.MCr;
      paramInt = this.MGe;
      io.flutter.a.gea();
      localk.vCn.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.send" }), null);
      continue;
      localk = this.MCr;
      paramInt = this.MGe;
      io.flutter.a.gea();
      localk.vCn.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.next" }), null);
      continue;
      localk = this.MCr;
      paramInt = this.MGe;
      io.flutter.a.gea();
      localk.vCn.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.previous" }), null);
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
        i = a(Selection.getSelectionStart(this.MGf), this.MGf);
        j = a(Selection.getSelectionEnd(this.MGf), this.MGf);
        if (j > i)
        {
          Selection.setSelection(this.MGf, i);
          this.MGf.delete(i, j);
          gfi();
          AppMethodBeat.o(9953);
          return true;
        }
        if (i <= 0) {
          break label762;
        }
        if (this.JpI.isRtlCharAt(this.JpI.getLineForOffset(i))) {}
        try
        {
          Selection.extendRight(this.MGf, this.JpI);
          for (;;)
          {
            i = a(Selection.getSelectionStart(this.MGf), this.MGf);
            j = a(Selection.getSelectionEnd(this.MGf), this.MGf);
            Selection.setSelection(this.MGf, Math.min(i, j));
            this.MGf.delete(Math.min(i, j), Math.max(i, j));
            gfi();
            AppMethodBeat.o(9953);
            return true;
            Selection.extendLeft(this.MGf, this.JpI);
          }
        }
        catch (IndexOutOfBoundsException paramKeyEvent)
        {
          for (;;)
          {
            Selection.setSelection(this.MGf, i, i - 1);
          }
        }
      }
      if (paramKeyEvent.getKeyCode() == 21)
      {
        i = Selection.getSelectionStart(this.MGf);
        j = Selection.getSelectionEnd(this.MGf);
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
        i = Selection.getSelectionStart(this.MGf);
        j = Selection.getSelectionEnd(this.MGf);
        if ((i == j) && (!paramKeyEvent.isShiftPressed()))
        {
          i = Math.min(i + 1, this.MGf.length());
          setSelection(i, i);
        }
        for (;;)
        {
          AppMethodBeat.o(9953);
          return true;
          setSelection(i, Math.min(j + 1, this.MGf.length()));
        }
      }
      if (paramKeyEvent.getKeyCode() == 19)
      {
        if ((Selection.getSelectionStart(this.MGf) == Selection.getSelectionEnd(this.MGf)) && (!paramKeyEvent.isShiftPressed()))
        {
          Selection.moveUp(this.MGf, this.JpI);
          i = Selection.getSelectionStart(this.MGf);
          setSelection(i, i);
        }
        for (;;)
        {
          AppMethodBeat.o(9953);
          return true;
          Selection.extendUp(this.MGf, this.JpI);
          setSelection(Selection.getSelectionStart(this.MGf), Selection.getSelectionEnd(this.MGf));
        }
      }
      if (paramKeyEvent.getKeyCode() == 20)
      {
        if ((Selection.getSelectionStart(this.MGf) == Selection.getSelectionEnd(this.MGf)) && (!paramKeyEvent.isShiftPressed()))
        {
          Selection.moveDown(this.MGf, this.JpI);
          i = Selection.getSelectionStart(this.MGf);
          setSelection(i, i);
        }
        for (;;)
        {
          AppMethodBeat.o(9953);
          return true;
          Selection.extendDown(this.MGf, this.JpI);
          setSelection(Selection.getSelectionStart(this.MGf), Selection.getSelectionEnd(this.MGf));
        }
      }
      if (((paramKeyEvent.getKeyCode() == 66) || (paramKeyEvent.getKeyCode() == 160)) && ((0x20000 & this.MGg.inputType) == 0))
      {
        performEditorAction(this.MGg.imeOptions & 0xFF);
        AppMethodBeat.o(9953);
        return true;
      }
      i = paramKeyEvent.getUnicodeChar();
      if (i != 0)
      {
        int k = Math.max(0, Selection.getSelectionStart(this.MGf));
        int m = Math.max(0, Selection.getSelectionEnd(this.MGf));
        j = Math.min(k, m);
        k = Math.max(k, m);
        if (j != k) {
          this.MGf.delete(j, k);
        }
        this.MGf.insert(j, String.valueOf((char)i));
        setSelection(j + 1, j + 1);
      }
      AppMethodBeat.o(9953);
      return true;
    }
    label762:
    if ((paramKeyEvent.getAction() == 1) && ((paramKeyEvent.getKeyCode() == 59) || (paramKeyEvent.getKeyCode() == 60)))
    {
      i = Selection.getSelectionEnd(this.MGf);
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
    gfi();
    AppMethodBeat.o(9949);
    return bool;
  }
  
  public final boolean setComposingText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(9950);
    if (paramCharSequence.length() == 0) {}
    for (boolean bool = super.commitText(paramCharSequence, paramInt);; bool = super.setComposingText(paramCharSequence, paramInt))
    {
      gfi();
      AppMethodBeat.o(9950);
      return bool;
    }
  }
  
  public final boolean setSelection(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9951);
    boolean bool = super.setSelection(paramInt1, paramInt2);
    gfi();
    AppMethodBeat.o(9951);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */