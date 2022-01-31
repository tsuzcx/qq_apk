package com.tencent.mm.ui.chatting.view;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.chatting.f.d.a;

public class MMChattingListView
  extends MMPullDownView
  implements MMPullDownView.c, MMPullDownView.d, MMPullDownView.e, MMPullDownView.g
{
  private ListView mListView;
  private com.tencent.mm.ui.chatting.l.a.a zDx;
  private Bundle zPY;
  private BaseAdapter zQR;
  private Rect zQS;
  private Paint zQT;
  private boolean zQU;
  private int zQV;
  
  public MMChattingListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(32764);
    this.zQS = new Rect();
    this.zQU = false;
    init(paramContext);
    AppMethodBeat.o(32764);
  }
  
  public MMChattingListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(32765);
    this.zQS = new Rect();
    this.zQU = false;
    init(paramContext);
    AppMethodBeat.o(32765);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(32766);
    this.zQT = new Paint();
    this.zQT.setColor(-16777216);
    this.mListView = new ListView(paramContext)
    {
      public final void onDrawForeground(Canvas paramAnonymousCanvas)
      {
        AppMethodBeat.i(32761);
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
          ab.d("MicroMsg.MMChattingListView", "[onDrawForeground] drawingRect:%s mHighLightItemRect:%s", new Object[] { localRect1, MMChattingListView.a(MMChattingListView.this) });
        }
        AppMethodBeat.o(32761);
      }
    };
    this.mListView.setBackgroundDrawable(null);
    this.mListView.setSelector(2130839631);
    this.mListView.setCacheColorHint(0);
    this.mListView.setDivider(null);
    this.mListView.setPadding(0, 0, 0, com.tencent.mm.cb.a.fromDPToPix(paramContext, 6));
    this.mListView.setClipToPadding(false);
    this.mListView.setScrollBarStyle(33554432);
    this.mListView.setId(2131820585);
    setOverScrollMode(2);
    addView(this.mListView, new FrameLayout.LayoutParams(-1, -1));
    setCanOverScrool(false);
    qD(false);
    qE(false);
    setTopViewVisible(true);
    setOnBottomLoadDataListener(this);
    setOnTopLoadDataListener(this);
    setAtBottomCallBack(this);
    setAtTopCallBack(this);
    setIsBottomShowAll(true);
    setIsTopShowAll(false);
    setBottomViewVisible(true);
    AppMethodBeat.o(32766);
  }
  
  public final void a(boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(32769);
    StringBuilder localStringBuilder = new StringBuilder("[lockTopLoadDataForPosition] start:").append(paramBoolean).append(" sourceArgs:");
    if (paramBundle == null) {}
    for (Object localObject = "null";; localObject = paramBundle)
    {
      ab.i("MicroMsg.MMChattingListView", localObject);
      this.zQU = paramBoolean;
      this.zPY = paramBundle;
      super.qD(paramBoolean);
      AppMethodBeat.o(32769);
      return;
    }
  }
  
  public final void aF(Bundle paramBundle)
  {
    AppMethodBeat.i(32771);
    StringBuilder localStringBuilder = new StringBuilder("[forceTopLoadData] sourceArgs:");
    if (paramBundle == null) {}
    for (String str = "";; str = paramBundle.toString())
    {
      ab.i("MicroMsg.MMChattingListView", str);
      this.zPY = paramBundle;
      super.qE(true);
      AppMethodBeat.o(32771);
      return;
    }
  }
  
  public final boolean bik()
  {
    AppMethodBeat.i(32773);
    this.zQV = getCurCount();
    ab.i("MicroMsg.MMChattingListView", "[onBottomLoadData] mPreCount:" + this.zQV);
    if (this.zDx != null)
    {
      this.zDx.a(d.a.zOx, false, this.zPY);
      this.zPY = null;
      this.zQU = false;
    }
    AppMethodBeat.o(32773);
    return false;
  }
  
  public final boolean bil()
  {
    AppMethodBeat.i(32772);
    View localView = getListView().getChildAt(getListView().getFirstVisiblePosition());
    if ((localView != null) && (localView.getTop() == 0))
    {
      AppMethodBeat.o(32772);
      return true;
    }
    AppMethodBeat.o(32772);
    return false;
  }
  
  public final boolean bim()
  {
    AppMethodBeat.i(32768);
    View localView = getListView().getChildAt(getListView().getChildCount() - 1);
    if (localView == null)
    {
      AppMethodBeat.o(32768);
      return true;
    }
    if ((localView.getBottom() <= getListView().getHeight() - getListView().getPaddingBottom()) && (getListView().getLastVisiblePosition() == getListView().getAdapter().getCount() - 1))
    {
      AppMethodBeat.o(32768);
      return true;
    }
    AppMethodBeat.o(32768);
    return false;
  }
  
  public final boolean bin()
  {
    AppMethodBeat.i(32774);
    this.zQV = getCurCount();
    ab.i("MicroMsg.MMChattingListView", "[onTopLoadData] mPreCount:" + this.zQV + " isForceTopLoadDataForPosition:" + this.zQU);
    com.tencent.mm.ui.chatting.l.a.a locala1;
    if (this.zDx != null)
    {
      if ((this.zQU) && (this.zPY != null)) {
        this.zPY.putInt("SCENE", 2);
      }
      locala1 = this.zDx;
      if (!this.zQU) {
        break label128;
      }
    }
    label128:
    for (d.a locala = d.a.zOA;; locala = d.a.zOw)
    {
      locala1.a(locala, false, this.zPY);
      this.zPY = null;
      this.zQU = false;
      AppMethodBeat.o(32774);
      return false;
    }
  }
  
  public BaseAdapter getBaseAdapter()
  {
    return this.zQR;
  }
  
  public int getBottomSpace()
  {
    AppMethodBeat.i(153913);
    int i = this.mListView.getHeight() - this.mListView.getPaddingBottom();
    if (this.mListView.getChildCount() <= 0) {}
    for (;;)
    {
      AppMethodBeat.o(153913);
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
    AppMethodBeat.i(32775);
    if (this.zQR == null)
    {
      AppMethodBeat.o(32775);
      return 0;
    }
    int i = this.zQR.getCount();
    AppMethodBeat.o(32775);
    return i;
  }
  
  public ListView getListView()
  {
    return this.mListView;
  }
  
  public int getPreCount()
  {
    return this.zQV;
  }
  
  public final void qD(boolean paramBoolean)
  {
    AppMethodBeat.i(32770);
    ab.i("MicroMsg.MMChattingListView", "[forceTopLoadData] start:" + paramBoolean + " isForceTopLoadDataForPosition:" + this.zQU);
    if (this.zQU)
    {
      AppMethodBeat.o(32770);
      return;
    }
    super.qD(paramBoolean);
    AppMethodBeat.o(32770);
  }
  
  public void setAdapter(BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(32767);
    this.zQR = paramBaseAdapter;
    getListView().setAdapter(this.zQR);
    AppMethodBeat.o(32767);
  }
  
  public void setHighLightChild(int paramInt)
  {
    AppMethodBeat.i(32776);
    paramInt = Math.max(0, paramInt);
    if (this.mListView == null)
    {
      ab.e("MicroMsg.MMChattingListView", "null == listView index:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(32776);
      return;
    }
    Object localObject2 = this.mListView.getChildAt(paramInt);
    if (localObject2 == null)
    {
      ab.e("MicroMsg.MMChattingListView", "null == view index:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(32776);
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
      ab.e("MicroMsg.MMChattingListView", "null == view index:%s", new Object[] { Integer.valueOf(paramInt + this.mListView.getHeaderViewsCount()) });
      AppMethodBeat.o(32776);
      return;
    }
    ab.i("MicroMsg.MMChattingListView", "[setHighLightChild] index:%s view rect:%s headerCount:%s", new Object[] { Integer.valueOf(paramInt), new Rect(((View)localObject1).getLeft(), ((View)localObject1).getTop(), ((View)localObject1).getRight(), ((View)localObject1).getBottom()), Integer.valueOf(this.mListView.getHeaderViewsCount()) });
    localObject2 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 0.85F, 0.85F, 0.85F, 0.85F, 0.85F, 0.0F }) });
    ((ValueAnimator)localObject2).addUpdateListener(new MMChattingListView.2(this, (View)localObject1));
    ((ValueAnimator)localObject2).addListener(new MMChattingListView.3(this));
    ((ValueAnimator)localObject2).setDuration(1600L);
    ((ValueAnimator)localObject2).start();
    AppMethodBeat.o(32776);
  }
  
  public void setLoadExecutor(com.tencent.mm.ui.chatting.l.a.a parama)
  {
    this.zDx = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.MMChattingListView
 * JD-Core Version:    0.7.0.1
 */