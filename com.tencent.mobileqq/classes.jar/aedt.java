import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class aedt
  implements View.OnClickListener
{
  public aedt(TroopInfoActivity paramTroopInfoActivity) {}
  
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
      paramView = bdgm.a(this.a, 230);
      paramView.setTitle(null);
      paramView.setMessage(this.a.getString(2131693597, new Object[] { this.a.jdField_a_of_type_Long + "" }));
      paramView.setPositiveButton(this.a.getString(2131693574), new bdgx());
      paramView.setPositiveButtonContentDescription(this.a.getString(2131693574));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedt
 * JD-Core Version:    0.7.0.1
 */