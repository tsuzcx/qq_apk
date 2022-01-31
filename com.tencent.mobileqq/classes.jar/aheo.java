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
import java.util.LinkedList;
import java.util.List;

public class aheo
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<ahen> jdField_a_of_type_JavaUtilList = new LinkedList();
  
  public aheo(TroopMemberHistoryFragment paramTroopMemberHistoryFragment, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  boolean a(long paramLong1, long paramLong2)
  {
    CalendarDay localCalendarDay1 = new CalendarDay(paramLong1 * 1000L);
    CalendarDay localCalendarDay2 = new CalendarDay(paramLong2 * 1000L);
    return (localCalendarDay1.year == localCalendarDay2.year) && (localCalendarDay1.month == localCalendarDay2.month) && (localCalendarDay1.day == localCalendarDay2.day);
  }
  
  boolean a(List<ahen> paramList)
  {
    int j = paramList.size();
    int i = 0;
    long l2;
    for (long l1 = 0L; i < j; l1 = l2)
    {
      ahen localahen = (ahen)paramList.get(i);
      l2 = localahen.jdField_a_of_type_Long;
      if ((l1 == 0L) || (!a(l1, l2))) {
        localahen.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_JavaUtilList.add(localahen);
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
    ahen localahen;
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if (paramView == null)
    {
      paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559259, null);
      paramViewGroup = new ahem();
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)paramView.findViewById(2131377607));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377609));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367819));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131369133));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369531);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131378440));
      paramView.setTag(paramViewGroup);
      localahen = (ahen)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localahen.jdField_a_of_type_JavaLangCharSequence);
      paramViewGroup.b.setText(localahen.a());
      localObject = new bamb(bdgc.h(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.b, localahen.jdField_a_of_type_JavaLangString), 16).a();
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText((CharSequence)localObject);
      bdrv.a(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, (Spannable)localObject);
      localObject = bdbk.a(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localahen.jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localObject = (RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.b.getLayoutParams();
      if (!localahen.jdField_a_of_type_Boolean) {
        break label420;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (paramInt != 0) {
        break label400;
      }
      i = bdoo.a(3.0F);
      label284:
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      if (paramInt != 0) {
        break label410;
      }
      i = bdoo.a(3.0F);
    }
    label302:
    for (localLayoutParams.topMargin = i;; localLayoutParams.topMargin = 0)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramViewGroup.b.setLayoutParams(localLayoutParams);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramInt));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription(localahen.jdField_a_of_type_JavaLangCharSequence + " " + localahen.a());
      return paramView;
      paramViewGroup = (ahem)paramView.getTag();
      break;
      i = bdoo.a(9.0F);
      break label284;
      i = bdoo.a(9.0F);
      break label302;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aheo
 * JD-Core Version:    0.7.0.1
 */