import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.Common;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.base.FileUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.MyAppApi;
import java.io.File;
import java.util.HashMap;

public final class alkz
  implements Runnable
{
  public alkz(Bundle paramBundle1, Bundle paramBundle2, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    boolean bool;
    Object localObject1;
    Object localObject2;
    Intent localIntent;
    Bundle localBundle;
    label169:
    Object localObject3;
    if (Common.a(this.jdField_a_of_type_AndroidOsBundle.getString("schemaUrl")).get("auto_download") != null)
    {
      bool = true;
      if (!MyAppApi.a().a(CommonDataAdapter.a().a(), this.jdField_b_of_type_AndroidOsBundle, bool, false))
      {
        localObject1 = Common.g() + File.separator + "qapp_center_detail.htm";
        localObject2 = new File((String)localObject1);
        if (!((File)localObject2).exists())
        {
          LogUtility.d("AppClient", "file" + (String)localObject1 + " not exist copyassets.");
          FileUtils.a("Page/system", Common.h());
        }
        localIntent = new Intent();
        localBundle = new Bundle();
        if (!((File)localObject2).exists()) {
          break label450;
        }
        localObject2 = "file:///" + (String)localObject1;
        localObject3 = "&from=-10&id=" + this.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          localObject1 = localObject3;
          if (this.jdField_b_of_type_JavaLangString.contains("channelId")) {}
        }
        else
        {
          localObject1 = (String)localObject3 + "&channelId=" + this.c;
        }
        if (!bool) {
          break label512;
        }
        localObject1 = (String)localObject1 + "&auto_download=1";
      }
    }
    label512:
    for (;;)
    {
      localObject3 = localObject1;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        if (!this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
          break label481;
        }
      }
      label450:
      label481:
      for (localObject3 = localObject1;; localObject3 = (String)localObject1 + "&" + this.jdField_b_of_type_JavaLangString)
      {
        localIntent.setClass(CommonDataAdapter.a().a(), QZoneAppListActivity.class);
        localBundle.putInt("goto_type", 3);
        localBundle.putString("APP_URL", (String)localObject2);
        localBundle.putBoolean("FROM_FEED", true);
        localBundle.putString("APP_PARAMS", (String)localObject3);
        if (this.jdField_a_of_type_AndroidOsBundle.getInt("process_id") == 2) {
          localBundle.putInt("process_id", 2);
        }
        LogUtility.b("Jie", "APP_URL:" + (String)localObject2 + " |  PARAMS >>> " + localBundle.getString("APP_PARAMS"));
        localIntent.putExtras(localBundle);
        localIntent.putExtra("adapter_action", "action_app_detail");
        localIntent.addFlags(872415232);
        CommonDataAdapter.a().a().startActivity(localIntent);
        return;
        bool = false;
        break;
        localObject2 = Common.m() + File.separator + "qapp_center_detail.htm";
        break label169;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alkz
 * JD-Core Version:    0.7.0.1
 */