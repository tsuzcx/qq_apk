import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.DownAdapter;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ajir
  extends UiCallBack.DownAdapter
{
  public ajir(TroopPicEffectsController paramTroopPicEffectsController, PicDownloadInfo paramPicDownloadInfo, TroopChatPie paramTroopChatPie, MessageForTroopEffectPic paramMessageForTroopEffectPic, boolean paramBoolean) {}
  
  public void a(int paramInt, PicResult paramPicResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopPicEffectsController", 2, "2g diy gif onDownload");
    }
    paramPicResult = new File(this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.c());
    AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a.getManager(222);
    if ((paramPicResult.exists()) && (localAIOAnimationControlManager != null))
    {
      localAIOAnimationControlManager.a = 1;
      localAIOAnimationControlManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie);
      localAIOAnimationControlManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopEffectPic, this.jdField_a_of_type_Boolean);
      localAIOAnimationControlManager.g();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("TroopPicEffectsController", 2, "[EffectPic] file not exist or isplaying.");
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopPicEffectsController", 2, "2g diy gif onUpdateProgress");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajir
 * JD-Core Version:    0.7.0.1
 */