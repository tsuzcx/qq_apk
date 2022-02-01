package com.tencent.mm.plugin.story.ui.a;

import android.content.Intent;
import android.support.v7.h.c;
import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.b.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$CommentViewHolder;", "commentDatas", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "TAG", "", "hasStoryStateMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "onItemClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "commentItem", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "filterFavItem", "filterValidItem", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateComments", "newComments", "", "CommentViewHolder", "plugin-story_release"})
public final class f
  extends RecyclerView.a<a>
{
  private final String TAG;
  public com.tencent.mm.plugin.story.i.j yqB;
  private final HashMap<String, Boolean> yqN;
  public b<? super a, y> yqO;
  private final ArrayList<a> yqP;
  
  public f(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(119765);
    this.yqP = paramArrayList;
    this.TAG = "MicroMsg.StoryCommentListAdapter";
    this.yqN = new HashMap();
    AppMethodBeat.o(119765);
  }
  
  public final void fY(final List<a> paramList)
  {
    int i = 1;
    AppMethodBeat.i(119764);
    k.h(paramList, "newComments");
    ad.d(this.TAG, "updateComments");
    Object localObject1 = this.yqN.entrySet().iterator();
    boolean bool;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      k.g(localObject2, "it.next()");
      localObject2 = (Map.Entry)localObject2;
      Object localObject3 = com.tencent.mm.plugin.story.f.j.yfh;
      if (!bt.kU(j.b.dta(), (String)((Map.Entry)localObject2).getKey()))
      {
        localObject3 = com.tencent.mm.plugin.story.f.j.yfh;
        localObject3 = j.b.dHe();
        Object localObject4 = ((Map.Entry)localObject2).getKey();
        k.g(localObject4, "entry.key");
        localObject3 = ((g)localObject3).arV((String)localObject4);
        if (localObject3 != null)
        {
          bool = ((com.tencent.mm.plugin.story.i.f)localObject3).dKB();
          label147:
          if (!bool) {
            break label214;
          }
          bool = true;
          label153:
          if (!(k.g(Boolean.valueOf(bool), (Boolean)((Map.Entry)localObject2).getValue()) ^ true)) {
            break label217;
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.yqP.clear();
        this.yqP.addAll((Collection)paramList);
        notifyDataSetChanged();
        AppMethodBeat.o(119764);
        return;
        bool = false;
        break label147;
        label214:
        bool = false;
        break label153;
        label217:
        break;
      }
      localObject1 = c.a((c.a)new d(this, paramList), false);
      k.g(localObject1, "DiffUtil.calculateDiff(o…  }\n            }, false)");
      ((c.b)localObject1).a((android.support.v7.h.d)new c(this, paramList));
      AppMethodBeat.o(119764);
      return;
      i = 0;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119762);
    int i = this.yqP.size();
    AppMethodBeat.o(119762);
    return i;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$CommentViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "unreadPadding", "", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter;Landroid/view/View;I)V", "avatar", "Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "getAvatar", "()Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "onBindAvatar", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "position", "onBindContent", "onBindUsername", "plugin-story_release"})
  public final class a
    extends RecyclerView.v
  {
    final TextView twu;
    final TextView ypQ;
    final CommentAvatarImageView yqH;
    final int yqQ;
    
    private a(int paramInt)
    {
      super();
      AppMethodBeat.i(119750);
      int i;
      this.yqQ = i;
      this$1 = paramInt.findViewById(2131305470);
      k.g(f.this, "itemView.findViewById(R.…ry_msg_comment_avatar_iv)");
      this.yqH = ((CommentAvatarImageView)f.this);
      this$1 = paramInt.findViewById(2131305473);
      k.g(f.this, "itemView.findViewById(R.…comment_content_username)");
      this.ypQ = ((TextView)f.this);
      this$1 = paramInt.findViewById(2131305472);
      k.g(f.this, "itemView.findViewById(R.…_msg_comment_content_msg)");
      this.twu = ((TextView)f.this);
      AppMethodBeat.o(119750);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(f.a parama, a parama1) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119749);
        paramView = new Intent();
        paramView.putExtra("Contact_User", this.yqL.dpv);
        paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
        com.tencent.mm.bs.d.b(this.yqS.yqH.getContext(), "profile", ".ui.ContactInfoUI", paramView);
        AppMethodBeat.o(119749);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(f paramf, a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119752);
      if ((f.a(this.yqR)) || (f.b(this.yqR)))
      {
        paramView = this.yqR.yqO;
        if (paramView != null)
        {
          paramView.aA(this.yqL);
          AppMethodBeat.o(119752);
          return;
        }
      }
      AppMethodBeat.o(119752);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$updateComments$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-story_release"})
  public static final class c
    implements android.support.v7.h.d
  {
    c(List paramList) {}
    
    public final void E(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119755);
      ad.d(f.d(this.yqR), "onInserted position:" + paramInt1 + ", count:" + paramInt2);
      f.c(this.yqR).clear();
      f.c(this.yqR).addAll((Collection)paramList);
      this.yqR.aq(paramInt1, paramInt2);
      AppMethodBeat.o(119755);
    }
    
    public final void F(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119756);
      ad.d(f.d(this.yqR), "onRemoved position:" + paramInt1 + ", count:" + paramInt2);
      f.c(this.yqR).clear();
      f.c(this.yqR).addAll((Collection)paramList);
      this.yqR.ar(paramInt1, paramInt2);
      AppMethodBeat.o(119756);
    }
    
    public final void G(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119754);
      ad.d(f.d(this.yqR), "onMoved fromPosition:" + paramInt1 + ", toPosition:" + paramInt2);
      AppMethodBeat.o(119754);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(119753);
      ad.d(f.d(this.yqR), "onChanged position:" + paramInt1 + ", count:" + paramInt2);
      f.c(this.yqR).clear();
      f.c(this.yqR).addAll((Collection)paramList);
      this.yqR.ao(paramInt1, paramInt2);
      AppMethodBeat.o(119753);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$updateComments$result$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"})
  public static final class d
    extends c.a
  {
    d(List paramList) {}
    
    public final boolean H(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119759);
      if ((((a)f.c(this.yqR).get(paramInt1)).dAu == ((a)paramList.get(paramInt2)).dAu) && (((a)f.c(this.yqR).get(paramInt1)).ygE == ((a)paramList.get(paramInt2)).ygE))
      {
        AppMethodBeat.o(119759);
        return true;
      }
      AppMethodBeat.o(119759);
      return false;
    }
    
    public final boolean I(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119760);
      if ((((a)f.c(this.yqR).get(paramInt1)).ygI == ((a)paramList.get(paramInt2)).ygI) && (bt.kU(((a)f.c(this.yqR).get(paramInt1)).content, ((a)paramList.get(paramInt2)).content)))
      {
        AppMethodBeat.o(119760);
        return true;
      }
      AppMethodBeat.o(119760);
      return false;
    }
    
    public final int gR()
    {
      AppMethodBeat.i(119757);
      int i = f.c(this.yqR).size();
      AppMethodBeat.o(119757);
      return i;
    }
    
    public final int gS()
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