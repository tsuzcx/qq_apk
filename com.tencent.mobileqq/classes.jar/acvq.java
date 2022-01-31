import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.VoiceResStrategy.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class acvq
  implements acve
{
  public agzd a;
  public PreloadManager a;
  private QQAppInterface a;
  
  public acvq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = null;
    this.jdField_a_of_type_Agzd = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = ((PreloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(151));
      this.jdField_a_of_type_Agzd = ((agzd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245));
    }
  }
  
  public void a() {}
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    ThreadManager.post(new CustomizeStrategyFactory.VoiceResStrategy.1(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, aels paramaels)
  {
    if ((paramRedPacketInfo != null) && ((paramaels instanceof aelz)))
    {
      paramaels = (aelz)paramaels;
      paramRedPacketInfo.icon = paramaels.a;
      paramRedPacketInfo.resPath = paramaels.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acvq
 * JD-Core Version:    0.7.0.1
 */