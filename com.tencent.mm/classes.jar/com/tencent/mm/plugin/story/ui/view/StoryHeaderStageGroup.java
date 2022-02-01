package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
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
import com.tencent.mm.ui.bd;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/StoryHeaderStageGroup;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "contentView", "Landroidx/recyclerview/widget/RecyclerView;", "delView", "Landroid/view/View;", "downX", "", "downY", "lastScrollX", "onDeleteClick", "Lkotlin/Function0;", "", "getOnDeleteClick", "()Lkotlin/jvm/functions/Function0;", "setOnDeleteClick", "(Lkotlin/jvm/functions/Function0;)V", "overScroller", "Landroid/widget/Scroller;", "scrollDistance", "scrolling", "", "touchHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "computeScroll", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onListScroll", "onNestedPreFling", "target", "velocityX", "velocityY", "onNestedPreScroll", "dx", "dy", "consumed", "", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "nestedScrollAxes", "onStopNestedScroll", "resetHeader", "scrollHideDelGroup", "scrollShowDelGroup", "setContentAdapter", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryHeaderStageGroup
  extends RelativeLayout
{
  final RecyclerView BpW;
  private final Scroller SyB;
  private final com.tencent.mm.ui.o.b SyC;
  private int SyD;
  private int SyE;
  private kotlin.g.a.a<ah> SyF;
  final String TAG;
  private float fif;
  private float fig;
  private boolean scrolling;
  private final View vzn;
  
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
    View.inflate(paramContext, a.e.SgN, (ViewGroup)this);
    paramAttributeSet = findViewById(a.d.SdI);
    s.s(paramAttributeSet, "findViewById(R.id.sns_st…header_tip_stage_content)");
    this.BpW = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.SdJ);
    s.s(paramAttributeSet, "findViewById(R.id.sns_st…ader_tip_stage_del_group)");
    this.vzn = paramAttributeSet;
    this.SyB = new Scroller(paramContext);
    this.SyC = new com.tencent.mm.ui.o.b(paramContext);
    this.BpW.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(0, false));
    this.vzn.setOnClickListener(new StoryHeaderStageGroup..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(120180);
  }
  
  private static final void a(StoryHeaderStageGroup paramStoryHeaderStageGroup, View paramView)
  {
    AppMethodBeat.i(367439);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramStoryHeaderStageGroup);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryHeaderStageGroup", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStoryHeaderStageGroup, "this$0");
    paramStoryHeaderStageGroup = paramStoryHeaderStageGroup.getOnDeleteClick();
    if (paramStoryHeaderStageGroup != null) {
      paramStoryHeaderStageGroup.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/StoryHeaderStageGroup", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367439);
  }
  
  private final void hzU()
  {
    AppMethodBeat.i(120172);
    if (!this.scrolling)
    {
      this.scrolling = true;
      this.SyB.startScroll(this.SyD, 0, this.vzn.getMeasuredWidth() + bd.fromDPToPix(getContext(), 20) - this.SyD, 0);
      invalidate();
    }
    AppMethodBeat.o(120172);
  }
  
  public final void computeScroll()
  {
    AppMethodBeat.i(120174);
    if (this.SyB.computeScrollOffset())
    {
      Log.d(this.TAG, "computeScroll scrollX:" + this.SyB.getCurrX() + " scrollY:" + this.SyB.getCurrY());
      this.SyD = this.SyB.getCurrX();
      scrollTo(this.SyB.getCurrX(), 0);
      invalidate();
    }
    AppMethodBeat.o(120174);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    AppMethodBeat.i(120179);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    Integer localInteger;
    if (paramMotionEvent == null)
    {
      localInteger = null;
      if (localInteger != null) {
        break label77;
      }
      label26:
      if (localInteger != null) {
        break label104;
      }
      label31:
      if (localInteger != null) {
        break label149;
      }
      label36:
      if (localInteger != null) {
        break label161;
      }
      label41:
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        this.fif = 0.0F;
        this.fig = 0.0F;
      }
      for (;;)
      {
        AppMethodBeat.o(120179);
        return bool;
        localInteger = Integer.valueOf(paramMotionEvent.getActionMasked());
        break;
        label77:
        if (localInteger.intValue() != 0) {
          break label26;
        }
        this.fif = paramMotionEvent.getX();
        this.fig = paramMotionEvent.getY();
        continue;
        label104:
        if (localInteger.intValue() != 2) {
          break label31;
        }
        if (Math.abs(paramMotionEvent.getX() - this.fif) > Math.abs(paramMotionEvent.getY() - this.fig)) {
          requestDisallowInterceptTouchEvent(true);
        }
      }
      label149:
      if (localInteger.intValue() != 1) {
        break label36;
      }
      continue;
      label161:
      if (localInteger.intValue() != 3) {
        break label41;
      }
    }
  }
  
  public final kotlin.g.a.a<ah> getOnDeleteClick()
  {
    return this.SyF;
  }
  
  final void hzV()
  {
    AppMethodBeat.i(120173);
    if (!this.scrolling)
    {
      this.scrolling = true;
      this.SyB.startScroll(this.SyD, 0, 0 - this.SyD, 0);
      invalidate();
    }
    AppMethodBeat.o(120173);
  }
  
  public final boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(120178);
    Log.d(this.TAG, "onNestedPreFling velocityX:" + paramFloat1 + " velocityY:" + paramFloat2);
    RecyclerView.LayoutManager localLayoutManager = this.BpW.getLayoutManager();
    RecyclerView.a locala = this.BpW.getAdapter();
    if ((localLayoutManager != null) && (locala != null))
    {
      if (paramFloat1 <= 0.0F) {
        break label114;
      }
      if (((LinearLayoutManager)localLayoutManager).Jx() == locala.getItemCount() - 1) {
        hzU();
      }
    }
    for (;;)
    {
      boolean bool = super.onNestedPreFling(paramView, paramFloat1, paramFloat2);
      AppMethodBeat.o(120178);
      return bool;
      label114:
      if ((paramFloat1 < 0.0F) && (getScrollX() != 0)) {
        hzV();
      }
    }
  }
  
  public final void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(120175);
    Log.d(this.TAG, "onNestedPreScroll dx:" + paramInt1 + " dy:" + paramInt2);
    paramView = this.BpW.getLayoutManager();
    RecyclerView.a locala = this.BpW.getAdapter();
    if ((paramView != null) && (locala != null))
    {
      if (paramInt1 <= 0) {
        break label148;
      }
      if (((LinearLayoutManager)paramView).Jx() == locala.getItemCount() - 1)
      {
        this.SyD = Math.min(this.SyD + paramInt1, this.vzn.getMeasuredWidth() + bd.fromDPToPix(getContext(), 20));
        scrollTo(this.SyD, 0);
        if (paramArrayOfInt != null) {
          paramArrayOfInt[0] = paramInt1;
        }
      }
    }
    for (;;)
    {
      this.SyE = paramInt1;
      AppMethodBeat.o(120175);
      return;
      label148:
      if ((paramInt1 < 0) && (getScrollX() != 0))
      {
        this.SyD = Math.max(this.SyD + paramInt1, 0);
        scrollTo(this.SyD, 0);
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
    this.SyE = 0;
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
    if (this.SyD != 0)
    {
      if (this.SyE <= 0) {
        break label51;
      }
      hzU();
    }
    for (;;)
    {
      this.SyE = 0;
      this.scrolling = false;
      AppMethodBeat.o(120177);
      return;
      label51:
      if (this.SyE < 0) {
        hzV();
      }
    }
  }
  
  public final void setContentAdapter(j paramj)
  {
    AppMethodBeat.i(120171);
    s.u(paramj, "adapter");
    this.BpW.setAdapter((RecyclerView.a)paramj);
    AppMethodBeat.o(120171);
  }
  
  public final void setOnDeleteClick(kotlin.g.a.a<ah> parama)
  {
    this.SyF = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryHeaderStageGroup
 * JD-Core Version:    0.7.0.1
 */