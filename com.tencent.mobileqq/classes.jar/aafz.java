import java.io.File;
import java.util.HashMap;

public abstract class aafz
{
  aafz jdField_a_of_type_Aafz;
  aaga jdField_a_of_type_Aaga;
  String c;
  String d;
  
  public aafz(aafb paramaafb, aaga paramaaga, String paramString)
  {
    this.jdField_a_of_type_Aaga = paramaaga;
    this.c = paramString;
  }
  
  public aafl a()
  {
    synchronized (this.b.jdField_a_of_type_JavaLangObject)
    {
      aafl localaafl = (aafl)this.b.jdField_a_of_type_JavaUtilHashMap.get(this.c);
      return localaafl;
    }
  }
  
  public File a()
  {
    int i = this.c.indexOf("_");
    Object localObject = this.c.substring(i + 1, this.c.length());
    localObject = new File(aafb.jdField_a_of_type_JavaLangString + File.separator + (String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return localObject;
  }
  
  public abstract void a();
  
  public File b()
  {
    File localFile = new File(aafb.jdField_a_of_type_JavaLangString + File.separator + "cache");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aafz != null) {
      this.jdField_a_of_type_Aafz.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aafz
 * JD-Core Version:    0.7.0.1
 */