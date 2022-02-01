package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.e.c;
import com.tencent.mm.plugin.multitask.ui.e.d;
import com.tencent.mm.plugin.multitask.ui.e.f;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.xwalk.core.Log;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/FileMinusScreenRoundCornerConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", "listener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getNickName", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "ui-multitask_release"})
public final class b
  extends d
{
  private final String TAG = "MicroMsg.FileMinusScreenRoundCornerConvert";
  
  public b(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    super(e.d.FJa, parama);
  }
  
  public final String a(Context paramContext, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama)
  {
    AppMethodBeat.i(196124);
    p.k(paramContext, "context");
    p.k(parama, "item");
    parama = parama.FKP.fbc().jmx;
    if (parama != null)
    {
      if (parama == null)
      {
        paramContext = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(196124);
        throw paramContext;
      }
      parama = parama.toUpperCase();
      p.j(parama, "(this as java.lang.String).toUpperCase()");
    }
    for (;;)
    {
      paramContext = p.I(parama, paramContext.getResources().getString(e.f.FJf));
      AppMethodBeat.o(196124);
      return paramContext;
      parama = null;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(196120);
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    AppMethodBeat.o(196120);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(196113);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    super.a(paramRecyclerView, parami, paramInt);
    AppMethodBeat.o(196113);
  }
  
  public final void a(i parami, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(196115);
    p.k(parami, "holder");
    p.k(parama, "item");
    Log.d(this.TAG, "onBindViewHolder");
    super.a(parami, parama, paramInt1, paramInt2, paramBoolean, paramList);
    paramList = (ImageView)parami.amk.findViewById(e.c.FIG);
    paramList.setImageDrawable(null);
    parami = (RoundCornerImageView)parami.amk.findViewById(e.c.FIx);
    p.j(paramList, "avatarImgView");
    paramList.setVisibility(8);
    p.j(parami, "defaultImage");
    parami.setVisibility(0);
    paramList = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.FKR;
    parami.setImageResource(com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.aRc(parama.FKP.fbc().jmx));
    AppMethodBeat.o(196115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.b
 * JD-Core Version:    0.7.0.1
 */