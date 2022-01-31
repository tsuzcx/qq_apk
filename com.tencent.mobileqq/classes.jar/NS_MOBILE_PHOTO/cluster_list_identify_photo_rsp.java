package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cluster_list_identify_photo_rsp
  extends JceStruct
{
  static faiss_search_result cache_result = new faiss_search_result();
  public String msg = "";
  public faiss_search_result result;
  public int ret;
  
  public cluster_list_identify_photo_rsp() {}
  
  public cluster_list_identify_photo_rsp(int paramInt, String paramString, faiss_search_result paramfaiss_search_result)
  {
    this.ret = paramInt;
    this.msg = paramString;
    this.result = paramfaiss_search_result;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.result = ((faiss_search_result)paramJceInputStream.read(cache_result, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.result != null) {
      paramJceOutputStream.write(this.result, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_PHOTO.cluster_list_identify_photo_rsp
 * JD-Core Version:    0.7.0.1
 */