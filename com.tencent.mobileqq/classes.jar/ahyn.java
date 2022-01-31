import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

class ahyn
{
  public float a;
  public int a;
  public ahym a;
  private ahyo a;
  public Bitmap a;
  public boolean a;
  
  public ahyn(String paramString, ahyo paramahyo, Typeface paramTypeface)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Ahyo = paramahyo;
    this.jdField_a_of_type_Ahym = new ahym(paramString, this.jdField_a_of_type_Ahyo.c, this.jdField_a_of_type_Ahyo.b, this.jdField_a_of_type_Ahyo.e, this.jdField_a_of_type_Ahyo.f, 0.0F, (this.jdField_a_of_type_Ahyo.jdField_a_of_type_Float - this.jdField_a_of_type_Ahyo.b) / 2.0F, paramTypeface);
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
    this.jdField_a_of_type_AndroidGraphicsBitmap = ahys.a(this.jdField_a_of_type_Ahym.c, this.jdField_a_of_type_Ahyo.jdField_a_of_type_Float);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      paramString = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_Ahym.jdField_a_of_type_Float = 0.0F;
      this.jdField_a_of_type_Ahym.a(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = -1;
      return;
      QLog.d("BeanItemWrapper", 2, "createcache error:" + this.jdField_a_of_type_Ahym.c + "-" + this.jdField_a_of_type_Ahyo.jdField_a_of_type_Float);
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      this.jdField_a_of_type_Ahym.jdField_a_of_type_Float = paramFloat1;
      paramFloat1 = this.jdField_a_of_type_Ahym.b;
      ahym localahym = this.jdField_a_of_type_Ahym;
      localahym.b += paramFloat2;
      this.jdField_a_of_type_Ahym.a(paramCanvas);
      this.jdField_a_of_type_Ahym.b = paramFloat1;
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
    ahys.a(paramRenderBuffer, this.jdField_a_of_type_Int, this.jdField_a_of_type_Ahym.c, this.jdField_a_of_type_Ahyo.jdField_a_of_type_Float, paramRectF, paramFloat1, paramFloat2);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (!a(paramString, this.jdField_a_of_type_Ahym.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Ahym.a(paramString);
        b(paramString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahyn
 * JD-Core Version:    0.7.0.1
 */