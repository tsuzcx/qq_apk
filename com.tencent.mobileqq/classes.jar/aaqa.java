import android.widget.ImageView;
import com.tencent.mobileqq.ar.config.MainEntryAni;
import java.lang.ref.WeakReference;

public class aaqa
  implements Runnable
{
  public aaqa(MainEntryAni paramMainEntryAni, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      ((ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get()).setVisibility(8);
      ((ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get()).setImageDrawable(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqa
 * JD-Core Version:    0.7.0.1
 */