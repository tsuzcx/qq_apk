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

class adut
  extends URLImageView
{
  public adut(adue paramadue, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    paramThrowable = (adus)actj.a(this);
    paramThrowable.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.a.a(paramThrowable, paramURLDrawable);
    if (AppSetting.d) {
      paramThrowable.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(ajya.a(2131706471));
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    adus localadus = (adus)actj.a(this);
    super.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    super.setImageDrawable(paramURLDrawable);
    if (localadus == null)
    {
      QLog.e("MarketFaceItemBuilder", 1, "onLoadSuccessed  holder == null url=" + paramURLDrawable.getURL());
      return;
    }
    if (localadus.jdField_a_of_type_Aobp == null)
    {
      paramURLDrawable = localadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
      if ((!anzr.a()) || (2 != localadus.jdField_a_of_type_Aobp.a.jobType) || (this.a.jdField_a_of_type_Anvx.e(localadus.jdField_a_of_type_Aobp.a.epId)) || (!asea.a()) || (anzr.c()))
      {
        float f = this.a.jdField_a_of_type_Anvx.a(localadus.jdField_a_of_type_Aobp.a.epId);
        if ((f < 0.0F) || (1.0F == f))
        {
          localadus.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          localadus.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
          if (QLog.isColorLevel()) {
            QLog.d("MarketFaceItemBuilder", 2, "onLoadSuccessed progressBar gone ");
          }
        }
      }
      this.a.a(localadus, paramURLDrawable);
      if ((2 == localadus.jdField_a_of_type_Aobp.a.jobType) && (asea.a()) && (this.a.jdField_a_of_type_Anvx.e(localadus.jdField_a_of_type_Aobp.a.epId)))
      {
        if (ascl.a(localadus.jdField_a_of_type_Aobp.a.magicValue) == 1) {
          localadus.f.setVisibility(8);
        }
      }
      else
      {
        if ((4 == localadus.jdField_a_of_type_Aobp.a.jobType) && (this.a.jdField_a_of_type_Anvx.b()) && (this.a.jdField_a_of_type_Anvx.a(localadus.jdField_a_of_type_Aobp.a.epId, true, true)) && (!this.a.jdField_b_of_type_Boolean))
        {
          localadus.f.setImageResource(2130837714);
          localadus.f.setVisibility(0);
        }
        if ((adue.c != 0L) && (adue.c == localadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) && (localadus.jdField_a_of_type_Aobp.b()))
        {
          if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
            break label548;
          }
          bcql.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695522, 0).b(this.a.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        }
      }
      for (;;)
      {
        if (!AppSetting.d) {
          break label568;
        }
        localadus.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        return;
        if (this.a.jdField_b_of_type_Boolean) {
          break;
        }
        localadus.f.setImageResource(2130837714);
        localadus.f.setVisibility(0);
        break;
        MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adut
 * JD-Core Version:    0.7.0.1
 */