import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class adre
  extends aocj
{
  public adre(AccountManageActivity paramAccountManageActivity) {}
  
  public void a(boolean paramBoolean, String paramString, bdxd parambdxd)
  {
    if (this.a.isFinishing()) {}
    bdwt localbdwt;
    do
    {
      for (;;)
      {
        return;
        AccountManageActivity.a(this.a, false);
        localbdwt = (bdwt)this.a.app.getManager(62);
        if (parambdxd.a != 1) {
          break;
        }
        if ((this.a.isResume()) && (bdwt.a(this.a.app, "sub.uin.all")))
        {
          paramString = localbdwt.a("sub.uin.all");
          int j = paramString.size();
          int i = 0;
          while (i < j)
          {
            parambdxd = (Pair)paramString.get(i);
            localbdwt.a(this.a.app, this.a, parambdxd, new adrf(this, localbdwt, parambdxd));
            i += 1;
          }
        }
      }
    } while (!this.a.isResume());
    localbdwt.a(paramString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adre
 * JD-Core Version:    0.7.0.1
 */