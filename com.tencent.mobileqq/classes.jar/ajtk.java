import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.logic.HomeworkTroopController;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.mobileqq.troop.utils.TroopLinkManager.LinkParams;
import com.tencent.mobileqq.util.TroopReportor;
import java.lang.ref.WeakReference;

public class ajtk
  implements View.OnClickListener
{
  public ajtk(HomeworkTroopController paramHomeworkTroopController) {}
  
  public void onClick(View paramView)
  {
    paramView = (BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramView != null)
    {
      HWTroopUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      Object localObject1 = TroopLinkManager.a();
      Object localObject2 = ((TroopLinkManager)localObject1).a("troop_list_homework");
      TroopLinkManager.LinkParams localLinkParams = new TroopLinkManager.LinkParams();
      localLinkParams.a = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      localLinkParams.c = "aio";
      localObject1 = ((TroopLinkManager)localObject1).a((String)localObject2, localLinkParams);
      localObject2 = new Intent(paramView, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      paramView.startActivity((Intent)localObject2);
      TroopReportor.a("Grp_edu", "homework", "AioSee_Clk", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, TroopReportor.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "", TroopReportor.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtk
 * JD-Core Version:    0.7.0.1
 */