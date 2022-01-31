import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.QZoneEntryController;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import java.util.HashMap;
import java.util.Map;

class aeav
  implements Runnable
{
  aeav(aeau paramaeau, QZoneManagerImp paramQZoneManagerImp) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqServletQZoneManagerImp.c(53);
    Map localMap = QZoneUnreadServletLogic.a(Long.valueOf(this.jdField_a_of_type_Aeau.a.a.getLongAccountUin()));
    Object localObject = localMap;
    if (localMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put(Long.valueOf(53L), Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    QZoneUnreadServletLogic.a((Map)localObject, Long.valueOf(this.jdField_a_of_type_Aeau.a.a.getLongAccountUin()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeav
 * JD-Core Version:    0.7.0.1
 */