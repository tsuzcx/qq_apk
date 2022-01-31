import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.SimpleTextView;

class aioq
  extends bfwg
{
  aioq(aion paramaion, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, bfwf parambfwf, View.OnClickListener paramOnClickListener)
  {
    parambfwf = super.a(paramInt, paramObject, parambfwf, paramOnClickListener);
    if ((parambfwf instanceof SimpleTextView)) {
      parambfwf.setTag(paramObject);
    }
    return parambfwf;
  }
  
  public void a(int paramInt, Object paramObject, bfwf[] paramArrayOfbfwf)
  {
    paramInt = 0;
    if ((paramArrayOfbfwf == null) || (paramArrayOfbfwf.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfbfwf.length < 0)
      {
        paramArrayOfbfwf[0].b = 0;
        paramArrayOfbfwf[0].a = 0;
        paramInt = 1;
      }
      while (paramInt < paramArrayOfbfwf.length)
      {
        paramArrayOfbfwf[paramInt].b = -1;
        paramArrayOfbfwf[paramInt].a = -1;
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aioq
 * JD-Core Version:    0.7.0.1
 */