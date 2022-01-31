import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.TipsInfo;
import com.tencent.qphone.base.util.QLog;

public class acbe
  implements IStatusListener
{
  public acbe(MessengerService paramMessengerService) {}
  
  public void a(int paramInt, RichStatus paramRichStatus, Object paramObject)
  {
    if (this.a.b != null)
    {
      this.a.b.putString("cmd", "ipc_signature_setordelete");
      paramRichStatus = new Bundle();
      paramRichStatus.putInt("result", paramInt);
      paramRichStatus.putBoolean("hasTipsInfo", false);
      if ((paramObject instanceof TipsInfo))
      {
        paramObject = (TipsInfo)paramObject;
        if (paramObject.jdField_b_of_type_Int > 0)
        {
          paramRichStatus.putInt("result", paramObject.jdField_a_of_type_Int);
          paramRichStatus.putBoolean("hasTipsInfo", true);
          paramRichStatus.putInt("tips_type", paramObject.jdField_b_of_type_Int);
          paramRichStatus.putString("tips_titleWording", paramObject.jdField_a_of_type_JavaLangString);
          paramRichStatus.putString("tips_wording", paramObject.jdField_b_of_type_JavaLangString);
          paramRichStatus.putString("tips_rightBtnWording", paramObject.jdField_c_of_type_JavaLangString);
          paramRichStatus.putString("tips_leftBtnWording", paramObject.d);
          paramRichStatus.putString("tips_vipType", paramObject.e);
          paramRichStatus.putInt("tips_vipMonth", paramObject.jdField_c_of_type_Int);
          paramRichStatus.putString("tips_url", paramObject.f);
        }
      }
      this.a.b.putBundle("response", paramRichStatus);
      this.a.a(this.a.b);
      this.a.b = null;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == -1) {
      if (this.a.a != null) {
        this.a.a.post(new acbf(this));
      }
    }
    while (this.a.c == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SigImg2Zone", 4, "isSync: " + paramBoolean);
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isSync", paramBoolean);
    this.a.c.putBundle("response", localBundle);
    this.a.a(this.a.c);
    this.a.c = null;
  }
  
  public void b(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acbe
 * JD-Core Version:    0.7.0.1
 */