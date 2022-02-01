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
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class ahdc
  extends BaseBubbleBuilder
  implements afqq, afqw, afrr, afsn, aftf, ahdb, bdtu
{
  protected SpannableString a;
  protected TextView a;
  protected bdts a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  protected Map<Long, String> a;
  Set<ahdf> jdField_a_of_type_JavaUtilSet = new HashSet();
  protected SpannableString b;
  
  public ahdc(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Bdts = ((bdts)paramQQAppInterface.getManager(QQManagerFactory.STT_MANAGER));
    this.jdField_a_of_type_Bdts.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private int a(ahdf paramahdf, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramMessageForPtt.voiceChangeFlag != 0) {}
    boolean bool2;
    Resources localResources;
    int i;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramahdf, paramMessageForPtt);
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      i = AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      switch (paramInt)
      {
      default: 
        return 0;
      }
    }
    return 7;
    paramahdf.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    paramahdf.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.dp2px(10.0F, localResources), BaseChatItemLayout.m, AIOUtils.dp2px(10.0F, localResources), BaseChatItemLayout.n);
    if (paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    }
    a(paramahdf, bool2, bool1, paramMessageForPtt.isSend());
    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
    ((RelativeLayout.LayoutParams)paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
    return 1;
    ((RelativeLayout.LayoutParams)paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
    paramahdf.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    paramahdf.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.dp2px(40.0F, localResources), BaseChatItemLayout.m, AIOUtils.dp2px(40.0F, localResources), BaseChatItemLayout.n);
    if (paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    }
    if (paramInt == 999)
    {
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(8);
      return 0;
    }
    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
    return 0;
    return b(paramahdf, paramMessageForPtt, paramInt, paramBoolean, paramString);
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
              j = bahy.a(paramQQAppInterface, paramMessageForPtt);
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
    for (paramQQAppInterface = (bdtt)paramQQAppInterface.getManager(QQManagerFactory.STT_MANAGER);; paramQQAppInterface = null)
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
        localObject = ((agjj)localObject).a(paramMessageForPtt);
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
    return this.jdField_a_of_type_AndroidContentContext.getString(2131719011);
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
        paramMessageForPtt = ((agjj)localObject).a(paramMessageForPtt);
      }
    }
    do
    {
      return paramMessageForPtt;
      return (String)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramMessageForPtt.uniseq));
      paramMessageForPtt = (MessageForPtt)localObject;
    } while (!TextUtils.isEmpty((CharSequence)localObject));
    return this.jdField_a_of_type_AndroidContentContext.getString(2131719011);
  }
  
  private void a(int paramInt, ahdf paramahdf)
  {
    if (paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(paramInt);
    }
    if (paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(paramInt);
    }
    if (paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) {
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(paramInt);
    }
  }
  
  public static void a(ahdf paramahdf, MessageForPtt paramMessageForPtt, int paramInt1, boolean paramBoolean1, String paramString1, boolean paramBoolean2, QQAppInterface paramQQAppInterface, int paramInt2, String paramString2)
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
      boolean bool2 = alcm.a(paramMessageForPtt);
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
          localObject2 = ((Context)localObject1).getString(2131719011);
        }
        paramString2 = new TextView((Context)localObject1);
        paramString2.setTextSize(0, paramInt2);
        f = paramString2.getPaint().measureText((String)localObject2);
      }
      paramInt2 = j + 44 + (int)AIOUtils.px2dp((int)paramahdf.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(paramString1), ((Context)localObject1).getResources());
      paramInt1 = paramInt2;
      if (bool1) {
        paramInt1 = paramInt2 + 16;
      }
      paramInt2 = paramInt1;
      if (bool2) {
        paramInt2 = paramInt1 + 38;
      }
      paramInt1 = a((Context)localObject1, paramMessageForPtt.voiceLength, f, paramInt2, i, bool1, bool2);
      localObject2 = (RelativeLayout.LayoutParams)paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = paramInt1;
      paramString1 = VoicePrintUtils.a(paramQQAppInterface, paramBoolean1, bool1, paramInt1 + j, paramahdf);
      paramString2 = (RelativeLayout.LayoutParams)paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
      paramString2.width = (paramString1[0] + paramString1[1] + paramString1[2]);
      paramString2.height = VoicePrintUtils.a(paramQQAppInterface, paramBoolean1, paramahdf);
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "message seq=" + paramMessageForPtt.uniseq + ", VpLp.width=" + paramString2.width + ", flagTimeContainer.getLeft()=" + paramahdf.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft());
      }
      if ((!paramBoolean1) || (paramString2.height <= 0)) {
        break label516;
      }
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(8);
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
      localObject1 = paramahdf.jdField_a_of_type_Aqhi.a(paramQQAppInterface, 7);
    } while ((((aqhj)((Pair)localObject1).first).a == null) || (((aqhj)((Pair)localObject1).first).a.length <= 0));
    paramQQAppInterface = paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView;
    localObject1 = (aqhj)((Pair)localObject1).first;
    paramInt1 = paramString1[0];
    paramInt2 = paramString2.height;
    int i = paramString1[1];
    int j = paramString1[2];
    if (!paramMessageForPtt.isSend()) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramQQAppInterface.setBitmap((aqhj)localObject1, paramInt1, paramInt2, i, j, paramBoolean1);
      if (!paramBoolean2) {
        break label507;
      }
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(false);
      return;
      bool1 = false;
      break;
    }
    label507:
    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(true);
    return;
    label516:
    if (paramMessageForPtt.voiceLength > 0) {
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramMessageForPtt.waveformArray, ((RelativeLayout.LayoutParams)localObject2).width - AIOUtils.dp2px(i, ((Context)localObject1).getResources()), paramMessageForPtt.voiceLength);
    }
    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(0);
    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
  }
  
  private void a(ahdf paramahdf, MessageForPtt paramMessageForPtt, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694935, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      return;
    }
    if (!FileUtil.fileExistsAndNotEmpty(paramMessageForPtt.getLocalFilePath()))
    {
      a(paramahdf, paramMessageForPtt, false, true);
      a(paramahdf, paramMessageForPtt, 5003, false);
      return;
    }
    PttAudioWaveView localPttAudioWaveView = (PttAudioWaveView)paramView.findViewById(2131374243);
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
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramahdf.jdField_b_of_type_Int);
      bdla.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 1, 0, "", "", "", "");
      if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(AIOUtils.getMessage(paramView), i)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694934, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      return;
      i = (int)(paramMessageForPtt.voiceLength * 1000.0F * f);
      continue;
      i = 0;
    }
  }
  
  private void a(ahdf paramahdf, MessageForPtt paramMessageForPtt, boolean paramBoolean)
  {
    paramahdf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    if (paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      if ((this.jdField_a_of_type_Bdts.a(paramMessageForPtt)) && (!paramMessageForPtt.getSttResult().a())) {
        paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(PttAudioWaveView.a(-16777216, 0.5F));
      }
    }
    if (paramahdf.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramahdf.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    if (!paramBoolean) {
      a(-16777216, paramahdf);
    }
  }
  
  private void a(ahdf paramahdf, MessageForPtt paramMessageForPtt, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int j = AIOUtils.dp2px(9.0F, localResources);
    int n = AIOUtils.dp2px(1.5F, localResources);
    int k = AIOUtils.dp2px(12.0F, localResources);
    int m = AIOUtils.dp2px(10.0F, localResources);
    try
    {
      i = localResources.getDrawable(2130844794).getIntrinsicHeight();
      int i1 = AIOUtils.dp2px(1.0F, localResources);
      int i2 = AIOUtils.dp2px(1.5F, localResources);
      paramahdf.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setPadding(0, 0, n, 0);
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setPadding(0, 0, i2, 0);
      Object localObject1 = (RelativeLayout.LayoutParams)paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams();
      if (paramBoolean)
      {
        ((RelativeLayout.LayoutParams)localObject1).width = AIOUtils.dp2px(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPadding(AIOUtils.dp2px(2.0F, localResources) + j, 0, 0, 0);
        if (paramInt1 == 2)
        {
          if (paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
            break label1238;
          }
          ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localImageView.setImageDrawable(new ColorDrawable(838860800));
          RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i1);
          localImageView.setLayoutParams(localLayoutParams1);
          localImageView.setId(2131374260);
          ETTextView localETTextView = new ETTextView(this.jdField_a_of_type_AndroidContentContext);
          if (!paramMessageForPtt.isSend()) {
            break label1190;
          }
          localObject1 = localResources.getColorStateList(2131167049);
          if (localObject1 != null)
          {
            localETTextView.setTextColor((ColorStateList)localObject1);
            if ((paramInt2 == 5) && (paramahdf.jdField_a_of_type_Aqhi != null) && (paramahdf.jdField_a_of_type_Aqhi.jdField_b_of_type_Int != 0)) {
              localETTextView.setTextColor(PttAudioWaveView.a(paramahdf.jdField_a_of_type_Aqhi.jdField_b_of_type_Int, 0.5F));
            }
          }
          localETTextView.setId(2131374259);
          localETTextView.setMaxWidth(BaseChatItemLayout.f);
          localObject4 = new RelativeLayout.LayoutParams(-2, -2);
          localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          ((RelativeLayout)localObject1).setId(2131374256);
          localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
          localProgressBar.setId(2131374257);
          localObject3 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localProgressBar.setIndeterminate(true);
          localProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839466));
          ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(13.0F, localResources);
          ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.dp2px(16.0F, localResources);
          localProgressBar.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject3 = new TextView(BaseApplicationImpl.getContext());
          RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
          ((TextView)localObject3).setLayoutParams(localLayoutParams2);
          ((TextView)localObject3).setText(2131719009);
          ((TextView)localObject3).setTextSize(AIOUtils.dp2px(4.0F, localResources));
          ((TextView)localObject3).setIncludeFontPadding(false);
          localLayoutParams2.addRule(5, 2131374259);
          localLayoutParams2.addRule(8, 2131374253);
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
            ((TextView)localObject3).setText(2131719007);
          }
          localETTextView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          ((RelativeLayout)localObject1).addView(localProgressBar);
          ((RelativeLayout)localObject1).addView(localETTextView);
          localObject4 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject4).setId(2131374253);
          localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
          ((ImageView)localObject4).setLayoutParams(localLayoutParams2);
          ((ImageView)localObject4).setImageResource(2130844794);
          ((ImageView)localObject4).setScaleType(ImageView.ScaleType.FIT_END);
          ((ImageView)localObject4).setOnClickListener(this);
          localLayoutParams1.addRule(3, 2131374240);
          localLayoutParams1.addRule(14);
          localLayoutParams2.addRule(3, 2131374260);
          localLayoutParams2.addRule(14);
          localLayoutParams2.addRule(6, 2131374256);
          localLayoutParams2.addRule(8, 2131374256);
          localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams1.addRule(3, 2131374260);
          ((RelativeLayout)localObject1).setLayoutParams(localLayoutParams1);
          paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localImageView);
          paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject1);
          paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject4);
          paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject3);
          paramahdf.e = localImageView;
          paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView = localETTextView;
          paramahdf.f = ((ImageView)localObject4);
          paramahdf.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject3);
          paramahdf.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
          paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this);
          paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnTouchListener(paramahdf.jdField_a_of_type_Aftk);
          paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnLongClickListener(paramahdf.jdField_a_of_type_Aftk);
          if ((paramInt2 != 5) && (paramInt2 != 6)) {
            break label1421;
          }
          paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(0, AIOUtils.dp2px(17.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramahdf.jdField_a_of_type_Alvu = new alvu();
          paramahdf.jdField_a_of_type_Alvu.a(paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView);
          paramahdf.jdField_a_of_type_Alvu.a(paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
          paramahdf.jdField_a_of_type_Alvu.b(paramMessageForPtt);
          localObject1 = (RelativeLayout.LayoutParams)paramahdf.e.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131374240);
          ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131374240);
          localObject1 = (RelativeLayout.LayoutParams)paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131374240);
          ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131374240);
          paramInt1 = AIOUtils.dp2px(22.0F, localResources);
          paramahdf.e.setPadding(j, 0, j, 0);
          paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(j, BaseChatItemLayout.m, j, paramInt1 + i);
          paramahdf.f.setPadding(0, 0, 0, k);
          paramahdf.jdField_b_of_type_AndroidWidgetTextView.setPadding(j, 0, 0, m);
          paramMessageForPtt = a(paramMessageForPtt, paramInt2);
          paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(paramMessageForPtt);
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
        paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPadding(AIOUtils.dp2px(2.0F, localResources) + j, 0, j, 0);
        continue;
        label1190:
        Object localObject2 = localResources.getColorStateList(2131167045);
        continue;
        label1203:
        ((RelativeLayout.LayoutParams)localObject4).leftMargin = AIOUtils.dp2px(0.0F, localResources);
        localProgressBar.setVisibility(8);
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject3).setText(2131719009);
        continue;
        label1238:
        paramahdf.e.setVisibility(0);
        paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
        paramahdf.f.setVisibility(0);
        localObject2 = (RelativeLayout.LayoutParams)paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
        if ((paramInt2 == 5) || (paramInt2 == 6))
        {
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(25.0F, localResources);
          if (paramInt2 == 5)
          {
            paramahdf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            paramahdf.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          if (paramInt2 == 6)
          {
            ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(0.0F, localResources);
            paramahdf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            paramahdf.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramahdf.jdField_b_of_type_AndroidWidgetTextView.setText(2131719007);
          }
        }
        for (;;)
        {
          paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          break;
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(0.0F, localResources);
          paramahdf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramahdf.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          paramahdf.jdField_b_of_type_AndroidWidgetTextView.setText(2131719009);
        }
        label1421:
        paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
      }
    }
  }
  
  private void a(ahdf paramahdf, MessageForPtt paramMessageForPtt, boolean paramBoolean, View paramView, ChatMessage paramChatMessage)
  {
    paramView = paramView.getResources();
    if (paramChatMessage.isSend())
    {
      paramView = paramView.getColorStateList(2131167049);
      if ((paramahdf.jdField_a_of_type_AndroidWidgetTextView != null) && (paramView != null)) {
        paramahdf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView);
      }
      if ((paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (paramView != null))
      {
        paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramView);
        if ((this.jdField_a_of_type_Bdts.a(paramMessageForPtt)) && (!paramMessageForPtt.getSttResult().a())) {
          paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(PttAudioWaveView.a(paramView.getDefaultColor(), 0.5F));
        }
      }
      if ((paramahdf.jdField_b_of_type_AndroidWidgetTextView != null) && (paramView != null)) {
        paramahdf.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramView);
      }
      if (!paramBoolean)
      {
        if (paramChatMessage.isSend()) {
          break label164;
        }
        a(Color.parseColor("#424448"), paramahdf);
      }
    }
    label164:
    while (paramView == null)
    {
      return;
      paramView = paramView.getColorStateList(2131167045);
      break;
    }
    a(paramView.getDefaultColor(), paramahdf);
  }
  
  private void a(ahdf paramahdf, MessageForPtt paramMessageForPtt, boolean paramBoolean, aqhi paramaqhi)
  {
    paramahdf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaqhi.jdField_b_of_type_Int);
    if (paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaqhi.jdField_b_of_type_Int);
      if ((this.jdField_a_of_type_Bdts.a(paramMessageForPtt)) && (!paramMessageForPtt.getSttResult().a())) {
        paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(PttAudioWaveView.a(paramaqhi.jdField_b_of_type_Int, 0.5F));
      }
    }
    if (paramahdf.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramahdf.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaqhi.jdField_b_of_type_Int);
    }
    if (!paramBoolean) {
      a(paramaqhi.jdField_b_of_type_Int, paramahdf);
    }
  }
  
  private void a(View paramView, ColorFilter paramColorFilter)
  {
    Object localObject = (ahdf)paramView.getTag();
    if (localObject != null)
    {
      paramView = AIOUtils.getMessage(paramView);
      if ((paramView != null) && (paramView.vipBubbleID == 0L))
      {
        localObject = ((ahdf)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getBackground();
        if ((localObject != null) && (paramView.vipBubbleID == 0L))
        {
          ((Drawable)localObject).setColorFilter(paramColorFilter);
          ((Drawable)localObject).invalidateSelf();
        }
      }
    }
  }
  
  private void a(bhjq parambhjq)
  {
    parambhjq.a(2131365307, this.jdField_a_of_type_AndroidContentContext.getString(2131719010), 2130838984);
    parambhjq.a(2131367213, this.jdField_a_of_type_AndroidContentContext.getString(2131689991), 2130838991);
    parambhjq.a(2131366456, this.jdField_a_of_type_AndroidContentContext.getString(2131692126), 2130838990);
    parambhjq.a(2131378158, this.jdField_a_of_type_AndroidContentContext.getString(2131719006), 2130844794);
  }
  
  private void a(bhjq parambhjq, MessageForPtt paramMessageForPtt)
  {
    if (ahdg.c)
    {
      boolean bool1 = MediaPlayerManager.a(paramMessageForPtt.playSpeedPos, MediaPlayerManager.a);
      boolean bool2 = MediaPlayerManager.a(paramMessageForPtt.playSpeedPos, MediaPlayerManager.c);
      if (!bool1) {
        parambhjq.a(2131377948, this.jdField_a_of_type_AndroidContentContext.getString(2131694698), 2130838988);
      }
      if (!bool2) {
        parambhjq.a(2131377946, this.jdField_a_of_type_AndroidContentContext.getString(2131694693), 2130838988);
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
    if (paramInt == 2131377949)
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
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694935, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      }
      for (;;)
      {
        return;
        if (paramInt != 2131377946) {
          break label586;
        }
        f = MediaPlayerManager.c;
        localObject1 = "0X8009DE3";
        break;
        label91:
        boolean bool1 = lfl.a(BaseApplicationImpl.getContext());
        boolean bool2 = AudioHelper.a(BaseApplicationImpl.getContext());
        Object localObject2 = bhfv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.speakerPhoneOn, bool1, bool2, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.playMode, f);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.playMode == 0) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.playMode = bhfv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.speakerPhoneOn, bool1, bool2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, (CharSequence)localObject2, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurType() == 0)
        {
          paramInt = 1;
          bdla.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, paramInt, 0, "", "", "", "");
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
          ahdf localahdf = (ahdf)AIOUtils.getHolder((View)localObject2);
          if ((localObject2 == null) || (localahdf == null)) {
            break label581;
          }
          localObject1 = (MessageForPtt)localahdf.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localahdf.jdField_b_of_type_Int);
          if (localObject1 != null) {
            ((MessageForPtt)localObject1).playSpeedPos = f;
          }
          localahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          localahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
          localahdf.a(true);
          localObject2 = (PttAudioWaveView)((View)localObject2).findViewById(2131374243);
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
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694934, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
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
    admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    PttInfoCollector.reportLongPressPtt(2);
  }
  
  private boolean a(int paramInt, MessageForPtt paramMessageForPtt)
  {
    return ((paramInt == 2003) || (paramInt == 1003)) && (!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt);
  }
  
  private boolean a(ahdf paramahdf, MessageForPtt paramMessageForPtt)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramMessageForPtt.voiceLength <= 1) {
      paramMessageForPtt.voiceLength = QQRecorder.a(paramMessageForPtt);
    }
    if (paramMessageForPtt.voiceLength <= 0)
    {
      ((RelativeLayout.LayoutParams)paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
      paramahdf.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramahdf.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.dp2px(10.0F, (Resources)localObject), BaseChatItemLayout.m, AIOUtils.dp2px(10.0F, (Resources)localObject), BaseChatItemLayout.n);
      if (paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
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
        localObject = ((Resources)localObject).getDrawable(2130840437);
        ((Drawable)localObject).setBounds(0, -5, ((Drawable)localObject).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject).getIntrinsicHeight() * 4 / 5);
        localObject = new biqh((Drawable)localObject, 1).a(0.05F);
        this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localObject, 0, 3, 17);
      }
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_a_of_type_AndroidTextSpannableString, this);
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
    for (paramahdf = "svip";; paramahdf = "vip")
    {
      VasWebviewUtil.reportCommercialDrainage((String)localObject, "LongVoice", "TailView", "0", 1, 0, 0, str, "", paramahdf);
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
        this.jdField_b_of_type_AndroidTextSpannableString = new SpannableString(anvx.a(2131708176));
        localObject = ((Resources)localObject).getDrawable(2130840436);
        ((Drawable)localObject).setBounds(0, -5, ((Drawable)localObject).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject).getIntrinsicHeight() * 4 / 5);
        localObject = new biqh((Drawable)localObject, 1).a(0.05F);
        this.jdField_b_of_type_AndroidTextSpannableString.setSpan(localObject, 0, 3, 17);
      }
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_b_of_type_AndroidTextSpannableString, this);
      break;
    }
  }
  
  private boolean a(bhjq parambhjq, MessageForPtt paramMessageForPtt)
  {
    if (aqvh.a(paramMessageForPtt)) {
      return true;
    }
    if (!paramMessageForPtt.isReady())
    {
      admh.a(parambhjq, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      super.c(parambhjq, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambhjq, this.jdField_a_of_type_AndroidContentContext);
      return true;
    }
    if (QQRecorder.a(paramMessageForPtt) <= 0)
    {
      admh.a(parambhjq, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      super.c(parambhjq, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambhjq, this.jdField_a_of_type_AndroidContentContext);
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
  
  private int b(ahdf paramahdf, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean, String paramString)
  {
    boolean bool2 = alcm.a(paramMessageForPtt);
    if (paramMessageForPtt.voiceChangeFlag != 0) {}
    boolean bool3;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool3 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramahdf, paramMessageForPtt);
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "showPttItem builder, voiceLength:" + paramMessageForPtt.voiceLength);
      }
      if (a(paramahdf, paramMessageForPtt)) {
        break;
      }
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "showPttItem, msgText = " + paramString + ", message.voiceLength" + paramMessageForPtt.voiceLength);
    }
    paramahdf.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    a(paramahdf, bool3, bool1, paramMessageForPtt.isSend());
    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
    paramahdf.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    String str;
    if (paramMessageForPtt.isSend()) {
      if (paramMessageForPtt.mRobotFlag == 1)
      {
        str = ((bgls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
        if (!TextUtils.isEmpty(str)) {
          break label324;
        }
      }
    }
    for (;;)
    {
      if (((paramInt == 2003) || (paramInt == 1003)) && (!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt)) {
        paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
      }
      int i = b(paramMessageForPtt, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramInt = a(paramMessageForPtt, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      a(paramahdf, paramMessageForPtt, bool2, i, paramInt);
      str = a(paramMessageForPtt, paramInt);
      a(paramahdf, paramMessageForPtt, i, bool3, paramString, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem, str);
      return paramInt;
      label324:
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, str, null);
      continue;
      str = ((bgls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
      if (!TextUtils.isEmpty(str)) {
        paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, str, null);
      }
    }
  }
  
  public static int b(MessageForPtt paramMessageForPtt, int paramInt, QQAppInterface paramQQAppInterface)
  {
    bdtt localbdtt = null;
    if (paramQQAppInterface != null) {
      localbdtt = (bdtt)paramQQAppInterface.getManager(QQManagerFactory.STT_MANAGER);
    }
    if ((paramInt == 2003) || (paramInt == 1003))
    {
      if ((paramMessageForPtt.sttAbility == 2) && (paramMessageForPtt.voiceChangeFlag != 1) && (paramMessageForPtt.expandStt)) {
        return 2;
      }
      if (((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3)) && (localbdtt != null) && (localbdtt.a(paramMessageForPtt))) {
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
    return anvx.a(2131708174);
  }
  
  private void b(MessageForPtt paramMessageForPtt, int paramInt)
  {
    this.jdField_a_of_type_Bdts.b(paramMessageForPtt, paramInt);
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
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B40", "0X8005B40", 0, 0, "", "", "", "");
      bdla.b(null, "dc00898", "", "", "0X8009DF7", "0X8009DF7", 0, 0, "", "", "", "");
      localObject = (ahdf)((View)localObject).getTag();
      PttInfoCollector.reportLongPressPtt(5);
      if ((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3))
      {
        if ((paramMessageForPtt.sttAbility == 3) && (!paramMessageForPtt.expandStt)) {
          paramMessageForPtt.expandStt = true;
        }
        h(paramChatMessage);
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramChatMessage.uniseq), "");
        b(paramMessageForPtt, 1);
        this.jdField_a_of_type_Bdts.a(this);
        a((ahdf)localObject, paramMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt), c(paramMessageForPtt));
        return;
      }
    } while ((paramMessageForPtt.sttAbility != 2) || (paramMessageForPtt.expandStt));
    paramMessageForPtt.expandStt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
    a((ahdf)localObject, paramMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt), c(paramMessageForPtt));
    a((afqr)localObject, ((ahdf)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramMessageForPtt, ((ahdf)localObject).jdField_a_of_type_Aqhi);
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
    bmcl localbmcl = new bmcl(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt.voiceType, new ahdd(this, paramMessageForPtt));
    Object localObject;
    if (paramMessageForPtt.isSend())
    {
      localObject = paramMessageForPtt.selfuin;
      Drawable localDrawable = null;
      if (nty.a(paramMessageForPtt)) {
        localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843720);
      }
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, (String)localObject);
      localObject = localBitmap;
      if (localBitmap == null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, paramMessageForPtt.frienduin);
      }
      if (!localbmcl.a(paramMessageForPtt.getLocalFilePath(), i, (Bitmap)localObject, localDrawable)) {
        break label146;
      }
      localbmcl.show();
    }
    for (;;)
    {
      PttInfoCollector.reportLongPressPtt(1);
      return;
      localObject = paramMessageForPtt.senderuin;
      break;
      label146:
      bmar.a(this.jdField_a_of_type_AndroidContentContext, 2131692128, 1);
    }
  }
  
  private boolean d(ChatMessage paramChatMessage)
  {
    return paramChatMessage.vipBubbleID >= 1L;
  }
  
  private void e(MessageForPtt paramMessageForPtt)
  {
    if (TextUtils.isEmpty(paramMessageForPtt.sttText)) {
      paramMessageForPtt = this.jdField_a_of_type_AndroidContentContext.getString(2131719011);
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
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
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
      aupt.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt, 21);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, anvx.a(2131708181), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
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
    ((ahdf)paramMessageForPtt.getTag()).jdField_a_of_type_ComEtrumpMixlayoutETTextView.performClick();
  }
  
  private void h(ChatMessage paramChatMessage)
  {
    if (bhzf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_show_open_svip_gray_msg", false)) {
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
          localObject1 = arjw.c();
          localObject2 = (ardl)aqxe.a().a(442);
          if ((localObject2 != null) && (((ardl)localObject2).a())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is close ,so click ptt msg not add msg");
        return;
        if (((arjv)localObject1).jdField_a_of_type_Int == 3) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is open but stage=" + ((arjv)localObject1).jdField_a_of_type_Int + ",so click ptt msg not add msg");
      return;
      if (!ahdg.d) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is open but switch is open ,so click ptt msg not add msg");
    return;
    Object localObject2 = anvx.a(2131708175);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_action", 41);
    ((Bundle)localObject1).putString("textColor", "#40A0FF");
    localObject2 = new avhz(paramChatMessage.frienduin, paramChatMessage.selfuin, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, -5020, 655392, ((MessageForPtt)paramChatMessage).time);
    ((avhz)localObject2).a(15, 19, (Bundle)localObject1);
    localObject1 = new MessageForUniteGrayTip();
    if (paramChatMessage.istroop == 1) {
      ((MessageForUniteGrayTip)localObject1).shmsgseq = paramChatMessage.shmsgseq;
    }
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (avhz)localObject2);
    avia.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject1);
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    localObject1 = "businessinfo_ptt_auto_change_guide_has_show_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentAccountUin();
    paramChatMessage.edit().putBoolean((String)localObject1, true).commit();
    ahdg.e = true;
    bhzf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_show_open_svip_gray_msg", true);
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
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694935, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
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
        bool1 = lfl.a(BaseApplicationImpl.getContext());
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
        ahdf localahdf = (ahdf)AIOUtils.getHolder((View)localObject2);
        if ((localObject2 == null) || (localahdf == null)) {
          break label526;
        }
        localObject1 = (MessageForPtt)localahdf.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localahdf.jdField_b_of_type_Int);
        localahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
        localahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
        localahdf.a(true);
        localObject2 = (PttAudioWaveView)((View)localObject2).findViewById(2131374243);
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
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694934, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
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
  
  public afqq a(View paramView)
  {
    if (AIOUtils.getMessage(paramView) != null) {
      return this;
    }
    return null;
  }
  
  public afqr a()
  {
    return new ahdf();
  }
  
  @Nullable
  protected agjj a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      return null;
    }
    return (agjj)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(82);
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    paramChatMessage = b(paramChatMessage, paramafqr, paramView, paramBaseChatItemLayout, paramaftk);
    afsl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this);
    if (AppSetting.c) {
      paramafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setOnClickListener(this);
    }
    paramafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bhfj.a(paramChatMessage.issend)) {
      return anvx.a(2131708171);
    }
    return anvx.a(2131708172);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bdts.a(null);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((ahdf)localIterator.next()).a();
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
    if (2131366456 == paramInt)
    {
      d(localMessageForPtt);
      return;
    }
    if (paramInt == 2131365475)
    {
      a(localMessageForPtt, paramChatMessage);
      return;
    }
    if (paramInt == 2131371684)
    {
      PttInfoCollector.reportLongPressPtt(6);
      super.d(paramChatMessage);
      return;
    }
    if (paramInt == 2131365307)
    {
      e(localMessageForPtt);
      return;
    }
    if (paramInt == 2131367213)
    {
      f(localMessageForPtt);
      return;
    }
    if (paramInt == 2131378158)
    {
      g(localMessageForPtt);
      return;
    }
    if (paramInt == 2131378159)
    {
      b(localMessageForPtt, paramChatMessage);
      return;
    }
    if (paramInt == 2131371641)
    {
      if (c(localMessageForPtt)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
      }
      super.a(paramChatMessage);
      return;
    }
    if (paramInt == 2131372930)
    {
      h(localMessageForPtt);
      return;
    }
    if ((paramInt == 2131377948) || (paramInt == 2131377949) || (paramInt == 2131377946))
    {
      a(localMessageForPtt, paramInt);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(afqr paramafqr, View paramView, ChatMessage paramChatMessage, aqhi paramaqhi)
  {
    paramafqr = (ahdf)paramafqr;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramafqr, localMessageForPtt);
    if ((paramaqhi.jdField_a_of_type_Int == 0) || (!paramaqhi.a())) {
      a(paramafqr, localMessageForPtt, bool, paramView, paramChatMessage);
    }
    label214:
    for (;;)
    {
      return;
      if (paramaqhi.jdField_b_of_type_Int == 0) {
        a(paramafqr, localMessageForPtt, bool);
      }
      for (;;)
      {
        if ((!paramaqhi.jdField_b_of_type_Boolean) || (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramafqr.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * paramafqr.jdField_a_of_type_Aqhi.jdField_a_of_type_Double) != 1)) {
          break label214;
        }
        float f2 = paramafqr.jdField_a_of_type_AndroidWidgetTextView.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramafqr.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramafqr.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(f1, 0.0F, 0.0F, paramaqhi.d);
        if (bool) {
          break;
        }
        a(-1, paramafqr);
        return;
        a(paramafqr, localMessageForPtt, bool, paramaqhi);
      }
    }
  }
  
  protected void a(ahdf paramahdf, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag + ", voiceLength is: " + paramMessageForPtt.voiceLength);
    }
    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject = (RelativeLayout.LayoutParams)paramahdf.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(1, -1);
    if (paramahdf.c != null)
    {
      paramahdf.c.setVisibility(8);
      paramahdf.c.setOnClickListener(null);
      paramahdf.d.setVisibility(8);
    }
    if ((paramahdf.jdField_a_of_type_Alvu != null) && (paramahdf.jdField_a_of_type_Alvu.c()) && (paramahdf.jdField_a_of_type_Alvu.a()))
    {
      paramahdf.jdField_a_of_type_Alvu.b();
      paramahdf.jdField_a_of_type_Alvu.d();
    }
    if (paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
      paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(null);
      paramahdf.e.setVisibility(8);
      paramahdf.f.setVisibility(8);
      paramahdf.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramahdf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramahdf.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramahdf.jdField_a_of_type_Aftk);
    paramahdf.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramahdf.jdField_a_of_type_Aftk);
    boolean bool1 = a(paramMessageForPtt, paramahdf);
    boolean bool2 = a(paramInt, paramMessageForPtt);
    localObject = a(paramInt, paramMessageForPtt);
    int i = a(paramahdf, paramMessageForPtt, paramInt, paramBoolean, (String)localObject);
    String str = b(paramInt, paramMessageForPtt);
    if (paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setSeekListener(this);
    }
    switch (i)
    {
    default: 
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
      if (paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) {
        paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
      }
      if (bool1)
      {
        paramMessageForPtt = (aktz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
        if (paramMessageForPtt != null)
        {
          paramMessageForPtt = paramMessageForPtt.a("voice_pwd", anvx.a(2131708177), new String[] { "lowTipStr" });
          label473:
          paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, paramMessageForPtt, null);
        }
      }
      else if (AppSetting.c)
      {
        paramMessageForPtt = anvx.a(2131708168);
        if (!bool2) {
          break label705;
        }
        paramahdf.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject + anvx.a(2131708173) + anvx.a(2131708169));
      }
      break;
    }
    for (;;)
    {
      if (paramahdf.jdField_a_of_type_JavaLangStringBuilder != null)
      {
        paramahdf.jdField_a_of_type_JavaLangStringBuilder.append("发送了语音.").append((String)localObject);
        if (str != null) {
          paramahdf.jdField_a_of_type_JavaLangStringBuilder.append(" ").append(str);
        }
      }
      return;
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
      ImageView localImageView = paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c;
      if (paramMessageForPtt.isSendFromLocal()) {}
      for (paramMessageForPtt = anvx.a(2131708178);; paramMessageForPtt = anvx.a(2131708170))
      {
        localImageView.setContentDescription(paramMessageForPtt);
        break;
      }
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839470, null);
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
      ((Animatable)paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getDrawable()).start();
      break;
      paramMessageForPtt = anvx.a(2131708177);
      break label473;
      label705:
      paramahdf.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject + anvx.a(2131708182));
    }
  }
  
  protected void a(ahdf paramahdf, MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      if (paramBoolean1) {
        i = 2;
      }
    }
    for (int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mEffectPullRefreshCount;; j = 0)
    {
      admh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramMessageForPtt, false, i, j, paramBoolean2);
      return;
      i = 1;
      break;
      i = 5;
    }
  }
  
  protected void a(ahdf paramahdf, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramahdf.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (paramBoolean3)
      {
        localObject = ((Resources)localObject).getDrawable(2130847067);
        if (localObject != null)
        {
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
          paramahdf.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
        }
      }
      do
      {
        return;
        localObject = ((Resources)localObject).getDrawable(2130847065);
      } while (localObject == null);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
      paramahdf.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
      return;
    }
    paramahdf.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
    paramahdf.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public void a(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.getMessage(paramView);
    paramView = (ahdf)AIOUtils.getHolder(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = bkzi.a(this.jdField_a_of_type_AndroidContentContext);
      paramView.a(2131689977);
      paramView.b(2131689976);
      paramView.c(2131690697);
      paramView.a(new ahde(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    if ((!Environment.getExternalStorageState().equals("mounted")) || (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1))
    {
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        QQToast.a(BaseApplication.getContext(), 2131694316, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299080));
        return;
      }
      QQToast.a(BaseApplication.getContext(), 2131718342, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299080));
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
        paramView = (ahdf)((View)paramView.getParent().getParent()).getTag();
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
        localObject = (afqr)paramView.getTag();
        paramView = (BaseChatItemLayout)paramView;
        b(paramChatMessage, (afqr)localObject, ((afqr)localObject).jdField_a_of_type_AndroidViewView, paramView, null);
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
    paramView = (ahdf)AIOUtils.getHolder(paramView);
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
          localObject = (ahdf)localView.getTag();
          if (localObject == null) {
            break label196;
          }
          localObject = ((ahdf)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView;
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
    paramPttAudioWaveView = (ahdf)AIOUtils.getHolder(paramPttAudioWaveView);
    if (paramPttAudioWaveView != null)
    {
      MediaPlayerManager localMediaPlayerManager = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localMediaPlayerManager.a(localMediaPlayerManager.a(), paramPttAudioWaveView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView, float paramFloat)
  {
    paramPttAudioWaveView = (ahdf)AIOUtils.getHolder(paramPttAudioWaveView);
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
    agjj localagjj = a();
    if (localagjj != null) {
      localagjj.b(paramMessageForPtt);
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
      agjj localagjj = a();
      if (localagjj != null) {
        localagjj.a(paramMessageForPtt);
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean, ahdf paramahdf)
  {
    this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramMessageForPtt.isSend())
    {
      if (d(paramMessageForPtt))
      {
        paramMessageForPtt = paramahdf.jdField_a_of_type_AndroidWidgetImageView;
        if (paramBoolean) {}
        for (i = 2130847063;; i = 2130847066)
        {
          paramMessageForPtt.setImageResource(i);
          return;
        }
      }
      paramMessageForPtt = paramahdf.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {}
      for (i = 2130849991;; i = 2130849992)
      {
        paramMessageForPtt.setImageResource(i);
        return;
      }
    }
    if (d(paramMessageForPtt))
    {
      paramMessageForPtt = paramahdf.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {}
      for (i = 2130847057;; i = 2130847064)
      {
        paramMessageForPtt.setImageResource(i);
        return;
      }
    }
    paramMessageForPtt = paramahdf.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i = 2130849985;; i = 2130849984)
    {
      paramMessageForPtt.setImageResource(i);
      return;
    }
  }
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ahdf paramahdf)
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
              i = 2130772262;
              paramMessageForPtt = (AnimationDrawable)localResources.getDrawable(i);
              paramahdf.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForPtt);
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
            i = 2130772260;
            continue;
          }
        }
        else
        {
          a(paramMessageForPtt, paramBoolean3, paramahdf);
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
      int i = 2130772261;
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
        i = 2130772259;
        continue;
        label169:
        if (paramBoolean3) {
          i = 2130772346;
        } else {
          i = 2130772345;
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
      if ((paramXListView instanceof ahdf))
      {
        paramXListView = (ahdf)paramXListView;
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
      if ((paramXListView instanceof ahdf))
      {
        paramXListView = (ahdf)paramXListView;
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
  
  public boolean a(afqr paramafqr)
  {
    return paramafqr instanceof ahdf;
  }
  
  protected boolean a(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, afqr paramafqr, MessageForPtt paramMessageForPtt)
  {
    return VoicePrintUtils.a(paramQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramafqr, paramMessageForPtt);
  }
  
  protected boolean a(MessageForPtt paramMessageForPtt, ahdf paramahdf)
  {
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = true;
    Object localObject;
    if (alcm.a(paramMessageForPtt)) {
      if (CustomizeStrategyFactory.a().a())
      {
        localObject = (aktz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
        if (localObject != null)
        {
          i = ((aktz)localObject).a("voice_pwd", 1, new String[] { "scoreSwitch" });
          if (i != 1) {
            break label361;
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
            break label398;
          }
          paramahdf.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramMessageForPtt.icon);
        }
      }
    }
    label393:
    label398:
    for (int i = 1;; i = 0)
    {
      bool1 = false;
      for (;;)
      {
        label188:
        paramMessageForPtt = paramahdf.jdField_b_of_type_AndroidWidgetImageView;
        if (i != 0)
        {
          i = j;
          label200:
          paramMessageForPtt.setVisibility(i);
        }
        label213:
        label361:
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
                  break label393;
                }
                if (localObject != null) {
                  break label331;
                }
                i = 5;
                int k = akrn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "voice_low_tips_count", 0);
                if (k >= i) {
                  break label393;
                }
                paramMessageForPtt.saveExtInfoToExtStr("voice_low_tips_tag", "1");
                ThreadManager.post(new PttItemBuilder.2(this, paramMessageForPtt), 10, null, false);
                akrn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "voice_low_tips_count", k + 1);
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
                continue;
                i = ((aktz)localObject).a("voice_pwd", 5, new String[] { "lowTipsLimit" });
              }
            }
          }
          CustomizeStrategyFactory.a().b(true);
          i = 0;
          bool1 = false;
          break label188;
          i = 8;
          break label200;
        } while (paramahdf.jdField_b_of_type_AndroidWidgetImageView == null);
        label331:
        paramahdf.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        return false;
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
    bahy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramXListView);
    if (paramXListView.isReady())
    {
      paramView = AIOUtils.getHolder(paramView);
      if ((paramView != null) && (!(paramView instanceof ahdf))) {
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "play failed not Holder " + paramXListView.getLocalFilePath());
        }
      }
      do
      {
        return false;
        paramView = (ahdf)paramView;
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
          a(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout, paramXListView, paramView.jdField_a_of_type_Aqhi, 0);
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
  
  public bhjs[] a(View paramView)
  {
    return a(new bhjq(), (MessageForPtt)AIOUtils.getMessage(paramView), paramView instanceof alwg);
  }
  
  protected bhjs[] a(bhjq parambhjq, MessageForPtt paramMessageForPtt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramMessageForPtt.sttAbility == 2) && (paramMessageForPtt.expandStt))
    {
      a(parambhjq);
      return parambhjq.a();
    }
    if (a(parambhjq, paramMessageForPtt)) {
      return parambhjq.a();
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
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131694694);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.speakerPhoneOn)) {
          break label383;
        }
        i = 2130838988;
        label119:
        parambhjq.a(2131372930, str, i);
      }
    }
    else
    {
      if (((paramMessageForPtt.extraflag != 32768) && (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt) == 1003) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramMessageForPtt))) || (TroopUtils.isSupportRevokeMsgByTroopOwnerOrMgr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        a(parambhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramMessageForPtt);
      }
      a(parambhjq, paramMessageForPtt);
      if (paramMessageForPtt.voiceChangeFlag != 1)
      {
        if ((paramMessageForPtt.sttAbility != 1) && (paramMessageForPtt.sttAbility != 3)) {
          break label391;
        }
        if ((!this.jdField_a_of_type_Bdts.a(paramMessageForPtt)) && ((!paramMessageForPtt.isSend()) || (paramMessageForPtt.fileSize > 0L)) && (!alcm.a(paramMessageForPtt))) {
          parambhjq.a(2131378159, this.jdField_a_of_type_AndroidContentContext.getString(2131719012), 2130838981);
        }
      }
    }
    for (;;)
    {
      a(paramMessageForPtt, parambhjq);
      parambhjq.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691219));
      a(parambhjq, paramMessageForPtt);
      parambhjq.a(2131366456, this.jdField_a_of_type_AndroidContentContext.getString(2131692126), 2130838990);
      super.a(parambhjq, this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt);
      b(paramMessageForPtt, parambhjq);
      super.c(parambhjq, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambhjq, this.jdField_a_of_type_AndroidContentContext);
      return parambhjq.a();
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131694696);
      break;
      label383:
      i = 2130838992;
      break label119;
      label391:
      if ((paramMessageForPtt.sttAbility == 2) && (!paramMessageForPtt.expandStt) && (!alcm.a(paramMessageForPtt))) {
        parambhjq.a(2131378159, this.jdField_a_of_type_AndroidContentContext.getString(2131719012), 2130838981);
      }
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "1", "", "", "");
  }
  
  protected View b(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    paramBaseChatItemLayout = (ahdf)paramafqr;
    this.jdField_a_of_type_JavaUtilSet.add(paramBaseChatItemLayout);
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramafqr = a();
    if (paramafqr != null) {
      paramafqr.a(paramBaseChatItemLayout, localMessageForPtt, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
    }
    paramafqr = paramView;
    if (paramView == null)
    {
      paramafqr = new BreathAnimationLayout(this.jdField_a_of_type_AndroidContentContext);
      paramafqr.setId(2131374237);
      paramView = new PttAudioPlayView(this.jdField_a_of_type_AndroidContentContext, 12);
      paramView.setThemeColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167045).getDefaultColor());
      paramView.setId(2131374242);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject1).width = AIOUtils.dp2px(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject1).height = AIOUtils.dp2px(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new PttAudioChangeView(this.jdField_a_of_type_AndroidContentContext, 2130838252, 8);
      ((PttAudioChangeView)localObject1).setThemeColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167045).getDefaultColor());
      ((PttAudioChangeView)localObject1).setId(2131374248);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject2).width = AIOUtils.dp2px(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject2).height = AIOUtils.dp2px(19.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((PttAudioChangeView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new PttAudioWaveView(this.jdField_a_of_type_AndroidContentContext);
      ((PttAudioWaveView)localObject2).setProgressColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167045).getDefaultColor());
      ((PttAudioWaveView)localObject2).setId(2131374243);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject3).width = AIOUtils.dp2px(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject3).height = AIOUtils.dp2px(52.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((PttAudioWaveView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject3).setId(2131374244);
      ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167045));
      VoicePrintUtils.VoicePrintView localVoicePrintView = new VoicePrintUtils.VoicePrintView(this.jdField_a_of_type_AndroidContentContext);
      localVoicePrintView.setId(2131374245);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setId(2131374247);
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
      ((RelativeLayout)localObject4).setId(2131374240);
      ((RelativeLayout)localObject4).addView((View)localObject2);
      ((RelativeLayout)localObject4).addView(paramView);
      ((RelativeLayout)localObject4).addView((View)localObject1);
      ((RelativeLayout)localObject4).addView((View)localObject3);
      ((RelativeLayout)localObject4).addView(localVoicePrintView);
      ((RelativeLayout)localObject4).addView(localImageView);
      paramafqr.addView((View)localObject4);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = paramafqr;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView = ((PttAudioChangeView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject2);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView = localVoicePrintView;
      paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView = localImageView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject4);
    }
    if (paramaftk != null) {
      paramBaseChatItemLayout.jdField_a_of_type_Aftk = paramaftk;
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
      paramView.addRule(1, 2131374245);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, 2131374247);
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
      if (((localMessageForPtt.istroop == 1) || (localMessageForPtt.istroop == 3000)) && (i == 2003) && (this.jdField_a_of_type_Bdts.b(localMessageForPtt)))
      {
        b(localMessageForPtt, 2);
        bdla.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
      }
      a(paramBaseChatItemLayout, localMessageForPtt, i, c(localMessageForPtt));
      bahy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(localMessageForPtt);
      PttInfoCollector.reportPttItemBuilderType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramChatMessage);
      return paramafqr;
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
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnTouchListener(paramBaseChatItemLayout.jdField_a_of_type_Aftk);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnLongClickListener(paramBaseChatItemLayout.jdField_a_of_type_Aftk);
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
      paramView.addRule(1, 2131374243);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131374248);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getLayoutParams()).addRule(1, 2131374247);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374242);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
      continue;
      label1379:
      if (bool)
      {
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374244);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131374245);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, -1);
      }
      else
      {
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131374243);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131374248);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getLayoutParams()).addRule(1, 2131374247);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374242);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
      }
    }
  }
  
  public void b(MessageForPtt paramMessageForPtt)
  {
    agjj localagjj = a();
    if (localagjj != null) {
      localagjj.c(paramMessageForPtt);
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
    if ((AppSetting.c) && (i == 2131363423)) {
      paramView.findViewById(2131374240).performClick();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = (ahdf)AIOUtils.getHolder(paramView);
      Object localObject2 = (MessageForPtt)((ahdf)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((i == 2131374240) || (i == 2131374243))
      {
        if (localObject2 != null)
        {
          if (c((ChatMessage)localObject2))
          {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
            bdla.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 2, 0, "", "", "", "");
          }
          for (;;)
          {
            if (((MessageForPtt)localObject2).istroop == 1008) {
              olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", ((MessageForPtt)localObject2).timeStr, "", false);
            }
            if (((MessageForPtt)localObject2).voiceChangeFlag != 1) {
              break;
            }
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F7E", 0, 0, "" + ((MessageForPtt)localObject2).istroop, "", "", "");
            break;
            if ((localObject2 != MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (((MessageForPtt)localObject2).isReady())) {
              a((ahdf)localObject1, (MessageForPtt)localObject2, paramView);
            }
          }
        }
      }
      else if ((i == 2131374259) || (i == 2131374253))
      {
        if ((localObject2 != null) && (((MessageForPtt)localObject2).expandStt))
        {
          ((MessageForPtt)localObject2).expandStt = false;
          ((MessageForPtt)localObject2).serial();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, ((MessageForPtt)localObject2).uniseq, ((MessageForPtt)localObject2).msgData);
          a((ahdf)localObject1, (MessageForPtt)localObject2, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForPtt)localObject2), c((ChatMessage)localObject2));
          bdla.b(null, "dc00898", "", "", "0X8009DF8", "0X8009DF8", 0, 0, "", "", "", "");
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
        }
      }
      else if (i == 2131364551)
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
 * Qualified Name:     ahdc
 * JD-Core Version:    0.7.0.1
 */