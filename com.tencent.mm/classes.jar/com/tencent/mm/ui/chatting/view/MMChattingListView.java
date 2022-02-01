package com.tencent.mm.ui.chatting.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.chatting.h.d.a;

public class MMChattingListView
  extends MMPullDownView
  implements MMPullDownView.c, MMPullDownView.d, MMPullDownView.e, MMPullDownView.g
{
  private com.tencent.mm.ui.chatting.n.a.a Kat;
  private Bundle KsX;
  private BaseAdapter KtY;
  private Rect KtZ;
  private Paint Kua;
  private boolean Kub;
  private boolean Kuc;
  private boolean Kud;
  private int Kue;
  private ListView mListView;
  
  public MMChattingListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(36708);
    this.KtZ = new Rect();
    this.Kud = false;
    init(paramContext);
    AppMethodBeat.o(36708);
  }
  
  public MMChattingListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(36709);
    this.KtZ = new Rect();
    this.Kud = false;
    init(paramContext);
    AppMethodBeat.o(36709);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(36710);
    this.Kua = new Paint();
    this.Kua.setColor(-16777216);
    this.mListView = new ListView(paramContext)
    {
      public final void onDrawForeground(Canvas paramAnonymousCanvas)
      {
        AppMethodBeat.i(36704);
        super.onDrawForeground(paramAnonymousCanvas);
        Rect localRect2;
        if (!MMChattingListView.a(MMChattingListView.this).isEmpty())
        {
          Rect localRect1 = new Rect();
          MMChattingListView.b(MMChattingListView.this).getLocalVisibleRect(localRect1);
          localRect2 = new Rect(localRect1);
          Rect localRect3 = new Rect(localRect1);
          if (!MMChattingListView.c(MMChattingListView.this))
          {
            localRect2.bottom = MMChattingListView.a(MMChattingListView.this).top;
            localRect3.top = MMChattingListView.a(MMChattingListView.this).bottom;
            paramAnonymousCanvas.drawRect(localRect2, MMChattingListView.d(MMChattingListView.this));
            paramAnonymousCanvas.drawRect(localRect3, MMChattingListView.d(MMChattingListView.this));
            ae.d("MicroMsg.MMChattingListView", "[onDrawForeground] drawingRect:%s mHighLightItemRect:%s", new Object[] { localRect1, MMChattingListView.a(MMChattingListView.this) });
          }
        }
        else
        {
          AppMethodBeat.o(36704);
          return;
        }
        if (MMChattingListView.e(MMChattingListView.this)) {}
        for (localRect2.top = (MMChattingListView.a(MMChattingListView.this).top + com.tencent.mm.cb.a.fromDPToPix(paramContext, 35));; localRect2.top = MMChattingListView.a(MMChattingListView.this).top)
        {
          localRect2.bottom = (MMChattingListView.a(MMChattingListView.this).bottom + com.tencent.mm.cb.a.fromDPToPix(paramContext, 1));
          paramAnonymousCanvas.drawRect(localRect2, MMChattingListView.d(MMChattingListView.this));
          break;
        }
      }
    };
    this.mListView.setBackgroundDrawable(null);
    this.mListView.setSelector(2131233255);
    this.mListView.setCacheColorHint(0);
    this.mListView.setDivider(null);
    this.mListView.setPadding(0, 0, 0, com.tencent.mm.cb.a.fromDPToPix(paramContext, 6));
    this.mListView.setClipToPadding(false);
    this.mListView.setScrollBarStyle(33554432);
    this.mListView.setId(2131298139);
    setOverScrollMode(2);
    addView(this.mListView, new FrameLayout.LayoutParams(-1, -1));
    setCanOverScrool(false);
    xI(false);
    xJ(false);
    setTopViewVisible(true);
    setOnBottomLoadDataListener(this);
    setOnTopLoadDataListener(this);
    setAtBottomCallBack(this);
    setAtTopCallBack(this);
    setIsBottomShowAll(true);
    setIsTopShowAll(false);
    setBottomViewVisible(true);
    this.Kuc = false;
    AppMethodBeat.o(36710);
  }
  
  public final void b(boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(36714);
    StringBuilder localStringBuilder = new StringBuilder("[lockTopLoadDataForPosition] start:").append(paramBoolean).append(" sourceArgs:");
    if (paramBundle == null) {}
    for (Object localObject = "null";; localObject = paramBundle)
    {
      ae.i("MicroMsg.MMChattingListView", localObject);
      this.Kud = paramBoolean;
      this.KsX = paramBundle;
      super.xI(paramBoolean);
      AppMethodBeat.o(36714);
      return;
    }
  }
  
  public final void bf(Bundle paramBundle)
  {
    AppMethodBeat.i(36716);
    StringBuilder localStringBuilder = new StringBuilder("[forceTopLoadData] sourceArgs:");
    if (paramBundle == null) {}
    for (String str = "";; str = paramBundle.toString())
    {
      ae.i("MicroMsg.MMChattingListView", str);
      this.KsX = paramBundle;
      super.xJ(true);
      AppMethodBeat.o(36716);
      return;
    }
  }
  
  public final boolean ccp()
  {
    AppMethodBeat.i(36718);
    this.Kue = getCurCount();
    ae.i("MicroMsg.MMChattingListView", "[onBottomLoadData] mPreCount:" + this.Kue);
    if (this.Kat != null)
    {
      this.Kat.a(d.a.Krw, false, this.KsX);
      this.KsX = null;
      this.Kud = false;
    }
    AppMethodBeat.o(36718);
    return false;
  }
  
  public final boolean ccq()
  {
    AppMethodBeat.i(36717);
    View localView = getListView().getChildAt(getListView().getFirstVisiblePosition());
    if ((localView != null) && (localView.getTop() == 0))
    {
      AppMethodBeat.o(36717);
      return true;
    }
    AppMethodBeat.o(36717);
    return false;
  }
  
  public final boolean ccr()
  {
    AppMethodBeat.i(36712);
    View localView = getListView().getChildAt(getListView().getChildCount() - 1);
    if (localView == null)
    {
      AppMethodBeat.o(36712);
      return true;
    }
    if ((localView.getBottom() <= getListView().getHeight() - getListView().getPaddingBottom()) && (getListView().getLastVisiblePosition() == getListView().getAdapter().getCount() - 1))
    {
      AppMethodBeat.o(36712);
      return true;
    }
    AppMethodBeat.o(36712);
    return false;
  }
  
  public final boolean ccs()
  {
    AppMethodBeat.i(36719);
    this.Kue = getCurCount();
    ae.i("MicroMsg.MMChattingListView", "[onTopLoadData] mPreCount:" + this.Kue + " isForceTopLoadDataForPosition:" + this.Kud);
    com.tencent.mm.ui.chatting.n.a.a locala1;
    if (this.Kat != null)
    {
      if ((this.Kud) && (this.KsX != null)) {
        this.KsX.putInt("SCENE", 2);
      }
      locala1 = this.Kat;
      if (!this.Kud) {
        break label128;
      }
    }
    label128:
    for (d.a locala = d.a.Krz;; locala = d.a.Krv)
    {
      locala1.a(locala, false, this.KsX);
      this.KsX = null;
      this.Kud = false;
      AppMethodBeat.o(36719);
      return false;
    }
  }
  
  public BaseAdapter getBaseAdapter()
  {
    return this.KtY;
  }
  
  public int getBottomSpace()
  {
    AppMethodBeat.i(36713);
    int i = this.mListView.getHeight() - this.mListView.getPaddingBottom();
    if (this.mListView.getChildCount() <= 0) {}
    for (;;)
    {
      AppMethodBeat.o(36713);
      return i;
      View localView = getListView().getChildAt(getListView().getChildCount() - 1);
      if ((localView != null) && (this.mListView.getLastVisiblePosition() == this.mListView.getAdapter().getCount() - 1)) {
        i -= localView.getBottom();
      } else {
        i = 0;
      }
    }
  }
  
  public int getCurCount()
  {
    AppMethodBeat.i(36720);
    if (this.KtY == null)
    {
      AppMethodBeat.o(36720);
      return 0;
    }
    int i = this.KtY.getCount();
    AppMethodBeat.o(36720);
    return i;
  }
  
  public ListView getListView()
  {
    return this.mListView;
  }
  
  public int getPreCount()
  {
    return this.Kue;
  }
  
  public void setAdapter(BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(36711);
    this.KtY = paramBaseAdapter;
    getListView().setAdapter(this.KtY);
    AppMethodBeat.o(36711);
  }
  
  public void setHighLightChild(int paramInt)
  {
    AppMethodBeat.i(36721);
    paramInt = Math.max(0, paramInt);
    if (this.mListView == null)
    {
      ae.e("MicroMsg.MMChattingListView", "null == listView index:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(36721);
      return;
    }
    Object localObject2 = this.mListView.getChildAt(paramInt);
    if (localObject2 == null)
    {
      ae.e("MicroMsg.MMChattingListView", "null == view index:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(36721);
      return;
    }
    Object localObject1 = localObject2;
    if (((View)localObject2).getBottom() - ((View)localObject2).getTop() <= 0)
    {
      localObject1 = this.mListView;
      localObject1 = ((ListView)localObject1).getChildAt(((ListView)localObject1).getHeaderViewsCount() + paramInt);
    }
    if (localObject1 == null)
    {
      ae.e("MicroMsg.MMChattingListView", "null == view index:%s", new Object[] { Integer.valueOf(paramInt + this.mListView.getHeaderViewsCount()) });
      AppMethodBeat.o(36721);
      return;
    }
    ae.i("MicroMsg.MMChattingListView", "[setHighLightChild] index:%s view rect:%s headerCount:%s", new Object[] { Integer.valueOf(paramInt), new Rect(((View)localObject1).getLeft(), ((View)localObject1).getTop(), ((View)localObject1).getRight(), ((View)localObject1).getBottom()), Integer.valueOf(this.mListView.getHeaderViewsCount()) });
    localObject2 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 0.85F, 0.85F, 0.85F, 0.85F, 0.85F, 0.0F }) });
    ((ValueAnimator)localObject2).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(36706);
        this.Kug.getGlobalVisibleRect(MMChattingListView.a(MMChattingListView.this));
        MMChattingListView.a(MMChattingListView.this).top = this.Kug.getTop();
        MMChattingListView.a(MMChattingListView.this).bottom = this.Kug.getBottom();
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue("alpha")).floatValue();
        MMChattingListView.d(MMChattingListView.this).setAlpha((int)(f * 255.0F));
        MMChattingListView.b(MMChattingListView.this).postInvalidate();
        AppMethodBeat.o(36706);
      }
    });
    ((ValueAnimator)localObject2).addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(36707);
        super.onAnimationEnd(paramAnonymousAnimator);
        MMChattingListView.a(MMChattingListView.this).setEmpty();
        AppMethodBeat.o(36707);
      }
    });
    ((ValueAnimator)localObject2).setDuration(1600L);
    ((ValueAnimator)localObject2).start();
    AppMethodBeat.o(36721);
  }
  
  public void setHighLightChildNew(int paramInt)
  {
    AppMethodBeat.i(187663);
    this.Kuc = true;
    if (al.isDarkMode()) {
      this.Kua.setColor(getResources().getColor(2131099828));
    }
    for (;;)
    {
      ae.i("MicroMsg.MMChattingListView", "[newStyle] setfalse" + this.Kuc);
      paramInt = Math.max(1, paramInt);
      if (this.mListView != null) {
        break;
      }
      ae.e("MicroMsg.MMChattingListView", "null == listView index:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(187663);
      return;
      this.Kua.setColor(getResources().getColor(2131100017));
    }
    Object localObject1 = this.mListView.getChildAt(paramInt);
    if (localObject1 == null)
    {
      ae.e("MicroMsg.MMChattingListView", "null == view index:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(187663);
      return;
    }
    if (((View)localObject1).getBottom() - ((View)localObject1).getTop() <= 0)
    {
      localObject1 = this.mListView;
      localObject1 = ((ListView)localObject1).getChildAt(((ListView)localObject1).getHeaderViewsCount() + paramInt);
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        ae.e("MicroMsg.MMChattingListView", "null == view index:%s", new Object[] { Integer.valueOf(paramInt + this.mListView.getHeaderViewsCount()) });
        AppMethodBeat.o(187663);
        return;
      }
      ae.i("MicroMsg.MMChattingListView", "[setHighLightChild] index:%s view rect:%s headerCount:%s", new Object[] { Integer.valueOf(paramInt), new Rect(((View)localObject1).getLeft(), ((View)localObject1).getTop(), ((View)localObject1).getRight(), ((View)localObject1).getBottom()), Integer.valueOf(this.mListView.getHeaderViewsCount()) });
      Object localObject2;
      if (al.isDarkMode())
      {
        localObject2 = PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 0.08F, 0.08F, 0.08F, 0.08F, 0.08F, 0.0F });
        localObject2 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { localObject2 });
        TextView localTextView = (TextView)((View)localObject1).findViewById(2131298178);
        if ((localTextView == null) || (localTextView.getVisibility() != 0)) {
          break label476;
        }
      }
      label476:
      for (this.Kub = true;; this.Kub = false)
      {
        ((ValueAnimator)localObject2).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(187661);
            this.Kug.getGlobalVisibleRect(MMChattingListView.a(MMChattingListView.this));
            MMChattingListView.a(MMChattingListView.this).top = this.Kug.getTop();
            MMChattingListView.a(MMChattingListView.this).bottom = this.Kug.getBottom();
            float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue("alpha")).floatValue();
            MMChattingListView.d(MMChattingListView.this).setAlpha((int)(f * 255.0F));
            MMChattingListView.b(MMChattingListView.this).postInvalidate();
            AppMethodBeat.o(187661);
          }
        });
        ((ValueAnimator)localObject2).addListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(187662);
            super.onAnimationEnd(paramAnonymousAnimator);
            MMChattingListView.a(MMChattingListView.this).setEmpty();
            MMChattingListView.f(MMChattingListView.this);
            AppMethodBeat.o(187662);
          }
        });
        ((ValueAnimator)localObject2).setDuration(1150L);
        ((ValueAnimator)localObject2).start();
        AppMethodBeat.o(187663);
        return;
        localObject2 = PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.0F });
        break;
      }
    }
  }
  
  public void setLoadExecutor(com.tencent.mm.ui.chatting.n.a.a parama)
  {
    this.Kat = parama;
  }
  
  public final void xI(boolean paramBoolean)
  {
    AppMethodBeat.i(36715);
    ae.i("MicroMsg.MMChattingListView", "[forceTopLoadData] start:" + paramBoolean + " isForceTopLoadDataForPosition:" + this.Kud);
    if (this.Kud)
    {
      AppMethodBeat.o(36715);
      return;
    }
    super.xI(paramBoolean);
    AppMethodBeat.o(36715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.MMChattingListView
 * JD-Core Version:    0.7.0.1
 */