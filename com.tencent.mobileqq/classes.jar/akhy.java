import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.SimpleTextView;

class akhy
  extends bhxd
{
  akhy(akhx paramakhx, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, bhxc parambhxc, View.OnClickListener paramOnClickListener)
  {
    parambhxc = super.a(paramInt, paramObject, parambhxc, paramOnClickListener);
    if ((parambhxc instanceof SimpleTextView)) {
      parambhxc.setTag(-10, paramObject);
    }
    return parambhxc;
  }
  
  public void a(int paramInt, Object paramObject, bhxc[] paramArrayOfbhxc)
  {
    this.a.a(paramInt, paramArrayOfbhxc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akhy
 * JD-Core Version:    0.7.0.1
 */