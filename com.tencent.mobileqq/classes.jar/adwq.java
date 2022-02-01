import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.EditInfoActivity.21.3;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class adwq
  extends bhow
{
  public adwq(EditInfoActivity paramEditInfoActivity) {}
  
  protected void onSetColorNick(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      VasWebviewUtil.reportCommercialDrainage(this.a.app.getCurrentUin(), "group_nickname", "set", "", 1, 0, 0, "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("ColorNick", 2, "onSetColorNick. clear saved colorNick");
      }
      this.a.c(true);
      paramString = (aoep)this.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
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
      VasWebviewUtil.reportCommercialDrainage(this.a.app.getCurrentUin(), "group_nickname", "group_nickname_9", "", 1, 0, 0, "", "", "");
      paramString = anvx.a(2131703118);
      str = anvx.a(2131703112);
      try
      {
        bhdj.a(this.a, 230, paramString, str, anvx.a(2131703105), anvx.a(2131703109), new adwr(this), new adws(this)).show();
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
      QQToast.a(this.a, 1, anvx.a(2131703108), 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (1793 == paramInt)
    {
      EditInfoActivity localEditInfoActivity = this.a;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.a.getString(2131693250);
      }
      QQToast.a(localEditInfoActivity, 1, str, 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a, 1, 2131694032, 0).b(this.a.getTitleBarHeight());
    this.a.a.postDelayed(new EditInfoActivity.21.3(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwq
 * JD-Core Version:    0.7.0.1
 */