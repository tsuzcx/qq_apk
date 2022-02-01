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
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignVideoItemBuilder.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.troop.widget.TroopSignVideoView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;

public class agsw
  extends agss
{
  protected static HashMap<ChatMessage, agtb> a;
  protected static long c;
  public TroopChatPie a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
  }
  
  public agsw(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, TroopChatPie paramTroopChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
  }
  
  public static void e()
  {
    if (System.currentTimeMillis() - c < 600000L) {
      return;
    }
    c = System.currentTimeMillis();
    nny.a();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = nny.a("2833");
    if (QLog.isColorLevel()) {
      QLog.d("TroopSignItemBuilder", 2, "checkOffline version = " + str);
    }
    nny.a("2833", localQQAppInterface, new agta(), true, 0, true);
  }
  
  public aezf a()
  {
    return new agtc();
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    agtc localagtc = (agtc)paramaezf;
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramChatMessage;
    localMessageForTroopSign.parse();
    if (paramView == null)
    {
      paramaezf = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562949, paramBaseChatItemLayout, false);
      localagtc.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramaezf);
      localagtc.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView = ((TroopSignVideoView)localagtc.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365187));
      localagtc.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localagtc.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378011));
      localagtc.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localagtc.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370570));
      localagtc.b = ((TextView)localagtc.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370572));
      localagtc.jdField_c_of_type_AndroidViewView = localagtc.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370571);
      localagtc.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localagtc.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370574));
      localagtc.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localagtc.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370569));
      localagtc.jdField_d_of_type_AndroidViewView = localagtc.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370573);
      localagtc.jdField_e_of_type_AndroidViewView = localagtc.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370267);
      localagtc.f = localagtc.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370292);
      localagtc.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFocusable(false);
      localagtc.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFocusableInTouchMode(false);
      localagtc.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setClickable(false);
      localagtc.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFps(30);
      paramaezf.setOnClickListener(this);
      paramaezf.setOnLongClickListener(paramafce);
      paramaezf.setOnTouchListener(paramafce);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(new agsx(this, localagtc, paramBaseChatItemLayout));
      }
      localagtc.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setOnPlayedListener(new agsy(this, localagtc));
    }
    for (;;)
    {
      boolean bool = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
      if (!bool)
      {
        localagtc.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopSign.msgContent);
        localagtc.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setShowCover(true);
        paramView = localMessageForTroopSign.dynamicSource;
        if (paramView.equals(localagtc.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.getTag())) {
          break label694;
        }
        localagtc.jdField_e_of_type_AndroidViewView.setVisibility(0);
        localagtc.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setTag(paramView);
        localagtc.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.a();
        paramafce = noe.a("2833") + "2833" + "/troop_sign/" + paramView + ".mp4";
        if (!new File(paramafce).exists()) {
          break label649;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.u)) {
          break label636;
        }
        localagtc.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFilePath(paramafce);
        label479:
        localagtc.f.setVisibility(8);
        label489:
        a(localagtc.jdField_e_of_type_AndroidViewView, "2833", paramView, bool);
        label503:
        a(localagtc, localMessageForTroopSign);
        if ((AppSetting.c) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle))) {
          paramaezf.setContentDescription("" + localMessageForTroopSign.msgTitle);
        }
        a(localagtc, paramBaseChatItemLayout);
        paramChatMessage = (FrameLayout.LayoutParams)localagtc.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams();
        if (!localMessageForTroopSign.isSend()) {
          break label751;
        }
      }
      label649:
      label694:
      label751:
      for (paramChatMessage.leftMargin = (BaseChatItemLayout.k + DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F));; paramChatMessage.leftMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F))
      {
        localagtc.jdField_e_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
        return paramaezf;
        localagtc.jdField_a_of_type_AndroidWidgetTextView.setText("");
        localagtc.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setShowCover(false);
        break;
        label636:
        localagtc.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.a(paramafce);
        break label479;
        if (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramChatMessage))
        {
          jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, new agsz(this, paramafce, localagtc));
          e();
        }
        localagtc.f.setVisibility(0);
        break label489;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.u))
        {
          jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopSignItemBuilder.TroopSignVideoItemBuilder.4(this, localagtc), 200L);
          break label503;
        }
        a(localagtc.jdField_e_of_type_AndroidViewView, "2833", paramView, bool);
        break label503;
      }
      paramaezf = paramView;
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
    paramString2 = new StringBuilder().append(noe.a(paramString1)).append(paramString1).append("/troop_sign/").append(paramString2);
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
    paramString1.setTag(bfol.b(287, 287, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 5.0F)));
    paramString1.setDecodeHandler(bfol.j);
    paramView.setBackgroundDrawable(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agsw
 * JD-Core Version:    0.7.0.1
 */