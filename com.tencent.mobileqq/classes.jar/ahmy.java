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

public class ahmy
  extends ahmu
{
  protected static HashMap<ChatMessage, ahnd> a;
  protected static long c;
  public TroopChatPie a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
  }
  
  public ahmy(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, TroopChatPie paramTroopChatPie)
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
    nko.a();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = nko.a("2833");
    if (QLog.isColorLevel()) {
      QLog.d("TroopSignItemBuilder", 2, "checkOffline version = " + str);
    }
    nko.a("2833", localQQAppInterface, new ahnc(), true, 0, true);
  }
  
  public afwr a()
  {
    return new ahne();
  }
  
  public View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    ahne localahne = (ahne)paramafwr;
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramChatMessage;
    localMessageForTroopSign.parse();
    if (paramView == null)
    {
      paramafwr = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563033, paramBaseChatItemLayout, false);
      localahne.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramafwr);
      localahne.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView = ((TroopSignVideoView)localahne.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365114));
      localahne.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localahne.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378086));
      localahne.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localahne.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370500));
      localahne.b = ((TextView)localahne.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370502));
      localahne.jdField_c_of_type_AndroidViewView = localahne.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370501);
      localahne.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localahne.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370504));
      localahne.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localahne.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370499));
      localahne.jdField_d_of_type_AndroidViewView = localahne.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370503);
      localahne.jdField_e_of_type_AndroidViewView = localahne.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370198);
      localahne.f = localahne.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370223);
      localahne.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFocusable(false);
      localahne.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFocusableInTouchMode(false);
      localahne.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setClickable(false);
      localahne.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFps(30);
      paramafwr.setOnClickListener(this);
      paramafwr.setOnLongClickListener(paramafzq);
      paramafwr.setOnTouchListener(paramafzq);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a(new ahmz(this, localahne, paramBaseChatItemLayout));
      }
      localahne.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setOnPlayedListener(new ahna(this, localahne));
    }
    for (;;)
    {
      boolean bool = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
      if (!bool)
      {
        localahne.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopSign.msgContent);
        localahne.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setShowCover(true);
        paramView = localMessageForTroopSign.dynamicSource;
        if (paramView.equals(localahne.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.getTag())) {
          break label694;
        }
        localahne.jdField_e_of_type_AndroidViewView.setVisibility(0);
        localahne.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setTag(paramView);
        localahne.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.a();
        paramafzq = nku.a("2833") + "2833" + "/troop_sign/" + paramView + ".mp4";
        if (!new File(paramafzq).exists()) {
          break label649;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.al)) {
          break label636;
        }
        localahne.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFilePath(paramafzq);
        label479:
        localahne.f.setVisibility(8);
        label489:
        a(localahne.jdField_e_of_type_AndroidViewView, "2833", paramView, bool);
        label503:
        a(localahne, localMessageForTroopSign);
        if ((AppSetting.c) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle))) {
          paramafwr.setContentDescription("" + localMessageForTroopSign.msgTitle);
        }
        a(localahne, paramBaseChatItemLayout);
        paramChatMessage = (FrameLayout.LayoutParams)localahne.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams();
        if (!localMessageForTroopSign.isSend()) {
          break label751;
        }
      }
      label649:
      label694:
      label751:
      for (paramChatMessage.leftMargin = (BaseChatItemLayout.k + bggq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));; paramChatMessage.leftMargin = bggq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F))
      {
        localahne.jdField_e_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
        return paramafwr;
        localahne.jdField_a_of_type_AndroidWidgetTextView.setText("");
        localahne.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setShowCover(false);
        break;
        label636:
        localahne.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.a(paramafzq);
        break label479;
        if (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramChatMessage))
        {
          jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, new ahnb(this, paramafzq, localahne));
          e();
        }
        localahne.f.setVisibility(0);
        break label489;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.al))
        {
          jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopSignItemBuilder.TroopSignVideoItemBuilder.4(this, localahne), 200L);
          break label503;
        }
        a(localahne.jdField_e_of_type_AndroidViewView, "2833", paramView, bool);
        break label503;
      }
      paramafwr = paramView;
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
    paramString2 = new StringBuilder().append(nku.a(paramString1)).append(paramString1).append("/troop_sign/").append(paramString2);
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
    paramString1.setTag(bgey.b(287, 287, bggq.a(this.jdField_a_of_type_AndroidContentContext, 5.0F)));
    paramString1.setDecodeHandler(bgey.j);
    paramView.setBackgroundDrawable(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmy
 * JD-Core Version:    0.7.0.1
 */