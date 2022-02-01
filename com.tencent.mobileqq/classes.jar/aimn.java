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

public class aimn
  extends BaseChatPie
{
  public boolean S;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private anua jdField_a_of_type_Anua = new aimp(this);
  anyu jdField_a_of_type_Anyu = new aimr(this);
  aojs jdField_a_of_type_Aojs = new aims(this);
  private atpa jdField_a_of_type_Atpa = new aimq(this);
  private MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private aggs jdField_b_of_type_Aggs;
  private AIOAnimationConatiner jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  private ChatXListView jdField_b_of_type_ComTencentMobileqqBubbleChatXListView;
  ScrollerRunnable jdField_b_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  public Runnable b;
  private List<ChatMessage> jdField_b_of_type_JavaUtilList;
  public MqqHandler b;
  private Runnable c;
  public long e;
  private long jdField_f_of_type_Long;
  private RelativeLayout jdField_f_of_type_AndroidWidgetRelativeLayout;
  private RelativeLayout jdField_g_of_type_AndroidWidgetRelativeLayout;
  String jdField_g_of_type_JavaLangString;
  public String h;
  private ImageView jdField_l_of_type_AndroidWidgetImageView;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  View n;
  private View o;
  private final int q = 300;
  private int r;
  private int s;
  
  public aimn(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_b_of_type_MqqOsMqqHandler = new aimo(this);
    this.jdField_c_of_type_JavaLangRunnable = new MultiForwardChatPie.4(this);
  }
  
  private void a(View paramView, int paramInt, blir paramblir)
  {
    if (paramView == null)
    {
      paramblir.dismiss();
      return;
    }
    String str = paramblir.a(paramInt);
    if (str == null)
    {
      paramblir.dismiss();
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      paramblir.dismiss();
      return;
    }
    if (str.equals(paramView.getResources().getString(2131692962)))
    {
      axpm.a("0X8009AB5");
      d(this.jdField_e_of_type_Long);
    }
    paramblir.dismiss();
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(24);
    if ((this.jdField_c_of_type_Bjbs == null) || (!this.jdField_c_of_type_Bjbs.isShowing())) {}
    do
    {
      return;
      if ((paramBoolean) && (paramObject != null) && (axpf.a().jdField_a_of_type_Int == 6))
      {
        this.jdField_c_of_type_Bjbs.dismiss();
        axpf.a().b.clear();
        axpf.a().b.putAll((Map)paramObject);
        ((agvi)this.jdField_a_of_type_Aguw.a(11)).a((Map)paramObject, axpf.a().jdField_a_of_type_JavaUtilArrayList, axpf.a().jdField_a_of_type_Int);
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("MultiMsg_TAG", 4, "handleMultiFavorite = " + paramObject);
  }
  
  private void bp()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    ahzr localahzr = (ahzr)a(49);
    if (localahzr != null) {
      localahzr.a(7);
    }
  }
  
  private void d(long paramLong)
  {
    ThreadManagerV2.post(new MultiForwardChatPie.9(this, paramLong), 8, null, true);
  }
  
  private void d(View paramView)
  {
    paramView = blir.c(paramView.getContext());
    paramView.b(2131692962);
    paramView.c(2131690580);
    paramView.a(new aimu(this, paramView));
    paramView.show();
  }
  
  private void z(int paramInt)
  {
    ambz localambz = (ambz)a(4);
    if (localambz != null) {
      localambz.a(paramInt);
    }
  }
  
  protected boolean E()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130839414);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.jdField_e_of_type_AndroidWidgetTextView.getCompoundDrawables();
      this.s = this.jdField_e_of_type_AndroidWidgetTextView.getCompoundDrawablePadding();
      this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
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
      this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.s);
      this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  public void H()
  {
    this.i = 9;
    z(12);
    this.j = null;
    this.jdField_k_of_type_AndroidViewView = null;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 0;
    this.jdField_b_of_type_Aggs.c();
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    aq();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    ahzr localahzr = (ahzr)a(49);
    if (localahzr != null) {
      localahzr.a(13);
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
    z(10);
  }
  
  public void M()
  {
    QQLiveImage.pauseAll(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    AbstractGifImage.pauseAll();
    this.i = 5;
    z(9);
  }
  
  public void P()
  {
    if (this.y) {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 800L);
    }
    if (this.y)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.postDelayed(new MultiForwardChatPie.5(this), 600L);
      this.y = false;
    }
    for (;;)
    {
      QQLiveImage.resumeAll(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      AbstractGifImage.resumeAll();
      this.i = 4;
      z(5);
      return;
      this.jdField_b_of_type_Aggs.notifyDataSetChanged();
    }
  }
  
  public azpp a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new aimw(this, this.jdField_e_of_type_Long);
    case 1: 
      return new aimw(this, this.jdField_e_of_type_Long);
    }
    return new aimv(this);
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
      paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131718523));
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
    paramMessageRecord = this.jdField_b_of_type_Aggs.a();
    if (paramMessageRecord != null)
    {
      Iterator localIterator = paramMessageRecord.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramMessageRecord = (ChatMessage)localIterator.next();
      } while ((adak.b(paramMessageRecord)) || (adak.a(paramMessageRecord)) || ((paramMessageRecord instanceof MessageForSafeGrayTips)) || (paramMessageRecord.shmsgseq != paramLong));
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
        if ((paramMessageRecord == null) || (avpe.a(paramMessageRecord))) {
          break label302;
        }
        paramInt2 = this.jdField_b_of_type_Aggs.a(paramMessageRecord.uniseq);
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
            QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, anzj.a(2131705893), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          }
        } while (!QLog.isColorLevel());
        QLog.d("MultiForwardChatPie", 2, new Object[] { "pos is -1, msgtype:", Integer.valueOf(paramMessageRecord.msgtype) });
        return;
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131697020, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
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
    this.y = true;
    this.S = BaseChatItemLayout.a;
    BaseChatItemLayout.a = false;
    this.H = ThemeUtil.isDefaultOrDIYTheme(false);
    this.i = 2;
    Object localObject1 = (ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362291);
    ((ViewGroup)localObject1).removeView(this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131376925));
    Object localObject2 = View.inflate(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131558625, null);
    ((View)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject1).addView((View)localObject2, 0);
    this.r = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("callback_type", 1);
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("multi_url");
    this.jdField_e_of_type_Long = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getLongExtra("multimsg_uniseq", 0L);
    this.h = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("multi_title");
    if (TextUtils.isEmpty(this.h)) {
      this.h = anzj.a(2131705892);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg_TAG.Nest", 4, "MultiForwardActivity.doOnCreate ResID = " + this.jdField_g_of_type_JavaLangString + "  msg.uniseq = " + this.jdField_e_of_type_Long + " downCallBackType" + this.r);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO = ((NavBarAIO)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131376731));
    this.jdField_k_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131376732));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369042));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369056));
    this.d = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369051));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369452));
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().density;
    agej.a(this.jdField_b_of_type_AndroidWidgetImageView, 0, 0, 0, (int)(50.0F * this.jdField_a_of_type_Float + 0.5F));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131379635));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378993));
    localObject2 = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      i = agej.a(64.0F, this.jdField_a_of_type_AndroidViewViewGroup.getResources());
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = i;
      ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131705890));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378936));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131379026));
    this.d.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131690559));
    c(false);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131371520));
    this.jdField_g_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131371518));
    this.jdField_l_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131371528));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131371517));
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131371525));
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(false);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setLongClickable(true);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setDelAnimationDuration(300L);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362696));
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
    axpf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject2, i, this.jdField_e_of_type_Long);
    if (localObject1 != null) {
      axpf.a().a(((MessageRecord)localObject1).issend);
    }
    for (;;)
    {
      this.o = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.o.setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDisplayMetrics())));
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.o);
      this.jdField_b_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
      this.jdField_b_of_type_Aggs = new aggs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
      if (this.n == null)
      {
        this.n = new View(this.jdField_a_of_type_AndroidContentContext);
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011);
        this.n.setLayoutParams(new AbsListView.LayoutParams(-1, i));
        this.n.setId(2131362426);
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.n, null, false);
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeaderTop(i);
      }
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_b_of_type_Aggs);
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2131558931, null);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aggu = new aggu();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(BaseApplicationImpl.getContext());
      if (aggu.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aggu)) {
        this.jdField_f_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aggu.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      ThreadManager.post(new MultiForwardChatPie.2(this), 8, null, true);
      this.jdField_e_of_type_AndroidWidgetTextView.setSingleLine(false);
      this.jdField_e_of_type_AndroidWidgetTextView.setMaxLines(2);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(16.0F);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.h);
      if (this.H) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850099);
      this.jdField_k_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166987);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      i = 2130840291;
      if (this.H) {
        i = 2130843670;
      }
      ((ImageView)localObject1).setImageResource(i);
      ((ImageView)localObject1).setContentDescription(anzj.a(2131705889));
      ((ImageView)localObject1).setVisibility(0);
      ((ImageView)localObject1).setOnClickListener(new aimt(this));
      ap();
      localObject1 = (ahzr)a(49);
      if (localObject1 != null) {
        ((ahzr)localObject1).a(3);
      }
      return true;
      axpf.a().a(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850100);
    this.jdField_k_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!TextUtils.isEmpty(this.jdField_c_of_type_AndroidWidgetTextView.getText())) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166988);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void ap()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Atpa);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anua);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aojs);
  }
  
  public void aq()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Atpa);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anua);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aojs);
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
  
  public void bo()
  {
    Object localObject2 = axpf.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_Long);
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
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - this.jdField_f_of_type_Long));
      }
      axpf.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaUtilList, true);
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
        paramView = agej.a(paramView);
      } while (!(paramView instanceof ahtx));
      paramView = (ahtx)paramView;
    } while (paramView.a == null);
    paramView.a.d();
  }
  
  public boolean i()
  {
    ambz localambz = (ambz)a(4);
    if ((localambz != null) && (localambz.a())) {
      return true;
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    BaseChatItemLayout.a = this.S;
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
      paramAbsListView = (ahzr)a(49);
      if (paramAbsListView != null) {
        paramAbsListView.a(19);
      }
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
 * Qualified Name:     aimn
 * JD-Core Version:    0.7.0.1
 */