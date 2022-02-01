import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class akdk
  extends BaseAdapter
{
  private static final String jdField_a_of_type_JavaLangString = akdk.class.getSimpleName();
  private Context jdField_a_of_type_AndroidContentContext;
  private bkyc jdField_a_of_type_Bkyc;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<akco> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public akdk(Context paramContext, bkyc parambkyc, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bkyc = parambkyc;
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
    String[] arrayOfString = bhec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_JavaUtilList.clear();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (a(str, paramString)) {
          this.jdField_a_of_type_JavaUtilList.add(new akco(str));
        }
        i += 1;
      }
    }
    notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "loadHistory, keyword = " + paramString + ", histories = " + this.jdField_a_of_type_JavaUtilList.toString());
    }
    this.jdField_a_of_type_Bkyc.sendEmptyMessage(3);
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
    akco localakco = (akco)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559393, null);
      paramView = new akdm(null);
      paramView.a = ((TextView)localView.findViewById(2131378658));
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.a.setText(localakco.jdField_a_of_type_JavaLangString);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      akdm localakdm = (akdm)paramView.getTag();
      localView = paramView;
      paramView = localakdm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdk
 * JD-Core Version:    0.7.0.1
 */