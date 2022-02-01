package com.tencent.mm.plugin.story.ui.sns;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "extInfoList", "", "EntranceViewHolder", "EntranceViewTipHolder", "EntranceViewUserHolder", "plugin-story_release"})
public final class d$c
  extends RecyclerView.a<a>
{
  final ArrayList<d.b> hKT;
  m<? super Integer, ? super d.b, x> uAj;
  
  public d$c()
  {
    AppMethodBeat.i(119996);
    this.hKT = new ArrayList();
    AppMethodBeat.o(119996);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119992);
    int i = this.hKT.size();
    AppMethodBeat.o(119992);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(119994);
    paramInt = ((d.b)this.hKT.get(paramInt)).type;
    AppMethodBeat.o(119994);
    return paramInt;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
  public abstract class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
    }
    
    public abstract void a(d.b paramb);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewTipHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "itemView", "Landroid/view/View;", "tipId", "", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;I)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "getTipId", "()I", "setTipId", "(I)V", "onBind", "", "position", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
  public final class b
    extends d.c.a
  {
    private int FAy;
    private final TextView hXC;
    
    public b(int paramInt)
    {
      super(paramInt);
      AppMethodBeat.i(119988);
      int i;
      this.FAy = i;
      this$1 = paramInt.findViewById(2131309163);
      p.g(d.c.this, "itemView.findViewById(R.id.tip_tv)");
      this.hXC = ((TextView)d.c.this);
      paramInt.setOnClickListener((View.OnClickListener)1.FAz);
      AppMethodBeat.o(119988);
    }
    
    public final void a(d.b paramb)
    {
      AppMethodBeat.i(119987);
      p.h(paramb, "data");
      this.hXC.setText(this.FAy);
      AppMethodBeat.o(119987);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewUserHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "reply", "getReply", "setReply", "(Landroid/widget/TextView;)V", "star", "getStar", "()Landroid/view/View;", "setStar", "(Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
  public final class c
    extends d.c.a
  {
    private View FAA;
    private TextView FAB;
    private final TextView hXC;
    private final ImageView keC;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(119991);
      this$1 = localObject.findViewById(2131297134);
      p.g(d.c.this, "itemView.findViewById(R.id.avatar_iv)");
      this.keC = ((ImageView)d.c.this);
      this$1 = localObject.findViewById(2131309643);
      p.g(d.c.this, "itemView.findViewById(R.id.user_name_tv)");
      this.hXC = ((TextView)d.c.this);
      this$1 = localObject.findViewById(2131308358);
      p.g(d.c.this, "itemView.findViewById(R.id.star)");
      this.FAA = d.c.this;
      this$1 = localObject.findViewById(2131306948);
      p.g(d.c.this, "itemView.findViewById(R.id.reply_icon)");
      this.FAB = ((TextView)d.c.this);
      localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(119989);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewUserHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          int i = this.FAC.lR();
          paramAnonymousView = d.c.a(this.FAC.FAx).get(i);
          p.g(paramAnonymousView, "userList[position]");
          paramAnonymousView = (d.b)paramAnonymousView;
          localObject = this.FAC.FAx.uAj;
          if (localObject != null) {
            ((m)localObject).invoke(Integer.valueOf(i), paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewUserHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(119989);
        }
      });
      AppMethodBeat.o(119991);
    }
    
    public final void a(d.b paramb)
    {
      int j = 0;
      AppMethodBeat.i(119990);
      p.h(paramb, "data");
      a.b.d(this.keC, paramb.userName);
      Object localObject1 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
      as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).aSN().Kn(paramb.userName);
      if (localas != null)
      {
        localObject2 = localas.arJ();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = paramb.userName;
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.span.l.b(this.hXC.getContext(), (CharSequence)localObject1, this.hXC.getTextSize());
      Object localObject2 = this.FAA;
      p.g(localas, "contact");
      if (localas.arA())
      {
        i = 0;
        ((View)localObject2).setVisibility(i);
        this.hXC.setText((CharSequence)localObject1);
        localObject1 = this.FAB;
        if (paramb.type != 5) {
          break label207;
        }
        this.FAB.setText((CharSequence)String.valueOf(com.tencent.mm.plugin.story.f.f.a.FpB.aSf(paramb.userName)));
      }
      label207:
      for (int i = j;; i = 8)
      {
        ((TextView)localObject1).setVisibility(i);
        AppMethodBeat.o(119990);
        return;
        i = 4;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.d.c
 * JD-Core Version:    0.7.0.1
 */