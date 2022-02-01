package com.tencent.mm.plugin.profile.ui.tab.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.plugin.profile.ui.tab.data.BizProfileDataFetcher;
import com.tencent.mm.plugin.profile.ui.tab.view.BizProfileRecyclerView;
import com.tencent.mm.plugin.profile.ui.tab.view.BizProfileRecyclerView.a;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.protocal.protobuf.pd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoFragment;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "()V", "mMsgList", "", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "mVideoAdapter", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter;", "msgType", "", "getMsgType", "()I", "onAppBarLayoutExpand", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setBizProfileResp", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "setDataFetcher", "dataFetcher", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "app_release"})
public final class BizProfileTabVideoFragment
  extends BaseBizProfileFragment
{
  private d HhZ;
  private List<oo> tnP;
  
  public BizProfileTabVideoFragment()
  {
    AppMethodBeat.i(291398);
    this.tnP = ((List)new ArrayList());
    AppMethodBeat.o(291398);
  }
  
  public final void e(BizProfileDataFetcher paramBizProfileDataFetcher)
  {
    AppMethodBeat.i(291393);
    p.k(paramBizProfileDataFetcher, "dataFetcher");
    d(paramBizProfileDataFetcher);
    frG().HgT.a((androidx.lifecycle.l)this, (s)new c(this));
    frG().HgU.a((androidx.lifecycle.l)this, (s)new d(this));
    AppMethodBeat.o(291393);
  }
  
  public final void f(pd parampd)
  {
    AppMethodBeat.i(291392);
    p.k(parampd, "bizProfileResp");
    e(new pd());
    frH().RXw = parampd.RXw;
    AppMethodBeat.o(291392);
  }
  
  public final void frK()
  {
    AppMethodBeat.i(291397);
    BizProfileRecyclerView localBizProfileRecyclerView = frI();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localBizProfileRecyclerView, locala.aFh(), "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoFragment", "onAppBarLayoutExpand", "()V", "Undefined", "scrollToPosition", "(I)V");
    localBizProfileRecyclerView.scrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localBizProfileRecyclerView, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoFragment", "onAppBarLayoutExpand", "()V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(291397);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(291394);
    p.k(paramLayoutInflater, "inflater");
    paramViewGroup = paramLayoutInflater.inflate(R.i.efe, paramViewGroup, false);
    paramLayoutInflater = paramViewGroup.findViewById(R.h.recycler_view);
    p.j(paramLayoutInflater, "view.findViewById(R.id.recycler_view)");
    a((BizProfileRecyclerView)paramLayoutInflater);
    paramLayoutInflater = frI();
    getActivity();
    paramLayoutInflater.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null) {}
    for (paramLayoutInflater = paramLayoutInflater.getString("contact");; paramLayoutInflater = null)
    {
      if (paramLayoutInflater == null) {
        p.iCn();
      }
      YU(paramLayoutInflater);
      this.HhZ = new d(this.tnP);
      paramLayoutInflater = frI().getRecycledViewPool();
      p.j(paramLayoutInflater, "mRecyclerView.recycledViewPool");
      paramLayoutInflater.aJ(0, 20);
      frI().setRecycledViewPool(paramLayoutInflater);
      paramLayoutInflater = frI();
      paramBundle = this.HhZ;
      if (paramBundle == null) {
        p.bGy("mVideoAdapter");
      }
      paramLayoutInflater.setAdapter((RecyclerView.a)paramBundle);
      frI().setOnScrollToTopListener((BizProfileRecyclerView.a)new a(this));
      AppMethodBeat.o(291394);
      return paramViewGroup;
    }
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(291395);
    p.k(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    if (this.tnP.isEmpty())
    {
      paramView = frH().RXw;
      if (paramView != null)
      {
        paramView = paramView.RWC;
        if (paramView != null) {
          if (((Collection)paramView).isEmpty()) {
            break label159;
          }
        }
      }
    }
    label159:
    for (int i = 1;; i = 0)
    {
      if (i == 1)
      {
        paramView = this.tnP;
        paramBundle = frH().RXw.RWC;
        p.j(paramBundle, "mBizProfileResp.VideoList.Msg");
        paramView.addAll((Collection)paramBundle);
        paramView = this.HhZ;
        if (paramView == null) {
          p.bGy("mVideoAdapter");
        }
        paramView.notifyDataSetChanged();
      }
      paramView = this.HhZ;
      if (paramView == null) {
        p.bGy("mVideoAdapter");
      }
      paramView.Hhp = ((kotlin.g.a.a)new BizProfileTabVideoFragment.b(this));
      AppMethodBeat.o(291395);
      return;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoFragment$onCreateView$1", "Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView$OnScrollToTopListener;", "onScrollToTop", "", "app_release"})
  public static final class a
    implements BizProfileRecyclerView.a
  {
    public final void dlA()
    {
      AppMethodBeat.i(288569);
      Object localObject = this.Hia.Hhj;
      if (localObject != null) {
        ((com.tencent.mm.plugin.profile.ui.tab.c)localObject).frB();
      }
      localObject = this.Hia.frI();
      if (localObject != null)
      {
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoFragment$onCreateView$1", "onScrollToTop", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((BizProfileRecyclerView)localObject).scrollToPosition(((Integer)locala.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoFragment$onCreateView$1", "onScrollToTop", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(288569);
        return;
      }
      AppMethodBeat.o(288569);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class c<T>
    implements s<pd>
  {
    c(BizProfileTabVideoFragment paramBizProfileTabVideoFragment) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class d<T>
    implements s<pd>
  {
    d(BizProfileTabVideoFragment paramBizProfileTabVideoFragment) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.BizProfileTabVideoFragment
 * JD-Core Version:    0.7.0.1
 */