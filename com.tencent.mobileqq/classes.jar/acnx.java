import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class acnx
  extends amwl
{
  public acnx(AccountManageActivity paramAccountManageActivity) {}
  
  public void onPushSubAccountMsg(boolean paramBoolean, String paramString, bcqu parambcqu)
  {
    if (this.a.isFinishing()) {}
    bcqk localbcqk;
    do
    {
      for (;;)
      {
        return;
        AccountManageActivity.a(this.a, false);
        localbcqk = (bcqk)this.a.app.getManager(62);
        if (parambcqu.a != 1) {
          break;
        }
        if ((this.a.isResume()) && (bcqk.a(this.a.app, "sub.uin.all")))
        {
          paramString = localbcqk.a("sub.uin.all");
          int j = paramString.size();
          int i = 0;
          while (i < j)
          {
            parambcqu = (Pair)paramString.get(i);
            localbcqk.a(this.a.app, this.a, parambcqu, new acny(this, localbcqk, parambcqu));
            i += 1;
          }
        }
      }
    } while (!this.a.isResume());
    localbcqk.a(paramString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acnx
 * JD-Core Version:    0.7.0.1
 */