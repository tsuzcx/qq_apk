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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.2;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.4;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.5;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.6;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.8;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
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

public class aege
  extends BaseChatPie
{
  public boolean T;
  private ajey jdField_a_of_type_Ajey = new aegl(this);
  ajjh jdField_a_of_type_Ajjh = new aegh(this);
  ajuc jdField_a_of_type_Ajuc = new aegi(this);
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private aodp jdField_a_of_type_Aodp = new aegg(this);
  private MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private acka jdField_b_of_type_Acka;
  private AIOAnimationConatiner jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  private ChatXListView jdField_b_of_type_ComTencentMobileqqBubbleChatXListView;
  ScrollerRunnable jdField_b_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  public Runnable b;
  private List<ChatMessage> jdField_b_of_type_JavaUtilList;
  public MqqHandler b;
  private RelativeLayout f;
  public long g;
  private RelativeLayout jdField_g_of_type_AndroidWidgetRelativeLayout;
  String jdField_g_of_type_JavaLangString;
  private long h;
  public String h;
  private TextView l;
  View o;
  private View jdField_p_of_type_AndroidViewView;
  private ImageView jdField_p_of_type_AndroidWidgetImageView;
  private final int q = 300;
  private int r;
  private int s;
  
  public aege(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_b_of_type_MqqOsMqqHandler = new aegf(this);
  }
  
  private void A(int paramInt)
  {
    ahpc localahpc = (ahpc)a(4);
    if (localahpc != null) {
      localahpc.a(paramInt);
    }
  }
  
  private void a(View paramView, int paramInt, begr parambegr)
  {
    if (paramView == null)
    {
      parambegr.dismiss();
      return;
    }
    String str = parambegr.a(paramInt);
    if (str == null)
    {
      parambegr.dismiss();
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      parambegr.dismiss();
      return;
    }
    if (str.equals(paramView.getResources().getString(2131627742)))
    {
      aryb.a("0X8009AB5");
      c(this.jdField_g_of_type_Long);
    }
    parambegr.dismiss();
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(24);
    if ((this.jdField_c_of_type_Bbms == null) || (!this.jdField_c_of_type_Bbms.isShowing())) {}
    do
    {
      return;
      if ((paramBoolean) && (paramObject != null) && (arxu.a().jdField_a_of_type_Int == 6))
      {
        this.jdField_c_of_type_Bbms.dismiss();
        arxu.a().b.clear();
        arxu.a().b.putAll((Map)paramObject);
        ((acxm)this.jdField_a_of_type_Acxb.a(11)).a((Map)paramObject, arxu.a().jdField_a_of_type_JavaUtilArrayList, arxu.a().jdField_a_of_type_Int);
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("MultiMsg_TAG", 4, "handleMultiFavorite = " + paramObject);
  }
  
  private void c(long paramLong)
  {
    ThreadManagerV2.post(new MultiForwardChatPie.8(this, paramLong), 8, null, true);
  }
  
  private void d(View paramView)
  {
    paramView = begr.c(paramView.getContext());
    paramView.b(2131627742);
    paramView.c(2131625035);
    paramView.a(new aegk(this, paramView));
    paramView.show();
  }
  
  protected boolean D()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130839117);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.e.getCompoundDrawables();
      this.s = this.e.getCompoundDrawablePadding();
      this.e.setCompoundDrawablePadding(10);
      this.e.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      return true;
    }
    return false;
  }
  
  public boolean E()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.e.setCompoundDrawablePadding(this.s);
      this.e.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  public void G()
  {
    this.i = 9;
    A(10);
    this.jdField_k_of_type_AndroidViewView = null;
    this.jdField_l_of_type_AndroidViewView = null;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 0;
    this.jdField_b_of_type_Acka.c();
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    ao();
  }
  
  public void H()
  {
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
    }
  }
  
  public void J()
  {
    this.i = 3;
  }
  
  public void K()
  {
    this.i = 6;
    A(9);
  }
  
  public void L()
  {
    QQLiveImage.pauseAll(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    AbstractGifImage.pauseAll();
    this.i = 5;
    A(8);
  }
  
  public void O()
  {
    if (this.z)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.postDelayed(new MultiForwardChatPie.4(this), 600L);
      this.z = false;
    }
    for (;;)
    {
      QQLiveImage.resumeAll(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      AbstractGifImage.resumeAll();
      this.i = 4;
      A(4);
      return;
      this.jdField_b_of_type_Acka.notifyDataSetChanged();
    }
  }
  
  public atpa a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new aegn(this, this.jdField_g_of_type_Long);
    case 1: 
      return new aegn(this, this.jdField_g_of_type_Long);
    }
    return new aegm(this);
  }
  
  public ListView a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "MultiForwardChatPie";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 21) && (paramInt2 == -1) && (paramIntent != null)) {
      super.a(paramIntent.getExtras());
    }
    if ((paramInt1 == 24) && (paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131654133));
      a(paramIntent.getExtras());
    }
    if ((paramInt1 == 24) && (paramIntent != null) && (paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false))) {
      a(false, null, false);
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, MessageRecord paramMessageRecord, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiForwardChatPie", 2, "refreshHeadMessage==>type:" + paramInt1 + "|value:" + paramLong);
    }
    paramMessageRecord = this.jdField_b_of_type_Acka.a();
    if (paramMessageRecord != null)
    {
      Iterator localIterator = paramMessageRecord.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramMessageRecord = (ChatMessage)localIterator.next();
      } while ((akbm.b(paramMessageRecord)) || (akbm.a(paramMessageRecord)) || ((paramMessageRecord instanceof MessageForSafeGrayTips)) || (paramMessageRecord.shmsgseq != paramLong));
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
        this.jdField_b_of_type_ComTencentMobileqqWidgetScrollerRunnable.b(paramInt3);
        if ((paramMessageRecord == null) || (aqay.a(paramMessageRecord))) {
          break label302;
        }
        paramInt2 = this.jdField_b_of_type_Acka.a(paramMessageRecord.uniseq);
        if (paramInt2 == -1) {
          break label231;
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null, 10);
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
            bbmy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ajjy.a(2131641215), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          }
        } while (!QLog.isColorLevel());
        QLog.d("MultiForwardChatPie", 2, new Object[] { "pos is -1, msgtype:", Integer.valueOf(paramMessageRecord.msgtype) });
        return;
        bbmy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131632210, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
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
  
  public boolean a(boolean paramBoolean)
  {
    this.z = true;
    this.T = BaseChatItemLayout.a;
    BaseChatItemLayout.a = false;
    this.I = ThemeUtil.isDefaultOrDIYTheme(false);
    this.i = 2;
    Object localObject1 = (ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131296648);
    ((ViewGroup)localObject1).removeView(this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131309736));
    Object localObject2 = View.inflate(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131493013, null);
    ((View)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject1).addView((View)localObject2, 0);
    this.r = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("callback_type", 1);
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("multi_url");
    this.jdField_g_of_type_Long = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getLongExtra("multimsg_uniseq", 0L);
    this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("multi_title");
    if (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
      this.jdField_h_of_type_JavaLangString = ajjy.a(2131641214);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg_TAG.Nest", 4, "MultiForwardActivity.doOnCreate ResID = " + this.jdField_g_of_type_JavaLangString + "  msg.uniseq = " + this.jdField_g_of_type_Long + " downCallBackType" + this.r);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO = ((NavBarAIO)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131309578));
    this.jdField_o_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131309579));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131302804));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131302816));
    this.d = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131302811));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131303102));
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().density;
    aciy.a(this.jdField_b_of_type_AndroidWidgetImageView, 0, 0, 0, (int)(50.0F * this.jdField_a_of_type_Float + 0.5F));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131312188));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131311586));
    localObject2 = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      i = aciy.a(64.0F, this.jdField_a_of_type_AndroidViewViewGroup.getResources());
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = i;
      ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajjy.a(2131641212));
    this.e = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131311534));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131311618));
    this.d.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131625011));
    c(false);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131304861));
    this.jdField_g_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131304859));
    this.jdField_p_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131304869));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131304858));
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131304866));
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(false);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setLongClickable(true);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setDelAnimationDuration(300L);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131297012));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_b_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
    localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras();
    localObject2 = ((Bundle)localObject1).getString("uin");
    String str = ((Bundle)localObject1).getString("troop_code");
    int i = ((Bundle)localObject1).getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = ((String)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = str;
    arxu.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject2, i, this.jdField_g_of_type_Long);
    if (localObject1 != null) {
      arxu.a().a(((MessageRecord)localObject1).issend);
    }
    for (;;)
    {
      this.jdField_p_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_p_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDisplayMetrics())));
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.jdField_p_of_type_AndroidViewView);
      this.jdField_b_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
      this.jdField_b_of_type_Acka = new acka(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
      if (this.jdField_o_of_type_AndroidViewView == null)
      {
        this.jdField_o_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766);
        this.jdField_o_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, i));
        this.jdField_o_of_type_AndroidViewView.setId(2131296774);
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_o_of_type_AndroidViewView, null, false);
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeaderTop(i);
      }
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_b_of_type_Acka);
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2131493267, null);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Ackc = new ackc();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(BaseApplicationImpl.getContext());
      if (ackc.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Ackc)) {
        this.jdField_f_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Ackc.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      ThreadManager.post(new MultiForwardChatPie.2(this), 8, null, true);
      this.e.setSingleLine(false);
      this.e.setMaxLines(2);
      this.e.setTextSize(16.0F);
      this.e.setText(this.jdField_h_of_type_JavaLangString);
      if (this.I) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130848801);
      this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131101257);
      this.e.setTextColor((ColorStateList)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      i = 2130839704;
      if (this.I) {
        i = 2130843010;
      }
      ((ImageView)localObject1).setImageResource(i);
      ((ImageView)localObject1).setContentDescription(ajjy.a(2131641211));
      ((ImageView)localObject1).setVisibility(0);
      ((ImageView)localObject1).setOnClickListener(new aegj(this));
      an();
      return true;
      arxu.a().a(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130848802);
    this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!TextUtils.isEmpty(this.jdField_c_of_type_AndroidWidgetTextView.getText())) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131101258);
      this.e.setTextColor((ColorStateList)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void an()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aodp);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajey);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuc);
  }
  
  public void ao()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aodp);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajey);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuc);
  }
  
  public void b(List<ChatMessage> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  public boolean b(int paramInt)
  {
    this.i = 8;
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    return false;
  }
  
  public void bm()
  {
    Object localObject2 = arxu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_g_of_type_Long);
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      Object localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((ChatMessage)((Iterator)localObject2).next());
      }
      b((List)localObject1);
      localObject1 = ChatActivityUtils.a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject1 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - this.jdField_h_of_type_Long));
      }
      arxu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaUtilList, true);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.5(this, (CharSequence)localObject1));
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.6(this));
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
        paramView = aciy.a(paramView);
      } while (!(paramView instanceof adrh));
      paramView = (adrh)paramView;
    } while (paramView.a == null);
    paramView.a.d();
  }
  
  public boolean i()
  {
    ahpc localahpc = (ahpc)a(4);
    if ((localahpc != null) && (localahpc.a())) {
      return true;
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    BaseChatItemLayout.a = this.T;
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    H();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_k_of_type_Int < paramInt1) {
      c(this.jdField_k_of_type_AndroidViewView);
    }
    for (;;)
    {
      this.jdField_k_of_type_Int = paramInt1;
      if (paramInt1 + paramInt2 - 1 >= 0) {
        this.jdField_l_of_type_Int = (paramInt1 + paramInt2 - 1);
      }
      this.jdField_k_of_type_AndroidViewView = paramAbsListView.getChildAt(0);
      this.jdField_l_of_type_AndroidViewView = paramAbsListView.getChildAt(paramInt2 - 1);
      return;
      if ((paramInt1 + paramInt2 - 1 < this.jdField_l_of_type_Int) && (paramInt1 + paramInt2 - 1 > 0)) {
        c(this.jdField_l_of_type_AndroidViewView);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      A(14);
      return;
    }
    A(12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aege
 * JD-Core Version:    0.7.0.1
 */