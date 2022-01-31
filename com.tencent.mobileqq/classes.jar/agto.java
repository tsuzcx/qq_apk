import android.app.Activity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import mqq.util.WeakReference;

class agto
  implements agmh
{
  agto(agtn paramagtn) {}
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (bkpv.a((Activity)this.a.a.get(), paramLocalMediaInfo))
    {
      agtn.a(this.a, paramLocalMediaInfo);
      xhb.a("mystatus_localupload", "pic_select", 0, 0, new String[0]);
      return;
    }
    ((NewPhotoListActivity)this.a.a.get()).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agto
 * JD-Core Version:    0.7.0.1
 */