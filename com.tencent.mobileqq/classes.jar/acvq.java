import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.EditInfoActivity.14.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class acvq
  extends bdul
{
  public acvq(EditInfoActivity paramEditInfoActivity) {}
  
  protected void onSetColorNick(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      VasWebviewUtil.reportCommercialDrainage(this.a.app.c(), "group_nickname", "set", "", 1, 0, 0, "", "", "");
      this.a.c(true);
      paramString = (amdu)this.a.app.a(20);
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
      paramString = alud.a(2131704028);
      str = alud.a(2131704022);
      try
      {
        bdgm.a(this.a, 230, paramString, str, alud.a(2131704015), alud.a(2131704019), new acvr(this), new acvs(this)).show();
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
      QQToast.a(this.a, 1, alud.a(2131704018), 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (1793 == paramInt)
    {
      EditInfoActivity localEditInfoActivity = this.a;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.a.getString(2131693619);
      }
      QQToast.a(localEditInfoActivity, 1, str, 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a, 1, 2131694456, 0).b(this.a.getTitleBarHeight());
    this.a.a.postDelayed(new EditInfoActivity.14.3(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acvq
 * JD-Core Version:    0.7.0.1
 */