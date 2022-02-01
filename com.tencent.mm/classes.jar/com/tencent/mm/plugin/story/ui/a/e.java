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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView;
import com.tencent.mm.plugin.story.ui.view.CommentItemView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import d.g.a.m;
import d.g.b.p;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "()V", "animStartPosition", "", "animateOnBind", "", "bindMaxPosition", "blankAreaClickListener", "Lkotlin/Function0;", "", "getBlankAreaClickListener", "()Lkotlin/jvm/functions/Function0;", "setBlankAreaClickListener", "(Lkotlin/jvm/functions/Function0;)V", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "replyClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "comment", "isReply", "getReplyClickListener", "()Lkotlin/jvm/functions/Function2;", "setReplyClickListener", "(Lkotlin/jvm/functions/Function2;)V", "filterFavItem", "filterValidItem", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAnimateEnable", "enable", "update", "storyComments", "", "BaseStoryCommentViewHolder", "Companion", "StoryBubbleViewHolder", "StoryCommentViewHolder", "plugin-story_release"})
public final class e
  extends RecyclerView.a<a>
{
  private static final int BmZ = 0;
  private static final int Bna = 1;
  public static final e.b Bnb;
  public boolean BmV;
  public com.tencent.mm.plugin.story.i.j BmW;
  public m<? super com.tencent.mm.plugin.story.f.b.a, ? super Boolean, z> BmX;
  public d.g.a.a<z> BmY;
  private final ArrayList<com.tencent.mm.plugin.story.f.b.a> Bmi;
  
  static
  {
    AppMethodBeat.i(119746);
    Bnb = new e.b((byte)0);
    Bna = 1;
    AppMethodBeat.o(119746);
  }
  
  public e()
  {
    AppMethodBeat.i(119745);
    this.Bmi = new ArrayList();
    AppMethodBeat.o(119745);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119741);
    int i = this.Bmi.size();
    AppMethodBeat.o(119741);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(119742);
    if (((com.tencent.mm.plugin.story.f.b.a)this.Bmi.get(paramInt)).Bdg)
    {
      paramInt = Bna;
      AppMethodBeat.o(119742);
      return paramInt;
    }
    paramInt = BmZ;
    AppMethodBeat.o(119742);
    return paramInt;
  }
  
  public final void gz(List<com.tencent.mm.plugin.story.f.b.a> paramList)
  {
    AppMethodBeat.i(119740);
    p.h(paramList, "storyComments");
    this.Bmi.clear();
    this.Bmi.addAll((Collection)paramList);
    AppMethodBeat.o(119740);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "avatar", "Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "getAvatar", "()Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "blankArea", "getBlankArea", "()Landroid/view/View;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "maskView", "getMaskView", "setMaskView", "(Landroid/view/View;)V", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindAvatar", "onBindMask", "onBindUsername", "plugin-story_release"})
  public abstract class a
    extends RecyclerView.w
  {
    final TextView Bml;
    private final CommentAvatarImageView Bnc;
    private final View gYC;
    private View hcH;
    private final TextView vTQ;
    
    public a()
    {
      super();
      this$1 = localObject.findViewById(2131305309);
      p.g(e.this, "itemView.findViewById(R.…tory_comment_item_avatar)");
      this.Bnc = ((CommentAvatarImageView)e.this);
      this$1 = localObject.findViewById(2131305319);
      p.g(e.this, "itemView.findViewById(R.…ry_comment_item_username)");
      this.Bml = ((TextView)e.this);
      this$1 = localObject.findViewById(2131305312);
      p.g(e.this, "itemView.findViewById(R.…ory_comment_item_content)");
      this.vTQ = ((TextView)e.this);
      this$1 = localObject.findViewById(2131305310);
      p.g(e.this, "itemView.findViewById(R.…_comment_item_blank_area)");
      this.gYC = e.this;
      this.hcH = ept();
    }
    
    public void a(int paramInt, final com.tencent.mm.plugin.story.f.b.a parama)
    {
      int i = 0;
      p.h(parama, "comment");
      if ((this.auu instanceof CommentItemView)) {
        ((CommentItemView)this.auu).setComment(parama);
      }
      Object localObject1 = this.auu;
      p.g(localObject1, "itemView");
      ((View)localObject1).setVisibility(4);
      this.auu.post((Runnable)new a(this));
      this.gYC.setOnClickListener((View.OnClickListener)new b(this));
      Object localObject2;
      if ((this.auu instanceof CommentItemView))
      {
        if (parama.Bdf)
        {
          localObject1 = this.hcH.getBackground();
          p.g(localObject1, "bg");
          localObject2 = this.auu;
          p.g(localObject2, "itemView");
          localObject2 = ((CommentItemView)localObject2).getContext();
          p.g(localObject2, "itemView.context");
          ((Drawable)localObject1).setColorFilter((ColorFilter)new PorterDuffColorFilter(((Context)localObject2).getResources().getColor(2131099748), PorterDuff.Mode.SRC_ATOP));
        }
      }
      else
      {
        localObject1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).azF().BH(parama.dzZ);
        localObject2 = this.Bml.getContext();
        if (localObject1 == null) {
          break label670;
        }
        localObject1 = ((an)localObject1).adG();
        if (localObject1 == null) {
          break label670;
        }
        localObject1 = (CharSequence)localObject1;
        label244:
        localObject2 = k.b((Context)localObject2, (CharSequence)localObject1, this.Bml.getTextSize());
        localObject1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).azF().BH(parama.toUser);
        Object localObject3 = this.Bml.getContext();
        if (localObject1 == null) {
          break label681;
        }
        localObject1 = ((an)localObject1).adG();
        if (localObject1 == null) {
          break label681;
        }
        localObject1 = (CharSequence)localObject1;
        label328:
        localObject1 = k.b((Context)localObject3, (CharSequence)localObject1, this.Bml.getTextSize());
        if (parama.Bdk == 0) {
          break label692;
        }
        paramInt = 1;
        label353:
        localObject3 = this.Bml;
        if (paramInt == 0) {
          break label697;
        }
        localObject2 = new StringBuilder().append(localObject2).append(' ');
        Context localContext = this.Bml.getContext();
        p.g(localContext, "fromUser.context");
        localObject1 = (CharSequence)(localContext.getResources().getString(2131755875) + ' ' + localObject1);
        label433:
        ((TextView)localObject3).setText((CharSequence)localObject1);
        this.vTQ.setText((CharSequence)k.b(this.vTQ.getContext(), (CharSequence)parama.content, this.vTQ.getTextSize()));
        a.b.d((ImageView)this.Bnc, parama.dzZ);
        localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
        localObject1 = j.b.elC().aDB(parama.dzZ);
        if (localObject1 == null) {
          break label707;
        }
      }
      label670:
      label681:
      label692:
      label697:
      label707:
      for (boolean bool = ((f)localObject1).epa();; bool = false)
      {
        this.Bnc.setShowStoryHint(bool);
        this.Bnc.aDI(parama.dzZ);
        localObject1 = this.Bnc;
        paramInt = i;
        if (parama.Bdg) {
          paramInt = this.Bnc.getResources().getColor(2131100967);
        }
        ((CommentAvatarImageView)localObject1).setHintBg(paramInt);
        this.Bnc.setOnClickListener((View.OnClickListener)new c(this, parama));
        return;
        localObject1 = this.hcH.getBackground();
        p.g(localObject1, "bg");
        localObject2 = this.auu;
        p.g(localObject2, "itemView");
        localObject2 = ((CommentItemView)localObject2).getContext();
        p.g(localObject2, "itemView.context");
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
    
    public abstract View ept();
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(e.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(119728);
        View localView = this.Bne.auu;
        p.g(localView, "itemView");
        localView.setVisibility(0);
        AppMethodBeat.o(119728);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(e.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119729);
        b localb = new b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder$onBind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramView = this.Bne.Bnd.BmY;
        if (paramView != null) {
          paramView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder$onBind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119729);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(e.a parama, com.tencent.mm.plugin.story.f.b.a parama1) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119730);
        Object localObject = new b();
        ((b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        paramView = new Intent();
        paramView.putExtra("Contact_User", parama.dzZ);
        paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
        localObject = this.Bne.auu;
        p.g(localObject, "itemView");
        d.b(((View)localObject).getContext(), "profile", ".ui.ContactInfoUI", paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119730);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryBubbleViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
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
      p.h(parama, "comment");
      super.a(paramInt, parama);
      if (parama.Bdg) {
        c.e(this.Bml);
      }
      AppMethodBeat.o(119732);
    }
    
    public final View ept()
    {
      AppMethodBeat.i(119731);
      View localView = this.auu.findViewById(2131305288);
      p.g(localView, "itemView.findViewById(R.…omment_bubble_background)");
      AppMethodBeat.o(119731);
      return localView;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "opTv", "Landroid/widget/TextView;", "getOpTv", "()Landroid/widget/TextView;", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindOpTv", "plugin-story_release"})
  public final class d
    extends e.a
  {
    private final TextView AgQ;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(119739);
      this$1 = localObject.findViewById(2131305315);
      p.g(e.this, "itemView.findViewById(R.…story_comment_item_op_tv)");
      this.AgQ = ((TextView)e.this);
      AppMethodBeat.o(119739);
    }
    
    public final void a(int paramInt, final com.tencent.mm.plugin.story.f.b.a parama)
    {
      AppMethodBeat.i(119738);
      p.h(parama, "comment");
      super.a(paramInt, parama);
      if (parama.Bdg) {
        c.e(this.Bml);
      }
      Object localObject1;
      Object localObject2;
      if (!parama.Bdg)
      {
        localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
        boolean bool = bu.lX(j.b.dXj(), parama.dzZ);
        this.AgQ.setVisibility(0);
        if (bool)
        {
          this.AgQ.setOnClickListener((View.OnClickListener)new b(this, parama));
          localObject1 = this.AgQ;
          localObject2 = this.auu;
          p.g(localObject2, "itemView");
          localObject2 = ((View)localObject2).getContext();
          p.g(localObject2, "itemView.context");
          ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131764221));
          this.AgQ.setTextColor(-1);
          c.e(this.AgQ);
        }
      }
      for (;;)
      {
        this.auu.setOnClickListener((View.OnClickListener)new a(this, parama));
        AppMethodBeat.o(119738);
        return;
        if ((com.tencent.mm.plugin.story.c.a.a.AZY.ekT()) && ((e.a(e.this)) || (e.b(e.this))))
        {
          this.AgQ.setOnClickListener((View.OnClickListener)new c(this, parama));
          localObject1 = this.AgQ;
          localObject2 = this.auu;
          p.g(localObject2, "itemView");
          localObject2 = ((View)localObject2).getContext();
          p.g(localObject2, "itemView.context");
          ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131764222));
          this.AgQ.setTextColor(-1);
          c.e(this.AgQ);
        }
        else
        {
          this.AgQ.setVisibility(8);
        }
      }
    }
    
    public final View ept()
    {
      AppMethodBeat.i(119737);
      View localView = this.auu.findViewById(2131305295);
      p.g(localView, "itemView.findViewById(R.…mment_content_background)");
      AppMethodBeat.o(119737);
      return localView;
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(e.d paramd, com.tencent.mm.plugin.story.f.b.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119734);
        b localb = new b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((com.tencent.mm.plugin.story.c.a.a.AZY.ekT()) && ((e.a(this.Bng.Bnd)) || (e.b(this.Bng.Bnd))))
        {
          paramView = com.tencent.mm.plugin.story.f.j.BbE;
          if (!bu.lX(j.b.dXj(), parama.dzZ))
          {
            paramView = this.Bng.Bnd.BmX;
            if (paramView != null) {
              paramView.p(parama, Boolean.TRUE);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119734);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(e.d paramd, com.tencent.mm.plugin.story.f.b.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119735);
        b localb = new b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBindOpTv$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramView = this.Bng.Bnd.BmX;
        if (paramView != null) {
          paramView.p(parama, Boolean.FALSE);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBindOpTv$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119735);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(e.d paramd, com.tencent.mm.plugin.story.f.b.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119736);
        b localb = new b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBindOpTv$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramView = this.Bng.Bnd.BmX;
        if (paramView != null) {
          paramView.p(parama, Boolean.TRUE);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBindOpTv$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119736);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.e
 * JD-Core Version:    0.7.0.1
 */