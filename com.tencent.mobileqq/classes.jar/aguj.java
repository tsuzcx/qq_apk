import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import java.util.ArrayList;
import mqq.util.WeakReference;

class aguj
  implements agmh
{
  aguj(agui paramagui, Intent paramIntent, ArrayList paramArrayList) {}
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    ((NewPhotoListActivity)this.jdField_a_of_type_Agui.a.get()).d();
    if (bkpv.a((Activity)this.jdField_a_of_type_Agui.a.get(), paramLocalMediaInfo))
    {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("media_info", paramLocalMediaInfo);
      PhotoUtils.a((Activity)this.jdField_a_of_type_Agui.a.get(), this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, 2, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aguj
 * JD-Core Version:    0.7.0.1
 */