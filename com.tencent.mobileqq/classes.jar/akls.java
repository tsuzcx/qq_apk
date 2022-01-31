import com.tencent.qphone.base.util.QLog;
import java.io.File;

class akls
  extends bdvu
{
  akls(aklq paramaklq, File paramFile, aklt paramaklt) {}
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip task.getStatus:" + parambdvv.a());
    }
    if (3 == parambdvv.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists()) {
        try
        {
          parambdvv = bfhi.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadAllZip onDone dstMd5:" + parambdvv + " result.mMd5:" + this.jdField_a_of_type_Aklt.d);
          }
          if (aklq.a(this.jdField_a_of_type_Aklt, parambdvv))
          {
            if (aklq.a(this.jdField_a_of_type_Aklt))
            {
              ndr.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
              if (QLog.isColorLevel()) {
                QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
              }
            }
            for (;;)
            {
              aklq.a(this.jdField_a_of_type_Aklq, this.jdField_a_of_type_Aklt.jdField_e_of_type_Int, this.jdField_a_of_type_Aklt);
              return;
              boolean bool = bdcs.d(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_Aklt.b() + this.jdField_a_of_type_Aklt.jdField_e_of_type_JavaLangString);
              QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip no need unzip copy:" + bool);
            }
          }
          QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path- no exist:" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        }
        catch (Exception parambdvv)
        {
          aklq.a(this.jdField_a_of_type_Aklq, this.jdField_a_of_type_Aklt.jdField_e_of_type_Int);
          this.jdField_a_of_type_JavaIoFile.delete();
          QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambdvv.getMessage());
          return;
          QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
          aklq.a(this.jdField_a_of_type_Aklq, this.jdField_a_of_type_Aklt.jdField_e_of_type_Int);
          return;
        }
        catch (OutOfMemoryError parambdvv)
        {
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambdvv.getMessage());
          }
          this.jdField_a_of_type_JavaIoFile.delete();
          return;
        }
      }
      aklq.a(this.jdField_a_of_type_Aklq, this.jdField_a_of_type_Aklt.jdField_e_of_type_Int);
      return;
    }
    QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambdvv.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akls
 * JD-Core Version:    0.7.0.1
 */