import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.AppletsChatPie.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.AppletsSettingFragment;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import common.config.service.QzoneConfig;
import mqq.os.MqqHandler;

public class aema
  extends BaseChatPie
{
  private View o;
  
  public aema(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private void bo()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
  }
  
  private void bp()
  {
    int i;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "miniappaioshowemptyview", 1) == 1) {
      i = 1;
    }
    for (;;)
    {
      AnyScaleTypeImageView localAnyScaleTypeImageView;
      Object localObject;
      if (i != 0) {
        if (this.o == null)
        {
          this.o = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558527, null);
          if (this.o != null)
          {
            localAnyScaleTypeImageView = (AnyScaleTypeImageView)this.o.findViewById(2131365654);
            if (localAnyScaleTypeImageView != null) {
              localObject = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappaioemptybackgroundurl", "https://qzonestyle.gtimg.cn/aoi/sola/20190329164016_N0Y2CuctLc.png");
            }
          }
        }
      }
      try
      {
        localAnyScaleTypeImageView.setImageURL((String)localObject);
        localObject = (TextView)this.o.findViewById(2131365671);
        if (localObject != null) {
          ((TextView)localObject).setText(QzoneConfig.getInstance().getConfig("qqminiapp", "miniappaioemptytips", "还没收到过小程序通知哦"));
        }
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.o, new ViewGroup.LayoutParams(-1, -1));
        }
        if (this.o != null) {
          this.o.setVisibility(0);
        }
        return;
        i = 0;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("AppletsChatPie", 1, "initEmptyLayout set image error! url: " + (String)localObject, localThrowable);
        }
      }
    }
  }
  
  private void bq()
  {
    if (this.o != null) {
      this.o.setVisibility(8);
    }
  }
  
  public void G()
  {
    super.G();
  }
  
  public void V()
  {
    super.V();
    if ((this.jdField_a_of_type_Acup == null) || (this.jdField_a_of_type_Acup.getCount() < 1))
    {
      bp();
      return;
    }
    bq();
  }
  
  public boolean a(boolean paramBoolean)
  {
    return super.a(paramBoolean);
  }
  
  public void f()
  {
    super.f();
    bo();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
      return;
    }
    PublicFragmentActivity.a(a(), AppletsSettingFragment.class);
  }
  
  public void y()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c == 22))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new AppletsChatPie.1(this));
      return;
    }
    super.y();
  }
  
  public void z()
  {
    super.z();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130840177, 2130840177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aema
 * JD-Core Version:    0.7.0.1
 */