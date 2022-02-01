import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class aacx
  extends aabe
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ArrayList<aacr> jdField_a_of_type_JavaUtilArrayList;
  
  public aacx(ArrayList<aacr> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  private void a()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Object localObject2;
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 1) && (this.jdField_a_of_type_JavaUtilArrayList.get(0) != null))
      {
        localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
        if (TextUtils.isEmpty(((aacr)this.jdField_a_of_type_JavaUtilArrayList.get(0)).getTitle())) {
          break label187;
        }
      }
      label187:
      for (Object localObject1 = ((aacr)this.jdField_a_of_type_JavaUtilArrayList.get(0)).getTitle();; localObject1 = "")
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((aacr)this.jdField_a_of_type_JavaUtilArrayList.get(0)).initTitleBar(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 1) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject1 = (aacr)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          localObject2 = ((aacr)localObject1).getTitleTabView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
          if (localObject2 != null)
          {
            ((View)localObject2).setOnClickListener(new aacy(this, i, (View)localObject2, (aacr)localObject1));
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      aacr localaacr = (aacr)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localaacr.onTitleTabSelectedChanged(localView, bool);
        i += 1;
        break;
      }
    }
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(paramInt);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = ((QCircleInitBean)a().getIntent().getSerializableExtra("key_bundle_common_init_bean")).getLaunchTo();
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.addOnPageChangeListener(new aacz(this));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(this.jdField_a_of_type_Int);
    a(this.jdField_a_of_type_Int);
  }
  
  public String a()
  {
    return "PublicListCommonPart";
  }
  
  protected void a(View paramView)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366776));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369134));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380141));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370258));
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)paramView.findViewById(2131381248));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      a();
      b();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((!a().onBackEvent()) && (a() != null)) {
        a().finish();
      }
      if ((aazb.a("PublicListCommonPart")) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.get(0) != null)) {
        ((aacr)this.jdField_a_of_type_JavaUtilArrayList.get(0)).onDoubleClickTitle();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacx
 * JD-Core Version:    0.7.0.1
 */