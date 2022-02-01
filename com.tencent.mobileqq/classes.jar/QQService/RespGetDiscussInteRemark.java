package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class RespGetDiscussInteRemark
  extends JceStruct
{
  static Map<Long, InteRemarkInfo> cache_InteRemarks;
  public String DiscussName = "";
  public long DiscussUin = 0L;
  public Map<Long, InteRemarkInfo> InteRemarks = null;
  
  public RespGetDiscussInteRemark() {}
  
  public RespGetDiscussInteRemark(long paramLong, Map<Long, InteRemarkInfo> paramMap, String paramString)
  {
    this.DiscussUin = paramLong;
    this.InteRemarks = paramMap;
    this.DiscussName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.DiscussUin = paramJceInputStream.read(this.DiscussUin, 0, true);
    if (cache_InteRemarks == null)
    {
      cache_InteRemarks = new HashMap();
      InteRemarkInfo localInteRemarkInfo = new InteRemarkInfo();
      cache_InteRemarks.put(Long.valueOf(0L), localInteRemarkInfo);
    }
    this.InteRemarks = ((Map)paramJceInputStream.read(cache_InteRemarks, 1, true));
    this.DiscussName = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussUin, 0);
    paramJceOutputStream.write(this.InteRemarks, 1);
    String str = this.DiscussName;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.RespGetDiscussInteRemark
 * JD-Core Version:    0.7.0.1
 */