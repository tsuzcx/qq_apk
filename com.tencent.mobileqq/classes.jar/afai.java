import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.SkinRedPacketStrategy.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import org.json.JSONObject;

public class afai
  implements afae
{
  public ajyg a;
  public PreloadManager a;
  private QQAppInterface a;
  
  public afai(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = null;
    this.jdField_a_of_type_Ajyg = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = ((PreloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(151));
      this.jdField_a_of_type_Ajyg = ((ajyg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245));
    }
  }
  
  private void a(@NonNull PreloadManager paramPreloadManager, @NonNull ajyg paramajyg, @NonNull CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    String str1 = null;
    String str2 = paramajyg.a("redPack", "https://imgcache.qq.com/channel/static/socialpay/skin/", new String[] { "prefix" });
    switch (paramRedPacketInfo.skinType)
    {
    default: 
      return;
    case 1: 
    case 2: 
      JSONObject localJSONObject = paramajyg.a("redPack", new String[] { "skinMap" });
      paramajyg = str1;
      if (localJSONObject != null)
      {
        localJSONObject = localJSONObject.optJSONObject(String.valueOf(paramRedPacketInfo.skinId));
        paramajyg = str1;
        if (localJSONObject != null)
        {
          paramajyg = localJSONObject.optString("aioZipMd5", "");
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
        paramPreloadManager.a(str2 + str1 + paramRedPacketInfo.skinId + ".zip", paramajyg, new afaj(this, paramRedPacketInfo));
        return;
        paramajyg = str1;
        break;
      }
    case 3: 
      label220:
      paramajyg = paramajyg.a("redPack", null, new String[] { "bigAnimMap", String.valueOf(paramRedPacketInfo.bigAnimId), "zipMd5" });
      paramPreloadManager.a(str2 + "aio_special_" + paramRedPacketInfo.bigAnimId + ".zip", paramajyg, new afak(this, paramRedPacketInfo));
      return;
    }
    paramajyg = paramajyg.a("redPack", null, new String[] { "popAnimMap", String.valueOf(paramRedPacketInfo.bigAnimId), "zipMd5" });
    paramPreloadManager.a(str2 + "pop_anim_" + paramRedPacketInfo.bigAnimId + ".png", paramajyg, new afal(this, paramRedPacketInfo));
  }
  
  public void a() {}
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    ThreadManager.post(new CustomizeStrategyFactory.SkinRedPacketStrategy.1(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, ahdi paramahdi)
  {
    if (paramRedPacketInfo != null)
    {
      if (!(paramahdi instanceof ahdm)) {
        break label74;
      }
      paramahdi = (ahdm)paramahdi;
      paramRedPacketInfo.background = paramahdi.b;
      paramRedPacketInfo.corner = paramahdi.jdField_a_of_type_AndroidGraphicsBitmap;
      paramRedPacketInfo.animInfo = paramahdi.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
      paramRedPacketInfo.title = paramahdi.c;
      paramRedPacketInfo.icon = paramahdi.a(paramRedPacketInfo);
      paramRedPacketInfo.isHideTitle = paramahdi.jdField_a_of_type_Int;
      paramRedPacketInfo.resPath = paramahdi.d;
    }
    label74:
    do
    {
      return;
      if ((paramahdi instanceof ahdj))
      {
        paramahdi = (ahdj)paramahdi;
        paramRedPacketInfo.specailBackgroundAnimInfo = paramahdi.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
        paramRedPacketInfo.specialBackground = paramahdi.jdField_a_of_type_AndroidGraphicsBitmap;
        return;
      }
    } while (!(paramahdi instanceof ahdl));
    paramRedPacketInfo.resPath = ((ahdl)paramahdi).b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afai
 * JD-Core Version:    0.7.0.1
 */