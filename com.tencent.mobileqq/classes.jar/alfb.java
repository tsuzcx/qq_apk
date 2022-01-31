import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager.DisplayListener;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;

@TargetApi(17)
public class alfb
  implements DisplayManager.DisplayListener
{
  private int jdField_a_of_type_Int;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final Display jdField_a_of_type_AndroidViewDisplay;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  @TargetApi(23)
  public alfb(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)paramContext.getSystemService(WindowManager.class)).getDefaultDisplay();
  }
  
  @TargetApi(23)
  public void a()
  {
    ((DisplayManager)this.jdField_a_of_type_AndroidContentContext.getSystemService(DisplayManager.class)).registerDisplayListener(this, new Handler());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Boolean = true;
  }
  
  @TargetApi(23)
  public void b()
  {
    ((DisplayManager)this.jdField_a_of_type_AndroidContentContext.getSystemService(DisplayManager.class)).unregisterDisplayListener(this);
  }
  
  public void onDisplayAdded(int paramInt) {}
  
  public void onDisplayChanged(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onDisplayRemoved(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alfb
 * JD-Core Version:    0.7.0.1
 */