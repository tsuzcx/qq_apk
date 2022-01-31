package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ResponeQueryLastLoginState
  extends JceStruct
{
  static ArrayList cache_lastLoginList;
  public long interval;
  public ArrayList lastLoginList;
  public long lastUsedFlag = 1L;
  public String mobileNo = "";
  public String nationCode = "";
  public long nextFlag;
  public long timeStamp;
  
  public ResponeQueryLastLoginState() {}
  
  public ResponeQueryLastLoginState(long paramLong1, long paramLong2, long paramLong3, ArrayList paramArrayList, String paramString1, String paramString2, long paramLong4)
  {
    this.nextFlag = paramLong1;
    this.timeStamp = paramLong2;
    this.interval = paramLong3;
    this.lastLoginList = paramArrayList;
    this.nationCode = paramString1;
    this.mobileNo = paramString2;
    this.lastUsedFlag = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 1, true);
    this.interval = paramJceInputStream.read(this.interval, 2, true);
    if (cache_lastLoginList == null)
    {
      cache_lastLoginList = new ArrayList();
      LastLoginInfo localLastLoginInfo = new LastLoginInfo();
      cache_lastLoginList.add(localLastLoginInfo);
    }
    this.lastLoginList = ((ArrayList)paramJceInputStream.read(cache_lastLoginList, 3, true));
    this.nationCode = paramJceInputStream.readString(4, true);
    this.mobileNo = paramJceInputStream.readString(5, true);
    this.lastUsedFlag = paramJceInputStream.read(this.lastUsedFlag, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.timeStamp, 1);
    paramJceOutputStream.write(this.interval, 2);
    paramJceOutputStream.write(this.lastLoginList, 3);
    paramJceOutputStream.write(this.nationCode, 4);
    paramJceOutputStream.write(this.mobileNo, 5);
    paramJceOutputStream.write(this.lastUsedFlag, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SecurityAccountServer.ResponeQueryLastLoginState
 * JD-Core Version:    0.7.0.1
 */