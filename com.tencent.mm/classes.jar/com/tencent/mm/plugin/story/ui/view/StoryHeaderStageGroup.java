package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.ui.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/StoryHeaderStageGroup;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "contentView", "Landroidx/recyclerview/widget/RecyclerView;", "delView", "Landroid/view/View;", "downX", "", "downY", "lastScrollX", "onDeleteClick", "Lkotlin/Function0;", "", "getOnDeleteClick", "()Lkotlin/jvm/functions/Function0;", "setOnDeleteClick", "(Lkotlin/jvm/functions/Function0;)V", "overScroller", "Landroid/widget/Scroller;", "scrollDistance", "scrolling", "", "touchHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "computeScroll", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onListScroll", "onNestedPreFling", "target", "velocityX", "velocityY", "onNestedPreScroll", "dx", "dy", "consumed", "", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "nestedScrollAxes", "onStopNestedScroll", "resetHeader", "scrollHideDelGroup", "scrollShowDelGroup", "setContentAdapter", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter;", "plugin-story_release"})
public final class StoryHeaderStageGroup
  extends RelativeLayout
{
  private final Scroller LWN;
  private final com.tencent.mm.ui.o.b LWO;
  private int LWP;
  private int LWQ;
  private kotlin.g.a.a<x> LWR;
  final String TAG;
  private float dit;
  private float diu;
  private boolean scrolling;
  private final View snp;
  final RecyclerView xQw;
  
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
    View.inflate(paramContext, a.e.LDc, (ViewGroup)this);
    paramAttributeSet = findViewById(a.d.LzV);
    p.j(paramAttributeSet, "findViewById(R.id.sns_st…header_tip_stage_content)");
    this.xQw = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LzW);
    p.j(paramAttributeSet, "findViewById(R.id.sns_st…ader_tip_stage_del_group)");
    this.snp = paramAttributeSet;
    this.LWN = new Scroller(paramContext);
    this.LWO = new com.tencent.mm.ui.o.b(paramContext);
    this.xQw.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(0, false));
    this.snp.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120170);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryHeaderStageGroup$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.LWS.getOnDeleteClick();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryHeaderStageGroup$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120170);
      }
    });
    AppMethodBeat.o(120180);
  }
  
  private final void ggz()
  {
    AppMethodBeat.i(120172);
    if (!this.scrolling)
    {
      this.scrolling = true;
      this.LWN.startScroll(this.LWP, 0, this.snp.getMeasuredWidth() + aw.fromDPToPix(getContext(), 20) - this.LWP, 0);
      invalidate();
    }
    AppMethodBeat.o(120172);
  }
  
  public final void computeScroll()
  {
    AppMethodBeat.i(120174);
    if (this.LWN.computeScrollOffset())
    {
      Log.d(this.TAG, "computeScroll scrollX:" + this.LWN.getCurrX() + " scrollY:" + this.LWN.getCurrY());
      this.LWP = this.LWN.getCurrX();
      scrollTo(this.LWN.getCurrX(), 0);
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
        this.dit = paramMotionEvent.getX();
        this.diu = paramMotionEvent.getY();
        continue;
        if (localInteger.intValue() != 2) {
          break label31;
        }
        if (Math.abs(paramMotionEvent.getX() - this.dit) > Math.abs(paramMotionEvent.getY() - this.diu)) {
          requestDisallowInterceptTouchEvent(true);
        }
      }
    }
    for (;;)
    {
      this.dit = 0.0F;
      this.diu = 0.0F;
      break;
      label142:
      if (localInteger.intValue() != 3) {
        break;
      }
    }
  }
  
  public final kotlin.g.a.a<x> getOnDeleteClick()
  {
    return this.LWR;
  }
  
  final void ggA()
  {
    AppMethodBeat.i(120173);
    if (!this.scrolling)
    {
      this.scrolling = true;
      this.LWN.startScroll(this.LWP, 0, 0 - this.LWP, 0);
      invalidate();
    }
    AppMethodBeat.o(120173);
  }
  
  public final boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(120178);
    Log.d(this.TAG, "onNestedPreFling velocityX:" + paramFloat1 + " velocityY:" + paramFloat2);
    RecyclerView.LayoutManager localLayoutManager = this.xQw.getLayoutManager();
    RecyclerView.a locala = this.xQw.getAdapter();
    if ((localLayoutManager != null) && (locala != null))
    {
      if (paramFloat1 <= 0.0F) {
        break label114;
      }
      if (((LinearLayoutManager)localLayoutManager).kM() == locala.getItemCount() - 1) {
        ggz();
      }
    }
    for (;;)
    {
      boolean bool = super.onNestedPreFling(paramView, paramFloat1, paramFloat2);
      AppMethodBeat.o(120178);
      return bool;
      label114:
      if ((paramFloat1 < 0.0F) && (getScrollX() != 0)) {
        ggA();
      }
    }
  }
  
  public final void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(120175);
    Log.d(this.TAG, "onNestedPreScroll dx:" + paramInt1 + " dy:" + paramInt2);
    paramView = this.xQw.getLayoutManager();
    RecyclerView.a locala = this.xQw.getAdapter();
    if ((paramView != null) && (locala != null))
    {
      if (paramInt1 <= 0) {
        break label148;
      }
      if (((LinearLayoutManager)paramView).kM() == locala.getItemCount() - 1)
      {
        this.LWP = Math.min(this.LWP + paramInt1, this.snp.getMeasuredWidth() + aw.fromDPToPix(getContext(), 20));
        scrollTo(this.LWP, 0);
        if (paramArrayOfInt != null) {
          paramArrayOfInt[0] = paramInt1;
        }
      }
    }
    for (;;)
    {
      this.LWQ = paramInt1;
      AppMethodBeat.o(120175);
      return;
      label148:
      if ((paramInt1 < 0) && (getScrollX() != 0))
      {
        this.LWP = Math.max(this.LWP + paramInt1, 0);
        scrollTo(this.LWP, 0);
        if (paramArrayOfInt != null) {
          paramArrayOfInt[0] = paramInt1;
        }
      }
    }
  }
  
  public final void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(120176);
    Log.d(this.TAG, "onNestedScrollAccepted axes:%s", new Object[] { Integer.valueOf(paramInt) });
    this.LWQ = 0;
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
    Log.d(this.TAG, "onStopNestedScroll");
    if (this.LWP != 0)
    {
      if (this.LWQ <= 0) {
        break label51;
      }
      ggz();
    }
    for (;;)
    {
      this.LWQ = 0;
      this.scrolling = false;
      AppMethodBeat.o(120177);
      return;
      label51:
      if (this.LWQ < 0) {
        ggA();
      }
    }
  }
  
  public final void setContentAdapter(j paramj)
  {
    AppMethodBeat.i(120171);
    p.k(paramj, "adapter");
    this.xQw.setAdapter((RecyclerView.a)paramj);
    AppMethodBeat.o(120171);
  }
  
  public final void setOnDeleteClick(kotlin.g.a.a<x> parama)
  {
    this.LWR = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryHeaderStageGroup
 * JD-Core Version:    0.7.0.1
 */