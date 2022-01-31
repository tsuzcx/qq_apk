import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class abwj
  extends alsi
{
  public abwj(AccountManageActivity paramAccountManageActivity) {}
  
  public void a(boolean paramBoolean, String paramString, azyv paramazyv)
  {
    if (this.a.isFinishing()) {}
    azyl localazyl;
    do
    {
      for (;;)
      {
        return;
        AccountManageActivity.a(this.a, false);
        localazyl = (azyl)this.a.app.getManager(62);
        if (paramazyv.a != 1) {
          break;
        }
        if ((this.a.isResume()) && (azyl.a(this.a.app, "sub.uin.all")))
        {
          paramString = localazyl.a("sub.uin.all");
          int j = paramString.size();
          int i = 0;
          while (i < j)
          {
            paramazyv = (Pair)paramString.get(i);
            localazyl.a(this.a.app, this.a, paramazyv, new abwk(this, localazyl, paramazyv));
            i += 1;
          }
        }
      }
    } while (!this.a.isResume());
    localazyl.a(paramString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwj
 * JD-Core Version:    0.7.0.1
 */