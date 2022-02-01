package io.flutter.plugin.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.Selection;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.c.k.a;
import io.flutter.embedding.engine.c.k.b;
import io.flutter.embedding.engine.c.k.c;
import io.flutter.embedding.engine.c.k.d;
import io.flutter.embedding.engine.c.k.e;
import io.flutter.embedding.engine.c.k.f;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.platform.h;

public final class b
{
  private final io.flutter.embedding.engine.c.k KLu;
  public h KLv;
  Editable KPi;
  public final InputMethodManager KPk;
  public a KPl;
  k.a KPm;
  public boolean KPn;
  public InputConnection KPo;
  final boolean KPp;
  public boolean KPq;
  public final View mView;
  
  public b(View paramView, DartExecutor paramDartExecutor, h paramh)
  {
    AppMethodBeat.i(9955);
    this.KPl = new a(b.a.a.KPt, 0);
    this.mView = paramView;
    this.KPk = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    this.KLu = new io.flutter.embedding.engine.c.k(paramDartExecutor);
    this.KLu.KOh = new k.e()
    {
      public final void a(int paramAnonymousInt, k.a paramAnonymousa)
      {
        AppMethodBeat.i(9939);
        b localb = b.this;
        localb.KPl = new b.a(b.a.a.KPu, paramAnonymousInt);
        localb.KPm = paramAnonymousa;
        localb.KPi = Editable.Factory.getInstance().newEditable("");
        localb.KPn = true;
        localb.KPq = false;
        AppMethodBeat.o(9939);
      }
      
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(9941);
        b localb = b.this;
        View localView = b.this.mView;
        if ((!localb.KPp) && (!localb.KPn) && (paramAnonymousd.text.equals(localb.KPi.toString())))
        {
          localb.b(paramAnonymousd);
          localb.KPk.updateSelection(localb.mView, Math.max(Selection.getSelectionStart(localb.KPi), 0), Math.max(Selection.getSelectionEnd(localb.KPi), 0), BaseInputConnection.getComposingSpanStart(localb.KPi), BaseInputConnection.getComposingSpanEnd(localb.KPi));
          AppMethodBeat.o(9941);
          return;
        }
        localb.KPi.replace(0, localb.KPi.length(), paramAnonymousd.text);
        localb.b(paramAnonymousd);
        localb.KPk.restartInput(localView);
        localb.KPn = false;
        AppMethodBeat.o(9941);
      }
      
      public final void agB(int paramAnonymousInt)
      {
        AppMethodBeat.i(9940);
        b localb = b.this;
        localb.mView.requestFocus();
        localb.KPl = new b.a(b.a.a.KPv, paramAnonymousInt);
        localb.KPk.restartInput(localb.mView);
        localb.KPn = false;
        AppMethodBeat.o(9940);
      }
      
      public final void fNI()
      {
        AppMethodBeat.i(9942);
        b localb = b.this;
        if (localb.KPl.KPs != b.a.a.KPv)
        {
          localb.KPl = new b.a(b.a.a.KPt, 0);
          localb.KPq = false;
        }
        AppMethodBeat.o(9942);
      }
      
      public final void hide()
      {
        AppMethodBeat.i(9938);
        b.this.hc(b.this.mView);
        AppMethodBeat.o(9938);
      }
      
      public final void show()
      {
        AppMethodBeat.i(9937);
        b localb = b.this;
        View localView = b.this.mView;
        localView.requestFocus();
        localb.KPk.showSoftInput(localView, 0);
        AppMethodBeat.o(9937);
      }
    };
    this.KLu.uzK.a("TextInputClient.requestExistingInputState", null, null);
    this.KLv = paramh;
    this.KLv.KKm = this;
    if ((this.KPk.getCurrentInputMethodSubtype() == null) || (Build.VERSION.SDK_INT < 21) || (!Build.MANUFACTURER.equals("samsung"))) {}
    for (boolean bool = false;; bool = Settings.Secure.getString(this.mView.getContext().getContentResolver(), "default_input_method").contains("Samsung"))
    {
      this.KPp = bool;
      AppMethodBeat.o(9955);
      return;
    }
  }
  
  private static int a(k.b paramb, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, k.c paramc)
  {
    int j;
    if (paramb.KOr == k.f.KOA) {
      j = 4;
    }
    int i;
    label170:
    label203:
    do
    {
      do
      {
        return j;
        if (paramb.KOr != k.f.KOB) {
          break;
        }
        i = 2;
        if (paramb.KOs) {
          i = 4098;
        }
        j = i;
      } while (!paramb.KOt);
      return i | 0x2000;
      if (paramb.KOr == k.f.KOC) {
        return 3;
      }
      i = 1;
      if (paramb.KOr == k.f.KOD)
      {
        i = 131073;
        if (!paramBoolean1) {
          break label170;
        }
        i = i | 0x80000 | 0x80;
      }
      for (;;)
      {
        if (paramc != k.c.KOu) {
          break label203;
        }
        return i | 0x1000;
        if (paramb.KOr == k.f.KOE)
        {
          i = 33;
          break;
        }
        if (paramb.KOr == k.f.KOF)
        {
          i = 17;
          break;
        }
        if (paramb.KOr != k.f.KOG) {
          break;
        }
        i = 145;
        break;
        j = i;
        if (paramBoolean2) {
          j = i | 0x8000;
        }
        i = j;
        if (!paramBoolean3) {
          i = j | 0x80000;
        }
      }
      if (paramc == k.c.KOv) {
        return i | 0x2000;
      }
      j = i;
    } while (paramc != k.c.KOw);
    return i | 0x4000;
  }
  
  public final InputConnection a(View paramView, EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9956);
    if (this.KPl.KPs == b.a.a.KPt)
    {
      this.KPo = null;
      AppMethodBeat.o(9956);
      return null;
    }
    if (this.KPl.KPs == b.a.a.KPv)
    {
      if (this.KPq)
      {
        paramView = this.KPo;
        AppMethodBeat.o(9956);
        return paramView;
      }
      this.KPo = this.KLv.o(Integer.valueOf(this.KPl.id)).onCreateInputConnection(paramEditorInfo);
      paramView = this.KPo;
      AppMethodBeat.o(9956);
      return paramView;
    }
    paramEditorInfo.inputType = a(this.KPm.KOo, this.KPm.KOk, this.KPm.KOl, this.KPm.KOm, this.KPm.KOn);
    paramEditorInfo.imeOptions = 33554432;
    int i;
    if (this.KPm.KOp == null) {
      if ((0x20000 & paramEditorInfo.inputType) != 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (this.KPm.KOq != null)
      {
        paramEditorInfo.actionLabel = this.KPm.KOq;
        paramEditorInfo.actionId = i;
      }
      paramEditorInfo.imeOptions = (i | paramEditorInfo.imeOptions);
      paramView = new a(paramView, this.KPl.id, this.KLu, this.KPi);
      paramEditorInfo.initialSelStart = Selection.getSelectionStart(this.KPi);
      paramEditorInfo.initialSelEnd = Selection.getSelectionEnd(this.KPi);
      this.KPo = paramView;
      paramView = this.KPo;
      AppMethodBeat.o(9956);
      return paramView;
      i = 6;
      continue;
      i = this.KPm.KOp.intValue();
    }
  }
  
  final void b(k.d paramd)
  {
    AppMethodBeat.i(9958);
    int i = paramd.selectionStart;
    int j = paramd.selectionEnd;
    if ((i >= 0) && (i <= this.KPi.length()) && (j >= 0) && (j <= this.KPi.length()))
    {
      Selection.setSelection(this.KPi, i, j);
      AppMethodBeat.o(9958);
      return;
    }
    Selection.removeSelection(this.KPi);
    AppMethodBeat.o(9958);
  }
  
  public final void hc(View paramView)
  {
    AppMethodBeat.i(9957);
    this.KPk.hideSoftInputFromWindow(paramView.getApplicationWindowToken(), 0);
    AppMethodBeat.o(9957);
  }
  
  public static final class a
  {
    public b.a.a KPs;
    public int id;
    
    public a(b.a.a parama, int paramInt)
    {
      this.KPs = parama;
      this.id = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.b.b
 * JD-Core Version:    0.7.0.1
 */