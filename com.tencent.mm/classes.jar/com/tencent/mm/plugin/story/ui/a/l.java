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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.f;
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

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$BubbleViewHolder;", "bubbleDatas", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "TAG", "", "hasStoryStateMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateBubbles", "newBubbles", "", "BubbleViewHolder", "plugin-story_release"})
public final class l
  extends RecyclerView.a<a>
{
  private final HashMap<String, Boolean> LRZ;
  private final ArrayList<com.tencent.mm.plugin.story.f.b.a> LSw;
  private final String TAG;
  
  public l(ArrayList<com.tencent.mm.plugin.story.f.b.a> paramArrayList)
  {
    AppMethodBeat.i(119803);
    this.LSw = paramArrayList;
    this.TAG = "MicroMsg.StoryVisitorListAdapter";
    this.LRZ = new HashMap();
    AppMethodBeat.o(119803);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119800);
    int i = this.LSw.size();
    AppMethodBeat.o(119800);
    return i;
  }
  
  public final void jdMethod_if(final List<com.tencent.mm.plugin.story.f.b.a> paramList)
  {
    int i = 1;
    AppMethodBeat.i(119802);
    p.k(paramList, "newBubbles");
    Log.d(this.TAG, "updateBubbles");
    Object localObject1 = this.LRZ.entrySet().iterator();
    boolean bool;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      p.j(localObject2, "it.next()");
      localObject2 = (Map.Entry)localObject2;
      Object localObject3 = j.LGA;
      if (!Util.isEqual(j.b.fOo(), (String)((Map.Entry)localObject2).getKey()))
      {
        localObject3 = j.LGA;
        localObject3 = j.b.gcx();
        Object localObject4 = ((Map.Entry)localObject2).getKey();
        p.j(localObject4, "entry.key");
        localObject3 = ((g)localObject3).bdA((String)localObject4);
        if (localObject3 != null)
        {
          bool = ((f)localObject3).gfW();
          label147:
          if (!bool) {
            break label214;
          }
          bool = true;
          label153:
          if (!(p.h(Boolean.valueOf(bool), (Boolean)((Map.Entry)localObject2).getValue()) ^ true)) {
            break label217;
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.LSw.clear();
        this.LSw.addAll((Collection)paramList);
        notifyDataSetChanged();
        AppMethodBeat.o(119802);
        return;
        bool = false;
        break label147;
        label214:
        bool = false;
        break label153;
        label217:
        break;
      }
      localObject1 = h.a((h.a)new c(this, paramList), false);
      p.j(localObject1, "DiffUtil.calculateDiff(o…  }\n            }, false)");
      ((h.b)localObject1).a((s)new b(this, paramList));
      AppMethodBeat.o(119802);
      return;
      i = 0;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$BubbleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "unreadPadding", "", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter;Landroid/view/View;I)V", "avatar", "Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "getAvatar", "()Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "fromUser", "Landroid/widget/TextView;", "getFromUser", "()Landroid/widget/TextView;", "onBindAvatar", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindUsername", "plugin-story_release"})
  public final class a
    extends RecyclerView.v
  {
    final CommentAvatarImageView LRU;
    final TextView LRd;
    final int LSc;
    
    private a(int paramInt)
    {
      super();
      AppMethodBeat.i(119789);
      int i;
      this.LSc = i;
      this$1 = paramInt.findViewById(a.d.LBY);
      p.j(l.this, "itemView.findViewById(R.…sg_bubble_item_avatar_iv)");
      this.LRU = ((CommentAvatarImageView)l.this);
      this$1 = paramInt.findViewById(a.d.LBZ);
      p.j(l.this, "itemView.findViewById(R.…_bubble_item_username_tv)");
      this.LRd = ((TextView)l.this);
      AppMethodBeat.o(119789);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(l.a parama, com.tencent.mm.plugin.story.f.b.a parama1) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119788);
        b localb = new b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$BubbleViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramView = new Intent();
        paramView.putExtra("Contact_User", this.LRX.fLi);
        paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
        c.b(this.LSy.LRU.getContext(), "profile", ".ui.ContactInfoUI", paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$BubbleViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119788);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$updateBubbles$1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-story_release"})
  public static final class b
    implements s
  {
    b(List paramList) {}
    
    public final void W(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119793);
      Log.d(l.b(this.LSx), "onInserted position:" + paramInt1 + ", count:" + paramInt2);
      l.a(this.LSx).clear();
      l.a(this.LSx).addAll((Collection)paramList);
      this.LSx.aG(paramInt1, paramInt2);
      AppMethodBeat.o(119793);
    }
    
    public final void ac(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119794);
      Log.d(l.b(this.LSx), "onRemoved position:" + paramInt1 + ", count:" + paramInt2);
      l.a(this.LSx).clear();
      l.a(this.LSx).addAll((Collection)paramList);
      this.LSx.aH(paramInt1, paramInt2);
      AppMethodBeat.o(119794);
    }
    
    public final void ad(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119792);
      Log.d(l.b(this.LSx), "onMoved fromPosition:" + paramInt1 + ", toPosition:" + paramInt2);
      AppMethodBeat.o(119792);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(119791);
      Log.d(l.b(this.LSx), "onChanged position:" + paramInt1 + ", count:" + paramInt2);
      l.a(this.LSx).clear();
      l.a(this.LSx).addAll((Collection)paramList);
      this.LSx.aE(paramInt1, paramInt2);
      AppMethodBeat.o(119791);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$updateBubbles$result$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"})
  public static final class c
    extends h.a
  {
    c(List paramList) {}
    
    public final boolean Z(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119797);
      if ((((com.tencent.mm.plugin.story.f.b.a)l.a(this.LSx).get(paramInt1)).fXG == ((com.tencent.mm.plugin.story.f.b.a)paramList.get(paramInt2)).fXG) && (((com.tencent.mm.plugin.story.f.b.a)l.a(this.LSx).get(paramInt1)).LHU == ((com.tencent.mm.plugin.story.f.b.a)paramList.get(paramInt2)).LHU))
      {
        AppMethodBeat.o(119797);
        return true;
      }
      AppMethodBeat.o(119797);
      return false;
    }
    
    public final boolean ab(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119798);
      if ((((com.tencent.mm.plugin.story.f.b.a)l.a(this.LSx).get(paramInt1)).LHX == ((com.tencent.mm.plugin.story.f.b.a)paramList.get(paramInt2)).LHX) && (Util.isEqual(((com.tencent.mm.plugin.story.f.b.a)l.a(this.LSx).get(paramInt1)).content, ((com.tencent.mm.plugin.story.f.b.a)paramList.get(paramInt2)).content)))
      {
        AppMethodBeat.o(119798);
        return true;
      }
      AppMethodBeat.o(119798);
      return false;
    }
    
    public final int jL()
    {
      AppMethodBeat.i(119795);
      int i = l.a(this.LSx).size();
      AppMethodBeat.o(119795);
      return i;
    }
    
    public final int jM()
    {
      AppMethodBeat.i(119796);
      int i = paramList.size();
      AppMethodBeat.o(119796);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.l
 * JD-Core Version:    0.7.0.1
 */