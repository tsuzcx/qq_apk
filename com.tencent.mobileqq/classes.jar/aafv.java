import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;

class aafv
  extends bhyn
{
  aafv(aafu paramaafu, aafl paramaafl, ArrayList paramArrayList, long paramLong) {}
  
  public void onDone(bhyo parambhyo)
  {
    if (parambhyo.a == 0)
    {
      parambhyo = this.jdField_a_of_type_Aafu.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (parambhyo.hasNext()) {
        if (!((File)parambhyo.next()).exists())
        {
          this.jdField_a_of_type_Aafu.jdField_a_of_type_Aaga.a(this.jdField_a_of_type_Aafu);
          return;
        }
      }
      try
      {
        parambhyo = this.jdField_a_of_type_Aafl.b.iterator();
        int i = 1;
        while (parambhyo.hasNext())
        {
          String str = (String)parambhyo.next();
          File localFile = new File(this.jdField_a_of_type_Aafu.a() + File.separator + "v_" + i + ".mp4");
          this.jdField_a_of_type_JavaUtilArrayList.add(localFile.getAbsolutePath());
          if (localFile.exists())
          {
            i += 1;
          }
          else
          {
            if (!localFile.exists()) {
              localFile.createNewFile();
            }
            zeb.a(new File(str), localFile);
            i += 1;
          }
        }
        this.jdField_a_of_type_Aafu.b();
      }
      catch (IOException parambhyo)
      {
        QLog.e(".troop.VideoCombineHelper", 1, parambhyo, new Object[0]);
        this.jdField_a_of_type_Aafu.jdField_a_of_type_Aaga.a(this.jdField_a_of_type_Aafu);
        this.jdField_a_of_type_Aafl.b = this.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_a_of_type_Aafu.jdField_a_of_type_Aaga.b(this.jdField_a_of_type_Aafu);
        this.jdField_a_of_type_Aafu.jdField_a_of_type_Aafz = new aafm(this.jdField_a_of_type_Aafu.jdField_a_of_type_Aafb, this.jdField_a_of_type_Aafu.jdField_a_of_type_Aaga, this.jdField_a_of_type_Aafu.c, this.jdField_a_of_type_Aafl.b, this.jdField_a_of_type_Aafl.d, this.jdField_a_of_type_Aafl.c);
        if (!VideoEnvironment.checkAVCodecLoadIsOK((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
      }
      for (;;)
      {
        QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
        return;
        if (this.jdField_a_of_type_Aafl.a) {
          this.jdField_a_of_type_Aafu.jdField_a_of_type_Aaga.b(this.jdField_a_of_type_Aafu.jdField_a_of_type_Aafz);
        } else {
          this.jdField_a_of_type_Aafu.jdField_a_of_type_Aaga.a(this.jdField_a_of_type_Aafu.jdField_a_of_type_Aafz);
        }
      }
    }
    this.jdField_a_of_type_Aafu.d = ("donwload failed!code = " + parambhyo.a + "errmsg = " + parambhyo.b);
    this.jdField_a_of_type_Aafu.jdField_a_of_type_Aaga.a(this.jdField_a_of_type_Aafu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aafv
 * JD-Core Version:    0.7.0.1
 */