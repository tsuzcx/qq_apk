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
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/LuggageMinusScreenRoundCornerConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", "listener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getNickName", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends d
{
  private final String TAG = "MicroMsg.LuggageMinusScreenRoundCornerConvert";
  
  public c(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    super(e.d.LEl, parama);
  }
  
  public final String a(Context paramContext, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama)
  {
    AppMethodBeat.i(304381);
    s.u(paramContext, "context");
    s.u(parama, "item");
    parama = super.a(paramContext, parama);
    if (parama != null) {
      if (((CharSequence)parama).length() > 0)
      {
        i = 1;
        if (i != 1) {
          break label65;
        }
      }
    }
    label65:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label70;
      }
      AppMethodBeat.o(304381);
      return parama;
      i = 0;
      break;
    }
    label70:
    paramContext = paramContext.getResources().getString(e.f.LEu);
    AppMethodBeat.o(304381);
    return paramContext;
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(304373);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    AppMethodBeat.o(304373);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(304357);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    super.a(paramRecyclerView, paramj, paramInt);
    AppMethodBeat.o(304357);
  }
  
  public final void a(j paramj, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(304366);
    s.u(paramj, "holder");
    s.u(parama, "item");
    Log.d(this.TAG, "onBindViewHolder");
    super.a(paramj, parama, paramInt1, paramInt2, paramBoolean, paramList);
    paramj = (ImageView)paramj.caK.findViewById(e.c.LDQ);
    paramj.setImageDrawable(null);
    parama = parama.LGa.gkh();
    if (parama != null)
    {
      parama = parama.aaXP;
      if (parama != null)
      {
        paramList = e.noo;
        paramList = e.blh();
        s.s(paramj, "avatarImgView");
        paramList.a(parama, paramj, getThumbLoaderOption());
        paramj = ah.aiuX;
      }
    }
    AppMethodBeat.o(304366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.c
 * JD-Core Version:    0.7.0.1
 */