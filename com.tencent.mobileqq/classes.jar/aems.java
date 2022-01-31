import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.SkinRedPacketStrategy.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class aems
  implements aemo
{
  public aitd a;
  public PreloadManager a;
  private QQAppInterface a;
  
  public aems(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = null;
    this.jdField_a_of_type_Aitd = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = ((PreloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(151));
      this.jdField_a_of_type_Aitd = ((aitd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245));
    }
  }
  
  public void a() {}
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    ThreadManager.post(new CustomizeStrategyFactory.SkinRedPacketStrategy.1(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, agij paramagij)
  {
    if (paramRedPacketInfo != null)
    {
      if (!(paramagij instanceof agin)) {
        break label74;
      }
      paramagij = (agin)paramagij;
      paramRedPacketInfo.background = paramagij.b;
      paramRedPacketInfo.corner = paramagij.jdField_a_of_type_AndroidGraphicsBitmap;
      paramRedPacketInfo.animInfo = paramagij.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
      paramRedPacketInfo.title = paramagij.c;
      paramRedPacketInfo.icon = paramagij.a(paramRedPacketInfo);
      paramRedPacketInfo.isHideTitle = paramagij.jdField_a_of_type_Int;
      paramRedPacketInfo.resPath = paramagij.d;
    }
    label74:
    do
    {
      return;
      if ((paramagij instanceof agik))
      {
        paramagij = (agik)paramagij;
        paramRedPacketInfo.specailBackgroundAnimInfo = paramagij.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
        paramRedPacketInfo.specialBackground = paramagij.jdField_a_of_type_AndroidGraphicsBitmap;
        return;
      }
    } while (!(paramagij instanceof agim));
    paramRedPacketInfo.resPath = ((agim)paramagij).b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aems
 * JD-Core Version:    0.7.0.1
 */