import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class akui
  implements axrt
{
  akui(akuh paramakuh, akul paramakul, akuk paramakuk) {}
  
  public void onResp(axsq paramaxsq)
  {
    if (paramaxsq.jdField_a_of_type_Int == 3)
    {
      QLog.i("AREngine_ARResourceDownload", 1, "Download init. url = " + ((axro)paramaxsq.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString);
      return;
    }
    synchronized (akuh.a(this.jdField_a_of_type_Akuh))
    {
      int i;
      if (akuh.a(this.jdField_a_of_type_Akuh) != null)
      {
        i = 0;
        if (i < akuh.a(this.jdField_a_of_type_Akuh).size())
        {
          if (!((akul)akuh.a(this.jdField_a_of_type_Akuh).get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Akul.jdField_a_of_type_JavaLangString)) {
            break label268;
          }
          akuh.a(this.jdField_a_of_type_Akuh).remove(i);
        }
      }
      if (paramaxsq.jdField_a_of_type_Int == 0)
      {
        ??? = new File(((axro)paramaxsq.jdField_a_of_type_Axsp).c);
        String str = attn.a(((File)???).getAbsolutePath());
        if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_Akul.b))) && (this.jdField_a_of_type_Akul.jdField_a_of_type_Int != 1))
        {
          QLog.i("AREngine_ARResourceDownload", 1, "Download end. MD5 check error. url = " + ((axro)paramaxsq.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
          this.jdField_a_of_type_Akuk.a(false, this.jdField_a_of_type_Akul);
          return;
          label268:
          i += 1;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Akuk.a(bool, this.jdField_a_of_type_Akul);
      return;
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARResourceDownload", 2, "onUpdateProgeress. url = " + ((axro)paramaxsp).jdField_a_of_type_JavaLangString + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    this.jdField_a_of_type_Akuk.a(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akui
 * JD-Core Version:    0.7.0.1
 */