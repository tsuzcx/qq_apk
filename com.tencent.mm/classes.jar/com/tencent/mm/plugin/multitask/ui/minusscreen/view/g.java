package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.e.b;
import com.tencent.mm.plugin.multitask.ui.e.c;
import com.tencent.mm.plugin.multitask.ui.e.d;
import com.tencent.mm.plugin.multitask.ui.e.e;
import com.tencent.mm.plugin.multitask.ui.e.f;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;
import kotlin.g.b.p;
import kotlin.l;
import org.xwalk.core.Log;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/VideoMinusScreenRoundCornerConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", "listener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getNickName", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "useBottomGradient", "ui-multitask_release"})
public final class g
  extends d
{
  private final String TAG = "MicroMsg.VideoMinusScreenRoundCornerConvert";
  
  public g(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    super(e.d.FJa, parama);
  }
  
  public final String a(Context paramContext, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama)
  {
    AppMethodBeat.i(196424);
    p.k(paramContext, "context");
    p.k(parama, "item");
    if (Util.isNullOrNil(parama.FKP.fbc().nickname))
    {
      paramContext = paramContext.getResources().getString(e.f.FJi);
      AppMethodBeat.o(196424);
      return paramContext;
    }
    paramContext = parama.FKP.fbc().nickname;
    AppMethodBeat.o(196424);
    return paramContext;
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(196421);
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    AppMethodBeat.o(196421);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(196410);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    super.a(paramRecyclerView, parami, paramInt);
    AppMethodBeat.o(196410);
  }
  
  public final void a(i parami, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(196418);
    p.k(parami, "holder");
    p.k(parama, "item");
    Log.d(this.TAG, "onBindViewHolder");
    super.a(parami, parama, paramInt1, paramInt2, paramBoolean, paramList);
    dar localdar = parama.FKP.fbc();
    TextView localTextView = (TextView)parami.amk.findViewById(e.c.FIN);
    ImageView localImageView2 = (ImageView)parami.amk.findViewById(e.c.FIG);
    ImageView localImageView1 = (ImageView)parami.amk.findViewById(e.c.FIH);
    paramList = t.ztT;
    com.tencent.mm.loader.d locald = t.dJh();
    if (localdar != null)
    {
      localObject = localdar.TIg;
      paramList = (List<Object>)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramList = "";
    }
    paramList = new e(paramList, u.AlP);
    p.j(localImageView2, "avatarImgView");
    Object localObject = t.ztT;
    locald.a(paramList, localImageView2, t.a(t.a.ztX));
    p.j(localTextView, "nickname");
    paramList = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.FKR;
    if (localdar != null)
    {
      paramList = localdar.nickname;
      if (paramList != null)
      {
        paramList = (CharSequence)paramList;
        localTextView.setText(com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.a(localTextView, paramList, fbK()));
        if (localdar != null)
        {
          paramList = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.FKR;
          p.j(localImageView1, "avatarIconView");
          com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.a(localImageView1, localdar.TIh, localdar.TIf);
        }
        paramList = (WeImageView)parami.RD(e.c.FII);
        paramList.setImageResource(e.e.icons_outlined_playbtn);
        localObject = parami.getContext();
        p.j(localObject, "holder.context");
        paramList.setIconColor(((Context)localObject).getResources().getColor(e.b.White));
        if (localdar.TIi) {
          break label384;
        }
        p.j(paramList, "playIconImg");
        paramList.setVisibility(0);
      }
    }
    for (;;)
    {
      parami = (TextView)parami.RD(e.c.FIM);
      parami.setText((CharSequence)AP(parama.FKP.fbc().KFK));
      p.j(parami, "durationTv");
      parami.setVisibility(0);
      AppMethodBeat.o(196418);
      return;
      paramList = (CharSequence)"";
      break;
      label384:
      p.j(paramList, "playIconImg");
      paramList.setVisibility(8);
    }
  }
  
  public final boolean fbL()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.g
 * JD-Core Version:    0.7.0.1
 */