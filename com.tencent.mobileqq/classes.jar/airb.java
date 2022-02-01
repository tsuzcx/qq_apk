import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedList;
import java.util.List;

public class airb
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<aira> jdField_a_of_type_JavaUtilList = new LinkedList();
  
  public airb(TroopMemberHistoryFragment paramTroopMemberHistoryFragment, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  boolean a(long paramLong1, long paramLong2)
  {
    CalendarDay localCalendarDay1 = new CalendarDay(paramLong1 * 1000L);
    CalendarDay localCalendarDay2 = new CalendarDay(paramLong2 * 1000L);
    return (localCalendarDay1.year == localCalendarDay2.year) && (localCalendarDay1.month == localCalendarDay2.month) && (localCalendarDay1.day == localCalendarDay2.day);
  }
  
  boolean a(List<aira> paramList)
  {
    int j = paramList.size();
    int i = 0;
    long l2;
    for (long l1 = 0L; i < j; l1 = l2)
    {
      aira localaira = (aira)paramList.get(i);
      l2 = localaira.jdField_a_of_type_Long;
      if ((l1 == 0L) || (!a(l1, l2))) {
        localaira.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_JavaUtilList.add(localaira);
      i += 1;
    }
    return true;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aiqz localaiqz;
    aira localaira;
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if (paramView == null)
    {
      paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559344, null);
      localaiqz = new aiqz();
      localaiqz.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)paramView.findViewById(2131378446));
      localaiqz.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378448));
      localaiqz.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368138));
      localaiqz.b = ((TextView)paramView.findViewById(2131369522));
      localaiqz.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369926);
      localaiqz.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131379290));
      paramView.setTag(localaiqz);
      localaira = (aira)getItem(paramInt);
      localaiqz.jdField_a_of_type_AndroidWidgetTextView.setText(localaira.jdField_a_of_type_JavaLangCharSequence);
      localaiqz.b.setText(localaira.a());
      localObject = new bdnf(bglf.h(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.b, localaira.jdField_a_of_type_JavaLangString), 16).a();
      localaiqz.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText((CharSequence)localObject);
      bgwv.a(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaiqz.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, (Spannable)localObject);
      localObject = aoch.a(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localaira.jdField_a_of_type_JavaLangString);
      localaiqz.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localObject = (RelativeLayout.LayoutParams)localaiqz.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams = (RelativeLayout.LayoutParams)localaiqz.b.getLayoutParams();
      if (!localaira.jdField_a_of_type_Boolean) {
        break label456;
      }
      localaiqz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localaiqz.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (paramInt != 0) {
        break label436;
      }
      i = bgtn.a(3.0F);
      label301:
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      if (paramInt != 0) {
        break label446;
      }
      i = bgtn.a(3.0F);
    }
    label319:
    for (localLayoutParams.topMargin = i;; localLayoutParams.topMargin = 0)
    {
      localaiqz.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localaiqz.b.setLayoutParams(localLayoutParams);
      localaiqz.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramInt));
      localaiqz.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription(localaira.jdField_a_of_type_JavaLangCharSequence + " " + localaira.a());
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localaiqz = (aiqz)paramView.getTag();
      break;
      i = bgtn.a(9.0F);
      break label301;
      i = bgtn.a(9.0F);
      break label319;
      label456:
      localaiqz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localaiqz.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airb
 * JD-Core Version:    0.7.0.1
 */