package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ListView.FixedViewInfo;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.a.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.aq;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationListView
  extends ListView
  implements View.OnTouchListener, AbsListView.OnScrollListener, a.a, AppBrandRecentView.e
{
  private int Xc;
  private HeaderContainer hph;
  private AbsListView.OnScrollListener lMb;
  private int lf;
  private int mCount;
  private Paint mPaint = new Paint(1);
  private View.OnTouchListener pXl;
  private LinkedList<ListView.FixedViewInfo> vQA = new LinkedList();
  private com.tencent.mm.plugin.appbrand.widget.header.a vQB;
  private String vQC;
  private float vQD;
  private int vQE;
  private Bitmap vQF = null;
  private RectF vQG = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
  private NinePatchDrawable vQH = null;
  private Rect vQI = new Rect();
  private final float vQJ = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
  private final float vQK = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
  private final float vQL = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
  private final float vQM = com.tencent.mm.cb.a.fromDPToPix(getContext(), 64);
  private final float vQN = 0.5F;
  private final float vQO = com.tencent.mm.cb.a.fromDPToPix(getContext(), 200);
  private View vQP;
  private boolean vQQ;
  private AdapterView.OnItemLongClickListener vec;
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private View getEmptyFooter()
  {
    Object localObject = getRootView().findViewById(R.h.launcher_ui_bottom_tabview);
    int j = (int)getResources().getDimension(R.f.NormalListHeight);
    int i;
    if (localObject != null)
    {
      i = ((View)localObject).getHeight();
      if (i > 0) {
        break label113;
      }
      i = j;
    }
    label113:
    for (;;)
    {
      localObject = new LinearLayout(getContext());
      this.vQP = new View(getContext());
      this.vQP.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
      ((LinearLayout)localObject).addView(this.vQP);
      ((LinearLayout)localObject).setBackgroundColor(getContext().getResources().getColor(R.e.white));
      return localObject;
      i = 0;
      break;
    }
  }
  
  private int getRealCount()
  {
    if (getAdapter() == null) {
      return 1;
    }
    return getAdapter().getCount() - getHeaderViewsCount() - getFooterViewsCount();
  }
  
  private void init(Context paramContext)
  {
    this.mPaint.setAlpha(255);
    this.mPaint.setTextSize(com.tencent.mm.cb.a.ab(getContext(), R.f.MiddleBtnTextSize));
    this.vQC = getResources().getString(R.l.close_btn);
    this.vQD = this.mPaint.measureText(this.vQC);
    super.setOnScrollListener(this);
    super.setOnTouchListener(this);
    setOverScrollMode(2);
    this.hph = ((d)g.r(d.class)).cF(paramContext);
    this.hph.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    addHeaderView(this.hph);
    addFooterView(getEmptyFooter());
    this.vQB = ((d)g.r(d.class)).a(paramContext, this, this.hph);
    this.vQB.a(this);
    this.hph.setAnimController(this.vQB);
    e.post(new ConversationListView.1(this), "DecodeCloseIcon");
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    super.addHeaderView(paramView, paramObject, paramBoolean);
    ListView.FixedViewInfo localFixedViewInfo = new ListView.FixedViewInfo(this);
    localFixedViewInfo.view = paramView;
    localFixedViewInfo.data = paramObject;
    localFixedViewInfo.isSelectable = paramBoolean;
    this.vQA.add(localFixedViewInfo);
  }
  
  public final void arr()
  {
    y.d("MicroMsg.ConversationListView", "[onOpenHeader]");
  }
  
  public final void ars()
  {
    y.d("MicroMsg.ConversationListView", "[onCloseHeader]");
  }
  
  public final void art()
  {
    y.d("MicroMsg.ConversationListView", "[onCloseHeader]");
  }
  
  public final void aru()
  {
    y.d("MicroMsg.ConversationListView", "[onOpenHeader]");
  }
  
  protected void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.attachViewToParent(paramView, paramInt, paramLayoutParams);
    if (this.Xc <= 0)
    {
      this.Xc = aq.cD(getContext());
      this.vQB.cf(getRootView().findViewById(R.h.action_bar_container));
      this.vQB.ce(getRootView().findViewById(R.h.launcher_ui_bottom_tabview));
    }
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    if (this.hph == null) {
      return super.canScrollHorizontally(paramInt);
    }
    return this.hph.getBottom() >= this.hph.getHeight();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.hph.getBottom() >= this.hph.getHeight()) && (this.hph.isFullScreen()) && (getFirstVisiblePosition() == 0))
    {
      if ((paramMotionEvent.getAction() == 0) && (this.hph.getBackUpFooterRect().contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
      {
        this.vQQ = true;
        if ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
          break label158;
        }
        if (!this.vQQ) {
          break label149;
        }
        this.vQB.ard();
        if (paramMotionEvent.getAction() == 1)
        {
          y.i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event");
          paramMotionEvent.setAction(3);
          super.dispatchTouchEvent(paramMotionEvent);
        }
      }
      for (;;)
      {
        this.vQQ = false;
        return true;
        if (paramMotionEvent.getAction() != 0) {
          break;
        }
        this.vQQ = false;
        break;
        label149:
        super.dispatchTouchEvent(paramMotionEvent);
      }
      label158:
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public int getFirstHeaderVisible()
  {
    Iterator localIterator = this.vQA.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (ListView.FixedViewInfo)localIterator.next();
      if (((ListView.FixedViewInfo)localObject).view == this.hph)
      {
        i += 1;
      }
      else
      {
        if ((((ListView.FixedViewInfo)localObject).view != null) && ((((ListView.FixedViewInfo)localObject).view instanceof ViewGroup)))
        {
          localObject = ((ViewGroup)((ListView.FixedViewInfo)localObject).view).getChildAt(0);
          if ((localObject != null) && (((View)localObject).getVisibility() == 0))
          {
            y.i("MicroMsg.ConversationListView", "[getFirstHeaderVisible] index:%s", new Object[] { Integer.valueOf(i) });
            return i;
          }
        }
        i += 1;
      }
    }
    y.i("MicroMsg.ConversationListView", "[getFirstHeaderVisible] index:%s", new Object[] { Integer.valueOf(i) });
    return i;
  }
  
  public final void mH(int paramInt) {}
  
  public void onDrawForeground(Canvas paramCanvas)
  {
    int i = 0;
    super.onDrawForeground(paramCanvas);
    if ((getFirstVisiblePosition() != 0) || (!this.hph.isFullScreen()) || (this.hph.getBottom() <= 6) || (this.vQE < 30)) {}
    do
    {
      return;
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setColor(getContext().getResources().getColor(R.e.app_brand_desktop_default_bg));
      this.mPaint.setAlpha(this.vQE);
      paramCanvas.drawRect(this.hph.getBackUpFooterRect(), this.mPaint);
      this.mPaint.reset();
      if (this.vQH != null)
      {
        this.vQH.setDither(true);
        int j = this.hph.getBackUpFooterRect().top;
        int k = (int)(j - this.vQM);
        this.vQI.set(0, k, getWidth(), j);
        this.vQH.setBounds(this.vQI);
        this.vQH.draw(paramCanvas);
      }
      y.d("MicroMsg.ConversationListView", "alvinluo top: %d, min: %f", new Object[] { Integer.valueOf(this.hph.getBackUpFooterRect().top), Float.valueOf(this.vQO) });
    } while (this.hph.getBackUpFooterRect().top < this.vQO);
    this.mPaint.reset();
    Paint localPaint = this.mPaint;
    if (this.vQE < 20) {}
    for (;;)
    {
      localPaint.setAlpha(i);
      if ((this.vQF == null) || (this.vQF.isRecycled())) {
        break;
      }
      float f1 = (getWidth() - this.vQF.getWidth()) / 2;
      float f2 = this.hph.getBackUpFooterRect().top;
      float f3 = this.vQJ;
      paramCanvas.drawBitmap(this.vQF, f1, f2 + f3, this.mPaint);
      return;
      i = this.vQE;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    y.i("MicroMsg.ConversationListView", "[onLayout] changed:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      setSelection(1);
      post(new ConversationListView.2(this));
    }
    LinearLayout.LayoutParams localLayoutParams;
    float f;
    if ((paramBoolean) || ((this.mCount < 16) && (getRealCount() != this.mCount)))
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.vQP.getLayoutParams();
      if (getAdapter() != null) {
        break label398;
      }
      paramInt1 = 0;
      paramInt2 = (int)getResources().getDimension(R.f.NormalListHeight);
      paramInt3 = getHeaderViewsCount();
      paramInt4 = getFooterViewsCount();
      int i = aq.cD(getContext());
      f = getMeasuredHeight() - paramInt2 * (paramInt1 - paramInt3 - paramInt4) - i;
      y.i("MicroMsg.ConversationListView", "[isFullScreen] totalItemCount:" + paramInt1 + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount() + " extraHeight:" + f);
      if (f >= 0.0F) {
        break label411;
      }
      paramBoolean = true;
      label246:
      paramInt4 = localLayoutParams.height;
      y.i("MicroMsg.ConversationListView", "[checkEmptyFooter] isRealFull:" + paramBoolean + " old height:" + paramInt4);
      View localView = getRootView().findViewById(R.h.launcher_ui_bottom_tabview);
      paramInt3 = (int)getResources().getDimension(R.f.NormalListHeight);
      if (localView == null) {
        break label416;
      }
      paramInt1 = localView.getHeight();
      label323:
      if (paramInt1 > 0) {
        break label421;
      }
      paramInt2 = paramInt3;
      label330:
      if (!paramBoolean) {
        break label426;
      }
    }
    label398:
    label411:
    label416:
    label421:
    label426:
    for (localLayoutParams.height = paramInt1;; localLayoutParams.height = ((int)f))
    {
      if (paramInt4 != localLayoutParams.height)
      {
        if ((!paramBoolean) || (Math.abs(f) <= paramInt2 + paramInt3))
        {
          y.i("MicroMsg.ConversationListView", "[checkEmptyFooter] setSelection");
          setSelection(1);
        }
        this.vQP.requestLayout();
      }
      this.mCount = getRealCount();
      return;
      paramInt1 = getAdapter().getCount();
      break;
      paramBoolean = false;
      break label246;
      paramInt1 = 0;
      break label323;
      paramInt2 = paramInt1;
      break label330;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    if (this.lMb != null) {
      this.lMb.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (this.vQB != null) {
      this.vQB.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (paramInt2 > 1) {
      if ((this.hph == null) || (this.hph.getBottom() < this.Xc + 3)) {
        break label142;
      }
    }
    label142:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if ((paramInt1 != 0) && (this.lf != 0))
      {
        paramInt1 = this.hph.getBottom();
        this.hph.getBackUpFooterRect().set(0, paramInt1, getWidth(), getHeight() + paramInt1);
        this.vQE = ((int)(255.0F * this.hph.getBottom() / this.hph.getHeight()));
      }
      return;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.lMb != null) {
      this.lMb.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (this.vQB != null) {
      this.vQB.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.lf = paramInt;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = this.vQB.onTouch(paramView, paramMotionEvent);
    boolean bool1 = bool2;
    if (this.pXl != null) {
      bool1 = bool2 | this.pXl.onTouch(paramView, paramMotionEvent);
    }
    return bool1;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.vec = paramOnItemLongClickListener;
    super.setOnItemLongClickListener(new ConversationListView.3(this));
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.lMb = paramOnScrollListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.pXl = paramOnTouchListener;
  }
  
  public void setSelection(int paramInt)
  {
    y.i("MicroMsg.ConversationListView", "[setSelection] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      super.setSelectionFromTop(getFirstHeaderVisible(), this.Xc);
      return;
    }
    super.setSelectionFromTop(paramInt, this.Xc);
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    y.i("MicroMsg.ConversationListView", "[smoothScrollToPosition] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.Xc);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt, this.Xc);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.Xc + paramInt2);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, this.Xc + paramInt2);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt1 == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.Xc + paramInt2, paramInt3);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, this.Xc + paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationListView
 * JD-Core Version:    0.7.0.1
 */