import android.graphics.Bitmap;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class aewr
  extends BaseAdapter
{
  RelativeSizeSpan jdField_a_of_type_AndroidTextStyleRelativeSizeSpan = new RelativeSizeSpan(0.62F);
  String jdField_a_of_type_JavaLangString;
  List<LikeRankingInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  int[] jdField_a_of_type_ArrayOfInt = { 2130845369, 2130845370, 2130845371 };
  String jdField_b_of_type_JavaLangString;
  int[] jdField_b_of_type_ArrayOfInt = { 2130845366, 2130845367, 2130845368 };
  
  public aewr(LikeRankingListActivity paramLikeRankingListActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramLikeRankingListActivity.getString(2131718779);
    this.jdField_a_of_type_JavaLangString = paramLikeRankingListActivity.getString(2131693258);
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
    int k = 8;
    int j = 0;
    int i = getItemViewType(paramInt);
    if (paramView == null) {}
    switch (i)
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    LikeRankingInfo localLikeRankingInfo;
    do
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity).inflate(2131561274, null);
      localObject1 = new aewt(this);
      ((aewt)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380022));
      ((aewt)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369340));
      ((aewt)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369132));
      ((aewt)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369131));
      ((aewt)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379965));
      ((aewt)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380158));
      ((aewt)localObject1).d = ((TextView)paramView.findViewById(2131379926));
      ((aewt)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365632);
      paramView.setTag(localObject1);
      break;
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity).inflate(2131559485, null);
      localObject1 = new aews(this);
      ((aews)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371433));
      ((aews)localObject1).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131376445));
      ((aews)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370293));
      paramView.setTag(localObject1);
      break;
      localLikeRankingInfo = a(paramInt);
    } while (localLikeRankingInfo == null);
    aewt localaewt = (aewt)paramView.getTag();
    localaewt.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
    label384:
    String str;
    if ((paramInt == 0) && (localLikeRankingInfo.uin == this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.uin) && ((localLikeRankingInfo.rankingNum > 3) || (localLikeRankingInfo.rankingNum < 1)))
    {
      localaewt.jdField_a_of_type_AndroidViewView.setVisibility(0);
      str = String.valueOf(localLikeRankingInfo.uin);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_Anyw.e(str);
      if (localObject1 == null) {
        break label670;
      }
      localaewt.jdField_b_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).getFriendNick());
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_Aoof.a(1, str);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_Aoof.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_Aoof.a(str, 1, true);
        }
        localObject1 = bhmq.a();
      }
      localaewt.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
      label493:
      switch (localLikeRankingInfo.rankingNum)
      {
      default: 
        if (localLikeRankingInfo.rankingNum < 1) {
          localaewt.jdField_a_of_type_AndroidWidgetTextView.setText("-");
        }
        break;
      }
    }
    for (;;)
    {
      localaewt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localaewt.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      for (;;)
      {
        localObject1 = new SpannableString(String.format(Locale.CHINA, this.jdField_a_of_type_JavaLangString, new Object[] { Integer.valueOf(localLikeRankingInfo.likeCountOfToday) }));
        ((SpannableString)localObject1).setSpan(this.jdField_a_of_type_AndroidTextStyleRelativeSizeSpan, 0, 1, 33);
        localaewt.d.setText((CharSequence)localObject1);
        localaewt.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_b_of_type_JavaLangString, new Object[] { Integer.valueOf(localLikeRankingInfo.totalLikeCount) }));
        break;
        localaewt.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break label384;
        label670:
        localaewt.jdField_b_of_type_AndroidWidgetTextView.setText(str);
        localaewt.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(bhmq.a());
        break label493;
        localaewt.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localLikeRankingInfo.rankingNum));
        localaewt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localaewt.jdField_b_of_type_AndroidWidgetImageView.setImageResource(this.jdField_b_of_type_ArrayOfInt[(localLikeRankingInfo.rankingNum - 1)]);
        localaewt.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      localaewt.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localLikeRankingInfo.rankingNum));
    }
    Object localObject1 = (aews)paramView.getTag();
    Object localObject2 = ((aews)localObject1).jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131693403;
      label799:
      ((TextView)localObject2).setText(i);
      localObject2 = ((aews)localObject1).jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label883;
      }
      i = 0;
      label823:
      ((ProgressBar)localObject2).setVisibility(i);
      localObject1 = ((aews)localObject1).jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label890;
      }
      i = k;
      label848:
      ((ImageView)localObject1).setVisibility(i);
      if (!this.jdField_a_of_type_Boolean) {
        break label896;
      }
    }
    label896:
    for (i = j;; i = 4)
    {
      paramView.setVisibility(i);
      break;
      i = 2131693764;
      break label799;
      label883:
      i = 8;
      break label823;
      label890:
      i = 0;
      break label848;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aewr
 * JD-Core Version:    0.7.0.1
 */