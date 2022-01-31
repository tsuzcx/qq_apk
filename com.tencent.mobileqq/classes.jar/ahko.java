import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import java.util.ArrayList;
import org.json.JSONObject;

class ahko
  implements Runnable
{
  ahko(ahkn paramahkn, String paramString1, JSONObject paramJSONObject, BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt1, int paramInt2, ArrayList paramArrayList, String paramString2, String paramString3) {}
  
  public void run()
  {
    this.jdField_a_of_type_Ahkn.a.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
    Object localObject = "";
    if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) {
      localObject = RedTouchWebviewHandler.access$100(this.jdField_a_of_type_Ahkn.a, this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.buffer.get());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("ret", String.valueOf(this.jdField_a_of_type_Int));
    localBundle.putString("buffer", (String)localObject);
    localBundle.putString("red", String.valueOf(this.jdField_b_of_type_Int));
    localBundle.putStringArrayList("missions", this.jdField_a_of_type_JavaUtilArrayList);
    localBundle.putString("path", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("serial", this.c);
    localBundle.putString("callback", this.jdField_a_of_type_JavaLangString);
    localObject = DataFactory.a("redTouch_getAppInfo_report", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ahkn.a.mOnRemoteResp.key, localBundle);
    this.jdField_a_of_type_Ahkn.a.sendRemoteReq((Bundle)localObject, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahko
 * JD-Core Version:    0.7.0.1
 */