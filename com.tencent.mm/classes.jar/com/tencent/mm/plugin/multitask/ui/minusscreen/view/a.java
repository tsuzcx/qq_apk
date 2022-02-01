package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.e;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.xwalk.core.Log;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/AppBrandMinusScreenRoundCornerConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", "listener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "MAX_APPBRAND_NAME_COUNT", "", "getMAX_APPBRAND_NAME_COUNT", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "getNickName", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "ui-multitask_release"})
public final class a
  extends d
{
  private final int Aeq = 4;
  private final String TAG = "MicroMsg.AppBrandMinusScreenRoundCornerConvert";
  
  public a(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    super(parama);
  }
  
  public final String a(Context paramContext, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama)
  {
    AppMethodBeat.i(236513);
    p.h(paramContext, "context");
    p.h(parama, "item");
    parama = super.a(paramContext, parama);
    if (parama != null)
    {
      if (((CharSequence)parama).length() > 0) {}
      for (int i = 1; i == 1; i = 0)
      {
        AppMethodBeat.o(236513);
        return parama;
      }
    }
    paramContext = paramContext.getResources().getString(2131763049);
    AppMethodBeat.o(236513);
    return paramContext;
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(236512);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    AppMethodBeat.o(236512);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(236509);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    super.a(paramRecyclerView, paramh, paramInt);
    AppMethodBeat.o(236509);
  }
  
  public final void a(h paramh, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(236510);
    p.h(paramh, "holder");
    p.h(parama, "item");
    Log.d(this.TAG, "onBindViewHolder");
    super.a(paramh, parama, paramInt1, paramInt2, paramBoolean, paramList);
    ImageView localImageView = (ImageView)paramh.aus.findViewById(2131305004);
    TextView localTextView = (TextView)paramh.aus.findViewById(2131305012);
    paramList = parama.Aen.erh();
    if (!Util.isNullOrNil(parama.Aen.erh().tag))
    {
      p.g(localTextView, "nickname");
      com.tencent.mm.plugin.multitask.ui.minusscreen.e.a locala = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.Aep;
      if (paramList == null) {
        break label203;
      }
      paramList = paramList.nickname;
      if (paramList == null) {
        break label203;
      }
    }
    label203:
    for (paramList = (CharSequence)paramList;; paramList = (CharSequence)"")
    {
      localTextView.setText(com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.a(localTextView, paramList, this.Aeq));
      localImageView.setImageDrawable(null);
      parama = parama.Aen.erh();
      if (parama == null) {
        break;
      }
      parama = parama.MwR;
      if (parama == null) {
        break;
      }
      paramh = e.hXU;
      paramh = e.aJs();
      p.g(localImageView, "avatarImgView");
      paramh.a(parama, localImageView, this.Aer);
      AppMethodBeat.o(236510);
      return;
    }
    paramh = (RoundCornerImageView)paramh.aus.findViewById(2131299444);
    p.g(paramh, "defaultImage");
    paramh.setVisibility(0);
    paramh.setImageResource(2131691572);
    AppMethodBeat.o(236510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.a
 * JD-Core Version:    0.7.0.1
 */