import com.tencent.mobileqq.arcard.ARCardCameraRecordFragment;

public class aael
  implements Runnable
{
  public aael(ARCardCameraRecordFragment paramARCardCameraRecordFragment) {}
  
  public void run()
  {
    if ((ARCardCameraRecordFragment.b(this.a)) && (ARCardCameraRecordFragment.c(this.a) != 0)) {
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aael
 * JD-Core Version:    0.7.0.1
 */