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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.profile.ui.tab.data.BizProfileDataFetcher;
import com.tencent.mm.plugin.profile.ui.tab.view.BizProfileRecyclerView;
import com.tencent.mm.plugin.profile.ui.tab.view.BizProfileRecyclerView.a;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.protocal.protobuf.pb;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.storage.bv;
import java.util.LinkedList;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgFragment;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "()V", "enterTime", "", "getEnterTime", "()J", "setEnterTime", "(J)V", "mAdapter", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter;", "mBizMessageList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "msgType", "", "getMsgType", "()I", "onAppBarLayoutExpand", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setBizProfileResp", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "setDataFetcher", "dataFetcher", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "app_release"})
public final class BizProfileTabMsgFragment
  extends BaseBizProfileFragment
{
  private a HhH;
  private final op HhI;
  public long enterTime;
  
  public BizProfileTabMsgFragment()
  {
    AppMethodBeat.i(201995);
    op localop = new op();
    localop.RWC = new LinkedList();
    localop.RWD = new pb();
    this.HhI = localop;
    AppMethodBeat.o(201995);
  }
  
  public final void e(BizProfileDataFetcher paramBizProfileDataFetcher)
  {
    AppMethodBeat.i(201977);
    p.k(paramBizProfileDataFetcher, "dataFetcher");
    d(paramBizProfileDataFetcher);
    frG().HgT.a((androidx.lifecycle.l)this, (s)new c(this));
    frG().HgV.a((androidx.lifecycle.l)this, (s)new d(this));
    AppMethodBeat.o(201977);
  }
  
  public final void f(pd parampd)
  {
    AppMethodBeat.i(201973);
    p.k(parampd, "bizProfileResp");
    Object localObject = new pd();
    ((pd)localObject).RXu = parampd.RXu;
    e((pd)localObject);
    localObject = this.HhI;
    parampd = parampd.RXu;
    if (parampd != null) {}
    for (parampd = parampd.RWD;; parampd = null)
    {
      ((op)localObject).RWD = parampd;
      AppMethodBeat.o(201973);
      return;
    }
  }
  
  public final void frK()
  {
    AppMethodBeat.i(201979);
    BizProfileRecyclerView localBizProfileRecyclerView = frI();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localBizProfileRecyclerView, locala.aFh(), "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgFragment", "onAppBarLayoutExpand", "()V", "Undefined", "scrollToPosition", "(I)V");
    localBizProfileRecyclerView.scrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localBizProfileRecyclerView, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgFragment", "onAppBarLayoutExpand", "()V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(201979);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(201991);
    p.k(paramLayoutInflater, "inflater");
    paramViewGroup = paramLayoutInflater.inflate(R.i.efd, paramViewGroup, false);
    paramLayoutInflater = paramViewGroup.findViewById(R.h.recycler_view);
    p.j(paramLayoutInflater, "view.findViewById(R.id.recycler_view)");
    a((BizProfileRecyclerView)paramLayoutInflater);
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null) {}
    for (paramLayoutInflater = paramLayoutInflater.getString("contact");; paramLayoutInflater = null)
    {
      p.j(bh.beI(), "MMCore.getAccStg()");
      paramBundle = com.tencent.mm.model.c.bbL();
      if (paramLayoutInflater == null) {
        p.iCn();
      }
      paramLayoutInflater = paramBundle.RG(paramLayoutInflater);
      paramBundle = getContext();
      if (paramBundle == null) {
        p.iCn();
      }
      p.j(paramBundle, "context!!");
      p.j(paramLayoutInflater, "contact");
      this.HhH = new a(paramBundle, paramLayoutInflater, this.enterTime);
      paramLayoutInflater = frI();
      p.j(paramViewGroup, "view");
      paramViewGroup.getContext();
      paramLayoutInflater.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      paramLayoutInflater = frI();
      paramBundle = this.HhH;
      if (paramBundle == null) {
        p.bGy("mAdapter");
      }
      paramLayoutInflater.setAdapter((RecyclerView.a)paramBundle);
      frI().setOnScrollToTopListener((BizProfileRecyclerView.a)new a(this));
      if (frH().RXu != null)
      {
        paramLayoutInflater = this.HhH;
        if (paramLayoutInflater == null) {
          p.bGy("mAdapter");
        }
        paramBundle = frH().RXu;
        p.j(paramBundle, "mBizProfileResp.MsgList");
        paramLayoutInflater.d(paramBundle);
      }
      paramLayoutInflater = this.HhH;
      if (paramLayoutInflater == null) {
        p.bGy("mAdapter");
      }
      paramLayoutInflater.Hhp = ((kotlin.g.a.a)new BizProfileTabMsgFragment.b(this));
      AppMethodBeat.o(201991);
      return paramViewGroup;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgFragment$onCreateView$1", "Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView$OnScrollToTopListener;", "onScrollToTop", "", "app_release"})
  public static final class a
    implements BizProfileRecyclerView.a
  {
    public final void dlA()
    {
      AppMethodBeat.i(271494);
      Object localObject = this.HhJ.Hhj;
      if (localObject != null) {
        ((com.tencent.mm.plugin.profile.ui.tab.c)localObject).frB();
      }
      localObject = this.HhJ.frI();
      if (localObject != null)
      {
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgFragment$onCreateView$1", "onScrollToTop", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((BizProfileRecyclerView)localObject).scrollToPosition(((Integer)locala.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgFragment$onCreateView$1", "onScrollToTop", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(271494);
        return;
      }
      AppMethodBeat.o(271494);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class c<T>
    implements s<pd>
  {
    c(BizProfileTabMsgFragment paramBizProfileTabMsgFragment) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class d<T>
    implements s<pd>
  {
    d(BizProfileTabMsgFragment paramBizProfileTabMsgFragment) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.BizProfileTabMsgFragment
 * JD-Core Version:    0.7.0.1
 */