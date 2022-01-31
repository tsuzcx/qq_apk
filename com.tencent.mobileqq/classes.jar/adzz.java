import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.leba.LebaWithFeeds;
import com.tencent.mobileqq.leba.header.LebaGridUtils;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class adzz
  extends DownloadIconsListener
{
  public adzz(LebaWithFeeds paramLebaWithFeeds) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    int i = 0;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("DownloadIconsListener onDownloadSuc, key=").append(paramString).append(", bitmap is null?");
      if (paramBitmap != null) {
        break label218;
      }
    }
    label218:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.lebatab.leba_with_feeds", 2, bool);
      int j = this.a.a.size();
      while (i < j)
      {
        localObject = (LebaGridItemInfo)this.a.a.get(i);
        if ((localObject != null) && (((LebaGridItemInfo)localObject).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo != null) && (paramString.equals(((LebaGridItemInfo)localObject).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pkgName)) && (paramBitmap != null))
        {
          File localFile = LebaGridUtils.a(this.a.a(), paramString, ((LebaGridItemInfo)localObject).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.resBigUrl);
          if (localFile != null)
          {
            ((LebaGridItemInfo)localObject).jdField_a_of_type_JavaLangString = ("LebaIcon://" + localFile.getAbsolutePath());
            if ((BaseApplicationImpl.sImageHashMap != null) && (BaseApplicationImpl.sImageHashMap.get(((LebaGridItemInfo)localObject).jdField_a_of_type_JavaLangString) == null)) {
              BaseApplicationImpl.sImageHashMap.put(((LebaGridItemInfo)localObject).jdField_a_of_type_JavaLangString, paramBitmap);
            }
          }
        }
        i += 1;
      }
    }
    this.a.a(new aeaa(this, paramString, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzz
 * JD-Core Version:    0.7.0.1
 */