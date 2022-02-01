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
import com.tencent.mm.plugin.story.f.b.a;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$BubbleViewHolder;", "bubbleDatas", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "TAG", "", "hasStoryStateMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateBubbles", "newBubbles", "", "BubbleViewHolder", "plugin-story_release"})
public final class l
  extends RecyclerView.a<a>
{
  private final String TAG;
  private final ArrayList<a> zEH;
  private final HashMap<String, Boolean> zEk;
  
  public l(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(119803);
    this.zEH = paramArrayList;
    this.TAG = "MicroMsg.StoryVisitorListAdapter";
    this.zEk = new HashMap();
    AppMethodBeat.o(119803);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119800);
    int i = this.zEH.size();
    AppMethodBeat.o(119800);
    return i;
  }
  
  public final void gg(final List<a> paramList)
  {
    int i = 1;
    AppMethodBeat.i(119802);
    k.h(paramList, "newBubbles");
    ac.d(this.TAG, "updateBubbles");
    Object localObject1 = this.zEk.entrySet().iterator();
    boolean bool;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      k.g(localObject2, "it.next()");
      localObject2 = (Map.Entry)localObject2;
      Object localObject3 = j.zsh;
      if (!bs.lr(j.b.dHx(), (String)((Map.Entry)localObject2).getKey()))
      {
        localObject3 = j.zsh;
        localObject3 = j.b.dVF();
        Object localObject4 = ((Map.Entry)localObject2).getKey();
        k.g(localObject4, "entry.key");
        localObject3 = ((g)localObject3).axe((String)localObject4);
        if (localObject3 != null)
        {
          bool = ((f)localObject3).dZc();
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
        this.zEH.clear();
        this.zEH.addAll((Collection)paramList);
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
      k.g(localObject1, "DiffUtil.calculateDiff(o…  }\n            }, false)");
      ((c.b)localObject1).a((android.support.v7.h.d)new b(this, paramList));
      AppMethodBeat.o(119802);
      return;
      i = 0;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$BubbleViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "unreadPadding", "", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter;Landroid/view/View;I)V", "avatar", "Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "getAvatar", "()Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "fromUser", "Landroid/widget/TextView;", "getFromUser", "()Landroid/widget/TextView;", "onBindAvatar", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindUsername", "plugin-story_release"})
  public final class a
    extends RecyclerView.w
  {
    final TextView zDo;
    final CommentAvatarImageView zEf;
    final int zEn;
    
    private a(int paramInt)
    {
      super();
      AppMethodBeat.i(119789);
      int i;
      this.zEn = i;
      this$1 = paramInt.findViewById(2131305466);
      k.g(l.this, "itemView.findViewById(R.…sg_bubble_item_avatar_iv)");
      this.zEf = ((CommentAvatarImageView)l.this);
      this$1 = paramInt.findViewById(2131305468);
      k.g(l.this, "itemView.findViewById(R.…_bubble_item_username_tv)");
      this.zDo = ((TextView)l.this);
      AppMethodBeat.o(119789);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(l.a parama, a parama1) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119788);
        paramView = new Intent();
        paramView.putExtra("Contact_User", this.zEi.dng);
        paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
        com.tencent.mm.br.d.b(this.zEJ.zEf.getContext(), "profile", ".ui.ContactInfoUI", paramView);
        AppMethodBeat.o(119788);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$updateBubbles$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-story_release"})
  public static final class b
    implements android.support.v7.h.d
  {
    b(List paramList) {}
    
    public final void E(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119793);
      ac.d(l.b(this.zEI), "onInserted position:" + paramInt1 + ", count:" + paramInt2);
      l.a(this.zEI).clear();
      l.a(this.zEI).addAll((Collection)paramList);
      this.zEI.aq(paramInt1, paramInt2);
      AppMethodBeat.o(119793);
    }
    
    public final void F(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119794);
      ac.d(l.b(this.zEI), "onRemoved position:" + paramInt1 + ", count:" + paramInt2);
      l.a(this.zEI).clear();
      l.a(this.zEI).addAll((Collection)paramList);
      this.zEI.ar(paramInt1, paramInt2);
      AppMethodBeat.o(119794);
    }
    
    public final void G(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119792);
      ac.d(l.b(this.zEI), "onMoved fromPosition:" + paramInt1 + ", toPosition:" + paramInt2);
      AppMethodBeat.o(119792);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(119791);
      ac.d(l.b(this.zEI), "onChanged position:" + paramInt1 + ", count:" + paramInt2);
      l.a(this.zEI).clear();
      l.a(this.zEI).addAll((Collection)paramList);
      this.zEI.ao(paramInt1, paramInt2);
      AppMethodBeat.o(119791);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$updateBubbles$result$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"})
  public static final class c
    extends c.a
  {
    c(List paramList) {}
    
    public final boolean H(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119797);
      if ((((a)l.a(this.zEI).get(paramInt1)).dyg == ((a)paramList.get(paramInt2)).dyg) && (((a)l.a(this.zEI).get(paramInt1)).ztE == ((a)paramList.get(paramInt2)).ztE))
      {
        AppMethodBeat.o(119797);
        return true;
      }
      AppMethodBeat.o(119797);
      return false;
    }
    
    public final boolean I(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119798);
      if ((((a)l.a(this.zEI).get(paramInt1)).ztI == ((a)paramList.get(paramInt2)).ztI) && (bs.lr(((a)l.a(this.zEI).get(paramInt1)).content, ((a)paramList.get(paramInt2)).content)))
      {
        AppMethodBeat.o(119798);
        return true;
      }
      AppMethodBeat.o(119798);
      return false;
    }
    
    public final int gZ()
    {
      AppMethodBeat.i(119795);
      int i = l.a(this.zEI).size();
      AppMethodBeat.o(119795);
      return i;
    }
    
    public final int ha()
    {
      AppMethodBeat.i(119796);
      int i = paramList.size();
      AppMethodBeat.o(119796);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.l
 * JD-Core Version:    0.7.0.1
 */