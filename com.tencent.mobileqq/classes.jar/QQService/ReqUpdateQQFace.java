package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqUpdateQQFace
  extends JceStruct
{
  static FaceInfo cache_stFaceInfo;
  static ReqHead cache_stHeader;
  public int bPicType;
  public FaceInfo stFaceInfo;
  public ReqHead stHeader;
  
  public ReqUpdateQQFace() {}
  
  public ReqUpdateQQFace(ReqHead paramReqHead, FaceInfo paramFaceInfo, int paramInt)
  {
    this.stHeader = paramReqHead;
    this.stFaceInfo = paramFaceInfo;
    this.bPicType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_stFaceInfo == null) {
      cache_stFaceInfo = new FaceInfo();
    }
    this.stFaceInfo = ((FaceInfo)paramJceInputStream.read(cache_stFaceInfo, 1, true));
    this.bPicType = paramJceInputStream.read(this.bPicType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.stFaceInfo, 1);
    paramJceOutputStream.write(this.bPicType, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     QQService.ReqUpdateQQFace
 * JD-Core Version:    0.7.0.1
 */