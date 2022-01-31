import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;

public class aetr
  implements Runnable
{
  public aetr(MyBusinessManager paramMyBusinessManager) {}
  
  public void run()
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((PhoneContactManagerImp)this.a.a.getManager(10)).a();
    String str = "";
    int i = 0;
    if (localRespondQueryQQBindingStat != null)
    {
      str = localRespondQueryQQBindingStat.mobileNo;
      i = localRespondQueryQQBindingStat.type;
    }
    this.a.a(str, i, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aetr
 * JD-Core Version:    0.7.0.1
 */