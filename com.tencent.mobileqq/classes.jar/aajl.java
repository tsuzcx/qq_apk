import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.qphone.base.util.QLog;

public class aajl
  implements DialogInterface.OnClickListener
{
  public aajl(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("vip_ptt.AssistantSettingActivity", 1, "click pay for auto ptt");
    paramDialogInterface = amzc.c();
    if (TextUtils.isEmpty(paramDialogInterface.a)) {
      bbje.a(this.a, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&type=!svip&aid=mvip.n.a.zdzwz");
    }
    for (;;)
    {
      this.a.b();
      return;
      paramDialogInterface = paramDialogInterface.a.replace("{aid}", "mvip.n.a.zdzwz");
      bbje.a(this.a, paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aajl
 * JD-Core Version:    0.7.0.1
 */