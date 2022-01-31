import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.newfriend.connections.ConnectsExplorationBanner;
import com.tencent.widget.SimpleTextView;

class afme
  extends bfvp
{
  afme(afma paramafma, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, bfvo parambfvo, View.OnClickListener paramOnClickListener)
  {
    parambfvo = super.a(paramInt, paramObject, parambfvo, paramOnClickListener);
    if ((parambfvo instanceof SimpleTextView)) {
      parambfvo.setTag(paramObject);
    }
    return parambfvo;
  }
  
  public void a(int paramInt, Object paramObject, bfvo[] paramArrayOfbfvo)
  {
    int i = 0;
    if ((paramArrayOfbfvo == null) || (paramArrayOfbfvo.length <= 0)) {}
    for (;;)
    {
      return;
      paramInt = i;
      if (paramArrayOfbfvo.length < 0)
      {
        paramInt = i;
        if (!(paramObject instanceof ConnectsExplorationBanner))
        {
          paramArrayOfbfvo[0].b = 0;
          paramArrayOfbfvo[0].a = 0;
          paramInt = 1;
        }
      }
      while (paramInt < paramArrayOfbfvo.length)
      {
        paramArrayOfbfvo[paramInt].b = -1;
        paramArrayOfbfvo[paramInt].a = -1;
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afme
 * JD-Core Version:    0.7.0.1
 */