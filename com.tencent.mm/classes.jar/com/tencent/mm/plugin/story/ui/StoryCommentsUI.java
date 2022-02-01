package com.tencent.mm.plugin.story.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "commentRecycler", "Landroid/support/v7/widget/RecyclerView;", "getLayoutId", "", "onCommentsLoaded", "", "comments", "", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "CommentUnreadAdapter", "plugin-story_release"})
public final class StoryCommentsUI
  extends MMActivity
{
  private RecyclerView Bmg;
  private a Bmh;
  
  public final int getLayoutId()
  {
    return 2131495678;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119638);
    super.onCreate(paramBundle);
    paramBundle = findViewById(2131305325);
    p.g(paramBundle, "findViewById(R.id.story_comment_recycler)");
    this.Bmg = ((RecyclerView)paramBundle);
    paramBundle = this.Bmg;
    if (paramBundle == null) {
      p.bdF("commentRecycler");
    }
    paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.Bmh = new a();
    paramBundle = this.Bmg;
    if (paramBundle == null) {
      p.bdF("commentRecycler");
    }
    Object localObject = this.Bmh;
    if (localObject == null) {
      p.bdF("commentAdapter");
    }
    paramBundle.setAdapter((RecyclerView.a)localObject);
    paramBundle = this.Bmh;
    if (paramBundle == null) {
      p.bdF("commentAdapter");
    }
    paramBundle.sLA = ((m)StoryCommentsUI.b.Bmp);
    localObject = new ArrayList();
    paramBundle = this.Bmh;
    if (paramBundle == null) {
      p.bdF("commentAdapter");
    }
    localObject = (List)localObject;
    p.h(localObject, "storyComments");
    paramBundle.Bmi.clear();
    paramBundle.Bmi.addAll((Collection)localObject);
    paramBundle.notifyDataSetChanged();
    AppMethodBeat.o(119638);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;)V", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "storyComments", "", "CommentUnreadViewHolder", "plugin-story_release"})
  public final class a
    extends RecyclerView.a<a>
  {
    final ArrayList<com.tencent.mm.plugin.story.f.b.a> Bmi;
    m<? super Integer, ? super com.tencent.mm.plugin.story.f.b.a, z> sLA;
    
    public a()
    {
      AppMethodBeat.i(119635);
      this.Bmi = new ArrayList();
      AppMethodBeat.o(119635);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(119632);
      int i = this.Bmi.size();
      AppMethodBeat.o(119632);
      return i;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "quote", "getQuote", "storyPreview", "getStoryPreview", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
    public final class a
      extends RecyclerView.w
    {
      private final ImageView Bmk;
      final TextView Bml;
      private final TextView Bmm;
      final ImageView jgy;
      final TextView vTQ;
      
      public a()
      {
        super();
        AppMethodBeat.i(119631);
        this$1 = localObject.findViewById(2131305309);
        p.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…tory_comment_item_avatar)");
        this.jgy = ((ImageView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131305316);
        p.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…ory_comment_item_preview)");
        this.Bmk = ((ImageView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131305319);
        p.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…ry_comment_item_username)");
        this.Bml = ((TextView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131305312);
        p.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…ory_comment_item_content)");
        this.vTQ = ((TextView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131305317);
        p.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…mment_item_quote_content)");
        this.Bmm = ((TextView)StoryCommentsUI.a.this);
        localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(119630);
            Object localObject = new b();
            ((b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
            int i = this.Bmo.lN();
            paramAnonymousView = StoryCommentsUI.a.a(this.Bmo.Bmn).get(i);
            p.g(paramAnonymousView, "comments[position]");
            paramAnonymousView = (com.tencent.mm.plugin.story.f.b.a)paramAnonymousView;
            localObject = this.Bmo.Bmn.sLA;
            if (localObject != null) {
              ((m)localObject).p(Integer.valueOf(i), paramAnonymousView);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119630);
          }
        });
        AppMethodBeat.o(119631);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryCommentsUI
 * JD-Core Version:    0.7.0.1
 */