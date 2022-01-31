import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.os.StatFs;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PttAudioChangeView;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder.2;
import com.tencent.mobileqq.activity.aio.item.SyncParentPressedRelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.XListView;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;

public class adwr
  extends BaseBubbleBuilder
  implements acum, acuq, acvj, acwf, acxj, adwq, ayaj
{
  protected SpannableString a;
  protected TextView a;
  protected ayae a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private Map<Long, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  Set<adwu> jdField_a_of_type_JavaUtilSet = new HashSet();
  protected SpannableString b;
  
  public adwr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Ayae = ((ayae)paramQQAppInterface.getManager(17));
    this.jdField_a_of_type_Ayae.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public static int a(Context paramContext, int paramInt1, float paramFloat, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramInt1 = Math.min(60, Math.max(1, paramInt1));
    if (paramInt1 == 1)
    {
      paramInt1 = 25;
      int i = 0;
      if (paramBoolean1) {
        i = 16;
      }
      int j = i;
      if (paramBoolean2) {
        j = i + 38;
      }
      i = paramInt1;
      if (j != 0)
      {
        i = paramInt1;
        if (paramInt1 > 170 - j) {
          i = 170 - j;
        }
      }
      paramInt1 = i;
      if (i % 5 != 0) {
        paramInt1 = i / 5 * 5;
      }
      paramInt1 = actn.a(paramInt1, paramContext.getResources());
      if (paramFloat <= 0.0F) {
        break label196;
      }
      paramInt1 = Math.max(paramInt1 + actn.a(paramInt2, paramContext.getResources()) + actn.a(paramInt3, paramContext.getResources()), (int)paramFloat);
      paramInt3 = BaseChatItemLayout.e - BaseChatItemLayout.i - BaseChatItemLayout.j - 32;
      if (paramInt1 <= paramInt3) {
        break label209;
      }
      paramInt1 = paramInt3;
    }
    label196:
    label209:
    for (;;)
    {
      return paramInt1 - actn.a(paramInt2 - 40, paramContext.getResources());
      paramInt1 = 15 + (int)(PttAudioWaveView.a(paramInt1, 60, 1.5F) * 125.0F);
      break;
      return paramInt1 + actn.a(paramInt3, paramContext.getResources());
    }
  }
  
  public static int a(Context paramContext, int paramInt1, String paramString, Paint paramPaint, int paramInt2)
  {
    int i = Math.min(60, Math.max(1, paramInt1));
    int j;
    float f1;
    if (i > 40)
    {
      i += 40;
      j = actn.a(i + 20, paramContext.getResources());
      if ((paramString == null) || (paramPaint == null)) {
        break label173;
      }
      i = BaseChatItemLayout.e - BaseChatItemLayout.i - BaseChatItemLayout.j - 32;
      f1 = paramPaint.measureText(paramString) + paramInt2;
      if (f1 <= i) {
        break label176;
      }
      f1 = i;
    }
    label173:
    label176:
    for (;;)
    {
      float f2;
      if (paramInt1 > 99)
      {
        f2 = 38.0F;
        int k = actn.a(f2, paramContext.getResources());
        paramInt2 = j + k;
        paramInt1 = paramInt2;
        if (paramInt2 > i) {
          paramInt1 = i;
        }
        return Math.max(paramInt1, (int)f1) - k;
        i *= 2;
        break;
      }
      if (paramInt1 > 9) {}
      for (paramInt1 = 34;; paramInt1 = 30)
      {
        f2 = paramInt1;
        break;
      }
      return j;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    int j = 999;
    int k = 1005;
    if (paramMessageForPtt == null) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "parsePttStatus  fileSize " + paramMessageForPtt.fileSize + " url " + paramMessageForPtt.url + " uniseq " + paramMessageForPtt.uniseq);
    }
    int i;
    if (paramMessageForPtt.isSendFromLocal()) {
      if ((paramMessageForPtt.url != null) && (paramMessageForPtt.url.startsWith(ajsf.aV))) {
        if (paramMessageForPtt.fileSize > 0L) {
          i = 1003;
        }
      }
    }
    for (;;)
    {
      return i;
      i = k;
      if (paramMessageForPtt.fileSize != -1L) {
        if (paramMessageForPtt.fileSize == -2L)
        {
          if (a(paramMessageForPtt))
          {
            i = 999;
          }
          else
          {
            paramMessageForPtt.fileSize = -1L;
            i = k;
          }
        }
        else
        {
          if (paramMessageForPtt.fileSize == -3L)
          {
            boolean bool = paramQQAppInterface.a().a(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
            k = paramQQAppInterface.a().b(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
            if (QLog.isColorLevel()) {
              QLog.d("PttItemBuilder", 2, "parsePttStatus transStatus  " + k + ", hasTransProc " + bool);
            }
            if ((!bool) || (k == 1005))
            {
              paramMessageForPtt.fileSize = -1L;
              i = 1005;
            }
            for (;;)
            {
              break;
              i = j;
              if (k != 7000) {
                i = 1001;
              }
            }
          }
          j = paramQQAppInterface.a().b(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("PttItemBuilder", 2, "parsePttStatus status  " + j);
            i = j;
            continue;
            i = 1004;
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("PttItemBuilder", 2, "handlePttItem recieve friendUin " + paramMessageForPtt.frienduin + " url " + paramMessageForPtt.url + " urlAtServer " + paramMessageForPtt.urlAtServer + " uniseq " + paramMessageForPtt.uniseq);
            }
            if (paramMessageForPtt != null)
            {
              j = avch.a(paramQQAppInterface, paramMessageForPtt);
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("PttItemBuilder", 2, "handlePttItem recieve status " + j + "   url " + paramMessageForPtt.url + " uniseq " + paramMessageForPtt.uniseq);
                i = j;
              }
            }
            else
            {
              i = 0;
            }
          }
        }
      }
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = 120;
    paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "key = " + paramString + ", time = " + paramQQAppInterface);
    }
    if (paramQQAppInterface != null) {}
    do
    {
      do
      {
        do
        {
          try
          {
            i = Integer.valueOf(paramQQAppInterface).intValue();
            if (i > 0) {
              return i;
            }
          }
          catch (Exception paramQQAppInterface)
          {
            if (QLog.isColorLevel()) {
              QLog.e("PttItemBuilder", 2, paramQQAppInterface.toString());
            }
          }
          i = j;
        } while ("ConvertText_MaxPtt".equals(paramString));
        i = j;
      } while ("Normal_MaxPtt".equals(paramString));
      if ("VIP_MaxPtt".equals(paramString)) {
        return 180;
      }
      int i = j;
    } while (!"SVIP_MaxPtt".equals(paramString));
    return 300;
  }
  
  public static String a(int paramInt)
  {
    String str = "";
    int i = paramInt / 60;
    if (i > 0) {
      str = i + "'";
    }
    return str + paramInt % 60 + "\"";
  }
  
  private void a(int paramInt, adwu paramadwu)
  {
    if (paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(paramInt);
    }
    if (paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
      paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(paramInt);
    }
    if (paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) {
      paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(paramInt);
    }
  }
  
  private void a(adwu paramadwu, MessageForPtt paramMessageForPtt, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
    {
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695521, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      return;
    }
    if (!apvb.b(paramMessageForPtt.getLocalFilePath()))
    {
      a(paramadwu, paramMessageForPtt, false, true);
      a(paramadwu, paramMessageForPtt, 5003, false);
      return;
    }
    PttAudioWaveView localPttAudioWaveView = (PttAudioWaveView)paramView.findViewById(2131372935);
    float f;
    int i;
    if (localPttAudioWaveView != null)
    {
      f = paramMessageForPtt.playProgress;
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "onClick, onPlayProgress progress = " + f);
      }
      if (f == 1.0F)
      {
        localPttAudioWaveView.setProgress(0.0F);
        paramMessageForPtt.playProgress = 0.0F;
        i = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "onClick, onPlayProgress offset = " + i);
      }
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramadwu.jdField_b_of_type_Int);
      axqw.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 1, 0, "", "", "", "");
      if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(actn.a(paramView), i)) {
        break;
      }
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695520, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      return;
      i = (int)(paramMessageForPtt.voiceLength * 1000.0F * f);
      continue;
      i = 0;
    }
  }
  
  private void a(View paramView, ColorFilter paramColorFilter)
  {
    Object localObject = (adwu)paramView.getTag();
    if (localObject != null)
    {
      paramView = actn.a(paramView);
      if ((paramView != null) && (paramView.vipBubbleID == 0L))
      {
        localObject = ((adwu)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getBackground();
        if ((localObject != null) && (paramView.vipBubbleID == 0L))
        {
          ((Drawable)localObject).setColorFilter(paramColorFilter);
          ((Drawable)localObject).invalidateSelf();
        }
      }
    }
  }
  
  private void a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
  }
  
  private void a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    if (adwv.h)
    {
      this.jdField_a_of_type_Ayae.a(paramMessageForPtt);
      return;
    }
    this.jdField_a_of_type_Ayae.b(paramMessageForPtt, paramInt);
  }
  
  protected static boolean a(MessageForPtt paramMessageForPtt)
  {
    String str = QQRecorder.a();
    return (paramMessageForPtt.fileSize == -2L) && (!TextUtils.isEmpty(str)) && (str.equals(paramMessageForPtt.getLocalFilePath()));
  }
  
  private boolean d(ChatMessage paramChatMessage)
  {
    return paramChatMessage.vipBubbleID >= 1L;
  }
  
  private void g(ChatMessage paramChatMessage)
  {
    if (bbwv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_show_open_svip_gray_msg", false)) {
      if (QLog.isColorLevel()) {
        QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt msg have showed ,so click ptt msg not add msg");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = amyv.c();
          localObject2 = (amuf)ampm.a().a(442);
          if ((localObject2 != null) && (((amuf)localObject2).a())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is close ,so click ptt msg not add msg");
        return;
        if (((amyu)localObject1).jdField_a_of_type_Int == 3) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is open but stage=" + ((amyu)localObject1).jdField_a_of_type_Int + ",so click ptt msg not add msg");
      return;
      if (!adwv.d) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is open but switch is open ,so click ptt msg not add msg");
    return;
    Object localObject2 = ajyc.a(2131708716);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_action", 41);
    ((Bundle)localObject1).putString("textColor", "#40A0FF");
    localObject2 = new aquz(paramChatMessage.frienduin, paramChatMessage.selfuin, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5020, 655392, ((MessageForPtt)paramChatMessage).time);
    ((aquz)localObject2).a(15, 19, (Bundle)localObject1);
    localObject1 = new MessageForUniteGrayTip();
    if (paramChatMessage.istroop == 1) {
      ((MessageForUniteGrayTip)localObject1).shmsgseq = paramChatMessage.shmsgseq;
    }
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aquz)localObject2);
    aqva.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject1);
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0);
    localObject1 = "businessinfo_ptt_auto_change_guide_has_show_" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramChatMessage.edit().putBoolean((String)localObject1, true).commit();
    adwv.e = true;
    bbwv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_show_open_svip_gray_msg", true);
    QLog.e("vip_ptt.PttItemBuilder", 1, "stage 3 add gray msg seccess");
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public acum a(View paramView)
  {
    if (actn.a(paramView) != null) {
      return this;
    }
    return null;
  }
  
  public acun a()
  {
    return new adwu();
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    paramChatMessage = b(paramChatMessage, paramacun, paramView, paramBaseChatItemLayout, paramacxn);
    acwd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramacun.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this);
    if (AppSetting.d) {
      paramacun.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setOnClickListener(this);
    }
    paramacun.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bbet.a(paramChatMessage.issend)) {
      return ajyc.a(2131708712);
    }
    return ajyc.a(2131708713);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ayae.a(null);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((adwu)localIterator.next()).a();
    }
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilSet = null;
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  @TargetApi(11)
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForPtt))) {}
    label173:
    label2095:
    for (;;)
    {
      return;
      MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
      Object localObject;
      if (2131365928 == paramInt)
      {
        paramInt = QQRecorder.a(localMessageForPtt);
        if (paramInt > 0)
        {
          bgrk localbgrk = new bgrk(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt.voiceType, new adws(this, localMessageForPtt));
          if (localMessageForPtt.isSend())
          {
            paramChatMessage = localMessageForPtt.selfuin;
            paramContext = null;
            if (mye.a(localMessageForPtt)) {
              paramContext = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843043);
            }
            localObject = this.jdField_a_of_type_Baxk.a(1, paramChatMessage);
            paramChatMessage = (ChatMessage)localObject;
            if (localObject == null) {
              paramChatMessage = this.jdField_a_of_type_Baxk.a(1, localMessageForPtt.frienduin);
            }
            if (!localbgrk.a(localMessageForPtt.getLocalFilePath(), paramInt, paramChatMessage, paramContext)) {
              break label173;
            }
            localbgrk.show();
          }
          for (;;)
          {
            aytl.a(1);
            return;
            paramChatMessage = localMessageForPtt.senderuin;
            break;
            bgpv.a(this.jdField_a_of_type_AndroidContentContext, 2131692326, 1);
          }
        }
      }
      else
      {
        if (paramInt == 2131364985)
        {
          if (c(localMessageForPtt)) {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
          }
          aaod.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          aytl.a(2);
          return;
        }
        if (paramInt == 2131370537)
        {
          aytl.a(6);
          super.d(paramChatMessage);
          return;
        }
        if (paramInt == 2131364825)
        {
          if (TextUtils.isEmpty(localMessageForPtt.sttText))
          {
            paramContext = this.jdField_a_of_type_AndroidContentContext.getString(2131719804);
            aytl.a(3);
          }
          for (;;)
          {
            try
            {
              if (Build.VERSION.SDK_INT >= 11) {
                break label355;
              }
              ((android.text.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramContext);
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
              return;
            }
            catch (Exception paramContext)
            {
              return;
            }
            paramContext = localMessageForPtt.sttText;
            break;
            label355:
            ((android.content.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("msg", paramContext));
          }
        }
        if (paramInt == 2131366632)
        {
          aytl.a(4);
          if ((localMessageForPtt.sttText != null) && (localMessageForPtt.sttText.length() > 0))
          {
            paramContext = new Bundle();
            paramContext.putInt("forward_type", -1);
            paramContext.putString("forward_text", localMessageForPtt.sttText);
            paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
            paramChatMessage = new Intent();
            paramChatMessage.putExtras(paramContext);
            aqbc.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
            return;
          }
          bcpw.a(this.jdField_a_of_type_AndroidContentContext, ajyc.a(2131708722), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
          return;
        }
        int i;
        if (paramInt == 2131376584)
        {
          paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acut.a(localMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.delmsg", 2, "autochange pos is:" + paramInt);
          }
          if (paramInt >= 0)
          {
            i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
            paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(paramInt - i);
            if (paramContext != null)
            {
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B40", "0X8005B40", 0, 0, "", "", "", "");
              axqw.b(null, "dc00898", "", "", "0X8009DF7", "0X8009DF7", 0, 0, "", "", "", "");
              paramContext = (adwu)paramContext.getTag();
              aytl.a(5);
              if ((localMessageForPtt.sttAbility == 1) || (localMessageForPtt.sttAbility == 3))
              {
                if ((localMessageForPtt.sttAbility == 3) && (!localMessageForPtt.expandStt)) {
                  localMessageForPtt.expandStt = true;
                }
                g(paramChatMessage);
                this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramChatMessage.uniseq), ajyc.a(2131708720));
                a(localMessageForPtt, 1);
                this.jdField_a_of_type_Ayae.a(this);
                a(paramContext, localMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt), c(localMessageForPtt));
                return;
              }
              if ((localMessageForPtt.sttAbility == 2) && (!localMessageForPtt.expandStt))
              {
                localMessageForPtt.expandStt = true;
                localMessageForPtt.serial();
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPtt.uniseq, localMessageForPtt.msgData);
                a(paramContext, localMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt), c(localMessageForPtt));
                a(paramContext, paramContext.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localMessageForPtt, paramContext.jdField_a_of_type_Ambh);
              }
            }
          }
        }
        else
        {
          if (paramInt == 2131370494)
          {
            if (c(localMessageForPtt)) {
              MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
            }
            super.a(paramChatMessage);
            return;
          }
          boolean bool1;
          label1086:
          label1133:
          boolean bool2;
          float f;
          if (paramInt == 2131371749)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l) {}
            for (paramInt = 9;; paramInt = 10)
            {
              aytl.a(paramInt);
              if (!localMessageForPtt.isReady()) {
                break;
              }
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
                break label1044;
              }
              bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695521, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
              return;
            }
            paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l)
            {
              bool1 = true;
              paramContext.d(bool1);
              paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l) {
                break label1451;
              }
              bool1 = true;
              paramContext.l = bool1;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
              {
                paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l) {
                  break label1457;
                }
                bool1 = true;
                paramContext.a(bool1, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              }
              bool1 = lgm.a(BaseApplicationImpl.getContext());
              bool2 = AudioHelper.a(BaseApplicationImpl.getContext());
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l, bool1, bool2);
              if (c(localMessageForPtt)) {
                MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
              }
              paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acut.a(localMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
              i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
              if (paramInt < 0) {
                break label2092;
              }
              paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(paramInt - i);
              localObject = (adwu)actn.a(paramChatMessage);
              if ((paramChatMessage == null) || (localObject == null)) {
                break label2092;
              }
              paramContext = (MessageForPtt)((adwu)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((adwu)localObject).jdField_b_of_type_Int);
              ((adwu)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
              ((adwu)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
              ((adwu)localObject).a(true);
              paramChatMessage = (PttAudioWaveView)paramChatMessage.findViewById(2131372935);
              if ((paramChatMessage == null) || (paramContext == null)) {
                break label2092;
              }
              f = paramContext.playProgress;
              if (QLog.isColorLevel()) {
                QLog.d("PttItemBuilder", 2, "onMenuItemClicked, progress = " + f);
              }
              if (f != 1.0F) {
                break label1463;
              }
              paramChatMessage.setProgress(0.0F);
              paramInt = 0;
            }
          }
          for (;;)
          {
            if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localMessageForPtt, paramInt)) {
              break label2095;
            }
            bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695520, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
            return;
            bool1 = false;
            break label1062;
            bool1 = false;
            break label1086;
            label1457:
            bool1 = false;
            break label1133;
            label1463:
            paramInt = (int)(paramContext.voiceLength * 1000.0F * f);
            continue;
            if ((paramInt == 2131376390) || (paramInt == 2131376391) || (paramInt == 2131376388))
            {
              f = MediaPlayerManager.a;
              paramContext = "0X8009DE4";
              if (paramInt == 2131376391)
              {
                f = MediaPlayerManager.b;
                paramContext = "0X8009E7D";
              }
            }
            for (;;)
            {
              if (!localMessageForPtt.isReady()) {
                break label2090;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
              {
                bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695521, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                return;
                if (paramInt == 2131376388)
                {
                  f = MediaPlayerManager.c;
                  paramContext = "0X8009DE3";
                }
              }
              else
              {
                bool1 = lgm.a(BaseApplicationImpl.getContext());
                bool2 = AudioHelper.a(BaseApplicationImpl.getContext());
                paramChatMessage = bbfk.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l, bool1, bool2, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n, f);
                if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n == 0) {
                  this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n = bbfk.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l, bool1, bool2);
                }
                if (!TextUtils.isEmpty(paramChatMessage)) {
                  bcpw.a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b() == 0)
                {
                  paramInt = 1;
                  axqw.b(null, "dc00898", "", "", paramContext, paramContext, paramInt, 0, "", "", "", "");
                  if (c(localMessageForPtt)) {
                    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("PttItemBuilder", 2, "getMenuItem oriSpeed:" + localMessageForPtt.playSpeedPos + ", newSpeed:" + f);
                  }
                  paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acut.a(localMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
                  i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
                  if (paramInt < 0) {
                    break label2084;
                  }
                  paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(paramInt - i);
                  localObject = (adwu)actn.a(paramChatMessage);
                  if ((paramChatMessage == null) || (localObject == null)) {
                    break label2084;
                  }
                  paramContext = (MessageForPtt)((adwu)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
                  MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((adwu)localObject).jdField_b_of_type_Int);
                  if (paramContext != null) {
                    paramContext.playSpeedPos = f;
                  }
                  ((adwu)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
                  ((adwu)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
                  ((adwu)localObject).a(true);
                  paramChatMessage = (PttAudioWaveView)paramChatMessage.findViewById(2131372935);
                  if ((paramChatMessage == null) || (paramContext == null)) {
                    break label2084;
                  }
                  f = paramContext.playProgress;
                  if (QLog.isColorLevel()) {
                    QLog.d("PttItemBuilder", 2, "onMenuItemClicked, progress = " + f);
                  }
                  if (f != 1.0F) {
                    break label2059;
                  }
                  paramChatMessage.setProgress(0.0F);
                  paramInt = 0;
                }
                for (;;)
                {
                  if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localMessageForPtt, paramInt)) {
                    break label2087;
                  }
                  bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695520, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                  return;
                  paramInt = 2;
                  break;
                  paramInt = (int)(paramContext.voiceLength * 1000.0F * f);
                  continue;
                  super.a(paramInt, paramContext, paramChatMessage);
                  return;
                  paramInt = 0;
                }
                break;
              }
            }
            break;
            paramInt = 0;
          }
        }
      }
    }
  }
  
  public void a(acun paramacun, View paramView, ChatMessage paramChatMessage, ambh paramambh)
  {
    adwu localadwu = (adwu)paramacun;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, localadwu, localMessageForPtt);
    if ((paramambh.jdField_a_of_type_Int == 0) || (!paramambh.a()))
    {
      paramacun = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramacun = paramacun.getColorStateList(2131166876);
        if ((localadwu.jdField_a_of_type_AndroidWidgetTextView != null) && (paramacun != null)) {
          localadwu.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramacun);
        }
        if ((localadwu.jdField_b_of_type_AndroidWidgetTextView != null) && (paramacun != null))
        {
          localadwu.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramacun);
          if (this.jdField_a_of_type_Ayae.a(localMessageForPtt)) {
            localadwu.jdField_b_of_type_AndroidWidgetTextView.setTextColor(PttAudioWaveView.a(paramacun.getDefaultColor(), 0.5F));
          }
          if ((localadwu.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) && (localadwu.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getVisibility() == 0))
          {
            localadwu.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(paramacun.getDefaultColor());
            localadwu.jdField_b_of_type_AndroidWidgetTextView.setTextColor(PttAudioWaveView.a(paramacun.getDefaultColor(), 0.5F));
          }
        }
        if (!bool)
        {
          if (paramChatMessage.isSend()) {
            break label227;
          }
          a(Color.parseColor("#424448"), localadwu);
        }
      }
    }
    label227:
    label633:
    for (;;)
    {
      return;
      paramacun = paramacun.getColorStateList(2131166872);
      break;
      if (paramacun != null)
      {
        a(paramacun.getDefaultColor(), localadwu);
        return;
        if (paramambh.jdField_b_of_type_Int == 0)
        {
          localadwu.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          if (localadwu.jdField_b_of_type_AndroidWidgetTextView != null)
          {
            localadwu.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
            if (this.jdField_a_of_type_Ayae.a(localMessageForPtt)) {
              localadwu.jdField_b_of_type_AndroidWidgetTextView.setTextColor(PttAudioWaveView.a(-16777216, 0.5F));
            }
            if ((localadwu.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) && (localadwu.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getVisibility() == 0))
            {
              localadwu.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(-16777216);
              localadwu.jdField_b_of_type_AndroidWidgetTextView.setTextColor(PttAudioWaveView.a(-16777216, 0.5F));
            }
          }
          if (!bool) {
            a(-16777216, localadwu);
          }
        }
        for (;;)
        {
          if ((!paramambh.jdField_b_of_type_Boolean) || (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localadwu.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), localadwu.jdField_a_of_type_Ambh.jdField_a_of_type_Double * 10000.0D) != 1)) {
            break label633;
          }
          float f2 = localadwu.jdField_a_of_type_AndroidWidgetTextView.getTextSize() * 3.0F / 16.0F;
          float f1 = f2;
          if (f2 > 25.0F) {
            f1 = 25.0F;
          }
          localadwu.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
          localadwu.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(f1, 0.0F, 0.0F, paramambh.d);
          if (bool) {
            break;
          }
          a(-1, localadwu);
          return;
          localadwu.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramambh.jdField_b_of_type_Int);
          if (localadwu.jdField_b_of_type_AndroidWidgetTextView != null)
          {
            localadwu.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramambh.jdField_b_of_type_Int);
            if (this.jdField_a_of_type_Ayae.a(localMessageForPtt)) {
              localadwu.jdField_b_of_type_AndroidWidgetTextView.setTextColor(PttAudioWaveView.a(paramambh.jdField_b_of_type_Int, 0.5F));
            }
            if ((localadwu.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) && (localadwu.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getVisibility() == 0))
            {
              localadwu.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(paramambh.jdField_b_of_type_Int);
              localadwu.jdField_b_of_type_AndroidWidgetTextView.setTextColor(PttAudioWaveView.a(paramambh.jdField_b_of_type_Int, 0.5F));
            }
          }
          if (!bool) {
            a(paramambh.jdField_b_of_type_Int, localadwu);
          }
        }
      }
    }
  }
  
  protected void a(adwu paramadwu, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag + ", voiceLength is: " + paramMessageForPtt.voiceLength);
    }
    paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject1 = (RelativeLayout.LayoutParams)paramadwu.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    int k = 0;
    Object localObject2 = null;
    if (paramadwu.c != null)
    {
      paramadwu.c.setVisibility(8);
      paramadwu.c.setOnClickListener(null);
      paramadwu.d.setVisibility(8);
    }
    if (paramadwu.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      paramadwu.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramadwu.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      paramadwu.e.setVisibility(8);
      paramadwu.f.setVisibility(8);
      paramadwu.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
      paramadwu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramadwu.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramadwu.jdField_a_of_type_Acxn);
    paramadwu.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramadwu.jdField_a_of_type_Acxn);
    Object localObject5 = this.jdField_a_of_type_AndroidContentContext.getResources();
    boolean bool3 = ahjm.a(paramMessageForPtt);
    boolean bool2 = a(paramMessageForPtt, paramadwu);
    boolean bool1;
    boolean bool4;
    int i;
    int j;
    int m;
    if (paramMessageForPtt.voiceChangeFlag != 0)
    {
      bool1 = true;
      bool4 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramadwu, paramMessageForPtt);
      i = 0;
      j = 0;
      m = actn.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      switch (paramInt)
      {
      default: 
        localObject1 = "";
        paramInt = k;
        i = j;
        label480:
        if (paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
          paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setSeekListener(this);
        }
        switch (paramInt)
        {
        default: 
          paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
          if (paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) {
            paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
          }
          label562:
          if (bool2)
          {
            paramMessageForPtt = (agzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245);
            if (paramMessageForPtt == null) {
              break label3971;
            }
            paramMessageForPtt = paramMessageForPtt.a("voice_pwd", ajyc.a(2131708718), new String[] { "lowTipStr" });
            label609:
            paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, paramMessageForPtt, null);
          }
          if (AppSetting.d)
          {
            paramMessageForPtt = ajyc.a(2131708709);
            if (i == 0) {
              break label3981;
            }
            paramadwu.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject1 + ajyc.a(2131708714) + ajyc.a(2131708710));
            label681:
            if (paramadwu.jdField_a_of_type_JavaLangStringBuilder != null)
            {
              paramadwu.jdField_a_of_type_JavaLangStringBuilder.append("发送了语音.").append((String)localObject1);
              if (localObject2 != null) {
                paramadwu.jdField_a_of_type_JavaLangStringBuilder.append(" ").append((String)localObject2);
              }
            }
          }
          break;
        }
        break;
      }
    }
    do
    {
      return;
      bool1 = false;
      break;
      paramInt = 7;
      localObject1 = "";
      i = j;
      break label480;
      paramadwu.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramadwu.jdField_a_of_type_AndroidWidgetTextView.setPadding(actn.a(10.0F, (Resources)localObject5), BaseChatItemLayout.l, actn.a(10.0F, (Resources)localObject5), BaseChatItemLayout.m);
      if (paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      a(paramadwu, bool4, bool1, paramMessageForPtt.isSend());
      paramInt = 1;
      paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      ((RelativeLayout.LayoutParams)paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = m;
      paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
      localObject1 = "";
      i = j;
      break label480;
      ((RelativeLayout.LayoutParams)paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = m;
      paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
      paramadwu.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramadwu.jdField_a_of_type_AndroidWidgetTextView.setPadding(actn.a(40.0F, (Resources)localObject5), BaseChatItemLayout.l, actn.a(40.0F, (Resources)localObject5), BaseChatItemLayout.m);
      if (paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      if (paramInt == 999)
      {
        paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
        paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(8);
        localObject1 = "";
        i = j;
        paramInt = k;
        break label480;
      }
      paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
      paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
      localObject1 = "";
      i = j;
      paramInt = k;
      break label480;
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "showPttItem builder, voiceLength:" + paramMessageForPtt.voiceLength);
      }
      if (paramMessageForPtt.voiceLength <= 1) {
        paramMessageForPtt.voiceLength = QQRecorder.a(paramMessageForPtt);
      }
      if (paramMessageForPtt.voiceLength > 0) {
        break label1145;
      }
      ((RelativeLayout.LayoutParams)paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = m;
      paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
      paramadwu.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramadwu.jdField_a_of_type_AndroidWidgetTextView.setPadding(actn.a(10.0F, (Resources)localObject5), BaseChatItemLayout.l, actn.a(10.0F, (Resources)localObject5), BaseChatItemLayout.m);
    } while (paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null);
    paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    return;
    label1145:
    label1278:
    Object localObject4;
    Object localObject6;
    if (paramMessageForPtt.voiceLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt")) {
      if (paramMessageForPtt.longPttVipFlag == 1)
      {
        if (this.jdField_a_of_type_AndroidTextSpannableString == null)
        {
          this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("[v] QQ会员专享长语音");
          localObject1 = ((Resources)localObject5).getDrawable(2130840072);
          ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
          localObject1 = new bcni((Drawable)localObject1, 1).a(0.05F);
          this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localObject1, 0, 3, 17);
        }
        paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_a_of_type_AndroidTextSpannableString, this);
        localObject2 = "QQ会员专享长语音";
        localObject1 = localObject2;
        if (VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          localObject6 = nam.a();
          if (!VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label3321;
          }
          localObject1 = "svip";
          label1321:
          VasWebviewUtil.reportCommercialDrainage((String)localObject4, "LongVoice", "TailView", "0", 1, 0, 0, (String)localObject6, "", (String)localObject1);
        }
      }
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      if ((paramMessageForPtt.voiceLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ConvertText_MaxPtt")) && (paramMessageForPtt.autoToText != 2)) {
        paramMessageForPtt.sttAbility = 0;
      }
      if ((TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
        paramMessageForPtt.timeStr = a(paramMessageForPtt.voiceLength);
      }
      localObject4 = paramMessageForPtt.timeStr;
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "showPttItem, msgText = " + (String)localObject4 + ", message.voiceLength" + paramMessageForPtt.voiceLength);
      }
      paramadwu.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject4);
      a(paramadwu, bool4, bool1, paramMessageForPtt.isSend());
      paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      paramadwu.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      if (paramMessageForPtt.isSend()) {
        if (paramMessageForPtt.mRobotFlag == 1)
        {
          localObject2 = ((balw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
        }
        else
        {
          label1548:
          j = 1;
          if ((paramInt != 2003) && (paramInt != 1003)) {
            break label3453;
          }
          if ((paramMessageForPtt.isSend()) || (paramMessageForPtt.isReadPtt)) {
            break label4027;
          }
          paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
        }
      }
      label3585:
      label3734:
      label3753:
      label4019:
      label4027:
      for (paramInt = 1;; paramInt = 0)
      {
        if ((paramMessageForPtt.sttAbility == 2) && (paramMessageForPtt.voiceChangeFlag != 1) && (paramMessageForPtt.expandStt))
        {
          j = 2;
          k = 0;
          i = paramInt;
        }
        for (paramInt = k;; paramInt = 0)
        {
          for (;;)
          {
            m = actn.a(9.0F, (Resources)localObject5);
            int i1 = actn.a(12.0F, (Resources)localObject5);
            try
            {
              k = ((Resources)localObject5).getDrawable(2130844025).getIntrinsicHeight();
              int i2 = actn.a(1.0F, (Resources)localObject5);
              n = actn.a(1.5F, (Resources)localObject5);
              int i3 = actn.a(1.5F, (Resources)localObject5);
              paramadwu.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, BaseChatItemLayout.l, m, BaseChatItemLayout.m);
              paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setPadding(0, 0, n, 0);
              paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setPadding(0, 0, i3, 0);
              localObject2 = (RelativeLayout.LayoutParams)paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams();
              if (bool3)
              {
                ((RelativeLayout.LayoutParams)localObject2).width = actn.a(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
                paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPadding(actn.a(2.0F, (Resources)localObject5) + m, 0, 0, 0);
                if (j == 2)
                {
                  if (paramadwu.jdField_b_of_type_AndroidWidgetTextView != null) {
                    break label3585;
                  }
                  localObject6 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                  ((ImageView)localObject6).setImageDrawable(new ColorDrawable(838860800));
                  RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i2);
                  ((ImageView)localObject6).setLayoutParams(localLayoutParams1);
                  ((ImageView)localObject6).setId(2131372952);
                  localObject7 = new TextView(this.jdField_a_of_type_AndroidContentContext);
                  if (!paramMessageForPtt.isSend()) {
                    break label3544;
                  }
                  localObject2 = ((Resources)localObject5).getColorStateList(2131166876);
                  if (localObject2 != null)
                  {
                    ((TextView)localObject7).setTextColor((ColorStateList)localObject2);
                    if ((paramInt == 5) && (paramadwu.jdField_a_of_type_Ambh != null) && (paramadwu.jdField_a_of_type_Ambh.jdField_b_of_type_Int != 0)) {
                      ((TextView)localObject7).setTextColor(PttAudioWaveView.a(paramadwu.jdField_a_of_type_Ambh.jdField_b_of_type_Int, 0.5F));
                    }
                  }
                  ((TextView)localObject7).setId(2131372951);
                  ((TextView)localObject7).setMaxWidth(BaseChatItemLayout.e);
                  localObject9 = new RelativeLayout.LayoutParams(-2, -2);
                  localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
                  ((RelativeLayout)localObject2).setId(2131372948);
                  localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
                  localProgressBar.setId(2131372949);
                  localObject8 = new RelativeLayout.LayoutParams(actn.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actn.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                  localProgressBar.setIndeterminate(true);
                  localProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839140));
                  ((RelativeLayout.LayoutParams)localObject8).topMargin = actn.a(13.0F, (Resources)localObject5);
                  ((RelativeLayout.LayoutParams)localObject8).leftMargin = actn.a(16.0F, (Resources)localObject5);
                  localProgressBar.setLayoutParams((ViewGroup.LayoutParams)localObject8);
                  localObject8 = new PttAudioChangeView(this.jdField_a_of_type_AndroidContentContext, 2130838045, 6);
                  ((PttAudioChangeView)localObject8).setThemeColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166872).getDefaultColor());
                  ((PttAudioChangeView)localObject8).setId(2131372950);
                  RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(actn.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actn.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                  localLayoutParams2.topMargin = actn.a(13.0F, (Resources)localObject5);
                  localLayoutParams2.leftMargin = actn.a(16.0F, (Resources)localObject5);
                  ((PttAudioChangeView)localObject8).setLayoutParams(localLayoutParams2);
                  if ((paramInt != 5) && (paramInt != 6)) {
                    break label3557;
                  }
                  ((RelativeLayout.LayoutParams)localObject9).leftMargin = actn.a(25.0F, (Resources)localObject5);
                  if (paramInt == 5)
                  {
                    localProgressBar.setVisibility(0);
                    ((PttAudioChangeView)localObject8).setVisibility(8);
                  }
                  if (paramInt == 6)
                  {
                    ((PttAudioChangeView)localObject8).setVisibility(0);
                    localProgressBar.setVisibility(8);
                  }
                  ((TextView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject9);
                  ((RelativeLayout)localObject2).addView((View)localObject8);
                  ((RelativeLayout)localObject2).addView(localProgressBar);
                  ((RelativeLayout)localObject2).addView((View)localObject7);
                  localObject9 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                  localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                  ((ImageView)localObject9).setLayoutParams(localLayoutParams2);
                  ((ImageView)localObject9).setImageResource(2130844025);
                  ((ImageView)localObject9).setScaleType(ImageView.ScaleType.FIT_END);
                  localLayoutParams1.addRule(3, 2131372932);
                  localLayoutParams1.addRule(14);
                  localLayoutParams2.addRule(3, 2131372952);
                  localLayoutParams2.addRule(14);
                  localLayoutParams2.addRule(6, 2131372948);
                  localLayoutParams2.addRule(8, 2131372948);
                  localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
                  localLayoutParams1.addRule(3, 2131372952);
                  ((RelativeLayout)localObject2).setLayoutParams(localLayoutParams1);
                  paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject6);
                  paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject2);
                  paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject9);
                  paramadwu.e = ((ImageView)localObject6);
                  paramadwu.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject7);
                  paramadwu.f = ((ImageView)localObject9);
                  paramadwu.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView = ((PttAudioChangeView)localObject8);
                  paramadwu.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
                  paramadwu.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
                  paramadwu.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(paramadwu.jdField_a_of_type_Acxn);
                  paramadwu.jdField_b_of_type_AndroidWidgetTextView.setOnLongClickListener(paramadwu.jdField_a_of_type_Acxn);
                  if ((paramInt != 5) && (paramInt != 6)) {
                    break label3734;
                  }
                  paramadwu.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, actn.a(17.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                  localObject2 = (RelativeLayout.LayoutParams)paramadwu.e.getLayoutParams();
                  ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131372932);
                  ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131372932);
                  localObject2 = (RelativeLayout.LayoutParams)paramadwu.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
                  ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131372932);
                  ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131372932);
                  i2 = actn.a(22.0F, (Resources)localObject5);
                  paramadwu.e.setPadding(m, 0, m, 0);
                  paramadwu.jdField_b_of_type_AndroidWidgetTextView.setPadding(m, BaseChatItemLayout.l, m, i2 + k);
                  paramadwu.f.setPadding(0, 0, 0, i1);
                  localObject5 = paramMessageForPtt.sttText;
                  if (paramInt != 5) {
                    break label3753;
                  }
                  localObject2 = (String)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramMessageForPtt.uniseq));
                  paramadwu.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
                }
                float f = 0.0F;
                if (j == 2)
                {
                  localObject5 = paramMessageForPtt.sttText;
                  localObject2 = localObject5;
                  if (TextUtils.isEmpty((CharSequence)localObject5)) {
                    localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131719804);
                  }
                  if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
                    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
                  }
                  this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
                  f = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText((String)localObject2);
                }
                k = m + 44 + (int)actn.a((int)paramadwu.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText((String)localObject4), this.jdField_a_of_type_AndroidContentContext.getResources());
                j = k;
                if (bool1) {
                  j = k + 16;
                }
                k = j;
                if (bool3) {
                  k = j + 38;
                }
                j = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt.voiceLength, f, k, n, bool1, bool3);
                localObject6 = (RelativeLayout.LayoutParams)paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
                ((RelativeLayout.LayoutParams)localObject6).width = j;
                localObject2 = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool4, bool1, j + m, paramadwu);
                localObject5 = (RelativeLayout.LayoutParams)paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
                ((RelativeLayout.LayoutParams)localObject5).width = (localObject2[0] + localObject2[1] + localObject2[2]);
                ((RelativeLayout.LayoutParams)localObject5).height = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool4, paramadwu);
                if (QLog.isColorLevel()) {
                  QLog.d("PttItemBuilder", 2, "message seq=" + paramMessageForPtt.uniseq + ", VpLp.width=" + ((RelativeLayout.LayoutParams)localObject5).width + ", flagTimeContainer.getLeft()=" + paramadwu.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft());
                }
                if ((!bool4) || (((RelativeLayout.LayoutParams)localObject5).height <= 0)) {
                  break label3797;
                }
                paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(8);
                paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
                Object localObject7 = paramadwu.jdField_a_of_type_Ambh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7);
                if ((((ambi)((Pair)localObject7).first).a != null) && (((ambi)((Pair)localObject7).first).a.length > 0))
                {
                  localObject6 = paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView;
                  localObject7 = (ambi)((Pair)localObject7).first;
                  j = localObject2[0];
                  k = ((RelativeLayout.LayoutParams)localObject5).height;
                  m = localObject2[1];
                  n = localObject2[2];
                  if (paramMessageForPtt.isSend()) {
                    break label3780;
                  }
                  bool1 = true;
                  ((VoicePrintUtils.VoicePrintView)localObject6).setBitmap((ambi)localObject7, j, k, m, n, bool1);
                  if (!paramBoolean) {
                    break label3786;
                  }
                  paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(false);
                }
                localObject2 = localObject1;
                localObject1 = localObject4;
                break;
                if (paramMessageForPtt.longPttVipFlag != 2) {
                  break label4032;
                }
                if (this.jdField_b_of_type_AndroidTextSpannableString == null)
                {
                  this.jdField_b_of_type_AndroidTextSpannableString = new SpannableString(ajyc.a(2131708717));
                  localObject1 = ((Resources)localObject5).getDrawable(2130840071);
                  ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
                  localObject1 = new bcni((Drawable)localObject1, 1).a(0.05F);
                  this.jdField_b_of_type_AndroidTextSpannableString.setSpan(localObject1, 0, 3, 17);
                }
                localObject2 = ajyc.a(2131708715);
                paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_b_of_type_AndroidTextSpannableString, this);
                break label1278;
                label3321:
                localObject1 = "vip";
                break label1321;
                paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject2, null);
                break label1548;
                localObject2 = ((balw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
                if (TextUtils.isEmpty((CharSequence)localObject2)) {
                  break label1548;
                }
                paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject2, null);
                break label1548;
                if (((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3)) && (this.jdField_a_of_type_Ayae.a(paramMessageForPtt)))
                {
                  j = 2;
                  i = paramInt;
                  paramInt = 5;
                  continue;
                }
                if ((paramMessageForPtt.sttAbility != 3) || (!paramMessageForPtt.expandStt)) {
                  break label4019;
                }
                j = 2;
                i = paramInt;
                paramInt = 6;
                continue;
                label3453:
                if ((paramInt == 1005) || (paramInt == 1004))
                {
                  paramInt = 1;
                  continue;
                }
                paramInt = 4;
              }
            }
            catch (Exception localException)
            {
              int n;
              for (;;)
              {
                Object localObject9;
                ProgressBar localProgressBar;
                Object localObject8;
                k = actn.a(24.0F, (Resources)localObject5);
                QLog.e("PttItemBuilder", 1, "", localException);
                continue;
                localException.width = actn.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
                paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPadding(actn.a(2.0F, (Resources)localObject5) + m, 0, m, 0);
                continue;
                label3544:
                localObject3 = ((Resources)localObject5).getColorStateList(2131166872);
                continue;
                label3557:
                ((RelativeLayout.LayoutParams)localObject9).leftMargin = actn.a(0.0F, (Resources)localObject5);
                ((PttAudioChangeView)localObject8).setVisibility(8);
                localProgressBar.setVisibility(8);
                continue;
                paramadwu.e.setVisibility(0);
                paramadwu.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramadwu.f.setVisibility(0);
                localObject3 = (RelativeLayout.LayoutParams)paramadwu.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
                if ((paramInt == 5) || (paramInt == 6))
                {
                  ((RelativeLayout.LayoutParams)localObject3).leftMargin = actn.a(25.0F, (Resources)localObject5);
                  if (paramInt == 5)
                  {
                    paramadwu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
                    paramadwu.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
                  }
                  if (paramInt == 6)
                  {
                    paramadwu.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(0);
                    paramadwu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
                  }
                }
                for (;;)
                {
                  paramadwu.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                  break;
                  ((RelativeLayout.LayoutParams)localObject3).leftMargin = actn.a(0.0F, (Resources)localObject5);
                  paramadwu.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
                  paramadwu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
                }
                paramadwu.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
                continue;
                localObject3 = localObject5;
                if (TextUtils.isEmpty((CharSequence)localObject5))
                {
                  localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131719804);
                  continue;
                  label3780:
                  bool1 = false;
                  continue;
                  label3786:
                  paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(true);
                }
              }
              label3797:
              if (paramMessageForPtt.voiceLength > 0) {
                paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramMessageForPtt.waveformArray, ((RelativeLayout.LayoutParams)localObject6).width - actn.a(n, this.jdField_a_of_type_AndroidContentContext.getResources()), paramMessageForPtt.voiceLength);
              }
              paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(0);
              paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
              localObject3 = localObject1;
              localObject1 = localObject4;
            }
          }
          break;
          paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
          localObject4 = paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c;
          if (paramMessageForPtt.isSendFromLocal()) {}
          for (paramMessageForPtt = ajyc.a(2131708719);; paramMessageForPtt = ajyc.a(2131708711))
          {
            ((ImageView)localObject4).setContentDescription(paramMessageForPtt);
            break;
          }
          paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839144, null);
          paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
          ((Animatable)paramadwu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getDrawable()).start();
          break label562;
          paramMessageForPtt = ajyc.a(2131708718);
          break label609;
          paramadwu.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject1 + ajyc.a(2131708723));
          break label681;
          i = paramInt;
        }
      }
      label3971:
      label3981:
      label4032:
      Object localObject3 = null;
      break label1278;
    }
  }
  
  protected void a(adwu paramadwu, MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      if (paramBoolean1) {
        i = 2;
      }
    }
    for (int j = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c;; j = 0)
    {
      aaod.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt, false, i, j, paramBoolean2);
      return;
      i = 1;
      break;
      i = 5;
    }
  }
  
  protected void a(adwu paramadwu, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramadwu.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(actn.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (paramBoolean3)
      {
        localObject = ((Resources)localObject).getDrawable(2130846146);
        if (localObject != null)
        {
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
          paramadwu.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
        }
      }
      do
      {
        return;
        localObject = ((Resources)localObject).getDrawable(2130846144);
      } while (localObject == null);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
      paramadwu.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
      return;
    }
    paramadwu.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
    paramadwu.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public void a(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)actn.a(paramView);
    paramView = (adwu)actn.a(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = bfol.a(this.jdField_a_of_type_AndroidContentContext);
      paramView.a(2131689996);
      paramView.b(2131689995);
      paramView.c(2131690596);
      paramView.a(new adwt(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    if ((!Environment.getExternalStorageState().equals("mounted")) || (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1))
    {
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        bcpw.a(BaseApplication.getContext(), 2131694692, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298865));
        return;
      }
      bcpw.a(BaseApplication.getContext(), 2131719048, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298865));
      return;
    }
    a(paramView, localMessageForPtt, true, false);
    if (QLog.isColorLevel()) {
      QLog.d("PTTItem->onErrorIconClick", 2, "fileStatus:2001|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
    }
    a(paramView, localMessageForPtt, 2001, false);
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return;
        paramView = (adwu)((View)paramView.getParent().getParent()).getTag();
      } while (paramView == null);
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getBackground();
    } while (paramView == null);
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  public void a(View paramView, ayqm paramayqm, int paramInt1, int paramInt2)
  {
    if ((paramayqm.jdField_b_of_type_Int != 2) || (paramInt1 == 2002) || (paramInt1 == 1002) || (paramInt1 == 2001)) {}
    MessageForPtt localMessageForPtt;
    do
    {
      do
      {
        return;
      } while (!(actn.a(paramView) instanceof MessageForPtt));
      localMessageForPtt = (MessageForPtt)actn.a(paramView);
    } while ((localMessageForPtt == null) || (localMessageForPtt.uniseq != paramayqm.jdField_b_of_type_Long));
    paramView = (adwu)actn.a(paramView);
    if ((paramInt1 == 1003) || (paramInt1 == 2003))
    {
      paramInt2 = paramInt1;
      if (!paramayqm.jdField_b_of_type_Boolean)
      {
        paramInt2 = paramInt1;
        if (paramInt1 == 2003)
        {
          b();
          paramInt2 = paramInt1;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->handleMessage", 2, "fileStatus:" + paramInt2 + "|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
      }
      a(paramView, localMessageForPtt, paramInt2, c(localMessageForPtt));
      return;
      if ((paramayqm.d == 1005) || (paramayqm.d == 1004))
      {
        this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
        paramInt2 = paramInt1;
      }
      else if (localMessageForPtt.fileSize == -2L)
      {
        paramInt2 = 999;
      }
      else if (localMessageForPtt.fileSize == -3L)
      {
        paramInt2 = 1001;
      }
      else if (localMessageForPtt.fileSize == -1L)
      {
        paramInt2 = 1005;
      }
      else
      {
        paramInt2 = paramInt1;
        if (paramInt1 == 2005)
        {
          localMessageForPtt.fileSize = -4L;
          paramInt2 = paramInt1;
        }
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    Object localObject = (MessageForPtt)paramChatMessage;
    if (paramInt == 889) {
      paramInt = 1;
    }
    for (;;)
    {
      if ((paramInt != 0) && (paramView != null))
      {
        localObject = (acun)paramView.getTag();
        paramView = (BaseChatItemLayout)paramView;
        b(paramChatMessage, (acun)localObject, ((acun)localObject).jdField_a_of_type_AndroidViewView, paramView, null);
      }
      return;
      super.a(paramView, paramChatMessage, paramInt);
      if (((MessageForPtt)localObject).voiceChangeFlag != 0) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        View localView;
        Object localObject;
        if ((paramView instanceof PttAudioWaveView))
        {
          localView = (View)paramView.getParent().getParent().getParent();
          localObject = (adwu)localView.getTag();
          if (localObject == null) {
            break label196;
          }
          localObject = ((adwu)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView;
          paramView = actn.a((View)paramView.getParent().getParent().getParent());
          if ((paramView == null) || (!(paramView instanceof MessageForPtt))) {
            break label196;
          }
          if (paramBoolean)
          {
            if (((MessageForPtt)paramView).playProgress <= 0.0F) {
              break label196;
            }
            ((PttAudioWaveView)localObject).setCanSupportSlide(true);
            break label196;
            a(localView, paramView);
          }
        }
        else
        {
          localView = (View)paramView.getParent().getParent();
          continue;
        }
        if (!c(paramView)) {
          break label196;
        }
        ((PttAudioWaveView)localObject).setCanSupportSlide(false);
      }
      catch (Exception paramView)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      QLog.d("PttItemBuilder", 2, "longClicked:" + paramView.toString());
      return;
      label196:
      while (!paramBoolean)
      {
        paramView = jdField_a_of_type_AndroidGraphicsColorFilter;
        break;
      }
      paramView = null;
    }
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "onStartSeek ");
    }
    paramPttAudioWaveView = (adwu)actn.a(paramPttAudioWaveView);
    if (paramPttAudioWaveView != null)
    {
      MediaPlayerManager localMediaPlayerManager = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localMediaPlayerManager.a(localMediaPlayerManager.a(), paramPttAudioWaveView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView, float paramFloat)
  {
    paramPttAudioWaveView = (adwu)actn.a(paramPttAudioWaveView);
    MessageForPtt localMessageForPtt;
    if (paramPttAudioWaveView != null)
    {
      localMessageForPtt = (MessageForPtt)paramPttAudioWaveView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (localMessageForPtt != null) {
        localMessageForPtt.playProgress = paramFloat;
      }
      if ((paramPttAudioWaveView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView == null) || (paramPttAudioWaveView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.a())) {
        break label50;
      }
    }
    label50:
    while (localMessageForPtt == null) {
      return;
    }
    int i = (int)(localMessageForPtt.voiceLength * 1000.0F * paramFloat);
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "onSeekProgressUpdate, offset = " + i);
    }
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localMessageForPtt, i);
  }
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean, adwu paramadwu)
  {
    this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramMessageForPtt.isSend())
    {
      if (d(paramMessageForPtt))
      {
        paramMessageForPtt = paramadwu.jdField_a_of_type_AndroidWidgetImageView;
        if (paramBoolean) {}
        for (i = 2130846142;; i = 2130846145)
        {
          paramMessageForPtt.setImageResource(i);
          return;
        }
      }
      paramMessageForPtt = paramadwu.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {}
      for (i = 2130848909;; i = 2130848910)
      {
        paramMessageForPtt.setImageResource(i);
        return;
      }
    }
    if (d(paramMessageForPtt))
    {
      paramMessageForPtt = paramadwu.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {}
      for (i = 2130846136;; i = 2130846143)
      {
        paramMessageForPtt.setImageResource(i);
        return;
      }
    }
    paramMessageForPtt = paramadwu.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i = 2130848903;; i = 2130848902)
    {
      paramMessageForPtt.setImageResource(i);
      return;
    }
  }
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, adwu paramadwu)
  {
    for (;;)
    {
      try
      {
        Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
        if ((paramBoolean1) && (!paramBoolean2))
        {
          if (paramMessageForPtt.isSend())
          {
            if (!d(paramMessageForPtt)) {
              break label140;
            }
            if (paramBoolean3)
            {
              i = 2130772240;
              paramMessageForPtt = (AnimationDrawable)localResources.getDrawable(i);
              paramadwu.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForPtt);
              paramMessageForPtt.start();
            }
          }
          else
          {
            if (!d(paramMessageForPtt)) {
              break label169;
            }
            if (!paramBoolean3) {
              break label161;
            }
            i = 2130772238;
            continue;
          }
        }
        else
        {
          a(paramMessageForPtt, paramBoolean3, paramadwu);
          return;
        }
      }
      catch (Throwable paramMessageForPtt)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PttItemBuilder", 2, "when handlePttFlagOnAnim throw a exception " + paramMessageForPtt);
        }
        return;
      }
      int i = 2130772239;
      continue;
      label140:
      if (paramBoolean3)
      {
        i = 2130772094;
      }
      else
      {
        i = 2130772093;
        continue;
        label161:
        i = 2130772237;
        continue;
        label169:
        if (paramBoolean3) {
          i = 2130772321;
        } else {
          i = 2130772320;
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null)
      {
        Message localMessage = new Message();
        localMessage.what = 78;
        localMessage.arg1 = 889;
        Bundle localBundle = new Bundle();
        localBundle.putLong("messageUniseq", paramMessageRecord.uniseq);
        localMessage.setData(localBundle);
        localMqqHandler.sendMessage(localMessage);
      }
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if ((paramView != null) && (paramFloat > 0.0F))
    {
      paramXListView = actn.a(paramView);
      if ((paramXListView instanceof adwu))
      {
        paramXListView = (adwu)paramXListView;
        if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null)
        {
          paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramFloat);
          if ((paramChatMessage instanceof MessageForPtt)) {
            ((MessageForPtt)paramChatMessage).playProgress = paramFloat;
          }
        }
      }
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramXListView = actn.a(paramView);
      if ((paramXListView instanceof adwu))
      {
        paramXListView = (adwu)paramXListView;
        paramView = (MessageForPtt)paramChatMessage;
        a(paramXListView, paramView, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView), false);
        if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null)
        {
          if (paramBoolean)
          {
            paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
            paramView.playProgress = 0.0F;
            paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
            paramXListView.a(false);
          }
          if ((!paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.d) && (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null)) {
            paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
          }
        }
      }
    }
    c();
    if ((paramBoolean) && ((paramChatMessage instanceof MessageForPtt))) {
      ((MessageForPtt)paramChatMessage).playSpeedPos = MediaPlayerManager.a;
    }
  }
  
  public void a(String paramString, MessageForPtt paramMessageForPtt)
  {
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramMessageForPtt.uniseq), paramString);
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, MessageForPtt paramMessageForPtt)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramMessageForPtt.uniseq));
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public boolean a(acun paramacun)
  {
    return paramacun instanceof adwu;
  }
  
  protected boolean a(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, acun paramacun, MessageForPtt paramMessageForPtt)
  {
    return VoicePrintUtils.a(paramQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramBaseAdapter, paramacun, paramMessageForPtt);
  }
  
  protected boolean a(MessageForPtt paramMessageForPtt, adwu paramadwu)
  {
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = true;
    Object localObject;
    if (ahjm.a(paramMessageForPtt)) {
      if (CustomizeStrategyFactory.a().a())
      {
        localObject = (agzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245);
        if (localObject != null)
        {
          i = ((agzf)localObject).a("voice_pwd", 1, new String[] { "scoreSwitch" });
          if (i != 1) {
            break label351;
          }
          String str = paramMessageForPtt.getExtInfoFromExtStr("voice_score_id");
          if (TextUtils.isEmpty(str)) {
            break label213;
          }
          localObject = new CustomizeStrategyFactory.RedPacketInfo();
          ((CustomizeStrategyFactory.RedPacketInfo)localObject).a = paramMessageForPtt;
          ((CustomizeStrategyFactory.RedPacketInfo)localObject).type = 6;
          ((CustomizeStrategyFactory.RedPacketInfo)localObject).templateId = str;
          paramMessageForPtt = CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (CustomizeStrategyFactory.RedPacketInfo)localObject, this);
          if (QLog.isColorLevel()) {
            QLog.d("PttItemBuilder", 2, "redPacketInfo.icon = " + paramMessageForPtt.icon);
          }
          if (paramMessageForPtt.icon == null) {
            break label388;
          }
          paramadwu.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramMessageForPtt.icon);
        }
      }
    }
    label388:
    for (int i = 1;; i = 0)
    {
      bool1 = false;
      for (;;)
      {
        label188:
        paramMessageForPtt = paramadwu.jdField_b_of_type_AndroidWidgetImageView;
        if (i != 0)
        {
          i = j;
          label200:
          paramMessageForPtt.setVisibility(i);
        }
        label213:
        label351:
        do
        {
          for (;;)
          {
            return bool1;
            i = 1;
            break;
            try
            {
              i = Integer.parseInt(paramMessageForPtt.getExtInfoFromExtStr("voice_low_tips_tag"));
              if (i == 1)
              {
                bool1 = true;
                if (bool1) {
                  break label383;
                }
                i = ((agzf)localObject).a("voice_pwd", 5, new String[] { "lowTipsLimit" });
                int k = agxc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "voice_low_tips_count", 0);
                if (k >= i) {
                  break label383;
                }
                paramMessageForPtt.saveExtInfoToExtStr("voice_low_tips_tag", "1");
                ThreadManager.post(new PttItemBuilder.2(this, paramMessageForPtt), 10, null, false);
                agxc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "voice_low_tips_count", k + 1);
                i = 0;
                bool1 = bool2;
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                i = 0;
                continue;
                bool1 = false;
              }
            }
          }
          CustomizeStrategyFactory.a().b(true);
          i = 0;
          bool1 = false;
          break label188;
          i = 8;
          break label200;
        } while (paramadwu.jdField_b_of_type_AndroidWidgetImageView == null);
        paramadwu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        return false;
        label383:
        i = 0;
      }
    }
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    return (!paramXListView.isSend()) && (!paramXListView.isReadPtt) && (paramXListView.isReady());
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer, int paramInt2)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    avch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramXListView);
    if (paramXListView.isReady())
    {
      paramView = actn.a(paramView);
      if ((paramView != null) && (!(paramView instanceof adwu))) {
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "play failed not Holder " + paramXListView.getLocalFilePath());
        }
      }
      do
      {
        return false;
        paramView = (adwu)paramView;
      } while (paramAudioPlayer == null);
      paramAudioPlayer.a(paramXListView.playSpeedPos);
      paramAudioPlayer.a(paramXListView.time);
      if (paramAudioPlayer.a(paramXListView.getLocalFilePath(), paramInt2))
      {
        a(paramXListView);
        if (paramView != null)
        {
          a(paramView, paramXListView, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView), true);
          if (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
            paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          }
          if (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
            paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
          }
          paramView.a(true);
          a(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout, paramXListView, paramView.jdField_a_of_type_Ambh, 0);
        }
        aytl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView.istroop, paramXListView.issend);
        if (!paramXListView.isSendFromLocal())
        {
          if (paramXListView.istroop != 0) {
            break label253;
          }
          paramInt1 = 1;
        }
      }
    }
    for (;;)
    {
      paramXListView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramChatMessage.getPttStreamFlag() == 10001) {}
      for (boolean bool = true;; bool = false)
      {
        aytl.a(paramXListView, paramInt1, bool, 1);
        return true;
        label253:
        if (paramXListView.istroop == 1)
        {
          paramInt1 = 3;
          break;
        }
        if (paramXListView.istroop != 3000) {
          break label361;
        }
        paramInt1 = 2;
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PttItemBuilder", 2, "play failed player return false " + paramXListView.getLocalFilePath());
      return false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PttItemBuilder", 2, "play failed not ready " + paramXListView.getLocalFilePath());
      return false;
      label361:
      paramInt1 = 4;
    }
  }
  
  public bblt[] a(View paramView)
  {
    bblr localbblr = new bblr();
    MessageForPtt localMessageForPtt = (MessageForPtt)actn.a(paramView);
    if (amns.a(localMessageForPtt)) {
      return localbblr.a();
    }
    if (!localMessageForPtt.isReady())
    {
      aaod.a(localbblr, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.c(localbblr, this.jdField_a_of_type_AndroidContentContext);
      super.e(localbblr, this.jdField_a_of_type_AndroidContentContext);
      return localbblr.a();
    }
    if (QQRecorder.a(localMessageForPtt) <= 0)
    {
      aaod.a(localbblr, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.c(localbblr, this.jdField_a_of_type_AndroidContentContext);
      super.e(localbblr, this.jdField_a_of_type_AndroidContentContext);
      return localbblr.a();
    }
    if (c(localMessageForPtt)) {
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
    }
    paramView = (adwu)actn.a(paramView);
    if (((paramView != null) && ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForLightVideo))) || (actn.b()))
    {
      if (((localMessageForPtt.extraflag != 32768) && (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt) == 1003) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForPtt))) || (bamn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        a(localbblr, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPtt);
      }
      if (adwv.c)
      {
        boolean bool1 = MediaPlayerManager.a(localMessageForPtt.playSpeedPos, MediaPlayerManager.a);
        boolean bool2 = MediaPlayerManager.a(localMessageForPtt.playSpeedPos, MediaPlayerManager.b);
        boolean bool3 = MediaPlayerManager.a(localMessageForPtt.playSpeedPos, MediaPlayerManager.c);
        if (!bool1) {
          localbblr.a(2131376390, this.jdField_a_of_type_AndroidContentContext.getString(2131695202), 2130838603);
        }
        if (!bool2) {
          localbblr.a(2131376391, this.jdField_a_of_type_AndroidContentContext.getString(2131695201), 2130838603);
        }
        if (!bool3) {
          localbblr.a(2131376388, this.jdField_a_of_type_AndroidContentContext.getString(2131695197), 2130838603);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "getMenuItem speed:" + localMessageForPtt.playSpeedPos);
        }
      }
      if (localMessageForPtt.voiceChangeFlag != 1)
      {
        if ((localMessageForPtt.sttAbility != 1) && (localMessageForPtt.sttAbility != 3)) {
          break label667;
        }
        if ((!this.jdField_a_of_type_Ayae.a(localMessageForPtt)) && ((!localMessageForPtt.isSend()) || (localMessageForPtt.fileSize > 0L)) && (!ahjm.a(localMessageForPtt))) {
          localbblr.a(2131376584, this.jdField_a_of_type_AndroidContentContext.getString(2131719805), 2130838596);
        }
      }
    }
    for (;;)
    {
      a(localMessageForPtt, localbblr);
      localbblr.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691237));
      a(localbblr, localMessageForPtt);
      localbblr.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131692324), 2130838605);
      b(localMessageForPtt, localbblr);
      super.c(localbblr, this.jdField_a_of_type_AndroidContentContext);
      super.e(localbblr, this.jdField_a_of_type_AndroidContentContext);
      return localbblr.a();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l))
      {
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131695198);
        label612:
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l)) {
          break label660;
        }
      }
      label660:
      for (int i = 2130838603;; i = 2130838607)
      {
        localbblr.a(2131371749, paramView, i);
        break;
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131695200);
        break label612;
      }
      label667:
      if (localMessageForPtt.sttAbility == 2) {
        if (localMessageForPtt.expandStt)
        {
          localbblr.a(2131364825, this.jdField_a_of_type_AndroidContentContext.getString(2131719803), 2130838599);
          localbblr.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131690012), 2130838606);
        }
        else if (!ahjm.a(localMessageForPtt))
        {
          localbblr.a(2131376584, this.jdField_a_of_type_AndroidContentContext.getString(2131719805), 2130838596);
        }
      }
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "1", "", "", "");
  }
  
  protected View b(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    paramBaseChatItemLayout = (adwu)paramacun;
    this.jdField_a_of_type_JavaUtilSet.add(paramBaseChatItemLayout);
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramacun = paramView;
    if (paramView == null)
    {
      paramacun = new BreathAnimationLayout(this.jdField_a_of_type_AndroidContentContext);
      paramacun.setId(2131372929);
      paramView = new PttAudioPlayView(this.jdField_a_of_type_AndroidContentContext, 12);
      paramView.setThemeColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166872).getDefaultColor());
      paramView.setId(2131372934);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject1).width = actn.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject1).height = actn.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new PttAudioChangeView(this.jdField_a_of_type_AndroidContentContext, 2130838046, 8);
      ((PttAudioChangeView)localObject1).setThemeColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166872).getDefaultColor());
      ((PttAudioChangeView)localObject1).setId(2131372940);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject2).width = actn.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject2).height = actn.a(19.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((PttAudioChangeView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new PttAudioWaveView(this.jdField_a_of_type_AndroidContentContext);
      ((PttAudioWaveView)localObject2).setProgressColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166872).getDefaultColor());
      ((PttAudioWaveView)localObject2).setId(2131372935);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject3).width = actn.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject3).height = actn.a(52.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((PttAudioWaveView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject3).setId(2131372936);
      ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166872));
      VoicePrintUtils.VoicePrintView localVoicePrintView = new VoicePrintUtils.VoicePrintView(this.jdField_a_of_type_AndroidContentContext);
      localVoicePrintView.setId(2131372937);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setId(2131372939);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      localVoicePrintView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject4).width = actn.a(47.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject4).height = actn.a(41.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new SyncParentPressedRelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject4).setId(2131372932);
      ((RelativeLayout)localObject4).addView((View)localObject2);
      ((RelativeLayout)localObject4).addView(paramView);
      ((RelativeLayout)localObject4).addView((View)localObject1);
      ((RelativeLayout)localObject4).addView((View)localObject3);
      ((RelativeLayout)localObject4).addView(localVoicePrintView);
      ((RelativeLayout)localObject4).addView(localImageView);
      paramacun.addView((View)localObject4);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = paramacun;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView = ((PttAudioChangeView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject2);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView = localVoicePrintView;
      paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView = localImageView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject4);
    }
    if (paramacxn != null) {
      paramBaseChatItemLayout.jdField_a_of_type_Acxn = paramacxn;
    }
    int i;
    boolean bool;
    if (localMessageForPtt.voiceChangeFlag != 0)
    {
      i = 1;
      bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramBaseChatItemLayout, localMessageForPtt);
      if (!bool) {
        break label1069;
      }
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
      if (!paramChatMessage.isSend()) {
        break label1356;
      }
      paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (!bool) {
        break label1275;
      }
      paramView.addRule(1, 2131372937);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, 2131372939);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, -1);
    }
    for (;;)
    {
      int j = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt);
      i = j;
      if (j == -1)
      {
        a(paramBaseChatItemLayout, localMessageForPtt, false, true);
        i = 2001;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + i + " url " + localMessageForPtt.url + " uniseq " + localMessageForPtt.uniseq);
      }
      if (((localMessageForPtt.istroop == 1) || (localMessageForPtt.istroop == 3000)) && (i == 2003) && (this.jdField_a_of_type_Ayae.b(localMessageForPtt)))
      {
        a(localMessageForPtt, 2);
        axqw.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
      }
      a(paramBaseChatItemLayout, localMessageForPtt, i, c(localMessageForPtt));
      avch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(localMessageForPtt);
      aytl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramChatMessage);
      return paramacun;
      i = 0;
      break;
      label1069:
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(0);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnClickListener(this);
      if (i != 0) {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(0);
      }
      for (;;)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnTouchListener(paramBaseChatItemLayout.jdField_a_of_type_Acxn);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnLongClickListener(paramBaseChatItemLayout.jdField_a_of_type_Acxn);
        if ((!c(paramChatMessage)) && (!paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.d)) {
          break label1205;
        }
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
        paramBaseChatItemLayout.a(true);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
        break;
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
      }
      label1205:
      if (((MessageForPtt)paramChatMessage).playProgress > 0.0F)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
        paramBaseChatItemLayout.a(true);
      }
      for (;;)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(localMessageForPtt.playProgress);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
        break;
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
        paramBaseChatItemLayout.a(false);
      }
      label1275:
      paramView.addRule(1, 2131372935);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131372940);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getLayoutParams()).addRule(1, 2131372939);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131372934);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
      continue;
      label1356:
      if (bool)
      {
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131372936);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131372937);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, -1);
      }
      else
      {
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131372935);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131372940);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getLayoutParams()).addRule(1, 2131372939);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131372934);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
      }
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  protected boolean c(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    return (localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForPtt)) && (localChatMessage.frienduin != null) && (localChatMessage.frienduin.equals(paramChatMessage.frienduin)) && (localChatMessage.uniseq == paramChatMessage.uniseq));
  }
  
  public void d()
  {
    aytl.a(7);
    super.d();
  }
  
  public void onClick(View paramView)
  {
    actn.n = true;
    int i = paramView.getId();
    if ((AppSetting.d) && (i == 2131363077)) {
      paramView.findViewById(2131372932).performClick();
    }
    do
    {
      Object localObject1;
      Object localObject2;
      do
      {
        do
        {
          return;
          localObject1 = (adwu)actn.a(paramView);
          localObject2 = (MessageForPtt)((adwu)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          if ((i != 2131372932) && (i != 2131372935)) {
            break;
          }
        } while (localObject2 == null);
        if (c((ChatMessage)localObject2))
        {
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
          axqw.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 2, 0, "", "", "", "");
        }
        for (;;)
        {
          if (((MessageForPtt)localObject2).istroop == 1008) {
            noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", ((MessageForPtt)localObject2).timeStr, "", false);
          }
          if (((MessageForPtt)localObject2).voiceChangeFlag != 1) {
            break;
          }
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F7E", 0, 0, "" + ((MessageForPtt)localObject2).istroop, "", "", "");
          return;
          if ((localObject2 != MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (((MessageForPtt)localObject2).isReady())) {
            a((adwu)localObject1, (MessageForPtt)localObject2, paramView);
          }
        }
        if (i != 2131372951) {
          break;
        }
      } while ((localObject2 == null) || (!((MessageForPtt)localObject2).expandStt));
      ((MessageForPtt)localObject2).expandStt = false;
      ((MessageForPtt)localObject2).serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((MessageForPtt)localObject2).uniseq, ((MessageForPtt)localObject2).msgData);
      a((adwu)localObject1, (MessageForPtt)localObject2, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForPtt)localObject2), c((ChatMessage)localObject2));
      axqw.b(null, "dc00898", "", "", "0X8009DF8", "0X8009DF8", 0, 0, "", "", "", "");
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
      return;
      if (i != 2131364139) {
        break;
      }
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject2 = nam.a();
        if (VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
        for (paramView = "svip";; paramView = "vip")
        {
          VasWebviewUtil.reportCommercialDrainage((String)localObject1, "LongVoice", "TailClick", "0", 1, 0, 0, (String)localObject2, "", paramView);
          paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          paramView.putExtra("url", "https://m.vip.qq.com/freedom/xhycyy.html?_nav_alpha=0");
          this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PttItemBuilder", 2, "chat_item_tail_message onclick nullpoint");
    return;
    super.onClick(paramView);
  }
  
  public void onSucc(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
    } while (paramRedPacketInfo.icon == null);
    a(paramRedPacketInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adwr
 * JD-Core Version:    0.7.0.1
 */