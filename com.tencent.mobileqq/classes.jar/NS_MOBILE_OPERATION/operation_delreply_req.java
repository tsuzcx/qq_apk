package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operation_delreply_req
  extends JceStruct
{
  static Map cache_mapBusiParam;
  public long iAppID;
  public long iCommentUin;
  public int iDelSource;
  public long iReplyUin;
  public long iSrcUin;
  public Map mapBusiParam;
  public String strCommentID = "";
  public String strReplyID = "";
  public String strSrcID = "";
  
  public operation_delreply_req() {}
  
  public operation_delreply_req(long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, long paramLong4, String paramString3, int paramInt, Map paramMap)
  {
    this.iAppID = paramLong1;
    this.iSrcUin = paramLong2;
    this.strSrcID = paramString1;
    this.iCommentUin = paramLong3;
    this.strCommentID = paramString2;
    this.iReplyUin = paramLong4;
    this.strReplyID = paramString3;
    this.iDelSource = paramInt;
    this.mapBusiParam = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iAppID = paramJceInputStream.read(this.iAppID, 0, true);
    this.iSrcUin = paramJceInputStream.read(this.iSrcUin, 1, true);
    this.strSrcID = paramJceInputStream.readString(2, true);
    this.iCommentUin = paramJceInputStream.read(this.iCommentUin, 3, true);
    this.strCommentID = paramJceInputStream.readString(4, true);
    this.iReplyUin = paramJceInputStream.read(this.iReplyUin, 5, true);
    this.strReplyID = paramJceInputStream.readString(6, true);
    this.iDelSource = paramJceInputStream.read(this.iDelSource, 7, true);
    if (cache_mapBusiParam == null)
    {
      cache_mapBusiParam = new HashMap();
      cache_mapBusiParam.put(Integer.valueOf(0), "");
    }
    this.mapBusiParam = ((Map)paramJceInputStream.read(cache_mapBusiParam, 8, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iAppID, 0);
    paramJceOutputStream.write(this.iSrcUin, 1);
    paramJceOutputStream.write(this.strSrcID, 2);
    paramJceOutputStream.write(this.iCommentUin, 3);
    paramJceOutputStream.write(this.strCommentID, 4);
    paramJceOutputStream.write(this.iReplyUin, 5);
    paramJceOutputStream.write(this.strReplyID, 6);
    paramJceOutputStream.write(this.iDelSource, 7);
    paramJceOutputStream.write(this.mapBusiParam, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_delreply_req
 * JD-Core Version:    0.7.0.1
 */