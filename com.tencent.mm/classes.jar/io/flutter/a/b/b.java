package io.flutter.a.b;

import android.content.Context;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.Selection;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.c.g;
import io.flutter.embedding.engine.c.k;
import io.flutter.embedding.engine.c.k.a;
import io.flutter.embedding.engine.c.k.b;
import io.flutter.embedding.engine.c.k.c;
import io.flutter.embedding.engine.c.k.d;
import io.flutter.embedding.engine.c.k.e;
import io.flutter.embedding.engine.c.k.f;
import io.flutter.embedding.engine.dart.DartExecutor;

public final class b
{
  private final k IYp;
  public g IYq;
  Editable JbE;
  public final InputMethodManager JbG;
  public a JbH;
  k.a JbI;
  public boolean JbJ;
  public InputConnection JbK;
  public boolean JbL;
  public final View mView;
  
  public b(View paramView, DartExecutor paramDartExecutor, g paramg)
  {
    AppMethodBeat.i(9955);
    this.JbH = new a(b.a.a.JbO, 0);
    this.mView = paramView;
    this.JbG = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    this.IYp = new k(paramDartExecutor);
    this.IYp.JaE = new k.e()
    {
      public final void a(int paramAnonymousInt, k.a paramAnonymousa)
      {
        AppMethodBeat.i(9939);
        b localb = b.this;
        localb.JbH = new b.a(b.a.a.JbP, paramAnonymousInt);
        localb.JbI = paramAnonymousa;
        localb.JbE = Editable.Factory.getInstance().newEditable("");
        localb.JbJ = true;
        localb.JbL = false;
        AppMethodBeat.o(9939);
      }
      
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(9941);
        b localb = b.this;
        View localView = b.this.mView;
        if ((!localb.JbJ) && (paramAnonymousd.text.equals(localb.JbE.toString())))
        {
          localb.b(paramAnonymousd);
          localb.JbG.updateSelection(localb.mView, Math.max(Selection.getSelectionStart(localb.JbE), 0), Math.max(Selection.getSelectionEnd(localb.JbE), 0), BaseInputConnection.getComposingSpanStart(localb.JbE), BaseInputConnection.getComposingSpanEnd(localb.JbE));
          AppMethodBeat.o(9941);
          return;
        }
        localb.JbE.replace(0, localb.JbE.length(), paramAnonymousd.text);
        localb.b(paramAnonymousd);
        localb.JbG.restartInput(localView);
        localb.JbJ = false;
        AppMethodBeat.o(9941);
      }
      
      public final void adG(int paramAnonymousInt)
      {
        AppMethodBeat.i(9940);
        b localb = b.this;
        localb.mView.requestFocus();
        localb.JbH = new b.a(b.a.a.JbQ, paramAnonymousInt);
        localb.JbG.restartInput(localb.mView);
        localb.JbJ = false;
        AppMethodBeat.o(9940);
      }
      
      public final void fvc()
      {
        AppMethodBeat.i(9942);
        b localb = b.this;
        if (localb.JbH.JbN != b.a.a.JbQ)
        {
          localb.JbH = new b.a(b.a.a.JbO, 0);
          localb.JbL = false;
        }
        AppMethodBeat.o(9942);
      }
      
      public final void hide()
      {
        AppMethodBeat.i(9938);
        b.this.gK(b.this.mView);
        AppMethodBeat.o(9938);
      }
      
      public final void show()
      {
        AppMethodBeat.i(9937);
        b localb = b.this;
        View localView = b.this.mView;
        localView.requestFocus();
        localb.JbG.showSoftInput(localView, 0);
        AppMethodBeat.o(9937);
      }
    };
    this.IYq = paramg;
    this.IYq.IXb = this;
    AppMethodBeat.o(9955);
  }
  
  private static int a(k.b paramb, boolean paramBoolean1, boolean paramBoolean2, k.c paramc)
  {
    int i;
    if (paramb.JaN == k.f.JaW) {
      i = 4;
    }
    int j;
    label169:
    label187:
    do
    {
      do
      {
        return i;
        if (paramb.JaN != k.f.JaX) {
          break;
        }
        j = 2;
        if (paramb.JaO) {
          j = 4098;
        }
        i = j;
      } while (!paramb.JaP);
      return j | 0x2000;
      if (paramb.JaN == k.f.JaY) {
        return 3;
      }
      i = 1;
      if (paramb.JaN == k.f.JaZ)
      {
        i = 131073;
        if (!paramBoolean1) {
          break label169;
        }
        j = i | 0x80000 | 0x80;
      }
      for (;;)
      {
        if (paramc != k.c.JaQ) {
          break label187;
        }
        return j | 0x1000;
        if (paramb.JaN == k.f.Jba)
        {
          i = 33;
          break;
        }
        if (paramb.JaN == k.f.Jbb)
        {
          i = 17;
          break;
        }
        if (paramb.JaN != k.f.Jbc) {
          break;
        }
        i = 145;
        break;
        j = i;
        if (paramBoolean2) {
          j = i | 0x8000;
        }
      }
      if (paramc == k.c.JaR) {
        return j | 0x2000;
      }
      i = j;
    } while (paramc != k.c.JaS);
    return j | 0x4000;
  }
  
  public final InputConnection a(View paramView, EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9956);
    if (this.JbH.JbN == b.a.a.JbO)
    {
      this.JbK = null;
      AppMethodBeat.o(9956);
      return null;
    }
    if (this.JbH.JbN == b.a.a.JbQ)
    {
      if (this.JbL)
      {
        paramView = this.JbK;
        AppMethodBeat.o(9956);
        return paramView;
      }
      this.JbK = this.IYq.n(Integer.valueOf(this.JbH.id)).onCreateInputConnection(paramEditorInfo);
      paramView = this.JbK;
      AppMethodBeat.o(9956);
      return paramView;
    }
    paramEditorInfo.inputType = a(this.JbI.JaK, this.JbI.JaH, this.JbI.JaI, this.JbI.JaJ);
    paramEditorInfo.imeOptions = 33554432;
    int i;
    if (this.JbI.JaL == null) {
      if ((0x20000 & paramEditorInfo.inputType) != 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (this.JbI.JaM != null)
      {
        paramEditorInfo.actionLabel = this.JbI.JaM;
        paramEditorInfo.actionId = i;
      }
      paramEditorInfo.imeOptions = (i | paramEditorInfo.imeOptions);
      paramView = new a(paramView, this.JbH.id, this.IYp, this.JbE);
      paramEditorInfo.initialSelStart = Selection.getSelectionStart(this.JbE);
      paramEditorInfo.initialSelEnd = Selection.getSelectionEnd(this.JbE);
      this.JbK = paramView;
      paramView = this.JbK;
      AppMethodBeat.o(9956);
      return paramView;
      i = 6;
      continue;
      i = this.JbI.JaL.intValue();
    }
  }
  
  final void b(k.d paramd)
  {
    AppMethodBeat.i(9958);
    int i = paramd.selectionStart;
    int j = paramd.selectionEnd;
    if ((i >= 0) && (i <= this.JbE.length()) && (j >= 0) && (j <= this.JbE.length()))
    {
      Selection.setSelection(this.JbE, i, j);
      AppMethodBeat.o(9958);
      return;
    }
    Selection.removeSelection(this.JbE);
    AppMethodBeat.o(9958);
  }
  
  public final void gK(View paramView)
  {
    AppMethodBeat.i(9957);
    this.JbG.hideSoftInputFromWindow(paramView.getApplicationWindowToken(), 0);
    AppMethodBeat.o(9957);
  }
  
  public static final class a
  {
    public b.a.a JbN;
    public int id;
    
    public a(b.a.a parama, int paramInt)
    {
      this.JbN = parama;
      this.id = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.a.b.b
 * JD-Core Version:    0.7.0.1
 */