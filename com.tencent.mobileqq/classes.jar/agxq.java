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
import com.tencent.mobileqq.widget.ADView;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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

public class agxq
  implements Handler.Callback
{
  public static final boolean a;
  public float a;
  public int a;
  public long a;
  private volatile agzn jdField_a_of_type_Agzn;
  private ahag jdField_a_of_type_Ahag;
  private SparseArray<ArrayList<Integer>> jdField_a_of_type_AndroidUtilSparseArray;
  private aroi jdField_a_of_type_Aroi;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private GameNoticeCenter jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new babk(this);
  private agxo[] jdField_a_of_type_ArrayOfAgxo = new agxo[41];
  public int b;
  public long b;
  private volatile agzn jdField_b_of_type_Agzn;
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
  
  public agxq(BaseActivity paramBaseActivity, XListView paramXListView)
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    if (this.jdField_c_of_type_Int == 0) {
      this.jdField_c_of_type_Int = aciy.a(50.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
    }
  }
  
  private View A()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131496987, null);
    TextView localTextView = (TextView)localView.findViewById(2131312841);
    localTextView.setOnClickListener(new agyt(this));
    localTextView.setText("");
    if (AppSetting.jdField_c_of_type_Boolean) {
      localTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131654772));
    }
    ((ImageView)localView.findViewById(2131298709)).setOnClickListener(new agyu(this));
    localView.findViewById(2131312840).setVisibility(8);
    return localView;
  }
  
  private View B()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131493745, null);
    localView.setOnClickListener(new agyv(this));
    localView.findViewById(2131304874).setVisibility(8);
    return localView;
  }
  
  private View C()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839177));
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131653508));
    localTipsBar.setOnClickListener(new agyw(this));
    awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 18, 0, "", "", "", "");
    return localTipsBar;
  }
  
  private View D()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131493892, null);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    localView.findViewById(2131306467).setVisibility(8);
    ((LinearLayout)localView.findViewById(2131298701)).setOnClickListener(new agyx(this));
    return localView;
  }
  
  private View E()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130844108));
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131632968));
    localTipsBar.setOnClickListener(new agyy(this));
    return localTipsBar;
  }
  
  private View F()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131495862, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131307685);
    localView.setOnClickListener(new agyz(this));
    localImageView.setOnClickListener(new agzb(this));
    return localView;
  }
  
  private View G()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.b(true);
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View H()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initWiFiSecurityBanner");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(4);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838094));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View I()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845899));
    localTipsBar.a(true);
    localTipsBar.setOnClickListener(new agze(this));
    return localTipsBar;
  }
  
  @Nullable
  public static agzn a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, agzl paramagzl)
  {
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null)
    {
      paramString1 = new agzn(1, paramString1, paramInt, paramString2, paramagzl);
      paramString2 = paramQQAppInterface.obtainMessage(1134200);
      paramString2.obj = paramString1;
      paramQQAppInterface.sendMessage(paramString2);
      return paramString1;
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    int m = 27;
    if (m <= 34)
    {
      if (this.jdField_a_of_type_ArrayOfAgxo[m] == null) {}
      for (;;)
      {
        m += 1;
        break;
        if (this.jdField_a_of_type_ArrayOfAgxo[m].jdField_b_of_type_Int == 2) {
          if (m != paramInt)
          {
            b(m, paramInt);
            this.jdField_a_of_type_ArrayOfAgxo[m].jdField_b_of_type_Int = 0;
          }
          else if ((m == 34) && (this.jdField_a_of_type_Agzn != null) && (!this.jdField_b_of_type_Agzn.equals(this.jdField_a_of_type_Agzn)))
          {
            b(m, paramInt);
          }
        }
      }
    }
  }
  
  private void a(agxo paramagxo)
  {
    if ((paramagxo == null) || (paramagxo.jdField_a_of_type_AndroidViewView != null)) {
      return;
    }
    for (;;)
    {
      try
      {
        int m = paramagxo.jdField_a_of_type_Int;
        switch (m)
        {
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = n();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = a();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = p();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = m();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = k();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = j();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = l();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = o();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = r();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = q();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = q();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = A();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = s();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = D();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = c();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = C();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = F();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = t();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = u();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = v();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = w();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = y();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = x();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = z();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = B();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = E();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = g();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = h();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = i();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = f();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = e();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = d();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = G();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = H();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = I();
        continue;
        paramagxo.jdField_a_of_type_AndroidViewView = b();
        continue;
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("Q.recent.banner", 4, "initBannerView | banner = " + paramagxo);
      return;
      paramagxo.jdField_a_of_type_AndroidViewView = l();
    }
  }
  
  private void a(agxo paramagxo, Message paramMessage)
  {
    boolean bool = false;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateBanner| banner = ").append(paramagxo).append(", msg = ").append(paramMessage).append(" isGeneral? ");
      if (paramagxo.jdField_a_of_type_Int == 34) {
        bool = true;
      }
      QLog.d("Q.recent.banner", 4, Boolean.toString(bool));
    }
    if ((paramagxo == null) || (paramagxo.jdField_a_of_type_AndroidViewView == null)) {
      label83:
      return;
    }
    for (;;)
    {
      try
      {
        switch (paramagxo.jdField_a_of_type_Int)
        {
        case 5: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 39: 
          if (!(paramagxo.jdField_a_of_type_AndroidViewView instanceof TipsBar)) {
            break label83;
          }
          a((TipsBar)paramagxo.jdField_a_of_type_AndroidViewView);
          return;
        }
      }
      catch (Throwable paramagxo)
      {
        paramagxo.printStackTrace();
        return;
      }
      b(paramagxo.jdField_a_of_type_AndroidViewView);
      continue;
      k(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      g(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      j(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      f(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      a(paramagxo.jdField_a_of_type_AndroidViewView);
      continue;
      l(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      c(paramagxo.jdField_a_of_type_AndroidViewView);
      continue;
      paramagxo.jdField_a_of_type_AndroidViewView.findViewById(2131312840).setVisibility(0);
      continue;
      paramagxo.jdField_a_of_type_AndroidViewView.findViewById(2131312840).setVisibility(0);
      continue;
      t(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      d(paramagxo.jdField_a_of_type_AndroidViewView);
      continue;
      n(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      o(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      p(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      r(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      q(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      s(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      u(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      e(paramagxo.jdField_a_of_type_AndroidViewView);
      continue;
      a(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      b(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage, paramagxo.jdField_b_of_type_Int);
      continue;
      a(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage, paramagxo.jdField_b_of_type_Int);
      continue;
      f(paramagxo.jdField_a_of_type_AndroidViewView);
      continue;
      d(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      e(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      i(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      c(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      b(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      m(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      w(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      v(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      g(paramagxo.jdField_a_of_type_AndroidViewView);
      continue;
      h(paramagxo.jdField_a_of_type_AndroidViewView, paramMessage);
    }
  }
  
  private void a(agzn paramagzn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "hideGeneralBannerInBInternal with: " + paramagzn);
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(201);
    localMessage.obj = paramagzn;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  private void a(View paramView)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    paramView.setVisibility(0);
    ((TipsBar)paramView).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625484));
  }
  
  private void a(View paramView, Message paramMessage)
  {
    if (paramMessage != null)
    {
      if (this.jdField_a_of_type_Ahag != null) {
        this.jdField_a_of_type_Ahag.c();
      }
      awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 11, 0, "", "", "", "");
    }
  }
  
  private void a(View paramView, Message paramMessage, int paramInt)
  {
    if ((paramMessage == null) || (paramMessage.obj == null) || (!(paramMessage.obj instanceof ajoe))) {
      return;
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8005B72", "0X8005B72", 0, 0, "", "", "", "");
    paramView.findViewById(2131307274).setVisibility(0);
    paramMessage = (ajoe)paramMessage.obj;
    ((TextView)paramView.findViewById(2131297509)).setText(paramMessage.jdField_b_of_type_JavaLangString);
    awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 5, 0, "", "", "", "");
    paramView.setOnClickListener(new agzf(this, paramMessage));
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
      pyk.a(paramQQAppInterface, paramIntent, localPendingIntent, str1, str2);
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
    paramIntent = new agzq(paramPendingIntent, paramQQAppInterface);
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
    paramIntent = new agzr(paramQQAppInterface, paramString3, str3, str1, str2, localIntent, paramQQAppInterface.c(), m);
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
      paramString3 = new agzs(paramString3, paramQQAppInterface, paramString4, paramInt2, paramBundle, paramBoolean);
      paramInt2 = paramInt1;
      if (paramInt1 < 0) {
        paramInt2 = agxp.a(str1);
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
  
  private void a(TipsBar paramTipsBar)
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
      paramTipsBar.a();
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
    paramString1 = new agzk(paramString1, paramQQAppInterface);
    paramString1.a(a(paramQQAppInterface, m, paramString2, paramString3, paramString1));
  }
  
  private boolean a(alzf paramalzf, int paramInt, View paramView)
  {
    awuf localawuf = new awuf(paramalzf.a(0, paramInt), paramalzf.b(0, paramInt), paramalzf.a(0, paramInt));
    localawuf.l = paramalzf.a(0, paramInt);
    localawuf.m = paramalzf.c(0, paramInt);
    boolean bool = localawuf.a(paramalzf.a(0, paramInt));
    if ((localawuf.jdField_c_of_type_JavaLangString != null) && (localawuf.jdField_c_of_type_JavaLangString.contains("|")) && (!azvt.a(Long.parseLong(localawuf.jdField_c_of_type_JavaLangString.substring(0, localawuf.jdField_c_of_type_JavaLangString.indexOf("|"))), Long.parseLong(localawuf.jdField_c_of_type_JavaLangString.substring(localawuf.jdField_c_of_type_JavaLangString.indexOf("|") + 1))))) {}
    label470:
    for (;;)
    {
      return false;
      if ((bool) && (!"".equals(localawuf.j)))
      {
        localawuf.jdField_a_of_type_Bacn = bade.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localawuf.j);
        if (localawuf.jdField_a_of_type_Bacn == null) {}
        for (int m = 0;; m = 1)
        {
          if (m == 0) {
            break label470;
          }
          Object localObject = paramalzf.a(0, paramInt);
          if (QLog.isDevelopLevel()) {
            QLog.i("PUSH BANNER", 4, "addPushBanner, bannerPic = " + localObject);
          }
          if (localObject == null) {
            break;
          }
          paramalzf = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131493893, null);
          ImageView localImageView = (ImageView)paramalzf.findViewById(2131296420);
          localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          localImageView.setImageBitmap((Bitmap)localObject);
          DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
          m = ((Bitmap)localObject).getHeight() * Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) / ((Bitmap)localObject).getWidth();
          localLayoutParams.height = Math.max((int)(30.0F * localDisplayMetrics.density), Math.min(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) * 68 / 320, m));
          localImageView.setLayoutParams(localLayoutParams);
          localObject = (ImageView)paramalzf.findViewById(2131306470);
          ((ImageView)localObject).setTag(localawuf);
          ((ImageView)localObject).setContentDescription(ajjy.a(2131635134));
          ((ImageView)localObject).setOnClickListener(new agzc(this));
          paramalzf.setTag(localawuf);
          ((ADView)paramView.findViewById(2131296607)).a(paramalzf, paramInt);
          paramView.setTag(2131296607, localawuf.jdField_a_of_type_JavaLangString);
          return true;
        }
      }
    }
  }
  
  private boolean a(View paramView)
  {
    alzf localalzf = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin(), false);
    if (localalzf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushBannerConfig", 2, "loadPushBanner");
      }
      o();
      return false;
    }
    int i2 = localalzf.a(0);
    if (i2 > 0)
    {
      ((ADView)paramView.findViewById(2131296607)).h();
      int m = 0;
      int i1;
      for (int n = 0; m < i2; n = i1)
      {
        i1 = n;
        if (a(localalzf, m, paramView)) {
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
  
  public static boolean a(QQAppInterface paramQQAppInterface, agzn paramagzn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "hideGeneralBannerInB with: " + paramagzn);
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null)
    {
      Message localMessage = paramQQAppInterface.obtainMessage(1134201);
      localMessage.obj = paramagzn;
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
    if ((paramInt1 == 34) && (this.jdField_a_of_type_Agzn != null)) {
      this.jdField_a_of_type_Agzn.jdField_a_of_type_Agzl.onOverride();
    }
    do
    {
      do
      {
        return;
      } while (paramInt1 != 32);
      localObject = aipq.a();
    } while (localObject == null);
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if (localQQAppInterface == null) {
        break label177;
      }
      if (((aipq)localObject).a != null) {
        break label146;
      }
    }
    label146:
    for (Object localObject = "-1";; localObject = ((aipq)localObject).a.gameId + "")
    {
      bajr.a(localQQAppInterface, "cmshow", "Apollo", "mutex_bar", 0, 0, new String[] { localObject });
      return;
      localQQAppInterface = null;
      break;
    }
    label177:
    QLog.e("Q.recent.banner", 1, "[notifyBannerStateChange] app null");
  }
  
  private void b(agzn paramagzn)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(201);
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(201);
    localMessage.obj = paramagzn;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 900000L);
  }
  
  private void b(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "hideGeneralBanner: " + paramMessage);
    }
    if (!(paramMessage.obj instanceof agzn)) {}
    do
    {
      return;
      int m = ((agzn)paramMessage.obj).jdField_a_of_type_Int;
    } while (!paramMessage.obj.equals(this.jdField_a_of_type_Agzn));
    a(34, 0);
    a(34, paramMessage);
  }
  
  private void b(View paramView)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    paramView.setVisibility(0);
    ((TipsBar)paramView).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131628952));
    if (a(11))
    {
      a(11, 0);
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_b_of_type_Int = -1;
      this.jdField_d_of_type_JavaLangString = null;
    }
    awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 1, 0, "", "", "", "");
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
    paramMessage = (aufl)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(38);
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
        paramView.findViewById(2131307272).setVisibility(0);
        ((TextView)paramView.findViewById(2131307273)).setText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131632934), new Object[] { Integer.valueOf(m) }));
      } while (m > 0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(7);
      return;
    }
  }
  
  private View c()
  {
    if (this.jdField_a_of_type_Ahag != null) {
      return this.jdField_a_of_type_Ahag.a();
    }
    return null;
  }
  
  private void c(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof agzn)) {
      return;
    }
    int m = ((agzn)paramMessage.obj).jdField_a_of_type_Int;
    this.jdField_b_of_type_Agzn = ((agzn)paramMessage.obj);
    a(34, 2);
    this.jdField_a_of_type_Agzn = this.jdField_b_of_type_Agzn;
    a(34, paramMessage);
    b((agzn)paramMessage.obj);
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
      localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625076));
      return;
    }
    if ((vvn.b(this.jdField_b_of_type_Int)) && (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {
      this.jdField_d_of_type_JavaLangString = "手表QQ已登录";
    }
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      localTipsBar.setTipsText(this.jdField_d_of_type_JavaLangString);
      if (this.jdField_b_of_type_Int != 5) {
        break label215;
      }
      localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838748));
      label126:
      if (this.jdField_b_of_type_Int != 4) {
        break label265;
      }
    }
    label265:
    for (int m = 23;; m = 10)
    {
      awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", m, 0, "", "", "", "");
      return;
      paramView = "QQ";
      if (this.jdField_b_of_type_Long == 77313L) {
        paramView = "TIM";
      }
      localTipsBar.setTipsText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131629298), new Object[] { paramView }));
      break;
      label215:
      if (vvn.b(this.jdField_b_of_type_Int))
      {
        localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838750));
        break label126;
      }
      localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838749));
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
      paramView.setOnClickListener(new agye(this));
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface)
  {
    a(15, 0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    if ((this.jdField_a_of_type_Aroi != null) && (paramQQAppInterface != null))
    {
      ((PhoneContactManagerImp)paramQQAppInterface.getManager(11)).b(this.jdField_a_of_type_Aroi);
      this.jdField_a_of_type_Aroi = null;
    }
  }
  
  private View d()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131633618));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838991));
    localTipsBar.setButtonText(ajjy.a(2131635130));
    localTipsBar.a().setBackgroundResource(0);
    localTipsBar.a().setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131101268));
    localTipsBar.setOriginalOnClickListener(new agzi(this));
    localTipsBar.setOnClickListener(new agzj(this));
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
        String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131629524);
        ((TipsBar)paramView).setTipsText(Html.fromHtml(str + " " + localSongInfo.jdField_b_of_type_JavaLangString));
      }
      awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EE0", "0X8009EE0", 1, 0, "", "", "", "");
      return;
    }
    paramView.setVisibility(8);
    a(35, 0);
    a(-1, null);
  }
  
  private void d(View paramView, Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {}
    for (;;)
    {
      return;
      paramView.setVisibility(0);
      ((TipsBar)paramView).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625752));
      a((TipsBar)paramView);
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {}
      for (QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app; (localQQAppInterface != null) && (paramMessage != null) && (paramMessage.obj != null); localQQAppInterface = null)
      {
        paramMessage = (String)paramMessage.obj;
        awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 16, 0, "", "", "", "");
        paramView.setOnClickListener(new agyp(this, paramMessage));
        return;
      }
    }
  }
  
  private void d(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "handleAccountChanged with: " + this.jdField_a_of_type_Agzn);
    }
    if ((this.jdField_a_of_type_Agzn != null) && (this.jdField_a_of_type_Agzn.jdField_a_of_type_Agzl.isNeedAutoCloseWhenAccountChange())) {
      a(this.jdField_a_of_type_Agzn);
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
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130849233));
    localTipsBar.b(true);
    UpgradeTIMWrapper localUpgradeTIMWrapper = UpgradeTIMWrapper.a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
    localTipsBar.setTipsText(localUpgradeTIMWrapper.f);
    localTipsBar.setOnClickListener(new agxs(this, localUpgradeTIMWrapper));
    localTipsBar.setCloseListener(new agxt(this, localUpgradeTIMWrapper));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void e(View paramView)
  {
    paramView.findViewById(2131306467).setVisibility(0);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131296608);
    paramView = (ADView)paramView.findViewById(2131296607);
    if (d())
    {
      localRelativeLayout.setPadding(0, 0, 0, 0);
      paramView.i();
    }
    for (;;)
    {
      awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 12, 0, "", "", "", "");
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
    awqx.b(null, "CliOper", "", "", "theme", "0X8007232", 0, 0, String.valueOf(m), "", "", "");
    awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 15, 0, "", "", "", "");
    paramView.setOnClickListener(new agza(this, n, (String)localObject, m));
  }
  
  private boolean e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).getBoolean("reveive_newpb" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), false);
  }
  
  private View f()
  {
    return alfo.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  private void f(View paramView)
  {
    paramView.findViewById(2131307684).setVisibility(0);
    ((TextView)paramView.findViewById(2131307686)).setText(ajjy.a(2131635122));
  }
  
  private void f(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null))
    {
      if (aosu.a().a())
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131629524);
        String str = aosu.a().a();
        if (str != null)
        {
          ((TipsBar)paramView).setTipsText(paramMessage + "" + str);
          paramView.setVisibility(0);
          awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EE1", "0X8009EE1", 2, 0, "", "", "", "");
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
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625752));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838094));
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
    vvk localvvk = (vvk)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(335);
    String str = localvvk.a();
    if (TextUtils.isEmpty(str))
    {
      k();
      return;
    }
    paramView.setTipsText(str);
    int m = localvvk.a();
    if (m == 1)
    {
      paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845901));
      return;
    }
    if (m == 2)
    {
      paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845900));
      return;
    }
    if (m == 3)
    {
      paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845902));
      return;
    }
    paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845899));
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
      paramView.setOnClickListener(new agzg(this, paramMessage));
      awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004028", "0X8004028", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private View h()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130849221));
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
    paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839066));
    a(paramView);
    paramView.setTipsText(str);
    paramView.setOnClickListener(new agzh(this, m));
    paramView.setVisibility(0);
  }
  
  private View i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.", 2, " initApolloGameBanner");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838340));
    localTipsBar.setTipsText(ajjy.a(2131635128));
    localTipsBar.setVisibility(8);
    localTipsBar.b(true);
    localTipsBar.setOnClickListener(new agxu(this));
    localTipsBar.setCloseListener(new agxv(this));
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
    awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 10, 0, "", "", "", "");
  }
  
  private View j()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130840858));
    localTipsBar.setOnClickListener(new agxy(this, localTipsBar));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void j(View paramView, Message paramMessage)
  {
    View localView = paramView.findViewById(2131307144);
    paramMessage = (TextView)paramView.findViewById(2131307145);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null))
    {
      int m = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a();
      if (m != 0)
      {
        localView.setVisibility(0);
        int n = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a().mMode;
        paramView = ajjy.a(2131635126);
        if (1 == n) {
          paramView = ajjy.a(2131635136);
        }
        for (;;)
        {
          paramMessage.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131632691) + paramView + String.valueOf(m) + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131632692));
          awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EE1", "0X8009EE1", 3, 0, "", "", "", "");
          return;
          if (2 == n) {
            paramView = ajjy.a(2131635125);
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
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131495004, null);
    localView.setOnClickListener(new agxz(this));
    localView.findViewById(2131307144).setVisibility(8);
    return localView;
  }
  
  private void k(View paramView, Message paramMessage)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131313626);
    if (paramMessage != null)
    {
      if (paramMessage.arg1 != 1) {
        break label42;
      }
      localTextView.setText(2131654999);
    }
    for (;;)
    {
      paramView.findViewById(2131313625).setVisibility(0);
      return;
      label42:
      if (paramMessage.arg1 == 2) {
        localTextView.setText(2131654997);
      }
    }
  }
  
  private View l()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 4);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131628952));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838094));
    localTipsBar.setOnClickListener(new agya(this));
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
      if ((paramMessage.obj instanceof auql))
      {
        paramMessage = (auql)paramMessage.obj;
        localObject2 = paramMessage.jdField_b_of_type_JavaLangString;
        localObject1 = (TextView)paramView.findViewById(2131309369);
        ((TextView)localObject1).setText((CharSequence)localObject2);
        if ((paramMessage.jdField_e_of_type_JavaLangString != null) && (!TextUtils.isEmpty(paramMessage.jdField_e_of_type_JavaLangString)))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getApp().getResources().getDrawable(2130846323);
          localObject2 = URLDrawable.getDrawable(paramMessage.jdField_e_of_type_JavaLangString, (Drawable)localObject2, (Drawable)localObject2);
          if (localObject2 != null)
          {
            ((Drawable)localObject2).setBounds(0, 0, azvv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 22.0F), azvv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 22.0F));
            ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
          }
        }
        localObject1 = (Button)paramView.findViewById(2131309368);
        if ((paramMessage.f != null) && (!TextUtils.isEmpty(paramMessage.f))) {
          ((Button)localObject1).setText(paramMessage.f);
        }
        localObject2 = paramMessage.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
        localauqh = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36);
        if ((paramMessage.jdField_a_of_type_JavaLangString != null) && (localObject2 != null) && (localauqh != null))
        {
          ((Button)localObject1).setOnClickListener(new agyc(this, localauqh, paramMessage, (BusinessInfoCheckUpdate.AppInfo)localObject2));
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
      auqh localauqh;
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(9);
  }
  
  private View m()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 4);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131628947));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838094));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void m()
  {
    a(32, 0);
    a(32, null);
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
        awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 2, 0, "", "", "", "");
        return;
      }
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(8);
  }
  
  private View n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initMissedCallBar");
    }
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131495087, null);
    ((TextView)localView.findViewById(2131307273)).setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131632934));
    localView.findViewById(2131307272).setVisibility(8);
    return localView;
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
        agxo localagxo = this.jdField_a_of_type_ArrayOfAgxo[n];
        if ((localagxo != null) && (localagxo.jdField_a_of_type_AndroidViewView != null) && (localagxo.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(localagxo.jdField_a_of_type_AndroidViewView);
          localagxo.jdField_a_of_type_Boolean = false;
          if (!localagxo.a()) {
            localagxo.jdField_a_of_type_AndroidViewView = null;
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
        ((TipsBar)paramView).setTipsText(Html.fromHtml((String)paramMessage.second + ajjy.a(2131635127)));
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
        a(33, 0);
      }
    }
    for (;;)
    {
      a(-1, null);
      return;
      paramView.setVisibility(8);
      a(33, 0);
    }
  }
  
  private View o()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131496050, null);
    localView.setVisibility(8);
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
    ((TipsBar)paramView).setTipsText(ajjy.a(2131635133) + str1 + "》");
    paramView.setOnClickListener(new agyl(this, l, str2));
    ((TipsBar)paramView).setCloseListener(new agzm(13, this.jdField_a_of_type_MqqOsMqqHandler));
    paramView.setVisibility(0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(13);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(13, 900000L);
    awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 1, 0, "", "", "", "");
  }
  
  private View p()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131494941, null);
    localView.findViewById(2131313626).setOnClickListener(new agyb(this));
    localView.findViewById(2131313625).setVisibility(8);
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
        int m = ((JSONObject)paramMessage.obj).optInt("actid");
        if (localLong.longValue() == 1L)
        {
          ((TipsBar)paramView).setTipsText(ajjy.a(2131635132));
          localObject1 = (String)localObject1 + "&ADTAG=aio.run.click";
        }
        for (;;)
        {
          paramView.setOnClickListener(new agym(this, (String)localObject1, localLong, m));
          if (localLong.longValue() == 3L)
          {
            localObject1 = new LpReportInfo_dc00307(LpReportInfo_dc00307.ACTION_TYPE_RED_PACK, LpReportInfo_dc00307.SUB_ACTION_TYPE_RED_PACK_EXPOSURE, m);
            LpReportManager.getInstance().reportToDC00307((LpReportInfo_dc00307)localObject1, false, true);
          }
          if ((paramView instanceof TipsBar)) {
            ((TipsBar)paramView).setCloseListener(new agzm(1134044, ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime()).getHandler(Conversation.class)));
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            paramView = new Bundle();
            paramMessage.obj = paramView;
            paramMessage = Message.obtain(paramMessage);
            bbzz.a().a((String)localObject2, new agyn(this, paramView, paramMessage));
          }
          awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 9, 0, "", "", "", "");
          return;
          if (localLong.longValue() == 2L)
          {
            ((TipsBar)paramView).setTipsText(ajjy.a(2131635124));
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
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131496988, null);
    TextView localTextView = (TextView)localView.findViewById(2131312841);
    localTextView.setOnClickListener(new agyd(this));
    localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131654771));
    ((ImageView)localView.findViewById(2131298727)).setOnClickListener(new agyf(this));
    localView.findViewById(2131312840).setVisibility(8);
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
        localTextView = (TextView)paramView.findViewById(2131296839);
      } while ((!(paramMessage.obj instanceof Bundle)) || (localTextView == null));
      paramMessage = (Bundle)paramMessage.obj;
      str = (String)paramMessage.getCharSequence("tips");
      int m = paramMessage.getInt("icon");
      if (m != -1) {
        ((ImageView)paramView.findViewById(2131296838)).setImageResource(m);
      }
    } while (TextUtils.isEmpty(str));
    localTextView.setText(str);
    paramView.setOnClickListener(new agyo(this, paramMessage));
    paramView.findViewById(2131296836).setVisibility(0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(15);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(15, paramMessage.getInt("timeout", 120000));
  }
  
  private View r()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838749));
    localTipsBar.b(true);
    localTipsBar.setCloseListener(new agyg(this));
    localTipsBar.setOnClickListener(new agyh(this));
    return localTipsBar;
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
        localTextView = (TextView)paramView.findViewById(2131296845);
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
        localTextView.setText(ajjy.a(2131635120) + paramMessage + "》");
      }
      for (;;)
      {
        paramView.setOnClickListener(new agyq(this, str));
        paramView.findViewById(2131296863).setVisibility(0);
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(14);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(14, 900000L);
        awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 2, 0, "", "", "", "");
        return;
        m = ((DisplayMetrics)localObject).widthPixels;
        break;
        localTextView.setText(ajjy.a(2131635131) + paramMessage + "》");
      }
    }
  }
  
  private View s()
  {
    View localView1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131493312, null);
    View localView2 = localView1.findViewById(2131299198);
    localView1.setOnClickListener(new agyi(this));
    localView2.setVisibility(8);
    return localView1;
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
          paramView.setOnClickListener(new agys(this, paramMessage));
          paramView.setCloseListener(new agzm(30, this.jdField_a_of_type_MqqOsMqqHandler));
          a(paramView);
          paramView.setVisibility(0);
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(30);
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(30, paramMessage.getInt("timeout", 900000));
          awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 4, 0, "", "", "", "");
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
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130840858));
    localTipsBar.setOnClickListener(new agyj(this));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void t(View paramView, Message paramMessage)
  {
    paramView.findViewById(2131312840).setVisibility(0);
    paramView = (TextView)paramView.findViewById(2131312841);
    if (paramMessage != null)
    {
      if (ajgd.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) {
        break label91;
      }
      paramMessage = akgo.a().a();
      if ((paramMessage != null) && (paramMessage.a != null) && (paramMessage.a.dialog != null)) {
        paramView.setText(paramMessage.a.dialog.h);
      }
    }
    else
    {
      return;
    }
    paramView.setText(ajjy.a(2131635121));
    return;
    label91:
    paramMessage = akgo.a().a();
    if ((paramMessage != null) && (paramMessage.a != null) && (paramMessage.a.dialog != null))
    {
      paramView.setText(paramMessage.a.dialog.g);
      return;
    }
    paramView.setText(ajjy.a(2131635129));
  }
  
  private View u()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130840857));
    localTipsBar.b(true);
    localTipsBar.setOnClickListener(new agyk(this));
    localTipsBar.setCloseListener(new agzm(1134060, ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime()).getHandler(Conversation.class)));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void u(View paramView, Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
      mbd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, paramView, paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
    }
  }
  
  private View v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReaderBar", 2, "initReaderBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.b(true);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838172));
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
    paramView.setOnClickListener(new agzd(this, paramMessage));
    paramView.setVisibility(0);
    awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 6, 0, "", "", "", "");
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(202);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(202, 7000L);
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext();
    if (paramMessage.tipsType == 2) {}
    for (int m = 398680;; m = 398678)
    {
      bbrm.b(paramView, m);
      return;
    }
  }
  
  private View w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RunningBar", 2, "initRunningBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsText(ajjy.a(2131635135));
    localTipsBar.b(true);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838173));
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
    paramMessage = (agzn)paramMessage.obj;
    paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(agxp.a(paramMessage.jdField_b_of_type_Int)));
    paramView.setTipsText(paramMessage.jdField_b_of_type_JavaLangString);
    paramView.setOnClickListener(new agzp(paramMessage, this.jdField_a_of_type_MqqOsMqqHandler));
    paramView.setCloseListener(new agzo(paramMessage, this.jdField_a_of_type_MqqOsMqqHandler));
    paramView.setVisibility(0);
    awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 1, 0, "", "", "", "");
  }
  
  private View x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BrowserBar", 2, "initBrowserBar");
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131493031, null);
    localView.findViewById(2131296836).setVisibility(8);
    return localView;
  }
  
  private View y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComicBar", 2, "initComicBar");
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131493033, null);
    localView.findViewById(2131296863).setVisibility(8);
    return localView;
  }
  
  private View z()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameBar", 2, "initGameBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838165));
    localTipsBar.setVisibility(8);
    localTipsBar.b(true);
    return localTipsBar;
  }
  
  public int a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfAgxo.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfAgxo[paramInt];
      }
    }
    if (localObject1 == null) {
      return 0;
    }
    return ((agxo)localObject1).jdField_b_of_type_Int;
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
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131495088, null);
    localView.findViewById(2131307274).setVisibility(8);
    return localView;
  }
  
  public Object a(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_ArrayOfAgxo.length)) {}
    for (agxo localagxo = this.jdField_a_of_type_ArrayOfAgxo[paramInt1];; localagxo = null)
    {
      Object localObject1 = localObject2;
      if (localagxo != null)
      {
        localObject1 = localObject2;
        if (localagxo.jdField_a_of_type_AndroidViewView != null)
        {
          if (paramInt2 != 0) {
            break label58;
          }
          localObject1 = localagxo.jdField_a_of_type_AndroidViewView.getTag();
        }
      }
      return localObject1;
      label58:
      return localagxo.jdField_a_of_type_AndroidViewView.getTag(paramInt2);
    }
  }
  
  public MqqHandler a()
  {
    return this.jdField_a_of_type_MqqOsMqqHandler;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ahag != null) {
      this.jdField_a_of_type_Ahag.h();
    }
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface();
    if ((localAppInterface != null) && ((localAppInterface instanceof QQAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter = ((awcl)localAppInterface.getManager(12)).a();
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
    Object localObject1 = this.jdField_a_of_type_ArrayOfAgxo[20];
    if ((localObject1 == null) || (((agxo)localObject1).jdField_a_of_type_AndroidViewView == null))
    {
      break label67;
      break label67;
    }
    for (;;)
    {
      label67:
      return;
      if (!((agxo)localObject1).jdField_a_of_type_Boolean) {
        continue;
      }
      if (paramFloat > 0.0F)
      {
        c(true);
        return;
      }
      localObject1 = ((agxo)localObject1).jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break;
      }
      int m = (int)Math.abs(paramFloat);
      localObject1 = ((View)localObject1).findViewById(2131306467);
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
            localObject2 = a(20, 2131296607);
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
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X80094CD", "0X80094CD", n, 0, "", "", "", "");
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
        ((View)localObject1).findViewById(2131298701).setVisibility(4);
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
    if ((paramInt1 >= 1) && (paramInt1 <= 40))
    {
      if (this.jdField_a_of_type_ArrayOfAgxo[paramInt1] == null) {
        break label101;
      }
      this.jdField_a_of_type_ArrayOfAgxo[paramInt1].jdField_b_of_type_Int = paramInt2;
    }
    for (;;)
    {
      if ((paramInt1 >= 27) && (paramInt1 <= 34) && (paramInt2 == 2)) {
        a(paramInt1);
      }
      return;
      label101:
      if ((this.jdField_a_of_type_ArrayOfAgxo[paramInt1] == null) && (agxo.a(paramInt2))) {
        this.jdField_a_of_type_ArrayOfAgxo[paramInt1] = new agxo(paramInt1, paramInt2);
      }
    }
  }
  
  /* Error */
  public void a(int paramInt, Message paramMessage)
  {
    // Byte code:
    //   0: invokestatic 310	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 237
    //   8: iconst_4
    //   9: new 312	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1867
    //   19: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 605	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: ldc_w 1869
    //   29: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 326	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: getfield 1871	agxq:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   46: ifnonnull +16 -> 62
    //   49: aload_0
    //   50: new 1391	android/util/SparseArray
    //   53: dup
    //   54: bipush 6
    //   56: invokespecial 1873	android/util/SparseArray:<init>	(I)V
    //   59: putfield 1871	agxq:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   62: iconst_0
    //   63: istore_3
    //   64: iload_3
    //   65: bipush 6
    //   67: if_icmpge +56 -> 123
    //   70: aload_0
    //   71: getfield 1871	agxq:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   74: iload_3
    //   75: invokevirtual 1395	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   78: checkcast 1397	java/util/ArrayList
    //   81: astore 6
    //   83: aload 6
    //   85: ifnonnull +30 -> 115
    //   88: new 1397	java/util/ArrayList
    //   91: dup
    //   92: iconst_1
    //   93: invokespecial 1874	java/util/ArrayList:<init>	(I)V
    //   96: astore 6
    //   98: aload_0
    //   99: getfield 1871	agxq:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   102: iload_3
    //   103: aload 6
    //   105: invokevirtual 1877	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   108: iload_3
    //   109: iconst_1
    //   110: iadd
    //   111: istore_3
    //   112: goto -48 -> 64
    //   115: aload 6
    //   117: invokevirtual 1879	java/util/ArrayList:clear	()V
    //   120: goto -12 -> 108
    //   123: aload_0
    //   124: getfield 1389	agxq:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   127: ifnonnull +16 -> 143
    //   130: aload_0
    //   131: new 1391	android/util/SparseArray
    //   134: dup
    //   135: bipush 6
    //   137: invokespecial 1873	android/util/SparseArray:<init>	(I)V
    //   140: putfield 1389	agxq:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   143: iconst_1
    //   144: istore_3
    //   145: iload_3
    //   146: bipush 25
    //   148: if_icmpgt +54 -> 202
    //   151: aload_0
    //   152: getfield 66	agxq:jdField_a_of_type_ArrayOfAgxo	[Lagxo;
    //   155: iload_3
    //   156: aaload
    //   157: ifnull +172 -> 329
    //   160: aload_0
    //   161: getfield 66	agxq:jdField_a_of_type_ArrayOfAgxo	[Lagxo;
    //   164: iload_3
    //   165: aaload
    //   166: invokevirtual 1423	agxo:a	()Z
    //   169: ifeq +160 -> 329
    //   172: aload_0
    //   173: getfield 1871	agxq:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   176: iconst_0
    //   177: invokevirtual 1395	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   180: checkcast 1397	java/util/ArrayList
    //   183: astore 6
    //   185: aload_0
    //   186: getfield 1871	agxq:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   189: ifnull +13 -> 202
    //   192: aload 6
    //   194: iload_3
    //   195: invokestatic 981	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: invokevirtual 1881	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   201: pop
    //   202: bipush 26
    //   204: istore_3
    //   205: iload_3
    //   206: bipush 26
    //   208: if_icmpgt +54 -> 262
    //   211: aload_0
    //   212: getfield 66	agxq:jdField_a_of_type_ArrayOfAgxo	[Lagxo;
    //   215: iload_3
    //   216: aaload
    //   217: ifnull +119 -> 336
    //   220: aload_0
    //   221: getfield 66	agxq:jdField_a_of_type_ArrayOfAgxo	[Lagxo;
    //   224: iload_3
    //   225: aaload
    //   226: invokevirtual 1423	agxo:a	()Z
    //   229: ifeq +107 -> 336
    //   232: aload_0
    //   233: getfield 1871	agxq:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   236: iconst_1
    //   237: invokevirtual 1395	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   240: checkcast 1397	java/util/ArrayList
    //   243: astore 6
    //   245: aload_0
    //   246: getfield 1871	agxq:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   249: ifnull +13 -> 262
    //   252: aload 6
    //   254: iload_3
    //   255: invokestatic 981	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: invokevirtual 1881	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   261: pop
    //   262: bipush 27
    //   264: istore_3
    //   265: iload_3
    //   266: bipush 34
    //   268: if_icmpgt +75 -> 343
    //   271: aload_0
    //   272: getfield 66	agxq:jdField_a_of_type_ArrayOfAgxo	[Lagxo;
    //   275: iload_3
    //   276: aaload
    //   277: ifnull +45 -> 322
    //   280: aload_0
    //   281: getfield 66	agxq:jdField_a_of_type_ArrayOfAgxo	[Lagxo;
    //   284: iload_3
    //   285: aaload
    //   286: invokevirtual 1423	agxo:a	()Z
    //   289: ifeq +33 -> 322
    //   292: aload_0
    //   293: getfield 1871	agxq:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   296: iconst_2
    //   297: invokevirtual 1395	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   300: checkcast 1397	java/util/ArrayList
    //   303: astore 6
    //   305: aload_0
    //   306: getfield 1871	agxq:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   309: ifnull +13 -> 322
    //   312: aload 6
    //   314: iload_3
    //   315: invokestatic 981	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   318: invokevirtual 1881	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   343: bipush 35
    //   345: istore_3
    //   346: iload_3
    //   347: bipush 35
    //   349: if_icmpgt +52 -> 401
    //   352: aload_0
    //   353: getfield 66	agxq:jdField_a_of_type_ArrayOfAgxo	[Lagxo;
    //   356: iload_3
    //   357: aaload
    //   358: ifnull +238 -> 596
    //   361: aload_0
    //   362: getfield 66	agxq:jdField_a_of_type_ArrayOfAgxo	[Lagxo;
    //   365: iload_3
    //   366: aaload
    //   367: invokevirtual 1423	agxo:a	()Z
    //   370: ifeq +226 -> 596
    //   373: aload_0
    //   374: getfield 1871	agxq:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   377: iconst_3
    //   378: invokevirtual 1395	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   381: checkcast 1397	java/util/ArrayList
    //   384: astore 6
    //   386: aload 6
    //   388: ifnull +13 -> 401
    //   391: aload 6
    //   393: iload_3
    //   394: invokestatic 981	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   397: invokevirtual 1881	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   400: pop
    //   401: bipush 36
    //   403: istore_3
    //   404: iload_3
    //   405: bipush 38
    //   407: if_icmpgt +52 -> 459
    //   410: aload_0
    //   411: getfield 66	agxq:jdField_a_of_type_ArrayOfAgxo	[Lagxo;
    //   414: iload_3
    //   415: aaload
    //   416: ifnull +187 -> 603
    //   419: aload_0
    //   420: getfield 66	agxq:jdField_a_of_type_ArrayOfAgxo	[Lagxo;
    //   423: iload_3
    //   424: aaload
    //   425: invokevirtual 1423	agxo:a	()Z
    //   428: ifeq +175 -> 603
    //   431: aload_0
    //   432: getfield 1871	agxq:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   435: iconst_4
    //   436: invokevirtual 1395	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   439: checkcast 1397	java/util/ArrayList
    //   442: astore 6
    //   444: aload 6
    //   446: ifnull +13 -> 459
    //   449: aload 6
    //   451: iload_3
    //   452: invokestatic 981	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   455: invokevirtual 1881	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   458: pop
    //   459: bipush 39
    //   461: istore_3
    //   462: iload_3
    //   463: bipush 40
    //   465: if_icmpgt +52 -> 517
    //   468: aload_0
    //   469: getfield 66	agxq:jdField_a_of_type_ArrayOfAgxo	[Lagxo;
    //   472: iload_3
    //   473: aaload
    //   474: ifnull +136 -> 610
    //   477: aload_0
    //   478: getfield 66	agxq:jdField_a_of_type_ArrayOfAgxo	[Lagxo;
    //   481: iload_3
    //   482: aaload
    //   483: invokevirtual 1423	agxo:a	()Z
    //   486: ifeq +124 -> 610
    //   489: aload_0
    //   490: getfield 1871	agxq:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   493: iconst_5
    //   494: invokevirtual 1395	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   497: checkcast 1397	java/util/ArrayList
    //   500: astore 6
    //   502: aload 6
    //   504: ifnull +13 -> 517
    //   507: aload 6
    //   509: iload_3
    //   510: invokestatic 981	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   513: invokevirtual 1881	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   533: getfield 1389	agxq:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   536: iload 5
    //   538: invokevirtual 1395	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   541: checkcast 1883	java/util/List
    //   544: astore 6
    //   546: aload_0
    //   547: getfield 1871	agxq:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   550: iload 5
    //   552: invokevirtual 1395	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   555: checkcast 1883	java/util/List
    //   558: astore 7
    //   560: aload 7
    //   562: aload 6
    //   564: invokeinterface 1884 2 0
    //   569: ifne +597 -> 1166
    //   572: iconst_0
    //   573: istore 4
    //   575: aload 7
    //   577: invokeinterface 1886 1 0
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
    //   626: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   629: ifeq +12 -> 641
    //   632: ldc 237
    //   634: iconst_2
    //   635: ldc_w 1888
    //   638: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   641: return
    //   642: iload_3
    //   643: ifeq +23 -> 666
    //   646: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   649: ifeq +12 -> 661
    //   652: ldc 237
    //   654: iconst_2
    //   655: ldc_w 1890
    //   658: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   661: aload_0
    //   662: invokespecial 1892	agxq:n	()V
    //   665: return
    //   666: aload_0
    //   667: aload_0
    //   668: getfield 1871	agxq:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   671: iconst_2
    //   672: invokevirtual 1894	agxq:a	(Landroid/util/SparseArray;I)I
    //   675: istore_3
    //   676: aload_0
    //   677: aload_0
    //   678: getfield 1389	agxq:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   681: iconst_2
    //   682: invokevirtual 1894	agxq:a	(Landroid/util/SparseArray;I)I
    //   685: istore 5
    //   687: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   690: ifeq +32 -> 722
    //   693: ldc 237
    //   695: iconst_2
    //   696: new 312	java/lang/StringBuilder
    //   699: dup
    //   700: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   703: ldc_w 1896
    //   706: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: iload_3
    //   710: iload 5
    //   712: isub
    //   713: invokevirtual 605	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   716: invokevirtual 326	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   722: iload 4
    //   724: ifne +59 -> 783
    //   727: aload_0
    //   728: invokespecial 1892	agxq:n	()V
    //   731: iconst_0
    //   732: istore_3
    //   733: iload_3
    //   734: bipush 6
    //   736: if_icmpge +47 -> 783
    //   739: aload_0
    //   740: getfield 1871	agxq:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   743: iload_3
    //   744: invokevirtual 1395	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   747: checkcast 1397	java/util/ArrayList
    //   750: astore 6
    //   752: aload 6
    //   754: ifnull +22 -> 776
    //   757: aload_0
    //   758: getfield 1389	agxq:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   761: iload_3
    //   762: aload 6
    //   764: invokevirtual 1899	java/util/ArrayList:clone	()Ljava/lang/Object;
    //   767: checkcast 1397	java/util/ArrayList
    //   770: checkcast 1397	java/util/ArrayList
    //   773: invokevirtual 1877	android/util/SparseArray:put	(ILjava/lang/Object;)V
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
    //   796: getfield 1389	agxq:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   799: iload 5
    //   801: invokevirtual 1395	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   804: checkcast 1397	java/util/ArrayList
    //   807: astore 6
    //   809: iload_3
    //   810: istore 4
    //   812: aload 6
    //   814: ifnull +14 -> 828
    //   817: aload 6
    //   819: invokevirtual 1400	java/util/ArrayList:size	()I
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
    //   842: invokevirtual 1404	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   845: astore 7
    //   847: iload_3
    //   848: istore 4
    //   850: aload 7
    //   852: invokeinterface 1409 1 0
    //   857: ifeq -29 -> 828
    //   860: aload 7
    //   862: invokeinterface 1413 1 0
    //   867: checkcast 977	java/lang/Integer
    //   870: invokevirtual 1416	java/lang/Integer:intValue	()I
    //   873: istore 4
    //   875: aload_0
    //   876: getfield 66	agxq:jdField_a_of_type_ArrayOfAgxo	[Lagxo;
    //   879: iload 4
    //   881: aaload
    //   882: astore 8
    //   884: aload 8
    //   886: ifnull -39 -> 847
    //   889: aload_0
    //   890: aload 8
    //   892: invokespecial 1901	agxq:a	(Lagxo;)V
    //   895: iload_3
    //   896: istore 4
    //   898: aload 8
    //   900: getfield 305	agxo:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   903: ifnull +85 -> 988
    //   906: iload_3
    //   907: istore 4
    //   909: aload 8
    //   911: getfield 1417	agxo:jdField_a_of_type_Boolean	Z
    //   914: ifne +74 -> 988
    //   917: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   920: ifeq +12 -> 932
    //   923: ldc 237
    //   925: iconst_2
    //   926: ldc_w 1903
    //   929: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   932: aload 8
    //   934: getfield 307	agxo:jdField_a_of_type_Int	I
    //   937: bipush 20
    //   939: if_icmpne +27 -> 966
    //   942: aload_0
    //   943: getfield 1818	agxq:g	Z
    //   946: ifeq +20 -> 966
    //   949: aload 8
    //   951: getfield 305	agxo:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   954: ldc 202
    //   956: invokevirtual 98	android/view/View:findViewById	(I)Landroid/view/View;
    //   959: invokevirtual 1828	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   962: iconst_0
    //   963: putfield 1831	android/view/ViewGroup$LayoutParams:height	I
    //   966: aload_0
    //   967: getfield 70	agxq:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   970: aload 8
    //   972: getfield 305	agxo:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   975: iconst_1
    //   976: invokevirtual 1906	com/tencent/widget/XListView:addHeaderView	(Landroid/view/View;I)V
    //   979: aload 8
    //   981: iconst_1
    //   982: putfield 1417	agxo:jdField_a_of_type_Boolean	Z
    //   985: iconst_1
    //   986: istore 4
    //   988: iload 4
    //   990: istore_3
    //   991: aload_2
    //   992: ifnull +12 -> 1004
    //   995: iload_1
    //   996: aload 8
    //   998: getfield 307	agxo:jdField_a_of_type_Int	I
    //   1001: if_icmpeq +54 -> 1055
    //   1004: aload_0
    //   1005: aload 8
    //   1007: aconst_null
    //   1008: invokespecial 1908	agxq:a	(Lagxo;Landroid/os/Message;)V
    //   1011: goto -164 -> 847
    //   1014: astore 6
    //   1016: invokestatic 310	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1019: ifeq +33 -> 1052
    //   1022: ldc 237
    //   1024: iconst_4
    //   1025: new 312	java/lang/StringBuilder
    //   1028: dup
    //   1029: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   1032: ldc_w 1910
    //   1035: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: aload 6
    //   1040: invokevirtual 1911	java/lang/Exception:toString	()Ljava/lang/String;
    //   1043: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: invokevirtual 326	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1049: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1052: goto -61 -> 991
    //   1055: aload_0
    //   1056: aload 8
    //   1058: aload_2
    //   1059: invokespecial 1908	agxq:a	(Lagxo;Landroid/os/Message;)V
    //   1062: goto -51 -> 1011
    //   1065: iload_3
    //   1066: ifeq -425 -> 641
    //   1069: aload_0
    //   1070: getfield 68	agxq:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1073: ifnull +78 -> 1151
    //   1076: aload_0
    //   1077: getfield 68	agxq:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1080: getfield 172	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1083: astore_2
    //   1084: aload_2
    //   1085: ifnull -444 -> 641
    //   1088: aload_2
    //   1089: sipush 252
    //   1092: invokevirtual 966	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1095: checkcast 1913	stg
    //   1098: getfield 1914	stg:jdField_a_of_type_Boolean	Z
    //   1101: ifeq -460 -> 641
    //   1104: aload_0
    //   1105: getfield 70	agxq:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   1108: invokevirtual 1917	com/tencent/widget/XListView:getFirstVisiblePosition	()I
    //   1111: istore_1
    //   1112: iload_1
    //   1113: aload_0
    //   1114: getfield 70	agxq:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   1117: invokevirtual 1920	com/tencent/widget/XListView:getHeaderViewsCount	()I
    //   1120: if_icmpgt -479 -> 641
    //   1123: aload_0
    //   1124: getfield 70	agxq:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   1127: iconst_0
    //   1128: invokevirtual 1922	com/tencent/widget/XListView:getHeaderViewsCount	(I)I
    //   1131: istore_3
    //   1132: iload_3
    //   1133: iconst_m1
    //   1134: if_icmpeq -493 -> 641
    //   1137: iload_3
    //   1138: iload_1
    //   1139: if_icmpgt -498 -> 641
    //   1142: aload_0
    //   1143: getfield 70	agxq:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   1146: iload_3
    //   1147: invokevirtual 1925	com/tencent/widget/XListView:setSelection	(I)V
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
    //   0	1169	0	this	agxq
    //   0	1169	1	paramInt	int
    //   0	1169	2	paramMessage	Message
    //   63	1097	3	m	int
    //   523	466	4	n	int
    //   518	315	5	i1	int
    //   81	760	6	localObject1	Object
    //   1014	25	6	localException1	Exception
    //   1156	1	6	localException2	Exception
    //   558	303	7	localObject2	Object
    //   882	175	8	localagxo	agxo
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
      bbzz.a().a(str, new agyr(this, localBundle, paramMessage));
      return;
    }
    a(30, 2);
    a(30, paramMessage);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "onDestroy");
      }
      this.f = true;
      if ((this.jdField_a_of_type_Aroi != null) && (paramQQAppInterface != null))
      {
        ((PhoneContactManagerImp)paramQQAppInterface.getManager(11)).b(this.jdField_a_of_type_Aroi);
        this.jdField_a_of_type_Aroi = null;
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
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    Object localObject;
    auqh localauqh;
    if ((paramAppInfo != null) && (paramString != null))
    {
      localObject = paramAppInfo.buffer.get();
      if (!baip.a((String)localObject)) {
        localauqh = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36);
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
        localauqh.a(paramAppInfo, false);
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
    auqh localauqh;
    JSONObject localJSONObject;
    if (((paramAppInfo != null) && (3 == paramInt)) || (2 == paramInt))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.recent.banner", 2, "onReportRenewBannerExposure");
      }
      localauqh = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("cmd", paramInt);
      localJSONObject.put("missionid", paramString);
      localauqh.a(paramAppInfo, localJSONObject, paramInt);
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
    if (this.jdField_a_of_type_ArrayOfAgxo[15] != null) {
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
      if ((this.jdField_a_of_type_Aroi == null) && (!this.f))
      {
        this.jdField_a_of_type_Aroi = new agxr(this);
        localPhoneContactManagerImp.a(this.jdField_a_of_type_Aroi);
      }
      paramBoolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), 0).getBoolean("key_show_contact_banner", true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "checkContactBanner, state = " + m + ", isFirstShow = " + paramBoolean);
      }
      if ((m == 1) && (paramBoolean))
      {
        if ((this.jdField_a_of_type_ArrayOfAgxo[15] != null) && (this.jdField_a_of_type_ArrayOfAgxo[15].jdField_b_of_type_Int != 2)) {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X80053D8", "0X80053D8", 0, 0, "", "", "", "");
        }
        a(15, 2);
        awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 13, 0, "", "", "", "");
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
      if (paramInt < this.jdField_a_of_type_ArrayOfAgxo.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfAgxo[paramInt];
      }
    }
    return (localObject1 != null) && (((agxo)localObject1).a());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().b() <= 0) {
        break label34;
      }
      a(36, 2);
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
          a(36, 2);
          return;
        }
        a(36, 0);
        return;
      }
      if (m == 1)
      {
        a(36, 2);
        return;
      }
    } while (m != 2);
    a(36, 2);
    return;
    a(36, 0);
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
    if (this.jdField_a_of_type_Ahag != null) {
      this.jdField_a_of_type_Ahag.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    ahag localahag = ahag.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this);
    if (localahag == null) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_Ahag == null) || (!this.jdField_a_of_type_Ahag.getClass().isInstance(localahag)) || (!localahag.getClass().isInstance(this.jdField_a_of_type_Ahag)))
      {
        this.jdField_a_of_type_Ahag = localahag;
        h();
      }
    } while (this.jdField_a_of_type_Ahag == null);
    boolean bool = this.jdField_a_of_type_Ahag.a();
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
      if (paramInt < this.jdField_a_of_type_ArrayOfAgxo.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfAgxo[paramInt];
      }
    }
    return (localObject1 != null) && (((agxo)localObject1).jdField_a_of_type_Boolean);
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
    Object localObject1 = this.jdField_a_of_type_ArrayOfAgxo[20];
    if ((localObject1 == null) || (((agxo)localObject1).jdField_a_of_type_AndroidViewView == null)) {}
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
          } while (!((agxo)localObject1).jdField_a_of_type_Boolean);
          localObject1 = ((agxo)localObject1).jdField_a_of_type_AndroidViewView;
        } while (localObject1 == null);
        localObject1 = ((View)localObject1).findViewById(2131306467);
        localLayoutParams = ((View)localObject1).getLayoutParams();
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, "fight.setPushBannerHeight.lp.height1 = " + localLayoutParams.height);
        }
        if (!paramBoolean) {
          break;
        }
      } while ((localLayoutParams.height == this.jdField_c_of_type_Int) && (((View)localObject1).findViewById(2131298701).getVisibility() == 0) && (((View)localObject1).getAlpha() == 1.0F));
      ((View)localObject1).findViewById(2131298701).setVisibility(0);
      ((View)localObject1).setAlpha(1.0F);
      localLayoutParams.height = this.jdField_c_of_type_Int;
      ((View)localObject1).requestLayout();
      localObject1 = a(20, 2131296607);
      if ((localObject1 != null) && ((localObject1 instanceof String))) {}
      for (;;)
      {
        try
        {
          m = Integer.parseInt((String)localObject1);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X80087C2", "0X80087C2", m, 0, "3", "", "", "");
          return;
        }
        catch (Throwable localThrowable1)
        {
          localThrowable1.printStackTrace();
        }
        m = 0;
      }
    } while (localLayoutParams.height == 0);
    localThrowable1.findViewById(2131298701).setVisibility(4);
    localThrowable1.setAlpha(0.0F);
    localLayoutParams.height = 0;
    localThrowable1.requestLayout();
    Object localObject2 = a(20, 2131296607);
    if ((localObject2 != null) && ((localObject2 instanceof String))) {}
    for (;;)
    {
      try
      {
        m = Integer.parseInt((String)localObject2);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X80094CD", "0X80094CD", m, 0, "", "", "", "");
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
        if (this.jdField_a_of_type_ArrayOfAgxo[20] == null) {
          this.jdField_a_of_type_ArrayOfAgxo[20] = new agxo(20, 0);
        }
        a(this.jdField_a_of_type_ArrayOfAgxo[20]);
        View localView = this.jdField_a_of_type_ArrayOfAgxo[20].jdField_a_of_type_AndroidViewView;
        if (localView != null) {}
        for (bool1 = a(localView);; bool1 = false)
        {
          if (bool1)
          {
            localView.findViewById(2131306467).setVisibility(0);
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
    Object localObject = this.jdField_a_of_type_ArrayOfAgxo[20];
    ViewGroup localViewGroup;
    int n;
    int m;
    if ((localObject != null) && (((agxo)localObject).jdField_a_of_type_AndroidViewView != null))
    {
      localObject = (ADView)((agxo)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131296607);
      localViewGroup = ((ADView)localObject).a(0);
      if (localViewGroup != null)
      {
        n = localViewGroup.getChildCount();
        m = 0;
        n -= 1;
        if (n >= 0)
        {
          View localView = localViewGroup.getChildAt(n);
          awuf localawuf = (awuf)localView.getTag();
          String str = localawuf.jdField_c_of_type_JavaLangString;
          int i1 = str.indexOf("|");
          if (azvt.a(Long.parseLong(str.substring(0, i1)), Long.parseLong(str.substring(i1 + 1)))) {
            break label296;
          }
          ((ADView)localObject).a(0, n, localView);
          alzf.a.b(localawuf.l);
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
          a(20, 0);
          a(-1, null);
          this.jdField_e_of_type_Boolean = false;
        }
        for (;;)
        {
          localObject = new alzh(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), amnh.jdField_a_of_type_JavaLangString);
          if (localObject != null)
          {
            ((alzh)localObject).b();
            ((alzh)localObject).c();
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
    a(40, 0);
    a(12, 0);
    a(14, 0);
    a(31, 0);
    a(32, 0);
    Object localObject = this.jdField_a_of_type_ArrayOfAgxo[20];
    if ((localObject != null) && (((agxo)localObject).jdField_a_of_type_AndroidViewView != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((agxo)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131296608);
      localObject = (ADView)((agxo)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131296607);
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
    a(22, 0);
    a(6, 0);
    a(19, 0);
    if (this.jdField_a_of_type_Ahag != null) {
      this.jdField_a_of_type_Ahag.g();
    }
    a(27, 0);
    a(30, 0);
    b();
    j();
    a(-1, null);
    a(false);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void f()
  {
    a(19, 0);
    a(-1, null);
    if (this.jdField_a_of_type_Ahag != null) {
      this.jdField_a_of_type_Ahag.f();
    }
  }
  
  public void g()
  {
    QLog.i("Q.recent.banner", 1, "onResume");
    if (this.jdField_a_of_type_Ahag != null) {
      this.jdField_a_of_type_Ahag.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter.b();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ArrayOfAgxo != null)
    {
      agxo localagxo = this.jdField_a_of_type_ArrayOfAgxo[19];
      if ((localagxo != null) && (localagxo.jdField_a_of_type_AndroidViewView != null) && (localagxo.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(localagxo.jdField_a_of_type_AndroidViewView);
        localagxo.jdField_a_of_type_Boolean = false;
        localagxo.jdField_a_of_type_AndroidViewView = null;
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
      awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 17, 0, "", "", "", "");
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
      a(23, 0);
      a(23, paramMessage);
      continue;
      a(24, 0);
      a(24, paramMessage);
      continue;
      a(22, 2);
      a(22, paramMessage);
      continue;
      a(22, 0);
      a(22, paramMessage);
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
        a(27, 0);
        a(27, paramMessage);
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
        a(25, 0);
        a(25, paramMessage);
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
      if ((localQQAppInterface != null) && ((ariz.a().c(localQQAppInterface, this.jdField_e_of_type_JavaLangString)) || (this.i)))
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
          } while ((TextUtils.isEmpty(localRecentUser.uin)) || (ariz.a().b(localQQAppInterface, localRecentUser.uin)) || (ariz.a().a(localQQAppInterface, localRecentUser.uin) != 1));
          if (localQQAppInterface.a().a(localRecentUser.uin, localRecentUser.getType()) > 99)
          {
            if ((this.i) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_e_of_type_JavaLangString.equals(localRecentUser.uin))) {
              break;
            }
            this.jdField_e_of_type_JavaLangString = localRecentUser.uin;
            if ((!this.h) || (!ariz.a().c(localQQAppInterface, this.jdField_e_of_type_JavaLangString))) {
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
    if (a(26))
    {
      a(26, 0);
      this.jdField_b_of_type_JavaLangString = null;
      a(-1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agxq
 * JD-Core Version:    0.7.0.1
 */