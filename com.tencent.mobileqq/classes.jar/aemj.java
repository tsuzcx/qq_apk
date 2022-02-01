import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.EditInfoActivity.15.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aemj
  extends bhzs
{
  public aemj(EditInfoActivity paramEditInfoActivity) {}
  
  protected void onSetColorNick(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      VasWebviewUtil.reportCommercialDrainage(this.a.app.c(), "group_nickname", "set", "", 1, 0, 0, "", "", "");
      this.a.c(true);
      paramString = (aoip)this.a.app.a(20);
      try
      {
        paramString.a(Long.parseLong(this.a.e), Long.parseLong(this.a.f));
        return;
      }
      catch (Exception paramString)
      {
        this.a.b(false);
        return;
      }
    }
    this.a.b(false);
    String str;
    if (paramInt == 1282)
    {
      VasWebviewUtil.reportCommercialDrainage(this.a.app.c(), "group_nickname", "group_nickname_9", "", 1, 0, 0, "", "", "");
      paramString = anzj.a(2131702532);
      str = anzj.a(2131702526);
      try
      {
        bhlq.a(this.a, 230, paramString, str, anzj.a(2131702519), anzj.a(2131702523), new aemk(this), new aeml(this)).show();
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("EditInfoActivity", 1, "onSetColorNick", paramString);
        return;
      }
    }
    if (1283 == paramInt)
    {
      QQToast.a(this.a, 1, anzj.a(2131702522), 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (1793 == paramInt)
    {
      EditInfoActivity localEditInfoActivity = this.a;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.a.getString(2131693028);
      }
      QQToast.a(localEditInfoActivity, 1, str, 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a, 1, 2131693743, 0).b(this.a.getTitleBarHeight());
    this.a.a.postDelayed(new EditInfoActivity.15.3(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aemj
 * JD-Core Version:    0.7.0.1
 */