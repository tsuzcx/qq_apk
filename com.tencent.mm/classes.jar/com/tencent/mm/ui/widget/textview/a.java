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
  View.OnTouchListener AKw;
  int[] HOb;
  b JnZ;
  public e JoA;
  ArrayList<c> JoB;
  private b Joa;
  g Job;
  public d Joc;
  View Jod;
  public f Joe;
  View.OnTouchListener Jof;
  private Spannable Jog;
  private com.tencent.mm.ui.widget.b.a Joh;
  int Joi;
  int Joj;
  private int Jok;
  int Jol;
  int Jom;
  private c Jon;
  int Joo;
  public int Jop;
  private ViewTreeObserver.OnScrollChangedListener Joq;
  boolean Jor;
  boolean Jos;
  public boolean Jot;
  public boolean Jou;
  boolean Jov;
  boolean Jow;
  boolean Jox;
  final Runnable Joy;
  final Runnable Joz;
  private boolean aKE;
  private View.OnAttachStateChangeListener ads;
  private ViewTreeObserver.OnGlobalLayoutListener ahC;
  View.OnClickListener gst;
  Context mContext;
  int[] tAc;
  private ViewTreeObserver.OnPreDrawListener zn;
  
  public a(a parama)
  {
    AppMethodBeat.i(159878);
    this.Job = new g();
    this.Jor = false;
    this.aKE = true;
    this.Jos = false;
    this.Jot = true;
    this.Jou = true;
    this.Jov = true;
    this.Jow = false;
    this.Jox = false;
    this.tAc = new int[2];
    this.Joy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159850);
        if (a.this.Jor)
        {
          an.d("SelectableTextHelper", "isReInit, return.", new Object[0]);
          AppMethodBeat.o(159850);
          return;
        }
        an.d("SelectableTextHelper", "in mShowSelectViewRunnable. opener: %s, inScrolling: %s.", new Object[] { Boolean.valueOf(a.this.Jov), Boolean.valueOf(a.this.Jow) });
        if (a.this.Joe != null)
        {
          if (!a.this.Jov)
          {
            a.this.Jov = true;
            if (a.this.Jow)
            {
              an.d("SelectableTextHelper", "menu is hide: %s, cursor is hide: %s.", new Object[] { Boolean.valueOf(a.this.Jot), Boolean.valueOf(a.this.Jou) });
              if (!a.this.Jot) {
                a.this.fwM();
              }
              if (!a.this.Jou)
              {
                a.this.fwH();
                a.this.kc(a.this.Job.atr, a.this.Job.MZ);
              }
              if ((a.this.Joe != null) && (a.this.Jot) && (!a.this.Jou)) {
                a.this.Joe.fY(a.this.Jod);
              }
            }
            a.this.Jow = false;
            AppMethodBeat.o(159850);
            return;
          }
          if (a.this.Jox)
          {
            a.this.Jox = false;
            an.d("SelectableTextHelper", "judge result(delay), click outside.", new Object[0]);
            if (a.this.JoA != null)
            {
              a.this.JoA.fqE();
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
          if (!a.this.Jot) {
            a.this.fwM();
          }
          if (!a.this.Jou) {
            a.this.fwH();
          }
        }
        AppMethodBeat.o(159850);
      }
    };
    this.Joz = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159854);
        an.d("SelectableTextHelper", "dismiss all runnable.", new Object[0]);
        if (a.this.JoA != null) {
          a.this.JoA.fqE();
        }
        AppMethodBeat.o(159854);
      }
    };
    this.HOb = new int[2];
    this.Jod = parama.Jod;
    this.Joe = parama.Joe;
    this.gst = parama.gst;
    this.Jof = parama.Jof;
    this.Joh = parama.JoD;
    this.mContext = this.Jod.getContext();
    this.Jok = parama.Jok;
    this.Jol = parama.Jol;
    View localView = this.Jod;
    int i;
    float f;
    if ((localView instanceof NeatTextView))
    {
      i = ((NeatTextView)localView).getLineHeight();
      this.Joo = i;
      if (this.Jom != 0) {
        break label345;
      }
      parama = this.Jod;
      if (!(parama instanceof NeatTextView)) {
        break label322;
      }
      f = ((NeatTextView)parama).getTextSize();
    }
    label221:
    for (this.Jom = ((int)f);; this.Jom = ao.fromDPToPix(this.mContext, parama.JoE))
    {
      this.ads = new View.OnAttachStateChangeListener()
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
      this.zn = new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(159857);
          if (a.this.Jos)
          {
            a.this.Jos = false;
            a locala = a.this;
            locala.Jod.removeCallbacks(locala.Joy);
            locala.Jod.postDelayed(locala.Joy, 100L);
          }
          AppMethodBeat.o(159857);
          return true;
        }
      };
      this.Joq = new ViewTreeObserver.OnScrollChangedListener()
      {
        public final void onScrollChanged()
        {
          AppMethodBeat.i(159858);
          if (a.this.Joe != null)
          {
            a.this.Jod.removeCallbacks(a.this.Joz);
            a.this.Jod.getLocationInWindow(a.this.HOb);
            an.d("SelectableTextHelper", "onScrollChanged, old-y: %d, y: %d.", new Object[] { Integer.valueOf(a.this.tAc[1]), Integer.valueOf(a.this.HOb[1]) });
            if (a.this.Jov)
            {
              if ((a.this.Jow) || (a.this.Jox)) {
                break label260;
              }
              if (a.this.tAc[1] == a.this.HOb[1]) {
                break label238;
              }
              a.this.Jow = true;
              a.this.Jov = false;
              an.d("SelectableTextHelper", "judge result, inScrolling.", new Object[0]);
            }
          }
          for (;;)
          {
            a.this.tAc[1] = a.this.HOb[1];
            if ((!a.this.Jos) && ((!a.this.Jot) || (!a.this.Jou)))
            {
              a.this.Jos = true;
              a.this.fwE();
            }
            AppMethodBeat.o(159858);
            return;
            label238:
            a.this.Jox = true;
            an.d("SelectableTextHelper", "need delay judge.", new Object[0]);
            continue;
            label260:
            if (a.this.Jox)
            {
              a.this.Jox = false;
              a.this.Jov = false;
              if (a.this.tAc[1] != a.this.HOb[1])
              {
                a.this.Jow = true;
                an.d("SelectableTextHelper", "judge result(delay), inScrolling.", new Object[0]);
              }
              else
              {
                a.this.Jow = false;
                an.d("SelectableTextHelper", "judge result, click outside.", new Object[0]);
              }
            }
          }
        }
      };
      this.ahC = new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(159859);
          an.d("SelectableTextHelper", "onGlobalLayout", new Object[0]);
          AppMethodBeat.o(159859);
        }
      };
      this.AKw = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(159860);
          an.d("SelectableTextHelper", "event pointer count: %d.", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getPointerCount()) });
          if (a.this.Jof != null) {
            a.this.Jof.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          }
          a.this.Joi = ((int)paramAnonymousMotionEvent.getX());
          a.this.Joj = ((int)paramAnonymousMotionEvent.getY());
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
    for (int i = this.Job.atr; (i < 0) || (i > b.gQ(this.Jod).length()); i = this.Job.MZ)
    {
      AppMethodBeat.o(159884);
      return;
    }
    Object localObject = b.gR(this.Jod);
    int j;
    if (localObject != null)
    {
      j = (int)((TextPaint)localObject).getFontMetrics().descent + b.aJ(this.Jod, b.aK(this.Jod, i));
      i = (int)b.aL(this.Jod, i);
    }
    for (;;)
    {
      paramb.JoC.Jod.getLocationInWindow(paramb.JoK);
      if (paramb.JoF) {}
      for (int k = paramb.mWidth;; k = 0)
      {
        int n = i;
        int m = j;
        if (!paramb.JoF)
        {
          localObject = paramb.kd(i, j);
          n = localObject[0];
          m = localObject[1];
        }
        try
        {
          paramb.mPopupWindow.showAtLocation(paramb.JoC.Jod, 0, n - k + paramb.fwQ(), m + paramb.fwR());
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
  
  private int be(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(159893);
    if (this.JoB != null)
    {
      Iterator localIterator = this.JoB.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.FA(paramInt))
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
  
  private boolean fwG()
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
    this.Jor = false;
    this.aKE = true;
    this.Jos = false;
    this.Jod.removeCallbacks(this.Joy);
    this.Jod.getViewTreeObserver().removeOnScrollChangedListener(this.Joq);
    this.Jod.getViewTreeObserver().removeOnPreDrawListener(this.zn);
    this.Jod.getViewTreeObserver().removeOnGlobalLayoutListener(this.ahC);
    this.Jod.removeOnAttachStateChangeListener(this.ads);
    this.Jot = true;
    this.Jou = true;
    fwE();
    fwF();
    this.JnZ = null;
    this.Joa = null;
    if (this.Joe != null) {
      this.Joe.dismiss();
    }
    AppMethodBeat.o(159880);
  }
  
  public final void fwE()
  {
    AppMethodBeat.i(159881);
    fwI();
    fwJ();
    if (this.Joe != null) {
      this.Joe.dismiss();
    }
    AppMethodBeat.o(159881);
  }
  
  public final void fwF()
  {
    AppMethodBeat.i(159882);
    this.Job.JoM = null;
    if ((this.Jog != null) && (this.Jon != null))
    {
      this.Jog.removeSpan(this.Jon);
      this.Jon = null;
    }
    AppMethodBeat.o(159882);
  }
  
  public final void fwH()
  {
    AppMethodBeat.i(159886);
    if (!fwG())
    {
      a(this.JnZ);
      a(this.Joa);
    }
    AppMethodBeat.o(159886);
  }
  
  public final void fwI()
  {
    AppMethodBeat.i(159887);
    if (this.JnZ != null) {
      this.JnZ.mPopupWindow.dismiss();
    }
    if (this.Joa != null) {
      this.Joa.mPopupWindow.dismiss();
    }
    AppMethodBeat.o(159887);
  }
  
  public final void fwJ()
  {
    AppMethodBeat.i(159888);
    if (this.Joh != null) {
      this.Joh.fkR();
    }
    AppMethodBeat.o(159888);
  }
  
  public final void fwK()
  {
    AppMethodBeat.i(159889);
    if (this.Joe != null) {
      this.Joe.fY(this.Jod);
    }
    AppMethodBeat.o(159889);
  }
  
  public final void fwL()
  {
    AppMethodBeat.i(159890);
    if (this.Joe != null) {
      this.Joe.dismiss();
    }
    AppMethodBeat.o(159890);
  }
  
  public final void fwM()
  {
    int j = 16;
    AppMethodBeat.i(159891);
    int i;
    int m;
    if (this.Joh != null)
    {
      int[] arrayOfInt = new int[2];
      this.Jod.getLocationInWindow(arrayOfInt);
      int k = (int)b.aL(this.Jod, this.Job.atr) + arrayOfInt[0];
      i = b.aM(this.Jod, b.aK(this.Jod, this.Job.atr));
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
        this.Joh.ej(i, j);
        if (this.Joe != null) {
          this.Joe.fqA();
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
    if (!this.aKE)
    {
      an.d("SelectableTextHelper", "not destroy, isReInit: %s.", new Object[] { Boolean.valueOf(this.Jor) });
      this.Jor = true;
      AppMethodBeat.o(159879);
      return;
    }
    an.d("SelectableTextHelper", "not init yet, need to init.", new Object[0]);
    this.Jor = false;
    this.aKE = false;
    this.Jos = false;
    if (this.Joe == null) {
      b.a(this.Jod, b.gQ(this.Jod), TextView.BufferType.SPANNABLE);
    }
    this.JnZ = new b(true);
    if (this.Joe != null)
    {
      this.JnZ.fwS();
      this.JnZ.setTouchInterceptor(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(159861);
          an.d("SelectableTextHelper", "interceptor onTouch.", new Object[0]);
          int i = (int)paramAnonymousMotionEvent.getX();
          int j = (int)paramAnonymousMotionEvent.getY();
          if ((paramAnonymousMotionEvent.getAction() == 0) && ((i < 0) || (i >= a.this.JnZ.getWidth()) || (j < 0) || (j >= a.this.JnZ.getHeight())))
          {
            an.d("SelectableTextHelper", "interceptor onTouch, down, outside.", new Object[0]);
            a.this.Jod.postDelayed(a.this.Joz, 100L);
            AppMethodBeat.o(159861);
            return true;
          }
          if (paramAnonymousMotionEvent.getAction() == 4)
          {
            an.d("SelectableTextHelper", "interceptor onTouch, outside.", new Object[0]);
            a.this.Jod.postDelayed(a.this.Joz, 100L);
            AppMethodBeat.o(159861);
            return true;
          }
          AppMethodBeat.o(159861);
          return false;
        }
      });
      this.JnZ.setOnDismissListener(new PopupWindow.OnDismissListener()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(159862);
          a.this.Jod.setOnTouchListener(a.this.AKw);
          AppMethodBeat.o(159862);
        }
      });
    }
    this.Joa = new b(false);
    this.Jod.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159851);
        an.d("SelectableTextHelper", "onLongClick.", new Object[0]);
        a.this.Jor = false;
        int j;
        if (a.this.Joe != null)
        {
          a.this.Jov = true;
          a.this.Jow = false;
          a.this.Jox = false;
          Object localObject2 = b.gQ(a.this.Jod);
          if ((localObject2 instanceof SpannableString))
          {
            localObject1 = a.this;
            localObject2 = (SpannableString)localObject2;
            ((a)localObject1).JoB = new ArrayList();
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
                ((a)localObject1).JoB.add(localObject3);
              }
              for (;;)
              {
                an.d("SelectableTextHelper", "spans from %d to %d.", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
                i = j;
                break;
                an.e("SelectableTextHelper", "other situation occur! length: %d.", new Object[] { Integer.valueOf(localObject3.length) });
              }
            }
            an.d("SelectableTextHelper", ((a)localObject1).JoB.toString(), new Object[0]);
          }
          a.this.fwE();
          if ((a.this.Jop > 0) && (a.this.Jop < b.gQ(a.this.Jod).length()))
          {
            a.a(a.this, a.this.Jop);
            a.this.Jot = false;
            a.this.Jou = false;
            a.this.fwM();
            a.this.fwH();
          }
          for (;;)
          {
            AppMethodBeat.o(159851);
            return true;
            a.a(a.this, b.gQ(a.this.Jod).length());
            a.this.Jot = true;
            a.this.Jou = false;
            a.this.fwH();
            a.this.Joe.fZ(paramAnonymousView);
          }
        }
        a.this.Jov = false;
        paramAnonymousView = a.this;
        int k = a.this.Joi;
        int i = a.this.Joj;
        Object localObject1 = paramAnonymousView.Jod;
        if ((localObject1 instanceof NeatTextView))
        {
          localObject1 = ((NeatTextView)localObject1).getLayout();
          if (localObject1 == null) {
            break label590;
          }
          i = ((com.tencent.neattextview.textview.layout.a)localObject1).ks(k, i);
        }
        for (;;)
        {
          paramAnonymousView.kb(i, i + 1);
          a.this.fwE();
          a.this.Jot = false;
          a.this.Jou = false;
          a.this.fwM();
          a.this.fwH();
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
    this.Jod.setOnTouchListener(this.AKw);
    this.Jod.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159852);
        an.d("SelectableTextHelper", "onClick", new Object[0]);
        if (a.this.gst != null) {
          a.this.gst.onClick(paramAnonymousView);
        }
        a.this.Jot = true;
        a.this.Jou = true;
        a.this.fwE();
        a.this.fwF();
        if (a.this.Joe != null) {
          a.this.Joe.dismiss();
        }
        AppMethodBeat.o(159852);
      }
    });
    this.Jod.addOnAttachStateChangeListener(this.ads);
    this.Jod.getViewTreeObserver().addOnPreDrawListener(this.zn);
    this.Jod.getViewTreeObserver().addOnScrollChangedListener(this.Joq);
    this.Jod.getViewTreeObserver().addOnGlobalLayoutListener(this.ahC);
    this.Jod.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(159853);
        a.this.Jod.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        if (a.this.Joe != null)
        {
          a.this.Jod.getLocationInWindow(a.this.tAc);
          an.d("SelectableTextHelper", "init: loc-x: %d, loc-y: %d.", new Object[] { Integer.valueOf(a.this.tAc[0]), Integer.valueOf(a.this.tAc[1]) });
        }
        AppMethodBeat.o(159853);
      }
    });
    AppMethodBeat.o(159879);
  }
  
  final void kb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159883);
    fwF();
    if ((b.gQ(this.Jod) instanceof Spannable)) {
      this.Jog = ((Spannable)b.gQ(this.Jod));
    }
    if ((this.Jog == null) || (paramInt1 >= b.gQ(this.Jod).length()))
    {
      this.Job.atr = 0;
      this.Job.MZ = 0;
      AppMethodBeat.o(159883);
      return;
    }
    kc(paramInt1, paramInt2);
    AppMethodBeat.o(159883);
  }
  
  public final void kc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159892);
    if (paramInt1 != -1) {
      this.Job.atr = be(paramInt1, true);
    }
    if (paramInt2 != -1) {
      this.Job.MZ = be(paramInt2, false);
    }
    if ((this.Job.atr < 0) || (this.Job.atr > b.gQ(this.Jod).length()))
    {
      AppMethodBeat.o(159892);
      return;
    }
    if ((this.Job.MZ < 0) || (this.Job.MZ > b.gQ(this.Jod).length()))
    {
      AppMethodBeat.o(159892);
      return;
    }
    if (this.Job.atr > this.Job.MZ)
    {
      paramInt1 = this.Job.atr;
      this.Job.atr = this.Job.MZ;
      this.Job.MZ = paramInt1;
    }
    if (this.Jog != null)
    {
      this.Job.JoM = this.Jog.subSequence(this.Job.atr, this.Job.MZ).toString();
      if (this.Jon == null) {
        break label314;
      }
      this.Jon.setPosition(this.Job.atr, this.Job.MZ);
    }
    for (;;)
    {
      paramInt1 = b.aK(this.Jod, this.Job.atr);
      paramInt1 = b.aP(this.Jod, paramInt1);
      this.Jog.setSpan(this.Jon, paramInt1, this.Job.MZ, 17);
      if (this.Joc != null) {
        this.Joc.an(this.Job.JoM);
      }
      AppMethodBeat.o(159892);
      return;
      label314:
      this.Jon = new c(this.Jod, this.mContext.getResources().getColor(this.Jok), this.Job.atr, this.Job.MZ);
    }
  }
  
  public static final class a
  {
    com.tencent.mm.ui.widget.b.a JoD;
    public int JoE = 0;
    View Jod;
    a.f Joe;
    View.OnTouchListener Jof;
    public int Jok = 2131100846;
    public int Jol = 2131100195;
    View.OnClickListener gst;
    
    public a(View paramView, com.tencent.mm.ui.widget.b.a parama)
    {
      this.Jod = paramView;
      this.JoD = parama;
    }
    
    public a(View paramView, com.tencent.mm.ui.widget.b.a parama, a.f paramf, View.OnClickListener paramOnClickListener, View.OnTouchListener paramOnTouchListener)
    {
      this(paramView, parama);
      this.Joe = paramf;
      this.gst = paramOnClickListener;
      this.Jof = paramOnTouchListener;
    }
    
    public final a fwN()
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
    private int[] HOb;
    boolean JoF;
    private int JoG;
    private int JoH;
    private int JoI;
    private int JoJ;
    int[] JoK;
    private boolean JoL;
    private Point lOz;
    private int mHeight;
    private int mPadding;
    private Paint mPaint;
    PopupWindow mPopupWindow;
    int mWidth;
    private int oSs;
    private Rect rect;
    
    b(boolean paramBoolean)
    {
      super();
      AppMethodBeat.i(159864);
      this.oSs = (a.this.Jom / 2);
      this.mWidth = (this.oSs * 2);
      this.mHeight = (this.oSs * 2);
      this.mPadding = 25;
      this.JoK = new int[2];
      this.rect = new Rect();
      this.lOz = new Point();
      this.JoL = false;
      this.HOb = new int[2];
      this.JoF = paramBoolean;
      this.mPaint = new Paint(1);
      this.mPaint.setColor(a.this.mContext.getResources().getColor(a.this.Jol));
      this.mPopupWindow = new PopupWindow(this);
      this.mPopupWindow.setClippingEnabled(false);
      this.mPopupWindow.setWidth(this.mWidth + this.mPadding * 2);
      this.mPopupWindow.setHeight(this.mHeight + this.mPadding / 2);
      AppMethodBeat.o(159864);
    }
    
    private void fwO()
    {
      AppMethodBeat.i(159867);
      if (!this.JoF) {}
      for (boolean bool = true;; bool = false)
      {
        this.JoF = bool;
        invalidate();
        AppMethodBeat.o(159867);
        return;
      }
    }
    
    private void fwP()
    {
      AppMethodBeat.i(159869);
      a.this.Jod.getLocationInWindow(this.JoK);
      Object localObject = b.gR(a.this.Jod);
      if (localObject != null)
      {
        int i = (int)((TextPaint)localObject).getFontMetrics().descent;
        if (this.JoF)
        {
          this.mPopupWindow.update((int)b.aL(a.this.Jod, a.this.Job.atr) - this.mWidth + fwQ(), i + b.aJ(a.this.Jod, b.aK(a.this.Jod, a.this.Job.atr)) + fwR(), -1, -1);
          AppMethodBeat.o(159869);
          return;
        }
        localObject = kd((int)b.aL(a.this.Jod, a.this.Job.MZ), i + b.aJ(a.this.Jod, b.aK(a.this.Jod, a.this.Job.MZ)));
        i = localObject[0];
        int j = localObject[1];
        this.mPopupWindow.update(i + fwQ(), j + fwR(), -1, -1);
      }
      AppMethodBeat.o(159869);
    }
    
    private void update(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159868);
      a.this.Jod.getLocationInWindow(this.JoK);
      int i;
      b localb;
      if (this.JoF)
      {
        i = a.this.Job.atr;
        int j = this.JoK[1];
        paramInt1 = b.f(a.this.Jod, paramInt1, paramInt2 - j, i);
        if (paramInt1 == i) {
          break label225;
        }
        a.this.fwF();
        if (!this.JoF) {
          break label169;
        }
        if (paramInt1 <= this.JoJ) {
          break label157;
        }
        localb = a.a(a.this, false);
        fwO();
        localb.fwO();
        this.JoI = this.JoJ;
        a.this.kc(this.JoJ, paramInt1);
        localb.fwP();
      }
      for (;;)
      {
        fwP();
        AppMethodBeat.o(159868);
        return;
        i = a.this.Job.MZ;
        break;
        label157:
        a.this.kc(paramInt1, -1);
      }
      label169:
      if (paramInt1 < this.JoI)
      {
        localb = a.a(a.this, true);
        localb.fwO();
        fwO();
        this.JoJ = this.JoI;
        a.this.kc(paramInt1, this.JoI);
        localb.fwP();
      }
      for (;;)
      {
        fwP();
        label225:
        AppMethodBeat.o(159868);
        return;
        a.this.kc(this.JoI, paramInt1);
      }
    }
    
    public final int fwQ()
    {
      AppMethodBeat.i(159870);
      int i = this.JoK[0];
      int j = this.mPadding;
      int k = a.this.Jod.getPaddingLeft();
      AppMethodBeat.o(159870);
      return i - j + k;
    }
    
    public final int fwR()
    {
      AppMethodBeat.i(159871);
      int i = this.JoK[1];
      int j = a.this.Jod.getPaddingTop();
      AppMethodBeat.o(159871);
      return i + j;
    }
    
    public final void fwS()
    {
      AppMethodBeat.i(159873);
      this.mPopupWindow.setOutsideTouchable(true);
      AppMethodBeat.o(159873);
    }
    
    final int[] kd(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159872);
      int j = paramInt1;
      int i = paramInt2;
      if (paramInt1 == 0)
      {
        j = paramInt1;
        i = paramInt2;
        if (a.this.Job.MZ > 1)
        {
          a.this.Jod.getLocationInWindow(this.JoK);
          TextPaint localTextPaint = b.gR(a.this.Jod);
          j = paramInt1;
          i = paramInt2;
          if (localTextPaint != null)
          {
            paramInt1 = (int)localTextPaint.getFontMetrics().descent;
            paramInt2 = b.aK(a.this.Jod, a.this.Job.MZ - 1);
            j = (int)b.aO(a.this.Jod, paramInt2);
            i = b.aJ(a.this.Jod, b.aK(a.this.Jod, a.this.Job.MZ - 1)) + paramInt1;
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
      if (a.this.Joe != null) {
        if (this.JoF)
        {
          i = a.this.Job.atr;
          TextPaint localTextPaint = b.gR(a.this.Jod);
          if (localTextPaint == null) {
            break label486;
          }
          j = b.aJ(a.this.Jod, b.aK(a.this.Jod, i));
          j = (int)localTextPaint.getFontMetrics().descent + j;
          k = (int)b.aL(a.this.Jod, i);
          i = j;
          j = k;
        }
      }
      for (;;)
      {
        a.this.Jod.getLocationInWindow(this.JoK);
        k = i;
        if (!this.JoF) {
          k = kd(j, i)[1];
        }
        i = fwR() + k;
        if (a.this.Jod.getGlobalVisibleRect(this.rect, this.lOz))
        {
          if (i >= this.rect.bottom)
          {
            if (this.JoF)
            {
              an.d("SelectableTextHelper", "start below bottom, dismiss all.", new Object[0]);
              a.this.fwF();
              a.this.Jot = true;
              a.this.Jou = true;
              a.this.fwE();
              a.this.Joe.dismiss();
            }
            an.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
            AppMethodBeat.o(159865);
            return;
            i = a.this.Job.MZ;
            break;
          }
          if (i > this.rect.top) {
            break label374;
          }
          if (!this.JoF)
          {
            an.d("SelectableTextHelper", "end above top, dismiss all.", new Object[0]);
            a.this.fwF();
            a.this.Jot = true;
            a.this.Jou = true;
            a.this.fwE();
            a.this.Joe.dismiss();
          }
          an.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
          AppMethodBeat.o(159865);
          return;
        }
        an.d("SelectableTextHelper", "view invisible.", new Object[0]);
        AppMethodBeat.o(159865);
        return;
        label374:
        paramCanvas.drawCircle(this.oSs + this.mPadding, this.oSs, this.oSs, this.mPaint);
        if (this.JoF)
        {
          paramCanvas.drawRect(this.oSs + this.mPadding, 0.0F, this.oSs * 2 + this.mPadding, this.oSs, this.mPaint);
          AppMethodBeat.o(159865);
          return;
        }
        paramCanvas.drawRect(this.mPadding, 0.0F, this.oSs + this.mPadding, this.oSs, this.mPaint);
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
        this.JoI = a.this.Job.atr;
        this.JoJ = a.this.Job.MZ;
        this.JoG = ((int)paramMotionEvent.getX());
        this.JoH = ((int)paramMotionEvent.getY());
        this.JoL = false;
        a.this.Jod.getLocationInWindow(this.HOb);
        continue;
        if ((a.this.Joe != null) && (!this.JoL))
        {
          this.JoL = true;
          a.this.Joe.fqy();
          if (a.this.Job.MZ - a.this.Job.atr == b.gQ(a.this.Jod).length())
          {
            a.this.Joe.fY(a.this.Jod);
            a.this.Jot = true;
            a.this.fwJ();
          }
          for (;;)
          {
            a.this.Joe.fqz();
            break;
            a.this.Joe.dismiss();
            a.this.Jot = false;
            a.this.fwM();
          }
        }
        if (!a.this.Jot)
        {
          a.this.fwM();
          continue;
          if (a.this.Joe != null)
          {
            a.this.Joe.fqy();
            a.this.Joe.dismiss();
          }
          a.this.fwJ();
          int i = (int)paramMotionEvent.getRawX();
          int j = (int)paramMotionEvent.getRawY();
          if (a.this.Joe == null) {
            update(i - this.HOb[0], j + this.JoH - this.mHeight - a.this.Joo);
          }
          for (;;)
          {
            if (a.this.Joe == null) {
              break label430;
            }
            a.this.Joe.fqz();
            break;
            update(i - this.HOb[0] + this.oSs, j + this.JoH - this.mHeight - a.this.Joo);
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
    
    final boolean FA(int paramInt)
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
    public abstract void an(CharSequence paramCharSequence);
  }
  
  public static abstract interface e
  {
    public abstract void fqE();
  }
  
  public static abstract class f
  {
    public void dismiss() {}
    
    public void fY(View paramView) {}
    
    public void fZ(View paramView) {}
    
    public void fqA() {}
    
    public void fqy() {}
    
    public void fqz() {}
  }
  
  final class g
  {
    String JoM;
    int MZ;
    int atr;
    
    g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a
 * JD-Core Version:    0.7.0.1
 */