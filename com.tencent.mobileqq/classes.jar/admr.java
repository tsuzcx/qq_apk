import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class admr
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private final List<ajky> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public admr(Context paramContext, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = paramOnCheckedChangeListener;
  }
  
  private void b(List<ajky> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        ajky localajky = (ajky)paramList.get(i);
        if (((localajky == null) || (localajky.jdField_a_of_type_Int == 1) || (localajky.jdField_a_of_type_Int == 2)) && (localajky != null)) {
          paramList.remove(localajky);
        }
        i -= 1;
      }
    }
  }
  
  public ajky a(short paramShort)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (((ajky)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Short == paramShort) {
        return (ajky)this.jdField_a_of_type_JavaUtilList.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(List<ajky> paramList)
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
          int m = ((ajky)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_Short;
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
      return (ajky)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    ajky localajky = (ajky)getItem(paramInt);
    if (localajky == null) {
      return 0L;
    }
    return localajky.jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    boolean bool;
    label58:
    label99:
    int i;
    if (!(paramView instanceof FormSwitchItem))
    {
      localObject1 = new FormMultiLineSwitchItem(this.jdField_a_of_type_AndroidContentContext);
      paramView = (View)localObject1;
      localObject2 = (ajky)getItem(paramInt);
      if (localObject2 != null)
      {
        paramView.setText(((ajky)localObject2).jdField_a_of_type_JavaLangString);
        if (((ajky)localObject2).e) {
          break label174;
        }
        bool = true;
        paramView.setChecked(bool);
        if ((((ajky)localObject2).jdField_a_of_type_Int != 3) || (!((ajky)localObject2).e)) {
          break label180;
        }
        paramView.setSecendLineText(this.jdField_a_of_type_AndroidContentContext.getString(2131698065));
        paramView.setSecondLineTextViewVisibility(0);
      }
      i = getCount();
      if ((paramInt != 0) || (i != 1)) {
        break label203;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label195;
      }
      paramView.setBgType(2);
    }
    for (;;)
    {
      paramView.setTag(localObject2);
      paramView.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject2 = (FormMultiLineSwitchItem)paramView;
      localObject1 = paramView;
      paramView = (View)localObject2;
      break;
      label174:
      bool = false;
      break label58;
      label180:
      paramView.setSecendLineText("");
      paramView.setSecondLineTextViewVisibility(8);
      break label99;
      label195:
      paramView.setBgType(0);
      continue;
      label203:
      if (paramInt == 0) {
        paramView.setBgType(1);
      } else if (paramInt == i - 1)
      {
        if (this.jdField_a_of_type_Boolean) {
          paramView.setBgType(2);
        } else {
          paramView.setBgType(3);
        }
      }
      else if ((paramInt > 0) && (paramInt < i - 1)) {
        paramView.setBgType(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     admr
 * JD-Core Version:    0.7.0.1
 */