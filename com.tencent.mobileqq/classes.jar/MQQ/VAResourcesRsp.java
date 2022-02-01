package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class VAResourcesRsp
  extends JceStruct
{
  static LhLogoInfo cache_lhLogoInfo = new LhLogoInfo();
  public int iSyncFreq = -1;
  public LhLogoInfo lhLogoInfo = null;
  
  public VAResourcesRsp() {}
  
  public VAResourcesRsp(int paramInt, LhLogoInfo paramLhLogoInfo)
  {
    this.iSyncFreq = paramInt;
    this.lhLogoInfo = paramLhLogoInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iSyncFreq = paramJceInputStream.read(this.iSyncFreq, 0, false);
    this.lhLogoInfo = ((LhLogoInfo)paramJceInputStream.read(cache_lhLogoInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iSyncFreq, 0);
    LhLogoInfo localLhLogoInfo = this.lhLogoInfo;
    if (localLhLogoInfo != null) {
      paramJceOutputStream.write(localLhLogoInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MQQ.VAResourcesRsp
 * JD-Core Version:    0.7.0.1
 */