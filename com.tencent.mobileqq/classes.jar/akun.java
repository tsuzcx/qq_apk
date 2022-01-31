import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class akun
  implements akuk
{
  akun(akum paramakum, akup paramakup, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Akup != null) {
      this.jdField_a_of_type_Akup.a(akum.a(this.jdField_a_of_type_Akum, paramLong1, 0));
    }
  }
  
  public void a(boolean paramBoolean, akul paramakul)
  {
    QLog.i("AREngine_ARResourceManagerTools", 1, "onARResourceDownloadComplete result" + paramBoolean);
    if (this.jdField_a_of_type_Akup != null) {
      this.jdField_a_of_type_Akup.a(paramakul.jdField_a_of_type_Int, paramBoolean);
    }
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localakul = (akul)localIterator.next();
          if (!localakul.jdField_a_of_type_JavaLangString.equals(paramakul.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          if (paramakul.jdField_a_of_type_Boolean) {}
          try
          {
            System.currentTimeMillis();
            if (paramakul.jdField_a_of_type_Int == 6)
            {
              new File(paramakul.c);
              akuq.a(paramakul.c, akug.b());
            }
            for (;;)
            {
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  ");
              this.b.remove(localakul);
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  remove " + localakul.jdField_a_of_type_JavaLangString);
              break;
              if (paramakul.jdField_a_of_type_Int != 7) {
                break label268;
              }
              akuq.a(paramakul.c, akug.a(paramakul.b));
            }
            return;
          }
          catch (Exception localException)
          {
            new File(paramakul.c).delete();
            QLog.i("AREngine_ARResourceManagerTools", 1, "Download end. uncompressZip error. url = ");
            if (this.jdField_a_of_type_Akup != null) {
              this.jdField_a_of_type_Akup.a(false);
            }
            this.jdField_a_of_type_Akum.a();
            QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerAllDownloadComplete  ");
          }
        }
      }
      label268:
      while (this.b.size() != 0) {
        for (;;)
        {
          akul localakul;
          File localFile = new File(paramakul.c);
          akuq.a(paramakul.c, localFile.getParentFile().getAbsolutePath() + File.separator + paramakul.b + File.separator);
        }
      }
      if (this.jdField_a_of_type_Akup != null) {
        this.jdField_a_of_type_Akup.a(true);
      }
      this.jdField_a_of_type_Akum.a();
      return;
    }
    if (this.jdField_a_of_type_Akup != null) {
      this.jdField_a_of_type_Akup.a(false);
    }
    this.jdField_a_of_type_Akum.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akun
 * JD-Core Version:    0.7.0.1
 */