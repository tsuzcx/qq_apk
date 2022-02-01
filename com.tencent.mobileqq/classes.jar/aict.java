import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.QQLiveImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.2;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.4;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.5;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.6;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.7;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.9;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class aict
  extends BaseChatPie
{
  private final int jdField_a_of_type_Int = 300;
  public long a;
  private afqz jdField_a_of_type_Afqz;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anrc jdField_a_of_type_Anrc = new aicv(this);
  anvi jdField_a_of_type_Anvi = new aicx(this);
  aofu jdField_a_of_type_Aofu = new aicy(this);
  private atfq jdField_a_of_type_Atfq = new aicw(this);
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  private MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  public Runnable a;
  private List<ChatMessage> jdField_a_of_type_JavaUtilList;
  public MqqHandler a;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private Runnable jdField_b_of_type_JavaLangRunnable = new MultiForwardChatPie.4(this);
  String jdField_b_of_type_JavaLangString;
  public boolean b;
  private int c;
  public String c;
  
  public aict(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_MqqOsMqqHandler = new aicu(this);
  }
  
  private void a(int paramInt)
  {
    alvw localalvw = (alvw)getHelper(4);
    if (localalvw != null) {
      localalvw.a(paramInt);
    }
  }
  
  private void a(long paramLong)
  {
    ThreadManagerV2.post(new MultiForwardChatPie.9(this, paramLong), 8, null, true);
  }
  
  private void a(View paramView)
  {
    paramView = bkzi.c(paramView.getContext());
    paramView.b(2131693153);
    paramView.c(2131690697);
    paramView.a(new aida(this, paramView));
    paramView.show();
  }
  
  private void a(View paramView, int paramInt, bkzi parambkzi)
  {
    if (paramView == null)
    {
      parambkzi.dismiss();
      return;
    }
    String str = parambkzi.a(paramInt);
    if (str == null)
    {
      parambkzi.dismiss();
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      parambkzi.dismiss();
      return;
    }
    if (str.equals(paramView.getResources().getString(2131693153)))
    {
      axiv.a("0X8009AB5");
      a(this.jdField_a_of_type_Long);
    }
    parambkzi.dismiss();
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    this.uiHandler.removeMessages(24);
    if ((this.mProgressDialog == null) || (!this.mProgressDialog.isShowing())) {}
    do
    {
      return;
      if ((paramBoolean) && (paramObject != null) && (axio.a().jdField_a_of_type_Int == 6))
      {
        this.mProgressDialog.dismiss();
        axio.a().b.clear();
        axio.a().b.putAll((Map)paramObject);
        ((agit)this.helperProvider.a(11)).a((Map)paramObject, axio.a().jdField_a_of_type_JavaUtilArrayList, axio.a().jdField_a_of_type_Int);
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("MultiMsg_TAG", 4, "handleMultiFavorite = " + paramObject);
  }
  
  private void b()
  {
    this.uiHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    ahpf localahpf = (ahpf)getHelper(49);
    if (localahpf != null) {
      localahpf.a(8);
    }
  }
  
  public azjj a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new aidc(this, this.jdField_a_of_type_Long);
    case 1: 
      return new aidc(this, this.jdField_a_of_type_Long);
    }
    return new aidb(this);
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  }
  
  public void a()
  {
    Object localObject2 = axio.a().a(this.app, this.jdField_a_of_type_Long);
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      Object localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((ChatMessage)((Iterator)localObject2).next());
      }
      a((List)localObject1);
      localObject1 = ChatActivityUtils.a(this.jdField_a_of_type_JavaUtilList, this.sessionInfo, this.app);
      localObject1 = ChatActivityUtils.a(this.app, BaseApplicationImpl.getContext(), this.sessionInfo, (MessageRecord)localObject1, -1L);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
      }
      axio.a().a(this.app, this.jdField_a_of_type_JavaUtilList, true);
      this.mActivity.runOnUiThread(new MultiForwardChatPie.6(this, (CharSequence)localObject1));
      return;
    }
    this.mActivity.runOnUiThread(new MultiForwardChatPie.7(this));
  }
  
  public void a(List<ChatMessage> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.mActivity.getResources().getDrawable(2130839470);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.mTitleText.getCompoundDrawables();
      this.jdField_c_of_type_Int = this.mTitleText.getCompoundDrawablePadding();
      this.mTitleText.setCompoundDrawablePadding(10);
      this.mTitleText.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      return true;
    }
    return false;
  }
  
  public void addBusinessObservers()
  {
    this.app.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_Atfq);
    this.app.addObserver(this.jdField_a_of_type_Anrc);
    this.app.addObserver(this.jdField_a_of_type_Anvi);
    this.app.addObserver(this.jdField_a_of_type_Aofu);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.mTitleText.setCompoundDrawablePadding(this.jdField_c_of_type_Int);
      this.mTitleText.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 21) && (paramInt2 == -1) && (paramIntent != null)) {
      super.startChatAndSendMsg(paramIntent.getExtras());
    }
    if ((paramInt1 == 24) && (paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent.putExtra("selfSet_leftViewText", this.app.getApplication().getString(2131719161));
      startChatAndSendMsg(paramIntent.getExtras());
    }
    if ((paramInt1 == 24) && (paramIntent != null) && (paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false))) {
      setLeftCheckBoxVisible(false, null, false);
    }
  }
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    this.isFromOnCreate = true;
    this.jdField_b_of_type_Boolean = BaseChatItemLayout.a;
    BaseChatItemLayout.a = false;
    this.isThemeDefault = ThemeUtil.isDefaultOrDIYTheme(false);
    this.mCurrentAIOState = 2;
    Object localObject1 = (ViewGroup)this.mAIORootView.findViewById(2131362299);
    ((ViewGroup)localObject1).removeView(this.mAIORootView.findViewById(2131376947));
    Object localObject2 = View.inflate(this.mActivity, 2131558640, null);
    ((View)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject1).addView((View)localObject2, 0);
    this.jdField_b_of_type_Int = this.mActivity.getIntent().getIntExtra("callback_type", 1);
    this.jdField_b_of_type_JavaLangString = this.mActivity.getIntent().getStringExtra("multi_url");
    this.jdField_a_of_type_Long = this.mActivity.getIntent().getLongExtra("multimsg_uniseq", 0L);
    this.jdField_c_of_type_JavaLangString = this.mActivity.getIntent().getStringExtra("multi_title");
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_c_of_type_JavaLangString = anvx.a(2131706474);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg_TAG.Nest", 4, "MultiForwardActivity.doOnCreate ResID = " + this.jdField_b_of_type_JavaLangString + "  msg.uniseq = " + this.jdField_a_of_type_Long + " downCallBackType" + this.jdField_b_of_type_Int);
    }
    this.mCustomTitleView = ((NavBarAIO)this.mAIORootView.findViewById(2131376760));
    this.titleBgView = ((ImageView)this.mAIORootView.findViewById(2131376761));
    this.mTitleBtnLeft = ((TextView)this.mAIORootView.findViewById(2131369231));
    this.mTitleBtnRight = ((ImageView)this.mAIORootView.findViewById(2131369245));
    this.mTitleBtnCall = ((ImageView)this.mAIORootView.findViewById(2131369240));
    this.mDefaultLeftBack = ((ImageView)this.mAIORootView.findViewById(2131369605));
    this.mDensity = this.app.getApplication().getResources().getDisplayMetrics().density;
    AIOUtils.expandViewTouchDelegate(this.mDefaultLeftBack, 0, 0, 0, (int)(50.0F * this.mDensity + 0.5F));
    this.mDefautlBtnLeft = ((TextView)this.mAIORootView.findViewById(2131379722));
    this.mTitleLayout = ((ViewGroup)this.mAIORootView.findViewById(2131379056));
    localObject2 = this.mTitleLayout.getLayoutParams();
    int i;
    if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      i = AIOUtils.dp2px(64.0F, this.mTitleLayout.getResources());
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = i;
      ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i;
    }
    this.mTitleBtnLeft.setOnClickListener(this);
    this.mDefaultLeftBack.setOnClickListener(this);
    this.mDefautlBtnLeft.setOnClickListener(this);
    this.mTitleBtnRight.setContentDescription(anvx.a(2131706472));
    this.mTitleText = ((TextView)this.mAIORootView.findViewById(2131379001));
    this.mSubTilteText = ((TextView)this.mAIORootView.findViewById(2131379089));
    this.mTitleBtnCall.setVisibility(4);
    this.mTitleBtnRight.setVisibility(4);
    this.mTitleBtnLeft.setText(this.mActivity.getString(2131690676));
    setSubTitleVisable(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mAIORootView.findViewById(2131371674));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mAIORootView.findViewById(2131371672));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mAIORootView.findViewById(2131371682));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mAIORootView.findViewById(2131371671));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.mAIORootView.findViewById(2131371679));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(false);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLongClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDelAnimationDuration(300L);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)this.mAIORootView.findViewById(2131362716));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    localObject1 = this.mActivity.getIntent().getExtras();
    if (localObject1 != null)
    {
      localObject2 = ((Bundle)localObject1).getString("uin");
      String str = ((Bundle)localObject1).getString("troop_code");
      i = ((Bundle)localObject1).getInt("uintype");
      this.sessionInfo = new SessionInfo();
      this.sessionInfo.curFriendUin = ((String)localObject2);
      this.sessionInfo.curType = i;
      this.sessionInfo.troopUin = str;
    }
    axio.a().a(this.sessionInfo);
    localObject1 = this.app.getMessageFacade().getMsgItemByUniseq(this.sessionInfo.curFriendUin, this.sessionInfo.curType, this.jdField_a_of_type_Long);
    if (localObject1 != null) {
      axio.a().a(((MessageRecord)localObject1).issend);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView = new View(this.mActivity);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.mActivity.getResources().getDisplayMetrics())));
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      this.jdField_a_of_type_Afqz = new afqz(this.app, this.mActivity, this.sessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = new View(this.mContext);
        i = this.mContext.getResources().getDimensionPixelSize(2131299080);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, i));
        this.jdField_a_of_type_AndroidViewView.setId(2131362436);
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView, null, false);
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeaderTop(i);
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_Afqz);
      localObject1 = LayoutInflater.from(this.app.getApp()).inflate(2131558966, null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)localObject1);
      this.sessionInfo.chatBg = new afrb();
      this.sessionInfo.textSizeForTextItem = ChatTextSizeSettingActivity.a(BaseApplicationImpl.getContext());
      if (afrb.a(BaseApplicationImpl.getContext(), this.app.getCurrentAccountUin(), this.sessionInfo.curFriendUin, true, 7, this.sessionInfo.chatBg)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(this.sessionInfo.chatBg.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      ThreadManager.post(new MultiForwardChatPie.2(this), 8, null, true);
      this.mTitleText.setSingleLine(false);
      this.mTitleText.setMaxLines(2);
      this.mTitleText.setTextSize(16.0F);
      this.mTitleText.setText(this.jdField_c_of_type_JavaLangString);
      if (this.isThemeDefault) {
        break;
      }
      this.mCustomTitleView.setBackgroundResource(2130850109);
      this.titleBgView.setVisibility(8);
      this.mDefaultLeftBack.setVisibility(8);
      this.mDefautlBtnLeft.setVisibility(8);
      localObject1 = this.mContext.getResources().getColorStateList(2131167023);
      this.mTitleText.setTextColor((ColorStateList)localObject1);
      this.mTitleBtnLeft.setVisibility(0);
      localObject1 = this.mTitleBtnRight;
      i = 2130840365;
      if (this.isThemeDefault) {
        i = 2130843770;
      }
      ((ImageView)localObject1).setImageResource(i);
      ((ImageView)localObject1).setContentDescription(anvx.a(2131706471));
      ((ImageView)localObject1).setVisibility(0);
      ((ImageView)localObject1).setOnClickListener(new aicz(this));
      addBusinessObservers();
      localObject1 = (ahpf)getHelper(49);
      if (localObject1 != null) {
        ((ahpf)localObject1).a(4);
      }
      return true;
      axio.a().a(0);
    }
    this.mCustomTitleView.setBackgroundResource(2130850110);
    this.titleBgView.setVisibility(0);
    if (!TextUtils.isEmpty(this.mDefautlBtnLeft.getText())) {
      this.mDefautlBtnLeft.setVisibility(0);
    }
    for (;;)
    {
      localObject1 = this.mContext.getResources().getColorStateList(2131167024);
      this.mTitleText.setTextColor((ColorStateList)localObject1);
      this.mTitleBtnLeft.setVisibility(8);
      break;
      this.mDefautlBtnLeft.setVisibility(4);
    }
  }
  
  public void doOnDestroy()
  {
    this.mCurrentAIOState = 9;
    a(13);
    this.mFirstVisibleView = null;
    this.mLastVisibleView = null;
    this.mFirstVisibleItem = 0;
    this.mLastVisibleItem = 0;
    this.jdField_a_of_type_Afqz.c();
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    removeBusinessObservers();
    this.uiHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    ahpf localahpf = (ahpf)getHelper(49);
    if (localahpf != null) {
      localahpf.a(14);
    }
  }
  
  public void doOnPause()
  {
    QQLiveImage.pauseAll(this.mActivity);
    AbstractGifImage.pauseAll();
    this.mCurrentAIOState = 5;
    a(10);
  }
  
  public void doOnResume()
  {
    if (this.isFromOnCreate) {
      this.uiHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 800L);
    }
    if (this.isFromOnCreate)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.postDelayed(new MultiForwardChatPie.5(this), 600L);
      this.isFromOnCreate = false;
    }
    for (;;)
    {
      QQLiveImage.resumeAll(this.mActivity);
      AbstractGifImage.resumeAll();
      this.mCurrentAIOState = 4;
      a(6);
      return;
      this.jdField_a_of_type_Afqz.notifyDataSetChanged();
    }
  }
  
  public void doOnStart()
  {
    this.mCurrentAIOState = 3;
  }
  
  public void doOnStop()
  {
    this.mCurrentAIOState = 6;
    a(11);
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    if (this.mActivity != null) {
      this.mActivity.finish();
    }
  }
  
  public boolean finish(int paramInt)
  {
    this.mCurrentAIOState = 8;
    this.uiHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    return false;
  }
  
  public void handleScrollOutScreen(View paramView)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("handleScrollOutScreen , view = ");
      if (paramView == null)
      {
        str = "null";
        QLog.i("MultiForwardActivity", 2, str);
      }
    }
    else
    {
      if (paramView != null) {
        break label56;
      }
    }
    label56:
    do
    {
      do
      {
        return;
        str = paramView.toString();
        break;
        paramView = AIOUtils.getHolder(paramView);
      } while (!(paramView instanceof ahjb));
      paramView = (ahjb)paramView;
    } while (paramView.a == null);
    paramView.a.d();
  }
  
  public boolean onBackEvent()
  {
    alvw localalvw = (alvw)getHelper(4);
    if ((localalvw != null) && (localalvw.a())) {
      return true;
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    BaseChatItemLayout.a = this.jdField_b_of_type_Boolean;
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      finish();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mFirstVisibleItem < paramInt1) {
      handleScrollOutScreen(this.mFirstVisibleView);
    }
    for (;;)
    {
      this.mFirstVisibleItem = paramInt1;
      if (paramInt1 + paramInt2 - 1 >= 0) {
        this.mLastVisibleItem = (paramInt1 + paramInt2 - 1);
      }
      this.mFirstVisibleView = paramAbsListView.getChildAt(0);
      this.mLastVisibleView = paramAbsListView.getChildAt(paramInt2 - 1);
      paramAbsListView = (ahpf)getHelper(49);
      if (paramAbsListView != null) {
        paramAbsListView.a(20);
      }
      return;
      if ((paramInt1 + paramInt2 - 1 < this.mLastVisibleItem) && (paramInt1 + paramInt2 - 1 > 0)) {
        handleScrollOutScreen(this.mLastVisibleView);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      a(17);
      return;
    }
    a(15);
  }
  
  public void refreshHeadMessage(int paramInt1, long paramLong, int paramInt2, MessageRecord paramMessageRecord, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiForwardChatPie", 2, "refreshHeadMessage==>type:" + paramInt1 + "|value:" + paramLong);
    }
    paramMessageRecord = this.jdField_a_of_type_Afqz.a();
    if (paramMessageRecord != null)
    {
      Iterator localIterator = paramMessageRecord.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramMessageRecord = (ChatMessage)localIterator.next();
      } while ((acnh.b(paramMessageRecord)) || (acnh.a(paramMessageRecord)) || ((paramMessageRecord instanceof MessageForSafeGrayTips)) || (paramMessageRecord.shmsgseq != paramLong));
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        if (paramMessageRecord != null)
        {
          bool = true;
          QLog.d("MultiForwardChatPie", 2, new Object[] { "refreshHeadMessage==>", "isFind:", Boolean.valueOf(bool) });
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b(paramInt3);
        if ((paramMessageRecord == null) || (avia.a(paramMessageRecord))) {
          break label302;
        }
        paramInt2 = this.jdField_a_of_type_Afqz.a(paramMessageRecord.uniseq);
        if (paramInt2 == -1) {
          break label231;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null, 10);
      }
      label231:
      do
      {
        do
        {
          return;
          bool = false;
          break;
          if (paramMessageRecord.msgtype == -2006) {
            QQToast.a(this.mActivity, anvx.a(2131706475), 0).b(this.mActivity.getTitleBarHeight());
          }
        } while (!QLog.isColorLevel());
        QLog.d("MultiForwardChatPie", 2, new Object[] { "pos is -1, msgtype:", Integer.valueOf(paramMessageRecord.msgtype) });
        return;
        QQToast.a(this.mActivity, 2131697439, 0).b(this.mActivity.getTitleBarHeight());
      } while (!QLog.isColorLevel());
      label302:
      if (paramMessageRecord != null) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.d("MultiForwardChatPie", 2, new Object[] { "foundMsgRecord:", Boolean.valueOf(bool) });
        return;
      }
      paramMessageRecord = null;
    }
  }
  
  public void removeBusinessObservers()
  {
    this.app.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_Atfq);
    this.app.removeObserver(this.jdField_a_of_type_Anrc);
    this.app.removeObserver(this.jdField_a_of_type_Anvi);
    this.app.removeObserver(this.jdField_a_of_type_Aofu);
  }
  
  public void setTag()
  {
    this.tag = "MultiForwardChatPie";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aict
 * JD-Core Version:    0.7.0.1
 */