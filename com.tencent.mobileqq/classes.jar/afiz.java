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

class afiz
  extends amof
{
  afiz(afiw paramafiw) {}
  
  protected void a()
  {
    if (this.a.jdField_a_of_type_AndroidViewView != null)
    {
      Animation localAnimation = this.a.jdField_a_of_type_AndroidViewView.getAnimation();
      if (localAnimation != null) {
        localAnimation.cancel();
      }
      this.a.mContent.removeView(this.a.jdField_a_of_type_AndroidViewView);
      this.a.jdField_a_of_type_AndroidViewView = null;
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
        ((amoa)this.a.app.getBusinessHandler(53)).a();
      }
      break;
    }
    do
    {
      do
      {
        return;
        localObject = (PhotoListPanel)this.a.panelManager.a(4);
        if ((localObject != null) && (((PhotoListPanel)localObject).getVisibility() == 0))
        {
          i = -1;
          break;
        }
        i = this.a.panelicons.a().indexOf(agwt.l);
        break;
        i = this.a.panelicons.a().indexOf(agwt.v);
        break;
        if (ShortVideoUtils.needTwoEntrance())
        {
          i = this.a.panelicons.a().indexOf(agwt.s);
          break;
        }
        i = this.a.panelicons.a().indexOf(agwt.v);
        break;
        if ((this.a.mAudioPanel != null) && (this.a.mAudioPanel.getVisibility() == 0))
        {
          i = -1;
          break;
        }
        i = this.a.panelicons.a().indexOf(agwt.a);
        break;
      } while (this.a.jdField_a_of_type_AndroidViewView != null);
      this.a.jdField_a_of_type_AndroidViewView = new View(this.a.mContext);
      this.a.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130844812);
      Object localObject = this.a.panelicons.getChildAt(i);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(((View)localObject).getHeight(), ((View)localObject).getHeight());
      localLayoutParams.addRule(12);
      localLayoutParams.setMargins(((View)localObject).getLeft() + ((View)localObject).getWidth() / 2 - ((View)localObject).getHeight() / 2, 0, 0, (this.a.panelicons.getHeight() - ((View)localObject).getHeight()) / 2);
      this.a.mContent.addView(this.a.jdField_a_of_type_AndroidViewView, localLayoutParams);
      localObject = AnimationUtils.loadAnimation(this.a.mContext, 2130772232);
      ((Animation)localObject).setAnimationListener(new afja(this));
      this.a.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
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
 * Qualified Name:     afiz
 * JD-Core Version:    0.7.0.1
 */