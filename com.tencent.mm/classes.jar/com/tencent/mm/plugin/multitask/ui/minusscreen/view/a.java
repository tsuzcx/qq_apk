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
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.xwalk.core.Log;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/AppBrandMinusScreenRoundCornerConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", "listener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "MAX_APPBRAND_NAME_COUNT", "", "getMAX_APPBRAND_NAME_COUNT", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "getNickName", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends d
{
  private final int LGd = 4;
  private final String TAG = "MicroMsg.AppBrandMinusScreenRoundCornerConvert";
  
  public a(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    super(e.d.LEl, parama);
  }
  
  public final String a(Context paramContext, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama)
  {
    AppMethodBeat.i(304444);
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
      AppMethodBeat.o(304444);
      return parama;
      i = 0;
      break;
    }
    label70:
    paramContext = paramContext.getResources().getString(e.f.LEp);
    AppMethodBeat.o(304444);
    return paramContext;
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(304432);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    AppMethodBeat.o(304432);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(304405);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    super.a(paramRecyclerView, paramj, paramInt);
    AppMethodBeat.o(304405);
  }
  
  public final void a(j paramj, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(304424);
    s.u(paramj, "holder");
    s.u(parama, "item");
    Log.d(this.TAG, "onBindViewHolder");
    super.a(paramj, parama, paramInt1, paramInt2, paramBoolean, paramList);
    ImageView localImageView = (ImageView)paramj.caK.findViewById(e.c.LDQ);
    TextView localTextView = (TextView)paramj.caK.findViewById(e.c.LDX);
    paramList = parama.LGa.gkh();
    Object localObject;
    if (!Util.isNullOrNil(parama.LGa.gkh().tag))
    {
      localObject = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.LGc;
      s.s(localTextView, "nickname");
      if (paramList == null)
      {
        paramList = "";
        localTextView.setText(com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.a(localTextView, (CharSequence)paramList, this.LGd));
      }
    }
    else
    {
      localImageView.setImageDrawable(null);
      parama = parama.LGa.gkh();
      if (parama != null) {
        break label213;
      }
      parama = null;
    }
    for (;;)
    {
      if (parama == null)
      {
        paramj = (RoundCornerImageView)paramj.caK.findViewById(e.c.LDH);
        paramj.setVisibility(0);
        paramj.setImageResource(e.e.spannable_app_brand_link_logo);
      }
      AppMethodBeat.o(304424);
      return;
      localObject = paramList.nickname;
      paramList = (List<Object>)localObject;
      if (localObject != null) {
        break;
      }
      paramList = "";
      break;
      label213:
      parama = parama.aaXP;
      if (parama == null)
      {
        parama = null;
      }
      else
      {
        paramList = e.noo;
        paramList = e.blh();
        s.s(localImageView, "avatarImgView");
        paramList.a(parama, localImageView, getThumbLoaderOption());
        parama = ah.aiuX;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.a
 * JD-Core Version:    0.7.0.1
 */