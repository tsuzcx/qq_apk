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
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "commentRecycler", "Landroid/support/v7/widget/RecyclerView;", "getLayoutId", "", "onCommentsLoaded", "", "comments", "", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "CommentUnreadAdapter", "plugin-story_release"})
public final class StoryCommentsUI
  extends MMActivity
{
  private RecyclerView AUI;
  private a AUJ;
  
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
    this.AUI = ((RecyclerView)paramBundle);
    paramBundle = this.AUI;
    if (paramBundle == null) {
      p.bcb("commentRecycler");
    }
    paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.AUJ = new a();
    paramBundle = this.AUI;
    if (paramBundle == null) {
      p.bcb("commentRecycler");
    }
    Object localObject = this.AUJ;
    if (localObject == null) {
      p.bcb("commentAdapter");
    }
    paramBundle.setAdapter((RecyclerView.a)localObject);
    paramBundle = this.AUJ;
    if (paramBundle == null) {
      p.bcb("commentAdapter");
    }
    paramBundle.sAA = ((m)b.AUR);
    localObject = new ArrayList();
    paramBundle = this.AUJ;
    if (paramBundle == null) {
      p.bcb("commentAdapter");
    }
    localObject = (List)localObject;
    p.h(localObject, "storyComments");
    paramBundle.AUK.clear();
    paramBundle.AUK.addAll((Collection)localObject);
    paramBundle.notifyDataSetChanged();
    AppMethodBeat.o(119638);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;)V", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "storyComments", "", "CommentUnreadViewHolder", "plugin-story_release"})
  public final class a
    extends RecyclerView.a<a>
  {
    final ArrayList<com.tencent.mm.plugin.story.f.b.a> AUK;
    m<? super Integer, ? super com.tencent.mm.plugin.story.f.b.a, z> sAA;
    
    public a()
    {
      AppMethodBeat.i(119635);
      this.AUK = new ArrayList();
      AppMethodBeat.o(119635);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(119632);
      int i = this.AUK.size();
      AppMethodBeat.o(119632);
      return i;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "quote", "getQuote", "storyPreview", "getStoryPreview", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
    public final class a
      extends RecyclerView.w
    {
      private final ImageView AUM;
      final TextView AUN;
      private final TextView AUO;
      final ImageView jdF;
      final TextView vHM;
      
      public a()
      {
        super();
        AppMethodBeat.i(119631);
        this$1 = localObject.findViewById(2131305309);
        p.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…tory_comment_item_avatar)");
        this.jdF = ((ImageView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131305316);
        p.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…ory_comment_item_preview)");
        this.AUM = ((ImageView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131305319);
        p.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…ry_comment_item_username)");
        this.AUN = ((TextView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131305312);
        p.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…ory_comment_item_content)");
        this.vHM = ((TextView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131305317);
        p.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…mment_item_quote_content)");
        this.AUO = ((TextView)StoryCommentsUI.a.this);
        localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(119630);
            Object localObject = new b();
            ((b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
            int i = this.AUQ.lN();
            paramAnonymousView = StoryCommentsUI.a.a(this.AUQ.AUP).get(i);
            p.g(paramAnonymousView, "comments[position]");
            paramAnonymousView = (com.tencent.mm.plugin.story.f.b.a)paramAnonymousView;
            localObject = this.AUQ.AUP.sAA;
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "position", "", "item", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "invoke"})
  static final class b
    extends q
    implements m<Integer, com.tencent.mm.plugin.story.f.b.a, z>
  {
    public static final b AUR;
    
    static
    {
      AppMethodBeat.i(119637);
      AUR = new b();
      AppMethodBeat.o(119637);
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