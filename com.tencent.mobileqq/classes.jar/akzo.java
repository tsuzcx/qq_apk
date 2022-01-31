import android.os.Handler;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;

public class akzo
  implements Runnable
{
  public akzo(WereWolvesLoadingView paramWereWolvesLoadingView) {}
  
  public void run()
  {
    if ((this.a.jdField_b_of_type_Int > 90) || (this.a.jdField_b_of_type_Boolean)) {
      return;
    }
    WereWolvesLoadingView localWereWolvesLoadingView1 = this.a;
    localWereWolvesLoadingView1.jdField_b_of_type_Int += 1;
    localWereWolvesLoadingView1 = this.a;
    WereWolvesLoadingView localWereWolvesLoadingView2 = this.a;
    int i = localWereWolvesLoadingView2.jdField_b_of_type_Int;
    localWereWolvesLoadingView2.jdField_b_of_type_Int = (i + 1);
    localWereWolvesLoadingView1.setProgress(i);
    i = (int)(2.222222F * this.a.jdField_b_of_type_Int + 100.0F);
    this.a.a.postDelayed(this, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akzo
 * JD-Core Version:    0.7.0.1
 */