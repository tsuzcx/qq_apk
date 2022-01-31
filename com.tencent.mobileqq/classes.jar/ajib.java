import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class ajib
  extends bbwf
{
  ajib(String paramString, File paramFile, ajih paramajih) {}
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData onDone url" + this.jdField_a_of_type_JavaLangString + " task.getStatus():" + parambbwg.a());
    }
    if (3 == parambbwg.a()) {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    }
    while (this.jdField_a_of_type_Ajih == null)
    {
      do
      {
        try
        {
          nay.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
          if (this.jdField_a_of_type_Ajih != null) {
            this.jdField_a_of_type_Ajih.a(true, 0);
          }
          return;
        }
        catch (Exception parambbwg)
        {
          for (;;)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error  error->" + parambbwg.getMessage());
            }
          }
        }
        catch (OutOfMemoryError parambbwg)
        {
          for (;;)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error resType->" + parambbwg.getMessage());
            }
          }
        }
      } while (this.jdField_a_of_type_Ajih == null);
      this.jdField_a_of_type_Ajih.a(false, 0);
      return;
    }
    this.jdField_a_of_type_Ajih.a(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajib
 * JD-Core Version:    0.7.0.1
 */