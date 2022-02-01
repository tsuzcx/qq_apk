import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.FormSimpleItem;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x5e1.UdcUinData;

public class adwr
  extends ayxn
{
  public adwr(AuthDevActivity paramAuthDevActivity) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    super.a(paramString1, paramInt, paramString2);
  }
  
  public void a(oidb_0x5e1.RspBody paramRspBody)
  {
    super.a(paramRspBody);
    AuthDevActivity.a(this.a, paramRspBody);
    int i = ((oidb_0x5e1.UdcUinData)AuthDevActivity.a(this.a).rpt_msg_uin_data.get(0)).user_login_guard_face.get();
    FormSimpleItem localFormSimpleItem = AuthDevActivity.a(this.a);
    if (i == 1)
    {
      paramRspBody = this.a.getString(2131691952);
      localFormSimpleItem.setRightText(paramRspBody);
      if (i != 1) {
        break label111;
      }
    }
    label111:
    for (paramRspBody = "1";; paramRspBody = "0")
    {
      bdll.b(null, "dc00898", "", "", "0X800AA7C", "0X800AA7C", 0, 0, paramRspBody, "", "", "");
      return;
      paramRspBody = this.a.getString(2131691957);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwr
 * JD-Core Version:    0.7.0.1
 */