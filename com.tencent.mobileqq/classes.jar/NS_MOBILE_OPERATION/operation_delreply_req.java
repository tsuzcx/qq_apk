package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operation_delreply_req
  extends JceStruct
{
  static Map<String, String> cache_bypass_param;
  static Map<Integer, String> cache_mapBusiParam = new HashMap();
  public Map<String, String> bypass_param;
  public String ciphertext = "";
  public long iAppID;
  public long iCommentUin;
  public int iDelSource;
  public long iReplyUin;
  public long iSrcUin;
  public Map<Integer, String> mapBusiParam;
  public String strCommentID = "";
  public String strCommentUinOpenid = "";
  public String strReplyID = "";
  public String strReplyUinOpenid = "";
  public String strSrcID = "";
  public String strSrcUinOpenid = "";
  
  static
  {
    cache_mapBusiParam.put(Integer.valueOf(0), "");
    cache_bypass_param = new HashMap();
    cache_bypass_param.put("", "");
  }
  
  public operation_delreply_req() {}
  
  public operation_delreply_req(long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, long paramLong4, String paramString3, int paramInt, Map<Integer, String> paramMap, String paramString4, String paramString5, String paramString6, String paramString7, Map<String, String> paramMap1)
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
    this.strSrcUinOpenid = paramString4;
    this.strCommentUinOpenid = paramString5;
    this.strReplyUinOpenid = paramString6;
    this.ciphertext = paramString7;
    this.bypass_param = paramMap1;
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
    this.mapBusiParam = ((Map)paramJceInputStream.read(cache_mapBusiParam, 8, true));
    this.strSrcUinOpenid = paramJceInputStream.readString(9, false);
    this.strCommentUinOpenid = paramJceInputStream.readString(10, false);
    this.strReplyUinOpenid = paramJceInputStream.readString(11, false);
    this.ciphertext = paramJceInputStream.readString(12, false);
    this.bypass_param = ((Map)paramJceInputStream.read(cache_bypass_param, 13, false));
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
    if (this.strSrcUinOpenid != null) {
      paramJceOutputStream.write(this.strSrcUinOpenid, 9);
    }
    if (this.strCommentUinOpenid != null) {
      paramJceOutputStream.write(this.strCommentUinOpenid, 10);
    }
    if (this.strReplyUinOpenid != null) {
      paramJceOutputStream.write(this.strReplyUinOpenid, 11);
    }
    if (this.ciphertext != null) {
      paramJceOutputStream.write(this.ciphertext, 12);
    }
    if (this.bypass_param != null) {
      paramJceOutputStream.write(this.bypass_param, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_delreply_req
 * JD-Core Version:    0.7.0.1
 */