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

public class agnz
  extends BaseChatPie
{
  public boolean T;
  private alkl jdField_a_of_type_Alkl = new agob(this);
  alox jdField_a_of_type_Alox = new agod(this);
  amab jdField_a_of_type_Amab = new agoe(this);
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private aqnl jdField_a_of_type_Aqnl = new agoc(this);
  private MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private aelz jdField_b_of_type_Aelz;
  private AIOAnimationConatiner jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  private ChatXListView jdField_b_of_type_ComTencentMobileqqBubbleChatXListView;
  ScrollerRunnable jdField_b_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  public Runnable b;
  private List<ChatMessage> jdField_b_of_type_JavaUtilList;
  public MqqHandler b;
  private Runnable c;
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
  
  public agnz(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_b_of_type_MqqOsMqqHandler = new agoa(this);
    this.jdField_c_of_type_JavaLangRunnable = new MultiForwardChatPie.4(this);
  }
  
  private void A(int paramInt)
  {
    ajtc localajtc = (ajtc)a(4);
    if (localajtc != null) {
      localajtc.a(paramInt);
    }
  }
  
  private void a(View paramView, int paramInt, bhpy parambhpy)
  {
    if (paramView == null)
    {
      parambhpy.dismiss();
      return;
    }
    String str = parambhpy.a(paramInt);
    if (str == null)
    {
      parambhpy.dismiss();
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      parambhpy.dismiss();
      return;
    }
    if (str.equals(paramView.getResources().getString(2131693485)))
    {
      aule.a("0X8009AB5");
      c(this.jdField_g_of_type_Long);
    }
    parambhpy.dismiss();
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(24);
    if ((this.jdField_c_of_type_Bepp == null) || (!this.jdField_c_of_type_Bepp.isShowing())) {}
    do
    {
      return;
      if ((paramBoolean) && (paramObject != null) && (aukx.a().jdField_a_of_type_Int == 6))
      {
        this.jdField_c_of_type_Bepp.dismiss();
        aukx.a().b.clear();
        aukx.a().b.putAll((Map)paramObject);
        ((afar)this.jdField_a_of_type_Afag.a(11)).a((Map)paramObject, aukx.a().jdField_a_of_type_JavaUtilArrayList, aukx.a().jdField_a_of_type_Int);
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("MultiMsg_TAG", 4, "handleMultiFavorite = " + paramObject);
  }
  
  private void bs()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    aeyc localaeyc = (aeyc)a(49);
    if (localaeyc != null) {
      localaeyc.a(6);
    }
  }
  
  private void c(long paramLong)
  {
    ThreadManagerV2.post(new MultiForwardChatPie.9(this, paramLong), 8, null, true);
  }
  
  private void d(View paramView)
  {
    paramView = bhpy.c(paramView.getContext());
    paramView.b(2131693485);
    paramView.c(2131690648);
    paramView.a(new agog(this, paramView));
    paramView.show();
  }
  
  protected boolean E()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130839228);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.e.getCompoundDrawables();
      this.s = this.e.getCompoundDrawablePadding();
      this.e.setCompoundDrawablePadding(10);
      this.e.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      return true;
    }
    return false;
  }
  
  public boolean F()
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
  
  public void H()
  {
    this.i = 9;
    A(10);
    this.jdField_k_of_type_AndroidViewView = null;
    this.jdField_l_of_type_AndroidViewView = null;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 0;
    this.jdField_b_of_type_Aelz.c();
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    aq();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    aeyc localaeyc = (aeyc)a(49);
    if (localaeyc != null) {
      localaeyc.a(11);
    }
  }
  
  public void I()
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
  
  public void K()
  {
    this.i = 3;
  }
  
  public void L()
  {
    this.i = 6;
    A(9);
  }
  
  public void M()
  {
    QQLiveImage.pauseAll(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    AbstractGifImage.pauseAll();
    this.i = 5;
    A(8);
  }
  
  public void P()
  {
    if (this.z) {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 800L);
    }
    if (this.z)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.postDelayed(new MultiForwardChatPie.5(this), 600L);
      this.z = false;
    }
    for (;;)
    {
      QQLiveImage.resumeAll(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      AbstractGifImage.resumeAll();
      this.i = 4;
      A(4);
      return;
      this.jdField_b_of_type_Aelz.notifyDataSetChanged();
    }
  }
  
  public aweh a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new agoi(this, this.jdField_g_of_type_Long);
    case 1: 
      return new agoi(this, this.jdField_g_of_type_Long);
    }
    return new agoh(this);
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
      paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131720570));
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
    paramMessageRecord = this.jdField_b_of_type_Aelz.a();
    if (paramMessageRecord != null)
    {
      Iterator localIterator = paramMessageRecord.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramMessageRecord = (ChatMessage)localIterator.next();
      } while ((abot.b(paramMessageRecord)) || (abot.a(paramMessageRecord)) || ((paramMessageRecord instanceof MessageForSafeGrayTips)) || (paramMessageRecord.shmsgseq != paramLong));
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
        if ((paramMessageRecord == null) || (aslq.a(paramMessageRecord))) {
          break label302;
        }
        paramInt2 = this.jdField_b_of_type_Aelz.a(paramMessageRecord.uniseq);
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
            QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, alpo.a(2131707383), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          }
        } while (!QLog.isColorLevel());
        QLog.d("MultiForwardChatPie", 2, new Object[] { "pos is -1, msgtype:", Integer.valueOf(paramMessageRecord.msgtype) });
        return;
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131698122, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
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
    Object localObject1 = (ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362208);
    ((ViewGroup)localObject1).removeView(this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131375981));
    Object localObject2 = View.inflate(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131558596, null);
    ((View)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject1).addView((View)localObject2, 0);
    this.r = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("callback_type", 1);
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("multi_url");
    this.jdField_g_of_type_Long = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getLongExtra("multimsg_uniseq", 0L);
    this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("multi_title");
    if (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
      this.jdField_h_of_type_JavaLangString = alpo.a(2131707382);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg_TAG.Nest", 4, "MultiForwardActivity.doOnCreate ResID = " + this.jdField_g_of_type_JavaLangString + "  msg.uniseq = " + this.jdField_g_of_type_Long + " downCallBackType" + this.r);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO = ((NavBarAIO)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131375812));
    this.jdField_o_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131375813));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131368613));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131368627));
    this.d = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131368622));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131368961));
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().density;
    aekt.a(this.jdField_b_of_type_AndroidWidgetImageView, 0, 0, 0, (int)(50.0F * this.jdField_a_of_type_Float + 0.5F));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378562));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131377935));
    localObject2 = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      i = aekt.a(64.0F, this.jdField_a_of_type_AndroidViewViewGroup.getResources());
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = i;
      ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alpo.a(2131707380));
    this.e = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131377884));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131377968));
    this.d.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131690623));
    c(false);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131370832));
    this.jdField_g_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131370830));
    this.jdField_p_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131370840));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131370829));
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131370837));
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(false);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setLongClickable(true);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setDelAnimationDuration(300L);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362578));
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
    aukx.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject2, i, this.jdField_g_of_type_Long);
    if (localObject1 != null) {
      aukx.a().a(((MessageRecord)localObject1).issend);
    }
    for (;;)
    {
      this.jdField_p_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_p_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDisplayMetrics())));
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.jdField_p_of_type_AndroidViewView);
      this.jdField_b_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
      this.jdField_b_of_type_Aelz = new aelz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
      if (this.jdField_o_of_type_AndroidViewView == null)
      {
        this.jdField_o_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914);
        this.jdField_o_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, i));
        this.jdField_o_of_type_AndroidViewView.setId(2131362335);
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_o_of_type_AndroidViewView, null, false);
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeaderTop(i);
      }
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_b_of_type_Aelz);
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2131558861, null);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb = new aemb();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(BaseApplicationImpl.getContext());
      if (aemb.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb)) {
        this.jdField_f_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      ThreadManager.post(new MultiForwardChatPie.2(this), 8, null, true);
      this.e.setSingleLine(false);
      this.e.setMaxLines(2);
      this.e.setTextSize(16.0F);
      this.e.setText(this.jdField_h_of_type_JavaLangString);
      if (this.I) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130849463);
      this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166898);
      this.e.setTextColor((ColorStateList)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      i = 2130840101;
      if (this.I) {
        i = 2130843278;
      }
      ((ImageView)localObject1).setImageResource(i);
      ((ImageView)localObject1).setContentDescription(alpo.a(2131707379));
      ((ImageView)localObject1).setVisibility(0);
      ((ImageView)localObject1).setOnClickListener(new agof(this));
      ap();
      localObject1 = (aeyc)a(49);
      if (localObject1 != null) {
        ((aeyc)localObject1).a(2);
      }
      return true;
      aukx.a().a(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130849464);
    this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!TextUtils.isEmpty(this.jdField_c_of_type_AndroidWidgetTextView.getText())) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166899);
      this.e.setTextColor((ColorStateList)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void ap()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aqnl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alkl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amab);
  }
  
  public void aq()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aqnl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alkl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amab);
  }
  
  public void b(List<ChatMessage> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  public boolean b(int paramInt)
  {
    this.i = 8;
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    return false;
  }
  
  public void br()
  {
    Object localObject2 = aukx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_g_of_type_Long);
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      Object localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((ChatMessage)((Iterator)localObject2).next());
      }
      b((List)localObject1);
      localObject1 = ChatActivityUtils.a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject1 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1, -1L);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - this.jdField_h_of_type_Long));
      }
      aukx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaUtilList, true);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.6(this, (CharSequence)localObject1));
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.7(this));
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
        paramView = aekt.a(paramView);
      } while (!(paramView instanceof afys));
      paramView = (afys)paramView;
    } while (paramView.a == null);
    paramView.a.d();
  }
  
  public boolean i()
  {
    ajtc localajtc = (ajtc)a(4);
    if ((localajtc != null) && (localajtc.a())) {
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
    I();
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
      paramAbsListView = (aeyc)a(49);
      if (paramAbsListView != null) {
        paramAbsListView.a(17);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnz
 * JD-Core Version:    0.7.0.1
 */