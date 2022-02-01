package com.tencent.mm.plugin.story.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "commentRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "getLayoutId", "", "onCommentsLoaded", "", "comments", "", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "CommentUnreadAdapter", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryCommentsUI
  extends MMActivity
{
  private RecyclerView StG;
  private a StH;
  
  public final int getLayoutId()
  {
    return a.e.Sgz;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject2 = null;
    AppMethodBeat.i(119638);
    super.onCreate(paramBundle);
    paramBundle = findViewById(a.d.SeQ);
    s.s(paramBundle, "findViewById(R.id.story_comment_recycler)");
    this.StG = ((RecyclerView)paramBundle);
    paramBundle = this.StG;
    label92:
    Object localObject1;
    if (paramBundle == null)
    {
      s.bIx("commentRecycler");
      paramBundle = null;
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      this.StH = new a();
      paramBundle = this.StG;
      if (paramBundle != null) {
        break label217;
      }
      s.bIx("commentRecycler");
      paramBundle = null;
      a locala = this.StH;
      localObject1 = locala;
      if (locala == null)
      {
        s.bIx("commentAdapter");
        localObject1 = null;
      }
      paramBundle.setAdapter((RecyclerView.a)localObject1);
      paramBundle = this.StH;
      if (paramBundle != null) {
        break label220;
      }
      s.bIx("commentAdapter");
      paramBundle = null;
      label137:
      paramBundle.CyZ = ((m)b.StO);
      localObject1 = new ArrayList();
      paramBundle = this.StH;
      if (paramBundle != null) {
        break label223;
      }
      s.bIx("commentAdapter");
      paramBundle = localObject2;
    }
    label217:
    label220:
    label223:
    for (;;)
    {
      localObject1 = (List)localObject1;
      s.u(localObject1, "storyComments");
      paramBundle.StI.clear();
      paramBundle.StI.addAll((Collection)localObject1);
      paramBundle.bZE.notifyChanged();
      AppMethodBeat.o(119638);
      return;
      break;
      break label92;
      break label137;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;)V", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "storyComments", "", "CommentUnreadViewHolder", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.a<a>
  {
    m<? super Integer, ? super com.tencent.mm.plugin.story.model.b.a, ah> CyZ;
    final ArrayList<com.tencent.mm.plugin.story.model.b.a> StI;
    
    public a()
    {
      AppMethodBeat.i(119635);
      this.StI = new ArrayList();
      AppMethodBeat.o(119635);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(119632);
      int i = this.StI.size();
      AppMethodBeat.o(119632);
      return i;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "quote", "getQuote", "storyPreview", "getStoryPreview", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
    public final class a
      extends RecyclerView.v
    {
      final TextView KNR;
      private final ImageView StK;
      final TextView StL;
      private final TextView StM;
      final ImageView avatar;
      
      public a()
      {
        super();
        AppMethodBeat.i(119631);
        this$1 = localObject.findViewById(a.d.SeC);
        s.s(StoryCommentsUI.a.this, "itemView.findViewById(R.…tory_comment_item_avatar)");
        this.avatar = ((ImageView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(a.d.SeI);
        s.s(StoryCommentsUI.a.this, "itemView.findViewById(R.…ory_comment_item_preview)");
        this.StK = ((ImageView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(a.d.SeK);
        s.s(StoryCommentsUI.a.this, "itemView.findViewById(R.…ry_comment_item_username)");
        this.StL = ((TextView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(a.d.SeF);
        s.s(StoryCommentsUI.a.this, "itemView.findViewById(R.…ory_comment_item_content)");
        this.KNR = ((TextView)StoryCommentsUI.a.this);
        this$1 = localObject.findViewById(a.d.SeJ);
        s.s(StoryCommentsUI.a.this, "itemView.findViewById(R.…mment_item_quote_content)");
        this.StM = ((TextView)StoryCommentsUI.a.this);
        localObject.setOnClickListener(new StoryCommentsUI.a.a..ExternalSyntheticLambda0(this, StoryCommentsUI.a.this));
        AppMethodBeat.o(119631);
      }
      
      private static final void a(a parama, StoryCommentsUI.a parama1, View paramView)
      {
        AppMethodBeat.i(367210);
        Object localObject = new Object();
        b localb = new b();
        localb.cH(parama);
        localb.cH(parama1);
        localb.cH(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
        s.u(parama, "this$0");
        s.u(parama1, "this$1");
        int i = parama.KJ();
        parama = StoryCommentsUI.a.a(parama1).get(i);
        s.s(parama, "comments[position]");
        parama = (com.tencent.mm.plugin.story.model.b.a)parama;
        parama1 = parama1.CyZ;
        if (parama1 != null) {
          parama1.invoke(Integer.valueOf(i), parama);
        }
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(367210);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "position", "", "item", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<Integer, com.tencent.mm.plugin.story.model.b.a, ah>
  {
    public static final b StO;
    
    static
    {
      AppMethodBeat.i(119637);
      StO = new b();
      AppMethodBeat.o(119637);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryCommentsUI
 * JD-Core Version:    0.7.0.1
 */