package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class DiscussMemberInfo
  extends JceStruct
{
  static Map<Integer, MemberAttrInfo> cache_Attr;
  static InteRemarkInfo cache_StInteRemark;
  public Map<Integer, MemberAttrInfo> Attr = null;
  public byte Flag = 0;
  public InteRemarkInfo StInteRemark = null;
  public long Uin = 0L;
  
  public DiscussMemberInfo() {}
  
  public DiscussMemberInfo(long paramLong, byte paramByte, Map<Integer, MemberAttrInfo> paramMap, InteRemarkInfo paramInteRemarkInfo)
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
    Object localObject = this.Attr;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
    localObject = this.StInteRemark;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.DiscussMemberInfo
 * JD-Core Version:    0.7.0.1
 */