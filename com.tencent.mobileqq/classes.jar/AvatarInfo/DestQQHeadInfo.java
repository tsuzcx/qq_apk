package AvatarInfo;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DestQQHeadInfo
  extends JceStruct
  implements Cloneable
{
  public long dstUin;
  public long dwTimestamp;
  public String phoneNum = "";
  
  public DestQQHeadInfo() {}
  
  public DestQQHeadInfo(long paramLong1, long paramLong2, String paramString)
  {
    this.dstUin = paramLong1;
    this.dwTimestamp = paramLong2;
    this.phoneNum = paramString;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.dstUin, "dstUin");
    paramStringBuilder.display(this.dwTimestamp, "dwTimestamp");
    paramStringBuilder.display(this.phoneNum, "phoneNum");
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dstUin = paramJceInputStream.read(this.dstUin, 0, true);
    this.dwTimestamp = paramJceInputStream.read(this.dwTimestamp, 1, true);
    this.phoneNum = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dstUin, 0);
    paramJceOutputStream.write(this.dwTimestamp, 1);
    if (this.phoneNum != null) {
      paramJceOutputStream.write(this.phoneNum, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom1.jar
 * Qualified Name:     AvatarInfo.DestQQHeadInfo
 * JD-Core Version:    0.7.0.1
 */