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

public class ahen
  extends BaseBubbleBuilder
  implements afwq, afwv, afxp, afyl, afzm, ahem, bdbs
{
  protected SpannableString a;
  protected TextView a;
  protected bdbn a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private Map<Long, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  Set<aheq> jdField_a_of_type_JavaUtilSet = new HashSet();
  protected SpannableString b;
  
  public ahen(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Bdbn = ((bdbn)paramQQAppInterface.getManager(17));
    this.jdField_a_of_type_Bdbn.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private int a(aheq paramaheq, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramMessageForPtt.voiceChangeFlag != 0) {}
    boolean bool2;
    Resources localResources;
    int i;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramaheq, paramMessageForPtt);
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      i = afur.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      switch (paramInt)
      {
      default: 
        return 0;
      }
    }
    return 7;
    paramaheq.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    paramaheq.jdField_a_of_type_AndroidWidgetTextView.setPadding(afur.a(10.0F, localResources), BaseChatItemLayout.m, afur.a(10.0F, localResources), BaseChatItemLayout.n);
    if (paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    }
    a(paramaheq, bool2, bool1, paramMessageForPtt.isSend());
    paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
    ((RelativeLayout.LayoutParams)paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
    paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
    return 1;
    ((RelativeLayout.LayoutParams)paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
    paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
    paramaheq.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    paramaheq.jdField_a_of_type_AndroidWidgetTextView.setPadding(afur.a(40.0F, localResources), BaseChatItemLayout.m, afur.a(40.0F, localResources), BaseChatItemLayout.n);
    if (paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    }
    if (paramInt == 999)
    {
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(8);
      return 0;
    }
    paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
    paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
    return 0;
    return b(paramaheq, paramMessageForPtt, paramInt, paramBoolean, paramString);
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
      paramInt1 = afur.a(paramInt1, paramContext.getResources());
      if (paramFloat <= 0.0F) {
        break label196;
      }
      paramInt1 = Math.max(paramInt1 + afur.a(paramInt2, paramContext.getResources()) + afur.a(paramInt3, paramContext.getResources()), (int)paramFloat);
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
      return paramInt1 - afur.a(paramInt2 - 40, paramContext.getResources());
      paramInt1 = 15 + (int)(PttAudioWaveView.a(paramInt1, 60, 1.5F) * 125.0F);
      break;
      return paramInt1 + afur.a(paramInt3, paramContext.getResources());
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
      j = afur.a(i + 20, paramContext.getResources());
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
        int k = afur.a(f2, paramContext.getResources());
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
      if ((paramMessageForPtt.url != null) && (paramMessageForPtt.url.startsWith(anhk.aZ))) {
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
              j = aztu.a(paramQQAppInterface, paramMessageForPtt);
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
  
  private void a(int paramInt, aheq paramaheq)
  {
    if (paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(paramInt);
    }
    if (paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(paramInt);
    }
    if (paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) {
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(paramInt);
    }
  }
  
  private void a(aheq paramaheq, MessageForPtt paramMessageForPtt, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694574, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
      return;
    }
    if (!atwl.b(paramMessageForPtt.getLocalFilePath()))
    {
      a(paramaheq, paramMessageForPtt, false, true);
      a(paramaheq, paramMessageForPtt, 5003, false);
      return;
    }
    PttAudioWaveView localPttAudioWaveView = (PttAudioWaveView)paramView.findViewById(2131374130);
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
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramaheq.jdField_b_of_type_Int);
      bcst.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 1, 0, "", "", "", "");
      if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(afur.a(paramView), i)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694573, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
      return;
      i = (int)(paramMessageForPtt.voiceLength * 1000.0F * f);
      continue;
      i = 0;
    }
  }
  
  private void a(aheq paramaheq, MessageForPtt paramMessageForPtt, boolean paramBoolean)
  {
    paramaheq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    if (paramaheq.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      paramaheq.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      if (this.jdField_a_of_type_Bdbn.a(paramMessageForPtt)) {
        paramaheq.jdField_b_of_type_AndroidWidgetTextView.setTextColor(PttAudioWaveView.a(-16777216, 0.5F));
      }
      if ((paramaheq.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) && (paramaheq.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getVisibility() == 0))
      {
        paramaheq.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(-16777216);
        paramaheq.jdField_b_of_type_AndroidWidgetTextView.setTextColor(PttAudioWaveView.a(-16777216, 0.5F));
      }
    }
    if (!paramBoolean) {
      a(-16777216, paramaheq);
    }
  }
  
  private void a(aheq paramaheq, MessageForPtt paramMessageForPtt, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int j = afur.a(9.0F, localResources);
    int m = afur.a(1.5F, localResources);
    int k = afur.a(12.0F, localResources);
    try
    {
      i = localResources.getDrawable(2130844835).getIntrinsicHeight();
      int n = afur.a(1.0F, localResources);
      int i1 = afur.a(1.5F, localResources);
      paramaheq.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setPadding(0, 0, m, 0);
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setPadding(0, 0, i1, 0);
      Object localObject1 = (RelativeLayout.LayoutParams)paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams();
      if (paramBoolean)
      {
        ((RelativeLayout.LayoutParams)localObject1).width = afur.a(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPadding(afur.a(2.0F, localResources) + j, 0, 0, 0);
        if (paramInt1 == 2)
        {
          if (paramaheq.jdField_b_of_type_AndroidWidgetTextView != null) {
            break label1214;
          }
          ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localImageView.setImageDrawable(new ColorDrawable(838860800));
          RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, n);
          localImageView.setLayoutParams(localLayoutParams1);
          localImageView.setId(2131374147);
          TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
          if (!paramMessageForPtt.isSend()) {
            break label1173;
          }
          localObject1 = localResources.getColorStateList(2131167008);
          if (localObject1 != null)
          {
            localTextView.setTextColor((ColorStateList)localObject1);
            if ((paramInt2 == 5) && (paramaheq.jdField_a_of_type_Apwt != null) && (paramaheq.jdField_a_of_type_Apwt.jdField_b_of_type_Int != 0)) {
              localTextView.setTextColor(PttAudioWaveView.a(paramaheq.jdField_a_of_type_Apwt.jdField_b_of_type_Int, 0.5F));
            }
          }
          localTextView.setId(2131374146);
          localTextView.setMaxWidth(BaseChatItemLayout.f);
          localObject4 = new RelativeLayout.LayoutParams(-2, -2);
          localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          ((RelativeLayout)localObject1).setId(2131374143);
          localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
          localProgressBar.setId(2131374144);
          localObject3 = new RelativeLayout.LayoutParams(afur.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localProgressBar.setIndeterminate(true);
          localProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839402));
          ((RelativeLayout.LayoutParams)localObject3).topMargin = afur.a(13.0F, localResources);
          ((RelativeLayout.LayoutParams)localObject3).leftMargin = afur.a(16.0F, localResources);
          localProgressBar.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject3 = new PttAudioChangeView(this.jdField_a_of_type_AndroidContentContext, 2130838196, 6);
          ((PttAudioChangeView)localObject3).setThemeColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167004).getDefaultColor());
          ((PttAudioChangeView)localObject3).setId(2131374145);
          RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(afur.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams2.topMargin = afur.a(13.0F, localResources);
          localLayoutParams2.leftMargin = afur.a(16.0F, localResources);
          ((PttAudioChangeView)localObject3).setLayoutParams(localLayoutParams2);
          if ((paramInt2 != 5) && (paramInt2 != 6)) {
            break label1186;
          }
          ((RelativeLayout.LayoutParams)localObject4).leftMargin = afur.a(25.0F, localResources);
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
          ((ImageView)localObject4).setId(2131374140);
          localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
          ((ImageView)localObject4).setLayoutParams(localLayoutParams2);
          ((ImageView)localObject4).setImageResource(2130844835);
          ((ImageView)localObject4).setScaleType(ImageView.ScaleType.FIT_END);
          ((ImageView)localObject4).setOnClickListener(this);
          localLayoutParams1.addRule(3, 2131374127);
          localLayoutParams1.addRule(14);
          localLayoutParams2.addRule(3, 2131374147);
          localLayoutParams2.addRule(14);
          localLayoutParams2.addRule(6, 2131374143);
          localLayoutParams2.addRule(8, 2131374143);
          localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams1.addRule(3, 2131374147);
          ((RelativeLayout)localObject1).setLayoutParams(localLayoutParams1);
          paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localImageView);
          paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject1);
          paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject4);
          paramaheq.e = localImageView;
          paramaheq.jdField_b_of_type_AndroidWidgetTextView = localTextView;
          paramaheq.f = ((ImageView)localObject4);
          paramaheq.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView = ((PttAudioChangeView)localObject3);
          paramaheq.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
          paramaheq.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
          paramaheq.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(paramaheq.jdField_a_of_type_Afzq);
          paramaheq.jdField_b_of_type_AndroidWidgetTextView.setOnLongClickListener(paramaheq.jdField_a_of_type_Afzq);
          if ((paramInt2 != 5) && (paramInt2 != 6)) {
            break label1367;
          }
          paramaheq.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, afur.a(17.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localObject1 = (RelativeLayout.LayoutParams)paramaheq.e.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131374127);
          ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131374127);
          localObject1 = (RelativeLayout.LayoutParams)paramaheq.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131374127);
          ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131374127);
          paramInt1 = afur.a(22.0F, localResources);
          paramaheq.e.setPadding(j, 0, j, 0);
          paramaheq.jdField_b_of_type_AndroidWidgetTextView.setPadding(j, BaseChatItemLayout.m, j, paramInt1 + i);
          paramaheq.f.setPadding(0, 0, 0, k);
          localObject1 = paramMessageForPtt.sttText;
          if (paramInt2 != 5) {
            break label1386;
          }
          paramMessageForPtt = (String)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramMessageForPtt.uniseq));
          paramaheq.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForPtt);
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
        int i = afur.a(24.0F, localResources);
        QLog.e("PttItemBuilder", 1, "", localException);
        continue;
        localException.width = afur.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPadding(afur.a(2.0F, localResources) + j, 0, j, 0);
        continue;
        label1173:
        Object localObject2 = localResources.getColorStateList(2131167004);
        continue;
        label1186:
        ((RelativeLayout.LayoutParams)localObject4).leftMargin = afur.a(0.0F, localResources);
        ((PttAudioChangeView)localObject3).setVisibility(8);
        localProgressBar.setVisibility(8);
        continue;
        label1214:
        paramaheq.e.setVisibility(0);
        paramaheq.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramaheq.f.setVisibility(0);
        localObject2 = (RelativeLayout.LayoutParams)paramaheq.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if ((paramInt2 == 5) || (paramInt2 == 6))
        {
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = afur.a(25.0F, localResources);
          if (paramInt2 == 5)
          {
            paramaheq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            paramaheq.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
          }
          if (paramInt2 == 6)
          {
            paramaheq.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(0);
            paramaheq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          }
        }
        for (;;)
        {
          paramaheq.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          break;
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = afur.a(0.0F, localResources);
          paramaheq.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
          paramaheq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
        label1367:
        paramaheq.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        continue;
        label1386:
        paramMessageForPtt = (MessageForPtt)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramMessageForPtt = this.jdField_a_of_type_AndroidContentContext.getString(2131718241);
        }
      }
    }
  }
  
  private void a(aheq paramaheq, MessageForPtt paramMessageForPtt, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, String paramString, boolean paramBoolean4)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
    int j = afur.a(1.5F, (Resources)localObject1);
    int k = afur.a(9.0F, (Resources)localObject1);
    float f = 0.0F;
    if (paramInt == 2)
    {
      localObject2 = paramMessageForPtt.sttText;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131718241);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      f = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText((String)localObject1);
    }
    int i = k + 44 + (int)afur.a((int)paramaheq.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(paramString), this.jdField_a_of_type_AndroidContentContext.getResources());
    paramInt = i;
    if (paramBoolean2) {
      paramInt = i + 16;
    }
    i = paramInt;
    if (paramBoolean1) {
      i = paramInt + 38;
    }
    paramInt = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt.voiceLength, f, i, j, paramBoolean2, paramBoolean1);
    Object localObject2 = (RelativeLayout.LayoutParams)paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).width = paramInt;
    paramString = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean3, paramBoolean2, paramInt + k, paramaheq);
    localObject1 = (RelativeLayout.LayoutParams)paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).width = (paramString[0] + paramString[1] + paramString[2]);
    ((RelativeLayout.LayoutParams)localObject1).height = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean3, paramaheq);
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "message seq=" + paramMessageForPtt.uniseq + ", VpLp.width=" + ((RelativeLayout.LayoutParams)localObject1).width + ", flagTimeContainer.getLeft()=" + paramaheq.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft());
    }
    if ((paramBoolean3) && (((RelativeLayout.LayoutParams)localObject1).height > 0))
    {
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(8);
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
      Object localObject3 = paramaheq.jdField_a_of_type_Apwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7);
      if ((((apwu)((Pair)localObject3).first).a != null) && (((apwu)((Pair)localObject3).first).a.length > 0))
      {
        localObject2 = paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView;
        localObject3 = (apwu)((Pair)localObject3).first;
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
        ((VoicePrintUtils.VoicePrintView)localObject2).setBitmap((apwu)localObject3, paramInt, i, j, k, paramBoolean1);
        if (!paramBoolean4) {
          break;
        }
        paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(false);
        return;
      }
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(true);
      return;
    }
    if (paramMessageForPtt.voiceLength > 0) {
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramMessageForPtt.waveformArray, ((RelativeLayout.LayoutParams)localObject2).width - afur.a(j, this.jdField_a_of_type_AndroidContentContext.getResources()), paramMessageForPtt.voiceLength);
    }
    paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(0);
    paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
  }
  
  private void a(aheq paramaheq, MessageForPtt paramMessageForPtt, boolean paramBoolean, View paramView, ChatMessage paramChatMessage)
  {
    paramView = paramView.getResources();
    if (paramChatMessage.isSend())
    {
      paramView = paramView.getColorStateList(2131167008);
      if ((paramaheq.jdField_a_of_type_AndroidWidgetTextView != null) && (paramView != null)) {
        paramaheq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView);
      }
      if ((paramaheq.jdField_b_of_type_AndroidWidgetTextView != null) && (paramView != null))
      {
        paramaheq.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramView);
        if (this.jdField_a_of_type_Bdbn.a(paramMessageForPtt)) {
          paramaheq.jdField_b_of_type_AndroidWidgetTextView.setTextColor(PttAudioWaveView.a(paramView.getDefaultColor(), 0.5F));
        }
        if ((paramaheq.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) && (paramaheq.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getVisibility() == 0))
        {
          paramaheq.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(paramView.getDefaultColor());
          paramaheq.jdField_b_of_type_AndroidWidgetTextView.setTextColor(PttAudioWaveView.a(paramView.getDefaultColor(), 0.5F));
        }
      }
      if (!paramBoolean)
      {
        if (paramChatMessage.isSend()) {
          break label180;
        }
        a(Color.parseColor("#424448"), paramaheq);
      }
    }
    label180:
    while (paramView == null)
    {
      return;
      paramView = paramView.getColorStateList(2131167004);
      break;
    }
    a(paramView.getDefaultColor(), paramaheq);
  }
  
  private void a(aheq paramaheq, MessageForPtt paramMessageForPtt, boolean paramBoolean, apwt paramapwt)
  {
    paramaheq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramapwt.jdField_b_of_type_Int);
    if (paramaheq.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      paramaheq.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramapwt.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Bdbn.a(paramMessageForPtt)) {
        paramaheq.jdField_b_of_type_AndroidWidgetTextView.setTextColor(PttAudioWaveView.a(paramapwt.jdField_b_of_type_Int, 0.5F));
      }
      if ((paramaheq.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) && (paramaheq.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getVisibility() == 0))
      {
        paramaheq.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(paramapwt.jdField_b_of_type_Int);
        paramaheq.jdField_b_of_type_AndroidWidgetTextView.setTextColor(PttAudioWaveView.a(paramapwt.jdField_b_of_type_Int, 0.5F));
      }
    }
    if (!paramBoolean) {
      a(paramapwt.jdField_b_of_type_Int, paramaheq);
    }
  }
  
  private void a(View paramView, ColorFilter paramColorFilter)
  {
    Object localObject = (aheq)paramView.getTag();
    if (localObject != null)
    {
      paramView = afur.a(paramView);
      if ((paramView != null) && (paramView.vipBubbleID == 0L))
      {
        localObject = ((aheq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getBackground();
        if ((localObject != null) && (paramView.vipBubbleID == 0L))
        {
          ((Drawable)localObject).setColorFilter(paramColorFilter);
          ((Drawable)localObject).invalidateSelf();
        }
      }
    }
  }
  
  private void a(bguh parambguh, MessageForPtt paramMessageForPtt)
  {
    if (aher.c)
    {
      boolean bool1 = MediaPlayerManager.a(paramMessageForPtt.playSpeedPos, MediaPlayerManager.a);
      boolean bool2 = MediaPlayerManager.a(paramMessageForPtt.playSpeedPos, MediaPlayerManager.b);
      boolean bool3 = MediaPlayerManager.a(paramMessageForPtt.playSpeedPos, MediaPlayerManager.c);
      if (!bool1) {
        parambguh.a(2131377756, this.jdField_a_of_type_AndroidContentContext.getString(2131694341), 2130838926);
      }
      if (!bool2) {
        parambguh.a(2131377757, this.jdField_a_of_type_AndroidContentContext.getString(2131694340), 2130838926);
      }
      if (!bool3) {
        parambguh.a(2131377754, this.jdField_a_of_type_AndroidContentContext.getString(2131694336), 2130838926);
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
    if (paramInt == 2131377757)
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
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694574, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
      }
      for (;;)
      {
        return;
        if (paramInt != 2131377754) {
          break label586;
        }
        f = MediaPlayerManager.c;
        localObject1 = "0X8009DE3";
        break;
        label91:
        boolean bool1 = lff.a(BaseApplicationImpl.getContext());
        boolean bool2 = AudioHelper.a(BaseApplicationImpl.getContext());
        Object localObject2 = bgoe.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l, bool1, bool2, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n, f);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n == 0) {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n = bgoe.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l, bool1, bool2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, (CharSequence)localObject2, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b() == 0)
        {
          paramInt = 1;
          bcst.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, paramInt, 0, "", "", "", "");
          if (c(paramMessageForPtt)) {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
          }
          if (QLog.isColorLevel()) {
            QLog.d("PttItemBuilder", 2, "getMenuItem oriSpeed:" + paramMessageForPtt.playSpeedPos + ", newSpeed:" + f);
          }
          paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Afwy.a(paramMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
          int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
          if (paramInt < 0) {
            break label581;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(paramInt - i);
          aheq localaheq = (aheq)afur.a((View)localObject2);
          if ((localObject2 == null) || (localaheq == null)) {
            break label581;
          }
          localObject1 = (MessageForPtt)localaheq.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localaheq.jdField_b_of_type_Int);
          if (localObject1 != null) {
            ((MessageForPtt)localObject1).playSpeedPos = f;
          }
          localaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          localaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
          localaheq.a(true);
          localObject2 = (PttAudioWaveView)((View)localObject2).findViewById(2131374130);
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
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694573, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
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
    adrm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    bdxh.a(2);
  }
  
  private boolean a(int paramInt, MessageForPtt paramMessageForPtt)
  {
    return ((paramInt == 2003) || (paramInt == 1003)) && (!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt);
  }
  
  private boolean a(aheq paramaheq, MessageForPtt paramMessageForPtt)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = afur.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramMessageForPtt.voiceLength <= 1) {
      paramMessageForPtt.voiceLength = QQRecorder.a(paramMessageForPtt);
    }
    if (paramMessageForPtt.voiceLength <= 0)
    {
      ((RelativeLayout.LayoutParams)paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
      paramaheq.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramaheq.jdField_a_of_type_AndroidWidgetTextView.setPadding(afur.a(10.0F, (Resources)localObject), BaseChatItemLayout.m, afur.a(10.0F, (Resources)localObject), BaseChatItemLayout.n);
      if (paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
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
        localObject = ((Resources)localObject).getDrawable(2130840352);
        ((Drawable)localObject).setBounds(0, -5, ((Drawable)localObject).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject).getIntrinsicHeight() * 4 / 5);
        localObject = new bhyq((Drawable)localObject, 1).a(0.05F);
        this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localObject, 0, 3, 17);
      }
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_a_of_type_AndroidTextSpannableString, this);
      if (VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        str = nlw.a();
        if (!VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label460;
        }
      }
    }
    label460:
    for (paramaheq = "svip";; paramaheq = "vip")
    {
      VasWebviewUtil.reportCommercialDrainage((String)localObject, "LongVoice", "TailView", "0", 1, 0, 0, str, "", paramaheq);
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
        this.jdField_b_of_type_AndroidTextSpannableString = new SpannableString(anni.a(2131707488));
        localObject = ((Resources)localObject).getDrawable(2130840351);
        ((Drawable)localObject).setBounds(0, -5, ((Drawable)localObject).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject).getIntrinsicHeight() * 4 / 5);
        localObject = new bhyq((Drawable)localObject, 1).a(0.05F);
        this.jdField_b_of_type_AndroidTextSpannableString.setSpan(localObject, 0, 3, 17);
      }
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_b_of_type_AndroidTextSpannableString, this);
      break;
    }
  }
  
  private boolean a(bguh parambguh, MessageForPtt paramMessageForPtt)
  {
    if (aqjq.a(paramMessageForPtt)) {
      return true;
    }
    if (!paramMessageForPtt.isReady())
    {
      adrm.a(parambguh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.c(parambguh, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambguh, this.jdField_a_of_type_AndroidContentContext);
      return true;
    }
    if (QQRecorder.a(paramMessageForPtt) <= 0)
    {
      adrm.a(parambguh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.c(parambguh, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambguh, this.jdField_a_of_type_AndroidContentContext);
      return true;
    }
    return false;
  }
  
  protected static boolean a(MessageForPtt paramMessageForPtt)
  {
    String str = QQRecorder.a();
    return (paramMessageForPtt.fileSize == -2L) && (!TextUtils.isEmpty(str)) && (str.equals(paramMessageForPtt.getLocalFilePath()));
  }
  
  private int b(aheq paramaheq, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean, String paramString)
  {
    boolean bool2 = akxm.a(paramMessageForPtt);
    if (paramMessageForPtt.voiceChangeFlag != 0) {}
    boolean bool3;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool3 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramaheq, paramMessageForPtt);
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "showPttItem builder, voiceLength:" + paramMessageForPtt.voiceLength);
      }
      if (a(paramaheq, paramMessageForPtt)) {
        break;
      }
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "showPttItem, msgText = " + paramString + ", message.voiceLength" + paramMessageForPtt.voiceLength);
    }
    paramaheq.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    a(paramaheq, bool3, bool1, paramMessageForPtt.isSend());
    paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
    paramaheq.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    String str;
    int i;
    if (paramMessageForPtt.isSend()) {
      if (paramMessageForPtt.mRobotFlag == 1)
      {
        str = ((bftx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
        if (!TextUtils.isEmpty(str)) {}
      }
      else
      {
        i = 1;
        if ((paramInt != 2003) && (paramInt != 1003)) {
          break label436;
        }
        if ((!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt)) {
          paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
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
      a(paramaheq, paramMessageForPtt, bool2, i, paramInt);
      a(paramaheq, paramMessageForPtt, bool2, i, bool1, bool3, paramString, paramBoolean);
      return paramInt;
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, str, null);
      break;
      str = ((bftx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
      if (TextUtils.isEmpty(str)) {
        break;
      }
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, str, null);
      break;
      label377:
      if (((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3)) && (this.jdField_a_of_type_Bdbn.a(paramMessageForPtt)))
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
    return anni.a(2131707486);
  }
  
  private void b(MessageForPtt paramMessageForPtt)
  {
    int i = QQRecorder.a(paramMessageForPtt);
    if (i <= 0) {
      return;
    }
    blls localblls = new blls(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt.voiceType, new aheo(this, paramMessageForPtt));
    Object localObject;
    if (paramMessageForPtt.isSend())
    {
      localObject = paramMessageForPtt.selfuin;
      Drawable localDrawable = null;
      if (njo.a(paramMessageForPtt)) {
        localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843602);
      }
      Bitmap localBitmap = this.jdField_a_of_type_Aobu.a(1, (String)localObject);
      localObject = localBitmap;
      if (localBitmap == null) {
        localObject = this.jdField_a_of_type_Aobu.a(1, paramMessageForPtt.frienduin);
      }
      if (!localblls.a(paramMessageForPtt.getLocalFilePath(), i, (Bitmap)localObject, localDrawable)) {
        break label146;
      }
      localblls.show();
    }
    for (;;)
    {
      bdxh.a(1);
      return;
      localObject = paramMessageForPtt.senderuin;
      break;
      label146:
      bljz.a(this.jdField_a_of_type_AndroidContentContext, 2131691988, 1);
    }
  }
  
  private void b(MessageForPtt paramMessageForPtt, int paramInt)
  {
    if (aher.h)
    {
      this.jdField_a_of_type_Bdbn.a(paramMessageForPtt);
      return;
    }
    this.jdField_a_of_type_Bdbn.b(paramMessageForPtt, paramInt);
  }
  
  private void b(MessageForPtt paramMessageForPtt, ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Afwy.a(paramMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
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
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B40", "0X8005B40", 0, 0, "", "", "", "");
      bcst.b(null, "dc00898", "", "", "0X8009DF7", "0X8009DF7", 0, 0, "", "", "", "");
      localObject = (aheq)((View)localObject).getTag();
      bdxh.a(5);
      if ((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3))
      {
        if ((paramMessageForPtt.sttAbility == 3) && (!paramMessageForPtt.expandStt)) {
          paramMessageForPtt.expandStt = true;
        }
        h(paramChatMessage);
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramChatMessage.uniseq), anni.a(2131707491));
        b(paramMessageForPtt, 1);
        this.jdField_a_of_type_Bdbn.a(this);
        a((aheq)localObject, paramMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt), c(paramMessageForPtt));
        return;
      }
    } while ((paramMessageForPtt.sttAbility != 2) || (paramMessageForPtt.expandStt));
    paramMessageForPtt.expandStt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
    a((aheq)localObject, paramMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt), c(paramMessageForPtt));
    a((afwr)localObject, ((aheq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramMessageForPtt, ((aheq)localObject).jdField_a_of_type_Apwt);
  }
  
  private void c(MessageForPtt paramMessageForPtt)
  {
    if (TextUtils.isEmpty(paramMessageForPtt.sttText)) {
      paramMessageForPtt = this.jdField_a_of_type_AndroidContentContext.getString(2131718241);
    }
    for (;;)
    {
      bdxh.a(3);
      try
      {
        if (Build.VERSION.SDK_INT < 11) {
          ((android.text.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramMessageForPtt);
        }
        for (;;)
        {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
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
    bdxh.a(4);
    if ((paramMessageForPtt.sttText != null) && (paramMessageForPtt.sttText.length() > 0))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", -1);
      localBundle.putString("forward_text", paramMessageForPtt.sttText);
      localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
      paramMessageForPtt = new Intent();
      paramMessageForPtt.putExtras(localBundle);
      aufz.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt, 21);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, anni.a(2131707493), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
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
      bdxh.a(i);
      if (paramMessageForPtt.isReady())
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
          break label70;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694574, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
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
        bool1 = lff.a(BaseApplicationImpl.getContext());
        boolean bool2 = AudioHelper.a(BaseApplicationImpl.getContext());
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l, bool1, bool2);
        if (c(paramMessageForPtt)) {
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
        }
        i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Afwy.a(paramMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
        if (i < 0) {
          break label526;
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i - j);
        aheq localaheq = (aheq)afur.a((View)localObject2);
        if ((localObject2 == null) || (localaheq == null)) {
          break label526;
        }
        localObject1 = (MessageForPtt)localaheq.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localaheq.jdField_b_of_type_Int);
        localaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
        localaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
        localaheq.a(true);
        localObject2 = (PttAudioWaveView)((View)localObject2).findViewById(2131374130);
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
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694573, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
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
    if (bhhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_show_open_svip_gray_msg", false)) {
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
          localObject1 = aqxe.c();
          localObject2 = (aqri)aqlk.a().a(442);
          if ((localObject2 != null) && (((aqri)localObject2).a())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is close ,so click ptt msg not add msg");
        return;
        if (((aqxd)localObject1).jdField_a_of_type_Int == 3) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is open but stage=" + ((aqxd)localObject1).jdField_a_of_type_Int + ",so click ptt msg not add msg");
      return;
      if (!aher.d) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is open but switch is open ,so click ptt msg not add msg");
    return;
    Object localObject2 = anni.a(2131707487);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_action", 41);
    ((Bundle)localObject1).putString("textColor", "#40A0FF");
    localObject2 = new auxc(paramChatMessage.frienduin, paramChatMessage.selfuin, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5020, 655392, ((MessageForPtt)paramChatMessage).time);
    ((auxc)localObject2).a(15, 19, (Bundle)localObject1);
    localObject1 = new MessageForUniteGrayTip();
    if (paramChatMessage.istroop == 1) {
      ((MessageForUniteGrayTip)localObject1).shmsgseq = paramChatMessage.shmsgseq;
    }
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (auxc)localObject2);
    auxd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject1);
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0);
    localObject1 = "businessinfo_ptt_auto_change_guide_has_show_" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramChatMessage.edit().putBoolean((String)localObject1, true).commit();
    aher.e = true;
    bhhv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_show_open_svip_gray_msg", true);
    QLog.e("vip_ptt.PttItemBuilder", 1, "stage 3 add gray msg seccess");
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public afwq a(View paramView)
  {
    if (afur.a(paramView) != null) {
      return this;
    }
    return null;
  }
  
  public afwr a()
  {
    return new aheq();
  }
  
  public View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    paramChatMessage = b(paramChatMessage, paramafwr, paramView, paramBaseChatItemLayout, paramafzq);
    afyj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramafwr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this);
    if (AppSetting.c) {
      paramafwr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setOnClickListener(this);
    }
    paramafwr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bgnr.a(paramChatMessage.issend)) {
      return anni.a(2131707483);
    }
    return anni.a(2131707484);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bdbn.a(null);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((aheq)localIterator.next()).a();
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
    if (2131366271 == paramInt)
    {
      b(localMessageForPtt);
      return;
    }
    if (paramInt == 2131365308)
    {
      a(localMessageForPtt, paramChatMessage);
      return;
    }
    if (paramInt == 2131371422)
    {
      bdxh.a(6);
      super.d(paramChatMessage);
      return;
    }
    if (paramInt == 2131365147)
    {
      c(localMessageForPtt);
      return;
    }
    if (paramInt == 2131367027)
    {
      d(localMessageForPtt);
      return;
    }
    if (paramInt == 2131377947)
    {
      b(localMessageForPtt, paramChatMessage);
      return;
    }
    if (paramInt == 2131371380)
    {
      if (c(localMessageForPtt)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
      }
      super.a(paramChatMessage);
      return;
    }
    if (paramInt == 2131372658)
    {
      e(localMessageForPtt);
      return;
    }
    if ((paramInt == 2131377756) || (paramInt == 2131377757) || (paramInt == 2131377754))
    {
      a(localMessageForPtt, paramInt);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(afwr paramafwr, View paramView, ChatMessage paramChatMessage, apwt paramapwt)
  {
    paramafwr = (aheq)paramafwr;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramafwr, localMessageForPtt);
    if ((paramapwt.jdField_a_of_type_Int == 0) || (!paramapwt.a())) {
      a(paramafwr, localMessageForPtt, bool, paramView, paramChatMessage);
    }
    label213:
    for (;;)
    {
      return;
      if (paramapwt.jdField_b_of_type_Int == 0) {
        a(paramafwr, localMessageForPtt, bool);
      }
      for (;;)
      {
        if ((!paramapwt.jdField_b_of_type_Boolean) || (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramafwr.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * paramafwr.jdField_a_of_type_Apwt.jdField_a_of_type_Double) != 1)) {
          break label213;
        }
        float f2 = paramafwr.jdField_a_of_type_AndroidWidgetTextView.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramafwr.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramafwr.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(f1, 0.0F, 0.0F, paramapwt.d);
        if (bool) {
          break;
        }
        a(-1, paramafwr);
        return;
        a(paramafwr, localMessageForPtt, bool, paramapwt);
      }
    }
  }
  
  protected void a(aheq paramaheq, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag + ", voiceLength is: " + paramMessageForPtt.voiceLength);
    }
    paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject = (RelativeLayout.LayoutParams)paramaheq.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(1, -1);
    if (paramaheq.c != null)
    {
      paramaheq.c.setVisibility(8);
      paramaheq.c.setOnClickListener(null);
      paramaheq.d.setVisibility(8);
    }
    if (paramaheq.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      paramaheq.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaheq.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      paramaheq.e.setVisibility(8);
      paramaheq.f.setVisibility(8);
      paramaheq.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
      paramaheq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramaheq.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramaheq.jdField_a_of_type_Afzq);
    paramaheq.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramaheq.jdField_a_of_type_Afzq);
    boolean bool1 = a(paramMessageForPtt, paramaheq);
    boolean bool2 = a(paramInt, paramMessageForPtt);
    localObject = a(paramInt, paramMessageForPtt);
    int i = a(paramaheq, paramMessageForPtt, paramInt, paramBoolean, (String)localObject);
    String str = b(paramInt, paramMessageForPtt);
    if (paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setSeekListener(this);
    }
    switch (i)
    {
    default: 
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
      if (paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) {
        paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
      }
      if (bool1)
      {
        paramMessageForPtt = (akpd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245);
        if (paramMessageForPtt != null)
        {
          paramMessageForPtt = paramMessageForPtt.a("voice_pwd", anni.a(2131707489), new String[] { "lowTipStr" });
          label433:
          paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, paramMessageForPtt, null);
        }
      }
      else if (AppSetting.c)
      {
        paramMessageForPtt = anni.a(2131707480);
        if (!bool2) {
          break label665;
        }
        paramaheq.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject + anni.a(2131707485) + anni.a(2131707481));
      }
      break;
    }
    for (;;)
    {
      if (paramaheq.jdField_a_of_type_JavaLangStringBuilder != null)
      {
        paramaheq.jdField_a_of_type_JavaLangStringBuilder.append("发送了语音.").append((String)localObject);
        if (str != null) {
          paramaheq.jdField_a_of_type_JavaLangStringBuilder.append(" ").append(str);
        }
      }
      return;
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
      ImageView localImageView = paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c;
      if (paramMessageForPtt.isSendFromLocal()) {}
      for (paramMessageForPtt = anni.a(2131707490);; paramMessageForPtt = anni.a(2131707482))
      {
        localImageView.setContentDescription(paramMessageForPtt);
        break;
      }
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839406, null);
      paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
      ((Animatable)paramaheq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getDrawable()).start();
      break;
      paramMessageForPtt = anni.a(2131707489);
      break label433;
      label665:
      paramaheq.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject + anni.a(2131707494));
    }
  }
  
  protected void a(aheq paramaheq, MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      if (paramBoolean1) {
        i = 2;
      }
    }
    for (int j = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c;; j = 0)
    {
      adrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt, false, i, j, paramBoolean2);
      return;
      i = 1;
      break;
      i = 5;
    }
  }
  
  protected void a(aheq paramaheq, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramaheq.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(afur.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (paramBoolean3)
      {
        localObject = ((Resources)localObject).getDrawable(2130847045);
        if (localObject != null)
        {
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
          paramaheq.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
        }
      }
      do
      {
        return;
        localObject = ((Resources)localObject).getDrawable(2130847043);
      } while (localObject == null);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
      paramaheq.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
      return;
    }
    paramaheq.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
    paramaheq.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public void a(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)afur.a(paramView);
    paramView = (aheq)afur.a(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = bkho.a(this.jdField_a_of_type_AndroidContentContext);
      paramView.a(2131689927);
      paramView.b(2131689926);
      paramView.c(2131690582);
      paramView.a(new ahep(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    if ((!Environment.getExternalStorageState().equals("mounted")) || (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1))
    {
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        QQToast.a(BaseApplication.getContext(), 2131694002, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298998));
        return;
      }
      QQToast.a(BaseApplication.getContext(), 2131717590, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298998));
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
        paramView = (aheq)((View)paramView.getParent().getParent()).getTag();
      } while (paramView == null);
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getBackground();
    } while (paramView == null);
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  public void a(View paramView, bduk parambduk, int paramInt1, int paramInt2)
  {
    if ((parambduk.jdField_b_of_type_Int != 2) || (paramInt1 == 2002) || (paramInt1 == 1002) || (paramInt1 == 2001)) {}
    MessageForPtt localMessageForPtt;
    do
    {
      do
      {
        return;
      } while (!(afur.a(paramView) instanceof MessageForPtt));
      localMessageForPtt = (MessageForPtt)afur.a(paramView);
    } while ((localMessageForPtt == null) || (localMessageForPtt.uniseq != parambduk.jdField_b_of_type_Long));
    paramView = (aheq)afur.a(paramView);
    if ((paramInt1 == 1003) || (paramInt1 == 2003))
    {
      paramInt2 = paramInt1;
      if (!parambduk.jdField_b_of_type_Boolean)
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
      if ((parambduk.d == 1005) || (parambduk.d == 1004))
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
        localObject = (afwr)paramView.getTag();
        paramView = (BaseChatItemLayout)paramView;
        b(paramChatMessage, (afwr)localObject, ((afwr)localObject).jdField_a_of_type_AndroidViewView, paramView, null);
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
          localObject = (aheq)localView.getTag();
          if (localObject == null) {
            break label196;
          }
          localObject = ((aheq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView;
          paramView = afur.a((View)paramView.getParent().getParent().getParent());
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
    paramPttAudioWaveView = (aheq)afur.a(paramPttAudioWaveView);
    if (paramPttAudioWaveView != null)
    {
      MediaPlayerManager localMediaPlayerManager = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localMediaPlayerManager.a(localMediaPlayerManager.a(), paramPttAudioWaveView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView, float paramFloat)
  {
    paramPttAudioWaveView = (aheq)afur.a(paramPttAudioWaveView);
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
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean, aheq paramaheq)
  {
    this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramMessageForPtt.isSend())
    {
      if (d(paramMessageForPtt))
      {
        paramMessageForPtt = paramaheq.jdField_a_of_type_AndroidWidgetImageView;
        if (paramBoolean) {}
        for (i = 2130847041;; i = 2130847044)
        {
          paramMessageForPtt.setImageResource(i);
          return;
        }
      }
      paramMessageForPtt = paramaheq.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {}
      for (i = 2130849970;; i = 2130849971)
      {
        paramMessageForPtt.setImageResource(i);
        return;
      }
    }
    if (d(paramMessageForPtt))
    {
      paramMessageForPtt = paramaheq.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {}
      for (i = 2130847035;; i = 2130847042)
      {
        paramMessageForPtt.setImageResource(i);
        return;
      }
    }
    paramMessageForPtt = paramaheq.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i = 2130849964;; i = 2130849963)
    {
      paramMessageForPtt.setImageResource(i);
      return;
    }
  }
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, aheq paramaheq)
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
              paramaheq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForPtt);
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
          a(paramMessageForPtt, paramBoolean3, paramaheq);
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
      paramXListView = afur.a(paramView);
      if ((paramXListView instanceof aheq))
      {
        paramXListView = (aheq)paramXListView;
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
      paramXListView = afur.a(paramView);
      if ((paramXListView instanceof aheq))
      {
        paramXListView = (aheq)paramXListView;
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
  
  public boolean a(afwr paramafwr)
  {
    return paramafwr instanceof aheq;
  }
  
  protected boolean a(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, afwr paramafwr, MessageForPtt paramMessageForPtt)
  {
    return VoicePrintUtils.a(paramQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramBaseAdapter, paramafwr, paramMessageForPtt);
  }
  
  protected boolean a(MessageForPtt paramMessageForPtt, aheq paramaheq)
  {
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = true;
    Object localObject;
    if (akxm.a(paramMessageForPtt)) {
      if (CustomizeStrategyFactory.a().a())
      {
        localObject = (akpd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245);
        if (localObject != null)
        {
          i = ((akpd)localObject).a("voice_pwd", 1, new String[] { "scoreSwitch" });
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
          paramaheq.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramMessageForPtt.icon);
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
        paramMessageForPtt = paramaheq.jdField_b_of_type_AndroidWidgetImageView;
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
                i = ((akpd)localObject).a("voice_pwd", 5, new String[] { "lowTipsLimit" });
                int k = akms.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "voice_low_tips_count", 0);
                if (k >= i) {
                  break label383;
                }
                paramMessageForPtt.saveExtInfoToExtStr("voice_low_tips_tag", "1");
                ThreadManager.post(new PttItemBuilder.2(this, paramMessageForPtt), 10, null, false);
                akms.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "voice_low_tips_count", k + 1);
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
        } while (paramaheq.jdField_b_of_type_AndroidWidgetImageView == null);
        paramaheq.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
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
    aztu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramXListView);
    if (paramXListView.isReady())
    {
      paramView = afur.a(paramView);
      if ((paramView != null) && (!(paramView instanceof aheq))) {
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "play failed not Holder " + paramXListView.getLocalFilePath());
        }
      }
      do
      {
        return false;
        paramView = (aheq)paramView;
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
          a(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout, paramXListView, paramView.jdField_a_of_type_Apwt, 0);
        }
        bdxh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView.istroop, paramXListView.issend);
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
        bdxh.a(paramXListView, paramInt1, bool, 1);
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
  
  public bguj[] a(View paramView)
  {
    return a(new bguh(), (MessageForPtt)afur.a(paramView));
  }
  
  protected bguj[] a(bguh parambguh, MessageForPtt paramMessageForPtt)
  {
    if (a(parambguh, paramMessageForPtt)) {
      return parambguh.a();
    }
    if (c(paramMessageForPtt)) {
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
    }
    String str;
    int i;
    if (!afur.b())
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l))
      {
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131694337);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l)) {
          break label352;
        }
        i = 2130838926;
        label89:
        parambguh.a(2131372658, str, i);
      }
    }
    else
    {
      if (((paramMessageForPtt.extraflag != 32768) && (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt) == 1003) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForPtt))) || (bfup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        a(parambguh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForPtt);
      }
      a(parambguh, paramMessageForPtt);
      if (paramMessageForPtt.voiceChangeFlag != 1)
      {
        if ((paramMessageForPtt.sttAbility != 1) && (paramMessageForPtt.sttAbility != 3)) {
          break label359;
        }
        if ((!this.jdField_a_of_type_Bdbn.a(paramMessageForPtt)) && ((!paramMessageForPtt.isSend()) || (paramMessageForPtt.fileSize > 0L)) && (!akxm.a(paramMessageForPtt))) {
          parambguh.a(2131377947, this.jdField_a_of_type_AndroidContentContext.getString(2131718242), 2130838919);
        }
      }
    }
    for (;;)
    {
      a(paramMessageForPtt, parambguh);
      parambguh.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691094));
      a(parambguh, paramMessageForPtt);
      parambguh.a(2131366271, this.jdField_a_of_type_AndroidContentContext.getString(2131691986), 2130838928);
      super.a(parambguh, this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt);
      b(paramMessageForPtt, parambguh);
      super.c(parambguh, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambguh, this.jdField_a_of_type_AndroidContentContext);
      return parambguh.a();
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131694339);
      break;
      label352:
      i = 2130838930;
      break label89;
      label359:
      if (paramMessageForPtt.sttAbility == 2) {
        if (paramMessageForPtt.expandStt)
        {
          parambguh.a(2131365147, this.jdField_a_of_type_AndroidContentContext.getString(2131718240), 2130838922);
          parambguh.a(2131367027, this.jdField_a_of_type_AndroidContentContext.getString(2131689941), 2130838929);
        }
        else if (!akxm.a(paramMessageForPtt))
        {
          parambguh.a(2131377947, this.jdField_a_of_type_AndroidContentContext.getString(2131718242), 2130838919);
        }
      }
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "1", "", "", "");
  }
  
  protected View b(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    paramBaseChatItemLayout = (aheq)paramafwr;
    this.jdField_a_of_type_JavaUtilSet.add(paramBaseChatItemLayout);
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramafwr = paramView;
    if (paramView == null)
    {
      paramafwr = new BreathAnimationLayout(this.jdField_a_of_type_AndroidContentContext);
      paramafwr.setId(2131374124);
      paramView = new PttAudioPlayView(this.jdField_a_of_type_AndroidContentContext, 12);
      paramView.setThemeColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167004).getDefaultColor());
      paramView.setId(2131374129);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject1).width = afur.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject1).height = afur.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new PttAudioChangeView(this.jdField_a_of_type_AndroidContentContext, 2130838197, 8);
      ((PttAudioChangeView)localObject1).setThemeColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167004).getDefaultColor());
      ((PttAudioChangeView)localObject1).setId(2131374135);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject2).width = afur.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject2).height = afur.a(19.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((PttAudioChangeView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new PttAudioWaveView(this.jdField_a_of_type_AndroidContentContext);
      ((PttAudioWaveView)localObject2).setProgressColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167004).getDefaultColor());
      ((PttAudioWaveView)localObject2).setId(2131374130);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject3).width = afur.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject3).height = afur.a(52.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((PttAudioWaveView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject3).setId(2131374131);
      ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167004));
      VoicePrintUtils.VoicePrintView localVoicePrintView = new VoicePrintUtils.VoicePrintView(this.jdField_a_of_type_AndroidContentContext);
      localVoicePrintView.setId(2131374132);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setId(2131374134);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      localVoicePrintView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject4).width = afur.a(47.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject4).height = afur.a(41.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new SyncParentPressedRelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject4).setId(2131374127);
      ((RelativeLayout)localObject4).addView((View)localObject2);
      ((RelativeLayout)localObject4).addView(paramView);
      ((RelativeLayout)localObject4).addView((View)localObject1);
      ((RelativeLayout)localObject4).addView((View)localObject3);
      ((RelativeLayout)localObject4).addView(localVoicePrintView);
      ((RelativeLayout)localObject4).addView(localImageView);
      paramafwr.addView((View)localObject4);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = paramafwr;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView = ((PttAudioChangeView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject2);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView = localVoicePrintView;
      paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView = localImageView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject4);
    }
    if (paramafzq != null) {
      paramBaseChatItemLayout.jdField_a_of_type_Afzq = paramafzq;
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
      paramView.addRule(1, 2131374132);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, 2131374134);
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
      if (((localMessageForPtt.istroop == 1) || (localMessageForPtt.istroop == 3000)) && (i == 2003) && (this.jdField_a_of_type_Bdbn.b(localMessageForPtt)))
      {
        b(localMessageForPtt, 2);
        bcst.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
      }
      a(paramBaseChatItemLayout, localMessageForPtt, i, c(localMessageForPtt));
      aztu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(localMessageForPtt);
      bdxh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramChatMessage);
      return paramafwr;
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
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnTouchListener(paramBaseChatItemLayout.jdField_a_of_type_Afzq);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnLongClickListener(paramBaseChatItemLayout.jdField_a_of_type_Afzq);
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
      paramView.addRule(1, 2131374130);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131374135);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getLayoutParams()).addRule(1, 2131374134);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374129);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
      continue;
      label1355:
      if (bool)
      {
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374131);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131374132);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, -1);
      }
      else
      {
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131374130);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131374135);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getLayoutParams()).addRule(1, 2131374134);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374129);
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
    bdxh.a(7);
    super.d();
  }
  
  public void onClick(View paramView)
  {
    afur.n = true;
    int i = paramView.getId();
    if ((AppSetting.c) && (i == 2131363300)) {
      paramView.findViewById(2131374127).performClick();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = (aheq)afur.a(paramView);
      Object localObject2 = (MessageForPtt)((aheq)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((i == 2131374127) || (i == 2131374130))
      {
        if (localObject2 != null)
        {
          if (c((ChatMessage)localObject2))
          {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
            bcst.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 2, 0, "", "", "", "");
          }
          for (;;)
          {
            if (((MessageForPtt)localObject2).istroop == 1008) {
              oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", ((MessageForPtt)localObject2).timeStr, "", false);
            }
            if (((MessageForPtt)localObject2).voiceChangeFlag != 1) {
              break;
            }
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F7E", 0, 0, "" + ((MessageForPtt)localObject2).istroop, "", "", "");
            break;
            if ((localObject2 != MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (((MessageForPtt)localObject2).isReady())) {
              a((aheq)localObject1, (MessageForPtt)localObject2, paramView);
            }
          }
        }
      }
      else if ((i == 2131374146) || (i == 2131374140))
      {
        if ((localObject2 != null) && (((MessageForPtt)localObject2).expandStt))
        {
          ((MessageForPtt)localObject2).expandStt = false;
          ((MessageForPtt)localObject2).serial();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((MessageForPtt)localObject2).uniseq, ((MessageForPtt)localObject2).msgData);
          a((aheq)localObject1, (MessageForPtt)localObject2, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForPtt)localObject2), c((ChatMessage)localObject2));
          bcst.b(null, "dc00898", "", "", "0X8009DF8", "0X8009DF8", 0, 0, "", "", "", "");
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
        }
      }
      else if (i == 2131364408)
      {
        if (this.jdField_a_of_type_AndroidContentContext != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          String str = nlw.a();
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
 * Qualified Name:     ahen
 * JD-Core Version:    0.7.0.1
 */