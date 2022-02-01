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
import com.tencent.imcore.message.QQMessageFacade;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ahyk
  extends BaseChatPie
  implements amow
{
  public static boolean T;
  public boolean S;
  private boolean U;
  private boolean V;
  private boolean W;
  private boolean X;
  private boolean Y;
  private boolean Z;
  private ahyw jdField_a_of_type_Ahyw;
  private ahyx jdField_a_of_type_Ahyx;
  private amoi jdField_a_of_type_Amoi;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new ahyq(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new bkgm(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
  protected anqd a;
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
  public View.OnClickListener b;
  private FrameGifView jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView;
  private List<ApolloGameData> jdField_b_of_type_JavaUtilList;
  private bgpa c;
  private bgpa d;
  private RelativeLayout f;
  private RelativeLayout g;
  private RelativeLayout h;
  private RelativeLayout i;
  private ImageView jdField_l_of_type_AndroidWidgetImageView;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  private TextView m;
  private TextView n;
  private TextView o;
  private TextView p;
  private int jdField_q_of_type_Int = 319;
  private TextView jdField_q_of_type_AndroidWidgetTextView;
  private int jdField_r_of_type_Int;
  private TextView jdField_r_of_type_AndroidWidgetTextView;
  private int jdField_s_of_type_Int;
  private TextView jdField_s_of_type_AndroidWidgetTextView;
  private int t;
  
  public ahyk(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ahyl(this);
    this.jdField_a_of_type_Anqd = new ahyn(this);
    ((amhd)paramQQAppInterface.getManager(153)).a().a(this);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    this.af = true;
    if (paramInt1 == 0)
    {
      paramInt2 = (int)(System.currentTimeMillis() / 1000L - paramInt2);
      if (paramInt2 > 86400)
      {
        paramString = (int)Math.ceil(paramInt2 / 86400.0D) + anni.a(2131700857);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
        w(false);
        if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777215);
        }
        if (this.Y) {
          this.jdField_a_of_type_Agaz.a();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar);
          this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = null;
        }
        this.ab = false;
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
        paramString = (int)Math.ceil(paramInt2 / 3600.0D) + anni.a(2131700861);
        break;
      }
      paramString = (int)Math.ceil(paramInt2 / 60.0D) + anni.a(2131700855);
      break;
      this.ab = true;
      this.jdField_f_of_type_AndroidWidgetTextView.setText(anni.a(2131718211));
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777215);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16777215, 500L);
      }
    }
  }
  
  private void a(String paramString, ahyx paramahyx, int paramInt)
  {
    boolean bool;
    if (paramInt == 4)
    {
      bool = true;
      this.aa = bool;
      this.ae = true;
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777215);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16777215, 500L);
      }
      if (this.h == null) {
        break label67;
      }
      z(paramInt);
    }
    label67:
    do
    {
      return;
      bool = false;
      break;
      if (paramahyx == null)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "[updateFriendAndShield] info is null.");
        return;
      }
      this.jdField_a_of_type_Ahyx = paramahyx;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[updateFriendAndShield] friUin:" + paramString + ", " + paramahyx.toString());
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
      if ((!TextUtils.isEmpty(paramahyx.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null))
      {
        paramString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uinname");
        if ((TextUtils.isEmpty(paramString)) && (this.e != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString;
          this.e.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        }
      }
    } while (paramahyx.jdField_c_of_type_Int == 4);
    this.h = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558897, null));
    this.h.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)this.h.findViewById(2131369010));
    this.o = ((TextView)this.h.findViewById(2131379779));
    this.p = ((TextView)this.h.findViewById(2131363693));
    this.jdField_q_of_type_AndroidWidgetTextView = ((TextView)this.h.findViewById(2131380011));
    this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView = ((DotPollingView)this.h.findViewById(2131365701));
    this.jdField_r_of_type_AndroidWidgetTextView = ((TextView)this.h.findViewById(2131363692));
    this.jdField_s_of_type_AndroidWidgetTextView = ((TextView)this.h.findViewById(2131379872));
    this.jdField_l_of_type_AndroidWidgetImageView = ((ImageView)this.h.findViewById(2131369282));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.h.findViewById(2131379508));
    this.i = ((RelativeLayout)this.h.findViewById(2131376664));
    this.m = ((TextView)this.h.findViewById(2131379563));
    this.n = ((TextView)this.h.findViewById(2131379533));
    if ((paramahyx.jdField_a_of_type_Int <= 0) && (TextUtils.isEmpty(paramahyx.jdField_c_of_type_JavaLangString)) && (paramahyx.jdField_b_of_type_Int <= 0))
    {
      this.n.setVisibility(0);
      label606:
      this.jdField_l_of_type_AndroidWidgetTextView.setText(paramahyx.jdField_a_of_type_Int + anni.a(2131700859));
      this.m.setText(paramahyx.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(afur.a(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageURL(paramahyx.d);
      if (!TextUtils.isEmpty(paramahyx.jdField_a_of_type_JavaLangString)) {
        break label1073;
      }
      this.o.setText(paramahyx.e);
      label703:
      this.p.setBackgroundDrawable(amol.a(this.jdField_a_of_type_AndroidContentContext, afur.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), "#000000"));
      this.p.setTextColor(amol.a(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
      this.jdField_r_of_type_AndroidWidgetTextView.setBackgroundDrawable(amol.a(this.jdField_a_of_type_AndroidContentContext, afur.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(23.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), "#000000"));
      this.jdField_r_of_type_AndroidWidgetTextView.setTextColor(amol.a(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
      this.p.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_r_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      z(paramahyx.jdField_c_of_type_Int);
      paramString = new RelativeLayout.LayoutParams(-1, afur.a(66.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramString.addRule(3, 2131376599);
      if (!this.H) {
        break label1087;
      }
    }
    label1073:
    label1087:
    for (paramString.topMargin -= afur.a(3.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());; paramString.topMargin = 0)
    {
      this.m.getViewTreeObserver().addOnPreDrawListener(new ahyv(this, paramahyx));
      this.jdField_d_of_type_AndroidViewViewGroup.addView(this.h, paramString);
      if (((this.jdField_a_of_type_Afwy.a().size() != 0) && (!(this.jdField_a_of_type_Afwy.a().get(0) instanceof MessageForCmGameTips))) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.needTopPadding = true;
      this.jdField_a_of_type_Afwy.notifyDataSetChanged();
      return;
      if (paramahyx.jdField_a_of_type_Int > 0) {
        this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (!TextUtils.isEmpty(paramahyx.jdField_c_of_type_JavaLangString)) {
        this.i.setVisibility(0);
      }
      if ((paramahyx.jdField_b_of_type_Int != 1) && (paramahyx.jdField_b_of_type_Int != 2)) {
        break label606;
      }
      this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(0);
      break label606;
      this.o.setText(paramahyx.jdField_a_of_type_JavaLangString);
      break label703;
    }
  }
  
  private void a(List<amox> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    int j = afur.a(7.0F, a().getResources());
    if (bgln.a() <= 2.0F) {
      j = afur.a(9.0F, a().getResources());
    }
    amox localamox = amop.a(paramInt);
    if (localamox != null)
    {
      paramList.add(localamox);
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      localamox = new amox();
      localamox.jdField_a_of_type_Int = 1;
      localamox.jdField_a_of_type_JavaLangCharSequence = anni.a(2131700850);
      paramList.add(localamox);
      return;
    case 7: 
      localamox = new amox();
      localamox.jdField_a_of_type_Int = 7;
      localamox.jdField_a_of_type_JavaLangCharSequence = new bdnt(bdol.b(193), 3, j);
      paramList.add(localamox);
      return;
    case 6: 
      localamox = new amox();
      localamox.jdField_a_of_type_Int = 6;
      localamox.jdField_a_of_type_JavaLangCharSequence = anni.a(2131700865);
      paramList.add(localamox);
      return;
    case 5: 
      localamox = new amox();
      localamox.jdField_a_of_type_Int = 5;
      localamox.jdField_a_of_type_JavaLangCharSequence = anni.a(2131700860);
      paramList.add(localamox);
      return;
    case 4: 
      localamox = new amox();
      localamox.jdField_a_of_type_Int = 4;
      localamox.jdField_a_of_type_JavaLangCharSequence = new bdnt(bdol.b(209), 3, j);
      paramList.add(localamox);
      return;
    case 3: 
      localamox = new amox();
      localamox.jdField_a_of_type_Int = 3;
      localamox.jdField_a_of_type_JavaLangCharSequence = anni.a(2131700858);
      paramList.add(localamox);
      return;
    case 2: 
      localamox = new amox();
      localamox.jdField_a_of_type_Int = 2;
      localamox.jdField_a_of_type_JavaLangCharSequence = new bdnt(bdol.b(192), 3, j);
      paramList.add(localamox);
      return;
    }
    localamox = new amox();
    localamox.jdField_a_of_type_Int = 1;
    localamox.jdField_a_of_type_JavaLangCharSequence = anni.a(2131700849);
    paramList.add(localamox);
  }
  
  private void bq()
  {
    ThreadManagerV2.excute(new CmGameChatPie.8(this), 16, null, false);
  }
  
  private void br()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (new Random().nextBoolean()) && (amoy.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      amop localamop = ((amhd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a();
      int j = (int)(System.currentTimeMillis() / 1000L);
      this.jdField_r_of_type_Int = j;
      this.jdField_s_of_type_Int = j;
      localamop.a(this.jdField_a_of_type_Amoi.jdField_a_of_type_Int, this.jdField_r_of_type_Int);
    }
  }
  
  private void bs()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkTipsBarLayout");
    }
    if (this.ac) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, "checkTipsBarLayout mQuickBarClickRemoved");
    }
    do
    {
      return;
      if ((!this.ae) || (!this.af) || (!this.ad))
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, new Object[] { "checkTipsBarLayout mMateStateChecked:", Boolean.valueOf(this.ae), " mOnLineStateChecked:", Boolean.valueOf(this.af), " mAudioOnLineChecked:", Boolean.valueOf(this.ad) });
        return;
      }
      if (this.ab) {
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
      localObject = new RelativeLayout.LayoutParams(-1, afur.a(48.0F, a().getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131368652);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar.setTipsClickListener(this);
    }
    Object localObject = new ArrayList();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, new Object[] { "checkTipsBarLayout mIsMate:", Boolean.valueOf(this.aa), " mFriendAudioOnLine:", Boolean.valueOf(this.Z), " sLaunchGameFromAIO:", Boolean.valueOf(T) });
    if (this.aa) {
      if (this.Z) {
        if (T)
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
      this.jdField_a_of_type_Agaz.a(afur.a(48.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), false, "cmGame_addFooter", 0);
      this.Y = true;
      return;
      a((List)localObject, 6);
      a((List)localObject, 4);
      a((List)localObject, 2);
      continue;
      if (T)
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
        if (this.Z)
        {
          if (T)
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
          if (T) {
            a((List)localObject, 3);
          } else {
            a((List)localObject, 2);
          }
        }
      }
    }
  }
  
  private void z(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.p.setVisibility(0);
      this.jdField_q_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView.setVisibility(8);
      this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    case 1: 
      this.p.setVisibility(8);
      this.jdField_q_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView.setVisibility(0);
      this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.p.setVisibility(8);
    this.jdField_q_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView.setVisibility(8);
    this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public boolean E()
  {
    return this.V;
  }
  
  public void H()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[doOnDestory] chatPie:" + this + "," + this.U);
    }
    this.S = false;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips, false);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips = null;
    }
    amhd localamhd = (amhd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    localamhd.a().a();
    localamhd.a().b(this.jdField_a_of_type_Ahyw);
    localamhd.a().b("page_tag_aio");
    if (this.U)
    {
      localamhd.a().d(a());
      this.U = false;
    }
    this.jdField_a_of_type_Ahyw = null;
    if (this.jdField_a_of_type_Amoi != null)
    {
      this.jdField_a_of_type_Amoi.dismiss();
      this.jdField_a_of_type_Amoi = null;
    }
    super.H();
    this.V = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    T = false;
    if (this.c != null) {
      this.c.dismiss();
    }
    if (this.jdField_d_of_type_Bgpa != null) {
      this.jdField_d_of_type_Bgpa.dismiss();
    }
    if (this.jdField_f_of_type_AndroidWidgetRelativeLayout != null)
    {
      x(true);
      this.jdField_f_of_type_AndroidWidgetRelativeLayout = null;
      this.ag = false;
    }
    if (this.g != null)
    {
      y(true);
      this.g = null;
      this.ag = false;
    }
    localamhd.a().a(null);
    localamhd.a().c(a(), 319);
  }
  
  public void K()
  {
    super.K();
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("key_show_one_more_page", false))) {
      bo();
    }
  }
  
  public void L()
  {
    super.L();
    this.X = true;
  }
  
  public void M()
  {
    super.M();
    this.W = true;
  }
  
  public void P()
  {
    super.P();
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    amhd localamhd = (amhd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if (this.W) {
      localamhd.a().a();
    }
    this.W = false;
    this.X = false;
    if (T)
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
    if (this.jdField_a_of_type_Ahyx != null)
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
    angn localangn = new angn();
    Object localObject = (ancd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    String str = anni.a(2131700862);
    ApolloGameData localApolloGameData = ((ancd)localObject).a(paramInt);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((ancd)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label184;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label184:
    for (;;)
    {
      int j = localApolloGameData.actionId;
      localangn.jdField_b_of_type_JavaLangString = localApolloGameData.name;
      for (;;)
      {
        localangn.jdField_a_of_type_JavaLangString = str;
        localangn.jdField_b_of_type_Int = j;
        localangn.jdField_a_of_type_Long = paramLong;
        localangn.jdField_a_of_type_Int = paramInt;
        localangn.d = 3;
        localangn.e = 0;
        amol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localangn);
        return;
        localangn.jdField_b_of_type_JavaLangString = anni.a(2131700856);
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
    T = true;
    amol.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramInt, paramLong);
  }
  
  public void a(amot paramamot)
  {
    if (paramamot == null)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "[addTopGame] gameMap is null.");
      return;
    }
    if ((paramamot.jdField_b_of_type_JavaUtilList.size() < 3) || (paramamot.jdField_b_of_type_JavaUtilList.size() % 3 != 0))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "[addTopGame] game size is not a multiple of 3.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "[addTopGame] alreadyAdd:" + this.S);
    }
    List localList = this.jdField_a_of_type_Afwy.a();
    if (!this.S)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips = ((MessageForCmGameTips)bbzh.a(-7004));
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.msgtype = -7004;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.mIsParsed = true;
      if ((this.h != null) && (localList.size() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.needTopPadding = true;
      }
      bbzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", 1036);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.gameInfo = paramamot;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), true, false, false, true);
      localList.add(this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips);
      this.S = true;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.10(this));
  }
  
  public void a(amox paramamox)
  {
    if ((paramamox != null) && (paramamox.jdField_a_of_type_JavaLangCharSequence != null) && (!this.ac))
    {
      adrm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramamox.jdField_a_of_type_JavaLangCharSequence.toString());
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar.a();
      }
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777216);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16777216, 600L);
        this.ac = true;
      }
      VipUtils.a(null, "cmshow", "Apollo", "quickMessage", 0, 0, new String[] { String.valueOf(paramamox.jdField_a_of_type_Int) });
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
      paramString1 = new auxc(paramString1, paramString2, anni.a(2131700853), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5040, 2359297, bbyp.a());
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
      auxd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2);
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
      l1 = bbyp.a();
      str1 = "";
      if (paramInt != 0) {
        break;
      }
    } while ((this.jdField_a_of_type_Ahyx != null) && (this.jdField_a_of_type_Ahyx.jdField_c_of_type_Int == 4));
    String str1 = anni.a(2131700866);
    for (;;)
    {
      paramString1 = new auxc(paramString1, paramString2, str1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5040, 2359297, l1);
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
      auxd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2);
      localSharedPreferences.edit().putBoolean(str2, false).commit();
      return;
      if (paramInt == 1) {
        str1 = anni.a(2131700864) + paramString3 + anni.a(2131700854);
      } else if (paramInt == 2) {
        str1 = anni.a(2131700851) + paramString3 + anni.a(2131700852);
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[doOnCreate] chatPie:" + this + "," + this.U);
    }
    this.F = false;
    this.U = true;
    Object localObject = (amhd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    ((amhd)localObject).a().a("page_tag_aio");
    ((amhd)localObject).a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "join");
    localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = localObject;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    return super.a(paramBoolean);
  }
  
  public void aV()
  {
    super.aV();
    this.e.setMaxEms(7);
    this.e.setEllipsize(TextUtils.TruncateAt.END);
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView = new FrameGifView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130839205);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setPlayLoop(true);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(100, null, "https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip", anhe.a("https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip"), false);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setOnClickListener(new ahym(this));
      localObject = new RelativeLayout.LayoutParams(afur.a(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView, (ViewGroup.LayoutParams)localObject);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView = new FrameGifView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130839206);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setPlayLoop(true);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(100, null, "https://cmshow.gtimg.cn/client/img/apollo_game_audio_micSmall.zip", anhe.a("https://cmshow.gtimg.cn/client/img/apollo_game_audio_micSmall.zip"), false);
      localObject = new LinearLayout.LayoutParams(afur.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setPadding(0, 0, 5, 0);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      ((ViewGroup)this.e.getParent()).addView(this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView, (ViewGroup.LayoutParams)localObject);
    }
    if (!amnw.b)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
    }
  }
  
  public void ag()
  {
    super.ag();
    this.jdField_a_of_type_Boolean = false;
    c(true);
    this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
  }
  
  public void am()
  {
    super.am();
    int j = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (j == 21) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1036)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(21);
    }
  }
  
  public void ap()
  {
    super.ap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Anqd);
  }
  
  public void aq()
  {
    super.aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anqd);
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
      localImageView.setId(2131362732);
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = afur.a(200.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = afur.a(100.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      Object localObject2 = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_audio_intro_btn.png", (URLDrawable.URLDrawableOptions)localObject1);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setImageDrawable((Drawable)localObject2);
      localImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localObject2 = new RelativeLayout.LayoutParams(afur.a(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + afur.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(45.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      this.g.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
      localImageView = new ImageView(a());
      localObject2 = new RelativeLayout.LayoutParams(afur.a(210.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131362732);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, afur.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      localObject1 = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_audio_intro_txt.png", (URLDrawable.URLDrawableOptions)localObject1);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setImageDrawable((Drawable)localObject1);
      this.g.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
      this.ag = true;
      this.g.setOnClickListener(new ahyo(this));
      ((FrameLayout)a().getWindow().getDecorView()).addView(this.g, localLayoutParams);
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, "[showOpenAudioIntro] already show audio intro.");
      localSharedPreferences.edit().putBoolean("apollo_audio_intro", false).commit();
    }
  }
  
  public void bp()
  {
    if (this.ag) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "[showAddPlaymateIntro] isShow intro return.");
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      if (this.jdField_a_of_type_Ahyx == null)
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "[showAddPlaymateIntro] friendInfo is null return.");
        return;
      }
      localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    } while ((!localSharedPreferences.getBoolean("apollo_add_playMate_intro", true)) || (this.jdField_a_of_type_Ahyx.jdField_c_of_type_Int != 0));
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(a());
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#cf000000"));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.t = 0;
    ImageView localImageView = new ImageView(a());
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setId(2131362731);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = afur.a(200.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = afur.a(100.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/add_playmate_intro.png", (URLDrawable.URLDrawableOptions)localObject));
    localImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(afur.a(91.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(41.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localLayoutParams1.addRule(11);
    localLayoutParams1.addRule(10);
    localLayoutParams1.setMargins(0, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + afur.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.addView(localImageView, localLayoutParams1);
    localImageView = new ImageView(a());
    localLayoutParams1 = new RelativeLayout.LayoutParams(afur.a(210.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localLayoutParams1.addRule(3, 2131362731);
    localLayoutParams1.addRule(11);
    localLayoutParams1.setMargins(0, 0, afur.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
    localObject = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/add_playmate_intro1.png", (URLDrawable.URLDrawableOptions)localObject);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setImageDrawable((Drawable)localObject);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.addView(localImageView, localLayoutParams1);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ahyp(this));
    QLog.i(this.jdField_a_of_type_JavaLangString, 1, "[showAddPlaymateIntro] already show addplaymate intro.");
    ((FrameLayout)a().getWindow().getDecorView()).addView(this.jdField_f_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
    this.ag = true;
    localSharedPreferences.edit().putBoolean("apollo_add_playMate_intro", false).commit();
  }
  
  public void d(long paramLong)
  {
    ThreadManagerV2.getUIHandlerV2().post(new CmGameChatPie.16(this, paramLong));
  }
  
  public void d(Intent paramIntent)
  {
    super.d(paramIntent);
    bgso.a(null, "AIO_updateSession_business");
    if (this.jdField_a_of_type_Ahyw == null) {
      this.jdField_a_of_type_Ahyw = new ahyw(this);
    }
    ((amhd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().a(this.jdField_a_of_type_Ahyw);
    bgso.a("AIO_updateSession_business", null);
    this.V = true;
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
  
  public void g(String paramString)
  {
    if (this.h != null)
    {
      this.jdField_d_of_type_AndroidViewViewGroup.removeView(this.h);
      a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Ahyx.jdField_a_of_type_JavaLangString, 2);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.needTopPadding = false;
        this.jdField_a_of_type_Afwy.notifyDataSetChanged();
      }
    }
  }
  
  public void h(String paramString)
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
            if (this.jdField_d_of_type_Bgpa == null)
            {
              localObject = bglp.a(a(), 230).setMessage(a().getString(2131695004)).setTitle(a().getString(2131695005)).setNegativeButton(2131690582, new ahys(this));
              if (!mue.a(a())) {
                break label218;
              }
            }
            label218:
            for (int j = 2131695006;; j = 2131695007)
            {
              this.jdField_d_of_type_Bgpa = ((bgpa)localObject).setPositiveButton(j, new ahyr(this));
              this.jdField_d_of_type_Bgpa.show();
              break;
            }
          }
          if ("dialog_type_confirm".equals(localObject))
          {
            if (this.c == null) {
              this.c = bglp.a(a(), 230).setMessage(anni.a(2131700863)).setPositiveButton(a().getString(2131694081), new ahyu(this)).setNegativeButton(a().getString(2131690582), new ahyt(this));
            }
            this.c.show();
          }
        }
      }
    }
  }
  
  public boolean i()
  {
    if (this.ag)
    {
      x(true);
      y(true);
      return true;
    }
    return super.i();
  }
  
  public void k()
  {
    Object localObject = (amhd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    amop localamop = ((amhd)localObject).a();
    localamop.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1);
    localamop.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localObject = ((amhd)localObject).a();
    if ((amnw.jdField_a_of_type_Boolean) && (!((amnw)localObject).b())) {
      ((amnw)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 319);
    }
    if ((!TextUtils.isEmpty(((amnw)localObject).a())) && (((amnw)localObject).a().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130839207);
    }
    localamop.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 319);
    localamop.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
  
  public void p()
  {
    super.p();
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
    ThreadManager.getUIHandler().post(new CmGameChatPie.14(this, paramBoolean));
  }
  
  public void w(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new CmGameChatPie.15(this, paramBoolean));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "updateFriendVoiceStatus isVoiceOpen:", Boolean.valueOf(paramBoolean) });
    }
    this.Z = paramBoolean;
    this.ad = true;
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777215);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16777215, 500L);
    }
  }
  
  public void x(boolean paramBoolean)
  {
    if ((this.jdField_f_of_type_AndroidWidgetRelativeLayout != null) && (this.ag))
    {
      ((FrameLayout)a().getWindow().getDecorView()).removeView(this.jdField_f_of_type_AndroidWidgetRelativeLayout);
      this.jdField_f_of_type_AndroidWidgetRelativeLayout = null;
      this.ag = false;
      if (paramBoolean) {
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAddFriend", 0, 0, new String[] { "2" });
      }
    }
  }
  
  public void y(boolean paramBoolean)
  {
    if ((this.g != null) && (this.ag))
    {
      ((FrameLayout)a().getWindow().getDecorView()).removeView(this.g);
      this.g = null;
      this.ag = false;
      if (paramBoolean) {
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAudio", 0, 0, new String[] { "2" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyk
 * JD-Core Version:    0.7.0.1
 */