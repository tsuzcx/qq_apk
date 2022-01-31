import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbEntryPendantHolder.1;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbEntryPendantHolder.5;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbEntryPendantHolder.6;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbEntryPendantHolder.7;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.io.File;
import java.net.URL;

public class ahhb
  extends alwu
{
  public static float a;
  private static boolean jdField_b_of_type_Boolean;
  private ahhg jdField_a_of_type_Ahhg;
  private volatile ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private auqh jdField_a_of_type_Auqh;
  private String jdField_a_of_type_JavaLangString;
  private volatile Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private auqh jdField_b_of_type_Auqh;
  private String jdField_b_of_type_JavaLangString;
  private boolean c;
  private boolean d;
  private volatile boolean e;
  private boolean f;
  private int k;
  private int l;
  
  static
  {
    jdField_a_of_type_Float = 112.0F;
  }
  
  public ahhb(View paramView)
  {
    super(paramView);
  }
  
  private void a(ahgg paramahgg)
  {
    ThreadManagerV2.executeOnFileThread(new SpringHbEntryPendantHolder.1(this, paramahgg));
  }
  
  static boolean a()
  {
    QLog.d("springHb_SpringHbEntryPendantHolder", 1, "canPendantClick：" + jdField_b_of_type_Boolean + ",isPendanting:" + ahgj.jdField_b_of_type_Boolean);
    return (jdField_b_of_type_Boolean) && (ahgj.jdField_b_of_type_Boolean);
  }
  
  private boolean a(Drawable paramDrawable)
  {
    return ((paramDrawable instanceof URLDrawable)) && ((((URLDrawable)paramDrawable).getCurrDrawable() instanceof ApngDrawable));
  }
  
  private void b(ahgg paramahgg)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.filePos = 0;
    localDownloadParam.url = paramahgg.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringHbEntryPendantHolder", 2, "tryLoadDefaultRes -->,getResPath...start,resUrl:" + paramahgg.jdField_a_of_type_JavaLangString);
    }
    PreloadManager.a().a(localDownloadParam, new ahhc(this, paramahgg));
  }
  
  private boolean b(Drawable paramDrawable)
  {
    try
    {
      if (!a(paramDrawable)) {
        break label74;
      }
      paramDrawable = (ApngDrawable)((URLDrawable)paramDrawable).getCurrDrawable();
      paramDrawable.repaly();
      paramDrawable.resume();
      bool = true;
    }
    catch (Throwable paramDrawable)
    {
      for (;;)
      {
        QLog.e("springHb_SpringHbEntryPendantHolder", 1, paramDrawable, new Object[0]);
        label74:
        boolean bool = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringHbEntryPendantHolder", 2, "doPlayDrumAnim: playSuccess:" + bool);
    }
    return bool;
  }
  
  private void c(ahgg paramahgg)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.filePos = 0;
    localDownloadParam.url = paramahgg.jdField_b_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringHbEntryPendantHolder", 2, "tryLoadActivityRes -->,getResPath...start,resUrl:" + paramahgg.jdField_b_of_type_JavaLangString);
    }
    PreloadManager.a().a(localDownloadParam, new ahhd(this, paramahgg));
  }
  
  private void c(Drawable paramDrawable)
  {
    try
    {
      if ((paramDrawable instanceof URLDrawable))
      {
        String str = ((URLDrawable)paramDrawable).getURL().toString();
        paramDrawable = (URLDrawable)paramDrawable;
        URLDrawable.removeMemoryCacheByUrl(str);
        if (QLog.isColorLevel()) {
          QLog.d("springHb_SpringHbEntryPendantHolder", 2, "removeDrawableCache,url：" + str);
        }
      }
      return;
    }
    catch (Exception paramDrawable)
    {
      QLog.e("springHb_SpringHbEntryPendantHolder", 1, paramDrawable, new Object[0]);
    }
  }
  
  private void d(ahgg paramahgg)
  {
    if (bbkk.a(paramahgg.c)) {
      return;
    }
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.filePos = 0;
    localDownloadParam.url = paramahgg.c;
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringHbEntryPendantHolder", 2, "tryLoadLogoRes -->,getResPath...start,resUrl:" + paramahgg.c);
    }
    PreloadManager.a().a(localDownloadParam, new ahhe(this));
  }
  
  private void h()
  {
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      c(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
      jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_Auqh != null)
      {
        c(this.jdField_a_of_type_Auqh.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_Auqh.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      }
      this.c = false;
      if (this.jdField_b_of_type_Auqh != null)
      {
        c(this.jdField_b_of_type_Auqh.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_b_of_type_Auqh.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      }
      this.d = false;
      this.e = false;
      p();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntryPendantHolder", 1, localThrowable, new Object[0]);
    }
  }
  
  private void i()
  {
    ThreadManagerV2.getUIHandlerV2().post(new SpringHbEntryPendantHolder.5(this));
  }
  
  private void j()
  {
    label192:
    for (;;)
    {
      try
      {
        Object localObject;
        if (!jdField_b_of_type_Boolean)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("key_play_apng", true);
          String str = this.jdField_a_of_type_JavaLangString + "gu.png";
          if (!new File(str).exists()) {
            break label192;
          }
          BitmapDrawable localBitmapDrawable = new BitmapDrawable(ahgj.a("spring_hb/qvip_pay_entry_drum_default.png", true));
          localObject = QWalletPicHelper.getDrawableForWallet(str, aywm.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localBitmapDrawable, (Bundle)localObject);
          if (localObject != null)
          {
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject);
            this.jdField_a_of_type_Ahhg = new ahhg(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
            jdField_b_of_type_Boolean = true;
          }
        }
        else
        {
          QLog.w("springHb_SpringHbEntryPendantHolder", 2, "loadDrumDrawable..isSuccess" + jdField_b_of_type_Boolean);
          return;
        }
        QLog.i("springHb_SpringHbEntryPendantHolder", 2, "loadDrumDrawable..failed,mDrumDrawable" + localObject);
        continue;
        QLog.w("springHb_SpringHbEntryPendantHolder", 2, "loadDrumDrawable..file not exist");
      }
      catch (Throwable localThrowable)
      {
        QLog.e("springHb_SpringHbEntryPendantHolder", 2, localThrowable, new Object[0]);
        return;
      }
    }
  }
  
  private void k()
  {
    label168:
    for (;;)
    {
      try
      {
        if (!this.d)
        {
          Object localObject = new Bundle();
          ((Bundle)localObject).putBoolean("key_play_apng", true);
          String str = this.jdField_b_of_type_JavaLangString + "logo.png";
          if (!new File(str).exists()) {
            break label168;
          }
          localObject = QWalletPicHelper.getDrawableForWallet(str, aywm.jdField_a_of_type_AndroidGraphicsDrawableDrawable, (Bundle)localObject);
          if (localObject != null)
          {
            this.jdField_b_of_type_Auqh.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject);
            this.jdField_a_of_type_Ahhg = new ahhg(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_Auqh.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            this.d = true;
          }
        }
        else
        {
          QLog.w("springHb_SpringHbEntryPendantHolder", 2, "loadLogoDrawable..isSuccess" + this.d);
          return;
        }
        QLog.w("springHb_SpringHbEntryPendantHolder", 2, "loadLogoDrawable..failed");
        continue;
        QLog.w("springHb_SpringHbEntryPendantHolder", 2, "loadLogoDrawable..file not exist");
      }
      catch (Throwable localThrowable)
      {
        QLog.e("springHb_SpringHbEntryPendantHolder", 2, localThrowable, new Object[0]);
        return;
      }
    }
  }
  
  private void l()
  {
    label168:
    for (;;)
    {
      try
      {
        if (!this.c)
        {
          Object localObject = new Bundle();
          ((Bundle)localObject).putBoolean("key_play_apng", true);
          String str = this.jdField_a_of_type_JavaLangString + "gu_qiaoji.png";
          if (!new File(str).exists()) {
            break label168;
          }
          localObject = QWalletPicHelper.getDrawableForWallet(str, aywm.jdField_a_of_type_AndroidGraphicsDrawableDrawable, (Bundle)localObject);
          if (localObject != null)
          {
            this.jdField_a_of_type_Auqh.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject);
            this.jdField_a_of_type_Ahhg = new ahhg(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Auqh.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            this.c = true;
          }
        }
        else
        {
          QLog.w("springHb_SpringHbEntryPendantHolder", 2, "loadHitDrumDrawable..isSuccess" + this.c);
          return;
        }
        QLog.i("springHb_SpringHbEntryPendantHolder", 2, "loadHitDrumDrawable..failed");
        continue;
        QLog.w("springHb_SpringHbEntryPendantHolder", 2, "loadHitDrumDrawable..file not exist");
      }
      catch (Throwable localThrowable)
      {
        QLog.e("springHb_SpringHbEntryPendantHolder", 2, localThrowable, new Object[0]);
        return;
      }
    }
  }
  
  private void m()
  {
    try
    {
      if (jdField_b_of_type_Boolean)
      {
        if (!ahgj.jdField_b_of_type_Boolean) {
          return;
        }
        p();
        if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
        {
          this.k = actj.a(7.5F, this.jdField_a_of_type_AndroidViewView.getResources());
          this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
          this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ahhf(this));
          this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(2000L);
          this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(2);
          this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
        }
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntryPendantHolder", 1, localThrowable, new Object[0]);
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.pause();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
  
  private void o()
  {
    if (!ahgj.jdField_b_of_type_Boolean) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (Build.VERSION.SDK_INT >= 19) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isPaused()))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.resume();
      return;
    }
    m();
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
  }
  
  public RectF a(int paramInt)
  {
    float f1 = -actj.a(20.0F, this.jdField_a_of_type_AndroidViewView.getResources());
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_f_of_type_Int - f1, this.g - f1 - paramInt, this.jdField_f_of_type_Int + this.h + f1, f1 + (this.g + this.i) - paramInt);
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  public void a()
  {
    try
    {
      int j = this.jdField_a_of_type_AndroidViewView.getWidth();
      int i = j;
      if (j == 0) {
        i = axlk.a;
      }
      j = actj.a(160.0F, this.jdField_a_of_type_AndroidViewView.getResources());
      a(i - j - 0, 0, j, actj.a(jdField_a_of_type_Float, this.jdField_a_of_type_AndroidViewView.getResources()), this.jdField_a_of_type_AndroidViewView);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntryPendantHolder", 1, localThrowable, new Object[0]);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Auqh != null) {
      this.jdField_a_of_type_Auqh.g = paramInt;
    }
    if (this.jdField_b_of_type_Auqh != null) {
      this.jdField_b_of_type_Auqh.g = paramInt;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    if (this.jdField_a_of_type_Auqh == null)
    {
      this.jdField_a_of_type_Auqh = new auqh();
      this.jdField_a_of_type_Auqh.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    }
    if (this.jdField_b_of_type_Auqh == null)
    {
      this.jdField_b_of_type_Auqh = new auqh();
      this.jdField_b_of_type_Auqh.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    if ((jdField_b_of_type_Boolean) && (this.d)) {
      this.jdField_b_of_type_Auqh.a(paramCanvas);
    }
  }
  
  public boolean a(int paramInt)
  {
    l();
    if (this.c)
    {
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
      b(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      b(this.jdField_a_of_type_Auqh.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      b(this.jdField_b_of_type_Auqh.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new SpringHbEntryPendantHolder.6(this), paramInt - 100);
    }
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      QLog.e("springHb_SpringHbEntryPendantHolder", 2, "playHitDrum ...startFloat Abnormally");
      m();
    }
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringHbEntryPendantHolder", 2, "playHitDrum...mDefaultDrawableLoaded:" + jdField_b_of_type_Boolean + ",mHitDrumDrawableLoaded:" + this.c + ",mLogoDrawableLoaded:" + this.d + ",playHitDrum:" + this.e);
    }
    return this.c;
  }
  
  public void a_(Drawable paramDrawable) {}
  
  public void b()
  {
    try
    {
      h();
      if ((BaseActivity.sTopActivity == null) || (BaseActivity.sTopActivity.app == null)) {
        return;
      }
      ahgg localahgg = ((ahfx)BaseActivity.sTopActivity.app.getManager(342)).a();
      if (!bbkk.a(localahgg.jdField_b_of_type_JavaLangString))
      {
        c(localahgg);
        return;
      }
      if (!bbkk.a(localahgg.jdField_a_of_type_JavaLangString))
      {
        b(localahgg);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntryPendantHolder", 1, localThrowable, new Object[0]);
      return;
    }
    a(localThrowable);
  }
  
  protected void b(Canvas paramCanvas)
  {
    if ((this.jdField_f_of_type_Boolean) && (this.c)) {
      this.jdField_a_of_type_Auqh.a(paramCanvas);
    }
  }
  
  public void b(Drawable paramDrawable)
  {
    try
    {
      if (a(paramDrawable)) {
        ((ApngDrawable)((URLDrawable)paramDrawable).getCurrDrawable()).pause();
      }
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringHbEntryPendantHolder", 2, "doPauseAnim..." + paramDrawable);
      }
      return;
    }
    catch (Throwable paramDrawable)
    {
      QLog.e("springHb_SpringHbEntryPendantHolder", 1, paramDrawable, new Object[0]);
    }
  }
  
  public void c()
  {
    try
    {
      h();
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringHbEntryPendantHolder", 2, "stopAnimation...");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntryPendantHolder", 1, localThrowable, new Object[0]);
    }
  }
  
  public void d()
  {
    try
    {
      n();
      ApngImage.pauseByTag(26);
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringHbEntryPendantHolder", 2, "pauseAnimation...");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntryPendantHolder", 1, localThrowable, new Object[0]);
    }
  }
  
  public void e()
  {
    try
    {
      o();
      ThreadManagerV2.getUIHandlerV2().post(new SpringHbEntryPendantHolder.7(this));
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringHbEntryPendantHolder", 2, "resumeAnimation...");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntryPendantHolder", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahhb
 * JD-Core Version:    0.7.0.1
 */