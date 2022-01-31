import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public class acol
  extends altm
{
  public acol(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      if ((ChatSettingActivity.a(this.a) == 0) && (ChatSettingActivity.b(this.a) != null) && (ChatSettingActivity.b(this.a).equals(paramString1)) && (paramString2 != null) && (!ChatSettingActivity.e(this.a).equals(paramString2)))
      {
        if ((ChatSettingActivity.a(this.a) != null) && (ChatSettingActivity.a(this.a).isShowing()) && (!this.a.isFinishing()))
        {
          ChatSettingActivity.a(this.a, 2131693629, 2);
          ChatSettingActivity.a(this.a).dismiss();
        }
        ChatSettingActivity.b(this.a, paramString2);
        ChatSettingActivity.b(this.a, paramString2);
        ChatSettingActivity.c(this.a, paramString2);
      }
    }
    while (ChatSettingActivity.a(this.a) != 0) {
      return;
    }
    if ((ChatSettingActivity.a(this.a) != null) && (ChatSettingActivity.a(this.a).isShowing()) && (!this.a.isFinishing())) {
      ChatSettingActivity.a(this.a).dismiss();
    }
    ChatSettingActivity.b(this.a, ChatSettingActivity.e(this.a));
  }
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap) {}
  
  protected void onSetHiddenChatSwitch(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 2)) {
      QLog.e("tag_hidden_chat", 1, "data not right");
    }
    label270:
    for (;;)
    {
      return;
      Object localObject = (String[])paramArrayOfObject[0];
      boolean[] arrayOfBoolean = (boolean[])paramArrayOfObject[1];
      if (QLog.isColorLevel()) {
        QLog.d("tag_hidden_chat", 2, new Object[] { "res:", Boolean.valueOf(paramBoolean), " len1:", Integer.valueOf(localObject.length), " len2:", Integer.valueOf(arrayOfBoolean.length) });
      }
      if (paramBoolean)
      {
        int i = 0;
        for (;;)
        {
          if (i >= localObject.length) {
            break label270;
          }
          paramArrayOfObject = localObject[i];
          paramBoolean = arrayOfBoolean[i];
          if (paramArrayOfObject.equals(ChatSettingActivity.b(this.a)))
          {
            this.a.b.setOnCheckedChangeListener(null);
            this.a.b.setChecked(paramBoolean);
            this.a.a();
            localObject = this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
            if ((!this.a.b.a()) && (!this.a.c.a())) {}
            for (i = 0;; i = 8)
            {
              ((FormSwitchItem)localObject).setVisibility(i);
              this.a.b.setOnCheckedChangeListener(this.a);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("tag_hidden_chat", 2, new Object[] { "uin:", paramArrayOfObject, " switch:", Boolean.valueOf(paramBoolean) });
              return;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (paramString.equals(ChatSettingActivity.b(this.a))) && (ChatSettingActivity.a(this.a) != null))
    {
      if ((ChatSettingActivity.a(this.a) == 1010) || (ChatSettingActivity.a(this.a) == 1001) || (ChatSettingActivity.a(this.a) == 10002))
      {
        paramString = bdbk.a(this.a.app, 200, ChatSettingActivity.b(this.a), true);
        ChatSettingActivity.a(this.a, new WeakReference(paramString));
        ChatSettingActivity.a(this.a).setImageDrawable(paramString);
      }
    }
    else {
      return;
    }
    if (ChatSettingActivity.a(this.a) == 1006)
    {
      paramString = bdbk.b(this.a.app, ChatSettingActivity.b(this.a), (byte)3);
      ChatSettingActivity.a(this.a).setImageDrawable(paramString);
      return;
    }
    paramString = bdbk.a(this.a.app, 1, ChatSettingActivity.b(this.a));
    ChatSettingActivity.a(this.a, new WeakReference(paramString));
    ChatSettingActivity.a(this.a).setImageDrawable(paramString);
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    QLog.i(ChatSettingActivity.a(this.a), 1, "onUpdateDelFriend isSuccess: " + paramBoolean + " object: " + paramObject);
    if ((paramBoolean) && (String.valueOf(paramObject).equals(ChatSettingActivity.b(this.a))) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, ChatSettingActivity.b(this.a))))
    {
      ChatSettingActivity.b(this.a, ChatSettingActivity.d(this.a, ChatSettingActivity.b(this.a)));
      if (ChatSettingActivity.e(this.a) == null) {
        ChatSettingActivity.b(this.a, "");
      }
      ChatSettingActivity.b(this.a, ChatSettingActivity.e(this.a));
      ChatSettingActivity.f(this.a);
    }
  }
  
  protected void onUpdateFriendShieldFlag(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    ChatSettingActivity.g(this.a);
    ChatSettingActivity.e(this.a);
    if (paramBoolean2) {
      if (!ChatSettingActivity.b(this.a).endsWith(paramLong + "")) {}
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        ChatSettingActivity.a(this.a, paramString, 1);
        return;
      }
    } while (!ChatSettingActivity.b(this.a).endsWith(paramLong + ""));
    if (paramBoolean1)
    {
      ChatSettingActivity.a(this.a, 2131720075, 1);
      return;
    }
    ChatSettingActivity.a(this.a, 2131720073, 1);
  }
  
  protected void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    super.onUpdateHotFriendLevel(paramBoolean, paramArrayList);
    if ((ChatSettingActivity.a(this.a) == 0) && (paramBoolean) && (paramArrayList != null) && (paramArrayList.contains(ChatSettingActivity.b(this.a))))
    {
      if (QLog.isColorLevel()) {
        QLog.d(ChatSettingActivity.a(this.a), 2, "onUpdateHotFriendLevel");
      }
      ChatSettingActivity.f(this.a);
    }
  }
  
  protected void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (ChatSettingActivity.a(this.a) != null) && (ChatSettingActivity.c(this.a) != null) && (paramString.equals(ChatSettingActivity.c(this.a))))
    {
      paramString = bdbk.b(this.a.app, paramString, (byte)3);
      ChatSettingActivity.a(this.a).setImageDrawable(paramString);
    }
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    int j;
    int i;
    if ((paramBoolean) && (paramArrayOfString != null) && (this.a.f != null) && (ChatSettingActivity.a(this.a) == 0) && (!TextUtils.isEmpty(ChatSettingActivity.b(this.a))))
    {
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfString[i];
        if (ChatSettingActivity.b(this.a).equals(str)) {
          ChatSettingActivity.a(this.a, ChatSettingActivity.a(this.a, ChatSettingActivity.b(this.a)), this.a.f);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  protected void onUpdateStrangerRichStatus(boolean paramBoolean, String[] paramArrayOfString, Map<String, RichStatus> paramMap)
  {
    if ((this.a.f != null) && (!TextUtils.isEmpty(ChatSettingActivity.b(this.a))) && (paramMap != null) && (paramMap.containsKey(ChatSettingActivity.b(this.a)))) {
      ChatSettingActivity.a(this.a, (RichStatus)paramMap.get(ChatSettingActivity.b(this.a)), this.a.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acol
 * JD-Core Version:    0.7.0.1
 */