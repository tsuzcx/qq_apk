package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ClientSetUinConfReq
  extends JceStruct
{
  static Map<String, ArrayList<byte[]>> cache_uinConf;
  public Map<String, ArrayList<byte[]>> uinConf;
  
  public ClientSetUinConfReq() {}
  
  public ClientSetUinConfReq(Map<String, ArrayList<byte[]>> paramMap)
  {
    this.uinConf = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_uinConf == null)
    {
      cache_uinConf = new HashMap();
      ArrayList localArrayList = new ArrayList();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      localArrayList.add(arrayOfByte);
      cache_uinConf.put("", localArrayList);
    }
    this.uinConf = ((Map)paramJceInputStream.read(cache_uinConf, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uinConf, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     protocol.KQQConfig.ClientSetUinConfReq
 * JD-Core Version:    0.7.0.1
 */