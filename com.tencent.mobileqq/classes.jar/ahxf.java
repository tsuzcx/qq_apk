import QQService.EVIPSPEC;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class ahxf
  extends BaseAdapter
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView;
  
  public ahxf(SpecailCareListActivity paramSpecailCareListActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramSpecailCareListActivity.getSystemService("layout_inflater"));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.b.size();
    if (i > 0) {
      return i;
    }
    return 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.b.size()) {
      return this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.b.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.b.size() == 0) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    if (getItemViewType(paramInt) == 1)
    {
      localObject1 = paramView;
      if (paramView == null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495524, paramViewGroup, false);
        paramView = ((View)localObject1).getLayoutParams();
        if (paramView == null) {
          break label181;
        }
        paramView.height = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getHeight();
        paramView.width = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getWidth();
      }
      for (;;)
      {
        ((View)localObject1).setLayoutParams(paramView);
        paramInt = ((ajjj)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app.getManager(51)).a();
        paramView = (Button)((View)localObject1).findViewById(2131300046);
        if (QLog.isColorLevel()) {
          QLog.d("SpecialCare", 2, "getView  friends count = " + paramInt);
        }
        paramViewGroup = (TextView)((View)localObject1).findViewById(2131303534);
        localObject2 = (TextView)((View)localObject1).findViewById(2131303535);
        if (paramInt > 0) {
          break;
        }
        ((TextView)localObject2).setVisibility(8);
        paramView.setVisibility(8);
        localObject2 = localObject1;
        return localObject2;
        label181:
        paramView = new ViewGroup.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getHeight());
      }
      ((TextView)localObject2).setVisibility(0);
      paramView.setVisibility(0);
      paramViewGroup.setText(2131653831);
      paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
      return localObject1;
    }
    if (paramView != null)
    {
      localObject1 = (ahxh)paramView.getTag();
      label253:
      if (localObject1 != null) {
        break label1741;
      }
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495528, paramViewGroup, false);
      localObject1 = new ahxh();
      paramViewGroup.setTag(localObject1);
      ((ahxh)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131302061));
      ((ahxh)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131311221));
      ((ahxh)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131312449));
      ((ahxh)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131311223));
      ((ahxh)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131303072));
      ((ahxh)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131304677));
      ((ahxh)localObject1).d = ((ImageView)paramViewGroup.findViewById(2131297253));
      ((ahxh)localObject1).e = ((ImageView)paramViewGroup.findViewById(2131303063));
      ((ahxh)localObject1).f = ((ImageView)paramViewGroup.findViewById(2131303023));
      ((ahxh)localObject1).g = ((ImageView)paramViewGroup.findViewById(2131303025));
      ((ahxh)localObject1).jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131309982);
      ((ahxh)localObject1).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView = ((MutualMarkIconsView)paramViewGroup.findViewById(2131304936));
      ((ahxh)localObject1).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView = ((OnlineStatusView)paramViewGroup.findViewById(2131300194));
      ((ahxh)localObject1).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setViewStyle(2);
      ((ahxh)localObject1).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setTextSize(bajq.a(14.0F));
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
    }
    for (;;)
    {
      Friends localFriends = (Friends)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.b.get(paramInt);
      ((ahxh)localObject1).jdField_a_of_type_ComTencentMobileqqDataFriends = localFriends;
      ((ahxh)localObject1).jdField_a_of_type_JavaLangString = localFriends.uin;
      ((ahxh)localObject1).jdField_c_of_type_AndroidWidgetImageView.setTag(localFriends.uin);
      ((ahxh)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
      if (AppSetting.c) {
        ((ahxh)localObject1).jdField_c_of_type_AndroidWidgetImageView.setContentDescription(ajjy.a(2131648474));
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_Azwg.a(1, localFriends.uin, 0);
      if (paramView == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_Azwg.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_Azwg.a(localFriends.uin, 1, true);
        }
        ((ahxh)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((BitmapDrawable)bacm.a());
        label639:
        paramInt = babh.a(localFriends.detalStatusFlag, localFriends.iTermType);
        paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app.a(1);
        switch (paramInt)
        {
        case 5: 
        default: 
          paramView = paramView.a(localFriends.getLastLoginType());
          if (paramView == null) {
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131653880);
          }
          break;
        }
      }
      for (;;)
      {
        label741:
        label753:
        int i;
        label785:
        boolean bool;
        label889:
        String str;
        label934:
        int j;
        RelativeLayout.LayoutParams localLayoutParams1;
        RelativeLayout.LayoutParams localLayoutParams2;
        if ((paramInt == 0) || (paramInt == 6))
        {
          paramInt = 1;
          if (!((ahxh)localObject1).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.a(localFriends)) {
            break label1491;
          }
          ((ahxh)localObject1).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(0);
          ((ahxh)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.a(localFriends, (ahxh)localObject1);
          ((ahxh)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          i = 0;
          if (paramInt == 0) {
            i = localFriends.netTypeIconId;
          }
          bool = awnu.b();
          if ((paramInt != 0) || (bool) || ((!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
            break label1547;
          }
          ((ahxh)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getResources().getColorStateList(2131101389));
          if ((bool) || (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))) {
            break label1571;
          }
          ((ahxh)localObject1).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_Int);
          ((ahxh)localObject1).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130849129, 0);
          str = babh.a(localFriends);
          ((ahxh)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(str);
          ((ahxh)localObject1).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app, localFriends.uin, 4);
          j = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.a(paramViewGroup, (ahxh)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.c);
          localObject2 = new RelativeLayout.LayoutParams((int)(50.0F * SpecailCareListActivity.k(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), (int)(50.0F * SpecailCareListActivity.l(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)));
          ((RelativeLayout.LayoutParams)localObject2).addRule(15);
          localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams1.addRule(1, 2131302061);
          localLayoutParams1.addRule(10);
          localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams2.addRule(1, 2131302061);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.c) {
            break label1634;
          }
          ((ahxh)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          ((ahxh)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(4);
          ((ahxh)localObject1).d.setVisibility(0);
          ((RelativeLayout.LayoutParams)localObject2).setMargins((int)(46.0F * SpecailCareListActivity.m(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, (int)(10.0F * SpecailCareListActivity.n(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0);
          int k = (int)(22.0F * SpecailCareListActivity.o(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity));
          float f = SpecailCareListActivity.p(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
          localLayoutParams1.setMargins(0, k, (int)(j + 23.0F * f), 0);
          localLayoutParams2.setMargins(0, (int)(24.0F * SpecailCareListActivity.q(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, 0);
        }
        for (;;)
        {
          ((ahxh)localObject1).jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((ahxh)localObject1).jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams1);
          localObject2 = paramViewGroup;
          if (!AppSetting.c) {
            break;
          }
          localObject2 = new StringBuilder(24);
          ((StringBuilder)localObject2).append(str).append(".").append(paramView).append(".");
          if ((localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
            ((StringBuilder)localObject2).append("QQ会员").append(".");
          }
          ((StringBuilder)localObject2).append(((ahxh)localObject1).jdField_b_of_type_AndroidWidgetTextView.getText()).append(".");
          if (paramInt == 0) {
            ((StringBuilder)localObject2).append(babh.b(i));
          }
          if (!TextUtils.isEmpty(((ahxh)localObject1).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a)) {
            ((StringBuilder)localObject2).append(((ahxh)localObject1).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a.toString());
          }
          paramViewGroup.setContentDescription((CharSequence)localObject2);
          return paramViewGroup;
          localObject1 = null;
          break label253;
          ((ahxh)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramView));
          break label639;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131653865);
          break label741;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131653868);
          break label741;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131653874);
          break label741;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131653882);
          break label741;
          paramView = "";
          break label741;
          paramView = babh.a(localFriends.netTypeIconId);
          break label741;
          paramInt = 0;
          break label753;
          label1491:
          ((ahxh)localObject1).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(8);
          ((ahxh)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          ((ahxh)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText("[" + paramView + "]");
          break label785;
          label1547:
          ((ahxh)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getResources().getColorStateList(2131101260));
          break label889;
          label1571:
          if ((!bool) && (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))
          {
            ((ahxh)localObject1).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_Int);
            ((ahxh)localObject1).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130849409, 0);
            break label934;
          }
          ((ahxh)localObject1).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label934;
          label1634:
          ((ahxh)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          ((ahxh)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((ahxh)localObject1).d.setVisibility(8);
          ((RelativeLayout.LayoutParams)localObject2).setMargins((int)(12.0F * SpecailCareListActivity.r(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, (int)(10.0F * SpecailCareListActivity.s(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0);
          localLayoutParams1.setMargins(0, (int)(10.0F * SpecailCareListActivity.t(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), j, 0);
          localLayoutParams2.setMargins(0, (int)(36.0F * SpecailCareListActivity.u(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, 0);
        }
      }
      label1741:
      paramViewGroup = paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahxf
 * JD-Core Version:    0.7.0.1
 */