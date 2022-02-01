package UserGrowth;

import NS_KING_INTERFACE.stGetFeedCommentListV2Req;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stQQGetFeedCommentListV2Req
  extends JceStruct
{
  static stGetFeedCommentListV2Req cache_req = new stGetFeedCommentListV2Req();
  public stGetFeedCommentListV2Req req = null;
  
  public stQQGetFeedCommentListV2Req() {}
  
  public stQQGetFeedCommentListV2Req(stGetFeedCommentListV2Req paramstGetFeedCommentListV2Req)
  {
    this.req = paramstGetFeedCommentListV2Req;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.req = ((stGetFeedCommentListV2Req)paramJceInputStream.read(cache_req, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.req != null) {
      paramJceOutputStream.write(this.req, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stQQGetFeedCommentListV2Req
 * JD-Core Version:    0.7.0.1
 */