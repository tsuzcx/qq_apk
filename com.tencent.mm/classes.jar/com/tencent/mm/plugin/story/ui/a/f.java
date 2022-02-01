package com.tencent.mm.plugin.story.ui.a;

import android.content.Intent;
import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import android.support.v7.h.d;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$CommentViewHolder;", "commentDatas", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "TAG", "", "hasStoryStateMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "onItemClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "commentItem", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "filterFavItem", "filterValidItem", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateComments", "newComments", "", "CommentViewHolder", "plugin-story_release"})
public final class f
  extends RecyclerView.a<a>
{
  public com.tencent.mm.plugin.story.i.j FxM;
  private final HashMap<String, Boolean> FxX;
  public kotlin.g.a.b<? super com.tencent.mm.plugin.story.f.b.a, x> FxY;
  private final ArrayList<com.tencent.mm.plugin.story.f.b.a> FxZ;
  private final String TAG;
  
  public f(ArrayList<com.tencent.mm.plugin.story.f.b.a> paramArrayList)
  {
    AppMethodBeat.i(119765);
    this.FxZ = paramArrayList;
    this.TAG = "MicroMsg.StoryCommentListAdapter";
    this.FxX = new HashMap();
    AppMethodBeat.o(119765);
  }
  
  public final void aj(final List<com.tencent.mm.plugin.story.f.b.a> paramList)
  {
    int i = 1;
    AppMethodBeat.i(119764);
    p.h(paramList, "newComments");
    Log.d(this.TAG, "updateComments");
    Object localObject1 = this.FxX.entrySet().iterator();
    boolean bool;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      p.g(localObject2, "it.next()");
      localObject2 = (Map.Entry)localObject2;
      Object localObject3 = com.tencent.mm.plugin.story.f.j.Fmy;
      if (!Util.isEqual(j.b.fau(), (String)((Map.Entry)localObject2).getKey()))
      {
        localObject3 = com.tencent.mm.plugin.story.f.j.Fmy;
        localObject3 = j.b.fod();
        Object localObject4 = ((Map.Entry)localObject2).getKey();
        p.g(localObject4, "entry.key");
        localObject3 = ((g)localObject3).aSw((String)localObject4);
        if (localObject3 != null)
        {
          bool = ((com.tencent.mm.plugin.story.i.f)localObject3).frA();
          label147:
          if (!bool) {
            break label214;
          }
          bool = true;
          label153:
          if (!(p.j(Boolean.valueOf(bool), (Boolean)((Map.Entry)localObject2).getValue()) ^ true)) {
            break label217;
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.FxZ.clear();
        this.FxZ.addAll((Collection)paramList);
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
      localObject1 = android.support.v7.h.c.a((c.a)new d(this, paramList), false);
      p.g(localObject1, "DiffUtil.calculateDiff(o…  }\n            }, false)");
      ((c.b)localObject1).a((d)new c(this, paramList));
      AppMethodBeat.o(119764);
      return;
      i = 0;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119762);
    int i = this.FxZ.size();
    AppMethodBeat.o(119762);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$CommentViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "unreadPadding", "", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter;Landroid/view/View;I)V", "avatar", "Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "getAvatar", "()Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "onBindAvatar", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "position", "onBindContent", "onBindUsername", "plugin-story_release"})
  public final class a
    extends RecyclerView.v
  {
    final CommentAvatarImageView FxS;
    final TextView Fxb;
    final int Fya;
    final TextView znW;
    
    private a(int paramInt)
    {
      super();
      AppMethodBeat.i(119750);
      int i;
      this.Fya = i;
      this$1 = paramInt.findViewById(2131308676);
      p.g(f.this, "itemView.findViewById(R.…ry_msg_comment_avatar_iv)");
      this.FxS = ((CommentAvatarImageView)f.this);
      this$1 = paramInt.findViewById(2131308679);
      p.g(f.this, "itemView.findViewById(R.…comment_content_username)");
      this.Fxb = ((TextView)f.this);
      this$1 = paramInt.findViewById(2131308678);
      p.g(f.this, "itemView.findViewById(R.…_msg_comment_content_msg)");
      this.znW = ((TextView)f.this);
      AppMethodBeat.o(119750);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(f.a parama, com.tencent.mm.plugin.story.f.b.a parama1) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119749);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$CommentViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramView = new Intent();
        paramView.putExtra("Contact_User", this.FxV.dRL);
        paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
        com.tencent.mm.br.c.b(this.Fyc.FxS.getContext(), "profile", ".ui.ContactInfoUI", paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$CommentViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119749);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(f paramf, com.tencent.mm.plugin.story.f.b.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119752);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if ((f.a(this.Fyb)) || (f.b(this.Fyb)))
      {
        paramView = this.Fyb.FxY;
        if (paramView != null) {
          paramView.invoke(this.FxV);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119752);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$updateComments$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-story_release"})
  public static final class c
    implements d
  {
    c(List paramList) {}
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(119753);
      Log.d(f.d(this.Fyb), "onChanged position:" + paramInt1 + ", count:" + paramInt2);
      f.c(this.Fyb).clear();
      f.c(this.Fyb).addAll((Collection)paramList);
      this.Fyb.aq(paramInt1, paramInt2);
      AppMethodBeat.o(119753);
    }
    
    public final void f(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119755);
      Log.d(f.d(this.Fyb), "onInserted position:" + paramInt1 + ", count:" + paramInt2);
      f.c(this.Fyb).clear();
      f.c(this.Fyb).addAll((Collection)paramList);
      this.Fyb.as(paramInt1, paramInt2);
      AppMethodBeat.o(119755);
    }
    
    public final void k(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119756);
      Log.d(f.d(this.Fyb), "onRemoved position:" + paramInt1 + ", count:" + paramInt2);
      f.c(this.Fyb).clear();
      f.c(this.Fyb).addAll((Collection)paramList);
      this.Fyb.at(paramInt1, paramInt2);
      AppMethodBeat.o(119756);
    }
    
    public final void l(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119754);
      Log.d(f.d(this.Fyb), "onMoved fromPosition:" + paramInt1 + ", toPosition:" + paramInt2);
      AppMethodBeat.o(119754);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$updateComments$result$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"})
  public static final class d
    extends c.a
  {
    d(List paramList) {}
    
    public final int aB()
    {
      AppMethodBeat.i(119757);
      int i = f.c(this.Fyb).size();
      AppMethodBeat.o(119757);
      return i;
    }
    
    public final int aC()
    {
      AppMethodBeat.i(119758);
      int i = paramList.size();
      AppMethodBeat.o(119758);
      return i;
    }
    
    public final boolean i(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119759);
      if ((((com.tencent.mm.plugin.story.f.b.a)f.c(this.Fyb).get(paramInt1)).edx == ((com.tencent.mm.plugin.story.f.b.a)paramList.get(paramInt2)).edx) && (((com.tencent.mm.plugin.story.f.b.a)f.c(this.Fyb).get(paramInt1)).FnS == ((com.tencent.mm.plugin.story.f.b.a)paramList.get(paramInt2)).FnS))
      {
        AppMethodBeat.o(119759);
        return true;
      }
      AppMethodBeat.o(119759);
      return false;
    }
    
    public final boolean j(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119760);
      if ((((com.tencent.mm.plugin.story.f.b.a)f.c(this.Fyb).get(paramInt1)).FnW == ((com.tencent.mm.plugin.story.f.b.a)paramList.get(paramInt2)).FnW) && (Util.isEqual(((com.tencent.mm.plugin.story.f.b.a)f.c(this.Fyb).get(paramInt1)).content, ((com.tencent.mm.plugin.story.f.b.a)paramList.get(paramInt2)).content)))
      {
        AppMethodBeat.o(119760);
        return true;
      }
      AppMethodBeat.o(119760);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.f
 * JD-Core Version:    0.7.0.1
 */