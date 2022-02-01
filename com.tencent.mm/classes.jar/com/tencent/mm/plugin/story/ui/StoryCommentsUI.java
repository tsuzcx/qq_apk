package com.tencent.mm.plugin.story.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "commentRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "getLayoutId", "", "onCommentsLoaded", "", "comments", "", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "CommentUnreadAdapter", "plugin-story_release"})
public final class StoryCommentsUI
  extends MMActivity
{
  private RecyclerView LQY;
  private a LQZ;
  
  public final int getLayoutId()
  {
    return a.e.LCO;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119638);
    super.onCreate(paramBundle);
    paramBundle = findViewById(a.d.LBf);
    p.j(paramBundle, "findViewById(R.id.story_comment_recycler)");
    this.LQY = ((RecyclerView)paramBundle);
    paramBundle = this.LQY;
    if (paramBundle == null) {
      p.bGy("commentRecycler");
    }
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.LQZ = new a();
    paramBundle = this.LQY;
    if (paramBundle == null) {
      p.bGy("commentRecycler");
    }
    Object localObject = this.LQZ;
    if (localObject == null) {
      p.bGy("commentAdapter");
    }
    paramBundle.setAdapter((RecyclerView.a)localObject);
    paramBundle = this.LQZ;
    if (paramBundle == null) {
      p.bGy("commentAdapter");
    }
    paramBundle.yWH = ((m)b.LRh);
    localObject = new ArrayList();
    paramBundle = this.LQZ;
    if (paramBundle == null) {
      p.bGy("commentAdapter");
    }
    localObject = (List)localObject;
    p.k(localObject, "storyComments");
    paramBundle.LRa.clear();
    paramBundle.LRa.addAll((Collection)localObject);
    paramBundle.notifyDataSetChanged();
    AppMethodBeat.o(119638);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;)V", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "storyComments", "", "CommentUnreadViewHolder", "plugin-story_release"})
  public final class a
    extends RecyclerView.a<a>
  {
    final ArrayList<com.tencent.mm.plugin.story.f.b.a> LRa;
    m<? super Integer, ? super com.tencent.mm.plugin.story.f.b.a, x> yWH;
    
    public a()
    {
      AppMethodBeat.i(119635);
      this.LRa = new ArrayList();
      AppMethodBeat.o(119635);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(119632);
      int i = this.LRa.size();
      AppMethodBeat.o(119632);
      return i;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "quote", "getQuote", "storyPreview", "getStoryPreview", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
    public final class a
      extends RecyclerView.v
    {
      final TextView ETn;
      private final ImageView LRc;
      final TextView LRd;
      private final TextView LRe;
      final ImageView mWb;
      
      public a()
      {
        super();
        AppMethodBeat.i(119631);
        this$1 = localObject.findViewById(a.d.LAQ);
        p.j(StoryCommentsUI.a.this, "itemView.findViewById(R.…tory_comment_item_avatar)");
        this.mWb = ((ImageView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(a.d.LAW);
        p.j(StoryCommentsUI.a.this, "itemView.findViewById(R.…ory_comment_item_preview)");
        this.LRc = ((ImageView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(a.d.LAZ);
        p.j(StoryCommentsUI.a.this, "itemView.findViewById(R.…ry_comment_item_username)");
        this.LRd = ((TextView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(a.d.LAT);
        p.j(StoryCommentsUI.a.this, "itemView.findViewById(R.…ory_comment_item_content)");
        this.ETn = ((TextView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(a.d.LAY);
        p.j(StoryCommentsUI.a.this, "itemView.findViewById(R.…mment_item_quote_content)");
        this.LRe = ((TextView)StoryCommentsUI.a.this);
        localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(119630);
            Object localObject = new b();
            ((b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
            int i = this.LRg.md();
            paramAnonymousView = StoryCommentsUI.a.a(this.LRg.LRf).get(i);
            p.j(paramAnonymousView, "comments[position]");
            paramAnonymousView = (com.tencent.mm.plugin.story.f.b.a)paramAnonymousView;
            localObject = this.LRg.LRf.yWH;
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "position", "", "item", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "invoke"})
  static final class b
    extends q
    implements m<Integer, com.tencent.mm.plugin.story.f.b.a, x>
  {
    public static final b LRh;
    
    static
    {
      AppMethodBeat.i(119637);
      LRh = new b();
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