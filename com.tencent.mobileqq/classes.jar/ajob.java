import android.view.View;
import com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;

public class ajob
  implements bkzq
{
  public ajob(ContactsTroopAdapter paramContactsTroopAdapter, antl paramantl, DiscussionInfo paramDiscussionInfo, boolean paramBoolean, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Antl;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
    boolean bool;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool = true;
      paramView.a((DiscussionInfo)localObject, bool);
      this.jdField_a_of_type_Bkzi.e();
      if (!this.jdField_a_of_type_Boolean) {
        break label155;
      }
      paramInt = 1;
      label43:
      paramView = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin;
      ((anrb)this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.a.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER)).notifyUI(18, true, new Object[] { paramView, Integer.valueOf(paramInt), Integer.valueOf(0), null });
      localObject = new bdlf(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.a).a("dc00899").b("Grp_Dis_set").c("Grp_contactlist");
      if (!this.jdField_a_of_type_Boolean) {
        break label160;
      }
    }
    label155:
    label160:
    for (paramView = "Clk_unstick";; paramView = "Clk_stick")
    {
      ((bdlf)localObject).d(paramView).a();
      return;
      bool = false;
      break;
      paramInt = 0;
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajob
 * JD-Core Version:    0.7.0.1
 */