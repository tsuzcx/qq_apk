import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Iterator;

public class abpx
{
  private static abpx jdField_a_of_type_Abpx;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public String a;
  private ArrayList<abqe> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private abpx()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private abpx(Context paramContext)
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
        localObject = new abqe(this.jdField_a_of_type_AndroidContentSharedPreferences, (String)localObject);
        abpt.a("KingKongMainConfig", "--> " + localObject);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
      i += 1;
    }
  }
  
  public static abpx a(Context paramContext)
  {
    if (jdField_a_of_type_Abpx != null) {
      return jdField_a_of_type_Abpx;
    }
    try
    {
      if (jdField_a_of_type_Abpx != null)
      {
        paramContext = jdField_a_of_type_Abpx;
        return paramContext;
      }
    }
    finally {}
    jdField_a_of_type_Abpx = new abpx(paramContext);
    paramContext = jdField_a_of_type_Abpx;
    return paramContext;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    abqe localabqe;
    for (String str = ""; localIterator.hasNext(); str = str + localabqe.jdField_a_of_type_JavaLangString + ";") {
      localabqe = (abqe)localIterator.next();
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("PATCH_LIST", str);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public abqe a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      abqe localabqe = (abqe)localIterator.next();
      if (localabqe.jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localabqe;
      }
    }
    return null;
  }
  
  public ArrayList<abqe> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(abqe paramabqe)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!((abqe)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramabqe.jdField_a_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if (i != -1) {
        this.jdField_a_of_type_JavaUtilArrayList.set(i, paramabqe);
      }
      for (;;)
      {
        paramabqe.b(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        return;
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramabqe);
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
      abqe localabqe = (abqe)localIterator.next();
      if (localabqe.jdField_a_of_type_JavaLangString.equals(paramString))
      {
        localabqe.a(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        this.jdField_a_of_type_JavaUtilArrayList.remove(localabqe);
      }
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abpx
 * JD-Core Version:    0.7.0.1
 */