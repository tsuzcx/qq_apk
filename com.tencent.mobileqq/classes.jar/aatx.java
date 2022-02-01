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

class aatx
  extends biht
{
  aatx(aatw paramaatw, aatn paramaatn, ArrayList paramArrayList, long paramLong) {}
  
  public void onDone(bihu parambihu)
  {
    if (parambihu.a == 0)
    {
      parambihu = this.jdField_a_of_type_Aatw.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (parambihu.hasNext()) {
        if (!((File)parambihu.next()).exists())
        {
          this.jdField_a_of_type_Aatw.jdField_a_of_type_Aauc.a(this.jdField_a_of_type_Aatw);
          return;
        }
      }
      try
      {
        parambihu = this.jdField_a_of_type_Aatn.b.iterator();
        int i = 1;
        while (parambihu.hasNext())
        {
          String str = (String)parambihu.next();
          File localFile = new File(this.jdField_a_of_type_Aatw.a() + File.separator + "v_" + i + ".mp4");
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
            zom.a(new File(str), localFile);
            i += 1;
          }
        }
        this.jdField_a_of_type_Aatw.b();
      }
      catch (IOException parambihu)
      {
        QLog.e(".troop.VideoCombineHelper", 1, parambihu, new Object[0]);
        this.jdField_a_of_type_Aatw.jdField_a_of_type_Aauc.a(this.jdField_a_of_type_Aatw);
        this.jdField_a_of_type_Aatn.b = this.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_a_of_type_Aatw.jdField_a_of_type_Aauc.b(this.jdField_a_of_type_Aatw);
        this.jdField_a_of_type_Aatw.jdField_a_of_type_Aaub = new aato(this.jdField_a_of_type_Aatw.jdField_a_of_type_Aatd, this.jdField_a_of_type_Aatw.jdField_a_of_type_Aauc, this.jdField_a_of_type_Aatw.c, this.jdField_a_of_type_Aatn.b, this.jdField_a_of_type_Aatn.d, this.jdField_a_of_type_Aatn.c);
        if (!VideoEnvironment.e((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
      }
      for (;;)
      {
        QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
        return;
        if (this.jdField_a_of_type_Aatn.a) {
          this.jdField_a_of_type_Aatw.jdField_a_of_type_Aauc.b(this.jdField_a_of_type_Aatw.jdField_a_of_type_Aaub);
        } else {
          this.jdField_a_of_type_Aatw.jdField_a_of_type_Aauc.a(this.jdField_a_of_type_Aatw.jdField_a_of_type_Aaub);
        }
      }
    }
    this.jdField_a_of_type_Aatw.d = ("donwload failed!code = " + parambihu.a + "errmsg = " + parambihu.b);
    this.jdField_a_of_type_Aatw.jdField_a_of_type_Aauc.a(this.jdField_a_of_type_Aatw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aatx
 * JD-Core Version:    0.7.0.1
 */