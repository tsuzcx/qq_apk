package Wallet;

import bdgk;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.activity.qwallet.red.QWRedConfig.RedInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class RedInfoSyncReq
  extends JceStruct
{
  public static final int PLAT_ANDROID = 1;
  static ArrayList<RedInfo> cache_vecRedInfo = new ArrayList();
  public String OSVersion = "";
  public String deviceModel = "";
  public int platId;
  public String qVersion = "";
  public ArrayList<RedInfo> vecRedInfo;
  
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
  
  public static RedInfoSyncReq createReq(List<QWRedConfig.RedInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QWRedConfig.RedInfo localRedInfo = (QWRedConfig.RedInfo)paramList.next();
      localArrayList.add(new RedInfo(localRedInfo.path, localRedInfo.taskId, localRedInfo.isShow));
    }
    return new RedInfoSyncReq(1, bdgk.c(), bdgk.e(), bdgk.i(), localArrayList);
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