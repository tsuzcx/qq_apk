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

public class agfj
  extends agff
{
  protected static HashMap<ChatMessage, agfo> a;
  protected static long c;
  public TroopChatPie a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
  }
  
  public agfj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, TroopChatPie paramTroopChatPie)
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
    nbv.a("2833", localQQAppInterface, new agfn(), true, 0, true);
  }
  
  public aeqi a()
  {
    return new agfp();
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    agfp localagfp = (agfp)paramaeqi;
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramChatMessage;
    localMessageForTroopSign.parse();
    if (paramView == null)
    {
      paramaeqi = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562794, paramBaseChatItemLayout, false);
      localagfp.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramaeqi);
      localagfp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView = ((TroopSignVideoView)localagfp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364881));
      localagfp.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localagfp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377276));
      localagfp.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localagfp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370057));
      localagfp.b = ((TextView)localagfp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370059));
      localagfp.jdField_c_of_type_AndroidViewView = localagfp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370058);
      localagfp.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localagfp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370061));
      localagfp.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localagfp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370056));
      localagfp.jdField_d_of_type_AndroidViewView = localagfp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370060);
      localagfp.jdField_e_of_type_AndroidViewView = localagfp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369767);
      localagfp.f = localagfp.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369787);
      localagfp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFocusable(false);
      localagfp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFocusableInTouchMode(false);
      localagfp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setClickable(false);
      localagfp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFps(30);
      paramaeqi.setOnClickListener(this);
      paramaeqi.setOnLongClickListener(paramaetk);
      paramaeqi.setOnTouchListener(paramaetk);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a(new agfk(this, localagfp, paramBaseChatItemLayout));
      }
      localagfp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setOnPlayedListener(new agfl(this, localagfp));
    }
    for (;;)
    {
      boolean bool = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
      if (!bool)
      {
        localagfp.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopSign.msgContent);
        localagfp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setShowCover(true);
        paramView = localMessageForTroopSign.dynamicSource;
        if (paramView.equals(localagfp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.getTag())) {
          break label694;
        }
        localagfp.jdField_e_of_type_AndroidViewView.setVisibility(0);
        localagfp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setTag(paramView);
        localagfp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.a();
        paramaetk = ncb.a("2833") + "2833" + "/troop_sign/" + paramView + ".mp4";
        if (!new File(paramaetk).exists()) {
          break label649;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.am)) {
          break label636;
        }
        localagfp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFilePath(paramaetk);
        label479:
        localagfp.f.setVisibility(8);
        label489:
        a(localagfp.jdField_e_of_type_AndroidViewView, "2833", paramView, bool);
        label503:
        a(localagfp, localMessageForTroopSign);
        if ((AppSetting.c) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle))) {
          paramaeqi.setContentDescription("" + localMessageForTroopSign.msgTitle);
        }
        a(localagfp, paramBaseChatItemLayout);
        paramChatMessage = (FrameLayout.LayoutParams)localagfp.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams();
        if (!localMessageForTroopSign.isSend()) {
          break label751;
        }
      }
      label649:
      label694:
      label751:
      for (paramChatMessage.leftMargin = (BaseChatItemLayout.j + bdaq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));; paramChatMessage.leftMargin = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F))
      {
        localagfp.jdField_e_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
        return paramaeqi;
        localagfp.jdField_a_of_type_AndroidWidgetTextView.setText("");
        localagfp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setShowCover(false);
        break;
        label636:
        localagfp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.a(paramaetk);
        break label479;
        if (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramChatMessage))
        {
          jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, new agfm(this, paramaetk, localagfp));
          e();
        }
        localagfp.f.setVisibility(0);
        break label489;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.am))
        {
          jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopSignItemBuilder.TroopSignVideoItemBuilder.4(this, localagfp), 200L);
          break label503;
        }
        a(localagfp.jdField_e_of_type_AndroidViewView, "2833", paramView, bool);
        break label503;
      }
      paramaeqi = paramView;
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
    paramString1.setTag(bcyz.b(287, 287, bdaq.a(this.jdField_a_of_type_AndroidContentContext, 5.0F)));
    paramString1.setDecodeHandler(bcyz.i);
    paramView.setBackgroundDrawable(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agfj
 * JD-Core Version:    0.7.0.1
 */