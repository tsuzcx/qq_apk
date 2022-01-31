import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloResponseManager.1.1;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class aigv
  implements View.OnClickListener
{
  aigv(aigu paramaigu) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == null) || (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.a.jdField_a_of_type_JavaLangRefWeakReference == null)) {}
    BaseChatPie localBaseChatPie;
    do
    {
      do
      {
        return;
        localBaseChatPie = (BaseChatPie)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (localBaseChatPie == null);
      localObject1 = paramView.getTag(2131297096);
      paramView = paramView.getTag(2131297097);
    } while ((localObject1 == null) || (paramView == null));
    int i = ((Integer)localObject1).intValue();
    int j = ((Integer)paramView).intValue();
    Object localObject2 = ((aiyu)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(i);
    if (localObject2 == null)
    {
      QLog.e("ApolloResponseManager", 1, "on click action is null!");
      return;
    }
    bajr.a(null, "cmshow", "Apollo", "quickresponseclick", String.valueOf(this.a.jdField_a_of_type_JavaLangString), ApolloUtil.b(this.a.jdField_a_of_type_Int), j, new String[] { String.valueOf(i), String.valueOf(((ApolloActionData)localObject2).feeType) });
    if (!ApolloUtil.a(((ApolloActionData)localObject2).actionId, ((ApolloActionData)localObject2).personNum))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResponseManager", 2, "download action data");
      }
      ThreadManager.post(new ApolloResponseManager.1.1(this, (ApolloActionData)localObject2), 5, null, false);
    }
    paramView = new ajcd(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    paramView.a = ((ApolloActionData)localObject2);
    ((ApolloActionData)localObject2).atNickName = "";
    ((ApolloActionData)localObject2).inputText = "";
    Object localObject1 = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (((SessionInfo)localObject1).jdField_a_of_type_Int == 0)
    {
      ((ApolloActionData)localObject2).peerUin = ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString;
      if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null)) {
        ((ApolloActionData)localObject2).inputText = axku.b(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
      }
    }
    while ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null))
    {
      localObject2 = localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      if ((localObject2 != null) && (((String)localObject2).length() > 99) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        ChatActivityUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131653444, 1);
        return;
        if (((((SessionInfo)localObject1).jdField_a_of_type_Int == 1) || (((SessionInfo)localObject1).jdField_a_of_type_Int == 3000)) && (localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null))
        {
          ArrayList localArrayList = new ArrayList();
          if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
            azef.a(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
          }
          if (((ApolloActionData)localObject2).personNum == 1)
          {
            if ((localArrayList.size() == 1) && (0L != ((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).uin) && (((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).startPos == 0))
            {
              String str = axku.b(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
              try
              {
                ((ApolloActionData)localObject2).atNickName = str.substring(0, ((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).textLen);
                if (((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).textLen >= localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() - 1) {}
                for (((ApolloActionData)localObject2).inputText = "";; ((ApolloActionData)localObject2).inputText = str.substring(((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).textLen))
                {
                  ((ApolloActionData)localObject2).peerUin = (((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).uin + "");
                  localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
                  break;
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloResponseManager", 2, "inputText err:" + localException.getMessage());
                  }
                  ((ApolloActionData)localObject2).inputText = "";
                }
              }
            }
            else if (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString))
            {
              localObject1 = babh.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, true);
              localObject1 = new StringBuilder("@").append((String)localObject1);
              paramView.a.peerUin = this.a.jdField_a_of_type_JavaLangString;
              paramView.a.atNickName = ((StringBuilder)localObject1).toString();
              paramView.a.inputText = axku.b(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
              localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
              localBaseChatPie.a(paramView);
              localBaseChatPie.jdField_a_of_type_Ajbx = paramView;
              this.a.a();
            }
          }
          else if ((((ApolloActionData)localObject2).personNum == 0) && (localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null))
          {
            ((ApolloActionData)localObject2).inputText = axku.b(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
            localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
          }
        }
      }
      else if ((((SessionInfo)localObject1).jdField_a_of_type_Int != 1) && (((SessionInfo)localObject1).jdField_a_of_type_Int != 3000))
      {
        localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
      }
    }
    if (localBaseChatPie != null) {
      localBaseChatPie.a(paramView);
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aigv
 * JD-Core Version:    0.7.0.1
 */