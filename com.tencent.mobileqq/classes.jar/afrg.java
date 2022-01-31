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

class afrg
  extends URLImageView
{
  public afrg(afqr paramafqr, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    paramThrowable = (afrf)aekt.a(this);
    paramThrowable.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.a.a(paramThrowable, paramURLDrawable);
    if (AppSetting.c) {
      paramThrowable.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(alpo.a(2131706843));
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    afrf localafrf = (afrf)aekt.a(this);
    super.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    super.setImageDrawable(paramURLDrawable);
    if (localafrf == null)
    {
      QLog.e("MarketFaceItemBuilder", 1, "onLoadSuccessed  holder == null url=" + paramURLDrawable.getURL());
      return;
    }
    if (localafrf.jdField_a_of_type_Aptm == null)
    {
      paramURLDrawable = localafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
      if ((!apro.a()) || (2 != localafrf.jdField_a_of_type_Aptm.a.jobType) || (this.a.jdField_a_of_type_Apnf.e(localafrf.jdField_a_of_type_Aptm.a.epId)) || (!atva.a()) || (apro.c()))
      {
        float f = this.a.jdField_a_of_type_Apnf.a(localafrf.jdField_a_of_type_Aptm.a.epId);
        if ((f < 0.0F) || (1.0F == f))
        {
          localafrf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          localafrf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
          if (QLog.isColorLevel()) {
            QLog.d("MarketFaceItemBuilder", 2, "onLoadSuccessed progressBar gone ");
          }
        }
      }
      this.a.a(localafrf, paramURLDrawable);
      if ((2 == localafrf.jdField_a_of_type_Aptm.a.jobType) && (atva.a()) && (this.a.jdField_a_of_type_Apnf.e(localafrf.jdField_a_of_type_Aptm.a.epId)))
      {
        if (attl.a(localafrf.jdField_a_of_type_Aptm.a.magicValue) == 1) {
          localafrf.f.setVisibility(8);
        }
      }
      else
      {
        if ((4 == localafrf.jdField_a_of_type_Aptm.a.jobType) && (this.a.jdField_a_of_type_Apnf.b()) && (this.a.jdField_a_of_type_Apnf.a(localafrf.jdField_a_of_type_Aptm.a.epId, true, true)) && (!this.a.jdField_b_of_type_Boolean))
        {
          localafrf.f.setImageResource(2130837910);
          localafrf.f.setVisibility(0);
        }
        if ((afqr.c != 0L) && (afqr.c == localafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) && (localafrf.jdField_a_of_type_Aptm.b()))
        {
          if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
            break label548;
          }
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695680, 0).b(this.a.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        }
      }
      for (;;)
      {
        if (!AppSetting.c) {
          break label568;
        }
        localafrf.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        return;
        if (this.a.jdField_b_of_type_Boolean) {
          break;
        }
        localafrf.f.setImageResource(2130837910);
        localafrf.f.setVisibility(0);
        break;
        MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrg
 * JD-Core Version:    0.7.0.1
 */