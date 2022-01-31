import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.PanelAdapter;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class acxk
  extends RelativeLayout
{
  public int a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public acxk(PanelAdapter paramPanelAdapter, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    int k = paramPanelAdapter.a();
    int m = paramPanelAdapter.b();
    int i = actj.a(15.0F, getContext().getResources());
    int n = (XPanelContainer.b - i) / m;
    int i1 = XPanelContainer.jdField_a_of_type_Int - XPanelContainer.b;
    i = 0;
    while (i < m)
    {
      paramAttributeSet = new LinearLayout(paramContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, n);
      localLayoutParams.leftMargin = actj.a(20.0F, getContext().getResources());
      localLayoutParams.rightMargin = actj.a(20.0F, getContext().getResources());
      paramAttributeSet.setOrientation(0);
      localLayoutParams.topMargin = (i1 / (m + 1) * (i + 1) + i * n);
      if (QLog.isColorLevel()) {
        QLog.i("IconLinearLayout", 2, "top margin: " + localLayoutParams.topMargin + "addedHeight: " + i1 + ", row height: " + n + ", i: " + i);
      }
      int j = 0;
      while (j < k)
      {
        Object localObject = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
          this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
        }
        View localView = LayoutInflater.from(paramContext).inflate(2131558762, null);
        paramAttributeSet.addView(localView, (ViewGroup.LayoutParams)localObject);
        localObject = new acxl();
        ((acxl)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367800));
        ((acxl)localObject).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramContext, ((acxl)localObject).jdField_a_of_type_AndroidWidgetImageView).a(8388661).a();
        ((acxl)localObject).b = ((ImageView)localView.findViewById(2131366359));
        ((acxl)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377046));
        localView.setTag(localObject);
        j += 1;
      }
      addView(paramAttributeSet, localLayoutParams);
      i += 1;
    }
    if (paramPanelAdapter.jdField_a_of_type_Boolean) {
      a(paramContext);
    }
    setTag(Integer.valueOf(XPanelContainer.d));
  }
  
  public void a()
  {
    int i = 0;
    while (i < getChildCount())
    {
      Object localObject = getChildAt(i);
      if (localObject != null)
      {
        localObject = (acxl)((View)localObject).getTag();
        if ((localObject != null) && (((acxl)localObject).jdField_a_of_type_AndroidWidgetImageView != null)) {
          ((acxl)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        }
      }
      i += 1;
    }
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.jdField_a_of_type_Boolean)
    {
      a(getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    while (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void a(Context paramContext)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      int i = actj.a(18.0F, getContext().getResources());
      int j = actj.a(18.0F, getContext().getResources());
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-4473925);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(8.0F);
      paramContext = new LinearLayout(paramContext);
      paramContext.setOrientation(0);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 83;
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(83);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 0);
      localLayoutParams.leftMargin = i;
      paramContext.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
      addView(paramContext, new RelativeLayout.LayoutParams(-1, j));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acxk
 * JD-Core Version:    0.7.0.1
 */