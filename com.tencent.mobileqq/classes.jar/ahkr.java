import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qcircleshadow.local.requests.QCircleChatGetPMBeginShowMsgRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.QCircleChatPie.4;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQCircleIceBreak;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import mqq.os.MqqHandler;

public class ahkr
  extends BaseChatPie
  implements Handler.Callback
{
  private volatile int jdField_a_of_type_Int;
  private amsu jdField_a_of_type_Amsu = new ahku(this);
  private amwl jdField_a_of_type_Amwl = new ahkt(this);
  private MessageForQCircleIceBreak jdField_a_of_type_ComTencentMobileqqDataMessageForQCircleIceBreak;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private MessageForUniteGrayTip jdField_a_of_type_ComTencentMobileqqGraytipMessageForUniteGrayTip;
  private Comparator<MessageRecord> jdField_a_of_type_JavaUtilComparator = new ahks(this);
  private byte[] jdField_a_of_type_ArrayOfByte;
  private MessageRecord jdField_b_of_type_ComTencentMobileqqDataMessageRecord;
  private String jdField_b_of_type_JavaLangString;
  
  public ahkr(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "gotoFriendAio : " + this.sessionInfo.curFriendUin);
    }
    Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(getActivity(), SplashActivity.class), null);
    localIntent.putExtra("uin", this.sessionInfo.curFriendUin);
    localIntent.putExtra("uintype", 0);
    getActivity().startActivity(localIntent);
  }
  
  private void a(String paramString)
  {
    paramString = new QCircleChatGetPMBeginShowMsgRequest(paramString);
    VSNetworkHelper.getInstance().sendRequest(this.mContext, paramString, new ahkv(this));
  }
  
  private boolean a()
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
  
  private void b()
  {
    ThreadManager.getSubThreadHandler().post(new QCircleChatPie.4(this));
  }
  
  private void c()
  {
    if (this.listAdapter != null) {
      this.listAdapter.a = Boolean.valueOf(false);
    }
  }
  
  private void d()
  {
    aull localaull = (aull)getHelper(16);
    if (localaull != null) {
      localaull.b();
    }
  }
  
  public void addBusinessObservers()
  {
    super.addBusinessObservers();
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "addBusinessObservers");
    }
    this.app.addObserver(this.jdField_a_of_type_Amwl);
    this.app.addObserver(this.jdField_a_of_type_Amsu);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    paramBoolean = super.doOnCreate(paramBoolean);
    c();
    b();
    return paramBoolean;
  }
  
  public void doOnCreate_initUI()
  {
    super.doOnCreate_initUI();
    this.listView.setChoiceMode(0);
    QCircleLpReportDc05504.report(this.sessionInfo.curFriendUin, 45, 1, 1);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (((amsw)this.app.getManager(51)).b(this.sessionInfo.curFriendUin)) {
      a();
    }
  }
  
  public boolean enableBlur()
  {
    boolean bool = false;
    if ((this.isThemeDefault) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public List<ChatMessage> getAIOList()
  {
    return getAIOList(this.app, false);
  }
  
  public List<ChatMessage> getAIOList(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = super.getAIOList(paramQQAppInterface, paramBoolean);
    Collections.sort(paramQQAppInterface, this.jdField_a_of_type_JavaUtilComparator);
    return paramQQAppInterface;
  }
  
  public List<ChatMessage> getAIOList(boolean paramBoolean)
  {
    return getAIOList(this.app, paramBoolean);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return super.handleMessage(paramMessage);
  }
  
  public void initTipsTaskList()
  {
    this.mVideoStatusBar = new VideoStatusTipsBar(this.app, this.sessionInfo, this.mTipsMgr, this.mActivity, this.uiHandler);
    this.mTipsMgr.a(this.mVideoStatusBar);
  }
  
  public boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onBackEvent begin");
    }
    if (a()) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onChangeMultiScreen(boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    if (i == 2131367352) {
      QCircleLpReportDc05504.report(this.sessionInfo.curFriendUin, 45, 6, 3);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i != 2131373813) {}
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    super.onPanelChanged(paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onPanelChanged, old:" + paramInt1 + " new:" + paramInt2);
    }
    if (paramInt2 == 1)
    {
      QCircleLpReportDc05504.report(this.sessionInfo.curFriendUin, 45, 5, 2);
      QLog.d(this.tag, 2, "report input click");
    }
  }
  
  public void onPostThemeChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onPostThemeChanged" + this.isThemeDefault);
    }
    updateUI_titleBarForTheme();
  }
  
  public void onPreThemeChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onPreThemeChanged" + this.isThemeDefault);
    }
  }
  
  public void onShowFirst(int paramInt)
  {
    super.onShowFirst(paramInt);
  }
  
  public void removeBusinessObservers()
  {
    super.removeBusinessObservers();
    this.app.removeObserver(this.jdField_a_of_type_Amsu);
    this.app.removeObserver(this.jdField_a_of_type_Amwl);
  }
  
  public void setLeftCheckBoxVisible(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    super.setLeftCheckBoxVisible(paramBoolean1, paramChatMessage, paramBoolean2);
    if (this.listAdapter != null) {
      this.listAdapter.a = Boolean.valueOf(false);
    }
  }
  
  public void setTag()
  {
    this.tag = "QCircleChatPie";
  }
  
  public boolean showorhideAddFriend()
  {
    return false;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      paramObject = (aull)getHelper(16);
      if (paramObject != null)
      {
        if (!paramObservable.isSend()) {
          break label44;
        }
        paramObject.d();
      }
    }
    label44:
    while (paramObservable.time <= paramObject.b) {
      return;
    }
    d();
  }
  
  public void updateSession(Intent paramIntent)
  {
    super.updateSession(paramIntent);
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("qcircle_chat_show_fuel_tips_key");
    this.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("qcirlce_chat_gift_info_bytes_key");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkr
 * JD-Core Version:    0.7.0.1
 */