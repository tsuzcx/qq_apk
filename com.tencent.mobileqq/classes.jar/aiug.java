import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aiug
  extends bbwt
{
  aiug(aiue paramaiue, File paramFile, aiuh paramaiuh) {}
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip task.getStatus:" + parambbwu.a());
    }
    if (3 == parambbwu.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists()) {
        try
        {
          parambbwu = bdik.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadAllZip onDone dstMd5:" + parambbwu + " result.mMd5:" + this.jdField_a_of_type_Aiuh.d);
          }
          if (aiue.a(this.jdField_a_of_type_Aiuh, parambbwu))
          {
            if (aiue.a(this.jdField_a_of_type_Aiuh))
            {
              nav.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
              if (QLog.isColorLevel()) {
                QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
              }
            }
            for (;;)
            {
              aiue.a(this.jdField_a_of_type_Aiue, this.jdField_a_of_type_Aiuh.jdField_e_of_type_Int, this.jdField_a_of_type_Aiuh);
              return;
              boolean bool = bbdx.d(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_Aiuh.b() + this.jdField_a_of_type_Aiuh.jdField_e_of_type_JavaLangString);
              QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip no need unzip copy:" + bool);
            }
          }
          QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path- no exist:" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        }
        catch (Exception parambbwu)
        {
          aiue.a(this.jdField_a_of_type_Aiue, this.jdField_a_of_type_Aiuh.jdField_e_of_type_Int);
          this.jdField_a_of_type_JavaIoFile.delete();
          QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambbwu.getMessage());
          return;
          QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
          aiue.a(this.jdField_a_of_type_Aiue, this.jdField_a_of_type_Aiuh.jdField_e_of_type_Int);
          return;
        }
        catch (OutOfMemoryError parambbwu)
        {
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambbwu.getMessage());
          }
          this.jdField_a_of_type_JavaIoFile.delete();
          return;
        }
      }
      aiue.a(this.jdField_a_of_type_Aiue, this.jdField_a_of_type_Aiuh.jdField_e_of_type_Int);
      return;
    }
    QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambbwu.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiug
 * JD-Core Version:    0.7.0.1
 */