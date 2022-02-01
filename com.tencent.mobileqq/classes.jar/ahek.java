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
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForCmGameTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import mqq.os.MqqHandler;

public class ahek
  extends BaseChatPie
  implements alvk
{
  public static boolean c;
  private int jdField_a_of_type_Int = 319;
  private ahew jdField_a_of_type_Ahew;
  private ahex jdField_a_of_type_Ahex;
  private aluw jdField_a_of_type_Aluw;
  protected amwl a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aheq(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new bjng(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
  public View.OnClickListener a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DotPollingView jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView;
  private QuickInputTipsBar jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar;
  private FrameGifView jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView;
  public MessageForCmGameTips a;
  private CornerImageView jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private List<ApolloGameData> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FrameGifView jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView;
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public boolean b;
  private int jdField_c_of_type_Int;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int jdField_d_of_type_Int;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private boolean jdField_g_of_type_Boolean;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private boolean jdField_h_of_type_Boolean;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  
  public ahek(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahel(this);
    this.jdField_a_of_type_Amwl = new ahen(this);
    ((alnr)paramQQAppInterface.getManager(153)).a().a(this);
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView.setVisibility(8);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    case 1: 
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView.setVisibility(8);
    this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void a(ahex paramahex)
  {
    if (paramahex == null) {
      return;
    }
    if ((paramahex.jdField_a_of_type_Int <= 0) && (android.text.TextUtils.isEmpty(paramahex.jdField_c_of_type_JavaLangString)) && (paramahex.jdField_b_of_type_Int <= 0)) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramahex.jdField_a_of_type_Int + amtj.a(2131701201));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramahex.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(AIOUtils.dp2px(25.0F, this.mContext.getResources()));
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageURL(paramahex.d);
      if (!android.text.TextUtils.isEmpty(paramahex.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramahex.e);
      return;
      if (paramahex.jdField_a_of_type_Int > 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (!android.text.TextUtils.isEmpty(paramahex.jdField_c_of_type_JavaLangString)) {
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      if ((paramahex.jdField_b_of_type_Int == 1) || (paramahex.jdField_b_of_type_Int == 2)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramahex.jdField_a_of_type_JavaLangString);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    this.o = true;
    if (paramInt1 == 0)
    {
      paramInt2 = (int)(System.currentTimeMillis() / 1000L - paramInt2);
      if (paramInt2 > 86400)
      {
        paramString = (int)Math.ceil(paramInt2 / 86400.0D) + amtj.a(2131701199);
        this.mSubTilteText.setText(paramString);
        b(false);
        if (this.uiHandler != null) {
          this.uiHandler.removeMessages(16777215);
        }
        if (this.jdField_h_of_type_Boolean) {
          this.businessFooterDetector.a();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null)
        {
          this.mContent.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar);
          this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = null;
        }
        this.k = false;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, new Object[] { "updateUserStatus status:", Integer.valueOf(paramInt1) });
      }
      return;
      if (paramInt2 > 3600)
      {
        paramString = (int)Math.ceil(paramInt2 / 3600.0D) + amtj.a(2131701203);
        break;
      }
      paramString = (int)Math.ceil(paramInt2 / 60.0D) + amtj.a(2131701197);
      break;
      this.k = true;
      this.mSubTilteText.setText(amtj.a(2131718588));
      if (this.uiHandler != null)
      {
        this.uiHandler.removeMessages(16777215);
        this.uiHandler.sendEmptyMessageDelayed(16777215, 500L);
      }
    }
  }
  
  private void a(String paramString, ahex paramahex, int paramInt)
  {
    boolean bool;
    if (paramInt == 4)
    {
      bool = true;
      this.j = bool;
      this.n = true;
      if (this.uiHandler != null)
      {
        this.uiHandler.removeMessages(16777215);
        this.uiHandler.sendEmptyMessageDelayed(16777215, 500L);
      }
      if (this.jdField_c_of_type_AndroidWidgetRelativeLayout == null) {
        break label69;
      }
      a(paramInt);
    }
    label69:
    do
    {
      do
      {
        do
        {
          return;
          bool = false;
          break;
        } while (this.mActivity == null);
        if (paramahex == null)
        {
          QLog.e(this.tag, 1, "[updateFriendAndShield] info is null.");
          return;
        }
        this.jdField_a_of_type_Ahex = paramahex;
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "[updateFriendAndShield] friUin:" + paramString + ", " + paramahex.toString());
        }
        a(this.sessionInfo.curFriendUin, this.app.getCurrentUin(), this.sessionInfo.curFriendNick, 0);
        if (this.mActivity.getIntent() != null)
        {
          paramString = this.mActivity.getIntent();
          bool = paramString.getBooleanExtra("key_show_one_more_page", false);
          if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, new Object[] { "[updateFriendAndShield] show one more page:", Boolean.valueOf(bool) });
          }
          if (bool)
          {
            paramString = paramString.getStringExtra("key_req_data");
            a(ApolloUtil.a(paramString, "gameId"), ApolloUtil.a(paramString, "scoreState"), paramString);
          }
        }
        if ((!android.text.TextUtils.isEmpty(paramahex.jdField_a_of_type_JavaLangString)) && (this.mActivity.getIntent() != null))
        {
          paramString = this.mActivity.getIntent().getStringExtra("uinname");
          if ((android.text.TextUtils.isEmpty(paramString)) && (this.mTitleText != null))
          {
            this.sessionInfo.curFriendNick = paramString;
            this.mTitleText.setText(this.sessionInfo.curFriendNick);
          }
        }
      } while (paramahex.jdField_c_of_type_Int == 4);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131558904, null));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131369131));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131379724));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131363747));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131379927));
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView = ((DotPollingView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131365776));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131363746));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131379804));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131369372));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131379458));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131376566));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131379519));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131379485));
      a(paramahex);
      this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundDrawable(aluz.a(this.mContext, AIOUtils.dp2px(80.0F, this.mContext.getResources()), AIOUtils.dp2px(30.0F, this.mContext.getResources()), "#000000"));
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(aluz.a(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
      this.jdField_g_of_type_AndroidWidgetTextView.setBackgroundDrawable(aluz.a(this.mContext, AIOUtils.dp2px(60.0F, this.mContext.getResources()), AIOUtils.dp2px(23.0F, this.mContext.getResources()), "#000000"));
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(aluz.a(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      a(paramahex.jdField_c_of_type_Int);
      paramString = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(66.0F, this.mContext.getResources()));
      paramString.addRule(3, 2131376501);
      if (!this.isThemeDefault) {
        paramString.topMargin = 0;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnPreDrawListener(new ahev(this, paramahex));
      this.afRoot.addView(this.jdField_c_of_type_AndroidWidgetRelativeLayout, paramString);
    } while (((this.listAdapter.a().size() != 0) && (!(this.listAdapter.a().get(0) instanceof MessageForCmGameTips))) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips == null));
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.needTopPadding = true;
    this.listAdapter.notifyDataSetChanged();
  }
  
  private void a(List<alvl> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    int i1 = AIOUtils.dp2px(7.0F, getActivity().getResources());
    if (DeviceInfoUtil.getDesity() <= 2.0F) {
      i1 = AIOUtils.dp2px(9.0F, getActivity().getResources());
    }
    alvl localalvl = alvd.a(paramInt);
    if (localalvl != null)
    {
      paramList.add(localalvl);
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      localalvl = new alvl();
      localalvl.jdField_a_of_type_Int = 1;
      localalvl.jdField_a_of_type_JavaLangCharSequence = amtj.a(2131701192);
      paramList.add(localalvl);
      return;
    case 7: 
      localalvl = new alvl();
      localalvl.jdField_a_of_type_Int = 7;
      localalvl.jdField_a_of_type_JavaLangCharSequence = new QQText(com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(193), 3, i1);
      paramList.add(localalvl);
      return;
    case 6: 
      localalvl = new alvl();
      localalvl.jdField_a_of_type_Int = 6;
      localalvl.jdField_a_of_type_JavaLangCharSequence = amtj.a(2131701207);
      paramList.add(localalvl);
      return;
    case 5: 
      localalvl = new alvl();
      localalvl.jdField_a_of_type_Int = 5;
      localalvl.jdField_a_of_type_JavaLangCharSequence = amtj.a(2131701202);
      paramList.add(localalvl);
      return;
    case 4: 
      localalvl = new alvl();
      localalvl.jdField_a_of_type_Int = 4;
      localalvl.jdField_a_of_type_JavaLangCharSequence = new QQText(com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(209), 3, i1);
      paramList.add(localalvl);
      return;
    case 3: 
      localalvl = new alvl();
      localalvl.jdField_a_of_type_Int = 3;
      localalvl.jdField_a_of_type_JavaLangCharSequence = amtj.a(2131701200);
      paramList.add(localalvl);
      return;
    case 2: 
      localalvl = new alvl();
      localalvl.jdField_a_of_type_Int = 2;
      localalvl.jdField_a_of_type_JavaLangCharSequence = new QQText(com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(192), 3, i1);
      paramList.add(localalvl);
      return;
    }
    localalvl = new alvl();
    localalvl.jdField_a_of_type_Int = 1;
    localalvl.jdField_a_of_type_JavaLangCharSequence = amtj.a(2131701191);
    paramList.add(localalvl);
  }
  
  private void c()
  {
    ThreadManagerV2.excute(new CmGameChatPie.8(this), 16, null, false);
  }
  
  private void d()
  {
    if ((this.sessionInfo != null) && (!android.text.TextUtils.isEmpty(this.sessionInfo.curFriendUin)) && (new Random().nextBoolean()) && (alvm.a(this.sessionInfo.curFriendUin)))
    {
      alvd localalvd = ((alnr)this.app.getManager(153)).a();
      int i1 = (int)(System.currentTimeMillis() / 1000L);
      this.jdField_b_of_type_Int = i1;
      this.jdField_c_of_type_Int = i1;
      localalvd.a(this.jdField_a_of_type_Aluw.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "checkTipsBarLayout");
    }
    if (this.l) {
      QLog.i(this.tag, 1, "checkTipsBarLayout mQuickBarClickRemoved");
    }
    do
    {
      return;
      if ((!this.n) || (!this.o) || (!this.m))
      {
        QLog.d(this.tag, 1, new Object[] { "checkTipsBarLayout mMateStateChecked:", Boolean.valueOf(this.n), " mOnLineStateChecked:", Boolean.valueOf(this.o), " mAudioOnLineChecked:", Boolean.valueOf(this.m) });
        return;
      }
      if (this.k) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null)
      {
        this.mContent.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar);
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = null;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.tag, 2, "checkTipsBarLayout !mFriendOnLine");
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = new QuickInputTipsBar(getActivity(), null);
      localObject = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(48.0F, getActivity().getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131368751);
      this.mContent.addView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar.setTipsClickListener(this);
    }
    Object localObject = new ArrayList();
    QLog.d(this.tag, 1, new Object[] { "checkTipsBarLayout mIsMate:", Boolean.valueOf(this.j), " mFriendAudioOnLine:", Boolean.valueOf(this.i), " sLaunchGameFromAIO:", Boolean.valueOf(jdField_c_of_type_Boolean) });
    if (this.j) {
      if (this.i) {
        if (jdField_c_of_type_Boolean)
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
      this.businessFooterDetector.a(AIOUtils.dp2px(48.0F, this.mContext.getResources()), false, "cmGame_addFooter", 0);
      this.jdField_h_of_type_Boolean = true;
      return;
      a((List)localObject, 6);
      a((List)localObject, 4);
      a((List)localObject, 2);
      continue;
      if (jdField_c_of_type_Boolean)
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
        if (this.i)
        {
          if (jdField_c_of_type_Boolean)
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
          if (jdField_c_of_type_Boolean) {
            a((List)localObject, 3);
          } else {
            a((List)localObject, 2);
          }
        }
      }
    }
  }
  
  public List<ApolloGameData> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return new ArrayList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    SharedPreferences localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    if (localSharedPreferences.getBoolean("apollo_audio_intro", true))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getActivity());
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#cf000000"));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      ImageView localImageView = new ImageView(getActivity());
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setId(2131362755);
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = AIOUtils.dp2px(200.0F, this.mContext.getResources());
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = AIOUtils.dp2px(100.0F, this.mContext.getResources());
      Object localObject2 = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_audio_intro_btn.png", (URLDrawable.URLDrawableOptions)localObject1);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setImageDrawable((Drawable)localObject2);
      localImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localObject2 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(35.0F, this.mContext.getResources()), AIOUtils.dp2px(35.0F, this.mContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + AIOUtils.dp2px(6.0F, this.mContext.getResources()), AIOUtils.dp2px(45.0F, this.mContext.getResources()), 0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
      localImageView = new ImageView(getActivity());
      localObject2 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(210.0F, this.mContext.getResources()), AIOUtils.dp2px(70.0F, this.mContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131362755);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, AIOUtils.dp2px(40.0F, this.mContext.getResources()), 0);
      localObject1 = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_audio_intro_txt.png", (URLDrawable.URLDrawableOptions)localObject1);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
      this.p = true;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aheo(this));
      ((FrameLayout)getActivity().getWindow().getDecorView()).addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
      QLog.i(this.tag, 1, "[showOpenAudioIntro] already show audio intro.");
      localSharedPreferences.edit().putBoolean("apollo_audio_intro", false).commit();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, new Object[] { "[showOneMoreGameView] gameId:", Integer.valueOf(paramInt1), ",isWinner:", Integer.valueOf(paramInt2), ",reqData:", paramString });
    }
    this.jdField_d_of_type_Int += 1;
    if (this.jdField_a_of_type_Ahex != null)
    {
      this.mActivity.getIntent().putExtra("key_show_one_more_page", false);
      ThreadManager.getUIHandler().post(new CmGameChatPie.12(this, paramInt1, paramInt2, paramString));
    }
    do
    {
      return;
      this.mActivity.getIntent().putExtra("key_show_one_more_page", true);
      this.mActivity.getIntent().putExtra("key_req_data", paramString);
    } while (!QLog.isColorLevel());
    QLog.d(this.tag, 2, "[showOneMoreGameView] friendInfo is null,update intent extra param");
  }
  
  public void a(int paramInt, long paramLong)
  {
    if ((this.sessionInfo == null) || (this.app == null)) {
      return;
    }
    ammz localammz = new ammz();
    Object localObject = (amir)this.app.getManager(155);
    String str = amtj.a(2131701204);
    ApolloGameData localApolloGameData = ((amir)localObject).a(paramInt);
    if ((localApolloGameData != null) && (!android.text.TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((amir)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label184;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label184:
    for (;;)
    {
      int i1 = localApolloGameData.actionId;
      localammz.jdField_b_of_type_JavaLangString = localApolloGameData.name;
      for (;;)
      {
        localammz.jdField_a_of_type_JavaLangString = str;
        localammz.jdField_b_of_type_Int = i1;
        localammz.jdField_a_of_type_Long = paramLong;
        localammz.jdField_a_of_type_Int = paramInt;
        localammz.jdField_d_of_type_Int = 3;
        localammz.e = 0;
        aluz.a(this.app, this.sessionInfo.curFriendUin, localammz);
        return;
        localammz.jdField_b_of_type_JavaLangString = amtj.a(2131701198);
        i1 = 0;
      }
    }
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    if (this.sessionInfo == null) {
      return;
    }
    CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(paramInt, true, "message", paramLong, 1, 0, this.sessionInfo.curType, ApolloGameUtil.a(this.app, this.sessionInfo.curType, this.sessionInfo.curFriendUin), this.sessionInfo.curFriendUin, this.jdField_a_of_type_Int, null);
    localStartCheckParam.mTempAIOUin = this.sessionInfo.curFriendUin;
    localStartCheckParam.mTempAIONickName = this.sessionInfo.curFriendNick;
    localStartCheckParam.disableMinGame = true;
    localStartCheckParam.mRobotOpenId = paramString;
    localStartCheckParam.src = 318001;
    ApolloGameUtil.a(this.mActivity, localStartCheckParam);
    jdField_c_of_type_Boolean = true;
    aluz.b(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.curType, paramInt, paramLong);
  }
  
  public void a(long paramLong)
  {
    ThreadManagerV2.getUIHandlerV2().post(new CmGameChatPie.16(this, paramLong));
  }
  
  public void a(alvh paramalvh)
  {
    if (paramalvh == null)
    {
      QLog.e(this.tag, 1, "[addTopGame] gameMap is null.");
      return;
    }
    if ((paramalvh.b.size() < 3) || (paramalvh.b.size() % 3 != 0))
    {
      QLog.e(this.tag, 1, "[addTopGame] game size is not a multiple of 3.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 1, "[addTopGame] alreadyAdd:" + this.jdField_b_of_type_Boolean);
    }
    List localList = this.listAdapter.a();
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips = ((MessageForCmGameTips)bbli.a(-7004));
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.msgtype = -7004;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.mIsParsed = true;
      if ((this.jdField_c_of_type_AndroidWidgetRelativeLayout != null) && (localList.size() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.needTopPadding = true;
      }
      bbli.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips, this.sessionInfo.curFriendUin, "", 1036);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.gameInfo = paramalvh;
      this.app.getMessageFacade().addMessage(this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips, this.app.getCurrentUin(), true, false, false, true);
      localList.add(this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips);
      this.jdField_b_of_type_Boolean = true;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.10(this));
  }
  
  public void a(alvl paramalvl)
  {
    if ((paramalvl != null) && (paramalvl.jdField_a_of_type_JavaLangCharSequence != null) && (!this.l))
    {
      acvv.b(this.app, this.mContext, this.sessionInfo, paramalvl.jdField_a_of_type_JavaLangCharSequence.toString());
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar.a();
      }
      if (this.uiHandler != null)
      {
        this.uiHandler.removeMessages(16777216);
        this.uiHandler.sendEmptyMessageDelayed(16777216, 600L);
        this.l = true;
      }
      VipUtils.a(null, "cmshow", "Apollo", "quickMessage", 0, 0, new String[] { String.valueOf(paramalvl.jdField_a_of_type_Int) });
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.afRoot.removeView(this.jdField_c_of_type_AndroidWidgetRelativeLayout);
      a(paramString, this.app.getCurrentAccountUin(), this.jdField_a_of_type_Ahex.jdField_a_of_type_JavaLangString, 2);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.needTopPadding = false;
        this.listAdapter.notifyDataSetChanged();
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramInt == 3)
    {
      paramString1 = new aucf(paramString1, paramString2, amtj.a(2131701195), this.sessionInfo.curType, -5040, 2359297, bbko.a());
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(this.app, paramString1);
      aucg.a(this.app, paramString2);
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
      l1 = bbko.a();
      str1 = "";
      if (paramInt != 0) {
        break;
      }
    } while ((this.jdField_a_of_type_Ahex != null) && (this.jdField_a_of_type_Ahex.jdField_c_of_type_Int == 4));
    String str1 = amtj.a(2131701208);
    for (;;)
    {
      paramString1 = new aucf(paramString1, paramString2, str1, this.sessionInfo.curType, -5040, 2359297, l1);
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(this.app, paramString1);
      aucg.a(this.app, paramString2);
      localSharedPreferences.edit().putBoolean(str2, false).commit();
      return;
      if (paramInt == 1) {
        str1 = amtj.a(2131701206) + paramString3 + amtj.a(2131701196);
      } else if (paramInt == 2) {
        str1 = amtj.a(2131701193) + paramString3 + amtj.a(2131701194);
      }
    }
  }
  
  public void a(List<ApolloGameData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new CmGameChatPie.14(this, paramBoolean));
  }
  
  public boolean a()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public void addBusinessObservers()
  {
    super.addBusinessObservers();
    this.app.addDefaultObservers(this.jdField_a_of_type_Amwl);
  }
  
  public void b()
  {
    if (this.p) {
      QLog.d(this.tag, 1, "[showAddPlaymateIntro] isShow intro return.");
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      if (this.jdField_a_of_type_Ahex == null)
      {
        QLog.d(this.tag, 1, "[showAddPlaymateIntro] friendInfo is null return.");
        return;
      }
      localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    } while ((!localSharedPreferences.getBoolean("apollo_add_playMate_intro", true)) || (this.jdField_a_of_type_Ahex.jdField_c_of_type_Int != 0));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getActivity());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#cf000000"));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_d_of_type_Int = 0;
    ImageView localImageView = new ImageView(getActivity());
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setId(2131362754);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.dp2px(200.0F, this.mContext.getResources());
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.dp2px(100.0F, this.mContext.getResources());
    localImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/add_playmate_intro.png", (URLDrawable.URLDrawableOptions)localObject));
    localImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(91.0F, this.mContext.getResources()), AIOUtils.dp2px(41.0F, this.mContext.getResources()));
    localLayoutParams1.addRule(11);
    localLayoutParams1.addRule(10);
    localLayoutParams1.setMargins(0, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + AIOUtils.dp2px(57.0F, this.mContext.getResources()), AIOUtils.dp2px(10.0F, this.mContext.getResources()), 0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localImageView, localLayoutParams1);
    localImageView = new ImageView(getActivity());
    localLayoutParams1 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(210.0F, this.mContext.getResources()), AIOUtils.dp2px(70.0F, this.mContext.getResources()));
    localLayoutParams1.addRule(3, 2131362754);
    localLayoutParams1.addRule(11);
    localLayoutParams1.setMargins(0, 0, AIOUtils.dp2px(40.0F, this.mContext.getResources()), 0);
    localObject = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/add_playmate_intro1.png", (URLDrawable.URLDrawableOptions)localObject);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localImageView, localLayoutParams1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ahep(this));
    QLog.i(this.tag, 1, "[showAddPlaymateIntro] already show addplaymate intro.");
    ((FrameLayout)getActivity().getWindow().getDecorView()).addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
    this.p = true;
    localSharedPreferences.edit().putBoolean("apollo_add_playMate_intro", false).commit();
  }
  
  public void b(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 16777218;
    localMessage.obj = paramString;
    this.uiHandler.removeMessages(16777218);
    this.uiHandler.sendMessage(localMessage);
  }
  
  public void b(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new CmGameChatPie.15(this, paramBoolean));
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, new Object[] { "updateFriendVoiceStatus isVoiceOpen:", Boolean.valueOf(paramBoolean) });
    }
    this.i = paramBoolean;
    this.m = true;
    if (this.uiHandler != null)
    {
      this.uiHandler.removeMessages(16777215);
      this.uiHandler.sendEmptyMessageDelayed(16777215, 500L);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.p))
    {
      ((FrameLayout)getActivity().getWindow().getDecorView()).removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      this.p = false;
      if (paramBoolean) {
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAddFriend", 0, 0, new String[] { "2" });
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.p))
    {
      ((FrameLayout)getActivity().getWindow().getDecorView()).removeView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
      this.p = false;
      if (paramBoolean) {
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAudio", 0, 0, new String[] { "2" });
      }
    }
  }
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "[doOnCreate] chatPie:" + this + "," + this.jdField_d_of_type_Boolean);
    }
    this.needAutoInput = false;
    this.jdField_d_of_type_Boolean = true;
    Object localObject = (alnr)this.app.getManager(153);
    ((alnr)localObject).a().a("page_tag_aio");
    ((alnr)localObject).a().a(this.app.getCurrentUin(), "join");
    localObject = this.mActivity.getIntent().getStringExtra("uin");
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = localObject;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    return super.doOnCreate(paramBoolean);
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "[doOnDestory] chatPie:" + this + "," + this.jdField_d_of_type_Boolean);
    }
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips != null)
    {
      this.app.getMessageFacade().removeMsgByMessageRecord(this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips, false);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips = null;
    }
    alnr localalnr = (alnr)this.app.getManager(153);
    localalnr.a().a();
    localalnr.a().b(this.jdField_a_of_type_Ahew);
    localalnr.a().b("page_tag_aio");
    if (this.jdField_d_of_type_Boolean)
    {
      localalnr.a().d(getCurFriendUin());
      this.jdField_d_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Ahew = null;
    if (this.jdField_a_of_type_Aluw != null)
    {
      this.jdField_a_of_type_Aluw.dismiss();
      this.jdField_a_of_type_Aluw = null;
    }
    super.doOnDestroy();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      c(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      this.p = false;
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      d(true);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
      this.p = false;
    }
    localalnr.a().a(null);
    localalnr.a().c(getCurFriendUin(), 319);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_f_of_type_Boolean = true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.mTitleBtnCall.setVisibility(8);
    alnr localalnr = (alnr)this.app.getManager(153);
    if (this.jdField_f_of_type_Boolean) {
      localalnr.a().a();
    }
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    if (jdField_c_of_type_Boolean)
    {
      this.uiHandler.removeMessages(16777215);
      this.uiHandler.sendEmptyMessageDelayed(16777215, 500L);
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if ((this.mActivity.getIntent() != null) && (!this.mActivity.getIntent().getBooleanExtra("key_show_one_more_page", false))) {
      a();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_g_of_type_Boolean = true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      e();
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null)
      {
        this.mContent.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar);
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = null;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null)
        {
          this.mContent.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar);
          this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = null;
          continue;
          Object localObject = (String)paramMessage.obj;
          if ("dialog_type_permission".equals(localObject))
          {
            if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
            {
              localObject = bfur.a(getActivity(), 230).setMessage(getActivity().getString(2131695185)).setTitle(getActivity().getString(2131695186)).setNegativeButton(2131690620, new ahes(this));
              if (!mum.a(getActivity())) {
                break label218;
              }
            }
            label218:
            for (int i1 = 2131695187;; i1 = 2131695188)
            {
              this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = ((QQCustomDialog)localObject).setPositiveButton(i1, new aher(this));
              this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
              break;
            }
          }
          if ("dialog_type_confirm".equals(localObject))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
              this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(getActivity(), 230).setMessage(amtj.a(2131701205)).setPositiveButton(getActivity().getString(2131694201), new aheu(this)).setNegativeButton(getActivity().getString(2131690620), new ahet(this));
            }
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
          }
        }
      }
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.p)
    {
      c(true);
      d(true);
      return true;
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
      VipUtils.a(null, "cmshow", "Apollo", "returnBtn", 0, 0, new String[] { "" });
      continue;
      VipUtils.a(null, "cmshow", "Apollo", "dataEntry", 0, 0, new String[] { "" });
      continue;
      VipUtils.a(null, "cmshow", "Apollo", "inputBoxClick", 0, 0, new String[] { "" });
    }
  }
  
  public void onPanelIconClick(Object paramObject)
  {
    super.onPanelIconClick(paramObject);
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
  
  public void onShow_business()
  {
    super.onShow_business();
    this.mSingleTitle = false;
    setSubTitleVisable(true);
    this.mSubTilteText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.mTitleLayout.setOnClickListener(null);
    this.mSubTitleLayout.setOnClickListener(null);
  }
  
  public void removeBusinessObservers()
  {
    super.removeBusinessObservers();
    this.app.removeObserver(this.jdField_a_of_type_Amwl);
  }
  
  public void setTag()
  {
    this.tag = "CmGameTemp_CmGameChatPie";
  }
  
  public void showAddFriendAndShield()
  {
    Object localObject = (alnr)this.app.getManager(153);
    alvd localalvd = ((alnr)localObject).a();
    localalvd.a(this.sessionInfo.curFriendUin, this.sessionInfo.curType, 1);
    localalvd.b(this.sessionInfo.curFriendUin);
    localObject = ((alnr)localObject).a();
    if ((aluk.a) && (!((aluk)localObject).b())) {
      ((aluk)localObject).b(this.sessionInfo.curFriendUin, 319);
    }
    if ((!android.text.TextUtils.isEmpty(((aluk)localObject).a())) && (((aluk)localObject).a().equals(this.sessionInfo.curFriendUin))) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130839250);
    }
    localalvd.a(this.sessionInfo.curFriendUin, 319);
    localalvd.c(this.sessionInfo.curFriendUin);
  }
  
  public boolean showorhideAddFriend()
  {
    return !isFullScreenMode();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof MessageRecord)) && ((paramObject instanceof ChatMessage)))
    {
      ChatMessage localChatMessage = (ChatMessage)paramObject;
      if (localChatMessage.senderuin.equals(this.sessionInfo.curFriendUin))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "[update] get friend message,update friend status");
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
  
  public void updatePanelIconStatus()
  {
    super.updatePanelIconStatus();
    int i1 = this.root.a();
    if ((this.panelicons != null) && (i1 == 21) && (this.sessionInfo.curType == 1036)) {
      this.panelicons.setSelected(21);
    }
  }
  
  public void updateSession_business(Intent paramIntent)
  {
    super.updateSession_business(paramIntent);
    bfzg.a(null, "AIO_updateSession_business");
    if (this.jdField_a_of_type_Ahew == null) {
      this.jdField_a_of_type_Ahew = new ahew(this);
    }
    ((alnr)this.app.getManager(153)).a().a(this.jdField_a_of_type_Ahew);
    bfzg.a("AIO_updateSession_business", null);
    this.jdField_e_of_type_Boolean = true;
    c();
  }
  
  public void updateSession_updateSubTitle()
  {
    super.updateSession_updateSubTitle();
  }
  
  public void updateSession_updateTitleLeftView(Intent paramIntent)
  {
    super.updateSession_updateTitleLeftView(paramIntent);
  }
  
  public void updateUI_titleBarForTheme()
  {
    super.updateUI_titleBarForTheme();
    this.mTitleText.setMaxEms(7);
    this.mTitleText.setEllipsize(TextUtils.TruncateAt.END);
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView = new FrameGifView(this.mContext);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130839248);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setPlayLoop(true);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(100, null, "https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip", amnq.a("https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip"), false);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setOnClickListener(new ahem(this));
      localObject = new RelativeLayout.LayoutParams(AIOUtils.dp2px(25.0F, this.mContext.getResources()), AIOUtils.dp2px(25.0F, this.mContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      this.mTitleBtnRightLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView, (ViewGroup.LayoutParams)localObject);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView = new FrameGifView(this.mContext);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130839249);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setPlayLoop(true);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(100, null, "https://cmshow.gtimg.cn/client/img/apollo_game_audio_micSmall.zip", amnq.a("https://cmshow.gtimg.cn/client/img/apollo_game_audio_micSmall.zip"), false);
      localObject = new LinearLayout.LayoutParams(AIOUtils.dp2px(18.0F, this.mContext.getResources()), AIOUtils.dp2px(18.0F, this.mContext.getResources()));
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setPadding(0, 0, 5, 0);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      ((ViewGroup)this.mTitleText.getParent()).addView(this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView, (ViewGroup.LayoutParams)localObject);
    }
    if (!aluk.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahek
 * JD-Core Version:    0.7.0.1
 */