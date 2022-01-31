import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;

public class adyb
  implements Runnable
{
  public adyb(MyBusinessManager paramMyBusinessManager) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adyb
 * JD-Core Version:    0.7.0.1
 */