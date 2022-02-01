import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloResponseManager.1.1;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class alph
  implements View.OnClickListener
{
  alph(alpg paramalpg) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == null) || (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.a.jdField_a_of_type_JavaLangRefWeakReference == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      BaseChatPie localBaseChatPie = (BaseChatPie)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localBaseChatPie != null)
      {
        Object localObject1 = paramView.getTag(2131362795);
        Object localObject2 = paramView.getTag(2131362796);
        if ((localObject1 != null) && (localObject2 != null))
        {
          int i = ((Integer)localObject1).intValue();
          int j = ((Integer)localObject2).intValue();
          Object localObject3 = ((amir)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(i);
          if (localObject3 == null)
          {
            QLog.e("ApolloResponseManager", 1, "on click action is null!");
          }
          else
          {
            VipUtils.a(null, "cmshow", "Apollo", "quickresponseclick", String.valueOf(this.a.jdField_a_of_type_JavaLangString), ApolloUtil.b(this.a.jdField_a_of_type_Int), j, new String[] { String.valueOf(i), String.valueOf(((ApolloActionData)localObject3).feeType) });
            if (!ApolloUtil.a(((ApolloActionData)localObject3).actionId, ((ApolloActionData)localObject3).personNum))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloResponseManager", 2, "download action data");
              }
              ThreadManager.post(new ApolloResponseManager.1.1(this, (ApolloActionData)localObject3), 5, null, false);
            }
            localObject1 = new amlx(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
            ((amlu)localObject1).h = 1;
            ((amlu)localObject1).a = ((ApolloActionData)localObject3);
            ((ApolloActionData)localObject3).atNickName = "";
            ((ApolloActionData)localObject3).inputText = "";
            localObject2 = localBaseChatPie.sessionInfo;
            if (((SessionInfo)localObject2).curType == 0)
            {
              ((ApolloActionData)localObject3).peerUin = ((SessionInfo)localObject2).curFriendUin;
              if ((localBaseChatPie != null) && (localBaseChatPie.input != null) && (localBaseChatPie.input.getText() != null)) {
                ((ApolloActionData)localObject3).inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(localBaseChatPie.input.getText().toString());
              }
            }
            for (;;)
            {
              if ((localBaseChatPie != null) && (localBaseChatPie.input != null) && (localBaseChatPie.input.getText() != null))
              {
                localObject3 = localBaseChatPie.input.getText().toString();
                if ((localObject3 != null) && (((String)localObject3).length() > 99) && (localBaseChatPie.app != null))
                {
                  ChatActivityUtils.a(localBaseChatPie.app.getApplication(), 2131718135, 1);
                  break;
                  if (((((SessionInfo)localObject2).curType != 1) && (((SessionInfo)localObject2).curType != 3000)) || (localBaseChatPie == null) || (localBaseChatPie.app == null) || (localBaseChatPie.mActivity == null)) {
                    continue;
                  }
                  ArrayList localArrayList = new ArrayList();
                  if ((localBaseChatPie != null) && (localBaseChatPie.input != null)) {
                    bevq.a(localBaseChatPie.input.getEditableText(), localArrayList);
                  }
                  if (((ApolloActionData)localObject3).personNum == 1)
                  {
                    if ((localArrayList.size() == 1) && (0L != ((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).uin) && (((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).startPos == 0))
                    {
                      String str = com.tencent.mobileqq.text.TextUtils.emoticonToText(localBaseChatPie.input.getText().toString());
                      try
                      {
                        ((ApolloActionData)localObject3).atNickName = str.substring(0, ((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).textLen);
                        if (((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).textLen >= localBaseChatPie.input.getText().length() - 1) {}
                        for (((ApolloActionData)localObject3).inputText = "";; ((ApolloActionData)localObject3).inputText = str.substring(((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).textLen))
                        {
                          ((ApolloActionData)localObject3).peerUin = (((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).uin + "");
                          localBaseChatPie.input.getText().clear();
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
                          ((ApolloActionData)localObject3).inputText = "";
                        }
                      }
                    }
                    if (android.text.TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
                      continue;
                    }
                    localObject2 = ContactUtils.getBuddyName(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, true);
                    localObject2 = new StringBuilder("@").append((String)localObject2);
                    ((amlu)localObject1).a.peerUin = this.a.jdField_a_of_type_JavaLangString;
                    ((amlu)localObject1).a.atNickName = ((StringBuilder)localObject2).toString();
                    ((amlu)localObject1).a.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(localBaseChatPie.input.getText().toString());
                    localBaseChatPie.input.getText().clear();
                    localBaseChatPie.send((amlu)localObject1);
                    localBaseChatPie.mApolloInfo = ((amlu)localObject1);
                    this.a.a();
                    break;
                  }
                  if ((((ApolloActionData)localObject3).personNum != 0) || (localBaseChatPie == null) || (localBaseChatPie.input == null) || (localBaseChatPie.input.getText() == null)) {
                    continue;
                  }
                  ((ApolloActionData)localObject3).inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(localBaseChatPie.input.getText().toString());
                  localBaseChatPie.input.getText().clear();
                  continue;
                }
                if ((((SessionInfo)localObject2).curType != 1) && (((SessionInfo)localObject2).curType != 3000)) {
                  localBaseChatPie.input.getText().clear();
                }
              }
            }
            if (localBaseChatPie != null) {
              localBaseChatPie.send((amlu)localObject1);
            }
            this.a.a();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alph
 * JD-Core Version:    0.7.0.1
 */