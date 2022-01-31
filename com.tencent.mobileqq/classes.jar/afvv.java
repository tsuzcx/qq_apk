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

class afvv
  extends URLImageView
{
  public afvv(afvg paramafvg, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    paramThrowable = (afvu)aepi.a(this);
    paramThrowable.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.a.a(paramThrowable, paramURLDrawable);
    if (AppSetting.c) {
      paramThrowable.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(alud.a(2131706855));
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    afvu localafvu = (afvu)aepi.a(this);
    super.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    super.setImageDrawable(paramURLDrawable);
    if (localafvu == null)
    {
      QLog.e("MarketFaceItemBuilder", 1, "onLoadSuccessed  holder == null url=" + paramURLDrawable.getURL());
      return;
    }
    if (localafvu.jdField_a_of_type_Apxv == null)
    {
      paramURLDrawable = localafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
      if ((!apvx.a()) || (2 != localafvu.jdField_a_of_type_Apxv.a.jobType) || (this.a.jdField_a_of_type_Apro.e(localafvu.jdField_a_of_type_Apxv.a.epId)) || (!atzj.a()) || (apvx.c()))
      {
        float f = this.a.jdField_a_of_type_Apro.a(localafvu.jdField_a_of_type_Apxv.a.epId);
        if ((f < 0.0F) || (1.0F == f))
        {
          localafvu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          localafvu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
          if (QLog.isColorLevel()) {
            QLog.d("MarketFaceItemBuilder", 2, "onLoadSuccessed progressBar gone ");
          }
        }
      }
      this.a.a(localafvu, paramURLDrawable);
      if ((2 == localafvu.jdField_a_of_type_Apxv.a.jobType) && (atzj.a()) && (this.a.jdField_a_of_type_Apro.e(localafvu.jdField_a_of_type_Apxv.a.epId)))
      {
        if (atxu.a(localafvu.jdField_a_of_type_Apxv.a.magicValue) == 1) {
          localafvu.f.setVisibility(8);
        }
      }
      else
      {
        if ((4 == localafvu.jdField_a_of_type_Apxv.a.jobType) && (this.a.jdField_a_of_type_Apro.b()) && (this.a.jdField_a_of_type_Apro.a(localafvu.jdField_a_of_type_Apxv.a.epId, true, true)) && (!this.a.jdField_b_of_type_Boolean))
        {
          localafvu.f.setImageResource(2130837911);
          localafvu.f.setVisibility(0);
        }
        if ((afvg.c != 0L) && (afvg.c == localafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) && (localafvu.jdField_a_of_type_Apxv.b()))
        {
          if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
            break label548;
          }
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695682, 0).b(this.a.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        }
      }
      for (;;)
      {
        if (!AppSetting.c) {
          break label568;
        }
        localafvu.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        return;
        if (this.a.jdField_b_of_type_Boolean) {
          break;
        }
        localafvu.f.setImageResource(2130837911);
        localafvu.f.setVisibility(0);
        break;
        MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvv
 * JD-Core Version:    0.7.0.1
 */