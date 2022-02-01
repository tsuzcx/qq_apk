package NS_FASHION_FEEDS_TAG_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetPicTagBinRspNode
  extends JceStruct
{
  static PicTagInfo cache_stPicTagInfo = new PicTagInfo();
  public PicTagInfo stPicTagInfo = null;
  
  public GetPicTagBinRspNode() {}
  
  public GetPicTagBinRspNode(PicTagInfo paramPicTagInfo)
  {
    this.stPicTagInfo = paramPicTagInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stPicTagInfo = ((PicTagInfo)paramJceInputStream.read(cache_stPicTagInfo, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stPicTagInfo != null) {
      paramJceOutputStream.write(this.stPicTagInfo, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_FASHION_FEEDS_TAG_PROTO.GetPicTagBinRspNode
 * JD-Core Version:    0.7.0.1
 */