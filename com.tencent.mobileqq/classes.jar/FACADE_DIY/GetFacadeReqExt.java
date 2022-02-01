package FACADE_DIY;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetFacadeReqExt
  extends JceStruct
{
  public String cachedChecksum = "";
  
  public GetFacadeReqExt() {}
  
  public GetFacadeReqExt(String paramString)
  {
    this.cachedChecksum = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cachedChecksum = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.cachedChecksum;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     FACADE_DIY.GetFacadeReqExt
 * JD-Core Version:    0.7.0.1
 */