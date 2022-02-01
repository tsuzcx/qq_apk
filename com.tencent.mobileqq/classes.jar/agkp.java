import android.content.Context;
import android.content.res.Resources;
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

public class agkp
  extends aezf
{
  public afce a;
  public akxy a;
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
  
  private void a(agkp paramagkp, QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    if ((paramagkp == null) || (paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramMessageForPtt == null) || (paramMessageForPtt.getSttResult() == null)) {}
    int i;
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.getApp().getApplicationContext();
      } while (paramQQAppInterface == null);
      i = paramMessageForPtt.getSttResult().a();
    } while (((i != 3) && (i != 4)) || (paramagkp.b == null));
    paramagkp.b.setVisibility(0);
    paramagkp.b.setText(paramQQAppInterface.getString(2131718620));
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
  
  public void a(agkp paramagkp, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      break label7;
    }
    label7:
    label147:
    for (;;)
    {
      return;
      if (paramagkp != null)
      {
        if (paramQQAppInterface != null) {}
        for (paramQQAppInterface = paramQQAppInterface.getApp().getApplicationContext();; paramQQAppInterface = null)
        {
          if (paramQQAppInterface == null) {
            break label147;
          }
          if (paramagkp.jdField_a_of_type_AndroidWidgetProgressBar != null) {
            paramagkp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          }
          paramString = (RelativeLayout.LayoutParams)paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
          paramQQAppInterface = paramQQAppInterface.getResources();
          paramString.leftMargin = AIOUtils.dp2px(0.0F, paramQQAppInterface);
          if (paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView == null) {
            break;
          }
          int j = AIOUtils.dp2px(9.0F, paramQQAppInterface);
          try
          {
            i = paramQQAppInterface.getDrawable(2130844725).getIntrinsicHeight();
            int k = AIOUtils.dp2px(22.0F, paramQQAppInterface);
            paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(j, BaseChatItemLayout.m, j, i + k);
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
  
  public void a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt, SpannableString paramSpannableString, int paramInt)
  {
    if (paramQQAppInterface == null) {
      QLog.e("PttItemBuilder", 1, "refreshSttUIForShardAnimator app is null!");
    }
    int i;
    boolean bool1;
    boolean bool2;
    do
    {
      return;
      i = agkm.a(paramQQAppInterface, paramMessageForPtt);
      bool1 = agkm.a(paramQQAppInterface, paramMessageForPtt);
      switch (i)
      {
      default: 
        return;
      }
      i = agkm.b(paramMessageForPtt, i, paramQQAppInterface);
      bool2 = VoicePrintUtils.a(paramQQAppInterface, paramQQAppInterface.getApp().getBaseContext(), this, paramMessageForPtt);
    } while ((this.jdField_a_of_type_ComEtrumpMixlayoutETTextView == null) || (i != 2) || (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getVisibility() != 0));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(paramSpannableString);
    a(this, paramQQAppInterface, paramSpannableString.toString());
    agkm.a(this, paramMessageForPtt, i, bool2, paramMessageForPtt.timeStr, bool1, paramQQAppInterface, paramInt, paramSpannableString.toString());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkp
 * JD-Core Version:    0.7.0.1
 */