import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aheb
  implements View.OnClickListener
{
  public aheb(ahdk paramahdk) {}
  
  public void onClick(View paramView)
  {
    MessageForPoke localMessageForPoke = (MessageForPoke)((ahdx)agej.a(paramView)).a;
    bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "0X8008913", "0X8008913", 0, 0, "", "", "", "");
    switch (localMessageForPoke.interactType)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aean.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1, "", "");
      continue;
      aean.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 2, "", "");
      continue;
      aean.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 3, "", "");
      continue;
      aean.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 4, "", "");
      continue;
      aean.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1, "", "");
      continue;
      aean.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 6, "", "");
      continue;
      aean.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 5, "", "");
      continue;
      if (!ahnt.a)
      {
        ahnt.a = true;
        ahnt.a(this.a.b, localMessageForPoke.subId, localMessageForPoke.name, -1, localMessageForPoke.minVersion, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aheb
 * JD-Core Version:    0.7.0.1
 */