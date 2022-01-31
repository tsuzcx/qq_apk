package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetPicUrlByKeysRsp
  extends JceStruct
{
  public String picUrl = "";
  
  public stGetPicUrlByKeysRsp() {}
  
  public stGetPicUrlByKeysRsp(String paramString)
  {
    this.picUrl = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.picUrl = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.picUrl, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     WMDBClientInterface.stGetPicUrlByKeysRsp
 * JD-Core Version:    0.7.0.1
 */