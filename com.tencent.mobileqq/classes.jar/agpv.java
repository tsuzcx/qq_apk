import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.qphone.base.util.QLog;

class agpv
  implements IRedPacket.OnGetSkinListener
{
  agpv(agpt paramagpt, Bundle paramBundle, ResultReceiver paramResultReceiver) {}
  
  public void onGetSkin(RedPacketInfoBase paramRedPacketInfoBase)
  {
    this.jdField_a_of_type_AndroidOsBundle.putParcelable("key_red_packet_info", paramRedPacketInfoBase);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCModule", 2, "getRedPacketBundle | info resPath = " + paramRedPacketInfoBase.resPath);
    }
    if (this.jdField_a_of_type_AndroidOsResultReceiver != null) {
      this.jdField_a_of_type_AndroidOsResultReceiver.send(0, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agpv
 * JD-Core Version:    0.7.0.1
 */