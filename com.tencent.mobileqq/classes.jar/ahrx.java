import android.content.Context;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView;
import java.util.Calendar;
import java.util.Date;

class ahrx
  implements aprs
{
  ahrx(ahru paramahru) {}
  
  public int a()
  {
    return 2;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1;
    case 0: 
      if (this.a.c >= 23) {
        return 365;
      }
      return 366;
    }
    if ((ahru.a(this.a).a(0) == 0) && (this.a.c < 23)) {
      return this.a.a();
    }
    return 24;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      localObject = "";
      return localObject;
    case 0: 
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setFirstDayOfWeek(1);
      if (this.a.c < 23) {}
      for (paramInt1 = paramInt2;; paramInt1 = paramInt2 + 1)
      {
        localCalendar.add(6, paramInt1);
        localObject = this.a.a(paramInt2, localCalendar);
        String str = "" + (String)localObject;
        localObject = str;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 1, str + " day_of_week " + localCalendar.get(7) + "\n" + localCalendar.getTime().toString());
        return str;
      }
    }
    if ((ahru.a(this.a).a(0) == 0) && (this.a.c < 23)) {}
    for (Object localObject = this.a.a(paramInt2);; localObject = paramInt2 + this.a.a.getString(2131694174)) {
      return "" + (String)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrx
 * JD-Core Version:    0.7.0.1
 */