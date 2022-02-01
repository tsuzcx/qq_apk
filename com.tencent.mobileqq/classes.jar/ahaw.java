import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArraySet;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.12;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.13;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.14;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.15;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.16;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.6;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.8;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.aio.item.SyncParentPressedRelativeLayout;
import com.tencent.mobileqq.activity.contact.connections.TriangleView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ahaw
  extends BaseBubbleBuilder
  implements aftf
{
  public static ChatMessage a;
  public static PicEmoticonInfo a;
  public static int c;
  static long jdField_c_of_type_Long;
  ahbi jdField_a_of_type_Ahbi = new ahbi();
  public asih a;
  asiu jdField_a_of_type_Asiu = new ahbg(this);
  public List<ahbj> a;
  public Set<Long> a;
  public Context b;
  Set<ahbj> b;
  Set<Long> jdField_c_of_type_JavaUtilSet = new ArraySet();
  public int d;
  private long d;
  public int e;
  public boolean f = false;
  
  static
  {
    jdField_c_of_type_Int = 1;
  }
  
  public ahaw(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_d_of_type_Int = 320;
    this.jdField_e_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Asih = ((asih)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER));
    if ((this.jdField_b_of_type_AndroidContentContext instanceof SplashActivity)) {
      this.f = true;
    }
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, Handler paramHandler)
  {
    boolean bool = true;
    asfk localasfk = (asfk)paramQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
    if (QLog.isColorLevel()) {
      QLog.i("MarketFaceItemBuilder", 2, "Call getEmoticonDataList from addEmotionToFavorite.");
    }
    List localList = localasfk.a();
    int j;
    int i;
    if (localList != null)
    {
      j = 0;
      int m = 0;
      int n;
      for (i = 1; j < localList.size(); i = n)
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(j);
        int k;
        if (!TextUtils.isEmpty(localCustomEmotionData.RomaingType))
        {
          k = m;
          if ("needDel".equals(localCustomEmotionData.RomaingType)) {}
        }
        else
        {
          k = m + 1;
        }
        if ((localCustomEmotionData.isMarkFace) && (localCustomEmotionData.emoPath.equals(paramEmoticon.epId)) && (localCustomEmotionData.eId.equals(paramEmoticon.eId)))
        {
          if (localasfk.a(localCustomEmotionData, j))
          {
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramHandler != null) {
              paramHandler.post(new MarketFaceItemBuilder.15(paramContext));
            }
            awyr.c("0", 1);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
            }
            return 0;
          }
          if (paramHandler != null) {
            paramHandler.post(new MarketFaceItemBuilder.16(paramContext));
          }
          awyr.c("2003", 1);
          return 0;
        }
        n = i;
        if (i < localCustomEmotionData.emoId) {
          n = localCustomEmotionData.emoId;
        }
        j += 1;
        m = k;
      }
      if (m >= asfi.a) {
        j = -2;
      }
    }
    for (;;)
    {
      paramHandler = new CustomEmotionData();
      paramHandler.uin = paramQQAppInterface.getCurrentAccountUin();
      paramHandler.emoId = (i + 1);
      paramHandler.isMarkFace = true;
      paramHandler.emoPath = paramEmoticon.epId;
      paramHandler.eId = paramEmoticon.eId;
      paramHandler.checkMarketFace("addEmotionToFavorite");
      paramEmoticon = ((awyr)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramEmoticon.epId);
      if (paramEmoticon != null) {
        if (paramEmoticon.isAPNG != 2) {
          break label427;
        }
      }
      for (;;)
      {
        paramHandler.isAPNG = bool;
        paramEmoticon = (asfl)paramQQAppInterface.getManager(QQManagerFactory.FAV_ROAMING_MANAGER);
        if (paramEmoticon != null) {
          paramEmoticon.b(paramHandler, new aset(paramQQAppInterface, paramContext, paramHandler, null, 0));
        }
        if (jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
          a(paramQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect_suc", 0);
        }
        return j;
        label427:
        bool = false;
      }
      j = 0;
      continue;
      i = 1;
      j = 0;
    }
  }
  
  private SpannableString a(int paramInt, String paramString1, String paramString2)
  {
    String str = "";
    Object localObject = paramString2;
    int i;
    if (TextUtils.isEmpty(paramString2))
    {
      i = 2131691001;
      switch (paramInt)
      {
      default: 
        paramString2 = str;
        paramInt = i;
      }
    }
    for (;;)
    {
      localObject = this.jdField_b_of_type_AndroidContentContext.getString(paramInt, new Object[] { paramString2 });
      paramString2 = (String)localObject + paramString1;
      localObject = new SpannableString(paramString2);
      paramInt = paramString2.indexOf(paramString1);
      i = paramString1.length();
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-31676), paramInt, i + paramInt, 33);
      return localObject;
      paramInt = 2131691002;
      paramString2 = anvx.a(2131705943);
      continue;
      paramString2 = anvx.a(2131705938);
      paramInt = i;
      continue;
      paramString2 = anvx.a(2131705935);
      paramInt = i;
      continue;
      paramString2 = anvx.a(2131705945);
      paramInt = i;
    }
  }
  
  private bisl a()
  {
    if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().mAuthEmoticonDialog == null) {
        ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().mAuthEmoticonDialog = new bisl(this.jdField_b_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().mAuthEmoticonDialog;
    }
    return null;
  }
  
  private String a()
  {
    try
    {
      i = NetworkUtil.getSystemNetwork(this.jdField_b_of_type_AndroidContentContext);
      switch (i)
      {
      default: 
        return "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
      }
      return "2G";
    }
    return "3G";
    return "4G";
    return "wifi";
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Ahbi.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a());
    asig.a().a(this.jdField_a_of_type_Ahbi);
    this.jdField_a_of_type_Asih.a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, asih.jdField_c_of_type_Int);
  }
  
  public static void a(int paramInt1, Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, int paramInt2, String paramString, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramEmoticon == null) {
      QLog.d("MarketFaceItemBuilder", 1, "can not find emoticon");
    }
    label223:
    do
    {
      Handler localHandler;
      do
      {
        do
        {
          do
          {
            return;
            if (a(paramContext)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("MarketFaceItemBuilder", 2, "context is not in the top");
          return;
          localHandler = new Handler(Looper.getMainLooper());
          if (paramInt2 != 0) {
            break label223;
          }
          if (7 != paramInt1 % 1000) {
            break;
          }
          try
          {
            paramQQAppInterface = new Bundle();
            paramQQAppInterface.putInt("forward_type", 9);
            paramQQAppInterface.putBoolean("forward_emotion_from_preview", paramBoolean);
            paramEmoticon = new Intent();
            paramEmoticon.putExtras(paramQQAppInterface);
            aupt.a((BaseActivity)paramContext, paramEmoticon, 21, 100500, "biz_src_jc_gif");
            return;
          }
          catch (Exception paramContext) {}
        } while (!QLog.isColorLevel());
        QLog.e("EmosmDetailActivity.operateMarketFaceFromDownLoad", 2, paramContext.getMessage());
        return;
        if (6 == paramInt1 % 1000)
        {
          ThreadManager.post(new MarketFaceItemBuilder.12(paramContext, paramQQAppInterface, paramEmoticon, localHandler), 5, null, true);
          return;
        }
      } while (107 != paramInt1 % 1000);
      bdla.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_follow_send_aio", 0, 0, "", paramEmoticon.epId, "", "");
      PicEmoticonInfo.send(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, null);
      return;
      if (paramInt2 < 0)
      {
        localHandler.post(new MarketFaceItemBuilder.13(paramContext, paramString));
        if (6 == paramInt1 % 1000) {
          awyr.c("2001", 1);
        }
        QLog.i("MarketFaceItemBuilder", 1, "opType: " + paramInt1 + ",result:" + paramInt2);
        return;
      }
      localHandler.post(new MarketFaceItemBuilder.14(paramInt1, paramContext, paramQQAppInterface, paramEmoticon, paramString));
    } while (6 != paramInt1 % 1000);
    awyr.c("2002", 1);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, PicEmoticonInfo paramPicEmoticonInfo, SessionInfo paramSessionInfo, bisl parambisl)
  {
    a(paramInt, paramContext, paramQQAppInterface, paramEmoticonPackage, paramPicEmoticonInfo, paramSessionInfo, parambisl, false);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, PicEmoticonInfo paramPicEmoticonInfo, SessionInfo paramSessionInfo, bisl parambisl, boolean paramBoolean)
  {
    if (paramPicEmoticonInfo == null) {
      return;
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.mobileFeetype == 1))
    {
      if ((parambisl != null) && (parambisl.isShowing())) {
        parambisl.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramPicEmoticonInfo.emoticon, 0, null, paramSessionInfo, paramBoolean);
      return;
    }
    if ((!NetworkUtil.isNetworkAvailable(paramContext)) || (paramInt > 1000))
    {
      if ((parambisl != null) && (parambisl.isShowing())) {
        parambisl.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramPicEmoticonInfo.emoticon, -404, anvx.a(2131705942), paramSessionInfo, paramBoolean);
      return;
    }
    ((antu)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).a(paramInt, Integer.valueOf(paramPicEmoticonInfo.emoticon.epId).intValue(), paramPicEmoticonInfo.emoticon.eId);
  }
  
  private void a(ahbj paramahbj)
  {
    EmoticonPackage localEmoticonPackage;
    if (!this.jdField_a_of_type_Asih.a(paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, Boolean.valueOf(false)))
    {
      asig.a().a(this.jdField_a_of_type_Asiu);
      localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.name;
      localEmoticonPackage.epId = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
      localEmoticonPackage.jobType = 3;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      if (paramahbj.jdField_e_of_type_Int != -1) {
        break label223;
      }
    }
    label223:
    for (localEmoticonPackage.rscType = awrh.a(paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.magicValue);; localEmoticonPackage.rscType = paramahbj.jdField_e_of_type_Int)
    {
      ((awyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon);
      paramahbj.jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = true;
      this.jdField_a_of_type_JavaUtilList.add(paramahbj);
      paramahbj.f.setVisibility(8);
      paramahbj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_Asih.a(localEmoticonPackage, false);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void a(ahbj paramahbj, int paramInt, MessageForMarketFace paramMessageForMarketFace, ChatMessage paramChatMessage, long paramLong)
  {
    paramahbj.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    if (paramMessageForMarketFace.mMarkFaceMessage != null) {
      a(paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, paramInt, paramMessageForMarketFace.mMarkFaceMessage.copywritingContent);
    }
    ahcj.e();
    long l = paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    paramahbj.jdField_a_of_type_Long = paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    if (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null)
    {
      paramahbj.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130838049);
      l = System.currentTimeMillis();
      if ((QLog.isColorLevel()) && (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)) {
        QLog.d("MarketFaceItemBuilder", 1, "epId = " + paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId + ":view time = " + (l - paramLong));
      }
      return;
    }
    paramahbj.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131705944) + paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.name);
    String str;
    if (2 == paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType)
    {
      awra localawra = (awra)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PNG_FRAME_DRAWABLE_MANAGER);
      boolean bool = false;
      if (paramahbj.jdField_b_of_type_Int == paramahbj.jdField_c_of_type_Int - 1) {
        bool = localawra.a(paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      str = "";
      if (paramMessageForMarketFace.mMarkFaceMessage != null) {
        if ((paramMessageForMarketFace.mMarkFaceMessage.mobileparam != null) && (paramMessageForMarketFace.mMarkFaceMessage.mobileparam.length > 0))
        {
          paramMessageForMarketFace = new String(paramMessageForMarketFace.mMarkFaceMessage.mobileparam);
          label305:
          localawra.a(paramMessageForMarketFace, paramahbj, l, bool, true, new ahbf(this, paramChatMessage, paramahbj));
          paramahbj.d.setVisibility(8);
          paramahbj.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramahbj.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
          paramahbj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
          paramahbj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramahbj.f.setVisibility(8);
          c(paramahbj);
        }
      }
    }
    for (;;)
    {
      if (((2 == paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) || (4 == paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType)) && (paramahbj.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView != null))
      {
        paramahbj.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
        paramahbj.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      }
      if (!this.f) {
        break;
      }
      d(paramahbj);
      break;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage mobileparam is empty");
      paramMessageForMarketFace = str;
      break label305;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage is null");
      paramMessageForMarketFace = str;
      break label305;
      if (4 == paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType)
      {
        if (!paramChatMessage.isSend()) {
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "mbjieshou", 0, 0, paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "", "");
        }
        a(paramChatMessage, paramahbj);
        b(paramahbj);
      }
      else
      {
        a(paramChatMessage, paramahbj);
      }
    }
  }
  
  private void a(ahbj paramahbj, long paramLong)
  {
    Animatable localAnimatable = (Animatable)paramahbj.g.getDrawable();
    if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramLong)))
    {
      if (!localAnimatable.isRunning()) {
        localAnimatable.start();
      }
      paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(4);
      paramahbj.g.setVisibility(0);
      return;
    }
    if (localAnimatable.isRunning()) {
      localAnimatable.stop();
    }
    paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
    paramahbj.g.setVisibility(4);
  }
  
  private void a(ahbj paramahbj, Rect paramRect)
  {
    AIOEmotionFragment.a(this.jdField_b_of_type_AndroidContentContext, paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramRect);
  }
  
  private void a(ahbj paramahbj, URLDrawable paramURLDrawable, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramURLDrawable != null) {
      switch (paramURLDrawable.getStatus())
      {
      default: 
        paramahbj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramBaseChatItemLayout.setProgressVisable(true);
      }
    }
    do
    {
      float f1;
      do
      {
        do
        {
          return;
          if (!awsw.a()) {
            paramahbj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          }
        } while ((EmoticonUtils.isWifiOrG3OrG4()) && (2 == paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) && (!this.jdField_a_of_type_Asih.f(paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)) && (!EmoticonUtils.needDisableAutoReceiveMagicFace()));
        f1 = this.jdField_a_of_type_Asih.a(paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
      } while ((f1 >= 0.0F) && (1.0F != f1));
      paramahbj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramBaseChatItemLayout.setProgressVisable(false);
      return;
      paramahbj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramBaseChatItemLayout.setProgressVisable(false);
    } while (!AppSetting.c);
    paramahbj.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(anvx.a(2131705939));
  }
  
  private void a(ahbj paramahbj, String paramString)
  {
    if ((paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 0) && (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 2) && (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 4))
    {
      paramahbj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if (!"big_sound".equals(paramString)) {
        break label181;
      }
      if ((paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.isSound))
      {
        if (!c(paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
          break label123;
        }
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      }
    }
    label123:
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694935, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
            return;
          }
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
          return;
        } while (!"aio_preview".equals(paramString));
        paramString = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getLoadingDrawable("fromAIO", true);
      } while (paramString == null);
      paramahbj.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      paramahbj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      a(paramahbj, paramString);
    } while (!paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound());
    label181:
    jdField_c_of_type_Long = paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    bdla.b(paramQQAppInterface, "CliOper", "", "", paramString2, paramString3, paramInt, 0, "", "", "", "");
  }
  
  private void a(ChatMessage paramChatMessage, ahbj paramahbj)
  {
    a(paramChatMessage, paramahbj, "");
  }
  
  private void a(ChatMessage paramChatMessage, ahbj paramahbj, String paramString)
  {
    int i = 0;
    if ((paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) && (!c(paramChatMessage))) {}
    for (boolean bool = false;; bool = true)
    {
      URLDrawable localURLDrawable = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getLoadingDrawable("fromAIO", bool);
      Object localObject1 = "";
      Object localObject2 = localObject1;
      if (localURLDrawable != null)
      {
        localObject2 = localObject1;
        if (localURLDrawable.getStatus() == 1)
        {
          if ((localURLDrawable.getStateTag() instanceof Bundle)) {
            localObject1 = ((Bundle)localURLDrawable.getStateTag()).getString("display_type");
          }
          localObject2 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = localObject1;
            if (((String)localObject1).equals("aio_preview"))
            {
              localObject2 = paramahbj.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
              if ((localObject2 != null) && (((EmoticonPackage)localObject2).status == 2))
              {
                URLDrawable.removeMemoryCacheByUrl(localURLDrawable.getURL().toString());
                paramString = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getLoadingDrawable("fromAIO", bool);
              }
            }
          }
        }
      }
      for (;;)
      {
        b(paramahbj, paramString);
        paramahbj.d.setVisibility(8);
        paramahbj.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        paramahbj.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
        c(paramChatMessage, paramahbj);
        b(paramChatMessage, paramahbj);
        if (paramString != null) {
          a(paramahbj, paramString, (String)localObject1);
        }
        c(paramahbj);
        return;
        if (!paramString.equals("")) {
          i = 1;
        }
        localObject2 = localObject1;
        if (i != 0)
        {
          URLDrawable.removeMemoryCacheByUrl(localURLDrawable.getURL().toString());
          paramString = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getLoadingDrawable("fromAIO", bool, true, paramahbj);
        }
        else
        {
          paramString = localURLDrawable;
          localObject1 = localObject2;
        }
      }
    }
  }
  
  private void a(PicEmoticonInfo paramPicEmoticonInfo, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      str2 = a();
      if (paramPicEmoticonInfo == null) {}
      for (paramPicEmoticonInfo = "";; paramPicEmoticonInfo = paramPicEmoticonInfo.emoticon.epId)
      {
        VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramPicEmoticonInfo, paramString);
        return;
      }
    case 3: 
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramPicEmoticonInfo == null) {}
      for (paramPicEmoticonInfo = "";; paramPicEmoticonInfo = paramPicEmoticonInfo.emoticon.epId)
      {
        bdla.b(paramString, "CliOper", "", "", "ep_mall", "0X8007187", 0, 0, paramPicEmoticonInfo, "", "", "");
        return;
      }
    }
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    String str2 = a();
    if (paramPicEmoticonInfo == null) {}
    for (paramPicEmoticonInfo = "";; paramPicEmoticonInfo = paramPicEmoticonInfo.emoticon.epId)
    {
      VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramPicEmoticonInfo, paramString, "1", "", "", "", 0, 0, 0, 0);
      return;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      if (localObject != null)
      {
        localObject = ((ComponentName)localObject).getClassName();
        return paramContext.getClass().getName().equals(localObject);
      }
    }
    return true;
  }
  
  private static void b(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, String paramString1, String paramString2)
  {
    try
    {
      bhdj.a(paramContext, 230, paramString1, paramString2, 2131690697, 2131691569, new ahba(paramEmoticon, paramContext, paramQQAppInterface, paramInt), new ahbb()).show();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EmosmDetailActivity.showCustomMarketFaceTips", 2, paramContext.getMessage());
    }
  }
  
  private void b(ahbj paramahbj)
  {
    if ((4 != paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) || (((MessageForMarketFace)paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Asih.a(paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, true, true)) {
        break;
      }
      if (!EmoticonUtils.isWifiOrG3OrG4())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone: H5MagicSource isnot Intact , and network isnot 2 3 4G or wifi;epId = " + paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
        }
        paramahbj.f.setVisibility(8);
        return;
      }
    } while (-1.0F != this.jdField_a_of_type_Asih.a(paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId));
    asig.a().a(this.jdField_a_of_type_Asiu);
    EmoticonPackage localEmoticonPackage = new EmoticonPackage();
    localEmoticonPackage.name = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.name;
    localEmoticonPackage.epId = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
    localEmoticonPackage.jobType = 5;
    localEmoticonPackage.type = 1;
    localEmoticonPackage.isMagicFaceDownloading = true;
    ((awyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon);
    this.jdField_a_of_type_JavaUtilList.add(paramahbj);
    paramahbj.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
    paramahbj.f.setVisibility(8);
    paramahbj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    ((MessageForMarketFace)paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
    this.jdField_a_of_type_Asih.a(localEmoticonPackage, false);
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone,start download epId = " + paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, localEmoticonPackage.epId, "", "", "");
    return;
    if ((this.f) && (this.jdField_a_of_type_Asih.b()))
    {
      if (!this.jdField_b_of_type_Boolean) {
        paramahbj.f.setVisibility(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source intacat epId = " + paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
      }
    }
    for (;;)
    {
      paramahbj.f.setImageResource(2130838053);
      if ((((MessageForMarketFace)paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage).isSend()) || (!((MessageForMarketFace)paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay) || (!this.jdField_a_of_type_Asih.a()) || (System.currentTimeMillis() - this.jdField_d_of_type_Long <= 3000L) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().hasXPanelContainer())) {
        break;
      }
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      ((MessageForMarketFace)paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      b(paramahbj, "1");
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "", "");
      return;
      paramahbj.f.setVisibility(8);
    }
  }
  
  private void b(ahbj paramahbj, URLDrawable paramURLDrawable)
  {
    int m = 200;
    int j;
    label50:
    int k;
    int n;
    Object localObject;
    if ((paramURLDrawable != null) && (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)) {
      if (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.width == 0)
      {
        j = 200;
        if (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.height != 0) {
          break label429;
        }
        k = j;
        i = m;
        if (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.extensionWidth != 0)
        {
          k = j;
          i = m;
          if (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.extensionHeight != 0)
          {
            k = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.extensionWidth;
            i = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.extensionHeight;
          }
        }
        j = k;
        if (k != i) {
          j = i;
        }
        n = (j * this.jdField_e_of_type_Int + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
        i = (this.jdField_e_of_type_Int * i + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
        paramahbj.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(n, i));
        localObject = paramahbj.jdField_a_of_type_AndroidWidgetTextView.getTag();
        if (!(localObject instanceof Integer)) {
          break label530;
        }
      }
    }
    label530:
    for (int i = ((Integer)localObject).intValue();; i = -1)
    {
      if ((paramahbj.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (i != -1))
      {
        String str1 = (String)paramahbj.jdField_a_of_type_AndroidWidgetTextView.getTag(2131364124);
        String str2 = (String)paramahbj.jdField_a_of_type_AndroidWidgetTextView.getTag(2131364123);
        Paint localPaint = new Paint(1);
        localPaint.setTextSize(AIOUtils.dp2px(12.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
        localPaint.setTextAlign(Paint.Align.LEFT);
        int i1 = (int)localPaint.measureText("...");
        if (!TextUtils.isEmpty(str1)) {}
        for (j = (int)localPaint.measureText(anvx.a(2131705940) + str1);; j = (int)localPaint.measureText(anvx.a(2131705936)))
        {
          m = str2.length();
          k = (int)localPaint.measureText(str2) + j;
          localObject = "";
          while ((k > n) && (m > 0))
          {
            m -= 1;
            localObject = str2.substring(0, m);
            k = (int)localPaint.measureText((String)localObject) + i1 + j;
          }
          j = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.width;
          break;
          label429:
          m = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.height;
          break label50;
        }
        if (!((String)localObject).equals(""))
        {
          localObject = a(i, (String)localObject + "...", str1);
          paramahbj.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
      }
      paramahbj.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
      a(paramahbj, paramURLDrawable, paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
      return;
    }
  }
  
  private void b(ahbj paramahbj, URLDrawable paramURLDrawable, String paramString)
  {
    String str = "";
    if ((paramURLDrawable.getStateTag() instanceof Bundle)) {
      str = ((Bundle)paramURLDrawable.getStateTag()).getString("display_type");
    }
    paramURLDrawable.restartDownload();
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "msgOnclickListener| URLDrawable restartDownload status=" + paramURLDrawable.getStatus());
    }
    a(paramahbj, paramURLDrawable, str);
    paramahbj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    if ((paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) && ("big_sound".equals(paramString))) {
      jdField_c_of_type_Long = paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    }
  }
  
  private void b(ahbj paramahbj, String paramString)
  {
    ThreadManager.post(new MarketFaceItemBuilder.6(this, paramString, paramahbj), 5, null, true);
  }
  
  private void b(ChatMessage paramChatMessage, ahbj paramahbj)
  {
    if ((paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) && (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getWaveformArray() != null)
      {
        paramChatMessage = (RelativeLayout.LayoutParams)paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
        paramChatMessage.width = AIOUtils.dp2px(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
        paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getWaveformArray(), paramChatMessage.width, paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getVoiceLength());
        if (Build.VERSION.SDK_INT < 19)
        {
          paramChatMessage = (RelativeLayout.LayoutParams)paramahbj.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
          paramChatMessage.width = AIOUtils.dp2px(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
          localLayoutParams.width = AIOUtils.dp2px(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
        }
      }
      int i = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getWaveBackgroundColor();
      int j = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getWaveForegroundColor();
      paramChatMessage = new bdoa(i, 1, 1, AIOUtils.dp2px(22.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      paramahbj.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(paramChatMessage);
      paramahbj.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.setDrawColor(i);
      paramahbj.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.postInvalidate();
      paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(j);
      paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(j);
    }
  }
  
  private void c(ahbj paramahbj)
  {
    paramahbj.jdField_a_of_type_Boolean = false;
    if ((2 != paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) || (((MessageForMarketFace)paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null) || (!awsw.a())) {}
    for (;;)
    {
      return;
      Object localObject;
      if (!this.jdField_a_of_type_Asih.f(paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId))
      {
        if (!EmoticonUtils.isWifiOrG3OrG4())
        {
          paramahbj.f.setVisibility(8);
          return;
        }
        if ((!EmoticonUtils.needDisableAutoReceiveMagicFace()) && (!this.jdField_a_of_type_Asih.a(paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, Boolean.valueOf(false))) && (-1.0F == this.jdField_a_of_type_Asih.a(paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)))
        {
          asig.a().a(this.jdField_a_of_type_Asiu);
          localObject = new EmoticonPackage();
          ((EmoticonPackage)localObject).name = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.name;
          ((EmoticonPackage)localObject).epId = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
          ((EmoticonPackage)localObject).jobType = 3;
          ((EmoticonPackage)localObject).rscType = awrh.a(paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.magicValue);
          ((EmoticonPackage)localObject).type = 1;
          ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
          ((awyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon);
          this.jdField_a_of_type_JavaUtilList.add(paramahbj);
          paramahbj.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
          paramahbj.f.setVisibility(8);
          paramahbj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((MessageForMarketFace)paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          this.jdField_a_of_type_Asih.a((EmoticonPackage)localObject, false);
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongXiazai", 0, 0, paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "", "");
        }
      }
      else
      {
        if (awrh.a(paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.magicValue) == 1) {
          paramahbj.f.setVisibility(8);
        }
        while (((MessageForMarketFace)paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay)
        {
          ((MessageForMarketFace)paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          localObject = new Emoticon();
          ((Emoticon)localObject).eId = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.eId;
          ((Emoticon)localObject).epId = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
          ((Emoticon)localObject).magicValue = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.magicValue;
          ((Emoticon)localObject).jobType = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType;
          if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() != null) && (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null) && (awsw.a())) {
            ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().playMaigcface((Emoticon)localObject, 1, ((MessageForMarketFace)paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage).senderuin, false);
          }
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "", "");
          return;
          if (!this.jdField_b_of_type_Boolean)
          {
            paramahbj.f.setImageResource(2130838053);
            paramahbj.f.setVisibility(0);
          }
        }
      }
    }
  }
  
  private void c(ChatMessage paramChatMessage, ahbj paramahbj)
  {
    if ((paramChatMessage.isFlowMessage) && (a(paramahbj)) && (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType == 0)) {
      if (!(this.jdField_b_of_type_AndroidContentContext instanceof MultiForwardActivity))
      {
        if (!paramChatMessage.isSend()) {
          break label64;
        }
        paramahbj.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130847120);
        paramahbj.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    label64:
    while ((!paramChatMessage.isDui) || (!DuiButtonImageView.jdField_a_of_type_Boolean) || (axnp.a(paramChatMessage)))
    {
      return;
      paramahbj.d.setImageResource(2130847120);
      paramahbj.d.setVisibility(0);
      return;
    }
    paramahbj.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    if ((paramChatMessage.isSend()) || ((a(paramahbj)) && (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound())))
    {
      paramahbj.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
      paramahbj.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      return;
    }
    if ((a(paramahbj)) && (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && ((2 == paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) || (4 == paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType)))
    {
      paramahbj.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
      paramahbj.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      return;
    }
    if (!paramChatMessage.hasPlayedDui) {
      paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramahbj.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView);
    }
    while (DuiButtonImageView.jdField_a_of_type_Boolean)
    {
      paramahbj.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(this);
      paramahbj.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(0);
      return;
      if (paramahbj.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.b()) {
        arzt.a(paramChatMessage);
      }
    }
    paramahbj.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(null);
    paramahbj.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
  }
  
  private boolean c(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    ChatMessage localChatMessage;
    do
    {
      return false;
      localChatMessage = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    } while ((localChatMessage != paramChatMessage) && ((!(localChatMessage instanceof MessageForMarketFace)) || (localChatMessage.frienduin == null) || (!localChatMessage.frienduin.equals(paramChatMessage.frienduin)) || (localChatMessage.uniseq != paramChatMessage.uniseq)));
    return true;
  }
  
  private void d(ahbj paramahbj)
  {
    if ((paramahbj != null) && (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()) && (paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (!this.jdField_c_of_type_JavaUtilSet.contains(Long.valueOf(paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))))
    {
      awyr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AB51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
      this.jdField_c_of_type_JavaUtilSet.add(Long.valueOf(paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
    }
  }
  
  private void h(View paramView)
  {
    paramView = (ahbj)AIOUtils.getHolder(paramView);
    EmoticonPackage localEmoticonPackage;
    if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && (2 == paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType))
    {
      if (!this.jdField_a_of_type_Asih.a(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, Boolean.valueOf(false)))
      {
        asig.a().a(this.jdField_a_of_type_Asiu);
        localEmoticonPackage = new EmoticonPackage();
        localEmoticonPackage.name = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.name;
        localEmoticonPackage.epId = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
        localEmoticonPackage.jobType = 3;
        localEmoticonPackage.type = 1;
        localEmoticonPackage.isMagicFaceDownloading = true;
        paramView.jdField_a_of_type_Boolean = false;
        ((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
        ((awyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon);
        this.jdField_a_of_type_JavaUtilList.add(paramView);
        paramView.f.setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_Asih.a(localEmoticonPackage, false);
        bdla.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongBofang", 0, 0, paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "", "");
      }
    }
    else if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && (4 == paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) && (System.currentTimeMillis() - this.jdField_d_of_type_Long > 3000L) && (this.jdField_a_of_type_Asih.a()))
    {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      if (!this.jdField_a_of_type_Asih.a(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, true, true)) {
        break label475;
      }
      b(paramView, "0");
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbFasong", "MbZhudongBofang", 0, 0, paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "", "");
      return;
      if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (!awsw.a()) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null)) {
        break;
      }
      ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().playMaigcface(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon, 1, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, true);
      break;
      label475:
      asig.a().a(this.jdField_a_of_type_Asiu);
      localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.name;
      localEmoticonPackage.epId = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
      localEmoticonPackage.jobType = 5;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      paramView.jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      ((awyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon);
      this.jdField_a_of_type_JavaUtilList.add(paramView);
      paramView.f.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_Asih.a(localEmoticonPackage, false);
    }
  }
  
  private void i(View paramView)
  {
    boolean bool = true;
    Object localObject = (ahbj)AIOUtils.getHolder(paramView);
    QQAppInterface localQQAppInterface;
    int i;
    if ((((ahbj)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (((ahbj)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) && (((ahbj)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()))
    {
      if (!c(((ahbj)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
        break label119;
      }
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
      if (((ahbj)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon == null) {
        break label112;
      }
    }
    label112:
    for (paramView = ((ahbj)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;; paramView = "")
    {
      awyr.a(localQQAppInterface, "0X800A934", i, paramView);
      return;
    }
    label119:
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694935, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      return;
    }
    if ((((ahbj)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMarketFace)) {
      ((MessageForMarketFace)((ahbj)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage).playProgress = 0.0F;
    }
    ((ahbj)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
    if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((ahbj)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage))
    {
      ((ahbj)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
      if (((ahbj)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)
      {
        paramView = ((ahbj)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
        awyr.a(localQQAppInterface, "0X800A933", i, paramView);
      }
    }
    for (;;)
    {
      if (!bool)
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (((ahbj)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)
        {
          paramView = ((ahbj)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
          label300:
          awyr.a(localQQAppInterface, "0X800A935", -1, paramView);
        }
      }
      else
      {
        localObject = new HashMap();
        if (!bool) {
          break label390;
        }
      }
      label390:
      for (paramView = "0";; paramView = "1")
      {
        ((HashMap)localObject).put("playResult", paramView);
        ((HashMap)localObject).put("playType", "1");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "NewAudioEmoticonVoicePlay", bool, 0L, 0L, (HashMap)localObject, null);
        return;
        paramView = "";
        break;
        paramView = "";
        break label300;
      }
      bool = false;
    }
  }
  
  private void j(View paramView)
  {
    ahbj localahbj = (ahbj)AIOUtils.getHolder(paramView);
    Drawable localDrawable = localahbj.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
    URLDrawable localURLDrawable;
    String str;
    if ((localDrawable instanceof URLDrawable))
    {
      localURLDrawable = (URLDrawable)localDrawable;
      str = localURLDrawable.getURL().getHost();
      if (!(localURLDrawable.getTag() instanceof Bundle)) {
        break label252;
      }
      str = ((Bundle)localURLDrawable.getTag()).getString("display_type");
    }
    label252:
    for (;;)
    {
      switch (((URLDrawable)localDrawable).getStatus())
      {
      default: 
        if ((localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && (localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType == 2) && (awsw.a())) {
          a(localahbj);
        }
        if ((((URLDrawable)localDrawable).getStatus() == 1) || ((localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && (localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isAioPreviewExists()))) {
          a(localahbj, aavz.a(paramView));
        }
        break;
      }
      do
      {
        return;
        b(localahbj, localURLDrawable, str);
        break;
        a(localahbj, str);
        break;
      } while ((!(localDrawable instanceof awqx)) || (localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon == null) || (!localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isAioPreviewExists()));
      a(localahbj, aavz.a(paramView));
      return;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afqr a()
  {
    return new ahbj();
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    long l = System.currentTimeMillis();
    paramBaseChatItemLayout = (MessageForMarketFace)paramChatMessage;
    ahbj localahbj = (ahbj)paramafqr;
    this.jdField_b_of_type_JavaUtilSet.add(localahbj);
    Object localObject2;
    Object localObject3;
    Object localObject1;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    PttAudioPlayView localPttAudioPlayView;
    Object localObject7;
    Object localObject8;
    Object localObject9;
    RelativeLayout localRelativeLayout;
    TriangleView localTriangleView;
    Object localObject10;
    Object localObject11;
    Object localObject12;
    Object localObject13;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramView == null)
    {
      paramafqr = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject2 = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout)localObject2).setId(2131370774);
      paramView = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      paramView.setId(2131367046);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131364522);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131364522);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setOnClickListener(this);
      localObject1 = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).setId(2131363516);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = 8;
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131367046);
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      ((FrameLayout)localObject1).setOnClickListener(this);
      ((FrameLayout)localObject1).setOnTouchListener(paramaftk);
      ((FrameLayout)localObject1).setOnLongClickListener(paramaftk);
      paramaftk = new ahbk(this, this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).addView(paramaftk, -2, -2);
      localObject4 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localObject5 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject5).gravity = 85;
      ((FrameLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject5).setId(2131381286);
      localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(1, 2131363516);
      ((RelativeLayout.LayoutParams)localObject6).addRule(8, 2131363516);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      ((ImageView)localObject5).setOnClickListener(this);
      localObject6 = new BreathAnimationLayout(this.jdField_b_of_type_AndroidContentContext);
      ((BreathAnimationLayout)localObject6).setId(2131371923);
      localPttAudioPlayView = new PttAudioPlayView(this.jdField_b_of_type_AndroidContentContext, 10);
      localPttAudioPlayView.setThemeColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131167045).getDefaultColor());
      localPttAudioPlayView.setId(2131371925);
      localPttAudioPlayView.setPttPauseOrStopDrawable(2130838250);
      localObject7 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject7).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject7).leftMargin = AIOUtils.dp2px(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).width = AIOUtils.dp2px(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).height = AIOUtils.dp2px(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      localPttAudioPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject7);
      localPttAudioPlayView.setOnClickListener(this);
      localObject7 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localObject8 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject8).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject8).leftMargin = AIOUtils.dp2px(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).width = AIOUtils.dp2px(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).height = AIOUtils.dp2px(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((ImageView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
      ((ImageView)localObject7).setImageDrawable((Drawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839464));
      ((ImageView)localObject7).setVisibility(4);
      localObject8 = new PttAudioWaveView(this.jdField_b_of_type_AndroidContentContext);
      ((PttAudioWaveView)localObject8).setShowProgressLine(false);
      ((PttAudioWaveView)localObject8).setMaxTopBottomPadding(4);
      ((PttAudioWaveView)localObject8).setProgressColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131167045).getDefaultColor());
      ((PttAudioWaveView)localObject8).setId(2131371926);
      localObject9 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(1, 2131371925);
      ((RelativeLayout.LayoutParams)localObject9).width = AIOUtils.dp2px(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).height = AIOUtils.dp2px(45.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).leftMargin = ViewUtils.dip2px(9.0F);
      ((RelativeLayout.LayoutParams)localObject9).rightMargin = ViewUtils.dip2px(12.0F);
      ((PttAudioWaveView)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
      ((PttAudioWaveView)localObject8).setCanSupportSlide(false);
      ((PttAudioWaveView)localObject8).setOnClickListener(this);
      localObject9 = new SyncParentPressedRelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      ((RelativeLayout)localObject9).setId(2131371924);
      ((RelativeLayout)localObject9).addView((View)localObject8);
      ((RelativeLayout)localObject9).addView(localPttAudioPlayView);
      ((RelativeLayout)localObject9).addView((View)localObject7);
      localRelativeLayout = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localTriangleView = new TriangleView(this.jdField_b_of_type_AndroidContentContext);
      localObject10 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(9.0F), ViewUtils.dip2px(5.0F));
      ((RelativeLayout.LayoutParams)localObject10).leftMargin = ViewUtils.dip2px(2.0F);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14);
      ((RelativeLayout.LayoutParams)localObject10).addRule(10);
      localTriangleView.setId(2131372958);
      localTriangleView.setRotation(180.0F);
      localTriangleView.setTranslationY(ViewUtils.dip2px(1.0F));
      localTriangleView.setLayoutParams((ViewGroup.LayoutParams)localObject10);
      localRelativeLayout.addView(localTriangleView);
      localObject10 = new RelativeLayout.LayoutParams(-2, ViewUtils.dip2px(29.0F));
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131372958);
      localRelativeLayout.addView((View)localObject9, (ViewGroup.LayoutParams)localObject10);
      ((BreathAnimationLayout)localObject6).addView(localRelativeLayout);
      localObject10 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14, 2131363516);
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131363516);
      ((RelativeLayout.LayoutParams)localObject10).bottomMargin = ViewUtils.dip2px(17.0F);
      ((RelativeLayout)localObject2).addView((View)localObject6, (ViewGroup.LayoutParams)localObject10);
      localObject10 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject10).setId(2131367047);
      localObject11 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject11).addRule(1, 2131363516);
      ((RelativeLayout.LayoutParams)localObject11).addRule(15, 2131363516);
      ((RelativeLayout.LayoutParams)localObject11).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject10, (ViewGroup.LayoutParams)localObject11);
      ((ImageView)localObject10).setOnClickListener(this);
      localObject11 = new DuiButtonImageView(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      ((DuiButtonImageView)localObject11).setId(2131365911);
      localObject12 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject12).addRule(1, 2131363516);
      ((RelativeLayout.LayoutParams)localObject12).addRule(8, 2131363516);
      ((RelativeLayout.LayoutParams)localObject12).setMargins(0, 0, 0, -AIOUtils.dp2px(6.5F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout)localObject2).addView((View)localObject11, (ViewGroup.LayoutParams)localObject12);
      localObject12 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject12).setId(2131370687);
      localObject13 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject13).addRule(1, 2131363516);
      ((RelativeLayout.LayoutParams)localObject13).addRule(8, 2131363516);
      ((RelativeLayout.LayoutParams)localObject13).leftMargin = AIOUtils.dp2px(10.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout)localObject2).addView((View)localObject12, (ViewGroup.LayoutParams)localObject13);
      localObject13 = new TextView(this.jdField_b_of_type_AndroidContentContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      ((TextView)localObject13).setTextSize(12.0F);
      ((TextView)localObject13).setTextColor(-1);
      localLayoutParams.topMargin = AIOUtils.dp2px(8.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((TextView)localObject13).setGravity(17);
      localLayoutParams.addRule(3, 2131370774);
    }
    for (;;)
    {
      try
      {
        ((TextView)localObject13).setBackgroundDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130844727));
        ((TextView)localObject13).setPadding(AIOUtils.dp2px(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
        paramafqr.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramafqr.addView((View)localObject13, localLayoutParams);
        ((ImageView)localObject12).setOnClickListener(this);
        localObject2 = new ProgressBar(this.jdField_b_of_type_AndroidContentContext, null, 0);
        ((ProgressBar)localObject2).setId(2131364549);
      }
      catch (Exception localException2)
      {
        try
        {
          ((ProgressBar)localObject2).setIndeterminateDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839466));
          int i = AIOUtils.dp2px(16.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
          localObject3 = new FrameLayout.LayoutParams(i, i);
          ((FrameLayout.LayoutParams)localObject3).gravity = 17;
          ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          localahbj.jdField_e_of_type_AndroidWidgetImageView = paramaftk;
          localahbj.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject4);
          localahbj.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject5);
          localahbj.jdField_c_of_type_AndroidWidgetImageView = paramView;
          localahbj.d = ((ImageView)localObject10);
          localahbj.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView = ((DuiButtonImageView)localObject11);
          localahbj.f = ((ImageView)localObject12);
          localahbj.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localObject1);
          localahbj.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject2);
          localahbj.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject13);
          localahbj.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)localObject6);
          localahbj.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = localPttAudioPlayView;
          localahbj.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject8);
          localahbj.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject9);
          localahbj.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
          localahbj.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView = localTriangleView;
          localahbj.g = ((ImageView)localObject7);
          if (!c(paramChatMessage)) {
            paramBaseChatItemLayout.playProgress = 0.0F;
          }
          a(localahbj, paramChatMessage.uniseq);
          localahbj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          localahbj.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramBaseChatItemLayout.playProgress);
          if ((AppSetting.c) && (a(paramChatMessage, localahbj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) && (localahbj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView != null)) {
            localahbj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131705941));
          }
          new QueryTask(new ahbd(this, localahbj), new ahbe(this, localahbj, paramBaseChatItemLayout, paramChatMessage, l)).a(paramBaseChatItemLayout.mMarkFaceMessage);
          return paramafqr;
          localException2 = localException2;
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException2);
        }
        catch (Exception localException1)
        {
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException1);
          continue;
        }
      }
      if ((localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) && (localahbj.jdField_b_of_type_AndroidWidgetImageView != null) && ((localahbj.jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof AnimationDrawable))) {
        localahbj.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847140);
      }
      paramafqr = paramView;
      if (AppSetting.c)
      {
        localahbj.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        paramafqr = paramView;
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (!bhfj.a(paramChatMessage.issend)) {
        break label104;
      }
      localStringBuilder.append("发出表情");
    }
    for (;;)
    {
      paramChatMessage = (MessageForMarketFace)paramChatMessage;
      if (paramChatMessage.mMarkFaceMessage != null)
      {
        paramChatMessage = ((awyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramChatMessage.mMarkFaceMessage);
        if (paramChatMessage != null)
        {
          paramChatMessage = paramChatMessage.emoticon;
          if ((paramChatMessage != null) && (paramChatMessage.name != null)) {
            localStringBuilder.append(paramChatMessage.name);
          }
        }
      }
      return localStringBuilder.toString();
      label104:
      localStringBuilder.append("发来表情");
    }
  }
  
  public void a()
  {
    asig.a().b(this.jdField_a_of_type_Asiu);
    asig.a().b(this.jdField_a_of_type_Ahbi);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((ahbj)localIterator.next()).a();
    }
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon == null))
    {
      QLog.e("MarketFaceItemBuilder", 1, "onMenuItemClicked emoticon is null");
      return;
    }
    if ((paramInt == 2131365475) || (paramInt == 2131362198) || (paramInt == 2131367230) || (paramInt == 2131366945) || (paramInt == 2131371640))
    {
      a(paramInt, paramChatMessage);
      return;
    }
    if (paramInt == 2131371684)
    {
      super.d(paramChatMessage);
      return;
    }
    if (paramInt == 2131371641)
    {
      super.a(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    ((awyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, new ahbc(this, paramInt, paramChatMessage));
  }
  
  void a(ahbj paramahbj, URLDrawable paramURLDrawable)
  {
    a(paramahbj, paramURLDrawable, "");
  }
  
  void a(ahbj paramahbj, URLDrawable paramURLDrawable, String paramString)
  {
    paramahbj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
    paramahbj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramahbj.f.setVisibility(8);
    paramahbj.jdField_b_of_type_Boolean = false;
    int i = paramURLDrawable.getStatus();
    if (paramURLDrawable.getHeader("2g_use_gif") != null) {
      i = 1;
    }
    for (;;)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString))
      {
        str = paramString;
        if ((paramURLDrawable.getStateTag() instanceof Bundle)) {
          str = ((Bundle)paramURLDrawable.getStateTag()).getString("display_type");
        }
      }
      if ("aio_preview".equals(str)) {
        if (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) {
          if (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()) {
            paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          }
        }
      }
      while (!"big_sound".equals(str))
      {
        do
        {
          return;
          paramahbj.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847140);
          paramahbj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        } while ((i != 1) || (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.imageType != 3));
        paramahbj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838050);
        paramahbj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramahbj.jdField_b_of_type_Boolean = true;
        return;
      }
      if (c(paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
      {
        if (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType())
        {
          paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          return;
        }
        paramahbj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramURLDrawable = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772266);
        paramahbj.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
        paramURLDrawable.start();
        return;
      }
      if (paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType())
      {
        paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
        paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
        return;
      }
      paramahbj.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847140);
      paramahbj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
  }
  
  public void a(View paramView)
  {
    paramView = (ahbj)AIOUtils.getHolder(paramView);
    String str1;
    String str2;
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSendFromLocal())
    {
      str1 = this.jdField_b_of_type_AndroidContentContext.getString(2131689976);
      str2 = this.jdField_b_of_type_AndroidContentContext.getString(2131689977);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 41) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)) {
        a((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo);
      }
    }
    do
    {
      return;
      bhdj.a(this.jdField_b_of_type_AndroidContentContext, 230, str1, str2, new ahbh(this, paramView), new ahay(this)).show();
      return;
      paramView = paramView.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
    } while (!(paramView instanceof URLDrawable));
    ((URLDrawable)paramView).restartDownload();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, ScreenUtil.dip2px(10.0F), 0);
  }
  
  protected void a(bhjq parambhjq)
  {
    if ((jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon == null)) {}
    label135:
    for (;;)
    {
      return;
      if (jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType == 0) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (!EmoticonUtils.isShowRelatedEmoInAio(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType))) {
          break label135;
        }
        aqye localaqye = aqyd.a();
        if ((localaqye == null) || (!localaqye.a())) {
          break;
        }
        parambhjq.a(2131371640, this.jdField_b_of_type_AndroidContentContext.getString(2131718023), 2130838999);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "0X800B114", "0X800B114", EmoticonUtils.getRelatedEmotionReportFromType(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, "", "", "", "");
        return;
      }
    }
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, String paramString, int paramInt)
  {
    bisl localbisl = a();
    if (localbisl != null)
    {
      localbisl.a(this.jdField_b_of_type_AndroidContentContext.getString(2131691881));
      localbisl.show();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect", 0);
    if ((jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)) {
      EmoticonUtils.reportFavAddEmotionEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.eId);
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", paramString, paramInt + "", "");
    QQAppInterface localQQAppInterface;
    if ((jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()))
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
      if (jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon == null) {
        break label268;
      }
    }
    label268:
    for (paramString = jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;; paramString = "")
    {
      awyr.a(localQQAppInterface, "0X800A939", paramInt, paramString);
      if ((paramEmoticonPackage == null) || (paramEmoticonPackage.name == null) || ((paramEmoticonPackage.mobileFeetype == 0) && (paramEmoticonPackage.downloadCount == 0))) {
        break label299;
      }
      paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
      int i = (int)(System.currentTimeMillis() / 1000L);
      if ((i - paramInt <= 86400) && (i >= paramInt)) {
        break;
      }
      a(6);
      return;
    }
    a(6, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localbisl);
    return;
    label299:
    a(6);
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, String paramString, int paramInt1, int paramInt2)
  {
    bisl localbisl = a();
    if (paramInt2 == 2131367230)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "aio_trans_bq", 0, 0, "4", paramString, paramInt1 + "", "");
      if ((2 == jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) && (!this.jdField_a_of_type_Asih.c()))
      {
        ChatActivityUtils.a(this.jdField_b_of_type_AndroidContentContext, 2131689975, 0);
        return;
      }
      jdField_c_of_type_Int = 1;
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_button_forward_aio", 0);
      paramString = this.jdField_b_of_type_AndroidContentContext.getString(2131691884);
    }
    for (paramInt1 = 7;; paramInt1 = 107)
    {
      if (localbisl != null)
      {
        localbisl.a(paramString);
        localbisl.show();
      }
      if (paramEmoticonPackage != null) {
        break;
      }
      a(paramInt1);
      return;
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006449", "0X8006449", 0, 0, "4", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) && (((bgkf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, true).jdField_a_of_type_Boolean))
      {
        ChatActivityUtils.a(this.jdField_b_of_type_AndroidContentContext, 2131697134, 0);
        return;
      }
      paramString = this.jdField_b_of_type_AndroidContentContext.getString(2131691883);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ep_mall", "Clk_button_follow_aio", 0, 0, "", jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "");
    }
    a(paramInt1, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localbisl);
  }
  
  protected void a(MessageForMarketFace paramMessageForMarketFace, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramMessageForMarketFace == null) || (paramPicEmoticonInfo == null) || (paramPicEmoticonInfo.emoticon == null) || (paramPicEmoticonInfo.emoticon.epId == null)) {
      return;
    }
    bkzi localbkzi = (bkzi)bkzz.a(this.jdField_b_of_type_AndroidContentContext, null);
    localbkzi.a(this.jdField_b_of_type_AndroidContentContext.getString(2131691879));
    localbkzi.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131691878), 1);
    localbkzi.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131691880), 1);
    localbkzi.c(2131690697);
    localbkzi.a(new ahaz(this, paramPicEmoticonInfo, localbkzi, paramMessageForMarketFace));
    localbkzi.show();
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if ((paramView != null) && (paramFloat > 0.0F))
    {
      paramXListView = (ahbj)AIOUtils.getHolder(paramView);
      if ((paramXListView != null) && (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) && (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()) && (c(paramChatMessage)))
      {
        QLog.i("MarketFaceItemBuilder", 2, "AudioPlayer onPlayProgress progress_ratio = " + paramFloat);
        paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramFloat);
        if ((paramChatMessage instanceof MessageForMarketFace)) {
          ((MessageForMarketFace)paramChatMessage).playProgress = paramFloat;
        }
      }
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramXListView = (ahbj)AIOUtils.getHolder(paramView);
      if (!paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()) {
        break label66;
      }
      paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
        paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
      }
    }
    for (;;)
    {
      paramView = paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getLoadingDrawable("fromAIO", false);
      paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      return;
      label66:
      paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847140);
    }
  }
  
  public boolean a(afqr paramafqr)
  {
    return paramafqr instanceof ahbj;
  }
  
  public boolean a(ahbj paramahbj)
  {
    return paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (ahbj)AIOUtils.getHolder(paramView);
    if ((paramXListView == null) || (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon == null)) {
      return false;
    }
    if (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound())
    {
      paramView = EmoticonUtils.emoticonSoundPath.replace("[epId]", paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId).replace("[eId]", paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.eId);
      if (!FileUtils.fileExistsAndNotEmpty(paramView))
      {
        if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramChatMessage.uniseq))) {
          return false;
        }
        this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramChatMessage.uniseq));
        a(paramXListView, paramChatMessage.uniseq);
        ThreadManager.getFileThreadHandler().post(new MarketFaceItemBuilder.8(this, paramXListView, paramChatMessage));
        return false;
      }
      if (paramAudioPlayerBase.a(paramView))
      {
        paramView = paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getLoadingDrawable("fromAIO", true);
        paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        PicEmoticonInfo.startSoundDrawablePlay(paramView);
        if (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()) {
          if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
            paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          }
        }
        for (;;)
        {
          return true;
          paramView = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772266);
          paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
          paramView.start();
        }
      }
    }
    return false;
  }
  
  public bhjs[] a(View paramView)
  {
    paramView = (ahbj)AIOUtils.getHolder(paramView);
    bhjq localbhjq = new bhjq();
    jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (ApolloUtil.a(jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
      return localbhjq.a();
    }
    if ((jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMarketFace))
    {
      MessageForMarketFace localMessageForMarketFace = (MessageForMarketFace)jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localMessageForMarketFace.mMarkFaceMessage == null) || (localMessageForMarketFace.mMarkFaceMessage.stickerInfo == null)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 1)
        {
          jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
          if (AIOUtils.getAIOMsgMenuDpcConfig(1) == 1) {
            localbhjq.a(2131362198, this.jdField_b_of_type_AndroidContentContext.getString(2131693145), 2130838989);
          }
          a(localbhjq);
          localbhjq.a(2131367230, this.jdField_b_of_type_AndroidContentContext.getString(2131692550), 2130838991);
          a(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbhjq);
          if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 2) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 4)) {
            localbhjq.a(2131366945, this.jdField_b_of_type_AndroidContentContext.getString(2131693152), 2130838967);
          }
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Ap_show_forward", 0);
        }
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
          a(localbhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        a(localbhjq, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        super.a(localbhjq, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        if (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 1) {
          b(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbhjq);
        }
        super.c(localbhjq, this.jdField_b_of_type_AndroidContentContext);
        super.e(localbhjq, this.jdField_b_of_type_AndroidContentContext);
      }
      for (;;)
      {
        return localbhjq.a();
        jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
        admh.a(localbhjq, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      }
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "[Doutu] Dui Button Clicked.");
    }
    Object localObject = ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment();
    if (localObject != null)
    {
      localObject = ((ChatFragment)localObject).a();
      if (localObject != null)
      {
        ((BaseChatPie)localObject).getUIHandler().obtainMessage(79, null).sendToTarget();
        arzt.b();
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("MarketFaceItemBuilder", 2, "[Doutu] curPie is null.");
      return;
    }
    QLog.d("MarketFaceItemBuilder", 2, "[Doutu] chatFragment is null.");
  }
  
  public void e(View paramView)
  {
    AIOUtils.isUserOperatedInAIO = true;
    if (super.a()) {
      return;
    }
    if (paramView.getId() == 2131363516)
    {
      j(paramView);
      return;
    }
    if (paramView.getId() == 2131381286) {
      g(paramView);
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      if ((paramView.getId() == 2131371925) || (paramView.getId() == 2131371926)) {
        i(paramView);
      } else if ((paramView.getId() == 2131367047) || (paramView.getId() == 2131367046)) {
        f(paramView);
      } else if (paramView.getId() == 2131365911) {
        e();
      } else if (paramView.getId() == 2131370687) {
        h(paramView);
      }
    }
  }
  
  protected void f(View paramView)
  {
    paramView = (ahbj)AIOUtils.getHolder(paramView);
    bisl localbisl = a();
    if (localbisl != null)
    {
      localbisl.a(this.jdField_b_of_type_AndroidContentContext.getString(2131691883));
      localbisl.show();
    }
    ((awyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, new ahax(this, paramView, localbisl));
  }
  
  protected void g(View paramView)
  {
    paramView = (ahbj)AIOUtils.getHolder(paramView);
    if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()))
    {
      if (c(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694935, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      return;
    }
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
  
  protected void h(ChatMessage paramChatMessage)
  {
    Object localObject = ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment();
    if (localObject != null)
    {
      localObject = ((ChatFragment)localObject).a();
      if (localObject != null) {
        ((aggg)((BaseChatPie)localObject).getHelper(72)).a(paramChatMessage, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getLoadingDrawable("fromAIO", false));
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("MarketFaceItemBuilder", 2, "[Related_Emotion] curPie is null.");
      return;
    }
    QLog.d("MarketFaceItemBuilder", 2, "[Related_Emotion] chatFragment is null.");
  }
  
  public void onClick(View paramView)
  {
    e(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahaw
 * JD-Core Version:    0.7.0.1
 */