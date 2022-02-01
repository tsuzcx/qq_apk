import java.io.File;
import java.util.HashMap;

public abstract class aapy
{
  aapy jdField_a_of_type_Aapy;
  aapz jdField_a_of_type_Aapz;
  String c;
  String d;
  
  public aapy(aapa paramaapa, aapz paramaapz, String paramString)
  {
    this.jdField_a_of_type_Aapz = paramaapz;
    this.c = paramString;
  }
  
  public aapk a()
  {
    synchronized (this.b.jdField_a_of_type_JavaLangObject)
    {
      aapk localaapk = (aapk)this.b.jdField_a_of_type_JavaUtilHashMap.get(this.c);
      return localaapk;
    }
  }
  
  public File a()
  {
    int i = this.c.indexOf("_");
    Object localObject = this.c.substring(i + 1, this.c.length());
    localObject = new File(aapa.jdField_a_of_type_JavaLangString + File.separator + (String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return localObject;
  }
  
  public abstract void a();
  
  public File b()
  {
    File localFile = new File(aapa.jdField_a_of_type_JavaLangString + File.separator + "cache");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aapy != null) {
      this.jdField_a_of_type_Aapy.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapy
 * JD-Core Version:    0.7.0.1
 */