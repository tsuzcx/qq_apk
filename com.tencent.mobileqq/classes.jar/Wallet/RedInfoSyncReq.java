package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

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
    Object localObject = this.qVersion;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.OSVersion;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.deviceModel;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.vecRedInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.RedInfoSyncReq
 * JD-Core Version:    0.7.0.1
 */