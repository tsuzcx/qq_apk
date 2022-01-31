import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignVideoItemBuilder.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.troop.widget.TroopSignVideoView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;

public class adtj
  extends adtf
{
  protected static HashMap<ChatMessage, adto> a;
  protected static long c;
  public aejb a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
  }
  
  public adtj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, aejb paramaejb)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Aejb = paramaejb;
  }
  
  public static void e()
  {
    if (System.currentTimeMillis() - c < 600000L) {
      return;
    }
    c = System.currentTimeMillis();
    mof.a();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = mof.a("2833");
    if (QLog.isColorLevel()) {
      QLog.d("TroopSignItemBuilder", 2, "checkOffline version = " + str);
    }
    mof.a("2833", localQQAppInterface, new adtn(), true, 0, true);
  }
  
  public acju a()
  {
    return new adtp();
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    adtp localadtp = (adtp)paramacju;
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramChatMessage;
    localMessageForTroopSign.parse();
    if (paramView == null)
    {
      paramacju = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131496975, paramBaseChatItemLayout, false);
      localadtp.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramacju);
      localadtp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView = ((TroopSignVideoView)localadtp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131299236));
      localadtp.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localadtp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131310903));
      localadtp.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localadtp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131304102));
      localadtp.b = ((TextView)localadtp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131304104));
      localadtp.jdField_c_of_type_AndroidViewView = localadtp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131304103);
      localadtp.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localadtp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131304106));
      localadtp.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localadtp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131304101));
      localadtp.jdField_d_of_type_AndroidViewView = localadtp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131304105);
      localadtp.jdField_e_of_type_AndroidViewView = localadtp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303812);
      localadtp.f = localadtp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303832);
      localadtp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFocusable(false);
      localadtp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFocusableInTouchMode(false);
      localadtp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setClickable(false);
      localadtp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFps(30);
      paramacju.setOnClickListener(this);
      paramacju.setOnLongClickListener(paramacmv);
      paramacju.setOnTouchListener(paramacmv);
      if (this.jdField_a_of_type_Aejb != null) {
        this.jdField_a_of_type_Aejb.a(new adtk(this, localadtp, paramBaseChatItemLayout));
      }
      localadtp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setOnPlayedListener(new adtl(this, localadtp));
    }
    for (;;)
    {
      boolean bool = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
      if (!bool)
      {
        localadtp.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopSign.msgContent);
        localadtp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setShowCover(true);
        paramView = localMessageForTroopSign.dynamicSource;
        if (paramView.equals(localadtp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.getTag())) {
          break label694;
        }
        localadtp.jdField_e_of_type_AndroidViewView.setVisibility(0);
        localadtp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setTag(paramView);
        localadtp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.a();
        paramacmv = mol.a("2833") + "2833" + "/troop_sign/" + paramView + ".mp4";
        if (!new File(paramacmv).exists()) {
          break label649;
        }
        if ((this.jdField_a_of_type_Aejb == null) || (!this.jdField_a_of_type_Aejb.am)) {
          break label636;
        }
        localadtp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFilePath(paramacmv);
        label479:
        localadtp.f.setVisibility(8);
        label489:
        a(localadtp.jdField_e_of_type_AndroidViewView, "2833", paramView, bool);
        label503:
        a(localadtp, localMessageForTroopSign);
        if ((AppSetting.c) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle))) {
          paramacju.setContentDescription("" + localMessageForTroopSign.msgTitle);
        }
        a(localadtp, paramBaseChatItemLayout);
        paramChatMessage = (FrameLayout.LayoutParams)localadtp.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams();
        if (!localMessageForTroopSign.isSend()) {
          break label751;
        }
      }
      label649:
      label694:
      label751:
      for (paramChatMessage.leftMargin = (BaseChatItemLayout.j + azvv.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));; paramChatMessage.leftMargin = azvv.a(this.jdField_a_of_type_AndroidContentContext, 10.0F))
      {
        localadtp.jdField_e_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
        return paramacju;
        localadtp.jdField_a_of_type_AndroidWidgetTextView.setText("");
        localadtp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setShowCover(false);
        break;
        label636:
        localadtp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.a(paramacmv);
        break label479;
        if (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramChatMessage))
        {
          jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, new adtm(this, paramacmv, localadtp));
          e();
        }
        localadtp.f.setVisibility(0);
        break label489;
        if ((this.jdField_a_of_type_Aejb != null) && (!this.jdField_a_of_type_Aejb.am))
        {
          jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopSignItemBuilder.TroopSignVideoItemBuilder.4(this, localadtp), 200L);
          break label503;
        }
        a(localadtp.jdField_e_of_type_AndroidViewView, "2833", paramView, bool);
        break label503;
      }
      paramacju = paramView;
    }
  }
  
  public void a()
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    super.a();
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean) {}
  
  protected void a(View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = new StringBuilder().append(mol.a(paramString1)).append(paramString1).append("/troop_sign/").append(paramString2);
    if (paramBoolean) {}
    for (paramString1 = "_no_summary";; paramString1 = "")
    {
      paramString1 = new File(paramString1 + ".png");
      if (!paramString1.exists()) {
        break;
      }
      paramString2 = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(0);
      paramString2.mFailedDrawable = localColorDrawable;
      paramString2.mLoadingDrawable = localColorDrawable;
      try
      {
        paramView.setBackgroundDrawable(URLDrawable.getDrawable(paramString1.toURL(), paramString2));
        return;
      }
      catch (MalformedURLException paramView)
      {
        paramView.printStackTrace();
        return;
      }
    }
    paramString1 = URLDrawable.URLDrawableOptions.obtain();
    paramString2 = new ColorDrawable(0);
    paramString1.mFailedDrawable = paramString2;
    paramString1.mLoadingDrawable = paramString2;
    paramString1 = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/troop_sign_loading.png", paramString1);
    paramString1.setTag(azue.b(287, 287, azvv.a(this.jdField_a_of_type_AndroidContentContext, 5.0F)));
    paramString1.setDecodeHandler(azue.i);
    paramView.setBackgroundDrawable(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adtj
 * JD-Core Version:    0.7.0.1
 */