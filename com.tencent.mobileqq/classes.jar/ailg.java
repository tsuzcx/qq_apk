import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.SlideAndOverScrollRecyclerView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class ailg
  implements View.OnClickListener
{
  ailg(ailf paramailf) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (TroopNotifyAndRecommendView.a(this.a.a) != null) {
        TroopNotifyAndRecommendView.a(this.a.a).c();
      }
      if (!bftf.a("tag_swip_icon_menu_item", paramView.getTag()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopNotifyAndRecommendView", 2, "handleDeleteItem|onClick tag is not int");
        }
      }
      else
      {
        Object localObject1 = paramView.getTag(-1);
        Object localObject2 = paramView.getTag(-2);
        if ((!(localObject1 instanceof Integer)) || (!(localObject2 instanceof Integer)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("TroopNotifyAndRecommendView", 2, "handleDeleteItem|onClick posTag or subTag is not int");
          }
        }
        else
        {
          int i = ((Integer)localObject1).intValue();
          if (QLog.isColorLevel()) {
            QLog.i("TroopNotifyAndRecommendView", 2, "handleDeleteItem|onClick position = " + i);
          }
          localObject1 = ailf.a(this.a, i);
          if ((localObject1 instanceof MessageRecord))
          {
            localObject1 = (MessageRecord)localObject1;
            localObject2 = ((MessageForSystemMsg)localObject1).getSystemMsg();
            if (localObject2 != null)
            {
              ailu.a((structmsg.StructMsg)localObject2, ((MessageRecord)localObject1).uniseq, AppConstants.TROOP_SUSPICIOUS_MSG_UIN);
              this.a.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(107);
              ailu.a((structmsg.StructMsg)localObject2, this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailg
 * JD-Core Version:    0.7.0.1
 */