package com.tencent.mm.plugin.story.ui.a;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.h.a;
import androidx.recyclerview.widget.h.b;
import androidx.recyclerview.widget.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$CommentViewHolder;", "commentDatas", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "TAG", "", "hasStoryStateMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "onItemClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "commentItem", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "filterFavItem", "filterValidItem", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateComments", "newComments", "", "CommentViewHolder", "plugin-story_release"})
public final class f
  extends RecyclerView.a<a>
{
  public com.tencent.mm.plugin.story.i.j LRO;
  private final HashMap<String, Boolean> LRZ;
  public kotlin.g.a.b<? super com.tencent.mm.plugin.story.f.b.a, x> LSa;
  private final ArrayList<com.tencent.mm.plugin.story.f.b.a> LSb;
  private final String TAG;
  
  public f(ArrayList<com.tencent.mm.plugin.story.f.b.a> paramArrayList)
  {
    AppMethodBeat.i(119765);
    this.LSb = paramArrayList;
    this.TAG = "MicroMsg.StoryCommentListAdapter";
    this.LRZ = new HashMap();
    AppMethodBeat.o(119765);
  }
  
  public final void ah(final List<com.tencent.mm.plugin.story.f.b.a> paramList)
  {
    int i = 1;
    AppMethodBeat.i(119764);
    p.k(paramList, "newComments");
    Log.d(this.TAG, "updateComments");
    Object localObject1 = this.LRZ.entrySet().iterator();
    boolean bool;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      p.j(localObject2, "it.next()");
      localObject2 = (Map.Entry)localObject2;
      Object localObject3 = com.tencent.mm.plugin.story.f.j.LGA;
      if (!Util.isEqual(j.b.fOo(), (String)((Map.Entry)localObject2).getKey()))
      {
        localObject3 = com.tencent.mm.plugin.story.f.j.LGA;
        localObject3 = j.b.gcx();
        Object localObject4 = ((Map.Entry)localObject2).getKey();
        p.j(localObject4, "entry.key");
        localObject3 = ((g)localObject3).bdA((String)localObject4);
        if (localObject3 != null)
        {
          bool = ((com.tencent.mm.plugin.story.i.f)localObject3).gfW();
          label142:
          if (!bool) {
            break label208;
          }
          bool = true;
          label148:
          if (!(p.h(Boolean.valueOf(bool), (Boolean)((Map.Entry)localObject2).getValue()) ^ true)) {
            break label211;
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.LSb.clear();
        this.LSb.addAll((Collection)paramList);
        notifyDataSetChanged();
        AppMethodBeat.o(119764);
        return;
        bool = false;
        break label142;
        label208:
        bool = false;
        break label148;
        label211:
        break;
      }
      localObject1 = h.a((h.a)new d(this, paramList), false);
      p.j(localObject1, "DiffUtil.calculateDiff(o…  }\n            }, false)");
      ((h.b)localObject1).a((s)new c(this, paramList));
      AppMethodBeat.o(119764);
      return;
      i = 0;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119762);
    int i = this.LSb.size();
    AppMethodBeat.o(119762);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$CommentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "unreadPadding", "", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter;Landroid/view/View;I)V", "avatar", "Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "getAvatar", "()Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "onBindAvatar", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "position", "onBindContent", "onBindUsername", "plugin-story_release"})
  public final class a
    extends RecyclerView.v
  {
    final TextView ETn;
    final CommentAvatarImageView LRU;
    final TextView LRd;
    final int LSc;
    
    private a(int paramInt)
    {
      super();
      AppMethodBeat.i(119750);
      int i;
      this.LSc = i;
      this$1 = paramInt.findViewById(a.d.LCb);
      p.j(f.this, "itemView.findViewById(R.…ry_msg_comment_avatar_iv)");
      this.LRU = ((CommentAvatarImageView)f.this);
      this$1 = paramInt.findViewById(a.d.LCd);
      p.j(f.this, "itemView.findViewById(R.…comment_content_username)");
      this.LRd = ((TextView)f.this);
      this$1 = paramInt.findViewById(a.d.LCc);
      p.j(f.this, "itemView.findViewById(R.…_msg_comment_content_msg)");
      this.ETn = ((TextView)f.this);
      AppMethodBeat.o(119750);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(f.a parama, com.tencent.mm.plugin.story.f.b.a parama1) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119749);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$CommentViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramView = new Intent();
        paramView.putExtra("Contact_User", this.LRX.fLi);
        paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
        c.b(this.LSe.LRU.getContext(), "profile", ".ui.ContactInfoUI", paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$CommentViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119749);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(f paramf, com.tencent.mm.plugin.story.f.b.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119752);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if ((f.a(this.LSd)) || (f.b(this.LSd)))
      {
        paramView = this.LSd.LSa;
        if (paramView != null) {
          paramView.invoke(this.LRX);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119752);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$updateComments$1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-story_release"})
  public static final class c
    implements s
  {
    c(List paramList) {}
    
    public final void W(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119755);
      Log.d(f.d(this.LSd), "onInserted position:" + paramInt1 + ", count:" + paramInt2);
      f.c(this.LSd).clear();
      f.c(this.LSd).addAll((Collection)paramList);
      this.LSd.aG(paramInt1, paramInt2);
      AppMethodBeat.o(119755);
    }
    
    public final void ac(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119756);
      Log.d(f.d(this.LSd), "onRemoved position:" + paramInt1 + ", count:" + paramInt2);
      f.c(this.LSd).clear();
      f.c(this.LSd).addAll((Collection)paramList);
      this.LSd.aH(paramInt1, paramInt2);
      AppMethodBeat.o(119756);
    }
    
    public final void ad(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119754);
      Log.d(f.d(this.LSd), "onMoved fromPosition:" + paramInt1 + ", toPosition:" + paramInt2);
      AppMethodBeat.o(119754);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(119753);
      Log.d(f.d(this.LSd), "onChanged position:" + paramInt1 + ", count:" + paramInt2);
      f.c(this.LSd).clear();
      f.c(this.LSd).addAll((Collection)paramList);
      this.LSd.aE(paramInt1, paramInt2);
      AppMethodBeat.o(119753);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$updateComments$result$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"})
  public static final class d
    extends h.a
  {
    d(List paramList) {}
    
    public final boolean Z(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119759);
      if ((((com.tencent.mm.plugin.story.f.b.a)f.c(this.LSd).get(paramInt1)).fXG == ((com.tencent.mm.plugin.story.f.b.a)paramList.get(paramInt2)).fXG) && (((com.tencent.mm.plugin.story.f.b.a)f.c(this.LSd).get(paramInt1)).LHU == ((com.tencent.mm.plugin.story.f.b.a)paramList.get(paramInt2)).LHU))
      {
        AppMethodBeat.o(119759);
        return true;
      }
      AppMethodBeat.o(119759);
      return false;
    }
    
    public final boolean ab(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119760);
      if ((((com.tencent.mm.plugin.story.f.b.a)f.c(this.LSd).get(paramInt1)).LHX == ((com.tencent.mm.plugin.story.f.b.a)paramList.get(paramInt2)).LHX) && (Util.isEqual(((com.tencent.mm.plugin.story.f.b.a)f.c(this.LSd).get(paramInt1)).content, ((com.tencent.mm.plugin.story.f.b.a)paramList.get(paramInt2)).content)))
      {
        AppMethodBeat.o(119760);
        return true;
      }
      AppMethodBeat.o(119760);
      return false;
    }
    
    public final int jL()
    {
      AppMethodBeat.i(119757);
      int i = f.c(this.LSd).size();
      AppMethodBeat.o(119757);
      return i;
    }
    
    public final int jM()
    {
      AppMethodBeat.i(119758);
      int i = paramList.size();
      AppMethodBeat.o(119758);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.f
 * JD-Core Version:    0.7.0.1
 */