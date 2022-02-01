package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqUpdateIntro
  extends JceStruct
{
  static ReqHead cache_stHeader;
  static Intro cache_stIntro;
  public ReqHead stHeader = null;
  public Intro stIntro = null;
  
  public ReqUpdateIntro() {}
  
  public ReqUpdateIntro(ReqHead paramReqHead, Intro paramIntro)
  {
    this.stHeader = paramReqHead;
    this.stIntro = paramIntro;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_stIntro == null) {
      cache_stIntro = new Intro();
    }
    this.stIntro = ((Intro)paramJceInputStream.read(cache_stIntro, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.stIntro, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.ReqUpdateIntro
 * JD-Core Version:    0.7.0.1
 */