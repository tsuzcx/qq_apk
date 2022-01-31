import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.SkinRedPacketStrategy.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class ackt
  implements ackp
{
  public agmq a;
  public PreloadManager a;
  private QQAppInterface a;
  
  public ackt(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = null;
    this.jdField_a_of_type_Agmq = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = ((PreloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(151));
      this.jdField_a_of_type_Agmq = ((agmq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245));
    }
  }
  
  public void a() {}
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    ThreadManager.post(new CustomizeStrategyFactory.SkinRedPacketStrategy.1(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, aeav paramaeav)
  {
    if (paramRedPacketInfo != null)
    {
      if (!(paramaeav instanceof aeaz)) {
        break label74;
      }
      paramaeav = (aeaz)paramaeav;
      paramRedPacketInfo.background = paramaeav.b;
      paramRedPacketInfo.corner = paramaeav.jdField_a_of_type_AndroidGraphicsBitmap;
      paramRedPacketInfo.animInfo = paramaeav.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
      paramRedPacketInfo.title = paramaeav.c;
      paramRedPacketInfo.icon = paramaeav.a(paramRedPacketInfo);
      paramRedPacketInfo.isHideTitle = paramaeav.jdField_a_of_type_Int;
      paramRedPacketInfo.resPath = paramaeav.d;
    }
    label74:
    do
    {
      return;
      if ((paramaeav instanceof aeaw))
      {
        paramaeav = (aeaw)paramaeav;
        paramRedPacketInfo.specailBackgroundAnimInfo = paramaeav.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
        paramRedPacketInfo.specialBackground = paramaeav.jdField_a_of_type_AndroidGraphicsBitmap;
        return;
      }
    } while (!(paramaeav instanceof aeay));
    paramRedPacketInfo.resPath = ((aeay)paramaeav).b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ackt
 * JD-Core Version:    0.7.0.1
 */