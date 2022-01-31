import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class aliu
  implements aysa
{
  aliu(alit paramalit, alix paramalix, aliw paramaliw) {}
  
  public void onResp(aysx paramaysx)
  {
    if (paramaysx.jdField_a_of_type_Int == 3)
    {
      QLog.i("AREngine_ARResourceDownload", 1, "Download init. url = " + ((ayrv)paramaysx.jdField_a_of_type_Aysw).jdField_a_of_type_JavaLangString);
      return;
    }
    synchronized (alit.a(this.jdField_a_of_type_Alit))
    {
      int i;
      if (alit.a(this.jdField_a_of_type_Alit) != null)
      {
        i = 0;
        if (i < alit.a(this.jdField_a_of_type_Alit).size())
        {
          if (!((alix)alit.a(this.jdField_a_of_type_Alit).get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Alix.jdField_a_of_type_JavaLangString)) {
            break label268;
          }
          alit.a(this.jdField_a_of_type_Alit).remove(i);
        }
      }
      if (paramaysx.jdField_a_of_type_Int == 0)
      {
        ??? = new File(((ayrv)paramaysx.jdField_a_of_type_Aysw).c);
        String str = aurl.a(((File)???).getAbsolutePath());
        if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_Alix.b))) && (this.jdField_a_of_type_Alix.jdField_a_of_type_Int != 1))
        {
          QLog.i("AREngine_ARResourceDownload", 1, "Download end. MD5 check error. url = " + ((ayrv)paramaysx.jdField_a_of_type_Aysw).jdField_a_of_type_JavaLangString + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
          this.jdField_a_of_type_Aliw.a(false, this.jdField_a_of_type_Alix);
          return;
          label268:
          i += 1;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Aliw.a(bool, this.jdField_a_of_type_Alix);
      return;
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARResourceDownload", 2, "onUpdateProgeress. url = " + ((ayrv)paramaysw).jdField_a_of_type_JavaLangString + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    this.jdField_a_of_type_Aliw.a(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aliu
 * JD-Core Version:    0.7.0.1
 */