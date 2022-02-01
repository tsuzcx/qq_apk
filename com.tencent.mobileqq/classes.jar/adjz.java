import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Iterator;

public class adjz
{
  private static adjz jdField_a_of_type_Adjz;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public String a;
  private ArrayList<adkg> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private adjz()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private adjz(Context paramContext)
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
        localObject = new adkg(this.jdField_a_of_type_AndroidContentSharedPreferences, (String)localObject);
        adjv.a("KingKongMainConfig", "--> " + localObject);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
      i += 1;
    }
  }
  
  public static adjz a(Context paramContext)
  {
    if (jdField_a_of_type_Adjz != null) {
      return jdField_a_of_type_Adjz;
    }
    try
    {
      if (jdField_a_of_type_Adjz != null)
      {
        paramContext = jdField_a_of_type_Adjz;
        return paramContext;
      }
    }
    finally {}
    jdField_a_of_type_Adjz = new adjz(paramContext);
    paramContext = jdField_a_of_type_Adjz;
    return paramContext;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    adkg localadkg;
    for (String str = ""; localIterator.hasNext(); str = str + localadkg.jdField_a_of_type_JavaLangString + ";") {
      localadkg = (adkg)localIterator.next();
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("PATCH_LIST", str);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public adkg a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      adkg localadkg = (adkg)localIterator.next();
      if (localadkg.jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localadkg;
      }
    }
    return null;
  }
  
  public ArrayList<adkg> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(adkg paramadkg)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!((adkg)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramadkg.jdField_a_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if (i != -1) {
        this.jdField_a_of_type_JavaUtilArrayList.set(i, paramadkg);
      }
      for (;;)
      {
        paramadkg.b(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        return;
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramadkg);
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
      adkg localadkg = (adkg)localIterator.next();
      if (localadkg.jdField_a_of_type_JavaLangString.equals(paramString))
      {
        localadkg.a(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        this.jdField_a_of_type_JavaUtilArrayList.remove(localadkg);
      }
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adjz
 * JD-Core Version:    0.7.0.1
 */