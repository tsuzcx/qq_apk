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
import com.tencent.mm.plugin.story.f.b.a;
import com.tencent.mm.ui.MMActivity;
import d.g.a.m;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "commentRecycler", "Landroid/support/v7/widget/RecyclerView;", "getLayoutId", "", "onCommentsLoaded", "", "comments", "", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "CommentUnreadAdapter", "plugin-story_release"})
public final class StoryCommentsUI
  extends MMActivity
{
  private RecyclerView zDj;
  private a zDk;
  
  public final int getLayoutId()
  {
    return 2131495678;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119638);
    super.onCreate(paramBundle);
    paramBundle = findViewById(2131305325);
    k.g(paramBundle, "findViewById(R.id.story_comment_recycler)");
    this.zDj = ((RecyclerView)paramBundle);
    paramBundle = this.zDj;
    if (paramBundle == null) {
      k.aVY("commentRecycler");
    }
    paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.zDk = new a();
    paramBundle = this.zDj;
    if (paramBundle == null) {
      k.aVY("commentRecycler");
    }
    Object localObject = this.zDk;
    if (localObject == null) {
      k.aVY("commentAdapter");
    }
    paramBundle.setAdapter((RecyclerView.a)localObject);
    paramBundle = this.zDk;
    if (paramBundle == null) {
      k.aVY("commentAdapter");
    }
    paramBundle.rFB = ((m)b.zDs);
    localObject = new ArrayList();
    paramBundle = this.zDk;
    if (paramBundle == null) {
      k.aVY("commentAdapter");
    }
    localObject = (List)localObject;
    k.h(localObject, "storyComments");
    paramBundle.zDl.clear();
    paramBundle.zDl.addAll((Collection)localObject);
    paramBundle.notifyDataSetChanged();
    AppMethodBeat.o(119638);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;)V", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "storyComments", "", "CommentUnreadViewHolder", "plugin-story_release"})
  public final class a
    extends RecyclerView.a<a>
  {
    m<? super Integer, ? super a, y> rFB;
    final ArrayList<a> zDl;
    
    public a()
    {
      AppMethodBeat.i(119635);
      this.zDl = new ArrayList();
      AppMethodBeat.o(119635);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(119632);
      int i = this.zDl.size();
      AppMethodBeat.o(119632);
      return i;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "quote", "getQuote", "storyPreview", "getStoryPreview", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
    public final class a
      extends RecyclerView.w
    {
      final ImageView iKw;
      final TextView uEM;
      private final ImageView zDn;
      final TextView zDo;
      private final TextView zDp;
      
      public a()
      {
        super();
        AppMethodBeat.i(119631);
        this$1 = localObject.findViewById(2131305309);
        k.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…tory_comment_item_avatar)");
        this.iKw = ((ImageView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131305316);
        k.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…ory_comment_item_preview)");
        this.zDn = ((ImageView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131305319);
        k.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…ry_comment_item_username)");
        this.zDo = ((TextView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131305312);
        k.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…ory_comment_item_content)");
        this.uEM = ((TextView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131305317);
        k.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…mment_item_quote_content)");
        this.zDp = ((TextView)StoryCommentsUI.a.this);
        localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(119630);
            int i = this.zDr.lv();
            paramAnonymousView = StoryCommentsUI.a.a(this.zDr.zDq).get(i);
            k.g(paramAnonymousView, "comments[position]");
            paramAnonymousView = (a)paramAnonymousView;
            m localm = this.zDr.zDq.rFB;
            if (localm != null)
            {
              localm.n(Integer.valueOf(i), paramAnonymousView);
              AppMethodBeat.o(119630);
              return;
            }
            AppMethodBeat.o(119630);
          }
        });
        AppMethodBeat.o(119631);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "position", "", "item", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "invoke"})
  static final class b
    extends d.g.b.l
    implements m<Integer, a, y>
  {
    public static final b zDs;
    
    static
    {
      AppMethodBeat.i(119637);
      zDs = new b();
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