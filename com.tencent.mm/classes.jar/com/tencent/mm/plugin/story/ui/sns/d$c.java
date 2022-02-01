package com.tencent.mm.plugin.story.ui.sns;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.f.f.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import d.g.a.m;
import d.l;
import d.y;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "extInfoList", "", "EntranceViewHolder", "EntranceViewTipHolder", "EntranceViewUserHolder", "plugin-story_release"})
public final class d$c
  extends RecyclerView.a<a>
{
  final ArrayList<d.b> gxd;
  m<? super Integer, ? super d.b, y> rFB;
  
  public d$c()
  {
    AppMethodBeat.i(119996);
    this.gxd = new ArrayList();
    AppMethodBeat.o(119996);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119992);
    int i = this.gxd.size();
    AppMethodBeat.o(119992);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(119994);
    paramInt = ((d.b)this.gxd.get(paramInt)).type;
    AppMethodBeat.o(119994);
    return paramInt;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
  public abstract class a
    extends RecyclerView.w
  {
    public a()
    {
      super();
    }
    
    public abstract void a(d.b paramb);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewTipHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "itemView", "Landroid/view/View;", "tipId", "", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;I)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "getTipId", "()I", "setTipId", "(I)V", "onBind", "", "position", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
  public final class b
    extends d.c.a
  {
    private final TextView gIq;
    private int zGN;
    
    public b(int paramInt)
    {
      super(paramInt);
      AppMethodBeat.i(119988);
      int i;
      this.zGN = i;
      this$1 = paramInt.findViewById(2131305880);
      d.g.b.k.g(d.c.this, "itemView.findViewById(R.id.tip_tv)");
      this.gIq = ((TextView)d.c.this);
      paramInt.setOnClickListener((View.OnClickListener)1.zGO);
      AppMethodBeat.o(119988);
    }
    
    public final void a(d.b paramb)
    {
      AppMethodBeat.i(119987);
      d.g.b.k.h(paramb, "data");
      this.gIq.setText(this.zGN);
      AppMethodBeat.o(119987);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewUserHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "reply", "getReply", "setReply", "(Landroid/widget/TextView;)V", "star", "getStar", "()Landroid/view/View;", "setStar", "(Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
  public final class c
    extends d.c.a
  {
    private final TextView gIq;
    private final ImageView iKw;
    private View zGP;
    private TextView zGQ;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(119991);
      this$1 = localObject.findViewById(2131297008);
      d.g.b.k.g(d.c.this, "itemView.findViewById(R.id.avatar_iv)");
      this.iKw = ((ImageView)d.c.this);
      this$1 = localObject.findViewById(2131306244);
      d.g.b.k.g(d.c.this, "itemView.findViewById(R.id.user_name_tv)");
      this.gIq = ((TextView)d.c.this);
      this$1 = localObject.findViewById(2131305171);
      d.g.b.k.g(d.c.this, "itemView.findViewById(R.id.star)");
      this.zGP = d.c.this;
      this$1 = localObject.findViewById(2131304083);
      d.g.b.k.g(d.c.this, "itemView.findViewById(R.id.reply_icon)");
      this.zGQ = ((TextView)d.c.this);
      localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(119989);
          int i = this.zGR.lv();
          paramAnonymousView = d.c.a(this.zGR.zGM).get(i);
          d.g.b.k.g(paramAnonymousView, "userList[position]");
          paramAnonymousView = (d.b)paramAnonymousView;
          m localm = this.zGR.zGM.rFB;
          if (localm != null)
          {
            localm.n(Integer.valueOf(i), paramAnonymousView);
            AppMethodBeat.o(119989);
            return;
          }
          AppMethodBeat.o(119989);
        }
      });
      AppMethodBeat.o(119991);
    }
    
    public final void a(d.b paramb)
    {
      int j = 0;
      AppMethodBeat.i(119990);
      d.g.b.k.h(paramb, "data");
      a.b.d(this.iKw, paramb.userName);
      Object localObject1 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
      ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject1).awB().aNt(paramb.userName);
      if (localai != null)
      {
        localObject2 = localai.aaS();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = paramb.userName;
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(this.gIq.getContext(), (CharSequence)localObject1, this.gIq.getTextSize());
      Object localObject2 = this.zGP;
      d.g.b.k.g(localai, "contact");
      if (localai.aaJ())
      {
        i = 0;
        ((View)localObject2).setVisibility(i);
        this.gIq.setText((CharSequence)localObject1);
        localObject1 = this.zGQ;
        if (paramb.type != 5) {
          break label207;
        }
        this.zGQ.setText((CharSequence)String.valueOf(a.zvn.awN(paramb.userName)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.d.c
 * JD-Core Version:    0.7.0.1
 */