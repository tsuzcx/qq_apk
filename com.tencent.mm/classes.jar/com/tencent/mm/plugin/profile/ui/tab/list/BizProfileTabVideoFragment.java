package com.tencent.mm.plugin.profile.ui.tab.list;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.m;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.profile.ui.tab.data.BizProfileDataFetcher;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.ph;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoFragment;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "()V", "mMsgList", "", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "mVideoAdapter", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter;", "mVideoRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "msgType", "", "getMsgType", "()I", "onAppBarLayoutExpand", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setBizProfileResp", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "setDataFetcher", "dataFetcher", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "app_release"})
public final class BizProfileTabVideoFragment
  extends BaseBizProfileFragment
{
  private RecyclerView BnD;
  private e BnE;
  private List<ou> pRP;
  
  public BizProfileTabVideoFragment()
  {
    AppMethodBeat.i(230852);
    this.pRP = ((List)new ArrayList());
    AppMethodBeat.o(230852);
  }
  
  public final void e(BizProfileDataFetcher paramBizProfileDataFetcher)
  {
    AppMethodBeat.i(230848);
    p.h(paramBizProfileDataFetcher, "dataFetcher");
    d(paramBizProfileDataFetcher);
    eFJ().Bmz.observe((LifecycleOwner)this, (Observer)new b(this));
    eFJ().BmA.observe((LifecycleOwner)this, (Observer)new c(this));
    AppMethodBeat.o(230848);
  }
  
  public final void eFM()
  {
    AppMethodBeat.i(230851);
    RecyclerView localRecyclerView = this.BnD;
    if (localRecyclerView == null) {
      p.btv("mVideoRecyclerView");
    }
    com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.axQ(), "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoFragment", "onAppBarLayoutExpand", "()V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.scrollToPosition(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoFragment", "onAppBarLayoutExpand", "()V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(230851);
  }
  
  public final void f(ph paramph)
  {
    AppMethodBeat.i(230847);
    p.h(paramph, "bizProfileResp");
    e(new ph());
    eFK().KWi = paramph.KWi;
    AppMethodBeat.o(230847);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(230849);
    p.h(paramLayoutInflater, "inflater");
    paramViewGroup = paramLayoutInflater.inflate(2131493743, paramViewGroup, false);
    paramLayoutInflater = paramViewGroup.findViewById(2131306757);
    p.g(paramLayoutInflater, "view.findViewById(R.id.recycler_view)");
    this.BnD = ((RecyclerView)paramLayoutInflater);
    paramLayoutInflater = this.BnD;
    if (paramLayoutInflater == null) {
      p.btv("mVideoRecyclerView");
    }
    getActivity();
    paramLayoutInflater.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null) {}
    for (paramLayoutInflater = paramLayoutInflater.getString("contact");; paramLayoutInflater = null)
    {
      if (paramLayoutInflater == null) {
        p.hyc();
      }
      Rx(paramLayoutInflater);
      this.BnE = new e(this.pRP);
      paramLayoutInflater = this.BnD;
      if (paramLayoutInflater == null) {
        p.btv("mVideoRecyclerView");
      }
      paramLayoutInflater = paramLayoutInflater.getRecycledViewPool();
      p.g(paramLayoutInflater, "mVideoRecyclerView.recycledViewPool");
      paramLayoutInflater.aw(0, 20);
      paramBundle = this.BnD;
      if (paramBundle == null) {
        p.btv("mVideoRecyclerView");
      }
      paramBundle.setRecycledViewPool(paramLayoutInflater);
      paramLayoutInflater = this.BnD;
      if (paramLayoutInflater == null) {
        p.btv("mVideoRecyclerView");
      }
      paramBundle = this.BnE;
      if (paramBundle == null) {
        p.btv("mVideoAdapter");
      }
      paramLayoutInflater.setAdapter((RecyclerView.a)paramBundle);
      AppMethodBeat.o(230849);
      return paramViewGroup;
    }
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(230850);
    p.h(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    if (this.pRP.isEmpty())
    {
      paramView = eFK().KWi;
      if (paramView != null)
      {
        paramView = paramView.KVw;
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
        paramView = this.pRP;
        paramBundle = eFK().KWi.KVw;
        p.g(paramBundle, "mBizProfileResp.VideoList.Msg");
        paramView.addAll((Collection)paramBundle);
        paramView = this.BnE;
        if (paramView == null) {
          p.btv("mVideoAdapter");
        }
        paramView.notifyDataSetChanged();
      }
      paramView = this.BnE;
      if (paramView == null) {
        p.btv("mVideoAdapter");
      }
      paramView.BmU = ((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(230850);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(BizProfileTabVideoFragment paramBizProfileTabVideoFragment)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "onChanged"})
  static final class b<T>
    implements Observer<ph>
  {
    b(BizProfileTabVideoFragment paramBizProfileTabVideoFragment) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "onChanged"})
  static final class c<T>
    implements Observer<ph>
  {
    c(BizProfileTabVideoFragment paramBizProfileTabVideoFragment) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.BizProfileTabVideoFragment
 * JD-Core Version:    0.7.0.1
 */