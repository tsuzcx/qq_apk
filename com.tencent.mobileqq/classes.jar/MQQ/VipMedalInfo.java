package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class VipMedalInfo
  extends JceStruct
{
  public int is_remind = 0;
  public int tips_times = 0;
  public int type = 0;
  public String value = "";
  
  public VipMedalInfo() {}
  
  public VipMedalInfo(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.type = paramInt1;
    this.value = paramString;
    this.is_remind = paramInt2;
    this.tips_times = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, true);
    this.value = paramJceInputStream.readString(1, true);
    this.is_remind = paramJceInputStream.read(this.is_remind, 2, false);
    this.tips_times = paramJceInputStream.read(this.tips_times, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.value, 1);
    paramJceOutputStream.write(this.is_remind, 2);
    paramJceOutputStream.write(this.tips_times, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MQQ.VipMedalInfo
 * JD-Core Version:    0.7.0.1
 */