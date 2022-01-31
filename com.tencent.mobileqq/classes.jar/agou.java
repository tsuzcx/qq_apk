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

class agou
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  agou(agos paramagos, View paramView1, View paramView2) {}
  
  public void onGlobalLayout()
  {
    int j;
    Object localObject1;
    int i;
    Object localObject2;
    aoiq localaoiq;
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getParent() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_Agos.jdField_a_of_type_JavaLangString, 2, "show holmes guide!");
      }
      j = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_Agos.jdField_a_of_type_AndroidContentContext);
      if (this.jdField_a_of_type_Agos.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1034) {
        break label488;
      }
      localObject1 = (CircleGuideView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364276);
      float f1 = this.b.getX();
      float f2 = this.b.getWidth() / 2;
      float f3 = j;
      float f4 = this.b.getY();
      float f5 = this.b.getHeight() / 2;
      i = 24;
      if (Build.VERSION.SDK_INT <= 18) {
        i = 20;
      }
      ((CircleGuideView)localObject1).setCircle(f2 + f1, f5 + (f3 + f4), aepi.a(i, agos.a(this.jdField_a_of_type_Agos).getResources()));
      localObject1 = this.jdField_a_of_type_Agos.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691088);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131367689).setPadding(0, j, 0, 0);
      localObject2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367692);
      localaoiq = ((aoiu)this.jdField_a_of_type_Agos.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b();
      if (localaoiq != null) {
        break label585;
      }
      j = 5;
      switch (j)
      {
      default: 
        label247:
        i = 2130844584;
      }
    }
    for (;;)
    {
      ((ImageView)localObject2).setImageResource(i);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367691)).setContentDescription(String.format((String)localObject1, new Object[] { Integer.valueOf(j) }));
      this.jdField_a_of_type_Agos.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_Agos.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Agos.jdField_a_of_type_AndroidWidgetPopupWindow.setWindowLayoutMode(-1, -1);
      this.jdField_a_of_type_Agos.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
      this.jdField_a_of_type_Agos.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
      this.jdField_a_of_type_Agos.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Agos.jdField_a_of_type_AndroidWidgetPopupWindow.setClippingEnabled(false);
      this.jdField_a_of_type_Agos.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(new View(this.jdField_a_of_type_Agos.jdField_a_of_type_AndroidContentContext), 0, 0, 0);
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_a_of_type_Agos.d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      return;
      label488:
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131372335);
      localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = (this.b.getLeft() + agos.a(this.jdField_a_of_type_Agos).getLeft());
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = (this.b.getTop() + j + agos.a(this.jdField_a_of_type_Agos).getTop());
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = this.jdField_a_of_type_Agos.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691087);
      break;
      label585:
      j = localaoiq.k;
      break label247;
      i = 2130844578;
      continue;
      i = 2130844579;
      continue;
      i = 2130844581;
      continue;
      i = 2130844582;
      continue;
      i = 2130844583;
      continue;
      i = 2130844584;
      continue;
      i = 2130844585;
      continue;
      i = 2130844586;
      continue;
      i = 2130844587;
      continue;
      i = 2130844588;
      continue;
      i = 2130844580;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agou
 * JD-Core Version:    0.7.0.1
 */