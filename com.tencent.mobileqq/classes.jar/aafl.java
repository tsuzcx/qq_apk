import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class aafl
  extends akat
{
  public aafl(AccountManageActivity paramAccountManageActivity) {}
  
  public void a(boolean paramBoolean, String paramString, ayay paramayay)
  {
    if (this.a.isFinishing()) {}
    ayaq localayaq;
    do
    {
      for (;;)
      {
        return;
        AccountManageActivity.a(this.a, false);
        localayaq = (ayaq)this.a.app.getManager(62);
        if (paramayay.a != 1) {
          break;
        }
        if ((this.a.isResume()) && (ayaq.a(this.a.app, "sub.uin.all")))
        {
          paramString = localayaq.a("sub.uin.all");
          int j = paramString.size();
          int i = 0;
          while (i < j)
          {
            paramayay = (Pair)paramString.get(i);
            localayaq.a(this.a.app, this.a, paramayay, new aafm(this, localayaq, paramayay));
            i += 1;
          }
        }
      }
    } while (!this.a.isResume());
    localayaq.a(paramString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aafl
 * JD-Core Version:    0.7.0.1
 */