import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.store.openbox.RoundRectLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.XEditTextEx;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ahfp
  extends BaseChatPie
{
  public static final String b;
  public static String c;
  private int jdField_a_of_type_Int;
  private ahgb jdField_a_of_type_Ahgb;
  protected amwl a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ahfu(this);
  private atyc jdField_a_of_type_Atyc;
  private atyd jdField_a_of_type_Atyd;
  private atyo jdField_a_of_type_Atyo = new ahfq(this);
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private List<ahga> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ahgb jdField_b_of_type_Ahgb;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new ahfv(this);
  private atyc jdField_b_of_type_Atyc;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private String d;
  private String e;
  private String f;
  
  static
  {
    jdField_b_of_type_JavaLangString = atyn.jdField_a_of_type_JavaLangString + "GameMsgChatPie";
    jdField_c_of_type_JavaLangString = "285982074";
  }
  
  public ahfp(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Amwl = new ahfy(this);
  }
  
  private String a(atyc paramatyc)
  {
    if (paramatyc == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(300);
    localStringBuilder.append(paramatyc.i).append(paramatyc.k).append("-").append(paramatyc.f);
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    Object localObject = this.mActivity.getIntent();
    String str1 = ((Intent)localObject).getStringExtra("game_msg_friend_role_id");
    String str2 = ((Intent)localObject).getStringExtra("game_msg_my_role_id");
    QLog.i(jdField_b_of_type_JavaLangString, 1, "friRoleId:" + str1 + ",myRoleId:" + str2);
    this.jdField_a_of_type_Ahgb = new ahgb(this.app, str2, true, this.mActivity);
    this.jdField_b_of_type_Ahgb = new ahgb(this.app, str1, false, this.mActivity);
    this.sessionInfo.setFriendRoleId(str1);
    this.sessionInfo.setMyRoleId(str2);
    this.jdField_a_of_type_Atyc = this.jdField_a_of_type_Atyd.a(str1);
    this.jdField_b_of_type_Atyc = this.jdField_a_of_type_Atyd.a(str2);
    String str3;
    if (this.jdField_a_of_type_Atyc != null)
    {
      str3 = this.jdField_a_of_type_Atyc.jdField_c_of_type_JavaLangString;
      if (this.jdField_a_of_type_Atyc.jdField_c_of_type_Int != 0) {
        break label229;
      }
    }
    label229:
    for (localObject = "1";; localObject = "0")
    {
      atyf.a(str3, "1", "145", "920", "92005", "206350", "", (String)localObject, "8", "0");
      localObject = (atyn)this.app.getBusinessHandler(175);
      ((atyn)localObject).a(str2, str1);
      if (this.jdField_a_of_type_Atyc != null) {
        ((atyn)localObject).a(this.jdField_a_of_type_Atyc.jdField_c_of_type_JavaLangString);
      }
      return;
    }
  }
  
  private void a(ahfz paramahfz)
  {
    if (paramahfz == null) {
      QLog.i(jdField_b_of_type_JavaLangString, 1, "[doOnButtonClick] buttonInfo is null.");
    }
    for (;;)
    {
      return;
      if (paramahfz.jdField_a_of_type_Int == 1)
      {
        paramahfz = paramahfz.jdField_a_of_type_JavaLangString;
        Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
        localIntent.putExtra("url", paramahfz);
        getActivity().startActivity(localIntent);
      }
      while ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
        return;
        if ((paramahfz.jdField_a_of_type_Int == 3) && (this.mActivity != null)) {
          this.mActivity.doOnBackPressed();
        }
      }
    }
  }
  
  private void a(atyc paramatyc)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "[setTitleInfo]");
    }
    if (paramatyc == null) {}
    try
    {
      QLog.w(jdField_b_of_type_JavaLangString, 1, "detail info is null.");
      this.mTitleBtnRightLayout.setVisibility(4);
      this.mTitleText.setText(amtj.a(2131692592));
      return;
    }
    catch (Throwable paramatyc)
    {
      Object localObject;
      QLog.e(jdField_b_of_type_JavaLangString, 1, paramatyc.getMessage());
      return;
    }
    paramatyc.a();
    if (!TextUtils.isEmpty(paramatyc.e))
    {
      this.mTitleText.setText(paramatyc.e);
      localObject = a(paramatyc);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        setSubTitleVisable(true);
        this.mSubTilteText.setText((CharSequence)localObject);
      }
      if (paramatyc.jdField_a_of_type_Int > 0)
      {
        if (this.mCustomTitleView != null) {
          this.mCustomTitleView.setEarIconVisible(false);
        }
        this.mTitleIcon.setVisibility(8);
        if (paramatyc.jdField_a_of_type_Int != 1) {
          break label328;
        }
      }
    }
    label328:
    for (int i = 2130840204;; i = 2130840203)
    {
      this.mTitleIcon2.setVisibility(0);
      this.mTitleIcon2.setImageDrawable(getActivity().getResources().getDrawable(i));
      if (!TextUtils.isEmpty(paramatyc.g))
      {
        this.mTitleIconRight.setVisibility(0);
        localObject = (LinearLayout.LayoutParams)this.mTitleIconRight.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject).width = AIOUtils.dp2px(18.0F, BaseApplication.getContext().getResources());
        ((LinearLayout.LayoutParams)localObject).height = AIOUtils.dp2px(18.0F, BaseApplication.getContext().getResources());
        localObject = URLDrawable.getDrawable(paramatyc.g);
        this.mTitleIconRight.setImageDrawable((Drawable)localObject);
      }
      if (TextUtils.isEmpty(paramatyc.j)) {
        return;
      }
      this.mTitleBtnRightLayout.setVisibility(0);
      this.mTitleBtnRight.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramatyc = URLDrawable.getDrawable(paramatyc.j);
      this.mCustomTitleView.setRight1Icon(paramatyc);
      return;
      this.mTitleText.setText(amtj.a(2131692592));
      break;
    }
  }
  
  private void a(String paramString1, String paramString2, ahfz paramahfz1, ahfz paramahfz2)
  {
    if ((paramahfz1 == null) && (paramahfz2 == null)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      return;
    }
    if ((paramahfz1 != null) && (paramahfz2 != null)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.mActivity, 230, paramString1, paramString2, paramahfz1.jdField_b_of_type_JavaLangString, paramahfz2.jdField_b_of_type_JavaLangString, new ahfr(this, paramahfz2), new ahfs(this, paramahfz1));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      if (paramahfz1 != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.mActivity, 230, paramString1, paramString2, paramahfz1.jdField_b_of_type_JavaLangString, "", null, new ahft(this, paramahfz1));
      }
    }
  }
  
  private boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "[showStartGame]");
    }
    if (a() == null) {
      return false;
    }
    atyf.a(this.mActivity, a());
    return true;
  }
  
  private void b()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.mCustomTitleView != null) {
        this.mCustomTitleView.a(false);
      }
      if ((this.jdField_c_of_type_Boolean) && (getApp() != null) && (this.jdField_a_of_type_Atyc != null))
      {
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0);
        String str = getApp().getCurrentUin() + "_game_msg_chatpie_reddot_click_" + this.jdField_a_of_type_Atyc.jdField_c_of_type_JavaLangString;
        localSharedPreferences.edit().putBoolean(str, true).commit();
      }
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_Atyc == null)
    {
      QLog.w(jdField_b_of_type_JavaLangString, 1, "friendGameInfo is null.");
      return false;
    }
    String str = this.jdField_a_of_type_Atyc.i;
    if (TextUtils.isEmpty(str))
    {
      QLog.w(jdField_b_of_type_JavaLangString, 1, "[showDialogIfBlocked], gameName is null.");
      return false;
    }
    str = String.format(amtj.a(2131692598), new Object[] { str });
    bfur.a(this.mActivity, 230, amtj.a(2131692599), str, amtj.a(2131690620), amtj.a(2131692597), new ahfw(this), new ahfx(this)).show();
    return true;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  @TargetApi(14)
  private void d()
  {
    hideAllPanels();
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      Object localObject1 = new RelativeLayout(getActivity());
      Object localObject2 = new RoundRectLinearLayout(getActivity());
      ((RoundRectLinearLayout)localObject2).setRoundRect(AIOUtils.dp2px(15.0F, getActivity().getResources()), -1, false);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(30.0F, getActivity().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new View(getActivity());
      ((View)localObject2).setBackgroundColor(-1);
      localObject3 = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(450.0F, getActivity().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(10.0F, getActivity().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new TextView(getActivity());
      ((TextView)localObject2).setText("游戏中心启动专属特权");
      ((TextView)localObject2).setTextColor(-13421773);
      ((TextView)localObject2).setTextSize(20.0F);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(20.0F, getActivity().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.dp2px(20.0F, getActivity().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new ImageView(getActivity());
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((ImageView)localObject2).setImageResource(2130850760);
      ((ImageView)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(11);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(5.0F, getActivity().getResources());
      ((RelativeLayout.LayoutParams)localObject3).rightMargin = AIOUtils.dp2px(10.0F, getActivity().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new ImageView(getActivity());
      localObject3 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(60.0F, getActivity().getResources()), AIOUtils.dp2px(60.0F, getActivity().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(66.0F, getActivity().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.dp2px(20.0F, getActivity().getResources());
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Atyc.j))
      {
        new File(amip.k + "boxcard/").mkdirs();
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = AIOUtils.dp2px(60.0F, getActivity().getResources());
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = AIOUtils.dp2px(60.0F, getActivity().getResources());
        ((ImageView)localObject2).setImageDrawable(amdn.a(Utils.Crc64String(this.jdField_a_of_type_Atyc.j), (URLDrawable.URLDrawableOptions)localObject4, this.jdField_a_of_type_Atyc.j));
      }
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new TextView(getActivity());
      if (this.jdField_a_of_type_Atyc != null) {
        ((TextView)localObject2).setText(this.jdField_a_of_type_Atyc.i);
      }
      ((TextView)localObject2).setTextColor(-13421773);
      ((TextView)localObject2).setTextSize(15.0F);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(75.0F, getActivity().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.dp2px(88.0F, getActivity().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new TextView(getActivity());
      ((TextView)localObject2).setText("启动特权生效中");
      ((TextView)localObject2).setClickable(false);
      ((TextView)localObject2).setTextColor(-32768);
      ((TextView)localObject2).setDuplicateParentStateEnabled(false);
      ((TextView)localObject2).setBackgroundDrawable(new aqwx(385843200, AIOUtils.dp2px(4.0F, getActivity().getResources()), AIOUtils.dp2px(80.0F, getActivity().getResources()), AIOUtils.dp2px(18.0F, getActivity().getResources())));
      ((TextView)localObject2).setTextSize(10.0F);
      ((TextView)localObject2).setGravity(17);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(101.0F, getActivity().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.dp2px(88.0F, getActivity().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new View(getActivity());
      ((View)localObject2).setBackgroundColor(369098752);
      localObject3 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(335.0F, getActivity().getResources()), 1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(142.0F, getActivity().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        int i = 0;
        while ((i < this.jdField_a_of_type_JavaUtilList.size()) && (i < 4))
        {
          localObject2 = (ahga)this.jdField_a_of_type_JavaUtilList.get(i);
          localObject3 = new ImageView(getActivity());
          ((ImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          localObject4 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(40.0F, getActivity().getResources()), AIOUtils.dp2px(40.0F, getActivity().getResources()));
          ((RelativeLayout.LayoutParams)localObject4).addRule(10);
          ((RelativeLayout.LayoutParams)localObject4).addRule(9);
          ((RelativeLayout.LayoutParams)localObject4).topMargin = AIOUtils.dp2px(158.0F, getActivity().getResources());
          f1 = (float)((DeviceInfoUtil.getPortraitWidth() - AIOUtils.dp2px(40.0F, getActivity().getResources()) * this.jdField_a_of_type_JavaUtilList.size()) / (this.jdField_a_of_type_JavaUtilList.size() + 1));
          ((RelativeLayout.LayoutParams)localObject4).leftMargin = ((int)(f1 + (AIOUtils.dp2px(40.0F, getActivity().getResources()) + f1) * i));
          if (!TextUtils.isEmpty(((ahga)localObject2).jdField_a_of_type_JavaLangString)) {
            ((ImageView)localObject3).setImageDrawable(URLDrawable.getDrawable(((ahga)localObject2).jdField_a_of_type_JavaLangString));
          }
          ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          localObject3 = new TextView(getActivity());
          ((TextView)localObject3).setText(((ahga)localObject2).jdField_b_of_type_JavaLangString);
          ((TextView)localObject3).setTextColor(-2144128205);
          ((TextView)localObject3).setTextSize(12.0F);
          ((TextView)localObject3).setLines(3);
          ((TextView)localObject3).setGravity(3);
          localObject2 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(63.0F, getActivity().getResources()), -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          f1 = (float)((DeviceInfoUtil.getPortraitWidth() - AIOUtils.dp2px(63.0F, getActivity().getResources()) * this.jdField_a_of_type_JavaUtilList.size()) / (this.jdField_a_of_type_JavaUtilList.size() + 1));
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(f1 + (AIOUtils.dp2px(63.0F, getActivity().getResources()) + f1) * i));
          ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.dp2px(208.0F, getActivity().getResources());
          ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
          i += 1;
        }
      }
      localObject2 = new RoundRectLinearLayout(getActivity());
      localObject3 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(335.0F, getActivity().getResources()), AIOUtils.dp2px(40.0F, getActivity().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(12);
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.dp2px(32.0F, getActivity().getResources());
      ((RoundRectLinearLayout)localObject2).setGravity(17);
      float f1 = AIOUtils.dp2px(20.0F, getActivity().getResources());
      Object localObject4 = new ShapeDrawable(new RoundRectShape(new float[] { f1, f1, f1, f1, f1, f1, f1, f1 }, null, null));
      LinearGradient localLinearGradient = new LinearGradient(0.0F, 0.0F, AIOUtils.dp2px(335.0F, getActivity().getResources()), 0.0F, -16733441, -16751361, Shader.TileMode.CLAMP);
      ((ShapeDrawable)localObject4).getPaint().setShader(localLinearGradient);
      ((RoundRectLinearLayout)localObject2).setBackgroundDrawable((Drawable)localObject4);
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(getActivity());
      ((TextView)localObject3).setText("立即启动");
      ((TextView)localObject3).setTextColor(-1);
      ((TextView)localObject3).setTextSize(16.0F);
      ((TextView)localObject3).getPaint().setFakeBoldText(true);
      ((TextView)localObject3).setGravity(17);
      ((RoundRectLinearLayout)localObject2).addView((View)localObject3);
      ((RoundRectLinearLayout)localObject2).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(getActivity(), 2131755826);
      this.jdField_a_of_type_AndroidAppDialog.setContentView((View)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      ((Window)localObject1).setGravity(80);
      if (Build.VERSION.SDK_INT >= 14) {
        ((Window)localObject1).setDimAmount(0.5F);
      }
      ((Window)localObject1).setWindowAnimations(2131755544);
      ((Window)localObject1).setLayout(-1, AIOUtils.dp2px(460.0F, getActivity().getResources()));
    }
    if (this.jdField_a_of_type_Atyc != null) {
      atyf.a(this.jdField_a_of_type_Atyc.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "207564", "", "", "8", "0");
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public ahgb a()
  {
    return this.jdField_a_of_type_Ahgb;
  }
  
  public atyc a()
  {
    return this.jdField_a_of_type_Atyc;
  }
  
  public void addBusinessObservers()
  {
    super.addBusinessObservers();
    this.app.addObserver(this.jdField_a_of_type_Atyo);
    this.app.addDefaultObservers(this.jdField_a_of_type_Amwl);
  }
  
  public void adjustInputLayout(int paramInt)
  {
    super.adjustInputLayout(paramInt);
    afqu localafqu = (afqu)getHelper(56);
    if (localafqu != null) {
      localafqu.d();
    }
  }
  
  public ahgb b()
  {
    return this.jdField_b_of_type_Ahgb;
  }
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    this.jdField_a_of_type_Atyd = ((atyd)this.app.getManager(358));
    a();
    QLog.i(jdField_b_of_type_JavaLangString, 1, "[doOnCreate]");
    return super.doOnCreate(paramBoolean);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    afqu localafqu = (afqu)getHelper(56);
    if (localafqu != null) {
      localafqu.a(getStatusTxtDartElseLight());
    }
    if (this.jdField_a_of_type_Atyd != null) {
      this.jdField_a_of_type_Atyd.c(this.sessionInfo.curFriendUin);
    }
  }
  
  public void doOnResume_updateUI()
  {
    super.doOnResume_updateUI();
    afqu localafqu = (afqu)getHelper(56);
    if (localafqu != null) {
      localafqu.a(this.mTitleBtnLeft);
    }
  }
  
  public void doPanelChanged(int paramInt1, int paramInt2)
  {
    super.doPanelChanged(paramInt1, paramInt2);
    afqu localafqu = (afqu)getHelper(56);
    if (localafqu != null) {
      localafqu.a(paramInt1, paramInt2);
    }
  }
  
  public boolean enableBlur()
  {
    return this.isThemeDefault;
  }
  
  public List<ChatMessage> getAIOList()
  {
    return super.getAIOList();
  }
  
  public List<ChatMessage> getAIOList(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return super.getAIOList(paramQQAppInterface, paramBoolean);
  }
  
  public List<ChatMessage> getAIOList(boolean paramBoolean)
  {
    return super.getAIOList(paramBoolean);
  }
  
  public void getAndParseAIOList()
  {
    super.getAndParseAIOList();
  }
  
  public int initHaveUnRead()
  {
    return super.initHaveUnRead();
  }
  
  public void initHelper()
  {
    super.initHelper();
    this.helperProvider.a(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      for (;;)
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (this.jdField_a_of_type_Atyc == null) {
            break;
          }
          if (this.jdField_a_of_type_Atyc != null) {
            atyf.a(this.jdField_a_of_type_Atyc.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206356", "", "", "20", "0");
          }
          if (this.jdField_a_of_type_Atyc.jdField_c_of_type_Int == 0)
          {
            if (!b()) {
              break;
            }
            continue;
          }
          try
          {
            if (this.input.getText().toString().getBytes().length <= this.jdField_a_of_type_Atyc.d) {
              break;
            }
            ChatActivityUtils.a(this.mContext, 2131692594, 1);
          }
          catch (Throwable localThrowable) {}
        }
        break;
        if (this.jdField_a_of_type_Atyc != null) {
          atyf.a(this.jdField_a_of_type_Atyc.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "207563", "", "", "20", "0");
        }
        b();
        boolean bool = aqmy.a(this.d, BaseApplicationImpl.getApplication());
        QLog.i(jdField_b_of_type_JavaLangString, 1, "mGamePackageName:" + this.d + " isInstall:" + bool);
        if ((a() != null) && (this.jdField_a_of_type_Int == 1) && (bool) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
        {
          d();
        }
        else
        {
          if (!a()) {
            break;
          }
          continue;
          b();
          bool = aqmy.a(this.d, BaseApplicationImpl.getApplication());
          QLog.i(jdField_b_of_type_JavaLangString, 1, "mGamePackageName:" + this.d + " isInstall:" + bool);
          if ((a() != null) && (this.jdField_a_of_type_Int == 1) && (bool) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
          {
            if (this.jdField_a_of_type_Atyc != null)
            {
              atyf.a(this.jdField_a_of_type_Atyc.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206357", "1", "", "20", "0");
              atyf.a(this.jdField_a_of_type_Atyc.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "207565", "", "", "20", "0");
            }
            d();
          }
          else
          {
            if (this.jdField_a_of_type_Atyc != null) {
              atyf.a(this.jdField_a_of_type_Atyc.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206357", "0", "", "20", "0");
            }
            if (!a()) {
              break;
            }
          }
        }
      }
      if (this.jdField_a_of_type_Atyc != null) {
        atyf.a(this.jdField_a_of_type_Atyc.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206355", "", "", "20", "0");
      }
    }
  }
  
  public View onCreatePanel(int paramInt)
  {
    if (paramInt == 3)
    {
      long l = System.currentTimeMillis();
      this.mEmoPanel = ((EmoticonMainPanel)View.inflate(this.mContext, 2131559130, null));
      this.mEmoPanel.setCallBack(this);
      EmoticonMainPanel localEmoticonMainPanel = this.mEmoPanel;
      if ((isFullScreenMode()) || (this.receiptMode)) {}
      for (boolean bool = true;; bool = false)
      {
        localEmoticonMainPanel.onlySysAndEmoji = bool;
        if (isFullScreenMode()) {
          this.mEmoPanel.setHideAllSettingTabs(true);
        }
        this.mEmoPanel.disableMoreEmotionButton = this.receiptMode;
        this.mEmoPanel.disableGuide = this.receiptMode;
        this.mEmoPanel.setOnlySysEmotionEnable(true);
        this.mEmoPanel.setSysEmotionOrder(atyf.a);
        this.mEmoPanel.init(this.app, this.sessionInfo.curType, this.mContext, getTitleBarHeight(), this.defaultEpId, this.defaultPanelType, this);
        this.mEmoPanel.setEmoSettingVisibility(8);
        this.mEmoPanel.hideAllTabs();
        if (QLog.isColorLevel()) {
          QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l));
        }
        return this.mEmoPanel;
      }
    }
    return super.onCreatePanel(paramInt);
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    afqu localafqu = (afqu)getHelper(56);
    if (localafqu != null) {
      localafqu.a(getStatusTxtDartElseLight());
    }
  }
  
  public void onShowFirst(int paramInt)
  {
    super.onShowFirst(paramInt);
  }
  
  public void refreshListAdapter()
  {
    super.refreshListAdapter();
    a(this.jdField_a_of_type_Atyc);
  }
  
  public void removeBusinessObservers()
  {
    super.removeBusinessObservers();
    this.app.removeObserver(this.jdField_a_of_type_Amwl);
    this.app.removeObserver(this.jdField_a_of_type_Atyo);
  }
  
  public void setReaded()
  {
    super.setReaded();
  }
  
  public void setReaded(QQAppInterface paramQQAppInterface)
  {
    super.setReaded(paramQQAppInterface);
  }
  
  public void showBottomBar()
  {
    super.showBottomBar();
    afqu localafqu = (afqu)getHelper(56);
    if (localafqu != null) {
      localafqu.c();
    }
  }
  
  public void updateSession_updateSubTitle()
  {
    a(this.jdField_a_of_type_Atyc);
  }
  
  public void updateSession_updateTitle(Intent paramIntent)
  {
    a(this.jdField_a_of_type_Atyc);
  }
  
  public void updateSession_updateTitleLeftView(Intent paramIntent)
  {
    super.updateSession_updateTitleLeftView(paramIntent);
  }
  
  public void updateSession_updateTitleRightView()
  {
    super.updateSession_updateTitleRightView();
  }
  
  public void updateSession_updateUI(Intent paramIntent)
  {
    super.updateSession_updateUI(paramIntent);
    a(this.jdField_a_of_type_Atyc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfp
 * JD-Core Version:    0.7.0.1
 */