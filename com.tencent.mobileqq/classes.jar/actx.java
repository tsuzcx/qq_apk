import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import com.tencent.mobileqq.activity.aio.doodle.HalfAlgorithm;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class actx
  implements actq
{
  public static final actr<actx> a;
  public int a;
  private acts jdField_a_of_type_Acts;
  private actu jdField_a_of_type_Actu;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private ArrayList<actz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<actu> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int = -1;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  
  static
  {
    jdField_a_of_type_Actr = new acty();
  }
  
  public actx(acto paramacto)
  {
    this.jdField_a_of_type_Int = -1;
    paramacto.a();
    if (this.jdField_a_of_type_JavaUtilList != null) {
      paramacto.a(this.jdField_a_of_type_JavaUtilList, actu.jdField_a_of_type_Actr);
    }
    paramacto.a(this.jdField_a_of_type_JavaUtilArrayList, actz.jdField_a_of_type_Actr);
    int i = paramacto.a();
    a(paramacto.a(), i);
    this.jdField_a_of_type_AndroidGraphicsRect = paramacto.a();
    this.jdField_b_of_type_AndroidGraphicsRect = paramacto.a();
    this.jdField_a_of_type_Actu = ((actu)paramacto.a(actu.jdField_a_of_type_Actr));
    this.jdField_a_of_type_Int = paramacto.a();
    this.jdField_a_of_type_Acts = new HalfAlgorithm();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_Acts.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilList = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_Acts = null;
      if (!this.jdField_b_of_type_AndroidGraphicsRect.equals(this.jdField_a_of_type_AndroidGraphicsRect)) {
        break;
      }
      QLog.d("PathDrawer", 2, "data area equal draw area, no scale.");
      return;
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
    }
    float f = a();
    QLog.d("PathDrawer", 2, "scale:" + f);
    a(f, false);
  }
  
  public actx(actt paramactt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramactt.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, paramInt1, paramInt2);
    this.jdField_a_of_type_JavaUtilList.addAll(paramactt.a());
    this.jdField_a_of_type_Acts = new HalfAlgorithm();
    this.jdField_a_of_type_Acts.a(paramInt5, paramInt6, paramFloat);
    this.jdField_a_of_type_Acts.a(paramactt.a(), this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_JavaUtilArrayList, 1000);
    QLog.d("PathDrawer", 2, "after transPath, segments count:" + this.jdField_a_of_type_JavaUtilArrayList.size());
    this.jdField_a_of_type_Acts = null;
    if (paramactt.c() > 0) {
      this.jdField_a_of_type_Actu = new actu(paramactt.a());
    }
    a(paramactt.b(), paramactt.a());
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      a(0, 0, paramInt3, paramInt4);
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect);
  }
  
  private float a()
  {
    float f1 = this.jdField_b_of_type_AndroidGraphicsRect.width() * 1.0F / this.jdField_a_of_type_AndroidGraphicsRect.width();
    float f2 = this.jdField_b_of_type_AndroidGraphicsRect.height() * 1.0F / this.jdField_a_of_type_AndroidGraphicsRect.height();
    if (f1 < f2) {
      return f1;
    }
    return f2;
  }
  
  private int a(long paramLong, boolean paramBoolean)
  {
    int i = 0;
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (j == 0) {
      i = -1;
    }
    long l;
    do
    {
      do
      {
        return i;
        if (j != 1) {
          break label67;
        }
        l = ((actz)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a();
        if (!paramBoolean) {
          break;
        }
      } while (l >= paramLong);
      return -1;
    } while (l > paramLong);
    return -1;
    label67:
    if (((actz)this.jdField_a_of_type_JavaUtilArrayList.get(j - 1)).a() < paramLong) {
      return -1;
    }
    i = 0;
    int k;
    if (j > i)
    {
      k = (j + i) / 2;
      l = ((actz)this.jdField_a_of_type_JavaUtilArrayList.get(k)).a();
      if (l == paramLong)
      {
        if (paramBoolean) {
          return k - ((actz)this.jdField_a_of_type_JavaUtilArrayList.get(k)).a();
        }
        j = k + 1;
        for (;;)
        {
          if ((j >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (l < ((actz)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a()))
          {
            i = j;
            if (j != this.jdField_a_of_type_JavaUtilArrayList.size()) {
              break;
            }
            return -1;
          }
          j += 1;
        }
      }
      if (l < paramLong)
      {
        k += 1;
        i = j;
        j = k;
      }
    }
    for (;;)
    {
      k = j;
      j = i;
      i = k;
      break;
      if (l > paramLong)
      {
        k -= ((actz)this.jdField_a_of_type_JavaUtilArrayList.get(k)).a();
        j = i;
        i = k;
        continue;
        return j - ((actz)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a();
      }
      else
      {
        k = i;
        i = j;
        j = k;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    if (paramInt2 > 0) {}
    a(paramInt1);
    b(paramInt2);
  }
  
  private void a(Canvas paramCanvas, actu paramactu)
  {
    if ((paramCanvas != null) && (paramactu != null) && (this.jdField_a_of_type_AndroidGraphicsPaint != null))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(paramactu.c() / 2.0F);
      paramCanvas.drawCircle(paramactu.a(), paramactu.b(), paramactu.c() / 4.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private void a(Canvas paramCanvas, actz paramactz)
  {
    if (paramCanvas != null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(paramactz.a());
      paramCanvas.drawPath(paramactz.a(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    long l = 0L;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      l = ((actz)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).a();
    }
    while (this.jdField_a_of_type_Actu == null) {
      return l;
    }
    return 0L;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Actu = null;
    this.jdField_b_of_type_Int = -1;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    this.jdField_a_of_type_Actu = new actu(paramFloat1, paramFloat2, paramFloat3, paramLong);
    if (this.jdField_a_of_type_Acts == null) {
      this.jdField_a_of_type_Acts = new HalfAlgorithm();
    }
    this.jdField_a_of_type_Acts.a(paramFloat1, paramFloat2, paramFloat3, 0L, this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (!this.jdField_a_of_type_AndroidGraphicsPath.isEmpty())
    {
      localObject1 = new Matrix();
      ((Matrix)localObject1).postScale(paramFloat, paramFloat);
      localObject2 = new Path();
      ((Path)localObject2).addPath(this.jdField_a_of_type_AndroidGraphicsPath, (Matrix)localObject1);
      this.jdField_a_of_type_AndroidGraphicsPath = ((Path)localObject2);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (actz)((Iterator)localObject1).next();
        ((actz)localObject2).c(paramFloat);
        if (paramBoolean) {
          ((actz)localObject2).a(((actz)localObject2).a() * paramFloat);
        }
      }
    }
    if ((paramBoolean) && (this.jdField_a_of_type_Actu != null)) {
      this.jdField_a_of_type_Actu.d(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    b(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 - paramInt1 == 0) || (paramInt4 - paramInt2 == 0)) {}
    while (this.jdField_b_of_type_AndroidGraphicsRect == null) {
      return;
    }
    if ((this.jdField_b_of_type_AndroidGraphicsRect.width() == paramInt3 - paramInt1) && (this.jdField_b_of_type_AndroidGraphicsRect.height() == paramInt4 - paramInt2))
    {
      QLog.d("PathDrawer", 2, "draw area not change.");
      return;
    }
    if ((!this.jdField_b_of_type_AndroidGraphicsRect.isEmpty()) && (!this.jdField_a_of_type_AndroidGraphicsRect.isEmpty()) && (!this.jdField_b_of_type_AndroidGraphicsRect.equals(this.jdField_a_of_type_AndroidGraphicsRect))) {}
    for (float f1 = a();; f1 = 1.0F)
    {
      this.jdField_b_of_type_AndroidGraphicsRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
      QLog.d("PathDrawer", 2, "setArea:" + this.jdField_b_of_type_AndroidGraphicsRect);
      float f2 = a();
      QLog.d("PathDrawer", 2, "scale:" + f2 + "  Old:" + f1);
      if ((f2 / f1 - 1.0F < 1.0E-006D) && (f2 / f1 - 1.0F > -1.0E-006D)) {
        QLog.d("PathDrawer", 2, "scale no change, return:");
      }
      a(f2 / f1, true);
      return;
    }
  }
  
  public void a(acto paramacto, int paramInt)
  {
    paramacto.a(1);
    paramacto.a(this.jdField_a_of_type_JavaUtilList);
    paramacto.a(this.jdField_a_of_type_JavaUtilArrayList);
    paramacto.a(this.jdField_b_of_type_Int);
    paramacto.a(this.jdField_a_of_type_AndroidGraphicsPaint.getColor());
    paramacto.a(this.jdField_a_of_type_AndroidGraphicsRect);
    paramacto.a(this.jdField_b_of_type_AndroidGraphicsRect);
    paramacto.a(this.jdField_a_of_type_Actu);
    paramacto.a(this.jdField_a_of_type_Int);
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      if (this.jdField_a_of_type_Actu != null) {
        a(paramCanvas, this.jdField_a_of_type_Actu);
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        a(paramCanvas, (actz)localIterator.next());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Acts != null)
    {
      if (!paramBoolean) {
        this.jdField_a_of_type_Acts.a(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Acts.a(this.jdField_a_of_type_JavaUtilArrayList, 0);
    this.jdField_a_of_type_Acts = null;
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (!this.jdField_a_of_type_AndroidGraphicsPath.isEmpty())) || ((this.jdField_a_of_type_JavaUtilArrayList.size() == 0) && (this.jdField_a_of_type_Actu != null));
  }
  
  public boolean a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0) {
      return false;
    }
    if (paramInt1 > paramInt2) {
      return false;
    }
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      if ((paramInt2 == 0) && (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
      {
        if (this.jdField_a_of_type_Actu != null) {
          a(paramCanvas, this.jdField_a_of_type_Actu);
        }
        return true;
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        if ((paramInt1 == 0) && (this.jdField_a_of_type_Actu != null)) {
          a(paramCanvas, this.jdField_a_of_type_Actu);
        }
        return false;
      }
      int i = paramInt2;
      if (paramInt2 > this.jdField_a_of_type_JavaUtilArrayList.size()) {
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
      }
      while (paramInt1 < i)
      {
        a(paramCanvas, (actz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1));
        paramInt1 += 1;
      }
      return i < this.jdField_a_of_type_JavaUtilArrayList.size();
    }
  }
  
  public boolean a(Canvas paramCanvas, long paramLong1, long paramLong2)
  {
    if (paramLong2 < 0L) {
      return false;
    }
    if (paramLong1 > paramLong2) {
      return false;
    }
    long l = paramLong1;
    if (paramLong1 < 0L) {
      l = 0L;
    }
    if ((paramLong2 == 0L) && (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      if (this.jdField_a_of_type_Actu != null) {
        a(paramCanvas, this.jdField_a_of_type_Actu);
      }
      return true;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if ((l == 0L) && (this.jdField_a_of_type_Actu != null)) {
        a(paramCanvas, this.jdField_a_of_type_Actu);
      }
      return false;
    }
    if ((paramLong2 == 0L) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0)) {
      return true;
    }
    int j = a(l, true);
    int i = a(paramLong2, false);
    if (j < 0) {
      return true;
    }
    if (i < 0) {
      i = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    for (;;)
    {
      if (j < i)
      {
        a(paramCanvas, (actz)this.jdField_a_of_type_JavaUtilArrayList.get(j));
        j += 1;
        continue;
        if (i == j)
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() <= i) {
            return true;
          }
          a(paramCanvas, (actz)this.jdField_a_of_type_JavaUtilArrayList.get(j));
          return false;
        }
      }
      else
      {
        return i < this.jdField_a_of_type_JavaUtilArrayList.size();
      }
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    if (this.jdField_a_of_type_Actu != null) {
      return 1;
    }
    return 0;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (this.jdField_a_of_type_Acts != null) {
      this.jdField_a_of_type_Acts.b(paramFloat1, paramFloat2, paramFloat3, paramLong, this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
      Object localObject = acte.a().a(0, paramInt);
      if (localObject != null)
      {
        localObject = new BitmapShader((Bitmap)localObject, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        if (localObject != null) {
          this.jdField_a_of_type_AndroidGraphicsPaint.setShader((Shader)localObject);
        }
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt;
      return;
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     actx
 * JD-Core Version:    0.7.0.1
 */