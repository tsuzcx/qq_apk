import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Iterator;

public class acxb
{
  private static acxb jdField_a_of_type_Acxb;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public String a;
  private ArrayList<acxi> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private acxb()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private acxb(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("SHARED_PREFERENCE_KINGKONG_PATCH", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    paramContext = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("PATCH_LIST", "").split(";");
    int j = paramContext.length;
    while (i < j)
    {
      Object localObject = paramContext[i];
      if (!((String)localObject).equals(""))
      {
        localObject = new acxi(this.jdField_a_of_type_AndroidContentSharedPreferences, (String)localObject);
        acwx.a("KingKongMainConfig", "--> " + localObject);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
      i += 1;
    }
  }
  
  public static acxb a(Context paramContext)
  {
    if (jdField_a_of_type_Acxb != null) {
      return jdField_a_of_type_Acxb;
    }
    try
    {
      if (jdField_a_of_type_Acxb != null)
      {
        paramContext = jdField_a_of_type_Acxb;
        return paramContext;
      }
    }
    finally {}
    jdField_a_of_type_Acxb = new acxb(paramContext);
    paramContext = jdField_a_of_type_Acxb;
    return paramContext;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    acxi localacxi;
    for (String str = ""; localIterator.hasNext(); str = str + localacxi.jdField_a_of_type_JavaLangString + ";") {
      localacxi = (acxi)localIterator.next();
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("PATCH_LIST", str);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public acxi a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      acxi localacxi = (acxi)localIterator.next();
      if (localacxi.jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localacxi;
      }
    }
    return null;
  }
  
  public ArrayList<acxi> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(acxi paramacxi)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!((acxi)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramacxi.jdField_a_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if (i != -1) {
        this.jdField_a_of_type_JavaUtilArrayList.set(i, paramacxi);
      }
      for (;;)
      {
        paramacxi.b(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        return;
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramacxi);
        a();
      }
      i = -1;
    }
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      acxi localacxi = (acxi)localIterator.next();
      if (localacxi.jdField_a_of_type_JavaLangString.equals(paramString))
      {
        localacxi.a(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        this.jdField_a_of_type_JavaUtilArrayList.remove(localacxi);
      }
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acxb
 * JD-Core Version:    0.7.0.1
 */