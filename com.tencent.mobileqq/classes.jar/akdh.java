import android.view.View;
import android.view.View.OnClickListener;
import java.lang.ref.WeakReference;

class akdh
  implements View.OnClickListener
{
  private WeakReference<akdd> a;
  
  public akdh(akdd paramakdd)
  {
    this.a = new WeakReference(paramakdd);
  }
  
  public void onClick(View paramView)
  {
    akdd localakdd = (akdd)this.a.get();
    if (localakdd != null) {
      localakdd.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdh
 * JD-Core Version:    0.7.0.1
 */