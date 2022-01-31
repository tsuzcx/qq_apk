import com.tencent.mobileqq.lightReply.FacePicDectect;
import com.tencent.mobileqq.lightReply.FacePicDectect.FaceDetectFinishedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;

public class aeka
  implements Runnable
{
  public aeka(FacePicDectect paramFacePicDectect, FacePicDectect.FaceDetectFinishedListener paramFaceDetectFinishedListener) {}
  
  public void run()
  {
    try
    {
      int j;
      int i;
      if (FacePicDectect.a() != null)
      {
        long l1 = System.currentTimeMillis();
        FacePicDectect.a(this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect).doTrack(FacePicDectect.a(), FacePicDectect.a(this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect) / 1, FacePicDectect.b(this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect) / 1);
        FacePicDectect.a(this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect).doFaceDetect(FacePicDectect.a(), FacePicDectect.a(this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect) / 1, FacePicDectect.b(this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect) / 1);
        j = FacePicDectect.a(this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect).getFaceCount();
        FacePicDectect.a(this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect).doTrack(FacePicDectect.a(), FacePicDectect.a(this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect) / 1, FacePicDectect.b(this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect) / 1);
        if (QLog.isColorLevel()) {
          QLog.i("faceDetectPLL", 2, "detect face temp count" + j);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("FacePicDetect", 2, "detect time is" + (l2 - l1));
        }
        i = FacePicDectect.a(this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect).getFaceCount();
      }
      for (;;)
      {
        i = Math.max(i, j);
        if (QLog.isColorLevel()) {
          QLog.d("FacePicDetect", 2, "faceDetect faceCount = " + i);
        }
        this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect$FaceDetectFinishedListener.a(i);
        FacePicDectect.a(null);
        return;
        QLog.e("FacePicDetect", 1, "rgbdata is null");
        i = -1;
        j = -1;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FacePicDetect", 1, "face detect failed", localException);
      this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect$FaceDetectFinishedListener.a(-1);
      FacePicDectect.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeka
 * JD-Core Version:    0.7.0.1
 */