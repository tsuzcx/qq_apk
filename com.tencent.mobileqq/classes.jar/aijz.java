import android.content.Intent;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;

public class aijz
  extends aijp
{
  public aijz(PhotoCropActivity paramPhotoCropActivity)
  {
    super(paramPhotoCropActivity);
  }
  
  public void a(int paramInt)
  {
    this.a.getIntent().putExtra("PhotoConst.QZONE_COVER_SYNC_FLAG", paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijz
 * JD-Core Version:    0.7.0.1
 */