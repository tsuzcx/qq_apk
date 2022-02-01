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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.aq;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/StoryHeaderStageGroup;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "contentView", "Landroid/support/v7/widget/RecyclerView;", "delView", "Landroid/view/View;", "downX", "", "downY", "lastScrollX", "onDeleteClick", "Lkotlin/Function0;", "", "getOnDeleteClick", "()Lkotlin/jvm/functions/Function0;", "setOnDeleteClick", "(Lkotlin/jvm/functions/Function0;)V", "overScroller", "Landroid/widget/Scroller;", "scrollDistance", "scrolling", "", "touchHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "computeScroll", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onListScroll", "onNestedPreFling", "target", "velocityX", "velocityY", "onNestedPreScroll", "dx", "dy", "consumed", "", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "nestedScrollAxes", "onStopNestedScroll", "resetHeader", "scrollHideDelGroup", "scrollShowDelGroup", "setContentAdapter", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter;", "plugin-story_release"})
public final class StoryHeaderStageGroup
  extends RelativeLayout
{
  private final com.tencent.mm.ui.j.b BaA;
  private int BaB;
  private int BaC;
  private d.g.a.a<z> BaD;
  final RecyclerView Bay;
  private final Scroller Baz;
  final String TAG;
  private float cNg;
  private float cNh;
  private final View nUE;
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
    this.Bay = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305066);
    p.g(paramAttributeSet, "findViewById(R.id.sns_st…ader_tip_stage_del_group)");
    this.nUE = paramAttributeSet;
    this.Baz = new Scroller(paramContext);
    this.BaA = new com.tencent.mm.ui.j.b(paramContext);
    this.Bay.setLayoutManager((RecyclerView.i)new LinearLayoutManager(0));
    this.nUE.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120170);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryHeaderStageGroup$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.BaE.getOnDeleteClick();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryHeaderStageGroup$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120170);
      }
    });
    AppMethodBeat.o(120180);
  }
  
  private final void elT()
  {
    AppMethodBeat.i(120172);
    if (!this.scrolling)
    {
      this.scrolling = true;
      this.Baz.startScroll(this.BaB, 0, this.nUE.getMeasuredWidth() + aq.fromDPToPix(getContext(), 20) - this.BaB, 0);
      invalidate();
    }
    AppMethodBeat.o(120172);
  }
  
  public final void computeScroll()
  {
    AppMethodBeat.i(120174);
    if (this.Baz.computeScrollOffset())
    {
      ad.d(this.TAG, "computeScroll scrollX:" + this.Baz.getCurrX() + " scrollY:" + this.Baz.getCurrY());
      this.BaB = this.Baz.getCurrX();
      scrollTo(this.Baz.getCurrX(), 0);
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
        this.cNg = paramMotionEvent.getX();
        this.cNh = paramMotionEvent.getY();
        continue;
        if (localInteger.intValue() != 2) {
          break label31;
        }
        if (Math.abs(paramMotionEvent.getX() - this.cNg) > Math.abs(paramMotionEvent.getY() - this.cNh)) {
          requestDisallowInterceptTouchEvent(true);
        }
      }
    }
    for (;;)
    {
      this.cNg = 0.0F;
      this.cNh = 0.0F;
      break;
      label142:
      if (localInteger.intValue() != 3) {
        break;
      }
    }
  }
  
  final void elU()
  {
    AppMethodBeat.i(120173);
    if (!this.scrolling)
    {
      this.scrolling = true;
      this.Baz.startScroll(this.BaB, 0, 0 - this.BaB, 0);
      invalidate();
    }
    AppMethodBeat.o(120173);
  }
  
  public final d.g.a.a<z> getOnDeleteClick()
  {
    return this.BaD;
  }
  
  public final boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(120178);
    ad.d(this.TAG, "onNestedPreFling velocityX:" + paramFloat1 + " velocityY:" + paramFloat2);
    RecyclerView.i locali = this.Bay.getLayoutManager();
    RecyclerView.a locala = this.Bay.getAdapter();
    if ((locali != null) && (locala != null))
    {
      if (paramFloat1 <= 0.0F) {
        break label114;
      }
      if (((LinearLayoutManager)locali).kp() == locala.getItemCount() - 1) {
        elT();
      }
    }
    for (;;)
    {
      boolean bool = super.onNestedPreFling(paramView, paramFloat1, paramFloat2);
      AppMethodBeat.o(120178);
      return bool;
      label114:
      if ((paramFloat1 < 0.0F) && (getScrollX() != 0)) {
        elU();
      }
    }
  }
  
  public final void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(120175);
    ad.d(this.TAG, "onNestedPreScroll dx:" + paramInt1 + " dy:" + paramInt2);
    paramView = this.Bay.getLayoutManager();
    RecyclerView.a locala = this.Bay.getAdapter();
    if ((paramView != null) && (locala != null))
    {
      if (paramInt1 <= 0) {
        break label148;
      }
      if (((LinearLayoutManager)paramView).kp() == locala.getItemCount() - 1)
      {
        this.BaB = Math.min(this.BaB + paramInt1, this.nUE.getMeasuredWidth() + aq.fromDPToPix(getContext(), 20));
        scrollTo(this.BaB, 0);
        if (paramArrayOfInt != null) {
          paramArrayOfInt[0] = paramInt1;
        }
      }
    }
    for (;;)
    {
      this.BaC = paramInt1;
      AppMethodBeat.o(120175);
      return;
      label148:
      if ((paramInt1 < 0) && (getScrollX() != 0))
      {
        this.BaB = Math.max(this.BaB + paramInt1, 0);
        scrollTo(this.BaB, 0);
        if (paramArrayOfInt != null) {
          paramArrayOfInt[0] = paramInt1;
        }
      }
    }
  }
  
  public final void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(120176);
    ad.d(this.TAG, "onNestedScrollAccepted axes:%s", new Object[] { Integer.valueOf(paramInt) });
    this.BaC = 0;
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
    ad.d(this.TAG, "onStopNestedScroll");
    if (this.BaB != 0)
    {
      if (this.BaC <= 0) {
        break label51;
      }
      elT();
    }
    for (;;)
    {
      this.BaC = 0;
      this.scrolling = false;
      AppMethodBeat.o(120177);
      return;
      label51:
      if (this.BaC < 0) {
        elU();
      }
    }
  }
  
  public final void setContentAdapter(j paramj)
  {
    AppMethodBeat.i(120171);
    p.h(paramj, "adapter");
    this.Bay.setAdapter((RecyclerView.a)paramj);
    AppMethodBeat.o(120171);
  }
  
  public final void setOnDeleteClick(d.g.a.a<z> parama)
  {
    this.BaD = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryHeaderStageGroup
 * JD-Core Version:    0.7.0.1
 */