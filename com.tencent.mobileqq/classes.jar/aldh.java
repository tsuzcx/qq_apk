import MWIFI.SCGet3rdCloudCheck;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager.43;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.data.GameNoticeCenter;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.mobileqq.widget.AdvancedTipsBar;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import cooperation.qlink.QlAndQQInterface.WorkState;
import cooperation.qzone.report.lp.LpReportInfo_dc00307;
import cooperation.qzone.report.lp.LpReportManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_8410;

public class aldh
  implements Handler.Callback
{
  public static final boolean a;
  public float a;
  public int a;
  public long a;
  private volatile alfg jdField_a_of_type_Alfg;
  private alga jdField_a_of_type_Alga;
  private aljk jdField_a_of_type_Aljk;
  private SparseArray<ArrayList<Integer>> jdField_a_of_type_AndroidUtilSparseArray;
  private awza jdField_a_of_type_Awza;
  private bbbu jdField_a_of_type_Bbbu;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private GameNoticeCenter jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bhde(this);
  private aldd[] jdField_a_of_type_ArrayOfAldd = new aldd[50];
  public int b;
  public long b;
  private volatile alfg jdField_b_of_type_Alfg;
  private SparseArray<ArrayList<Integer>> jdField_b_of_type_AndroidUtilSparseArray;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  private String e;
  public boolean e;
  boolean f = false;
  public boolean g;
  private boolean h = true;
  private boolean i;
  private boolean j;
  private boolean k = true;
  
  static
  {
    jdField_a_of_type_Boolean = AppSetting.jdField_c_of_type_Boolean;
  }
  
  public aldh(BaseActivity paramBaseActivity, XListView paramXListView)
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    if (this.jdField_c_of_type_Int == 0) {
      this.jdField_c_of_type_Int = AIOUtils.dp2px(50.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
    }
    this.jdField_a_of_type_Aljk = new aljk();
  }
  
  private View A()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130841342));
    localTipsBar.a(true);
    localTipsBar.setOnClickListener(new aled(this));
    localTipsBar.setCloseListener(new alff(1134060, ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime()).getHandler(Conversation.class)));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View B()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReaderBar", 2, "initReaderBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.a(true);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838402));
    return localTipsBar;
  }
  
  private View C()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RunningBar", 2, "initRunningBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsText(anvx.a(2131700428));
    localTipsBar.a(true);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838403));
    return localTipsBar;
  }
  
  private View D()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BrowserBar", 2, "initBrowserBar");
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131558662, null);
    localView.findViewById(2131362514).setVisibility(8);
    return localView;
  }
  
  private View E()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComicBar", 2, "initComicBar");
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131558664, null);
    localView.findViewById(2131362542).setVisibility(8);
    return localView;
  }
  
  private View F()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameBar", 2, "initGameBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838394));
    localTipsBar.setVisibility(8);
    localTipsBar.a(true);
    return localTipsBar;
  }
  
  private View G()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131563031, null);
    TextView localTextView = (TextView)localView.findViewById(2131380517);
    localTextView.setOnClickListener(new alem(this));
    localTextView.setText("");
    if (AppSetting.jdField_c_of_type_Boolean) {
      localTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719829));
    }
    ((ImageView)localView.findViewById(2131364706)).setOnClickListener(new alen(this));
    localView.findViewById(2131380516).setVisibility(8);
    return localView;
  }
  
  private View H()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131559523, null);
    localView.setOnClickListener(new aleo(this));
    localView.findViewById(2131371686).setVisibility(8);
    return localView;
  }
  
  private View I()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839534));
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718568));
    localTipsBar.setOnClickListener(new alep(this));
    bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 18, 0, "", "", "", "");
    return localTipsBar;
  }
  
  private View J()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131559690, null);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    localView.findViewById(2131373401).setVisibility(8);
    ((LinearLayout)localView.findViewById(2131364699)).setOnClickListener(new aleq(this));
    return localView;
  }
  
  private View K()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130844968));
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698368));
    localTipsBar.setOnClickListener(new ales(this));
    return localTipsBar;
  }
  
  private View L()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131561883, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131374749);
    localView.setOnClickListener(new alet(this));
    localImageView.setOnClickListener(new aleu(this));
    return localView;
  }
  
  private View M()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.a(true);
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View N()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initWiFiSecurityBanner");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(4);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838319));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View O()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130847001));
    localTipsBar.b(true);
    localTipsBar.setOnClickListener(new alex(this));
    return localTipsBar;
  }
  
  @Nullable
  public static alfg a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, alfe paramalfe)
  {
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null)
    {
      paramString1 = new alfg(1, paramString1, paramInt, paramString2, paramalfe);
      paramString2 = paramQQAppInterface.obtainMessage(1134200);
      paramString2.obj = paramString1;
      paramQQAppInterface.sendMessage(paramString2);
      return paramString1;
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    int m = 32;
    if (m <= 41)
    {
      if (this.jdField_a_of_type_ArrayOfAldd[m] == null) {}
      for (;;)
      {
        m += 1;
        break;
        if (this.jdField_a_of_type_ArrayOfAldd[m].jdField_b_of_type_Int == 2) {
          if (m != paramInt)
          {
            c(m, paramInt);
            this.jdField_a_of_type_ArrayOfAldd[m].jdField_b_of_type_Int = 0;
          }
          else if ((m == 41) && (this.jdField_a_of_type_Alfg != null) && (!this.jdField_b_of_type_Alfg.equals(this.jdField_a_of_type_Alfg)))
          {
            c(m, paramInt);
          }
        }
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      if (paramInt2 <= paramInt3)
      {
        if ((this.jdField_a_of_type_ArrayOfAldd[paramInt2] == null) || (!this.jdField_a_of_type_ArrayOfAldd[paramInt2].a())) {
          break label55;
        }
        ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt1);
        if (localArrayList != null) {
          localArrayList.add(Integer.valueOf(paramInt2));
        }
      }
      return;
      label55:
      paramInt2 += 1;
    }
  }
  
  private void a(int paramInt, Message paramMessage, aldd paramaldd)
  {
    QLog.d("Q.recent.banner", 1, new Object[] { "[banner] addBannerViewToMsgTabHeader: invoked. ", " bannerId: ", Integer.valueOf(paramInt), " refreshMsg: ", paramMessage, " banner: ", paramaldd });
    if (paramaldd == null) {
      return;
    }
    a(paramaldd);
    for (;;)
    {
      try
      {
        if ((paramaldd.jdField_a_of_type_AndroidViewView != null) && (!paramaldd.jdField_a_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "fight.addHeaderView_3.");
          }
          if ((paramaldd.jdField_a_of_type_Int == 24) && (this.g)) {
            paramaldd.jdField_a_of_type_AndroidViewView.findViewById(2131373401).getLayoutParams().height = 0;
          }
          this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(paramaldd.jdField_a_of_type_AndroidViewView, 1);
          if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
            continue;
          }
          localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
          aldg.a(localQQAppInterface, paramaldd.jdField_a_of_type_Int);
          paramaldd.jdField_a_of_type_Boolean = true;
        }
      }
      catch (Exception localException)
      {
        QQAppInterface localQQAppInterface;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("Q.recent.banner", 4, "initBanner|" + localException.toString());
        continue;
        a(paramaldd, paramMessage);
      }
      if ((paramMessage != null) && (paramInt == paramaldd.jdField_a_of_type_Int)) {
        continue;
      }
      a(paramaldd, null);
      return;
      localQQAppInterface = null;
    }
  }
  
  private void a(aldd paramaldd)
  {
    if ((paramaldd == null) || (paramaldd.jdField_a_of_type_AndroidViewView != null)) {}
    for (;;)
    {
      return;
      try
      {
        b(paramaldd);
        c(paramaldd);
        d(paramaldd);
        e(paramaldd);
        g(paramaldd);
        f(paramaldd);
        h(paramaldd);
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("Q.recent.banner", 4, "initBannerView | banner = " + paramaldd);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  private void a(aldd paramaldd, Message paramMessage)
  {
    boolean bool = false;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateBanner| banner = ").append(paramaldd).append(", msg = ").append(paramMessage).append(" isGeneral? ");
      if (paramaldd.jdField_a_of_type_Int == 41) {
        bool = true;
      }
      QLog.d("Q.recent.banner", 4, Boolean.toString(bool));
    }
    if ((paramaldd == null) || (paramaldd.jdField_a_of_type_AndroidViewView == null)) {
      label84:
      return;
    }
    TextHook.updateFont(paramaldd.jdField_a_of_type_AndroidViewView);
    for (;;)
    {
      try
      {
        switch (paramaldd.jdField_a_of_type_Int)
        {
        case 8: 
        case 18: 
        case 19: 
        case 20: 
        case 22: 
        case 32: 
        case 46: 
        case 48: 
          if (!(paramaldd.jdField_a_of_type_AndroidViewView instanceof TipsBar)) {
            break label84;
          }
          a((TipsBar)paramaldd.jdField_a_of_type_AndroidViewView);
          return;
        }
      }
      catch (Throwable paramaldd)
      {
        paramaldd.printStackTrace();
        return;
      }
      b(paramaldd.jdField_a_of_type_AndroidViewView);
      continue;
      n(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      j(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      m(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      i(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      a(paramaldd.jdField_a_of_type_AndroidViewView);
      continue;
      o(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      c(paramaldd.jdField_a_of_type_AndroidViewView);
      continue;
      paramaldd.jdField_a_of_type_AndroidViewView.findViewById(2131380516).setVisibility(0);
      continue;
      paramaldd.jdField_a_of_type_AndroidViewView.findViewById(2131380516).setVisibility(0);
      continue;
      w(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      d(paramaldd.jdField_a_of_type_AndroidViewView);
      continue;
      q(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      r(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      s(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      u(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      t(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      v(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter.updateGameCenterBar(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        x(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        e(paramaldd.jdField_a_of_type_AndroidViewView);
        continue;
        c(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        b(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage, paramaldd.jdField_b_of_type_Int);
        continue;
        a(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage, paramaldd.jdField_b_of_type_Int);
        continue;
        f(paramaldd.jdField_a_of_type_AndroidViewView);
        continue;
        g(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        h(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        l(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        f(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        d(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        e(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        aqni.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(this, paramaldd.jdField_a_of_type_AndroidViewView);
        continue;
        p(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        z(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        y(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        g(paramaldd.jdField_a_of_type_AndroidViewView);
        continue;
        k(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        a(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        paramaldd.jdField_a_of_type_AndroidViewView.setVisibility(0);
        continue;
        b(paramaldd.jdField_a_of_type_AndroidViewView, paramMessage);
      }
    }
  }
  
  private void a(alfg paramalfg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "hideGeneralBannerInBInternal with: " + paramalfg);
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(201);
    localMessage.obj = paramalfg;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  private void a(View paramView)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    paramView.setVisibility(0);
    ((TipsBar)paramView).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691053));
  }
  
  private void a(View paramView, Message paramMessage)
  {
    paramView.setVisibility(0);
  }
  
  private void a(View paramView, Message paramMessage, int paramInt)
  {
    if ((paramMessage == null) || (paramMessage.obj == null) || (!(paramMessage.obj instanceof ajcn))) {
      return;
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8005B72", "0X8005B72", 0, 0, "", "", "", "");
    paramView.findViewById(2131374321).setVisibility(0);
    paramMessage = (ajcn)paramMessage.obj;
    ((TextView)paramView.findViewById(2131363389)).setText(paramMessage.jdField_b_of_type_JavaLangString);
    bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 5, 0, "", "", "", "");
    paramView.setOnClickListener(new alfb(this, paramMessage));
  }
  
  public static void a(Conversation paramConversation)
  {
    if ((paramConversation != null) && (paramConversation.a != null) && (paramConversation.a.a(26) != 0))
    {
      paramConversation = paramConversation.a.a();
      if (paramConversation != null)
      {
        paramConversation.removeMessages(9);
        paramConversation.sendEmptyMessage(9);
      }
    }
  }
  
  public static void a(Conversation paramConversation, bbbu parambbbu)
  {
    if ((paramConversation == null) || (paramConversation.a == null) || (paramConversation.a.a(26) != 0)) {}
    do
    {
      return;
      paramConversation = paramConversation.a.a();
    } while (paramConversation == null);
    paramConversation.removeMessages(9);
    Message localMessage = paramConversation.obtainMessage(8, parambbbu);
    localMessage.obj = parambbbu;
    paramConversation.sendMessage(localMessage);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    int m = 0;
    if ((!paramIntent.hasExtra("banner_businessCategory")) || (!paramIntent.hasExtra("banner_wording"))) {
      return;
    }
    String str1 = paramIntent.getStringExtra("banner_businessCategory");
    String str2 = paramIntent.getStringExtra("banner_wording");
    String str3 = paramIntent.getStringExtra("banner_webViewUrl");
    String str4 = paramIntent.getStringExtra("banner_activityName");
    String str5 = paramIntent.getStringExtra("banner_fragmentName");
    int n = paramIntent.getIntExtra("banner_iconIdx", -1);
    int i1 = paramIntent.getIntExtra("banner_activityFlag", 0);
    PendingIntent localPendingIntent = (PendingIntent)paramIntent.getParcelableExtra("banner_pendingIntent");
    Bundle localBundle = paramIntent.getBundleExtra("banner_webview_extra");
    boolean bool = paramIntent.getBooleanExtra("force_no_reload", false);
    if (!TextUtils.isEmpty(str3)) {
      m = 1;
    }
    if (str5 != null)
    {
      a(str5, paramIntent, paramQQAppInterface, str1, str2);
      return;
    }
    if (m != 0)
    {
      a(paramQQAppInterface, str1, str2, str3, str4, n, i1, localBundle, bool);
      return;
    }
    if (str1.equals("readinjoy_video_feeds"))
    {
      sfw.a(paramQQAppInterface, paramIntent, localPendingIntent, str1, str2);
      return;
    }
    if (localPendingIntent == null)
    {
      a(paramQQAppInterface, paramIntent, str1, str2, str4);
      return;
    }
    a(paramQQAppInterface, paramIntent, localPendingIntent, str1, str2);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, PendingIntent paramPendingIntent, String paramString1, String paramString2)
  {
    int m = paramIntent.getIntExtra("banner_iconIdx", -1);
    if ((paramPendingIntent == null) || (m < 0) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("Q.recent.banner", 1, "invalid intent extra from pendingIntent, " + paramString1 + " / " + paramString2 + " / " + paramPendingIntent + " / " + m);
      return;
    }
    paramIntent = new alfj(paramPendingIntent, paramQQAppInterface);
    paramIntent.a(a(paramQQAppInterface, m, paramString1, paramString2, paramIntent));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, String paramString1, String paramString2, String paramString3)
  {
    int m = paramIntent.getIntExtra("banner_plguinType", -1);
    String str1 = paramIntent.getStringExtra("banner_pluginId");
    String str2 = paramIntent.getStringExtra("banner_pluginName");
    String str3 = paramIntent.getStringExtra("banner_pluginProxyActivityName");
    Intent localIntent = (Intent)paramIntent.getParcelableExtra("banner_pluginIntent");
    int n = paramIntent.getIntExtra("banner_iconIdx", -1);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (m < 0) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (localIntent == null) || (n < 0))
    {
      QLog.e("Q.recent.banner", 1, "invalid intent extra from plugin, " + paramString1 + " / " + paramString2 + " / " + paramString3 + " / " + m + " / " + str1 + " / " + str2 + " / " + str3 + " / " + localIntent + " / " + n);
      return;
    }
    paramIntent = new alfk(paramQQAppInterface, paramString3, str3, str1, str2, localIntent, paramQQAppInterface.getCurrentUin(), m);
    paramIntent.a(a(paramQQAppInterface, n, paramString1, paramString2, paramIntent));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, Bundle paramBundle, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      QLog.e("Q.recent.banner", 1, "invalid intent extra from webview, " + paramString1 + " / " + paramString2 + " / " + paramString3);
      return;
    }
    try
    {
      String str1 = new URL(paramString3).getHost();
      paramString3 = new alfl(paramString3, paramQQAppInterface, paramString4, paramInt2, paramBundle, paramBoolean);
      paramInt2 = paramInt1;
      if (paramInt1 < 0) {
        paramInt2 = alde.a(str1);
      }
      paramString3.a(a(paramQQAppInterface, paramInt2, paramString1, paramString2, paramString3));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        localMalformedURLException.printStackTrace();
        String str2 = "";
      }
    }
  }
  
  private void a(TipsBar paramTipsBar, int paramInt)
  {
    if ((paramInt == 2) && (this.j) && ((ThemeUtil.isDefaultTheme()) || (ThemeUtil.isSimpleDayTheme(false))))
    {
      paramTipsBar.setBarType(6);
      return;
    }
    paramTipsBar.setBarType(paramInt);
  }
  
  private static void a(String paramString1, Intent paramIntent, QQAppInterface paramQQAppInterface, String paramString2, String paramString3)
  {
    int m = paramIntent.getIntExtra("banner_iconIdx", -1);
    paramString1 = new alfd(paramString1, paramQQAppInterface);
    paramString1.a(a(paramQQAppInterface, m, paramString2, paramString3, paramString1));
  }
  
  private boolean a(View paramView)
  {
    aqwk localaqwk = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getConfig(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin(), false);
    if (localaqwk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushBannerConfig", 2, "loadPushBanner");
      }
      s();
      return false;
    }
    int i2 = localaqwk.a(0);
    if (i2 > 0)
    {
      ((ADView)paramView.findViewById(2131362239)).h();
      int m = 0;
      int i1;
      for (int n = 0; m < i2; n = i1)
      {
        i1 = n;
        if (a(localaqwk, m, paramView)) {
          i1 = n + 1;
        }
        m += 1;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent.banner", 4, "loadPushBanner, addnum = " + n);
      }
      if (n > 0)
      {
        p();
        return true;
      }
    }
    return false;
  }
  
  private boolean a(aqwk paramaqwk, int paramInt, View paramView)
  {
    bdno localbdno = new bdno(paramaqwk.a(0, paramInt), paramaqwk.b(0, paramInt), paramaqwk.a(0, paramInt));
    localbdno.l = paramaqwk.a(0, paramInt);
    localbdno.m = paramaqwk.c(0, paramInt);
    boolean bool = localbdno.a(paramaqwk.a(0, paramInt));
    if ((localbdno.jdField_c_of_type_JavaLangString != null) && (localbdno.jdField_c_of_type_JavaLangString.contains("|")) && (!bgyr.a(Long.parseLong(localbdno.jdField_c_of_type_JavaLangString.substring(0, localbdno.jdField_c_of_type_JavaLangString.indexOf("|"))), Long.parseLong(localbdno.jdField_c_of_type_JavaLangString.substring(localbdno.jdField_c_of_type_JavaLangString.indexOf("|") + 1))))) {}
    label470:
    for (;;)
    {
      return false;
      if ((bool) && (!"".equals(localbdno.j)))
      {
        localbdno.jdField_a_of_type_Bheh = bhey.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localbdno.j);
        if (localbdno.jdField_a_of_type_Bheh == null) {}
        for (int m = 0;; m = 1)
        {
          if (m == 0) {
            break label470;
          }
          Object localObject = paramaqwk.a(0, paramInt);
          if (QLog.isDevelopLevel()) {
            QLog.i("PUSH BANNER", 4, "addPushBanner, bannerPic = " + localObject);
          }
          if (localObject == null) {
            break;
          }
          paramaqwk = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131559691, null);
          ImageView localImageView = (ImageView)paramaqwk.findViewById(2131362018);
          localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          localImageView.setImageBitmap((Bitmap)localObject);
          DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
          m = ((Bitmap)localObject).getHeight() * Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) / ((Bitmap)localObject).getWidth();
          localLayoutParams.height = Math.max((int)(30.0F * localDisplayMetrics.density), Math.min(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) * 68 / 320, m));
          localImageView.setLayoutParams(localLayoutParams);
          localObject = (ImageView)paramaqwk.findViewById(2131373412);
          ((ImageView)localObject).setTag(localbdno);
          ((ImageView)localObject).setContentDescription(anvx.a(2131700427));
          ((ImageView)localObject).setOnClickListener(new alev(this));
          paramaqwk.setTag(localbdno);
          ((ADView)paramView.findViewById(2131362239)).a(paramaqwk, paramInt);
          paramView.setTag(2131362239, localbdno.jdField_a_of_type_JavaLangString);
          return true;
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, alfg paramalfg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "hideGeneralBannerInB with: " + paramalfg);
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null)
    {
      Message localMessage = paramQQAppInterface.obtainMessage(1134201);
      localMessage.obj = paramalfg;
      paramQQAppInterface.sendMessage(localMessage);
      return true;
    }
    return false;
  }
  
  private View b()
  {
    TipsBar localTipsBar = aoms.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    return localTipsBar;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if (paramInt2 != 2) {
        break label31;
      }
      aldg.a(localQQAppInterface, paramInt1);
    }
    label31:
    while (paramInt2 != 0)
    {
      return;
      localQQAppInterface = null;
      break;
    }
    aldg.b(localQQAppInterface, paramInt1);
  }
  
  private void b(aldd paramaldd)
  {
    switch (paramaldd.jdField_a_of_type_Int)
    {
    case 8: 
    case 22: 
    default: 
      return;
    case 1: 
      paramaldd.jdField_a_of_type_AndroidViewView = q();
      return;
    case 7: 
      paramaldd.jdField_a_of_type_AndroidViewView = t();
      return;
    case 9: 
      paramaldd.jdField_a_of_type_AndroidViewView = a();
      return;
    case 10: 
      paramaldd.jdField_a_of_type_AndroidViewView = v();
      return;
    case 11: 
      paramaldd.jdField_a_of_type_AndroidViewView = r();
      return;
    case 12: 
      paramaldd.jdField_a_of_type_AndroidViewView = q();
      return;
    case 26: 
      paramaldd.jdField_a_of_type_AndroidViewView = u();
      return;
    case 14: 
      paramaldd.jdField_a_of_type_AndroidViewView = x();
      return;
    case 15: 
      paramaldd.jdField_a_of_type_AndroidViewView = w();
      return;
    case 16: 
      paramaldd.jdField_a_of_type_AndroidViewView = w();
      return;
    case 17: 
      paramaldd.jdField_a_of_type_AndroidViewView = G();
      return;
    case 19: 
      paramaldd.jdField_a_of_type_AndroidViewView = y();
      return;
    case 24: 
      paramaldd.jdField_a_of_type_AndroidViewView = J();
      return;
    case 23: 
      paramaldd.jdField_a_of_type_AndroidViewView = e();
      return;
    case 20: 
      paramaldd.jdField_a_of_type_AndroidViewView = I();
      return;
    case 5: 
      paramaldd.jdField_a_of_type_AndroidViewView = f();
      return;
    case 2: 
      paramaldd.jdField_a_of_type_AndroidViewView = b();
      return;
    case 3: 
      paramaldd.jdField_a_of_type_AndroidViewView = g();
      return;
    case 21: 
      paramaldd.jdField_a_of_type_AndroidViewView = s();
      return;
    case 25: 
      paramaldd.jdField_a_of_type_AndroidViewView = L();
      return;
    case 18: 
      paramaldd.jdField_a_of_type_AndroidViewView = K();
      return;
    case 27: 
      paramaldd.jdField_a_of_type_AndroidViewView = l();
      return;
    case 28: 
      paramaldd.jdField_a_of_type_AndroidViewView = m();
      return;
    case 6: 
      paramaldd.jdField_a_of_type_AndroidViewView = k();
      return;
    case 29: 
      paramaldd.jdField_a_of_type_AndroidViewView = i();
      return;
    case 30: 
      paramaldd.jdField_a_of_type_AndroidViewView = j();
      return;
    case 13: 
      paramaldd.jdField_a_of_type_AndroidViewView = h();
      return;
    }
    paramaldd.jdField_a_of_type_AndroidViewView = N();
  }
  
  private void b(alfg paramalfg)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(201);
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(201);
    localMessage.obj = paramalfg;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 900000L);
  }
  
  private void b(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "hideGeneralBanner: " + paramMessage);
    }
    if (!(paramMessage.obj instanceof alfg)) {}
    do
    {
      return;
      int m = ((alfg)paramMessage.obj).jdField_a_of_type_Int;
    } while (!paramMessage.obj.equals(this.jdField_a_of_type_Alfg));
    a(41, 0);
    a(41, paramMessage);
  }
  
  private void b(View paramView)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    paramView.setVisibility(0);
    ((TipsBar)paramView).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694258));
    if (a(14))
    {
      a(14, 0);
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_b_of_type_Int = -1;
      this.jdField_d_of_type_JavaLangString = null;
    }
    bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 1, 0, "", "", "", "");
  }
  
  private void b(View paramView, Message paramMessage)
  {
    if (((paramView instanceof NewerGuideBannerView)) && ((paramMessage.obj instanceof oidb_0x59f.Guidelines_8410))) {
      ((NewerGuideBannerView)paramView).a((oidb_0x59f.Guidelines_8410)paramMessage.obj);
    }
  }
  
  private void b(View paramView, Message paramMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "updateMissedCallBar state: " + paramInt);
    }
    paramMessage = (bapk)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    if (paramMessage != null) {}
    for (int m = paramMessage.a();; m = 0)
    {
      if (m == 0) {}
      do
      {
        do
        {
          return;
          if (paramInt != 0) {
            break;
          }
        } while (paramView.getVisibility() != 0);
        paramView.setVisibility(8);
        return;
        paramView.findViewById(2131374319).setVisibility(0);
        ((TextView)paramView.findViewById(2131374320)).setText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698340), new Object[] { Integer.valueOf(m) }));
      } while (m > 0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(7);
      return;
    }
  }
  
  private View c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComicBar", 2, "initComicBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "[notifyBannerIsOverride], type is " + paramInt1 + " / " + paramInt2);
    }
    if ((paramInt1 == 41) && (this.jdField_a_of_type_Alfg != null)) {
      this.jdField_a_of_type_Alfg.jdField_a_of_type_Alfe.onOverride();
    }
    do
    {
      do
      {
        return;
      } while (paramInt1 != 39);
      localObject = amyv.a();
    } while (localObject == null);
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if (localQQAppInterface == null) {
        break label178;
      }
      if (((amyv)localObject).a != null) {
        break label147;
      }
    }
    label147:
    for (Object localObject = "-1";; localObject = ((amyv)localObject).a.gameId + "")
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "mutex_bar", 0, 0, new String[] { localObject });
      return;
      localQQAppInterface = null;
      break;
    }
    label178:
    QLog.e("Q.recent.banner", 1, "[notifyBannerStateChange] app null");
  }
  
  private void c(aldd paramaldd)
  {
    switch (paramaldd.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    paramaldd.jdField_a_of_type_AndroidViewView = O();
  }
  
  private void c(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof alfg)) {
      return;
    }
    int m = ((alfg)paramMessage.obj).jdField_a_of_type_Int;
    this.jdField_b_of_type_Alfg = ((alfg)paramMessage.obj);
    a(41, 2);
    this.jdField_a_of_type_Alfg = this.jdField_b_of_type_Alfg;
    a(41, paramMessage);
    b((alfg)paramMessage.obj);
  }
  
  private void c(View paramView)
  {
    if (!(paramView instanceof TipsBar)) {
      return;
    }
    TipsBar localTipsBar = (TipsBar)paramView;
    a(localTipsBar);
    if ((this.jdField_c_of_type_JavaLangString != null) && ("1600000104".equals(this.jdField_c_of_type_JavaLangString.trim())))
    {
      localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690721));
      return;
    }
    if ((znj.b(this.jdField_b_of_type_Int)) && (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {
      this.jdField_d_of_type_JavaLangString = "手表QQ已登录";
    }
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      localTipsBar.setTipsText(this.jdField_d_of_type_JavaLangString);
      if (this.jdField_b_of_type_Int != 5) {
        break label218;
      }
      localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839160));
      label126:
      if (this.jdField_b_of_type_Int != 4) {
        break label268;
      }
    }
    label268:
    for (int m = 23;; m = 10)
    {
      bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", m, 0, "", "", "", "");
      return;
      paramView = "QQ";
      if (this.jdField_b_of_type_Long == 77313L) {
        paramView = "TIM";
      }
      localTipsBar.setTipsText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694516), new Object[] { paramView }));
      break;
      label218:
      if (znj.b(this.jdField_b_of_type_Int))
      {
        localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839162));
        break label126;
      }
      localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839161));
      break label126;
    }
  }
  
  private void c(View paramView, Message paramMessage)
  {
    if (paramMessage != null)
    {
      if (this.jdField_a_of_type_Alga != null) {
        this.jdField_a_of_type_Alga.c();
      }
      bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 11, 0, "", "", "", "");
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface)
  {
    a(18, 0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    if ((this.jdField_a_of_type_Awza != null) && (paramQQAppInterface != null))
    {
      ((PhoneContactManagerImp)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).b(this.jdField_a_of_type_Awza);
      this.jdField_a_of_type_Awza = null;
    }
  }
  
  private View d()
  {
    return new NewerGuideBannerView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  private void d(aldd paramaldd)
  {
    switch (paramaldd.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 40: 
      paramaldd.jdField_a_of_type_AndroidViewView = A();
      return;
    case 33: 
      paramaldd.jdField_a_of_type_AndroidViewView = B();
      return;
    case 38: 
      paramaldd.jdField_a_of_type_AndroidViewView = C();
      return;
    case 39: 
      paramaldd.jdField_a_of_type_AndroidViewView = n();
      return;
    case 34: 
      paramaldd.jdField_a_of_type_AndroidViewView = E();
      return;
    case 35: 
      paramaldd.jdField_a_of_type_AndroidViewView = D();
      return;
    case 37: 
      paramaldd.jdField_a_of_type_AndroidViewView = F();
      return;
    case 36: 
      TipsBar localTipsBar = GameNoticeCenter.createBanner(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      a(localTipsBar, 2);
      paramaldd.jdField_a_of_type_AndroidViewView = localTipsBar;
      return;
    }
    paramaldd.jdField_a_of_type_AndroidViewView = M();
  }
  
  private void d(View paramView)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if (QQPlayerService.a())
    {
      paramView.setVisibility(0);
      SongInfo localSongInfo = QQPlayerService.b();
      if (localSongInfo != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694700);
        ((TipsBar)paramView).setTipsText(Html.fromHtml(str + " " + localSongInfo.jdField_c_of_type_JavaLangString));
      }
      bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EE0", "0X8009EE0", 1, 0, "", "", "", "");
      return;
    }
    paramView.setVisibility(8);
    a(42, 0);
    a(-1, null);
  }
  
  private void d(View paramView, Message paramMessage)
  {
    paramView = (TipsBar)paramView;
    paramView.setVisibility(0);
    a(paramView);
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      paramView.setTipsText(((UpgradeTIMWrapper)paramMessage.obj).f);
    }
  }
  
  private void d(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "handleAccountChanged with: " + this.jdField_a_of_type_Alfg);
    }
    if ((this.jdField_a_of_type_Alfg != null) && (this.jdField_a_of_type_Alfg.jdField_a_of_type_Alfe.isNeedAutoCloseWhenAccountChange())) {
      a(this.jdField_a_of_type_Alfg);
    }
  }
  
  private View e()
  {
    if (this.jdField_a_of_type_Alga != null) {
      return this.jdField_a_of_type_Alga.a();
    }
    return null;
  }
  
  private void e(aldd paramaldd)
  {
    switch (paramaldd.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    paramaldd.jdField_a_of_type_AndroidViewView = z();
  }
  
  private void e(View paramView)
  {
    paramView.findViewById(2131373401).setVisibility(0);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131362240);
    paramView = (ADView)paramView.findViewById(2131362239);
    if (f())
    {
      localRelativeLayout.setPadding(0, 0, 0, 0);
      paramView.i();
    }
    for (;;)
    {
      bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 12, 0, "", "", "", "");
      return;
      localRelativeLayout.setPadding(0, -1, 0, 0);
    }
  }
  
  private void e(View paramView, Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null))
    {
      paramView = (TipsBar)paramView;
      a(paramView);
      paramView.setVisibility(0);
      paramMessage = (azeo)paramMessage.obj;
      paramView.setCloseListener(new aldv(this, paramMessage));
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "[status][banner] banner mgr show banner " + paramMessage.jdField_b_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramMessage.jdField_c_of_type_JavaLangString))
      {
        Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getApp().getResources().getDrawable(2130847435);
        paramView.setTipsIcon(URLDrawable.getDrawable(paramMessage.jdField_c_of_type_JavaLangString, localDrawable, localDrawable));
      }
      paramView.setTipsText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690269), new Object[] { paramMessage.jdField_b_of_type_JavaLangString }));
      paramView.setButtonText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690268));
      paramView.a(true);
      paramView.setOnClickListener(new aleg(this, paramMessage));
      paramView.setOriginalOnClickListener(new aler(this, paramMessage));
      azcl.a("0X800AF9E", (int)paramMessage.a);
    }
  }
  
  private boolean e()
  {
    aldd localaldd = this.jdField_a_of_type_ArrayOfAldd[49];
    return (localaldd != null) && (localaldd.jdField_b_of_type_Int == 2);
  }
  
  private View f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initSecurePhoneBanner");
    }
    TipsBar localTipsBar = bhav.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    return localTipsBar;
  }
  
  private void f(aldd paramaldd)
  {
    switch (paramaldd.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    paramaldd.jdField_a_of_type_AndroidViewView = c();
  }
  
  private void f(View paramView)
  {
    paramView.findViewById(2131374748).setVisibility(0);
    ((TextView)paramView.findViewById(2131374750)).setText(anvx.a(2131700415));
  }
  
  private void f(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if ((paramMessage != null) && (paramMessage.obj != null))
    {
      ((TipsBar)paramView).setTipsText((String)paramMessage.obj);
      paramView.setOnClickListener(new aley(this));
    }
  }
  
  private boolean f()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getConfiguration().orientation == 1;
  }
  
  private View g()
  {
    TipsBar localTipsBar = bcpn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    return localTipsBar;
  }
  
  private void g(aldd paramaldd)
  {
    switch (paramaldd.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 43: 
      paramaldd.jdField_a_of_type_AndroidViewView = H();
      return;
    case 45: 
      paramaldd.jdField_a_of_type_AndroidViewView = o();
      return;
    }
    paramaldd.jdField_a_of_type_AndroidViewView = p();
  }
  
  private void g(View paramView)
  {
    if (!(paramView instanceof TipsBar)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null) {
      return;
    }
    paramView = (TipsBar)paramView;
    a(paramView);
    zng localzng = (zng)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER);
    String str = localzng.a();
    if (TextUtils.isEmpty(str))
    {
      l();
      return;
    }
    paramView.setTipsText(str);
    int m = localzng.a();
    if (m == 1)
    {
      paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130847003));
      return;
    }
    if (m == 2)
    {
      paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130847002));
      return;
    }
    if (m == 3)
    {
      paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130847004));
      return;
    }
    paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130847001));
  }
  
  private void g(View paramView, Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {}
    for (;;)
    {
      return;
      paramView.setVisibility(0);
      ((TipsBar)paramView).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691283));
      a((TipsBar)paramView);
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {}
      for (QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app; (localQQAppInterface != null) && (paramMessage != null) && (paramMessage.obj != null); localQQAppInterface = null)
      {
        paramMessage = (String)paramMessage.obj;
        bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 16, 0, "", "", "", "");
        paramView.setOnClickListener(new alez(this, paramMessage));
        return;
      }
    }
  }
  
  private boolean g()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).getBoolean("reveive_newpb" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), false);
  }
  
  private View h()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698802));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839340));
    localTipsBar.setButtonText(anvx.a(2131700423));
    localTipsBar.a().setBackgroundResource(0);
    localTipsBar.a().setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167034));
    localTipsBar.setOriginalOnClickListener(new aldk(this));
    localTipsBar.setOnClickListener(new aldl(this));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void h(aldd paramaldd)
  {
    switch (paramaldd.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    paramaldd.jdField_a_of_type_AndroidViewView = d();
  }
  
  private void h(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if (localObject != null) {
        break label43;
      }
    }
    label43:
    while ((paramMessage == null) || (paramMessage.obj == null))
    {
      return;
      localObject = null;
      break;
    }
    paramMessage = (Bundle)paramMessage.obj;
    paramView = (TipsBar)paramView;
    paramView.setVisibility(0);
    paramView.setTipsText(paramMessage.getString("expireMsg"));
    int m = paramMessage.getInt("expireType", 4);
    Object localObject = paramMessage.getString("themeId");
    int n = paramMessage.getInt("authResult");
    int i1 = paramMessage.getInt("sSimpleOpen");
    bdla.b(null, "CliOper", "", "", "theme", "0X8007232", 0, 0, String.valueOf(m), "", "", "");
    bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 15, 0, "", "", "", "");
    paramView.setOnClickListener(new alfa(this, i1, n, (String)localObject, m));
  }
  
  private boolean h()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).getBoolean("push_banner_display" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), true);
  }
  
  private View i()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130850627));
    localTipsBar.a(true);
    UpgradeTIMWrapper localUpgradeTIMWrapper = UpgradeTIMWrapper.a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
    localTipsBar.setTipsText(localUpgradeTIMWrapper.f);
    localTipsBar.setOnClickListener(new aldm(this, localUpgradeTIMWrapper));
    localTipsBar.setCloseListener(new aldn(this, localUpgradeTIMWrapper));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void i(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null))
    {
      if (atuo.a().a())
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694700);
        String str = atuo.a().a();
        if (str != null)
        {
          ((TipsBar)paramView).setTipsText(paramMessage + "" + str);
          paramView.setVisibility(0);
          bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EE1", "0X8009EE1", 2, 0, "", "", "", "");
          return;
        }
        paramView.setVisibility(8);
        return;
      }
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(8);
  }
  
  private View j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "[status][banner] initAutoStatusBanner");
    }
    AdvancedTipsBar localAdvancedTipsBar = new AdvancedTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localAdvancedTipsBar, 2);
    localAdvancedTipsBar.a(true);
    localAdvancedTipsBar.setVisibility(8);
    return localAdvancedTipsBar;
  }
  
  private void j(View paramView, Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.arg1 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "updateNetNeedSignOn return, msg == null || msg.arg1==HIDE");
      }
      return;
    }
    if ((paramMessage != null) && ((paramMessage.obj instanceof String))) {}
    for (paramMessage = String.valueOf(paramMessage.obj);; paramMessage = "https://qq.com")
    {
      if (paramView.getVisibility() != 0) {
        paramView.setVisibility(0);
      }
      paramView.setOnClickListener(new alfc(this, paramMessage));
      bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004028", "0X8004028", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private View k()
  {
    return apzo.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  private void k(View paramView, Message paramMessage)
  {
    if (!(paramView instanceof TipsBar)) {}
    while ((paramMessage == null) || (!(paramMessage.obj instanceof String))) {
      return;
    }
    String str = (String)paramMessage.obj;
    int m = paramMessage.arg1;
    paramView = (TipsBar)paramView;
    paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839414));
    a(paramView);
    paramView.setTipsText(str);
    paramView.setOnClickListener(new aldj(this, m));
    paramView.setVisibility(0);
  }
  
  private View l()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 4);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691283));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838319));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void l(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("updateApolloGameBanner: ").append(paramView).append(" / ").append(paramMessage).append(" / ");
      if (paramMessage == null) {
        break label86;
      }
    }
    label86:
    for (Object localObject = paramMessage.obj;; localObject = null)
    {
      QLog.d("Q.recent.banner", 2, localObject);
      if (paramView != null) {
        break;
      }
      return;
    }
    paramView.setVisibility(0);
    if ((paramMessage != null) && ((paramMessage.obj instanceof String)))
    {
      ((TipsBar)paramView).setTipsText((String)paramMessage.obj);
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.", 2, " updateApolloGameBanner (String) msg.obj:" + (String)paramMessage.obj);
      }
    }
    bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 10, 0, "", "", "", "");
  }
  
  private View m()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130850615));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void m()
  {
    if (this.jdField_b_of_type_AndroidUtilSparseArray == null) {
      this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(7);
    }
    int m = 0;
    if (m < 7)
    {
      ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(m);
      if (localArrayList == null)
      {
        localArrayList = new ArrayList(1);
        this.jdField_b_of_type_AndroidUtilSparseArray.put(m, localArrayList);
      }
      for (;;)
      {
        m += 1;
        break;
        localArrayList.clear();
      }
    }
  }
  
  private void m(View paramView, Message paramMessage)
  {
    View localView = paramView.findViewById(2131374162);
    paramMessage = (TextView)paramView.findViewById(2131374163);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null))
    {
      int m = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getQQProxyForQlink().a();
      if (m != 0)
      {
        localView.setVisibility(0);
        int n = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getQQProxyForQlink().a().mMode;
        paramView = anvx.a(2131700419);
        if (1 == n) {
          paramView = anvx.a(2131700429);
        }
        for (;;)
        {
          paramMessage.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698108) + paramView + String.valueOf(m) + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698109));
          bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EE1", "0X8009EE1", 3, 0, "", "", "", "");
          return;
          if (2 == n) {
            paramView = anvx.a(2131700418);
          }
        }
      }
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(8);
  }
  
  private View n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.", 2, " initApolloGameBanner");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838568));
    localTipsBar.setTipsText(anvx.a(2131700421));
    localTipsBar.setVisibility(8);
    localTipsBar.a(true);
    localTipsBar.setOnClickListener(new aldo(this));
    localTipsBar.setCloseListener(new aldp(this));
    return localTipsBar;
  }
  
  private void n()
  {
    int n = this.jdField_a_of_type_Aljk.a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "[addNeedShowBannerIdsArrayExperiment] strategy id: " + n);
    }
    int m = n;
    if (n == -1) {
      m = 0;
    }
    aljl localaljl = this.jdField_a_of_type_Aljk.a(m).a();
    if (localaljl.jdField_a_of_type_Boolean) {
      a(0, 1, 30);
    }
    if (localaljl.b) {
      a(1, 31, 31);
    }
    if (localaljl.jdField_c_of_type_Boolean) {
      a(2, 32, 41);
    }
    if (localaljl.jdField_d_of_type_Boolean) {
      a(3, 42, 42);
    }
    if (localaljl.jdField_e_of_type_Boolean) {
      a(4, 43, 45);
    }
    if (localaljl.f) {
      a(5, 46, 47);
    }
    if (localaljl.g) {
      a(6, 48, 49);
    }
  }
  
  private void n(View paramView, Message paramMessage)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131381476);
    if (paramMessage != null)
    {
      if (paramMessage.arg1 != 1) {
        break label42;
      }
      localTextView.setText(2131720113);
    }
    for (;;)
    {
      paramView.findViewById(2131381475).setVisibility(0);
      return;
      label42:
      if (paramMessage.arg1 == 2) {
        localTextView.setText(2131720111);
      }
    }
  }
  
  private View o()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130841343));
    localTipsBar.setOnClickListener(new alds(this, localTipsBar));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "[addNeedShowBannerIdsArray]");
    }
    int m = 1;
    ArrayList localArrayList;
    if (m <= 30)
    {
      if ((this.jdField_a_of_type_ArrayOfAldd[m] == null) || (!this.jdField_a_of_type_ArrayOfAldd[m].a())) {
        break label411;
      }
      localArrayList = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(0);
      if (this.jdField_b_of_type_AndroidUtilSparseArray != null) {
        localArrayList.add(Integer.valueOf(m));
      }
    }
    m = 31;
    label76:
    if (m <= 31)
    {
      if ((this.jdField_a_of_type_ArrayOfAldd[m] == null) || (!this.jdField_a_of_type_ArrayOfAldd[m].a())) {
        break label418;
      }
      localArrayList = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(1);
      if (this.jdField_b_of_type_AndroidUtilSparseArray != null) {
        localArrayList.add(Integer.valueOf(m));
      }
    }
    m = 32;
    label134:
    if (m <= 41)
    {
      if ((this.jdField_a_of_type_ArrayOfAldd[m] == null) || (!this.jdField_a_of_type_ArrayOfAldd[m].a())) {
        break label425;
      }
      localArrayList = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(2);
      if (this.jdField_b_of_type_AndroidUtilSparseArray != null) {
        localArrayList.add(Integer.valueOf(m));
      }
    }
    m = 42;
    label192:
    if (m <= 42)
    {
      if ((this.jdField_a_of_type_ArrayOfAldd[m] == null) || (!this.jdField_a_of_type_ArrayOfAldd[m].a())) {
        break label432;
      }
      localArrayList = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(3);
      if (localArrayList != null) {
        localArrayList.add(Integer.valueOf(m));
      }
    }
    m = 43;
    label247:
    if (m <= 45)
    {
      if ((this.jdField_a_of_type_ArrayOfAldd[m] == null) || (!this.jdField_a_of_type_ArrayOfAldd[m].a())) {
        break label439;
      }
      localArrayList = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(4);
      if (localArrayList != null) {
        localArrayList.add(Integer.valueOf(m));
      }
    }
    m = 46;
    label302:
    if (m <= 47)
    {
      if ((this.jdField_a_of_type_ArrayOfAldd[m] == null) || (!this.jdField_a_of_type_ArrayOfAldd[m].a())) {
        break label446;
      }
      localArrayList = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(5);
      if (localArrayList != null) {
        localArrayList.add(Integer.valueOf(m));
      }
    }
    m = 48;
    for (;;)
    {
      if (m <= 49)
      {
        if ((this.jdField_a_of_type_ArrayOfAldd[m] == null) || (!this.jdField_a_of_type_ArrayOfAldd[m].a())) {
          break label453;
        }
        localArrayList = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(6);
        if (localArrayList != null) {
          localArrayList.add(Integer.valueOf(m));
        }
      }
      return;
      label411:
      m += 1;
      break;
      label418:
      m += 1;
      break label76;
      label425:
      m += 1;
      break label134;
      label432:
      m += 1;
      break label192;
      label439:
      m += 1;
      break label247;
      label446:
      m += 1;
      break label302;
      label453:
      m += 1;
    }
  }
  
  private void o(View paramView, Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.what == 8))
    {
      if ((paramMessage.obj instanceof bbbu))
      {
        paramMessage = (bbbu)paramMessage.obj;
        this.jdField_a_of_type_Bbbu = paramMessage;
        bmlf.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, paramMessage, this.jdField_a_of_type_MqqOsMqqHandler, this.j);
      }
      return;
    }
    if (paramView.getVisibility() == 8)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(9);
      this.jdField_a_of_type_Bbbu = null;
      return;
    }
    bmlf.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, this.jdField_a_of_type_Bbbu, this.j);
  }
  
  private View p()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131560936, null);
    localView.setOnClickListener(new aldt(this));
    localView.findViewById(2131374162).setVisibility(8);
    return localView;
  }
  
  private void p()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(101);
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(11, 0);
    localCalendar.clear(12);
    localCalendar.clear(13);
    localCalendar.clear(14);
    l = localCalendar.getTimeInMillis() - (l - 10L) + 300000L;
    if (QLog.isColorLevel()) {
      QLog.d("PushBanner", 2, "Check banner delay: " + l);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(101, l);
  }
  
  private void p(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if (FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      if (paramMessage == null) {
        return;
      }
      TipsBar localTipsBar = (TipsBar)paramView;
      if (paramMessage.arg1 == 2)
      {
        localTipsBar.setVisibility(0);
        bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 2, 0, "", "", "", "");
        return;
      }
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(8);
  }
  
  private View q()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 4);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694258));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838319));
    localTipsBar.setOnClickListener(new aldu(this));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void q()
  {
    a(39, 0);
    a(39, null);
  }
  
  private void q(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if (paramMessage == null) {}
    do
    {
      return;
      if (paramMessage.what == 1134059)
      {
        paramView.setVisibility(0);
        paramMessage = (Pair)paramMessage.obj;
        ((TipsBar)paramView).setTipsText(Html.fromHtml((String)paramMessage.second + anvx.a(2131700420)));
        paramView.setTag(paramMessage);
        return;
      }
    } while (paramMessage.what != 1134060);
    if (paramMessage.obj != null)
    {
      paramMessage = (Long)paramMessage.obj;
      Pair localPair = (Pair)paramView.getTag();
      if ((localPair != null) && (((Long)localPair.first).equals(paramMessage)))
      {
        paramView.setVisibility(8);
        a(40, 0);
      }
    }
    for (;;)
    {
      a(-1, null);
      return;
      paramView.setVisibility(8);
      a(40, 0);
    }
  }
  
  private View r()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 4);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694254));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838319));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {}
    for (;;)
    {
      return;
      int m = 0;
      while (m < 7)
      {
        localObject = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(m);
        if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {
          break label46;
        }
        m += 1;
      }
    }
    label46:
    Iterator localIterator = ((ArrayList)localObject).iterator();
    label52:
    aldd localaldd;
    while (localIterator.hasNext())
    {
      int n = ((Integer)localIterator.next()).intValue();
      localaldd = this.jdField_a_of_type_ArrayOfAldd[n];
      if ((localaldd != null) && (localaldd.jdField_a_of_type_AndroidViewView != null) && (localaldd.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(localaldd.jdField_a_of_type_AndroidViewView);
        if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
          break label165;
        }
      }
    }
    label165:
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;; localObject = null)
    {
      aldg.b((QQAppInterface)localObject, localaldd.jdField_a_of_type_Int);
      localaldd.jdField_a_of_type_Boolean = false;
      if (localaldd.a()) {
        break label52;
      }
      localaldd.jdField_a_of_type_AndroidViewView = null;
      break label52;
      break;
    }
  }
  
  private void r(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if ((paramMessage == null) || (paramMessage.what != 1134027)) {
      if (QLog.isColorLevel()) {
        QLog.d("ReaderBar", 2, "updateReaderBar msg " + paramMessage);
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ReaderBar", 2, "updateReaderBar msg.obj = " + paramMessage.obj);
        }
      } while (!(paramMessage.obj instanceof String));
      paramMessage = ((String)paramMessage.obj).split("@#");
    } while (paramMessage.length != 3);
    String str1 = paramMessage[0];
    String str2 = paramMessage[2];
    long l = Long.parseLong(paramMessage[1]);
    ((TipsBar)paramView).setTipsText(anvx.a(2131700426) + str1 + "》");
    paramView.setOnClickListener(new alee(this, l, str2));
    ((TipsBar)paramView).setCloseListener(new alff(13, this.jdField_a_of_type_MqqOsMqqHandler));
    paramView.setVisibility(0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(13);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(13, 900000L);
    bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 1, 0, "", "", "", "");
  }
  
  private View s()
  {
    AdvancedTipsBar localAdvancedTipsBar = new AdvancedTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localAdvancedTipsBar, 2);
    aqni.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localAdvancedTipsBar);
    return localAdvancedTipsBar;
  }
  
  private void s()
  {
    ThreadManager.post(new BannerManager.43(this), 5, null, false);
  }
  
  private void s(View paramView, Message paramMessage)
  {
    Object localObject2 = null;
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if ((paramMessage == null) || (paramMessage.what != 1134043)) {
      if (QLog.isColorLevel()) {
        QLog.d("runningState", 2, "updateRunningBar msg " + paramMessage);
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RunningBar", 2, "updateRunningBar msg.obj = " + paramMessage.obj);
      }
      if ((paramMessage.obj instanceof JSONObject)) {}
      try
      {
        Long localLong = Long.valueOf(((JSONObject)paramMessage.obj).getLong("runningState"));
        Object localObject1 = ((JSONObject)paramMessage.obj).getString("cookieUrl");
        String str = ((JSONObject)paramMessage.obj).optString("title");
        ((JSONObject)paramMessage.obj).optInt("actid");
        int m = ((JSONObject)paramMessage.obj).optInt("appid");
        if (localLong.longValue() == 1L)
        {
          ((TipsBar)paramView).setTipsText(anvx.a(2131700425));
          localObject1 = (String)localObject1 + "&ADTAG=aio.run.click";
        }
        for (;;)
        {
          paramView.setOnClickListener(new alef(this, (String)localObject1, localLong, m));
          if (localLong.longValue() == 3L)
          {
            localObject1 = new LpReportInfo_dc00307(LpReportInfo_dc00307.ACTION_TYPE_RED_PACK, LpReportInfo_dc00307.SUB_ACTION_TYPE_RED_PACK_EXPOSURE, m);
            LpReportManager.getInstance().reportToDC00307((LpReportInfo_dc00307)localObject1, false, true);
          }
          if ((paramView instanceof TipsBar)) {
            ((TipsBar)paramView).setCloseListener(new alff(1134044, ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime()).getHandler(Conversation.class)));
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            paramView = new Bundle();
            paramMessage.obj = paramView;
            paramMessage = Message.obtain(paramMessage);
            bjgt.a().a((String)localObject2, new aleh(this, paramView, paramMessage));
          }
          bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 9, 0, "", "", "", "");
          return;
          if (localLong.longValue() == 2L)
          {
            ((TipsBar)paramView).setTipsText(anvx.a(2131700417));
            localObject1 = (String)localObject1 + "&ADTAG=aio.run.click";
          }
          else
          {
            if (localLong.longValue() == 3L)
            {
              ((TipsBar)paramView).setTipsText(str);
              localObject1 = (String)localObject1 + "&ADTAG=qqlist.tongzhi.hongbao.click";
              localObject2 = ((JSONObject)paramMessage.obj).optString("icon");
              continue;
              if (!(paramMessage.obj instanceof Bundle)) {
                break;
              }
              paramMessage = (Bundle)paramMessage.obj;
              if (!paramMessage.containsKey("icon")) {
                break;
              }
              paramMessage = (Bitmap)paramMessage.getParcelable("icon");
              ((TipsBar)paramView).setTipsIcon(new BitmapDrawable(paramMessage));
              return;
            }
            localObject1 = null;
          }
        }
        return;
      }
      catch (JSONException paramView) {}
    }
  }
  
  private View t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initMissedCallBar");
    }
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131561030, null);
    ((TextView)localView.findViewById(2131374320)).setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698340));
    localView.findViewById(2131374319).setVisibility(8);
    return localView;
  }
  
  private void t(View paramView, Message paramMessage)
  {
    if ((paramMessage == null) || ((paramMessage.what != 1134041) && (paramMessage.what != 1134042))) {
      if (QLog.isColorLevel()) {
        QLog.d("BrowserBar", 2, "updateBrowserBar msg " + paramMessage);
      }
    }
    TextView localTextView;
    String str;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("BrowserBar", 2, "updateBrowserBar msg.obj = " + paramMessage.obj);
        }
        if (paramMessage.what == 1134042)
        {
          paramView.setVisibility(8);
          return;
        }
        localTextView = (TextView)paramView.findViewById(2131362517);
      } while ((!(paramMessage.obj instanceof Bundle)) || (localTextView == null));
      paramMessage = (Bundle)paramMessage.obj;
      str = (String)paramMessage.getCharSequence("tips");
      int m = paramMessage.getInt("icon");
      if (m != -1) {
        ((ImageView)paramView.findViewById(2131362516)).setImageResource(m);
      }
    } while (TextUtils.isEmpty(str));
    localTextView.setText(str);
    paramView.setOnClickListener(new alei(this, paramMessage));
    paramView.findViewById(2131362514).setVisibility(0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(15);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(15, paramMessage.getInt("timeout", 120000));
  }
  
  private View u()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131562067, null);
    localView.setVisibility(8);
    return localView;
  }
  
  private void u(View paramView, Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.what != 1134039)) {
      if (QLog.isColorLevel()) {
        QLog.d("ComicBar", 2, "updateComicBar msg " + paramMessage);
      }
    }
    TextView localTextView;
    String str;
    int n;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ComicBar", 2, "updateComicBar msg.obj = " + paramMessage.obj);
        }
        localTextView = (TextView)paramView.findViewById(2131362523);
      } while ((!(paramMessage.obj instanceof Bundle)) || (localTextView == null));
      localObject = (Bundle)paramMessage.obj;
      paramMessage = ((Bundle)localObject).getString("comicName");
      str = ((Bundle)localObject).getString("comicId");
      n = ((Bundle)localObject).getInt("type", -1);
    } while (TextUtils.isEmpty(paramMessage));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
    int i1 = (int)(localTextView.getPaint().measureText(paramMessage) / paramMessage.length());
    int m;
    if (((DisplayMetrics)localObject).widthPixels > ((DisplayMetrics)localObject).heightPixels)
    {
      m = ((DisplayMetrics)localObject).heightPixels;
      m = (int)((m - ((DisplayMetrics)localObject).density * 65.0F) / i1) - 8;
      if (paramMessage.length() <= m) {
        break label434;
      }
      paramMessage = paramMessage.substring(0, m) + "...";
    }
    label434:
    for (;;)
    {
      if ((n >= 100) && (n <= 300)) {
        localTextView.setText(anvx.a(2131700413) + paramMessage + "》");
      }
      for (;;)
      {
        paramView.setOnClickListener(new alej(this, str));
        paramView.findViewById(2131362542).setVisibility(0);
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(14);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(14, 900000L);
        bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 2, 0, "", "", "", "");
        return;
        m = ((DisplayMetrics)localObject).widthPixels;
        break;
        localTextView.setText(anvx.a(2131700424) + paramMessage + "》");
      }
    }
  }
  
  private View v()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131560883, null);
    localView.findViewById(2131381476).setOnClickListener(new aldw(this));
    localView.findViewById(2131381475).setVisibility(8);
    return localView;
  }
  
  private void v(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if ((paramMessage == null) || ((paramMessage.what != 1134049) && (paramMessage.what != 1134050))) {
      if (QLog.isColorLevel()) {
        QLog.d("GameBar", 2, "updateGameBar msg " + paramMessage);
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("GameBar", 2, "updateGameBar msg.obj = " + paramMessage.obj);
      }
      if (paramMessage.what == 1134050)
      {
        paramView.setVisibility(8);
        return;
      }
      if (((paramMessage.obj instanceof Bundle)) && ((paramView instanceof TipsBar)))
      {
        paramView = (TipsBar)paramView;
        paramMessage = (Bundle)paramMessage.obj;
        String str = (String)paramMessage.getCharSequence("tips");
        int m = paramMessage.getInt("icon");
        if (paramMessage.containsKey("iconURLBitmap")) {
          paramView.setTipsIcon(new BitmapDrawable((Bitmap)paramMessage.getParcelable("iconURLBitmap")));
        }
        while (!TextUtils.isEmpty(str))
        {
          paramView.setTipsText(str);
          paramView.setOnClickListener(new alel(this, paramMessage));
          paramView.setCloseListener(new alff(30, this.jdField_a_of_type_MqqOsMqqHandler));
          a(paramView);
          paramView.setVisibility(0);
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(30);
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(30, paramMessage.getInt("timeout", 900000));
          bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 4, 0, "", "", "", "");
          return;
          if (m != 1) {
            paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(m));
          }
        }
      }
    }
  }
  
  private View w()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131563032, null);
    TextView localTextView = (TextView)localView.findViewById(2131380517);
    localTextView.setOnClickListener(new aldx(this));
    localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719828));
    ((ImageView)localView.findViewById(2131364724)).setOnClickListener(new aldy(this));
    localView.findViewById(2131380516).setVisibility(8);
    return localView;
  }
  
  private void w(View paramView, Message paramMessage)
  {
    paramView.findViewById(2131380516).setVisibility(0);
    paramView = (TextView)paramView.findViewById(2131380517);
    if (paramMessage != null)
    {
      if (ansg.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) {
        break label91;
      }
      paramMessage = bgvx.a().a();
      if ((paramMessage != null) && (paramMessage.a != null) && (paramMessage.a.dialog != null)) {
        paramView.setText(paramMessage.a.dialog.h);
      }
    }
    else
    {
      return;
    }
    paramView.setText(anvx.a(2131700414));
    return;
    label91:
    paramMessage = bgvx.a().a();
    if ((paramMessage != null) && (paramMessage.a != null) && (paramMessage.a.dialog != null))
    {
      paramView.setText(paramMessage.a.dialog.g);
      return;
    }
    paramView.setText(anvx.a(2131700422));
  }
  
  private View x()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839161));
    localTipsBar.a(true);
    localTipsBar.setCloseListener(new aldz(this));
    localTipsBar.setOnClickListener(new alea(this));
    return localTipsBar;
  }
  
  private void x(View paramView, Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
      mmr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, paramView, paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
    }
  }
  
  private View y()
  {
    View localView1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131559008, null);
    View localView2 = localView1.findViewById(2131365233);
    localView1.setOnClickListener(new aleb(this));
    localView2.setVisibility(8);
    return localView1;
  }
  
  private void y(View paramView, Message paramMessage)
  {
    paramView = (TipsBar)paramView;
    a(paramView);
    if (paramMessage == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "updateWiFiSecurityBanner");
    }
    paramMessage = (SCGet3rdCloudCheck)paramMessage.obj;
    paramView.setTipsText(paramMessage.tips);
    paramView.setOnClickListener(new alew(this, paramMessage));
    paramView.setVisibility(0);
    bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 6, 0, "", "", "", "");
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(202);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(202, 7000L);
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext();
    if (paramMessage.tipsType == 2) {}
    for (int m = 398680;; m = 398678)
    {
      bixr.b(paramView, m);
      return;
    }
  }
  
  private View z()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130841343));
    localTipsBar.setOnClickListener(new alec(this));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  @SuppressLint({"ResourceType"})
  private void z(View paramView, Message paramMessage)
  {
    paramView = (TipsBar)paramView;
    a(paramView);
    if (paramMessage == null) {
      return;
    }
    paramMessage = (alfg)paramMessage.obj;
    paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(alde.a(paramMessage.jdField_b_of_type_Int)));
    paramView.setTipsText(paramMessage.jdField_b_of_type_JavaLangString);
    paramView.setOnClickListener(new alfi(paramMessage, this.jdField_a_of_type_MqqOsMqqHandler));
    paramView.setCloseListener(new alfh(paramMessage, this.jdField_a_of_type_MqqOsMqqHandler));
    paramView.setVisibility(0);
    bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 1, 0, "", "", "", "");
  }
  
  public int a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfAldd.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfAldd[paramInt];
      }
    }
    if (localObject1 == null) {
      return 0;
    }
    return ((aldd)localObject1).jdField_b_of_type_Int;
  }
  
  public View a()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131561031, null);
    localView.findViewById(2131374321).setVisibility(8);
    return localView;
  }
  
  public Object a(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_ArrayOfAldd.length)) {}
    for (aldd localaldd = this.jdField_a_of_type_ArrayOfAldd[paramInt1];; localaldd = null)
    {
      Object localObject1 = localObject2;
      if (localaldd != null)
      {
        localObject1 = localObject2;
        if (localaldd.jdField_a_of_type_AndroidViewView != null)
        {
          if (paramInt2 != 0) {
            break label58;
          }
          localObject1 = localaldd.jdField_a_of_type_AndroidViewView.getTag();
        }
      }
      return localObject1;
      label58:
      return localaldd.jdField_a_of_type_AndroidViewView.getTag(paramInt2);
    }
  }
  
  public MqqHandler a()
  {
    return this.jdField_a_of_type_MqqOsMqqHandler;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Alga != null) {
      this.jdField_a_of_type_Alga.h();
    }
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "fight.setPushBannerHeight:" + paramFloat + ",mIsStoryShow:" + this.g);
    }
    Object localObject1 = this.jdField_a_of_type_ArrayOfAldd[24];
    if ((localObject1 == null) || (((aldd)localObject1).jdField_a_of_type_AndroidViewView == null))
    {
      break label68;
      break label68;
    }
    for (;;)
    {
      label68:
      return;
      if (!((aldd)localObject1).jdField_a_of_type_Boolean) {
        continue;
      }
      if (paramFloat > 0.0F)
      {
        c(true);
        return;
      }
      localObject1 = ((aldd)localObject1).jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break;
      }
      int m = (int)Math.abs(paramFloat);
      localObject1 = ((View)localObject1).findViewById(2131373401);
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
      int n = this.jdField_c_of_type_Int;
      label160:
      Object localObject2;
      int i1;
      if (this.g)
      {
        if (localLayoutParams.height == this.jdField_c_of_type_Int) {
          break;
        }
        if (paramFloat < -n)
        {
          paramFloat = 0.0F;
          m = 0;
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "fight.setPushBannerHeight.lp.height = " + localLayoutParams.height + "height:" + m + ",alpha:" + paramFloat);
          }
          if (localLayoutParams.height == m) {
            break;
          }
          if (m == 0)
          {
            localObject2 = a(24, 2131362239);
            i1 = 0;
            n = i1;
            if (localObject2 != null)
            {
              n = i1;
              if (!(localObject2 instanceof String)) {}
            }
          }
        }
      }
      try
      {
        n = Integer.parseInt((String)localObject2);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X80094CD", "0X80094CD", n, 0, "", "", "", "");
        localLayoutParams.height = m;
        ((View)localObject1).setAlpha(paramFloat);
        ((View)localObject1).requestLayout();
        return;
        if (paramFloat >= -3.0F)
        {
          m = this.jdField_c_of_type_Int;
          paramFloat = 1.0F;
          break label160;
        }
        paramFloat = (n - m) / this.jdField_c_of_type_Int;
        m = n - m;
        break label160;
        if (localLayoutParams.height == 0) {
          continue;
        }
        ((View)localObject1).findViewById(2131364699).setVisibility(4);
        if (paramFloat < this.jdField_a_of_type_Float - n)
        {
          paramFloat = 0.0F;
          m = 0;
          break label160;
        }
        if (paramFloat < this.jdField_a_of_type_Float)
        {
          m = (int)(n + paramFloat - this.jdField_a_of_type_Float);
          paramFloat = m / n;
          break label160;
        }
        m = this.jdField_c_of_type_Int;
        paramFloat = 1.0F;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          n = i1;
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 4, "updateBannerState|[" + paramInt1 + "," + paramInt2 + "]");
    }
    if ((paramInt1 >= 1) && (paramInt1 <= 49))
    {
      if (this.jdField_a_of_type_ArrayOfAldd[paramInt1] == null) {
        break label108;
      }
      this.jdField_a_of_type_ArrayOfAldd[paramInt1].jdField_b_of_type_Int = paramInt2;
    }
    for (;;)
    {
      if ((paramInt1 >= 32) && (paramInt1 <= 41) && (paramInt2 == 2)) {
        a(paramInt1);
      }
      b(paramInt1, paramInt2);
      return;
      label108:
      if ((this.jdField_a_of_type_ArrayOfAldd[paramInt1] == null) && (aldd.a(paramInt2))) {
        this.jdField_a_of_type_ArrayOfAldd[paramInt1] = new aldd(paramInt1, paramInt2);
      }
    }
  }
  
  public void a(int paramInt, Message paramMessage)
  {
    int i1 = 0;
    QLog.d("Q.recent.banner", 2, "refreshBanner, bannerId: " + paramInt);
    m();
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(7);
    }
    int m;
    boolean bool1;
    boolean bool2;
    label73:
    Object localObject;
    List localList;
    if (e())
    {
      n();
      m = 0;
      bool1 = true;
      bool2 = true;
      if (m >= 7) {
        break label147;
      }
      localObject = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(m);
      localList = (List)this.jdField_b_of_type_AndroidUtilSparseArray.get(m);
      if (localList.equals(localObject)) {
        break label371;
      }
      bool2 = false;
    }
    label147:
    label371:
    for (;;)
    {
      if (!localList.isEmpty()) {
        bool1 = false;
      }
      for (;;)
      {
        m += 1;
        break label73;
        o();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, new Object[] { "[refresh] refreshBanner: invoked. ", " needShowIdsEmpty: ", Boolean.valueOf(bool1), " bannersEqual: ", Boolean.valueOf(bool2) });
        }
        if ((bool2) && (bool1)) {
          return;
        }
        if (bool1)
        {
          r();
          return;
        }
        m = i1;
        int n;
        if (!bool2)
        {
          r();
          n = 0;
          for (;;)
          {
            m = i1;
            if (n >= 7) {
              break;
            }
            localObject = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(n);
            if (localObject != null) {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(n, (ArrayList)((ArrayList)localObject).clone());
            }
            n += 1;
          }
        }
        for (;;)
        {
          m += 1;
          if (m >= 7) {
            break;
          }
          localObject = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(m);
          if (localObject != null)
          {
            localObject = ((ArrayList)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              n = ((Integer)((Iterator)localObject).next()).intValue();
              a(paramInt, paramMessage, this.jdField_a_of_type_ArrayOfAldd[n]);
            }
          }
        }
      }
    }
  }
  
  public void a(Message paramMessage)
  {
    Bundle localBundle = (Bundle)paramMessage.obj;
    String str = localBundle.getString("iconURL");
    if (!TextUtils.isEmpty(str))
    {
      paramMessage = Message.obtain(paramMessage);
      bjgt.a().a(str, new alek(this, localBundle, paramMessage));
      return;
    }
    a(37, 2);
    a(37, paramMessage);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "onDestroy");
      }
      this.f = true;
      if ((this.jdField_a_of_type_Awza != null) && (paramQQAppInterface != null))
      {
        ((PhoneContactManagerImp)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).b(this.jdField_a_of_type_Awza);
        this.jdField_a_of_type_Awza = null;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.recent.banner", 2, "onDestroy", paramQQAppInterface);
    }
  }
  
  public void a(TipsBar paramTipsBar)
  {
    if (this.j) {
      if ((ThemeUtil.isDefaultTheme()) || (ThemeUtil.isSimpleDayTheme(false))) {
        if (paramTipsBar.a() == 2) {
          paramTipsBar.setBarType(6);
        }
      }
    }
    for (;;)
    {
      paramTipsBar.b();
      return;
      if (paramTipsBar.a() == 6)
      {
        paramTipsBar.setBarType(2);
      }
      else if ((!ThemeUtil.isInNightMode(BaseApplicationImpl.sApplication.getRuntime())) && (paramTipsBar.a() == 2))
      {
        paramTipsBar.setBarType(2);
        continue;
        if (paramTipsBar.a() == 6) {
          paramTipsBar.setBarType(2);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((a(19)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString)) && (this.jdField_e_of_type_JavaLangString.equals(paramString)))
    {
      this.jdField_e_of_type_JavaLangString = "";
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 1000L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ArrayOfAldd[18] != null) {
      a(18, 0);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    if (paramBoolean)
    {
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.CONTACT_MANAGER);
      int m;
      if (localPhoneContactManagerImp != null)
      {
        m = localPhoneContactManagerImp.b();
        if (m == 0) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(11, 1000L);
        }
      }
      else
      {
        return;
      }
      if ((this.jdField_a_of_type_Awza == null) && (!this.f))
      {
        this.jdField_a_of_type_Awza = new aldi(this);
        localPhoneContactManagerImp.a(this.jdField_a_of_type_Awza);
      }
      paramBoolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), 0).getBoolean("key_show_contact_banner", true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "checkContactBanner, state = " + m + ", isFirstShow = " + paramBoolean);
      }
      if ((m == 1) && (paramBoolean))
      {
        if ((this.jdField_a_of_type_ArrayOfAldd[18] != null) && (this.jdField_a_of_type_ArrayOfAldd[18].jdField_b_of_type_Int != 2)) {
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X80053D8", "0X80053D8", 0, 0, "", "", "", "");
        }
        a(18, 2);
        bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 13, 0, "", "", "", "");
        return;
      }
      a(18, 0);
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(11, 1000L);
  }
  
  public void a(boolean paramBoolean, float paramFloat)
  {
    this.g = paramBoolean;
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public boolean a()
  {
    return ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).mAutomator.c();
  }
  
  public boolean a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfAldd.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfAldd[paramInt];
      }
    }
    return (localObject1 != null) && (((aldd)localObject1).a());
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "onDelayRefreshGameNotice");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter = new GameNoticeCenter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
    }
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter.checkBannerFromResume();
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    a(13, 0);
    c(paramQQAppInterface);
    q();
    d(paramQQAppInterface);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Alga != null) {
      this.jdField_a_of_type_Alga.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    if ((this.jdField_b_of_type_AndroidUtilSparseArray != null) && (this.jdField_b_of_type_AndroidUtilSparseArray.size() > 0))
    {
      Object localObject = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(6);
      if ((localObject != null) && (((ArrayList)localObject).contains(Integer.valueOf(49))))
      {
        localObject = this.jdField_a_of_type_ArrayOfAldd[49];
        return (localObject != null) && (((aldd)localObject).jdField_b_of_type_Int == 2);
      }
    }
    return false;
  }
  
  public boolean b(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfAldd.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfAldd[paramInt];
      }
    }
    return (localObject1 != null) && (((aldd)localObject1).jdField_a_of_type_Boolean);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAVNotifyCenter().b() <= 0) {
        break label34;
      }
      a(43, 2);
    }
    label34:
    int m;
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.isVideoChatting()) {
        break;
      }
      m = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAVNotifyCenter().e();
      if (m == 3)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAVNotifyCenter().b() > 0L)
        {
          a(43, 2);
          return;
        }
        a(43, 0);
        return;
      }
      if (m == 1)
      {
        a(43, 2);
        return;
      }
    } while (m != 2);
    a(43, 2);
    return;
    a(43, 0);
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAldd[24];
    if ((localObject1 == null) || (((aldd)localObject1).jdField_a_of_type_AndroidViewView == null)) {}
    label19:
    ViewGroup.LayoutParams localLayoutParams;
    int m;
    do
    {
      do
      {
        do
        {
          break label19;
          do
          {
            return;
          } while (!((aldd)localObject1).jdField_a_of_type_Boolean);
          localObject1 = ((aldd)localObject1).jdField_a_of_type_AndroidViewView;
        } while (localObject1 == null);
        localObject1 = ((View)localObject1).findViewById(2131373401);
        localLayoutParams = ((View)localObject1).getLayoutParams();
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, "fight.setPushBannerHeight.lp.height1 = " + localLayoutParams.height);
        }
        if (!paramBoolean) {
          break;
        }
      } while ((localLayoutParams.height == this.jdField_c_of_type_Int) && (((View)localObject1).findViewById(2131364699).getVisibility() == 0) && (((View)localObject1).getAlpha() == 1.0F));
      ((View)localObject1).findViewById(2131364699).setVisibility(0);
      ((View)localObject1).setAlpha(1.0F);
      localLayoutParams.height = this.jdField_c_of_type_Int;
      ((View)localObject1).requestLayout();
      localObject1 = a(24, 2131362239);
      if ((localObject1 != null) && ((localObject1 instanceof String))) {}
      for (;;)
      {
        try
        {
          m = Integer.parseInt((String)localObject1);
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X80087C2", "0X80087C2", m, 0, "3", "", "", "");
          return;
        }
        catch (Throwable localThrowable1)
        {
          localThrowable1.printStackTrace();
        }
        m = 0;
      }
    } while (localLayoutParams.height == 0);
    localThrowable1.findViewById(2131364699).setVisibility(4);
    localThrowable1.setAlpha(0.0F);
    localLayoutParams.height = 0;
    localThrowable1.requestLayout();
    Object localObject2 = a(24, 2131362239);
    if ((localObject2 != null) && ((localObject2 instanceof String))) {}
    for (;;)
    {
      try
      {
        m = Integer.parseInt((String)localObject2);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X80094CD", "0X80094CD", m, 0, "", "", "", "");
        return;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
      }
      m = 0;
    }
  }
  
  public boolean c()
  {
    alga localalga = alga.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this);
    if (localalga == null) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_Alga == null) || (!this.jdField_a_of_type_Alga.getClass().isInstance(localalga)) || (!localalga.getClass().isInstance(this.jdField_a_of_type_Alga)))
      {
        this.jdField_a_of_type_Alga = localalga;
        i();
      }
    } while (this.jdField_a_of_type_Alga == null);
    boolean bool = this.jdField_a_of_type_Alga.a();
    QLog.i("QBoss.ADBanner.Manager", 1, "isNeedShowQBossADBanner: " + bool);
    return bool;
  }
  
  public void d()
  {
    if (a(14))
    {
      a(14, 0);
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_b_of_type_Int = -1;
      this.jdField_d_of_type_JavaLangString = null;
      this.jdField_b_of_type_Long = 0L;
      a(-1, null);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean d()
  {
    boolean bool1 = true;
    boolean bool2 = g();
    if ((this.jdField_e_of_type_Boolean) && (!bool2)) {}
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent.banner", 4, "isNeedShowPushBanner, isNeedShow = " + bool1);
      }
      return bool1;
      if (h())
      {
        if (this.jdField_a_of_type_ArrayOfAldd[24] == null) {
          this.jdField_a_of_type_ArrayOfAldd[24] = new aldd(24, 0);
        }
        a(this.jdField_a_of_type_ArrayOfAldd[24]);
        View localView = this.jdField_a_of_type_ArrayOfAldd[24].jdField_a_of_type_AndroidViewView;
        if (localView != null) {}
        for (bool1 = a(localView);; bool1 = false)
        {
          if (bool1)
          {
            localView.findViewById(2131373401).setVisibility(0);
            this.jdField_e_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).edit().putBoolean("reveive_newpb" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), false).commit();
          }
          break;
        }
      }
      bool1 = false;
    }
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAldd[24];
    ViewGroup localViewGroup;
    int n;
    int m;
    if ((localObject != null) && (((aldd)localObject).jdField_a_of_type_AndroidViewView != null))
    {
      localObject = (ADView)((aldd)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131362239);
      localViewGroup = ((ADView)localObject).a(0);
      if (localViewGroup != null)
      {
        n = localViewGroup.getChildCount();
        m = 0;
        n -= 1;
        if (n >= 0)
        {
          View localView = localViewGroup.getChildAt(n);
          bdno localbdno = (bdno)localView.getTag();
          String str = localbdno.jdField_c_of_type_JavaLangString;
          int i1 = str.indexOf("|");
          if (bgyr.a(Long.parseLong(str.substring(0, i1)), Long.parseLong(str.substring(i1 + 1)))) {
            break label296;
          }
          ((ADView)localObject).a(0, n, localView);
          aqwk.a.a(localbdno.l);
          m = 1;
        }
      }
    }
    label296:
    for (;;)
    {
      n -= 1;
      break;
      if (m != 0)
      {
        if (localViewGroup.getChildCount() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).edit().putBoolean("push_banner_display" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime().getAccount(), false).commit();
          ((ADView)localObject).h();
          a(24, 0);
          a(-1, null);
          this.jdField_e_of_type_Boolean = false;
        }
        for (;;)
        {
          localObject = new aqwm(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), arph.jdField_a_of_type_JavaLangString);
          if (localObject != null)
          {
            ((aqwm)localObject).b();
            ((aqwm)localObject).c();
          }
          return;
          p();
        }
      }
      p();
      return;
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(101);
    a(47, 0);
    a(15, 0);
    a(17, 0);
    a(38, 0);
    a(39, 0);
    Object localObject = this.jdField_a_of_type_ArrayOfAldd[24];
    if ((localObject != null) && (((aldd)localObject).jdField_a_of_type_AndroidViewView != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((aldd)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131362240);
      localObject = (ADView)((aldd)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131362239);
      if (localObject != null)
      {
        ((ADView)localObject).j();
        ((ADView)localObject).h();
      }
      if (localRelativeLayout != null) {
        localRelativeLayout.setPadding(0, -1, 0, 0);
      }
    }
    this.jdField_e_of_type_Boolean = false;
    d();
    l();
    a(19, 0);
    this.h = true;
    this.i = false;
    this.jdField_e_of_type_JavaLangString = "";
    a(10, 0);
    a(20, 0);
    a(21, 0);
    a(26, 0);
    a(9, 0);
    a(23, 0);
    if (this.jdField_a_of_type_Alga != null) {
      this.jdField_a_of_type_Alga.g();
    }
    a(30, 0);
    a(33, 0);
    a(49, 0);
    a(37, 0);
    a(36, 0);
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter = null;
    }
    c();
    k();
    a(3, 0);
    a(5, 0);
    bhav.a().a();
    a(2, 0);
    a(-1, null);
    a(false);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void g()
  {
    a(23, 0);
    a(-1, null);
    if (this.jdField_a_of_type_Alga != null) {
      this.jdField_a_of_type_Alga.f();
    }
  }
  
  public void h()
  {
    QLog.i("Q.recent.banner", 1, "onResume");
    if (this.jdField_a_of_type_Alga != null) {
      this.jdField_a_of_type_Alga.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {}
    for (QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;; localQQAppInterface = null)
    {
      bhav.a().a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      bcpn.a().a(localQQAppInterface, System.currentTimeMillis());
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
    case 4: 
    case 6: 
    case 7: 
    case 12: 
    case 16: 
    case 8: 
    case 9: 
    case 101: 
      do
      {
        return true;
        bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 17, 0, "", "", "", "");
        return true;
        a(19, 0);
        this.jdField_e_of_type_JavaLangString = "";
        a(19, paramMessage);
        return true;
        a(20, 0);
        a(20, paramMessage);
        return true;
        a(7, 2);
        a(7, paramMessage);
        return true;
        a(7, 0);
        a(7, paramMessage);
        return true;
        a(27, 0);
        a(27, paramMessage);
        return true;
        a(28, 0);
        a(28, paramMessage);
        return true;
        a(26, 2);
        a(26, paramMessage);
        return true;
        a(26, 0);
        a(26, paramMessage);
        return true;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("PushBanner", 2, "checkAndClosePushBanner");
          }
          e();
          return true;
        }
        catch (Exception paramMessage) {}
      } while (!QLog.isColorLevel());
      QLog.d("PushBanner", 2, "checkAndClosePushBanner Exception:", paramMessage);
      return true;
    case 11: 
      a(true);
      return true;
    case 13: 
      a(33, 0);
      a(33, paramMessage);
      return true;
    case 14: 
      a(34, 0);
      a(34, paramMessage);
      return true;
    case 15: 
      a(35, 0);
      a(35, paramMessage);
      return true;
    case 30: 
      a(37, 0);
      a(37, paramMessage);
      return true;
    case 20: 
      a(29, 0);
      a(29, paramMessage);
      return true;
    case 200: 
      c(paramMessage);
      return true;
    case 201: 
      b(paramMessage);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "handler msg MSG_HIDE_WIFI_SECURITY_CHECK");
    }
    a(4, 0);
    a(4, paramMessage);
    return true;
  }
  
  public void i()
  {
    aldd localaldd;
    if (this.jdField_a_of_type_ArrayOfAldd != null)
    {
      localaldd = this.jdField_a_of_type_ArrayOfAldd[23];
      if ((localaldd != null) && (localaldd.jdField_a_of_type_AndroidViewView != null) && (localaldd.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(localaldd.jdField_a_of_type_AndroidViewView);
        if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
          break label79;
        }
      }
    }
    label79:
    for (QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;; localQQAppInterface = null)
    {
      aldg.b(localQQAppInterface, localaldd.jdField_a_of_type_Int);
      localaldd.jdField_a_of_type_Boolean = false;
      localaldd.jdField_a_of_type_AndroidViewView = null;
      return;
    }
  }
  
  public void j()
  {
    int i2 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "checkIsShowTroopTip");
    }
    QQAppInterface localQQAppInterface;
    List localList;
    int m;
    label83:
    int n;
    label85:
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if ((localQQAppInterface != null) && ((awtz.a().c(localQQAppInterface, this.jdField_e_of_type_JavaLangString)) || (this.i)))
      {
        localList = localQQAppInterface.getProxyManager().a().getRecentList(false);
        if (localList != null) {
          break label136;
        }
        m = 0;
        n = 0;
        i1 = i2;
        if (n >= m) {
          break label154;
        }
        if (((RecentUser)localList.get(n)).getType() != 5000) {
          break label147;
        }
        if (this.i) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
        }
      }
    }
    label136:
    label147:
    label154:
    do
    {
      return;
      localQQAppInterface = null;
      break;
      m = localList.size();
      break label83;
      n += 1;
      break label85;
      if (i1 < m)
      {
        RecentUser localRecentUser = (RecentUser)localList.get(i1);
        if (localRecentUser.getType() != 1) {}
        do
        {
          do
          {
            i1 += 1;
            break;
          } while ((TextUtils.isEmpty(localRecentUser.uin)) || (awtz.a().b(localQQAppInterface, localRecentUser.uin)) || (awtz.a().a(localQQAppInterface, localRecentUser.uin) != 1));
          if (localQQAppInterface.getConversationFacade().a(localRecentUser.uin, localRecentUser.getType()) > 99)
          {
            if ((this.i) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_e_of_type_JavaLangString.equals(localRecentUser.uin))) {
              break;
            }
            this.jdField_e_of_type_JavaLangString = localRecentUser.uin;
            if ((!this.h) || (!awtz.a().c(localQQAppInterface, this.jdField_e_of_type_JavaLangString))) {
              break;
            }
            return;
          }
        } while ((TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || (!this.jdField_e_of_type_JavaLangString.equals(localRecentUser.uin)));
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
        return;
      }
    } while ((!this.i) || (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)));
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
  }
  
  public void k() {}
  
  public void l()
  {
    if (a(31))
    {
      a(31, 0);
      this.jdField_b_of_type_JavaLangString = null;
      a(-1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldh
 * JD-Core Version:    0.7.0.1
 */