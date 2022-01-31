import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector.5;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;
import mqq.os.MqqHandler;

public class aewi
  extends aewn
  implements Animator.AnimatorListener
{
  private aexh jdField_a_of_type_Aexh;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  
  public aewi(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Aexh = new aexh(paramContext);
    this.jdField_a_of_type_Aexh.a(new aewj(this));
  }
  
  private QQAppInterface a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (a() != null)
    {
      localObject1 = localObject2;
      if ((a() instanceof BaseActivity)) {
        localObject1 = ((BaseActivity)a()).app;
      }
    }
    return localObject1;
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = ausr.a(paramQQAppInterface).a(this.jdField_b_of_type_JavaLangString, this.c);
    if (QLog.isColorLevel()) {
      QLog.i("LottieAnimDirector", 1, "onResourceReady lottieUrl:" + this.jdField_b_of_type_JavaLangString + "  lottieMd5:" + this.c + " mResPath:" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = new LottieDrawable();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setImageAssetDelegate(new aewl(this));
    }
    try
    {
      paramQQAppInterface = new FileInputStream(this.jdField_a_of_type_JavaLangString + "data.json");
      QLog.i("LottieAnimDirector", 1, "decode anim async");
      LottieComposition.Factory.fromInputStream(a(), paramQQAppInterface, new aewm(this));
      return;
    }
    catch (IOException paramQQAppInterface)
    {
      QLog.e("LottieAnimDirector", 1, "Decode anim json error");
    }
  }
  
  private void a(LottieComposition paramLottieComposition)
  {
    QLog.i("LottieAnimDirector", 1, "decode json success");
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (paramLottieComposition != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setComposition(paramLottieComposition);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.loop(false);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.addAnimatorListener(this);
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimDirector", 2, "refresh Lottie.d");
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      }
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "play");
    }
    ThreadManager.getUIHandler().postDelayed(new LottieAnimDirector.5(this), 300L);
  }
  
  public void a(aewt paramaewt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "prepare");
    }
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      paramaewt.a(false);
      return;
    }
    if (ausr.a(localQQAppInterface).a(this.jdField_b_of_type_JavaLangString, this.c))
    {
      a(localQQAppInterface);
      paramaewt.a(true);
      return;
    }
    ausr.a(localQQAppInterface).a(this.jdField_b_of_type_JavaLangString, this.c, new aewk(this, paramaewt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "setLottieResources url:" + paramString1 + " md5:" + paramString2);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "cancel");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.cancelAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.recycleBitmaps();
    }
    if (this.jdField_a_of_type_Aexh != null)
    {
      this.jdField_a_of_type_Aexh.b();
      this.jdField_a_of_type_Aexh.c();
    }
    a(8);
    super.b();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "doOnPause");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.pauseAnimation();
    }
    if ((this.jdField_a_of_type_Aexh != null) && (this.jdField_a_of_type_Aexh.a())) {
      this.jdField_a_of_type_Aexh.d();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "doOnResume");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.resumeAnimation();
    }
    if ((this.jdField_a_of_type_Aexh != null) && (this.jdField_a_of_type_Aexh.a())) {
      this.jdField_a_of_type_Aexh.e();
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "doOnDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.cancelAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.recycleBitmaps();
    }
    if (this.jdField_a_of_type_Aexh != null)
    {
      this.jdField_a_of_type_Aexh.b();
      this.jdField_a_of_type_Aexh.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    b();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aewi
 * JD-Core Version:    0.7.0.1
 */