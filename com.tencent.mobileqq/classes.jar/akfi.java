import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.mobileqq.data.QIMNotifyAddFriend.VideoInfo;
import java.util.ArrayList;

class akfi
  implements View.OnClickListener
{
  akfi(akfg paramakfg, ArrayList paramArrayList, QIMNotifyAddFriend.VideoInfo paramVideoInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend$VideoInfo.videoVid), 120);
    paramView.a();
    tij.a(this.jdField_a_of_type_Akfg.a, paramView.a(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akfi
 * JD-Core Version:    0.7.0.1
 */