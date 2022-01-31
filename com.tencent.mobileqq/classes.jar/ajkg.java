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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ajkg
  implements View.OnClickListener
{
  public static final int[] a;
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2131691317, 2130839336 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131691324, 2130839323 };
  private static final int[] jdField_d_of_type_ArrayOfInt = { 2131691321, 2130839340 };
  private static final int[] jdField_e_of_type_ArrayOfInt = { 2131691334, 2130839339 };
  private static final int[] f = { 2131691330, 2130839347 };
  private static final int[] g = { 2131691323, 2130839341 };
  private static final int[] h = { 2131691328, 2130839346 };
  private static final int[] i = { 2131691326, 2130839345 };
  private static final int[] j = { 2131691325, 2130839343 };
  private static final int[] k = { 2131691336, 2130839339 };
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bhzx jdField_a_of_type_Bhzx;
  public BaseActivity a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private String jdField_a_of_type_JavaLangString = "";
  private List<biaa> jdField_a_of_type_JavaUtilList;
  public boolean a;
  private RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691331, 2130839348 };
  }
  
  public ajkg(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public static Intent a(BaseActivity paramBaseActivity, long paramLong1, long paramLong2, int paramInt)
  {
    Intent localIntent = new Intent(paramBaseActivity, ScannerActivity.class);
    localIntent.putExtra("from", "Conversation");
    localIntent.putExtra("from_+", true);
    localIntent.putExtra("leftViewText", paramBaseActivity.getString(2131690623));
    localIntent.putExtra("selfSet_leftViewText", paramBaseActivity.getString(2131690623));
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
    ajlb.a(paramFrameHelperActivity, paramIntent);
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
    if (lmm.b(BaseApplicationImpl.getContext())) {
      return false;
    }
    if (paramBaseActivity.isInMultiWindow())
    {
      QQToast.a(paramBaseActivity, alud.a(2131713595), 0).a();
      return false;
    }
    return true;
  }
  
  private void n()
  {
    if (!VideoEnvironment.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) {
      bdgm.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(alud.a(2131713597)).setPositiveButton(2131694953, new ajkk(this)).show();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.c())
      {
        QQToast.a(BaseApplicationImpl.getContext(), 2131696353, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298914));
        return;
      }
    } while (!VideoEnvironment.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app));
    k();
  }
  
  public biaa a(int[] paramArrayOfInt)
  {
    biaa localbiaa = new biaa();
    localbiaa.jdField_a_of_type_Int = paramArrayOfInt[0];
    localbiaa.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramArrayOfInt[0]);
    localbiaa.c = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramArrayOfInt[0]);
    localbiaa.b = paramArrayOfInt[1];
    return localbiaa;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(a(f));
    this.jdField_a_of_type_JavaUtilList.add(a(jdField_b_of_type_ArrayOfInt));
    Object localObject;
    if (aqge.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app))
    {
      this.jdField_d_of_type_Boolean = true;
      localObject = a(j);
      this.jdField_a_of_type_JavaLangString = aqge.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        ((biaa)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        ((biaa)localObject).c = this.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.add(a(jdField_a_of_type_ArrayOfInt));
      this.jdField_a_of_type_JavaUtilList.add(a(jdField_c_of_type_ArrayOfInt));
      this.jdField_a_of_type_JavaUtilList.add(a(jdField_d_of_type_ArrayOfInt));
      localObject = aoom.a();
      if ((localObject != null) && (((aool)localObject).c())) {
        this.jdField_a_of_type_JavaUtilList.add(a(i));
      }
      this.jdField_c_of_type_Boolean = false;
      if ((RecentDanceConfigMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) && (c()))
      {
        this.jdField_a_of_type_JavaUtilList.add(b(k));
        this.jdField_c_of_type_Boolean = true;
      }
      this.jdField_e_of_type_Boolean = false;
      if ((aivo.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false)) && (c()))
      {
        this.jdField_a_of_type_JavaUtilList.add(a(g));
        this.jdField_e_of_type_Boolean = true;
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "hongbaocaidan.show", 0, 0, "", "", "", "");
      }
      if (AudioHelper.d()) {
        PstnCardTestActivity.addDebugMenu(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_JavaUtilList);
      }
      this.jdField_a_of_type_Bhzx = bhzx.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaUtilList, new ajkh(this), new ajki(this));
      return;
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  protected void a(int paramInt)
  {
    long l = VACDReportUtil.a(null, "qqwallet", "payCode", "click", "2", 0, null);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, JumpActivity.class);
    localIntent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=" + paramInt + "&entry=2&seq=" + l));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, -1);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8005ED3", "0X8005ED3", 0, 0, "", "", "", "");
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Bhzx != null) && (this.jdField_a_of_type_Bhzx.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Bhzx = null;
    }
    if (this.jdField_a_of_type_Bhzx == null) {
      a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhzx.showAsDropDown(paramView, paramInt1, paramInt2);
      label576:
      if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) || (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch == null))
      {
        paramView = (LinearLayout)this.jdField_a_of_type_Bhzx.getContentView().findViewById(2131364771);
        paramInt1 = 0;
        label76:
        if (paramInt1 < paramView.getChildCount()) {
          try
          {
            Object localObject = paramView.getChildAt(paramInt1);
            if (((biaa)((View)localObject).getTag()).jdField_a_of_type_Int == 2131691317)
            {
              localObject = (TextView)((View)localObject).findViewById(2131377774);
              this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject).a(21).a();
            }
            for (;;)
            {
              paramInt1 += 1;
              break label76;
              if (this.jdField_d_of_type_Boolean)
              {
                localObject = aqge.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
                if ((localObject != null) && (this.jdField_a_of_type_JavaLangString != null) && (!((String)localObject).equals(this.jdField_a_of_type_JavaLangString))) {
                  this.jdField_a_of_type_Boolean = true;
                }
              }
              if (((this.jdField_d_of_type_Boolean) && (!aqge.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app))) || ((!this.jdField_d_of_type_Boolean) && (aqge.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)))) {
                this.jdField_a_of_type_Boolean = true;
              }
              if (this.jdField_a_of_type_Boolean)
              {
                a();
                this.jdField_a_of_type_Boolean = false;
              }
              if (!c()) {
                break;
              }
              if (((this.jdField_e_of_type_Boolean) && (!aivo.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false))) || ((!this.jdField_e_of_type_Boolean) && (aivo.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false))))
              {
                a();
                this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
                this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = null;
              }
              if (aivo.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin()))
              {
                if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
                  this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131165548));
                }
                if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
                  this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839341);
                }
              }
              while (((this.jdField_c_of_type_Boolean) && (!RecentDanceConfigMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app))) || ((!this.jdField_c_of_type_Boolean) && (RecentDanceConfigMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app))) || ((this.jdField_c_of_type_Boolean) && (RecentDanceConfigMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) && (RecentDanceConfigMgr.a())))
              {
                a();
                break;
                if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
                  this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131166903));
                }
                if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
                  this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839342);
                }
              }
              if (((biaa)((View)localObject).getTag()).jdField_a_of_type_Int != 2131691334) {
                break label576;
              }
              localObject = ((View)localObject).findViewById(2131368176);
              this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject).a(53).a();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
              continue;
              if (((biaa)localException.getTag()).jdField_a_of_type_Int == 2131691323)
              {
                this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localException.findViewById(2131377774));
                this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localException.findViewById(2131368176));
                if (aivo.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin()))
                {
                  this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131165548));
                  this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839341);
                }
                else
                {
                  this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131166903));
                  this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839342);
                }
              }
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      paramView = ((axlx)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36)).a("101210.101211");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(paramView);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch == null) || (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)) {
      if (azjh.a(azjh.g)) {
        break label852;
      }
    }
    label852:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean != this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.g) {
        this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_b_of_type_Boolean);
      }
      bkny.a(BaseApplicationImpl.getContext(), "peak_preload_plus_panel");
      b();
      if (this.jdField_d_of_type_Boolean) {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800A69B", "0X800A69B", 0, 0, "", "", "", "");
      }
      return;
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
    return (this.jdField_a_of_type_Bhzx != null) && (this.jdField_a_of_type_Bhzx.isShowing());
  }
  
  public biaa b(int[] paramArrayOfInt)
  {
    biaa localbiaa = new biaa();
    localbiaa.jdField_a_of_type_Int = paramArrayOfInt[0];
    localbiaa.c = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramArrayOfInt[0]);
    localbiaa.b = paramArrayOfInt[1];
    RecentDanceConfigMgr.DItemInfo localDItemInfo = RecentDanceConfigMgr.a();
    if (localDItemInfo != null)
    {
      localbiaa.jdField_a_of_type_JavaLangString = localDItemInfo.showName;
      localbiaa.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = localDItemInfo.drawable;
      return localbiaa;
    }
    localbiaa.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramArrayOfInt[0]);
    localbiaa.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
    return localbiaa;
  }
  
  public void b()
  {
    if (a()) {
      this.jdField_a_of_type_Bhzx.dismiss();
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
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004077", "0X8004077", 0, 0, "", "", "", "");
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
    localIntent.putExtra("leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690623));
    localIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690623));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004839", "0X8004839", 0, 0, "", "", "", "");
    try
    {
      ((axlx)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36)).b(String.valueOf("101210.101211"));
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void e() {}
  
  protected void f()
  {
    bisq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 8, null);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X80053AD", "0X80053AD", 0, 0, "", "", "", "");
  }
  
  protected void g()
  {
    long l = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "click", null, 0, null);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QrcodeHbGuiderActivity.class);
    localIntent.putExtra("appInfo", "");
    localIntent.putExtra("vacreport_key_seq", l);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "jiahao.hongbao.click", 0, 0, "", "", "", "");
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
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004074", "0X8004074", 0, 0, "", "", "", "");
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00899", "Grp_create", "", "msg_page", "exp_creategrp", 0, 0, "", "", "", "");
  }
  
  protected void i()
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X800780A", "0X800780A", 0, 0, "", "", "", "");
    wxj.a("plus_shoot", "clk_entry", 0, 0, new String[] { "", "", "", "" });
    wxj.a("plus_shoot", "exp_shoot", 0, 0, new String[] { "", "", "", "" });
    if (this.jdField_b_of_type_Boolean) {
      azjh.a(azjh.g);
    }
    j();
    if (biqe.a != null) {
      biqe.a.b();
    }
  }
  
  protected void j()
  {
    if (!VideoEnvironment.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) {
      bdgm.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(alud.a(2131713598)).setPositiveButton(2131694953, new ajkj(this)).show();
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
      boolean bool = azgd.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      RecentDanceConfigMgr.a("showDanceCategoryPanel: videoUsable=" + bool);
      axpl.h();
      localObject = bkmr.a(null, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getName(), 10004, 8, ((RecentDanceConfigMgr.DItemInfo)localObject).unfold, ((RecentDanceConfigMgr.DItemInfo)localObject).categoryID, ((RecentDanceConfigMgr.DItemInfo)localObject).itemID);
      xpk.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Bundle)localObject, 9010);
    } while (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a());
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(false);
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Bhzx != null) {
      this.jdField_a_of_type_Bhzx.a();
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
      aqhg.a().b(4);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800A69C", "0X800A69C", 0, 0, "", "", "", "");
      return;
    }
    QLog.e("RecentOptPopBar", 2, "activity or app is null");
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bhzx.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkg
 * JD-Core Version:    0.7.0.1
 */