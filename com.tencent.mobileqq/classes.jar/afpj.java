import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class afpj
  implements View.OnLongClickListener
{
  private WeakReference<afpe> a;
  
  public afpj(afpe paramafpe)
  {
    this.a = new WeakReference(paramafpe);
  }
  
  public boolean onLongClick(View paramView)
  {
    afpe localafpe = (afpe)this.a.get();
    if (localafpe != null) {
      return localafpe.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afpj
 * JD-Core Version:    0.7.0.1
 */