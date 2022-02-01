package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RuleInfo
  extends JceStruct
{
  public long rule_id = 0L;
  public long test_id = 0L;
  
  public RuleInfo() {}
  
  public RuleInfo(long paramLong1, long paramLong2)
  {
    this.test_id = paramLong1;
    this.rule_id = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.test_id = paramJceInputStream.read(this.test_id, 0, false);
    this.rule_id = paramJceInputStream.read(this.rule_id, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.test_id, 0);
    paramJceOutputStream.write(this.rule_id, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_USER_ACTION_REPORT.RuleInfo
 * JD-Core Version:    0.7.0.1
 */