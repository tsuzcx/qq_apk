import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;

public class alvc
{
  private static double jdField_a_of_type_Double = 0.25D;
  private static float jdField_a_of_type_Float;
  private static double jdField_b_of_type_Double = 0.5D;
  private static float jdField_b_of_type_Float;
  private static float c;
  private int jdField_a_of_type_Int;
  private int jdField_b_of_type_Int;
  
  public alvc(Context paramContext)
  {
    a(paramContext);
    paramContext = paramContext.getResources();
    jdField_a_of_type_Float = paramContext.getDimensionPixelSize(2131166275);
    jdField_b_of_type_Float = paramContext.getDimensionPixelSize(2131166276);
    c = paramContext.getDimensionPixelSize(2131166274);
  }
  
  private void a(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    this.jdField_a_of_type_Int = paramContext.getDefaultDisplay().getWidth();
    this.jdField_b_of_type_Int = paramContext.getDefaultDisplay().getHeight();
  }
  
  public double a(MotionEvent paramMotionEvent)
  {
    float f = paramMotionEvent.getRawX();
    paramMotionEvent.getRawY();
    if (f <= jdField_a_of_type_Double * this.jdField_a_of_type_Int) {
      return 0.0D;
    }
    if (f >= jdField_b_of_type_Double * this.jdField_a_of_type_Int) {
      return 1.0D;
    }
    return (f - jdField_a_of_type_Double * this.jdField_a_of_type_Int) / ((jdField_b_of_type_Double - jdField_a_of_type_Double) * this.jdField_a_of_type_Int);
  }
  
  public boolean a(MotionEvent paramMotionEvent, Context paramContext)
  {
    return (a(paramMotionEvent) + 1.0E-008D > 1.0D) && (paramMotionEvent.getRawX() > this.jdField_a_of_type_Int - jdField_b_of_type_Float) && (paramMotionEvent.getRawY() > this.jdField_b_of_type_Int - jdField_a_of_type_Float - c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alvc
 * JD-Core Version:    0.7.0.1
 */