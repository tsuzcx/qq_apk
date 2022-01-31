import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class aiua
  extends batl
{
  aiua(String paramString, File paramFile, aiuf paramaiuf) {}
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData onDone url" + this.jdField_a_of_type_JavaLangString + " task.getStatus():" + parambatm.a());
    }
    if (3 == parambatm.a()) {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    }
    while (this.jdField_a_of_type_Aiuf == null)
    {
      do
      {
        try
        {
          mpx.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
          if (this.jdField_a_of_type_Aiuf != null) {
            this.jdField_a_of_type_Aiuf.a(true, 0);
          }
          return;
        }
        catch (Exception parambatm)
        {
          for (;;)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error  error->" + parambatm.getMessage());
            }
          }
        }
        catch (OutOfMemoryError parambatm)
        {
          for (;;)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error resType->" + parambatm.getMessage());
            }
          }
        }
      } while (this.jdField_a_of_type_Aiuf == null);
      this.jdField_a_of_type_Aiuf.a(false, 0);
      return;
    }
    this.jdField_a_of_type_Aiuf.a(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiua
 * JD-Core Version:    0.7.0.1
 */