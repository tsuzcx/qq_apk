import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.SimpleTextView;

class ajhe
  extends bkov
{
  ajhe(ajhd paramajhd, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, bkou parambkou, View.OnClickListener paramOnClickListener)
  {
    parambkou = super.a(paramInt, paramObject, parambkou, paramOnClickListener);
    if ((parambkou instanceof SimpleTextView)) {
      parambkou.setTag(-10, paramObject);
    }
    return parambkou;
  }
  
  public void a(int paramInt, Object paramObject, bkou[] paramArrayOfbkou)
  {
    this.a.a(paramInt, paramArrayOfbkou);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhe
 * JD-Core Version:    0.7.0.1
 */