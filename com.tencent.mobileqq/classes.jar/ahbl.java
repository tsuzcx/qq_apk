import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class ahbl
  extends bbwt
{
  public ahbl(PreloadManager paramPreloadManager, String paramString, ahbn paramahbn) {}
  
  public void onDoneFile(bbwu parambbwu)
  {
    int i = -5;
    super.onDoneFile(parambbwu);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "downloadModule|done" + parambbwu.jdField_a_of_type_JavaLangString);
    }
    Object localObject = parambbwu.a();
    PreloadModule localPreloadModule = (PreloadModule)((Bundle)localObject).getSerializable("module");
    localObject = (PreloadResource)((Bundle)localObject).getSerializable("resource");
    if (ahiw.c(localPreloadModule.mid, this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "downloadModule|done code" + parambbwu.jdField_a_of_type_Int);
      }
      if (parambbwu.jdField_a_of_type_Int != 0) {
        break label168;
      }
      i = 0;
      if (localObject != null) {
        break label183;
      }
    }
    label168:
    label183:
    for (localObject = null;; localObject = ((PreloadResource)localObject).getResInfo(localPreloadModule))
    {
      this.jdField_a_of_type_Ahbn.onDownloadResFinished(localPreloadModule.mid, i, ((File)parambbwu.jdField_a_of_type_JavaUtilMap.get(parambbwu.jdField_a_of_type_JavaLangString)).getAbsolutePath(), (ResourceInfo)localObject);
      return;
      if (parambbwu.jdField_a_of_type_Int == -5) {
        break;
      }
      i = -6;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahbl
 * JD-Core Version:    0.7.0.1
 */