package NS_GROUP_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class profile_count_item
  extends JceStruct
{
  public long count = 0L;
  public String jumpSchema = "";
  public long uin = 0L;
  
  public profile_count_item() {}
  
  public profile_count_item(long paramLong1, String paramString, long paramLong2)
  {
    this.uin = paramLong1;
    this.jumpSchema = paramString;
    this.count = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.jumpSchema = paramJceInputStream.readString(1, false);
    this.count = paramJceInputStream.read(this.count, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.jumpSchema != null) {
      paramJceOutputStream.write(this.jumpSchema, 1);
    }
    paramJceOutputStream.write(this.count, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_GROUP_COUNT.profile_count_item
 * JD-Core Version:    0.7.0.1
 */