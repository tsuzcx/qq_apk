package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetLikeListRsp
  extends JceStruct
{
  static CommRsp cache_errInfo = new CommRsp();
  static LikeListInfo cache_stLikeList = new LikeListInfo();
  public CommRsp errInfo = null;
  public long iTotal = 0L;
  public boolean isEnd = true;
  public String sCookie = "";
  public LikeListInfo stLikeList = null;
  
  public GetLikeListRsp() {}
  
  public GetLikeListRsp(CommRsp paramCommRsp, LikeListInfo paramLikeListInfo, String paramString, boolean paramBoolean, long paramLong)
  {
    this.errInfo = paramCommRsp;
    this.stLikeList = paramLikeListInfo;
    this.sCookie = paramString;
    this.isEnd = paramBoolean;
    this.iTotal = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.errInfo = ((CommRsp)paramJceInputStream.read(cache_errInfo, 0, false));
    this.stLikeList = ((LikeListInfo)paramJceInputStream.read(cache_stLikeList, 1, false));
    this.sCookie = paramJceInputStream.readString(2, false);
    this.isEnd = paramJceInputStream.read(this.isEnd, 3, false);
    this.iTotal = paramJceInputStream.read(this.iTotal, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.errInfo != null) {
      paramJceOutputStream.write(this.errInfo, 0);
    }
    if (this.stLikeList != null) {
      paramJceOutputStream.write(this.stLikeList, 1);
    }
    if (this.sCookie != null) {
      paramJceOutputStream.write(this.sCookie, 2);
    }
    paramJceOutputStream.write(this.isEnd, 3);
    paramJceOutputStream.write(this.iTotal, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VIP.GetLikeListRsp
 * JD-Core Version:    0.7.0.1
 */