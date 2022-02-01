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
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedList;
import java.util.List;

public class airt
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<airs> jdField_a_of_type_JavaUtilList = new LinkedList();
  
  public airt(TroopMemberHistoryFragment paramTroopMemberHistoryFragment, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  boolean a(long paramLong1, long paramLong2)
  {
    CalendarDay localCalendarDay1 = new CalendarDay(paramLong1 * 1000L);
    CalendarDay localCalendarDay2 = new CalendarDay(paramLong2 * 1000L);
    return (localCalendarDay1.year == localCalendarDay2.year) && (localCalendarDay1.month == localCalendarDay2.month) && (localCalendarDay1.day == localCalendarDay2.day);
  }
  
  boolean a(List<airs> paramList)
  {
    int j = paramList.size();
    int i = 0;
    long l2;
    for (long l1 = 0L; i < j; l1 = l2)
    {
      airs localairs = (airs)paramList.get(i);
      l2 = localairs.jdField_a_of_type_Long;
      if ((l1 == 0L) || (!a(l1, l2))) {
        localairs.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_JavaUtilList.add(localairs);
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
    airr localairr;
    airs localairs;
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if (paramView == null)
    {
      paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559396, null);
      localairr = new airr();
      localairr.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)paramView.findViewById(2131378659));
      localairr.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378661));
      localairr.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368381));
      localairr.b = ((TextView)paramView.findViewById(2131369774));
      localairr.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370193);
      localairr.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131379531));
      paramView.setTag(localairr);
      localairs = (airs)getItem(paramInt);
      localairr.jdField_a_of_type_AndroidWidgetTextView.setText(localairs.jdField_a_of_type_JavaLangCharSequence);
      localairr.b.setText(localairs.a());
      localObject = new begq(ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.b, localairs.jdField_a_of_type_JavaLangString), 16).a();
      localairr.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText((CharSequence)localObject);
      bhmb.a(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localairr.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, (Spannable)localObject);
      localObject = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localairs.jdField_a_of_type_JavaLangString);
      localairr.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localObject = (RelativeLayout.LayoutParams)localairr.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams = (RelativeLayout.LayoutParams)localairr.b.getLayoutParams();
      if (!localairs.jdField_a_of_type_Boolean) {
        break label456;
      }
      localairr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localairr.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (paramInt != 0) {
        break label436;
      }
      i = ViewUtils.dip2px(3.0F);
      label301:
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      if (paramInt != 0) {
        break label446;
      }
      i = ViewUtils.dip2px(3.0F);
    }
    label319:
    for (localLayoutParams.topMargin = i;; localLayoutParams.topMargin = 0)
    {
      localairr.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localairr.b.setLayoutParams(localLayoutParams);
      localairr.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramInt));
      localairr.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription(localairs.jdField_a_of_type_JavaLangCharSequence + " " + localairs.a());
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localairr = (airr)paramView.getTag();
      break;
      i = ViewUtils.dip2px(9.0F);
      break label301;
      i = ViewUtils.dip2px(9.0F);
      break label319;
      label456:
      localairr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localairr.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airt
 * JD-Core Version:    0.7.0.1
 */