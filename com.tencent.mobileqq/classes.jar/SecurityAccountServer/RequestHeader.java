package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestHeader
  extends JceStruct
{
  static int cache_assistImport;
  public String account = "";
  public int appid = 0;
  public int assistImport = 0;
  public String channel_id = "";
  public int cmd = 0;
  public String ksid = "";
  public int requestID = 0;
  public String sbid = "";
  public int svrSeqNo = 0;
  public long uin = 0L;
  public int ver = 0;
  
  public RequestHeader() {}
  
  public RequestHeader(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int paramInt5, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt6)
  {
    this.ver = paramInt1;
    this.cmd = paramInt2;
    this.requestID = paramInt3;
    this.svrSeqNo = paramInt4;
    this.account = paramString1;
    this.appid = paramInt5;
    this.sbid = paramString2;
    this.channel_id = paramString3;
    this.ksid = paramString4;
    this.uin = paramLong;
    this.assistImport = paramInt6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ver = paramJceInputStream.read(this.ver, 0, true);
    this.cmd = paramJceInputStream.read(this.cmd, 1, true);
    this.requestID = paramJceInputStream.read(this.requestID, 2, true);
    this.svrSeqNo = paramJceInputStream.read(this.svrSeqNo, 3, true);
    this.account = paramJceInputStream.readString(4, true);
    this.appid = paramJceInputStream.read(this.appid, 5, true);
    this.sbid = paramJceInputStream.readString(6, true);
    this.channel_id = paramJceInputStream.readString(7, true);
    this.ksid = paramJceInputStream.readString(8, true);
    this.uin = paramJceInputStream.read(this.uin, 9, false);
    this.assistImport = paramJceInputStream.read(this.assistImport, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ver, 0);
    paramJceOutputStream.write(this.cmd, 1);
    paramJceOutputStream.write(this.requestID, 2);
    paramJceOutputStream.write(this.svrSeqNo, 3);
    paramJceOutputStream.write(this.account, 4);
    paramJceOutputStream.write(this.appid, 5);
    paramJceOutputStream.write(this.sbid, 6);
    paramJceOutputStream.write(this.channel_id, 7);
    paramJceOutputStream.write(this.ksid, 8);
    paramJceOutputStream.write(this.uin, 9);
    paramJceOutputStream.write(this.assistImport, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SecurityAccountServer.RequestHeader
 * JD-Core Version:    0.7.0.1
 */