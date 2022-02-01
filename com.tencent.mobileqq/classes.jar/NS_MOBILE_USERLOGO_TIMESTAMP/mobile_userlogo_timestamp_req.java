package NS_MOBILE_USERLOGO_TIMESTAMP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_userlogo_timestamp_req
  extends JceStruct
{
  static ArrayList<Long> cache_others;
  public int field_flag;
  public long last_timestamp;
  public ArrayList<Long> others;
  public long pay_info_timestamp;
  public long skin_timestamp;
  public long skin_uin;
  public long uin;
  
  public mobile_userlogo_timestamp_req() {}
  
  public mobile_userlogo_timestamp_req(long paramLong1, ArrayList<Long> paramArrayList, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5)
  {
    this.uin = paramLong1;
    this.others = paramArrayList;
    this.last_timestamp = paramLong2;
    this.field_flag = paramInt;
    this.skin_uin = paramLong3;
    this.skin_timestamp = paramLong4;
    this.pay_info_timestamp = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    if (cache_others == null)
    {
      cache_others = new ArrayList();
      cache_others.add(Long.valueOf(0L));
    }
    this.others = ((ArrayList)paramJceInputStream.read(cache_others, 1, false));
    this.last_timestamp = paramJceInputStream.read(this.last_timestamp, 2, false);
    this.field_flag = paramJceInputStream.read(this.field_flag, 3, false);
    this.skin_uin = paramJceInputStream.read(this.skin_uin, 4, false);
    this.skin_timestamp = paramJceInputStream.read(this.skin_timestamp, 5, false);
    this.pay_info_timestamp = paramJceInputStream.read(this.pay_info_timestamp, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    ArrayList localArrayList = this.others;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
    paramJceOutputStream.write(this.last_timestamp, 2);
    paramJceOutputStream.write(this.field_flag, 3);
    paramJceOutputStream.write(this.skin_uin, 4);
    paramJceOutputStream.write(this.skin_timestamp, 5);
    paramJceOutputStream.write(this.pay_info_timestamp, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_USERLOGO_TIMESTAMP.mobile_userlogo_timestamp_req
 * JD-Core Version:    0.7.0.1
 */