import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.leba.LebaTopBarAdapter;
import com.tencent.mobileqq.leba.header.LebaGridUtils;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class aehv
  implements Runnable
{
  public aehv(LebaTopBarAdapter paramLebaTopBarAdapter, LebaGridItemInfo paramLebaGridItemInfo, String paramString, ImageView paramImageView) {}
  
  public void run()
  {
    Object localObject = LebaGridUtils.a(LebaTopBarAdapter.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaTopBarAdapter), this.jdField_a_of_type_ComTencentMobileqqLebaModelLebaGridItemInfo.a.pkgName, this.jdField_a_of_type_ComTencentMobileqqLebaModelLebaGridItemInfo.a.resBigUrl);
    if (((File)localObject).exists())
    {
      localObject = LebaGridUtils.a((File)localObject);
      if (localObject == null) {
        break label123;
      }
      if (QLog.isColorLevel()) {
        QLog.d(LebaTopBarAdapter.a(), 2, "found bitmap from sdcard, info=" + this.jdField_a_of_type_ComTencentMobileqqLebaModelLebaGridItemInfo.a.resName);
      }
      BaseApplicationImpl.sImageHashMap.put(this.jdField_a_of_type_JavaLangString, localObject);
      ((BaseActivity)LebaTopBarAdapter.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaTopBarAdapter)).runOnUiThread(new aehw(this, (Bitmap)localObject));
    }
    label123:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(LebaTopBarAdapter.a(), 2, "can't find bitmap form cache & sdcard" + this.jdField_a_of_type_ComTencentMobileqqLebaModelLebaGridItemInfo.a.resName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehv
 * JD-Core Version:    0.7.0.1
 */