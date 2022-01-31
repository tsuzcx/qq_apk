import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.SimpleTextView;

class afpn
  extends bfwg
{
  afpn(afpm paramafpm, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
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
    this.a.a(paramInt, paramArrayOfbfwf, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afpn
 * JD-Core Version:    0.7.0.1
 */