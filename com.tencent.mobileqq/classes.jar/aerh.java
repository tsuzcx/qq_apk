import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.SkinRedPacketStrategy.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class aerh
  implements aerd
{
  public aixs a;
  public PreloadManager a;
  private QQAppInterface a;
  
  public aerh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = null;
    this.jdField_a_of_type_Aixs = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = ((PreloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(151));
      this.jdField_a_of_type_Aixs = ((aixs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245));
    }
  }
  
  public void a() {}
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    ThreadManager.post(new CustomizeStrategyFactory.SkinRedPacketStrategy.1(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, agmy paramagmy)
  {
    if (paramRedPacketInfo != null)
    {
      if (!(paramagmy instanceof agnc)) {
        break label74;
      }
      paramagmy = (agnc)paramagmy;
      paramRedPacketInfo.background = paramagmy.b;
      paramRedPacketInfo.corner = paramagmy.jdField_a_of_type_AndroidGraphicsBitmap;
      paramRedPacketInfo.animInfo = paramagmy.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
      paramRedPacketInfo.title = paramagmy.c;
      paramRedPacketInfo.icon = paramagmy.a(paramRedPacketInfo);
      paramRedPacketInfo.isHideTitle = paramagmy.jdField_a_of_type_Int;
      paramRedPacketInfo.resPath = paramagmy.d;
    }
    label74:
    do
    {
      return;
      if ((paramagmy instanceof agmz))
      {
        paramagmy = (agmz)paramagmy;
        paramRedPacketInfo.specailBackgroundAnimInfo = paramagmy.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
        paramRedPacketInfo.specialBackground = paramagmy.jdField_a_of_type_AndroidGraphicsBitmap;
        return;
      }
    } while (!(paramagmy instanceof agnb));
    paramRedPacketInfo.resPath = ((agnb)paramagmy).b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aerh
 * JD-Core Version:    0.7.0.1
 */