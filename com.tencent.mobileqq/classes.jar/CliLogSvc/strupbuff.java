package CliLogSvc;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class strupbuff
  extends JceStruct
  implements Cloneable
{
  static Map<String, ArrayList<byte[]>> cache_logstring;
  public Map<String, ArrayList<byte[]>> logstring = null;
  public String prefix = "";
  
  public strupbuff()
  {
    setLogstring(this.logstring);
    setPrefix(this.prefix);
  }
  
  public strupbuff(Map<String, ArrayList<byte[]>> paramMap, String paramString)
  {
    setLogstring(paramMap);
    setPrefix(paramString);
  }
  
  public String className()
  {
    return "strupbuff";
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.logstring, "logstring");
    paramStringBuilder.display(this.prefix, "prefix");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (strupbuff)paramObject;
    return (JceUtil.equals(this.logstring, paramObject.logstring)) && (JceUtil.equals(this.prefix, paramObject.prefix));
  }
  
  public String fullClassName()
  {
    return "CliLogSvc.strupbuff";
  }
  
  public Map<String, ArrayList<byte[]>> getLogstring()
  {
    return this.logstring;
  }
  
  public String getPrefix()
  {
    return this.prefix;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_logstring == null)
    {
      cache_logstring = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new byte[] { 0 });
      cache_logstring.put("", localArrayList);
    }
    setLogstring((Map)paramJceInputStream.read(cache_logstring, 0, true));
    setPrefix(paramJceInputStream.readString(1, false));
  }
  
  public void setLogstring(Map<String, ArrayList<byte[]>> paramMap)
  {
    this.logstring = paramMap;
  }
  
  public void setPrefix(String paramString)
  {
    this.prefix = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.logstring, 0);
    String str = this.prefix;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     CliLogSvc.strupbuff
 * JD-Core Version:    0.7.0.1
 */