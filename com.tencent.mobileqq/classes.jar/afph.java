import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class afph
  implements View.OnLongClickListener
{
  private WeakReference<afpc> a;
  
  public afph(afpc paramafpc)
  {
    this.a = new WeakReference(paramafpc);
  }
  
  public boolean onLongClick(View paramView)
  {
    afpc localafpc = (afpc)this.a.get();
    if (localafpc != null) {
      return localafpc.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afph
 * JD-Core Version:    0.7.0.1
 */