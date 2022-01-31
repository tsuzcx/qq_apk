import com.tencent.mobileqq.util.FaceDrawableImpl;
import com.tencent.mobileqq.util.FaceDrawableImpl.NewTroopFaceObserver;
import com.tencent.qphone.base.util.QLog;

public class ajzv
  implements FaceDrawableImpl.NewTroopFaceObserver
{
  private ajzv(FaceDrawableImpl paramFaceDrawableImpl) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean2) {
      this.a.a(paramBoolean1, 101, paramString, this.a.a);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawableImpl", 2, "====faceDrawableImpl onUpdateGroupFaceIcon === isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2 + ",disUin: " + paramString + ",type: " + 101);
      }
      return;
      this.a.a(paramBoolean1, 101, paramString, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzv
 * JD-Core Version:    0.7.0.1
 */