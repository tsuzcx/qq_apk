package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class C2CVoiceInfo
  extends JceStruct
{
  public String uuid = "";
  
  public C2CVoiceInfo() {}
  
  public C2CVoiceInfo(String paramString)
  {
    this.uuid = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uuid = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.uuid;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.C2CVoiceInfo
 * JD-Core Version:    0.7.0.1
 */