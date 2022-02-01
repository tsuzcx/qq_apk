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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class advg
  extends BaseAdapter
{
  private anvk jdField_a_of_type_Anvk;
  
  public advg(DiscussionInfoCardActivity paramDiscussionInfoCardActivity)
  {
    this.jdField_a_of_type_Anvk = ((anvk)paramDiscussionInfoCardActivity.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
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
    advh localadvh;
    TextView localTextView;
    ImageView localImageView;
    Object localObject1;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getLayoutInflater().inflate(2131558902, null);
      localadvh = new advh();
      localadvh.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368381));
      localadvh.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371803));
      localView.setTag(localadvh);
      localView.setVisibility(0);
      localView.setFocusable(false);
      localTextView = localadvh.jdField_a_of_type_AndroidWidgetTextView;
      localImageView = localadvh.jdField_a_of_type_AndroidWidgetImageView;
      if (paramInt != getCount() - 1) {
        break label253;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getString(2131693371);
      localTextView.setText((CharSequence)localObject1);
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getResources().getColor(2131167034));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130839242);
      localImageView.setTag(localObject1);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a.isDiscussHrMeeting()) || (!bhgf.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a.mSelfRight))) {
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
      localadvh = (advh)paramView.getTag();
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
        localImageView.setImageResource(2130844919);
        localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getResources().getColor(2131167026));
        String str = ((DiscussionMemberInfo)DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).get(paramInt)).memberUin;
        localadvh.jdField_a_of_type_JavaLangString = str;
        Object localObject2 = ContactUtils.getDiscussionMemberShowName(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity), str);
        if (TextUtils.isEmpty(str))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localTextView.setText((CharSequence)localObject1);
          localImageView.setImageDrawable(bheg.b());
        }
        else
        {
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_Anvk != null)
            {
              Friends localFriends = this.jdField_a_of_type_Anvk.e(str);
              localObject1 = localObject2;
              if (localFriends != null)
              {
                localObject1 = localObject2;
                if (localFriends.isFriend()) {
                  localObject1 = ContactUtils.getFriendNick(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, str);
                }
              }
            }
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = str;
          }
          localTextView.setText((CharSequence)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a(localadvh, null, true);
          localImageView.setTag(str);
          localImageView.setTag(2131378478, localObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advg
 * JD-Core Version:    0.7.0.1
 */