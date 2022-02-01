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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.pluspanel.appinfo.GroupVideoChatAppInfo;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class agtw
  extends BaseBubbleBuilder
{
  private static final int c = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int e;
  private static final int jdField_f_of_type_Int = BaseChatItemLayout.k + BaseChatItemLayout.p;
  private View.OnClickListener a;
  private boolean jdField_f_of_type_Boolean = true;
  
  static
  {
    jdField_e_of_type_Int = BaseChatItemLayout.j + BaseChatItemLayout.o;
  }
  
  public agtw(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new agtx(this);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    if (paramInt <= 0)
    {
      paramTextView.setCompoundDrawables(null, null, null, null);
      return;
    }
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
      paramTextView.setCompoundDrawablePadding(BaseChatItemLayout.r);
      return;
      int k = localResources.getDimensionPixelSize(2131297641);
      int m = localResources.getDimensionPixelSize(2131297642);
      paramInt = k;
      if (k == 0) {
        paramInt = 1;
      }
      i = i * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem / paramInt;
      paramInt = j * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem / paramInt + m;
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
      GroupVideoChatAppInfo.startGroupVideoOrVoice(paramQQAppInterface, paramContext, paramSessionInfo.curType, paramSessionInfo.curFriendUin, (Map)localObject);
      long l = Long.valueOf(paramSessionInfo.curFriendUin).longValue();
      if (paramSessionInfo.curType == 3000) {
        if (paramQQAppInterface.getAVNotifyCenter().b() != l) {
          bcef.b(paramQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_disobj_launch", 0, 0, "", "", "", "");
        }
      }
      while ((paramSessionInfo.curType != 1) || (paramQQAppInterface.getAVNotifyCenter().b(1, l))) {
        return;
      }
      if (paramInt == 10)
      {
        if (paramQQAppInterface.getAVNotifyCenter().b() == 0L)
        {
          paramContext = paramQQAppInterface.getAVNotifyCenter().a(l, 10);
          if ((paramContext == null) || (paramContext.a <= 0)) {
            break label242;
          }
        }
        for (;;)
        {
          bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8005DC6", "0X8005DC6", 0, 0, "", "", "", "");
          return;
          label242:
          bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8005925", "0X8005925", 0, 0, "", "", "", "");
        }
      }
      bcef.b(paramQQAppInterface, "CliOper", "", "", "0X80046CB", "0X80046CB", 0, 0, "", "", "", "");
      return;
    }
    boolean bool = bfxg.a("qqVideoEx", paramQQAppInterface, paramSessionInfo.curFriendUin);
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("MultiAVType", paramInt);
    ((Bundle)localObject).putBoolean("enableInvite", bool);
    ((Bundle)localObject).putBoolean("isVideo", paramBoolean);
    ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.curType, paramSessionInfo.curFriendUin, true, true, null, (Bundle)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    long l1 = AudioHelper.b();
    int j = paramSessionInfo.curType;
    String str = paramSessionInfo.curFriendUin;
    long l2 = azjk.b(str);
    QLog.w("ChatItemBuilder", 1, "showGroupQavActionSheet, avType[" + paramInt + "], isVideo[" + paramBoolean + "], msgSelfUin[" + paramString1 + "], uinType[" + j + "], groupId[" + str + "], curFriendNick[" + paramSessionInfo.curFriendNick + "], troopUin[" + paramSessionInfo.troopUin + "], fromWhere[" + paramString2 + "], isVideoActionSheetShown[" + mup.a() + "], seq[" + l1 + "]");
    if (10 == paramInt)
    {
      i = 0;
      boolean bool = false;
      paramString1 = paramQQAppInterface.getAVNotifyCenter().a(l2, paramInt);
      if ((paramString1 == null) || (paramString1.a <= 0))
      {
        paramString1 = bfxg.a(paramQQAppInterface, str);
        bool = paramString1.getBoolean("forceDisableInviteBox");
        i = paramString1.getInt("errId", 2131695167);
      }
      if (bool)
      {
        bfur.a(paramContext, 230, null, paramContext.getResources().getString(i), 2131694952, 2131719509, new agty(), null).show();
        return;
      }
    }
    if (paramBoolean)
    {
      i = 2;
      label274:
      if ((paramQQAppInterface.getAVNotifyCenter().a(paramContext, i, paramSessionInfo.curType, paramSessionInfo.curFriendUin)) || (paramQQAppInterface.getAVNotifyCenter().a(paramContext, paramSessionInfo.curType, paramSessionInfo.curFriendUin, paramBoolean))) {
        break label443;
      }
      if (AudioHelper.a(19) != 1) {
        break label445;
      }
    }
    label443:
    label445:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        AudioHelper.a(amtj.a(2131715308));
      }
      if ((!paramQQAppInterface.getAVNotifyCenter().a(l1, str)) && (i == 0)) {
        break label451;
      }
      paramSessionInfo = new Bundle();
      paramSessionInfo.putInt("MultiAVType", mum.a(j));
      if (paramBoolean) {
        paramSessionInfo.putBoolean("isVideo", true);
      }
      if (j == 1) {
        paramSessionInfo.putBoolean("enableInvite", bfxg.a("showGroupQavActionSheet", paramQQAppInterface, str));
      }
      paramSessionInfo.putString("Fromwhere", paramString2);
      ChatActivityUtils.a(paramQQAppInterface, paramContext, j, str, true, true, null, paramSessionInfo);
      return;
      i = 1;
      break label274;
      break;
    }
    label451:
    paramString1 = paramQQAppInterface.getAVNotifyCenter().a(azjk.b(str));
    if ((paramString1 == null) || (paramString1.b != paramInt))
    {
      VideoMsgTools.a(paramQQAppInterface, paramContext, j, str, paramSessionInfo.curFriendNick, paramBoolean, paramString2);
      return;
    }
    if ((paramString1 != null) && (paramString1.b == 2) && (paramString1.d == 2) && (paramString1.jdField_e_of_type_Int == 4)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      VideoStatusTipsBar.a(paramQQAppInterface, paramContext, j, str, paramInt, paramBoolean, paramString2);
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageForVideo paramMessageForVideo)
  {
    if ((!lld.c()) || (mup.a())) {
      return;
    }
    if (paramMessageForVideo.type == 13) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label77;
      }
      i = paramMessageForVideo.istroop;
      if ((i != 1) && (i != 3000)) {
        break;
      }
      a(paramQQAppInterface, paramContext, paramSessionInfo, paramMessageForVideo.extInt, paramMessageForVideo.isVideo, paramMessageForVideo.selfuin, "");
      return;
    }
    label77:
    b(paramQQAppInterface, paramSessionInfo, paramMessageForVideo.isVideo, paramMessageForVideo.type);
    if (paramMessageForVideo.isVideo)
    {
      bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8005642", "0X8005642", 0, 0, "", "", "", "");
      return;
    }
    bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8005243", "0X8005243", 0, 0, "", "", "", "");
  }
  
  static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForVideo paramMessageForVideo, SessionInfo paramSessionInfo)
  {
    AIOUtils.isUserOperatedInAIO = true;
    if (lld.c())
    {
      a(paramQQAppInterface, paramMessageForVideo, paramSessionInfo);
      if ((paramSessionInfo.curType != 1) || (paramMessageForVideo.extInt == 10)) {}
    }
    else
    {
      try
      {
        l = Long.parseLong(paramSessionInfo.curFriendUin);
        int i = mum.b(paramSessionInfo.curType);
        l = paramQQAppInterface.getAVNotifyCenter().a(i, l);
        Object localObject = (bfbz)paramQQAppInterface.getManager(48);
        boolean bool1 = ((bfbz)localObject).a(paramSessionInfo.curFriendUin, paramQQAppInterface.getCurrentAccountUin());
        boolean bool2 = ((bfbz)localObject).a(paramSessionInfo.curFriendUin);
        boolean bool3 = ((bfbz)localObject).b(paramSessionInfo.curFriendUin);
        localObject = ((bfbz)localObject).a(paramSessionInfo.curFriendUin);
        if ((l == 0L) && (((!bool3) && (bool1)) || ((!bool2) && (localObject != null) && (((bfcg)localObject).a > 0L))))
        {
          QQToast.a(paramQQAppInterface.getApp(), amtj.a(2131715307), 0).b(paramQQAppInterface.getApp().getResources().getDimensionPixelSize(2131299076));
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
      switch (paramSessionInfo.curType)
      {
      default: 
        paramSessionInfo = "0";
        label72:
        bcef.b(paramQQAppInterface, "CliOper", "", "", str1, str2, 0, 0, paramSessionInfo, "", "", "");
        if (paramInt == 2) {
          bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "2", "", "", "");
        }
        break;
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label238;
      }
      bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8005643", "0X8005643", 0, 0, "", "", "", "");
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
        bcef.b(paramQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "2", "", "", "");
      }
    }
    label238:
    bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8005244", "0X8005244", 0, 0, "", "", "", "");
  }
  
  static void a(QQAppInterface paramQQAppInterface, MessageForVideo paramMessageForVideo, SessionInfo paramSessionInfo)
  {
    int i = paramMessageForVideo.istroop;
    if (paramMessageForVideo.type == 13)
    {
      if (i != 3000) {
        break label123;
      }
      bcef.b(paramQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_disobj", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if ((paramMessageForVideo.type == 2) || (paramMessageForVideo.type == 24)) {
        bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "1", "", "", "");
      }
      if (paramMessageForVideo.type == 0) {
        bcef.b(paramQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "1", "", "", "");
      }
      return;
      label123:
      if (i == 1) {
        if (paramMessageForVideo.extInt == 10) {
          bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8005924", "0X8005924", 0, 0, "", "", "", "");
        } else {
          bcef.b(null, "dc00899", "Grp_video", "", "notice", "video", 0, 0, paramSessionInfo.curFriendUin, "" + TroopUtils.getTroopIdentity(paramQQAppInterface, paramSessionInfo.curFriendUin), "0", "");
        }
      }
    }
  }
  
  private void a(MessageForVideo paramMessageForVideo, Context paramContext, View paramView)
  {
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
    int i;
    if (paramMessageForVideo.selfuin.equals(paramMessageForVideo.senderuin))
    {
      if (-2016 == paramMessageForVideo.msgtype) {
        localObject1 = amtj.a(2131715301);
      }
      Object localObject2 = localObject1;
      if (paramMessageForVideo.msgtype == -2009)
      {
        localObject1 = new StringBuilder().append((String)localObject1);
        localObject2 = paramView.getResources();
        if (!paramMessageForVideo.isVideo) {
          break label259;
        }
        i = 2131719046;
        label132:
        localObject2 = ((Resources)localObject2).getString(i);
      }
      localObject1 = (String)localObject2 + paramMessageForVideo.text;
      if (!paramMessageForVideo.text.contains(paramContext.getResources().getString(2131719505))) {
        break label267;
      }
      localObject1 = (String)localObject1 + a(paramMessageForVideo, paramContext, paramView);
    }
    for (;;)
    {
      paramView.setContentDescription(((String)localObject1).replace(amtj.a(2131715309), amtj.a(2131715300)));
      return;
      localObject1 = ContactUtils.getNick(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForVideo.senderuin, 0);
      break;
      label259:
      i = 2131719032;
      break label132;
      label267:
      if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131719494)))
      {
        paramContext = paramContext.getResources();
        if (paramMessageForVideo.isVideo) {}
        for (i = 2131719513;; i = 2131690187)
        {
          localObject1 = paramContext.getString(i);
          break;
        }
      }
      if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131695485))) {
        localObject1 = paramContext.getResources().getString(2131718109);
      } else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131695484))) {
        localObject1 = paramContext.getResources().getString(2131717691);
      } else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131694909))) {
        localObject1 = paramContext.getResources().getString(2131718109);
      } else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131694908))) {
        localObject1 = paramContext.getResources().getString(2131717691);
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean, int paramInt)
  {
    QLog.w("ChatItemBuilder", 1, "qqVideoEx, isVideo[" + paramBoolean + "], closeType[" + paramInt + "]");
    a(paramQQAppInterface, paramSessionInfo, paramBoolean, paramInt);
    int i = paramSessionInfo.curType;
    String str3 = paramSessionInfo.curFriendNick;
    String str2;
    String str1;
    if (i == 1006)
    {
      str2 = paramSessionInfo.curFriendUin;
      str1 = null;
      if (!paramBoolean) {
        break label115;
      }
    }
    label115:
    for (paramInt = 2;; paramInt = 1)
    {
      if (!paramQQAppInterface.getAVNotifyCenter().a(paramQQAppInterface.getApp(), paramInt, i, str1)) {
        break label120;
      }
      return;
      str1 = paramSessionInfo.curFriendUin;
      str2 = null;
      break;
    }
    label120:
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ChatActivityUtils.a(paramQQAppInterface, localBaseApplication, i, str1, str3, str2, paramBoolean, paramSessionInfo.troopUin, true, true, null, "from_internal");
      return;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public aezf a()
  {
    return new agtz(this);
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    agtz localagtz = (agtz)paramaezf;
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramaezf = paramView;
    if (paramView == null)
    {
      paramaezf = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramaezf.setId(2131364444);
      paramaezf.setTextColor(localResources.getColorStateList(2131167031));
      paramaezf.setTextSize(localResources.getDimensionPixelOffset(2131296459));
      paramaezf.setGravity(16);
      localagtz.a = paramaezf;
    }
    paramView = (MessageForVideo)paramChatMessage;
    int i = VideoMsgTools.a(paramBaseChatItemLayout, paramView.type, paramView.text, paramView.isVideo, paramChatMessage.isSendFromLocal());
    a(localagtz.a, i);
    i = VideoMsgTools.a(paramBaseChatItemLayout, paramView.type, paramView.text, paramChatMessage.isSendFromLocal());
    localagtz.a.setTextColor(localResources.getColor(i));
    localagtz.a.setText(paramView.text);
    if ((paramView.istroop == 1) && (this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695110).equals(paramView.text))) {
      bcef.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, paramView.frienduin, "" + TroopUtils.getTroopIdentity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.frienduin), "", "");
    }
    paramaezf.setOnTouchListener(paramafce);
    paramaezf.setOnLongClickListener(paramafce);
    paramaezf.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (jdField_e_of_type_Boolean) {
      a(paramView, paramBaseChatItemLayout, paramaezf);
    }
    return paramaezf;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return amtj.a(2131715306);
  }
  
  String a(MessageForVideo paramMessageForVideo, Context paramContext, View paramView)
  {
    int j = 0;
    Object localObject = "";
    String str2 = paramMessageForVideo.text;
    String str1 = paramContext.getResources().getString(2131719505) + ",";
    paramContext = str2.substring(str2.indexOf(':') - 2, str2.lastIndexOf(':') + 3).split(":");
    int k;
    int i;
    if (paramContext.length == 3)
    {
      k = Integer.valueOf(paramContext[0]).intValue();
      j = Integer.valueOf(paramContext[1]).intValue();
      i = Integer.valueOf(paramContext[2]).intValue();
    }
    for (;;)
    {
      if ((k <= 0) && (j <= 0))
      {
        paramContext = (Context)localObject;
        if (i <= 0) {}
      }
      else
      {
        if (k <= 0) {
          break label331;
        }
      }
      label331:
      for (localObject = str1 + k + amtj.a(2131715303);; localObject = str1)
      {
        paramContext = (Context)localObject;
        if (j > 0) {
          paramContext = (String)localObject + j + amtj.a(2131715305);
        }
        localObject = paramContext;
        if (i > 0) {
          localObject = paramContext + i + amtj.a(2131715304);
        }
        paramContext = paramView.getResources();
        if (paramMessageForVideo.isVideo) {}
        for (i = 2131719046;; i = 2131719032)
        {
          paramMessageForVideo = paramContext.getString(i);
          paramContext = paramMessageForVideo + (String)localObject;
          return paramContext;
          if (paramContext.length != 2) {
            break label338;
          }
          j = Integer.valueOf(paramContext[0]).intValue();
          i = Integer.valueOf(paramContext[1]).intValue();
          k = 0;
          break;
        }
      }
      label338:
      i = 0;
      k = 0;
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131365382)
    {
      acvv.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    if (paramInt == 2131371498)
    {
      super.d(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(aezf paramaezf, View paramView, ChatMessage paramChatMessage, apee paramapee)
  {
    agtz localagtz = (agtz)paramaezf;
    localagtz.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
    if ((paramapee.a == 0) || (!paramapee.a()))
    {
      paramView = paramView.getResources();
      if (localagtz.a.getText().toString().contains(this.jdField_a_of_type_AndroidContentContext.getString(2131719491)))
      {
        paramaezf = paramView.getColorStateList(2131165941);
        localagtz.a.setTextColor(paramaezf);
        return;
      }
      if (paramChatMessage.isSend())
      {
        paramaezf = paramView.getColorStateList(2131167035);
        localagtz.a.setTextColor(paramaezf);
        if (!paramChatMessage.isSend()) {
          break label151;
        }
      }
      label151:
      for (paramaezf = paramView.getColorStateList(2131167034);; paramaezf = paramView.getColorStateList(2131167033))
      {
        localagtz.a.setLinkTextColor(paramaezf);
        return;
        paramaezf = paramView.getColorStateList(2131167031);
        break;
      }
    }
    if (paramapee.b == 0) {
      localagtz.a.setTextColor(-16777216);
    }
    while (paramapee.c == 0)
    {
      localagtz.a.setLinkTextColor(paramView.getResources().getColorStateList(2131167033));
      return;
      localagtz.a.setTextColor(paramapee.b);
    }
    localagtz.a.setLinkTextColor(paramapee.c);
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
  
  public bgbb[] a(View paramView)
  {
    bgaz localbgaz = new bgaz();
    AIOUtils.getMessage(paramView);
    acvv.a(localbgaz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    super.c(localbgaz, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbgaz, this.jdField_a_of_type_AndroidContentContext);
    return localbgaz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agtw
 * JD-Core Version:    0.7.0.1
 */