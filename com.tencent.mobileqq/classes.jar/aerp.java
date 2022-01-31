import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.ConcurrentHashMap;

class aerp
  implements View.OnClickListener
{
  aerp(aerj paramaerj) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 == null) || (!(localObject1 instanceof Integer))) {
      return;
    }
    paramView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) {
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f;
    }
    for (;;)
    {
      switch (((Integer)localObject1).intValue())
      {
      default: 
        return;
      case 1: 
        ((aszf)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)).d.put(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(1));
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001)
        {
          paramView = "2";
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {}
          akbl.a((QQAppInterface)localObject1, (String)localObject2, paramView, "1", 2, new aerq(this));
          localObject1 = (aset)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(16);
          localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) {
            break label284;
          }
          paramView = "0";
          label235:
          if (!((aset)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break label290;
          }
        }
        label284:
        label290:
        for (localObject1 = "1";; localObject1 = "0")
        {
          axqy.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "c2c_tmp", "follow_aio", 0, 0, paramView, "0", (String)localObject1, "");
          return;
          paramView = "1";
          break;
          paramView = "1";
          break label235;
        }
      }
      ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, false);
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) {
        axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
      }
      Object localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001)
      {
        paramView = "0";
        if (!this.a.Z) {
          break label458;
        }
      }
      label458:
      for (localObject1 = "0";; localObject1 = "1")
      {
        axqy.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "c2c_tmp", "block_aio", 0, 0, paramView, "0", (String)localObject1, "");
        return;
        paramView = "1";
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aerp
 * JD-Core Version:    0.7.0.1
 */