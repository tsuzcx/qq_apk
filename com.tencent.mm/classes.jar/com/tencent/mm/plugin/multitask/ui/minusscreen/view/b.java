package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.xwalk.core.Log;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/FileMinusScreenRoundCornerConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", "listener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getNickName", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "ui-multitask_release"})
public final class b
  extends d
{
  private final String TAG = "MicroMsg.FileMinusScreenRoundCornerConvert";
  
  public b(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    super(parama);
  }
  
  public final String a(Context paramContext, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama)
  {
    AppMethodBeat.i(236518);
    p.h(paramContext, "context");
    p.h(parama, "item");
    parama = parama.Aen.erh().gCr;
    if (parama != null)
    {
      if (parama == null)
      {
        paramContext = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(236518);
        throw paramContext;
      }
      parama = parama.toUpperCase();
      p.g(parama, "(this as java.lang.String).toUpperCase()");
    }
    for (;;)
    {
      paramContext = p.I(parama, paramContext.getResources().getString(2131763050));
      AppMethodBeat.o(236518);
      return paramContext;
      parama = null;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(236517);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    AppMethodBeat.o(236517);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(236514);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    super.a(paramRecyclerView, paramh, paramInt);
    AppMethodBeat.o(236514);
  }
  
  public final void a(h paramh, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(236515);
    p.h(paramh, "holder");
    p.h(parama, "item");
    Log.d(this.TAG, "onBindViewHolder");
    super.a(paramh, parama, paramInt1, paramInt2, paramBoolean, paramList);
    paramList = (ImageView)paramh.aus.findViewById(2131305004);
    paramList.setImageDrawable(null);
    paramh = (RoundCornerImageView)paramh.aus.findViewById(2131299444);
    p.g(paramList, "avatarImgView");
    paramList.setVisibility(8);
    p.g(paramh, "defaultImage");
    paramh.setVisibility(0);
    paramList = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.Aep;
    paramh.setImageResource(com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.aGN(parama.Aen.erh().gCr));
    AppMethodBeat.o(236515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.b
 * JD-Core Version:    0.7.0.1
 */