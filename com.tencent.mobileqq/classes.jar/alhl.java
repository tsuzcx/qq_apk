import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class alhl
{
  alhj jdField_a_of_type_Alhj = null;
  alhn jdField_a_of_type_Alhn;
  baub jdField_a_of_type_Baub;
  boolean jdField_a_of_type_Boolean = false;
  
  boolean a(alhj paramalhj, int paramInt)
  {
    String str1;
    if (!alhk.b(paramalhj))
    {
      String str2 = paramalhj.jdField_a_of_type_JavaLangString;
      str1 = paramalhj.b;
      String str3 = alhk.a(paramalhj);
      baub localbaub = new baub();
      localbaub.jdField_a_of_type_Baug = new alhm(this, str1, paramalhj);
      localbaub.a(str1);
      localbaub.jdField_a_of_type_JavaLangString = str2;
      localbaub.jdField_a_of_type_Int = 0;
      localbaub.jdField_c_of_type_JavaLangString = new File(str3).getPath();
      localbaub.jdField_c_of_type_Int = bdin.a(bavg.a().a());
      paramalhj = akwd.a().getNetEngine(0);
      if (paramalhj == null) {
        break label206;
      }
      this.jdField_a_of_type_Baub = localbaub;
      paramalhj.a(this.jdField_a_of_type_Baub);
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_Alhn != null)) {
        this.jdField_a_of_type_Alhn.a(3, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
      }
      return bool;
      if (this.jdField_a_of_type_Alhn != null) {
        this.jdField_a_of_type_Alhn.a(0, "So Already Exist!!!");
      }
      return false;
    }
  }
  
  boolean a(alhj paramalhj, alhn paramalhn)
  {
    this.jdField_a_of_type_Alhn = paramalhn;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Alhj == paramalhj) || (TextUtils.isEmpty(paramalhj.b)) || (paramalhj.b.equals(this.jdField_a_of_type_Alhj.b))) {
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
        if (this.jdField_a_of_type_Baub != null)
        {
          paramalhn = akwd.a().getNetEngine(0);
          if (paramalhn != null)
          {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Baub.a() }));
            paramalhn.b(this.jdField_a_of_type_Baub);
          }
        }
        this.jdField_a_of_type_Alhj = paramalhj;
        this.jdField_a_of_type_Baub = null;
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.jdField_a_of_type_Alhj }));
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Alhj, 1);
        return this.jdField_a_of_type_Boolean;
        label214:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alhl
 * JD-Core Version:    0.7.0.1
 */