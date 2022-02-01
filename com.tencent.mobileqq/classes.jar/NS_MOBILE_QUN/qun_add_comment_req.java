package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class qun_add_comment_req
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param = new HashMap();
  public String albumId = "";
  public Map<Integer, String> busi_param = null;
  public int comment_type = 0;
  public String content = "";
  public long ownuin = 0L;
  public String qunid = "";
  public String srcid = "";
  public long uin = 0L;
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
  }
  
  public qun_add_comment_req() {}
  
  public qun_add_comment_req(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, int paramInt, String paramString4, Map<Integer, String> paramMap)
  {
    this.qunid = paramString1;
    this.uin = paramLong1;
    this.ownuin = paramLong2;
    this.srcid = paramString2;
    this.content = paramString3;
    this.comment_type = paramInt;
    this.albumId = paramString4;
    this.busi_param = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qunid = paramJceInputStream.readString(0, true);
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.ownuin = paramJceInputStream.read(this.ownuin, 2, false);
    this.srcid = paramJceInputStream.readString(3, false);
    this.content = paramJceInputStream.readString(4, false);
    this.comment_type = paramJceInputStream.read(this.comment_type, 5, false);
    this.albumId = paramJceInputStream.readString(6, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.qunid, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.ownuin, 2);
    Object localObject = this.srcid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.content;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.comment_type, 5);
    localObject = this.albumId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.busi_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_add_comment_req
 * JD-Core Version:    0.7.0.1
 */