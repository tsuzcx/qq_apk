import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.ArrayList;
import java.util.List;

public class aaaf
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private final List<affz> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public aaaf(Context paramContext, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = paramOnCheckedChangeListener;
  }
  
  private void b(List<affz> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        affz localaffz = (affz)paramList.get(i);
        if (((localaffz == null) || (localaffz.jdField_a_of_type_Int == 1) || (localaffz.jdField_a_of_type_Int == 2)) && (localaffz != null)) {
          paramList.remove(localaffz);
        }
        i -= 1;
      }
    }
  }
  
  public affz a(short paramShort)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (((affz)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Short == paramShort) {
        return (affz)this.jdField_a_of_type_JavaUtilList.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(List<affz> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null)
    {
      b(paramList);
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(short[] paramArrayOfShort)
  {
    int i = 0;
    boolean bool = false;
    if ((!bool) && (paramArrayOfShort != null)) {}
    label90:
    for (;;)
    {
      try
      {
        if (i < paramArrayOfShort.length)
        {
          int j = 0;
          if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label90;
          }
          int k = paramArrayOfShort[i];
          int m = ((affz)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_Short;
          if (k == m)
          {
            bool = true;
            i += 1;
            break;
          }
          j += 1;
          continue;
        }
        return bool;
      }
      catch (Throwable paramArrayOfShort)
      {
        paramArrayOfShort.printStackTrace();
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getCount())) {
      return (affz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    affz localaffz = (affz)getItem(paramInt);
    if (localaffz == null) {
      return 0L;
    }
    return localaffz.jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    boolean bool;
    label57:
    label96:
    int i;
    if (!(paramView instanceof FormSwitchItem))
    {
      paramViewGroup = new FormMultiLineSwitchItem(this.jdField_a_of_type_AndroidContentContext);
      paramView = paramViewGroup;
      localObject = paramViewGroup;
      paramViewGroup = paramView;
      paramView = (affz)getItem(paramInt);
      if (paramView != null)
      {
        paramViewGroup.setText(paramView.jdField_a_of_type_JavaLangString);
        if (paramView.e) {
          break label151;
        }
        bool = true;
        paramViewGroup.setChecked(bool);
        if ((paramView.jdField_a_of_type_Int != 3) || (!paramView.e)) {
          break label157;
        }
        paramViewGroup.setSecendLineText(this.jdField_a_of_type_AndroidContentContext.getString(2131633361));
        paramViewGroup.setSecondLineTextViewVisibility(0);
      }
      i = getCount();
      if ((paramInt != 0) || (i != 1)) {
        break label180;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label172;
      }
      paramViewGroup.setBgType(2);
    }
    for (;;)
    {
      paramViewGroup.setTag(paramView);
      paramViewGroup.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      return localObject;
      paramViewGroup = (FormMultiLineSwitchItem)paramView;
      localObject = paramView;
      break;
      label151:
      bool = false;
      break label57;
      label157:
      paramViewGroup.setSecendLineText("");
      paramViewGroup.setSecondLineTextViewVisibility(8);
      break label96;
      label172:
      paramViewGroup.setBgType(0);
      continue;
      label180:
      if (paramInt == 0) {
        paramViewGroup.setBgType(1);
      } else if (paramInt == i - 1)
      {
        if (this.jdField_a_of_type_Boolean) {
          paramViewGroup.setBgType(2);
        } else {
          paramViewGroup.setBgType(3);
        }
      }
      else if ((paramInt > 0) && (paramInt < i - 1)) {
        paramViewGroup.setBgType(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaaf
 * JD-Core Version:    0.7.0.1
 */