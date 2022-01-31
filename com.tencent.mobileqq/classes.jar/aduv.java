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

class aduv
  extends URLImageView
{
  public aduv(adug paramadug, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    paramThrowable = (aduu)actn.a(this);
    paramThrowable.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.a.a(paramThrowable, paramURLDrawable);
    if (AppSetting.d) {
      paramThrowable.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(ajyc.a(2131706460));
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    aduu localaduu = (aduu)actn.a(this);
    super.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    super.setImageDrawable(paramURLDrawable);
    if (localaduu == null)
    {
      QLog.e("MarketFaceItemBuilder", 1, "onLoadSuccessed  holder == null url=" + paramURLDrawable.getURL());
      return;
    }
    if (localaduu.jdField_a_of_type_Aobk == null)
    {
      paramURLDrawable = localaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
      if ((!anzm.a()) || (2 != localaduu.jdField_a_of_type_Aobk.a.jobType) || (this.a.jdField_a_of_type_Anvs.e(localaduu.jdField_a_of_type_Aobk.a.epId)) || (!asdy.a()) || (anzm.c()))
      {
        float f = this.a.jdField_a_of_type_Anvs.a(localaduu.jdField_a_of_type_Aobk.a.epId);
        if ((f < 0.0F) || (1.0F == f))
        {
          localaduu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          localaduu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
          if (QLog.isColorLevel()) {
            QLog.d("MarketFaceItemBuilder", 2, "onLoadSuccessed progressBar gone ");
          }
        }
      }
      this.a.a(localaduu, paramURLDrawable);
      if ((2 == localaduu.jdField_a_of_type_Aobk.a.jobType) && (asdy.a()) && (this.a.jdField_a_of_type_Anvs.e(localaduu.jdField_a_of_type_Aobk.a.epId)))
      {
        if (ascj.a(localaduu.jdField_a_of_type_Aobk.a.magicValue) == 1) {
          localaduu.f.setVisibility(8);
        }
      }
      else
      {
        if ((4 == localaduu.jdField_a_of_type_Aobk.a.jobType) && (this.a.jdField_a_of_type_Anvs.b()) && (this.a.jdField_a_of_type_Anvs.a(localaduu.jdField_a_of_type_Aobk.a.epId, true, true)) && (!this.a.jdField_b_of_type_Boolean))
        {
          localaduu.f.setImageResource(2130837714);
          localaduu.f.setVisibility(0);
        }
        if ((adug.c != 0L) && (adug.c == localaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) && (localaduu.jdField_a_of_type_Aobk.b()))
        {
          if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
            break label548;
          }
          bcpw.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695521, 0).b(this.a.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        }
      }
      for (;;)
      {
        if (!AppSetting.d) {
          break label568;
        }
        localaduu.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        return;
        if (this.a.jdField_b_of_type_Boolean) {
          break;
        }
        localaduu.f.setImageResource(2130837714);
        localaduu.f.setVisibility(0);
        break;
        MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aduv
 * JD-Core Version:    0.7.0.1
 */