import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.newfriend.connections.ConnectsExplorationBanner;
import com.tencent.widget.SimpleTextView;

class ahjh
  extends bhxd
{
  ahjh(ahjd paramahjd, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, bhxc parambhxc, View.OnClickListener paramOnClickListener)
  {
    parambhxc = super.a(paramInt, paramObject, parambhxc, paramOnClickListener);
    if ((parambhxc instanceof SimpleTextView)) {
      parambhxc.setTag(paramObject);
    }
    return parambhxc;
  }
  
  public void a(int paramInt, Object paramObject, bhxc[] paramArrayOfbhxc)
  {
    int i = 0;
    if ((paramArrayOfbhxc == null) || (paramArrayOfbhxc.length <= 0)) {}
    for (;;)
    {
      return;
      paramInt = i;
      if (paramArrayOfbhxc.length < 0)
      {
        paramInt = i;
        if (!(paramObject instanceof ConnectsExplorationBanner))
        {
          paramArrayOfbhxc[0].b = 0;
          paramArrayOfbhxc[0].a = 0;
          paramInt = 1;
        }
      }
      while (paramInt < paramArrayOfbhxc.length)
      {
        paramArrayOfbhxc[paramInt].b = -1;
        paramArrayOfbhxc[paramInt].a = -1;
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjh
 * JD-Core Version:    0.7.0.1
 */