import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.SimpleTextView;

class afdr
  extends benv
{
  afdr(afdq paramafdq, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, benu parambenu, View.OnClickListener paramOnClickListener)
  {
    parambenu = super.a(paramInt, paramObject, parambenu, paramOnClickListener);
    if ((parambenu instanceof SimpleTextView)) {
      parambenu.setTag(paramObject);
    }
    return parambenu;
  }
  
  public void a(int paramInt, Object paramObject, benu[] paramArrayOfbenu)
  {
    this.a.a(paramInt, paramArrayOfbenu, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afdr
 * JD-Core Version:    0.7.0.1
 */