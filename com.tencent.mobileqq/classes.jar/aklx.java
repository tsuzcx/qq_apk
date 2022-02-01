import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.qwallet.QrcodeHbGuiderActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.debug.PstnCardTestActivity;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class aklx
  implements View.OnClickListener
{
  public static final int[] a;
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2131691151, 2130839557 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131691155, 2130839543 };
  private static final int[] jdField_d_of_type_ArrayOfInt = { 2131691153, 2130839562 };
  private static final int[] jdField_e_of_type_ArrayOfInt = { 2131691162, 2130839561 };
  private static final int[] jdField_f_of_type_ArrayOfInt = { 2131691160, 2130839569 };
  private static final int[] g = { 2131691154, 2130839563 };
  private static final int[] h = { 2131691158, 2130839568 };
  private static final int[] i = { 2131691157, 2130839567 };
  private static final int[] j = { 2131698527, 2130839570 };
  private static final int[] k = { 2131691156, 2130839565 };
  private static final int[] l = { 2131691152, 2130839558 };
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bjsv jdField_a_of_type_Bjsv;
  public BaseActivity a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private String jdField_a_of_type_JavaLangString = "";
  private List<bjsy> jdField_a_of_type_JavaUtilList;
  public boolean a;
  private RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  private boolean jdField_f_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691161, 2130839571 };
  }
  
  public aklx(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public static Intent a(BaseActivity paramBaseActivity, long paramLong1, long paramLong2, int paramInt)
  {
    Intent localIntent = new Intent(paramBaseActivity, ScannerActivity.class);
    localIntent.putExtra("from", "Conversation");
    localIntent.putExtra("from_+", true);
    localIntent.putExtra("leftViewText", paramBaseActivity.getString(2131690599));
    localIntent.putExtra("selfSet_leftViewText", paramBaseActivity.getString(2131690599));
    localIntent.putExtra("start_time", System.currentTimeMillis());
    paramBaseActivity = new Bundle();
    paramBaseActivity.putLong("PromotionType", paramLong1);
    paramBaseActivity.putLong("RecoglizeMask", paramLong2);
    paramBaseActivity.putString("H5Source", String.valueOf(paramInt));
    localIntent.putExtra("web_invoke_params", paramBaseActivity);
    localIntent.setFlags(67108864);
    return localIntent;
  }
  
  public static void a(Intent paramIntent, FrameHelperActivity paramFrameHelperActivity)
  {
    if ((paramIntent != null) && (paramFrameHelperActivity != null) && ((paramFrameHelperActivity.getActivity() instanceof SplashActivity)))
    {
      paramFrameHelperActivity = (SplashActivity)paramFrameHelperActivity.getActivity();
      if (!paramIntent.getBooleanExtra("open_leba_tab_fragment", false)) {
        break label42;
      }
      paramFrameHelperActivity.b(paramIntent);
    }
    label42:
    while (!paramIntent.getBooleanExtra("open_chatfragment", false)) {
      return;
    }
    akms.a(paramFrameHelperActivity, paramIntent);
  }
  
  public static void a(BaseActivity paramBaseActivity, long paramLong1, long paramLong2, int paramInt)
  {
    if (!a(paramBaseActivity)) {
      return;
    }
    paramBaseActivity.startActivity(a(paramBaseActivity, paramLong1, paramLong2, paramInt));
  }
  
  public static boolean a(BaseActivity paramBaseActivity)
  {
    if (ljo.b(BaseApplicationImpl.getContext())) {
      return false;
    }
    if (paramBaseActivity.isInMultiWindow())
    {
      QQToast.a(paramBaseActivity, amtj.a(2131712315), 0).a();
      return false;
    }
    return true;
  }
  
  private boolean d()
  {
    boolean bool = false;
    String str = bkjx.a("drawer_plus_text");
    if ((this.jdField_b_of_type_JavaLangString != null) && (!this.jdField_b_of_type_JavaLangString.equals(str))) {}
    for (int m = 1;; m = 0)
    {
      if ((bkke.c() != this.jdField_d_of_type_Boolean) || (m != 0)) {
        bool = true;
      }
      return bool;
    }
  }
  
  private void n()
  {
    boolean bool = bkke.c();
    this.jdField_d_of_type_Boolean = bool;
    if (bool)
    {
      bjsy localbjsy = a(j);
      String str2 = bkjx.a("drawer_plus_text");
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131698527);
      }
      localbjsy.jdField_a_of_type_JavaLangString = str1;
      this.jdField_b_of_type_JavaLangString = localbjsy.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilList.add(localbjsy);
    }
  }
  
  private void o()
  {
    bkke.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "add");
  }
  
  private void p()
  {
    if (((this.jdField_f_of_type_Boolean) && (!ajvu.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false))) || ((!this.jdField_f_of_type_Boolean) && (ajvu.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false))))
    {
      a();
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = null;
    }
    if (ajvu.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin()))
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131165593));
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839563);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131167012));
      }
    } while (this.jdField_a_of_type_AndroidWidgetImageView == null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839564);
  }
  
  private void q()
  {
    boolean bool = false;
    Object localObject1;
    int m;
    if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) || (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch == null))
    {
      localObject1 = (LinearLayout)this.jdField_a_of_type_Bjsv.getContentView().findViewById(2131365073);
      m = 0;
    }
    for (;;)
    {
      if (m < ((LinearLayout)localObject1).getChildCount())
      {
        try
        {
          Object localObject2 = ((LinearLayout)localObject1).getChildAt(m);
          if (((bjsy)((View)localObject2).getTag()).jdField_a_of_type_Int == 2131691151)
          {
            localObject2 = (TextView)((View)localObject2).findViewById(2131378537);
            this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject2).a(21).a();
          }
          else if (((bjsy)((View)localObject2).getTag()).jdField_a_of_type_Int == 2131691162)
          {
            localObject2 = ((View)localObject2).findViewById(2131368601);
            this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject2).a(53).a();
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (((bjsy)localException.getTag()).jdField_a_of_type_Int == 2131691154)
        {
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localException.findViewById(2131378537));
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localException.findViewById(2131368601));
          if (ajvu.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin()))
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131165593));
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839563);
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131167012));
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839564);
          }
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
        {
          localObject1 = ((azvi)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36)).a("101210.101211");
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
        }
        if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)
        {
          if (!bbwb.a(bbwb.g)) {
            bool = true;
          }
          this.jdField_b_of_type_Boolean = bool;
          if (this.jdField_b_of_type_Boolean != this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.g) {
            this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_b_of_type_Boolean);
          }
        }
        return;
      }
      m += 1;
    }
  }
  
  public bjsy a(int[] paramArrayOfInt)
  {
    bjsy localbjsy = new bjsy();
    localbjsy.jdField_a_of_type_Int = paramArrayOfInt[0];
    localbjsy.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramArrayOfInt[0]);
    localbjsy.c = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramArrayOfInt[0]);
    localbjsy.b = paramArrayOfInt[1];
    return localbjsy;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(a(jdField_f_of_type_ArrayOfInt));
    this.jdField_a_of_type_JavaUtilList.add(a(jdField_b_of_type_ArrayOfInt));
    Object localObject;
    if (arnn.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app))
    {
      this.jdField_c_of_type_Boolean = true;
      localObject = a(k);
      this.jdField_a_of_type_JavaLangString = arnn.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        ((bjsy)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        ((bjsy)localObject).c = this.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      if (!njk.a()) {
        break label383;
      }
      this.jdField_a_of_type_JavaUtilList.add(a(l));
    }
    label383:
    for (this.jdField_e_of_type_Boolean = true;; this.jdField_e_of_type_Boolean = false)
    {
      this.jdField_a_of_type_JavaUtilList.add(a(jdField_a_of_type_ArrayOfInt));
      this.jdField_a_of_type_JavaUtilList.add(a(jdField_c_of_type_ArrayOfInt));
      this.jdField_a_of_type_JavaUtilList.add(a(jdField_d_of_type_ArrayOfInt));
      localObject = apyt.a();
      if ((localObject != null) && (((apys)localObject).c())) {
        this.jdField_a_of_type_JavaUtilList.add(a(i));
      }
      this.jdField_f_of_type_Boolean = false;
      if ((ajvu.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false)) && (c()))
      {
        this.jdField_a_of_type_JavaUtilList.add(a(g));
        this.jdField_f_of_type_Boolean = true;
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "hongbaocaidan.show", 0, 0, "", "", "", "");
      }
      n();
      if (AudioHelper.e()) {
        PstnCardTestActivity.addDebugMenu(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_JavaUtilList);
      }
      this.jdField_a_of_type_Bjsv = bjsv.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaUtilList, new akly(this), new aklz(this));
      return;
      this.jdField_c_of_type_Boolean = false;
      break;
    }
  }
  
  protected void a(int paramInt)
  {
    long l1 = VACDReportUtil.a(null, "qqwallet", "payCode", "click", "2", 0, null);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, JumpActivity.class);
    localIntent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=" + paramInt + "&entry=2&seq=" + l1));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, -1);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8005ED3", "0X8005ED3", 0, 0, "", "", "", "");
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Bjsv != null) && (this.jdField_a_of_type_Bjsv.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Bjsv = null;
    }
    if (this.jdField_a_of_type_Bjsv == null) {
      a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bjsv.showAsDropDown(paramView, paramInt1, paramInt2);
      q();
      blig.a(BaseApplicationImpl.getContext(), "peak_preload_plus_panel");
      b();
      if (this.jdField_c_of_type_Boolean) {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800A69B", "0X800A69B", 0, 0, "", "", "", "");
      }
      return;
      if (this.jdField_c_of_type_Boolean)
      {
        String str = arnn.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
        if ((str != null) && (this.jdField_a_of_type_JavaLangString != null) && (!str.equals(this.jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_Boolean = true;
        }
      }
      if (d()) {
        this.jdField_a_of_type_Boolean = true;
      }
      if (((this.jdField_c_of_type_Boolean) && (!arnn.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app))) || ((!this.jdField_c_of_type_Boolean) && (arnn.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)))) {
        this.jdField_a_of_type_Boolean = true;
      }
      if (((this.jdField_e_of_type_Boolean) && (!njk.a())) || ((!this.jdField_e_of_type_Boolean) && (njk.a()))) {
        this.jdField_a_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        a();
        this.jdField_a_of_type_Boolean = false;
      }
      if (c()) {
        p();
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("SP_SHOT_REDTOUCH_TIME" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface().getCurrentAccountUin(), 0).getLong(paramString, 0L) != 0L) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("SP_SHOT_REDTOUCH_TIME" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface().getCurrentAccountUin(), 0).edit().putLong(paramString, paramLong).commit();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bjsv != null) && (this.jdField_a_of_type_Bjsv.isShowing());
  }
  
  public void b()
  {
    if (a()) {
      this.jdField_a_of_type_Bjsv.dismiss();
    }
  }
  
  public boolean b()
  {
    if (ShortVideoUtils.isVideoSoLibLoaded()) {
      return true;
    }
    ThreadManager.post(new RecentOptPopBar.4(this), 8, null, true);
    return false;
  }
  
  protected void c()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0L, 0L, 0);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004077", "0X8004077", 0, 0, "", "", "", "");
  }
  
  public boolean c()
  {
    return false;
  }
  
  protected void d()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AddContactsActivity.class);
    localIntent.putExtra("entrence_data_report", 2);
    localIntent.putExtra("EntranceId", 4);
    localIntent.putExtra("leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690599));
    localIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690599));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004839", "0X8004839", 0, 0, "", "", "", "");
    try
    {
      ((azvi)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36)).b(String.valueOf("101210.101211"));
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void e() {}
  
  protected void f()
  {
    bkmt.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 8, null);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X80053AD", "0X80053AD", 0, 0, "", "", "", "");
  }
  
  protected void g()
  {
    long l1 = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "click", null, 0, null);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QrcodeHbGuiderActivity.class);
    localIntent.putExtra("appInfo", "");
    localIntent.putExtra("vacreport_key_seq", l1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "jiahao.hongbao.click", 0, 0, "", "", "", "");
  }
  
  protected void h()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, NewTroopCreateActivity.class);
    localIntent.putExtra("param_exit_animation", 0);
    localIntent.setFlags(603979776);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("create_source", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 1300);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130771997, 2130772001);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004074", "0X8004074", 0, 0, "", "", "", "");
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00899", "Grp_create", "", "msg_page", "exp_creategrp", 0, 0, "", "", "", "");
  }
  
  protected void i()
  {
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X800780A", "0X800780A", 0, 0, "", "", "", "");
    xwa.a("plus_shoot", "clk_entry", 0, 0, new String[] { "", "", "", "" });
    xwa.a("plus_shoot", "exp_shoot", 0, 0, new String[] { "", "", "", "" });
    if (this.jdField_b_of_type_Boolean) {
      bbwb.a(bbwb.g);
    }
    j();
    if (bkkh.a != null) {
      bkkh.a.b();
    }
  }
  
  protected void j()
  {
    if (!VideoEnvironment.supportShortVideoRecord(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) {
      bfur.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(amtj.a(2131712318)).setPositiveButton(2131694201, new akma(this)).show();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Bjsv != null) {
      this.jdField_a_of_type_Bjsv.a();
    }
  }
  
  protected void l()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("ExtendFriendLimitChatFromeType", 1);
      PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, ExtendFriendLimitChatMatchFragment.class);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130771997, 2130771990);
      aroq.a().b(4);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800A69C", "0X800A69C", 0, 0, "", "", "", "");
      return;
    }
    QLog.e("RecentOptPopBar", 2, "activity or app is null");
  }
  
  protected void m()
  {
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800B010", "0X800B010", 0, 0, "", "", "", "");
    PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AVGameRoomCenterFragment.class);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bjsv.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aklx
 * JD-Core Version:    0.7.0.1
 */