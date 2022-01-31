import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.AssociatedAccountOptPopBar;
import com.tencent.mobileqq.subaccount.SubAccountControll;

public class aipb
  implements Runnable
{
  public aipb(AssociatedAccountOptPopBar paramAssociatedAccountOptPopBar) {}
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.app != null) && (this.a.a()))
    {
      this.a.a.app.f(false);
      SubAccountControll.a(this.a.a.app, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipb
 * JD-Core Version:    0.7.0.1
 */