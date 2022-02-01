package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.story.a.a;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/CommentsContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "currIndex", "isPause", "", "()Z", "setPause", "(Z)V", "isUnread", "setUnread", "itemClickListener", "Lkotlin/Function0;", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "nextItemDelay", "", "nextItemDuration", "nextRunnable", "Ljava/lang/Runnable;", "onLoop", "getOnLoop", "setOnLoop", "onLoopRunnable", "random", "Ljava/util/Random;", "animNext", "createDrawable", "Landroid/graphics/drawable/GradientDrawable;", "comment", "getItemView", "Lcom/tencent/mm/plugin/story/ui/view/CommentItemView;", "nextDelay", "nextDuration", "pause", "restart", "resume", "shakeIndex", "index", "update", "storyComments", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CommentsContainer
  extends RelativeLayout
{
  private int NZy;
  private boolean Sly;
  private final ArrayList<com.tencent.mm.plugin.story.model.b.a> StI;
  private long SwW;
  private long SwX;
  private kotlin.g.a.a<ah> SwY;
  private final Runnable SwZ;
  private final Runnable Sxa;
  private final String TAG;
  public boolean hJi;
  private kotlin.g.a.a<ah> noh;
  private Random random;
  
  public CommentsContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(120059);
    AppMethodBeat.o(120059);
  }
  
  public CommentsContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120058);
    this.TAG = "MicroMsg.CommentsContainer";
    this.StI = new ArrayList();
    this.NZy = -1;
    this.random = new Random();
    this.hJi = true;
    this.SwZ = new CommentsContainer..ExternalSyntheticLambda3(this);
    this.Sxa = new CommentsContainer..ExternalSyntheticLambda2(this);
    AppMethodBeat.o(120058);
  }
  
  private static final void a(final CommentItemView paramCommentItemView, CommentsContainer paramCommentsContainer, final com.tencent.mm.plugin.story.model.b.a parama, int paramInt)
  {
    AppMethodBeat.i(367432);
    s.u(paramCommentItemView, "$itemView");
    s.u(paramCommentsContainer, "this$0");
    s.u(parama, "$comment");
    View localView = paramCommentItemView.getMaskView();
    Object localObject = paramCommentsContainer.getContext();
    s.s(localObject, "context");
    int j = ((Context)localObject).getResources().getColor(a.a.Indigo);
    int i = ((Context)localObject).getResources().getColor(a.a.ScO);
    if (paramCommentsContainer.Sly) {
      i = j;
    }
    float f = com.tencent.mm.cd.a.fromDPToPix((Context)localObject, 24);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(i);
    ((GradientDrawable)localObject).setCornerRadius(f);
    localView.setBackground((Drawable)localObject);
    paramCommentItemView.setVisibility(0);
    i = paramCommentItemView.getMeasuredHeight();
    j = paramCommentsContainer.getPaddingBottom();
    paramCommentsContainer.SwX = (com.tencent.mm.cd.a.K(paramCommentsContainer.getContext(), paramInt - j) * 9L);
    if (paramCommentsContainer.SwX <= 0L) {
      paramCommentsContainer.SwX = 4000L;
    }
    paramCommentItemView.a(paramCommentsContainer.SwX, paramCommentsContainer.getPaddingBottom(), paramInt - i / 2, (kotlin.g.a.a)new a(paramCommentsContainer, parama, paramCommentItemView), (kotlin.g.a.a)new b(paramCommentsContainer, paramCommentItemView));
    paramCommentsContainer.SwW = ((com.tencent.mm.cd.a.K(paramCommentsContainer.getContext(), i) + 96) * 6L);
    if (paramCommentsContainer.NZy == paramCommentsContainer.StI.size() - 1)
    {
      paramCommentsContainer.SwW = paramCommentsContainer.SwX;
      paramCommentsContainer.postDelayed(paramCommentsContainer.Sxa, paramCommentsContainer.SwW);
    }
    paramCommentsContainer.postDelayed(paramCommentsContainer.SwZ, paramCommentsContainer.SwW);
    AppMethodBeat.o(367432);
  }
  
  private static final void a(CommentsContainer paramCommentsContainer)
  {
    AppMethodBeat.i(367426);
    s.u(paramCommentsContainer, "this$0");
    Log.i(paramCommentsContainer.TAG, "LogStory: animNext " + paramCommentsContainer.NZy + ' ' + paramCommentsContainer.hJi + ' ' + paramCommentsContainer.StI.size());
    if ((paramCommentsContainer.hJi) || (paramCommentsContainer.StI.size() <= 0))
    {
      AppMethodBeat.o(367426);
      return;
    }
    paramCommentsContainer.NZy += 1;
    paramCommentsContainer.NZy %= paramCommentsContainer.StI.size();
    int j = paramCommentsContainer.NZy;
    Object localObject1 = paramCommentsContainer.StI.get(j);
    s.s(localObject1, "comments[itemIndex]");
    com.tencent.mm.plugin.story.model.b.a locala = (com.tencent.mm.plugin.story.model.b.a)localObject1;
    localObject1 = LayoutInflater.from(paramCommentsContainer.getContext());
    View localView;
    TextView localTextView2;
    Object localObject3;
    if (locala.Slz)
    {
      i = a.e.Sgx;
      localView = ((LayoutInflater)localObject1).inflate(i, (ViewGroup)paramCommentsContainer, false);
      localView.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
      localObject1 = localView.findViewById(a.d.SeC);
      s.s(localObject1, "itemView.findViewById(R.…tory_comment_item_avatar)");
      localObject1 = (ImageView)localObject1;
      localObject2 = localView.findViewById(a.d.SeK);
      s.s(localObject2, "itemView.findViewById(R.…ry_comment_item_username)");
      TextView localTextView1 = (TextView)localObject2;
      localObject2 = localView.findViewById(a.d.SeF);
      s.s(localObject2, "itemView.findViewById(R.…ory_comment_item_content)");
      localTextView2 = (TextView)localObject2;
      ((ImageView)localObject1).setClickable(false);
      a.b.h((ImageView)localObject1, locala.hQQ);
      localObject1 = ((n)h.ax(n.class)).bzA().JE(locala.hQQ);
      localObject3 = localTextView1.getContext();
      if (localObject1 != null) {
        break label524;
      }
      localObject1 = "";
      label319:
      localObject3 = p.b((Context)localObject3, (CharSequence)localObject1, localTextView1.getTextSize());
      localObject1 = ((n)h.ax(n.class)).bzA().JE(locala.toUser);
      Context localContext = localTextView1.getContext();
      if (localObject1 != null) {
        break label545;
      }
      localObject1 = "";
      label375:
      localObject1 = p.b(localContext, (CharSequence)localObject1, localTextView1.getTextSize());
      if (locala.SlD == 0) {
        break label566;
      }
      i = 1;
      label400:
      if (i == 0) {
        break label571;
      }
      localObject1 = (CharSequence)(localObject3 + ' ' + localTextView1.getContext().getResources().getString(a.g.app_reply) + ' ' + localObject1);
      label454:
      localTextView1.setText((CharSequence)localObject1);
      if (!locala.Slz) {
        break label580;
      }
      localTextView2.setVisibility(8);
      d.h(localTextView1);
    }
    for (;;)
    {
      localView.setOnClickListener(new CommentsContainer..ExternalSyntheticLambda0(paramCommentsContainer));
      if (localView != null) {
        break label612;
      }
      paramCommentsContainer = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.CommentItemView");
      AppMethodBeat.o(367426);
      throw paramCommentsContainer;
      i = a.e.Sgw;
      break;
      label524:
      localObject2 = ((au)localObject1).aSV();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label319;
      }
      localObject1 = "";
      break label319;
      label545:
      localObject2 = ((au)localObject1).aSV();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label375;
      }
      localObject1 = "";
      break label375;
      label566:
      i = 0;
      break label400;
      label571:
      localObject1 = (CharSequence)localObject3;
      break label454;
      label580:
      localTextView2.setText((CharSequence)p.b(localTextView2.getContext(), (CharSequence)locala.content, localTextView2.getTextSize()));
    }
    label612:
    localObject1 = (CommentItemView)localView;
    int i = paramCommentsContainer.getMeasuredHeight() * 2 / 3;
    Log.i(paramCommentsContainer.TAG, s.X("LogStory: is enhance comment ", Boolean.valueOf(locala.SlB)));
    ((CommentItemView)localObject1).setId(j);
    ((CommentItemView)localObject1).setVisibility(4);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramCommentsContainer.getMeasuredHeight() - i);
    paramCommentsContainer.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    paramCommentsContainer.post(new CommentsContainer..ExternalSyntheticLambda1((CommentItemView)localObject1, paramCommentsContainer, locala, i));
    AppMethodBeat.o(367426);
  }
  
  private static final void a(CommentsContainer paramCommentsContainer, View paramView)
  {
    AppMethodBeat.i(367437);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramCommentsContainer);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/CommentsContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramCommentsContainer, "this$0");
    paramCommentsContainer = paramCommentsContainer.getItemClickListener();
    if (paramCommentsContainer != null) {
      paramCommentsContainer.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/CommentsContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367437);
  }
  
  private static final void b(CommentsContainer paramCommentsContainer)
  {
    AppMethodBeat.i(367429);
    s.u(paramCommentsContainer, "this$0");
    paramCommentsContainer = paramCommentsContainer.getOnLoop();
    if (paramCommentsContainer != null) {
      paramCommentsContainer.invoke();
    }
    AppMethodBeat.o(367429);
  }
  
  public final void F(List<com.tencent.mm.plugin.story.model.b.a> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(120053);
    s.u(paramList, "storyComments");
    this.Sly = paramBoolean;
    this.StI.clear();
    this.StI.addAll((Collection)paramList);
    this.NZy = -1;
    this.SwX = 4000L;
    AppMethodBeat.o(120053);
  }
  
  public final void bEH()
  {
    AppMethodBeat.i(120055);
    Log.i(this.TAG, s.X("LogStory: restart ", this));
    resume();
    AppMethodBeat.o(120055);
  }
  
  public final kotlin.g.a.a<ah> getItemClickListener()
  {
    return this.noh;
  }
  
  public final kotlin.g.a.a<ah> getOnLoop()
  {
    return this.SwY;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(120057);
    Log.i(this.TAG, s.X("LogStory: pause ", this));
    this.hJi = true;
    removeCallbacks(this.SwZ);
    removeCallbacks(this.Sxa);
    removeAllViews();
    this.NZy = -1;
    AppMethodBeat.o(120057);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(120056);
    Log.i(this.TAG, s.X("LogStory: resume ", this));
    this.hJi = false;
    if (this.NZy != 0)
    {
      removeCallbacks(this.SwZ);
      removeCallbacks(this.Sxa);
      removeAllViews();
      this.NZy = -1;
      postDelayed(this.SwZ, 300L);
    }
    AppMethodBeat.o(120056);
  }
  
  public final void setItemClickListener(kotlin.g.a.a<ah> parama)
  {
    this.noh = parama;
  }
  
  public final void setOnLoop(kotlin.g.a.a<ah> parama)
  {
    this.SwY = parama;
  }
  
  public final void setPause(boolean paramBoolean)
  {
    this.hJi = paramBoolean;
  }
  
  public final void setUnread(boolean paramBoolean)
  {
    this.Sly = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(CommentsContainer paramCommentsContainer, com.tencent.mm.plugin.story.model.b.a parama, CommentItemView paramCommentItemView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(CommentsContainer paramCommentsContainer, CommentItemView paramCommentItemView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentsContainer
 * JD-Core Version:    0.7.0.1
 */