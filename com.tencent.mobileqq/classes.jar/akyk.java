import android.text.TextUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class akyk
  extends alxn
{
  public String a(alxr paramalxr)
  {
    paramalxr = ((akyp)paramalxr.a).jdField_d_of_type_JavaLangString;
    if (AudioHelper.e()) {
      QLog.w(akyy.a, 1, "getUnzipDirPath, path[" + paramalxr + "]");
    }
    return paramalxr;
  }
  
  public boolean a(alxr paramalxr)
  {
    akyp localakyp = (akyp)paramalxr.a;
    localakyp.jdField_d_of_type_Int = 0;
    boolean bool1 = super.a(paramalxr);
    String str1 = "ARPromotionRDHandler, needDownload[" + bool1 + "], zipItem[" + localakyp;
    String str4;
    File localFile;
    boolean bool2;
    String str3;
    if (bool1)
    {
      str4 = aurz.a("20180426_803_worldcupXXX", localakyp.b);
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
        str1 = bfjx.a(localFile);
        str3 = str3 + "], preMd5[" + str1;
        if (TextUtils.equals(localakyp.b, str1))
        {
          str1 = str3 + ajyc.a(2131700722);
          bool2 = bbdj.d(str4, b(paramalxr));
          bool1 = super.a(paramalxr);
          paramalxr = str1 + ", copyFile[" + bool2 + "], reCheck[" + bool1 + "]";
          if (!bool1) {
            localakyp.jdField_d_of_type_Int = 1;
          }
          QLog.w(akyy.a, 1, paramalxr);
          return bool1;
        }
      }
      catch (Exception localException)
      {
        str2 = "Exception";
        continue;
        paramalxr = str3 + ajyc.a(2131700721);
        continue;
      }
      paramalxr = str3;
      continue;
      paramalxr = str2;
    }
  }
  
  public boolean a(alxr paramalxr, boolean paramBoolean)
  {
    return false;
  }
  
  public String b(alxr paramalxr)
  {
    paramalxr = ((akyp)paramalxr.a).c;
    if (AudioHelper.e()) {
      QLog.w(akyy.a, 1, "getDownloadPath, path[" + paramalxr + "]");
    }
    return paramalxr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akyk
 * JD-Core Version:    0.7.0.1
 */