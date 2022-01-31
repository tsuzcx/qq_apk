package com.tencent.mm.plugin.story.ui;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.b.a;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "commentRecycler", "Landroid/support/v7/widget/RecyclerView;", "getLayoutId", "", "onCommentsLoaded", "", "comments", "", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "CommentUnreadAdapter", "plugin-story_release"})
public final class StoryCommentsUI
  extends MMActivity
{
  private RecyclerView sHy;
  private StoryCommentsUI.a sHz;
  
  public final int getLayoutId()
  {
    return 2130970940;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110031);
    super.onCreate(paramBundle);
    paramBundle = findViewById(2131828328);
    j.p(paramBundle, "findViewById(R.id.story_comment_recycler)");
    this.sHy = ((RecyclerView)paramBundle);
    paramBundle = this.sHy;
    if (paramBundle == null) {
      j.ays("commentRecycler");
    }
    paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.sHz = new StoryCommentsUI.a(this);
    paramBundle = this.sHy;
    if (paramBundle == null) {
      j.ays("commentRecycler");
    }
    Object localObject = this.sHz;
    if (localObject == null) {
      j.ays("commentAdapter");
    }
    paramBundle.setAdapter((RecyclerView.a)localObject);
    paramBundle = this.sHz;
    if (paramBundle == null) {
      j.ays("commentAdapter");
    }
    paramBundle.sHB = ((m)b.sHI);
    localObject = new ArrayList();
    paramBundle = this.sHz;
    if (paramBundle == null) {
      j.ays("commentAdapter");
    }
    localObject = (List)localObject;
    j.q(localObject, "storyComments");
    paramBundle.sHA.clear();
    paramBundle.sHA.addAll((Collection)localObject);
    paramBundle.notifyDataSetChanged();
    AppMethodBeat.o(110031);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "quote", "getQuote", "storyPreview", "getStoryPreview", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
  public final class a$a
    extends RecyclerView.v
  {
    final ImageView gxs;
    final TextView oBQ;
    private final ImageView sHD;
    final TextView sHE;
    private final TextView sHF;
    
    public a$a()
    {
      super();
      AppMethodBeat.i(110024);
      this$1 = localObject.findViewById(2131828317);
      j.p(StoryCommentsUI.this, "itemView.findViewById(R.…tory_comment_item_avatar)");
      this.gxs = ((ImageView)StoryCommentsUI.this);
      this$1 = localObject.findViewById(2131828324);
      j.p(StoryCommentsUI.this, "itemView.findViewById(R.…ory_comment_item_preview)");
      this.sHD = ((ImageView)StoryCommentsUI.this);
      this$1 = localObject.findViewById(2131828319);
      j.p(StoryCommentsUI.this, "itemView.findViewById(R.…ry_comment_item_username)");
      this.sHE = ((TextView)StoryCommentsUI.this);
      this$1 = localObject.findViewById(2131828320);
      j.p(StoryCommentsUI.this, "itemView.findViewById(R.…ory_comment_item_content)");
      this.oBQ = ((TextView)StoryCommentsUI.this);
      this$1 = localObject.findViewById(2131828325);
      j.p(StoryCommentsUI.this, "itemView.findViewById(R.…mment_item_quote_content)");
      this.sHF = ((TextView)StoryCommentsUI.this);
      localObject.setOnClickListener((View.OnClickListener)new StoryCommentsUI.a.a.1(this));
      AppMethodBeat.o(110024);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "position", "", "item", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "invoke"})
  static final class b
    extends k
    implements m<Integer, a, y>
  {
    public static final b sHI;
    
    static
    {
      AppMethodBeat.i(110030);
      sHI = new b();
      AppMethodBeat.o(110030);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryCommentsUI
 * JD-Core Version:    0.7.0.1
 */