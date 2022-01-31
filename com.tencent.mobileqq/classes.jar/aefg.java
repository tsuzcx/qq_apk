import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class aefg
  extends BaseBubbleBuilder
{
  private static final int c = BaseChatItemLayout.g + BaseChatItemLayout.l;
  private static final int d = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int e;
  private static final int jdField_f_of_type_Int = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private View.OnClickListener a;
  private boolean jdField_f_of_type_Boolean = true;
  
  static
  {
    jdField_e_of_type_Int = BaseChatItemLayout.i + BaseChatItemLayout.n;
  }
  
  public aefg(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aefh(this);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    Drawable localDrawable = localResources.getDrawable(paramInt);
    int i = localDrawable.getIntrinsicWidth();
    int j = localDrawable.getIntrinsicHeight();
    switch (this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0))
    {
    default: 
      paramInt = j;
    }
    for (;;)
    {
      localDrawable.setBounds(0, 0, i, paramInt);
      paramTextView.setCompoundDrawables(localDrawable, null, null, null);
      paramTextView.setCompoundDrawablePadding(BaseChatItemLayout.q);
      return;
      int k = localResources.getDimensionPixelSize(2131297476);
      int m = localResources.getDimensionPixelSize(2131297477);
      paramInt = k;
      if (k == 0) {
        paramInt = 1;
      }
      i = i * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int / paramInt;
      paramInt = j * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int / paramInt + m;
      i += m;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt, boolean paramBoolean)
  {
    QLog.w("ChatItemBuilder", 1, "qqVideo_group, avType[" + paramInt + "], isVideo[" + paramBoolean + "]");
    if (paramInt == 2)
    {
      localObject = new HashMap();
      ((Map)localObject).put("MultiAVType", String.valueOf(paramInt));
      ((Map)localObject).put("from", "itemBuilder");
      ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, (Map)localObject);
      long l = Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue();
      if (paramSessionInfo.jdField_a_of_type_Int == 3000) {
        if (paramQQAppInterface.a().b() != l) {
          axqy.b(paramQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_disobj_launch", 0, 0, "", "", "", "");
        }
      }
      while ((paramSessionInfo.jdField_a_of_type_Int != 1) || (paramQQAppInterface.a().b(1, l))) {
        return;
      }
      if (paramInt == 10)
      {
        if (paramQQAppInterface.a().b() == 0L)
        {
          paramContext = paramQQAppInterface.a().a(l, 10);
          if ((paramContext == null) || (paramContext.jdField_a_of_type_Int <= 0)) {
            break label242;
          }
        }
        for (;;)
        {
          axqy.b(paramQQAppInterface, "CliOper", "", "", "0X8005DC6", "0X8005DC6", 0, 0, "", "", "", "");
          return;
          label242:
          axqy.b(paramQQAppInterface, "CliOper", "", "", "0X8005925", "0X8005925", 0, 0, "", "", "", "");
        }
      }
      axqy.b(paramQQAppInterface, "CliOper", "", "", "0X80046CB", "0X80046CB", 0, 0, "", "", "", "");
      return;
    }
    boolean bool = bbgb.a("qqVideoEx", paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("MultiAVType", paramInt);
    ((Bundle)localObject).putBoolean("enableInvite", bool);
    ((Bundle)localObject).putBoolean("isVideo", paramBoolean);
    ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, true, true, null, (Bundle)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt, boolean paramBoolean, String paramString)
  {
    long l1 = AudioHelper.b();
    int j = paramSessionInfo.jdField_a_of_type_Int;
    String str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    long l2 = avfb.b(str);
    QLog.w("ChatItemBuilder", 1, "showGroupQavActionSheet, avType[" + paramInt + "], isVideo[" + paramBoolean + "], msgSelfUin[" + paramString + "], uinType[" + j + "], groupId[" + str + "], curFriendNick[" + paramSessionInfo.d + "], troopUin[" + paramSessionInfo.jdField_b_of_type_JavaLangString + "], isVideoActionSheetShown[" + muf.a() + "], seq[" + l1 + "]");
    if (10 == paramInt)
    {
      i = 0;
      boolean bool = false;
      paramString = paramQQAppInterface.a().a(l2, paramInt);
      if ((paramString == null) || (paramString.jdField_a_of_type_Int <= 0))
      {
        paramString = bbgb.a(paramQQAppInterface, str);
        bool = paramString.getBoolean("forceDisableInviteBox");
        i = paramString.getInt("errId", 2131695943);
      }
      if (bool) {
        bbdj.a(paramContext, 230, null, paramContext.getResources().getString(i), 2131695732, 2131720783, new aefi(), null).show();
      }
    }
    while (paramQQAppInterface.a().a(paramContext, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramBoolean)) {
      return;
    }
    if (AudioHelper.a(19) == 1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        AudioHelper.a(ajya.a(2131716304));
      }
      if ((!paramQQAppInterface.a().a(l1, str)) && (i == 0)) {
        break;
      }
      paramSessionInfo = new Bundle();
      paramSessionInfo.putInt("MultiAVType", muc.a(j));
      if (paramBoolean) {
        paramSessionInfo.putBoolean("isVideo", true);
      }
      if (j == 1) {
        paramSessionInfo.putBoolean("enableInvite", bbgb.a("showGroupQavActionSheet", paramQQAppInterface, str));
      }
      ChatActivityUtils.a(paramQQAppInterface, paramContext, j, str, true, true, null, paramSessionInfo);
      return;
    }
    paramString = paramQQAppInterface.a().a(avfb.b(str));
    if ((paramString == null) || (paramString.jdField_b_of_type_Int != paramInt))
    {
      VideoMsgTools.a(paramQQAppInterface, paramContext, j, str, paramSessionInfo.d, paramBoolean);
      return;
    }
    if ((paramString != null) && (paramString.jdField_b_of_type_Int == 2) && (paramString.c == 2) && (paramString.d == 4)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      VideoStatusTipsBar.a(paramQQAppInterface, paramContext, j, str, paramInt, paramBoolean);
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageForVideo paramMessageForVideo)
  {
    if ((!llw.c()) || (!llw.d()) || (muf.a())) {
      return;
    }
    if (paramMessageForVideo.type == 13) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label81;
      }
      i = paramMessageForVideo.istroop;
      if ((i != 1) && (i != 3000)) {
        break;
      }
      a(paramQQAppInterface, paramContext, paramSessionInfo, paramMessageForVideo.extInt, paramMessageForVideo.isVideo, paramMessageForVideo.selfuin);
      return;
    }
    label81:
    b(paramQQAppInterface, paramSessionInfo, paramMessageForVideo.isVideo, paramMessageForVideo.type);
    if (paramMessageForVideo.isVideo)
    {
      axqy.b(paramQQAppInterface, "CliOper", "", "", "0X8005642", "0X8005642", 0, 0, "", "", "", "");
      return;
    }
    axqy.b(paramQQAppInterface, "CliOper", "", "", "0X8005243", "0X8005243", 0, 0, "", "", "", "");
  }
  
  static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForVideo paramMessageForVideo, SessionInfo paramSessionInfo)
  {
    actj.n = true;
    if ((llw.c()) && (llw.d()))
    {
      a(paramQQAppInterface, paramMessageForVideo, paramSessionInfo);
      if ((paramSessionInfo.jdField_a_of_type_Int != 1) || (paramMessageForVideo.extInt == 10)) {}
    }
    else
    {
      try
      {
        l = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
        int i = muc.b(paramSessionInfo.jdField_a_of_type_Int);
        l = paramQQAppInterface.a().a(i, l);
        Object localObject = (baky)paramQQAppInterface.getManager(48);
        boolean bool1 = ((baky)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.getCurrentAccountUin());
        boolean bool2 = ((baky)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
        boolean bool3 = ((baky)localObject).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
        localObject = ((baky)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
        if ((l == 0L) && (((!bool3) && (bool1)) || ((!bool2) && (localObject != null) && (((balf)localObject).a > 0L))))
        {
          bcql.a(paramQQAppInterface.getApp(), ajya.a(2131716303), 0).b(paramQQAppInterface.getApp().getResources().getDimensionPixelSize(2131298865));
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          long l = 0L;
        }
        a(paramQQAppInterface, paramContext, paramSessionInfo, paramMessageForVideo.extInt, paramMessageForVideo.isVideo);
        return;
      }
    }
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramMessageForVideo);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean, int paramInt)
  {
    String str1;
    String str2;
    if (!paramBoolean)
    {
      str1 = "Two_call";
      str2 = "Two_call_launch";
      switch (paramSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        paramSessionInfo = "0";
        label72:
        axqy.b(paramQQAppInterface, "CliOper", "", "", str1, str2, 0, 0, paramSessionInfo, "", "", "");
        if (paramInt == 2) {
          axqy.b(paramQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "2", "", "", "");
        }
        break;
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label238;
      }
      axqy.b(paramQQAppInterface, "CliOper", "", "", "0X8005643", "0X8005643", 0, 0, "", "", "", "");
      return;
      str1 = "Two_video_call";
      str2 = "Two_video_call_launch";
      break;
      paramSessionInfo = "0";
      break label72;
      paramSessionInfo = "1";
      break label72;
      paramSessionInfo = "2";
      break label72;
      paramSessionInfo = "3";
      break label72;
      paramSessionInfo = "4";
      break label72;
      if (paramInt == 0) {
        axqy.b(paramQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "2", "", "", "");
      }
    }
    label238:
    axqy.b(paramQQAppInterface, "CliOper", "", "", "0X8005244", "0X8005244", 0, 0, "", "", "", "");
  }
  
  static void a(QQAppInterface paramQQAppInterface, MessageForVideo paramMessageForVideo, SessionInfo paramSessionInfo)
  {
    int i = paramMessageForVideo.istroop;
    if (paramMessageForVideo.type == 13)
    {
      if (i != 3000) {
        break label123;
      }
      axqy.b(paramQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_disobj", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if ((paramMessageForVideo.type == 2) || (paramMessageForVideo.type == 24)) {
        axqy.b(paramQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "1", "", "", "");
      }
      if (paramMessageForVideo.type == 0) {
        axqy.b(paramQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "1", "", "", "");
      }
      return;
      label123:
      if (i == 1) {
        if (paramMessageForVideo.extInt == 10) {
          axqy.b(paramQQAppInterface, "CliOper", "", "", "0X8005924", "0X8005924", 0, 0, "", "", "", "");
        } else {
          axqy.b(null, "dc00899", "Grp_video", "", "notice", "video", 0, 0, paramSessionInfo.jdField_a_of_type_JavaLangString, "" + banb.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString), "0", "");
        }
      }
    }
  }
  
  private void a(MessageForVideo paramMessageForVideo, Context paramContext, View paramView)
  {
    int j = 0;
    Object localObject1 = "";
    if (paramMessageForVideo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "setMsgAccDescription-->message is null");
      }
    }
    do
    {
      return;
      if ((paramMessageForVideo.senderuin != null) && (paramMessageForVideo.selfuin != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ChatItemBuilder", 2, "setMsgAccDescription-->uin is null");
    return;
    Object localObject2;
    int i;
    label135:
    int k;
    if (paramMessageForVideo.selfuin.equals(paramMessageForVideo.senderuin))
    {
      if (-2016 == paramMessageForVideo.msgtype) {
        localObject1 = ajya.a(2131716297);
      }
      localObject2 = localObject1;
      if (paramMessageForVideo.msgtype == -2009)
      {
        localObject1 = new StringBuilder().append((String)localObject1);
        localObject2 = paramView.getResources();
        if (!paramMessageForVideo.isVideo) {
          break label516;
        }
        i = 2131720385;
        localObject2 = ((Resources)localObject2).getString(i);
      }
      localObject1 = (String)localObject2 + paramMessageForVideo.text;
      if (!paramMessageForVideo.text.contains(paramContext.getResources().getString(2131720780))) {
        break label569;
      }
      localObject2 = paramMessageForVideo.text;
      paramContext = paramContext.getResources().getString(2131720780) + ",";
      localObject2 = ((String)localObject2).substring(((String)localObject2).indexOf(':') - 2, ((String)localObject2).lastIndexOf(':') + 3).split(":");
      if (localObject2.length != 3) {
        break label524;
      }
      k = Integer.valueOf(localObject2[0]).intValue();
      j = Integer.valueOf(localObject2[1]).intValue();
      i = Integer.valueOf(localObject2[2]).intValue();
    }
    for (;;)
    {
      label306:
      if ((k > 0) || (j > 0) || (i > 0)) {
        if (k <= 0) {
          break label765;
        }
      }
      label449:
      label765:
      for (localObject1 = paramContext + k + ajya.a(2131716299);; localObject1 = paramContext)
      {
        paramContext = (Context)localObject1;
        if (j > 0) {
          paramContext = (String)localObject1 + j + ajya.a(2131716301);
        }
        localObject1 = paramContext;
        if (i > 0) {
          localObject1 = paramContext + i + ajya.a(2131716300);
        }
        paramContext = paramView.getResources();
        if (paramMessageForVideo.isVideo)
        {
          i = 2131720385;
          paramMessageForVideo = paramContext.getString(i);
          localObject1 = paramMessageForVideo + (String)localObject1;
        }
        for (;;)
        {
          paramView.setContentDescription(((String)localObject1).replace(ajya.a(2131716305), ajya.a(2131716296)));
          return;
          localObject1 = bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForVideo.senderuin, 0);
          break;
          i = 2131720363;
          break label135;
          if (localObject2.length != 2) {
            break label771;
          }
          j = Integer.valueOf(localObject2[0]).intValue();
          i = Integer.valueOf(localObject2[1]).intValue();
          k = 0;
          break label306;
          i = 2131720363;
          break label449;
          if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131720769)))
          {
            paramContext = paramContext.getResources();
            if (paramMessageForVideo.isVideo) {}
            for (i = 2131720786;; i = 2131690269)
            {
              localObject1 = paramContext.getString(i);
              break;
            }
          }
          if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131696247))) {
            localObject1 = paramContext.getResources().getString(2131719252);
          } else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131696246))) {
            localObject1 = paramContext.getResources().getString(2131718755);
          } else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131695689))) {
            localObject1 = paramContext.getResources().getString(2131719252);
          } else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131695688))) {
            localObject1 = paramContext.getResources().getString(2131718755);
          }
        }
      }
      label516:
      label524:
      label569:
      i = 0;
      label771:
      k = 0;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean, int paramInt)
  {
    QLog.w("ChatItemBuilder", 1, "qqVideoEx, isVideo[" + paramBoolean + "], closeType[" + paramInt + "]");
    a(paramQQAppInterface, paramSessionInfo, paramBoolean, paramInt);
    paramInt = paramSessionInfo.jdField_a_of_type_Int;
    String str3 = paramSessionInfo.d;
    String str2;
    String str1;
    BaseApplication localBaseApplication;
    if (paramInt == 1006)
    {
      str2 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      str1 = null;
      localBaseApplication = paramQQAppInterface.getApp();
      if (paramBoolean) {
        break label125;
      }
    }
    label125:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ChatActivityUtils.a(paramQQAppInterface, localBaseApplication, paramInt, str1, str3, str2, paramBoolean, paramSessionInfo.jdField_b_of_type_JavaLangString, true, true, null, "from_internal");
      return;
      str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      str2 = null;
      break;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public acuj a()
  {
    return new aefj(this);
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    aefj localaefj = (aefj)paramacuj;
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramacuj = paramView;
    if (paramView == null)
    {
      paramacuj = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramacuj.setId(2131364112);
      paramacuj.setTextColor(localResources.getColorStateList(2131166872));
      paramacuj.setTextSize(localResources.getDimensionPixelOffset(2131296362));
      paramacuj.setGravity(16);
      localaefj.a = paramacuj;
    }
    paramView = (MessageForVideo)paramChatMessage;
    int i = VideoMsgTools.a(paramBaseChatItemLayout, paramView.type, paramView.text, paramView.isVideo, paramChatMessage.isSendFromLocal());
    a(localaefj.a, i);
    i = VideoMsgTools.a(paramBaseChatItemLayout, paramView.type, paramView.text, paramChatMessage.isSendFromLocal());
    localaefj.a.setTextColor(localResources.getColor(i));
    localaefj.a.setText(paramView.text);
    if ((paramView.istroop == 1) && (this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695887).equals(paramView.text))) {
      axqy.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, paramView.frienduin, "" + banb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.frienduin), "", "");
    }
    paramacuj.setOnTouchListener(paramacxj);
    paramacuj.setOnLongClickListener(paramacxj);
    paramacuj.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (jdField_e_of_type_Boolean) {
      a(paramView, paramBaseChatItemLayout, paramacuj);
    }
    return paramacuj;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ajya.a(2131716302);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131364984)
    {
      aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    if (paramInt == 2131370536)
    {
      super.d(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(acuj paramacuj, View paramView, ChatMessage paramChatMessage, ambg paramambg)
  {
    aefj localaefj = (aefj)paramacuj;
    localaefj.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
    if ((paramambg.jdField_a_of_type_Int == 0) || (!paramambg.a()))
    {
      paramView = paramView.getResources();
      if (localaefj.a.getText().toString().contains(this.jdField_a_of_type_AndroidContentContext.getString(2131720766)))
      {
        paramacuj = paramView.getColorStateList(2131165829);
        localaefj.a.setTextColor(paramacuj);
        return;
      }
      if (paramChatMessage.isSend())
      {
        paramacuj = paramView.getColorStateList(2131166876);
        localaefj.a.setTextColor(paramacuj);
        if (!paramChatMessage.isSend()) {
          break label151;
        }
      }
      label151:
      for (paramacuj = paramView.getColorStateList(2131166875);; paramacuj = paramView.getColorStateList(2131166874))
      {
        localaefj.a.setLinkTextColor(paramacuj);
        return;
        paramacuj = paramView.getColorStateList(2131166872);
        break;
      }
    }
    if (paramambg.jdField_b_of_type_Int == 0) {
      localaefj.a.setTextColor(-16777216);
    }
    while (paramambg.c == 0)
    {
      localaefj.a.setLinkTextColor(paramView.getResources().getColorStateList(2131166874));
      return;
      localaefj.a.setTextColor(paramambg.jdField_b_of_type_Int);
    }
    localaefj.a.setLinkTextColor(paramambg.c);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(jdField_f_of_type_Int, c, jdField_e_of_type_Int, d);
      return;
    }
    paramView.setPadding(jdField_e_of_type_Int, c, jdField_f_of_type_Int, d);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    actj.a(paramView);
    aanz.a(localbbmf, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.c(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    return localbbmf.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aefg
 * JD-Core Version:    0.7.0.1
 */