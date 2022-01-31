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

public class agau
  extends agaq
{
  protected static HashMap<ChatMessage, agaz> a;
  protected static long c;
  public TroopChatPie a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
  }
  
  public agau(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, TroopChatPie paramTroopChatPie)
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
    nbv.a();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = nbv.a("2833");
    if (QLog.isColorLevel()) {
      QLog.d("TroopSignItemBuilder", 2, "checkOffline version = " + str);
    }
    nbv.a("2833", localQQAppInterface, new agay(), true, 0, true);
  }
  
  public aelt a()
  {
    return new agba();
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    agba localagba = (agba)paramaelt;
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramChatMessage;
    localMessageForTroopSign.parse();
    if (paramView == null)
    {
      paramaelt = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562776, paramBaseChatItemLayout, false);
      localagba.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramaelt);
      localagba.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView = ((TroopSignVideoView)localagba.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364879));
      localagba.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localagba.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377222));
      localagba.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localagba.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370038));
      localagba.b = ((TextView)localagba.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370040));
      localagba.jdField_c_of_type_AndroidViewView = localagba.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370039);
      localagba.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localagba.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370042));
      localagba.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localagba.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370037));
      localagba.jdField_d_of_type_AndroidViewView = localagba.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370041);
      localagba.jdField_e_of_type_AndroidViewView = localagba.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369748);
      localagba.f = localagba.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369768);
      localagba.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFocusable(false);
      localagba.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFocusableInTouchMode(false);
      localagba.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setClickable(false);
      localagba.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFps(30);
      paramaelt.setOnClickListener(this);
      paramaelt.setOnLongClickListener(paramaeov);
      paramaelt.setOnTouchListener(paramaeov);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a(new agav(this, localagba, paramBaseChatItemLayout));
      }
      localagba.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setOnPlayedListener(new agaw(this, localagba));
    }
    for (;;)
    {
      boolean bool = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
      if (!bool)
      {
        localagba.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopSign.msgContent);
        localagba.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setShowCover(true);
        paramView = localMessageForTroopSign.dynamicSource;
        if (paramView.equals(localagba.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.getTag())) {
          break label694;
        }
        localagba.jdField_e_of_type_AndroidViewView.setVisibility(0);
        localagba.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setTag(paramView);
        localagba.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.a();
        paramaeov = ncb.a("2833") + "2833" + "/troop_sign/" + paramView + ".mp4";
        if (!new File(paramaeov).exists()) {
          break label649;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.am)) {
          break label636;
        }
        localagba.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFilePath(paramaeov);
        label479:
        localagba.f.setVisibility(8);
        label489:
        a(localagba.jdField_e_of_type_AndroidViewView, "2833", paramView, bool);
        label503:
        a(localagba, localMessageForTroopSign);
        if ((AppSetting.c) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle))) {
          paramaelt.setContentDescription("" + localMessageForTroopSign.msgTitle);
        }
        a(localagba, paramBaseChatItemLayout);
        paramChatMessage = (FrameLayout.LayoutParams)localagba.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams();
        if (!localMessageForTroopSign.isSend()) {
          break label751;
        }
      }
      label649:
      label694:
      label751:
      for (paramChatMessage.leftMargin = (BaseChatItemLayout.j + bcwh.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));; paramChatMessage.leftMargin = bcwh.a(this.jdField_a_of_type_AndroidContentContext, 10.0F))
      {
        localagba.jdField_e_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
        return paramaelt;
        localagba.jdField_a_of_type_AndroidWidgetTextView.setText("");
        localagba.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setShowCover(false);
        break;
        label636:
        localagba.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.a(paramaeov);
        break label479;
        if (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramChatMessage))
        {
          jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, new agax(this, paramaeov, localagba));
          e();
        }
        localagba.f.setVisibility(0);
        break label489;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.am))
        {
          jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopSignItemBuilder.TroopSignVideoItemBuilder.4(this, localagba), 200L);
          break label503;
        }
        a(localagba.jdField_e_of_type_AndroidViewView, "2833", paramView, bool);
        break label503;
      }
      paramaelt = paramView;
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
    paramString2 = new StringBuilder().append(ncb.a(paramString1)).append(paramString1).append("/troop_sign/").append(paramString2);
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
    paramString1.setTag(bcuq.b(287, 287, bcwh.a(this.jdField_a_of_type_AndroidContentContext, 5.0F)));
    paramString1.setDecodeHandler(bcuq.i);
    paramView.setBackgroundDrawable(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agau
 * JD-Core Version:    0.7.0.1
 */