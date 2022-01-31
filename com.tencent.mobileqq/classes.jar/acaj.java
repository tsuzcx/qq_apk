import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.qphone.base.util.QLog;

public class acaj
  implements DialogInterface.OnClickListener
{
  public acaj(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("vip_ptt.AssistantSettingActivity", 1, "click pay for auto ptt");
    paramDialogInterface = aoqj.c();
    if (TextUtils.isEmpty(paramDialogInterface.a)) {
      bdia.a(this.a, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&type=!svip&aid=mvip.n.a.zdzwz");
    }
    for (;;)
    {
      this.a.b();
      return;
      paramDialogInterface = paramDialogInterface.a.replace("{aid}", "mvip.n.a.zdzwz");
      bdia.a(this.a, paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acaj
 * JD-Core Version:    0.7.0.1
 */