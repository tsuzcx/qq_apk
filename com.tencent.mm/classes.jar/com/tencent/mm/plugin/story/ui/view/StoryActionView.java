package com.tencent.mm.plugin.story.ui.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.story.a.c;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.f;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.f.d.g;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/StoryActionView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SCROLL_DIRECTION_L2R", "SCROLL_DIRECTION_R2L", "TAG", "", "TEXT_MAX_COLOR", "TEXT_MAX_SIZE", "", "TEXT_MIN_COLOR", "TEXT_MIN_SIZE", "TIP_ICON_REPLACE", "TIP_ICON_SPACE", "comment", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "commentOtherView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentBubbleView;", "commentTipTv", "Landroid/widget/TextView;", "curIndex", "isOpenList", "", "isSelf", "lastOffset", "likeTipTv", "onActionClicked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getOnActionClicked", "()Lkotlin/jvm/functions/Function1;", "setOnActionClicked", "(Lkotlin/jvm/functions/Function1;)V", "otherGroup", "Landroid/view/View;", "readyAnimation", "scrollDirection", "scrollState", "selfGroup", "tipGroup", "Landroid/widget/LinearLayout;", "tipSpan", "Lcom/tencent/mm/plugin/story/ui/view/StoryActionView$StoryTipImageSpan;", "animateToFocus", "textView", "animateToNormal", "animateToUnfocus", "needTipIcon", "tipIndex", "onMsgClosed", "onMsgOpened", "onPageChanged", "onPageChangedState", "state", "onPageChanging", "offset", "p2", "setup", "showTipIcon", "show", "view", "upadteComment", "StoryTipImageSpan", "plugin-story_release"})
public final class StoryActionView
  extends RelativeLayout
{
  g LIW;
  boolean LVA;
  private final StoryActionView.a LVB;
  private kotlin.g.a.b<? super Integer, x> LVC;
  final float LVk;
  final float LVl;
  final int LVm;
  final int LVn;
  final int LVo;
  final int LVp;
  private final String LVq;
  private final String LVr;
  final TextView LVs;
  final TextView LVt;
  private final LinearLayout LVu;
  private final StoryCommentBubbleView LVv;
  private final View LVw;
  final View LVx;
  boolean LVy;
  float LVz;
  int LcN;
  final String TAG;
  int bFP;
  boolean fCB;
  int wzx;
  
  public StoryActionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(120080);
    AppMethodBeat.o(120080);
  }
  
  public StoryActionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120079);
    this.TAG = "MicroMsg.StoryActionView";
    this.LVk = aw.fromDPToPix(paramContext, 17);
    this.LVl = aw.fromDPToPix(paramContext, 14);
    this.LVm = Color.parseColor("#FFFFFFFF");
    this.LVn = Color.parseColor("#7FFFFFFF");
    this.LVp = 1;
    this.LVq = "  ";
    this.LVr = " ";
    this.LVz = -1.0F;
    this.LcN = -1;
    View.inflate(paramContext, a.e.LCu, (ViewGroup)this);
    paramAttributeSet = findViewById(a.d.LAc);
    p.j(paramAttributeSet, "findViewById(R.id.story_action_like_tip_tv)");
    this.LVs = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LAa);
    p.j(paramAttributeSet, "findViewById(R.id.story_action_comment_tip_tv)");
    this.LVt = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LBd);
    p.j(paramAttributeSet, "findViewById(R.id.story_…ment_others_comment_icon)");
    this.LVv = ((StoryCommentBubbleView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LAe);
    p.j(paramAttributeSet, "findViewById(R.id.story_action_self)");
    this.LVw = paramAttributeSet;
    paramAttributeSet = findViewById(a.d.LAd);
    p.j(paramAttributeSet, "findViewById(R.id.story_action_other)");
    this.LVx = paramAttributeSet;
    paramAttributeSet = findViewById(a.d.LAb);
    p.j(paramAttributeSet, "findViewById(R.id.story_action_like_tip_group)");
    this.LVu = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LBe);
    p.j(paramAttributeSet, "findViewById(R.id.story_comment_others_comment_tv)");
    d.g((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.getResources().getDrawable(a.c.Lzn);
    paramAttributeSet.setBounds(0, 0, aw.fromDPToPix(paramContext, 8), aw.fromDPToPix(paramContext, 8));
    p.j(paramAttributeSet, "drawable");
    this.LVB = new StoryActionView.a(paramAttributeSet);
    paramAttributeSet = this.LVu.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).topMargin = aw.fromDPToPix(paramContext, 48);
    paramAttributeSet = this.LVu.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).bottomMargin = (aw.fromDPToPix(paramContext, 48) + ax.aB(paramContext));
    paramAttributeSet = this.LVx.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).topMargin = aw.fromDPToPix(paramContext, 48);
    paramAttributeSet = this.LVx.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).bottomMargin = (aw.fromDPToPix(paramContext, 48) + ax.aB(paramContext));
    this.LVv.setImageDrawable(au.o(paramContext, a.f.icons_filled_chats, -1));
    this.LVs.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120063);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.LVD.getOnActionClicked();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(0));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120063);
      }
    });
    this.LVt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120064);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.LVD.getOnActionClicked();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(1));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120064);
      }
    });
    this.LVv.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120065);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryActionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.LVD.getOnActionClicked();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(0));
        }
        paramAnonymousView = h.LOJ;
        h.aio(8);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryActionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120065);
      }
    });
    AppMethodBeat.o(120079);
  }
  
  private final boolean aiy(int paramInt)
  {
    return (!this.LVA) || (this.wzx != paramInt);
  }
  
  final void E(TextView paramTextView)
  {
    AppMethodBeat.i(120073);
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofArgb(new int[] { paramTextView.getCurrentTextColor(), this.LVm });
    localValueAnimator1.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    localValueAnimator1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.b(paramTextView));
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofFloat(new float[] { paramTextView.getTextSize(), this.LVk });
    localValueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.c(paramTextView));
    paramTextView = new AnimatorSet();
    paramTextView.setDuration(150L);
    paramTextView.playTogether(new Animator[] { (Animator)localValueAnimator1, (Animator)localValueAnimator2 });
    paramTextView.start();
    AppMethodBeat.o(120073);
  }
  
  final void F(TextView paramTextView)
  {
    AppMethodBeat.i(120074);
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofArgb(new int[] { paramTextView.getCurrentTextColor(), this.LVn });
    localValueAnimator1.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    localValueAnimator1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.f(paramTextView));
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofFloat(new float[] { paramTextView.getTextSize(), this.LVl });
    localValueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.g(paramTextView));
    paramTextView = new AnimatorSet();
    paramTextView.setDuration(150L);
    paramTextView.playTogether(new Animator[] { (Animator)localValueAnimator1, (Animator)localValueAnimator2 });
    paramTextView.start();
    AppMethodBeat.o(120074);
  }
  
  final void G(TextView paramTextView)
  {
    AppMethodBeat.i(120075);
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofArgb(new int[] { paramTextView.getCurrentTextColor(), this.LVm });
    localValueAnimator1.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    localValueAnimator1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.d(paramTextView));
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofFloat(new float[] { paramTextView.getTextSize(), this.LVl });
    localValueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.e(paramTextView));
    paramTextView = new AnimatorSet();
    paramTextView.setDuration(150L);
    paramTextView.playTogether(new Animator[] { (Animator)localValueAnimator1, (Animator)localValueAnimator2 });
    paramTextView.start();
    AppMethodBeat.o(120075);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(120078);
    p.k(paramg, "comment");
    if (this.fCB)
    {
      paramg = paramg.LIS;
      Object localObject1 = (Collection)paramg;
      if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject1 = this.LVt;
        Object localObject2 = af.aaBG;
        localObject2 = getContext();
        p.j(localObject2, "context");
        localObject2 = ((Context)localObject2).getResources().getString(a.g.LEb);
        p.j(localObject2, "context.resources.getStr…tory_gallery_comment_tip)");
        paramg = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(paramg.size()) }, 1));
        p.j(paramg, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setText((CharSequence)paramg);
        AppMethodBeat.o(120078);
        return;
      }
      paramg = this.LVt;
      localObject1 = getContext();
      p.j(localObject1, "context");
      paramg.setText((CharSequence)((Context)localObject1).getResources().getString(a.g.LEd));
    }
    AppMethodBeat.o(120078);
  }
  
  final void a(boolean paramBoolean, TextView paramTextView)
  {
    int j = 0;
    AppMethodBeat.i(120076);
    Object localObject2 = paramTextView.getText();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (CharSequence)"";
    }
    localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
    if (paramBoolean)
    {
      localObject2 = (StoryActionView.a[])((SpannableStringBuilder)localObject1).getSpans(0, ((SpannableStringBuilder)localObject1).length(), StoryActionView.a.class);
      if (localObject2 != null) {
        if (localObject2.length != 0) {
          break label158;
        }
      }
      label158:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          j = 1;
        }
        if (j == 0) {
          break;
        }
        ((SpannableStringBuilder)localObject1).append((CharSequence)this.LVq).append((CharSequence)this.LVr);
        ((SpannableStringBuilder)localObject1).setSpan(this.LVB, ((SpannableStringBuilder)localObject1).length() - this.LVr.length(), ((SpannableStringBuilder)localObject1).length(), 33);
        paramTextView.setText((CharSequence)localObject1);
        AppMethodBeat.o(120076);
        return;
      }
    }
    localObject2 = (StoryActionView.a[])((SpannableStringBuilder)localObject1).getSpans(0, ((SpannableStringBuilder)localObject1).length(), StoryActionView.a.class);
    if (localObject2 != null)
    {
      if (localObject2.length != 0) {
        break label230;
      }
      i = 1;
      if (i == 0) {
        break label235;
      }
    }
    label230:
    label235:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ((SpannableStringBuilder)localObject1).removeSpan(StoryActionView.a.class);
        paramTextView.setText(n.bb((CharSequence)localObject1));
      }
      AppMethodBeat.o(120076);
      return;
      i = 0;
      break;
    }
  }
  
  public final kotlin.g.a.b<Integer, x> getOnActionClicked()
  {
    return this.LVC;
  }
  
  public final void setOnActionClicked(kotlin.g.a.b<? super Integer, x> paramb)
  {
    this.LVC = paramb;
  }
  
  public final void setup(g paramg)
  {
    AppMethodBeat.i(120077);
    p.k(paramg, "comment");
    this.LIW = paramg;
    Object localObject1 = j.LGA;
    this.fCB = Util.isEqual(j.b.fOo(), paramg.LIb);
    if (this.fCB)
    {
      Object localObject3 = paramg.LIU;
      paramg = paramg.LIS;
      Object localObject2 = (Iterable)paramg;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = ((Iterator)localObject2).next();
        if (((com.tencent.mm.plugin.story.f.b.a)localObject4).LHX) {
          ((Collection)localObject1).add(localObject4);
        }
      }
      localObject1 = (List)localObject1;
      Object localObject4 = (Iterable)localObject3;
      localObject2 = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      Object localObject5;
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((Iterator)localObject4).next();
        if (((com.tencent.mm.plugin.story.f.b.a)localObject5).LHX) {
          ((Collection)localObject2).add(localObject5);
        }
      }
      localObject2 = (List)localObject2;
      localObject4 = (Collection)localObject3;
      int i;
      if ((localObject4 == null) || (((Collection)localObject4).isEmpty()))
      {
        i = 1;
        if (i != 0) {
          break label548;
        }
        localObject4 = this.LVs;
        localObject5 = af.aaBG;
        localObject5 = getContext();
        p.j(localObject5, "context");
        localObject5 = ((Context)localObject5).getResources().getString(a.g.LDY);
        p.j(localObject5, "context.resources.getStr…story_gallery_bubble_tip)");
        localObject3 = String.format((String)localObject5, Arrays.copyOf(new Object[] { Integer.valueOf(((LinkedList)localObject3).size()) }, 1));
        p.j(localObject3, "java.lang.String.format(format, *args)");
        ((TextView)localObject4).setText((CharSequence)localObject3);
        label322:
        localObject3 = (Collection)paramg;
        if ((localObject3 != null) && (!((Collection)localObject3).isEmpty())) {
          break label589;
        }
        i = 1;
        label345:
        if (i != 0) {
          break label594;
        }
        localObject3 = this.LVt;
        localObject4 = af.aaBG;
        localObject4 = getContext();
        p.j(localObject4, "context");
        localObject4 = ((Context)localObject4).getResources().getString(a.g.LEb);
        p.j(localObject4, "context.resources.getStr…tory_gallery_comment_tip)");
        paramg = String.format((String)localObject4, Arrays.copyOf(new Object[] { Integer.valueOf(paramg.size()) }, 1));
        p.j(paramg, "java.lang.String.format(format, *args)");
        ((TextView)localObject3).setText((CharSequence)paramg);
        label434:
        if (!((Collection)localObject1).isEmpty()) {
          break label633;
        }
        i = 1;
        label448:
        if ((i != 0) || (!aiy(1))) {
          break label638;
        }
        a(true, this.LVt);
        label469:
        if (!((Collection)localObject2).isEmpty()) {
          break label650;
        }
        i = 1;
        label484:
        if ((i != 0) || (!aiy(0))) {
          break label655;
        }
        a(true, this.LVs);
      }
      for (;;)
      {
        this.LVs.requestLayout();
        this.LVt.requestLayout();
        this.LVw.setVisibility(0);
        this.LVx.setVisibility(8);
        AppMethodBeat.o(120077);
        return;
        i = 0;
        break;
        label548:
        localObject3 = this.LVs;
        localObject4 = getContext();
        p.j(localObject4, "context");
        ((TextView)localObject3).setText((CharSequence)((Context)localObject4).getResources().getString(a.g.LEa));
        break label322;
        label589:
        i = 0;
        break label345;
        label594:
        paramg = this.LVt;
        localObject3 = getContext();
        p.j(localObject3, "context");
        paramg.setText((CharSequence)((Context)localObject3).getResources().getString(a.g.LEd));
        break label434;
        label633:
        i = 0;
        break label448;
        label638:
        a(false, this.LVt);
        break label469;
        label650:
        i = 0;
        break label484;
        label655:
        a(false, this.LVs);
      }
    }
    this.LVw.setVisibility(8);
    this.LVx.setVisibility(0);
    AppMethodBeat.o(120077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryActionView
 * JD-Core Version:    0.7.0.1
 */