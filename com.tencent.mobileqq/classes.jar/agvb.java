import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class agvb
  extends BaseAdapter
{
  public List a;
  boolean jdField_a_of_type_Boolean = false;
  
  public agvb(QCallDetailActivity paramQCallDetailActivity)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    if ((QCallDetailActivity.a(paramQCallDetailActivity) != null) && (QCallDetailActivity.a(paramQCallDetailActivity).a() == 1)) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private int a(QCallRecord paramQCallRecord)
  {
    if (paramQCallRecord.isSender()) {
      return 2130842431;
    }
    if ((paramQCallRecord.isMissCall()) || (paramQCallRecord.state == 1) || ((paramQCallRecord.uinType == 3000) && (paramQCallRecord.state == 8))) {
      return 2130842437;
    }
    return 2130842426;
  }
  
  private String a(QCallRecord paramQCallRecord)
  {
    if (paramQCallRecord.uinType == 3000)
    {
      switch (paramQCallRecord.state)
      {
      default: 
        paramQCallRecord = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436991);
      case 1: 
      case 2: 
      case 8: 
      case 3: 
      case 4: 
        String str;
        do
        {
          return paramQCallRecord;
          return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436991);
          return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436988);
          paramQCallRecord = paramQCallRecord.getTalkTimeMinute();
          return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436989, new Object[] { paramQCallRecord });
          str = paramQCallRecord.getTalkTimeMinute();
          paramQCallRecord = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436990);
        } while (TextUtils.isEmpty(str));
        return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436989, new Object[] { str });
      }
      if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
        return String.format(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436970), new Object[] { paramQCallRecord.getTalkTimeMinute() });
      }
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436987);
    }
    switch (paramQCallRecord.state)
    {
    default: 
      return "";
    case 0: 
    case 9: 
    case 15: 
      if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
        return String.format(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436970), new Object[] { paramQCallRecord.getTalkTimeMinute() });
      }
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436971);
    case 2: 
    case 24: 
      if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
        return String.format(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436970), new Object[] { paramQCallRecord.getTalkTimeMinute() });
      }
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436972);
    case 1: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436988);
    case 3: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131428851);
    case 10: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436988);
    case 7: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131428844);
    case 12: 
      if (paramQCallRecord.isSender()) {
        return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436987);
      }
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436988);
    case 42: 
    case 43: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436987);
    case 46: 
    case 47: 
    case 48: 
      if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
        return String.format(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436970), new Object[] { paramQCallRecord.getTalkTimeMinute() });
      }
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436971);
    case 49: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131429184);
    case 6: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436988);
    case 58: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131437003);
    }
    if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
      return String.format(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436970), new Object[] { paramQCallRecord.getTalkTimeMinute() });
    }
    return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436987);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    }
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
  
  public int getItemViewType(int paramInt)
  {
    if (((QCallRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt)).type == QCallRecord.TYPE_DATE) {
      return QCallRecord.TYPE_DATE;
    }
    return QCallRecord.TYPE_REALRECORD;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    paramViewGroup = paramView;
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new agvc();
      if (i == QCallRecord.TYPE_DATE)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).inflate(2130970261, null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368327));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365554));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369905));
        paramView.setTag(paramViewGroup);
        paramViewGroup = paramView;
      }
    }
    else
    {
      paramView = (agvc)paramViewGroup.getTag();
      localObject = (QCallRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (i != QCallRecord.TYPE_DATE) {
        break label237;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((QCallRecord)localObject).getDateString());
      paramInt = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getResources().getColor(2131494150);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(paramInt);
    }
    label237:
    label505:
    for (;;)
    {
      return paramViewGroup;
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).inflate(2130970266, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366704));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363203));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369904));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131369907));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369905));
      break;
      String str1 = ((QCallRecord)localObject).getTime();
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(a((QCallRecord)localObject));
      String str2;
      if (((QCallRecord)localObject).state == 59)
      {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        str2 = a((QCallRecord)localObject);
        paramView.c.setText(str2);
        if (!((QCallRecord)localObject).isVideo()) {
          break label389;
        }
        localObject = paramView.jdField_b_of_type_AndroidWidgetTextView;
        if (!this.jdField_a_of_type_Boolean) {
          break label383;
        }
        paramInt = 2131436950;
        ((TextView)localObject).setText(paramInt);
        paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        if (!AppSetting.b) {
          break label505;
        }
        paramViewGroup.setContentDescription(str1 + str2);
        return paramViewGroup;
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
        label383:
        paramInt = 2131436951;
        break label325;
        if ((((QCallRecord)localObject).state == 58) || (((QCallRecord)localObject).state == 59) || (((QCallRecord)localObject).uinType == 26))
        {
          paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        else if (((QCallRecord)localObject).uinType == 8)
        {
          paramView.jdField_b_of_type_AndroidWidgetTextView.setText("");
          paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        else if (this.jdField_a_of_type_Boolean)
        {
          paramView.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131428759));
          paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        else
        {
          paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agvb
 * JD-Core Version:    0.7.0.1
 */