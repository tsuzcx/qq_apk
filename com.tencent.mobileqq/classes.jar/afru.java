import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.SkinRedPacketStrategy.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import org.json.JSONObject;

public class afru
  implements afrq
{
  public aktz a;
  public PreloadManager a;
  private QQAppInterface a;
  
  public afru(QQAppInterface paramQQAppInterface)
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
  
  private void a(@NonNull PreloadManager paramPreloadManager, @NonNull aktz paramaktz, @NonNull CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    String str1 = null;
    String str2 = paramaktz.a("redPack", "https://imgcache.qq.com/channel/static/socialpay/skin/", new String[] { "prefix" });
    switch (paramRedPacketInfo.skinType)
    {
    default: 
      return;
    case 1: 
    case 2: 
      JSONObject localJSONObject = paramaktz.a("redPack", new String[] { "skinMap" });
      paramaktz = str1;
      if (localJSONObject != null)
      {
        localJSONObject = localJSONObject.optJSONObject(String.valueOf(paramRedPacketInfo.skinId));
        paramaktz = str1;
        if (localJSONObject != null)
        {
          paramaktz = localJSONObject.optString("aioZipMd5", "");
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
        paramPreloadManager.a(str2 + str1 + paramRedPacketInfo.skinId + ".zip", paramaktz, new afrv(this, paramRedPacketInfo));
        return;
        paramaktz = str1;
        break;
      }
    case 3: 
      label220:
      paramaktz = paramaktz.a("redPack", null, new String[] { "bigAnimMap", String.valueOf(paramRedPacketInfo.bigAnimId), "zipMd5" });
      paramPreloadManager.a(str2 + "aio_special_" + paramRedPacketInfo.bigAnimId + ".zip", paramaktz, new afrw(this, paramRedPacketInfo));
      return;
    }
    paramaktz = paramaktz.a("redPack", null, new String[] { "popAnimMap", String.valueOf(paramRedPacketInfo.bigAnimId), "zipMd5" });
    paramPreloadManager.a(str2 + "pop_anim_" + paramRedPacketInfo.bigAnimId + ".png", paramaktz, new afrx(this, paramRedPacketInfo));
  }
  
  public void a() {}
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    ThreadManager.post(new CustomizeStrategyFactory.SkinRedPacketStrategy.1(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, ahya paramahya)
  {
    if (paramRedPacketInfo != null)
    {
      if (!(paramahya instanceof ahye)) {
        break label74;
      }
      paramahya = (ahye)paramahya;
      paramRedPacketInfo.background = paramahya.b;
      paramRedPacketInfo.corner = paramahya.jdField_a_of_type_AndroidGraphicsBitmap;
      paramRedPacketInfo.animInfo = paramahya.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
      paramRedPacketInfo.title = paramahya.c;
      paramRedPacketInfo.icon = paramahya.a(paramRedPacketInfo);
      paramRedPacketInfo.isHideTitle = paramahya.jdField_a_of_type_Int;
      paramRedPacketInfo.resPath = paramahya.d;
    }
    label74:
    do
    {
      return;
      if ((paramahya instanceof ahyb))
      {
        paramahya = (ahyb)paramahya;
        paramRedPacketInfo.specailBackgroundAnimInfo = paramahya.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
        paramRedPacketInfo.specialBackground = paramahya.jdField_a_of_type_AndroidGraphicsBitmap;
        return;
      }
    } while (!(paramahya instanceof ahyd));
    paramRedPacketInfo.resPath = ((ahyd)paramahya).b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afru
 * JD-Core Version:    0.7.0.1
 */