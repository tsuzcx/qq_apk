import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.1;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.10;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.16;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.2;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.5;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.6;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.9;
import com.tencent.mobileqq.activity.aio.IntimateTitleSwitchView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.CommonBody;
import com.tencent.mobileqq.data.IntimateInfo.CommonTroopInfo;
import com.tencent.mobileqq.data.IntimateInfo.DNAInfo;
import com.tencent.mobileqq.data.IntimateInfo.FriendGiftInfo;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.mobileqq.data.IntimateInfo.MutualMarkInfo;
import com.tencent.mobileqq.data.IntimateInfo.PrefetchMutualMarkInfo;
import com.tencent.mobileqq.friends.intimate.CommonTroopListActivity;
import com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.FeedListView;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class acwp
  implements acxh, adjx, Handler.Callback, View.OnClickListener, View.OnTouchListener, bhbf
{
  private int jdField_a_of_type_Int;
  private acwm jdField_a_of_type_Acwm;
  private acwz jdField_a_of_type_Acwz;
  private acxa jdField_a_of_type_Acxa;
  private adka jdField_a_of_type_Adka;
  ajxl jdField_a_of_type_Ajxl = new acws(this);
  public Context a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public FragmentActivity a;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqkf jdField_a_of_type_Aqkf;
  aqkl jdField_a_of_type_Aqkl = new acwu(this);
  asrq jdField_a_of_type_Asrq;
  private baxk jdField_a_of_type_Baxk;
  baxl jdField_a_of_type_Baxl = new acwt(this);
  private bbgg jdField_a_of_type_Bbgg;
  private bcpq jdField_a_of_type_Bcpq;
  private bfol jdField_a_of_type_Bfol;
  private bhzi jdField_a_of_type_Bhzi;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private IntimateTitleSwitchView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView;
  public QQAppInterface a;
  private IntimateInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
  @Nullable
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  @Nullable
  private FeedListView jdField_a_of_type_CooperationQzoneApiFeedListView;
  private Long jdField_a_of_type_JavaLangLong;
  public String a;
  public boolean a;
  private int jdField_b_of_type_Int = 1;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private HorizontalListView jdField_b_of_type_ComTencentWidgetHorizontalListView;
  public String b;
  public boolean b;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  private View jdField_g_of_type_AndroidViewView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private boolean jdField_g_of_type_Boolean;
  private View jdField_h_of_type_AndroidViewView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private final boolean jdField_h_of_type_Boolean;
  private View jdField_i_of_type_AndroidViewView;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private boolean jdField_i_of_type_Boolean;
  private View jdField_j_of_type_AndroidViewView;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private boolean jdField_j_of_type_Boolean;
  private View k;
  private View l;
  private View m;
  private View n;
  
  public acwp(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      l1 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
      if ((l1 > 0L) && (bhbh.b()))
      {
        paramString = QzonePluginProxyActivity.a();
        localObject = new StringBuilder().append("IntimateInfoView: start to load qzone plugin ");
        if (paramString != null)
        {
          bool = true;
          QLog.i("IntimateInfoView", 1, bool);
          if (paramString != null) {
            break label1147;
          }
          QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new IntimateInfoView.1(this, paramFragmentActivity, paramQQAppInterface));
          bool = false;
          if (!bool) {
            break label1247;
          }
        }
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        try
        {
          paramString = LayoutInflater.from(paramContext).inflate(2131559146, null);
        }
        catch (Throwable localThrowable1)
        {
          long l1;
          Object localObject;
          boolean bool;
          label1147:
          paramString = null;
        }
        try
        {
          this.jdField_a_of_type_CooperationQzoneApiFeedListView = ((FeedListView)paramString.findViewById(2131368241));
          if ((paramString != null) && (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)) {
            break label1185;
          }
          paramString = LayoutInflater.from(paramContext).inflate(2131559143, null);
          this.jdField_h_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidViewView = paramString.findViewById(2131375510);
          this.jdField_b_of_type_AndroidViewView = paramString.findViewById(2131377444);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramString.findViewById(2131362989));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramString.findViewById(2131377408));
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramString.findViewById(2131369907));
          if (!this.jdField_h_of_type_Boolean) {
            break label1193;
          }
          localObject = LayoutInflater.from(paramContext).inflate(2131559144, null);
          this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131375827));
          this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131366787));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView = ((IntimateTitleSwitchView)((View)localObject).findViewById(2131368243));
          this.jdField_c_of_type_AndroidViewView = ((View)localObject).findViewById(2131364558);
          this.jdField_d_of_type_AndroidViewView = ((View)localObject).findViewById(2131364560);
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131364559));
          this.jdField_e_of_type_AndroidViewView = ((View)localObject).findViewById(2131374890);
          this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131374888));
          this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131374889));
          this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131374891));
          this.jdField_i_of_type_AndroidViewView = ((View)localObject).findViewById(2131365511);
          this.jdField_f_of_type_AndroidViewView = ((View)localObject).findViewById(2131366803);
          this.jdField_g_of_type_AndroidViewView = ((View)localObject).findViewById(2131366801);
          this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366796));
          this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366799));
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((View)localObject).findViewById(2131366802));
          this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368254));
          this.jdField_h_of_type_AndroidViewView = ((View)localObject).findViewById(2131366773);
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366771));
          this.l = ((View)localObject).findViewById(2131366782);
          this.m = ((View)localObject).findViewById(2131366777);
          this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366778));
          this.jdField_b_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((View)localObject).findViewById(2131366781));
          this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366780));
          this.jdField_j_of_type_AndroidViewView = ((View)localObject).findViewById(2131369598);
          this.k = ((View)localObject).findViewById(2131369595);
          this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131369597));
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131369897));
          this.n = ((View)localObject).findViewById(2131366776);
          if (!this.jdField_h_of_type_Boolean) {
            break label1200;
          }
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.setOverScrollMode(0);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.setEdgeEffectEnabled(false);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.setVerticalScrollBarEnabled(false);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.addHeaderView((View)localObject);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.a(paramQQAppInterface, paramFragmentActivity, l1);
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.setCallBack(this);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.setApp(paramQQAppInterface);
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
          this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
          this.k.setOnClickListener(this);
          this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
          this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
          this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_a_of_type_Acxa = new acxa(this, null);
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(bbkx.a(5.0F));
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Acxa);
          this.jdField_a_of_type_Acwz = new acwz(this, null);
          this.jdField_b_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(bbkx.a(5.0F));
          this.jdField_b_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Acwz);
          this.m.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this);
          this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
          this.jdField_d_of_type_AndroidViewView.setOnTouchListener(this);
          this.jdField_e_of_type_AndroidViewView.setOnTouchListener(this);
          this.jdField_g_of_type_AndroidViewView.setOnTouchListener(this);
          this.k.setOnTouchListener(this);
          this.jdField_i_of_type_AndroidViewView.setOnTouchListener(this);
          this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this);
          this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(this);
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnTouchListener(this);
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setTransTouchStateToParent(true);
          this.jdField_b_of_type_ComTencentWidgetHorizontalListView.setOnTouchListener(this);
          this.jdField_b_of_type_ComTencentWidgetHorizontalListView.setTransTouchStateToParent(true);
          this.m.setOnTouchListener(this);
          if (AppSetting.jdField_d_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajyc.a(2131705807));
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajyc.a(2131705817));
            this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(ajyc.a(2131705822));
            this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(ajyc.a(2131705820));
          }
          if (ImmersiveUtils.isSupporImmersive() == 1)
          {
            paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
            paramQQAppInterface.setMargins(0, ImmersiveUtils.getStatusBarHeight(paramContext), 0, 0);
            this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramQQAppInterface);
          }
          return;
        }
        catch (Throwable localThrowable2)
        {
          String str;
          break label1171;
        }
        paramString = paramString;
        l1 = 0L;
        continue;
        bool = false;
        continue;
        bool = bhbh.b(paramFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        continue;
        bool = false;
        continue;
        label1171:
        QLog.w("IntimateInfoView", 1, "IntimateInfoView: failed to load qzone feed", localThrowable1);
        continue;
        label1185:
        this.jdField_h_of_type_Boolean = true;
        continue;
        label1193:
        str = paramString;
        continue;
        label1200:
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)paramString.findViewById(2131375660));
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setEdgeEffectEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
        continue;
        label1247:
        paramString = null;
      }
    }
  }
  
  private Bitmap a(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo)
  {
    int i1 = aswz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramPrefetchMutualMarkInfo.type, paramPrefetchMutualMarkInfo.level);
    if (i1 == 0) {
      return null;
    }
    Bitmap localBitmap1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), i1);
    if (localBitmap1 == null) {
      return null;
    }
    Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth(), localBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap2);
    Paint localPaint = new Paint();
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(0.0F);
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    int i2 = localBitmap1.getHeight() + 32;
    i1 = i2;
    if (paramPrefetchMutualMarkInfo.days > 0) {
      i1 = i2 * paramPrefetchMutualMarkInfo.currentDays / paramPrefetchMutualMarkInfo.days;
    }
    i1 = 16 + localBitmap1.getHeight() - i1;
    paramPrefetchMutualMarkInfo = new Rect(0, 0, localBitmap1.getWidth(), i1);
    localCanvas.drawBitmap(localBitmap1, paramPrefetchMutualMarkInfo, paramPrefetchMutualMarkInfo, localPaint);
    paramPrefetchMutualMarkInfo = new Rect(0, i1, localBitmap1.getWidth(), localBitmap1.getHeight());
    localCanvas.drawBitmap(localBitmap1, paramPrefetchMutualMarkInfo, paramPrefetchMutualMarkInfo, null);
    return localBitmap2;
  }
  
  private Bitmap a(String paramString)
  {
    if (this.jdField_a_of_type_Baxk == null)
    {
      this.jdField_a_of_type_Baxk = new baxk(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Baxk.a(this.jdField_a_of_type_Baxl);
    }
    Bitmap localBitmap = this.jdField_a_of_type_Baxk.a(1, paramString, 0, (byte)4);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Baxk.a()) {
      this.jdField_a_of_type_Baxk.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    return null;
  }
  
  private String a(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo, boolean paramBoolean)
  {
    paramPrefetchMutualMarkInfo = "intimate_" + paramPrefetchMutualMarkInfo.type + paramPrefetchMutualMarkInfo.level + paramPrefetchMutualMarkInfo.days + paramPrefetchMutualMarkInfo.currentDays + paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "cacheName" + paramPrefetchMutualMarkInfo);
    }
    return paramPrefetchMutualMarkInfo;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {}
    for (String str = asye.b(paramInt1, paramInt2); (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (str.equals(this.jdField_c_of_type_JavaLangString)); str = asye.a(paramInt1, paramInt2)) {
      return;
    }
    Object localObject;
    if (paramInt1 == 3) {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840144);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("setBackgroundDrawable, intimateType: %s, level: %s, bgUrl: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str }));
      }
      if (TextUtils.isEmpty(str)) {
        break;
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = bbkx.a();
      localURLDrawableOptions.mRequestHeight = bbkx.b();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localObject = URLDrawable.getDrawable(str, localURLDrawableOptions);
      ((URLDrawable)localObject).setDecodeHandler(bavi.y);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
      this.jdField_c_of_type_JavaLangString = str;
      return;
      if (paramInt1 == 2) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840142);
      } else if (paramInt1 == 1) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840146);
      } else {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840150);
      }
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_Acwm == null)
    {
      ThreadManager.getFileThreadHandler().post(new IntimateInfoView.10(this, paramURLDrawable));
      return;
    }
    this.jdField_a_of_type_Acwm.a();
  }
  
  private void a(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("getPrefetchMarkIcon, type=%s, currDay=%s, day=%s", new Object[] { Integer.valueOf(paramPrefetchMutualMarkInfo.type), Integer.valueOf(paramPrefetchMutualMarkInfo.currentDays), Integer.valueOf(paramPrefetchMutualMarkInfo.days) }));
    }
    ThreadManager.getSubThreadHandler().post(new IntimateInfoView.16(this, paramPrefetchMutualMarkInfo));
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
    this.jdField_a_of_type_Int = paramIntimateInfo.maskType;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    Object localObject2;
    int i1;
    if (paramIntimateInfo.beFriendDays >= -1) {
      if (this.jdField_a_of_type_Int == 3)
      {
        this.jdField_b_of_type_Int = 4;
        this.jdField_j_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        a(this.jdField_a_of_type_Int, paramIntimateInfo.maskLevel);
        this.jdField_e_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.a(paramIntimateInfo, this.jdField_a_of_type_Int);
        if (paramIntimateInfo.memoryDayInfoList != null)
        {
          AbstractGifImage.resumeAll();
          if (this.jdField_a_of_type_Adka == null)
          {
            this.jdField_a_of_type_Adka = new adka(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Adka.a(new acwv(this));
          }
          localObject1 = new ArrayList(paramIntimateInfo.memoryDayInfoList);
          this.jdField_a_of_type_Adka.a(this.jdField_a_of_type_AndroidContentContext, (ArrayList)localObject1);
          if ((this.jdField_a_of_type_Adka.a() != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Adka.a());
          }
        }
        if (this.jdField_b_of_type_Boolean) {
          y();
        }
        if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Asrq != null))
        {
          localObject3 = this.jdField_a_of_type_Asrq.a();
          localObject4 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          localObject1 = "";
          localObject2 = this.jdField_a_of_type_Asrq.a();
          if (localObject2 != null) {
            localObject1 = ((asri)localObject2).b();
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = ((TroopManager)localObject4).a((String)localObject3, this.jdField_a_of_type_JavaLangString);
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        }
        if ((paramIntimateInfo.commonTroopInfoList == null) || (paramIntimateInfo.commonTroopInfoList.size() <= 0)) {
          break label854;
        }
        i1 = paramIntimateInfo.commonTroopInfoList.size();
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(i1));
        localObject1 = paramIntimateInfo.recentChatTroopInfo;
        if ((localObject1 == null) || (TextUtils.isEmpty(((IntimateInfo.CommonTroopInfo)localObject1).troopUin))) {
          break label824;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(((IntimateInfo.CommonTroopInfo)localObject1).troopName);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(paramIntimateInfo.commonTroopTips);
        localObject1 = baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, ((IntimateInfo.CommonTroopInfo)localObject1).troopCode);
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        label482:
        if (this.jdField_b_of_type_Boolean) {
          axqw.b(null, "dc00898", "", "", "0X8009F51", "0X8009F51", this.jdField_b_of_type_Int, 0, "", "", "", "");
        }
      }
    }
    for (;;)
    {
      localObject1 = new ArrayList();
      if ((paramIntimateInfo.markInfoList == null) || (paramIntimateInfo.markInfoList.size() <= 0)) {
        break label909;
      }
      localObject2 = paramIntimateInfo.markInfoList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (IntimateInfo.MutualMarkInfo)((Iterator)localObject2).next();
        if (a((IntimateInfo.MutualMarkInfo)localObject3)) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_b_of_type_Int = 3;
        this.jdField_j_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        a(this.jdField_a_of_type_Int, paramIntimateInfo.maskLevel);
        this.jdField_e_of_type_Boolean = true;
        break;
      }
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_b_of_type_Int = 2;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if ((this.jdField_j_of_type_AndroidViewView.getVisibility() == 8) && (this.jdField_a_of_type_Boolean)) {
          p();
        }
        this.jdField_j_of_type_AndroidViewView.setVisibility(0);
        LpReportInfo_dc03950.report(new LpReportInfo_dc03950("25", "6", "2", "1"));
        a(this.jdField_a_of_type_Int, paramIntimateInfo.maskLevel);
        if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
        {
          this.jdField_d_of_type_Boolean = true;
          v();
        }
        this.jdField_e_of_type_Boolean = true;
        break;
      }
      this.jdField_b_of_type_Int = 1;
      this.jdField_j_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      a(0, paramIntimateInfo.maskLevel);
      this.jdField_e_of_type_Boolean = false;
      break;
      a(0, paramIntimateInfo.maskLevel);
      break;
      label824:
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      break label482;
      label854:
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_b_of_type_Boolean) {
      axqw.b(null, "dc00898", "", "", "0X8009F52", "0X8009F52", this.jdField_b_of_type_Int, 0, "", "", "", "");
    }
    label909:
    if ((paramIntimateInfo.prefetchMutualMarkInfoList != null) && (paramIntimateInfo.prefetchMutualMarkInfoList.size() > 0))
    {
      localObject2 = paramIntimateInfo.prefetchMutualMarkInfoList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (IntimateInfo.MutualMarkInfo)((Iterator)localObject2).next();
        if (a((IntimateInfo.MutualMarkInfo)localObject3)) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      if (this.jdField_b_of_type_Boolean) {
        axqw.b(null, "dc00898", "", "", "0X8009F52", "0X8009F52", this.jdField_b_of_type_Int, 0, "", "", "", "");
      }
    }
    if (!((ArrayList)localObject1).isEmpty()) {
      if ((paramIntimateInfo.markInfoList == null) || (paramIntimateInfo.markInfoList.isEmpty()))
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(String.valueOf(paramIntimateInfo.prefetchMutualMarkInfoList.size()));
        this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693632));
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_Acxa.a((List)localObject1);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
        this.jdField_g_of_type_Boolean = aswy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        label1126:
        localObject1 = this.jdField_e_of_type_AndroidWidgetImageView;
        if ((!paramIntimateInfo.isShowRedPoint) && (!this.jdField_g_of_type_Boolean)) {
          break label1541;
        }
        i1 = 0;
        label1148:
        ((ImageView)localObject1).setVisibility(i1);
        if ((paramIntimateInfo.dnaInfoList == null) || (paramIntimateInfo.dnaInfoList.size() <= 0)) {
          break label1616;
        }
        this.jdField_h_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_a_of_type_Asrq != null) {
          break label1547;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        label1195:
        localObject3 = paramIntimateInfo.dnaInfoList.iterator();
        i1 = 0;
        label1208:
        if (!((Iterator)localObject3).hasNext()) {
          break label1625;
        }
        localObject4 = (IntimateInfo.DNAInfo)((Iterator)localObject3).next();
        localObject1 = null;
        if (this.jdField_a_of_type_Asrq != null) {
          localObject1 = this.jdField_a_of_type_Asrq.a();
        }
        if (localObject1 != null) {
          break label1990;
        }
        localObject1 = adjy.a(this.jdField_a_of_type_AndroidContentContext);
      }
    }
    label1541:
    label1547:
    label1990:
    for (;;)
    {
      localObject2 = (TextView)((View)localObject1).findViewById(2131377442);
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131377334);
      ((TextView)localObject2).setText(((IntimateInfo.DNAInfo)localObject4).wording);
      int i2;
      if (((IntimateInfo.DNAInfo)localObject4).viceTitle != null)
      {
        localObject2 = new SpannableString(((IntimateInfo.DNAInfo)localObject4).viceTitle);
        if (!TextUtils.isEmpty(((IntimateInfo.DNAInfo)localObject4).linkWording))
        {
          int i4 = ((IntimateInfo.DNAInfo)localObject4).viceTitle.indexOf(((IntimateInfo.DNAInfo)localObject4).linkWording);
          int i3 = ((IntimateInfo.DNAInfo)localObject4).linkWording.length() + i4;
          i2 = i4;
          if (i4 < 0)
          {
            String str = ((IntimateInfo.DNAInfo)localObject4).viceTitle + ((IntimateInfo.DNAInfo)localObject4).linkWording;
            localObject2 = new SpannableString(str);
            i2 = ((IntimateInfo.DNAInfo)localObject4).viceTitle.length();
            i3 = str.length();
          }
          ((SpannableString)localObject2).setSpan(new acww(this, (IntimateInfo.DNAInfo)localObject4), i2, i3, 33);
          localTextView.setText((CharSequence)localObject2);
          localTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }
      }
      for (;;)
      {
        localObject2 = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject2).topMargin = bbkx.a(16.0F);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        i1 += 1;
        break label1208;
        this.jdField_f_of_type_AndroidWidgetTextView.setText(String.valueOf(paramIntimateInfo.markInfoList.size()));
        break;
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
        break label1126;
        i1 = 8;
        break label1148;
        i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        if (i2 <= 0) {
          break label1195;
        }
        i1 = 0;
        while (i1 < i2)
        {
          localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
          this.jdField_a_of_type_Asrq.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, (View)localObject1);
          i1 += 1;
        }
        break label1195;
        localTextView.setText((CharSequence)localObject2);
        continue;
        localTextView.setVisibility(8);
      }
      label1616:
      this.jdField_h_of_type_AndroidViewView.setVisibility(8);
      label1625:
      if ((paramIntimateInfo.commonBodyList != null) && (paramIntimateInfo.commonBodyList.size() > 0))
      {
        localObject1 = paramIntimateInfo.commonBodyList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (IntimateInfo.CommonBody)((Iterator)localObject1).next();
          if (((IntimateInfo.CommonBody)localObject2).cmd == 3436)
          {
            paramIntimateInfo.friendGiftInfo = IntimateInfo.FriendGiftInfo.copyFrom((IntimateInfo.CommonBody)localObject2);
            if ((paramIntimateInfo.friendGiftInfo != null) && (paramIntimateInfo.friendGiftInfo.str_send_times > 0))
            {
              this.jdField_i_of_type_AndroidWidgetTextView.setText(String.valueOf(paramIntimateInfo.friendGiftInfo.str_send_times));
              this.jdField_j_of_type_AndroidWidgetTextView.setText(paramIntimateInfo.friendGiftInfo.str_desc);
              this.l.setVisibility(0);
              if (paramIntimateInfo.friendGiftInfo.str_gift_url.size() > 6) {
                this.jdField_a_of_type_Acwz.a(paramIntimateInfo.friendGiftInfo.str_gift_url.subList(0, 6));
              }
              for (;;)
              {
                this.jdField_b_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
                if (!this.jdField_b_of_type_Boolean) {
                  break;
                }
                axqw.b(null, "dc00898", "", "", "0X800A3B3", "0X800A3B3", this.jdField_b_of_type_Int, 0, "", "", "", "");
                break;
                this.jdField_a_of_type_Acwz.a(paramIntimateInfo.friendGiftInfo.str_gift_url);
              }
            }
            this.l.setVisibility(8);
            this.jdField_b_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
          }
        }
      }
      IntimatePlayTogetherMiniGameCardView.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
      if (this.jdField_b_of_type_Boolean)
      {
        axqw.b(null, "dc00898", "", "", "0X8009F4D", "0X8009F4D", this.jdField_b_of_type_Int, 0, "", "", "", "");
        if (this.jdField_b_of_type_Int == 2) {
          axqw.b(null, "dc00898", "", "", "0X800A05F", "0X800A05F", 0, 0, "", "", "", "");
        }
      }
      QLog.d("Intimatetest", 2, "ui ok");
      return;
    }
  }
  
  private void a(String paramString)
  {
    axqw.b(null, "dc00898", "", "", "0X800A11A", "0X800A11A", this.jdField_b_of_type_Int, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentImageURLDrawable == null)
    {
      c(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131694099));
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = 750;
      localURLDrawableOptions.mRequestHeight = 1272;
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    }
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) || (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 4))
    {
      w();
      a(this.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new acwy(this));
    ThreadManager.getFileThreadHandler().post(new IntimateInfoView.9(this));
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!bbev.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
        break label91;
      }
      if (this.jdField_a_of_type_Aqkf == null) {
        this.jdField_a_of_type_Aqkf = ((aqkf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(153));
      }
      this.jdField_a_of_type_Aqkf.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("disbandIntimateRelationship, friendUin: %s, type: %s", new Object[] { paramString, Integer.valueOf(paramInt) }));
      }
      return;
      label91:
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719756);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      QLog.d("intimate_relationship", 1, String.format("disbandIntimateRelationship network is not available, uin: %s", new Object[] { paramString }));
    }
  }
  
  private boolean a(IntimateInfo.MutualMarkInfo paramMutualMarkInfo)
  {
    if (!aswz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMutualMarkInfo.type)) {}
    int i1;
    do
    {
      return false;
      int i2 = aswz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramMutualMarkInfo.type, paramMutualMarkInfo.level);
      asxz localasxz = aswz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMutualMarkInfo.type);
      i1 = i2;
      if (localasxz != null)
      {
        i1 = i2;
        if (localasxz.jdField_b_of_type_Boolean) {
          i1 = 0;
        }
      }
    } while ((TextUtils.isEmpty(paramMutualMarkInfo.icon_static_url)) && (i1 == 0));
    return true;
  }
  
  private Bitmap b(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo)
  {
    int i2 = actn.a(45.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Bitmap localBitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas1 = new Canvas(localBitmap);
    Object localObject = new RectF(0.0F, 0.0F, i2, i2);
    RectF localRectF = new RectF(2, 2, i2 - 2, i2 - 2);
    Paint localPaint = new Paint(1);
    localPaint.setColor(Color.parseColor("#E8E9F3"));
    localCanvas1.drawRoundRect((RectF)localObject, 14, 14, localPaint);
    localPaint.setColor(-1);
    localCanvas1.drawRoundRect(localRectF, 12, 12, localPaint);
    localObject = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas2 = new Canvas((Bitmap)localObject);
    localPaint.setColor(Color.parseColor("#F2F4F9"));
    localCanvas2.drawRoundRect(localRectF, 12, 12, localPaint);
    if (paramPrefetchMutualMarkInfo.days > 0) {}
    for (int i1 = paramPrefetchMutualMarkInfo.currentDays * i2 / paramPrefetchMutualMarkInfo.days;; i1 = i2)
    {
      paramPrefetchMutualMarkInfo = new Rect(0, i2 - i1, i2, i2);
      localCanvas1.drawBitmap((Bitmap)localObject, paramPrefetchMutualMarkInfo, paramPrefetchMutualMarkInfo, null);
      return localBitmap;
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "disbandLoverRelationship sendRequest");
    }
    bhzg localbhzg = new bhzg();
    try
    {
      localbhzg.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()), Long.parseLong(paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramString.what = 5;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
    }
  }
  
  private void c(String paramString)
  {
    if (this.jdField_a_of_type_Bcpq == null)
    {
      this.jdField_a_of_type_Bcpq = new bcpq(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      this.jdField_a_of_type_Bcpq.c(true);
    }
    this.jdField_a_of_type_Bcpq.a(paramString);
    if ((this.jdField_a_of_type_Bcpq != null) && (!this.jdField_a_of_type_Bcpq.isShowing()) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
      this.jdField_a_of_type_Bcpq.show();
    }
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("isIntimate" + this.jdField_e_of_type_Boolean, new Object[0]));
    }
    axqw.b(null, "dc00898", "", "", "0X800A119", "0X800A119", this.jdField_b_of_type_Int, 0, "", "", "", "");
    this.jdField_a_of_type_Bfol = bfol.c(this.jdField_a_of_type_AndroidContentContext);
    String str = asye.c(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskLevel);
    if (!TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_Bfol.a(2131693644, 0);
    }
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_Bfol.a(2131693611, 3);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfol.a(new acwx(this, str));
      this.jdField_a_of_type_Bfol.c(2131690596);
      this.jdField_a_of_type_Bfol.show();
      return;
      this.jdField_a_of_type_Bfol.a(2131693623, 0);
    }
  }
  
  private void t()
  {
    axqw.b(null, "dc00898", "", "", "0X8009F71", "0X8009F71", 0, 0, "", "", "", "");
    String str = asye.a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "click menu_bind_intimate url:" + str);
    }
    if (!TextUtils.isEmpty(str))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent.putExtra("url", str));
    }
  }
  
  private void u()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      QLog.d("intimate_relationship", 1, "showDisbandDialog, mActivity == null or is finishing!");
      return;
    }
    if (this.jdField_a_of_type_Bbgg == null) {
      this.jdField_a_of_type_Bbgg = bbcv.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(2131693615).setPositiveButton(2131693614, new acwr(this)).setNegativeButton(2131693613, new acwq(this));
    }
    this.jdField_a_of_type_Bbgg.show();
  }
  
  private void v()
  {
    WebProcessManager localWebProcessManager;
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app != null))
    {
      localWebProcessManager = (WebProcessManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(13);
      if (localWebProcessManager != null) {
        break label38;
      }
    }
    label38:
    do
    {
      do
      {
        return;
      } while (!localWebProcessManager.d());
      localWebProcessManager.e();
    } while (!QLog.isColorLevel());
    QLog.d("intimate_relationship", 2, "start preloadWebProcess");
  }
  
  private void w()
  {
    if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bcpq.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void x()
  {
    String str = asye.c(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskLevel);
    if (!TextUtils.isEmpty(str))
    {
      a(str);
      return;
    }
    bcpw.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, ajyc.a(2131705808), 1).a();
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null)
    {
      Iterator localIterator;
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.memoryDayInfoList != null)
      {
        localIterator = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.memoryDayInfoList.iterator();
        while (localIterator.hasNext())
        {
          IntimateInfo.MemoryDayInfo localMemoryDayInfo = (IntimateInfo.MemoryDayInfo)localIterator.next();
          if (!TextUtils.isEmpty(localMemoryDayInfo.linkWording))
          {
            axqw.b(null, "dc00898", "", "", "0X800A207 ", "0X800A207 ", localMemoryDayInfo.dateType, 0, "", "", "", "");
            QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A207");
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.dnaInfoList != null)
      {
        localIterator = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.dnaInfoList.iterator();
        while (localIterator.hasNext()) {
          if (!TextUtils.isEmpty(((IntimateInfo.DNAInfo)localIterator.next()).linkWording))
          {
            axqw.b(null, "dc00898", "", "", "0X800A209 ", "0X800A209 ", 0, 0, "", "", "", "");
            QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A209");
          }
        }
      }
    }
    else
    {
      QLog.d("intimate_relationship", 2, "DnaLinkReport info null");
    }
  }
  
  private void z()
  {
    if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null))
    {
      if ((this.jdField_c_of_type_Int == 3) || (this.jdField_c_of_type_Int == 4)) {
        this.jdField_j_of_type_Boolean = true;
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.a(this);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aqkl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxl);
    }
    ThreadManager.getSubThreadHandler().post(new IntimateInfoView.2(this));
  }
  
  public void a(int paramInt)
  {
    boolean bool = true;
    QLog.i("IntimateInfoView", 4, "setCurrentShowType: " + paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "setCurrentShowType showType: " + paramInt + "  old:" + this.jdField_c_of_type_Int);
    }
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.setCurrentShowType(paramInt);
    if (!this.jdField_i_of_type_Boolean)
    {
      z();
      this.jdField_i_of_type_Boolean = true;
    }
    FeedListView localFeedListView;
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)
    {
      localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
      if ((paramInt == 3) || (paramInt == 4)) {
        break label131;
      }
    }
    for (;;)
    {
      localFeedListView.setLongClickValid(bool);
      return;
      label131:
      bool = false;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(asri paramasri, String paramString)
  {
    if (paramasri == null) {}
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_JavaLangString = paramasri.a();
          this.jdField_b_of_type_JavaLangString = paramString;
        } while (paramasri.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null);
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aqkl);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxl);
        }
        this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramasri.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
        paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramString.what = 0;
        paramString.obj = paramasri.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
        if (!this.jdField_h_of_type_Boolean) {
          break;
        }
      } while (this.jdField_a_of_type_CooperationQzoneApiFeedListView == null);
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.scrollTo(0, 0);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView == null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.scrollTo(0, 0);
  }
  
  public void a(asrq paramasrq)
  {
    if (this.jdField_a_of_type_Asrq != null)
    {
      this.jdField_a_of_type_Asrq.k();
      this.jdField_a_of_type_Asrq = null;
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
    }
    a(3);
    this.jdField_a_of_type_Asrq = paramasrq;
    this.jdField_f_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    Bitmap localBitmap = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (localBitmap != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localBitmap = a(this.jdField_a_of_type_JavaLangString);
      if (localBitmap != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (bbev.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)))
    {
      if (this.jdField_a_of_type_Aqkf == null) {
        this.jdField_a_of_type_Aqkf = ((aqkf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(153));
      }
      this.jdField_a_of_type_Aqkf.b(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 100	acwp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4: invokestatic 599	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +55 -> 62
    //   10: aload_0
    //   11: getfield 96	acwp:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   14: invokestatic 1094	bbev:g	(Landroid/content/Context;)Z
    //   17: ifeq +152 -> 169
    //   20: aload_0
    //   21: getfield 1096	acwp:jdField_a_of_type_Aqkf	Laqkf;
    //   24: ifnonnull +20 -> 44
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 94	acwp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   32: sipush 153
    //   35: invokevirtual 1099	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   38: checkcast 1101	aqkf
    //   41: putfield 1096	acwp:jdField_a_of_type_Aqkf	Laqkf;
    //   44: aload_0
    //   45: getfield 791	acwp:jdField_a_of_type_Asrq	Lasrq;
    //   48: ifnonnull +45 -> 93
    //   51: aload_0
    //   52: getfield 1096	acwp:jdField_a_of_type_Aqkf	Laqkf;
    //   55: aload_0
    //   56: getfield 100	acwp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   59: invokevirtual 1404	aqkf:a	(Ljava/lang/String;)V
    //   62: invokestatic 573	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq +27 -> 92
    //   68: ldc_w 575
    //   71: iconst_2
    //   72: ldc_w 1406
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: aload_0
    //   82: getfield 100	acwp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   85: aastore
    //   86: invokestatic 626	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   89: invokestatic 579	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: return
    //   93: new 770	java/util/ArrayList
    //   96: dup
    //   97: invokespecial 865	java/util/ArrayList:<init>	()V
    //   100: astore 5
    //   102: aload_0
    //   103: getfield 100	acwp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: invokestatic 1409	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   109: invokevirtual 1413	java/lang/Long:longValue	()J
    //   112: lstore_3
    //   113: aload_0
    //   114: getfield 1382	acwp:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   117: invokestatic 1409	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   120: invokevirtual 1413	java/lang/Long:longValue	()J
    //   123: lstore_1
    //   124: aload 5
    //   126: lload_3
    //   127: invokestatic 1416	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   130: invokevirtual 889	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   133: pop
    //   134: aload_0
    //   135: getfield 1096	acwp:jdField_a_of_type_Aqkf	Laqkf;
    //   138: lload_1
    //   139: aload 5
    //   141: aconst_null
    //   142: invokevirtual 1419	aqkf:a	(JLjava/util/ArrayList;Ljava/lang/Object;)V
    //   145: goto -83 -> 62
    //   148: astore 6
    //   150: lconst_0
    //   151: lstore_1
    //   152: ldc_w 575
    //   155: iconst_2
    //   156: ldc_w 1421
    //   159: invokestatic 1423	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: lload_1
    //   163: lstore_3
    //   164: lconst_0
    //   165: lstore_1
    //   166: goto -42 -> 124
    //   169: aload_0
    //   170: getfield 546	acwp:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   173: invokevirtual 1110	android/os/Handler:obtainMessage	()Landroid/os/Message;
    //   176: astore 5
    //   178: aload 5
    //   180: iconst_1
    //   181: putfield 1115	android/os/Message:what	I
    //   184: aload 5
    //   186: aload_0
    //   187: getfield 98	acwp:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   190: invokevirtual 463	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   193: ldc_w 1116
    //   196: invokevirtual 933	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   199: putfield 1120	android/os/Message:obj	Ljava/lang/Object;
    //   202: aload_0
    //   203: getfield 546	acwp:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   206: aload 5
    //   208: invokevirtual 1124	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   211: pop
    //   212: ldc_w 575
    //   215: iconst_1
    //   216: ldc_w 1425
    //   219: iconst_1
    //   220: anewarray 4	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: aload_0
    //   226: getfield 100	acwp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   229: aastore
    //   230: invokestatic 626	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   233: invokestatic 579	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: goto -174 -> 62
    //   239: astore 6
    //   241: lload_3
    //   242: lstore_1
    //   243: goto -91 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	acwp
    //   123	120	1	l1	long
    //   112	130	3	l2	long
    //   100	107	5	localObject	Object
    //   148	1	6	localNumberFormatException1	NumberFormatException
    //   239	1	6	localNumberFormatException2	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   102	113	148	java/lang/NumberFormatException
    //   113	124	239	java/lang/NumberFormatException
  }
  
  public void d(boolean paramBoolean)
  {
    QLog.i("IntimateInfoView", 4, "onLoadOver: " + paramBoolean);
    if ((this.n == null) || (this.jdField_a_of_type_CooperationQzoneApiFeedListView == null)) {
      return;
    }
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView.b() > 0)
    {
      this.n.setVisibility(0);
      return;
    }
    this.n.setVisibility(8);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.a();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.c();
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.b();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)
    {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.o_();
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.b();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.c();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.j();
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.d();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.o_();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        a((IntimateInfo)paramMessage.obj);
        return true;
        paramMessage = (String)paramMessage.obj;
        bcpw.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, paramMessage, 1).a();
        return true;
        paramMessage = (String)paramMessage.obj;
        bcpw.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, paramMessage, 1).a();
        return true;
        c((String)paramMessage.obj);
        return true;
        w();
        return true;
        w();
        bcpw.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131693616, 1).a();
        return true;
        d();
        bcpw.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131693617, 1).a();
        return true;
      } while (this.jdField_h_of_type_AndroidWidgetTextView == null);
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Object[])))
      {
        Object localObject = (Object[])paramMessage.obj;
        paramMessage = (String)localObject[0];
        String str = (String)localObject[1];
        localObject = (String)localObject[2];
        paramMessage = String.format("<font color=\"#878B99\">" + paramMessage + " </font> <font color=\"#FF7EAE\">" + str + "</font>", new Object[0]);
        this.jdField_h_of_type_AndroidWidgetTextView.setText(Html.fromHtml(paramMessage));
        this.jdField_h_of_type_AndroidWidgetTextView.setTag(localObject);
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
        return true;
      }
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      return true;
    } while (this.jdField_h_of_type_AndroidWidgetTextView == null);
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
    return true;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aqkl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxl);
    }
    if (this.jdField_a_of_type_Baxk != null)
    {
      this.jdField_a_of_type_Baxk.d();
      this.jdField_a_of_type_Baxk = null;
    }
    if (this.jdField_a_of_type_Acwm != null) {
      this.jdField_a_of_type_Acwm.b();
    }
    if (this.jdField_a_of_type_Adka != null)
    {
      this.jdField_a_of_type_Adka.a();
      this.jdField_a_of_type_Adka = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.e();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.setApp(null);
    }
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)
    {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.d();
      this.jdField_c_of_type_Boolean = true;
    }
    if (this.n != null) {
      this.n.setVisibility(8);
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Asrq != null) {
      this.jdField_a_of_type_Asrq.a();
    }
    while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  public void k()
  {
    int i1 = 3;
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
    String str = asye.b();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onScoreRuleClick goToScoreRulePage1, url: %s", new Object[] { str }));
    }
    if (TextUtils.isEmpty(str)) {
      return;
    }
    str = str.replace("frd_uin=", "frd_uin=" + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Int == 3) {}
    for (;;)
    {
      str = str.replace("frd_type=", "frd_type=" + i1);
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("onScoreRuleClick goToScoreRulePage2, url: %s", new Object[] { str }));
      }
      localIntent.putExtra("url", str);
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
      }
      axqw.b(null, "dc00898", "", "", "0X800A3C1", "0X800A3C1", this.jdField_b_of_type_Int, 0, "", "", "", "");
      return;
      if (this.jdField_a_of_type_Int == 2) {
        i1 = 2;
      } else if (this.jdField_a_of_type_Int == 1) {
        i1 = 1;
      } else {
        i1 = 14;
      }
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onScoreRuleExpose");
    }
    axqw.b(null, "dc00898", "", "", "0X800A3C2", "0X800A3C2", this.jdField_b_of_type_Int, 0, "", "", "", "");
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterScore = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore;
      ThreadManager.postImmediately(new IntimateInfoView.5(this), null, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onScoreUpdated: " + this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterFriendDays = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays;
      ThreadManager.postImmediately(new IntimateInfoView.6(this), null, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onDaysUpdated: " + this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
    }
  }
  
  public void o()
  {
    p();
  }
  
  public void onClick(View paramView)
  {
    long l1 = SystemClock.elapsedRealtime();
    if ((this.jdField_a_of_type_JavaLangLong != null) && (l1 - this.jdField_a_of_type_JavaLangLong.longValue() < 500L)) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_JavaLangLong = Long.valueOf(l1);
        switch (paramView.getId())
        {
        case 2131366773: 
        default: 
          return;
        case 2131362989: 
          j();
          return;
        case 2131369907: 
          s();
          return;
        case 2131364560: 
          if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList != null)) {
            CommonTroopListActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (ArrayList)this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList, this.jdField_b_of_type_Int);
          }
          axqw.b(null, "dc00898", "", "", "0X8009F4E", "0X8009F4E", this.jdField_b_of_type_Int, 0, "", "", "", "");
          return;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.recentChatTroopInfo == null));
      paramView = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.recentChatTroopInfo;
      Object localObject = actn.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
      ((Intent)localObject).putExtra("uin", paramView.troopCode);
      ((Intent)localObject).putExtra("uintype", 1);
      ((Intent)localObject).putExtra("uinname", paramView.troopName);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject);
      axqw.b(null, "dc00898", "", "", "0X8009F4F", "0X8009F4F", this.jdField_b_of_type_Int, 0, "", "", "", "");
      return;
      paramView = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
      localObject = amtg.a().a(this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("goToC2CWebPage, url: %s", new Object[] { localObject }));
      }
      paramView.putExtra("url", (String)localObject);
      paramView.putExtra("finish_animation_out_to_right", true);
      paramView.putExtra("is_wrap_content", true);
      paramView.putExtra("hide_left_button", false);
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(paramView);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.isShowRedPoint)
      {
        c();
        this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.isShowRedPoint = false;
      }
      if (this.jdField_g_of_type_Boolean)
      {
        this.jdField_g_of_type_Boolean = false;
        aswy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      axqw.b(null, "dc00898", "", "", "0X8009F50", "0X8009F50", this.jdField_b_of_type_Int, 0, "", "", "", "");
      return;
      asaw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2064, "2");
      axqw.b(null, "dc00898", "", "", "0X800A05E", "0X800A05E", 0, 0, "", "", "", "");
      return;
      paramView = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.friendGiftInfo.str_custom_url;
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("goToFriendGiftWebPage, url: %s", new Object[] { localObject }));
      }
      paramView.putExtra("url", (String)localObject);
      paramView.putExtra("finish_animation_out_to_right", true);
      paramView.putExtra("is_wrap_content", true);
      paramView.putExtra("hide_left_button", false);
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(paramView);
      }
      axqw.b(null, "dc00898", "", "", "0X800A3B4", "0X800A3B4", this.jdField_b_of_type_Int, 0, "", "", "", "");
      return;
    } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null);
    paramView = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, FriendProfileMoreInfoActivity.class);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(paramView);
    return;
    if (this.jdField_a_of_type_Asrq == null)
    {
      paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      ProfileActivity.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramView);
      return;
    }
    paramView = this.jdField_a_of_type_Asrq.a();
    if (!TextUtils.isEmpty(paramView))
    {
      auvw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, -1);
      return;
    }
    QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
    return;
    if (this.jdField_a_of_type_Asrq == null)
    {
      paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 1);
      ProfileActivity.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramView);
      return;
    }
    paramView = this.jdField_a_of_type_Asrq.a();
    if (!TextUtils.isEmpty(paramView))
    {
      auvw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_JavaLangString, 0, -1);
      return;
    }
    QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
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
  
  public void p()
  {
    if ((this.jdField_j_of_type_AndroidViewView.getVisibility() != 0) && ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType != 1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "showLoverValueText stop request");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "getLoverIntimateValue sendRequest");
    }
    if (this.jdField_a_of_type_Bhzi == null) {
      this.jdField_a_of_type_Bhzi = new bhzi();
    }
    this.jdField_a_of_type_Bhzi.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "6", "1", "1"));
  }
  
  public void q()
  {
    QLog.i("IntimateInfoView", 4, "onZoomIn: ");
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView == null) {}
    do
    {
      return;
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, Long.parseLong(this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.a(this);
        this.jdField_c_of_type_Boolean = false;
        return;
      }
    } while (!this.jdField_j_of_type_Boolean);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.a(this);
    this.jdField_j_of_type_Boolean = false;
  }
  
  public void r()
  {
    QLog.i("IntimateInfoView", 4, "onZoomOut: ");
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwp
 * JD-Core Version:    0.7.0.1
 */