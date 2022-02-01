import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewAdapter;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

public class akkk
  extends akif
{
  protected akkk(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public boolean needShowMultiPhoto()
  {
    return (this.mPhotoCommonData.selectedPhotoList != null) && (!this.mPhotoCommonData.selectedPhotoList.isEmpty());
  }
  
  public void onGalleryItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onGalleryItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView = ((NewPhotoPreviewActivity)this.mActivity).adapter.getItem(paramInt);
    if (((NewPhotoPreviewActivity)this.mActivity).getMediaType(paramAdapterView) == 1)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label96;
      }
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(8);
      ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
      ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
    }
    label258:
    for (;;)
    {
      return;
      paramInt = 0;
      break;
      label96:
      if (this.a.c)
      {
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(0);
        if (!this.a.b) {
          break label227;
        }
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(0);
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(0);
      }
      for (;;)
      {
        if ((!this.a.g) && (!this.a.isSingleMode)) {
          break label258;
        }
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
        return;
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(8);
        break;
        label227:
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
      }
    }
  }
  
  public void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    if (paramBundle != null)
    {
      paramBundle.putBoolean("key_multi_edit_pic", true);
      paramBundle.putBoolean("key_enable_edit_title_bar", true);
    }
    super.onMagicStickClick(paramView, 10000, paramBundle, paramInt2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkk
 * JD-Core Version:    0.7.0.1
 */