import android.content.Context;
import java.io.File;
import java.util.ArrayList;

public abstract class acxh
{
  public static String a;
  public acxi a;
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
  
  public static acxh b(String paramString, acxi paramacxi)
  {
    String str = paramacxi.f;
    if (str.equals("Native"))
    {
      paramString = acxc.a(paramString, paramacxi);
      if (paramString == null) {
        return null;
      }
    }
    else
    {
      acwx.a("KingKongPatchInfo", "Unsupported patch type : " + str);
      return null;
    }
    if ((!paramString.c.equals(paramacxi.jdField_a_of_type_JavaLangString)) || (!paramString.d.equals(paramacxi.b)) || (!paramString.e.equals(paramacxi.f)) || (!paramString.e.equals("Native")))
    {
      acwx.a("KingKongPatchInfo", "Patch name, version or type mismatch : " + paramString.c + ", " + paramString.d + ", " + paramString.e);
      return null;
    }
    paramString.jdField_a_of_type_Acxi = paramacxi;
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
 * Qualified Name:     acxh
 * JD-Core Version:    0.7.0.1
 */