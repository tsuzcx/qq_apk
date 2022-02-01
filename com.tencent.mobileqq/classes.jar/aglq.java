import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.LottieAnimationInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.RenderMode;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class aglq
  extends agkr
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private LottieAnimationInfo jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimationInfo;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Queue<aglv> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  
  public aglq(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LottieAnimation", 2, "playNextAnim mLottieView == null || mLottieLayout == null");
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating())
    {
      if (QLog.isColorLevel()) {
        QLog.d("LottieAnimation", 2, "playNextAnim mLottieView isAnimating");
      }
      return true;
    }
    Object localObject1 = "";
    int i;
    if ((this.jdField_a_of_type_JavaUtilQueue != null) && (this.jdField_a_of_type_JavaUtilQueue.size() > 0))
    {
      localObject1 = ((aglv)this.jdField_a_of_type_JavaUtilQueue.peek()).jdField_a_of_type_JavaLangString;
      i = ((aglv)this.jdField_a_of_type_JavaUtilQueue.peek()).jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("LottieAnimation", 2, "playNextAnim strAnimPath" + (String)localObject1 + "id" + i);
      }
    }
    for (;;)
    {
      if (((String)localObject1).isEmpty())
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("LottieAnimation", 2, "playNextAnim strAnimPath isEmpty");
        return false;
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("LottieAnimation", 2, "playNextAnim listViewParent is null");
        return false;
      }
      File localFile = new File(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext().getFilesDir().getAbsoluteFile() + File.separator + "animConfig/" + (String)localObject1 + "/data.json");
      Object localObject2 = new File(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext().getFilesDir().getAbsoluteFile() + File.separator + "animConfig/" + (String)localObject1 + "/images");
      if (localFile.exists()) {}
      for (;;)
      {
        try
        {
          localObject1 = new FileInputStream(localFile);
          if ((localObject1 != null) && (((File)localObject2).exists())) {
            break label383;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("LottieAnimation", 2, "playNextAnim fis == null || !imageDir.exists()");
          return false;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("LottieAnimation", 2, "playNextAnim fis Exception");
        return false;
        label383:
        localObject2 = ((File)localObject2).getAbsolutePath();
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "playNextAnim absolutePath" + (String)localObject2);
        }
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageAssetDelegate(new agls(this, (String)localObject2));
        LottieComposition.Factory.fromInputStream(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getContext(), localException, new aglt(this));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimationInfo == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("LottieAnimation", 2, "playNextAnim extraInfo null");
          return false;
        }
        switch (aglu.a[this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimationInfo.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimationInfo$Src.ordinal()])
        {
        }
        for (;;)
        {
          return true;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimationInfo.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
            break;
          }
          str = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimationInfo.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
          long l = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimationInfo.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt;
          bdll.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimationInfo.jdField_a_of_type_JavaLangString, "0X800AE17", "0X800AE17", i, 0, str, String.valueOf(l), "", "");
        }
        String str = null;
      }
      i = 0;
    }
  }
  
  protected boolean a(int paramInt)
  {
    return true;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)) {
      return true;
    }
    Object localObject = (InputLinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368726);
    if (localObject != null) {}
    for (paramInt4 = ((InputLinearLayout)localObject).getHeight();; paramInt4 = 0)
    {
      localObject = (PanelIconLinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372262);
      if (localObject != null) {
        i = ((PanelIconLinearLayout)localObject).getHeight();
      }
      paramInt4 = zps.c(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext()) - paramInt4 - i;
      i = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getLeft();
      int j = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getRight();
      int k = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getTop();
      int m = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getBottom();
      if ((i == paramInt1) && (j == paramInt3) && (k == paramInt2) && (m == paramInt4)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.layout(paramInt1, paramInt2, paramInt3, paramInt4);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
      return true;
    }
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    if (paramVarArgs == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LottieAnimation", 2, "startAnim args is null");
      }
      return false;
    }
    if (paramVarArgs.length > 2)
    {
      String str = (String)paramVarArgs[0];
      int i = ((Integer)paramVarArgs[1]).intValue();
      if ((!TextUtils.isEmpty(str)) && (i != 0)) {
        this.jdField_a_of_type_JavaUtilQueue.add(new aglv(this, str, i, null));
      }
      paramVarArgs = paramVarArgs[2];
      if ((paramVarArgs != null) && ((paramVarArgs instanceof LottieAnimationInfo))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimationInfo = ((LottieAnimationInfo)paramVarArgs);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "startAnim mLottieView isAnimating");
        }
        return true;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("LottieAnimation", 2, "startAnim args error!");
      }
      return false;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentWidgetListView.getParent());
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        return false;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 2131558581, null));
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "startAnim mLottieLayout null");
        }
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131362325));
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "startAnim mLottieView null");
        }
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new aglr(this));
      paramVarArgs = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramVarArgs);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setRenderMode(RenderMode.HARDWARE);
    }
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("LottieAnimation", 2, "playNextAnim false");
      }
      c();
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimation", 2, "startAnim succ");
    }
    return true;
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimation", 2, "stopAnim");
    }
    if ((this.jdField_a_of_type_JavaUtilQueue != null) && (!this.jdField_a_of_type_JavaUtilQueue.isEmpty())) {
      this.jdField_a_of_type_JavaUtilQueue.clear();
    }
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LottieAnimation", 2, "mLottieView == null || mLottieLayout == null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAllAnimatorListener();
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.endAnimation();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = null;
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglq
 * JD-Core Version:    0.7.0.1
 */