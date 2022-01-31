package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class EventWidgetInfo
  extends JceStruct
{
  static DescInfo cache_stDescInfo = new DescInfo();
  static VideoInfo cache_stVideoInfo = new VideoInfo();
  static int cache_type = 0;
  public boolean bIsPreload = true;
  public boolean bShow;
  public DescInfo stDescInfo;
  public VideoInfo stVideoInfo;
  public String strBubbleDesc = "";
  public String strJumpUrl = "";
  public String strMaterialUrl = "";
  public String strTraceInfo = "";
  public int type;
  
  public EventWidgetInfo() {}
  
  public EventWidgetInfo(boolean paramBoolean1, int paramInt, String paramString1, DescInfo paramDescInfo, VideoInfo paramVideoInfo, String paramString2, boolean paramBoolean2, String paramString3, String paramString4)
  {
    this.bShow = paramBoolean1;
    this.type = paramInt;
    this.strMaterialUrl = paramString1;
    this.stDescInfo = paramDescInfo;
    this.stVideoInfo = paramVideoInfo;
    this.strJumpUrl = paramString2;
    this.bIsPreload = paramBoolean2;
    this.strBubbleDesc = paramString3;
    this.strTraceInfo = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bShow = paramJceInputStream.read(this.bShow, 0, false);
    this.type = paramJceInputStream.read(this.type, 1, false);
    this.strMaterialUrl = paramJceInputStream.readString(2, false);
    this.stDescInfo = ((DescInfo)paramJceInputStream.read(cache_stDescInfo, 3, false));
    this.stVideoInfo = ((VideoInfo)paramJceInputStream.read(cache_stVideoInfo, 4, false));
    this.strJumpUrl = paramJceInputStream.readString(5, false);
    this.bIsPreload = paramJceInputStream.read(this.bIsPreload, 6, false);
    this.strBubbleDesc = paramJceInputStream.readString(7, false);
    this.strTraceInfo = paramJceInputStream.readString(8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bShow, 0);
    paramJceOutputStream.write(this.type, 1);
    if (this.strMaterialUrl != null) {
      paramJceOutputStream.write(this.strMaterialUrl, 2);
    }
    if (this.stDescInfo != null) {
      paramJceOutputStream.write(this.stDescInfo, 3);
    }
    if (this.stVideoInfo != null) {
      paramJceOutputStream.write(this.stVideoInfo, 4);
    }
    if (this.strJumpUrl != null) {
      paramJceOutputStream.write(this.strJumpUrl, 5);
    }
    paramJceOutputStream.write(this.bIsPreload, 6);
    if (this.strBubbleDesc != null) {
      paramJceOutputStream.write(this.strBubbleDesc, 7);
    }
    if (this.strTraceInfo != null) {
      paramJceOutputStream.write(this.strTraceInfo, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MOBILE_QZMALL_PROTOCOL.EventWidgetInfo
 * JD-Core Version:    0.7.0.1
 */