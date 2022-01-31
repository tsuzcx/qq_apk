import android.text.TextUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class akjy
  extends aliz
{
  public String a(aljd paramaljd)
  {
    paramaljd = ((akkd)paramaljd.a).jdField_d_of_type_JavaLangString;
    if (AudioHelper.e()) {
      QLog.w(akkm.a, 1, "getUnzipDirPath, path[" + paramaljd + "]");
    }
    return paramaljd;
  }
  
  public boolean a(aljd paramaljd)
  {
    akkd localakkd = (akkd)paramaljd.a;
    localakkd.jdField_d_of_type_Int = 0;
    boolean bool1 = super.a(paramaljd);
    String str1 = "ARPromotionRDHandler, needDownload[" + bool1 + "], zipItem[" + localakkd;
    String str4;
    File localFile;
    boolean bool2;
    String str3;
    if (bool1)
    {
      str4 = atub.a("20180426_803_worldcupXXX", localakkd.b);
      if (!TextUtils.isEmpty(str4))
      {
        localFile = new File(str4);
        bool2 = localFile.exists();
        str3 = str1 + "], prePath[" + str4 + "], exists[" + bool2;
        if (!bool2) {}
      }
    }
    for (;;)
    {
      String str2;
      try
      {
        str1 = bech.a(localFile);
        str3 = str3 + "], preMd5[" + str1;
        if (TextUtils.equals(localakkd.b, str1))
        {
          str1 = str3 + ajjy.a(2131634938);
          bool2 = bace.d(str4, b(paramaljd));
          bool1 = super.a(paramaljd);
          paramaljd = str1 + ", copyFile[" + bool2 + "], reCheck[" + bool1 + "]";
          if (!bool1) {
            localakkd.jdField_d_of_type_Int = 1;
          }
          QLog.w(akkm.a, 1, paramaljd);
          return bool1;
        }
      }
      catch (Exception localException)
      {
        str2 = "Exception";
        continue;
        paramaljd = str3 + ajjy.a(2131634937);
        continue;
      }
      paramaljd = str3;
      continue;
      paramaljd = str2;
    }
  }
  
  public boolean a(aljd paramaljd, boolean paramBoolean)
  {
    return false;
  }
  
  public String b(aljd paramaljd)
  {
    paramaljd = ((akkd)paramaljd.a).c;
    if (AudioHelper.e()) {
      QLog.w(akkm.a, 1, "getDownloadPath, path[" + paramaljd + "]");
    }
    return paramaljd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akjy
 * JD-Core Version:    0.7.0.1
 */