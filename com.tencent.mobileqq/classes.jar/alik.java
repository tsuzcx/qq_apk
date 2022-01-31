import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

class alik
  implements ayxp
{
  alik(alij paramalij, alip paramalip) {}
  
  public void a(ayxo paramayxo)
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, "onPreDownloadStart");
  }
  
  public void onResp(aysx paramaysx)
  {
    if (paramaysx.jdField_a_of_type_Int == 3) {
      QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download init. url = " + ((ayrv)paramaysx.jdField_a_of_type_Aysw).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      return;
      int i;
      synchronized (alij.a(this.jdField_a_of_type_Alij))
      {
        if (alij.a(this.jdField_a_of_type_Alij) != null)
        {
          i = 0;
          label67:
          if (i < alij.a(this.jdField_a_of_type_Alij).size())
          {
            if (!((alip)alij.a(this.jdField_a_of_type_Alij).get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Alip.jdField_a_of_type_JavaLangString)) {
              break label342;
            }
            alij.a(this.jdField_a_of_type_Alij).remove(i);
          }
        }
      }
      synchronized (alij.a(this.jdField_a_of_type_Alij))
      {
        ??? = (alio)alij.a(this.jdField_a_of_type_Alij).get(this.jdField_a_of_type_Alip.b);
        if (paramaysx.jdField_a_of_type_Int == 0)
        {
          if (alij.a(this.jdField_a_of_type_Alij) != null) {
            alij.a(this.jdField_a_of_type_Alij).a(this.jdField_a_of_type_Alip.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Alip.jdField_a_of_type_Long);
          }
          ??? = new File(((ayrv)paramaysx.jdField_a_of_type_Aysw).c);
          String str = aurl.a(((File)???).getAbsolutePath());
          if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_Alip.b))) && (this.jdField_a_of_type_Alip.jdField_a_of_type_Int != 1))
          {
            QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download end. MD5 check error. url = " + ((ayrv)paramaysx.jdField_a_of_type_Aysw).jdField_a_of_type_JavaLangString + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
            if (??? == null) {
              continue;
            }
            ((alio)???).a(false, this.jdField_a_of_type_Alip);
            return;
            label342:
            i += 1;
            break label67;
            paramaysx = finally;
            throw paramaysx;
          }
        }
      }
      for (boolean bool = true; ??? != null; bool = false)
      {
        ((alio)???).a(bool, this.jdField_a_of_type_Alip);
        return;
        if (alij.a(this.jdField_a_of_type_Alij) != null) {
          alij.a(this.jdField_a_of_type_Alij).a(this.jdField_a_of_type_Alip.jdField_a_of_type_JavaLangString, -1L);
        }
      }
    }
  }
  
  public void onUpdateProgeress(aysw arg1, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARPreSoResourceDownload", 2, "onUpdateProgeress. url = " + ((ayrv)???).jdField_a_of_type_JavaLangString + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    synchronized (alij.a(this.jdField_a_of_type_Alij))
    {
      alio localalio = (alio)alij.a(this.jdField_a_of_type_Alij).get(this.jdField_a_of_type_Alip.b);
      if (localalio != null) {
        localalio.a(paramLong1, paramLong2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alik
 * JD-Core Version:    0.7.0.1
 */