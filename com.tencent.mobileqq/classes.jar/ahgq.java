import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpakcetPreviewConfBean.BreathLight;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbConversationEntry.2;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbConversationEntry.4;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbConversationEntry.5;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbConversationEntry.7;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbEntrySplashView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ahgq
  extends alww
{
  private long jdField_a_of_type_Long;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  public bfok a;
  private SpringHbEntrySplashView jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbEntrySplashView;
  public Runnable a;
  private int e = -1;
  private int f;
  private int g;
  private int h;
  private boolean i;
  
  public ahgq(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    super(paramConversation, paramViewGroup);
    this.jdField_a_of_type_Bfok = new ahgr(this);
    this.jdField_a_of_type_JavaLangRunnable = new SpringHbConversationEntry.2(this);
    try
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(16908290);
      if (this.jdField_a_of_type_AndroidViewView == null) {
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
      }
      return;
    }
    catch (Throwable paramConversation)
    {
      QLog.e("springHb_SpringHbConversationEntry", 1, "ConversationSpringHbEntry", paramConversation);
    }
  }
  
  private void e(int paramInt)
  {
    bfuc.jdField_a_of_type_Int = paramInt;
  }
  
  private void e(boolean paramBoolean)
  {
    try
    {
      QLog.i("springHb_SpringHbConversationEntry", 2, "notifyLoadTransferPage, mActiveState:" + this.e + ", isDoingJumpAnimation:" + this.i + ", mResume:" + this.jdField_a_of_type_Boolean);
      ((ahfx)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(342)).a((ViewGroup)this.jdField_a_of_type_AndroidViewView, paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbConversationEntry", 1, "notifyLoadTransferPage", localThrowable);
    }
  }
  
  private void f(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringHbConversationEntry", 2, "changeActiveState -->oldState:" + this.e + ",curState:" + paramInt);
    }
    this.e = paramInt;
  }
  
  private void f(boolean paramBoolean)
  {
    try
    {
      c(0);
      c(true);
      h();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbEntrySplashView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbEntrySplashView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView != null)
      {
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setEnableTouch(true);
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setActiveListViewListener(null);
        if (paramBoolean)
        {
          this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.h();
          return;
        }
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.d();
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.g();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbConversationEntry", 1, localThrowable, new Object[0]);
    }
  }
  
  private void g(int paramInt)
  {
    if (paramInt == 2) {
      ahif.a("sq.xcx.bp", 1, 0, null);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringHbConversationEntry", 2, "reportEnterClick....type:" + paramInt);
      }
      return;
      if (paramInt == 3) {
        ahif.a("sq.xcx.qp", 1, 0, null);
      } else {
        ahif.a("sq.dz", 1, 0, null);
      }
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        j = bbll.b(110.0F);
        ahqy.jdField_a_of_type_Int = j;
        ahqy localahqy = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Ahqy;
        if (localahqy != null) {
          localahqy.g();
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("springHb_SpringHbConversationEntry", 2, "updateCareBarTopMargin..." + j);
        return;
      }
      catch (Throwable localThrowable)
      {
        int j;
        QLog.e("springHb_SpringHbConversationEntry", 1, localThrowable, new Object[0]);
      }
      j = bbll.a(50.0F);
    }
  }
  
  private void q()
  {
    try
    {
      QLog.i("springHb_SpringHbConversationEntry", 2, "doJumpToAct mActiveState:" + this.e + ", isDoingJumpAnimation:" + this.i + ", mResume:" + this.jdField_a_of_type_Boolean);
      if (!this.i)
      {
        if (!this.jdField_a_of_type_Boolean) {
          return;
        }
        ((ahfx)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(342)).b();
        this.i = true;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbEntrySplashView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbEntrySplashView.c();
        }
        if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView != null) {
          this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setEnableTouch(false);
        }
        h();
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        if (this.jdField_a_of_type_Int <= 0) {
          g();
        }
        e(400);
        c(-this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2004);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2004, 400L);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbConversationEntry", 1, "doJumpToAct", localThrowable);
      e(400);
    }
  }
  
  private void r()
  {
    try
    {
      QLog.i("springHb_SpringHbConversationEntry", 2, "doJumpToAct run, mActiveState:" + this.e + ", isDoingJumpAnimation:" + this.i + ", mResume:" + this.jdField_a_of_type_Boolean);
      e(400);
      if (!this.jdField_a_of_type_Boolean)
      {
        h();
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 0L);
        this.i = false;
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Ahoi != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Ahoi.a())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Ahoi.b();
      }
      s();
      h();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
      this.i = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbConversationEntry", 1, "doJumpToAct", localThrowable);
    }
  }
  
  private void s()
  {
    e(false);
  }
  
  private void t()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityConversation.b() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityConversation.b().getBackground() != null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.b().getBackground();
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.b().setBackgroundDrawable(null);
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.b().setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  private void v()
  {
    for (;;)
    {
      int j;
      int k;
      try
      {
        if (this.e != -1) {
          break label428;
        }
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView = ((ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374872));
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.a = this;
        j = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().getDisplayMetrics().heightPixels;
        k = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().getDisplayMetrics().widthPixels;
        if (j <= k) {
          break label610;
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          break label604;
        }
        j -= ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
        k = 0;
        this.h = j;
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.d = (j * 57 / 100);
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_b_of_type_Boolean = false;
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
        int m = actj.a(50.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        if ((localObject == null) || (((View)localObject).getBottom() - ((View)localObject).getTop() == 0))
        {
          this.jdField_c_of_type_Int = m;
          if (k != 0)
          {
            k = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
            int n = (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131296998);
            this.jdField_f_of_type_Int = ((int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131296999));
            this.g = ((int)(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298020) - this.jdField_c_of_type_Int) / 2);
            this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.e = this.g;
            this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getHeight();
            this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getWidth();
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbEntrySplashView = new SpringHbEntrySplashView(this.jdField_a_of_type_AndroidAppActivity);
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbEntrySplashView.a(this);
            localObject = new FrameLayout.LayoutParams(-1, j);
            j = this.jdField_f_of_type_Int / 2;
            n /= 2;
            int i1 = this.g;
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbEntrySplashView.setLayoutParams((ViewGroup.LayoutParams)localObject);
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbEntrySplashView.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbEntrySplashView.setTipMarginTop(k + m + j - n);
            this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362987));
            this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbEntrySplashView);
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbEntrySplashView.a(true);
            f(1);
          }
        }
        else
        {
          this.jdField_c_of_type_Int = (((View)localObject).getBottom() - ((View)localObject).getTop());
          continue;
        }
        k = 0;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("springHb_SpringHbConversationEntry", 1, "ensureInit", localThrowable);
        return;
      }
      continue;
      label428:
      if ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView != null) && (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.a != this))
      {
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.a = this;
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.d = (this.h * 57 / 100);
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.e = this.g;
        QLog.i("springHb_SpringHbConversationEntry", 2, "ensureInit handle after conflict, mListViewHeight:" + this.jdField_a_of_type_Int + " mListViewWidth:" + this.jdField_b_of_type_Int + " mBackgroundBannerHeight:" + this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.d + " mBannerHeightWithoutTitlebar:" + this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.e + " mPullMsgMaxScope:" + this.g + " mTitlebarHeight:" + this.jdField_c_of_type_Int + " mViewHeight:" + this.h);
        return;
        label604:
        k = 1;
      }
      else
      {
        return;
        label610:
        j = k;
      }
    }
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView != null)
    {
      boolean bool = ((ahfx)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(342)).d();
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.b(bool);
      bool = ((ahfx)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(342)).e();
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setShowLightByUser(bool);
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversation != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
      if (localObject != null)
      {
        localObject = ((PullRefreshHeader)localObject).findViewById(2131375051);
        if (localObject != null)
        {
          ((View)localObject).setVisibility(4);
          ((View)localObject).postDelayed(new SpringHbConversationEntry.7(this, (View)localObject), 1500L);
        }
      }
    }
  }
  
  public void a()
  {
    try
    {
      QLog.i("springHb_SpringHbConversationEntry", 2, "normalMode, mState=" + this.e);
      c(true);
      if (this.e == -1) {
        return;
      }
      f(false);
      a(false);
      f(1);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbConversationEntry", 1, "normalMode ", localThrowable);
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (!b()) {
        return;
      }
      QLog.i("springHb_SpringHbConversationEntry", 2, "onMsgPullFinished, result=" + paramInt);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbEntrySplashView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbEntrySplashView.a(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbEntrySplashView.postDelayed(new SpringHbConversationEntry.4(this), 800L);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbConversationEntry", 1, "onMsgPullFinished ", localThrowable);
    }
  }
  
  /* Error */
  public void a(android.graphics.Bitmap paramBitmap, java.lang.String paramString, java.util.List<android.graphics.Bitmap> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 305	ahgq:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   5: ldc_w 306
    //   8: invokevirtual 307	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   11: checkcast 197	com/tencent/widget/ARMapHongBaoListView
    //   14: putfield 195	ahgq:jdField_a_of_type_ComTencentWidgetARMapHongBaoListView	Lcom/tencent/widget/ARMapHongBaoListView;
    //   17: aload_0
    //   18: getfield 195	ahgq:jdField_a_of_type_ComTencentWidgetARMapHongBaoListView	Lcom/tencent/widget/ARMapHongBaoListView;
    //   21: ifnonnull +13 -> 34
    //   24: ldc 62
    //   26: iconst_2
    //   27: ldc_w 473
    //   30: invokestatic 141	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: return
    //   34: getstatic 476	ahgj:jdField_a_of_type_Int	I
    //   37: istore 4
    //   39: ldc 62
    //   41: iconst_2
    //   42: new 114	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 478
    //   52: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_0
    //   56: getfield 26	ahgq:e	I
    //   59: invokevirtual 125	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 480
    //   65: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload 4
    //   70: invokevirtual 125	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 141	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: iload 4
    //   81: iconst_1
    //   82: if_icmpne +130 -> 212
    //   85: aload_0
    //   86: invokespecial 482	ahgq:v	()V
    //   89: ldc 62
    //   91: iconst_2
    //   92: new 114	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 484
    //   102: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: getfield 26	ahgq:e	I
    //   109: invokevirtual 125	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 141	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: aload_0
    //   119: getfield 26	ahgq:e	I
    //   122: iconst_2
    //   123: if_icmpeq +49 -> 172
    //   126: aload_0
    //   127: iconst_2
    //   128: invokespecial 409	ahgq:f	(I)V
    //   131: aload_0
    //   132: getfield 74	ahgq:jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbEntrySplashView	Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbEntrySplashView;
    //   135: iconst_0
    //   136: invokevirtual 192	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbEntrySplashView:setVisibility	(I)V
    //   139: aload_0
    //   140: getfield 195	ahgq:jdField_a_of_type_ComTencentWidgetARMapHongBaoListView	Lcom/tencent/widget/ARMapHongBaoListView;
    //   143: iload 4
    //   145: invokevirtual 485	com/tencent/widget/ARMapHongBaoListView:a	(I)V
    //   148: aload_0
    //   149: getfield 195	ahgq:jdField_a_of_type_ComTencentWidgetARMapHongBaoListView	Lcom/tencent/widget/ARMapHongBaoListView;
    //   152: aload_0
    //   153: getfield 33	ahgq:jdField_a_of_type_Bfok	Lbfok;
    //   156: invokevirtual 487	com/tencent/widget/ARMapHongBaoListView:a	(Lbfok;)V
    //   159: aload_0
    //   160: getfield 74	ahgq:jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbEntrySplashView	Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbEntrySplashView;
    //   163: aload_0
    //   164: getfield 50	ahgq:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   167: aload_1
    //   168: aload_2
    //   169: invokevirtual 491	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbEntrySplashView:setContent	(Landroid/view/View;Landroid/graphics/Bitmap;Ljava/lang/String;)V
    //   172: invokestatic 494	ahgj:a	()Lahgj;
    //   175: aload_0
    //   176: getfield 144	ahgq:jdField_a_of_type_ComTencentMobileqqActivityConversation	Lcom/tencent/mobileqq/activity/Conversation;
    //   179: getfield 149	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   182: invokevirtual 497	ahgj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   185: return
    //   186: astore_1
    //   187: ldc 62
    //   189: iconst_1
    //   190: ldc_w 499
    //   193: aload_1
    //   194: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   197: return
    //   198: astore_1
    //   199: ldc 62
    //   201: iconst_1
    //   202: ldc_w 501
    //   205: aload_1
    //   206: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   209: goto -37 -> 172
    //   212: aload_0
    //   213: iconst_2
    //   214: invokespecial 409	ahgq:f	(I)V
    //   217: aload_0
    //   218: getfield 195	ahgq:jdField_a_of_type_ComTencentWidgetARMapHongBaoListView	Lcom/tencent/widget/ARMapHongBaoListView;
    //   221: iload 4
    //   223: invokevirtual 485	com/tencent/widget/ARMapHongBaoListView:a	(I)V
    //   226: aload_0
    //   227: getfield 195	ahgq:jdField_a_of_type_ComTencentWidgetARMapHongBaoListView	Lcom/tencent/widget/ARMapHongBaoListView;
    //   230: new 503	ahgs
    //   233: dup
    //   234: aload_0
    //   235: invokespecial 504	ahgs:<init>	(Lahgq;)V
    //   238: invokevirtual 508	com/tencent/widget/ARMapHongBaoListView:setOnPendentClickListener	(Lbfom;)V
    //   241: goto -69 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	ahgq
    //   0	244	1	paramBitmap	android.graphics.Bitmap
    //   0	244	2	paramString	java.lang.String
    //   0	244	3	paramList	java.util.List<android.graphics.Bitmap>
    //   37	185	4	j	int
    // Exception table:
    //   from	to	target	type
    //   0	33	186	java/lang/Throwable
    //   34	79	186	java/lang/Throwable
    //   172	185	186	java/lang/Throwable
    //   199	209	186	java/lang/Throwable
    //   212	241	186	java/lang/Throwable
    //   85	172	198	java/lang/Throwable
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      QLog.i("springHb_SpringHbConversationEntry", 2, "pendant show:" + paramBoolean + " pendanting:" + this.jdField_b_of_type_Boolean + ", mResume=" + this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView == null) {
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView = ((ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374872));
      }
      w();
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.c();
        ahif.a("sq.dz", 0, 0, null);
      }
      for (;;)
      {
        ahgj.jdField_b_of_type_Boolean = paramBoolean;
        g(paramBoolean);
        return;
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.d();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbConversationEntry", 1, "pendant ", localThrowable);
    }
  }
  
  public void a(boolean paramBoolean, SpringFestivalRedpakcetPreviewConfBean.BreathLight paramBreathLight)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView = ((ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374872));
        if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView == null) {
          return;
        }
        if ((paramBoolean) && (paramBreathLight != null) && (paramBreathLight.breathTimeInfo != null) && (!bbkk.a(paramBreathLight.resUrl)))
        {
          DownloadParam localDownloadParam = new DownloadParam();
          localDownloadParam.filePos = 0;
          localDownloadParam.url = paramBreathLight.resUrl;
          if (QLog.isColorLevel()) {
            QLog.i("springHb_SpringHbConversationEntry", 2, "onLightChange -->,getResPath...start,breathLight:" + paramBreathLight);
          }
          w();
          PreloadManager.a().a(localDownloadParam, new ahgt(this, paramBreathLight));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("springHb_SpringHbConversationEntry", 2, "onLightChange....show:" + paramBoolean + ",breathLight:" + paramBreathLight);
          return;
        }
      }
      catch (Throwable paramBreathLight)
      {
        QLog.e("springHb_SpringHbConversationEntry", 1, paramBreathLight, new Object[0]);
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.f();
    }
  }
  
  public boolean a()
  {
    try
    {
      if (!b()) {
        return false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbEntrySplashView != null)
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbEntrySplashView.a();
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbConversationEntry", 1, "isPullingMsg", localThrowable);
    }
    return false;
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView != null)
        {
          int k = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getListViewScrollY();
          j = k;
          if (k < bbll.a(ahhb.a - 20.0F))
          {
            this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.j();
            j = k;
          }
          if (QLog.isDevelopLevel()) {
            QLog.i("springHb_SpringHbConversationEntry", 4, "resumeAnim...,viewScrollY:" + j + ",pendent_height:" + bbll.a(ahhb.a));
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("springHb_SpringHbConversationEntry", 1, localThrowable, new Object[0]);
        return;
      }
      int j = 0;
    }
  }
  
  public void b(int paramInt)
  {
    QLog.i("springHb_SpringHbConversationEntry", 1, "onEnterActiveClick, mActiveState:" + this.e + ",clickType:" + paramInt);
    if (paramInt == 1)
    {
      if (Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long) < 2600L) {
        return;
      }
      if (!ahhb.a())
      {
        QLog.e("springHb_SpringHbConversationEntry", 1, "onEnterActiveClick illegal state:default pendant is not load");
        return;
      }
    }
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    boolean bool = false;
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        bool = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.a(1100);
        if (bool)
        {
          ThreadManagerV2.getUIHandlerV2().postDelayed(new SpringHbConversationEntry.5(this), 1100L);
          g(paramInt);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("springHb_SpringHbConversationEntry", 2, "onEnterActiveClick,type:" + paramInt + ",mIsNetSupport=" + this.jdField_c_of_type_Boolean + ",hitSuccess:" + bool);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("springHb_SpringHbConversationEntry", 1, "onEnterActiveClick ", localThrowable);
        return;
      }
      s();
      continue;
      e(true);
    }
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.e != -1)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityConversation != null) {
          break label64;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringHbConversationEntry", 2, "isShowingEntrance, " + bool1);
      }
      return bool1;
      label64:
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.g)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.h) {
          bool1 = true;
        }
      }
    }
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView != null) {
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.i();
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("springHb_SpringHbConversationEntry", 4, "pauseAnim...");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbConversationEntry", 1, localThrowable, new Object[0]);
    }
  }
  
  public void d()
  {
    try
    {
      super.d();
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringHbConversationEntry", 2, "onResume, mActiveState=" + this.e + ",isShowingEntrance:" + b());
      }
      ((ahfx)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(342)).a();
      b();
      w();
      if (!b()) {
        return;
      }
      ahgj.a().a();
      if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView != null) {
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setEnableTouch(true);
      }
      h();
      if (ahgj.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 0L);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbConversationEntry", 1, "onResume ", localThrowable);
    }
  }
  
  public void e()
  {
    try
    {
      super.e();
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringHbConversationEntry", 2, "onPause, mActiveState=" + this.e + ",isShowingEntrance:" + b());
      }
      c();
      if (!b()) {
        return;
      }
      if ((ahgj.jdField_a_of_type_Int == 1) && (!this.jdField_f_of_type_Boolean))
      {
        c(0);
        c(true);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbConversationEntry", 1, "onPause ", localThrowable);
    }
  }
  
  public void f()
  {
    try
    {
      super.f();
      if (b()) {
        QLog.i("springHb_SpringHbConversationEntry", 1, "onDestroy....,mEntryMode:" + ahgj.jdField_a_of_type_Int);
      }
      ahgj.jdField_a_of_type_Int = 0;
      u();
      a(false, null);
      a(false);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbConversationEntry", 1, localThrowable, new Object[0]);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 2004: 
      r();
      ahif.a("sq.zjjr", 2, 0, null);
      return false;
    }
    a(0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahgq
 * JD-Core Version:    0.7.0.1
 */