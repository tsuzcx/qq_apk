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

public class aefi
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
  
  public aefi(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aefj(this);
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
          axqw.b(paramQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_disobj_launch", 0, 0, "", "", "", "");
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
          axqw.b(paramQQAppInterface, "CliOper", "", "", "0X8005DC6", "0X8005DC6", 0, 0, "", "", "", "");
          return;
          label242:
          axqw.b(paramQQAppInterface, "CliOper", "", "", "0X8005925", "0X8005925", 0, 0, "", "", "", "");
        }
      }
      axqw.b(paramQQAppInterface, "CliOper", "", "", "0X80046CB", "0X80046CB", 0, 0, "", "", "", "");
      return;
    }
    boolean bool = bbfn.a("qqVideoEx", paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
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
    long l2 = avez.b(str);
    QLog.w("ChatItemBuilder", 1, "showGroupQavActionSheet, avType[" + paramInt + "], isVideo[" + paramBoolean + "], msgSelfUin[" + paramString + "], uinType[" + j + "], groupId[" + str + "], curFriendNick[" + paramSessionInfo.d + "], troopUin[" + paramSessionInfo.jdField_b_of_type_JavaLangString + "], isVideoActionSheetShown[" + mui.a() + "], seq[" + l1 + "]");
    if (10 == paramInt)
    {
      i = 0;
      boolean bool = false;
      paramString = paramQQAppInterface.a().a(l2, paramInt);
      if ((paramString == null) || (paramString.jdField_a_of_type_Int <= 0))
      {
        paramString = bbfn.a(paramQQAppInterface, str);
        bool = paramString.getBoolean("forceDisableInviteBox");
        i = paramString.getInt("errId", 2131695942);
      }
      if (bool) {
        bbcv.a(paramContext, 230, null, paramContext.getResources().getString(i), 2131695731, 2131720772, new aefk(), null).show();
      }
    }
    while (paramQQAppInterface.a().a(paramContext, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramBoolean)) {
      return;
    }
    if (AudioHelper.a(19) == 1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        AudioHelper.a(ajyc.a(2131716293));
      }
      if ((!paramQQAppInterface.a().a(l1, str)) && (i == 0)) {
        break;
      }
      paramSessionInfo = new Bundle();
      paramSessionInfo.putInt("MultiAVType", muf.a(j));
      if (paramBoolean) {
        paramSessionInfo.putBoolean("isVideo", true);
      }
      if (j == 1) {
        paramSessionInfo.putBoolean("enableInvite", bbfn.a("showGroupQavActionSheet", paramQQAppInterface, str));
      }
      ChatActivityUtils.a(paramQQAppInterface, paramContext, j, str, true, true, null, paramSessionInfo);
      return;
    }
    paramString = paramQQAppInterface.a().a(avez.b(str));
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
    if ((!lmb.c()) || (!lmb.d()) || (mui.a())) {
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
      axqw.b(paramQQAppInterface, "CliOper", "", "", "0X8005642", "0X8005642", 0, 0, "", "", "", "");
      return;
    }
    axqw.b(paramQQAppInterface, "CliOper", "", "", "0X8005243", "0X8005243", 0, 0, "", "", "", "");
  }
  
  static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForVideo paramMessageForVideo, SessionInfo paramSessionInfo)
  {
    actn.n = true;
    if ((lmb.c()) && (lmb.d()))
    {
      a(paramQQAppInterface, paramMessageForVideo, paramSessionInfo);
      if ((paramSessionInfo.jdField_a_of_type_Int != 1) || (paramMessageForVideo.extInt == 10)) {}
    }
    else
    {
      try
      {
        l = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
        int i = muf.b(paramSessionInfo.jdField_a_of_type_Int);
        l = paramQQAppInterface.a().a(i, l);
        Object localObject = (bakk)paramQQAppInterface.getManager(48);
        boolean bool1 = ((bakk)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.getCurrentAccountUin());
        boolean bool2 = ((bakk)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
        boolean bool3 = ((bakk)localObject).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
        localObject = ((bakk)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
        if ((l == 0L) && (((!bool3) && (bool1)) || ((!bool2) && (localObject != null) && (((bakr)localObject).a > 0L))))
        {
          bcpw.a(paramQQAppInterface.getApp(), ajyc.a(2131716292), 0).b(paramQQAppInterface.getApp().getResources().getDimensionPixelSize(2131298865));
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
        axqw.b(paramQQAppInterface, "CliOper", "", "", str1, str2, 0, 0, paramSessionInfo, "", "", "");
        if (paramInt == 2) {
          axqw.b(paramQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "2", "", "", "");
        }
        break;
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label238;
      }
      axqw.b(paramQQAppInterface, "CliOper", "", "", "0X8005643", "0X8005643", 0, 0, "", "", "", "");
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
        axqw.b(paramQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "2", "", "", "");
      }
    }
    label238:
    axqw.b(paramQQAppInterface, "CliOper", "", "", "0X8005244", "0X8005244", 0, 0, "", "", "", "");
  }
  
  static void a(QQAppInterface paramQQAppInterface, MessageForVideo paramMessageForVideo, SessionInfo paramSessionInfo)
  {
    int i = paramMessageForVideo.istroop;
    if (paramMessageForVideo.type == 13)
    {
      if (i != 3000) {
        break label123;
      }
      axqw.b(paramQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_disobj", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if ((paramMessageForVideo.type == 2) || (paramMessageForVideo.type == 24)) {
        axqw.b(paramQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "1", "", "", "");
      }
      if (paramMessageForVideo.type == 0) {
        axqw.b(paramQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "1", "", "", "");
      }
      return;
      label123:
      if (i == 1) {
        if (paramMessageForVideo.extInt == 10) {
          axqw.b(paramQQAppInterface, "CliOper", "", "", "0X8005924", "0X8005924", 0, 0, "", "", "", "");
        } else {
          axqw.b(null, "dc00899", "Grp_video", "", "notice", "video", 0, 0, paramSessionInfo.jdField_a_of_type_JavaLangString, "" + bamn.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString), "0", "");
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
        localObject1 = ajyc.a(2131716286);
      }
      localObject2 = localObject1;
      if (paramMessageForVideo.msgtype == -2009)
      {
        localObject1 = new StringBuilder().append((String)localObject1);
        localObject2 = paramView.getResources();
        if (!paramMessageForVideo.isVideo) {
          break label516;
        }
        i = 2131720374;
        localObject2 = ((Resources)localObject2).getString(i);
      }
      localObject1 = (String)localObject2 + paramMessageForVideo.text;
      if (!paramMessageForVideo.text.contains(paramContext.getResources().getString(2131720769))) {
        break label569;
      }
      localObject2 = paramMessageForVideo.text;
      paramContext = paramContext.getResources().getString(2131720769) + ",";
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
      for (localObject1 = paramContext + k + ajyc.a(2131716288);; localObject1 = paramContext)
      {
        paramContext = (Context)localObject1;
        if (j > 0) {
          paramContext = (String)localObject1 + j + ajyc.a(2131716290);
        }
        localObject1 = paramContext;
        if (i > 0) {
          localObject1 = paramContext + i + ajyc.a(2131716289);
        }
        paramContext = paramView.getResources();
        if (paramMessageForVideo.isVideo)
        {
          i = 2131720374;
          paramMessageForVideo = paramContext.getString(i);
          localObject1 = paramMessageForVideo + (String)localObject1;
        }
        for (;;)
        {
          paramView.setContentDescription(((String)localObject1).replace(ajyc.a(2131716294), ajyc.a(2131716285)));
          return;
          localObject1 = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForVideo.senderuin, 0);
          break;
          i = 2131720352;
          break label135;
          if (localObject2.length != 2) {
            break label771;
          }
          j = Integer.valueOf(localObject2[0]).intValue();
          i = Integer.valueOf(localObject2[1]).intValue();
          k = 0;
          break label306;
          i = 2131720352;
          break label449;
          if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131720758)))
          {
            paramContext = paramContext.getResources();
            if (paramMessageForVideo.isVideo) {}
            for (i = 2131720775;; i = 2131690269)
            {
              localObject1 = paramContext.getString(i);
              break;
            }
          }
          if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131696246))) {
            localObject1 = paramContext.getResources().getString(2131719241);
          } else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131696245))) {
            localObject1 = paramContext.getResources().getString(2131718744);
          } else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131695688))) {
            localObject1 = paramContext.getResources().getString(2131719241);
          } else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131695687))) {
            localObject1 = paramContext.getResources().getString(2131718744);
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
  
  public acun a()
  {
    return new aefl(this);
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    aefl localaefl = (aefl)paramacun;
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramacun = paramView;
    if (paramView == null)
    {
      paramacun = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramacun.setId(2131364113);
      paramacun.setTextColor(localResources.getColorStateList(2131166872));
      paramacun.setTextSize(localResources.getDimensionPixelOffset(2131296362));
      paramacun.setGravity(16);
      localaefl.a = paramacun;
    }
    paramView = (MessageForVideo)paramChatMessage;
    int i = VideoMsgTools.a(paramBaseChatItemLayout, paramView.type, paramView.text, paramView.isVideo, paramChatMessage.isSendFromLocal());
    a(localaefl.a, i);
    i = VideoMsgTools.a(paramBaseChatItemLayout, paramView.type, paramView.text, paramChatMessage.isSendFromLocal());
    localaefl.a.setTextColor(localResources.getColor(i));
    localaefl.a.setText(paramView.text);
    if ((paramView.istroop == 1) && (this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695886).equals(paramView.text))) {
      axqw.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, paramView.frienduin, "" + bamn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.frienduin), "", "");
    }
    paramacun.setOnTouchListener(paramacxn);
    paramacun.setOnLongClickListener(paramacxn);
    paramacun.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (jdField_e_of_type_Boolean) {
      a(paramView, paramBaseChatItemLayout, paramacun);
    }
    return paramacun;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ajyc.a(2131716291);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131364985)
    {
      aaod.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    if (paramInt == 2131370537)
    {
      super.d(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(acun paramacun, View paramView, ChatMessage paramChatMessage, ambh paramambh)
  {
    aefl localaefl = (aefl)paramacun;
    localaefl.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
    if ((paramambh.jdField_a_of_type_Int == 0) || (!paramambh.a()))
    {
      paramView = paramView.getResources();
      if (localaefl.a.getText().toString().contains(this.jdField_a_of_type_AndroidContentContext.getString(2131720755)))
      {
        paramacun = paramView.getColorStateList(2131165829);
        localaefl.a.setTextColor(paramacun);
        return;
      }
      if (paramChatMessage.isSend())
      {
        paramacun = paramView.getColorStateList(2131166876);
        localaefl.a.setTextColor(paramacun);
        if (!paramChatMessage.isSend()) {
          break label151;
        }
      }
      label151:
      for (paramacun = paramView.getColorStateList(2131166875);; paramacun = paramView.getColorStateList(2131166874))
      {
        localaefl.a.setLinkTextColor(paramacun);
        return;
        paramacun = paramView.getColorStateList(2131166872);
        break;
      }
    }
    if (paramambh.jdField_b_of_type_Int == 0) {
      localaefl.a.setTextColor(-16777216);
    }
    while (paramambh.c == 0)
    {
      localaefl.a.setLinkTextColor(paramView.getResources().getColorStateList(2131166874));
      return;
      localaefl.a.setTextColor(paramambh.jdField_b_of_type_Int);
    }
    localaefl.a.setLinkTextColor(paramambh.c);
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
  
  public bblt[] a(View paramView)
  {
    bblr localbblr = new bblr();
    actn.a(paramView);
    aaod.a(localbblr, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.c(localbblr, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbblr, this.jdField_a_of_type_AndroidContentContext);
    return localbblr.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aefi
 * JD-Core Version:    0.7.0.1
 */