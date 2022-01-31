import android.os.Handler;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar;

public class ahqj
  implements Runnable
{
  public ahqj(TCProgressBar paramTCProgressBar) {}
  
  public void run()
  {
    ahqf localahqf;
    if (this.a.jdField_a_of_type_Int == 3)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new ahqj(this.a), this.a.d);
      localahqf = this.a.jdField_a_of_type_Ahqf;
      if (this.a.jdField_a_of_type_Ahqf.e) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      localahqf.e = bool;
      this.a.invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahqj
 * JD-Core Version:    0.7.0.1
 */