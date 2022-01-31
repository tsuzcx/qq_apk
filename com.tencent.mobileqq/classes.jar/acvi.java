import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.SkinRedPacketStrategy.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class acvi
  implements acve
{
  public agzd a;
  public PreloadManager a;
  private QQAppInterface a;
  
  public acvi(QQAppInterface paramQQAppInterface)
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
    ThreadManager.post(new CustomizeStrategyFactory.SkinRedPacketStrategy.1(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, aels paramaels)
  {
    if (paramRedPacketInfo != null)
    {
      if (!(paramaels instanceof aelw)) {
        break label74;
      }
      paramaels = (aelw)paramaels;
      paramRedPacketInfo.background = paramaels.b;
      paramRedPacketInfo.corner = paramaels.jdField_a_of_type_AndroidGraphicsBitmap;
      paramRedPacketInfo.animInfo = paramaels.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
      paramRedPacketInfo.title = paramaels.c;
      paramRedPacketInfo.icon = paramaels.a(paramRedPacketInfo);
      paramRedPacketInfo.isHideTitle = paramaels.jdField_a_of_type_Int;
      paramRedPacketInfo.resPath = paramaels.d;
    }
    label74:
    do
    {
      return;
      if ((paramaels instanceof aelt))
      {
        paramaels = (aelt)paramaels;
        paramRedPacketInfo.specailBackgroundAnimInfo = paramaels.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
        paramRedPacketInfo.specialBackground = paramaels.jdField_a_of_type_AndroidGraphicsBitmap;
        return;
      }
    } while (!(paramaels instanceof aelv));
    paramRedPacketInfo.resPath = ((aelv)paramaels).b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acvi
 * JD-Core Version:    0.7.0.1
 */