package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;
import kotlin.g.b.p;
import kotlin.l;
import org.xwalk.core.Log;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/VideoMinusScreenRoundCornerConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", "listener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getNickName", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "useBottomGradient", "ui-multitask_release"})
public final class g
  extends d
{
  private final String TAG = "MicroMsg.VideoMinusScreenRoundCornerConvert";
  
  public g(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    super(parama);
  }
  
  public final String a(Context paramContext, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama)
  {
    AppMethodBeat.i(236546);
    p.h(paramContext, "context");
    p.h(parama, "item");
    if (Util.isNullOrNil(parama.Aen.erh().nickname))
    {
      paramContext = paramContext.getResources().getString(2131763057);
      AppMethodBeat.o(236546);
      return paramContext;
    }
    paramContext = parama.Aen.erh().nickname;
    AppMethodBeat.o(236546);
    return paramContext;
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(236545);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    AppMethodBeat.o(236545);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(236542);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    super.a(paramRecyclerView, paramh, paramInt);
    AppMethodBeat.o(236542);
  }
  
  public final void a(h paramh, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(236543);
    p.h(paramh, "holder");
    p.h(parama, "item");
    Log.d(this.TAG, "onBindViewHolder");
    super.a(paramh, parama, paramInt1, paramInt2, paramBoolean, paramList);
    cru localcru = parama.Aen.erh();
    TextView localTextView = (TextView)paramh.aus.findViewById(2131305012);
    ImageView localImageView2 = (ImageView)paramh.aus.findViewById(2131305004);
    ImageView localImageView1 = (ImageView)paramh.aus.findViewById(2131305005);
    paramList = m.uJa;
    com.tencent.mm.loader.d locald = m.dka();
    if (localcru != null)
    {
      localObject = localcru.MwR;
      paramList = (List<Object>)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramList = "";
    }
    paramList = new com.tencent.mm.plugin.finder.loader.a(paramList);
    p.g(localImageView2, "avatarImgView");
    Object localObject = m.uJa;
    locald.a(paramList, localImageView2, m.a(m.a.uJe));
    p.g(localTextView, "nickname");
    paramList = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.Aep;
    if (localcru != null)
    {
      paramList = localcru.nickname;
      if (paramList != null)
      {
        paramList = (CharSequence)paramList;
        localTextView.setText(com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.a(localTextView, paramList, this.tDx));
        if (localcru != null)
        {
          paramList = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.Aep;
          p.g(localImageView1, "avatarIconView");
          com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.a(localImageView1, localcru.MwS, localcru.MwQ);
        }
        paramList = (WeImageView)paramh.Mn(2131305007);
        paramList.setImageResource(2131690887);
        localObject = paramh.getContext();
        p.g(localObject, "holder.context");
        paramList.setIconColor(((Context)localObject).getResources().getColor(2131099844));
        if (localcru.MwT) {
          break label406;
        }
        p.g(paramList, "playIconImg");
        paramList.setVisibility(0);
      }
    }
    for (;;)
    {
      paramh = (TextView)paramh.Mn(2131305011);
      paramInt1 = parama.Aen.erh().Eso;
      paramh.setText((CharSequence)(d.xt(paramInt1 / 60) + ":" + d.xt(paramInt1 % 60)));
      p.g(paramh, "durationTv");
      paramh.setVisibility(0);
      AppMethodBeat.o(236543);
      return;
      paramList = (CharSequence)"";
      break;
      label406:
      p.g(paramList, "playIconImg");
      paramList.setVisibility(8);
    }
  }
  
  public final boolean erF()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.g
 * JD-Core Version:    0.7.0.1
 */