import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.LoginKeyHelper;
import com.tencent.mobileqq.intervideo.LoginKeyHelper.AccountInfo;
import com.tencent.mobileqq.intervideo.LoginKeyHelper.GetLoginKeyListener;
import com.tencent.mobileqq.intervideo.huayang.HuayangDowanloadHelper;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.intervideo.od.ODProxy;
import com.tencent.qphone.base.util.QLog;

public class adkc
  implements LoginKeyHelper.GetLoginKeyListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private final InstalledPlugin jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin;
  private final IVPluginInfo jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo;
  private final String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  
  public adkc(HuayangDowanloadHelper paramHuayangDowanloadHelper, String paramString, IVPluginInfo paramIVPluginInfo, InstalledPlugin paramInstalledPlugin, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo = paramIVPluginInfo;
    this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin = paramInstalledPlugin;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!paramBoolean2))
    {
      HuayangDowanloadHelper.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper).a(5, new Object[] { "" });
      return;
    }
    if (paramBoolean1) {}
    for (long l = 0L;; l = 2000L)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new adkd(this, paramBoolean1, paramBoolean2), l);
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    long l1;
    label96:
    String str;
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_AndroidOsBundle = HuayangDowanloadHelper.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper).a().a.getExtras();
        if ("Hy".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_JavaLangString)) {
          Monitor.a("2653752");
        }
        a(this.jdField_a_of_type_Boolean, paramBoolean);
        long l2 = System.currentTimeMillis();
        if (!"Hy".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_JavaLangString)) {
          break label338;
        }
        l1 = HuayangDowanloadHelper.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper);
        l1 = l2 - l1;
        if (QLog.isColorLevel()) {
          QLog.d("HuayangPluginNewDownloader", 2, "拉取票据完成 耗时：" + l1 + "appId = " + paramString + " isSuccess =  " + paramBoolean + " code = " + paramInt);
        }
        if (!Monitor.jdField_a_of_type_Boolean) {
          break label350;
        }
        str = "huayang";
        label172:
        if (!paramBoolean) {
          break label357;
        }
      }
    }
    label338:
    label350:
    label357:
    for (int i = 1;; i = 0)
    {
      StoryReportor.a(str, "getLoginKey", i, (int)l1, new String[] { HuayangDowanloadHelper.c(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper), paramInt + "", paramString, "7.6.0" });
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_Int != 2) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_AndroidOsBundle = ODProxy.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo, HuayangDowanloadHelper.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper));
      if (!"Od".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_JavaLangString)) {
        break;
      }
      Monitor.a("2691711");
      break;
      if ("Hy".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_JavaLangString))
      {
        Monitor.a("2653753");
        break;
      }
      if (!"Od".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_JavaLangString)) {
        break;
      }
      Monitor.a("2691712");
      break;
      l1 = HuayangDowanloadHelper.b(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper);
      break label96;
      str = "group_video";
      break label172;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adkc
 * JD-Core Version:    0.7.0.1
 */