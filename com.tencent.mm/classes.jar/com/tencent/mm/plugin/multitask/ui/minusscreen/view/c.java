package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.e;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.e.c;
import com.tencent.mm.plugin.multitask.ui.e.d;
import com.tencent.mm.plugin.multitask.ui.e.f;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.xwalk.core.Log;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/LuggageMinusScreenRoundCornerConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", "listener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getNickName", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "ui-multitask_release"})
public final class c
  extends d
{
  private final String TAG = "MicroMsg.LuggageMinusScreenRoundCornerConvert";
  
  public c(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    super(e.d.FJa, parama);
  }
  
  public final String a(Context paramContext, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama)
  {
    AppMethodBeat.i(196923);
    p.k(paramContext, "context");
    p.k(parama, "item");
    parama = super.a(paramContext, parama);
    if (parama != null)
    {
      if (((CharSequence)parama).length() > 0) {}
      for (int i = 1; i == 1; i = 0)
      {
        AppMethodBeat.o(196923);
        return parama;
      }
    }
    paramContext = paramContext.getResources().getString(e.f.FJj);
    AppMethodBeat.o(196923);
    return paramContext;
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(196919);
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    AppMethodBeat.o(196919);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(196909);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    super.a(paramRecyclerView, parami, paramInt);
    AppMethodBeat.o(196909);
  }
  
  public final void a(i parami, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(196914);
    p.k(parami, "holder");
    p.k(parama, "item");
    Log.d(this.TAG, "onBindViewHolder");
    super.a(parami, parama, paramInt1, paramInt2, paramBoolean, paramList);
    parami = (ImageView)parami.amk.findViewById(e.c.FIG);
    parami.setImageDrawable(null);
    parama = parama.FKP.fbc();
    if (parama != null)
    {
      parama = parama.TIg;
      if (parama != null)
      {
        paramList = e.kMy;
        paramList = e.aRs();
        p.j(parami, "avatarImgView");
        paramList.a(parama, parami, getThumbLoaderOption());
        AppMethodBeat.o(196914);
        return;
      }
    }
    AppMethodBeat.o(196914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.c
 * JD-Core Version:    0.7.0.1
 */