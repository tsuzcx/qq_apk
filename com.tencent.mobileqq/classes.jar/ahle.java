import android.os.Build.VERSION;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.PendantVersionManager;
import com.tencent.mobileqq.shortvideo.ShortVideoArtResourceMgr;
import com.tencent.mobileqq.shortvideo.ShortVideoPortraitResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.quic.QuicResProcess;

public class ahle
{
  public static int a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload:APPID=" + AppSetting.a + " subVersion=" + "7.6.0" + " buildnum=" + "3525", null);
    String str;
    if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_video_"))
    {
      str = "new_qq_android_native_short_video_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (paramSVConfigItem.versionCode < 56)
        {
          VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInShortVideo=" + 56, null);
          return -2;
        }
      }
      else {
        return -4;
      }
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_filter_"))
    {
      str = "new_qq_android_native_short_filter_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (paramSVConfigItem.versionCode < 5)
        {
          VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInPendant=" + 5, null);
          return -2;
        }
      }
      else {
        return -4;
      }
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_art_filter_"))
    {
      str = "new_qq_android_native_art_filter_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (paramSVConfigItem.versionCode < 4)
        {
          VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInArt=" + 4, null);
          return -2;
        }
      }
      else {
        return -4;
      }
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_other_"))
    {
      str = "new_qq_android_native_short_other_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (paramSVConfigItem.versionCode < 1)
        {
          VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInOther=" + 1, null);
          return -2;
        }
      }
      else {
        return -4;
      }
    }
    else
    {
      if (paramSVConfigItem.name.startsWith("msf_quic_lib")) {
        return QuicResProcess.a(paramSVConfigItem);
      }
      if (paramSVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_"))
      {
        str = "new_qq_android_native_portrait_filter_" + paramSVConfigItem.versionCode;
        if (paramSVConfigItem.name.equalsIgnoreCase(str))
        {
          if (paramSVConfigItem.versionCode < 5)
          {
            VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInPortrait=" + 5, null);
            return -2;
          }
        }
        else {
          return -4;
        }
      }
    }
    return 0;
  }
  
  private static boolean a()
  {
    boolean bool = VcSystemInfo.e();
    VideoEnvironment.a("ShortVideoResourceManager", "isArmV7aAndNeon:isNeon=" + bool + ",SDK_INT=" + Build.VERSION.SDK_INT, null);
    return (bool) && (Build.VERSION.SDK_INT >= 15);
  }
  
  public static boolean a(AppInterface paramAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    boolean bool1 = true;
    if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_video_"))
    {
      boolean bool2 = VideoEnvironment.a(paramSVConfigItem.versionCode);
      VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload[Builtin Mode]:needDownload=" + bool2 + ",itemConfig.name=" + paramSVConfigItem.name, null);
      bool1 = bool2;
      if (bool2) {
        bool1 = VideoEnvironment.d(paramAppInterface);
      }
    }
    for (;;)
    {
      VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload:needDownload=" + bool1 + ",itemConfig.name=" + paramSVConfigItem.name, null);
      return bool1;
      if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_filter_")) {
        bool1 = a();
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_art_filter_")) {
        bool1 = ShortVideoArtResourceMgr.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_other_")) {
        bool1 = ahlf.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("msf_quic_lib")) {
        bool1 = QuicResProcess.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_")) {
        bool1 = ShortVideoPortraitResourceManager.a(paramAppInterface, paramSVConfigItem);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      return VideoEnvironment.e(paramQQAppInterface);
    }
    if (paramString.startsWith("new_qq_android_native_short_filter_")) {
      return PtvFilterSoLoad.b(VideoEnvironment.a());
    }
    if (paramString.startsWith("new_qq_android_native_art_filter_")) {
      return ShortVideoArtResourceMgr.a();
    }
    if (paramString.startsWith("new_qq_android_native_short_other_")) {
      return ahlf.a();
    }
    if (paramString.startsWith("msf_quic_lib")) {
      return QuicResProcess.a(paramQQAppInterface);
    }
    if (paramString.startsWith("new_qq_android_native_portrait_filter_")) {
      return ShortVideoPortraitResourceManager.a();
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      bool1 = VideoEnvironment.a(paramQQAppInterface, paramString3, paramInt);
      if (bool1) {
        VideoEnvironment.a(false, paramQQAppInterface);
      }
    }
    do
    {
      return bool1;
      VideoEnvironment.a(true, paramQQAppInterface);
      return bool1;
      if (paramString1.startsWith("new_qq_android_native_short_filter_"))
      {
        bool2 = PendantVersionManager.a(paramString2, paramString3);
        if (!bool2) {}
        for (;;)
        {
          PendantVersionManager.a(bool1);
          return bool2;
          bool1 = false;
        }
      }
      if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
        return ShortVideoArtResourceMgr.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("new_qq_android_native_short_other_")) {
        return ahlf.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("msf_quic_lib")) {
        return QuicResProcess.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      bool1 = bool2;
    } while (!paramString1.startsWith("new_qq_android_native_portrait_filter_"));
    return ShortVideoPortraitResourceManager.a(paramQQAppInterface, paramString2, paramString3, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahle
 * JD-Core Version:    0.7.0.1
 */