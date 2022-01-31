package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class DiscussMemberInfo
  extends JceStruct
{
  static Map cache_Attr;
  static InteRemarkInfo cache_StInteRemark;
  public Map Attr;
  public byte Flag;
  public InteRemarkInfo StInteRemark;
  public long Uin;
  
  public DiscussMemberInfo() {}
  
  public DiscussMemberInfo(long paramLong, byte paramByte, Map paramMap, InteRemarkInfo paramInteRemarkInfo)
  {
    this.Uin = paramLong;
    this.Flag = paramByte;
    this.Attr = paramMap;
    this.StInteRemark = paramInteRemarkInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Uin = paramJceInputStream.read(this.Uin, 0, true);
    this.Flag = paramJceInputStream.read(this.Flag, 1, true);
    if (cache_Attr == null)
    {
      cache_Attr = new HashMap();
      MemberAttrInfo localMemberAttrInfo = new MemberAttrInfo();
      cache_Attr.put(Integer.valueOf(0), localMemberAttrInfo);
    }
    this.Attr = ((Map)paramJceInputStream.read(cache_Attr, 2, false));
    if (cache_StInteRemark == null) {
      cache_StInteRemark = new InteRemarkInfo();
    }
    this.StInteRemark = ((InteRemarkInfo)paramJceInputStream.read(cache_StInteRemark, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Uin, 0);
    paramJceOutputStream.write(this.Flag, 1);
    if (this.Attr != null) {
      paramJceOutputStream.write(this.Attr, 2);
    }
    if (this.StInteRemark != null) {
      paramJceOutputStream.write(this.StInteRemark, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     QQService.DiscussMemberInfo
 * JD-Core Version:    0.7.0.1
 */