import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;

public class alyt
{
  public ArrayList<alyu> a;
  
  public static alyt a(oidb_0x74b.RspBody paramRspBody)
  {
    Object localObject;
    if (paramRspBody == null) {
      localObject = null;
    }
    alyt localalyt;
    do
    {
      return localObject;
      localalyt = new alyt();
      localObject = localalyt;
    } while (!paramRspBody.rpt_msg_uin_head_list.has());
    localalyt.a = alyu.a(paramRspBody.rpt_msg_uin_head_list.get());
    return localalyt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alyt
 * JD-Core Version:    0.7.0.1
 */