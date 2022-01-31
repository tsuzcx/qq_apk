import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class akqg
  extends bead
{
  akqg(akqf paramakqf, File paramFile, akqi paramakqi) {}
  
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch task.getStatus:" + parambeae.a());
    }
    if (3 == parambeae.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        String str = this.jdField_a_of_type_Akqi.e();
        parambeae = this.jdField_a_of_type_Akqi.c();
        if (BspatchUtil.a(str, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), parambeae))
        {
          try
          {
            str = bflr.a(parambeae);
            if (QLog.isColorLevel()) {
              QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadZipAndPatch onDone dstMd5:" + str + " result.mMd5:" + this.jdField_a_of_type_Akqi.d);
            }
            if (akqf.a(this.jdField_a_of_type_Akqi, str))
            {
              if (akqf.a(this.jdField_a_of_type_Akqi))
              {
                ndr.a(new File(parambeae), this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
                if (QLog.isColorLevel()) {
                  QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " dstpath:" + parambeae);
                }
              }
              for (;;)
              {
                akqf.a(this.jdField_a_of_type_Akqf, this.jdField_a_of_type_Akqi.jdField_e_of_type_Int, this.jdField_a_of_type_Akqi);
                return;
                boolean bool = bdhb.d(parambeae, this.jdField_a_of_type_Akqi.b() + this.jdField_a_of_type_Akqi.jdField_e_of_type_JavaLangString);
                QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch no need unzip copy:" + bool);
              }
            }
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambeae.getMessage());
          }
          catch (Exception parambeae)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambeae.getMessage());
            return;
            QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
            akqf.a(this.jdField_a_of_type_Akqf, this.jdField_a_of_type_Akqi);
            return;
          }
          catch (OutOfMemoryError parambeae)
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
          akqf.a(this.jdField_a_of_type_Akqf, this.jdField_a_of_type_Akqi);
        }
      }
      else
      {
        akqf.a(this.jdField_a_of_type_Akqf, this.jdField_a_of_type_Akqi);
        QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch patchFile no exist path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambeae.a());
      }
    }
    else {
      QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambeae.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akqg
 * JD-Core Version:    0.7.0.1
 */