import android.app.Activity;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;

public class akpy
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public akpy(QzoneHbFragment paramQzoneHbFragment, Activity paramActivity) {}
  
  public void onGlobalLayout()
  {
    Button localButton;
    int j;
    int i;
    if (this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getWidth() <= 480)
    {
      localButton = QzoneHbFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment);
      Object localObject = new Rect();
      this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      int k = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getRootView().getHeight();
      j = k - ((Rect)localObject).bottom;
      i = j;
      if (j - this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment.a(this.jdField_a_of_type_AndroidAppActivity) == 0) {
        i = 0;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment.mActivity.getWindow().getDecorView().getScrollY();
      if ((localButton == null) || (i == 0)) {
        break label204;
      }
      localObject = new int[2];
      localButton.getLocationOnScreen((int[])localObject);
      m = localObject[1];
      i = localButton.getMeasuredHeight() + m + i - k - j;
      if (i > 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment.mActivity.getWindow().getDecorView().scrollBy(0, i + 5);
      }
      QzoneHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment, true);
    }
    label204:
    while (i != 0)
    {
      int m;
      return;
      localButton = QzoneHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment);
      break;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment.mActivity.getWindow().getDecorView().scrollBy(0, -j);
    QzoneHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akpy
 * JD-Core Version:    0.7.0.1
 */