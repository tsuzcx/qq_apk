import android.content.SharedPreferences;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.NeonControl.1;
import com.tencent.mobileqq.ar.NeonControl.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aldb
{
  private static aldb jdField_a_of_type_Aldb;
  public static boolean a;
  aldc jdField_a_of_type_Aldc;
  public final Object a;
  private boolean b;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  private aldb()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    Object localObject1 = BaseApplication.getContext().getSharedPreferences("sp_cpu_neon_support", 4);
    if (!((SharedPreferences)localObject1).contains("sp_cpu_neon_support")) {
      ThreadManager.post(new NeonControl.1(this, (SharedPreferences)localObject1, false), 5, null, true);
    }
    boolean bool2 = ((SharedPreferences)localObject1).getBoolean("sp_cpu_neon_support", false);
    boolean bool3 = aldm.a().e;
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
  
  public static aldb a()
  {
    if (jdField_a_of_type_Aldb == null) {
      jdField_a_of_type_Aldb = new aldb();
    }
    return jdField_a_of_type_Aldb;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aldc == null) {}
    aldc localaldc;
    int i;
    do
    {
      do
      {
        return;
        localaldc = new aldc(this);
        localaldc.jdField_a_of_type_Long = this.jdField_a_of_type_Aldc.jdField_a_of_type_Long;
        localaldc.jdField_a_of_type_Int = this.jdField_a_of_type_Aldc.jdField_a_of_type_Int;
        localaldc.b = this.jdField_a_of_type_Aldc.b;
        this.jdField_a_of_type_Aldc.b = -2147483648;
        this.jdField_a_of_type_Aldc.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_Aldc.jdField_a_of_type_Int = 0;
      } while ((localaldc.jdField_a_of_type_Long <= 0L) || (localaldc.jdField_a_of_type_Int <= 0) || (localaldc.b == -2147483648));
      i = (int)(localaldc.jdField_a_of_type_Long / localaldc.jdField_a_of_type_Int);
    } while ((i < 0) || (i >= 600000));
    ThreadManager.post(new NeonControl.2(this, localaldc, i), 5, null, false);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Aldc == null)
    {
      this.jdField_a_of_type_Aldc = new aldc(this);
      this.jdField_a_of_type_Aldc.b = paramInt;
    }
    if (this.jdField_a_of_type_Aldc.b != paramInt)
    {
      if ((this.jdField_a_of_type_Aldc.jdField_a_of_type_Long > 0L) || (this.jdField_a_of_type_Aldc.jdField_a_of_type_Int > 0)) {
        a();
      }
      this.jdField_a_of_type_Aldc.b = paramInt;
      this.jdField_a_of_type_Aldc.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Aldc.jdField_a_of_type_Int = 0;
    }
    aldc localaldc = this.jdField_a_of_type_Aldc;
    localaldc.jdField_a_of_type_Long += paramLong;
    localaldc = this.jdField_a_of_type_Aldc;
    localaldc.jdField_a_of_type_Int += 1;
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
 * Qualified Name:     aldb
 * JD-Core Version:    0.7.0.1
 */