import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public final class akko
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public akko(ApolloRender paramApolloRender, View paramView) {}
  
  public void onGlobalLayout()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mShowEditWindow)) {
      QLog.e("rogersxiao", 2, "render.mEditWindow return");
    }
    do
    {
      return;
      localObject = new Rect();
      this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame((Rect)localObject);
      i = (int)bdcb.l();
      j = ((Rect)localObject).bottom;
      int k = ((Rect)localObject).top;
      ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidViewView.getContext());
      if (i - (j - k) >= 200) {
        break;
      }
    } while (!ApolloRender.sIsKeyBoardShow);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.dismiss();
    ApolloRender.sIsKeyBoardDissmiss = true;
    return;
    int i = ((Rect)localObject).bottom - this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.getHeight();
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
    int j = ((SharedPreferences)localObject).getInt("sp_key_apollo_keyboard_height", 0);
    if ((this.jdField_a_of_type_AndroidViewView.getContext() instanceof Activity))
    {
      if (((Activity)this.jdField_a_of_type_AndroidViewView.getContext()).isFinishing())
      {
        QLog.e("sava_ApolloRender", 1, "showKeyBorad activity is isFinishing");
        return;
      }
      if ((Build.VERSION.SDK_INT >= 17) && (((Activity)this.jdField_a_of_type_AndroidViewView.getContext()).isDestroyed()))
      {
        QLog.e("sava_ApolloRender", 1, "showKeyBorad activity is destroy");
        return;
      }
    }
    if (j != i) {}
    try
    {
      ((SharedPreferences)localObject).edit().putInt("sp_key_apollo_keyboard_height", i).commit();
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.showAtLocation(this.jdField_a_of_type_AndroidViewView.getRootView(), 0, 0, i);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.update(0, i, this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.getWidth(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.getHeight());
      ApolloRender.sIsKeyBoardDissmiss = false;
      if (ApolloRender.sIsKeyBoardDissmiss)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.showAtLocation(this.jdField_a_of_type_AndroidViewView.getRootView(), 0, 0, i);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.update(0, i, this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.getWidth(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.getHeight());
        ApolloRender.sIsKeyBoardDissmiss = false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("sava_ApolloRender", 1, localException, new Object[0]);
      }
    }
    ApolloRender.sIsKeyBoardShow = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akko
 * JD-Core Version:    0.7.0.1
 */