import android.content.Context;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.huayang.HuayangDowanloadHelper;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import com.tencent.qphone.base.util.QLog;

class adkd
  implements Runnable
{
  adkd(adkc paramadkc, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HuayangPluginNewDownloader", 2, "startLoadingActivity：" + System.currentTimeMillis());
    }
    Context localContext = HuayangDowanloadHelper.a(this.jdField_a_of_type_Adkc.a);
    String str2 = adkc.a(this.jdField_a_of_type_Adkc);
    IVPluginInfo localIVPluginInfo = adkc.a(this.jdField_a_of_type_Adkc);
    InstalledPlugin localInstalledPlugin = adkc.a(this.jdField_a_of_type_Adkc);
    String str3 = HuayangDowanloadHelper.d(this.jdField_a_of_type_Adkc.a);
    if (this.jdField_a_of_type_Boolean) {}
    for (String str1 = HuayangDowanloadHelper.e(this.jdField_a_of_type_Adkc.a);; str1 = null)
    {
      HuayangLoadbackgroudActivity.a(localContext, str2, localIVPluginInfo, localInstalledPlugin, str3, str1, this.b, this.jdField_a_of_type_Boolean, HuayangDowanloadHelper.c(this.jdField_a_of_type_Adkc.a));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adkd
 * JD-Core Version:    0.7.0.1
 */