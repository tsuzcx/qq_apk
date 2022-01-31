import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;

public class alkf
{
  public ArrayList<alkg> a;
  
  public static alkf a(oidb_0x74b.RspBody paramRspBody)
  {
    Object localObject;
    if (paramRspBody == null) {
      localObject = null;
    }
    alkf localalkf;
    do
    {
      return localObject;
      localalkf = new alkf();
      localObject = localalkf;
    } while (!paramRspBody.rpt_msg_uin_head_list.has());
    localalkf.a = alkg.a(paramRspBody.rpt_msg_uin_head_list.get());
    return localalkf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alkf
 * JD-Core Version:    0.7.0.1
 */