import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import mqq.observer.BusinessObserver;

public class amaz
  implements BusinessObserver
{
  private static amaz jdField_a_of_type_Amaz;
  private int jdField_a_of_type_Int;
  private final SparseArray<amay> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  public static amaz a()
  {
    if (jdField_a_of_type_Amaz == null) {}
    try
    {
      if (jdField_a_of_type_Amaz == null) {
        jdField_a_of_type_Amaz = new amaz();
      }
      return jdField_a_of_type_Amaz;
    }
    finally {}
  }
  
  public int a(amay paramamay)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      SparseArray localSparseArray2 = this.jdField_a_of_type_AndroidUtilSparseArray;
      int i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      localSparseArray2.append(i, paramamay);
      i = this.jdField_a_of_type_Int;
      return i;
    }
  }
  
  public int a(Context paramContext, amag paramamag)
  {
    return a(new amay(paramContext, paramamag));
  }
  
  public int a(Context paramContext, amal paramamal)
  {
    return a(new amay(paramContext, paramamal));
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = paramBundle.getInt("req_id");
    amay localamay = (amay)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.delete(i);
      return;
      localamay.b(paramBoolean, paramBundle.getBoolean("allow_download", true), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"), paramBundle.getString("jump_url"));
      continue;
      localamay.b(paramBoolean, paramBundle.getInt("jump", 0), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amaz
 * JD-Core Version:    0.7.0.1
 */