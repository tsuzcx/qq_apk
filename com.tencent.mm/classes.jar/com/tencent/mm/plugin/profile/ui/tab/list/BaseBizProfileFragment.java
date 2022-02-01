package com.tencent.mm.plugin.profile.ui.tab.list;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.profile.ui.tab.data.BizProfileDataFetcher;
import com.tencent.mm.protocal.protobuf.ph;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "Landroid/support/v4/app/Fragment;", "()V", "bizUsername", "", "getBizUsername", "()Ljava/lang/String;", "setBizUsername", "(Ljava/lang/String;)V", "footerTextView", "Landroid/widget/TextView;", "getFooterTextView", "()Landroid/widget/TextView;", "footerTextView$delegate", "Lkotlin/Lazy;", "footerView", "Landroid/view/View;", "getFooterView", "()Landroid/view/View;", "footerView$delegate", "mBizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "getMBizProfileResp", "()Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "setMBizProfileResp", "(Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;)V", "mDataFetcher", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "getMDataFetcher", "()Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "setMDataFetcher", "(Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;)V", "msgType", "", "getMsgType", "()I", "fetchMsgList", "", "onAppBarLayoutExpand", "setBizProfileResp", "bizProfileResp", "setDataFetcher", "dataFetcher", "showErrorView", "app_release"})
public abstract class BaseBizProfileFragment
  extends Fragment
{
  protected BizProfileDataFetcher BmN;
  protected ph BmO;
  private final f BmP = g.ah((a)new b(this));
  private final f BmQ = g.ah((a)new a(this));
  protected String dVu;
  
  protected final void Rx(String paramString)
  {
    p.h(paramString, "<set-?>");
    this.dVu = paramString;
  }
  
  protected final void d(BizProfileDataFetcher paramBizProfileDataFetcher)
  {
    p.h(paramBizProfileDataFetcher, "<set-?>");
    this.BmN = paramBizProfileDataFetcher;
  }
  
  public void e(BizProfileDataFetcher paramBizProfileDataFetcher)
  {
    p.h(paramBizProfileDataFetcher, "dataFetcher");
    this.BmN = paramBizProfileDataFetcher;
  }
  
  protected final void e(ph paramph)
  {
    p.h(paramph, "<set-?>");
    this.BmO = paramph;
  }
  
  protected final BizProfileDataFetcher eFJ()
  {
    BizProfileDataFetcher localBizProfileDataFetcher = this.BmN;
    if (localBizProfileDataFetcher == null) {
      p.btv("mDataFetcher");
    }
    return localBizProfileDataFetcher;
  }
  
  protected final ph eFK()
  {
    ph localph = this.BmO;
    if (localph == null) {
      p.btv("mBizProfileResp");
    }
    return localph;
  }
  
  protected final TextView eFL()
  {
    return (TextView)this.BmQ.getValue();
  }
  
  public void eFM() {}
  
  public void f(ph paramph)
  {
    p.h(paramph, "bizProfileResp");
    this.BmO = paramph;
  }
  
  protected final View getFooterView()
  {
    return (View)this.BmP.getValue();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements a<TextView>
  {
    a(BaseBizProfileFragment paramBaseBizProfileFragment)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.BaseBizProfileFragment
 * JD-Core Version:    0.7.0.1
 */