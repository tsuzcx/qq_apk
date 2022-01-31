import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopEntranceBar;

public class ajix
  implements Runnable
{
  public ajix(TroopEntranceBar paramTroopEntranceBar) {}
  
  public void run()
  {
    Object localObject2 = "";
    Object localObject1 = "";
    Object localObject4 = PublicAccountUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (localObject4 != null)
    {
      localObject3 = ((AccountDetail)localObject4).uin;
      localObject4 = ((AccountDetail)localObject4).name;
      localObject1 = localObject4;
      localObject2 = localObject3;
      if (localObject4 != null)
      {
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (((String)localObject4).endsWith("·部落"))
        {
          localObject1 = ((String)localObject4).substring(0, ((String)localObject4).length() - 3);
          localObject2 = localObject3;
        }
      }
    }
    localObject1 = String.format("https://buluo.qq.com/mobile/relativegroup.html?from=%s&scode=%s&keyword=%s&channel=1&_wv=1027&_bid=128", new Object[] { "qun_aio", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localObject1 });
    Object localObject3 = new Intent(this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject3).putExtra("url", (String)localObject1);
    this.a.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "clk_tribechat_aio", "exp_tribechat_aio", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, (String)localObject2, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajix
 * JD-Core Version:    0.7.0.1
 */