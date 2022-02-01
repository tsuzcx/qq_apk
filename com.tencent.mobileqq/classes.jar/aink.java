import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.SimpleTextView;

class aink
  extends bjub
{
  aink(ainj paramainj, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, bjua parambjua, View.OnClickListener paramOnClickListener)
  {
    parambjua = super.a(paramInt, paramObject, parambjua, paramOnClickListener);
    if ((parambjua instanceof SimpleTextView)) {
      parambjua.setTag(-10, paramObject);
    }
    return parambjua;
  }
  
  public void a(int paramInt, Object paramObject, bjua[] paramArrayOfbjua)
  {
    this.a.a(paramInt, paramArrayOfbjua);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aink
 * JD-Core Version:    0.7.0.1
 */