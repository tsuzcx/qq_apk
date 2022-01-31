import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;

public class ahpl
  implements ahpp
{
  private static final int jdField_a_of_type_Int = bjlo.a(172.0F);
  private static final int b = bjlo.a(31.5F);
  private static final int c = jdField_a_of_type_Int + bjlo.a(16.0F);
  private static final int d = b + bjlo.a(14.0F);
  private static final int e = c / 2;
  private static final int f = bjlo.a(65.0F);
  private static final int g = bjlo.a(10.0F);
  private static final int h = bajq.b(30.0F);
  private static final int i = bajq.b(8.0F);
  private static final int j = bajq.b(12.0F);
  private static final int k = bjlo.a(4.0F);
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  private boolean jdField_a_of_type_Boolean;
  private int l = -1;
  private int m = -1;
  private int n = -1;
  
  private int a(int paramInt)
  {
    int i2 = 0;
    int i1 = i2;
    if (this.l != -1)
    {
      i1 = i2;
      if (this.m != -1)
      {
        if ((paramInt <= this.m + j) || (this.l <= this.m + j)) {
          break label53;
        }
        i1 = 2;
      }
    }
    label53:
    do
    {
      do
      {
        return i1;
        i1 = i2;
      } while (j + paramInt >= this.m);
      i1 = i2;
    } while (this.l + j >= this.m);
    return 1;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    this.m = this.l;
    this.l = paramInt1;
    int i1;
    if ((paramInt2 == 0) && (this.n != -1)) {
      if (this.n > paramInt1) {
        if (this.n - paramInt1 < i) {
          i1 = this.n;
        }
      }
    }
    while (paramInt2 == 0)
    {
      return i1 - h;
      this.n = paramInt1;
      i1 = paramInt1;
      continue;
      i1 = paramInt1;
      if (this.n < paramInt1) {
        if (paramInt1 - this.n < i)
        {
          i1 = this.n;
        }
        else
        {
          this.n = paramInt1;
          i1 = paramInt1;
          continue;
          this.n = paramInt1;
          i1 = paramInt1;
        }
      }
    }
    if (paramInt2 == 1) {
      return (int)(i1 - h * 1.5F);
    }
    return (int)(i1 - h * 0.5F);
  }
  
  public static RectF a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return new RectF(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    RectF localRectF = a(paramView);
    a("start update ");
    a(paramInt1 - localRectF.left, paramInt2 - localRectF.top, 1.5F);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(-1);
    this.jdField_a_of_type_AndroidGraphicsCanvas.scale(1.5F, 1.5F);
    this.jdField_a_of_type_AndroidGraphicsCanvas.translate(-this.jdField_a_of_type_AndroidGraphicsRect.left, -this.jdField_a_of_type_AndroidGraphicsRect.top);
    paramView.draw(this.jdField_a_of_type_AndroidGraphicsCanvas);
    a("get Drawing cache ");
    this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QMagnifier", 2, paramString + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    this.jdField_a_of_type_Boolean = false;
    this.l = -1;
    this.m = -1;
    this.n = -1;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat2 -= g;
    this.jdField_a_of_type_AndroidGraphicsRect.set((int)(paramFloat1 - jdField_a_of_type_Int / 2 / paramFloat3), (int)(paramFloat2 - b / 2 / paramFloat3), (int)(jdField_a_of_type_Int / 2 / paramFloat3 + paramFloat1), (int)(paramFloat2 + b / 2 / paramFloat3));
  }
  
  public void a(@NonNull View paramView1, int paramInt1, int paramInt2, @NonNull View paramView2, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setClippingEnabled(false);
      a("create popWindow ");
      paramView2 = ((LayoutInflater)paramView1.getContext().getSystemService("layout_inflater")).inflate(2131493597, null, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)paramView2.findViewById(2131296776));
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setmRadius(k, false);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(paramView2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(c);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(d);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(jdField_a_of_type_Int, b, Bitmap.Config.ARGB_8888);
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
      a("create magnifier bitmap and canvas");
    }
    if ((paramBoolean) || (!this.jdField_a_of_type_Boolean)) {
      a(paramView1, paramInt1, paramInt2);
    }
    paramInt2 = a(paramInt2, a(paramInt2));
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.update(paramInt1 - e, paramInt2 - f, c, d);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView1, 0, paramInt1 - e, paramInt2 - f);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahpl
 * JD-Core Version:    0.7.0.1
 */