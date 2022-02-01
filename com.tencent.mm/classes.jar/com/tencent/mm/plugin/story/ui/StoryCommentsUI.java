package com.tencent.mm.plugin.story.ui;

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
import com.tencent.mm.plugin.story.f.b.a;
import com.tencent.mm.ui.MMActivity;
import d.g.a.m;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "commentRecycler", "Landroid/support/v7/widget/RecyclerView;", "getLayoutId", "", "onCommentsLoaded", "", "comments", "", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "CommentUnreadAdapter", "plugin-story_release"})
public final class StoryCommentsUI
  extends MMActivity
{
  private RecyclerView ypK;
  private a ypL;
  
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
    this.ypK = ((RecyclerView)paramBundle);
    paramBundle = this.ypK;
    if (paramBundle == null) {
      k.aPZ("commentRecycler");
    }
    paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.ypL = new a();
    paramBundle = this.ypK;
    if (paramBundle == null) {
      k.aPZ("commentRecycler");
    }
    Object localObject = this.ypL;
    if (localObject == null) {
      k.aPZ("commentAdapter");
    }
    paramBundle.setAdapter((RecyclerView.a)localObject);
    paramBundle = this.ypL;
    if (paramBundle == null) {
      k.aPZ("commentAdapter");
    }
    paramBundle.ypN = ((m)b.ypU);
    localObject = new ArrayList();
    paramBundle = this.ypL;
    if (paramBundle == null) {
      k.aPZ("commentAdapter");
    }
    localObject = (List)localObject;
    k.h(localObject, "storyComments");
    paramBundle.ypM.clear();
    paramBundle.ypM.addAll((Collection)localObject);
    paramBundle.notifyDataSetChanged();
    AppMethodBeat.o(119638);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;)V", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "storyComments", "", "CommentUnreadViewHolder", "plugin-story_release"})
  public final class a
    extends RecyclerView.a<a>
  {
    final ArrayList<a> ypM;
    m<? super Integer, ? super a, y> ypN;
    
    public a()
    {
      AppMethodBeat.i(119635);
      this.ypM = new ArrayList();
      AppMethodBeat.o(119635);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(119632);
      int i = this.ypM.size();
      AppMethodBeat.o(119632);
      return i;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "quote", "getQuote", "storyPreview", "getStoryPreview", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
    public final class a
      extends RecyclerView.v
    {
      final ImageView ikp;
      final TextView twu;
      private final ImageView ypP;
      final TextView ypQ;
      private final TextView ypR;
      
      public a()
      {
        super();
        AppMethodBeat.i(119631);
        this$1 = localObject.findViewById(2131305309);
        k.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…tory_comment_item_avatar)");
        this.ikp = ((ImageView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131305316);
        k.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…ory_comment_item_preview)");
        this.ypP = ((ImageView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131305319);
        k.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…ry_comment_item_username)");
        this.ypQ = ((TextView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131305312);
        k.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…ory_comment_item_content)");
        this.twu = ((TextView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131305317);
        k.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…mment_item_quote_content)");
        this.ypR = ((TextView)StoryCommentsUI.a.this);
        localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(119630);
            int i = this.ypT.ln();
            paramAnonymousView = StoryCommentsUI.a.a(this.ypT.ypS).get(i);
            k.g(paramAnonymousView, "comments[position]");
            paramAnonymousView = (a)paramAnonymousView;
            m localm = this.ypT.ypS.ypN;
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "position", "", "item", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "invoke"})
  static final class b
    extends d.g.b.l
    implements m<Integer, a, y>
  {
    public static final b ypU;
    
    static
    {
      AppMethodBeat.i(119637);
      ypU = new b();
      AppMethodBeat.o(119637);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryCommentsUI
 * JD-Core Version:    0.7.0.1
 */