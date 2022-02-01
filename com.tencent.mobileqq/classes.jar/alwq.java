import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import com.tencent.mobileqq.activity.selectable.TranslateSelectableMenu.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ScrollView;
import java.lang.ref.WeakReference;

public class alwq
  extends alwb<TextPreviewTranslateActivity>
{
  protected void a(ContainerView paramContainerView)
  {
    super.a(paramContainerView);
    TextPreviewTranslateActivity localTextPreviewTranslateActivity = (TextPreviewTranslateActivity)this.b.get();
    if (localTextPreviewTranslateActivity != null) {
      paramContainerView.setOutScrollView((ScrollView)localTextPreviewTranslateActivity.findViewById(2131377135));
    }
    paramContainerView.jdField_a_of_type_Boolean = false;
    paramContainerView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.post(new TranslateSelectableMenu.1(this, paramContainerView));
  }
  
  protected void a(ContainerView paramContainerView, View paramView)
  {
    super.a(paramContainerView, paramView);
    bdla.b((QQAppInterface)this.a.get(), "dc00898", "", "", "0X800A435", "0X800A435", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      if ((paramView.getId() != 2131377287) && (alvr.a().c())) {
        alvr.a().d();
      }
      for (;;)
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          try
          {
            behe.a(a(), "TextPreview");
            bdla.b((QQAppInterface)this.a.get(), "dc00898", "", "", "0X800A437", "0X800A437", 0, 0, "", "", "", "");
          }
          catch (Exception localException) {}
        }
        if (QLog.isColorLevel()) {
          QLog.e("TranslateSelectableMenu", 2, localException.toString());
        }
      }
      behe.a((Activity)paramView.getContext(), a());
      bdla.b((QQAppInterface)this.a.get(), "dc00898", "", "", "0X800A438", "0X800A438", 0, 0, "", "", "", "");
      continue;
      if (localException != null) {
        behe.a((Activity)paramView.getContext(), localException, a());
      }
      bdla.b((QQAppInterface)this.a.get(), "dc00898", "", "", "0X800A439", "0X800A439", 0, 0, "", "", "", "");
      continue;
      alvr.a().a(null);
      bdla.b((QQAppInterface)this.a.get(), "dc00898", "", "", "0X800A436", "0X800A436", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alwq
 * JD-Core Version:    0.7.0.1
 */