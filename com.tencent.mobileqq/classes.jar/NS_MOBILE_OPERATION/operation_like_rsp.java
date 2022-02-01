package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class operation_like_rsp
  extends JceStruct
{
  static cmshow_active_result cache_cmshow_act_result = new cmshow_active_result();
  public cmshow_active_result cmshow_act_result = null;
  public String msg = "";
  public int ret = 0;
  
  public operation_like_rsp() {}
  
  public operation_like_rsp(int paramInt, String paramString, cmshow_active_result paramcmshow_active_result)
  {
    this.ret = paramInt;
    this.msg = paramString;
    this.cmshow_act_result = paramcmshow_active_result;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.cmshow_act_result = ((cmshow_active_result)paramJceInputStream.read(cache_cmshow_act_result, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.cmshow_act_result != null) {
      paramJceOutputStream.write(this.cmshow_act_result, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_like_rsp
 * JD-Core Version:    0.7.0.1
 */