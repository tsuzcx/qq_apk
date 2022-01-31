import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.device.msg.activities.AIODevLittleVideoData;
import com.tencent.image.NativeVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.VideoDrawable;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.GalleryImageStruct;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.13;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.18;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.19;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.2;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.24;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.25;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.28;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.3;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.4;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.5;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.AdapterView;
import com.tencent.widget.DragView;
import com.tencent.widget.Gallery;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.os.MqqHandler;

public class agdi
  extends zdy
  implements agdh, aikb, ails, ailu, View.OnClickListener, SeekBar.OnSeekBarChangeListener, bhqg, INetInfoHandler
{
  final int jdField_a_of_type_Int = -3321;
  long jdField_a_of_type_Long = 0L;
  ageh jdField_a_of_type_Ageh;
  protected agei a;
  public ages a;
  public agft a;
  public ailt a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new agea(this);
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public SeekBar a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private anoe jdField_a_of_type_Anoe;
  azey jdField_a_of_type_Azey;
  bepe jdField_a_of_type_Bepe;
  betz jdField_a_of_type_Betz;
  public AIOGalleryAdapter a;
  AIORichMediaData jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
  public ShareActionSheetBuilder a;
  DragView jdField_a_of_type_ComTencentWidgetDragView;
  public final Runnable a;
  String jdField_a_of_type_JavaLangString;
  public final MqqHandler a;
  boolean jdField_a_of_type_Boolean = false;
  ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public SeekBar b;
  public TextView b;
  public final Runnable b;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  ImageButton jdField_c_of_type_AndroidWidgetImageButton;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  public TextView c;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  final int jdField_d_of_type_Int = -2147483648;
  ImageButton jdField_d_of_type_AndroidWidgetImageButton;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int;
  public TextView e;
  String jdField_e_of_type_JavaLangString;
  boolean jdField_e_of_type_Boolean = false;
  int jdField_f_of_type_Int = 1;
  String jdField_f_of_type_JavaLangString;
  int jdField_g_of_type_Int;
  public String g;
  boolean jdField_g_of_type_Boolean = false;
  public int h;
  private String jdField_h_of_type_JavaLangString;
  boolean jdField_h_of_type_Boolean;
  public int i;
  boolean i;
  int jdField_j_of_type_Int = 0;
  boolean jdField_j_of_type_Boolean;
  public int k;
  boolean k;
  int jdField_l_of_type_Int;
  boolean jdField_l_of_type_Boolean = false;
  int jdField_m_of_type_Int;
  boolean jdField_m_of_type_Boolean;
  private int n;
  public boolean n;
  boolean o = false;
  boolean p = false;
  public boolean q;
  boolean r = true;
  public boolean s;
  boolean t = false;
  boolean u;
  
  public agdi(Activity paramActivity, zec paramzec, agft paramagft, String paramString)
  {
    super(paramActivity, paramzec);
    this.jdField_i_of_type_Boolean = false;
    this.jdField_i_of_type_Int = 5;
    this.jdField_k_of_type_Int = -1;
    this.jdField_a_of_type_Ailt = new ailv();
    this.jdField_a_of_type_Agei = new agei(this);
    this.jdField_a_of_type_JavaLangRunnable = new AIOGalleryScene.2(this);
    this.jdField_b_of_type_JavaLangRunnable = new AIOGalleryScene.3(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new ageb(this);
    this.jdField_a_of_type_Ages = ((ages)paramzec);
    this.jdField_a_of_type_Agft = paramagft;
    ((ailv)this.jdField_a_of_type_Ailt).a(paramagft);
    this.jdField_b_of_type_JavaLangString = paramString;
    if ((paramString == null) && (PeakActivity.class.isInstance(paramActivity))) {
      this.jdField_b_of_type_JavaLangString = bllv.a().getCurrentAccountUin();
    }
    paramzec = (PeakAppInterface)((PeakActivity)paramActivity).getAppRuntime();
    if (paramzec != null) {
      ((also)paramzec.a(2)).a(paramActivity);
    }
  }
  
  private void F()
  {
    this.jdField_c_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_c_of_type_AndroidWidgetImageButton.setContentDescription(alpo.a(2131700401));
    this.jdField_c_of_type_AndroidWidgetImageButton.setId(2131373457);
    this.jdField_c_of_type_AndroidWidgetImageButton.setImageResource(2130845719);
    this.jdField_c_of_type_AndroidWidgetImageButton.setBackgroundDrawable(null);
    this.jdField_c_of_type_AndroidWidgetImageButton.setPadding(32, 12, 32, 12);
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.topMargin = ((int)TypedValue.applyDimension(1, 10.0F, (DisplayMetrics)localObject));
    localLayoutParams.leftMargin = ((int)TypedValue.applyDimension(1, 24.0F, (DisplayMetrics)localObject));
    localObject = (AIORichMediaData)this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras().getParcelable("extra.EXTRA_CURRENT_IMAGE");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetImageButton, localLayoutParams);
    this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    a(false);
  }
  
  private void G()
  {
    Object localObject = "";
    Activity localActivity;
    int i1;
    switch (this.jdField_g_of_type_Int)
    {
    default: 
      localActivity = this.jdField_a_of_type_AndroidAppActivity;
      i1 = this.jdField_g_of_type_Int;
      if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
        break;
      }
    }
    for (String str = this.jdField_c_of_type_JavaLangString;; str = this.jdField_h_of_type_JavaLangString)
    {
      MiniChatActivity.a(localActivity, i1, (String)localObject, str);
      return;
      localObject = this.jdField_c_of_type_JavaLangString;
      break;
      str = this.jdField_d_of_type_JavaLangString;
      localObject = str;
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      localObject = this.jdField_c_of_type_JavaLangString;
      break;
      str = this.jdField_d_of_type_JavaLangString;
      localObject = str;
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      localObject = this.jdField_c_of_type_JavaLangString;
      break;
    }
  }
  
  private void H()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    int i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
    int i3 = this.jdField_a_of_type_Ages.b();
    if ((i3 >= i1) && (i3 <= i2 + i1 - 1))
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i3 - i1);
      if ((AIOGalleryAdapter.GalleryImageStruct.class.isInstance(localObject)) && ((((AIOGalleryAdapter.GalleryImageStruct)localObject).a() instanceof URLDrawable)))
      {
        localObject = ((URLDrawable)((AIOGalleryAdapter.GalleryImageStruct)localObject).a()).getCurrDrawable();
        if ((localObject != null) && ((localObject instanceof VideoDrawable))) {
          ((VideoDrawable)localObject).resetAndPlayAudioCircle();
        }
      }
    }
  }
  
  private int a()
  {
    Object localObject = this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if (localObject != null)
    {
      if ((localObject instanceof AIOFilePicData)) {
        return 2;
      }
      if ((localObject instanceof AIOImageData))
      {
        if (!((AIOImageData)localObject).jdField_h_of_type_Boolean) {
          return 1;
        }
        return 5;
      }
      if ((localObject instanceof AIOShortVideoData))
      {
        localObject = (AIOShortVideoData)localObject;
        if (((AIOShortVideoData)localObject).jdField_b_of_type_Int == 0) {
          return 4;
        }
        if (((AIOShortVideoData)localObject).jdField_b_of_type_Int == 1) {
          return 3;
        }
      }
      else if ((localObject instanceof AIOFileVideoData))
      {
        return 5;
      }
    }
    return -1;
  }
  
  private int a(String paramString)
  {
    int i1 = 4;
    switch (this.jdField_k_of_type_Int)
    {
    case 4: 
    default: 
      i1 = -1;
    case 1: 
    case 3: 
    case 2: 
      do
      {
        do
        {
          return i1;
          return 1;
        } while ("0X8009EFC".equals(paramString));
        if (!"0X8009EFD".equals(paramString)) {
          break;
        }
        return -1;
        if ("0X8009EFC".equals(paramString)) {
          return 5;
        }
      } while ("0X8009EFD".equals(paramString));
    }
    do
    {
      return -1;
      if ("0X8009EFC".equals(paramString)) {
        return 6;
      }
    } while (!"0X8009EFD".equals(paramString));
    return 5;
  }
  
  private <T extends agfq> T a(long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.jdField_a_of_type_Ages.a().iterator();
    while (localIterator.hasNext())
    {
      agfq localagfq = (agfq)localIterator.next();
      if ((localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramLong1) && (localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int == paramLong2)) {
        return localagfq;
      }
    }
    return null;
  }
  
  private bepe a(Context paramContext)
  {
    bepe localbepe = new bepe(paramContext);
    localbepe.a(aekt.a(50.0F, paramContext.getResources()));
    localbepe.a(true);
    localbepe.c(false);
    localbepe.f(-1);
    localbepe.e(0);
    localbepe.d(-15550475);
    localbepe.g(3);
    localbepe.jdField_f_of_type_Boolean = true;
    localbepe.jdField_f_of_type_Int = 2;
    localbepe.e(true);
    localbepe.a(new agdw(this));
    return localbepe;
  }
  
  private AIOGalleryAdapter.GalleryImageStruct a()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    int i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
    int i3 = this.jdField_a_of_type_Ages.b();
    if ((i3 >= i1) && (i3 <= i2 + i1 - 1))
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i3 - i1);
      if ((localView instanceof AIOGalleryAdapter.GalleryImageStruct)) {
        return (AIOGalleryAdapter.GalleryImageStruct)localView;
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_AndroidAppActivity.getString(paramInt1);
    localActionSheetItem.icon = paramInt2;
    localActionSheetItem.action = paramInt3;
    localActionSheetItem.argus = paramString;
    paramArrayList.add(localActionSheetItem);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_AndroidAppActivity.getString(paramInt1);
    localActionSheetItem.icon = paramInt2;
    localActionSheetItem.action = paramInt3;
    localActionSheetItem.argus = "";
    paramArrayList.add(localActionSheetItem);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList, int paramInt4)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_AndroidAppActivity.getString(paramInt1);
    localActionSheetItem.icon = paramInt2;
    localActionSheetItem.action = paramInt3;
    localActionSheetItem.argus = "";
    localActionSheetItem.firstLineCount = paramInt4;
    paramArrayList.add(localActionSheetItem);
  }
  
  private void a(int paramInt, File paramFile)
  {
    Object localObject1;
    switch (paramInt)
    {
    default: 
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 != null) {
        azmj.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
      }
      localObject1 = (PeakActivity)this.jdField_a_of_type_AndroidAppActivity;
      if (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "save video failed, intent is null");
      }
      QQToast.a((Context)localObject1, 1, alpo.a(2131700420), 0).a();
      return;
      localObject1 = "0X8007A24";
      continue;
      localObject1 = "0X8007A25";
    }
    NativeVideoImage.pauseAll();
    paramInt = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
    int i2 = this.jdField_a_of_type_Ages.b();
    if ((i2 >= paramInt) && (i2 <= i1 + paramInt - 1))
    {
      localObject2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i2 - paramInt);
      if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(localObject2)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(i2, (AIOGalleryAdapter.GalleryImageStruct)localObject2);
      }
    }
    Object localObject2 = ShortVideoUtils.c();
    a((Activity)localObject1, alpo.a(2131700419), false, 0);
    if (xmx.a(BaseApplication.getContext(), paramFile.getAbsolutePath(), (String)localObject2)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(10000);
    }
    for (;;)
    {
      azmj.b(null, "CliOper", "", "", "0X800610F", "0X800610F", 0, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(10001);
    }
  }
  
  private void a(agfq paramagfq)
  {
    if (paramagfq == null) {}
    do
    {
      return;
      if (AIOShortVideoData.class.isInstance(paramagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        AIOShortVideoData localAIOShortVideoData = (AIOShortVideoData)paramagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (localAIOShortVideoData.jdField_b_of_type_Int == 0)
        {
          paramagfq.jdField_a_of_type_Agfr.jdField_h_of_type_Boolean = false;
          paramagfq.jdField_a_of_type_Agfr.jdField_d_of_type_Boolean = false;
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
          paramagfq.jdField_a_of_type_Agfr.jdField_g_of_type_Boolean = false;
          return;
          this.jdField_d_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(localAIOShortVideoData.jdField_a_of_type_Int * 1000));
          paramagfq.jdField_a_of_type_Agfr.jdField_i_of_type_Boolean = false;
        }
      }
      if ((paramagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData))
      {
        this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
        paramagfq.jdField_a_of_type_Agfr.jdField_g_of_type_Boolean = false;
        return;
      }
    } while (this.jdField_a_of_type_MqqOsMqqHandler == null);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    if (paramActivity == null) {
      return;
    }
    long l1;
    Bundle localBundle;
    Intent localIntent;
    label185:
    int i1;
    boolean bool1;
    label213:
    boolean bool3;
    if ((paramInt2 == 1) || (paramInt2 == 3000))
    {
      l1 = paramLong2;
      localObject = paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "jumpToTargetAIOPosition, className = " + (String)localObject + ", time = " + paramLong1 + " , shmsgseq = " + paramLong2 + ", isEmotion = " + paramBoolean);
      }
      localBundle = new Bundle();
      localBundle.putBoolean("need_jump_to_msg", true);
      localBundle.putLong("searched_timeorseq", l1);
      localBundle.putLong("searched_time", paramLong1);
      localBundle.putLong("target_shmsgseq", paramLong2);
      localBundle.putBoolean("searched_update_session", true);
      localIntent = new Intent();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label396;
      }
      localIntent.setClassName(paramActivity, (String)localObject);
      i1 = paramActivity.getIntent().getIntExtra("extra.EXTRA_ENTRANCE", -1);
      if ((i1 != 2) && (i1 != 3)) {
        break label409;
      }
      bool1 = true;
      bool3 = paramActivity.getIntent().getBooleanExtra("from_chat_history", false);
      if (!paramBoolean) {
        break label415;
      }
    }
    label396:
    label409:
    label415:
    for (boolean bool2 = bool3;; bool2 = bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "jumpToTargetAIOPosition, isFromHistory = " + bool2 + ", isEmotion = " + paramBoolean + ", sourceEntrance = " + i1 + ", fromHistory_picAndVideo = " + bool1 + ", fromHistory_emotion = " + bool3);
      }
      if (!bool2) {
        break label458;
      }
      paramInt1 = paramActivity.getIntent().getIntExtra("FromChatHistoryTab", 0);
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "jumpToTargetAIOPosition, fromType = " + paramInt1);
      }
      if ((paramInt1 != 2) && (paramInt1 != 4)) {
        break label438;
      }
      if (paramInt2 != 1) {
        break label422;
      }
      ChatHistoryBubbleListForTroopFragment.a(paramActivity, paramString2, paramLong2, -1, 0);
      return;
      l1 = paramLong1;
      break;
      localIntent.setClass(paramActivity, SplashActivity.class);
      break label185;
      bool1 = false;
      break label213;
    }
    label422:
    ChatHistoryActivity.a(paramActivity, paramString1, paramInt2, "", paramLong1, paramLong2, 0);
    return;
    label438:
    localIntent.putExtras(localBundle);
    paramActivity.setResult(-1, localIntent);
    paramActivity.finish();
    return;
    label458:
    Object localObject = aekt.a(localIntent, null);
    ((Intent)localObject).putExtras(localBundle);
    ((Intent)localObject).putExtra("uin", paramString1);
    ((Intent)localObject).putExtra("uintype", paramInt1);
    ((Intent)localObject).putExtra("troop_uin", paramString2);
    ((Intent)localObject).addFlags(603979776);
    ((Intent)localObject).putExtra("entrance", 1);
    paramActivity.startActivity((Intent)localObject);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = aekt.a(new Intent(paramActivity, SplashActivity.class), null);
    paramBundle = new Bundle(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "AIOGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
    }
    paramBundle.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    paramBundle.putBoolean("PhotoConst.IS_FORWARD", true);
    paramBundle.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    paramBundle.putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtras(paramBundle);
    String str = paramBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(str);
    PhotoUtils.a(paramActivity, localIntent, localArrayList, paramBundle.getInt("PhotoConst.SEND_SIZE_SPEC", 0), true);
  }
  
  private void a(Dialog paramDialog)
  {
    if ((paramDialog != null) && (this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AIOGalleryScene", 2, "showDialogSafe exception: " + paramDialog.getMessage());
    }
  }
  
  private void a(Uri paramUri, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      return;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
    SparseArray localSparseArray = new SparseArray(2);
    Object localObject1 = null;
    int i2;
    int i1;
    label92:
    Rect localRect;
    if ((localObject3 instanceof AIOGalleryAdapter.GalleryImageStruct))
    {
      localObject1 = (AIOGalleryAdapter.GalleryImageStruct)localObject3;
      i2 = ((AIOGalleryAdapter.GalleryImageStruct)localObject1).getWidth();
      int i3 = ((AIOGalleryAdapter.GalleryImageStruct)localObject1).getHeight();
      if (i2 >= i3 * 2)
      {
        i1 = 1;
        if (i3 < i2 * 2) {
          break label321;
        }
        i2 = 1;
        if ((i1 == 0) && (i2 == 0)) {
          break label349;
        }
        localObject3 = new Matrix();
        ((Matrix)localObject3).set(this.jdField_a_of_type_ComTencentWidgetGallery.a((View)localObject1));
        localRect = new Rect(((AIOGalleryAdapter.GalleryImageStruct)localObject1).getLeft(), ((AIOGalleryAdapter.GalleryImageStruct)localObject1).getTop(), ((AIOGalleryAdapter.GalleryImageStruct)localObject1).getRight(), ((AIOGalleryAdapter.GalleryImageStruct)localObject1).getBottom());
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((AIOGalleryAdapter.GalleryImageStruct)localObject1).a(localRect, (Matrix)localObject3, this.jdField_a_of_type_ComTencentWidgetGallery.getWidth(), this.jdField_a_of_type_ComTencentWidgetGallery.getHeight());
        if (localObject1 == null) {
          break label355;
        }
        i1 = xwb.a((Bitmap)localObject1, true, 3, localSparseArray) | 0x0;
        if (QLog.isColorLevel()) {
          QLog.i("AIOGalleryScene", 2, String.format("checkQQCode bmp!=null result=%d", new Object[] { Integer.valueOf(i1) }));
        }
        if (localObject1 == null)
        {
          i2 = xwb.a(paramUri, this.jdField_a_of_type_AndroidAppActivity, 3, localSparseArray);
          i1 = i2;
          if (QLog.isColorLevel())
          {
            QLog.i("AIOGalleryScene", 2, String.format("checkQQCode bmp=null result=%d", new Object[] { Integer.valueOf(i2) }));
            i1 = i2;
          }
        }
        ThreadManager.getUIHandler().post(new AIOGalleryScene.19(this, i1, localSparseArray, paramArrayList));
        if (i1 > 0) {
          this.jdField_f_of_type_JavaLangString = paramUri.getPath();
        }
        anak.b(i1);
        return;
      }
      catch (Throwable localThrowable)
      {
        label321:
        if (!QLog.isColorLevel()) {
          break label349;
        }
        QLog.i("AIOGalleryScene", 2, localThrowable.getMessage(), localThrowable);
      }
      i1 = 0;
      break;
      i2 = 0;
      break label92;
      label349:
      Object localObject2 = null;
      continue;
      label355:
      i1 = 0;
      continue;
      i1 = 0;
    }
  }
  
  private void a(AIOFileVideoData paramAIOFileVideoData, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(2131692991, 2130839735, 59, localArrayList1);
    a(2131693000, 2130839744, 53, localArrayList1);
    azmj.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
    a(2131692993, 2130843845, 67, localArrayList1);
    a(2131693002, 2130839745, 58, localArrayList1);
    a(2131692990, 2130839734, 57, localArrayList1);
    if ((this.jdField_g_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.r)) {
      a(2131693004, 2130839746, 54, localArrayList2);
    }
    if (arof.b(paramAIOFileVideoData.jdField_c_of_type_JavaLangString)) {
      a(2131692997, 2130839740, 64, localArrayList2, 5);
    }
    a(paramAIOFileVideoData, null, false);
    paramAIOFileVideoData = (List[])new ArrayList[] { localArrayList1, localArrayList2 };
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(paramAIOFileVideoData);
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
  }
  
  private void a(AIOImageData paramAIOImageData, agfq paramagfq)
  {
    if (paramAIOImageData != null)
    {
      this.jdField_a_of_type_Ageh = new ageh(this);
      this.jdField_a_of_type_Ageh.jdField_a_of_type_Long = paramAIOImageData.jdField_f_of_type_Long;
      this.jdField_a_of_type_Ageh.jdField_a_of_type_Int = paramAIOImageData.jdField_f_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "dealSaveOriginalImage");
      }
      this.jdField_a_of_type_Agft.a(this.jdField_a_of_type_Ageh.jdField_a_of_type_Long, this.jdField_a_of_type_Ageh.jdField_a_of_type_Int, 24);
    }
  }
  
  private void a(AIOImageData paramAIOImageData, agfq paramagfq, File paramFile)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(new agee(this, paramAIOImageData, paramagfq, paramFile));
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setCancelListener(new agdk(this));
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, File paramFile, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(2131692991, 2130839735, 59, localArrayList1);
    if ((PicShareToWX.a().a()) && (PicShareToWX.a().a(paramFile))) {
      a(2131693001, 2130846285, 69, localArrayList1);
    }
    a(2131693000, 2130839744, 53, localArrayList1);
    azmj.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
    a(2131692993, 2130843845, 67, localArrayList1);
    a(2131693002, 2130839745, 58, localArrayList1);
    a(2131692990, 2130839734, 57, localArrayList1);
    if ((this.jdField_g_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.r)) {
      a(2131693004, 2130839746, 54, localArrayList2);
    }
    if (this.jdField_g_of_type_Boolean) {
      a(2131692996, 2130839739, 52, localArrayList2, 2);
    }
    ThreadManager.getFileThreadHandler().post(new AIOGalleryScene.18(this, paramFile, localArrayList2));
    a(paramAIORichMediaData, paramFile, true);
    paramAIORichMediaData = (List[])new ArrayList[] { localArrayList1, localArrayList2 };
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(paramAIORichMediaData);
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, File paramFile, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(new agdr(this, paramAIORichMediaData, paramBoolean, paramFile));
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, int paramInt)
  {
    File localFile = paramAIOShortVideoData.a(1);
    agfq localagfq = this.jdField_a_of_type_Ages.a();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i1 = 0;
    if ((localFile != null) && (localFile.exists()))
    {
      long l1 = localFile.length();
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "showActionSheetForShortVideo, file.getPath()=" + localFile.getPath() + ", mTransferredSize = " + l1 + ", data.size = " + paramAIOShortVideoData.h);
      }
      if (l1 >= paramAIOShortVideoData.h) {}
    }
    for (i1 = 1;; i1 = 1)
    {
      if ((paramAIOShortVideoData.jdField_b_of_type_Int != 1) || (i1 == 0)) {
        a(2131692991, 2130839735, 59, localArrayList1);
      }
      if ((bhou.d()) && ((paramAIOShortVideoData.jdField_b_of_type_Int != 1) || (i1 == 0))) {
        a(2131693000, 2130839744, 61, localArrayList1);
      }
      if (i1 == 0)
      {
        a(2131692990, 2130839734, 63, localArrayList1);
        a(2131692994, 2130839737, 60, localArrayList1);
        a(2131693002, 2130839745, 58, localArrayList1);
      }
      if ((this.jdField_g_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.r)) {
        a(2131693004, 2130839746, 62, localArrayList2);
      }
      if (i1 == 0) {
        a(2131692997, 2130839740, 64, localArrayList2, 5);
      }
      a(paramAIOShortVideoData, localFile, paramInt, localagfq);
      paramAIOShortVideoData = (List[])new ArrayList[] { localArrayList1, localArrayList2 };
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(paramAIOShortVideoData);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
      }
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, agfq paramagfq)
  {
    if (paramAIOShortVideoData != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "dealSaveVideo");
      }
      this.jdField_a_of_type_Agft.a(paramAIOShortVideoData.jdField_f_of_type_Long, paramAIOShortVideoData.jdField_f_of_type_Int, 256);
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, agfq paramagfq)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(new agdo(this, paramAIOShortVideoData, paramFile, paramInt, paramagfq));
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setCancelListener(new agdp(this));
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      agfq localagfq = this.jdField_a_of_type_Ages.a();
      if ((localagfq != null) && ((localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a((AIOShortVideoData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData) != null))
        {
          this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(0);
          return true;
        }
      }
      else if ((localagfq != null) && ((localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData)) && (xmx.c(((AIOFileVideoData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_c_of_type_JavaLangString)))
      {
        this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(0);
        return true;
      }
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    return false;
  }
  
  private int b()
  {
    switch (this.jdField_g_of_type_Int)
    {
    default: 
      return 4;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  private void b(agfq paramagfq)
  {
    AIOImageData localAIOImageData = (AIOImageData)paramagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    File localFile = localAIOImageData.a(4);
    if (localFile == null) {
      localFile = localAIOImageData.a(2);
    }
    for (;;)
    {
      if ((localFile == null) && (this.t)) {
        return;
      }
      if (localFile != null) {
        this.jdField_g_of_type_JavaLangString = localFile.getPath();
      }
      Object localObject = bhpy.c(this.jdField_a_of_type_AndroidAppActivity);
      if ((!a((bhpy)localObject, localAIOImageData)) && (abot.a(this.jdField_g_of_type_Int) != 1032))
      {
        localObject = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        if (localFile != null) {
          if (!this.jdField_c_of_type_Boolean)
          {
            if (this.jdField_h_of_type_Boolean)
            {
              a(2131692988, 2130839730, 48, (ArrayList)localObject);
              VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickMore", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
            }
            if ((this.jdField_g_of_type_Int != 1037) && (abot.a(this.jdField_g_of_type_Int) != 1044)) {
              a(2131692991, 2130839735, 49, (ArrayList)localObject);
            }
            if ((PicShareToWX.a().a()) && (PicShareToWX.a().a(localFile))) {
              a(2131693001, 2130846285, 69, (ArrayList)localObject);
            }
            if (!asmt.a().a()) {
              a(2131693000, 2130839744, 53, (ArrayList)localObject);
            }
            if (!this.jdField_h_of_type_Boolean) {
              a(2131692990, 2130839734, 57, (ArrayList)localObject);
            }
            if ((this.jdField_g_of_type_Int != 1037) && (abot.a(this.jdField_g_of_type_Int) != 1044))
            {
              if (localAIOImageData.jdField_e_of_type_JavaLangString != null) {
                a(2131692995, 2130839738, 50, (ArrayList)localObject, 3);
              }
              if ((this.jdField_i_of_type_Boolean) && (localAIOImageData.jdField_e_of_type_JavaLangString != null)) {
                a(2131692992, 2130839736, 51, (ArrayList)localObject, 3);
              }
            }
            a(2131693002, 2130839745, 58, (ArrayList)localObject);
            if ((this.jdField_g_of_type_Int != 1037) && (abot.a(this.jdField_g_of_type_Int) != 1044))
            {
              if ((this.jdField_g_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.r)) {
                a(2131693004, 2130839746, 54, localArrayList, 3);
              }
              if (this.jdField_g_of_type_Boolean) {
                a(2131692996, 2130839739, 52, localArrayList, 2);
              }
              ThreadManager.getFileThreadHandler().post(new AIOGalleryScene.13(this, localFile, localArrayList));
            }
          }
        }
        for (;;)
        {
          if ((localAIOImageData.jdField_e_of_type_Int == 4) && (!localAIOImageData.jdField_i_of_type_Boolean)) {
            a(2131693494, 2130846147, 66, (ArrayList)localObject);
          }
          a(localAIOImageData, paramagfq, localFile);
          paramagfq = (List[])new ArrayList[] { localObject, localArrayList };
          this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(paramagfq);
          this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
          return;
          a(2131693485, 2130839735, 49, (ArrayList)localObject);
          a(2131693495, 2130839744, 53, (ArrayList)localObject);
          continue;
          if ((!this.jdField_c_of_type_Boolean) && (this.jdField_g_of_type_Int != 1037) && (abot.a(this.jdField_g_of_type_Int) != 1044) && (this.jdField_g_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.r)) {
            a(2131693004, 2130839746, 54, localArrayList, 3);
          }
        }
      }
      if ((abot.a(this.jdField_g_of_type_Int) == 1032) && (localFile != null)) {
        ((bhpy)localObject).b(2131693495);
      }
      ((bhpy)localObject).c(2131690648);
      ((bhpy)localObject).a(new agdn(this, (bhpy)localObject, localAIOImageData, localFile));
      ((bhpy)localObject).show();
      ((bhpy)localObject).a(this);
      return;
    }
  }
  
  public static void b(agfq paramagfq, Activity paramActivity, int paramInt)
  {
    if (!AIOImageData.class.isInstance(paramagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
      return;
    }
    AIOImageData localAIOImageData = (AIOImageData)paramagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    File localFile = localAIOImageData.a(4);
    if (localFile == null) {
      localFile = localAIOImageData.a(2);
    }
    for (int i1 = 0;; i1 = 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localAIOImageData.a(1));
      paramagfq = paramagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (i1 != 0) {}
      for (int i2 = 4;; i2 = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", paramagfq.a(i2));
        if (paramActivity.getIntent().getBooleanExtra("image_share_by_server", false))
        {
          paramagfq = Long.toString(paramActivity.getIntent().getLongExtra("appid", 0L));
          i2 = paramActivity.getIntent().getIntExtra("curType", 0);
          localBundle.putBoolean("key_forward_image_share", true);
          localBundle.putString("key_forward_image_share_appid", paramagfq);
          localBundle.putInt("key_forward_image_share_uin_type", i2);
        }
        if (localFile == null) {
          break;
        }
        try
        {
          localBundle.putString("GALLERY.FORWORD_LOCAL_PATH", localFile.getAbsolutePath());
          localBundle.putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
          if (i1 != 0) {
            localBundle.putInt("PhotoConst.SEND_SIZE_SPEC", 2);
          }
          localBundle.putParcelable("FORWARD_MSG_FOR_PIC", localAIOImageData);
          if (localAIOImageData.jdField_b_of_type_Int == 4) {
            localBundle.putBoolean("HOT_PIC_HAS_EXTRA", true);
          }
          paramagfq = new Intent();
          paramagfq.putExtras(localBundle);
          arum.a(paramActivity, paramagfq, paramInt);
          return;
        }
        catch (NullPointerException paramagfq) {}
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOGalleryScene", 2, "showFriendPickerForForward ,cache path is null");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOGalleryScene", 2, "showFriendPickerForForward ,NullPointerException: " + paramagfq);
      return;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561290, null);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    if (paramBoolean) {
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131373458);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localRelativeLayout.findViewById(2131371201));
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376271));
      localObject = (ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371442);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372319));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378166));
      ((ImageView)localObject).setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131379297));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131379299));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131379298));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131364326));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131363777));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localRelativeLayout.findViewById(2131375156));
      return;
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    }
  }
  
  public void A()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AIOGalleryScene.25(this), 1000L);
  }
  
  public void B()
  {
    this.jdField_n_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidAppDialog != null) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AIOGalleryScene", 2, localException, new Object[0]);
    }
  }
  
  void C()
  {
    for (;;)
    {
      AIORichMediaData localAIORichMediaData;
      Object localObject3;
      try
      {
        localAIORichMediaData = this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (((localAIORichMediaData instanceof AIOImageData)) || ((localAIORichMediaData instanceof AIOFilePicData)))
        {
          if ((localAIORichMediaData instanceof AIOImageData))
          {
            localObject3 = localAIORichMediaData.a(4);
            Object localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = localAIORichMediaData.a(2);
            }
            localObject3 = localObject1;
            if (localObject1 != null) {
              break label613;
            }
            localObject1 = localAIORichMediaData.a(1);
            if (localObject1 != null) {
              break label148;
            }
          }
        }
        else {
          return;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        localNullPointerException.printStackTrace();
        return;
      }
      Object localObject2;
      if ((localAIORichMediaData instanceof AIOFilePicData))
      {
        localObject3 = localAIORichMediaData.a(20);
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = localAIORichMediaData.a(18);
        }
        localObject3 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = localAIORichMediaData.a(16);
          continue;
          label148:
          this.jdField_g_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
          int i1 = 99;
          int i2;
          boolean bool;
          int i3;
          switch (this.jdField_k_of_type_Int)
          {
          default: 
            i2 = 0;
            bool = false;
            i3 = 0;
            localObject2 = EditPicActivity.a(this.jdField_a_of_type_AndroidAppActivity, ((File)localObject2).getAbsolutePath(), true, true, true, true, true, 2, i1, 7);
            ((Intent)localObject2).putExtra("uintype", this.jdField_g_of_type_Int);
            ((Intent)localObject2).putExtra("open_chatfragment", true);
            ((Intent)localObject2).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1041);
            ((Intent)localObject2).putExtra("key_enable_edit_title_bar", true);
            if (bool) {
              ((Intent)localObject2).putExtra("key_help_forward_pic", bool);
            }
            if (i2 != 0) {
              ((Intent)localObject2).putExtra("key_allow_multiple_forward_from_limit", false);
            }
            if ((localAIORichMediaData instanceof AIOFilePicData))
            {
              if (this.jdField_a_of_type_Agft.asBinder().pingBinder())
              {
                localObject3 = this.jdField_a_of_type_Agft.a(localAIORichMediaData.jdField_f_of_type_Long, localAIORichMediaData.jdField_f_of_type_Int, this.jdField_g_of_type_Int);
                if (localObject3 != null)
                {
                  ((Intent)localObject3).setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
                  localObject3 = (ForwardFileInfo)((Intent)localObject3).getParcelableExtra("fileinfo");
                  if (localObject3 != null) {
                    ((Intent)localObject2).putExtra("fileinfo", (Parcelable)localObject3);
                  }
                }
              }
              ((Intent)localObject2).putExtra("not_forward", true);
            }
            if (i3 != 0) {
              this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject2, i3);
            }
            break;
          }
          for (;;)
          {
            this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772036, 2130772038);
            azmj.b(null, "dc00898", "", "", "0X8007ACE", "0X8007ACE", 0, 0, "", "", "", "");
            return;
            azmj.b(null, "dc00898", "", "", "0X800A187", "0X800A187", 0, 0, "", "", "", "");
            i2 = 0;
            bool = true;
            i1 = 125;
            i3 = 19002;
            break;
            i1 = 126;
            i2 = 1;
            bool = true;
            i3 = 19000;
            break;
            i1 = 127;
            i2 = 1;
            bool = true;
            i3 = 19000;
            break;
            i1 = 128;
            i2 = 1;
            bool = true;
            i3 = 19000;
            break;
            i1 = 129;
            i2 = 1;
            bool = true;
            i3 = 19000;
            break;
            i1 = 130;
            i2 = 0;
            bool = true;
            i3 = 19000;
            break;
            this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
          }
        }
        else
        {
          label613:
          localObject2 = localObject3;
        }
      }
      else
      {
        localObject2 = null;
      }
    }
  }
  
  public void D()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a();
  }
  
  public void E()
  {
    if ((this.jdField_a_of_type_Ailt != null) && (this.jdField_a_of_type_Ailt.a != null) && (this.jdField_a_of_type_Ailt.a.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ailt.c()))
    {
      this.jdField_a_of_type_Ailt.d(2);
      Object localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131720109);
      localObject = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, (String)localObject, 2131694804, 2131721490, new agdy(this), new agdz(this));
      if (this.jdField_a_of_type_Ailt != null) {
        this.jdField_a_of_type_Ailt.h();
      }
      a((Dialog)localObject);
    }
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561139, null);
  }
  
  protected AbstractImageAdapter a(Context paramContext)
  {
    boolean bool1 = true;
    if (this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("extra.IS_FROM_CHAT_FILE_HISTORY", false)) {}
    for (int i1 = 1; this.jdField_e_of_type_Boolean; i1 = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter = new AIOGalleryAdapter(paramContext, this.jdField_a_of_type_Agft, true, i1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_a_of_type_Ailt);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.jdField_a_of_type_Agdc = new agdt(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_a_of_type_Ages);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.jdField_a_of_type_Boolean = this.q;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(new agdu(this));
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter;
    }
    boolean bool2 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras().getBoolean("is_one_item", false);
    if (this.jdField_k_of_type_Int == 4) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter = new AIOGalleryAdapter(paramContext, this.jdField_a_of_type_Agft, bool1, i1);
      break;
      bool1 = bool2;
    }
  }
  
  public void a()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
    Object localObject = (AIORichMediaData)localBundle.getParcelable("extra.EXTRA_CURRENT_IMAGE");
    if ((localObject instanceof AIOShortVideoData))
    {
      int i1 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("forward_source_uin_type", -1);
      if (i1 != -1) {
        ((AIOShortVideoData)localObject).jdField_g_of_type_Int = i1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData = ((AIORichMediaData)localObject);
    localObject = new agfq((AIORichMediaData)localObject);
    this.jdField_a_of_type_Ages.a((agfq)localObject);
    this.q = localBundle.getBoolean("muate_play");
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "initData , mIsMute = " + this.q);
    }
    ((agfq)localObject).jdField_b_of_type_AndroidGraphicsRect = ((Rect)localBundle.getParcelable("KEY_THUMBNAL_BOUND"));
    this.jdField_c_of_type_Int = localBundle.getInt("extra.AIO_CURRENT_PANEL_STATE", -3321);
    this.t = localBundle.getBoolean("IS_APP_SHARE_PIC", false);
    this.jdField_e_of_type_Int = localBundle.getInt("extra.MOBILE_QQ_PROCESS_ID", -2147483648);
    this.o = localBundle.getBoolean("extra.IS_HOT_CHAT", false);
    this.p = localBundle.getBoolean("extra.IS_SAVING_FILE", false);
    this.jdField_j_of_type_Int = localBundle.getInt("extra.SAVE_FILE_PROGRESS", 0);
    this.jdField_i_of_type_Boolean = localBundle.getBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", false);
    this.jdField_d_of_type_JavaLangString = localBundle.getString("extra.GROUP_UIN");
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_e_of_type_JavaLangString = localBundle.getString("extra.GROUP_CODE");
      if (((this.jdField_d_of_type_JavaLangString == null) || (this.jdField_e_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString == null)) && (QLog.isColorLevel())) {
        QLog.i("AIOGalleryScene", 2, "mGroupUin=" + this.jdField_d_of_type_JavaLangString + ", mGroupCode=" + this.jdField_e_of_type_JavaLangString + ", mMyUin=" + this.jdField_b_of_type_JavaLangString);
      }
    }
    this.jdField_f_of_type_Int = localBundle.getInt("extra.EXTRA_FORWARD_TO_QZONE_SRC");
    this.jdField_e_of_type_Boolean = localBundle.getBoolean("extra.IS_APOLLO");
    this.jdField_c_of_type_Boolean = localBundle.getBoolean("extra.IS_FROM_MULTI_MSG");
    this.jdField_a_of_type_Long = localBundle.getLong("key_multi_forward_seq", 0L);
    this.jdField_d_of_type_Boolean = localBundle.getBoolean("extra.IS_RECEIPT_MSG");
    this.jdField_g_of_type_Int = localBundle.getInt("forward_source_uin_type", -1);
    this.jdField_c_of_type_JavaLangString = localBundle.getString("uin");
    this.jdField_j_of_type_Boolean = localBundle.getBoolean("extra.IS_FROM_CHAT_FILE_HISTORY", false);
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_a_of_type_Ages.a(true);
      this.jdField_k_of_type_Boolean = true;
      if (!TextUtils.isEmpty(localBundle.getString("babyq_video_type"))) {
        break label570;
      }
    }
    label570:
    for (boolean bool = false;; bool = true)
    {
      this.jdField_m_of_type_Boolean = bool;
      this.jdField_g_of_type_Boolean = localBundle.getBoolean("extra.OCR", false);
      this.jdField_a_of_type_JavaLangString = localBundle.getString("extra.OCR_TEXT");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131693491);
      }
      this.jdField_h_of_type_Boolean = localBundle.getBoolean("group.emo.big.preview", false);
      this.jdField_k_of_type_Int = localBundle.getInt("extra.EXTRA_ENTRANCE");
      this.r = localBundle.getBoolean("is_ReplyMsg_From_Same_Session", true);
      return;
      ((agfq)localObject).jdField_c_of_type_Boolean = false;
      break;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_Agei.jdField_a_of_type_Boolean = true;
    u();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 0))
    {
      a(this.jdField_a_of_type_AndroidAppActivity, paramIntent.getExtras());
      if (this.jdField_g_of_type_Int == 9501) {
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
    }
    do
    {
      return;
      if ((paramInt2 == -1) && (paramInt1 == 10001))
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131720103, 0).a();
        return;
      }
    } while ((paramInt1 != 10002) || (this.jdField_a_of_type_Azey == null));
    this.jdField_a_of_type_Azey.a(paramInt2);
  }
  
  public void a(int paramInt1, View paramView, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "carverW notifyVideoUrl setShortVideoDrawableWithUrls ,position = " + paramInt1);
    }
    agfq localagfq = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt1);
    if (localagfq == null) {}
    for (;;)
    {
      return;
      if (AIOShortVideoData.class.isInstance(localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "carverW notifyVideoUrl setShortVideoDrawableWithUrls ,AIOShortVideoData id=" + localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
        }
        aggc.a().a(localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, paramArrayOfString, System.currentTimeMillis(), paramMessageForShortVideo, paramInt2, paramString2);
        paramString1 = new ailz();
        paramString1.jdField_a_of_type_Boolean = true;
        paramString1.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
        paramString1.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
        paramString1.jdField_a_of_type_Int = paramInt2;
        paramString1.jdField_a_of_type_Long = localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long;
        paramString1.jdField_b_of_type_Int = localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int;
        paramArrayOfString = new File(((AIOShortVideoData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
        if (paramArrayOfString.exists())
        {
          paramString1.d = paramArrayOfString.length();
          if (this.q)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AIOGalleryScene", 2, "setShortVideoDrawableWithUrls, dataOfBubble.id =  " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long + ", msg.uniseq = " + paramMessageForShortVideo.uniseq + ", mIsmute = " + this.q);
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramMessageForShortVideo.uniseq))
            {
              paramString1.jdField_e_of_type_Boolean = true;
              if (QLog.isColorLevel()) {
                QLog.d("AIOGalleryScene", 2, "setShortVideoDrawableWithUrls, set playMedioInfo.isMute =  " + this.q);
              }
            }
          }
          this.jdField_a_of_type_Ailt.a(paramView, paramString1);
          paramView = (AIOShortVideoData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(((AIOShortVideoData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_a_of_type_Long)) {
            break label481;
          }
          this.jdField_a_of_type_Ailt.f();
          this.jdField_a_of_type_Ailt.a((AIOShortVideoData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, false, false);
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_Agft == null) || (paramView.a(0) != null)) {
            break label499;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AIOGalleryScene", 2, "setShortVideoDrawableWithUrls, get THUMB");
          }
          this.jdField_a_of_type_Agft.a(paramView.jdField_f_of_type_Long, paramView.jdField_f_of_type_Int, 0);
          return;
          paramString1.d = 0L;
          break;
          label481:
          this.jdField_a_of_type_Ailt.a((AIOShortVideoData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, false, true);
        }
      }
      else
      {
        label499:
        if (AIOFileVideoData.class.isInstance(localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          paramMessageForShortVideo = (AIOFileVideoData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          if (paramMessageForShortVideo.jdField_a_of_type_Boolean)
          {
            QLog.i("VideoPlayControllerForFile", 1, "filevideo is playing:" + localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
            return;
          }
          paramMessageForShortVideo.jdField_a_of_type_Boolean = true;
          if ("I:E".equals(paramString1)) {
            try
            {
              paramMessageForShortVideo.jdField_b_of_type_Long = Long.parseLong(paramArrayOfString[0]);
              paramString2 = paramArrayOfString[1];
              paramMessageForShortVideo.a(paramString2);
              paramInt1 = 0;
              if (paramMessageForShortVideo.jdField_b_of_type_Long == -134L)
              {
                paramString1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131720126);
                paramInt1 = 1;
                label636:
                if (paramInt1 != 0)
                {
                  paramString1 = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230, "", paramString1, null, alpo.a(2131700414), new agdx(this), null);
                  if (paramString1.isShowing()) {
                    continue;
                  }
                  paramString1.show();
                  return;
                }
              }
            }
            catch (NumberFormatException paramString1)
            {
              paramMessageForShortVideo.jdField_b_of_type_Long = -1L;
              paramMessageForShortVideo.jdField_g_of_type_JavaLangString = paramArrayOfString[1];
            }
          }
        }
      }
    }
    for (;;)
    {
      paramString1 = paramMessageForShortVideo.a(this.q);
      this.jdField_a_of_type_Ailt.a(paramView, paramString1);
      if ((!AIOGalleryActivity.class.isInstance(this.jdField_a_of_type_AndroidAppActivity)) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramMessageForShortVideo.jdField_f_of_type_Long))) {
        break;
      }
      ((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_Ailt.b();
      this.jdField_a_of_type_Ailt.f();
      this.q = false;
      return;
      if (paramMessageForShortVideo.jdField_b_of_type_Long != -7003L)
      {
        long l1 = paramMessageForShortVideo.jdField_b_of_type_Long;
        paramString1 = paramString2;
        if (l1 != -6101L) {
          break label636;
        }
      }
      paramInt1 = 1;
      paramString1 = paramString2;
      break label636;
      paramMessageForShortVideo.jdField_d_of_type_JavaLangString = paramArrayOfString[0];
      paramMessageForShortVideo.jdField_f_of_type_JavaLangString = paramString1;
      paramMessageForShortVideo.jdField_e_of_type_JavaLangString = paramString2;
    }
  }
  
  public void a(int paramInt, Object paramObject, agfq paramagfq)
  {
    a(bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131719312), this.jdField_a_of_type_AndroidAppActivity.getString(2131719311), new agdl(this, paramInt, paramObject, paramagfq), new agdm(this)));
  }
  
  public void a(long paramLong)
  {
    boolean bool = true;
    int i1;
    if ((this.jdField_a_of_type_Zep != null) && (this.jdField_a_of_type_Zep.a() == this))
    {
      i1 = 1;
      if (i1 != 0) {
        break label49;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "onRevokeMsg not currentScene!");
      }
    }
    label49:
    agfq localagfq;
    do
    {
      return;
      i1 = 0;
      break;
      localagfq = this.jdField_a_of_type_Ages.a();
      if ((localagfq != null) && (localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null)) {
        break label88;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AIOGalleryScene", 2, "onRevokeMsg exp!");
    return;
    label88:
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "onRevokeMsg seq:" + paramLong + ", selectItem seq:" + localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long + ", isFromMultiMsg:" + this.jdField_c_of_type_Boolean + ", OriSeq:" + this.jdField_a_of_type_Long);
      }
      if ((this.jdField_a_of_type_Agft != null) && (!bool)) {
        this.jdField_a_of_type_Agft.a(paramLong);
      }
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOGalleryScene.28(this, paramLong, localagfq, bool));
      return;
      bool = false;
    }
  }
  
  public void a(long paramLong, float paramFloat, String paramString)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOGalleryScene.4(this, paramLong, paramFloat, paramString));
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt2 == 2)
    {
      localObject1 = this.jdField_a_of_type_Ages.a();
      paramInt2 = 0;
      if (paramInt2 < ((List)localObject1).size())
      {
        localObject2 = (agfq)((List)localObject1).get(paramInt2);
        if ((((agfq)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != paramLong1) || (((agfq)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int != paramInt1)) {
          break label156;
        }
        ((agfq)localObject2).jdField_a_of_type_Int = paramInt3;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt2, paramInt3 / 100);
        if (paramBoolean)
        {
          paramInt1 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
          paramInt3 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
          if ((paramInt2 >= paramInt1) && (paramInt2 <= paramInt3 + paramInt1 - 1))
          {
            localObject1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt2 - paramInt1);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt2, (View)localObject1, paramBoolean);
          }
        }
      }
    }
    label156:
    label797:
    label799:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            paramInt2 += 1;
            break;
            if (paramInt2 == 24)
            {
              localObject1 = this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
              if ((((AIORichMediaData)localObject1).jdField_f_of_type_Long == paramLong1) && (((AIORichMediaData)localObject1).jdField_f_of_type_Int == paramInt1))
              {
                if ((this.jdField_a_of_type_AndroidWidgetSeekBar != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
                {
                  this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131700410) + paramInt3 / 100.0D + "%");
                  this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(paramInt3);
                }
              }
              else
              {
                localObject1 = a(paramLong1, paramInt1);
                if (localObject1 != null) {
                  ((agfq)localObject1).jdField_a_of_type_Agfr.jdField_a_of_type_Int = paramInt3;
                }
              }
            }
            else if (paramInt2 == 4)
            {
              localObject1 = this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
              if ((((AIORichMediaData)localObject1).jdField_f_of_type_Long == paramLong1) && (((AIORichMediaData)localObject1).jdField_f_of_type_Int == paramInt1))
              {
                this.jdField_a_of_type_Ages.a().jdField_a_of_type_Int = paramInt3;
                this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131700404) + arof.a((paramLong2 * (paramInt3 / 10000.0D))) + "/" + arof.a(paramLong2) + ")");
                this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(paramInt3);
                return;
              }
              localObject1 = a(paramLong1, paramInt1);
              if (localObject1 != null) {
                ((agfq)localObject1).jdField_a_of_type_Int = paramInt3;
              }
            }
            else if (paramInt2 == 1)
            {
              localObject1 = this.jdField_a_of_type_Ages.a();
              paramInt1 = 0;
              while (paramInt1 < ((List)localObject1).size())
              {
                localObject2 = (agfq)((List)localObject1).get(paramInt1);
                if (((agfq)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramLong1)
                {
                  ((agfq)localObject2).jdField_a_of_type_Int = paramInt3;
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt1, paramInt3 / 100);
                  return;
                }
                paramInt1 += 1;
              }
            }
            else if (paramInt2 == 256)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AIOGalleryScene", 2, "save video progress : " + paramInt3);
              }
              localObject1 = this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
              if ((((AIORichMediaData)localObject1).jdField_f_of_type_Long == paramLong1) && (((AIORichMediaData)localObject1).jdField_f_of_type_Int == paramInt1))
              {
                this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131700435) + paramInt3 + "%");
                this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(paramInt3 / 100.0D * 10000.0D));
              }
            }
            else
            {
              if (paramInt2 != 18) {
                break label799;
              }
              localObject1 = this.jdField_a_of_type_Ages.a();
              paramInt1 = 0;
              for (;;)
              {
                if (paramInt1 >= ((List)localObject1).size()) {
                  break label797;
                }
                localObject2 = (agfq)((List)localObject1).get(paramInt1);
                if (((agfq)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramLong1)
                {
                  ((agfq)localObject2).jdField_a_of_type_Int = paramInt3;
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt1, paramInt3 / 100);
                  if (!paramBoolean) {
                    break;
                  }
                  paramInt2 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
                  paramInt3 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
                  if ((paramInt1 < paramInt2) || (paramInt1 > paramInt3 + paramInt2 - 1)) {
                    break;
                  }
                  localObject1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2);
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt1, (View)localObject1, paramBoolean);
                  return;
                }
                paramInt1 += 1;
              }
            }
          }
        } while (paramInt2 != 20);
        localObject1 = this.jdField_a_of_type_Ages.a();
      } while (!AIOFilePicData.class.isInstance(((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
      localObject2 = (AIOFilePicData)((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      ((AIOFilePicData)localObject2).jdField_f_of_type_Boolean = true;
      if (this.jdField_a_of_type_Ageh == null)
      {
        this.jdField_a_of_type_Ageh = new ageh(this);
        this.jdField_a_of_type_Ageh.jdField_a_of_type_Long = ((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long;
        this.jdField_a_of_type_Ageh.jdField_a_of_type_Int = ((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int;
      }
    } while ((((AIOFilePicData)localObject2).jdField_f_of_type_Long != paramLong1) || (this.jdField_a_of_type_AndroidWidgetSeekBar == null));
    a(true);
    this.jdField_a_of_type_Ages.a().jdField_a_of_type_Int = paramInt3;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131700437) + arof.a((paramLong2 * (paramInt3 / 10000.0D))) + "/" + arof.a(paramLong2) + ")");
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(paramInt3);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    Object localObject1;
    int i1;
    if (paramInt2 == 2)
    {
      localObject1 = this.jdField_a_of_type_Ages;
      if (paramInt3 == 1)
      {
        paramInt2 = ((ages)localObject1).a(paramLong, paramInt1, paramInt2, paramString, false);
        i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
        int i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
        if ((paramInt2 >= i1) && (paramInt2 <= i2 + i1 - 1))
        {
          paramString = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt2 - i1);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt2, paramString, paramBoolean);
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("AIOGalleryScene", 4, "notifyImageResult(): Gallery position is " + paramInt2);
        }
        paramInt2 = 0;
        label133:
        if (paramInt2 >= this.jdField_a_of_type_Ages.a()) {
          break label460;
        }
        paramString = this.jdField_a_of_type_Ages.a(paramInt2);
        if (paramString != null) {
          break label178;
        }
      }
      for (;;)
      {
        paramInt2 += 1;
        break label133;
        paramString = "I:E";
        break;
        label178:
        if ((paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramLong) && (paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int == paramInt1) && (paramInt3 == 1) && (AIOImageData.class.isInstance(paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
        {
          paramString = (AIOImageData)paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          if ((!paramString.jdField_g_of_type_Boolean) && (new File(paramString.jdField_a_of_type_JavaLangString + "_hd").exists())) {
            paramString.jdField_a_of_type_JavaLangString += "_hd";
          }
        }
      }
    }
    else
    {
      if (paramInt2 != 24) {
        break label512;
      }
      localObject1 = this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if ((((AIORichMediaData)localObject1).jdField_f_of_type_Long != paramLong) || (((AIORichMediaData)localObject1).jdField_f_of_type_Int != paramInt1)) {
        break label486;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "save pic result = " + paramInt3 + ", resultStr = " + paramString);
      }
      if (paramInt3 != 1) {
        break label461;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131719309), 0).a();
      u();
      label425:
      if ((this.jdField_a_of_type_Ageh != null) && (this.jdField_a_of_type_Ageh.jdField_a_of_type_Long == paramLong) && (this.jdField_a_of_type_Ageh.jdField_a_of_type_Int == paramInt1)) {
        this.jdField_a_of_type_Ageh = null;
      }
    }
    label460:
    label461:
    label486:
    Object localObject2;
    label512:
    label796:
    label837:
    label869:
    label1645:
    do
    {
      do
      {
        return;
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131719305), 0).a();
        break;
        paramString = a(paramLong, paramInt1);
        if (paramString == null) {
          break label425;
        }
        paramString.jdField_a_of_type_Agfr.jdField_e_of_type_Boolean = false;
        break label425;
        if (paramInt2 != 4) {
          break label869;
        }
      } while ((this.jdField_a_of_type_Ageh == null) || (this.jdField_a_of_type_Ageh.jdField_a_of_type_Long != paramLong) || (this.jdField_a_of_type_Ageh.jdField_a_of_type_Int != paramInt1));
      localObject2 = this.jdField_a_of_type_Ages;
      if (paramInt3 == 1)
      {
        localObject1 = paramString;
        ((ages)localObject2).a(paramLong, paramInt1, paramInt2, (String)localObject1, false);
        if (paramInt3 != 1) {
          break label796;
        }
        paramString = URLDrawable.URLDrawableOptions.obtain();
        paramString.mPlayGifImage = true;
        paramString.mUseExifOrientation = false;
      }
      for (;;)
      {
        try
        {
          paramString = URLDrawable.getDrawable(this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4), paramString);
          if (paramString == null) {
            break;
          }
          switch (paramString.getStatus())
          {
          default: 
            paramString.setTag(Integer.valueOf(1));
            paramString.setURLDrawableListener(this.jdField_a_of_type_Ageh);
            paramString.startDownload();
            this.jdField_a_of_type_Ageh.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
            paramString = this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
            if ((paramString.jdField_f_of_type_Long != paramLong) || (paramString.jdField_f_of_type_Int != paramInt1)) {
              break label837;
            }
            this.jdField_a_of_type_Ages.a().jdField_a_of_type_Agfr.jdField_c_of_type_Boolean = false;
            u();
            return;
            localObject1 = "I:E";
          }
        }
        catch (Throwable paramString)
        {
          paramString.printStackTrace();
          paramString = null;
          continue;
          this.jdField_a_of_type_Ageh.onLoadSuccessed(paramString);
          continue;
          this.jdField_a_of_type_Ageh.onLoadFialed(paramString, null);
          continue;
          this.jdField_a_of_type_Ageh.onLoadCanceled(paramString);
          continue;
        }
        if (!"TroopFileError".equals(paramString)) {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131695499), 0).a();
        }
        this.jdField_a_of_type_Ageh = null;
        continue;
        paramString = a(paramLong, paramInt1);
        if (paramString != null)
        {
          paramString.jdField_a_of_type_Int = 0;
          paramString.jdField_a_of_type_Agfr.jdField_c_of_type_Boolean = false;
        }
      }
      if (paramInt2 == 256)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "save video result resultStr = " + paramString);
        }
        if (paramInt3 == 1) {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131719309), 0).a();
        }
        for (;;)
        {
          this.jdField_a_of_type_Agei.jdField_b_of_type_Boolean = false;
          u();
          return;
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131719305), 0).a();
        }
      }
      if ((paramInt2 == 1) || (paramInt2 == 0))
      {
        localObject1 = this.jdField_a_of_type_Ages;
        if (paramInt3 == 1) {}
        for (;;)
        {
          paramInt1 = ((ages)localObject1).a(paramLong, paramInt1, paramInt2, paramString, false);
          paramInt2 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
          paramInt3 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
          if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1))
          {
            paramString = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt1, paramString, paramBoolean);
          }
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("AIOGalleryScene", 4, "notifyImageResult(): Gallery position is " + paramInt1);
          return;
          paramString = "I:E";
        }
      }
      if (paramInt2 == 18)
      {
        localObject1 = this.jdField_a_of_type_Ages;
        if (paramInt3 == 1) {}
        for (;;)
        {
          paramInt1 = ((ages)localObject1).a(paramLong, paramInt1, paramInt2, paramString, false);
          paramInt2 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
          i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
          if ((paramInt1 >= paramInt2) && (paramInt1 <= i1 + paramInt2 - 1))
          {
            paramString = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt1, paramString, paramBoolean);
            if (paramInt3 == 2)
            {
              a(false);
              c(true);
              this.jdField_a_of_type_Ageh = null;
            }
          }
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("AIOGalleryScene", 4, "notifyImageResult(): Gallery position is " + paramInt1);
          return;
          paramString = "I:E";
        }
      }
      if ((paramInt2 == 20) && (this.jdField_a_of_type_Ageh != null) && (this.jdField_a_of_type_Ageh.jdField_a_of_type_Long == paramLong))
      {
        localObject2 = this.jdField_a_of_type_Ages;
        if (paramInt3 == 1) {}
        for (localObject1 = paramString;; localObject1 = "I:E")
        {
          ((ages)localObject2).a(paramLong, paramInt1, paramInt2, (String)localObject1, false);
          QLog.d("AIOGalleryScene", 2, "AIOFilePicData.TYPE_ORIGINAL_IMAGE,result:" + paramInt3 + ",resultStr: " + paramString);
          if (paramInt3 != 1) {
            break label1586;
          }
          paramString = this.jdField_a_of_type_Ages.a();
          if ((paramString != null) && (paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (AIOFilePicData.class.isInstance(paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
            ((AIOFilePicData)paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_f_of_type_Boolean = false;
          }
          paramString = URLDrawable.URLDrawableOptions.obtain();
          paramString.mPlayGifImage = true;
          paramString.mUseExifOrientation = false;
          localObject1 = this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          QLog.e("AIOGalleryScene", 1, "null url");
          return;
        }
        paramString = URLDrawable.getDrawable((String)localObject1, paramString);
        switch (paramString.getStatus())
        {
        }
        for (;;)
        {
          paramString.setTag(Integer.valueOf(1));
          paramString.setURLDrawableListener(this.jdField_a_of_type_Ageh);
          paramString.startDownload();
          this.jdField_a_of_type_Ageh.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
          return;
          this.jdField_a_of_type_Ageh.onLoadSuccessed(paramString);
          return;
          this.jdField_a_of_type_Ageh.onLoadFialed(paramString, null);
          return;
          this.jdField_a_of_type_Ageh.onLoadCanceled(paramString);
        }
        if (!"TroopFileError".equals(paramString))
        {
          if (!this.jdField_a_of_type_AndroidAppActivity.getString(2131692939).equals(paramString)) {
            break label1645;
          }
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, paramString, 0).a();
        }
        for (;;)
        {
          a(false);
          c(true);
          this.jdField_a_of_type_Ageh = null;
          return;
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131695499), 0).a();
        }
      }
    } while (paramInt2 != 269484034);
    label1586:
    paramInt1 = 0;
    label1680:
    if (paramInt1 < this.jdField_a_of_type_Ages.a())
    {
      localObject1 = this.jdField_a_of_type_Ages.a(paramInt1);
      if ((localObject1 != null) && (((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (AIOFileVideoData.class.isInstance(((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
        break label1735;
      }
    }
    label1735:
    do
    {
      paramInt1 += 1;
      break label1680;
      break;
      localObject2 = (AIOFileVideoData)((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    } while (((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != paramLong);
    if (paramInt3 == 1)
    {
      ((AIOFileVideoData)localObject2).jdField_c_of_type_Boolean = true;
      ((AIOFileVideoData)localObject2).jdField_d_of_type_Boolean = false;
      ((AIOFileVideoData)localObject2).jdField_c_of_type_JavaLangString = paramString;
    }
    for (;;)
    {
      u();
      if (this.jdField_a_of_type_Ages.a() != localObject1) {
        break;
      }
      this.jdField_a_of_type_Ailt.b(0);
      break;
      if (paramInt3 == 2) {
        ((AIOFileVideoData)localObject2).jdField_c_of_type_Boolean = false;
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    paramInt1 = this.jdField_a_of_type_Ages.a(paramLong, paramInt1, paramInt2, paramString1, false);
    paramInt2 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
    if (QLog.isDevelopLevel()) {
      QLog.d("AIOGalleryScene", 2, " carverW notifyVideoUrl(): Gallery position is " + paramInt1 + ", first = " + paramInt2 + ", count = " + i1);
    }
    if ((paramInt1 >= paramInt2) && (paramInt1 <= i1 + paramInt2 - 1)) {
      a(paramInt1, this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2), paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
    }
  }
  
  protected void a(agfq paramagfq, Activity paramActivity, int paramInt)
  {
    b(paramagfq, this.jdField_a_of_type_AndroidAppActivity, 0);
  }
  
  public void a(ailz paramailz)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("[TVKInfo] onPlayStart, id : ");
      if (paramailz != null) {
        break label78;
      }
    }
    label78:
    for (String str = "null";; str = paramailz.jdField_a_of_type_Long + "")
    {
      QLog.d("AIOGalleryScene", 2, str);
      if ((paramailz == null) || (!paramailz.jdField_b_of_type_Boolean) || (!paramailz.jdField_a_of_type_Boolean)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "Filevideo onPlayStart igon playProgress");
      }
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
    this.jdField_a_of_type_Ages.a().jdField_a_of_type_Agfr.jdField_g_of_type_Boolean = true;
    u();
  }
  
  public void a(ailz paramailz, int paramInt)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("[TVKInfo] onEndBuffering, id : ");
      if (paramailz == null)
      {
        localObject1 = "null";
        QLog.d("AIOGalleryScene", 2, (String)localObject1);
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_Ages.a();
      if ((localObject1 != null) && (((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (paramailz != null)) {
        break label96;
      }
    }
    label96:
    do
    {
      return;
      localObject1 = paramailz.jdField_a_of_type_Long + "";
      break;
      localObject2 = a(paramailz.jdField_a_of_type_Long, paramailz.jdField_b_of_type_Int);
      if (localObject2 != null) {
        ((agfq)localObject2).jdField_a_of_type_Agfr.jdField_d_of_type_Boolean = false;
      }
    } while (((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != paramailz.jdField_a_of_type_Long);
    u();
  }
  
  public void a(ailz paramailz, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[TVKInfo] onError , id : ");
      if (paramailz == null)
      {
        localObject = "null";
        QLog.d("AIOGalleryScene", 2, (String)localObject);
      }
    }
    else
    {
      if (paramailz != null) {
        break label80;
      }
    }
    label80:
    label231:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localObject = paramailz.jdField_a_of_type_Long + "";
              break;
              localObject = this.jdField_a_of_type_Ages.a();
            } while (((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != paramailz.jdField_a_of_type_Long);
            if (!paramailz.jdField_b_of_type_Boolean) {
              break label231;
            }
          } while (!AIOFileVideoData.class.isInstance(((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
          paramString = rjm.a(paramInt1, paramInt2);
          localObject = (AIOFileVideoData)((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        } while (((AIOFileVideoData)localObject).jdField_b_of_type_Boolean);
        ((AIOFileVideoData)localObject).a(paramString);
        paramString = new Bundle();
        float f1 = 0.0F;
        if (ailv.class.isInstance(this.jdField_a_of_type_Ailt)) {
          f1 = ((ailv)this.jdField_a_of_type_Ailt).a(paramailz.jdField_a_of_type_Long);
        }
        paramString.putFloat("progress", f1);
        this.jdField_a_of_type_Agft.a(((AIOFileVideoData)localObject).jdField_f_of_type_Long, 10, paramString);
        u();
        return;
        paramailz = a(paramailz.jdField_a_of_type_Long, paramailz.jdField_b_of_type_Int);
      } while (paramailz == null);
      paramailz.jdField_a_of_type_Agfr.jdField_k_of_type_Boolean = true;
    } while (!AIOShortVideoData.class.isInstance(((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
    ((AIOShortVideoData)((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(paramString);
    u();
  }
  
  public void a(ailz paramailz, long paramLong)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("[TVKInfo] onDurationReady , id : ");
      if (paramailz != null) {
        break label57;
      }
    }
    label57:
    for (paramailz = "null";; paramailz = paramailz.jdField_a_of_type_Long + "")
    {
      QLog.d("AIOGalleryScene", 2, paramailz);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramLong));
      return;
    }
  }
  
  public void a(ailz paramailz, boolean paramBoolean)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[TVKInfo] onGetUrl, id : ");
      if (paramailz == null)
      {
        str = "null";
        QLog.d("AIOGalleryScene", 2, str + " isStart=" + paramBoolean);
      }
    }
    else
    {
      if (paramailz != null) {
        break label87;
      }
    }
    label87:
    do
    {
      do
      {
        return;
        str = paramailz.jdField_a_of_type_Long + "";
        break;
        paramailz = a(paramailz.jdField_a_of_type_Long, paramailz.jdField_b_of_type_Int);
      } while (paramailz == null);
      paramailz.jdField_a_of_type_Agfr.jdField_j_of_type_Boolean = paramBoolean;
    } while (paramailz.jdField_a_of_type_Agfr.jdField_g_of_type_Boolean);
    this.jdField_e_of_type_AndroidWidgetTextView.setText("");
    u();
  }
  
  @TargetApi(14)
  public void a(Activity paramActivity, String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(paramActivity);
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561624);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372312);
      this.jdField_a_of_type_Bepe = a(paramActivity);
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bepe);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370758)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new agdv(this));
    }
    this.jdField_a_of_type_Bepe.c(0);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AIOGalleryScene.24(this), paramInt);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramConfiguration);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(ViewGroup paramViewGroup)
  {
    bngs.c(this.jdField_a_of_type_AndroidAppActivity);
    super.a(paramViewGroup);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a());
    this.jdField_a_of_type_Azey = azey.a(bllv.a());
    if (this.jdField_a_of_type_Azey != null) {
      this.jdField_b_of_type_AndroidWidgetImageView = this.jdField_a_of_type_Azey.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(9, -1);
    paramViewGroup = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();
    localLayoutParams.bottomMargin = ((int)TypedValue.applyDimension(1, 23.0F, paramViewGroup));
    localLayoutParams.leftMargin = ((int)TypedValue.applyDimension(1, 14.0F, paramViewGroup));
    int i1 = (int)TypedValue.applyDimension(1, 5.0F, paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131373463);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131165335));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(2.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165410));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695497);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131695497));
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i1, i1, i1, i1);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843196));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_d_of_type_AndroidWidgetImageButton.setContentDescription(alpo.a(2131700438));
    this.jdField_d_of_type_AndroidWidgetImageButton.setId(2131373458);
    this.jdField_d_of_type_AndroidWidgetImageButton.setImageResource(2130837937);
    this.jdField_d_of_type_AndroidWidgetImageButton.setBackgroundDrawable(null);
    this.jdField_d_of_type_AndroidWidgetImageButton.setPadding(0, 0, 0, 0);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.bottomMargin = ((int)TypedValue.applyDimension(1, 23.0F, paramViewGroup));
    localLayoutParams.rightMargin = ((int)TypedValue.applyDimension(1, 25.0F, paramViewGroup));
    boolean bool;
    if ((f()) && (!(this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras().getParcelable("extra.EXTRA_CURRENT_IMAGE") instanceof AIODevLittleVideoData)))
    {
      i1 = 1;
      if ((i1 == 0) || (this.jdField_k_of_type_Int == 3)) {
        break label1137;
      }
      bool = true;
      label485:
      if (bool) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_d_of_type_AndroidWidgetImageButton, localLayoutParams);
      }
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_b_of_type_AndroidWidgetImageButton.setContentDescription(alpo.a(2131700433));
      this.jdField_b_of_type_AndroidWidgetImageButton.setId(2131373459);
      this.jdField_b_of_type_AndroidWidgetImageButton.setImageResource(2130837935);
      this.jdField_b_of_type_AndroidWidgetImageButton.setBackgroundDrawable(null);
      this.jdField_b_of_type_AndroidWidgetImageButton.setPadding(0, 0, 0, 0);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(10, -1);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.topMargin = ((int)TypedValue.applyDimension(1, 10.0F, paramViewGroup));
      localLayoutParams.rightMargin = ((int)TypedValue.applyDimension(1, 24.0F, paramViewGroup));
      Bundle localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      if (!((AIORichMediaData)localBundle.getParcelable("extra.EXTRA_CURRENT_IMAGE") instanceof AIODevLittleVideoData)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageButton, localLayoutParams);
      }
      this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_k_of_type_Int = localBundle.getInt("extra.EXTRA_ENTRANCE");
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "editPhotoBtn mContext.getIntent().getBooleanExtra: " + this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("extra.FROM_AIO", false));
      }
      this.jdField_a_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
      if ((!this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("extra.FROM_AIO", false)) && (this.jdField_k_of_type_Int != 3) && (this.jdField_k_of_type_Int != 2)) {
        break label1142;
      }
      i1 = 1;
      label799:
      if (((i1 != 0) || ((this.jdField_k_of_type_Int == 4) && (localBundle.getBoolean("key_allow_forward_photo_preview_edit", false)))) && (abot.a(this.jdField_g_of_type_Int) != 1032) && (this.jdField_g_of_type_Int != 1037) && (abot.a(this.jdField_g_of_type_Int) != 1044))
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(alpo.a(2131700429));
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837930);
        this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundDrawable(null);
        this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetImageButton.setId(2131373460);
        this.jdField_a_of_type_AndroidWidgetImageButton.setPadding(0, 0, 0, 0);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(12, -1);
        localLayoutParams.alignWithParent = true;
        if (!bool) {
          break label1147;
        }
        localLayoutParams.addRule(0, 2131373458);
      }
    }
    for (;;)
    {
      localLayoutParams.bottomMargin = ((int)TypedValue.applyDimension(1, 23.0F, paramViewGroup));
      localLayoutParams.rightMargin = ((int)TypedValue.applyDimension(1, 20.0F, paramViewGroup));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageButton, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
      d(bool);
      F();
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((aikc.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter)) && (ProGallery.class.isInstance(this.jdField_a_of_type_ComTencentWidgetGallery))) {
        ((ProGallery)this.jdField_a_of_type_ComTencentWidgetGallery).setOnNoBlankListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter);
      }
      this.jdField_a_of_type_Ailt.a(this);
      this.jdField_a_of_type_Ailt.a(this);
      this.jdField_a_of_type_Ailt.e(this.jdField_k_of_type_Int);
      ((ProGallery)this.jdField_a_of_type_ComTencentWidgetGallery).setGestureListener(this);
      this.jdField_l_of_type_Int = (azjb.a(this.jdField_a_of_type_AndroidAppActivity) / 2);
      agdf.a().a(this);
      return;
      i1 = 0;
      break;
      label1137:
      bool = false;
      break label485;
      label1142:
      i1 = 0;
      break label799;
      label1147:
      localLayoutParams.addRule(11, -1);
    }
  }
  
  void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Agft != null) {
      this.jdField_a_of_type_Agft.a(paramString, paramInt);
    }
  }
  
  void a(String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
    localIntent.putExtra("detectType", paramInt2);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString1);
    paramString1 = null;
    paramIntent = null;
    paramInt2 = 0;
    switch (paramInt1)
    {
    default: 
      if (paramBoolean) {
        paramInt1 = 3;
      }
      break;
    }
    try
    {
      if (!TextUtils.equals(paramString2, this.jdField_b_of_type_JavaLangString)) {
        break label259;
      }
      paramIntent = this.jdField_c_of_type_JavaLangString;
      label132:
      if (TextUtils.isEmpty(paramString4)) {
        break label292;
      }
      i1 = bamr.d();
      if (paramInt2 == 0) {
        break label623;
      }
      str = "gchat.qpic.cn";
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        int i1;
        label259:
        label292:
        QLog.e("AIOGalleryScene", 1, "onQRDecodeSucceed error:" + paramString1.getMessage());
        continue;
        continue;
        String str = "c2cpicdw.qpic.cn";
        continue;
        paramString1 = null;
        continue;
        paramString1 = null;
        continue;
        paramString1 = null;
      }
    }
    if (!TextUtils.isEmpty(str)) {
      if (i1 != 80) {
        paramString1 = str + ":" + i1 + paramString4;
      } else {
        for (;;)
        {
          localIntent.putExtra("report_params", xwb.a(paramString3, paramString1, paramString5, paramString2, paramIntent, paramInt1));
          this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
          return;
          if (paramBoolean)
          {
            paramInt1 = 4;
            break label132;
          }
          paramInt1 = 2;
          paramInt2 = 1;
          break label132;
          paramInt1 = 1;
          break;
          paramIntent = this.jdField_b_of_type_JavaLangString;
          break label132;
          paramString1 = str + paramString4;
          break label620;
          if (TextUtils.isEmpty(paramString5)) {
            break label631;
          }
          switch (paramInt1)
          {
          case 2: 
            paramString1 = "gchat.qpic.cn/gchatpic_new";
            if (!TextUtils.isEmpty(paramString2)) {
              paramString1 = "gchat.qpic.cn/gchatpic_new" + "/" + paramString2;
            }
            if (paramString5.startsWith("/")) {
              paramString1 = paramString1 + "0-0-" + paramString5.replace(".jpg", "") + "/0";
            } else {
              paramString1 = paramString1 + "/0-0-" + paramString5.replace(".jpg", "") + "/0";
            }
            break;
          case 1: 
            paramString1 = "c2cpicdw.qpic.cn/offpic_new";
            if (!TextUtils.isEmpty(paramString2)) {
              paramString1 = "c2cpicdw.qpic.cn/offpic_new" + "/" + paramString2;
            }
            if (paramString5.startsWith("/")) {
              paramString1 = paramString1 + paramString5 + "/0";
            } else {
              paramString1 = paramString1 + "/" + paramString5 + "/0";
            }
            break;
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "showLoadPanel : " + paramBoolean);
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      c(false);
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode()) {
      try
      {
        if (!AIODevLittleVideoData.class.isInstance(this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          c(3);
        }
        return true;
      }
      catch (Throwable paramKeyEvent)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AIOGalleryScene", 2, "showActionSheet oom");
          }
        }
      }
    }
    return super.a(paramInt, paramKeyEvent);
  }
  
  boolean a(agfq paramagfq)
  {
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("onScroll", 2, "distanceX=" + paramFloat1 + " x1=" + paramMotionEvent1.getRawX() + " x2=" + paramMotionEvent2.getRawX() + " x2-x1=" + (paramMotionEvent2.getRawX() - paramMotionEvent1.getRawX()) + " alldis=");
    }
    if (Math.abs(paramMotionEvent2.getRawX() - paramMotionEvent1.getRawX()) > this.jdField_l_of_type_Int) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.d();
    }
    return false;
  }
  
  boolean a(bhpy parambhpy, AIOImageData paramAIOImageData)
  {
    return false;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    azmj.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "0", "", "", "");
    if (this.jdField_k_of_type_Int == 4) {
      return true;
    }
    try
    {
      if (!AIODevLittleVideoData.class.isInstance(this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        c(1);
      }
      return true;
    }
    catch (Throwable paramAdapterView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOGalleryScene", 2, "showActionSheet oom");
        }
      }
    }
  }
  
  boolean a(String paramString, AIOImageData paramAIOImageData, File paramFile)
  {
    return false;
  }
  
  public void as_()
  {
    q();
  }
  
  public void b()
  {
    w();
    agfq localagfq = this.jdField_a_of_type_Ages.b();
    if (localagfq != null) {
      localagfq.jdField_b_of_type_Boolean = true;
    }
    if (!g()) {
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
    if (this.jdField_k_of_type_Int == 4) {
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    this.jdField_a_of_type_Agei.jdField_d_of_type_Boolean = false;
    u();
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    this.jdField_a_of_type_Agei.jdField_a_of_type_Boolean = false;
    u();
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_Ages.a().jdField_a_of_type_Agfr.jdField_g_of_type_Boolean = true;
    int i1 = this.jdField_a_of_type_Ages.a(paramLong, 0, 0, "", false);
    agfq localagfq = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(i1);
    if (AIOFileVideoData.class.isInstance(localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      ((AIOFileVideoData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a();
      QLog.i("FileVideoMediaPlayHelper.filevideoPeek", 1, "file[" + paramLong + "],download success, set downloadSuccess");
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOGalleryScene.5(this));
  }
  
  public void b(ailz paramailz)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("[TVKInfo] onPlayPause , id : ");
      if (paramailz != null) {
        break label56;
      }
    }
    label56:
    for (paramailz = "null";; paramailz = paramailz.jdField_a_of_type_Long + "")
    {
      QLog.d("AIOGalleryScene", 2, paramailz);
      this.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
  }
  
  public void b(ailz paramailz, int paramInt)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[TVKInfo] onDownloading, id : ");
      if (paramailz == null)
      {
        str = "null";
        QLog.d("AIOGalleryScene", 2, str);
      }
    }
    else
    {
      if (paramailz != null) {
        break label77;
      }
    }
    label77:
    do
    {
      do
      {
        return;
        str = paramailz.jdField_a_of_type_Long + "";
        break;
        paramailz = a(paramailz.jdField_a_of_type_Long, paramailz.jdField_b_of_type_Int);
      } while (paramailz == null);
      paramailz.jdField_a_of_type_Agfr.jdField_h_of_type_Boolean = true;
    } while (paramailz.jdField_a_of_type_Agfr.jdField_g_of_type_Boolean);
    this.jdField_e_of_type_AndroidWidgetTextView.setText("");
    u();
  }
  
  protected boolean b()
  {
    boolean bool = true;
    if (this.jdField_c_of_type_Int == 1) {
      bool = false;
    }
    return bool;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Agei.jdField_d_of_type_Boolean = true;
    u();
    if (!h()) {
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    if (this.jdField_d_of_type_AndroidWidgetImageButton != null) {
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
  }
  
  void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(this.jdField_a_of_type_AndroidAppActivity.getString(2131693003));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(new agdq(this));
    agfq localagfq = this.jdField_a_of_type_Ages.a();
    Object localObject3;
    Object localObject2;
    Object localObject1;
    int i1;
    label170:
    int i2;
    int i3;
    if (AIOImageData.class.isInstance(localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      localObject3 = (AIOImageData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if ((((AIOImageData)localObject3).jdField_g_of_type_Int == 1) && (((AIOImageData)localObject3).jdField_h_of_type_Boolean))
      {
        localObject2 = ((AIOImageData)localObject3).a(4);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = ((AIOImageData)localObject3).a(2);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = ((AIOImageData)localObject3).a(1);
        }
        if ((localObject2 == null) && (this.t)) {
          return;
        }
        a((AIORichMediaData)localObject3, (File)localObject2, paramInt);
      }
      for (i1 = 2;; i1 = 1)
      {
        i2 = localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_g_of_type_Int;
        if (i2 != 0) {
          break;
        }
        i3 = 1;
        label186:
        if (this.jdField_k_of_type_Int != 1) {
          break label565;
        }
        i2 = 1;
        label196:
        if (paramInt != 2) {
          break label604;
        }
        paramInt = 1;
        label203:
        azmj.b(null, "dc00898", "", "", "0X8009EFB", "0X8009EFB", i1, 0, String.valueOf(i3), String.valueOf(i2), String.valueOf(paramInt), "");
        return;
        b(localagfq);
      }
    }
    if (AIOShortVideoData.class.isInstance(localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      localObject1 = (AIOShortVideoData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (((AIOShortVideoData)localObject1).jdField_b_of_type_Int == 0) {
        i1 = 4;
      }
    }
    for (;;)
    {
      a((AIOShortVideoData)localObject1, paramInt);
      break label170;
      if (((AIOShortVideoData)localObject1).jdField_b_of_type_Int == 1)
      {
        i1 = 3;
        continue;
        if (AIOFilePicData.class.isInstance(localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          localObject3 = (AIOFilePicData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          localObject2 = ((AIOFilePicData)localObject3).a(20);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = ((AIOFilePicData)localObject3).a(18);
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = ((AIOFilePicData)localObject3).a(16);
          }
          if ((localObject2 == null) && (this.t)) {
            break;
          }
          a((AIORichMediaData)localObject3, (File)localObject2, paramInt);
          i1 = 2;
          break label170;
        }
        if (AIOFileVideoData.class.isInstance(localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          i1 = 5;
          a((AIOFileVideoData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt);
          break label170;
          if (i2 == 1)
          {
            i3 = 2;
            break label186;
          }
          if ((i2 == 1004) || (i2 == 1008) || (i2 == 1009) || (i2 == 1010) || (i2 == 1011) || (i2 == 1020) || (i2 == 1021) || (i2 == 1022) || (i2 == 1023) || (i2 == 1024) || (i2 == 1025) || (i2 == 1036) || (i2 == 10002) || (i2 == 10003) || (i2 == 10004))
          {
            i3 = 3;
            break label186;
          }
          i3 = 4;
          break label186;
          label565:
          if (this.jdField_k_of_type_Int == 2)
          {
            i2 = 5;
            break label196;
          }
          if (this.jdField_k_of_type_Int == 3)
          {
            i2 = 4;
            break label196;
          }
          if (this.jdField_c_of_type_Boolean)
          {
            i2 = 6;
            break label196;
            label604:
            if (paramInt == 1)
            {
              paramInt = 2;
              break label203;
            }
            paramInt = 0;
            break label203;
          }
          i2 = 0;
          break label196;
        }
        i1 = 0;
        break label170;
      }
      i1 = 0;
    }
  }
  
  public void c(ailz paramailz)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("[TVKInfo] onPlayFinish , id : ");
      if (paramailz != null) {
        break label88;
      }
    }
    label88:
    for (paramailz = "null";; paramailz = paramailz.jdField_a_of_type_Long + "")
    {
      QLog.d("AIOGalleryScene", 2, paramailz);
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Ages.a();
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(100);
      u();
      return;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.u = paramBoolean;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (this.u) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  protected boolean c()
  {
    if (((this.jdField_c_of_type_Int == -3321) || (this.jdField_c_of_type_Int == 1)) && (!this.jdField_j_of_type_Boolean)) {
      return false;
    }
    if (this.jdField_e_of_type_Int == -2147483648) {
      return false;
    }
    Iterator localIterator = ((ActivityManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("activity")).getRunningAppProcesses().iterator();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
    } while (!localRunningAppProcessInfo.processName.endsWith("mobileqq"));
    for (int i1 = localRunningAppProcessInfo.pid;; i1 = -2147483648) {
      return i1 == this.jdField_e_of_type_Int;
    }
  }
  
  public void d()
  {
    if (!h()) {
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    if (this.jdField_d_of_type_AndroidWidgetImageButton != null) {
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    if (this.jdField_a_of_type_Azey != null) {
      this.jdField_a_of_type_Azey.b();
    }
    this.jdField_a_of_type_Agei.jdField_f_of_type_Boolean = true;
    u();
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_Bepe == null) {
      return;
    }
    this.jdField_a_of_type_Bepe.a();
    this.jdField_a_of_type_Bepe.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("AIOGalleryScene", 2, "[setProgress] current:" + this.jdField_a_of_type_Bepe.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bepe.b(true);
    this.jdField_a_of_type_Bepe.d(false);
    this.jdField_a_of_type_Bepe.a(String.valueOf(paramInt) + "%");
  }
  
  public void d(ailz paramailz)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("[TVKInfo] onBuffering, id : ");
      if (paramailz == null)
      {
        localObject1 = "null";
        QLog.d("AIOGalleryScene", 2, (String)localObject1);
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_Ages.a();
      if ((localObject1 != null) && (((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (paramailz != null)) {
        break label94;
      }
    }
    label94:
    do
    {
      return;
      localObject1 = paramailz.jdField_a_of_type_Long + "";
      break;
      localObject2 = a(paramailz.jdField_a_of_type_Long, paramailz.jdField_b_of_type_Int);
      if (localObject2 != null) {
        ((agfq)localObject2).jdField_a_of_type_Agfr.jdField_d_of_type_Boolean = true;
      }
    } while ((((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != paramailz.jdField_a_of_type_Long) || (((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int != paramailz.jdField_b_of_type_Int));
    u();
  }
  
  public void e()
  {
    if (this.jdField_l_of_type_Boolean)
    {
      this.jdField_l_of_type_Boolean = false;
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatHistoryFileActivity.class);
      localIntent.addFlags(603979776);
      agfq localagfq = this.jdField_a_of_type_Ages.a();
      if (localagfq != null) {
        localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
      }
      localIntent.putExtra("tab_tab_type", 0);
      localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("uintype", this.jdField_g_of_type_Int);
      localIntent.putExtra("extra.IS_FROM_CHAT_AIO_GALLERY", true);
      localIntent.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getString(2131690884));
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
    }
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Ages != null)
    {
      if (this.jdField_a_of_type_Ages.a() != null) {
        break label25;
      }
      bool1 = bool2;
    }
    label25:
    do
    {
      return bool1;
      Object localObject = this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if ((localObject != null) && (AIOImageData.class.isInstance(localObject)) && (this.jdField_a_of_type_Ages.a().jdField_a_of_type_Agfr != null) && (this.jdField_a_of_type_Ages.a().jdField_a_of_type_Agfr.jdField_c_of_type_Boolean))
      {
        if (this.jdField_a_of_type_Ageh != null) {
          this.jdField_a_of_type_Agft.b(this.jdField_a_of_type_Ageh.jdField_a_of_type_Long, this.jdField_a_of_type_Ageh.jdField_a_of_type_Int, 4);
        }
        this.jdField_a_of_type_Ages.a().jdField_a_of_type_Agfr.jdField_c_of_type_Boolean = false;
        u();
        return true;
      }
      c(false);
      bool2 = super.e();
      y();
      localObject = a().findViewById(2131367020);
      if (localObject != null) {
        ((View)localObject).setVisibility(4);
      }
      if (this.jdField_j_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_Ages.a();
        if (localObject != null)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", ((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
          this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
        }
      }
      bool1 = bool2;
    } while (!this.jdField_m_of_type_Boolean);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, this.jdField_a_of_type_AndroidAppActivity.getIntent());
    return bool2;
  }
  
  public void f()
  {
    agfq localagfq = this.jdField_a_of_type_Ages.a();
    if ((localagfq != null) && (AIOShortVideoData.class.isInstance(localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) && (((AIOShortVideoData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_Ailt != null)) {
      this.jdField_a_of_type_Ailt.k();
    }
    AppNetConnInfo.unregisterNetInfoHandler(this);
    super.f();
    if (this.jdField_m_of_type_Int > 0) {
      azmj.b(null, "CliOper", "", "", "View_pic", "View_pic_spin", 0, 0, "" + this.jdField_m_of_type_Int, "", "", "");
    }
    agdf.a().b(this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.c();
    }
    this.jdField_a_of_type_Azey = null;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    aggc.a().a();
    if (this.jdField_a_of_type_Anoe != null) {
      this.jdField_a_of_type_Anoe.b();
    }
  }
  
  public boolean f()
  {
    if (abot.a(this.jdField_g_of_type_Int) == 1032) {}
    label231:
    label232:
    for (;;)
    {
      return false;
      if ((this.jdField_g_of_type_Int != 1037) && (abot.a(this.jdField_g_of_type_Int) != 1044) && (!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Ages != null))
      {
        Object localObject = this.jdField_a_of_type_Ages.a();
        if (AIOImageData.class.isInstance(((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          AIOImageData localAIOImageData = (AIOImageData)((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          localObject = localAIOImageData.a(4);
          if (localObject != null) {
            break label231;
          }
          localObject = localAIOImageData.a(2);
        }
        for (;;)
        {
          if ((localObject == null) && (this.t)) {
            break label232;
          }
          if ((!this.t) && (!this.jdField_c_of_type_Boolean)) {}
          for (boolean bool = true;; bool = false)
          {
            return bool;
            if (AIOShortVideoData.class.isInstance(((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
            {
              localObject = ((AIOShortVideoData)((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(1);
              if ((localObject == null) || (!((File)localObject).exists())) {
                break;
              }
              return true;
            }
            if (AIOFilePicData.class.isInstance(((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
            {
              if (this.jdField_c_of_type_Boolean) {
                break;
              }
              return true;
            }
            if (!AIOFileVideoData.class.isInstance(((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
              break;
            }
            localObject = (AIOFileVideoData)((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
            if ((this.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(((AIOFileVideoData)localObject).jdField_c_of_type_JavaLangString))) {
              break;
            }
            return true;
          }
        }
      }
    }
  }
  
  public void g()
  {
    y();
    if (this.jdField_a_of_type_Ailt != null) {
      this.jdField_a_of_type_Ailt.d();
    }
  }
  
  boolean g()
  {
    return false;
  }
  
  boolean h()
  {
    return false;
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onStop");
    }
    super.l();
    D();
    Object localObject1 = this.jdField_a_of_type_Ages.a();
    if ((localObject1 == null) || (((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          localObject2 = (ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371442);
          if ((!(((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)) || (((AIOShortVideoData)((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Int != 1)) {
            break;
          }
          localObject1 = a();
        } while (localObject1 == null);
        Object localObject2 = ((AIOGalleryAdapter.GalleryImageStruct)localObject1).a();
        if ((localObject2 instanceof URLDrawable)) {
          ((URLDrawable)localObject2).pauseVideo();
        }
        ((AIOGalleryAdapter.GalleryImageStruct)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
        if ((!(((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)) || (((AIOShortVideoData)((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Int != 0)) {
          break;
        }
      } while (this.jdField_a_of_type_Ailt == null);
      this.jdField_a_of_type_Ailt.h();
      return;
    } while ((!AIOFileVideoData.class.isInstance(((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) || (this.jdField_a_of_type_Ailt == null) || (!this.jdField_a_of_type_Ailt.c()));
    this.jdField_a_of_type_Ailt.h();
  }
  
  public void m()
  {
    super.m();
    agfq localagfq = this.jdField_a_of_type_Ages.b();
    if (localagfq != null) {
      localagfq.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void n()
  {
    super.n();
    agfq localagfq = this.jdField_a_of_type_Ages.b();
    if (localagfq != null) {
      localagfq.jdField_b_of_type_Boolean = false;
    }
    this.jdField_k_of_type_Int = 3;
    this.s = true;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof AIOGalleryActivity))
    {
      ((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).jdField_c_of_type_Boolean = false;
      ((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).jdField_a_of_type_Long = -1L;
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return;
      paramView = this.jdField_a_of_type_Ages.a();
      if ((paramView != null) && (this.jdField_a_of_type_Agft.asBinder().pingBinder()))
      {
        this.jdField_a_of_type_Ageh = new ageh(this);
        this.jdField_a_of_type_Ageh.jdField_a_of_type_Long = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long;
        this.jdField_a_of_type_Ageh.jdField_a_of_type_Int = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int;
        if (AIOImageData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          paramView.jdField_a_of_type_Agfr.jdField_c_of_type_Boolean = true;
          u();
          this.jdField_a_of_type_Agft.a(this.jdField_a_of_type_Ageh.jdField_a_of_type_Long, this.jdField_a_of_type_Ageh.jdField_a_of_type_Int, 4);
          return;
        }
        if (AIOFilePicData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          if (!bdee.d(this.jdField_a_of_type_AndroidAppActivity))
          {
            QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131694061), 0).a();
            this.jdField_a_of_type_Ageh = null;
            u();
            return;
          }
          paramView = (AIOFilePicData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          if (paramView.jdField_d_of_type_Boolean)
          {
            QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692939), 0).a();
            u();
            this.jdField_a_of_type_Ageh = null;
            return;
          }
          if (paramView.jdField_e_of_type_Boolean) {
            u();
          }
          long l1 = aqxg.a();
          if ((paramView.jdField_a_of_type_Long > l1) && (arni.a())) {
            try
            {
              arni.a(false, this.jdField_a_of_type_AndroidAppActivity, new agdj(this));
              return;
            }
            catch (Throwable paramView)
            {
              return;
            }
          }
          a(true);
          this.jdField_a_of_type_Agft.a(this.jdField_a_of_type_Ageh.jdField_a_of_type_Long, this.jdField_a_of_type_Ageh.jdField_a_of_type_Int, 20);
          this.jdField_a_of_type_ComTencentWidgetGallery.b(true);
          this.jdField_a_of_type_ComTencentWidgetGallery.a(true);
          return;
          azmj.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "1", "", "", "");
          c(2);
          return;
          G();
          return;
          x();
          azmj.b(null, "dc00898", "", "", "0X8009EFD", "0X8009EFD", a(), b(), "" + a("0X8009EFD"), "", "", "");
          return;
          C();
          azmj.b(null, "dc00898", "", "", "0X8009EFC", "0X8009EFC", a(), b(), "" + a("0X8009EFC"), "", "", "");
          return;
          paramView = this.jdField_a_of_type_Ages.a();
          if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && ((paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFilePicData)))
          {
            if (this.jdField_a_of_type_Ageh != null)
            {
              e();
              e();
            }
          }
          else if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && ((paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) && (((AIOImageData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Int == 3) && (this.jdField_a_of_type_Ageh != null))
          {
            e();
            e();
            return;
            paramView = (ImageView)paramView;
            Object localObject;
            if ((this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData))
            {
              if (((AIOShortVideoData)this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Int == 0)
              {
                if (this.jdField_a_of_type_Ailt != null)
                {
                  this.jdField_a_of_type_Ailt.f();
                  if (this.jdField_a_of_type_Ailt.c()) {
                    paramView.setImageResource(2130845635);
                  }
                  for (;;)
                  {
                    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
                    return;
                    paramView.setImageResource(2130845634);
                  }
                }
              }
              else
              {
                localObject = a();
                if (localObject != null)
                {
                  Drawable localDrawable = ((AIOGalleryAdapter.GalleryImageStruct)localObject).a();
                  if ((localDrawable instanceof URLDrawable))
                  {
                    int i1 = ((URLDrawable)localDrawable).getPlayState();
                    int i2 = this.jdField_a_of_type_Ages.b();
                    if (i1 == 2)
                    {
                      ((AIOGalleryAdapter.GalleryImageStruct)localObject).b(i2);
                      paramView.setImageResource(2130845634);
                      ((AIOGalleryAdapter.GalleryImageStruct)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
                      return;
                    }
                    if (i1 == 4)
                    {
                      ((AIOGalleryAdapter.GalleryImageStruct)localObject).b(i2);
                      paramView.setImageResource(2130845635);
                      ((AIOGalleryAdapter.GalleryImageStruct)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
                      return;
                    }
                    if (i1 == 6)
                    {
                      ((AIOGalleryAdapter.GalleryImageStruct)localObject).b(i2);
                      ((AIOGalleryAdapter.GalleryImageStruct)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
                      paramView.setImageResource(2130845635);
                      return;
                    }
                    if (i1 == -1)
                    {
                      ((AIOGalleryAdapter.GalleryImageStruct)localObject).b(i2);
                      ((AIOGalleryAdapter.GalleryImageStruct)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
                      paramView.setImageResource(2130845635);
                    }
                  }
                }
              }
            }
            else if (((this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData)) && (this.jdField_a_of_type_Ailt != null))
            {
              this.jdField_a_of_type_Ailt.f();
              if (this.jdField_a_of_type_Ailt.c()) {
                paramView.setImageResource(2130845635);
              }
              for (;;)
              {
                this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
                return;
                paramView.setImageResource(2130845634);
              }
              if (this.jdField_a_of_type_Ailt != null)
              {
                paramView = this.jdField_a_of_type_Ages.a();
                if (paramView != null)
                {
                  if (!AIOFileVideoData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
                    break label1248;
                  }
                  ((AIOFileVideoData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Boolean = true;
                  this.jdField_a_of_type_Ailt.c();
                  this.jdField_a_of_type_Ailt.e();
                  e();
                }
              }
              label1084:
              paramView = this.jdField_a_of_type_Ages.a();
              if (this.jdField_a_of_type_Ailt != null) {
                l1 = this.jdField_a_of_type_Ailt.a();
              }
              for (;;)
              {
                if ((paramView != null) && ((paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)))
                {
                  paramView = (AIOShortVideoData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                  if (this.jdField_a_of_type_Betz != null) {
                    this.jdField_a_of_type_Betz.b();
                  }
                  this.jdField_a_of_type_Betz = new betz(this.jdField_a_of_type_AndroidAppActivity);
                  localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramView);
                  if (localObject != null)
                  {
                    this.jdField_a_of_type_Betz.a((ailz)localObject, paramView.jdField_a_of_type_Long, l1);
                    this.jdField_a_of_type_Betz.a(paramView.jdField_a_of_type_JavaLangString, paramView.jdField_c_of_type_Int, paramView.jdField_d_of_type_Int);
                    bool1 = bool2;
                    if (paramView.jdField_c_of_type_Int > paramView.jdField_d_of_type_Int) {
                      bool1 = true;
                    }
                    if (!this.jdField_a_of_type_Betz.a(bool1, paramView.jdField_g_of_type_Int)) {
                      break;
                    }
                    e();
                    return;
                    label1248:
                    if (AIOShortVideoData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
                    {
                      paramView = (AIOShortVideoData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                      if (paramView.jdField_b_of_type_Int == 0)
                      {
                        if (this.jdField_a_of_type_Agft != null) {
                          this.jdField_a_of_type_Agft.b(paramView.jdField_f_of_type_Long, paramView.jdField_f_of_type_Int, 256);
                        }
                        u();
                        break label1084;
                      }
                      if (paramView.jdField_b_of_type_Int != 1) {
                        break label1084;
                      }
                      this.jdField_a_of_type_Agei.jdField_c_of_type_Boolean = false;
                      u();
                      break label1084;
                    }
                    if (AIOImageData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
                    {
                      localObject = (AIOImageData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                      if (paramView.jdField_a_of_type_Agfr.jdField_c_of_type_Boolean)
                      {
                        if (this.jdField_a_of_type_Agft != null) {
                          this.jdField_a_of_type_Agft.b(this.jdField_a_of_type_Ageh.jdField_a_of_type_Long, this.jdField_a_of_type_Ageh.jdField_a_of_type_Int, 4);
                        }
                        paramView.jdField_a_of_type_Agfr.jdField_c_of_type_Boolean = false;
                      }
                      for (;;)
                      {
                        u();
                        break;
                        if (this.jdField_a_of_type_Agft != null) {
                          this.jdField_a_of_type_Agft.b(((AIOImageData)localObject).jdField_f_of_type_Long, ((AIOImageData)localObject).jdField_f_of_type_Int, 24);
                        }
                        paramView.jdField_a_of_type_Agfr.jdField_f_of_type_Boolean = true;
                      }
                    }
                    if (!AIOFilePicData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
                      break label1084;
                    }
                    paramView = (AIOFilePicData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                    if (this.jdField_a_of_type_Agft != null) {
                      this.jdField_a_of_type_Agft.b(paramView.jdField_f_of_type_Long, paramView.jdField_f_of_type_Int, 24);
                    }
                    paramView.jdField_f_of_type_Boolean = false;
                    a(false);
                    u();
                    break label1084;
                    l1 = 0L;
                    continue;
                  }
                  QLog.d("AIOGalleryScene", 1, "Failed to floating, videoPlayMedioInfo is null");
                  return;
                }
              }
              if ((paramView != null) && ((paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData)))
              {
                paramView = (AIOFileVideoData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                if (xmx.c(paramView.jdField_c_of_type_JavaLangString))
                {
                  if (this.jdField_a_of_type_Betz != null) {
                    this.jdField_a_of_type_Betz.b();
                  }
                  this.jdField_a_of_type_Betz = new betz(this.jdField_a_of_type_AndroidAppActivity);
                  this.jdField_a_of_type_Betz.a(paramView.jdField_c_of_type_JavaLangString, paramView.jdField_f_of_type_Long, l1);
                  if (bdcs.b(paramView.jdField_b_of_type_JavaLangString)) {
                    this.jdField_a_of_type_Betz.a(paramView.jdField_b_of_type_JavaLangString, paramView.jdField_a_of_type_Int, paramView.jdField_b_of_type_Int);
                  }
                  if (paramView.jdField_a_of_type_Int > paramView.jdField_b_of_type_Int) {}
                  while (this.jdField_a_of_type_Betz.a(bool1, paramView.jdField_g_of_type_Int))
                  {
                    e();
                    return;
                    bool1 = false;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onItemClick");
    }
    paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null)) {
      QLog.e("AIOGalleryScene", 1, "there data is null, position:" + paramInt);
    }
    label262:
    label312:
    for (;;)
    {
      return;
      if ((AIOImageData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) || (AIOFilePicData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
        e();
      }
      MotionEvent localMotionEvent = ((DragGallery)this.jdField_a_of_type_ComTencentWidgetGallery).a();
      if (AIOShortVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        if (((AIOShortVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Int == 0) {
          break label262;
        }
        if (!AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView)) {
          break label254;
        }
        AIOGalleryAdapter.GalleryImageStruct localGalleryImageStruct = (AIOGalleryAdapter.GalleryImageStruct)paramView;
        if (!localGalleryImageStruct.a(localMotionEvent)) {
          break label246;
        }
        localGalleryImageStruct.b(paramInt);
      }
      for (;;)
      {
        if ((!AIOFileVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) || (this.jdField_a_of_type_Ailt == null)) {
          break label312;
        }
        if ((localMotionEvent == null) || (this.jdField_a_of_type_Ailt == null) || (!this.jdField_a_of_type_Ailt.a(localMotionEvent))) {
          break label314;
        }
        paramAdapterView = (AIOFileVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        paramAdapterView.a(paramView, this.jdField_a_of_type_Ailt);
        paramAdapterView.jdField_d_of_type_Boolean = false;
        if (TextUtils.isEmpty(paramAdapterView.jdField_c_of_type_JavaLangString)) {
          break;
        }
        u();
        return;
        label246:
        e();
        continue;
        label254:
        e();
        continue;
        if ((this.jdField_a_of_type_Ailt != null) && (localMotionEvent != null) && (this.jdField_a_of_type_Ailt.a(localMotionEvent)))
        {
          if (!this.jdField_a_of_type_Agei.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_Ailt.f();
          }
        }
        else {
          e();
        }
      }
    }
    label314:
    e();
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    Object localObject;
    Drawable localDrawable;
    if (!this.jdField_e_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Ages.b()) {
        z();
      }
    }
    else
    {
      c(false);
      this.jdField_a_of_type_ComTencentWidgetGallery.b(true);
      this.jdField_a_of_type_ComTencentWidgetGallery.a(true);
      if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView))
      {
        localObject = (AIOGalleryAdapter.GalleryImageStruct)paramView;
        localDrawable = ((AIOGalleryAdapter.GalleryImageStruct)localObject).a();
        if ((((AIOGalleryAdapter.GalleryImageStruct)localObject).a()) || (localDrawable == null) || (!(localDrawable instanceof URLDrawable))) {
          break label613;
        }
        localObject = this.jdField_a_of_type_Ages.a(paramInt);
        if (localObject != null)
        {
          a((agfq)localObject);
          if ((((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4)) || (((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20)))
          {
            if (((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.h <= 0L) {
              break label600;
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidAppActivity.getString(2131695500), new Object[] { arof.a(((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.h) }));
            label196:
            c(true);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramAdapterView, paramView, paramInt, paramLong);
              localObject = a().findViewById(2131367020);
              if (localObject != null)
              {
                if (((View)localObject).getAnimation() != null)
                {
                  ((View)localObject).getAnimation().cancel();
                  ((View)localObject).setAnimation(null);
                }
                ((View)localObject).setVisibility(4);
              }
            }
          }
        }
      }
      label265:
      a(false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramAdapterView, paramView, paramInt, paramLong);
        paramAdapterView = a().findViewById(2131367020);
        if (paramAdapterView != null)
        {
          if (paramAdapterView.getAnimation() != null)
          {
            paramAdapterView.getAnimation().cancel();
            paramAdapterView.setAnimation(null);
          }
          paramAdapterView.setVisibility(4);
        }
      }
      paramAdapterView = this.jdField_a_of_type_Ages.a(paramInt);
      if (paramAdapterView != null) {
        this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(paramAdapterView.b());
      }
      if (paramAdapterView != null)
      {
        if ((!(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFilePicData)) || (!((AIOFilePicData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_f_of_type_Boolean)) {
          break label864;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt, -1);
          ((AIOFilePicData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_f_of_type_Boolean = false;
        }
      }
    }
    for (;;)
    {
      a(paramAdapterView);
      u();
      if ((paramAdapterView != null) && (this.jdField_a_of_type_Azey != null))
      {
        if (!(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)) {
          break label894;
        }
        this.jdField_a_of_type_Azey.a((AIOShortVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
      }
      return;
      int i2 = this.jdField_a_of_type_Ages.a();
      int i1 = 0;
      if (this.jdField_k_of_type_Boolean) {
        if (i2 - paramInt > 0)
        {
          if (paramInt <= i2 - 25) {
            break label576;
          }
          i1 = 1;
        }
      }
      for (;;)
      {
        if ((i2 == 1) || (i1 == 0) || (this.jdField_a_of_type_Boolean) || (this.jdField_n_of_type_Int == i2)) {
          break label598;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "[onItemSelected] loadMedias: mLastLoadCount=" + this.jdField_n_of_type_Int);
        }
        this.jdField_n_of_type_Int = this.jdField_a_of_type_Ages.a();
        this.jdField_a_of_type_Agft.a(0);
        break;
        label576:
        i1 = 0;
        continue;
        if (paramInt < 25) {
          i1 = 1;
        } else {
          i1 = 0;
        }
      }
      label598:
      break;
      label600:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695497);
      break label196;
      label613:
      if ((((AIOGalleryAdapter.GalleryImageStruct)localObject).a()) || (localDrawable == null) || (!(localDrawable instanceof SkinnableBitmapDrawable))) {
        break label265;
      }
      localObject = this.jdField_a_of_type_Ages.a(paramInt);
      if ((localObject != null) && ((((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFilePicData)))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidAppActivity.getString(2131695500), new Object[] { arof.a(((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.h) }));
        if (((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.h <= aqxg.c()) {
          break label848;
        }
        c(true);
        this.jdField_a_of_type_ComTencentWidgetGallery.b(false);
        this.jdField_a_of_type_ComTencentWidgetGallery.a(false);
      }
      for (;;)
      {
        if ((localObject == null) || (!(((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) || (((AIOImageData)((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_g_of_type_Int != 1)) {
          break label854;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidAppActivity.getString(2131695500), new Object[] { arof.a(((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.h) }));
        if (((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.h <= aqxg.c()) {
          break label856;
        }
        c(true);
        this.jdField_a_of_type_ComTencentWidgetGallery.b(false);
        this.jdField_a_of_type_ComTencentWidgetGallery.a(false);
        break;
        label848:
        c(true);
      }
      label854:
      break label265;
      label856:
      c(true);
      break label265;
      label864:
      if ((paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData))
      {
        a(false);
        this.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    label894:
    this.jdField_a_of_type_Azey.a(null);
  }
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onNetMobile2None");
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onNetMobile2Wifi s=" + paramString);
    }
    if (this.jdField_a_of_type_Ailt != null) {
      this.jdField_a_of_type_Ailt.d(1);
    }
    aggc.a().a();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onNetNone2Mobile s=" + paramString);
    }
    E();
    aggc.a().a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onNetNone2Wifi s=" + paramString);
    }
    aggc.a().a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onNetWifi2Mobile s=" + paramString);
    }
    E();
    aggc.a().a();
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onNetWifi2None");
    }
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramSeekBar = this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (!(paramSeekBar instanceof AIOShortVideoData)) {
        break label127;
      }
      paramSeekBar = (AIOShortVideoData)paramSeekBar;
      if (paramSeekBar.jdField_b_of_type_Int != 0) {
        break label67;
      }
      if (this.jdField_a_of_type_Ailt != null)
      {
        paramInt = (int)(paramInt / 10000.0F * (float)this.jdField_a_of_type_Ailt.b());
        this.jdField_a_of_type_Ailt.c(paramInt);
      }
    }
    label66:
    label67:
    label127:
    while ((!AIOFileVideoData.class.isInstance(paramSeekBar)) || (this.jdField_a_of_type_Ailt == null))
    {
      Object localObject;
      do
      {
        do
        {
          break label66;
          do
          {
            return;
          } while (paramSeekBar.jdField_b_of_type_Int != 1);
          localObject = a();
        } while (localObject == null);
        localObject = ((AIOGalleryAdapter.GalleryImageStruct)localObject).a();
      } while (!(localObject instanceof URLDrawable));
      ((URLDrawable)localObject).seek((int)(paramInt / 10000.0D * paramSeekBar.jdField_a_of_type_Int * 1000.0D));
      return;
    }
    paramInt = (int)(paramInt / 10000.0F * (float)this.jdField_a_of_type_Ailt.b());
    this.jdField_a_of_type_Ailt.c(paramInt);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (this.jdField_a_of_type_Ailt != null) {
      this.jdField_a_of_type_Ailt.n();
    }
  }
  
  public void p()
  {
    if ((this.jdField_a_of_type_Ailt != null) && (this.jdField_a_of_type_Ailt.c())) {
      this.jdField_a_of_type_Ailt.h();
    }
  }
  
  protected void q()
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    for (int i1 = 4356;; i1 = 4)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setSystemUiVisibility(i1);
      return;
    }
  }
  
  public void s()
  {
    q();
    if (this.jdField_a_of_type_Ailt != null) {
      this.jdField_a_of_type_Ailt.j();
    }
  }
  
  public void u()
  {
    if ((this.jdField_a_of_type_Agei.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Agei.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_Agei.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Agei.jdField_f_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryScene", 2, "updateUI selectedItem all gone");
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      a(false);
      return;
    }
    Object localObject1;
    label181:
    Object localObject2;
    int i1;
    if ((this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData))
    {
      localObject1 = this.jdField_a_of_type_Ages.a();
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      a(true);
      if (this.jdField_f_of_type_Boolean)
      {
        this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
        localObject2 = (AIOShortVideoData)this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (((AIOShortVideoData)localObject2).jdField_b_of_type_Int != 0) {
          break label683;
        }
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        i1 = this.jdField_a_of_type_Agft.a(((AIOShortVideoData)localObject2).jdField_f_of_type_Long, ((AIOShortVideoData)localObject2).jdField_f_of_type_Int);
        this.jdField_a_of_type_Ailt.a(8, "");
        if (!((agfq)localObject1).jdField_a_of_type_Agfr.jdField_a_of_type_Boolean) {
          break label364;
        }
        if (QLog.isColorLevel()) {
          QLog.i("AIOGalleryScene", 2, "updateUI selectedItem.longVideoSaving");
        }
        ((agfq)localObject1).jdField_a_of_type_Agfr.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131700436));
        this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
    label322:
    label1363:
    label1626:
    label1635:
    for (;;)
    {
      label1507:
      if ((this.jdField_k_of_type_Int == 4) || (abot.a(this.jdField_g_of_type_Int) == 1032))
      {
        this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
        return;
        this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(0);
        break label181;
        label364:
        if (i1 != -1)
        {
          this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(i1 / 100.0D * 10000.0D));
          this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        else if (((agfq)localObject1).jdField_a_of_type_Agfr.jdField_d_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.i("AIOGalleryScene", 2, "updateUI selectedItem.longVideoBuffering");
          }
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        else if (!((agfq)localObject1).jdField_a_of_type_Agfr.jdField_g_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.i("AIOGalleryScene", 2, "updateUI selectedItem.hasEnterPlaying longVideoDownloading=" + ((agfq)localObject1).jdField_a_of_type_Agfr.jdField_h_of_type_Boolean + " selectedItem.state=" + ((agfq)localObject1).jdField_a_of_type_Agfr + " longVideoGetUrl=" + ((agfq)localObject1).jdField_a_of_type_Agfr.jdField_j_of_type_Boolean);
          }
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (((agfq)localObject1).jdField_a_of_type_Agfr.jdField_h_of_type_Boolean) {
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          }
          if (((agfq)localObject1).jdField_a_of_type_Agfr.jdField_j_of_type_Boolean) {
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          }
        }
        else if (((agfq)localObject1).jdField_a_of_type_Agfr.jdField_k_of_type_Boolean)
        {
          this.jdField_a_of_type_Ailt.a(0, ((AIOShortVideoData)localObject2).a());
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          ((agfq)localObject1).jdField_a_of_type_Agfr.jdField_k_of_type_Boolean = false;
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("AIOGalleryScene", 2, "updateUI selectedItem.else");
          }
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          continue;
          if (((AIOShortVideoData)localObject2).jdField_b_of_type_Int == 1) {
            if (this.jdField_a_of_type_Agei.jdField_c_of_type_Boolean)
            {
              this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            }
            else if (!((agfq)localObject1).jdField_a_of_type_Agfr.jdField_g_of_type_Boolean)
            {
              this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              if (((agfq)localObject1).jdField_a_of_type_Agfr.jdField_i_of_type_Boolean) {
                this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
              }
            }
            else
            {
              this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              continue;
              if ((this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData))
              {
                localObject1 = (AIOImageData)this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                localObject2 = this.jdField_a_of_type_Ages.a();
                this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
                this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
                a(false);
                i1 = this.jdField_a_of_type_Agft.a(((AIOImageData)localObject1).jdField_f_of_type_Long, ((AIOImageData)localObject1).jdField_f_of_type_Int);
                if (((agfq)localObject2).jdField_a_of_type_Agfr.jdField_c_of_type_Boolean)
                {
                  this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
                  this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
                  this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
                  this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
                  this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131700412) + ((agfq)localObject2).jdField_a_of_type_Agfr.jdField_a_of_type_Int + "%");
                  this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                }
                for (;;)
                {
                  if (((AIOImageData)localObject1).jdField_b_of_type_Int != 3) {
                    break label1447;
                  }
                  if (!AIOImageData.class.isInstance(localObject1)) {
                    break;
                  }
                  if (!((AIOImageData)localObject1).jdField_f_of_type_Boolean) {
                    break label322;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("AIOGalleryScene", 2, "troop show pic file, file is progressive");
                  }
                  this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
                  this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
                  this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
                  this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
                  this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131700443) + ((agfq)localObject2).jdField_a_of_type_Agfr.jdField_a_of_type_Int + "%");
                  this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                  if (this.jdField_a_of_type_Ageh != null) {
                    break label322;
                  }
                  this.jdField_a_of_type_Ageh = new ageh(this);
                  this.jdField_a_of_type_Ageh.jdField_a_of_type_Long = ((AIOImageData)localObject1).jdField_f_of_type_Long;
                  this.jdField_a_of_type_Ageh.jdField_a_of_type_Int = ((AIOImageData)localObject1).jdField_f_of_type_Int;
                  this.jdField_a_of_type_Ages.a().jdField_a_of_type_Agfr.jdField_c_of_type_Boolean = true;
                  ((AIOImageData)localObject1).jdField_f_of_type_Boolean = false;
                  break label322;
                  if (((agfq)localObject2).jdField_a_of_type_Agfr.jdField_e_of_type_Boolean)
                  {
                    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
                    this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
                    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
                    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
                    this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131700400));
                    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                    ((agfq)localObject2).jdField_a_of_type_Agfr.jdField_e_of_type_Boolean = false;
                  }
                  else if ((i1 != -1) && (!((agfq)localObject2).jdField_a_of_type_Agfr.jdField_f_of_type_Boolean))
                  {
                    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
                    this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
                    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
                    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(i1 / 100.0D * 10000.0D));
                    this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131700413) + i1 + "%");
                    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                  }
                  else
                  {
                    if (this.jdField_f_of_type_Boolean)
                    {
                      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
                      if ((!((AIOImageData)localObject1).a(4)) || (((AIOImageData)localObject1).a(4) != null)) {
                        break label1430;
                      }
                      c(true);
                    }
                    for (;;)
                    {
                      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
                      if ((((AIOImageData)localObject1).a(2) == null) && (((AIOImageData)localObject1).a(4) == null)) {
                        break label1438;
                      }
                      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(true);
                      break;
                      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(0);
                      break label1363;
                      c(false);
                    }
                    this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
                  }
                }
              }
              else if ((this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFilePicData))
              {
                localObject1 = (AIOFilePicData)this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
                if (((AIOFilePicData)localObject1).jdField_a_of_type_Long > 10485760)
                {
                  this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
                  if (!arof.b(((AIOFilePicData)localObject1).jdField_d_of_type_JavaLangString)) {
                    break label1615;
                  }
                  this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
                  label1526:
                  if (!this.jdField_f_of_type_Boolean) {
                    break label1626;
                  }
                  this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
                }
                for (;;)
                {
                  if (!((AIOFilePicData)localObject1).jdField_f_of_type_Boolean) {
                    break label1635;
                  }
                  c(false);
                  this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
                  this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
                  break;
                  if ((((AIOFilePicData)localObject1).a(18) != null) || (((AIOFilePicData)localObject1).a(20) != null))
                  {
                    this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(true);
                    break label1507;
                  }
                  this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
                  break label1507;
                  this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
                  break label1526;
                  this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(0);
                }
              }
              else if ((this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData))
              {
                localObject1 = (AIOFileVideoData)this.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                this.jdField_a_of_type_Ailt.a(8, "");
                this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
                a(true);
                if ((((AIOFileVideoData)localObject1).jdField_c_of_type_Boolean) || (((AIOFileVideoData)localObject1).a()))
                {
                  this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(0);
                  this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
                  this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                }
                if (((AIOFileVideoData)localObject1).b())
                {
                  this.jdField_a_of_type_Ailt.a(0, ((AIOFileVideoData)localObject1).a());
                  this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                }
                if (((AIOFileVideoData)localObject1).jdField_d_of_type_Boolean)
                {
                  this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                  if (((AIOFileVideoData)localObject1).a()) {
                    break label1847;
                  }
                  this.jdField_a_of_type_Ailt.b(8);
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label683:
      label1615:
      if (!this.jdField_a_of_type_Ages.a().jdField_a_of_type_Agfr.jdField_g_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      label1430:
      label1438:
      label1447:
      if (this.jdField_k_of_type_Int != 3) {
        break label322;
      }
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
      break label322;
      break;
      label1847:
      this.jdField_a_of_type_Ailt.b(0);
    }
  }
  
  public void v() {}
  
  @TargetApi(11)
  public void w()
  {
    if ((this.t) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Ages.b());
    }
  }
  
  protected void x()
  {
    if (this.jdField_k_of_type_Int == 2) {}
    for (int i1 = 1; this.jdField_j_of_type_Boolean; i1 = 0)
    {
      this.jdField_l_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidAppActivity.onBackPressed();
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatHistoryActivity.class);
    localIntent.addFlags(536870912);
    localIntent.putExtra("tab_tab_type", 0);
    localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("SissionUin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_g_of_type_Int);
    localIntent.putExtra("extra.IS_FROM_CHAT_AIO_GALLERY", true);
    localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", ((agfq)this.jdField_a_of_type_Zec.a()).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
    localIntent.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getString(2131690884));
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", true);
    if (i1 == 0) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772287, 2130772228);
  }
  
  public void y()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetGallery == null) || (this.jdField_a_of_type_Ages == null)) {}
    do
    {
      int i1;
      int i2;
      int i3;
      do
      {
        return;
        i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
        i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
        i3 = this.jdField_a_of_type_Ages.b();
      } while ((i3 < i1) || (i3 > i2 + i1 - 1));
      View localView = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i3 - i1);
      if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(localView))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(i3, (AIOGalleryAdapter.GalleryImageStruct)localView);
        return;
      }
    } while (this.jdField_a_of_type_Ailt == null);
    this.jdField_a_of_type_Ailt.l();
  }
  
  public void z()
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Ages.c() == 0)
    {
      awfb.b(false);
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131693121, 0).a();
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(true);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = true;
      int i1 = this.jdField_a_of_type_Ages.b();
      if (i1 == this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedItemPosition()) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(i1);
      return;
      awfb.b(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdi
 * JD-Core Version:    0.7.0.1
 */