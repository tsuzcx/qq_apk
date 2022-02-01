import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

public class akpp
  extends akmu
{
  akpp(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  protected void d()
  {
    Object localObject = ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList();
    Intent localIntent = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
    if (localObject != null)
    {
      aklj.a(((ArrayList)localObject).size(), this.a.totalPicCount);
      aklj.a(localIntent, ((ArrayList)localObject).size(), this.mPhotoCommonData.currentQualityType);
    }
    localObject = (NewPhotoPreviewActivity)this.mActivity;
    if ((localObject == null) || (((NewPhotoPreviewActivity)localObject).isFinishing())) {
      return;
    }
    ((NewPhotoPreviewActivity)localObject).setResult(-1, new Intent());
    ((NewPhotoPreviewActivity)localObject).finish();
  }
  
  public void onGalleryItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onGalleryItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    if (((NewPhotoPreviewActivity)this.mActivity).isFinishing()) {
      ((NewPhotoPreviewActivity)this.mActivity).titleView.setText(anvx.a(2131707600));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akpp
 * JD-Core Version:    0.7.0.1
 */