import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.SkinRedPacketStrategy.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class acvm
  implements acvi
{
  public agzf a;
  public PreloadManager a;
  private QQAppInterface a;
  
  public acvm(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = null;
    this.jdField_a_of_type_Agzf = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = ((PreloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(151));
      this.jdField_a_of_type_Agzf = ((agzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245));
    }
  }
  
  public void a() {}
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    ThreadManager.post(new CustomizeStrategyFactory.SkinRedPacketStrategy.1(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, aelu paramaelu)
  {
    if (paramRedPacketInfo != null)
    {
      if (!(paramaelu instanceof aely)) {
        break label74;
      }
      paramaelu = (aely)paramaelu;
      paramRedPacketInfo.background = paramaelu.b;
      paramRedPacketInfo.corner = paramaelu.jdField_a_of_type_AndroidGraphicsBitmap;
      paramRedPacketInfo.animInfo = paramaelu.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
      paramRedPacketInfo.title = paramaelu.c;
      paramRedPacketInfo.icon = paramaelu.a(paramRedPacketInfo);
      paramRedPacketInfo.isHideTitle = paramaelu.jdField_a_of_type_Int;
      paramRedPacketInfo.resPath = paramaelu.d;
    }
    label74:
    do
    {
      return;
      if ((paramaelu instanceof aelv))
      {
        paramaelu = (aelv)paramaelu;
        paramRedPacketInfo.specailBackgroundAnimInfo = paramaelu.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
        paramRedPacketInfo.specialBackground = paramaelu.jdField_a_of_type_AndroidGraphicsBitmap;
        return;
      }
    } while (!(paramaelu instanceof aelx));
    paramRedPacketInfo.resPath = ((aelx)paramaelu).b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acvm
 * JD-Core Version:    0.7.0.1
 */