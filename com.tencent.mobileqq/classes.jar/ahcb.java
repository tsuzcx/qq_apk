import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class ahcb
  extends ahcc
{
  public ahcb(PreloadResource paramPreloadResource, bbwt parambbwt)
  {
    super(parambbwt);
  }
  
  private int a(String paramString, boolean paramBoolean)
  {
    int i = ahct.a(paramString, 0, this.a.getFilePos());
    if (i == 0)
    {
      if (paramBoolean) {
        ahct.a(paramString, 1, this.a.getFilePos());
      }
      return 1;
    }
    if (i == 1) {
      return 7;
    }
    if (paramBoolean) {
      ahct.a(paramString, 1, this.a.getFilePos());
    }
    return i;
  }
  
  public void onDoneFile(bbwu parambbwu)
  {
    boolean bool = true;
    Object localObject1;
    PreloadModule localPreloadModule;
    Object localObject2;
    File localFile;
    String str;
    int i;
    if ((parambbwu != null) && (parambbwu.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(parambbwu.jdField_a_of_type_JavaLangString)))
    {
      localObject1 = parambbwu.a();
      localPreloadModule = (PreloadModule)((Bundle)localObject1).getSerializable("module");
      localObject2 = (PreloadResource)((Bundle)localObject1).getSerializable("resource");
      localFile = (File)parambbwu.jdField_a_of_type_JavaUtilMap.get(parambbwu.jdField_a_of_type_JavaLangString);
      if (localFile != null) {
        break label430;
      }
      localObject1 = "";
      if ((parambbwu.jdField_a_of_type_Int != 0) || (localObject2 == null)) {
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
      ahiw.a((String)localObject1);
      ahct.a(parambbwu.jdField_a_of_type_JavaLangString, 5, this.a.getFilePos());
      parambbwu.jdField_a_of_type_Int = -1;
      ahia.a(localPreloadModule, 2, parambbwu.c, parambbwu.jdField_a_of_type_Int);
      i = 1;
      if (parambbwu.jdField_a_of_type_Int == -118) {
        i = 1;
      }
      if ((i != 0) && (localPreloadModule != null)) {
        localPreloadModule.removeResource((PreloadResource)localObject2);
      }
      localObject2 = parambbwu.jdField_a_of_type_JavaLangString;
      if (parambbwu.jdField_a_of_type_Int != 0) {
        break label524;
      }
    }
    for (;;)
    {
      i = a((String)localObject2, bool);
      parambbwu.a().putInt("scene", i);
      if ((i == 7) && (parambbwu.jdField_a_of_type_Int == 0)) {
        ahcu.a(parambbwu.jdField_a_of_type_JavaLangString, this.a.getFilePos());
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, "preload onDoneFile|" + parambbwu.jdField_a_of_type_Int + "|" + parambbwu.jdField_a_of_type_JavaLangString + "|" + (String)localObject1 + "|" + i);
      }
      super.onDoneFile(parambbwu);
      if (this.a.isNeedReport(parambbwu.jdField_a_of_type_JavaLangString)) {
        this.a.reportDownload(parambbwu.jdField_a_of_type_JavaLangString, parambbwu.jdField_a_of_type_Int, localPreloadModule);
      }
      return;
      label430:
      localObject1 = localFile.getAbsolutePath();
      break;
      label440:
      ahcu.a(parambbwu.jdField_a_of_type_JavaLangString, str, NetConnInfoCenter.getServerTimeMillis(), this.a.getFilePos());
      if (PreloadResource.access$000(this.a, (String)localObject1, parambbwu.jdField_a_of_type_JavaLangString)) {
        this.a.unzip((String)localObject1, parambbwu.jdField_a_of_type_JavaLangString);
      }
      ahia.a(localPreloadModule, 0, parambbwu.c, parambbwu.jdField_a_of_type_Int);
      for (;;)
      {
        label502:
        i = 0;
        break;
        label507:
        ahia.a(localPreloadModule, 1, parambbwu.c, parambbwu.jdField_a_of_type_Int);
      }
      label524:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahcb
 * JD-Core Version:    0.7.0.1
 */