import com.tencent.mobileqq.arcard.ARCardCameraRecordFragment;

public class aalm
  implements Runnable
{
  public aalm(ARCardCameraRecordFragment paramARCardCameraRecordFragment) {}
  
  public void run()
  {
    if ((ARCardCameraRecordFragment.b(this.a)) && (ARCardCameraRecordFragment.c(this.a) != 0)) {
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalm
 * JD-Core Version:    0.7.0.1
 */