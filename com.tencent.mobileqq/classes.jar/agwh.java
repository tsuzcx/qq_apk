import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.widget.RatioLayout;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;
import java.util.List;

class agwh
  implements Runnable
{
  agwh(agwg paramagwg, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int k = ProfileTagView.a().length - 1;
      int i;
      if (this.jdField_a_of_type_JavaUtilList.size() >= k)
      {
        i = k;
        if ((!this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.c) || (this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.d) || (this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.jdField_a_of_type_ArrayOfAndroidViewView[k] == null) || (i != 0)) {
          break label341;
        }
        this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.b.setVisibility(0);
      }
      Object localObject2;
      Object localObject1;
      for (;;)
      {
        if ((this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) && (this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.jdField_a_of_type_ArrayOfAndroidViewView[k] == null))
        {
          localObject2 = this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.jdField_a_of_type_ArrayOfAndroidViewView;
          localObject1 = View.inflate(this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getContext(), 2130971053, null);
          localObject2[k] = localObject1;
          localObject2 = new RatioLayout.LayoutParams(-2, -2, 0.5F, 0.5F, 0.5F, 0.5F);
          this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          ((View)localObject1).setVisibility(4);
          ((View)localObject1).setTag(new DataTag(32, null));
          ((View)localObject1).setOnClickListener(this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((View)localObject1).setId(2131362045);
          ((View)localObject1).setTag(2131362045, Integer.valueOf(-1));
          ((View)localObject1).setTag(2131362044, Integer.valueOf(ProfileTagView.a().length - 1));
        }
        j = 0;
        while (j < k)
        {
          localObject1 = this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.jdField_a_of_type_ArrayOfAndroidViewView[j];
          if (((localObject1 instanceof VipTagView)) && (((View)localObject1).getVisibility() != 8))
          {
            ((VipTagView)localObject1).setShakingState(false);
            ((View)localObject1).setVisibility(8);
          }
          j += 1;
        }
        i = this.jdField_a_of_type_JavaUtilList.size();
        break;
        label341:
        this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.b.setVisibility(4);
      }
      int j = 0;
      if (j < i)
      {
        localObject2 = (ProfileLabelInfo)this.jdField_a_of_type_JavaUtilList.get(j);
        if (this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.jdField_a_of_type_ArrayOfAndroidViewView[j] == null)
        {
          localObject1 = new VipTagView(this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getContext());
          this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.jdField_a_of_type_ArrayOfAndroidViewView[j] = localObject1;
          this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.addView((View)localObject1);
          ((VipTagView)localObject1).setGravity(17);
          ((VipTagView)localObject1).setTag(2131362045, Integer.valueOf(j));
          ((VipTagView)localObject1).setTag(2131362044, Integer.valueOf(ProfileTagView.a()[j]));
          ((VipTagView)localObject1).setTextColor(-1);
        }
        VipTagView localVipTagView = (VipTagView)this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.jdField_a_of_type_ArrayOfAndroidViewView[j];
        if ((this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.c) && (!this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.d))
        {
          localObject1 = ProfileTagView.a()[ProfileTagView.a()[j]];
          localObject1 = new RatioLayout.LayoutParams(-2, -2, 0.5F, 0.5F, ((PointF)localObject1).x, ((PointF)localObject1).y);
          localVipTagView.setVisibility(0);
          localVipTagView.setShakingState(true);
          label575:
          localVipTagView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localVipTagView.setLabelAndPraise(((ProfileLabelInfo)localObject2).labelName, ((ProfileLabelInfo)localObject2).likeNum.intValue());
          localVipTagView.setTag(2131362047, ((ProfileLabelInfo)localObject2).labelId);
          if ((!this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.a(localVipTagView)) || (this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)) {
            break label715;
          }
          localVipTagView.setTagColor(this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getResources().getColor(2131493147), this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getResources().getColor(2131493146));
        }
        for (;;)
        {
          j += 1;
          break;
          localObject1 = new RatioLayout.LayoutParams(-2, -2, 0.5F, 0.5F, 0.5F, 0.5F);
          localVipTagView.setVisibility(4);
          break label575;
          label715:
          localVipTagView.setTagColor(this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getResources().getColor(2131493145), this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getResources().getColor(2131493144));
        }
      }
    }
    this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.b((int)this.jdField_a_of_type_Agwg.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agwh
 * JD-Core Version:    0.7.0.1
 */