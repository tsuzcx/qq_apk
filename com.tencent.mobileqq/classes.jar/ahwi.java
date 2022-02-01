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
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.troop.widget.TroopSignVideoView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;

public class ahwi
  extends ahwe
{
  protected static HashMap<ChatMessage, ahwn> a;
  protected static long c;
  public TroopChatPie a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
  }
  
  public ahwi(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, TroopChatPie paramTroopChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
  }
  
  public static void e()
  {
    if (System.currentTimeMillis() - c < 600000L) {
      return;
    }
    c = System.currentTimeMillis();
    nmj.a();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = nmj.a("2833");
    if (QLog.isColorLevel()) {
      QLog.d("TroopSignItemBuilder", 2, "checkOffline version = " + str);
    }
    nmj.a("2833", localQQAppInterface, new ahwm(), true, 0, true);
  }
  
  public aggl a()
  {
    return new ahwo();
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    ahwo localahwo = (ahwo)paramaggl;
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramChatMessage;
    localMessageForTroopSign.parse();
    if (paramView == null)
    {
      paramaggl = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563068, paramBaseChatItemLayout, false);
      localahwo.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramaggl);
      localahwo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView = ((TroopSignVideoView)localahwo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365160));
      localahwo.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localahwo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378243));
      localahwo.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localahwo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370602));
      localahwo.b = ((TextView)localahwo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370604));
      localahwo.jdField_c_of_type_AndroidViewView = localahwo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370603);
      localahwo.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localahwo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370606));
      localahwo.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localahwo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370601));
      localahwo.jdField_d_of_type_AndroidViewView = localahwo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370605);
      localahwo.jdField_e_of_type_AndroidViewView = localahwo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370299);
      localahwo.f = localahwo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370324);
      localahwo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFocusable(false);
      localahwo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFocusableInTouchMode(false);
      localahwo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setClickable(false);
      localahwo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFps(30);
      paramaggl.setOnClickListener(this);
      paramaggl.setOnLongClickListener(paramagjk);
      paramaggl.setOnTouchListener(paramagjk);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a(new ahwj(this, localahwo, paramBaseChatItemLayout));
      }
      localahwo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setOnPlayedListener(new ahwk(this, localahwo));
    }
    for (;;)
    {
      boolean bool = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
      if (!bool)
      {
        localahwo.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopSign.msgContent);
        localahwo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setShowCover(true);
        paramView = localMessageForTroopSign.dynamicSource;
        if (paramView.equals(localahwo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.getTag())) {
          break label694;
        }
        localahwo.jdField_e_of_type_AndroidViewView.setVisibility(0);
        localahwo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setTag(paramView);
        localahwo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.a();
        paramagjk = nmp.a("2833") + "2833" + "/troop_sign/" + paramView + ".mp4";
        if (!new File(paramagjk).exists()) {
          break label649;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.al)) {
          break label636;
        }
        localahwo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFilePath(paramagjk);
        label479:
        localahwo.f.setVisibility(8);
        label489:
        a(localahwo.jdField_e_of_type_AndroidViewView, "2833", paramView, bool);
        label503:
        a(localahwo, localMessageForTroopSign);
        if ((AppSetting.c) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle))) {
          paramaggl.setContentDescription("" + localMessageForTroopSign.msgTitle);
        }
        a(localahwo, paramBaseChatItemLayout);
        paramChatMessage = (FrameLayout.LayoutParams)localahwo.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams();
        if (!localMessageForTroopSign.isSend()) {
          break label751;
        }
      }
      label649:
      label694:
      label751:
      for (paramChatMessage.leftMargin = (BaseChatItemLayout.k + bhgr.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));; paramChatMessage.leftMargin = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 10.0F))
      {
        localahwo.jdField_e_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
        return paramaggl;
        localahwo.jdField_a_of_type_AndroidWidgetTextView.setText("");
        localahwo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setShowCover(false);
        break;
        label636:
        localahwo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.a(paramagjk);
        break label479;
        if (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramChatMessage))
        {
          jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, new ahwl(this, paramagjk, localahwo));
          e();
        }
        localahwo.f.setVisibility(0);
        break label489;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.al))
        {
          jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopSignItemBuilder.TroopSignVideoItemBuilder.4(this, localahwo), 200L);
          break label503;
        }
        a(localahwo.jdField_e_of_type_AndroidViewView, "2833", paramView, bool);
        break label503;
      }
      paramaggl = paramView;
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
    paramString2 = new StringBuilder().append(nmp.a(paramString1)).append(paramString1).append("/troop_sign/").append(paramString2);
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
    paramString1 = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/troop_sign_loading.png", paramString1);
    paramString1.setTag(bhez.b(287, 287, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 5.0F)));
    paramString1.setDecodeHandler(bhez.j);
    paramView.setBackgroundDrawable(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwi
 * JD-Core Version:    0.7.0.1
 */