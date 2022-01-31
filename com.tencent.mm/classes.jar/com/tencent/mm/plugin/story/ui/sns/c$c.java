package com.tencent.mm.plugin.story.ui.sns;

import a.f.a.m;
import a.l;
import a.y;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.model.f.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "extInfoList", "", "EntranceViewHolder", "EntranceViewTipHolder", "EntranceViewUserHolder", "plugin-story_release"})
public final class c$c
  extends RecyclerView.a<c.c.a>
{
  m<? super Integer, ? super c.b, y> sHB;
  final ArrayList<c.b> sKy;
  
  public c$c()
  {
    AppMethodBeat.i(110279);
    this.sKy = new ArrayList();
    AppMethodBeat.o(110279);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(110275);
    int i = this.sKy.size();
    AppMethodBeat.o(110275);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(110277);
    paramInt = ((c.b)this.sKy.get(paramInt)).type;
    AppMethodBeat.o(110277);
    return paramInt;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewUserHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "reply", "getReply", "setReply", "(Landroid/widget/TextView;)V", "star", "getStar", "()Landroid/view/View;", "setStar", "(Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
  public final class c
    extends c.c.a
  {
    private final TextView gMp;
    private final ImageView gxs;
    private View sKT;
    private TextView sKU;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(110274);
      this$1 = localObject.findViewById(2131821210);
      a.f.b.j.p(c.c.this, "itemView.findViewById(R.id.avatar_iv)");
      this.gxs = ((ImageView)c.c.this);
      this$1 = localObject.findViewById(2131826331);
      a.f.b.j.p(c.c.this, "itemView.findViewById(R.id.user_name_tv)");
      this.gMp = ((TextView)c.c.this);
      this$1 = localObject.findViewById(2131828401);
      a.f.b.j.p(c.c.this, "itemView.findViewById(R.id.star)");
      this.sKT = c.c.this;
      this$1 = localObject.findViewById(2131828400);
      a.f.b.j.p(c.c.this, "itemView.findViewById(R.id.reply_icon)");
      this.sKU = ((TextView)c.c.this);
      localObject.setOnClickListener((View.OnClickListener)new c.c.c.1(this));
      AppMethodBeat.o(110274);
    }
    
    public final void a(c.b paramb)
    {
      int j = 0;
      AppMethodBeat.i(110273);
      a.f.b.j.q(paramb, "data");
      a.b.s(this.gxs, paramb.userName);
      Object localObject1 = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
      a.f.b.j.p(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
      ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject1).YA().arw(paramb.userName);
      if (localad != null)
      {
        localObject2 = localad.Of();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = paramb.userName;
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.d.j.b(this.gMp.getContext(), (CharSequence)localObject1, this.gMp.getTextSize());
      Object localObject2 = this.sKT;
      a.f.b.j.p(localad, "contact");
      if (localad.NY())
      {
        i = 0;
        ((View)localObject2).setVisibility(i);
        this.gMp.setText((CharSequence)localObject1);
        localObject1 = this.sKU;
        if (paramb.type != 5) {
          break label207;
        }
        this.sKU.setText((CharSequence)String.valueOf(a.szc.adm(paramb.userName)));
      }
      label207:
      for (int i = j;; i = 8)
      {
        ((TextView)localObject1).setVisibility(i);
        AppMethodBeat.o(110273);
        return;
        i = 4;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.c.c
 * JD-Core Version:    0.7.0.1
 */