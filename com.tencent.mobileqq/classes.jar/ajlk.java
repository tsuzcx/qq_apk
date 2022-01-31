import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ajlk
{
  ajli jdField_a_of_type_Ajli = null;
  ajlm jdField_a_of_type_Ajlm;
  ayrx jdField_a_of_type_Ayrx;
  boolean jdField_a_of_type_Boolean = false;
  
  boolean a(ajli paramajli, int paramInt)
  {
    String str1;
    if (!ajlj.b(paramajli))
    {
      String str2 = paramajli.jdField_a_of_type_JavaLangString;
      str1 = paramajli.b;
      String str3 = ajlj.a(paramajli);
      ayrx localayrx = new ayrx();
      localayrx.jdField_a_of_type_Aysc = new ajll(this, str1, paramajli);
      localayrx.a(str1);
      localayrx.jdField_a_of_type_JavaLangString = str2;
      localayrx.jdField_a_of_type_Int = 0;
      localayrx.jdField_c_of_type_JavaLangString = new File(str3).getPath();
      localayrx.jdField_c_of_type_Int = bbfj.a(ayta.a().a());
      paramajli = ajac.a().getNetEngine(0);
      if (paramajli == null) {
        break label206;
      }
      this.jdField_a_of_type_Ayrx = localayrx;
      paramajli.a(this.jdField_a_of_type_Ayrx);
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_Ajlm != null)) {
        this.jdField_a_of_type_Ajlm.a(3, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
      }
      return bool;
      if (this.jdField_a_of_type_Ajlm != null) {
        this.jdField_a_of_type_Ajlm.a(0, "So Already Exist!!!");
      }
      return false;
    }
  }
  
  boolean a(ajli paramajli, ajlm paramajlm)
  {
    this.jdField_a_of_type_Ajlm = paramajlm;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Ajli == paramajli) || (TextUtils.isEmpty(paramajli.b)) || (paramajli.b.equals(this.jdField_a_of_type_Ajli.b))) {
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
        if (this.jdField_a_of_type_Ayrx != null)
        {
          paramajlm = ajac.a().getNetEngine(0);
          if (paramajlm != null)
          {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Ayrx.a() }));
            paramajlm.b(this.jdField_a_of_type_Ayrx);
          }
        }
        this.jdField_a_of_type_Ajli = paramajli;
        this.jdField_a_of_type_Ayrx = null;
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.jdField_a_of_type_Ajli }));
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Ajli, 1);
        return this.jdField_a_of_type_Boolean;
        label214:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajlk
 * JD-Core Version:    0.7.0.1
 */