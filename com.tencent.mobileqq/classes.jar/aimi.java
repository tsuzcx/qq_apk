import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class aimi
  implements View.OnLongClickListener
{
  public aimi(StructMsgForGeneralShare paramStructMsgForGeneralShare, OnLongClickAndTouchListener paramOnLongClickAndTouchListener) {}
  
  public boolean onLongClick(View paramView)
  {
    StructMsgForGeneralShare.clickedItemIndex = 0;
    AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)paramView.getTag();
    if (!TextUtils.isEmpty(localAbsStructMsgElement.s)) {
      StructMsgForGeneralShare.clickedItemIndex = Integer.valueOf(localAbsStructMsgElement.s).intValue();
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener.onLongClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimi
 * JD-Core Version:    0.7.0.1
 */