import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class aedf
  implements View.OnClickListener
{
  public aedf(TroopInfoActivity paramTroopInfoActivity, Dialog paramDialog, long paramLong1, int paramInt, long paramLong2, long paramLong3, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.finish();
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.jdField_a_of_type_Amdu.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedf
 * JD-Core Version:    0.7.0.1
 */