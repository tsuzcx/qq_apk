import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.SimpleTextView;

class aiqp
  extends bfvp
{
  aiqp(aiqo paramaiqo, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, bfvo parambfvo, View.OnClickListener paramOnClickListener)
  {
    parambfvo = super.a(paramInt, paramObject, parambfvo, paramOnClickListener);
    if ((parambfvo instanceof SimpleTextView)) {
      parambfvo.setTag(-10, paramObject);
    }
    return parambfvo;
  }
  
  public void a(int paramInt, Object paramObject, bfvo[] paramArrayOfbfvo)
  {
    this.a.a(paramInt, paramArrayOfbfvo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aiqp
 * JD-Core Version:    0.7.0.1
 */