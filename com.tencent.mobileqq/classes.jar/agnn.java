import android.content.Intent;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import java.util.ArrayList;

class agnn
  implements agmh
{
  agnn(agnl paramagnl, Intent paramIntent, ArrayList paramArrayList) {}
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (bkpv.a(this.jdField_a_of_type_Agnl.a, paramLocalMediaInfo))
    {
      if (PhotoListActivity.l(this.jdField_a_of_type_Agnl.a))
      {
        if (paramLocalMediaInfo.mDuration > this.jdField_a_of_type_Agnl.a.c)
        {
          this.jdField_a_of_type_Agnl.a.f();
          this.jdField_a_of_type_AndroidContentIntent.putExtra("media_info", paramLocalMediaInfo);
          PhotoUtils.a(this.jdField_a_of_type_Agnl.a, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, 2, this.jdField_a_of_type_Agnl.a.d);
          return;
        }
        new FrameVideoHelper(paramLocalMediaInfo.path, paramLocalMediaInfo.mediaWidth, paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mDuration).a(new agno(this, paramLocalMediaInfo));
        xhb.a("mystatus_localupload", "video_select", 0, 0, new String[0]);
        return;
      }
      this.jdField_a_of_type_Agnl.a.f();
      this.jdField_a_of_type_AndroidContentIntent.putExtra("media_info", paramLocalMediaInfo);
      PhotoUtils.a(this.jdField_a_of_type_Agnl.a, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, 2, this.jdField_a_of_type_Agnl.a.d);
      return;
    }
    this.jdField_a_of_type_Agnl.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agnn
 * JD-Core Version:    0.7.0.1
 */