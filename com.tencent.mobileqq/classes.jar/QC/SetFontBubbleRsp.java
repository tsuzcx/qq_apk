package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SetFontBubbleRsp
  extends JceStruct
{
  static BubbleRsp cache_stBubbleRsp = new BubbleRsp();
  static FontRsp cache_stFontRsp;
  static CommonRsp cache_stRet = new CommonRsp();
  public BubbleRsp stBubbleRsp;
  public FontRsp stFontRsp;
  public CommonRsp stRet;
  
  static
  {
    cache_stFontRsp = new FontRsp();
  }
  
  public SetFontBubbleRsp() {}
  
  public SetFontBubbleRsp(CommonRsp paramCommonRsp, FontRsp paramFontRsp, BubbleRsp paramBubbleRsp)
  {
    this.stRet = paramCommonRsp;
    this.stFontRsp = paramFontRsp;
    this.stBubbleRsp = paramBubbleRsp;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stRet = ((CommonRsp)paramJceInputStream.read(cache_stRet, 0, false));
    this.stFontRsp = ((FontRsp)paramJceInputStream.read(cache_stFontRsp, 1, false));
    this.stBubbleRsp = ((BubbleRsp)paramJceInputStream.read(cache_stBubbleRsp, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stRet != null) {
      paramJceOutputStream.write(this.stRet, 0);
    }
    if (this.stFontRsp != null) {
      paramJceOutputStream.write(this.stFontRsp, 1);
    }
    if (this.stBubbleRsp != null) {
      paramJceOutputStream.write(this.stBubbleRsp, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.SetFontBubbleRsp
 * JD-Core Version:    0.7.0.1
 */