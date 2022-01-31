import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.HotPicPageView.MyVideoViewHolder;
import com.tencent.qphone.base.util.QLog;

public class adqk
  implements DialogInterface.OnClickListener
{
  public adqk(HotPicPageView paramHotPicPageView, HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a(-11);
    QLog.d("HotPicManagerHotPicPageView", 2, "User disallowed downd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqk
 * JD-Core Version:    0.7.0.1
 */