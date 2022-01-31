import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;

class afpr
  implements bfph
{
  afpr(afpm paramafpm, ajvg paramajvg, DiscussionInfo paramDiscussionInfo, boolean paramBoolean, bfpc parambfpc) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Ajvg;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
    boolean bool;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool = true;
      paramView.a((DiscussionInfo)localObject, bool);
      this.jdField_a_of_type_Bfpc.e();
      if (!this.jdField_a_of_type_Boolean) {
        break label154;
      }
      paramInt = 1;
      label43:
      paramView = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin;
      ((ajsx)this.jdField_a_of_type_Afpm.a.a(22)).notifyUI(18, true, new Object[] { paramView, Integer.valueOf(paramInt), Integer.valueOf(0), null });
      localObject = new axrc(this.jdField_a_of_type_Afpm.a).a("dc00899").b("Grp_Dis_set").c("Grp_contactlist");
      if (!this.jdField_a_of_type_Boolean) {
        break label159;
      }
    }
    label154:
    label159:
    for (paramView = "Clk_unstick";; paramView = "Clk_stick")
    {
      ((axrc)localObject).d(paramView).a();
      return;
      bool = false;
      break;
      paramInt = 0;
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afpr
 * JD-Core Version:    0.7.0.1
 */