import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.11;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.4;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.LinkSpan;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

@TargetApi(9)
public class aagb
  extends QQCustomDialog
  implements View.OnClickListener, Observer
{
  int jdField_a_of_type_Int = 0;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bfhz a;
  public bfid a;
  protected bfie a;
  bfxw jdField_a_of_type_Bfxw;
  protected URLImageView a;
  TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  public QQAppInterface a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = null;
  protected String a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  protected boolean b;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean = false;
  View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  protected boolean d;
  protected View e;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  boolean jdField_e_of_type_Boolean = false;
  boolean f;
  public boolean g = false;
  boolean h = false;
  boolean i = false;
  
  public aagb(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, bfxw parambfxw, String paramString)
  {
    super(paramBaseActivity, 2131755829);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidOsHandler = new aagd(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    if (((paramBaseActivity instanceof SplashActivity)) || ((paramBaseActivity instanceof ChatActivity)))
    {
      paramBaseActivity = ((FragmentActivity)paramBaseActivity).getChatFragment();
      if ((paramBaseActivity != null) && ((paramBaseActivity.a() instanceof TroopChatPie))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = ((TroopChatPie)paramBaseActivity.a());
      }
      this.jdField_a_of_type_Bfxw = parambfxw;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      paramBaseActivity = (awzf)paramQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
    }
    try
    {
      this.jdField_a_of_type_Bfhz = paramBaseActivity.a(Long.valueOf(Long.parseLong(paramString)), true);
      this.jdField_b_of_type_JavaLangString = paramString;
      if (a()) {
        this.jdField_e_of_type_Boolean = true;
      }
      setOnDismissListener(new aagc(this));
      this.f = TroopInfo.isHomeworkTroop(paramQQAppInterface, paramString);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopTipsPopWindow", 2, paramQQAppInterface.toString());
    }
    dismiss();
    return;
  }
  
  public static String a(long paramLong)
  {
    Date localDate = new Date(paramLong * 1000L);
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTime(localDate);
    try
    {
      paramLong = NetConnInfoCenter.getServerTime();
      Object localObject2 = new Date(paramLong * 1000L);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime((Date)localObject2);
      localObject2 = new SimpleDateFormat("HH:mm");
      if (((Calendar)localObject1).get(1) == localCalendar.get(1))
      {
        localObject1 = new SimpleDateFormat("M月d日");
        return ((SimpleDateFormat)localObject1).format(localDate) + " " + ((SimpleDateFormat)localObject2).format(localDate);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramLong = System.currentTimeMillis() / 1000L;
      }
    }
    return new SimpleDateFormat("yyyy年M月d日").format(localDate);
  }
  
  public static String a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l2 = 60L * 60L;
    long l3 = 24L * l2;
    Date localDate = new Date(1000L * paramLong);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(localDate);
    long l1;
    Calendar localCalendar2;
    Object localObject4;
    try
    {
      l1 = NetConnInfoCenter.getServerTime();
      Object localObject1 = new Date(1000L * l1);
      localCalendar2 = Calendar.getInstance();
      localCalendar2.setTime((Date)localObject1);
      Object localObject2 = new SimpleDateFormat("yyyy-MM-dd");
      localObject4 = ((SimpleDateFormat)localObject2).format((Date)localObject1);
      localObject1 = null;
      try
      {
        localObject2 = ((SimpleDateFormat)localObject2).parse((String)localObject4);
        localObject1 = localObject2;
        localObject4 = new Date(((Date)localObject2).getTime() - 1000L * l3);
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      catch (Exception localException2)
      {
        Object localObject3;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopTipsPopWindow", 2, "get today failed! msg = " + localException2.getMessage());
          }
          localObject3 = null;
        }
        localObject4 = new SimpleDateFormat("HH:mm");
        l1 -= paramLong;
        paramLong = l1;
        if (l1 >= 0L) {
          break label239;
        }
        paramLong = 0L;
        if (paramLong >= 60L) {
          break label253;
        }
        return anvx.a(2131715045);
        if (paramLong >= l2) {
          break label310;
        }
        l1 = ((float)paramLong / (float)60L + 0.5F);
        paramLong = l1;
        if (l1 != 0L) {
          break label286;
        }
        paramLong = 1L;
        return paramLong + anvx.a(2131715040);
        if (paramLong >= l3) {
          break label448;
        }
        if (localDate.getDate() == localException1.getDate()) {
          break label376;
        }
        if (!paramBoolean1) {
          break label369;
        }
        return anvx.a(2131715041) + " " + ((SimpleDateFormat)localObject4).format(localDate);
        return anvx.a(2131715043);
        if (!paramBoolean3) {
          break label411;
        }
        return anvx.a(2131715044) + ((SimpleDateFormat)localObject4).format(localDate);
        paramLong = ((float)paramLong / (float)l2 + 0.5D);
        return paramLong + anvx.a(2131715042);
        if ((!paramBoolean2) || (paramLong >= 72L * l2) || (localObject3.getTime() - localDate.getTime() > 1000L * l3)) {
          break label530;
        }
        if (!paramBoolean1) {
          break label523;
        }
        return anvx.a(2131715036) + " " + ((SimpleDateFormat)localObject4).format(localDate);
        return anvx.a(2131715039);
        if ((paramLong >= 48L * l2) || (localException1.getTime() - localDate.getTime() > 1000L * l3)) {
          break label608;
        }
        if (!paramBoolean1) {
          break label601;
        }
        return anvx.a(2131715037) + " " + ((SimpleDateFormat)localObject4).format(localDate);
        return anvx.a(2131715047);
        if (localCalendar1.get(1) != localCalendar2.get(1)) {
          break label683;
        }
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM-dd");
        if (!paramBoolean1) {
          break label675;
        }
        return localSimpleDateFormat.format(localDate) + " " + ((SimpleDateFormat)localObject4).format(localDate);
        return localSimpleDateFormat.format(localDate);
      }
      if ((localObject1 == null) || (localObject2 == null)) {
        return "unknown";
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        l1 = System.currentTimeMillis() / 1000L;
      }
    }
    label239:
    label253:
    return new SimpleDateFormat("yyyy-MM-dd").format(localDate);
  }
  
  public static String a(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("qbiz_host_ip_map", 0).getString(paramString, "");
  }
  
  private boolean a(JSONObject paramJSONObject, int paramInt)
  {
    if (!this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_Bfhz.deleteObserver(this);
      return false;
    }
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_Bfid != null) {
        break label52;
      }
      QLog.d("TroopTipsPopWindow", 2, "initNorNoticeView mTroopNotify  is null.");
    }
    while (this.jdField_a_of_type_Bfid == null)
    {
      dismiss();
      return false;
      label52:
      QLog.d("TroopTipsPopWindow", 2, "initNorNoticeView mTroopNotify" + this.jdField_a_of_type_Bfid.toString());
    }
    this.jdField_a_of_type_Bfid.jdField_a_of_type_Int = paramInt;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bfid.f)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(new QQText(Html.fromHtml(this.jdField_a_of_type_Bfid.jdField_c_of_type_JavaLangString), 8));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Bfid.jdField_b_of_type_Int + anvx.a(2131715038));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_Bfid.jdField_a_of_type_Long));
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bfid.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_bulletin", "", "grp_card", "exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      if (this.jdField_a_of_type_Bfid.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697387);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131697376);
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697376));
      }
      this.jdField_d_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new aagf(this));
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bfid.d)) {
        c(this.jdField_a_of_type_Bfid.d);
      }
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697385, new Object[] { Html.fromHtml(this.jdField_a_of_type_Bfid.jdField_b_of_type_JavaLangString).toString(), this.jdField_a_of_type_Bfid.h, a(this.jdField_a_of_type_Bfid.jdField_a_of_type_Long, true, true, false), Html.fromHtml(this.jdField_a_of_type_Bfid.jdField_c_of_type_JavaLangString).toString() });
      }
      if ((this.jdField_a_of_type_Bfhz == null) || (this.jdField_a_of_type_Bfhz.jdField_a_of_type_Int != 1)) {
        break label469;
      }
      b();
    }
    for (;;)
    {
      return true;
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      break;
      label469:
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    }
  }
  
  public static void b(String paramString)
  {
    ThreadManager.post(new TroopNewGuidePopWindow.11(paramString), 5, null, false);
  }
  
  private void c(String paramString)
  {
    localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
    j = (int)(localDisplayMetrics.widthPixels - bhdz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 60.0F));
    int k = (int)bhdz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 150.0F);
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    try
    {
      URL localURL = new URL(paramString);
      String str2 = a(localURL.getHost());
      localObject = paramString;
      if (!TextUtils.isEmpty(str2)) {
        localObject = new URL("http", str2, localURL.getFile()).toString();
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        Object localObject;
        float f1;
        float f2;
        localMalformedURLException.printStackTrace();
        String str1 = paramString;
        continue;
        float f3 = j;
        j = (int)(f1 / f2 * f3);
        continue;
        paramString.setURLDrawableListener(new aagg(this, localDisplayMetrics));
        continue;
        j = 0;
      }
    }
    paramString = URLDrawable.getDrawable((String)localObject, j, k);
    if (paramString.getStatus() == 1)
    {
      f1 = paramString.getIntrinsicHeight();
      f2 = paramString.getIntrinsicWidth();
      localObject = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (f2 == 0.0F) {
        break label293;
      }
      if (f1 > bhdz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 150.0F))
      {
        j = (int)bhdz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 150.0F);
        if (j > 0)
        {
          ((ViewGroup.LayoutParams)localObject).height = j;
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697380));
        return;
      }
    }
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a())) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
    Object localObject2 = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = ((int)(((DisplayMetrics)localObject1).widthPixels - bhdz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 30.0F)));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject2).gravity = 17;
    int j = (int)bhdz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 10.0F);
    ((WindowManager.LayoutParams)localObject2).width = ((int)(((DisplayMetrics)localObject1).widthPixels - bhdz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 30.0F)));
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new aagh(this, j));
    localObject1 = (agkt)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getHelper(92);
    if (localObject1 != null) {
      ((agkt)localObject1).a();
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a())) {
      super.show();
    }
    a("exp_bulletin");
    if (this.jdField_a_of_type_Bfid.jdField_a_of_type_Int == 2) {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "AIOchat", "notice_exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bfid.f)) {
      a("exp_vid");
    }
    for (;;)
    {
      try
      {
        localObject1 = (QQText)this.jdField_b_of_type_AndroidWidgetTextView.getText();
        localObject1 = (QQText.LinkSpan[])((QQText)localObject1).getSpans(0, ((QQText)localObject1).length(), QQText.LinkSpan.class);
        if ((localObject1 == null) || (localObject1.length == 0)) {
          break;
        }
        a("exp_link");
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopTipsPopWindow", 2, "report exp pattern link");
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bfid.d)) {
        a("exp_pic");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_e_of_type_Boolean) {}
    bgll localbgll;
    do
    {
      do
      {
        do
        {
          return;
          if (this.f) {
            bhbu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, "Grp_notice", "AioNotice_Show", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString, "", "", "" });
          }
          switch (paramInt)
          {
          default: 
            return;
          }
        } while (this.jdField_a_of_type_Bfhz == null);
        localbgll = bglm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
      } while (localbgll == null);
      if (localbgll.jdField_a_of_type_Int != 1) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopTipsPopWindow", 2, "show. TYPE_TROOP_NOTICE, type = 1");
      }
      this.jdField_a_of_type_Bfhz.addObserver(this);
      this.jdField_a_of_type_Bfhz.a(1007, localbgll.jdField_a_of_type_JavaLangString);
      return;
    } while (this.jdField_a_of_type_Bfhz == null);
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "show. GET_NEW_GUIDE_NOTICE_REQUEST_CODE");
    }
    this.jdField_a_of_type_Bfhz.addObserver(this);
    this.jdField_a_of_type_Bfhz.b(1003);
    return;
    if (localbgll.jdField_a_of_type_Int == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopTipsPopWindow", 2, "show. TYPE_TROOP_NOTICE, type = 2");
      }
      this.jdField_a_of_type_Bfhz.addObserver(this);
      this.jdField_a_of_type_Bfhz.b(1003);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "show. GET_NOR_NOTICE, type = 0");
    }
    this.jdField_a_of_type_Bfhz.addObserver(this);
    this.jdField_a_of_type_Bfhz.b(1004);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().heightPixels - this.jdField_a_of_type_Int * 2);
  }
  
  public void a(bfie parambfie)
  {
    if ((parambfie != null) && (!TextUtils.isEmpty(parambfie.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(parambfie.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = null;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = null;
      localObject = URLDrawable.getDrawable(parambfie.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new aagi(this));
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new aagj(this, parambfie));
      return;
    }
    a(false, "json data null------");
  }
  
  void a(String paramString)
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "bulletin_popUp", paramString, 0, 0, this.jdField_b_of_type_JavaLangString, "" + this.jdField_a_of_type_Bfid.jdField_a_of_type_Int, "", "");
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    ThreadManager.post(new TroopNewGuidePopWindow.4(this, paramJSONObject, paramBoolean, paramInt), 8, null, true);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      QLog.i("zivonchen", 2, "changAdLayoutVisible show = " + paramBoolean + ", from = " + paramString);
      return;
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public boolean a()
  {
    long l = (DeviceInfoUtil.getSystemTotalMemory() * 3L + DeviceInfoUtil.getSystemAvaialbeMemory() * 7L) / 10L;
    if (l < 3136512L)
    {
      hide();
      QLog.i("TroopTipsPopWindow", 1, "availMemSize is " + l + " , smaller than 3M , TroopNewGuidePopWindow can't show ");
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131560744, null);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365174);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379056);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377134));
      if (Build.VERSION.SDK_INT > 8) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(2);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new aage(this));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372100));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364708));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131371494));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378954));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378952));
      this.jdField_b_of_type_AndroidWidgetTextView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
      this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368877));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368879));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368883));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368878));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697384));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380980));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368713);
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379572);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131379571));
      setContentView(this.jdField_a_of_type_AndroidViewView);
      setCancelable(true);
      return true;
    }
    catch (InflateException localInflateException)
    {
      hide();
      QLog.e("TroopTipsPopWindow", 2, "InflateException, OutOfMemoryError, hide TroopNewGuidePopWindow");
    }
    return false;
  }
  
  public void b()
  {
    bfhz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, new aagk(this));
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_Bfhz != null) {
      this.jdField_a_of_type_Bfhz.deleteObserver(this);
    }
    bggl localbggl = (bggl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    if (localbggl != null) {}
    for (boolean bool = localbggl.a(this.jdField_b_of_type_JavaLangString);; bool = false)
    {
      if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a()))
      {
        bggl.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.playGiftAnimationPlayList(true);
      }
      super.dismiss();
      return;
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if ((AppSetting.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.i))
    {
      bgyd.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_JavaLangString);
      this.i = true;
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    Object localObject5;
    Object localObject4;
    Object localObject1;
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131371494: 
      localObject3 = "";
      localObject5 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      localObject4 = ((TroopManager)localObject5).b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      localObject1 = localObject3;
      if (localObject4 != null)
      {
        localObject1 = localObject3;
        if (((TroopMemberInfo)localObject4).troopColorNick != null) {
          localObject1 = ((TroopMemberInfo)localObject4).troopColorNick;
        }
      }
      localObject3 = ((TroopManager)localObject5).b(this.jdField_b_of_type_JavaLangString);
      if (localObject3 == null) {
        break;
      }
    }
    for (Object localObject3 = "" + ((TroopInfo)localObject3).dwGroupClassExt;; localObject3 = "")
    {
      localObject5 = new Intent(getContext(), EditInfoActivity.class);
      ((Intent)localObject5).putExtra("edit_type", 0);
      ((Intent)localObject5).putExtra("title", getContext().getResources().getString(2131697317));
      ((Intent)localObject5).putExtra("default_text", (String)localObject1);
      if (localObject4 != null) {
        ((Intent)localObject5).putExtra("default_nick_id", ((TroopMemberInfo)localObject4).troopColorNickId);
      }
      ((Intent)localObject5).putExtra("isTroopNick", true);
      ((Intent)localObject5).putExtra("troopUin", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject5).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      ((Intent)localObject5).putExtra("max_num", 60);
      ((Intent)localObject5).putExtra("from", 0);
      getContext().startActivity((Intent)localObject5);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_bulletin", "", "grp_card", "clk", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject4 = this.jdField_b_of_type_JavaLangString;
      if (this.jdField_a_of_type_Bfid.jdField_c_of_type_Boolean) {}
      for (int j = 2;; j = 1)
      {
        bdla.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800AACA", "0X800AACA", 0, 0, (String)localObject4, (String)localObject3, String.valueOf(j), "");
        dismiss();
        break;
      }
      localObject4 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      localObject5 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_b_of_type_JavaLangString);
      localObject3 = "";
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject1 = localObject3;
      if (localObject5 != null)
      {
        localObject1 = localObject3;
        if (str != null)
        {
          if (!str.equals(((TroopInfo)localObject5).troopowneruin)) {
            break label677;
          }
          label498:
          localObject1 = "" + ((TroopInfo)localObject5).dwGroupClassExt;
        }
      }
      ((Intent)localObject4).putExtra("url", "https://web.qun.qq.com/mannounce/detail.html?_bid=148&_wv=1031#fid=" + this.jdField_a_of_type_Bfid.i + "&gc=" + this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject4).putExtra("webStyle", "noBottomBar");
      ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject4);
      a("clk_history");
      if (this.jdField_a_of_type_Bfid.jdField_c_of_type_Boolean)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject4 = this.jdField_b_of_type_JavaLangString;
        if (this.g)
        {
          j = 2;
          label641:
          bdla.b((QQAppInterface)localObject3, "dc00898", "", "", "0X800AAC9", "0X800AAC9", 0, 0, (String)localObject4, (String)localObject1, "", String.valueOf(j));
        }
      }
      for (;;)
      {
        dismiss();
        break;
        label677:
        if ((((TroopInfo)localObject5).Administrator == null) || (!((TroopInfo)localObject5).Administrator.contains(str))) {
          break label498;
        }
        break label498;
        j = 1;
        break label641;
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AAC8", "0X800AAC8", 0, 0, this.jdField_b_of_type_JavaLangString, (String)localObject1, "", "");
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bfid.f))
      {
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", this.jdField_a_of_type_Bfid.f);
        ((Intent)localObject1).putExtra("webStyle", "noBottomBar");
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
        a("clk_vid");
        break;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_Bfid.e)) {
        break;
      }
      localObject4 = new ArrayList();
      localObject3 = this.jdField_a_of_type_Bfid.e;
      try
      {
        localObject5 = new URL((String)localObject3);
        str = a(((URL)localObject5).getHost());
        localObject1 = localObject3;
        if (!TextUtils.isEmpty(str)) {
          localObject1 = new URL("http", str, ((URL)localObject5).getFile()).toString();
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          localMalformedURLException.printStackTrace();
          Object localObject2 = localObject3;
        }
      }
      ((ArrayList)localObject4).add(localObject1);
      bfxp.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, (ArrayList)localObject4, true, "", -1);
      a("clk_pic");
      break;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (this.jdField_a_of_type_Bfhz != null) {
      this.jdField_a_of_type_Bfhz.deleteObserver(this);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a())) {}
    label32:
    do
    {
      do
      {
        do
        {
          do
          {
            break label32;
            break label32;
            do
            {
              return;
            } while (!(paramObject instanceof Integer));
            paramObservable = (Integer)paramObject;
            if (QLog.isColorLevel()) {
              QLog.d("TroopTipsPopWindow", 2, "update, notifyType = " + paramObservable);
            }
            if (paramObservable.intValue() != 106) {
              break;
            }
            if ((this.jdField_a_of_type_Bfhz != null) && (this.jdField_a_of_type_Bfhz.jdField_a_of_type_OrgJsonJSONObject != null))
            {
              a(this.jdField_a_of_type_Bfhz.jdField_a_of_type_OrgJsonJSONObject, 2, false);
              return;
            }
          } while (!QLog.isColorLevel());
          QLog.d("TroopTipsPopWindow", 2, "mNewGuideNotice = null!");
          return;
          if (paramObservable.intValue() != 1007) {
            break;
          }
          if ((this.jdField_a_of_type_Bfhz != null) && (this.jdField_a_of_type_Bfhz.b != null))
          {
            a(this.jdField_a_of_type_Bfhz.b, 1, false);
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d("TroopTipsPopWindow", 2, "mNewNorNotice = null!");
        return;
        if (paramObservable.intValue() != 1011) {
          break;
        }
        if ((this.jdField_a_of_type_Bfhz != null) && (this.jdField_a_of_type_Bfhz.b != null))
        {
          a(this.jdField_a_of_type_Bfhz.b, 1, true);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopTipsPopWindow", 2, "mNewNorNotice = null!");
      return;
    } while (paramObservable.intValue() != 1012);
    bglm.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aagb
 * JD-Core Version:    0.7.0.1
 */