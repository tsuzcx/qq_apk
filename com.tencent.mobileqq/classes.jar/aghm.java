import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.SkinRedPacketStrategy.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import org.json.JSONObject;

public class aghm
  implements aghi
{
  public alao a;
  public PreloadManager a;
  private QQAppInterface a;
  
  public aghm(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = null;
    this.jdField_a_of_type_Alao = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = ((PreloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(151));
      this.jdField_a_of_type_Alao = ((alao)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245));
    }
  }
  
  private void a(@NonNull PreloadManager paramPreloadManager, @NonNull alao paramalao, @NonNull CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    String str1 = null;
    String str2 = paramalao.a("redPack", "https://imgcache.qq.com/channel/static/socialpay/skin/", new String[] { "prefix" });
    switch (paramRedPacketInfo.skinType)
    {
    default: 
      return;
    case 1: 
    case 2: 
      JSONObject localJSONObject = paramalao.a("redPack", new String[] { "skinMap" });
      paramalao = str1;
      if (localJSONObject != null)
      {
        localJSONObject = localJSONObject.optJSONObject(String.valueOf(paramRedPacketInfo.skinId));
        paramalao = str1;
        if (localJSONObject != null)
        {
          paramalao = localJSONObject.optString("aioZipMd5", "");
          str1 = localJSONObject.optString("popZipMd5", "");
          if (paramRedPacketInfo.skinType != 1) {
            break label220;
          }
          paramRedPacketInfo.title = localJSONObject.optString("title", "");
          paramRedPacketInfo.isHideTitle = localJSONObject.optInt("isHideTitle", paramRedPacketInfo.a());
        }
      }
      if (paramRedPacketInfo.skinType == 1) {}
      for (str1 = "aio_";; str1 = "pop_")
      {
        paramPreloadManager.a(str2 + str1 + paramRedPacketInfo.skinId + ".zip", paramalao, new aghn(this, paramRedPacketInfo));
        return;
        paramalao = str1;
        break;
      }
    case 3: 
      label220:
      paramalao = paramalao.a("redPack", null, new String[] { "bigAnimMap", String.valueOf(paramRedPacketInfo.bigAnimId), "zipMd5" });
      paramPreloadManager.a(str2 + "aio_special_" + paramRedPacketInfo.bigAnimId + ".zip", paramalao, new agho(this, paramRedPacketInfo));
      return;
    }
    paramalao = paramalao.a("redPack", null, new String[] { "popAnimMap", String.valueOf(paramRedPacketInfo.bigAnimId), "zipMd5" });
    paramPreloadManager.a(str2 + "pop_anim_" + paramRedPacketInfo.bigAnimId + ".png", paramalao, new aghp(this, paramRedPacketInfo));
  }
  
  public void a() {}
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    ThreadManager.post(new CustomizeStrategyFactory.SkinRedPacketStrategy.1(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, aigs paramaigs)
  {
    if (paramRedPacketInfo != null)
    {
      if (!(paramaigs instanceof aigw)) {
        break label74;
      }
      paramaigs = (aigw)paramaigs;
      paramRedPacketInfo.background = paramaigs.b;
      paramRedPacketInfo.corner = paramaigs.jdField_a_of_type_AndroidGraphicsBitmap;
      paramRedPacketInfo.animInfo = paramaigs.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
      paramRedPacketInfo.title = paramaigs.c;
      paramRedPacketInfo.icon = paramaigs.a(paramRedPacketInfo);
      paramRedPacketInfo.isHideTitle = paramaigs.jdField_a_of_type_Int;
      paramRedPacketInfo.resPath = paramaigs.d;
    }
    label74:
    do
    {
      return;
      if ((paramaigs instanceof aigt))
      {
        paramaigs = (aigt)paramaigs;
        paramRedPacketInfo.specailBackgroundAnimInfo = paramaigs.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
        paramRedPacketInfo.specialBackground = paramaigs.jdField_a_of_type_AndroidGraphicsBitmap;
        return;
      }
    } while (!(paramaigs instanceof aigv));
    paramRedPacketInfo.resPath = ((aigv)paramaigs).b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghm
 * JD-Core Version:    0.7.0.1
 */