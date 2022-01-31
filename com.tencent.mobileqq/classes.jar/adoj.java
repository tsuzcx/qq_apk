import com.tencent.mobileqq.lightReply.FacePicDectect;
import com.tencent.mobileqq.lightReply.LightReplyFaceDetectSoManager.Callback;
import com.tencent.qphone.base.util.QLog;

public class adoj
  implements LightReplyFaceDetectSoManager.Callback
{
  public adoj(FacePicDectect paramFacePicDectect) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FacePicDetect", 2, "loadSo" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adoj
 * JD-Core Version:    0.7.0.1
 */