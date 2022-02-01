package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SetFontBubbleReq
  extends JceStruct
{
  static BubbleReq cache_stBubbleReq = new BubbleReq();
  static FontReq cache_stFontReq;
  static LoginInfo cache_stLogin = new LoginInfo();
  public BubbleReq stBubbleReq = null;
  public FontReq stFontReq = null;
  public LoginInfo stLogin = null;
  
  static
  {
    cache_stFontReq = new FontReq();
  }
  
  public SetFontBubbleReq() {}
  
  public SetFontBubbleReq(LoginInfo paramLoginInfo, FontReq paramFontReq, BubbleReq paramBubbleReq)
  {
    this.stLogin = paramLoginInfo;
    this.stFontReq = paramFontReq;
    this.stBubbleReq = paramBubbleReq;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, true));
    this.stFontReq = ((FontReq)paramJceInputStream.read(cache_stFontReq, 1, false));
    this.stBubbleReq = ((BubbleReq)paramJceInputStream.read(cache_stBubbleReq, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stLogin, 0);
    Object localObject = this.stFontReq;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.stBubbleReq;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.SetFontBubbleReq
 * JD-Core Version:    0.7.0.1
 */