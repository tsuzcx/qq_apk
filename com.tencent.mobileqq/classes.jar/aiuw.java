import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor;
import com.tencent.qphone.base.util.QLog;

class aiuw
  implements Runnable
{
  aiuw(aiuv paramaiuv) {}
  
  public void run()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "ImageUploadStep|changeImgUrl,need rich since invalid url=" + ForwardSdkShareProcessor.a(this.a.a.b));
    ForwardSdkShareProcessor.c(this.a.a.b, null);
    ForwardSdkShareProcessor.a(this.a.a.b).g();
    ForwardSdkShareProcessor.a(this.a.a.b).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiuw
 * JD-Core Version:    0.7.0.1
 */