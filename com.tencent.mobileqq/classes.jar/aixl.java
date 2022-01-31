import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aixl
  implements axrt
{
  aixl(aixk paramaixk, String paramString, aixi paramaixi) {}
  
  public void onResp(axsq paramaxsq)
  {
    axro localaxro = (axro)paramaxsq.jdField_a_of_type_Axsp;
    if (this.jdField_a_of_type_Aixk.jdField_a_of_type_Axro == localaxro) {
      this.jdField_a_of_type_Aixk.jdField_a_of_type_Axro = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TMG_Downloader", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localaxro.jdField_a_of_type_JavaLangString, Integer.valueOf(paramaxsq.jdField_a_of_type_Int), Integer.valueOf(paramaxsq.c), this.jdField_a_of_type_JavaLangString }));
    }
    if (paramaxsq.jdField_a_of_type_Int == 0)
    {
      paramaxsq = new File(localaxro.c);
      if (!paramaxsq.exists()) {}
    }
    do
    {
      for (;;)
      {
        try
        {
          paramaxsq = paramaxsq.getParent();
          bace.a(localaxro.c, paramaxsq, false);
          aixj.a(this.jdField_a_of_type_Aixi.b);
          i = 1;
          if (i == 0) {
            break;
          }
          if (this.jdField_a_of_type_Aixk.jdField_a_of_type_Aixm != null)
          {
            this.jdField_a_of_type_Aixk.jdField_a_of_type_Aixm.a(100);
            this.jdField_a_of_type_Aixk.jdField_a_of_type_Aixm.a(0, "Download Complete!!!");
          }
          this.jdField_a_of_type_Aixk.jdField_a_of_type_Boolean = false;
          return;
        }
        catch (Exception paramaxsq)
        {
          paramaxsq.printStackTrace();
        }
        int i = 0;
      }
    } while (this.jdField_a_of_type_Aixk.jdField_a_of_type_Aixm == null);
    this.jdField_a_of_type_Aixk.jdField_a_of_type_Aixm.a(2, "");
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aixk.jdField_a_of_type_Aixm != null) {
        this.jdField_a_of_type_Aixk.jdField_a_of_type_Aixm.a(i);
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
 * Qualified Name:     aixl
 * JD-Core Version:    0.7.0.1
 */