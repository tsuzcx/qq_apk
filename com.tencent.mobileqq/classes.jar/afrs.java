import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.PanelStrategy.1;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;

public class afrs
  implements afrq
{
  public aktz a;
  public PreloadManager a;
  private QQAppInterface a;
  
  public afrs(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = null;
    this.jdField_a_of_type_Aktz = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = ((PreloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PRELOAD_MANAGER));
      this.jdField_a_of_type_Aktz = ((aktz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER));
    }
  }
  
  public void a() {}
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    ThreadManager.post(new CustomizeStrategyFactory.PanelStrategy.1(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, ahya paramahya)
  {
    if ((paramRedPacketInfo != null) && ((paramahya instanceof ahyc)))
    {
      paramahya = (ahyc)paramahya;
      paramRedPacketInfo.icon = paramahya.a;
      paramRedPacketInfo.resPath = paramahya.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrs
 * JD-Core Version:    0.7.0.1
 */