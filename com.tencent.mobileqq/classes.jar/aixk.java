import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aixk
{
  aixi jdField_a_of_type_Aixi = null;
  aixm jdField_a_of_type_Aixm;
  axro jdField_a_of_type_Axro;
  boolean jdField_a_of_type_Boolean = false;
  
  boolean a(aixi paramaixi, int paramInt)
  {
    String str1;
    if (!aixj.b(paramaixi))
    {
      String str2 = paramaixi.jdField_a_of_type_JavaLangString;
      str1 = paramaixi.b;
      String str3 = aixj.a(paramaixi);
      axro localaxro = new axro();
      localaxro.jdField_a_of_type_Axrt = new aixl(this, str1, paramaixi);
      localaxro.a(str1);
      localaxro.jdField_a_of_type_JavaLangString = str2;
      localaxro.jdField_a_of_type_Int = 0;
      localaxro.jdField_c_of_type_JavaLangString = new File(str3).getPath();
      localaxro.jdField_c_of_type_Int = badq.a(axsr.a().a());
      paramaixi = aing.a().getNetEngine(0);
      if (paramaixi == null) {
        break label206;
      }
      this.jdField_a_of_type_Axro = localaxro;
      paramaixi.a(this.jdField_a_of_type_Axro);
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_Aixm != null)) {
        this.jdField_a_of_type_Aixm.a(3, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
      }
      return bool;
      if (this.jdField_a_of_type_Aixm != null) {
        this.jdField_a_of_type_Aixm.a(0, "So Already Exist!!!");
      }
      return false;
    }
  }
  
  boolean a(aixi paramaixi, aixm paramaixm)
  {
    this.jdField_a_of_type_Aixm = paramaixm;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Aixi == paramaixi) || (TextUtils.isEmpty(paramaixi.b)) || (paramaixi.b.equals(this.jdField_a_of_type_Aixi.b))) {
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
        if (this.jdField_a_of_type_Axro != null)
        {
          paramaixm = aing.a().getNetEngine(0);
          if (paramaixm != null)
          {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Axro.a() }));
            paramaixm.b(this.jdField_a_of_type_Axro);
          }
        }
        this.jdField_a_of_type_Aixi = paramaixi;
        this.jdField_a_of_type_Axro = null;
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.jdField_a_of_type_Aixi }));
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Aixi, 1);
        return this.jdField_a_of_type_Boolean;
        label214:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aixk
 * JD-Core Version:    0.7.0.1
 */