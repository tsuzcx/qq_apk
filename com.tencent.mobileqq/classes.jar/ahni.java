import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;

class ahni
  implements bhqd
{
  ahni(ahnd paramahnd, almt paramalmt, DiscussionInfo paramDiscussionInfo, boolean paramBoolean, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Almt;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
    boolean bool;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool = true;
      paramView.a((DiscussionInfo)localObject, bool);
      this.jdField_a_of_type_Bhpy.e();
      if (!this.jdField_a_of_type_Boolean) {
        break label154;
      }
      paramInt = 1;
      label43:
      paramView = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin;
      ((alkk)this.jdField_a_of_type_Ahnd.a.a(22)).notifyUI(18, true, new Object[] { paramView, Integer.valueOf(paramInt), Integer.valueOf(0), null });
      localObject = new azmo(this.jdField_a_of_type_Ahnd.a).a("dc00899").b("Grp_Dis_set").c("Grp_contactlist");
      if (!this.jdField_a_of_type_Boolean) {
        break label159;
      }
    }
    label154:
    label159:
    for (paramView = "Clk_unstick";; paramView = "Clk_stick")
    {
      ((azmo)localObject).d(paramView).a();
      return;
      bool = false;
      break;
      paramInt = 0;
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahni
 * JD-Core Version:    0.7.0.1
 */