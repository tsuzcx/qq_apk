import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.AppletsChatPie.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.AppletsSettingFragment;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import common.config.service.QzoneConfig;
import mqq.os.MqqHandler;

public class ahyi
  extends BaseChatPie
{
  private View a;
  
  public ahyi(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private void a()
  {
    this.input.setVisibility(8);
    this.mInputBar.setVisibility(8);
    this.mIconLayoutInInputRight.setVisibility(8);
    this.mTipRoot.setVisibility(8);
    this.panelicons.setVisibility(8);
  }
  
  private void b()
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
        if (this.a == null)
        {
          this.a = LayoutInflater.from(this.mContext).inflate(2131558598, null);
          if (this.a != null)
          {
            localAnyScaleTypeImageView = (AnyScaleTypeImageView)this.a.findViewById(2131366159);
            if (localAnyScaleTypeImageView != null) {
              localObject = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappaioemptybackgroundurl", "https://qzonestyle.gtimg.cn/aoi/sola/20190329164016_N0Y2CuctLc.png");
            }
          }
        }
      }
      try
      {
        localAnyScaleTypeImageView.setImageURL((String)localObject);
        localObject = (TextView)this.a.findViewById(2131366175);
        if (localObject != null) {
          ((TextView)localObject).setText(QzoneConfig.getInstance().getConfig("qqminiapp", "miniappaioemptytips", "还没收到过小程序通知哦"));
        }
        if (this.mContent != null) {
          this.mContent.addView(this.a, new ViewGroup.LayoutParams(-1, -1));
        }
        if (this.a != null) {
          this.a.setVisibility(0);
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
  
  private void c()
  {
    if (this.a != null) {
      this.a.setVisibility(8);
    }
  }
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    return super.doOnCreate(paramBoolean);
  }
  
  public void doOnCreate_initUI()
  {
    super.doOnCreate_initUI();
    a();
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      PublicFragmentActivity.a(getActivity(), AppletsSettingFragment.class);
    }
  }
  
  public void refreshListAdapter()
  {
    super.refreshListAdapter();
    if ((this.listAdapter == null) || (this.listAdapter.getCount() < 1))
    {
      b();
      return;
    }
    c();
  }
  
  public void updateSession_updateTitleRightView()
  {
    super.updateSession_updateTitleRightView();
    this.mCustomTitleView.setRight1Icon(2130840546, 2130840546);
  }
  
  public void updateUnreadNumOnTitleBar()
  {
    if ((this.sessionInfo != null) && (this.sessionInfo.entrance == 22))
    {
      this.uiHandler.post(new AppletsChatPie.1(this));
      return;
    }
    super.updateUnreadNumOnTitleBar();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyi
 * JD-Core Version:    0.7.0.1
 */