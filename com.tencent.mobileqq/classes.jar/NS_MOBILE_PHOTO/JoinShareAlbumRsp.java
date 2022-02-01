package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class JoinShareAlbumRsp
  extends JceStruct
{
  public boolean isAutoJoin = false;
  public String msg = "";
  public int ret = 0;
  
  public JoinShareAlbumRsp() {}
  
  public JoinShareAlbumRsp(int paramInt, String paramString)
  {
    this.ret = paramInt;
    this.msg = paramString;
    this.isAutoJoin = this.isAutoJoin;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.isAutoJoin = paramJceInputStream.read(this.isAutoJoin, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    String str = this.msg;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.isAutoJoin, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.JoinShareAlbumRsp
 * JD-Core Version:    0.7.0.1
 */