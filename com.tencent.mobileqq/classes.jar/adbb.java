import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Iterator;

public class adbb
{
  private static adbb jdField_a_of_type_Adbb;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public String a;
  private ArrayList<adbi> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private adbb()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private adbb(Context paramContext)
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
        localObject = new adbi(this.jdField_a_of_type_AndroidContentSharedPreferences, (String)localObject);
        adax.a("KingKongMainConfig", "--> " + localObject);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
      i += 1;
    }
  }
  
  public static adbb a(Context paramContext)
  {
    if (jdField_a_of_type_Adbb != null) {
      return jdField_a_of_type_Adbb;
    }
    try
    {
      if (jdField_a_of_type_Adbb != null)
      {
        paramContext = jdField_a_of_type_Adbb;
        return paramContext;
      }
    }
    finally {}
    jdField_a_of_type_Adbb = new adbb(paramContext);
    paramContext = jdField_a_of_type_Adbb;
    return paramContext;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    adbi localadbi;
    for (String str = ""; localIterator.hasNext(); str = str + localadbi.jdField_a_of_type_JavaLangString + ";") {
      localadbi = (adbi)localIterator.next();
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("PATCH_LIST", str);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public adbi a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      adbi localadbi = (adbi)localIterator.next();
      if (localadbi.jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localadbi;
      }
    }
    return null;
  }
  
  public ArrayList<adbi> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(adbi paramadbi)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!((adbi)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramadbi.jdField_a_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if (i != -1) {
        this.jdField_a_of_type_JavaUtilArrayList.set(i, paramadbi);
      }
      for (;;)
      {
        paramadbi.b(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        return;
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramadbi);
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
      adbi localadbi = (adbi)localIterator.next();
      if (localadbi.jdField_a_of_type_JavaLangString.equals(paramString))
      {
        localadbi.a(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        this.jdField_a_of_type_JavaUtilArrayList.remove(localadbi);
      }
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adbb
 * JD-Core Version:    0.7.0.1
 */