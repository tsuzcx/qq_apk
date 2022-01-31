package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespFaceInfo
  extends JceStruct
{
  static RespHead cache_stHeader;
  static ArrayList<FaceInfo> cache_vFaceInfo;
  public int iFaceNum;
  public RespHead stHeader;
  public int uFaceTimeStamp;
  public ArrayList<FaceInfo> vFaceInfo;
  
  public RespFaceInfo() {}
  
  public RespFaceInfo(RespHead paramRespHead, int paramInt1, ArrayList<FaceInfo> paramArrayList, int paramInt2)
  {
    this.stHeader = paramRespHead;
    this.uFaceTimeStamp = paramInt1;
    this.vFaceInfo = paramArrayList;
    this.iFaceNum = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.uFaceTimeStamp = paramJceInputStream.read(this.uFaceTimeStamp, 1, true);
    if (cache_vFaceInfo == null)
    {
      cache_vFaceInfo = new ArrayList();
      FaceInfo localFaceInfo = new FaceInfo();
      cache_vFaceInfo.add(localFaceInfo);
    }
    this.vFaceInfo = ((ArrayList)paramJceInputStream.read(cache_vFaceInfo, 2, true));
    this.iFaceNum = paramJceInputStream.read(this.iFaceNum, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.uFaceTimeStamp, 1);
    paramJceOutputStream.write(this.vFaceInfo, 2);
    paramJceOutputStream.write(this.iFaceNum, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QQService.RespFaceInfo
 * JD-Core Version:    0.7.0.1
 */