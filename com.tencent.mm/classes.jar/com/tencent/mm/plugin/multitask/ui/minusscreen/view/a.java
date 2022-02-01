package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.xwalk.core.Log;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/AppBrandMinusScreenRoundCornerConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", "listener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "MAX_APPBRAND_NAME_COUNT", "", "getMAX_APPBRAND_NAME_COUNT", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "getNickName", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "ui-multitask_release"})
public final class a
  extends d
{
  private final int FKS = 4;
  private final String TAG = "MicroMsg.AppBrandMinusScreenRoundCornerConvert";
  
  public a(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    super(e.d.FJa, parama);
  }
  
  public final String a(Context paramContext, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama)
  {
    AppMethodBeat.i(196506);
    p.k(paramContext, "context");
    p.k(parama, "item");
    parama = super.a(paramContext, parama);
    if (parama != null)
    {
      if (((CharSequence)parama).length() > 0) {}
      for (int i = 1; i == 1; i = 0)
      {
        AppMethodBeat.o(196506);
        return parama;
      }
    }
    paramContext = paramContext.getResources().getString(e.f.FJe);
    AppMethodBeat.o(196506);
    return paramContext;
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(196504);
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    AppMethodBeat.o(196504);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(196500);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    super.a(paramRecyclerView, parami, paramInt);
    AppMethodBeat.o(196500);
  }
  
  public final void a(i parami, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(196502);
    p.k(parami, "holder");
    p.k(parama, "item");
    Log.d(this.TAG, "onBindViewHolder");
    super.a(parami, parama, paramInt1, paramInt2, paramBoolean, paramList);
    ImageView localImageView = (ImageView)parami.amk.findViewById(e.c.FIG);
    TextView localTextView = (TextView)parami.amk.findViewById(e.c.FIN);
    paramList = parama.FKP.fbc();
    if (!Util.isNullOrNil(parama.FKP.fbc().tag))
    {
      p.j(localTextView, "nickname");
      com.tencent.mm.plugin.multitask.ui.minusscreen.e.a locala = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.FKR;
      if (paramList == null) {
        break label205;
      }
      paramList = paramList.nickname;
      if (paramList == null) {
        break label205;
      }
    }
    label205:
    for (paramList = (CharSequence)paramList;; paramList = (CharSequence)"")
    {
      localTextView.setText(com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.a(localTextView, paramList, this.FKS));
      localImageView.setImageDrawable(null);
      parama = parama.FKP.fbc();
      if (parama == null) {
        break;
      }
      parama = parama.TIg;
      if (parama == null) {
        break;
      }
      parami = e.kMy;
      parami = e.aRs();
      p.j(localImageView, "avatarImgView");
      parami.a(parama, localImageView, getThumbLoaderOption());
      AppMethodBeat.o(196502);
      return;
    }
    parami = (RoundCornerImageView)parami.amk.findViewById(e.c.FIx);
    p.j(parami, "defaultImage");
    parami.setVisibility(0);
    parami.setImageResource(e.e.spannable_app_brand_link_logo);
    AppMethodBeat.o(196502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.a
 * JD-Core Version:    0.7.0.1
 */