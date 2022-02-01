import android.animation.Animator;
import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.Cancellable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class agec
{
  public static final String a;
  public static final String b;
  private static Map<Integer, String> jdField_b_of_type_JavaUtilMap;
  private Cancellable jdField_a_of_type_ComTencentMobileqqDiniflyCancellable;
  private Map<String, LottieDrawable> jdField_a_of_type_JavaUtilMap = new HashMap(20);
  private Set<ageg> jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean;
  private Set<Integer> jdField_b_of_type_JavaUtilSet;
  
  static
  {
    jdField_a_of_type_JavaLangString = bhgg.a(anhk.aZ + "/Tencent/MobileQQ/pttPanelAnimations/");
    jdField_b_of_type_JavaLangString = bhgg.a(anhk.aZ + "/Tencent/MobileQQ/pttPanelAnimations/qq_android_ptt_transition_anim_res/");
  }
  
  private agec()
  {
    jdField_b_of_type_JavaUtilMap = new HashMap(20);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new CopyOnWriteArraySet();
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(1), "ptt_voicechange_to_press_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(2), "ptt_press_to_voicechange_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(3), "ptt_press_to_record_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(4), "ptt_record_to_press_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(5), "ptt_record_to_stop_record_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(201), "ptt_recordstop_to_play_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(202), "ptt_play_to_stop_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(203), "ptt_stop_to_play_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(6), "ptt_record_to_voicechange_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(7), "ptt_voicechange_to_record_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(101), "ptt_voicechange_to_press_anim_night/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(102), "ptt_press_to_voicechange_anim_night/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(103), "ptt_press_to_record_anim_night/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(104), "ptt_record_to_press_anim_night/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(105), "ptt_record_to_stop_record_anim_night/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(301), "ptt_recordstop_to_play_anim_night/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(302), "ptt_play_to_stop_anim_night/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(303), "ptt_stop_to_play_anim_night/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(106), "ptt_record_to_voicechange_anim_night/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(107), "ptt_voicechange_to_record_anim_night/");
  }
  
  public static agec a()
  {
    return agef.a();
  }
  
  private void a(Animator paramAnimator, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      ageg localageg = (ageg)localIterator.next();
      if (localageg != null) {
        localageg.a(paramAnimator, paramInt);
      }
    }
  }
  
  private void a(LottieDrawable paramLottieDrawable, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      ageg localageg = (ageg)localIterator.next();
      if (localageg != null) {
        localageg.a(paramLottieDrawable, paramInt);
      }
    }
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      LottieDrawable localLottieDrawable = (LottieDrawable)this.jdField_a_of_type_JavaUtilMap.get(str);
      localLottieDrawable.cancelAnimation();
      localLottieDrawable.removeAllAnimatorListeners();
      localLottieDrawable.recycleBitmaps();
      localLottieDrawable.clearCompositionAndCache(str + "data.json");
      localLottieDrawable.setImageAssetDelegate(null);
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public LottieDrawable a(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel getDrawable type" + paramInt);
    }
    if ((jdField_b_of_type_JavaUtilMap == null) || (!jdField_b_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))))
    {
      QLog.e("AudioTransitionAnimManager", 1, "getDrawable mResPathMap error.");
      return null;
    }
    String str = (String)jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if ((this.jdField_a_of_type_JavaUtilMap.containsKey(str)) && (this.jdField_a_of_type_JavaUtilMap.get(str) != null)) {
      return (LottieDrawable)this.jdField_a_of_type_JavaUtilMap.get(str);
    }
    if (this.jdField_b_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel getDrawable loading type" + paramInt);
      }
      return null;
    }
    this.jdField_b_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
    ThreadManager.post(new AudioTransitionAnimManager.1(this, str, paramContext, paramInt), 5, null, true);
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyCancellable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyCancellable.cancel();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyCancellable = null;
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      b();
    }
  }
  
  public void a(ageg paramageg)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramageg);
  }
  
  public void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel preLoadRes");
    }
    if (paramContext != null)
    {
      a(paramContext, 1);
      a(paramContext, 2);
      a(paramContext, 3);
      a(paramContext, 5);
      a(paramContext, 202);
      a(paramContext, 203);
      a(paramContext, 201);
    }
  }
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel cancelAnimation drawable=" + paramLottieDrawable);
    }
    paramLottieDrawable.cancelAnimation();
  }
  
  public void a(LottieDrawable paramLottieDrawable, float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    while ((paramFloat > 1.0F) || (paramFloat < 0.0F)) {
      return;
    }
    float f = paramFloat;
    if (ageh.a(paramInt)) {
      f = 1.0F - paramFloat;
    }
    paramLottieDrawable.setProgress(f);
  }
  
  public void a(LottieDrawable paramLottieDrawable, int paramInt, ImageView paramImageView, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel playTransitionAnim   type" + paramInt + " drawable=" + paramLottieDrawable + " needDoPlay= " + paramBoolean);
    }
    if ((paramLottieDrawable == null) || (paramImageView == null)) {}
    do
    {
      return;
      paramImageView.setImageDrawable(paramLottieDrawable);
      paramLottieDrawable.removeAllAnimatorListeners();
      paramLottieDrawable.addAnimatorListener(new agee(this, paramLottieDrawable, paramInt, paramImageView));
    } while (!paramBoolean);
    paramLottieDrawable.playAnimation();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(LottieDrawable paramLottieDrawable)
  {
    return paramLottieDrawable.isAnimating();
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "isFileExsit fileExsit = " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    File localFile = new File(jdField_b_of_type_JavaLangString);
    if ((localFile.exists()) && (jdField_b_of_type_JavaUtilMap != null) && (localFile.listFiles().length == jdField_b_of_type_JavaUtilMap.size()))
    {
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agec
 * JD-Core Version:    0.7.0.1
 */