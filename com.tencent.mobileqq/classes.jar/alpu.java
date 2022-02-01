import android.app.Activity;
import android.content.Intent;

public abstract interface alpu
{
  public abstract String getRefer();
  
  public abstract void localVideoClick(Activity paramActivity);
  
  public abstract void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void sendClick(Activity paramActivity, Intent paramIntent);
  
  public abstract void setRefer(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alpu
 * JD-Core Version:    0.7.0.1
 */