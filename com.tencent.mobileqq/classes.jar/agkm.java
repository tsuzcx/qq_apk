import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import android.support.annotation.Nullable;
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
import com.etrump.mixlayout.ETTextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PttAudioChangeView;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder.2;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder.4;
import com.tencent.mobileqq.activity.aio.item.SyncParentPressedRelativeLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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

public class agkm
  extends BaseBubbleBuilder
  implements aeze, aezk, afaf, afbb, afbz, agkl, bcmu
{
  protected SpannableString a;
  protected TextView a;
  protected bcms a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  protected Map<Long, String> a;
  Set<agkp> jdField_a_of_type_JavaUtilSet = new HashSet();
  protected SpannableString b;
  
  public agkm(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Bcms = ((bcms)paramQQAppInterface.getManager(17));
    this.jdField_a_of_type_Bcms.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private int a(agkp paramagkp, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramMessageForPtt.voiceChangeFlag != 0) {}
    boolean bool2;
    Resources localResources;
    int i;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramagkp, paramMessageForPtt);
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      i = AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      switch (paramInt)
      {
      default: 
        return 0;
      }
    }
    return 7;
    paramagkp.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    paramagkp.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.dp2px(10.0F, localResources), BaseChatItemLayout.m, AIOUtils.dp2px(10.0F, localResources), BaseChatItemLayout.n);
    if (paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    }
    a(paramagkp, bool2, bool1, paramMessageForPtt.isSend());
    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
    ((RelativeLayout.LayoutParams)paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
    return 1;
    ((RelativeLayout.LayoutParams)paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
    paramagkp.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    paramagkp.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.dp2px(40.0F, localResources), BaseChatItemLayout.m, AIOUtils.dp2px(40.0F, localResources), BaseChatItemLayout.n);
    if (paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    }
    if (paramInt == 999)
    {
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(8);
      return 0;
    }
    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
    return 0;
    return b(paramagkp, paramMessageForPtt, paramInt, paramBoolean, paramString);
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
      paramInt1 = AIOUtils.dp2px(paramInt1, paramContext.getResources());
      if (paramFloat <= 0.0F) {
        break label196;
      }
      paramInt1 = Math.max(paramInt1 + AIOUtils.dp2px(paramInt2, paramContext.getResources()) + AIOUtils.dp2px(paramInt3, paramContext.getResources()), (int)paramFloat);
      paramInt3 = BaseChatItemLayout.f - BaseChatItemLayout.j - BaseChatItemLayout.k - 32;
      if (paramInt1 <= paramInt3) {
        break label209;
      }
      paramInt1 = paramInt3;
    }
    label196:
    label209:
    for (;;)
    {
      return paramInt1 - AIOUtils.dp2px(paramInt2 - 40, paramContext.getResources());
      paramInt1 = 15 + (int)(PttAudioWaveView.a(paramInt1, 60, 1.5F) * 125.0F);
      break;
      return paramInt1 + AIOUtils.dp2px(paramInt3, paramContext.getResources());
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
      j = AIOUtils.dp2px(i + 20, paramContext.getResources());
      if ((paramString == null) || (paramPaint == null)) {
        break label173;
      }
      i = BaseChatItemLayout.f - BaseChatItemLayout.j - BaseChatItemLayout.k - 32;
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
        int k = AIOUtils.dp2px(f2, paramContext.getResources());
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
      if ((paramMessageForPtt.url != null) && (paramMessageForPtt.url.startsWith(AppConstants.SDCARD_ROOT))) {
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
            boolean bool = paramQQAppInterface.getTransFileController().containsProcessor(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
            k = paramQQAppInterface.getTransFileController().findProcessorFileStatus(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
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
          j = paramQQAppInterface.getTransFileController().findProcessorFileStatus(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
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
              j = azck.a(paramQQAppInterface, paramMessageForPtt);
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
    paramQQAppInterface = paramQQAppInterface.getServerConfigValue(ServerConfigManager.ConfigType.common, paramString);
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
  
  public static int a(MessageForPtt paramMessageForPtt, int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = (bcmt)paramQQAppInterface.getManager(17);; paramQQAppInterface = null)
    {
      int i = 0;
      if ((paramInt == 2003) || (paramInt == 1003))
      {
        if (((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3)) && (paramQQAppInterface != null) && (paramQQAppInterface.a(paramMessageForPtt))) {
          paramInt = 5;
        }
        do
        {
          do
          {
            return paramInt;
            paramInt = i;
          } while (paramMessageForPtt.sttAbility != 3);
          paramInt = i;
        } while (!paramMessageForPtt.expandStt);
        return 6;
      }
      if ((paramInt == 1005) || (paramInt == 1004)) {
        return 1;
      }
      return 4;
    }
  }
  
  private CharSequence a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    String str = paramMessageForPtt.sttText;
    Object localObject;
    if (paramInt == 5)
    {
      localObject = a();
      if ((localObject != null) && (paramMessageForPtt.getSttResult().a())) {
        localObject = ((afry)localObject).a(paramMessageForPtt);
      }
    }
    do
    {
      return localObject;
      return (CharSequence)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramMessageForPtt.uniseq));
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    if (paramMessageForPtt.sttAbility == 3) {
      return "";
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131718622);
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
  
  private String a(int paramInt, MessageForPtt paramMessageForPtt)
  {
    if ((paramInt == 1001) || (paramInt == 1002) || (paramInt == 1005) || (paramInt == 1004) || (paramInt == 2003) || (paramInt == 1003))
    {
      if ((TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
        paramMessageForPtt.timeStr = a(paramMessageForPtt.voiceLength);
      }
      return paramMessageForPtt.timeStr;
    }
    return "";
  }
  
  private String a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    Object localObject = paramMessageForPtt.sttText;
    if (paramInt == 5)
    {
      localObject = a();
      if ((localObject != null) && (paramMessageForPtt.getSttResult().a())) {
        paramMessageForPtt = ((afry)localObject).a(paramMessageForPtt);
      }
    }
    do
    {
      return paramMessageForPtt;
      return (String)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramMessageForPtt.uniseq));
      paramMessageForPtt = (MessageForPtt)localObject;
    } while (!TextUtils.isEmpty((CharSequence)localObject));
    return this.jdField_a_of_type_AndroidContentContext.getString(2131718622);
  }
  
  private void a(int paramInt, agkp paramagkp)
  {
    if (paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(paramInt);
    }
    if (paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(paramInt);
    }
    if (paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) {
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(paramInt);
    }
  }
  
  public static void a(agkp paramagkp, MessageForPtt paramMessageForPtt, int paramInt1, boolean paramBoolean1, String paramString1, boolean paramBoolean2, QQAppInterface paramQQAppInterface, int paramInt2, String paramString2)
  {
    Object localObject1 = null;
    if (paramQQAppInterface != null) {
      localObject1 = paramQQAppInterface.getApp().getApplicationContext();
    }
    if (localObject1 == null) {}
    boolean bool1;
    Object localObject2;
    do
    {
      return;
      boolean bool2 = akgt.a(paramMessageForPtt);
      if (paramMessageForPtt.voiceChangeFlag == 0) {
        break;
      }
      bool1 = true;
      localObject2 = ((Context)localObject1).getResources();
      i = AIOUtils.dp2px(1.5F, (Resources)localObject2);
      j = AIOUtils.dp2px(9.0F, (Resources)localObject2);
      float f = 0.0F;
      if (paramInt1 == 2)
      {
        localObject2 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          localObject2 = ((Context)localObject1).getString(2131718622);
        }
        paramString2 = new TextView((Context)localObject1);
        paramString2.setTextSize(0, paramInt2);
        f = paramString2.getPaint().measureText((String)localObject2);
      }
      paramInt2 = j + 44 + (int)AIOUtils.px2dp((int)paramagkp.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(paramString1), ((Context)localObject1).getResources());
      paramInt1 = paramInt2;
      if (bool1) {
        paramInt1 = paramInt2 + 16;
      }
      paramInt2 = paramInt1;
      if (bool2) {
        paramInt2 = paramInt1 + 38;
      }
      paramInt1 = a((Context)localObject1, paramMessageForPtt.voiceLength, f, paramInt2, i, bool1, bool2);
      localObject2 = (RelativeLayout.LayoutParams)paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = paramInt1;
      paramString1 = VoicePrintUtils.a(paramQQAppInterface, paramBoolean1, bool1, paramInt1 + j, paramagkp);
      paramString2 = (RelativeLayout.LayoutParams)paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
      paramString2.width = (paramString1[0] + paramString1[1] + paramString1[2]);
      paramString2.height = VoicePrintUtils.a(paramQQAppInterface, paramBoolean1, paramagkp);
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "message seq=" + paramMessageForPtt.uniseq + ", VpLp.width=" + paramString2.width + ", flagTimeContainer.getLeft()=" + paramagkp.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft());
      }
      if ((!paramBoolean1) || (paramString2.height <= 0)) {
        break label516;
      }
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(8);
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
      localObject1 = paramagkp.jdField_a_of_type_Apee.a(paramQQAppInterface, 7);
    } while ((((apef)((Pair)localObject1).first).a == null) || (((apef)((Pair)localObject1).first).a.length <= 0));
    paramQQAppInterface = paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView;
    localObject1 = (apef)((Pair)localObject1).first;
    paramInt1 = paramString1[0];
    paramInt2 = paramString2.height;
    int i = paramString1[1];
    int j = paramString1[2];
    if (!paramMessageForPtt.isSend()) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramQQAppInterface.setBitmap((apef)localObject1, paramInt1, paramInt2, i, j, paramBoolean1);
      if (!paramBoolean2) {
        break label507;
      }
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(false);
      return;
      bool1 = false;
      break;
    }
    label507:
    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(true);
    return;
    label516:
    if (paramMessageForPtt.voiceLength > 0) {
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramMessageForPtt.waveformArray, ((RelativeLayout.LayoutParams)localObject2).width - AIOUtils.dp2px(i, ((Context)localObject1).getResources()), paramMessageForPtt.voiceLength);
    }
    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(0);
    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
  }
  
  private void a(agkp paramagkp, MessageForPtt paramMessageForPtt, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694732, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
      return;
    }
    if (!FileUtil.fileExistsAndNotEmpty(paramMessageForPtt.getLocalFilePath()))
    {
      a(paramagkp, paramMessageForPtt, false, true);
      a(paramagkp, paramMessageForPtt, 5003, false);
      return;
    }
    PttAudioWaveView localPttAudioWaveView = (PttAudioWaveView)paramView.findViewById(2131374014);
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
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramagkp.jdField_b_of_type_Int);
      bcef.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 1, 0, "", "", "", "");
      if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(AIOUtils.getMessage(paramView), i)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694731, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
      return;
      i = (int)(paramMessageForPtt.voiceLength * 1000.0F * f);
      continue;
      i = 0;
    }
  }
  
  private void a(agkp paramagkp, MessageForPtt paramMessageForPtt, boolean paramBoolean)
  {
    paramagkp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    if (paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      if ((this.jdField_a_of_type_Bcms.a(paramMessageForPtt)) && (!paramMessageForPtt.getSttResult().a())) {
        paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(PttAudioWaveView.a(-16777216, 0.5F));
      }
    }
    if (paramagkp.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramagkp.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    if (!paramBoolean) {
      a(-16777216, paramagkp);
    }
  }
  
  private void a(agkp paramagkp, MessageForPtt paramMessageForPtt, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int j = AIOUtils.dp2px(9.0F, localResources);
    int n = AIOUtils.dp2px(1.5F, localResources);
    int k = AIOUtils.dp2px(12.0F, localResources);
    int m = AIOUtils.dp2px(10.0F, localResources);
    try
    {
      i = localResources.getDrawable(2130844725).getIntrinsicHeight();
      int i1 = AIOUtils.dp2px(1.0F, localResources);
      int i2 = AIOUtils.dp2px(1.5F, localResources);
      paramagkp.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setPadding(0, 0, n, 0);
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setPadding(0, 0, i2, 0);
      Object localObject1 = (RelativeLayout.LayoutParams)paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams();
      if (paramBoolean)
      {
        ((RelativeLayout.LayoutParams)localObject1).width = AIOUtils.dp2px(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPadding(AIOUtils.dp2px(2.0F, localResources) + j, 0, 0, 0);
        if (paramInt1 == 2)
        {
          if (paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
            break label1238;
          }
          ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localImageView.setImageDrawable(new ColorDrawable(838860800));
          RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i1);
          localImageView.setLayoutParams(localLayoutParams1);
          localImageView.setId(2131374031);
          ETTextView localETTextView = new ETTextView(this.jdField_a_of_type_AndroidContentContext);
          if (!paramMessageForPtt.isSend()) {
            break label1190;
          }
          localObject1 = localResources.getColorStateList(2131167035);
          if (localObject1 != null)
          {
            localETTextView.setTextColor((ColorStateList)localObject1);
            if ((paramInt2 == 5) && (paramagkp.jdField_a_of_type_Apee != null) && (paramagkp.jdField_a_of_type_Apee.jdField_b_of_type_Int != 0)) {
              localETTextView.setTextColor(PttAudioWaveView.a(paramagkp.jdField_a_of_type_Apee.jdField_b_of_type_Int, 0.5F));
            }
          }
          localETTextView.setId(2131374030);
          localETTextView.setMaxWidth(BaseChatItemLayout.f);
          localObject4 = new RelativeLayout.LayoutParams(-2, -2);
          localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          ((RelativeLayout)localObject1).setId(2131374027);
          localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
          localProgressBar.setId(2131374028);
          localObject3 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localProgressBar.setIndeterminate(true);
          localProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839445));
          ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(13.0F, localResources);
          ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.dp2px(16.0F, localResources);
          localProgressBar.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject3 = new TextView(BaseApplicationImpl.getContext());
          RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
          ((TextView)localObject3).setLayoutParams(localLayoutParams2);
          ((TextView)localObject3).setText(2131718620);
          ((TextView)localObject3).setTextSize(AIOUtils.dp2px(4.0F, localResources));
          ((TextView)localObject3).setIncludeFontPadding(false);
          localLayoutParams2.addRule(5, 2131374030);
          localLayoutParams2.addRule(8, 2131374024);
          if ((paramInt2 != 5) && (paramInt2 != 6)) {
            break label1203;
          }
          ((RelativeLayout.LayoutParams)localObject4).leftMargin = AIOUtils.dp2px(25.0F, localResources);
          if (paramInt2 == 5)
          {
            localProgressBar.setVisibility(0);
            ((TextView)localObject3).setVisibility(8);
          }
          if (paramInt2 == 6)
          {
            localProgressBar.setVisibility(8);
            ((TextView)localObject3).setVisibility(0);
            ((TextView)localObject3).setText(2131718618);
          }
          localETTextView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          ((RelativeLayout)localObject1).addView(localProgressBar);
          ((RelativeLayout)localObject1).addView(localETTextView);
          localObject4 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject4).setId(2131374024);
          localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
          ((ImageView)localObject4).setLayoutParams(localLayoutParams2);
          ((ImageView)localObject4).setImageResource(2130844725);
          ((ImageView)localObject4).setScaleType(ImageView.ScaleType.FIT_END);
          ((ImageView)localObject4).setOnClickListener(this);
          localLayoutParams1.addRule(3, 2131374011);
          localLayoutParams1.addRule(14);
          localLayoutParams2.addRule(3, 2131374031);
          localLayoutParams2.addRule(14);
          localLayoutParams2.addRule(6, 2131374027);
          localLayoutParams2.addRule(8, 2131374027);
          localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams1.addRule(3, 2131374031);
          ((RelativeLayout)localObject1).setLayoutParams(localLayoutParams1);
          paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localImageView);
          paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject1);
          paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject4);
          paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject3);
          paramagkp.e = localImageView;
          paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView = localETTextView;
          paramagkp.f = ((ImageView)localObject4);
          paramagkp.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject3);
          paramagkp.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
          paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this);
          paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnTouchListener(paramagkp.jdField_a_of_type_Afce);
          paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnLongClickListener(paramagkp.jdField_a_of_type_Afce);
          if ((paramInt2 != 5) && (paramInt2 != 6)) {
            break label1421;
          }
          paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(0, AIOUtils.dp2px(17.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramagkp.jdField_a_of_type_Akxy = new akxy();
          paramagkp.jdField_a_of_type_Akxy.a(paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView);
          paramagkp.jdField_a_of_type_Akxy.a(paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
          paramagkp.jdField_a_of_type_Akxy.b(paramMessageForPtt);
          localObject1 = (RelativeLayout.LayoutParams)paramagkp.e.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131374011);
          ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131374011);
          localObject1 = (RelativeLayout.LayoutParams)paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131374011);
          ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131374011);
          paramInt1 = AIOUtils.dp2px(22.0F, localResources);
          paramagkp.e.setPadding(j, 0, j, 0);
          paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(j, BaseChatItemLayout.m, j, paramInt1 + i);
          paramagkp.f.setPadding(0, 0, 0, k);
          paramagkp.jdField_b_of_type_AndroidWidgetTextView.setPadding(j, 0, 0, m);
          paramMessageForPtt = a(paramMessageForPtt, paramInt2);
          paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(paramMessageForPtt);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject4;
        ProgressBar localProgressBar;
        Object localObject3;
        int i = AIOUtils.dp2px(24.0F, localResources);
        QLog.e("PttItemBuilder", 1, "", localException);
        continue;
        localException.width = AIOUtils.dp2px(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPadding(AIOUtils.dp2px(2.0F, localResources) + j, 0, j, 0);
        continue;
        label1190:
        Object localObject2 = localResources.getColorStateList(2131167031);
        continue;
        label1203:
        ((RelativeLayout.LayoutParams)localObject4).leftMargin = AIOUtils.dp2px(0.0F, localResources);
        localProgressBar.setVisibility(8);
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject3).setText(2131718620);
        continue;
        label1238:
        paramagkp.e.setVisibility(0);
        paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
        paramagkp.f.setVisibility(0);
        localObject2 = (RelativeLayout.LayoutParams)paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
        if ((paramInt2 == 5) || (paramInt2 == 6))
        {
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(25.0F, localResources);
          if (paramInt2 == 5)
          {
            paramagkp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            paramagkp.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          if (paramInt2 == 6)
          {
            ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(0.0F, localResources);
            paramagkp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            paramagkp.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramagkp.jdField_b_of_type_AndroidWidgetTextView.setText(2131718618);
          }
        }
        for (;;)
        {
          paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          break;
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(0.0F, localResources);
          paramagkp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramagkp.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          paramagkp.jdField_b_of_type_AndroidWidgetTextView.setText(2131718620);
        }
        label1421:
        paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
      }
    }
  }
  
  private void a(agkp paramagkp, MessageForPtt paramMessageForPtt, boolean paramBoolean, View paramView, ChatMessage paramChatMessage)
  {
    paramView = paramView.getResources();
    if (paramChatMessage.isSend())
    {
      paramView = paramView.getColorStateList(2131167035);
      if ((paramagkp.jdField_a_of_type_AndroidWidgetTextView != null) && (paramView != null)) {
        paramagkp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView);
      }
      if ((paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (paramView != null))
      {
        paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramView);
        if ((this.jdField_a_of_type_Bcms.a(paramMessageForPtt)) && (!paramMessageForPtt.getSttResult().a())) {
          paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(PttAudioWaveView.a(paramView.getDefaultColor(), 0.5F));
        }
      }
      if ((paramagkp.jdField_b_of_type_AndroidWidgetTextView != null) && (paramView != null)) {
        paramagkp.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramView);
      }
      if (!paramBoolean)
      {
        if (paramChatMessage.isSend()) {
          break label164;
        }
        a(Color.parseColor("#424448"), paramagkp);
      }
    }
    label164:
    while (paramView == null)
    {
      return;
      paramView = paramView.getColorStateList(2131167031);
      break;
    }
    a(paramView.getDefaultColor(), paramagkp);
  }
  
  private void a(agkp paramagkp, MessageForPtt paramMessageForPtt, boolean paramBoolean, apee paramapee)
  {
    paramagkp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramapee.jdField_b_of_type_Int);
    if (paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramapee.jdField_b_of_type_Int);
      if ((this.jdField_a_of_type_Bcms.a(paramMessageForPtt)) && (!paramMessageForPtt.getSttResult().a())) {
        paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(PttAudioWaveView.a(paramapee.jdField_b_of_type_Int, 0.5F));
      }
    }
    if (paramagkp.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramagkp.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramapee.jdField_b_of_type_Int);
    }
    if (!paramBoolean) {
      a(paramapee.jdField_b_of_type_Int, paramagkp);
    }
  }
  
  private void a(View paramView, ColorFilter paramColorFilter)
  {
    Object localObject = (agkp)paramView.getTag();
    if (localObject != null)
    {
      paramView = AIOUtils.getMessage(paramView);
      if ((paramView != null) && (paramView.vipBubbleID == 0L))
      {
        localObject = ((agkp)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getBackground();
        if ((localObject != null) && (paramView.vipBubbleID == 0L))
        {
          ((Drawable)localObject).setColorFilter(paramColorFilter);
          ((Drawable)localObject).invalidateSelf();
        }
      }
    }
  }
  
  private void a(bgaz parambgaz)
  {
    parambgaz.a(2131365216, this.jdField_a_of_type_AndroidContentContext.getString(2131718621), 2130838964);
    parambgaz.a(2131367094, this.jdField_a_of_type_AndroidContentContext.getString(2131689962), 2130838971);
    parambgaz.a(2131366347, this.jdField_a_of_type_AndroidContentContext.getString(2131692036), 2130838970);
    parambgaz.a(2131377872, this.jdField_a_of_type_AndroidContentContext.getString(2131718617), 2130844725);
  }
  
  private void a(bgaz parambgaz, MessageForPtt paramMessageForPtt)
  {
    if (agkq.c)
    {
      boolean bool1 = MediaPlayerManager.a(paramMessageForPtt.playSpeedPos, MediaPlayerManager.a);
      boolean bool2 = MediaPlayerManager.a(paramMessageForPtt.playSpeedPos, MediaPlayerManager.c);
      if (!bool1) {
        parambgaz.a(2131377674, this.jdField_a_of_type_AndroidContentContext.getString(2131694497), 2130838968);
      }
      if (!bool2) {
        parambgaz.a(2131377672, this.jdField_a_of_type_AndroidContentContext.getString(2131694492), 2130838968);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "getMenuItem speed:" + paramMessageForPtt.playSpeedPos);
      }
    }
  }
  
  private void a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    float f = MediaPlayerManager.a;
    Object localObject1 = "0X8009DE4";
    if (paramInt == 2131377675)
    {
      f = MediaPlayerManager.b;
      localObject1 = "0X8009E7D";
    }
    label564:
    label581:
    label584:
    label586:
    for (;;)
    {
      if (paramMessageForPtt.isReady())
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) {
          break label91;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694732, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
      }
      for (;;)
      {
        return;
        if (paramInt != 2131377672) {
          break label586;
        }
        f = MediaPlayerManager.c;
        localObject1 = "0X8009DE3";
        break;
        label91:
        boolean bool1 = lfg.a(BaseApplicationImpl.getContext());
        boolean bool2 = AudioHelper.a(BaseApplicationImpl.getContext());
        Object localObject2 = bfxd.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.speakerPhoneOn, bool1, bool2, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.playMode, f);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.playMode == 0) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.playMode = bfxd.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.speakerPhoneOn, bool1, bool2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, (CharSequence)localObject2, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurType() == 0)
        {
          paramInt = 1;
          bcef.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, paramInt, 0, "", "", "", "");
          if (c(paramMessageForPtt)) {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
          }
          if (QLog.isColorLevel()) {
            QLog.d("PttItemBuilder", 2, "getMenuItem oriSpeed:" + paramMessageForPtt.playSpeedPos + ", newSpeed:" + f);
          }
          paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listAdapter.a(paramMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView.getHeaderViewsCount();
          int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView.getFirstVisiblePosition();
          if (paramInt < 0) {
            break label581;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView.getChildAt(paramInt - i);
          agkp localagkp = (agkp)AIOUtils.getHolder((View)localObject2);
          if ((localObject2 == null) || (localagkp == null)) {
            break label581;
          }
          localObject1 = (MessageForPtt)localagkp.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localagkp.jdField_b_of_type_Int);
          if (localObject1 != null) {
            ((MessageForPtt)localObject1).playSpeedPos = f;
          }
          localagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          localagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
          localagkp.a(true);
          localObject2 = (PttAudioWaveView)((View)localObject2).findViewById(2131374014);
          if ((localObject2 == null) || (localObject1 == null)) {
            break label581;
          }
          f = ((MessageForPtt)localObject1).playProgress;
          if (QLog.isColorLevel()) {
            QLog.d("PttItemBuilder", 2, "onMenuItemClicked, progress = " + f);
          }
          if (f != 1.0F) {
            break label564;
          }
          ((PttAudioWaveView)localObject2).setProgress(0.0F);
          paramInt = 0;
        }
        for (;;)
        {
          if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramMessageForPtt, paramInt)) {
            break label584;
          }
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694731, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
          return;
          paramInt = 2;
          break;
          paramInt = (int)(((MessageForPtt)localObject1).voiceLength * 1000.0F * f);
          continue;
          paramInt = 0;
        }
      }
    }
  }
  
  private void a(MessageForPtt paramMessageForPtt, ChatMessage paramChatMessage)
  {
    if (c(paramMessageForPtt)) {
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
    }
    acvv.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    PttInfoCollector.reportLongPressPtt(2);
  }
  
  private boolean a(int paramInt, MessageForPtt paramMessageForPtt)
  {
    return ((paramInt == 2003) || (paramInt == 1003)) && (!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt);
  }
  
  private boolean a(agkp paramagkp, MessageForPtt paramMessageForPtt)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramMessageForPtt.voiceLength <= 1) {
      paramMessageForPtt.voiceLength = QQRecorder.a(paramMessageForPtt);
    }
    if (paramMessageForPtt.voiceLength <= 0)
    {
      ((RelativeLayout.LayoutParams)paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
      paramagkp.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramagkp.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.dp2px(10.0F, (Resources)localObject), BaseChatItemLayout.m, AIOUtils.dp2px(10.0F, (Resources)localObject), BaseChatItemLayout.n);
      if (paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      return false;
    }
    String str;
    if (paramMessageForPtt.voiceLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt"))
    {
      if (paramMessageForPtt.longPttVipFlag != 1) {
        break label343;
      }
      if (this.jdField_a_of_type_AndroidTextSpannableString == null)
      {
        this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("[v] QQ会员专享长语音");
        localObject = ((Resources)localObject).getDrawable(2130840400);
        ((Drawable)localObject).setBounds(0, -5, ((Drawable)localObject).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject).getIntrinsicHeight() * 4 / 5);
        localObject = new bhfp((Drawable)localObject, 1).a(0.05F);
        this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localObject, 0, 3, 17);
      }
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_a_of_type_AndroidTextSpannableString, this);
      if (VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        str = HttpUtil.getNetWorkTypeByStr();
        if (!VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label460;
        }
      }
    }
    label460:
    for (paramagkp = "svip";; paramagkp = "vip")
    {
      VasWebviewUtil.reportCommercialDrainage((String)localObject, "LongVoice", "TailView", "0", 1, 0, 0, str, "", paramagkp);
      if ((paramMessageForPtt.voiceLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ConvertText_MaxPtt")) && (paramMessageForPtt.autoToText != 2)) {
        paramMessageForPtt.sttAbility = 0;
      }
      return true;
      label343:
      if (paramMessageForPtt.longPttVipFlag != 2) {
        break;
      }
      if (this.jdField_b_of_type_AndroidTextSpannableString == null)
      {
        this.jdField_b_of_type_AndroidTextSpannableString = new SpannableString(amtj.a(2131707829));
        localObject = ((Resources)localObject).getDrawable(2130840399);
        ((Drawable)localObject).setBounds(0, -5, ((Drawable)localObject).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject).getIntrinsicHeight() * 4 / 5);
        localObject = new bhfp((Drawable)localObject, 1).a(0.05F);
        this.jdField_b_of_type_AndroidTextSpannableString.setSpan(localObject, 0, 3, 17);
      }
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_b_of_type_AndroidTextSpannableString, this);
      break;
    }
  }
  
  private boolean a(bgaz parambgaz, MessageForPtt paramMessageForPtt)
  {
    if (apse.a(paramMessageForPtt)) {
      return true;
    }
    if (!paramMessageForPtt.isReady())
    {
      acvv.a(parambgaz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      super.c(parambgaz, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambgaz, this.jdField_a_of_type_AndroidContentContext);
      return true;
    }
    if (QQRecorder.a(paramMessageForPtt) <= 0)
    {
      acvv.a(parambgaz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      super.c(parambgaz, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambgaz, this.jdField_a_of_type_AndroidContentContext);
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = MediaPlayerManager.a(paramQQAppInterface).a();
    return (paramQQAppInterface == paramChatMessage) || (((paramQQAppInterface instanceof MessageForPtt)) && (paramQQAppInterface.frienduin != null) && (paramQQAppInterface.frienduin.equals(paramChatMessage.frienduin)) && (paramQQAppInterface.uniseq == paramChatMessage.uniseq));
  }
  
  protected static boolean a(MessageForPtt paramMessageForPtt)
  {
    String str = QQRecorder.a();
    return (paramMessageForPtt.fileSize == -2L) && (!TextUtils.isEmpty(str)) && (str.equals(paramMessageForPtt.getLocalFilePath()));
  }
  
  private int b(agkp paramagkp, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean, String paramString)
  {
    boolean bool2 = akgt.a(paramMessageForPtt);
    if (paramMessageForPtt.voiceChangeFlag != 0) {}
    boolean bool3;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool3 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramagkp, paramMessageForPtt);
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "showPttItem builder, voiceLength:" + paramMessageForPtt.voiceLength);
      }
      if (a(paramagkp, paramMessageForPtt)) {
        break;
      }
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "showPttItem, msgText = " + paramString + ", message.voiceLength" + paramMessageForPtt.voiceLength);
    }
    paramagkp.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    a(paramagkp, bool3, bool1, paramMessageForPtt.isSend());
    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
    paramagkp.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    String str;
    if (paramMessageForPtt.isSend()) {
      if (paramMessageForPtt.mRobotFlag == 1)
      {
        str = ((bfdm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
        if (!TextUtils.isEmpty(str)) {
          break label324;
        }
      }
    }
    for (;;)
    {
      if (((paramInt == 2003) || (paramInt == 1003)) && (!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt)) {
        paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
      }
      int i = b(paramMessageForPtt, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramInt = a(paramMessageForPtt, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      a(paramagkp, paramMessageForPtt, bool2, i, paramInt);
      str = a(paramMessageForPtt, paramInt);
      a(paramagkp, paramMessageForPtt, i, bool3, paramString, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem, str);
      return paramInt;
      label324:
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, str, null);
      continue;
      str = ((bfdm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
      if (!TextUtils.isEmpty(str)) {
        paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, str, null);
      }
    }
  }
  
  public static int b(MessageForPtt paramMessageForPtt, int paramInt, QQAppInterface paramQQAppInterface)
  {
    bcmt localbcmt = null;
    if (paramQQAppInterface != null) {
      localbcmt = (bcmt)paramQQAppInterface.getManager(17);
    }
    if ((paramInt == 2003) || (paramInt == 1003))
    {
      if ((paramMessageForPtt.sttAbility == 2) && (paramMessageForPtt.voiceChangeFlag != 1) && (paramMessageForPtt.expandStt)) {
        return 2;
      }
      if (((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3)) && (localbcmt != null) && (localbcmt.a(paramMessageForPtt))) {
        return 2;
      }
      if ((paramMessageForPtt.sttAbility == 3) && (paramMessageForPtt.expandStt)) {
        return 2;
      }
    }
    return 1;
  }
  
  private String b(int paramInt, MessageForPtt paramMessageForPtt)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramInt != 1001) && (paramInt != 1002) && (paramInt != 1005) && (paramInt != 1004) && (paramInt != 2003))
    {
      localObject1 = localObject2;
      if (paramInt != 1003) {}
    }
    else
    {
      if (paramMessageForPtt.voiceLength <= a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt")) {
        break label82;
      }
      localObject1 = localObject2;
      if (paramMessageForPtt.longPttVipFlag == 1) {
        localObject1 = "QQ会员专享长语音";
      }
    }
    label82:
    do
    {
      return localObject1;
      localObject1 = localObject2;
    } while (paramMessageForPtt.longPttVipFlag != 2);
    return amtj.a(2131707827);
  }
  
  private void b(MessageForPtt paramMessageForPtt, int paramInt)
  {
    this.jdField_a_of_type_Bcms.b(paramMessageForPtt, paramInt);
  }
  
  private void b(MessageForPtt paramMessageForPtt, ChatMessage paramChatMessage)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      paramMessageForPtt = a();
      if (paramMessageForPtt != null) {
        paramMessageForPtt.b();
      }
    }
    Object localObject;
    do
    {
      do
      {
        int i;
        do
        {
          return;
          i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listAdapter.a(paramMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView.getHeaderViewsCount();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.delmsg", 2, "autochange pos is:" + i);
          }
        } while (i < 0);
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView.getFirstVisiblePosition();
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView.getChildAt(i - j);
      } while (localObject == null);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B40", "0X8005B40", 0, 0, "", "", "", "");
      bcef.b(null, "dc00898", "", "", "0X8009DF7", "0X8009DF7", 0, 0, "", "", "", "");
      localObject = (agkp)((View)localObject).getTag();
      PttInfoCollector.reportLongPressPtt(5);
      if ((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3))
      {
        if ((paramMessageForPtt.sttAbility == 3) && (!paramMessageForPtt.expandStt)) {
          paramMessageForPtt.expandStt = true;
        }
        h(paramChatMessage);
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramChatMessage.uniseq), "");
        b(paramMessageForPtt, 1);
        this.jdField_a_of_type_Bcms.a(this);
        a((agkp)localObject, paramMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt), c(paramMessageForPtt));
        return;
      }
    } while ((paramMessageForPtt.sttAbility != 2) || (paramMessageForPtt.expandStt));
    paramMessageForPtt.expandStt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
    a((agkp)localObject, paramMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt), c(paramMessageForPtt));
    a((aezf)localObject, ((agkp)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramMessageForPtt, ((agkp)localObject).jdField_a_of_type_Apee);
  }
  
  private void c(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
  }
  
  private void d(MessageForPtt paramMessageForPtt)
  {
    int i = QQRecorder.a(paramMessageForPtt);
    if (i <= 0) {
      return;
    }
    bkrc localbkrc = new bkrc(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt.voiceType, new agkn(this, paramMessageForPtt));
    Object localObject;
    if (paramMessageForPtt.isSend())
    {
      localObject = paramMessageForPtt.selfuin;
      Drawable localDrawable = null;
      if (nmy.a(paramMessageForPtt)) {
        localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843682);
      }
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, (String)localObject);
      localObject = localBitmap;
      if (localBitmap == null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, paramMessageForPtt.frienduin);
      }
      if (!localbkrc.a(paramMessageForPtt.getLocalFilePath(), i, (Bitmap)localObject, localDrawable)) {
        break label146;
      }
      localbkrc.show();
    }
    for (;;)
    {
      PttInfoCollector.reportLongPressPtt(1);
      return;
      localObject = paramMessageForPtt.senderuin;
      break;
      label146:
      bkpj.a(this.jdField_a_of_type_AndroidContentContext, 2131692038, 1);
    }
  }
  
  private boolean d(ChatMessage paramChatMessage)
  {
    return paramChatMessage.vipBubbleID >= 1L;
  }
  
  private void e(MessageForPtt paramMessageForPtt)
  {
    if (TextUtils.isEmpty(paramMessageForPtt.sttText)) {
      paramMessageForPtt = this.jdField_a_of_type_AndroidContentContext.getString(2131718622);
    }
    for (;;)
    {
      PttInfoCollector.reportLongPressPtt(3);
      try
      {
        if (Build.VERSION.SDK_INT < 11) {
          ((android.text.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramMessageForPtt);
        }
        for (;;)
        {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
          return;
          paramMessageForPtt = paramMessageForPtt.sttText;
          break;
          ((android.content.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("msg", paramMessageForPtt));
        }
        return;
      }
      catch (Exception paramMessageForPtt) {}
    }
  }
  
  private void f(MessageForPtt paramMessageForPtt)
  {
    PttInfoCollector.reportLongPressPtt(4);
    if ((paramMessageForPtt.sttText != null) && (paramMessageForPtt.sttText.length() > 0))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", -1);
      localBundle.putString("forward_text", paramMessageForPtt.sttText);
      localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
      paramMessageForPtt = new Intent();
      paramMessageForPtt.putExtras(localBundle);
      atky.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt, 21);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, amtj.a(2131707834), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
  }
  
  private void g(MessageForPtt paramMessageForPtt)
  {
    if ((paramMessageForPtt.sttAbility != 2) || (!paramMessageForPtt.expandStt)) {}
    do
    {
      int i;
      do
      {
        return;
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listAdapter.a(paramMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView.getHeaderViewsCount();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.delmsg", 2, "autochange pos is:" + i);
        }
      } while (i < 0);
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView.getFirstVisiblePosition();
      paramMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView.getChildAt(i - j);
    } while (paramMessageForPtt == null);
    ((agkp)paramMessageForPtt.getTag()).jdField_a_of_type_ComEtrumpMixlayoutETTextView.performClick();
  }
  
  private void h(ChatMessage paramChatMessage)
  {
    if (bgov.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_show_open_svip_gray_msg", false)) {
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
          localObject1 = aqgp.c();
          localObject2 = (aqai)apub.a().a(442);
          if ((localObject2 != null) && (((aqai)localObject2).a())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is close ,so click ptt msg not add msg");
        return;
        if (((aqgo)localObject1).jdField_a_of_type_Int == 3) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is open but stage=" + ((aqgo)localObject1).jdField_a_of_type_Int + ",so click ptt msg not add msg");
      return;
      if (!agkq.d) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is open but switch is open ,so click ptt msg not add msg");
    return;
    Object localObject2 = amtj.a(2131707828);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_action", 41);
    ((Bundle)localObject1).putString("textColor", "#40A0FF");
    localObject2 = new aucf(paramChatMessage.frienduin, paramChatMessage.selfuin, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, -5020, 655392, ((MessageForPtt)paramChatMessage).time);
    ((aucf)localObject2).a(15, 19, (Bundle)localObject1);
    localObject1 = new MessageForUniteGrayTip();
    if (paramChatMessage.istroop == 1) {
      ((MessageForUniteGrayTip)localObject1).shmsgseq = paramChatMessage.shmsgseq;
    }
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aucf)localObject2);
    aucg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject1);
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    localObject1 = "businessinfo_ptt_auto_change_guide_has_show_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentAccountUin();
    paramChatMessage.edit().putBoolean((String)localObject1, true).commit();
    agkq.e = true;
    bgov.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_show_open_svip_gray_msg", true);
    QLog.e("vip_ptt.PttItemBuilder", 1, "stage 3 add gray msg seccess");
  }
  
  private void h(MessageForPtt paramMessageForPtt)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.speakerPhoneOn)
    {
      i = 9;
      PttInfoCollector.reportLongPressPtt(i);
      if (paramMessageForPtt.isReady())
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) {
          break label70;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694732, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
      }
    }
    label526:
    label529:
    for (;;)
    {
      return;
      i = 10;
      break;
      label70:
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      boolean bool1;
      label115:
      float f;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.speakerPhoneOn)
      {
        bool1 = true;
        ((QQAppInterface)localObject1).setLoudSpeakerState(bool1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.speakerPhoneOn) {
          break label497;
        }
        bool1 = true;
        ((BaseChatPie)localObject1).speakerPhoneOn = bool1;
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mCustomTitleView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo != null))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mCustomTitleView;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.speakerPhoneOn) {
            break label503;
          }
          bool1 = true;
          label174:
          ((NavBarAIO)localObject1).a(bool1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType);
        }
        bool1 = lfg.a(BaseApplicationImpl.getContext());
        boolean bool2 = AudioHelper.a(BaseApplicationImpl.getContext());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.showPttStatusToast(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.speakerPhoneOn, bool1, bool2);
        if (c(paramMessageForPtt)) {
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
        }
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listAdapter.a(paramMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView.getHeaderViewsCount();
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView.getFirstVisiblePosition();
        if (i < 0) {
          break label526;
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView.getChildAt(i - j);
        agkp localagkp = (agkp)AIOUtils.getHolder((View)localObject2);
        if ((localObject2 == null) || (localagkp == null)) {
          break label526;
        }
        localObject1 = (MessageForPtt)localagkp.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localagkp.jdField_b_of_type_Int);
        localagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
        localagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
        localagkp.a(true);
        localObject2 = (PttAudioWaveView)((View)localObject2).findViewById(2131374014);
        if ((localObject2 == null) || (localObject1 == null)) {
          break label526;
        }
        f = ((MessageForPtt)localObject1).playProgress;
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "onMenuItemClicked, progress = " + f);
        }
        if (f != 1.0F) {
          break label509;
        }
        ((PttAudioWaveView)localObject2).setProgress(0.0F);
        i = 0;
      }
      for (;;)
      {
        if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramMessageForPtt, i)) {
          break label529;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694731, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
        return;
        bool1 = false;
        break;
        label497:
        bool1 = false;
        break label115;
        label503:
        bool1 = false;
        break label174;
        label509:
        i = (int)(((MessageForPtt)localObject1).voiceLength * 1000.0F * f);
        continue;
        i = 0;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public aeze a(View paramView)
  {
    if (AIOUtils.getMessage(paramView) != null) {
      return this;
    }
    return null;
  }
  
  public aezf a()
  {
    return new agkp();
  }
  
  @Nullable
  protected afry a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      return null;
    }
    return (afry)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(82);
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    paramChatMessage = b(paramChatMessage, paramaezf, paramView, paramBaseChatItemLayout, paramafce);
    afaz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramaezf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this);
    if (AppSetting.c) {
      paramaezf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setOnClickListener(this);
    }
    paramaezf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bfwr.a(paramChatMessage.issend)) {
      return amtj.a(2131707824);
    }
    return amtj.a(2131707825);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bcms.a(null);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((agkp)localIterator.next()).a();
    }
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilSet = null;
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  @TargetApi(11)
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForPtt))) {
      return;
    }
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    if (2131366347 == paramInt)
    {
      d(localMessageForPtt);
      return;
    }
    if (paramInt == 2131365382)
    {
      a(localMessageForPtt, paramChatMessage);
      return;
    }
    if (paramInt == 2131371498)
    {
      PttInfoCollector.reportLongPressPtt(6);
      super.d(paramChatMessage);
      return;
    }
    if (paramInt == 2131365216)
    {
      e(localMessageForPtt);
      return;
    }
    if (paramInt == 2131367094)
    {
      f(localMessageForPtt);
      return;
    }
    if (paramInt == 2131377872)
    {
      g(localMessageForPtt);
      return;
    }
    if (paramInt == 2131377873)
    {
      b(localMessageForPtt, paramChatMessage);
      return;
    }
    if (paramInt == 2131371455)
    {
      if (c(localMessageForPtt)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
      }
      super.a(paramChatMessage);
      return;
    }
    if (paramInt == 2131372737)
    {
      h(localMessageForPtt);
      return;
    }
    if ((paramInt == 2131377674) || (paramInt == 2131377675) || (paramInt == 2131377672))
    {
      a(localMessageForPtt, paramInt);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(aezf paramaezf, View paramView, ChatMessage paramChatMessage, apee paramapee)
  {
    paramaezf = (agkp)paramaezf;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramaezf, localMessageForPtt);
    if ((paramapee.jdField_a_of_type_Int == 0) || (!paramapee.a())) {
      a(paramaezf, localMessageForPtt, bool, paramView, paramChatMessage);
    }
    label213:
    for (;;)
    {
      return;
      if (paramapee.jdField_b_of_type_Int == 0) {
        a(paramaezf, localMessageForPtt, bool);
      }
      for (;;)
      {
        if ((!paramapee.jdField_b_of_type_Boolean) || (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramaezf.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * paramaezf.jdField_a_of_type_Apee.jdField_a_of_type_Double) != 1)) {
          break label213;
        }
        float f2 = paramaezf.jdField_a_of_type_AndroidWidgetTextView.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramaezf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramaezf.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(f1, 0.0F, 0.0F, paramapee.d);
        if (bool) {
          break;
        }
        a(-1, paramaezf);
        return;
        a(paramaezf, localMessageForPtt, bool, paramapee);
      }
    }
  }
  
  protected void a(agkp paramagkp, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag + ", voiceLength is: " + paramMessageForPtt.voiceLength);
    }
    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject = (RelativeLayout.LayoutParams)paramagkp.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(1, -1);
    if (paramagkp.c != null)
    {
      paramagkp.c.setVisibility(8);
      paramagkp.c.setOnClickListener(null);
      paramagkp.d.setVisibility(8);
    }
    if ((paramagkp.jdField_a_of_type_Akxy != null) && (paramagkp.jdField_a_of_type_Akxy.c()) && (paramagkp.jdField_a_of_type_Akxy.a()))
    {
      paramagkp.jdField_a_of_type_Akxy.b();
      paramagkp.jdField_a_of_type_Akxy.d();
    }
    if (paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
      paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(null);
      paramagkp.e.setVisibility(8);
      paramagkp.f.setVisibility(8);
      paramagkp.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramagkp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramagkp.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramagkp.jdField_a_of_type_Afce);
    paramagkp.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramagkp.jdField_a_of_type_Afce);
    boolean bool1 = a(paramMessageForPtt, paramagkp);
    boolean bool2 = a(paramInt, paramMessageForPtt);
    localObject = a(paramInt, paramMessageForPtt);
    int i = a(paramagkp, paramMessageForPtt, paramInt, paramBoolean, (String)localObject);
    String str = b(paramInt, paramMessageForPtt);
    if (paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setSeekListener(this);
    }
    switch (i)
    {
    default: 
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
      if (paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) {
        paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
      }
      if (bool1)
      {
        paramMessageForPtt = (ajyg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245);
        if (paramMessageForPtt != null)
        {
          paramMessageForPtt = paramMessageForPtt.a("voice_pwd", amtj.a(2131707830), new String[] { "lowTipStr" });
          label473:
          paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, paramMessageForPtt, null);
        }
      }
      else if (AppSetting.c)
      {
        paramMessageForPtt = amtj.a(2131707821);
        if (!bool2) {
          break label705;
        }
        paramagkp.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject + amtj.a(2131707826) + amtj.a(2131707822));
      }
      break;
    }
    for (;;)
    {
      if (paramagkp.jdField_a_of_type_JavaLangStringBuilder != null)
      {
        paramagkp.jdField_a_of_type_JavaLangStringBuilder.append("发送了语音.").append((String)localObject);
        if (str != null) {
          paramagkp.jdField_a_of_type_JavaLangStringBuilder.append(" ").append(str);
        }
      }
      return;
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
      ImageView localImageView = paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c;
      if (paramMessageForPtt.isSendFromLocal()) {}
      for (paramMessageForPtt = amtj.a(2131707831);; paramMessageForPtt = amtj.a(2131707823))
      {
        localImageView.setContentDescription(paramMessageForPtt);
        break;
      }
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839449, null);
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
      ((Animatable)paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getDrawable()).start();
      break;
      paramMessageForPtt = amtj.a(2131707830);
      break label473;
      label705:
      paramagkp.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject + amtj.a(2131707835));
    }
  }
  
  protected void a(agkp paramagkp, MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      if (paramBoolean1) {
        i = 2;
      }
    }
    for (int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mEffectPullRefreshCount;; j = 0)
    {
      acvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramMessageForPtt, false, i, j, paramBoolean2);
      return;
      i = 1;
      break;
      i = 5;
    }
  }
  
  protected void a(agkp paramagkp, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramagkp.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (paramBoolean3)
      {
        localObject = ((Resources)localObject).getDrawable(2130846970);
        if (localObject != null)
        {
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
          paramagkp.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
        }
      }
      do
      {
        return;
        localObject = ((Resources)localObject).getDrawable(2130846968);
      } while (localObject == null);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
      paramagkp.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
      return;
    }
    paramagkp.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
    paramagkp.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public void a(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.getMessage(paramView);
    paramView = (agkp)AIOUtils.getHolder(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = bjnw.a(this.jdField_a_of_type_AndroidContentContext);
      paramView.a(2131689948);
      paramView.b(2131689947);
      paramView.c(2131690620);
      paramView.a(new agko(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    if ((!Environment.getExternalStorageState().equals("mounted")) || (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1))
    {
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        QQToast.a(BaseApplication.getContext(), 2131694119, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299076));
        return;
      }
      QQToast.a(BaseApplication.getContext(), 2131717957, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299076));
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
        paramView = (agkp)((View)paramView.getParent().getParent()).getTag();
      } while (paramView == null);
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getBackground();
    } while (paramView == null);
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
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
        localObject = (aezf)paramView.getTag();
        paramView = (BaseChatItemLayout)paramView;
        b(paramChatMessage, (aezf)localObject, ((aezf)localObject).jdField_a_of_type_AndroidViewView, paramView, null);
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
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if ((paramFileMsg.fileType != 2) || (paramInt1 == 2002) || (paramInt1 == 1002) || (paramInt1 == 2001)) {}
    MessageForPtt localMessageForPtt;
    do
    {
      do
      {
        return;
      } while (!(AIOUtils.getMessage(paramView) instanceof MessageForPtt));
      localMessageForPtt = (MessageForPtt)AIOUtils.getMessage(paramView);
    } while ((localMessageForPtt == null) || (localMessageForPtt.uniseq != paramFileMsg.uniseq));
    paramView = (agkp)AIOUtils.getHolder(paramView);
    if ((paramInt1 == 1003) || (paramInt1 == 2003))
    {
      paramInt2 = paramInt1;
      if (!paramFileMsg.isStreamMode)
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
      if ((paramFileMsg.status == 1005) || (paramFileMsg.status == 1004))
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
          localObject = (agkp)localView.getTag();
          if (localObject == null) {
            break label196;
          }
          localObject = ((agkp)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView;
          paramView = AIOUtils.getMessage((View)paramView.getParent().getParent().getParent());
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
    paramPttAudioWaveView = (agkp)AIOUtils.getHolder(paramPttAudioWaveView);
    if (paramPttAudioWaveView != null)
    {
      MediaPlayerManager localMediaPlayerManager = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localMediaPlayerManager.a(localMediaPlayerManager.a(), paramPttAudioWaveView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView, float paramFloat)
  {
    paramPttAudioWaveView = (agkp)AIOUtils.getHolder(paramPttAudioWaveView);
    MessageForPtt localMessageForPtt;
    if (paramPttAudioWaveView != null)
    {
      localMessageForPtt = (MessageForPtt)paramPttAudioWaveView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (localMessageForPtt != null) {
        localMessageForPtt.playProgress = paramFloat;
      }
      if ((paramPttAudioWaveView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView == null) || (paramPttAudioWaveView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.b())) {
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
  
  public void a(MessageForPtt paramMessageForPtt)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramMessageForPtt.uniseq));
    ThreadManager.excute(new PttItemBuilder.4(this, paramMessageForPtt.getSttResult().b() + "", paramMessageForPtt.getSttResult().c() + ""), 16, null, false);
    afry localafry = a();
    if (localafry != null) {
      localafry.b(paramMessageForPtt);
    }
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void a(MessageForPtt paramMessageForPtt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramMessageForPtt.uniseq));
    if (paramMessageForPtt.getSttResult().a())
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
      }
      afry localafry = a();
      if (localafry != null) {
        localafry.a(paramMessageForPtt);
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean, agkp paramagkp)
  {
    this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramMessageForPtt.isSend())
    {
      if (d(paramMessageForPtt))
      {
        paramMessageForPtt = paramagkp.jdField_a_of_type_AndroidWidgetImageView;
        if (paramBoolean) {}
        for (i = 2130846966;; i = 2130846969)
        {
          paramMessageForPtt.setImageResource(i);
          return;
        }
      }
      paramMessageForPtt = paramagkp.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {}
      for (i = 2130849898;; i = 2130849899)
      {
        paramMessageForPtt.setImageResource(i);
        return;
      }
    }
    if (d(paramMessageForPtt))
    {
      paramMessageForPtt = paramagkp.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {}
      for (i = 2130846960;; i = 2130846967)
      {
        paramMessageForPtt.setImageResource(i);
        return;
      }
    }
    paramMessageForPtt = paramagkp.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i = 2130849892;; i = 2130849891)
    {
      paramMessageForPtt.setImageResource(i);
      return;
    }
  }
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, agkp paramagkp)
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
              i = 2130772263;
              paramMessageForPtt = (AnimationDrawable)localResources.getDrawable(i);
              paramagkp.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForPtt);
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
            i = 2130772261;
            continue;
          }
        }
        else
        {
          a(paramMessageForPtt, paramBoolean3, paramagkp);
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
      int i = 2130772262;
      continue;
      label140:
      if (paramBoolean3)
      {
        i = 2130772103;
      }
      else
      {
        i = 2130772102;
        continue;
        label161:
        i = 2130772260;
        continue;
        label169:
        if (paramBoolean3) {
          i = 2130772347;
        } else {
          i = 2130772346;
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
      paramXListView = AIOUtils.getHolder(paramView);
      if ((paramXListView instanceof agkp))
      {
        paramXListView = (agkp)paramXListView;
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
      paramXListView = AIOUtils.getHolder(paramView);
      if ((paramXListView instanceof agkp))
      {
        paramXListView = (agkp)paramXListView;
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
  
  public boolean a(aezf paramaezf)
  {
    return paramaezf instanceof agkp;
  }
  
  protected boolean a(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, aezf paramaezf, MessageForPtt paramMessageForPtt)
  {
    return VoicePrintUtils.a(paramQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramaezf, paramMessageForPtt);
  }
  
  protected boolean a(MessageForPtt paramMessageForPtt, agkp paramagkp)
  {
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = true;
    Object localObject;
    if (akgt.a(paramMessageForPtt)) {
      if (CustomizeStrategyFactory.a().a())
      {
        localObject = (ajyg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245);
        if (localObject != null)
        {
          i = ((ajyg)localObject).a("voice_pwd", 1, new String[] { "scoreSwitch" });
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
          paramagkp.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramMessageForPtt.icon);
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
        paramMessageForPtt = paramagkp.jdField_b_of_type_AndroidWidgetImageView;
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
                i = ((ajyg)localObject).a("voice_pwd", 5, new String[] { "lowTipsLimit" });
                int k = ajvu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "voice_low_tips_count", 0);
                if (k >= i) {
                  break label383;
                }
                paramMessageForPtt.saveExtInfoToExtStr("voice_low_tips_tag", "1");
                ThreadManager.post(new PttItemBuilder.2(this, paramMessageForPtt), 10, null, false);
                ajvu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "voice_low_tips_count", k + 1);
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
        } while (paramagkp.jdField_b_of_type_AndroidWidgetImageView == null);
        paramagkp.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
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
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    azck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramXListView);
    if (paramXListView.isReady())
    {
      paramView = AIOUtils.getHolder(paramView);
      if ((paramView != null) && (!(paramView instanceof agkp))) {
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "play failed not Holder " + paramXListView.getLocalFilePath());
        }
      }
      do
      {
        return false;
        paramView = (agkp)paramView;
      } while (paramAudioPlayerBase == null);
      paramAudioPlayerBase.b(paramXListView.playSpeedPos);
      paramAudioPlayerBase.a(paramXListView.time);
      if (paramAudioPlayerBase.b(paramXListView.getLocalFilePath(), paramInt2))
      {
        c(paramXListView);
        if (paramView != null)
        {
          paramAudioPlayerBase = a();
          if (paramAudioPlayerBase != null) {
            paramAudioPlayerBase.e(paramXListView);
          }
          a(paramView, paramXListView, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView), true);
          if (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
            paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          }
          if (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
            paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
          }
          paramView.a(true);
          a(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout, paramXListView, paramView.jdField_a_of_type_Apee, 0);
        }
        PttInfoCollector.reportPttPlay(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView.istroop, paramXListView.issend);
        if (!paramXListView.isSendFromLocal())
        {
          if (paramXListView.istroop != 0) {
            break label270;
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
        PttInfoCollector.reportPTTPV(paramXListView, paramInt1, bool, 1);
        return true;
        label270:
        if (paramXListView.istroop == 1)
        {
          paramInt1 = 3;
          break;
        }
        if (paramXListView.istroop != 3000) {
          break label378;
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
      label378:
      paramInt1 = 4;
    }
  }
  
  public bgbb[] a(View paramView)
  {
    return a(new bgaz(), (MessageForPtt)AIOUtils.getMessage(paramView), paramView instanceof akyk);
  }
  
  protected bgbb[] a(bgaz parambgaz, MessageForPtt paramMessageForPtt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramMessageForPtt.sttAbility == 2) && (paramMessageForPtt.expandStt))
    {
      a(parambgaz);
      return parambgaz.a();
    }
    if (a(parambgaz, paramMessageForPtt)) {
      return parambgaz.a();
    }
    if (c(paramMessageForPtt)) {
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
    }
    String str;
    int i;
    if (!AIOUtils.isRubbishSamsun())
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.speakerPhoneOn))
      {
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131694493);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.speakerPhoneOn)) {
          break label383;
        }
        i = 2130838968;
        label119:
        parambgaz.a(2131372737, str, i);
      }
    }
    else
    {
      if (((paramMessageForPtt.extraflag != 32768) && (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt) == 1003) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramMessageForPtt))) || (TroopUtils.isSupportRevokeMsgByTroopOwnerOrMgr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        a(parambgaz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramMessageForPtt);
      }
      a(parambgaz, paramMessageForPtt);
      if (paramMessageForPtt.voiceChangeFlag != 1)
      {
        if ((paramMessageForPtt.sttAbility != 1) && (paramMessageForPtt.sttAbility != 3)) {
          break label391;
        }
        if ((!this.jdField_a_of_type_Bcms.a(paramMessageForPtt)) && ((!paramMessageForPtt.isSend()) || (paramMessageForPtt.fileSize > 0L)) && (!akgt.a(paramMessageForPtt))) {
          parambgaz.a(2131377873, this.jdField_a_of_type_AndroidContentContext.getString(2131718623), 2130838961);
        }
      }
    }
    for (;;)
    {
      a(paramMessageForPtt, parambgaz);
      parambgaz.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691134));
      a(parambgaz, paramMessageForPtt);
      parambgaz.a(2131366347, this.jdField_a_of_type_AndroidContentContext.getString(2131692036), 2130838970);
      super.a(parambgaz, this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt);
      b(paramMessageForPtt, parambgaz);
      super.c(parambgaz, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambgaz, this.jdField_a_of_type_AndroidContentContext);
      return parambgaz.a();
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131694495);
      break;
      label383:
      i = 2130838972;
      break label119;
      label391:
      if ((paramMessageForPtt.sttAbility == 2) && (!paramMessageForPtt.expandStt) && (!akgt.a(paramMessageForPtt))) {
        parambgaz.a(2131377873, this.jdField_a_of_type_AndroidContentContext.getString(2131718623), 2130838961);
      }
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "1", "", "", "");
  }
  
  protected View b(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    paramBaseChatItemLayout = (agkp)paramaezf;
    this.jdField_a_of_type_JavaUtilSet.add(paramBaseChatItemLayout);
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramaezf = a();
    if (paramaezf != null) {
      paramaezf.a(paramBaseChatItemLayout, localMessageForPtt, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
    }
    paramaezf = paramView;
    if (paramView == null)
    {
      paramaezf = new BreathAnimationLayout(this.jdField_a_of_type_AndroidContentContext);
      paramaezf.setId(2131374008);
      paramView = new PttAudioPlayView(this.jdField_a_of_type_AndroidContentContext, 12);
      paramView.setThemeColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167031).getDefaultColor());
      paramView.setId(2131374013);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject1).width = AIOUtils.dp2px(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject1).height = AIOUtils.dp2px(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new PttAudioChangeView(this.jdField_a_of_type_AndroidContentContext, 2130838232, 8);
      ((PttAudioChangeView)localObject1).setThemeColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167031).getDefaultColor());
      ((PttAudioChangeView)localObject1).setId(2131374019);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject2).width = AIOUtils.dp2px(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject2).height = AIOUtils.dp2px(19.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((PttAudioChangeView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new PttAudioWaveView(this.jdField_a_of_type_AndroidContentContext);
      ((PttAudioWaveView)localObject2).setProgressColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167031).getDefaultColor());
      ((PttAudioWaveView)localObject2).setId(2131374014);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject3).width = AIOUtils.dp2px(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject3).height = AIOUtils.dp2px(52.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((PttAudioWaveView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject3).setId(2131374015);
      ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167031));
      VoicePrintUtils.VoicePrintView localVoicePrintView = new VoicePrintUtils.VoicePrintView(this.jdField_a_of_type_AndroidContentContext);
      localVoicePrintView.setId(2131374016);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setId(2131374018);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      localVoicePrintView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject4).width = AIOUtils.dp2px(47.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject4).height = AIOUtils.dp2px(41.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new SyncParentPressedRelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject4).setId(2131374011);
      ((RelativeLayout)localObject4).addView((View)localObject2);
      ((RelativeLayout)localObject4).addView(paramView);
      ((RelativeLayout)localObject4).addView((View)localObject1);
      ((RelativeLayout)localObject4).addView((View)localObject3);
      ((RelativeLayout)localObject4).addView(localVoicePrintView);
      ((RelativeLayout)localObject4).addView(localImageView);
      paramaezf.addView((View)localObject4);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = paramaezf;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView = ((PttAudioChangeView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject2);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView = localVoicePrintView;
      paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView = localImageView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject4);
    }
    if (paramafce != null) {
      paramBaseChatItemLayout.jdField_a_of_type_Afce = paramafce;
    }
    int i;
    boolean bool;
    if (localMessageForPtt.voiceChangeFlag != 0)
    {
      i = 1;
      bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramBaseChatItemLayout, localMessageForPtt);
      if (!bool) {
        break label1092;
      }
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
      if (!paramChatMessage.isSend()) {
        break label1379;
      }
      paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (!bool) {
        break label1298;
      }
      paramView.addRule(1, 2131374016);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, 2131374018);
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
      if (((localMessageForPtt.istroop == 1) || (localMessageForPtt.istroop == 3000)) && (i == 2003) && (this.jdField_a_of_type_Bcms.b(localMessageForPtt)))
      {
        b(localMessageForPtt, 2);
        bcef.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
      }
      a(paramBaseChatItemLayout, localMessageForPtt, i, c(localMessageForPtt));
      azck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(localMessageForPtt);
      PttInfoCollector.reportPttItemBuilderType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramChatMessage);
      return paramaezf;
      i = 0;
      break;
      label1092:
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(0);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnClickListener(this);
      if (i != 0) {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(0);
      }
      for (;;)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnTouchListener(paramBaseChatItemLayout.jdField_a_of_type_Afce);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnLongClickListener(paramBaseChatItemLayout.jdField_a_of_type_Afce);
        if ((!c(paramChatMessage)) && (!paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.d)) {
          break label1228;
        }
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
        paramBaseChatItemLayout.a(true);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
        break;
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
      }
      label1228:
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
      label1298:
      paramView.addRule(1, 2131374014);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131374019);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getLayoutParams()).addRule(1, 2131374018);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374013);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
      continue;
      label1379:
      if (bool)
      {
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374015);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131374016);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, -1);
      }
      else
      {
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131374014);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131374019);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getLayoutParams()).addRule(1, 2131374018);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374013);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
      }
    }
  }
  
  public void b(MessageForPtt paramMessageForPtt)
  {
    afry localafry = a();
    if (localafry != null) {
      localafry.c(paramMessageForPtt);
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  protected boolean c(ChatMessage paramChatMessage)
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void d()
  {
    PttInfoCollector.reportLongPressPtt(7);
    super.d();
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.isUserOperatedInAIO = true;
    int i = paramView.getId();
    if ((AppSetting.c) && (i == 2131363354)) {
      paramView.findViewById(2131374011).performClick();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = (agkp)AIOUtils.getHolder(paramView);
      Object localObject2 = (MessageForPtt)((agkp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((i == 2131374011) || (i == 2131374014))
      {
        if (localObject2 != null)
        {
          if (c((ChatMessage)localObject2))
          {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
            bcef.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 2, 0, "", "", "", "");
          }
          for (;;)
          {
            if (((MessageForPtt)localObject2).istroop == 1008) {
              odq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", ((MessageForPtt)localObject2).timeStr, "", false);
            }
            if (((MessageForPtt)localObject2).voiceChangeFlag != 1) {
              break;
            }
            bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F7E", 0, 0, "" + ((MessageForPtt)localObject2).istroop, "", "", "");
            break;
            if ((localObject2 != MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (((MessageForPtt)localObject2).isReady())) {
              a((agkp)localObject1, (MessageForPtt)localObject2, paramView);
            }
          }
        }
      }
      else if ((i == 2131374030) || (i == 2131374024))
      {
        if ((localObject2 != null) && (((MessageForPtt)localObject2).expandStt))
        {
          ((MessageForPtt)localObject2).expandStt = false;
          ((MessageForPtt)localObject2).serial();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, ((MessageForPtt)localObject2).uniseq, ((MessageForPtt)localObject2).msgData);
          a((agkp)localObject1, (MessageForPtt)localObject2, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForPtt)localObject2), c((ChatMessage)localObject2));
          bcef.b(null, "dc00898", "", "", "0X8009DF8", "0X8009DF8", 0, 0, "", "", "", "");
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
        }
      }
      else if (i == 2131364470)
      {
        if (this.jdField_a_of_type_AndroidContentContext != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          String str = HttpUtil.getNetWorkTypeByStr();
          if (VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
          for (localObject1 = "svip";; localObject1 = "vip")
          {
            VasWebviewUtil.reportCommercialDrainage((String)localObject2, "LongVoice", "TailClick", "0", 1, 0, 0, str, "", (String)localObject1);
            localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            ((Intent)localObject1).putExtra("url", "https://m.vip.qq.com/freedom/xhycyy.html?_nav_alpha=0");
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
            break;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "chat_item_tail_message onclick nullpoint");
        }
      }
      else
      {
        super.onClick(paramView);
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkm
 * JD-Core Version:    0.7.0.1
 */