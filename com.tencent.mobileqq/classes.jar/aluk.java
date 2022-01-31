import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

class aluk
  implements bemh<oidb_0x8e4.RspBody>
{
  aluk(aluj paramaluj) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if (paramInt == 0)
    {
      paramRspBody = paramRspBody.string_invite_id.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramRspBody))
      {
        com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.a = paramRspBody;
        auxp.a().a(0, paramRspBody, 0L, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aluk
 * JD-Core Version:    0.7.0.1
 */