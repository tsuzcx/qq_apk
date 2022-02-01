import com.tencent.device.qfind.QFindBLEScanMgr;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.oidb.qfind.QFind.DeviceInfo;

public class acaq
  extends apcq
{
  public acaq(QFindBLEScanMgr paramQFindBLEScanMgr, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      QFind.DeviceInfo localDeviceInfo = (QFind.DeviceInfo)this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr.c.get(this.jdField_a_of_type_JavaLangString);
      acai localacai = (acai)this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr.a.remove(this.jdField_a_of_type_JavaLangString);
      localacai.a = paramSosoLbsInfo;
      byte[] arrayOfByte;
      boolean bool;
      if (localDeviceInfo.bytes_sig.has())
      {
        arrayOfByte = localDeviceInfo.bytes_sig.get().toByteArray();
        localacai.jdField_b_of_type_ArrayOfByte = arrayOfByte;
        localacai.d = localDeviceInfo.uint32_need_verify_dev.get();
        if ((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L) - localDeviceInfo.timestamp.get() <= localDeviceInfo.uint32_verify_dev_interval.get()) {
          break label246;
        }
        bool = true;
        label122:
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE", 2, "reportDevWithLoc get location errorCode=" + paramInt + " ; needVerify = " + localacai.d + " ; exceedVerifyInterval= " + bool + " ; peerInfo.ble_id = " + localacai.c);
        }
        if ((localacai.d <= 0) || (!bool)) {
          break label251;
        }
        localacai.jdField_b_of_type_Boolean = true;
        abub.a().a(this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr.a(localacai));
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr.a.put(this.jdField_a_of_type_JavaLangString, localacai);
        return;
        arrayOfByte = null;
        break;
        label246:
        bool = false;
        break label122;
        label251:
        localacai.jdField_b_of_type_Boolean = false;
        QFindBLEScanMgr.a(this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr, localacai, paramSosoLbsInfo, false);
      }
    }
    QLog.e("QFindBLE", 1, "reportDevWithLoc get location failed errorCode=" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acaq
 * JD-Core Version:    0.7.0.1
 */