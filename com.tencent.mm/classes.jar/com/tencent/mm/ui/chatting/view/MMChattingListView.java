package com.tencent.mm.ui.chatting.view;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.R.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.chatting.e.d.a;
import com.tencent.mm.ui.chatting.k.a.a;

public class MMChattingListView
  extends MMPullDownView
  implements MMPullDownView.c, MMPullDownView.d, MMPullDownView.e, MMPullDownView.g
{
  private ListView Nn;
  public BaseAdapter vAs;
  private Rect vAt = new Rect();
  private Paint vAu;
  private boolean vAv = false;
  private int vAw;
  private a vob;
  private Bundle vzB;
  
  public MMChattingListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public MMChattingListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.vAu = new Paint();
    this.vAu.setColor(-16777216);
    this.Nn = new MMChattingListView.1(this, paramContext);
    this.Nn.setBackgroundDrawable(null);
    this.Nn.setSelector(R.g.mm_chat_listitem);
    this.Nn.setCacheColorHint(0);
    this.Nn.setDivider(null);
    setOverScrollMode(2);
    addView(this.Nn, new FrameLayout.LayoutParams(-1, -1));
    setCanOverScrool(false);
    na(false);
    nb(false);
    setTopViewVisible(true);
    setOnBottomLoadDataListener(this);
    setOnTopLoadDataListener(this);
    setAtBottomCallBack(this);
    setAtTopCallBack(this);
    setIsBottomShowAll(true);
    setIsTopShowAll(false);
    setBottomViewVisible(true);
  }
  
  public final void a(boolean paramBoolean, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder("[lockTopLoadDataForPosition] start:").append(paramBoolean).append(" sourceArgs:");
    if (paramBundle == null) {}
    for (Object localObject = "null";; localObject = paramBundle)
    {
      y.i("MicroMsg.MMChattingListView", localObject);
      this.vAv = paramBoolean;
      this.vzB = paramBundle;
      super.na(paramBoolean);
      return;
    }
  }
  
  public final boolean aEU()
  {
    this.vAw = getCurCount();
    y.i("MicroMsg.MMChattingListView", "[onBottomLoadData] mPreCount:" + this.vAw);
    if (this.vob != null)
    {
      this.vob.a(d.a.vyc, false, this.vzB);
      this.vzB = null;
      this.vAv = false;
    }
    return false;
  }
  
  public final boolean aEV()
  {
    View localView = getListView().getChildAt(getListView().getFirstVisiblePosition());
    return (localView != null) && (localView.getTop() == 0);
  }
  
  public final boolean aEW()
  {
    View localView = getListView().getChildAt(getListView().getChildCount() - 1);
    if (localView == null) {}
    while ((localView.getBottom() <= getListView().getHeight()) && (getListView().getLastVisiblePosition() == getListView().getAdapter().getCount() - 1)) {
      return true;
    }
    return false;
  }
  
  public final boolean aEX()
  {
    this.vAw = getCurCount();
    y.i("MicroMsg.MMChattingListView", "[onTopLoadData] mPreCount:" + this.vAw + " isForceTopLoadDataForPosition:" + this.vAv);
    a locala1;
    if (this.vob != null)
    {
      if ((this.vAv) && (this.vzB != null)) {
        this.vzB.putInt("SCENE", 2);
      }
      locala1 = this.vob;
      if (!this.vAv) {
        break label113;
      }
    }
    label113:
    for (d.a locala = d.a.vyf;; locala = d.a.vyb)
    {
      locala1.a(locala, false, this.vzB);
      this.vzB = null;
      this.vAv = false;
      return false;
    }
  }
  
  public final void am(Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder("[forceTopLoadData] sourceArgs:");
    if (paramBundle == null) {}
    for (String str = "";; str = paramBundle.toString())
    {
      y.i("MicroMsg.MMChattingListView", str);
      this.vzB = paramBundle;
      super.nb(true);
      return;
    }
  }
  
  public BaseAdapter getBaseAdapter()
  {
    return this.vAs;
  }
  
  public int getCurCount()
  {
    if (this.vAs == null) {
      return 0;
    }
    return this.vAs.getCount();
  }
  
  public ListView getListView()
  {
    return this.Nn;
  }
  
  public int getPreCount()
  {
    return this.vAw;
  }
  
  public final void na(boolean paramBoolean)
  {
    y.i("MicroMsg.MMChattingListView", "[forceTopLoadData] start:" + paramBoolean + " isForceTopLoadDataForPosition:" + this.vAv);
    if (this.vAv) {
      return;
    }
    super.na(paramBoolean);
  }
  
  public void setAdapter(BaseAdapter paramBaseAdapter)
  {
    this.vAs = paramBaseAdapter;
  }
  
  public void setHighLightChild(int paramInt)
  {
    paramInt = Math.max(0, paramInt);
    if (this.Nn == null)
    {
      y.e("MicroMsg.MMChattingListView", "null == listView index:%s", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    Object localObject2 = this.Nn.getChildAt(paramInt);
    if (localObject2 == null)
    {
      y.e("MicroMsg.MMChattingListView", "null == view index:%s", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    Object localObject1 = localObject2;
    if (((View)localObject2).getBottom() - ((View)localObject2).getTop() <= 0) {
      localObject1 = this.Nn.getChildAt(this.Nn.getHeaderViewsCount() + paramInt);
    }
    if (localObject1 == null)
    {
      y.e("MicroMsg.MMChattingListView", "null == view index:%s", new Object[] { Integer.valueOf(paramInt + this.Nn.getHeaderViewsCount()) });
      return;
    }
    y.i("MicroMsg.MMChattingListView", "[setHighLightChild] index:%s view rect:%s headerCount:%s", new Object[] { Integer.valueOf(paramInt), new Rect(((View)localObject1).getLeft(), ((View)localObject1).getTop(), ((View)localObject1).getRight(), ((View)localObject1).getBottom()), Integer.valueOf(this.Nn.getHeaderViewsCount()) });
    localObject2 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 0.85F, 0.85F, 0.85F, 0.85F, 0.85F, 0.0F }) });
    ((ValueAnimator)localObject2).addUpdateListener(new MMChattingListView.2(this, (View)localObject1));
    ((ValueAnimator)localObject2).addListener(new MMChattingListView.3(this));
    ((ValueAnimator)localObject2).setDuration(1600L);
    ((ValueAnimator)localObject2).start();
  }
  
  public void setLoadExecutor(a parama)
  {
    this.vob = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.MMChattingListView
 * JD-Core Version:    0.7.0.1
 */