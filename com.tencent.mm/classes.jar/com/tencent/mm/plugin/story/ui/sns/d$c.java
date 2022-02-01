package com.tencent.mm.plugin.story.ui.sns;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import d.g.a.m;
import d.g.b.p;
import d.z;
import java.util.ArrayList;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "extInfoList", "", "EntranceViewHolder", "EntranceViewTipHolder", "EntranceViewUserHolder", "plugin-story_release"})
public final class d$c
  extends RecyclerView.a<a>
{
  final ArrayList<d.b> gQO;
  m<? super Integer, ? super d.b, z> sAA;
  
  public d$c()
  {
    AppMethodBeat.i(119996);
    this.gQO = new ArrayList();
    AppMethodBeat.o(119996);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119992);
    int i = this.gQO.size();
    AppMethodBeat.o(119992);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(119994);
    paramInt = ((d.b)this.gQO.get(paramInt)).type;
    AppMethodBeat.o(119994);
    return paramInt;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
  public abstract class a
    extends RecyclerView.w
  {
    public a()
    {
      super();
    }
    
    public abstract void a(d.b paramb);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewTipHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "itemView", "Landroid/view/View;", "tipId", "", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;I)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "getTipId", "()I", "setTipId", "(I)V", "onBind", "", "position", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
  public final class b
    extends d.c.a
  {
    private int AYo;
    private final TextView hca;
    
    public b(int paramInt)
    {
      super(paramInt);
      AppMethodBeat.i(119988);
      int i;
      this.AYo = i;
      this$1 = paramInt.findViewById(2131305880);
      p.g(d.c.this, "itemView.findViewById(R.id.tip_tv)");
      this.hca = ((TextView)d.c.this);
      paramInt.setOnClickListener((View.OnClickListener)1.AYp);
      AppMethodBeat.o(119988);
    }
    
    public final void a(d.b paramb)
    {
      AppMethodBeat.i(119987);
      p.h(paramb, "data");
      this.hca.setText(this.AYo);
      AppMethodBeat.o(119987);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewUserHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "reply", "getReply", "setReply", "(Landroid/widget/TextView;)V", "star", "getStar", "()Landroid/view/View;", "setStar", "(Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
  public final class c
    extends d.c.a
  {
    private View AYq;
    private TextView AYr;
    private final TextView hca;
    private final ImageView jdF;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(119991);
      this$1 = localObject.findViewById(2131297008);
      p.g(d.c.this, "itemView.findViewById(R.id.avatar_iv)");
      this.jdF = ((ImageView)d.c.this);
      this$1 = localObject.findViewById(2131306244);
      p.g(d.c.this, "itemView.findViewById(R.id.user_name_tv)");
      this.hca = ((TextView)d.c.this);
      this$1 = localObject.findViewById(2131305171);
      p.g(d.c.this, "itemView.findViewById(R.id.star)");
      this.AYq = d.c.this;
      this$1 = localObject.findViewById(2131304083);
      p.g(d.c.this, "itemView.findViewById(R.id.reply_icon)");
      this.AYr = ((TextView)d.c.this);
      localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(119989);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewUserHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
          int i = this.AYs.lN();
          paramAnonymousView = d.c.a(this.AYs.AYn).get(i);
          p.g(paramAnonymousView, "userList[position]");
          paramAnonymousView = (d.b)paramAnonymousView;
          localObject = this.AYs.AYn.sAA;
          if (localObject != null) {
            ((m)localObject).p(Integer.valueOf(i), paramAnonymousView);
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
      a.b.d(this.jdF, paramb.userName);
      Object localObject1 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
      am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).azp().Bf(paramb.userName);
      if (localam != null)
      {
        localObject2 = localam.adv();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = paramb.userName;
      }
      localObject1 = k.b(this.hca.getContext(), (CharSequence)localObject1, this.hca.getTextSize());
      Object localObject2 = this.AYq;
      p.g(localam, "contact");
      if (localam.adm())
      {
        i = 0;
        ((View)localObject2).setVisibility(i);
        this.hca.setText((CharSequence)localObject1);
        localObject1 = this.AYr;
        if (paramb.type != 5) {
          break label207;
        }
        this.AYr.setText((CharSequence)String.valueOf(com.tencent.mm.plugin.story.f.f.a.ANj.aBR(paramb.userName)));
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