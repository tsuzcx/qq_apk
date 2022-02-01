import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class akbs
  extends akbt
{
  public akbs(PreloadResource paramPreloadResource, bgod parambgod)
  {
    super(parambgod);
  }
  
  private int a(String paramString, boolean paramBoolean)
  {
    int i = akcn.a(paramString, 0, this.a.getFilePos());
    if (i == 0)
    {
      if (paramBoolean) {
        akcn.a(paramString, 1, this.a.getFilePos());
      }
      return 1;
    }
    if (i == 1) {
      return 7;
    }
    if (paramBoolean) {
      akcn.a(paramString, 1, this.a.getFilePos());
    }
    return i;
  }
  
  public void onDoneFile(bgoe parambgoe)
  {
    boolean bool = true;
    Object localObject1;
    PreloadModule localPreloadModule;
    Object localObject2;
    File localFile;
    String str;
    int i;
    if ((parambgoe != null) && (parambgoe.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(parambgoe.jdField_a_of_type_JavaLangString)))
    {
      localObject1 = parambgoe.a();
      localPreloadModule = (PreloadModule)((Bundle)localObject1).getSerializable("module");
      localObject2 = (PreloadResource)((Bundle)localObject1).getSerializable("resource");
      localFile = (File)parambgoe.jdField_a_of_type_JavaUtilMap.get(parambgoe.jdField_a_of_type_JavaLangString);
      if (localFile != null) {
        break label416;
      }
      localObject1 = "";
      if ((parambgoe.jdField_a_of_type_Int != 0) || (localObject2 == null)) {
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
      akgd.a((String)localObject1);
      akcn.a(parambgoe.jdField_a_of_type_JavaLangString, 5, this.a.getFilePos());
      parambgoe.jdField_a_of_type_Int = -1;
      i = 1;
      label229:
      if (parambgoe.jdField_a_of_type_Int == -118) {
        i = 1;
      }
      if ((i != 0) && (localPreloadModule != null)) {
        localPreloadModule.removeResource((PreloadResource)localObject2);
      }
      localObject2 = parambgoe.jdField_a_of_type_JavaLangString;
      if (parambgoe.jdField_a_of_type_Int != 0) {
        break label479;
      }
    }
    for (;;)
    {
      i = a((String)localObject2, bool);
      parambgoe.a().putInt("scene", i);
      if ((i == 7) && (parambgoe.jdField_a_of_type_Int == 0)) {
        akco.a(parambgoe.jdField_a_of_type_JavaLangString, this.a.getFilePos());
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, "preload onDoneFile|" + parambgoe.jdField_a_of_type_Int + "|" + parambgoe.jdField_a_of_type_JavaLangString + "|" + (String)localObject1 + "|" + i);
      }
      super.onDoneFile(parambgoe);
      if (this.a.isNeedReport(parambgoe.jdField_a_of_type_JavaLangString)) {
        this.a.reportDownload(parambgoe.jdField_a_of_type_JavaLangString, parambgoe.jdField_a_of_type_Int, localPreloadModule);
      }
      return;
      label416:
      localObject1 = localFile.getAbsolutePath();
      break;
      label426:
      akco.a(parambgoe.jdField_a_of_type_JavaLangString, str, NetConnInfoCenter.getServerTimeMillis(), this.a.getFilePos());
      if (PreloadResource.access$000(this.a, (String)localObject1, parambgoe.jdField_a_of_type_JavaLangString)) {
        this.a.unzip((String)localObject1, parambgoe.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     akbs
 * JD-Core Version:    0.7.0.1
 */