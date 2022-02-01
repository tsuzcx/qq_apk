import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.RenderMode;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class afej
  extends afdk
{
  private afeo jdField_a_of_type_Afeo;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Queue<afen> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  
  public afej(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
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
    Object localObject2;
    Object localObject1;
    int i;
    if ((this.jdField_a_of_type_JavaUtilQueue != null) && (this.jdField_a_of_type_JavaUtilQueue.size() > 0))
    {
      localObject2 = (afen)this.jdField_a_of_type_JavaUtilQueue.peek();
      if (localObject2 != null)
      {
        localObject1 = ((afen)localObject2).jdField_a_of_type_JavaLangString;
        i = ((afen)localObject2).jdField_a_of_type_Int;
        label107:
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "playNextAnim strAnimPath" + (String)localObject1 + "id" + i);
        }
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
      localObject2 = new File(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext().getFilesDir().getAbsoluteFile() + File.separator + "animConfig/" + (String)localObject1 + "/images");
      if (localFile.exists()) {}
      for (;;)
      {
        try
        {
          localObject1 = new FileInputStream(localFile);
          if (localObject1 == null) {
            break;
          }
          if (((File)localObject2).exists()) {
            break label416;
          }
          if (QLog.isColorLevel()) {
            QLog.d("LottieAnimation", 2, "playNextAnim fis == null || !imageDir.exists()");
          }
          if (localObject1 == null) {
            break;
          }
          try
          {
            ((FileInputStream)localObject1).close();
            return false;
          }
          catch (IOException localIOException1)
          {
            localIOException1.printStackTrace();
            return false;
          }
          if (0 == 0) {
            break;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("LottieAnimation", 2, "playNextAnim tempFis Exception");
          }
        }
        try
        {
          throw new NullPointerException();
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
          return false;
        }
        label416:
        localObject2 = ((File)localObject2).getAbsolutePath();
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "playNextAnim absolutePath" + (String)localObject2);
        }
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageAssetDelegate(new afel(this, (String)localObject2));
        LottieComposition.Factory.fromInputStream(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getContext(), localIOException2, new afem(this, localIOException2));
        if (this.jdField_a_of_type_Afeo == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("LottieAnimation", 2, "playNextAnim extraInfo null");
          return false;
        }
        switch (this.jdField_a_of_type_Afeo.jdField_a_of_type_Int)
        {
        }
        for (;;)
        {
          return true;
          if (this.jdField_a_of_type_Afeo.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
            break;
          }
          str = this.jdField_a_of_type_Afeo.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
          long l = this.jdField_a_of_type_Afeo.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt;
          bcef.b(null, "dc00898", "", this.jdField_a_of_type_Afeo.jdField_a_of_type_JavaLangString, "0X800AE17", "0X800AE17", i, 0, str, String.valueOf(l), "", "");
        }
        str = null;
      }
      String str = "";
      i = 0;
      break label107;
      str = "";
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
    Object localObject = (InputLinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368751);
    if (localObject != null) {}
    for (paramInt4 = ((InputLinearLayout)localObject).getHeight();; paramInt4 = 0)
    {
      localObject = (PanelIconLinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372228);
      if (localObject != null) {
        i = ((PanelIconLinearLayout)localObject).getHeight();
      }
      paramInt4 = UIUtils.getScreenHeight(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext()) - paramInt4 - i;
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
        this.jdField_a_of_type_JavaUtilQueue.add(new afen(this, str, i, null));
      }
      paramVarArgs = paramVarArgs[2];
      if ((paramVarArgs != null) && ((paramVarArgs instanceof afeo))) {
        this.jdField_a_of_type_Afeo = ((afeo)paramVarArgs);
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
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 2131558584, null));
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "startAnim mLottieLayout null");
        }
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131362328));
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "startAnim mLottieView null");
        }
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new afek(this));
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
 * Qualified Name:     afej
 * JD-Core Version:    0.7.0.1
 */