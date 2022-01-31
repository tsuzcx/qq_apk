import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.util.ScreenShotUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.io.File;
import org.json.JSONObject;

class adoc
  implements Runnable
{
  adoc(adob paramadob, Bitmap paramBitmap) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_Adob.a.jdField_a_of_type_OrgJsonJSONObject.optString("briefMsg");
    String str2 = this.jdField_a_of_type_Adob.a.jdField_a_of_type_OrgJsonJSONObject.optString("appName");
    String str3 = this.jdField_a_of_type_Adob.a.jdField_a_of_type_OrgJsonJSONObject.optString("iconUrl");
    String str4 = this.jdField_a_of_type_Adob.a.jdField_a_of_type_OrgJsonJSONObject.optString("actionUrl");
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      Object localObject1 = new File(BaseApplicationImpl.getApplication().getCacheDir(), "ShareScreenShots");
      Object localObject2 = "ShareScreenShot_" + System.currentTimeMillis() + ".jpg";
      localObject1 = ScreenShotUtil.a(this.jdField_a_of_type_AndroidGraphicsBitmap, (File)localObject1, (String)localObject2);
      localObject2 = new Intent(this.jdField_a_of_type_Adob.a.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a(), ForwardRecentActivity.class);
      ((Intent)localObject2).putExtra("key_flag_from_plugin", true);
      ((Intent)localObject2).putExtra("image_url", (String)localObject1);
      ((Intent)localObject2).putExtra("forward_type", -3);
      ((Intent)localObject2).putExtra("pkg_name", "com.tencent.mobileqq");
      ((Intent)localObject2).putExtra("req_type", 5);
      ((Intent)localObject2).putExtra("k_back", true);
      ((Intent)localObject2).putExtra("brief_key", str1);
      ((Intent)localObject2).putExtra("app_name", str2);
      if (!TextUtils.isEmpty(str3)) {
        ((Intent)localObject2).putExtra("struct_share_key_source_icon", str3);
      }
      ((Intent)localObject2).putExtra("struct_share_key_source_action", "web");
      ((Intent)localObject2).putExtra("struct_share_key_source_url", str4);
      ((Intent)localObject2).putExtra("stuctmsg_bytes", StructMsgFactory.a(((Intent)localObject2).getExtras()).getBytes());
      this.jdField_a_of_type_Adob.a.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.startActivityForResult((Intent)localObject2, (byte)15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adoc
 * JD-Core Version:    0.7.0.1
 */