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
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ThemeImageView;
import java.util.List;

public class affj
  extends BaseAdapter
{
  private List<AccountSearchPb.record> jdField_a_of_type_JavaUtilList;
  
  private affj(ClassificationSearchFragment paramClassificationSearchFragment) {}
  
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
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return paramView;
          localObject1 = paramView;
          if (paramView == null)
          {
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getLayoutInflater().inflate(2131560579, paramViewGroup, false);
            paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment);
            paramViewGroup = new afgl();
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367407));
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370830));
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378594));
            paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365041));
            paramViewGroup.d = ((TextView)paramView.findViewById(2131369516));
            paramViewGroup.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)getItem(paramInt));
            paramViewGroup.jdField_b_of_type_Int = ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment);
            paramView.setTag(2131369773, Integer.valueOf(paramInt));
            paramView.setTag(paramViewGroup);
            localObject1 = paramView;
            if ((paramViewGroup.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView))
            {
              ((ThemeImageView)paramViewGroup.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(true);
              localObject1 = paramView;
            }
          }
          paramView = (afgl)((View)localObject1).getTag();
          paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)getItem(paramInt));
          paramView.jdField_c_of_type_Int = (paramInt + 1);
          paramViewGroup = ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment, paramView, (AccountSearchPb.record)this.jdField_a_of_type_JavaUtilList.get(paramInt));
          paramView = (View)localObject1;
        } while (!AppSetting.d);
        ((View)localObject1).setContentDescription(paramViewGroup);
        return localObject1;
        localObject1 = (AccountSearchPb.record)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramViewGroup = paramView;
        if (paramView == null)
        {
          paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getLayoutInflater().inflate(2131561053, null);
          paramView = new afgk();
          paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367407));
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370830));
          paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131377291));
          paramView.d = ((TextView)paramViewGroup.findViewById(2131362888));
          paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131363412));
          paramView.jdField_a_of_type_Long = ((AccountSearchPb.record)localObject1).account_id.get();
          paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment);
          paramViewGroup.setTag(paramView);
        }
        paramView = (afgk)paramViewGroup.getTag();
        paramView.jdField_c_of_type_AndroidWidgetTextView.setText(((AccountSearchPb.record)localObject1).article_create_time.get());
        if ((((AccountSearchPb.record)localObject1).article_author.has()) && (!"".equals(((AccountSearchPb.record)localObject1).article_author.get()))) {
          paramView.d.setText(((AccountSearchPb.record)localObject1).article_author.get());
        }
        int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.getResources().getDimensionPixelSize(2131297291);
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
              paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(new AbsListView.LayoutParams(-1, actn.a(110.0F, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getResources()))));
              localObject2 = (ImageView)paramViewGroup.findViewById(2131379357);
              ((ImageView)localObject2).setVisibility(4);
              ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131364799);
              localImageView.setVisibility(4);
              if ((((AccountSearchPb.record)localObject1).video_article.has()) && (((AccountSearchPb.record)localObject1).video_article.get() == 11))
              {
                ((ImageView)localObject2).setVisibility(0);
                localImageView.getBackground().setAlpha(25);
                localImageView.setVisibility(0);
              }
              paramView.jdField_a_of_type_Int = (paramInt + 1);
              return paramViewGroup;
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
            paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(new AbsListView.LayoutParams(-1, actn.a(90.0F, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getResources()))));
          }
        }
        paramViewGroup = paramView;
        if (paramView == null)
        {
          paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getLayoutInflater().inflate(2131559314, null);
          paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment);
          paramView = new affi();
          paramViewGroup.setTag(paramView);
          paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131375054));
          paramViewGroup.findViewById(2131369481).setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370443));
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.b();
        localObject1 = (affi)paramViewGroup.getTag();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Int != 3) {
          break;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Boolean = true;
          ((affi)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          ((affi)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131701912));
          return paramViewGroup;
        }
        paramView = paramViewGroup;
      } while (!bbev.d(BaseApplicationImpl.getContext()));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Boolean = false;
      ((affi)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      ((affi)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131701921));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_JavaLangString, true);
      return paramViewGroup;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Int == 2)
      {
        ((affi)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        ((affi)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131701929));
        return paramViewGroup;
      }
      paramView = paramViewGroup;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Int != 4);
    ((affi)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    ((affi)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131701925));
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     affj
 * JD-Core Version:    0.7.0.1
 */