package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetFeedIconOpRsp
  extends JceStruct
{
  static stBusinessIconInfo cache_businessIcon;
  static stFeedIconOpConf cache_feedIconOpConf = new stFeedIconOpConf();
  static stFeedOpInfo cache_opInfo = new stFeedOpInfo();
  static stFunctionalIconInfo cache_shootIconInfo;
  public stBusinessIconInfo businessIcon = null;
  public stFeedIconOpConf feedIconOpConf = null;
  public stFeedOpInfo opInfo = null;
  public stFunctionalIconInfo shootIconInfo = null;
  
  static
  {
    cache_businessIcon = new stBusinessIconInfo();
    cache_shootIconInfo = new stFunctionalIconInfo();
  }
  
  public stGetFeedIconOpRsp() {}
  
  public stGetFeedIconOpRsp(stFeedOpInfo paramstFeedOpInfo, stBusinessIconInfo paramstBusinessIconInfo, stFunctionalIconInfo paramstFunctionalIconInfo, stFeedIconOpConf paramstFeedIconOpConf)
  {
    this.opInfo = paramstFeedOpInfo;
    this.businessIcon = paramstBusinessIconInfo;
    this.shootIconInfo = paramstFunctionalIconInfo;
    this.feedIconOpConf = paramstFeedIconOpConf;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.opInfo = ((stFeedOpInfo)paramJceInputStream.read(cache_opInfo, 0, false));
    this.businessIcon = ((stBusinessIconInfo)paramJceInputStream.read(cache_businessIcon, 1, false));
    this.shootIconInfo = ((stFunctionalIconInfo)paramJceInputStream.read(cache_shootIconInfo, 2, false));
    this.feedIconOpConf = ((stFeedIconOpConf)paramJceInputStream.read(cache_feedIconOpConf, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.opInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.businessIcon;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.shootIconInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.feedIconOpConf;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetFeedIconOpRsp
 * JD-Core Version:    0.7.0.1
 */