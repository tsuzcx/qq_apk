package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class SUserLable
  extends JceStruct
{
  static Map<Long, SLableInfo> cache_lable;
  public Map<Long, SLableInfo> lable;
  
  public SUserLable() {}
  
  public SUserLable(Map<Long, SLableInfo> paramMap)
  {
    this.lable = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_lable == null)
    {
      cache_lable = new HashMap();
      SLableInfo localSLableInfo = new SLableInfo();
      cache_lable.put(Long.valueOf(0L), localSLableInfo);
    }
    this.lable = ((Map)paramJceInputStream.read(cache_lable, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lable, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SummaryCardTaf.SUserLable
 * JD-Core Version:    0.7.0.1
 */