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
  public BubbleRsp stBubbleRsp = null;
  public FontRsp stFontRsp = null;
  public CommonRsp stRet = null;
  
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
    Object localObject = this.stRet;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.stFontRsp;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.stBubbleRsp;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.SetFontBubbleRsp
 * JD-Core Version:    0.7.0.1
 */