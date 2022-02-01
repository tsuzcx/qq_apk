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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import mqq.os.MqqHandler;

public class aivm
  implements aiwf, View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private aiwh jdField_a_of_type_Aiwh;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  private boolean jdField_a_of_type_Boolean = true;
  public String b;
  
  public aivm(QQAppInterface paramQQAppInterface, aiwh paramaiwh, SessionInfo paramSessionInfo, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aiwh = paramaiwh;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    ThreadManager.post(new LightalkBlueTipsBar.1(this), 5, null, true);
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (aivn.a() != null) {
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558618, null);
      paramVarArgs = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369910);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null)
      {
        paramVarArgs.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
        paramVarArgs = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369913);
        if (this.jdField_a_of_type_JavaLangString == null) {
          break label322;
        }
        if (QLog.isColorLevel()) {
          QLog.d("LightalkBlueTipsBar", 2, "getBarView() mTextWording =" + this.jdField_a_of_type_JavaLangString);
        }
        paramVarArgs.setText(this.jdField_a_of_type_JavaLangString);
        paramVarArgs.setContentDescription(this.jdField_a_of_type_JavaLangString + anzj.a(2131704931));
        paramVarArgs.setOnClickListener(this);
        paramVarArgs = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369912);
        if (AppSetting.c) {
          paramVarArgs.setContentDescription(anzj.a(2131704930));
        }
        paramVarArgs.setOnClickListener(this);
      }
    }
    for (;;)
    {
      for (;;)
      {
        return this.jdField_a_of_type_AndroidViewView;
        File localFile = new File(aivn.c);
        if ((localFile != null) && (localFile.exists())) {}
        try
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources(), bhgm.a(aivn.c));
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
            this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130844851));
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
        } while (!(this.jdField_a_of_type_Aiwh.a() instanceof aivm));
        this.jdField_a_of_type_Aiwh.a();
        return;
      } while (!this.jdField_a_of_type_Aiwh.a(this, new Object[0]));
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800510F", "0X800510F", 0, 0, "" + (paramInt + 1), "", "", "");
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
      this.jdField_a_of_type_Aiwh.a();
      ThreadManager.getSubThreadHandler().post(new LightalkBlueTipsBar.3(this));
      long l;
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_Long < 200L);
      this.jdField_a_of_type_Long = l;
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("url", this.b);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005111", "0X8005111", 0, 0, "", "", "", "");
      continue;
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005110", "0X8005110", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivm
 * JD-Core Version:    0.7.0.1
 */