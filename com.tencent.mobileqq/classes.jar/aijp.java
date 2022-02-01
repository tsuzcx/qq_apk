import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BabyQAIOPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aijp
  extends antp
{
  aijp(aijm paramaijm) {}
  
  protected void a()
  {
    if (this.a.p != null)
    {
      Animation localAnimation = this.a.p.getAnimation();
      if (localAnimation != null) {
        localAnimation.cancel();
      }
      aijm.b(this.a).removeView(this.a.p);
      this.a.p = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "onStopGuide");
      }
    }
  }
  
  protected void a(Object paramObject)
  {
    paramObject = (Integer)paramObject;
    int i;
    switch (paramObject.intValue())
    {
    default: 
      i = -1;
      if (i < 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.BabyQ", 2, "onStartGuide " + paramObject + " but panel is opened");
        }
        ((antk)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a();
      }
      break;
    }
    do
    {
      do
      {
        return;
        localObject = (PhotoListPanel)aijm.a(this.a).b(4);
        if ((localObject != null) && (((PhotoListPanel)localObject).getVisibility() == 0))
        {
          i = -1;
          break;
        }
        i = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a().indexOf(aiaf.l);
        break;
        i = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a().indexOf(aiaf.v);
        break;
        if (ShortVideoUtils.f())
        {
          i = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a().indexOf(aiaf.s);
          break;
        }
        i = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a().indexOf(aiaf.v);
        break;
        if ((aijm.a(this.a) != null) && (aijm.b(this.a).getVisibility() == 0))
        {
          i = -1;
          break;
        }
        i = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a().indexOf(aiaf.a);
        break;
      } while (this.a.p != null);
      this.a.p = new View(this.a.jdField_a_of_type_AndroidContentContext);
      this.a.p.setBackgroundResource(2130844932);
      Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getChildAt(i);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(((View)localObject).getHeight(), ((View)localObject).getHeight());
      localLayoutParams.addRule(12);
      localLayoutParams.setMargins(((View)localObject).getLeft() + ((View)localObject).getWidth() / 2 - ((View)localObject).getHeight() / 2, 0, 0, (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight() - ((View)localObject).getHeight()) / 2);
      aijm.a(this.a).addView(this.a.p, localLayoutParams);
      localObject = AnimationUtils.loadAnimation(this.a.jdField_a_of_type_AndroidContentContext, 2130772234);
      ((Animation)localObject).setAnimationListener(new aijq(this));
      this.a.p.startAnimation((Animation)localObject);
    } while (!QLog.isColorLevel());
    QLog.d("Q.BabyQ", 2, "onStartGuide " + paramObject);
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijp
 * JD-Core Version:    0.7.0.1
 */