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
import android.os.RemoteException;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.device.msg.activities.AIODevLittleVideoData;
import com.tencent.image.NativeVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.image.VideoDrawable;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.GalleryImageStruct;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.15;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.2;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.20;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.21;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.27;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.28;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.3;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.31;
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
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AdapterView;
import com.tencent.widget.DragView;
import com.tencent.widget.Gallery;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class aibr
  extends abjp
  implements aibq, akqv, aksm, akso, View.OnClickListener, SeekBar.OnSeekBarChangeListener, bljd, INetInfoHandler
{
  final int jdField_a_of_type_Int = -3321;
  long jdField_a_of_type_Long = 0L;
  aicq jdField_a_of_type_Aicq;
  protected aicr a;
  public aicx a;
  public aidz a;
  public aksn a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new aicl(this);
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public SeekBar a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqgi jdField_a_of_type_Aqgi;
  bdcy jdField_a_of_type_Bdcy;
  bjbh jdField_a_of_type_Bjbh;
  bjgf jdField_a_of_type_Bjgf;
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
  boolean jdField_f_of_type_Boolean = false;
  int g;
  public String g;
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
  
  public aibr(Activity paramActivity, abjt paramabjt, aidz paramaidz, String paramString)
  {
    super(paramActivity, paramabjt);
    this.jdField_i_of_type_Boolean = false;
    this.jdField_i_of_type_Int = 5;
    this.jdField_k_of_type_Int = -1;
    this.jdField_a_of_type_Aksn = new aksp();
    this.jdField_a_of_type_Aicr = new aicr(this);
    this.jdField_a_of_type_JavaLangRunnable = new AIOGalleryScene.2(this);
    this.jdField_b_of_type_JavaLangRunnable = new AIOGalleryScene.3(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new aicm(this);
    this.jdField_a_of_type_Aicx = ((aicx)paramabjt);
    this.jdField_a_of_type_Aidz = paramaidz;
    ((aksp)this.jdField_a_of_type_Aksn).a(paramaidz);
    this.jdField_b_of_type_JavaLangString = paramString;
    if ((paramString == null) && (PeakActivity.class.isInstance(paramActivity))) {
      this.jdField_b_of_type_JavaLangString = bplg.a().getCurrentAccountUin();
    }
    paramabjt = (PeakAppInterface)((PeakActivity)paramActivity).getAppRuntime();
    if (paramabjt != null) {
      ((aocp)paramabjt.a(2)).a(paramActivity);
    }
  }
  
  private void F()
  {
    Object localObject = this.jdField_a_of_type_Aicx.a();
    if ((localObject != null) && (this.jdField_a_of_type_Aidz.asBinder().pingBinder()))
    {
      this.jdField_a_of_type_Aicq = new aicq(this);
      this.jdField_a_of_type_Aicq.jdField_a_of_type_Long = ((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long;
      this.jdField_a_of_type_Aicq.jdField_a_of_type_Int = ((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int;
      if (!AIOImageData.class.isInstance(((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        break label118;
      }
      ((aidw)localObject).jdField_a_of_type_Aidx.jdField_c_of_type_Boolean = true;
      u();
      this.jdField_a_of_type_Aidz.a(this.jdField_a_of_type_Aicq.jdField_a_of_type_Long, this.jdField_a_of_type_Aicq.jdField_a_of_type_Int, 4);
    }
    label118:
    while (!AIOFilePicData.class.isInstance(((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
      return;
    }
    if (!bhnv.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131693371), 0).a();
      this.jdField_a_of_type_Aicq = null;
      u();
      return;
    }
    localObject = (AIOFilePicData)((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if (((AIOFilePicData)localObject).jdField_d_of_type_Boolean)
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692472), 0).a();
      u();
      this.jdField_a_of_type_Aicq = null;
      return;
    }
    if (((AIOFilePicData)localObject).jdField_e_of_type_Boolean) {
      u();
    }
    long l1 = atyt.a();
    if ((((AIOFilePicData)localObject).jdField_a_of_type_Long > l1) && (aunj.a())) {
      try
      {
        aunj.a(false, this.jdField_a_of_type_AndroidAppActivity, new aibs(this));
        return;
      }
      catch (Throwable localThrowable)
      {
        return;
      }
    }
    a(true);
    this.jdField_a_of_type_Aidz.a(this.jdField_a_of_type_Aicq.jdField_a_of_type_Long, this.jdField_a_of_type_Aicq.jdField_a_of_type_Int, 20);
    this.jdField_a_of_type_ComTencentWidgetGallery.b(true);
    this.jdField_a_of_type_ComTencentWidgetGallery.a(true);
  }
  
  private void G()
  {
    if (this.jdField_a_of_type_Aksn != null)
    {
      localObject = this.jdField_a_of_type_Aicx.a();
      if (localObject != null)
      {
        if (!AIOFileVideoData.class.isInstance(((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          break label63;
        }
        ((AIOFileVideoData)((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Aksn.c();
        this.jdField_a_of_type_Aksn.e();
        e();
      }
    }
    label63:
    do
    {
      do
      {
        return;
        if (!AIOShortVideoData.class.isInstance(((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          break;
        }
        localObject = (AIOShortVideoData)((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (((AIOShortVideoData)localObject).jdField_b_of_type_Int == 0)
        {
          if (this.jdField_a_of_type_Aidz != null) {
            this.jdField_a_of_type_Aidz.b(((AIOShortVideoData)localObject).jdField_f_of_type_Long, ((AIOShortVideoData)localObject).jdField_f_of_type_Int, 256);
          }
          u();
          return;
        }
      } while (((AIOShortVideoData)localObject).jdField_b_of_type_Int != 1);
      this.jdField_a_of_type_Aicr.jdField_c_of_type_Boolean = false;
      u();
      return;
      if (AIOImageData.class.isInstance(((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        AIOImageData localAIOImageData = (AIOImageData)((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (((aidw)localObject).jdField_a_of_type_Aidx.jdField_c_of_type_Boolean)
        {
          if (this.jdField_a_of_type_Aidz != null) {
            this.jdField_a_of_type_Aidz.b(this.jdField_a_of_type_Aicq.jdField_a_of_type_Long, this.jdField_a_of_type_Aicq.jdField_a_of_type_Int, 4);
          }
          ((aidw)localObject).jdField_a_of_type_Aidx.jdField_c_of_type_Boolean = false;
        }
        for (;;)
        {
          u();
          return;
          if (this.jdField_a_of_type_Aidz != null) {
            this.jdField_a_of_type_Aidz.b(localAIOImageData.jdField_f_of_type_Long, localAIOImageData.jdField_f_of_type_Int, 24);
          }
          ((aidw)localObject).jdField_a_of_type_Aidx.jdField_f_of_type_Boolean = true;
        }
      }
    } while (!AIOFilePicData.class.isInstance(((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
    Object localObject = (AIOFilePicData)((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if (this.jdField_a_of_type_Aidz != null) {
      this.jdField_a_of_type_Aidz.b(((AIOFilePicData)localObject).jdField_f_of_type_Long, ((AIOFilePicData)localObject).jdField_f_of_type_Int, 24);
    }
    ((AIOFilePicData)localObject).jdField_f_of_type_Boolean = false;
    a(false);
    u();
  }
  
  private void H()
  {
    boolean bool = true;
    Object localObject = this.jdField_a_of_type_Aicx.a();
    long l1;
    if (this.jdField_a_of_type_Aksn != null)
    {
      l1 = this.jdField_a_of_type_Aksn.a();
      if ((localObject == null) || (!(((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData))) {
        break label192;
      }
      localObject = (AIOShortVideoData)((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (this.jdField_a_of_type_Bjgf != null) {
        this.jdField_a_of_type_Bjgf.b();
      }
      this.jdField_a_of_type_Bjgf = new bjgf(this.jdField_a_of_type_AndroidAppActivity);
      akss localakss = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a((AIOShortVideoData)localObject);
      if (localakss == null) {
        break label181;
      }
      this.jdField_a_of_type_Bjgf.a(localakss, ((AIOShortVideoData)localObject).jdField_a_of_type_Long, l1);
      this.jdField_a_of_type_Bjgf.a(((AIOShortVideoData)localObject).jdField_a_of_type_JavaLangString, ((AIOShortVideoData)localObject).jdField_c_of_type_Int, ((AIOShortVideoData)localObject).jdField_d_of_type_Int);
      if (((AIOShortVideoData)localObject).jdField_c_of_type_Int <= ((AIOShortVideoData)localObject).jdField_d_of_type_Int) {
        break label176;
      }
      bool = true;
      label149:
      if (this.jdField_a_of_type_Bjgf.a(bool, ((AIOShortVideoData)localObject).jdField_g_of_type_Int)) {
        e();
      }
    }
    for (;;)
    {
      return;
      l1 = 0L;
      break;
      label176:
      bool = false;
      break label149;
      label181:
      QLog.d("AIOGalleryScene", 1, "Failed to floating, videoPlayMedioInfo is null");
      return;
      label192:
      if ((localObject != null) && ((((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData)))
      {
        localObject = (AIOFileVideoData)((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (zom.c(((AIOFileVideoData)localObject).jdField_c_of_type_JavaLangString))
        {
          if (this.jdField_a_of_type_Bjgf != null) {
            this.jdField_a_of_type_Bjgf.b();
          }
          this.jdField_a_of_type_Bjgf = new bjgf(this.jdField_a_of_type_AndroidAppActivity);
          this.jdField_a_of_type_Bjgf.a(((AIOFileVideoData)localObject).jdField_c_of_type_JavaLangString, ((AIOFileVideoData)localObject).jdField_f_of_type_Long, l1);
          if (bhmi.b(((AIOFileVideoData)localObject).jdField_b_of_type_JavaLangString)) {
            this.jdField_a_of_type_Bjgf.a(((AIOFileVideoData)localObject).jdField_b_of_type_JavaLangString, ((AIOFileVideoData)localObject).jdField_a_of_type_Int, ((AIOFileVideoData)localObject).jdField_b_of_type_Int);
          }
          if (((AIOFileVideoData)localObject).jdField_a_of_type_Int > ((AIOFileVideoData)localObject).jdField_b_of_type_Int) {}
          while (this.jdField_a_of_type_Bjgf.a(bool, ((AIOFileVideoData)localObject).jdField_g_of_type_Int))
          {
            e();
            return;
            bool = false;
          }
        }
      }
    }
  }
  
  private void I()
  {
    this.jdField_c_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_c_of_type_AndroidWidgetImageButton.setContentDescription(anzj.a(2131698946));
    this.jdField_c_of_type_AndroidWidgetImageButton.setId(2131374353);
    this.jdField_c_of_type_AndroidWidgetImageButton.setImageResource(2130846241);
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
  
  private void J()
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
  
  private void K()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    int i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
    int i3 = this.jdField_a_of_type_Aicx.b();
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
    Object localObject = this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
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
  
  private int a(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if ((paramInt == 1004) || (paramInt == 1008) || (paramInt == 1009) || (paramInt == 1010) || (paramInt == 1011) || (paramInt == 1020) || (paramInt == 1021) || (paramInt == 1022) || (paramInt == 1023) || (paramInt == 1024) || (paramInt == 1025) || (paramInt == 1036) || (paramInt == 10002) || (paramInt == 10003) || (paramInt == 10004)) {
      return 3;
    }
    return 4;
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
  
  private <T extends aidw> T a(long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.jdField_a_of_type_Aicx.a().iterator();
    while (localIterator.hasNext())
    {
      aidw localaidw = (aidw)localIterator.next();
      if ((localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramLong1) && (localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int == paramLong2)) {
        return localaidw;
      }
    }
    return null;
  }
  
  private bjbh a(Context paramContext)
  {
    bjbh localbjbh = new bjbh(paramContext);
    localbjbh.a(agej.a(50.0F, paramContext.getResources()));
    localbjbh.a(true);
    localbjbh.c(false);
    localbjbh.g(-1);
    localbjbh.f(0);
    localbjbh.d(-15550475);
    localbjbh.i(3);
    localbjbh.jdField_f_of_type_Boolean = true;
    localbjbh.jdField_f_of_type_Int = 2;
    localbjbh.e(true);
    localbjbh.a(new aich(this));
    return localbjbh;
  }
  
  private AIOGalleryAdapter.GalleryImageStruct a()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    int i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
    int i3 = this.jdField_a_of_type_Aicx.b();
    if ((i3 >= i1) && (i3 <= i2 + i1 - 1))
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i3 - i1);
      if ((localView instanceof AIOGalleryAdapter.GalleryImageStruct)) {
        return (AIOGalleryAdapter.GalleryImageStruct)localView;
      }
    }
    return null;
  }
  
  private File a(AIORichMediaData paramAIORichMediaData)
  {
    Object localObject1 = null;
    Object localObject2;
    if ((paramAIORichMediaData instanceof AIOImageData))
    {
      localObject1 = paramAIORichMediaData.a(4);
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramAIORichMediaData.a(2);
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramAIORichMediaData.a(1);
      }
    }
    do
    {
      do
      {
        return localObject1;
      } while (!(paramAIORichMediaData instanceof AIOFilePicData));
      localObject1 = paramAIORichMediaData.a(20);
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramAIORichMediaData.a(18);
      }
      localObject1 = localObject2;
    } while (localObject2 != null);
    return paramAIORichMediaData.a(16);
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
        bdll.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
      }
      localObject1 = (PeakActivity)this.jdField_a_of_type_AndroidAppActivity;
      if (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "save video failed, intent is null");
      }
      QQToast.a((Context)localObject1, 1, anzj.a(2131698965), 0).a();
      return;
      localObject1 = "0X8007A24";
      continue;
      localObject1 = "0X8007A25";
    }
    NativeVideoImage.pauseAll();
    paramInt = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
    int i2 = this.jdField_a_of_type_Aicx.b();
    if ((i2 >= paramInt) && (i2 <= i1 + paramInt - 1))
    {
      localObject2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i2 - paramInt);
      if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(localObject2)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(i2, (AIOGalleryAdapter.GalleryImageStruct)localObject2);
      }
    }
    Object localObject2 = ShortVideoUtils.c();
    a((Activity)localObject1, anzj.a(2131698964), false, 0);
    if (zom.a(BaseApplication.getContext(), paramFile.getAbsolutePath(), (String)localObject2)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(10000);
    }
    for (;;)
    {
      bdll.b(null, "CliOper", "", "", "0X800610F", "0X800610F", 0, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(10001);
    }
  }
  
  private void a(long paramLong, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if ((((AIORichMediaData)localObject).jdField_f_of_type_Long == paramLong) && (((AIORichMediaData)localObject).jdField_f_of_type_Int == paramInt)) {
      if ((this.jdField_a_of_type_AndroidWidgetSeekBar != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131698955) + this.jdField_h_of_type_Int / 100.0D + "%");
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.jdField_h_of_type_Int);
      }
    }
    do
    {
      return;
      localObject = a(paramLong, paramInt);
    } while (localObject == null);
    ((aidw)localObject).jdField_a_of_type_Aidx.jdField_a_of_type_Int = this.jdField_h_of_type_Int;
  }
  
  private void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if ((((AIORichMediaData)localObject).jdField_f_of_type_Long == paramLong1) && (((AIORichMediaData)localObject).jdField_f_of_type_Int == paramInt1))
    {
      this.jdField_a_of_type_Aicx.a().jdField_a_of_type_Int = paramInt3;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131698949) + auog.a((paramLong2 * (paramInt3 / 10000.0D))) + "/" + auog.a(paramLong2) + ")");
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(paramInt3);
    }
    do
    {
      return;
      localObject = a(paramLong1, paramInt1);
    } while (localObject == null);
    ((aidw)localObject).jdField_a_of_type_Int = paramInt3;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AIORichMediaData localAIORichMediaData = this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if ((localAIORichMediaData.jdField_f_of_type_Long == paramLong) && (localAIORichMediaData.jdField_f_of_type_Int == paramInt1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "save pic result = " + paramInt3 + ", resultStr = " + paramString);
      }
      if (paramInt3 == 1)
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131717539), 0).a();
        u();
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Aicq != null) && (this.jdField_a_of_type_Aicq.jdField_a_of_type_Long == paramLong) && (this.jdField_a_of_type_Aicq.jdField_a_of_type_Int == paramInt1)) {
        this.jdField_a_of_type_Aicq = null;
      }
      return;
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131717535), 0).a();
      break;
      paramString = a(paramLong, paramInt1);
      if (paramString != null) {
        paramString.jdField_a_of_type_Aidx.jdField_e_of_type_Boolean = false;
      }
    }
  }
  
  private void a(long paramLong, int paramInt, String paramString)
  {
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_Aicx.a())
    {
      aidw localaidw = this.jdField_a_of_type_Aicx.a(i1);
      if ((localaidw == null) || (localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null) || (!AIOFileVideoData.class.isInstance(localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {}
      AIOFileVideoData localAIOFileVideoData;
      do
      {
        i1 += 1;
        break;
        localAIOFileVideoData = (AIOFileVideoData)localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      } while (localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != paramLong);
      if (paramInt == 1)
      {
        localAIOFileVideoData.jdField_c_of_type_Boolean = true;
        localAIOFileVideoData.jdField_d_of_type_Boolean = false;
        localAIOFileVideoData.jdField_c_of_type_JavaLangString = paramString;
      }
      for (;;)
      {
        u();
        if (this.jdField_a_of_type_Aicx.a() != localaidw) {
          break;
        }
        this.jdField_a_of_type_Aksn.b(0);
        break;
        if (paramInt == 2) {
          localAIOFileVideoData.jdField_c_of_type_Boolean = false;
        }
      }
    }
  }
  
  private void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Aicx.a();
    int i1 = 0;
    for (;;)
    {
      if (i1 < ((List)localObject).size())
      {
        aidw localaidw = (aidw)((List)localObject).get(i1);
        if ((localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != paramLong) || (localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int != paramInt)) {
          break label154;
        }
        localaidw.jdField_a_of_type_Int = this.jdField_h_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(i1, this.jdField_h_of_type_Int / 100);
        if (paramBoolean)
        {
          paramInt = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
          int i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
          if ((i1 >= paramInt) && (i1 <= i2 + paramInt - 1))
          {
            localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i1 - paramInt);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(i1, (View)localObject, paramBoolean);
          }
        }
      }
      return;
      label154:
      i1 += 1;
    }
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    aidw localaidw = this.jdField_a_of_type_Aicx.a();
    if (!AIOFilePicData.class.isInstance(localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {}
    AIOFilePicData localAIOFilePicData;
    do
    {
      return;
      localAIOFilePicData = (AIOFilePicData)localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      localAIOFilePicData.jdField_f_of_type_Boolean = true;
      if (this.jdField_a_of_type_Aicq == null)
      {
        this.jdField_a_of_type_Aicq = new aicq(this);
        this.jdField_a_of_type_Aicq.jdField_a_of_type_Long = localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long;
        this.jdField_a_of_type_Aicq.jdField_a_of_type_Int = localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int;
      }
    } while ((localAIOFilePicData.jdField_f_of_type_Long != paramLong1) || (this.jdField_a_of_type_AndroidWidgetSeekBar == null));
    a(true);
    this.jdField_a_of_type_Aicx.a().jdField_a_of_type_Int = this.jdField_h_of_type_Int;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131698982) + auog.a((paramLong2 * (this.jdField_h_of_type_Int / 10000.0D))) + "/" + auog.a(paramLong2) + ")");
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.jdField_h_of_type_Int);
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Aicx.a();
    int i1 = 0;
    for (;;)
    {
      if (i1 < ((List)localObject).size())
      {
        aidw localaidw = (aidw)((List)localObject).get(i1);
        if (localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != paramLong) {
          break label144;
        }
        localaidw.jdField_a_of_type_Int = this.jdField_h_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(i1, this.jdField_h_of_type_Int / 100);
        if (paramBoolean)
        {
          int i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
          int i3 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
          if ((i1 >= i2) && (i1 <= i3 + i2 - 1))
          {
            localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i1 - i2);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(i1, (View)localObject, paramBoolean);
          }
        }
      }
      return;
      label144:
      i1 += 1;
    }
  }
  
  private void a(aidw paramaidw)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    a(true);
    AIOShortVideoData localAIOShortVideoData;
    int i1;
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
      localAIOShortVideoData = (AIOShortVideoData)this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (localAIOShortVideoData.jdField_b_of_type_Int != 0) {
        break label511;
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      i1 = this.jdField_a_of_type_Aidz.a(localAIOShortVideoData.jdField_f_of_type_Long, localAIOShortVideoData.jdField_f_of_type_Int);
      this.jdField_a_of_type_Aksn.a(8, "");
      if (!paramaidw.jdField_a_of_type_Aidx.jdField_a_of_type_Boolean) {
        break label202;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryScene", 2, "updateUI selectedItem.longVideoSaving");
      }
      paramaidw.jdField_a_of_type_Aidx.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131698981));
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    label202:
    label511:
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(0);
          break;
          if (i1 != -1)
          {
            this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(i1 / 100.0D * 10000.0D));
            this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            return;
          }
          if (paramaidw.jdField_a_of_type_Aidx.jdField_d_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.i("AIOGalleryScene", 2, "updateUI selectedItem.longVideoBuffering");
            }
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            return;
          }
          if (paramaidw.jdField_a_of_type_Aidx.jdField_g_of_type_Boolean) {
            break label437;
          }
          if (QLog.isColorLevel()) {
            QLog.i("AIOGalleryScene", 2, "updateUI selectedItem.hasEnterPlaying longVideoDownloading=" + paramaidw.jdField_a_of_type_Aidx.jdField_h_of_type_Boolean + " selectedItem.state=" + paramaidw.jdField_a_of_type_Aidx + " longVideoGetUrl=" + paramaidw.jdField_a_of_type_Aidx.jdField_j_of_type_Boolean);
          }
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (paramaidw.jdField_a_of_type_Aidx.jdField_h_of_type_Boolean) {
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          }
        } while (!paramaidw.jdField_a_of_type_Aidx.jdField_j_of_type_Boolean);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        return;
        if (paramaidw.jdField_a_of_type_Aidx.jdField_k_of_type_Boolean)
        {
          this.jdField_a_of_type_Aksn.a(0, localAIOShortVideoData.a());
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          paramaidw.jdField_a_of_type_Aidx.jdField_k_of_type_Boolean = false;
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("AIOGalleryScene", 2, "updateUI selectedItem.else");
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        return;
      } while (localAIOShortVideoData.jdField_b_of_type_Int != 1);
      if (this.jdField_a_of_type_Aicr.jdField_c_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
      }
      if (paramaidw.jdField_a_of_type_Aidx.jdField_g_of_type_Boolean) {
        break label594;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    } while (!paramaidw.jdField_a_of_type_Aidx.jdField_i_of_type_Boolean);
    label437:
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    return;
    label594:
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  private void a(aidw paramaidw, File paramFile)
  {
    try
    {
      paramaidw = this.jdField_a_of_type_Aidz.a(paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int);
      if (paramaidw == null) {
        bmko.b(paramFile.getAbsolutePath()).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaLangString);
      }
      for (;;)
      {
        bmky.a(null, 40, 3);
        return;
        new bmko(paramaidw).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaLangString);
      }
      return;
    }
    catch (RemoteException paramaidw)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AIOGalleryScene", 2, "", paramaidw);
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), this.jdField_a_of_type_AndroidAppActivity.getString(2131692519), 0).a();
    }
  }
  
  private void a(aidw paramaidw, String paramString1, String[] paramArrayOfString, String paramString2, View paramView)
  {
    AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if (localAIOFileVideoData.jdField_a_of_type_Boolean) {
      QLog.i("VideoPlayControllerForFile", 1, "filevideo is playing:" + paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
    }
    int i1;
    for (;;)
    {
      return;
      localAIOFileVideoData.jdField_a_of_type_Boolean = true;
      if ("I:E".equals(paramString1)) {
        try
        {
          localAIOFileVideoData.jdField_b_of_type_Long = Long.parseLong(paramArrayOfString[0]);
          paramString1 = paramArrayOfString[1];
          localAIOFileVideoData.a(paramString1);
          i1 = 0;
          if (localAIOFileVideoData.jdField_b_of_type_Long == -134L)
          {
            paramaidw = this.jdField_a_of_type_AndroidAppActivity.getString(2131718233);
            i1 = 1;
            label117:
            if (i1 != 0)
            {
              paramaidw = bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230, "", paramaidw, null, anzj.a(2131698959), new aici(this), null);
              if (paramaidw.isShowing()) {
                continue;
              }
              paramaidw.show();
              return;
            }
          }
        }
        catch (NumberFormatException paramaidw)
        {
          localAIOFileVideoData.jdField_b_of_type_Long = -1L;
          localAIOFileVideoData.jdField_g_of_type_JavaLangString = paramArrayOfString[1];
        }
      }
    }
    for (;;)
    {
      paramaidw = localAIOFileVideoData.a(this.q);
      this.jdField_a_of_type_Aksn.a(paramView, paramaidw);
      if ((!AIOGalleryActivity.class.isInstance(this.jdField_a_of_type_AndroidAppActivity)) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(localAIOFileVideoData.jdField_f_of_type_Long))) {
        break;
      }
      ((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_Aksn.b();
      this.jdField_a_of_type_Aksn.f();
      this.q = false;
      return;
      if (localAIOFileVideoData.jdField_b_of_type_Long != -7003L)
      {
        long l1 = localAIOFileVideoData.jdField_b_of_type_Long;
        paramaidw = paramString1;
        if (l1 != -6101L) {
          break label117;
        }
      }
      i1 = 1;
      paramaidw = paramString1;
      break label117;
      localAIOFileVideoData.jdField_d_of_type_JavaLangString = paramArrayOfString[0];
      localAIOFileVideoData.jdField_f_of_type_JavaLangString = paramString1;
      localAIOFileVideoData.jdField_e_of_type_JavaLangString = paramString2;
    }
  }
  
  private void a(aidw paramaidw, boolean paramBoolean)
  {
    if ((paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData)) {
      if ((this.jdField_a_of_type_Aksn != null) && (this.jdField_a_of_type_Aksn.c())) {
        this.jdField_a_of_type_Aksn.h();
      }
    }
    label202:
    do
    {
      int i1;
      int i2;
      do
      {
        Drawable localDrawable;
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!(paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)) {
                  break label202;
                }
                paramaidw = (AIOShortVideoData)paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                if (paramaidw.jdField_b_of_type_Int != 0) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("AIOGalleryScene", 2, "onRevokeMsg BUSI_TYPE_VIDEO");
                }
                if (paramBoolean)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("AIOGalleryScene", 2, "onRevokeMsg cancelDownloadMedia");
                  }
                  this.jdField_a_of_type_Aidz.b(paramaidw.jdField_f_of_type_Long, paramaidw.jdField_f_of_type_Int, 256);
                }
              } while ((this.jdField_a_of_type_Aksn == null) || (!this.jdField_a_of_type_Aksn.c()));
              this.jdField_a_of_type_Aksn.h();
              return;
            } while (paramaidw.jdField_b_of_type_Int != 1);
            paramaidw = a();
          } while (paramaidw == null);
          localDrawable = paramaidw.a();
        } while (!(localDrawable instanceof URLDrawable));
        i1 = ((URLDrawable)localDrawable).getPlayState();
        i2 = this.jdField_a_of_type_Aicx.b();
      } while (i1 != 2);
      paramaidw.b(i2);
      return;
    } while ((!(paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) || (!paramBoolean));
    this.jdField_a_of_type_Aidz.b(paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int, 24);
  }
  
  private void a(aidw paramaidw, String[] paramArrayOfString, String paramString, View paramView, MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "carverW notifyVideoUrl setShortVideoDrawableWithUrls ,AIOShortVideoData id=" + paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
    }
    aiei.a().a(paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, paramArrayOfString, System.currentTimeMillis(), paramMessageForShortVideo, paramInt, paramString);
    paramString = new akss();
    paramString.jdField_a_of_type_Boolean = true;
    paramString.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    paramString.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    paramString.jdField_a_of_type_Int = paramInt;
    paramString.jdField_a_of_type_Long = paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long;
    paramString.jdField_b_of_type_Int = paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int;
    paramArrayOfString = new File(((AIOShortVideoData)paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
    if (paramArrayOfString.exists())
    {
      paramString.d = paramArrayOfString.length();
      if (this.q)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "setShortVideoDrawableWithUrls, dataOfBubble.id =  " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long + ", msg.uniseq = " + paramMessageForShortVideo.uniseq + ", mIsmute = " + this.q);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramMessageForShortVideo.uniseq))
        {
          paramString.jdField_e_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d("AIOGalleryScene", 2, "setShortVideoDrawableWithUrls, set playMedioInfo.isMute =  " + this.q);
          }
        }
      }
      this.jdField_a_of_type_Aksn.a(paramView, paramString);
      paramArrayOfString = (AIOShortVideoData)paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(((AIOShortVideoData)paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_a_of_type_Long)) {
        break label405;
      }
      this.jdField_a_of_type_Aksn.f();
      this.jdField_a_of_type_Aksn.a((AIOShortVideoData)paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, false, false);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Aidz != null) && (paramArrayOfString.a(0) == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "setShortVideoDrawableWithUrls, get THUMB");
        }
        this.jdField_a_of_type_Aidz.a(paramArrayOfString.jdField_f_of_type_Long, paramArrayOfString.jdField_f_of_type_Int, 0);
      }
      return;
      paramString.d = 0L;
      break;
      label405:
      this.jdField_a_of_type_Aksn.a((AIOShortVideoData)paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, false, true);
    }
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
    Object localObject = agej.a(localIntent, null);
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
    Intent localIntent = agej.a(new Intent(paramActivity, SplashActivity.class), null);
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
        i1 = zxx.a((Bitmap)localObject1, true, 3, localSparseArray) | 0x0;
        if (QLog.isColorLevel()) {
          QLog.i("AIOGalleryScene", 2, String.format("checkQQCode bmp!=null result=%d", new Object[] { Integer.valueOf(i1) }));
        }
        if (localObject1 == null)
        {
          i2 = zxx.a(paramUri, this.jdField_a_of_type_AndroidAppActivity, 3, localSparseArray);
          i1 = i2;
          if (QLog.isColorLevel())
          {
            QLog.i("AIOGalleryScene", 2, String.format("checkQQCode bmp=null result=%d", new Object[] { Integer.valueOf(i2) }));
            i1 = i2;
          }
        }
        ThreadManager.getUIHandler().post(new AIOGalleryScene.21(this, i1, localSparseArray, paramArrayList));
        if (i1 > 0) {
          this.jdField_f_of_type_JavaLangString = paramUri.getPath();
        }
        apra.b(i1);
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
  
  private void a(View paramView)
  {
    paramView = (ImageView)paramView;
    if ((this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)) {
      if (((AIOShortVideoData)this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Int == 0) {
        if (this.jdField_a_of_type_Aksn != null)
        {
          this.jdField_a_of_type_Aksn.f();
          if (!this.jdField_a_of_type_Aksn.c()) {
            break label87;
          }
          paramView.setImageResource(2130846132);
          this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
        }
      }
    }
    label87:
    while ((!(this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData)) || (this.jdField_a_of_type_Aksn == null))
    {
      AIOGalleryAdapter.GalleryImageStruct localGalleryImageStruct;
      int i1;
      int i2;
      do
      {
        Drawable localDrawable;
        do
        {
          do
          {
            for (;;)
            {
              return;
              paramView.setImageResource(2130846131);
            }
            localGalleryImageStruct = a();
          } while (localGalleryImageStruct == null);
          localDrawable = localGalleryImageStruct.a();
        } while (!(localDrawable instanceof URLDrawable));
        i1 = ((URLDrawable)localDrawable).getPlayState();
        i2 = this.jdField_a_of_type_Aicx.b();
        if (i1 == 2)
        {
          localGalleryImageStruct.b(i2);
          paramView.setImageResource(2130846131);
          localGalleryImageStruct.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        }
        if (i1 == 4)
        {
          localGalleryImageStruct.b(i2);
          paramView.setImageResource(2130846132);
          localGalleryImageStruct.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
        }
        if (i1 == 6)
        {
          localGalleryImageStruct.b(i2);
          localGalleryImageStruct.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView.setImageResource(2130846132);
          return;
        }
      } while (i1 != -1);
      localGalleryImageStruct.b(i2);
      localGalleryImageStruct.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramView.setImageResource(2130846132);
      return;
    }
    this.jdField_a_of_type_Aksn.f();
    if (this.jdField_a_of_type_Aksn.c()) {
      paramView.setImageResource(2130846132);
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
      return;
      paramView.setImageResource(2130846131);
    }
  }
  
  private void a(blir paramblir, AIOImageData paramAIOImageData, File paramFile1, File paramFile2)
  {
    if ((adak.a(this.jdField_g_of_type_Int) == 1032) && (paramFile1 != null)) {
      paramblir.b(2131692968);
    }
    paramblir.c(2131690580);
    paramblir.a(new aiby(this, paramblir, paramAIOImageData, paramFile2));
    paramblir.show();
    paramblir.a(this);
  }
  
  private void a(AIOFilePicData paramAIOFilePicData)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    if (paramAIOFilePicData.jdField_a_of_type_Long > 10485760)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
      if (!auog.b(paramAIOFilePicData.jdField_d_of_type_JavaLangString)) {
        break label134;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      label47:
      if (!this.jdField_g_of_type_Boolean) {
        break label145;
      }
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    for (;;)
    {
      if (paramAIOFilePicData.jdField_f_of_type_Boolean)
      {
        c(false);
        this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      }
      return;
      if ((paramAIOFilePicData.a(18) != null) || (paramAIOFilePicData.a(20) != null))
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(true);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
      break;
      label134:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break label47;
      label145:
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
  }
  
  private void a(AIOFilePicData paramAIOFilePicData, int paramInt)
  {
    Object localObject2 = paramAIOFilePicData.a(20);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramAIOFilePicData.a(18);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramAIOFilePicData.a(16);
    }
    if ((localObject2 == null) && (this.t)) {
      return;
    }
    a(paramAIOFilePicData, (File)localObject2, paramInt);
  }
  
  private void a(AIOFileVideoData paramAIOFileVideoData)
  {
    this.jdField_a_of_type_Aksn.a(8, "");
    this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
    a(true);
    if ((paramAIOFileVideoData.jdField_c_of_type_Boolean) || (paramAIOFileVideoData.a()))
    {
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    if (paramAIOFileVideoData.b())
    {
      this.jdField_a_of_type_Aksn.a(0, paramAIOFileVideoData.a());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (paramAIOFileVideoData.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (paramAIOFileVideoData.a()) {
        break label178;
      }
      this.jdField_a_of_type_Aksn.b(8);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Aicx.a().jdField_a_of_type_Aidx.jdField_g_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if (this.jdField_k_of_type_Int == 3) {
        this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
      }
      return;
      label178:
      this.jdField_a_of_type_Aksn.b(0);
    }
  }
  
  private void a(AIOFileVideoData paramAIOFileVideoData, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(2131692524, 2130840151, 59, localArrayList1);
    a(2131692533, 2130840160, 53, localArrayList1);
    bdll.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
    a(2131692526, 2130844322, 67, localArrayList1);
    a(2131692535, 2130840161, 58, localArrayList1);
    a(2131692523, 2130840150, 57, localArrayList1);
    if ((this.jdField_g_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.r)) {
      a(2131692537, 2130840162, 54, localArrayList2);
    }
    if (auog.b(paramAIOFileVideoData.jdField_c_of_type_JavaLangString)) {
      a(2131692530, 2130840156, 64, localArrayList2, 5);
    }
    a(paramAIOFileVideoData, null, false);
    paramAIOFileVideoData = (List[])new ArrayList[] { localArrayList1, localArrayList2 };
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(paramAIOFileVideoData);
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
  }
  
  private void a(AIOImageData paramAIOImageData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Manager", 2, "action sheet add to favorite.");
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("pic_md5", paramAIOImageData.jdField_f_of_type_JavaLangString);
    paramAIOImageData = new aibu(this);
    QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_add_fav", localBundle, paramAIOImageData);
    if (this.jdField_h_of_type_Boolean) {
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
    }
  }
  
  private void a(AIOImageData paramAIOImageData, int paramInt, aidw paramaidw)
  {
    if ((paramAIOImageData.jdField_g_of_type_Int == 1) && (paramAIOImageData.jdField_h_of_type_Boolean))
    {
      Object localObject = paramAIOImageData.a(4);
      paramaidw = (aidw)localObject;
      if (localObject == null) {
        paramaidw = paramAIOImageData.a(2);
      }
      localObject = paramaidw;
      if (paramaidw == null) {
        localObject = paramAIOImageData.a(1);
      }
      if ((localObject == null) && (this.t)) {
        return;
      }
      a(paramAIOImageData, (File)localObject, paramInt);
      return;
    }
    d(paramaidw);
  }
  
  private void a(AIOImageData paramAIOImageData, aidw paramaidw)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    a(false);
    int i1 = this.jdField_a_of_type_Aidz.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int);
    if (paramaidw.jdField_a_of_type_Aidx.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131698957) + paramaidw.jdField_a_of_type_Aidx.jdField_a_of_type_Int + "%");
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if ((paramAIOImageData.jdField_b_of_type_Int == 3) && (AIOImageData.class.isInstance(paramAIOImageData))) {
        break label450;
      }
    }
    label364:
    do
    {
      do
      {
        return;
        if (paramaidw.jdField_a_of_type_Aidx.jdField_e_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131698945));
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          paramaidw.jdField_a_of_type_Aidx.jdField_e_of_type_Boolean = false;
          break;
        }
        if ((i1 != -1) && (!paramaidw.jdField_a_of_type_Aidx.jdField_f_of_type_Boolean))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(i1 / 100.0D * 10000.0D));
          this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131698958) + i1 + "%");
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          break;
        }
        if (this.jdField_g_of_type_Boolean)
        {
          this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
          if ((!paramAIOImageData.a(4)) || (paramAIOImageData.a(4) != null)) {
            break label431;
          }
          c(true);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
          if ((paramAIOImageData.a(2) == null) && (paramAIOImageData.a(4) == null)) {
            break label439;
          }
          this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(true);
          break;
          this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(0);
          break label364;
          c(false);
        }
        this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
        break;
      } while (!paramAIOImageData.jdField_f_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "troop show pic file, file is progressive");
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131698988) + paramaidw.jdField_a_of_type_Aidx.jdField_a_of_type_Int + "%");
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    } while (this.jdField_a_of_type_Aicq != null);
    label431:
    label439:
    label450:
    this.jdField_a_of_type_Aicq = new aicq(this);
    this.jdField_a_of_type_Aicq.jdField_a_of_type_Long = paramAIOImageData.jdField_f_of_type_Long;
    this.jdField_a_of_type_Aicq.jdField_a_of_type_Int = paramAIOImageData.jdField_f_of_type_Int;
    this.jdField_a_of_type_Aicx.a().jdField_a_of_type_Aidx.jdField_c_of_type_Boolean = true;
    paramAIOImageData.jdField_f_of_type_Boolean = false;
  }
  
  private void a(AIOImageData paramAIOImageData, aidw paramaidw, File paramFile)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(new aicp(this, paramAIOImageData, paramaidw, paramFile));
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setCancelListener(new aibt(this));
  }
  
  private void a(AIORichMediaData paramAIORichMediaData)
  {
    Intent localIntent1;
    if (this.jdField_a_of_type_Aidz.asBinder().pingBinder())
    {
      localIntent1 = this.jdField_a_of_type_Aidz.a(paramAIORichMediaData.jdField_f_of_type_Long, paramAIORichMediaData.jdField_f_of_type_Int, 0);
      if (localIntent1 == null) {
        QLog.w("AIOGalleryScene", 1, "getForwardData return null from main process");
      }
    }
    else
    {
      return;
    }
    localIntent1.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
    if (paramAIORichMediaData.jdField_g_of_type_Int == 1) {}
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      localIntent1.putExtra("filepictest", true);
      paramAIORichMediaData = (ForwardFileInfo)localIntent1.getParcelableExtra("fileinfo");
      String str1 = localIntent1.getStringExtra("forward_filepath");
      boolean bool1 = localIntent1.getBooleanExtra("k_favorites", false);
      String str2 = localIntent1.getStringExtra("forward_text");
      boolean bool2 = localIntent1.getBooleanExtra("isFromShare", false);
      i1 = localIntent1.getIntExtra("forward_type", 0);
      Intent localIntent2 = new Intent();
      localIntent2.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", i1);
      localBundle.putParcelable("fileinfo", paramAIORichMediaData);
      localBundle.putBoolean("not_forward", true);
      localIntent2.putExtras(localBundle);
      localIntent2.putExtra("forward_filepath", str1);
      localIntent2.putExtra("forward_text", str2);
      localIntent2.putExtra("k_favorites", bool1);
      localIntent2.putExtra("isFromShare", bool2);
      if (AIOFilePicData.class.isInstance(localIntent1))
      {
        localIntent2.putExtra("isPic", true);
        localIntent2.putExtra("direct_send_if_dataline_forward", true);
      }
      auxu.a(this.jdField_a_of_type_AndroidAppActivity, localIntent1, 103);
      return;
    }
    auxu.a(this.jdField_a_of_type_AndroidAppActivity, localIntent1, 21);
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, File paramFile)
  {
    if (AIOFilePicData.class.isInstance(paramAIORichMediaData)) {
      aicv.a(this.jdField_a_of_type_AndroidAppActivity, paramFile, Utils.Crc64String(paramFile.getAbsolutePath()));
    }
    do
    {
      return;
      if (AIOFileVideoData.class.isInstance(paramAIORichMediaData))
      {
        paramFile = new Bundle();
        float f1 = 0.0F;
        if (aksp.class.isInstance(this.jdField_a_of_type_Aksn)) {
          f1 = ((aksp)this.jdField_a_of_type_Aksn).a(paramAIORichMediaData.jdField_f_of_type_Long);
        }
        paramFile.putFloat("progress", f1);
        this.jdField_a_of_type_Aidz.a(paramAIORichMediaData.jdField_f_of_type_Long, 13, paramFile);
        ((AIOFileVideoData)paramAIORichMediaData).jdField_d_of_type_Boolean = true;
        this.jdField_a_of_type_Aksn.h();
        u();
        return;
      }
    } while (!AIOImageData.class.isInstance(paramAIORichMediaData));
    if ((paramFile != null) && (paramFile.exists()))
    {
      aicv.a(this.jdField_a_of_type_AndroidAppActivity, paramFile, Utils.Crc64String(paramFile.getAbsolutePath()));
      return;
    }
    QLog.i("AIOGalleryScene", 1, "menu item click, troop file action AIOGallerysence, but file is null");
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, File paramFile, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(2131692524, 2130840151, 59, localArrayList1);
    if ((PicShareToWX.a().a()) && (PicShareToWX.a().a(paramFile))) {
      a(2131692534, 2130846814, 69, localArrayList1);
    }
    a(2131692533, 2130840160, 53, localArrayList1);
    bdll.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
    a(2131692526, 2130844322, 67, localArrayList1);
    a(2131692535, 2130840161, 58, localArrayList1);
    a(2131692523, 2130840150, 57, localArrayList1);
    if ((this.jdField_g_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.r)) {
      a(2131692537, 2130840162, 54, localArrayList2);
    }
    if (this.jdField_f_of_type_Boolean) {
      a(2131692529, 2130840155, 52, localArrayList2, 2);
    }
    ThreadManager.getFileThreadHandler().post(new AIOGalleryScene.20(this, paramFile, localArrayList2));
    a(paramAIORichMediaData, paramFile, true);
    paramAIORichMediaData = (List[])new ArrayList[] { localArrayList1, localArrayList2 };
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(paramAIORichMediaData);
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, File paramFile, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(new aicc(this, paramAIORichMediaData, paramBoolean, paramFile));
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("preResult", paramString);
    if (AIOImageData.class.isInstance(paramAIORichMediaData))
    {
      paramAIORichMediaData = (AIOImageData)paramAIORichMediaData;
      a(this.jdField_f_of_type_JavaLangString, paramAIORichMediaData.jdField_g_of_type_Int, paramAIORichMediaData.jdField_h_of_type_Boolean, paramAIORichMediaData.k, paramAIORichMediaData.jdField_f_of_type_JavaLangString, paramAIORichMediaData.j, paramAIORichMediaData.jdField_e_of_type_JavaLangString, 2, localIntent);
    }
    while (!AIOFilePicData.class.isInstance(paramAIORichMediaData)) {
      return;
    }
    paramString = (AIOFilePicData)paramAIORichMediaData;
    if (bhnt.a(paramString.jdField_b_of_type_Int)) {}
    for (paramAIORichMediaData = this.jdField_b_of_type_JavaLangString;; paramAIORichMediaData = this.jdField_c_of_type_JavaLangString)
    {
      a(this.jdField_f_of_type_JavaLangString, paramString.jdField_a_of_type_Int, true, paramAIORichMediaData, null, null, paramString.jdField_h_of_type_JavaLangString, 2, localIntent);
      return;
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData)
  {
    if (this.jdField_a_of_type_Aidz.asBinder().pingBinder())
    {
      paramAIOShortVideoData = this.jdField_a_of_type_Aidz.a(paramAIOShortVideoData.jdField_f_of_type_Long, paramAIOShortVideoData.jdField_f_of_type_Int, this.jdField_g_of_type_Int);
      if (paramAIOShortVideoData != null)
      {
        paramAIOShortVideoData.putExtra("NeedReportForwardShortVideo", true);
        if (this.jdField_a_of_type_Aicx.a() != null)
        {
          Object localObject = this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          if ((localObject instanceof AIOShortVideoData))
          {
            localObject = (AIOShortVideoData)localObject;
            int i1 = ((AIOShortVideoData)localObject).jdField_e_of_type_Int;
            AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
            if ((i1 == LocalMediaInfo.REDBAG_TYPE_GET) && (localAppRuntime.getAccount().equals(((AIOShortVideoData)localObject).jdField_d_of_type_JavaLangString)))
            {
              paramAIOShortVideoData.putExtra("param_key_redbag_type", i1);
              paramAIOShortVideoData.putExtra("param_key_redbag_video_id", ((AIOShortVideoData)localObject).jdField_c_of_type_JavaLangString);
              paramAIOShortVideoData.putExtra("from_session_uin", ((AIOShortVideoData)localObject).jdField_e_of_type_JavaLangString);
            }
            if (((AIOShortVideoData)localObject).jdField_k_of_type_Int == 2) {
              paramAIOShortVideoData.putExtra("special_video_type", ((AIOShortVideoData)localObject).jdField_k_of_type_Int);
            }
          }
        }
        auxu.a(this.jdField_a_of_type_AndroidAppActivity, paramAIOShortVideoData);
      }
    }
    if (this.jdField_c_of_type_Boolean) {
      axpm.a("0X8009ABC");
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, int paramInt)
  {
    File localFile = paramAIOShortVideoData.a(1);
    aidw localaidw = this.jdField_a_of_type_Aicx.a();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i1 = 0;
    if ((localFile != null) && (localFile.exists()))
    {
      long l1 = localFile.length();
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "showActionSheetForShortVideo, file.getPath()=" + localFile.getPath() + ", mTransferredSize = " + l1 + ", data.size = " + paramAIOShortVideoData.jdField_h_of_type_Long);
      }
      if (l1 >= paramAIOShortVideoData.jdField_h_of_type_Long) {}
    }
    for (i1 = 1;; i1 = 1)
    {
      if ((paramAIOShortVideoData.jdField_b_of_type_Int != 1) || (i1 == 0)) {
        a(2131692524, 2130840151, 59, localArrayList1);
      }
      if ((VersionUtils.isIceScreamSandwich()) && ((paramAIOShortVideoData.jdField_b_of_type_Int != 1) || (i1 == 0))) {
        a(2131692533, 2130840160, 61, localArrayList1);
      }
      if (i1 == 0)
      {
        a(2131692523, 2130840150, 63, localArrayList1);
        a(2131692527, 2130840153, 60, localArrayList1);
        a(2131692535, 2130840161, 58, localArrayList1);
      }
      if ((this.jdField_g_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.r)) {
        a(2131692537, 2130840162, 62, localArrayList2);
      }
      if (i1 == 0) {
        a(2131692530, 2130840156, 64, localArrayList2, 5);
      }
      a(paramAIOShortVideoData, localFile, paramInt, localaidw);
      paramAIOShortVideoData = (List[])new ArrayList[] { localArrayList1, localArrayList2 };
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(paramAIOShortVideoData);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
      }
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, aidw paramaidw)
  {
    if (paramAIOShortVideoData != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "dealSaveVideo");
      }
      this.jdField_a_of_type_Aidz.a(paramAIOShortVideoData.jdField_f_of_type_Long, paramAIOShortVideoData.jdField_f_of_type_Int, 256);
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, aidw paramaidw)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(new aibz(this, paramAIOShortVideoData, paramFile, paramInt, paramaidw));
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setCancelListener(new aica(this));
  }
  
  private void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    aidw localaidw = this.jdField_a_of_type_Aicx.a(paramInt);
    if (localaidw != null)
    {
      a(localaidw);
      if ((localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4)) || (localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20)))
      {
        if (localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_h_of_type_Long <= 0L) {
          break label165;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidAppActivity.getString(2131694456), new Object[] { auog.a(localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_h_of_type_Long) }));
      }
    }
    for (;;)
    {
      c(true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramAdapterView, paramView, paramInt, paramLong);
        paramAdapterView = a().findViewById(2131367352);
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
      return;
      label165:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694453);
    }
  }
  
  private void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList1, File paramFile1, AIOImageData paramAIOImageData, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList2, File paramFile2)
  {
    if (this.jdField_h_of_type_Boolean)
    {
      a(2131692521, 2130840146, 48, paramArrayList1);
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickMore", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    if ((this.jdField_g_of_type_Int != 1037) && (adak.a(this.jdField_g_of_type_Int) != 1044)) {
      a(2131692524, 2130840151, 49, paramArrayList1);
    }
    if ((PicShareToWX.a().a()) && (PicShareToWX.a().a(paramFile1))) {
      a(2131692534, 2130846814, 69, paramArrayList1);
    }
    if (!avqh.a().a()) {
      a(2131692533, 2130840160, 53, paramArrayList1);
    }
    if (!this.jdField_h_of_type_Boolean) {
      a(2131692523, 2130840150, 57, paramArrayList1);
    }
    if ((this.jdField_g_of_type_Int != 1037) && (adak.a(this.jdField_g_of_type_Int) != 1044))
    {
      if (paramAIOImageData.jdField_e_of_type_JavaLangString != null) {
        a(2131692528, 2130840154, 50, paramArrayList1, 3);
      }
      if ((this.jdField_i_of_type_Boolean) && (paramAIOImageData.jdField_e_of_type_JavaLangString != null)) {
        a(2131692525, 2130840152, 51, paramArrayList1, 3);
      }
    }
    a(2131692535, 2130840161, 58, paramArrayList1);
    if ((this.jdField_g_of_type_Int != 1037) && (adak.a(this.jdField_g_of_type_Int) != 1044))
    {
      if ((this.jdField_g_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.r)) {
        a(2131692537, 2130840162, 54, paramArrayList2, 3);
      }
      if (this.jdField_f_of_type_Boolean) {
        a(2131692529, 2130840155, 52, paramArrayList2, 2);
      }
      ThreadManager.getFileThreadHandler().post(new AIOGalleryScene.15(this, paramFile2, paramArrayList2));
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      aidw localaidw = this.jdField_a_of_type_Aicx.a();
      if ((localaidw != null) && ((localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a((AIOShortVideoData)localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData) != null))
        {
          this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(0);
          return true;
        }
      }
      else if ((localaidw != null) && ((localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData)) && (zom.c(((AIOFileVideoData)localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_c_of_type_JavaLangString)))
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
  
  private void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    aicx localaicx = this.jdField_a_of_type_Aicx;
    if (paramInt3 == 1) {}
    for (String str = paramString;; str = "I:E")
    {
      localaicx.a(paramLong, paramInt1, paramInt2, str, false);
      QLog.d("AIOGalleryScene", 2, "AIOFilePicData.TYPE_ORIGINAL_IMAGE,result:" + paramInt3 + ",resultStr: " + paramString);
      if (paramInt3 != 1) {
        break label290;
      }
      paramString = this.jdField_a_of_type_Aicx.a();
      if ((paramString != null) && (paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (AIOFilePicData.class.isInstance(paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
        ((AIOFilePicData)paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_f_of_type_Boolean = false;
      }
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mPlayGifImage = true;
      paramString.mUseExifOrientation = false;
      str = this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20);
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      QLog.e("AIOGalleryScene", 1, "null url");
      return;
    }
    paramString = URLDrawable.getDrawable(str, paramString);
    switch (paramString.getStatus())
    {
    }
    for (;;)
    {
      paramString.setTag(Integer.valueOf(1));
      paramString.setURLDrawableListener(this.jdField_a_of_type_Aicq);
      paramString.startDownload();
      this.jdField_a_of_type_Aicq.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
      return;
      this.jdField_a_of_type_Aicq.onLoadSuccessed(paramString);
      return;
      this.jdField_a_of_type_Aicq.onLoadFialed(paramString, null);
      return;
      this.jdField_a_of_type_Aicq.onLoadCanceled(paramString);
    }
    label290:
    if (!"TroopFileError".equals(paramString))
    {
      if (!this.jdField_a_of_type_AndroidAppActivity.getString(2131692472).equals(paramString)) {
        break label349;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, paramString, 0).a();
    }
    for (;;)
    {
      a(false);
      c(true);
      this.jdField_a_of_type_Aicq = null;
      return;
      label349:
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131694455), 0).a();
    }
  }
  
  private void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    aicx localaicx = this.jdField_a_of_type_Aicx;
    if (paramInt3 == 1)
    {
      paramInt2 = localaicx.a(paramLong, paramInt1, paramInt2, paramString, false);
      int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
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
      label127:
      if (paramInt2 >= this.jdField_a_of_type_Aicx.a()) {
        return;
      }
      paramString = this.jdField_a_of_type_Aicx.a(paramInt2);
      if (paramString != null) {
        break label172;
      }
    }
    for (;;)
    {
      paramInt2 += 1;
      break label127;
      paramString = "I:E";
      break;
      label172:
      if ((paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramLong) && (paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int == paramInt1) && (paramInt3 == 1) && (AIOImageData.class.isInstance(paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
      {
        paramString = (AIOImageData)paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if ((!paramString.jdField_g_of_type_Boolean) && (new File(paramString.jdField_a_of_type_JavaLangString + "_hd").exists())) {
          paramString.jdField_a_of_type_JavaLangString += "_hd";
        }
      }
    }
  }
  
  private void b(aidw paramaidw)
  {
    if (paramaidw == null) {}
    do
    {
      return;
      if (AIOShortVideoData.class.isInstance(paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        AIOShortVideoData localAIOShortVideoData = (AIOShortVideoData)paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (localAIOShortVideoData.jdField_b_of_type_Int == 0)
        {
          paramaidw.jdField_a_of_type_Aidx.jdField_h_of_type_Boolean = false;
          paramaidw.jdField_a_of_type_Aidx.jdField_d_of_type_Boolean = false;
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
          paramaidw.jdField_a_of_type_Aidx.jdField_g_of_type_Boolean = false;
          return;
          this.jdField_d_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(localAIOShortVideoData.jdField_a_of_type_Int * 1000));
          paramaidw.jdField_a_of_type_Aidx.jdField_i_of_type_Boolean = false;
        }
      }
      if ((paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData))
      {
        this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
        paramaidw.jdField_a_of_type_Aidx.jdField_g_of_type_Boolean = false;
        return;
      }
    } while (this.jdField_a_of_type_MqqOsMqqHandler == null);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  public static void b(aidw paramaidw, Activity paramActivity, int paramInt)
  {
    if (!AIOImageData.class.isInstance(paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
      return;
    }
    AIOImageData localAIOImageData = (AIOImageData)paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
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
      paramaidw = paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (i1 != 0) {}
      for (int i2 = 4;; i2 = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", paramaidw.a(i2));
        if (paramActivity.getIntent().getBooleanExtra("image_share_by_server", false))
        {
          paramaidw = Long.toString(paramActivity.getIntent().getLongExtra("appid", 0L));
          i2 = paramActivity.getIntent().getIntExtra("curType", 0);
          localBundle.putBoolean("key_forward_image_share", true);
          localBundle.putString("key_forward_image_share_appid", paramaidw);
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
          paramaidw = new Intent();
          paramaidw.putExtras(localBundle);
          auxu.a(paramActivity, paramaidw, paramInt);
          return;
        }
        catch (NullPointerException paramaidw) {}
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOGalleryScene", 2, "showFriendPickerForForward ,cache path is null");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOGalleryScene", 2, "showFriendPickerForForward ,NullPointerException: " + paramaidw);
      return;
    }
  }
  
  private void b(AIOImageData paramAIOImageData)
  {
    if (LocalMultiProcConfig.getInt4Uin(this.jdField_b_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_d_of_type_JavaLangString, -1, Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue()) == 0)
    {
      paramAIOImageData = new bhpc(this.jdField_a_of_type_AndroidAppActivity, 2131755824);
      paramAIOImageData.setContentView(2131559008);
      paramAIOImageData.setTitle(this.jdField_a_of_type_AndroidAppActivity.getString(2131696995));
      paramAIOImageData.setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131696993));
      paramAIOImageData.setNegativeButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131696994), new aibv(this));
      paramAIOImageData.setCanceledOnTouchOutside(false);
      paramAIOImageData.setCancelable(false);
      paramAIOImageData.show();
      QZoneClickReport.startReportImediately(this.jdField_b_of_type_JavaLangString, "40", "1");
      return;
    }
    a("Pic_Forward_Grpalbum", 0);
    aicv.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, paramAIOImageData.jdField_a_of_type_JavaLangString, paramAIOImageData.jdField_e_of_type_JavaLangString, paramAIOImageData.c, -1);
  }
  
  private void b(AIOImageData paramAIOImageData, aidw paramaidw)
  {
    if (paramAIOImageData != null)
    {
      this.jdField_a_of_type_Aicq = new aicq(this);
      this.jdField_a_of_type_Aicq.jdField_a_of_type_Long = paramAIOImageData.jdField_f_of_type_Long;
      this.jdField_a_of_type_Aicq.jdField_a_of_type_Int = paramAIOImageData.jdField_f_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "dealSaveOriginalImage");
      }
      this.jdField_a_of_type_Aidz.a(this.jdField_a_of_type_Aicq.jdField_a_of_type_Long, this.jdField_a_of_type_Aicq.jdField_a_of_type_Int, 24);
    }
  }
  
  private void b(AIOImageData paramAIOImageData, aidw paramaidw, File paramFile)
  {
    a("Pic_save", 0);
    if ((paramAIOImageData.a(4) == null) && (paramAIOImageData.a(4)) && (AppNetConnInfo.isNetSupport())) {
      if ((!AppNetConnInfo.isWifiConn()) && (paramAIOImageData.jdField_h_of_type_Long > 29360128L)) {
        a(1, paramAIOImageData, paramaidw);
      }
    }
    for (;;)
    {
      a(paramFile.getAbsolutePath(), 55);
      if (this.jdField_h_of_type_Boolean) {
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "3", "", "", "", "", 0, 0, 0, 0);
      }
      if (this.jdField_c_of_type_Boolean) {
        axpm.a("0X8009ABB");
      }
      return;
      b(paramAIOImageData, paramaidw);
      paramaidw.jdField_a_of_type_Aidx.jdField_e_of_type_Boolean = true;
      u();
      continue;
      aicv.a(this.jdField_a_of_type_AndroidAppActivity, paramFile, Utils.Crc64String(paramFile.getAbsolutePath() + NetConnInfoCenter.getServerTime()));
    }
  }
  
  private void b(AIORichMediaData paramAIORichMediaData)
  {
    if (LocalMultiProcConfig.getInt4Uin(this.jdField_b_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_d_of_type_JavaLangString, -1, Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue()) == 0)
    {
      paramAIORichMediaData = new bhpc(this.jdField_a_of_type_AndroidAppActivity, 2131755824);
      paramAIORichMediaData.setContentView(2131559008);
      paramAIORichMediaData.setTitle(this.jdField_a_of_type_AndroidAppActivity.getString(2131696995));
      paramAIORichMediaData.setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131696993));
      paramAIORichMediaData.setNegativeButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131696994), new aicd(this));
      paramAIORichMediaData.setCanceledOnTouchOutside(false);
      paramAIORichMediaData.setCancelable(false);
      paramAIORichMediaData.show();
      QZoneClickReport.startReportImediately(this.jdField_b_of_type_JavaLangString, "40", "1");
      return;
    }
    paramAIORichMediaData = (AIOImageData)paramAIORichMediaData;
    a("Pic_Forward_Grpalbum", 0);
    aicv.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, paramAIORichMediaData.jdField_a_of_type_JavaLangString, paramAIORichMediaData.jdField_e_of_type_JavaLangString, paramAIORichMediaData.c, -1);
  }
  
  private void b(AIORichMediaData paramAIORichMediaData, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("preResult", paramString);
    if (AIOImageData.class.isInstance(paramAIORichMediaData))
    {
      paramAIORichMediaData = (AIOImageData)paramAIORichMediaData;
      a(this.jdField_f_of_type_JavaLangString, paramAIORichMediaData.jdField_g_of_type_Int, paramAIORichMediaData.jdField_h_of_type_Boolean, paramAIORichMediaData.k, paramAIORichMediaData.jdField_f_of_type_JavaLangString, paramAIORichMediaData.j, paramAIORichMediaData.jdField_e_of_type_JavaLangString, 1, localIntent);
    }
    while (!AIOFilePicData.class.isInstance(paramAIORichMediaData))
    {
      bdll.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
      return;
    }
    paramString = (AIOFilePicData)paramAIORichMediaData;
    if (bhnt.a(paramString.jdField_b_of_type_Int)) {}
    for (paramAIORichMediaData = this.jdField_b_of_type_JavaLangString;; paramAIORichMediaData = this.jdField_c_of_type_JavaLangString)
    {
      a(this.jdField_f_of_type_JavaLangString, paramString.jdField_a_of_type_Int, true, paramAIORichMediaData, null, null, paramString.jdField_h_of_type_JavaLangString, 1, localIntent);
      break;
    }
  }
  
  private void b(AIOShortVideoData paramAIOShortVideoData)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.parse("file://" + paramAIOShortVideoData.jdField_b_of_type_JavaLangString), "video/*");
    localIntent.putExtra("big_brother_source_key", " biz_src_jc_video");
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    int i1 = paramAIOShortVideoData.jdField_g_of_type_Int;
    if (i1 == 0)
    {
      bdll.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
      return;
    }
    if (i1 == 3000)
    {
      bdll.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
      return;
    }
    if (i1 == 1)
    {
      bdll.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
      return;
    }
    bdll.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
  }
  
  private void b(AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, aidw paramaidw)
  {
    if (paramAIOShortVideoData.jdField_j_of_type_Int == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "video file is expired");
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, anzj.a(2131698966), 0).a();
      return;
    }
    if (paramAIOShortVideoData.jdField_b_of_type_Int == 1)
    {
      a(paramInt, paramFile);
      return;
    }
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.length() == paramAIOShortVideoData.jdField_h_of_type_Long))
    {
      paramAIOShortVideoData = new StringBuilder().append(paramFile.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4";
      ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(paramFile.getAbsolutePath(), this.jdField_a_of_type_MqqOsMqqHandler, paramAIOShortVideoData, false));
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(10001);
      return;
    }
    if ((!AppNetConnInfo.isWifiConn()) && (paramAIOShortVideoData.jdField_h_of_type_Long > 29360128L))
    {
      a(3, paramAIOShortVideoData, paramaidw);
      return;
    }
    a(paramAIOShortVideoData, paramaidw);
    paramaidw.jdField_a_of_type_Aidx.jdField_a_of_type_Boolean = true;
    u();
  }
  
  private int c()
  {
    if (this.jdField_k_of_type_Int == 1) {
      return 1;
    }
    if (this.jdField_k_of_type_Int == 2) {
      return 5;
    }
    if (this.jdField_k_of_type_Int == 3) {
      return 4;
    }
    if (this.jdField_c_of_type_Boolean) {
      return 6;
    }
    return 0;
  }
  
  private void c(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    aicx localaicx;
    String str;
    if ((this.jdField_a_of_type_Aicq != null) && (this.jdField_a_of_type_Aicq.jdField_a_of_type_Long == paramLong) && (this.jdField_a_of_type_Aicq.jdField_a_of_type_Int == paramInt1))
    {
      localaicx = this.jdField_a_of_type_Aicx;
      if (paramInt3 != 1) {
        break label109;
      }
      str = paramString;
    }
    for (;;)
    {
      localaicx.a(paramLong, paramInt1, paramInt2, str, false);
      if (paramInt3 != 1) {
        break label279;
      }
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mPlayGifImage = true;
      paramString.mUseExifOrientation = false;
      try
      {
        paramString = URLDrawable.getDrawable(this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4), paramString);
        if (paramString == null)
        {
          return;
          label109:
          str = "I:E";
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = null;
        }
        switch (paramString.getStatus())
        {
        }
      }
    }
    paramString.setTag(Integer.valueOf(1));
    paramString.setURLDrawableListener(this.jdField_a_of_type_Aicq);
    paramString.startDownload();
    this.jdField_a_of_type_Aicq.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
    label192:
    paramString = this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if ((paramString.jdField_f_of_type_Long == paramLong) && (paramString.jdField_f_of_type_Int == paramInt1)) {
      this.jdField_a_of_type_Aicx.a().jdField_a_of_type_Aidx.jdField_c_of_type_Boolean = false;
    }
    for (;;)
    {
      u();
      return;
      this.jdField_a_of_type_Aicq.onLoadSuccessed(paramString);
      break label192;
      this.jdField_a_of_type_Aicq.onLoadFialed(paramString, null);
      break label192;
      this.jdField_a_of_type_Aicq.onLoadCanceled(paramString);
      break;
      label279:
      if (!"TroopFileError".equals(paramString)) {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131694455), 0).a();
      }
      this.jdField_a_of_type_Aicq = null;
      break label192;
      paramString = a(paramLong, paramInt1);
      if (paramString != null)
      {
        paramString.jdField_a_of_type_Int = 0;
        paramString.jdField_a_of_type_Aidx.jdField_c_of_type_Boolean = false;
      }
    }
  }
  
  private void c(aidw paramaidw)
  {
    a("Pic_Forward_Contacts", 0);
    a(paramaidw, this.jdField_a_of_type_AndroidAppActivity, 0);
    if (this.jdField_h_of_type_Boolean) {
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
    }
    if (this.jdField_c_of_type_Boolean) {
      axpm.a("0X8009ABA");
    }
  }
  
  private void c(AIOImageData paramAIOImageData)
  {
    if (this.jdField_h_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_Manager", 2, "action sheet share weiyun.");
      }
      localBundle = new Bundle();
      localBundle.putString("pic_md5", paramAIOImageData.jdField_f_of_type_JavaLangString);
      QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_upload_wy", localBundle, null);
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "5", "", "", "", "", 0, 0, 0, 0);
    }
    while ((paramAIOImageData.jdField_f_of_type_Long <= 0L) || (!this.jdField_a_of_type_Aidz.asBinder().pingBinder()))
    {
      Bundle localBundle;
      return;
    }
    this.jdField_a_of_type_Aidz.c(paramAIOImageData.jdField_f_of_type_Long);
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692445), 0).a();
  }
  
  private void d(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    aicx localaicx = this.jdField_a_of_type_Aicx;
    if (paramInt3 == 1) {}
    for (;;)
    {
      paramInt1 = localaicx.a(paramLong, paramInt1, paramInt2, paramString, false);
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
      paramInt3 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
      if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1))
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt1, paramString, paramBoolean);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("AIOGalleryScene", 4, "notifyImageResult(): Gallery position is " + paramInt1);
      }
      return;
      paramString = "I:E";
    }
  }
  
  private void d(aidw paramaidw)
  {
    AIOImageData localAIOImageData = (AIOImageData)paramaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    Object localObject2 = localAIOImageData.a(4);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localAIOImageData.a(2);
    }
    if ((localObject1 == null) && (this.t)) {
      return;
    }
    if (localObject1 != null) {
      this.jdField_g_of_type_JavaLangString = ((File)localObject1).getPath();
    }
    localObject2 = blir.c(this.jdField_a_of_type_AndroidAppActivity);
    if ((!a((blir)localObject2, localAIOImageData)) && (adak.a(this.jdField_g_of_type_Int) != 1032))
    {
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      if (localObject1 != null) {
        if (!this.jdField_c_of_type_Boolean) {
          a((ArrayList)localObject2, (File)localObject1, localAIOImageData, localArrayList, (File)localObject1);
        }
      }
      for (;;)
      {
        if ((localAIOImageData.jdField_e_of_type_Int == 4) && (!localAIOImageData.jdField_i_of_type_Boolean)) {
          a(2131692967, 2130846676, 66, (ArrayList)localObject2);
        }
        a(localAIOImageData, paramaidw, (File)localObject1);
        paramaidw = (List[])new ArrayList[] { localObject2, localArrayList };
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(paramaidw);
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
        return;
        a(2131692962, 2130840151, 49, (ArrayList)localObject2);
        a(2131692968, 2130840160, 53, (ArrayList)localObject2);
        continue;
        if ((!this.jdField_c_of_type_Boolean) && (this.jdField_g_of_type_Int != 1037) && (adak.a(this.jdField_g_of_type_Int) != 1044) && (this.jdField_g_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.r)) {
          a(2131692537, 2130840162, 54, localArrayList, 3);
        }
      }
    }
    a((blir)localObject2, localAIOImageData, (File)localObject1, (File)localObject1);
  }
  
  private void d(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561579, null);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    if (paramBoolean) {
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131374354);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localRelativeLayout.findViewById(2131371891));
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377245));
      localObject = (ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372146);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373046));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379238));
      ((ImageView)localObject).setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131380467));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380469));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380468));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131364585));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131364011));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localRelativeLayout.findViewById(2131376077));
      return;
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    }
  }
  
  private void e(int paramInt)
  {
    if (!this.jdField_e_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_Aicx.b()) {
        break label22;
      }
      z();
    }
    for (;;)
    {
      return;
      label22:
      int i1 = this.jdField_a_of_type_Aicx.a();
      if (this.jdField_k_of_type_Boolean)
      {
        if (i1 - paramInt <= 0) {
          break label156;
        }
        if (paramInt > i1 - 25) {
          paramInt = 1;
        }
      }
      while ((i1 != 1) && (paramInt != 0) && (!this.jdField_a_of_type_Boolean) && (this.jdField_n_of_type_Int != i1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "[onItemSelected] loadMedias: mLastLoadCount=" + this.jdField_n_of_type_Int);
        }
        this.jdField_n_of_type_Int = this.jdField_a_of_type_Aicx.a();
        this.jdField_a_of_type_Aidz.a(0);
        return;
        paramInt = 0;
        continue;
        if (paramInt < 25)
        {
          paramInt = 1;
        }
        else
        {
          paramInt = 0;
          continue;
          label156:
          paramInt = 0;
        }
      }
    }
  }
  
  private void e(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    aicx localaicx = this.jdField_a_of_type_Aicx;
    if (paramInt3 == 1) {}
    for (;;)
    {
      paramInt1 = localaicx.a(paramLong, paramInt1, paramInt2, paramString, false);
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
      int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
      if ((paramInt1 >= paramInt2) && (paramInt1 <= i1 + paramInt2 - 1))
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt1, paramString, paramBoolean);
        if (paramInt3 == 2)
        {
          a(false);
          c(true);
          this.jdField_a_of_type_Aicq = null;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("AIOGalleryScene", 4, "notifyImageResult(): Gallery position is " + paramInt1);
      }
      return;
      paramString = "I:E";
    }
  }
  
  private void f(int paramInt)
  {
    aidw localaidw = this.jdField_a_of_type_Aicx.a(paramInt);
    if ((localaidw != null) && ((localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFilePicData)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidAppActivity.getString(2131694456), new Object[] { auog.a(localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_h_of_type_Long) }));
      if (localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_h_of_type_Long <= atyt.c()) {
        break label202;
      }
      c(true);
      this.jdField_a_of_type_ComTencentWidgetGallery.b(false);
      this.jdField_a_of_type_ComTencentWidgetGallery.a(false);
    }
    for (;;)
    {
      if ((localaidw != null) && ((localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) && (((AIOImageData)localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_g_of_type_Int == 1))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidAppActivity.getString(2131694456), new Object[] { auog.a(localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_h_of_type_Long) }));
        if (localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_h_of_type_Long <= atyt.c()) {
          break;
        }
        c(true);
        this.jdField_a_of_type_ComTencentWidgetGallery.b(false);
        this.jdField_a_of_type_ComTencentWidgetGallery.a(false);
      }
      return;
      label202:
      c(true);
    }
    c(true);
  }
  
  public void A()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AIOGalleryScene.28(this), 1000L);
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
    Object localObject;
    try
    {
      localObject = this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (((localObject instanceof AIOImageData)) || ((localObject instanceof AIOFilePicData)))
      {
        File localFile = a((AIORichMediaData)localObject);
        if (localFile != null) {}
      }
      else
      {
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
      return;
    }
    this.jdField_g_of_type_JavaLangString = localNullPointerException.getAbsolutePath();
    int i1 = 99;
    int i2;
    boolean bool;
    int i3;
    Intent localIntent;
    switch (this.jdField_k_of_type_Int)
    {
    default: 
      i2 = 0;
      bool = false;
      i3 = 0;
      localIntent = EditPicActivity.a(this.jdField_a_of_type_AndroidAppActivity, localNullPointerException.getAbsolutePath(), true, true, true, true, true, 2, i1, 7);
      localIntent.putExtra("uintype", this.jdField_g_of_type_Int);
      localIntent.putExtra("open_chatfragment", true);
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1041);
      localIntent.putExtra("key_enable_edit_title_bar", true);
      if (bool) {
        localIntent.putExtra("key_help_forward_pic", bool);
      }
      if (i2 != 0) {
        localIntent.putExtra("key_allow_multiple_forward_from_limit", false);
      }
      if ((localObject instanceof AIOFilePicData))
      {
        if (this.jdField_a_of_type_Aidz.asBinder().pingBinder())
        {
          localObject = this.jdField_a_of_type_Aidz.a(((AIORichMediaData)localObject).jdField_f_of_type_Long, ((AIORichMediaData)localObject).jdField_f_of_type_Int, this.jdField_g_of_type_Int);
          if (localObject != null)
          {
            ((Intent)localObject).setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
            localObject = (ForwardFileInfo)((Intent)localObject).getParcelableExtra("fileinfo");
            if (localObject != null) {
              localIntent.putExtra("fileinfo", (Parcelable)localObject);
            }
          }
        }
        localIntent.putExtra("not_forward", true);
      }
      if (i3 != 0) {
        this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, i3);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772037, 2130772039);
      bdll.b(null, "dc00898", "", "", "0X8007ACE", "0X8007ACE", 0, 0, "", "", "", "");
      return;
      bdll.b(null, "dc00898", "", "", "0X800A187", "0X800A187", 0, 0, "", "", "", "");
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
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    }
  }
  
  public void D()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a();
  }
  
  public void E()
  {
    if ((this.jdField_a_of_type_Aksn != null) && (this.jdField_a_of_type_Aksn.a != null) && (this.jdField_a_of_type_Aksn.a.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aksn.c()))
    {
      this.jdField_a_of_type_Aksn.d(2);
      Object localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131718217);
      localObject = bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, (String)localObject, 2131693994, 2131719410, new aicj(this), new aick(this));
      if (this.jdField_a_of_type_Aksn != null) {
        this.jdField_a_of_type_Aksn.h();
      }
      a((Dialog)localObject);
    }
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561407, null);
  }
  
  protected AbstractImageAdapter a(Context paramContext)
  {
    boolean bool1 = true;
    if (this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("extra.IS_FROM_CHAT_FILE_HISTORY", false)) {}
    for (int i1 = 1; this.jdField_e_of_type_Boolean; i1 = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter = new AIOGalleryAdapter(paramContext, this.jdField_a_of_type_Aidz, true, i1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_a_of_type_Aksn);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.jdField_a_of_type_Aibl = new aice(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_a_of_type_Aicx);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.jdField_a_of_type_Boolean = this.q;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(new aicf(this));
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter;
    }
    boolean bool2 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras().getBoolean("is_one_item", false);
    if (this.jdField_k_of_type_Int == 4) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter = new AIOGalleryAdapter(paramContext, this.jdField_a_of_type_Aidz, bool1, i1);
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
    localObject = new aidw((AIORichMediaData)localObject);
    this.jdField_a_of_type_Aicx.a((aidw)localObject);
    this.q = localBundle.getBoolean("muate_play");
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "initData , mIsMute = " + this.q);
    }
    ((aidw)localObject).jdField_b_of_type_AndroidGraphicsRect = ((Rect)localBundle.getParcelable("KEY_THUMBNAL_BOUND"));
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
      this.jdField_a_of_type_Aicx.a(true);
      this.jdField_k_of_type_Boolean = true;
      if (!TextUtils.isEmpty(localBundle.getString("babyq_video_type"))) {
        break label570;
      }
    }
    label570:
    for (boolean bool = false;; bool = true)
    {
      this.jdField_m_of_type_Boolean = bool;
      this.jdField_f_of_type_Boolean = localBundle.getBoolean("extra.OCR", false);
      this.jdField_a_of_type_JavaLangString = localBundle.getString("extra.OCR_TEXT");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131692964);
      }
      this.jdField_h_of_type_Boolean = localBundle.getBoolean("group.emo.big.preview", false);
      this.jdField_k_of_type_Int = localBundle.getInt("extra.EXTRA_ENTRANCE");
      this.r = localBundle.getBoolean("is_ReplyMsg_From_Same_Session", true);
      return;
      ((aidw)localObject).jdField_c_of_type_Boolean = false;
      break;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_Aicr.jdField_a_of_type_Boolean = true;
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
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131718211, 0).a();
        return;
      }
    } while ((paramInt1 != 10002) || (this.jdField_a_of_type_Bdcy == null));
    this.jdField_a_of_type_Bdcy.a(paramInt2);
  }
  
  public void a(int paramInt1, View paramView, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "carverW notifyVideoUrl setShortVideoDrawableWithUrls ,position = " + paramInt1);
    }
    aidw localaidw = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt1);
    if (localaidw == null) {}
    do
    {
      return;
      if (AIOShortVideoData.class.isInstance(localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        a(localaidw, paramArrayOfString, paramString2, paramView, paramMessageForShortVideo, paramInt2);
        return;
      }
    } while (!AIOFileVideoData.class.isInstance(localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
    a(localaidw, paramString1, paramArrayOfString, paramString2, paramView);
  }
  
  public void a(int paramInt, Object paramObject, aidw paramaidw)
  {
    a(bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131717542), this.jdField_a_of_type_AndroidAppActivity.getString(2131717541), new aibw(this, paramInt, paramObject, paramaidw), new aibx(this)));
  }
  
  public void a(long paramLong)
  {
    boolean bool = true;
    int i1;
    if ((this.jdField_a_of_type_Abkg != null) && (this.jdField_a_of_type_Abkg.a() == this))
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
    aidw localaidw;
    do
    {
      return;
      i1 = 0;
      break;
      localaidw = this.jdField_a_of_type_Aicx.a();
      if ((localaidw != null) && (localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null)) {
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
        QLog.d("AIOGalleryScene", 2, "onRevokeMsg seq:" + paramLong + ", selectItem seq:" + localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long + ", isFromMultiMsg:" + this.jdField_c_of_type_Boolean + ", OriSeq:" + this.jdField_a_of_type_Long);
      }
      if ((this.jdField_a_of_type_Aidz != null) && (!bool)) {
        this.jdField_a_of_type_Aidz.a(paramLong);
      }
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOGalleryScene.31(this, paramLong, localaidw, bool));
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
    if (paramInt2 == 2) {
      a(paramLong1, paramInt1, paramBoolean);
    }
    do
    {
      Object localObject;
      do
      {
        for (;;)
        {
          return;
          if (paramInt2 == 24)
          {
            a(paramLong1, paramInt1);
            return;
          }
          if (paramInt2 == 4)
          {
            a(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2);
            return;
          }
          if (paramInt2 != 1) {
            break;
          }
          localObject = this.jdField_a_of_type_Aicx.a();
          paramInt1 = 0;
          while (paramInt1 < ((List)localObject).size())
          {
            aidw localaidw = (aidw)((List)localObject).get(paramInt1);
            if (localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramLong1)
            {
              localaidw.jdField_a_of_type_Int = paramInt3;
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt1, paramInt3 / 100);
              return;
            }
            paramInt1 += 1;
          }
        }
        if (paramInt2 != 256) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "save video progress : " + paramInt3);
        }
        localObject = this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      } while ((((AIORichMediaData)localObject).jdField_f_of_type_Long != paramLong1) || (((AIORichMediaData)localObject).jdField_f_of_type_Int != paramInt1));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131698980) + paramInt3 + "%");
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(paramInt3 / 100.0D * 10000.0D));
      return;
      if (paramInt2 == 18)
      {
        a(paramLong1, paramBoolean);
        return;
      }
    } while (paramInt2 != 20);
    a(paramLong1, paramLong2);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    if (paramInt2 == 2) {
      b(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
    }
    do
    {
      return;
      if (paramInt2 == 24)
      {
        a(paramLong, paramInt1, paramInt2, paramInt3, paramString);
        return;
      }
      if (paramInt2 == 4)
      {
        c(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
        return;
      }
      if (paramInt2 == 256)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "save video result resultStr = " + paramString);
        }
        if (paramInt3 == 1) {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131717539), 0).a();
        }
        for (;;)
        {
          this.jdField_a_of_type_Aicr.jdField_b_of_type_Boolean = false;
          u();
          return;
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131717535), 0).a();
        }
      }
      if ((paramInt2 == 1) || (paramInt2 == 0))
      {
        d(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
        return;
      }
      if (paramInt2 == 18)
      {
        e(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
        return;
      }
      if ((paramInt2 == 20) && (this.jdField_a_of_type_Aicq != null) && (this.jdField_a_of_type_Aicq.jdField_a_of_type_Long == paramLong))
      {
        b(paramLong, paramInt1, paramInt2, paramInt3, paramString);
        return;
      }
    } while (paramInt2 != 269484034);
    a(paramLong, paramInt3, paramString);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    paramInt1 = this.jdField_a_of_type_Aicx.a(paramLong, paramInt1, paramInt2, paramString1, false);
    paramInt2 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
    if (QLog.isDevelopLevel()) {
      QLog.d("AIOGalleryScene", 2, " carverW notifyVideoUrl(): Gallery position is " + paramInt1 + ", first = " + paramInt2 + ", count = " + i1);
    }
    if ((paramInt1 >= paramInt2) && (paramInt1 <= i1 + paramInt2 - 1)) {
      a(paramInt1, this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2), paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
    }
  }
  
  protected void a(aidw paramaidw, Activity paramActivity, int paramInt)
  {
    b(paramaidw, this.jdField_a_of_type_AndroidAppActivity, 0);
  }
  
  public void a(akss paramakss)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("[TVKInfo] onPlayStart, id : ");
      if (paramakss != null) {
        break label78;
      }
    }
    label78:
    for (String str = "null";; str = paramakss.jdField_a_of_type_Long + "")
    {
      QLog.d("AIOGalleryScene", 2, str);
      if ((paramakss == null) || (!paramakss.jdField_b_of_type_Boolean) || (!paramakss.jdField_a_of_type_Boolean)) {
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
    this.jdField_a_of_type_Aicx.a().jdField_a_of_type_Aidx.jdField_g_of_type_Boolean = true;
    u();
  }
  
  public void a(akss paramakss, int paramInt)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("[TVKInfo] onEndBuffering, id : ");
      if (paramakss == null)
      {
        localObject1 = "null";
        QLog.d("AIOGalleryScene", 2, (String)localObject1);
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_Aicx.a();
      if ((localObject1 != null) && (((aidw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (paramakss != null)) {
        break label96;
      }
    }
    label96:
    do
    {
      return;
      localObject1 = paramakss.jdField_a_of_type_Long + "";
      break;
      localObject2 = a(paramakss.jdField_a_of_type_Long, paramakss.jdField_b_of_type_Int);
      if (localObject2 != null) {
        ((aidw)localObject2).jdField_a_of_type_Aidx.jdField_d_of_type_Boolean = false;
      }
    } while (((aidw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != paramakss.jdField_a_of_type_Long);
    u();
  }
  
  public void a(akss paramakss, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[TVKInfo] onError , id : ");
      if (paramakss == null)
      {
        localObject = "null";
        QLog.d("AIOGalleryScene", 2, (String)localObject);
      }
    }
    else
    {
      if (paramakss != null) {
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
              localObject = paramakss.jdField_a_of_type_Long + "";
              break;
              localObject = this.jdField_a_of_type_Aicx.a();
            } while (((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != paramakss.jdField_a_of_type_Long);
            if (!paramakss.jdField_b_of_type_Boolean) {
              break label231;
            }
          } while (!AIOFileVideoData.class.isInstance(((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
          paramString = rwe.a(paramInt1, paramInt2);
          localObject = (AIOFileVideoData)((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        } while (((AIOFileVideoData)localObject).jdField_b_of_type_Boolean);
        ((AIOFileVideoData)localObject).a(paramString);
        paramString = new Bundle();
        float f1 = 0.0F;
        if (aksp.class.isInstance(this.jdField_a_of_type_Aksn)) {
          f1 = ((aksp)this.jdField_a_of_type_Aksn).a(paramakss.jdField_a_of_type_Long);
        }
        paramString.putFloat("progress", f1);
        this.jdField_a_of_type_Aidz.a(((AIOFileVideoData)localObject).jdField_f_of_type_Long, 10, paramString);
        u();
        return;
        paramakss = a(paramakss.jdField_a_of_type_Long, paramakss.jdField_b_of_type_Int);
      } while (paramakss == null);
      paramakss.jdField_a_of_type_Aidx.jdField_k_of_type_Boolean = true;
    } while (!AIOShortVideoData.class.isInstance(((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
    ((AIOShortVideoData)((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(paramString);
    u();
  }
  
  public void a(akss paramakss, long paramLong)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("[TVKInfo] onDurationReady , id : ");
      if (paramakss != null) {
        break label57;
      }
    }
    label57:
    for (paramakss = "null";; paramakss = paramakss.jdField_a_of_type_Long + "")
    {
      QLog.d("AIOGalleryScene", 2, paramakss);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramLong));
      return;
    }
  }
  
  public void a(akss paramakss, boolean paramBoolean)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[TVKInfo] onGetUrl, id : ");
      if (paramakss == null)
      {
        str = "null";
        QLog.d("AIOGalleryScene", 2, str + " isStart=" + paramBoolean);
      }
    }
    else
    {
      if (paramakss != null) {
        break label87;
      }
    }
    label87:
    do
    {
      do
      {
        return;
        str = paramakss.jdField_a_of_type_Long + "";
        break;
        paramakss = a(paramakss.jdField_a_of_type_Long, paramakss.jdField_b_of_type_Int);
      } while (paramakss == null);
      paramakss.jdField_a_of_type_Aidx.jdField_j_of_type_Boolean = paramBoolean;
    } while (paramakss.jdField_a_of_type_Aidx.jdField_g_of_type_Boolean);
    this.jdField_e_of_type_AndroidWidgetTextView.setText("");
    u();
  }
  
  @TargetApi(14)
  public void a(Activity paramActivity, String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(paramActivity);
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561917);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373039);
      this.jdField_a_of_type_Bjbh = a(paramActivity);
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bjbh);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371445)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new aicg(this));
    }
    this.jdField_a_of_type_Bjbh.c(0);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AIOGalleryScene.27(this), paramInt);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramConfiguration);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(ViewGroup paramViewGroup)
  {
    LiuHaiUtils.enableNotch(this.jdField_a_of_type_AndroidAppActivity);
    super.a(paramViewGroup);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a());
    this.jdField_a_of_type_Bdcy = bdcy.a(bplg.a());
    if (this.jdField_a_of_type_Bdcy != null) {
      this.jdField_b_of_type_AndroidWidgetImageView = this.jdField_a_of_type_Bdcy.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_JavaLangString);
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
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131374359);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131165370));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(2.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165444));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694453);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131694453));
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i1, i1, i1, i1);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843588));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_d_of_type_AndroidWidgetImageButton.setContentDescription(anzj.a(2131698983));
    this.jdField_d_of_type_AndroidWidgetImageButton.setId(2131374354);
    this.jdField_d_of_type_AndroidWidgetImageButton.setImageResource(2130838042);
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
        break label1138;
      }
      bool = true;
      label485:
      if (bool) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_d_of_type_AndroidWidgetImageButton, localLayoutParams);
      }
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_b_of_type_AndroidWidgetImageButton.setContentDescription(anzj.a(2131698978));
      this.jdField_b_of_type_AndroidWidgetImageButton.setId(2131374355);
      this.jdField_b_of_type_AndroidWidgetImageButton.setImageResource(2130838040);
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
        break label1143;
      }
      i1 = 1;
      label800:
      if (((i1 != 0) || ((this.jdField_k_of_type_Int == 4) && (localBundle.getBoolean("key_allow_forward_photo_preview_edit", false)))) && (adak.a(this.jdField_g_of_type_Int) != 1032) && (this.jdField_g_of_type_Int != 1037) && (adak.a(this.jdField_g_of_type_Int) != 1044))
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(anzj.a(2131698974));
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130838035);
        this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundDrawable(null);
        this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetImageButton.setId(2131374356);
        this.jdField_a_of_type_AndroidWidgetImageButton.setPadding(0, 0, 0, 0);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(12, -1);
        localLayoutParams.alignWithParent = true;
        if (!bool) {
          break label1148;
        }
        localLayoutParams.addRule(0, 2131374354);
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
      I();
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((akqw.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter)) && (ProGallery.class.isInstance(this.jdField_a_of_type_ComTencentWidgetGallery))) {
        ((ProGallery)this.jdField_a_of_type_ComTencentWidgetGallery).setOnNoBlankListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter);
      }
      this.jdField_a_of_type_Aksn.a(this);
      this.jdField_a_of_type_Aksn.a(this);
      this.jdField_a_of_type_Aksn.e(this.jdField_k_of_type_Int);
      ((ProGallery)this.jdField_a_of_type_ComTencentWidgetGallery).setGestureListener(this);
      this.jdField_l_of_type_Int = (bdhj.a(this.jdField_a_of_type_AndroidAppActivity) / 2);
      aibo.a().a(this);
      return;
      i1 = 0;
      break;
      label1138:
      bool = false;
      break label485;
      label1143:
      i1 = 0;
      break label800;
      label1148:
      localLayoutParams.addRule(11, -1);
    }
  }
  
  void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Aidz != null) {
      this.jdField_a_of_type_Aidz.a(paramString, paramInt);
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
      i1 = berj.d();
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
          localIntent.putExtra("report_params", zxx.a(paramString3, paramString1, paramString5, paramString2, paramIntent, paramInt1));
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
        if (!AIODevLittleVideoData.class.isInstance(this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
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
  
  boolean a(aidw paramaidw)
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
  
  boolean a(blir paramblir, AIOImageData paramAIOImageData)
  {
    return false;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    bdll.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "0", "", "", "");
    if (this.jdField_k_of_type_Int == 4) {
      return true;
    }
    try
    {
      if (!AIODevLittleVideoData.class.isInstance(this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
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
  
  public void ak_()
  {
    r();
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    this.jdField_a_of_type_Aicr.jdField_a_of_type_Boolean = false;
    u();
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_Aicx.a().jdField_a_of_type_Aidx.jdField_g_of_type_Boolean = true;
    int i1 = this.jdField_a_of_type_Aicx.a(paramLong, 0, 0, "", false);
    aidw localaidw = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(i1);
    if (AIOFileVideoData.class.isInstance(localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      ((AIOFileVideoData)localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a();
      QLog.i("FileVideoMediaPlayHelper.filevideoPeek", 1, "file[" + paramLong + "],download success, set downloadSuccess");
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOGalleryScene.5(this));
  }
  
  public void b(akss paramakss)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("[TVKInfo] onPlayPause , id : ");
      if (paramakss != null) {
        break label56;
      }
    }
    label56:
    for (paramakss = "null";; paramakss = paramakss.jdField_a_of_type_Long + "")
    {
      QLog.d("AIOGalleryScene", 2, paramakss);
      this.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
  }
  
  public void b(akss paramakss, int paramInt)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[TVKInfo] onDownloading, id : ");
      if (paramakss == null)
      {
        str = "null";
        QLog.d("AIOGalleryScene", 2, str);
      }
    }
    else
    {
      if (paramakss != null) {
        break label77;
      }
    }
    label77:
    do
    {
      do
      {
        return;
        str = paramakss.jdField_a_of_type_Long + "";
        break;
        paramakss = a(paramakss.jdField_a_of_type_Long, paramakss.jdField_b_of_type_Int);
      } while (paramakss == null);
      paramakss.jdField_a_of_type_Aidx.jdField_h_of_type_Boolean = true;
    } while (paramakss.jdField_a_of_type_Aidx.jdField_g_of_type_Boolean);
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
    if ((this.jdField_a_of_type_Aksn != null) && (this.jdField_a_of_type_Aksn.c())) {
      this.jdField_a_of_type_Aksn.h();
    }
  }
  
  void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(this.jdField_a_of_type_AndroidAppActivity.getString(2131692536));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(new aicb(this));
    aidw localaidw = this.jdField_a_of_type_Aicx.a();
    Object localObject;
    int i1;
    if (AIOImageData.class.isInstance(localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      localObject = (AIOImageData)localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      a((AIOImageData)localObject, paramInt, localaidw);
      if ((((AIOImageData)localObject).jdField_g_of_type_Int != 1) || (!((AIOImageData)localObject).jdField_h_of_type_Boolean)) {
        break label324;
      }
      i1 = 2;
    }
    for (;;)
    {
      int i2 = a(localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_g_of_type_Int);
      int i3 = c();
      if (paramInt == 2)
      {
        paramInt = 1;
        label140:
        bdll.b(null, "dc00898", "", "", "0X8009EFB", "0X8009EFB", i1, 0, String.valueOf(i2), String.valueOf(i3), String.valueOf(paramInt), "");
        return;
        if (AIOShortVideoData.class.isInstance(localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          localObject = (AIOShortVideoData)localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          if (((AIOShortVideoData)localObject).jdField_b_of_type_Int == 0) {
            i1 = 4;
          }
        }
      }
      for (;;)
      {
        a((AIOShortVideoData)localObject, paramInt);
        break;
        if (((AIOShortVideoData)localObject).jdField_b_of_type_Int == 1)
        {
          i1 = 3;
          continue;
          if (AIOFilePicData.class.isInstance(localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
          {
            a((AIOFilePicData)localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt);
            i1 = 2;
            break;
          }
          if (AIOFileVideoData.class.isInstance(localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
          {
            i1 = 5;
            a((AIOFileVideoData)localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt);
            break;
            if (paramInt == 1)
            {
              paramInt = 2;
              break label140;
            }
            paramInt = 0;
            break label140;
          }
          i1 = 0;
          break;
        }
        i1 = 0;
      }
      label324:
      i1 = 1;
    }
  }
  
  public void c(akss paramakss)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("[TVKInfo] onPlayFinish , id : ");
      if (paramakss != null) {
        break label88;
      }
    }
    label88:
    for (paramakss = "null";; paramakss = paramakss.jdField_a_of_type_Long + "")
    {
      QLog.d("AIOGalleryScene", 2, paramakss);
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Aicx.a();
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
    y();
    if (this.jdField_a_of_type_Aksn != null) {
      this.jdField_a_of_type_Aksn.d();
    }
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_Bjbh == null) {
      return;
    }
    this.jdField_a_of_type_Bjbh.a();
    this.jdField_a_of_type_Bjbh.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("AIOGalleryScene", 2, "[setProgress] current:" + this.jdField_a_of_type_Bjbh.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bjbh.b(true);
    this.jdField_a_of_type_Bjbh.d(false);
    this.jdField_a_of_type_Bjbh.a(String.valueOf(paramInt) + "%");
  }
  
  public void d(akss paramakss)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("[TVKInfo] onBuffering, id : ");
      if (paramakss == null)
      {
        localObject1 = "null";
        QLog.d("AIOGalleryScene", 2, (String)localObject1);
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_Aicx.a();
      if ((localObject1 != null) && (((aidw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (paramakss != null)) {
        break label94;
      }
    }
    label94:
    do
    {
      return;
      localObject1 = paramakss.jdField_a_of_type_Long + "";
      break;
      localObject2 = a(paramakss.jdField_a_of_type_Long, paramakss.jdField_b_of_type_Int);
      if (localObject2 != null) {
        ((aidw)localObject2).jdField_a_of_type_Aidx.jdField_d_of_type_Boolean = true;
      }
    } while ((((aidw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != paramakss.jdField_a_of_type_Long) || (((aidw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int != paramakss.jdField_b_of_type_Int));
    u();
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Aicx != null)
    {
      if (this.jdField_a_of_type_Aicx.a() != null) {
        break label25;
      }
      bool1 = bool2;
    }
    label25:
    do
    {
      return bool1;
      Object localObject = this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if ((localObject != null) && (AIOImageData.class.isInstance(localObject)) && (this.jdField_a_of_type_Aicx.a().jdField_a_of_type_Aidx != null) && (this.jdField_a_of_type_Aicx.a().jdField_a_of_type_Aidx.jdField_c_of_type_Boolean))
      {
        if (this.jdField_a_of_type_Aicq != null) {
          this.jdField_a_of_type_Aidz.b(this.jdField_a_of_type_Aicq.jdField_a_of_type_Long, this.jdField_a_of_type_Aicq.jdField_a_of_type_Int, 4);
        }
        this.jdField_a_of_type_Aicx.a().jdField_a_of_type_Aidx.jdField_c_of_type_Boolean = false;
        u();
        return true;
      }
      c(false);
      bool2 = super.e();
      y();
      localObject = a().findViewById(2131367352);
      if (localObject != null) {
        ((View)localObject).setVisibility(4);
      }
      if (this.jdField_j_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_Aicx.a();
        if (localObject != null)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", ((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
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
    w();
    aidw localaidw = this.jdField_a_of_type_Aicx.b();
    if (localaidw != null) {
      localaidw.jdField_b_of_type_Boolean = true;
    }
    if (!g()) {
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
    if (this.jdField_k_of_type_Int == 4) {
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    this.jdField_a_of_type_Aicr.jdField_d_of_type_Boolean = false;
    u();
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  public boolean f()
  {
    if (adak.a(this.jdField_g_of_type_Int) == 1032) {}
    label229:
    label230:
    for (;;)
    {
      return false;
      if ((this.jdField_g_of_type_Int != 1037) && (adak.a(this.jdField_g_of_type_Int) != 1044) && (!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Aicx != null))
      {
        Object localObject = this.jdField_a_of_type_Aicx.a();
        if (AIOImageData.class.isInstance(((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          AIOImageData localAIOImageData = (AIOImageData)((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          localObject = localAIOImageData.a(4);
          if (localObject != null) {
            break label229;
          }
          localObject = localAIOImageData.a(2);
        }
        for (;;)
        {
          if ((localObject == null) && (this.t)) {
            break label230;
          }
          if ((!this.t) && (!this.jdField_c_of_type_Boolean)) {}
          for (boolean bool = true;; bool = false)
          {
            return bool;
            if (AIOShortVideoData.class.isInstance(((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
            {
              localObject = ((AIOShortVideoData)((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(1);
              if ((localObject == null) || (!((File)localObject).exists())) {
                break;
              }
              return true;
            }
            if (AIOFilePicData.class.isInstance(((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
            {
              if (this.jdField_c_of_type_Boolean) {
                break;
              }
              return true;
            }
            if (!AIOFileVideoData.class.isInstance(((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
              break;
            }
            localObject = (AIOFileVideoData)((aidw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
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
    this.jdField_a_of_type_Aicr.jdField_d_of_type_Boolean = true;
    u();
    if (!h()) {
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    if (this.jdField_d_of_type_AndroidWidgetImageButton != null) {
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
  }
  
  boolean g()
  {
    return false;
  }
  
  public void h()
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
    if (this.jdField_a_of_type_Bdcy != null) {
      this.jdField_a_of_type_Bdcy.b();
    }
    this.jdField_a_of_type_Aicr.jdField_f_of_type_Boolean = true;
    u();
  }
  
  boolean h()
  {
    return false;
  }
  
  public void h_()
  {
    r();
    if (this.jdField_a_of_type_Aksn != null) {
      this.jdField_a_of_type_Aksn.i();
    }
  }
  
  public void i()
  {
    if (this.jdField_l_of_type_Boolean)
    {
      this.jdField_l_of_type_Boolean = false;
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatHistoryFileActivity.class);
      localIntent.addFlags(603979776);
      aidw localaidw = this.jdField_a_of_type_Aicx.a();
      if (localaidw != null) {
        localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
      }
      localIntent.putExtra("tab_tab_type", 0);
      localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("uintype", this.jdField_g_of_type_Int);
      localIntent.putExtra("extra.IS_FROM_CHAT_AIO_GALLERY", true);
      localIntent.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getString(2131690728));
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
    }
  }
  
  public void j()
  {
    aidw localaidw = this.jdField_a_of_type_Aicx.a();
    if ((localaidw != null) && (AIOShortVideoData.class.isInstance(localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) && (((AIOShortVideoData)localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_Aksn != null)) {
      this.jdField_a_of_type_Aksn.j();
    }
    AppNetConnInfo.unregisterNetInfoHandler(this);
    super.j();
    if (this.jdField_m_of_type_Int > 0) {
      bdll.b(null, "CliOper", "", "", "View_pic", "View_pic_spin", 0, 0, "" + this.jdField_m_of_type_Int, "", "", "");
    }
    aibo.a().b(this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.c();
    }
    this.jdField_a_of_type_Bdcy = null;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    aiei.a().a();
    if (this.jdField_a_of_type_Aqgi != null) {
      this.jdField_a_of_type_Aqgi.b();
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onStop");
    }
    super.n();
    D();
    Object localObject1 = this.jdField_a_of_type_Aicx.a();
    if ((localObject1 == null) || (((aidw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          localObject2 = (ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372146);
          if ((!(((aidw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)) || (((AIOShortVideoData)((aidw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Int != 1)) {
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
        if ((!(((aidw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)) || (((AIOShortVideoData)((aidw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Int != 0)) {
          break;
        }
      } while (this.jdField_a_of_type_Aksn == null);
      this.jdField_a_of_type_Aksn.h();
      return;
    } while ((!AIOFileVideoData.class.isInstance(((aidw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) || (this.jdField_a_of_type_Aksn == null) || (!this.jdField_a_of_type_Aksn.c()));
    this.jdField_a_of_type_Aksn.h();
  }
  
  public void o()
  {
    super.o();
    aidw localaidw = this.jdField_a_of_type_Aicx.b();
    if (localaidw != null) {
      localaidw.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      F();
      continue;
      bdll.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "1", "", "", "");
      c(2);
      continue;
      J();
      continue;
      x();
      bdll.b(null, "dc00898", "", "", "0X8009EFD", "0X8009EFD", a(), b(), "" + a("0X8009EFD"), "", "", "");
      continue;
      C();
      bdll.b(null, "dc00898", "", "", "0X8009EFC", "0X8009EFC", a(), b(), "" + a("0X8009EFC"), "", "", "");
      continue;
      aidw localaidw = this.jdField_a_of_type_Aicx.a();
      if ((localaidw != null) && (localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && ((localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFilePicData)))
      {
        if (this.jdField_a_of_type_Aicq != null)
        {
          e();
          e();
        }
      }
      else if ((localaidw != null) && (localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && ((localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) && (((AIOImageData)localaidw.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Int == 3) && (this.jdField_a_of_type_Aicq != null))
      {
        e();
        e();
        continue;
        a(paramView);
        continue;
        G();
        continue;
        H();
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
    label260:
    label310:
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
          break label260;
        }
        if (!AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView)) {
          break label252;
        }
        AIOGalleryAdapter.GalleryImageStruct localGalleryImageStruct = (AIOGalleryAdapter.GalleryImageStruct)paramView;
        if (!localGalleryImageStruct.a(localMotionEvent)) {
          break label244;
        }
        localGalleryImageStruct.b(paramInt);
      }
      for (;;)
      {
        if ((!AIOFileVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) || (this.jdField_a_of_type_Aksn == null)) {
          break label310;
        }
        if ((localMotionEvent == null) || (this.jdField_a_of_type_Aksn == null) || (!this.jdField_a_of_type_Aksn.a(localMotionEvent))) {
          break label312;
        }
        paramAdapterView = (AIOFileVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        paramAdapterView.a(paramView, this.jdField_a_of_type_Aksn);
        paramAdapterView.jdField_d_of_type_Boolean = false;
        if (TextUtils.isEmpty(paramAdapterView.jdField_c_of_type_JavaLangString)) {
          break;
        }
        u();
        return;
        label244:
        e();
        continue;
        label252:
        e();
        continue;
        if ((this.jdField_a_of_type_Aksn != null) && (localMotionEvent != null) && (this.jdField_a_of_type_Aksn.a(localMotionEvent)))
        {
          if (!this.jdField_a_of_type_Aicr.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_Aksn.f();
          }
        }
        else {
          e();
        }
      }
    }
    label312:
    e();
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    e(paramInt);
    c(false);
    this.jdField_a_of_type_ComTencentWidgetGallery.b(true);
    this.jdField_a_of_type_ComTencentWidgetGallery.a(true);
    AIOGalleryAdapter.GalleryImageStruct localGalleryImageStruct;
    Drawable localDrawable;
    if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView))
    {
      localGalleryImageStruct = (AIOGalleryAdapter.GalleryImageStruct)paramView;
      localDrawable = localGalleryImageStruct.a();
      if ((!localGalleryImageStruct.a()) && (localDrawable != null) && ((localDrawable instanceof URLDrawable))) {
        a(paramAdapterView, paramView, paramInt, paramLong);
      }
    }
    else
    {
      a(false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramAdapterView, paramView, paramInt, paramLong);
        paramAdapterView = a().findViewById(2131367352);
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
      paramAdapterView = this.jdField_a_of_type_Aicx.a(paramInt);
      if (paramAdapterView != null) {
        this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(paramAdapterView.b());
      }
      if (paramAdapterView != null)
      {
        if ((!(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFilePicData)) || (!((AIOFilePicData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_f_of_type_Boolean)) {
          break label303;
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
      b(paramAdapterView);
      u();
      if ((paramAdapterView != null) && (this.jdField_a_of_type_Bdcy != null))
      {
        if (!(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)) {
          break label333;
        }
        this.jdField_a_of_type_Bdcy.a((AIOShortVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
      }
      return;
      if ((localGalleryImageStruct.a()) || (localDrawable == null) || (!(localDrawable instanceof SkinnableBitmapDrawable))) {
        break;
      }
      f(paramInt);
      break;
      label303:
      if ((paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData))
      {
        a(false);
        this.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    label333:
    this.jdField_a_of_type_Bdcy.a(null);
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
    if (this.jdField_a_of_type_Aksn != null) {
      this.jdField_a_of_type_Aksn.d(1);
    }
    aiei.a().a();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onNetNone2Mobile s=" + paramString);
    }
    E();
    aiei.a().a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onNetNone2Wifi s=" + paramString);
    }
    aiei.a().a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onNetWifi2Mobile s=" + paramString);
    }
    E();
    aiei.a().a();
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
      paramSeekBar = this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (!(paramSeekBar instanceof AIOShortVideoData)) {
        break label127;
      }
      paramSeekBar = (AIOShortVideoData)paramSeekBar;
      if (paramSeekBar.jdField_b_of_type_Int != 0) {
        break label67;
      }
      if (this.jdField_a_of_type_Aksn != null)
      {
        paramInt = (int)(paramInt / 10000.0F * (float)this.jdField_a_of_type_Aksn.b());
        this.jdField_a_of_type_Aksn.c(paramInt);
      }
    }
    label66:
    label67:
    label127:
    while ((!AIOFileVideoData.class.isInstance(paramSeekBar)) || (this.jdField_a_of_type_Aksn == null))
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
    paramInt = (int)(paramInt / 10000.0F * (float)this.jdField_a_of_type_Aksn.b());
    this.jdField_a_of_type_Aksn.c(paramInt);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (this.jdField_a_of_type_Aksn != null) {
      this.jdField_a_of_type_Aksn.m();
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void p()
  {
    super.p();
    aidw localaidw = this.jdField_a_of_type_Aicx.b();
    if (localaidw != null) {
      localaidw.jdField_b_of_type_Boolean = false;
    }
    this.jdField_k_of_type_Int = 3;
    this.s = true;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof AIOGalleryActivity))
    {
      ((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).jdField_c_of_type_Boolean = false;
      ((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).jdField_a_of_type_Long = -1L;
    }
  }
  
  protected void r()
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    for (int i1 = 4356;; i1 = 4)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setSystemUiVisibility(i1);
      return;
    }
  }
  
  public void u()
  {
    if ((this.jdField_a_of_type_Aicr.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Aicr.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_Aicr.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Aicr.jdField_f_of_type_Boolean))
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
    }
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)) {
        a(this.jdField_a_of_type_Aicx.a());
      }
      while ((this.jdField_k_of_type_Int == 4) || (adak.a(this.jdField_g_of_type_Int) == 1032))
      {
        this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
        return;
        if ((this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) {
          a((AIOImageData)this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_Aicx.a());
        } else if ((this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFilePicData)) {
          a((AIOFilePicData)this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
        } else if ((this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData)) {
          a((AIOFileVideoData)this.jdField_a_of_type_Aicx.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
        }
      }
    }
  }
  
  public void v() {}
  
  @TargetApi(11)
  public void w()
  {
    if ((this.t) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Aicx.b());
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
    localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", ((aidw)this.jdField_a_of_type_Abjt.a()).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
    localIntent.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getString(2131690728));
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", true);
    if (i1 == 0) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772297, 2130772238);
  }
  
  public void y()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetGallery == null) || (this.jdField_a_of_type_Aicx == null)) {}
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
        i3 = this.jdField_a_of_type_Aicx.b();
      } while ((i3 < i1) || (i3 > i2 + i1 - 1));
      View localView = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i3 - i1);
      if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(localView))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(i3, (AIOGalleryAdapter.GalleryImageStruct)localView);
        return;
      }
    } while (this.jdField_a_of_type_Aksn == null);
    this.jdField_a_of_type_Aksn.k();
  }
  
  public void z()
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Aicx.c() == 0)
    {
      azqj.b(false);
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131692661, 0).a();
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(true);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = true;
      int i1 = this.jdField_a_of_type_Aicx.b();
      if (i1 == this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedItemPosition()) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(i1);
      return;
      azqj.b(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibr
 * JD-Core Version:    0.7.0.1
 */