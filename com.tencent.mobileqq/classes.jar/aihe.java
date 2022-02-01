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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
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

public class aihe
  extends BaseChatPie
{
  private boolean S;
  private boolean T;
  private anmu jdField_a_of_type_Anmu = new aihj(this);
  Comparator<MessageRecord> jdField_a_of_type_JavaUtilComparator = new aihh(this);
  private Long[] jdField_a_of_type_ArrayOfJavaLangLong;
  private afwy jdField_b_of_type_Afwy;
  Comparator<MessageRecord> jdField_b_of_type_JavaUtilComparator = new aihi(this);
  private List<ChatMessage> jdField_b_of_type_JavaUtilList;
  private RelativeLayout f;
  private TextView l;
  private View n;
  
  public aihe(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private void a(View paramView, int paramInt, bkho parambkho)
  {
    if (paramView == null)
    {
      parambkho.dismiss();
      return;
    }
    String str = parambkho.a(paramInt);
    if (str == null)
    {
      parambkho.dismiss();
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      parambkho.dismiss();
      return;
    }
    if (str.equals(paramView.getResources().getString(2131689955)))
    {
      bo();
      bcst.b(null, "dc00898", "", "", "0X800AE92", "0X800AE92", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      parambkho.dismiss();
      return;
      if (str.equals(paramView.getResources().getString(2131689956)))
      {
        bp();
        bcst.b(null, "dc00898", "", "", "0X800AE93", "0X800AE93", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void b(List<ChatMessage> paramList)
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
  
  private void bo()
  {
    ((aimx)this.jdField_a_of_type_Aglu.a(59)).a(this.jdField_b_of_type_JavaUtilList);
  }
  
  private void bp()
  {
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      ChatMessage localChatMessage = (ChatMessage)this.jdField_b_of_type_JavaUtilList.get(0);
      ((ainf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(365)).a(a(), localChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    }
  }
  
  private void bq()
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
        localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageRecord.longValue());
        if (((localMessageRecord instanceof ChatMessage)) && (aini.a(localMessageRecord))) {
          localArrayList.add((ChatMessage)localMessageRecord);
        }
        for (;;)
        {
          i += 1;
          break;
          this.S = true;
        }
      }
      b(localArrayList);
      localObject = Message.obtain();
      ((Message)localObject).what = 96;
      ((Message)localObject).obj = localArrayList;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
    }
  }
  
  private void br()
  {
    Intent localIntent = a().getIntent();
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.jdField_a_of_type_ArrayOfJavaLangLong = ((Long[])localIntent.getSerializableExtra("key_uniseq"));
      if ((this.jdField_a_of_type_ArrayOfJavaLangLong == null) || (this.jdField_a_of_type_ArrayOfJavaLangLong.length == 0)) {
        a().finish();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("uin");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = localIntent.getIntExtra("uintype", -1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
        break label240;
      }
    }
    label240:
    for (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = bglf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, bglf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);; this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = localIntent.getStringExtra("uinname"))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n = true;
      if (QLog.isDevelopLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Q.aio.BaseChatPie parseIntent...sessionInfo.curFriendUin = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + ", sessionInfo.curType = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
      return;
      Object[] arrayOfObject = (Object[])localIntent.getSerializableExtra("key_uniseq");
      this.jdField_a_of_type_ArrayOfJavaLangLong = ((Long[])Arrays.copyOf(arrayOfObject, arrayOfObject.length, [Ljava.lang.Long.class));
      break;
    }
  }
  
  private void d(View paramView)
  {
    paramView = bkho.c(paramView.getContext());
    paramView.b(2131689955);
    paramView.b(2131689956);
    paramView.c(2131690582);
    paramView.a(new aihg(this, paramView));
    paramView.show();
  }
  
  private void z(int paramInt)
  {
    alqh localalqh = (alqh)a(4);
    if (localalqh != null) {
      localalqh.a(paramInt);
    }
  }
  
  public void H()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Q.aio.BaseChatPie doOnDestroy...");
    }
    this.i = 9;
    z(12);
    this.j = null;
    this.jdField_k_of_type_AndroidViewView = null;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 0;
    this.jdField_b_of_type_Afwy.c();
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    aq();
  }
  
  public void I()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
    }
  }
  
  public void K()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Q.aio.BaseChatPie doOnStart...");
    }
    this.i = 3;
  }
  
  public void L()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Q.aio.BaseChatPie doOnStop...");
    }
    this.i = 6;
    z(10);
  }
  
  public void M()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Q.aio.BaseChatPie doOnPause...");
    }
    BaseChatItemLayout.a = this.T;
    QQLiveImage.pauseAll(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    AbstractGifImage.pauseAll();
    this.i = 5;
    z(9);
  }
  
  public void P()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Q.aio.BaseChatPie doOnResume...");
    }
    this.T = BaseChatItemLayout.a;
    BaseChatItemLayout.a = false;
    if (this.y)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.postDelayed(new UpComingMsgChatPie.6(this), 600L);
      this.y = false;
    }
    for (;;)
    {
      QQLiveImage.resumeAll(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      AbstractGifImage.resumeAll();
      this.i = 4;
      z(5);
      return;
      this.jdField_b_of_type_Afwy.notifyDataSetChanged();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "UpComingMsgLogic.UpComingMsgChatPie";
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Q.aio.BaseChatPie doOnCreate...");
    }
    this.S = false;
    this.y = true;
    br();
    this.H = ThemeUtil.isDefaultOrDIYTheme(false);
    Object localObject1 = (ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362279);
    ((ViewGroup)localObject1).removeView(this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131376788));
    Object localObject2 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362526);
    if (localObject2 != null) {
      ((ViewGroup)localObject1).removeView((View)localObject2);
    }
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = new UpComingRelativeLayout(a());
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.setId(2131362526);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ViewGroup)localObject1).addView(this.jdField_f_of_type_AndroidWidgetRelativeLayout, 0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = new ChatXListView(a());
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.n = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.n.setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDisplayMetrics())));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.n);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(false);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLongClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDelAnimationDuration(300L);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVerticalScrollBarEnabled(false);
    this.jdField_l_of_type_AndroidWidgetTextView = new TextView(a());
    this.jdField_l_of_type_AndroidWidgetTextView.setText(a().getResources().getString(2131689957));
    this.jdField_l_of_type_AndroidWidgetTextView.setTextSize(2, 16.0F);
    this.jdField_l_of_type_AndroidWidgetTextView.setTextColor(-7829368);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_l_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO = ((NavBarAIO)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131376599));
    this.jdField_k_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131376600));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131368947));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131368961));
    this.d = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131368956));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369362));
    this.e = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378776));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378864));
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().density;
    afur.a(this.jdField_b_of_type_AndroidWidgetImageView, 0, 0, 0, (int)(50.0F * this.jdField_a_of_type_Float + 0.5F));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131379468));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378831));
    localObject2 = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    int i;
    if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      i = afur.a(64.0F, this.jdField_a_of_type_AndroidViewViewGroup.getResources());
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = i;
      ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anni.a(2131705783));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = new AIOAnimationConatiner(a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_b_of_type_Afwy = new afwy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
    this.jdField_b_of_type_Afwy.a = Boolean.valueOf(false);
    if (this.m == null)
    {
      this.m = new View(this.jdField_a_of_type_AndroidContentContext);
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998);
      this.m.setLayoutParams(new AbsListView.LayoutParams(-1, i));
      this.m.setId(2131362411);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.m, null, false);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeaderTop(i);
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_b_of_type_Afwy);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Afxa = new afxa();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(BaseApplicationImpl.getContext());
    if (afxa.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Afxa)) {
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Afxa.a);
    }
    this.d.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131690563));
    c(false);
    this.e.setSingleLine(false);
    this.e.setMaxLines(2);
    this.e.setTextSize(16.0F);
    this.e.setText(a().getResources().getString(2131689954));
    if (!this.H)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850087);
      this.jdField_k_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166983);
      this.e.setTextColor((ColorStateList)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      ThreadManager.post(new UpComingMsgChatPie.1(this), 8, null, true);
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      i = 2130840281;
      if (this.H) {
        i = 2130843652;
      }
      ((ImageView)localObject1).setImageResource(i);
      ((ImageView)localObject1).setContentDescription(anni.a(2131705782));
      ((ImageView)localObject1).setOnClickListener(new aihf(this));
      ap();
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850088);
    this.jdField_k_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!TextUtils.isEmpty(this.jdField_c_of_type_AndroidWidgetTextView.getText())) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166984);
      this.e.setTextColor((ColorStateList)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void ap()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anmu);
  }
  
  public void aq()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anmu);
  }
  
  public boolean b(int paramInt)
  {
    this.i = 8;
    return false;
  }
  
  public void c(View paramView)
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
        paramView = afur.a(paramView);
      } while (!(paramView instanceof ahkn));
      paramView = (ahkn)paramView;
    } while (paramView.a == null);
    paramView.a.d();
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
        this.jdField_b_of_type_JavaUtilList = localList;
        if (this.jdField_b_of_type_JavaUtilList.size() <= 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(8);
          this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          bcst.b(null, "dc00898", "", "", "0X800AE95", "0X800AE95", 1, 0, "", "", "", "");
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label231;
          }
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Q.aio.BaseChatPie upComing. dataList.size = " + this.jdField_b_of_type_JavaUtilList.size());
          break;
          if (this.S)
          {
            QQToast.a(a(), 0, 2131689958, 3000).a();
            bcst.b(null, "dc00898", "", "", "0X800AE95", "0X800AE95", 2, 0, "", "", "", "");
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_b_of_type_Afwy.a(localList, null);
        }
      }
    }
  }
  
  public boolean i()
  {
    alqh localalqh = (alqh)a(4);
    return (localalqh != null) && (localalqh.a());
  }
  
  public void o(int paramInt)
  {
    bcst.b(null, "dc00898", "", "", "0X800AE91", "0X800AE91", 0, 0, "", "", "", "");
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
      I();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_k_of_type_Int < paramInt1) {
      c(this.j);
    }
    for (;;)
    {
      this.jdField_k_of_type_Int = paramInt1;
      if (paramInt1 + paramInt2 - 1 >= 0) {
        this.jdField_l_of_type_Int = (paramInt1 + paramInt2 - 1);
      }
      this.j = paramAbsListView.getChildAt(0);
      this.jdField_k_of_type_AndroidViewView = paramAbsListView.getChildAt(paramInt2 - 1);
      return;
      if ((paramInt1 + paramInt2 - 1 < this.jdField_l_of_type_Int) && (paramInt1 + paramInt2 - 1 > 0)) {
        c(this.jdField_k_of_type_AndroidViewView);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      z(16);
      return;
    }
    z(14);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihe
 * JD-Core Version:    0.7.0.1
 */