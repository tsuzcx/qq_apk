import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class aliy
  implements aliv
{
  aliy(alix paramalix, alja paramalja, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Alja != null) {
      this.jdField_a_of_type_Alja.a(alix.a(this.jdField_a_of_type_Alix, paramLong1, 0));
    }
  }
  
  public void a(boolean paramBoolean, aliw paramaliw)
  {
    QLog.i("AREngine_ARResourceManagerTools", 1, "onARResourceDownloadComplete result" + paramBoolean);
    if (this.jdField_a_of_type_Alja != null) {
      this.jdField_a_of_type_Alja.a(paramaliw.jdField_a_of_type_Int, paramBoolean);
    }
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localaliw = (aliw)localIterator.next();
          if (!localaliw.jdField_a_of_type_JavaLangString.equals(paramaliw.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          if (paramaliw.jdField_a_of_type_Boolean) {}
          try
          {
            System.currentTimeMillis();
            if (paramaliw.jdField_a_of_type_Int == 6)
            {
              new File(paramaliw.c);
              aljb.a(paramaliw.c, alir.b());
            }
            for (;;)
            {
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  ");
              this.b.remove(localaliw);
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  remove " + localaliw.jdField_a_of_type_JavaLangString);
              break;
              if (paramaliw.jdField_a_of_type_Int != 7) {
                break label268;
              }
              aljb.a(paramaliw.c, alir.a(paramaliw.b));
            }
            return;
          }
          catch (Exception localException)
          {
            new File(paramaliw.c).delete();
            QLog.i("AREngine_ARResourceManagerTools", 1, "Download end. uncompressZip error. url = ");
            if (this.jdField_a_of_type_Alja != null) {
              this.jdField_a_of_type_Alja.a(false);
            }
            this.jdField_a_of_type_Alix.a();
            QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerAllDownloadComplete  ");
          }
        }
      }
      label268:
      while (this.b.size() != 0) {
        for (;;)
        {
          aliw localaliw;
          File localFile = new File(paramaliw.c);
          aljb.a(paramaliw.c, localFile.getParentFile().getAbsolutePath() + File.separator + paramaliw.b + File.separator);
        }
      }
      if (this.jdField_a_of_type_Alja != null) {
        this.jdField_a_of_type_Alja.a(true);
      }
      this.jdField_a_of_type_Alix.a();
      return;
    }
    if (this.jdField_a_of_type_Alja != null) {
      this.jdField_a_of_type_Alja.a(false);
    }
    this.jdField_a_of_type_Alix.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aliy
 * JD-Core Version:    0.7.0.1
 */