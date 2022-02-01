import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.RenderMode;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.WeakHashMap;

public class agdw
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private Queue<agea> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private WeakHashMap<String, Bitmap> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  
  public agdw(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEggLottieAnimView", 2, "playNextAnim mLottieView == null || mLottieLayout == null");
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEggLottieAnimView", 2, "playNextAnim mLottieView isAnimating");
      }
      return true;
    }
    Object localObject1 = "";
    int i;
    if ((this.jdField_a_of_type_JavaUtilQueue != null) && (this.jdField_a_of_type_JavaUtilQueue.size() > 0))
    {
      localObject1 = ((agea)this.jdField_a_of_type_JavaUtilQueue.peek()).jdField_a_of_type_JavaLangString;
      i = ((agea)this.jdField_a_of_type_JavaUtilQueue.peek()).jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("TroopEggLottieAnimView", 2, "playNextAnim strAnimPath" + (String)localObject1 + "id" + i);
      }
    }
    for (;;)
    {
      if (((String)localObject1).isEmpty())
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TroopEggLottieAnimView", 2, "playNextAnim strAnimPath isEmpty");
        return false;
      }
      Object localObject4 = new File(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getFilesDir().getAbsoluteFile() + File.separator + "animConfig/" + (String)localObject1 + "/data.json");
      Object localObject3 = new File(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getFilesDir().getAbsoluteFile() + File.separator + "animConfig/" + (String)localObject1 + "/images");
      if (((File)localObject4).exists()) {}
      for (;;)
      {
        try
        {
          localObject1 = new FileInputStream((File)localObject4);
          if ((localObject1 != null) && (((File)localObject3).exists())) {
            break label348;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TroopEggLottieAnimView", 2, "playNextAnim fis == null || !imageDir.exists()");
          return false;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TroopEggLottieAnimView", 2, "playNextAnim fis Exception");
        return false;
        label348:
        localObject3 = ((File)localObject3).getAbsolutePath();
        if (QLog.isColorLevel()) {
          QLog.d("TroopEggLottieAnimView", 2, "playNextAnim absolutePath" + (String)localObject3);
        }
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageAssetDelegate(new agdy(this, (String)localObject3));
        LottieComposition.Factory.fromInputStream(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getContext(), localException, new agdz(this));
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
        Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        localObject3 = "";
        if (localObject2 != null) {}
        for (localObject2 = ((TroopManager)localObject2).b((String)localObject4);; localObject2 = null)
        {
          if (localObject2 != null) {
            localObject3 = "" + ((TroopInfo)localObject2).dwGroupClassExt;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopEggLottieAnimView", 2, "playNextAnim report 0X800AE17");
          }
          bcst.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "0X800AE17", "0X800AE17", i, 0, (String)localObject4, (String)localObject3, "", "");
          return true;
        }
        localObject2 = null;
      }
      i = 0;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEggLottieAnimView", 2, "stopAnim");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEggLottieAnimView", 2, "mLottieView == null || mLottieLayout == null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAllAnimatorListener();
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.endAnimation();
    }
    if ((this.jdField_a_of_type_JavaUtilQueue != null) && (!this.jdField_a_of_type_JavaUtilQueue.isEmpty())) {
      this.jdField_a_of_type_JavaUtilQueue.clear();
    }
    if ((this.jdField_a_of_type_JavaUtilWeakHashMap != null) && (!this.jdField_a_of_type_JavaUtilWeakHashMap.isEmpty())) {
      this.jdField_a_of_type_JavaUtilWeakHashMap.clear();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      RelativeLayout localRelativeLayout = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
      if (localRelativeLayout != null) {
        localRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = null;
  }
  
  public boolean a(Object... paramVarArgs)
  {
    if (paramVarArgs == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEggLottieAnimView", 2, "startAnim args is null");
      }
      return false;
    }
    if (paramVarArgs.length > 1)
    {
      String str = (String)paramVarArgs[0];
      int i = ((Integer)paramVarArgs[1]).intValue();
      if ((!str.isEmpty()) && (i != 0)) {
        this.jdField_a_of_type_JavaUtilQueue.add(new agea(this, str, i, null));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopEggLottieAnimView", 2, "startAnim mLottieView isAnimating");
        }
        return true;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEggLottieAnimView", 2, "startAnim args error!");
      }
      return false;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131558579, null));
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopEggLottieAnimView", 2, "startAnim mLottieLayout null");
        }
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131362313));
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopEggLottieAnimView", 2, "startAnim mLottieView null");
        }
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new agdx(this));
      paramVarArgs = new RelativeLayout.LayoutParams(-1, -1);
      paramVarArgs.addRule(2, 2131368652);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramVarArgs);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setRenderMode(RenderMode.HARDWARE);
    }
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEggLottieAnimView", 2, "playNextAnim false");
      }
      this.jdField_a_of_type_JavaUtilQueue.clear();
      a();
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopEggLottieAnimView", 2, "startAnim succ");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdw
 * JD-Core Version:    0.7.0.1
 */