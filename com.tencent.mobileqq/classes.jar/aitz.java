import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

public class aitz
  extends airj
{
  aitz(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  protected void c()
  {
    Object localObject = ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList();
    Intent localIntent = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
    if (localObject != null)
    {
      aips.a(((ArrayList)localObject).size(), this.a.totalPicCount);
      aips.a(localIntent, ((ArrayList)localObject).size(), this.mPhotoCommonData.currentQualityType);
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
    paramAdapterView = (NewPhotoPreviewActivity)this.mActivity;
    if ((paramAdapterView != null) && (!paramAdapterView.isFinishing())) {
      paramAdapterView.titleView.setText(alud.a(2131708535));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitz
 * JD-Core Version:    0.7.0.1
 */