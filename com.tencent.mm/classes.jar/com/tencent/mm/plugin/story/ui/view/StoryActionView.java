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
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.story.f.d.g;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/StoryActionView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SCROLL_DIRECTION_L2R", "SCROLL_DIRECTION_R2L", "TAG", "", "TEXT_MAX_COLOR", "TEXT_MAX_SIZE", "", "TEXT_MIN_COLOR", "TEXT_MIN_SIZE", "TIP_ICON_REPLACE", "TIP_ICON_SPACE", "comment", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "commentOtherView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentBubbleView;", "commentTipTv", "Landroid/widget/TextView;", "curIndex", "isOpenList", "", "isSelf", "lastOffset", "likeTipTv", "onActionClicked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getOnActionClicked", "()Lkotlin/jvm/functions/Function1;", "setOnActionClicked", "(Lkotlin/jvm/functions/Function1;)V", "otherGroup", "Landroid/view/View;", "readyAnimation", "scrollDirection", "scrollState", "selfGroup", "tipGroup", "Landroid/widget/LinearLayout;", "tipSpan", "Lcom/tencent/mm/plugin/story/ui/view/StoryActionView$StoryTipImageSpan;", "animateToFocus", "textView", "animateToNormal", "animateToUnfocus", "needTipIcon", "tipIndex", "onMsgClosed", "onMsgOpened", "onPageChanged", "onPageChangedState", "state", "onPageChanging", "offset", "p2", "setup", "showTipIcon", "show", "view", "upadteComment", "StoryTipImageSpan", "plugin-story_release"})
public final class StoryActionView
  extends RelativeLayout
{
  int EOS;
  final float FBg;
  final float FBh;
  final int FBi;
  final int FBj;
  final int FBk;
  final int FBl;
  private final String FBm;
  private final String FBn;
  final TextView FBo;
  final TextView FBp;
  private final LinearLayout FBq;
  private final StoryCommentBubbleView FBr;
  private final View FBs;
  final View FBt;
  boolean FBu;
  float FBv;
  boolean FBw;
  private final StoryActionView.a FBx;
  private kotlin.g.a.b<? super Integer, x> FBy;
  g FoU;
  final String TAG;
  boolean dJM;
  int sTB;
  int vp;
  
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
    this.FBg = at.fromDPToPix(paramContext, 17);
    this.FBh = at.fromDPToPix(paramContext, 14);
    this.FBi = Color.parseColor("#FFFFFFFF");
    this.FBj = Color.parseColor("#7FFFFFFF");
    this.FBl = 1;
    this.FBm = "  ";
    this.FBn = " ";
    this.FBv = -1.0F;
    this.EOS = -1;
    View.inflate(paramContext, 2131496551, (ViewGroup)this);
    paramAttributeSet = findViewById(2131308451);
    p.g(paramAttributeSet, "findViewById(R.id.story_action_like_tip_tv)");
    this.FBo = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308449);
    p.g(paramAttributeSet, "findViewById(R.id.story_action_comment_tip_tv)");
    this.FBp = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308528);
    p.g(paramAttributeSet, "findViewById(R.id.story_…ment_others_comment_icon)");
    this.FBr = ((StoryCommentBubbleView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308453);
    p.g(paramAttributeSet, "findViewById(R.id.story_action_self)");
    this.FBs = paramAttributeSet;
    paramAttributeSet = findViewById(2131308452);
    p.g(paramAttributeSet, "findViewById(R.id.story_action_other)");
    this.FBt = paramAttributeSet;
    paramAttributeSet = findViewById(2131308450);
    p.g(paramAttributeSet, "findViewById(R.id.story_action_like_tip_group)");
    this.FBq = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131308529);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_others_comment_tv)");
    d.f((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.getResources().getDrawable(2131235144);
    paramAttributeSet.setBounds(0, 0, at.fromDPToPix(paramContext, 8), at.fromDPToPix(paramContext, 8));
    p.g(paramAttributeSet, "drawable");
    this.FBx = new StoryActionView.a(paramAttributeSet);
    paramAttributeSet = this.FBq.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).topMargin = at.fromDPToPix(paramContext, 48);
    paramAttributeSet = this.FBq.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).bottomMargin = (at.fromDPToPix(paramContext, 48) + au.aD(paramContext));
    paramAttributeSet = this.FBt.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).topMargin = at.fromDPToPix(paramContext, 48);
    paramAttributeSet = this.FBt.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).bottomMargin = (at.fromDPToPix(paramContext, 48) + au.aD(paramContext));
    this.FBr.setImageDrawable(ar.m(paramContext, 2131690510, -1));
    this.FBo.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120063);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.FBz.getOnActionClicked();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(0));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120063);
      }
    });
    this.FBp.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120064);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.FBz.getOnActionClicked();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(1));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120064);
      }
    });
    this.FBr.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120065);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryActionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.FBz.getOnActionClicked();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(0));
        }
        paramAnonymousView = h.FuH;
        h.aaT(8);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryActionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120065);
      }
    });
    AppMethodBeat.o(120079);
  }
  
  private final boolean abd(int paramInt)
  {
    return (!this.FBw) || (this.sTB != paramInt);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(120078);
    p.h(paramg, "comment");
    if (this.dJM)
    {
      paramg = paramg.FoQ;
      Object localObject1 = (Collection)paramg;
      if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject1 = this.FBp;
        Object localObject2 = ae.SYK;
        localObject2 = getContext();
        p.g(localObject2, "context");
        localObject2 = ((Context)localObject2).getResources().getString(2131766527);
        p.g(localObject2, "context.resources.getStr…tory_gallery_comment_tip)");
        paramg = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(paramg.size()) }, 1));
        p.g(paramg, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setText((CharSequence)paramg);
        AppMethodBeat.o(120078);
        return;
      }
      paramg = this.FBp;
      localObject1 = getContext();
      p.g(localObject1, "context");
      paramg.setText((CharSequence)((Context)localObject1).getResources().getString(2131766529));
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
        ((SpannableStringBuilder)localObject1).append((CharSequence)this.FBm).append((CharSequence)this.FBn);
        ((SpannableStringBuilder)localObject1).setSpan(this.FBx, ((SpannableStringBuilder)localObject1).length() - this.FBn.length(), ((SpannableStringBuilder)localObject1).length(), 33);
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
  
  public final kotlin.g.a.b<Integer, x> getOnActionClicked()
  {
    return this.FBy;
  }
  
  public final void setOnActionClicked(kotlin.g.a.b<? super Integer, x> paramb)
  {
    this.FBy = paramb;
  }
  
  public final void setup(g paramg)
  {
    AppMethodBeat.i(120077);
    p.h(paramg, "comment");
    this.FoU = paramg;
    Object localObject1 = j.Fmy;
    this.dJM = Util.isEqual(j.b.fau(), paramg.Foa);
    if (this.dJM)
    {
      Object localObject3 = paramg.FoS;
      paramg = paramg.FoQ;
      Object localObject2 = (Iterable)paramg;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = ((Iterator)localObject2).next();
        if (((com.tencent.mm.plugin.story.f.b.a)localObject4).FnW) {
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
        if (((com.tencent.mm.plugin.story.f.b.a)localObject5).FnW) {
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
        localObject4 = this.FBo;
        localObject5 = ae.SYK;
        localObject5 = getContext();
        p.g(localObject5, "context");
        localObject5 = ((Context)localObject5).getResources().getString(2131766524);
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
        localObject3 = this.FBp;
        localObject4 = ae.SYK;
        localObject4 = getContext();
        p.g(localObject4, "context");
        localObject4 = ((Context)localObject4).getResources().getString(2131766527);
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
        if ((i != 0) || (!abd(1))) {
          break label638;
        }
        a(true, this.FBp);
        label469:
        if (!((Collection)localObject2).isEmpty()) {
          break label650;
        }
        i = 1;
        label484:
        if ((i != 0) || (!abd(0))) {
          break label655;
        }
        a(true, this.FBo);
      }
      for (;;)
      {
        this.FBo.requestLayout();
        this.FBp.requestLayout();
        this.FBs.setVisibility(0);
        this.FBt.setVisibility(8);
        AppMethodBeat.o(120077);
        return;
        i = 0;
        break;
        label548:
        localObject3 = this.FBo;
        localObject4 = getContext();
        p.g(localObject4, "context");
        ((TextView)localObject3).setText((CharSequence)((Context)localObject4).getResources().getString(2131766526));
        break label322;
        label589:
        i = 0;
        break label345;
        label594:
        paramg = this.FBp;
        localObject3 = getContext();
        p.g(localObject3, "context");
        paramg.setText((CharSequence)((Context)localObject3).getResources().getString(2131766529));
        break label434;
        label633:
        i = 0;
        break label448;
        label638:
        a(false, this.FBp);
        break label469;
        label650:
        i = 0;
        break label484;
        label655:
        a(false, this.FBo);
      }
    }
    this.FBs.setVisibility(8);
    this.FBt.setVisibility(0);
    AppMethodBeat.o(120077);
  }
  
  final void w(TextView paramTextView)
  {
    AppMethodBeat.i(120073);
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofArgb(new int[] { paramTextView.getCurrentTextColor(), this.FBi });
    localValueAnimator1.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    localValueAnimator1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(paramTextView));
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofFloat(new float[] { paramTextView.getTextSize(), this.FBg });
    localValueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(paramTextView));
    paramTextView = new AnimatorSet();
    paramTextView.setDuration(150L);
    paramTextView.playTogether(new Animator[] { (Animator)localValueAnimator1, (Animator)localValueAnimator2 });
    paramTextView.start();
    AppMethodBeat.o(120073);
  }
  
  final void x(TextView paramTextView)
  {
    AppMethodBeat.i(120074);
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofArgb(new int[] { paramTextView.getCurrentTextColor(), this.FBj });
    localValueAnimator1.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    localValueAnimator1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new f(paramTextView));
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofFloat(new float[] { paramTextView.getTextSize(), this.FBh });
    localValueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new g(paramTextView));
    paramTextView = new AnimatorSet();
    paramTextView.setDuration(150L);
    paramTextView.playTogether(new Animator[] { (Animator)localValueAnimator1, (Animator)localValueAnimator2 });
    paramTextView.start();
    AppMethodBeat.o(120074);
  }
  
  final void y(TextView paramTextView)
  {
    AppMethodBeat.i(120075);
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofArgb(new int[] { paramTextView.getCurrentTextColor(), this.FBi });
    localValueAnimator1.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    localValueAnimator1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new d(paramTextView));
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofFloat(new float[] { paramTextView.getTextSize(), this.FBh });
    localValueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new e(paramTextView));
    paramTextView = new AnimatorSet();
    paramTextView.setDuration(150L);
    paramTextView.playTogether(new Animator[] { (Animator)localValueAnimator1, (Animator)localValueAnimator2 });
    paramTextView.start();
    AppMethodBeat.o(120075);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(TextView paramTextView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(120067);
      TextView localTextView = this.hUM;
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(120067);
        throw paramValueAnimator;
      }
      localTextView.setTextColor(((Integer)paramValueAnimator).intValue());
      AppMethodBeat.o(120067);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(TextView paramTextView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(120068);
      TextView localTextView = this.hUM;
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(120068);
        throw paramValueAnimator;
      }
      localTextView.setTextSize(0, ((Float)paramValueAnimator).floatValue());
      AppMethodBeat.o(120068);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class d
    implements ValueAnimator.AnimatorUpdateListener
  {
    d(TextView paramTextView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(120069);
      TextView localTextView = this.hUM;
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(120069);
        throw paramValueAnimator;
      }
      localTextView.setTextColor(((Integer)paramValueAnimator).intValue());
      AppMethodBeat.o(120069);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(TextView paramTextView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(120070);
      TextView localTextView = this.hUM;
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(120070);
        throw paramValueAnimator;
      }
      localTextView.setTextSize(0, ((Float)paramValueAnimator).floatValue());
      AppMethodBeat.o(120070);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    f(TextView paramTextView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(120071);
      TextView localTextView = this.hUM;
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(120071);
        throw paramValueAnimator;
      }
      localTextView.setTextColor(((Integer)paramValueAnimator).intValue());
      AppMethodBeat.o(120071);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class g
    implements ValueAnimator.AnimatorUpdateListener
  {
    g(TextView paramTextView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(120072);
      TextView localTextView = this.hUM;
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(120072);
        throw paramValueAnimator;
      }
      localTextView.setTextSize(0, ((Float)paramValueAnimator).floatValue());
      AppMethodBeat.o(120072);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryActionView
 * JD-Core Version:    0.7.0.1
 */