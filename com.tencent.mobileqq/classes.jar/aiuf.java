import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aiuf
  extends bbwt
{
  aiuf(aiue paramaiue, File paramFile, aiuh paramaiuh) {}
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch task.getStatus:" + parambbwu.a());
    }
    if (3 == parambbwu.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        String str = this.jdField_a_of_type_Aiuh.e();
        parambbwu = this.jdField_a_of_type_Aiuh.c();
        if (BspatchUtil.a(str, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), parambbwu))
        {
          try
          {
            str = bdik.a(parambbwu);
            if (QLog.isColorLevel()) {
              QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadZipAndPatch onDone dstMd5:" + str + " result.mMd5:" + this.jdField_a_of_type_Aiuh.d);
            }
            if (aiue.a(this.jdField_a_of_type_Aiuh, str))
            {
              if (aiue.a(this.jdField_a_of_type_Aiuh))
              {
                nav.a(new File(parambbwu), this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
                if (QLog.isColorLevel()) {
                  QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " dstpath:" + parambbwu);
                }
              }
              for (;;)
              {
                aiue.a(this.jdField_a_of_type_Aiue, this.jdField_a_of_type_Aiuh.jdField_e_of_type_Int, this.jdField_a_of_type_Aiuh);
                return;
                boolean bool = bbdx.d(parambbwu, this.jdField_a_of_type_Aiuh.b() + this.jdField_a_of_type_Aiuh.jdField_e_of_type_JavaLangString);
                QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch no need unzip copy:" + bool);
              }
            }
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambbwu.getMessage());
          }
          catch (Exception parambbwu)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambbwu.getMessage());
            return;
            QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
            aiue.a(this.jdField_a_of_type_Aiue, this.jdField_a_of_type_Aiuh);
            return;
          }
          catch (OutOfMemoryError parambbwu)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (!QLog.isColorLevel()) {
              return;
            }
          }
        }
        else
        {
          QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch patchFile error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
          aiue.a(this.jdField_a_of_type_Aiue, this.jdField_a_of_type_Aiuh);
        }
      }
      else
      {
        aiue.a(this.jdField_a_of_type_Aiue, this.jdField_a_of_type_Aiuh);
        QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch patchFile no exist path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambbwu.a());
      }
    }
    else {
      QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambbwu.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiuf
 * JD-Core Version:    0.7.0.1
 */