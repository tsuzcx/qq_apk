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
import com.tencent.mm.ui.base.c;
import com.tencent.mm.ui.bc;
import com.tencent.mm.ui.bd;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  private int Ips;
  int[] JoC;
  private boolean aUP;
  private Spannable afXs;
  private ViewTreeObserver.OnScrollChangedListener aggc;
  private int aggi;
  int aggj;
  int aggk;
  boolean aggl;
  int aggm;
  int aggp;
  int aggq;
  final Runnable aggv;
  b agoL;
  private b agoM;
  g agoN;
  public d agoO;
  View agoP;
  public f agoQ;
  View.OnTouchListener agoR;
  private com.tencent.mm.ui.widget.b.a agoS;
  private c agoT;
  public int agoU;
  boolean agoV;
  public boolean agoW;
  public boolean agoX;
  boolean agoY;
  boolean agoZ;
  boolean agpa;
  final Runnable agpb;
  public e agpc;
  ArrayList<c> agpd;
  int[] bfh;
  private ViewTreeObserver.OnPreDrawListener cfn;
  private View.OnAttachStateChangeListener mB;
  Context mContext;
  View.OnClickListener mWW;
  View.OnTouchListener pWX;
  private ViewTreeObserver.OnGlobalLayoutListener qZ;
  
  public a(a parama)
  {
    AppMethodBeat.i(159878);
    this.agoN = new g();
    this.Ips = 0;
    this.agoV = false;
    this.aUP = true;
    this.aggl = false;
    this.agoW = true;
    this.agoX = true;
    this.agoY = true;
    this.agoZ = false;
    this.agpa = false;
    this.bfh = new int[2];
    this.aggv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159850);
        if (a.this.agoV)
        {
          bc.d("SelectableTextHelper", "isReInit, return.", new Object[0]);
          AppMethodBeat.o(159850);
          return;
        }
        bc.d("SelectableTextHelper", "in mShowSelectViewRunnable. opener: %s, inScrolling: %s.", new Object[] { Boolean.valueOf(a.this.agoY), Boolean.valueOf(a.this.agoZ) });
        if (a.this.agoQ != null)
        {
          if (!a.this.agoY)
          {
            a.this.agoY = true;
            if (a.this.agoZ)
            {
              bc.d("SelectableTextHelper", "menu is hide: %s, cursor is hide: %s.", new Object[] { Boolean.valueOf(a.this.agoW), Boolean.valueOf(a.this.agoX) });
              if (!a.this.agoW) {
                a.this.jJt();
              }
              if (!a.this.agoX)
              {
                a.this.jJo();
                a.this.gc(a.this.agoN.uG, a.this.agoN.uH);
              }
              if ((a.this.agoQ != null) && (a.this.agoW) && (!a.this.agoX)) {
                a.this.agoQ.ls(a.this.agoP);
              }
            }
            a.this.agoZ = false;
            AppMethodBeat.o(159850);
            return;
          }
          if (a.this.agpa)
          {
            a.this.agpa = false;
            bc.d("SelectableTextHelper", "judge result(delay), click outside.", new Object[0]);
            if (a.this.agpc != null)
            {
              a.this.agpc.jxt();
              AppMethodBeat.o(159850);
            }
          }
          else
          {
            bc.d("SelectableTextHelper", "Oh, bypass the judge logic! Don't worry, that's reasonable.", new Object[0]);
            AppMethodBeat.o(159850);
          }
        }
        else
        {
          if (!a.this.agoW) {
            a.this.jJt();
          }
          if (!a.this.agoX) {
            a.this.jJo();
          }
        }
        AppMethodBeat.o(159850);
      }
    };
    this.agpb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159854);
        bc.d("SelectableTextHelper", "dismiss all runnable.", new Object[0]);
        if (a.this.agpc != null) {
          a.this.agpc.jxt();
        }
        AppMethodBeat.o(159854);
      }
    };
    this.JoC = new int[2];
    this.agoP = parama.agoP;
    this.agoQ = parama.agoQ;
    this.mWW = parama.mWW;
    this.agoR = parama.agoR;
    this.agoS = parama.agpf;
    this.Ips = parama.agph;
    this.mContext = this.agoP.getContext();
    this.aggi = parama.aggi;
    this.aggj = parama.aggj;
    this.aggm = b.mw(this.agoP);
    float f;
    if (this.aggk == 0)
    {
      parama = this.agoP;
      if ((parama instanceof NeatTextView)) {
        f = ((NeatTextView)parama).getTextSize();
      }
    }
    for (this.aggk = ((int)f);; this.aggk = bd.fromDPToPix(this.mContext, parama.agpg))
    {
      this.mB = new View.OnAttachStateChangeListener()
      {
        public final void onViewAttachedToWindow(View paramAnonymousView)
        {
          AppMethodBeat.i(159855);
          bc.d("SelectableTextHelper", "onViewAttachedToWindow", new Object[0]);
          AppMethodBeat.o(159855);
        }
        
        public final void onViewDetachedFromWindow(View paramAnonymousView)
        {
          AppMethodBeat.i(159856);
          bc.d("SelectableTextHelper", "onViewDetachedFromWindow", new Object[0]);
          a.this.destroy();
          AppMethodBeat.o(159856);
        }
      };
      this.cfn = new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(159857);
          if (a.this.aggl)
          {
            a.this.aggl = false;
            a locala = a.this;
            locala.agoP.removeCallbacks(locala.aggv);
            locala.agoP.postDelayed(locala.aggv, 100L);
          }
          AppMethodBeat.o(159857);
          return true;
        }
      };
      this.aggc = new ViewTreeObserver.OnScrollChangedListener()
      {
        public final void onScrollChanged()
        {
          AppMethodBeat.i(159858);
          if (a.this.agoQ != null)
          {
            a.this.agoP.removeCallbacks(a.this.agpb);
            a.this.agoP.getLocationInWindow(a.this.JoC);
            bc.d("SelectableTextHelper", "onScrollChanged, old-y: %d, y: %d.", new Object[] { Integer.valueOf(a.this.bfh[1]), Integer.valueOf(a.this.JoC[1]) });
            if (a.this.agoY)
            {
              if ((a.this.agoZ) || (a.this.agpa)) {
                break label260;
              }
              if (a.this.bfh[1] == a.this.JoC[1]) {
                break label238;
              }
              a.this.agoZ = true;
              a.this.agoY = false;
              bc.d("SelectableTextHelper", "judge result, inScrolling.", new Object[0]);
            }
          }
          for (;;)
          {
            a.this.bfh[1] = a.this.JoC[1];
            if ((!a.this.aggl) && ((!a.this.agoW) || (!a.this.agoX)))
            {
              a.this.aggl = true;
              a.this.cRT();
            }
            AppMethodBeat.o(159858);
            return;
            label238:
            a.this.agpa = true;
            bc.d("SelectableTextHelper", "need delay judge.", new Object[0]);
            continue;
            label260:
            if (a.this.agpa)
            {
              a.this.agpa = false;
              a.this.agoY = false;
              if (a.this.bfh[1] != a.this.JoC[1])
              {
                a.this.agoZ = true;
                bc.d("SelectableTextHelper", "judge result(delay), inScrolling.", new Object[0]);
              }
              else
              {
                a.this.agoZ = false;
                bc.d("SelectableTextHelper", "judge result, click outside.", new Object[0]);
              }
            }
          }
        }
      };
      this.qZ = new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(159859);
          AppMethodBeat.o(159859);
        }
      };
      this.pWX = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(159860);
          bc.d("SelectableTextHelper", "event pointer count: %d.", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getPointerCount()) });
          if (a.this.agoR != null) {
            a.this.agoR.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          }
          a.this.aggp = ((int)paramAnonymousMotionEvent.getX());
          a.this.aggq = ((int)paramAnonymousMotionEvent.getY());
          AppMethodBeat.o(159860);
          return false;
        }
      };
      if (this.aUP) {
        break label363;
      }
      bc.d("SelectableTextHelper", "not destroy, isReInit: %s.", new Object[] { Boolean.valueOf(this.agoV) });
      this.agoV = true;
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
    bc.d("SelectableTextHelper", "not init yet, need to init.", new Object[0]);
    this.agoV = false;
    this.aUP = false;
    this.aggl = false;
    Object localObject;
    TextView.BufferType localBufferType;
    if (this.agoQ == null)
    {
      parama = this.agoP;
      localObject = b.mu(this.agoP);
      localBufferType = TextView.BufferType.SPANNABLE;
      if (!(parama instanceof NeatTextView)) {
        break label637;
      }
      ((NeatTextView)parama).a((CharSequence)localObject, localBufferType);
    }
    for (;;)
    {
      this.agoL = new b(true);
      if (this.agoQ != null)
      {
        this.agoL.aggz.setOutsideTouchable(true);
        parama = this.agoL;
        localObject = new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(159861);
            bc.d("SelectableTextHelper", "interceptor onTouch.", new Object[0]);
            int i = (int)paramAnonymousMotionEvent.getX();
            int j = (int)paramAnonymousMotionEvent.getY();
            if ((paramAnonymousMotionEvent.getAction() == 0) && ((i < 0) || (i >= a.this.agoL.getWidth()) || (j < 0) || (j >= a.this.agoL.getHeight())))
            {
              bc.d("SelectableTextHelper", "interceptor onTouch, down, outside.", new Object[0]);
              a.this.agoP.postDelayed(a.this.agpb, 100L);
              AppMethodBeat.o(159861);
              return true;
            }
            if (paramAnonymousMotionEvent.getAction() == 4)
            {
              bc.d("SelectableTextHelper", "interceptor onTouch, outside.", new Object[0]);
              a.this.agoP.postDelayed(a.this.agpb, 100L);
              AppMethodBeat.o(159861);
              return true;
            }
            AppMethodBeat.o(159861);
            return false;
          }
        };
        parama.aggz.setTouchInterceptor((View.OnTouchListener)localObject);
        parama = this.agoL;
        localObject = new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(159862);
            a.this.agoP.setOnTouchListener(a.this.pWX);
            AppMethodBeat.o(159862);
          }
        };
        parama.aggz.setOnDismissListener((PopupWindow.OnDismissListener)localObject);
      }
      this.agoM = new b(false);
      this.agoP.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159851);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/textview/SelectableTextHelper$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
          bc.d("SelectableTextHelper", "onLongClick.", new Object[0]);
          a.this.agoV = false;
          int j;
          if (a.this.agoQ != null)
          {
            a.this.agoY = true;
            a.this.agoZ = false;
            a.this.agpa = false;
            Object localObject2 = b.mu(a.this.agoP);
            if ((localObject2 instanceof SpannableString))
            {
              localObject1 = a.this;
              localObject2 = (SpannableString)localObject2;
              ((a)localObject1).agpd = new ArrayList();
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
                  ((a)localObject1).agpd.add(localObject3);
                }
                for (;;)
                {
                  bc.d("SelectableTextHelper", "spans from %d to %d.", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
                  i = j;
                  break;
                  bc.e("SelectableTextHelper", "other situation occur! length: %d.", new Object[] { Integer.valueOf(localObject3.length) });
                }
              }
              bc.d("SelectableTextHelper", ((a)localObject1).agpd.toString(), new Object[0]);
            }
            a.this.cRT();
            if ((a.this.agoU > 0) && (a.this.agoU < b.mu(a.this.agoP).length()))
            {
              a.a(a.this, a.this.agoU);
              a.this.agoW = false;
              a.this.agoX = false;
              a.this.jJt();
              a.this.jJo();
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/textview/SelectableTextHelper$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(159851);
              return true;
              a.a(a.this, b.mu(a.this.agoP).length());
              a.this.agoW = true;
              a.this.agoX = false;
              a.this.jJo();
              a.this.agoQ.ft(paramAnonymousView);
            }
          }
          a.this.agoY = false;
          paramAnonymousView = a.this;
          int k = a.this.aggp;
          int i = a.this.aggq;
          localObject1 = paramAnonymousView.agoP;
          if ((localObject1 instanceof NeatTextView))
          {
            localObject1 = ((NeatTextView)localObject1).getLayout();
            if (localObject1 == null) {
              break label635;
            }
            i = ((com.tencent.neattextview.textview.layout.a)localObject1).pB(k, i);
          }
          for (;;)
          {
            paramAnonymousView.pc(i, i + 1);
            a.this.cRT();
            a.this.agoW = false;
            a.this.agoX = false;
            a.this.jJt();
            a.this.jJo();
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
      this.agoP.setOnTouchListener(this.pWX);
      this.agoP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159852);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/textview/SelectableTextHelper$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          bc.d("SelectableTextHelper", "onClick", new Object[0]);
          if (a.this.mWW != null) {
            a.this.mWW.onClick(paramAnonymousView);
          }
          a.this.agoW = true;
          a.this.agoX = true;
          a.this.cRT();
          a.this.cRQ();
          if (a.this.agoQ != null) {
            a.this.agoQ.dismiss();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/textview/SelectableTextHelper$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(159852);
        }
      });
      this.agoP.addOnAttachStateChangeListener(this.mB);
      this.agoP.getViewTreeObserver().addOnPreDrawListener(this.cfn);
      this.agoP.getViewTreeObserver().addOnScrollChangedListener(this.aggc);
      this.agoP.getViewTreeObserver().addOnGlobalLayoutListener(this.qZ);
      this.agoP.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(159853);
          a.this.agoP.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          if (a.this.agoQ != null)
          {
            a.this.agoP.getLocationInWindow(a.this.bfh);
            bc.d("SelectableTextHelper", "init: loc-x: %d, loc-y: %d.", new Object[] { Integer.valueOf(a.this.bfh[0]), Integer.valueOf(a.this.bfh[1]) });
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
    for (int i = this.agoN.uG; (i < 0) || (i > b.mu(this.agoP).length()); i = this.agoN.uH)
    {
      AppMethodBeat.o(159884);
      return;
    }
    Object localObject = b.mv(this.agoP);
    int j;
    if (localObject != null)
    {
      j = (int)((TextPaint)localObject).getFontMetrics().descent + b.bv(this.agoP, b.bw(this.agoP, i));
      i = (int)b.bx(this.agoP, i);
    }
    for (;;)
    {
      paramb.agpe.agoP.getLocationInWindow(paramb.agcv);
      if (paramb.aggA) {}
      for (int k = paramb.mWidth;; k = 0)
      {
        int n = i;
        int m = j;
        if (!paramb.aggA)
        {
          localObject = paramb.pd(i, j);
          n = localObject[0] + paramb.ebX;
          m = localObject[1];
        }
        try
        {
          paramb.aggz.showAtLocation(paramb.agpe.agoP, 0, n - k + paramb.getExtraX(), m + paramb.getExtraY());
          AppMethodBeat.o(159884);
          return;
        }
        catch (Exception paramb)
        {
          bc.e("SelectableTextHelper", "error! message: %s.", new Object[] { paramb.getMessage() });
          AppMethodBeat.o(159884);
          return;
        }
      }
      i = 0;
      j = 0;
    }
  }
  
  private boolean cEs()
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
  
  private int cY(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(159893);
    if (this.agpd != null)
    {
      Iterator localIterator = this.agpd.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.Wh(paramInt))
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
  
  public final void cRQ()
  {
    AppMethodBeat.i(159882);
    this.agoN.aggI = null;
    if ((this.afXs != null) && (this.agoT != null))
    {
      this.afXs.removeSpan(this.agoT);
      this.agoT = null;
    }
    AppMethodBeat.o(159882);
  }
  
  public final void cRT()
  {
    AppMethodBeat.i(159881);
    jJp();
    jJq();
    if (this.agoQ != null) {
      this.agoQ.dismiss();
    }
    AppMethodBeat.o(159881);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(159880);
    this.agoV = false;
    this.aUP = true;
    this.aggl = false;
    this.agoP.removeCallbacks(this.aggv);
    this.agoP.getViewTreeObserver().removeOnScrollChangedListener(this.aggc);
    this.agoP.getViewTreeObserver().removeOnPreDrawListener(this.cfn);
    this.agoP.getViewTreeObserver().removeOnGlobalLayoutListener(this.qZ);
    this.agoP.removeOnAttachStateChangeListener(this.mB);
    this.agoW = true;
    this.agoX = true;
    cRT();
    cRQ();
    this.agoL = null;
    this.agoM = null;
    if (this.agoQ != null) {
      this.agoQ.dismiss();
    }
    AppMethodBeat.o(159880);
  }
  
  public final void gc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159892);
    if (paramInt1 != -1) {
      this.agoN.uG = cY(paramInt1, true);
    }
    if (paramInt2 != -1) {
      this.agoN.uH = cY(paramInt2, false);
    }
    if ((this.agoN.uG < 0) || (this.agoN.uG > b.mu(this.agoP).length()))
    {
      AppMethodBeat.o(159892);
      return;
    }
    if ((this.agoN.uH < 0) || (this.agoN.uH > b.mu(this.agoP).length()))
    {
      AppMethodBeat.o(159892);
      return;
    }
    if (this.agoN.uG > this.agoN.uH)
    {
      paramInt1 = this.agoN.uG;
      this.agoN.uG = this.agoN.uH;
      this.agoN.uH = paramInt1;
    }
    if (this.afXs != null)
    {
      this.agoN.aggI = this.afXs.subSequence(this.agoN.uG, this.agoN.uH).toString();
      if (this.agoT == null) {
        break label314;
      }
      this.agoT.od(this.agoN.uG, this.agoN.uH);
    }
    for (;;)
    {
      paramInt1 = b.bw(this.agoP, this.agoN.uG);
      paramInt1 = b.bB(this.agoP, paramInt1);
      this.afXs.setSpan(this.agoT, paramInt1, this.agoN.uH, 17);
      if (this.agoO != null) {
        this.agoO.aV(this.agoN.aggI);
      }
      AppMethodBeat.o(159892);
      return;
      label314:
      this.agoT = new c(this.agoP, this.mContext.getResources().getColor(this.aggi), this.agoN.uG, this.agoN.uH);
    }
  }
  
  public final void jJo()
  {
    AppMethodBeat.i(159886);
    if (!cEs())
    {
      a(this.agoL);
      a(this.agoM);
    }
    AppMethodBeat.o(159886);
  }
  
  public final void jJp()
  {
    AppMethodBeat.i(159887);
    if (this.agoL != null) {
      this.agoL.aggz.dismiss();
    }
    if (this.agoM != null) {
      this.agoM.aggz.dismiss();
    }
    AppMethodBeat.o(159887);
  }
  
  public final void jJq()
  {
    AppMethodBeat.i(159888);
    if (this.agoS != null) {
      this.agoS.diW();
    }
    AppMethodBeat.o(159888);
  }
  
  public final void jJr()
  {
    AppMethodBeat.i(159889);
    if (this.agoQ != null) {
      this.agoQ.ls(this.agoP);
    }
    AppMethodBeat.o(159889);
  }
  
  public final void jJs()
  {
    AppMethodBeat.i(159890);
    if (this.agoQ != null) {
      this.agoQ.dismiss();
    }
    AppMethodBeat.o(159890);
  }
  
  public final void jJt()
  {
    AppMethodBeat.i(159891);
    int i;
    int j;
    if (this.agoS != null)
    {
      int[] arrayOfInt = new int[2];
      this.agoP.getLocationInWindow(arrayOfInt);
      float f3 = b.bx(this.agoP, this.agoN.uG);
      float f2 = b.bx(this.agoP, this.agoN.uH);
      i = b.bw(this.agoP, this.agoN.uG);
      float f1;
      if (b.bw(this.agoP, this.agoN.uH) <= i)
      {
        f1 = f2;
        if (f2 > f3) {}
      }
      else
      {
        f1 = b.bA(this.agoP, b.bw(this.agoP, this.agoN.uG));
      }
      i = (int)((f1 + f3) / 2.0F);
      j = this.Ips + i;
      int k = b.by(this.agoP, b.bw(this.agoP, this.agoN.uG)) + arrayOfInt[1] + this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.ck.a.d.edgePadding);
      bc.d("SelectableTextHelper", "dancy test posX:%s, startline:%s, endline:%s, leftpadding:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(b.bw(this.agoP, this.agoN.uG)), Integer.valueOf(b.bw(this.agoP, this.agoN.uH)), Integer.valueOf(this.Ips) });
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
      this.agoS.fQ(i, j);
      if (this.agoQ != null) {
        this.agoQ.jxo();
      }
      AppMethodBeat.o(159891);
      return;
    }
  }
  
  final void pc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159883);
    cRQ();
    if ((b.mu(this.agoP) instanceof Spannable)) {
      this.afXs = ((Spannable)b.mu(this.agoP));
    }
    if ((this.afXs == null) || (paramInt1 >= b.mu(this.agoP).length()))
    {
      this.agoN.uG = 0;
      this.agoN.uH = 0;
      AppMethodBeat.o(159883);
      return;
    }
    gc(paramInt1, paramInt2);
    AppMethodBeat.o(159883);
  }
  
  public static final class a
  {
    public int aggi = com.tencent.mm.ck.a.c.selected_blue;
    public int aggj = com.tencent.mm.ck.a.c.cursor_handle_color;
    View agoP;
    a.f agoQ;
    View.OnTouchListener agoR;
    com.tencent.mm.ui.widget.b.a agpf;
    public int agpg = 0;
    public int agph = 0;
    View.OnClickListener mWW;
    
    private a(View paramView, com.tencent.mm.ui.widget.b.a parama)
    {
      this.agoP = paramView;
      this.agpf = parama;
    }
    
    public a(View paramView, com.tencent.mm.ui.widget.b.a parama, a.f paramf, View.OnClickListener paramOnClickListener, View.OnTouchListener paramOnTouchListener)
    {
      this(paramView, parama);
      this.agoQ = paramf;
      this.mWW = paramOnClickListener;
      this.agoR = paramOnTouchListener;
    }
    
    public final a jJu()
    {
      AppMethodBeat.i(159863);
      a locala = new a(this);
      AppMethodBeat.o(159863);
      return locala;
    }
  }
  
  final class b
    extends View
  {
    private int JoA;
    private int JoB;
    private int[] JoC;
    int[] agcv;
    boolean aggA;
    private int aggB;
    private int aggC;
    PopupWindow aggz;
    private boolean agpi;
    int ebX;
    private int mHeight;
    private Paint mPaint;
    int mWidth;
    private Rect rect;
    private Point tKS;
    private int xAB;
    
    b(boolean paramBoolean)
    {
      super();
      AppMethodBeat.i(159864);
      this.xAB = (a.this.aggk / 2);
      this.mWidth = (this.xAB * 2);
      this.mHeight = (this.xAB * 2);
      this.ebX = 20;
      this.agcv = new int[2];
      this.rect = new Rect();
      this.tKS = new Point();
      this.agpi = false;
      this.JoC = new int[2];
      this.aggA = paramBoolean;
      this.mPaint = new Paint(1);
      this.mPaint.setColor(a.this.mContext.getResources().getColor(a.this.aggj));
      this.aggz = new PopupWindow(this);
      this.aggz.setClippingEnabled(false);
      this.aggz.setWidth(this.mWidth + this.ebX * 3);
      this.aggz.setHeight(this.mHeight + this.ebX * 2);
      AppMethodBeat.o(159864);
    }
    
    private void jHW()
    {
      AppMethodBeat.i(159867);
      if (!this.aggA) {}
      for (boolean bool = true;; bool = false)
      {
        this.aggA = bool;
        invalidate();
        AppMethodBeat.o(159867);
        return;
      }
    }
    
    private void jHX()
    {
      AppMethodBeat.i(159869);
      a.this.agoP.getLocationInWindow(this.agcv);
      Object localObject = b.mv(a.this.agoP);
      if (localObject != null)
      {
        int i = (int)((TextPaint)localObject).getFontMetrics().descent;
        if (this.aggA)
        {
          this.aggz.update((int)b.bx(a.this.agoP, a.this.agoN.uG) - this.mWidth + getExtraX(), i + b.bv(a.this.agoP, b.bw(a.this.agoP, a.this.agoN.uG)) + getExtraY(), -1, -1);
          AppMethodBeat.o(159869);
          return;
        }
        localObject = pd((int)b.bx(a.this.agoP, a.this.agoN.uH), i + b.bv(a.this.agoP, b.bw(a.this.agoP, a.this.agoN.uH)));
        i = localObject[0];
        int j = this.ebX;
        int k = localObject[1];
        this.aggz.update(i + j + getExtraX(), k + getExtraY(), -1, -1);
      }
      AppMethodBeat.o(159869);
    }
    
    private void mq(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159868);
      a.this.agoP.getLocationInWindow(this.agcv);
      int i;
      b localb;
      if (this.aggA)
      {
        i = a.this.agoN.uG;
        int j = this.agcv[1];
        paramInt1 = b.h(a.this.agoP, paramInt1, paramInt2 - j, i);
        if (paramInt1 == i) {
          break label225;
        }
        a.this.cRQ();
        if (!this.aggA) {
          break label169;
        }
        if (paramInt1 <= this.aggC) {
          break label157;
        }
        localb = a.a(a.this, false);
        jHW();
        localb.jHW();
        this.aggB = this.aggC;
        a.this.gc(this.aggC, paramInt1);
        localb.jHX();
      }
      for (;;)
      {
        jHX();
        AppMethodBeat.o(159868);
        return;
        i = a.this.agoN.uH;
        break;
        label157:
        a.this.gc(paramInt1, -1);
      }
      label169:
      if (paramInt1 < this.aggB)
      {
        localb = a.a(a.this, true);
        localb.jHW();
        jHW();
        this.aggC = this.aggB;
        a.this.gc(paramInt1, this.aggB);
        localb.jHX();
      }
      for (;;)
      {
        jHX();
        label225:
        AppMethodBeat.o(159868);
        return;
        a.this.gc(this.aggB, paramInt1);
      }
    }
    
    public final int getExtraX()
    {
      AppMethodBeat.i(159870);
      int i = this.agcv[0];
      int j = this.ebX;
      int k = a.this.agoP.getPaddingLeft();
      AppMethodBeat.o(159870);
      return i - j * 2 + k;
    }
    
    public final int getExtraY()
    {
      AppMethodBeat.i(159871);
      int i = this.agcv[1];
      int j = a.this.agoP.getPaddingTop();
      AppMethodBeat.o(159871);
      return i + j;
    }
    
    protected final void onDraw(Canvas paramCanvas)
    {
      AppMethodBeat.i(159865);
      int i;
      int j;
      int k;
      if (a.this.agoQ != null) {
        if (this.aggA)
        {
          i = a.this.agoN.uG;
          TextPaint localTextPaint = b.mv(a.this.agoP);
          if (localTextPaint == null) {
            break label519;
          }
          j = b.bv(a.this.agoP, b.bw(a.this.agoP, i));
          j = (int)localTextPaint.getFontMetrics().descent + j;
          k = (int)b.bx(a.this.agoP, i);
          i = j;
          j = k;
        }
      }
      for (;;)
      {
        a.this.agoP.getLocationInWindow(this.agcv);
        k = i;
        if (!this.aggA) {
          k = pd(j, i)[1];
        }
        i = getExtraY() + k;
        if (a.this.agoP.getGlobalVisibleRect(this.rect, this.tKS))
        {
          if (i >= this.rect.bottom)
          {
            if (this.aggA)
            {
              bc.d("SelectableTextHelper", "start below bottom, dismiss all.", new Object[0]);
              a.this.cRQ();
              a.this.agoW = true;
              a.this.agoX = true;
              a.this.cRT();
              a.this.agoQ.dismiss();
            }
            bc.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
            AppMethodBeat.o(159865);
            return;
            i = a.this.agoN.uH;
            break;
          }
          if (i > this.rect.top) {
            break label373;
          }
          if (!this.aggA)
          {
            bc.d("SelectableTextHelper", "end above top, dismiss all.", new Object[0]);
            a.this.cRQ();
            a.this.agoW = true;
            a.this.agoX = true;
            a.this.cRT();
            a.this.agoQ.dismiss();
          }
          bc.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
          AppMethodBeat.o(159865);
          return;
        }
        bc.d("SelectableTextHelper", "view invisible.", new Object[0]);
        AppMethodBeat.o(159865);
        return;
        label373:
        if (this.aggA)
        {
          paramCanvas.drawCircle(this.xAB + this.ebX * 2, this.xAB, this.xAB, this.mPaint);
          paramCanvas.drawRect(this.xAB + this.ebX * 2, 0.0F, this.xAB * 2 + this.ebX * 2, this.xAB, this.mPaint);
          AppMethodBeat.o(159865);
          return;
        }
        paramCanvas.drawCircle(this.xAB + this.ebX, this.xAB, this.xAB, this.mPaint);
        paramCanvas.drawRect(this.ebX, 0.0F, this.xAB + this.ebX, this.xAB, this.mPaint);
        AppMethodBeat.o(159865);
        return;
        label519:
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
        this.aggB = a.this.agoN.uG;
        this.aggC = a.this.agoN.uH;
        this.JoA = ((int)paramMotionEvent.getX());
        this.JoB = ((int)paramMotionEvent.getY());
        this.agpi = false;
        a.this.agoP.getLocationOnScreen(this.JoC);
        continue;
        if ((a.this.agoQ != null) && (!this.agpi))
        {
          this.agpi = true;
          a.this.agoQ.jxm();
          if (a.this.agoN.uH - a.this.agoN.uG == b.mu(a.this.agoP).length())
          {
            a.this.agoQ.ls(a.this.agoP);
            a.this.agoW = true;
            a.this.jJq();
          }
          for (;;)
          {
            a.this.agoQ.jxn();
            break;
            a.this.agoQ.dismiss();
            a.this.agoW = false;
            a.this.jJt();
          }
        }
        if (!a.this.agoW)
        {
          a.this.jJt();
          continue;
          if (a.this.agoQ != null)
          {
            a.this.agoQ.jxm();
            a.this.agoQ.dismiss();
          }
          a.this.jJq();
          int i = (int)paramMotionEvent.getRawX();
          int j = (int)paramMotionEvent.getRawY();
          if (a.this.agoQ == null) {
            mq(i - this.JoC[0], j + this.JoB - this.mHeight - a.this.aggm);
          }
          for (;;)
          {
            if (a.this.agoQ == null) {
              break label430;
            }
            a.this.agoQ.jxn();
            break;
            mq(i - this.JoC[0] + this.xAB, j + this.JoB - this.mHeight - a.this.aggm);
          }
        }
      }
    }
    
    final int[] pd(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159872);
      int j = paramInt1;
      int i = paramInt2;
      if (paramInt1 == 0)
      {
        j = paramInt1;
        i = paramInt2;
        if (a.this.agoN.uH > 1)
        {
          a.this.agoP.getLocationInWindow(this.agcv);
          TextPaint localTextPaint = b.mv(a.this.agoP);
          j = paramInt1;
          i = paramInt2;
          if (localTextPaint != null)
          {
            paramInt1 = (int)localTextPaint.getFontMetrics().descent;
            paramInt2 = b.bw(a.this.agoP, a.this.agoN.uH - 1);
            j = (int)b.bA(a.this.agoP, paramInt2);
            i = b.bv(a.this.agoP, b.bw(a.this.agoP, a.this.agoN.uH - 1)) + paramInt1;
          }
        }
      }
      AppMethodBeat.o(159872);
      return new int[] { j, i };
    }
  }
  
  final class c
  {
    int end;
    int start;
    
    c() {}
    
    final boolean Wh(int paramInt)
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
  
  public static abstract interface d
  {
    public abstract void aV(CharSequence paramCharSequence);
  }
  
  public static abstract interface e
  {
    public abstract void jxt();
  }
  
  public static abstract class f
  {
    public void dismiss() {}
    
    public void ft(View paramView) {}
    
    public void jxm() {}
    
    public void jxn() {}
    
    public void jxo() {}
    
    public void ls(View paramView) {}
  }
  
  final class g
  {
    String aggI;
    int uG;
    int uH;
    
    g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a
 * JD-Core Version:    0.7.0.1
 */