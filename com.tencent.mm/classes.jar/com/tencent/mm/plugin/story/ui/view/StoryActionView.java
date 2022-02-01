package com.tencent.mm.plugin.story.ui.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
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
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.d.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/StoryActionView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SCROLL_DIRECTION_L2R", "SCROLL_DIRECTION_R2L", "TAG", "", "TEXT_MAX_COLOR", "TEXT_MAX_SIZE", "", "TEXT_MIN_COLOR", "TEXT_MIN_SIZE", "TIP_ICON_REPLACE", "TIP_ICON_SPACE", "comment", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "commentOtherView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentBubbleView;", "commentTipTv", "Landroid/widget/TextView;", "curIndex", "isOpenList", "", "isSelf", "lastOffset", "likeTipTv", "onActionClicked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getOnActionClicked", "()Lkotlin/jvm/functions/Function1;", "setOnActionClicked", "(Lkotlin/jvm/functions/Function1;)V", "otherGroup", "Landroid/view/View;", "readyAnimation", "scrollDirection", "scrollState", "selfGroup", "tipGroup", "Landroid/widget/LinearLayout;", "tipSpan", "Lcom/tencent/mm/plugin/story/ui/view/StoryActionView$StoryTipImageSpan;", "animateToFocus", "textView", "animateToNormal", "animateToUnfocus", "needTipIcon", "tipIndex", "onMsgClosed", "onMsgOpened", "onPageChanged", "onPageChangedState", "state", "onPageChanging", "offset", "p2", "setup", "showTipIcon", "show", "view", "upadteComment", "StoryTipImageSpan", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryActionView
  extends RelativeLayout
{
  int RCV;
  private g Sms;
  private final float Sxe;
  private final float Sxf;
  private final int Sxg;
  private final int Sxh;
  private final int Sxi;
  private final int Sxj;
  private final String Sxk;
  private final String Sxl;
  final TextView Sxm;
  final TextView Sxn;
  private final LinearLayout Sxo;
  private final StoryCommentBubbleView Sxp;
  private final View Sxq;
  private final View Sxr;
  boolean Sxs;
  float Sxt;
  private boolean Sxu;
  private final StoryActionView.a Sxv;
  private kotlin.g.a.b<? super Integer, ah> Sxw;
  final String TAG;
  int dyP;
  boolean hHq;
  int zVI;
  
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
    this.Sxe = bd.fromDPToPix(paramContext, 17);
    this.Sxf = bd.fromDPToPix(paramContext, 14);
    this.Sxg = Color.parseColor("#FFFFFFFF");
    this.Sxh = Color.parseColor("#7FFFFFFF");
    this.Sxj = 1;
    this.Sxk = "  ";
    this.Sxl = " ";
    this.Sxt = -1.0F;
    this.RCV = -1;
    View.inflate(paramContext, a.e.Sgf, (ViewGroup)this);
    paramAttributeSet = findViewById(a.d.SdP);
    s.s(paramAttributeSet, "findViewById(R.id.story_action_like_tip_tv)");
    this.Sxm = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.SdN);
    s.s(paramAttributeSet, "findViewById(R.id.story_action_comment_tip_tv)");
    this.Sxn = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.SeO);
    s.s(paramAttributeSet, "findViewById(R.id.story_…ment_others_comment_icon)");
    this.Sxp = ((StoryCommentBubbleView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.SdR);
    s.s(paramAttributeSet, "findViewById(R.id.story_action_self)");
    this.Sxq = paramAttributeSet;
    paramAttributeSet = findViewById(a.d.SdQ);
    s.s(paramAttributeSet, "findViewById(R.id.story_action_other)");
    this.Sxr = paramAttributeSet;
    paramAttributeSet = findViewById(a.d.SdO);
    s.s(paramAttributeSet, "findViewById(R.id.story_action_like_tip_group)");
    this.Sxo = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.SeP);
    s.s(paramAttributeSet, "findViewById(R.id.story_comment_others_comment_tv)");
    d.h((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.getResources().getDrawable(a.c.Sda);
    paramAttributeSet.setBounds(0, 0, bd.fromDPToPix(paramContext, 8), bd.fromDPToPix(paramContext, 8));
    s.s(paramAttributeSet, "drawable");
    this.Sxv = new StoryActionView.a(paramAttributeSet);
    paramAttributeSet = this.Sxo.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).topMargin = bd.fromDPToPix(paramContext, 48);
    paramAttributeSet = this.Sxo.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).bottomMargin = (bd.fromDPToPix(paramContext, 48) + bf.bk(paramContext));
    paramAttributeSet = this.Sxr.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).topMargin = bd.fromDPToPix(paramContext, 48);
    paramAttributeSet = this.Sxr.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120079);
      throw paramContext;
    }
    ((ViewGroup.MarginLayoutParams)paramAttributeSet).bottomMargin = (bd.fromDPToPix(paramContext, 48) + bf.bk(paramContext));
    this.Sxp.setImageDrawable(bb.m(paramContext, a.f.icons_filled_chats, -1));
    this.Sxm.setOnClickListener(new StoryActionView..ExternalSyntheticLambda8(this));
    this.Sxn.setOnClickListener(new StoryActionView..ExternalSyntheticLambda7(this));
    this.Sxp.setOnClickListener(new StoryActionView..ExternalSyntheticLambda6(this));
    AppMethodBeat.o(120079);
  }
  
  private final void H(TextView paramTextView)
  {
    AppMethodBeat.i(120073);
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofArgb(new int[] { paramTextView.getCurrentTextColor(), this.Sxg });
    localValueAnimator1.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    localValueAnimator1.addUpdateListener(new StoryActionView..ExternalSyntheticLambda1(paramTextView));
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofFloat(new float[] { paramTextView.getTextSize(), this.Sxe });
    localValueAnimator2.addUpdateListener(new StoryActionView..ExternalSyntheticLambda3(paramTextView));
    paramTextView = new AnimatorSet();
    paramTextView.setDuration(150L);
    paramTextView.playTogether(new Animator[] { (Animator)localValueAnimator1, (Animator)localValueAnimator2 });
    paramTextView.start();
    AppMethodBeat.o(120073);
  }
  
  private final void I(TextView paramTextView)
  {
    AppMethodBeat.i(120074);
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofArgb(new int[] { paramTextView.getCurrentTextColor(), this.Sxh });
    localValueAnimator1.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    localValueAnimator1.addUpdateListener(new StoryActionView..ExternalSyntheticLambda2(paramTextView));
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofFloat(new float[] { paramTextView.getTextSize(), this.Sxf });
    localValueAnimator2.addUpdateListener(new StoryActionView..ExternalSyntheticLambda0(paramTextView));
    paramTextView = new AnimatorSet();
    paramTextView.setDuration(150L);
    paramTextView.playTogether(new Animator[] { (Animator)localValueAnimator1, (Animator)localValueAnimator2 });
    paramTextView.start();
    AppMethodBeat.o(120074);
  }
  
  private final void J(TextView paramTextView)
  {
    AppMethodBeat.i(120075);
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofArgb(new int[] { paramTextView.getCurrentTextColor(), this.Sxg });
    localValueAnimator1.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    localValueAnimator1.addUpdateListener(new StoryActionView..ExternalSyntheticLambda4(paramTextView));
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofFloat(new float[] { paramTextView.getTextSize(), this.Sxf });
    localValueAnimator2.addUpdateListener(new StoryActionView..ExternalSyntheticLambda5(paramTextView));
    paramTextView = new AnimatorSet();
    paramTextView.setDuration(150L);
    paramTextView.playTogether(new Animator[] { (Animator)localValueAnimator1, (Animator)localValueAnimator2 });
    paramTextView.start();
    AppMethodBeat.o(120075);
  }
  
  private static final void a(TextView paramTextView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(367599);
    s.u(paramTextView, "$textView");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramTextView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(367599);
      throw paramTextView;
    }
    paramTextView.setTextColor(((Integer)paramValueAnimator).intValue());
    AppMethodBeat.o(367599);
  }
  
  private static final void a(StoryActionView paramStoryActionView, View paramView)
  {
    AppMethodBeat.i(367592);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramStoryActionView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryActionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStoryActionView, "this$0");
    paramStoryActionView = paramStoryActionView.getOnActionClicked();
    if (paramStoryActionView != null) {
      paramStoryActionView.invoke(Integer.valueOf(0));
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/StoryActionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367592);
  }
  
  private final boolean anx(int paramInt)
  {
    return (!this.Sxu) || (this.zVI != paramInt);
  }
  
  private static final void b(TextView paramTextView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(367602);
    s.u(paramTextView, "$textView");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramTextView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(367602);
      throw paramTextView;
    }
    paramTextView.setTextSize(0, ((Float)paramValueAnimator).floatValue());
    AppMethodBeat.o(367602);
  }
  
  private static final void b(StoryActionView paramStoryActionView, View paramView)
  {
    AppMethodBeat.i(367594);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramStoryActionView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryActionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStoryActionView, "this$0");
    paramStoryActionView = paramStoryActionView.getOnActionClicked();
    if (paramStoryActionView != null) {
      paramStoryActionView.invoke(Integer.valueOf(1));
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/StoryActionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367594);
  }
  
  private static final void c(TextView paramTextView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(367604);
    s.u(paramTextView, "$textView");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramTextView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(367604);
      throw paramTextView;
    }
    paramTextView.setTextColor(((Integer)paramValueAnimator).intValue());
    AppMethodBeat.o(367604);
  }
  
  private static final void c(StoryActionView paramStoryActionView, View paramView)
  {
    AppMethodBeat.i(367597);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramStoryActionView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryActionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStoryActionView, "this$0");
    paramStoryActionView = paramStoryActionView.getOnActionClicked();
    if (paramStoryActionView != null) {
      paramStoryActionView.invoke(Integer.valueOf(0));
    }
    paramStoryActionView = h.SqZ;
    h.ano(8);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/StoryActionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367597);
  }
  
  private static final void d(TextView paramTextView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(367605);
    s.u(paramTextView, "$textView");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramTextView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(367605);
      throw paramTextView;
    }
    paramTextView.setTextSize(0, ((Float)paramValueAnimator).floatValue());
    AppMethodBeat.o(367605);
  }
  
  private static final void e(TextView paramTextView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(367606);
    s.u(paramTextView, "$textView");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramTextView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(367606);
      throw paramTextView;
    }
    paramTextView.setTextColor(((Integer)paramValueAnimator).intValue());
    AppMethodBeat.o(367606);
  }
  
  private static final void f(TextView paramTextView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(367608);
    s.u(paramTextView, "$textView");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramTextView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(367608);
      throw paramTextView;
    }
    paramTextView.setTextSize(0, ((Float)paramValueAnimator).floatValue());
    AppMethodBeat.o(367608);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(120078);
    s.u(paramg, "comment");
    if (this.hHq)
    {
      paramg = paramg.PmC;
      Object localObject1 = (Collection)paramg;
      if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject1 = this.Sxn;
        Object localObject2 = am.aixg;
        localObject2 = getContext().getResources().getString(a.g.ShM);
        s.s(localObject2, "context.resources.getStr…tory_gallery_comment_tip)");
        paramg = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(paramg.size()) }, 1));
        s.s(paramg, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setText((CharSequence)paramg);
        AppMethodBeat.o(120078);
        return;
      }
      this.Sxn.setText((CharSequence)getContext().getResources().getString(a.g.ShO));
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
        ((SpannableStringBuilder)localObject1).append((CharSequence)this.Sxk).append((CharSequence)this.Sxl);
        ((SpannableStringBuilder)localObject1).setSpan(this.Sxv, ((SpannableStringBuilder)localObject1).length() - this.Sxl.length(), ((SpannableStringBuilder)localObject1).length(), 33);
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
        paramTextView.setText(n.bq((CharSequence)localObject1));
      }
      AppMethodBeat.o(120076);
      return;
      i = 0;
      break;
    }
  }
  
  public final void any(int paramInt)
  {
    AppMethodBeat.i(367680);
    this.Sxu = true;
    this.zVI = paramInt;
    if (this.hHq)
    {
      this.Sxm.setBackground(null);
      this.Sxn.setBackground(null);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(367680);
        return;
        H(this.Sxm);
        I(this.Sxn);
        a(false, this.Sxm);
        AppMethodBeat.o(367680);
        return;
        H(this.Sxn);
        I(this.Sxm);
        a(false, this.Sxn);
      }
    }
    this.Sxr.setVisibility(8);
    AppMethodBeat.o(367680);
  }
  
  public final void e(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(367668);
    Log.d(this.TAG, "curIndex:" + paramInt1 + " offset:" + paramFloat + " p2:" + paramInt2 + " readyAnimation:" + this.Sxs + " scrollDirection:" + this.RCV + " lastOffset:" + this.Sxt);
    if (this.hHq)
    {
      if ((this.dyP == 1) && (paramInt1 == 0))
      {
        paramInt1 = this.Sxg >>> 24;
        paramInt2 = this.Sxh >>> 24;
        float f2 = Math.max(Math.min(paramFloat, 1.0F), 0.0F);
        int i = Math.max(Math.min((int)(paramInt1 - (paramInt1 - paramInt2) * f2), paramInt1), paramInt2) << 24 | 0xFFFFFF;
        int j = Math.max(Math.min((int)(paramInt2 + (paramInt1 - paramInt2) * f2), paramInt1), paramInt2) << 24 | 0xFFFFFF;
        float f1 = Math.max(Math.min(this.Sxe - (this.Sxe - this.Sxf) * f2, this.Sxe), this.Sxf);
        float f3 = this.Sxf;
        f2 = Math.max(Math.min(f2 * (this.Sxe - this.Sxf) + f3, this.Sxe), this.Sxf);
        Log.d(this.TAG, "outOffset:" + (i - paramInt1) + "  inOffset:" + (j - paramInt2));
        this.Sxm.setTextColor(i);
        this.Sxm.setTextSize(0, f1);
        this.Sxn.setTextColor(j);
        this.Sxn.setTextSize(0, f2);
      }
      if (this.Sxt <= paramFloat) {
        break label438;
      }
      this.RCV = this.Sxj;
      label390:
      if (this.Sxs)
      {
        if (this.Sxt != -1.0F) {
          break label458;
        }
        paramInt1 = 1;
        label375:
        if (paramInt1 == 0)
        {
          if (this.Sxt != 0.0F) {
            break label463;
          }
          paramInt1 = 1;
          if (paramInt1 == 0)
          {
            this.Sxs = false;
            if (this.RCV != this.Sxi) {
              break label468;
            }
            H(this.Sxn);
            I(this.Sxm);
          }
        }
      }
    }
    for (;;)
    {
      this.Sxt = paramFloat;
      AppMethodBeat.o(367668);
      return;
      label438:
      if (this.Sxt >= paramFloat) {
        break;
      }
      this.RCV = this.Sxi;
      break;
      label458:
      paramInt1 = 0;
      break label375;
      label463:
      paramInt1 = 0;
      break label390;
      label468:
      if (this.RCV == this.Sxj)
      {
        H(this.Sxm);
        I(this.Sxn);
      }
    }
  }
  
  public final kotlin.g.a.b<Integer, ah> getOnActionClicked()
  {
    return this.Sxw;
  }
  
  public final void hzN()
  {
    AppMethodBeat.i(367674);
    this.Sxu = false;
    if (this.hHq)
    {
      this.Sxm.setBackground(getResources().getDrawable(a.c.ScX));
      this.Sxn.setBackground(getResources().getDrawable(a.c.ScX));
      g localg = this.Sms;
      int i;
      if ((localg != null) && (localg.Smj == true))
      {
        i = 1;
        if (i == 0) {
          break label144;
        }
        a(true, this.Sxn);
        label84:
        localg = this.Sms;
        if ((localg == null) || (localg.Smi != true)) {
          break label156;
        }
        i = 1;
        label103:
        if (i == 0) {
          break label161;
        }
        a(true, this.Sxm);
      }
      for (;;)
      {
        J(this.Sxm);
        J(this.Sxn);
        AppMethodBeat.o(367674);
        return;
        i = 0;
        break;
        label144:
        a(false, this.Sxn);
        break label84;
        label156:
        i = 0;
        break label103;
        label161:
        a(false, this.Sxm);
      }
    }
    this.Sxr.setVisibility(0);
    AppMethodBeat.o(367674);
  }
  
  public final void setOnActionClicked(kotlin.g.a.b<? super Integer, ah> paramb)
  {
    this.Sxw = paramb;
  }
  
  public final void setup(g paramg)
  {
    AppMethodBeat.i(120077);
    s.u(paramg, "comment");
    this.Sms = paramg;
    Object localObject1 = StoryCore.SjP;
    this.hHq = Util.isEqual(StoryCore.b.hgg(), paramg.SlC);
    if (this.hHq)
    {
      Object localObject2 = paramg.Smm;
      paramg = paramg.PmC;
      Object localObject3 = (Iterable)paramg;
      localObject1 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        if (((com.tencent.mm.plugin.story.model.b.a)localObject4).Sly) {
          ((Collection)localObject1).add(localObject4);
        }
      }
      localObject1 = (List)localObject1;
      Object localObject4 = (Iterable)localObject2;
      localObject3 = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      Object localObject5;
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((Iterator)localObject4).next();
        if (((com.tencent.mm.plugin.story.model.b.a)localObject5).Sly) {
          ((Collection)localObject3).add(localObject5);
        }
      }
      localObject3 = (List)localObject3;
      localObject4 = (Collection)localObject2;
      int i;
      if ((localObject4 == null) || (((Collection)localObject4).isEmpty()))
      {
        i = 1;
        if (i != 0) {
          break label526;
        }
        localObject4 = this.Sxm;
        localObject5 = am.aixg;
        localObject5 = getContext().getResources().getString(a.g.ShJ);
        s.s(localObject5, "context.resources.getStr…story_gallery_bubble_tip)");
        localObject2 = String.format((String)localObject5, Arrays.copyOf(new Object[] { Integer.valueOf(((LinkedList)localObject2).size()) }, 1));
        s.s(localObject2, "java.lang.String.format(format, *args)");
        ((TextView)localObject4).setText((CharSequence)localObject2);
        label311:
        localObject2 = (Collection)paramg;
        if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
          break label552;
        }
        i = 1;
        label334:
        if (i != 0) {
          break label557;
        }
        localObject2 = this.Sxn;
        localObject4 = am.aixg;
        localObject4 = getContext().getResources().getString(a.g.ShM);
        s.s(localObject4, "context.resources.getStr…tory_gallery_comment_tip)");
        paramg = String.format((String)localObject4, Arrays.copyOf(new Object[] { Integer.valueOf(paramg.size()) }, 1));
        s.s(paramg, "java.lang.String.format(format, *args)");
        ((TextView)localObject2).setText((CharSequence)paramg);
        label412:
        if (!((Collection)localObject1).isEmpty()) {
          break label583;
        }
        i = 1;
        label426:
        if ((i != 0) || (!anx(1))) {
          break label588;
        }
        a(true, this.Sxn);
        label447:
        if (!((Collection)localObject3).isEmpty()) {
          break label600;
        }
        i = 1;
        label462:
        if ((i != 0) || (!anx(0))) {
          break label605;
        }
        a(true, this.Sxm);
      }
      for (;;)
      {
        this.Sxm.requestLayout();
        this.Sxn.requestLayout();
        this.Sxq.setVisibility(0);
        this.Sxr.setVisibility(8);
        AppMethodBeat.o(120077);
        return;
        i = 0;
        break;
        label526:
        this.Sxm.setText((CharSequence)getContext().getResources().getString(a.g.ShL));
        break label311;
        label552:
        i = 0;
        break label334;
        label557:
        this.Sxn.setText((CharSequence)getContext().getResources().getString(a.g.ShO));
        break label412;
        label583:
        i = 0;
        break label426;
        label588:
        a(false, this.Sxn);
        break label447;
        label600:
        i = 0;
        break label462;
        label605:
        a(false, this.Sxm);
      }
    }
    this.Sxq.setVisibility(8);
    this.Sxr.setVisibility(0);
    AppMethodBeat.o(120077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryActionView
 * JD-Core Version:    0.7.0.1
 */