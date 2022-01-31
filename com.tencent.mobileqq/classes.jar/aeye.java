import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar.1;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar.2;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class aeye
  implements aeyt, View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private aeyv jdField_a_of_type_Aeyv;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  private boolean jdField_a_of_type_Boolean = true;
  public String b;
  
  public aeye(QQAppInterface paramQQAppInterface, aeyv paramaeyv, SessionInfo paramSessionInfo, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aeyv = paramaeyv;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    ThreadManager.post(new LightalkBlueTipsBar.1(this), 5, null, true);
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (aeyf.a() != null) {
      bool = true;
    }
    return bool;
  }
  
  public int a()
  {
    return 45;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightalkBlueTipsBar", 2, "getBarView()");
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558558, null);
      paramVarArgs = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369168);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null)
      {
        paramVarArgs.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
        paramVarArgs = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369171);
        if (this.jdField_a_of_type_JavaLangString == null) {
          break label322;
        }
        if (QLog.isColorLevel()) {
          QLog.d("LightalkBlueTipsBar", 2, "getBarView() mTextWording =" + this.jdField_a_of_type_JavaLangString);
        }
        paramVarArgs.setText(this.jdField_a_of_type_JavaLangString);
        paramVarArgs.setContentDescription(this.jdField_a_of_type_JavaLangString + ajya.a(2131706029));
        paramVarArgs.setOnClickListener(this);
        paramVarArgs = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369170);
        if (AppSetting.d) {
          paramVarArgs.setContentDescription(ajya.a(2131706028));
        }
        paramVarArgs.setOnClickListener(this);
      }
    }
    for (;;)
    {
      for (;;)
      {
        return this.jdField_a_of_type_AndroidViewView;
        File localFile = new File(aeyf.c);
        if ((localFile != null) && (localFile.exists())) {}
        try
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources(), baxi.a(aeyf.c));
          if (QLog.isDevelopLevel()) {
            QLog.i("LightalkBlueTipsBar", 4, "load icon to bitmap ");
          }
          if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) {
            paramVarArgs.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("LightalkBlueTipsBar", 2, "decodeFile Failed!", localThrowable);
            }
            this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130844028));
            localThrowable.printStackTrace();
          }
        }
      }
      return null;
      label322:
      return null;
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    label7:
    do
    {
      do
      {
        do
        {
          String str;
          do
          {
            do
            {
              break label7;
              break label7;
              break label7;
              do
              {
                return;
              } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0);
              if (QLog.isColorLevel()) {
                QLog.d("LightalkBlueTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW");
              }
              paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
            } while (!paramVarArgs.getBoolean("lightalk_tip_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false));
            str = paramVarArgs.getString("Lightalk_tips_frdUin", null);
          } while ((str == null) || (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
          paramInt = paramVarArgs.getInt("LT_tip_show_times" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
          if (QLog.isColorLevel()) {
            QLog.d("LightalkBlueTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW =====> tipsum = " + paramInt);
          }
          if (paramInt < 3) {
            break;
          }
        } while (!(this.jdField_a_of_type_Aeyv.a() instanceof aeye));
        this.jdField_a_of_type_Aeyv.a();
        return;
      } while (!this.jdField_a_of_type_Aeyv.a(this, new Object[0]));
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800510F", "0X800510F", 0, 0, "" + (paramInt + 1), "", "", "");
    } while (!this.jdField_a_of_type_Boolean);
    ThreadManager.getSubThreadHandler().post(new LightalkBlueTipsBar.2(this));
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 12;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Aeyv.a();
      ThreadManager.getSubThreadHandler().post(new LightalkBlueTipsBar.3(this));
      long l;
      do
      {
        return;
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_Long < 200L);
      this.jdField_a_of_type_Long = l;
      paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      paramView.putExtra("hide_more_button", true);
      paramView.putExtra("url", this.b);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005111", "0X8005111", 0, 0, "", "", "", "");
      continue;
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005110", "0X8005110", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeye
 * JD-Core Version:    0.7.0.1
 */