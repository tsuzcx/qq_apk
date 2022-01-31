import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

final class ajhx
  extends bbwt
{
  ajhx(File paramFile, airx paramairx, int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, ajic paramajic, String paramString, int paramInt3, int[] paramArrayOfInt, int paramInt4) {}
  
  public void onDone(bbwu parambbwu)
  {
    boolean bool = true;
    super.onDone(parambbwu);
    if (3 == parambbwu.a()) {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    }
    for (;;)
    {
      try
      {
        nav.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
        ajhu.a(this.jdField_a_of_type_Airx, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
        if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) {
          break label421;
        }
        if (this.jdField_a_of_type_Ajic != null)
        {
          parambbwu = this.jdField_a_of_type_Ajic;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) {
            bool = false;
          }
          parambbwu.onDownLoadFinish(bool, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_ArrayOfInt, this.d);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloResDownloader", 2, "downloadApolloRes download all done uin: " + this.jdField_a_of_type_JavaLangString + "all cnt: " + this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", err cnt: " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          }
        }
        this.jdField_a_of_type_JavaIoFile.delete();
        return;
      }
      catch (Exception parambbwu)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + this.jdField_a_of_type_Int + " id->" + this.jdField_b_of_type_Int + " error->" + parambbwu.getMessage());
        continue;
      }
      catch (OutOfMemoryError parambbwu)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + this.jdField_a_of_type_Int + " id->" + this.jdField_b_of_type_Int + " error->" + parambbwu.getMessage());
        continue;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
      QLog.d("ApolloResDownloader", 1, "download file error resType->" + this.jdField_a_of_type_Int + " id->" + this.jdField_b_of_type_Int + " task.getStatus()->" + parambbwu.a());
      continue;
      label421:
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloRes download uin:" + this.jdField_a_of_type_JavaLangString + ", cb cnt: " + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", all cnt: " + this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajhx
 * JD-Core Version:    0.7.0.1
 */