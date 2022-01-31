import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.qphone.base.util.QLog;

class adju
  extends URLImageView
{
  public adju(adje paramadje, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    paramThrowable = (adjt)aciy.a(this);
    paramThrowable.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.a.a(paramThrowable, paramURLDrawable);
    if (AppSetting.c) {
      paramThrowable.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(ajjy.a(2131640675));
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    adjt localadjt = (adjt)aciy.a(this);
    super.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    super.setImageDrawable(paramURLDrawable);
    if (localadjt == null)
    {
      QLog.e("MarketFaceItemBuilder", 1, "onLoadSuccessed  holder == null url=" + paramURLDrawable.getURL());
      return;
    }
    if (localadjt.jdField_a_of_type_Anla == null)
    {
      paramURLDrawable = localadjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (!(paramURLDrawable instanceof MessageForMarketFace)) {
        break label570;
      }
      paramURLDrawable = ((MessageForMarketFace)paramURLDrawable).mMarkFaceMessage;
      if (paramURLDrawable == null) {
        break label570;
      }
    }
    label548:
    label568:
    label570:
    for (int i = paramURLDrawable.dwTabID;; i = -1)
    {
      QLog.e("MarketFaceItemBuilder", 1, "onLoadSuccessed  emoticonInfo == null epId = " + i);
      return;
      if ((!anjd.a()) || (2 != localadjt.jdField_a_of_type_Anla.a.jobType) || (this.a.jdField_a_of_type_Anfj.e(localadjt.jdField_a_of_type_Anla.a.epId)) || (!arhw.a()) || (anjd.c()))
      {
        float f = this.a.jdField_a_of_type_Anfj.a(localadjt.jdField_a_of_type_Anla.a.epId);
        if ((f < 0.0F) || (1.0F == f))
        {
          localadjt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          localadjt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
          if (QLog.isColorLevel()) {
            QLog.d("MarketFaceItemBuilder", 2, "onLoadSuccessed progressBar gone ");
          }
        }
      }
      this.a.a(localadjt, paramURLDrawable);
      if ((2 == localadjt.jdField_a_of_type_Anla.a.jobType) && (arhw.a()) && (this.a.jdField_a_of_type_Anfj.e(localadjt.jdField_a_of_type_Anla.a.epId)))
      {
        if (argh.a(localadjt.jdField_a_of_type_Anla.a.magicValue) == 1) {
          localadjt.f.setVisibility(8);
        }
      }
      else
      {
        if ((4 == localadjt.jdField_a_of_type_Anla.a.jobType) && (this.a.jdField_a_of_type_Anfj.b()) && (this.a.jdField_a_of_type_Anfj.a(localadjt.jdField_a_of_type_Anla.a.epId, true, true)) && (!this.a.jdField_b_of_type_Boolean))
        {
          localadjt.f.setImageResource(2130837704);
          localadjt.f.setVisibility(0);
        }
        if ((adje.c != 0L) && (adje.c == localadjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) && (localadjt.jdField_a_of_type_Anla.b()))
        {
          if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
            break label548;
          }
          bbmy.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131629840, 0).b(this.a.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
        }
      }
      for (;;)
      {
        if (!AppSetting.c) {
          break label568;
        }
        localadjt.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        return;
        if (this.a.jdField_b_of_type_Boolean) {
          break;
        }
        localadjt.f.setImageResource(2130837704);
        localadjt.f.setVisibility(0);
        break;
        MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localadjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adju
 * JD-Core Version:    0.7.0.1
 */