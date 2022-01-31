import android.text.TextUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class akyj
  extends alxm
{
  public String a(alxq paramalxq)
  {
    paramalxq = ((akyo)paramalxq.a).jdField_d_of_type_JavaLangString;
    if (AudioHelper.e()) {
      QLog.w(akyx.a, 1, "getUnzipDirPath, path[" + paramalxq + "]");
    }
    return paramalxq;
  }
  
  public boolean a(alxq paramalxq)
  {
    akyo localakyo = (akyo)paramalxq.a;
    localakyo.jdField_d_of_type_Int = 0;
    boolean bool1 = super.a(paramalxq);
    String str1 = "ARPromotionRDHandler, needDownload[" + bool1 + "], zipItem[" + localakyo;
    String str4;
    File localFile;
    boolean bool2;
    String str3;
    if (bool1)
    {
      str4 = ausb.a("20180426_803_worldcupXXX", localakyo.b);
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
        str1 = bfko.a(localFile);
        str3 = str3 + "], preMd5[" + str1;
        if (TextUtils.equals(localakyo.b, str1))
        {
          str1 = str3 + ajya.a(2131700733);
          bool2 = bbdx.d(str4, b(paramalxq));
          bool1 = super.a(paramalxq);
          paramalxq = str1 + ", copyFile[" + bool2 + "], reCheck[" + bool1 + "]";
          if (!bool1) {
            localakyo.jdField_d_of_type_Int = 1;
          }
          QLog.w(akyx.a, 1, paramalxq);
          return bool1;
        }
      }
      catch (Exception localException)
      {
        str2 = "Exception";
        continue;
        paramalxq = str3 + ajya.a(2131700732);
        continue;
      }
      paramalxq = str3;
      continue;
      paramalxq = str2;
    }
  }
  
  public boolean a(alxq paramalxq, boolean paramBoolean)
  {
    return false;
  }
  
  public String b(alxq paramalxq)
  {
    paramalxq = ((akyo)paramalxq.a).c;
    if (AudioHelper.e()) {
      QLog.w(akyx.a, 1, "getDownloadPath, path[" + paramalxq + "]");
    }
    return paramalxq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akyj
 * JD-Core Version:    0.7.0.1
 */