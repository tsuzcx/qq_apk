import android.content.Context;
import android.view.LayoutInflater;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView;
import java.util.Calendar;
import java.util.Date;

public class ahru
{
  protected int a;
  protected long a;
  private ahrw jdField_a_of_type_Ahrw;
  ahrx jdField_a_of_type_Ahrx = new ahrx(this);
  protected Context a;
  private bjnw jdField_a_of_type_Bjnw;
  private TimeSelectView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView;
  protected int b;
  protected int c;
  protected int d;
  private int e;
  
  ahru(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView = ((TimeSelectView)LayoutInflater.from(paramContext).inflate(2131561128, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView.a(this.jdField_a_of_type_Ahrx);
    this.jdField_a_of_type_Bjnw = bjnw.c(paramContext);
    this.jdField_a_of_type_Bjnw.e(true);
    this.jdField_a_of_type_Bjnw.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView, null);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView.setPickListener(new ahrv(this));
    a();
  }
  
  private int a(long paramLong)
  {
    int i = 1;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.jdField_a_of_type_Int);
    localCalendar.set(6, this.b);
    localCalendar.set(11, this.c);
    localCalendar.set(12, this.d);
    long l = (paramLong - localCalendar.getTimeInMillis()) / 86400000L;
    localCalendar.setTime(new Date(paramLong));
    if (l < 0L) {
      i = 0;
    }
    while (l == 0L) {
      return i;
    }
    if (l <= 7L) {
      return 2;
    }
    if (localCalendar.get(1) == this.jdField_a_of_type_Int) {
      return 3;
    }
    return 4;
  }
  
  private void a()
  {
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date(l));
    this.jdField_a_of_type_Int = localCalendar.get(1);
    this.b = localCalendar.get(6);
    this.c = localCalendar.get(11);
    this.d = localCalendar.get(12);
  }
  
  private void a(int paramInt, Calendar paramCalendar)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView.a(1);
    if ((paramInt == 0) && (this.c < 23))
    {
      b(i, paramCalendar);
      return;
    }
    paramCalendar.set(12, 0);
    paramCalendar.set(11, i);
  }
  
  private void b()
  {
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date(l));
    if (this.c < 23) {
      localCalendar.add(12, 30);
    }
    for (;;)
    {
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      this.jdField_a_of_type_Long = localCalendar.getTimeInMillis();
      b(0, 0);
      b(1, 0);
      return;
      localCalendar.add(6, 1);
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView.setSelection(paramInt1, paramInt2);
    if (paramInt1 == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView.a(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView.a(0);
  }
  
  private void b(int paramInt, Calendar paramCalendar)
  {
    if (paramInt == 0)
    {
      paramCalendar.add(12, 30);
      return;
    }
    if (paramInt <= 3)
    {
      paramCalendar.add(11, paramInt);
      return;
    }
    paramCalendar.add(11, paramInt);
    paramCalendar.set(12, 0);
  }
  
  protected int a()
  {
    if (this.c >= 20) {
      return 4;
    }
    return 24 - this.c;
  }
  
  protected String a(int paramInt)
  {
    if (paramInt == 0) {
      return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131689979), new Object[] { Integer.valueOf(30) });
    }
    if ((paramInt > 0) && (paramInt <= 3)) {
      return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131689976), new Object[] { Integer.valueOf(paramInt) });
    }
    if ((paramInt > 3) && (paramInt < a())) {
      return this.c + paramInt + this.jdField_a_of_type_AndroidContentContext.getString(2131694174);
    }
    return "";
  }
  
  protected String a(int paramInt, Calendar paramCalendar)
  {
    Object localObject = "";
    if (paramCalendar.get(1) != this.jdField_a_of_type_Int) {
      localObject = "" + paramCalendar.get(1) + this.jdField_a_of_type_AndroidContentContext.getString(2131719733);
    }
    String str = (String)localObject + (paramCalendar.get(2) + 1) + this.jdField_a_of_type_AndroidContentContext.getString(2131693843) + paramCalendar.get(5) + this.jdField_a_of_type_AndroidContentContext.getString(2131691333);
    int i = paramInt;
    if (this.c >= 23) {
      i = paramInt + 1;
    }
    if (i == 0) {
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131719016);
    }
    do
    {
      return localObject;
      if (i == 1) {
        return str + " " + this.jdField_a_of_type_AndroidContentContext.getString(2131719018);
      }
      if (i == 2) {
        return str + " " + this.jdField_a_of_type_AndroidContentContext.getString(2131689821);
      }
      localObject = str;
    } while (i > 7);
    return str + " " + ahrm.a(paramCalendar.get(7));
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
    a();
    b();
    this.jdField_a_of_type_Bjnw.show();
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.jdField_a_of_type_Int);
    localCalendar.set(6, this.b);
    localCalendar.set(11, this.c);
    localCalendar.set(12, this.d);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      this.jdField_a_of_type_Long = localCalendar.getTimeInMillis();
      if (QLog.isColorLevel()) {
        QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 3, "year: " + localCalendar.get(1) + "\nmonth: " + localCalendar.get(2) + "\nday: " + localCalendar.get(5) + "\ntimeStamp: " + this.jdField_a_of_type_Long);
      }
      return;
      if (this.c < 23) {}
      for (paramInt1 = paramInt2;; paramInt1 = paramInt2 + 1)
      {
        localCalendar.add(6, paramInt1);
        a(paramInt2, localCalendar);
        break;
      }
      if (this.c < 23) {}
      for (paramInt1 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView.a(0);; paramInt1 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView.a(0) + 1)
      {
        localCalendar.add(6, paramInt1);
        if ((this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView.a(0) != 0) || (this.c >= 23)) {
          break label266;
        }
        b(paramInt2, localCalendar);
        break;
      }
      label266:
      localCalendar.set(12, 0);
      localCalendar.set(11, paramInt2);
    }
  }
  
  void a(ahrw paramahrw)
  {
    this.jdField_a_of_type_Ahrw = paramahrw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahru
 * JD-Core Version:    0.7.0.1
 */