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

class ahmh
  extends URLImageView
{
  public ahmh(ahlt paramahlt, Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(ahmg paramahmg)
  {
    if ((!asos.a()) || (2 != paramahmg.jdField_a_of_type_Asre.a.jobType) || (this.a.jdField_a_of_type_Askd.f(paramahmg.jdField_a_of_type_Asre.a.epId)) || (!awzk.a()) || (asos.c()))
    {
      float f = this.a.jdField_a_of_type_Askd.a(paramahmg.jdField_a_of_type_Asre.a.epId);
      if ((f < 0.0F) || (1.0F == f))
      {
        paramahmg.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramahmg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "onLoadSuccessed progressBar gone ");
        }
      }
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    paramThrowable = (ahmg)agej.a(this);
    paramThrowable.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.a.a(paramThrowable, paramURLDrawable);
    if (AppSetting.c) {
      paramThrowable.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(anzj.a(2131705353));
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ahmg localahmg = (ahmg)agej.a(this);
    super.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    super.setImageDrawable(paramURLDrawable);
    if (localahmg == null)
    {
      QLog.e("MarketFaceItemBuilder", 1, "onLoadSuccessed  holder == null url=" + paramURLDrawable.getURL());
      return;
    }
    if (localahmg.jdField_a_of_type_Asre == null)
    {
      paramURLDrawable = localahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
      a(localahmg);
      this.a.a(localahmg, paramURLDrawable);
      if ((2 == localahmg.jdField_a_of_type_Asre.a.jobType) && (awzk.a()) && (this.a.jdField_a_of_type_Askd.f(localahmg.jdField_a_of_type_Asre.a.epId)))
      {
        if (awxv.a(localahmg.jdField_a_of_type_Asre.a.magicValue) == 1) {
          localahmg.f.setVisibility(8);
        }
      }
      else
      {
        if ((4 == localahmg.jdField_a_of_type_Asre.a.jobType) && (this.a.jdField_a_of_type_Askd.b()) && (this.a.jdField_a_of_type_Askd.a(localahmg.jdField_a_of_type_Asre.a.epId, true, true)) && (!this.a.jdField_b_of_type_Boolean))
        {
          localahmg.f.setImageResource(2130838014);
          localahmg.f.setVisibility(0);
        }
        if ((ahlt.c != 0L) && (ahlt.c == localahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) && (localahmg.jdField_a_of_type_Asre.b()))
        {
          if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
            break label412;
          }
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694616, 0).b(this.a.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
        }
      }
      for (;;)
      {
        if (!AppSetting.c) {
          break label431;
        }
        localahmg.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        return;
        if (this.a.jdField_b_of_type_Boolean) {
          break;
        }
        localahmg.f.setImageResource(2130838014);
        localahmg.f.setVisibility(0);
        break;
        MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmh
 * JD-Core Version:    0.7.0.1
 */