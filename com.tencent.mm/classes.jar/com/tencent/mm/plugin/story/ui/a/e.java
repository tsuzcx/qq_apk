package com.tencent.mm.plugin.story.ui.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.story.a.a;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView;
import com.tencent.mm.plugin.story.ui.view.CommentItemView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "()V", "animStartPosition", "", "animateOnBind", "", "bindMaxPosition", "blankAreaClickListener", "Lkotlin/Function0;", "", "getBlankAreaClickListener", "()Lkotlin/jvm/functions/Function0;", "setBlankAreaClickListener", "(Lkotlin/jvm/functions/Function0;)V", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "replyClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "comment", "isReply", "getReplyClickListener", "()Lkotlin/jvm/functions/Function2;", "setReplyClickListener", "(Lkotlin/jvm/functions/Function2;)V", "filterFavItem", "filterValidItem", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAnimateEnable", "enable", "update", "storyComments", "", "BaseStoryCommentViewHolder", "Companion", "StoryBubbleViewHolder", "StoryCommentViewHolder", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends RecyclerView.a<a>
{
  public static final e.b Sui;
  private static final int Sun = 0;
  private static final int Suo;
  private final ArrayList<com.tencent.mm.plugin.story.model.b.a> StI;
  public boolean Suj;
  public j Suk;
  public m<? super com.tencent.mm.plugin.story.model.b.a, ? super Boolean, ah> Sul;
  public kotlin.g.a.a<ah> Sum;
  
  static
  {
    AppMethodBeat.i(119746);
    Sui = new e.b((byte)0);
    Suo = 1;
    AppMethodBeat.o(119746);
  }
  
  public e()
  {
    AppMethodBeat.i(119745);
    this.StI = new ArrayList();
    AppMethodBeat.o(119745);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119741);
    int i = this.StI.size();
    AppMethodBeat.o(119741);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(119742);
    if (((com.tencent.mm.plugin.story.model.b.a)this.StI.get(paramInt)).Slz)
    {
      paramInt = Suo;
      AppMethodBeat.o(119742);
      return paramInt;
    }
    paramInt = Sun;
    AppMethodBeat.o(119742);
    return paramInt;
  }
  
  public final void hM(List<com.tencent.mm.plugin.story.model.b.a> paramList)
  {
    AppMethodBeat.i(119740);
    s.u(paramList, "storyComments");
    this.StI.clear();
    this.StI.addAll((Collection)paramList);
    AppMethodBeat.o(119740);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "avatar", "Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "getAvatar", "()Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "blankArea", "getBlankArea", "()Landroid/view/View;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "maskView", "getMaskView", "setMaskView", "(Landroid/view/View;)V", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindAvatar", "onBindMask", "onBindUsername", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public abstract class a
    extends RecyclerView.v
  {
    private final TextView KNR;
    private final TextView StL;
    private final CommentAvatarImageView Sup;
    private View maskView;
    private final View niW;
    
    public a()
    {
      super();
      this$1 = localObject.findViewById(a.d.SeC);
      s.s(e.this, "itemView.findViewById(R.…tory_comment_item_avatar)");
      this.Sup = ((CommentAvatarImageView)e.this);
      this$1 = localObject.findViewById(a.d.SeK);
      s.s(e.this, "itemView.findViewById(R.…ry_comment_item_username)");
      this.StL = ((TextView)e.this);
      this$1 = localObject.findViewById(a.d.SeF);
      s.s(e.this, "itemView.findViewById(R.…ory_comment_item_content)");
      this.KNR = ((TextView)e.this);
      this$1 = localObject.findViewById(a.d.SeD);
      s.s(e.this, "itemView.findViewById(R.…_comment_item_blank_area)");
      this.niW = e.this;
      this.maskView = hzH();
    }
    
    private static final void a(com.tencent.mm.plugin.story.model.b.a parama, a parama1, View paramView)
    {
      Object localObject = new Object();
      b localb = new b();
      localb.cH(parama);
      localb.cH(parama1);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "$comment");
      s.u(parama1, "this$0");
      paramView = new Intent();
      paramView.putExtra("Contact_User", parama.hQQ);
      paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
      c.b(parama1.caK.getContext(), "profile", ".ui.ContactInfoUI", paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    }
    
    private static final void a(a parama)
    {
      s.u(parama, "this$0");
      parama.caK.setVisibility(0);
    }
    
    private static final void a(e parame, View paramView)
    {
      Object localObject = new Object();
      b localb = new b();
      localb.cH(parame);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parame, "this$0");
      parame = parame.Sum;
      if (parame != null) {
        parame.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    }
    
    public void a(int paramInt, com.tencent.mm.plugin.story.model.b.a parama)
    {
      int i = 0;
      s.u(parama, "comment");
      if ((this.caK instanceof CommentItemView)) {
        ((CommentItemView)this.caK).setComment(parama);
      }
      this.caK.setVisibility(4);
      this.caK.post(new e.a..ExternalSyntheticLambda2(this));
      this.niW.setOnClickListener(new e.a..ExternalSyntheticLambda1(e.this));
      Object localObject1;
      Object localObject3;
      label174:
      label237:
      Object localObject2;
      if ((this.caK instanceof CommentItemView))
      {
        if (parama.Sly) {
          this.maskView.getBackground().setColorFilter((ColorFilter)new PorterDuffColorFilter(((CommentItemView)this.caK).getContext().getResources().getColor(a.a.Indigo), PorterDuff.Mode.SRC_ATOP));
        }
      }
      else
      {
        localObject1 = ((n)h.ax(n.class)).bzA().JE(parama.hQQ);
        localObject3 = this.StL.getContext();
        if (localObject1 != null) {
          break label526;
        }
        localObject1 = "";
        localObject3 = p.b((Context)localObject3, (CharSequence)localObject1, this.StL.getTextSize());
        localObject1 = ((n)h.ax(n.class)).bzA().JE(parama.toUser);
        Context localContext = this.StL.getContext();
        if (localObject1 != null) {
          break label550;
        }
        localObject1 = "";
        localObject1 = p.b(localContext, (CharSequence)localObject1, this.StL.getTextSize());
        if (parama.SlD == 0) {
          break label574;
        }
        paramInt = 1;
        label265:
        localObject2 = this.StL;
        if (paramInt == 0) {
          break label579;
        }
        localObject1 = (CharSequence)(localObject3 + ' ' + this.StL.getContext().getResources().getString(a.g.app_reply) + ' ' + localObject1);
        label329:
        ((TextView)localObject2).setText((CharSequence)localObject1);
        this.KNR.setText((CharSequence)p.b(this.KNR.getContext(), (CharSequence)parama.content, this.KNR.getTextSize()));
        a.b.h((ImageView)this.Sup, parama.hQQ);
        localObject1 = StoryCore.SjP;
        localObject1 = StoryCore.b.hvS().bcm(parama.hQQ);
        if (localObject1 != null) {
          break label589;
        }
      }
      label526:
      label550:
      label574:
      label579:
      label589:
      for (boolean bool = false;; bool = ((f)localObject1).hzn())
      {
        this.Sup.setShowStoryHint(bool);
        this.Sup.bct(parama.hQQ);
        localObject1 = this.Sup;
        paramInt = i;
        if (parama.Slz) {
          paramInt = this.Sup.getResources().getColor(a.a.ScO);
        }
        ((CommentAvatarImageView)localObject1).setHintBg(paramInt);
        this.Sup.setOnClickListener(new e.a..ExternalSyntheticLambda0(parama, this));
        return;
        this.maskView.getBackground().setColorFilter((ColorFilter)new PorterDuffColorFilter(((CommentItemView)this.caK).getContext().getResources().getColor(a.a.ScO), PorterDuff.Mode.SRC_ATOP));
        break;
        localObject2 = ((au)localObject1).aSV();
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label174;
        }
        localObject1 = "";
        break label174;
        localObject2 = ((au)localObject1).aSV();
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label237;
        }
        localObject1 = "";
        break label237;
        paramInt = 0;
        break label265;
        localObject1 = (CharSequence)localObject3;
        break label329;
      }
    }
    
    public final TextView hzG()
    {
      return this.StL;
    }
    
    public abstract View hzH();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryBubbleViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends e.a
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(119733);
      AppMethodBeat.o(119733);
    }
    
    public final void a(int paramInt, com.tencent.mm.plugin.story.model.b.a parama)
    {
      AppMethodBeat.i(119732);
      s.u(parama, "comment");
      super.a(paramInt, parama);
      if (parama.Slz) {
        d.h(hzG());
      }
      AppMethodBeat.o(119732);
    }
    
    public final View hzH()
    {
      AppMethodBeat.i(119731);
      View localView = this.caK.findViewById(a.d.Sej);
      s.s(localView, "itemView.findViewById(R.…omment_bubble_background)");
      AppMethodBeat.o(119731);
      return localView;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "opTv", "Landroid/widget/TextView;", "getOpTv", "()Landroid/widget/TextView;", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindOpTv", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends e.a
  {
    private final TextView Rcd;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(119739);
      this$1 = localObject.findViewById(a.d.SeH);
      s.s(e.this, "itemView.findViewById(R.…story_comment_item_op_tv)");
      this.Rcd = ((TextView)e.this);
      AppMethodBeat.o(119739);
    }
    
    private static final void a(e parame, com.tencent.mm.plugin.story.model.b.a parama, View paramView)
    {
      AppMethodBeat.i(367353);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(parame);
      localb.cH(parama);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parame, "this$0");
      s.u(parama, "$comment");
      if ((com.tencent.mm.plugin.story.c.a.a.SiJ.hvf()) && ((e.a(parame)) || (e.b(parame))))
      {
        paramView = StoryCore.SjP;
        if (!Util.isEqual(StoryCore.b.hgg(), parama.hQQ))
        {
          parame = parame.Sul;
          if (parame != null) {
            parame.invoke(parama, Boolean.TRUE);
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(367353);
    }
    
    private static final void b(e parame, com.tencent.mm.plugin.story.model.b.a parama, View paramView)
    {
      AppMethodBeat.i(367355);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(parame);
      localb.cH(parama);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parame, "this$0");
      s.u(parama, "$comment");
      parame = parame.Sul;
      if (parame != null) {
        parame.invoke(parama, Boolean.FALSE);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(367355);
    }
    
    private static final void c(e parame, com.tencent.mm.plugin.story.model.b.a parama, View paramView)
    {
      AppMethodBeat.i(367359);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(parame);
      localb.cH(parama);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parame, "this$0");
      s.u(parama, "$comment");
      parame = parame.Sul;
      if (parame != null) {
        parame.invoke(parama, Boolean.TRUE);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(367359);
    }
    
    public final void a(int paramInt, com.tencent.mm.plugin.story.model.b.a parama)
    {
      AppMethodBeat.i(119738);
      s.u(parama, "comment");
      super.a(paramInt, parama);
      if (parama.Slz) {
        d.h(hzG());
      }
      if (!parama.Slz)
      {
        StoryCore.b localb = StoryCore.SjP;
        boolean bool = Util.isEqual(StoryCore.b.hgg(), parama.hQQ);
        this.Rcd.setVisibility(0);
        if (bool)
        {
          this.Rcd.setOnClickListener(new e.d..ExternalSyntheticLambda1(e.this, parama));
          this.Rcd.setText((CharSequence)this.caK.getContext().getResources().getString(a.g.Shr));
          this.Rcd.setTextColor(-1);
          d.h(this.Rcd);
        }
      }
      for (;;)
      {
        this.caK.setOnClickListener(new e.d..ExternalSyntheticLambda0(e.this, parama));
        AppMethodBeat.o(119738);
        return;
        if ((com.tencent.mm.plugin.story.c.a.a.SiJ.hvf()) && ((e.a(e.this)) || (e.b(e.this))))
        {
          this.Rcd.setOnClickListener(new e.d..ExternalSyntheticLambda2(e.this, parama));
          this.Rcd.setText((CharSequence)this.caK.getContext().getResources().getString(a.g.Shs));
          this.Rcd.setTextColor(-1);
          d.h(this.Rcd);
        }
        else
        {
          this.Rcd.setVisibility(8);
        }
      }
    }
    
    public final View hzH()
    {
      AppMethodBeat.i(119737);
      View localView = this.caK.findViewById(a.d.Seq);
      s.s(localView, "itemView.findViewById(R.…mment_content_background)");
      AppMethodBeat.o(119737);
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.e
 * JD-Core Version:    0.7.0.1
 */