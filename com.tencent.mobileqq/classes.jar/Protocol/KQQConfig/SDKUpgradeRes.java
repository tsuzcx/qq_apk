package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SDKUpgradeRes
  extends JceStruct
{
  static ArrayList<UpgradeInfo> cache_vUpgradeInfo;
  public int iActionType;
  public ArrayList<UpgradeInfo> vUpgradeInfo;
  
  public SDKUpgradeRes() {}
  
  public SDKUpgradeRes(ArrayList<UpgradeInfo> paramArrayList, int paramInt)
  {
    this.vUpgradeInfo = paramArrayList;
    this.iActionType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vUpgradeInfo == null)
    {
      cache_vUpgradeInfo = new ArrayList();
      UpgradeInfo localUpgradeInfo = new UpgradeInfo();
      cache_vUpgradeInfo.add(localUpgradeInfo);
    }
    this.vUpgradeInfo = ((ArrayList)paramJceInputStream.read(cache_vUpgradeInfo, 1, true));
    this.iActionType = paramJceInputStream.read(this.iActionType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vUpgradeInfo, 1);
    paramJceOutputStream.write(this.iActionType, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     protocol.KQQConfig.SDKUpgradeRes
 * JD-Core Version:    0.7.0.1
 */