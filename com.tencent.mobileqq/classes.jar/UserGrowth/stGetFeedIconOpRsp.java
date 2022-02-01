package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetFeedIconOpRsp
  extends JceStruct
{
  static stBusinessIconInfo cache_businessIcon = new stBusinessIconInfo();
  static stFeedOpInfo cache_opInfo = new stFeedOpInfo();
  static stFunctionalIconInfo cache_shootIconInfo = new stFunctionalIconInfo();
  public stBusinessIconInfo businessIcon = null;
  public stFeedOpInfo opInfo = null;
  public stFunctionalIconInfo shootIconInfo = null;
  
  public stGetFeedIconOpRsp() {}
  
  public stGetFeedIconOpRsp(stFeedOpInfo paramstFeedOpInfo, stBusinessIconInfo paramstBusinessIconInfo, stFunctionalIconInfo paramstFunctionalIconInfo)
  {
    this.opInfo = paramstFeedOpInfo;
    this.businessIcon = paramstBusinessIconInfo;
    this.shootIconInfo = paramstFunctionalIconInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.opInfo = ((stFeedOpInfo)paramJceInputStream.read(cache_opInfo, 0, false));
    this.businessIcon = ((stBusinessIconInfo)paramJceInputStream.read(cache_businessIcon, 1, false));
    this.shootIconInfo = ((stFunctionalIconInfo)paramJceInputStream.read(cache_shootIconInfo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.opInfo != null) {
      paramJceOutputStream.write(this.opInfo, 0);
    }
    if (this.businessIcon != null) {
      paramJceOutputStream.write(this.businessIcon, 1);
    }
    if (this.shootIconInfo != null) {
      paramJceOutputStream.write(this.shootIconInfo, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stGetFeedIconOpRsp
 * JD-Core Version:    0.7.0.1
 */