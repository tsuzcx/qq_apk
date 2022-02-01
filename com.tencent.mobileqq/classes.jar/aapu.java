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

class aapu
  extends bhhe
{
  aapu(aapt paramaapt, aapk paramaapk, ArrayList paramArrayList, long paramLong) {}
  
  public void onDone(bhhf parambhhf)
  {
    if (parambhhf.a == 0)
    {
      parambhhf = this.jdField_a_of_type_Aapt.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (parambhhf.hasNext()) {
        if (!((File)parambhhf.next()).exists())
        {
          this.jdField_a_of_type_Aapt.jdField_a_of_type_Aapz.a(this.jdField_a_of_type_Aapt);
          return;
        }
      }
      try
      {
        parambhhf = this.jdField_a_of_type_Aapk.b.iterator();
        int i = 1;
        while (parambhhf.hasNext())
        {
          String str = (String)parambhhf.next();
          File localFile = new File(this.jdField_a_of_type_Aapt.a() + File.separator + "v_" + i + ".mp4");
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
            zkr.a(new File(str), localFile);
            i += 1;
          }
        }
        this.jdField_a_of_type_Aapt.b();
      }
      catch (IOException parambhhf)
      {
        QLog.e(".troop.VideoCombineHelper", 1, parambhhf, new Object[0]);
        this.jdField_a_of_type_Aapt.jdField_a_of_type_Aapz.a(this.jdField_a_of_type_Aapt);
        this.jdField_a_of_type_Aapk.b = this.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_a_of_type_Aapt.jdField_a_of_type_Aapz.b(this.jdField_a_of_type_Aapt);
        this.jdField_a_of_type_Aapt.jdField_a_of_type_Aapy = new aapl(this.jdField_a_of_type_Aapt.jdField_a_of_type_Aapa, this.jdField_a_of_type_Aapt.jdField_a_of_type_Aapz, this.jdField_a_of_type_Aapt.c, this.jdField_a_of_type_Aapk.b, this.jdField_a_of_type_Aapk.d, this.jdField_a_of_type_Aapk.c);
        if (!VideoEnvironment.e((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
      }
      for (;;)
      {
        QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
        return;
        if (this.jdField_a_of_type_Aapk.a) {
          this.jdField_a_of_type_Aapt.jdField_a_of_type_Aapz.b(this.jdField_a_of_type_Aapt.jdField_a_of_type_Aapy);
        } else {
          this.jdField_a_of_type_Aapt.jdField_a_of_type_Aapz.a(this.jdField_a_of_type_Aapt.jdField_a_of_type_Aapy);
        }
      }
    }
    this.jdField_a_of_type_Aapt.d = ("donwload failed!code = " + parambhhf.a + "errmsg = " + parambhhf.b);
    this.jdField_a_of_type_Aapt.jdField_a_of_type_Aapz.a(this.jdField_a_of_type_Aapt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapu
 * JD-Core Version:    0.7.0.1
 */