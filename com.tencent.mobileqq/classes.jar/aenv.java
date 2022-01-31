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
import android.util.DisplayMetrics;
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
import com.tencent.mobileqq.activity.aio.IntimateInfoView.11;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.12;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.18;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.4;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.7;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.8;
import com.tencent.mobileqq.activity.aio.IntimateTitleSwitchView;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
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
import com.tencent.mobileqq.widget.QQToast;
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

public class aenv
  implements aeop, afcf, Handler.Callback, View.OnClickListener, View.OnTouchListener, bjdf
{
  protected int a;
  private aens jdField_a_of_type_Aens;
  private aeoh jdField_a_of_type_Aeoh;
  private aeoi jdField_a_of_type_Aeoi;
  private afci jdField_a_of_type_Afci;
  protected ahkz a;
  alox jdField_a_of_type_Alox = new aenz(this);
  public Context a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public FragmentActivity a;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private asdx jdField_a_of_type_Asdx;
  ased jdField_a_of_type_Ased = new aeob(this);
  auip jdField_a_of_type_Auip;
  private bcws jdField_a_of_type_Bcws;
  bcwt jdField_a_of_type_Bcwt = new aeoa(this);
  private bdfq jdField_a_of_type_Bdfq;
  private bepp jdField_a_of_type_Bepp;
  private bhpy jdField_a_of_type_Bhpy;
  private bkbv jdField_a_of_type_Bkbv;
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
  protected List<ahjq> a;
  public boolean a;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private HorizontalListView jdField_b_of_type_ComTencentWidgetHorizontalListView;
  public String b;
  public boolean b;
  private int jdField_c_of_type_Int = 1;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
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
  private View jdField_k_of_type_AndroidViewView;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  private View jdField_l_of_type_AndroidViewView;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  private View jdField_m_of_type_AndroidViewView;
  private TextView jdField_m_of_type_AndroidWidgetTextView;
  private View n;
  
  public aenv(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Ahkz = new ahkz();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      l1 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
      Object localObject;
      if ((l1 > 0L) && (bjdh.c()))
      {
        paramString = QzonePluginProxyActivity.a();
        localObject = new StringBuilder().append("IntimateInfoView: start to load qzone plugin ");
        if (paramString != null)
        {
          bool = true;
          QLog.i("IntimateInfoView", 1, bool);
          if (paramString != null) {
            break label1376;
          }
          QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new IntimateInfoView.1(this, paramFragmentActivity, paramQQAppInterface));
          bool = false;
          paramString = null;
          if (!bool) {
            break label1468;
          }
        }
      }
      try
      {
        localObject = LayoutInflater.from(paramContext).inflate(2131559189, null);
        paramString = (String)localObject;
        this.jdField_a_of_type_CooperationQzoneApiFeedListView = ((FeedListView)((View)localObject).findViewById(2131368387));
        paramString = (String)localObject;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          float f1;
          QLog.w("IntimateInfoView", 1, "IntimateInfoView: failed to load qzone feed", localThrowable);
          continue;
          this.jdField_h_of_type_Boolean = true;
          continue;
          String str = paramString;
          continue;
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)paramString.findViewById(2131376154));
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setEdgeEffectEnabled(false);
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
        }
      }
      if ((paramString == null) || (this.jdField_a_of_type_CooperationQzoneApiFeedListView == null))
      {
        paramString = LayoutInflater.from(paramContext).inflate(2131559186, null);
        this.jdField_h_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidViewView = paramString.findViewById(2131376000);
        this.jdField_b_of_type_AndroidViewView = paramString.findViewById(2131377981);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramString.findViewById(2131363024));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramString.findViewById(2131377944));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramString.findViewById(2131370170));
        if (!this.jdField_h_of_type_Boolean) {
          break label1419;
        }
        localObject = LayoutInflater.from(paramContext).inflate(2131559187, null);
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131376328));
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131366906));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView = ((IntimateTitleSwitchView)((View)localObject).findViewById(2131368389));
        this.jdField_c_of_type_AndroidViewView = ((View)localObject).findViewById(2131364632);
        this.jdField_d_of_type_AndroidViewView = ((View)localObject).findViewById(2131364636);
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131364635));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131364634));
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131364633));
        this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131364638));
        this.jdField_e_of_type_AndroidViewView = ((View)localObject).findViewById(2131375360);
        this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131375358));
        this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131375359));
        this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131375361));
        this.jdField_i_of_type_AndroidViewView = ((View)localObject).findViewById(2131365595);
        this.jdField_f_of_type_AndroidViewView = ((View)localObject).findViewById(2131366922);
        this.jdField_g_of_type_AndroidViewView = ((View)localObject).findViewById(2131366920);
        this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366915));
        this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366918));
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((View)localObject).findViewById(2131366921));
        this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368400));
        this.jdField_h_of_type_AndroidViewView = ((View)localObject).findViewById(2131366892);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366890));
        this.jdField_l_of_type_AndroidViewView = ((View)localObject).findViewById(2131366901);
        this.jdField_m_of_type_AndroidViewView = ((View)localObject).findViewById(2131366896);
        this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366897));
        this.jdField_b_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((View)localObject).findViewById(2131366900));
        this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366899));
        this.jdField_j_of_type_AndroidViewView = ((View)localObject).findViewById(2131369861);
        this.jdField_k_of_type_AndroidViewView = ((View)localObject).findViewById(2131369858);
        this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131369860));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131370160));
        this.n = ((View)localObject).findViewById(2131366895);
        if (!this.jdField_h_of_type_Boolean) {
          break label1426;
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
        this.jdField_k_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_Aeoi = new aeoi(this, null);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(bdkf.a(5.0F));
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Aeoi);
        this.jdField_a_of_type_Aeoh = new aeoh(this, null);
        this.jdField_b_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(bdkf.a(5.0F));
        this.jdField_b_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Aeoh);
        this.jdField_m_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
        this.jdField_d_of_type_AndroidViewView.setOnTouchListener(this);
        this.jdField_e_of_type_AndroidViewView.setOnTouchListener(this);
        this.jdField_g_of_type_AndroidViewView.setOnTouchListener(this);
        this.jdField_k_of_type_AndroidViewView.setOnTouchListener(this);
        this.jdField_i_of_type_AndroidViewView.setOnTouchListener(this);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this);
        this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(this);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnTouchListener(this);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setTransTouchStateToParent(true);
        this.jdField_b_of_type_ComTencentWidgetHorizontalListView.setOnTouchListener(this);
        this.jdField_b_of_type_ComTencentWidgetHorizontalListView.setTransTouchStateToParent(true);
        this.jdField_m_of_type_AndroidViewView.setOnTouchListener(this);
        if (AppSetting.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alpo.a(2131706190));
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alpo.a(2131706200));
          this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(alpo.a(2131706205));
          this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(alpo.a(2131706203));
        }
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          paramQQAppInterface.setMargins(0, ImmersiveUtils.getStatusBarHeight(paramContext), 0, 0);
          this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramQQAppInterface);
        }
        f1 = paramContext.getResources().getDisplayMetrics().density;
        aekt.a(this.jdField_e_of_type_AndroidWidgetTextView, (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F));
        aekt.a(this.jdField_f_of_type_AndroidWidgetTextView, (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F), (int)(f1 * 10.0F + 0.5F));
        paramQQAppInterface = new aeoc(this);
        paramFragmentActivity = new aeod(this);
        this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(paramFragmentActivity);
        this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(paramQQAppInterface);
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        long l1 = 0L;
        continue;
        boolean bool = false;
        continue;
        label1376:
        bool = bjdh.c(paramFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        continue;
        bool = false;
        continue;
        label1419:
        label1426:
        label1468:
        paramString = null;
      }
    }
  }
  
  private void A()
  {
    if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null))
    {
      if ((this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 4)) {
        this.jdField_j_of_type_Boolean = true;
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.a(this);
  }
  
  private void B()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    TroopWithCommonFriendsFragment.a(this.jdField_a_of_type_JavaLangString);
    TroopWithCommonFriendsFragment.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2);
  }
  
  private Bitmap a(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo)
  {
    int i1 = auny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramPrefetchMutualMarkInfo.type, paramPrefetchMutualMarkInfo.level);
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
    if (this.jdField_a_of_type_Bcws == null)
    {
      this.jdField_a_of_type_Bcws = new bcws(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Bcws.a(this.jdField_a_of_type_Bcwt);
    }
    Bitmap localBitmap = this.jdField_a_of_type_Bcws.a(1, paramString, 0, (byte)4);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Bcws.a()) {
      this.jdField_a_of_type_Bcws.a(paramString, 200, false, 1, true, (byte)0, 4);
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
    for (String str = aupd.b(paramInt1, paramInt2); (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (str.equals(this.jdField_c_of_type_JavaLangString)); str = aupd.a(paramInt1, paramInt2)) {
      return;
    }
    Object localObject;
    if (paramInt1 == 3) {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840244);
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
      localURLDrawableOptions.mRequestWidth = bdkf.a();
      localURLDrawableOptions.mRequestHeight = bdkf.b();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localObject = URLDrawable.getDrawable(str, localURLDrawableOptions);
      ((URLDrawable)localObject).setDecodeHandler(bcuq.y);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
      this.jdField_c_of_type_JavaLangString = str;
      return;
      if (paramInt1 == 2) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840242);
      } else if (paramInt1 == 1) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840246);
      } else {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840250);
      }
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_Aens == null)
    {
      ThreadManager.getFileThreadHandler().post(new IntimateInfoView.12(this, paramURLDrawable));
      return;
    }
    this.jdField_a_of_type_Aens.a();
  }
  
  private void a(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("getPrefetchMarkIcon, type=%s, currDay=%s, day=%s", new Object[] { Integer.valueOf(paramPrefetchMutualMarkInfo.type), Integer.valueOf(paramPrefetchMutualMarkInfo.currentDays), Integer.valueOf(paramPrefetchMutualMarkInfo.days) }));
    }
    ThreadManager.getSubThreadHandler().post(new IntimateInfoView.18(this, paramPrefetchMutualMarkInfo));
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
    this.jdField_b_of_type_Int = paramIntimateInfo.maskType;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    Object localObject2;
    int i1;
    label362:
    label383:
    int i3;
    if (paramIntimateInfo.beFriendDays >= -1) {
      if (this.jdField_b_of_type_Int == 3)
      {
        this.jdField_c_of_type_Int = 4;
        this.jdField_j_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        a(this.jdField_b_of_type_Int, paramIntimateInfo.maskLevel);
        this.jdField_e_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.a(paramIntimateInfo, this.jdField_b_of_type_Int);
        if (paramIntimateInfo.memoryDayInfoList != null)
        {
          AbstractGifImage.resumeAll();
          if (this.jdField_a_of_type_Afci == null)
          {
            this.jdField_a_of_type_Afci = new afci(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Afci.a(new aeoe(this));
          }
          localObject1 = new ArrayList(paramIntimateInfo.memoryDayInfoList);
          this.jdField_a_of_type_Afci.a(this.jdField_a_of_type_AndroidContentContext, (ArrayList)localObject1);
          if ((this.jdField_a_of_type_Afci.a() != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Afci.a());
          }
        }
        if (this.jdField_b_of_type_Boolean) {
          z();
        }
        if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Auip != null))
        {
          localObject3 = this.jdField_a_of_type_Auip.a();
          localObject4 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          localObject1 = "";
          localObject2 = this.jdField_a_of_type_Auip.a();
          if (localObject2 != null) {
            localObject1 = ((auij)localObject2).b();
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = ((TroopManager)localObject4).a((String)localObject3, this.jdField_a_of_type_JavaLangString);
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        }
        if ((paramIntimateInfo.commonTroopInfoList == null) || (paramIntimateInfo.commonTroopInfoList.size() <= 0)) {
          break label938;
        }
        i1 = 1;
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break label943;
        }
        i2 = 1;
        i3 = 0;
        localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693713);
        if (i2 != 0) {
          i3 = ahmk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        }
        if (i3 == 2) {
          localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693712);
        }
        if ((i1 == 0) && (i2 == 0)) {
          break label1141;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        if (i1 == 0) {
          break label948;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        if ((paramIntimateInfo.commonTroopInfoList != null) && (paramIntimateInfo.commonTroopInfoList.size() > 0))
        {
          i1 = paramIntimateInfo.commonTroopInfoList.size();
          this.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(i1));
          localObject2 = paramIntimateInfo.recentChatTroopInfo;
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
          if ((localObject2 != null) && (!TextUtils.isEmpty(((IntimateInfo.CommonTroopInfo)localObject2).troopUin)))
          {
            this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_g_of_type_AndroidWidgetTextView.setText(((IntimateInfo.CommonTroopInfo)localObject2).troopName);
            this.jdField_h_of_type_AndroidWidgetTextView.setText(paramIntimateInfo.commonTroopTips);
            localObject2 = bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, ((IntimateInfo.CommonTroopInfo)localObject2).troopCode);
            this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          }
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
        if (i2 != 0)
        {
          this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          azmj.b(null, "dc00898", "", "", "0X800AD21", "0X800AD21", 0, 0, "0", "0", "", "");
        }
        if (this.jdField_b_of_type_Boolean) {
          azmj.b(null, "dc00898", "", "", "0X8009F51", "0X8009F51", this.jdField_c_of_type_Int, 0, "", "", "", "");
        }
      }
    }
    for (;;)
    {
      localObject1 = new ArrayList();
      if ((paramIntimateInfo.markInfoList == null) || (paramIntimateInfo.markInfoList.size() <= 0)) {
        break label2020;
      }
      localObject2 = paramIntimateInfo.markInfoList.iterator();
      i1 = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (IntimateInfo.MutualMarkInfo)((Iterator)localObject2).next();
        if (!a((IntimateInfo.MutualMarkInfo)localObject3)) {
          break label2017;
        }
        ((ArrayList)localObject1).add(localObject3);
        i1 += 1;
      }
      if (this.jdField_b_of_type_Int == 2)
      {
        this.jdField_c_of_type_Int = 3;
        this.jdField_j_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        a(this.jdField_b_of_type_Int, paramIntimateInfo.maskLevel);
        this.jdField_e_of_type_Boolean = true;
        break;
      }
      if (this.jdField_b_of_type_Int == 1)
      {
        b(paramIntimateInfo);
        break;
      }
      this.jdField_c_of_type_Int = 1;
      this.jdField_j_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      a(0, paramIntimateInfo.maskLevel);
      this.jdField_e_of_type_Boolean = false;
      break;
      a(0, paramIntimateInfo.maskLevel);
      break;
      label938:
      i1 = 0;
      break label362;
      label943:
      i2 = 0;
      break label383;
      label948:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693715));
      localObject2 = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
      this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).topMargin = aekt.a(10.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
      this.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      azmj.b(null, "dc00898", "", "", "0X800AD21", "0X800AD21", 0, 0, "0", "0", "", "");
      continue;
      label1141:
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    int i2 = i1;
    if (this.jdField_b_of_type_Boolean) {
      azmj.b(null, "dc00898", "", "", "0X8009F52", "0X8009F52", this.jdField_c_of_type_Int, 0, "", "", "", "");
    }
    label1429:
    label1476:
    label1489:
    label1885:
    label2017:
    label2020:
    for (i2 = i1;; i2 = 0)
    {
      if ((paramIntimateInfo.prefetchMutualMarkInfoList != null) && (paramIntimateInfo.prefetchMutualMarkInfoList.size() > 0))
      {
        localObject2 = paramIntimateInfo.prefetchMutualMarkInfoList.iterator();
        i1 = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (IntimateInfo.MutualMarkInfo)((Iterator)localObject2).next();
          if (!a((IntimateInfo.MutualMarkInfo)localObject3)) {
            break label2008;
          }
          ((ArrayList)localObject1).add(localObject3);
          i1 += 1;
        }
        i3 = i1;
        if (this.jdField_b_of_type_Boolean) {
          azmj.b(null, "dc00898", "", "", "0X8009F52", "0X8009F52", this.jdField_c_of_type_Int, 0, "", "", "", "");
        }
      }
      for (i3 = i1;; i3 = 0)
      {
        if (!((ArrayList)localObject1).isEmpty()) {
          if (i2 == 0)
          {
            this.jdField_i_of_type_AndroidWidgetTextView.setText(String.valueOf(i3));
            this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693737));
            this.jdField_f_of_type_AndroidViewView.setVisibility(0);
            this.jdField_a_of_type_Aeoi.a((List)localObject1);
            this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
            this.jdField_g_of_type_Boolean = aunx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            label1407:
            localObject1 = this.jdField_e_of_type_AndroidWidgetImageView;
            if ((!paramIntimateInfo.isShowRedPoint) && (!this.jdField_g_of_type_Boolean)) {
              break label1814;
            }
            i1 = 0;
            ((ImageView)localObject1).setVisibility(i1);
            if ((paramIntimateInfo.dnaInfoList == null) || (paramIntimateInfo.dnaInfoList.size() <= 0)) {
              break label1885;
            }
            this.jdField_h_of_type_AndroidViewView.setVisibility(0);
            if (this.jdField_a_of_type_Auip != null) {
              break label1820;
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
            localObject3 = paramIntimateInfo.dnaInfoList.iterator();
            i1 = 0;
            if (!((Iterator)localObject3).hasNext()) {
              break label1894;
            }
            localObject4 = (IntimateInfo.DNAInfo)((Iterator)localObject3).next();
            localObject1 = null;
            if (this.jdField_a_of_type_Auip != null) {
              localObject1 = this.jdField_a_of_type_Auip.a();
            }
            if (localObject1 != null) {
              break label2005;
            }
            localObject1 = afcg.a(this.jdField_a_of_type_AndroidContentContext);
          }
        }
        for (;;)
        {
          localObject2 = (TextView)((View)localObject1).findViewById(2131377979);
          TextView localTextView = (TextView)((View)localObject1).findViewById(2131377868);
          ((TextView)localObject2).setText(((IntimateInfo.DNAInfo)localObject4).wording);
          if (((IntimateInfo.DNAInfo)localObject4).viceTitle != null)
          {
            localObject2 = new SpannableString(((IntimateInfo.DNAInfo)localObject4).viceTitle);
            if (!TextUtils.isEmpty(((IntimateInfo.DNAInfo)localObject4).linkWording))
            {
              int i4 = ((IntimateInfo.DNAInfo)localObject4).viceTitle.indexOf(((IntimateInfo.DNAInfo)localObject4).linkWording);
              i3 = ((IntimateInfo.DNAInfo)localObject4).linkWording.length() + i4;
              i2 = i4;
              if (i4 < 0)
              {
                String str = ((IntimateInfo.DNAInfo)localObject4).viceTitle + ((IntimateInfo.DNAInfo)localObject4).linkWording;
                localObject2 = new SpannableString(str);
                i2 = ((IntimateInfo.DNAInfo)localObject4).viceTitle.length();
                i3 = str.length();
              }
              ((SpannableString)localObject2).setSpan(new aeof(this, (IntimateInfo.DNAInfo)localObject4), i2, i3, 33);
              localTextView.setText((CharSequence)localObject2);
              localTextView.setMovementMethod(LinkMovementMethod.getInstance());
            }
          }
          for (;;)
          {
            localObject2 = new LinearLayout.LayoutParams(-1, -1);
            ((LinearLayout.LayoutParams)localObject2).topMargin = bdkf.a(16.0F);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            i1 += 1;
            break label1489;
            this.jdField_i_of_type_AndroidWidgetTextView.setText(String.valueOf(i2));
            break;
            this.jdField_f_of_type_AndroidViewView.setVisibility(8);
            this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
            break label1407;
            i1 = 8;
            break label1429;
            i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
            i1 = 0;
            while (i1 < i2)
            {
              localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
              this.jdField_a_of_type_Auip.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, (View)localObject1);
              i1 += 1;
            }
            break label1476;
            localTextView.setText((CharSequence)localObject2);
            continue;
            localTextView.setVisibility(8);
          }
          this.jdField_h_of_type_AndroidViewView.setVisibility(8);
          label1894:
          c(paramIntimateInfo);
          IntimatePlayTogetherMiniGameCardView.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
          if (this.jdField_b_of_type_Boolean)
          {
            azmj.b(null, "dc00898", "", "", "0X8009F4D", "0X8009F4D", this.jdField_c_of_type_Int, 0, "", "", "", "");
            if (this.jdField_c_of_type_Int == 2) {
              azmj.b(null, "dc00898", "", "", "0X800A05F", "0X800A05F", 0, 0, "", "", "", "");
            }
          }
          QLog.d("Intimatetest", 2, "ui ok");
          return;
        }
        break;
      }
      break;
    }
  }
  
  private void a(String paramString)
  {
    azmj.b(null, "dc00898", "", "", "0X800A11A", "0X800A11A", this.jdField_c_of_type_Int, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentImageURLDrawable == null)
    {
      c(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131694217));
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = 750;
      localURLDrawableOptions.mRequestHeight = 1272;
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    }
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) || (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 4))
    {
      x();
      a(this.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new aenw(this));
    ThreadManager.getFileThreadHandler().post(new IntimateInfoView.11(this));
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!bdee.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
        break label91;
      }
      if (this.jdField_a_of_type_Asdx == null) {
        this.jdField_a_of_type_Asdx = ((asdx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(153));
      }
      this.jdField_a_of_type_Asdx.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType);
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
      localMessage.obj = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131720293);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      QLog.d("intimate_relationship", 1, String.format("disbandIntimateRelationship network is not available, uin: %s", new Object[] { paramString }));
    }
  }
  
  private boolean a(IntimateInfo.MutualMarkInfo paramMutualMarkInfo)
  {
    if (!auny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMutualMarkInfo.type)) {}
    int i1;
    do
    {
      return false;
      int i2 = auny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramMutualMarkInfo.type, paramMutualMarkInfo.level);
      auoy localauoy = auny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMutualMarkInfo.type);
      i1 = i2;
      if (localauoy != null)
      {
        i1 = i2;
        if (localauoy.jdField_b_of_type_Boolean) {
          i1 = 0;
        }
      }
    } while ((TextUtils.isEmpty(paramMutualMarkInfo.icon_static_url)) && (i1 == 0));
    return true;
  }
  
  private Bitmap b(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo)
  {
    int i2 = aekt.a(45.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
  
  private void b(IntimateInfo paramIntimateInfo)
  {
    if (paramIntimateInfo == null) {
      return;
    }
    this.jdField_c_of_type_Int = 2;
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if ((this.jdField_j_of_type_AndroidViewView.getVisibility() == 8) && (this.jdField_a_of_type_Boolean)) {
      q();
    }
    this.jdField_j_of_type_AndroidViewView.setVisibility(0);
    atry.a("6", "2", "1", LpReportInfo_dc03950.getReportUserType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    a(this.jdField_b_of_type_Int, paramIntimateInfo.maskLevel);
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = true;
      w();
    }
    this.jdField_e_of_type_Boolean = true;
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "disbandLoverRelationship sendRequest");
    }
    bkbt localbkbt = new bkbt();
    try
    {
      localbkbt.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()), Long.parseLong(paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramString.what = 5;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
    }
  }
  
  private void c(IntimateInfo paramIntimateInfo)
  {
    if ((this.jdField_a_of_type_Aeoh != null) && (paramIntimateInfo != null) && (paramIntimateInfo.commonBodyList != null) && (paramIntimateInfo.commonBodyList.size() > 0))
    {
      Iterator localIterator = paramIntimateInfo.commonBodyList.iterator();
      while (localIterator.hasNext())
      {
        IntimateInfo.CommonBody localCommonBody = (IntimateInfo.CommonBody)localIterator.next();
        if (localCommonBody.cmd == 3436)
        {
          paramIntimateInfo.friendGiftInfo = IntimateInfo.FriendGiftInfo.copyFrom(localCommonBody);
          if ((paramIntimateInfo.friendGiftInfo != null) && (paramIntimateInfo.friendGiftInfo.str_send_times > 0))
          {
            this.jdField_l_of_type_AndroidWidgetTextView.setText(String.valueOf(paramIntimateInfo.friendGiftInfo.str_send_times));
            this.jdField_m_of_type_AndroidWidgetTextView.setText(paramIntimateInfo.friendGiftInfo.str_desc);
            this.jdField_l_of_type_AndroidViewView.setVisibility(0);
            if (paramIntimateInfo.friendGiftInfo.str_gift_url.size() > 6) {
              this.jdField_a_of_type_Aeoh.a(paramIntimateInfo.friendGiftInfo.str_gift_url.subList(0, 6));
            }
            for (;;)
            {
              this.jdField_b_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
              if (!this.jdField_b_of_type_Boolean) {
                break;
              }
              azmj.b(null, "dc00898", "", "", "0X800A3B3", "0X800A3B3", this.jdField_c_of_type_Int, 0, "", "", "", "");
              break;
              this.jdField_a_of_type_Aeoh.a(paramIntimateInfo.friendGiftInfo.str_gift_url);
            }
          }
          this.jdField_l_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
        }
      }
    }
  }
  
  private void c(String paramString)
  {
    if (this.jdField_a_of_type_Bepp == null)
    {
      this.jdField_a_of_type_Bepp = new bepp(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      this.jdField_a_of_type_Bepp.c(true);
    }
    this.jdField_a_of_type_Bepp.a(paramString);
    if ((this.jdField_a_of_type_Bepp != null) && (!this.jdField_a_of_type_Bepp.isShowing()) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
      this.jdField_a_of_type_Bepp.show();
    }
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("isIntimate" + this.jdField_e_of_type_Boolean, new Object[0]));
    }
    azmj.b(null, "dc00898", "", "", "0X800A119", "0X800A119", this.jdField_c_of_type_Int, 0, "", "", "", "");
    this.jdField_a_of_type_Bhpy = bhpy.c(this.jdField_a_of_type_AndroidContentContext);
    String str = aupd.c(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskLevel);
    if (!TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_Bhpy.a(2131693749, 0);
    }
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_Bhpy.a(2131693716, 3);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpy.a(new aeog(this, str));
      this.jdField_a_of_type_Bhpy.c(2131690648);
      this.jdField_a_of_type_Bhpy.show();
      return;
      this.jdField_a_of_type_Bhpy.a(2131693728, 0);
    }
  }
  
  private void u()
  {
    azmj.b(null, "dc00898", "", "", "0X8009F71", "0X8009F71", 0, 0, "", "", "", "");
    String str = aupd.a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "click menu_bind_intimate url:" + str);
    }
    if (!TextUtils.isEmpty(str))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent.putExtra("url", str));
    }
  }
  
  private void v()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      QLog.d("intimate_relationship", 1, "showDisbandDialog, mActivity == null or is finishing!");
      return;
    }
    if (this.jdField_a_of_type_Bdfq == null) {
      this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(2131693720).setPositiveButton(2131693719, new aeny(this)).setNegativeButton(2131693718, new aenx(this));
    }
    this.jdField_a_of_type_Bdfq.show();
  }
  
  private void w()
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
  
  private void x()
  {
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bepp.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void y()
  {
    String str = aupd.c(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskLevel);
    if (!TextUtils.isEmpty(str))
    {
      a(str);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, alpo.a(2131706191), 1).a();
  }
  
  private void z()
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
            azmj.b(null, "dc00898", "", "", "0X800A207 ", "0X800A207 ", localMemoryDayInfo.dateType, 0, "", "", "", "");
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
            azmj.b(null, "dc00898", "", "", "0X800A209 ", "0X800A209 ", 0, 0, "", "", "", "");
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ased);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
    }
    ThreadManager.getSubThreadHandler().post(new IntimateInfoView.4(this));
  }
  
  public void a(int paramInt)
  {
    boolean bool = true;
    QLog.i("IntimateInfoView", 4, "setCurrentShowType: " + paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "setCurrentShowType showType: " + paramInt + "  old:" + this.jdField_d_of_type_Int);
    }
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.setCurrentShowType(paramInt);
    if (!this.jdField_i_of_type_Boolean)
    {
      A();
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
  
  public void a(auij paramauij, String paramString)
  {
    if (paramauij == null) {}
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_JavaLangString = paramauij.a();
          this.jdField_b_of_type_JavaLangString = paramString;
        } while (paramauij.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null);
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ased);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
        }
        this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramauij.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
        paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramString.what = 0;
        paramString.obj = paramauij.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
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
  
  public void a(auip paramauip)
  {
    if (this.jdField_a_of_type_Auip != null)
    {
      this.jdField_a_of_type_Auip.k();
      this.jdField_a_of_type_Auip = null;
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
    }
    a(3);
    this.jdField_a_of_type_Auip = paramauip;
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
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (bdee.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)))
    {
      if (this.jdField_a_of_type_Asdx == null) {
        this.jdField_a_of_type_Asdx = ((asdx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(153));
      }
      this.jdField_a_of_type_Asdx.b(this.jdField_a_of_type_JavaLangString);
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
    //   1: getfield 113	aenv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4: invokestatic 666	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +55 -> 62
    //   10: aload_0
    //   11: getfield 109	aenv:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   14: invokestatic 1112	bdee:g	(Landroid/content/Context;)Z
    //   17: ifeq +152 -> 169
    //   20: aload_0
    //   21: getfield 1114	aenv:jdField_a_of_type_Asdx	Lasdx;
    //   24: ifnonnull +20 -> 44
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 107	aenv:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   32: sipush 153
    //   35: invokevirtual 1117	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalko;
    //   38: checkcast 1119	asdx
    //   41: putfield 1114	aenv:jdField_a_of_type_Asdx	Lasdx;
    //   44: aload_0
    //   45: getfield 851	aenv:jdField_a_of_type_Auip	Lauip;
    //   48: ifnonnull +45 -> 93
    //   51: aload_0
    //   52: getfield 1114	aenv:jdField_a_of_type_Asdx	Lasdx;
    //   55: aload_0
    //   56: getfield 113	aenv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   59: invokevirtual 1471	asdx:a	(Ljava/lang/String;)V
    //   62: invokestatic 641	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq +27 -> 92
    //   68: ldc_w 643
    //   71: iconst_2
    //   72: ldc_w 1473
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: aload_0
    //   82: getfield 113	aenv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   85: aastore
    //   86: invokestatic 691	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   89: invokestatic 647	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: return
    //   93: new 80	java/util/ArrayList
    //   96: dup
    //   97: invokespecial 81	java/util/ArrayList:<init>	()V
    //   100: astore 5
    //   102: aload_0
    //   103: getfield 113	aenv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: invokestatic 1476	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   109: invokevirtual 1480	java/lang/Long:longValue	()J
    //   112: lstore_3
    //   113: aload_0
    //   114: getfield 1449	aenv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   117: invokestatic 1476	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   120: invokevirtual 1480	java/lang/Long:longValue	()J
    //   123: lstore_1
    //   124: aload 5
    //   126: lload_3
    //   127: invokestatic 1483	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   130: invokevirtual 963	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   133: pop
    //   134: aload_0
    //   135: getfield 1114	aenv:jdField_a_of_type_Asdx	Lasdx;
    //   138: lload_1
    //   139: aload 5
    //   141: aconst_null
    //   142: invokevirtual 1486	asdx:a	(JLjava/util/ArrayList;Ljava/lang/Object;)V
    //   145: goto -83 -> 62
    //   148: astore 6
    //   150: lconst_0
    //   151: lstore_1
    //   152: ldc_w 643
    //   155: iconst_2
    //   156: ldc_w 1488
    //   159: invokestatic 1490	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: lload_1
    //   163: lstore_3
    //   164: lconst_0
    //   165: lstore_1
    //   166: goto -42 -> 124
    //   169: aload_0
    //   170: getfield 614	aenv:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   173: invokevirtual 1128	android/os/Handler:obtainMessage	()Landroid/os/Message;
    //   176: astore 5
    //   178: aload 5
    //   180: iconst_1
    //   181: putfield 1133	android/os/Message:what	I
    //   184: aload 5
    //   186: aload_0
    //   187: getfield 111	aenv:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   190: invokevirtual 437	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   193: ldc_w 1134
    //   196: invokevirtual 891	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   199: putfield 1138	android/os/Message:obj	Ljava/lang/Object;
    //   202: aload_0
    //   203: getfield 614	aenv:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   206: aload 5
    //   208: invokevirtual 1142	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   211: pop
    //   212: ldc_w 643
    //   215: iconst_1
    //   216: ldc_w 1492
    //   219: iconst_1
    //   220: anewarray 4	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: aload_0
    //   226: getfield 113	aenv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   229: aastore
    //   230: invokestatic 691	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   233: invokestatic 647	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: goto -174 -> 62
    //   239: astore 6
    //   241: lload_3
    //   242: lstore_1
    //   243: goto -91 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	aenv
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
    long l2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (!bdee.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
        break label110;
      }
      l2 = 0L;
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
        ahmk.a(l1, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("intimate_relationship", 2, String.format("requestTroopListWithCommonFriends, friendUin: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        long l1 = l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("intimate_relationship", 2, String.format("requestTroopListWithCommonFriends, friendUin: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
        l1 = l2;
        continue;
      }
      label110:
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131720293);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      QLog.d("intimate_relationship", 1, String.format("requestTroopListWithCommonFriends network is not available, uin: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.a();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.h();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.b();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)
    {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.f();
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.g();
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.c();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.m();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      do
      {
        do
        {
          return true;
          a((IntimateInfo)paramMessage.obj);
          return true;
          paramMessage = (String)paramMessage.obj;
          QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, paramMessage, 1).a();
          return true;
          paramMessage = (String)paramMessage.obj;
          QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, paramMessage, 1).a();
          return true;
          c((String)paramMessage.obj);
          return true;
          x();
          return true;
          x();
          QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131693721, 1).a();
          return true;
          d();
          QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131693722, 1).a();
          return true;
        } while (this.jdField_k_of_type_AndroidWidgetTextView == null);
        if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Object[])))
        {
          Object localObject = (Object[])paramMessage.obj;
          paramMessage = (String)localObject[0];
          String str = (String)localObject[1];
          localObject = (String)localObject[2];
          paramMessage = String.format("<font color=\"#878B99\">" + paramMessage + " </font> <font color=\"#FF7EAE\">" + str + "</font>", new Object[0]);
          this.jdField_k_of_type_AndroidWidgetTextView.setText(Html.fromHtml(paramMessage));
          this.jdField_k_of_type_AndroidWidgetTextView.setTag(localObject);
          this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
          return true;
        }
        this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(8);
        return true;
      } while (this.jdField_k_of_type_AndroidWidgetTextView == null);
      this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(8);
      return true;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
    return true;
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.d();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.f();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ased);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
    }
    if (this.jdField_a_of_type_Bcws != null)
    {
      this.jdField_a_of_type_Bcws.d();
      this.jdField_a_of_type_Bcws = null;
    }
    if (this.jdField_a_of_type_Aens != null) {
      this.jdField_a_of_type_Aens.b();
    }
    if (this.jdField_a_of_type_Afci != null)
    {
      this.jdField_a_of_type_Afci.a();
      this.jdField_a_of_type_Afci = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.e();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.setApp(null);
    }
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)
    {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.i();
      this.jdField_c_of_type_Boolean = true;
    }
    if (this.n != null) {
      this.n.setVisibility(8);
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Auip != null) {
      this.jdField_a_of_type_Auip.a();
    }
    while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  public void l()
  {
    int i1 = 3;
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
    String str = aupd.b();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onScoreRuleClick goToScoreRulePage1, url: %s", new Object[] { str }));
    }
    if (TextUtils.isEmpty(str)) {
      return;
    }
    str = str.replace("frd_uin=", "frd_uin=" + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_b_of_type_Int == 3) {}
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
      azmj.b(null, "dc00898", "", "", "0X800A3C1", "0X800A3C1", this.jdField_c_of_type_Int, 0, "", "", "", "");
      return;
      if (this.jdField_b_of_type_Int == 2) {
        i1 = 2;
      } else if (this.jdField_b_of_type_Int == 1) {
        i1 = 1;
      } else {
        i1 = 14;
      }
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onScoreRuleExpose");
    }
    azmj.b(null, "dc00898", "", "", "0X800A3C2", "0X800A3C2", this.jdField_c_of_type_Int, 0, "", "", "", "");
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterScore = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore;
      ThreadManager.postImmediately(new IntimateInfoView.7(this), null, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onScoreUpdated: " + this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
    }
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterFriendDays = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays;
      ThreadManager.postImmediately(new IntimateInfoView.8(this), null, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onDaysUpdated: " + this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
    }
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
        case 2131366892: 
        default: 
          return;
        case 2131363024: 
          k();
          return;
        case 2131370170: 
          t();
          return;
        case 2131364636: 
          if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList != null))
          {
            CommonTroopListActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (ArrayList)this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList, this.jdField_c_of_type_Int);
            azmj.b(null, "dc00898", "", "", "0X8009F4E", "0X8009F4E", this.jdField_c_of_type_Int, 0, "", "", "", "");
            return;
          }
          B();
          return;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.recentChatTroopInfo == null));
      paramView = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.recentChatTroopInfo;
      Object localObject = aekt.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
      ((Intent)localObject).putExtra("uin", paramView.troopCode);
      ((Intent)localObject).putExtra("uintype", 1);
      ((Intent)localObject).putExtra("uinname", paramView.troopName);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject);
      azmj.b(null, "dc00898", "", "", "0X8009F4F", "0X8009F4F", this.jdField_c_of_type_Int, 0, "", "", "", "");
      return;
      paramView = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
      localObject = aokh.a().a(this.jdField_a_of_type_JavaLangString);
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
        aunx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      azmj.b(null, "dc00898", "", "", "0X8009F50", "0X8009F50", this.jdField_c_of_type_Int, 0, "", "", "", "");
      return;
      atry.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2064, "2");
      azmj.b(null, "dc00898", "", "", "0X800A05E", "0X800A05E", 0, 0, "", "", "", "");
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
      azmj.b(null, "dc00898", "", "", "0X800A3B4", "0X800A3B4", this.jdField_c_of_type_Int, 0, "", "", "", "");
      return;
    } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null);
    paramView = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, FriendProfileMoreInfoActivity.class);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(paramView);
    return;
    if (this.jdField_a_of_type_Auip == null)
    {
      paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      ProfileActivity.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramView);
      return;
    }
    paramView = this.jdField_a_of_type_Auip.a();
    if (!TextUtils.isEmpty(paramView))
    {
      awnk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, -1);
      return;
    }
    QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
    return;
    if (this.jdField_a_of_type_Auip == null)
    {
      paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 1);
      ProfileActivity.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramView);
      return;
    }
    paramView = this.jdField_a_of_type_Auip.a();
    if (!TextUtils.isEmpty(paramView))
    {
      awnk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_JavaLangString, 0, -1);
      return;
    }
    QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
    return;
    B();
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
    q();
  }
  
  public void q()
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
    if (this.jdField_a_of_type_Bkbv == null) {
      this.jdField_a_of_type_Bkbv = new bkbv();
    }
    this.jdField_a_of_type_Bkbv.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "6", "1", "1"));
  }
  
  public void r()
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
  
  public void s()
  {
    QLog.i("IntimateInfoView", 4, "onZoomOut: ");
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.q_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aenv
 * JD-Core Version:    0.7.0.1
 */