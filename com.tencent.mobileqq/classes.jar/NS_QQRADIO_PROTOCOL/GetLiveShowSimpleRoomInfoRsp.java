package NS_QQRADIO_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetLiveShowSimpleRoomInfoRsp
  extends JceStruct
{
  static RecordPlayInfo cache_recordPlayInfo = new RecordPlayInfo();
  public int happychat = 0;
  public int isRecordVideo = 0;
  public String multiVideoStreamUrl = "";
  public RecordPlayInfo recordPlayInfo = null;
  public String roomName = "";
  public int roomStatus = 0;
  public String roomid = "";
  public String uid = "";
  public String videoRtmpUrl = "";
  
  public GetLiveShowSimpleRoomInfoRsp() {}
  
  public GetLiveShowSimpleRoomInfoRsp(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, RecordPlayInfo paramRecordPlayInfo, int paramInt3)
  {
    this.roomid = paramString1;
    this.uid = paramString2;
    this.roomName = paramString3;
    this.roomStatus = paramInt1;
    this.multiVideoStreamUrl = paramString4;
    this.videoRtmpUrl = paramString5;
    this.isRecordVideo = paramInt2;
    this.recordPlayInfo = paramRecordPlayInfo;
    this.happychat = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.roomid = paramJceInputStream.readString(0, false);
    this.uid = paramJceInputStream.readString(1, false);
    this.roomName = paramJceInputStream.readString(2, false);
    this.roomStatus = paramJceInputStream.read(this.roomStatus, 3, false);
    this.multiVideoStreamUrl = paramJceInputStream.readString(4, false);
    this.videoRtmpUrl = paramJceInputStream.readString(5, false);
    this.isRecordVideo = paramJceInputStream.read(this.isRecordVideo, 6, false);
    this.recordPlayInfo = ((RecordPlayInfo)paramJceInputStream.read(cache_recordPlayInfo, 7, false));
    this.happychat = paramJceInputStream.read(this.happychat, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.roomid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.uid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.roomName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.roomStatus, 3);
    localObject = this.multiVideoStreamUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.videoRtmpUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    paramJceOutputStream.write(this.isRecordVideo, 6);
    localObject = this.recordPlayInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
    paramJceOutputStream.write(this.happychat, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQRADIO_PROTOCOL.GetLiveShowSimpleRoomInfoRsp
 * JD-Core Version:    0.7.0.1
 */