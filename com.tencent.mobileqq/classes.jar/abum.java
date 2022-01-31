import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Iterator;

public class abum
{
  private static abum jdField_a_of_type_Abum;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public String a;
  private ArrayList<abut> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private abum()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private abum(Context paramContext)
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
        localObject = new abut(this.jdField_a_of_type_AndroidContentSharedPreferences, (String)localObject);
        abui.a("KingKongMainConfig", "--> " + localObject);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
      i += 1;
    }
  }
  
  public static abum a(Context paramContext)
  {
    if (jdField_a_of_type_Abum != null) {
      return jdField_a_of_type_Abum;
    }
    try
    {
      if (jdField_a_of_type_Abum != null)
      {
        paramContext = jdField_a_of_type_Abum;
        return paramContext;
      }
    }
    finally {}
    jdField_a_of_type_Abum = new abum(paramContext);
    paramContext = jdField_a_of_type_Abum;
    return paramContext;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    abut localabut;
    for (String str = ""; localIterator.hasNext(); str = str + localabut.jdField_a_of_type_JavaLangString + ";") {
      localabut = (abut)localIterator.next();
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("PATCH_LIST", str);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public abut a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      abut localabut = (abut)localIterator.next();
      if (localabut.jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localabut;
      }
    }
    return null;
  }
  
  public ArrayList<abut> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(abut paramabut)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!((abut)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramabut.jdField_a_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if (i != -1) {
        this.jdField_a_of_type_JavaUtilArrayList.set(i, paramabut);
      }
      for (;;)
      {
        paramabut.b(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        return;
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramabut);
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
      abut localabut = (abut)localIterator.next();
      if (localabut.jdField_a_of_type_JavaLangString.equals(paramString))
      {
        localabut.a(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        this.jdField_a_of_type_JavaUtilArrayList.remove(localabut);
      }
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abum
 * JD-Core Version:    0.7.0.1
 */