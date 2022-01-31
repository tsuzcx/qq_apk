package QZMALL_COMM_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class qzmall_data_rsp
  extends JceStruct
{
  static Map cache_rspMap = new HashMap();
  public Map rspMap;
  public long uUin;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_rspMap.put("", arrayOfByte);
  }
  
  public qzmall_data_rsp() {}
  
  public qzmall_data_rsp(long paramLong, Map paramMap)
  {
    this.uUin = paramLong;
    this.rspMap = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uUin = paramJceInputStream.read(this.uUin, 0, false);
    this.rspMap = ((Map)paramJceInputStream.read(cache_rspMap, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uUin, 0);
    if (this.rspMap != null) {
      paramJceOutputStream.write(this.rspMap, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     QZMALL_COMM_PROTOCOL.qzmall_data_rsp
 * JD-Core Version:    0.7.0.1
 */