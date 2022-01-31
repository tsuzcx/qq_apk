import android.os.Bundle;
import com.tencent.mobileqq.statistics.battery.BatteryStatsImpl;

public class aili
{
  public boolean a;
  public String[][] a;
  public boolean b = true;
  public boolean c;
  public boolean d;
  
  public aili(BatteryStatsImpl paramBatteryStatsImpl, String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    paramBatteryStatsImpl = paramString.split(";");
    this.jdField_a_of_type_Array2dOfJavaLangString = new String[paramBatteryStatsImpl.length][];
    int i = 0;
    while (i < paramBatteryStatsImpl.length)
    {
      this.jdField_a_of_type_Array2dOfJavaLangString[i] = paramBatteryStatsImpl[i].split(",");
      i += 1;
    }
  }
  
  public void a() {}
  
  public void a(Bundle paramBundle) {}
  
  public void b()
  {
    this.c = true;
    if (!BatteryStatsImpl.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl)) {
      this.d = true;
    }
  }
  
  public void c()
  {
    this.c = false;
    this.d = false;
  }
  
  public void d() {}
  
  public void e()
  {
    this.b = false;
  }
  
  public void f()
  {
    this.d = false;
  }
  
  public void g()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aili
 * JD-Core Version:    0.7.0.1
 */