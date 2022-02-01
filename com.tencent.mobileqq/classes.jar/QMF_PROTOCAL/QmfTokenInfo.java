package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class QmfTokenInfo
  extends JceStruct
{
  static byte[] cache_Key;
  static Map<Integer, byte[]> cache_ext_key;
  public byte[] Key;
  public int Type;
  public Map<Integer, byte[]> ext_key;
  
  public QmfTokenInfo() {}
  
  public QmfTokenInfo(int paramInt, byte[] paramArrayOfByte, Map<Integer, byte[]> paramMap)
  {
    this.Type = paramInt;
    this.Key = paramArrayOfByte;
    this.ext_key = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Type = paramJceInputStream.read(this.Type, 0, true);
    if (cache_Key == null)
    {
      cache_Key = (byte[])new byte[1];
      ((byte[])cache_Key)[0] = 0;
    }
    this.Key = ((byte[])paramJceInputStream.read(cache_Key, 1, true));
    if (cache_ext_key == null)
    {
      cache_ext_key = new HashMap();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      cache_ext_key.put(Integer.valueOf(0), arrayOfByte);
    }
    this.ext_key = ((Map)paramJceInputStream.read(cache_ext_key, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Type, 0);
    paramJceOutputStream.write(this.Key, 1);
    Map localMap = this.ext_key;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QMF_PROTOCAL.QmfTokenInfo
 * JD-Core Version:    0.7.0.1
 */