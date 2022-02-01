import android.content.Intent;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import java.util.ArrayList;

class akvw
  extends aktq
{
  protected akvw(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.a.customSendBtnText = ((NewPhotoPreviewActivity)this.mActivity).getString(2131694346);
  }
  
  public void initUI()
  {
    super.initUI();
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setOnClickListener(new akvx(this));
  }
  
  public boolean needShowMultiPhoto()
  {
    return (this.mPhotoCommonData.selectedPhotoList != null) && (!this.mPhotoCommonData.selectedPhotoList.isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvw
 * JD-Core Version:    0.7.0.1
 */