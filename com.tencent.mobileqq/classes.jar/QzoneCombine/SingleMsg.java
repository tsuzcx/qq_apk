package QzoneCombine;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class SingleMsg
  extends JceStruct
{
  static Map<String, String> cache_data = new HashMap();
  static byte[] cache_extBuffer;
  public long addTime = 0L;
  public Map<String, String> data = null;
  public byte[] extBuffer = null;
  public long opUin = 0L;
  
  static
  {
    cache_data.put("", "");
    cache_extBuffer = (byte[])new byte[1];
    ((byte[])cache_extBuffer)[0] = 0;
  }
  
  public SingleMsg() {}
  
  public SingleMsg(long paramLong1, Map<String, String> paramMap, long paramLong2, byte[] paramArrayOfByte)
  {
    this.addTime = paramLong1;
    this.data = paramMap;
    this.opUin = paramLong2;
    this.extBuffer = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.addTime = paramJceInputStream.read(this.addTime, 0, false);
    this.data = ((Map)paramJceInputStream.read(cache_data, 1, false));
    this.opUin = paramJceInputStream.read(this.opUin, 2, false);
    this.extBuffer = ((byte[])paramJceInputStream.read(cache_extBuffer, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.addTime, 0);
    Object localObject = this.data;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
    paramJceOutputStream.write(this.opUin, 2);
    localObject = this.extBuffer;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QzoneCombine.SingleMsg
 * JD-Core Version:    0.7.0.1
 */