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

public class agfd
  extends BaseAdapter
{
  private static final String jdField_a_of_type_JavaLangString = agfd.class.getSimpleName();
  private Context jdField_a_of_type_AndroidContentContext;
  private bfmt jdField_a_of_type_Bfmt;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<ageh> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public agfd(Context paramContext, bfmt parambfmt, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bfmt = parambfmt;
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
    String[] arrayOfString = bbdn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_JavaUtilList.clear();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (a(str, paramString)) {
          this.jdField_a_of_type_JavaUtilList.add(new ageh(str));
        }
        i += 1;
      }
    }
    notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "loadHistory, keyword = " + paramString + ", histories = " + this.jdField_a_of_type_JavaUtilList.toString());
    }
    this.jdField_a_of_type_Bfmt.sendEmptyMessage(3);
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
    ageh localageh = (ageh)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559213, null);
      paramView = new agff(null);
      paramView.a = ((TextView)localView.findViewById(2131377030));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a.setText(localageh.jdField_a_of_type_JavaLangString);
      return localView;
      paramViewGroup = (agff)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agfd
 * JD-Core Version:    0.7.0.1
 */