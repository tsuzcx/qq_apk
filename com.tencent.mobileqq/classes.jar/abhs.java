import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.test.MapBorderUtils;
import com.tencent.mobileqq.armap.test.MapBorderUtils.LatLng;

public class abhs
  implements DialogInterface.OnClickListener
{
  public abhs(ARMapActivity paramARMapActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < MapBorderUtils.a.length)) {
      this.a.b(MapBorderUtils.a[paramInt].b, MapBorderUtils.a[paramInt].a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abhs
 * JD-Core Version:    0.7.0.1
 */