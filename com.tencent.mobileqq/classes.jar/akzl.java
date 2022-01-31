import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class akzl
  extends bdvu
{
  akzl(String paramString, File paramFile, akzr paramakzr) {}
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData onDone url" + this.jdField_a_of_type_JavaLangString + " task.getStatus():" + parambdvv.a());
    }
    if (3 == parambdvv.a()) {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    }
    while (this.jdField_a_of_type_Akzr == null)
    {
      do
      {
        try
        {
          ndr.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
          if (this.jdField_a_of_type_Akzr != null) {
            this.jdField_a_of_type_Akzr.a(true, 0);
          }
          return;
        }
        catch (Exception parambdvv)
        {
          for (;;)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error  error->" + parambdvv.getMessage());
            }
          }
        }
        catch (OutOfMemoryError parambdvv)
        {
          for (;;)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error resType->" + parambdvv.getMessage());
            }
          }
        }
      } while (this.jdField_a_of_type_Akzr == null);
      this.jdField_a_of_type_Akzr.a(false, 0);
      return;
    }
    this.jdField_a_of_type_Akzr.a(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzl
 * JD-Core Version:    0.7.0.1
 */