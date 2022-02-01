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
import com.tencent.mm.plugin.multitask.ui.e.e;
import com.tencent.mm.plugin.multitask.ui.e.f;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.xwalk.core.Log;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/WebMinusScreenRoundCornerConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", "listener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getNickName", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "ui-multitask_release"})
public final class h
  extends d
{
  private final String TAG = "MicroMsg.WebMinusScreenRoundCornerConvert";
  
  public h(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    super(e.d.FJa, parama);
  }
  
  public final String a(Context paramContext, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama)
  {
    AppMethodBeat.i(197517);
    p.k(paramContext, "context");
    p.k(parama, "item");
    parama = super.a(paramContext, parama);
    if (parama != null)
    {
      if (((CharSequence)parama).length() > 0) {}
      for (int i = 1; i == 1; i = 0)
      {
        AppMethodBeat.o(197517);
        return parama;
      }
    }
    paramContext = paramContext.getResources().getString(e.f.FJj);
    AppMethodBeat.o(197517);
    return paramContext;
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(197519);
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    AppMethodBeat.o(197519);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(197509);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    super.a(paramRecyclerView, parami, paramInt);
    AppMethodBeat.o(197509);
  }
  
  public final void a(i parami, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(197512);
    p.k(parami, "holder");
    p.k(parama, "item");
    Log.d(this.TAG, "onBindViewHolder");
    super.a(parami, parama, paramInt1, paramInt2, paramBoolean, paramList);
    ImageView localImageView = (ImageView)parami.amk.findViewById(e.c.FIx);
    paramList = (ImageView)parami.amk.findViewById(e.c.FIG);
    paramList.setImageDrawable(null);
    p.j(localImageView, "defaultImage");
    localImageView.setVisibility(8);
    parama = parama.FKP.field_showData.TIg;
    if (parama != null)
    {
      if (!Util.isNullOrNil(parama))
      {
        parami = e.kMy;
        parami = e.aRs();
        p.j(paramList, "avatarImgView");
        parami.a(parama, paramList, getThumbLoaderOption());
      }
      AppMethodBeat.o(197512);
      return;
    }
    localImageView.setPadding(aw.fromDPToPix(parami.getContext(), 3), aw.fromDPToPix(parami.getContext(), 3), aw.fromDPToPix(parami.getContext(), 3), aw.fromDPToPix(parami.getContext(), 3));
    localImageView.setImageDrawable(au.o(parami.getContext(), e.e.icons_filled_link, au.fG(-1, 50)));
    localImageView.setVisibility(0);
    AppMethodBeat.o(197512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.h
 * JD-Core Version:    0.7.0.1
 */