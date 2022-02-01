package com.tencent.mm.plugin.story.ui.sns;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "extInfoList", "", "EntranceViewHolder", "EntranceViewTipHolder", "EntranceViewUserHolder", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$c
  extends RecyclerView.a<a>
{
  m<? super Integer, ? super d.b, ah> CyZ;
  final ArrayList<d.b> nbM;
  
  public d$c()
  {
    AppMethodBeat.i(119996);
    this.nbM = new ArrayList();
    AppMethodBeat.o(119996);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119992);
    int i = this.nbM.size();
    AppMethodBeat.o(119992);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(119994);
    paramInt = ((d.b)this.nbM.get(paramInt)).type;
    AppMethodBeat.o(119994);
    return paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public abstract class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
    }
    
    public abstract void a(d.b paramb);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewTipHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "itemView", "Landroid/view/View;", "tipId", "", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;I)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "getTipId", "()I", "setTipId", "(I)V", "onBind", "", "position", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends d.c.a
  {
    private int SwE;
    private final TextView noc;
    
    public b(int paramInt)
    {
      super(paramInt);
      AppMethodBeat.i(119988);
      int i;
      this.SwE = i;
      this$1 = paramInt.findViewById(a.d.tip_tv);
      s.s(d.c.this, "itemView.findViewById(R.id.tip_tv)");
      this.noc = ((TextView)d.c.this);
      paramInt.setOnClickListener(d.c.b..ExternalSyntheticLambda0.INSTANCE);
      AppMethodBeat.o(119988);
    }
    
    private static final void dg(View paramView)
    {
      AppMethodBeat.i(367399);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewTipHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewTipHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(367399);
    }
    
    public final void a(d.b paramb)
    {
      AppMethodBeat.i(119987);
      s.u(paramb, "data");
      this.noc.setText(this.SwE);
      AppMethodBeat.o(119987);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewUserHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "reply", "getReply", "setReply", "(Landroid/widget/TextView;)V", "star", "getStar", "()Landroid/view/View;", "setStar", "(Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends d.c.a
  {
    private View SwF;
    private TextView SwG;
    private final ImageView avatar;
    private final TextView noc;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(119991);
      this$1 = localObject.findViewById(a.d.avatar_iv);
      s.s(d.c.this, "itemView.findViewById(R.id.avatar_iv)");
      this.avatar = ((ImageView)d.c.this);
      this$1 = localObject.findViewById(a.d.user_name_tv);
      s.s(d.c.this, "itemView.findViewById(R.id.user_name_tv)");
      this.noc = ((TextView)d.c.this);
      this$1 = localObject.findViewById(a.d.SdM);
      s.s(d.c.this, "itemView.findViewById(R.id.star)");
      this.SwF = d.c.this;
      this$1 = localObject.findViewById(a.d.SdD);
      s.s(d.c.this, "itemView.findViewById(R.id.reply_icon)");
      this.SwG = ((TextView)d.c.this);
      localObject.setOnClickListener(new d.c.c..ExternalSyntheticLambda0(this, d.c.this));
      AppMethodBeat.o(119991);
    }
    
    private static final void a(c paramc, d.c paramc1, View paramView)
    {
      AppMethodBeat.i(367402);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramc);
      localb.cH(paramc1);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewUserHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramc, "this$0");
      s.u(paramc1, "this$1");
      int i = paramc.KJ();
      paramc = d.c.a(paramc1).get(i);
      s.s(paramc, "userList[position]");
      paramc = (d.b)paramc;
      paramc1 = paramc1.CyZ;
      if (paramc1 != null) {
        paramc1.invoke(Integer.valueOf(i), paramc);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewUserHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(367402);
    }
    
    public final void a(d.b paramb)
    {
      int j = 0;
      AppMethodBeat.i(119990);
      s.u(paramb, "data");
      a.b.h(this.avatar, paramb.userName);
      au localau = ((n)h.ax(n.class)).bzA().JE(paramb.userName);
      Object localObject1;
      if (localau == null)
      {
        localObject1 = null;
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = paramb.userName;
        }
        localObject1 = p.b(this.noc.getContext(), (CharSequence)localObject2, this.noc.getTextSize());
        localObject2 = this.SwF;
        if (!localau.aSK()) {
          break label190;
        }
        i = 0;
        label111:
        ((View)localObject2).setVisibility(i);
        this.noc.setText((CharSequence)localObject1);
        localObject1 = this.SwG;
        if (paramb.type != 5) {
          break label195;
        }
        this.SwG.setText((CharSequence)String.valueOf(com.tencent.mm.plugin.story.model.sync.a.SmO.bbW(paramb.userName)));
      }
      label190:
      label195:
      for (int i = j;; i = 8)
      {
        ((TextView)localObject1).setVisibility(i);
        AppMethodBeat.o(119990);
        return;
        localObject1 = localau.aSV();
        break;
        i = 4;
        break label111;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.d.c
 * JD-Core Version:    0.7.0.1
 */