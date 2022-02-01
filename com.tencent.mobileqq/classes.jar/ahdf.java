import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PttAudioChangeView;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ahdf
  extends afqr
{
  public aftk a;
  public alvu a;
  public ImageView a;
  public ProgressBar a;
  public RelativeLayout a;
  public TextView a;
  public ETTextView a;
  public VoicePrintUtils.VoicePrintView a;
  public BreathAnimationLayout a;
  public PttAudioChangeView a;
  public PttAudioPlayView a;
  public PttAudioWaveView a;
  public StringBuilder a;
  private boolean a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  public ImageView d;
  public ImageView e;
  public ImageView f;
  
  private void a(ahdf paramahdf, QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    if ((paramahdf == null) || (paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramMessageForPtt == null) || (paramMessageForPtt.getSttResult() == null)) {}
    int i;
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.getApp().getApplicationContext();
      } while (paramQQAppInterface == null);
      i = paramMessageForPtt.getSttResult().a();
    } while (((i != 3) && (i != 4)) || (paramahdf.b == null));
    paramahdf.b.setVisibility(0);
    paramahdf.b.setText(paramQQAppInterface.getString(2131719009));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.a();
    }
  }
  
  public void a(ahdf paramahdf, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      break label7;
    }
    label7:
    label147:
    for (;;)
    {
      return;
      if (paramahdf != null)
      {
        if (paramQQAppInterface != null) {}
        for (paramQQAppInterface = paramQQAppInterface.getApp().getApplicationContext();; paramQQAppInterface = null)
        {
          if (paramQQAppInterface == null) {
            break label147;
          }
          if (paramahdf.jdField_a_of_type_AndroidWidgetProgressBar != null) {
            paramahdf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          }
          paramString = (RelativeLayout.LayoutParams)paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
          paramQQAppInterface = paramQQAppInterface.getResources();
          paramString.leftMargin = AIOUtils.dp2px(0.0F, paramQQAppInterface);
          if (paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView == null) {
            break;
          }
          int j = AIOUtils.dp2px(9.0F, paramQQAppInterface);
          try
          {
            i = paramQQAppInterface.getDrawable(2130844794).getIntrinsicHeight();
            int k = AIOUtils.dp2px(22.0F, paramQQAppInterface);
            paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(j, BaseChatItemLayout.m, j, i + k);
            return;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              int i = AIOUtils.dp2px(24.0F, paramQQAppInterface);
              QLog.e("PttItemBuilder", 1, "", paramString);
            }
          }
        }
      }
    }
  }
  
  public void a(Rect paramRect)
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramRect != null)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.getGlobalVisibleRect(paramRect);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt, SpannableString paramSpannableString, int paramInt)
  {
    if (paramQQAppInterface == null) {
      QLog.e("PttItemBuilder", 1, "refreshSttUIForShardAnimator app is null!");
    }
    int i;
    int j;
    boolean bool1;
    do
    {
      return;
      i = ahdc.a(paramQQAppInterface, paramMessageForPtt);
      j = ahdc.b(paramMessageForPtt, i, paramQQAppInterface);
      bool1 = ahdc.a(paramQQAppInterface, paramMessageForPtt);
    } while (!a(i, j));
    boolean bool2 = VoicePrintUtils.a(paramQQAppInterface, paramQQAppInterface.getApp().getBaseContext(), this, paramMessageForPtt);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(paramSpannableString);
    a(this, paramQQAppInterface, paramSpannableString.toString());
    ahdc.a(this, paramMessageForPtt, j, bool2, paramMessageForPtt.timeStr, bool1, paramQQAppInterface, paramInt, paramSpannableString.toString());
    a(this, paramQQAppInterface, paramMessageForPtt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return false;
    } while ((this.jdField_a_of_type_ComEtrumpMixlayoutETTextView == null) || (paramInt2 != 2) || (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getVisibility() != 0));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdf
 * JD-Core Version:    0.7.0.1
 */