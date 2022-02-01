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

public class aihy
  extends BaseChatPie
  implements anaq
{
  public static boolean T;
  public boolean S;
  private boolean U;
  private boolean V;
  private boolean W;
  private boolean X;
  private boolean Y;
  private boolean Z;
  private aiik jdField_a_of_type_Aiik;
  private aiil jdField_a_of_type_Aiil;
  private anac jdField_a_of_type_Anac;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aiie(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new blhq(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
  protected aocj a;
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
  private bhpc c;
  private bhpc d;
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
  
  public aihy(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new aihz(this);
    this.jdField_a_of_type_Aocj = new aiib(this);
    ((amsx)paramQQAppInterface.getManager(153)).a().a(this);
  }
  
  private void a(aiil paramaiil)
  {
    if (paramaiil == null) {
      return;
    }
    if ((paramaiil.jdField_a_of_type_Int <= 0) && (TextUtils.isEmpty(paramaiil.jdField_c_of_type_JavaLangString)) && (paramaiil.jdField_b_of_type_Int <= 0)) {
      this.n.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_l_of_type_AndroidWidgetTextView.setText(paramaiil.jdField_a_of_type_Int + anzj.a(2131700966));
      this.m.setText(paramaiil.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(agej.a(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageURL(paramaiil.d);
      if (!TextUtils.isEmpty(paramaiil.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.o.setText(paramaiil.e);
      return;
      if (paramaiil.jdField_a_of_type_Int > 0) {
        this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (!TextUtils.isEmpty(paramaiil.jdField_c_of_type_JavaLangString)) {
        this.i.setVisibility(0);
      }
      if ((paramaiil.jdField_b_of_type_Int == 1) || (paramaiil.jdField_b_of_type_Int == 2)) {
        this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    this.o.setText(paramaiil.jdField_a_of_type_JavaLangString);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    this.af = true;
    if (paramInt1 == 0)
    {
      paramInt2 = (int)(System.currentTimeMillis() / 1000L - paramInt2);
      if (paramInt2 > 86400)
      {
        paramString = (int)Math.ceil(paramInt2 / 86400.0D) + anzj.a(2131700964);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
        w(false);
        if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777215);
        }
        if (this.Y) {
          this.jdField_a_of_type_Agkt.a();
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
        paramString = (int)Math.ceil(paramInt2 / 3600.0D) + anzj.a(2131700968);
        break;
      }
      paramString = (int)Math.ceil(paramInt2 / 60.0D) + anzj.a(2131700962);
      break;
      this.ab = true;
      this.jdField_f_of_type_AndroidWidgetTextView.setText(anzj.a(2131718346));
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777215);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16777215, 500L);
      }
    }
  }
  
  private void a(String paramString, aiil paramaiil, int paramInt)
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
        break label69;
      }
      z(paramInt);
    }
    label69:
    do
    {
      return;
      bool = false;
      break;
      if (paramaiil == null)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "[updateFriendAndShield] info is null.");
        return;
      }
      this.jdField_a_of_type_Aiil = paramaiil;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[updateFriendAndShield] friUin:" + paramString + ", " + paramaiil.toString());
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
      if ((!TextUtils.isEmpty(paramaiil.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null))
      {
        paramString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uinname");
        if ((TextUtils.isEmpty(paramString)) && (this.e != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString;
          this.e.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        }
      }
    } while (paramaiil.jdField_c_of_type_Int == 4);
    this.h = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558896, null));
    this.h.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)this.h.findViewById(2131369104));
    this.o = ((TextView)this.h.findViewById(2131379958));
    this.p = ((TextView)this.h.findViewById(2131363718));
    this.jdField_q_of_type_AndroidWidgetTextView = ((TextView)this.h.findViewById(2131380196));
    this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView = ((DotPollingView)this.h.findViewById(2131365744));
    this.jdField_r_of_type_AndroidWidgetTextView = ((TextView)this.h.findViewById(2131363717));
    this.jdField_s_of_type_AndroidWidgetTextView = ((TextView)this.h.findViewById(2131380052));
    this.jdField_l_of_type_AndroidWidgetImageView = ((ImageView)this.h.findViewById(2131369372));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.h.findViewById(2131379677));
    this.i = ((RelativeLayout)this.h.findViewById(2131376798));
    this.m = ((TextView)this.h.findViewById(2131379735));
    this.n = ((TextView)this.h.findViewById(2131379702));
    a(paramaiil);
    this.p.setBackgroundDrawable(anaf.a(this.jdField_a_of_type_AndroidContentContext, agej.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), "#000000"));
    this.p.setTextColor(anaf.a(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
    this.jdField_r_of_type_AndroidWidgetTextView.setBackgroundDrawable(anaf.a(this.jdField_a_of_type_AndroidContentContext, agej.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(23.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), "#000000"));
    this.jdField_r_of_type_AndroidWidgetTextView.setTextColor(anaf.a(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
    this.p.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_r_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    z(paramaiil.jdField_c_of_type_Int);
    paramString = new RelativeLayout.LayoutParams(-1, agej.a(66.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramString.addRule(3, 2131376731);
    if (this.H) {}
    for (paramString.topMargin -= agej.a(3.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());; paramString.topMargin = 0)
    {
      this.m.getViewTreeObserver().addOnPreDrawListener(new aiij(this, paramaiil));
      this.jdField_d_of_type_AndroidViewViewGroup.addView(this.h, paramString);
      if (((this.jdField_a_of_type_Aggs.a().size() != 0) && (!(this.jdField_a_of_type_Aggs.a().get(0) instanceof MessageForCmGameTips))) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.needTopPadding = true;
      this.jdField_a_of_type_Aggs.notifyDataSetChanged();
      return;
    }
  }
  
  private void a(List<anar> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    int j = agej.a(7.0F, a().getResources());
    if (bhlo.a() <= 2.0F) {
      j = agej.a(9.0F, a().getResources());
    }
    anar localanar = anaj.a(paramInt);
    if (localanar != null)
    {
      paramList.add(localanar);
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      localanar = new anar();
      localanar.jdField_a_of_type_Int = 1;
      localanar.jdField_a_of_type_JavaLangCharSequence = anzj.a(2131700957);
      paramList.add(localanar);
      return;
    case 7: 
      localanar = new anar();
      localanar.jdField_a_of_type_Int = 7;
      localanar.jdField_a_of_type_JavaLangCharSequence = new begp(behh.b(193), 3, j);
      paramList.add(localanar);
      return;
    case 6: 
      localanar = new anar();
      localanar.jdField_a_of_type_Int = 6;
      localanar.jdField_a_of_type_JavaLangCharSequence = anzj.a(2131700972);
      paramList.add(localanar);
      return;
    case 5: 
      localanar = new anar();
      localanar.jdField_a_of_type_Int = 5;
      localanar.jdField_a_of_type_JavaLangCharSequence = anzj.a(2131700967);
      paramList.add(localanar);
      return;
    case 4: 
      localanar = new anar();
      localanar.jdField_a_of_type_Int = 4;
      localanar.jdField_a_of_type_JavaLangCharSequence = new begp(behh.b(209), 3, j);
      paramList.add(localanar);
      return;
    case 3: 
      localanar = new anar();
      localanar.jdField_a_of_type_Int = 3;
      localanar.jdField_a_of_type_JavaLangCharSequence = anzj.a(2131700965);
      paramList.add(localanar);
      return;
    case 2: 
      localanar = new anar();
      localanar.jdField_a_of_type_Int = 2;
      localanar.jdField_a_of_type_JavaLangCharSequence = new begp(behh.b(192), 3, j);
      paramList.add(localanar);
      return;
    }
    localanar = new anar();
    localanar.jdField_a_of_type_Int = 1;
    localanar.jdField_a_of_type_JavaLangCharSequence = anzj.a(2131700956);
    paramList.add(localanar);
  }
  
  private void bq()
  {
    ThreadManagerV2.excute(new CmGameChatPie.8(this), 16, null, false);
  }
  
  private void br()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (new Random().nextBoolean()) && (anas.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      anaj localanaj = ((amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a();
      int j = (int)(System.currentTimeMillis() / 1000L);
      this.jdField_r_of_type_Int = j;
      this.jdField_s_of_type_Int = j;
      localanaj.a(this.jdField_a_of_type_Anac.jdField_a_of_type_Int, this.jdField_r_of_type_Int);
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
      localObject = new RelativeLayout.LayoutParams(-1, agej.a(48.0F, a().getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131368726);
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
      this.jdField_a_of_type_Agkt.a(agej.a(48.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), false, "cmGame_addFooter", 0);
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
    amsx localamsx = (amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    localamsx.a().a();
    localamsx.a().b(this.jdField_a_of_type_Aiik);
    localamsx.a().b("page_tag_aio");
    if (this.U)
    {
      localamsx.a().d(a());
      this.U = false;
    }
    this.jdField_a_of_type_Aiik = null;
    if (this.jdField_a_of_type_Anac != null)
    {
      this.jdField_a_of_type_Anac.dismiss();
      this.jdField_a_of_type_Anac = null;
    }
    super.H();
    this.V = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    T = false;
    if (this.c != null) {
      this.c.dismiss();
    }
    if (this.jdField_d_of_type_Bhpc != null) {
      this.jdField_d_of_type_Bhpc.dismiss();
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
    localamsx.a().a(null);
    localamsx.a().c(a(), 319);
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
    amsx localamsx = (amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if (this.W) {
      localamsx.a().a();
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
    if (this.jdField_a_of_type_Aiil != null)
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
    ansi localansi = new ansi();
    Object localObject = (annx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    String str = anzj.a(2131700969);
    ApolloGameData localApolloGameData = ((annx)localObject).a(paramInt);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((annx)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label184;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label184:
    for (;;)
    {
      int j = localApolloGameData.actionId;
      localansi.jdField_b_of_type_JavaLangString = localApolloGameData.name;
      for (;;)
      {
        localansi.jdField_a_of_type_JavaLangString = str;
        localansi.jdField_b_of_type_Int = j;
        localansi.jdField_a_of_type_Long = paramLong;
        localansi.jdField_a_of_type_Int = paramInt;
        localansi.d = 3;
        localansi.e = 0;
        anaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localansi);
        return;
        localansi.jdField_b_of_type_JavaLangString = anzj.a(2131700963);
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
    anaf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramInt, paramLong);
  }
  
  public void a(anan paramanan)
  {
    if (paramanan == null)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "[addTopGame] gameMap is null.");
      return;
    }
    if ((paramanan.jdField_b_of_type_JavaUtilList.size() < 3) || (paramanan.jdField_b_of_type_JavaUtilList.size() % 3 != 0))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "[addTopGame] game size is not a multiple of 3.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "[addTopGame] alreadyAdd:" + this.S);
    }
    List localList = this.jdField_a_of_type_Aggs.a();
    if (!this.S)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips = ((MessageForCmGameTips)bcry.a(-7004));
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.msgtype = -7004;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.mIsParsed = true;
      if ((this.h != null) && (localList.size() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.needTopPadding = true;
      }
      bcry.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", 1036);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.gameInfo = paramanan;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), true, false, false, true);
      localList.add(this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips);
      this.S = true;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.10(this));
  }
  
  public void a(anar paramanar)
  {
    if ((paramanar != null) && (paramanar.jdField_a_of_type_JavaLangCharSequence != null) && (!this.ac))
    {
      aean.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramanar.jdField_a_of_type_JavaLangCharSequence.toString());
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar.a();
      }
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777216);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16777216, 600L);
        this.ac = true;
      }
      VipUtils.a(null, "cmshow", "Apollo", "quickMessage", 0, 0, new String[] { String.valueOf(paramanar.jdField_a_of_type_Int) });
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
      paramString1 = new avpd(paramString1, paramString2, anzj.a(2131700960), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5040, 2359297, bcrg.a());
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
      avpe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2);
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
      l1 = bcrg.a();
      str1 = "";
      if (paramInt != 0) {
        break;
      }
    } while ((this.jdField_a_of_type_Aiil != null) && (this.jdField_a_of_type_Aiil.jdField_c_of_type_Int == 4));
    String str1 = anzj.a(2131700973);
    for (;;)
    {
      paramString1 = new avpd(paramString1, paramString2, str1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5040, 2359297, l1);
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
      avpe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2);
      localSharedPreferences.edit().putBoolean(str2, false).commit();
      return;
      if (paramInt == 1) {
        str1 = anzj.a(2131700971) + paramString3 + anzj.a(2131700961);
      } else if (paramInt == 2) {
        str1 = anzj.a(2131700958) + paramString3 + anzj.a(2131700959);
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
    Object localObject = (amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    ((amsx)localObject).a().a("page_tag_aio");
    ((amsx)localObject).a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "join");
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
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130839213);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setPlayLoop(true);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(100, null, "https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip", ansz.a("https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip"), false);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setOnClickListener(new aiia(this));
      localObject = new RelativeLayout.LayoutParams(agej.a(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView, (ViewGroup.LayoutParams)localObject);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView = new FrameGifView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130839214);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setPlayLoop(true);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(100, null, "https://cmshow.gtimg.cn/client/img/apollo_game_audio_micSmall.zip", ansz.a("https://cmshow.gtimg.cn/client/img/apollo_game_audio_micSmall.zip"), false);
      localObject = new LinearLayout.LayoutParams(agej.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setPadding(0, 0, 5, 0);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      ((ViewGroup)this.e.getParent()).addView(this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView, (ViewGroup.LayoutParams)localObject);
    }
    if (!amzq.b)
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Aocj);
  }
  
  public void aq()
  {
    super.aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aocj);
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
      localImageView.setId(2131362750);
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = agej.a(200.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = agej.a(100.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      Object localObject2 = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_audio_intro_btn.png", (URLDrawable.URLDrawableOptions)localObject1);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setImageDrawable((Drawable)localObject2);
      localImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localObject2 = new RelativeLayout.LayoutParams(agej.a(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + agej.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(45.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      this.g.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
      localImageView = new ImageView(a());
      localObject2 = new RelativeLayout.LayoutParams(agej.a(210.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131362750);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, agej.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      localObject1 = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_audio_intro_txt.png", (URLDrawable.URLDrawableOptions)localObject1);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setImageDrawable((Drawable)localObject1);
      this.g.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
      this.ag = true;
      this.g.setOnClickListener(new aiic(this));
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
      if (this.jdField_a_of_type_Aiil == null)
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "[showAddPlaymateIntro] friendInfo is null return.");
        return;
      }
      localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    } while ((!localSharedPreferences.getBoolean("apollo_add_playMate_intro", true)) || (this.jdField_a_of_type_Aiil.jdField_c_of_type_Int != 0));
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(a());
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#cf000000"));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.t = 0;
    ImageView localImageView = new ImageView(a());
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setId(2131362749);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = agej.a(200.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = agej.a(100.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/add_playmate_intro.png", (URLDrawable.URLDrawableOptions)localObject));
    localImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(agej.a(91.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(41.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localLayoutParams1.addRule(11);
    localLayoutParams1.addRule(10);
    localLayoutParams1.setMargins(0, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + agej.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.addView(localImageView, localLayoutParams1);
    localImageView = new ImageView(a());
    localLayoutParams1 = new RelativeLayout.LayoutParams(agej.a(210.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localLayoutParams1.addRule(3, 2131362749);
    localLayoutParams1.addRule(11);
    localLayoutParams1.setMargins(0, 0, agej.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
    localObject = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/add_playmate_intro1.png", (URLDrawable.URLDrawableOptions)localObject);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setImageDrawable((Drawable)localObject);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.addView(localImageView, localLayoutParams1);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aiid(this));
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
    bhsq.a(null, "AIO_updateSession_business");
    if (this.jdField_a_of_type_Aiik == null) {
      this.jdField_a_of_type_Aiik = new aiik(this);
    }
    ((amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().a(this.jdField_a_of_type_Aiik);
    bhsq.a("AIO_updateSession_business", null);
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
      a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Aiil.jdField_a_of_type_JavaLangString, 2);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.needTopPadding = false;
        this.jdField_a_of_type_Aggs.notifyDataSetChanged();
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
            if (this.jdField_d_of_type_Bhpc == null)
            {
              localObject = bhlq.a(a(), 230).setMessage(a().getString(2131695047)).setTitle(a().getString(2131695048)).setNegativeButton(2131690580, new aiig(this));
              if (!mvd.a(a())) {
                break label218;
              }
            }
            label218:
            for (int j = 2131695049;; j = 2131695050)
            {
              this.jdField_d_of_type_Bhpc = ((bhpc)localObject).setPositiveButton(j, new aiif(this));
              this.jdField_d_of_type_Bhpc.show();
              break;
            }
          }
          if ("dialog_type_confirm".equals(localObject))
          {
            if (this.c == null) {
              this.c = bhlq.a(a(), 230).setMessage(anzj.a(2131700970)).setPositiveButton(a().getString(2131694098), new aiii(this)).setNegativeButton(a().getString(2131690580), new aiih(this));
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
    Object localObject = (amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    anaj localanaj = ((amsx)localObject).a();
    localanaj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1);
    localanaj.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localObject = ((amsx)localObject).a();
    if ((amzq.jdField_a_of_type_Boolean) && (!((amzq)localObject).b())) {
      ((amzq)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 319);
    }
    if ((!TextUtils.isEmpty(((amzq)localObject).a())) && (((amzq)localObject).a().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130839215);
    }
    localanaj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 319);
    localanaj.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     aihy
 * JD-Core Version:    0.7.0.1
 */