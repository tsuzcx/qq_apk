import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.qphone.base.util.QLog;

public abstract class aewn
  implements aews
{
  private aewp jdField_a_of_type_Aewp = new aewo(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private FriendShipLayout jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout;
  
  public aewn(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseDirector", 2, "BaseDirector init");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  @Nullable
  public static aews a(@IntRange(from=0L, to=3L) int paramInt, Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseDirector", 2, "makeDirector type = " + paramInt);
    }
    switch (paramInt)
    {
    case 0: 
    default: 
      return null;
    case 1: 
      return new aewc(paramActivity);
    case 2: 
      return new aewe(paramActivity);
    }
    return new aewi(paramActivity);
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public FriendShipLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseDirector", 2, "BaseDirector play");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout = new FriendShipLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout.setBackListener(this.jdField_a_of_type_Aewp);
      if (Build.VERSION.SDK_INT < 19) {
        break label101;
      }
    }
    label101:
    for (int i = 67109888;; i = 1024)
    {
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -1, 2, i, -2);
      new FrameLayout.LayoutParams(-1, -1).gravity = 51;
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout, localLayoutParams);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout.setVisibility(paramInt);
    }
  }
  
  public void a(aewt paramaewt) {}
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseDirector", 2, "BaseDirector cancel");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout.removeAllViews();
    }
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout = null;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        QLog.e("BaseDirector", 1, "cancel anim error");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aewn
 * JD-Core Version:    0.7.0.1
 */