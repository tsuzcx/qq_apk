package com.tencent.mm.plugin.story.ui.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.f;
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

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "()V", "animStartPosition", "", "animateOnBind", "", "bindMaxPosition", "blankAreaClickListener", "Lkotlin/Function0;", "", "getBlankAreaClickListener", "()Lkotlin/jvm/functions/Function0;", "setBlankAreaClickListener", "(Lkotlin/jvm/functions/Function0;)V", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "replyClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "comment", "isReply", "getReplyClickListener", "()Lkotlin/jvm/functions/Function2;", "setReplyClickListener", "(Lkotlin/jvm/functions/Function2;)V", "filterFavItem", "filterValidItem", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAnimateEnable", "enable", "update", "storyComments", "", "BaseStoryCommentViewHolder", "Companion", "StoryBubbleViewHolder", "StoryCommentViewHolder", "plugin-story_release"})
public final class e
  extends RecyclerView.a<a>
{
  private static final int FxP = 0;
  private static final int FxQ = 1;
  public static final b FxR;
  private final ArrayList<com.tencent.mm.plugin.story.f.b.a> FwY;
  public boolean FxL;
  public com.tencent.mm.plugin.story.i.j FxM;
  public m<? super com.tencent.mm.plugin.story.f.b.a, ? super Boolean, x> FxN;
  public kotlin.g.a.a<x> FxO;
  
  static
  {
    AppMethodBeat.i(119746);
    FxR = new b((byte)0);
    FxQ = 1;
    AppMethodBeat.o(119746);
  }
  
  public e()
  {
    AppMethodBeat.i(119745);
    this.FwY = new ArrayList();
    AppMethodBeat.o(119745);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119741);
    int i = this.FwY.size();
    AppMethodBeat.o(119741);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(119742);
    if (((com.tencent.mm.plugin.story.f.b.a)this.FwY.get(paramInt)).FnX)
    {
      paramInt = FxQ;
      AppMethodBeat.o(119742);
      return paramInt;
    }
    paramInt = FxP;
    AppMethodBeat.o(119742);
    return paramInt;
  }
  
  public final void hw(List<com.tencent.mm.plugin.story.f.b.a> paramList)
  {
    AppMethodBeat.i(119740);
    p.h(paramList, "storyComments");
    this.FwY.clear();
    this.FwY.addAll((Collection)paramList);
    AppMethodBeat.o(119740);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "avatar", "Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "getAvatar", "()Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "blankArea", "getBlankArea", "()Landroid/view/View;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "maskView", "getMaskView", "setMaskView", "(Landroid/view/View;)V", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindAvatar", "onBindMask", "onBindUsername", "plugin-story_release"})
  public abstract class a
    extends RecyclerView.v
  {
    private final CommentAvatarImageView FxS;
    final TextView Fxb;
    private final View hRx;
    private View maskView;
    private final TextView znW;
    
    public a()
    {
      super();
      this$1 = localObject.findViewById(2131308514);
      p.g(e.this, "itemView.findViewById(R.…tory_comment_item_avatar)");
      this.FxS = ((CommentAvatarImageView)e.this);
      this$1 = localObject.findViewById(2131308524);
      p.g(e.this, "itemView.findViewById(R.…ry_comment_item_username)");
      this.Fxb = ((TextView)e.this);
      this$1 = localObject.findViewById(2131308517);
      p.g(e.this, "itemView.findViewById(R.…ory_comment_item_content)");
      this.znW = ((TextView)e.this);
      this$1 = localObject.findViewById(2131308515);
      p.g(e.this, "itemView.findViewById(R.…_comment_item_blank_area)");
      this.hRx = e.this;
      this.maskView = frT();
    }
    
    public void a(int paramInt, final com.tencent.mm.plugin.story.f.b.a parama)
    {
      int i = 0;
      p.h(parama, "comment");
      if ((this.aus instanceof CommentItemView)) {
        ((CommentItemView)this.aus).setComment(parama);
      }
      Object localObject1 = this.aus;
      p.g(localObject1, "itemView");
      ((View)localObject1).setVisibility(4);
      this.aus.post((Runnable)new a(this));
      this.hRx.setOnClickListener((View.OnClickListener)new b(this));
      Object localObject2;
      if ((this.aus instanceof CommentItemView))
      {
        if (parama.FnW)
        {
          localObject1 = this.maskView.getBackground();
          p.g(localObject1, "bg");
          localObject2 = this.aus;
          p.g(localObject2, "itemView");
          localObject2 = ((CommentItemView)localObject2).getContext();
          p.g(localObject2, "itemView.context");
          ((Drawable)localObject1).setColorFilter((ColorFilter)new PorterDuffColorFilter(((Context)localObject2).getResources().getColor(2131099762), PorterDuff.Mode.SRC_ATOP));
        }
      }
      else
      {
        localObject1 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).aSN().Kn(parama.dRL);
        localObject2 = this.Fxb.getContext();
        if (localObject1 == null) {
          break label670;
        }
        localObject1 = ((as)localObject1).arJ();
        if (localObject1 == null) {
          break label670;
        }
        localObject1 = (CharSequence)localObject1;
        label244:
        localObject2 = com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject2, (CharSequence)localObject1, this.Fxb.getTextSize());
        localObject1 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).aSN().Kn(parama.toUser);
        Object localObject3 = this.Fxb.getContext();
        if (localObject1 == null) {
          break label681;
        }
        localObject1 = ((as)localObject1).arJ();
        if (localObject1 == null) {
          break label681;
        }
        localObject1 = (CharSequence)localObject1;
        label328:
        localObject1 = com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject3, (CharSequence)localObject1, this.Fxb.getTextSize());
        if (parama.Fob == 0) {
          break label692;
        }
        paramInt = 1;
        label353:
        localObject3 = this.Fxb;
        if (paramInt == 0) {
          break label697;
        }
        localObject2 = new StringBuilder().append(localObject2).append(' ');
        Context localContext = this.Fxb.getContext();
        p.g(localContext, "fromUser.context");
        localObject1 = (CharSequence)(localContext.getResources().getString(2131755964) + ' ' + localObject1);
        label433:
        ((TextView)localObject3).setText((CharSequence)localObject1);
        this.znW.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(this.znW.getContext(), (CharSequence)parama.content, this.znW.getTextSize()));
        a.b.d((ImageView)this.FxS, parama.dRL);
        localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
        localObject1 = j.b.fod().aSw(parama.dRL);
        if (localObject1 == null) {
          break label707;
        }
      }
      label670:
      label681:
      label692:
      label697:
      label707:
      for (boolean bool = ((f)localObject1).frA();; bool = false)
      {
        this.FxS.setShowStoryHint(bool);
        this.FxS.aSD(parama.dRL);
        localObject1 = this.FxS;
        paramInt = i;
        if (parama.FnX) {
          paramInt = this.FxS.getResources().getColor(2131101195);
        }
        ((CommentAvatarImageView)localObject1).setHintBg(paramInt);
        this.FxS.setOnClickListener((View.OnClickListener)new c(this, parama));
        return;
        localObject1 = this.maskView.getBackground();
        p.g(localObject1, "bg");
        localObject2 = this.aus;
        p.g(localObject2, "itemView");
        localObject2 = ((CommentItemView)localObject2).getContext();
        p.g(localObject2, "itemView.context");
        ((Drawable)localObject1).setColorFilter((ColorFilter)new PorterDuffColorFilter(((Context)localObject2).getResources().getColor(2131101195), PorterDuff.Mode.SRC_ATOP));
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
    
    public abstract View frT();
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(e.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(119728);
        View localView = this.FxU.aus;
        p.g(localView, "itemView");
        localView.setVisibility(0);
        AppMethodBeat.o(119728);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(e.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119729);
        b localb = new b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder$onBind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramView = this.FxU.FxT.FxO;
        if (paramView != null) {
          paramView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder$onBind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119729);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(e.a parama, com.tencent.mm.plugin.story.f.b.a parama1) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119730);
        Object localObject = new b();
        ((b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        paramView = new Intent();
        paramView.putExtra("Contact_User", parama.dRL);
        paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
        localObject = this.FxU.aus;
        p.g(localObject, "itemView");
        c.b(((View)localObject).getContext(), "profile", ".ui.ContactInfoUI", paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119730);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$Companion;", "", "()V", "ViewTypeBubble", "", "ViewTypeNormal", "plugin-story_release"})
  public static final class b {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryBubbleViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
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
      if (parama.FnX) {
        d.f(this.Fxb);
      }
      AppMethodBeat.o(119732);
    }
    
    public final View frT()
    {
      AppMethodBeat.i(119731);
      View localView = this.aus.findViewById(2131308493);
      p.g(localView, "itemView.findViewById(R.…omment_bubble_background)");
      AppMethodBeat.o(119731);
      return localView;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "opTv", "Landroid/widget/TextView;", "getOpTv", "()Landroid/widget/TextView;", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindOpTv", "plugin-story_release"})
  public final class d
    extends e.a
  {
    private final TextView Epm;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(119739);
      this$1 = localObject.findViewById(2131308520);
      p.g(e.this, "itemView.findViewById(R.…story_comment_item_op_tv)");
      this.Epm = ((TextView)e.this);
      AppMethodBeat.o(119739);
    }
    
    public final void a(int paramInt, final com.tencent.mm.plugin.story.f.b.a parama)
    {
      AppMethodBeat.i(119738);
      p.h(parama, "comment");
      super.a(paramInt, parama);
      if (parama.FnX) {
        d.f(this.Fxb);
      }
      Object localObject1;
      Object localObject2;
      if (!parama.FnX)
      {
        localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
        boolean bool = Util.isEqual(j.b.fau(), parama.dRL);
        this.Epm.setVisibility(0);
        if (bool)
        {
          this.Epm.setOnClickListener((View.OnClickListener)new b(this, parama));
          localObject1 = this.Epm;
          localObject2 = this.aus;
          p.g(localObject2, "itemView");
          localObject2 = ((View)localObject2).getContext();
          p.g(localObject2, "itemView.context");
          ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131766477));
          this.Epm.setTextColor(-1);
          d.f(this.Epm);
        }
      }
      for (;;)
      {
        this.aus.setOnClickListener((View.OnClickListener)new a(this, parama));
        AppMethodBeat.o(119738);
        return;
        if ((com.tencent.mm.plugin.story.c.a.a.FkW.fnu()) && ((e.a(e.this)) || (e.b(e.this))))
        {
          this.Epm.setOnClickListener((View.OnClickListener)new c(this, parama));
          localObject1 = this.Epm;
          localObject2 = this.aus;
          p.g(localObject2, "itemView");
          localObject2 = ((View)localObject2).getContext();
          p.g(localObject2, "itemView.context");
          ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131766478));
          this.Epm.setTextColor(-1);
          d.f(this.Epm);
        }
        else
        {
          this.Epm.setVisibility(8);
        }
      }
    }
    
    public final View frT()
    {
      AppMethodBeat.i(119737);
      View localView = this.aus.findViewById(2131308500);
      p.g(localView, "itemView.findViewById(R.…mment_content_background)");
      AppMethodBeat.o(119737);
      return localView;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(e.d paramd, com.tencent.mm.plugin.story.f.b.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119734);
        b localb = new b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((com.tencent.mm.plugin.story.c.a.a.FkW.fnu()) && ((e.a(this.FxW.FxT)) || (e.b(this.FxW.FxT))))
        {
          paramView = com.tencent.mm.plugin.story.f.j.Fmy;
          if (!Util.isEqual(j.b.fau(), parama.dRL))
          {
            paramView = this.FxW.FxT.FxN;
            if (paramView != null) {
              paramView.invoke(parama, Boolean.TRUE);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119734);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(e.d paramd, com.tencent.mm.plugin.story.f.b.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119735);
        b localb = new b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBindOpTv$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramView = this.FxW.FxT.FxN;
        if (paramView != null) {
          paramView.invoke(parama, Boolean.FALSE);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBindOpTv$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119735);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(e.d paramd, com.tencent.mm.plugin.story.f.b.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119736);
        b localb = new b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBindOpTv$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramView = this.FxW.FxT.FxN;
        if (paramView != null) {
          paramView.invoke(parama, Boolean.TRUE);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBindOpTv$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119736);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.e
 * JD-Core Version:    0.7.0.1
 */