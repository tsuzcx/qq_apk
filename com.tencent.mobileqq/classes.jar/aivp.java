import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class aivp
  extends bdvu
{
  public aivp(PreloadManager paramPreloadManager, aivs paramaivs) {}
  
  public void onDoneFile(bdvv parambdvv)
  {
    int i = -5;
    super.onDoneFile(parambdvv);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "downloadRes|done" + parambdvv.jdField_a_of_type_JavaLangString + "|" + parambdvv.jdField_a_of_type_Int);
    }
    Object localObject = parambdvv.a();
    PreloadModule localPreloadModule = (PreloadModule)((Bundle)localObject).getSerializable("module");
    localObject = (PreloadResource)((Bundle)localObject).getSerializable("resource");
    if (parambdvv.jdField_a_of_type_Int == 0)
    {
      i = 0;
      if (localObject != null) {
        break label146;
      }
    }
    label146:
    for (localObject = null;; localObject = ((PreloadResource)localObject).getResInfo(localPreloadModule))
    {
      this.jdField_a_of_type_Aivs.onDownloadResFinished(localPreloadModule.mid, i, ((File)parambdvv.jdField_a_of_type_JavaUtilMap.get(parambdvv.jdField_a_of_type_JavaLangString)).getAbsolutePath(), (ResourceInfo)localObject);
      return;
      if (parambdvv.jdField_a_of_type_Int == -5) {
        break;
      }
      i = -6;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivp
 * JD-Core Version:    0.7.0.1
 */