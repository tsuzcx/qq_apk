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
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.story.f.d.g;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/StoryActionView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SCROLL_DIRECTION_L2R", "SCROLL_DIRECTION_R2L", "TAG", "", "TEXT_MAX_COLOR", "TEXT_MAX_SIZE", "", "TEXT_MIN_COLOR", "TEXT_MIN_SIZE", "TIP_ICON_REPLACE", "TIP_ICON_SPACE", "comment", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "commentOtherView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentBubbleView;", "commentTipTv", "Landroid/widget/TextView;", "curIndex", "isOpenList", "", "isSelf", "lastOffset", "likeTipTv", "onActionClicked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getOnActionClicked", "()Lkotlin/jvm/functions/Function1;", "setOnActionClicked", "(Lkotlin/jvm/functions/Function1;)V", "otherGroup", "Landroid/view/View;", "readyAnimation", "scrollDirection", "scrollState", "selfGroup", "tipGroup", "Landroid/widget/LinearLayout;", "tipSpan", "Lcom/tencent/mm/plugin/story/ui/view/StoryActionView$StoryTipImageSpan;", "animateToFocus", "textView", "animateToNormal", "animateToUnfocus", "needTipIcon", "tipIndex", "onMsgClosed", "onMsgOpened", "onPageChanged", "onPageChangedState", "state", "onPageChanging", "offset", "p2", "setup", "showTipIcon", "show", "view", "upadteComment", "StoryTipImageSpan", "plugin-story_release"})
public final class StoryActionView
  extends RelativeLayout
{
  int AFo;
  g Bed;
  private final String BqA;
  final TextView BqB;
  final TextView BqC;
  private final LinearLayout BqD;
  private final StoryCommentBubbleView BqE;
  private final View BqF;
  final View BqG;
  boolean BqH;
  float BqI;
  boolean BqJ;
  private final StoryActionView.a BqK;
  private d.g.a.b<? super Integer, z> BqL;
  final float Bqt;
  final float Bqu;
  final int Bqv;
  final int Bqw;
  final int Bqx;
  final int Bqy;
  private final String Bqz;
  final String TAG;
  boolean dsB;
  int rss;
  int vi;
  
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
    this.Bqt = aq.fromDPToPix(paramContext, 17);
    this.Bqu = aq.fromDPToPix(paramContext, 14);
    this.Bqv = Color.parseColor("#FFFFFFFF");
    this.Bqw = Color.parseColor("#7FFFFFFF");
    this.Bqy = 1;
    this.Bqz = "  ";
    this.BqA = " ";
    this.BqI = -1.0F;
    this.AFo = -1;
    View.inflate(paramContext, 2131495646, (ViewGroup)this);
    paramAttributeSet = findViewById(2131305247);
    p.g(paramAttributeSet, "findViewById(R.id.story_action_like_tip_tv)");
    this.BqB = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305245);
    p.g(paramAttributeSet, "findViewById(R.id.story_action_comment_tip_tv)");
    this.BqC = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305323);
    p.g(paramAttributeSet, "findViewById(R.id.story_…ment_others_comment_icon)");
    this.BqE = ((StoryCommentBubbleView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305249);
    p.g(paramAttributeSet, "findViewById(R.id.story_action_self)");
    this.BqF = paramAttributeSet;
    paramAttributeSet = findViewById(2131305248);
    p.g(paramAttributeSet, "findViewById(R.id.story_action_other)");
    this.BqG = paramAttributeSet;
    paramAttributeSet = findViewById(2131305246);
    p.g(paramAttributeSet, "findViewById(R.id.story_action_like_tip_group)");
    this.BqD = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131305324);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_others_comment_tv)");
    c.e((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.getResources().getDrawable(2131234267);
    paramAttributeSet.setBounds(0, 0, aq.fromDPToPix(paramContext, 8), aq.fromDPToPix(paramContext, 8));
    p.g(paramAttributeSet, "drawable");
    this.BqK = new StoryActionView.a(paramAttributeSet);
    paramAttributeSet = this.BqD.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).topMargin = aq.fromDPToPix(paramContext, 48);
    paramAttributeSet = this.BqD.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).bottomMargin = (aq.fromDPToPix(paramContext, 48) + ar.en(paramContext));
    paramAttributeSet = this.BqG.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).topMargin = aq.fromDPToPix(paramContext, 48);
    paramAttributeSet = this.BqG.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).bottomMargin = (aq.fromDPToPix(paramContext, 48) + ar.en(paramContext));
    this.BqE.setImageDrawable(ao.k(paramContext, 2131690368, -1));
    this.BqB.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120063);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = this.BqM.getOnActionClicked();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(0));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120063);
      }
    });
    this.BqC.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120064);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = this.BqM.getOnActionClicked();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(1));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120064);
      }
    });
    this.BqE.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120065);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryActionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = this.BqM.getOnActionClicked();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(0));
        }
        paramAnonymousView = h.BjR;
        h.SX(8);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryActionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120065);
      }
    });
    AppMethodBeat.o(120079);
  }
  
  private final boolean Th(int paramInt)
  {
    return (!this.BqJ) || (this.rss != paramInt);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(120078);
    p.h(paramg, "comment");
    if (this.dsB)
    {
      paramg = paramg.BdZ;
      Object localObject1 = (Collection)paramg;
      if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject1 = this.BqC;
        Object localObject2 = ad.Njc;
        localObject2 = getContext();
        p.g(localObject2, "context");
        localObject2 = ((Context)localObject2).getResources().getString(2131764269);
        p.g(localObject2, "context.resources.getStr…tory_gallery_comment_tip)");
        paramg = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(paramg.size()) }, 1));
        p.g(paramg, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setText((CharSequence)paramg);
        AppMethodBeat.o(120078);
        return;
      }
      paramg = this.BqC;
      localObject1 = getContext();
      p.g(localObject1, "context");
      paramg.setText((CharSequence)((Context)localObject1).getResources().getString(2131764271));
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
        ((SpannableStringBuilder)localObject1).append((CharSequence)this.Bqz).append((CharSequence)this.BqA);
        ((SpannableStringBuilder)localObject1).setSpan(this.BqK, ((SpannableStringBuilder)localObject1).length() - this.BqA.length(), ((SpannableStringBuilder)localObject1).length(), 33);
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
        paramTextView.setText(n.trim((CharSequence)localObject1));
      }
      AppMethodBeat.o(120076);
      return;
      i = 0;
      break;
    }
  }
  
  public final d.g.a.b<Integer, z> getOnActionClicked()
  {
    return this.BqL;
  }
  
  final void o(TextView paramTextView)
  {
    AppMethodBeat.i(120073);
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofArgb(new int[] { paramTextView.getCurrentTextColor(), this.Bqv });
    localValueAnimator1.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    localValueAnimator1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.b(paramTextView));
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofFloat(new float[] { paramTextView.getTextSize(), this.Bqt });
    localValueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.c(paramTextView));
    paramTextView = new AnimatorSet();
    paramTextView.setDuration(150L);
    paramTextView.playTogether(new Animator[] { (Animator)localValueAnimator1, (Animator)localValueAnimator2 });
    paramTextView.start();
    AppMethodBeat.o(120073);
  }
  
  final void p(TextView paramTextView)
  {
    AppMethodBeat.i(120074);
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofArgb(new int[] { paramTextView.getCurrentTextColor(), this.Bqw });
    localValueAnimator1.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    localValueAnimator1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.f(paramTextView));
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofFloat(new float[] { paramTextView.getTextSize(), this.Bqu });
    localValueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.g(paramTextView));
    paramTextView = new AnimatorSet();
    paramTextView.setDuration(150L);
    paramTextView.playTogether(new Animator[] { (Animator)localValueAnimator1, (Animator)localValueAnimator2 });
    paramTextView.start();
    AppMethodBeat.o(120074);
  }
  
  final void q(TextView paramTextView)
  {
    AppMethodBeat.i(120075);
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofArgb(new int[] { paramTextView.getCurrentTextColor(), this.Bqv });
    localValueAnimator1.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    localValueAnimator1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.d(paramTextView));
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofFloat(new float[] { paramTextView.getTextSize(), this.Bqu });
    localValueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.e(paramTextView));
    paramTextView = new AnimatorSet();
    paramTextView.setDuration(150L);
    paramTextView.playTogether(new Animator[] { (Animator)localValueAnimator1, (Animator)localValueAnimator2 });
    paramTextView.start();
    AppMethodBeat.o(120075);
  }
  
  public final void setOnActionClicked(d.g.a.b<? super Integer, z> paramb)
  {
    this.BqL = paramb;
  }
  
  public final void setup(g paramg)
  {
    AppMethodBeat.i(120077);
    p.h(paramg, "comment");
    this.Bed = paramg;
    Object localObject1 = j.BbE;
    this.dsB = bu.lX(j.b.dXj(), paramg.Bdj);
    if (this.dsB)
    {
      Object localObject3 = paramg.Beb;
      paramg = paramg.BdZ;
      Object localObject2 = (Iterable)paramg;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = ((Iterator)localObject2).next();
        if (((com.tencent.mm.plugin.story.f.b.a)localObject4).Bdf) {
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
        if (((com.tencent.mm.plugin.story.f.b.a)localObject5).Bdf) {
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
        localObject4 = this.BqB;
        localObject5 = ad.Njc;
        localObject5 = getContext();
        p.g(localObject5, "context");
        localObject5 = ((Context)localObject5).getResources().getString(2131764266);
        p.g(localObject5, "context.resources.getStr…story_gallery_bubble_tip)");
        localObject3 = String.format((String)localObject5, Arrays.copyOf(new Object[] { Integer.valueOf(((LinkedList)localObject3).size()) }, 1));
        p.g(localObject3, "java.lang.String.format(format, *args)");
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
        localObject3 = this.BqC;
        localObject4 = ad.Njc;
        localObject4 = getContext();
        p.g(localObject4, "context");
        localObject4 = ((Context)localObject4).getResources().getString(2131764269);
        p.g(localObject4, "context.resources.getStr…tory_gallery_comment_tip)");
        paramg = String.format((String)localObject4, Arrays.copyOf(new Object[] { Integer.valueOf(paramg.size()) }, 1));
        p.g(paramg, "java.lang.String.format(format, *args)");
        ((TextView)localObject3).setText((CharSequence)paramg);
        label434:
        if (!((Collection)localObject1).isEmpty()) {
          break label633;
        }
        i = 1;
        label448:
        if ((i != 0) || (!Th(1))) {
          break label638;
        }
        a(true, this.BqC);
        label469:
        if (!((Collection)localObject2).isEmpty()) {
          break label650;
        }
        i = 1;
        label484:
        if ((i != 0) || (!Th(0))) {
          break label655;
        }
        a(true, this.BqB);
      }
      for (;;)
      {
        this.BqB.requestLayout();
        this.BqC.requestLayout();
        this.BqF.setVisibility(0);
        this.BqG.setVisibility(8);
        AppMethodBeat.o(120077);
        return;
        i = 0;
        break;
        label548:
        localObject3 = this.BqB;
        localObject4 = getContext();
        p.g(localObject4, "context");
        ((TextView)localObject3).setText((CharSequence)((Context)localObject4).getResources().getString(2131764268));
        break label322;
        label589:
        i = 0;
        break label345;
        label594:
        paramg = this.BqC;
        localObject3 = getContext();
        p.g(localObject3, "context");
        paramg.setText((CharSequence)((Context)localObject3).getResources().getString(2131764271));
        break label434;
        label633:
        i = 0;
        break label448;
        label638:
        a(false, this.BqC);
        break label469;
        label650:
        i = 0;
        break label484;
        label655:
        a(false, this.BqB);
      }
    }
    this.BqF.setVisibility(8);
    this.BqG.setVisibility(0);
    AppMethodBeat.o(120077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryActionView
 * JD-Core Version:    0.7.0.1
 */