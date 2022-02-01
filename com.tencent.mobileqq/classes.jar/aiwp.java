import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aiwp
  implements aiwf, View.OnClickListener
{
  public static String a;
  private aiwh jdField_a_of_type_Aiwh;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://imgcache.qq.com/club/client/group/release/index.html?_bid=199&groupId=";
  }
  
  public aiwp(QQAppInterface paramQQAppInterface, Context paramContext, aiwh paramaiwh)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aiwh = paramaiwh;
  }
  
  public int a()
  {
    return 25;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558654, null);
    paramVarArgs.setOnClickListener(this);
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 21;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeBigTroopTipsBar", 2, "click tips, jump");
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", jdField_a_of_type_JavaLangString + this.b + "&from=aio");
      localIntent.putExtra("hide_operation_bar", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.b, 3);
      this.jdField_a_of_type_Aiwh.a();
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_up", "", "Grp_AIO", "clk", 0, 0, this.b, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwp
 * JD-Core Version:    0.7.0.1
 */