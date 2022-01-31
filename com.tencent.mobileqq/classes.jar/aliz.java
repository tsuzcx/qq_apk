import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class aliz
  implements aliw
{
  aliz(aliy paramaliy, aljb paramaljb, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Aljb != null) {
      this.jdField_a_of_type_Aljb.a(aliy.a(this.jdField_a_of_type_Aliy, paramLong1, 0));
    }
  }
  
  public void a(boolean paramBoolean, alix paramalix)
  {
    QLog.i("AREngine_ARResourceManagerTools", 1, "onARResourceDownloadComplete result" + paramBoolean);
    if (this.jdField_a_of_type_Aljb != null) {
      this.jdField_a_of_type_Aljb.a(paramalix.jdField_a_of_type_Int, paramBoolean);
    }
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localalix = (alix)localIterator.next();
          if (!localalix.jdField_a_of_type_JavaLangString.equals(paramalix.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          if (paramalix.jdField_a_of_type_Boolean) {}
          try
          {
            System.currentTimeMillis();
            if (paramalix.jdField_a_of_type_Int == 6)
            {
              new File(paramalix.c);
              aljc.a(paramalix.c, alis.b());
            }
            for (;;)
            {
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  ");
              this.b.remove(localalix);
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  remove " + localalix.jdField_a_of_type_JavaLangString);
              break;
              if (paramalix.jdField_a_of_type_Int != 7) {
                break label268;
              }
              aljc.a(paramalix.c, alis.a(paramalix.b));
            }
            return;
          }
          catch (Exception localException)
          {
            new File(paramalix.c).delete();
            QLog.i("AREngine_ARResourceManagerTools", 1, "Download end. uncompressZip error. url = ");
            if (this.jdField_a_of_type_Aljb != null) {
              this.jdField_a_of_type_Aljb.a(false);
            }
            this.jdField_a_of_type_Aliy.a();
            QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerAllDownloadComplete  ");
          }
        }
      }
      label268:
      while (this.b.size() != 0) {
        for (;;)
        {
          alix localalix;
          File localFile = new File(paramalix.c);
          aljc.a(paramalix.c, localFile.getParentFile().getAbsolutePath() + File.separator + paramalix.b + File.separator);
        }
      }
      if (this.jdField_a_of_type_Aljb != null) {
        this.jdField_a_of_type_Aljb.a(true);
      }
      this.jdField_a_of_type_Aliy.a();
      return;
    }
    if (this.jdField_a_of_type_Aljb != null) {
      this.jdField_a_of_type_Aljb.a(false);
    }
    this.jdField_a_of_type_Aliy.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aliz
 * JD-Core Version:    0.7.0.1
 */