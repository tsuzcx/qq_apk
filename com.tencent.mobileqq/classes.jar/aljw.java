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
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.recent.BannerManager.44;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.data.GameNoticeCenter;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
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

public class aljw
  implements Handler.Callback
{
  public static final boolean a;
  public float a;
  public int a;
  public long a;
  private volatile allw jdField_a_of_type_Allw;
  private almq jdField_a_of_type_Almq;
  private SparseArray<ArrayList<Integer>> jdField_a_of_type_AndroidUtilSparseArray;
  private axfs jdField_a_of_type_Axfs;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private GameNoticeCenter jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bhlj(this);
  private aljs[] jdField_a_of_type_ArrayOfAljs = new aljs[45];
  public int b;
  public long b;
  private volatile allw jdField_b_of_type_Allw;
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
  
  public aljw(BaseActivity paramBaseActivity, XListView paramXListView)
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    if (this.jdField_c_of_type_Int == 0) {
      this.jdField_c_of_type_Int = agej.a(50.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
    }
  }
  
  private View A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BrowserBar", 2, "initBrowserBar");
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131558646, null);
    localView.findViewById(2131362497).setVisibility(8);
    return localView;
  }
  
  private View B()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComicBar", 2, "initComicBar");
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131558648, null);
    localView.findViewById(2131362524).setVisibility(8);
    return localView;
  }
  
  private View C()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameBar", 2, "initGameBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838356));
    localTipsBar.setVisibility(8);
    localTipsBar.a(true);
    return localTipsBar;
  }
  
  private View D()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131563076, null);
    TextView localTextView = (TextView)localView.findViewById(2131380458);
    localTextView.setOnClickListener(new allc(this));
    localTextView.setText("");
    if (AppSetting.jdField_c_of_type_Boolean) {
      localTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719116));
    }
    ((ImageView)localView.findViewById(2131364591)).setOnClickListener(new alld(this));
    localView.findViewById(2131380457).setVisibility(8);
    return localView;
  }
  
  private View E()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131559488, null);
    localView.setOnClickListener(new alle(this));
    localView.findViewById(2131371532).setVisibility(8);
    return localView;
  }
  
  private View F()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839478));
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131717941));
    localTipsBar.setOnClickListener(new allf(this));
    bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 18, 0, "", "", "", "");
    return localTipsBar;
  }
  
  private View G()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131559653, null);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    localView.findViewById(2131373224).setVisibility(8);
    ((LinearLayout)localView.findViewById(2131364584)).setOnClickListener(new allh(this));
    return localView;
  }
  
  private View H()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845013));
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697925));
    localTipsBar.setOnClickListener(new alli(this));
    return localTipsBar;
  }
  
  private View I()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131561938, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131374743);
    localView.setOnClickListener(new allj(this));
    localImageView.setOnClickListener(new allk(this));
    return localView;
  }
  
  private View J()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.a(true);
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View K()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initWiFiSecurityBanner");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(4);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838270));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View L()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130846996));
    localTipsBar.b(true);
    localTipsBar.setOnClickListener(new alln(this));
    return localTipsBar;
  }
  
  @Nullable
  public static allw a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, allu paramallu)
  {
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null)
    {
      paramString1 = new allw(1, paramString1, paramInt, paramString2, paramallu);
      paramString2 = paramQQAppInterface.obtainMessage(1134200);
      paramString2.obj = paramString1;
      paramQQAppInterface.sendMessage(paramString2);
      return paramString1;
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    int m = 30;
    if (m <= 38)
    {
      if (this.jdField_a_of_type_ArrayOfAljs[m] == null) {}
      for (;;)
      {
        m += 1;
        break;
        if (this.jdField_a_of_type_ArrayOfAljs[m].jdField_b_of_type_Int == 2) {
          if (m != paramInt)
          {
            c(m, paramInt);
            this.jdField_a_of_type_ArrayOfAljs[m].jdField_b_of_type_Int = 0;
          }
          else if ((m == 38) && (this.jdField_a_of_type_Allw != null) && (!this.jdField_b_of_type_Allw.equals(this.jdField_a_of_type_Allw)))
          {
            c(m, paramInt);
          }
        }
      }
    }
  }
  
  private void a(aljs paramaljs)
  {
    if ((paramaljs == null) || (paramaljs.jdField_a_of_type_AndroidViewView != null)) {
      return;
    }
    for (;;)
    {
      try
      {
        int m = paramaljs.jdField_a_of_type_Int;
        switch (m)
        {
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = q();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = a();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = s();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = o();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = m();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = l();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = n();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = r();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = u();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = t();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = t();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = D();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = v();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = G();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = c();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = F();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = d();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = p();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = I();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = w();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = x();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = y();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = z();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = B();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = A();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = C();
        continue;
        TipsBar localTipsBar = GameNoticeCenter.createBanner(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        a(localTipsBar, 2);
        paramaljs.jdField_a_of_type_AndroidViewView = localTipsBar;
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = E();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = H();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = i();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = j();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = k();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = h();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = f();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = g();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = e();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = J();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = K();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = L();
        continue;
        paramaljs.jdField_a_of_type_AndroidViewView = b();
        continue;
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("Q.recent.banner", 4, "initBannerView | banner = " + paramaljs);
      return;
      paramaljs.jdField_a_of_type_AndroidViewView = n();
    }
  }
  
  private void a(aljs paramaljs, Message paramMessage)
  {
    boolean bool = false;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateBanner| banner = ").append(paramaljs).append(", msg = ").append(paramMessage).append(" isGeneral? ");
      if (paramaljs.jdField_a_of_type_Int == 38) {
        bool = true;
      }
      QLog.d("Q.recent.banner", 4, Boolean.toString(bool));
    }
    if ((paramaljs == null) || (paramaljs.jdField_a_of_type_AndroidViewView == null)) {
      label84:
      return;
    }
    TextHook.updateFont(paramaljs.jdField_a_of_type_AndroidViewView);
    for (;;)
    {
      try
      {
        switch (paramaljs.jdField_a_of_type_Int)
        {
        case 6: 
        case 16: 
        case 17: 
        case 18: 
        case 20: 
        case 43: 
          if (!(paramaljs.jdField_a_of_type_AndroidViewView instanceof TipsBar)) {
            break label84;
          }
          a((TipsBar)paramaljs.jdField_a_of_type_AndroidViewView);
          return;
        }
      }
      catch (Throwable paramaljs)
      {
        paramaljs.printStackTrace();
        return;
      }
      b(paramaljs.jdField_a_of_type_AndroidViewView);
      continue;
      m(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      i(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      l(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      h(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      a(paramaljs.jdField_a_of_type_AndroidViewView);
      continue;
      n(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      c(paramaljs.jdField_a_of_type_AndroidViewView);
      continue;
      paramaljs.jdField_a_of_type_AndroidViewView.findViewById(2131380457).setVisibility(0);
      continue;
      paramaljs.jdField_a_of_type_AndroidViewView.findViewById(2131380457).setVisibility(0);
      continue;
      v(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      d(paramaljs.jdField_a_of_type_AndroidViewView);
      continue;
      p(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      q(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      r(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      t(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      s(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      u(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter.updateGameCenterBar(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        w(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        e(paramaljs.jdField_a_of_type_AndroidViewView);
        continue;
        b(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        b(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage, paramaljs.jdField_b_of_type_Int);
        continue;
        a(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage, paramaljs.jdField_b_of_type_Int);
        continue;
        f(paramaljs.jdField_a_of_type_AndroidViewView);
        continue;
        f(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        g(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        k(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        e(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        c(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        d(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        aqqv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(this, paramaljs.jdField_a_of_type_AndroidViewView);
        continue;
        o(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        y(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        x(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        g(paramaljs.jdField_a_of_type_AndroidViewView);
        continue;
        j(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
        continue;
        a(paramaljs.jdField_a_of_type_AndroidViewView, paramMessage);
      }
    }
  }
  
  private void a(allw paramallw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "hideGeneralBannerInBInternal with: " + paramallw);
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(201);
    localMessage.obj = paramallw;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  private void a(View paramView)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    paramView.setVisibility(0);
    ((TipsBar)paramView).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690928));
  }
  
  private void a(View paramView, Message paramMessage)
  {
    paramView.setVisibility(0);
  }
  
  private void a(View paramView, Message paramMessage, int paramInt)
  {
    if ((paramMessage == null) || (paramMessage.obj == null) || (!(paramMessage.obj instanceof ajnf))) {
      return;
    }
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8005B72", "0X8005B72", 0, 0, "", "", "", "");
    paramView.findViewById(2131374319).setVisibility(0);
    paramMessage = (ajnf)paramMessage.obj;
    ((TextView)paramView.findViewById(2131363294)).setText(paramMessage.jdField_b_of_type_JavaLangString);
    bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 5, 0, "", "", "", "");
    paramView.setOnClickListener(new allr(this, paramMessage));
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
      rmf.a(paramQQAppInterface, paramIntent, localPendingIntent, str1, str2);
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
    paramIntent = new allz(paramPendingIntent, paramQQAppInterface);
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
    paramIntent = new alma(paramQQAppInterface, paramString3, str3, str1, str2, localIntent, paramQQAppInterface.c(), m);
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
      paramString3 = new almb(paramString3, paramQQAppInterface, paramString4, paramInt2, paramBundle, paramBoolean);
      paramInt2 = paramInt1;
      if (paramInt1 < 0) {
        paramInt2 = aljt.a(str1);
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
    paramString1 = new allt(paramString1, paramQQAppInterface);
    paramString1.a(a(paramQQAppInterface, m, paramString2, paramString3, paramString1));
  }
  
  private boolean a(View paramView)
  {
    aqzw localaqzw = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin(), false);
    if (localaqzw == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushBannerConfig", 2, "loadPushBanner");
      }
      o();
      return false;
    }
    int i2 = localaqzw.a(0);
    if (i2 > 0)
    {
      ((ADView)paramView.findViewById(2131362236)).h();
      int m = 0;
      int i1;
      for (int n = 0; m < i2; n = i1)
      {
        i1 = n;
        if (a(localaqzw, m, paramView)) {
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
  
  private boolean a(aqzw paramaqzw, int paramInt, View paramView)
  {
    bdof localbdof = new bdof(paramaqzw.a(0, paramInt), paramaqzw.b(0, paramInt), paramaqzw.a(0, paramInt));
    localbdof.l = paramaqzw.a(0, paramInt);
    localbdof.m = paramaqzw.c(0, paramInt);
    boolean bool = localbdof.a(paramaqzw.a(0, paramInt));
    if ((localbdof.jdField_c_of_type_JavaLangString != null) && (localbdof.jdField_c_of_type_JavaLangString.contains("|")) && (!bhgp.a(Long.parseLong(localbdof.jdField_c_of_type_JavaLangString.substring(0, localbdof.jdField_c_of_type_JavaLangString.indexOf("|"))), Long.parseLong(localbdof.jdField_c_of_type_JavaLangString.substring(localbdof.jdField_c_of_type_JavaLangString.indexOf("|") + 1))))) {}
    label470:
    for (;;)
    {
      return false;
      if ((bool) && (!"".equals(localbdof.j)))
      {
        localbdof.jdField_a_of_type_Bhmr = bhni.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localbdof.j);
        if (localbdof.jdField_a_of_type_Bhmr == null) {}
        for (int m = 0;; m = 1)
        {
          if (m == 0) {
            break label470;
          }
          Object localObject = paramaqzw.a(0, paramInt);
          if (QLog.isDevelopLevel()) {
            QLog.i("PUSH BANNER", 4, "addPushBanner, bannerPic = " + localObject);
          }
          if (localObject == null) {
            break;
          }
          paramaqzw = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131559654, null);
          ImageView localImageView = (ImageView)paramaqzw.findViewById(2131362017);
          localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          localImageView.setImageBitmap((Bitmap)localObject);
          DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
          m = ((Bitmap)localObject).getHeight() * Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) / ((Bitmap)localObject).getWidth();
          localLayoutParams.height = Math.max((int)(30.0F * localDisplayMetrics.density), Math.min(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) * 68 / 320, m));
          localImageView.setLayoutParams(localLayoutParams);
          localObject = (ImageView)paramaqzw.findViewById(2131373236);
          ((ImageView)localObject).setTag(localbdof);
          ((ImageView)localObject).setContentDescription(anzj.a(2131699841));
          ((ImageView)localObject).setOnClickListener(new alll(this));
          paramaqzw.setTag(localbdof);
          ((ADView)paramView.findViewById(2131362236)).a(paramaqzw, paramInt);
          paramView.setTag(2131362236, localbdof.jdField_a_of_type_JavaLangString);
          return true;
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, allw paramallw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "hideGeneralBannerInB with: " + paramallw);
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null)
    {
      Message localMessage = paramQQAppInterface.obtainMessage(1134201);
      localMessage.obj = paramallw;
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
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if (paramInt2 != 2) {
        break label31;
      }
      aljv.a(localQQAppInterface, paramInt1);
    }
    label31:
    while (paramInt2 != 0)
    {
      return;
      localQQAppInterface = null;
      break;
    }
    aljv.b(localQQAppInterface, paramInt1);
  }
  
  private void b(allw paramallw)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(201);
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(201);
    localMessage.obj = paramallw;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 900000L);
  }
  
  private void b(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "hideGeneralBanner: " + paramMessage);
    }
    if (!(paramMessage.obj instanceof allw)) {}
    do
    {
      return;
      int m = ((allw)paramMessage.obj).jdField_a_of_type_Int;
    } while (!paramMessage.obj.equals(this.jdField_a_of_type_Allw));
    a(38, 0);
    a(38, paramMessage);
  }
  
  private void b(View paramView)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    paramView.setVisibility(0);
    ((TipsBar)paramView).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693968));
    if (a(12))
    {
      a(12, 0);
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_b_of_type_Int = -1;
      this.jdField_d_of_type_JavaLangString = null;
    }
    bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 1, 0, "", "", "", "");
  }
  
  private void b(View paramView, Message paramMessage)
  {
    if (paramMessage != null)
    {
      if (this.jdField_a_of_type_Almq != null) {
        this.jdField_a_of_type_Almq.c();
      }
      bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 11, 0, "", "", "", "");
    }
  }
  
  private void b(View paramView, Message paramMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "updateMissedCallBar state: " + paramInt);
    }
    paramMessage = (baou)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(38);
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
        paramView.findViewById(2131374317).setVisibility(0);
        ((TextView)paramView.findViewById(2131374318)).setText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697897), new Object[] { Integer.valueOf(m) }));
      } while (m > 0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(7);
      return;
    }
  }
  
  private View c()
  {
    if (this.jdField_a_of_type_Almq != null) {
      return this.jdField_a_of_type_Almq.a();
    }
    return null;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "[notifyBannerIsOverride], type is " + paramInt1 + " / " + paramInt2);
    }
    if ((paramInt1 == 38) && (this.jdField_a_of_type_Allw != null)) {
      this.jdField_a_of_type_Allw.jdField_a_of_type_Allu.onOverride();
    }
    do
    {
      do
      {
        return;
      } while (paramInt1 != 36);
      localObject = andl.a();
    } while (localObject == null);
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if (localQQAppInterface == null) {
        break label178;
      }
      if (((andl)localObject).a != null) {
        break label147;
      }
    }
    label147:
    for (Object localObject = "-1";; localObject = ((andl)localObject).a.gameId + "")
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "mutex_bar", 0, 0, new String[] { localObject });
      return;
      localQQAppInterface = null;
      break;
    }
    label178:
    QLog.e("Q.recent.banner", 1, "[notifyBannerStateChange] app null");
  }
  
  private void c(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof allw)) {
      return;
    }
    int m = ((allw)paramMessage.obj).jdField_a_of_type_Int;
    this.jdField_b_of_type_Allw = ((allw)paramMessage.obj);
    a(38, 2);
    this.jdField_a_of_type_Allw = this.jdField_b_of_type_Allw;
    a(38, paramMessage);
    b((allw)paramMessage.obj);
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
      localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690604));
      return;
    }
    if ((zyv.b(this.jdField_b_of_type_Int)) && (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {
      this.jdField_d_of_type_JavaLangString = "手表QQ已登录";
    }
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      localTipsBar.setTipsText(this.jdField_d_of_type_JavaLangString);
      if (this.jdField_b_of_type_Int != 5) {
        break label215;
      }
      localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839105));
      label126:
      if (this.jdField_b_of_type_Int != 4) {
        break label265;
      }
    }
    label265:
    for (int m = 23;; m = 10)
    {
      bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", m, 0, "", "", "", "");
      return;
      paramView = "QQ";
      if (this.jdField_b_of_type_Long == 77313L) {
        paramView = "TIM";
      }
      localTipsBar.setTipsText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694201), new Object[] { paramView }));
      break;
      label215:
      if (zyv.b(this.jdField_b_of_type_Int))
      {
        localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839107));
        break label126;
      }
      localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839106));
      break label126;
    }
  }
  
  private void c(View paramView, Message paramMessage)
  {
    paramView = (TipsBar)paramView;
    paramView.setVisibility(0);
    a(paramView);
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      paramView.setTipsText(((UpgradeTIMWrapper)paramMessage.obj).f);
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface)
  {
    a(16, 0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    if ((this.jdField_a_of_type_Axfs != null) && (paramQQAppInterface != null))
    {
      ((PhoneContactManagerImp)paramQQAppInterface.getManager(11)).b(this.jdField_a_of_type_Axfs);
      this.jdField_a_of_type_Axfs = null;
    }
  }
  
  private View d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initSecurePhoneBanner");
    }
    TipsBar localTipsBar = bhiu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
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
        String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694385);
        ((TipsBar)paramView).setTipsText(Html.fromHtml(str + " " + localSongInfo.jdField_c_of_type_JavaLangString));
      }
      bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EE0", "0X8009EE0", 1, 0, "", "", "", "");
      return;
    }
    paramView.setVisibility(8);
    a(39, 0);
    a(-1, null);
  }
  
  private void d(View paramView, Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null))
    {
      paramView = (TipsBar)paramView;
      a(paramView);
      paramView.setVisibility(0);
      paramMessage = (azku)paramMessage.obj;
      paramView.setCloseListener(new alkk(this, paramMessage));
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "[status][banner] banner mgr show banner " + paramMessage.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramMessage.jdField_b_of_type_JavaLangString))
      {
        Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getApp().getResources().getDrawable(2130847438);
        paramView.setTipsIcon(URLDrawable.getDrawable(paramMessage.jdField_b_of_type_JavaLangString, localDrawable, localDrawable));
      }
      paramView.setTipsText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690206), new Object[] { paramMessage.jdField_a_of_type_JavaLangString }));
      paramView.setButtonText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690205));
      paramView.a(true);
      paramView.setOnClickListener(new alkv(this, paramMessage));
      paramView.setOriginalOnClickListener(new allg(this, paramMessage));
      azir.a("0X800AF9E", (int)paramMessage.jdField_a_of_type_Long);
    }
  }
  
  private void d(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "handleAccountChanged with: " + this.jdField_a_of_type_Allw);
    }
    if ((this.jdField_a_of_type_Allw != null) && (this.jdField_a_of_type_Allw.jdField_a_of_type_Allu.isNeedAutoCloseWhenAccountChange())) {
      a(this.jdField_a_of_type_Allw);
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
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698336));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839284));
    localTipsBar.setButtonText(anzj.a(2131699837));
    localTipsBar.a().setBackgroundResource(0);
    localTipsBar.a().setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166998));
    localTipsBar.setOriginalOnClickListener(new aljz(this));
    localTipsBar.setOnClickListener(new alka(this));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void e(View paramView)
  {
    paramView.findViewById(2131373224).setVisibility(0);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131362237);
    paramView = (ADView)paramView.findViewById(2131362236);
    if (d())
    {
      localRelativeLayout.setPadding(0, 0, 0, 0);
      paramView.i();
    }
    for (;;)
    {
      bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 12, 0, "", "", "", "");
      return;
      localRelativeLayout.setPadding(0, -1, 0, 0);
    }
  }
  
  private void e(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if ((paramMessage != null) && (paramMessage.obj != null))
    {
      ((TipsBar)paramView).setTipsText((String)paramMessage.obj);
      paramView.setOnClickListener(new allo(this));
    }
  }
  
  private boolean e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).getBoolean("reveive_newpb" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), false);
  }
  
  private View f()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130850595));
    localTipsBar.a(true);
    UpgradeTIMWrapper localUpgradeTIMWrapper = UpgradeTIMWrapper.a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
    localTipsBar.setTipsText(localUpgradeTIMWrapper.f);
    localTipsBar.setOnClickListener(new alkb(this, localUpgradeTIMWrapper));
    localTipsBar.setCloseListener(new alkc(this, localUpgradeTIMWrapper));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void f(View paramView)
  {
    paramView.findViewById(2131374742).setVisibility(0);
    ((TextView)paramView.findViewById(2131374744)).setText(anzj.a(2131699829));
  }
  
  private void f(View paramView, Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {}
    for (;;)
    {
      return;
      paramView.setVisibility(0);
      ((TipsBar)paramView).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691159));
      a((TipsBar)paramView);
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {}
      for (QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app; (localQQAppInterface != null) && (paramMessage != null) && (paramMessage.obj != null); localQQAppInterface = null)
      {
        paramMessage = (String)paramMessage.obj;
        bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 16, 0, "", "", "", "");
        paramView.setOnClickListener(new allp(this, paramMessage));
        return;
      }
    }
  }
  
  private boolean f()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).getBoolean("push_banner_display" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), true);
  }
  
  private View g()
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
  
  private void g(View paramView)
  {
    if (!(paramView instanceof TipsBar)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null) {
      return;
    }
    paramView = (TipsBar)paramView;
    a(paramView);
    zys localzys = (zys)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(335);
    String str = localzys.a();
    if (TextUtils.isEmpty(str))
    {
      k();
      return;
    }
    paramView.setTipsText(str);
    int m = localzys.a();
    if (m == 1)
    {
      paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130846998));
      return;
    }
    if (m == 2)
    {
      paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130846997));
      return;
    }
    if (m == 3)
    {
      paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130846999));
      return;
    }
    paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130846996));
  }
  
  private void g(View paramView, Message paramMessage)
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
    bdll.b(null, "CliOper", "", "", "theme", "0X8007232", 0, 0, String.valueOf(m), "", "", "");
    bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 15, 0, "", "", "", "");
    paramView.setOnClickListener(new allq(this, i1, n, (String)localObject, m));
  }
  
  private View h()
  {
    return aqcz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  private void h(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null))
    {
      if (audx.a().a())
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694385);
        String str = audx.a().a();
        if (str != null)
        {
          ((TipsBar)paramView).setTipsText(paramMessage + "" + str);
          paramView.setVisibility(0);
          bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EE1", "0X8009EE1", 2, 0, "", "", "", "");
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
  
  private View i()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 4);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691159));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838270));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void i(View paramView, Message paramMessage)
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
      paramView.setOnClickListener(new alls(this, paramMessage));
      bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004028", "0X8004028", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private View j()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130850583));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void j(View paramView, Message paramMessage)
  {
    if (!(paramView instanceof TipsBar)) {}
    while ((paramMessage == null) || (!(paramMessage.obj instanceof String))) {
      return;
    }
    String str = (String)paramMessage.obj;
    int m = paramMessage.arg1;
    paramView = (TipsBar)paramView;
    paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839358));
    a(paramView);
    paramView.setTipsText(str);
    paramView.setOnClickListener(new aljy(this, m));
    paramView.setVisibility(0);
  }
  
  private View k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.", 2, " initApolloGameBanner");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838521));
    localTipsBar.setTipsText(anzj.a(2131699835));
    localTipsBar.setVisibility(8);
    localTipsBar.a(true);
    localTipsBar.setOnClickListener(new alkd(this));
    localTipsBar.setCloseListener(new alke(this));
    return localTipsBar;
  }
  
  private void k(View paramView, Message paramMessage)
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
    bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 10, 0, "", "", "", "");
  }
  
  private View l()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130841301));
    localTipsBar.setOnClickListener(new alkh(this, localTipsBar));
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
    View localView = paramView.findViewById(2131374187);
    paramMessage = (TextView)paramView.findViewById(2131374188);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null))
    {
      int m = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a();
      if (m != 0)
      {
        localView.setVisibility(0);
        int n = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a().mMode;
        paramView = anzj.a(2131699833);
        if (1 == n) {
          paramView = anzj.a(2131699843);
        }
        for (;;)
        {
          paramMessage.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697679) + paramView + String.valueOf(m) + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697680));
          bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EE1", "0X8009EE1", 3, 0, "", "", "", "");
          return;
          if (2 == n) {
            paramView = anzj.a(2131699832);
          }
        }
      }
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(8);
  }
  
  private View m()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131561006, null);
    localView.setOnClickListener(new alki(this));
    localView.findViewById(2131374187).setVisibility(8);
    return localView;
  }
  
  private void m()
  {
    a(36, 0);
    a(36, null);
  }
  
  private void m(View paramView, Message paramMessage)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131381399);
    if (paramMessage != null)
    {
      if (paramMessage.arg1 != 1) {
        break label42;
      }
      localTextView.setText(2131719342);
    }
    for (;;)
    {
      paramView.findViewById(2131381398).setVisibility(0);
      return;
      label42:
      if (paramMessage.arg1 == 2) {
        localTextView.setText(2131719340);
      }
    }
  }
  
  private View n()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 4);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693968));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838270));
    localTipsBar.setOnClickListener(new alkj(this));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {}
    for (;;)
    {
      return;
      int m = 0;
      while (m < 6)
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
    aljs localaljs;
    while (localIterator.hasNext())
    {
      int n = ((Integer)localIterator.next()).intValue();
      localaljs = this.jdField_a_of_type_ArrayOfAljs[n];
      if ((localaljs != null) && (localaljs.jdField_a_of_type_AndroidViewView != null) && (localaljs.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(localaljs.jdField_a_of_type_AndroidViewView);
        if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
          break label165;
        }
      }
    }
    label165:
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;; localObject = null)
    {
      aljv.b((QQAppInterface)localObject, localaljs.jdField_a_of_type_Int);
      localaljs.jdField_a_of_type_Boolean = false;
      if (localaljs.a()) {
        break label52;
      }
      localaljs.jdField_a_of_type_AndroidViewView = null;
      break label52;
      break;
    }
  }
  
  private void n(View paramView, Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.what == 8)) {
      if ((paramMessage.obj instanceof bbba))
      {
        paramMessage = (bbba)paramMessage.obj;
        localObject2 = paramMessage.jdField_b_of_type_JavaLangString;
        localObject1 = (TextView)paramView.findViewById(2131376504);
        ((TextView)localObject1).setText((CharSequence)localObject2);
        if ((paramMessage.jdField_e_of_type_JavaLangString != null) && (!TextUtils.isEmpty(paramMessage.jdField_e_of_type_JavaLangString)))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getApp().getResources().getDrawable(2130847438);
          localObject2 = URLDrawable.getDrawable(paramMessage.jdField_e_of_type_JavaLangString, (Drawable)localObject2, (Drawable)localObject2);
          if (localObject2 != null)
          {
            ((Drawable)localObject2).setBounds(0, 0, bhgr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 22.0F), bhgr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 22.0F));
            ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
          }
        }
        localObject1 = (Button)paramView.findViewById(2131376503);
        if ((paramMessage.f != null) && (!TextUtils.isEmpty(paramMessage.f))) {
          ((Button)localObject1).setText(paramMessage.f);
        }
        localObject2 = paramMessage.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
        localbbav = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36);
        if ((paramMessage.jdField_a_of_type_JavaLangString != null) && (localObject2 != null) && (localbbav != null))
        {
          ((Button)localObject1).setOnClickListener(new alkm(this, localbbav, paramMessage, (BusinessInfoCheckUpdate.AppInfo)localObject2));
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
      bbav localbbav;
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(9);
  }
  
  private View o()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 4);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693964));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838270));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void o()
  {
    ThreadManager.post(new BannerManager.44(this), 5, null, false);
  }
  
  private void o(View paramView, Message paramMessage)
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
        bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 2, 0, "", "", "", "");
        return;
      }
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(8);
  }
  
  private View p()
  {
    AdvancedTipsBar localAdvancedTipsBar = new AdvancedTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localAdvancedTipsBar, 2);
    aqqv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localAdvancedTipsBar);
    return localAdvancedTipsBar;
  }
  
  private void p(View paramView, Message paramMessage)
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
        ((TipsBar)paramView).setTipsText(Html.fromHtml((String)paramMessage.second + anzj.a(2131699834)));
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
        a(37, 0);
      }
    }
    for (;;)
    {
      a(-1, null);
      return;
      paramView.setVisibility(8);
      a(37, 0);
    }
  }
  
  private View q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initMissedCallBar");
    }
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131561095, null);
    ((TextView)localView.findViewById(2131374318)).setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697897));
    localView.findViewById(2131374317).setVisibility(8);
    return localView;
  }
  
  private void q(View paramView, Message paramMessage)
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
    ((TipsBar)paramView).setTipsText(anzj.a(2131699840) + str1 + "》");
    paramView.setOnClickListener(new alku(this, l, str2));
    ((TipsBar)paramView).setCloseListener(new allv(13, this.jdField_a_of_type_MqqOsMqqHandler));
    paramView.setVisibility(0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(13);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(13, 900000L);
    bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 1, 0, "", "", "", "");
  }
  
  private View r()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131562127, null);
    localView.setVisibility(8);
    return localView;
  }
  
  private void r(View paramView, Message paramMessage)
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
          ((TipsBar)paramView).setTipsText(anzj.a(2131699839));
          localObject1 = (String)localObject1 + "&ADTAG=aio.run.click";
        }
        for (;;)
        {
          paramView.setOnClickListener(new alkw(this, (String)localObject1, localLong, m));
          if (localLong.longValue() == 3L)
          {
            localObject1 = new LpReportInfo_dc00307(LpReportInfo_dc00307.ACTION_TYPE_RED_PACK, LpReportInfo_dc00307.SUB_ACTION_TYPE_RED_PACK_EXPOSURE, m);
            LpReportManager.getInstance().reportToDC00307((LpReportInfo_dc00307)localObject1, false, true);
          }
          if ((paramView instanceof TipsBar)) {
            ((TipsBar)paramView).setCloseListener(new allv(1134044, ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime()).getHandler(Conversation.class)));
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            paramView = new Bundle();
            paramMessage.obj = paramView;
            paramMessage = Message.obtain(paramMessage);
            bjqd.a().a((String)localObject2, new alkx(this, paramView, paramMessage));
          }
          bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 9, 0, "", "", "", "");
          return;
          if (localLong.longValue() == 2L)
          {
            ((TipsBar)paramView).setTipsText(anzj.a(2131699831));
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
  
  private View s()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131560943, null);
    localView.findViewById(2131381399).setOnClickListener(new alkl(this));
    localView.findViewById(2131381398).setVisibility(8);
    return localView;
  }
  
  private void s(View paramView, Message paramMessage)
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
        localTextView = (TextView)paramView.findViewById(2131362500);
      } while ((!(paramMessage.obj instanceof Bundle)) || (localTextView == null));
      paramMessage = (Bundle)paramMessage.obj;
      str = (String)paramMessage.getCharSequence("tips");
      int m = paramMessage.getInt("icon");
      if (m != -1) {
        ((ImageView)paramView.findViewById(2131362499)).setImageResource(m);
      }
    } while (TextUtils.isEmpty(str));
    localTextView.setText(str);
    paramView.setOnClickListener(new alky(this, paramMessage));
    paramView.findViewById(2131362497).setVisibility(0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(15);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(15, paramMessage.getInt("timeout", 120000));
  }
  
  private View t()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131563077, null);
    TextView localTextView = (TextView)localView.findViewById(2131380458);
    localTextView.setOnClickListener(new alkn(this));
    localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719115));
    ((ImageView)localView.findViewById(2131364609)).setOnClickListener(new alko(this));
    localView.findViewById(2131380457).setVisibility(8);
    return localView;
  }
  
  private void t(View paramView, Message paramMessage)
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
        localTextView = (TextView)paramView.findViewById(2131362506);
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
        break label433;
      }
      paramMessage = paramMessage.substring(0, m) + "...";
    }
    label433:
    for (;;)
    {
      if ((n >= 100) && (n <= 300)) {
        localTextView.setText(anzj.a(2131699827) + paramMessage + "》");
      }
      for (;;)
      {
        paramView.setOnClickListener(new alkz(this, str));
        paramView.findViewById(2131362524).setVisibility(0);
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(14);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(14, 900000L);
        bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 2, 0, "", "", "", "");
        return;
        m = ((DisplayMetrics)localObject).widthPixels;
        break;
        localTextView.setText(anzj.a(2131699838) + paramMessage + "》");
      }
    }
  }
  
  private View u()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839106));
    localTipsBar.a(true);
    localTipsBar.setCloseListener(new alkp(this));
    localTipsBar.setOnClickListener(new alkq(this));
    return localTipsBar;
  }
  
  private void u(View paramView, Message paramMessage)
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
          paramView.setOnClickListener(new allb(this, paramMessage));
          paramView.setCloseListener(new allv(30, this.jdField_a_of_type_MqqOsMqqHandler));
          a(paramView);
          paramView.setVisibility(0);
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(30);
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(30, paramMessage.getInt("timeout", 900000));
          bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 4, 0, "", "", "", "");
          return;
          if (m != 1) {
            paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(m));
          }
        }
      }
    }
  }
  
  private View v()
  {
    View localView1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558973, null);
    View localView2 = localView1.findViewById(2131365121);
    localView1.setOnClickListener(new alkr(this));
    localView2.setVisibility(8);
    return localView1;
  }
  
  private void v(View paramView, Message paramMessage)
  {
    paramView.findViewById(2131380457).setVisibility(0);
    paramView = (TextView)paramView.findViewById(2131380458);
    if (paramMessage != null)
    {
      if (anvl.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) {
        break label91;
      }
      paramMessage = bhdu.a().a();
      if ((paramMessage != null) && (paramMessage.a != null) && (paramMessage.a.dialog != null)) {
        paramView.setText(paramMessage.a.dialog.h);
      }
    }
    else
    {
      return;
    }
    paramView.setText(anzj.a(2131699828));
    return;
    label91:
    paramMessage = bhdu.a().a();
    if ((paramMessage != null) && (paramMessage.a != null) && (paramMessage.a.dialog != null))
    {
      paramView.setText(paramMessage.a.dialog.g);
      return;
    }
    paramView.setText(anzj.a(2131699836));
  }
  
  private View w()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130841301));
    localTipsBar.setOnClickListener(new alks(this));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void w(View paramView, Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
      mml.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, paramView, paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
    }
  }
  
  private View x()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130841300));
    localTipsBar.a(true);
    localTipsBar.setOnClickListener(new alkt(this));
    localTipsBar.setCloseListener(new allv(1134060, ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime()).getHandler(Conversation.class)));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void x(View paramView, Message paramMessage)
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
    paramView.setOnClickListener(new allm(this, paramMessage));
    paramView.setVisibility(0);
    bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 6, 0, "", "", "", "");
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(202);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(202, 7000L);
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext();
    if (paramMessage.tipsType == 2) {}
    for (int m = 398680;; m = 398678)
    {
      bjhk.b(paramView, m);
      return;
    }
  }
  
  private View y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReaderBar", 2, "initReaderBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.a(true);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838364));
    return localTipsBar;
  }
  
  @SuppressLint({"ResourceType"})
  private void y(View paramView, Message paramMessage)
  {
    paramView = (TipsBar)paramView;
    a(paramView);
    if (paramMessage == null) {
      return;
    }
    paramMessage = (allw)paramMessage.obj;
    paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(aljt.a(paramMessage.jdField_b_of_type_Int)));
    paramView.setTipsText(paramMessage.jdField_b_of_type_JavaLangString);
    paramView.setOnClickListener(new ally(paramMessage, this.jdField_a_of_type_MqqOsMqqHandler));
    paramView.setCloseListener(new allx(paramMessage, this.jdField_a_of_type_MqqOsMqqHandler));
    paramView.setVisibility(0);
    bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 1, 0, "", "", "", "");
  }
  
  private View z()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RunningBar", 2, "initRunningBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsText(anzj.a(2131699842));
    localTipsBar.a(true);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838365));
    return localTipsBar;
  }
  
  public int a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfAljs.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfAljs[paramInt];
      }
    }
    if (localObject1 == null) {
      return 0;
    }
    return ((aljs)localObject1).jdField_b_of_type_Int;
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
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131561096, null);
    localView.findViewById(2131374319).setVisibility(8);
    return localView;
  }
  
  public Object a(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_ArrayOfAljs.length)) {}
    for (aljs localaljs = this.jdField_a_of_type_ArrayOfAljs[paramInt1];; localaljs = null)
    {
      Object localObject1 = localObject2;
      if (localaljs != null)
      {
        localObject1 = localObject2;
        if (localaljs.jdField_a_of_type_AndroidViewView != null)
        {
          if (paramInt2 != 0) {
            break label58;
          }
          localObject1 = localaljs.jdField_a_of_type_AndroidViewView.getTag();
        }
      }
      return localObject1;
      label58:
      return localaljs.jdField_a_of_type_AndroidViewView.getTag(paramInt2);
    }
  }
  
  public MqqHandler a()
  {
    return this.jdField_a_of_type_MqqOsMqqHandler;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Almq != null) {
      this.jdField_a_of_type_Almq.h();
    }
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface();
    if ((localAppInterface != null) && ((localAppInterface instanceof QQAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter = ((bcuy)localAppInterface.getManager(12)).a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter.checkBannerFromResume();
    }
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "fight.setPushBannerHeight:" + paramFloat + ",mIsStoryShow:" + this.g);
    }
    Object localObject1 = this.jdField_a_of_type_ArrayOfAljs[22];
    if ((localObject1 == null) || (((aljs)localObject1).jdField_a_of_type_AndroidViewView == null))
    {
      break label68;
      break label68;
    }
    for (;;)
    {
      label68:
      return;
      if (!((aljs)localObject1).jdField_a_of_type_Boolean) {
        continue;
      }
      if (paramFloat > 0.0F)
      {
        c(true);
        return;
      }
      localObject1 = ((aljs)localObject1).jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break;
      }
      int m = (int)Math.abs(paramFloat);
      localObject1 = ((View)localObject1).findViewById(2131373224);
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
      int n = this.jdField_c_of_type_Int;
      label159:
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
            localObject2 = a(22, 2131362236);
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
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X80094CD", "0X80094CD", n, 0, "", "", "", "");
        localLayoutParams.height = m;
        ((View)localObject1).setAlpha(paramFloat);
        ((View)localObject1).requestLayout();
        return;
        if (paramFloat >= -3.0F)
        {
          m = this.jdField_c_of_type_Int;
          paramFloat = 1.0F;
          break label159;
        }
        paramFloat = (n - m) / this.jdField_c_of_type_Int;
        m = n - m;
        break label159;
        if (localLayoutParams.height == 0) {
          continue;
        }
        ((View)localObject1).findViewById(2131364584).setVisibility(4);
        if (paramFloat < this.jdField_a_of_type_Float - n)
        {
          paramFloat = 0.0F;
          m = 0;
          break label159;
        }
        if (paramFloat < this.jdField_a_of_type_Float)
        {
          m = (int)(n + paramFloat - this.jdField_a_of_type_Float);
          paramFloat = m / n;
          break label159;
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
    if ((paramInt1 >= 1) && (paramInt1 <= 44))
    {
      if (this.jdField_a_of_type_ArrayOfAljs[paramInt1] == null) {
        break label108;
      }
      this.jdField_a_of_type_ArrayOfAljs[paramInt1].jdField_b_of_type_Int = paramInt2;
    }
    for (;;)
    {
      if ((paramInt1 >= 30) && (paramInt1 <= 38) && (paramInt2 == 2)) {
        a(paramInt1);
      }
      b(paramInt1, paramInt2);
      return;
      label108:
      if ((this.jdField_a_of_type_ArrayOfAljs[paramInt1] == null) && (aljs.a(paramInt2))) {
        this.jdField_a_of_type_ArrayOfAljs[paramInt1] = new aljs(paramInt1, paramInt2);
      }
    }
  }
  
  public void a(int paramInt, Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.recent.banner", 4, "refreshBanner, id: " + paramInt + " msg: " + paramMessage);
    }
    if (this.jdField_b_of_type_AndroidUtilSparseArray == null) {
      this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(6);
    }
    int m = 0;
    Object localObject1;
    if (m < 6)
    {
      localObject1 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(m);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList(1);
        this.jdField_b_of_type_AndroidUtilSparseArray.put(m, localObject1);
      }
      for (;;)
      {
        m += 1;
        break;
        ((ArrayList)localObject1).clear();
      }
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(6);
    }
    m = 1;
    if (m <= 28)
    {
      if ((this.jdField_a_of_type_ArrayOfAljs[m] == null) || (!this.jdField_a_of_type_ArrayOfAljs[m].a())) {
        break label330;
      }
      localObject1 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(0);
      if (this.jdField_b_of_type_AndroidUtilSparseArray != null) {
        ((ArrayList)localObject1).add(Integer.valueOf(m));
      }
    }
    m = 29;
    for (;;)
    {
      if (m <= 29)
      {
        if ((this.jdField_a_of_type_ArrayOfAljs[m] == null) || (!this.jdField_a_of_type_ArrayOfAljs[m].a())) {
          break label337;
        }
        localObject1 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(1);
        if (this.jdField_b_of_type_AndroidUtilSparseArray != null) {
          ((ArrayList)localObject1).add(Integer.valueOf(m));
        }
      }
      m = 30;
      while (m <= 38)
      {
        if ((this.jdField_a_of_type_ArrayOfAljs[m] != null) && (this.jdField_a_of_type_ArrayOfAljs[m].a()))
        {
          localObject1 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(2);
          if (this.jdField_b_of_type_AndroidUtilSparseArray != null) {
            ((ArrayList)localObject1).add(Integer.valueOf(m));
          }
        }
        m += 1;
      }
      label330:
      m += 1;
      break;
      label337:
      m += 1;
    }
    m = 39;
    if (m <= 39)
    {
      if ((this.jdField_a_of_type_ArrayOfAljs[m] == null) || (!this.jdField_a_of_type_ArrayOfAljs[m].a())) {
        break label597;
      }
      localObject1 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(3);
      if (localObject1 != null) {
        ((ArrayList)localObject1).add(Integer.valueOf(m));
      }
    }
    m = 40;
    label405:
    if (m <= 42)
    {
      if ((this.jdField_a_of_type_ArrayOfAljs[m] == null) || (!this.jdField_a_of_type_ArrayOfAljs[m].a())) {
        break label604;
      }
      localObject1 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(4);
      if (localObject1 != null) {
        ((ArrayList)localObject1).add(Integer.valueOf(m));
      }
    }
    m = 43;
    label463:
    if (m <= 44)
    {
      if ((this.jdField_a_of_type_ArrayOfAljs[m] == null) || (!this.jdField_a_of_type_ArrayOfAljs[m].a())) {
        break label611;
      }
      localObject1 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(5);
      if (localObject1 != null) {
        ((ArrayList)localObject1).add(Integer.valueOf(m));
      }
    }
    int i1 = 0;
    m = 1;
    int n = 1;
    label526:
    Object localObject2;
    if (i1 < 6)
    {
      localObject1 = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(i1);
      localObject2 = (List)this.jdField_b_of_type_AndroidUtilSparseArray.get(i1);
      if (((List)localObject2).equals(localObject1)) {
        break label1204;
      }
      n = 0;
    }
    label1192:
    label1204:
    for (;;)
    {
      if (!((List)localObject2).isEmpty()) {
        m = 0;
      }
      for (;;)
      {
        i1 += 1;
        break label526;
        label597:
        m += 1;
        break;
        label604:
        m += 1;
        break label405;
        label611:
        m += 1;
        break label463;
        if ((n != 0) && (m != 0)) {
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "refreshBanner, no banner");
          }
        }
        for (;;)
        {
          return;
          if (m != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.recent.banner", 2, "refreshBanner| clear banner");
            }
            n();
            return;
          }
          m = a(this.jdField_b_of_type_AndroidUtilSparseArray, 2);
          i1 = a(this.jdField_a_of_type_AndroidUtilSparseArray, 2);
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "added banner: " + (m - i1));
          }
          if (n == 0)
          {
            n();
            m = 0;
            while (m < 6)
            {
              localObject1 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(m);
              if (localObject1 != null) {
                this.jdField_a_of_type_AndroidUtilSparseArray.put(m, (ArrayList)((ArrayList)localObject1).clone());
              }
              m += 1;
            }
          }
          i1 = 0;
          m = 0;
          while (i1 < 6)
          {
            localObject1 = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(i1);
            n = m;
            if (localObject1 != null)
            {
              if (((ArrayList)localObject1).size() == 0) {
                n = m;
              }
            }
            else
            {
              i1 += 1;
              m = n;
              continue;
            }
            localObject2 = ((ArrayList)localObject1).iterator();
            aljs localaljs;
            do
            {
              n = m;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              n = ((Integer)((Iterator)localObject2).next()).intValue();
              localaljs = this.jdField_a_of_type_ArrayOfAljs[n];
            } while (localaljs == null);
            a(localaljs);
            n = m;
            for (;;)
            {
              for (;;)
              {
                try
                {
                  if (localaljs.jdField_a_of_type_AndroidViewView != null)
                  {
                    n = m;
                    if (!localaljs.jdField_a_of_type_Boolean)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.recent.banner", 2, "fight.addHeaderView_3.");
                      }
                      if ((localaljs.jdField_a_of_type_Int == 22) && (this.g)) {
                        localaljs.jdField_a_of_type_AndroidViewView.findViewById(2131373224).getLayoutParams().height = 0;
                      }
                      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localaljs.jdField_a_of_type_AndroidViewView, 1);
                      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
                        continue;
                      }
                      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
                      aljv.a((QQAppInterface)localObject1, localaljs.jdField_a_of_type_Int);
                    }
                  }
                }
                catch (Exception localException1) {}
                try
                {
                  localaljs.jdField_a_of_type_Boolean = true;
                  n = 1;
                  m = n;
                  if ((paramMessage != null) && (paramInt == localaljs.jdField_a_of_type_Int)) {
                    break label1093;
                  }
                  a(localaljs, null);
                }
                catch (Exception localException2)
                {
                  for (;;)
                  {
                    label1093:
                    m = 1;
                  }
                }
              }
              localObject1 = null;
              continue;
              if (QLog.isDevelopLevel()) {
                QLog.d("Q.recent.banner", 4, "initBanner|" + localException1.toString());
              }
              continue;
              a(localaljs, paramMessage);
            }
          }
          if (m != 0)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {}
            for (paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;; paramMessage = null)
            {
              if ((paramMessage == null) || (!((wwh)paramMessage.getManager(252)).jdField_a_of_type_Boolean)) {
                break label1192;
              }
              paramInt = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
              if (paramInt > this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount()) {
                break;
              }
              m = this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount(0);
              if ((m == -1) || (m > paramInt)) {
                break;
              }
              this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(m);
              return;
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
      bjqd.a().a(str, new alla(this, localBundle, paramMessage));
      return;
    }
    a(34, 2);
    a(34, paramMessage);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "onDestroy");
      }
      this.f = true;
      if ((this.jdField_a_of_type_Axfs != null) && (paramQQAppInterface != null))
      {
        ((PhoneContactManagerImp)paramQQAppInterface.getManager(11)).b(this.jdField_a_of_type_Axfs);
        this.jdField_a_of_type_Axfs = null;
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
    bbav localbbav;
    if ((paramAppInfo != null) && (paramString != null))
    {
      localObject = paramAppInfo.buffer.get();
      if (!bhsr.a((String)localObject)) {
        localbbav = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36);
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
        localbbav.a(paramAppInfo, false);
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
    bbav localbbav;
    JSONObject localJSONObject;
    if (((paramAppInfo != null) && (3 == paramInt)) || (2 == paramInt))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.recent.banner", 2, "onReportRenewBannerExposure");
      }
      localbbav = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("cmd", paramInt);
      localJSONObject.put("missionid", paramString);
      localbbav.a(paramAppInfo, localJSONObject, paramInt);
      return;
    }
    catch (JSONException paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    if ((a(17)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString)) && (this.jdField_e_of_type_JavaLangString.equals(paramString)))
    {
      this.jdField_e_of_type_JavaLangString = "";
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 1000L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ArrayOfAljs[16] != null) {
      a(16, 0);
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
      if ((this.jdField_a_of_type_Axfs == null) && (!this.f))
      {
        this.jdField_a_of_type_Axfs = new aljx(this);
        localPhoneContactManagerImp.a(this.jdField_a_of_type_Axfs);
      }
      paramBoolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), 0).getBoolean("key_show_contact_banner", true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "checkContactBanner, state = " + m + ", isFirstShow = " + paramBoolean);
      }
      if ((m == 1) && (paramBoolean))
      {
        if ((this.jdField_a_of_type_ArrayOfAljs[16] != null) && (this.jdField_a_of_type_ArrayOfAljs[16].jdField_b_of_type_Int != 2)) {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X80053D8", "0X80053D8", 0, 0, "", "", "", "");
        }
        a(16, 2);
        bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 13, 0, "", "", "", "");
        return;
      }
      a(16, 0);
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
      if (paramInt < this.jdField_a_of_type_ArrayOfAljs.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfAljs[paramInt];
      }
    }
    return (localObject1 != null) && (((aljs)localObject1).a());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().b() <= 0) {
        break label34;
      }
      a(40, 2);
    }
    label34:
    int m;
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.d()) {
        break;
      }
      m = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().e();
      if (m == 3)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().b() > 0L)
        {
          a(40, 2);
          return;
        }
        a(40, 0);
        return;
      }
      if (m == 1)
      {
        a(40, 2);
        return;
      }
    } while (m != 2);
    a(40, 2);
    return;
    a(40, 0);
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    a(11, 0);
    c(paramQQAppInterface);
    m();
    d(paramQQAppInterface);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Almq != null) {
      this.jdField_a_of_type_Almq.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    almq localalmq = almq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this);
    if (localalmq == null) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_Almq == null) || (!this.jdField_a_of_type_Almq.getClass().isInstance(localalmq)) || (!localalmq.getClass().isInstance(this.jdField_a_of_type_Almq)))
      {
        this.jdField_a_of_type_Almq = localalmq;
        h();
      }
    } while (this.jdField_a_of_type_Almq == null);
    boolean bool = this.jdField_a_of_type_Almq.a();
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
      if (paramInt < this.jdField_a_of_type_ArrayOfAljs.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfAljs[paramInt];
      }
    }
    return (localObject1 != null) && (((aljs)localObject1).jdField_a_of_type_Boolean);
  }
  
  public void c()
  {
    if (a(12))
    {
      a(12, 0);
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_b_of_type_Int = -1;
      this.jdField_d_of_type_JavaLangString = null;
      this.jdField_b_of_type_Long = 0L;
      a(-1, null);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAljs[22];
    if ((localObject1 == null) || (((aljs)localObject1).jdField_a_of_type_AndroidViewView == null)) {}
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
          } while (!((aljs)localObject1).jdField_a_of_type_Boolean);
          localObject1 = ((aljs)localObject1).jdField_a_of_type_AndroidViewView;
        } while (localObject1 == null);
        localObject1 = ((View)localObject1).findViewById(2131373224);
        localLayoutParams = ((View)localObject1).getLayoutParams();
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, "fight.setPushBannerHeight.lp.height1 = " + localLayoutParams.height);
        }
        if (!paramBoolean) {
          break;
        }
      } while ((localLayoutParams.height == this.jdField_c_of_type_Int) && (((View)localObject1).findViewById(2131364584).getVisibility() == 0) && (((View)localObject1).getAlpha() == 1.0F));
      ((View)localObject1).findViewById(2131364584).setVisibility(0);
      ((View)localObject1).setAlpha(1.0F);
      localLayoutParams.height = this.jdField_c_of_type_Int;
      ((View)localObject1).requestLayout();
      localObject1 = a(22, 2131362236);
      if ((localObject1 != null) && ((localObject1 instanceof String))) {}
      for (;;)
      {
        try
        {
          m = Integer.parseInt((String)localObject1);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X80087C2", "0X80087C2", m, 0, "3", "", "", "");
          return;
        }
        catch (Throwable localThrowable1)
        {
          localThrowable1.printStackTrace();
        }
        m = 0;
      }
    } while (localLayoutParams.height == 0);
    localThrowable1.findViewById(2131364584).setVisibility(4);
    localThrowable1.setAlpha(0.0F);
    localLayoutParams.height = 0;
    localThrowable1.requestLayout();
    Object localObject2 = a(22, 2131362236);
    if ((localObject2 != null) && ((localObject2 instanceof String))) {}
    for (;;)
    {
      try
      {
        m = Integer.parseInt((String)localObject2);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X80094CD", "0X80094CD", m, 0, "", "", "", "");
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
        if (this.jdField_a_of_type_ArrayOfAljs[22] == null) {
          this.jdField_a_of_type_ArrayOfAljs[22] = new aljs(22, 0);
        }
        a(this.jdField_a_of_type_ArrayOfAljs[22]);
        View localView = this.jdField_a_of_type_ArrayOfAljs[22].jdField_a_of_type_AndroidViewView;
        if (localView != null) {}
        for (bool1 = a(localView);; bool1 = false)
        {
          if (bool1)
          {
            localView.findViewById(2131373224).setVisibility(0);
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
    Object localObject = this.jdField_a_of_type_ArrayOfAljs[22];
    ViewGroup localViewGroup;
    int n;
    int m;
    if ((localObject != null) && (((aljs)localObject).jdField_a_of_type_AndroidViewView != null))
    {
      localObject = (ADView)((aljs)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131362236);
      localViewGroup = ((ADView)localObject).a(0);
      if (localViewGroup != null)
      {
        n = localViewGroup.getChildCount();
        m = 0;
        n -= 1;
        if (n >= 0)
        {
          View localView = localViewGroup.getChildAt(n);
          bdof localbdof = (bdof)localView.getTag();
          String str = localbdof.jdField_c_of_type_JavaLangString;
          int i1 = str.indexOf("|");
          if (bhgp.a(Long.parseLong(str.substring(0, i1)), Long.parseLong(str.substring(i1 + 1)))) {
            break label296;
          }
          ((ADView)localObject).a(0, n, localView);
          aqzw.a.b(localbdof.l);
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
          a(22, 0);
          a(-1, null);
          this.jdField_e_of_type_Boolean = false;
        }
        for (;;)
        {
          localObject = new aqzy(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), arry.jdField_a_of_type_JavaLangString);
          if (localObject != null)
          {
            ((aqzy)localObject).b();
            ((aqzy)localObject).c();
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
    a(44, 0);
    a(13, 0);
    a(15, 0);
    a(35, 0);
    a(36, 0);
    Object localObject = this.jdField_a_of_type_ArrayOfAljs[22];
    if ((localObject != null) && (((aljs)localObject).jdField_a_of_type_AndroidViewView != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((aljs)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131362237);
      localObject = (ADView)((aljs)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131362236);
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
    a(17, 0);
    this.h = true;
    this.i = false;
    this.jdField_e_of_type_JavaLangString = "";
    a(8, 0);
    a(18, 0);
    a(19, 0);
    a(24, 0);
    a(7, 0);
    a(21, 0);
    if (this.jdField_a_of_type_Almq != null) {
      this.jdField_a_of_type_Almq.g();
    }
    a(28, 0);
    a(30, 0);
    a(34, 0);
    a(33, 0);
    b();
    j();
    a(3, 0);
    bhiu.a().a();
    a(-1, null);
    a(false);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void f()
  {
    a(21, 0);
    a(-1, null);
    if (this.jdField_a_of_type_Almq != null) {
      this.jdField_a_of_type_Almq.f();
    }
  }
  
  public void g()
  {
    QLog.i("Q.recent.banner", 1, "onResume");
    if (this.jdField_a_of_type_Almq != null) {
      this.jdField_a_of_type_Almq.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter.checkBannerFromResume();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {}
    for (QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;; localQQAppInterface = null)
    {
      bhiu.a().a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      return;
    }
  }
  
  public void h()
  {
    aljs localaljs;
    if (this.jdField_a_of_type_ArrayOfAljs != null)
    {
      localaljs = this.jdField_a_of_type_ArrayOfAljs[21];
      if ((localaljs != null) && (localaljs.jdField_a_of_type_AndroidViewView != null) && (localaljs.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(localaljs.jdField_a_of_type_AndroidViewView);
        if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
          break label79;
        }
      }
    }
    label79:
    for (QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;; localQQAppInterface = null)
    {
      aljv.b(localQQAppInterface, localaljs.jdField_a_of_type_Int);
      localaljs.jdField_a_of_type_Boolean = false;
      localaljs.jdField_a_of_type_AndroidViewView = null;
      return;
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
      bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 17, 0, "", "", "", "");
      continue;
      a(17, 0);
      this.jdField_e_of_type_JavaLangString = "";
      a(17, paramMessage);
      continue;
      a(18, 0);
      a(18, paramMessage);
      continue;
      a(5, 2);
      a(5, paramMessage);
      continue;
      a(5, 0);
      a(5, paramMessage);
      continue;
      a(25, 0);
      a(25, paramMessage);
      continue;
      a(26, 0);
      a(26, paramMessage);
      continue;
      a(24, 2);
      a(24, paramMessage);
      continue;
      a(24, 0);
      a(24, paramMessage);
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
        a(30, 0);
        a(30, paramMessage);
        continue;
        a(31, 0);
        a(31, paramMessage);
        continue;
        a(32, 0);
        a(32, paramMessage);
        continue;
        a(34, 0);
        a(34, paramMessage);
        continue;
        a(27, 0);
        a(27, paramMessage);
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
    label83:
    int n;
    label85:
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if ((localQQAppInterface != null) && ((axan.a().c(localQQAppInterface, this.jdField_e_of_type_JavaLangString)) || (this.i)))
      {
        localList = localQQAppInterface.a().a().getRecentList(false);
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
          } while ((TextUtils.isEmpty(localRecentUser.uin)) || (axan.a().b(localQQAppInterface, localRecentUser.uin)) || (axan.a().a(localQQAppInterface, localRecentUser.uin) != 1));
          if (localQQAppInterface.a().a(localRecentUser.uin, localRecentUser.getType()) > 99)
          {
            if ((this.i) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_e_of_type_JavaLangString.equals(localRecentUser.uin))) {
              break;
            }
            this.jdField_e_of_type_JavaLangString = localRecentUser.uin;
            if ((!this.h) || (!axan.a().c(localQQAppInterface, this.jdField_e_of_type_JavaLangString))) {
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
    if (a(29))
    {
      a(29, 0);
      this.jdField_b_of_type_JavaLangString = null;
      a(-1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aljw
 * JD-Core Version:    0.7.0.1
 */