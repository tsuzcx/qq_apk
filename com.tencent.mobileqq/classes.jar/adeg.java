import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class adeg
  extends anyz
{
  public adeg(AccountManageActivity paramAccountManageActivity) {}
  
  public void onPushSubAccountMsg(boolean paramBoolean, String paramString, bdxt parambdxt)
  {
    if (this.a.isFinishing()) {}
    bdxj localbdxj;
    do
    {
      for (;;)
      {
        return;
        AccountManageActivity.a(this.a, false);
        localbdxj = (bdxj)this.a.app.getManager(QQManagerFactory.SUB_ACCOUNT_CONTROLL);
        if (parambdxt.a != 1) {
          break;
        }
        if ((this.a.isResume()) && (bdxj.a(this.a.app, "sub.uin.all")))
        {
          paramString = localbdxj.a("sub.uin.all");
          int j = paramString.size();
          int i = 0;
          while (i < j)
          {
            parambdxt = (Pair)paramString.get(i);
            localbdxj.a(this.a.app, this.a, parambdxt, new adeh(this, localbdxj, parambdxt));
            i += 1;
          }
        }
      }
    } while (!this.a.isResume());
    localbdxj.a(paramString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adeg
 * JD-Core Version:    0.7.0.1
 */