package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class ReqGetDiscussInfo
  extends JceStruct
{
  static Map<Long, Integer> cache_UinList;
  public long DiscussUin = 0L;
  public long InfoSeq = 0L;
  public long InteRemarkTimeStamp = -1L;
  public String Signature = "";
  public Map<Long, Integer> UinList = null;
  
  public ReqGetDiscussInfo() {}
  
  public ReqGetDiscussInfo(long paramLong1, long paramLong2, Map<Long, Integer> paramMap, long paramLong3, String paramString)
  {
    this.DiscussUin = paramLong1;
    this.InteRemarkTimeStamp = paramLong2;
    this.UinList = paramMap;
    this.InfoSeq = paramLong3;
    this.Signature = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.DiscussUin = paramJceInputStream.read(this.DiscussUin, 0, true);
    this.InteRemarkTimeStamp = paramJceInputStream.read(this.InteRemarkTimeStamp, 1, false);
    if (cache_UinList == null)
    {
      cache_UinList = new HashMap();
      cache_UinList.put(Long.valueOf(0L), Integer.valueOf(0));
    }
    this.UinList = ((Map)paramJceInputStream.read(cache_UinList, 2, false));
    this.InfoSeq = paramJceInputStream.read(this.InfoSeq, 3, false);
    this.Signature = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussUin, 0);
    paramJceOutputStream.write(this.InteRemarkTimeStamp, 1);
    if (this.UinList != null) {
      paramJceOutputStream.write(this.UinList, 2);
    }
    paramJceOutputStream.write(this.InfoSeq, 3);
    if (this.Signature != null) {
      paramJceOutputStream.write(this.Signature, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QQService.ReqGetDiscussInfo
 * JD-Core Version:    0.7.0.1
 */