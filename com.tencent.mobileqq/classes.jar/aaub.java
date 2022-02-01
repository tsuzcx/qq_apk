import java.io.File;
import java.util.HashMap;

public abstract class aaub
{
  aaub jdField_a_of_type_Aaub;
  aauc jdField_a_of_type_Aauc;
  String c;
  String d;
  
  public aaub(aatd paramaatd, aauc paramaauc, String paramString)
  {
    this.jdField_a_of_type_Aauc = paramaauc;
    this.c = paramString;
  }
  
  public aatn a()
  {
    synchronized (this.b.jdField_a_of_type_JavaLangObject)
    {
      aatn localaatn = (aatn)this.b.jdField_a_of_type_JavaUtilHashMap.get(this.c);
      return localaatn;
    }
  }
  
  public File a()
  {
    int i = this.c.indexOf("_");
    Object localObject = this.c.substring(i + 1, this.c.length());
    localObject = new File(aatd.jdField_a_of_type_JavaLangString + File.separator + (String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return localObject;
  }
  
  public abstract void a();
  
  public File b()
  {
    File localFile = new File(aatd.jdField_a_of_type_JavaLangString + File.separator + "cache");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aaub != null) {
      this.jdField_a_of_type_Aaub.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaub
 * JD-Core Version:    0.7.0.1
 */