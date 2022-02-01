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
  View.OnTouchListener Cjy;
  int[] JBQ;
  View LfA;
  public a.f LfB;
  View.OnTouchListener LfC;
  private Spannable LfD;
  private com.tencent.mm.ui.widget.b.a LfE;
  int LfF;
  int LfG;
  private int LfH;
  int LfI;
  int LfJ;
  private c LfK;
  int LfL;
  public int LfM;
  private ViewTreeObserver.OnScrollChangedListener LfN;
  boolean LfO;
  boolean LfP;
  public boolean LfQ;
  public boolean LfR;
  boolean LfS;
  boolean LfT;
  boolean LfU;
  final Runnable LfV;
  final Runnable LfW;
  public e LfX;
  ArrayList<c> LfY;
  b Lfw;
  private b Lfx;
  g Lfy;
  public a.d Lfz;
  private boolean aMv;
  private View.OnAttachStateChangeListener afj;
  private ViewTreeObserver.OnGlobalLayoutListener ajt;
  View.OnClickListener gMe;
  Context mContext;
  int[] uCL;
  private int yKP;
  
  public a(a.a parama)
  {
    AppMethodBeat.i(159878);
    this.Lfy = new g();
    this.yKP = 0;
    this.LfO = false;
    this.aMv = true;
    this.LfP = false;
    this.LfQ = true;
    this.LfR = true;
    this.LfS = true;
    this.LfT = false;
    this.LfU = false;
    this.uCL = new int[2];
    this.LfV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159850);
        if (a.this.LfO)
        {
          ap.d("SelectableTextHelper", "isReInit, return.", new Object[0]);
          AppMethodBeat.o(159850);
          return;
        }
        ap.d("SelectableTextHelper", "in mShowSelectViewRunnable. opener: %s, inScrolling: %s.", new Object[] { Boolean.valueOf(a.this.LfS), Boolean.valueOf(a.this.LfT) });
        if (a.this.LfB != null)
        {
          if (!a.this.LfS)
          {
            a.this.LfS = true;
            if (a.this.LfT)
            {
              ap.d("SelectableTextHelper", "menu is hide: %s, cursor is hide: %s.", new Object[] { Boolean.valueOf(a.this.LfQ), Boolean.valueOf(a.this.LfR) });
              if (!a.this.LfQ) {
                a.this.fNA();
              }
              if (!a.this.LfR)
              {
                a.this.fNv();
                a.this.kp(a.this.Lfy.avj, a.this.Lfy.OQ);
              }
              if ((a.this.LfB != null) && (a.this.LfQ) && (!a.this.LfR)) {
                a.this.LfB.gp(a.this.LfA);
              }
            }
            a.this.LfT = false;
            AppMethodBeat.o(159850);
            return;
          }
          if (a.this.LfU)
          {
            a.this.LfU = false;
            ap.d("SelectableTextHelper", "judge result(delay), click outside.", new Object[0]);
            if (a.this.LfX != null)
            {
              a.this.LfX.fHr();
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
          if (!a.this.LfQ) {
            a.this.fNA();
          }
          if (!a.this.LfR) {
            a.this.fNv();
          }
        }
        AppMethodBeat.o(159850);
      }
    };
    this.LfW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159854);
        ap.d("SelectableTextHelper", "dismiss all runnable.", new Object[0]);
        if (a.this.LfX != null) {
          a.this.LfX.fHr();
        }
        AppMethodBeat.o(159854);
      }
    };
    this.JBQ = new int[2];
    this.LfA = parama.LfA;
    this.LfB = parama.LfB;
    this.gMe = parama.gMe;
    this.LfC = parama.LfC;
    this.LfE = parama.Lga;
    this.yKP = parama.Lgc;
    this.mContext = this.LfA.getContext();
    this.LfH = parama.LfH;
    this.LfI = parama.LfI;
    Object localObject = this.LfA;
    int i;
    float f;
    if ((localObject instanceof NeatTextView))
    {
      i = ((NeatTextView)localObject).getLineHeight();
      this.LfL = i;
      if (this.LfJ != 0) {
        break label387;
      }
      parama = this.LfA;
      if (!(parama instanceof NeatTextView)) {
        break label364;
      }
      f = ((NeatTextView)parama).getTextSize();
    }
    label234:
    for (this.LfJ = ((int)f);; this.LfJ = aq.fromDPToPix(this.mContext, parama.Lgb))
    {
      this.afj = new a.6(this);
      this.Bf = new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(159857);
          if (a.this.LfP)
          {
            a.this.LfP = false;
            a locala = a.this;
            locala.LfA.removeCallbacks(locala.LfV);
            locala.LfA.postDelayed(locala.LfV, 100L);
          }
          AppMethodBeat.o(159857);
          return true;
        }
      };
      this.LfN = new ViewTreeObserver.OnScrollChangedListener()
      {
        public final void onScrollChanged()
        {
          AppMethodBeat.i(159858);
          if (a.this.LfB != null)
          {
            a.this.LfA.removeCallbacks(a.this.LfW);
            a.this.LfA.getLocationInWindow(a.this.JBQ);
            ap.d("SelectableTextHelper", "onScrollChanged, old-y: %d, y: %d.", new Object[] { Integer.valueOf(a.this.uCL[1]), Integer.valueOf(a.this.JBQ[1]) });
            if (a.this.LfS)
            {
              if ((a.this.LfT) || (a.this.LfU)) {
                break label260;
              }
              if (a.this.uCL[1] == a.this.JBQ[1]) {
                break label238;
              }
              a.this.LfT = true;
              a.this.LfS = false;
              ap.d("SelectableTextHelper", "judge result, inScrolling.", new Object[0]);
            }
          }
          for (;;)
          {
            a.this.uCL[1] = a.this.JBQ[1];
            if ((!a.this.LfP) && ((!a.this.LfQ) || (!a.this.LfR)))
            {
              a.this.LfP = true;
              a.this.fNs();
            }
            AppMethodBeat.o(159858);
            return;
            label238:
            a.this.LfU = true;
            ap.d("SelectableTextHelper", "need delay judge.", new Object[0]);
            continue;
            label260:
            if (a.this.LfU)
            {
              a.this.LfU = false;
              a.this.LfS = false;
              if (a.this.uCL[1] != a.this.JBQ[1])
              {
                a.this.LfT = true;
                ap.d("SelectableTextHelper", "judge result(delay), inScrolling.", new Object[0]);
              }
              else
              {
                a.this.LfT = false;
                ap.d("SelectableTextHelper", "judge result, click outside.", new Object[0]);
              }
            }
          }
        }
      };
      this.ajt = new a.9(this);
      this.Cjy = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(159860);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/textview/SelectableTextHelper$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          ap.d("SelectableTextHelper", "event pointer count: %d.", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getPointerCount()) });
          if (a.this.LfC != null) {
            a.this.LfC.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          }
          a.this.LfF = ((int)paramAnonymousMotionEvent.getX());
          a.this.LfG = ((int)paramAnonymousMotionEvent.getY());
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/textview/SelectableTextHelper$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(159860);
          return false;
        }
      };
      if (this.aMv) {
        break label405;
      }
      ap.d("SelectableTextHelper", "not destroy, isReInit: %s.", new Object[] { Boolean.valueOf(this.LfO) });
      this.LfO = true;
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
    this.LfO = false;
    this.aMv = false;
    this.LfP = false;
    TextView.BufferType localBufferType;
    if (this.LfB == null)
    {
      parama = this.LfA;
      localObject = b.hh(this.LfA);
      localBufferType = TextView.BufferType.SPANNABLE;
      if (!(parama instanceof NeatTextView)) {
        break label685;
      }
      ((NeatTextView)parama).a((CharSequence)localObject, localBufferType);
    }
    for (;;)
    {
      this.Lfw = new b(true);
      if (this.LfB != null)
      {
        this.Lfw.mPopupWindow.setOutsideTouchable(true);
        parama = this.Lfw;
        localObject = new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(159861);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/textview/SelectableTextHelper$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
            ap.d("SelectableTextHelper", "interceptor onTouch.", new Object[0]);
            int i = (int)paramAnonymousMotionEvent.getX();
            int j = (int)paramAnonymousMotionEvent.getY();
            if ((paramAnonymousMotionEvent.getAction() == 0) && ((i < 0) || (i >= a.this.Lfw.getWidth()) || (j < 0) || (j >= a.this.Lfw.getHeight())))
            {
              ap.d("SelectableTextHelper", "interceptor onTouch, down, outside.", new Object[0]);
              a.this.LfA.postDelayed(a.this.LfW, 100L);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/textview/SelectableTextHelper$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(159861);
              return true;
            }
            if (paramAnonymousMotionEvent.getAction() == 4)
            {
              ap.d("SelectableTextHelper", "interceptor onTouch, outside.", new Object[0]);
              a.this.LfA.postDelayed(a.this.LfW, 100L);
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
        parama = this.Lfw;
        localObject = new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(159862);
            a.this.LfA.setOnTouchListener(a.this.Cjy);
            AppMethodBeat.o(159862);
          }
        };
        parama.mPopupWindow.setOnDismissListener((PopupWindow.OnDismissListener)localObject);
      }
      this.Lfx = new b(false);
      this.LfA.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159851);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/textview/SelectableTextHelper$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
          ap.d("SelectableTextHelper", "onLongClick.", new Object[0]);
          a.this.LfO = false;
          int j;
          if (a.this.LfB != null)
          {
            a.this.LfS = true;
            a.this.LfT = false;
            a.this.LfU = false;
            Object localObject2 = b.hh(a.this.LfA);
            if ((localObject2 instanceof SpannableString))
            {
              localObject1 = a.this;
              localObject2 = (SpannableString)localObject2;
              ((a)localObject1).LfY = new ArrayList();
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
                  ((a)localObject1).LfY.add(localObject3);
                }
                for (;;)
                {
                  ap.d("SelectableTextHelper", "spans from %d to %d.", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
                  i = j;
                  break;
                  ap.e("SelectableTextHelper", "other situation occur! length: %d.", new Object[] { Integer.valueOf(localObject3.length) });
                }
              }
              ap.d("SelectableTextHelper", ((a)localObject1).LfY.toString(), new Object[0]);
            }
            a.this.fNs();
            if ((a.this.LfM > 0) && (a.this.LfM < b.hh(a.this.LfA).length()))
            {
              a.a(a.this, a.this.LfM);
              a.this.LfQ = false;
              a.this.LfR = false;
              a.this.fNA();
              a.this.fNv();
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/textview/SelectableTextHelper$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(159851);
              return true;
              a.a(a.this, b.hh(a.this.LfA).length());
              a.this.LfQ = true;
              a.this.LfR = false;
              a.this.fNv();
              a.this.LfB.gq(paramAnonymousView);
            }
          }
          a.this.LfS = false;
          paramAnonymousView = a.this;
          int k = a.this.LfF;
          int i = a.this.LfG;
          localObject1 = paramAnonymousView.LfA;
          if ((localObject1 instanceof NeatTextView))
          {
            localObject1 = ((NeatTextView)localObject1).getLayout();
            if (localObject1 == null) {
              break label635;
            }
            i = ((com.tencent.neattextview.textview.layout.a)localObject1).kH(k, i);
          }
          for (;;)
          {
            paramAnonymousView.ko(i, i + 1);
            a.this.fNs();
            a.this.LfQ = false;
            a.this.LfR = false;
            a.this.fNA();
            a.this.fNv();
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
      this.LfA.setOnTouchListener(this.Cjy);
      this.LfA.setOnClickListener(new a.3(this));
      this.LfA.addOnAttachStateChangeListener(this.afj);
      this.LfA.getViewTreeObserver().addOnPreDrawListener(this.Bf);
      this.LfA.getViewTreeObserver().addOnScrollChangedListener(this.LfN);
      this.LfA.getViewTreeObserver().addOnGlobalLayoutListener(this.ajt);
      this.LfA.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(159853);
          a.this.LfA.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          if (a.this.LfB != null)
          {
            a.this.LfA.getLocationInWindow(a.this.uCL);
            ap.d("SelectableTextHelper", "init: loc-x: %d, loc-y: %d.", new Object[] { Integer.valueOf(a.this.uCL[0]), Integer.valueOf(a.this.uCL[1]) });
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
    for (int i = this.Lfy.avj; (i < 0) || (i > b.hh(this.LfA).length()); i = this.Lfy.OQ)
    {
      AppMethodBeat.o(159884);
      return;
    }
    Object localObject = b.hi(this.LfA);
    int j;
    if (localObject != null)
    {
      j = (int)((TextPaint)localObject).getFontMetrics().descent + b.aL(this.LfA, b.aM(this.LfA, i));
      i = (int)b.aN(this.LfA, i);
    }
    for (;;)
    {
      paramb.LfZ.LfA.getLocationInWindow(paramb.Lgi);
      if (paramb.Lgd) {}
      for (int k = paramb.mWidth;; k = 0)
      {
        int n = i;
        int m = j;
        if (!paramb.Lgd)
        {
          localObject = paramb.kq(i, j);
          n = localObject[0];
          m = localObject[1];
        }
        try
        {
          paramb.mPopupWindow.showAtLocation(paramb.LfZ.LfA, 0, n - k + paramb.fNE(), m + paramb.fNF());
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
  
  private int bm(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(159893);
    if (this.LfY != null)
    {
      Iterator localIterator = this.LfY.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.GP(paramInt))
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
  
  private boolean fNu()
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
    this.LfO = false;
    this.aMv = true;
    this.LfP = false;
    this.LfA.removeCallbacks(this.LfV);
    this.LfA.getViewTreeObserver().removeOnScrollChangedListener(this.LfN);
    this.LfA.getViewTreeObserver().removeOnPreDrawListener(this.Bf);
    this.LfA.getViewTreeObserver().removeOnGlobalLayoutListener(this.ajt);
    this.LfA.removeOnAttachStateChangeListener(this.afj);
    this.LfQ = true;
    this.LfR = true;
    fNs();
    fNt();
    this.Lfw = null;
    this.Lfx = null;
    if (this.LfB != null) {
      this.LfB.dismiss();
    }
    AppMethodBeat.o(159880);
  }
  
  public final void fNA()
  {
    AppMethodBeat.i(159891);
    int i;
    int j;
    if (this.LfE != null)
    {
      int[] arrayOfInt = new int[2];
      this.LfA.getLocationInWindow(arrayOfInt);
      float f3 = b.aN(this.LfA, this.Lfy.avj);
      float f2 = b.aN(this.LfA, this.Lfy.OQ);
      i = b.aM(this.LfA, this.Lfy.avj);
      float f1;
      if (b.aM(this.LfA, this.Lfy.OQ) <= i)
      {
        f1 = f2;
        if (f2 > f3) {}
      }
      else
      {
        f1 = b.aQ(this.LfA, b.aM(this.LfA, this.Lfy.avj));
      }
      i = (int)((f1 + f3) / 2.0F);
      j = this.yKP + i;
      int k = b.aO(this.LfA, b.aM(this.LfA, this.Lfy.avj)) + arrayOfInt[1] + this.mContext.getResources().getDimensionPixelSize(2131166166);
      ap.d("SelectableTextHelper", "dancy test posX:%s, startline:%s, endline:%s, leftpadding:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(b.aM(this.LfA, this.Lfy.avj)), Integer.valueOf(b.aM(this.LfA, this.Lfy.OQ)), Integer.valueOf(this.yKP) });
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
      this.LfE.el(i, j);
      if (this.LfB != null) {
        this.LfB.fHn();
      }
      AppMethodBeat.o(159891);
      return;
    }
  }
  
  public final void fNs()
  {
    AppMethodBeat.i(159881);
    fNw();
    fNx();
    if (this.LfB != null) {
      this.LfB.dismiss();
    }
    AppMethodBeat.o(159881);
  }
  
  public final void fNt()
  {
    AppMethodBeat.i(159882);
    this.Lfy.Lgk = null;
    if ((this.LfD != null) && (this.LfK != null))
    {
      this.LfD.removeSpan(this.LfK);
      this.LfK = null;
    }
    AppMethodBeat.o(159882);
  }
  
  public final void fNv()
  {
    AppMethodBeat.i(159886);
    if (!fNu())
    {
      a(this.Lfw);
      a(this.Lfx);
    }
    AppMethodBeat.o(159886);
  }
  
  public final void fNw()
  {
    AppMethodBeat.i(159887);
    if (this.Lfw != null) {
      this.Lfw.mPopupWindow.dismiss();
    }
    if (this.Lfx != null) {
      this.Lfx.mPopupWindow.dismiss();
    }
    AppMethodBeat.o(159887);
  }
  
  public final void fNx()
  {
    AppMethodBeat.i(159888);
    if (this.LfE != null) {
      this.LfE.fBg();
    }
    AppMethodBeat.o(159888);
  }
  
  public final void fNy()
  {
    AppMethodBeat.i(159889);
    if (this.LfB != null) {
      this.LfB.gp(this.LfA);
    }
    AppMethodBeat.o(159889);
  }
  
  public final void fNz()
  {
    AppMethodBeat.i(159890);
    if (this.LfB != null) {
      this.LfB.dismiss();
    }
    AppMethodBeat.o(159890);
  }
  
  final void ko(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159883);
    fNt();
    if ((b.hh(this.LfA) instanceof Spannable)) {
      this.LfD = ((Spannable)b.hh(this.LfA));
    }
    if ((this.LfD == null) || (paramInt1 >= b.hh(this.LfA).length()))
    {
      this.Lfy.avj = 0;
      this.Lfy.OQ = 0;
      AppMethodBeat.o(159883);
      return;
    }
    kp(paramInt1, paramInt2);
    AppMethodBeat.o(159883);
  }
  
  public final void kp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159892);
    if (paramInt1 != -1) {
      this.Lfy.avj = bm(paramInt1, true);
    }
    if (paramInt2 != -1) {
      this.Lfy.OQ = bm(paramInt2, false);
    }
    if ((this.Lfy.avj < 0) || (this.Lfy.avj > b.hh(this.LfA).length()))
    {
      AppMethodBeat.o(159892);
      return;
    }
    if ((this.Lfy.OQ < 0) || (this.Lfy.OQ > b.hh(this.LfA).length()))
    {
      AppMethodBeat.o(159892);
      return;
    }
    if (this.Lfy.avj > this.Lfy.OQ)
    {
      paramInt1 = this.Lfy.avj;
      this.Lfy.avj = this.Lfy.OQ;
      this.Lfy.OQ = paramInt1;
    }
    if (this.LfD != null)
    {
      this.Lfy.Lgk = this.LfD.subSequence(this.Lfy.avj, this.Lfy.OQ).toString();
      if (this.LfK == null) {
        break label314;
      }
      this.LfK.setPosition(this.Lfy.avj, this.Lfy.OQ);
    }
    for (;;)
    {
      paramInt1 = b.aM(this.LfA, this.Lfy.avj);
      paramInt1 = b.aR(this.LfA, paramInt1);
      this.LfD.setSpan(this.LfK, paramInt1, this.Lfy.OQ, 17);
      if (this.Lfz != null) {
        this.Lfz.an(this.Lfy.Lgk);
      }
      AppMethodBeat.o(159892);
      return;
      label314:
      this.LfK = new c(this.LfA, this.mContext.getResources().getColor(this.LfH), this.Lfy.avj, this.Lfy.OQ);
    }
  }
  
  final class b
    extends View
  {
    private int[] JBQ;
    boolean Lgd;
    private int Lge;
    private int Lgf;
    private int Lgg;
    private int Lgh;
    int[] Lgi;
    private boolean Lgj;
    private int mHeight;
    private int mPadding;
    private Paint mPaint;
    PopupWindow mPopupWindow;
    int mWidth;
    private Point mop;
    private int pwc;
    private Rect rect;
    
    b(boolean paramBoolean)
    {
      super();
      AppMethodBeat.i(159864);
      this.pwc = (a.this.LfJ / 2);
      this.mWidth = (this.pwc * 2);
      this.mHeight = (this.pwc * 2);
      this.mPadding = 25;
      this.Lgi = new int[2];
      this.rect = new Rect();
      this.mop = new Point();
      this.Lgj = false;
      this.JBQ = new int[2];
      this.Lgd = paramBoolean;
      this.mPaint = new Paint(1);
      this.mPaint.setColor(a.this.mContext.getResources().getColor(a.this.LfI));
      this.mPopupWindow = new PopupWindow(this);
      this.mPopupWindow.setClippingEnabled(false);
      this.mPopupWindow.setWidth(this.mWidth + this.mPadding * 2);
      this.mPopupWindow.setHeight(this.mHeight + this.mPadding / 2);
      AppMethodBeat.o(159864);
    }
    
    private void fNC()
    {
      AppMethodBeat.i(159867);
      if (!this.Lgd) {}
      for (boolean bool = true;; bool = false)
      {
        this.Lgd = bool;
        invalidate();
        AppMethodBeat.o(159867);
        return;
      }
    }
    
    private void fND()
    {
      AppMethodBeat.i(159869);
      a.this.LfA.getLocationInWindow(this.Lgi);
      Object localObject = b.hi(a.this.LfA);
      if (localObject != null)
      {
        int i = (int)((TextPaint)localObject).getFontMetrics().descent;
        if (this.Lgd)
        {
          this.mPopupWindow.update((int)b.aN(a.this.LfA, a.this.Lfy.avj) - this.mWidth + fNE(), i + b.aL(a.this.LfA, b.aM(a.this.LfA, a.this.Lfy.avj)) + fNF(), -1, -1);
          AppMethodBeat.o(159869);
          return;
        }
        localObject = kq((int)b.aN(a.this.LfA, a.this.Lfy.OQ), i + b.aL(a.this.LfA, b.aM(a.this.LfA, a.this.Lfy.OQ)));
        i = localObject[0];
        int j = localObject[1];
        this.mPopupWindow.update(i + fNE(), j + fNF(), -1, -1);
      }
      AppMethodBeat.o(159869);
    }
    
    private void update(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159868);
      a.this.LfA.getLocationInWindow(this.Lgi);
      int i;
      b localb;
      if (this.Lgd)
      {
        i = a.this.Lfy.avj;
        int j = this.Lgi[1];
        paramInt1 = b.f(a.this.LfA, paramInt1, paramInt2 - j, i);
        if (paramInt1 == i) {
          break label225;
        }
        a.this.fNt();
        if (!this.Lgd) {
          break label169;
        }
        if (paramInt1 <= this.Lgh) {
          break label157;
        }
        localb = a.a(a.this, false);
        fNC();
        localb.fNC();
        this.Lgg = this.Lgh;
        a.this.kp(this.Lgh, paramInt1);
        localb.fND();
      }
      for (;;)
      {
        fND();
        AppMethodBeat.o(159868);
        return;
        i = a.this.Lfy.OQ;
        break;
        label157:
        a.this.kp(paramInt1, -1);
      }
      label169:
      if (paramInt1 < this.Lgg)
      {
        localb = a.a(a.this, true);
        localb.fNC();
        fNC();
        this.Lgh = this.Lgg;
        a.this.kp(paramInt1, this.Lgg);
        localb.fND();
      }
      for (;;)
      {
        fND();
        label225:
        AppMethodBeat.o(159868);
        return;
        a.this.kp(this.Lgg, paramInt1);
      }
    }
    
    public final int fNE()
    {
      AppMethodBeat.i(159870);
      int i = this.Lgi[0];
      int j = this.mPadding;
      int k = a.this.LfA.getPaddingLeft();
      AppMethodBeat.o(159870);
      return i - j + k;
    }
    
    public final int fNF()
    {
      AppMethodBeat.i(159871);
      int i = this.Lgi[1];
      int j = a.this.LfA.getPaddingTop();
      AppMethodBeat.o(159871);
      return i + j;
    }
    
    final int[] kq(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159872);
      int j = paramInt1;
      int i = paramInt2;
      if (paramInt1 == 0)
      {
        j = paramInt1;
        i = paramInt2;
        if (a.this.Lfy.OQ > 1)
        {
          a.this.LfA.getLocationInWindow(this.Lgi);
          TextPaint localTextPaint = b.hi(a.this.LfA);
          j = paramInt1;
          i = paramInt2;
          if (localTextPaint != null)
          {
            paramInt1 = (int)localTextPaint.getFontMetrics().descent;
            paramInt2 = b.aM(a.this.LfA, a.this.Lfy.OQ - 1);
            j = (int)b.aQ(a.this.LfA, paramInt2);
            i = b.aL(a.this.LfA, b.aM(a.this.LfA, a.this.Lfy.OQ - 1)) + paramInt1;
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
      if (a.this.LfB != null) {
        if (this.Lgd)
        {
          i = a.this.Lfy.avj;
          TextPaint localTextPaint = b.hi(a.this.LfA);
          if (localTextPaint == null) {
            break label485;
          }
          j = b.aL(a.this.LfA, b.aM(a.this.LfA, i));
          j = (int)localTextPaint.getFontMetrics().descent + j;
          k = (int)b.aN(a.this.LfA, i);
          i = j;
          j = k;
        }
      }
      for (;;)
      {
        a.this.LfA.getLocationInWindow(this.Lgi);
        k = i;
        if (!this.Lgd) {
          k = kq(j, i)[1];
        }
        i = fNF() + k;
        if (a.this.LfA.getGlobalVisibleRect(this.rect, this.mop))
        {
          if (i >= this.rect.bottom)
          {
            if (this.Lgd)
            {
              ap.d("SelectableTextHelper", "start below bottom, dismiss all.", new Object[0]);
              a.this.fNt();
              a.this.LfQ = true;
              a.this.LfR = true;
              a.this.fNs();
              a.this.LfB.dismiss();
            }
            ap.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
            AppMethodBeat.o(159865);
            return;
            i = a.this.Lfy.OQ;
            break;
          }
          if (i > this.rect.top) {
            break label373;
          }
          if (!this.Lgd)
          {
            ap.d("SelectableTextHelper", "end above top, dismiss all.", new Object[0]);
            a.this.fNt();
            a.this.LfQ = true;
            a.this.LfR = true;
            a.this.fNs();
            a.this.LfB.dismiss();
          }
          ap.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
          AppMethodBeat.o(159865);
          return;
        }
        ap.d("SelectableTextHelper", "view invisible.", new Object[0]);
        AppMethodBeat.o(159865);
        return;
        label373:
        paramCanvas.drawCircle(this.pwc + this.mPadding, this.pwc, this.pwc, this.mPaint);
        if (this.Lgd)
        {
          paramCanvas.drawRect(this.pwc + this.mPadding, 0.0F, this.pwc * 2 + this.mPadding, this.pwc, this.mPaint);
          AppMethodBeat.o(159865);
          return;
        }
        paramCanvas.drawRect(this.mPadding, 0.0F, this.pwc + this.mPadding, this.pwc, this.mPaint);
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
        this.Lgg = a.this.Lfy.avj;
        this.Lgh = a.this.Lfy.OQ;
        this.Lge = ((int)paramMotionEvent.getX());
        this.Lgf = ((int)paramMotionEvent.getY());
        this.Lgj = false;
        a.this.LfA.getLocationInWindow(this.JBQ);
        continue;
        if ((a.this.LfB != null) && (!this.Lgj))
        {
          this.Lgj = true;
          a.this.LfB.fHl();
          if (a.this.Lfy.OQ - a.this.Lfy.avj == b.hh(a.this.LfA).length())
          {
            a.this.LfB.gp(a.this.LfA);
            a.this.LfQ = true;
            a.this.fNx();
          }
          for (;;)
          {
            a.this.LfB.fHm();
            break;
            a.this.LfB.dismiss();
            a.this.LfQ = false;
            a.this.fNA();
          }
        }
        if (!a.this.LfQ)
        {
          a.this.fNA();
          continue;
          if (a.this.LfB != null)
          {
            a.this.LfB.fHl();
            a.this.LfB.dismiss();
          }
          a.this.fNx();
          int i = (int)paramMotionEvent.getRawX();
          int j = (int)paramMotionEvent.getRawY();
          if (a.this.LfB == null) {
            update(i - this.JBQ[0], j + this.Lgf - this.mHeight - a.this.LfL);
          }
          for (;;)
          {
            if (a.this.LfB == null) {
              break label430;
            }
            a.this.LfB.fHm();
            break;
            update(i - this.JBQ[0] + this.pwc, j + this.Lgf - this.mHeight - a.this.LfL);
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
    
    final boolean GP(int paramInt)
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
    public abstract void fHr();
  }
  
  final class g
  {
    String Lgk;
    int OQ;
    int avj;
    
    g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a
 * JD-Core Version:    0.7.0.1
 */