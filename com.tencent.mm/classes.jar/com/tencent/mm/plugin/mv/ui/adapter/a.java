package com.tencent.mm.plugin.mv.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView;
import com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView.b;
import com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView.c;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$MusicLyricViewHolder;", "itemClickListener", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;", "(Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemClickListener", "()Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "list", "", "MusicLyricViewHolder", "OnItemClickListener", "plugin-mv_release"})
public final class a
  extends RecyclerView.a<a>
{
  final b ArD;
  private final String TAG;
  public final ArrayList<String> kgc;
  
  public a(b paramb)
  {
    AppMethodBeat.i(256964);
    this.ArD = paramb;
    this.TAG = "MicroMsg.MusicLyricAdapter";
    this.kgc = new ArrayList();
    AppMethodBeat.o(256964);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(256963);
    int i = this.kgc.size();
    AppMethodBeat.o(256963);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$MusicLyricViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter;Landroid/view/View;)V", "textView", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "kotlin.jvm.PlatformType", "getTextView", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "plugin-mv_release"})
  public final class a
    extends RecyclerView.v
  {
    final MusicMvMarqueeTextView ArE;
    
    public a()
    {
      super();
      AppMethodBeat.i(256960);
      this.ArE = ((MusicMvMarqueeTextView)localObject.findViewById(2131304295));
      this.ArE.setTextSize(com.tencent.mm.cb.a.fromDPToPix(localObject.getContext(), 22));
      this$1 = this.ArE;
      Context localContext = localObject.getContext();
      p.g(localContext, "itemView.context");
      a.this.setTextColor(localContext.getResources().getColor(2131099844));
      this$1 = new MusicMvMarqueeTextView.c(this.ArE.getViewProvider());
      this.ArE.setEffect((MusicMvMarqueeTextView.b)a.this);
      localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(256959);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$MusicLyricViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = this.ArG.ArF.ArD;
          this.ArG.lR();
          paramAnonymousView.cVN();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$MusicLyricViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(256959);
        }
      });
      AppMethodBeat.o(256960);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;", "", "onClick", "", "position", "", "plugin-mv_release"})
  public static abstract interface b
  {
    public abstract void cVN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.adapter.a
 * JD-Core Version:    0.7.0.1
 */