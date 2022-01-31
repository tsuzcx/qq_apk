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
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager.41;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.NewUpgradeConfig;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMWrapper;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.data.GameNoticeCenter;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.mobileqq.widget.AdvancedTipsBar;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
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

public class ajgb
  implements Handler.Callback
{
  public static final boolean a;
  public float a;
  public int a;
  public long a;
  private volatile ajhy jdField_a_of_type_Ajhy;
  private ajir jdField_a_of_type_Ajir;
  private SparseArray<ArrayList<Integer>> jdField_a_of_type_AndroidUtilSparseArray;
  private aufw jdField_a_of_type_Aufw;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private GameNoticeCenter jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bdgf(this);
  private ajfz[] jdField_a_of_type_ArrayOfAjfz = new ajfz[42];
  public int b;
  public long b;
  private volatile ajhy jdField_b_of_type_Ajhy;
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
  
  public ajgb(BaseActivity paramBaseActivity, XListView paramXListView)
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    if (this.jdField_c_of_type_Int == 0) {
      this.jdField_c_of_type_Int = aepi.a(50.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
    }
  }
  
  private View A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameBar", 2, "initGameBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838233));
    localTipsBar.setVisibility(8);
    localTipsBar.a(true);
    return localTipsBar;
  }
  
  private View B()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131562803, null);
    TextView localTextView = (TextView)localView.findViewById(2131379346);
    localTextView.setOnClickListener(new ajhe(this));
    localTextView.setText("");
    if (AppSetting.jdField_c_of_type_Boolean) {
      localTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131721234));
    }
    ((ImageView)localView.findViewById(2131364335)).setOnClickListener(new ajhf(this));
    localView.findViewById(2131379345).setVisibility(8);
    return localView;
  }
  
  private View C()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131559367, null);
    localView.setOnClickListener(new ajhg(this));
    localView.findViewById(2131370864).setVisibility(8);
    return localView;
  }
  
  private View D()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839292));
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719844));
    localTipsBar.setOnClickListener(new ajhh(this));
    azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 18, 0, "", "", "", "");
    return localTipsBar;
  }
  
  private View E()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131559511, null);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    localView.findViewById(2131372509).setVisibility(8);
    ((LinearLayout)localView.findViewById(2131364327)).setOnClickListener(new ajhi(this));
    return localView;
  }
  
  private View F()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130844604));
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699024));
    localTipsBar.setOnClickListener(new ajhj(this));
    return localTipsBar;
  }
  
  private View G()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131561660, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131373900);
    localView.setOnClickListener(new ajhk(this));
    localImageView.setOnClickListener(new ajhm(this));
    return localView;
  }
  
  private View H()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.a(true);
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View I()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initWiFiSecurityBanner");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(4);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838158));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View J()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130846538));
    localTipsBar.b(true);
    localTipsBar.setOnClickListener(new ajhp(this));
    return localTipsBar;
  }
  
  @Nullable
  public static ajhy a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, ajhw paramajhw)
  {
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null)
    {
      paramString1 = new ajhy(1, paramString1, paramInt, paramString2, paramajhw);
      paramString2 = paramQQAppInterface.obtainMessage(1134200);
      paramString2.obj = paramString1;
      paramQQAppInterface.sendMessage(paramString2);
      return paramString1;
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    int m = 28;
    if (m <= 35)
    {
      if (this.jdField_a_of_type_ArrayOfAjfz[m] == null) {}
      for (;;)
      {
        m += 1;
        break;
        if (this.jdField_a_of_type_ArrayOfAjfz[m].jdField_b_of_type_Int == 2) {
          if (m != paramInt)
          {
            b(m, paramInt);
            this.jdField_a_of_type_ArrayOfAjfz[m].jdField_b_of_type_Int = 0;
          }
          else if ((m == 35) && (this.jdField_a_of_type_Ajhy != null) && (!this.jdField_b_of_type_Ajhy.equals(this.jdField_a_of_type_Ajhy)))
          {
            b(m, paramInt);
          }
        }
      }
    }
  }
  
  private void a(ajfz paramajfz)
  {
    if ((paramajfz == null) || (paramajfz.jdField_a_of_type_AndroidViewView != null)) {
      return;
    }
    for (;;)
    {
      try
      {
        int m = paramajfz.jdField_a_of_type_Int;
        switch (m)
        {
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = o();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = a();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = q();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = m();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = k();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = j();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = l();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = p();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = s();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = r();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = r();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = B();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = t();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = E();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = c();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = D();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = n();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = G();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = u();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = v();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = w();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = x();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = z();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = y();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = A();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = C();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = F();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = g();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = h();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = i();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = f();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = e();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = d();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = H();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = I();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = J();
        continue;
        paramajfz.jdField_a_of_type_AndroidViewView = b();
        continue;
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("Q.recent.banner", 4, "initBannerView | banner = " + paramajfz);
      return;
      paramajfz.jdField_a_of_type_AndroidViewView = l();
    }
  }
  
  private void a(ajfz paramajfz, Message paramMessage)
  {
    boolean bool = false;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateBanner| banner = ").append(paramajfz).append(", msg = ").append(paramMessage).append(" isGeneral? ");
      if (paramajfz.jdField_a_of_type_Int == 35) {
        bool = true;
      }
      QLog.d("Q.recent.banner", 4, Boolean.toString(bool));
    }
    if ((paramajfz == null) || (paramajfz.jdField_a_of_type_AndroidViewView == null)) {
      label83:
      return;
    }
    TextHook.updateFont(paramajfz.jdField_a_of_type_AndroidViewView);
    for (;;)
    {
      try
      {
        switch (paramajfz.jdField_a_of_type_Int)
        {
        case 5: 
        case 15: 
        case 16: 
        case 17: 
        case 19: 
        case 40: 
          if (!(paramajfz.jdField_a_of_type_AndroidViewView instanceof TipsBar)) {
            break label83;
          }
          a((TipsBar)paramajfz.jdField_a_of_type_AndroidViewView);
          return;
        }
      }
      catch (Throwable paramajfz)
      {
        paramajfz.printStackTrace();
        return;
      }
      b(paramajfz.jdField_a_of_type_AndroidViewView);
      continue;
      k(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      g(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      j(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      f(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      a(paramajfz.jdField_a_of_type_AndroidViewView);
      continue;
      l(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      c(paramajfz.jdField_a_of_type_AndroidViewView);
      continue;
      paramajfz.jdField_a_of_type_AndroidViewView.findViewById(2131379345).setVisibility(0);
      continue;
      paramajfz.jdField_a_of_type_AndroidViewView.findViewById(2131379345).setVisibility(0);
      continue;
      t(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      d(paramajfz.jdField_a_of_type_AndroidViewView);
      continue;
      n(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      o(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      p(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      r(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      q(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      s(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      u(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      e(paramajfz.jdField_a_of_type_AndroidViewView);
      continue;
      a(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      b(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage, paramajfz.jdField_b_of_type_Int);
      continue;
      a(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage, paramajfz.jdField_b_of_type_Int);
      continue;
      f(paramajfz.jdField_a_of_type_AndroidViewView);
      continue;
      d(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      e(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      i(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      c(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      b(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      aobo.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(this, paramajfz.jdField_a_of_type_AndroidViewView);
      continue;
      m(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      w(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      v(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      g(paramajfz.jdField_a_of_type_AndroidViewView);
      continue;
      h(paramajfz.jdField_a_of_type_AndroidViewView, paramMessage);
    }
  }
  
  private void a(ajhy paramajhy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "hideGeneralBannerInBInternal with: " + paramajhy);
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(201);
    localMessage.obj = paramajhy;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  private void a(View paramView)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    paramView.setVisibility(0);
    ((TipsBar)paramView).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691110));
  }
  
  private void a(View paramView, Message paramMessage)
  {
    if (paramMessage != null)
    {
      if (this.jdField_a_of_type_Ajir != null) {
        this.jdField_a_of_type_Ajir.c();
      }
      azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 11, 0, "", "", "", "");
    }
  }
  
  private void a(View paramView, Message paramMessage, int paramInt)
  {
    if ((paramMessage == null) || (paramMessage.obj == null) || (!(paramMessage.obj instanceof alyr))) {
      return;
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8005B72", "0X8005B72", 0, 0, "", "", "", "");
    paramView.findViewById(2131373477).setVisibility(0);
    paramMessage = (alyr)paramMessage.obj;
    ((TextView)paramView.findViewById(2131363085)).setText(paramMessage.jdField_b_of_type_JavaLangString);
    azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 5, 0, "", "", "", "");
    paramView.setOnClickListener(new ajhq(this, paramMessage));
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
      qzo.a(paramQQAppInterface, paramIntent, localPendingIntent, str1, str2);
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
    paramIntent = new ajib(paramPendingIntent, paramQQAppInterface);
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
    paramIntent = new ajic(paramQQAppInterface, paramString3, str3, str1, str2, localIntent, paramQQAppInterface.c(), m);
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
      paramString3 = new ajid(paramString3, paramQQAppInterface, paramString4, paramInt2, paramBundle, paramBoolean);
      paramInt2 = paramInt1;
      if (paramInt1 < 0) {
        paramInt2 = ajga.a(str1);
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
    if ((paramInt == 2) && (this.j == true) && ((ThemeUtil.isDefaultTheme()) || (ThemeUtil.isSimpleDayTheme(false))))
    {
      paramTipsBar.setBarType(6);
      return;
    }
    paramTipsBar.setBarType(paramInt);
  }
  
  private static void a(String paramString1, Intent paramIntent, QQAppInterface paramQQAppInterface, String paramString2, String paramString3)
  {
    int m = paramIntent.getIntExtra("banner_iconIdx", -1);
    paramString1 = new ajhv(paramString1, paramQQAppInterface);
    paramString1.a(a(paramQQAppInterface, m, paramString2, paramString3, paramString1));
  }
  
  private boolean a(View paramView)
  {
    aokb localaokb = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin(), false);
    if (localaokb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushBannerConfig", 2, "loadPushBanner");
      }
      o();
      return false;
    }
    int i2 = localaokb.a(0);
    if (i2 > 0)
    {
      ((ADView)paramView.findViewById(2131362155)).h();
      int m = 0;
      int i1;
      for (int n = 0; m < i2; n = i1)
      {
        i1 = n;
        if (a(localaokb, m, paramView)) {
          i1 = n + 1;
        }
        m += 1;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent.banner", 4, "loadPushBanner, addnum = " + n);
      }
      if (n > 0)
      {
        l();
        return true;
      }
    }
    return false;
  }
  
  private boolean a(aokb paramaokb, int paramInt, View paramView)
  {
    azum localazum = new azum(paramaokb.a(0, paramInt), paramaokb.b(0, paramInt), paramaokb.a(0, paramInt));
    localazum.l = paramaokb.a(0, paramInt);
    localazum.m = paramaokb.c(0, paramInt);
    boolean bool = localazum.a(paramaokb.a(0, paramInt));
    if ((localazum.jdField_c_of_type_JavaLangString != null) && (localazum.jdField_c_of_type_JavaLangString.contains("|")) && (!bdao.a(Long.parseLong(localazum.jdField_c_of_type_JavaLangString.substring(0, localazum.jdField_c_of_type_JavaLangString.indexOf("|"))), Long.parseLong(localazum.jdField_c_of_type_JavaLangString.substring(localazum.jdField_c_of_type_JavaLangString.indexOf("|") + 1))))) {}
    label470:
    for (;;)
    {
      return false;
      if ((bool) && (!"".equals(localazum.j)))
      {
        localazum.jdField_a_of_type_Bdhk = bdib.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localazum.j);
        if (localazum.jdField_a_of_type_Bdhk == null) {}
        for (int m = 0;; m = 1)
        {
          if (m == 0) {
            break label470;
          }
          Object localObject = paramaokb.a(0, paramInt);
          if (QLog.isDevelopLevel()) {
            QLog.i("PUSH BANNER", 4, "addPushBanner, bannerPic = " + localObject);
          }
          if (localObject == null) {
            break;
          }
          paramaokb = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131559512, null);
          ImageView localImageView = (ImageView)paramaokb.findViewById(2131361957);
          localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          localImageView.setImageBitmap((Bitmap)localObject);
          DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
          m = ((Bitmap)localObject).getHeight() * Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) / ((Bitmap)localObject).getWidth();
          localLayoutParams.height = Math.max((int)(30.0F * localDisplayMetrics.density), Math.min(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) * 68 / 320, m));
          localImageView.setLayoutParams(localLayoutParams);
          localObject = (ImageView)paramaokb.findViewById(2131372513);
          ((ImageView)localObject).setTag(localazum);
          ((ImageView)localObject).setContentDescription(alud.a(2131701310));
          ((ImageView)localObject).setOnClickListener(new ajhn(this));
          paramaokb.setTag(localazum);
          ((ADView)paramView.findViewById(2131362155)).a(paramaokb, paramInt);
          paramView.setTag(2131362155, localazum.jdField_a_of_type_JavaLangString);
          return true;
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ajhy paramajhy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "hideGeneralBannerInB with: " + paramajhy);
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null)
    {
      Message localMessage = paramQQAppInterface.obtainMessage(1134201);
      localMessage.obj = paramajhy;
      paramQQAppInterface.sendMessage(localMessage);
      return true;
    }
    return false;
  }
  
  private View b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComicBar", 2, "initComicBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "[notifyBannerIsOverride], type is " + paramInt1 + " / " + paramInt2);
    }
    if ((paramInt1 == 35) && (this.jdField_a_of_type_Ajhy != null)) {
      this.jdField_a_of_type_Ajhy.jdField_a_of_type_Ajhw.onOverride();
    }
    do
    {
      do
      {
        return;
      } while (paramInt1 != 33);
      localObject = akyn.a();
    } while (localObject == null);
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if (localQQAppInterface == null) {
        break label177;
      }
      if (((akyn)localObject).a != null) {
        break label146;
      }
    }
    label146:
    for (Object localObject = "-1";; localObject = ((akyn)localObject).a.gameId + "")
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "mutex_bar", 0, 0, new String[] { localObject });
      return;
      localQQAppInterface = null;
      break;
    }
    label177:
    QLog.e("Q.recent.banner", 1, "[notifyBannerStateChange] app null");
  }
  
  private void b(ajhy paramajhy)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(201);
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(201);
    localMessage.obj = paramajhy;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 900000L);
  }
  
  private void b(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "hideGeneralBanner: " + paramMessage);
    }
    if (!(paramMessage.obj instanceof ajhy)) {}
    do
    {
      return;
      int m = ((ajhy)paramMessage.obj).jdField_a_of_type_Int;
    } while (!paramMessage.obj.equals(this.jdField_a_of_type_Ajhy));
    a(35, 0);
    a(35, paramMessage);
  }
  
  private void b(View paramView)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    paramView.setVisibility(0);
    ((TipsBar)paramView).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694772));
    if (a(11))
    {
      a(11, 0);
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_b_of_type_Int = -1;
      this.jdField_d_of_type_JavaLangString = null;
    }
    azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 1, 0, "", "", "", "");
  }
  
  private void b(View paramView, Message paramMessage)
  {
    paramView = (TipsBar)paramView;
    paramView.setVisibility(0);
    a(paramView);
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      paramView.setTipsText(((UpgradeTIMWrapper)paramMessage.obj).f);
    }
  }
  
  private void b(View paramView, Message paramMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "updateMissedCallBar state: " + paramInt);
    }
    paramMessage = (axap)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(38);
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
        paramView.findViewById(2131373475).setVisibility(0);
        ((TextView)paramView.findViewById(2131373476)).setText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698989), new Object[] { Integer.valueOf(m) }));
      } while (m > 0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(7);
      return;
    }
  }
  
  private View c()
  {
    if (this.jdField_a_of_type_Ajir != null) {
      return this.jdField_a_of_type_Ajir.a();
    }
    return null;
  }
  
  private void c(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof ajhy)) {
      return;
    }
    int m = ((ajhy)paramMessage.obj).jdField_a_of_type_Int;
    this.jdField_b_of_type_Ajhy = ((ajhy)paramMessage.obj);
    a(35, 2);
    this.jdField_a_of_type_Ajhy = this.jdField_b_of_type_Ajhy;
    a(35, paramMessage);
    b((ajhy)paramMessage.obj);
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
      localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690689));
      return;
    }
    if ((ybi.b(this.jdField_b_of_type_Int)) && (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {
      this.jdField_d_of_type_JavaLangString = "手表QQ已登录";
    }
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      localTipsBar.setTipsText(this.jdField_d_of_type_JavaLangString);
      if (this.jdField_b_of_type_Int != 5) {
        break label215;
      }
      localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838931));
      label126:
      if (this.jdField_b_of_type_Int != 4) {
        break label265;
      }
    }
    label265:
    for (int m = 23;; m = 10)
    {
      azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", m, 0, "", "", "", "");
      return;
      paramView = "QQ";
      if (this.jdField_b_of_type_Long == 77313L) {
        paramView = "TIM";
      }
      localTipsBar.setTipsText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695135), new Object[] { paramView }));
      break;
      label215:
      if (ybi.b(this.jdField_b_of_type_Int))
      {
        localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838933));
        break label126;
      }
      localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838932));
      break label126;
    }
  }
  
  private void c(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if ((paramMessage != null) && (paramMessage.obj != null))
    {
      ((TipsBar)paramView).setTipsText((String)paramMessage.obj);
      paramView.setOnClickListener(new ajgp(this));
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface)
  {
    a(15, 0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    if ((this.jdField_a_of_type_Aufw != null) && (paramQQAppInterface != null))
    {
      ((PhoneContactManagerImp)paramQQAppInterface.getManager(11)).b(this.jdField_a_of_type_Aufw);
      this.jdField_a_of_type_Aufw = null;
    }
  }
  
  private View d()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699759));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839101));
    localTipsBar.setButtonText(alud.a(2131701306));
    localTipsBar.a().setBackgroundResource(0);
    localTipsBar.a().setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166911));
    localTipsBar.setOriginalOnClickListener(new ajht(this));
    localTipsBar.setOnClickListener(new ajhu(this));
    localTipsBar.setVisibility(8);
    return localTipsBar;
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
        String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695366);
        ((TipsBar)paramView).setTipsText(Html.fromHtml(str + " " + localSongInfo.jdField_c_of_type_JavaLangString));
      }
      azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EE0", "0X8009EE0", 1, 0, "", "", "", "");
      return;
    }
    paramView.setVisibility(8);
    a(36, 0);
    a(-1, null);
  }
  
  private void d(View paramView, Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {}
    for (;;)
    {
      return;
      paramView.setVisibility(0);
      ((TipsBar)paramView).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691382));
      a((TipsBar)paramView);
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {}
      for (QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app; (localQQAppInterface != null) && (paramMessage != null) && (paramMessage.obj != null); localQQAppInterface = null)
      {
        paramMessage = (String)paramMessage.obj;
        azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 16, 0, "", "", "", "");
        paramView.setOnClickListener(new ajha(this, paramMessage));
        return;
      }
    }
  }
  
  private void d(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "handleAccountChanged with: " + this.jdField_a_of_type_Ajhy);
    }
    if ((this.jdField_a_of_type_Ajhy != null) && (this.jdField_a_of_type_Ajhy.jdField_a_of_type_Ajhw.isNeedAutoCloseWhenAccountChange())) {
      a(this.jdField_a_of_type_Ajhy);
    }
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getConfiguration().orientation == 1;
  }
  
  private View e()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130849990));
    localTipsBar.a(true);
    UpgradeTIMWrapper localUpgradeTIMWrapper = UpgradeTIMWrapper.a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
    localTipsBar.setTipsText(localUpgradeTIMWrapper.f);
    localTipsBar.setOnClickListener(new ajgd(this, localUpgradeTIMWrapper));
    localTipsBar.setCloseListener(new ajge(this, localUpgradeTIMWrapper));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void e(View paramView)
  {
    paramView.findViewById(2131372509).setVisibility(0);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131362156);
    paramView = (ADView)paramView.findViewById(2131362155);
    if (d())
    {
      localRelativeLayout.setPadding(0, 0, 0, 0);
      paramView.i();
    }
    for (;;)
    {
      azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 12, 0, "", "", "", "");
      return;
      localRelativeLayout.setPadding(0, -1, 0, 0);
    }
  }
  
  private void e(View paramView, Message paramMessage)
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
    azqs.b(null, "CliOper", "", "", "theme", "0X8007232", 0, 0, String.valueOf(m), "", "", "");
    azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 15, 0, "", "", "", "");
    paramView.setOnClickListener(new ajhl(this, n, (String)localObject, m));
  }
  
  private boolean e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).getBoolean("reveive_newpb" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), false);
  }
  
  private View f()
  {
    return anpd.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  private void f(View paramView)
  {
    paramView.findViewById(2131373899).setVisibility(0);
    ((TextView)paramView.findViewById(2131373901)).setText(alud.a(2131701298));
  }
  
  private void f(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null))
    {
      if (arho.a().a())
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695366);
        String str = arho.a().a();
        if (str != null)
        {
          ((TipsBar)paramView).setTipsText(paramMessage + "" + str);
          paramView.setVisibility(0);
          azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EE1", "0X8009EE1", 2, 0, "", "", "", "");
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
  
  private boolean f()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).getBoolean("push_banner_display" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), true);
  }
  
  private View g()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 4);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691382));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838158));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void g(View paramView)
  {
    if (!(paramView instanceof TipsBar)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null) {
      return;
    }
    paramView = (TipsBar)paramView;
    a(paramView);
    ybf localybf = (ybf)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(335);
    String str = localybf.a();
    if (TextUtils.isEmpty(str))
    {
      k();
      return;
    }
    paramView.setTipsText(str);
    int m = localybf.a();
    if (m == 1)
    {
      paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130846540));
      return;
    }
    if (m == 2)
    {
      paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130846539));
      return;
    }
    if (m == 3)
    {
      paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130846541));
      return;
    }
    paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130846538));
  }
  
  private void g(View paramView, Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.arg1 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "updateNetNeedSignOn return, msg == null || msg.arg1==HIDE");
      }
      return;
    }
    if ((paramMessage != null) && ((paramMessage.obj instanceof String))) {}
    for (paramMessage = String.valueOf(paramMessage.obj);; paramMessage = "http://qq.com")
    {
      if (paramView.getVisibility() != 0) {
        paramView.setVisibility(0);
      }
      paramView.setOnClickListener(new ajhr(this, paramMessage));
      azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004028", "0X8004028", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private View h()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130849978));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void h(View paramView, Message paramMessage)
  {
    if (!(paramView instanceof TipsBar)) {}
    while ((paramMessage == null) || (!(paramMessage.obj instanceof String))) {
      return;
    }
    String str = (String)paramMessage.obj;
    int m = paramMessage.arg1;
    paramView = (TipsBar)paramView;
    paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839175));
    a(paramView);
    paramView.setTipsText(str);
    paramView.setOnClickListener(new ajhs(this, m));
    paramView.setVisibility(0);
  }
  
  private View i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.", 2, " initApolloGameBanner");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838409));
    localTipsBar.setTipsText(alud.a(2131701304));
    localTipsBar.setVisibility(8);
    localTipsBar.a(true);
    localTipsBar.setOnClickListener(new ajgf(this));
    localTipsBar.setCloseListener(new ajgg(this));
    return localTipsBar;
  }
  
  private void i(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("updateApolloGameBanner: ").append(paramView).append(" / ").append(paramMessage).append(" / ");
      if (paramMessage == null) {
        break label85;
      }
    }
    label85:
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
    azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 10, 0, "", "", "", "");
  }
  
  private View j()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130841041));
    localTipsBar.setOnClickListener(new ajgj(this, localTipsBar));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void j(View paramView, Message paramMessage)
  {
    View localView = paramView.findViewById(2131373348);
    paramMessage = (TextView)paramView.findViewById(2131373349);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null))
    {
      int m = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a();
      if (m != 0)
      {
        localView.setVisibility(0);
        int n = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a().mMode;
        paramView = alud.a(2131701302);
        if (1 == n) {
          paramView = alud.a(2131701312);
        }
        for (;;)
        {
          paramMessage.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698739) + paramView + String.valueOf(m) + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698740));
          azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EE1", "0X8009EE1", 3, 0, "", "", "", "");
          return;
          if (2 == n) {
            paramView = alud.a(2131701301);
          }
        }
      }
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(8);
  }
  
  private View k()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131560771, null);
    localView.setOnClickListener(new ajgk(this));
    localView.findViewById(2131373348).setVisibility(8);
    return localView;
  }
  
  private void k(View paramView, Message paramMessage)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131380241);
    if (paramMessage != null)
    {
      if (paramMessage.arg1 != 1) {
        break label42;
      }
      localTextView.setText(2131721472);
    }
    for (;;)
    {
      paramView.findViewById(2131380240).setVisibility(0);
      return;
      label42:
      if (paramMessage.arg1 == 2) {
        localTextView.setText(2131721470);
      }
    }
  }
  
  private View l()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 4);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694772));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838158));
    localTipsBar.setOnClickListener(new ajgl(this));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void l()
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
  
  private void l(View paramView, Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.what == 8)) {
      if ((paramMessage.obj instanceof axmd))
      {
        paramMessage = (axmd)paramMessage.obj;
        localObject2 = paramMessage.jdField_b_of_type_JavaLangString;
        localObject1 = (TextView)paramView.findViewById(2131375648);
        ((TextView)localObject1).setText((CharSequence)localObject2);
        if ((paramMessage.jdField_e_of_type_JavaLangString != null) && (!TextUtils.isEmpty(paramMessage.jdField_e_of_type_JavaLangString)))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getApp().getResources().getDrawable(2130846964);
          localObject2 = URLDrawable.getDrawable(paramMessage.jdField_e_of_type_JavaLangString, (Drawable)localObject2, (Drawable)localObject2);
          if (localObject2 != null)
          {
            ((Drawable)localObject2).setBounds(0, 0, bdaq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 22.0F), bdaq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 22.0F));
            ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
          }
        }
        localObject1 = (Button)paramView.findViewById(2131375647);
        if ((paramMessage.f != null) && (!TextUtils.isEmpty(paramMessage.f))) {
          ((Button)localObject1).setText(paramMessage.f);
        }
        localObject2 = paramMessage.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
        localaxlx = (axlx)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36);
        if ((paramMessage.jdField_a_of_type_JavaLangString != null) && (localObject2 != null) && (localaxlx != null))
        {
          ((Button)localObject1).setOnClickListener(new ajgn(this, localaxlx, paramMessage, (BusinessInfoCheckUpdate.AppInfo)localObject2));
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(9, paramMessage.jdField_b_of_type_Long);
          a((BusinessInfoCheckUpdate.AppInfo)localObject2, paramMessage.jdField_a_of_type_JavaLangString);
          paramView.setVisibility(0);
        }
      }
    }
    while (paramView.getVisibility() != 8)
    {
      Object localObject2;
      Object localObject1;
      axlx localaxlx;
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(9);
  }
  
  private View m()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 4);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694767));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838158));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void m()
  {
    a(33, 0);
    a(33, null);
  }
  
  private void m(View paramView, Message paramMessage)
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
        azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 2, 0, "", "", "", "");
        return;
      }
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(8);
  }
  
  private View n()
  {
    AdvancedTipsBar localAdvancedTipsBar = new AdvancedTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localAdvancedTipsBar, 2);
    aobo.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localAdvancedTipsBar);
    return localAdvancedTipsBar;
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      return;
    }
    int m = 0;
    label10:
    Object localObject;
    if (m < 6)
    {
      localObject = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(m);
      if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {
        break label46;
      }
    }
    for (;;)
    {
      m += 1;
      break label10;
      break;
      label46:
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        int n = ((Integer)((Iterator)localObject).next()).intValue();
        ajfz localajfz = this.jdField_a_of_type_ArrayOfAjfz[n];
        if ((localajfz != null) && (localajfz.jdField_a_of_type_AndroidViewView != null) && (localajfz.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(localajfz.jdField_a_of_type_AndroidViewView);
          localajfz.jdField_a_of_type_Boolean = false;
          if (!localajfz.a()) {
            localajfz.jdField_a_of_type_AndroidViewView = null;
          }
        }
      }
    }
  }
  
  private void n(View paramView, Message paramMessage)
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
        ((TipsBar)paramView).setTipsText(Html.fromHtml((String)paramMessage.second + alud.a(2131701303)));
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
        a(34, 0);
      }
    }
    for (;;)
    {
      a(-1, null);
      return;
      paramView.setVisibility(8);
      a(34, 0);
    }
  }
  
  private View o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initMissedCallBar");
    }
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131560855, null);
    ((TextView)localView.findViewById(2131373476)).setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698989));
    localView.findViewById(2131373475).setVisibility(8);
    return localView;
  }
  
  private void o()
  {
    ThreadManager.post(new BannerManager.41(this), 5, null, false);
  }
  
  private void o(View paramView, Message paramMessage)
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
    ((TipsBar)paramView).setTipsText(alud.a(2131701309) + str1 + "》");
    paramView.setOnClickListener(new ajgw(this, l, str2));
    ((TipsBar)paramView).setCloseListener(new ajhx(13, this.jdField_a_of_type_MqqOsMqqHandler));
    paramView.setVisibility(0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(13);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(13, 900000L);
    azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 1, 0, "", "", "", "");
  }
  
  private View p()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131561850, null);
    localView.setVisibility(8);
    return localView;
  }
  
  private void p(View paramView, Message paramMessage)
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
          ((TipsBar)paramView).setTipsText(alud.a(2131701308));
          localObject1 = (String)localObject1 + "&ADTAG=aio.run.click";
        }
        for (;;)
        {
          paramView.setOnClickListener(new ajgx(this, (String)localObject1, localLong, m));
          if (localLong.longValue() == 3L)
          {
            localObject1 = new LpReportInfo_dc00307(LpReportInfo_dc00307.ACTION_TYPE_RED_PACK, LpReportInfo_dc00307.SUB_ACTION_TYPE_RED_PACK_EXPOSURE, m);
            LpReportManager.getInstance().reportToDC00307((LpReportInfo_dc00307)localObject1, false, true);
          }
          if ((paramView instanceof TipsBar)) {
            ((TipsBar)paramView).setCloseListener(new ajhx(1134044, ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime()).getHandler(Conversation.class)));
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            paramView = new Bundle();
            paramMessage.obj = paramView;
            paramMessage = Message.obtain(paramMessage);
            bfhv.a().a((String)localObject2, new ajgy(this, paramView, paramMessage));
          }
          azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 9, 0, "", "", "", "");
          return;
          if (localLong.longValue() == 2L)
          {
            ((TipsBar)paramView).setTipsText(alud.a(2131701300));
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
  
  private View q()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131560707, null);
    localView.findViewById(2131380241).setOnClickListener(new ajgm(this));
    localView.findViewById(2131380240).setVisibility(8);
    return localView;
  }
  
  private void q(View paramView, Message paramMessage)
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
        localTextView = (TextView)paramView.findViewById(2131362400);
      } while ((!(paramMessage.obj instanceof Bundle)) || (localTextView == null));
      paramMessage = (Bundle)paramMessage.obj;
      str = (String)paramMessage.getCharSequence("tips");
      int m = paramMessage.getInt("icon");
      if (m != -1) {
        ((ImageView)paramView.findViewById(2131362399)).setImageResource(m);
      }
    } while (TextUtils.isEmpty(str));
    localTextView.setText(str);
    paramView.setOnClickListener(new ajgz(this, paramMessage));
    paramView.findViewById(2131362397).setVisibility(0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(15);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(15, paramMessage.getInt("timeout", 120000));
  }
  
  private View r()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131562804, null);
    TextView localTextView = (TextView)localView.findViewById(2131379346);
    localTextView.setOnClickListener(new ajgo(this));
    localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131721233));
    ((ImageView)localView.findViewById(2131364353)).setOnClickListener(new ajgq(this));
    localView.findViewById(2131379345).setVisibility(8);
    return localView;
  }
  
  private void r(View paramView, Message paramMessage)
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
        localTextView = (TextView)paramView.findViewById(2131362406);
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
        break label436;
      }
      paramMessage = paramMessage.substring(0, m) + "...";
    }
    label436:
    for (;;)
    {
      if ((n >= 100) && (n <= 300)) {
        localTextView.setText(alud.a(2131701296) + paramMessage + "》");
      }
      for (;;)
      {
        paramView.setOnClickListener(new ajhb(this, str));
        paramView.findViewById(2131362424).setVisibility(0);
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(14);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(14, 900000L);
        azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 2, 0, "", "", "", "");
        return;
        m = ((DisplayMetrics)localObject).widthPixels;
        break;
        localTextView.setText(alud.a(2131701307) + paramMessage + "》");
      }
    }
  }
  
  private View s()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838932));
    localTipsBar.a(true);
    localTipsBar.setCloseListener(new ajgr(this));
    localTipsBar.setOnClickListener(new ajgs(this));
    return localTipsBar;
  }
  
  private void s(View paramView, Message paramMessage)
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
          paramView.setOnClickListener(new ajhd(this, paramMessage));
          paramView.setCloseListener(new ajhx(30, this.jdField_a_of_type_MqqOsMqqHandler));
          a(paramView);
          paramView.setVisibility(0);
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(30);
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(30, paramMessage.getInt("timeout", 900000));
          azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 4, 0, "", "", "", "");
          return;
          if (m != 1) {
            paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(m));
          }
        }
      }
    }
  }
  
  private View t()
  {
    View localView1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558908, null);
    View localView2 = localView1.findViewById(2131364842);
    localView1.setOnClickListener(new ajgt(this));
    localView2.setVisibility(8);
    return localView1;
  }
  
  private void t(View paramView, Message paramMessage)
  {
    paramView.findViewById(2131379345).setVisibility(0);
    paramView = (TextView)paramView.findViewById(2131379346);
    if (paramMessage != null)
    {
      if (alqf.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) {
        break label91;
      }
      paramMessage = amqe.a().a();
      if ((paramMessage != null) && (paramMessage.a != null) && (paramMessage.a.dialog != null)) {
        paramView.setText(paramMessage.a.dialog.h);
      }
    }
    else
    {
      return;
    }
    paramView.setText(alud.a(2131701297));
    return;
    label91:
    paramMessage = amqe.a().a();
    if ((paramMessage != null) && (paramMessage.a != null) && (paramMessage.a.dialog != null))
    {
      paramView.setText(paramMessage.a.dialog.g);
      return;
    }
    paramView.setText(alud.a(2131701305));
  }
  
  private View u()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130841041));
    localTipsBar.setOnClickListener(new ajgu(this));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void u(View paramView, Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
      mol.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, paramView, paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
    }
  }
  
  private View v()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130841040));
    localTipsBar.a(true);
    localTipsBar.setOnClickListener(new ajgv(this));
    localTipsBar.setCloseListener(new ajhx(1134060, ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime()).getHandler(Conversation.class)));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void v(View paramView, Message paramMessage)
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
    paramView.setOnClickListener(new ajho(this, paramMessage));
    paramView.setVisibility(0);
    azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 6, 0, "", "", "", "");
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(202);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(202, 7000L);
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext();
    if (paramMessage.tipsType == 2) {}
    for (int m = 398680;; m = 398678)
    {
      bezm.b(paramView, m);
      return;
    }
  }
  
  private View w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReaderBar", 2, "initReaderBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.a(true);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838246));
    return localTipsBar;
  }
  
  @SuppressLint({"ResourceType"})
  private void w(View paramView, Message paramMessage)
  {
    paramView = (TipsBar)paramView;
    a(paramView);
    if (paramMessage == null) {
      return;
    }
    paramMessage = (ajhy)paramMessage.obj;
    paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(ajga.a(paramMessage.jdField_b_of_type_Int)));
    paramView.setTipsText(paramMessage.jdField_b_of_type_JavaLangString);
    paramView.setOnClickListener(new ajia(paramMessage, this.jdField_a_of_type_MqqOsMqqHandler));
    paramView.setCloseListener(new ajhz(paramMessage, this.jdField_a_of_type_MqqOsMqqHandler));
    paramView.setVisibility(0);
    azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 1, 0, "", "", "", "");
  }
  
  private View x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RunningBar", 2, "initRunningBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsText(alud.a(2131701311));
    localTipsBar.a(true);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838247));
    return localTipsBar;
  }
  
  private View y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BrowserBar", 2, "initBrowserBar");
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131558615, null);
    localView.findViewById(2131362397).setVisibility(8);
    return localView;
  }
  
  private View z()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComicBar", 2, "initComicBar");
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131558617, null);
    localView.findViewById(2131362424).setVisibility(8);
    return localView;
  }
  
  public int a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfAjfz.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfAjfz[paramInt];
      }
    }
    if (localObject1 == null) {
      return 0;
    }
    return ((ajfz)localObject1).jdField_b_of_type_Int;
  }
  
  public int a(SparseArray<ArrayList<Integer>> paramSparseArray, int paramInt)
  {
    int i1 = 0;
    int n = 0;
    int m;
    if (paramSparseArray == null) {
      m = n;
    }
    do
    {
      do
      {
        return m;
        paramSparseArray = (ArrayList)paramSparseArray.get(paramInt);
        m = n;
      } while (paramSparseArray == null);
      m = n;
    } while (paramSparseArray.size() <= 0);
    paramSparseArray = paramSparseArray.iterator();
    for (paramInt = i1;; paramInt = ((Integer)paramSparseArray.next()).intValue() + paramInt)
    {
      m = paramInt;
      if (!paramSparseArray.hasNext()) {
        break;
      }
    }
  }
  
  public View a()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131560856, null);
    localView.findViewById(2131373477).setVisibility(8);
    return localView;
  }
  
  public Object a(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_ArrayOfAjfz.length)) {}
    for (ajfz localajfz = this.jdField_a_of_type_ArrayOfAjfz[paramInt1];; localajfz = null)
    {
      Object localObject1 = localObject2;
      if (localajfz != null)
      {
        localObject1 = localObject2;
        if (localajfz.jdField_a_of_type_AndroidViewView != null)
        {
          if (paramInt2 != 0) {
            break label58;
          }
          localObject1 = localajfz.jdField_a_of_type_AndroidViewView.getTag();
        }
      }
      return localObject1;
      label58:
      return localajfz.jdField_a_of_type_AndroidViewView.getTag(paramInt2);
    }
  }
  
  public MqqHandler a()
  {
    return this.jdField_a_of_type_MqqOsMqqHandler;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ajir != null) {
      this.jdField_a_of_type_Ajir.h();
    }
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface();
    if ((localAppInterface != null) && ((localAppInterface instanceof QQAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter = ((azbi)localAppInterface.getManager(12)).a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter.a();
    }
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "fight.setPushBannerHeight:" + paramFloat + ",mIsStoryShow:" + this.g);
    }
    Object localObject1 = this.jdField_a_of_type_ArrayOfAjfz[21];
    if ((localObject1 == null) || (((ajfz)localObject1).jdField_a_of_type_AndroidViewView == null))
    {
      break label67;
      break label67;
    }
    for (;;)
    {
      label67:
      return;
      if (!((ajfz)localObject1).jdField_a_of_type_Boolean) {
        continue;
      }
      if (paramFloat > 0.0F)
      {
        c(true);
        return;
      }
      localObject1 = ((ajfz)localObject1).jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break;
      }
      int m = (int)Math.abs(paramFloat);
      localObject1 = ((View)localObject1).findViewById(2131372509);
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
      int n = this.jdField_c_of_type_Int;
      label158:
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
            localObject2 = a(21, 2131362155);
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
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X80094CD", "0X80094CD", n, 0, "", "", "", "");
        localLayoutParams.height = m;
        ((View)localObject1).setAlpha(paramFloat);
        ((View)localObject1).requestLayout();
        return;
        if (paramFloat >= -3.0F)
        {
          m = this.jdField_c_of_type_Int;
          paramFloat = 1.0F;
          break label158;
        }
        paramFloat = (n - m) / this.jdField_c_of_type_Int;
        m = n - m;
        break label158;
        if (localLayoutParams.height == 0) {
          continue;
        }
        ((View)localObject1).findViewById(2131364327).setVisibility(4);
        if (paramFloat < this.jdField_a_of_type_Float - n)
        {
          paramFloat = 0.0F;
          m = 0;
          break label158;
        }
        if (paramFloat < this.jdField_a_of_type_Float)
        {
          m = (int)(n + paramFloat - this.jdField_a_of_type_Float);
          paramFloat = m / n;
          break label158;
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
      QLog.d("Q.recent.banner", 4, "updateBanerState|[" + paramInt1 + "," + paramInt2 + "]");
    }
    if ((paramInt1 >= 1) && (paramInt1 <= 41))
    {
      if (this.jdField_a_of_type_ArrayOfAjfz[paramInt1] == null) {
        break label101;
      }
      this.jdField_a_of_type_ArrayOfAjfz[paramInt1].jdField_b_of_type_Int = paramInt2;
    }
    for (;;)
    {
      if ((paramInt1 >= 28) && (paramInt1 <= 35) && (paramInt2 == 2)) {
        a(paramInt1);
      }
      return;
      label101:
      if ((this.jdField_a_of_type_ArrayOfAjfz[paramInt1] == null) && (ajfz.a(paramInt2))) {
        this.jdField_a_of_type_ArrayOfAjfz[paramInt1] = new ajfz(paramInt1, paramInt2);
      }
    }
  }
  
  /* Error */
  public void a(int paramInt, Message paramMessage)
  {
    // Byte code:
    //   0: invokestatic 315	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 245
    //   8: iconst_4
    //   9: new 317	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1875
    //   19: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 625	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: ldc_w 1877
    //   29: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: getfield 1879	ajgb:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   46: ifnonnull +16 -> 62
    //   49: aload_0
    //   50: new 1398	android/util/SparseArray
    //   53: dup
    //   54: bipush 6
    //   56: invokespecial 1881	android/util/SparseArray:<init>	(I)V
    //   59: putfield 1879	ajgb:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   62: iconst_0
    //   63: istore_3
    //   64: iload_3
    //   65: bipush 6
    //   67: if_icmpge +56 -> 123
    //   70: aload_0
    //   71: getfield 1879	ajgb:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   74: iload_3
    //   75: invokevirtual 1402	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   78: checkcast 1404	java/util/ArrayList
    //   81: astore 6
    //   83: aload 6
    //   85: ifnonnull +30 -> 115
    //   88: new 1404	java/util/ArrayList
    //   91: dup
    //   92: iconst_1
    //   93: invokespecial 1882	java/util/ArrayList:<init>	(I)V
    //   96: astore 6
    //   98: aload_0
    //   99: getfield 1879	ajgb:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   102: iload_3
    //   103: aload 6
    //   105: invokevirtual 1885	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   108: iload_3
    //   109: iconst_1
    //   110: iadd
    //   111: istore_3
    //   112: goto -48 -> 64
    //   115: aload 6
    //   117: invokevirtual 1887	java/util/ArrayList:clear	()V
    //   120: goto -12 -> 108
    //   123: aload_0
    //   124: getfield 1396	ajgb:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   127: ifnonnull +16 -> 143
    //   130: aload_0
    //   131: new 1398	android/util/SparseArray
    //   134: dup
    //   135: bipush 6
    //   137: invokespecial 1881	android/util/SparseArray:<init>	(I)V
    //   140: putfield 1396	ajgb:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   143: iconst_1
    //   144: istore_3
    //   145: iload_3
    //   146: bipush 26
    //   148: if_icmpgt +54 -> 202
    //   151: aload_0
    //   152: getfield 66	ajgb:jdField_a_of_type_ArrayOfAjfz	[Lajfz;
    //   155: iload_3
    //   156: aaload
    //   157: ifnull +172 -> 329
    //   160: aload_0
    //   161: getfield 66	ajgb:jdField_a_of_type_ArrayOfAjfz	[Lajfz;
    //   164: iload_3
    //   165: aaload
    //   166: invokevirtual 1430	ajfz:a	()Z
    //   169: ifeq +160 -> 329
    //   172: aload_0
    //   173: getfield 1879	ajgb:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   176: iconst_0
    //   177: invokevirtual 1402	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   180: checkcast 1404	java/util/ArrayList
    //   183: astore 6
    //   185: aload_0
    //   186: getfield 1879	ajgb:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   189: ifnull +13 -> 202
    //   192: aload 6
    //   194: iload_3
    //   195: invokestatic 984	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: invokevirtual 1889	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   201: pop
    //   202: bipush 27
    //   204: istore_3
    //   205: iload_3
    //   206: bipush 27
    //   208: if_icmpgt +54 -> 262
    //   211: aload_0
    //   212: getfield 66	ajgb:jdField_a_of_type_ArrayOfAjfz	[Lajfz;
    //   215: iload_3
    //   216: aaload
    //   217: ifnull +119 -> 336
    //   220: aload_0
    //   221: getfield 66	ajgb:jdField_a_of_type_ArrayOfAjfz	[Lajfz;
    //   224: iload_3
    //   225: aaload
    //   226: invokevirtual 1430	ajfz:a	()Z
    //   229: ifeq +107 -> 336
    //   232: aload_0
    //   233: getfield 1879	ajgb:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   236: iconst_1
    //   237: invokevirtual 1402	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   240: checkcast 1404	java/util/ArrayList
    //   243: astore 6
    //   245: aload_0
    //   246: getfield 1879	ajgb:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   249: ifnull +13 -> 262
    //   252: aload 6
    //   254: iload_3
    //   255: invokestatic 984	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: invokevirtual 1889	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   261: pop
    //   262: bipush 28
    //   264: istore_3
    //   265: iload_3
    //   266: bipush 35
    //   268: if_icmpgt +75 -> 343
    //   271: aload_0
    //   272: getfield 66	ajgb:jdField_a_of_type_ArrayOfAjfz	[Lajfz;
    //   275: iload_3
    //   276: aaload
    //   277: ifnull +45 -> 322
    //   280: aload_0
    //   281: getfield 66	ajgb:jdField_a_of_type_ArrayOfAjfz	[Lajfz;
    //   284: iload_3
    //   285: aaload
    //   286: invokevirtual 1430	ajfz:a	()Z
    //   289: ifeq +33 -> 322
    //   292: aload_0
    //   293: getfield 1879	ajgb:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   296: iconst_2
    //   297: invokevirtual 1402	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   300: checkcast 1404	java/util/ArrayList
    //   303: astore 6
    //   305: aload_0
    //   306: getfield 1879	ajgb:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   309: ifnull +13 -> 322
    //   312: aload 6
    //   314: iload_3
    //   315: invokestatic 984	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   318: invokevirtual 1889	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   321: pop
    //   322: iload_3
    //   323: iconst_1
    //   324: iadd
    //   325: istore_3
    //   326: goto -61 -> 265
    //   329: iload_3
    //   330: iconst_1
    //   331: iadd
    //   332: istore_3
    //   333: goto -188 -> 145
    //   336: iload_3
    //   337: iconst_1
    //   338: iadd
    //   339: istore_3
    //   340: goto -135 -> 205
    //   343: bipush 36
    //   345: istore_3
    //   346: iload_3
    //   347: bipush 36
    //   349: if_icmpgt +52 -> 401
    //   352: aload_0
    //   353: getfield 66	ajgb:jdField_a_of_type_ArrayOfAjfz	[Lajfz;
    //   356: iload_3
    //   357: aaload
    //   358: ifnull +238 -> 596
    //   361: aload_0
    //   362: getfield 66	ajgb:jdField_a_of_type_ArrayOfAjfz	[Lajfz;
    //   365: iload_3
    //   366: aaload
    //   367: invokevirtual 1430	ajfz:a	()Z
    //   370: ifeq +226 -> 596
    //   373: aload_0
    //   374: getfield 1879	ajgb:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   377: iconst_3
    //   378: invokevirtual 1402	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   381: checkcast 1404	java/util/ArrayList
    //   384: astore 6
    //   386: aload 6
    //   388: ifnull +13 -> 401
    //   391: aload 6
    //   393: iload_3
    //   394: invokestatic 984	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   397: invokevirtual 1889	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   400: pop
    //   401: bipush 37
    //   403: istore_3
    //   404: iload_3
    //   405: bipush 39
    //   407: if_icmpgt +52 -> 459
    //   410: aload_0
    //   411: getfield 66	ajgb:jdField_a_of_type_ArrayOfAjfz	[Lajfz;
    //   414: iload_3
    //   415: aaload
    //   416: ifnull +187 -> 603
    //   419: aload_0
    //   420: getfield 66	ajgb:jdField_a_of_type_ArrayOfAjfz	[Lajfz;
    //   423: iload_3
    //   424: aaload
    //   425: invokevirtual 1430	ajfz:a	()Z
    //   428: ifeq +175 -> 603
    //   431: aload_0
    //   432: getfield 1879	ajgb:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   435: iconst_4
    //   436: invokevirtual 1402	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   439: checkcast 1404	java/util/ArrayList
    //   442: astore 6
    //   444: aload 6
    //   446: ifnull +13 -> 459
    //   449: aload 6
    //   451: iload_3
    //   452: invokestatic 984	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   455: invokevirtual 1889	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   458: pop
    //   459: bipush 40
    //   461: istore_3
    //   462: iload_3
    //   463: bipush 41
    //   465: if_icmpgt +52 -> 517
    //   468: aload_0
    //   469: getfield 66	ajgb:jdField_a_of_type_ArrayOfAjfz	[Lajfz;
    //   472: iload_3
    //   473: aaload
    //   474: ifnull +136 -> 610
    //   477: aload_0
    //   478: getfield 66	ajgb:jdField_a_of_type_ArrayOfAjfz	[Lajfz;
    //   481: iload_3
    //   482: aaload
    //   483: invokevirtual 1430	ajfz:a	()Z
    //   486: ifeq +124 -> 610
    //   489: aload_0
    //   490: getfield 1879	ajgb:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   493: iconst_5
    //   494: invokevirtual 1402	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   497: checkcast 1404	java/util/ArrayList
    //   500: astore 6
    //   502: aload 6
    //   504: ifnull +13 -> 517
    //   507: aload 6
    //   509: iload_3
    //   510: invokestatic 984	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   513: invokevirtual 1889	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   516: pop
    //   517: iconst_0
    //   518: istore 5
    //   520: iconst_1
    //   521: istore_3
    //   522: iconst_1
    //   523: istore 4
    //   525: iload 5
    //   527: bipush 6
    //   529: if_icmpge +88 -> 617
    //   532: aload_0
    //   533: getfield 1396	ajgb:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   536: iload 5
    //   538: invokevirtual 1402	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   541: checkcast 1891	java/util/List
    //   544: astore 6
    //   546: aload_0
    //   547: getfield 1879	ajgb:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   550: iload 5
    //   552: invokevirtual 1402	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   555: checkcast 1891	java/util/List
    //   558: astore 7
    //   560: aload 7
    //   562: aload 6
    //   564: invokeinterface 1892 2 0
    //   569: ifne +597 -> 1166
    //   572: iconst_0
    //   573: istore 4
    //   575: aload 7
    //   577: invokeinterface 1894 1 0
    //   582: ifne +581 -> 1163
    //   585: iconst_0
    //   586: istore_3
    //   587: iload 5
    //   589: iconst_1
    //   590: iadd
    //   591: istore 5
    //   593: goto -68 -> 525
    //   596: iload_3
    //   597: iconst_1
    //   598: iadd
    //   599: istore_3
    //   600: goto -254 -> 346
    //   603: iload_3
    //   604: iconst_1
    //   605: iadd
    //   606: istore_3
    //   607: goto -203 -> 404
    //   610: iload_3
    //   611: iconst_1
    //   612: iadd
    //   613: istore_3
    //   614: goto -152 -> 462
    //   617: iload 4
    //   619: ifeq +23 -> 642
    //   622: iload_3
    //   623: ifeq +19 -> 642
    //   626: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   629: ifeq +12 -> 641
    //   632: ldc 245
    //   634: iconst_2
    //   635: ldc_w 1896
    //   638: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   641: return
    //   642: iload_3
    //   643: ifeq +23 -> 666
    //   646: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   649: ifeq +12 -> 661
    //   652: ldc 245
    //   654: iconst_2
    //   655: ldc_w 1898
    //   658: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   661: aload_0
    //   662: invokespecial 1900	ajgb:n	()V
    //   665: return
    //   666: aload_0
    //   667: aload_0
    //   668: getfield 1879	ajgb:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   671: iconst_2
    //   672: invokevirtual 1902	ajgb:a	(Landroid/util/SparseArray;I)I
    //   675: istore_3
    //   676: aload_0
    //   677: aload_0
    //   678: getfield 1396	ajgb:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   681: iconst_2
    //   682: invokevirtual 1902	ajgb:a	(Landroid/util/SparseArray;I)I
    //   685: istore 5
    //   687: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   690: ifeq +32 -> 722
    //   693: ldc 245
    //   695: iconst_2
    //   696: new 317	java/lang/StringBuilder
    //   699: dup
    //   700: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   703: ldc_w 1904
    //   706: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: iload_3
    //   710: iload 5
    //   712: isub
    //   713: invokevirtual 625	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   716: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   722: iload 4
    //   724: ifne +59 -> 783
    //   727: aload_0
    //   728: invokespecial 1900	ajgb:n	()V
    //   731: iconst_0
    //   732: istore_3
    //   733: iload_3
    //   734: bipush 6
    //   736: if_icmpge +47 -> 783
    //   739: aload_0
    //   740: getfield 1879	ajgb:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   743: iload_3
    //   744: invokevirtual 1402	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   747: checkcast 1404	java/util/ArrayList
    //   750: astore 6
    //   752: aload 6
    //   754: ifnull +22 -> 776
    //   757: aload_0
    //   758: getfield 1396	ajgb:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   761: iload_3
    //   762: aload 6
    //   764: invokevirtual 1907	java/util/ArrayList:clone	()Ljava/lang/Object;
    //   767: checkcast 1404	java/util/ArrayList
    //   770: checkcast 1404	java/util/ArrayList
    //   773: invokevirtual 1885	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   776: iload_3
    //   777: iconst_1
    //   778: iadd
    //   779: istore_3
    //   780: goto -47 -> 733
    //   783: iconst_0
    //   784: istore 5
    //   786: iconst_0
    //   787: istore_3
    //   788: iload 5
    //   790: bipush 6
    //   792: if_icmpge +273 -> 1065
    //   795: aload_0
    //   796: getfield 1396	ajgb:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   799: iload 5
    //   801: invokevirtual 1402	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   804: checkcast 1404	java/util/ArrayList
    //   807: astore 6
    //   809: iload_3
    //   810: istore 4
    //   812: aload 6
    //   814: ifnull +14 -> 828
    //   817: aload 6
    //   819: invokevirtual 1407	java/util/ArrayList:size	()I
    //   822: ifne +18 -> 840
    //   825: iload_3
    //   826: istore 4
    //   828: iload 5
    //   830: iconst_1
    //   831: iadd
    //   832: istore 5
    //   834: iload 4
    //   836: istore_3
    //   837: goto -49 -> 788
    //   840: aload 6
    //   842: invokevirtual 1411	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   845: astore 7
    //   847: iload_3
    //   848: istore 4
    //   850: aload 7
    //   852: invokeinterface 1416 1 0
    //   857: ifeq -29 -> 828
    //   860: aload 7
    //   862: invokeinterface 1420 1 0
    //   867: checkcast 980	java/lang/Integer
    //   870: invokevirtual 1423	java/lang/Integer:intValue	()I
    //   873: istore 4
    //   875: aload_0
    //   876: getfield 66	ajgb:jdField_a_of_type_ArrayOfAjfz	[Lajfz;
    //   879: iload 4
    //   881: aaload
    //   882: astore 8
    //   884: aload 8
    //   886: ifnull -39 -> 847
    //   889: aload_0
    //   890: aload 8
    //   892: invokespecial 1909	ajgb:a	(Lajfz;)V
    //   895: iload_3
    //   896: istore 4
    //   898: aload 8
    //   900: getfield 310	ajfz:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   903: ifnull +85 -> 988
    //   906: iload_3
    //   907: istore 4
    //   909: aload 8
    //   911: getfield 1424	ajfz:jdField_a_of_type_Boolean	Z
    //   914: ifne +74 -> 988
    //   917: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   920: ifeq +12 -> 932
    //   923: ldc 245
    //   925: iconst_2
    //   926: ldc_w 1911
    //   929: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   932: aload 8
    //   934: getfield 312	ajfz:jdField_a_of_type_Int	I
    //   937: bipush 21
    //   939: if_icmpne +27 -> 966
    //   942: aload_0
    //   943: getfield 1826	ajgb:g	Z
    //   946: ifeq +20 -> 966
    //   949: aload 8
    //   951: getfield 310	ajfz:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   954: ldc 221
    //   956: invokevirtual 138	android/view/View:findViewById	(I)Landroid/view/View;
    //   959: invokevirtual 1836	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   962: iconst_0
    //   963: putfield 1839	android/view/ViewGroup$LayoutParams:height	I
    //   966: aload_0
    //   967: getfield 70	ajgb:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   970: aload 8
    //   972: getfield 310	ajfz:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   975: iconst_1
    //   976: invokevirtual 1914	com/tencent/widget/XListView:addHeaderView	(Landroid/view/View;I)V
    //   979: aload 8
    //   981: iconst_1
    //   982: putfield 1424	ajfz:jdField_a_of_type_Boolean	Z
    //   985: iconst_1
    //   986: istore 4
    //   988: iload 4
    //   990: istore_3
    //   991: aload_2
    //   992: ifnull +12 -> 1004
    //   995: iload_1
    //   996: aload 8
    //   998: getfield 312	ajfz:jdField_a_of_type_Int	I
    //   1001: if_icmpeq +54 -> 1055
    //   1004: aload_0
    //   1005: aload 8
    //   1007: aconst_null
    //   1008: invokespecial 1916	ajgb:a	(Lajfz;Landroid/os/Message;)V
    //   1011: goto -164 -> 847
    //   1014: astore 6
    //   1016: invokestatic 315	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1019: ifeq +33 -> 1052
    //   1022: ldc 245
    //   1024: iconst_4
    //   1025: new 317	java/lang/StringBuilder
    //   1028: dup
    //   1029: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   1032: ldc_w 1918
    //   1035: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: aload 6
    //   1040: invokevirtual 1919	java/lang/Exception:toString	()Ljava/lang/String;
    //   1043: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1049: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1052: goto -61 -> 991
    //   1055: aload_0
    //   1056: aload 8
    //   1058: aload_2
    //   1059: invokespecial 1916	ajgb:a	(Lajfz;Landroid/os/Message;)V
    //   1062: goto -51 -> 1011
    //   1065: iload_3
    //   1066: ifeq -425 -> 641
    //   1069: aload_0
    //   1070: getfield 68	ajgb:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1073: ifnull +78 -> 1151
    //   1076: aload_0
    //   1077: getfield 68	ajgb:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1080: getfield 191	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1083: astore_2
    //   1084: aload_2
    //   1085: ifnull -444 -> 641
    //   1088: aload_2
    //   1089: sipush 252
    //   1092: invokevirtual 968	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1095: checkcast 1921	uza
    //   1098: getfield 1922	uza:jdField_a_of_type_Boolean	Z
    //   1101: ifeq -460 -> 641
    //   1104: aload_0
    //   1105: getfield 70	ajgb:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   1108: invokevirtual 1925	com/tencent/widget/XListView:getFirstVisiblePosition	()I
    //   1111: istore_1
    //   1112: iload_1
    //   1113: aload_0
    //   1114: getfield 70	ajgb:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   1117: invokevirtual 1928	com/tencent/widget/XListView:getHeaderViewsCount	()I
    //   1120: if_icmpgt -479 -> 641
    //   1123: aload_0
    //   1124: getfield 70	ajgb:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   1127: iconst_0
    //   1128: invokevirtual 1930	com/tencent/widget/XListView:getHeaderViewsCount	(I)I
    //   1131: istore_3
    //   1132: iload_3
    //   1133: iconst_m1
    //   1134: if_icmpeq -493 -> 641
    //   1137: iload_3
    //   1138: iload_1
    //   1139: if_icmpgt -498 -> 641
    //   1142: aload_0
    //   1143: getfield 70	ajgb:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   1146: iload_3
    //   1147: invokevirtual 1933	com/tencent/widget/XListView:setSelection	(I)V
    //   1150: return
    //   1151: aconst_null
    //   1152: astore_2
    //   1153: goto -69 -> 1084
    //   1156: astore 6
    //   1158: iconst_1
    //   1159: istore_3
    //   1160: goto -144 -> 1016
    //   1163: goto -576 -> 587
    //   1166: goto -591 -> 575
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1169	0	this	ajgb
    //   0	1169	1	paramInt	int
    //   0	1169	2	paramMessage	Message
    //   63	1097	3	m	int
    //   523	466	4	n	int
    //   518	315	5	i1	int
    //   81	760	6	localObject1	Object
    //   1014	25	6	localException1	Exception
    //   1156	1	6	localException2	Exception
    //   558	303	7	localObject2	Object
    //   882	175	8	localajfz	ajfz
    // Exception table:
    //   from	to	target	type
    //   898	906	1014	java/lang/Exception
    //   909	932	1014	java/lang/Exception
    //   932	966	1014	java/lang/Exception
    //   966	979	1014	java/lang/Exception
    //   979	985	1156	java/lang/Exception
  }
  
  public void a(Message paramMessage)
  {
    Bundle localBundle = (Bundle)paramMessage.obj;
    String str = localBundle.getString("iconURL");
    if (!TextUtils.isEmpty(str))
    {
      paramMessage = Message.obtain(paramMessage);
      bfhv.a().a(str, new ajhc(this, localBundle, paramMessage));
      return;
    }
    a(31, 2);
    a(31, paramMessage);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "onDestroy");
      }
      this.f = true;
      if ((this.jdField_a_of_type_Aufw != null) && (paramQQAppInterface != null))
      {
        ((PhoneContactManagerImp)paramQQAppInterface.getManager(11)).b(this.jdField_a_of_type_Aufw);
        this.jdField_a_of_type_Aufw = null;
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
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    Object localObject;
    axlx localaxlx;
    if ((paramAppInfo != null) && (paramString != null))
    {
      localObject = paramAppInfo.buffer.get();
      if (!bdnn.a((String)localObject)) {
        localaxlx = (axlx)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36);
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject("msg").getJSONObject(paramString);
      if ((localJSONObject != null) && (localJSONObject.getInt("blue_bar_stat") == 1))
      {
        localJSONObject.put("blue_bar_stat", 2);
        paramAppInfo.buffer.set(((JSONObject)localObject).toString());
        localaxlx.a(paramAppInfo, false);
        a(paramAppInfo, paramString, 2);
      }
      return;
    }
    catch (Exception paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString, int paramInt)
  {
    axlx localaxlx;
    JSONObject localJSONObject;
    if (((paramAppInfo != null) && (3 == paramInt)) || (2 == paramInt))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.recent.banner", 2, "onReportRenewBannerExposure");
      }
      localaxlx = (axlx)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("cmd", paramInt);
      localJSONObject.put("missionid", paramString);
      localaxlx.a(paramAppInfo, localJSONObject, paramInt);
      return;
    }
    catch (JSONException paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    if ((a(16)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString)) && (this.jdField_e_of_type_JavaLangString.equals(paramString)))
    {
      this.jdField_e_of_type_JavaLangString = "";
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 1000L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ArrayOfAjfz[15] != null) {
      a(15, 0);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    if (paramBoolean)
    {
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(11);
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
      if ((this.jdField_a_of_type_Aufw == null) && (!this.f))
      {
        this.jdField_a_of_type_Aufw = new ajgc(this);
        localPhoneContactManagerImp.a(this.jdField_a_of_type_Aufw);
      }
      paramBoolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), 0).getBoolean("key_show_contact_banner", true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "checkContactBanner, state = " + m + ", isFirstShow = " + paramBoolean);
      }
      if ((m == 1) && (paramBoolean))
      {
        if ((this.jdField_a_of_type_ArrayOfAjfz[15] != null) && (this.jdField_a_of_type_ArrayOfAjfz[15].jdField_b_of_type_Int != 2)) {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X80053D8", "0X80053D8", 0, 0, "", "", "", "");
        }
        a(15, 2);
        azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 13, 0, "", "", "", "");
        return;
      }
      a(15, 0);
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
    return ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a.c();
  }
  
  public boolean a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfAjfz.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfAjfz[paramInt];
      }
    }
    return (localObject1 != null) && (((ajfz)localObject1).a());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().b() <= 0) {
        break label34;
      }
      a(37, 2);
    }
    label34:
    int m;
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.c()) {
        break;
      }
      m = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().e();
      if (m == 3)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().b() > 0L)
        {
          a(37, 2);
          return;
        }
        a(37, 0);
        return;
      }
      if (m == 1)
      {
        a(37, 2);
        return;
      }
    } while (m != 2);
    a(37, 2);
    return;
    a(37, 0);
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    a(10, 0);
    c(paramQQAppInterface);
    m();
    d(paramQQAppInterface);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ajir != null) {
      this.jdField_a_of_type_Ajir.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    ajir localajir = ajir.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this);
    if (localajir == null) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_Ajir == null) || (!this.jdField_a_of_type_Ajir.getClass().isInstance(localajir)) || (!localajir.getClass().isInstance(this.jdField_a_of_type_Ajir)))
      {
        this.jdField_a_of_type_Ajir = localajir;
        h();
      }
    } while (this.jdField_a_of_type_Ajir == null);
    boolean bool = this.jdField_a_of_type_Ajir.a();
    QLog.i("QBoss.ADBanner.Manager", 1, "isNeedShowQBossADBanner: " + bool);
    return bool;
  }
  
  public boolean b(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfAjfz.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfAjfz[paramInt];
      }
    }
    return (localObject1 != null) && (((ajfz)localObject1).jdField_a_of_type_Boolean);
  }
  
  public void c()
  {
    if (a(11))
    {
      a(11, 0);
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_b_of_type_Int = -1;
      this.jdField_d_of_type_JavaLangString = null;
      this.jdField_b_of_type_Long = 0L;
      a(-1, null);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAjfz[21];
    if ((localObject1 == null) || (((ajfz)localObject1).jdField_a_of_type_AndroidViewView == null)) {}
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
          } while (!((ajfz)localObject1).jdField_a_of_type_Boolean);
          localObject1 = ((ajfz)localObject1).jdField_a_of_type_AndroidViewView;
        } while (localObject1 == null);
        localObject1 = ((View)localObject1).findViewById(2131372509);
        localLayoutParams = ((View)localObject1).getLayoutParams();
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, "fight.setPushBannerHeight.lp.height1 = " + localLayoutParams.height);
        }
        if (!paramBoolean) {
          break;
        }
      } while ((localLayoutParams.height == this.jdField_c_of_type_Int) && (((View)localObject1).findViewById(2131364327).getVisibility() == 0) && (((View)localObject1).getAlpha() == 1.0F));
      ((View)localObject1).findViewById(2131364327).setVisibility(0);
      ((View)localObject1).setAlpha(1.0F);
      localLayoutParams.height = this.jdField_c_of_type_Int;
      ((View)localObject1).requestLayout();
      localObject1 = a(21, 2131362155);
      if ((localObject1 != null) && ((localObject1 instanceof String))) {}
      for (;;)
      {
        try
        {
          m = Integer.parseInt((String)localObject1);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X80087C2", "0X80087C2", m, 0, "3", "", "", "");
          return;
        }
        catch (Throwable localThrowable1)
        {
          localThrowable1.printStackTrace();
        }
        m = 0;
      }
    } while (localLayoutParams.height == 0);
    localThrowable1.findViewById(2131364327).setVisibility(4);
    localThrowable1.setAlpha(0.0F);
    localLayoutParams.height = 0;
    localThrowable1.requestLayout();
    Object localObject2 = a(21, 2131362155);
    if ((localObject2 != null) && ((localObject2 instanceof String))) {}
    for (;;)
    {
      try
      {
        m = Integer.parseInt((String)localObject2);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X80094CD", "0X80094CD", m, 0, "", "", "", "");
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
    boolean bool1 = true;
    boolean bool2 = e();
    if ((this.jdField_e_of_type_Boolean) && (!bool2)) {}
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent.banner", 4, "isNeedShowPushBanner, isNeedShow = " + bool1);
      }
      return bool1;
      if (f())
      {
        if (this.jdField_a_of_type_ArrayOfAjfz[21] == null) {
          this.jdField_a_of_type_ArrayOfAjfz[21] = new ajfz(21, 0);
        }
        a(this.jdField_a_of_type_ArrayOfAjfz[21]);
        View localView = this.jdField_a_of_type_ArrayOfAjfz[21].jdField_a_of_type_AndroidViewView;
        if (localView != null) {}
        for (bool1 = a(localView);; bool1 = false)
        {
          if (bool1)
          {
            localView.findViewById(2131372509).setVisibility(0);
            this.jdField_e_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).edit().putBoolean("reveive_newpb" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), false).commit();
          }
          break;
        }
      }
      bool1 = false;
    }
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAjfz[21];
    ViewGroup localViewGroup;
    int n;
    int m;
    if ((localObject != null) && (((ajfz)localObject).jdField_a_of_type_AndroidViewView != null))
    {
      localObject = (ADView)((ajfz)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131362155);
      localViewGroup = ((ADView)localObject).a(0);
      if (localViewGroup != null)
      {
        n = localViewGroup.getChildCount();
        m = 0;
        n -= 1;
        if (n >= 0)
        {
          View localView = localViewGroup.getChildAt(n);
          azum localazum = (azum)localView.getTag();
          String str = localazum.jdField_c_of_type_JavaLangString;
          int i1 = str.indexOf("|");
          if (bdao.a(Long.parseLong(str.substring(0, i1)), Long.parseLong(str.substring(i1 + 1)))) {
            break label296;
          }
          ((ADView)localObject).a(0, n, localView);
          aokb.a.b(localazum.l);
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
          a(21, 0);
          a(-1, null);
          this.jdField_e_of_type_Boolean = false;
        }
        for (;;)
        {
          localObject = new aokd(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), aozj.jdField_a_of_type_JavaLangString);
          if (localObject != null)
          {
            ((aokd)localObject).b();
            ((aokd)localObject).c();
          }
          return;
          l();
        }
      }
      l();
      return;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void e()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(101);
    a(41, 0);
    a(12, 0);
    a(14, 0);
    a(32, 0);
    a(33, 0);
    Object localObject = this.jdField_a_of_type_ArrayOfAjfz[21];
    if ((localObject != null) && (((ajfz)localObject).jdField_a_of_type_AndroidViewView != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((ajfz)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131362156);
      localObject = (ADView)((ajfz)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131362155);
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
    c();
    k();
    a(16, 0);
    this.h = true;
    this.i = false;
    this.jdField_e_of_type_JavaLangString = "";
    a(7, 0);
    a(17, 0);
    a(18, 0);
    a(23, 0);
    a(6, 0);
    a(20, 0);
    if (this.jdField_a_of_type_Ajir != null) {
      this.jdField_a_of_type_Ajir.g();
    }
    a(28, 0);
    a(31, 0);
    b();
    j();
    a(-1, null);
    a(false);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void f()
  {
    a(20, 0);
    a(-1, null);
    if (this.jdField_a_of_type_Ajir != null) {
      this.jdField_a_of_type_Ajir.f();
    }
  }
  
  public void g()
  {
    QLog.i("Q.recent.banner", 1, "onResume");
    if (this.jdField_a_of_type_Ajir != null) {
      this.jdField_a_of_type_Ajir.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter.b();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ArrayOfAjfz != null)
    {
      ajfz localajfz = this.jdField_a_of_type_ArrayOfAjfz[20];
      if ((localajfz != null) && (localajfz.jdField_a_of_type_AndroidViewView != null) && (localajfz.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(localajfz.jdField_a_of_type_AndroidViewView);
        localajfz.jdField_a_of_type_Boolean = false;
        localajfz.jdField_a_of_type_AndroidViewView = null;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 17, 0, "", "", "", "");
      continue;
      a(16, 0);
      this.jdField_e_of_type_JavaLangString = "";
      a(16, paramMessage);
      continue;
      a(17, 0);
      a(17, paramMessage);
      continue;
      a(4, 2);
      a(4, paramMessage);
      continue;
      a(4, 0);
      a(4, paramMessage);
      continue;
      a(24, 0);
      a(24, paramMessage);
      continue;
      a(25, 0);
      a(25, paramMessage);
      continue;
      a(23, 2);
      a(23, paramMessage);
      continue;
      a(23, 0);
      a(23, paramMessage);
      continue;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PushBanner", 2, "checkAndClosePushBanner");
        }
        d();
      }
      catch (Exception paramMessage) {}
      if (QLog.isColorLevel())
      {
        QLog.d("PushBanner", 2, "checkAndClosePushBanner Exception:", paramMessage);
        continue;
        a(true);
        continue;
        a(28, 0);
        a(28, paramMessage);
        continue;
        a(29, 0);
        a(29, paramMessage);
        continue;
        a(30, 0);
        a(30, paramMessage);
        continue;
        a(31, 0);
        a(31, paramMessage);
        continue;
        a(26, 0);
        a(26, paramMessage);
        continue;
        c(paramMessage);
        continue;
        b(paramMessage);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, "handler msg MSG_HIDE_WIFI_SECURITY_CHECK");
        }
        a(2, 0);
        a(2, paramMessage);
      }
    }
  }
  
  public void i()
  {
    int i2 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "checkIsShowTroopTip");
    }
    QQAppInterface localQQAppInterface;
    List localList;
    int m;
    label82:
    int n;
    label84:
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if ((localQQAppInterface != null) && ((auam.a().c(localQQAppInterface, this.jdField_e_of_type_JavaLangString)) || (this.i)))
      {
        localList = localQQAppInterface.a().a().a(false);
        if (localList != null) {
          break label135;
        }
        m = 0;
        n = 0;
        i1 = i2;
        if (n >= m) {
          break label153;
        }
        if (((RecentUser)localList.get(n)).getType() != 5000) {
          break label146;
        }
        if (this.i) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
        }
      }
    }
    label135:
    label146:
    label153:
    do
    {
      return;
      localQQAppInterface = null;
      break;
      m = localList.size();
      break label82;
      n += 1;
      break label84;
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
          } while ((TextUtils.isEmpty(localRecentUser.uin)) || (auam.a().b(localQQAppInterface, localRecentUser.uin)) || (auam.a().a(localQQAppInterface, localRecentUser.uin) != 1));
          if (localQQAppInterface.a().a(localRecentUser.uin, localRecentUser.getType()) > 99)
          {
            if ((this.i) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_e_of_type_JavaLangString.equals(localRecentUser.uin))) {
              break;
            }
            this.jdField_e_of_type_JavaLangString = localRecentUser.uin;
            if ((!this.h) || (!auam.a().c(localQQAppInterface, this.jdField_e_of_type_JavaLangString))) {
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
  
  public void j() {}
  
  public void k()
  {
    if (a(27))
    {
      a(27, 0);
      this.jdField_b_of_type_JavaLangString = null;
      a(-1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgb
 * JD-Core Version:    0.7.0.1
 */