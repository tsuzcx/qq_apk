package com.tencent.mm.plugin.story.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "commentRecycler", "Landroid/support/v7/widget/RecyclerView;", "getLayoutId", "", "onCommentsLoaded", "", "comments", "", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "CommentUnreadAdapter", "plugin-story_release"})
public final class StoryCommentsUI
  extends MMActivity
{
  private RecyclerView FwW;
  private a FwX;
  
  public final int getLayoutId()
  {
    return 2131496583;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119638);
    super.onCreate(paramBundle);
    paramBundle = findViewById(2131308530);
    p.g(paramBundle, "findViewById(R.id.story_comment_recycler)");
    this.FwW = ((RecyclerView)paramBundle);
    paramBundle = this.FwW;
    if (paramBundle == null) {
      p.btv("commentRecycler");
    }
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.FwX = new a();
    paramBundle = this.FwW;
    if (paramBundle == null) {
      p.btv("commentRecycler");
    }
    Object localObject = this.FwX;
    if (localObject == null) {
      p.btv("commentAdapter");
    }
    paramBundle.setAdapter((RecyclerView.a)localObject);
    paramBundle = this.FwX;
    if (paramBundle == null) {
      p.btv("commentAdapter");
    }
    paramBundle.uAj = ((m)b.Fxf);
    localObject = new ArrayList();
    paramBundle = this.FwX;
    if (paramBundle == null) {
      p.btv("commentAdapter");
    }
    localObject = (List)localObject;
    p.h(localObject, "storyComments");
    paramBundle.FwY.clear();
    paramBundle.FwY.addAll((Collection)localObject);
    paramBundle.notifyDataSetChanged();
    AppMethodBeat.o(119638);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;)V", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "storyComments", "", "CommentUnreadViewHolder", "plugin-story_release"})
  public final class a
    extends RecyclerView.a<a>
  {
    final ArrayList<com.tencent.mm.plugin.story.f.b.a> FwY;
    m<? super Integer, ? super com.tencent.mm.plugin.story.f.b.a, x> uAj;
    
    public a()
    {
      AppMethodBeat.i(119635);
      this.FwY = new ArrayList();
      AppMethodBeat.o(119635);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(119632);
      int i = this.FwY.size();
      AppMethodBeat.o(119632);
      return i;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "quote", "getQuote", "storyPreview", "getStoryPreview", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
    public final class a
      extends RecyclerView.v
    {
      private final ImageView Fxa;
      final TextView Fxb;
      private final TextView Fxc;
      final ImageView keC;
      final TextView znW;
      
      public a()
      {
        super();
        AppMethodBeat.i(119631);
        this$1 = localObject.findViewById(2131308514);
        p.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…tory_comment_item_avatar)");
        this.keC = ((ImageView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131308521);
        p.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…ory_comment_item_preview)");
        this.Fxa = ((ImageView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131308524);
        p.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…ry_comment_item_username)");
        this.Fxb = ((TextView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131308517);
        p.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…ory_comment_item_content)");
        this.znW = ((TextView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(2131308522);
        p.g(StoryCommentsUI.a.this, "itemView.findViewById(R.…mment_item_quote_content)");
        this.Fxc = ((TextView)StoryCommentsUI.a.this);
        localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(119630);
            Object localObject = new b();
            ((b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
            int i = this.Fxe.lR();
            paramAnonymousView = StoryCommentsUI.a.a(this.Fxe.Fxd).get(i);
            p.g(paramAnonymousView, "comments[position]");
            paramAnonymousView = (com.tencent.mm.plugin.story.f.b.a)paramAnonymousView;
            localObject = this.Fxe.Fxd.uAj;
            if (localObject != null) {
              ((m)localObject).invoke(Integer.valueOf(i), paramAnonymousView);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119630);
          }
        });
        AppMethodBeat.o(119631);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "position", "", "item", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "invoke"})
  static final class b
    extends q
    implements m<Integer, com.tencent.mm.plugin.story.f.b.a, x>
  {
    public static final b Fxf;
    
    static
    {
      AppMethodBeat.i(119637);
      Fxf = new b();
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