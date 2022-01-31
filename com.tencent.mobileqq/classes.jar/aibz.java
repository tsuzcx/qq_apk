import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.SimpleTextView;

class aibz
  extends benv
{
  aibz(aibw paramaibw, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
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
    paramInt = 0;
    if ((paramArrayOfbenu == null) || (paramArrayOfbenu.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfbenu.length < 0)
      {
        paramArrayOfbenu[0].b = 0;
        paramArrayOfbenu[0].a = 0;
        paramInt = 1;
      }
      while (paramInt < paramArrayOfbenu.length)
      {
        paramArrayOfbenu[paramInt].b = -1;
        paramArrayOfbenu[paramInt].a = -1;
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aibz
 * JD-Core Version:    0.7.0.1
 */