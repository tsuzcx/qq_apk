import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class abxm
  implements View.OnClickListener
{
  public abxm(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L) || (this.a.c != 0L))
    {
      this.a.c();
      return;
    }
    switch (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)
    {
    default: 
      return;
    case 0: 
    case 1: 
      this.a.i();
      return;
    }
    if ((this.a.jdField_a_of_type_Long > 0L) && (this.a.jdField_a_of_type_Long <= this.a.jdField_b_of_type_Long) && (this.a.jdField_b_of_type_Int == 0))
    {
      paramView = babr.a(this.a, 230);
      paramView.setTitle(null);
      paramView.setMessage(this.a.getString(2131627852, new Object[] { this.a.jdField_a_of_type_Long + "" }));
      paramView.setPositiveButton(this.a.getString(2131627829), new baca());
      paramView.setPositiveButtonContentDescription(this.a.getString(2131627829));
      paramView.show();
      return;
    }
    paramView = TroopInfoActivity.a(this.a);
    if (!TextUtils.isEmpty(paramView))
    {
      this.a.a(paramView);
      return;
    }
    TroopInfoActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abxm
 * JD-Core Version:    0.7.0.1
 */