import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.leba.header.LebaGridMenuAdapter;
import com.tencent.mobileqq.leba.header.LebaGridMenuAdapter.LebaGridItemViewHolder;
import com.tencent.mobileqq.leba.header.LebaGridUtils;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.mobileqq.leba.model.pluginactions.PluginAction;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class aejh
  implements Runnable
{
  public aejh(LebaGridMenuAdapter paramLebaGridMenuAdapter, LebaGridItemInfo paramLebaGridItemInfo, String paramString, PluginAction paramPluginAction, LebaGridMenuAdapter.LebaGridItemViewHolder paramLebaGridItemViewHolder) {}
  
  public void run()
  {
    Object localObject = LebaGridUtils.a(this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter.a, this.jdField_a_of_type_ComTencentMobileqqLebaModelLebaGridItemInfo.a.pkgName, this.jdField_a_of_type_ComTencentMobileqqLebaModelLebaGridItemInfo.a.resBigUrl);
    if (((File)localObject).exists())
    {
      localObject = LebaGridUtils.a((File)localObject);
      if (localObject == null) {
        break label122;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LebaGridMenuAdapter", 2, "found bitmap from sdcard, info=" + this.jdField_a_of_type_ComTencentMobileqqLebaModelLebaGridItemInfo.a.resName);
      }
      BaseApplicationImpl.sImageHashMap.put(this.jdField_a_of_type_JavaLangString, localObject);
      ((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter.a).runOnUiThread(new aeji(this, (Bitmap)localObject));
    }
    label122:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("LebaGridMenuAdapter", 2, "can't find bitmap form cache & sdcard" + this.jdField_a_of_type_ComTencentMobileqqLebaModelLebaGridItemInfo.a.resName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejh
 * JD-Core Version:    0.7.0.1
 */