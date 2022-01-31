import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import com.tencent.mobileqq.activity.selectable.TranslateSelectableMenu.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import java.lang.ref.WeakReference;

public class ajtw
  extends ajth<TextPreviewTranslateActivity>
{
  protected void a(ContainerView paramContainerView)
  {
    super.a(paramContainerView);
    TextPreviewTranslateActivity localTextPreviewTranslateActivity = (TextPreviewTranslateActivity)this.b.get();
    if (localTextPreviewTranslateActivity != null) {
      paramContainerView.setOutScrollView((ScrollView)localTextPreviewTranslateActivity.findViewById(2131376147));
    }
    paramContainerView.jdField_a_of_type_Boolean = false;
    paramContainerView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.post(new TranslateSelectableMenu.1(this, paramContainerView));
  }
  
  protected void a(ContainerView paramContainerView, View paramView)
  {
    super.a(paramContainerView, paramView);
    azmj.b((QQAppInterface)this.a.get(), "dc00898", "", "", "0X800A435", "0X800A435", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      if ((paramView.getId() != 2131376287) && (ajsx.a().c())) {
        ajsx.a().d();
      }
      do
      {
        for (;;)
        {
          return;
          try
          {
            baja.a(a(), "TextPreview");
            azmj.b((QQAppInterface)this.a.get(), "dc00898", "", "", "0X800A437", "0X800A437", 0, 0, "", "", "", "");
          }
          catch (Exception paramView) {}
        }
      } while (!QLog.isColorLevel());
      QLog.e("TranslateSelectableMenu", 2, paramView.toString());
      return;
      baja.a((Activity)paramView.getContext(), a());
      azmj.b((QQAppInterface)this.a.get(), "dc00898", "", "", "0X800A438", "0X800A438", 0, 0, "", "", "", "");
      continue;
      if (localQQAppInterface != null) {
        baja.a((Activity)paramView.getContext(), localQQAppInterface, a());
      }
      azmj.b((QQAppInterface)this.a.get(), "dc00898", "", "", "0X800A439", "0X800A439", 0, 0, "", "", "", "");
      continue;
      ajsx.a().a(null);
      azmj.b((QQAppInterface)this.a.get(), "dc00898", "", "", "0X800A436", "0X800A436", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtw
 * JD-Core Version:    0.7.0.1
 */