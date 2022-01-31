import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class ajhv
  implements ajic
{
  ajhv(airx paramairx, int[] paramArrayOfInt, AppInterface paramAppInterface, ajic paramajic, boolean paramBoolean, int paramInt) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean)
    {
      File localFile;
      if ((Build.VERSION.SDK_INT < 24) && (BaseApplicationImpl.sProcessId == 1))
      {
        localFile = new File(ajhu.a(1, paramInt1), "dress.zip");
        if (!localFile.exists()) {}
      }
      try
      {
        paramArrayOfInt = ajms.f;
        if (paramInt1 == 0) {
          paramArrayOfInt = ajms.c + "/def/dress/";
        }
        new File(paramArrayOfInt).mkdirs();
        nav.a(localFile, paramArrayOfInt);
        paramArrayOfInt = ajhu.a(paramInt1);
        if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
        {
          int j = paramArrayOfInt.length;
          int i = 0;
          while (i < j)
          {
            int k = paramArrayOfInt[i];
            ajhu.a(this.jdField_a_of_type_Airx, 2, k);
            i += 1;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder down load role succ  id: " + paramInt1 + ", uin: " + paramString);
        }
      }
      catch (Exception paramArrayOfInt)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder unZipFile file error resType->" + paramInt1 + " error->" + paramArrayOfInt.getMessage(), paramArrayOfInt);
          }
        }
      }
      catch (OutOfMemoryError paramArrayOfInt)
      {
        do
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder unZipFile file error resType->" + paramInt1 + " error->" + paramArrayOfInt.getMessage());
            }
          }
        } while (this.jdField_a_of_type_Ajic == null);
        this.jdField_a_of_type_Ajic.onDownLoadFinish(true, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt, paramInt2);
        return;
      }
      if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0)) {
        ajhu.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, this.jdField_a_of_type_Ajic, -1, this.jdField_a_of_type_ArrayOfInt, -1, -1, this.jdField_a_of_type_Boolean);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Ajic != null) {
        this.jdField_a_of_type_Ajic.onDownLoadFinish(false, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt, paramInt2);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder down load role fail id: " + this.jdField_a_of_type_Int + ", uin:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajhv
 * JD-Core Version:    0.7.0.1
 */