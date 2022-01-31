import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.CircleGuideView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

class aeno
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aeno(aenm paramaenm, View paramView1, View paramView2) {}
  
  public void onGlobalLayout()
  {
    int j;
    Object localObject1;
    int i;
    Object localObject2;
    amnj localamnj;
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getParent() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_Aenm.jdField_a_of_type_JavaLangString, 2, "show holmes guide!");
      }
      j = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_Aenm.jdField_a_of_type_AndroidContentContext);
      if (this.jdField_a_of_type_Aenm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1034) {
        break label488;
      }
      localObject1 = (CircleGuideView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364211);
      float f1 = this.b.getX();
      float f2 = this.b.getWidth() / 2;
      float f3 = j;
      float f4 = this.b.getY();
      float f5 = this.b.getHeight() / 2;
      i = 24;
      if (Build.VERSION.SDK_INT <= 18) {
        i = 20;
      }
      ((CircleGuideView)localObject1).setCircle(f2 + f1, f5 + (f3 + f4), actj.a(i, aenm.a(this.jdField_a_of_type_Aenm).getResources()));
      localObject1 = this.jdField_a_of_type_Aenm.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691034);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131367551).setPadding(0, j, 0, 0);
      localObject2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367554);
      localamnj = ((amnn)this.jdField_a_of_type_Aenm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b();
      if (localamnj != null) {
        break label585;
      }
      j = 5;
      switch (j)
      {
      default: 
        label247:
        i = 2130844169;
      }
    }
    for (;;)
    {
      ((ImageView)localObject2).setImageResource(i);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367553)).setContentDescription(String.format((String)localObject1, new Object[] { Integer.valueOf(j) }));
      this.jdField_a_of_type_Aenm.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_Aenm.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Aenm.jdField_a_of_type_AndroidWidgetPopupWindow.setWindowLayoutMode(-1, -1);
      this.jdField_a_of_type_Aenm.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
      this.jdField_a_of_type_Aenm.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
      this.jdField_a_of_type_Aenm.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Aenm.jdField_a_of_type_AndroidWidgetPopupWindow.setClippingEnabled(false);
      this.jdField_a_of_type_Aenm.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(new View(this.jdField_a_of_type_Aenm.jdField_a_of_type_AndroidContentContext), 0, 0, 0);
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_a_of_type_Aenm.d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      return;
      label488:
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131371998);
      localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = (this.b.getLeft() + aenm.a(this.jdField_a_of_type_Aenm).getLeft());
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = (this.b.getTop() + j + aenm.a(this.jdField_a_of_type_Aenm).getTop());
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = this.jdField_a_of_type_Aenm.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691033);
      break;
      label585:
      j = localamnj.k;
      break label247;
      i = 2130844163;
      continue;
      i = 2130844164;
      continue;
      i = 2130844166;
      continue;
      i = 2130844167;
      continue;
      i = 2130844168;
      continue;
      i = 2130844169;
      continue;
      i = 2130844170;
      continue;
      i = 2130844171;
      continue;
      i = 2130844172;
      continue;
      i = 2130844173;
      continue;
      i = 2130844165;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeno
 * JD-Core Version:    0.7.0.1
 */