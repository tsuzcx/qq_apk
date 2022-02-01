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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import d.g.a.m;
import d.g.b.p;
import d.z;
import java.util.ArrayList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "userList", "Ljava/util/ArrayList;", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "extinfoList", "", "EntranceViewHolder", "EntranceViewTipHolder", "EntranceViewUserHolder", "plugin-story_release"})
public final class StoryEntranceUI$c
  extends RecyclerView.a<a>
{
  final ArrayList<StoryEntranceUI.b> gTw;
  m<? super Integer, ? super StoryEntranceUI.b, z> sLA;
  
  public StoryEntranceUI$c()
  {
    AppMethodBeat.i(119973);
    this.gTw = new ArrayList();
    AppMethodBeat.o(119973);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119969);
    int i = this.gTw.size();
    AppMethodBeat.o(119969);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(119971);
    paramInt = ((StoryEntranceUI.b)this.gTw.get(paramInt)).type;
    AppMethodBeat.o(119971);
    return paramInt;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
  public abstract class a
    extends RecyclerView.w
  {
    public a()
    {
      super();
    }
    
    public abstract void a(StoryEntranceUI.b paramb);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewTipHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
  public final class b
    extends StoryEntranceUI.c.a
  {
    private final TextView heO;
    
    public b()
    {
      super(localObject);
      AppMethodBeat.i(119965);
      this$1 = localObject.findViewById(2131305880);
      p.g(StoryEntranceUI.c.this, "itemView.findViewById(R.id.tip_tv)");
      this.heO = ((TextView)StoryEntranceUI.c.this);
      localObject.setOnClickListener((View.OnClickListener)1.Bpw);
      AppMethodBeat.o(119965);
    }
    
    public final void a(StoryEntranceUI.b paramb)
    {
      AppMethodBeat.i(119964);
      p.h(paramb, "data");
      this.heO.setText(2131763985);
      AppMethodBeat.o(119964);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewUserHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
  public final class c
    extends StoryEntranceUI.c.a
  {
    private final TextView heO;
    private final ImageView jgy;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(119968);
      this$1 = localObject.findViewById(2131297008);
      p.g(StoryEntranceUI.c.this, "itemView.findViewById(R.id.avatar_iv)");
      this.jgy = ((ImageView)StoryEntranceUI.c.this);
      this$1 = localObject.findViewById(2131306244);
      p.g(StoryEntranceUI.c.this, "itemView.findViewById(R.id.user_name_tv)");
      this.heO = ((TextView)StoryEntranceUI.c.this);
      localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(119966);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewUserHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
          int i = this.Bpx.lN();
          paramAnonymousView = StoryEntranceUI.c.a(this.Bpx.Bpv).get(i);
          p.g(paramAnonymousView, "userList[position]");
          paramAnonymousView = (StoryEntranceUI.b)paramAnonymousView;
          localObject = this.Bpx.Bpv.sLA;
          if (localObject != null) {
            ((m)localObject).p(Integer.valueOf(i), paramAnonymousView);
          }
          a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewUserHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(119966);
        }
      });
      AppMethodBeat.o(119968);
    }
    
    public final void a(StoryEntranceUI.b paramb)
    {
      AppMethodBeat.i(119967);
      p.h(paramb, "data");
      a.b.c(this.jgy, paramb.userName);
      Object localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azF().BH(paramb.userName);
      if (localObject != null)
      {
        String str = ((an)localObject).adG();
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = paramb.userName;
      }
      localObject = k.b(this.heO.getContext(), (CharSequence)localObject, this.heO.getTextSize());
      if (StoryEntranceUI.a(StoryEntranceUI.c.this.Bpu).contains(paramb.userName)) {
        this.heO.setTextColor(StoryEntranceUI.c.this.Bpu.getContext().getResources().getColor(2131099660));
      }
      for (;;)
      {
        this.heO.setText((CharSequence)localObject);
        AppMethodBeat.o(119967);
        return;
        this.heO.setTextColor(StoryEntranceUI.c.this.Bpu.getContext().getResources().getColor(2131100711));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI.c
 * JD-Core Version:    0.7.0.1
 */