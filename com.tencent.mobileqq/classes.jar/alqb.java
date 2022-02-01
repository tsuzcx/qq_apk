import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class alqb
  extends bgod
{
  alqb(alpz paramalpz, File paramFile, alqc paramalqc) {}
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip task.getStatus:" + parambgoe.a());
    }
    if (3 == parambgoe.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists()) {
        try
        {
          parambgoe = MD5Utils.encodeFileHexStr(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadAllZip onDone dstMd5:" + parambgoe + " result.mMd5:" + this.jdField_a_of_type_Alqc.d);
          }
          if (alpz.a(this.jdField_a_of_type_Alqc, parambgoe))
          {
            if (alpz.a(this.jdField_a_of_type_Alqc))
            {
              npo.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
              if (QLog.isColorLevel()) {
                QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
              }
            }
            for (;;)
            {
              alpz.a(this.jdField_a_of_type_Alpz, this.jdField_a_of_type_Alqc.jdField_e_of_type_Int, this.jdField_a_of_type_Alqc);
              return;
              boolean bool = FileUtils.copyFile(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_Alqc.b() + this.jdField_a_of_type_Alqc.jdField_e_of_type_JavaLangString);
              QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip no need unzip copy:" + bool);
            }
          }
          QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path- no exist:" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        }
        catch (Exception parambgoe)
        {
          alpz.a(this.jdField_a_of_type_Alpz, this.jdField_a_of_type_Alqc.jdField_e_of_type_Int);
          this.jdField_a_of_type_JavaIoFile.delete();
          QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambgoe.getMessage());
          return;
          QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
          alpz.a(this.jdField_a_of_type_Alpz, this.jdField_a_of_type_Alqc.jdField_e_of_type_Int);
          return;
        }
        catch (OutOfMemoryError parambgoe)
        {
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambgoe.getMessage());
          }
          this.jdField_a_of_type_JavaIoFile.delete();
          return;
        }
      }
      alpz.a(this.jdField_a_of_type_Alpz, this.jdField_a_of_type_Alqc.jdField_e_of_type_Int);
      return;
    }
    QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambgoe.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alqb
 * JD-Core Version:    0.7.0.1
 */