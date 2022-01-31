import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.opengl.GLES20;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.subtitles.WordingItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

public class ajuh
{
  private static AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 15;
  private long jdField_a_of_type_Long = -1L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private String jdField_a_of_type_JavaLangString;
  private TreeMap<Long, WordingItem> jdField_a_of_type_JavaUtilTreeMap = new TreeMap();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float = -1.0F;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float = -1.0F;
  private boolean jdField_d_of_type_Boolean;
  private float e = 1.0F;
  private float f = 1.0F;
  private float g = 1.0F;
  private float h;
  private float i;
  
  private long a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.incrementAndGet();
  }
  
  private WordingItem a(long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      WordingItem localWordingItem = (WordingItem)((Map.Entry)localIterator.next()).getValue();
      if ((localWordingItem != null) && (localWordingItem.jdField_b_of_type_Long == paramLong1)) {
        return localWordingItem;
      }
    }
    return null;
  }
  
  private float c()
  {
    float f1 = this.jdField_c_of_type_Float / this.jdField_a_of_type_Float;
    float f2 = this.jdField_d_of_type_Float / this.jdField_b_of_type_Float;
    if (f1 > f2) {
      return f1;
    }
    return f2;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }
    if ((this.jdField_a_of_type_AndroidGraphicsCanvas != null) && (this.jdField_a_of_type_AndroidGraphicsPaint != null)) {
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) && (this.jdField_c_of_type_Boolean))
    {
      GLES20.glClearStencil(0);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(17664);
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
    }
  }
  
  protected float a()
  {
    return this.e;
  }
  
  public float a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.jdField_a_of_type_Float;
    }
    return this.jdField_c_of_type_Float;
  }
  
  protected int a()
  {
    return 0;
  }
  
  public int a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Int == 3) {
      return this.jdField_a_of_type_JavaUtilTreeMap.size();
    }
    if (paramBoolean) {
      return 0;
    }
    return a();
  }
  
  protected long a(long paramLong)
  {
    long l = 0L;
    if (!this.jdField_b_of_type_Boolean)
    {
      paramLong = l;
      if (this.jdField_a_of_type_Long >= 0L) {
        paramLong = this.jdField_a_of_type_Long;
      }
      return paramLong;
    }
    return paramLong / this.jdField_a_of_type_Int;
  }
  
  public long a(Canvas paramCanvas, RenderBuffer paramRenderBuffer, long paramLong)
  {
    if ((paramCanvas == null) && (paramRenderBuffer == null)) {
      return -1L;
    }
    if ((this.jdField_a_of_type_JavaUtilTreeMap.size() == 0) && (3 == this.jdField_b_of_type_Int)) {
      return -1L;
    }
    if (this.jdField_a_of_type_Long < 0L) {
      this.jdField_a_of_type_Long = 0L;
    }
    long l = this.jdField_a_of_type_Long;
    if (paramLong > 0L) {}
    for (l = paramLong / this.jdField_a_of_type_Int;; l += 1L)
    {
      if (l < this.jdField_a_of_type_Long)
      {
        QLog.d("BaseAnimDrawer", 2, "nextFrame , targetindex <= mFrameIndex, timestamp:" + paramLong + "  frameindex:" + this.jdField_a_of_type_Long);
        return -2L;
      }
      if (l == this.jdField_a_of_type_Long)
      {
        QLog.d("BaseAnimDrawer", 2, "nextFrame , targetindex == mFrameIndex, timestamp:" + paramLong + "  frameindex:" + this.jdField_a_of_type_Long + " cachevalid:" + this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Boolean) {
          return this.jdField_a_of_type_Long;
        }
        return -2L;
      }
      if ((paramRenderBuffer != null) && (this.jdField_c_of_type_Boolean))
      {
        paramRenderBuffer.bind();
        if (QLog.isColorLevel()) {
          QLog.d("BaseAnimDrawer", 2, "nextFrame timestamp:" + paramLong);
        }
      }
      this.h += this.i;
      f();
      if (this.jdField_d_of_type_Boolean) {}
      boolean bool;
      for (paramLong = this.jdField_a_of_type_Long - 1L;; paramLong = this.jdField_a_of_type_Long)
      {
        bool = a(paramCanvas, paramRenderBuffer, paramLong, this.jdField_a_of_type_Int);
        if (!this.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_Long += 1L;
        }
        if ((bool) || (this.jdField_a_of_type_Long <= this.jdField_b_of_type_Long + 1L)) {
          break;
        }
        if ((paramRenderBuffer != null) && (this.jdField_c_of_type_Boolean)) {
          paramRenderBuffer.unbind();
        }
        if (QLog.isColorLevel()) {
          QLog.d("BaseAnimDrawer", 2, "nextFrame drawer is finished:" + this.jdField_a_of_type_Long);
        }
        return -1L;
      }
      if (this.jdField_d_of_type_Boolean) {}
      for (;;)
      {
        if ((paramRenderBuffer != null) && (this.jdField_c_of_type_Boolean)) {
          paramRenderBuffer.unbind();
        }
        if (!bool) {
          break label428;
        }
        return this.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Long < l) {
          break;
        }
      }
      label428:
      if (!this.jdField_b_of_type_Boolean) {
        return -1L;
      }
      if (this.jdField_a_of_type_Long > this.jdField_b_of_type_Long) {
        return -1L;
      }
      return -2L;
    }
  }
  
  protected Typeface a(String paramString)
  {
    Typeface localTypeface = null;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localTypeface = Typeface.createFromFile(paramString);
      return localTypeface;
    }
    catch (Exception paramString)
    {
      QLog.e("BaseAnimDrawer", 2, "createTypeFace exception:" + paramString.toString());
    }
    return null;
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    b(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseAnimDrawer", 2, "setText, state:" + this.jdField_b_of_type_Int + " time:" + paramLong1 + "-" + paramLong2 + " wording: " + paramString1 + "-" + paramString2 + " final:" + paramBoolean);
    }
    WordingItem localWordingItem = a(paramLong1, paramLong2);
    if (localWordingItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseAnimDrawer", 2, "is new item");
      }
      localWordingItem = new WordingItem();
      localWordingItem.jdField_b_of_type_Long = paramLong1;
      localWordingItem.c = paramLong2;
      if (!TextUtils.isEmpty(paramString1)) {
        localWordingItem.jdField_a_of_type_JavaLangString = paramString1;
      }
      if (localWordingItem.jdField_a_of_type_JavaLangString == null) {
        localWordingItem.jdField_a_of_type_JavaLangString = "";
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localWordingItem.jdField_b_of_type_JavaLangString = paramString2;
      }
      if (localWordingItem.jdField_b_of_type_JavaLangString == null) {
        localWordingItem.jdField_b_of_type_JavaLangString = "";
      }
      localWordingItem.jdField_a_of_type_Long = a();
      if (this.jdField_b_of_type_Int == 3)
      {
        this.jdField_a_of_type_JavaUtilTreeMap.put(Long.valueOf(localWordingItem.jdField_a_of_type_Long), localWordingItem);
        paramString1 = localWordingItem;
      }
    }
    for (;;)
    {
      a(paramString1);
      return;
      paramString1 = localWordingItem;
      if (!paramBoolean)
      {
        this.jdField_a_of_type_JavaUtilTreeMap.put(Long.valueOf(localWordingItem.jdField_a_of_type_Long), localWordingItem);
        paramString1 = localWordingItem;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("BaseAnimDrawer", 2, "is old item:" + localWordingItem.jdField_a_of_type_JavaLangString + "-" + paramString1);
        }
        if (!TextUtils.isEmpty(paramString1)) {
          localWordingItem.jdField_a_of_type_JavaLangString = paramString1;
        }
        if (!TextUtils.isEmpty(paramString2)) {
          localWordingItem.jdField_b_of_type_JavaLangString = paramString2;
        }
        localWordingItem.c = paramLong2;
        paramString1 = localWordingItem;
        if (paramBoolean)
        {
          paramString1 = localWordingItem;
          if (this.jdField_b_of_type_Int != 3)
          {
            this.jdField_a_of_type_JavaUtilTreeMap.remove(Long.valueOf(localWordingItem.jdField_a_of_type_Long));
            paramString1 = localWordingItem;
          }
        }
      }
    }
  }
  
  public void a(Context paramContext, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramFloat1 > 0.0F)
    {
      this.jdField_a_of_type_Float = paramFloat1;
      this.jdField_c_of_type_Float = paramFloat1;
    }
    if (paramFloat2 > 0.0F)
    {
      this.jdField_b_of_type_Float = paramFloat2;
      this.jdField_d_of_type_Float = paramFloat2;
    }
    if (paramInt > 0) {
      this.jdField_a_of_type_Int = paramInt;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    e();
    a(paramContext, paramString);
  }
  
  public void a(Context paramContext, float paramFloat1, float paramFloat2, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramFloat1 > 0.0F) {
      this.jdField_c_of_type_Float = paramFloat1;
    }
    if (paramFloat2 > 0.0F) {
      this.jdField_d_of_type_Float = paramFloat2;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, paramInt2, paramInt3);
    localParcel.setDataPosition(0);
    paramArrayOfByte = new ArrayList();
    localParcel.readTypedList(paramArrayOfByte, WordingItem.CREATOR);
    paramArrayOfByte = paramArrayOfByte.iterator();
    while (paramArrayOfByte.hasNext())
    {
      WordingItem localWordingItem = (WordingItem)paramArrayOfByte.next();
      this.jdField_a_of_type_JavaUtilTreeMap.put(Long.valueOf(localWordingItem.jdField_a_of_type_Long), localWordingItem);
    }
    this.jdField_a_of_type_Float = localParcel.readFloat();
    this.jdField_b_of_type_Float = localParcel.readFloat();
    if (this.jdField_d_of_type_Float <= 0.0F) {
      this.jdField_d_of_type_Float = this.jdField_b_of_type_Float;
    }
    if (this.jdField_c_of_type_Float <= 0.0F) {
      this.jdField_c_of_type_Float = this.jdField_a_of_type_Float;
    }
    this.jdField_a_of_type_Int = localParcel.readInt();
    this.jdField_a_of_type_JavaLangString = localParcel.readString();
    localParcel.recycle();
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.e = c();
    a(paramContext, this.jdField_a_of_type_JavaLangString);
    d();
    a(3);
  }
  
  protected void a(Context paramContext, String paramString) {}
  
  protected void a(WordingItem paramWordingItem) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(long paramLong)
  {
    if (!d()) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer((int)this.jdField_c_of_type_Float, (int)this.jdField_d_of_type_Float, 33984);
    }
    paramLong = a(null, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer, paramLong);
    if ((paramLong != -1L) && (paramLong != -2L)) {}
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false) {
      return this.jdField_a_of_type_Boolean;
    }
  }
  
  protected boolean a(Canvas paramCanvas, RenderBuffer paramRenderBuffer, long paramLong1, long paramLong2)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = a();
    }
    return this.jdField_c_of_type_Boolean;
  }
  
  protected float b()
  {
    return this.f;
  }
  
  public float b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.jdField_b_of_type_Float;
    }
    return this.jdField_d_of_type_Float;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  protected void b() {}
  
  protected void b(int paramInt) {}
  
  protected boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c()
  {
    a();
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
    }
    if (this.jdField_a_of_type_AndroidGraphicsCanvas != null) {
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
    this.jdField_a_of_type_JavaUtilTreeMap.clear();
  }
  
  protected boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int d()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null)) {
      return this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
    }
    return -1;
  }
  
  public void d()
  {
    try
    {
      this.jdField_a_of_type_Long = -1L;
      if (this.jdField_a_of_type_JavaUtilTreeMap.size() == 0) {
        return;
      }
      if ((b()) && (this.jdField_a_of_type_JavaUtilTreeMap.size() > 0))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeMap.values().iterator();
        while (localIterator.hasNext())
        {
          WordingItem localWordingItem = (WordingItem)localIterator.next();
          if (localWordingItem != null)
          {
            if (this.jdField_b_of_type_Long < a(localWordingItem.jdField_b_of_type_Long)) {
              this.jdField_b_of_type_Long = a(localWordingItem.jdField_b_of_type_Long);
            }
            a(localWordingItem);
          }
        }
      }
    }
    finally {}
  }
  
  public boolean d()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void e()
  {
    try
    {
      b();
      this.jdField_a_of_type_JavaUtilTreeMap.clear();
      d();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajuh
 * JD-Core Version:    0.7.0.1
 */