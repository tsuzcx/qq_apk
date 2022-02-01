package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserConfig
  extends JceStruct
{
  public int effect_id = 0;
  public long group_code = 0L;
  public long set_mode = 0L;
  public long status = 0L;
  
  public UserConfig() {}
  
  public UserConfig(long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
    this.group_code = paramLong1;
    this.effect_id = paramInt;
    this.status = paramLong2;
    this.set_mode = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.group_code = paramJceInputStream.read(this.group_code, 0, false);
    this.effect_id = paramJceInputStream.read(this.effect_id, 1, false);
    this.status = paramJceInputStream.read(this.status, 2, false);
    this.set_mode = paramJceInputStream.read(this.set_mode, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.group_code, 0);
    paramJceOutputStream.write(this.effect_id, 1);
    paramJceOutputStream.write(this.status, 2);
    paramJceOutputStream.write(this.set_mode, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.UserConfig
 * JD-Core Version:    0.7.0.1
 */