import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ajlm
{
  ajlk jdField_a_of_type_Ajlk = null;
  ajlo jdField_a_of_type_Ajlo;
  ayrv jdField_a_of_type_Ayrv;
  boolean jdField_a_of_type_Boolean = false;
  
  boolean a(ajlk paramajlk, int paramInt)
  {
    String str1;
    if (!ajll.b(paramajlk))
    {
      String str2 = paramajlk.jdField_a_of_type_JavaLangString;
      str1 = paramajlk.b;
      String str3 = ajll.a(paramajlk);
      ayrv localayrv = new ayrv();
      localayrv.jdField_a_of_type_Aysa = new ajln(this, str1, paramajlk);
      localayrv.a(str1);
      localayrv.jdField_a_of_type_JavaLangString = str2;
      localayrv.jdField_a_of_type_Int = 0;
      localayrv.jdField_c_of_type_JavaLangString = new File(str3).getPath();
      localayrv.jdField_c_of_type_Int = bbev.a(aysy.a().a());
      paramajlk = ajae.a().getNetEngine(0);
      if (paramajlk == null) {
        break label206;
      }
      this.jdField_a_of_type_Ayrv = localayrv;
      paramajlk.a(this.jdField_a_of_type_Ayrv);
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_Ajlo != null)) {
        this.jdField_a_of_type_Ajlo.a(3, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
      }
      return bool;
      if (this.jdField_a_of_type_Ajlo != null) {
        this.jdField_a_of_type_Ajlo.a(0, "So Already Exist!!!");
      }
      return false;
    }
  }
  
  boolean a(ajlk paramajlk, ajlo paramajlo)
  {
    this.jdField_a_of_type_Ajlo = paramajlo;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Ajlk == paramajlk) || (TextUtils.isEmpty(paramajlk.b)) || (paramajlk.b.equals(this.jdField_a_of_type_Ajlk.b))) {
        break label214;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mDownloading[%s], reDownload[%s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(bool) }));
      }
      if (!bool)
      {
        return this.jdField_a_of_type_Boolean;
        bool = true;
      }
      else
      {
        if (this.jdField_a_of_type_Ayrv != null)
        {
          paramajlo = ajae.a().getNetEngine(0);
          if (paramajlo != null)
          {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Ayrv.a() }));
            paramajlo.b(this.jdField_a_of_type_Ayrv);
          }
        }
        this.jdField_a_of_type_Ajlk = paramajlk;
        this.jdField_a_of_type_Ayrv = null;
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.jdField_a_of_type_Ajlk }));
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Ajlk, 1);
        return this.jdField_a_of_type_Boolean;
        label214:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajlm
 * JD-Core Version:    0.7.0.1
 */