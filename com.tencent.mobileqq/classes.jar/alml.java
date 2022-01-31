import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import mqq.observer.BusinessObserver;

public class alml
  implements BusinessObserver
{
  private static alml jdField_a_of_type_Alml;
  private int jdField_a_of_type_Int;
  private final SparseArray<almk> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  public static alml a()
  {
    if (jdField_a_of_type_Alml == null) {}
    try
    {
      if (jdField_a_of_type_Alml == null) {
        jdField_a_of_type_Alml = new alml();
      }
      return jdField_a_of_type_Alml;
    }
    finally {}
  }
  
  public int a(almk paramalmk)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      SparseArray localSparseArray2 = this.jdField_a_of_type_AndroidUtilSparseArray;
      int i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      localSparseArray2.append(i, paramalmk);
      i = this.jdField_a_of_type_Int;
      return i;
    }
  }
  
  public int a(Context paramContext, alls paramalls)
  {
    return a(new almk(paramContext, paramalls));
  }
  
  public int a(Context paramContext, allx paramallx)
  {
    return a(new almk(paramContext, paramallx));
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = paramBundle.getInt("req_id");
    almk localalmk = (almk)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.delete(i);
      return;
      localalmk.b(paramBoolean, paramBundle.getBoolean("allow_download", true), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"), paramBundle.getString("jump_url"));
      continue;
      localalmk.b(paramBoolean, paramBundle.getInt("jump", 0), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alml
 * JD-Core Version:    0.7.0.1
 */