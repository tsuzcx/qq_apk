import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.app.QQAppInterface;

public class aidt
  extends aume
{
  public aidt(PhoneContactTabView paramPhoneContactTabView) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.a.unRegistObserver(this);
    switch (PhoneContactTabView.a(this.a).d())
    {
    case 2: 
    case 3: 
    case 4: 
    case 8: 
    default: 
      PhoneContactTabView.b(this.a);
      return;
    case 9: 
      this.a.d();
      return;
    case 0: 
    case 1: 
    case 5: 
    case 7: 
      PhoneContactTabView.a(this.a);
      return;
    }
    if (PhoneContactTabView.a(this.a).a().lastUsedFlag == 2L)
    {
      this.a.d();
      return;
    }
    PhoneContactTabView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aidt
 * JD-Core Version:    0.7.0.1
 */