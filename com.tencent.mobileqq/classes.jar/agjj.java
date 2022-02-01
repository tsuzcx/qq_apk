import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agjj
  implements View.OnClickListener
{
  private long a;
  public SessionInfo a;
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1000L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Long = l;
      Object localObject = (URLImageView)paramView;
      MessageForPic localMessageForPic = (MessageForPic)((URLImageView)localObject).getTag(2131364437);
      URLDrawable localURLDrawable = (URLDrawable)((URLImageView)localObject).getDrawable();
      if (localURLDrawable != null) {
        switch (localURLDrawable.getStatus())
        {
        default: 
          break;
        case 0: 
          if (!localURLDrawable.isDownloadStarted()) {
            localURLDrawable.startDownload();
          }
          break;
        case 2: 
          localObject = PicDownloadExplicitError.getFailedTip(localURLDrawable);
          if (localObject != null) {
            QQToast.a(paramView.getContext(), (CharSequence)localObject, 0).a();
          } else if (bhmi.a(paramView.getContext())) {
            localURLDrawable.restartDownload();
          }
          break;
        case 1: 
          if (ahng.a(localMessageForPic))
          {
            AIOEmotionFragment.a(paramView.getContext(), localMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, abke.a(paramView));
          }
          else
          {
            localMessageForPic.isInMixedMsg = true;
            ahng.a(xiz.a(), paramView.getContext(), (View)localObject, localMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, null);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjj
 * JD-Core Version:    0.7.0.1
 */