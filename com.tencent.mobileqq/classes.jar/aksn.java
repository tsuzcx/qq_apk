import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class aksn
  extends akso
{
  public aksn(PreloadResource paramPreloadResource, bhhe parambhhe)
  {
    super(parambhhe);
  }
  
  private int a(String paramString, boolean paramBoolean)
  {
    int i = aktf.a(paramString, 0, this.a.getFilePos());
    if (i == 0)
    {
      if (paramBoolean) {
        aktf.a(paramString, 1, this.a.getFilePos());
      }
      return 1;
    }
    if (i == 1) {
      return 7;
    }
    if (paramBoolean) {
      aktf.a(paramString, 1, this.a.getFilePos());
    }
    return i;
  }
  
  public void onDoneFile(bhhf parambhhf)
  {
    boolean bool = true;
    Object localObject1;
    PreloadModule localPreloadModule;
    Object localObject2;
    File localFile;
    String str;
    int i;
    if ((parambhhf != null) && (parambhhf.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(parambhhf.jdField_a_of_type_JavaLangString)))
    {
      localObject1 = parambhhf.a();
      localPreloadModule = (PreloadModule)((Bundle)localObject1).getSerializable("module");
      localObject2 = (PreloadResource)((Bundle)localObject1).getSerializable("resource");
      localFile = (File)parambhhf.jdField_a_of_type_JavaUtilMap.get(parambhhf.jdField_a_of_type_JavaLangString);
      if (localFile != null) {
        break label416;
      }
      localObject1 = "";
      if ((parambhhf.jdField_a_of_type_Int != 0) || (localObject2 == null)) {
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
      akww.a((String)localObject1);
      aktf.a(parambhhf.jdField_a_of_type_JavaLangString, 5, this.a.getFilePos());
      parambhhf.jdField_a_of_type_Int = -1;
      i = 1;
      label229:
      if (parambhhf.jdField_a_of_type_Int == -118) {
        i = 1;
      }
      if ((i != 0) && (localPreloadModule != null)) {
        localPreloadModule.removeResource((PreloadResource)localObject2);
      }
      localObject2 = parambhhf.jdField_a_of_type_JavaLangString;
      if (parambhhf.jdField_a_of_type_Int != 0) {
        break label479;
      }
    }
    for (;;)
    {
      i = a((String)localObject2, bool);
      parambhhf.a().putInt("scene", i);
      if ((i == 7) && (parambhhf.jdField_a_of_type_Int == 0)) {
        aktg.a(parambhhf.jdField_a_of_type_JavaLangString, this.a.getFilePos());
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, "preload onDoneFile|" + parambhhf.jdField_a_of_type_Int + "|" + parambhhf.jdField_a_of_type_JavaLangString + "|" + (String)localObject1 + "|" + i);
      }
      super.onDoneFile(parambhhf);
      if (this.a.isNeedReport(parambhhf.jdField_a_of_type_JavaLangString)) {
        this.a.reportDownload(parambhhf.jdField_a_of_type_JavaLangString, parambhhf.jdField_a_of_type_Int, localPreloadModule);
      }
      return;
      label416:
      localObject1 = localFile.getAbsolutePath();
      break;
      label426:
      aktg.a(parambhhf.jdField_a_of_type_JavaLangString, str, NetConnInfoCenter.getServerTimeMillis(), this.a.getFilePos());
      if (PreloadResource.access$000(this.a, (String)localObject1, parambhhf.jdField_a_of_type_JavaLangString)) {
        this.a.unzip((String)localObject1, parambhhf.jdField_a_of_type_JavaLangString);
      }
      label474:
      i = 0;
      break label229;
      label479:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksn
 * JD-Core Version:    0.7.0.1
 */