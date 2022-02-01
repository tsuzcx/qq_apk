package com.tencent.mm.plugin.story.ui.sns;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import d.g.a.m;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "userList", "Ljava/util/ArrayList;", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "extinfoList", "", "EntranceViewHolder", "EntranceViewTipHolder", "EntranceViewUserHolder", "plugin-story_release"})
public final class StoryEntranceUI$c
  extends RecyclerView.a<a>
{
  final ArrayList<StoryEntranceUI.b> gxd;
  m<? super Integer, ? super StoryEntranceUI.b, y> rFB;
  
  public StoryEntranceUI$c()
  {
    AppMethodBeat.i(119973);
    this.gxd = new ArrayList();
    AppMethodBeat.o(119973);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119969);
    int i = this.gxd.size();
    AppMethodBeat.o(119969);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(119971);
    paramInt = ((StoryEntranceUI.b)this.gxd.get(paramInt)).type;
    AppMethodBeat.o(119971);
    return paramInt;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
  public abstract class a
    extends RecyclerView.w
  {
    public a()
    {
      super();
    }
    
    public abstract void a(StoryEntranceUI.b paramb);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewTipHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
  public final class b
    extends StoryEntranceUI.c.a
  {
    private final TextView gIq;
    
    public b()
    {
      super(localObject);
      AppMethodBeat.i(119965);
      this$1 = localObject.findViewById(2131305880);
      d.g.b.k.g(StoryEntranceUI.c.this, "itemView.findViewById(R.id.tip_tv)");
      this.gIq = ((TextView)StoryEntranceUI.c.this);
      localObject.setOnClickListener((View.OnClickListener)1.zGx);
      AppMethodBeat.o(119965);
    }
    
    public final void a(StoryEntranceUI.b paramb)
    {
      AppMethodBeat.i(119964);
      d.g.b.k.h(paramb, "data");
      this.gIq.setText(2131763985);
      AppMethodBeat.o(119964);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewUserHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
  public final class c
    extends StoryEntranceUI.c.a
  {
    private final TextView gIq;
    private final ImageView iKw;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(119968);
      this$1 = localObject.findViewById(2131297008);
      d.g.b.k.g(StoryEntranceUI.c.this, "itemView.findViewById(R.id.avatar_iv)");
      this.iKw = ((ImageView)StoryEntranceUI.c.this);
      this$1 = localObject.findViewById(2131306244);
      d.g.b.k.g(StoryEntranceUI.c.this, "itemView.findViewById(R.id.user_name_tv)");
      this.gIq = ((TextView)StoryEntranceUI.c.this);
      localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(119966);
          int i = this.zGy.lv();
          paramAnonymousView = StoryEntranceUI.c.a(this.zGy.zGw).get(i);
          d.g.b.k.g(paramAnonymousView, "userList[position]");
          paramAnonymousView = (StoryEntranceUI.b)paramAnonymousView;
          m localm = this.zGy.zGw.rFB;
          if (localm != null)
          {
            localm.n(Integer.valueOf(i), paramAnonymousView);
            AppMethodBeat.o(119966);
            return;
          }
          AppMethodBeat.o(119966);
        }
      });
      AppMethodBeat.o(119968);
    }
    
    public final void a(StoryEntranceUI.b paramb)
    {
      AppMethodBeat.i(119967);
      d.g.b.k.h(paramb, "data");
      a.b.c(this.iKw, paramb.userName);
      Object localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).awB().aNt(paramb.userName);
      if (localObject != null)
      {
        String str = ((ai)localObject).aaS();
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = paramb.userName;
      }
      localObject = com.tencent.mm.pluginsdk.ui.span.k.b(this.gIq.getContext(), (CharSequence)localObject, this.gIq.getTextSize());
      if (StoryEntranceUI.a(StoryEntranceUI.c.this.zGv).contains(paramb.userName)) {
        this.gIq.setTextColor(StoryEntranceUI.c.this.zGv.getContext().getResources().getColor(2131099660));
      }
      for (;;)
      {
        this.gIq.setText((CharSequence)localObject);
        AppMethodBeat.o(119967);
        return;
        this.gIq.setTextColor(StoryEntranceUI.c.this.zGv.getContext().getResources().getColor(2131100711));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI.c
 * JD-Core Version:    0.7.0.1
 */