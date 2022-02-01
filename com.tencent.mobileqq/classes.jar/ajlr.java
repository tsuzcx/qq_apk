import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.contacts.topentry.MayknowRecommendsAdapter.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class ajlr
  extends amck
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  Context jdField_a_of_type_AndroidContentContext;
  Resources jdField_a_of_type_AndroidContentResResources;
  anpk jdField_a_of_type_Anpk;
  private bkhe jdField_a_of_type_Bkhe = new ajls(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected Runnable a;
  List<MayKnowRecommend> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ajlr(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
    this.jdField_a_of_type_JavaLangRunnable = new MayknowRecommendsAdapter.2(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Anpk = ((anpk)paramQQAppInterface.getManager(159));
    a(this.jdField_a_of_type_Bkhe);
  }
  
  private void a(ajlt paramajlt)
  {
    Object localObject = paramajlt.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.getRichStatus();
    StringBuilder localStringBuilder = new StringBuilder();
    if (((RichStatus)localObject).actionText != null) {
      localStringBuilder.append("actionText:").append(((RichStatus)localObject).actionText);
    }
    if (((RichStatus)localObject).dataText != null) {
      localStringBuilder.append("dataText:").append(((RichStatus)localObject).dataText);
    }
    localStringBuilder.append("plainText:");
    localObject = ((RichStatus)localObject).getPlainText();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localStringBuilder.append((String)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.i("contacts.RecommendsAdapter", 2, "updateRichStatus, content=" + localStringBuilder + "  uin:" + paramajlt.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.uin);
    }
  }
  
  private void a(MayKnowRecommend paramMayKnowRecommend)
  {
    Object localObject;
    boolean bool2;
    if ((paramMayKnowRecommend != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      localObject = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((((anmw)localObject).b(paramMayKnowRecommend.uin)) || (((anmw)localObject).d(paramMayKnowRecommend.uin))) {
        break label258;
      }
      bool2 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
      if (this.jdField_a_of_type_Anpk == null) {
        break label300;
      }
    }
    label258:
    label300:
    for (boolean bool1 = this.jdField_a_of_type_Anpk.a();; bool1 = false)
    {
      localObject = paramMayKnowRecommend.getDisplayName(bool1);
      int i = 3045;
      if (bool2) {
        i = 3083;
      }
      for (int j = 1;; j = 24)
      {
        localObject = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, paramMayKnowRecommend.uin, null, i, j, (String)localObject, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689550), null);
        ((Intent)localObject).putExtra("key_param_age_area", bghy.a(this.jdField_a_of_type_AndroidContentContext, paramMayKnowRecommend.gender, paramMayKnowRecommend.age, paramMayKnowRecommend.country, paramMayKnowRecommend.province, paramMayKnowRecommend.city));
        ((Intent)localObject).putExtra("from_babyq", bool2);
        ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivity((Intent)localObject);
        for (;;)
        {
          if (this.jdField_a_of_type_Anpk != null) {
            this.jdField_a_of_type_Anpk.a(paramMayKnowRecommend, 24, 0, 3);
          }
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMayKnowRecommend.uin, "frd_list_add", 24, 1, paramMayKnowRecommend.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(paramMayKnowRecommend), paramMayKnowRecommend.algBuffer, 0, "1");
          return;
          if (((anmw)localObject).b(paramMayKnowRecommend.uin))
          {
            paramMayKnowRecommend.friendStatus = 2;
            notifyDataSetChanged();
          }
          else
          {
            paramMayKnowRecommend.friendStatus = 1;
            notifyDataSetChanged();
          }
        }
      }
    }
  }
  
  public void a()
  {
    super.c();
    a(null);
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_Anpk = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
  }
  
  public void a(List<MayKnowRecommend> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    notifyDataSetChanged();
  }
  
  public void b()
  {
    e();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.RecommendsAdapter", 2, "onResume firstVisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      anpk localanpk = (anpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition())
      {
        if ((i >= 0) && (i < getCount())) {
          localanpk.a((MayKnowRecommend)getItem(i), 24, 0, 1);
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("contacts.RecommendsAdapter", 2, "stopVisibleExpose firstVisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
      }
      if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        anpk localanpk = (anpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
        int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
        while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition())
        {
          if ((i >= 0) && (i < getCount())) {
            localanpk.b((MayKnowRecommend)getItem(i), 24, 0, 1);
          }
          i += 1;
        }
      }
    } while (this.jdField_a_of_type_ComTencentWidgetXListView == null);
    this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      int j = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      int k = this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      int i = j;
      while (i <= k)
      {
        if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_JavaUtilList.get(i) != null))
        {
          localArrayList1.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).uin);
          localArrayList2.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).recommendReason);
          localArrayList3.add(Integer.valueOf(i));
          localArrayList4.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).algBuffer);
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("contacts.RecommendsAdapter", 2, "reportRecommendFrdExpose firstVisibleItem: " + j + " lastVisibleItem: " + k + " exp_uins: " + localArrayList1 + " exp_reasons:" + localArrayList2 + " exp_positions:" + localArrayList3 + " algh_ids:" + localArrayList4);
      }
      if ((!localArrayList1.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
        ContactReportUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 24, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 0, "1");
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return new MayKnowRecommend();
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if ((this.jdField_a_of_type_AndroidContentResResources == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    Object localObject2;
    Object localObject3;
    if (paramView == null)
    {
      localObject2 = new ajlt();
      localObject3 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558965, paramViewGroup, false);
      ((ajlt)localObject2).c = ((ImageView)((View)localObject3).findViewById(2131361795));
      ((ajlt)localObject2).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject3).findViewById(2131371720));
      ((ajlt)localObject2).b = ((SingleLineTextView)((View)localObject3).findViewById(2131376456));
      ((ajlt)localObject2).jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject3).findViewById(2131376443));
      ((ajlt)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject3).findViewById(2131376453));
      ((ajlt)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject3).findViewById(2131365319));
      ((View)localObject3).setTag(localObject2);
      localObject1 = localObject2;
      paramView = (View)localObject3;
      if ((((ajlt)localObject2).c instanceof ThemeImageView))
      {
        ((ThemeImageView)((ajlt)localObject2).c).setSupportMaskView(false);
        paramView = (View)localObject3;
        localObject1 = localObject2;
      }
      label211:
      localObject2 = (MayKnowRecommend)getItem(paramInt);
      ((ajlt)localObject1).jdField_a_of_type_JavaLangString = ((MayKnowRecommend)localObject2).uin;
      ((ajlt)localObject1).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = ((MayKnowRecommend)localObject2);
      if (this.jdField_a_of_type_Anpk == null) {
        break label810;
      }
    }
    label656:
    label669:
    label810:
    for (boolean bool = this.jdField_a_of_type_Anpk.a();; bool = false)
    {
      Object localObject4 = ((MayKnowRecommend)localObject2).getDisplayName(bool);
      localObject3 = new StringBuilder(512);
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        ((ajlt)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
        ((ajlt)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject4);
        if (AppSetting.c) {
          ((StringBuilder)localObject3).append((String)localObject4);
        }
        label316:
        localObject4 = new StringBuilder();
        if (!TextUtils.isEmpty(((MayKnowRecommend)localObject2).category)) {
          ((StringBuilder)localObject4).append(((MayKnowRecommend)localObject2).category).append(" ");
        }
        if (!TextUtils.isEmpty(((MayKnowRecommend)localObject2).recommendReason)) {
          ((StringBuilder)localObject4).append(((MayKnowRecommend)localObject2).recommendReason);
        }
        localObject4 = ((StringBuilder)localObject4).toString();
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          break label656;
        }
        ((ajlt)localObject1).b.setVisibility(0);
        ((ajlt)localObject1).b.setText((CharSequence)localObject4);
        if (AppSetting.c) {
          ((StringBuilder)localObject3).append(",").append((String)localObject4);
        }
        label429:
        if (((MayKnowRecommend)localObject2).friendStatus != 0) {
          break label669;
        }
        ((ajlt)localObject1).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        ((ajlt)localObject1).jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        ((ajlt)localObject1).jdField_a_of_type_AndroidWidgetButton.setTag(localObject2);
        ((ajlt)localObject1).jdField_a_of_type_AndroidWidgetButton.setText(anni.a(2131689550));
        ((ajlt)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        if (AppSetting.c)
        {
          ((StringBuilder)localObject3).append(",点击添加");
          ((ajlt)localObject1).jdField_a_of_type_AndroidWidgetButton.setContentDescription(anni.a(2131689550));
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          a((ajlt)localObject1);
        }
        if (this.jdField_a_of_type_Anpk != null) {
          this.jdField_a_of_type_Anpk.a((MayKnowRecommend)localObject2, 24, 0, 1);
        }
        if (AppSetting.c) {
          paramView.setContentDescription(((StringBuilder)localObject3).toString());
        }
        ((ajlt)localObject1).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        ((ajlt)localObject1).jdField_a_of_type_AndroidWidgetImageView.setTag(localObject2);
        paramView.setOnClickListener(this);
        if (AppSetting.c) {
          ((ajlt)localObject1).jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anni.a(2131705262));
        }
        ((ajlt)localObject1).c.setImageBitmap(a(1, ((ajlt)localObject1).jdField_a_of_type_JavaLangString));
        localObject1 = paramView;
        break;
        localObject1 = (ajlt)paramView.getTag();
        break label211;
        ((ajlt)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
        break label316;
        ((ajlt)localObject1).b.setVisibility(8);
        break label429;
        if (((MayKnowRecommend)localObject2).friendStatus == 1)
        {
          ((ajlt)localObject1).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          ((ajlt)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          ((ajlt)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131717330);
          if (AppSetting.c)
          {
            ((StringBuilder)localObject3).append(",等待验证");
            ((ajlt)localObject1).jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131717330));
          }
        }
        else
        {
          ((ajlt)localObject1).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          ((ajlt)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          ((ajlt)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131689975);
          if (AppSetting.c)
          {
            ((StringBuilder)localObject3).append(",已添加");
            ((ajlt)localObject1).jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131689975));
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
    case 2131376443: 
    case 2131376609: 
      do
      {
        do
        {
          for (;;)
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            a((MayKnowRecommend)paramView.getTag());
          }
          localObject1 = (ajlt)paramView.getTag();
        } while (localObject1 == null);
        localObject1 = ((ajlt)localObject1).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend;
      } while ((localObject1 == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidContentContext == null));
      localObject2 = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject2 == null) || (!((anmw)localObject2).b(((MayKnowRecommend)localObject1).uin))) {
        break;
      }
    }
    for (int i = 1;; i = 101)
    {
      localObject2 = new ProfileActivity.AllInOne(((MayKnowRecommend)localObject1).uin, i);
      if (this.jdField_a_of_type_Anpk != null) {}
      for (boolean bool = this.jdField_a_of_type_Anpk.a();; bool = false)
      {
        Object localObject3 = ((MayKnowRecommend)localObject1).getRecommendName(bool);
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((ProfileActivity.AllInOne)localObject2).l = ((String)localObject3);
        }
        if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).nick)) {
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = ((MayKnowRecommend)localObject1).nick;
        }
        ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 88;
        bool = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
        localObject3 = new Bundle();
        if (bool) {
          ((Bundle)localObject3).putBoolean("from_babyq", true);
        }
        ((Bundle)localObject3).putString("recommend_entry_type", "1");
        ((Bundle)localObject3).putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
        ((Bundle)localObject3).putInt("recommend_pos", this.jdField_a_of_type_JavaUtilList.indexOf(localObject1));
        ((Bundle)localObject3).putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
        ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject2, (Bundle)localObject3);
        if (this.jdField_a_of_type_Anpk != null) {
          this.jdField_a_of_type_Anpk.a((MayKnowRecommend)localObject1, 24, 0, 2);
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", 24, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 0, "1");
        break;
        localObject2 = (MayKnowRecommend)paramView.getTag();
        if ((localObject2 == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 500L)) {
          break;
        }
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        localObject1 = (ajld)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(295);
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((ajld)localObject1).a())
        {
          if (localObject1 != null) {
            ((ajlm)localObject1).a(((MayKnowRecommend)localObject2).uin);
          }
          if (this.jdField_a_of_type_JavaUtilList == null) {
            break;
          }
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject2).uin, "frd_list_dlt", 24, 0, ((MayKnowRecommend)localObject2).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject2), ((MayKnowRecommend)localObject2).algBuffer, 0, "1");
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlr
 * JD-Core Version:    0.7.0.1
 */