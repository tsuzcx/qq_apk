import android.content.Context;
import android.view.LayoutInflater;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView;
import java.util.Calendar;
import java.util.Date;

public class aixj
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aixl jdField_a_of_type_Aixl;
  aixm jdField_a_of_type_Aixm = new aixm(this);
  private blir jdField_a_of_type_Blir;
  private TimeSelectView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  aixj(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView = ((TimeSelectView)LayoutInflater.from(paramContext).inflate(2131561253, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView.a(this.jdField_a_of_type_Aixm);
    this.jdField_a_of_type_Blir = blir.c(paramContext);
    this.jdField_a_of_type_Blir.e(true);
    this.jdField_a_of_type_Blir.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView, null);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView.setPickListener(new aixk(this));
    a();
  }
  
  private void a()
  {
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date(l));
    this.c = localCalendar.get(1);
    this.b = this.c;
    this.e = localCalendar.get(6);
    this.d = 1;
    this.g = localCalendar.get(10);
    this.f = 0;
    this.i = localCalendar.get(12);
    this.h = 0;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    Calendar localCalendar;
    switch (paramInt1)
    {
    default: 
      localCalendar = Calendar.getInstance();
      localCalendar.set(1, this.c);
      localCalendar.set(6, this.e);
      localCalendar.set(11, this.g);
      localCalendar.set(12, this.i);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      if (localCalendar.getTimeInMillis() > System.currentTimeMillis()) {
        bool = true;
      }
      if (bool) {
        this.jdField_a_of_type_Long = localCalendar.getTimeInMillis();
      }
      break;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 3, "year: " + localCalendar.get(1) + "\nmonth: " + localCalendar.get(2) + "\nday: " + localCalendar.get(5) + "\ntimeValid: " + bool);
      }
      return;
      this.c = (this.b + paramInt2);
      break;
      this.e = (this.d + paramInt2);
      break;
      this.g = (this.f + paramInt2);
      break;
      this.i = (this.h + paramInt2);
      break;
      b();
    }
  }
  
  private void b()
  {
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date(l + 60000L));
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    this.jdField_a_of_type_Long = localCalendar.getTimeInMillis();
    int j = localCalendar.get(1);
    int k = localCalendar.get(6);
    int m = localCalendar.get(11);
    int n = localCalendar.get(12);
    int i1 = this.b;
    int i2 = this.d;
    int i3 = this.f;
    int i4 = this.h;
    b(0, j - i1);
    b(1, k - i2);
    b(2, m - i3);
    b(3, n - i4);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView.setSelection(paramInt1, paramInt2);
      return;
      this.c = (this.b + paramInt2);
      continue;
      this.e = (this.d + paramInt2);
      continue;
      this.g = (this.f + paramInt2);
      continue;
      this.i = (this.h + paramInt2);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    b();
    this.jdField_a_of_type_Blir.show();
  }
  
  void a(aixl paramaixl)
  {
    this.jdField_a_of_type_Aixl = paramaixl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixj
 * JD-Core Version:    0.7.0.1
 */