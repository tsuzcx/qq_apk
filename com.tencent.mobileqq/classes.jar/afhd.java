import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.intimate.StrangerIntimateView.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.CommonTroopInfo;
import com.tencent.mobileqq.data.IntimateInfo.DNAInfo;
import com.tencent.mobileqq.friends.intimate.CommonTroopListActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class afhd
  implements afgu, Handler.Callback, View.OnClickListener, View.OnTouchListener
{
  private int jdField_a_of_type_Int = 1;
  altm jdField_a_of_type_Altm = new afhf(this);
  public Context a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public FragmentActivity a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private asig jdField_a_of_type_Asig;
  asim jdField_a_of_type_Asim = new afhh(this);
  aumy jdField_a_of_type_Aumy;
  private bdbb jdField_a_of_type_Bdbb;
  bdbc jdField_a_of_type_Bdbc = new afhg(this);
  private bety jdField_a_of_type_Bety;
  public QQAppInterface a;
  private IntimateInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private Long jdField_a_of_type_JavaLangLong;
  public String a;
  public boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  public boolean b;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private View g;
  
  public afhd(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    paramQQAppInterface = LayoutInflater.from(paramContext).inflate(2131559199, null);
    this.jdField_a_of_type_AndroidViewView = paramQQAppInterface.findViewById(2131376053);
    this.jdField_b_of_type_AndroidViewView = paramQQAppInterface.findViewById(2131378035);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramQQAppInterface.findViewById(2131363024));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramQQAppInterface.findViewById(2131377998));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramQQAppInterface.findViewById(2131376382));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramQQAppInterface.findViewById(2131366916));
    this.jdField_c_of_type_AndroidViewView = paramQQAppInterface.findViewById(2131364634);
    this.jdField_d_of_type_AndroidViewView = paramQQAppInterface.findViewById(2131364638);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramQQAppInterface.findViewById(2131364637));
    this.jdField_e_of_type_AndroidViewView = paramQQAppInterface.findViewById(2131375411);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramQQAppInterface.findViewById(2131375409));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramQQAppInterface.findViewById(2131375410));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramQQAppInterface.findViewById(2131375412));
    this.g = paramQQAppInterface.findViewById(2131365597);
    this.jdField_f_of_type_AndroidViewView = paramQQAppInterface.findViewById(2131366902);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramQQAppInterface.findViewById(2131366900));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramQQAppInterface.findViewById(2131362098));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramQQAppInterface.findViewById(2131380112));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)paramQQAppInterface.findViewById(2131376208));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setEdgeEffectEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnTouchListener(this);
    this.jdField_e_of_type_AndroidViewView.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this);
    this.g.setOnTouchListener(this);
    if (AppSetting.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alud.a(2131714961));
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131714959));
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131714962));
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      paramQQAppInterface.setMargins(0, ImmersiveUtils.getStatusBarHeight(paramContext), 0, 0);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramQQAppInterface);
    }
    f();
  }
  
  private Bitmap a(String paramString)
  {
    if (this.jdField_a_of_type_Bdbb == null)
    {
      this.jdField_a_of_type_Bdbb = new bdbb(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Bdbb.a(this.jdField_a_of_type_Bdbc);
    }
    Bitmap localBitmap = this.jdField_a_of_type_Bdbb.a(1, paramString, 0, (byte)4);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Bdbb.a()) {
      this.jdField_a_of_type_Bdbb.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    return null;
  }
  
  private void a(IntimateInfo paramIntimateInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "updateIntimateInfo: " + paramIntimateInfo);
    }
    if (paramIntimateInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramIntimateInfo;
    this.jdField_a_of_type_Int = 5;
    g();
    Object localObject3;
    Object localObject4;
    Object localObject1;
    Object localObject2;
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Aumy != null))
    {
      localObject3 = this.jdField_a_of_type_Aumy.a();
      localObject4 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      localObject1 = "";
      localObject2 = this.jdField_a_of_type_Aumy.a();
      if (localObject2 != null) {
        localObject1 = ((aums)localObject2).b();
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = ((TroopManager)localObject4).a((String)localObject3, this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    }
    int i;
    if ((paramIntimateInfo.commonTroopInfoList != null) && (paramIntimateInfo.commonTroopInfoList.size() > 0))
    {
      i = paramIntimateInfo.commonTroopInfoList.size();
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(i));
      localObject1 = paramIntimateInfo.recentChatTroopInfo;
      if ((localObject1 != null) && (!TextUtils.isEmpty(((IntimateInfo.CommonTroopInfo)localObject1).troopUin)))
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(((IntimateInfo.CommonTroopInfo)localObject1).troopName);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(paramIntimateInfo.commonTroopTips);
        localObject1 = bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, ((IntimateInfo.CommonTroopInfo)localObject1).troopCode);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        if (this.jdField_b_of_type_Boolean)
        {
          azqs.b(null, "dc00898", "", "", "0X800A21B ", "0X800A21B ", 0, 0, "", "", "", "");
          QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A21B");
        }
        label340:
        if (this.jdField_b_of_type_Boolean) {
          i();
        }
        if ((paramIntimateInfo.dnaInfoList == null) || (paramIntimateInfo.dnaInfoList.size() <= 0)) {
          break label799;
        }
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_a_of_type_Aumy != null) {
          break label730;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        label392:
        localObject2 = paramIntimateInfo.dnaInfoList.iterator();
        i = 0;
        label405:
        if (!((Iterator)localObject2).hasNext()) {
          break label808;
        }
        localObject3 = (IntimateInfo.DNAInfo)((Iterator)localObject2).next();
        paramIntimateInfo = null;
        if (this.jdField_a_of_type_Aumy != null) {
          paramIntimateInfo = this.jdField_a_of_type_Aumy.a();
        }
        if (paramIntimateInfo != null) {
          break label819;
        }
        paramIntimateInfo = afgv.a(this.jdField_a_of_type_AndroidContentContext);
      }
    }
    label799:
    label808:
    label819:
    for (;;)
    {
      localObject1 = (TextView)paramIntimateInfo.findViewById(2131378033);
      localObject4 = (TextView)paramIntimateInfo.findViewById(2131377922);
      ((TextView)localObject1).setText(((IntimateInfo.DNAInfo)localObject3).wording);
      int j;
      if (((IntimateInfo.DNAInfo)localObject3).viceTitle != null)
      {
        localObject1 = new SpannableString(((IntimateInfo.DNAInfo)localObject3).viceTitle);
        if (!TextUtils.isEmpty(((IntimateInfo.DNAInfo)localObject3).linkWording))
        {
          int m = ((IntimateInfo.DNAInfo)localObject3).viceTitle.indexOf(((IntimateInfo.DNAInfo)localObject3).linkWording);
          int k = ((IntimateInfo.DNAInfo)localObject3).linkWording.length() + m;
          j = m;
          if (m < 0)
          {
            String str = ((IntimateInfo.DNAInfo)localObject3).viceTitle + ((IntimateInfo.DNAInfo)localObject3).linkWording;
            localObject1 = new SpannableString(str);
            j = ((IntimateInfo.DNAInfo)localObject3).viceTitle.length();
            k = str.length();
          }
          ((SpannableString)localObject1).setSpan(new afhe(this, (IntimateInfo.DNAInfo)localObject3), j, k, 33);
          ((TextView)localObject4).setText((CharSequence)localObject1);
          ((TextView)localObject4).setMovementMethod(LinkMovementMethod.getInstance());
        }
      }
      for (;;)
      {
        localObject1 = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject1).topMargin = bdoo.a(16.0F);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramIntimateInfo, (ViewGroup.LayoutParams)localObject1);
        i += 1;
        break label405;
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        break label340;
        label730:
        j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        if (j <= 0) {
          break label392;
        }
        i = 0;
        while (i < j)
        {
          localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
          this.jdField_a_of_type_Aumy.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, (View)localObject1);
          i += 1;
        }
        break label392;
        ((TextView)localObject4).setText((CharSequence)localObject1);
        continue;
        ((TextView)localObject4).setVisibility(8);
      }
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      QLog.d("Intimatetest2", 2, "ui ok");
      return;
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_Bety == null)
    {
      this.jdField_a_of_type_Bety = new bety(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      this.jdField_a_of_type_Bety.c(true);
    }
    this.jdField_a_of_type_Bety.a(paramString);
    if ((this.jdField_a_of_type_Bety != null) && (!this.jdField_a_of_type_Bety.isShowing()) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
      this.jdField_a_of_type_Bety.show();
    }
  }
  
  private void f()
  {
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {}
    for (String str = ""; (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (str.equals(this.jdField_c_of_type_JavaLangString)); str = aonq.a().jdField_c_of_type_JavaLangString) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840251);
    if (!TextUtils.isEmpty(str))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = bdoo.a();
      localURLDrawableOptions.mRequestHeight = bdoo.b();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localObject = URLDrawable.getDrawable(str, localURLDrawableOptions);
      ((URLDrawable)localObject).setDecodeHandler(bcyz.y);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
      this.jdField_c_of_type_JavaLangString = str;
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
  }
  
  private void g()
  {
    QLog.d("Intimatetest2", 2, "updateAddFrdBtn begin");
    alto localalto;
    if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_f_of_type_AndroidWidgetTextView != null))
    {
      localalto = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (!localalto.b(this.jdField_a_of_type_JavaLangString)) {
        break label77;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      QLog.d("Intimatetest2", 2, "updateAddFrdBtn end");
      return;
      label77:
      if (!localalto.d(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
        if (this.jdField_b_of_type_Boolean)
        {
          azqs.b(null, "dc00898", "", "", "0X800A218 ", "0X800A218 ", 0, 0, "", "", "", "");
          QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A218");
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
        if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
          this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundResource(2130840236);
        } else {
          this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundResource(2130840237);
        }
      }
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bety.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.dnaInfoList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.dnaInfoList.iterator();
        while (localIterator.hasNext()) {
          if (!TextUtils.isEmpty(((IntimateInfo.DNAInfo)localIterator.next()).linkWording))
          {
            azqs.b(null, "dc00898", "", "", "0X800A209 ", "0X800A209 ", 0, 0, "", "", "", "");
            QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A209");
          }
        }
      }
    }
    else {
      QLog.d("intimate_relationship", 2, "DnaLinkReport info null");
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Asim);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Altm);
    }
    ThreadManager.getSubThreadHandler().post(new StrangerIntimateView.1(this));
  }
  
  public void a(aums paramaums, String paramString)
  {
    if (paramaums == null) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_JavaLangString = paramaums.a();
        this.jdField_b_of_type_JavaLangString = paramString;
      } while (paramaums.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null);
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Asim);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Altm);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramaums.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramString.what = 0;
      paramString.obj = paramaums.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView == null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.scrollTo(0, 0);
  }
  
  public void a(aumy paramaumy)
  {
    if (this.jdField_a_of_type_Aumy != null)
    {
      this.jdField_a_of_type_Aumy.k();
      this.jdField_a_of_type_Aumy = null;
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
    }
    if (paramaumy == null) {
      return;
    }
    this.jdField_a_of_type_Aumy = paramaumy;
    if (this.jdField_a_of_type_Aumy != null) {
      this.jdField_a_of_type_Aumy.c(this.jdField_a_of_type_AndroidWidgetButton);
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    Bitmap localBitmap = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (localBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localBitmap = a(this.jdField_a_of_type_JavaLangString);
      if (localBitmap != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aumy != null) {
      this.jdField_a_of_type_Aumy.a();
    }
    while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void d()
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (!bdin.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
        break label148;
      }
      if (this.jdField_a_of_type_Asig == null) {
        this.jdField_a_of_type_Asig = ((asig)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(153));
      }
      localObject = new ArrayList();
    }
    for (;;)
    {
      try
      {
        l2 = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
        QLog.e("intimate_relationship", 2, "valueOf string err");
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          l1 = Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue();
          ((ArrayList)localObject).add(Long.valueOf(l2));
          this.jdField_a_of_type_Asig.a(l1, (ArrayList)localObject, null);
          if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, String.format("requestIntimateInfo, friendUin: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
          }
          return;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          for (;;)
          {
            long l2;
            long l1 = l2;
          }
        }
        localNumberFormatException1 = localNumberFormatException1;
        l1 = 0L;
      }
      l2 = l1;
      l1 = 0L;
      continue;
      label148:
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131720305);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      QLog.d("intimate_relationship", 1, String.format("requestIntimateInfo network is not available, uin: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void e()
  {
    g();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 0: 
      a((IntimateInfo)paramMessage.obj);
      return true;
    case 1: 
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, paramMessage, 1).a();
      return true;
    case 2: 
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, paramMessage, 1).a();
      return true;
    case 3: 
      a((String)paramMessage.obj);
      return true;
    }
    h();
    return true;
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Asim);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Altm);
    }
    if (this.jdField_a_of_type_Bdbb != null)
    {
      this.jdField_a_of_type_Bdbb.d();
      this.jdField_a_of_type_Bdbb = null;
    }
  }
  
  public void onClick(View paramView)
  {
    long l = SystemClock.elapsedRealtime();
    if ((this.jdField_a_of_type_JavaLangLong != null) && (l - this.jdField_a_of_type_JavaLangLong.longValue() < 500L)) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(l);
      switch (paramView.getId())
      {
      case 2131366902: 
      default: 
        return;
      case 2131362098: 
        if ((this.jdField_a_of_type_Aumy != null) && (this.jdField_a_of_type_Aumy.a() == 1)) {
          azqs.b(null, "dc00898", "", "", "0X800A214", "0X800A214", 2, 0, "", "", "", "");
        }
        azqs.b(null, "dc00898", "", "", "0X800A219 ", "0X800A219 ", 0, 0, "", "", "", "");
        QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A219");
      }
    } while (this.jdField_a_of_type_Aumy == null);
    String str = this.jdField_a_of_type_Aumy.a();
    paramView = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    Object localObject = this.jdField_a_of_type_Aumy.a();
    if (localObject != null) {}
    for (paramView = ((aums)localObject).b();; paramView = paramView.b(str, this.jdField_a_of_type_JavaLangString))
    {
      localObject = paramView;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.equals(this.jdField_a_of_type_JavaLangString)) {
          localObject = "";
        }
      }
      paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_JavaLangString, str, 3004, 17, (String)localObject, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689628), null);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
      c();
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList == null)) {
        break;
      }
      CommonTroopListActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (ArrayList)this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList, this.jdField_a_of_type_Int);
      azqs.b(null, "dc00898", "", "", "0X800A21A ", "0X800A21A ", this.jdField_a_of_type_Int, 0, "", "", "", "");
      QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A21A");
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.recentChatTroopInfo == null)) {
        break;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.recentChatTroopInfo;
      localObject = aepi.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
      ((Intent)localObject).putExtra("uin", paramView.troopCode);
      ((Intent)localObject).putExtra("uintype", 1);
      ((Intent)localObject).putExtra("uinname", paramView.troopName);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject);
      return;
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
        break;
      }
      paramView = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, FriendProfileMoreInfoActivity.class);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(paramView);
      return;
      if (this.jdField_a_of_type_Aumy == null)
      {
        paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
        ProfileActivity.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramView);
        return;
      }
      paramView = this.jdField_a_of_type_Aumy.a();
      if (!TextUtils.isEmpty(paramView))
      {
        awrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, -1);
        return;
      }
      QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
      return;
      if (this.jdField_a_of_type_Aumy == null)
      {
        paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 19);
        ProfileActivity.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramView);
        return;
      }
      paramView = this.jdField_a_of_type_Aumy.a();
      if (!TextUtils.isEmpty(paramView))
      {
        awrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_JavaLangString, 0, -1);
        return;
      }
      QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
      return;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramView.setAlpha(0.5F);
        continue;
        if (Build.VERSION.SDK_INT >= 11) {
          paramView.setAlpha(1.0F);
        }
      }
    }
  }
  
  public void p() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhd
 * JD-Core Version:    0.7.0.1
 */