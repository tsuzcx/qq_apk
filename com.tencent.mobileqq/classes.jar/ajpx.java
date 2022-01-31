import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

class ajpx
{
  public int a;
  public ajqs a;
  public Bitmap a;
  public boolean a;
  public ajqs b;
  
  public ajpx(String paramString, float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, Typeface paramTypeface)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Ajqs = new ajqs(paramString, paramFloat1, paramInt, paramFloat2, -1.0F, 1, -1.0F, paramTypeface);
    this.b = new ajqs(paramString, paramFloat1, -1, paramFloat2, -1.0F, 1, paramFloat3, paramTypeface);
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      b(paramString);
      return;
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {}
    do
    {
      return true;
      if ((paramString1 == null) || (paramString2 == null)) {
        return false;
      }
    } while (paramString1.equals(paramString2));
    return false;
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      if (this.jdField_a_of_type_Int != -1)
      {
        GlUtil.deleteTexture(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Int = -1;
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      if (this.jdField_a_of_type_Int != -1)
      {
        GlUtil.deleteTexture(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Int = -1;
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = ajqa.a(this.b.jdField_a_of_type_Float + 5.0F, this.b.b);
    } while (this.jdField_a_of_type_AndroidGraphicsBitmap == null);
    paramString = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.b.a(paramString, 0.0F, 0.0F);
    this.jdField_a_of_type_Ajqs.a(paramString, 0.0F, 0.0F);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int != -1)
    {
      GlUtil.deleteTexture(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = -1;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      this.b.a(paramCanvas, paramFloat1, paramFloat2);
      this.jdField_a_of_type_Ajqs.a(paramCanvas, paramFloat1, paramFloat2);
      return;
    }
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, paramFloat1, paramFloat2, null);
  }
  
  public void a(RenderBuffer paramRenderBuffer, float paramFloat1, float paramFloat2)
  {
    if ((paramRenderBuffer == null) || (!this.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Int < 0) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        this.jdField_a_of_type_Int = GlUtil.createTexture(3553, this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
    } while (this.jdField_a_of_type_Int < 0);
    ajqa.a(paramRenderBuffer, this.jdField_a_of_type_Int, this.b.jdField_a_of_type_Float, this.b.b, null, paramFloat1, paramFloat2);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (!a(paramString, this.jdField_a_of_type_Ajqs.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Ajqs.a(paramString);
        this.b.a(paramString);
        b(paramString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpx
 * JD-Core Version:    0.7.0.1
 */