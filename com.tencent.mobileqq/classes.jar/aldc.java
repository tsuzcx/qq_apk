import android.content.SharedPreferences;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.NeonControl.1;
import com.tencent.mobileqq.ar.NeonControl.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aldc
{
  private static aldc jdField_a_of_type_Aldc;
  public static boolean a;
  aldd jdField_a_of_type_Aldd;
  public final Object a;
  private boolean b;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  private aldc()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    Object localObject1 = BaseApplication.getContext().getSharedPreferences("sp_cpu_neon_support", 4);
    if (!((SharedPreferences)localObject1).contains("sp_cpu_neon_support")) {
      ThreadManager.post(new NeonControl.1(this, (SharedPreferences)localObject1, false), 5, null, true);
    }
    boolean bool2 = ((SharedPreferences)localObject1).getBoolean("sp_cpu_neon_support", false);
    boolean bool3 = aldn.a().e;
    int i;
    int j;
    if (QLog.isColorLevel())
    {
      if (bool3)
      {
        i = 1;
        if (!bool2) {
          break label174;
        }
        j = 1;
        label97:
        QLog.i("NeonControl", 2, String.format("dpcNeonCfgSwitch:%d isNeonSupport:%d forceOpenNeon:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0) }));
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_JavaLangObject;
      if ((!bool3) || (!bool2)) {
        break label179;
      }
    }
    for (;;)
    {
      try
      {
        this.b = bool1;
        return;
      }
      finally {}
      i = 0;
      break;
      label174:
      j = 0;
      break label97;
      label179:
      bool1 = false;
    }
  }
  
  public static aldc a()
  {
    if (jdField_a_of_type_Aldc == null) {
      jdField_a_of_type_Aldc = new aldc();
    }
    return jdField_a_of_type_Aldc;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aldd == null) {}
    aldd localaldd;
    int i;
    do
    {
      do
      {
        return;
        localaldd = new aldd(this);
        localaldd.jdField_a_of_type_Long = this.jdField_a_of_type_Aldd.jdField_a_of_type_Long;
        localaldd.jdField_a_of_type_Int = this.jdField_a_of_type_Aldd.jdField_a_of_type_Int;
        localaldd.b = this.jdField_a_of_type_Aldd.b;
        this.jdField_a_of_type_Aldd.b = -2147483648;
        this.jdField_a_of_type_Aldd.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_Aldd.jdField_a_of_type_Int = 0;
      } while ((localaldd.jdField_a_of_type_Long <= 0L) || (localaldd.jdField_a_of_type_Int <= 0) || (localaldd.b == -2147483648));
      i = (int)(localaldd.jdField_a_of_type_Long / localaldd.jdField_a_of_type_Int);
    } while ((i < 0) || (i >= 600000));
    ThreadManager.post(new NeonControl.2(this, localaldd, i), 5, null, false);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Aldd == null)
    {
      this.jdField_a_of_type_Aldd = new aldd(this);
      this.jdField_a_of_type_Aldd.b = paramInt;
    }
    if (this.jdField_a_of_type_Aldd.b != paramInt)
    {
      if ((this.jdField_a_of_type_Aldd.jdField_a_of_type_Long > 0L) || (this.jdField_a_of_type_Aldd.jdField_a_of_type_Int > 0)) {
        a();
      }
      this.jdField_a_of_type_Aldd.b = paramInt;
      this.jdField_a_of_type_Aldd.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Aldd.jdField_a_of_type_Int = 0;
    }
    aldd localaldd = this.jdField_a_of_type_Aldd;
    localaldd.jdField_a_of_type_Long += paramLong;
    localaldd = this.jdField_a_of_type_Aldd;
    localaldd.jdField_a_of_type_Int += 1;
  }
  
  public boolean a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      boolean bool = this.b;
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aldc
 * JD-Core Version:    0.7.0.1
 */