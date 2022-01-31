import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class aihv
  extends BaseAdapter
{
  private static final String jdField_a_of_type_JavaLangString = aihv.class.getSimpleName();
  private Context jdField_a_of_type_AndroidContentContext;
  private bhsl jdField_a_of_type_Bhsl;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<aigz> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public aihv(Context paramContext, bhsl parambhsl, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bhsl = parambhsl;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "loadHistory, keyword = " + paramString);
    }
    if (paramString == null) {
      return;
    }
    String[] arrayOfString = bdhf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_JavaUtilList.clear();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (a(str, paramString)) {
          this.jdField_a_of_type_JavaUtilList.add(new aigz(str));
        }
        i += 1;
      }
    }
    notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "loadHistory, keyword = " + paramString + ", histories = " + this.jdField_a_of_type_JavaUtilList.toString());
    }
    this.jdField_a_of_type_Bhsl.sendEmptyMessage(3);
  }
  
  boolean a(String paramString1, String paramString2)
  {
    return paramString1.toLowerCase(Locale.US).contains(paramString2.toLowerCase(Locale.US));
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
    aigz localaigz = (aigz)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559256, null);
      paramView = new aihx(null);
      paramView.a = ((TextView)localView.findViewById(2131377606));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a.setText(localaigz.jdField_a_of_type_JavaLangString);
      return localView;
      paramViewGroup = (aihx)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihv
 * JD-Core Version:    0.7.0.1
 */