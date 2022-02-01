import android.content.Intent;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class akwe
  extends aktq
{
  protected akwe(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public void initData(Intent paramIntent)
  {
    int i = ((NewPhotoPreviewActivity)this.mActivity).getIntent().getIntExtra("PhotoConst.CURRENT_SELECTED_INDEX", -1);
    ArrayList localArrayList1 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    ArrayList localArrayList2 = new ArrayList();
    if (localArrayList1 != null) {
      localArrayList2.addAll(localArrayList1);
    }
    super.initData(paramIntent);
    this.a.paths.clear();
    this.a.paths = localArrayList2;
    this.a.totalPicCount = this.a.paths.size();
    this.a.firstSelectedPostion = i;
    if (this.a.firstSelectedPostion >= this.a.totalPicCount) {
      this.a.firstSelectedPostion = -1;
    }
    this.mPhotoCommonData.selectedIndex.clear();
    this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(this.a.firstSelectedPostion));
    paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (this.mPhotoCommonData.selectedPhotoList == null) {
      this.mPhotoCommonData.selectedPhotoList = new ArrayList();
    }
    for (;;)
    {
      if ((paramIntent != null) && (!paramIntent.equals(""))) {
        this.mPhotoCommonData.selectedPhotoList.add(paramIntent);
      }
      QLog.d("PhotoPreviewLogicScanEntry", 1, new Object[] { "count=", Integer.valueOf(this.a.totalPicCount), " pos=", Integer.valueOf(this.a.firstSelectedPostion) });
      return;
      this.mPhotoCommonData.selectedPhotoList.clear();
    }
  }
  
  public void initUI()
  {
    super.initUI();
    ((NewPhotoPreviewActivity)this.mActivity).cancelTv.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwe
 * JD-Core Version:    0.7.0.1
 */