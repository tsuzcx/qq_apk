package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SetUserTailReq
  extends JceStruct
{
  public int iDiyTag;
  public String strDiyMemo = "";
  public String strIdentifySqua = "";
  
  public SetUserTailReq() {}
  
  public SetUserTailReq(String paramString1, String paramString2, int paramInt)
  {
    this.strIdentifySqua = paramString1;
    this.strDiyMemo = paramString2;
    this.iDiyTag = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strIdentifySqua = paramJceInputStream.readString(0, false);
    this.strDiyMemo = paramJceInputStream.readString(1, false);
    this.iDiyTag = paramJceInputStream.read(this.iDiyTag, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.strIdentifySqua;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.strDiyMemo;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.iDiyTag, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_EXTRA.SetUserTailReq
 * JD-Core Version:    0.7.0.1
 */