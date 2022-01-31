package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class ReqSetDiscussAttr
  extends JceStruct
{
  static Map cache_Attr;
  public Map Attr;
  public long DiscussUin;
  
  public ReqSetDiscussAttr() {}
  
  public ReqSetDiscussAttr(long paramLong, Map paramMap)
  {
    this.DiscussUin = paramLong;
    this.Attr = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.DiscussUin = paramJceInputStream.read(this.DiscussUin, 0, true);
    if (cache_Attr == null)
    {
      cache_Attr = new HashMap();
      MemberAttrInfo localMemberAttrInfo = new MemberAttrInfo();
      cache_Attr.put(Integer.valueOf(0), localMemberAttrInfo);
    }
    this.Attr = ((Map)paramJceInputStream.read(cache_Attr, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussUin, 0);
    paramJceOutputStream.write(this.Attr, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QQService.ReqSetDiscussAttr
 * JD-Core Version:    0.7.0.1
 */