import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class ajau
  extends ajav
{
  public ajau(PreloadResource paramPreloadResource, bead parambead)
  {
    super(parambead);
  }
  
  private int a(String paramString, boolean paramBoolean)
  {
    int i = ajbm.a(paramString, 0, this.a.getFilePos());
    if (i == 0)
    {
      if (paramBoolean) {
        ajbm.a(paramString, 1, this.a.getFilePos());
      }
      return 1;
    }
    if (i == 1) {
      return 7;
    }
    if (paramBoolean) {
      ajbm.a(paramString, 1, this.a.getFilePos());
    }
    return i;
  }
  
  public void onDoneFile(beae parambeae)
  {
    boolean bool = true;
    Object localObject1;
    PreloadModule localPreloadModule;
    Object localObject2;
    File localFile;
    String str;
    int i;
    if ((parambeae != null) && (parambeae.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(parambeae.jdField_a_of_type_JavaLangString)))
    {
      localObject1 = parambeae.a();
      localPreloadModule = (PreloadModule)((Bundle)localObject1).getSerializable("module");
      localObject2 = (PreloadResource)((Bundle)localObject1).getSerializable("resource");
      localFile = (File)parambeae.jdField_a_of_type_JavaUtilMap.get(parambeae.jdField_a_of_type_JavaLangString);
      if (localFile != null) {
        break label416;
      }
      localObject1 = "";
      if ((parambeae.jdField_a_of_type_Int != 0) || (localObject2 == null)) {
        break label474;
      }
      str = MD5Coding.encodeFile2HexStr((String)localObject1);
      if ((localFile == null) || (!localFile.exists()) || (TextUtils.isEmpty(str))) {
        break label474;
      }
      if ((TextUtils.isEmpty(((PreloadResource)localObject2).md5)) || (str.equalsIgnoreCase(((PreloadResource)localObject2).md5))) {
        break label426;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, "preload onDoneFile md5 not match|" + ((PreloadResource)localObject2).mResId + "|" + str + "|" + ((PreloadResource)localObject2).md5);
      }
      ajeu.a((String)localObject1);
      ajbm.a(parambeae.jdField_a_of_type_JavaLangString, 5, this.a.getFilePos());
      parambeae.jdField_a_of_type_Int = -1;
      i = 1;
      label229:
      if (parambeae.jdField_a_of_type_Int == -118) {
        i = 1;
      }
      if ((i != 0) && (localPreloadModule != null)) {
        localPreloadModule.removeResource((PreloadResource)localObject2);
      }
      localObject2 = parambeae.jdField_a_of_type_JavaLangString;
      if (parambeae.jdField_a_of_type_Int != 0) {
        break label479;
      }
    }
    for (;;)
    {
      i = a((String)localObject2, bool);
      parambeae.a().putInt("scene", i);
      if ((i == 7) && (parambeae.jdField_a_of_type_Int == 0)) {
        ajbn.a(parambeae.jdField_a_of_type_JavaLangString, this.a.getFilePos());
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, "preload onDoneFile|" + parambeae.jdField_a_of_type_Int + "|" + parambeae.jdField_a_of_type_JavaLangString + "|" + (String)localObject1 + "|" + i);
      }
      super.onDoneFile(parambeae);
      if (this.a.isNeedReport(parambeae.jdField_a_of_type_JavaLangString)) {
        this.a.reportDownload(parambeae.jdField_a_of_type_JavaLangString, parambeae.jdField_a_of_type_Int, localPreloadModule);
      }
      return;
      label416:
      localObject1 = localFile.getAbsolutePath();
      break;
      label426:
      ajbn.a(parambeae.jdField_a_of_type_JavaLangString, str, NetConnInfoCenter.getServerTimeMillis(), this.a.getFilePos());
      if (PreloadResource.access$000(this.a, (String)localObject1, parambeae.jdField_a_of_type_JavaLangString)) {
        this.a.unzip((String)localObject1, parambeae.jdField_a_of_type_JavaLangString);
      }
      label474:
      i = 0;
      break label229;
      label479:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajau
 * JD-Core Version:    0.7.0.1
 */