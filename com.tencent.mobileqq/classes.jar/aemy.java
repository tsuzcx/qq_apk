import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.10;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.12;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.14;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.15;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.16;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.7;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.8;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.lightGame.DotPollingView;
import com.tencent.mobileqq.apollo.lightGame.QuickInputTipsBar;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForCmGameTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class aemy
  extends BaseChatPie
  implements aizp
{
  public static boolean U;
  public boolean T;
  private boolean V;
  private boolean W;
  private boolean X;
  private boolean Y;
  private boolean Z;
  private aenk jdField_a_of_type_Aenk;
  private aenl jdField_a_of_type_Aenl;
  private aizb jdField_a_of_type_Aizb;
  protected akat a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aene(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new bfob(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
  private DotPollingView jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView;
  private QuickInputTipsBar jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar;
  private FrameGifView jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView;
  public MessageForCmGameTips a;
  private CornerImageView jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView;
  private boolean aa;
  private boolean ab;
  private boolean ac;
  private boolean ad;
  private boolean ae;
  private boolean af;
  private boolean ag;
  private boolean ah;
  public View.OnClickListener b;
  private FrameGifView jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView;
  private List<ApolloGameData> jdField_b_of_type_JavaUtilList;
  private bbgu c;
  private bbgu d;
  private RelativeLayout f;
  private RelativeLayout g;
  private RelativeLayout h;
  private RelativeLayout i;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private ImageView jdField_p_of_type_AndroidWidgetImageView;
  private TextView jdField_p_of_type_AndroidWidgetTextView;
  private int jdField_q_of_type_Int = 319;
  private TextView jdField_q_of_type_AndroidWidgetTextView;
  private int jdField_r_of_type_Int;
  private TextView jdField_r_of_type_AndroidWidgetTextView;
  private int jdField_s_of_type_Int;
  private TextView jdField_s_of_type_AndroidWidgetTextView;
  private int t;
  
  public aemy(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new aemz(this);
    this.jdField_a_of_type_Akat = new aenb(this);
    ((airx)paramQQAppInterface.getManager(153)).a().a(this);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    this.ag = true;
    if (paramInt1 == 0)
    {
      paramInt2 = (int)(System.currentTimeMillis() / 1000L - paramInt2);
      if (paramInt2 > 86400)
      {
        paramString = (int)Math.ceil(paramInt2 / 86400.0D) + ajya.a(2131702053);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
        u(false);
        if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777215);
        }
        if (this.Z) {
          this.jdField_a_of_type_Acyn.a();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar);
          this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = null;
        }
        this.ac = false;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "updateUserStatus status:", Integer.valueOf(paramInt1) });
      }
      return;
      if (paramInt2 > 3600)
      {
        paramString = (int)Math.ceil(paramInt2 / 3600.0D) + ajya.a(2131702057);
        break;
      }
      paramString = (int)Math.ceil(paramInt2 / 60.0D) + ajya.a(2131702051);
      break;
      this.ac = true;
      this.jdField_f_of_type_AndroidWidgetTextView.setText(ajya.a(2131719776));
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777215);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16777215, 500L);
      }
    }
  }
  
  private void a(String paramString, aenl paramaenl, int paramInt)
  {
    boolean bool;
    if (paramInt == 4)
    {
      bool = true;
      this.ab = bool;
      this.af = true;
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777215);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16777215, 500L);
      }
      if (this.h == null) {
        break label204;
      }
      if (paramInt != 1) {
        break label110;
      }
      this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_q_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView.setVisibility(0);
      this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label110:
    do
    {
      return;
      bool = false;
      break;
      if (paramInt == 2)
      {
        this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_q_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView.setVisibility(8);
        this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
      }
      this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_q_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView.setVisibility(8);
      this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      if (paramaenl == null)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "[updateFriendAndShield] info is null.");
        return;
      }
      this.jdField_a_of_type_Aenl = paramaenl;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[updateFriendAndShield] friUin:" + paramString + ", " + paramaenl.toString());
      }
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 0);
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null)
      {
        paramString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
        bool = paramString.getBooleanExtra("key_show_one_more_page", false);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[updateFriendAndShield] show one more page:", Boolean.valueOf(bool) });
        }
        if (bool)
        {
          paramString = paramString.getStringExtra("key_req_data");
          a(ApolloUtil.a(paramString, "gameId"), ApolloUtil.a(paramString, "scoreState"), paramString);
        }
      }
      if ((!TextUtils.isEmpty(paramaenl.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null))
      {
        paramString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uinname");
        if ((TextUtils.isEmpty(paramString)) && (this.e != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString;
          this.e.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        }
      }
    } while (paramaenl.jdField_c_of_type_Int == 4);
    label204:
    this.h = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558790, null));
    this.h.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)this.h.findViewById(2131368488));
    this.o = ((TextView)this.h.findViewById(2131378265));
    this.jdField_p_of_type_AndroidWidgetTextView = ((TextView)this.h.findViewById(2131363455));
    this.jdField_q_of_type_AndroidWidgetTextView = ((TextView)this.h.findViewById(2131378421));
    this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView = ((DotPollingView)this.h.findViewById(2131365378));
    this.jdField_r_of_type_AndroidWidgetTextView = ((TextView)this.h.findViewById(2131363454));
    this.jdField_s_of_type_AndroidWidgetTextView = ((TextView)this.h.findViewById(2131378327));
    this.jdField_p_of_type_AndroidWidgetImageView = ((ImageView)this.h.findViewById(2131368684));
    this.l = ((TextView)this.h.findViewById(2131378050));
    this.i = ((RelativeLayout)this.h.findViewById(2131375386));
    this.m = ((TextView)this.h.findViewById(2131378094));
    this.n = ((TextView)this.h.findViewById(2131378069));
    if ((paramaenl.jdField_a_of_type_Int <= 0) && (TextUtils.isEmpty(paramaenl.jdField_c_of_type_JavaLangString)) && (paramaenl.jdField_b_of_type_Int <= 0))
    {
      this.n.setVisibility(0);
      label743:
      this.l.setText(paramaenl.jdField_a_of_type_Int + ajya.a(2131702055));
      this.m.setText(paramaenl.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(actj.a(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageURL(paramaenl.d);
      if (!TextUtils.isEmpty(paramaenl.jdField_a_of_type_JavaLangString)) {
        break label1253;
      }
      this.o.setText(paramaenl.e);
      label840:
      this.jdField_p_of_type_AndroidWidgetTextView.setBackgroundDrawable(aize.a(this.jdField_a_of_type_AndroidContentContext, actj.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), "#000000"));
      this.jdField_p_of_type_AndroidWidgetTextView.setTextColor(aize.a(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
      this.jdField_r_of_type_AndroidWidgetTextView.setBackgroundDrawable(aize.a(this.jdField_a_of_type_AndroidContentContext, actj.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(23.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), "#000000"));
      this.jdField_r_of_type_AndroidWidgetTextView.setTextColor(aize.a(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
      this.jdField_p_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_r_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (paramaenl.jdField_c_of_type_Int != 1) {
        break label1267;
      }
      this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView.setVisibility(0);
      this.jdField_q_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(8);
      label1043:
      paramString = new RelativeLayout.LayoutParams(-1, actj.a(66.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramString.addRule(3, 2131375329);
      if (!this.I) {
        break label1368;
      }
    }
    label1368:
    for (paramString.topMargin -= actj.a(3.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());; paramString.topMargin = 0)
    {
      this.m.getViewTreeObserver().addOnPreDrawListener(new aenj(this, paramaenl));
      this.jdField_d_of_type_AndroidViewViewGroup.addView(this.h, paramString);
      if (((this.jdField_a_of_type_Acup.a().size() != 0) && (!(this.jdField_a_of_type_Acup.a().get(0) instanceof MessageForCmGameTips))) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.needTopPadding = true;
      this.jdField_a_of_type_Acup.notifyDataSetChanged();
      return;
      if (paramaenl.jdField_a_of_type_Int > 0) {
        this.l.setVisibility(0);
      }
      if (!TextUtils.isEmpty(paramaenl.jdField_c_of_type_JavaLangString)) {
        this.i.setVisibility(0);
      }
      if ((paramaenl.jdField_b_of_type_Int != 1) && (paramaenl.jdField_b_of_type_Int != 2)) {
        break label743;
      }
      this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(0);
      break label743;
      label1253:
      this.o.setText(paramaenl.jdField_a_of_type_JavaLangString);
      break label840;
      label1267:
      if (paramaenl.jdField_c_of_type_Int == 2)
      {
        this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_q_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView.setVisibility(8);
        this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(0);
        break label1043;
      }
      this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_q_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView.setVisibility(8);
      break label1043;
    }
  }
  
  private void a(List<aizq> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    int j = actj.a(7.0F, a().getResources());
    if (bbdh.a() <= 2.0F) {
      j = actj.a(9.0F, a().getResources());
    }
    aizq localaizq = aizi.a(paramInt);
    if (localaizq != null)
    {
      paramList.add(localaizq);
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      localaizq = new aizq();
      localaizq.jdField_a_of_type_Int = 1;
      localaizq.jdField_a_of_type_JavaLangCharSequence = ajya.a(2131702046);
      paramList.add(localaizq);
      return;
    case 7: 
      localaizq = new aizq();
      localaizq.jdField_a_of_type_Int = 7;
      localaizq.jdField_a_of_type_JavaLangCharSequence = new aykk(aylc.c(193), 3, j);
      paramList.add(localaizq);
      return;
    case 6: 
      localaizq = new aizq();
      localaizq.jdField_a_of_type_Int = 6;
      localaizq.jdField_a_of_type_JavaLangCharSequence = ajya.a(2131702061);
      paramList.add(localaizq);
      return;
    case 5: 
      localaizq = new aizq();
      localaizq.jdField_a_of_type_Int = 5;
      localaizq.jdField_a_of_type_JavaLangCharSequence = ajya.a(2131702056);
      paramList.add(localaizq);
      return;
    case 4: 
      localaizq = new aizq();
      localaizq.jdField_a_of_type_Int = 4;
      localaizq.jdField_a_of_type_JavaLangCharSequence = new aykk(aylc.c(209), 3, j);
      paramList.add(localaizq);
      return;
    case 3: 
      localaizq = new aizq();
      localaizq.jdField_a_of_type_Int = 3;
      localaizq.jdField_a_of_type_JavaLangCharSequence = ajya.a(2131702054);
      paramList.add(localaizq);
      return;
    case 2: 
      localaizq = new aizq();
      localaizq.jdField_a_of_type_Int = 2;
      localaizq.jdField_a_of_type_JavaLangCharSequence = new aykk(aylc.c(192), 3, j);
      paramList.add(localaizq);
      return;
    }
    localaizq = new aizq();
    localaizq.jdField_a_of_type_Int = 1;
    localaizq.jdField_a_of_type_JavaLangCharSequence = ajya.a(2131702045);
    paramList.add(localaizq);
  }
  
  private void bq()
  {
    ThreadManagerV2.excute(new CmGameChatPie.8(this), 16, null, false);
  }
  
  private void br()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (new Random().nextBoolean()) && (aizr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      aizi localaizi = ((airx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a();
      int j = (int)(System.currentTimeMillis() / 1000L);
      this.jdField_r_of_type_Int = j;
      this.jdField_s_of_type_Int = j;
      localaizi.a(this.jdField_a_of_type_Aizb.jdField_a_of_type_Int, this.jdField_r_of_type_Int);
    }
  }
  
  private void bs()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkTipsBarLayout");
    }
    if (this.ad) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, "checkTipsBarLayout mQuickBarClickRemoved");
    }
    do
    {
      return;
      if ((!this.af) || (!this.ag) || (!this.ae))
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, new Object[] { "checkTipsBarLayout mMateStateChecked:", Boolean.valueOf(this.af), " mOnLineStateChecked:", Boolean.valueOf(this.ag), " mAudioOnLineChecked:", Boolean.valueOf(this.ae) });
        return;
      }
      if (this.ac) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar);
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = null;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkTipsBarLayout !mFriendOnLine");
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = new QuickInputTipsBar(a(), null);
      localObject = new RelativeLayout.LayoutParams(-1, actj.a(48.0F, a().getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131368187);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar.setTipsClickListener(this);
    }
    Object localObject = new ArrayList();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, new Object[] { "checkTipsBarLayout mIsMate:", Boolean.valueOf(this.ab), " mFriendAudioOnLine:", Boolean.valueOf(this.aa), " sLaunchGameFromAIO:", Boolean.valueOf(U) });
    if (this.ab) {
      if (this.aa) {
        if (U)
        {
          a((List)localObject, 7);
          a((List)localObject, 5);
          a((List)localObject, 3);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar.a((List)localObject);
      this.jdField_a_of_type_Acyn.a(actj.a(48.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), false, "cmGame_addFooter", 0);
      this.Z = true;
      return;
      a((List)localObject, 6);
      a((List)localObject, 4);
      a((List)localObject, 2);
      continue;
      if (U)
      {
        a((List)localObject, 7);
        a((List)localObject, 1);
        a((List)localObject, 3);
      }
      else
      {
        a((List)localObject, 6);
        a((List)localObject, 1);
        a((List)localObject, 2);
        continue;
        a((List)localObject, 0);
        if (this.aa)
        {
          if (U)
          {
            a((List)localObject, 5);
            a((List)localObject, 3);
          }
          else
          {
            a((List)localObject, 4);
            a((List)localObject, 2);
          }
        }
        else
        {
          a((List)localObject, 1);
          if (U) {
            a((List)localObject, 3);
          } else {
            a((List)localObject, 2);
          }
        }
      }
    }
  }
  
  public boolean D()
  {
    return this.W;
  }
  
  public void G()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[doOnDestory] chatPie:" + this + "," + this.V);
    }
    this.T = false;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips, false);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips = null;
    }
    airx localairx = (airx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    localairx.a().a();
    localairx.a().b(this.jdField_a_of_type_Aenk);
    localairx.a().b("page_tag_aio");
    if (this.V)
    {
      localairx.a().d(a());
      this.V = false;
    }
    this.jdField_a_of_type_Aenk = null;
    if (this.jdField_a_of_type_Aizb != null)
    {
      this.jdField_a_of_type_Aizb.dismiss();
      this.jdField_a_of_type_Aizb = null;
    }
    super.G();
    this.W = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    U = false;
    if (this.c != null) {
      this.c.dismiss();
    }
    if (this.jdField_d_of_type_Bbgu != null) {
      this.jdField_d_of_type_Bbgu.dismiss();
    }
    if (this.jdField_f_of_type_AndroidWidgetRelativeLayout != null)
    {
      v(true);
      this.jdField_f_of_type_AndroidWidgetRelativeLayout = null;
      this.ah = false;
    }
    if (this.g != null)
    {
      w(true);
      this.g = null;
      this.ah = false;
    }
    localairx.a().a(null);
    localairx.a().c(a(), 319);
  }
  
  public void J()
  {
    super.J();
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("key_show_one_more_page", false))) {
      bo();
    }
  }
  
  public void K()
  {
    super.K();
    this.Y = true;
  }
  
  public void L()
  {
    super.L();
    this.X = true;
  }
  
  public void O()
  {
    super.O();
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    airx localairx = (airx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if (this.X) {
      localairx.a().a();
    }
    this.X = false;
    this.Y = false;
    if (U)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777215);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16777215, 500L);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "CmGameTemp_CmGameChatPie";
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[showOneMoreGameView] gameId:", Integer.valueOf(paramInt1), ",isWinner:", Integer.valueOf(paramInt2), ",reqData:", paramString });
    }
    this.t += 1;
    if (this.jdField_a_of_type_Aenl != null)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().putExtra("key_show_one_more_page", false);
      ThreadManager.getUIHandler().post(new CmGameChatPie.12(this, paramInt1, paramInt2, paramString));
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().putExtra("key_show_one_more_page", true);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().putExtra("key_req_data", paramString);
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[showOneMoreGameView] friendInfo is null,update intent extra param");
  }
  
  public void a(int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    ajrd localajrd = new ajrd();
    Object localObject = (ajmu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    String str = ajya.a(2131702058);
    ApolloGameData localApolloGameData = ((ajmu)localObject).a(paramInt);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((ajmu)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label184;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label184:
    for (;;)
    {
      int j = localApolloGameData.actionId;
      localajrd.jdField_b_of_type_JavaLangString = localApolloGameData.name;
      for (;;)
      {
        localajrd.jdField_a_of_type_JavaLangString = str;
        localajrd.jdField_b_of_type_Int = j;
        localajrd.jdField_a_of_type_Long = paramLong;
        localajrd.jdField_a_of_type_Int = paramInt;
        localajrd.d = 3;
        localajrd.e = 0;
        aize.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localajrd);
        return;
        localajrd.jdField_b_of_type_JavaLangString = ajya.a(2131702052);
        j = 0;
      }
    }
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      return;
    }
    CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(paramInt, true, "message", paramLong, 1, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_q_of_type_Int, null);
    localStartCheckParam.mTempAIOUin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    localStartCheckParam.mTempAIONickName = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    localStartCheckParam.disableMinGame = true;
    localStartCheckParam.mRobotOpenId = paramString;
    localStartCheckParam.src = 318001;
    ApolloGameUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localStartCheckParam);
    U = true;
    aize.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramInt, paramLong);
  }
  
  public void a(aizm paramaizm)
  {
    if (paramaizm == null)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "[addTopGame] gameMap is null.");
      return;
    }
    if ((paramaizm.jdField_b_of_type_JavaUtilList.size() < 3) || (paramaizm.jdField_b_of_type_JavaUtilList.size() % 3 != 0))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "[addTopGame] game size is not a multiple of 3.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "[addTopGame] alreadyAdd:" + this.T);
    }
    List localList = this.jdField_a_of_type_Acup.a();
    if (!this.T)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips = ((MessageForCmGameTips)axas.a(-7004));
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.msgtype = -7004;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.mIsParsed = true;
      if ((this.h != null) && (localList.size() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.needTopPadding = true;
      }
      axas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", 1036);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.gameInfo = paramaizm;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), true, false, false, true);
      localList.add(this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips);
      this.T = true;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.10(this));
  }
  
  public void a(aizq paramaizq)
  {
    if ((paramaizq != null) && (paramaizq.jdField_a_of_type_JavaLangCharSequence != null) && (!this.ad))
    {
      aanz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramaizq.jdField_a_of_type_JavaLangCharSequence.toString());
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar.a();
      }
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777216);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16777216, 600L);
        this.ad = true;
      }
      VipUtils.a(null, "cmshow", "Apollo", "quickMessage", 0, 0, new String[] { String.valueOf(paramaizq.jdField_a_of_type_Int) });
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    case 4: 
      VipUtils.a(null, "cmshow", "Apollo", "picClick", 0, 0, new String[] { "" });
      return;
    case 3: 
      VipUtils.a(null, "cmshow", "Apollo", "expressionClick", 0, 0, new String[] { "" });
      return;
    }
    VipUtils.a(null, "cmshow", "Apollo", "gameClick", 0, 0, new String[] { "" });
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramInt == 3)
    {
      paramString1 = new aqvb(paramString1, paramString2, ajya.a(2131702049), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5040, 2359297, awzy.a());
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
      aqvc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2);
    }
    String str2;
    SharedPreferences localSharedPreferences;
    long l1;
    do
    {
      do
      {
        return;
        str2 = "apollo_add_playMate_gray_tip" + paramString2 + "_" + paramString1 + "_" + paramInt;
        localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
      } while (!localSharedPreferences.getBoolean(str2, true));
      l1 = awzy.a();
      str1 = "";
      if (paramInt != 0) {
        break;
      }
    } while ((this.jdField_a_of_type_Aenl != null) && (this.jdField_a_of_type_Aenl.jdField_c_of_type_Int == 4));
    String str1 = ajya.a(2131702062);
    for (;;)
    {
      paramString1 = new aqvb(paramString1, paramString2, str1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5040, 2359297, l1);
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
      aqvc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2);
      localSharedPreferences.edit().putBoolean(str2, false).commit();
      return;
      if (paramInt == 1) {
        str1 = ajya.a(2131702060) + paramString3 + ajya.a(2131702050);
      } else if (paramInt == 2) {
        str1 = ajya.a(2131702047) + paramString3 + ajya.a(2131702048);
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[doOnCreate] chatPie:" + this + "," + this.V);
    }
    this.G = false;
    this.V = true;
    Object localObject = (airx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    ((airx)localObject).a().a("page_tag_aio");
    ((airx)localObject).a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "join");
    localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = localObject;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    return super.a(paramBoolean);
  }
  
  public void aX()
  {
    super.aX();
    this.e.setMaxEms(7);
    this.e.setEllipsize(TextUtils.TruncateAt.END);
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView = new FrameGifView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130838954);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setPlayLoop(true);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(100, null, "https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip", ajrs.a("https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip"), false);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setOnClickListener(new aena(this));
      localObject = new RelativeLayout.LayoutParams(actj.a(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView, (ViewGroup.LayoutParams)localObject);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView = new FrameGifView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130838955);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setPlayLoop(true);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(100, null, "https://cmshow.gtimg.cn/client/img/apollo_game_audio_micSmall.zip", ajrs.a("https://cmshow.gtimg.cn/client/img/apollo_game_audio_micSmall.zip"), false);
      localObject = new LinearLayout.LayoutParams(actj.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setPadding(0, 0, 5, 0);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      ((ViewGroup)this.e.getParent()).addView(this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView, (ViewGroup.LayoutParams)localObject);
    }
    if (!aiyp.b)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
    }
  }
  
  public void ae()
  {
    super.ae();
    this.jdField_a_of_type_Boolean = false;
    c(true);
    this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
  }
  
  public void ak()
  {
    super.ak();
    int j = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (j == 21) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1036)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(21);
    }
  }
  
  public void an()
  {
    super.an();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Akat);
  }
  
  public void ao()
  {
    super.ao();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akat);
  }
  
  public List<ApolloGameData> b()
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return null;
    }
    return new ArrayList(this.jdField_b_of_type_JavaUtilList);
  }
  
  public void b(List<ApolloGameData> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  public void bo()
  {
    SharedPreferences localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    if (localSharedPreferences.getBoolean("apollo_audio_intro", true))
    {
      this.g = new RelativeLayout(a());
      this.g.setBackgroundColor(Color.parseColor("#cf000000"));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      ImageView localImageView = new ImageView(a());
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setId(2131362596);
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = actj.a(200.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = actj.a(100.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      Object localObject2 = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_audio_intro_btn.png", (URLDrawable.URLDrawableOptions)localObject1);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setImageDrawable((Drawable)localObject2);
      localImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localObject2 = new RelativeLayout.LayoutParams(actj.a(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + actj.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(45.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      this.g.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
      localImageView = new ImageView(a());
      localObject2 = new RelativeLayout.LayoutParams(actj.a(210.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131362596);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, actj.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      localObject1 = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_audio_intro_txt.png", (URLDrawable.URLDrawableOptions)localObject1);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setImageDrawable((Drawable)localObject1);
      this.g.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
      this.ah = true;
      this.g.setOnClickListener(new aenc(this));
      ((FrameLayout)a().getWindow().getDecorView()).addView(this.g, localLayoutParams);
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, "[showOpenAudioIntro] already show audio intro.");
      localSharedPreferences.edit().putBoolean("apollo_audio_intro", false).commit();
    }
  }
  
  public void bp()
  {
    if (this.ah) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "[showAddPlaymateIntro] isShow intro return.");
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      if (this.jdField_a_of_type_Aenl == null)
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "[showAddPlaymateIntro] friendInfo is null return.");
        return;
      }
      localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    } while ((!localSharedPreferences.getBoolean("apollo_add_playMate_intro", true)) || (this.jdField_a_of_type_Aenl.jdField_c_of_type_Int != 0));
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(a());
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#cf000000"));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.t = 0;
    ImageView localImageView = new ImageView(a());
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setId(2131362595);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = actj.a(200.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = actj.a(100.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/add_playmate_intro.png", (URLDrawable.URLDrawableOptions)localObject));
    localImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(actj.a(91.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(41.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localLayoutParams1.addRule(11);
    localLayoutParams1.addRule(10);
    localLayoutParams1.setMargins(0, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + actj.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.addView(localImageView, localLayoutParams1);
    localImageView = new ImageView(a());
    localLayoutParams1 = new RelativeLayout.LayoutParams(actj.a(210.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localLayoutParams1.addRule(3, 2131362595);
    localLayoutParams1.addRule(11);
    localLayoutParams1.setMargins(0, 0, actj.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
    localObject = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/add_playmate_intro1.png", (URLDrawable.URLDrawableOptions)localObject);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setImageDrawable((Drawable)localObject);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.addView(localImageView, localLayoutParams1);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aend(this));
    QLog.i(this.jdField_a_of_type_JavaLangString, 1, "[showAddPlaymateIntro] already show addplaymate intro.");
    ((FrameLayout)a().getWindow().getDecorView()).addView(this.jdField_f_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
    this.ah = true;
    localSharedPreferences.edit().putBoolean("apollo_add_playMate_intro", false).commit();
  }
  
  public void c(long paramLong)
  {
    ThreadManagerV2.getUIHandlerV2().post(new CmGameChatPie.16(this, paramLong));
  }
  
  public void d(Intent paramIntent)
  {
    super.d(paramIntent);
    bbkj.a(null, "AIO_updateSession_business");
    if (this.jdField_a_of_type_Aenk == null) {
      this.jdField_a_of_type_Aenk = new aenk(this);
    }
    ((airx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().a(this.jdField_a_of_type_Aenk);
    bbkj.a("AIO_updateSession_business", null);
    this.W = true;
    bq();
  }
  
  public void e(Intent paramIntent)
  {
    super.e(paramIntent);
  }
  
  public boolean e()
  {
    return !A();
  }
  
  public void f(String paramString)
  {
    if (this.h != null)
    {
      this.jdField_d_of_type_AndroidViewViewGroup.removeView(this.h);
      a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Aenl.jdField_a_of_type_JavaLangString, 2);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.needTopPadding = false;
        this.jdField_a_of_type_Acup.notifyDataSetChanged();
      }
    }
  }
  
  public void g(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 16777218;
    localMessage.obj = paramString;
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777218);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      bs();
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar);
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = null;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar);
          this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = null;
          continue;
          Object localObject = (String)paramMessage.obj;
          if ("dialog_type_permission".equals(localObject))
          {
            if (this.jdField_d_of_type_Bbgu == null)
            {
              localObject = bbdj.a(a(), 230).setMessage(a().getString(2131695961)).setTitle(a().getString(2131695962)).setNegativeButton(2131690596, new aeng(this));
              if (!muc.a(a())) {
                break label218;
              }
            }
            label218:
            for (int j = 2131695963;; j = 2131695964)
            {
              this.jdField_d_of_type_Bbgu = ((bbgu)localObject).setPositiveButton(j, new aenf(this));
              this.jdField_d_of_type_Bbgu.show();
              break;
            }
          }
          if ("dialog_type_confirm".equals(localObject))
          {
            if (this.c == null) {
              this.c = bbdj.a(a(), 230).setMessage(ajya.a(2131702059)).setPositiveButton(a().getString(2131694794), new aeni(this)).setNegativeButton(a().getString(2131690596), new aenh(this));
            }
            this.c.show();
          }
        }
      }
    }
  }
  
  public boolean i()
  {
    if (this.ah)
    {
      v(true);
      w(true);
      return true;
    }
    return super.i();
  }
  
  public void k()
  {
    Object localObject = (airx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    aizi localaizi = ((airx)localObject).a();
    localaizi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1);
    localaizi.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localObject = ((airx)localObject).a();
    if ((aiyp.jdField_a_of_type_Boolean) && (!((aiyp)localObject).b())) {
      ((aiyp)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 319);
    }
    if ((!TextUtils.isEmpty(((aiyp)localObject).a())) && (((aiyp)localObject).a().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130838956);
    }
    localaizi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 319);
    localaizi.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      VipUtils.a(null, "cmshow", "Apollo", "returnBtn", 0, 0, new String[] { "" });
      continue;
      VipUtils.a(null, "cmshow", "Apollo", "dataEntry", 0, 0, new String[] { "" });
      continue;
      VipUtils.a(null, "cmshow", "Apollo", "inputBoxClick", 0, 0, new String[] { "" });
    }
  }
  
  public void p()
  {
    super.p();
  }
  
  public void t(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new CmGameChatPie.14(this, paramBoolean));
  }
  
  public void u(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new CmGameChatPie.15(this, paramBoolean));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "updateFriendVoiceStatus isVoiceOpen:", Boolean.valueOf(paramBoolean) });
    }
    this.aa = paramBoolean;
    this.ae = true;
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777215);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16777215, 500L);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof MessageRecord)) && ((paramObject instanceof ChatMessage)))
    {
      ChatMessage localChatMessage = (ChatMessage)paramObject;
      if (localChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[update] get friend message,update friend status");
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        Message localMessage = Message.obtain();
        localMessage.what = 1;
        localMessage.obj = localChatMessage.selfuin;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 60000L);
        ThreadManager.getUIHandler().post(new CmGameChatPie.7(this));
      }
    }
    super.update(paramObservable, paramObject);
  }
  
  public void v(boolean paramBoolean)
  {
    if ((this.jdField_f_of_type_AndroidWidgetRelativeLayout != null) && (this.ah))
    {
      ((FrameLayout)a().getWindow().getDecorView()).removeView(this.jdField_f_of_type_AndroidWidgetRelativeLayout);
      this.jdField_f_of_type_AndroidWidgetRelativeLayout = null;
      this.ah = false;
      if (paramBoolean) {
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAddFriend", 0, 0, new String[] { "2" });
      }
    }
  }
  
  public void w(boolean paramBoolean)
  {
    if ((this.g != null) && (this.ah))
    {
      ((FrameLayout)a().getWindow().getDecorView()).removeView(this.g);
      this.g = null;
      this.ah = false;
      if (paramBoolean) {
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAudio", 0, 0, new String[] { "2" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aemy
 * JD-Core Version:    0.7.0.1
 */