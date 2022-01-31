import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class agpo
  extends agpp
{
  public agpo(PreloadResource paramPreloadResource, batl parambatl)
  {
    super(parambatl);
  }
  
  private int a(String paramString, boolean paramBoolean)
  {
    int i = agqg.a(paramString, 0, this.a.getFilePos());
    if (i == 0)
    {
      if (paramBoolean) {
        agqg.a(paramString, 1, this.a.getFilePos());
      }
      return 1;
    }
    if (i == 1) {
      return 7;
    }
    if (paramBoolean) {
      agqg.a(paramString, 1, this.a.getFilePos());
    }
    return i;
  }
  
  public void onDoneFile(batm parambatm)
  {
    boolean bool = true;
    Object localObject1;
    PreloadModule localPreloadModule;
    Object localObject2;
    File localFile;
    String str;
    int i;
    if ((parambatm != null) && (parambatm.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(parambatm.jdField_a_of_type_JavaLangString)))
    {
      localObject1 = parambatm.a();
      localPreloadModule = (PreloadModule)((Bundle)localObject1).getSerializable("module");
      localObject2 = (PreloadResource)((Bundle)localObject1).getSerializable("resource");
      localFile = (File)parambatm.jdField_a_of_type_JavaUtilMap.get(parambatm.jdField_a_of_type_JavaLangString);
      if (localFile != null) {
        break label430;
      }
      localObject1 = "";
      if ((parambatm.jdField_a_of_type_Int != 0) || (localObject2 == null)) {
        break label507;
      }
      str = MD5Coding.encodeFile2HexStr((String)localObject1);
      if ((localFile == null) || (!localFile.exists()) || (TextUtils.isEmpty(str))) {
        break label502;
      }
      if ((TextUtils.isEmpty(((PreloadResource)localObject2).md5)) || (str.equalsIgnoreCase(((PreloadResource)localObject2).md5))) {
        break label440;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, "preload onDoneFile md5 not match|" + ((PreloadResource)localObject2).mResId + "|" + str + "|" + ((PreloadResource)localObject2).md5);
      }
      agwj.a((String)localObject1);
      agqg.a(parambatm.jdField_a_of_type_JavaLangString, 5, this.a.getFilePos());
      parambatm.jdField_a_of_type_Int = -1;
      agvn.a(localPreloadModule, 2, parambatm.c, parambatm.jdField_a_of_type_Int);
      i = 1;
      if (parambatm.jdField_a_of_type_Int == -118) {
        i = 1;
      }
      if ((i != 0) && (localPreloadModule != null)) {
        localPreloadModule.removeResource((PreloadResource)localObject2);
      }
      localObject2 = parambatm.jdField_a_of_type_JavaLangString;
      if (parambatm.jdField_a_of_type_Int != 0) {
        break label524;
      }
    }
    for (;;)
    {
      i = a((String)localObject2, bool);
      parambatm.a().putInt("scene", i);
      if ((i == 7) && (parambatm.jdField_a_of_type_Int == 0)) {
        agqh.a(parambatm.jdField_a_of_type_JavaLangString, this.a.getFilePos());
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, "preload onDoneFile|" + parambatm.jdField_a_of_type_Int + "|" + parambatm.jdField_a_of_type_JavaLangString + "|" + (String)localObject1 + "|" + i);
      }
      super.onDoneFile(parambatm);
      if (this.a.isNeedReport(parambatm.jdField_a_of_type_JavaLangString)) {
        this.a.reportDownload(parambatm.jdField_a_of_type_JavaLangString, parambatm.jdField_a_of_type_Int, localPreloadModule);
      }
      return;
      label430:
      localObject1 = localFile.getAbsolutePath();
      break;
      label440:
      agqh.a(parambatm.jdField_a_of_type_JavaLangString, str, NetConnInfoCenter.getServerTimeMillis(), this.a.getFilePos());
      if (PreloadResource.access$000(this.a, (String)localObject1, parambatm.jdField_a_of_type_JavaLangString)) {
        this.a.unzip((String)localObject1, parambatm.jdField_a_of_type_JavaLangString);
      }
      agvn.a(localPreloadModule, 0, parambatm.c, parambatm.jdField_a_of_type_Int);
      for (;;)
      {
        label502:
        i = 0;
        break;
        label507:
        agvn.a(localPreloadModule, 1, parambatm.c, parambatm.jdField_a_of_type_Int);
      }
      label524:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agpo
 * JD-Core Version:    0.7.0.1
 */