import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.robotchat.RobotChatPanelLayout;
import com.tencent.mobileqq.robotchat.RobotChatTipLayout;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

public class aifq
  extends agab
  implements Handler.Callback, bbwz
{
  public RobotChatPanelLayout a;
  private RobotChatTipLayout a;
  private View b;
  
  public aifq(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private boolean b()
  {
    boolean bool1 = false;
    int j = 0;
    if (this.root.a() != 0)
    {
      int i = j;
      if (this.root.a() == 2)
      {
        i = j;
        if (this.mAudioPanel != null)
        {
          i = j;
          if (this.mAudioPanel.a()) {
            i = 1;
          }
        }
      }
      if (i == 0) {
        this.root.a(true);
      }
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (this.mAIOGiftPanelContainer != null)
    {
      bool2 = bool1;
      if (this.mAIOGiftPanelContainer.a())
      {
        this.mAIOGiftPanelContainer.a();
        bool2 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "checkConsumeBackEvent, comsumed:" + bool2);
    }
    return bool2;
  }
  
  private void c()
  {
    if (bhhr.b(this.mContext, this.app.getCurrentUin(), this.sessionInfo.curFriendUin)) {}
    while (!(this.mTipRoot instanceof ViewGroup)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout = new RobotChatTipLayout(this.mContext);
    this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.a(this);
    ((ViewGroup)this.mTipRoot).addView(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout, 0);
  }
  
  private void d()
  {
    Object localObject = (ViewGroup)this.mTitleText.getParent();
    this.mCustomTitleView.a();
    localObject = (ImageView)this.mAIORootView.findViewById(2131379049);
    if (localObject != null)
    {
      ((ImageView)localObject).setImageDrawable(bbxa.a(this.mContext));
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = (agld)this.helperProvider.a(23);
    if (localObject != null) {
      ((agld)localObject).a();
    }
    if (this.mArkController != null)
    {
      this.mArkController.b();
      this.mArkController = null;
    }
  }
  
  public String a()
  {
    if (this.sessionInfo != null)
    {
      if (!TextUtils.isEmpty(this.sessionInfo.curFriendNick)) {
        return this.sessionInfo.curFriendNick;
      }
      return this.sessionInfo.curFriendUin;
    }
    return null;
  }
  
  public void a(RobotChatTipLayout paramRobotChatTipLayout)
  {
    bhhr.c(this.mContext, this.app.getCurrentUin(), this.sessionInfo.curFriendUin, true);
    if ((this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout != null) && (this.mTipRoot != null) && ((this.mTipRoot instanceof ViewGroup)))
    {
      ((ViewGroup)this.mTipRoot).removeView(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout);
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.a();
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout = null;
    }
    bdla.b(this.app, "dc00898", "", "", "0X800A486", "0X800A486", 0, 0, "", "", "", "");
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void adjustInputLayout(int paramInt)
  {
    super.adjustInputLayout(paramInt);
    agjy localagjy = (agjy)getHelper(36);
    if ((localagjy != null) && (localagjy.b())) {
      localagjy.d();
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      super.afterTextChanged(paramEditable);
      if (this.mInputStat == 0)
      {
        paramEditable = (agjy)getHelper(36);
        if ((paramEditable != null) && (paramEditable.b())) {
          paramEditable.a(bool);
        }
      }
      return;
    }
  }
  
  public ager createChatDrawer()
  {
    return null;
  }
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    return super.doOnCreate(paramBoolean);
  }
  
  public void doOnCreate_initUI()
  {
    super.doOnCreate_initUI();
    d();
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "doOnDestroy:");
    }
    agld localagld = (agld)this.helperProvider.a(23);
    if (localagld != null) {
      localagld.b();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout != null) && (this.mTipRoot != null))
    {
      ((ViewGroup)this.mTipRoot).removeView(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout);
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.a();
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout = null;
    }
    if ((this.b != null) && (this.b.getParent() != null))
    {
      ((ViewGroup)this.b.getParent()).removeView(this.b);
      this.b = null;
    }
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    agjy localagjy = (agjy)getHelper(36);
    if ((localagjy != null) && (localagjy.b())) {
      localagjy.a(getStatusTxtDartElseLight());
    }
  }
  
  public void doOnResume_updateUI()
  {
    super.doOnResume_updateUI();
    agjy localagjy = (agjy)getHelper(36);
    if ((localagjy != null) && (localagjy.b())) {
      localagjy.a(this.mTitleBtnLeft);
    }
  }
  
  public void doPanelChanged(int paramInt1, int paramInt2)
  {
    super.doPanelChanged(paramInt1, paramInt2);
    agjy localagjy = (agjy)getHelper(36);
    if ((localagjy != null) && (localagjy.b())) {
      localagjy.a(paramInt1, paramInt2);
    }
  }
  
  public boolean enableFullScreenInput()
  {
    return false;
  }
  
  public void initHelper()
  {
    super.initHelper();
    this.helperProvider.a(this);
  }
  
  public void leftBackEvent(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "leftBackEvent begin:" + paramBoolean);
    }
    if (paramBoolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "no confirm dialog");
    }
    super.leftBackEvent(paramBoolean);
  }
  
  public boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onBackEvent begin");
    }
    if (b()) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "no confirm dialog");
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      agjy localagjy = (agjy)getHelper(36);
      if ((localagjy != null) && (localagjy.b())) {
        if (this.input.getText().length() <= 0)
        {
          localagjy.b(false);
          bdla.b(this.app, "dc00898", "", "", "0X800A487", "0X800A487", 0, 0, "", "", "", "");
        }
        else
        {
          localagjy.b(true);
        }
      }
    }
  }
  
  public void onDoubleTap(MotionEvent paramMotionEvent)
  {
    agld localagld = (agld)this.helperProvider.a(23);
    if ((localagld != null) && (localagld.a(paramMotionEvent, this.isJubaoMode))) {
      return;
    }
    super.onDoubleTap(paramMotionEvent);
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    agjy localagjy = (agjy)getHelper(36);
    if ((localagjy != null) && (localagjy.b())) {
      localagjy.a(getStatusTxtDartElseLight());
    }
  }
  
  public void onShow_otherThings()
  {
    super.onShow_otherThings();
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onShow_otherThings:");
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, " onTextChanged:  start=" + paramInt1 + " before=" + paramInt2 + " count=" + paramInt3);
    }
    paramCharSequence = (agld)getHelper(23);
    if (paramCharSequence != null) {
      paramCharSequence.b(this.input.getLineCount());
    }
  }
  
  public void openOptionActivity()
  {
    bghs.a(this.mContext, null, this.sessionInfo.curFriendUin);
    bdla.b(null, "dc00898", "", "", "0X800A48B", "0X800A48B", 0, 0, "", "", "", "");
  }
  
  public void setTag()
  {
    this.tag = "RobotChatPie";
  }
  
  public void showZhituIcon() {}
  
  public void updateFriendNick()
  {
    super.updateFriendNick();
    if (this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.setRobotName(a());
    }
  }
  
  public void updateListUnRead(int paramInt)
  {
    super.updateListUnRead(paramInt);
    agld localagld = (agld)this.helperProvider.a(23);
    if (localagld != null) {
      localagld.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout, this.mContent);
    }
  }
  
  public void updateSession(Intent paramIntent)
  {
    super.updateSession(paramIntent);
    paramIntent = paramIntent.getBundleExtra("key_invoke_troop_robot_function");
    agld localagld = (agld)this.helperProvider.a(23);
    if (localagld != null) {
      localagld.a(paramIntent);
    }
  }
  
  public void updateSession_checkUpdateFooterView() {}
  
  public void updateSession_updateTitle(Intent paramIntent)
  {
    super.updateSession_updateTitle(paramIntent);
    this.mTitleText.setOnClickListener(new aifs(this));
  }
  
  public void updateSession_updateTitleBtnCall()
  {
    if (this.mTitleBtnCall != null)
    {
      this.mTitleBtnCall.setVisibility(4);
      ThreadManager.post(new RobotChatPie.3(this), 5, null, false);
    }
  }
  
  public void updateSession_updateUI(Intent paramIntent)
  {
    super.updateSession_updateUI(paramIntent);
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.setRobotName(a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout.a(this.sessionInfo.curFriendUin, a(), this, new aifr(this));
    }
  }
  
  public void updateSpeakerPhoneLayout(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.speakerPhoneLayout != null) {
      super.updateSpeakerPhoneLayout(paramBoolean1, paramBoolean2);
    }
    agld localagld;
    do
    {
      return;
      super.updateSpeakerPhoneLayout(paramBoolean1, paramBoolean2);
      localagld = (agld)this.helperProvider.a(23);
    } while (localagld == null);
    localagld.a(this.speakerPhoneLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifq
 * JD-Core Version:    0.7.0.1
 */