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
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
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
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr.DItemInfo;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class alof
  implements View.OnClickListener
{
  public static final int[] a;
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2131691111, 2130839522 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131691115, 2130839508 };
  private static final int[] jdField_d_of_type_ArrayOfInt = { 2131691113, 2130839527 };
  private static final int[] jdField_e_of_type_ArrayOfInt = { 2131691122, 2130839526 };
  private static final int[] jdField_f_of_type_ArrayOfInt = { 2131691120, 2130839534 };
  private static final int[] jdField_g_of_type_ArrayOfInt = { 2131691114, 2130839528 };
  private static final int[] h = { 2131691118, 2130839533 };
  private static final int[] i = { 2131691117, 2130839532 };
  private static final int[] j = { 2131698358, 2130839535 };
  private static final int[] k = { 2131691116, 2130839530 };
  private static final int[] l = { 2131691123, 2130839526 };
  private static final int[] m = { 2131691112, 2130839523 };
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  blol jdField_a_of_type_Blol;
  public BaseActivity a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private String jdField_a_of_type_JavaLangString = "";
  private List<bloo> jdField_a_of_type_JavaUtilList;
  private ngn jdField_a_of_type_Ngn;
  public boolean a;
  private RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  private boolean jdField_f_of_type_Boolean;
  private boolean jdField_g_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691121, 2130839536 };
  }
  
  public alof(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public static Intent a(BaseActivity paramBaseActivity, long paramLong1, long paramLong2, int paramInt)
  {
    Intent localIntent = new Intent(paramBaseActivity, ScannerActivity.class);
    localIntent.putExtra("from", "Conversation");
    localIntent.putExtra("from_+", true);
    localIntent.putExtra("leftViewText", paramBaseActivity.getString(2131690559));
    localIntent.putExtra("selfSet_leftViewText", paramBaseActivity.getString(2131690559));
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
    alpb.a(paramFrameHelperActivity, paramIntent);
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
    if (lju.b(BaseApplicationImpl.getContext())) {
      return false;
    }
    if (paramBaseActivity.isInMultiWindow())
    {
      QQToast.a(paramBaseActivity, anzj.a(2131712083), 0).a();
      return false;
    }
    return true;
  }
  
  private boolean d()
  {
    boolean bool = false;
    String str = bmfq.a("drawer_plus_text");
    if ((this.jdField_b_of_type_JavaLangString != null) && (!this.jdField_b_of_type_JavaLangString.equals(str))) {}
    for (int n = 1;; n = 0)
    {
      if ((bmfx.c() != this.jdField_e_of_type_Boolean) || (n != 0)) {
        bool = true;
      }
      return bool;
    }
  }
  
  private void o()
  {
    boolean bool = bmfx.c();
    this.jdField_e_of_type_Boolean = bool;
    if (bool)
    {
      bloo localbloo = a(j);
      String str2 = bmfq.a("drawer_plus_text");
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131698358);
      }
      localbloo.jdField_a_of_type_JavaLangString = str1;
      this.jdField_b_of_type_JavaLangString = localbloo.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilList.add(localbloo);
    }
  }
  
  private void p()
  {
    bmfx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "add");
  }
  
  private void q()
  {
    if (((this.jdField_g_of_type_Boolean) && (!akyd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false))) || ((!this.jdField_g_of_type_Boolean) && (akyd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false))))
    {
      a();
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = null;
    }
    if (akyd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin()))
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131165585));
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839528);
      }
    }
    for (;;)
    {
      if (((this.jdField_c_of_type_Boolean) && (!RecentDanceConfigMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app))) || ((!this.jdField_c_of_type_Boolean) && (RecentDanceConfigMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app))) || ((this.jdField_c_of_type_Boolean) && (RecentDanceConfigMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) && (RecentDanceConfigMgr.a()))) {
        a();
      }
      return;
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131166990));
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839529);
      }
    }
  }
  
  private void r()
  {
    boolean bool = false;
    Object localObject1;
    int n;
    if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) || (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch == null))
    {
      localObject1 = (LinearLayout)this.jdField_a_of_type_Blol.getContentView().findViewById(2131365046);
      n = 0;
    }
    for (;;)
    {
      if (n < ((LinearLayout)localObject1).getChildCount())
      {
        try
        {
          Object localObject2 = ((LinearLayout)localObject1).getChildAt(n);
          if (((bloo)((View)localObject2).getTag()).jdField_a_of_type_Int == 2131691111)
          {
            localObject2 = (TextView)((View)localObject2).findViewById(2131378772);
            this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject2).a(21).a();
          }
          else if (((bloo)((View)localObject2).getTag()).jdField_a_of_type_Int == 2131691122)
          {
            localObject2 = ((View)localObject2).findViewById(2131368576);
            this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject2).a(53).a();
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (((bloo)localException.getTag()).jdField_a_of_type_Int == 2131691114)
        {
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localException.findViewById(2131378772));
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localException.findViewById(2131368576));
          if (akyd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin()))
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131165585));
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839528);
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131166990));
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839529);
          }
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
        {
          localObject1 = ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36)).a("101210.101211");
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
        }
        if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)
        {
          if (!bdcy.a(bdcy.g)) {
            bool = true;
          }
          this.jdField_b_of_type_Boolean = bool;
          if (this.jdField_b_of_type_Boolean != this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_g_of_type_Boolean) {
            this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_b_of_type_Boolean);
          }
        }
        return;
      }
      n += 1;
    }
  }
  
  private void s()
  {
    if (!VideoEnvironment.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) {
      bhlq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(anzj.a(2131712085)).setPositiveButton(2131694098, new aloj(this)).show();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.d())
      {
        QQToast.a(BaseApplicationImpl.getContext(), 2131695278, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299011));
        return;
      }
    } while (!VideoEnvironment.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app));
    k();
  }
  
  public bloo a(int[] paramArrayOfInt)
  {
    bloo localbloo = new bloo();
    localbloo.jdField_a_of_type_Int = paramArrayOfInt[0];
    localbloo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramArrayOfInt[0]);
    localbloo.c = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramArrayOfInt[0]);
    localbloo.b = paramArrayOfInt[1];
    return localbloo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(a(jdField_f_of_type_ArrayOfInt));
    this.jdField_a_of_type_JavaUtilList.add(a(jdField_b_of_type_ArrayOfInt));
    Object localObject;
    if (atbf.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app))
    {
      this.jdField_d_of_type_Boolean = true;
      localObject = a(k);
      this.jdField_a_of_type_JavaLangString = atbf.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        ((bloo)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        ((bloo)localObject).c = this.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      if (!nhv.a()) {
        break label430;
      }
      this.jdField_a_of_type_JavaUtilList.add(a(m));
    }
    label430:
    for (this.jdField_f_of_type_Boolean = true;; this.jdField_f_of_type_Boolean = false)
    {
      this.jdField_a_of_type_JavaUtilList.add(a(jdField_a_of_type_ArrayOfInt));
      this.jdField_a_of_type_JavaUtilList.add(a(jdField_c_of_type_ArrayOfInt));
      this.jdField_a_of_type_JavaUtilList.add(a(jdField_d_of_type_ArrayOfInt));
      localObject = arfd.a();
      if ((localObject != null) && (((arfc)localObject).c())) {
        this.jdField_a_of_type_JavaUtilList.add(a(i));
      }
      this.jdField_c_of_type_Boolean = false;
      if ((RecentDanceConfigMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) && (c()))
      {
        this.jdField_a_of_type_JavaUtilList.add(b(l));
        this.jdField_c_of_type_Boolean = true;
      }
      this.jdField_g_of_type_Boolean = false;
      if ((akyd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false)) && (c()))
      {
        this.jdField_a_of_type_JavaUtilList.add(a(jdField_g_of_type_ArrayOfInt));
        this.jdField_g_of_type_Boolean = true;
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "hongbaocaidan.show", 0, 0, "", "", "", "");
      }
      o();
      if (AudioHelper.e()) {
        PstnCardTestActivity.addDebugMenu(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_JavaUtilList);
      }
      this.jdField_a_of_type_Blol = blol.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaUtilList, new alog(this), new aloh(this));
      return;
      this.jdField_d_of_type_Boolean = false;
      break;
    }
  }
  
  protected void a(int paramInt)
  {
    long l1 = VACDReportUtil.a(null, "qqwallet", "payCode", "click", "2", 0, null);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, JumpActivity.class);
    localIntent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=" + paramInt + "&entry=2&seq=" + l1));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, -1);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8005ED3", "0X8005ED3", 0, 0, "", "", "", "");
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Blol != null) && (this.jdField_a_of_type_Blol.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Blol = null;
    }
    if (this.jdField_a_of_type_Blol == null) {
      a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Blol.showAsDropDown(paramView, paramInt1, paramInt2);
      r();
      bodt.a(BaseApplicationImpl.getContext(), "peak_preload_plus_panel");
      b();
      if (this.jdField_d_of_type_Boolean) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800A69B", "0X800A69B", 0, 0, "", "", "", "");
      }
      return;
      if (this.jdField_d_of_type_Boolean)
      {
        String str = atbf.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
        if ((str != null) && (this.jdField_a_of_type_JavaLangString != null) && (!str.equals(this.jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_Boolean = true;
        }
      }
      if (d()) {
        this.jdField_a_of_type_Boolean = true;
      }
      if (((this.jdField_d_of_type_Boolean) && (!atbf.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app))) || ((!this.jdField_d_of_type_Boolean) && (atbf.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)))) {
        this.jdField_a_of_type_Boolean = true;
      }
      if (((this.jdField_f_of_type_Boolean) && (!nhv.a())) || ((!this.jdField_f_of_type_Boolean) && (nhv.a()))) {
        this.jdField_a_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        a();
        this.jdField_a_of_type_Boolean = false;
      }
      if (c()) {
        q();
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
    return (this.jdField_a_of_type_Blol != null) && (this.jdField_a_of_type_Blol.isShowing());
  }
  
  public bloo b(int[] paramArrayOfInt)
  {
    bloo localbloo = new bloo();
    localbloo.jdField_a_of_type_Int = paramArrayOfInt[0];
    localbloo.c = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramArrayOfInt[0]);
    localbloo.b = paramArrayOfInt[1];
    RecentDanceConfigMgr.DItemInfo localDItemInfo = RecentDanceConfigMgr.a();
    if (localDItemInfo != null)
    {
      localbloo.jdField_a_of_type_JavaLangString = localDItemInfo.showName;
      localbloo.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = localDItemInfo.drawable;
      return localbloo;
    }
    localbloo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramArrayOfInt[0]);
    localbloo.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
    return localbloo;
  }
  
  public void b()
  {
    if (a()) {
      this.jdField_a_of_type_Blol.dismiss();
    }
  }
  
  public boolean b()
  {
    if (ShortVideoUtils.a()) {
      return true;
    }
    ThreadManager.post(new RecentOptPopBar.4(this), 8, null, true);
    return false;
  }
  
  protected void c()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0L, 0L, 0);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004077", "0X8004077", 0, 0, "", "", "", "");
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
    localIntent.putExtra("leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690559));
    localIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690559));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004839", "0X8004839", 0, 0, "", "", "", "");
    try
    {
      ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36)).b(String.valueOf("101210.101211"));
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void e() {}
  
  protected void f()
  {
    bmim.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 8, null);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X80053AD", "0X80053AD", 0, 0, "", "", "", "");
  }
  
  protected void g()
  {
    long l1 = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "click", null, 0, null);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QrcodeHbGuiderActivity.class);
    localIntent.putExtra("appInfo", "");
    localIntent.putExtra("vacreport_key_seq", l1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "jiahao.hongbao.click", 0, 0, "", "", "", "");
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
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004074", "0X8004074", 0, 0, "", "", "", "");
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00899", "Grp_create", "", "msg_page", "exp_creategrp", 0, 0, "", "", "", "");
  }
  
  protected void i()
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X800780A", "0X800780A", 0, 0, "", "", "", "");
    yup.a("plus_shoot", "clk_entry", 0, 0, new String[] { "", "", "", "" });
    yup.a("plus_shoot", "exp_shoot", 0, 0, new String[] { "", "", "", "" });
    if (this.jdField_b_of_type_Boolean) {
      bdcy.a(bdcy.g);
    }
    j();
    if (bmgb.a != null) {
      bmgb.a.b();
    }
  }
  
  protected void j()
  {
    if (!VideoEnvironment.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) {
      bhlq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(anzj.a(2131712086)).setPositiveButton(2131694098, new aloi(this)).show();
    }
  }
  
  protected void k()
  {
    Object localObject = RecentDanceConfigMgr.a();
    if (localObject == null) {
      RecentDanceConfigMgr.a("showDanceCategoryPanel:[Plus] itemInfo=null");
    }
    do
    {
      return;
      boolean bool = bczv.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      RecentDanceConfigMgr.a("showDanceCategoryPanel: videoUsable=" + bool);
      bbgf.h();
      localObject = bocm.a(null, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getName(), 10004, 8, ((RecentDanceConfigMgr.DItemInfo)localObject).unfold, ((RecentDanceConfigMgr.DItemInfo)localObject).categoryID, ((RecentDanceConfigMgr.DItemInfo)localObject).itemID);
      zmq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Bundle)localObject, 9010);
    } while (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a());
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(false);
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Blol != null) {
      this.jdField_a_of_type_Blol.a();
    }
  }
  
  protected void m()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("ExtendFriendLimitChatFromeType", 1);
      PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, ExtendFriendLimitChatMatchFragment.class);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130771997, 2130771990);
      atci.a().b(4);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800A69C", "0X800A69C", 0, 0, "", "", "", "");
      return;
    }
    QLog.e("RecentOptPopBar", 2, "activity or app is null");
  }
  
  protected void n()
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800B010", "0X800B010", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_Ngn == null) {
      this.jdField_a_of_type_Ngn = new ngn(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    this.jdField_a_of_type_Ngn.onClick(null);
    mxc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Blol.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alof
 * JD-Core Version:    0.7.0.1
 */