package com.tencent.mm.plugin.profile.ui.tab.list;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v4.view.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.profile.ui.tab.data.BizProfileDataFetcher;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.storage.bv;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgFragment;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "()V", "enterTime", "", "getEnterTime", "()J", "setEnterTime", "(J)V", "listView", "Landroid/widget/ListView;", "mAdapter", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter;", "mBizMessageList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "msgType", "", "getMsgType", "()I", "onAppBarLayoutExpand", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setBizProfileResp", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "setDataFetcher", "dataFetcher", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "app_release"})
public final class BizProfileTabMsgFragment
  extends BaseBizProfileFragment
{
  private a Bnl;
  private final ov Bnm;
  public long enterTime;
  private ListView krb;
  
  public BizProfileTabMsgFragment()
  {
    AppMethodBeat.i(230820);
    ov localov = new ov();
    localov.KVw = new LinkedList();
    localov.KVx = new pf();
    this.Bnm = localov;
    AppMethodBeat.o(230820);
  }
  
  public final void e(BizProfileDataFetcher paramBizProfileDataFetcher)
  {
    AppMethodBeat.i(230817);
    p.h(paramBizProfileDataFetcher, "dataFetcher");
    d(paramBizProfileDataFetcher);
    eFJ().Bmz.observe((LifecycleOwner)this, (Observer)new b(this));
    eFJ().BmB.observe((LifecycleOwner)this, (Observer)new c(this));
    AppMethodBeat.o(230817);
  }
  
  public final void eFM()
  {
    AppMethodBeat.i(230818);
    ListView localListView = this.krb;
    if (localListView == null) {
      p.btv("listView");
    }
    localListView.setItemChecked(0, true);
    localListView = this.krb;
    if (localListView == null) {
      p.btv("listView");
    }
    localListView.setSelection(0);
    AppMethodBeat.o(230818);
  }
  
  public final void f(ph paramph)
  {
    AppMethodBeat.i(230816);
    p.h(paramph, "bizProfileResp");
    Object localObject = new ph();
    ((ph)localObject).KWg = paramph.KWg;
    e((ph)localObject);
    localObject = this.Bnm;
    paramph = paramph.KWg;
    if (paramph != null) {}
    for (paramph = paramph.KVx;; paramph = null)
    {
      ((ov)localObject).KVx = paramph;
      AppMethodBeat.o(230816);
      return;
    }
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(230819);
    p.h(paramLayoutInflater, "inflater");
    paramViewGroup = paramLayoutInflater.inflate(2131493742, paramViewGroup, false);
    paramLayoutInflater = paramViewGroup.findViewById(2131306757);
    p.g(paramLayoutInflater, "view.findViewById(R.id.recycler_view)");
    this.krb = ((ListView)paramLayoutInflater);
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null) {}
    for (paramLayoutInflater = paramLayoutInflater.getString("contact");; paramLayoutInflater = null)
    {
      p.g(bg.aVF(), "MMCore.getAccStg()");
      paramBundle = c.aSN();
      if (paramLayoutInflater == null) {
        p.hyc();
      }
      paramLayoutInflater = paramBundle.Kn(paramLayoutInflater);
      paramBundle = getContext();
      if (paramBundle == null) {
        p.hyc();
      }
      p.g(paramBundle, "context!!");
      p.g(paramLayoutInflater, "contact");
      this.Bnl = new a(paramBundle, paramLayoutInflater, this.enterTime);
      paramLayoutInflater = this.krb;
      if (paramLayoutInflater == null) {
        p.btv("listView");
      }
      paramBundle = this.Bnl;
      if (paramBundle == null) {
        p.btv("mAdapter");
      }
      paramLayoutInflater.setAdapter((ListAdapter)paramBundle);
      paramLayoutInflater = this.krb;
      if (paramLayoutInflater == null) {
        p.btv("listView");
      }
      u.av((View)paramLayoutInflater);
      if (eFK().KWg != null)
      {
        paramLayoutInflater = this.Bnl;
        if (paramLayoutInflater == null) {
          p.btv("mAdapter");
        }
        paramBundle = eFK().KWg;
        p.g(paramBundle, "mBizProfileResp.MsgList");
        paramLayoutInflater.d(paramBundle);
      }
      paramLayoutInflater = this.Bnl;
      if (paramLayoutInflater == null) {
        p.btv("mAdapter");
      }
      paramLayoutInflater.BmU = ((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(230819);
      return paramViewGroup;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(BizProfileTabMsgFragment paramBizProfileTabMsgFragment)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "onChanged"})
  static final class b<T>
    implements Observer<ph>
  {
    b(BizProfileTabMsgFragment paramBizProfileTabMsgFragment) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "onChanged"})
  static final class c<T>
    implements Observer<ph>
  {
    c(BizProfileTabMsgFragment paramBizProfileTabMsgFragment) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.BizProfileTabMsgFragment
 * JD-Core Version:    0.7.0.1
 */