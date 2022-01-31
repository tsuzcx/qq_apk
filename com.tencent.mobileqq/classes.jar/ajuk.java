import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

class ajuk
{
  public float a;
  public int a;
  public ajuj a;
  private ajul a;
  public Bitmap a;
  public boolean a;
  
  public ajuk(String paramString, ajul paramajul, Typeface paramTypeface)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Ajul = paramajul;
    this.jdField_a_of_type_Ajuj = new ajuj(paramString, this.jdField_a_of_type_Ajul.c, this.jdField_a_of_type_Ajul.b, this.jdField_a_of_type_Ajul.e, this.jdField_a_of_type_Ajul.f, 0.0F, (this.jdField_a_of_type_Ajul.jdField_a_of_type_Float - this.jdField_a_of_type_Ajul.b) / 2.0F, paramTypeface);
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
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    if (this.jdField_a_of_type_Int != -1)
    {
      GlUtil.deleteTexture(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = -1;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = ajup.a(this.jdField_a_of_type_Ajuj.c, this.jdField_a_of_type_Ajul.jdField_a_of_type_Float);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      paramString = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_Ajuj.jdField_a_of_type_Float = 0.0F;
      this.jdField_a_of_type_Ajuj.a(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = -1;
      return;
      QLog.d("BeanItemWrapper", 2, "createcache error:" + this.jdField_a_of_type_Ajuj.c + "-" + this.jdField_a_of_type_Ajul.jdField_a_of_type_Float);
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      this.jdField_a_of_type_Ajuj.jdField_a_of_type_Float = paramFloat1;
      paramFloat1 = this.jdField_a_of_type_Ajuj.b;
      ajuj localajuj = this.jdField_a_of_type_Ajuj;
      localajuj.b += paramFloat2;
      this.jdField_a_of_type_Ajuj.a(paramCanvas);
      this.jdField_a_of_type_Ajuj.b = paramFloat1;
      return;
    }
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, paramFloat1, paramFloat2, null);
  }
  
  public void a(RenderBuffer paramRenderBuffer, RectF paramRectF, float paramFloat1, float paramFloat2)
  {
    if ((paramRenderBuffer == null) || (!this.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Int < 0) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        this.jdField_a_of_type_Int = GlUtil.createTexture(3553, this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
    } while (this.jdField_a_of_type_Int < 0);
    ajup.a(paramRenderBuffer, this.jdField_a_of_type_Int, this.jdField_a_of_type_Ajuj.c, this.jdField_a_of_type_Ajul.jdField_a_of_type_Float, paramRectF, paramFloat1, paramFloat2);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (!a(paramString, this.jdField_a_of_type_Ajuj.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Ajuj.a(paramString);
        b(paramString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajuk
 * JD-Core Version:    0.7.0.1
 */