import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class abqi
  implements IphonePickerView.PickerViewAdapter
{
  public abqi(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public int getColumnCount()
  {
    int j = 1;
    int i;
    if (this.a.i == 0) {
      i = 2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "getColumnCount|pickerType : " + this.a.i + ", count : " + i);
      }
      return i;
      i = j;
      if (this.a.i != 3) {
        if (this.a.i != 1)
        {
          i = j;
          if (this.a.i != 2) {}
        }
        else
        {
          i = this.a.h;
        }
      }
    }
  }
  
  public int getRowCount(int paramInt)
  {
    int j = 0;
    int i;
    if (this.a.i == 0) {
      i = ConditionSearchManager.b.length;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "getRowCount|pickerType : " + this.a.i + ", column : " + paramInt + ", count : " + i);
      }
      return i;
      if (this.a.i == 3)
      {
        i = ConditionSearchManager.c.length;
      }
      else if (this.a.i != 1)
      {
        i = j;
        if (this.a.i != 2) {}
      }
      else
      {
        i = j;
        if (paramInt < this.a.h)
        {
          i = j;
          if (paramInt >= 0)
          {
            i = j;
            if (this.a.a[paramInt] != null) {
              i = ((List)this.a.a[paramInt]).size();
            }
          }
        }
      }
    }
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    String str2 = "";
    int i;
    String str1;
    if (this.a.i == 0)
    {
      if (paramInt2 >= 0)
      {
        i = paramInt2;
        if (paramInt2 < ConditionSearchManager.b.length) {}
      }
      else
      {
        i = 0;
      }
      str1 = ConditionSearchManager.b[i];
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "getText|pickerType : " + this.a.i + ", column : " + paramInt1 + ", row : " + i + ", result : " + str1);
      }
      return str1;
      if (this.a.i == 3)
      {
        if (paramInt2 >= 0)
        {
          i = paramInt2;
          if (paramInt2 < ConditionSearchManager.c.length) {}
        }
        else
        {
          i = 0;
        }
        str1 = ConditionSearchManager.c[i];
      }
      else if (this.a.i != 1)
      {
        str1 = str2;
        i = paramInt2;
        if (this.a.i != 2) {}
      }
      else
      {
        str1 = str2;
        i = paramInt2;
        if (paramInt1 < this.a.a.length)
        {
          str1 = str2;
          i = paramInt2;
          if (this.a.a[paramInt1] != null)
          {
            if (paramInt2 >= 0)
            {
              i = paramInt2;
              if (paramInt2 < ((List)this.a.a[paramInt1]).size()) {}
            }
            else
            {
              i = 0;
            }
            if (((BaseAddress)((List)this.a.a[paramInt1]).get(i)).code.equals("0")) {
              str1 = "不限";
            } else {
              str1 = ((BaseAddress)((List)this.a.a[paramInt1]).get(i)).name;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abqi
 * JD-Core Version:    0.7.0.1
 */