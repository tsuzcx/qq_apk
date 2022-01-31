import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.nearby.NearbyJsInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.HashMap;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0x8c1.oidb_0x8c1.RspBody;
import tencent.im.oidb.cmd0x8c1.oidb_0x8c1.SelfCardInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aeuo
  implements BusinessObserver
{
  public aeuo(NearbyJsInterface paramNearbyJsInterface, String paramString, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int j = 0;
    int i = 1;
    Object localObject;
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        localObject = new oidb_sso.OIDBSSOPkg();
      }
    }
    for (;;)
    {
      try
      {
        paramBundle = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramBundle);
        if ((paramBundle.uint32_result.has()) && (paramBundle.uint32_result.get() == 0) && (paramBundle.bytes_bodybuffer.has()) && (paramBundle.bytes_bodybuffer.get() != null))
        {
          localObject = new oidb_0x8c1.RspBody();
          ((oidb_0x8c1.RspBody)localObject).mergeFrom(paramBundle.bytes_bodybuffer.get().toByteArray());
          paramBundle = (oidb_0x8c1.SelfCardInfo)((oidb_0x8c1.RspBody)localObject).msg_card_info.get();
          if (NearbyJsInterface.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface) != 1) {
            continue;
          }
          paramInt = 10002;
          if (!paramBundle.int32_friend_flag.has()) {
            break label283;
          }
          if (paramBundle.int32_friend_flag.get() != 1) {
            continue;
          }
          break label286;
          this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramBundle.bytes_xml_msg.get().toByteArray(), String.valueOf(paramBundle.uint64_uin.get()), paramBundle.int32_direction_flag.get(), paramInt);
          paramBundle = new aeur(String.valueOf(paramBundle.uint64_uin.get()), paramBundle.int32_direction_flag.get());
          this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(this.jdField_a_of_type_JavaLangString), paramBundle);
          if (this.jdField_a_of_type_Boolean) {
            NearbyJsInterface.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface, paramBundle);
          }
        }
        return;
        paramInt = 1001;
        continue;
        i = 0;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      continue;
      label283:
      continue;
      label286:
      if (i != 0) {
        paramInt = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeuo
 * JD-Core Version:    0.7.0.1
 */