import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationBanner;
import com.tencent.widget.SimpleTextView;

class aiye
  extends blfn
{
  aiye(aiya paramaiya, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, blfm paramblfm, View.OnClickListener paramOnClickListener)
  {
    paramblfm = super.a(paramInt, paramObject, paramblfm, paramOnClickListener);
    if ((paramblfm instanceof SimpleTextView)) {
      paramblfm.setTag(paramObject);
    }
    return paramblfm;
  }
  
  public void a(int paramInt, Object paramObject, blfm[] paramArrayOfblfm)
  {
    int i = 0;
    if ((paramArrayOfblfm == null) || (paramArrayOfblfm.length <= 0)) {}
    for (;;)
    {
      return;
      paramInt = i;
      if (paramArrayOfblfm.length < 0)
      {
        paramInt = i;
        if (!(paramObject instanceof ConnectsExplorationBanner))
        {
          paramArrayOfblfm[0].b = 0;
          paramArrayOfblfm[0].a = 0;
          paramInt = 1;
        }
      }
      while (paramInt < paramArrayOfblfm.length)
      {
        paramArrayOfblfm[paramInt].b = -1;
        paramArrayOfblfm[paramInt].a = -1;
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiye
 * JD-Core Version:    0.7.0.1
 */