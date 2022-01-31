import com.tencent.qphone.base.util.QLog;
import java.io.File;

class akqh
  extends bead
{
  akqh(akqf paramakqf, File paramFile, akqi paramakqi) {}
  
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip task.getStatus:" + parambeae.a());
    }
    if (3 == parambeae.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists()) {
        try
        {
          parambeae = bflr.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadAllZip onDone dstMd5:" + parambeae + " result.mMd5:" + this.jdField_a_of_type_Akqi.d);
          }
          if (akqf.a(this.jdField_a_of_type_Akqi, parambeae))
          {
            if (akqf.a(this.jdField_a_of_type_Akqi))
            {
              ndr.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
              if (QLog.isColorLevel()) {
                QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
              }
            }
            for (;;)
            {
              akqf.a(this.jdField_a_of_type_Akqf, this.jdField_a_of_type_Akqi.jdField_e_of_type_Int, this.jdField_a_of_type_Akqi);
              return;
              boolean bool = bdhb.d(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_Akqi.b() + this.jdField_a_of_type_Akqi.jdField_e_of_type_JavaLangString);
              QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip no need unzip copy:" + bool);
            }
          }
          QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path- no exist:" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        }
        catch (Exception parambeae)
        {
          akqf.a(this.jdField_a_of_type_Akqf, this.jdField_a_of_type_Akqi.jdField_e_of_type_Int);
          this.jdField_a_of_type_JavaIoFile.delete();
          QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambeae.getMessage());
          return;
          QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
          akqf.a(this.jdField_a_of_type_Akqf, this.jdField_a_of_type_Akqi.jdField_e_of_type_Int);
          return;
        }
        catch (OutOfMemoryError parambeae)
        {
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambeae.getMessage());
          }
          this.jdField_a_of_type_JavaIoFile.delete();
          return;
        }
      }
      akqf.a(this.jdField_a_of_type_Akqf, this.jdField_a_of_type_Akqi.jdField_e_of_type_Int);
      return;
    }
    QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambeae.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akqh
 * JD-Core Version:    0.7.0.1
 */