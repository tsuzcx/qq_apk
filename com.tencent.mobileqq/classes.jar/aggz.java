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

public class aggz
  extends BaseAdapter
{
  public List a;
  boolean jdField_a_of_type_Boolean = false;
  
  public aggz(QCallDetailActivity paramQCallDetailActivity)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    if ((QCallDetailActivity.a(paramQCallDetailActivity) != null) && (QCallDetailActivity.a(paramQCallDetailActivity).a() == 1)) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private int a(QCallRecord paramQCallRecord)
  {
    if (paramQCallRecord.isSender()) {
      return 2130842384;
    }
    if ((paramQCallRecord.isMissCall()) || (paramQCallRecord.state == 1) || ((paramQCallRecord.uinType == 3000) && (paramQCallRecord.state == 8))) {
      return 2130842390;
    }
    return 2130842379;
  }
  
  private String a(QCallRecord paramQCallRecord)
  {
    if (paramQCallRecord.uinType == 3000)
    {
      switch (paramQCallRecord.state)
      {
      default: 
        paramQCallRecord = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436974);
      case 1: 
      case 2: 
      case 8: 
      case 3: 
      case 4: 
        String str;
        do
        {
          return paramQCallRecord;
          return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436974);
          return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436971);
          paramQCallRecord = paramQCallRecord.getTalkTimeMinute();
          return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436972, new Object[] { paramQCallRecord });
          str = paramQCallRecord.getTalkTimeMinute();
          paramQCallRecord = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436973);
        } while (TextUtils.isEmpty(str));
        return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436972, new Object[] { str });
      }
      if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
        return String.format(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436953), new Object[] { paramQCallRecord.getTalkTimeMinute() });
      }
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436970);
    }
    switch (paramQCallRecord.state)
    {
    default: 
      return "";
    case 0: 
    case 9: 
    case 15: 
      if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
        return String.format(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436953), new Object[] { paramQCallRecord.getTalkTimeMinute() });
      }
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436954);
    case 2: 
    case 24: 
      if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
        return String.format(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436953), new Object[] { paramQCallRecord.getTalkTimeMinute() });
      }
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436955);
    case 1: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436971);
    case 3: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131428845);
    case 10: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436971);
    case 7: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131428838);
    case 12: 
      if (paramQCallRecord.isSender()) {
        return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436970);
      }
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436971);
    case 42: 
    case 43: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436970);
    case 46: 
    case 47: 
    case 48: 
      if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
        return String.format(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436953), new Object[] { paramQCallRecord.getTalkTimeMinute() });
      }
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436954);
    case 49: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131429178);
    case 6: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436971);
    case 58: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436986);
    }
    if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
      return String.format(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436953), new Object[] { paramQCallRecord.getTalkTimeMinute() });
    }
    return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131436970);
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
      paramViewGroup = new agha();
      if (i == QCallRecord.TYPE_DATE)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).inflate(2130970245, null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368260));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365532));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369828));
        paramView.setTag(paramViewGroup);
        paramViewGroup = paramView;
      }
    }
    else
    {
      paramView = (agha)paramViewGroup.getTag();
      localObject = (QCallRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (i != QCallRecord.TYPE_DATE) {
        break label237;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((QCallRecord)localObject).getDateString());
      paramInt = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getResources().getColor(2131494143);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(paramInt);
    }
    label237:
    label505:
    for (;;)
    {
      return paramViewGroup;
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).inflate(2130970250, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366837));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363185));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369827));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131369830));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369828));
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
        paramInt = 2131436933;
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
        paramInt = 2131436934;
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
          paramView.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131428753));
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
 * Qualified Name:     aggz
 * JD-Core Version:    0.7.0.1
 */