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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ahcv
  extends URLImageView
{
  public ahcv(ahch paramahch, Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(ahcu paramahcu)
  {
    if ((!arze.a()) || (2 != paramahcu.jdField_a_of_type_Asbq.a.jobType) || (this.a.jdField_a_of_type_Arup.f(paramahcu.jdField_a_of_type_Asbq.a.epId)) || (!awgs.a()) || (arze.c()))
    {
      float f = this.a.jdField_a_of_type_Arup.a(paramahcu.jdField_a_of_type_Asbq.a.epId);
      if ((f < 0.0F) || (1.0F == f))
      {
        paramahcu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramahcu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "onLoadSuccessed progressBar gone ");
        }
      }
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    paramThrowable = (ahcu)afur.a(this);
    paramThrowable.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.a.a(paramThrowable, paramURLDrawable);
    if (AppSetting.c) {
      paramThrowable.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(anni.a(2131705246));
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ahcu localahcu = (ahcu)afur.a(this);
    super.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    super.setImageDrawable(paramURLDrawable);
    if (localahcu == null)
    {
      QLog.e("MarketFaceItemBuilder", 1, "onLoadSuccessed  holder == null url=" + paramURLDrawable.getURL());
      return;
    }
    if (localahcu.jdField_a_of_type_Asbq == null)
    {
      paramURLDrawable = localahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (!(paramURLDrawable instanceof MessageForMarketFace)) {
        break label433;
      }
      paramURLDrawable = ((MessageForMarketFace)paramURLDrawable).mMarkFaceMessage;
      if (paramURLDrawable == null) {
        break label433;
      }
    }
    label412:
    label431:
    label433:
    for (int i = paramURLDrawable.dwTabID;; i = -1)
    {
      QLog.e("MarketFaceItemBuilder", 1, "onLoadSuccessed  emoticonInfo == null epId = " + i);
      return;
      a(localahcu);
      this.a.a(localahcu, paramURLDrawable);
      if ((2 == localahcu.jdField_a_of_type_Asbq.a.jobType) && (awgs.a()) && (this.a.jdField_a_of_type_Arup.f(localahcu.jdField_a_of_type_Asbq.a.epId)))
      {
        if (awfd.a(localahcu.jdField_a_of_type_Asbq.a.magicValue) == 1) {
          localahcu.f.setVisibility(8);
        }
      }
      else
      {
        if ((4 == localahcu.jdField_a_of_type_Asbq.a.jobType) && (this.a.jdField_a_of_type_Arup.b()) && (this.a.jdField_a_of_type_Arup.a(localahcu.jdField_a_of_type_Asbq.a.epId, true, true)) && (!this.a.jdField_b_of_type_Boolean))
        {
          localahcu.f.setImageResource(2130838005);
          localahcu.f.setVisibility(0);
        }
        if ((ahch.c != 0L) && (ahch.c == localahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) && (localahcu.jdField_a_of_type_Asbq.b()))
        {
          if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
            break label412;
          }
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694574, 0).b(this.a.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
        }
      }
      for (;;)
      {
        if (!AppSetting.c) {
          break label431;
        }
        localahcu.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        return;
        if (this.a.jdField_b_of_type_Boolean) {
          break;
        }
        localahcu.f.setImageResource(2130838005);
        localahcu.f.setVisibility(0);
        break;
        MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcv
 * JD-Core Version:    0.7.0.1
 */