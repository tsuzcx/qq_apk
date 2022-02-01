import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class ahpk
{
  public int a;
  public Context a;
  protected SessionInfo a;
  protected BaseChatPie a;
  public QQAppInterface a;
  public int b;
  
  public ahpk(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public long a()
  {
    return 0L;
  }
  
  public abstract View a();
  
  public abstract void a();
  
  public abstract boolean a();
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public String toString()
  {
    return "NavigateBar{id=" + this.jdField_a_of_type_Int + ", priority=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpk
 * JD-Core Version:    0.7.0.1
 */