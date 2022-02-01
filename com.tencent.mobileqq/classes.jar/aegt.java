import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aegt
  implements View.OnClickListener
{
  public aegt(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = (bgqm)this.a.app.getManager(109);
      if (localObject != null) {
        ((bgqm)localObject).a(true, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
      bgqr.a(2, Long.parseLong((String)localObject), this.a.app, this.a.getApplicationContext(), (BaseActivity)this.a.getActivity());
      long l = Long.parseLong((String)localObject);
      localObject = ((bgks)this.a.app.getManager(355)).a(Long.valueOf(l));
      if (localObject != null) {
        ((bgkr)localObject).c(0);
      }
      bdll.b(null, "dc00898", "", "", "0X800AFC5", "0X800AFC5", 0, 0, String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aegt
 * JD-Core Version:    0.7.0.1
 */