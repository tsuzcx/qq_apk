import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aihp
  extends batl
{
  aihp(aihn paramaihn, File paramFile, aihq paramaihq) {}
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip task.getStatus:" + parambatm.a());
    }
    if (3 == parambatm.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists()) {
        try
        {
          parambatm = bcdu.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadAllZip onDone dstMd5:" + parambatm + " result.mMd5:" + this.jdField_a_of_type_Aihq.d);
          }
          if (aihn.a(this.jdField_a_of_type_Aihq, parambatm))
          {
            if (aihn.a(this.jdField_a_of_type_Aihq))
            {
              mpx.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
              if (QLog.isColorLevel()) {
                QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
              }
            }
            for (;;)
            {
              aihn.a(this.jdField_a_of_type_Aihn, this.jdField_a_of_type_Aihq.jdField_e_of_type_Int, this.jdField_a_of_type_Aihq);
              return;
              boolean bool = bace.d(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_Aihq.b() + this.jdField_a_of_type_Aihq.jdField_e_of_type_JavaLangString);
              QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip no need unzip copy:" + bool);
            }
          }
          QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path- no exist:" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        }
        catch (Exception parambatm)
        {
          aihn.a(this.jdField_a_of_type_Aihn, this.jdField_a_of_type_Aihq.jdField_e_of_type_Int);
          this.jdField_a_of_type_JavaIoFile.delete();
          QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambatm.getMessage());
          return;
          QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
          aihn.a(this.jdField_a_of_type_Aihn, this.jdField_a_of_type_Aihq.jdField_e_of_type_Int);
          return;
        }
        catch (OutOfMemoryError parambatm)
        {
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambatm.getMessage());
          }
          this.jdField_a_of_type_JavaIoFile.delete();
          return;
        }
      }
      aihn.a(this.jdField_a_of_type_Aihn, this.jdField_a_of_type_Aihq.jdField_e_of_type_Int);
      return;
    }
    QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambatm.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aihp
 * JD-Core Version:    0.7.0.1
 */