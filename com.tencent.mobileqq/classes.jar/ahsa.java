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
import com.tencent.mobileqq.activity.contacts.adapter.RecommendsAdapter.2;
import com.tencent.mobileqq.activity.contacts.utils.ContactReportUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class ahsa
  extends akis
  implements View.OnClickListener
{
  alwd jdField_a_of_type_Alwd;
  Context jdField_a_of_type_AndroidContentContext;
  Resources jdField_a_of_type_AndroidContentResResources;
  private bhtv jdField_a_of_type_Bhtv = new ahsb(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected Runnable a;
  List<MayKnowRecommend> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ahsa(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
    this.jdField_a_of_type_JavaLangRunnable = new RecommendsAdapter.2(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Alwd = ((alwd)paramQQAppInterface.getManager(159));
    a(this.jdField_a_of_type_Bhtv);
  }
  
  private void a(ahsc paramahsc)
  {
    Object localObject = paramahsc.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.getRichStatus();
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
      QLog.i("contacts.RecommendsAdapter", 2, "updateRichStatus, content=" + localStringBuilder + "  uin:" + paramahsc.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.uin);
    }
  }
  
  public void a()
  {
    super.c();
    a(null);
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_Alwd = null;
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
      this.jdField_a_of_type_Alwd = ((alwd)paramQQAppInterface.getManager(159));
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
      alwd localalwd = (alwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition())
      {
        if ((i >= 0) && (i < getCount())) {
          localalwd.a((MayKnowRecommend)getItem(i), 20, 0, 1);
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
        alwd localalwd = (alwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
        int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
        while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition())
        {
          if ((i >= 0) && (i < getCount())) {
            localalwd.b((MayKnowRecommend)getItem(i), 20, 0, 1);
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
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = new ahsc();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558897, paramViewGroup, false);
      ((ahsc)localObject1).c = ((ImageView)paramView.findViewById(2131361795));
      ((ahsc)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131371161));
      ((ahsc)localObject1).b = ((SingleLineTextView)paramView.findViewById(2131375729));
      ((ahsc)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131375716));
      ((ahsc)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375726));
      if ((((ahsc)localObject1).c instanceof ThemeImageView)) {
        ((ThemeImageView)((ahsc)localObject1).c).setSupportMaskView(true);
      }
      paramView.setTag(localObject1);
      paramViewGroup = (ViewGroup)localObject1;
      localObject1 = (MayKnowRecommend)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_JavaLangString = ((MayKnowRecommend)localObject1).uin;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = ((MayKnowRecommend)localObject1);
      if (this.jdField_a_of_type_Alwd == null) {
        break label668;
      }
    }
    label523:
    label535:
    label668:
    for (boolean bool = this.jdField_a_of_type_Alwd.a();; bool = false)
    {
      Object localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(bool);
      StringBuilder localStringBuilder = new StringBuilder(512);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject2);
        if (AppSetting.c) {
          localStringBuilder.append((String)localObject2);
        }
        label237:
        localObject2 = new StringBuilder();
        if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).category)) {
          ((StringBuilder)localObject2).append(((MayKnowRecommend)localObject1).category).append(" ");
        }
        if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).recommendReason)) {
          ((StringBuilder)localObject2).append(((MayKnowRecommend)localObject1).recommendReason);
        }
        localObject2 = ((StringBuilder)localObject2).toString();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label523;
        }
        paramViewGroup.b.setVisibility(0);
        paramViewGroup.b.setText((CharSequence)localObject2);
        if (AppSetting.c) {
          localStringBuilder.append(",").append((String)localObject2);
        }
        label348:
        if (((MayKnowRecommend)localObject1).friendStatus != 0) {
          break label535;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(localObject1);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(alud.a(2131689628));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        if (AppSetting.c)
        {
          localStringBuilder.append(",点击添加");
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setContentDescription(alud.a(2131689628));
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          a(paramViewGroup);
        }
        if (this.jdField_a_of_type_Alwd != null) {
          this.jdField_a_of_type_Alwd.a((MayKnowRecommend)localObject1, 20, 0, 1);
        }
        if (AppSetting.c) {
          paramView.setContentDescription(localStringBuilder.toString());
        }
        paramView.setOnClickListener(this);
        paramViewGroup.c.setImageBitmap(a(1, paramViewGroup.jdField_a_of_type_JavaLangString));
        return paramView;
        paramViewGroup = (ahsc)paramView.getTag();
        break;
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
        break label237;
        paramViewGroup.b.setVisibility(8);
        break label348;
        if (((MayKnowRecommend)localObject1).friendStatus == 1)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131719239);
          if (AppSetting.c)
          {
            localStringBuilder.append(",等待验证");
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131719239));
          }
        }
        else
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131690082);
          if (AppSetting.c)
          {
            localStringBuilder.append(",已添加");
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131690082));
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
    boolean bool1;
    do
    {
      do
      {
        do
        {
          return;
          paramView = (MayKnowRecommend)paramView.getTag();
        } while (paramView == null);
        localObject1 = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if ((!((alto)localObject1).b(paramView.uin)) && (!((alto)localObject1).d(paramView.uin)))
        {
          boolean bool2 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
          bool1 = false;
          if (this.jdField_a_of_type_Alwd != null) {
            bool1 = this.jdField_a_of_type_Alwd.a();
          }
          localObject1 = paramView.getDisplayName(bool1);
          i = 3045;
          int j = 20;
          if (bool2)
          {
            i = 3083;
            j = 1;
          }
          localObject1 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, paramView.uin, null, i, j, (String)localObject1, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689628), null);
          ((Intent)localObject1).putExtra("key_param_age_area", bddf.a(this.jdField_a_of_type_AndroidContentContext, paramView.gender, paramView.age, paramView.country, paramView.province, paramView.city));
          ((Intent)localObject1).putExtra("from_babyq", bool2);
          ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivity((Intent)localObject1);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Alwd != null) {
            this.jdField_a_of_type_Alwd.a(paramView, 20, 0, 3);
          }
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_add", 20, 1, paramView.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(paramView), paramView.algBuffer, 0);
          return;
          if (((alto)localObject1).b(paramView.uin))
          {
            paramView.friendStatus = 2;
            notifyDataSetChanged();
          }
          else
          {
            paramView.friendStatus = 1;
            notifyDataSetChanged();
          }
        }
        paramView = (ahsc)paramView.getTag();
      } while (paramView == null);
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend;
    } while (paramView == null);
    Object localObject1 = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if ((localObject1 != null) && (((alto)localObject1).b(paramView.uin))) {}
    for (int i = 1;; i = 103)
    {
      localObject1 = new ProfileActivity.AllInOne(paramView.uin, i);
      bool1 = false;
      if (this.jdField_a_of_type_Alwd != null) {
        bool1 = this.jdField_a_of_type_Alwd.a();
      }
      Object localObject2 = paramView.getRecommendName(bool1);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((ProfileActivity.AllInOne)localObject1).l = ((String)localObject2);
      }
      if (!TextUtils.isEmpty(paramView.nick)) {
        ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_JavaLangString = paramView.nick;
      }
      ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 88;
      bool1 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
      localObject2 = new Bundle();
      if (bool1) {
        ((Bundle)localObject2).putBoolean("from_babyq", true);
      }
      ((Bundle)localObject2).putString("recommend_reason", paramView.recommendReason);
      ((Bundle)localObject2).putInt("recommend_pos", this.jdField_a_of_type_JavaUtilList.indexOf(paramView));
      ((Bundle)localObject2).putByteArray("recommend_algh_id", paramView.algBuffer);
      ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject1, (Bundle)localObject2);
      if (this.jdField_a_of_type_Alwd != null) {
        this.jdField_a_of_type_Alwd.a(paramView, 20, 0, 2);
      }
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_clk", 20, 0, paramView.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(paramView), paramView.algBuffer, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsa
 * JD-Core Version:    0.7.0.1
 */