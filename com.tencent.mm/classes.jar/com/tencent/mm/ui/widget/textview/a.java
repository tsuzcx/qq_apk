package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint.FontMetrics;
import android.text.Spannable;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.accessibility.AccessibilityManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.c;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  a.b AMN;
  private a.b AMO;
  a.g AMQ;
  public a.d AMS;
  View AMT;
  public a.f AMU;
  View.OnTouchListener AMV;
  private Spannable AMW;
  private com.tencent.mm.ui.widget.c.a AMX;
  int AMY;
  int AMZ;
  private int ANa;
  int ANb;
  int ANc;
  private c ANd;
  int ANe;
  public int ANf;
  private ViewTreeObserver.OnScrollChangedListener ANg;
  boolean ANh;
  boolean ANi;
  public boolean ANj;
  public boolean ANk;
  boolean ANl;
  boolean ANm;
  boolean ANn;
  final Runnable ANo;
  final Runnable ANp;
  public a.e ANq;
  ArrayList<a.c> ANr;
  private View.OnAttachStateChangeListener Vt;
  private ViewTreeObserver.OnGlobalLayoutListener ZD;
  View.OnTouchListener kjL;
  View.OnClickListener lPx;
  Context mContext;
  private boolean mVI;
  private ViewTreeObserver.OnPreDrawListener rP;
  int[] sfd;
  int[] zzX;
  
  public a(a.a parama)
  {
    AppMethodBeat.i(113143);
    this.AMQ = new a.g(this);
    this.ANh = false;
    this.mVI = true;
    this.ANi = false;
    this.ANj = true;
    this.ANk = true;
    this.ANl = true;
    this.ANm = false;
    this.ANn = false;
    this.sfd = new int[2];
    this.ANo = new a.1(this);
    this.ANp = new a.5(this);
    this.zzX = new int[2];
    this.AMT = parama.AMT;
    this.AMU = parama.AMU;
    this.lPx = parama.lPx;
    this.AMV = parama.AMV;
    this.AMX = parama.ANt;
    this.mContext = this.AMT.getContext();
    this.ANa = parama.ANa;
    this.ANb = parama.ANb;
    View localView = this.AMT;
    int i;
    float f;
    if ((localView instanceof NeatTextView))
    {
      i = ((NeatTextView)localView).getLineHeight();
      this.ANe = i;
      if (this.ANc != 0) {
        break label345;
      }
      parama = this.AMT;
      if (!(parama instanceof NeatTextView)) {
        break label322;
      }
      f = ((NeatTextView)parama).getTextSize();
    }
    label221:
    for (this.ANc = ((int)f);; this.ANc = al.fromDPToPix(this.mContext, parama.ANu))
    {
      this.Vt = new a.6(this);
      this.rP = new a.7(this);
      this.ANg = new a.8(this);
      this.ZD = new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(113126);
          ak.d("SelectableTextHelper", "onGlobalLayout", new Object[0]);
          if (a.this.AMU != null)
          {
            a.this.dPQ();
            a.this.ANj = true;
            a.this.ANk = true;
            a.this.dPP();
          }
          AppMethodBeat.o(113126);
        }
      };
      this.kjL = new a.10(this);
      init();
      AppMethodBeat.o(113143);
      return;
      if ((localView instanceof TextView))
      {
        i = ((TextView)localView).getLineHeight();
        break;
      }
      i = 0;
      break;
      if ((parama instanceof TextView))
      {
        f = ((TextView)parama).getTextSize();
        break label221;
      }
      f = 0.0F;
      break label221;
    }
  }
  
  private void a(a.b paramb)
  {
    AppMethodBeat.i(113149);
    if (paramb == null)
    {
      AppMethodBeat.o(113149);
      return;
    }
    if (a.b.b(paramb)) {}
    for (int i = this.AMQ.akX; (i < 0) || (i > b.fz(this.AMT).length()); i = this.AMQ.Fe)
    {
      AppMethodBeat.o(113149);
      return;
    }
    Object localObject = b.fA(this.AMT);
    int j;
    if (localObject != null)
    {
      j = (int)((TextPaint)localObject).getFontMetrics().descent + b.au(this.AMT, b.av(this.AMT, i));
      i = (int)b.aw(this.AMT, i);
    }
    for (;;)
    {
      paramb.ANs.AMT.getLocationInWindow(paramb.ANA);
      if (paramb.ANv) {}
      for (int k = paramb.mWidth;; k = 0)
      {
        int n = i;
        int m = j;
        if (!paramb.ANv)
        {
          localObject = paramb.ia(i, j);
          n = localObject[0];
          m = localObject[1];
        }
        try
        {
          paramb.mPopupWindow.showAtLocation(paramb.ANs.AMT, 0, n - k + paramb.dQa(), m + paramb.dQb());
          AppMethodBeat.o(113149);
          return;
        }
        catch (Exception paramb)
        {
          ak.e("SelectableTextHelper", "error! message: %s.", new Object[] { paramb.getMessage() });
          AppMethodBeat.o(113149);
          return;
        }
      }
      i = 0;
      j = 0;
    }
  }
  
  private int aL(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(113156);
    if (this.ANr != null)
    {
      Iterator localIterator = this.ANr.iterator();
      while (localIterator.hasNext())
      {
        a.c localc = (a.c)localIterator.next();
        if (localc.ws(paramInt))
        {
          if (paramBoolean)
          {
            paramInt = localc.start;
            AppMethodBeat.o(113156);
            return paramInt;
          }
          paramInt = localc.end;
          AppMethodBeat.o(113156);
          return paramInt;
        }
      }
    }
    AppMethodBeat.o(113156);
    return paramInt;
  }
  
  private boolean dPR()
  {
    AppMethodBeat.i(138213);
    AccessibilityManager localAccessibilityManager = (AccessibilityManager)this.mContext.getSystemService("accessibility");
    if ((localAccessibilityManager.isEnabled()) && (localAccessibilityManager.isTouchExplorationEnabled()))
    {
      AppMethodBeat.o(138213);
      return true;
    }
    AppMethodBeat.o(138213);
    return false;
  }
  
  public final void dPP()
  {
    AppMethodBeat.i(113146);
    dPT();
    dPU();
    if (this.AMU != null) {
      this.AMU.dismiss();
    }
    AppMethodBeat.o(113146);
  }
  
  public final void dPQ()
  {
    AppMethodBeat.i(113147);
    this.AMQ.AND = null;
    if ((this.AMW != null) && (this.ANd != null))
    {
      this.AMW.removeSpan(this.ANd);
      this.ANd = null;
    }
    AppMethodBeat.o(113147);
  }
  
  public final void dPS()
  {
    AppMethodBeat.i(113150);
    if (!dPR())
    {
      a(this.AMN);
      a(this.AMO);
    }
    AppMethodBeat.o(113150);
  }
  
  public final void dPT()
  {
    AppMethodBeat.i(113151);
    if (this.AMN != null) {
      this.AMN.mPopupWindow.dismiss();
    }
    if (this.AMO != null) {
      this.AMO.mPopupWindow.dismiss();
    }
    AppMethodBeat.o(113151);
  }
  
  public final void dPU()
  {
    AppMethodBeat.i(113152);
    if (this.AMX != null) {
      this.AMX.dGj();
    }
    AppMethodBeat.o(113152);
  }
  
  public final void dPV()
  {
    AppMethodBeat.i(113153);
    if (this.AMU != null) {
      this.AMU.eW(this.AMT);
    }
    AppMethodBeat.o(113153);
  }
  
  public final void dPW()
  {
    int j = 16;
    AppMethodBeat.i(113154);
    int i;
    int m;
    if (this.AMX != null)
    {
      int[] arrayOfInt = new int[2];
      this.AMT.getLocationInWindow(arrayOfInt);
      int k = (int)b.aw(this.AMT, this.AMQ.akX) + arrayOfInt[0];
      i = b.ax(this.AMT, b.av(this.AMT, this.AMQ.akX));
      m = arrayOfInt[1] + i - 16;
      i = k;
      if (k <= 0) {
        i = 16;
      }
      if (m >= 0) {
        break label140;
      }
    }
    for (;;)
    {
      if (i > b.getScreenWidth(this.mContext)) {
        i = b.getScreenWidth(this.mContext) - 16;
      }
      for (;;)
      {
        this.AMX.dq(i, j);
        AppMethodBeat.o(113154);
        return;
      }
      label140:
      j = m;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(113145);
    this.ANh = false;
    this.mVI = true;
    this.ANi = false;
    this.AMT.removeCallbacks(this.ANo);
    this.AMT.getViewTreeObserver().removeOnScrollChangedListener(this.ANg);
    this.AMT.getViewTreeObserver().removeOnPreDrawListener(this.rP);
    this.AMT.getViewTreeObserver().removeOnGlobalLayoutListener(this.ZD);
    this.AMT.removeOnAttachStateChangeListener(this.Vt);
    this.ANj = true;
    this.ANk = true;
    dPP();
    dPQ();
    this.AMN = null;
    this.AMO = null;
    if (this.AMU != null) {
      this.AMU.dismiss();
    }
    AppMethodBeat.o(113145);
  }
  
  final void hY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113148);
    dPQ();
    if ((b.fz(this.AMT) instanceof Spannable)) {
      this.AMW = ((Spannable)b.fz(this.AMT));
    }
    if ((this.AMW == null) || (paramInt1 >= b.fz(this.AMT).length()))
    {
      this.AMQ.akX = 0;
      this.AMQ.Fe = 0;
      AppMethodBeat.o(113148);
      return;
    }
    hZ(paramInt1, paramInt2);
    AppMethodBeat.o(113148);
  }
  
  public final void hZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113155);
    if (paramInt1 != -1) {
      this.AMQ.akX = aL(paramInt1, true);
    }
    if (paramInt2 != -1) {
      this.AMQ.Fe = aL(paramInt2, false);
    }
    if ((this.AMQ.akX < 0) || (this.AMQ.akX > b.fz(this.AMT).length()))
    {
      AppMethodBeat.o(113155);
      return;
    }
    if ((this.AMQ.Fe < 0) || (this.AMQ.Fe > b.fz(this.AMT).length()))
    {
      AppMethodBeat.o(113155);
      return;
    }
    if (this.AMQ.akX > this.AMQ.Fe)
    {
      paramInt1 = this.AMQ.akX;
      this.AMQ.akX = this.AMQ.Fe;
      this.AMQ.Fe = paramInt1;
    }
    if (this.AMW != null)
    {
      this.AMQ.AND = this.AMW.subSequence(this.AMQ.akX, this.AMQ.Fe).toString();
      if (this.ANd == null) {
        break label314;
      }
      this.ANd.setPosition(this.AMQ.akX, this.AMQ.Fe);
    }
    for (;;)
    {
      paramInt1 = b.av(this.AMT, this.AMQ.akX);
      paramInt1 = b.aA(this.AMT, paramInt1);
      this.AMW.setSpan(this.ANd, paramInt1, this.AMQ.Fe, 17);
      if (this.AMS != null) {
        this.AMS.ad(this.AMQ.AND);
      }
      AppMethodBeat.o(113155);
      return;
      label314:
      this.ANd = new c(this.AMT, this.mContext.getResources().getColor(this.ANa), this.AMQ.akX, this.AMQ.Fe);
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(113144);
    if (!this.mVI)
    {
      ak.d("SelectableTextHelper", "not destroy, isReInit: %s.", new Object[] { Boolean.valueOf(this.ANh) });
      this.ANh = true;
      AppMethodBeat.o(113144);
      return;
    }
    ak.d("SelectableTextHelper", "not init yet, need to init.", new Object[0]);
    this.ANh = false;
    this.mVI = false;
    this.ANi = false;
    if (this.AMU == null) {
      b.a(this.AMT, b.fz(this.AMT), TextView.BufferType.SPANNABLE);
    }
    this.AMN = new a.b(this, true);
    if (this.AMU != null)
    {
      this.AMN.dQc();
      this.AMN.setTouchInterceptor(new a.11(this));
      this.AMN.setOnDismissListener(new a.12(this));
    }
    this.AMO = new a.b(this, false);
    this.AMT.setOnLongClickListener(new a.2(this));
    this.AMT.setOnTouchListener(this.kjL);
    this.AMT.setOnClickListener(new a.3(this));
    this.AMT.addOnAttachStateChangeListener(this.Vt);
    this.AMT.getViewTreeObserver().addOnPreDrawListener(this.rP);
    this.AMT.getViewTreeObserver().addOnScrollChangedListener(this.ANg);
    this.AMT.getViewTreeObserver().addOnGlobalLayoutListener(this.ZD);
    this.AMT.getViewTreeObserver().addOnGlobalLayoutListener(new a.4(this));
    AppMethodBeat.o(113144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a
 * JD-Core Version:    0.7.0.1
 */