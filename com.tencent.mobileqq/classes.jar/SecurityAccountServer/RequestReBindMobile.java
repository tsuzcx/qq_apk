package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestReBindMobile
  extends JceStruct
{
  static int cache_type;
  public boolean isFromChangeBind;
  public boolean isFromUni;
  public String mobileNo = "";
  public String nationCode = "";
  public long originBinder;
  public int type = 0;
  
  public RequestReBindMobile() {}
  
  public RequestReBindMobile(String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.nationCode = paramString1;
    this.mobileNo = paramString2;
    this.originBinder = paramLong;
    this.type = paramInt;
    this.isFromUni = paramBoolean1;
    this.isFromChangeBind = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nationCode = paramJceInputStream.readString(0, true);
    this.mobileNo = paramJceInputStream.readString(1, true);
    this.originBinder = paramJceInputStream.read(this.originBinder, 2, false);
    this.type = paramJceInputStream.read(this.type, 3, false);
    this.isFromUni = paramJceInputStream.read(this.isFromUni, 4, false);
    this.isFromChangeBind = paramJceInputStream.read(this.isFromChangeBind, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nationCode, 0);
    paramJceOutputStream.write(this.mobileNo, 1);
    paramJceOutputStream.write(this.originBinder, 2);
    paramJceOutputStream.write(this.type, 3);
    paramJceOutputStream.write(this.isFromUni, 4);
    paramJceOutputStream.write(this.isFromChangeBind, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     SecurityAccountServer.RequestReBindMobile
 * JD-Core Version:    0.7.0.1
 */