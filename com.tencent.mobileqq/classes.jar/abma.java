import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x5e1.UdcUinData;

public class abma
  extends atzn
{
  public abma(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    bcpw.a(this.a, paramString2, 0).a();
    QLog.e("LoginInfoActivity.AccDevSec", 1, "cmd : " + paramString1 + " request failed  code : " + paramInt + " message : " + paramString2);
    LoginInfoActivity.a(this.a).setVisibility(4);
  }
  
  public void a(oidb_0x5e1.RspBody paramRspBody)
  {
    LoginInfoActivity.a(this.a, paramRspBody);
    int i = ((oidb_0x5e1.UdcUinData)paramRspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.get();
    TextView localTextView = LoginInfoActivity.b(this.a);
    if (i == 1)
    {
      paramRspBody = this.a.getString(2131692277);
      localTextView.setText(paramRspBody);
      LoginInfoActivity.a(this.a).setVisibility(4);
      LoginInfoActivity.b(this.a).setVisibility(0);
      if (i != 1) {
        break label122;
      }
    }
    label122:
    for (paramRspBody = "1";; paramRspBody = "0")
    {
      axqw.b(null, "dc00898", "", "", "0X800AA7A", "0X800AA7A", 0, 0, paramRspBody, "", "", "");
      return;
      paramRspBody = this.a.getString(2131692284);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abma
 * JD-Core Version:    0.7.0.1
 */