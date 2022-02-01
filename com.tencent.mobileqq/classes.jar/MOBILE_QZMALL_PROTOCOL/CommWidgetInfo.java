package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CommWidgetInfo
  extends JceStruct
{
  static ArrowInfo cache_stArrowInfo;
  static DescInfo cache_stDescInfo = new DescInfo();
  static NumberInfo cache_stNumberInfo = new NumberInfo();
  static WidgetMargin cache_stWidgetMargin;
  static int cache_type = 0;
  public boolean bShow = false;
  public ArrowInfo stArrowInfo = null;
  public DescInfo stDescInfo = null;
  public NumberInfo stNumberInfo = null;
  public WidgetMargin stWidgetMargin = null;
  public String strDownloadAppPackageName = "";
  public String strJumpUrl = "";
  public String strTraceInfo = "";
  public String strWidgetUrl = "";
  public int type = 0;
  public long uiFrameIntervalMs = 0L;
  public long uiLevel = 0L;
  public long uiLoopIntervalMs = 0L;
  
  static
  {
    cache_stArrowInfo = new ArrowInfo();
    cache_stWidgetMargin = new WidgetMargin();
  }
  
  public CommWidgetInfo() {}
  
  public CommWidgetInfo(boolean paramBoolean, int paramInt, String paramString1, ArrowInfo paramArrowInfo, String paramString2, long paramLong1, WidgetMargin paramWidgetMargin, DescInfo paramDescInfo, NumberInfo paramNumberInfo, long paramLong2, long paramLong3, String paramString3, String paramString4)
  {
    this.bShow = paramBoolean;
    this.type = paramInt;
    this.strWidgetUrl = paramString1;
    this.stArrowInfo = paramArrowInfo;
    this.strJumpUrl = paramString2;
    this.uiLevel = paramLong1;
    this.stWidgetMargin = paramWidgetMargin;
    this.stDescInfo = paramDescInfo;
    this.stNumberInfo = paramNumberInfo;
    this.uiFrameIntervalMs = paramLong2;
    this.uiLoopIntervalMs = paramLong3;
    this.strTraceInfo = paramString3;
    this.strDownloadAppPackageName = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bShow = paramJceInputStream.read(this.bShow, 0, false);
    this.type = paramJceInputStream.read(this.type, 1, false);
    this.strWidgetUrl = paramJceInputStream.readString(2, false);
    this.stArrowInfo = ((ArrowInfo)paramJceInputStream.read(cache_stArrowInfo, 3, false));
    this.strJumpUrl = paramJceInputStream.readString(4, false);
    this.uiLevel = paramJceInputStream.read(this.uiLevel, 5, false);
    this.stWidgetMargin = ((WidgetMargin)paramJceInputStream.read(cache_stWidgetMargin, 6, false));
    this.stDescInfo = ((DescInfo)paramJceInputStream.read(cache_stDescInfo, 7, false));
    this.stNumberInfo = ((NumberInfo)paramJceInputStream.read(cache_stNumberInfo, 8, false));
    this.uiFrameIntervalMs = paramJceInputStream.read(this.uiFrameIntervalMs, 9, false);
    this.uiLoopIntervalMs = paramJceInputStream.read(this.uiLoopIntervalMs, 10, false);
    this.strTraceInfo = paramJceInputStream.readString(11, false);
    this.strDownloadAppPackageName = paramJceInputStream.readString(12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bShow, 0);
    paramJceOutputStream.write(this.type, 1);
    if (this.strWidgetUrl != null) {
      paramJceOutputStream.write(this.strWidgetUrl, 2);
    }
    if (this.stArrowInfo != null) {
      paramJceOutputStream.write(this.stArrowInfo, 3);
    }
    if (this.strJumpUrl != null) {
      paramJceOutputStream.write(this.strJumpUrl, 4);
    }
    paramJceOutputStream.write(this.uiLevel, 5);
    if (this.stWidgetMargin != null) {
      paramJceOutputStream.write(this.stWidgetMargin, 6);
    }
    if (this.stDescInfo != null) {
      paramJceOutputStream.write(this.stDescInfo, 7);
    }
    if (this.stNumberInfo != null) {
      paramJceOutputStream.write(this.stNumberInfo, 8);
    }
    paramJceOutputStream.write(this.uiFrameIntervalMs, 9);
    paramJceOutputStream.write(this.uiLoopIntervalMs, 10);
    if (this.strTraceInfo != null) {
      paramJceOutputStream.write(this.strTraceInfo, 11);
    }
    if (this.strDownloadAppPackageName != null) {
      paramJceOutputStream.write(this.strDownloadAppPackageName, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MOBILE_QZMALL_PROTOCOL.CommWidgetInfo
 * JD-Core Version:    0.7.0.1
 */