import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.IPSiteModel.Goods;
import com.tencent.mobileqq.emoticonview.IPSiteListGoodsAdapter;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class abze
  implements View.OnClickListener
{
  public abze(IPSiteListGoodsAdapter paramIPSiteListGoodsAdapter, IPSiteModel.Goods paramGoods) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(IPSiteListGoodsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPSiteListGoodsAdapter), QQBrowserActivity.class);
    paramView.putExtra("hide_operation_bar", true);
    VasWebviewUtil.openQQBrowserWithoutAD(IPSiteListGoodsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPSiteListGoodsAdapter), this.jdField_a_of_type_ComTencentMobileqqDataIPSiteModel$Goods.moreUrl, -1L, paramView, false, -1);
    VasWebviewUtil.reportCommercialDrainage(IPSiteListGoodsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPSiteListGoodsAdapter), "IP", "aio_productmore", "", 0, 0, 0, IPSiteListGoodsAdapter.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPSiteListGoodsAdapter), IPSiteListGoodsAdapter.c(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPSiteListGoodsAdapter), "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abze
 * JD-Core Version:    0.7.0.1
 */