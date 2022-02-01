package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GuestGetLikeRsp
  extends JceStruct
{
  static CommRsp cache_errInfo = new CommRsp();
  public boolean canLike = true;
  public CommRsp errInfo = null;
  public boolean hasLiked = true;
  
  public GuestGetLikeRsp() {}
  
  public GuestGetLikeRsp(CommRsp paramCommRsp, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.errInfo = paramCommRsp;
    this.canLike = paramBoolean1;
    this.hasLiked = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.errInfo = ((CommRsp)paramJceInputStream.read(cache_errInfo, 0, false));
    this.canLike = paramJceInputStream.read(this.canLike, 1, false);
    this.hasLiked = paramJceInputStream.read(this.hasLiked, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    CommRsp localCommRsp = this.errInfo;
    if (localCommRsp != null) {
      paramJceOutputStream.write(localCommRsp, 0);
    }
    paramJceOutputStream.write(this.canLike, 1);
    paramJceOutputStream.write(this.hasLiked, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VIP.GuestGetLikeRsp
 * JD-Core Version:    0.7.0.1
 */