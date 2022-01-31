package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class ClientGetUinConfReq
  extends JceStruct
{
  static Map<String, Integer> cache_uinConf;
  public Map<String, Integer> uinConf;
  
  public ClientGetUinConfReq() {}
  
  public ClientGetUinConfReq(Map<String, Integer> paramMap)
  {
    this.uinConf = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_uinConf == null)
    {
      cache_uinConf = new HashMap();
      cache_uinConf.put("", Integer.valueOf(0));
    }
    this.uinConf = ((Map)paramJceInputStream.read(cache_uinConf, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uinConf, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     protocol.KQQConfig.ClientGetUinConfReq
 * JD-Core Version:    0.7.0.1
 */