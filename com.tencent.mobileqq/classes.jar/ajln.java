import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ajln
  implements aysa
{
  ajln(ajlm paramajlm, String paramString, ajlk paramajlk) {}
  
  public void onResp(aysx paramaysx)
  {
    ayrv localayrv = (ayrv)paramaysx.jdField_a_of_type_Aysw;
    if (this.jdField_a_of_type_Ajlm.jdField_a_of_type_Ayrv == localayrv) {
      this.jdField_a_of_type_Ajlm.jdField_a_of_type_Ayrv = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TMG_Downloader", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localayrv.jdField_a_of_type_JavaLangString, Integer.valueOf(paramaysx.jdField_a_of_type_Int), Integer.valueOf(paramaysx.c), this.jdField_a_of_type_JavaLangString }));
    }
    if (paramaysx.jdField_a_of_type_Int == 0)
    {
      paramaysx = new File(localayrv.c);
      if (!paramaysx.exists()) {}
    }
    do
    {
      for (;;)
      {
        try
        {
          paramaysx = paramaysx.getParent();
          bbdj.a(localayrv.c, paramaysx, false);
          ajll.a(this.jdField_a_of_type_Ajlk.b);
          i = 1;
          if (i == 0) {
            break;
          }
          if (this.jdField_a_of_type_Ajlm.jdField_a_of_type_Ajlo != null)
          {
            this.jdField_a_of_type_Ajlm.jdField_a_of_type_Ajlo.a(100);
            this.jdField_a_of_type_Ajlm.jdField_a_of_type_Ajlo.a(0, "Download Complete!!!");
          }
          this.jdField_a_of_type_Ajlm.jdField_a_of_type_Boolean = false;
          return;
        }
        catch (Exception paramaysx)
        {
          paramaysx.printStackTrace();
        }
        int i = 0;
      }
    } while (this.jdField_a_of_type_Ajlm.jdField_a_of_type_Ajlo == null);
    this.jdField_a_of_type_Ajlm.jdField_a_of_type_Ajlo.a(2, "");
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ajlm.jdField_a_of_type_Ajlo != null) {
        this.jdField_a_of_type_Ajlm.jdField_a_of_type_Ajlo.a(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajln
 * JD-Core Version:    0.7.0.1
 */