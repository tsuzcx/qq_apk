package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.b;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.e.b;
import com.tencent.mm.plugin.multitask.ui.e.c;
import com.tencent.mm.plugin.multitask.ui.e.d;
import com.tencent.mm.plugin.multitask.ui.e.e;
import com.tencent.mm.plugin.multitask.ui.e.f;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/VideoMinusScreenRoundCornerConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", "listener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getNickName", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "useBottomGradient", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends d
{
  private final String TAG = "MicroMsg.VideoMinusScreenRoundCornerConvert";
  
  public g(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    super(e.d.LEl, parama);
  }
  
  public final String a(Context paramContext, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama)
  {
    AppMethodBeat.i(304450);
    s.u(paramContext, "context");
    s.u(parama, "item");
    if (Util.isNullOrNil(parama.LGa.gkh().nickname))
    {
      paramContext = paramContext.getResources().getString(e.f.LEt);
      AppMethodBeat.o(304450);
      return paramContext;
    }
    paramContext = parama.LGa.gkh().nickname;
    AppMethodBeat.o(304450);
    return paramContext;
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(304429);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    AppMethodBeat.o(304429);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(304389);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    super.a(paramRecyclerView, paramj, paramInt);
    AppMethodBeat.o(304389);
  }
  
  public final void a(j paramj, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(304418);
    s.u(paramj, "holder");
    s.u(parama, "item");
    Log.d(this.TAG, "onBindViewHolder");
    super.a(paramj, parama, paramInt1, paramInt2, paramBoolean, paramList);
    drz localdrz = parama.LGa.gkh();
    TextView localTextView = (TextView)paramj.caK.findViewById(e.c.LDX);
    ImageView localImageView2 = (ImageView)paramj.caK.findViewById(e.c.LDQ);
    ImageView localImageView1 = (ImageView)paramj.caK.findViewById(e.c.LDR);
    paramList = p.ExI;
    com.tencent.mm.loader.d locald = p.eCp();
    Object localObject;
    if (localdrz == null)
    {
      paramList = "";
      paramList = new b(paramList, v.FLF);
      s.s(localImageView2, "avatarImgView");
      localObject = p.ExI;
      locald.a(paramList, localImageView2, p.a(p.a.ExM));
      paramList = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.LGc;
      s.s(localTextView, "nickname");
      if (localdrz != null) {
        break label342;
      }
      paramList = "";
      label174:
      localTextView.setText(com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.a(localTextView, (CharSequence)paramList, gkO()));
      if (localdrz != null)
      {
        paramList = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.LGc;
        s.s(localImageView1, "avatarIconView");
        com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.b(localImageView1, localdrz.aaXQ, localdrz.aaXO);
      }
      paramList = (WeImageView)paramj.UH(e.c.LDS);
      paramList.setImageResource(e.e.icons_outlined_playbtn);
      paramList.setIconColor(paramj.context.getResources().getColor(e.b.White));
      if (localdrz.aaXR) {
        break label365;
      }
      paramList.setVisibility(0);
    }
    for (;;)
    {
      paramj = (TextView)paramj.UH(e.c.LDW);
      paramj.setText((CharSequence)Be(parama.LGa.gkh().Rfk));
      paramj.setVisibility(0);
      AppMethodBeat.o(304418);
      return;
      localObject = localdrz.aaXP;
      paramList = (List<Object>)localObject;
      if (localObject != null) {
        break;
      }
      paramList = "";
      break;
      label342:
      localObject = localdrz.nickname;
      paramList = (List<Object>)localObject;
      if (localObject != null) {
        break label174;
      }
      paramList = "";
      break label174;
      label365:
      paramList.setVisibility(8);
    }
  }
  
  public final boolean gkP()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.g
 * JD-Core Version:    0.7.0.1
 */