import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.ThemeAnimStrategy.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class acvm
  implements acve
{
  private PreloadManager jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public acvm(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = ((PreloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(151));
    }
  }
  
  public void a() {}
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo == null) {
      return;
    }
    ThreadManager.post(new CustomizeStrategyFactory.ThemeAnimStrategy.1(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, aels paramaels)
  {
    if ((paramRedPacketInfo != null) && ((paramaels instanceof aelx))) {
      paramRedPacketInfo.animInfo = ((aelx)paramaels).a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acvm
 * JD-Core Version:    0.7.0.1
 */