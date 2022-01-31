import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.SimpleTextView;

class akmn
  extends bibk
{
  akmn(akmm paramakmm, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, bibj parambibj, View.OnClickListener paramOnClickListener)
  {
    parambibj = super.a(paramInt, paramObject, parambibj, paramOnClickListener);
    if ((parambibj instanceof SimpleTextView)) {
      parambibj.setTag(-10, paramObject);
    }
    return parambibj;
  }
  
  public void a(int paramInt, Object paramObject, bibj[] paramArrayOfbibj)
  {
    this.a.a(paramInt, paramArrayOfbibj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akmn
 * JD-Core Version:    0.7.0.1
 */