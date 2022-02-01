package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RedInfoSyncReq
  extends JceStruct
{
  public static final int PLAT_ANDROID = 1;
  static ArrayList<RedInfo> cache_vecRedInfo = new ArrayList();
  public String OSVersion = "";
  public String deviceModel = "";
  public int platId = 0;
  public String qVersion = "";
  public ArrayList<RedInfo> vecRedInfo = null;
  
  static
  {
    RedInfo localRedInfo = new RedInfo();
    cache_vecRedInfo.add(localRedInfo);
  }
  
  public RedInfoSyncReq() {}
  
  public RedInfoSyncReq(int paramInt, String paramString1, String paramString2, String paramString3, ArrayList<RedInfo> paramArrayList)
  {
    this.platId = paramInt;
    this.qVersion = paramString1;
    this.OSVersion = paramString2;
    this.deviceModel = paramString3;
    this.vecRedInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.platId = paramJceInputStream.read(this.platId, 0, false);
    this.qVersion = paramJceInputStream.readString(1, false);
    this.OSVersion = paramJceInputStream.readString(2, false);
    this.deviceModel = paramJceInputStream.readString(3, false);
    this.vecRedInfo = ((ArrayList)paramJceInputStream.read(cache_vecRedInfo, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.platId, 0);
    if (this.qVersion != null) {
      paramJceOutputStream.write(this.qVersion, 1);
    }
    if (this.OSVersion != null) {
      paramJceOutputStream.write(this.OSVersion, 2);
    }
    if (this.deviceModel != null) {
      paramJceOutputStream.write(this.deviceModel, 3);
    }
    if (this.vecRedInfo != null) {
      paramJceOutputStream.write(this.vecRedInfo, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.RedInfoSyncReq
 * JD-Core Version:    0.7.0.1
 */