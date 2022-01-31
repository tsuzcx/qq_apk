import android.os.SystemClock;
import com.tencent.av.avgesture.AVGestureWrapper;
import com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceDetectTask;
import com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceDetectTask.GestureDetectTaskResult;
import com.tencent.mobileqq.shortvideo.facedancegame.GestureDetectManager;
import com.tencent.mobileqq.shortvideo.facedancegame.IGestureDetectCallBack;

public class ahnc
  implements Runnable
{
  public ahnc(GestureDetectManager paramGestureDetectManager, byte[] paramArrayOfByte, int paramInt1, int paramInt2, IGestureDetectCallBack paramIGestureDetectCallBack) {}
  
  public void run()
  {
    long l = SystemClock.elapsedRealtimeNanos();
    AVGestureWrapper localAVGestureWrapper = new AVGestureWrapper(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.b, 0);
    boolean bool = localAVGestureWrapper.doCalc();
    FaceDanceDetectTask.a("AVGestureWrapper.doCalc", l, SystemClock.elapsedRealtimeNanos());
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameIGestureDetectCallBack != null)
    {
      FaceDanceDetectTask.GestureDetectTaskResult localGestureDetectTaskResult = new FaceDanceDetectTask.GestureDetectTaskResult();
      localGestureDetectTaskResult.jdField_a_of_type_Boolean = bool;
      if (bool) {
        localGestureDetectTaskResult.jdField_a_of_type_JavaLangString = localAVGestureWrapper.getGestureType();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameIGestureDetectCallBack.a(localGestureDetectTaskResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahnc
 * JD-Core Version:    0.7.0.1
 */