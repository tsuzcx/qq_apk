import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.QQLiveImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.UpComingMsgChatPie.1;
import com.tencent.mobileqq.activity.aio.rebuild.UpComingMsgChatPie.6;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingRelativeLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ahlf
  extends BaseChatPie
{
  private aezn jdField_a_of_type_Aezn;
  private amsu jdField_a_of_type_Amsu = new ahlk(this);
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  Comparator<MessageRecord> jdField_a_of_type_JavaUtilComparator = new ahli(this);
  private List<ChatMessage> jdField_a_of_type_JavaUtilList;
  private Long[] jdField_a_of_type_ArrayOfJavaLangLong;
  Comparator<MessageRecord> jdField_b_of_type_JavaUtilComparator = new ahlj(this);
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public ahlf(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private void a()
  {
    ((ahrg)this.helperProvider.a(59)).a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void a(int paramInt)
  {
    akya localakya = (akya)getHelper(4);
    if (localakya != null) {
      localakya.a(paramInt);
    }
  }
  
  private void a(View paramView)
  {
    paramView = bjnw.c(paramView.getContext());
    paramView.b(2131689977);
    paramView.b(2131689978);
    paramView.c(2131690620);
    paramView.a(new ahlh(this, paramView));
    paramView.show();
  }
  
  private void a(View paramView, int paramInt, bjnw parambjnw)
  {
    if (paramView == null)
    {
      parambjnw.dismiss();
      return;
    }
    String str = parambjnw.a(paramInt);
    if (str == null)
    {
      parambjnw.dismiss();
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      parambjnw.dismiss();
      return;
    }
    if (str.equals(paramView.getResources().getString(2131689977)))
    {
      a();
      bcef.b(null, "dc00898", "", "", "0X800AE92", "0X800AE92", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      parambjnw.dismiss();
      return;
      if (str.equals(paramView.getResources().getString(2131689978)))
      {
        b();
        bcef.b(null, "dc00898", "", "", "0X800AE93", "0X800AE93", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void a(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (((ChatMessage)paramList.get(0)).istroop == 1) {
        Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
      }
    }
    else {
      return;
    }
    Collections.sort(paramList, this.jdField_b_of_type_JavaUtilComparator);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(0);
      ((ahro)this.app.getManager(365)).a(getActivity(), localChatMessage, this.sessionInfo.curFriendNick);
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ArrayOfJavaLangLong != null) && (this.jdField_a_of_type_ArrayOfJavaLangLong.length > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = this.jdField_a_of_type_ArrayOfJavaLangLong;
      int j = localObject.length;
      int i = 0;
      if (i < j)
      {
        MessageRecord localMessageRecord = localObject[i];
        localMessageRecord = this.app.getMessageFacade().queryMsgItemByUniseq(this.sessionInfo.curFriendUin, this.sessionInfo.curType, localMessageRecord.longValue());
        if (((localMessageRecord instanceof ChatMessage)) && (ahrr.a(localMessageRecord))) {
          localArrayList.add((ChatMessage)localMessageRecord);
        }
        for (;;)
        {
          i += 1;
          break;
          this.jdField_b_of_type_Boolean = true;
        }
      }
      a(localArrayList);
      localObject = Message.obtain();
      ((Message)localObject).what = 96;
      ((Message)localObject).obj = localArrayList;
      this.uiHandler.sendMessage((Message)localObject);
    }
  }
  
  private void d()
  {
    Intent localIntent = getActivity().getIntent();
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.jdField_a_of_type_ArrayOfJavaLangLong = ((Long[])localIntent.getSerializableExtra("key_uniseq"));
      if ((this.jdField_a_of_type_ArrayOfJavaLangLong == null) || (this.jdField_a_of_type_ArrayOfJavaLangLong.length == 0)) {
        getActivity().finish();
      }
      this.sessionInfo = new SessionInfo();
      this.sessionInfo.curFriendUin = localIntent.getStringExtra("uin");
      this.sessionInfo.curType = localIntent.getIntExtra("uintype", -1);
      if (this.sessionInfo.curType != 0) {
        break label242;
      }
    }
    label242:
    for (this.sessionInfo.curFriendNick = ContactUtils.getDisplayName(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.troopUin, ContactUtils.getEntry(this.sessionInfo.curType), 3);; this.sessionInfo.curFriendNick = localIntent.getStringExtra("uinname"))
    {
      this.sessionInfo.isUpComingPrevious = true;
      if (QLog.isDevelopLevel()) {
        QLog.d(this.tag, 2, "Q.aio.BaseChatPie parseIntent...sessionInfo.curFriendUin = " + this.sessionInfo.curFriendUin + ", sessionInfo.curType = " + this.sessionInfo.curType);
      }
      return;
      Object[] arrayOfObject = (Object[])localIntent.getSerializableExtra("key_uniseq");
      this.jdField_a_of_type_ArrayOfJavaLangLong = ((Long[])Arrays.copyOf(arrayOfObject, arrayOfObject.length, [Ljava.lang.Long.class));
      break;
    }
  }
  
  public void addBusinessObservers()
  {
    if (this.app == null) {
      return;
    }
    this.app.addObserver(this.jdField_a_of_type_Amsu);
  }
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "Q.aio.BaseChatPie doOnCreate...");
    }
    this.jdField_b_of_type_Boolean = false;
    this.isFromOnCreate = true;
    d();
    this.isThemeDefault = ThemeUtil.isDefaultOrDIYTheme(false);
    Object localObject1 = (ViewGroup)this.mAIORootView.findViewById(2131362294);
    ((ViewGroup)localObject1).removeView(this.mAIORootView.findViewById(2131376679));
    Object localObject2 = this.mAIORootView.findViewById(2131362545);
    if (localObject2 != null) {
      ((ViewGroup)localObject1).removeView((View)localObject2);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new UpComingRelativeLayout(getActivity());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setId(2131362545);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ViewGroup)localObject1).addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0);
    this.listView = new ChatXListView(getActivity());
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.listView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.listView);
    this.jdField_a_of_type_AndroidViewView = new View(this.mActivity);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.mActivity.getResources().getDisplayMetrics())));
    this.listView.addFooterView(this.jdField_a_of_type_AndroidViewView);
    this.listView.setStackFromBottom(false);
    this.listView.setTranscriptMode(0);
    this.listView.setLongClickable(true);
    this.listView.setDelAnimationDuration(300L);
    this.listView.setDivider(null);
    this.listView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getActivity());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getActivity().getResources().getString(2131689980));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-7829368);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.mCustomTitleView = ((NavBarAIO)this.mAIORootView.findViewById(2131376501));
    this.titleBgView = ((ImageView)this.mAIORootView.findViewById(2131376502));
    this.mTitleBtnLeft = ((TextView)this.mAIORootView.findViewById(2131369068));
    this.mTitleBtnRight = ((ImageView)this.mAIORootView.findViewById(2131369082));
    this.mTitleBtnCall = ((ImageView)this.mAIORootView.findViewById(2131369077));
    this.mDefaultLeftBack = ((ImageView)this.mAIORootView.findViewById(2131369436));
    this.mTitleText = ((TextView)this.mAIORootView.findViewById(2131378707));
    this.mSubTilteText = ((TextView)this.mAIORootView.findViewById(2131378795));
    this.mSubTilteText.setVisibility(8);
    this.mDensity = this.app.getApplication().getResources().getDisplayMetrics().density;
    AIOUtils.expandViewTouchDelegate(this.mDefaultLeftBack, 0, 0, 0, (int)(50.0F * this.mDensity + 0.5F));
    this.mDefautlBtnLeft = ((TextView)this.mAIORootView.findViewById(2131379417));
    this.mTitleLayout = ((ViewGroup)this.mAIORootView.findViewById(2131378762));
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
    this.mTitleBtnRight.setContentDescription(amtj.a(2131706120));
    this.mAnimContainer = new AIOAnimationConatiner(getActivity());
    this.mAnimContainer.a(this.listView);
    this.jdField_a_of_type_Aezn = new aezn(this.app, this.mActivity, this.sessionInfo, this.mAnimContainer, this);
    this.jdField_a_of_type_Aezn.a = Boolean.valueOf(false);
    if (this.headView == null)
    {
      this.headView = new View(this.mContext);
      i = this.mContext.getResources().getDimensionPixelSize(2131299076);
      this.headView.setLayoutParams(new AbsListView.LayoutParams(-1, i));
      this.headView.setId(2131362430);
      this.listView.addHeaderView(this.headView, null, false);
      this.listView.setOverscrollHeaderTop(i);
    }
    this.listView.setAdapter(this.jdField_a_of_type_Aezn);
    this.sessionInfo.chatBg = new aezp();
    this.sessionInfo.textSizeForTextItem = ChatTextSizeSettingActivity.a(BaseApplicationImpl.getContext());
    if (aezp.a(BaseApplicationImpl.getContext(), this.app.getCurrentAccountUin(), this.sessionInfo.curFriendUin, true, 7, this.sessionInfo.chatBg)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(this.sessionInfo.chatBg.a);
    }
    this.mTitleBtnCall.setVisibility(4);
    this.mTitleBtnRight.setVisibility(4);
    this.mTitleBtnLeft.setText(this.mActivity.getString(2131690599));
    setSubTitleVisable(false);
    this.mTitleText.setSingleLine(false);
    this.mTitleText.setMaxLines(2);
    this.mTitleText.setTextSize(16.0F);
    this.mTitleText.setText(getActivity().getResources().getString(2131689975));
    if (!this.isThemeDefault)
    {
      this.mCustomTitleView.setBackgroundResource(2130850016);
      this.titleBgView.setVisibility(8);
      this.mDefaultLeftBack.setVisibility(8);
      this.mDefautlBtnLeft.setVisibility(8);
      localObject1 = this.mContext.getResources().getColorStateList(2131167009);
      this.mTitleText.setTextColor((ColorStateList)localObject1);
      this.mTitleBtnLeft.setVisibility(0);
      ThreadManager.post(new UpComingMsgChatPie.1(this), 8, null, true);
      localObject1 = this.mTitleBtnRight;
      i = 2130840329;
      if (this.isThemeDefault) {
        i = 2130843732;
      }
      ((ImageView)localObject1).setImageResource(i);
      ((ImageView)localObject1).setContentDescription(amtj.a(2131706119));
      ((ImageView)localObject1).setOnClickListener(new ahlg(this));
      addBusinessObservers();
      return true;
    }
    this.mCustomTitleView.setBackgroundResource(2130850017);
    this.titleBgView.setVisibility(0);
    if (!TextUtils.isEmpty(this.mDefautlBtnLeft.getText())) {
      this.mDefautlBtnLeft.setVisibility(0);
    }
    for (;;)
    {
      localObject1 = this.mContext.getResources().getColorStateList(2131167010);
      this.mTitleText.setTextColor((ColorStateList)localObject1);
      this.mTitleBtnLeft.setVisibility(8);
      break;
      this.mDefautlBtnLeft.setVisibility(4);
    }
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "Q.aio.BaseChatPie doOnDestroy...");
    }
    this.mCurrentAIOState = 9;
    a(12);
    this.mFirstVisibleView = null;
    this.mLastVisibleView = null;
    this.mFirstVisibleItem = 0;
    this.mLastVisibleItem = 0;
    this.jdField_a_of_type_Aezn.c();
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    removeBusinessObservers();
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "Q.aio.BaseChatPie doOnPause...");
    }
    BaseChatItemLayout.a = this.c;
    QQLiveImage.pauseAll(this.mActivity);
    AbstractGifImage.pauseAll();
    this.mCurrentAIOState = 5;
    a(9);
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "Q.aio.BaseChatPie doOnResume...");
    }
    this.c = BaseChatItemLayout.a;
    BaseChatItemLayout.a = false;
    if (this.isFromOnCreate)
    {
      this.listView.postDelayed(new UpComingMsgChatPie.6(this), 600L);
      this.isFromOnCreate = false;
    }
    for (;;)
    {
      QQLiveImage.resumeAll(this.mActivity);
      AbstractGifImage.resumeAll();
      this.mCurrentAIOState = 4;
      a(5);
      return;
      this.jdField_a_of_type_Aezn.notifyDataSetChanged();
    }
  }
  
  public void doOnStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "Q.aio.BaseChatPie doOnStart...");
    }
    this.mCurrentAIOState = 3;
  }
  
  public void doOnStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "Q.aio.BaseChatPie doOnStop...");
    }
    this.mCurrentAIOState = 6;
    a(10);
  }
  
  public void finish()
  {
    if (this.mActivity != null) {
      this.mActivity.finish();
    }
  }
  
  public boolean finish(int paramInt)
  {
    this.mCurrentAIOState = 8;
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label231:
    for (;;)
    {
      return super.handleMessage(paramMessage);
      if ((paramMessage.obj instanceof List))
      {
        List localList = (List)paramMessage.obj;
        this.jdField_a_of_type_JavaUtilList = localList;
        if (this.jdField_a_of_type_JavaUtilList.size() <= 0)
        {
          this.listView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.mTitleBtnRight.setVisibility(8);
          bcef.b(null, "dc00898", "", "", "0X800AE95", "0X800AE95", 1, 0, "", "", "", "");
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label231;
          }
          QLog.d(this.tag, 2, "Q.aio.BaseChatPie upComing. dataList.size = " + this.jdField_a_of_type_JavaUtilList.size());
          break;
          if (this.jdField_b_of_type_Boolean)
          {
            QQToast.a(getActivity(), 0, 2131689981, 3000).a();
            bcef.b(null, "dc00898", "", "", "0X800AE95", "0X800AE95", 2, 0, "", "", "", "");
          }
          this.mTitleBtnRight.setVisibility(0);
          this.jdField_a_of_type_Aezn.a(localList, null);
        }
      }
    }
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
        QLog.i("Q.aio.BaseChatPie", 2, str);
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
      } while (!(paramView instanceof agql));
      paramView = (agql)paramView;
    } while (paramView.a == null);
    paramView.a.d();
  }
  
  public boolean onBackEvent()
  {
    akya localakya = (akya)getHelper(4);
    return (localakya != null) && (localakya.a());
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
      a(16);
      return;
    }
    a(14);
  }
  
  public void onShowFirst(int paramInt)
  {
    bcef.b(null, "dc00898", "", "", "0X800AE91", "0X800AE91", 0, 0, "", "", "", "");
  }
  
  public void removeBusinessObservers()
  {
    if (this.app == null) {
      return;
    }
    this.app.removeObserver(this.jdField_a_of_type_Amsu);
  }
  
  public void setTag()
  {
    this.tag = "UpComingMsgLogic.UpComingMsgChatPie";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlf
 * JD-Core Version:    0.7.0.1
 */