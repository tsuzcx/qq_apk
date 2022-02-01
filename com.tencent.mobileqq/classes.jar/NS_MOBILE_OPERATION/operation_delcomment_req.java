package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operation_delcomment_req
  extends JceStruct
{
  static Map<String, String> cache_bypass_param;
  static Map<Integer, String> cache_mapBusiParam = new HashMap();
  public Map<String, String> bypass_param = null;
  public String ciphertext = "";
  public long iAppID = 0L;
  public long iCommentUin = 0L;
  public int iDelSource = 0;
  public long iSrcUin = 0L;
  public Map<Integer, String> mapBusiParam = null;
  public String strCommentID = "";
  public String strCommentUinOpenid = "";
  public String strSrcID = "";
  public String strSrcUinOpenid = "";
  
  static
  {
    cache_mapBusiParam.put(Integer.valueOf(0), "");
    cache_bypass_param = new HashMap();
    cache_bypass_param.put("", "");
  }
  
  public operation_delcomment_req() {}
  
  public operation_delcomment_req(long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, int paramInt, Map<Integer, String> paramMap, String paramString3, String paramString4, String paramString5, Map<String, String> paramMap1)
  {
    this.iAppID = paramLong1;
    this.iSrcUin = paramLong2;
    this.strSrcID = paramString1;
    this.iCommentUin = paramLong3;
    this.strCommentID = paramString2;
    this.iDelSource = paramInt;
    this.mapBusiParam = paramMap;
    this.strSrcUinOpenid = paramString3;
    this.strCommentUinOpenid = paramString4;
    this.ciphertext = paramString5;
    this.bypass_param = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iAppID = paramJceInputStream.read(this.iAppID, 0, true);
    this.iSrcUin = paramJceInputStream.read(this.iSrcUin, 1, true);
    this.strSrcID = paramJceInputStream.readString(2, true);
    this.iCommentUin = paramJceInputStream.read(this.iCommentUin, 3, true);
    this.strCommentID = paramJceInputStream.readString(4, true);
    this.iDelSource = paramJceInputStream.read(this.iDelSource, 5, true);
    this.mapBusiParam = ((Map)paramJceInputStream.read(cache_mapBusiParam, 6, true));
    this.strSrcUinOpenid = paramJceInputStream.readString(7, false);
    this.strCommentUinOpenid = paramJceInputStream.readString(8, false);
    this.ciphertext = paramJceInputStream.readString(9, false);
    this.bypass_param = ((Map)paramJceInputStream.read(cache_bypass_param, 10, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iAppID, 0);
    paramJceOutputStream.write(this.iSrcUin, 1);
    paramJceOutputStream.write(this.strSrcID, 2);
    paramJceOutputStream.write(this.iCommentUin, 3);
    paramJceOutputStream.write(this.strCommentID, 4);
    paramJceOutputStream.write(this.iDelSource, 5);
    paramJceOutputStream.write(this.mapBusiParam, 6);
    if (this.strSrcUinOpenid != null) {
      paramJceOutputStream.write(this.strSrcUinOpenid, 7);
    }
    if (this.strCommentUinOpenid != null) {
      paramJceOutputStream.write(this.strCommentUinOpenid, 8);
    }
    if (this.ciphertext != null) {
      paramJceOutputStream.write(this.ciphertext, 9);
    }
    if (this.bypass_param != null) {
      paramJceOutputStream.write(this.bypass_param, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_delcomment_req
 * JD-Core Version:    0.7.0.1
 */