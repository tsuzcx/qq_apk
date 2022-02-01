package com.tencent.mm.ui.chatting.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
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
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.pluginsdk.ui.tools.ScrollControlListView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.viewitems.c.a;

public class MMChattingListView
  extends MMPullDownView
  implements MMPullDownView.c, MMPullDownView.d, MMPullDownView.e, MMPullDownView.g
{
  private Bundle aeJD;
  private BaseAdapter aeLl;
  private Rect aeLm;
  private Paint aeLn;
  private boolean aeLo;
  private boolean aeLp;
  private int aeLq;
  private boolean aeLr;
  private int aeLs;
  private com.tencent.mm.ui.chatting.k.a.a aenb;
  private ListView mListView;
  
  public MMChattingListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(36708);
    this.aeLm = new Rect();
    this.aeLq = 400;
    this.aeLr = false;
    init(paramContext);
    AppMethodBeat.o(36708);
  }
  
  public MMChattingListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(36709);
    this.aeLm = new Rect();
    this.aeLq = 400;
    this.aeLr = false;
    init(paramContext);
    AppMethodBeat.o(36709);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(36710);
    this.aeLn = new Paint();
    this.aeLn.setColor(-16777216);
    this.mListView = new ScrollControlListView(paramContext, paramContext)
    {
      public final int axj(int paramAnonymousInt)
      {
        AppMethodBeat.i(254286);
        if (getChildCount() > paramAnonymousInt)
        {
          Object localObject = getChildAt(paramAnonymousInt);
          if ((((View)localObject).getTag() instanceof c.a))
          {
            localObject = (c.a)((View)localObject).getTag();
            if ((((c.a)localObject).timeTV != null) && (((c.a)localObject).timeTV.getVisibility() == 0))
            {
              paramAnonymousInt = MMChattingListView.a(MMChattingListView.this);
              AppMethodBeat.o(254286);
              return paramAnonymousInt;
            }
          }
        }
        paramAnonymousInt = super.axj(paramAnonymousInt);
        AppMethodBeat.o(254286);
        return paramAnonymousInt;
      }
      
      public final int getExtraScrollDistance()
      {
        AppMethodBeat.i(254291);
        if ((paramContext instanceof Activity))
        {
          View localView = ((Activity)paramContext).findViewById(R.h.fxx);
          int i = localView.getMeasuredHeight() - localView.getMinimumHeight();
          if (i > 0)
          {
            i = (int)(i * 1.3D);
            AppMethodBeat.o(254291);
            return i;
          }
        }
        AppMethodBeat.o(254291);
        return 0;
      }
      
      public final void onDraw(Canvas paramAnonymousCanvas)
      {
        AppMethodBeat.i(254294);
        Rect localRect2;
        if (!MMChattingListView.b(MMChattingListView.this).isEmpty())
        {
          Rect localRect1 = new Rect();
          MMChattingListView.c(MMChattingListView.this).getLocalVisibleRect(localRect1);
          localRect2 = new Rect(localRect1);
          Rect localRect3 = new Rect(localRect1);
          if (!MMChattingListView.d(MMChattingListView.this))
          {
            localRect2.bottom = MMChattingListView.b(MMChattingListView.this).top;
            localRect3.top = MMChattingListView.b(MMChattingListView.this).bottom;
            paramAnonymousCanvas.drawRect(localRect2, MMChattingListView.e(MMChattingListView.this));
            paramAnonymousCanvas.drawRect(localRect3, MMChattingListView.e(MMChattingListView.this));
            Log.d("ScrollControlListView", "[onDrawForeground] drawingRect:%s mHighLightItemRect:%s newStyle:%b showTimeTv:%b topRect:%s", new Object[] { localRect1, MMChattingListView.b(MMChattingListView.this), Boolean.valueOf(MMChattingListView.d(MMChattingListView.this)), Boolean.valueOf(MMChattingListView.f(MMChattingListView.this)), localRect2 });
          }
        }
        else
        {
          super.onDraw(paramAnonymousCanvas);
          AppMethodBeat.o(254294);
          return;
        }
        if (MMChattingListView.f(MMChattingListView.this)) {}
        for (localRect2.top = (MMChattingListView.b(MMChattingListView.this).top + com.tencent.mm.cd.a.fromDPToPix(paramContext, 35));; localRect2.top = MMChattingListView.b(MMChattingListView.this).top)
        {
          localRect2.bottom = (MMChattingListView.b(MMChattingListView.this).bottom + com.tencent.mm.cd.a.fromDPToPix(paramContext, 1));
          paramAnonymousCanvas.drawRect(localRect2, MMChattingListView.e(MMChattingListView.this));
          break;
        }
      }
    };
    this.mListView.setBackgroundDrawable(null);
    this.mListView.setSelector(R.g.mm_chat_listitem);
    this.mListView.setCacheColorHint(0);
    this.mListView.setDivider(null);
    this.mListView.setPadding(0, 0, 0, com.tencent.mm.cd.a.fromDPToPix(paramContext, 6));
    this.mListView.setClipToPadding(false);
    this.mListView.setScrollBarStyle(33554432);
    this.mListView.setId(R.h.fzf);
    setOverScrollMode(2);
    addView(this.mListView, new FrameLayout.LayoutParams(-1, -1));
    setCanOverScrool(false);
    LB(false);
    LC(false);
    setTopViewVisible(true);
    setOnBottomLoadDataListener(this);
    setOnTopLoadDataListener(this);
    setAtBottomCallBack(this);
    setAtTopCallBack(this);
    setIsBottomShowAll(true);
    setIsTopShowAll(false);
    setBottomViewVisible(true);
    setNestedOverScrollEnabled(true);
    this.aeLp = false;
    AppMethodBeat.o(36710);
  }
  
  public final void as(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(254328);
    Log.i("MicroMsg.MMChattingListView", "[forceTopLoadData] start:" + paramBoolean + " isForceTopLoadDataForPosition:" + this.aeLr);
    if (this.aeLr)
    {
      AppMethodBeat.o(254328);
      return;
    }
    super.as(paramBoolean, paramInt);
    AppMethodBeat.o(254328);
  }
  
  public final void bV(Bundle paramBundle)
  {
    AppMethodBeat.i(36716);
    StringBuilder localStringBuilder = new StringBuilder("[forceTopLoadData] sourceArgs:");
    if (paramBundle == null) {}
    for (String str = "";; str = paramBundle.toString())
    {
      Log.i("MicroMsg.MMChattingListView", str);
      this.aeJD = paramBundle;
      super.LC(true);
      AppMethodBeat.o(36716);
      return;
    }
  }
  
  public final void c(boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(36714);
    StringBuilder localStringBuilder = new StringBuilder("[lockTopLoadDataForPosition] start:").append(paramBoolean).append(" sourceArgs:");
    if (paramBundle == null) {}
    for (Object localObject = "null";; localObject = paramBundle)
    {
      Log.i("MicroMsg.MMChattingListView", localObject);
      this.aeLr = paramBoolean;
      this.aeJD = paramBundle;
      super.LB(paramBoolean);
      AppMethodBeat.o(36714);
      return;
    }
  }
  
  public final boolean dso()
  {
    AppMethodBeat.i(36718);
    this.aeLs = getCurCount();
    Log.i("MicroMsg.MMChattingListView", "[onBottomLoadData] mPreCount:" + this.aeLs);
    if (this.aenb != null)
    {
      this.aenb.a(d.a.aeHR, false, this.aeJD);
      this.aeJD = null;
      this.aeLr = false;
    }
    AppMethodBeat.o(36718);
    return false;
  }
  
  public final boolean dsp()
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
  
  public final boolean dsq()
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
  
  public final boolean dsr()
  {
    AppMethodBeat.i(36719);
    this.aeLs = getCurCount();
    Log.i("MicroMsg.MMChattingListView", "[onTopLoadData] mPreCount:" + this.aeLs + " isForceTopLoadDataForPosition:" + this.aeLr);
    com.tencent.mm.ui.chatting.k.a.a locala1;
    if (this.aenb != null)
    {
      if ((this.aeLr) && (this.aeJD != null)) {
        this.aeJD.putInt("SCENE", 2);
      }
      locala1 = this.aenb;
      if (!this.aeLr) {
        break label127;
      }
    }
    label127:
    for (d.a locala = d.a.aeHU;; locala = d.a.aeHQ)
    {
      locala1.a(locala, false, this.aeJD);
      this.aeJD = null;
      this.aeLr = false;
      AppMethodBeat.o(36719);
      return false;
    }
  }
  
  public BaseAdapter getBaseAdapter()
  {
    return this.aeLl;
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
    if (this.aeLl == null)
    {
      AppMethodBeat.o(36720);
      return 0;
    }
    int i = this.aeLl.getCount();
    AppMethodBeat.o(36720);
    return i;
  }
  
  public ListView getListView()
  {
    return this.mListView;
  }
  
  public int getPreCount()
  {
    return this.aeLs;
  }
  
  public void setAdapter(BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(36711);
    this.aeLl = paramBaseAdapter;
    getListView().setAdapter(this.aeLl);
    AppMethodBeat.o(36711);
  }
  
  public void setHighLightChild(int paramInt)
  {
    AppMethodBeat.i(36721);
    paramInt = Math.max(0, paramInt);
    if (this.mListView == null)
    {
      Log.e("MicroMsg.MMChattingListView", "null == listView index:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(36721);
      return;
    }
    Object localObject2 = this.mListView.getChildAt(paramInt);
    if (localObject2 == null)
    {
      Log.e("MicroMsg.MMChattingListView", "null == view index:%s", new Object[] { Integer.valueOf(paramInt) });
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
      Log.e("MicroMsg.MMChattingListView", "null == view index:%s", new Object[] { Integer.valueOf(paramInt + this.mListView.getHeaderViewsCount()) });
      AppMethodBeat.o(36721);
      return;
    }
    Log.i("MicroMsg.MMChattingListView", "[setHighLightChild] index:%s view rect:%s headerCount:%s", new Object[] { Integer.valueOf(paramInt), new Rect(((View)localObject1).getLeft(), ((View)localObject1).getTop(), ((View)localObject1).getRight(), ((View)localObject1).getBottom()), Integer.valueOf(this.mListView.getHeaderViewsCount()) });
    localObject2 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 0.85F, 0.85F, 0.85F, 0.85F, 0.85F, 0.0F }) });
    ((ValueAnimator)localObject2).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(36706);
        this.aeLu.getGlobalVisibleRect(MMChattingListView.b(MMChattingListView.this));
        MMChattingListView.b(MMChattingListView.this).top = this.aeLu.getTop();
        MMChattingListView.b(MMChattingListView.this).bottom = this.aeLu.getBottom();
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue("alpha")).floatValue();
        MMChattingListView.e(MMChattingListView.this).setAlpha((int)(f * 255.0F));
        MMChattingListView.c(MMChattingListView.this).postInvalidate();
        AppMethodBeat.o(36706);
      }
    });
    ((ValueAnimator)localObject2).addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(36707);
        super.onAnimationEnd(paramAnonymousAnimator);
        MMChattingListView.b(MMChattingListView.this).setEmpty();
        AppMethodBeat.o(36707);
      }
    });
    ((ValueAnimator)localObject2).setDuration(1600L);
    ((ValueAnimator)localObject2).start();
    AppMethodBeat.o(36721);
  }
  
  public void setHighLightChildNew(int paramInt)
  {
    AppMethodBeat.i(254341);
    this.aeLp = true;
    if (aw.isDarkMode()) {
      this.aeLn.setColor(getResources().getColor(R.e.White));
    }
    for (;;)
    {
      Log.i("MicroMsg.MMChattingListView", "[newStyle] setfalse" + this.aeLp);
      paramInt = Math.max(0, paramInt);
      if (this.mListView != null) {
        break;
      }
      Log.e("MicroMsg.MMChattingListView", "null == listView index:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(254341);
      return;
      this.aeLn.setColor(getResources().getColor(R.e.black));
    }
    Object localObject1 = this.mListView.getChildAt(paramInt);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.MMChattingListView", "null == view index:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(254341);
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
        Log.e("MicroMsg.MMChattingListView", "null == view index:%s", new Object[] { Integer.valueOf(paramInt + this.mListView.getHeaderViewsCount()) });
        AppMethodBeat.o(254341);
        return;
      }
      Log.i("MicroMsg.MMChattingListView", "[setHighLightChild] index:%s view rect:%s headerCount:%s", new Object[] { Integer.valueOf(paramInt), new Rect(((View)localObject1).getLeft(), ((View)localObject1).getTop(), ((View)localObject1).getRight(), ((View)localObject1).getBottom()), Integer.valueOf(this.mListView.getHeaderViewsCount()) });
      Object localObject2;
      if (aw.isDarkMode())
      {
        localObject2 = PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 0.08F, 0.08F, 0.08F, 0.08F, 0.08F, 0.0F });
        localObject2 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { localObject2 });
        TextView localTextView = (TextView)((View)localObject1).findViewById(R.h.fAm);
        if ((localTextView == null) || (localTextView.getVisibility() != 0)) {
          break label480;
        }
      }
      label480:
      for (this.aeLo = true;; this.aeLo = false)
      {
        ((View)localObject1).clearAnimation();
        ((ValueAnimator)localObject2).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(254289);
            this.aeLu.getGlobalVisibleRect(MMChattingListView.b(MMChattingListView.this));
            MMChattingListView.b(MMChattingListView.this).top = this.aeLu.getTop();
            MMChattingListView.b(MMChattingListView.this).bottom = this.aeLu.getBottom();
            float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue("alpha")).floatValue();
            MMChattingListView.e(MMChattingListView.this).setAlpha((int)(f * 255.0F));
            MMChattingListView.c(MMChattingListView.this).postInvalidate();
            AppMethodBeat.o(254289);
          }
        });
        ((ValueAnimator)localObject2).addListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(254290);
            super.onAnimationEnd(paramAnonymousAnimator);
            MMChattingListView.b(MMChattingListView.this).setEmpty();
            AppMethodBeat.o(254290);
          }
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(254287);
            super.onAnimationStart(paramAnonymousAnimator);
            MMChattingListView.g(MMChattingListView.this);
            AppMethodBeat.o(254287);
          }
        });
        ((ValueAnimator)localObject2).setDuration(1150L);
        ((ValueAnimator)localObject2).start();
        AppMethodBeat.o(254341);
        return;
        localObject2 = PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.0F });
        break;
      }
    }
  }
  
  public void setLoadExecutor(com.tencent.mm.ui.chatting.k.a.a parama)
  {
    this.aenb = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.MMChattingListView
 * JD-Core Version:    0.7.0.1
 */