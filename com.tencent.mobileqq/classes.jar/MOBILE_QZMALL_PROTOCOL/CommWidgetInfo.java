package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CommWidgetInfo
  extends JceStruct
{
  static ArrowInfo cache_stArrowInfo = new ArrowInfo();
  static DescInfo cache_stDescInfo = new DescInfo();
  static NumberInfo cache_stNumberInfo = new NumberInfo();
  static WidgetMargin cache_stWidgetMargin = new WidgetMargin();
  static int cache_type;
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
    Object localObject = this.strWidgetUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.stArrowInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.strJumpUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.uiLevel, 5);
    localObject = this.stWidgetMargin;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
    localObject = this.stDescInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
    localObject = this.stNumberInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 8);
    }
    paramJceOutputStream.write(this.uiFrameIntervalMs, 9);
    paramJceOutputStream.write(this.uiLoopIntervalMs, 10);
    localObject = this.strTraceInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    localObject = this.strDownloadAppPackageName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MOBILE_QZMALL_PROTOCOL.CommWidgetInfo
 * JD-Core Version:    0.7.0.1
 */