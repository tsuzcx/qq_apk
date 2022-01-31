import android.os.Handler;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar;

public class aijf
  implements Runnable
{
  public aijf(TCProgressBar paramTCProgressBar) {}
  
  public void run()
  {
    aijb localaijb;
    if (this.a.jdField_a_of_type_Int == 3)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new aijf(this.a), this.a.d);
      localaijb = this.a.jdField_a_of_type_Aijb;
      if (this.a.jdField_a_of_type_Aijb.e) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      localaijb.e = bool;
      this.a.invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aijf
 * JD-Core Version:    0.7.0.1
 */