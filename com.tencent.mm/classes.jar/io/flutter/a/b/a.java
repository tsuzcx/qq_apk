package io.flutter.a.b;

import android.content.Context;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

final class a
  extends BaseInputConnection
{
  private final Layout Gce;
  private final io.flutter.embedding.engine.c.k IYp;
  private final View JbC;
  private final int JbD;
  private final Editable JbE;
  private int JbF;
  private InputMethodManager JbG;
  
  public a(View paramView, int paramInt, io.flutter.embedding.engine.c.k paramk, Editable paramEditable)
  {
    super(paramView, true);
    AppMethodBeat.i(9943);
    this.JbC = paramView;
    this.JbD = paramInt;
    this.IYp = paramk;
    this.JbE = paramEditable;
    this.JbF = 0;
    this.Gce = new DynamicLayout(this.JbE, new TextPaint(), 2147483647, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.JbG = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    AppMethodBeat.o(9943);
  }
  
  private static int a(int paramInt, Editable paramEditable)
  {
    AppMethodBeat.i(9952);
    int i = Math.max(0, Math.min(paramEditable.length(), paramInt));
    if (i != paramInt)
    {
      new StringBuilder("Text selection index was clamped (").append(paramInt).append("->").append(i).append(") to remain in bounds. This may not be your fault, as some keyboards may select outside of bounds.");
      io.flutter.a.ftT();
    }
    AppMethodBeat.o(9952);
    return i;
  }
  
  private void fvd()
  {
    AppMethodBeat.i(9944);
    if (this.JbF > 0)
    {
      AppMethodBeat.o(9944);
      return;
    }
    int i = Selection.getSelectionStart(this.JbE);
    int j = Selection.getSelectionEnd(this.JbE);
    int k = BaseInputConnection.getComposingSpanStart(this.JbE);
    int m = BaseInputConnection.getComposingSpanEnd(this.JbE);
    this.JbG.updateSelection(this.JbC, i, j, k, m);
    io.flutter.embedding.engine.c.k localk = this.IYp;
    int n = this.JbD;
    String str = this.JbE.toString();
    new StringBuilder("Sending message to update editing state: \nText: ").append(str).append("\nSelection start: ").append(i).append("\nSelection end: ").append(j).append("\nComposing start: ").append(k).append("\nComposing end: ").append(m);
    io.flutter.a.ftS();
    HashMap localHashMap = new HashMap();
    localHashMap.put("text", str);
    localHashMap.put("selectionBase", Integer.valueOf(i));
    localHashMap.put("selectionExtent", Integer.valueOf(j));
    localHashMap.put("composingBase", Integer.valueOf(k));
    localHashMap.put("composingExtent", Integer.valueOf(m));
    localk.sNT.a("TextInputClient.updateEditingState", Arrays.asList(new Serializable[] { Integer.valueOf(n), localHashMap }), null);
    AppMethodBeat.o(9944);
  }
  
  public final boolean beginBatchEdit()
  {
    AppMethodBeat.i(9945);
    this.JbF += 1;
    boolean bool = super.beginBatchEdit();
    AppMethodBeat.o(9945);
    return bool;
  }
  
  public final boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(9947);
    boolean bool = super.commitText(paramCharSequence, paramInt);
    fvd();
    AppMethodBeat.o(9947);
    return bool;
  }
  
  public final boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9948);
    if (Selection.getSelectionStart(this.JbE) == -1)
    {
      AppMethodBeat.o(9948);
      return true;
    }
    boolean bool = super.deleteSurroundingText(paramInt1, paramInt2);
    fvd();
    AppMethodBeat.o(9948);
    return bool;
  }
  
  public final boolean endBatchEdit()
  {
    AppMethodBeat.i(9946);
    boolean bool = super.endBatchEdit();
    this.JbF -= 1;
    fvd();
    AppMethodBeat.o(9946);
    return bool;
  }
  
  public final Editable getEditable()
  {
    return this.JbE;
  }
  
  public final boolean performEditorAction(int paramInt)
  {
    AppMethodBeat.i(9954);
    io.flutter.embedding.engine.c.k localk;
    switch (paramInt)
    {
    case 6: 
    default: 
      localk = this.IYp;
      paramInt = this.JbD;
      io.flutter.a.ftS();
      localk.sNT.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.done" }), null);
    }
    for (;;)
    {
      AppMethodBeat.o(9954);
      return true;
      localk = this.IYp;
      paramInt = this.JbD;
      io.flutter.a.ftS();
      localk.sNT.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.newline" }), null);
      continue;
      localk = this.IYp;
      paramInt = this.JbD;
      io.flutter.a.ftS();
      localk.sNT.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.unspecified" }), null);
      continue;
      localk = this.IYp;
      paramInt = this.JbD;
      io.flutter.a.ftS();
      localk.sNT.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.go" }), null);
      continue;
      localk = this.IYp;
      paramInt = this.JbD;
      io.flutter.a.ftS();
      localk.sNT.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.search" }), null);
      continue;
      localk = this.IYp;
      paramInt = this.JbD;
      io.flutter.a.ftS();
      localk.sNT.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.send" }), null);
      continue;
      localk = this.IYp;
      paramInt = this.JbD;
      io.flutter.a.ftS();
      localk.sNT.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.next" }), null);
      continue;
      localk = this.IYp;
      paramInt = this.JbD;
      io.flutter.a.ftS();
      localk.sNT.a("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.previous" }), null);
    }
  }
  
  public final boolean sendKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(9953);
    if (paramKeyEvent.getAction() == 0)
    {
      int j;
      if (paramKeyEvent.getKeyCode() == 67)
      {
        i = a(Selection.getSelectionStart(this.JbE), this.JbE);
        j = a(Selection.getSelectionEnd(this.JbE), this.JbE);
        if (j > i)
        {
          Selection.setSelection(this.JbE, i);
          this.JbE.delete(i, j);
          fvd();
          AppMethodBeat.o(9953);
          return true;
        }
        if (i <= 0) {
          break label403;
        }
        if (this.Gce.isRtlCharAt(this.Gce.getLineForOffset(i))) {}
        try
        {
          Selection.extendRight(this.JbE, this.Gce);
          for (;;)
          {
            i = a(Selection.getSelectionStart(this.JbE), this.JbE);
            j = a(Selection.getSelectionEnd(this.JbE), this.JbE);
            Selection.setSelection(this.JbE, Math.min(i, j));
            this.JbE.delete(Math.min(i, j), Math.max(i, j));
            fvd();
            AppMethodBeat.o(9953);
            return true;
            Selection.extendLeft(this.JbE, this.Gce);
          }
        }
        catch (IndexOutOfBoundsException paramKeyEvent)
        {
          for (;;)
          {
            Selection.setSelection(this.JbE, i, i - 1);
          }
        }
      }
      if (paramKeyEvent.getKeyCode() == 21)
      {
        i = Math.max(Selection.getSelectionStart(this.JbE) - 1, 0);
        setSelection(i, i);
        AppMethodBeat.o(9953);
        return true;
      }
      if (paramKeyEvent.getKeyCode() == 22)
      {
        i = Math.min(Selection.getSelectionStart(this.JbE) + 1, this.JbE.length());
        setSelection(i, i);
        AppMethodBeat.o(9953);
        return true;
      }
      int i = paramKeyEvent.getUnicodeChar();
      if (i != 0)
      {
        j = Math.max(0, Selection.getSelectionStart(this.JbE));
        int k = Math.max(0, Selection.getSelectionEnd(this.JbE));
        if (k != j) {
          this.JbE.delete(j, k);
        }
        this.JbE.insert(j, String.valueOf((char)i));
        setSelection(j + 1, j + 1);
        fvd();
      }
      AppMethodBeat.o(9953);
      return true;
    }
    label403:
    AppMethodBeat.o(9953);
    return false;
  }
  
  public final boolean setComposingRegion(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9949);
    boolean bool = super.setComposingRegion(paramInt1, paramInt2);
    fvd();
    AppMethodBeat.o(9949);
    return bool;
  }
  
  public final boolean setComposingText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(9950);
    if (paramCharSequence.length() == 0) {}
    for (boolean bool = super.commitText(paramCharSequence, paramInt);; bool = super.setComposingText(paramCharSequence, paramInt))
    {
      fvd();
      AppMethodBeat.o(9950);
      return bool;
    }
  }
  
  public final boolean setSelection(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9951);
    boolean bool = super.setSelection(paramInt1, paramInt2);
    fvd();
    AppMethodBeat.o(9951);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.a.b.a
 * JD-Core Version:    0.7.0.1
 */