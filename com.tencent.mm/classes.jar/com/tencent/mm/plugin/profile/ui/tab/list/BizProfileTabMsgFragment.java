package com.tencent.mm.plugin.profile.ui.tab.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizHeaderController;
import com.tencent.mm.plugin.profile.ui.tab.data.BizProfileDataFetcher;
import com.tencent.mm.plugin.profile.ui.tab.view.BizProfileRecyclerView;
import com.tencent.mm.plugin.profile.ui.tab.view.BizProfileRecyclerView.a;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.qk;
import com.tencent.mm.protocal.protobuf.qm;
import com.tencent.mm.storage.bx;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgFragment;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "()V", "enterTime", "", "getEnterTime", "()J", "setEnterTime", "(J)V", "mAdapter", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter;", "mBizMessageList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "msgType", "", "getMsgType", "()I", "onAppBarLayoutExpand", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setBizProfileResp", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "setDataFetcher", "dataFetcher", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizProfileTabMsgFragment
  extends BaseBizProfileFragment
{
  private a NfA;
  private final py NfB;
  public long enterTime;
  
  public BizProfileTabMsgFragment()
  {
    AppMethodBeat.i(306168);
    py localpy = new py();
    localpy.YUi = new LinkedList();
    localpy.YUj = new qk();
    ah localah = ah.aiuX;
    this.NfB = localpy;
    AppMethodBeat.o(306168);
  }
  
  private static final void a(BizProfileTabMsgFragment paramBizProfileTabMsgFragment, qm paramqm)
  {
    Object localObject2 = null;
    AppMethodBeat.i(306175);
    s.u(paramBizProfileTabMsgFragment, "this$0");
    if (paramqm == null)
    {
      AppMethodBeat.o(306175);
      return;
    }
    paramBizProfileTabMsgFragment.e(new qm());
    paramBizProfileTabMsgFragment.gCV().YVn = paramqm.YVn;
    Object localObject1 = paramBizProfileTabMsgFragment.NfB.YUi;
    if (localObject1 != null) {
      ((LinkedList)localObject1).clear();
    }
    Object localObject3 = paramBizProfileTabMsgFragment.NfB;
    localObject1 = paramqm.YVn;
    if (localObject1 == null)
    {
      localObject1 = null;
      ((py)localObject3).YUj = ((qk)localObject1);
      localObject1 = paramqm.YVn;
      if (localObject1 != null)
      {
        localObject1 = ((py)localObject1).YUi;
        if (localObject1 != null)
        {
          localObject3 = paramBizProfileTabMsgFragment.NfB.YUi;
          if (localObject3 != null) {
            ((LinkedList)localObject3).addAll((Collection)localObject1);
          }
          localObject1 = paramBizProfileTabMsgFragment.NfA;
          if (localObject1 != null) {
            break label224;
          }
          s.bIx("mAdapter");
          localObject1 = localObject2;
          label144:
          ((a)localObject1).c(paramBizProfileTabMsgFragment.NfB);
        }
      }
      paramqm = com.tencent.mm.plugin.profile.ui.tab.a.a(8, paramqm);
      if (paramqm == null) {
        break label232;
      }
      if (((CharSequence)paramqm).length() <= 0) {
        break label227;
      }
      i = 1;
      label177:
      if (i != 1) {
        break label232;
      }
    }
    label224:
    label227:
    label232:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label237;
      }
      paramBizProfileTabMsgFragment.gCX().setText((CharSequence)paramqm);
      paramBizProfileTabMsgFragment.gCW().et(paramBizProfileTabMsgFragment.getFooterView());
      AppMethodBeat.o(306175);
      return;
      localObject1 = ((py)localObject1).YUj;
      break;
      break label144;
      i = 0;
      break label177;
    }
    label237:
    paramBizProfileTabMsgFragment.gCX().setText(R.l.biz_time_line_loading_no_more_tips);
    paramBizProfileTabMsgFragment.gCW().eu(paramBizProfileTabMsgFragment.getFooterView());
    AppMethodBeat.o(306175);
  }
  
  private static final void b(BizProfileTabMsgFragment paramBizProfileTabMsgFragment, qm paramqm)
  {
    AppMethodBeat.i(306180);
    s.u(paramBizProfileTabMsgFragment, "this$0");
    if (paramqm == null)
    {
      AppMethodBeat.o(306180);
      return;
    }
    Object localObject;
    if (paramBizProfileTabMsgFragment.gCV().YVn == null)
    {
      paramqm.YVn = paramqm.YVn;
      py localpy = paramqm.YVn;
      if (localpy != null)
      {
        paramqm = localpy.YUi;
        if (paramqm != null)
        {
          paramBizProfileTabMsgFragment.NfB.YUi.addAll((Collection)paramqm);
          localObject = paramBizProfileTabMsgFragment.NfA;
          paramqm = (qm)localObject;
          if (localObject == null)
          {
            s.bIx("mAdapter");
            paramqm = null;
          }
          paramqm.c(paramBizProfileTabMsgFragment.NfB);
        }
        paramqm = localpy.YUj;
        if ((paramqm == null) || (paramqm.YVg != 0)) {
          break label181;
        }
      }
    }
    label181:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramBizProfileTabMsgFragment.gCW().et(paramBizProfileTabMsgFragment.getFooterView());
      }
      AppMethodBeat.o(306180);
      return;
      localObject = paramqm.YVn;
      if (localObject == null) {
        break;
      }
      localObject = ((py)localObject).YUj;
      if (localObject == null) {
        break;
      }
      paramBizProfileTabMsgFragment.NfB.YUj = ((qk)localObject);
      paramBizProfileTabMsgFragment.gCV().YVn.YUj = ((qk)localObject);
      break;
    }
  }
  
  public final void b(BizProfileDataFetcher paramBizProfileDataFetcher)
  {
    AppMethodBeat.i(306206);
    s.u(paramBizProfileDataFetcher, "dataFetcher");
    a(paramBizProfileDataFetcher);
    gCU().Nei.a((q)this, new BizProfileTabMsgFragment..ExternalSyntheticLambda1(this));
    gCU().Nek.a((q)this, new BizProfileTabMsgFragment..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(306206);
  }
  
  public final void dUU()
  {
    AppMethodBeat.i(306211);
    BizProfileRecyclerView localBizProfileRecyclerView = gCW();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localBizProfileRecyclerView, locala.aYi(), "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgFragment", "onAppBarLayoutExpand", "()V", "Undefined", "scrollToPosition", "(I)V");
    localBizProfileRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localBizProfileRecyclerView, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgFragment", "onAppBarLayoutExpand", "()V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(306211);
  }
  
  public final void f(qm paramqm)
  {
    AppMethodBeat.i(306197);
    s.u(paramqm, "bizProfileResp");
    Object localObject = new qm();
    ((qm)localObject).YVn = paramqm.YVn;
    ah localah = ah.aiuX;
    e((qm)localObject);
    localObject = this.NfB;
    paramqm = paramqm.YVn;
    if (paramqm == null) {}
    for (paramqm = null;; paramqm = paramqm.YUj)
    {
      ((py)localObject).YUj = paramqm;
      AppMethodBeat.o(306197);
      return;
    }
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = null;
    AppMethodBeat.i(306222);
    s.u(paramLayoutInflater, "inflater");
    View localView = paramLayoutInflater.inflate(R.i.ghX, paramViewGroup, false);
    paramLayoutInflater = localView.findViewById(R.h.recycler_view);
    s.s(paramLayoutInflater, "view.findViewById(R.id.recycler_view)");
    a((BizProfileRecyclerView)paramLayoutInflater);
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater == null)
    {
      paramLayoutInflater = null;
      bh.bCz();
      paramViewGroup = com.tencent.mm.model.c.bzA();
      s.checkNotNull(paramLayoutInflater);
      paramLayoutInflater = paramViewGroup.JE(paramLayoutInflater);
      paramViewGroup = getContext();
      s.checkNotNull(paramViewGroup);
      s.s(paramViewGroup, "context!!");
      s.s(paramLayoutInflater, "contact");
      this.NfA = new a(paramViewGroup, paramLayoutInflater, this.enterTime);
      paramLayoutInflater = gCW();
      localView.getContext();
      paramLayoutInflater.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      BizProfileRecyclerView localBizProfileRecyclerView = gCW();
      paramViewGroup = this.NfA;
      paramLayoutInflater = paramViewGroup;
      if (paramViewGroup == null)
      {
        s.bIx("mAdapter");
        paramLayoutInflater = null;
      }
      localBizProfileRecyclerView.setAdapter((RecyclerView.a)paramLayoutInflater);
      gCW().setOnScrollToTopListener((BizProfileRecyclerView.a)new a(this));
      if (gCV().YVn != null)
      {
        paramViewGroup = this.NfA;
        paramLayoutInflater = paramViewGroup;
        if (paramViewGroup == null)
        {
          s.bIx("mAdapter");
          paramLayoutInflater = null;
        }
        paramViewGroup = gCV().YVn;
        s.s(paramViewGroup, "mBizProfileResp.MsgList");
        paramLayoutInflater.c(paramViewGroup);
      }
      paramLayoutInflater = this.NfA;
      if (paramLayoutInflater != null) {
        break label296;
      }
      s.bIx("mAdapter");
      paramLayoutInflater = paramBundle;
    }
    label296:
    for (;;)
    {
      paramLayoutInflater.NeE = ((kotlin.g.a.a)new b(this));
      AppMethodBeat.o(306222);
      return localView;
      paramLayoutInflater = paramLayoutInflater.getString("contact");
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgFragment$onCreateView$1", "Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView$OnScrollToTopListener;", "onScrollToTop", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements BizProfileRecyclerView.a
  {
    a(BizProfileTabMsgFragment paramBizProfileTabMsgFragment) {}
    
    public final void dSq()
    {
      AppMethodBeat.i(306176);
      Object localObject = this.NfC.Nev;
      if (localObject != null) {
        ((ContactWidgetTabBizHeaderController)localObject).gCJ();
      }
      localObject = this.NfC.gCW();
      if (localObject != null)
      {
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgFragment$onCreateView$1", "onScrollToTop", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((BizProfileRecyclerView)localObject).scrollToPosition(((Integer)locala.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgFragment$onCreateView$1", "onScrollToTop", "()V", "Undefined", "scrollToPosition", "(I)V");
      }
      AppMethodBeat.o(306176);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(BizProfileTabMsgFragment paramBizProfileTabMsgFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.BizProfileTabMsgFragment
 * JD-Core Version:    0.7.0.1
 */