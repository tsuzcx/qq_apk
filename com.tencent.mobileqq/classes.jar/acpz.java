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
import java.util.List;

public class acpz
  extends BaseAdapter
{
  private aloz jdField_a_of_type_Aloz;
  
  public acpz(DiscussionInfoCardActivity paramDiscussionInfoCardActivity)
  {
    this.jdField_a_of_type_Aloz = ((aloz)paramDiscussionInfoCardActivity.app.getManager(51));
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
    acqa localacqa;
    TextView localTextView;
    ImageView localImageView;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getLayoutInflater().inflate(2131558797, null);
      localacqa = new acqa();
      localacqa.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367808));
      localacqa.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370958));
      paramViewGroup.setTag(localacqa);
      paramViewGroup.setVisibility(0);
      paramViewGroup.setFocusable(false);
      localTextView = localacqa.jdField_a_of_type_AndroidWidgetTextView;
      localImageView = localacqa.jdField_a_of_type_AndroidWidgetImageView;
      if (paramInt != getCount() - 1) {
        break label228;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getString(2131693776);
      localTextView.setText(paramView);
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getResources().getColor(2131166909));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130839011);
      localImageView.setTag(paramView);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a.isDiscussHrMeeting()) || (!bdfe.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a.mSelfRight))) {
        break label219;
      }
      localImageView.setEnabled(false);
    }
    for (;;)
    {
      if (AppSetting.c) {
        ViewCompat.setImportantForAccessibility(localImageView, 2);
      }
      localImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity);
      return paramViewGroup;
      localacqa = (acqa)paramView.getTag();
      paramViewGroup = paramView;
      break;
      label219:
      localImageView.setEnabled(true);
      continue;
      label228:
      if (paramInt > getCount() - 1)
      {
        localTextView.setText("");
        localImageView.setBackgroundDrawable(null);
        localImageView.setImageDrawable(null);
      }
      else
      {
        localImageView.setImageResource(2130844483);
        localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getResources().getColor(2131166901));
        String str = ((DiscussionMemberInfo)DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).get(paramInt)).memberUin;
        localacqa.jdField_a_of_type_JavaLangString = str;
        Object localObject = bdbt.c(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity), str);
        if (TextUtils.isEmpty(str))
        {
          paramView = (View)localObject;
          if (localObject == null) {
            paramView = "";
          }
          localTextView.setText(paramView);
          localImageView.setImageDrawable(bdda.b());
        }
        else
        {
          paramView = (View)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            paramView = (View)localObject;
            if (this.jdField_a_of_type_Aloz != null)
            {
              Friends localFriends = this.jdField_a_of_type_Aloz.e(str);
              paramView = (View)localObject;
              if (localFriends != null)
              {
                paramView = (View)localObject;
                if (localFriends.isFriend()) {
                  paramView = bdbt.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, str);
                }
              }
            }
          }
          localObject = paramView;
          if (TextUtils.isEmpty(paramView)) {
            localObject = str;
          }
          localTextView.setText((CharSequence)localObject);
          this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a(localacqa, null, true);
          localImageView.setTag(str);
          localImageView.setTag(2131377383, localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpz
 * JD-Core Version:    0.7.0.1
 */