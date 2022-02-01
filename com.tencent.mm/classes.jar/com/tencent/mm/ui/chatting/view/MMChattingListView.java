package com.tencent.mm.ui.chatting.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.chatting.g.d.a;

public class MMChattingListView
  extends MMPullDownView
  implements MMPullDownView.c, MMPullDownView.d, MMPullDownView.e, MMPullDownView.g
{
  private Bundle GGx;
  private BaseAdapter GHq;
  private Rect GHr;
  private Paint GHs;
  private boolean GHt;
  private int GHu;
  private com.tencent.mm.ui.chatting.m.a.a GrS;
  private ListView mListView;
  
  public MMChattingListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(36708);
    this.GHr = new Rect();
    this.GHt = false;
    init(paramContext);
    AppMethodBeat.o(36708);
  }
  
  public MMChattingListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(36709);
    this.GHr = new Rect();
    this.GHt = false;
    init(paramContext);
    AppMethodBeat.o(36709);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(36710);
    this.GHs = new Paint();
    this.GHs.setColor(-16777216);
    this.mListView = new ListView(paramContext)
    {
      public final void onDrawForeground(Canvas paramAnonymousCanvas)
      {
        AppMethodBeat.i(36704);
        super.onDrawForeground(paramAnonymousCanvas);
        if (!MMChattingListView.a(MMChattingListView.this).isEmpty())
        {
          Rect localRect1 = new Rect();
          MMChattingListView.b(MMChattingListView.this).getLocalVisibleRect(localRect1);
          Rect localRect2 = new Rect(localRect1);
          Rect localRect3 = new Rect(localRect1);
          localRect2.bottom = MMChattingListView.a(MMChattingListView.this).top;
          localRect3.top = MMChattingListView.a(MMChattingListView.this).bottom;
          paramAnonymousCanvas.drawRect(localRect2, MMChattingListView.c(MMChattingListView.this));
          paramAnonymousCanvas.drawRect(localRect3, MMChattingListView.c(MMChattingListView.this));
          ad.d("MicroMsg.MMChattingListView", "[onDrawForeground] drawingRect:%s mHighLightItemRect:%s", new Object[] { localRect1, MMChattingListView.a(MMChattingListView.this) });
        }
        AppMethodBeat.o(36704);
      }
    };
    this.mListView.setBackgroundDrawable(null);
    this.mListView.setSelector(2131233255);
    this.mListView.setCacheColorHint(0);
    this.mListView.setDivider(null);
    this.mListView.setPadding(0, 0, 0, com.tencent.mm.cd.a.fromDPToPix(paramContext, 6));
    this.mListView.setClipToPadding(false);
    this.mListView.setScrollBarStyle(33554432);
    this.mListView.setId(2131298139);
    setOverScrollMode(2);
    addView(this.mListView, new FrameLayout.LayoutParams(-1, -1));
    setCanOverScrool(false);
    vL(false);
    vM(false);
    setTopViewVisible(true);
    setOnBottomLoadDataListener(this);
    setOnTopLoadDataListener(this);
    setAtBottomCallBack(this);
    setAtTopCallBack(this);
    setIsBottomShowAll(true);
    setIsTopShowAll(false);
    setBottomViewVisible(true);
    AppMethodBeat.o(36710);
  }
  
  public final void a(boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(36714);
    StringBuilder localStringBuilder = new StringBuilder("[lockTopLoadDataForPosition] start:").append(paramBoolean).append(" sourceArgs:");
    if (paramBundle == null) {}
    for (Object localObject = "null";; localObject = paramBundle)
    {
      ad.i("MicroMsg.MMChattingListView", localObject);
      this.GHt = paramBoolean;
      this.GGx = paramBundle;
      super.vL(paramBoolean);
      AppMethodBeat.o(36714);
      return;
    }
  }
  
  public final void aV(Bundle paramBundle)
  {
    AppMethodBeat.i(36716);
    StringBuilder localStringBuilder = new StringBuilder("[forceTopLoadData] sourceArgs:");
    if (paramBundle == null) {}
    for (String str = "";; str = paramBundle.toString())
    {
      ad.i("MicroMsg.MMChattingListView", str);
      this.GGx = paramBundle;
      super.vM(true);
      AppMethodBeat.o(36716);
      return;
    }
  }
  
  public final boolean bPh()
  {
    AppMethodBeat.i(36718);
    this.GHu = getCurCount();
    ad.i("MicroMsg.MMChattingListView", "[onBottomLoadData] mPreCount:" + this.GHu);
    if (this.GrS != null)
    {
      this.GrS.a(d.a.GEV, false, this.GGx);
      this.GGx = null;
      this.GHt = false;
    }
    AppMethodBeat.o(36718);
    return false;
  }
  
  public final boolean bPi()
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
  
  public final boolean bPj()
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
  
  public final boolean bPk()
  {
    AppMethodBeat.i(36719);
    this.GHu = getCurCount();
    ad.i("MicroMsg.MMChattingListView", "[onTopLoadData] mPreCount:" + this.GHu + " isForceTopLoadDataForPosition:" + this.GHt);
    com.tencent.mm.ui.chatting.m.a.a locala1;
    if (this.GrS != null)
    {
      if ((this.GHt) && (this.GGx != null)) {
        this.GGx.putInt("SCENE", 2);
      }
      locala1 = this.GrS;
      if (!this.GHt) {
        break label128;
      }
    }
    label128:
    for (d.a locala = d.a.GEY;; locala = d.a.GEU)
    {
      locala1.a(locala, false, this.GGx);
      this.GGx = null;
      this.GHt = false;
      AppMethodBeat.o(36719);
      return false;
    }
  }
  
  public BaseAdapter getBaseAdapter()
  {
    return this.GHq;
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
    if (this.GHq == null)
    {
      AppMethodBeat.o(36720);
      return 0;
    }
    int i = this.GHq.getCount();
    AppMethodBeat.o(36720);
    return i;
  }
  
  public ListView getListView()
  {
    return this.mListView;
  }
  
  public int getPreCount()
  {
    return this.GHu;
  }
  
  public void setAdapter(BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(36711);
    this.GHq = paramBaseAdapter;
    getListView().setAdapter(this.GHq);
    AppMethodBeat.o(36711);
  }
  
  public void setHighLightChild(int paramInt)
  {
    AppMethodBeat.i(36721);
    paramInt = Math.max(0, paramInt);
    if (this.mListView == null)
    {
      ad.e("MicroMsg.MMChattingListView", "null == listView index:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(36721);
      return;
    }
    Object localObject2 = this.mListView.getChildAt(paramInt);
    if (localObject2 == null)
    {
      ad.e("MicroMsg.MMChattingListView", "null == view index:%s", new Object[] { Integer.valueOf(paramInt) });
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
      ad.e("MicroMsg.MMChattingListView", "null == view index:%s", new Object[] { Integer.valueOf(paramInt + this.mListView.getHeaderViewsCount()) });
      AppMethodBeat.o(36721);
      return;
    }
    ad.i("MicroMsg.MMChattingListView", "[setHighLightChild] index:%s view rect:%s headerCount:%s", new Object[] { Integer.valueOf(paramInt), new Rect(((View)localObject1).getLeft(), ((View)localObject1).getTop(), ((View)localObject1).getRight(), ((View)localObject1).getBottom()), Integer.valueOf(this.mListView.getHeaderViewsCount()) });
    localObject2 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 0.85F, 0.85F, 0.85F, 0.85F, 0.85F, 0.0F }) });
    ((ValueAnimator)localObject2).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(36706);
        this.GHw.getGlobalVisibleRect(MMChattingListView.a(MMChattingListView.this));
        MMChattingListView.a(MMChattingListView.this).top = this.GHw.getTop();
        MMChattingListView.a(MMChattingListView.this).bottom = this.GHw.getBottom();
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue("alpha")).floatValue();
        MMChattingListView.c(MMChattingListView.this).setAlpha((int)(f * 255.0F));
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
  
  public void setLoadExecutor(com.tencent.mm.ui.chatting.m.a.a parama)
  {
    this.GrS = parama;
  }
  
  public final void vL(boolean paramBoolean)
  {
    AppMethodBeat.i(36715);
    ad.i("MicroMsg.MMChattingListView", "[forceTopLoadData] start:" + paramBoolean + " isForceTopLoadDataForPosition:" + this.GHt);
    if (this.GHt)
    {
      AppMethodBeat.o(36715);
      return;
    }
    super.vL(paramBoolean);
    AppMethodBeat.o(36715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.MMChattingListView
 * JD-Core Version:    0.7.0.1
 */