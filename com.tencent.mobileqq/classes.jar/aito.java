import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoPreviewActivity.ImageAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import java.util.ArrayList;

public class aito
  extends airj
{
  protected aito(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    paramViewGroup = ((NewPhotoPreviewActivity)this.mActivity).adapter.getItem(paramInt);
    if (((NewPhotoPreviewActivity)this.mActivity).getMediaType(paramViewGroup) == 1)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label96;
      }
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(8);
      ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
      ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
    }
    label259:
    for (;;)
    {
      return paramView;
      paramInt = 0;
      break;
      label96:
      if (this.a.c)
      {
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(0);
        if (!this.a.b) {
          break label228;
        }
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(0);
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(0);
      }
      for (;;)
      {
        if ((!this.a.g) && (!this.a.isSingleMode)) {
          break label259;
        }
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
        return paramView;
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(8);
        break;
        label228:
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
      }
    }
  }
  
  public boolean needShowMultiPhoto()
  {
    return (this.mPhotoCommonData.selectedPhotoList != null) && (!this.mPhotoCommonData.selectedPhotoList.isEmpty());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aito
 * JD-Core Version:    0.7.0.1
 */