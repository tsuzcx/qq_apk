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
import com.tencent.mobileqq.activity.contacts.mayknow.RecommendsAdapter.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class aipx
  extends aliy
  implements View.OnClickListener
{
  amvo jdField_a_of_type_Amvo;
  Context jdField_a_of_type_AndroidContentContext;
  Resources jdField_a_of_type_AndroidContentResResources;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new aipy(this);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected Runnable a;
  List<MayKnowRecommend> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public aipx(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
    this.jdField_a_of_type_JavaLangRunnable = new RecommendsAdapter.2(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Amvo = ((amvo)paramQQAppInterface.getManager(159));
    a(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
  }
  
  private void a(aipz paramaipz)
  {
    Object localObject = paramaipz.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.getRichStatus();
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
      QLog.i("contacts.RecommendsAdapter", 2, "updateRichStatus, content=" + localStringBuilder + "  uin:" + paramaipz.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.uin);
    }
  }
  
  public void a()
  {
    super.c();
    a(null);
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_Amvo = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.i("contacts.RecommendsAdapter", 2, "checkResetApp, need change app!");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Amvo = ((amvo)paramQQAppInterface.getManager(159));
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
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.RecommendsAdapter", 2, "onResume firstVisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      amvo localamvo = (amvo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition())
      {
        if ((i >= 0) && (i < getCount())) {
          localamvo.a((MayKnowRecommend)getItem(i), 20, 0, 1);
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
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("contacts.RecommendsAdapter", 2, "stopVisibleExpose firstVisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
      }
      if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
      {
        amvo localamvo = (amvo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
        int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
        while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition())
        {
          if ((i >= 0) && (i < getCount())) {
            localamvo.b((MayKnowRecommend)getItem(i), 20, 0, 1);
          }
          i += 1;
        }
      }
    } while (this.jdField_a_of_type_ComTencentWidgetXListView == null);
    this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void e()
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
      if (!localArrayList1.isEmpty()) {
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 20, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 0, null);
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
    View localView;
    Object localObject1;
    if (paramView == null)
    {
      paramView = new aipz();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558971, paramViewGroup, false);
      paramView.c = ((ImageView)localView.findViewById(2131361795));
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131371791));
      paramView.b = ((SingleLineTextView)localView.findViewById(2131376354));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131376341));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376351));
      if ((paramView.c instanceof ThemeImageView)) {
        ((ThemeImageView)paramView.c).setSupportMaskView(false);
      }
      localView.setTag(paramView);
      localObject1 = (MayKnowRecommend)getItem(paramInt);
      paramView.jdField_a_of_type_JavaLangString = ((MayKnowRecommend)localObject1).uin;
      paramView.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = ((MayKnowRecommend)localObject1);
      if (this.jdField_a_of_type_Amvo == null) {
        break label688;
      }
    }
    label543:
    label555:
    label688:
    for (boolean bool = this.jdField_a_of_type_Amvo.a();; bool = false)
    {
      Object localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(bool);
      StringBuilder localStringBuilder = new StringBuilder(512);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
        paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject2);
        if (AppSetting.c) {
          localStringBuilder.append((String)localObject2);
        }
        label232:
        localObject2 = new StringBuilder();
        if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).category)) {
          ((StringBuilder)localObject2).append(((MayKnowRecommend)localObject1).category).append(" ");
        }
        if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).recommendReason)) {
          ((StringBuilder)localObject2).append(((MayKnowRecommend)localObject1).recommendReason);
        }
        localObject2 = ((StringBuilder)localObject2).toString();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label543;
        }
        paramView.b.setVisibility(0);
        paramView.b.setText((CharSequence)localObject2);
        if (AppSetting.c) {
          localStringBuilder.append(",").append((String)localObject2);
        }
        label343:
        if (((MayKnowRecommend)localObject1).friendStatus != 0) {
          break label555;
        }
        paramView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramView.jdField_a_of_type_AndroidWidgetButton.setTag(localObject1);
        paramView.jdField_a_of_type_AndroidWidgetButton.setText(amtj.a(2131689550));
        paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        if (AppSetting.c)
        {
          localStringBuilder.append(",点击添加");
          paramView.jdField_a_of_type_AndroidWidgetButton.setContentDescription(amtj.a(2131689550));
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          a(paramView);
        }
        if (this.jdField_a_of_type_Amvo != null) {
          this.jdField_a_of_type_Amvo.a((MayKnowRecommend)localObject1, 20, 0, 1);
        }
        if (AppSetting.c) {
          localView.setContentDescription(localStringBuilder.toString());
        }
        localView.setOnClickListener(this);
        paramView.c.setImageBitmap(a(1, paramView.jdField_a_of_type_JavaLangString));
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject1 = (aipz)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject1;
        break;
        paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
        break label232;
        paramView.b.setVisibility(8);
        break label343;
        if (((MayKnowRecommend)localObject1).friendStatus == 1)
        {
          paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131717690);
          if (AppSetting.c)
          {
            localStringBuilder.append(",等待验证");
            paramView.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131717690));
          }
        }
        else
        {
          paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131690001);
          if (AppSetting.c)
          {
            localStringBuilder.append(",已添加");
            paramView.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131690001));
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject1;
    boolean bool1;
    do
    {
      do
      {
        do
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          localObject1 = (MayKnowRecommend)paramView.getTag();
        } while (localObject1 == null);
        localObject2 = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if ((!((amsw)localObject2).b(((MayKnowRecommend)localObject1).uin)) && (!((amsw)localObject2).d(((MayKnowRecommend)localObject1).uin)))
        {
          boolean bool2 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
          bool1 = false;
          if (this.jdField_a_of_type_Amvo != null) {
            bool1 = this.jdField_a_of_type_Amvo.a();
          }
          localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(bool1);
          i = 3045;
          int j = 20;
          if (bool2)
          {
            i = 3083;
            j = 1;
          }
          localObject2 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((MayKnowRecommend)localObject1).uin, null, i, j, (String)localObject2, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689550), null);
          ((Intent)localObject2).putExtra("key_param_age_area", bfrj.a(this.jdField_a_of_type_AndroidContentContext, ((MayKnowRecommend)localObject1).gender, ((MayKnowRecommend)localObject1).age, ((MayKnowRecommend)localObject1).country, ((MayKnowRecommend)localObject1).province, ((MayKnowRecommend)localObject1).city));
          ((Intent)localObject2).putExtra("from_babyq", bool2);
          ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivity((Intent)localObject2);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Amvo != null) {
            this.jdField_a_of_type_Amvo.a((MayKnowRecommend)localObject1, 20, 0, 3);
          }
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_add", 20, 1, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 0);
          break;
          if (((amsw)localObject2).b(((MayKnowRecommend)localObject1).uin))
          {
            ((MayKnowRecommend)localObject1).friendStatus = 2;
            notifyDataSetChanged();
          }
          else
          {
            ((MayKnowRecommend)localObject1).friendStatus = 1;
            notifyDataSetChanged();
          }
        }
        localObject1 = (aipz)paramView.getTag();
      } while (localObject1 == null);
      localObject1 = ((aipz)localObject1).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend;
    } while (localObject1 == null);
    Object localObject2 = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if ((localObject2 != null) && (((amsw)localObject2).b(((MayKnowRecommend)localObject1).uin))) {}
    for (int i = 1;; i = 103)
    {
      localObject2 = new ProfileActivity.AllInOne(((MayKnowRecommend)localObject1).uin, i);
      bool1 = false;
      if (this.jdField_a_of_type_Amvo != null) {
        bool1 = this.jdField_a_of_type_Amvo.a();
      }
      Object localObject3 = ((MayKnowRecommend)localObject1).getRecommendName(bool1);
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((ProfileActivity.AllInOne)localObject2).l = ((String)localObject3);
      }
      if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).nick)) {
        ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = ((MayKnowRecommend)localObject1).nick;
      }
      ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 88;
      bool1 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
      localObject3 = new Bundle();
      if (bool1) {
        ((Bundle)localObject3).putBoolean("from_babyq", true);
      }
      ((Bundle)localObject3).putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
      ((Bundle)localObject3).putInt("recommend_pos", this.jdField_a_of_type_JavaUtilList.indexOf(localObject1));
      ((Bundle)localObject3).putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
      ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject2, (Bundle)localObject3);
      if (this.jdField_a_of_type_Amvo != null) {
        this.jdField_a_of_type_Amvo.a((MayKnowRecommend)localObject1, 20, 0, 2);
      }
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", 20, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 0);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipx
 * JD-Core Version:    0.7.0.1
 */