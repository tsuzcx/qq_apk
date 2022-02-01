import android.content.Context;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.widget.GridView;

class ahth
  extends FrameLayout
{
  public ahth(ahte paramahte, Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = ahte.a(this.a).getPaddingLeft() + getPaddingLeft();
    if (i != paramInt1) {
      offsetLeftAndRight(i - paramInt1);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(ahte.a(this.a).getMeasuredWidth() - ahte.a(this.a).getPaddingLeft() - ahte.a(this.a).getPaddingRight(), View.MeasureSpec.getMode(paramInt1)), paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahth
 * JD-Core Version:    0.7.0.1
 */