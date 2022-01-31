import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aklr
  extends bdvu
{
  aklr(aklq paramaklq, File paramFile, aklt paramaklt) {}
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch task.getStatus:" + parambdvv.a());
    }
    if (3 == parambdvv.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        String str = this.jdField_a_of_type_Aklt.e();
        parambdvv = this.jdField_a_of_type_Aklt.c();
        if (BspatchUtil.a(str, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), parambdvv))
        {
          try
          {
            str = bfhi.a(parambdvv);
            if (QLog.isColorLevel()) {
              QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadZipAndPatch onDone dstMd5:" + str + " result.mMd5:" + this.jdField_a_of_type_Aklt.d);
            }
            if (aklq.a(this.jdField_a_of_type_Aklt, str))
            {
              if (aklq.a(this.jdField_a_of_type_Aklt))
              {
                ndr.a(new File(parambdvv), this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
                if (QLog.isColorLevel()) {
                  QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " dstpath:" + parambdvv);
                }
              }
              for (;;)
              {
                aklq.a(this.jdField_a_of_type_Aklq, this.jdField_a_of_type_Aklt.jdField_e_of_type_Int, this.jdField_a_of_type_Aklt);
                return;
                boolean bool = bdcs.d(parambdvv, this.jdField_a_of_type_Aklt.b() + this.jdField_a_of_type_Aklt.jdField_e_of_type_JavaLangString);
                QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch no need unzip copy:" + bool);
              }
            }
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambdvv.getMessage());
          }
          catch (Exception parambdvv)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambdvv.getMessage());
            return;
            QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
            aklq.a(this.jdField_a_of_type_Aklq, this.jdField_a_of_type_Aklt);
            return;
          }
          catch (OutOfMemoryError parambdvv)
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
          aklq.a(this.jdField_a_of_type_Aklq, this.jdField_a_of_type_Aklt);
        }
      }
      else
      {
        aklq.a(this.jdField_a_of_type_Aklq, this.jdField_a_of_type_Aklt);
        QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch patchFile no exist path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambdvv.a());
      }
    }
    else {
      QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambdvv.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aklr
 * JD-Core Version:    0.7.0.1
 */