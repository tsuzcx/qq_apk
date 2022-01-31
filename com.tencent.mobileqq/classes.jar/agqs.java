import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import java.lang.ref.WeakReference;

public class agqs
  implements ackq
{
  public agqs(RedPacketManager paramRedPacketManager, RedPacketInfoBase paramRedPacketInfoBase, WeakReference paramWeakReference) {}
  
  public void onSucc(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    paramRedPacketInfo.isCache = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.isCache;
    IRedPacket.OnGetSkinListener localOnGetSkinListener = (IRedPacket.OnGetSkinListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localOnGetSkinListener != null) {
      localOnGetSkinListener.onGetSkin(paramRedPacketInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agqs
 * JD-Core Version:    0.7.0.1
 */