import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aiho
  extends batl
{
  aiho(aihn paramaihn, File paramFile, aihq paramaihq) {}
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch task.getStatus:" + parambatm.a());
    }
    if (3 == parambatm.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        String str = this.jdField_a_of_type_Aihq.e();
        parambatm = this.jdField_a_of_type_Aihq.c();
        if (BspatchUtil.a(str, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), parambatm))
        {
          try
          {
            str = bcdu.a(parambatm);
            if (QLog.isColorLevel()) {
              QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadZipAndPatch onDone dstMd5:" + str + " result.mMd5:" + this.jdField_a_of_type_Aihq.d);
            }
            if (aihn.a(this.jdField_a_of_type_Aihq, str))
            {
              if (aihn.a(this.jdField_a_of_type_Aihq))
              {
                mpx.a(new File(parambatm), this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
                if (QLog.isColorLevel()) {
                  QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " dstpath:" + parambatm);
                }
              }
              for (;;)
              {
                aihn.a(this.jdField_a_of_type_Aihn, this.jdField_a_of_type_Aihq.jdField_e_of_type_Int, this.jdField_a_of_type_Aihq);
                return;
                boolean bool = bace.d(parambatm, this.jdField_a_of_type_Aihq.b() + this.jdField_a_of_type_Aihq.jdField_e_of_type_JavaLangString);
                QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch no need unzip copy:" + bool);
              }
            }
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambatm.getMessage());
          }
          catch (Exception parambatm)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambatm.getMessage());
            return;
            QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
            aihn.a(this.jdField_a_of_type_Aihn, this.jdField_a_of_type_Aihq);
            return;
          }
          catch (OutOfMemoryError parambatm)
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
          aihn.a(this.jdField_a_of_type_Aihn, this.jdField_a_of_type_Aihq);
        }
      }
      else
      {
        aihn.a(this.jdField_a_of_type_Aihn, this.jdField_a_of_type_Aihq);
        QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch patchFile no exist path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambatm.a());
      }
    }
    else {
      QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambatm.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiho
 * JD-Core Version:    0.7.0.1
 */