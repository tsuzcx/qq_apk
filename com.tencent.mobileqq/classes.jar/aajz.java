import android.app.Activity;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;

public class aajz
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public aajz(PluginJumpManager paramPluginJumpManager, aaka paramaaka, Activity paramActivity, String paramString1, String paramString2, String paramString3, long paramLong, aakb paramaakb, String paramString4) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.mPluginManager = paramPluginManagerClient;
    paramPluginManagerClient = this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.mPluginManager.queryPlugin(this.jdField_a_of_type_Aaka.b);
    int i;
    if (paramPluginManagerClient != null) {
      if (paramPluginManagerClient.mState == 4)
      {
        i = 1;
        this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.launchPlugin(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aaka.b, this.jdField_a_of_type_Aaka.c, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.jdField_a_of_type_Long, this.jdField_a_of_type_Aakb.b, this.jdField_a_of_type_Aakb.a);
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.openLinkInNewWebView(this.jdField_a_of_type_AndroidAppActivity, this.b, this.d);
      }
      return;
      PluginJumpManager.report("BizTechReport", "native_plugin", "open_with_noapk", 0, this.b, this.jdField_a_of_type_Aakb.b, null, null);
      this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.mPluginManager.installPlugin(this.jdField_a_of_type_Aaka.b);
      i = 0;
      continue;
      PluginJumpManager.report("BizTechReport", "native_plugin", "open_with_noapk", 1, this.b, this.jdField_a_of_type_Aakb.b, null, null);
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajz
 * JD-Core Version:    0.7.0.1
 */