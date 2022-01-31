import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;

public class alys
{
  public ArrayList<alyt> a;
  
  public static alys a(oidb_0x74b.RspBody paramRspBody)
  {
    Object localObject;
    if (paramRspBody == null) {
      localObject = null;
    }
    alys localalys;
    do
    {
      return localObject;
      localalys = new alys();
      localObject = localalys;
    } while (!paramRspBody.rpt_msg_uin_head_list.has());
    localalys.a = alyt.a(paramRspBody.rpt_msg_uin_head_list.get());
    return localalys;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alys
 * JD-Core Version:    0.7.0.1
 */