import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesFetcher;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesRetriever;
import com.tencent.qphone.base.util.QLog;

public class ajri
  implements ajrg
{
  public static final boolean a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ajrf jdField_a_of_type_Ajrf;
  private ajrh jdField_a_of_type_Ajrh;
  private ajrl jdField_a_of_type_Ajrl;
  private ajrm jdField_a_of_type_Ajrm;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new ajrj(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private float[] jdField_a_of_type_ArrayOfFloat = { 0.33F, 0.5F, 0.11F, 0.0F, -50.0F, 0.33F, 0.5F, 0.11F, 0.0F, -50.0F, 0.33F, 0.5F, 0.11F, 0.0F, -50.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int;
  private Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 10) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public ajri(ajrh paramajrh, String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, float paramFloat3, int paramInt4)
  {
    this.jdField_a_of_type_Ajrh = paramajrh;
    this.jdField_b_of_type_Float = paramFloat1;
    this.jdField_c_of_type_Float = paramFloat2;
    this.jdField_d_of_type_Int = paramInt2;
    this.i = paramInt3;
    this.f = (1.0F * paramInt1 / paramInt4 * paramFloat1);
    this.g = Math.max(this.f - paramInt2 * paramFloat1, 0.0F);
    this.h = 0.0F;
    if (QLog.isColorLevel()) {
      QLog.d("FramesProcessor", 2, "mTotalRange=" + this.f + ", mMaxMovedDistance=" + this.g);
    }
    this.jdField_d_of_type_Float = 0.0F;
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt3, (int)this.jdField_c_of_type_Float, Bitmap.Config.RGB_565);
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColorFilter(new ColorMatrixColorFilter(this.jdField_a_of_type_ArrayOfFloat));
    this.jdField_a_of_type_Float = paramFloat3;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, (int)paramFloat3, (int)this.jdField_c_of_type_Float);
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect((int)(Math.min(1.0F * paramInt1 / paramInt4 * paramFloat1, paramInt2 * paramFloat1) + paramFloat3), 0, paramInt3, (int)this.jdField_c_of_type_Float);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(this.jdField_a_of_type_Ajrh.getContext());
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_Ajrh.getContext(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.jdField_a_of_type_Ajrf = new ajrf(this);
    this.jdField_b_of_type_Int = ((int)Math.ceil(1.0F * paramInt3 / this.jdField_b_of_type_Float));
    this.jdField_b_of_type_Int = Math.min(this.jdField_b_of_type_Int, paramInt2);
    this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Int = 0;
    if (jdField_a_of_type_Boolean) {}
    for (this.jdField_a_of_type_Ajrm = new VideoFramesRetriever(paramString, paramFloat1);; this.jdField_a_of_type_Ajrm = new VideoFramesFetcher())
    {
      this.jdField_a_of_type_Ajrm.a(paramInt4, paramInt1, this.jdField_a_of_type_Ajrf);
      this.jdField_a_of_type_Ajrm.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      return;
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) == 0.0F;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Ajrf == null) || (this.jdField_a_of_type_Ajrf.a())) {}
    int j;
    do
    {
      return;
      j = (int)(this.jdField_d_of_type_Float / this.jdField_b_of_type_Float);
      this.jdField_a_of_type_Int = Math.max(j, 0);
    } while (this.jdField_c_of_type_Int < 6);
    this.jdField_b_of_type_Int = Math.min(j + this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(-16777216);
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      this.jdField_d_of_type_Float = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      if (this.jdField_d_of_type_Float < this.h)
      {
        this.jdField_d_of_type_Float = this.h;
        this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
      }
      if (this.jdField_d_of_type_Float > this.g)
      {
        this.jdField_d_of_type_Float = this.g;
        this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
      }
      c();
      if (this.jdField_a_of_type_Ajrh != null) {
        this.jdField_a_of_type_Ajrh.invalidate();
      }
      float f1 = this.jdField_d_of_type_Float;
      float f2 = this.e;
      this.e = this.jdField_d_of_type_Float;
      if (!a(f1 - f2, 0.0F)) {
        break label157;
      }
    }
    label157:
    while (this.jdField_a_of_type_Ajrl == null)
    {
      return;
      this.jdField_a_of_type_Ajrm.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      break;
    }
    this.jdField_a_of_type_Ajrl.a(this.jdField_d_of_type_Float, -this.jdField_d_of_type_Float, this.f - this.jdField_d_of_type_Float);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ajrh.postInvalidate();
  }
  
  public void a(int paramInt)
  {
    int j = this.jdField_a_of_type_AndroidGraphicsRect.right;
    float f1 = this.h;
    this.h = (j - paramInt + f1);
    this.jdField_a_of_type_AndroidGraphicsRect.right = paramInt;
    this.jdField_a_of_type_Ajrh.invalidate();
  }
  
  public void a(ajrl paramajrl)
  {
    this.jdField_a_of_type_Ajrl = paramajrl;
    if (this.jdField_a_of_type_Ajrl != null) {
      this.jdField_a_of_type_Ajrl.a(this.jdField_d_of_type_Float, -this.jdField_d_of_type_Float, this.f - this.jdField_d_of_type_Float);
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Ajrf == null) {
      return;
    }
    d();
    int j = Math.max(this.jdField_a_of_type_Int - 1, 0);
    float f1 = j;
    f1 = this.jdField_b_of_type_Float * f1;
    this.jdField_a_of_type_AndroidGraphicsCanvas.translate(f1 - this.jdField_d_of_type_Float + this.jdField_a_of_type_Float, 0.0F);
    int m = Math.min(this.jdField_b_of_type_Int + 3, this.jdField_d_of_type_Int);
    int k = (int)this.jdField_b_of_type_Float;
    while (j < m)
    {
      ajrk localajrk = this.jdField_a_of_type_Ajrf.a(j);
      if (localajrk != null)
      {
        k = (int)Math.min(this.f - f1, this.jdField_b_of_type_Float);
        this.jdField_c_of_type_AndroidGraphicsRect.set(0, 0, k, (int)this.jdField_c_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap(localajrk.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      this.jdField_a_of_type_AndroidGraphicsCanvas.translate(k, 0.0F);
      f1 += k;
      j += 1;
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas.translate(-f1 + this.jdField_d_of_type_Float - this.jdField_a_of_type_Float, 0.0F);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector != null) {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
  }
  
  public boolean a()
  {
    return !a(this.jdField_d_of_type_Float, 0.0F);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Ajrl = null;
    if (this.jdField_a_of_type_Ajrm != null) {
      this.jdField_a_of_type_Ajrm.a();
    }
    if (this.jdField_a_of_type_Ajrf != null) {
      this.jdField_a_of_type_Ajrf.a();
    }
    this.jdField_a_of_type_Ajrf = null;
  }
  
  public void b(int paramInt)
  {
    int j = this.jdField_b_of_type_AndroidGraphicsRect.left;
    float f1 = this.g;
    this.g = (j - paramInt + f1);
    this.jdField_b_of_type_AndroidGraphicsRect.left = paramInt;
    this.jdField_a_of_type_Ajrh.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajri
 * JD-Core Version:    0.7.0.1
 */