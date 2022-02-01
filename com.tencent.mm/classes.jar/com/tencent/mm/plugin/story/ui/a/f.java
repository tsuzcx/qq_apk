package com.tencent.mm.plugin.story.ui.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.g.a;
import androidx.recyclerview.widget.g.b;
import androidx.recyclerview.widget.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.story.a.c;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$CommentViewHolder;", "commentDatas", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "TAG", "", "hasStoryStateMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "onItemClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "commentItem", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "filterFavItem", "filterValidItem", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateComments", "newComments", "", "CommentViewHolder", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends RecyclerView.a<a>
{
  public kotlin.g.a.b<? super com.tencent.mm.plugin.story.model.b.a, ah> Fau;
  public j Suk;
  private final ArrayList<com.tencent.mm.plugin.story.model.b.a> Sur;
  private final HashMap<String, Boolean> Sus;
  private final String TAG;
  
  public f(ArrayList<com.tencent.mm.plugin.story.model.b.a> paramArrayList)
  {
    AppMethodBeat.i(119765);
    this.Sur = paramArrayList;
    this.TAG = "MicroMsg.StoryCommentListAdapter";
    this.Sus = new HashMap();
    AppMethodBeat.o(119765);
  }
  
  private static final void a(f paramf, com.tencent.mm.plugin.story.model.b.a parama, View paramView)
  {
    AppMethodBeat.i(367340);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramf, "this$0");
    s.u(parama, "$comment");
    paramView = paramf.Suk;
    if ((paramView != null) && (paramView.hzx() == true))
    {
      i = 1;
      if (i == 0)
      {
        paramView = paramf.Suk;
        if ((paramView == null) || (paramView.hzy())) {
          break label190;
        }
        i = 1;
        label112:
        if (i == 0) {
          break label200;
        }
        paramView = paramf.Suk;
        if ((paramView == null) || (paramView.hzw())) {
          break label195;
        }
        i = 1;
        label134:
        if (i == 0) {
          break label200;
        }
      }
    }
    label190:
    label195:
    label200:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramf = paramf.Fau;
        if (paramf != null) {
          paramf.invoke(parama);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(367340);
      return;
      i = 0;
      break;
      i = 0;
      break label112;
      i = 0;
      break label134;
    }
  }
  
  public final void bI(final List<com.tencent.mm.plugin.story.model.b.a> paramList)
  {
    int i = 1;
    AppMethodBeat.i(119764);
    s.u(paramList, "newComments");
    Log.d(this.TAG, "updateComments");
    Object localObject1 = this.Sus.entrySet().iterator();
    Object localObject3;
    boolean bool;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      s.s(localObject2, "it.next()");
      localObject2 = (Map.Entry)localObject2;
      localObject3 = StoryCore.SjP;
      if (!Util.isEqual(StoryCore.b.hgg(), (String)((Map.Entry)localObject2).getKey()))
      {
        localObject3 = StoryCore.SjP;
        localObject3 = StoryCore.b.hvS();
        Object localObject4 = ((Map.Entry)localObject2).getKey();
        s.s(localObject4, "entry.key");
        localObject3 = ((com.tencent.mm.plugin.story.h.g)localObject3).bcm((String)localObject4);
        if (localObject3 == null)
        {
          bool = false;
          label139:
          if (!bool) {
            break label207;
          }
          bool = true;
          label145:
          if (s.p(Boolean.valueOf(bool), ((Map.Entry)localObject2).getValue())) {
            break label210;
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.Sur.clear();
        this.Sur.addAll((Collection)paramList);
        this.bZE.notifyChanged();
        AppMethodBeat.o(119764);
        return;
        bool = ((com.tencent.mm.plugin.story.h.f)localObject3).hzn();
        break label139;
        label207:
        bool = false;
        break label145;
        label210:
        break;
      }
      localObject1 = androidx.recyclerview.widget.g.a((g.a)new c(this, paramList), false);
      s.s(localObject1, "fun updateComments(newCo…       })\n        }\n    }");
      ((g.b)localObject1).a((q)new b(this, paramList));
      AppMethodBeat.o(119764);
      return;
      i = 0;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119762);
    int i = this.Sur.size();
    AppMethodBeat.o(119762);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$CommentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "unreadPadding", "", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter;Landroid/view/View;I)V", "avatar", "Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "getAvatar", "()Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "onBindAvatar", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "position", "onBindContent", "onBindUsername", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.v
  {
    final TextView KNR;
    final TextView StL;
    private final CommentAvatarImageView Sup;
    private final int Sut;
    
    private a(int paramInt)
    {
      super();
      AppMethodBeat.i(119750);
      int i;
      this.Sut = i;
      this$1 = paramInt.findViewById(a.d.SfM);
      s.s(f.this, "itemView.findViewById(R.…ry_msg_comment_avatar_iv)");
      this.Sup = ((CommentAvatarImageView)f.this);
      this$1 = paramInt.findViewById(a.d.SfO);
      s.s(f.this, "itemView.findViewById(R.…comment_content_username)");
      this.StL = ((TextView)f.this);
      this$1 = paramInt.findViewById(a.d.SfN);
      s.s(f.this, "itemView.findViewById(R.…_msg_comment_content_msg)");
      this.KNR = ((TextView)f.this);
      AppMethodBeat.o(119750);
    }
    
    private static final void a(com.tencent.mm.plugin.story.model.b.a parama, a parama1, View paramView)
    {
      AppMethodBeat.i(367322);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.cH(parama1);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$CommentViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "$comment");
      s.u(parama1, "this$0");
      paramView = new Intent();
      paramView.putExtra("Contact_User", parama.hQQ);
      paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
      c.b(parama1.Sup.getContext(), "profile", ".ui.ContactInfoUI", paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$CommentViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(367322);
    }
    
    public final void a(com.tencent.mm.plugin.story.model.b.a parama)
    {
      boolean bool3 = false;
      AppMethodBeat.i(367327);
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
        localObject1 = (Map)f.c(f.this);
        localObject2 = parama.hQQ;
        localObject3 = StoryCore.SjP;
        bool2 = bool3;
        if (!Util.isEqual(StoryCore.b.hgg(), parama.hQQ))
        {
          localObject3 = StoryCore.SjP;
          localObject3 = StoryCore.b.hvS().bcm(parama.hQQ);
          if (localObject3 != null) {
            break label271;
          }
        }
      }
      label271:
      for (boolean bool1 = false;; bool1 = ((com.tencent.mm.plugin.story.h.f)localObject3).hzn())
      {
        bool2 = bool3;
        if (bool1) {
          bool2 = true;
        }
        ((Map)localObject1).put(localObject2, Boolean.valueOf(bool2));
        localObject3 = this.Sup;
        localObject2 = (Boolean)f.c(f.this).get(parama.hQQ);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = Boolean.FALSE;
        }
        ((CommentAvatarImageView)localObject3).setShowStoryHint(((Boolean)localObject1).booleanValue());
        this.Sup.bct(parama.hQQ);
        this.Sup.setOnClickListener(new f.a..ExternalSyntheticLambda0(parama, this));
        AppMethodBeat.o(367327);
        return;
        this.Sup.setBackground(null);
        this.Sup.setPadding(0, 0, 0, 0);
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$updateComments$1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements q
  {
    b(f paramf, List<com.tencent.mm.plugin.story.model.b.a> paramList) {}
    
    public final void aR(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119755);
      Log.d(f.b(this.Suu), "onInserted position:" + paramInt1 + ", count:" + paramInt2);
      f.a(this.Suu).clear();
      f.a(this.Suu).addAll((Collection)paramList);
      this.Suu.bA(paramInt1, paramInt2);
      AppMethodBeat.o(119755);
    }
    
    public final void aS(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119756);
      Log.d(f.b(this.Suu), "onRemoved position:" + paramInt1 + ", count:" + paramInt2);
      f.a(this.Suu).clear();
      f.a(this.Suu).addAll((Collection)paramList);
      this.Suu.bB(paramInt1, paramInt2);
      AppMethodBeat.o(119756);
    }
    
    public final void aW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119754);
      Log.d(f.b(this.Suu), "onMoved fromPosition:" + paramInt1 + ", toPosition:" + paramInt2);
      AppMethodBeat.o(119754);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(119753);
      Log.d(f.b(this.Suu), "onChanged position:" + paramInt1 + ", count:" + paramInt2);
      f.a(this.Suu).clear();
      f.a(this.Suu).addAll((Collection)paramList);
      this.Suu.by(paramInt1, paramInt2);
      AppMethodBeat.o(119753);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$updateComments$result$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends g.a
  {
    c(f paramf, List<com.tencent.mm.plugin.story.model.b.a> paramList) {}
    
    public final int If()
    {
      AppMethodBeat.i(119757);
      int i = f.a(this.Suu).size();
      AppMethodBeat.o(119757);
      return i;
    }
    
    public final int Ig()
    {
      AppMethodBeat.i(119758);
      int i = paramList.size();
      AppMethodBeat.o(119758);
      return i;
    }
    
    public final boolean aU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119759);
      if ((((com.tencent.mm.plugin.story.model.b.a)f.a(this.Suu).get(paramInt1)).idH == ((com.tencent.mm.plugin.story.model.b.a)paramList.get(paramInt2)).idH) && (((com.tencent.mm.plugin.story.model.b.a)f.a(this.Suu).get(paramInt1)).Slv == ((com.tencent.mm.plugin.story.model.b.a)paramList.get(paramInt2)).Slv))
      {
        AppMethodBeat.o(119759);
        return true;
      }
      AppMethodBeat.o(119759);
      return false;
    }
    
    public final boolean aV(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119760);
      if ((((com.tencent.mm.plugin.story.model.b.a)f.a(this.Suu).get(paramInt1)).Sly == ((com.tencent.mm.plugin.story.model.b.a)paramList.get(paramInt2)).Sly) && (Util.isEqual(((com.tencent.mm.plugin.story.model.b.a)f.a(this.Suu).get(paramInt1)).content, ((com.tencent.mm.plugin.story.model.b.a)paramList.get(paramInt2)).content)))
      {
        AppMethodBeat.o(119760);
        return true;
      }
      AppMethodBeat.o(119760);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.f
 * JD-Core Version:    0.7.0.1
 */