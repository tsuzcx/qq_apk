import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.ui.dialog.DisplayHelper;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import java.util.ArrayList;
import java.util.List;

public class afij
  extends BaseAdapter
{
  private afik jdField_a_of_type_Afik;
  protected Context a;
  protected View a;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList;
  
  public afij(Context paramContext, View paramView, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = afim.a().a(paramString);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private boolean a(List<String> paramList1, List<String> paramList2)
  {
    if ((paramList1 == null) && (paramList2 == null)) {
      return true;
    }
    if ((paramList1 == null) || (paramList2 == null) || (paramList1.size() != paramList2.size())) {
      return false;
    }
    return paramList1.equals(paramList2);
  }
  
  public String a(int paramInt)
  {
    return (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    ArrayList localArrayList = afim.a().a(this.jdField_a_of_type_JavaLangString);
    if (a(this.jdField_a_of_type_JavaUtilList, localArrayList)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = localArrayList;
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    notifyDataSetChanged();
  }
  
  public void a(afik paramafik)
  {
    this.jdField_a_of_type_Afik = paramafik;
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
      paramViewGroup = new afil(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367530));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367533));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView = ((PressEffectImageView)paramView.findViewById(2131375366));
      paramViewGroup.b = paramView.findViewById(2131365283);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.leftMargin = DisplayHelper.dp2px(this.jdField_a_of_type_AndroidContentContext, 16);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_JavaUtilList != null) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      }
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label242;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845328);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839124);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView.setImageResource(2130845327);
    }
    for (;;)
    {
      paramViewGroup.b.setVisibility(8);
      paramView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView.setOnClickListener(paramViewGroup);
      return paramView;
      paramViewGroup = (afil)paramView.getTag();
      break;
      label242:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4D4D4D"));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845179);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839123);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView.setImageResource(2130845177);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afij
 * JD-Core Version:    0.7.0.1
 */