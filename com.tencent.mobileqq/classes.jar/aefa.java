import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class aefa
  extends anuw
{
  public aefa(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null))
      {
        if ((ChatSettingActivity.a(this.a) == 0) && (ChatSettingActivity.a(this.a).equals(paramObject.uin)))
        {
          String str = bhlg.a(this.a.app, ChatSettingActivity.a(this.a));
          if ((!TextUtils.isEmpty(str)) && (!str.equals(ChatSettingActivity.f(this.a)))) {
            ChatSettingActivity.c(this.a, str);
          }
        }
        if ((this.a.g != null) && (!TextUtils.isEmpty(ChatSettingActivity.a(this.a))) && (ChatSettingActivity.a(this.a).equals(paramObject.uin))) {
          ChatSettingActivity.a(this.a, ChatSettingActivity.a(this.a, ChatSettingActivity.a(this.a)), this.a.g);
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
 * Qualified Name:     aefa
 * JD-Core Version:    0.7.0.1
 */