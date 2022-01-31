package CommonClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stRspHeader
  extends JceStruct
{
  public int iRet = 0;
  public String sErrmsg = "";
  
  public stRspHeader() {}
  
  public stRspHeader(int paramInt, String paramString)
  {
    this.iRet = paramInt;
    this.sErrmsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRet = paramJceInputStream.read(this.iRet, 0, true);
    this.sErrmsg = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRet, 0);
    paramJceOutputStream.write(this.sErrmsg, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     CommonClientInterface.stRspHeader
 * JD-Core Version:    0.7.0.1
 */