import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class abbo
  extends BaseAdapter
{
  RelativeSizeSpan jdField_a_of_type_AndroidTextStyleRelativeSizeSpan = new RelativeSizeSpan(0.62F);
  String jdField_a_of_type_JavaLangString;
  List<LikeRankingInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  int[] jdField_a_of_type_ArrayOfInt = { 2130844434, 2130844435, 2130844436 };
  String jdField_b_of_type_JavaLangString;
  int[] jdField_b_of_type_ArrayOfInt = { 2130844431, 2130844432, 2130844433 };
  
  public abbo(LikeRankingListActivity paramLikeRankingListActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramLikeRankingListActivity.getString(2131654451);
    this.jdField_a_of_type_JavaLangString = paramLikeRankingListActivity.getString(2131628171);
  }
  
  public LikeRankingInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (LikeRankingInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<LikeRankingInfo> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    LikeRankingInfo localLikeRankingInfo1 = this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo;
    int i = paramList.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        LikeRankingInfo localLikeRankingInfo2 = (LikeRankingInfo)paramList.get(i);
        if (localLikeRankingInfo2.uin == this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.uin) {
          this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo = localLikeRankingInfo2;
        }
      }
      else
      {
        if ((this.jdField_a_of_type_JavaUtilList.size() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.rankingNum > 3) && (this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.likeCountOfToday > 0)) {
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo);
        }
        if (QLog.isColorLevel()) {
          QLog.i("LikeRankingListActivity", 2, String.format("setList isServer:%s oldRankInfo:%s newRankInfo:%s size:%d", new Object[] { Boolean.valueOf(paramBoolean), localLikeRankingInfo1, this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo, Integer.valueOf(paramList.size()) }));
        }
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        this.jdField_a_of_type_Boolean = false;
        notifyDataSetChanged();
        return;
      }
      i -= 1;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getCount() - 1) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 8;
    int i = 0;
    int k = getItemViewType(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {}
    switch (k)
    {
    default: 
      paramViewGroup = paramView;
      switch (k)
      {
      }
      break;
    }
    LikeRankingInfo localLikeRankingInfo;
    do
    {
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity).inflate(2131495243, null);
      paramView = new abbq(this);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131312476));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131303027));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131302881));
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131302880));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131312440));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131312564));
      paramView.d = ((TextView)paramViewGroup.findViewById(2131312413));
      paramView.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131299701);
      paramViewGroup.setTag(paramView);
      break;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity).inflate(2131493742, null);
      paramView = new abbp(this);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131304782));
      paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131309309));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131303806));
      paramViewGroup.setTag(paramView);
      break;
      localLikeRankingInfo = a(paramInt);
    } while (localLikeRankingInfo == null);
    abbq localabbq = (abbq)paramViewGroup.getTag();
    localabbq.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
    String str;
    if ((paramInt == 0) && (localLikeRankingInfo.uin == this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.uin) && ((localLikeRankingInfo.rankingNum > 3) || (localLikeRankingInfo.rankingNum < 1)))
    {
      localabbq.jdField_a_of_type_AndroidViewView.setVisibility(0);
      str = String.valueOf(localLikeRankingInfo.uin);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_Ajjj.e(str);
      if (paramView == null) {
        break label634;
      }
      localabbq.jdField_b_of_type_AndroidWidgetTextView.setText(paramView.getFriendNick());
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_Azwg.a(1, str);
      paramView = (View)localObject;
      if (localObject == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_Azwg.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_Azwg.a(str, 1, true);
        }
        paramView = bacm.a();
      }
      localabbq.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
      label462:
      switch (localLikeRankingInfo.rankingNum)
      {
      default: 
        if (localLikeRankingInfo.rankingNum < 1) {
          localabbq.jdField_a_of_type_AndroidWidgetTextView.setText("-");
        }
        break;
      }
    }
    for (;;)
    {
      localabbq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localabbq.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      for (;;)
      {
        paramView = new SpannableString(String.format(Locale.CHINA, this.jdField_a_of_type_JavaLangString, new Object[] { Integer.valueOf(localLikeRankingInfo.likeCountOfToday) }));
        paramView.setSpan(this.jdField_a_of_type_AndroidTextStyleRelativeSizeSpan, 0, 1, 33);
        localabbq.d.setText(paramView);
        localabbq.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_b_of_type_JavaLangString, new Object[] { Integer.valueOf(localLikeRankingInfo.totalLikeCount) }));
        return paramViewGroup;
        localabbq.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break;
        label634:
        localabbq.jdField_b_of_type_AndroidWidgetTextView.setText(str);
        localabbq.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(bacm.a());
        break label462;
        localabbq.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localLikeRankingInfo.rankingNum));
        localabbq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localabbq.jdField_b_of_type_AndroidWidgetImageView.setImageResource(this.jdField_b_of_type_ArrayOfInt[(localLikeRankingInfo.rankingNum - 1)]);
        localabbq.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      localabbq.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localLikeRankingInfo.rankingNum));
    }
    paramView = (abbp)paramViewGroup.getTag();
    Object localObject = paramView.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 2131628336;
      ((TextView)localObject).setText(paramInt);
      localObject = paramView.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label831;
      }
      paramInt = 0;
      label781:
      ((ProgressBar)localObject).setVisibility(paramInt);
      paramView = paramView.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label837;
      }
      paramInt = j;
      label802:
      paramView.setVisibility(paramInt);
      if (!this.jdField_a_of_type_Boolean) {
        break label842;
      }
    }
    label831:
    label837:
    label842:
    for (paramInt = i;; paramInt = 4)
    {
      paramViewGroup.setVisibility(paramInt);
      return paramViewGroup;
      paramInt = 2131628666;
      break;
      paramInt = 8;
      break label781;
      paramInt = 0;
      break label802;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abbo
 * JD-Core Version:    0.7.0.1
 */