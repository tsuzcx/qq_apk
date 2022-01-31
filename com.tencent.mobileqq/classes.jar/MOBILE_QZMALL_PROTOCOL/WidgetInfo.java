package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class WidgetInfo
  extends JceStruct
{
  static int cache_category = 0;
  static int cache_src = 0;
  static CommWidgetInfo cache_stCommWidgetInfo = new CommWidgetInfo();
  static EventWidgetInfo cache_stEventWidgetInfo = new EventWidgetInfo();
  public int category = 0;
  public int src;
  public CommWidgetInfo stCommWidgetInfo;
  public EventWidgetInfo stEventWidgetInfo;
  
  public WidgetInfo() {}
  
  public WidgetInfo(int paramInt1, int paramInt2, CommWidgetInfo paramCommWidgetInfo, EventWidgetInfo paramEventWidgetInfo)
  {
    this.category = paramInt1;
    this.src = paramInt2;
    this.stCommWidgetInfo = paramCommWidgetInfo;
    this.stEventWidgetInfo = paramEventWidgetInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.category = paramJceInputStream.read(this.category, 0, false);
    this.src = paramJceInputStream.read(this.src, 1, false);
    this.stCommWidgetInfo = ((CommWidgetInfo)paramJceInputStream.read(cache_stCommWidgetInfo, 2, false));
    this.stEventWidgetInfo = ((EventWidgetInfo)paramJceInputStream.read(cache_stEventWidgetInfo, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.category, 0);
    paramJceOutputStream.write(this.src, 1);
    if (this.stCommWidgetInfo != null) {
      paramJceOutputStream.write(this.stCommWidgetInfo, 2);
    }
    if (this.stEventWidgetInfo != null) {
      paramJceOutputStream.write(this.stEventWidgetInfo, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MOBILE_QZMALL_PROTOCOL.WidgetInfo
 * JD-Core Version:    0.7.0.1
 */