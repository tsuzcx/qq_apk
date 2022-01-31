import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.qphone.base.util.QLog;

public class aeys
  implements aeyt, View.OnClickListener
{
  private aeyv jdField_a_of_type_Aeyv;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public aeys(QQAppInterface paramQQAppInterface, Context paramContext, aeyv paramaeyv)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aeyv = paramaeyv;
  }
  
  public int a()
  {
    return 5;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = ((acto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(218)).a();
    this.jdField_a_of_type_JavaLangString = paramVarArgs.tipsUrl;
    paramVarArgs = paramVarArgs.tipsMsg;
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558590, null);
    ((TextView)localView.findViewById(2131362412)).setText(paramVarArgs);
    localView.setOnClickListener(this);
    localView.findViewById(2131362410).setOnClickListener(this);
    return localView;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 18;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362409: 
      if (QLog.isColorLevel()) {
        QLog.d("TimTipsBar", 2, "click tips, jump");
      }
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
      paramView.putExtra("hide_operation_bar", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      axqy.b(null, "dc00898", "", "", "0X8008948", "0X8008948", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Aeyv.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeys
 * JD-Core Version:    0.7.0.1
 */