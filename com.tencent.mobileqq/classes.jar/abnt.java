import android.view.View;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class abnt
  implements AdapterView.OnItemClickListener
{
  public abnt(CardPicGalleryActivity paramCardPicGalleryActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!this.a.isFinishing())
    {
      this.a.overridePendingTransition(0, 2131034423);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abnt
 * JD-Core Version:    0.7.0.1
 */