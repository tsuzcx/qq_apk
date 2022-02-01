import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

public class aagd
  extends aadt
{
  protected WeakReference<Context> a;
  
  public aagd(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.a = new WeakReference(paramContext);
  }
  
  public boolean b()
  {
    Context localContext = (Context)this.a.get();
    return ((localContext instanceof Activity)) && (((Activity)localContext).isFinishing());
  }
  
  public void show()
  {
    if (b()) {
      return;
    }
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aagd
 * JD-Core Version:    0.7.0.1
 */