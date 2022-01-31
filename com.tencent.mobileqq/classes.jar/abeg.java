import android.os.Handler;
import android.text.Editable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class abeg
  implements Runnable
{
  public abeg(ArkRecommendController paramArkRecommendController) {}
  
  public void run()
  {
    ArkRecommendController.a(this.a, null);
    Object localObject = ArkRecommendController.a(this.a).a.getEditableText();
    if ((ArkRecommendController.a(this.a) == null) || (ArkRecommendController.a(this.a).a == null) || (ArkRecommendController.a(this.a).a.getText() == null) || (localObject == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRecommendController", 2, "mChatPie is null or input ctrl is null");
      }
    }
    String str;
    do
    {
      return;
      str = ArkRecommendController.a(this.a).a.getText().toString();
    } while (str.length() > 80);
    localObject = (AtTroopMemberSpan[])((Editable)localObject).getSpans(0, localObject.toString().length(), AtTroopMemberSpan.class);
    ArkRecommendController.a(this.a);
    ArkRecommendLogic.a().post(new abeh(this, str, (AtTroopMemberSpan[])localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abeg
 * JD-Core Version:    0.7.0.1
 */