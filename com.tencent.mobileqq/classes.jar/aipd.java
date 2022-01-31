import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import java.util.List;

public class aipd
  extends BaseAdapter
{
  protected int a;
  protected akgd a;
  protected Context a;
  protected View a;
  protected QQAppInterface a;
  public List<String> a;
  
  public aipd(Context paramContext, QQAppInterface paramQQAppInterface, View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Akgd = ((akgd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(299));
  }
  
  public String a(int paramInt)
  {
    return (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Akgd.a();
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559621, paramViewGroup, false);
      paramViewGroup = new aipe(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367530));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367533));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView = ((PressEffectImageView)paramView.findViewById(2131375366));
      paramViewGroup.b = paramView.findViewById(2131365283);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView;
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_JavaUtilList != null) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      }
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label210;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#6991B8"));
      paramViewGroup.b.setBackgroundColor(Color.parseColor("#040E1C"));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845180);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839124);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView.setImageResource(2130845178);
    }
    for (;;)
    {
      paramView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView.setOnClickListener(paramViewGroup);
      return paramView;
      paramViewGroup = (aipe)paramView.getTag();
      break;
      label210:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4D4D4D"));
      paramViewGroup.b.setBackgroundColor(Color.parseColor("#E6E6E6"));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845179);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839123);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView.setImageResource(2130845177);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aipd
 * JD-Core Version:    0.7.0.1
 */