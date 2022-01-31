import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aiui
  extends bbwf
{
  aiui(aiug paramaiug, File paramFile, aiuj paramaiuj) {}
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip task.getStatus:" + parambbwg.a());
    }
    if (3 == parambbwg.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists()) {
        try
        {
          parambbwg = bdhv.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadAllZip onDone dstMd5:" + parambbwg + " result.mMd5:" + this.jdField_a_of_type_Aiuj.d);
          }
          if (aiug.a(this.jdField_a_of_type_Aiuj, parambbwg))
          {
            if (aiug.a(this.jdField_a_of_type_Aiuj))
            {
              nay.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
              if (QLog.isColorLevel()) {
                QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
              }
            }
            for (;;)
            {
              aiug.a(this.jdField_a_of_type_Aiug, this.jdField_a_of_type_Aiuj.jdField_e_of_type_Int, this.jdField_a_of_type_Aiuj);
              return;
              boolean bool = bbdj.d(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_Aiuj.b() + this.jdField_a_of_type_Aiuj.jdField_e_of_type_JavaLangString);
              QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip no need unzip copy:" + bool);
            }
          }
          QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path- no exist:" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        }
        catch (Exception parambbwg)
        {
          aiug.a(this.jdField_a_of_type_Aiug, this.jdField_a_of_type_Aiuj.jdField_e_of_type_Int);
          this.jdField_a_of_type_JavaIoFile.delete();
          QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambbwg.getMessage());
          return;
          QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
          aiug.a(this.jdField_a_of_type_Aiug, this.jdField_a_of_type_Aiuj.jdField_e_of_type_Int);
          return;
        }
        catch (OutOfMemoryError parambbwg)
        {
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambbwg.getMessage());
          }
          this.jdField_a_of_type_JavaIoFile.delete();
          return;
        }
      }
      aiug.a(this.jdField_a_of_type_Aiug, this.jdField_a_of_type_Aiuj.jdField_e_of_type_Int);
      return;
    }
    QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambbwg.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiui
 * JD-Core Version:    0.7.0.1
 */