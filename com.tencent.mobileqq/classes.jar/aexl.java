import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;

public class aexl
  implements aeyt, View.OnClickListener
{
  public static String a;
  private int jdField_a_of_type_Int;
  private aeyv jdField_a_of_type_Aeyv;
  private Context jdField_a_of_type_AndroidContentContext;
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://imgcache.qq.com/club/client/group/release/index.html?_bid=199&groupId=%s&from=%s";
  }
  
  public aexl(QQAppInterface paramQQAppInterface, Context paramContext, aeyv paramaeyv)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aeyv = paramaeyv;
  }
  
  public int a()
  {
    return 25;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558591, null);
    ImageView localImageView1 = (ImageView)paramVarArgs.findViewById(2131362397);
    ImageView localImageView2 = (ImageView)paramVarArgs.findViewById(2131362407);
    ((TextView)paramVarArgs.findViewById(2131362408)).setText(this.jdField_a_of_type_AndroidTextSpannableString);
    if (this.jdField_a_of_type_Int == 0)
    {
      localImageView1.setImageResource(2130839202);
      paramVarArgs.setBackgroundResource(2130839199);
      localImageView2.setImageResource(2130849082);
    }
    for (;;)
    {
      paramVarArgs.setOnClickListener(this);
      return paramVarArgs;
      localImageView1.setImageResource(2130843414);
      paramVarArgs.setBackgroundResource(2130846238);
      localImageView2.setImageResource(2130843556);
      localImageView2.setOnClickListener(this);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(String paramString, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidTextSpannableString = paramSpannableString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if ((paramInt2 == 3) || (paramInt2 == 4)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 23;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BigTroopExpiredTipsBar", 2, "click tips, jump");
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramView.putExtra("url", String.format(jdField_a_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString, "group_aio_tip" }));
        paramView.putExtra("hide_operation_bar", true);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E34", this.jdField_b_of_type_Int, 0, "", "", "", "");
        this.jdField_a_of_type_Aeyv.a();
        return;
      }
      akig.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_JavaLangString, "group_aio_tip");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_b_of_type_Int == 3) {}
      for (paramView = "0X800A57A";; paramView = "0X800A57C")
      {
        axqy.b(localQQAppInterface, "dc00898", "", "", "qq_vip", paramView, 1, 0, "", "", "", "");
        break;
      }
      paramView = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      int i = paramView.e(this.jdField_b_of_type_JavaLangString);
      paramView.f(this.jdField_b_of_type_JavaLangString, i + 1);
      this.jdField_a_of_type_Aeyv.a();
    } while (!this.jdField_a_of_type_Boolean);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_b_of_type_Int == 3) {}
    for (paramView = "0X800A57A";; paramView = "0X800A57C")
    {
      axqy.b(localQQAppInterface, "dc00898", "", "", "qq_vip", paramView, 2, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexl
 * JD-Core Version:    0.7.0.1
 */