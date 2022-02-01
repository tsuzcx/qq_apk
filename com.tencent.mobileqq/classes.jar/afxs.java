import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.SkinRedPacketStrategy.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import org.json.JSONObject;

public class afxs
  implements afxo
{
  public akpd a;
  public PreloadManager a;
  private QQAppInterface a;
  
  public afxs(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = null;
    this.jdField_a_of_type_Akpd = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = ((PreloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(151));
      this.jdField_a_of_type_Akpd = ((akpd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245));
    }
  }
  
  private void a(@NonNull PreloadManager paramPreloadManager, @NonNull akpd paramakpd, @NonNull CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    String str1 = null;
    String str2 = paramakpd.a("redPack", "https://imgcache.qq.com/channel/static/socialpay/skin/", new String[] { "prefix" });
    switch (paramRedPacketInfo.skinType)
    {
    default: 
      return;
    case 1: 
    case 2: 
      JSONObject localJSONObject = paramakpd.a("redPack", new String[] { "skinMap" });
      paramakpd = str1;
      if (localJSONObject != null)
      {
        localJSONObject = localJSONObject.optJSONObject(String.valueOf(paramRedPacketInfo.skinId));
        paramakpd = str1;
        if (localJSONObject != null)
        {
          paramakpd = localJSONObject.optString("aioZipMd5", "");
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
        paramPreloadManager.a(str2 + str1 + paramRedPacketInfo.skinId + ".zip", paramakpd, new afxt(this, paramRedPacketInfo));
        return;
        paramakpd = str1;
        break;
      }
    case 3: 
      label220:
      paramakpd = paramakpd.a("redPack", null, new String[] { "bigAnimMap", String.valueOf(paramRedPacketInfo.bigAnimId), "zipMd5" });
      paramPreloadManager.a(str2 + "aio_special_" + paramRedPacketInfo.bigAnimId + ".zip", paramakpd, new afxu(this, paramRedPacketInfo));
      return;
    }
    paramakpd = paramakpd.a("redPack", null, new String[] { "popAnimMap", String.valueOf(paramRedPacketInfo.bigAnimId), "zipMd5" });
    paramPreloadManager.a(str2 + "pop_anim_" + paramRedPacketInfo.bigAnimId + ".png", paramakpd, new afxv(this, paramRedPacketInfo));
  }
  
  public void a() {}
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    ThreadManager.post(new CustomizeStrategyFactory.SkinRedPacketStrategy.1(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, ahxe paramahxe)
  {
    if (paramRedPacketInfo != null)
    {
      if (!(paramahxe instanceof ahxi)) {
        break label74;
      }
      paramahxe = (ahxi)paramahxe;
      paramRedPacketInfo.background = paramahxe.b;
      paramRedPacketInfo.corner = paramahxe.jdField_a_of_type_AndroidGraphicsBitmap;
      paramRedPacketInfo.animInfo = paramahxe.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
      paramRedPacketInfo.title = paramahxe.c;
      paramRedPacketInfo.icon = paramahxe.a(paramRedPacketInfo);
      paramRedPacketInfo.isHideTitle = paramahxe.jdField_a_of_type_Int;
      paramRedPacketInfo.resPath = paramahxe.d;
    }
    label74:
    do
    {
      return;
      if ((paramahxe instanceof ahxf))
      {
        paramahxe = (ahxf)paramahxe;
        paramRedPacketInfo.specailBackgroundAnimInfo = paramahxe.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
        paramRedPacketInfo.specialBackground = paramahxe.jdField_a_of_type_AndroidGraphicsBitmap;
        return;
      }
    } while (!(paramahxe instanceof ahxh));
    paramRedPacketInfo.resPath = ((ahxh)paramahxe).b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afxs
 * JD-Core Version:    0.7.0.1
 */