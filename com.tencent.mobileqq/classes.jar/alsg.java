import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class alsg
  extends Drawable
{
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private List<alsj> jdField_a_of_type_JavaUtilList;
  private int b;
  private int c;
  private int d = 1;
  private int e;
  private int f;
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramInt);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(1);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new alsh(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new alsi(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null) {
      b(paramInt);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    if (QLog.isColorLevel()) {
      QLog.d("MusicDanceView", 1, "Start music dance animation");
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_JavaUtilList.add(new alsj(this, paramInt1, paramInt2, paramInt3, paramInt4, null));
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, -16777216);
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt3);
    this.b = paramInt2;
    this.c = aciy.a(2.0F, paramContext.getResources());
    if (this.c < 0) {}
    paramInt3 = (paramInt1 - this.c * 2) / 3;
    paramInt1 = 0;
    while (paramInt1 < 3)
    {
      a(0, paramInt2, paramInt3, -1);
      paramInt1 += 1;
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    this.jdField_a_of_type_Int = 0;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      alsj localalsj = (alsj)this.jdField_a_of_type_JavaUtilList.get(i);
      paramCanvas.drawRect(this.jdField_a_of_type_Int, this.b - alsj.a(localalsj), this.jdField_a_of_type_Int + alsj.b(localalsj), this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_Int += alsj.b(localalsj) + this.c;
      i += 1;
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.f;
  }
  
  public int getIntrinsicWidth()
  {
    return this.e;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alsg
 * JD-Core Version:    0.7.0.1
 */