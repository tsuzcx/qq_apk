package com.tencent.mm.plugin.profile.ui.tab.list;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.mm.plugin.findersdk.a.r;
import com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizHeaderController;
import com.tencent.mm.plugin.profile.ui.tab.data.BizProfileDataFetcher;
import com.tencent.mm.plugin.profile.ui.tab.view.BizProfileRecyclerView;
import com.tencent.mm.protocal.protobuf.qm;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/mm/plugin/findersdk/api/IBizProfileFragment;", "()V", "bizUsername", "", "getBizUsername", "()Ljava/lang/String;", "setBizUsername", "(Ljava/lang/String;)V", "controller", "Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController;", "getController", "()Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController;", "setController", "(Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController;)V", "footerTextView", "Landroid/widget/TextView;", "getFooterTextView", "()Landroid/widget/TextView;", "footerTextView$delegate", "Lkotlin/Lazy;", "footerView", "Landroid/view/View;", "getFooterView", "()Landroid/view/View;", "footerView$delegate", "mBizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "getMBizProfileResp", "()Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "setMBizProfileResp", "(Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;)V", "mDataFetcher", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "getMDataFetcher", "()Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "setMDataFetcher", "(Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;)V", "mRecyclerView", "Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView;", "getMRecyclerView", "()Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView;", "setMRecyclerView", "(Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView;)V", "msgType", "", "getMsgType", "()I", "fetchMsgList", "", "isVideoTab", "", "onAppBarLayoutExpand", "setBizProfileResp", "bizProfileResp", "setDataFetcher", "dataFetcher", "showErrorView", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseBizProfileFragment
  extends Fragment
  implements r
{
  protected BizProfileDataFetcher Nes;
  protected qm Net;
  protected BizProfileRecyclerView Neu;
  public ContactWidgetTabBizHeaderController Nev;
  private final j New = k.cm((a)new b(this));
  private final j Nex = k.cm((a)new a(this));
  protected String hUQ;
  
  protected final void QZ(String paramString)
  {
    s.u(paramString, "<set-?>");
    this.hUQ = paramString;
  }
  
  protected final void a(BizProfileDataFetcher paramBizProfileDataFetcher)
  {
    s.u(paramBizProfileDataFetcher, "<set-?>");
    this.Nes = paramBizProfileDataFetcher;
  }
  
  protected final void a(BizProfileRecyclerView paramBizProfileRecyclerView)
  {
    s.u(paramBizProfileRecyclerView, "<set-?>");
    this.Neu = paramBizProfileRecyclerView;
  }
  
  public void b(BizProfileDataFetcher paramBizProfileDataFetcher)
  {
    s.u(paramBizProfileDataFetcher, "dataFetcher");
    a(paramBizProfileDataFetcher);
  }
  
  public void dUU() {}
  
  public boolean dUV()
  {
    return false;
  }
  
  protected final void e(qm paramqm)
  {
    s.u(paramqm, "<set-?>");
    this.Net = paramqm;
  }
  
  public void f(qm paramqm)
  {
    s.u(paramqm, "bizProfileResp");
    e(paramqm);
  }
  
  protected final BizProfileDataFetcher gCU()
  {
    BizProfileDataFetcher localBizProfileDataFetcher = this.Nes;
    if (localBizProfileDataFetcher != null) {
      return localBizProfileDataFetcher;
    }
    s.bIx("mDataFetcher");
    return null;
  }
  
  protected final qm gCV()
  {
    qm localqm = this.Net;
    if (localqm != null) {
      return localqm;
    }
    s.bIx("mBizProfileResp");
    return null;
  }
  
  protected final BizProfileRecyclerView gCW()
  {
    BizProfileRecyclerView localBizProfileRecyclerView = this.Neu;
    if (localBizProfileRecyclerView != null) {
      return localBizProfileRecyclerView;
    }
    s.bIx("mRecyclerView");
    return null;
  }
  
  protected final TextView gCX()
  {
    Object localObject = this.Nex.getValue();
    s.s(localObject, "<get-footerTextView>(...)");
    return (TextView)localObject;
  }
  
  protected final View getFooterView()
  {
    Object localObject = this.New.getValue();
    s.s(localObject, "<get-footerView>(...)");
    return (View)localObject;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<TextView>
  {
    a(BaseBizProfileFragment paramBaseBizProfileFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<View>
  {
    b(BaseBizProfileFragment paramBaseBizProfileFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.BaseBizProfileFragment
 * JD-Core Version:    0.7.0.1
 */