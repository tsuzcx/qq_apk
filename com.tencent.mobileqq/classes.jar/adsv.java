import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adsv
  implements View.OnClickListener
{
  public adsv(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = (bgig)this.a.app.getManager(QQManagerFactory.TROOP_APP_MGR);
      if (localObject != null) {
        ((bgig)localObject).a(true, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
      bgil.a(2, Long.parseLong((String)localObject), this.a.app, this.a.getApplicationContext(), (BaseActivity)this.a.getActivity());
      long l = Long.parseLong((String)localObject);
      localObject = ((bgbg)this.a.app.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(l));
      if (localObject != null) {
        ((bgbf)localObject).c(0);
      }
      bdla.b(null, "dc00898", "", "", "0X800AFC5", "0X800AFC5", 0, 0, String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsv
 * JD-Core Version:    0.7.0.1
 */