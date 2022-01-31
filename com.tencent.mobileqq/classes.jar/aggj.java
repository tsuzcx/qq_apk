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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class aggj
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
  
  public aggj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aggk(this);
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
      int k = localResources.getDimensionPixelSize(2131297495);
      int m = localResources.getDimensionPixelSize(2131297496);
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
          azqs.b(paramQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_disobj_launch", 0, 0, "", "", "", "");
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
          azqs.b(paramQQAppInterface, "CliOper", "", "", "0X8005DC6", "0X8005DC6", 0, 0, "", "", "", "");
          return;
          label242:
          azqs.b(paramQQAppInterface, "CliOper", "", "", "0X8005925", "0X8005925", 0, 0, "", "", "", "");
        }
      }
      azqs.b(paramQQAppInterface, "CliOper", "", "", "0X80046CB", "0X80046CB", 0, 0, "", "", "", "");
      return;
    }
    boolean bool = bdjg.a("qqVideoEx", paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("MultiAVType", paramInt);
    ((Bundle)localObject).putBoolean("enableInvite", bool);
    ((Bundle)localObject).putBoolean("isVideo", paramBoolean);
    ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, true, true, null, (Bundle)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    long l1 = AudioHelper.b();
    int j = paramSessionInfo.jdField_a_of_type_Int;
    String str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    long l2 = axax.b(str);
    QLog.w("ChatItemBuilder", 1, "showGroupQavActionSheet, avType[" + paramInt + "], isVideo[" + paramBoolean + "], msgSelfUin[" + paramString1 + "], uinType[" + j + "], groupId[" + str + "], curFriendNick[" + paramSessionInfo.d + "], troopUin[" + paramSessionInfo.jdField_b_of_type_JavaLangString + "], fromWhere[" + paramString2 + "], isVideoActionSheetShown[" + mwz.a() + "], seq[" + l1 + "]");
    if (10 == paramInt)
    {
      i = 0;
      boolean bool = false;
      paramString1 = paramQQAppInterface.a().a(l2, paramInt);
      if ((paramString1 == null) || (paramString1.jdField_a_of_type_Int <= 0))
      {
        paramString1 = bdjg.a(paramQQAppInterface, str);
        bool = paramString1.getBoolean("forceDisableInviteBox");
        i = paramString1.getInt("errId", 2131696106);
      }
      if (bool) {
        bdgm.a(paramContext, 230, null, paramContext.getResources().getString(i), 2131695894, 2131721336, new aggl(), null).show();
      }
    }
    while (paramQQAppInterface.a().a(paramContext, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramBoolean)) {
      return;
    }
    if (AudioHelper.a(19) == 1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        AudioHelper.a(alud.a(2131716688));
      }
      if ((!paramQQAppInterface.a().a(l1, str)) && (i == 0)) {
        break;
      }
      paramSessionInfo = new Bundle();
      paramSessionInfo.putInt("MultiAVType", mww.a(j));
      if (paramBoolean) {
        paramSessionInfo.putBoolean("isVideo", true);
      }
      if (j == 1) {
        paramSessionInfo.putBoolean("enableInvite", bdjg.a("showGroupQavActionSheet", paramQQAppInterface, str));
      }
      paramSessionInfo.putString("Fromwhere", paramString2);
      ChatActivityUtils.a(paramQQAppInterface, paramContext, j, str, true, true, null, paramSessionInfo);
      return;
    }
    paramString1 = paramQQAppInterface.a().a(axax.b(str));
    if ((paramString1 == null) || (paramString1.jdField_b_of_type_Int != paramInt))
    {
      VideoMsgTools.a(paramQQAppInterface, paramContext, j, str, paramSessionInfo.d, paramBoolean, paramString2);
      return;
    }
    if ((paramString1 != null) && (paramString1.jdField_b_of_type_Int == 2) && (paramString1.d == 2) && (paramString1.jdField_e_of_type_Int == 4)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      VideoStatusTipsBar.a(paramQQAppInterface, paramContext, j, str, paramInt, paramBoolean, paramString2);
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageForVideo paramMessageForVideo)
  {
    if ((!lnz.c()) || (!lnz.d()) || (mwz.a())) {
      return;
    }
    if (paramMessageForVideo.type == 13) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label83;
      }
      i = paramMessageForVideo.istroop;
      if ((i != 1) && (i != 3000)) {
        break;
      }
      a(paramQQAppInterface, paramContext, paramSessionInfo, paramMessageForVideo.extInt, paramMessageForVideo.isVideo, paramMessageForVideo.selfuin, "");
      return;
    }
    label83:
    b(paramQQAppInterface, paramSessionInfo, paramMessageForVideo.isVideo, paramMessageForVideo.type);
    if (paramMessageForVideo.isVideo)
    {
      azqs.b(paramQQAppInterface, "CliOper", "", "", "0X8005642", "0X8005642", 0, 0, "", "", "", "");
      return;
    }
    azqs.b(paramQQAppInterface, "CliOper", "", "", "0X8005243", "0X8005243", 0, 0, "", "", "", "");
  }
  
  static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForVideo paramMessageForVideo, SessionInfo paramSessionInfo)
  {
    aepi.n = true;
    if ((lnz.c()) && (lnz.d()))
    {
      a(paramQQAppInterface, paramMessageForVideo, paramSessionInfo);
      if ((paramSessionInfo.jdField_a_of_type_Int != 1) || (paramMessageForVideo.extInt == 10)) {}
    }
    else
    {
      try
      {
        l = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
        int i = mww.b(paramSessionInfo.jdField_a_of_type_Int);
        l = paramQQAppInterface.a().a(i, l);
        Object localObject = (bcnu)paramQQAppInterface.getManager(48);
        boolean bool1 = ((bcnu)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.getCurrentAccountUin());
        boolean bool2 = ((bcnu)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
        boolean bool3 = ((bcnu)localObject).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
        localObject = ((bcnu)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
        if ((l == 0L) && (((!bool3) && (bool1)) || ((!bool2) && (localObject != null) && (((bcob)localObject).a > 0L))))
        {
          QQToast.a(paramQQAppInterface.getApp(), alud.a(2131716687), 0).b(paramQQAppInterface.getApp().getResources().getDimensionPixelSize(2131298914));
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
        azqs.b(paramQQAppInterface, "CliOper", "", "", str1, str2, 0, 0, paramSessionInfo, "", "", "");
        if (paramInt == 2) {
          azqs.b(paramQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "2", "", "", "");
        }
        break;
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label238;
      }
      azqs.b(paramQQAppInterface, "CliOper", "", "", "0X8005643", "0X8005643", 0, 0, "", "", "", "");
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
        azqs.b(paramQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "2", "", "", "");
      }
    }
    label238:
    azqs.b(paramQQAppInterface, "CliOper", "", "", "0X8005244", "0X8005244", 0, 0, "", "", "", "");
  }
  
  static void a(QQAppInterface paramQQAppInterface, MessageForVideo paramMessageForVideo, SessionInfo paramSessionInfo)
  {
    int i = paramMessageForVideo.istroop;
    if (paramMessageForVideo.type == 13)
    {
      if (i != 3000) {
        break label123;
      }
      azqs.b(paramQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_disobj", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if ((paramMessageForVideo.type == 2) || (paramMessageForVideo.type == 24)) {
        azqs.b(paramQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "1", "", "", "");
      }
      if (paramMessageForVideo.type == 0) {
        azqs.b(paramQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "1", "", "", "");
      }
      return;
      label123:
      if (i == 1) {
        if (paramMessageForVideo.extInt == 10) {
          azqs.b(paramQQAppInterface, "CliOper", "", "", "0X8005924", "0X8005924", 0, 0, "", "", "", "");
        } else {
          azqs.b(null, "dc00899", "Grp_video", "", "notice", "video", 0, 0, paramSessionInfo.jdField_a_of_type_JavaLangString, "" + bcpx.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString), "0", "");
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
        localObject1 = alud.a(2131716681);
      }
      localObject2 = localObject1;
      if (paramMessageForVideo.msgtype == -2009)
      {
        localObject1 = new StringBuilder().append((String)localObject1);
        localObject2 = paramView.getResources();
        if (!paramMessageForVideo.isVideo) {
          break label516;
        }
        i = 2131720933;
        localObject2 = ((Resources)localObject2).getString(i);
      }
      localObject1 = (String)localObject2 + paramMessageForVideo.text;
      if (!paramMessageForVideo.text.contains(paramContext.getResources().getString(2131721333))) {
        break label569;
      }
      localObject2 = paramMessageForVideo.text;
      paramContext = paramContext.getResources().getString(2131721333) + ",";
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
      for (localObject1 = paramContext + k + alud.a(2131716683);; localObject1 = paramContext)
      {
        paramContext = (Context)localObject1;
        if (j > 0) {
          paramContext = (String)localObject1 + j + alud.a(2131716685);
        }
        localObject1 = paramContext;
        if (i > 0) {
          localObject1 = paramContext + i + alud.a(2131716684);
        }
        paramContext = paramView.getResources();
        if (paramMessageForVideo.isVideo)
        {
          i = 2131720933;
          paramMessageForVideo = paramContext.getString(i);
          localObject1 = paramMessageForVideo + (String)localObject1;
        }
        for (;;)
        {
          paramView.setContentDescription(((String)localObject1).replace(alud.a(2131716689), alud.a(2131716680)));
          return;
          localObject1 = bdgc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForVideo.senderuin, 0);
          break;
          i = 2131720911;
          break label135;
          if (localObject2.length != 2) {
            break label771;
          }
          j = Integer.valueOf(localObject2[0]).intValue();
          i = Integer.valueOf(localObject2[1]).intValue();
          k = 0;
          break label306;
          i = 2131720911;
          break label449;
          if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131721322)))
          {
            paramContext = paramContext.getResources();
            if (paramMessageForVideo.isVideo) {}
            for (i = 2131721339;; i = 2131690320)
            {
              localObject1 = paramContext.getString(i);
              break;
            }
          }
          if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131696421))) {
            localObject1 = paramContext.getResources().getString(2131719745);
          } else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131696420))) {
            localObject1 = paramContext.getResources().getString(2131719240);
          } else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131695851))) {
            localObject1 = paramContext.getResources().getString(2131719745);
          } else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131695850))) {
            localObject1 = paramContext.getResources().getString(2131719240);
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
  
  public aeqi a()
  {
    return new aggm(this);
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    aggm localaggm = (aggm)paramaeqi;
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramaeqi = paramView;
    if (paramView == null)
    {
      paramaeqi = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramaeqi.setId(2131364176);
      paramaeqi.setTextColor(localResources.getColorStateList(2131166921));
      paramaeqi.setTextSize(localResources.getDimensionPixelOffset(2131296368));
      paramaeqi.setGravity(16);
      localaggm.a = paramaeqi;
    }
    paramView = (MessageForVideo)paramChatMessage;
    int i = VideoMsgTools.a(paramBaseChatItemLayout, paramView.type, paramView.text, paramView.isVideo, paramChatMessage.isSendFromLocal());
    a(localaggm.a, i);
    i = VideoMsgTools.a(paramBaseChatItemLayout, paramView.type, paramView.text, paramChatMessage.isSendFromLocal());
    localaggm.a.setTextColor(localResources.getColor(i));
    localaggm.a.setText(paramView.text);
    if ((paramView.istroop == 1) && (this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696050).equals(paramView.text))) {
      azqs.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, paramView.frienduin, "" + bcpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.frienduin), "", "");
    }
    paramaeqi.setOnTouchListener(paramaetk);
    paramaeqi.setOnLongClickListener(paramaetk);
    paramaeqi.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (jdField_e_of_type_Boolean) {
      a(paramView, paramBaseChatItemLayout, paramaeqi);
    }
    return paramaeqi;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return alud.a(2131716686);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131365071)
    {
      acjm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    if (paramInt == 2131370861)
    {
      super.d(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(aeqi paramaeqi, View paramView, ChatMessage paramChatMessage, anwo paramanwo)
  {
    aggm localaggm = (aggm)paramaeqi;
    localaggm.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
    if ((paramanwo.jdField_a_of_type_Int == 0) || (!paramanwo.a()))
    {
      paramView = paramView.getResources();
      if (localaggm.a.getText().toString().contains(this.jdField_a_of_type_AndroidContentContext.getString(2131721319)))
      {
        paramaeqi = paramView.getColorStateList(2131165867);
        localaggm.a.setTextColor(paramaeqi);
        return;
      }
      if (paramChatMessage.isSend())
      {
        paramaeqi = paramView.getColorStateList(2131166925);
        localaggm.a.setTextColor(paramaeqi);
        if (!paramChatMessage.isSend()) {
          break label151;
        }
      }
      label151:
      for (paramaeqi = paramView.getColorStateList(2131166924);; paramaeqi = paramView.getColorStateList(2131166923))
      {
        localaggm.a.setLinkTextColor(paramaeqi);
        return;
        paramaeqi = paramView.getColorStateList(2131166921);
        break;
      }
    }
    if (paramanwo.jdField_b_of_type_Int == 0) {
      localaggm.a.setTextColor(-16777216);
    }
    while (paramanwo.c == 0)
    {
      localaggm.a.setLinkTextColor(paramView.getResources().getColorStateList(2131166923));
      return;
      localaggm.a.setTextColor(paramanwo.jdField_b_of_type_Int);
    }
    localaggm.a.setLinkTextColor(paramanwo.c);
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
  
  public bdpk[] a(View paramView)
  {
    bdpi localbdpi = new bdpi();
    aepi.a(paramView);
    acjm.a(localbdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.c(localbdpi, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbdpi, this.jdField_a_of_type_AndroidContentContext);
    return localbdpi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aggj
 * JD-Core Version:    0.7.0.1
 */