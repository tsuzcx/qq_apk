import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ThemeImageView;
import java.util.List;

public class aite
  extends BaseAdapter
{
  private List<AccountSearchPb.record> jdField_a_of_type_JavaUtilList;
  
  private aite(ClassificationSearchFragment paramClassificationSearchFragment) {}
  
  public List<AccountSearchPb.record> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<AccountSearchPb.record> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Int != 0) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (((AccountSearchPb.record)this.jdField_a_of_type_JavaUtilList.get(paramInt)).account_id.has()) {
        return 2;
      }
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      View localView = paramView;
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getLayoutInflater().inflate(2131560937, paramViewGroup, false);
        paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment);
        localObject1 = new aity();
        ((aity)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368094));
        ((aity)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371980));
        ((aity)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380445));
        ((aity)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365536));
        ((aity)localObject1).d = ((TextView)paramView.findViewById(2131370481));
        ((aity)localObject1).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)getItem(paramInt));
        ((aity)localObject1).jdField_b_of_type_Int = ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment);
        paramView.setTag(2131370751, Integer.valueOf(paramInt));
        paramView.setTag(localObject1);
        localView = paramView;
        if ((((aity)localObject1).jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView))
        {
          ((ThemeImageView)((aity)localObject1).jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(false);
          localView = paramView;
        }
      }
      paramView = (aity)localView.getTag();
      paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)getItem(paramInt));
      paramView.jdField_c_of_type_Int = (paramInt + 1);
      Object localObject1 = ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment, paramView, (AccountSearchPb.record)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      paramView = localView;
      if (AppSetting.c)
      {
        localView.setContentDescription((CharSequence)localObject1);
        paramView = localView;
        continue;
        localObject1 = (AccountSearchPb.record)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        localView = paramView;
        if (paramView == null)
        {
          localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getLayoutInflater().inflate(2131561467, null);
          paramView = new aitx();
          paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368094));
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371980));
          paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378940));
          paramView.d = ((TextView)localView.findViewById(2131363090));
          paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363773));
          paramView.jdField_a_of_type_Long = ((AccountSearchPb.record)localObject1).account_id.get();
          localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment);
          localView.setTag(paramView);
        }
        paramView = (aitx)localView.getTag();
        paramView.jdField_c_of_type_AndroidWidgetTextView.setText(((AccountSearchPb.record)localObject1).article_create_time.get());
        if ((((AccountSearchPb.record)localObject1).article_author.has()) && (!"".equals(((AccountSearchPb.record)localObject1).article_author.get()))) {
          paramView.d.setText(((AccountSearchPb.record)localObject1).article_author.get());
        }
        int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.getResources().getDimensionPixelSize(2131297457);
        if (!TextUtils.isEmpty(((AccountSearchPb.record)localObject1).title_image.get())) {}
        try
        {
          Object localObject2 = URLDrawable.getDrawable(((AccountSearchPb.record)localObject1).title_image.get(), i, i);
          paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          paramView.jdField_a_of_type_JavaLangString = ((AccountSearchPb.record)localObject1).article_short_url.get();
          if (((AccountSearchPb.record)localObject1).name.has()) {
            paramView.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a(80000003, ((AccountSearchPb.record)localObject1).name.get()));
          }
          if ((((AccountSearchPb.record)localObject1).brief.has()) && (!"".equals(((AccountSearchPb.record)localObject1).brief.get()))) {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a(paramView.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a()) > 1)
            {
              paramView.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
              paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              paramView.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a(80000003, ((AccountSearchPb.record)localObject1).brief.get());
              if (QLog.isColorLevel()) {
                QLog.d("ClassificationSearchFragment", 2, "brief = " + localObject2);
              }
              paramView.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
              localView.setLayoutParams(new AbsListView.LayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.dp2px(110.0F, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getResources()))));
              localObject2 = (ImageView)localView.findViewById(2131381344);
              ((ImageView)localObject2).setVisibility(4);
              ImageView localImageView = (ImageView)localView.findViewById(2131365278);
              localImageView.setVisibility(4);
              if ((((AccountSearchPb.record)localObject1).video_article.has()) && (((AccountSearchPb.record)localObject1).video_article.get() == 11))
              {
                ((ImageView)localObject2).setVisibility(0);
                localImageView.getBackground().setAlpha(25);
                localImageView.setVisibility(0);
              }
              paramView.jdField_a_of_type_Int = (paramInt + 1);
              paramView = localView;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d("ClassificationSearchFragment", 1, "classification urldrawable error:" + localException.toString());
            continue;
            paramView.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("ClassificationSearchFragment", 2, "brief = gone");
            }
            paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            localView.setLayoutParams(new AbsListView.LayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.dp2px(90.0F, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getResources()))));
          }
        }
        localView = paramView;
        if (paramView == null)
        {
          localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getLayoutInflater().inflate(2131559520, null);
          localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment);
          paramView = new aitd();
          localView.setTag(paramView);
          paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131376461));
          localView.findViewById(2131370440).setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371586));
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.b();
        localObject1 = (aitd)localView.getTag();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Int == 3)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Boolean = true;
            ((aitd)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            ((aitd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131701420));
            paramView = localView;
          }
          else
          {
            paramView = localView;
            if (NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Boolean = false;
              ((aitd)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
              ((aitd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131701429));
              this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_JavaLangString, true);
              paramView = localView;
            }
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Int == 2)
        {
          ((aitd)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((aitd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131701437));
          paramView = localView;
        }
        else
        {
          paramView = localView;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Int == 4)
          {
            ((aitd)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            ((aitd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131701433));
            paramView = localView;
          }
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aite
 * JD-Core Version:    0.7.0.1
 */