import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Iterator;

public class acgt
{
  private static acgt jdField_a_of_type_Acgt;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public String a;
  private ArrayList<acha> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private acgt()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private acgt(Context paramContext)
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
        localObject = new acha(this.jdField_a_of_type_AndroidContentSharedPreferences, (String)localObject);
        acgp.a("KingKongMainConfig", "--> " + localObject);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
      i += 1;
    }
  }
  
  public static acgt a(Context paramContext)
  {
    if (jdField_a_of_type_Acgt != null) {
      return jdField_a_of_type_Acgt;
    }
    try
    {
      if (jdField_a_of_type_Acgt != null)
      {
        paramContext = jdField_a_of_type_Acgt;
        return paramContext;
      }
    }
    finally {}
    jdField_a_of_type_Acgt = new acgt(paramContext);
    paramContext = jdField_a_of_type_Acgt;
    return paramContext;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    acha localacha;
    for (String str = ""; localIterator.hasNext(); str = str + localacha.jdField_a_of_type_JavaLangString + ";") {
      localacha = (acha)localIterator.next();
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("PATCH_LIST", str);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public acha a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      acha localacha = (acha)localIterator.next();
      if (localacha.jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localacha;
      }
    }
    return null;
  }
  
  public ArrayList<acha> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(acha paramacha)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!((acha)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramacha.jdField_a_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if (i != -1) {
        this.jdField_a_of_type_JavaUtilArrayList.set(i, paramacha);
      }
      for (;;)
      {
        paramacha.b(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        return;
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramacha);
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
      acha localacha = (acha)localIterator.next();
      if (localacha.jdField_a_of_type_JavaLangString.equals(paramString))
      {
        localacha.a(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        this.jdField_a_of_type_JavaUtilArrayList.remove(localacha);
      }
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgt
 * JD-Core Version:    0.7.0.1
 */