import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class adqs
  extends CardObserver
{
  public adqs(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null))
      {
        if ((ChatSettingActivity.a(this.a) == 0) && (ChatSettingActivity.a(this.a).equals(paramObject.uin)))
        {
          String str = ContactUtils.getFriendNick(this.a.app, ChatSettingActivity.a(this.a));
          if ((!TextUtils.isEmpty(str)) && (!str.equals(ChatSettingActivity.b(this.a)))) {
            ChatSettingActivity.a(this.a, str);
          }
        }
        if ((this.a.h != null) && (!TextUtils.isEmpty(ChatSettingActivity.a(this.a))) && (ChatSettingActivity.a(this.a).equals(paramObject.uin))) {
          ChatSettingActivity.a(this.a, ChatSettingActivity.a(this.a, ChatSettingActivity.a(this.a)), this.a.h);
        }
      }
      return;
    }
  }
  
  public void onGetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.a.d != null) && (paramBoolean2 != this.a.d.a()))
    {
      this.a.d.setOnCheckedChangeListener(null);
      this.a.d.setChecked(paramBoolean2);
      this.a.d.setOnCheckedChangeListener(this.a);
    }
  }
  
  public void onSetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.a.d != null) && (paramBoolean2 != this.a.d.a()))
    {
      this.a.d.setOnCheckedChangeListener(null);
      this.a.d.setChecked(paramBoolean2);
      this.a.d.setOnCheckedChangeListener(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqs
 * JD-Core Version:    0.7.0.1
 */