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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class alyt
  extends BaseAdapter
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView;
  
  public alyt(SpecailCareListActivity paramSpecailCareListActivity)
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
    int i;
    Object localObject2;
    Object localObject3;
    if (getItemViewType(paramInt) == 1)
    {
      localObject1 = paramView;
      if (paramView == null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561546, paramViewGroup, false);
        paramView = ((View)localObject1).getLayoutParams();
        if (paramView != null)
        {
          paramView.height = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getHeight();
          paramView.width = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getWidth();
          ((View)localObject1).setLayoutParams(paramView);
        }
      }
      else
      {
        i = ((anmw)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app.getManager(51)).a();
        paramView = (Button)((View)localObject1).findViewById(2131365970);
        if (QLog.isColorLevel()) {
          QLog.d("SpecialCare", 2, "getView  friends count = " + i);
        }
        localObject2 = (TextView)((View)localObject1).findViewById(2131369849);
        localObject3 = (TextView)((View)localObject1).findViewById(2131369850);
        if (i > 0) {
          break label229;
        }
        ((TextView)localObject3).setVisibility(8);
        paramView.setVisibility(8);
      }
      for (;;)
      {
        paramView = (View)localObject1;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject1;
        paramView = new ViewGroup.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getHeight());
        break;
        label229:
        ((TextView)localObject3).setVisibility(0);
        paramView.setVisibility(0);
        ((TextView)localObject2).setText(2131718188);
        paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
      }
    }
    if (paramView != null)
    {
      localObject1 = (alyv)paramView.getTag();
      label271:
      if (localObject1 != null) {
        break label1794;
      }
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561550, paramViewGroup, false);
      localObject2 = new alyv();
      ((View)localObject1).setTag(localObject2);
      ((alyv)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131368138));
      ((alyv)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131378446));
      ((alyv)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131379800));
      ((alyv)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131378448));
      ((alyv)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369312));
      ((alyv)localObject2).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131371209));
      ((alyv)localObject2).d = ((ImageView)((View)localObject1).findViewById(2131362937));
      ((alyv)localObject2).e = ((ImageView)((View)localObject1).findViewById(2131369302));
      ((alyv)localObject2).f = ((ImageView)((View)localObject1).findViewById(2131369246));
      ((alyv)localObject2).g = ((ImageView)((View)localObject1).findViewById(2131369248));
      ((alyv)localObject2).jdField_a_of_type_AndroidViewView = ((View)localObject1).findViewById(2131377074);
      ((alyv)localObject2).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView = ((MutualMarkIconsView)((View)localObject1).findViewById(2131371490));
      ((alyv)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView = ((OnlineStatusView)((View)localObject1).findViewById(2131366133));
      ((alyv)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setViewStyle(2);
      ((alyv)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setTextSize(bgtn.a(14.0F));
      ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
    }
    for (;;)
    {
      localObject3 = (Friends)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.b.get(paramInt);
      ((alyv)localObject2).jdField_a_of_type_ComTencentMobileqqDataFriends = ((Friends)localObject3);
      ((alyv)localObject2).jdField_a_of_type_JavaLangString = ((Friends)localObject3).uin;
      ((alyv)localObject2).jdField_c_of_type_AndroidWidgetImageView.setTag(((Friends)localObject3).uin);
      ((alyv)localObject2).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
      if (AppSetting.c) {
        ((alyv)localObject2).jdField_c_of_type_AndroidWidgetImageView.setContentDescription(anni.a(2131712998));
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_Aobu.a(1, ((Friends)localObject3).uin, 0);
      if (paramView == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_Aobu.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_Aobu.a(((Friends)localObject3).uin, 1, true);
        }
        ((alyv)localObject2).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((BitmapDrawable)bgmo.a());
        label673:
        i = bglf.a(((Friends)localObject3).detalStatusFlag, ((Friends)localObject3).iTermType);
        paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app.a(1);
        switch (i)
        {
        case 5: 
        default: 
          paramView = paramView.a(((Friends)localObject3).getLastLoginType());
          if (paramView == null) {
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131718210);
          }
          break;
        }
      }
      for (;;)
      {
        label777:
        label792:
        label831:
        int j;
        boolean bool;
        label937:
        label982:
        String str;
        int k;
        Object localObject4;
        RelativeLayout.LayoutParams localLayoutParams1;
        RelativeLayout.LayoutParams localLayoutParams2;
        if ((i == 0) || (i == 6))
        {
          i = 1;
          if (!((alyv)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app, (Friends)localObject3)) {
            break label1544;
          }
          ((alyv)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(0);
          ((alyv)localObject2).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.a((Friends)localObject3, (alyv)localObject2);
          ((alyv)localObject2).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          j = 0;
          if (i == 0) {
            j = ((Friends)localObject3).netTypeIconId;
          }
          bool = bcnj.b();
          if ((i != 0) || (bool) || ((!((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
            break label1600;
          }
          ((alyv)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getResources().getColorStateList(2131167121));
          if ((bool) || (!((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))) {
            break label1624;
          }
          ((alyv)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_Int);
          ((alyv)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130850473, 0);
          str = bglf.a((Friends)localObject3);
          ((alyv)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(str);
          ((alyv)localObject2).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app, ((Friends)localObject3).uin, 4);
          k = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.a((View)localObject1, (alyv)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.c);
          localObject4 = new RelativeLayout.LayoutParams((int)(50.0F * SpecailCareListActivity.k(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), (int)(50.0F * SpecailCareListActivity.l(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)));
          ((RelativeLayout.LayoutParams)localObject4).addRule(15);
          localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams1.addRule(1, 2131368138);
          localLayoutParams1.addRule(10);
          localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams2.addRule(1, 2131368138);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.c) {
            break label1687;
          }
          ((alyv)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          ((alyv)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(4);
          ((alyv)localObject2).d.setVisibility(0);
          ((RelativeLayout.LayoutParams)localObject4).setMargins((int)(46.0F * SpecailCareListActivity.m(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, (int)(10.0F * SpecailCareListActivity.n(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0);
          int m = (int)(22.0F * SpecailCareListActivity.o(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity));
          float f = SpecailCareListActivity.p(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
          localLayoutParams1.setMargins(0, m, (int)(k + 23.0F * f), 0);
          localLayoutParams2.setMargins(0, (int)(24.0F * SpecailCareListActivity.q(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, 0);
        }
        for (;;)
        {
          ((alyv)localObject2).jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          ((alyv)localObject2).jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams1);
          if (AppSetting.c)
          {
            localObject4 = new StringBuilder(24);
            ((StringBuilder)localObject4).append(str).append(".").append(paramView).append(".");
            if ((((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
              ((StringBuilder)localObject4).append("QQ会员").append(".");
            }
            ((StringBuilder)localObject4).append(((alyv)localObject2).jdField_b_of_type_AndroidWidgetTextView.getText()).append(".");
            if (i == 0) {
              ((StringBuilder)localObject4).append(bglf.b(j));
            }
            if (!TextUtils.isEmpty(((alyv)localObject2).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a)) {
              ((StringBuilder)localObject4).append(((alyv)localObject2).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a.toString());
            }
            ((View)localObject1).setContentDescription((CharSequence)localObject4);
          }
          paramView = (View)localObject1;
          break;
          localObject1 = null;
          break label271;
          ((alyv)localObject2).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramView));
          break label673;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131718201);
          break label777;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131718203);
          break label777;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131718207);
          break label777;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131718212);
          break label777;
          paramView = "";
          break label777;
          paramView = bglf.a(((Friends)localObject3).netTypeIconId);
          break label777;
          i = 0;
          break label792;
          label1544:
          ((alyv)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(8);
          ((alyv)localObject2).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          ((alyv)localObject2).jdField_c_of_type_AndroidWidgetTextView.setText("[" + paramView + "]");
          break label831;
          label1600:
          ((alyv)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getResources().getColorStateList(2131166986));
          break label937;
          label1624:
          if ((!bool) && (((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))
          {
            ((alyv)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_Int);
            ((alyv)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130850763, 0);
            break label982;
          }
          ((alyv)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label982;
          label1687:
          ((alyv)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          ((alyv)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((alyv)localObject2).d.setVisibility(8);
          ((RelativeLayout.LayoutParams)localObject4).setMargins((int)(12.0F * SpecailCareListActivity.r(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, (int)(10.0F * SpecailCareListActivity.s(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0);
          localLayoutParams1.setMargins(0, (int)(10.0F * SpecailCareListActivity.t(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), k, 0);
          localLayoutParams2.setMargins(0, (int)(36.0F * SpecailCareListActivity.u(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, 0);
        }
      }
      label1794:
      localObject2 = localObject1;
      localObject1 = paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alyt
 * JD-Core Version:    0.7.0.1
 */