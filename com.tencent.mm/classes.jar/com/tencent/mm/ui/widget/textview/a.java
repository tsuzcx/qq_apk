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
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.c;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  private ViewTreeObserver.OnPreDrawListener Bf;
  View.OnTouchListener CBc;
  int[] JWH;
  b LBY;
  private b LBZ;
  ArrayList<c> LCA;
  g LCa;
  public d LCb;
  View LCc;
  public f LCd;
  View.OnTouchListener LCe;
  private Spannable LCf;
  private com.tencent.mm.ui.widget.b.a LCg;
  int LCh;
  int LCi;
  private int LCj;
  int LCk;
  int LCl;
  private c LCm;
  int LCn;
  public int LCo;
  private ViewTreeObserver.OnScrollChangedListener LCp;
  boolean LCq;
  boolean LCr;
  public boolean LCs;
  public boolean LCt;
  boolean LCu;
  boolean LCv;
  boolean LCw;
  final Runnable LCx;
  final Runnable LCy;
  public e LCz;
  private boolean aMv;
  private View.OnAttachStateChangeListener afj;
  private ViewTreeObserver.OnGlobalLayoutListener ajt;
  View.OnClickListener gON;
  Context mContext;
  int[] uOq;
  private int zaZ;
  
  public a(a parama)
  {
    AppMethodBeat.i(159878);
    this.LCa = new g();
    this.zaZ = 0;
    this.LCq = false;
    this.aMv = true;
    this.LCr = false;
    this.LCs = true;
    this.LCt = true;
    this.LCu = true;
    this.LCv = false;
    this.LCw = false;
    this.uOq = new int[2];
    this.LCx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159850);
        if (a.this.LCq)
        {
          ap.d("SelectableTextHelper", "isReInit, return.", new Object[0]);
          AppMethodBeat.o(159850);
          return;
        }
        ap.d("SelectableTextHelper", "in mShowSelectViewRunnable. opener: %s, inScrolling: %s.", new Object[] { Boolean.valueOf(a.this.LCu), Boolean.valueOf(a.this.LCv) });
        if (a.this.LCd != null)
        {
          if (!a.this.LCu)
          {
            a.this.LCu = true;
            if (a.this.LCv)
            {
              ap.d("SelectableTextHelper", "menu is hide: %s, cursor is hide: %s.", new Object[] { Boolean.valueOf(a.this.LCs), Boolean.valueOf(a.this.LCt) });
              if (!a.this.LCs) {
                a.this.fRV();
              }
              if (!a.this.LCt)
              {
                a.this.fRQ();
                a.this.kw(a.this.LCa.avj, a.this.LCa.OQ);
              }
              if ((a.this.LCd != null) && (a.this.LCs) && (!a.this.LCt)) {
                a.this.LCd.gu(a.this.LCc);
              }
            }
            a.this.LCv = false;
            AppMethodBeat.o(159850);
            return;
          }
          if (a.this.LCw)
          {
            a.this.LCw = false;
            ap.d("SelectableTextHelper", "judge result(delay), click outside.", new Object[0]);
            if (a.this.LCz != null)
            {
              a.this.LCz.fLJ();
              AppMethodBeat.o(159850);
            }
          }
          else
          {
            ap.d("SelectableTextHelper", "Oh, bypass the judge logic! Don't worry, that's reasonable.", new Object[0]);
            AppMethodBeat.o(159850);
          }
        }
        else
        {
          if (!a.this.LCs) {
            a.this.fRV();
          }
          if (!a.this.LCt) {
            a.this.fRQ();
          }
        }
        AppMethodBeat.o(159850);
      }
    };
    this.LCy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159854);
        ap.d("SelectableTextHelper", "dismiss all runnable.", new Object[0]);
        if (a.this.LCz != null) {
          a.this.LCz.fLJ();
        }
        AppMethodBeat.o(159854);
      }
    };
    this.JWH = new int[2];
    this.LCc = parama.LCc;
    this.LCd = parama.LCd;
    this.gON = parama.gON;
    this.LCe = parama.LCe;
    this.LCg = parama.LCC;
    this.zaZ = parama.LCE;
    this.mContext = this.LCc.getContext();
    this.LCj = parama.LCj;
    this.LCk = parama.LCk;
    Object localObject = this.LCc;
    int i;
    float f;
    if ((localObject instanceof NeatTextView))
    {
      i = ((NeatTextView)localObject).getLineHeight();
      this.LCn = i;
      if (this.LCl != 0) {
        break label387;
      }
      parama = this.LCc;
      if (!(parama instanceof NeatTextView)) {
        break label364;
      }
      f = ((NeatTextView)parama).getTextSize();
    }
    label234:
    for (this.LCl = ((int)f);; this.LCl = aq.fromDPToPix(this.mContext, parama.LCD))
    {
      this.afj = new View.OnAttachStateChangeListener()
      {
        public final void onViewAttachedToWindow(View paramAnonymousView)
        {
          AppMethodBeat.i(159855);
          ap.d("SelectableTextHelper", "onViewAttachedToWindow", new Object[0]);
          AppMethodBeat.o(159855);
        }
        
        public final void onViewDetachedFromWindow(View paramAnonymousView)
        {
          AppMethodBeat.i(159856);
          ap.d("SelectableTextHelper", "onViewDetachedFromWindow", new Object[0]);
          a.this.destroy();
          AppMethodBeat.o(159856);
        }
      };
      this.Bf = new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(159857);
          if (a.this.LCr)
          {
            a.this.LCr = false;
            a locala = a.this;
            locala.LCc.removeCallbacks(locala.LCx);
            locala.LCc.postDelayed(locala.LCx, 100L);
          }
          AppMethodBeat.o(159857);
          return true;
        }
      };
      this.LCp = new ViewTreeObserver.OnScrollChangedListener()
      {
        public final void onScrollChanged()
        {
          AppMethodBeat.i(159858);
          if (a.this.LCd != null)
          {
            a.this.LCc.removeCallbacks(a.this.LCy);
            a.this.LCc.getLocationInWindow(a.this.JWH);
            ap.d("SelectableTextHelper", "onScrollChanged, old-y: %d, y: %d.", new Object[] { Integer.valueOf(a.this.uOq[1]), Integer.valueOf(a.this.JWH[1]) });
            if (a.this.LCu)
            {
              if ((a.this.LCv) || (a.this.LCw)) {
                break label260;
              }
              if (a.this.uOq[1] == a.this.JWH[1]) {
                break label238;
              }
              a.this.LCv = true;
              a.this.LCu = false;
              ap.d("SelectableTextHelper", "judge result, inScrolling.", new Object[0]);
            }
          }
          for (;;)
          {
            a.this.uOq[1] = a.this.JWH[1];
            if ((!a.this.LCr) && ((!a.this.LCs) || (!a.this.LCt)))
            {
              a.this.LCr = true;
              a.this.fRN();
            }
            AppMethodBeat.o(159858);
            return;
            label238:
            a.this.LCw = true;
            ap.d("SelectableTextHelper", "need delay judge.", new Object[0]);
            continue;
            label260:
            if (a.this.LCw)
            {
              a.this.LCw = false;
              a.this.LCu = false;
              if (a.this.uOq[1] != a.this.JWH[1])
              {
                a.this.LCv = true;
                ap.d("SelectableTextHelper", "judge result(delay), inScrolling.", new Object[0]);
              }
              else
              {
                a.this.LCv = false;
                ap.d("SelectableTextHelper", "judge result, click outside.", new Object[0]);
              }
            }
          }
        }
      };
      this.ajt = new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(159859);
          ap.d("SelectableTextHelper", "onGlobalLayout", new Object[0]);
          AppMethodBeat.o(159859);
        }
      };
      this.CBc = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(159860);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/textview/SelectableTextHelper$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          ap.d("SelectableTextHelper", "event pointer count: %d.", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getPointerCount()) });
          if (a.this.LCe != null) {
            a.this.LCe.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          }
          a.this.LCh = ((int)paramAnonymousMotionEvent.getX());
          a.this.LCi = ((int)paramAnonymousMotionEvent.getY());
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/textview/SelectableTextHelper$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(159860);
          return false;
        }
      };
      if (this.aMv) {
        break label405;
      }
      ap.d("SelectableTextHelper", "not destroy, isReInit: %s.", new Object[] { Boolean.valueOf(this.LCq) });
      this.LCq = true;
      AppMethodBeat.o(159878);
      return;
      if ((localObject instanceof TextView))
      {
        i = ((TextView)localObject).getLineHeight();
        break;
      }
      i = 0;
      break;
      label364:
      if ((parama instanceof TextView))
      {
        f = ((TextView)parama).getTextSize();
        break label234;
      }
      f = 0.0F;
      break label234;
    }
    label387:
    label405:
    ap.d("SelectableTextHelper", "not init yet, need to init.", new Object[0]);
    this.LCq = false;
    this.aMv = false;
    this.LCr = false;
    TextView.BufferType localBufferType;
    if (this.LCd == null)
    {
      parama = this.LCc;
      localObject = b.hm(this.LCc);
      localBufferType = TextView.BufferType.SPANNABLE;
      if (!(parama instanceof NeatTextView)) {
        break label685;
      }
      ((NeatTextView)parama).a((CharSequence)localObject, localBufferType);
    }
    for (;;)
    {
      this.LBY = new b(true);
      if (this.LCd != null)
      {
        this.LBY.mPopupWindow.setOutsideTouchable(true);
        parama = this.LBY;
        localObject = new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(159861);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/textview/SelectableTextHelper$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
            ap.d("SelectableTextHelper", "interceptor onTouch.", new Object[0]);
            int i = (int)paramAnonymousMotionEvent.getX();
            int j = (int)paramAnonymousMotionEvent.getY();
            if ((paramAnonymousMotionEvent.getAction() == 0) && ((i < 0) || (i >= a.this.LBY.getWidth()) || (j < 0) || (j >= a.this.LBY.getHeight())))
            {
              ap.d("SelectableTextHelper", "interceptor onTouch, down, outside.", new Object[0]);
              a.this.LCc.postDelayed(a.this.LCy, 100L);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/textview/SelectableTextHelper$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(159861);
              return true;
            }
            if (paramAnonymousMotionEvent.getAction() == 4)
            {
              ap.d("SelectableTextHelper", "interceptor onTouch, outside.", new Object[0]);
              a.this.LCc.postDelayed(a.this.LCy, 100L);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/textview/SelectableTextHelper$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(159861);
              return true;
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/textview/SelectableTextHelper$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(159861);
            return false;
          }
        };
        parama.mPopupWindow.setTouchInterceptor((View.OnTouchListener)localObject);
        parama = this.LBY;
        localObject = new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(159862);
            a.this.LCc.setOnTouchListener(a.this.CBc);
            AppMethodBeat.o(159862);
          }
        };
        parama.mPopupWindow.setOnDismissListener((PopupWindow.OnDismissListener)localObject);
      }
      this.LBZ = new b(false);
      this.LCc.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159851);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/textview/SelectableTextHelper$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
          ap.d("SelectableTextHelper", "onLongClick.", new Object[0]);
          a.this.LCq = false;
          int j;
          if (a.this.LCd != null)
          {
            a.this.LCu = true;
            a.this.LCv = false;
            a.this.LCw = false;
            Object localObject2 = b.hm(a.this.LCc);
            if ((localObject2 instanceof SpannableString))
            {
              localObject1 = a.this;
              localObject2 = (SpannableString)localObject2;
              ((a)localObject1).LCA = new ArrayList();
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
                  ((a)localObject1).LCA.add(localObject3);
                }
                for (;;)
                {
                  ap.d("SelectableTextHelper", "spans from %d to %d.", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
                  i = j;
                  break;
                  ap.e("SelectableTextHelper", "other situation occur! length: %d.", new Object[] { Integer.valueOf(localObject3.length) });
                }
              }
              ap.d("SelectableTextHelper", ((a)localObject1).LCA.toString(), new Object[0]);
            }
            a.this.fRN();
            if ((a.this.LCo > 0) && (a.this.LCo < b.hm(a.this.LCc).length()))
            {
              a.a(a.this, a.this.LCo);
              a.this.LCs = false;
              a.this.LCt = false;
              a.this.fRV();
              a.this.fRQ();
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/textview/SelectableTextHelper$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(159851);
              return true;
              a.a(a.this, b.hm(a.this.LCc).length());
              a.this.LCs = true;
              a.this.LCt = false;
              a.this.fRQ();
              a.this.LCd.gv(paramAnonymousView);
            }
          }
          a.this.LCu = false;
          paramAnonymousView = a.this;
          int k = a.this.LCh;
          int i = a.this.LCi;
          localObject1 = paramAnonymousView.LCc;
          if ((localObject1 instanceof NeatTextView))
          {
            localObject1 = ((NeatTextView)localObject1).getLayout();
            if (localObject1 == null) {
              break label635;
            }
            i = ((com.tencent.neattextview.textview.layout.a)localObject1).kO(k, i);
          }
          for (;;)
          {
            paramAnonymousView.kv(i, i + 1);
            a.this.fRN();
            a.this.LCs = false;
            a.this.LCt = false;
            a.this.fRV();
            a.this.fRQ();
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
      this.LCc.setOnTouchListener(this.CBc);
      this.LCc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159852);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/textview/SelectableTextHelper$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ap.d("SelectableTextHelper", "onClick", new Object[0]);
          if (a.this.gON != null) {
            a.this.gON.onClick(paramAnonymousView);
          }
          a.this.LCs = true;
          a.this.LCt = true;
          a.this.fRN();
          a.this.fRO();
          if (a.this.LCd != null) {
            a.this.LCd.dismiss();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/textview/SelectableTextHelper$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(159852);
        }
      });
      this.LCc.addOnAttachStateChangeListener(this.afj);
      this.LCc.getViewTreeObserver().addOnPreDrawListener(this.Bf);
      this.LCc.getViewTreeObserver().addOnScrollChangedListener(this.LCp);
      this.LCc.getViewTreeObserver().addOnGlobalLayoutListener(this.ajt);
      this.LCc.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(159853);
          a.this.LCc.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          if (a.this.LCd != null)
          {
            a.this.LCc.getLocationInWindow(a.this.uOq);
            ap.d("SelectableTextHelper", "init: loc-x: %d, loc-y: %d.", new Object[] { Integer.valueOf(a.this.uOq[0]), Integer.valueOf(a.this.uOq[1]) });
          }
          AppMethodBeat.o(159853);
        }
      });
      AppMethodBeat.o(159878);
      return;
      label685:
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
    for (int i = this.LCa.avj; (i < 0) || (i > b.hm(this.LCc).length()); i = this.LCa.OQ)
    {
      AppMethodBeat.o(159884);
      return;
    }
    Object localObject = b.hn(this.LCc);
    int j;
    if (localObject != null)
    {
      j = (int)((TextPaint)localObject).getFontMetrics().descent + b.aL(this.LCc, b.aM(this.LCc, i));
      i = (int)b.aN(this.LCc, i);
    }
    for (;;)
    {
      paramb.LCB.LCc.getLocationInWindow(paramb.LCK);
      if (paramb.LCF) {}
      for (int k = paramb.mWidth;; k = 0)
      {
        int n = i;
        int m = j;
        if (!paramb.LCF)
        {
          localObject = paramb.kx(i, j);
          n = localObject[0];
          m = localObject[1];
        }
        try
        {
          paramb.mPopupWindow.showAtLocation(paramb.LCB.LCc, 0, n - k + paramb.fRZ(), m + paramb.fSa());
          AppMethodBeat.o(159884);
          return;
        }
        catch (Exception paramb)
        {
          ap.e("SelectableTextHelper", "error! message: %s.", new Object[] { paramb.getMessage() });
          AppMethodBeat.o(159884);
          return;
        }
      }
      i = 0;
      j = 0;
    }
  }
  
  private int bv(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(159893);
    if (this.LCA != null)
    {
      Iterator localIterator = this.LCA.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.Hm(paramInt))
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
  
  private boolean fRP()
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
    this.LCq = false;
    this.aMv = true;
    this.LCr = false;
    this.LCc.removeCallbacks(this.LCx);
    this.LCc.getViewTreeObserver().removeOnScrollChangedListener(this.LCp);
    this.LCc.getViewTreeObserver().removeOnPreDrawListener(this.Bf);
    this.LCc.getViewTreeObserver().removeOnGlobalLayoutListener(this.ajt);
    this.LCc.removeOnAttachStateChangeListener(this.afj);
    this.LCs = true;
    this.LCt = true;
    fRN();
    fRO();
    this.LBY = null;
    this.LBZ = null;
    if (this.LCd != null) {
      this.LCd.dismiss();
    }
    AppMethodBeat.o(159880);
  }
  
  public final void fRN()
  {
    AppMethodBeat.i(159881);
    fRR();
    fRS();
    if (this.LCd != null) {
      this.LCd.dismiss();
    }
    AppMethodBeat.o(159881);
  }
  
  public final void fRO()
  {
    AppMethodBeat.i(159882);
    this.LCa.LCM = null;
    if ((this.LCf != null) && (this.LCm != null))
    {
      this.LCf.removeSpan(this.LCm);
      this.LCm = null;
    }
    AppMethodBeat.o(159882);
  }
  
  public final void fRQ()
  {
    AppMethodBeat.i(159886);
    if (!fRP())
    {
      a(this.LBY);
      a(this.LBZ);
    }
    AppMethodBeat.o(159886);
  }
  
  public final void fRR()
  {
    AppMethodBeat.i(159887);
    if (this.LBY != null) {
      this.LBY.mPopupWindow.dismiss();
    }
    if (this.LBZ != null) {
      this.LBZ.mPopupWindow.dismiss();
    }
    AppMethodBeat.o(159887);
  }
  
  public final void fRS()
  {
    AppMethodBeat.i(159888);
    if (this.LCg != null) {
      this.LCg.fFi();
    }
    AppMethodBeat.o(159888);
  }
  
  public final void fRT()
  {
    AppMethodBeat.i(159889);
    if (this.LCd != null) {
      this.LCd.gu(this.LCc);
    }
    AppMethodBeat.o(159889);
  }
  
  public final void fRU()
  {
    AppMethodBeat.i(159890);
    if (this.LCd != null) {
      this.LCd.dismiss();
    }
    AppMethodBeat.o(159890);
  }
  
  public final void fRV()
  {
    AppMethodBeat.i(159891);
    int i;
    int j;
    if (this.LCg != null)
    {
      int[] arrayOfInt = new int[2];
      this.LCc.getLocationInWindow(arrayOfInt);
      float f3 = b.aN(this.LCc, this.LCa.avj);
      float f2 = b.aN(this.LCc, this.LCa.OQ);
      i = b.aM(this.LCc, this.LCa.avj);
      float f1;
      if (b.aM(this.LCc, this.LCa.OQ) <= i)
      {
        f1 = f2;
        if (f2 > f3) {}
      }
      else
      {
        f1 = b.aQ(this.LCc, b.aM(this.LCc, this.LCa.avj));
      }
      i = (int)((f1 + f3) / 2.0F);
      j = this.zaZ + i;
      int k = b.aO(this.LCc, b.aM(this.LCc, this.LCa.avj)) + arrayOfInt[1] + this.mContext.getResources().getDimensionPixelSize(2131166166);
      ap.d("SelectableTextHelper", "dancy test posX:%s, startline:%s, endline:%s, leftpadding:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(b.aM(this.LCc, this.LCa.avj)), Integer.valueOf(b.aM(this.LCc, this.LCa.OQ)), Integer.valueOf(this.zaZ) });
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
      this.LCg.el(i, j);
      if (this.LCd != null) {
        this.LCd.fLF();
      }
      AppMethodBeat.o(159891);
      return;
    }
  }
  
  final void kv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159883);
    fRO();
    if ((b.hm(this.LCc) instanceof Spannable)) {
      this.LCf = ((Spannable)b.hm(this.LCc));
    }
    if ((this.LCf == null) || (paramInt1 >= b.hm(this.LCc).length()))
    {
      this.LCa.avj = 0;
      this.LCa.OQ = 0;
      AppMethodBeat.o(159883);
      return;
    }
    kw(paramInt1, paramInt2);
    AppMethodBeat.o(159883);
  }
  
  public final void kw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159892);
    if (paramInt1 != -1) {
      this.LCa.avj = bv(paramInt1, true);
    }
    if (paramInt2 != -1) {
      this.LCa.OQ = bv(paramInt2, false);
    }
    if ((this.LCa.avj < 0) || (this.LCa.avj > b.hm(this.LCc).length()))
    {
      AppMethodBeat.o(159892);
      return;
    }
    if ((this.LCa.OQ < 0) || (this.LCa.OQ > b.hm(this.LCc).length()))
    {
      AppMethodBeat.o(159892);
      return;
    }
    if (this.LCa.avj > this.LCa.OQ)
    {
      paramInt1 = this.LCa.avj;
      this.LCa.avj = this.LCa.OQ;
      this.LCa.OQ = paramInt1;
    }
    if (this.LCf != null)
    {
      this.LCa.LCM = this.LCf.subSequence(this.LCa.avj, this.LCa.OQ).toString();
      if (this.LCm == null) {
        break label314;
      }
      this.LCm.setPosition(this.LCa.avj, this.LCa.OQ);
    }
    for (;;)
    {
      paramInt1 = b.aM(this.LCc, this.LCa.avj);
      paramInt1 = b.aR(this.LCc, paramInt1);
      this.LCf.setSpan(this.LCm, paramInt1, this.LCa.OQ, 17);
      if (this.LCb != null) {
        this.LCb.am(this.LCa.LCM);
      }
      AppMethodBeat.o(159892);
      return;
      label314:
      this.LCm = new c(this.LCc, this.mContext.getResources().getColor(this.LCj), this.LCa.avj, this.LCa.OQ);
    }
  }
  
  public static final class a
  {
    com.tencent.mm.ui.widget.b.a LCC;
    public int LCD = 0;
    public int LCE = 0;
    View LCc;
    a.f LCd;
    View.OnTouchListener LCe;
    public int LCj = 2131100846;
    public int LCk = 2131100195;
    View.OnClickListener gON;
    
    public a(View paramView, com.tencent.mm.ui.widget.b.a parama)
    {
      this.LCc = paramView;
      this.LCC = parama;
    }
    
    public a(View paramView, com.tencent.mm.ui.widget.b.a parama, a.f paramf, View.OnClickListener paramOnClickListener, View.OnTouchListener paramOnTouchListener)
    {
      this(paramView, parama);
      this.LCd = paramf;
      this.gON = paramOnClickListener;
      this.LCe = paramOnTouchListener;
    }
    
    public final a fRW()
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
    private int[] JWH;
    boolean LCF;
    private int LCG;
    private int LCH;
    private int LCI;
    private int LCJ;
    int[] LCK;
    private boolean LCL;
    private int mHeight;
    private int mPadding;
    private Paint mPaint;
    PopupWindow mPopupWindow;
    int mWidth;
    private Point mtn;
    private int pCG;
    private Rect rect;
    
    b(boolean paramBoolean)
    {
      super();
      AppMethodBeat.i(159864);
      this.pCG = (a.this.LCl / 2);
      this.mWidth = (this.pCG * 2);
      this.mHeight = (this.pCG * 2);
      this.mPadding = 25;
      this.LCK = new int[2];
      this.rect = new Rect();
      this.mtn = new Point();
      this.LCL = false;
      this.JWH = new int[2];
      this.LCF = paramBoolean;
      this.mPaint = new Paint(1);
      this.mPaint.setColor(a.this.mContext.getResources().getColor(a.this.LCk));
      this.mPopupWindow = new PopupWindow(this);
      this.mPopupWindow.setClippingEnabled(false);
      this.mPopupWindow.setWidth(this.mWidth + this.mPadding * 2);
      this.mPopupWindow.setHeight(this.mHeight + this.mPadding / 2);
      AppMethodBeat.o(159864);
    }
    
    private void fRX()
    {
      AppMethodBeat.i(159867);
      if (!this.LCF) {}
      for (boolean bool = true;; bool = false)
      {
        this.LCF = bool;
        invalidate();
        AppMethodBeat.o(159867);
        return;
      }
    }
    
    private void fRY()
    {
      AppMethodBeat.i(159869);
      a.this.LCc.getLocationInWindow(this.LCK);
      Object localObject = b.hn(a.this.LCc);
      if (localObject != null)
      {
        int i = (int)((TextPaint)localObject).getFontMetrics().descent;
        if (this.LCF)
        {
          this.mPopupWindow.update((int)b.aN(a.this.LCc, a.this.LCa.avj) - this.mWidth + fRZ(), i + b.aL(a.this.LCc, b.aM(a.this.LCc, a.this.LCa.avj)) + fSa(), -1, -1);
          AppMethodBeat.o(159869);
          return;
        }
        localObject = kx((int)b.aN(a.this.LCc, a.this.LCa.OQ), i + b.aL(a.this.LCc, b.aM(a.this.LCc, a.this.LCa.OQ)));
        i = localObject[0];
        int j = localObject[1];
        this.mPopupWindow.update(i + fRZ(), j + fSa(), -1, -1);
      }
      AppMethodBeat.o(159869);
    }
    
    private void update(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159868);
      a.this.LCc.getLocationInWindow(this.LCK);
      int i;
      b localb;
      if (this.LCF)
      {
        i = a.this.LCa.avj;
        int j = this.LCK[1];
        paramInt1 = b.f(a.this.LCc, paramInt1, paramInt2 - j, i);
        if (paramInt1 == i) {
          break label225;
        }
        a.this.fRO();
        if (!this.LCF) {
          break label169;
        }
        if (paramInt1 <= this.LCJ) {
          break label157;
        }
        localb = a.a(a.this, false);
        fRX();
        localb.fRX();
        this.LCI = this.LCJ;
        a.this.kw(this.LCJ, paramInt1);
        localb.fRY();
      }
      for (;;)
      {
        fRY();
        AppMethodBeat.o(159868);
        return;
        i = a.this.LCa.OQ;
        break;
        label157:
        a.this.kw(paramInt1, -1);
      }
      label169:
      if (paramInt1 < this.LCI)
      {
        localb = a.a(a.this, true);
        localb.fRX();
        fRX();
        this.LCJ = this.LCI;
        a.this.kw(paramInt1, this.LCI);
        localb.fRY();
      }
      for (;;)
      {
        fRY();
        label225:
        AppMethodBeat.o(159868);
        return;
        a.this.kw(this.LCI, paramInt1);
      }
    }
    
    public final int fRZ()
    {
      AppMethodBeat.i(159870);
      int i = this.LCK[0];
      int j = this.mPadding;
      int k = a.this.LCc.getPaddingLeft();
      AppMethodBeat.o(159870);
      return i - j + k;
    }
    
    public final int fSa()
    {
      AppMethodBeat.i(159871);
      int i = this.LCK[1];
      int j = a.this.LCc.getPaddingTop();
      AppMethodBeat.o(159871);
      return i + j;
    }
    
    final int[] kx(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159872);
      int j = paramInt1;
      int i = paramInt2;
      if (paramInt1 == 0)
      {
        j = paramInt1;
        i = paramInt2;
        if (a.this.LCa.OQ > 1)
        {
          a.this.LCc.getLocationInWindow(this.LCK);
          TextPaint localTextPaint = b.hn(a.this.LCc);
          j = paramInt1;
          i = paramInt2;
          if (localTextPaint != null)
          {
            paramInt1 = (int)localTextPaint.getFontMetrics().descent;
            paramInt2 = b.aM(a.this.LCc, a.this.LCa.OQ - 1);
            j = (int)b.aQ(a.this.LCc, paramInt2);
            i = b.aL(a.this.LCc, b.aM(a.this.LCc, a.this.LCa.OQ - 1)) + paramInt1;
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
      if (a.this.LCd != null) {
        if (this.LCF)
        {
          i = a.this.LCa.avj;
          TextPaint localTextPaint = b.hn(a.this.LCc);
          if (localTextPaint == null) {
            break label485;
          }
          j = b.aL(a.this.LCc, b.aM(a.this.LCc, i));
          j = (int)localTextPaint.getFontMetrics().descent + j;
          k = (int)b.aN(a.this.LCc, i);
          i = j;
          j = k;
        }
      }
      for (;;)
      {
        a.this.LCc.getLocationInWindow(this.LCK);
        k = i;
        if (!this.LCF) {
          k = kx(j, i)[1];
        }
        i = fSa() + k;
        if (a.this.LCc.getGlobalVisibleRect(this.rect, this.mtn))
        {
          if (i >= this.rect.bottom)
          {
            if (this.LCF)
            {
              ap.d("SelectableTextHelper", "start below bottom, dismiss all.", new Object[0]);
              a.this.fRO();
              a.this.LCs = true;
              a.this.LCt = true;
              a.this.fRN();
              a.this.LCd.dismiss();
            }
            ap.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
            AppMethodBeat.o(159865);
            return;
            i = a.this.LCa.OQ;
            break;
          }
          if (i > this.rect.top) {
            break label373;
          }
          if (!this.LCF)
          {
            ap.d("SelectableTextHelper", "end above top, dismiss all.", new Object[0]);
            a.this.fRO();
            a.this.LCs = true;
            a.this.LCt = true;
            a.this.fRN();
            a.this.LCd.dismiss();
          }
          ap.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
          AppMethodBeat.o(159865);
          return;
        }
        ap.d("SelectableTextHelper", "view invisible.", new Object[0]);
        AppMethodBeat.o(159865);
        return;
        label373:
        paramCanvas.drawCircle(this.pCG + this.mPadding, this.pCG, this.pCG, this.mPaint);
        if (this.LCF)
        {
          paramCanvas.drawRect(this.pCG + this.mPadding, 0.0F, this.pCG * 2 + this.mPadding, this.pCG, this.mPaint);
          AppMethodBeat.o(159865);
          return;
        }
        paramCanvas.drawRect(this.mPadding, 0.0F, this.pCG + this.mPadding, this.pCG, this.mPaint);
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
        this.LCI = a.this.LCa.avj;
        this.LCJ = a.this.LCa.OQ;
        this.LCG = ((int)paramMotionEvent.getX());
        this.LCH = ((int)paramMotionEvent.getY());
        this.LCL = false;
        a.this.LCc.getLocationInWindow(this.JWH);
        continue;
        if ((a.this.LCd != null) && (!this.LCL))
        {
          this.LCL = true;
          a.this.LCd.fLD();
          if (a.this.LCa.OQ - a.this.LCa.avj == b.hm(a.this.LCc).length())
          {
            a.this.LCd.gu(a.this.LCc);
            a.this.LCs = true;
            a.this.fRS();
          }
          for (;;)
          {
            a.this.LCd.fLE();
            break;
            a.this.LCd.dismiss();
            a.this.LCs = false;
            a.this.fRV();
          }
        }
        if (!a.this.LCs)
        {
          a.this.fRV();
          continue;
          if (a.this.LCd != null)
          {
            a.this.LCd.fLD();
            a.this.LCd.dismiss();
          }
          a.this.fRS();
          int i = (int)paramMotionEvent.getRawX();
          int j = (int)paramMotionEvent.getRawY();
          if (a.this.LCd == null) {
            update(i - this.JWH[0], j + this.LCH - this.mHeight - a.this.LCn);
          }
          for (;;)
          {
            if (a.this.LCd == null) {
              break label430;
            }
            a.this.LCd.fLE();
            break;
            update(i - this.JWH[0] + this.pCG, j + this.LCH - this.mHeight - a.this.LCn);
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
    
    final boolean Hm(int paramInt)
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
    public abstract void am(CharSequence paramCharSequence);
  }
  
  public static abstract interface e
  {
    public abstract void fLJ();
  }
  
  public static abstract class f
  {
    public void dismiss() {}
    
    public void fLD() {}
    
    public void fLE() {}
    
    public void fLF() {}
    
    public void gu(View paramView) {}
    
    public void gv(View paramView) {}
  }
  
  final class g
  {
    String LCM;
    int OQ;
    int avj;
    
    g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a
 * JD-Core Version:    0.7.0.1
 */