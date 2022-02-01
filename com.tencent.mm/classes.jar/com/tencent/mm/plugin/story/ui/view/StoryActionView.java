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
import com.tencent.mm.plugin.story.f.b.a;
import com.tencent.mm.plugin.story.f.d.g;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import d.g.a.b;
import d.g.b.k;
import d.g.b.z;
import d.l;
import d.n.n;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/StoryActionView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SCROLL_DIRECTION_L2R", "SCROLL_DIRECTION_R2L", "TAG", "", "TEXT_MAX_COLOR", "TEXT_MAX_SIZE", "", "TEXT_MIN_COLOR", "TEXT_MIN_SIZE", "TIP_ICON_REPLACE", "TIP_ICON_SPACE", "comment", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "commentOtherView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentBubbleView;", "commentTipTv", "Landroid/widget/TextView;", "curIndex", "isOpenList", "", "isSelf", "lastOffset", "likeTipTv", "onActionClicked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getOnActionClicked", "()Lkotlin/jvm/functions/Function1;", "setOnActionClicked", "(Lkotlin/jvm/functions/Function1;)V", "otherGroup", "Landroid/view/View;", "readyAnimation", "scrollDirection", "scrollState", "selfGroup", "tipGroup", "Landroid/widget/LinearLayout;", "tipSpan", "Lcom/tencent/mm/plugin/story/ui/view/StoryActionView$StoryTipImageSpan;", "animateToFocus", "textView", "animateToNormal", "animateToUnfocus", "needTipIcon", "tipIndex", "onMsgClosed", "onMsgOpened", "onPageChanged", "onPageChangedState", "state", "onPageChanging", "offset", "p2", "setup", "showTipIcon", "show", "view", "upadteComment", "StoryTipImageSpan", "plugin-story_release"})
public final class StoryActionView
  extends RelativeLayout
{
  final String TAG;
  boolean diE;
  int goS;
  int sq;
  int xJB;
  g yhG;
  final float yuc;
  final float yud;
  final int yue;
  final int yuf;
  final int yug;
  final int yuh;
  private final String yui;
  private final String yuj;
  final TextView yuk;
  final TextView yul;
  private final LinearLayout yum;
  private final StoryCommentBubbleView yun;
  private final View yuo;
  final View yup;
  boolean yuq;
  float yur;
  boolean yus;
  private final StoryActionView.a yut;
  private b<? super Integer, y> yuu;
  
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
    this.yuc = ao.fromDPToPix(paramContext, 17);
    this.yud = ao.fromDPToPix(paramContext, 14);
    this.yue = Color.parseColor("#FFFFFFFF");
    this.yuf = Color.parseColor("#7FFFFFFF");
    this.yuh = 1;
    this.yui = "  ";
    this.yuj = " ";
    this.yur = -1.0F;
    this.xJB = -1;
    View.inflate(paramContext, 2131495646, (ViewGroup)this);
    paramAttributeSet = findViewById(2131305247);
    k.g(paramAttributeSet, "findViewById(R.id.story_action_like_tip_tv)");
    this.yuk = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305245);
    k.g(paramAttributeSet, "findViewById(R.id.story_action_comment_tip_tv)");
    this.yul = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305323);
    k.g(paramAttributeSet, "findViewById(R.id.story_…ment_others_comment_icon)");
    this.yun = ((StoryCommentBubbleView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305249);
    k.g(paramAttributeSet, "findViewById(R.id.story_action_self)");
    this.yuo = paramAttributeSet;
    paramAttributeSet = findViewById(2131305248);
    k.g(paramAttributeSet, "findViewById(R.id.story_action_other)");
    this.yup = paramAttributeSet;
    paramAttributeSet = findViewById(2131305246);
    k.g(paramAttributeSet, "findViewById(R.id.story_action_like_tip_group)");
    this.yum = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131305324);
    k.g(paramAttributeSet, "findViewById(R.id.story_comment_others_comment_tv)");
    c.e((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.getResources().getDrawable(2131234267);
    paramAttributeSet.setBounds(0, 0, ao.fromDPToPix(paramContext, 8), ao.fromDPToPix(paramContext, 8));
    k.g(paramAttributeSet, "drawable");
    this.yut = new StoryActionView.a(paramAttributeSet);
    paramAttributeSet = this.yum.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).topMargin = ao.fromDPToPix(paramContext, 48);
    paramAttributeSet = this.yum.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).bottomMargin = (ao.fromDPToPix(paramContext, 48) + ap.eb(paramContext));
    paramAttributeSet = this.yup.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).topMargin = ao.fromDPToPix(paramContext, 48);
    paramAttributeSet = this.yup.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).bottomMargin = (ao.fromDPToPix(paramContext, 48) + ap.eb(paramContext));
    this.yun.setImageDrawable(am.i(paramContext, 2131690368, -1));
    this.yuk.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120063);
        paramAnonymousView = this.yuv.getOnActionClicked();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.aA(Integer.valueOf(0));
          AppMethodBeat.o(120063);
          return;
        }
        AppMethodBeat.o(120063);
      }
    });
    this.yul.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120064);
        paramAnonymousView = this.yuv.getOnActionClicked();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.aA(Integer.valueOf(1));
          AppMethodBeat.o(120064);
          return;
        }
        AppMethodBeat.o(120064);
      }
    });
    this.yun.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120065);
        paramAnonymousView = this.yuv.getOnActionClicked();
        if (paramAnonymousView != null) {
          paramAnonymousView.aA(Integer.valueOf(0));
        }
        paramAnonymousView = h.ynv;
        h.OB(8);
        AppMethodBeat.o(120065);
      }
    });
    AppMethodBeat.o(120079);
  }
  
  private final boolean OL(int paramInt)
  {
    return (!this.yus) || (this.goS != paramInt);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(120078);
    k.h(paramg, "comment");
    if (this.diE)
    {
      paramg = paramg.yhC;
      Object localObject1 = (Collection)paramg;
      if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject1 = this.yul;
        Object localObject2 = z.Jhz;
        localObject2 = getContext();
        k.g(localObject2, "context");
        localObject2 = ((Context)localObject2).getResources().getString(2131764269);
        k.g(localObject2, "context.resources.getStr…tory_gallery_comment_tip)");
        paramg = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(paramg.size()) }, 1));
        k.g(paramg, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setText((CharSequence)paramg);
        AppMethodBeat.o(120078);
        return;
      }
      paramg = this.yul;
      localObject1 = getContext();
      k.g(localObject1, "context");
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
        ((SpannableStringBuilder)localObject1).append((CharSequence)this.yui).append((CharSequence)this.yuj);
        ((SpannableStringBuilder)localObject1).setSpan(this.yut, ((SpannableStringBuilder)localObject1).length() - this.yuj.length(), ((SpannableStringBuilder)localObject1).length(), 33);
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
  
  public final b<Integer, y> getOnActionClicked()
  {
    return this.yuu;
  }
  
  final void q(TextView paramTextView)
  {
    AppMethodBeat.i(120073);
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofArgb(new int[] { paramTextView.getCurrentTextColor(), this.yue });
    localValueAnimator1.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    localValueAnimator1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.b(paramTextView));
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofFloat(new float[] { paramTextView.getTextSize(), this.yuc });
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
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofArgb(new int[] { paramTextView.getCurrentTextColor(), this.yuf });
    localValueAnimator1.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    localValueAnimator1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.f(paramTextView));
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofFloat(new float[] { paramTextView.getTextSize(), this.yud });
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
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofArgb(new int[] { paramTextView.getCurrentTextColor(), this.yue });
    localValueAnimator1.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    localValueAnimator1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.d(paramTextView));
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofFloat(new float[] { paramTextView.getTextSize(), this.yud });
    localValueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new StoryActionView.e(paramTextView));
    paramTextView = new AnimatorSet();
    paramTextView.setDuration(150L);
    paramTextView.playTogether(new Animator[] { (Animator)localValueAnimator1, (Animator)localValueAnimator2 });
    paramTextView.start();
    AppMethodBeat.o(120075);
  }
  
  public final void setOnActionClicked(b<? super Integer, y> paramb)
  {
    this.yuu = paramb;
  }
  
  public final void setup(g paramg)
  {
    AppMethodBeat.i(120077);
    k.h(paramg, "comment");
    this.yhG = paramg;
    Object localObject1 = j.yfh;
    this.diE = bt.kU(j.b.dta(), paramg.ygM);
    if (this.diE)
    {
      Object localObject3 = paramg.yhE;
      paramg = paramg.yhC;
      Object localObject2 = (Iterable)paramg;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = ((Iterator)localObject2).next();
        if (((a)localObject4).ygI) {
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
        if (((a)localObject5).ygI) {
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
        localObject4 = this.yuk;
        localObject5 = z.Jhz;
        localObject5 = getContext();
        k.g(localObject5, "context");
        localObject5 = ((Context)localObject5).getResources().getString(2131764266);
        k.g(localObject5, "context.resources.getStr…story_gallery_bubble_tip)");
        localObject3 = String.format((String)localObject5, Arrays.copyOf(new Object[] { Integer.valueOf(((LinkedList)localObject3).size()) }, 1));
        k.g(localObject3, "java.lang.String.format(format, *args)");
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
        localObject3 = this.yul;
        localObject4 = z.Jhz;
        localObject4 = getContext();
        k.g(localObject4, "context");
        localObject4 = ((Context)localObject4).getResources().getString(2131764269);
        k.g(localObject4, "context.resources.getStr…tory_gallery_comment_tip)");
        paramg = String.format((String)localObject4, Arrays.copyOf(new Object[] { Integer.valueOf(paramg.size()) }, 1));
        k.g(paramg, "java.lang.String.format(format, *args)");
        ((TextView)localObject3).setText((CharSequence)paramg);
        label434:
        if (!((Collection)localObject1).isEmpty()) {
          break label633;
        }
        i = 1;
        label448:
        if ((i != 0) || (!OL(1))) {
          break label638;
        }
        a(true, this.yul);
        label469:
        if (!((Collection)localObject2).isEmpty()) {
          break label650;
        }
        i = 1;
        label484:
        if ((i != 0) || (!OL(0))) {
          break label655;
        }
        a(true, this.yuk);
      }
      for (;;)
      {
        this.yuk.requestLayout();
        this.yul.requestLayout();
        this.yuo.setVisibility(0);
        this.yup.setVisibility(8);
        AppMethodBeat.o(120077);
        return;
        i = 0;
        break;
        label548:
        localObject3 = this.yuk;
        localObject4 = getContext();
        k.g(localObject4, "context");
        ((TextView)localObject3).setText((CharSequence)((Context)localObject4).getResources().getString(2131764268));
        break label322;
        label589:
        i = 0;
        break label345;
        label594:
        paramg = this.yul;
        localObject3 = getContext();
        k.g(localObject3, "context");
        paramg.setText((CharSequence)((Context)localObject3).getResources().getString(2131764271));
        break label434;
        label633:
        i = 0;
        break label448;
        label638:
        a(false, this.yul);
        break label469;
        label650:
        i = 0;
        break label484;
        label655:
        a(false, this.yuk);
      }
    }
    this.yuo.setVisibility(8);
    this.yup.setVisibility(0);
    AppMethodBeat.o(120077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryActionView
 * JD-Core Version:    0.7.0.1
 */