import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import mqq.observer.BusinessObserver;

public class amay
  implements BusinessObserver
{
  private static amay jdField_a_of_type_Amay;
  private int jdField_a_of_type_Int;
  private final SparseArray<amax> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  public static amay a()
  {
    if (jdField_a_of_type_Amay == null) {}
    try
    {
      if (jdField_a_of_type_Amay == null) {
        jdField_a_of_type_Amay = new amay();
      }
      return jdField_a_of_type_Amay;
    }
    finally {}
  }
  
  public int a(amax paramamax)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      SparseArray localSparseArray2 = this.jdField_a_of_type_AndroidUtilSparseArray;
      int i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      localSparseArray2.append(i, paramamax);
      i = this.jdField_a_of_type_Int;
      return i;
    }
  }
  
  public int a(Context paramContext, amaf paramamaf)
  {
    return a(new amax(paramContext, paramamaf));
  }
  
  public int a(Context paramContext, amak paramamak)
  {
    return a(new amax(paramContext, paramamak));
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = paramBundle.getInt("req_id");
    amax localamax = (amax)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.delete(i);
      return;
      localamax.b(paramBoolean, paramBundle.getBoolean("allow_download", true), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"), paramBundle.getString("jump_url"));
      continue;
      localamax.b(paramBoolean, paramBundle.getInt("jump", 0), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amay
 * JD-Core Version:    0.7.0.1
 */