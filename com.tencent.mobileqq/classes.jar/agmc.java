import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.EmptyStatusInfo;

public class agmc
{
  public String a;
  
  public static agmc a(oidb_0xcf4.EmptyStatusInfo paramEmptyStatusInfo)
  {
    Object localObject;
    if (paramEmptyStatusInfo == null) {
      localObject = null;
    }
    agmc localagmc;
    do
    {
      return localObject;
      localagmc = new agmc();
      localObject = localagmc;
    } while (!paramEmptyStatusInfo.bytes_jump_url.has());
    localagmc.a = paramEmptyStatusInfo.bytes_jump_url.get().toStringUtf8();
    return localagmc;
  }
  
  public String toString()
  {
    return "EmptyStatusInfo{jumpUrl=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmc
 * JD-Core Version:    0.7.0.1
 */