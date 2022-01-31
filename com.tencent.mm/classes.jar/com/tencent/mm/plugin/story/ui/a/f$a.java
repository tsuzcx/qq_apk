package com.tencent.mm.plugin.story.ui.a;

import a.l;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.model.b.a;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView;
import com.tencent.mm.plugin.story.ui.view.CommentItemView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "avatar", "Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "getAvatar", "()Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "blankArea", "getBlankArea", "()Landroid/view/View;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "maskView", "getMaskView", "setMaskView", "(Landroid/view/View;)V", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindAvatar", "onBindMask", "onBindUsername", "plugin-story_release"})
public abstract class f$a
  extends RecyclerView.v
{
  private View jbK;
  private final TextView oBQ;
  final TextView sHE;
  private final CommentAvatarImageView sIA;
  private final View sIB;
  
  public f$a(View paramView)
  {
    super(localObject);
    paramView = localObject.findViewById(2131828317);
    a.f.b.j.p(paramView, "itemView.findViewById(R.…tory_comment_item_avatar)");
    this.sIA = ((CommentAvatarImageView)paramView);
    paramView = localObject.findViewById(2131828319);
    a.f.b.j.p(paramView, "itemView.findViewById(R.…ry_comment_item_username)");
    this.sHE = ((TextView)paramView);
    paramView = localObject.findViewById(2131828320);
    a.f.b.j.p(paramView, "itemView.findViewById(R.…ory_comment_item_content)");
    this.oBQ = ((TextView)paramView);
    paramView = localObject.findViewById(2131828322);
    a.f.b.j.p(paramView, "itemView.findViewById(R.…_comment_item_blank_area)");
    this.sIB = paramView;
    this.jbK = cFo();
  }
  
  public void a(int paramInt, a parama)
  {
    boolean bool = false;
    a.f.b.j.q(parama, "comment");
    if ((this.aku instanceof CommentItemView)) {
      ((CommentItemView)this.aku).setComment(parama);
    }
    Object localObject1 = this.aku;
    a.f.b.j.p(localObject1, "itemView");
    ((View)localObject1).setVisibility(4);
    this.aku.post((Runnable)new a(this));
    this.sIB.setOnClickListener((View.OnClickListener)new f.a.b(this));
    Object localObject2;
    label233:
    Object localObject3;
    label317:
    label342:
    Context localContext;
    if ((this.aku instanceof CommentItemView))
    {
      if (parama.sxy)
      {
        localObject1 = this.jbK.getBackground();
        a.f.b.j.p(localObject1, "bg");
        localObject2 = ((CommentItemView)this.aku).getContext();
        a.f.b.j.p(localObject2, "itemView.context");
        ((Drawable)localObject1).setColorFilter((ColorFilter)new PorterDuffColorFilter(((Context)localObject2).getResources().getColor(2131689549), PorterDuff.Mode.SRC_ATOP));
      }
    }
    else
    {
      localObject1 = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
      a.f.b.j.p(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject1).YA().arw(parama.czp);
      localObject2 = this.sHE.getContext();
      if (localObject1 == null) {
        break label670;
      }
      localObject1 = ((ad)localObject1).Of();
      if (localObject1 == null) {
        break label670;
      }
      localObject1 = (CharSequence)localObject1;
      localObject2 = com.tencent.mm.pluginsdk.ui.d.j.b((Context)localObject2, (CharSequence)localObject1, this.sHE.getTextSize());
      localObject1 = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
      a.f.b.j.p(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject1).YA().arw(parama.toUser);
      localObject3 = this.sHE.getContext();
      if (localObject1 == null) {
        break label681;
      }
      localObject1 = ((ad)localObject1).Of();
      if (localObject1 == null) {
        break label681;
      }
      localObject1 = (CharSequence)localObject1;
      localObject1 = com.tencent.mm.pluginsdk.ui.d.j.b((Context)localObject3, (CharSequence)localObject1, this.sHE.getTextSize());
      if (parama.sxD == 0) {
        break label692;
      }
      paramInt = 1;
      localObject3 = this.sHE;
      if (paramInt == 0) {
        break label697;
      }
      localObject2 = new StringBuilder().append(localObject2).append(' ');
      localContext = this.sHE.getContext();
      a.f.b.j.p(localContext, "fromUser.context");
    }
    label670:
    label681:
    label692:
    label697:
    for (localObject1 = (CharSequence)(localContext.getResources().getString(2131297058) + ' ' + localObject1);; localObject1 = (CharSequence)localObject2)
    {
      ((TextView)localObject3).setText((CharSequence)localObject1);
      this.oBQ.setText((CharSequence)com.tencent.mm.pluginsdk.ui.d.j.b(this.oBQ.getContext(), (CharSequence)parama.content, this.oBQ.getTextSize()));
      a.b.s((ImageView)this.sIA, parama.czp);
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      localObject1 = j.b.cAC().adC(parama.czp);
      if (localObject1 != null) {
        bool = ((f)localObject1).cEU();
      }
      this.sIA.setShowStoryHint(bool);
      localObject1 = this.sIA;
      localObject2 = parama.czp;
      a.f.b.j.q(localObject2, "userName");
      ((CommentAvatarImageView)localObject1).sci.dw((String)localObject2, 6);
      if (!TextUtils.equals((CharSequence)((CommentAvatarImageView)localObject1).smP, (CharSequence)localObject2)) {
        ((CommentAvatarImageView)localObject1).smP = ((String)localObject2);
      }
      this.sIA.setWithHintBg(parama.sxz);
      this.sIA.setOnClickListener((View.OnClickListener)new f.a.c(this, parama));
      return;
      localObject1 = this.jbK.getBackground();
      a.f.b.j.p(localObject1, "bg");
      localObject2 = ((CommentItemView)this.aku).getContext();
      a.f.b.j.p(localObject2, "itemView.context");
      ((Drawable)localObject1).setColorFilter((ColorFilter)new PorterDuffColorFilter(((Context)localObject2).getResources().getColor(2131690533), PorterDuff.Mode.SRC_ATOP));
      break;
      localObject1 = (CharSequence)"";
      break label233;
      localObject1 = (CharSequence)"";
      break label317;
      paramInt = 0;
      break label342;
    }
  }
  
  public abstract View cFo();
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(f.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(138850);
      View localView = this.sID.aku;
      a.f.b.j.p(localView, "itemView");
      localView.setVisibility(0);
      AppMethodBeat.o(138850);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.f.a
 * JD-Core Version:    0.7.0.1
 */