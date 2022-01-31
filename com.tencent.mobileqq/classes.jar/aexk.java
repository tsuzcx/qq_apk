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
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.WeakHashMap;

public class aexk
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private Queue<aexo> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private WeakHashMap<String, Bitmap> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  
  public aexk(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {}
    label387:
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()) {
        return true;
      }
      Object localObject1 = "";
      if ((this.jdField_a_of_type_JavaUtilQueue != null) && (this.jdField_a_of_type_JavaUtilQueue.size() > 0)) {
        localObject1 = ((aexo)this.jdField_a_of_type_JavaUtilQueue.peek()).jdField_a_of_type_JavaLangString;
      }
      for (int i = ((aexo)this.jdField_a_of_type_JavaUtilQueue.peek()).jdField_a_of_type_Int;; i = 0)
      {
        if (((String)localObject1).isEmpty()) {
          break label387;
        }
        Object localObject4 = new File(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getFilesDir().getAbsoluteFile() + File.separator + "animConfig/" + (String)localObject1 + "/data.json");
        Object localObject3 = new File(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getFilesDir().getAbsoluteFile() + File.separator + "animConfig/" + (String)localObject1 + "/images");
        if (((File)localObject4).exists()) {}
        for (;;)
        {
          try
          {
            localObject1 = new FileInputStream((File)localObject4);
            if ((localObject1 == null) || (!((File)localObject3).exists())) {
              break;
            }
            localObject3 = ((File)localObject3).getAbsolutePath();
            this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageAssetDelegate(new aexm(this, (String)localObject3));
            LottieComposition.Factory.fromInputStream(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getContext(), (InputStream)localObject1, new aexn(this));
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
            localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
            localObject3 = "";
            if (localObject1 != null)
            {
              localObject1 = ((TroopManager)localObject1).b((String)localObject4);
              if (localObject1 != null) {
                localObject3 = "" + ((TroopInfo)localObject1).dwGroupClassExt;
              }
              azqs.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "0X800AE17", "0X800AE17", i, 0, (String)localObject4, (String)localObject3, "", "");
              return true;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            return false;
          }
          Object localObject2 = null;
          continue;
          localObject2 = null;
        }
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {
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
    if (paramVarArgs == null) {
      return false;
    }
    if (paramVarArgs.length > 1)
    {
      String str = (String)paramVarArgs[0];
      int i = ((Integer)paramVarArgs[1]).intValue();
      if ((!str.isEmpty()) && (i != 0)) {
        this.jdField_a_of_type_JavaUtilQueue.add(new aexo(this, str, i, null));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating())) {
        return true;
      }
    }
    else
    {
      return false;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131558554, null));
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131362238));
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null) {
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new aexl(this));
      paramVarArgs = new RelativeLayout.LayoutParams(-1, -1);
      paramVarArgs.addRule(2, 2131368344);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramVarArgs);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setRenderMode(RenderMode.HARDWARE);
    }
    if (!a())
    {
      this.jdField_a_of_type_JavaUtilQueue.clear();
      a();
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexk
 * JD-Core Version:    0.7.0.1
 */