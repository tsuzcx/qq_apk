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

public class aeei
  extends aeee
{
  protected static HashMap<ChatMessage, aeen> a;
  protected static long c;
  public TroopChatPie a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
  }
  
  public aeei(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, TroopChatPie paramTroopChatPie)
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
    mze.a();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = mze.a("2833");
    if (QLog.isColorLevel()) {
      QLog.d("TroopSignItemBuilder", 2, "checkOffline version = " + str);
    }
    mze.a("2833", localQQAppInterface, new aeem(), true, 0, true);
  }
  
  public acun a()
  {
    return new aeeo();
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    aeeo localaeeo = (aeeo)paramacun;
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramChatMessage;
    localMessageForTroopSign.parse();
    if (paramView == null)
    {
      paramacun = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562575, paramBaseChatItemLayout, false);
      localaeeo.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramacun);
      localaeeo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView = ((TroopSignVideoView)localaeeo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364799));
      localaeeo.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localaeeo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376710));
      localaeeo.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localaeeo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369775));
      localaeeo.b = ((TextView)localaeeo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369777));
      localaeeo.jdField_c_of_type_AndroidViewView = localaeeo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369776);
      localaeeo.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localaeeo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369779));
      localaeeo.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localaeeo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369774));
      localaeeo.jdField_d_of_type_AndroidViewView = localaeeo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369778);
      localaeeo.jdField_e_of_type_AndroidViewView = localaeeo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369487);
      localaeeo.f = localaeeo.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369507);
      localaeeo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFocusable(false);
      localaeeo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFocusableInTouchMode(false);
      localaeeo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setClickable(false);
      localaeeo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFps(30);
      paramacun.setOnClickListener(this);
      paramacun.setOnLongClickListener(paramacxn);
      paramacun.setOnTouchListener(paramacxn);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a(new aeej(this, localaeeo, paramBaseChatItemLayout));
      }
      localaeeo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setOnPlayedListener(new aeek(this, localaeeo));
    }
    for (;;)
    {
      boolean bool = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
      if (!bool)
      {
        localaeeo.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopSign.msgContent);
        localaeeo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setShowCover(true);
        paramView = localMessageForTroopSign.dynamicSource;
        if (paramView.equals(localaeeo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.getTag())) {
          break label694;
        }
        localaeeo.jdField_e_of_type_AndroidViewView.setVisibility(0);
        localaeeo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setTag(paramView);
        localaeeo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.a();
        paramacxn = mzk.a("2833") + "2833" + "/troop_sign/" + paramView + ".mp4";
        if (!new File(paramacxn).exists()) {
          break label649;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.am)) {
          break label636;
        }
        localaeeo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFilePath(paramacxn);
        label479:
        localaeeo.f.setVisibility(8);
        label489:
        a(localaeeo.jdField_e_of_type_AndroidViewView, "2833", paramView, bool);
        label503:
        a(localaeeo, localMessageForTroopSign);
        if ((AppSetting.d) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle))) {
          paramacun.setContentDescription("" + localMessageForTroopSign.msgTitle);
        }
        a(localaeeo, paramBaseChatItemLayout);
        paramChatMessage = (FrameLayout.LayoutParams)localaeeo.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams();
        if (!localMessageForTroopSign.isSend()) {
          break label751;
        }
      }
      label649:
      label694:
      label751:
      for (paramChatMessage.leftMargin = (BaseChatItemLayout.j + bawz.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));; paramChatMessage.leftMargin = bawz.a(this.jdField_a_of_type_AndroidContentContext, 10.0F))
      {
        localaeeo.jdField_e_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
        return paramacun;
        localaeeo.jdField_a_of_type_AndroidWidgetTextView.setText("");
        localaeeo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setShowCover(false);
        break;
        label636:
        localaeeo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.a(paramacxn);
        break label479;
        if (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramChatMessage))
        {
          jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, new aeel(this, paramacxn, localaeeo));
          e();
        }
        localaeeo.f.setVisibility(0);
        break label489;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.am))
        {
          jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopSignItemBuilder.TroopSignVideoItemBuilder.4(this, localaeeo), 200L);
          break label503;
        }
        a(localaeeo.jdField_e_of_type_AndroidViewView, "2833", paramView, bool);
        break label503;
      }
      paramacun = paramView;
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
    paramString2 = new StringBuilder().append(mzk.a(paramString1)).append(paramString1).append("/troop_sign/").append(paramString2);
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
    paramString1.setTag(bavi.b(287, 287, bawz.a(this.jdField_a_of_type_AndroidContentContext, 5.0F)));
    paramString1.setDecodeHandler(bavi.i);
    paramView.setBackgroundDrawable(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeei
 * JD-Core Version:    0.7.0.1
 */