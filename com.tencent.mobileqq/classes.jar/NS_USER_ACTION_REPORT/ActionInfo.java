package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ActionInfo
  extends JceStruct
{
  static int cache_action_attr = 0;
  static int cache_action_id = 0;
  public int action_attr = 0;
  public int action_id = 0;
  public long action_value = 0L;
  public long oper_time = 0L;
  
  public ActionInfo() {}
  
  public ActionInfo(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    this.oper_time = paramLong1;
    this.action_id = paramInt1;
    this.action_value = paramLong2;
    this.action_attr = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.oper_time = paramJceInputStream.read(this.oper_time, 0, true);
    this.action_id = paramJceInputStream.read(this.action_id, 1, true);
    this.action_value = paramJceInputStream.read(this.action_value, 2, false);
    this.action_attr = paramJceInputStream.read(this.action_attr, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.oper_time, 0);
    paramJceOutputStream.write(this.action_id, 1);
    paramJceOutputStream.write(this.action_value, 2);
    paramJceOutputStream.write(this.action_attr, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_USER_ACTION_REPORT.ActionInfo
 * JD-Core Version:    0.7.0.1
 */