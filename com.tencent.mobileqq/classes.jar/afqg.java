import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class afqg
  implements afrc
{
  public static String a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public FastImagePreviewLayout a;
  private final boolean jdField_a_of_type_Boolean = true;
  private boolean b = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = "FastImageHelper";
  }
  
  public afqg(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.mContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.mActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.sessionInfo;
  }
  
  public void a()
  {
    this.b = true;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == 20) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie))) {
      a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 32: 
      if (QLog.isColorLevel()) {
        QLog.d("fastimage", 2, "MSG_SHOW_FASTIMAGE,  mAllowFastImage = " + this.b);
      }
      if (!this.b) {
        return true;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getEmotionKeyWordLayout() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getEmotionKeyWordLayout().getVisibility() == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getEmotionKeyWordLayout().hide();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler().removeMessages(67);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
        b(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getContent().addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D91", "0X8004D91", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.showFastImage();
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler().sendMessageDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler().obtainMessage(33), 5000L);
      return false;
    }
    b(true);
    return false;
  }
  
  public int[] a()
  {
    return new int[] { 20 };
  }
  
  public void b()
  {
    float f = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().density;
    if (QLog.isColorLevel()) {
      QLog.d("fastimage", 2, "initAndQueryFastImage start! ");
    }
    if (!this.b) {
      if (QLog.isColorLevel()) {
        QLog.d("fastimage", 2, "initAndQueryFastImage return!,  mAllowFastImage = " + this.b);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout = ((FastImagePreviewLayout)this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2131558605, null));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(2, 2131368751);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(7, 2131368751);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.rightMargin = ((int)(10.5D * f + 0.5D));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin = ((int)(f * 4.0F + 0.5F));
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setId(2131362373);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setHandler(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler());
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.queryFastImage();
    } while (!QLog.isColorLevel());
    QLog.d("fastimage", 2, "initAndQueryFastImage end! ");
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("fastimage", 2, "onPanelIconClick  removeFastImage");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler().removeMessages(33);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.removeFastImage(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getContent().removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("fastimage", 2, "BaseCHatPie onClick call enterPhotoPreivew. path = " + afcm.b);
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D92", "0X8004D92", 0, 0, "", "", "", "");
    PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).edit().putString("camera_photo_path", afcm.b).commit();
    Intent localIntent;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) && (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)))
    {
      localIntent = new Intent();
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    }
    for (;;)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1, localIntent, 8);
      if (QLog.isColorLevel()) {
        QLog.d("fastimage", 2, "BaseCHatPie onClick call removeFastImage");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler().removeMessages(33);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(null);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getContent().removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout);
      }
      return;
      localIntent = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqg
 * JD-Core Version:    0.7.0.1
 */