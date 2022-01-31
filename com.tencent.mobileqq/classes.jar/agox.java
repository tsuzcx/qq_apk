import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class agox
  extends batl
{
  public agox(PreloadManager paramPreloadManager, agpa paramagpa) {}
  
  public void onDoneFile(batm parambatm)
  {
    int i = -5;
    super.onDoneFile(parambatm);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "downloadRes|done" + parambatm.jdField_a_of_type_JavaLangString + "|" + parambatm.jdField_a_of_type_Int);
    }
    Object localObject = parambatm.a();
    PreloadModule localPreloadModule = (PreloadModule)((Bundle)localObject).getSerializable("module");
    localObject = (PreloadResource)((Bundle)localObject).getSerializable("resource");
    if (parambatm.jdField_a_of_type_Int == 0)
    {
      i = 0;
      if (localObject != null) {
        break label146;
      }
    }
    label146:
    for (localObject = null;; localObject = ((PreloadResource)localObject).getResInfo(localPreloadModule))
    {
      this.jdField_a_of_type_Agpa.onDownloadResFinished(localPreloadModule.mid, i, ((File)parambatm.jdField_a_of_type_JavaUtilMap.get(parambatm.jdField_a_of_type_JavaLangString)).getAbsolutePath(), (ResourceInfo)localObject);
      return;
      if (parambatm.jdField_a_of_type_Int == -5) {
        break;
      }
      i = -6;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agox
 * JD-Core Version:    0.7.0.1
 */