import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;

class afdv
  implements begw
{
  afdv(afdq paramafdq, ajhf paramajhf, DiscussionInfo paramDiscussionInfo, boolean paramBoolean, begr parambegr) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Ajhf;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
    boolean bool;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool = true;
      paramView.a((DiscussionInfo)localObject, bool);
      this.jdField_a_of_type_Begr.e();
      if (!this.jdField_a_of_type_Boolean) {
        break label154;
      }
      paramInt = 1;
      label43:
      paramView = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin;
      ((ajex)this.jdField_a_of_type_Afdq.a.a(22)).notifyUI(18, true, new Object[] { paramView, Integer.valueOf(paramInt), Integer.valueOf(0), null });
      localObject = new awrb(this.jdField_a_of_type_Afdq.a).a("dc00899").b("Grp_Dis_set").c("Grp_contactlist");
      if (!this.jdField_a_of_type_Boolean) {
        break label159;
      }
    }
    label154:
    label159:
    for (paramView = "Clk_unstick";; paramView = "Clk_stick")
    {
      ((awrb)localObject).d(paramView).a();
      return;
      bool = false;
      break;
      paramInt = 0;
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afdv
 * JD-Core Version:    0.7.0.1
 */