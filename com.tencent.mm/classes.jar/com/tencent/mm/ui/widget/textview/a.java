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
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.c;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  int[] Gok;
  b HND;
  private b HNE;
  g HNF;
  public d HNG;
  View HNH;
  public f HNI;
  View.OnTouchListener HNJ;
  private Spannable HNK;
  private com.tencent.mm.ui.widget.b.a HNL;
  int HNM;
  int HNN;
  private int HNO;
  int HNP;
  int HNQ;
  private c HNR;
  int HNS;
  public int HNT;
  private ViewTreeObserver.OnScrollChangedListener HNU;
  boolean HNV;
  boolean HNW;
  public boolean HNX;
  public boolean HNY;
  boolean HNZ;
  boolean HOa;
  boolean HOb;
  final Runnable HOc;
  final Runnable HOd;
  public e HOe;
  ArrayList<c> HOf;
  private boolean aJO;
  private View.OnAttachStateChangeListener acy;
  private ViewTreeObserver.OnGlobalLayoutListener agI;
  Context mContext;
  View.OnClickListener pgj;
  int[] ssm;
  private ViewTreeObserver.OnPreDrawListener yo;
  View.OnTouchListener zrL;
  
  public a(a parama)
  {
    AppMethodBeat.i(159878);
    this.HNF = new g();
    this.HNV = false;
    this.aJO = true;
    this.HNW = false;
    this.HNX = true;
    this.HNY = true;
    this.HNZ = true;
    this.HOa = false;
    this.HOb = false;
    this.ssm = new int[2];
    this.HOc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159850);
        if (a.this.HNV)
        {
          an.d("SelectableTextHelper", "isReInit, return.", new Object[0]);
          AppMethodBeat.o(159850);
          return;
        }
        an.d("SelectableTextHelper", "in mShowSelectViewRunnable. opener: %s, inScrolling: %s.", new Object[] { Boolean.valueOf(a.this.HNZ), Boolean.valueOf(a.this.HOa) });
        if (a.this.HNI != null)
        {
          if (!a.this.HNZ)
          {
            a.this.HNZ = true;
            if (a.this.HOa)
            {
              an.d("SelectableTextHelper", "menu is hide: %s, cursor is hide: %s.", new Object[] { Boolean.valueOf(a.this.HNX), Boolean.valueOf(a.this.HNY) });
              if (!a.this.HNX) {
                a.this.fgM();
              }
              if (!a.this.HNY)
              {
                a.this.fgH();
                a.this.jQ(a.this.HNF.asw, a.this.HNF.Mc);
              }
              if ((a.this.HNI != null) && (a.this.HNX) && (!a.this.HNY)) {
                a.this.HNI.fL(a.this.HNH);
              }
            }
            a.this.HOa = false;
            AppMethodBeat.o(159850);
            return;
          }
          if (a.this.HOb)
          {
            a.this.HOb = false;
            an.d("SelectableTextHelper", "judge result(delay), click outside.", new Object[0]);
            if (a.this.HOe != null)
            {
              a.this.HOe.faO();
              AppMethodBeat.o(159850);
            }
          }
          else
          {
            an.d("SelectableTextHelper", "Oh, bypass the judge logic! Don't worry, that's reasonable.", new Object[0]);
            AppMethodBeat.o(159850);
          }
        }
        else
        {
          if (!a.this.HNX) {
            a.this.fgM();
          }
          if (!a.this.HNY) {
            a.this.fgH();
          }
        }
        AppMethodBeat.o(159850);
      }
    };
    this.HOd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159854);
        an.d("SelectableTextHelper", "dismiss all runnable.", new Object[0]);
        if (a.this.HOe != null) {
          a.this.HOe.faO();
        }
        AppMethodBeat.o(159854);
      }
    };
    this.Gok = new int[2];
    this.HNH = parama.HNH;
    this.HNI = parama.HNI;
    this.pgj = parama.pgj;
    this.HNJ = parama.HNJ;
    this.HNL = parama.HOh;
    this.mContext = this.HNH.getContext();
    this.HNO = parama.HNO;
    this.HNP = parama.HNP;
    View localView = this.HNH;
    int i;
    float f;
    if ((localView instanceof NeatTextView))
    {
      i = ((NeatTextView)localView).getLineHeight();
      this.HNS = i;
      if (this.HNQ != 0) {
        break label345;
      }
      parama = this.HNH;
      if (!(parama instanceof NeatTextView)) {
        break label322;
      }
      f = ((NeatTextView)parama).getTextSize();
    }
    label221:
    for (this.HNQ = ((int)f);; this.HNQ = ao.fromDPToPix(this.mContext, parama.HOi))
    {
      this.acy = new View.OnAttachStateChangeListener()
      {
        public final void onViewAttachedToWindow(View paramAnonymousView)
        {
          AppMethodBeat.i(159855);
          an.d("SelectableTextHelper", "onViewAttachedToWindow", new Object[0]);
          AppMethodBeat.o(159855);
        }
        
        public final void onViewDetachedFromWindow(View paramAnonymousView)
        {
          AppMethodBeat.i(159856);
          an.d("SelectableTextHelper", "onViewDetachedFromWindow", new Object[0]);
          a.this.destroy();
          AppMethodBeat.o(159856);
        }
      };
      this.yo = new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(159857);
          if (a.this.HNW)
          {
            a.this.HNW = false;
            a locala = a.this;
            locala.HNH.removeCallbacks(locala.HOc);
            locala.HNH.postDelayed(locala.HOc, 100L);
          }
          AppMethodBeat.o(159857);
          return true;
        }
      };
      this.HNU = new ViewTreeObserver.OnScrollChangedListener()
      {
        public final void onScrollChanged()
        {
          AppMethodBeat.i(159858);
          if (a.this.HNI != null)
          {
            a.this.HNH.removeCallbacks(a.this.HOd);
            a.this.HNH.getLocationInWindow(a.this.Gok);
            an.d("SelectableTextHelper", "onScrollChanged, old-y: %d, y: %d.", new Object[] { Integer.valueOf(a.this.ssm[1]), Integer.valueOf(a.this.Gok[1]) });
            if (a.this.HNZ)
            {
              if ((a.this.HOa) || (a.this.HOb)) {
                break label260;
              }
              if (a.this.ssm[1] == a.this.Gok[1]) {
                break label238;
              }
              a.this.HOa = true;
              a.this.HNZ = false;
              an.d("SelectableTextHelper", "judge result, inScrolling.", new Object[0]);
            }
          }
          for (;;)
          {
            a.this.ssm[1] = a.this.Gok[1];
            if ((!a.this.HNW) && ((!a.this.HNX) || (!a.this.HNY)))
            {
              a.this.HNW = true;
              a.this.fgE();
            }
            AppMethodBeat.o(159858);
            return;
            label238:
            a.this.HOb = true;
            an.d("SelectableTextHelper", "need delay judge.", new Object[0]);
            continue;
            label260:
            if (a.this.HOb)
            {
              a.this.HOb = false;
              a.this.HNZ = false;
              if (a.this.ssm[1] != a.this.Gok[1])
              {
                a.this.HOa = true;
                an.d("SelectableTextHelper", "judge result(delay), inScrolling.", new Object[0]);
              }
              else
              {
                a.this.HOa = false;
                an.d("SelectableTextHelper", "judge result, click outside.", new Object[0]);
              }
            }
          }
        }
      };
      this.agI = new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(159859);
          an.d("SelectableTextHelper", "onGlobalLayout", new Object[0]);
          AppMethodBeat.o(159859);
        }
      };
      this.zrL = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(159860);
          an.d("SelectableTextHelper", "event pointer count: %d.", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getPointerCount()) });
          if (a.this.HNJ != null) {
            a.this.HNJ.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          }
          a.this.HNM = ((int)paramAnonymousMotionEvent.getX());
          a.this.HNN = ((int)paramAnonymousMotionEvent.getY());
          AppMethodBeat.o(159860);
          return false;
        }
      };
      init();
      AppMethodBeat.o(159878);
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
  
  private void a(b paramb)
  {
    AppMethodBeat.i(159884);
    if (paramb == null)
    {
      AppMethodBeat.o(159884);
      return;
    }
    if (b.b(paramb)) {}
    for (int i = this.HNF.asw; (i < 0) || (i > b.gA(this.HNH).length()); i = this.HNF.Mc)
    {
      AppMethodBeat.o(159884);
      return;
    }
    Object localObject = b.gB(this.HNH);
    int j;
    if (localObject != null)
    {
      j = (int)((TextPaint)localObject).getFontMetrics().descent + b.aH(this.HNH, b.aI(this.HNH, i));
      i = (int)b.aJ(this.HNH, i);
    }
    for (;;)
    {
      paramb.HOg.HNH.getLocationInWindow(paramb.HOo);
      if (paramb.HOj) {}
      for (int k = paramb.mWidth;; k = 0)
      {
        int n = i;
        int m = j;
        if (!paramb.HOj)
        {
          localObject = paramb.jR(i, j);
          n = localObject[0];
          m = localObject[1];
        }
        try
        {
          paramb.mPopupWindow.showAtLocation(paramb.HOg.HNH, 0, n - k + paramb.fgQ(), m + paramb.fgR());
          AppMethodBeat.o(159884);
          return;
        }
        catch (Exception paramb)
        {
          an.e("SelectableTextHelper", "error! message: %s.", new Object[] { paramb.getMessage() });
          AppMethodBeat.o(159884);
          return;
        }
      }
      i = 0;
      j = 0;
    }
  }
  
  private int ba(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(159893);
    if (this.HOf != null)
    {
      Iterator localIterator = this.HOf.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.DE(paramInt))
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
  
  private boolean fgG()
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
    this.HNV = false;
    this.aJO = true;
    this.HNW = false;
    this.HNH.removeCallbacks(this.HOc);
    this.HNH.getViewTreeObserver().removeOnScrollChangedListener(this.HNU);
    this.HNH.getViewTreeObserver().removeOnPreDrawListener(this.yo);
    this.HNH.getViewTreeObserver().removeOnGlobalLayoutListener(this.agI);
    this.HNH.removeOnAttachStateChangeListener(this.acy);
    this.HNX = true;
    this.HNY = true;
    fgE();
    fgF();
    this.HND = null;
    this.HNE = null;
    if (this.HNI != null) {
      this.HNI.dismiss();
    }
    AppMethodBeat.o(159880);
  }
  
  public final void fgE()
  {
    AppMethodBeat.i(159881);
    fgI();
    fgJ();
    if (this.HNI != null) {
      this.HNI.dismiss();
    }
    AppMethodBeat.o(159881);
  }
  
  public final void fgF()
  {
    AppMethodBeat.i(159882);
    this.HNF.HOr = null;
    if ((this.HNK != null) && (this.HNR != null))
    {
      this.HNK.removeSpan(this.HNR);
      this.HNR = null;
    }
    AppMethodBeat.o(159882);
  }
  
  public final void fgH()
  {
    AppMethodBeat.i(159886);
    if (!fgG())
    {
      a(this.HND);
      a(this.HNE);
    }
    AppMethodBeat.o(159886);
  }
  
  public final void fgI()
  {
    AppMethodBeat.i(159887);
    if (this.HND != null) {
      this.HND.mPopupWindow.dismiss();
    }
    if (this.HNE != null) {
      this.HNE.mPopupWindow.dismiss();
    }
    AppMethodBeat.o(159887);
  }
  
  public final void fgJ()
  {
    AppMethodBeat.i(159888);
    if (this.HNL != null) {
      this.HNL.eVf();
    }
    AppMethodBeat.o(159888);
  }
  
  public final void fgK()
  {
    AppMethodBeat.i(159889);
    if (this.HNI != null) {
      this.HNI.fL(this.HNH);
    }
    AppMethodBeat.o(159889);
  }
  
  public final void fgL()
  {
    AppMethodBeat.i(159890);
    if (this.HNI != null) {
      this.HNI.dismiss();
    }
    AppMethodBeat.o(159890);
  }
  
  public final void fgM()
  {
    int j = 16;
    AppMethodBeat.i(159891);
    int i;
    int m;
    if (this.HNL != null)
    {
      int[] arrayOfInt = new int[2];
      this.HNH.getLocationInWindow(arrayOfInt);
      int k = (int)b.aJ(this.HNH, this.HNF.asw) + arrayOfInt[0];
      i = b.aK(this.HNH, b.aI(this.HNH, this.HNF.asw));
      m = arrayOfInt[1] + i - 16;
      i = k;
      if (k <= 0) {
        i = 16;
      }
      if (m >= 0) {
        break label154;
      }
    }
    for (;;)
    {
      if (i > b.getScreenWidth(this.mContext)) {
        i = b.getScreenWidth(this.mContext) - 16;
      }
      for (;;)
      {
        this.HNL.eh(i, j);
        if (this.HNI != null) {
          this.HNI.faK();
        }
        AppMethodBeat.o(159891);
        return;
      }
      label154:
      j = m;
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(159879);
    if (!this.aJO)
    {
      an.d("SelectableTextHelper", "not destroy, isReInit: %s.", new Object[] { Boolean.valueOf(this.HNV) });
      this.HNV = true;
      AppMethodBeat.o(159879);
      return;
    }
    an.d("SelectableTextHelper", "not init yet, need to init.", new Object[0]);
    this.HNV = false;
    this.aJO = false;
    this.HNW = false;
    if (this.HNI == null) {
      b.a(this.HNH, b.gA(this.HNH), TextView.BufferType.SPANNABLE);
    }
    this.HND = new b(true);
    if (this.HNI != null)
    {
      this.HND.fgS();
      this.HND.setTouchInterceptor(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(159861);
          an.d("SelectableTextHelper", "interceptor onTouch.", new Object[0]);
          int i = (int)paramAnonymousMotionEvent.getX();
          int j = (int)paramAnonymousMotionEvent.getY();
          if ((paramAnonymousMotionEvent.getAction() == 0) && ((i < 0) || (i >= a.this.HND.getWidth()) || (j < 0) || (j >= a.this.HND.getHeight())))
          {
            an.d("SelectableTextHelper", "interceptor onTouch, down, outside.", new Object[0]);
            a.this.HNH.postDelayed(a.this.HOd, 100L);
            AppMethodBeat.o(159861);
            return true;
          }
          if (paramAnonymousMotionEvent.getAction() == 4)
          {
            an.d("SelectableTextHelper", "interceptor onTouch, outside.", new Object[0]);
            a.this.HNH.postDelayed(a.this.HOd, 100L);
            AppMethodBeat.o(159861);
            return true;
          }
          AppMethodBeat.o(159861);
          return false;
        }
      });
      this.HND.setOnDismissListener(new PopupWindow.OnDismissListener()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(159862);
          a.this.HNH.setOnTouchListener(a.this.zrL);
          AppMethodBeat.o(159862);
        }
      });
    }
    this.HNE = new b(false);
    this.HNH.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159851);
        an.d("SelectableTextHelper", "onLongClick.", new Object[0]);
        a.this.HNV = false;
        int j;
        if (a.this.HNI != null)
        {
          a.this.HNZ = true;
          a.this.HOa = false;
          a.this.HOb = false;
          Object localObject2 = b.gA(a.this.HNH);
          if ((localObject2 instanceof SpannableString))
          {
            localObject1 = a.this;
            localObject2 = (SpannableString)localObject2;
            ((a)localObject1).HOf = new ArrayList();
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
                ((a)localObject1).HOf.add(localObject3);
              }
              for (;;)
              {
                an.d("SelectableTextHelper", "spans from %d to %d.", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
                i = j;
                break;
                an.e("SelectableTextHelper", "other situation occur! length: %d.", new Object[] { Integer.valueOf(localObject3.length) });
              }
            }
            an.d("SelectableTextHelper", ((a)localObject1).HOf.toString(), new Object[0]);
          }
          a.this.fgE();
          if ((a.this.HNT > 0) && (a.this.HNT < b.gA(a.this.HNH).length()))
          {
            a.a(a.this, a.this.HNT);
            a.this.HNX = false;
            a.this.HNY = false;
            a.this.fgM();
            a.this.fgH();
          }
          for (;;)
          {
            AppMethodBeat.o(159851);
            return true;
            a.a(a.this, b.gA(a.this.HNH).length());
            a.this.HNX = true;
            a.this.HNY = false;
            a.this.fgH();
            a.this.HNI.fM(paramAnonymousView);
          }
        }
        a.this.HNZ = false;
        paramAnonymousView = a.this;
        int k = a.this.HNM;
        int i = a.this.HNN;
        Object localObject1 = paramAnonymousView.HNH;
        if ((localObject1 instanceof NeatTextView))
        {
          localObject1 = ((NeatTextView)localObject1).getLayout();
          if (localObject1 == null) {
            break label590;
          }
          i = ((com.tencent.neattextview.textview.layout.a)localObject1).kf(k, i);
        }
        for (;;)
        {
          paramAnonymousView.jP(i, i + 1);
          a.this.fgE();
          a.this.HNX = false;
          a.this.HNY = false;
          a.this.fgM();
          a.this.fgH();
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
            label590:
            i = 0;
          }
        }
      }
    });
    this.HNH.setOnTouchListener(this.zrL);
    this.HNH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159852);
        an.d("SelectableTextHelper", "onClick", new Object[0]);
        if (a.this.pgj != null) {
          a.this.pgj.onClick(paramAnonymousView);
        }
        a.this.HNX = true;
        a.this.HNY = true;
        a.this.fgE();
        a.this.fgF();
        if (a.this.HNI != null) {
          a.this.HNI.dismiss();
        }
        AppMethodBeat.o(159852);
      }
    });
    this.HNH.addOnAttachStateChangeListener(this.acy);
    this.HNH.getViewTreeObserver().addOnPreDrawListener(this.yo);
    this.HNH.getViewTreeObserver().addOnScrollChangedListener(this.HNU);
    this.HNH.getViewTreeObserver().addOnGlobalLayoutListener(this.agI);
    this.HNH.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(159853);
        a.this.HNH.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        if (a.this.HNI != null)
        {
          a.this.HNH.getLocationInWindow(a.this.ssm);
          an.d("SelectableTextHelper", "init: loc-x: %d, loc-y: %d.", new Object[] { Integer.valueOf(a.this.ssm[0]), Integer.valueOf(a.this.ssm[1]) });
        }
        AppMethodBeat.o(159853);
      }
    });
    AppMethodBeat.o(159879);
  }
  
  final void jP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159883);
    fgF();
    if ((b.gA(this.HNH) instanceof Spannable)) {
      this.HNK = ((Spannable)b.gA(this.HNH));
    }
    if ((this.HNK == null) || (paramInt1 >= b.gA(this.HNH).length()))
    {
      this.HNF.asw = 0;
      this.HNF.Mc = 0;
      AppMethodBeat.o(159883);
      return;
    }
    jQ(paramInt1, paramInt2);
    AppMethodBeat.o(159883);
  }
  
  public final void jQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159892);
    if (paramInt1 != -1) {
      this.HNF.asw = ba(paramInt1, true);
    }
    if (paramInt2 != -1) {
      this.HNF.Mc = ba(paramInt2, false);
    }
    if ((this.HNF.asw < 0) || (this.HNF.asw > b.gA(this.HNH).length()))
    {
      AppMethodBeat.o(159892);
      return;
    }
    if ((this.HNF.Mc < 0) || (this.HNF.Mc > b.gA(this.HNH).length()))
    {
      AppMethodBeat.o(159892);
      return;
    }
    if (this.HNF.asw > this.HNF.Mc)
    {
      paramInt1 = this.HNF.asw;
      this.HNF.asw = this.HNF.Mc;
      this.HNF.Mc = paramInt1;
    }
    if (this.HNK != null)
    {
      this.HNF.HOr = this.HNK.subSequence(this.HNF.asw, this.HNF.Mc).toString();
      if (this.HNR == null) {
        break label314;
      }
      this.HNR.setPosition(this.HNF.asw, this.HNF.Mc);
    }
    for (;;)
    {
      paramInt1 = b.aI(this.HNH, this.HNF.asw);
      paramInt1 = b.aN(this.HNH, paramInt1);
      this.HNK.setSpan(this.HNR, paramInt1, this.HNF.Mc, 17);
      if (this.HNG != null) {
        this.HNG.am(this.HNF.HOr);
      }
      AppMethodBeat.o(159892);
      return;
      label314:
      this.HNR = new c(this.HNH, this.mContext.getResources().getColor(this.HNO), this.HNF.asw, this.HNF.Mc);
    }
  }
  
  public static final class a
  {
    View HNH;
    a.f HNI;
    View.OnTouchListener HNJ;
    public int HNO = 2131100846;
    public int HNP = 2131100195;
    com.tencent.mm.ui.widget.b.a HOh;
    public int HOi = 0;
    View.OnClickListener pgj;
    
    public a(View paramView, com.tencent.mm.ui.widget.b.a parama)
    {
      this.HNH = paramView;
      this.HOh = parama;
    }
    
    public a(View paramView, com.tencent.mm.ui.widget.b.a parama, a.f paramf, View.OnClickListener paramOnClickListener, View.OnTouchListener paramOnTouchListener)
    {
      this(paramView, parama);
      this.HNI = paramf;
      this.pgj = paramOnClickListener;
      this.HNJ = paramOnTouchListener;
    }
    
    public final a fgN()
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
    private int[] Gok;
    boolean HOj;
    private int HOk;
    private int HOl;
    private int HOm;
    private int HOn;
    int[] HOo;
    private Point HOp;
    private boolean HOq;
    private int mHeight;
    private int mPadding;
    private Paint mPaint;
    PopupWindow mPopupWindow;
    int mWidth;
    private int ooS;
    private Rect rect;
    
    b(boolean paramBoolean)
    {
      super();
      AppMethodBeat.i(159864);
      this.ooS = (a.this.HNQ / 2);
      this.mWidth = (this.ooS * 2);
      this.mHeight = (this.ooS * 2);
      this.mPadding = 25;
      this.HOo = new int[2];
      this.rect = new Rect();
      this.HOp = new Point();
      this.HOq = false;
      this.Gok = new int[2];
      this.HOj = paramBoolean;
      this.mPaint = new Paint(1);
      this.mPaint.setColor(a.this.mContext.getResources().getColor(a.this.HNP));
      this.mPopupWindow = new PopupWindow(this);
      this.mPopupWindow.setClippingEnabled(false);
      this.mPopupWindow.setWidth(this.mWidth + this.mPadding * 2);
      this.mPopupWindow.setHeight(this.mHeight + this.mPadding / 2);
      AppMethodBeat.o(159864);
    }
    
    private void fgO()
    {
      AppMethodBeat.i(159867);
      if (!this.HOj) {}
      for (boolean bool = true;; bool = false)
      {
        this.HOj = bool;
        invalidate();
        AppMethodBeat.o(159867);
        return;
      }
    }
    
    private void fgP()
    {
      AppMethodBeat.i(159869);
      a.this.HNH.getLocationInWindow(this.HOo);
      Object localObject = b.gB(a.this.HNH);
      if (localObject != null)
      {
        int i = (int)((TextPaint)localObject).getFontMetrics().descent;
        if (this.HOj)
        {
          this.mPopupWindow.update((int)b.aJ(a.this.HNH, a.this.HNF.asw) - this.mWidth + fgQ(), i + b.aH(a.this.HNH, b.aI(a.this.HNH, a.this.HNF.asw)) + fgR(), -1, -1);
          AppMethodBeat.o(159869);
          return;
        }
        localObject = jR((int)b.aJ(a.this.HNH, a.this.HNF.Mc), i + b.aH(a.this.HNH, b.aI(a.this.HNH, a.this.HNF.Mc)));
        i = localObject[0];
        int j = localObject[1];
        this.mPopupWindow.update(i + fgQ(), j + fgR(), -1, -1);
      }
      AppMethodBeat.o(159869);
    }
    
    private void update(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159868);
      a.this.HNH.getLocationInWindow(this.HOo);
      int i;
      b localb;
      if (this.HOj)
      {
        i = a.this.HNF.asw;
        int j = this.HOo[1];
        paramInt1 = b.f(a.this.HNH, paramInt1, paramInt2 - j, i);
        if (paramInt1 == i) {
          break label225;
        }
        a.this.fgF();
        if (!this.HOj) {
          break label169;
        }
        if (paramInt1 <= this.HOn) {
          break label157;
        }
        localb = a.a(a.this, false);
        fgO();
        localb.fgO();
        this.HOm = this.HOn;
        a.this.jQ(this.HOn, paramInt1);
        localb.fgP();
      }
      for (;;)
      {
        fgP();
        AppMethodBeat.o(159868);
        return;
        i = a.this.HNF.Mc;
        break;
        label157:
        a.this.jQ(paramInt1, -1);
      }
      label169:
      if (paramInt1 < this.HOm)
      {
        localb = a.a(a.this, true);
        localb.fgO();
        fgO();
        this.HOn = this.HOm;
        a.this.jQ(paramInt1, this.HOm);
        localb.fgP();
      }
      for (;;)
      {
        fgP();
        label225:
        AppMethodBeat.o(159868);
        return;
        a.this.jQ(this.HOm, paramInt1);
      }
    }
    
    public final int fgQ()
    {
      AppMethodBeat.i(159870);
      int i = this.HOo[0];
      int j = this.mPadding;
      int k = a.this.HNH.getPaddingLeft();
      AppMethodBeat.o(159870);
      return i - j + k;
    }
    
    public final int fgR()
    {
      AppMethodBeat.i(159871);
      int i = this.HOo[1];
      int j = a.this.HNH.getPaddingTop();
      AppMethodBeat.o(159871);
      return i + j;
    }
    
    public final void fgS()
    {
      AppMethodBeat.i(159873);
      this.mPopupWindow.setOutsideTouchable(true);
      AppMethodBeat.o(159873);
    }
    
    final int[] jR(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159872);
      int j = paramInt1;
      int i = paramInt2;
      if (paramInt1 == 0)
      {
        j = paramInt1;
        i = paramInt2;
        if (a.this.HNF.Mc > 1)
        {
          a.this.HNH.getLocationInWindow(this.HOo);
          TextPaint localTextPaint = b.gB(a.this.HNH);
          j = paramInt1;
          i = paramInt2;
          if (localTextPaint != null)
          {
            paramInt1 = (int)localTextPaint.getFontMetrics().descent;
            paramInt2 = b.aI(a.this.HNH, a.this.HNF.Mc - 1);
            j = (int)b.aM(a.this.HNH, paramInt2);
            i = b.aH(a.this.HNH, b.aI(a.this.HNH, a.this.HNF.Mc - 1)) + paramInt1;
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
      if (a.this.HNI != null) {
        if (this.HOj)
        {
          i = a.this.HNF.asw;
          TextPaint localTextPaint = b.gB(a.this.HNH);
          if (localTextPaint == null) {
            break label486;
          }
          j = b.aH(a.this.HNH, b.aI(a.this.HNH, i));
          j = (int)localTextPaint.getFontMetrics().descent + j;
          k = (int)b.aJ(a.this.HNH, i);
          i = j;
          j = k;
        }
      }
      for (;;)
      {
        a.this.HNH.getLocationInWindow(this.HOo);
        k = i;
        if (!this.HOj) {
          k = jR(j, i)[1];
        }
        i = fgR() + k;
        if (a.this.HNH.getGlobalVisibleRect(this.rect, this.HOp))
        {
          if (i >= this.rect.bottom)
          {
            if (this.HOj)
            {
              an.d("SelectableTextHelper", "start below bottom, dismiss all.", new Object[0]);
              a.this.fgF();
              a.this.HNX = true;
              a.this.HNY = true;
              a.this.fgE();
              a.this.HNI.dismiss();
            }
            an.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
            AppMethodBeat.o(159865);
            return;
            i = a.this.HNF.Mc;
            break;
          }
          if (i > this.rect.top) {
            break label374;
          }
          if (!this.HOj)
          {
            an.d("SelectableTextHelper", "end above top, dismiss all.", new Object[0]);
            a.this.fgF();
            a.this.HNX = true;
            a.this.HNY = true;
            a.this.fgE();
            a.this.HNI.dismiss();
          }
          an.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
          AppMethodBeat.o(159865);
          return;
        }
        an.d("SelectableTextHelper", "view invisible.", new Object[0]);
        AppMethodBeat.o(159865);
        return;
        label374:
        paramCanvas.drawCircle(this.ooS + this.mPadding, this.ooS, this.ooS, this.mPaint);
        if (this.HOj)
        {
          paramCanvas.drawRect(this.ooS + this.mPadding, 0.0F, this.ooS * 2 + this.mPadding, this.ooS, this.mPaint);
          AppMethodBeat.o(159865);
          return;
        }
        paramCanvas.drawRect(this.mPadding, 0.0F, this.ooS + this.mPadding, this.ooS, this.mPaint);
        AppMethodBeat.o(159865);
        return;
        label486:
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
        this.HOm = a.this.HNF.asw;
        this.HOn = a.this.HNF.Mc;
        this.HOk = ((int)paramMotionEvent.getX());
        this.HOl = ((int)paramMotionEvent.getY());
        this.HOq = false;
        a.this.HNH.getLocationInWindow(this.Gok);
        continue;
        if ((a.this.HNI != null) && (!this.HOq))
        {
          this.HOq = true;
          a.this.HNI.faI();
          if (a.this.HNF.Mc - a.this.HNF.asw == b.gA(a.this.HNH).length())
          {
            a.this.HNI.fL(a.this.HNH);
            a.this.HNX = true;
            a.this.fgJ();
          }
          for (;;)
          {
            a.this.HNI.faJ();
            break;
            a.this.HNI.dismiss();
            a.this.HNX = false;
            a.this.fgM();
          }
        }
        if (!a.this.HNX)
        {
          a.this.fgM();
          continue;
          if (a.this.HNI != null)
          {
            a.this.HNI.faI();
            a.this.HNI.dismiss();
          }
          a.this.fgJ();
          int i = (int)paramMotionEvent.getRawX();
          int j = (int)paramMotionEvent.getRawY();
          if (a.this.HNI == null) {
            update(i - this.Gok[0], j + this.HOl - this.mHeight - a.this.HNS);
          }
          for (;;)
          {
            if (a.this.HNI == null) {
              break label430;
            }
            a.this.HNI.faJ();
            break;
            update(i - this.Gok[0] + this.ooS, j + this.HOl - this.mHeight - a.this.HNS);
          }
        }
      }
    }
    
    public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
    {
      AppMethodBeat.i(159875);
      this.mPopupWindow.setOnDismissListener(paramOnDismissListener);
      AppMethodBeat.o(159875);
    }
    
    public final void setTouchInterceptor(View.OnTouchListener paramOnTouchListener)
    {
      AppMethodBeat.i(159874);
      this.mPopupWindow.setTouchInterceptor(paramOnTouchListener);
      AppMethodBeat.o(159874);
    }
  }
  
  final class c
  {
    int end;
    int start;
    
    c() {}
    
    final boolean DE(int paramInt)
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
    public abstract void faO();
  }
  
  public static abstract class f
  {
    public void dismiss() {}
    
    public void fL(View paramView) {}
    
    public void fM(View paramView) {}
    
    public void faI() {}
    
    public void faJ() {}
    
    public void faK() {}
  }
  
  final class g
  {
    String HOr;
    int Mc;
    int asw;
    
    g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a
 * JD-Core Version:    0.7.0.1
 */