import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanel.1.1;
import com.tencent.mobileqq.apollo.view.ApolloPanel.1.2;
import com.tencent.mobileqq.apollo.view.ApolloPanelGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class almj
  extends alkv
{
  public almj(ApolloPanel paramApolloPanel) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "tab download Done");
    }
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "action res done. action=" + paramApolloActionData.actionId);
    }
    this.a.a(paramApolloActionData);
    if (ApolloPanel.a(this.a) != null) {
      ApolloPanel.a(this.a).a(paramApolloActionData);
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a == null)) {}
    MqqHandler localMqqHandler;
    do
    {
      do
      {
        do
        {
          return;
          localMqqHandler = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getHandler(ChatActivity.class);
        } while (localMqqHandler == null);
        localMqqHandler.post(new ApolloPanel.1.1(this));
        if (!paramBoolean.booleanValue()) {
          break;
        }
        this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getCurrentAccountUin());
      } while (this.a.c == null);
      this.a.c.clear();
      this.a.d(this.a.b(ApolloPanel.jdField_a_of_type_Int));
      return;
    } while ((this.a.jdField_a_of_type_Almg == null) || (this.a.jdField_a_of_type_Almg.c != 3));
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "onJsonDone in panel fail refresh panel");
    }
    localMqqHandler.post(new ApolloPanel.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     almj
 * JD-Core Version:    0.7.0.1
 */