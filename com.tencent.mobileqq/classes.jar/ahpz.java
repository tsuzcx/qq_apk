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
import com.tencent.mobileqq.activity.contacts.topentry.MayknowRecommendsAdapter.2;
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

public class ahpz
  extends aked
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  alro jdField_a_of_type_Alro;
  Context jdField_a_of_type_AndroidContentContext;
  Resources jdField_a_of_type_AndroidContentResResources;
  private bhpo jdField_a_of_type_Bhpo = new ahqa(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected Runnable a;
  List<MayKnowRecommend> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ahpz(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
    this.jdField_a_of_type_JavaLangRunnable = new MayknowRecommendsAdapter.2(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Alro = ((alro)paramQQAppInterface.getManager(159));
    a(this.jdField_a_of_type_Bhpo);
  }
  
  private void a(ahqb paramahqb)
  {
    Object localObject = paramahqb.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.getRichStatus();
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
      QLog.i("contacts.RecommendsAdapter", 2, "updateRichStatus, content=" + localStringBuilder + "  uin:" + paramahqb.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.uin);
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
    this.jdField_a_of_type_Alro = null;
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
      alro localalro = (alro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition())
      {
        if ((i >= 0) && (i < getCount())) {
          localalro.a((MayKnowRecommend)getItem(i), 24, 0, 1);
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
        alro localalro = (alro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
        int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
        while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition())
        {
          if ((i >= 0) && (i < getCount())) {
            localalro.b((MayKnowRecommend)getItem(i), 24, 0, 1);
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
    if ((this.jdField_a_of_type_AndroidContentResResources == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return paramView;
    }
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = new ahqb();
      localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558899, paramViewGroup, false);
      ((ahqb)localObject1).c = ((ImageView)((View)localObject2).findViewById(2131361795));
      ((ahqb)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject2).findViewById(2131371142));
      ((ahqb)localObject1).b = ((SingleLineTextView)((View)localObject2).findViewById(2131375678));
      ((ahqb)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject2).findViewById(2131375665));
      ((ahqb)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131375675));
      ((ahqb)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131365080));
      ((View)localObject2).setTag(localObject1);
      paramViewGroup = (ViewGroup)localObject1;
      paramView = (View)localObject2;
      if ((((ahqb)localObject1).c instanceof ThemeImageView))
      {
        ((ThemeImageView)((ahqb)localObject1).c).setSupportMaskView(true);
        paramView = (View)localObject2;
        paramViewGroup = (ViewGroup)localObject1;
      }
      localObject1 = (MayKnowRecommend)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_JavaLangString = ((MayKnowRecommend)localObject1).uin;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = ((MayKnowRecommend)localObject1);
      if (this.jdField_a_of_type_Alro == null) {
        break label759;
      }
    }
    label292:
    label614:
    label626:
    label759:
    for (boolean bool = this.jdField_a_of_type_Alro.a();; bool = false)
    {
      Object localObject3 = ((MayKnowRecommend)localObject1).getDisplayName(bool);
      localObject2 = new StringBuilder(512);
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject3);
        if (AppSetting.c) {
          ((StringBuilder)localObject2).append((String)localObject3);
        }
        localObject3 = new StringBuilder();
        if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).category)) {
          ((StringBuilder)localObject3).append(((MayKnowRecommend)localObject1).category).append(" ");
        }
        if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).recommendReason)) {
          ((StringBuilder)localObject3).append(((MayKnowRecommend)localObject1).recommendReason);
        }
        localObject3 = ((StringBuilder)localObject3).toString();
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label614;
        }
        paramViewGroup.b.setVisibility(0);
        paramViewGroup.b.setText((CharSequence)localObject3);
        if (AppSetting.c) {
          ((StringBuilder)localObject2).append(",").append((String)localObject3);
        }
        if (((MayKnowRecommend)localObject1).friendStatus != 0) {
          break label626;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(localObject1);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(alpo.a(2131689628));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        if (AppSetting.c)
        {
          ((StringBuilder)localObject2).append(",点击添加");
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setContentDescription(alpo.a(2131689628));
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          a(paramViewGroup);
        }
        if (this.jdField_a_of_type_Alro != null) {
          this.jdField_a_of_type_Alro.a((MayKnowRecommend)localObject1, 24, 0, 1);
        }
        if (AppSetting.c) {
          paramView.setContentDescription(((StringBuilder)localObject2).toString());
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject1);
        paramView.setOnClickListener(this);
        if (AppSetting.c) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alpo.a(2131706859));
        }
        paramViewGroup.c.setImageBitmap(a(1, paramViewGroup.jdField_a_of_type_JavaLangString));
        return paramView;
        paramViewGroup = (ahqb)paramView.getTag();
        break;
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
        break label292;
        paramViewGroup.b.setVisibility(8);
        break label403;
        if (((MayKnowRecommend)localObject1).friendStatus == 1)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131719227);
          if (AppSetting.c)
          {
            ((StringBuilder)localObject2).append(",等待验证");
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131719227));
          }
        }
        else
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131690082);
          if (AppSetting.c)
          {
            ((StringBuilder)localObject2).append(",已添加");
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131690082));
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    boolean bool1;
    switch (paramView.getId())
    {
    default: 
    case 2131375665: 
    case 2131375820: 
      do
      {
        do
        {
          do
          {
            return;
            paramView = (MayKnowRecommend)paramView.getTag();
          } while ((paramView == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidContentContext == null));
          localObject1 = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          if ((!((aloz)localObject1).b(paramView.uin)) && (!((aloz)localObject1).d(paramView.uin)))
          {
            boolean bool2 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
            bool1 = false;
            if (this.jdField_a_of_type_Alro != null) {
              bool1 = this.jdField_a_of_type_Alro.a();
            }
            localObject1 = paramView.getDisplayName(bool1);
            i = 3045;
            int j = 24;
            if (bool2)
            {
              i = 3083;
              j = 1;
            }
            localObject1 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, paramView.uin, null, i, j, (String)localObject1, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689628), null);
            ((Intent)localObject1).putExtra("key_param_age_area", bcyw.a(this.jdField_a_of_type_AndroidContentContext, paramView.gender, paramView.age, paramView.country, paramView.province, paramView.city));
            ((Intent)localObject1).putExtra("from_babyq", bool2);
            ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivity((Intent)localObject1);
          }
          for (;;)
          {
            if (this.jdField_a_of_type_Alro != null) {
              this.jdField_a_of_type_Alro.a(paramView, 24, 0, 3);
            }
            ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_add", 24, 1, paramView.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(paramView), paramView.algBuffer, 0, "1");
            return;
            if (((aloz)localObject1).b(paramView.uin))
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
          paramView = (ahqb)paramView.getTag();
        } while (paramView == null);
        paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend;
      } while ((paramView == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidContentContext == null));
      localObject1 = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject1 == null) || (!((aloz)localObject1).b(paramView.uin))) {
        break;
      }
    }
    for (int i = 1;; i = 101)
    {
      localObject1 = new ProfileActivity.AllInOne(paramView.uin, i);
      bool1 = false;
      if (this.jdField_a_of_type_Alro != null) {
        bool1 = this.jdField_a_of_type_Alro.a();
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
      ((Bundle)localObject2).putString("recommend_entry_type", "1");
      ((Bundle)localObject2).putString("recommend_reason", paramView.recommendReason);
      ((Bundle)localObject2).putInt("recommend_pos", this.jdField_a_of_type_JavaUtilList.indexOf(paramView));
      ((Bundle)localObject2).putByteArray("recommend_algh_id", paramView.algBuffer);
      ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject1, (Bundle)localObject2);
      if (this.jdField_a_of_type_Alro != null) {
        this.jdField_a_of_type_Alro.a(paramView, 24, 0, 2);
      }
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_clk", 24, 0, paramView.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(paramView), paramView.algBuffer, 0, "1");
      return;
      localObject1 = (MayKnowRecommend)paramView.getTag();
      if ((localObject1 == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 500L)) {
        break;
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramView = (ahpq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(295);
      if (paramView == null) {}
      for (paramView = null;; paramView = paramView.a())
      {
        if (paramView != null) {
          paramView.a(((MayKnowRecommend)localObject1).uin);
        }
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break;
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_dlt", 24, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 0, "1");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpz
 * JD-Core Version:    0.7.0.1
 */