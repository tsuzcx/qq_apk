import com.tencent.qphone.base.util.QLog;
import java.io.File;

class alhm
  implements baug
{
  alhm(alhl paramalhl, String paramString, alhj paramalhj) {}
  
  public void onResp(bavf parambavf)
  {
    baub localbaub = (baub)parambavf.jdField_a_of_type_Bave;
    if (this.jdField_a_of_type_Alhl.jdField_a_of_type_Baub == localbaub) {
      this.jdField_a_of_type_Alhl.jdField_a_of_type_Baub = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TMG_Downloader", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localbaub.jdField_a_of_type_JavaLangString, Integer.valueOf(parambavf.jdField_a_of_type_Int), Integer.valueOf(parambavf.c), this.jdField_a_of_type_JavaLangString }));
    }
    if (parambavf.jdField_a_of_type_Int == 0)
    {
      parambavf = new File(localbaub.c);
      if (!parambavf.exists()) {}
    }
    do
    {
      for (;;)
      {
        try
        {
          parambavf = parambavf.getParent();
          bdhb.a(localbaub.c, parambavf, false);
          alhk.a(this.jdField_a_of_type_Alhj.b);
          i = 1;
          if (i == 0) {
            break;
          }
          if (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn != null)
          {
            this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.a(100);
            this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.a(0, "Download Complete!!!");
          }
          this.jdField_a_of_type_Alhl.jdField_a_of_type_Boolean = false;
          return;
        }
        catch (Exception parambavf)
        {
          parambavf.printStackTrace();
        }
        int i = 0;
      }
    } while (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn == null);
    this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.a(2, "");
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn != null) {
        this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.a(i);
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
 * Qualified Name:     alhm
 * JD-Core Version:    0.7.0.1
 */