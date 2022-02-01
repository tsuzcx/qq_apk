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
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.story.f.d.g;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.bt;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/StoryActionView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SCROLL_DIRECTION_L2R", "SCROLL_DIRECTION_R2L", "TAG", "", "TEXT_MAX_COLOR", "TEXT_MAX_SIZE", "", "TEXT_MIN_COLOR", "TEXT_MIN_SIZE", "TIP_ICON_REPLACE", "TIP_ICON_SPACE", "comment", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "commentOtherView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentBubbleView;", "commentTipTv", "Landroid/widget/TextView;", "curIndex", "isOpenList", "", "isSelf", "lastOffset", "likeTipTv", "onActionClicked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getOnActionClicked", "()Lkotlin/jvm/functions/Function1;", "setOnActionClicked", "(Lkotlin/jvm/functions/Function1;)V", "otherGroup", "Landroid/view/View;", "readyAnimation", "scrollDirection", "scrollState", "selfGroup", "tipGroup", "Landroid/widget/LinearLayout;", "tipSpan", "Lcom/tencent/mm/plugin/story/ui/view/StoryActionView$StoryTipImageSpan;", "animateToFocus", "textView", "animateToNormal", "animateToUnfocus", "needTipIcon", "tipIndex", "onMsgClosed", "onMsgOpened", "onPageChanged", "onPageChangedState", "state", "onPageChanging", "offset", "p2", "setup", "showTipIcon", "show", "view", "upadteComment", "StoryTipImageSpan", "plugin-story_release"})
public final class StoryActionView
  extends RelativeLayout
{
  g AMB;
  final float AYV;
  final float AYW;
  final int AYX;
  final int AYY;
  final int AYZ;
  final int AZa;
  private final String AZb;
  private final String AZc;
  final TextView AZd;
  final TextView AZe;
  private final LinearLayout AZf;
  private final StoryCommentBubbleView AZg;
  private final View AZh;
  final View AZi;
  boolean AZj;
  float AZk;
  boolean AZl;
  private final StoryActionView.a AZm;
  private d.g.a.b<? super Integer, z> AZn;
  int Aob;
  final String TAG;
  boolean drv;
  int rko;
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
    this.AYV = aq.fromDPToPix(paramContext, 17);
    this.AYW = aq.fromDPToPix(paramContext, 14);
    this.AYX = Color.parseColor("#FFFFFFFF");
    this.AYY = Color.parseColor("#7FFFFFFF");
    this.AZa = 1;
    this.AZb = "  ";
    this.AZc = " ";
    this.AZk = -1.0F;
    this.Aob = -1;
    View.inflate(paramContext, 2131495646, (ViewGroup)this);
    paramAttributeSet = findViewById(2131305247);
    p.g(paramAttributeSet, "findViewById(R.id.story_action_like_tip_tv)");
    this.AZd = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305245);
    p.g(paramAttributeSet, "findViewById(R.id.story_action_comment_tip_tv)");
    this.AZe = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305323);
    p.g(paramAttributeSet, "findViewById(R.id.story_…ment_others_comment_icon)");
    this.AZg = ((StoryCommentBubbleView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305249);
    p.g(paramAttributeSet, "findViewById(R.id.story_action_self)");
    this.AZh = paramAttributeSet;
    paramAttributeSet = findViewById(2131305248);
    p.g(paramAttributeSet, "findViewById(R.id.story_action_other)");
    this.AZi = paramAttributeSet;
    paramAttributeSet = findViewById(2131305246);
    p.g(paramAttributeSet, "findViewById(R.id.story_action_like_tip_group)");
    this.AZf = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131305324);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_others_comment_tv)");
    c.e((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.getResources().getDrawable(2131234267);
    paramAttributeSet.setBounds(0, 0, aq.fromDPToPix(paramContext, 8), aq.fromDPToPix(paramContext, 8));
    p.g(paramAttributeSet, "drawable");
    this.AZm = new StoryActionView.a(paramAttributeSet);
    paramAttributeSet = this.AZf.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).topMargin = aq.fromDPToPix(paramContext, 48);
    paramAttributeSet = this.AZf.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).bottomMargin = (aq.fromDPToPix(paramContext, 48) + ar.ej(paramContext));
    paramAttributeSet = this.AZi.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).topMargin = aq.fromDPToPix(paramContext, 48);
    paramAttributeSet = this.AZi.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).bottomMargin = (aq.fromDPToPix(paramContext, 48) + ar.ej(paramContext));
    this.AZg.setImageDrawable(ao.k(paramContext, 2131690368, -1));
    this.AZd.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120063);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.AZo.getOnActionClicked();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(0));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120063);
      }
    });
    this.AZe.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120064);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.AZo.getOnActionClicked();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(1));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120064);
      }
    });
    this.AZg.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120065);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryActionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.AZo.getOnActionClicked();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(0));
        }
        paramAnonymousView = h.ASt;
        h.Sq(8);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryActionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120065);
      }
    });
    AppMethodBeat.o(120079);
  }
  
  private final boolean SA(int paramInt)
  {
    return (!this.AZl) || (this.rko != paramInt);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(120078);
    p.h(paramg, "comment");
    if (this.drv)
    {
      paramg = paramg.AMx;
      Object localObject1 = (Collection)paramg;
      if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject1 = this.AZe;
        Object localObject2 = ad.MLZ;
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
      paramg = this.AZe;
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
        ((SpannableStringBuilder)localObject1).append((CharSequence)this.AZb).append((CharSequence)this.AZc);
        ((SpannableStringBuilder)localObject1).setSpan(this.AZm, ((SpannableStringBuilder)localObject1).length() - this.AZc.length(), ((SpannableStringBuilder)localObject1).length(), 33);
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
    return this.AZn;
  }
  
  final void q(TextView paramTextView)
  {
    AppMethodBeat.i(120073);
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofArgb(new int[] { paramTextView.getCurrentTextColor(), this.AYX });
    localValueAnimator1.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    localValueAnimator1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.b(paramTextView));
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofFloat(new float[] { paramTextView.getTextSize(), this.AYV });
    localValueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.c(paramTextView));
    paramTextView = new AnimatorSet();
    paramTextView.setDuration(150L);
    paramTextView.playTogether(new Animator[] { (Animator)localValueAnimator1, (Animator)localValueAnimator2 });
    paramTextView.start();
    AppMethodBeat.o(120073);
  }
  
  final void r(TextView paramTextView)
  {
    AppMethodBeat.i(120074);
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofArgb(new int[] { paramTextView.getCurrentTextColor(), this.AYY });
    localValueAnimator1.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    localValueAnimator1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.f(paramTextView));
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofFloat(new float[] { paramTextView.getTextSize(), this.AYW });
    localValueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.g(paramTextView));
    paramTextView = new AnimatorSet();
    paramTextView.setDuration(150L);
    paramTextView.playTogether(new Animator[] { (Animator)localValueAnimator1, (Animator)localValueAnimator2 });
    paramTextView.start();
    AppMethodBeat.o(120074);
  }
  
  final void s(TextView paramTextView)
  {
    AppMethodBeat.i(120075);
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofArgb(new int[] { paramTextView.getCurrentTextColor(), this.AYX });
    localValueAnimator1.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    localValueAnimator1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.d(paramTextView));
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofFloat(new float[] { paramTextView.getTextSize(), this.AYW });
    localValueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.e(paramTextView));
    paramTextView = new AnimatorSet();
    paramTextView.setDuration(150L);
    paramTextView.playTogether(new Animator[] { (Animator)localValueAnimator1, (Animator)localValueAnimator2 });
    paramTextView.start();
    AppMethodBeat.o(120075);
  }
  
  public final void setOnActionClicked(d.g.a.b<? super Integer, z> paramb)
  {
    this.AZn = paramb;
  }
  
  public final void setup(g paramg)
  {
    AppMethodBeat.i(120077);
    p.h(paramg, "comment");
    this.AMB = paramg;
    Object localObject1 = j.AKb;
    this.drv = bt.lQ(j.b.dTJ(), paramg.ALG);
    if (this.drv)
    {
      Object localObject3 = paramg.AMz;
      paramg = paramg.AMx;
      Object localObject2 = (Iterable)paramg;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = ((Iterator)localObject2).next();
        if (((com.tencent.mm.plugin.story.f.b.a)localObject4).ALC) {
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
        if (((com.tencent.mm.plugin.story.f.b.a)localObject5).ALC) {
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
        localObject4 = this.AZd;
        localObject5 = ad.MLZ;
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
        localObject3 = this.AZe;
        localObject4 = ad.MLZ;
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
        if ((i != 0) || (!SA(1))) {
          break label638;
        }
        a(true, this.AZe);
        label469:
        if (!((Collection)localObject2).isEmpty()) {
          break label650;
        }
        i = 1;
        label484:
        if ((i != 0) || (!SA(0))) {
          break label655;
        }
        a(true, this.AZd);
      }
      for (;;)
      {
        this.AZd.requestLayout();
        this.AZe.requestLayout();
        this.AZh.setVisibility(0);
        this.AZi.setVisibility(8);
        AppMethodBeat.o(120077);
        return;
        i = 0;
        break;
        label548:
        localObject3 = this.AZd;
        localObject4 = getContext();
        p.g(localObject4, "context");
        ((TextView)localObject3).setText((CharSequence)((Context)localObject4).getResources().getString(2131764268));
        break label322;
        label589:
        i = 0;
        break label345;
        label594:
        paramg = this.AZe;
        localObject3 = getContext();
        p.g(localObject3, "context");
        paramg.setText((CharSequence)((Context)localObject3).getResources().getString(2131764271));
        break label434;
        label633:
        i = 0;
        break label448;
        label638:
        a(false, this.AZe);
        break label469;
        label650:
        i = 0;
        break label484;
        label655:
        a(false, this.AZd);
      }
    }
    this.AZh.setVisibility(8);
    this.AZi.setVisibility(0);
    AppMethodBeat.o(120077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryActionView
 * JD-Core Version:    0.7.0.1
 */