import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.BabyQAIOPanel;
import java.util.ArrayList;

public class actz
  extends BaseAdapter
{
  public actz(BabyQAIOPanel paramBabyQAIOPanel) {}
  
  public actx a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < BabyQAIOPanel.a(this.a).size())) {
      return (actx)BabyQAIOPanel.a(this.a).get(paramInt);
    }
    return new actx();
  }
  
  public int getCount()
  {
    return BabyQAIOPanel.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      localObject = new acty();
      paramView = LayoutInflater.from(BabyQAIOPanel.a(this.a)).inflate(2131558531, paramViewGroup, false);
      ((acty)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368344));
      ((acty)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367700));
      ((acty)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377046));
      ((acty)localObject).b = ((ImageView)paramView.findViewById(2131370762));
      paramView.setTag(localObject);
      paramViewGroup = (ViewGroup)localObject;
      localObject = (RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (paramInt % 2 == 0) {
        break label249;
      }
      ((RelativeLayout.LayoutParams)localObject).leftMargin = baxn.a(this.a.getContext(), 8.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = baxn.a(this.a.getContext(), 12.0F);
      label148:
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = a(paramInt);
      paramViewGroup.jdField_a_of_type_Int = ((actx)localObject).jdField_a_of_type_Int;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((actx)localObject).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(((actx)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      if (!((actx)localObject).jdField_a_of_type_Boolean) {
        break label286;
      }
      paramViewGroup.b.setVisibility(0);
    }
    for (;;)
    {
      paramView.setOnClickListener(this.a);
      if (AppSetting.d) {
        paramView.setContentDescription(((actx)localObject).jdField_a_of_type_JavaLangString);
      }
      return paramView;
      paramViewGroup = (acty)paramView.getTag();
      break;
      label249:
      ((RelativeLayout.LayoutParams)localObject).leftMargin = baxn.a(this.a.getContext(), 12.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = baxn.a(this.a.getContext(), 8.0F);
      break label148;
      label286:
      paramViewGroup.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     actz
 * JD-Core Version:    0.7.0.1
 */