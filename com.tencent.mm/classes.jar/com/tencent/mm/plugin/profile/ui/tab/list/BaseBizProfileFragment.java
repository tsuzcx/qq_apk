package com.tencent.mm.plugin.profile.ui.tab.list;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.mm.plugin.profile.ui.tab.c;
import com.tencent.mm.plugin.profile.ui.tab.data.BizProfileDataFetcher;
import com.tencent.mm.plugin.profile.ui.tab.view.BizProfileRecyclerView;
import com.tencent.mm.protocal.protobuf.pd;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "Landroidx/fragment/app/Fragment;", "()V", "bizUsername", "", "getBizUsername", "()Ljava/lang/String;", "setBizUsername", "(Ljava/lang/String;)V", "controller", "Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController;", "getController", "()Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController;", "setController", "(Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController;)V", "footerTextView", "Landroid/widget/TextView;", "getFooterTextView", "()Landroid/widget/TextView;", "footerTextView$delegate", "Lkotlin/Lazy;", "footerView", "Landroid/view/View;", "getFooterView", "()Landroid/view/View;", "footerView$delegate", "mBizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "getMBizProfileResp", "()Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "setMBizProfileResp", "(Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;)V", "mDataFetcher", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "getMDataFetcher", "()Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "setMDataFetcher", "(Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;)V", "mRecyclerView", "Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView;", "getMRecyclerView", "()Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView;", "setMRecyclerView", "(Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView;)V", "msgType", "", "getMsgType", "()I", "fetchMsgList", "", "onAppBarLayoutExpand", "setBizProfileResp", "bizProfileResp", "setDataFetcher", "dataFetcher", "showErrorView", "app_release"})
public abstract class BaseBizProfileFragment
  extends Fragment
{
  protected BizProfileDataFetcher Hhg;
  protected pd Hhh;
  protected BizProfileRecyclerView Hhi;
  public c Hhj;
  private final f Hhk = g.ar((a)new b(this));
  private final f Hhl = g.ar((a)new a(this));
  protected String fOX;
  
  protected final void YU(String paramString)
  {
    p.k(paramString, "<set-?>");
    this.fOX = paramString;
  }
  
  protected final void a(BizProfileRecyclerView paramBizProfileRecyclerView)
  {
    p.k(paramBizProfileRecyclerView, "<set-?>");
    this.Hhi = paramBizProfileRecyclerView;
  }
  
  protected final void d(BizProfileDataFetcher paramBizProfileDataFetcher)
  {
    p.k(paramBizProfileDataFetcher, "<set-?>");
    this.Hhg = paramBizProfileDataFetcher;
  }
  
  public void e(BizProfileDataFetcher paramBizProfileDataFetcher)
  {
    p.k(paramBizProfileDataFetcher, "dataFetcher");
    this.Hhg = paramBizProfileDataFetcher;
  }
  
  protected final void e(pd parampd)
  {
    p.k(parampd, "<set-?>");
    this.Hhh = parampd;
  }
  
  public void f(pd parampd)
  {
    p.k(parampd, "bizProfileResp");
    this.Hhh = parampd;
  }
  
  protected final BizProfileDataFetcher frG()
  {
    BizProfileDataFetcher localBizProfileDataFetcher = this.Hhg;
    if (localBizProfileDataFetcher == null) {
      p.bGy("mDataFetcher");
    }
    return localBizProfileDataFetcher;
  }
  
  protected final pd frH()
  {
    pd localpd = this.Hhh;
    if (localpd == null) {
      p.bGy("mBizProfileResp");
    }
    return localpd;
  }
  
  protected final BizProfileRecyclerView frI()
  {
    BizProfileRecyclerView localBizProfileRecyclerView = this.Hhi;
    if (localBizProfileRecyclerView == null) {
      p.bGy("mRecyclerView");
    }
    return localBizProfileRecyclerView;
  }
  
  protected final TextView frJ()
  {
    return (TextView)this.Hhl.getValue();
  }
  
  public void frK() {}
  
  protected final View getFooterView()
  {
    return (View)this.Hhk.getValue();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements a<TextView>
  {
    a(BaseBizProfileFragment paramBaseBizProfileFragment)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements a<View>
  {
    b(BaseBizProfileFragment paramBaseBizProfileFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.BaseBizProfileFragment
 * JD-Core Version:    0.7.0.1
 */