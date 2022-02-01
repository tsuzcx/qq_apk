package UserGrowth;

import NS_KING_SOCIALIZE_META.stShareInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetPersonalInfoRsp
  extends JceStruct
{
  static stSimpleMetaPerson cache_info = new stSimpleMetaPerson();
  static stShareInfo cache_share_info = new stShareInfo();
  public stSimpleMetaPerson info = null;
  public int isShowPraisedFeed = 0;
  public stShareInfo share_info = null;
  
  public stGetPersonalInfoRsp() {}
  
  public stGetPersonalInfoRsp(stSimpleMetaPerson paramstSimpleMetaPerson, int paramInt, stShareInfo paramstShareInfo)
  {
    this.info = paramstSimpleMetaPerson;
    this.isShowPraisedFeed = paramInt;
    this.share_info = paramstShareInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.info = ((stSimpleMetaPerson)paramJceInputStream.read(cache_info, 0, false));
    this.isShowPraisedFeed = paramJceInputStream.read(this.isShowPraisedFeed, 1, false);
    this.share_info = ((stShareInfo)paramJceInputStream.read(cache_share_info, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    paramJceOutputStream.write(this.isShowPraisedFeed, 1);
    localObject = this.share_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetPersonalInfoRsp
 * JD-Core Version:    0.7.0.1
 */