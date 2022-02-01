import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CDateFragment;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.mobileqq.widget.datepicker.SimpleMonthView;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

public class aiwe
  implements bhkt
{
  CalendarDay jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
  CalendarDay b;
  
  public aiwe(ChatHistoryC2CDateFragment paramChatHistoryC2CDateFragment, CalendarDay paramCalendarDay1, CalendarDay paramCalendarDay2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = paramCalendarDay1;
    this.b = paramCalendarDay2;
  }
  
  public CalendarDay a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay == null) {
      return new CalendarDay(System.currentTimeMillis());
    }
    return this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
  }
  
  public void a(CalendarDay paramCalendarDay, MessageRecord paramMessageRecord)
  {
    if (ChatHistoryC2CDateFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment).a())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment.getString(2131718612), new aiwd(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment));
      ChatHistoryC2CDateFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment, paramCalendarDay);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramCalendarDay.getTimeInMillis());
      ChatHistoryC2CDateFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment).d(localCalendar);
    }
    for (;;)
    {
      QLog.i(ChatHistoryC2CDateFragment.b(), 1, "clickDay: CalendarDay" + paramCalendarDay + " | MessageRecord:" + paramMessageRecord);
      return;
      ChatHistoryC2CDateFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment);
      ChatHistoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment.getActivity(), ChatHistoryC2CDateFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment), ChatHistoryC2CDateFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment), ChatHistoryC2CDateFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment), paramMessageRecord.time, paramMessageRecord.shmsgseq, 0);
    }
  }
  
  public void a(CalendarDay paramCalendarDay1, CalendarDay paramCalendarDay2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = paramCalendarDay1;
    this.b = paramCalendarDay2;
  }
  
  public void a(SimpleMonthView paramSimpleMonthView, int paramInt1, int paramInt2)
  {
    if (!ChatHistoryC2CDateFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment, paramInt1, paramInt2))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment.d) {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment.a(paramInt1, paramInt2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment.b(paramInt1, paramInt2);
  }
  
  public CalendarDay b()
  {
    if (this.b == null)
    {
      CalendarDay localCalendarDay = new CalendarDay(System.currentTimeMillis());
      return new CalendarDay(localCalendarDay.year + 1, localCalendarDay.month, localCalendarDay.month);
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwe
 * JD-Core Version:    0.7.0.1
 */