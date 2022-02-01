import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class akwv
  extends bhyn
{
  public akwv(PreloadManager paramPreloadManager, String paramString, akwx paramakwx) {}
  
  public void onDoneFile(bhyo parambhyo)
  {
    int i = -5;
    super.onDoneFile(parambhyo);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "downloadModule|done" + parambhyo.jdField_a_of_type_JavaLangString);
    }
    Object localObject = parambhyo.a();
    PreloadModule localPreloadModule = (PreloadModule)((Bundle)localObject).getSerializable("module");
    localObject = (PreloadResource)((Bundle)localObject).getSerializable("resource");
    if (albw.c(localPreloadModule.mid, this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "downloadModule|done code" + parambhyo.jdField_a_of_type_Int);
      }
      if (parambhyo.jdField_a_of_type_Int != 0) {
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
      this.jdField_a_of_type_Akwx.onDownloadResFinished(localPreloadModule.mid, i, ((File)parambhyo.jdField_a_of_type_JavaUtilMap.get(parambhyo.jdField_a_of_type_JavaLangString)).getAbsolutePath(), (ResourceInfo)localObject);
      return;
      if (parambhyo.jdField_a_of_type_Int == -5) {
        break;
      }
      i = -6;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwv
 * JD-Core Version:    0.7.0.1
 */