import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aelg
  extends BaseAdapter
{
  private anyw jdField_a_of_type_Anyw;
  
  public aelg(DiscussionInfoCardActivity paramDiscussionInfoCardActivity)
  {
    this.jdField_a_of_type_Anyw = ((anyw)paramDiscussionInfoCardActivity.app.getManager(51));
  }
  
  public int getCount()
  {
    if (DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity) == null) {
      return 1;
    }
    return DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if ((DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity) == null) || (paramInt >= DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).size())) {
      return null;
    }
    return DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    aelh localaelh;
    TextView localTextView;
    ImageView localImageView;
    Object localObject1;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getLayoutInflater().inflate(2131558867, null);
      localaelh = new aelh();
      localaelh.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368212));
      localaelh.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371647));
      localView.setTag(localaelh);
      localView.setVisibility(0);
      localView.setFocusable(false);
      localTextView = localaelh.jdField_a_of_type_AndroidWidgetTextView;
      localImageView = localaelh.jdField_a_of_type_AndroidWidgetImageView;
      if (paramInt != getCount() - 1) {
        break label253;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getString(2131693130);
      localTextView.setText((CharSequence)localObject1);
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getResources().getColor(2131166998));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130839186);
      localImageView.setTag(localObject1);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a.isDiscussHrMeeting()) || (!bhoq.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a.mSelfRight))) {
        break label244;
      }
      localImageView.setEnabled(false);
    }
    for (;;)
    {
      if (AppSetting.c) {
        ViewCompat.setImportantForAccessibility(localImageView, 2);
      }
      localImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      localaelh = (aelh)paramView.getTag();
      localView = paramView;
      break;
      label244:
      localImageView.setEnabled(true);
      continue;
      label253:
      if (paramInt > getCount() - 1)
      {
        localTextView.setText("");
        localImageView.setBackgroundDrawable(null);
        localImageView.setImageDrawable(null);
      }
      else
      {
        localImageView.setImageResource(2130844964);
        localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getResources().getColor(2131166990));
        String str = ((DiscussionMemberInfo)DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).get(paramInt)).memberUin;
        localaelh.jdField_a_of_type_JavaLangString = str;
        Object localObject2 = bhlg.c(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity), str);
        if (TextUtils.isEmpty(str))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localTextView.setText((CharSequence)localObject1);
          localImageView.setImageDrawable(bhmq.b());
        }
        else
        {
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_Anyw != null)
            {
              Friends localFriends = this.jdField_a_of_type_Anyw.e(str);
              localObject1 = localObject2;
              if (localFriends != null)
              {
                localObject1 = localObject2;
                if (localFriends.isFriend()) {
                  localObject1 = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, str);
                }
              }
            }
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = str;
          }
          localTextView.setText((CharSequence)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a(localaelh, null, true);
          localImageView.setTag(str);
          localImageView.setTag(2131378423, localObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aelg
 * JD-Core Version:    0.7.0.1
 */