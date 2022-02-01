package io.flutter.plugin.editing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.Selection;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets.Type;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.android.a;
import io.flutter.embedding.engine.b.m;
import io.flutter.embedding.engine.b.m.a;
import io.flutter.embedding.engine.b.m.a.a;
import io.flutter.embedding.engine.b.m.b;
import io.flutter.embedding.engine.b.m.c;
import io.flutter.embedding.engine.b.m.d;
import io.flutter.embedding.engine.b.m.e;
import io.flutter.embedding.engine.b.m.f;
import io.flutter.plugin.a.k;
import io.flutter.plugin.platform.PlatformViewsController;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

public final class d
  implements c.a
{
  private final m aaqg;
  public a aauW;
  c aauX;
  public boolean aavA;
  public final InputMethodManager aavc;
  final AutofillManager aavq;
  public a aavr;
  m.a aavs;
  private SparseArray<m.a> aavt;
  public boolean aavu;
  public InputConnection aavv;
  Rect aavw;
  private final boolean aavx;
  private ImeSyncDeferringInsetsCallback aavy;
  private m.d aavz;
  public final View mView;
  private PlatformViewsController platformViewsController;
  
  @SuppressLint({"NewApi"})
  public d(View paramView, m paramm, PlatformViewsController paramPlatformViewsController)
  {
    AppMethodBeat.i(254164);
    this.aavr = new a(d.a.a.aavG, 0);
    this.mView = paramView;
    this.aavc = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.aavq = ((AutofillManager)paramView.getContext().getSystemService(AutofillManager.class));
      if (Build.VERSION.SDK_INT >= 30) {
        if ((this.mView.getWindowSystemUiVisibility() & 0x2) != 0) {
          break label274;
        }
      }
    }
    label274:
    for (int i = WindowInsets.Type.navigationBars() | 0x0;; i = 0)
    {
      int j = i;
      if ((this.mView.getWindowSystemUiVisibility() & 0x4) == 0) {
        j = i | WindowInsets.Type.statusBars();
      }
      this.aavy = new ImeSyncDeferringInsetsCallback(paramView, j, WindowInsets.Type.ime());
      this.aavy.install();
      this.aaqg = paramm;
      paramm.aatN = new m.e()
      {
        public final void Jd(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(255786);
          if ((Build.VERSION.SDK_INT < 26) || (d.this.aavq == null))
          {
            AppMethodBeat.o(255786);
            return;
          }
          if (paramAnonymousBoolean)
          {
            d.this.aavq.commit();
            AppMethodBeat.o(255786);
            return;
          }
          d.this.aavq.cancel();
          AppMethodBeat.o(255786);
        }
        
        public final void a(double paramAnonymousDouble1, double paramAnonymousDouble2, double[] paramAnonymousArrayOfDouble)
        {
          AppMethodBeat.i(255794);
          d locald = d.this;
          double[] arrayOfDouble = new double[4];
          if ((paramAnonymousArrayOfDouble[3] == 0.0D) && (paramAnonymousArrayOfDouble[7] == 0.0D) && (paramAnonymousArrayOfDouble[15] == 1.0D)) {}
          for (boolean bool = true;; bool = false)
          {
            double d = paramAnonymousArrayOfDouble[12] / paramAnonymousArrayOfDouble[15];
            arrayOfDouble[1] = d;
            arrayOfDouble[0] = d;
            d = paramAnonymousArrayOfDouble[13] / paramAnonymousArrayOfDouble[15];
            arrayOfDouble[3] = d;
            arrayOfDouble[2] = d;
            paramAnonymousArrayOfDouble = new d.2(locald, bool, paramAnonymousArrayOfDouble, arrayOfDouble);
            paramAnonymousArrayOfDouble.u(paramAnonymousDouble1, 0.0D);
            paramAnonymousArrayOfDouble.u(paramAnonymousDouble1, paramAnonymousDouble2);
            paramAnonymousArrayOfDouble.u(0.0D, paramAnonymousDouble2);
            paramAnonymousArrayOfDouble = Float.valueOf(locald.mView.getContext().getResources().getDisplayMetrics().density);
            locald.aavw = new Rect((int)(arrayOfDouble[0] * paramAnonymousArrayOfDouble.floatValue()), (int)(arrayOfDouble[2] * paramAnonymousArrayOfDouble.floatValue()), (int)Math.ceil(arrayOfDouble[1] * paramAnonymousArrayOfDouble.floatValue()), (int)Math.ceil(arrayOfDouble[3] * paramAnonymousArrayOfDouble.floatValue()));
            AppMethodBeat.o(255794);
            return;
          }
        }
        
        public final void a(int paramAnonymousInt, m.a paramAnonymousa)
        {
          AppMethodBeat.i(9939);
          d locald1 = d.this;
          locald1.iBr();
          locald1.aavr = new d.a(d.a.a.aavH, paramAnonymousInt);
          if (locald1.aauX != null) {
            locald1.aauX.b(locald1);
          }
          if (paramAnonymousa.aatW != null) {}
          for (m.d locald = paramAnonymousa.aatW.aaua;; locald = null)
          {
            locald1.aauX = new c(locald, locald1.mView);
            locald1.aavs = paramAnonymousa;
            locald1.a(paramAnonymousa);
            locald1.aavu = true;
            locald1.aavA = false;
            locald1.aavw = null;
            locald1.aauX.a(locald1);
            AppMethodBeat.o(9939);
            return;
          }
        }
        
        public final void a(m.d paramAnonymousd)
        {
          AppMethodBeat.i(9941);
          d.this.a(d.this.mView, paramAnonymousd);
          AppMethodBeat.o(9941);
        }
        
        public final void aDr(int paramAnonymousInt)
        {
          AppMethodBeat.i(9940);
          d locald = d.this;
          locald.mView.requestFocus();
          locald.aavr = new d.a(d.a.a.aavI, paramAnonymousInt);
          locald.aavc.restartInput(locald.mView);
          locald.aavu = false;
          AppMethodBeat.o(9940);
        }
        
        public final void hide()
        {
          AppMethodBeat.i(9938);
          d.this.jl(d.this.mView);
          AppMethodBeat.o(9938);
        }
        
        public final void iBm()
        {
          AppMethodBeat.i(255784);
          d locald = d.this;
          if ((Build.VERSION.SDK_INT < 26) || (locald.aavq == null) || (!locald.iBq()))
          {
            AppMethodBeat.o(255784);
            return;
          }
          String str = locald.aavs.aatW.aatY;
          int[] arrayOfInt = new int[2];
          locald.mView.getLocationOnScreen(arrayOfInt);
          Rect localRect = new Rect(locald.aavw);
          localRect.offset(arrayOfInt[0], arrayOfInt[1]);
          locald.aavq.notifyViewEntered(locald.mView, str.hashCode(), localRect);
          AppMethodBeat.o(255784);
        }
        
        public final void iBn()
        {
          AppMethodBeat.i(9942);
          d locald = d.this;
          if (locald.aavr.aavF != d.a.a.aavI)
          {
            locald.aauX.b(locald);
            locald.iBr();
            locald.a(null);
            locald.aavr = new d.a(d.a.a.aavG, 0);
            locald.aavA = false;
            locald.aavw = null;
          }
          AppMethodBeat.o(9942);
        }
        
        public final void show()
        {
          AppMethodBeat.i(9937);
          d locald = d.this;
          View localView = d.this.mView;
          localView.requestFocus();
          locald.aavc.showSoftInput(localView, 0);
          AppMethodBeat.o(9937);
        }
        
        public final void x(String paramAnonymousString, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(255796);
          d locald = d.this;
          locald.aavc.sendAppPrivateCommand(locald.mView, paramAnonymousString, paramAnonymousBundle);
          AppMethodBeat.o(255796);
        }
      };
      paramm.aKT.a("TextInputClient.requestExistingInputState", null, null);
      this.platformViewsController = paramPlatformViewsController;
      this.platformViewsController.aaoo = this;
      boolean bool1 = bool2;
      if (this.aavc.getCurrentInputMethodSubtype() != null)
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT >= 21) {
          if (Build.MANUFACTURER.equals("samsung")) {
            break label249;
          }
        }
      }
      label249:
      for (bool1 = bool2;; bool1 = Settings.Secure.getString(this.mView.getContext().getContentResolver(), "default_input_method").contains("Samsung"))
      {
        this.aavx = bool1;
        AppMethodBeat.o(254164);
        return;
        this.aavq = null;
        break;
      }
    }
  }
  
  private static int a(m.b paramb, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, m.c paramc)
  {
    int j;
    if (paramb.aaub == m.f.aauo) {
      j = 4;
    }
    int i;
    label204:
    label238:
    do
    {
      do
      {
        return j;
        if (paramb.aaub != m.f.aaur) {
          break;
        }
        i = 2;
        if (paramb.aauc) {
          i = 4098;
        }
        j = i;
      } while (!paramb.aaud);
      return i | 0x2000;
      if (paramb.aaub == m.f.aaus) {
        return 3;
      }
      i = 1;
      if (paramb.aaub == m.f.aaut)
      {
        i = 131073;
        if (!paramBoolean1) {
          break label204;
        }
        i = i | 0x80000 | 0x80;
      }
      for (;;)
      {
        if (paramc != m.c.aaue) {
          break label238;
        }
        return i | 0x1000;
        if (paramb.aaub == m.f.aauu)
        {
          i = 33;
          break;
        }
        if (paramb.aaub == m.f.aauv)
        {
          i = 17;
          break;
        }
        if (paramb.aaub == m.f.aauw)
        {
          i = 145;
          break;
        }
        if (paramb.aaub == m.f.aaup)
        {
          i = 97;
          break;
        }
        if (paramb.aaub != m.f.aauq) {
          break;
        }
        i = 113;
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
      if (paramc == m.c.aauf) {
        return i | 0x2000;
      }
      j = i;
    } while (paramc != m.c.aaug);
    return i | 0x4000;
  }
  
  public final void Je(boolean paramBoolean)
  {
    AppMethodBeat.i(254170);
    Object localObject1;
    int j;
    int k;
    int m;
    int n;
    if (paramBoolean)
    {
      localObject1 = this.aauX.toString();
      if ((Build.VERSION.SDK_INT >= 26) && (this.aavq != null) && (iBq())) {}
    }
    else
    {
      j = Selection.getSelectionStart(this.aauX);
      k = Selection.getSelectionEnd(this.aauX);
      m = BaseInputConnection.getComposingSpanStart(this.aauX);
      n = BaseInputConnection.getComposingSpanEnd(this.aauX);
      if ((this.aavz != null) && ((!this.aauX.toString().equals(this.aavz.text)) || (j != this.aavz.aauj) || (k != this.aavz.aauk) || (m != this.aavz.aaul) || (n != this.aavz.aaum))) {
        break label378;
      }
    }
    label378:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        new StringBuilder("send EditingState to flutter: ").append(this.aauX.toString());
        io.flutter.b.iAd();
        localObject1 = this.aaqg;
        i = this.aavr.id;
        localObject2 = this.aauX.toString();
        new StringBuilder("Sending message to update editing state: \nText: ").append((String)localObject2).append("\nSelection start: ").append(j).append("\nSelection end: ").append(k).append("\nComposing start: ").append(m).append("\nComposing end: ").append(n);
        io.flutter.b.iAd();
        localObject2 = m.h((String)localObject2, j, k, m, n);
        ((m)localObject1).aKT.a("TextInputClient.updateEditingState", Arrays.asList(new Serializable[] { Integer.valueOf(i), localObject2 }), null);
        this.aavz = new m.d(this.aauX.toString(), j, k, m, n);
      }
      AppMethodBeat.o(254170);
      return;
      Object localObject2 = this.aavs.aatW.aatY;
      this.aavq.notifyValueChanged(this.mView, ((String)localObject2).hashCode(), AutofillValue.forText((CharSequence)localObject1));
      break;
    }
  }
  
  public final InputConnection a(View paramView, EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9956);
    if (this.aavr.aavF == d.a.a.aavG)
    {
      this.aavv = null;
      AppMethodBeat.o(9956);
      return null;
    }
    if (this.aavr.aavF == d.a.a.aavI)
    {
      if (this.aavA)
      {
        paramView = this.aavv;
        AppMethodBeat.o(9956);
        return paramView;
      }
      this.aavv = this.platformViewsController.z(Integer.valueOf(this.aavr.id)).onCreateInputConnection(paramEditorInfo);
      paramView = this.aavv;
      AppMethodBeat.o(9956);
      return paramView;
    }
    paramEditorInfo.inputType = a(this.aavs.aatT, this.aavs.aatP, this.aavs.aatQ, this.aavs.aatR, this.aavs.aatS);
    paramEditorInfo.imeOptions = 33554432;
    int i;
    if (this.aavs.aatU == null) {
      if ((0x20000 & paramEditorInfo.inputType) != 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (this.aavs.aatV != null)
      {
        paramEditorInfo.actionLabel = this.aavs.aatV;
        paramEditorInfo.actionId = i;
      }
      paramEditorInfo.imeOptions = (i | paramEditorInfo.imeOptions);
      paramView = new b(paramView, this.aavr.id, this.aaqg, this.aauW, this.aauX, paramEditorInfo);
      paramEditorInfo.initialSelStart = Selection.getSelectionStart(this.aauX);
      paramEditorInfo.initialSelEnd = Selection.getSelectionEnd(this.aauX);
      this.aavv = paramView;
      paramView = this.aavv;
      AppMethodBeat.o(9956);
      return paramView;
      i = 6;
      continue;
      i = this.aavs.aatU.intValue();
    }
  }
  
  final void a(View paramView, m.d paramd)
  {
    AppMethodBeat.i(254169);
    this.aavz = paramd;
    this.aauX.a(paramd);
    if ((this.aavx) || (this.aavu))
    {
      this.aavc.restartInput(paramView);
      this.aavu = false;
    }
    AppMethodBeat.o(254169);
  }
  
  public final void a(ViewStructure paramViewStructure)
  {
    AppMethodBeat.i(254175);
    if ((Build.VERSION.SDK_INT < 26) || (!iBq()))
    {
      AppMethodBeat.o(254175);
      return;
    }
    String str = this.aavs.aatW.aatY;
    AutofillId localAutofillId = paramViewStructure.getAutofillId();
    int i = 0;
    if (i < this.aavt.size())
    {
      int j = this.aavt.keyAt(i);
      m.a.a locala = ((m.a)this.aavt.valueAt(i)).aatW;
      ViewStructure localViewStructure;
      if (locala != null)
      {
        paramViewStructure.addChildCount(1);
        localViewStructure = paramViewStructure.newChild(i);
        localViewStructure.setAutofillId(localAutofillId, j);
        localViewStructure.setAutofillHints(locala.aatZ);
        localViewStructure.setAutofillType(1);
        localViewStructure.setVisibility(0);
        if ((str.hashCode() != j) || (this.aavw == null)) {
          break label202;
        }
        localViewStructure.setDimens(this.aavw.left, this.aavw.top, 0, 0, this.aavw.width(), this.aavw.height());
        localViewStructure.setAutofillValue(AutofillValue.forText(this.aauX));
      }
      for (;;)
      {
        i += 1;
        break;
        label202:
        localViewStructure.setDimens(0, 0, 0, 0, 1, 1);
        localViewStructure.setAutofillValue(AutofillValue.forText(locala.aaua.text));
      }
    }
    AppMethodBeat.o(254175);
  }
  
  final void a(m.a parama)
  {
    AppMethodBeat.i(254173);
    if (Build.VERSION.SDK_INT < 26)
    {
      AppMethodBeat.o(254173);
      return;
    }
    if ((parama == null) || (parama.aatW == null))
    {
      this.aavt = null;
      AppMethodBeat.o(254173);
      return;
    }
    m.a[] arrayOfa = parama.aatX;
    this.aavt = new SparseArray();
    if (arrayOfa == null)
    {
      this.aavt.put(parama.aatW.aatY.hashCode(), parama);
      AppMethodBeat.o(254173);
      return;
    }
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      parama = arrayOfa[i];
      m.a.a locala = parama.aatW;
      if (locala != null)
      {
        this.aavt.put(locala.aatY.hashCode(), parama);
        this.aavq.notifyValueChanged(this.mView, locala.aatY.hashCode(), AutofillValue.forText(locala.aaua.text));
      }
      i += 1;
    }
    AppMethodBeat.o(254173);
  }
  
  public final void autofill(SparseArray<AutofillValue> paramSparseArray)
  {
    AppMethodBeat.i(254176);
    if (Build.VERSION.SDK_INT < 26)
    {
      AppMethodBeat.o(254176);
      return;
    }
    m.a.a locala = this.aavs.aatW;
    if (locala == null)
    {
      AppMethodBeat.o(254176);
      return;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramSparseArray.size())
    {
      int j = paramSparseArray.keyAt(i);
      Object localObject1 = (m.a)this.aavt.get(j);
      if ((localObject1 != null) && (((m.a)localObject1).aatW != null))
      {
        localObject1 = ((m.a)localObject1).aatW;
        Object localObject2 = ((AutofillValue)paramSparseArray.valueAt(i)).getTextValue().toString();
        localObject2 = new m.d((String)localObject2, ((String)localObject2).length(), ((String)localObject2).length(), -1, -1);
        if (((m.a.a)localObject1).aatY.equals(locala.aatY)) {
          a(this.mView, (m.d)localObject2);
        }
        localHashMap.put(((m.a.a)localObject1).aatY, localObject2);
      }
      i += 1;
    }
    this.aaqg.a(this.aavr.id, localHashMap);
    AppMethodBeat.o(254176);
  }
  
  @SuppressLint({"NewApi"})
  public final void destroy()
  {
    AppMethodBeat.i(254165);
    this.platformViewsController.aaoo = null;
    this.aaqg.aatN = null;
    iBr();
    if (this.aauX != null) {
      this.aauX.b(this);
    }
    if (this.aavy != null) {
      this.aavy.remove();
    }
    AppMethodBeat.o(254165);
  }
  
  final boolean iBq()
  {
    return this.aavt != null;
  }
  
  final void iBr()
  {
    AppMethodBeat.i(254171);
    if ((Build.VERSION.SDK_INT < 26) || (this.aavq == null) || (this.aavs == null) || (this.aavs.aatW == null) || (!iBq()))
    {
      AppMethodBeat.o(254171);
      return;
    }
    String str = this.aavs.aatW.aatY;
    this.aavq.notifyViewExited(this.mView, str.hashCode());
    AppMethodBeat.o(254171);
  }
  
  public final void jl(View paramView)
  {
    AppMethodBeat.i(9957);
    iBr();
    this.aavc.hideSoftInputFromWindow(paramView.getApplicationWindowToken(), 0);
    AppMethodBeat.o(9957);
  }
  
  public static final class a
  {
    public d.a.a aavF;
    public int id;
    
    public a(d.a.a parama, int paramInt)
    {
      this.aavF = parama;
      this.id = paramInt;
    }
  }
  
  static abstract interface b
  {
    public abstract void u(double paramDouble1, double paramDouble2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.editing.d
 * JD-Core Version:    0.7.0.1
 */