import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.Leba.1;
import com.tencent.mobileqq.activity.Leba.10;
import com.tencent.mobileqq.activity.Leba.18;
import com.tencent.mobileqq.activity.Leba.2;
import com.tencent.mobileqq.activity.Leba.20;
import com.tencent.mobileqq.activity.Leba.21;
import com.tencent.mobileqq.activity.Leba.22;
import com.tencent.mobileqq.activity.Leba.23;
import com.tencent.mobileqq.activity.Leba.24;
import com.tencent.mobileqq.activity.Leba.25;
import com.tencent.mobileqq.activity.Leba.26;
import com.tencent.mobileqq.activity.Leba.3;
import com.tencent.mobileqq.activity.Leba.33;
import com.tencent.mobileqq.activity.Leba.35;
import com.tencent.mobileqq.activity.Leba.38;
import com.tencent.mobileqq.activity.Leba.4;
import com.tencent.mobileqq.activity.Leba.5;
import com.tencent.mobileqq.activity.Leba.6;
import com.tencent.mobileqq.activity.Leba.7;
import com.tencent.mobileqq.activity.Leba.8;
import com.tencent.mobileqq.activity.Leba.9;
import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.apollo.lightGame.CmGameFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.sonic.SonicPreloadData;
import com.tencent.mobileqq.webview.sonic.SonicPreloader;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import tencent.im.oidb.qqshop.qqshop_code.SRsp;

