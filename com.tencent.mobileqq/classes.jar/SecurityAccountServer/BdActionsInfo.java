package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BdActionsInfo
  extends JceStruct
{
  public int accountAbi = 0;
  public long bindUin = 0L;
  public long bindingDate = 0L;
  public long isRecommend = 0L;
  public String mobileCode = "";
  public String nationCode = "";
  public long originBinder = 0L;
  
  public BdActionsInfo() {}
  
  public BdActionsInfo(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    this.bindUin = paramLong1;
    this.nationCode = paramString1;
    this.mobileCode = paramString2;
    this.bindingDate = paramLong2;
    this.isRecommend = paramLong3;
    this.originBinder = paramLong4;
    this.accountAbi = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bindUin = paramJceInputStream.read(this.bindUin, 0, true);
    this.nationCode = paramJceInputStream.readString(1, true);
    this.mobileCode = paramJceInputStream.readString(2, true);
    this.bindingDate = paramJceInputStream.read(this.bindingDate, 3, true);
    this.isRecommend = paramJceInputStream.read(this.isRecommend, 4, false);
    this.originBinder = paramJceInputStream.read(this.originBinder, 5, false);
    this.accountAbi = paramJceInputStream.read(this.accountAbi, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bindUin, 0);
    paramJceOutputStream.write(this.nationCode, 1);
    paramJceOutputStream.write(this.mobileCode, 2);
    paramJceOutputStream.write(this.bindingDate, 3);
    paramJceOutputStream.write(this.isRecommend, 4);
    paramJceOutputStream.write(this.originBinder, 5);
    paramJceOutputStream.write(this.accountAbi, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SecurityAccountServer.BdActionsInfo
 * JD-Core Version:    0.7.0.1
 */