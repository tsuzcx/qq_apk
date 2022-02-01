package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class HostGetLikeRsp
  extends JceStruct
{
  static CommRsp cache_errInfo = new CommRsp();
  public boolean canLike = true;
  public CommRsp errInfo = null;
  public boolean hasLiked = true;
  public long iTotal = 0L;
  
  public HostGetLikeRsp() {}
  
  public HostGetLikeRsp(CommRsp paramCommRsp, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.errInfo = paramCommRsp;
    this.iTotal = paramLong;
    this.canLike = paramBoolean1;
    this.hasLiked = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.errInfo = ((CommRsp)paramJceInputStream.read(cache_errInfo, 0, false));
    this.iTotal = paramJceInputStream.read(this.iTotal, 1, false);
    this.canLike = paramJceInputStream.read(this.canLike, 2, false);
    this.hasLiked = paramJceInputStream.read(this.hasLiked, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.errInfo != null) {
      paramJceOutputStream.write(this.errInfo, 0);
    }
    paramJceOutputStream.write(this.iTotal, 1);
    paramJceOutputStream.write(this.canLike, 2);
    paramJceOutputStream.write(this.hasLiked, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VIP.HostGetLikeRsp
 * JD-Core Version:    0.7.0.1
 */