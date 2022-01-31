import android.content.Intent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import java.util.List;

public class aisl
  extends aira
{
  private int a;
  private int b;
  private int c;
  
  public aisl(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  protected void b()
  {
    if ((this.mPhotoCommonData != null) && (this.mPhotoCommonData.selectedPhotoList != null) && (this.mActivity != null))
    {
      Intent localIntent = new Intent();
      localIntent.putStringArrayListExtra("img_list", this.mPhotoCommonData.selectedPhotoList);
      ((NewPhotoListActivity)this.mActivity).setResult(-1, localIntent);
      ((NewPhotoListActivity)this.mActivity).finish();
      bdfa.anim(this.mActivity, false, false);
    }
  }
  
  public List<LocalMediaInfo> getLocalMediaInfos()
  {
    List localList = super.getLocalMediaInfos();
    if (localList != null)
    {
      int i = localList.size() - 1;
      while (i >= 0)
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)localList.get(i);
        if ((!localLocalMediaInfo.path.endsWith(".gif")) && ((localLocalMediaInfo.mediaHeight < this.b) || (localLocalMediaInfo.mediaWidth < this.a))) {
          localList.remove(i);
        }
        if ((localLocalMediaInfo.path.endsWith(".gif")) && (localLocalMediaInfo.fileSize > this.c)) {
          localList.remove(i);
        }
        i -= 1;
      }
    }
    return localList;
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.a = paramIntent.getIntExtra("min_width", 200);
    this.b = paramIntent.getIntExtra("min_height", 200);
    this.c = paramIntent.getIntExtra("max_gif_size", 8388608);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    while ((paramInt2 != -1) || (paramInt1 != 100010) || (this.mPhotoCommonData == null) || (this.mPhotoCommonData.selectedPhotoList == null) || (this.mActivity == null)) {
      return;
    }
    paramIntent = new Intent();
    paramIntent.putStringArrayListExtra("img_list", this.mPhotoCommonData.selectedPhotoList);
    ((NewPhotoListActivity)this.mActivity).setResult(-1, paramIntent);
    ((NewPhotoListActivity)this.mActivity).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisl
 * JD-Core Version:    0.7.0.1
 */