import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class aczm
  extends Drawable
{
  protected int a;
  aczn jdField_a_of_type_Aczn;
  Resources jdField_a_of_type_AndroidContentResResources;
  protected Paint a;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  protected Object a;
  protected int b = 50;
  
  public aczm(Resources paramResources)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = -1;
    this.b = 50;
  }
  
  public void a(aczn paramaczn)
  {
    this.jdField_a_of_type_Aczn = paramaczn;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof aczo)) && (((aczo)this.jdField_a_of_type_JavaLangObject).a != null) && (this.jdField_a_of_type_Int == 1) && (((aczo)this.jdField_a_of_type_JavaLangObject).a.equals(paramString))) {
      return;
    }
    a();
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangObject = new aczo(this, paramString);
  }
  
  public void a(String[] paramArrayOfString, int paramInt)
  {
    if (paramArrayOfString == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_JavaLangObject != null) && (!(this.jdField_a_of_type_JavaLangObject instanceof aczo)))
        {
          boolean bool = Arrays.equals((String[])this.jdField_a_of_type_JavaLangObject, paramArrayOfString);
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("VipPendantDrawable", 1, "setPngPaths, exception=" + MsfSdkUtils.getStackTraceString(localException));
        }
      }
    }
    a();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangObject = paramArrayOfString;
    this.b = paramInt;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int == -1) {}
    Bitmap localBitmap;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Aczn == null);
      localBitmap = this.jdField_a_of_type_Aczn.a();
    } while ((localBitmap == null) || (localBitmap.isRecycled()));
    paramCanvas.drawBitmap(localBitmap, null, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(paramBoolean);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aczm
 * JD-Core Version:    0.7.0.1
 */