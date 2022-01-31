import android.os.Handler;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;

public class akrw
  implements Runnable
{
  public akrw(WereWolvesLoadingView paramWereWolvesLoadingView) {}
  
  public void run()
  {
    if (this.a.b >= 100)
    {
      this.a.setProgress(100);
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
      return;
    }
    WereWolvesLoadingView localWereWolvesLoadingView = this.a;
    localWereWolvesLoadingView.b += 3;
    if (this.a.b > 100) {
      this.a.b = 100;
    }
    this.a.setProgress(this.a.b);
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 40L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akrw
 * JD-Core Version:    0.7.0.1
 */