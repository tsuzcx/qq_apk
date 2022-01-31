package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class SUserLabel
  extends JceStruct
{
  static Map cache_label;
  public Map label;
  
  public SUserLabel() {}
  
  public SUserLabel(Map paramMap)
  {
    this.label = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_label == null)
    {
      cache_label = new HashMap();
      SLabelInfo localSLabelInfo = new SLabelInfo();
      cache_label.put(Long.valueOf(0L), localSLabelInfo);
    }
    this.label = ((Map)paramJceInputStream.read(cache_label, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.label, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SummaryCardTaf.SUserLabel
 * JD-Core Version:    0.7.0.1
 */