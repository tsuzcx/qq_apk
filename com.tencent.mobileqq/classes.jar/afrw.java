import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class afrw
  implements akxc
{
  afrw(afru paramafru, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.folderPath;
    if (paramInt == 0) {}
    try
    {
      paramPathResult = paramPathResult + File.separator;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.specailBackgroundAnimInfo = AnimationView.AnimationInfo.loadFromFolder(paramPathResult + "anim_bg");
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "TYPE_SPECAIL_ANIM specailBackgroundAnimInfo=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.specailBackgroundAnimInfo);
      }
      CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo);
      return;
    }
    catch (Throwable paramPathResult)
    {
      for (;;)
      {
        paramPathResult.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrw
 * JD-Core Version:    0.7.0.1
 */