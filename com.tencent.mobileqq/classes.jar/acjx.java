import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class acjx
  extends allb
{
  public acjx(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null))
      {
        if ((ChatSettingActivity.a(this.a) == 0) && (ChatSettingActivity.b(this.a).equals(paramObject.uin)))
        {
          String str = bdbt.a(this.a.app, ChatSettingActivity.b(this.a));
          if ((!TextUtils.isEmpty(str)) && (!str.equals(ChatSettingActivity.f(this.a)))) {
            ChatSettingActivity.c(this.a, str);
          }
        }
        if ((this.a.f != null) && (!TextUtils.isEmpty(ChatSettingActivity.b(this.a))) && (ChatSettingActivity.b(this.a).equals(paramObject.uin))) {
          ChatSettingActivity.a(this.a, ChatSettingActivity.a(this.a, ChatSettingActivity.b(this.a)), this.a.f);
        }
      }
      return;
    }
  }
  
  protected void onGetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.a.d != null) && (paramBoolean2 != this.a.d.a()))
    {
      this.a.d.setOnCheckedChangeListener(null);
      this.a.d.setChecked(paramBoolean2);
      this.a.d.setOnCheckedChangeListener(this.a);
    }
  }
  
  protected void onSetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
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
 * Qualified Name:     acjx
 * JD-Core Version:    0.7.0.1
 */