public class abai
  extends ajii
  implements abbf, afqf, View.OnClickListener, ViewStub.OnInflateListener, begh
{
  public static int a;
  static long jdField_b_of_type_Long;
  private static List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  private static List<String> jdField_d_of_type_JavaUtilList = new ArrayList();
  private static List<String> jdField_e_of_type_JavaUtilList = new ArrayList();
  protected final long a;
  private abbj jdField_a_of_type_Abbj;
  public aiba a;
  private ajfo jdField_a_of_type_Ajfo = new abay(this);
  ajjh jdField_a_of_type_Ajjh = new abaw(this);
  private ajpe jdField_a_of_type_Ajpe = new abav(this);
  private akfr jdField_a_of_type_Akfr = new abau(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new abak(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageSwitcher jdField_a_of_type_AndroidWidgetImageSwitcher;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anoj jdField_a_of_type_Anoj = new abaz(this);
  private aqeb jdField_a_of_type_Aqeb = new aqeb("qzone_leba", "com.tencent.mobileqq:qzone");
  private aquq jdField_a_of_type_Aquq;
  asde jdField_a_of_type_Asde = new abax(this);
  private atdh jdField_a_of_type_Atdh = new abat(this);
  private atdi jdField_a_of_type_Atdi = new abas(this);
  private atdk jdField_a_of_type_Atdk = new abar(this);
  public beez a;
  behi jdField_a_of_type_Behi = new abap(this);
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new abaj(this);
  FPSXListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
  protected TimerTaskManager a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private Runnable jdField_a_of_type_JavaLangRunnable = new Leba.1(this);
  protected final String a;
  protected List<HotWordSearchEntryDataModel.HotSearchItem> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManagerV2.getSubThreadLooper());
  qqshop_code.SRsp jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 1;
  private View jdField_b_of_type_AndroidViewView;
  private ImageSwitcher jdField_b_of_type_AndroidWidgetImageSwitcher;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private aqeb jdField_b_of_type_Aqeb = new aqeb("web_leba", "com.tencent.mobileqq:tool");
  private List<amnq> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = true;
  private long jdField_d_of_type_Long;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g = true;
  
  static
  {
    jdField_c_of_type_JavaUtilList.add("jiankang.qq.com");
    jdField_c_of_type_JavaUtilList.add("guahao.com");
    jdField_c_of_type_JavaUtilList.add("91160.com");
    jdField_d_of_type_JavaUtilList.add("m.gamecenter.qq.com");
    jdField_d_of_type_JavaUtilList.add("web.gamecenter.qq.com");
    jdField_d_of_type_JavaUtilList.add("imgcache.qq.com");
    jdField_d_of_type_JavaUtilList.add("imgcache.gtimg.cn");
    jdField_d_of_type_JavaUtilList.add("youxi.vip.qq.com");
    jdField_e_of_type_JavaUtilList.add("cdn.vip.qq.com");
    jdField_e_of_type_JavaUtilList.add("comic.vip.qq.com");
    jdField_e_of_type_JavaUtilList.add("reader.sh.vip.qq.com");
    jdField_e_of_type_JavaUtilList.add("ac.tc.qq.com");
    jdField_e_of_type_JavaUtilList.add("img-qq.ac.qq.com");
  }
  
  public abai()
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager = arfd.a();
    this.jdField_a_of_type_JavaLangString = ("mobileMP" + System.currentTimeMillis());
    this.jdField_a_of_type_Long = 30000L;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Beez = new beez(this.jdField_a_of_type_AndroidOsHandler$Callback);
  }
  
  private void C()
  {
    if (QSecFramework.a().a(1001).booleanValue()) {
      QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(81), Integer.valueOf(1), Integer.valueOf(6), "nearbyClick1", null }, null);
    }
    long l1 = System.currentTimeMillis();
    long l2 = Math.abs(l1 - jdField_b_of_type_Long);
    if ((l2 >= 0L) && (l2 < 2000L)) {
      return;
    }
    jdField_b_of_type_Long = l1;
    Object localObject3 = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    Object localObject2 = ((auqh)localObject3).a(String.valueOf(100510));
    ((atax)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160)).a(100510);
    afqa.jdField_a_of_type_Int |= 0x1;
    Object localObject1 = ((auqh)localObject3).a("100510.100517");
    if (((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.has()) {}
    int i;
    for (localObject1 = ((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get();; localObject1 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.i("toplist_rank", 2, "god buffer: " + (String)localObject1);
      }
      if ((!((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.has()) || (!((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.has())) {
        break label1054;
      }
      Object localObject4 = ((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.get();
      if ((localObject4 == null) || (((List)localObject4).size() <= 0)) {
        break label1054;
      }
      localObject4 = ((List)localObject4).iterator();
      for (i = 2; ((Iterator)localObject4).hasNext(); i = 1) {
        if (((BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject4).next()).red_type.get() != 3) {
          break label1051;
        }
      }
    }
    for (;;)
    {
      ((auqh)localObject3).b("100510.100517");
      localObject3 = (mmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43);
      ((mmr)localObject3).a(60);
      ((mmr)localObject3).a(59);
      localObject3 = (mmy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
      if ((((mmy)localObject3).a()) && (this.jdField_c_of_type_Int != 0)) {
        ThreadManagerV2.excute(new Leba.22(this, (ascz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
      }
      ((mmy)localObject3).a(false);
      int j = this.jdField_a_of_type_Aiba.jdField_b_of_type_Int;
      this.jdField_a_of_type_Beez.post(new Leba.23(this));
      ThreadManagerV2.excute(new Leba.24(this, (ascz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
      boolean bool;
      if ((((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.has()) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1))
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.i("msg0x210.SubMsgType0x6f", 2, "Nearby item is clicked zan rotTouch is display");
        }
        awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005247", "0X8005247", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          asfl.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        }
        aseo.b(0);
        if (!asfc.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
        {
          localObject2 = new Intent(a(), NearbyActivity.class);
          ((Intent)localObject2).putExtra("ENTER_TIME", System.currentTimeMillis());
          ((Intent)localObject2).putExtra("IS_HAS_REDTOUCH", bool);
          ((Intent)localObject2).putExtra("FROM_WHERE", 0);
          ((Intent)localObject2).putExtra("RANK_BANNER_PUSH", (String)localObject1);
          ((Intent)localObject2).putExtra("NEARBY_IS_HAS_ICON", i);
          if ((j == 56) || (j == 57)) {
            ((Intent)localObject2).putExtra("nearby_main_init_tab", 1);
          }
          NearbyFakeActivity.a(a(), (Intent)localObject2);
          if (j != 59) {
            break label881;
          }
          new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("like_clk_red").a();
        }
        for (;;)
        {
          asdc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j);
          if (bool) {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "new_thing", "clk_red", 0, 0, "", "", "", "");
          }
          ohp.a().a("FuJin", bool);
          return;
          localObject2 = new Intent(a(), NearbyGuideActivity.class);
          ((Intent)localObject2).putExtra("ENTER_TIME", System.currentTimeMillis());
          ((Intent)localObject2).putExtra("IS_HAS_REDTOUCH", bool);
          ((Intent)localObject2).putExtra("FROM_WHERE", 0);
          ((Intent)localObject2).putExtra("RANK_BANNER_PUSH", (String)localObject1);
          ((Intent)localObject2).putExtra("NEARBY_IS_HAS_ICON", i);
          a().startActivity((Intent)localObject2);
          break;
          label881:
          if (j == 60)
          {
            localObject1 = ((mmy)localObject3).a(60);
            if ((localObject1 != null) && (((oidb_0x791.RedDotInfo)localObject1).uint64_cmd_uin.get() == 1822701914L)) {
              new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("assist_clk_red").a();
            } else {
              new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("c2c_clk_red").a();
            }
          }
          else if (j == 61)
          {
            new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("paried_clk_red").a();
          }
        }
        bool = false;
      }
      label1051:
      break;
      label1054:
      i = 2;
    }
  }
  
  private void D()
  {
    if ((a() != null) && (a().app != null))
    {
      aroj localaroj = (aroj)a().app.getManager(10);
      if (localaroj != null)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.leba", 2, "getQzoneUnread by tab resume.");
          }
          localaroj.a(3);
        }
        localaroj.a(false);
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void E()
  {
    afqa.a().jdField_a_of_type_Boolean = true;
    ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b("100600");
    a(new Intent(a(), LebaListMgrActivity.class));
  }
  
  private void F()
  {
    G();
    this.jdField_a_of_type_Beez.sendEmptyMessageDelayed(1134006, 200L);
    H();
    if ((this.jdField_a_of_type_Aiba != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Aiba.notifyDataSetChanged();
    }
  }
  
  private void G()
  {
    ThreadManager.post(new Leba.35(this), 5, null, false);
  }
  
  private void H()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a("100600");
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(53).d(10).a().a(localAppInfo);
    a(localAppInfo);
  }
  
  private void I()
  {
    Object localObject = (mmy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
    if (localObject != null)
    {
      oidb_0x791.RedDotInfo localRedDotInfo = ((mmy)localObject).a(1);
      if (localRedDotInfo != null) {
        mmr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedDotInfo);
      }
      localObject = ((mmy)localObject).a(6);
      if (localObject != null) {
        mmr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (oidb_0x791.RedDotInfo)localObject);
      }
    }
  }
  
  private void J()
  {
    this.jdField_a_of_type_JavaUtilSet.add("com.tx.gamecenter.android");
    this.jdField_a_of_type_JavaUtilSet.add("com.android.music");
    this.jdField_a_of_type_JavaUtilSet.add("com.qq.yijianfankui");
    this.jdField_a_of_type_JavaUtilSet.add("com.life.android");
    this.jdField_a_of_type_JavaUtilSet.add("com.tencent.citylife.android");
    this.jdField_a_of_type_JavaUtilSet.add("com.tx.android.txnews.new2");
    this.jdField_a_of_type_JavaUtilSet.add("com.tencent.Health");
    this.jdField_a_of_type_JavaUtilSet.add("com.android.ketang");
    this.jdField_a_of_type_JavaUtilSet.add("com.tencent.zhibojian");
    this.jdField_a_of_type_JavaUtilSet.add("qzone_feedlist");
  }
  
  private amnq a()
  {
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        amnq localamnq = (amnq)localIterator.next();
        if ((localamnq != null) && (localamnq.a != null) && (localamnq.a.strPkgName != null) && (localamnq.a.strResName != null) && ((localamnq.a.strPkgName.equals("com.tx.gamecenter.android")) || (localamnq.a.strResName.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131627284))))) {
          return localamnq;
        }
      }
    }
    return null;
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramAppInfo);
  }
  
  private String b()
  {
    Object localObject2 = bant.a("vipGameCenter");
    Object localObject1 = localObject2;
    Object localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = a();
      localObject1 = localObject2;
      if (localObject3 != null) {
        if (((amnq)localObject3).a == null) {
          break label91;
        }
      }
    }
    label91:
    for (localObject1 = ((amnq)localObject3).a.strGotoUrl;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = bade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject1);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject1 = ((bacn)localObject3).b("url");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          localObject2 = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393";
        }
      }
      return localObject2;
    }
    try
    {
      localObject1 = URLDecoder.decode((String)localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393";
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a == null)) {
      return;
    }
    WebProcessManager.c(true);
    t();
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_trends_tab", 0, 0, "", "", "", "");
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "trends_tab_exp", 2, 0, "", "", "", "");
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a();
    LebaPluginInfo localLebaPluginInfo;
    if (localList != null)
    {
      int i = 0;
      if (i < localList.size())
      {
        localLebaPluginInfo = (LebaPluginInfo)localList.get(i);
        if (localLebaPluginInfo == null) {}
        while ((TextUtils.isEmpty(localLebaPluginInfo.strPkgName)) || (!localLebaPluginInfo.strPkgName.equals("m.tx.apphelper.android")))
        {
          i += 1;
          break;
        }
      }
    }
    for (long l = localLebaPluginInfo.uiResId;; l = 0L)
    {
      ThreadManager.postImmediately(new Leba.7(this, l), null, false);
      r();
      return;
    }
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "preloadWebProcess");
    }
    WebProcessManager localWebProcessManager = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    if (localWebProcessManager == null) {
      return;
    }
    if (localWebProcessManager.d()) {
      localWebProcessManager.a(202);
    }
    u();
  }
  
  private void u()
  {
    ThreadManager.executeOnSubThread(new Leba.8(this));
  }
  
  private void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "preloadForGameCenter");
    }
    if (!SonicPreloader.isWifiOrG3OrG4())
    {
      QLog.d("Q.lebatab.leba", 1, "preloadForGameCenter, net type not match, abort");
      return;
    }
    String str = b();
    if (TextUtils.isEmpty(str))
    {
      QLog.e("Q.lebatab.leba", 1, "preloadForGameCenter, gameCenterUrl null");
      return;
    }
    long l2 = System.currentTimeMillis();
    Object localObject1 = a();
    if ((localObject1 != null) && (((amnq)localObject1).a != null)) {}
    for (long l1 = ((amnq)localObject1).a.uiResId;; l1 = 489L)
    {
      localObject1 = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      Object localObject2 = ((auqh)localObject1).a("200010.200011");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((auqh)localObject1).a(String.valueOf(l1));
      Object localObject3 = SonicPreloader.getSonicPreloadDataList((BusinessInfoCheckUpdate.AppInfo)localObject2, 0);
      SparseArray localSparseArray = SonicPreloader.getSonicPreloadDataList(localAppInfo, 1002);
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int i;
      if ((localObject3 != null) && (((SparseArray)localObject3).size() > 0))
      {
        i = 0;
        if (i < ((SparseArray)localObject3).size())
        {
          SonicPreloadData localSonicPreloadData = (SonicPreloadData)((SparseArray)localObject3).valueAt(i);
          if (localSonicPreloadData.id != 1002) {
            break label370;
          }
          localSonicPreloadData.url = str;
          ((ArrayList)localObject2).add(localSonicPreloadData);
        }
      }
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        localObject3 = (SonicPreloadData)localSparseArray.valueAt(0);
        ((SonicPreloadData)localObject3).url = str;
        localArrayList.add(localObject3);
      }
      localObject3 = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (((WebProcessManager)localObject3).a((ArrayList)localObject2)) {
        ((auqh)localObject1).b(String.valueOf("200010.200011"));
      }
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        if (((WebProcessManager)localObject3).a(localArrayList)) {
          localAppInfo.preload_ts.set(System.currentTimeMillis());
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label427;
        }
        QLog.d("Q.lebatab.leba", 2, "preloadForGameCenter cost:" + (System.currentTimeMillis() - l2));
        return;
        label370:
        i += 1;
        break;
        QLog.d("Q.lebatab.leba", 1, new Object[] { "preload for gamecenter, gameCenterUrl=", str });
        localArrayList.add(new SonicPreloadData(0, str, true, 0L, 1));
        ((WebProcessManager)localObject3).a(localArrayList);
      }
      label427:
      break;
    }
  }
  
  private void w()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131311626));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131311553));
    IphoneTitleBarActivity.setLayerType((ViewGroup)a(2131309578));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131303421));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131302847));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131654138);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131302816));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (awnu.a()) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a(), this.jdField_b_of_type_AndroidWidgetImageView).a(53).d(10).a();
    H();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      awnu.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130848801);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131101257));
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Atdk);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Atdi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Atdh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akfr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajpe);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajfo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Asde);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anoj);
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = ((FPSXListView)a(2131303423));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131303414));
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setActTAG("actFPSLeba");
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setReportType(2);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setNeedCheckSpringback(true);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverscrollHeader(a().getDrawable(2130848905));
      }
    }
    else
    {
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      if (this.jdField_a_of_type_Aiba != null) {
        break label766;
      }
      this.jdField_a_of_type_Aiba = new aiba(a(), this.jdField_b_of_type_JavaUtilList, 2131493421, 2131493422, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, new abal(this));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null)
      {
        if (this.jdField_b_of_type_AndroidViewView == null)
        {
          this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131495236, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, false);
          this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131308401);
          ImageView localImageView = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131303476);
          if ((localImageView instanceof ThemeImageView)) {
            ((ThemeImageView)localImageView).setMaskShape(beog.jdField_c_of_type_Int);
          }
          localImageView.setImageResource(2130844406);
          this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130839104);
          ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131303477)).setText(2131654130);
          this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131308403));
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131308447));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131308592));
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131308926));
          this.jdField_a_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_b_of_type_AndroidViewView.findViewById(2131308404));
          this.jdField_a_of_type_AndroidWidgetImageSwitcher.setFactory(new abam(this));
          this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131308416));
          this.jdField_b_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_b_of_type_AndroidViewView.findViewById(2131308405));
          this.jdField_b_of_type_AndroidWidgetImageSwitcher.setFactory(new aban(this));
          this.jdField_a_of_type_Abbj = new abbj(this.jdField_a_of_type_AndroidWidgetImageSwitcher, this.jdField_b_of_type_AndroidWidgetImageSwitcher, this.jdField_d_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Beez, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131309736));
          }
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131303413));
          this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131300167));
          this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
          azve.a(this.jdField_a_of_type_AndroidWidgetEditText, a(2131625586));
          this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131312509));
          this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297934));
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.f = BaseApplicationImpl.sApplication.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("has_search_bar", false);
          k();
          this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new abao(this));
          if (AppSetting.jdField_c_of_type_Boolean) {
            azve.b(this.jdField_b_of_type_AndroidViewView);
          }
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
          ajjy.a(2131654130);
          azve.b(this.jdField_c_of_type_AndroidViewView, Button.class.getName());
        }
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setAdapter(this.jdField_a_of_type_Aiba);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOnItemClickListener(this.jdField_a_of_type_Behi);
      }
      if (this.jdField_a_of_type_Aquq == null)
      {
        this.jdField_a_of_type_Aquq = new aquq(a());
        this.jdField_a_of_type_Aquq.a(this.jdField_a_of_type_AndroidViewView);
        int i = a().getTitleBarHeight();
        int j = (int)bacc.a(a(), 5.0F);
        this.jdField_a_of_type_Aquq.b();
        this.jdField_a_of_type_Aquq.a(i - j);
      }
      o();
      return;
      label766:
      this.jdField_a_of_type_Aiba.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Aiba.a(this.jdField_b_of_type_JavaUtilList);
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131493617, null);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected String a()
  {
    return ajjy.a(2131640213);
  }
  
  protected void a()
  {
    super.a();
    k();
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onAccountChanged");
    }
    if (this.jdField_a_of_type_Abbj != null) {
      this.jdField_a_of_type_Abbj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    afqa.a().a();
    F();
    if (this.jdField_a_of_type_Aquq != null) {
      this.jdField_a_of_type_Aquq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(int paramInt, String paramString, Drawable paramDrawable, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "onIconDownload, status=" + paramInt + ", url=" + paramString);
    }
    if ((paramInt != 2) || (paramDrawable == null) || (paramVarArgs == null) || (paramVarArgs.length < 1)) {}
    while ((paramVarArgs[0] == null) || (!(paramVarArgs[0] instanceof Integer))) {
      return;
    }
    ((Integer)paramVarArgs[0]).intValue();
  }
  
  protected void a(amnq paramamnq, BusinessInfoCheckUpdate.AppInfo paramAppInfo, auqh paramauqh)
  {
    if ((paramamnq.a != null) && (paramamnq.a.uiResId > 0L))
    {
      paramauqh = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      String str = String.valueOf(paramamnq.a.uiResId);
      if ((paramAppInfo != null) && (paramauqh != null) && (paramauqh.a(str))) {
        ThreadManager.getFileThreadHandler().post(new Leba.25(this, str, paramAppInfo));
      }
      if (paramamnq.a.strPkgName.equals(bbfu.jdField_a_of_type_JavaLangString)) {
        ThreadManager.post(new Leba.26(this), 5, null, false);
      }
      if (paramamnq.a.uiResId == 7759L) {
        alyc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, "" + paramamnq.a.uiResId, "", "", "");
    }
  }
  
  void a(Message paramMessage)
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramMessage == null)) {}
    for (;;)
    {
      return;
      ngh localngh = (ngh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      String str1 = String.valueOf(System.currentTimeMillis() - this.jdField_c_of_type_Long);
      try
      {
        paramMessage = (qqshop_code.SRsp)paramMessage.obj;
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
        String str3 = paramMessage.auth_code.get();
        if (str3 == null) {
          return;
        }
        str3 = befm.a(str2, "code", paramMessage.auth_code.get());
        this.jdField_a_of_type_AndroidContentIntent.putExtra("url", str3);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (QLog.isColorLevel()) {
            QLog.i("AuthCode", 2, "newUrl:" + str3);
          }
          a(this.jdField_a_of_type_AndroidContentIntent);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          a(str2);
          if (localngh != null) {
            localngh.a(134246777, null, "jump", str1, "hascode", 0L, false);
          }
        }
        for (;;)
        {
          return;
          if (localngh != null) {
            localngh.a(134246777, null, "not_jump", str1, "", 0L, false);
          }
          this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp = paramMessage;
        }
      }
      catch (Exception paramMessage)
      {
        QLog.e("AuthCode", 1, "authcode resp exception:" + paramMessage);
        return;
      }
      finally
      {
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (localngh != null) {
            localngh.a(134246777, null, "jump", str1, "no_code", 0L, false);
          }
          a(this.jdField_a_of_type_AndroidContentIntent);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        }
      }
    }
  }
  
  void a(View paramView, int paramInt)
  {
    amnq localamnq = (amnq)this.jdField_a_of_type_Aiba.getItem(paramInt);
    if (localamnq == null) {
      return;
    }
    localamnq.a.strGotoUrl = ajlh.jdField_a_of_type_JavaLangString;
    String str = baig.c(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (!TextUtils.isEmpty(str)) {
      localamnq.a.strGotoUrl = str.trim();
    }
    if (QLog.isColorLevel()) {
      QLog.i("enterXQBL", 2, "跳转url = " + localamnq.a.strGotoUrl);
    }
    a(paramView, paramInt, null);
    I();
    awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484A", "0X800484A", 0, 0, "", "", "", "");
  }
  
  public void a(View paramView, int paramInt, amnq paramamnq)
  {
    amnq localamnq = null;
    if ((paramInt == -1) && (paramamnq != null)) {
      localamnq = paramamnq;
    }
    while ((localamnq == null) || (localamnq.a == null))
    {
      QLog.i("Q.lebatab.leba", 2, "item == null || item.info == null");
      return;
      if (paramInt >= 0) {
        localamnq = (amnq)this.jdField_a_of_type_Aiba.getItem(paramInt);
      }
    }
    a(localamnq.a.strResName, new abaq(this, paramView, paramInt, paramamnq));
  }
  
  void a(String paramString)
  {
    ((baot)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).c(paramString);
    this.jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, abbc paramabbc)
  {
    if (paramabbc == null) {
      return;
    }
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramabbc.a();
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("Q.lebatab.leba", 1, paramString, new Object[0]);
      paramabbc.a();
      return;
    }
    String str1;
    int i;
    if (paramString.equals(a().getString(2131628102)))
    {
      str1 = a().getString(2131628099);
      paramString = a().getString(2131628104);
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        SharedPreferences localSharedPreferences = a().getSharedPreferences("laba_and_qwallet_check_enter", 4);
        if (localSharedPreferences != null)
        {
          String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          str2 = bcdt.a("check_app_exemption__" + str2 + "_" + paramString);
          boolean bool = localSharedPreferences.getBoolean(str2, false);
          QLog.i("Q.lebatab.leba", 2, "checkEnterApp..checkKey:" + str2 + ",hasCheck:" + bool + "，checkName：" + paramString);
          if (!bool)
          {
            a(new Leba.38(this, str1, localSharedPreferences, str2, paramabbc));
            return;
            if (paramString.equals(a().getString(2131628101)))
            {
              str1 = a().getString(2131628098);
              paramString = a().getString(2131628103);
              i = 1;
              continue;
            }
            if (!paramString.equals(a().getString(2131628100))) {
              break label320;
            }
            str1 = a().getString(2131628097);
            i = 1;
            continue;
          }
        }
      }
      paramabbc.a();
      return;
      label320:
      paramString = null;
      str1 = null;
      i = 0;
    }
  }
  
  protected void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onLogout");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ohp.a().a(3, paramBoolean);
    this.jdField_a_of_type_Beez.postDelayed(new Leba.9(this, paramBoolean), 150L);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onSwitchOutofLeba");
    }
  }
  
  public void b(View paramView, int paramInt, amnq paramamnq)
  {
    if ((paramInt == -1) && (paramamnq != null)) {}
    for (;;)
    {
      if ((paramamnq == null) || (paramamnq.a == null))
      {
        return;
        if (paramInt >= 0) {
          paramamnq = (amnq)this.jdField_a_of_type_Aiba.getItem(paramInt);
        }
      }
      else
      {
        Object localObject1 = paramamnq.a.strGotoUrl;
        if ("com.cmshow.game.android".equals(paramamnq.a.strPkgName)) {
          bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_tab_game", 0, 0, new String[0]);
        }
        String str1 = paramamnq.a.strResName;
        int i = paramamnq.a.sResSubType;
        boolean bool3 = false;
        boolean bool1 = false;
        if ((paramView != null) && ((paramView instanceof RedTouch))) {}
        for (boolean bool2 = ((RedTouch)paramView).a();; bool2 = false)
        {
          Object localObject2;
          Object localObject4;
          int j;
          if ((paramamnq.a.strPkgName.equals("com.tx.gamecenter.android")) || (paramamnq.a.strResName.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131627284))))
          {
            paramView = bant.a("vipGameCenter");
            if (TextUtils.isEmpty(paramView))
            {
              paramView = paramamnq.a.strGotoUrl;
              QLog.d("Q.lebatab.leba", 1, "clickAction gamecenter use plugin info url=" + paramView);
              if (!bool2) {
                break label3582;
              }
              localObject2 = "-1";
              localObject4 = ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf(paramamnq.a.uiResId)).missions.get();
              localObject1 = localObject2;
              if (localObject4 == null) {
                break label426;
              }
              localObject1 = localObject2;
              if (((List)localObject4).size() <= 0) {
                break label426;
              }
              localObject1 = "-1";
              j = 0;
              label299:
              if (j >= ((List)localObject4).size()) {
                break label426;
              }
              if (j != 0) {
                break label385;
              }
            }
            label385:
            for (localObject1 = (String)((List)localObject4).get(j);; localObject1 = (String)localObject1 + "_" + (String)((List)localObject4).get(j))
            {
              j += 1;
              break label299;
              if (paramView.startsWith("http")) {
                i = 0;
              }
              for (;;)
              {
                QLog.d("Q.lebatab.leba", 2, "clickAction gamecenter use IndividuationUrl url=" + paramView);
                break;
              }
            }
            label426:
            if (i == 0)
            {
              paramView = paramView + "&missions=" + (String)localObject1;
              label457:
              QLog.i("Q.lebatab.leba", 1, "[dealGameCenterUrl] add redPointId :" + paramView);
            }
          }
          for (;;)
          {
            if (paramInt == -1) {
              if (paramamnq != null)
              {
                if (paramamnq.a.uiResId != 0L) {
                  break label3573;
                }
                if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
                  break label1129;
                }
                bool1 = true;
              }
            }
            label525:
            label541:
            label951:
            label3516:
            label3528:
            label3531:
            label3534:
            label3541:
            for (;;)
            {
              ohp.a().b((int)paramamnq.a.uiResId, bool1);
              if (QLog.isColorLevel()) {
                QLog.d("Q.lebatab.leba", 2, "clickAction.name=" + str1 + ",url=" + paramView + ",type=" + i);
              }
              auqh localauqh = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
              BusinessInfoCheckUpdate.AppInfo localAppInfo = localauqh.a(paramamnq.a.uiResId + "");
              if ((paramamnq.a != null) && (paramamnq.a.uiResId > 0L)) {
                if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
                {
                  paramView = bfvl.a(paramView, localAppInfo);
                  if (localAppInfo.type.get() == 0) {
                    bool1 = true;
                  }
                  if (!paramamnq.a.strPkgName.equals("com.tx.gamecenter.android"))
                  {
                    bool2 = bool1;
                    if (!paramamnq.a.strResName.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131627284))) {}
                  }
                  else
                  {
                    bool2 = bool1 | true;
                  }
                  new ArrayList();
                  if ((localAppInfo.red_display_info == null) || (localAppInfo.red_display_info.red_type_info == null)) {
                    break label3567;
                  }
                  localObject1 = localAppInfo.red_display_info.red_type_info.get();
                  if ((localObject1 == null) || (((List)localObject1).size() < 2)) {
                    break label3567;
                  }
                }
              }
              label987:
              label1129:
              label1259:
              label3181:
              label3567:
              for (j = ((BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject1).get(1)).red_type.get();; j = 0)
              {
                int k = localAppInfo.num.get();
                localObject1 = "status=" + j + "&number=" + k + "&path=" + localAppInfo.path.get();
                bool1 = bool2;
                label894:
                localObject2 = (awcl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
                if (localObject2 != null) {
                  if (((awcl)localObject2).a(paramamnq.a.uiResId + "") != -1)
                  {
                    bool3 = true;
                    if (paramInt != -1) {
                      break label1259;
                    }
                    localauqh.b(paramamnq.a.uiResId + "");
                    bool2 = bool3;
                    if (bool3) {
                      a(new Leba.20(this));
                    }
                  }
                }
                for (bool2 = bool3;; bool2 = false)
                {
                  paramInt = k;
                  localObject2 = paramView;
                  paramView = (View)localObject1;
                  localObject1 = localObject2;
                  for (;;)
                  {
                    if ((localObject1 == null) || ("".equals(localObject1)))
                    {
                      a(paramamnq, localAppInfo, localauqh);
                      return;
                      if (i != 2) {
                        break label3579;
                      }
                      localObject2 = bade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramView).b("url");
                      paramView = paramView.replace((CharSequence)localObject2, (String)localObject2 + URLEncoder.encode(new StringBuilder().append("&missions=").append((String)localObject1).toString()));
                      break label457;
                      bool1 = false;
                      break label525;
                      if (paramamnq == null) {
                        break label541;
                      }
                      ohp.a().b((int)paramamnq.a.uiResId, bool2);
                      bool1 = bool3;
                      if ("com.tx.xingqubuluo.android".equals(paramamnq.a.strPkgName)) {
                        bool1 = bool2;
                      }
                      if (paramamnq.a.uiResId != 7966L) {
                        break label541;
                      }
                      bool1 = bool2;
                      break label541;
                      localObject1 = "status=" + -1 + "&number=0" + "&path=" + paramamnq.a.uiResId;
                      k = 0;
                      j = 0;
                      break label894;
                      bool3 = false;
                      break label951;
                      localauqh.a((int)paramamnq.a.uiResId, 31);
                      break label987;
                      if ((paramamnq.a == null) || (!paramamnq.a.strPkgName.equals("qzone_feedlist"))) {
                        break label3541;
                      }
                      localObject1 = (awcz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
                      if ((localObject1 == null) || ((((awcz)localObject1).a(2) <= 0) && (((awcz)localObject1).a(1) <= 0))) {
                        break label3541;
                      }
                      j = 0;
                      localObject2 = null;
                      bool2 = true;
                      paramInt = 0;
                      localObject1 = paramView;
                      paramView = (View)localObject2;
                      continue;
                    }
                    String str2 = (String)aqup.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramamnq.a.uiResId));
                    if (i == 0) {
                      if (!((String)localObject1).contains("plg_uin=1")) {
                        break label3534;
                      }
                    }
                    for (localObject2 = (String)localObject1 + "&mqquin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; localObject3 = localObject1)
                    {
                      localObject1 = localObject2;
                      if (((String)localObject2).contains("plg_vkey=1")) {
                        localObject1 = (String)localObject2 + "&mqqvkey=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
                      }
                      localObject4 = new Intent(a(), QQBrowserActivity.class);
                      if (((String)localObject1).contains("plg_nld=1")) {
                        ((Intent)localObject4).putExtra("reportNld", true);
                      }
                      localObject2 = localObject1;
                      if (!TextUtils.isEmpty(paramView))
                      {
                        ((Intent)localObject4).putExtra("redTouch", paramView);
                        localObject2 = localObject1;
                        if (((String)localObject1).contains("red_touch=1")) {
                          localObject2 = (String)localObject1 + "&" + paramView;
                        }
                      }
                      this.jdField_b_of_type_Aqeb.b();
                      ((Intent)localObject4).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                      ((Intent)localObject4).putExtra("plugin_start_time", System.nanoTime());
                      ((Intent)localObject4).putExtra("click_start_time", System.currentTimeMillis());
                      ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
                      ((Intent)localObject4).putExtra("is_from_leba", true);
                      ((Intent)localObject4).putExtra("leba_resid", paramamnq.a.uiResId);
                      ((Intent)localObject4).putExtra("has_red_dot", bool1);
                      ((Intent)localObject4).putExtra("url", (String)localObject2);
                      if (!TextUtils.isEmpty(str2)) {
                        ((Intent)localObject4).putExtra("big_brother_source_key", str2);
                      }
                      if ((paramamnq.a.uiResId == 3053L) && (((String)localObject2).indexOf("fetchCode=1") > -1))
                      {
                        long l = NetConnInfoCenter.getServerTime();
                        if ((this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp != null) && (this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get() > l))
                        {
                          if (QLog.isColorLevel()) {
                            QLog.i("AuthCode", 2, "use cache:" + this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get());
                          }
                          ((Intent)localObject4).putExtra("url", befm.a((String)localObject2, "code", this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.auth_code.get()));
                          a((Intent)localObject4);
                          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
                          a(paramamnq.a.strGotoUrl);
                          paramView = (ngh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
                          if (paramView != null) {
                            paramView.a(134246777, null, "jump", "use_cache", "hascode", 0L, false);
                          }
                        }
                        for (;;)
                        {
                          awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, "" + paramamnq.a.uiResId, "", "", "");
                          return;
                          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
                          this.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject4);
                          a(paramamnq.a.strGotoUrl);
                          this.jdField_a_of_type_Beez.sendEmptyMessageDelayed(1134007, 1000L);
                        }
                      }
                      if (paramamnq.a.uiResId == 5647L)
                      {
                        if (!((String)localObject2).contains("?"))
                        {
                          paramView = (String)localObject2 + "?hasRedDot=" + bool1;
                          if ((!bool1) || (localAppInfo == null)) {
                            break label3531;
                          }
                          localObject1 = new StringBuilder();
                          localObject2 = localAppInfo.missions.get();
                          if (((List)localObject2).size() <= 0) {
                            break label2185;
                          }
                          paramInt = 0;
                          if (paramInt >= ((List)localObject2).size()) {
                            break label2185;
                          }
                          if (paramInt != ((List)localObject2).size() - 1) {
                            break label2159;
                          }
                          ((StringBuilder)localObject1).append((String)((List)localObject2).get(paramInt));
                        }
                        for (;;)
                        {
                          paramInt += 1;
                          break label2081;
                          paramView = (String)localObject2 + "&hasRedDot=" + bool1;
                          break;
                          label2159:
                          ((StringBuilder)localObject1).append((String)((List)localObject2).get(paramInt)).append("_");
                        }
                        paramView = paramView + "&missions=" + ((StringBuilder)localObject1).toString();
                      }
                      for (;;)
                      {
                        ((Intent)localObject4).putExtra("url", paramView);
                        if ("com.cmshow.game.android".equals(paramamnq.a.strPkgName))
                        {
                          ((Intent)localObject4).putExtra("fragment_class", CmGameFragment.class.getCanonicalName());
                          ((Intent)localObject4).putExtra("hide_operation_bar", true);
                          ((Intent)localObject4).putExtra("hide_more_button", true);
                          ((Intent)localObject4).putExtra("portraitOnly", true);
                        }
                        a((Intent)localObject4);
                        do
                        {
                          a(paramamnq, localAppInfo, localauqh);
                          if ((paramamnq.a.strPkgName.equalsIgnoreCase("com.tx.gamecenter.android")) || (paramamnq.a.strResName.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131627284)))) {
                            awrn.a(a()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Game_center", "Clk_game_in", 0, 1, "0", null, null, null, null);
                          }
                          a(new Leba.21(this));
                          if (paramamnq.a.strPkgName.equals("qzone_feedlist")) {
                            break;
                          }
                          this.jdField_a_of_type_Boolean = true;
                          return;
                        } while (i != 2);
                        localObject4 = bade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject1);
                        if (localObject4 != null)
                        {
                          if ((!paramamnq.a.strPkgName.equals("com.tx.gamecenter.android")) && (!paramamnq.a.strResName.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131627284)))) {
                            break label2848;
                          }
                          ((bacn)localObject4).d("platformId=qq_m");
                          localObject2 = localObject4;
                        }
                        do
                        {
                          for (;;)
                          {
                            ((bacn)localObject2).a("from_leba", "fromleba");
                            ((bacn)localObject2).a("leba_resid", String.valueOf(paramamnq.a.uiResId));
                            ((bacn)localObject2).a("config_res_plugin_item_name", str1);
                            ((bacn)localObject2).a("redtouch_click_timestamp", String.valueOf((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)));
                            ((bacn)localObject2).a(bool2);
                            ((bacn)localObject2).b(paramamnq.a.strPkgName);
                            ((bacn)localObject2).e(paramView);
                            ((bacn)localObject2).b(bool1);
                            ((bacn)localObject2).a(localAppInfo);
                            if (!TextUtils.isEmpty(str2)) {
                              ((bacn)localObject2).a("download_sourceid", str2);
                            }
                            if ((paramamnq.a.uiResId != 8059L) || (!MiniAppLauncher.isMiniAppUrl((String)localObject1))) {
                              break label3516;
                            }
                            MiniAppLauncher.startMiniApp(a(), (String)localObject1, 2050, null);
                            befe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramamnq, j, paramInt);
                            if (this.jdField_a_of_type_JavaUtilSet.contains(paramamnq.a.strPkgName)) {
                              this.jdField_b_of_type_Aqeb.b();
                            }
                            if (!paramamnq.a.strPkgName.equals("qzone_feedlist")) {
                              break;
                            }
                            awrv.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                            awrv.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                            this.jdField_a_of_type_Aqeb.b();
                            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 2, 0, "", "", "", "");
                            paramView = (awcz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
                            if (paramView != null)
                            {
                              if (QLog.isDevelopLevel()) {
                                QLog.d("Q.unread.", 4, "qq click action and clear active feed unread");
                              }
                              paramView.a(true);
                            }
                            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Qzone", "Qzone_prestrain", 0, 0, "0", "0", "0", "");
                            break;
                            if (paramamnq.a.strPkgName.equals("com.tx.xingqubuluo.android"))
                            {
                              localObject2 = (mmy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
                              localObject5 = new StringBuffer();
                              i = ((mmy)localObject2).d();
                              if (i > 0) {
                                ((StringBuffer)localObject5).append("redid=" + i);
                              }
                              if (QLog.isDevelopLevel()) {
                                QLog.d("xingqubuluo", 4, "***redid=" + i);
                              }
                              i = ((mmy)localObject2).a();
                              if (i > 0) {
                                if (((StringBuffer)localObject5).length() != 0) {
                                  break label3181;
                                }
                              }
                              for (localObject2 = "";; localObject2 = "&rpnumber=" + i)
                              {
                                ((StringBuffer)localObject5).append((String)localObject2);
                                if (QLog.isDevelopLevel()) {
                                  QLog.d("xingqubuluo", 4, "***rpnumber=" + i);
                                }
                                try
                                {
                                  localObject2 = new JSONObject(localAppInfo.buffer.get());
                                  if (localObject2 != null)
                                  {
                                    localObject2 = ((JSONObject)localObject2).optJSONObject("param");
                                    if (localObject2 != null)
                                    {
                                      localObject6 = ((JSONObject)localObject2).optJSONObject((String)localAppInfo.missions.get(0));
                                      if (localObject6 != null)
                                      {
                                        localObject2 = ((JSONObject)localObject6).optString("_red_ext_bid");
                                        localObject6 = ((JSONObject)localObject6).optString("_red_ext_pid");
                                        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                                          ((StringBuffer)localObject5).append("&bid=").append((String)localObject2);
                                        }
                                        if (!TextUtils.isEmpty((CharSequence)localObject6)) {
                                          ((StringBuffer)localObject5).append("&pid=").append((String)localObject6);
                                        }
                                      }
                                    }
                                  }
                                }
                                catch (JSONException localJSONException)
                                {
                                  for (;;)
                                  {
                                    localJSONException.printStackTrace();
                                  }
                                }
                                localObject2 = localObject4;
                                if (((StringBuffer)localObject5).length() <= 0) {
                                  break;
                                }
                                ((bacn)localObject4).d(((StringBuffer)localObject5).toString());
                                localObject2 = localObject4;
                                break;
                              }
                            }
                            if (!paramamnq.a.strPkgName.equals("com.read.android")) {
                              break label3251;
                            }
                            ((bacn)localObject4).a("ChannelID", "100020");
                            localObject3 = localObject4;
                          }
                          localObject3 = localObject4;
                        } while (paramamnq.a.uiResId != msg.jdField_a_of_type_Int);
                        Object localObject6 = (mmy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
                        Object localObject5 = ((mmy)localObject6).a();
                        localObject3 = localObject5;
                        if (localObject5 == null)
                        {
                          localObject3 = localObject5;
                          if (((stg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).jdField_a_of_type_Boolean)
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("Q.lebatab.leba", 2, "check invisible red point for msgtab");
                            }
                            localObject3 = ((mmy)localObject6).a(52);
                            if (localObject3 != null) {
                              break label3528;
                            }
                            localObject3 = ((mmy)localObject6).a(35);
                          }
                        }
                        for (;;)
                        {
                          if ((localObject3 != null) && (((oidb_0x791.RedDotInfo)localObject3).uint32_appid.get() == 37))
                          {
                            localObject5 = null;
                            try
                            {
                              localObject6 = new JSONObject(((oidb_0x791.RedDotInfo)localObject3).str_custom_buffer.get().toStringUtf8()).getString("fake_protocol");
                              localObject5 = localObject6;
                            }
                            catch (Exception localException)
                            {
                              for (;;)
                              {
                                urk.d("Leba.qqstory.tag", "tag red dot json parse error , %s", new Object[] { localException.getMessage() });
                                continue;
                                localObject3 = String.valueOf(((oidb_0x791.RedDotInfo)localObject3).uint32_appid.get());
                              }
                            }
                            if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                              localObject4 = bade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject5);
                            }
                          }
                          for (;;)
                          {
                            if (localObject3 == null)
                            {
                              localObject3 = "";
                              ((bacn)localObject4).a("redid", (String)localObject3);
                              ((bacn)localObject4).a("lebaVersion", "old");
                              localObject3 = localObject4;
                              break;
                            }
                            ((bacn)localObject3).c();
                            break label2649;
                          }
                        }
                      }
                    }
                    j = 0;
                    Object localObject3 = null;
                    bool2 = false;
                    paramInt = 0;
                    localObject1 = paramView;
                    paramView = (View)localObject3;
                  }
                }
              }
              label2649:
              label3573:
              bool1 = false;
            }
            label2081:
            label3251:
            label3579:
            break label457;
            label2185:
            label2848:
            label3582:
            continue;
            paramView = (View)localObject1;
          }
        }
      }
      paramamnq = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      y();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_Beez);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Atdk);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Atdi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Atdh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akfr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajpe);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajfo, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Asde);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anoj);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Q.lebatab.leba", 1, "leba fillData->initLebaView exception:" + localException, localException);
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Beez.post(new Leba.2(this));
  }
  
  boolean c()
  {
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = this.g;
      if (this.g)
      {
        this.g = false;
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.postDelayed(new Leba.18(this), 1000L);
        return bool2;
      }
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.lebatab.leba", 2, "clickAction is dismiss,click too frequently.");
    return bool2;
  }
  
  public void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "leba.java onResume");
    }
    AbstractGifImage.resumeAll();
    ohp.a().c();
    if (this.jdField_e_of_type_Boolean)
    {
      ThreadRegulator.a().b(4);
      this.jdField_e_of_type_Boolean = false;
    }
    abnm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_Abbj != null) {
      this.jdField_a_of_type_Abbj.c();
    }
    ThreadManager.post(new Leba.4(this), 5, null, false);
    ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(System.currentTimeMillis());
    if ((!this.jdField_b_of_type_Boolean) || ((afqa.jdField_a_of_type_Int & 0x4) != 0)) {
      this.jdField_a_of_type_Beez.sendEmptyMessageDelayed(11340002, 200L);
    }
    for (;;)
    {
      WebProcessManager.c(true);
      this.jdField_a_of_type_Beez.postDelayed(new Leba.5(this), 100L);
      ThreadManagerV2.excute(new Leba.6(this, (ascz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
      H();
      Object localObject;
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setFocusable(true);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(a(2131625544));
        localObject = a(2131628428);
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
        a().setTitle(a(2131628428));
      }
      if (this.jdField_a_of_type_Aiba != null) {
        this.jdField_a_of_type_Aiba.a();
      }
      if (this.jdField_a_of_type_Aquq != null) {
        this.jdField_a_of_type_Aquq.a(true);
      }
      ApngImage.playByTag(4);
      if ((paramBoolean) && (!this.jdField_d_of_type_Boolean) && (a() != null))
      {
        this.jdField_d_of_type_Boolean = true;
        ThreadManagerV2.executeOnSubThread(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
      if (afqa.jdField_a_of_type_Int > 0)
      {
        localObject = new ArrayList();
        ajlj.a((List)localObject, afqa.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        if (this.jdField_b_of_type_JavaUtilList != null)
        {
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_b_of_type_JavaUtilList.addAll((Collection)localObject);
          if (this.jdField_a_of_type_Aiba != null)
          {
            this.jdField_a_of_type_Aiba.notifyDataSetChanged();
            F();
          }
        }
        afqa.jdField_a_of_type_Int = 0;
      }
    }
  }
  
  protected void e()
  {
    super.e();
    x();
    if (this.jdField_a_of_type_Abbj != null) {
      this.jdField_a_of_type_Abbj.d();
    }
  }
  
  protected void f()
  {
    super.f();
    w();
    J();
    ((ViewStub)a(2131310803)).setOnInflateListener(this);
    ((CommonLoadingView)a(2131298986)).setOnFirstDrawListener(this);
    this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void h()
  {
    ApngImage.pauseByTag(4);
    super.h();
    WebProcessManager.c(false);
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.b();
    }
    this.jdField_a_of_type_Aqeb.d();
    this.jdField_b_of_type_Aqeb.d();
    aseo.c(0);
    this.jdField_a_of_type_Beez.removeMessages(1134010);
    if (this.jdField_a_of_type_Abbj != null) {
      this.jdField_a_of_type_Abbj.b();
    }
    if (this.jdField_a_of_type_Aiba != null) {
      this.jdField_a_of_type_Aiba.b();
    }
    if (this.jdField_a_of_type_Aquq != null) {
      this.jdField_a_of_type_Aquq.c();
    }
    this.jdField_a_of_type_Beez.postDelayed(new Leba.3(this), 500L);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "leba.java onPause");
    }
  }
  
  public void i()
  {
    super.i();
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onStop");
    }
  }
  
  protected void j()
  {
    x();
    if (this.jdField_a_of_type_Abbj != null) {
      this.jdField_a_of_type_Abbj.d();
    }
    if (this.jdField_a_of_type_Aquq != null) {
      this.jdField_a_of_type_Aquq.d();
    }
    super.j();
  }
  
  protected void k()
  {
    LinearLayout localLinearLayout;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (!avwc.a()) {
        break label26;
      }
    }
    label26:
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      return;
    }
  }
  
  void l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. begin.");
    }
    ThreadManager.post(new Leba.10(this), 10, null, false);
    WebProcessManager localWebProcessManager = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    if ((localWebProcessManager != null) && (localWebProcessManager.d())) {
      localWebProcessManager.a(202);
    }
  }
  
  protected void m()
  {
    super.m();
  }
  
  public void n()
  {
    Object localObject = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    int j;
    if (localObject != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((auqh)localObject).a("886.100170");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0) && (localAppInfo.type.get() != -1))
      {
        j = 0;
        int i = j;
        if (j == -1)
        {
          localAppInfo = ((auqh)localObject).a("886.100171");
          i = j;
          if (localAppInfo != null)
          {
            i = j;
            if (localAppInfo.iNewFlag.get() != 0)
            {
              i = j;
              if (localAppInfo.type.get() != -1) {
                i = 1;
              }
            }
          }
        }
        j = i;
        if (i == -1)
        {
          localObject = ((auqh)localObject).a("886.100172");
          j = i;
          if (localObject != null)
          {
            j = i;
            if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0)
            {
              j = i;
              if (((BusinessInfoCheckUpdate.AppInfo)localObject).type.get() != -1) {
                j = 2;
              }
            }
          }
        }
        if (j != -1) {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "dynamic", "exp_red", 0, 0, j + "", "", "", "");
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyTroopsActivity", 2, "ReportTroopAndActivityStatics, redDotFrom=" + j);
      }
      return;
      j = -1;
      break;
      j = -1;
    }
  }
  
  void o()
  {
    ThemeBackground.applyThemeBg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetImageView, 4, 2130838504, "-leba-");
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null) && (ThemeUtil.isNowThemeIsAnimate())) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOnScrollListener(this);
    }
  }
  
  public void onClick(View paramView)
  {
    if (!c()) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131302816: 
    case 2131302832: 
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_tt_right", 0, 0, "", "", "", "");
      E();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HardCoder", 2, "launch qzone");
    }
    jdField_a_of_type_Int = zrr.a().a(0, 1, 1, 0, 3000, 101, 4L, Process.myTid(), "bootQzone");
    paramView = (amnq)afqa.a().jdField_a_of_type_JavaUtilHashMap.get("qzone_feedlist");
    QLog.d("Q.lebatab.leba", 1, "user clicked qzone feed entry.");
    ThreadManager.postImmediately(new Leba.33(this, paramView), null, true);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, "10000", "", "", "");
    azve.a(this.jdField_c_of_type_AndroidViewView, ajjy.a(2131654130));
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    b(false);
    if (!this.jdField_b_of_type_Boolean) {
      d(true);
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    do
    {
      do
      {
        return;
        if (paramInt != 0)
        {
          ApngImage.pauseByTag(4);
          if (QLog.isColorLevel()) {
            QLog.e("Q.lebatab.leba", 2, "onScrollStateChanged not SCROLL_STATE_IDLE");
          }
        }
      } while (paramInt != 0);
      ApngImage.playByTag(4);
    } while (!QLog.isColorLevel());
    QLog.e("Q.lebatab.leba", 2, "onScrollStateChanged SCROLL_STATE_IDLE");
  }
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "onPostThemeChanged");
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(null);
    }
    o();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
      awnu.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_Beez.sendEmptyMessageDelayed(11340002, 0L);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        if (!awnu.a()) {
          break label215;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aiba != null) {
        this.jdField_a_of_type_Aiba.c();
      }
      if (this.jdField_a_of_type_Abbj != null) {
        this.jdField_a_of_type_Abbj.e();
      }
      if (this.jdField_a_of_type_Aquq != null) {
        this.jdField_a_of_type_Aquq.f();
      }
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130848801);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131101257));
      break;
      label215:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      aroj localaroj = (aroj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      awdb.jdField_a_of_type_Boolean = true;
      if (localaroj != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "click leba.test if get qzone unread.");
        }
        localaroj.a(3);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b();
      }
    }
    if (!e()) {
      B();
    }
  }
  
  void s()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() == true)) {}
    ngh localngh;
    do
    {
      return;
      localngh = (ngh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      if (QLog.isColorLevel()) {
        QLog.e("AuthCode", 2, "time out jump!");
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a(this.jdField_a_of_type_AndroidContentIntent);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    } while (localngh == null);
    localngh.a(134246777, null, "jump", "time_out", "no_code", 0L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abai
 * JD-Core Version:    0.7.0.1
 */