package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MemberAttrInfo
  extends JceStruct
{
  public String StrValue = "";
  public int Value = 0;
  
  public MemberAttrInfo() {}
  
  public MemberAttrInfo(int paramInt, String paramString)
  {
    this.Value = paramInt;
    this.StrValue = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Value = paramJceInputStream.read(this.Value, 0, true);
    this.StrValue = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Value, 0);
    String str = this.StrValue;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.MemberAttrInfo
 * JD-Core Version:    0.7.0.1
 */