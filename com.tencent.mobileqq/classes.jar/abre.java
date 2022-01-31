import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.mobileqq.doutu.DoutuServlet;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class abre
  implements Runnable
{
  public abre(DoutuManager paramDoutuManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "postGetDoutuList : run begin .");
    }
    DoutuManager.a(this.a, 1);
    NewIntent localNewIntent = new NewIntent(DoutuManager.a(this.a).getApp(), DoutuServlet.class);
    long l = Long.valueOf(DoutuManager.a(this.a).getCurrentAccountUin()).longValue();
    localNewIntent.putExtra("KEY_SRC_UIN", l);
    localNewIntent.putExtra("KEY_CMD", 1);
    Object localObject = (FriendsManager)DoutuManager.a(this.a).getManager(50);
    int i;
    if (localObject != null)
    {
      localObject = ((FriendsManager)localObject).a(DoutuManager.a(this.a).getCurrentAccountUin());
      if (localObject != null)
      {
        i = ((Card)localObject).age;
        localNewIntent.putExtra("KEY_AGE", ((Card)localObject).age);
        localNewIntent.putExtra("key_gender", ((Card)localObject).shGender);
        DoutuManager.a(this.a, (Card)localObject);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "postGetDoutuList : curUin = " + l + ", age = " + i);
      }
      DoutuManager.a(this.a).startServlet(localNewIntent);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abre
 * JD-Core Version:    0.7.0.1
 */