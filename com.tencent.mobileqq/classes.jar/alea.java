import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class alea
  extends bead
{
  alea(String paramString, File paramFile, aleg paramaleg) {}
  
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData onDone url" + this.jdField_a_of_type_JavaLangString + " task.getStatus():" + parambeae.a());
    }
    if (3 == parambeae.a()) {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    }
    while (this.jdField_a_of_type_Aleg == null)
    {
      do
      {
        try
        {
          ndr.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
          if (this.jdField_a_of_type_Aleg != null) {
            this.jdField_a_of_type_Aleg.a(true, 0);
          }
          return;
        }
        catch (Exception parambeae)
        {
          for (;;)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error  error->" + parambeae.getMessage());
            }
          }
        }
        catch (OutOfMemoryError parambeae)
        {
          for (;;)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error resType->" + parambeae.getMessage());
            }
          }
        }
      } while (this.jdField_a_of_type_Aleg == null);
      this.jdField_a_of_type_Aleg.a(false, 0);
      return;
    }
    this.jdField_a_of_type_Aleg.a(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alea
 * JD-Core Version:    0.7.0.1
 */