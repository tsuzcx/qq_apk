import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import java.util.ArrayList;

public class akor
  extends akmu
{
  akor(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  private void e()
  {
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0)
    {
      ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setEnabled(true);
      return;
    }
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setEnabled(false);
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    e();
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    e();
  }
  
  public void initUI()
  {
    super.initUI();
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setOnClickListener(new akos(this));
    e();
  }
  
  public void onBackPressed(boolean paramBoolean)
  {
    bnqm.a().aJ();
    super.onBackPressed(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akor
 * JD-Core Version:    0.7.0.1
 */