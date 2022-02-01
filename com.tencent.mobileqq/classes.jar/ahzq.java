import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.confess.ConfessProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ahzq
  extends BaseChatPie
  implements Handler.Callback
{
  private int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  protected anyz a;
  aqva jdField_a_of_type_Aqva;
  aqvi jdField_a_of_type_Aqvi = new ahzr(this);
  biso jdField_a_of_type_Biso;
  protected ConfessInfo a;
  private ConfessProgressView jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bkyc(ThreadManager.getSubThreadLooper(), this);
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  protected boolean b;
  
  public ahzq(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Anyz = new ahzv(this);
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return 2130844948;
    case 0: 
      return 2130844942;
    case 1: 
      return 2130844943;
    case 2: 
      return 2130844945;
    case 3: 
      return 2130844946;
    case 4: 
      return 2130844947;
    case 6: 
      return 2130844949;
    case 7: 
      return 2130844950;
    case 8: 
      return 2130844951;
    case 9: 
      return 2130844952;
    }
    return 2130844944;
  }
  
  @NonNull
  private List<ChatMessage> a(List<ChatMessage> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if (((ChatMessage)paramList.get(i)).getConfessTopicId() == this.sessionInfo.topicId)
      {
        localArrayList.add(paramList.get(i));
        if ((((ChatMessage)paramList.get(i)).msgtype == 1032) && (QLog.isColorLevel())) {
          QLog.i(this.tag, 2, "ConfessChatPie has illegal msgType!");
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    ConfessConvInfo localConfessConvInfo = this.app.getProxyManager().a().a(this.sessionInfo.curFriendUin, this.sessionInfo.curType, this.sessionInfo.topicId);
    if (localConfessConvInfo != null)
    {
      if ((localConfessConvInfo.holmesTolCount == 0) || (localConfessConvInfo.holmesCurCount != localConfessConvInfo.holmesTolCount)) {
        break label213;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844956);
    }
    for (int i = 0;; i = 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView.a(localConfessConvInfo.holmesCurCount, localConfessConvInfo.holmesTolCount);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(String.format(anvx.a(2131701895), new Object[] { Integer.valueOf(localConfessConvInfo.holmesTolCount), Integer.valueOf(localConfessConvInfo.holmesCurCount) }));
      if ((paramBoolean) && (localConfessConvInfo.holmesCurCount > this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null))
      {
        if ((i != 0) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        }
        if (this.jdField_b_of_type_AndroidViewView != null) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        }
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      }
      this.jdField_a_of_type_Int = localConfessConvInfo.holmesCurCount;
      c();
      return;
      label213:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844955);
    }
  }
  
  private void b()
  {
    long l1;
    if (aquz.a(this.app))
    {
      a(false);
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(this.sessionInfo.curFriendUin);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label30:
      break label30;
    }
    if (this.sessionInfo.curType == 1033)
    {
      this.jdField_a_of_type_Aqva.a(this.app.getLongAccountUin(), l1, this.sessionInfo.topicId, this.sessionInfo.curType, true);
      return;
    }
    this.jdField_a_of_type_Aqva.a(l1, this.app.getLongAccountUin(), this.sessionInfo.topicId, this.sessionInfo.curType, false);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.sessionInfo.curType == 1034))
    {
      String str = aqvh.a(this.sessionInfo.curFriendUin, this.sessionInfo.curType, this.sessionInfo.topicId);
      if (aquz.c(this.app, str)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void d()
  {
    if (this.sessionInfo.curType == 1033)
    {
      this.mCustomTitleView.setBackgroundResource(2130843707);
      this.afRoot.setBackgroundResource(2130843707);
      this.mInputBar.getBackground().setVisible(true, false);
      this.mInputBar.findViewById(2131377820).setVisibility(8);
    }
    for (;;)
    {
      try
      {
        AIOUtils.setViewDrawalbe(this.mInputBar, 2130843713);
        if (this.input != null)
        {
          AIOUtils.setViewDrawalbe(this.input, 2130843726);
          this.input.setTextColor(-16777216);
        }
        this.mTitleText.setTextColor(nty.c);
        this.mTitleCount.setTextColor(this.mActivity.getResources().getColor(2131167023));
        if (this.mTitleBtnLeft.getVisibility() == 0)
        {
          this.mTitleBtnLeft.setBackgroundResource(2130843733);
          this.mTitleBtnLeft.setTextColor(nty.c);
          this.mTitleLayout.setOnClickListener(null);
          this.mSubTitleLayout.setOnClickListener(null);
          AIOUtils.setViewDrawable(this.mTitleBtnRight, null);
          if (this.panelicons != null)
          {
            this.panelicons.setBackgroundColor(-16777216);
            if (this.root.a() == 8) {
              this.panelicons.setSelected(8);
            }
            this.panelicons.a(this.app);
          }
          if (this.mEmoPanel != null) {
            this.mEmoPanel.switchToAnonymous(true);
          }
          this.mTitleBtnRight.setVisibility(4);
          this.mSingleTitle = false;
          setSubTitleVisable(true);
          this.mSubTilteText.setText(anvx.a(2131701885) + this.jdField_b_of_type_JavaLangString);
          this.mSubTilteText.setTextColor(-855638017);
          this.mTitleText.setTextColor(-855638017);
          Object localObject1 = new View(this.mActivity);
          ((View)localObject1).setBackgroundColor(-2013265920);
          Object localObject2 = new RelativeLayout.LayoutParams(-1, 2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
          this.mCustomTitleView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          localObject1 = anvx.a(2131701886);
          if (this.jdField_b_of_type_Boolean) {
            localObject1 = anvx.a(2131701887);
          }
          this.mTitleBtnLeft.setText((CharSequence)localObject1);
          this.mCustomTitleView.findViewById(2131370044).setVisibility(8);
          this.mTitleBtnLeft.setTextSize(16.0F);
          this.mCustomTitleView.setLeftContentDescription((String)localObject1);
          localObject1 = new ConfessNewsBgView(this.mContext);
          ((ConfessNewsBgView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          this.mContent.addView((View)localObject1, 0);
          if (this.sessionInfo.curType != 1033) {
            break label933;
          }
          i = 858006566;
          ((ConfessNewsBgView)localObject1).setBgColor(i);
          ((ConfessNewsBgView)localObject1).setSize(2);
          if (aquz.a(this.app))
          {
            localObject1 = View.inflate(this.mContext, 2131561068, null);
            this.afRoot.addView((View)localObject1, new ViewGroup.LayoutParams(-1, -1));
            localObject2 = ((View)localObject1).findViewById(2131381343);
            this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131368252));
            this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
            this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView = ((ConfessProgressView)((View)localObject1).findViewById(2131365054));
            float f = this.mContext.getResources().getDisplayMetrics().density;
            this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView.setSize(24.0F * f, 27.0F * f, -0.15F * f, -0.5F * f);
            this.jdField_a_of_type_AndroidViewView = ((View)localObject1).findViewById(2131368244);
            this.jdField_a_of_type_AndroidViewView.setVisibility(8);
            this.jdField_b_of_type_AndroidViewView = ((View)localObject1).findViewById(2131368242);
            if (this.sessionInfo.curType == 1033)
            {
              localObject1 = (ViewGroup.MarginLayoutParams)((View)localObject2).getLayoutParams();
              ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = ((int)(9.0F * f));
              ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
            this.jdField_b_of_type_AndroidViewView.setVisibility(4);
            e();
            if (!aquz.b(this.app, "holmes_guide"))
            {
              aquz.a(this.app, "holmes_guide", true);
              if (this.sessionInfo.curType != 1033) {
                break label940;
              }
              localObject1 = View.inflate(this.mContext, 2131561067, null);
              ((View)localObject1).findViewById(2131368247).setOnClickListener(this);
              ((View)localObject1).setOnClickListener(this);
              this.afRoot.getViewTreeObserver().addOnGlobalLayoutListener(new ahzs(this, (View)localObject1, (View)localObject2));
            }
            if ((this.isJubaoMode) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
            }
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.i(this.tag, 1, "handleConfessUI error: " + localThrowable.getMessage());
        continue;
        if (this.mDefaultLeftBack.getVisibility() != 0) {
          continue;
        }
        this.mDefaultLeftBack.setBackgroundResource(2130850725);
        this.mDefaultLeftBack.setPadding(0, 0, 0, 0);
        this.mDefautlBtnLeft.setTextColor(nty.c);
        this.mDefautlBtnLeft.setBackgroundResource(2130838022);
        continue;
      }
      this.mTitleText.setText(this.jdField_b_of_type_JavaLangString);
      this.mTitleBtnCall.setVisibility(4);
      this.mTitleBtnRight.setImageResource(2130845565);
      this.mTitleBtnRight.setBackgroundColor(0);
      continue;
      label933:
      int i = 268234225;
      continue;
      label940:
      View localView = View.inflate(this.mContext, 2131561066, null);
    }
  }
  
  private void e()
  {
    ThreadManager.excute(new ConfessChatPie.3(this), 16, null, true);
  }
  
  private void f()
  {
    Object localObject = getActivity();
    if ((localObject == null) || (this.app == null)) {
      return;
    }
    localObject = (bkzi)bkzz.a((Context)localObject, null);
    ((bkzi)localObject).a(2131689987, 5);
    ((bkzi)localObject).a(2131690717, 5);
    ((bkzi)localObject).c(2131690697);
    ((bkzi)localObject).a(new ahzw(this, (bkzi)localObject));
    ((bkzi)localObject).show();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Biso != null)
    {
      this.jdField_a_of_type_Biso.b();
      this.jdField_a_of_type_Biso = null;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_Biso == null) {
      this.jdField_a_of_type_Biso = new biso(this.mActivity);
    }
    this.jdField_a_of_type_Biso.a(paramInt1, paramString, paramInt2);
  }
  
  public void addBusinessObservers()
  {
    super.addBusinessObservers();
    this.app.addObserver(this.jdField_a_of_type_Anyz);
  }
  
  public void adjustTitleDimension() {}
  
  public void clickSendTextButton()
  {
    if (this.input.getText().length() == 0) {
      return;
    }
    String str = this.input.getText().toString();
    if ((str != null) && (str.length() > MAX_SOURCE_MSG_TEXT_LENGTH))
    {
      ChatActivityUtils.a(this.mContext, 2131718520, 1);
      return;
    }
    admo localadmo = new admo();
    setSendTextMsgParams(localadmo);
    localadmo.i = this.isSendToRobotServer;
    this.isSendToRobotServer = false;
    admh.a(this.app, this.mContext, this.sessionInfo, str, null, localadmo);
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
    }
    clearInput();
    this.mTipsMgr.a(1002, new Object[] { str });
  }
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    paramBoolean = super.doOnCreate(paramBoolean);
    d();
    this.app.addObserver(this.jdField_a_of_type_Aqvi);
    this.jdField_a_of_type_Aqva = ((aqva)this.app.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER));
    b();
    return paramBoolean;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Aqvi);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    a();
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
  }
  
  public void doOnResume_updateUI()
  {
    super.doOnResume_updateUI();
    if (this.sessionInfo.curType == 1033) {
      setSystemBarColor(-16777216, false);
    }
  }
  
  public List<ChatMessage> getAIOList()
  {
    return a(getAIOList(this.app, false));
  }
  
  public List<ChatMessage> getAIOList(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return a(paramQQAppInterface.getMessageFacade().getAIOList(this.sessionInfo.curFriendUin, this.sessionInfo.curType, -1L, this.sessionInfo.topicId, paramBoolean));
  }
  
  public List<ChatMessage> getAIOList(boolean paramBoolean)
  {
    return a(getAIOList(this.app, paramBoolean));
  }
  
  public void getAndParseAIOList()
  {
    ThreadManager.post(new ConfessChatPie.4(this), 8, null, true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 60) && (this.sessionInfo.curType == 1033))
    {
      this.afRoot.setBackgroundResource(2130843707);
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  public int initHaveUnRead()
  {
    int i = this.app.getConversationFacade().a(this.sessionInfo.curFriendUin, this.sessionInfo.curType, this.sessionInfo.topicId);
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "initHaveUnRead count " + i);
    }
    return i;
  }
  
  public void initTipsTaskList() {}
  
  public void messageTips(QQMessageFacade.Message paramMessage) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    int i = paramView.getId();
    if ((i == 2131369245) && (this.sessionInfo != null) && (this.sessionInfo.curType == 1034)) {
      f();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131368247)
      {
        if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
        {
          this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
          this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
        }
      }
      else if (i != 2131368249)
      {
        if (i == 2131368252)
        {
          int j = 2;
          i = j;
          String str1;
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            i = j;
            if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
            {
              this.jdField_a_of_type_AndroidViewView.setVisibility(8);
              str1 = aqvh.a(this.sessionInfo.curFriendUin, this.sessionInfo.curType, this.sessionInfo.topicId);
              aquz.b(this.app, str1, false);
              i = 1;
            }
          }
          String str2;
          label192:
          QQAppInterface localQQAppInterface;
          Context localContext;
          if (this.sessionInfo.curType == 1033)
          {
            str1 = this.app.getAccount();
            str2 = this.sessionInfo.curFriendUin;
            localQQAppInterface = this.app;
            localContext = this.mContext;
            j = this.sessionInfo.topicId;
            if (this.sessionInfo.curType != 1033) {
              break label358;
            }
          }
          for (;;)
          {
            aquz.a(localQQAppInterface, localContext, str1, str2, j, bool);
            bdla.b(this.app, "dc00898", "", "", "0X8009573", "0X8009573", i, 0, this.sessionInfo.topicId + "", "", str1 + "", str2 + "");
            break;
            str1 = this.sessionInfo.curFriendUin;
            str2 = this.app.getAccount();
            break label192;
            label358:
            bool = false;
          }
        }
        super.onClick(paramView);
      }
    }
  }
  
  public void onPostThemeChanged()
  {
    Object localObject = ((FragmentActivity)getActivity()).getSupportFragmentManager();
    ((FragmentManager)localObject).beginTransaction();
    localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null)
    {
      localObject = (ChatFragment)localObject;
      if (((ChatFragment)localObject).a != null) {
        ((ChatFragment)localObject).a.setStatusBarColor(1226741);
      }
    }
  }
  
  public void openOptionActivity() {}
  
  public int recorderSetTimeout()
  {
    int i = ahdc.a(this.app, "Normal_MaxPtt") * 1000 - 200;
    this.uiHandler.sendEmptyMessageDelayed(16711687, i);
    return i + 200;
  }
  
  public void removeBusinessObservers()
  {
    super.removeBusinessObservers();
    this.app.removeObserver(this.jdField_a_of_type_Anyz);
  }
  
  public void setReaded()
  {
    setReaded(this.app);
  }
  
  public void setReaded(QQAppInterface paramQQAppInterface)
  {
    aqvh.a(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.curType, this.sessionInfo.topicId, true, true);
  }
  
  public void setTag()
  {
    this.tag = "ConfessChatPie";
  }
  
  public void setTextDraft(DraftTextInfo paramDraftTextInfo) {}
  
  public boolean showorhideAddFriend()
  {
    return false;
  }
  
  public void updateSession(Intent paramIntent)
  {
    super.updateSession(paramIntent);
    String str1 = paramIntent.getStringExtra("key_confessor_nick");
    int i = paramIntent.getIntExtra("key_confessor_sex", 0);
    String str2 = paramIntent.getStringExtra("key_confess_desc");
    long l = paramIntent.getLongExtra("key_confess_time", 0L);
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("open_chat_from_rec_confess", false);
    this.jdField_b_of_type_JavaLangString = str1;
    paramIntent = (aqvd)this.app.getManager(QQManagerFactory.CONFESS_MANAGER);
    if (((this.mActivity instanceof ChatActivity)) && (TextUtils.isEmpty(this.sessionInfo.curFriendUin)))
    {
      QLog.d("ConfessChatPie", 1, "friend uin is null ,uintype = " + this.sessionInfo.curType);
      this.mActivity.finish();
      return;
    }
    this.sessionInfo.uinName = this.jdField_b_of_type_JavaLangString;
    if (!this.isJubaoMode)
    {
      aquy localaquy = paramIntent.a();
      String str3 = this.sessionInfo.curFriendUin;
      int j = this.sessionInfo.curType;
      int k = this.sessionInfo.topicId;
      if (this.sessionInfo.curType == 1033)
      {
        paramIntent = this.app.getCurrentAccountUin();
        label209:
        this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo = localaquy.a(str3, j, k, paramIntent, str1, i, str2, l);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.tag, 2, String.format("updateSession saveConfessItem frdUin:%s type:%s topicId:%d confessorNick:%s confessorSex:%d", new Object[] { this.sessionInfo.curFriendUin, Integer.valueOf(this.sessionInfo.curType), Integer.valueOf(this.sessionInfo.topicId), str1, Integer.valueOf(i) }));
      }
      if (this.refreshMessageContext.topicId <= 0) {
        break;
      }
      this.refreshMessageContext.msgRefresher = new acmv(this.app.getMessageFacade().getC2CMessageManager());
      return;
      paramIntent = this.sessionInfo.curFriendUin;
      break label209;
      paramIntent = new ConfessInfo();
      paramIntent.reset();
      paramIntent.topicId = this.sessionInfo.topicId;
      paramIntent.confessorNick = str1;
    }
  }
  
  public void updateUI_titleBarForTheme()
  {
    if ((this.sessionInfo == null) || (this.mContext == null) || (this.mCustomTitleView == null)) {}
    do
    {
      do
      {
        return;
      } while (ThemeUtil.isDefaultOrDIYTheme(false));
      if (this.sessionInfo.curType != 1033)
      {
        Object localObject = ((FragmentActivity)getActivity()).getSupportFragmentManager();
        ((FragmentManager)localObject).beginTransaction();
        localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
        if (localObject != null)
        {
          localObject = (ChatFragment)localObject;
          if (((ChatFragment)localObject).a != null) {
            ((ChatFragment)localObject).a.setStatusBarDrawable(getActivity().getResources().getDrawable(2130846157));
          }
        }
        this.mTitleCount.setTextColor(-1);
        this.mTitleText.setTextColor(-1);
        this.mSubTilteText.setTextColor(-1);
        this.mTitleBtnLeft.setTextColor(-1);
        this.mTitleBtnLeft.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850123));
        this.mAIORootView.findViewById(2131370044).setVisibility(8);
        this.mCustomTitleView.setIsDefaultTheme(false);
        this.mCustomTitleView.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850109));
        this.afRoot.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850046));
        AIOUtils.setViewDrawable(this.mInputBar, SkinEngine.getInstances().getDefaultThemeDrawable(2130849852));
        AIOUtils.setViewDrawable(this.input, SkinEngine.getInstances().getDefaultThemeDrawable(2130849853));
        if (this.input != null) {
          this.input.setTextColor(-16777216);
        }
        localObject = SkinEngine.getInstances().getDefaultThemeDrawable(2130850001);
        Drawable localDrawable1 = SkinEngine.getInstances().getDefaultThemeDrawable(2130849998);
        Drawable localDrawable2 = SkinEngine.getInstances().getDefaultThemeDrawable(2130850002);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { -16842910 }, localDrawable1);
        localStateListDrawable.addState(new int[] { 16842919 }, localDrawable2);
        localStateListDrawable.addState(new int[0], (Drawable)localObject);
        if (this.mFunBtn != null)
        {
          this.mFunBtn.setBackgroundDrawable(localStateListDrawable);
          this.mFunBtn.setTextColor(-1);
        }
        this.panelicons.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130849902));
        return;
      }
      AIOUtils.setViewDrawalbe(this.input, 2130843726);
    } while (this.input == null);
    this.input.setTextColor(-16777216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzq
 * JD-Core Version:    0.7.0.1
 */