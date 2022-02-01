package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operation_comm_req
  extends JceStruct
{
  static Map<String, String> cache_mapEx;
  static byte[] cache_message = (byte[])new byte[1];
  public int appid = 0;
  public Map<String, String> mapEx = null;
  public byte[] message = null;
  public long opuin = 0L;
  
  static
  {
    ((byte[])cache_message)[0] = 0;
    cache_mapEx = new HashMap();
    cache_mapEx.put("", "");
  }
  
  public operation_comm_req() {}
  
  public operation_comm_req(int paramInt, long paramLong, byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    this.appid = paramInt;
    this.opuin = paramLong;
    this.message = paramArrayOfByte;
    this.mapEx = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.opuin = paramJceInputStream.read(this.opuin, 1, false);
    this.message = ((byte[])paramJceInputStream.read(cache_message, 2, false));
    this.mapEx = ((Map)paramJceInputStream.read(cache_mapEx, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.opuin, 1);
    Object localObject = this.message;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 2);
    }
    localObject = this.mapEx;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_comm_req
 * JD-Core Version:    0.7.0.1
 */