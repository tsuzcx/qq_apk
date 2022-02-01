package com.tencent.mm.plugin.story.ui.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.g.a;
import androidx.recyclerview.widget.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.story.a.a;
import com.tencent.mm.plugin.story.a.c;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$BubbleViewHolder;", "bubbleDatas", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "TAG", "", "hasStoryStateMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateBubbles", "newBubbles", "", "BubbleViewHolder", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends RecyclerView.a<a>
{
  public final ArrayList<com.tencent.mm.plugin.story.model.b.a> SuL;
  public final HashMap<String, Boolean> Sus;
  public final String TAG;
  
  public l(ArrayList<com.tencent.mm.plugin.story.model.b.a> paramArrayList)
  {
    AppMethodBeat.i(119803);
    this.SuL = paramArrayList;
    this.TAG = "MicroMsg.StoryVisitorListAdapter";
    this.Sus = new HashMap();
    AppMethodBeat.o(119803);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119800);
    int i = this.SuL.size();
    AppMethodBeat.o(119800);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$BubbleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "unreadPadding", "", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter;Landroid/view/View;I)V", "avatar", "Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "getAvatar", "()Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "fromUser", "Landroid/widget/TextView;", "getFromUser", "()Landroid/widget/TextView;", "onBindAvatar", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindUsername", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.v
  {
    final TextView StL;
    private final CommentAvatarImageView Sup;
    private final int Sut;
    
    private a(int paramInt)
    {
      super();
      AppMethodBeat.i(119789);
      int i;
      this.Sut = i;
      this$1 = paramInt.findViewById(a.d.SfJ);
      s.s(l.this, "itemView.findViewById(R.…sg_bubble_item_avatar_iv)");
      this.Sup = ((CommentAvatarImageView)l.this);
      this$1 = paramInt.findViewById(a.d.SfK);
      s.s(l.this, "itemView.findViewById(R.…_bubble_item_username_tv)");
      this.StL = ((TextView)l.this);
      AppMethodBeat.o(119789);
    }
    
    private static final void a(com.tencent.mm.plugin.story.model.b.a parama, a parama1, View paramView)
    {
      AppMethodBeat.i(367319);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(parama);
      localb.cH(parama1);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$BubbleViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "$comment");
      s.u(parama1, "this$0");
      paramView = new Intent();
      paramView.putExtra("Contact_User", parama.hQQ);
      paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
      c.b(parama1.Sup.getContext(), "profile", ".ui.ContactInfoUI", paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$BubbleViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(367319);
    }
    
    public final void b(com.tencent.mm.plugin.story.model.b.a parama)
    {
      boolean bool3 = false;
      AppMethodBeat.i(367324);
      s.u(parama, "comment");
      a.b.h((ImageView)this.Sup, parama.hQQ);
      Object localObject1;
      Object localObject2;
      Object localObject3;
      boolean bool2;
      if (parama.Sly)
      {
        this.Sup.setBackground(this.Sup.getContext().getResources().getDrawable(a.c.Sdb));
        this.Sup.setPadding(this.Sut, this.Sut, this.Sut, this.Sut);
        this.Sup.setHintBg(this.Sup.getContext().getResources().getColor(a.a.ScN));
        localObject1 = (Map)l.c(l.this);
        localObject2 = parama.hQQ;
        localObject3 = StoryCore.SjP;
        bool2 = bool3;
        if (!Util.isEqual(StoryCore.b.hgg(), parama.hQQ))
        {
          localObject3 = StoryCore.SjP;
          localObject3 = StoryCore.b.hvS().bcm(parama.hQQ);
          if (localObject3 != null) {
            break label302;
          }
        }
      }
      label302:
      for (boolean bool1 = false;; bool1 = ((f)localObject3).hzn())
      {
        bool2 = bool3;
        if (bool1) {
          bool2 = true;
        }
        ((Map)localObject1).put(localObject2, Boolean.valueOf(bool2));
        localObject3 = this.Sup;
        localObject2 = (Boolean)l.c(l.this).get(parama.hQQ);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = Boolean.FALSE;
        }
        ((CommentAvatarImageView)localObject3).setShowStoryHint(((Boolean)localObject1).booleanValue());
        this.Sup.bct(parama.hQQ);
        this.Sup.setOnClickListener(new l.a..ExternalSyntheticLambda0(parama, this));
        AppMethodBeat.o(367324);
        return;
        this.Sup.setBackground(null);
        this.Sup.setPadding(0, 0, 0, 0);
        this.Sup.setHintBg(0);
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$updateBubbles$1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements q
  {
    public b(l paraml, List<com.tencent.mm.plugin.story.model.b.a> paramList) {}
    
    public final void aR(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119793);
      Log.d(l.b(this.SuM), "onInserted position:" + paramInt1 + ", count:" + paramInt2);
      l.a(this.SuM).clear();
      l.a(this.SuM).addAll((Collection)this.SuN);
      this.SuM.bA(paramInt1, paramInt2);
      AppMethodBeat.o(119793);
    }
    
    public final void aS(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119794);
      Log.d(l.b(this.SuM), "onRemoved position:" + paramInt1 + ", count:" + paramInt2);
      l.a(this.SuM).clear();
      l.a(this.SuM).addAll((Collection)this.SuN);
      this.SuM.bB(paramInt1, paramInt2);
      AppMethodBeat.o(119794);
    }
    
    public final void aW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119792);
      Log.d(l.b(this.SuM), "onMoved fromPosition:" + paramInt1 + ", toPosition:" + paramInt2);
      AppMethodBeat.o(119792);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(119791);
      Log.d(l.b(this.SuM), "onChanged position:" + paramInt1 + ", count:" + paramInt2);
      l.a(this.SuM).clear();
      l.a(this.SuM).addAll((Collection)this.SuN);
      this.SuM.by(paramInt1, paramInt2);
      AppMethodBeat.o(119791);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$updateBubbles$result$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends g.a
  {
    public c(l paraml, List<com.tencent.mm.plugin.story.model.b.a> paramList) {}
    
    public final int If()
    {
      AppMethodBeat.i(119795);
      int i = l.a(this.SuM).size();
      AppMethodBeat.o(119795);
      return i;
    }
    
    public final int Ig()
    {
      AppMethodBeat.i(119796);
      int i = this.SuN.size();
      AppMethodBeat.o(119796);
      return i;
    }
    
    public final boolean aU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119797);
      if ((((com.tencent.mm.plugin.story.model.b.a)l.a(this.SuM).get(paramInt1)).idH == ((com.tencent.mm.plugin.story.model.b.a)this.SuN.get(paramInt2)).idH) && (((com.tencent.mm.plugin.story.model.b.a)l.a(this.SuM).get(paramInt1)).Slv == ((com.tencent.mm.plugin.story.model.b.a)this.SuN.get(paramInt2)).Slv))
      {
        AppMethodBeat.o(119797);
        return true;
      }
      AppMethodBeat.o(119797);
      return false;
    }
    
    public final boolean aV(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119798);
      if ((((com.tencent.mm.plugin.story.model.b.a)l.a(this.SuM).get(paramInt1)).Sly == ((com.tencent.mm.plugin.story.model.b.a)this.SuN.get(paramInt2)).Sly) && (Util.isEqual(((com.tencent.mm.plugin.story.model.b.a)l.a(this.SuM).get(paramInt1)).content, ((com.tencent.mm.plugin.story.model.b.a)this.SuN.get(paramInt2)).content)))
      {
        AppMethodBeat.o(119798);
        return true;
      }
      AppMethodBeat.o(119798);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.l
 * JD-Core Version:    0.7.0.1
 */