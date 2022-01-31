import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class abqp
  implements Runnable
{
  public abqp(NearbyTransitActivity paramNearbyTransitActivity, Common.WifiPOIInfo paramWifiPOIInfo) {}
  
  public void run()
  {
    boolean bool = true;
    HotChatHandler localHotChatHandler = (HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqDatingNearbyTransitActivity.app.a(35);
    Common.WifiPOIInfo localWifiPOIInfo = this.jdField_a_of_type_TencentImOidbHotchatCommon$WifiPOIInfo;
    if (this.jdField_a_of_type_TencentImOidbHotchatCommon$WifiPOIInfo.uint32_wifi_poi_type.get() == 1) {}
    for (;;)
    {
      localHotChatHandler.a(localWifiPOIInfo, bool, 4, NearbyTransitActivity.c(this.jdField_a_of_type_ComTencentMobileqqDatingNearbyTransitActivity));
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abqp
 * JD-Core Version:    0.7.0.1
 */