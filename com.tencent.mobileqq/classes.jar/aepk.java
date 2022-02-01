import android.os.Handler;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity.12.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aepk
  extends andd
{
  public aepk(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void onOIDB0X88D_10_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (this.a.jdField_a_of_type_JavaLangString == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          this.a.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_JavaLangString.trim();
          long l = Long.parseLong(this.a.jdField_a_of_type_JavaLangString);
          if (paramLong != l) {}
        }
        catch (NumberFormatException paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.systemmsg.TroopRequestActivity", 2, "onOIDB0X88D_10_Ret=>NumberFormatException");
            }
          }
        }
      }
      this.a.h();
    } while ((!paramBoolean) || (paramTroopInfo == null));
    ThreadManager.post(new TroopRequestActivity.12.1(this, paramTroopInfo), 8, null, true);
  }
  
  protected void onOIDB0X88D_1_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (this.a.jdField_a_of_type_JavaLangString == null) {}
    do
    {
      for (;;)
      {
        return;
        this.a.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_JavaLangString.trim();
        try
        {
          long l = Long.parseLong(this.a.jdField_a_of_type_JavaLangString);
          if (paramLong != l) {}
        }
        catch (NumberFormatException paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.e("Q.systemmsg.TroopRequestActivity", 2, "onOIDB0X88D_1_Ret=>NumberFormatException");
              continue;
              QQToast.a(this.a.app.getApplication(), 2131719201, 0).b(this.a.getTitleBarHeight());
            }
          }
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        }
      }
      this.a.h();
      if (!paramBoolean) {
        break label215;
      }
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.a.p = paramTroopInfo.joinTroopQuestion;
        this.a.q = paramTroopInfo.joinTroopAnswer;
      }
      this.a.jdField_a_of_type_Short = paramTroopInfo.cGroupOption;
      if (this.a.jdField_a_of_type_Short == 3) {
        break;
      }
      TroopRequestActivity.a(this.a);
    } while (!QLog.isColorLevel());
    QLog.i("Q.systemmsg.TroopRequestActivity", 2, "troop.cGroupOption = " + paramTroopInfo.cGroupOption);
    return;
    label215:
  }
  
  protected void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 4) || (paramInt1 == 5) || (paramInt1 == 6) || (paramInt1 == 7)) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
    if (paramInt1 == 8) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == 4) || (paramInt1 == 5) || (paramInt1 == 6) || (paramInt1 == 7))
    {
      if (paramInt2 != 0) {
        break label68;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      this.a.finish();
    }
    for (;;)
    {
      if (paramInt1 == 8)
      {
        if (paramInt2 != 0) {
          break;
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
      return;
      label68:
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aepk
 * JD-Core Version:    0.7.0.1
 */