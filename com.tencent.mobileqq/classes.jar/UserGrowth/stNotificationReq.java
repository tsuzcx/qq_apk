package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stNotificationReq
  extends JceStruct
{
  static stLinkStragegyArgs cache_linkStrategyArgs = new stLinkStragegyArgs();
  public stLinkStragegyArgs linkStrategyArgs = null;
  public String personid = "";
  public String push_info = "";
  
  public stNotificationReq() {}
  
  public stNotificationReq(String paramString1, stLinkStragegyArgs paramstLinkStragegyArgs, String paramString2)
  {
    this.personid = paramString1;
    this.linkStrategyArgs = paramstLinkStragegyArgs;
    this.push_info = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.personid = paramJceInputStream.readString(0, false);
    this.linkStrategyArgs = ((stLinkStragegyArgs)paramJceInputStream.read(cache_linkStrategyArgs, 1, false));
    this.push_info = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.personid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.linkStrategyArgs;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.push_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stNotificationReq
 * JD-Core Version:    0.7.0.1
 */