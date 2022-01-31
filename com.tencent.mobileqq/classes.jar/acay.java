import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class acay
  extends alwx
{
  public acay(AccountManageActivity paramAccountManageActivity) {}
  
  public void a(boolean paramBoolean, String paramString, bade parambade)
  {
    if (this.a.isFinishing()) {}
    bacu localbacu;
    do
    {
      for (;;)
      {
        return;
        AccountManageActivity.a(this.a, false);
        localbacu = (bacu)this.a.app.getManager(62);
        if (parambade.a != 1) {
          break;
        }
        if ((this.a.isResume()) && (bacu.a(this.a.app, "sub.uin.all")))
        {
          paramString = localbacu.a("sub.uin.all");
          int j = paramString.size();
          int i = 0;
          while (i < j)
          {
            parambade = (Pair)paramString.get(i);
            localbacu.a(this.a.app, this.a, parambade, new acaz(this, localbacu, parambade));
            i += 1;
          }
        }
      }
    } while (!this.a.isResume());
    localbacu.a(paramString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acay
 * JD-Core Version:    0.7.0.1
 */