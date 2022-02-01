package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TrafficResultInfo
  extends JceStruct
{
  static PopupImgInfo cache_popInfo = new PopupImgInfo();
  static ToastImgInfo cache_toasInfo = new ToastImgInfo();
  public int bUpdate = 0;
  public int iDrawerEnable = 0;
  public int iDrawerTextId = 0;
  public int iGuideEnable = 0;
  public int iImsiInterval = 0;
  public int iReportInterval = 0;
  public int iWkOrderState1 = 0;
  public int iWkOrderState2 = 0;
  public PopupImgInfo popInfo = null;
  public String sDrawerText = "";
  public String sDrawerUrl = "";
  public String sGuideUrl = "";
  public ToastImgInfo toasInfo = null;
  
  public TrafficResultInfo() {}
  
  public TrafficResultInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, int paramInt5, ToastImgInfo paramToastImgInfo, PopupImgInfo paramPopupImgInfo, int paramInt6, int paramInt7, int paramInt8)
  {
    this.iWkOrderState1 = paramInt1;
    this.iWkOrderState2 = paramInt2;
    this.iDrawerEnable = paramInt3;
    this.iGuideEnable = paramInt4;
    this.sDrawerText = paramString1;
    this.sDrawerUrl = paramString2;
    this.sGuideUrl = paramString3;
    this.iImsiInterval = paramInt5;
    this.toasInfo = paramToastImgInfo;
    this.popInfo = paramPopupImgInfo;
    this.iReportInterval = paramInt6;
    this.bUpdate = paramInt7;
    this.iDrawerTextId = paramInt8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iWkOrderState1 = paramJceInputStream.read(this.iWkOrderState1, 0, false);
    this.iWkOrderState2 = paramJceInputStream.read(this.iWkOrderState2, 1, false);
    this.iDrawerEnable = paramJceInputStream.read(this.iDrawerEnable, 2, false);
    this.iGuideEnable = paramJceInputStream.read(this.iGuideEnable, 3, false);
    this.sDrawerText = paramJceInputStream.readString(4, false);
    this.sDrawerUrl = paramJceInputStream.readString(5, false);
    this.sGuideUrl = paramJceInputStream.readString(6, false);
    this.iImsiInterval = paramJceInputStream.read(this.iImsiInterval, 7, false);
    this.toasInfo = ((ToastImgInfo)paramJceInputStream.read(cache_toasInfo, 8, false));
    this.popInfo = ((PopupImgInfo)paramJceInputStream.read(cache_popInfo, 9, false));
    this.iReportInterval = paramJceInputStream.read(this.iReportInterval, 10, false);
    this.bUpdate = paramJceInputStream.read(this.bUpdate, 11, false);
    this.iDrawerTextId = paramJceInputStream.read(this.iDrawerTextId, 12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iWkOrderState1, 0);
    paramJceOutputStream.write(this.iWkOrderState2, 1);
    paramJceOutputStream.write(this.iDrawerEnable, 2);
    paramJceOutputStream.write(this.iGuideEnable, 3);
    Object localObject = this.sDrawerText;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.sDrawerUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.sGuideUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    paramJceOutputStream.write(this.iImsiInterval, 7);
    localObject = this.toasInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 8);
    }
    localObject = this.popInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    paramJceOutputStream.write(this.iReportInterval, 10);
    paramJceOutputStream.write(this.bUpdate, 11);
    paramJceOutputStream.write(this.iDrawerTextId, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MQQ.TrafficResultInfo
 * JD-Core Version:    0.7.0.1
 */