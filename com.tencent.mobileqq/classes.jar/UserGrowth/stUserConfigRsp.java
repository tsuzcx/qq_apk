package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stUserConfigRsp
  extends JceStruct
{
  static stCallInfo cache_call_inBg = new stCallInfo();
  public boolean auth_closed = true;
  public stCallInfo call_inBg = null;
  public int code = 0;
  public String msg = "";
  
  public stUserConfigRsp() {}
  
  public stUserConfigRsp(int paramInt, String paramString, boolean paramBoolean, stCallInfo paramstCallInfo)
  {
    this.code = paramInt;
    this.msg = paramString;
    this.auth_closed = paramBoolean;
    this.call_inBg = paramstCallInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.code = paramJceInputStream.read(this.code, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.auth_closed = paramJceInputStream.read(this.auth_closed, 2, false);
    this.call_inBg = ((stCallInfo)paramJceInputStream.read(cache_call_inBg, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.code, 0);
    Object localObject = this.msg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.auth_closed, 2);
    localObject = this.call_inBg;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stUserConfigRsp
 * JD-Core Version:    0.7.0.1
 */