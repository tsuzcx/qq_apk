import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aiuh
  extends bbwf
{
  aiuh(aiug paramaiug, File paramFile, aiuj paramaiuj) {}
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch task.getStatus:" + parambbwg.a());
    }
    if (3 == parambbwg.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        String str = this.jdField_a_of_type_Aiuj.e();
        parambbwg = this.jdField_a_of_type_Aiuj.c();
        if (BspatchUtil.a(str, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), parambbwg))
        {
          try
          {
            str = bdhv.a(parambbwg);
            if (QLog.isColorLevel()) {
              QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadZipAndPatch onDone dstMd5:" + str + " result.mMd5:" + this.jdField_a_of_type_Aiuj.d);
            }
            if (aiug.a(this.jdField_a_of_type_Aiuj, str))
            {
              if (aiug.a(this.jdField_a_of_type_Aiuj))
              {
                nay.a(new File(parambbwg), this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
                if (QLog.isColorLevel()) {
                  QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " dstpath:" + parambbwg);
                }
              }
              for (;;)
              {
                aiug.a(this.jdField_a_of_type_Aiug, this.jdField_a_of_type_Aiuj.jdField_e_of_type_Int, this.jdField_a_of_type_Aiuj);
                return;
                boolean bool = bbdj.d(parambbwg, this.jdField_a_of_type_Aiuj.b() + this.jdField_a_of_type_Aiuj.jdField_e_of_type_JavaLangString);
                QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch no need unzip copy:" + bool);
              }
            }
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambbwg.getMessage());
          }
          catch (Exception parambbwg)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + parambbwg.getMessage());
            return;
            QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
            aiug.a(this.jdField_a_of_type_Aiug, this.jdField_a_of_type_Aiuj);
            return;
          }
          catch (OutOfMemoryError parambbwg)
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
          aiug.a(this.jdField_a_of_type_Aiug, this.jdField_a_of_type_Aiuj);
        }
      }
      else
      {
        aiug.a(this.jdField_a_of_type_Aiug, this.jdField_a_of_type_Aiuj);
        QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch patchFile no exist path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambbwg.a());
      }
    }
    else {
      QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + parambbwg.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiuh
 * JD-Core Version:    0.7.0.1
 */