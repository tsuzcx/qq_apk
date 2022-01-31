import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;

public class abud
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public abud(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new Rect();
    this.a.jdField_a_of_type_Bbcj.d.getWindowVisibleDisplayFrame((Rect)localObject);
    int i = this.a.jdField_a_of_type_Bbcj.d.getRootView().getHeight();
    int j = i - ((Rect)localObject).bottom;
    if ((this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.a.e != j))
    {
      localObject = (RelativeLayout.LayoutParams)this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, j);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.a.e = j;
    }
    if (j > i / 3)
    {
      if (this.a.c) {
        this.a.c(false);
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_Int == 2) {
          this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        }
        i = (int)mjg.b(BaseApplicationImpl.getApplication(), this.a.b + j);
        return;
        this.a.c(true);
      }
    }
    this.a.c(false);
    if (this.a.jdField_a_of_type_Int == 2) {
      this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    if (this.a.jdField_a_of_type_Int == 2) {
      i = (int)mjg.b(BaseApplicationImpl.getApplication(), this.a.b);
    }
    for (;;)
    {
      this.a.d = false;
      return;
      if (this.a.jdField_a_of_type_Int != 1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abud
 * JD-Core Version:    0.7.0.1
 */