import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import java.lang.ref.WeakReference;

public class aajd
  implements DialogInterface.OnClickListener
{
  public aajd(TroopGiftPanel paramTroopGiftPanel, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_Aail != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_Aail.a != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_Aail.a.c)))
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c();
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.j == 2) {
        bdla.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_topay", 0, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.j == 6)
    {
      bdla.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_topay", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.j == 7)
    {
      bdla.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_topay", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.k >= 4)
    {
      anzp.a("gift_store", "pay_tip", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() + "", "", "");
      return;
    }
    bdla.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_topay", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c, "" + mvi.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajd
 * JD-Core Version:    0.7.0.1
 */