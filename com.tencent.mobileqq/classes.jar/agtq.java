import android.app.Activity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import mqq.util.WeakReference;

class agtq
  implements agmj
{
  agtq(agtp paramagtp) {}
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (bkpe.a((Activity)this.a.a.get(), paramLocalMediaInfo))
    {
      agtp.a(this.a, paramLocalMediaInfo);
      xhe.a("mystatus_localupload", "pic_select", 0, 0, new String[0]);
      return;
    }
    ((NewPhotoListActivity)this.a.a.get()).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agtq
 * JD-Core Version:    0.7.0.1
 */