import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.tencent.common.app.ToolRuntimeBase;

public class abjb
  implements ComponentCallbacks2
{
  public abjb(ToolRuntimeBase paramToolRuntimeBase) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory() {}
  
  public void onTrimMemory(int paramInt)
  {
    this.a.onTrimMemory(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abjb
 * JD-Core Version:    0.7.0.1
 */