import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aawy
  implements aaxv
{
  public aawy(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void a(int paramInt) {}
  
  public void a(List<bgtf> paramList, aawq paramaawq)
  {
    if (this.a.jdField_a_of_type_Aawm == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGiftPanel", 2, "getPackGiftStorage--onGetPackGift error--mTroopGifPanelData is null");
      }
      return;
    }
    this.a.jdField_a_of_type_Aawm.b(paramList);
    this.a.jdField_a_of_type_Aawm.a(paramaawq);
    if ((this.a.jdField_a_of_type_Aawm != null) && (this.a.jdField_a_of_type_Aawm.jdField_e_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_Aawm.jdField_e_of_type_JavaUtilArrayList.size() > 0) && (this.a.jdField_a_of_type_Aawm.b.size() > 0) && (this.a.jdField_a_of_type_Aawm.jdField_e_of_type_Int != -1))
    {
      this.a.jdField_a_of_type_Aawl = ((aawl)this.a.jdField_a_of_type_Aawm.jdField_e_of_type_JavaUtilArrayList.get(this.a.jdField_a_of_type_Aawm.jdField_e_of_type_Int));
      TroopGiftPanel.a(this.a, this.a.jdField_a_of_type_Aawl);
    }
    if (this.a.d())
    {
      paramList = this.a;
      if ((!TextUtils.isEmpty(this.a.f)) && (TroopGiftPanel.a(this.a))) {}
      for (boolean bool = true;; bool = false)
      {
        paramList.setSendGiftBtnEnabled(bool);
        return;
      }
    }
    this.a.setSendGiftBtnEnabled(TroopGiftPanel.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aawy
 * JD-Core Version:    0.7.0.1
 */