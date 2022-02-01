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
import android.widget.ImageView.ScaleType;
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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.1;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.11;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.12;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.18;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.4;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.7;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.8;
import com.tencent.mobileqq.activity.aio.IntimateTitleSwitchView;
import com.tencent.mobileqq.activity.aio.intimate.IntimateScoreCardView;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.app.face.FaceDrawable;
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
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.FeedListView;
import cooperation.qzone.api.FeedListView.LoadFeedCallback;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class afbj
  implements afbx, aftr, aftu, Handler.Callback, View.OnClickListener, View.OnTouchListener, FeedListView.LoadFeedCallback
{
  protected int a;
  private afbf jdField_a_of_type_Afbf;
  private afbv jdField_a_of_type_Afbv;
  private afbw jdField_a_of_type_Afbw;
  private aftx jdField_a_of_type_Aftx;
  protected aiko a;
  amsu jdField_a_of_type_Amsu = new afbn(this);
  public Context a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public FragmentActivity a;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private atub jdField_a_of_type_Atub;
  atuh jdField_a_of_type_Atuh = new afbp(this);
  awac jdField_a_of_type_Awac;
  azwn jdField_a_of_type_Azwn;
  private bhht jdField_a_of_type_Bhht;
  private bjnw jdField_a_of_type_Bjnw;
  private blbi jdField_a_of_type_Blbi;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private IntimateTitleSwitchView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView;
  private IntimateScoreCardView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView;
  public QQAppInterface a;
  FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener = new afbo(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private IntimateInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  @Nullable
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  @Nullable
  private FeedListView jdField_a_of_type_CooperationQzoneApiFeedListView;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private Long jdField_a_of_type_JavaLangLong;
  public String a;
  protected List<aija> a;
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
  private View jdField_n_of_type_AndroidViewView;
  private TextView jdField_n_of_type_AndroidWidgetTextView;
  private View o;
  
  public afbj(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Aiko = new aiko();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      l1 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
      Object localObject;
      if ((l1 > 0L) && (QZoneApiProxy.needLoadQZoneEnv()))
      {
        paramString = QzonePluginProxyActivity.getQZonePluginClassLoaderInUI();
        localObject = new StringBuilder().append("IntimateInfoView: start to load qzone plugin ");
        if (paramString != null)
        {
          bool = true;
          QLog.i("IntimateInfoView", 1, bool);
          if (paramString != null) {
            break label1504;
          }
          QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new IntimateInfoView.1(this, paramFragmentActivity, paramQQAppInterface));
          bool = false;
          paramString = null;
          if (!bool) {
            break label1596;
          }
        }
      }
      try
      {
        localObject = LayoutInflater.from(paramContext).inflate(2131559273, null);
        paramString = (String)localObject;
        this.jdField_a_of_type_CooperationQzoneApiFeedListView = ((FeedListView)((View)localObject).findViewById(2131368803));
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
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)paramString.findViewById(2131376870));
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setEdgeEffectEnabled(false);
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
        }
      }
      if ((paramString == null) || (this.jdField_a_of_type_CooperationQzoneApiFeedListView == null))
      {
        paramString = LayoutInflater.from(paramContext).inflate(2131559270, null);
        this.jdField_h_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidViewView = paramString.findViewById(2131376699);
        this.jdField_b_of_type_AndroidViewView = paramString.findViewById(2131378811);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramString.findViewById(2131363264));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramString.findViewById(2131378771));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramString.findViewById(2131370702));
        if (!this.jdField_h_of_type_Boolean) {
          break label1547;
        }
        localObject = LayoutInflater.from(paramContext).inflate(2131559271, null);
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131377062));
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367255));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView = ((IntimateTitleSwitchView)((View)localObject).findViewById(2131368805));
        this.jdField_c_of_type_AndroidViewView = ((View)localObject).findViewById(2131364925);
        this.jdField_d_of_type_AndroidViewView = ((View)localObject).findViewById(2131364929);
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131364928));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131364927));
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131364926));
        this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131364931));
        this.jdField_e_of_type_AndroidViewView = ((View)localObject).findViewById(2131376045);
        this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131376043));
        this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131376044));
        this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131376046));
        this.jdField_i_of_type_AndroidViewView = ((View)localObject).findViewById(2131365904);
        this.jdField_f_of_type_AndroidViewView = ((View)localObject).findViewById(2131367274);
        this.jdField_g_of_type_AndroidViewView = ((View)localObject).findViewById(2131367272);
        this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367267));
        this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367270));
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((View)localObject).findViewById(2131367273));
        this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368816));
        this.jdField_h_of_type_AndroidViewView = ((View)localObject).findViewById(2131367241);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367239));
        this.jdField_m_of_type_AndroidViewView = ((View)localObject).findViewById(2131367250);
        this.jdField_n_of_type_AndroidViewView = ((View)localObject).findViewById(2131367245);
        this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367246));
        this.jdField_b_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((View)localObject).findViewById(2131367249));
        this.jdField_n_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367248));
        this.jdField_k_of_type_AndroidViewView = ((View)localObject).findViewById(2131370390);
        this.jdField_l_of_type_AndroidViewView = ((View)localObject).findViewById(2131370387);
        this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131370389));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131370692));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView = ((IntimateScoreCardView)((View)localObject).findViewById(2131368818));
        this.o = ((View)localObject).findViewById(2131367244);
        this.jdField_j_of_type_AndroidViewView = ((View)localObject).findViewById(2131367234);
        this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367235));
        if (!this.jdField_h_of_type_Boolean) {
          break label1554;
        }
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.setOverScrollMode(0);
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.setEdgeEffectEnabled(false);
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.setVerticalScrollBarEnabled(false);
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.addHeaderView((View)localObject);
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.attach(paramQQAppInterface, paramFragmentActivity, l1);
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.setCallBack(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.setApp(paramQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.setCallBack(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.setApp(paramQQAppInterface);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_l_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_Afbw = new afbw(this, null);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(ViewUtils.dip2px(5.0F));
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Afbw);
        this.jdField_a_of_type_Afbv = new afbv(this, null);
        this.jdField_b_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(ViewUtils.dip2px(5.0F));
        this.jdField_b_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Afbv);
        this.jdField_n_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
        this.jdField_d_of_type_AndroidViewView.setOnTouchListener(this);
        this.jdField_e_of_type_AndroidViewView.setOnTouchListener(this);
        this.jdField_g_of_type_AndroidViewView.setOnTouchListener(this);
        this.jdField_l_of_type_AndroidViewView.setOnTouchListener(this);
        this.jdField_i_of_type_AndroidViewView.setOnTouchListener(this);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this);
        this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(this);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnTouchListener(this);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setTransTouchStateToParent(true);
        this.jdField_b_of_type_ComTencentWidgetHorizontalListView.setOnTouchListener(this);
        this.jdField_b_of_type_ComTencentWidgetHorizontalListView.setTransTouchStateToParent(true);
        this.jdField_n_of_type_AndroidViewView.setOnTouchListener(this);
        if (AppSetting.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(amtj.a(2131704940));
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(amtj.a(2131704950));
          this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(amtj.a(2131704955));
          this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(amtj.a(2131704953));
        }
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          paramQQAppInterface.setMargins(0, ImmersiveUtils.getStatusBarHeight(paramContext), 0, 0);
          this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramQQAppInterface);
        }
        f1 = paramContext.getResources().getDisplayMetrics().density;
        AIOUtils.expandViewTouchDelegate(this.jdField_e_of_type_AndroidWidgetTextView, (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F));
        AIOUtils.expandViewTouchDelegate(this.jdField_f_of_type_AndroidWidgetTextView, (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F), (int)(f1 * 10.0F + 0.5F));
        paramQQAppInterface = new afbq(this);
        paramFragmentActivity = new afbr(this);
        this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(paramFragmentActivity);
        this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(paramQQAppInterface);
        this.jdField_a_of_type_Azwn = new azwn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramQQAppInterface = this.jdField_a_of_type_Azwn;
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(azwn.a());
        if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
          this.jdField_j_of_type_AndroidViewView.setVisibility(0);
        }
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
        label1504:
        bool = QZoneApiProxy.needShowAioFeedList(paramFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        continue;
        bool = false;
        continue;
        label1547:
        label1554:
        label1596:
        paramString = null;
      }
    }
  }
  
  private Bitmap a(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo)
  {
    if (paramPrefetchMutualMarkInfo == null) {
      return null;
    }
    Bitmap localBitmap2 = b(paramPrefetchMutualMarkInfo.iconStaticUrl);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      i1 = awfn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramPrefetchMutualMarkInfo.type, paramPrefetchMutualMarkInfo.level);
      if (i1 == 0) {
        return null;
      }
      localBitmap2 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), i1);
      localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        return null;
      }
    }
    localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth(), localBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap2);
    Paint localPaint = new Paint();
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(0.0F);
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    int i2 = localBitmap1.getHeight() + 32;
    int i1 = i2;
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener);
    }
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, paramString, 0, (byte)4);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 4);
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
    for (String str = awgt.b(paramInt1, paramInt2); (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (str.equals(this.jdField_c_of_type_JavaLangString)); str = awgt.a(paramInt1, paramInt2)) {
      return;
    }
    Object localObject;
    if (paramInt1 == 3) {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840473);
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
      localURLDrawableOptions.mRequestWidth = ViewUtils.getScreenWidth();
      localURLDrawableOptions.mRequestHeight = ViewUtils.getScreenHeight();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localObject = URLDrawable.getDrawable(str, localURLDrawableOptions);
      ((URLDrawable)localObject).setDecodeHandler(bfol.z);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
      this.jdField_c_of_type_JavaLangString = str;
      return;
      if (paramInt1 == 2) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840471);
      } else if (paramInt1 == 26) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840488);
      } else if (paramInt1 == 1) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840475);
      } else {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840479);
      }
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_Afbf == null)
    {
      ThreadManager.getFileThreadHandler().post(new IntimateInfoView.12(this, paramURLDrawable));
      return;
    }
    this.jdField_a_of_type_Afbf.a();
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
    QLog.d("intimate_relationship", 1, "updateIntimateInfo: " + paramIntimateInfo);
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
    label368:
    int i3;
    if (paramIntimateInfo.beFriendDays >= -1) {
      if (this.jdField_b_of_type_Int == 3)
      {
        this.jdField_c_of_type_Int = 4;
        this.jdField_k_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        a(this.jdField_b_of_type_Int, paramIntimateInfo.maskLevel);
        this.jdField_e_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.a(paramIntimateInfo, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.setData(paramIntimateInfo, this.jdField_b_of_type_Int);
        if (paramIntimateInfo.memoryDayInfoList != null)
        {
          AbstractGifImage.resumeAll();
          if (this.jdField_a_of_type_Aftx == null)
          {
            this.jdField_a_of_type_Aftx = new aftx(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Aftx.a(new afbs(this));
          }
          localObject1 = new ArrayList(paramIntimateInfo.memoryDayInfoList);
          this.jdField_a_of_type_Aftx.a(this.jdField_a_of_type_AndroidContentContext, (ArrayList)localObject1);
          if ((this.jdField_a_of_type_Aftx.a() != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Aftx.a());
          }
        }
        if (this.jdField_b_of_type_Boolean) {
          x();
        }
        if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Awac != null))
        {
          localObject3 = this.jdField_a_of_type_Awac.a();
          localObject4 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          localObject1 = "";
          localObject2 = this.jdField_a_of_type_Awac.a();
          if (localObject2 != null) {
            localObject1 = ((avzw)localObject2).b();
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = ((TroopManager)localObject4).a((String)localObject3, this.jdField_a_of_type_JavaLangString);
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        }
        if ((paramIntimateInfo.commonTroopInfoList == null) || (paramIntimateInfo.commonTroopInfoList.size() <= 0)) {
          break label995;
        }
        i1 = 1;
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break label1000;
        }
        i2 = 1;
        label389:
        i3 = 0;
        localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693140);
        if (i2 != 0) {
          i3 = aimu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        }
        if (i3 == 2) {
          localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693139);
        }
        if ((i1 == 0) && (i2 == 0)) {
          break label1198;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        if (i1 == 0) {
          break label1005;
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
            localObject2 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, ((IntimateInfo.CommonTroopInfo)localObject2).troopCode);
            this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          }
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
        if (i2 != 0)
        {
          this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          bcef.b(null, "dc00898", "", "", "0X800AD21", "0X800AD21", 0, 0, "0", "0", "", "");
        }
        if (this.jdField_b_of_type_Boolean) {
          bcef.b(null, "dc00898", "", "", "0X8009F51", "0X8009F51", this.jdField_c_of_type_Int, 0, "", "", "", "");
        }
      }
    }
    for (;;)
    {
      localObject1 = new ArrayList();
      if ((paramIntimateInfo.markInfoList == null) || (paramIntimateInfo.markInfoList.size() <= 0)) {
        break label2077;
      }
      localObject2 = paramIntimateInfo.markInfoList.iterator();
      i1 = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (IntimateInfo.MutualMarkInfo)((Iterator)localObject2).next();
        if (!a((IntimateInfo.MutualMarkInfo)localObject3)) {
          break label2074;
        }
        ((ArrayList)localObject1).add(localObject3);
        i1 += 1;
      }
      if (this.jdField_b_of_type_Int == 2)
      {
        this.jdField_c_of_type_Int = 3;
        this.jdField_k_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        a(this.jdField_b_of_type_Int, paramIntimateInfo.maskLevel);
        this.jdField_e_of_type_Boolean = true;
        break;
      }
      if (this.jdField_b_of_type_Int == 26)
      {
        this.jdField_c_of_type_Int = 5;
        this.jdField_k_of_type_AndroidViewView.setVisibility(8);
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
      this.jdField_k_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      a(0, paramIntimateInfo.maskLevel);
      this.jdField_e_of_type_Boolean = false;
      break;
      a(0, paramIntimateInfo.maskLevel);
      break;
      label995:
      i1 = 0;
      break label368;
      label1000:
      i2 = 0;
      break label389;
      label1005:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693142));
      localObject2 = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
      this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.dp2px(10.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
      this.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      bcef.b(null, "dc00898", "", "", "0X800AD21", "0X800AD21", 0, 0, "0", "0", "", "");
      continue;
      label1198:
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    int i2 = i1;
    if (this.jdField_b_of_type_Boolean) {
      bcef.b(null, "dc00898", "", "", "0X8009F52", "0X8009F52", this.jdField_c_of_type_Int, 0, "", "", "", "");
    }
    label1546:
    label1942:
    label2074:
    label2077:
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
            break label2065;
          }
          ((ArrayList)localObject1).add(localObject3);
          i1 += 1;
        }
        i3 = i1;
        if (this.jdField_b_of_type_Boolean) {
          bcef.b(null, "dc00898", "", "", "0X8009F52", "0X8009F52", this.jdField_c_of_type_Int, 0, "", "", "", "");
        }
      }
      for (i3 = i1;; i3 = 0)
      {
        if (!((ArrayList)localObject1).isEmpty()) {
          if (i2 == 0)
          {
            this.jdField_i_of_type_AndroidWidgetTextView.setText(String.valueOf(i3));
            this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693166));
            this.jdField_f_of_type_AndroidViewView.setVisibility(0);
            this.jdField_a_of_type_Afbw.a((List)localObject1);
            this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
            this.jdField_g_of_type_Boolean = awfm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            label1464:
            localObject1 = this.jdField_e_of_type_AndroidWidgetImageView;
            if ((!paramIntimateInfo.isShowRedPoint) && (!this.jdField_g_of_type_Boolean)) {
              break label1871;
            }
            i1 = 0;
            label1486:
            ((ImageView)localObject1).setVisibility(i1);
            if ((paramIntimateInfo.dnaInfoList == null) || (paramIntimateInfo.dnaInfoList.size() <= 0)) {
              break label1942;
            }
            this.jdField_h_of_type_AndroidViewView.setVisibility(0);
            if (this.jdField_a_of_type_Awac != null) {
              break label1877;
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
            label1533:
            localObject3 = paramIntimateInfo.dnaInfoList.iterator();
            i1 = 0;
            if (!((Iterator)localObject3).hasNext()) {
              break label1951;
            }
            localObject4 = (IntimateInfo.DNAInfo)((Iterator)localObject3).next();
            localObject1 = null;
            if (this.jdField_a_of_type_Awac != null) {
              localObject1 = this.jdField_a_of_type_Awac.a();
            }
            if (localObject1 != null) {
              break label2062;
            }
            localObject1 = aftv.a(this.jdField_a_of_type_AndroidContentContext);
          }
        }
        for (;;)
        {
          localObject2 = (TextView)((View)localObject1).findViewById(2131378809);
          TextView localTextView = (TextView)((View)localObject1).findViewById(2131378691);
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
              ((SpannableString)localObject2).setSpan(new afbt(this, (IntimateInfo.DNAInfo)localObject4), i2, i3, 33);
              localTextView.setText((CharSequence)localObject2);
              localTextView.setMovementMethod(LinkMovementMethod.getInstance());
            }
          }
          for (;;)
          {
            localObject2 = new LinearLayout.LayoutParams(-1, -1);
            ((LinearLayout.LayoutParams)localObject2).topMargin = ViewUtils.dip2px(16.0F);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            i1 += 1;
            break label1546;
            this.jdField_i_of_type_AndroidWidgetTextView.setText(String.valueOf(i2));
            break;
            this.jdField_f_of_type_AndroidViewView.setVisibility(8);
            this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
            break label1464;
            label1871:
            i1 = 8;
            break label1486;
            label1877:
            i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
            i1 = 0;
            while (i1 < i2)
            {
              localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
              this.jdField_a_of_type_Awac.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, (View)localObject1);
              i1 += 1;
            }
            break label1533;
            localTextView.setText((CharSequence)localObject2);
            continue;
            localTextView.setVisibility(8);
          }
          this.jdField_h_of_type_AndroidViewView.setVisibility(8);
          label1951:
          c(paramIntimateInfo);
          IntimatePlayTogetherMiniGameCardView.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
          if (this.jdField_b_of_type_Boolean)
          {
            bcef.b(null, "dc00898", "", "", "0X8009F4D", "0X8009F4D", this.jdField_c_of_type_Int, 0, "", "", "", "");
            if (this.jdField_c_of_type_Int == 2) {
              bcef.b(null, "dc00898", "", "", "0X800A05F", "0X800A05F", 0, 0, "", "", "", "");
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
  
  private void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
        break label91;
      }
      if (this.jdField_a_of_type_Atub == null) {
        this.jdField_a_of_type_Atub = ((atub)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(153));
      }
      this.jdField_a_of_type_Atub.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType);
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
      localMessage.obj = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718582);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      QLog.d("intimate_relationship", 1, String.format("disbandIntimateRelationship network is not available, uin: %s", new Object[] { paramString }));
    }
  }
  
  private boolean a(IntimateInfo.MutualMarkInfo paramMutualMarkInfo)
  {
    if (!awfn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMutualMarkInfo.type)) {}
    int i1;
    do
    {
      return false;
      int i2 = awfn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramMutualMarkInfo.type, paramMutualMarkInfo.level);
      awgn localawgn = awfn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMutualMarkInfo.type);
      i1 = i2;
      if (localawgn != null)
      {
        i1 = i2;
        if (localawgn.jdField_b_of_type_Boolean) {
          i1 = 0;
        }
      }
    } while ((TextUtils.isEmpty(paramMutualMarkInfo.iconStaticUrl)) && (i1 == 0));
    return true;
  }
  
  private Bitmap b(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo)
  {
    int i2 = AIOUtils.dp2px(45.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
  
  private Bitmap b(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localObject1 = axic.a.a(paramString);
      return localObject1;
    }
    catch (Exception paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("intimate_relationship", 2, "PushUtil.INSTANCE.getBitmapFromUrl() error = " + paramString);
    }
    return null;
  }
  
  private void b(IntimateInfo paramIntimateInfo)
  {
    if (paramIntimateInfo == null) {
      return;
    }
    this.jdField_c_of_type_Int = 2;
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if ((this.jdField_k_of_type_AndroidViewView.getVisibility() == 8) && (this.jdField_a_of_type_Boolean)) {
      o();
    }
    this.jdField_k_of_type_AndroidViewView.setVisibility(0);
    avjp.a("6", "2", "1", LpReportInfo_dc03950.getReportUserType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    a(this.jdField_b_of_type_Int, paramIntimateInfo.maskLevel);
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = true;
      u();
    }
    this.jdField_e_of_type_Boolean = true;
  }
  
  private void b(String paramString)
  {
    bcef.b(null, "dc00898", "", "", "0X800A11A", "0X800A11A", this.jdField_c_of_type_Int, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentImageURLDrawable == null)
    {
      d(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693585));
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = 750;
      localURLDrawableOptions.mRequestHeight = 1272;
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    }
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) || (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 4))
    {
      v();
      a(this.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new afbk(this));
    ThreadManager.getFileThreadHandler().post(new IntimateInfoView.11(this));
  }
  
  private void c(IntimateInfo paramIntimateInfo)
  {
    if ((this.jdField_a_of_type_Afbv != null) && (paramIntimateInfo != null) && (paramIntimateInfo.commonBodyList != null) && (paramIntimateInfo.commonBodyList.size() > 0))
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
            this.jdField_m_of_type_AndroidWidgetTextView.setText(String.valueOf(paramIntimateInfo.friendGiftInfo.str_send_times));
            this.jdField_n_of_type_AndroidWidgetTextView.setText(paramIntimateInfo.friendGiftInfo.str_desc);
            this.jdField_m_of_type_AndroidViewView.setVisibility(0);
            if (paramIntimateInfo.friendGiftInfo.str_gift_url.size() > 6) {
              this.jdField_a_of_type_Afbv.a(paramIntimateInfo.friendGiftInfo.str_gift_url.subList(0, 6));
            }
            for (;;)
            {
              this.jdField_b_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
              if (!this.jdField_b_of_type_Boolean) {
                break;
              }
              bcef.b(null, "dc00898", "", "", "0X800A3B3", "0X800A3B3", this.jdField_c_of_type_Int, 0, "", "", "", "");
              break;
              this.jdField_a_of_type_Afbv.a(paramIntimateInfo.friendGiftInfo.str_gift_url);
            }
          }
          this.jdField_m_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
        }
      }
    }
  }
  
  private void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "disbandLoverRelationship sendRequest");
    }
    blbg localblbg = new blbg();
    try
    {
      localblbg.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()), Long.parseLong(paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramString.what = 5;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
    }
  }
  
  private void d(String paramString)
  {
    if (this.jdField_a_of_type_Bhht == null)
    {
      this.jdField_a_of_type_Bhht = new bhht(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      this.jdField_a_of_type_Bhht.c(true);
    }
    this.jdField_a_of_type_Bhht.a(paramString);
    if ((this.jdField_a_of_type_Bhht != null) && (!this.jdField_a_of_type_Bhht.isShowing()) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
      this.jdField_a_of_type_Bhht.show();
    }
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("isIntimate" + this.jdField_e_of_type_Boolean, new Object[0]));
    }
    bcef.b(null, "dc00898", "", "", "0X800A119", "0X800A119", this.jdField_c_of_type_Int, 0, "", "", "", "");
    this.jdField_a_of_type_Bjnw = bjnw.c(this.jdField_a_of_type_AndroidContentContext);
    String str = awgt.c(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskLevel);
    if (!TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_Bjnw.a(2131693167, 0);
    }
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_Bjnw.a(2131693143, 3);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bjnw.a(new afbu(this, str));
      this.jdField_a_of_type_Bjnw.c(2131690620);
      this.jdField_a_of_type_Bjnw.show();
      return;
      this.jdField_a_of_type_Bjnw.a(2131693154, 0);
    }
  }
  
  private void s()
  {
    bcef.b(null, "dc00898", "", "", "0X8009F71", "0X8009F71", 0, 0, "", "", "", "");
    String str = awgt.a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "click menu_bind_intimate url:" + str);
    }
    if (!TextUtils.isEmpty(str))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent.putExtra("url", str));
    }
  }
  
  private void t()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      QLog.d("intimate_relationship", 1, "showDisbandDialog, mActivity == null or is finishing!");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(2131693146).setPositiveButton(2131693145, new afbm(this)).setNegativeButton(2131693144, new afbl(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void u()
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
  
  private void v()
  {
    if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bhht.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void w()
  {
    String str = awgt.c(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskLevel);
    if (!TextUtils.isEmpty(str))
    {
      b(str);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, amtj.a(2131704941), 1).a();
  }
  
  private void x()
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
            bcef.b(null, "dc00898", "", "", "0X800A207 ", "0X800A207 ", localMemoryDayInfo.dateType, 0, "", "", "", "");
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
            bcef.b(null, "dc00898", "", "", "0X800A209 ", "0X800A209 ", 0, 0, "", "", "", "");
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
  
  private void y()
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
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.loadMore(this);
  }
  
  private void z()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    TroopWithCommonFriendsFragment.a(this.jdField_a_of_type_JavaLangString);
    TroopWithCommonFriendsFragment.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Atuh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amsu);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.setCurrentShowType(paramInt);
    if (!this.jdField_i_of_type_Boolean)
    {
      y();
      this.jdField_i_of_type_Boolean = true;
    }
    FeedListView localFeedListView;
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)
    {
      localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
      if ((paramInt == 3) || (paramInt == 4)) {
        break label139;
      }
    }
    for (;;)
    {
      localFeedListView.setLongClickValid(bool);
      return;
      label139:
      bool = false;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.doActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(ImageView paramImageView, String paramString, Drawable paramDrawable, int paramInt)
  {
    paramString = VasApngUtil.getApngURLDrawable(paramString, VasApngUtil.VIP_APNG_TAGS, paramDrawable, null, null);
    paramDrawable = paramImageView.getLayoutParams();
    paramDrawable.width = paramDrawable.height;
    paramImageView.setImageDrawable(null);
    paramImageView.setImageDrawable(paramString);
    paramImageView.setLayoutParams(paramDrawable);
    if (paramInt == 17)
    {
      paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      return;
    }
    paramImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
  }
  
  public void a(avzw paramavzw, String paramString)
  {
    if (paramavzw == null) {}
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_JavaLangString = paramavzw.a();
          this.jdField_b_of_type_JavaLangString = paramString;
        } while (paramavzw.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null);
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Atuh);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amsu);
        }
        this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramavzw.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
        paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramString.what = 0;
        paramString.obj = paramavzw.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
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
  
  public void a(awac paramawac)
  {
    if (this.jdField_a_of_type_Awac != null)
    {
      this.jdField_a_of_type_Awac.k();
      this.jdField_a_of_type_Awac = null;
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
    }
    a(3);
    this.jdField_a_of_type_Awac = paramawac;
    this.jdField_f_of_type_Boolean = true;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IntimateInfoView", 2, "onScoreCardActionClick strUrl:" + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.toLowerCase().startsWith("http://")) || (paramString.toLowerCase().startsWith("https://"))))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("selfSet_leftViewText", amtj.a(2131705660));
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
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
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)))
    {
      if (this.jdField_a_of_type_Atub == null) {
        this.jdField_a_of_type_Atub = ((atub)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(153));
      }
      this.jdField_a_of_type_Atub.b(this.jdField_a_of_type_JavaLangString);
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
    //   1: getfield 127	afbj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4: invokestatic 703	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +55 -> 62
    //   10: aload_0
    //   11: getfield 123	afbj:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   14: invokestatic 1138	com/tencent/mobileqq/utils/NetworkUtil:isNetworkAvailable	(Landroid/content/Context;)Z
    //   17: ifeq +152 -> 169
    //   20: aload_0
    //   21: getfield 1140	afbj:jdField_a_of_type_Atub	Latub;
    //   24: ifnonnull +20 -> 44
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 121	afbj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   32: sipush 153
    //   35: invokevirtual 1144	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   38: checkcast 1146	atub
    //   41: putfield 1140	afbj:jdField_a_of_type_Atub	Latub;
    //   44: aload_0
    //   45: getfield 892	afbj:jdField_a_of_type_Awac	Lawac;
    //   48: ifnonnull +45 -> 93
    //   51: aload_0
    //   52: getfield 1140	afbj:jdField_a_of_type_Atub	Latub;
    //   55: aload_0
    //   56: getfield 127	afbj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   59: invokevirtual 1598	atub:a	(Ljava/lang/String;)V
    //   62: invokestatic 677	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq +27 -> 92
    //   68: ldc_w 679
    //   71: iconst_2
    //   72: ldc_w 1600
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: aload_0
    //   82: getfield 127	afbj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   85: aastore
    //   86: invokestatic 727	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   89: invokestatic 683	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: return
    //   93: new 94	java/util/ArrayList
    //   96: dup
    //   97: invokespecial 95	java/util/ArrayList:<init>	()V
    //   100: astore 5
    //   102: aload_0
    //   103: getfield 127	afbj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: invokestatic 1603	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   109: invokevirtual 1607	java/lang/Long:longValue	()J
    //   112: lstore_3
    //   113: aload_0
    //   114: getfield 1559	afbj:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   117: invokestatic 1603	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   120: invokevirtual 1607	java/lang/Long:longValue	()J
    //   123: lstore_1
    //   124: aload 5
    //   126: lload_3
    //   127: invokestatic 1610	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   130: invokevirtual 1007	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   133: pop
    //   134: aload_0
    //   135: getfield 1140	afbj:jdField_a_of_type_Atub	Latub;
    //   138: lload_1
    //   139: aload 5
    //   141: aconst_null
    //   142: invokevirtual 1613	atub:a	(JLjava/util/ArrayList;Ljava/lang/Object;)V
    //   145: goto -83 -> 62
    //   148: astore 6
    //   150: lconst_0
    //   151: lstore_1
    //   152: ldc_w 679
    //   155: iconst_2
    //   156: ldc_w 1615
    //   159: invokestatic 1222	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: lload_1
    //   163: lstore_3
    //   164: lconst_0
    //   165: lstore_1
    //   166: goto -42 -> 124
    //   169: aload_0
    //   170: getfield 650	afbj:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   173: invokevirtual 1155	android/os/Handler:obtainMessage	()Landroid/os/Message;
    //   176: astore 5
    //   178: aload 5
    //   180: iconst_1
    //   181: putfield 1160	android/os/Message:what	I
    //   184: aload 5
    //   186: aload_0
    //   187: getfield 125	afbj:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   190: invokevirtual 470	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   193: ldc_w 1161
    //   196: invokevirtual 934	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   199: putfield 1165	android/os/Message:obj	Ljava/lang/Object;
    //   202: aload_0
    //   203: getfield 650	afbj:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   206: aload 5
    //   208: invokevirtual 1169	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   211: pop
    //   212: ldc_w 679
    //   215: iconst_1
    //   216: ldc_w 1617
    //   219: iconst_1
    //   220: anewarray 4	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: aload_0
    //   226: getfield 127	afbj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   229: aastore
    //   230: invokestatic 727	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   233: invokestatic 683	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: goto -174 -> 62
    //   239: astore 6
    //   241: lload_3
    //   242: lstore_1
    //   243: goto -91 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	afbj
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
  
  public void e()
  {
    long l2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
        break label110;
      }
      l2 = 0L;
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
        aimu.a(l1, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      localMessage.obj = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718582);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      QLog.d("intimate_relationship", 1, String.format("requestTroopListWithCommonFriends network is not available, uin: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.b();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onPause();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.a();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)
    {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onStart();
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onResume();
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.d();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onStop();
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
          d((String)paramMessage.obj);
          return true;
          v();
          return true;
          v();
          QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131693147, 1).a();
          return true;
          d();
          QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131693148, 1).a();
          return true;
        } while (this.jdField_l_of_type_AndroidWidgetTextView == null);
        if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Object[])))
        {
          Object localObject = (Object[])paramMessage.obj;
          paramMessage = (String)localObject[0];
          String str = (String)localObject[1];
          localObject = (String)localObject[2];
          paramMessage = String.format("<font color=\"#878B99\">" + paramMessage + " </font> <font color=\"#FF7EAE\">" + str + "</font>", new Object[0]);
          this.jdField_l_of_type_AndroidWidgetTextView.setText(Html.fromHtml(paramMessage));
          this.jdField_l_of_type_AndroidWidgetTextView.setTag(localObject);
          this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
          return true;
        }
        this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
        return true;
      } while (this.jdField_l_of_type_AndroidWidgetTextView == null);
      this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
      return true;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
    return true;
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.c();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onStart();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Atuh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amsu);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = null;
    }
    if (this.jdField_a_of_type_Afbf != null) {
      this.jdField_a_of_type_Afbf.b();
    }
    if (this.jdField_a_of_type_Aftx != null)
    {
      this.jdField_a_of_type_Aftx.a();
      this.jdField_a_of_type_Aftx = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.e();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.setApp(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.e();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.setApp(null);
    }
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)
    {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onDestroy();
      this.jdField_c_of_type_Boolean = true;
    }
    if (this.o != null) {
      this.o.setVisibility(8);
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Awac != null) {
      this.jdField_a_of_type_Awac.a();
    }
    while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  public void l()
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
  
  public void m()
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
  
  public void n()
  {
    o();
  }
  
  public void o()
  {
    if ((this.jdField_k_of_type_AndroidViewView.getVisibility() != 0) && ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType != 1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "showLoverValueText stop request");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "getLoverIntimateValue sendRequest");
    }
    if (this.jdField_a_of_type_Blbi == null) {
      this.jdField_a_of_type_Blbi = new blbi();
    }
    try
    {
      this.jdField_a_of_type_Blbi.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
      LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "6", "1", "1"));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.d("IntimateInfoView", 1, "getLoverIntimateValue", localNumberFormatException);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    long l1 = SystemClock.elapsedRealtime();
    if ((this.jdField_a_of_type_JavaLangLong != null) && (l1 - this.jdField_a_of_type_JavaLangLong.longValue() < 500L)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(l1);
      Object localObject1;
      Object localObject2;
      switch (paramView.getId())
      {
      case 2131367241: 
      default: 
        break;
      case 2131363264: 
        k();
        break;
      case 2131370702: 
        r();
        break;
      case 2131364929: 
        if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList != null))
        {
          CommonTroopListActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (ArrayList)this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList, this.jdField_c_of_type_Int);
          bcef.b(null, "dc00898", "", "", "0X8009F4E", "0X8009F4E", this.jdField_c_of_type_Int, 0, "", "", "", "");
        }
        else
        {
          z();
        }
        break;
      case 2131376045: 
        if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.recentChatTroopInfo != null))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.recentChatTroopInfo;
          localObject2 = AIOUtils.setOpenAIOIntent(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
          ((Intent)localObject2).putExtra("uin", ((IntimateInfo.CommonTroopInfo)localObject1).troopCode);
          ((Intent)localObject2).putExtra("uintype", 1);
          ((Intent)localObject2).putExtra("uinname", ((IntimateInfo.CommonTroopInfo)localObject1).troopName);
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject2);
          bcef.b(null, "dc00898", "", "", "0X8009F4F", "0X8009F4F", this.jdField_c_of_type_Int, 0, "", "", "", "");
        }
        break;
      case 2131367272: 
        localObject1 = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
        localObject2 = apyz.a().a(this.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("intimate_relationship", 2, String.format("goToC2CWebPage, url: %s", new Object[] { localObject2 }));
        }
        ((Intent)localObject1).putExtra("url", (String)localObject2);
        ((Intent)localObject1).putExtra("finish_animation_out_to_right", true);
        ((Intent)localObject1).putExtra("is_wrap_content", true);
        ((Intent)localObject1).putExtra("hide_left_button", false);
        if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject1);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.isShowRedPoint)
        {
          c();
          this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.isShowRedPoint = false;
        }
        if (this.jdField_g_of_type_Boolean)
        {
          this.jdField_g_of_type_Boolean = false;
          awfm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        bcef.b(null, "dc00898", "", "", "0X8009F50", "0X8009F50", this.jdField_c_of_type_Int, 0, "", "", "", "");
        break;
      case 2131370387: 
        avjp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2064, "2");
        bcef.b(null, "dc00898", "", "", "0X800A05E", "0X800A05E", 0, 0, "", "", "", "");
        break;
      case 2131367245: 
        localObject1 = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.friendGiftInfo.str_custom_url;
        if (QLog.isColorLevel()) {
          QLog.d("intimate_relationship", 2, String.format("goToFriendGiftWebPage, url: %s", new Object[] { localObject2 }));
        }
        ((Intent)localObject1).putExtra("url", (String)localObject2);
        ((Intent)localObject1).putExtra("finish_animation_out_to_right", true);
        ((Intent)localObject1).putExtra("is_wrap_content", true);
        ((Intent)localObject1).putExtra("hide_left_button", false);
        if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject1);
        }
        bcef.b(null, "dc00898", "", "", "0X800A3B4", "0X800A3B4", this.jdField_c_of_type_Int, 0, "", "", "", "");
        break;
      case 2131365904: 
        if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
        {
          localObject1 = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, FriendProfileMoreInfoActivity.class);
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject1);
        }
        break;
      case 2131367235: 
        this.jdField_a_of_type_Azwn.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_JavaLangString);
        break;
      case 2131377062: 
        if (this.jdField_a_of_type_Awac == null)
        {
          localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
          ProfileActivity.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (ProfileActivity.AllInOne)localObject1);
        }
        else
        {
          localObject1 = this.jdField_a_of_type_Awac.a();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            aynd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, -1);
          } else {
            QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
          }
        }
        break;
      case 2131367255: 
        if (this.jdField_a_of_type_Awac == null)
        {
          localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 1);
          ProfileActivity.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (ProfileActivity.AllInOne)localObject1);
        }
        else
        {
          localObject1 = this.jdField_a_of_type_Awac.a();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            aynd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject1, this.jdField_a_of_type_JavaLangString, 0, -1);
          } else {
            QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
          }
        }
        break;
      case 2131364926: 
      case 2131364931: 
        z();
      }
    }
  }
  
  public void onLoadOver(boolean paramBoolean)
  {
    QLog.i("IntimateInfoView", 4, "onLoadOver: " + paramBoolean);
    if ((this.o == null) || (this.jdField_a_of_type_CooperationQzoneApiFeedListView == null)) {
      return;
    }
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView.getFeedCnt() > 0)
    {
      this.o.setVisibility(0);
      return;
    }
    this.o.setVisibility(8);
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
    QLog.i("IntimateInfoView", 4, "onZoomIn: ");
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView == null) {}
    do
    {
      return;
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.attach(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, Long.parseLong(this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.loadMore(this);
        this.jdField_c_of_type_Boolean = false;
        return;
      }
    } while (!this.jdField_j_of_type_Boolean);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.loadMore(this);
    this.jdField_j_of_type_Boolean = false;
  }
  
  public void q()
  {
    QLog.i("IntimateInfoView", 4, "onZoomOut: ");
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.scrollToHeadView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbj
 * JD-Core Version:    0.7.0.1
 */