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
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
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
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PttAudioChangeView;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder.2;
import com.tencent.mobileqq.activity.aio.item.SyncParentPressedRelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.model.ChatBackgroundManager;
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

public class ahnz
  extends BaseBubbleBuilder
  implements aggk, aggp, aghj, agif, agjg, ahny, bduj
{
  protected SpannableString a;
  protected TextView a;
  protected bdug a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private Map<Long, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  Set<ahoc> jdField_a_of_type_JavaUtilSet = new HashSet();
  protected SpannableString b;
  
  public ahnz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Bdug = ((bdug)paramQQAppInterface.getManager(17));
    this.jdField_a_of_type_Bdug.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private int a(ahoc paramahoc, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramMessageForPtt.voiceChangeFlag != 0) {}
    boolean bool2;
    Resources localResources;
    int i;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramahoc, paramMessageForPtt);
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      i = agej.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      switch (paramInt)
      {
      default: 
        return 0;
      }
    }
    return 7;
    paramahoc.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    paramahoc.jdField_a_of_type_AndroidWidgetTextView.setPadding(agej.a(10.0F, localResources), BaseChatItemLayout.m, agej.a(10.0F, localResources), BaseChatItemLayout.n);
    if (paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    }
    a(paramahoc, bool2, bool1, paramMessageForPtt.isSend());
    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
    ((RelativeLayout.LayoutParams)paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
    return 1;
    ((RelativeLayout.LayoutParams)paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
    paramahoc.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    paramahoc.jdField_a_of_type_AndroidWidgetTextView.setPadding(agej.a(40.0F, localResources), BaseChatItemLayout.m, agej.a(40.0F, localResources), BaseChatItemLayout.n);
    if (paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    }
    if (paramInt == 999)
    {
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(8);
      return 0;
    }
    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
    return 0;
    return b(paramahoc, paramMessageForPtt, paramInt, paramBoolean, paramString);
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
      paramInt1 = agej.a(paramInt1, paramContext.getResources());
      if (paramFloat <= 0.0F) {
        break label196;
      }
      paramInt1 = Math.max(paramInt1 + agej.a(paramInt2, paramContext.getResources()) + agej.a(paramInt3, paramContext.getResources()), (int)paramFloat);
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
      return paramInt1 - agej.a(paramInt2 - 40, paramContext.getResources());
      paramInt1 = 15 + (int)(PttAudioWaveView.a(paramInt1, 60, 1.5F) * 125.0F);
      break;
      return paramInt1 + agej.a(paramInt3, paramContext.getResources());
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
      j = agej.a(i + 20, paramContext.getResources());
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
        int k = agej.a(f2, paramContext.getResources());
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
      if ((paramMessageForPtt.url != null) && (paramMessageForPtt.url.startsWith(antf.aZ))) {
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
              j = bamk.a(paramQQAppInterface, paramMessageForPtt);
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
  
  private void a(int paramInt, ahoc paramahoc)
  {
    if (paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(paramInt);
    }
    if (paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(paramInt);
    }
    if (paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) {
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(paramInt);
    }
  }
  
  private void a(ahoc paramahoc, MessageForPtt paramMessageForPtt, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694616, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      return;
    }
    if (!auog.b(paramMessageForPtt.getLocalFilePath()))
    {
      a(paramahoc, paramMessageForPtt, false, true);
      a(paramahoc, paramMessageForPtt, 5003, false);
      return;
    }
    PttAudioWaveView localPttAudioWaveView = (PttAudioWaveView)paramView.findViewById(2131374269);
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
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramahoc.jdField_b_of_type_Int);
      bdll.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 1, 0, "", "", "", "");
      if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(agej.a(paramView), i)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694615, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      return;
      i = (int)(paramMessageForPtt.voiceLength * 1000.0F * f);
      continue;
      i = 0;
    }
  }
  
  private void a(ahoc paramahoc, MessageForPtt paramMessageForPtt, boolean paramBoolean)
  {
    paramahoc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    if (paramahoc.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      paramahoc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      if (this.jdField_a_of_type_Bdug.a(paramMessageForPtt)) {
        paramahoc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(PttAudioWaveView.a(-16777216, 0.5F));
      }
      if ((paramahoc.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) && (paramahoc.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getVisibility() == 0))
      {
        paramahoc.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(-16777216);
        paramahoc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(PttAudioWaveView.a(-16777216, 0.5F));
      }
    }
    if (!paramBoolean) {
      a(-16777216, paramahoc);
    }
  }
  
  private void a(ahoc paramahoc, MessageForPtt paramMessageForPtt, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int j = agej.a(9.0F, localResources);
    int m = agej.a(1.5F, localResources);
    int k = agej.a(12.0F, localResources);
    try
    {
      i = localResources.getDrawable(2130844849).getIntrinsicHeight();
      int n = agej.a(1.0F, localResources);
      int i1 = agej.a(1.5F, localResources);
      paramahoc.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setPadding(0, 0, m, 0);
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setPadding(0, 0, i1, 0);
      Object localObject1 = (RelativeLayout.LayoutParams)paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams();
      if (paramBoolean)
      {
        ((RelativeLayout.LayoutParams)localObject1).width = agej.a(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPadding(agej.a(2.0F, localResources) + j, 0, 0, 0);
        if (paramInt1 == 2)
        {
          if (paramahoc.jdField_b_of_type_AndroidWidgetTextView != null) {
            break label1214;
          }
          ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localImageView.setImageDrawable(new ColorDrawable(838860800));
          RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, n);
          localImageView.setLayoutParams(localLayoutParams1);
          localImageView.setId(2131374286);
          TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
          if (!paramMessageForPtt.isSend()) {
            break label1173;
          }
          localObject1 = localResources.getColorStateList(2131167013);
          if (localObject1 != null)
          {
            localTextView.setTextColor((ColorStateList)localObject1);
            if ((paramInt2 == 5) && (paramahoc.jdField_a_of_type_Aqkt != null) && (paramahoc.jdField_a_of_type_Aqkt.jdField_b_of_type_Int != 0)) {
              localTextView.setTextColor(PttAudioWaveView.a(paramahoc.jdField_a_of_type_Aqkt.jdField_b_of_type_Int, 0.5F));
            }
          }
          localTextView.setId(2131374285);
          localTextView.setMaxWidth(BaseChatItemLayout.f);
          localObject4 = new RelativeLayout.LayoutParams(-2, -2);
          localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          ((RelativeLayout)localObject1).setId(2131374282);
          localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
          localProgressBar.setId(2131374283);
          localObject3 = new RelativeLayout.LayoutParams(agej.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localProgressBar.setIndeterminate(true);
          localProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839410));
          ((RelativeLayout.LayoutParams)localObject3).topMargin = agej.a(13.0F, localResources);
          ((RelativeLayout.LayoutParams)localObject3).leftMargin = agej.a(16.0F, localResources);
          localProgressBar.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject3 = new PttAudioChangeView(this.jdField_a_of_type_AndroidContentContext, 2130838206, 6);
          ((PttAudioChangeView)localObject3).setThemeColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167009).getDefaultColor());
          ((PttAudioChangeView)localObject3).setId(2131374284);
          RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(agej.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams2.topMargin = agej.a(13.0F, localResources);
          localLayoutParams2.leftMargin = agej.a(16.0F, localResources);
          ((PttAudioChangeView)localObject3).setLayoutParams(localLayoutParams2);
          if ((paramInt2 != 5) && (paramInt2 != 6)) {
            break label1186;
          }
          ((RelativeLayout.LayoutParams)localObject4).leftMargin = agej.a(25.0F, localResources);
          if (paramInt2 == 5)
          {
            localProgressBar.setVisibility(0);
            ((PttAudioChangeView)localObject3).setVisibility(8);
          }
          if (paramInt2 == 6)
          {
            ((PttAudioChangeView)localObject3).setVisibility(0);
            localProgressBar.setVisibility(8);
          }
          localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          ((RelativeLayout)localObject1).addView((View)localObject3);
          ((RelativeLayout)localObject1).addView(localProgressBar);
          ((RelativeLayout)localObject1).addView(localTextView);
          localObject4 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject4).setId(2131374279);
          localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
          ((ImageView)localObject4).setLayoutParams(localLayoutParams2);
          ((ImageView)localObject4).setImageResource(2130844849);
          ((ImageView)localObject4).setScaleType(ImageView.ScaleType.FIT_END);
          ((ImageView)localObject4).setOnClickListener(this);
          localLayoutParams1.addRule(3, 2131374266);
          localLayoutParams1.addRule(14);
          localLayoutParams2.addRule(3, 2131374286);
          localLayoutParams2.addRule(14);
          localLayoutParams2.addRule(6, 2131374282);
          localLayoutParams2.addRule(8, 2131374282);
          localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams1.addRule(3, 2131374286);
          ((RelativeLayout)localObject1).setLayoutParams(localLayoutParams1);
          paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localImageView);
          paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject1);
          paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject4);
          paramahoc.e = localImageView;
          paramahoc.jdField_b_of_type_AndroidWidgetTextView = localTextView;
          paramahoc.f = ((ImageView)localObject4);
          paramahoc.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView = ((PttAudioChangeView)localObject3);
          paramahoc.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
          paramahoc.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
          paramahoc.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(paramahoc.jdField_a_of_type_Agjk);
          paramahoc.jdField_b_of_type_AndroidWidgetTextView.setOnLongClickListener(paramahoc.jdField_a_of_type_Agjk);
          if ((paramInt2 != 5) && (paramInt2 != 6)) {
            break label1367;
          }
          paramahoc.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, agej.a(17.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localObject1 = (RelativeLayout.LayoutParams)paramahoc.e.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131374266);
          ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131374266);
          localObject1 = (RelativeLayout.LayoutParams)paramahoc.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131374266);
          ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131374266);
          paramInt1 = agej.a(22.0F, localResources);
          paramahoc.e.setPadding(j, 0, j, 0);
          paramahoc.jdField_b_of_type_AndroidWidgetTextView.setPadding(j, BaseChatItemLayout.m, j, paramInt1 + i);
          paramahoc.f.setPadding(0, 0, 0, k);
          localObject1 = paramMessageForPtt.sttText;
          if (paramInt2 != 5) {
            break label1386;
          }
          paramMessageForPtt = (String)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramMessageForPtt.uniseq));
          paramahoc.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForPtt);
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
        int i = agej.a(24.0F, localResources);
        QLog.e("PttItemBuilder", 1, "", localException);
        continue;
        localException.width = agej.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPadding(agej.a(2.0F, localResources) + j, 0, j, 0);
        continue;
        label1173:
        Object localObject2 = localResources.getColorStateList(2131167009);
        continue;
        label1186:
        ((RelativeLayout.LayoutParams)localObject4).leftMargin = agej.a(0.0F, localResources);
        ((PttAudioChangeView)localObject3).setVisibility(8);
        localProgressBar.setVisibility(8);
        continue;
        label1214:
        paramahoc.e.setVisibility(0);
        paramahoc.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramahoc.f.setVisibility(0);
        localObject2 = (RelativeLayout.LayoutParams)paramahoc.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if ((paramInt2 == 5) || (paramInt2 == 6))
        {
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = agej.a(25.0F, localResources);
          if (paramInt2 == 5)
          {
            paramahoc.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            paramahoc.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
          }
          if (paramInt2 == 6)
          {
            paramahoc.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(0);
            paramahoc.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          }
        }
        for (;;)
        {
          paramahoc.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          break;
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = agej.a(0.0F, localResources);
          paramahoc.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
          paramahoc.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
        label1367:
        paramahoc.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        continue;
        label1386:
        paramMessageForPtt = (MessageForPtt)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramMessageForPtt = this.jdField_a_of_type_AndroidContentContext.getString(2131718376);
        }
      }
    }
  }
  
  private void a(ahoc paramahoc, MessageForPtt paramMessageForPtt, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, String paramString, boolean paramBoolean4)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
    int j = agej.a(1.5F, (Resources)localObject1);
    int k = agej.a(9.0F, (Resources)localObject1);
    float f = 0.0F;
    if (paramInt == 2)
    {
      localObject2 = paramMessageForPtt.sttText;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131718376);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      f = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText((String)localObject1);
    }
    int i = k + 44 + (int)agej.a((int)paramahoc.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(paramString), this.jdField_a_of_type_AndroidContentContext.getResources());
    paramInt = i;
    if (paramBoolean2) {
      paramInt = i + 16;
    }
    i = paramInt;
    if (paramBoolean1) {
      i = paramInt + 38;
    }
    paramInt = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt.voiceLength, f, i, j, paramBoolean2, paramBoolean1);
    Object localObject2 = (RelativeLayout.LayoutParams)paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).width = paramInt;
    paramString = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean3, paramBoolean2, paramInt + k, paramahoc);
    localObject1 = (RelativeLayout.LayoutParams)paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).width = (paramString[0] + paramString[1] + paramString[2]);
    ((RelativeLayout.LayoutParams)localObject1).height = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean3, paramahoc);
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "message seq=" + paramMessageForPtt.uniseq + ", VpLp.width=" + ((RelativeLayout.LayoutParams)localObject1).width + ", flagTimeContainer.getLeft()=" + paramahoc.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft());
    }
    if ((paramBoolean3) && (((RelativeLayout.LayoutParams)localObject1).height > 0))
    {
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(8);
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
      Object localObject3 = paramahoc.jdField_a_of_type_Aqkt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7);
      if ((((aqku)((Pair)localObject3).first).a != null) && (((aqku)((Pair)localObject3).first).a.length > 0))
      {
        localObject2 = paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView;
        localObject3 = (aqku)((Pair)localObject3).first;
        paramInt = paramString[0];
        i = ((RelativeLayout.LayoutParams)localObject1).height;
        j = paramString[1];
        k = paramString[2];
        if (paramMessageForPtt.isSend()) {
          break label507;
        }
      }
      label507:
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        ((VoicePrintUtils.VoicePrintView)localObject2).setBitmap((aqku)localObject3, paramInt, i, j, k, paramBoolean1);
        if (!paramBoolean4) {
          break;
        }
        paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(false);
        return;
      }
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(true);
      return;
    }
    if (paramMessageForPtt.voiceLength > 0) {
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramMessageForPtt.waveformArray, ((RelativeLayout.LayoutParams)localObject2).width - agej.a(j, this.jdField_a_of_type_AndroidContentContext.getResources()), paramMessageForPtt.voiceLength);
    }
    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(0);
    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
  }
  
  private void a(ahoc paramahoc, MessageForPtt paramMessageForPtt, boolean paramBoolean, View paramView, ChatMessage paramChatMessage)
  {
    paramView = paramView.getResources();
    if (paramChatMessage.isSend())
    {
      paramView = paramView.getColorStateList(2131167013);
      if ((paramahoc.jdField_a_of_type_AndroidWidgetTextView != null) && (paramView != null)) {
        paramahoc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView);
      }
      if ((paramahoc.jdField_b_of_type_AndroidWidgetTextView != null) && (paramView != null))
      {
        paramahoc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramView);
        if (this.jdField_a_of_type_Bdug.a(paramMessageForPtt)) {
          paramahoc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(PttAudioWaveView.a(paramView.getDefaultColor(), 0.5F));
        }
        if ((paramahoc.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) && (paramahoc.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getVisibility() == 0))
        {
          paramahoc.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(paramView.getDefaultColor());
          paramahoc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(PttAudioWaveView.a(paramView.getDefaultColor(), 0.5F));
        }
      }
      if (!paramBoolean)
      {
        if (paramChatMessage.isSend()) {
          break label180;
        }
        a(Color.parseColor("#424448"), paramahoc);
      }
    }
    label180:
    while (paramView == null)
    {
      return;
      paramView = paramView.getColorStateList(2131167009);
      break;
    }
    a(paramView.getDefaultColor(), paramahoc);
  }
  
  private void a(ahoc paramahoc, MessageForPtt paramMessageForPtt, boolean paramBoolean, aqkt paramaqkt)
  {
    paramahoc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaqkt.jdField_b_of_type_Int);
    if (paramahoc.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      paramahoc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaqkt.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Bdug.a(paramMessageForPtt)) {
        paramahoc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(PttAudioWaveView.a(paramaqkt.jdField_b_of_type_Int, 0.5F));
      }
      if ((paramahoc.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) && (paramahoc.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getVisibility() == 0))
      {
        paramahoc.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(paramaqkt.jdField_b_of_type_Int);
        paramahoc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(PttAudioWaveView.a(paramaqkt.jdField_b_of_type_Int, 0.5F));
      }
    }
    if (!paramBoolean) {
      a(paramaqkt.jdField_b_of_type_Int, paramahoc);
    }
  }
  
  private void a(View paramView, ColorFilter paramColorFilter)
  {
    Object localObject = (ahoc)paramView.getTag();
    if (localObject != null)
    {
      paramView = agej.a(paramView);
      if ((paramView != null) && (paramView.vipBubbleID == 0L))
      {
        localObject = ((ahoc)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getBackground();
        if ((localObject != null) && (paramView.vipBubbleID == 0L))
        {
          ((Drawable)localObject).setColorFilter(paramColorFilter);
          ((Drawable)localObject).invalidateSelf();
        }
      }
    }
  }
  
  private void a(bhuk parambhuk, MessageForPtt paramMessageForPtt)
  {
    if (ahod.c)
    {
      boolean bool1 = MediaPlayerManager.a(paramMessageForPtt.playSpeedPos, MediaPlayerManager.a);
      boolean bool2 = MediaPlayerManager.a(paramMessageForPtt.playSpeedPos, MediaPlayerManager.b);
      boolean bool3 = MediaPlayerManager.a(paramMessageForPtt.playSpeedPos, MediaPlayerManager.c);
      if (!bool1) {
        parambhuk.a(2131377904, this.jdField_a_of_type_AndroidContentContext.getString(2131694383), 2130838936);
      }
      if (!bool2) {
        parambhuk.a(2131377905, this.jdField_a_of_type_AndroidContentContext.getString(2131694382), 2130838936);
      }
      if (!bool3) {
        parambhuk.a(2131377902, this.jdField_a_of_type_AndroidContentContext.getString(2131694378), 2130838936);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "getMenuItem speed:" + paramMessageForPtt.playSpeedPos);
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
    float f = MediaPlayerManager.a;
    Object localObject1 = "0X8009DE4";
    if (paramInt == 2131377905)
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
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
          break label91;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694616, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      }
      for (;;)
      {
        return;
        if (paramInt != 2131377902) {
          break label586;
        }
        f = MediaPlayerManager.c;
        localObject1 = "0X8009DE3";
        break;
        label91:
        boolean bool1 = lfm.a(BaseApplicationImpl.getContext());
        boolean bool2 = AudioHelper.a(BaseApplicationImpl.getContext());
        Object localObject2 = bhog.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l, bool1, bool2, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n, f);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n == 0) {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n = bhog.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l, bool1, bool2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, (CharSequence)localObject2, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b() == 0)
        {
          paramInt = 1;
          bdll.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, paramInt, 0, "", "", "", "");
          if (c(paramMessageForPtt)) {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
          }
          if (QLog.isColorLevel()) {
            QLog.d("PttItemBuilder", 2, "getMenuItem oriSpeed:" + paramMessageForPtt.playSpeedPos + ", newSpeed:" + f);
          }
          paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aggs.a(paramMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
          int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
          if (paramInt < 0) {
            break label581;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(paramInt - i);
          ahoc localahoc = (ahoc)agej.a((View)localObject2);
          if ((localObject2 == null) || (localahoc == null)) {
            break label581;
          }
          localObject1 = (MessageForPtt)localahoc.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localahoc.jdField_b_of_type_Int);
          if (localObject1 != null) {
            ((MessageForPtt)localObject1).playSpeedPos = f;
          }
          localahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          localahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
          localahoc.a(true);
          localObject2 = (PttAudioWaveView)((View)localObject2).findViewById(2131374269);
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
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694615, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
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
    aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    bewa.a(2);
  }
  
  private boolean a(int paramInt, MessageForPtt paramMessageForPtt)
  {
    return ((paramInt == 2003) || (paramInt == 1003)) && (!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt);
  }
  
  private boolean a(ahoc paramahoc, MessageForPtt paramMessageForPtt)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = agej.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramMessageForPtt.voiceLength <= 1) {
      paramMessageForPtt.voiceLength = QQRecorder.a(paramMessageForPtt);
    }
    if (paramMessageForPtt.voiceLength <= 0)
    {
      ((RelativeLayout.LayoutParams)paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
      paramahoc.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramahoc.jdField_a_of_type_AndroidWidgetTextView.setPadding(agej.a(10.0F, (Resources)localObject), BaseChatItemLayout.m, agej.a(10.0F, (Resources)localObject), BaseChatItemLayout.n);
      if (paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
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
        localObject = ((Resources)localObject).getDrawable(2130840362);
        ((Drawable)localObject).setBounds(0, -5, ((Drawable)localObject).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject).getIntrinsicHeight() * 4 / 5);
        localObject = new bizo((Drawable)localObject, 1).a(0.05F);
        this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localObject, 0, 3, 17);
      }
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_a_of_type_AndroidTextSpannableString, this);
      if (VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        str = nnr.a();
        if (!VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label460;
        }
      }
    }
    label460:
    for (paramahoc = "svip";; paramahoc = "vip")
    {
      VasWebviewUtil.reportCommercialDrainage((String)localObject, "LongVoice", "TailView", "0", 1, 0, 0, str, "", paramahoc);
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
        this.jdField_b_of_type_AndroidTextSpannableString = new SpannableString(anzj.a(2131707597));
        localObject = ((Resources)localObject).getDrawable(2130840361);
        ((Drawable)localObject).setBounds(0, -5, ((Drawable)localObject).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject).getIntrinsicHeight() * 4 / 5);
        localObject = new bizo((Drawable)localObject, 1).a(0.05F);
        this.jdField_b_of_type_AndroidTextSpannableString.setSpan(localObject, 0, 3, 17);
      }
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_b_of_type_AndroidTextSpannableString, this);
      break;
    }
  }
  
  private boolean a(bhuk parambhuk, MessageForPtt paramMessageForPtt)
  {
    if (aqyt.a(paramMessageForPtt)) {
      return true;
    }
    if (!paramMessageForPtt.isReady())
    {
      aean.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.c(parambhuk, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
      return true;
    }
    if (QQRecorder.a(paramMessageForPtt) <= 0)
    {
      aean.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.c(parambhuk, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
      return true;
    }
    return false;
  }
  
  protected static boolean a(MessageForPtt paramMessageForPtt)
  {
    String str = QQRecorder.a();
    return (paramMessageForPtt.fileSize == -2L) && (!TextUtils.isEmpty(str)) && (str.equals(paramMessageForPtt.getLocalFilePath()));
  }
  
  private int b(ahoc paramahoc, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean, String paramString)
  {
    boolean bool2 = aljb.a(paramMessageForPtt);
    if (paramMessageForPtt.voiceChangeFlag != 0) {}
    boolean bool3;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool3 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramahoc, paramMessageForPtt);
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "showPttItem builder, voiceLength:" + paramMessageForPtt.voiceLength);
      }
      if (a(paramahoc, paramMessageForPtt)) {
        break;
      }
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "showPttItem, msgText = " + paramString + ", message.voiceLength" + paramMessageForPtt.voiceLength);
    }
    paramahoc.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    a(paramahoc, bool3, bool1, paramMessageForPtt.isSend());
    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
    paramahoc.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    String str;
    int i;
    if (paramMessageForPtt.isSend()) {
      if (paramMessageForPtt.mRobotFlag == 1)
      {
        str = ((bgty)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
        if (!TextUtils.isEmpty(str)) {}
      }
      else
      {
        i = 1;
        if ((paramInt != 2003) && (paramInt != 1003)) {
          break label436;
        }
        if ((!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt)) {
          paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
        }
        if ((paramMessageForPtt.sttAbility != 2) || (paramMessageForPtt.voiceChangeFlag == 1) || (!paramMessageForPtt.expandStt)) {
          break label377;
        }
        i = 2;
        paramInt = 0;
      }
    }
    label436:
    for (;;)
    {
      a(paramahoc, paramMessageForPtt, bool2, i, paramInt);
      a(paramahoc, paramMessageForPtt, bool2, i, bool1, bool3, paramString, paramBoolean);
      return paramInt;
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, str, null);
      break;
      str = ((bgty)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
      if (TextUtils.isEmpty(str)) {
        break;
      }
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, str, null);
      break;
      label377:
      if (((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3)) && (this.jdField_a_of_type_Bdug.a(paramMessageForPtt)))
      {
        paramInt = 5;
        i = 2;
      }
      else if ((paramMessageForPtt.sttAbility == 3) && (paramMessageForPtt.expandStt))
      {
        paramInt = 6;
        i = 2;
        continue;
        if ((paramInt == 1005) || (paramInt == 1004)) {
          paramInt = 1;
        } else {
          paramInt = 4;
        }
      }
      else
      {
        paramInt = 0;
      }
    }
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
    return anzj.a(2131707595);
  }
  
  private void b(MessageForPtt paramMessageForPtt)
  {
    int i = QQRecorder.a(paramMessageForPtt);
    if (i <= 0) {
      return;
    }
    bmmv localbmmv = new bmmv(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt.voiceType, new ahoa(this, paramMessageForPtt));
    Object localObject;
    if (paramMessageForPtt.isSend())
    {
      localObject = paramMessageForPtt.selfuin;
      Drawable localDrawable = null;
      if (nlj.a(paramMessageForPtt)) {
        localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843620);
      }
      Bitmap localBitmap = this.jdField_a_of_type_Aoof.a(1, (String)localObject);
      localObject = localBitmap;
      if (localBitmap == null) {
        localObject = this.jdField_a_of_type_Aoof.a(1, paramMessageForPtt.frienduin);
      }
      if (!localbmmv.a(paramMessageForPtt.getLocalFilePath(), i, (Bitmap)localObject, localDrawable)) {
        break label146;
      }
      localbmmv.show();
    }
    for (;;)
    {
      bewa.a(1);
      return;
      localObject = paramMessageForPtt.senderuin;
      break;
      label146:
      bmlc.a(this.jdField_a_of_type_AndroidContentContext, 2131691992, 1);
    }
  }
  
  private void b(MessageForPtt paramMessageForPtt, int paramInt)
  {
    this.jdField_a_of_type_Bdug.b(paramMessageForPtt, paramInt);
  }
  
  private void b(MessageForPtt paramMessageForPtt, ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aggs.a(paramMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "autochange pos is:" + i);
    }
    if (i < 0) {}
    Object localObject;
    do
    {
      do
      {
        return;
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i - j);
      } while (localObject == null);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B40", "0X8005B40", 0, 0, "", "", "", "");
      bdll.b(null, "dc00898", "", "", "0X8009DF7", "0X8009DF7", 0, 0, "", "", "", "");
      localObject = (ahoc)((View)localObject).getTag();
      bewa.a(5);
      if ((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3))
      {
        if ((paramMessageForPtt.sttAbility == 3) && (!paramMessageForPtt.expandStt)) {
          paramMessageForPtt.expandStt = true;
        }
        h(paramChatMessage);
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramChatMessage.uniseq), anzj.a(2131707600));
        b(paramMessageForPtt, 1);
        this.jdField_a_of_type_Bdug.a(this);
        a((ahoc)localObject, paramMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt), c(paramMessageForPtt));
        return;
      }
    } while ((paramMessageForPtt.sttAbility != 2) || (paramMessageForPtt.expandStt));
    paramMessageForPtt.expandStt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
    a((ahoc)localObject, paramMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt), c(paramMessageForPtt));
    a((aggl)localObject, ((ahoc)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramMessageForPtt, ((ahoc)localObject).jdField_a_of_type_Aqkt);
  }
  
  private void c(MessageForPtt paramMessageForPtt)
  {
    if (TextUtils.isEmpty(paramMessageForPtt.sttText)) {
      paramMessageForPtt = this.jdField_a_of_type_AndroidContentContext.getString(2131718376);
    }
    for (;;)
    {
      bewa.a(3);
      try
      {
        if (Build.VERSION.SDK_INT < 11) {
          ((android.text.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramMessageForPtt);
        }
        for (;;)
        {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
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
  
  private void d(MessageForPtt paramMessageForPtt)
  {
    bewa.a(4);
    if ((paramMessageForPtt.sttText != null) && (paramMessageForPtt.sttText.length() > 0))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", -1);
      localBundle.putString("forward_text", paramMessageForPtt.sttText);
      localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
      paramMessageForPtt = new Intent();
      paramMessageForPtt.putExtras(localBundle);
      auxu.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt, 21);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, anzj.a(2131707602), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
  }
  
  private boolean d(ChatMessage paramChatMessage)
  {
    return paramChatMessage.vipBubbleID >= 1L;
  }
  
  private void e(MessageForPtt paramMessageForPtt)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l)
    {
      i = 9;
      bewa.a(i);
      if (paramMessageForPtt.isReady())
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
          break label70;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694616, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
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
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l)
      {
        bool1 = true;
        ((QQAppInterface)localObject1).d(bool1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l) {
          break label497;
        }
        bool1 = true;
        ((BaseChatPie)localObject1).l = bool1;
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l) {
            break label503;
          }
          bool1 = true;
          label174:
          ((NavBarAIO)localObject1).a(bool1, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        bool1 = lfm.a(BaseApplicationImpl.getContext());
        boolean bool2 = AudioHelper.a(BaseApplicationImpl.getContext());
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l, bool1, bool2);
        if (c(paramMessageForPtt)) {
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
        }
        i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aggs.a(paramMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
        if (i < 0) {
          break label526;
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i - j);
        ahoc localahoc = (ahoc)agej.a((View)localObject2);
        if ((localObject2 == null) || (localahoc == null)) {
          break label526;
        }
        localObject1 = (MessageForPtt)localahoc.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localahoc.jdField_b_of_type_Int);
        localahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
        localahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
        localahoc.a(true);
        localObject2 = (PttAudioWaveView)((View)localObject2).findViewById(2131374269);
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
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694615, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
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
  
  private void h(ChatMessage paramChatMessage)
  {
    if (biik.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_show_open_svip_gray_msg", false)) {
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
          localObject1 = arms.c();
          localObject2 = (args)aran.a().a(442);
          if ((localObject2 != null) && (((args)localObject2).a())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is close ,so click ptt msg not add msg");
        return;
        if (((armr)localObject1).jdField_a_of_type_Int == 3) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is open but stage=" + ((armr)localObject1).jdField_a_of_type_Int + ",so click ptt msg not add msg");
      return;
      if (!ahod.d) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is open but switch is open ,so click ptt msg not add msg");
    return;
    Object localObject2 = anzj.a(2131707596);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_action", 41);
    ((Bundle)localObject1).putString("textColor", "#40A0FF");
    localObject2 = new avpd(paramChatMessage.frienduin, paramChatMessage.selfuin, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5020, 655392, ((MessageForPtt)paramChatMessage).time);
    ((avpd)localObject2).a(15, 19, (Bundle)localObject1);
    localObject1 = new MessageForUniteGrayTip();
    if (paramChatMessage.istroop == 1) {
      ((MessageForUniteGrayTip)localObject1).shmsgseq = paramChatMessage.shmsgseq;
    }
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (avpd)localObject2);
    avpe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject1);
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0);
    localObject1 = "businessinfo_ptt_auto_change_guide_has_show_" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramChatMessage.edit().putBoolean((String)localObject1, true).commit();
    ahod.e = true;
    biik.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_show_open_svip_gray_msg", true);
    QLog.e("vip_ptt.PttItemBuilder", 1, "stage 3 add gray msg seccess");
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public aggk a(View paramView)
  {
    if (agej.a(paramView) != null) {
      return this;
    }
    return null;
  }
  
  public aggl a()
  {
    return new ahoc();
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    paramChatMessage = b(paramChatMessage, paramaggl, paramView, paramBaseChatItemLayout, paramagjk);
    agid.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this);
    if (AppSetting.c) {
      paramaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setOnClickListener(this);
    }
    paramaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bhnt.a(paramChatMessage.issend)) {
      return anzj.a(2131707592);
    }
    return anzj.a(2131707593);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bdug.a(null);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((ahoc)localIterator.next()).a();
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
    if (2131366320 == paramInt)
    {
      b(localMessageForPtt);
      return;
    }
    if (paramInt == 2131365352)
    {
      a(localMessageForPtt, paramChatMessage);
      return;
    }
    if (paramInt == 2131371530)
    {
      bewa.a(6);
      super.d(paramChatMessage);
      return;
    }
    if (paramInt == 2131365191)
    {
      c(localMessageForPtt);
      return;
    }
    if (paramInt == 2131367078)
    {
      d(localMessageForPtt);
      return;
    }
    if (paramInt == 2131378102)
    {
      b(localMessageForPtt, paramChatMessage);
      return;
    }
    if (paramInt == 2131371487)
    {
      if (c(localMessageForPtt)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
      }
      super.a(paramChatMessage);
      return;
    }
    if (paramInt == 2131372769)
    {
      e(localMessageForPtt);
      return;
    }
    if ((paramInt == 2131377904) || (paramInt == 2131377905) || (paramInt == 2131377902))
    {
      a(localMessageForPtt, paramInt);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(aggl paramaggl, View paramView, ChatMessage paramChatMessage, aqkt paramaqkt)
  {
    paramaggl = (ahoc)paramaggl;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramaggl, localMessageForPtt);
    if ((paramaqkt.jdField_a_of_type_Int == 0) || (!paramaqkt.a())) {
      a(paramaggl, localMessageForPtt, bool, paramView, paramChatMessage);
    }
    label213:
    for (;;)
    {
      return;
      if (paramaqkt.jdField_b_of_type_Int == 0) {
        a(paramaggl, localMessageForPtt, bool);
      }
      for (;;)
      {
        if ((!paramaqkt.jdField_b_of_type_Boolean) || (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramaggl.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * paramaggl.jdField_a_of_type_Aqkt.jdField_a_of_type_Double) != 1)) {
          break label213;
        }
        float f2 = paramaggl.jdField_a_of_type_AndroidWidgetTextView.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramaggl.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramaggl.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(f1, 0.0F, 0.0F, paramaqkt.d);
        if (bool) {
          break;
        }
        a(-1, paramaggl);
        return;
        a(paramaggl, localMessageForPtt, bool, paramaqkt);
      }
    }
  }
  
  protected void a(ahoc paramahoc, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag + ", voiceLength is: " + paramMessageForPtt.voiceLength);
    }
    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject = (RelativeLayout.LayoutParams)paramahoc.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(1, -1);
    if (paramahoc.c != null)
    {
      paramahoc.c.setVisibility(8);
      paramahoc.c.setOnClickListener(null);
      paramahoc.d.setVisibility(8);
    }
    if (paramahoc.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      paramahoc.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramahoc.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      paramahoc.e.setVisibility(8);
      paramahoc.f.setVisibility(8);
      paramahoc.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
      paramahoc.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramahoc.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramahoc.jdField_a_of_type_Agjk);
    paramahoc.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramahoc.jdField_a_of_type_Agjk);
    boolean bool1 = a(paramMessageForPtt, paramahoc);
    boolean bool2 = a(paramInt, paramMessageForPtt);
    localObject = a(paramInt, paramMessageForPtt);
    int i = a(paramahoc, paramMessageForPtt, paramInt, paramBoolean, (String)localObject);
    String str = b(paramInt, paramMessageForPtt);
    if (paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setSeekListener(this);
    }
    switch (i)
    {
    default: 
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
      if (paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) {
        paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
      }
      if (bool1)
      {
        paramMessageForPtt = (alao)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245);
        if (paramMessageForPtt != null)
        {
          paramMessageForPtt = paramMessageForPtt.a("voice_pwd", anzj.a(2131707598), new String[] { "lowTipStr" });
          label433:
          paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, paramMessageForPtt, null);
        }
      }
      else if (AppSetting.c)
      {
        paramMessageForPtt = anzj.a(2131707589);
        if (!bool2) {
          break label665;
        }
        paramahoc.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject + anzj.a(2131707594) + anzj.a(2131707590));
      }
      break;
    }
    for (;;)
    {
      if (paramahoc.jdField_a_of_type_JavaLangStringBuilder != null)
      {
        paramahoc.jdField_a_of_type_JavaLangStringBuilder.append("发送了语音.").append((String)localObject);
        if (str != null) {
          paramahoc.jdField_a_of_type_JavaLangStringBuilder.append(" ").append(str);
        }
      }
      return;
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
      ImageView localImageView = paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c;
      if (paramMessageForPtt.isSendFromLocal()) {}
      for (paramMessageForPtt = anzj.a(2131707599);; paramMessageForPtt = anzj.a(2131707591))
      {
        localImageView.setContentDescription(paramMessageForPtt);
        break;
      }
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839414, null);
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
      ((Animatable)paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getDrawable()).start();
      break;
      paramMessageForPtt = anzj.a(2131707598);
      break label433;
      label665:
      paramahoc.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject + anzj.a(2131707603));
    }
  }
  
  protected void a(ahoc paramahoc, MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      if (paramBoolean1) {
        i = 2;
      }
    }
    for (int j = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c;; j = 0)
    {
      aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt, false, i, j, paramBoolean2);
      return;
      i = 1;
      break;
      i = 5;
    }
  }
  
  protected void a(ahoc paramahoc, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramahoc.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(agej.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (paramBoolean3)
      {
        localObject = ((Resources)localObject).getDrawable(2130847062);
        if (localObject != null)
        {
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
          paramahoc.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
        }
      }
      do
      {
        return;
        localObject = ((Resources)localObject).getDrawable(2130847060);
      } while (localObject == null);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
      paramahoc.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
      return;
    }
    paramahoc.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
    paramahoc.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public void a(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)agej.a(paramView);
    paramView = (ahoc)agej.a(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = blir.a(this.jdField_a_of_type_AndroidContentContext);
      paramView.a(2131689934);
      paramView.b(2131689933);
      paramView.c(2131690580);
      paramView.a(new ahob(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    if ((!Environment.getExternalStorageState().equals("mounted")) || (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1))
    {
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        QQToast.a(BaseApplication.getContext(), 2131694019, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299011));
        return;
      }
      QQToast.a(BaseApplication.getContext(), 2131717721, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299011));
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
        paramView = (ahoc)((View)paramView.getParent().getParent()).getTag();
      } while (paramView == null);
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getBackground();
    } while (paramView == null);
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  public void a(View paramView, bete parambete, int paramInt1, int paramInt2)
  {
    if ((parambete.jdField_b_of_type_Int != 2) || (paramInt1 == 2002) || (paramInt1 == 1002) || (paramInt1 == 2001)) {}
    MessageForPtt localMessageForPtt;
    do
    {
      do
      {
        return;
      } while (!(agej.a(paramView) instanceof MessageForPtt));
      localMessageForPtt = (MessageForPtt)agej.a(paramView);
    } while ((localMessageForPtt == null) || (localMessageForPtt.uniseq != parambete.jdField_b_of_type_Long));
    paramView = (ahoc)agej.a(paramView);
    if ((paramInt1 == 1003) || (paramInt1 == 2003))
    {
      paramInt2 = paramInt1;
      if (!parambete.jdField_b_of_type_Boolean)
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
      if ((parambete.d == 1005) || (parambete.d == 1004))
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
        localObject = (aggl)paramView.getTag();
        paramView = (BaseChatItemLayout)paramView;
        b(paramChatMessage, (aggl)localObject, ((aggl)localObject).jdField_a_of_type_AndroidViewView, paramView, null);
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
          localObject = (ahoc)localView.getTag();
          if (localObject == null) {
            break label196;
          }
          localObject = ((ahoc)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView;
          paramView = agej.a((View)paramView.getParent().getParent().getParent());
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
    paramPttAudioWaveView = (ahoc)agej.a(paramPttAudioWaveView);
    if (paramPttAudioWaveView != null)
    {
      MediaPlayerManager localMediaPlayerManager = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localMediaPlayerManager.a(localMediaPlayerManager.a(), paramPttAudioWaveView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView, float paramFloat)
  {
    paramPttAudioWaveView = (ahoc)agej.a(paramPttAudioWaveView);
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
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean, ahoc paramahoc)
  {
    this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramMessageForPtt.isSend())
    {
      if (d(paramMessageForPtt))
      {
        paramMessageForPtt = paramahoc.jdField_a_of_type_AndroidWidgetImageView;
        if (paramBoolean) {}
        for (i = 2130847058;; i = 2130847061)
        {
          paramMessageForPtt.setImageResource(i);
          return;
        }
      }
      paramMessageForPtt = paramahoc.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {}
      for (i = 2130849981;; i = 2130849982)
      {
        paramMessageForPtt.setImageResource(i);
        return;
      }
    }
    if (d(paramMessageForPtt))
    {
      paramMessageForPtt = paramahoc.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {}
      for (i = 2130847052;; i = 2130847059)
      {
        paramMessageForPtt.setImageResource(i);
        return;
      }
    }
    paramMessageForPtt = paramahoc.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i = 2130849975;; i = 2130849974)
    {
      paramMessageForPtt.setImageResource(i);
      return;
    }
  }
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ahoc paramahoc)
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
              i = 2130772265;
              paramMessageForPtt = (AnimationDrawable)localResources.getDrawable(i);
              paramahoc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForPtt);
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
            i = 2130772263;
            continue;
          }
        }
        else
        {
          a(paramMessageForPtt, paramBoolean3, paramahoc);
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
      int i = 2130772264;
      continue;
      label140:
      if (paramBoolean3)
      {
        i = 2130772097;
      }
      else
      {
        i = 2130772096;
        continue;
        label161:
        i = 2130772262;
        continue;
        label169:
        if (paramBoolean3) {
          i = 2130772349;
        } else {
          i = 2130772348;
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
      paramXListView = agej.a(paramView);
      if ((paramXListView instanceof ahoc))
      {
        paramXListView = (ahoc)paramXListView;
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
      paramXListView = agej.a(paramView);
      if ((paramXListView instanceof ahoc))
      {
        paramXListView = (ahoc)paramXListView;
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
  
  public void a(boolean paramBoolean, MessageForPtt paramMessageForPtt)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramMessageForPtt.uniseq));
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public boolean a(aggl paramaggl)
  {
    return paramaggl instanceof ahoc;
  }
  
  protected boolean a(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, aggl paramaggl, MessageForPtt paramMessageForPtt)
  {
    return VoicePrintUtils.a(paramQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramBaseAdapter, paramaggl, paramMessageForPtt);
  }
  
  protected boolean a(MessageForPtt paramMessageForPtt, ahoc paramahoc)
  {
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = true;
    Object localObject;
    if (aljb.a(paramMessageForPtt)) {
      if (CustomizeStrategyFactory.a().a())
      {
        localObject = (alao)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245);
        if (localObject != null)
        {
          i = ((alao)localObject).a("voice_pwd", 1, new String[] { "scoreSwitch" });
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
          paramahoc.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramMessageForPtt.icon);
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
        paramMessageForPtt = paramahoc.jdField_b_of_type_AndroidWidgetImageView;
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
                i = ((alao)localObject).a("voice_pwd", 5, new String[] { "lowTipsLimit" });
                int k = akyd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "voice_low_tips_count", 0);
                if (k >= i) {
                  break label383;
                }
                paramMessageForPtt.saveExtInfoToExtStr("voice_low_tips_tag", "1");
                ThreadManager.post(new PttItemBuilder.2(this, paramMessageForPtt), 10, null, false);
                akyd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "voice_low_tips_count", k + 1);
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
        } while (paramahoc.jdField_b_of_type_AndroidWidgetImageView == null);
        paramahoc.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
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
    bamk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramXListView);
    if (paramXListView.isReady())
    {
      paramView = agej.a(paramView);
      if ((paramView != null) && (!(paramView instanceof ahoc))) {
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "play failed not Holder " + paramXListView.getLocalFilePath());
        }
      }
      do
      {
        return false;
        paramView = (ahoc)paramView;
      } while (paramAudioPlayerBase == null);
      paramAudioPlayerBase.b(paramXListView.playSpeedPos);
      paramAudioPlayerBase.a(paramXListView.time);
      if (paramAudioPlayerBase.b(paramXListView.getLocalFilePath(), paramInt2))
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
          a(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout, paramXListView, paramView.jdField_a_of_type_Aqkt, 0);
        }
        bewa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView.istroop, paramXListView.issend);
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
        bewa.a(paramXListView, paramInt1, bool, 1);
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
  
  public bhum[] a(View paramView)
  {
    return a(new bhuk(), (MessageForPtt)agej.a(paramView));
  }
  
  protected bhum[] a(bhuk parambhuk, MessageForPtt paramMessageForPtt)
  {
    if (a(parambhuk, paramMessageForPtt)) {
      return parambhuk.a();
    }
    if (c(paramMessageForPtt)) {
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
    }
    String str;
    int i;
    if (!agej.b())
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l))
      {
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131694379);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l)) {
          break label352;
        }
        i = 2130838936;
        label89:
        parambhuk.a(2131372769, str, i);
      }
    }
    else
    {
      if (((paramMessageForPtt.extraflag != 32768) && (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt) == 1003) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForPtt))) || (bguq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        a(parambhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForPtt);
      }
      a(parambhuk, paramMessageForPtt);
      if (paramMessageForPtt.voiceChangeFlag != 1)
      {
        if ((paramMessageForPtt.sttAbility != 1) && (paramMessageForPtt.sttAbility != 3)) {
          break label359;
        }
        if ((!this.jdField_a_of_type_Bdug.a(paramMessageForPtt)) && ((!paramMessageForPtt.isSend()) || (paramMessageForPtt.fileSize > 0L)) && (!aljb.a(paramMessageForPtt))) {
          parambhuk.a(2131378102, this.jdField_a_of_type_AndroidContentContext.getString(2131718377), 2130838929);
        }
      }
    }
    for (;;)
    {
      a(paramMessageForPtt, parambhuk);
      parambhuk.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691094));
      a(parambhuk, paramMessageForPtt);
      parambhuk.a(2131366320, this.jdField_a_of_type_AndroidContentContext.getString(2131691990), 2130838938);
      super.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt);
      b(paramMessageForPtt, parambhuk);
      super.c(parambhuk, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
      return parambhuk.a();
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131694381);
      break;
      label352:
      i = 2130838940;
      break label89;
      label359:
      if (paramMessageForPtt.sttAbility == 2) {
        if (paramMessageForPtt.expandStt)
        {
          parambhuk.a(2131365191, this.jdField_a_of_type_AndroidContentContext.getString(2131718375), 2130838932);
          parambhuk.a(2131367078, this.jdField_a_of_type_AndroidContentContext.getString(2131689948), 2130838939);
        }
        else if (!aljb.a(paramMessageForPtt))
        {
          parambhuk.a(2131378102, this.jdField_a_of_type_AndroidContentContext.getString(2131718377), 2130838929);
        }
      }
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "1", "", "", "");
  }
  
  protected View b(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    paramBaseChatItemLayout = (ahoc)paramaggl;
    this.jdField_a_of_type_JavaUtilSet.add(paramBaseChatItemLayout);
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramaggl = paramView;
    if (paramView == null)
    {
      paramaggl = new BreathAnimationLayout(this.jdField_a_of_type_AndroidContentContext);
      paramaggl.setId(2131374263);
      paramView = new PttAudioPlayView(this.jdField_a_of_type_AndroidContentContext, 12);
      paramView.setThemeColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167009).getDefaultColor());
      paramView.setId(2131374268);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject1).width = agej.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject1).height = agej.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new PttAudioChangeView(this.jdField_a_of_type_AndroidContentContext, 2130838207, 8);
      ((PttAudioChangeView)localObject1).setThemeColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167009).getDefaultColor());
      ((PttAudioChangeView)localObject1).setId(2131374274);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject2).width = agej.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject2).height = agej.a(19.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((PttAudioChangeView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new PttAudioWaveView(this.jdField_a_of_type_AndroidContentContext);
      ((PttAudioWaveView)localObject2).setProgressColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167009).getDefaultColor());
      ((PttAudioWaveView)localObject2).setId(2131374269);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject3).width = agej.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject3).height = agej.a(52.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((PttAudioWaveView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject3).setId(2131374270);
      ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167009));
      VoicePrintUtils.VoicePrintView localVoicePrintView = new VoicePrintUtils.VoicePrintView(this.jdField_a_of_type_AndroidContentContext);
      localVoicePrintView.setId(2131374271);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setId(2131374273);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      localVoicePrintView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject4).width = agej.a(47.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject4).height = agej.a(41.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new SyncParentPressedRelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject4).setId(2131374266);
      ((RelativeLayout)localObject4).addView((View)localObject2);
      ((RelativeLayout)localObject4).addView(paramView);
      ((RelativeLayout)localObject4).addView((View)localObject1);
      ((RelativeLayout)localObject4).addView((View)localObject3);
      ((RelativeLayout)localObject4).addView(localVoicePrintView);
      ((RelativeLayout)localObject4).addView(localImageView);
      paramaggl.addView((View)localObject4);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = paramaggl;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView = ((PttAudioChangeView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject2);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView = localVoicePrintView;
      paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView = localImageView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject4);
    }
    if (paramagjk != null) {
      paramBaseChatItemLayout.jdField_a_of_type_Agjk = paramagjk;
    }
    int i;
    boolean bool;
    if (localMessageForPtt.voiceChangeFlag != 0)
    {
      i = 1;
      bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramBaseChatItemLayout, localMessageForPtt);
      if (!bool) {
        break label1068;
      }
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
      if (!paramChatMessage.isSend()) {
        break label1355;
      }
      paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (!bool) {
        break label1274;
      }
      paramView.addRule(1, 2131374271);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, 2131374273);
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
      if (((localMessageForPtt.istroop == 1) || (localMessageForPtt.istroop == 3000)) && (i == 2003) && (this.jdField_a_of_type_Bdug.b(localMessageForPtt)))
      {
        b(localMessageForPtt, 2);
        bdll.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
      }
      a(paramBaseChatItemLayout, localMessageForPtt, i, c(localMessageForPtt));
      bamk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(localMessageForPtt);
      bewa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramChatMessage);
      return paramaggl;
      i = 0;
      break;
      label1068:
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(0);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnClickListener(this);
      if (i != 0) {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(0);
      }
      for (;;)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnTouchListener(paramBaseChatItemLayout.jdField_a_of_type_Agjk);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnLongClickListener(paramBaseChatItemLayout.jdField_a_of_type_Agjk);
        if ((!c(paramChatMessage)) && (!paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.d)) {
          break label1204;
        }
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
        paramBaseChatItemLayout.a(true);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
        break;
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
      }
      label1204:
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
      label1274:
      paramView.addRule(1, 2131374269);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131374274);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getLayoutParams()).addRule(1, 2131374273);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374268);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
      continue;
      label1355:
      if (bool)
      {
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374270);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131374271);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, -1);
      }
      else
      {
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131374269);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131374274);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getLayoutParams()).addRule(1, 2131374273);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374268);
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
    bewa.a(7);
    super.d();
  }
  
  public void onClick(View paramView)
  {
    agej.n = true;
    int i = paramView.getId();
    if ((AppSetting.c) && (i == 2131363324)) {
      paramView.findViewById(2131374266).performClick();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = (ahoc)agej.a(paramView);
      Object localObject2 = (MessageForPtt)((ahoc)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((i == 2131374266) || (i == 2131374269))
      {
        if (localObject2 != null)
        {
          if (c((ChatMessage)localObject2))
          {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
            bdll.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 2, 0, "", "", "", "");
          }
          for (;;)
          {
            if (((MessageForPtt)localObject2).istroop == 1008) {
              ocd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", ((MessageForPtt)localObject2).timeStr, "", false);
            }
            if (((MessageForPtt)localObject2).voiceChangeFlag != 1) {
              break;
            }
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F7E", 0, 0, "" + ((MessageForPtt)localObject2).istroop, "", "", "");
            break;
            if ((localObject2 != MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (((MessageForPtt)localObject2).isReady())) {
              a((ahoc)localObject1, (MessageForPtt)localObject2, paramView);
            }
          }
        }
      }
      else if ((i == 2131374285) || (i == 2131374279))
      {
        if ((localObject2 != null) && (((MessageForPtt)localObject2).expandStt))
        {
          ((MessageForPtt)localObject2).expandStt = false;
          ((MessageForPtt)localObject2).serial();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((MessageForPtt)localObject2).uniseq, ((MessageForPtt)localObject2).msgData);
          a((ahoc)localObject1, (MessageForPtt)localObject2, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForPtt)localObject2), c((ChatMessage)localObject2));
          bdll.b(null, "dc00898", "", "", "0X8009DF8", "0X8009DF8", 0, 0, "", "", "", "");
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
        }
      }
      else if (i == 2131364452)
      {
        if (this.jdField_a_of_type_AndroidContentContext != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          String str = nnr.a();
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
 * Qualified Name:     ahnz
 * JD-Core Version:    0.7.0.1
 */