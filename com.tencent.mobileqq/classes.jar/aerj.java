import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryByDateFragment;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.mobileqq.widget.datepicker.SimpleMonthView;
import com.tencent.qphone.base.util.QLog;

public class aerj
  implements bbpi
{
  CalendarDay jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
  CalendarDay b;
  
  public aerj(ChatHistoryByDateFragment paramChatHistoryByDateFragment, CalendarDay paramCalendarDay1, CalendarDay paramCalendarDay2)
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
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryByDateFragment.jdField_a_of_type_JavaLangString;
    ChatHistoryBubbleListForTroopFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryByDateFragment.getActivity(), str, paramMessageRecord, -1, 3);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryByDateFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_date", "date_clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryByDateFragment.jdField_a_of_type_JavaLangString, "", "", "");
    QLog.i(ChatHistoryByDateFragment.a(), 1, "clickDay: CalendarDay" + paramCalendarDay + " | MessageRecord:" + paramMessageRecord);
  }
  
  public void a(SimpleMonthView paramSimpleMonthView, int paramInt1, int paramInt2)
  {
    if (!ChatHistoryByDateFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryByDateFragment, paramInt1, paramInt2)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryByDateFragment.a(paramInt1, paramInt2);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aerj
 * JD-Core Version:    0.7.0.1
 */