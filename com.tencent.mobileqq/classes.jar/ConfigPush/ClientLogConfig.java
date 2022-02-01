package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ClientLogConfig
  extends JceStruct
{
  static TimeStamp cache_time_finish;
  static TimeStamp cache_time_start;
  public int cookie = 0;
  public byte loglevel = 0;
  public long lseq = 0L;
  public TimeStamp time_finish = null;
  public TimeStamp time_start = null;
  public int type = 0;
  
  public ClientLogConfig() {}
  
  public ClientLogConfig(int paramInt1, TimeStamp paramTimeStamp1, TimeStamp paramTimeStamp2, byte paramByte, int paramInt2, long paramLong)
  {
    this.type = paramInt1;
    this.time_start = paramTimeStamp1;
    this.time_finish = paramTimeStamp2;
    this.loglevel = paramByte;
    this.cookie = paramInt2;
    this.lseq = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 1, true);
    if (cache_time_start == null) {
      cache_time_start = new TimeStamp();
    }
    this.time_start = ((TimeStamp)paramJceInputStream.read(cache_time_start, 2, false));
    if (cache_time_finish == null) {
      cache_time_finish = new TimeStamp();
    }
    this.time_finish = ((TimeStamp)paramJceInputStream.read(cache_time_finish, 3, false));
    this.loglevel = paramJceInputStream.read(this.loglevel, 4, false);
    this.cookie = paramJceInputStream.read(this.cookie, 5, false);
    this.lseq = paramJceInputStream.read(this.lseq, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 1);
    if (this.time_start != null) {
      paramJceOutputStream.write(this.time_start, 2);
    }
    if (this.time_finish != null) {
      paramJceOutputStream.write(this.time_finish, 3);
    }
    paramJceOutputStream.write(this.loglevel, 4);
    paramJceOutputStream.write(this.cookie, 5);
    paramJceOutputStream.write(this.lseq, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ConfigPush.ClientLogConfig
 * JD-Core Version:    0.7.0.1
 */