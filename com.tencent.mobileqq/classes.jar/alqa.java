import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.BspatchUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class alqa
  extends bgod
{
  alqa(alpz paramalpz, File paramFile, alqc paramalqc) {}
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch task.getStatus:" + parambgoe.a());
    }
    if (3 == parambgoe.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        String str = this.jdField_a_of_type_Alqc.e();
        parambgoe = this.jdField_a_of_type_Alqc.c();
        if (BspatchUtil.a(str, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), parambgoe))
        {
          try
          {
            str = MD5Utils.encodeFileHexStr(parambgoe);
            if (QLog.isColorLevel()) {
              QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadZipAndPatch onDone dstMd5:" + str + " result.mMd5:" + this.jdField_a_of_type_Alqc.d);
            }
            if (alpz.a(this.jdField_a_of_type_Alqc, str))
            {
              if (alpz.a(this.jdField_a_of_type_Alqc))
              {
                npo.a(new File(parambgoe), this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
                if (QLog.isColorLevel()) {
                  QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " dstpath:" + parambgoe);
                }
              }
              for (;;)
              {
                alpz.a(this.jdField_a_of_type_Alpz, this.jdField_a_of_type_Alqc.jdField_e_of_type_Int, this.jdField_a_of_type_Alqc);
                return;
                boolean bool = FileUtils.copyFile(parambgoe, this.jdField_a_of_type_Alqc.b() + this.jdField_a_of_type_Alqc.jdField_e_of_type_JavaLangString);
                QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch no need unzip copy:" + bool);
              }
            }
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambgoe.getMessage());
          }
          catch (Exception parambgoe)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambgoe.getMessage());
            return;
            QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
            alpz.a(this.jdField_a_of_type_Alpz, this.jdField_a_of_type_Alqc);
            return;
          }
          catch (OutOfMemoryError parambgoe)
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
          alpz.a(this.jdField_a_of_type_Alpz, this.jdField_a_of_type_Alqc);
        }
      }
      else
      {
        alpz.a(this.jdField_a_of_type_Alpz, this.jdField_a_of_type_Alqc);
        QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch patchFile no exist path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambgoe.a());
      }
    }
    else {
      QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambgoe.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alqa
 * JD-Core Version:    0.7.0.1
 */