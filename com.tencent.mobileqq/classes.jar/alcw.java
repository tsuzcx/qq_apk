import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class alcw
{
  alcu jdField_a_of_type_Alcu = null;
  alcy jdField_a_of_type_Alcy;
  baps jdField_a_of_type_Baps;
  boolean jdField_a_of_type_Boolean = false;
  
  boolean a(alcu paramalcu, int paramInt)
  {
    String str1;
    if (!alcv.b(paramalcu))
    {
      String str2 = paramalcu.jdField_a_of_type_JavaLangString;
      str1 = paramalcu.b;
      String str3 = alcv.a(paramalcu);
      baps localbaps = new baps();
      localbaps.jdField_a_of_type_Bapx = new alcx(this, str1, paramalcu);
      localbaps.a(str1);
      localbaps.jdField_a_of_type_JavaLangString = str2;
      localbaps.jdField_a_of_type_Int = 0;
      localbaps.jdField_c_of_type_JavaLangString = new File(str3).getPath();
      localbaps.jdField_c_of_type_Int = bdee.a(baqx.a().a());
      paramalcu = akro.a().getNetEngine(0);
      if (paramalcu == null) {
        break label206;
      }
      this.jdField_a_of_type_Baps = localbaps;
      paramalcu.a(this.jdField_a_of_type_Baps);
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_Alcy != null)) {
        this.jdField_a_of_type_Alcy.a(3, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
      }
      return bool;
      if (this.jdField_a_of_type_Alcy != null) {
        this.jdField_a_of_type_Alcy.a(0, "So Already Exist!!!");
      }
      return false;
    }
  }
  
  boolean a(alcu paramalcu, alcy paramalcy)
  {
    this.jdField_a_of_type_Alcy = paramalcy;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Alcu == paramalcu) || (TextUtils.isEmpty(paramalcu.b)) || (paramalcu.b.equals(this.jdField_a_of_type_Alcu.b))) {
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
        if (this.jdField_a_of_type_Baps != null)
        {
          paramalcy = akro.a().getNetEngine(0);
          if (paramalcy != null)
          {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Baps.a() }));
            paramalcy.b(this.jdField_a_of_type_Baps);
          }
        }
        this.jdField_a_of_type_Alcu = paramalcu;
        this.jdField_a_of_type_Baps = null;
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.jdField_a_of_type_Alcu }));
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Alcu, 1);
        return this.jdField_a_of_type_Boolean;
        label214:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alcw
 * JD-Core Version:    0.7.0.1
 */