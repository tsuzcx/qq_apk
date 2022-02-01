package com.tencent.mm.plugin.story.ui.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.story.a.a;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView;
import com.tencent.mm.plugin.story.ui.view.CommentItemView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "()V", "animStartPosition", "", "animateOnBind", "", "bindMaxPosition", "blankAreaClickListener", "Lkotlin/Function0;", "", "getBlankAreaClickListener", "()Lkotlin/jvm/functions/Function0;", "setBlankAreaClickListener", "(Lkotlin/jvm/functions/Function0;)V", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "replyClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "comment", "isReply", "getReplyClickListener", "()Lkotlin/jvm/functions/Function2;", "setReplyClickListener", "(Lkotlin/jvm/functions/Function2;)V", "filterFavItem", "filterValidItem", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAnimateEnable", "enable", "update", "storyComments", "", "BaseStoryCommentViewHolder", "Companion", "StoryBubbleViewHolder", "StoryCommentViewHolder", "plugin-story_release"})
public final class e
  extends RecyclerView.a<a>
{
  private static final int LRR = 0;
  private static final int LRS = 1;
  public static final b LRT;
  public boolean LRN;
  public com.tencent.mm.plugin.story.i.j LRO;
  public m<? super com.tencent.mm.plugin.story.f.b.a, ? super Boolean, x> LRP;
  public kotlin.g.a.a<x> LRQ;
  private final ArrayList<com.tencent.mm.plugin.story.f.b.a> LRa;
  
  static
  {
    AppMethodBeat.i(119746);
    LRT = new b((byte)0);
    LRS = 1;
    AppMethodBeat.o(119746);
  }
  
  public e()
  {
    AppMethodBeat.i(119745);
    this.LRa = new ArrayList();
    AppMethodBeat.o(119745);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119741);
    int i = this.LRa.size();
    AppMethodBeat.o(119741);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(119742);
    if (((com.tencent.mm.plugin.story.f.b.a)this.LRa.get(paramInt)).LHY)
    {
      paramInt = LRS;
      AppMethodBeat.o(119742);
      return paramInt;
    }
    paramInt = LRR;
    AppMethodBeat.o(119742);
    return paramInt;
  }
  
  public final void gg(List<com.tencent.mm.plugin.story.f.b.a> paramList)
  {
    AppMethodBeat.i(119740);
    p.k(paramList, "storyComments");
    this.LRa.clear();
    this.LRa.addAll((Collection)paramList);
    AppMethodBeat.o(119740);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "avatar", "Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "getAvatar", "()Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "blankArea", "getBlankArea", "()Landroid/view/View;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "maskView", "getMaskView", "setMaskView", "(Landroid/view/View;)V", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindAvatar", "onBindMask", "onBindUsername", "plugin-story_release"})
  public abstract class a
    extends RecyclerView.v
  {
    private final TextView ETn;
    private final CommentAvatarImageView LRU;
    private final TextView LRd;
    private final View kFU;
    private View maskView;
    
    public a()
    {
      super();
      this$1 = localObject.findViewById(a.d.LAQ);
      p.j(e.this, "itemView.findViewById(R.…tory_comment_item_avatar)");
      this.LRU = ((CommentAvatarImageView)e.this);
      this$1 = localObject.findViewById(a.d.LAZ);
      p.j(e.this, "itemView.findViewById(R.…ry_comment_item_username)");
      this.LRd = ((TextView)e.this);
      this$1 = localObject.findViewById(a.d.LAT);
      p.j(e.this, "itemView.findViewById(R.…ory_comment_item_content)");
      this.ETn = ((TextView)e.this);
      this$1 = localObject.findViewById(a.d.LAR);
      p.j(e.this, "itemView.findViewById(R.…_comment_item_blank_area)");
      this.kFU = e.this;
      this.maskView = ggq();
    }
    
    public void a(int paramInt, final com.tencent.mm.plugin.story.f.b.a parama)
    {
      int i = 0;
      p.k(parama, "comment");
      if ((this.amk instanceof CommentItemView)) {
        ((CommentItemView)this.amk).setComment(parama);
      }
      Object localObject1 = this.amk;
      p.j(localObject1, "itemView");
      ((View)localObject1).setVisibility(4);
      this.amk.post((Runnable)new a(this));
      this.kFU.setOnClickListener((View.OnClickListener)new b(this));
      Object localObject2;
      if ((this.amk instanceof CommentItemView))
      {
        if (parama.LHX)
        {
          localObject1 = this.maskView.getBackground();
          p.j(localObject1, "bg");
          localObject2 = this.amk;
          p.j(localObject2, "itemView");
          localObject2 = ((CommentItemView)localObject2).getContext();
          p.j(localObject2, "itemView.context");
          ((Drawable)localObject1).setColorFilter((ColorFilter)new PorterDuffColorFilter(((Context)localObject2).getResources().getColor(a.a.Indigo), PorterDuff.Mode.SRC_ATOP));
        }
      }
      else
      {
        localObject1 = h.ae(n.class);
        p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
        localObject1 = ((n)localObject1).bbL().RG(parama.fLi);
        localObject2 = this.LRd.getContext();
        if (localObject1 == null) {
          break label671;
        }
        localObject1 = ((as)localObject1).ays();
        if (localObject1 == null) {
          break label671;
        }
        localObject1 = (CharSequence)localObject1;
        label245:
        localObject2 = com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject2, (CharSequence)localObject1, this.LRd.getTextSize());
        localObject1 = h.ae(n.class);
        p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
        localObject1 = ((n)localObject1).bbL().RG(parama.toUser);
        Object localObject3 = this.LRd.getContext();
        if (localObject1 == null) {
          break label682;
        }
        localObject1 = ((as)localObject1).ays();
        if (localObject1 == null) {
          break label682;
        }
        localObject1 = (CharSequence)localObject1;
        label329:
        localObject1 = com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject3, (CharSequence)localObject1, this.LRd.getTextSize());
        if (parama.LIc == 0) {
          break label693;
        }
        paramInt = 1;
        label354:
        localObject3 = this.LRd;
        if (paramInt == 0) {
          break label698;
        }
        localObject2 = new StringBuilder().append(localObject2).append(' ');
        Context localContext = this.LRd.getContext();
        p.j(localContext, "fromUser.context");
        localObject1 = (CharSequence)(localContext.getResources().getString(a.g.app_reply) + ' ' + localObject1);
        label434:
        ((TextView)localObject3).setText((CharSequence)localObject1);
        this.ETn.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(this.ETn.getContext(), (CharSequence)parama.content, this.ETn.getTextSize()));
        a.b.d((ImageView)this.LRU, parama.fLi);
        localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
        localObject1 = j.b.gcx().bdA(parama.fLi);
        if (localObject1 == null) {
          break label708;
        }
      }
      label671:
      label682:
      label693:
      label698:
      label708:
      for (boolean bool = ((f)localObject1).gfW();; bool = false)
      {
        this.LRU.setShowStoryHint(bool);
        this.LRU.bdH(parama.fLi);
        localObject1 = this.LRU;
        paramInt = i;
        if (parama.LHY) {
          paramInt = this.LRU.getResources().getColor(a.a.Lzb);
        }
        ((CommentAvatarImageView)localObject1).setHintBg(paramInt);
        this.LRU.setOnClickListener((View.OnClickListener)new c(this, parama));
        return;
        localObject1 = this.maskView.getBackground();
        p.j(localObject1, "bg");
        localObject2 = this.amk;
        p.j(localObject2, "itemView");
        localObject2 = ((CommentItemView)localObject2).getContext();
        p.j(localObject2, "itemView.context");
        ((Drawable)localObject1).setColorFilter((ColorFilter)new PorterDuffColorFilter(((Context)localObject2).getResources().getColor(a.a.Lzb), PorterDuff.Mode.SRC_ATOP));
        break;
        localObject1 = (CharSequence)"";
        break label245;
        localObject1 = (CharSequence)"";
        break label329;
        paramInt = 0;
        break label354;
        localObject1 = (CharSequence)localObject2;
        break label434;
      }
    }
    
    public final TextView ggp()
    {
      return this.LRd;
    }
    
    public abstract View ggq();
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(e.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(119728);
        View localView = this.LRW.amk;
        p.j(localView, "itemView");
        localView.setVisibility(0);
        AppMethodBeat.o(119728);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(e.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119729);
        b localb = new b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder$onBind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramView = this.LRW.LRV.LRQ;
        if (paramView != null) {
          paramView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder$onBind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119729);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(e.a parama, com.tencent.mm.plugin.story.f.b.a parama1) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119730);
        Object localObject = new b();
        ((b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        paramView = new Intent();
        paramView.putExtra("Contact_User", parama.fLi);
        paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
        localObject = this.LRW.amk;
        p.j(localObject, "itemView");
        c.b(((View)localObject).getContext(), "profile", ".ui.ContactInfoUI", paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119730);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$Companion;", "", "()V", "ViewTypeBubble", "", "ViewTypeNormal", "plugin-story_release"})
  public static final class b {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryBubbleViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
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
      p.k(parama, "comment");
      super.a(paramInt, parama);
      if (parama.LHY) {
        d.g(ggp());
      }
      AppMethodBeat.o(119732);
    }
    
    public final View ggq()
    {
      AppMethodBeat.i(119731);
      View localView = this.amk.findViewById(a.d.LAw);
      p.j(localView, "itemView.findViewById(R.…omment_bubble_background)");
      AppMethodBeat.o(119731);
      return localView;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "opTv", "Landroid/widget/TextView;", "getOpTv", "()Landroid/widget/TextView;", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindOpTv", "plugin-story_release"})
  public final class d
    extends e.a
  {
    private final TextView KCv;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(119739);
      this$1 = localObject.findViewById(a.d.LAV);
      p.j(e.this, "itemView.findViewById(R.…story_comment_item_op_tv)");
      this.KCv = ((TextView)e.this);
      AppMethodBeat.o(119739);
    }
    
    public final void a(int paramInt, final com.tencent.mm.plugin.story.f.b.a parama)
    {
      AppMethodBeat.i(119738);
      p.k(parama, "comment");
      super.a(paramInt, parama);
      if (parama.LHY) {
        d.g(ggp());
      }
      Object localObject1;
      Object localObject2;
      if (!parama.LHY)
      {
        localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
        boolean bool = Util.isEqual(j.b.fOo(), parama.fLi);
        this.KCv.setVisibility(0);
        if (bool)
        {
          this.KCv.setOnClickListener((View.OnClickListener)new b(this, parama));
          localObject1 = this.KCv;
          localObject2 = this.amk;
          p.j(localObject2, "itemView");
          localObject2 = ((View)localObject2).getContext();
          p.j(localObject2, "itemView.context");
          ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(a.g.LDG));
          this.KCv.setTextColor(-1);
          d.g(this.KCv);
        }
      }
      for (;;)
      {
        this.amk.setOnClickListener((View.OnClickListener)new a(this, parama));
        AppMethodBeat.o(119738);
        return;
        if ((com.tencent.mm.plugin.story.c.a.a.LEY.gbO()) && ((e.a(e.this)) || (e.b(e.this))))
        {
          this.KCv.setOnClickListener((View.OnClickListener)new c(this, parama));
          localObject1 = this.KCv;
          localObject2 = this.amk;
          p.j(localObject2, "itemView");
          localObject2 = ((View)localObject2).getContext();
          p.j(localObject2, "itemView.context");
          ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(a.g.LDH));
          this.KCv.setTextColor(-1);
          d.g(this.KCv);
        }
        else
        {
          this.KCv.setVisibility(8);
        }
      }
    }
    
    public final View ggq()
    {
      AppMethodBeat.i(119737);
      View localView = this.amk.findViewById(a.d.LAD);
      p.j(localView, "itemView.findViewById(R.…mment_content_background)");
      AppMethodBeat.o(119737);
      return localView;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(e.d paramd, com.tencent.mm.plugin.story.f.b.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119734);
        b localb = new b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((com.tencent.mm.plugin.story.c.a.a.LEY.gbO()) && ((e.a(this.LRY.LRV)) || (e.b(this.LRY.LRV))))
        {
          paramView = com.tencent.mm.plugin.story.f.j.LGA;
          if (!Util.isEqual(j.b.fOo(), parama.fLi))
          {
            paramView = this.LRY.LRV.LRP;
            if (paramView != null) {
              paramView.invoke(parama, Boolean.TRUE);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119734);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(e.d paramd, com.tencent.mm.plugin.story.f.b.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119735);
        b localb = new b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBindOpTv$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramView = this.LRY.LRV.LRP;
        if (paramView != null) {
          paramView.invoke(parama, Boolean.FALSE);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBindOpTv$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119735);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(e.d paramd, com.tencent.mm.plugin.story.f.b.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119736);
        b localb = new b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBindOpTv$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramView = this.LRY.LRV.LRP;
        if (paramView != null) {
          paramView.invoke(parama, Boolean.TRUE);
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