import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ajnz
  extends BaseAdapter
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private String jdField_a_of_type_JavaLangString;
  List jdField_a_of_type_JavaUtilList;
  
  public ajnz(Activity paramActivity, List paramList1, TroopInfo paramTroopInfo, List paramList2)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramTroopInfo != null)
    {
      this.jdField_a_of_type_JavaUtilList.add(new ajod(paramTroopInfo, Boolean.valueOf(true)));
      this.jdField_a_of_type_JavaLangString = paramTroopInfo.troopuin;
      if (this.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_JavaLangString = "";
      }
    }
    if (paramList1 != null)
    {
      paramActivity = paramList1.iterator();
      while (paramActivity.hasNext())
      {
        paramList1 = (TroopInfo)paramActivity.next();
        if (paramList1 != null)
        {
          if ((paramList2 != null) && (paramList2.contains(paramList1.troopuin))) {}
          for (boolean bool = true;; bool = false)
          {
            this.jdField_a_of_type_JavaUtilList.add(new ajod(paramList1, Boolean.valueOf(bool)));
            break;
          }
        }
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ajod localajod = (ajod)getItem(paramInt);
    Object localObject1;
    if (paramView != null)
    {
      localObject1 = (ajoc)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject1;
      paramViewGroup.setOnClickListener(null);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(((Boolean)localajod.b).booleanValue());
      localObject1 = paramView.jdField_a_of_type_AndroidWidgetCheckBox;
      if (((TroopInfo)localajod.a).troopuin.equals(this.jdField_a_of_type_JavaLangString)) {
        break label458;
      }
    }
    label458:
    for (boolean bool = true;; bool = false)
    {
      ((CheckBox)localObject1).setEnabled(bool);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new ajoa(this, localajod));
      paramViewGroup.setOnClickListener(new ajob(this, paramView.jdField_a_of_type_AndroidWidgetCheckBox));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopInfo)localajod.a).troopname);
      return paramViewGroup;
      paramView = new ajoc();
      paramViewGroup = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
      paramViewGroup.setMinimumHeight(ScreenUtil.a(48.0F));
      paramViewGroup.setOrientation(0);
      paramViewGroup.setGravity(16);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = new CheckBox(this.jdField_a_of_type_AndroidAppActivity);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(2130838346);
      localObject1 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject1).setMargins(ScreenUtil.a(12.0F), 0, 0, 0);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
      Object localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout.LayoutParams)localObject2).setMargins(ScreenUtil.a(12.0F), 0, ScreenUtil.a(12.0F), 0);
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((LinearLayout)localObject1).setOrientation(1);
      paramView.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
      localObject2 = new LinearLayout.LayoutParams(-1, 0);
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new View(this.jdField_a_of_type_AndroidAppActivity);
      ((View)localObject2).setBackgroundDrawable(new ColorDrawable(Color.parseColor("#dedfe0")));
      ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, 2));
      ((LinearLayout)localObject1).addView(paramView.jdField_a_of_type_AndroidWidgetTextView);
      ((LinearLayout)localObject1).addView((View)localObject2);
      paramViewGroup.addView(paramView.jdField_a_of_type_AndroidWidgetCheckBox);
      paramViewGroup.addView((View)localObject1);
      paramViewGroup.setClickable(true);
      paramViewGroup.setTag(paramView);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnz
 * JD-Core Version:    0.7.0.1
 */