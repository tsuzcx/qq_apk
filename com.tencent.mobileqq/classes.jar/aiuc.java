import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class aiuc
  extends bbwt
{
  aiuc(String paramString1, File paramFile, AtomicInteger paramAtomicInteger1, int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, aiud paramaiud, aiua paramaiua, String paramString2, List paramList) {}
  
  public void onDone(bbwu parambbwu)
  {
    boolean bool = true;
    super.onDone(parambbwu);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscDownloader", 1, "download url:" + this.jdField_a_of_type_JavaLangString + " task.getStatus()->" + parambbwu.a());
    }
    if (3 == parambbwu.a()) {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    }
    do
    {
      for (;;)
      {
        try
        {
          nav.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
          if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != this.c.get()) {
            break;
          }
          if (this.jdField_a_of_type_Aiud != null)
          {
            parambbwu = "";
            if (this.jdField_a_of_type_Aiua != null) {
              parambbwu = this.jdField_a_of_type_Aiua.c();
            }
            aiud localaiud = this.jdField_a_of_type_Aiud;
            if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) {
              bool = false;
            }
            localaiud.a(bool, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, parambbwu);
            if (QLog.isColorLevel()) {
              QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes download all done uin: " + this.jdField_b_of_type_JavaLangString + "all cnt: " + this.c.get() + ", err cnt: " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
            }
          }
          return;
        }
        catch (Exception parambbwu)
        {
          this.jdField_a_of_type_JavaIoFile.delete();
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("rscContent_CmShowRscDownloader", 2, "unZipFile file error resType->" + this.jdField_a_of_type_Int + " id->" + this.jdField_b_of_type_Int + " error->" + parambbwu.getMessage());
          continue;
        }
        catch (OutOfMemoryError parambbwu)
        {
          this.jdField_a_of_type_JavaIoFile.delete();
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("rscContent_CmShowRscDownloader", 2, "unZipFile file error resType->" + this.jdField_a_of_type_Int + " id->" + this.jdField_b_of_type_Int + " error->" + parambbwu.getMessage());
          continue;
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
        QLog.d("rscContent_CmShowRscDownloader", 1, "download file error resType->" + this.jdField_a_of_type_Int + " id->" + this.jdField_b_of_type_Int + " task.getStatus()->" + parambbwu.a());
      }
    } while (!QLog.isColorLevel());
    QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes download uin:" + this.jdField_b_of_type_JavaLangString + ", cb cnt: " + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", all cnt: " + this.c.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiuc
 * JD-Core Version:    0.7.0.1
 */