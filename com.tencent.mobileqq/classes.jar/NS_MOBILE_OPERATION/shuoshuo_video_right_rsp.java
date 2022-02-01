package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class shuoshuo_video_right_rsp
  extends JceStruct
{
  public boolean isverified = true;
  public String msg = "";
  public int remain_times;
  public int ret;
  
  public shuoshuo_video_right_rsp() {}
  
  public shuoshuo_video_right_rsp(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    this.ret = paramInt1;
    this.msg = paramString;
    this.isverified = paramBoolean;
    this.remain_times = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.isverified = paramJceInputStream.read(this.isverified, 2, false);
    this.remain_times = paramJceInputStream.read(this.remain_times, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    String str = this.msg;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.isverified, 2);
    paramJceOutputStream.write(this.remain_times, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.shuoshuo_video_right_rsp
 * JD-Core Version:    0.7.0.1
 */