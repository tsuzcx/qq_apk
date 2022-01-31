import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class akqd
  extends bead
{
  akqd(String paramString1, File paramFile, AtomicInteger paramAtomicInteger1, int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, akqe paramakqe, akqb paramakqb, String paramString2, List paramList) {}
  
  public void onDone(beae parambeae)
  {
    boolean bool = true;
    super.onDone(parambeae);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscDownloader", 1, "download url:" + this.jdField_a_of_type_JavaLangString + " task.getStatus()->" + parambeae.a());
    }
    if (3 == parambeae.a()) {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    }
    do
    {
      for (;;)
      {
        try
        {
          ndr.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
          if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != this.c.get()) {
            break;
          }
          if (this.jdField_a_of_type_Akqe != null)
          {
            parambeae = "";
            if (this.jdField_a_of_type_Akqb != null) {
              parambeae = this.jdField_a_of_type_Akqb.c();
            }
            akqe localakqe = this.jdField_a_of_type_Akqe;
            if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) {
              bool = false;
            }
            localakqe.a(bool, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, parambeae);
            if (QLog.isColorLevel()) {
              QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes download all done uin: " + this.jdField_b_of_type_JavaLangString + "all cnt: " + this.c.get() + ", err cnt: " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
            }
          }
          return;
        }
        catch (Exception parambeae)
        {
          this.jdField_a_of_type_JavaIoFile.delete();
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("rscContent_CmShowRscDownloader", 2, "unZipFile file error resType->" + this.jdField_a_of_type_Int + " id->" + this.jdField_b_of_type_Int + " error->" + parambeae.getMessage());
          continue;
        }
        catch (OutOfMemoryError parambeae)
        {
          this.jdField_a_of_type_JavaIoFile.delete();
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("rscContent_CmShowRscDownloader", 2, "unZipFile file error resType->" + this.jdField_a_of_type_Int + " id->" + this.jdField_b_of_type_Int + " error->" + parambeae.getMessage());
          continue;
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
        QLog.d("rscContent_CmShowRscDownloader", 1, "download file error resType->" + this.jdField_a_of_type_Int + " id->" + this.jdField_b_of_type_Int + " task.getStatus()->" + parambeae.a());
      }
    } while (!QLog.isColorLevel());
    QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes download uin:" + this.jdField_b_of_type_JavaLangString + ", cb cnt: " + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", all cnt: " + this.c.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akqd
 * JD-Core Version:    0.7.0.1
 */