import com.tencent.qphone.base.util.QLog;
import java.io.File;

class alcx
  implements bapx
{
  alcx(alcw paramalcw, String paramString, alcu paramalcu) {}
  
  public void onResp(baqw parambaqw)
  {
    baps localbaps = (baps)parambaqw.jdField_a_of_type_Baqv;
    if (this.jdField_a_of_type_Alcw.jdField_a_of_type_Baps == localbaps) {
      this.jdField_a_of_type_Alcw.jdField_a_of_type_Baps = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TMG_Downloader", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localbaps.jdField_a_of_type_JavaLangString, Integer.valueOf(parambaqw.jdField_a_of_type_Int), Integer.valueOf(parambaqw.c), this.jdField_a_of_type_JavaLangString }));
    }
    if (parambaqw.jdField_a_of_type_Int == 0)
    {
      parambaqw = new File(localbaps.c);
      if (!parambaqw.exists()) {}
    }
    do
    {
      for (;;)
      {
        try
        {
          parambaqw = parambaqw.getParent();
          bdcs.a(localbaps.c, parambaqw, false);
          alcv.a(this.jdField_a_of_type_Alcu.b);
          i = 1;
          if (i == 0) {
            break;
          }
          if (this.jdField_a_of_type_Alcw.jdField_a_of_type_Alcy != null)
          {
            this.jdField_a_of_type_Alcw.jdField_a_of_type_Alcy.a(100);
            this.jdField_a_of_type_Alcw.jdField_a_of_type_Alcy.a(0, "Download Complete!!!");
          }
          this.jdField_a_of_type_Alcw.jdField_a_of_type_Boolean = false;
          return;
        }
        catch (Exception parambaqw)
        {
          parambaqw.printStackTrace();
        }
        int i = 0;
      }
    } while (this.jdField_a_of_type_Alcw.jdField_a_of_type_Alcy == null);
    this.jdField_a_of_type_Alcw.jdField_a_of_type_Alcy.a(2, "");
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Alcw.jdField_a_of_type_Alcy != null) {
        this.jdField_a_of_type_Alcw.jdField_a_of_type_Alcy.a(i);
      }
      return;
      if (paramLong1 >= paramLong2) {
        i = 99;
      } else {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alcx
 * JD-Core Version:    0.7.0.1
 */