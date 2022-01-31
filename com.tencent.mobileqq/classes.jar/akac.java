import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.HbThemeConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public class akac
  implements Runnable
{
  public akac(HbThemeConfigManager paramHbThemeConfigManager, Context paramContext, JSONObject paramJSONObject, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("qb_tenpay_share_face", 0).edit();
    ((SharedPreferences.Editor)localObject).putString("hb_face", HbThemeConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager, this.jdField_a_of_type_OrgJsonJSONObject).toString());
    ((SharedPreferences.Editor)localObject).commit();
    localObject = HbThemeConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager).optString("hb_face_imgurl");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HbThemeConfigManager", 2, "start downloading img...");
    }
    HashSet localHashSet = new HashSet(2);
    localHashSet.add(localObject);
    PreloadImgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHashSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akac
 * JD-Core Version:    0.7.0.1
 */