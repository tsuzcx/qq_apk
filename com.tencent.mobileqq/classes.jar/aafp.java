import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class aafp
  extends akav
{
  public aafp(AccountManageActivity paramAccountManageActivity) {}
  
  public void a(boolean paramBoolean, String paramString, ayaw paramayaw)
  {
    if (this.a.isFinishing()) {}
    ayao localayao;
    do
    {
      for (;;)
      {
        return;
        AccountManageActivity.a(this.a, false);
        localayao = (ayao)this.a.app.getManager(62);
        if (paramayaw.a != 1) {
          break;
        }
        if ((this.a.isResume()) && (ayao.a(this.a.app, "sub.uin.all")))
        {
          paramString = localayao.a("sub.uin.all");
          int j = paramString.size();
          int i = 0;
          while (i < j)
          {
            paramayaw = (Pair)paramString.get(i);
            localayao.a(this.a.app, this.a, paramayaw, new aafq(this, localayao, paramayaw));
            i += 1;
          }
        }
      }
    } while (!this.a.isResume());
    localayao.a(paramString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aafp
 * JD-Core Version:    0.7.0.1
 */