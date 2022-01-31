import android.content.Context;
import com.tencent.ad.tangram.toast.AdToastAdapter;
import com.tencent.mobileqq.widget.QQToast;

public class aamo
  implements AdToastAdapter
{
  public void show(Context paramContext, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    int i = 1;
    if (paramInt1 == 1) {
      paramInt1 = i;
    }
    for (;;)
    {
      QQToast.a(paramContext, paramInt1, paramCharSequence, paramInt2).a();
      return;
      if (paramInt1 == 2) {
        paramInt1 = 2;
      } else {
        paramInt1 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamo
 * JD-Core Version:    0.7.0.1
 */