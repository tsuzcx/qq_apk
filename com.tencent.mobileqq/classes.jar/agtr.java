import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import java.util.ArrayList;
import mqq.util.WeakReference;

class agtr
  implements agmj
{
  agtr(agtp paramagtp, Intent paramIntent, ArrayList paramArrayList) {}
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (bkpe.a((Activity)this.jdField_a_of_type_Agtp.a.get(), paramLocalMediaInfo))
    {
      if ((agtp.a(this.jdField_a_of_type_Agtp) != null) && (paramLocalMediaInfo.mDuration > agtp.a(this.jdField_a_of_type_Agtp).c))
      {
        ((NewPhotoListActivity)this.jdField_a_of_type_Agtp.a.get()).d();
        this.jdField_a_of_type_AndroidContentIntent.putExtra("media_info", paramLocalMediaInfo);
        PhotoUtils.a((Activity)this.jdField_a_of_type_Agtp.a.get(), this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, 2, true);
        return;
      }
      new FrameVideoHelper(paramLocalMediaInfo.path, paramLocalMediaInfo.mediaWidth, paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mDuration).a(new agts(this, paramLocalMediaInfo));
      xhe.a("mystatus_localupload", "video_select", 0, 0, new String[0]);
      return;
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_Agtp.a.get()).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agtr
 * JD-Core Version:    0.7.0.1
 */