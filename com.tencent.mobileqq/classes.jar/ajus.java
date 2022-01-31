import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

class ajus
  extends ajup
{
  int jdField_a_of_type_Int = -1;
  ajvh jdField_a_of_type_Ajvh = null;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  ajvh b = null;
  
  public ajus(long paramLong1, long paramLong2, boolean paramBoolean, String paramString, float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Typeface paramTypeface)
  {
    super(paramLong1, paramLong2, paramBoolean);
    a(6, paramFloat3);
    a(7, paramFloat4);
    this.jdField_a_of_type_Ajvh = new ajvh(paramString, paramFloat1, paramInt, paramFloat5, paramFloat6, 2, -1.0F, paramTypeface);
    this.b = new ajvh(paramString, paramFloat1, -16777216, paramFloat5, paramFloat6, 2, paramFloat2, paramTypeface);
    a(3, this.b.jdField_a_of_type_Float);
    paramInt = this.b.a();
    paramFloat1 = this.b.b * 2.0F / paramInt;
    if (paramInt == 1) {
      paramFloat1 = this.b.b;
    }
    a(4, paramFloat1);
    this.jdField_a_of_type_AndroidGraphicsBitmap = a(this.b.jdField_a_of_type_Float, paramFloat1);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      paramString = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.b.a(paramString, 0.0F, paramFloat1 - this.b.b);
      this.jdField_a_of_type_Ajvh.a(paramString, 0.0F, paramFloat1 - this.b.b);
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      this.b.a(paramCanvas, a(6), a(7) + a(4) - this.b.b);
      this.jdField_a_of_type_Ajvh.a(paramCanvas, a(6), a(7) + a(4) - this.b.b);
      return;
    }
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, a(6), a(7), null);
  }
  
  public void a(RenderBuffer paramRenderBuffer)
  {
    if ((this.jdField_a_of_type_Int < 0) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null)) {
      this.jdField_a_of_type_Int = GlUtil.createTexture(3553, this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if (this.jdField_a_of_type_Int >= 0) {
      a(paramRenderBuffer, this.jdField_a_of_type_Int, a(3), a(4), null, a(6), a(7));
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (a()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    float f;
    do
    {
      do
      {
        return;
      } while (paramString.equals(this.jdField_a_of_type_Ajvh.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_Ajvh.a(paramString);
      this.b.a(paramString);
      int i = this.b.a();
      f = this.b.b * 2.0F / i;
      if (i == 1) {
        f = this.b.b;
      }
      a(4, f);
      a(3, this.b.jdField_a_of_type_Float);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = a(this.b.jdField_a_of_type_Float, f);
    } while (this.jdField_a_of_type_AndroidGraphicsBitmap == null);
    paramString = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.b.a(paramString, 0.0F, f - this.b.b);
    this.jdField_a_of_type_Ajvh.a(paramString, 0.0F, f - this.b.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajus
 * JD-Core Version:    0.7.0.1
 */