import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class adre
  extends allu
{
  public adre(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    super.onUpdate(paramInt, paramBoolean, paramObject);
    if (paramInt == 0)
    {
      QQToast.a(BaseApplication.getContext(), 2131698778, 0).a();
      if (this.a.e != null) {
        this.a.e.setVisibility(8);
      }
      if (ChatSettingActivity.b(this.a) != null) {
        ChatSettingActivity.b(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adre
 * JD-Core Version:    0.7.0.1
 */