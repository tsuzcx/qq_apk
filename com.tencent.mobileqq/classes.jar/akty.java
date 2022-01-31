import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

class akty
  implements axxi
{
  akty(aktx paramaktx, akud paramakud) {}
  
  public void a(axxh paramaxxh)
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, "onPreDownloadStart");
  }
  
  public void onResp(axsq paramaxsq)
  {
    if (paramaxsq.jdField_a_of_type_Int == 3) {
      QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download init. url = " + ((axro)paramaxsq.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      return;
      int i;
      synchronized (aktx.a(this.jdField_a_of_type_Aktx))
      {
        if (aktx.a(this.jdField_a_of_type_Aktx) != null)
        {
          i = 0;
          label67:
          if (i < aktx.a(this.jdField_a_of_type_Aktx).size())
          {
            if (!((akud)aktx.a(this.jdField_a_of_type_Aktx).get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Akud.jdField_a_of_type_JavaLangString)) {
              break label342;
            }
            aktx.a(this.jdField_a_of_type_Aktx).remove(i);
          }
        }
      }
      synchronized (aktx.a(this.jdField_a_of_type_Aktx))
      {
        ??? = (akuc)aktx.a(this.jdField_a_of_type_Aktx).get(this.jdField_a_of_type_Akud.b);
        if (paramaxsq.jdField_a_of_type_Int == 0)
        {
          if (aktx.a(this.jdField_a_of_type_Aktx) != null) {
            aktx.a(this.jdField_a_of_type_Aktx).a(this.jdField_a_of_type_Akud.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Akud.jdField_a_of_type_Long);
          }
          ??? = new File(((axro)paramaxsq.jdField_a_of_type_Axsp).c);
          String str = attn.a(((File)???).getAbsolutePath());
          if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_Akud.b))) && (this.jdField_a_of_type_Akud.jdField_a_of_type_Int != 1))
          {
            QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download end. MD5 check error. url = " + ((axro)paramaxsq.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
            if (??? == null) {
              continue;
            }
            ((akuc)???).a(false, this.jdField_a_of_type_Akud);
            return;
            label342:
            i += 1;
            break label67;
            paramaxsq = finally;
            throw paramaxsq;
          }
        }
      }
      for (boolean bool = true; ??? != null; bool = false)
      {
        ((akuc)???).a(bool, this.jdField_a_of_type_Akud);
        return;
        if (aktx.a(this.jdField_a_of_type_Aktx) != null) {
          aktx.a(this.jdField_a_of_type_Aktx).a(this.jdField_a_of_type_Akud.jdField_a_of_type_JavaLangString, -1L);
        }
      }
    }
  }
  
  public void onUpdateProgeress(axsp arg1, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARPreSoResourceDownload", 2, "onUpdateProgeress. url = " + ((axro)???).jdField_a_of_type_JavaLangString + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    synchronized (aktx.a(this.jdField_a_of_type_Aktx))
    {
      akuc localakuc = (akuc)aktx.a(this.jdField_a_of_type_Aktx).get(this.jdField_a_of_type_Akud.b);
      if (localakuc != null) {
        localakuc.a(paramLong1, paramLong2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akty
 * JD-Core Version:    0.7.0.1
 */