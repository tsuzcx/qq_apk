import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError;
import com.tencent.mobileqq.widget.QQToast;

public class aeou
  implements View.OnClickListener
{
  private long a;
  public SessionInfo a;
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1000L) {}
    Object localObject;
    MessageForPic localMessageForPic;
    URLDrawable localURLDrawable;
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Long = l;
          localObject = (URLImageView)paramView;
          localMessageForPic = (MessageForPic)((URLImageView)localObject).getTag(2131364185);
          localURLDrawable = (URLDrawable)((URLImageView)localObject).getDrawable();
        } while (localURLDrawable == null);
        switch (localURLDrawable.getStatus())
        {
        default: 
          return;
        }
      } while (localURLDrawable.isDownloadStarted());
      localURLDrawable.startDownload();
      return;
      localObject = PicDownloadExplicitError.getFailedTip(localURLDrawable);
      if (localObject != null)
      {
        QQToast.a(paramView.getContext(), (CharSequence)localObject, 0).a();
        return;
      }
    } while (!bdcs.a(paramView.getContext()));
    localURLDrawable.restartDownload();
    return;
    if (afsf.a(localMessageForPic))
    {
      AIOEmotionFragment.a(paramView.getContext(), localMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, zen.a(paramView));
      return;
    }
    localMessageForPic.isInMixedMsg = true;
    afsf.a(vhj.a(), paramView.getContext(), (View)localObject, localMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeou
 * JD-Core Version:    0.7.0.1
 */