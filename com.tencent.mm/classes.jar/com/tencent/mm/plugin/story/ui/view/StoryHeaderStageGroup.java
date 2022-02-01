package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.ui.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.j.b;
import d.g.a.a;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/StoryHeaderStageGroup;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "contentView", "Landroid/support/v7/widget/RecyclerView;", "delView", "Landroid/view/View;", "downX", "", "downY", "lastScrollX", "onDeleteClick", "Lkotlin/Function0;", "", "getOnDeleteClick", "()Lkotlin/jvm/functions/Function0;", "setOnDeleteClick", "(Lkotlin/jvm/functions/Function0;)V", "overScroller", "Landroid/widget/Scroller;", "scrollDistance", "scrolling", "", "touchHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "computeScroll", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onListScroll", "onNestedPreFling", "target", "velocityX", "velocityY", "onNestedPreScroll", "dx", "dy", "consumed", "", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "nestedScrollAxes", "onStopNestedScroll", "resetHeader", "scrollHideDelGroup", "scrollShowDelGroup", "setContentAdapter", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter;", "plugin-story_release"})
public final class StoryHeaderStageGroup
  extends RelativeLayout
{
  final RecyclerView BrW;
  private final Scroller BrX;
  private final b BrY;
  private int BrZ;
  private int Bsa;
  private a<z> Bsb;
  final String TAG;
  private float cNQ;
  private float cNR;
  private final View oak;
  private boolean scrolling;
  
  public StoryHeaderStageGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(120181);
    AppMethodBeat.o(120181);
  }
  
  public StoryHeaderStageGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120180);
    this.TAG = "MicroMsg.StoryHeaderStageGroup";
    View.inflate(paramContext, 2131495698, (ViewGroup)this);
    paramAttributeSet = findViewById(2131305064);
    p.g(paramAttributeSet, "findViewById(R.id.sns_st…header_tip_stage_content)");
    this.BrW = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305066);
    p.g(paramAttributeSet, "findViewById(R.id.sns_st…ader_tip_stage_del_group)");
    this.oak = paramAttributeSet;
    this.BrX = new Scroller(paramContext);
    this.BrY = new b(paramContext);
    this.BrW.setLayoutManager((RecyclerView.i)new LinearLayoutManager(0));
    this.oak.setOnClickListener((View.OnClickListener)new StoryHeaderStageGroup.1(this));
    AppMethodBeat.o(120180);
  }
  
  private final void epC()
  {
    AppMethodBeat.i(120172);
    if (!this.scrolling)
    {
      this.scrolling = true;
      this.BrX.startScroll(this.BrZ, 0, this.oak.getMeasuredWidth() + aq.fromDPToPix(getContext(), 20) - this.BrZ, 0);
      invalidate();
    }
    AppMethodBeat.o(120172);
  }
  
  public final void computeScroll()
  {
    AppMethodBeat.i(120174);
    if (this.BrX.computeScrollOffset())
    {
      ae.d(this.TAG, "computeScroll scrollX:" + this.BrX.getCurrX() + " scrollY:" + this.BrX.getCurrY());
      this.BrZ = this.BrX.getCurrX();
      scrollTo(this.BrX.getCurrX(), 0);
      invalidate();
    }
    AppMethodBeat.o(120174);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(120179);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    Integer localInteger;
    if (paramMotionEvent != null)
    {
      localInteger = Integer.valueOf(paramMotionEvent.getActionMasked());
      if (localInteger != null) {
        break label51;
      }
      label27:
      if (localInteger != null) {
        break label77;
      }
      label31:
      if (localInteger != null) {
        break label121;
      }
    }
    label51:
    label77:
    label121:
    while (localInteger.intValue() != 1)
    {
      if (localInteger != null) {
        break label142;
      }
      for (;;)
      {
        AppMethodBeat.o(120179);
        return bool;
        localInteger = null;
        break;
        if (localInteger.intValue() != 0) {
          break label27;
        }
        this.cNQ = paramMotionEvent.getX();
        this.cNR = paramMotionEvent.getY();
        continue;
        if (localInteger.intValue() != 2) {
          break label31;
        }
        if (Math.abs(paramMotionEvent.getX() - this.cNQ) > Math.abs(paramMotionEvent.getY() - this.cNR)) {
          requestDisallowInterceptTouchEvent(true);
        }
      }
    }
    for (;;)
    {
      this.cNQ = 0.0F;
      this.cNR = 0.0F;
      break;
      label142:
      if (localInteger.intValue() != 3) {
        break;
      }
    }
  }
  
  final void epD()
  {
    AppMethodBeat.i(120173);
    if (!this.scrolling)
    {
      this.scrolling = true;
      this.BrX.startScroll(this.BrZ, 0, 0 - this.BrZ, 0);
      invalidate();
    }
    AppMethodBeat.o(120173);
  }
  
  public final a<z> getOnDeleteClick()
  {
    return this.Bsb;
  }
  
  public final boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(120178);
    ae.d(this.TAG, "onNestedPreFling velocityX:" + paramFloat1 + " velocityY:" + paramFloat2);
    RecyclerView.i locali = this.BrW.getLayoutManager();
    RecyclerView.a locala = this.BrW.getAdapter();
    if ((locali != null) && (locala != null))
    {
      if (paramFloat1 <= 0.0F) {
        break label114;
      }
      if (((LinearLayoutManager)locali).kp() == locala.getItemCount() - 1) {
        epC();
      }
    }
    for (;;)
    {
      boolean bool = super.onNestedPreFling(paramView, paramFloat1, paramFloat2);
      AppMethodBeat.o(120178);
      return bool;
      label114:
      if ((paramFloat1 < 0.0F) && (getScrollX() != 0)) {
        epD();
      }
    }
  }
  
  public final void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(120175);
    ae.d(this.TAG, "onNestedPreScroll dx:" + paramInt1 + " dy:" + paramInt2);
    paramView = this.BrW.getLayoutManager();
    RecyclerView.a locala = this.BrW.getAdapter();
    if ((paramView != null) && (locala != null))
    {
      if (paramInt1 <= 0) {
        break label148;
      }
      if (((LinearLayoutManager)paramView).kp() == locala.getItemCount() - 1)
      {
        this.BrZ = Math.min(this.BrZ + paramInt1, this.oak.getMeasuredWidth() + aq.fromDPToPix(getContext(), 20));
        scrollTo(this.BrZ, 0);
        if (paramArrayOfInt != null) {
          paramArrayOfInt[0] = paramInt1;
        }
      }
    }
    for (;;)
    {
      this.Bsa = paramInt1;
      AppMethodBeat.o(120175);
      return;
      label148:
      if ((paramInt1 < 0) && (getScrollX() != 0))
      {
        this.BrZ = Math.max(this.BrZ + paramInt1, 0);
        scrollTo(this.BrZ, 0);
        if (paramArrayOfInt != null) {
          paramArrayOfInt[0] = paramInt1;
        }
      }
    }
  }
  
  public final void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(120176);
    ae.d(this.TAG, "onNestedScrollAccepted axes:%s", new Object[] { Integer.valueOf(paramInt) });
    this.Bsa = 0;
    this.scrolling = false;
    AppMethodBeat.o(120176);
  }
  
  public final boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public final void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(120177);
    ae.d(this.TAG, "onStopNestedScroll");
    if (this.BrZ != 0)
    {
      if (this.Bsa <= 0) {
        break label51;
      }
      epC();
    }
    for (;;)
    {
      this.Bsa = 0;
      this.scrolling = false;
      AppMethodBeat.o(120177);
      return;
      label51:
      if (this.Bsa < 0) {
        epD();
      }
    }
  }
  
  public final void setContentAdapter(j paramj)
  {
    AppMethodBeat.i(120171);
    p.h(paramj, "adapter");
    this.BrW.setAdapter((RecyclerView.a)paramj);
    AppMethodBeat.o(120171);
  }
  
  public final void setOnDeleteClick(a<z> parama)
  {
    this.Bsb = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryHeaderStageGroup
 * JD-Core Version:    0.7.0.1
 */