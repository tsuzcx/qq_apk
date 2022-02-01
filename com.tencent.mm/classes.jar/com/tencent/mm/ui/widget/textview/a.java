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
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.c;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  int[] BdE;
  private int Cxs;
  int[] Dvf;
  private Spannable Yfs;
  private ViewTreeObserver.OnScrollChangedListener YnQ;
  private int YnW;
  int YnX;
  int YnY;
  boolean YnZ;
  int Yoa;
  int Yod;
  int Yoe;
  final Runnable Yoj;
  private com.tencent.mm.ui.widget.b.a YwA;
  private c YwB;
  public int YwC;
  boolean YwD;
  public boolean YwE;
  public boolean YwF;
  boolean YwG;
  boolean YwH;
  boolean YwI;
  final Runnable YwJ;
  public e YwK;
  ArrayList<c> YwL;
  b Ywt;
  private b Ywu;
  g Ywv;
  public d Yww;
  View Ywx;
  public a.f Ywy;
  View.OnTouchListener Ywz;
  private boolean aJQ;
  private ViewTreeObserver.OnPreDrawListener aqE;
  View.OnClickListener kte;
  private View.OnAttachStateChangeListener lF;
  Context mContext;
  View.OnTouchListener nan;
  private ViewTreeObserver.OnGlobalLayoutListener qc;
  
  public a(a parama)
  {
    AppMethodBeat.i(159878);
    this.Ywv = new g();
    this.Cxs = 0;
    this.YwD = false;
    this.aJQ = true;
    this.YnZ = false;
    this.YwE = true;
    this.YwF = true;
    this.YwG = true;
    this.YwH = false;
    this.YwI = false;
    this.BdE = new int[2];
    this.Yoj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159850);
        if (a.this.YwD)
        {
          av.d("SelectableTextHelper", "isReInit, return.", new Object[0]);
          AppMethodBeat.o(159850);
          return;
        }
        av.d("SelectableTextHelper", "in mShowSelectViewRunnable. opener: %s, inScrolling: %s.", new Object[] { Boolean.valueOf(a.this.YwG), Boolean.valueOf(a.this.YwH) });
        if (a.this.Ywy != null)
        {
          if (!a.this.YwG)
          {
            a.this.YwG = true;
            if (a.this.YwH)
            {
              av.d("SelectableTextHelper", "menu is hide: %s, cursor is hide: %s.", new Object[] { Boolean.valueOf(a.this.YwE), Boolean.valueOf(a.this.YwF) });
              if (!a.this.YwE) {
                a.this.iek();
              }
              if (!a.this.YwF)
              {
                a.this.ief();
                a.this.fj(a.this.Ywv.tH, a.this.Ywv.tI);
              }
              if ((a.this.Ywy != null) && (a.this.YwE) && (!a.this.YwF)) {
                a.this.Ywy.hW(a.this.Ywx);
              }
            }
            a.this.YwH = false;
            AppMethodBeat.o(159850);
            return;
          }
          if (a.this.YwI)
          {
            a.this.YwI = false;
            av.d("SelectableTextHelper", "judge result(delay), click outside.", new Object[0]);
            if (a.this.YwK != null)
            {
              a.this.YwK.hTP();
              AppMethodBeat.o(159850);
            }
          }
          else
          {
            av.d("SelectableTextHelper", "Oh, bypass the judge logic! Don't worry, that's reasonable.", new Object[0]);
            AppMethodBeat.o(159850);
          }
        }
        else
        {
          if (!a.this.YwE) {
            a.this.iek();
          }
          if (!a.this.YwF) {
            a.this.ief();
          }
        }
        AppMethodBeat.o(159850);
      }
    };
    this.YwJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159854);
        av.d("SelectableTextHelper", "dismiss all runnable.", new Object[0]);
        if (a.this.YwK != null) {
          a.this.YwK.hTP();
        }
        AppMethodBeat.o(159854);
      }
    };
    this.Dvf = new int[2];
    this.Ywx = parama.Ywx;
    this.Ywy = parama.Ywy;
    this.kte = parama.kte;
    this.Ywz = parama.Ywz;
    this.YwA = parama.YwN;
    this.Cxs = parama.YwP;
    this.mContext = this.Ywx.getContext();
    this.YnW = parama.YnW;
    this.YnX = parama.YnX;
    this.Yoa = b.iZ(this.Ywx);
    float f;
    if (this.YnY == 0)
    {
      parama = this.Ywx;
      if ((parama instanceof NeatTextView)) {
        f = ((NeatTextView)parama).getTextSize();
      }
    }
    for (this.YnY = ((int)f);; this.YnY = aw.fromDPToPix(this.mContext, parama.YwO))
    {
      this.lF = new View.OnAttachStateChangeListener()
      {
        public final void onViewAttachedToWindow(View paramAnonymousView)
        {
          AppMethodBeat.i(159855);
          av.d("SelectableTextHelper", "onViewAttachedToWindow", new Object[0]);
          AppMethodBeat.o(159855);
        }
        
        public final void onViewDetachedFromWindow(View paramAnonymousView)
        {
          AppMethodBeat.i(159856);
          av.d("SelectableTextHelper", "onViewDetachedFromWindow", new Object[0]);
          a.this.destroy();
          AppMethodBeat.o(159856);
        }
      };
      this.aqE = new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(159857);
          if (a.this.YnZ)
          {
            a.this.YnZ = false;
            a locala = a.this;
            locala.Ywx.removeCallbacks(locala.Yoj);
            locala.Ywx.postDelayed(locala.Yoj, 100L);
          }
          AppMethodBeat.o(159857);
          return true;
        }
      };
      this.YnQ = new ViewTreeObserver.OnScrollChangedListener()
      {
        public final void onScrollChanged()
        {
          AppMethodBeat.i(159858);
          if (a.this.Ywy != null)
          {
            a.this.Ywx.removeCallbacks(a.this.YwJ);
            a.this.Ywx.getLocationInWindow(a.this.Dvf);
            av.d("SelectableTextHelper", "onScrollChanged, old-y: %d, y: %d.", new Object[] { Integer.valueOf(a.this.BdE[1]), Integer.valueOf(a.this.Dvf[1]) });
            if (a.this.YwG)
            {
              if ((a.this.YwH) || (a.this.YwI)) {
                break label260;
              }
              if (a.this.BdE[1] == a.this.Dvf[1]) {
                break label238;
              }
              a.this.YwH = true;
              a.this.YwG = false;
              av.d("SelectableTextHelper", "judge result, inScrolling.", new Object[0]);
            }
          }
          for (;;)
          {
            a.this.BdE[1] = a.this.Dvf[1];
            if ((!a.this.YnZ) && ((!a.this.YwE) || (!a.this.YwF)))
            {
              a.this.YnZ = true;
              a.this.cpq();
            }
            AppMethodBeat.o(159858);
            return;
            label238:
            a.this.YwI = true;
            av.d("SelectableTextHelper", "need delay judge.", new Object[0]);
            continue;
            label260:
            if (a.this.YwI)
            {
              a.this.YwI = false;
              a.this.YwG = false;
              if (a.this.BdE[1] != a.this.Dvf[1])
              {
                a.this.YwH = true;
                av.d("SelectableTextHelper", "judge result(delay), inScrolling.", new Object[0]);
              }
              else
              {
                a.this.YwH = false;
                av.d("SelectableTextHelper", "judge result, click outside.", new Object[0]);
              }
            }
          }
        }
      };
      this.qc = new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(159859);
          av.d("SelectableTextHelper", "onGlobalLayout", new Object[0]);
          AppMethodBeat.o(159859);
        }
      };
      this.nan = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(159860);
          av.d("SelectableTextHelper", "event pointer count: %d.", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getPointerCount()) });
          if (a.this.Ywz != null) {
            a.this.Ywz.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          }
          a.this.Yod = ((int)paramAnonymousMotionEvent.getX());
          a.this.Yoe = ((int)paramAnonymousMotionEvent.getY());
          AppMethodBeat.o(159860);
          return false;
        }
      };
      if (this.aJQ) {
        break label363;
      }
      av.d("SelectableTextHelper", "not destroy, isReInit: %s.", new Object[] { Boolean.valueOf(this.YwD) });
      this.YwD = true;
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
    av.d("SelectableTextHelper", "not init yet, need to init.", new Object[0]);
    this.YwD = false;
    this.aJQ = false;
    this.YnZ = false;
    Object localObject;
    TextView.BufferType localBufferType;
    if (this.Ywy == null)
    {
      parama = this.Ywx;
      localObject = b.iX(this.Ywx);
      localBufferType = TextView.BufferType.SPANNABLE;
      if (!(parama instanceof NeatTextView)) {
        break label637;
      }
      ((NeatTextView)parama).a((CharSequence)localObject, localBufferType);
    }
    for (;;)
    {
      this.Ywt = new b(true);
      if (this.Ywy != null)
      {
        this.Ywt.mPopupWindow.setOutsideTouchable(true);
        parama = this.Ywt;
        localObject = new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(159861);
            av.d("SelectableTextHelper", "interceptor onTouch.", new Object[0]);
            int i = (int)paramAnonymousMotionEvent.getX();
            int j = (int)paramAnonymousMotionEvent.getY();
            if ((paramAnonymousMotionEvent.getAction() == 0) && ((i < 0) || (i >= a.this.Ywt.getWidth()) || (j < 0) || (j >= a.this.Ywt.getHeight())))
            {
              av.d("SelectableTextHelper", "interceptor onTouch, down, outside.", new Object[0]);
              a.this.Ywx.postDelayed(a.this.YwJ, 100L);
              AppMethodBeat.o(159861);
              return true;
            }
            if (paramAnonymousMotionEvent.getAction() == 4)
            {
              av.d("SelectableTextHelper", "interceptor onTouch, outside.", new Object[0]);
              a.this.Ywx.postDelayed(a.this.YwJ, 100L);
              AppMethodBeat.o(159861);
              return true;
            }
            AppMethodBeat.o(159861);
            return false;
          }
        };
        parama.mPopupWindow.setTouchInterceptor((View.OnTouchListener)localObject);
        parama = this.Ywt;
        localObject = new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(159862);
            a.this.Ywx.setOnTouchListener(a.this.nan);
            AppMethodBeat.o(159862);
          }
        };
        parama.mPopupWindow.setOnDismissListener((PopupWindow.OnDismissListener)localObject);
      }
      this.Ywu = new b(false);
      this.Ywx.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159851);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/textview/SelectableTextHelper$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
          av.d("SelectableTextHelper", "onLongClick.", new Object[0]);
          a.this.YwD = false;
          int j;
          if (a.this.Ywy != null)
          {
            a.this.YwG = true;
            a.this.YwH = false;
            a.this.YwI = false;
            Object localObject2 = b.iX(a.this.Ywx);
            if ((localObject2 instanceof SpannableString))
            {
              localObject1 = a.this;
              localObject2 = (SpannableString)localObject2;
              ((a)localObject1).YwL = new ArrayList();
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
                  ((a)localObject1).YwL.add(localObject3);
                }
                for (;;)
                {
                  av.d("SelectableTextHelper", "spans from %d to %d.", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
                  i = j;
                  break;
                  av.e("SelectableTextHelper", "other situation occur! length: %d.", new Object[] { Integer.valueOf(localObject3.length) });
                }
              }
              av.d("SelectableTextHelper", ((a)localObject1).YwL.toString(), new Object[0]);
            }
            a.this.cpq();
            if ((a.this.YwC > 0) && (a.this.YwC < b.iX(a.this.Ywx).length()))
            {
              a.a(a.this, a.this.YwC);
              a.this.YwE = false;
              a.this.YwF = false;
              a.this.iek();
              a.this.ief();
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/textview/SelectableTextHelper$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(159851);
              return true;
              a.a(a.this, b.iX(a.this.Ywx).length());
              a.this.YwE = true;
              a.this.YwF = false;
              a.this.ief();
              a.this.Ywy.eD(paramAnonymousView);
            }
          }
          a.this.YwG = false;
          paramAnonymousView = a.this;
          int k = a.this.Yod;
          int i = a.this.Yoe;
          localObject1 = paramAnonymousView.Ywx;
          if ((localObject1 instanceof NeatTextView))
          {
            localObject1 = ((NeatTextView)localObject1).getLayout();
            if (localObject1 == null) {
              break label635;
            }
            i = ((com.tencent.neattextview.textview.layout.a)localObject1).nE(k, i);
          }
          for (;;)
          {
            paramAnonymousView.ng(i, i + 1);
            a.this.cpq();
            a.this.YwE = false;
            a.this.YwF = false;
            a.this.iek();
            a.this.ief();
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
      this.Ywx.setOnTouchListener(this.nan);
      this.Ywx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159852);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/textview/SelectableTextHelper$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          av.d("SelectableTextHelper", "onClick", new Object[0]);
          if (a.this.kte != null) {
            a.this.kte.onClick(paramAnonymousView);
          }
          a.this.YwE = true;
          a.this.YwF = true;
          a.this.cpq();
          a.this.cpn();
          if (a.this.Ywy != null) {
            a.this.Ywy.dismiss();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/textview/SelectableTextHelper$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(159852);
        }
      });
      this.Ywx.addOnAttachStateChangeListener(this.lF);
      this.Ywx.getViewTreeObserver().addOnPreDrawListener(this.aqE);
      this.Ywx.getViewTreeObserver().addOnScrollChangedListener(this.YnQ);
      this.Ywx.getViewTreeObserver().addOnGlobalLayoutListener(this.qc);
      this.Ywx.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(159853);
          a.this.Ywx.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          if (a.this.Ywy != null)
          {
            a.this.Ywx.getLocationInWindow(a.this.BdE);
            av.d("SelectableTextHelper", "init: loc-x: %d, loc-y: %d.", new Object[] { Integer.valueOf(a.this.BdE[0]), Integer.valueOf(a.this.BdE[1]) });
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
    for (int i = this.Ywv.tH; (i < 0) || (i > b.iX(this.Ywx).length()); i = this.Ywv.tI)
    {
      AppMethodBeat.o(159884);
      return;
    }
    Object localObject = b.iY(this.Ywx);
    int j;
    if (localObject != null)
    {
      j = (int)((TextPaint)localObject).getFontMetrics().descent + b.aY(this.Ywx, b.aZ(this.Ywx, i));
      i = (int)b.ba(this.Ywx, i);
    }
    for (;;)
    {
      paramb.YwM.Ywx.getLocationInWindow(paramb.Ykw);
      if (paramb.Yon) {}
      for (int k = paramb.mWidth;; k = 0)
      {
        int n = i;
        int m = j;
        if (!paramb.Yon)
        {
          localObject = paramb.nh(i, j);
          n = localObject[0];
          m = localObject[1];
        }
        try
        {
          paramb.mPopupWindow.showAtLocation(paramb.YwM.Ywx, 0, n - k + paramb.getExtraX(), m + paramb.getExtraY());
          AppMethodBeat.o(159884);
          return;
        }
        catch (Exception paramb)
        {
          av.e("SelectableTextHelper", "error! message: %s.", new Object[] { paramb.getMessage() });
          AppMethodBeat.o(159884);
          return;
        }
      }
      i = 0;
      j = 0;
    }
  }
  
  private int ch(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(159893);
    if (this.YwL != null)
    {
      Iterator localIterator = this.YwL.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.SA(paramInt))
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
  
  private boolean hJe()
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
  
  public final void cpn()
  {
    AppMethodBeat.i(159882);
    this.Ywv.Yov = null;
    if ((this.Yfs != null) && (this.YwB != null))
    {
      this.Yfs.removeSpan(this.YwB);
      this.YwB = null;
    }
    AppMethodBeat.o(159882);
  }
  
  public final void cpq()
  {
    AppMethodBeat.i(159881);
    ieg();
    ieh();
    if (this.Ywy != null) {
      this.Ywy.dismiss();
    }
    AppMethodBeat.o(159881);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(159880);
    this.YwD = false;
    this.aJQ = true;
    this.YnZ = false;
    this.Ywx.removeCallbacks(this.Yoj);
    this.Ywx.getViewTreeObserver().removeOnScrollChangedListener(this.YnQ);
    this.Ywx.getViewTreeObserver().removeOnPreDrawListener(this.aqE);
    this.Ywx.getViewTreeObserver().removeOnGlobalLayoutListener(this.qc);
    this.Ywx.removeOnAttachStateChangeListener(this.lF);
    this.YwE = true;
    this.YwF = true;
    cpq();
    cpn();
    this.Ywt = null;
    this.Ywu = null;
    if (this.Ywy != null) {
      this.Ywy.dismiss();
    }
    AppMethodBeat.o(159880);
  }
  
  public final void fj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159892);
    if (paramInt1 != -1) {
      this.Ywv.tH = ch(paramInt1, true);
    }
    if (paramInt2 != -1) {
      this.Ywv.tI = ch(paramInt2, false);
    }
    if ((this.Ywv.tH < 0) || (this.Ywv.tH > b.iX(this.Ywx).length()))
    {
      AppMethodBeat.o(159892);
      return;
    }
    if ((this.Ywv.tI < 0) || (this.Ywv.tI > b.iX(this.Ywx).length()))
    {
      AppMethodBeat.o(159892);
      return;
    }
    if (this.Ywv.tH > this.Ywv.tI)
    {
      paramInt1 = this.Ywv.tH;
      this.Ywv.tH = this.Ywv.tI;
      this.Ywv.tI = paramInt1;
    }
    if (this.Yfs != null)
    {
      this.Ywv.Yov = this.Yfs.subSequence(this.Ywv.tH, this.Ywv.tI).toString();
      if (this.YwB == null) {
        break label314;
      }
      this.YwB.setPosition(this.Ywv.tH, this.Ywv.tI);
    }
    for (;;)
    {
      paramInt1 = b.aZ(this.Ywx, this.Ywv.tH);
      paramInt1 = b.be(this.Ywx, paramInt1);
      this.Yfs.setSpan(this.YwB, paramInt1, this.Ywv.tI, 17);
      if (this.Yww != null) {
        this.Yww.aH(this.Ywv.Yov);
      }
      AppMethodBeat.o(159892);
      return;
      label314:
      this.YwB = new c(this.Ywx, this.mContext.getResources().getColor(this.YnW), this.Ywv.tH, this.Ywv.tI);
    }
  }
  
  public final void ief()
  {
    AppMethodBeat.i(159886);
    if (!hJe())
    {
      a(this.Ywt);
      a(this.Ywu);
    }
    AppMethodBeat.o(159886);
  }
  
  public final void ieg()
  {
    AppMethodBeat.i(159887);
    if (this.Ywt != null) {
      this.Ywt.mPopupWindow.dismiss();
    }
    if (this.Ywu != null) {
      this.Ywu.mPopupWindow.dismiss();
    }
    AppMethodBeat.o(159887);
  }
  
  public final void ieh()
  {
    AppMethodBeat.i(159888);
    if (this.YwA != null) {
      this.YwA.cFD();
    }
    AppMethodBeat.o(159888);
  }
  
  public final void iei()
  {
    AppMethodBeat.i(159889);
    if (this.Ywy != null) {
      this.Ywy.hW(this.Ywx);
    }
    AppMethodBeat.o(159889);
  }
  
  public final void iej()
  {
    AppMethodBeat.i(159890);
    if (this.Ywy != null) {
      this.Ywy.dismiss();
    }
    AppMethodBeat.o(159890);
  }
  
  public final void iek()
  {
    AppMethodBeat.i(159891);
    int i;
    int j;
    if (this.YwA != null)
    {
      int[] arrayOfInt = new int[2];
      this.Ywx.getLocationInWindow(arrayOfInt);
      float f3 = b.ba(this.Ywx, this.Ywv.tH);
      float f2 = b.ba(this.Ywx, this.Ywv.tI);
      i = b.aZ(this.Ywx, this.Ywv.tH);
      float f1;
      if (b.aZ(this.Ywx, this.Ywv.tI) <= i)
      {
        f1 = f2;
        if (f2 > f3) {}
      }
      else
      {
        f1 = b.bd(this.Ywx, b.aZ(this.Ywx, this.Ywv.tH));
      }
      i = (int)((f1 + f3) / 2.0F);
      j = this.Cxs + i;
      int k = b.bb(this.Ywx, b.aZ(this.Ywx, this.Ywv.tH)) + arrayOfInt[1] + this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.cr.a.d.edgePadding);
      av.d("SelectableTextHelper", "dancy test posX:%s, startline:%s, endline:%s, leftpadding:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(b.aZ(this.Ywx, this.Ywv.tH)), Integer.valueOf(b.aZ(this.Ywx, this.Ywv.tI)), Integer.valueOf(this.Cxs) });
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
      this.YwA.eY(i, j);
      if (this.Ywy != null) {
        this.Ywy.hTL();
      }
      AppMethodBeat.o(159891);
      return;
    }
  }
  
  final void ng(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159883);
    cpn();
    if ((b.iX(this.Ywx) instanceof Spannable)) {
      this.Yfs = ((Spannable)b.iX(this.Ywx));
    }
    if ((this.Yfs == null) || (paramInt1 >= b.iX(this.Ywx).length()))
    {
      this.Ywv.tH = 0;
      this.Ywv.tI = 0;
      AppMethodBeat.o(159883);
      return;
    }
    fj(paramInt1, paramInt2);
    AppMethodBeat.o(159883);
  }
  
  public static final class a
  {
    public int YnW = com.tencent.mm.cr.a.c.selected_blue;
    public int YnX = com.tencent.mm.cr.a.c.cursor_handle_color;
    com.tencent.mm.ui.widget.b.a YwN;
    public int YwO = 0;
    public int YwP = 0;
    View Ywx;
    a.f Ywy;
    View.OnTouchListener Ywz;
    View.OnClickListener kte;
    
    private a(View paramView, com.tencent.mm.ui.widget.b.a parama)
    {
      this.Ywx = paramView;
      this.YwN = parama;
    }
    
    public a(View paramView, com.tencent.mm.ui.widget.b.a parama, a.f paramf, View.OnClickListener paramOnClickListener, View.OnTouchListener paramOnTouchListener)
    {
      this(paramView, parama);
      this.Ywy = paramf;
      this.kte = paramOnClickListener;
      this.Ywz = paramOnTouchListener;
    }
    
    public final a iel()
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
    private int Dvd;
    private int Dve;
    private int[] Dvf;
    int[] Ykw;
    boolean Yon;
    private int Yoo;
    private int Yop;
    private boolean YwQ;
    private Rect byG;
    private int clC;
    private int mHeight;
    private Paint mPaint;
    PopupWindow mPopupWindow;
    int mWidth;
    private Point qGg;
    private int uue;
    
    b(boolean paramBoolean)
    {
      super();
      AppMethodBeat.i(159864);
      this.uue = (a.this.YnY / 2);
      this.mWidth = (this.uue * 2);
      this.mHeight = (this.uue * 2);
      this.clC = 25;
      this.Ykw = new int[2];
      this.byG = new Rect();
      this.qGg = new Point();
      this.YwQ = false;
      this.Dvf = new int[2];
      this.Yon = paramBoolean;
      this.mPaint = new Paint(1);
      this.mPaint.setColor(a.this.mContext.getResources().getColor(a.this.YnX));
      this.mPopupWindow = new PopupWindow(this);
      this.mPopupWindow.setClippingEnabled(false);
      this.mPopupWindow.setWidth(this.mWidth + this.clC * 2);
      this.mPopupWindow.setHeight(this.mHeight + this.clC / 2);
      AppMethodBeat.o(159864);
    }
    
    private void icK()
    {
      AppMethodBeat.i(159867);
      if (!this.Yon) {}
      for (boolean bool = true;; bool = false)
      {
        this.Yon = bool;
        invalidate();
        AppMethodBeat.o(159867);
        return;
      }
    }
    
    private void icL()
    {
      AppMethodBeat.i(159869);
      a.this.Ywx.getLocationInWindow(this.Ykw);
      Object localObject = b.iY(a.this.Ywx);
      if (localObject != null)
      {
        int i = (int)((TextPaint)localObject).getFontMetrics().descent;
        if (this.Yon)
        {
          this.mPopupWindow.update((int)b.ba(a.this.Ywx, a.this.Ywv.tH) - this.mWidth + getExtraX(), i + b.aY(a.this.Ywx, b.aZ(a.this.Ywx, a.this.Ywv.tH)) + getExtraY(), -1, -1);
          AppMethodBeat.o(159869);
          return;
        }
        localObject = nh((int)b.ba(a.this.Ywx, a.this.Ywv.tI), i + b.aY(a.this.Ywx, b.aZ(a.this.Ywx, a.this.Ywv.tI)));
        i = localObject[0];
        int j = localObject[1];
        this.mPopupWindow.update(i + getExtraX(), j + getExtraY(), -1, -1);
      }
      AppMethodBeat.o(159869);
    }
    
    private void kC(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159868);
      a.this.Ywx.getLocationInWindow(this.Ykw);
      int i;
      b localb;
      if (this.Yon)
      {
        i = a.this.Ywv.tH;
        int j = this.Ykw[1];
        paramInt1 = b.i(a.this.Ywx, paramInt1, paramInt2 - j, i);
        if (paramInt1 == i) {
          break label225;
        }
        a.this.cpn();
        if (!this.Yon) {
          break label169;
        }
        if (paramInt1 <= this.Yop) {
          break label157;
        }
        localb = a.a(a.this, false);
        icK();
        localb.icK();
        this.Yoo = this.Yop;
        a.this.fj(this.Yop, paramInt1);
        localb.icL();
      }
      for (;;)
      {
        icL();
        AppMethodBeat.o(159868);
        return;
        i = a.this.Ywv.tI;
        break;
        label157:
        a.this.fj(paramInt1, -1);
      }
      label169:
      if (paramInt1 < this.Yoo)
      {
        localb = a.a(a.this, true);
        localb.icK();
        icK();
        this.Yop = this.Yoo;
        a.this.fj(paramInt1, this.Yoo);
        localb.icL();
      }
      for (;;)
      {
        icL();
        label225:
        AppMethodBeat.o(159868);
        return;
        a.this.fj(this.Yoo, paramInt1);
      }
    }
    
    public final int getExtraX()
    {
      AppMethodBeat.i(159870);
      int i = this.Ykw[0];
      int j = this.clC;
      int k = a.this.Ywx.getPaddingLeft();
      AppMethodBeat.o(159870);
      return i - j + k;
    }
    
    public final int getExtraY()
    {
      AppMethodBeat.i(159871);
      int i = this.Ykw[1];
      int j = a.this.Ywx.getPaddingTop();
      AppMethodBeat.o(159871);
      return i + j;
    }
    
    final int[] nh(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159872);
      int j = paramInt1;
      int i = paramInt2;
      if (paramInt1 == 0)
      {
        j = paramInt1;
        i = paramInt2;
        if (a.this.Ywv.tI > 1)
        {
          a.this.Ywx.getLocationInWindow(this.Ykw);
          TextPaint localTextPaint = b.iY(a.this.Ywx);
          j = paramInt1;
          i = paramInt2;
          if (localTextPaint != null)
          {
            paramInt1 = (int)localTextPaint.getFontMetrics().descent;
            paramInt2 = b.aZ(a.this.Ywx, a.this.Ywv.tI - 1);
            j = (int)b.bd(a.this.Ywx, paramInt2);
            i = b.aY(a.this.Ywx, b.aZ(a.this.Ywx, a.this.Ywv.tI - 1)) + paramInt1;
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
      if (a.this.Ywy != null) {
        if (this.Yon)
        {
          i = a.this.Ywv.tH;
          TextPaint localTextPaint = b.iY(a.this.Ywx);
          if (localTextPaint == null) {
            break label485;
          }
          j = b.aY(a.this.Ywx, b.aZ(a.this.Ywx, i));
          j = (int)localTextPaint.getFontMetrics().descent + j;
          k = (int)b.ba(a.this.Ywx, i);
          i = j;
          j = k;
        }
      }
      for (;;)
      {
        a.this.Ywx.getLocationInWindow(this.Ykw);
        k = i;
        if (!this.Yon) {
          k = nh(j, i)[1];
        }
        i = getExtraY() + k;
        if (a.this.Ywx.getGlobalVisibleRect(this.byG, this.qGg))
        {
          if (i >= this.byG.bottom)
          {
            if (this.Yon)
            {
              av.d("SelectableTextHelper", "start below bottom, dismiss all.", new Object[0]);
              a.this.cpn();
              a.this.YwE = true;
              a.this.YwF = true;
              a.this.cpq();
              a.this.Ywy.dismiss();
            }
            av.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
            AppMethodBeat.o(159865);
            return;
            i = a.this.Ywv.tI;
            break;
          }
          if (i > this.byG.top) {
            break label373;
          }
          if (!this.Yon)
          {
            av.d("SelectableTextHelper", "end above top, dismiss all.", new Object[0]);
            a.this.cpn();
            a.this.YwE = true;
            a.this.YwF = true;
            a.this.cpq();
            a.this.Ywy.dismiss();
          }
          av.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
          AppMethodBeat.o(159865);
          return;
        }
        av.d("SelectableTextHelper", "view invisible.", new Object[0]);
        AppMethodBeat.o(159865);
        return;
        label373:
        paramCanvas.drawCircle(this.uue + this.clC, this.uue, this.uue, this.mPaint);
        if (this.Yon)
        {
          paramCanvas.drawRect(this.uue + this.clC, 0.0F, this.uue * 2 + this.clC, this.uue, this.mPaint);
          AppMethodBeat.o(159865);
          return;
        }
        paramCanvas.drawRect(this.clC, 0.0F, this.uue + this.clC, this.uue, this.mPaint);
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
        this.Yoo = a.this.Ywv.tH;
        this.Yop = a.this.Ywv.tI;
        this.Dvd = ((int)paramMotionEvent.getX());
        this.Dve = ((int)paramMotionEvent.getY());
        this.YwQ = false;
        a.this.Ywx.getLocationOnScreen(this.Dvf);
        continue;
        if ((a.this.Ywy != null) && (!this.YwQ))
        {
          this.YwQ = true;
          a.this.Ywy.hTJ();
          if (a.this.Ywv.tI - a.this.Ywv.tH == b.iX(a.this.Ywx).length())
          {
            a.this.Ywy.hW(a.this.Ywx);
            a.this.YwE = true;
            a.this.ieh();
          }
          for (;;)
          {
            a.this.Ywy.hTK();
            break;
            a.this.Ywy.dismiss();
            a.this.YwE = false;
            a.this.iek();
          }
        }
        if (!a.this.YwE)
        {
          a.this.iek();
          continue;
          if (a.this.Ywy != null)
          {
            a.this.Ywy.hTJ();
            a.this.Ywy.dismiss();
          }
          a.this.ieh();
          int i = (int)paramMotionEvent.getRawX();
          int j = (int)paramMotionEvent.getRawY();
          if (a.this.Ywy == null) {
            kC(i - this.Dvf[0], j + this.Dve - this.mHeight - a.this.Yoa);
          }
          for (;;)
          {
            if (a.this.Ywy == null) {
              break label430;
            }
            a.this.Ywy.hTK();
            break;
            kC(i - this.Dvf[0] + this.uue, j + this.Dve - this.mHeight - a.this.Yoa);
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
    
    final boolean SA(int paramInt)
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
    public abstract void aH(CharSequence paramCharSequence);
  }
  
  public static abstract interface e
  {
    public abstract void hTP();
  }
  
  final class g
  {
    String Yov;
    int tH;
    int tI;
    
    g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a
 * JD-Core Version:    0.7.0.1
 */