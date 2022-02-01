package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.e;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.xwalk.core.Log;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/WebMinusScreenRoundCornerConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", "listener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getNickName", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "ui-multitask_release"})
public final class h
  extends d
{
  private final String TAG = "MicroMsg.WebMinusScreenRoundCornerConvert";
  
  public h(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    super(parama);
  }
  
  public final String a(Context paramContext, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama)
  {
    AppMethodBeat.i(236550);
    p.h(paramContext, "context");
    p.h(parama, "item");
    parama = super.a(paramContext, parama);
    if (parama != null)
    {
      if (((CharSequence)parama).length() > 0) {}
      for (int i = 1; i == 1; i = 0)
      {
        AppMethodBeat.o(236550);
        return parama;
      }
    }
    paramContext = paramContext.getResources().getString(2131763058);
    AppMethodBeat.o(236550);
    return paramContext;
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(236551);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    AppMethodBeat.o(236551);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.h paramh, int paramInt)
  {
    AppMethodBeat.i(236547);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    super.a(paramRecyclerView, paramh, paramInt);
    AppMethodBeat.o(236547);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.h paramh, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(236548);
    p.h(paramh, "holder");
    p.h(parama, "item");
    Log.d(this.TAG, "onBindViewHolder");
    super.a(paramh, parama, paramInt1, paramInt2, paramBoolean, paramList);
    ImageView localImageView = (ImageView)paramh.aus.findViewById(2131299444);
    paramList = (ImageView)paramh.aus.findViewById(2131305004);
    paramList.setImageDrawable(null);
    p.g(localImageView, "defaultImage");
    localImageView.setVisibility(8);
    parama = parama.Aen.field_showData.MwR;
    if (parama != null)
    {
      if (!Util.isNullOrNil(parama))
      {
        paramh = e.hXU;
        paramh = e.aJs();
        p.g(paramList, "avatarImgView");
        paramh.a(parama, paramList, this.Aer);
      }
      AppMethodBeat.o(236548);
      return;
    }
    localImageView.setPadding(at.fromDPToPix(paramh.getContext(), 3), at.fromDPToPix(paramh.getContext(), 3), at.fromDPToPix(paramh.getContext(), 3), at.fromDPToPix(paramh.getContext(), 3));
    localImageView.setImageDrawable(ar.m(paramh.getContext(), 2131690579, ar.fj(-1, 50)));
    localImageView.setVisibility(0);
    AppMethodBeat.o(236548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.h
 * JD-Core Version:    0.7.0.1
 */