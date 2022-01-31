import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class alit
  implements aysc
{
  alit(alis paramalis, aliw paramaliw, aliv paramaliv) {}
  
  public void onResp(aysz paramaysz)
  {
    if (paramaysz.jdField_a_of_type_Int == 3)
    {
      QLog.i("AREngine_ARResourceDownload", 1, "Download init. url = " + ((ayrx)paramaysz.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString);
      return;
    }
    synchronized (alis.a(this.jdField_a_of_type_Alis))
    {
      int i;
      if (alis.a(this.jdField_a_of_type_Alis) != null)
      {
        i = 0;
        if (i < alis.a(this.jdField_a_of_type_Alis).size())
        {
          if (!((aliw)alis.a(this.jdField_a_of_type_Alis).get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Aliw.jdField_a_of_type_JavaLangString)) {
            break label268;
          }
          alis.a(this.jdField_a_of_type_Alis).remove(i);
        }
      }
      if (paramaysz.jdField_a_of_type_Int == 0)
      {
        ??? = new File(((ayrx)paramaysz.jdField_a_of_type_Aysy).c);
        String str = aurn.a(((File)???).getAbsolutePath());
        if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_Aliw.b))) && (this.jdField_a_of_type_Aliw.jdField_a_of_type_Int != 1))
        {
          QLog.i("AREngine_ARResourceDownload", 1, "Download end. MD5 check error. url = " + ((ayrx)paramaysz.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
          this.jdField_a_of_type_Aliv.a(false, this.jdField_a_of_type_Aliw);
          return;
          label268:
          i += 1;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Aliv.a(bool, this.jdField_a_of_type_Aliw);
      return;
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARResourceDownload", 2, "onUpdateProgeress. url = " + ((ayrx)paramaysy).jdField_a_of_type_JavaLangString + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    this.jdField_a_of_type_Aliv.a(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alit
 * JD-Core Version:    0.7.0.1
 */