package com.tencent.mm.plugin.story.ui.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView;
import com.tencent.mm.plugin.story.ui.view.CommentItemView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import d.g.a.m;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "()V", "animStartPosition", "", "animateOnBind", "", "bindMaxPosition", "blankAreaClickListener", "Lkotlin/Function0;", "", "getBlankAreaClickListener", "()Lkotlin/jvm/functions/Function0;", "setBlankAreaClickListener", "(Lkotlin/jvm/functions/Function0;)V", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "replyClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "comment", "isReply", "getReplyClickListener", "()Lkotlin/jvm/functions/Function2;", "setReplyClickListener", "(Lkotlin/jvm/functions/Function2;)V", "filterFavItem", "filterValidItem", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAnimateEnable", "enable", "update", "storyComments", "", "BaseStoryCommentViewHolder", "Companion", "StoryBubbleViewHolder", "StoryCommentViewHolder", "plugin-story_release"})
public final class e
  extends RecyclerView.a<a>
{
  private static final int zEc = 0;
  private static final int zEd = 1;
  public static final e.b zEe;
  public boolean zDY;
  public com.tencent.mm.plugin.story.i.j zDZ;
  private final ArrayList<com.tencent.mm.plugin.story.f.b.a> zDl;
  public m<? super com.tencent.mm.plugin.story.f.b.a, ? super Boolean, y> zEa;
  public d.g.a.a<y> zEb;
  
  static
  {
    AppMethodBeat.i(119746);
    zEe = new e.b((byte)0);
    zEd = 1;
    AppMethodBeat.o(119746);
  }
  
  public e()
  {
    AppMethodBeat.i(119745);
    this.zDl = new ArrayList();
    AppMethodBeat.o(119745);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119741);
    int i = this.zDl.size();
    AppMethodBeat.o(119741);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(119742);
    if (((com.tencent.mm.plugin.story.f.b.a)this.zDl.get(paramInt)).ztJ)
    {
      paramInt = zEd;
      AppMethodBeat.o(119742);
      return paramInt;
    }
    paramInt = zEc;
    AppMethodBeat.o(119742);
    return paramInt;
  }
  
  public final void gf(List<com.tencent.mm.plugin.story.f.b.a> paramList)
  {
    AppMethodBeat.i(119740);
    d.g.b.k.h(paramList, "storyComments");
    this.zDl.clear();
    this.zDl.addAll((Collection)paramList);
    AppMethodBeat.o(119740);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "avatar", "Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "getAvatar", "()Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "blankArea", "getBlankArea", "()Landroid/view/View;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "maskView", "getMaskView", "setMaskView", "(Landroid/view/View;)V", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindAvatar", "onBindMask", "onBindUsername", "plugin-story_release"})
  public abstract class a
    extends RecyclerView.w
  {
    private final View gCi;
    private View gGk;
    private final TextView uEM;
    final TextView zDo;
    private final CommentAvatarImageView zEf;
    
    public a()
    {
      super();
      this$1 = localObject.findViewById(2131305309);
      d.g.b.k.g(e.this, "itemView.findViewById(R.…tory_comment_item_avatar)");
      this.zEf = ((CommentAvatarImageView)e.this);
      this$1 = localObject.findViewById(2131305319);
      d.g.b.k.g(e.this, "itemView.findViewById(R.…ry_comment_item_username)");
      this.zDo = ((TextView)e.this);
      this$1 = localObject.findViewById(2131305312);
      d.g.b.k.g(e.this, "itemView.findViewById(R.…ory_comment_item_content)");
      this.uEM = ((TextView)e.this);
      this$1 = localObject.findViewById(2131305310);
      d.g.b.k.g(e.this, "itemView.findViewById(R.…_comment_item_blank_area)");
      this.gCi = e.this;
      this.gGk = dZv();
    }
    
    public void a(int paramInt, final com.tencent.mm.plugin.story.f.b.a parama)
    {
      int i = 0;
      d.g.b.k.h(parama, "comment");
      if ((this.asD instanceof CommentItemView)) {
        ((CommentItemView)this.asD).setComment(parama);
      }
      Object localObject1 = this.asD;
      d.g.b.k.g(localObject1, "itemView");
      ((View)localObject1).setVisibility(4);
      this.asD.post((Runnable)new a(this));
      this.gCi.setOnClickListener((View.OnClickListener)new b(this));
      Object localObject2;
      if ((this.asD instanceof CommentItemView))
      {
        if (parama.ztI)
        {
          localObject1 = this.gGk.getBackground();
          d.g.b.k.g(localObject1, "bg");
          localObject2 = this.asD;
          d.g.b.k.g(localObject2, "itemView");
          localObject2 = ((CommentItemView)localObject2).getContext();
          d.g.b.k.g(localObject2, "itemView.context");
          ((Drawable)localObject1).setColorFilter((ColorFilter)new PorterDuffColorFilter(((Context)localObject2).getResources().getColor(2131099748), PorterDuff.Mode.SRC_ATOP));
        }
      }
      else
      {
        localObject1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
        d.g.b.k.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject1).awB().aNt(parama.dng);
        localObject2 = this.zDo.getContext();
        if (localObject1 == null) {
          break label670;
        }
        localObject1 = ((ai)localObject1).aaS();
        if (localObject1 == null) {
          break label670;
        }
        localObject1 = (CharSequence)localObject1;
        label244:
        localObject2 = com.tencent.mm.pluginsdk.ui.span.k.b((Context)localObject2, (CharSequence)localObject1, this.zDo.getTextSize());
        localObject1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
        d.g.b.k.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject1).awB().aNt(parama.toUser);
        Object localObject3 = this.zDo.getContext();
        if (localObject1 == null) {
          break label681;
        }
        localObject1 = ((ai)localObject1).aaS();
        if (localObject1 == null) {
          break label681;
        }
        localObject1 = (CharSequence)localObject1;
        label328:
        localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b((Context)localObject3, (CharSequence)localObject1, this.zDo.getTextSize());
        if (parama.ztN == 0) {
          break label692;
        }
        paramInt = 1;
        label353:
        localObject3 = this.zDo;
        if (paramInt == 0) {
          break label697;
        }
        localObject2 = new StringBuilder().append(localObject2).append(' ');
        Context localContext = this.zDo.getContext();
        d.g.b.k.g(localContext, "fromUser.context");
        localObject1 = (CharSequence)(localContext.getResources().getString(2131755875) + ' ' + localObject1);
        label433:
        ((TextView)localObject3).setText((CharSequence)localObject1);
        this.uEM.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(this.uEM.getContext(), (CharSequence)parama.content, this.uEM.getTextSize()));
        a.b.d((ImageView)this.zEf, parama.dng);
        localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
        localObject1 = j.b.dVF().axe(parama.dng);
        if (localObject1 == null) {
          break label707;
        }
      }
      label670:
      label681:
      label692:
      label697:
      label707:
      for (boolean bool = ((f)localObject1).dZc();; bool = false)
      {
        this.zEf.setShowStoryHint(bool);
        this.zEf.axl(parama.dng);
        localObject1 = this.zEf;
        paramInt = i;
        if (parama.ztJ) {
          paramInt = this.zEf.getResources().getColor(2131100967);
        }
        ((CommentAvatarImageView)localObject1).setHintBg(paramInt);
        this.zEf.setOnClickListener((View.OnClickListener)new c(this, parama));
        return;
        localObject1 = this.gGk.getBackground();
        d.g.b.k.g(localObject1, "bg");
        localObject2 = this.asD;
        d.g.b.k.g(localObject2, "itemView");
        localObject2 = ((CommentItemView)localObject2).getContext();
        d.g.b.k.g(localObject2, "itemView.context");
        ((Drawable)localObject1).setColorFilter((ColorFilter)new PorterDuffColorFilter(((Context)localObject2).getResources().getColor(2131100967), PorterDuff.Mode.SRC_ATOP));
        break;
        localObject1 = (CharSequence)"";
        break label244;
        localObject1 = (CharSequence)"";
        break label328;
        paramInt = 0;
        break label353;
        localObject1 = (CharSequence)localObject2;
        break label433;
      }
    }
    
    public abstract View dZv();
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(e.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(119728);
        View localView = this.zEh.asD;
        d.g.b.k.g(localView, "itemView");
        localView.setVisibility(0);
        AppMethodBeat.o(119728);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(e.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119729);
        paramView = this.zEh.zEg.zEb;
        if (paramView != null)
        {
          paramView.invoke();
          AppMethodBeat.o(119729);
          return;
        }
        AppMethodBeat.o(119729);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(e.a parama, com.tencent.mm.plugin.story.f.b.a parama1) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119730);
        paramView = new Intent();
        paramView.putExtra("Contact_User", parama.dng);
        paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
        View localView = this.zEh.asD;
        d.g.b.k.g(localView, "itemView");
        d.b(localView.getContext(), "profile", ".ui.ContactInfoUI", paramView);
        AppMethodBeat.o(119730);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryBubbleViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
  public final class c
    extends e.a
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(119733);
      AppMethodBeat.o(119733);
    }
    
    public final void a(int paramInt, com.tencent.mm.plugin.story.f.b.a parama)
    {
      AppMethodBeat.i(119732);
      d.g.b.k.h(parama, "comment");
      super.a(paramInt, parama);
      if (parama.ztJ) {
        c.e(this.zDo);
      }
      AppMethodBeat.o(119732);
    }
    
    public final View dZv()
    {
      AppMethodBeat.i(119731);
      View localView = this.asD.findViewById(2131305288);
      d.g.b.k.g(localView, "itemView.findViewById(R.…omment_bubble_background)");
      AppMethodBeat.o(119731);
      return localView;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "opTv", "Landroid/widget/TextView;", "getOpTv", "()Landroid/widget/TextView;", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindOpTv", "plugin-story_release"})
  public final class d
    extends e.a
  {
    private final TextView yyy;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(119739);
      this$1 = localObject.findViewById(2131305315);
      d.g.b.k.g(e.this, "itemView.findViewById(R.…story_comment_item_op_tv)");
      this.yyy = ((TextView)e.this);
      AppMethodBeat.o(119739);
    }
    
    public final void a(int paramInt, final com.tencent.mm.plugin.story.f.b.a parama)
    {
      AppMethodBeat.i(119738);
      d.g.b.k.h(parama, "comment");
      super.a(paramInt, parama);
      if (parama.ztJ) {
        c.e(this.zDo);
      }
      Object localObject1;
      Object localObject2;
      if (!parama.ztJ)
      {
        localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
        boolean bool = bs.lr(j.b.dHx(), parama.dng);
        this.yyy.setVisibility(0);
        if (bool)
        {
          this.yyy.setOnClickListener((View.OnClickListener)new b(this, parama));
          localObject1 = this.yyy;
          localObject2 = this.asD;
          d.g.b.k.g(localObject2, "itemView");
          localObject2 = ((View)localObject2).getContext();
          d.g.b.k.g(localObject2, "itemView.context");
          ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131764221));
          this.yyy.setTextColor(-1);
          c.e(this.yyy);
        }
      }
      for (;;)
      {
        this.asD.setOnClickListener((View.OnClickListener)new a(this, parama));
        AppMethodBeat.o(119738);
        return;
        if ((com.tencent.mm.plugin.story.c.a.a.zqB.dUW()) && ((e.a(e.this)) || (e.b(e.this))))
        {
          this.yyy.setOnClickListener((View.OnClickListener)new c(this, parama));
          localObject1 = this.yyy;
          localObject2 = this.asD;
          d.g.b.k.g(localObject2, "itemView");
          localObject2 = ((View)localObject2).getContext();
          d.g.b.k.g(localObject2, "itemView.context");
          ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131764222));
          this.yyy.setTextColor(-1);
          c.e(this.yyy);
        }
        else
        {
          this.yyy.setVisibility(8);
        }
      }
    }
    
    public final View dZv()
    {
      AppMethodBeat.i(119737);
      View localView = this.asD.findViewById(2131305295);
      d.g.b.k.g(localView, "itemView.findViewById(R.…mment_content_background)");
      AppMethodBeat.o(119737);
      return localView;
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(e.d paramd, com.tencent.mm.plugin.story.f.b.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119734);
        if ((com.tencent.mm.plugin.story.c.a.a.zqB.dUW()) && ((e.a(this.zEj.zEg)) || (e.b(this.zEj.zEg))))
        {
          paramView = com.tencent.mm.plugin.story.f.j.zsh;
          if (!bs.lr(j.b.dHx(), parama.dng))
          {
            paramView = this.zEj.zEg.zEa;
            if (paramView != null)
            {
              paramView.n(parama, Boolean.TRUE);
              AppMethodBeat.o(119734);
              return;
            }
          }
        }
        AppMethodBeat.o(119734);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(e.d paramd, com.tencent.mm.plugin.story.f.b.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119735);
        paramView = this.zEj.zEg.zEa;
        if (paramView != null)
        {
          paramView.n(parama, Boolean.FALSE);
          AppMethodBeat.o(119735);
          return;
        }
        AppMethodBeat.o(119735);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(e.d paramd, com.tencent.mm.plugin.story.f.b.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119736);
        paramView = this.zEj.zEg.zEa;
        if (paramView != null)
        {
          paramView.n(parama, Boolean.TRUE);
          AppMethodBeat.o(119736);
          return;
        }
        AppMethodBeat.o(119736);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.e
 * JD-Core Version:    0.7.0.1
 */