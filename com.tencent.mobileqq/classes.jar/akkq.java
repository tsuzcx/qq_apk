import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.SimpleTextView;

class akkq
  extends bibk
{
  akkq(akkn paramakkn, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, bibj parambibj, View.OnClickListener paramOnClickListener)
  {
    parambibj = super.a(paramInt, paramObject, parambibj, paramOnClickListener);
    if ((parambibj instanceof SimpleTextView)) {
      parambibj.setTag(paramObject);
    }
    return parambibj;
  }
  
  public void a(int paramInt, Object paramObject, bibj[] paramArrayOfbibj)
  {
    paramInt = 0;
    if ((paramArrayOfbibj == null) || (paramArrayOfbibj.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfbibj.length < 0)
      {
        paramArrayOfbibj[0].b = 0;
        paramArrayOfbibj[0].a = 0;
        paramInt = 1;
      }
      while (paramInt < paramArrayOfbibj.length)
      {
        paramArrayOfbibj[paramInt].b = -1;
        paramArrayOfbibj[paramInt].a = -1;
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akkq
 * JD-Core Version:    0.7.0.1
 */