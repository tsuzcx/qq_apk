package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.accessibility.AccessibilityManager;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.c;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  private ViewTreeObserver.OnPreDrawListener Bl;
  private int DfR;
  View.OnTouchListener HeV;
  int[] PhV;
  private Spannable QGC;
  private ViewTreeObserver.OnScrollChangedListener QPc;
  private int QPi;
  int QPj;
  int QPk;
  boolean QPl;
  int QPm;
  int QPp;
  int QPq;
  final Runnable QPv;
  b QXL;
  private b QXM;
  g QXN;
  public a.d QXO;
  View QXP;
  public a.f QXQ;
  View.OnTouchListener QXR;
  private com.tencent.mm.ui.widget.b.a QXS;
  private c QXT;
  public int QXU;
  boolean QXV;
  public boolean QXW;
  public boolean QXX;
  boolean QXY;
  boolean QXZ;
  boolean QYa;
  final Runnable QYb;
  public e QYc;
  ArrayList<c> QYd;
  private boolean aMn;
  private View.OnAttachStateChangeListener afw;
  private ViewTreeObserver.OnGlobalLayoutListener ajG;
  View.OnClickListener hEZ;
  Context mContext;
  int[] wrA;
  
  public a(a.a parama)
  {
    AppMethodBeat.i(159878);
    this.QXN = new g();
    this.DfR = 0;
    this.QXV = false;
    this.aMn = true;
    this.QPl = false;
    this.QXW = true;
    this.QXX = true;
    this.QXY = true;
    this.QXZ = false;
    this.QYa = false;
    this.wrA = new int[2];
    this.QPv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159850);
        if (a.this.QXV)
        {
          as.d("SelectableTextHelper", "isReInit, return.", new Object[0]);
          AppMethodBeat.o(159850);
          return;
        }
        as.d("SelectableTextHelper", "in mShowSelectViewRunnable. opener: %s, inScrolling: %s.", new Object[] { Boolean.valueOf(a.this.QXY), Boolean.valueOf(a.this.QXZ) });
        if (a.this.QXQ != null)
        {
          if (!a.this.QXY)
          {
            a.this.QXY = true;
            if (a.this.QXZ)
            {
              as.d("SelectableTextHelper", "menu is hide: %s, cursor is hide: %s.", new Object[] { Boolean.valueOf(a.this.QXW), Boolean.valueOf(a.this.QXX) });
              if (!a.this.QXW) {
                a.this.hcV();
              }
              if (!a.this.QXX)
              {
                a.this.hcQ();
                a.this.lE(a.this.QXN.avh, a.this.QXN.Pc);
              }
              if ((a.this.QXQ != null) && (a.this.QXW) && (!a.this.QXX)) {
                a.this.QXQ.gL(a.this.QXP);
              }
            }
            a.this.QXZ = false;
            AppMethodBeat.o(159850);
            return;
          }
          if (a.this.QYa)
          {
            a.this.QYa = false;
            as.d("SelectableTextHelper", "judge result(delay), click outside.", new Object[0]);
            if (a.this.QYc != null)
            {
              a.this.QYc.gUe();
              AppMethodBeat.o(159850);
            }
          }
          else
          {
            as.d("SelectableTextHelper", "Oh, bypass the judge logic! Don't worry, that's reasonable.", new Object[0]);
            AppMethodBeat.o(159850);
          }
        }
        else
        {
          if (!a.this.QXW) {
            a.this.hcV();
          }
          if (!a.this.QXX) {
            a.this.hcQ();
          }
        }
        AppMethodBeat.o(159850);
      }
    };
    this.QYb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159854);
        as.d("SelectableTextHelper", "dismiss all runnable.", new Object[0]);
        if (a.this.QYc != null) {
          a.this.QYc.gUe();
        }
        AppMethodBeat.o(159854);
      }
    };
    this.PhV = new int[2];
    this.QXP = parama.QXP;
    this.QXQ = parama.QXQ;
    this.hEZ = parama.hEZ;
    this.QXR = parama.QXR;
    this.QXS = parama.QYf;
    this.DfR = parama.QYh;
    this.mContext = this.QXP.getContext();
    this.QPi = parama.QPi;
    this.QPj = parama.QPj;
    this.QPm = b.hD(this.QXP);
    float f;
    if (this.QPk == 0)
    {
      parama = this.QXP;
      if ((parama instanceof NeatTextView)) {
        f = ((NeatTextView)parama).getTextSize();
      }
    }
    for (this.QPk = ((int)f);; this.QPk = at.fromDPToPix(this.mContext, parama.QYg))
    {
      this.afw = new View.OnAttachStateChangeListener()
      {
        public final void onViewAttachedToWindow(View paramAnonymousView)
        {
          AppMethodBeat.i(159855);
          as.d("SelectableTextHelper", "onViewAttachedToWindow", new Object[0]);
          AppMethodBeat.o(159855);
        }
        
        public final void onViewDetachedFromWindow(View paramAnonymousView)
        {
          AppMethodBeat.i(159856);
          as.d("SelectableTextHelper", "onViewDetachedFromWindow", new Object[0]);
          a.this.destroy();
          AppMethodBeat.o(159856);
        }
      };
      this.Bl = new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(159857);
          if (a.this.QPl)
          {
            a.this.QPl = false;
            a locala = a.this;
            locala.QXP.removeCallbacks(locala.QPv);
            locala.QXP.postDelayed(locala.QPv, 100L);
          }
          AppMethodBeat.o(159857);
          return true;
        }
      };
      this.QPc = new ViewTreeObserver.OnScrollChangedListener()
      {
        public final void onScrollChanged()
        {
          AppMethodBeat.i(159858);
          if (a.this.QXQ != null)
          {
            a.this.QXP.removeCallbacks(a.this.QYb);
            a.this.QXP.getLocationInWindow(a.this.PhV);
            as.d("SelectableTextHelper", "onScrollChanged, old-y: %d, y: %d.", new Object[] { Integer.valueOf(a.this.wrA[1]), Integer.valueOf(a.this.PhV[1]) });
            if (a.this.QXY)
            {
              if ((a.this.QXZ) || (a.this.QYa)) {
                break label260;
              }
              if (a.this.wrA[1] == a.this.PhV[1]) {
                break label238;
              }
              a.this.QXZ = true;
              a.this.QXY = false;
              as.d("SelectableTextHelper", "judge result, inScrolling.", new Object[0]);
            }
          }
          for (;;)
          {
            a.this.wrA[1] = a.this.PhV[1];
            if ((!a.this.QPl) && ((!a.this.QXW) || (!a.this.QXX)))
            {
              a.this.QPl = true;
              a.this.hbz();
            }
            AppMethodBeat.o(159858);
            return;
            label238:
            a.this.QYa = true;
            as.d("SelectableTextHelper", "need delay judge.", new Object[0]);
            continue;
            label260:
            if (a.this.QYa)
            {
              a.this.QYa = false;
              a.this.QXY = false;
              if (a.this.wrA[1] != a.this.PhV[1])
              {
                a.this.QXZ = true;
                as.d("SelectableTextHelper", "judge result(delay), inScrolling.", new Object[0]);
              }
              else
              {
                a.this.QXZ = false;
                as.d("SelectableTextHelper", "judge result, click outside.", new Object[0]);
              }
            }
          }
        }
      };
      this.ajG = new a.9(this);
      this.HeV = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(159860);
          as.d("SelectableTextHelper", "event pointer count: %d.", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getPointerCount()) });
          if (a.this.QXR != null) {
            a.this.QXR.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          }
          a.this.QPp = ((int)paramAnonymousMotionEvent.getX());
          a.this.QPq = ((int)paramAnonymousMotionEvent.getY());
          AppMethodBeat.o(159860);
          return false;
        }
      };
      if (this.aMn) {
        break label363;
      }
      as.d("SelectableTextHelper", "not destroy, isReInit: %s.", new Object[] { Boolean.valueOf(this.QXV) });
      this.QXV = true;
      AppMethodBeat.o(159878);
      return;
      if ((parama instanceof TextView))
      {
        f = ((TextView)parama).getTextSize();
        break;
      }
      f = 0.0F;
      break;
    }
    label363:
    as.d("SelectableTextHelper", "not init yet, need to init.", new Object[0]);
    this.QXV = false;
    this.aMn = false;
    this.QPl = false;
    Object localObject;
    TextView.BufferType localBufferType;
    if (this.QXQ == null)
    {
      parama = this.QXP;
      localObject = b.hB(this.QXP);
      localBufferType = TextView.BufferType.SPANNABLE;
      if (!(parama instanceof NeatTextView)) {
        break label637;
      }
      ((NeatTextView)parama).a((CharSequence)localObject, localBufferType);
    }
    for (;;)
    {
      this.QXL = new b(true);
      if (this.QXQ != null)
      {
        this.QXL.mPopupWindow.setOutsideTouchable(true);
        parama = this.QXL;
        localObject = new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(159861);
            as.d("SelectableTextHelper", "interceptor onTouch.", new Object[0]);
            int i = (int)paramAnonymousMotionEvent.getX();
            int j = (int)paramAnonymousMotionEvent.getY();
            if ((paramAnonymousMotionEvent.getAction() == 0) && ((i < 0) || (i >= a.this.QXL.getWidth()) || (j < 0) || (j >= a.this.QXL.getHeight())))
            {
              as.d("SelectableTextHelper", "interceptor onTouch, down, outside.", new Object[0]);
              a.this.QXP.postDelayed(a.this.QYb, 100L);
              AppMethodBeat.o(159861);
              return true;
            }
            if (paramAnonymousMotionEvent.getAction() == 4)
            {
              as.d("SelectableTextHelper", "interceptor onTouch, outside.", new Object[0]);
              a.this.QXP.postDelayed(a.this.QYb, 100L);
              AppMethodBeat.o(159861);
              return true;
            }
            AppMethodBeat.o(159861);
            return false;
          }
        };
        parama.mPopupWindow.setTouchInterceptor((View.OnTouchListener)localObject);
        parama = this.QXL;
        localObject = new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(159862);
            a.this.QXP.setOnTouchListener(a.this.HeV);
            AppMethodBeat.o(159862);
          }
        };
        parama.mPopupWindow.setOnDismissListener((PopupWindow.OnDismissListener)localObject);
      }
      this.QXM = new b(false);
      this.QXP.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159851);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/textview/SelectableTextHelper$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
          as.d("SelectableTextHelper", "onLongClick.", new Object[0]);
          a.this.QXV = false;
          int j;
          if (a.this.QXQ != null)
          {
            a.this.QXY = true;
            a.this.QXZ = false;
            a.this.QYa = false;
            Object localObject2 = b.hB(a.this.QXP);
            if ((localObject2 instanceof SpannableString))
            {
              localObject1 = a.this;
              localObject2 = (SpannableString)localObject2;
              ((a)localObject1).QYd = new ArrayList();
              i = 0;
              if (i < ((SpannableString)localObject2).length())
              {
                j = ((SpannableString)localObject2).nextSpanTransition(i, ((SpannableString)localObject2).length(), ImageSpan.class);
                Object localObject3 = (ImageSpan[])((SpannableString)localObject2).getSpans(i, j, ImageSpan.class);
                if (1 == localObject3.length)
                {
                  localObject3 = new a.c((a)localObject1);
                  ((a.c)localObject3).start = i;
                  ((a.c)localObject3).end = j;
                  ((a)localObject1).QYd.add(localObject3);
                }
                for (;;)
                {
                  as.d("SelectableTextHelper", "spans from %d to %d.", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
                  i = j;
                  break;
                  as.e("SelectableTextHelper", "other situation occur! length: %d.", new Object[] { Integer.valueOf(localObject3.length) });
                }
              }
              as.d("SelectableTextHelper", ((a)localObject1).QYd.toString(), new Object[0]);
            }
            a.this.hbz();
            if ((a.this.QXU > 0) && (a.this.QXU < b.hB(a.this.QXP).length()))
            {
              a.a(a.this, a.this.QXU);
              a.this.QXW = false;
              a.this.QXX = false;
              a.this.hcV();
              a.this.hcQ();
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/textview/SelectableTextHelper$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(159851);
              return true;
              a.a(a.this, b.hB(a.this.QXP).length());
              a.this.QXW = true;
              a.this.QXX = false;
              a.this.hcQ();
              a.this.QXQ.ea(paramAnonymousView);
            }
          }
          a.this.QXY = false;
          paramAnonymousView = a.this;
          int k = a.this.QPp;
          int i = a.this.QPq;
          localObject1 = paramAnonymousView.QXP;
          if ((localObject1 instanceof NeatTextView))
          {
            localObject1 = ((NeatTextView)localObject1).getLayout();
            if (localObject1 == null) {
              break label635;
            }
            i = ((com.tencent.neattextview.textview.layout.a)localObject1).mn(k, i);
          }
          for (;;)
          {
            paramAnonymousView.lP(i, i + 1);
            a.this.hbz();
            a.this.QXW = false;
            a.this.QXX = false;
            a.this.hcV();
            a.this.hcQ();
            break;
            if ((localObject1 instanceof TextView))
            {
              localObject1 = ((TextView)localObject1).getLayout();
              if (localObject1 != null)
              {
                j = ((Layout)localObject1).getOffsetForHorizontal(((Layout)localObject1).getLineForVertical(i), k);
                i = j;
                if ((int)((Layout)localObject1).getPrimaryHorizontal(j) > k) {
                  i = ((Layout)localObject1).getOffsetToLeftOf(j);
                }
              }
              else
              {
                i = -1;
              }
            }
            else
            {
              label635:
              i = 0;
            }
          }
        }
      });
      this.QXP.setOnTouchListener(this.HeV);
      this.QXP.setOnClickListener(new a.3(this));
      this.QXP.addOnAttachStateChangeListener(this.afw);
      this.QXP.getViewTreeObserver().addOnPreDrawListener(this.Bl);
      this.QXP.getViewTreeObserver().addOnScrollChangedListener(this.QPc);
      this.QXP.getViewTreeObserver().addOnGlobalLayoutListener(this.ajG);
      this.QXP.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(159853);
          a.this.QXP.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          if (a.this.QXQ != null)
          {
            a.this.QXP.getLocationInWindow(a.this.wrA);
            as.d("SelectableTextHelper", "init: loc-x: %d, loc-y: %d.", new Object[] { Integer.valueOf(a.this.wrA[0]), Integer.valueOf(a.this.wrA[1]) });
          }
          AppMethodBeat.o(159853);
        }
      });
      AppMethodBeat.o(159878);
      return;
      label637:
      if ((parama instanceof TextView)) {
        ((TextView)parama).setText((CharSequence)localObject, localBufferType);
      }
    }
  }
  
  private void a(b paramb)
  {
    AppMethodBeat.i(159884);
    if (paramb == null)
    {
      AppMethodBeat.o(159884);
      return;
    }
    if (b.b(paramb)) {}
    for (int i = this.QXN.avh; (i < 0) || (i > b.hB(this.QXP).length()); i = this.QXN.Pc)
    {
      AppMethodBeat.o(159884);
      return;
    }
    Object localObject = b.hC(this.QXP);
    int j;
    if (localObject != null)
    {
      j = (int)((TextPaint)localObject).getFontMetrics().descent + b.aP(this.QXP, b.aQ(this.QXP, i));
      i = (int)b.aR(this.QXP, i);
    }
    for (;;)
    {
      paramb.QYe.QXP.getLocationInWindow(paramb.QLE);
      if (paramb.QPA) {}
      for (int k = paramb.mWidth;; k = 0)
      {
        int n = i;
        int m = j;
        if (!paramb.QPA)
        {
          localObject = paramb.lQ(i, j);
          n = localObject[0];
          m = localObject[1];
        }
        try
        {
          paramb.mPopupWindow.showAtLocation(paramb.QYe.QXP, 0, n - k + paramb.hbD(), m + paramb.hbE());
          AppMethodBeat.o(159884);
          return;
        }
        catch (Exception paramb)
        {
          as.e("SelectableTextHelper", "error! message: %s.", new Object[] { paramb.getMessage() });
          AppMethodBeat.o(159884);
          return;
        }
      }
      i = 0;
      j = 0;
    }
  }
  
  private int bU(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(159893);
    if (this.QYd != null)
    {
      Iterator localIterator = this.QYd.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.Nm(paramInt))
        {
          if (paramBoolean)
          {
            paramInt = localc.start;
            AppMethodBeat.o(159893);
            return paramInt;
          }
          paramInt = localc.end;
          AppMethodBeat.o(159893);
          return paramInt;
        }
      }
    }
    AppMethodBeat.o(159893);
    return paramInt;
  }
  
  private boolean hcP()
  {
    AppMethodBeat.i(159885);
    AccessibilityManager localAccessibilityManager = (AccessibilityManager)this.mContext.getSystemService("accessibility");
    if ((localAccessibilityManager.isEnabled()) && (localAccessibilityManager.isTouchExplorationEnabled()))
    {
      AppMethodBeat.o(159885);
      return true;
    }
    AppMethodBeat.o(159885);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(159880);
    this.QXV = false;
    this.aMn = true;
    this.QPl = false;
    this.QXP.removeCallbacks(this.QPv);
    this.QXP.getViewTreeObserver().removeOnScrollChangedListener(this.QPc);
    this.QXP.getViewTreeObserver().removeOnPreDrawListener(this.Bl);
    this.QXP.getViewTreeObserver().removeOnGlobalLayoutListener(this.ajG);
    this.QXP.removeOnAttachStateChangeListener(this.afw);
    this.QXW = true;
    this.QXX = true;
    hbz();
    hbA();
    this.QXL = null;
    this.QXM = null;
    if (this.QXQ != null) {
      this.QXQ.dismiss();
    }
    AppMethodBeat.o(159880);
  }
  
  public final void hbA()
  {
    AppMethodBeat.i(159882);
    this.QXN.QPK = null;
    if ((this.QGC != null) && (this.QXT != null))
    {
      this.QGC.removeSpan(this.QXT);
      this.QXT = null;
    }
    AppMethodBeat.o(159882);
  }
  
  public final void hbz()
  {
    AppMethodBeat.i(159881);
    hcR();
    hcS();
    if (this.QXQ != null) {
      this.QXQ.dismiss();
    }
    AppMethodBeat.o(159881);
  }
  
  public final void hcQ()
  {
    AppMethodBeat.i(159886);
    if (!hcP())
    {
      a(this.QXL);
      a(this.QXM);
    }
    AppMethodBeat.o(159886);
  }
  
  public final void hcR()
  {
    AppMethodBeat.i(159887);
    if (this.QXL != null) {
      this.QXL.mPopupWindow.dismiss();
    }
    if (this.QXM != null) {
      this.QXM.mPopupWindow.dismiss();
    }
    AppMethodBeat.o(159887);
  }
  
  public final void hcS()
  {
    AppMethodBeat.i(159888);
    if (this.QXS != null) {
      this.QXS.gNq();
    }
    AppMethodBeat.o(159888);
  }
  
  public final void hcT()
  {
    AppMethodBeat.i(159889);
    if (this.QXQ != null) {
      this.QXQ.gL(this.QXP);
    }
    AppMethodBeat.o(159889);
  }
  
  public final void hcU()
  {
    AppMethodBeat.i(159890);
    if (this.QXQ != null) {
      this.QXQ.dismiss();
    }
    AppMethodBeat.o(159890);
  }
  
  public final void hcV()
  {
    AppMethodBeat.i(159891);
    int i;
    int j;
    if (this.QXS != null)
    {
      int[] arrayOfInt = new int[2];
      this.QXP.getLocationInWindow(arrayOfInt);
      float f3 = b.aR(this.QXP, this.QXN.avh);
      float f2 = b.aR(this.QXP, this.QXN.Pc);
      i = b.aQ(this.QXP, this.QXN.avh);
      float f1;
      if (b.aQ(this.QXP, this.QXN.Pc) <= i)
      {
        f1 = f2;
        if (f2 > f3) {}
      }
      else
      {
        f1 = b.aU(this.QXP, b.aQ(this.QXP, this.QXN.avh));
      }
      i = (int)((f1 + f3) / 2.0F);
      j = this.DfR + i;
      int k = b.aS(this.QXP, b.aQ(this.QXP, this.QXN.avh)) + arrayOfInt[1] + this.mContext.getResources().getDimensionPixelSize(2131166207);
      as.d("SelectableTextHelper", "dancy test posX:%s, startline:%s, endline:%s, leftpadding:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(b.aQ(this.QXP, this.QXN.avh)), Integer.valueOf(b.aQ(this.QXP, this.QXN.Pc)), Integer.valueOf(this.DfR) });
      i = j;
      if (j <= 0) {
        i = 16;
      }
      j = k;
      if (k < 0) {
        j = 16;
      }
      if (i <= b.getScreenWidth(this.mContext)) {
        break label334;
      }
      i = b.getScreenWidth(this.mContext) - 16;
    }
    label334:
    for (;;)
    {
      this.QXS.ez(i, j);
      if (this.QXQ != null) {
        this.QXQ.gUa();
      }
      AppMethodBeat.o(159891);
      return;
    }
  }
  
  public final void lE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159892);
    if (paramInt1 != -1) {
      this.QXN.avh = bU(paramInt1, true);
    }
    if (paramInt2 != -1) {
      this.QXN.Pc = bU(paramInt2, false);
    }
    if ((this.QXN.avh < 0) || (this.QXN.avh > b.hB(this.QXP).length()))
    {
      AppMethodBeat.o(159892);
      return;
    }
    if ((this.QXN.Pc < 0) || (this.QXN.Pc > b.hB(this.QXP).length()))
    {
      AppMethodBeat.o(159892);
      return;
    }
    if (this.QXN.avh > this.QXN.Pc)
    {
      paramInt1 = this.QXN.avh;
      this.QXN.avh = this.QXN.Pc;
      this.QXN.Pc = paramInt1;
    }
    if (this.QGC != null)
    {
      this.QXN.QPK = this.QGC.subSequence(this.QXN.avh, this.QXN.Pc).toString();
      if (this.QXT == null) {
        break label314;
      }
      this.QXT.setPosition(this.QXN.avh, this.QXN.Pc);
    }
    for (;;)
    {
      paramInt1 = b.aQ(this.QXP, this.QXN.avh);
      paramInt1 = b.aV(this.QXP, paramInt1);
      this.QGC.setSpan(this.QXT, paramInt1, this.QXN.Pc, 17);
      if (this.QXO != null) {
        this.QXO.as(this.QXN.QPK);
      }
      AppMethodBeat.o(159892);
      return;
      label314:
      this.QXT = new c(this.QXP, this.mContext.getResources().getColor(this.QPi), this.QXN.avh, this.QXN.Pc);
    }
  }
  
  final void lP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159883);
    hbA();
    if ((b.hB(this.QXP) instanceof Spannable)) {
      this.QGC = ((Spannable)b.hB(this.QXP));
    }
    if ((this.QGC == null) || (paramInt1 >= b.hB(this.QXP).length()))
    {
      this.QXN.avh = 0;
      this.QXN.Pc = 0;
      AppMethodBeat.o(159883);
      return;
    }
    lE(paramInt1, paramInt2);
    AppMethodBeat.o(159883);
  }
  
  final class b
    extends View
  {
    private int[] PhV;
    int[] QLE;
    boolean QPA;
    private int QPB;
    private int QPC;
    private int QPD;
    private int QPE;
    private boolean QYi;
    private int mHeight;
    private int mPadding;
    private Paint mPaint;
    PopupWindow mPopupWindow;
    int mWidth;
    private Point nDV;
    private int qRY;
    private Rect rect;
    
    b(boolean paramBoolean)
    {
      super();
      AppMethodBeat.i(159864);
      this.qRY = (a.this.QPk / 2);
      this.mWidth = (this.qRY * 2);
      this.mHeight = (this.qRY * 2);
      this.mPadding = 25;
      this.QLE = new int[2];
      this.rect = new Rect();
      this.nDV = new Point();
      this.QYi = false;
      this.PhV = new int[2];
      this.QPA = paramBoolean;
      this.mPaint = new Paint(1);
      this.mPaint.setColor(a.this.mContext.getResources().getColor(a.this.QPj));
      this.mPopupWindow = new PopupWindow(this);
      this.mPopupWindow.setClippingEnabled(false);
      this.mPopupWindow.setWidth(this.mWidth + this.mPadding * 2);
      this.mPopupWindow.setHeight(this.mHeight + this.mPadding / 2);
      AppMethodBeat.o(159864);
    }
    
    private void hbB()
    {
      AppMethodBeat.i(159867);
      if (!this.QPA) {}
      for (boolean bool = true;; bool = false)
      {
        this.QPA = bool;
        invalidate();
        AppMethodBeat.o(159867);
        return;
      }
    }
    
    private void hbC()
    {
      AppMethodBeat.i(159869);
      a.this.QXP.getLocationInWindow(this.QLE);
      Object localObject = b.hC(a.this.QXP);
      if (localObject != null)
      {
        int i = (int)((TextPaint)localObject).getFontMetrics().descent;
        if (this.QPA)
        {
          this.mPopupWindow.update((int)b.aR(a.this.QXP, a.this.QXN.avh) - this.mWidth + hbD(), i + b.aP(a.this.QXP, b.aQ(a.this.QXP, a.this.QXN.avh)) + hbE(), -1, -1);
          AppMethodBeat.o(159869);
          return;
        }
        localObject = lQ((int)b.aR(a.this.QXP, a.this.QXN.Pc), i + b.aP(a.this.QXP, b.aQ(a.this.QXP, a.this.QXN.Pc)));
        i = localObject[0];
        int j = localObject[1];
        this.mPopupWindow.update(i + hbD(), j + hbE(), -1, -1);
      }
      AppMethodBeat.o(159869);
    }
    
    private void update(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159868);
      a.this.QXP.getLocationInWindow(this.QLE);
      int i;
      b localb;
      if (this.QPA)
      {
        i = a.this.QXN.avh;
        int j = this.QLE[1];
        paramInt1 = b.f(a.this.QXP, paramInt1, paramInt2 - j, i);
        if (paramInt1 == i) {
          break label225;
        }
        a.this.hbA();
        if (!this.QPA) {
          break label169;
        }
        if (paramInt1 <= this.QPE) {
          break label157;
        }
        localb = a.a(a.this, false);
        hbB();
        localb.hbB();
        this.QPD = this.QPE;
        a.this.lE(this.QPE, paramInt1);
        localb.hbC();
      }
      for (;;)
      {
        hbC();
        AppMethodBeat.o(159868);
        return;
        i = a.this.QXN.Pc;
        break;
        label157:
        a.this.lE(paramInt1, -1);
      }
      label169:
      if (paramInt1 < this.QPD)
      {
        localb = a.a(a.this, true);
        localb.hbB();
        hbB();
        this.QPE = this.QPD;
        a.this.lE(paramInt1, this.QPD);
        localb.hbC();
      }
      for (;;)
      {
        hbC();
        label225:
        AppMethodBeat.o(159868);
        return;
        a.this.lE(this.QPD, paramInt1);
      }
    }
    
    public final int hbD()
    {
      AppMethodBeat.i(159870);
      int i = this.QLE[0];
      int j = this.mPadding;
      int k = a.this.QXP.getPaddingLeft();
      AppMethodBeat.o(159870);
      return i - j + k;
    }
    
    public final int hbE()
    {
      AppMethodBeat.i(159871);
      int i = this.QLE[1];
      int j = a.this.QXP.getPaddingTop();
      AppMethodBeat.o(159871);
      return i + j;
    }
    
    final int[] lQ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159872);
      int j = paramInt1;
      int i = paramInt2;
      if (paramInt1 == 0)
      {
        j = paramInt1;
        i = paramInt2;
        if (a.this.QXN.Pc > 1)
        {
          a.this.QXP.getLocationInWindow(this.QLE);
          TextPaint localTextPaint = b.hC(a.this.QXP);
          j = paramInt1;
          i = paramInt2;
          if (localTextPaint != null)
          {
            paramInt1 = (int)localTextPaint.getFontMetrics().descent;
            paramInt2 = b.aQ(a.this.QXP, a.this.QXN.Pc - 1);
            j = (int)b.aU(a.this.QXP, paramInt2);
            i = b.aP(a.this.QXP, b.aQ(a.this.QXP, a.this.QXN.Pc - 1)) + paramInt1;
          }
        }
      }
      AppMethodBeat.o(159872);
      return new int[] { j, i };
    }
    
    protected final void onDraw(Canvas paramCanvas)
    {
      AppMethodBeat.i(159865);
      int i;
      int j;
      int k;
      if (a.this.QXQ != null) {
        if (this.QPA)
        {
          i = a.this.QXN.avh;
          TextPaint localTextPaint = b.hC(a.this.QXP);
          if (localTextPaint == null) {
            break label485;
          }
          j = b.aP(a.this.QXP, b.aQ(a.this.QXP, i));
          j = (int)localTextPaint.getFontMetrics().descent + j;
          k = (int)b.aR(a.this.QXP, i);
          i = j;
          j = k;
        }
      }
      for (;;)
      {
        a.this.QXP.getLocationInWindow(this.QLE);
        k = i;
        if (!this.QPA) {
          k = lQ(j, i)[1];
        }
        i = hbE() + k;
        if (a.this.QXP.getGlobalVisibleRect(this.rect, this.nDV))
        {
          if (i >= this.rect.bottom)
          {
            if (this.QPA)
            {
              as.d("SelectableTextHelper", "start below bottom, dismiss all.", new Object[0]);
              a.this.hbA();
              a.this.QXW = true;
              a.this.QXX = true;
              a.this.hbz();
              a.this.QXQ.dismiss();
            }
            as.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
            AppMethodBeat.o(159865);
            return;
            i = a.this.QXN.Pc;
            break;
          }
          if (i > this.rect.top) {
            break label373;
          }
          if (!this.QPA)
          {
            as.d("SelectableTextHelper", "end above top, dismiss all.", new Object[0]);
            a.this.hbA();
            a.this.QXW = true;
            a.this.QXX = true;
            a.this.hbz();
            a.this.QXQ.dismiss();
          }
          as.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
          AppMethodBeat.o(159865);
          return;
        }
        as.d("SelectableTextHelper", "view invisible.", new Object[0]);
        AppMethodBeat.o(159865);
        return;
        label373:
        paramCanvas.drawCircle(this.qRY + this.mPadding, this.qRY, this.qRY, this.mPaint);
        if (this.QPA)
        {
          paramCanvas.drawRect(this.qRY + this.mPadding, 0.0F, this.qRY * 2 + this.mPadding, this.qRY, this.mPaint);
          AppMethodBeat.o(159865);
          return;
        }
        paramCanvas.drawRect(this.mPadding, 0.0F, this.qRY + this.mPadding, this.qRY, this.mPaint);
        AppMethodBeat.o(159865);
        return;
        label485:
        j = 0;
        i = 0;
      }
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(159866);
      switch (paramMotionEvent.getAction())
      {
      }
      label430:
      for (;;)
      {
        AppMethodBeat.o(159866);
        return true;
        this.QPD = a.this.QXN.avh;
        this.QPE = a.this.QXN.Pc;
        this.QPB = ((int)paramMotionEvent.getX());
        this.QPC = ((int)paramMotionEvent.getY());
        this.QYi = false;
        a.this.QXP.getLocationOnScreen(this.PhV);
        continue;
        if ((a.this.QXQ != null) && (!this.QYi))
        {
          this.QYi = true;
          a.this.QXQ.gTY();
          if (a.this.QXN.Pc - a.this.QXN.avh == b.hB(a.this.QXP).length())
          {
            a.this.QXQ.gL(a.this.QXP);
            a.this.QXW = true;
            a.this.hcS();
          }
          for (;;)
          {
            a.this.QXQ.gTZ();
            break;
            a.this.QXQ.dismiss();
            a.this.QXW = false;
            a.this.hcV();
          }
        }
        if (!a.this.QXW)
        {
          a.this.hcV();
          continue;
          if (a.this.QXQ != null)
          {
            a.this.QXQ.gTY();
            a.this.QXQ.dismiss();
          }
          a.this.hcS();
          int i = (int)paramMotionEvent.getRawX();
          int j = (int)paramMotionEvent.getRawY();
          if (a.this.QXQ == null) {
            update(i - this.PhV[0], j + this.QPC - this.mHeight - a.this.QPm);
          }
          for (;;)
          {
            if (a.this.QXQ == null) {
              break label430;
            }
            a.this.QXQ.gTZ();
            break;
            update(i - this.PhV[0] + this.qRY, j + this.QPC - this.mHeight - a.this.QPm);
          }
        }
      }
    }
  }
  
  final class c
  {
    int end;
    int start;
    
    c() {}
    
    final boolean Nm(int paramInt)
    {
      return (paramInt >= this.start) && (paramInt < this.end);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(159877);
      String str = "start: " + this.start + " end: " + this.end;
      AppMethodBeat.o(159877);
      return str;
    }
  }
  
  public static abstract interface e
  {
    public abstract void gUe();
  }
  
  final class g
  {
    int Pc;
    String QPK;
    int avh;
    
    g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a
 * JD-Core Version:    0.7.0.1
 */