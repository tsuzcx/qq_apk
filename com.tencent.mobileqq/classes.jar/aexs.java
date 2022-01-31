import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.FraudTipsBar.1;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import mqq.os.MqqHandler;

public class aexs
  implements aeyt
{
  private int jdField_a_of_type_Int = 0;
  private aeyv jdField_a_of_type_Aeyv;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  
  public aexs(QQAppInterface paramQQAppInterface, aeyv paramaeyv, Context paramContext, SessionInfo paramSessionInfo, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aeyv = paramaeyv;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public int a()
  {
    return 50;
  }
  
  public View a(Object... paramVarArgs)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561463, null);
    TextView localTextView = (TextView)localView.findViewById(2131362386);
    String str = (String)paramVarArgs[0];
    int i = ((Integer)paramVarArgs[1]).intValue();
    localTextView.setText(str);
    localView.setOnClickListener(new aext(this, i));
    return localView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FraudTipsBar", 2, "check() : ");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Int != 0)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FraudTipsBar", 2, "mAntiFraudTips is showing or has shown");
        return;
      }
      try
      {
        l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (l == 0L) {
          continue;
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          if (airk.a().a(l))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FraudTipsBar", 2, "uin cache is out of date, update it! ");
            }
            ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a("OidbSvc.0x476_146", (int)l, 146);
          }
        }
        int i = airk.a().a(l);
        if (i == 0) {
          continue;
        }
        bbbz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SecWarningCfg");
        Object localObject = (Bundle)bbbz.a().a("SecWarningCfg", "BannerWording", 146, i);
        if (localObject != null)
        {
          localObject = ((Bundle)localObject).getString("BannerWording");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            continue;
          }
          if (!this.jdField_a_of_type_Aeyv.a(this, new Object[] { localObject, Integer.valueOf(i) })) {
            continue;
          }
          this.jdField_a_of_type_Int = 1;
          axqy.b(null, "P_CliOper", "Safe_AntiFraud", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "banner", "display", i, 0, "", "", "", "");
          Timer localTimer = new Timer();
          FraudTipsBar.1 local1 = new FraudTipsBar.1(this);
          localObject = (Bundle)bbbz.a().a("SecWarningCfg", "BannerTTL", 146, i);
          if (localObject != null)
          {
            localObject = ((Bundle)localObject).getString("BannerTTL");
            try
            {
              i = Integer.parseInt((String)localObject);
              l = i;
            }
            catch (Throwable localThrowable2)
            {
              for (;;)
              {
                localThrowable2.printStackTrace();
                l = 15L;
              }
            }
            l *= 1000L;
            if (l <= 0L) {
              continue;
            }
            localTimer.schedule(local1, l);
            return;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          localThrowable1.printStackTrace();
          long l = 0L;
          continue;
          String str = "0";
          continue;
          str = null;
        }
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FraudTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW =====>");
    }
    a();
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexs
 * JD-Core Version:    0.7.0.1
 */