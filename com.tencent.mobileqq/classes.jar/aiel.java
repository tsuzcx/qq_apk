import android.os.Handler;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar;

public class aiel
  implements Runnable
{
  public aiel(TCProgressBar paramTCProgressBar) {}
  
  public void run()
  {
    aieh localaieh;
    if (this.a.jdField_a_of_type_Int == 3)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new aiel(this.a), this.a.d);
      localaieh = this.a.jdField_a_of_type_Aieh;
      if (this.a.jdField_a_of_type_Aieh.e) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      localaieh.e = bool;
      this.a.invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aiel
 * JD-Core Version:    0.7.0.1
 */