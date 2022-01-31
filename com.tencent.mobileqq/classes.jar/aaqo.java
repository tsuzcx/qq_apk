import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.EditInfoActivity.14.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class aaqo
  extends baox
{
  public aaqo(EditInfoActivity paramEditInfoActivity) {}
  
  protected void onSetColorNick(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      VasWebviewUtil.reportCommercialDrainage(this.a.app.c(), "group_nickname", "set", "", 1, 0, 0, "", "", "");
      this.a.c(true);
      paramString = (ajtg)this.a.app.a(20);
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
      paramString = ajjy.a(2131637848);
      str = ajjy.a(2131637842);
      try
      {
        babr.a(this.a, 230, paramString, str, ajjy.a(2131637835), ajjy.a(2131637839), new aaqp(this), new aaqq(this)).show();
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
      bbmy.a(this.a, 1, ajjy.a(2131637838), 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (1793 == paramInt)
    {
      EditInfoActivity localEditInfoActivity = this.a;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.a.getString(2131627874);
      }
      bbmy.a(localEditInfoActivity, 1, str, 0).b(this.a.getTitleBarHeight());
      return;
    }
    bbmy.a(this.a, 1, 2131628648, 0).b(this.a.getTitleBarHeight());
    this.a.a.postDelayed(new EditInfoActivity.14.3(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaqo
 * JD-Core Version:    0.7.0.1
 */