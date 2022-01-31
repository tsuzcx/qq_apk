import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class agzq
  implements ahan
{
  private int jdField_a_of_type_Int;
  private ahap jdField_a_of_type_Ahap;
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  public agzq(QQAppInterface paramQQAppInterface, ahap paramahap, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ahap = paramahap;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public int a()
  {
    return 40;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558619, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramVarArgs.findViewById(2131362414));
    a();
    paramVarArgs.setOnClickListener(new agzr(this));
    bfhz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2015", "0", false);
    return paramVarArgs;
  }
  
  public void a()
  {
    Object localObject = (aspf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156);
    if (((aspf)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = ((aspf)localObject).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Int = ((aspf)localObject).jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = ((aspf)localObject).c;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((aspf)localObject).jdField_b_of_type_JavaLangString)) {
        break label173;
      }
      if (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int) {
        break label157;
      }
      localObject = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693030), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int) });
    }
    Looper localLooper;
    for (;;)
    {
      localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
      label157:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693028);
      continue;
      label173:
      if ((((aspf)localObject).e == 3) || (((aspf)localObject).e == 4)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693032);
      } else if (this.jdField_a_of_type_Int < this.jdField_b_of_type_Int) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693031);
      } else {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693029);
      }
    }
    new Handler(localLooper).post(new GamePartyTipsBar.2(this, (String)localObject));
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    while (!((aspf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_Ahap.a(this, new Object[0]);
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 14;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agzq
 * JD-Core Version:    0.7.0.1
 */