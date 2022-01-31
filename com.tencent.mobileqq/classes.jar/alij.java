import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

class alij
  implements ayxr
{
  alij(alii paramalii, alio paramalio) {}
  
  public void a(ayxq paramayxq)
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, "onPreDownloadStart");
  }
  
  public void onResp(aysz paramaysz)
  {
    if (paramaysz.jdField_a_of_type_Int == 3) {
      QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download init. url = " + ((ayrx)paramaysz.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      return;
      int i;
      synchronized (alii.a(this.jdField_a_of_type_Alii))
      {
        if (alii.a(this.jdField_a_of_type_Alii) != null)
        {
          i = 0;
          label67:
          if (i < alii.a(this.jdField_a_of_type_Alii).size())
          {
            if (!((alio)alii.a(this.jdField_a_of_type_Alii).get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Alio.jdField_a_of_type_JavaLangString)) {
              break label342;
            }
            alii.a(this.jdField_a_of_type_Alii).remove(i);
          }
        }
      }
      synchronized (alii.a(this.jdField_a_of_type_Alii))
      {
        ??? = (alin)alii.a(this.jdField_a_of_type_Alii).get(this.jdField_a_of_type_Alio.b);
        if (paramaysz.jdField_a_of_type_Int == 0)
        {
          if (alii.a(this.jdField_a_of_type_Alii) != null) {
            alii.a(this.jdField_a_of_type_Alii).a(this.jdField_a_of_type_Alio.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Alio.jdField_a_of_type_Long);
          }
          ??? = new File(((ayrx)paramaysz.jdField_a_of_type_Aysy).c);
          String str = aurn.a(((File)???).getAbsolutePath());
          if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_Alio.b))) && (this.jdField_a_of_type_Alio.jdField_a_of_type_Int != 1))
          {
            QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download end. MD5 check error. url = " + ((ayrx)paramaysz.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
            if (??? == null) {
              continue;
            }
            ((alin)???).a(false, this.jdField_a_of_type_Alio);
            return;
            label342:
            i += 1;
            break label67;
            paramaysz = finally;
            throw paramaysz;
          }
        }
      }
      for (boolean bool = true; ??? != null; bool = false)
      {
        ((alin)???).a(bool, this.jdField_a_of_type_Alio);
        return;
        if (alii.a(this.jdField_a_of_type_Alii) != null) {
          alii.a(this.jdField_a_of_type_Alii).a(this.jdField_a_of_type_Alio.jdField_a_of_type_JavaLangString, -1L);
        }
      }
    }
  }
  
  public void onUpdateProgeress(aysy arg1, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARPreSoResourceDownload", 2, "onUpdateProgeress. url = " + ((ayrx)???).jdField_a_of_type_JavaLangString + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    synchronized (alii.a(this.jdField_a_of_type_Alii))
    {
      alin localalin = (alin)alii.a(this.jdField_a_of_type_Alii).get(this.jdField_a_of_type_Alio.b);
      if (localalin != null) {
        localalin.a(paramLong1, paramLong2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alij
 * JD-Core Version:    0.7.0.1
 */