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

class agpw
  extends alop
{
  agpw(agps paramagps) {}
  
  protected void a()
  {
    if (this.a.q != null)
    {
      Animation localAnimation = this.a.q.getAnimation();
      if (localAnimation != null) {
        localAnimation.cancel();
      }
      agps.b(this.a).removeView(this.a.q);
      this.a.q = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "onStopGuide");
      }
    }
  }
  
  protected void a(Object paramObject)
  {
    int i = -1;
    paramObject = (Integer)paramObject;
    switch (paramObject.intValue())
    {
    default: 
      if (i < 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.BabyQ", 2, "onStartGuide " + paramObject + " but panel is opened");
        }
        ((alok)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a();
      }
      break;
    }
    do
    {
      do
      {
        return;
        if ((agps.a(this.a) != null) && (agps.b(this.a).getVisibility() == 0)) {
          break;
        }
        i = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a().indexOf(aggx.l);
        break;
        i = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a().indexOf(aggx.v);
        break;
        if (ShortVideoUtils.f())
        {
          i = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a().indexOf(aggx.s);
          break;
        }
        i = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a().indexOf(aggx.v);
        break;
        if ((agps.a(this.a) != null) && (agps.b(this.a).getVisibility() == 0)) {
          break;
        }
        i = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a().indexOf(aggx.a);
        break;
      } while (this.a.q != null);
      this.a.q = new View(this.a.jdField_a_of_type_AndroidContentContext);
      this.a.q.setBackgroundResource(2130844524);
      Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getChildAt(i);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(((View)localObject).getHeight(), ((View)localObject).getHeight());
      localLayoutParams.addRule(12);
      localLayoutParams.setMargins(((View)localObject).getLeft() + ((View)localObject).getWidth() / 2 - ((View)localObject).getHeight() / 2, 0, 0, (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight() - ((View)localObject).getHeight()) / 2);
      agps.a(this.a).addView(this.a.q, localLayoutParams);
      localObject = AnimationUtils.loadAnimation(this.a.jdField_a_of_type_AndroidContentContext, 2130772225);
      ((Animation)localObject).setAnimationListener(new agpx(this));
      this.a.q.startAnimation((Animation)localObject);
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
 * Qualified Name:     agpw
 * JD-Core Version:    0.7.0.1
 */