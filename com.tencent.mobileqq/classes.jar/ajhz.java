import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class ajhz
  extends bbwt
{
  ajhz(String paramString, File paramFile, ajif paramajif) {}
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData onDone url" + this.jdField_a_of_type_JavaLangString + " task.getStatus():" + parambbwu.a());
    }
    if (3 == parambbwu.a()) {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    }
    while (this.jdField_a_of_type_Ajif == null)
    {
      do
      {
        try
        {
          nav.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
          if (this.jdField_a_of_type_Ajif != null) {
            this.jdField_a_of_type_Ajif.a(true, 0);
          }
          return;
        }
        catch (Exception parambbwu)
        {
          for (;;)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error  error->" + parambbwu.getMessage());
            }
          }
        }
        catch (OutOfMemoryError parambbwu)
        {
          for (;;)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error resType->" + parambbwu.getMessage());
            }
          }
        }
      } while (this.jdField_a_of_type_Ajif == null);
      this.jdField_a_of_type_Ajif.a(false, 0);
      return;
    }
    this.jdField_a_of_type_Ajif.a(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajhz
 * JD-Core Version:    0.7.0.1
 */