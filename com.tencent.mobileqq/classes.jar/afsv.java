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
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.1;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.2;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.4;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.7;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.8;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemClueView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemFriendInfoView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemGiftView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemLoverAchievementView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemLoverEntranceView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemMutualMarkView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemNewDnaView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemOldDnaView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.DNAInfo;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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

public class afsv
  implements agll, aglo, Handler.Callback, View.OnClickListener, View.OnTouchListener, FeedListView.LoadFeedCallback
{
  private int jdField_a_of_type_Int;
  private afsr jdField_a_of_type_Afsr;
  private aglr jdField_a_of_type_Aglr;
  public Context a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public FragmentActivity a;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  anvi jdField_a_of_type_Anvi = new afsw(this);
  private auzb jdField_a_of_type_Auzb;
  auzh jdField_a_of_type_Auzh = new afsz(this);
  axge jdField_a_of_type_Axge;
  private bisl jdField_a_of_type_Bisl;
  private bkzi jdField_a_of_type_Bkzi;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private IntimateContentItemClueView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemClueView;
  private IntimateContentItemFriendInfoView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemFriendInfoView;
  private IntimateContentItemGiftView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemGiftView;
  private IntimateContentItemLoverAchievementView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverAchievementView;
  private IntimateContentItemLoverEntranceView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverEntranceView;
  private IntimateContentItemMutualMarkView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView;
  private IntimateContentItemNewDnaView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView;
  private IntimateContentItemOldDnaView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemOldDnaView;
  public QQAppInterface a;
  FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener = new aftd(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private IntimateInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  @Nullable
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  @Nullable
  private FeedListView jdField_a_of_type_CooperationQzoneApiFeedListView;
  private Long jdField_a_of_type_JavaLangLong;
  public String a;
  private ArrayList<IntimateContentItemBaseView> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private int jdField_b_of_type_Int = 1;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  public boolean b;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private final boolean g;
  private boolean h;
  private boolean i;
  
  public afsv(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      l = Long.parseLong(this.jdField_a_of_type_JavaLangString);
      if ((l > 0L) && (QZoneApiProxy.needLoadQZoneEnv()))
      {
        paramString = QzonePluginProxyActivity.getQZonePluginClassLoaderInUI();
        localObject = new StringBuilder().append("IntimateInfoView: start to load qzone plugin ");
        if (paramString != null)
        {
          bool = true;
          QLog.i("IntimateInfoView", 1, bool);
          if (paramString != null) {
            break label569;
          }
          QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new IntimateInfoView.1(this, paramFragmentActivity, paramQQAppInterface));
          bool = false;
          if (!bool) {
            break label861;
          }
        }
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        long l;
        try
        {
          paramString = LayoutInflater.from(paramContext).inflate(2131559324, null);
        }
        catch (Throwable localThrowable1)
        {
          Object localObject;
          boolean bool;
          Iterator localIterator;
          paramString = null;
        }
        try
        {
          this.jdField_a_of_type_CooperationQzoneApiFeedListView = ((FeedListView)paramString.findViewById(2131368962));
          if ((paramString != null) && (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)) {
            break label607;
          }
          paramString = LayoutInflater.from(paramContext).inflate(2131559310, null);
          this.g = false;
          this.jdField_a_of_type_AndroidViewView = paramString.findViewById(2131376967);
          this.jdField_b_of_type_AndroidViewView = paramString.findViewById(2131379104);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramString.findViewById(2131363329));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramString.findViewById(2131379065));
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramString.findViewById(2131370887));
          if (!this.g) {
            break label615;
          }
          localObject = LayoutInflater.from(paramContext).inflate(2131559311, null);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemFriendInfoView = ((IntimateContentItemFriendInfoView)((View)localObject).findViewById(2131367385));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView = ((IntimateContentItemMutualMarkView)((View)localObject).findViewById(2131367398));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemOldDnaView = ((IntimateContentItemOldDnaView)((View)localObject).findViewById(2131367365));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemGiftView = ((IntimateContentItemGiftView)((View)localObject).findViewById(2131367374));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemClueView = ((IntimateContentItemClueView)((View)localObject).findViewById(2131367352));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverEntranceView = ((IntimateContentItemLoverEntranceView)((View)localObject).findViewById(2131370573));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView = ((IntimateContentItemNewDnaView)((View)localObject).findViewById(2131367357));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverAchievementView = ((IntimateContentItemLoverAchievementView)((View)localObject).findViewById(2131365277));
          this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemFriendInfoView);
          this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemGiftView);
          this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView);
          this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemOldDnaView);
          this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemClueView);
          this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverEntranceView);
          this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView);
          this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverAchievementView);
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!localIterator.hasNext()) {
            break label622;
          }
          ((IntimateContentItemBaseView)localIterator.next()).setIntimateInterface(this);
          continue;
          paramString = paramString;
          l = 0L;
        }
        catch (Throwable localThrowable2)
        {
          String str;
          break label593;
        }
        bool = false;
        continue;
        label569:
        bool = QZoneApiProxy.needShowAioFeedList(paramFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        continue;
        bool = false;
        continue;
        label593:
        QLog.w("IntimateInfoView", 1, "IntimateInfoView: failed to load qzone feed", localThrowable1);
        continue;
        label607:
        this.g = true;
        continue;
        label615:
        str = paramString;
        continue;
        label622:
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemFriendInfoView.g();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)str.findViewById(2131370877));
        this.jdField_c_of_type_AndroidViewView = str.findViewById(2131367368);
        if (this.g)
        {
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.setOverScrollMode(0);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.setEdgeEffectEnabled(false);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.setVerticalScrollBarEnabled(false);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.addHeaderView(str);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.attach(paramQQAppInterface, paramFragmentActivity, l);
          this.jdField_c_of_type_Boolean = false;
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this);
          this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
          if (AppSetting.jdField_c_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anvx.a(2131705291));
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131705301));
          }
          if (ImmersiveUtils.isSupporImmersive() == 1)
          {
            paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
            paramQQAppInterface.setMargins(0, ImmersiveUtils.getStatusBarHeight(paramContext), 0, 0);
            this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramQQAppInterface);
          }
          return;
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)paramString.findViewById(2131377142));
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setEdgeEffectEnabled(false);
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
        }
        label861:
        paramString = null;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {}
    for (String str = axmv.b(paramInt1, paramInt2); (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (str.equals(this.jdField_c_of_type_JavaLangString)); str = axmv.a(paramInt1, paramInt2)) {
      return;
    }
    Object localObject;
    if (paramInt1 == 3) {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840511);
    }
    for (;;)
    {
      QLog.i("intimate_relationship", 1, String.format("setBackgroundDrawable, intimateType: %s, level: %s, bgUrl: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str }));
      if (TextUtils.isEmpty(str)) {
        break;
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = ViewUtils.getScreenWidth();
      localURLDrawableOptions.mRequestHeight = ViewUtils.getScreenHeight();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localObject = URLDrawable.getDrawable(str, localURLDrawableOptions);
      ((URLDrawable)localObject).setDecodeHandler(bgxc.z);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
      this.jdField_c_of_type_JavaLangString = str;
      return;
      if (paramInt1 == 2) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840509);
      } else if (paramInt1 == 1) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840513);
      } else if (paramInt1 == 26) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840526);
      } else {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840517);
      }
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_Afsr == null)
    {
      ThreadManager.getFileThreadHandler().post(new IntimateInfoView.8(this, paramURLDrawable));
      return;
    }
    this.jdField_a_of_type_Afsr.a();
  }
  
  private void a(IntimateInfo paramIntimateInfo)
  {
    QLog.i("intimate_relationship", 1, "updateIntimateInfo: " + paramIntimateInfo);
    if (paramIntimateInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramIntimateInfo;
    this.jdField_a_of_type_Int = paramIntimateInfo.maskType;
    if (paramIntimateInfo.beFriendDays >= -1) {
      if (this.jdField_a_of_type_Int == 3)
      {
        this.jdField_b_of_type_Int = 4;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        a(this.jdField_a_of_type_Int, paramIntimateInfo.maskLevel);
        this.e = true;
      }
    }
    Object localObject;
    for (;;)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IntimateContentItemBaseView)((Iterator)localObject).next()).b(paramIntimateInfo, this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_b_of_type_Int = 3;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        a(this.jdField_a_of_type_Int, paramIntimateInfo.maskLevel);
        this.e = true;
      }
      else if (this.jdField_a_of_type_Int == 1)
      {
        c(paramIntimateInfo);
      }
      else if (this.jdField_a_of_type_Int == 26)
      {
        this.jdField_b_of_type_Int = 5;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverEntranceView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        a(this.jdField_a_of_type_Int, paramIntimateInfo.maskLevel);
        this.e = true;
      }
      else
      {
        this.jdField_b_of_type_Int = 1;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        a(0, paramIntimateInfo.maskLevel);
        this.e = false;
        continue;
        this.jdField_a_of_type_Int = 0;
        a(0, paramIntimateInfo.maskLevel);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView.setReportType(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemGiftView.setReportType(this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverEntranceView.n();
    }
    b(paramIntimateInfo);
    if (this.jdField_b_of_type_Boolean) {
      v();
    }
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Axge != null))
    {
      String str = this.jdField_a_of_type_Axge.a();
      TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      paramIntimateInfo = "";
      localObject = this.jdField_a_of_type_Axge.a();
      if (localObject != null) {
        paramIntimateInfo = ((axfy)localObject).b();
      }
      localObject = paramIntimateInfo;
      if (TextUtils.isEmpty(paramIntimateInfo)) {
        localObject = localTroopManager.a(str, this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    IntimatePlayTogetherMiniGameCardView.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
    if (this.jdField_b_of_type_Boolean)
    {
      bdla.b(null, "dc00898", "", "", "0X8009F4D", "0X8009F4D", this.jdField_b_of_type_Int, 0, "", "", "", "");
      if (this.jdField_b_of_type_Int == 2) {
        bdla.b(null, "dc00898", "", "", "0X800A05F", "0X800A05F", 0, 0, "", "", "", "");
      }
    }
    QLog.d("Intimatetest", 2, "ui ok");
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
        break label91;
      }
      if (this.jdField_a_of_type_Auzb == null) {
        this.jdField_a_of_type_Auzb = ((auzb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER));
      }
      this.jdField_a_of_type_Auzb.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType);
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
      localMessage.obj = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718971);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      QLog.d("intimate_relationship", 1, String.format("disbandIntimateRelationship network is not available, uin: %s", new Object[] { paramString }));
    }
  }
  
  private void b(IntimateInfo paramIntimateInfo)
  {
    if (paramIntimateInfo.memoryDayInfoList != null)
    {
      AbstractGifImage.resumeAll();
      if (this.jdField_a_of_type_Aglr == null)
      {
        this.jdField_a_of_type_Aglr = new aglr(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Aglr.a(new afta(this));
      }
      paramIntimateInfo = new ArrayList(paramIntimateInfo.memoryDayInfoList);
      this.jdField_a_of_type_Aglr.a(this.jdField_a_of_type_AndroidContentContext, paramIntimateInfo);
      if ((this.jdField_a_of_type_Aglr.a() != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Aglr.a());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void b(String paramString)
  {
    bdla.b(null, "dc00898", "", "", "0X800A11A", "0X800A11A", this.jdField_b_of_type_Int, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentImageURLDrawable == null)
    {
      d(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693769));
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = 750;
      localURLDrawableOptions.mRequestHeight = 1272;
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    }
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) || (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 4))
    {
      t();
      a(this.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new aftc(this));
    ThreadManager.getFileThreadHandler().post(new IntimateInfoView.7(this));
  }
  
  private void c(IntimateInfo paramIntimateInfo)
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    awpu.a("6", "2", "1", LpReportInfo_dc03950.getReportUserType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    a(this.jdField_a_of_type_Int, paramIntimateInfo.maskLevel);
    if ((!this.d) && (this.jdField_a_of_type_Boolean))
    {
      this.d = true;
      s();
    }
    this.e = true;
  }
  
  private void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "disbandLoverRelationship sendRequest");
    }
    bmnr localbmnr = new bmnr();
    try
    {
      localbmnr.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()), Long.parseLong(paramString));
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
    if (this.jdField_a_of_type_Bisl == null)
    {
      this.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      this.jdField_a_of_type_Bisl.c(true);
    }
    this.jdField_a_of_type_Bisl.a(paramString);
    if ((this.jdField_a_of_type_Bisl != null) && (!this.jdField_a_of_type_Bisl.isShowing()) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
      this.jdField_a_of_type_Bisl.show();
    }
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("isIntimate" + this.e, new Object[0]));
    }
    bdla.b(null, "dc00898", "", "", "0X800A119", "0X800A119", this.jdField_b_of_type_Int, 0, "", "", "", "");
    this.jdField_a_of_type_Bkzi = bkzi.c(this.jdField_a_of_type_AndroidContentContext);
    String str = axmv.c(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskLevel);
    if (!TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_Bkzi.a(2131693345, 0);
    }
    if (this.e) {
      this.jdField_a_of_type_Bkzi.a(2131693314, 3);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.a(new aftb(this, str));
      this.jdField_a_of_type_Bkzi.c(2131690697);
      this.jdField_a_of_type_Bkzi.show();
      return;
      this.jdField_a_of_type_Bkzi.a(2131693327, 0);
    }
  }
  
  private void q()
  {
    bdla.b(null, "dc00898", "", "", "0X8009F71", "0X8009F71", 0, 0, "", "", "", "");
    String str = axmv.a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "click menu_bind_intimate url:" + str);
    }
    if (!TextUtils.isEmpty(str))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent.putExtra("url", str));
    }
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      QLog.d("intimate_relationship", 1, "showDisbandDialog, mActivity == null or is finishing!");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(2131693317).setPositiveButton(2131693316, new afsy(this)).setNegativeButton(2131693315, new afsx(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void s()
  {
    WebProcessManager localWebProcessManager;
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app != null))
    {
      localWebProcessManager = (WebProcessManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.WEBPROCESS_MANAGER);
      if (localWebProcessManager != null) {
        break label39;
      }
    }
    label39:
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
  
  private void t()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bisl.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void u()
  {
    String str = axmv.c(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskLevel);
    if (!TextUtils.isEmpty(str))
    {
      b(str);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, anvx.a(2131705292), 1).a();
  }
  
  private void v()
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
            bdla.b(null, "dc00898", "", "", "0X800A207 ", "0X800A207 ", localMemoryDayInfo.dateType, 0, "", "", "", "");
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
            bdla.b(null, "dc00898", "", "", "0X800A209 ", "0X800A209 ", 0, 0, "", "", "", "");
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
  
  private void w()
  {
    if ((this.g) && (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null))
    {
      if ((this.jdField_c_of_type_Int == 3) || (this.jdField_c_of_type_Int == 4)) {
        this.i = true;
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.loadMore(this);
  }
  
  public Bitmap a(String paramString)
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
  
  public FragmentActivity a()
  {
    return this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public axge a()
  {
    return this.jdField_a_of_type_Axge;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Auzh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
    }
    ThreadManager.getSubThreadHandler().post(new IntimateInfoView.2(this));
  }
  
  public void a(int paramInt)
  {
    QLog.i("IntimateInfoView", 4, "setCurrentShowType: " + paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "setCurrentShowType showType: " + paramInt + "  old:" + this.jdField_c_of_type_Int);
    }
    this.jdField_c_of_type_Int = paramInt;
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IntimateContentItemBaseView)((Iterator)localObject).next()).setCurrentShowType(paramInt);
    }
    if (!this.h)
    {
      w();
      this.h = true;
    }
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)
    {
      localObject = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
      if ((paramInt == 3) || (paramInt == 4)) {
        break label156;
      }
    }
    label156:
    for (boolean bool = true;; bool = false)
    {
      ((FeedListView)localObject).setLongClickValid(bool);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.g) && (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.doActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(axfy paramaxfy, String paramString)
  {
    if (paramaxfy == null) {}
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_JavaLangString = paramaxfy.a();
          this.jdField_b_of_type_JavaLangString = paramString;
        } while (paramaxfy.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null);
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Auzh);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
        }
        this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramaxfy.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
        paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramString.what = 0;
        paramString.obj = paramaxfy.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
        if (!this.g) {
          break;
        }
      } while (this.jdField_a_of_type_CooperationQzoneApiFeedListView == null);
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.scrollTo(0, 0);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView == null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.scrollTo(0, 0);
  }
  
  public void a(axge paramaxge)
  {
    if (this.jdField_a_of_type_Axge != null)
    {
      this.jdField_a_of_type_Axge.k();
      this.jdField_a_of_type_Axge = null;
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
    }
    a(3);
    this.jdField_a_of_type_Axge = paramaxge;
    this.f = true;
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
      localIntent.putExtra("selfSet_leftViewText", anvx.a(2131706011));
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemFriendInfoView.m();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView.setNeedReportPage(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemGiftView.setNeedReportPage(paramBoolean);
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 104	afsv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4: invokestatic 415	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +63 -> 70
    //   10: aload_0
    //   11: getfield 100	afsv:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   14: invokestatic 641	com/tencent/mobileqq/utils/NetworkUtil:isNetworkAvailable	(Landroid/content/Context;)Z
    //   17: ifeq +163 -> 180
    //   20: aload_0
    //   21: getfield 643	afsv:jdField_a_of_type_Auzb	Lauzb;
    //   24: ifnonnull +20 -> 44
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 98	afsv:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   32: getstatic 648	com/tencent/mobileqq/app/BusinessHandlerFactory:INTIMATE_INFO_HANDLER	I
    //   35: invokevirtual 652	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   38: checkcast 654	auzb
    //   41: putfield 643	afsv:jdField_a_of_type_Auzb	Lauzb;
    //   44: aload_0
    //   45: getfield 581	afsv:jdField_a_of_type_Axge	Laxge;
    //   48: ifnonnull +53 -> 101
    //   51: invokestatic 1074	arav:a	()Larau;
    //   54: getfield 1077	arau:d	Z
    //   57: istore_1
    //   58: aload_0
    //   59: getfield 643	afsv:jdField_a_of_type_Auzb	Lauzb;
    //   62: aload_0
    //   63: getfield 104	afsv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   66: iload_1
    //   67: invokevirtual 1080	auzb:a	(Ljava/lang/String;Z)V
    //   70: invokestatic 658	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +27 -> 100
    //   76: ldc_w 437
    //   79: iconst_2
    //   80: ldc_w 1082
    //   83: iconst_1
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_0
    //   90: getfield 104	afsv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   93: aastore
    //   94: invokestatic 449	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   97: invokestatic 635	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: return
    //   101: new 74	java/util/ArrayList
    //   104: dup
    //   105: invokespecial 75	java/util/ArrayList:<init>	()V
    //   108: astore 6
    //   110: aload_0
    //   111: getfield 104	afsv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   114: invokestatic 1085	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   117: invokevirtual 1089	java/lang/Long:longValue	()J
    //   120: lstore 4
    //   122: aload_0
    //   123: getfield 1030	afsv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   126: invokestatic 1085	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   129: invokevirtual 1089	java/lang/Long:longValue	()J
    //   132: lstore_2
    //   133: aload 6
    //   135: lload 4
    //   137: invokestatic 1092	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   140: invokevirtual 253	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   143: pop
    //   144: aload_0
    //   145: getfield 643	afsv:jdField_a_of_type_Auzb	Lauzb;
    //   148: lload_2
    //   149: aload 6
    //   151: aconst_null
    //   152: invokevirtual 1095	auzb:a	(JLjava/util/ArrayList;Ljava/lang/Object;)V
    //   155: goto -85 -> 70
    //   158: astore 7
    //   160: lconst_0
    //   161: lstore_2
    //   162: ldc_w 437
    //   165: iconst_1
    //   166: ldc_w 1097
    //   169: invokestatic 1099	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: lload_2
    //   173: lstore 4
    //   175: lconst_0
    //   176: lstore_2
    //   177: goto -44 -> 133
    //   180: aload_0
    //   181: getfield 381	afsv:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   184: invokevirtual 666	android/os/Handler:obtainMessage	()Landroid/os/Message;
    //   187: astore 6
    //   189: aload 6
    //   191: iconst_1
    //   192: putfield 671	android/os/Message:what	I
    //   195: aload 6
    //   197: aload_0
    //   198: getfield 102	afsv:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   201: invokevirtual 428	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   204: ldc_w 672
    //   207: invokevirtual 675	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   210: putfield 679	android/os/Message:obj	Ljava/lang/Object;
    //   213: aload_0
    //   214: getfield 381	afsv:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   217: aload 6
    //   219: invokevirtual 683	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   222: pop
    //   223: ldc_w 437
    //   226: iconst_1
    //   227: ldc_w 1101
    //   230: iconst_1
    //   231: anewarray 4	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: aload_0
    //   237: getfield 104	afsv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   240: aastore
    //   241: invokestatic 449	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   244: invokestatic 635	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: goto -177 -> 70
    //   250: astore 7
    //   252: lload 4
    //   254: lstore_2
    //   255: goto -93 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	afsv
    //   57	10	1	bool	boolean
    //   132	123	2	l1	long
    //   120	133	4	l2	long
    //   108	110	6	localObject	Object
    //   158	1	7	localNumberFormatException1	NumberFormatException
    //   250	1	7	localNumberFormatException2	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   110	122	158	java/lang/NumberFormatException
    //   122	133	250	java/lang/NumberFormatException
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
  
  public void d()
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
        ajhu.a(l1, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      localMessage.obj = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718971);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      QLog.d("intimate_relationship", 1, String.format("requestTroopListWithCommonFriends network is not available, uin: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IntimateContentItemBaseView)localIterator.next()).i();
    }
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onPause();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IntimateContentItemBaseView)localIterator.next()).h();
    }
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)
    {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onStart();
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onResume();
    }
  }
  
  public void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IntimateContentItemBaseView)localIterator.next()).k();
    }
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onStop();
    }
  }
  
  public void h()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IntimateContentItemBaseView)localIterator.next()).j();
    }
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onStart();
    }
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
      d((String)paramMessage.obj);
      return true;
    case 4: 
      t();
      return true;
    case 5: 
      t();
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131693318, 1).a();
      return true;
    case 6: 
      c();
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131693319, 1).a();
      return true;
    case 7: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Object[])))
      {
        paramMessage = (Object[])paramMessage.obj;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverEntranceView.a((String)paramMessage[0], (String)paramMessage[1], (String)paramMessage[2]);
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverEntranceView.m();
      return true;
    case 8: 
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverEntranceView.m();
      return true;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
    return true;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Auzh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = null;
    }
    if (this.jdField_a_of_type_Afsr != null) {
      this.jdField_a_of_type_Afsr.b();
    }
    if (this.jdField_a_of_type_Aglr != null)
    {
      this.jdField_a_of_type_Aglr.a();
      this.jdField_a_of_type_Aglr = null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IntimateContentItemBaseView)localIterator.next()).l();
    }
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)
    {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onDestroy();
      this.jdField_c_of_type_Boolean = true;
    }
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Axge != null) {
      this.jdField_a_of_type_Axge.a();
    }
    while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterScore = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore;
      ThreadManager.postImmediately(new IntimateInfoView.4(this), null, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onScoreUpdated: " + this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
    }
  }
  
  public void l()
  {
    m();
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverEntranceView.o();
  }
  
  public void n()
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
    } while (!this.i);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.loadMore(this);
    this.i = false;
  }
  
  public void o()
  {
    QLog.i("IntimateInfoView", 4, "onZoomOut: ");
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.scrollToHeadView();
    }
  }
  
  public void onClick(View paramView)
  {
    long l = SystemClock.elapsedRealtime();
    if ((this.jdField_a_of_type_JavaLangLong != null) && (l - this.jdField_a_of_type_JavaLangLong.longValue() < 500L)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(l);
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363329: 
        j();
        break;
      case 2131370887: 
        p();
      }
    }
  }
  
  public void onLoadOver(boolean paramBoolean)
  {
    QLog.i("IntimateInfoView", 4, "onLoadOver: " + paramBoolean);
    if ((this.jdField_c_of_type_AndroidViewView == null) || (this.jdField_a_of_type_CooperationQzoneApiFeedListView == null)) {
      return;
    }
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView.getFeedCnt() > 0)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsv
 * JD-Core Version:    0.7.0.1
 */