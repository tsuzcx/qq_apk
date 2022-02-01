package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class EventWidgetInfo
  extends JceStruct
{
  static DescInfo cache_stDescInfo = new DescInfo();
  static VideoInfo cache_stVideoInfo = new VideoInfo();
  static int cache_type;
  public boolean bIsPreload = true;
  public boolean bShow = false;
  public DescInfo stDescInfo = null;
  public VideoInfo stVideoInfo = null;
  public String strBubbleDesc = "";
  public String strDownloadAppPackageName = "";
  public String strJumpUrl = "";
  public String strMaterialUrl = "";
  public String strTraceInfo = "";
  public int type = 0;
  
  public EventWidgetInfo() {}
  
  public EventWidgetInfo(boolean paramBoolean1, int paramInt, String paramString1, DescInfo paramDescInfo, VideoInfo paramVideoInfo, String paramString2, boolean paramBoolean2, String paramString3, String paramString4, String paramString5)
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
    this.strDownloadAppPackageName = paramString5;
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
    this.strDownloadAppPackageName = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bShow, 0);
    paramJceOutputStream.write(this.type, 1);
    Object localObject = this.strMaterialUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.stDescInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.stVideoInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    localObject = this.strJumpUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    paramJceOutputStream.write(this.bIsPreload, 6);
    localObject = this.strBubbleDesc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.strTraceInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.strDownloadAppPackageName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MOBILE_QZMALL_PROTOCOL.EventWidgetInfo
 * JD-Core Version:    0.7.0.1
 */