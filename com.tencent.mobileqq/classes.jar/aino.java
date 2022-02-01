import com.tencent.TMG.utils.QLog;
import java.util.Calendar;
import java.util.Date;

class aino
  implements aqje
{
  aino(ainl paramainl) {}
  
  public int a()
  {
    return 4;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1;
    case 0: 
      return 2;
    case 1: 
      return aind.a(ainl.b(this.a));
    case 2: 
      return 24;
    }
    return 60;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
      return "" + (ainl.c(this.a) + paramInt2) + "年";
    case 1: 
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.clear();
      localCalendar.setFirstDayOfWeek(1);
      localCalendar.set(1, ainl.b(this.a));
      localCalendar.add(5, paramInt2);
      String str = "" + (localCalendar.get(2) + 1);
      str = str + "月";
      str = str + localCalendar.get(5);
      str = str + "日 ";
      str = str + aind.a(localCalendar.get(7));
      QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 3, str + " day_of_week " + localCalendar.get(7) + "\n" + localCalendar.getTime().toString());
      return str;
    case 2: 
      return "" + (ainl.d(this.a) + paramInt2);
    }
    return "" + (ainl.e(this.a) + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aino
 * JD-Core Version:    0.7.0.1
 */