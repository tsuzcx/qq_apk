import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.widget.XListView;

public class acpx
  implements awcf
{
  public acpx(VisitorsActivity paramVisitorsActivity) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    int i = 0;
    if ((paramBitmap != null) && (paramInt2 == 200))
    {
      paramBitmap = this.a.a;
      if (paramBitmap == null) {
        break label108;
      }
      paramInt2 = paramBitmap.getChildCount();
    }
    for (;;)
    {
      if (i < paramInt2)
      {
        Object localObject = paramBitmap.getChildAt(i).getTag();
        if ((localObject != null) && ((localObject instanceof acqo)))
        {
          localObject = (acqo)localObject;
          if ((((acqo)localObject).b == paramInt1) && (((acqo)localObject).e != null)) {
            VisitorsActivity.a(this.a, ((acqo)localObject).e, paramInt1);
          }
        }
        i += 1;
      }
      else
      {
        return;
        label108:
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acpx
 * JD-Core Version:    0.7.0.1
 */