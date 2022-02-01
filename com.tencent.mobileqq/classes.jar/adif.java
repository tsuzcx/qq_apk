import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class adif
  extends anqd
{
  public adif(AccountManageActivity paramAccountManageActivity) {}
  
  public void a(boolean paramBoolean, String paramString, bdei parambdei)
  {
    if (this.a.isFinishing()) {}
    bddy localbddy;
    do
    {
      for (;;)
      {
        return;
        AccountManageActivity.a(this.a, false);
        localbddy = (bddy)this.a.app.getManager(62);
        if (parambdei.a != 1) {
          break;
        }
        if ((this.a.isResume()) && (bddy.a(this.a.app, "sub.uin.all")))
        {
          paramString = localbddy.a("sub.uin.all");
          int j = paramString.size();
          int i = 0;
          while (i < j)
          {
            parambdei = (Pair)paramString.get(i);
            localbddy.a(this.a.app, this.a, parambdei, new adig(this, localbddy, parambdei));
            i += 1;
          }
        }
      }
    } while (!this.a.isResume());
    localbddy.a(paramString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adif
 * JD-Core Version:    0.7.0.1
 */