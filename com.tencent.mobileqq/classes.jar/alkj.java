import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;

final class alkj
  implements aled
{
  alkj(String paramString, String[] paramArrayOfString, alkh paramalkh) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloHttpUtil", 2, "fakeResource3DUrlRequest onDownLoadFinish:" + paramInt1 + " sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      paramArrayOfInt = new File(this.jdField_a_of_type_JavaLangString);
      if (paramArrayOfInt.exists()) {
        try
        {
          paramString = alki.a(this.jdField_a_of_type_ArrayOfJavaLangString);
          if (alki.a(this.jdField_a_of_type_JavaLangString))
          {
            paramArrayOfInt = alki.a(paramArrayOfInt, paramString);
            this.jdField_a_of_type_Alkh.a(0, paramString, paramArrayOfInt);
          }
          while (QLog.isColorLevel())
          {
            QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest onDownLoadFinish retHeader:", paramString });
            return;
            this.jdField_a_of_type_Alkh.a(0, paramString, ApolloRender.readStream(new FileInputStream(paramArrayOfInt)));
          }
          this.jdField_a_of_type_Alkh.a(-1, null, null);
        }
        catch (Exception paramString)
        {
          QLog.e("ApolloHttpUtil", 1, paramString, new Object[0]);
          return;
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Alkh.a(-1, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkj
 * JD-Core Version:    0.7.0.1
 */