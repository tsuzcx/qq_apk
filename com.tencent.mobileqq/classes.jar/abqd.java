import android.content.Context;
import java.io.File;
import java.util.ArrayList;

public abstract class abqd
{
  public static String a;
  public abqe a;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = File.separator;
  }
  
  public static ArrayList<String> a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString2.equals("Native"))
    {
      localArrayList.add(paramString1 + ".cfg");
      localArrayList.add("lib" + paramString1 + ".so");
      localArrayList.add(paramString1 + ".subpatch");
      return localArrayList;
    }
    if (paramString2.equals("DVM"))
    {
      localArrayList.add(paramString1 + ".cfg");
      localArrayList.add(paramString1 + ".jar");
      return localArrayList;
    }
    return null;
  }
  
  public static abqd b(String paramString, abqe paramabqe)
  {
    String str = paramabqe.f;
    if (str.equals("Native"))
    {
      paramString = abpy.a(paramString, paramabqe);
      if (paramString == null) {
        return null;
      }
    }
    else
    {
      abpt.a("KingKongPatchInfo", "Unsupported patch type : " + str);
      return null;
    }
    if ((!paramString.c.equals(paramabqe.jdField_a_of_type_JavaLangString)) || (!paramString.d.equals(paramabqe.b)) || (!paramString.e.equals(paramabqe.f)) || (!paramString.e.equals("Native")))
    {
      abpt.a("KingKongPatchInfo", "Patch name, version or type mismatch : " + paramString.c + ", " + paramString.d + ", " + paramString.e);
      return null;
    }
    paramString.jdField_a_of_type_Abqe = paramabqe;
    return paramString;
  }
  
  public static ArrayList<String> b(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString2.equals("Native"))
    {
      localArrayList.add(paramString1 + ".cfg");
      localArrayList.add("lib" + paramString1 + ".so");
      localArrayList.add(paramString1 + ".subpatch");
    }
    while (!paramString2.equals("DVM")) {
      return localArrayList;
    }
    localArrayList.add(paramString1 + ".cfg");
    localArrayList.add(paramString1 + ".jar");
    localArrayList.add(paramString1 + ".dex");
    return localArrayList;
  }
  
  public abstract int a(Context paramContext);
  
  public String a()
  {
    return this.b + jdField_a_of_type_JavaLangString + this.c + ".cfg";
  }
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abqd
 * JD-Core Version:    0.7.0.1
 */