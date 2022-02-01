import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.subscribe.comment.CommentPresenter.5.1;
import com.tencent.qphone.base.util.QLog;

public class aaew
  implements View.OnLayoutChangeListener
{
  aaew(aaet paramaaet) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    QLog.d(aaet.a(), 2, "OnLayoutChangeListener scrollToReplyView start mScrollToTargetReply" + aaet.c(this.a));
    if ((aaet.a(this.a) != null) && (aaet.c(this.a))) {
      aaet.a(this.a, new CommentPresenter.5.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaew
 * JD-Core Version:    0.7.0.1
 */