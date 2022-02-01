package com.tencent.mm.plugin.story.ui.a;

import android.content.Intent;
import android.support.v7.h.c;
import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$BubbleViewHolder;", "bubbleDatas", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "TAG", "", "hasStoryStateMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateBubbles", "newBubbles", "", "BubbleViewHolder", "plugin-story_release"})
public final class l
  extends RecyclerView.a<a>
{
  private final HashMap<String, Boolean> AVJ;
  private final ArrayList<com.tencent.mm.plugin.story.f.b.a> AWg;
  private final String TAG;
  
  public l(ArrayList<com.tencent.mm.plugin.story.f.b.a> paramArrayList)
  {
    AppMethodBeat.i(119803);
    this.AWg = paramArrayList;
    this.TAG = "MicroMsg.StoryVisitorListAdapter";
    this.AVJ = new HashMap();
    AppMethodBeat.o(119803);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119800);
    int i = this.AWg.size();
    AppMethodBeat.o(119800);
    return i;
  }
  
  public final void gr(final List<com.tencent.mm.plugin.story.f.b.a> paramList)
  {
    int i = 1;
    AppMethodBeat.i(119802);
    p.h(paramList, "newBubbles");
    ad.d(this.TAG, "updateBubbles");
    Object localObject1 = this.AVJ.entrySet().iterator();
    boolean bool;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      p.g(localObject2, "it.next()");
      localObject2 = (Map.Entry)localObject2;
      Object localObject3 = j.AKb;
      if (!bt.lQ(j.b.dTJ(), (String)((Map.Entry)localObject2).getKey()))
      {
        localObject3 = j.AKb;
        localObject3 = j.b.ehU();
        Object localObject4 = ((Map.Entry)localObject2).getKey();
        p.g(localObject4, "entry.key");
        localObject3 = ((g)localObject3).aCi((String)localObject4);
        if (localObject3 != null)
        {
          bool = ((f)localObject3).elr();
          label147:
          if (!bool) {
            break label214;
          }
          bool = true;
          label153:
          if (!(p.i(Boolean.valueOf(bool), (Boolean)((Map.Entry)localObject2).getValue()) ^ true)) {
            break label217;
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.AWg.clear();
        this.AWg.addAll((Collection)paramList);
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
      localObject1 = c.a((c.a)new c(this, paramList), false);
      p.g(localObject1, "DiffUtil.calculateDiff(o…  }\n            }, false)");
      ((c.b)localObject1).a((android.support.v7.h.d)new b(this, paramList));
      AppMethodBeat.o(119802);
      return;
      i = 0;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$BubbleViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "unreadPadding", "", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter;Landroid/view/View;I)V", "avatar", "Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "getAvatar", "()Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "fromUser", "Landroid/widget/TextView;", "getFromUser", "()Landroid/widget/TextView;", "onBindAvatar", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindUsername", "plugin-story_release"})
  public final class a
    extends RecyclerView.w
  {
    final TextView AUN;
    final CommentAvatarImageView AVE;
    final int AVM;
    
    private a(int paramInt)
    {
      super();
      AppMethodBeat.i(119789);
      int i;
      this.AVM = i;
      this$1 = paramInt.findViewById(2131305466);
      p.g(l.this, "itemView.findViewById(R.…sg_bubble_item_avatar_iv)");
      this.AVE = ((CommentAvatarImageView)l.this);
      this$1 = paramInt.findViewById(2131305468);
      p.g(l.this, "itemView.findViewById(R.…_bubble_item_username_tv)");
      this.AUN = ((TextView)l.this);
      AppMethodBeat.o(119789);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(l.a parama, com.tencent.mm.plugin.story.f.b.a parama1) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119788);
        b localb = new b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$BubbleViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramView = new Intent();
        paramView.putExtra("Contact_User", this.AVH.dyU);
        paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
        com.tencent.mm.bs.d.b(this.AWi.AVE.getContext(), "profile", ".ui.ContactInfoUI", paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$BubbleViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119788);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$updateBubbles$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-story_release"})
  public static final class b
    implements android.support.v7.h.d
  {
    b(List paramList) {}
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(119791);
      ad.d(l.b(this.AWh), "onChanged position:" + paramInt1 + ", count:" + paramInt2);
      l.a(this.AWh).clear();
      l.a(this.AWh).addAll((Collection)paramList);
      this.AWh.ap(paramInt1, paramInt2);
      AppMethodBeat.o(119791);
    }
    
    public final void f(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119793);
      ad.d(l.b(this.AWh), "onInserted position:" + paramInt1 + ", count:" + paramInt2);
      l.a(this.AWh).clear();
      l.a(this.AWh).addAll((Collection)paramList);
      this.AWh.ar(paramInt1, paramInt2);
      AppMethodBeat.o(119793);
    }
    
    public final void k(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119794);
      ad.d(l.b(this.AWh), "onRemoved position:" + paramInt1 + ", count:" + paramInt2);
      l.a(this.AWh).clear();
      l.a(this.AWh).addAll((Collection)paramList);
      this.AWh.as(paramInt1, paramInt2);
      AppMethodBeat.o(119794);
    }
    
    public final void l(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119792);
      ad.d(l.b(this.AWh), "onMoved fromPosition:" + paramInt1 + ", toPosition:" + paramInt2);
      AppMethodBeat.o(119792);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$updateBubbles$result$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"})
  public static final class c
    extends c.a
  {
    c(List paramList) {}
    
    public final int aA()
    {
      AppMethodBeat.i(119796);
      int i = paramList.size();
      AppMethodBeat.o(119796);
      return i;
    }
    
    public final int az()
    {
      AppMethodBeat.i(119795);
      int i = l.a(this.AWh).size();
      AppMethodBeat.o(119795);
      return i;
    }
    
    public final boolean i(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119797);
      if ((((com.tencent.mm.plugin.story.f.b.a)l.a(this.AWh).get(paramInt1)).dKt == ((com.tencent.mm.plugin.story.f.b.a)paramList.get(paramInt2)).dKt) && (((com.tencent.mm.plugin.story.f.b.a)l.a(this.AWh).get(paramInt1)).ALy == ((com.tencent.mm.plugin.story.f.b.a)paramList.get(paramInt2)).ALy))
      {
        AppMethodBeat.o(119797);
        return true;
      }
      AppMethodBeat.o(119797);
      return false;
    }
    
    public final boolean j(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119798);
      if ((((com.tencent.mm.plugin.story.f.b.a)l.a(this.AWh).get(paramInt1)).ALC == ((com.tencent.mm.plugin.story.f.b.a)paramList.get(paramInt2)).ALC) && (bt.lQ(((com.tencent.mm.plugin.story.f.b.a)l.a(this.AWh).get(paramInt1)).content, ((com.tencent.mm.plugin.story.f.b.a)paramList.get(paramInt2)).content)))
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