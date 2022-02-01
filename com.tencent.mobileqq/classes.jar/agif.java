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
import com.tencent.mobileqq.app.QQAppInterface;
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

public class agif
  extends BaseBubbleBuilder
  implements afbz
{
  public static ChatMessage a;
  public static PicEmoticonInfo a;
  public static int c;
  static long jdField_c_of_type_Long;
  agir jdField_a_of_type_Agir = new agir();
  public areb a;
  areo jdField_a_of_type_Areo = new agip(this);
  public List<agis> a;
  public Set<Long> a;
  public Context b;
  Set<agis> b;
  Set<Long> jdField_c_of_type_JavaUtilSet = new ArraySet();
  public int d;
  private long d;
  public int e;
  public boolean f = false;
  
  static
  {
    jdField_c_of_type_Int = 1;
  }
  
  public agif(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_d_of_type_Int = 320;
    this.jdField_e_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Areb = ((areb)paramQQAppInterface.getManager(43));
    if ((this.jdField_b_of_type_AndroidContentContext instanceof SplashActivity)) {
      this.f = true;
    }
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, Handler paramHandler)
  {
    boolean bool = true;
    arba localarba = (arba)paramQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("MarketFaceItemBuilder", 2, "Call getEmoticonDataList from addEmotionToFavorite.");
    }
    List localList = localarba.a();
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
          if (localarba.a(localCustomEmotionData, j))
          {
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramHandler != null) {
              paramHandler.post(new MarketFaceItemBuilder.15(paramContext));
            }
            avsq.c("0", 1);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
            }
            return 0;
          }
          if (paramHandler != null) {
            paramHandler.post(new MarketFaceItemBuilder.16(paramContext));
          }
          avsq.c("2003", 1);
          return 0;
        }
        n = i;
        if (i < localCustomEmotionData.emoId) {
          n = localCustomEmotionData.emoId;
        }
        j += 1;
        m = k;
      }
      if (m >= aray.a) {
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
      paramEmoticon = ((avsq)paramQQAppInterface.getManager(14)).a(paramEmoticon.epId);
      if (paramEmoticon != null) {
        if (paramEmoticon.isAPNG != 2) {
          break label425;
        }
      }
      for (;;)
      {
        paramHandler.isAPNG = bool;
        paramEmoticon = (arbb)paramQQAppInterface.getManager(103);
        if (paramEmoticon != null) {
          paramEmoticon.b(paramHandler, new araj(paramQQAppInterface, paramContext, paramHandler, null, 0));
        }
        if (jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
          a(paramQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect_suc", 0);
        }
        return j;
        label425:
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
      i = 2131690916;
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
      paramInt = 2131690917;
      paramString2 = amtj.a(2131705592);
      continue;
      paramString2 = amtj.a(2131705587);
      paramInt = i;
      continue;
      paramString2 = amtj.a(2131705584);
      paramInt = i;
      continue;
      paramString2 = amtj.a(2131705594);
      paramInt = i;
    }
  }
  
  private bhht a()
  {
    if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().mAuthEmoticonDialog == null) {
        ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().mAuthEmoticonDialog = new bhht(this.jdField_b_of_type_AndroidContentContext);
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
    this.jdField_a_of_type_Agir.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a());
    area.a().a(this.jdField_a_of_type_Agir);
    this.jdField_a_of_type_Areb.a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, areb.jdField_c_of_type_Int);
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
            atky.a((BaseActivity)paramContext, paramEmoticon, 21, 100500, "biz_src_jc_gif");
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
      bcef.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_follow_send_aio", 0, 0, "", paramEmoticon.epId, "", "");
      PicEmoticonInfo.send(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, null);
      return;
      if (paramInt2 < 0)
      {
        localHandler.post(new MarketFaceItemBuilder.13(paramContext, paramString));
        if (6 == paramInt1 % 1000) {
          avsq.c("2001", 1);
        }
        QLog.i("MarketFaceItemBuilder", 1, "opType: " + paramInt1 + ",result:" + paramInt2);
        return;
      }
      localHandler.post(new MarketFaceItemBuilder.14(paramInt1, paramContext, paramQQAppInterface, paramEmoticon, paramString));
    } while (6 != paramInt1 % 1000);
    avsq.c("2002", 1);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, PicEmoticonInfo paramPicEmoticonInfo, SessionInfo paramSessionInfo, bhht parambhht)
  {
    a(paramInt, paramContext, paramQQAppInterface, paramEmoticonPackage, paramPicEmoticonInfo, paramSessionInfo, parambhht, false);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, PicEmoticonInfo paramPicEmoticonInfo, SessionInfo paramSessionInfo, bhht parambhht, boolean paramBoolean)
  {
    if (paramPicEmoticonInfo == null) {
      return;
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.mobileFeetype == 1))
    {
      if ((parambhht != null) && (parambhht.isShowing())) {
        parambhht.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramPicEmoticonInfo.emoticon, 0, null, paramSessionInfo, paramBoolean);
      return;
    }
    if ((!NetworkUtil.isNetworkAvailable(paramContext)) || (paramInt > 1000))
    {
      if ((parambhht != null) && (parambhht.isShowing())) {
        parambhht.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramPicEmoticonInfo.emoticon, -404, amtj.a(2131705591), paramSessionInfo, paramBoolean);
      return;
    }
    ((amrg)paramQQAppInterface.getBusinessHandler(12)).a(paramInt, Integer.valueOf(paramPicEmoticonInfo.emoticon.epId).intValue(), paramPicEmoticonInfo.emoticon.eId);
  }
  
  private void a(agis paramagis)
  {
    EmoticonPackage localEmoticonPackage;
    if (!this.jdField_a_of_type_Areb.a(paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, Boolean.valueOf(false)))
    {
      area.a().a(this.jdField_a_of_type_Areo);
      localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.name;
      localEmoticonPackage.epId = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
      localEmoticonPackage.jobType = 3;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      if (paramagis.jdField_e_of_type_Int != -1) {
        break label222;
      }
    }
    label222:
    for (localEmoticonPackage.rscType = avlc.a(paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.magicValue);; localEmoticonPackage.rscType = paramagis.jdField_e_of_type_Int)
    {
      ((avsq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon);
      paramagis.jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = true;
      this.jdField_a_of_type_JavaUtilList.add(paramagis);
      paramagis.f.setVisibility(8);
      paramagis.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_Areb.a(localEmoticonPackage, false);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void a(agis paramagis, int paramInt, MessageForMarketFace paramMessageForMarketFace, ChatMessage paramChatMessage, long paramLong)
  {
    paramagis.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    if (paramMessageForMarketFace.mMarkFaceMessage != null) {
      a(paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, paramInt, paramMessageForMarketFace.mMarkFaceMessage.copywritingContent);
    }
    agjt.e();
    long l = paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    paramagis.jdField_a_of_type_Long = paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    if (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null)
    {
      paramagis.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130838035);
      l = System.currentTimeMillis();
      if ((QLog.isColorLevel()) && (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)) {
        QLog.d("MarketFaceItemBuilder", 1, "epId = " + paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId + ":view time = " + (l - paramLong));
      }
      return;
    }
    paramagis.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(amtj.a(2131705593) + paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.name);
    String str;
    if (2 == paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType)
    {
      avkv localavkv = (avkv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(83);
      boolean bool = false;
      if (paramagis.jdField_b_of_type_Int == paramagis.jdField_c_of_type_Int - 1) {
        bool = localavkv.a(paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      str = "";
      if (paramMessageForMarketFace.mMarkFaceMessage != null) {
        if ((paramMessageForMarketFace.mMarkFaceMessage.mobileparam != null) && (paramMessageForMarketFace.mMarkFaceMessage.mobileparam.length > 0))
        {
          paramMessageForMarketFace = new String(paramMessageForMarketFace.mMarkFaceMessage.mobileparam);
          label304:
          localavkv.a(paramMessageForMarketFace, paramagis, l, bool, true, new agio(this, paramChatMessage, paramagis));
          paramagis.d.setVisibility(8);
          paramagis.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramagis.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
          paramagis.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramagis.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
          paramagis.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramagis.f.setVisibility(8);
          c(paramagis);
        }
      }
    }
    for (;;)
    {
      if (((2 == paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) || (4 == paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType)) && (paramagis.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView != null))
      {
        paramagis.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
        paramagis.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      }
      if (!this.f) {
        break;
      }
      d(paramagis);
      break;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage mobileparam is empty");
      paramMessageForMarketFace = str;
      break label304;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage is null");
      paramMessageForMarketFace = str;
      break label304;
      if (4 == paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType)
      {
        if (!paramChatMessage.isSend()) {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "mbjieshou", 0, 0, paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "", "");
        }
        a(paramChatMessage, paramagis);
        b(paramagis);
      }
      else
      {
        a(paramChatMessage, paramagis);
      }
    }
  }
  
  private void a(agis paramagis, long paramLong)
  {
    Animatable localAnimatable = (Animatable)paramagis.g.getDrawable();
    if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramLong)))
    {
      if (!localAnimatable.isRunning()) {
        localAnimatable.start();
      }
      paramagis.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(4);
      paramagis.g.setVisibility(0);
      return;
    }
    if (localAnimatable.isRunning()) {
      localAnimatable.stop();
    }
    paramagis.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
    paramagis.g.setVisibility(4);
  }
  
  private void a(agis paramagis, Rect paramRect)
  {
    AIOEmotionFragment.a(this.jdField_b_of_type_AndroidContentContext, paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramRect);
  }
  
  private void a(agis paramagis, URLDrawable paramURLDrawable, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramURLDrawable != null) {
      switch (paramURLDrawable.getStatus())
      {
      default: 
        paramagis.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
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
          if (!avmr.a()) {
            paramagis.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          }
        } while ((EmoticonUtils.isWifiOrG3OrG4()) && (2 == paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) && (!this.jdField_a_of_type_Areb.f(paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)) && (!EmoticonUtils.needDisableAutoReceiveMagicFace()));
        f1 = this.jdField_a_of_type_Areb.a(paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
      } while ((f1 >= 0.0F) && (1.0F != f1));
      paramagis.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramBaseChatItemLayout.setProgressVisable(false);
      return;
      paramagis.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramBaseChatItemLayout.setProgressVisable(false);
    } while (!AppSetting.c);
    paramagis.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(amtj.a(2131705588));
  }
  
  private void a(agis paramagis, String paramString)
  {
    if ((paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 0) && (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 2) && (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 4))
    {
      paramagis.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if (!"big_sound".equals(paramString)) {
        break label181;
      }
      if ((paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.isSound))
      {
        if (!c(paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
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
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694732, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
            return;
          }
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
          return;
        } while (!"aio_preview".equals(paramString));
        paramString = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getLoadingDrawable("fromAIO", true);
      } while (paramString == null);
      paramagis.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      paramagis.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      a(paramagis, paramString);
    } while (!paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound());
    label181:
    jdField_c_of_type_Long = paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    bcef.b(paramQQAppInterface, "CliOper", "", "", paramString2, paramString3, paramInt, 0, "", "", "", "");
  }
  
  private void a(ChatMessage paramChatMessage, agis paramagis)
  {
    a(paramChatMessage, paramagis, "");
  }
  
  private void a(ChatMessage paramChatMessage, agis paramagis, String paramString)
  {
    int i = 0;
    if ((paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) && (!c(paramChatMessage))) {}
    for (boolean bool = false;; bool = true)
    {
      URLDrawable localURLDrawable = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getLoadingDrawable("fromAIO", bool);
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
              localObject2 = paramagis.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
              if ((localObject2 != null) && (((EmoticonPackage)localObject2).status == 2))
              {
                URLDrawable.removeMemoryCacheByUrl(localURLDrawable.getURL().toString());
                paramString = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getLoadingDrawable("fromAIO", bool);
              }
            }
          }
        }
      }
      for (;;)
      {
        b(paramagis, paramString);
        paramagis.d.setVisibility(8);
        paramagis.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        paramagis.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
        c(paramChatMessage, paramagis);
        b(paramChatMessage, paramagis);
        if (paramString != null) {
          a(paramagis, paramString, (String)localObject1);
        }
        c(paramagis);
        return;
        if (!paramString.equals("")) {
          i = 1;
        }
        localObject2 = localObject1;
        if (i != 0)
        {
          URLDrawable.removeMemoryCacheByUrl(localURLDrawable.getURL().toString());
          paramString = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getLoadingDrawable("fromAIO", bool, true, paramagis);
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
        bcef.b(paramString, "CliOper", "", "", "ep_mall", "0X8007187", 0, 0, paramPicEmoticonInfo, "", "", "");
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
      bfur.a(paramContext, 230, paramString1, paramString2, 2131690620, 2131691484, new agij(paramEmoticon, paramContext, paramQQAppInterface, paramInt), new agik()).show();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EmosmDetailActivity.showCustomMarketFaceTips", 2, paramContext.getMessage());
    }
  }
  
  private void b(agis paramagis)
  {
    if ((4 != paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) || (((MessageForMarketFace)paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Areb.a(paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, true, true)) {
        break;
      }
      if (!EmoticonUtils.isWifiOrG3OrG4())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone: H5MagicSource isnot Intact , and network isnot 2 3 4G or wifi;epId = " + paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
        }
        paramagis.f.setVisibility(8);
        return;
      }
    } while (-1.0F != this.jdField_a_of_type_Areb.a(paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId));
    area.a().a(this.jdField_a_of_type_Areo);
    EmoticonPackage localEmoticonPackage = new EmoticonPackage();
    localEmoticonPackage.name = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.name;
    localEmoticonPackage.epId = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
    localEmoticonPackage.jobType = 5;
    localEmoticonPackage.type = 1;
    localEmoticonPackage.isMagicFaceDownloading = true;
    ((avsq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon);
    this.jdField_a_of_type_JavaUtilList.add(paramagis);
    paramagis.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
    paramagis.f.setVisibility(8);
    paramagis.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    ((MessageForMarketFace)paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
    this.jdField_a_of_type_Areb.a(localEmoticonPackage, false);
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone,start download epId = " + paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, localEmoticonPackage.epId, "", "", "");
    return;
    if ((this.f) && (this.jdField_a_of_type_Areb.b()))
    {
      if (!this.jdField_b_of_type_Boolean) {
        paramagis.f.setVisibility(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source intacat epId = " + paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
      }
    }
    for (;;)
    {
      paramagis.f.setImageResource(2130838039);
      if ((((MessageForMarketFace)paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage).isSend()) || (!((MessageForMarketFace)paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay) || (!this.jdField_a_of_type_Areb.a()) || (System.currentTimeMillis() - this.jdField_d_of_type_Long <= 3000L) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().hasXPanelContainer())) {
        break;
      }
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      ((MessageForMarketFace)paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      b(paramagis, "1");
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "", "");
      return;
      paramagis.f.setVisibility(8);
    }
  }
  
  private void b(agis paramagis, URLDrawable paramURLDrawable)
  {
    int m = 200;
    int j;
    label50:
    int k;
    int n;
    Object localObject;
    if ((paramURLDrawable != null) && (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)) {
      if (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.width == 0)
      {
        j = 200;
        if (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.height != 0) {
          break label429;
        }
        k = j;
        i = m;
        if (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.extensionWidth != 0)
        {
          k = j;
          i = m;
          if (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.extensionHeight != 0)
          {
            k = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.extensionWidth;
            i = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.extensionHeight;
          }
        }
        j = k;
        if (k != i) {
          j = i;
        }
        n = (j * this.jdField_e_of_type_Int + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
        i = (this.jdField_e_of_type_Int * i + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
        paramagis.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(n, i));
        localObject = paramagis.jdField_a_of_type_AndroidWidgetTextView.getTag();
        if (!(localObject instanceof Integer)) {
          break label530;
        }
      }
    }
    label530:
    for (int i = ((Integer)localObject).intValue();; i = -1)
    {
      if ((paramagis.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (i != -1))
      {
        String str1 = (String)paramagis.jdField_a_of_type_AndroidWidgetTextView.getTag(2131364049);
        String str2 = (String)paramagis.jdField_a_of_type_AndroidWidgetTextView.getTag(2131364048);
        Paint localPaint = new Paint(1);
        localPaint.setTextSize(AIOUtils.dp2px(12.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
        localPaint.setTextAlign(Paint.Align.LEFT);
        int i1 = (int)localPaint.measureText("...");
        if (!TextUtils.isEmpty(str1)) {}
        for (j = (int)localPaint.measureText(amtj.a(2131705589) + str1);; j = (int)localPaint.measureText(amtj.a(2131705585)))
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
          j = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.width;
          break;
          label429:
          m = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.height;
          break label50;
        }
        if (!((String)localObject).equals(""))
        {
          localObject = a(i, (String)localObject + "...", str1);
          paramagis.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
      }
      paramagis.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
      a(paramagis, paramURLDrawable, paramagis.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
      return;
    }
  }
  
  private void b(agis paramagis, URLDrawable paramURLDrawable, String paramString)
  {
    String str = "";
    if ((paramURLDrawable.getStateTag() instanceof Bundle)) {
      str = ((Bundle)paramURLDrawable.getStateTag()).getString("display_type");
    }
    paramURLDrawable.restartDownload();
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "msgOnclickListener| URLDrawable restartDownload status=" + paramURLDrawable.getStatus());
    }
    a(paramagis, paramURLDrawable, str);
    paramagis.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    if ((paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) && ("big_sound".equals(paramString))) {
      jdField_c_of_type_Long = paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    }
  }
  
  private void b(agis paramagis, String paramString)
  {
    ThreadManager.post(new MarketFaceItemBuilder.6(this, paramString, paramagis), 5, null, true);
  }
  
  private void b(ChatMessage paramChatMessage, agis paramagis)
  {
    if ((paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) && (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getWaveformArray() != null)
      {
        paramChatMessage = (RelativeLayout.LayoutParams)paramagis.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
        paramChatMessage.width = AIOUtils.dp2px(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
        paramagis.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getWaveformArray(), paramChatMessage.width, paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getVoiceLength());
        if (Build.VERSION.SDK_INT < 19)
        {
          paramChatMessage = (RelativeLayout.LayoutParams)paramagis.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramagis.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
          paramChatMessage.width = AIOUtils.dp2px(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
          localLayoutParams.width = AIOUtils.dp2px(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
        }
      }
      int i = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getWaveBackgroundColor();
      int j = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getWaveForegroundColor();
      paramChatMessage = new bchc(i, 1, 1, AIOUtils.dp2px(22.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      paramagis.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(paramChatMessage);
      paramagis.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.setDrawColor(i);
      paramagis.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.postInvalidate();
      paramagis.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(j);
      paramagis.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(j);
    }
  }
  
  private void c(agis paramagis)
  {
    paramagis.jdField_a_of_type_Boolean = false;
    if ((2 != paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) || (((MessageForMarketFace)paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null) || (!avmr.a())) {}
    for (;;)
    {
      return;
      Object localObject;
      if (!this.jdField_a_of_type_Areb.f(paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId))
      {
        if (!EmoticonUtils.isWifiOrG3OrG4())
        {
          paramagis.f.setVisibility(8);
          return;
        }
        if ((!EmoticonUtils.needDisableAutoReceiveMagicFace()) && (!this.jdField_a_of_type_Areb.a(paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, Boolean.valueOf(false))) && (-1.0F == this.jdField_a_of_type_Areb.a(paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)))
        {
          area.a().a(this.jdField_a_of_type_Areo);
          localObject = new EmoticonPackage();
          ((EmoticonPackage)localObject).name = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.name;
          ((EmoticonPackage)localObject).epId = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
          ((EmoticonPackage)localObject).jobType = 3;
          ((EmoticonPackage)localObject).rscType = avlc.a(paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.magicValue);
          ((EmoticonPackage)localObject).type = 1;
          ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
          ((avsq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon);
          this.jdField_a_of_type_JavaUtilList.add(paramagis);
          paramagis.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
          paramagis.f.setVisibility(8);
          paramagis.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((MessageForMarketFace)paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          this.jdField_a_of_type_Areb.a((EmoticonPackage)localObject, false);
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongXiazai", 0, 0, paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "", "");
        }
      }
      else
      {
        if (avlc.a(paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.magicValue) == 1) {
          paramagis.f.setVisibility(8);
        }
        while (((MessageForMarketFace)paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay)
        {
          ((MessageForMarketFace)paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          localObject = new Emoticon();
          ((Emoticon)localObject).eId = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.eId;
          ((Emoticon)localObject).epId = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
          ((Emoticon)localObject).magicValue = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.magicValue;
          ((Emoticon)localObject).jobType = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType;
          if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() != null) && (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null) && (avmr.a())) {
            ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().playMaigcface((Emoticon)localObject, 1, ((MessageForMarketFace)paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage).senderuin, false);
          }
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "", "");
          return;
          if (!this.jdField_b_of_type_Boolean)
          {
            paramagis.f.setImageResource(2130838039);
            paramagis.f.setVisibility(0);
          }
        }
      }
    }
  }
  
  private void c(ChatMessage paramChatMessage, agis paramagis)
  {
    if ((paramChatMessage.isFlowMessage) && (a(paramagis)) && (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType == 0)) {
      if (!(this.jdField_b_of_type_AndroidContentContext instanceof MultiForwardActivity))
      {
        if (!paramChatMessage.isSend()) {
          break label64;
        }
        paramagis.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130847022);
        paramagis.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    label64:
    while ((!paramChatMessage.isDui) || (!DuiButtonImageView.jdField_a_of_type_Boolean) || (awhn.a(paramChatMessage)))
    {
      return;
      paramagis.d.setImageResource(2130847022);
      paramagis.d.setVisibility(0);
      return;
    }
    paramagis.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    if ((paramChatMessage.isSend()) || ((a(paramagis)) && (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound())))
    {
      paramagis.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
      paramagis.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      return;
    }
    if ((a(paramagis)) && (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && ((2 == paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) || (4 == paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType)))
    {
      paramagis.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
      paramagis.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      return;
    }
    if (!paramChatMessage.hasPlayedDui) {
      paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramagis.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView);
    }
    while (DuiButtonImageView.jdField_a_of_type_Boolean)
    {
      paramagis.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(this);
      paramagis.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(0);
      return;
      paramagis.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.f();
    }
    paramagis.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(null);
    paramagis.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
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
  
  private void d(agis paramagis)
  {
    if ((paramagis != null) && (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()) && (paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (!this.jdField_c_of_type_JavaUtilSet.contains(Long.valueOf(paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))))
    {
      avsq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AB51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
      this.jdField_c_of_type_JavaUtilSet.add(Long.valueOf(paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
    }
  }
  
  private void h(View paramView)
  {
    paramView = (agis)AIOUtils.getHolder(paramView);
    EmoticonPackage localEmoticonPackage;
    if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && (2 == paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType))
    {
      if (!this.jdField_a_of_type_Areb.a(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, Boolean.valueOf(false)))
      {
        area.a().a(this.jdField_a_of_type_Areo);
        localEmoticonPackage = new EmoticonPackage();
        localEmoticonPackage.name = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.name;
        localEmoticonPackage.epId = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
        localEmoticonPackage.jobType = 3;
        localEmoticonPackage.type = 1;
        localEmoticonPackage.isMagicFaceDownloading = true;
        paramView.jdField_a_of_type_Boolean = false;
        ((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
        ((avsq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon);
        this.jdField_a_of_type_JavaUtilList.add(paramView);
        paramView.f.setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_Areb.a(localEmoticonPackage, false);
        bcef.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongBofang", 0, 0, paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "", "");
      }
    }
    else if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && (4 == paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) && (System.currentTimeMillis() - this.jdField_d_of_type_Long > 3000L) && (this.jdField_a_of_type_Areb.a()))
    {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      if (!this.jdField_a_of_type_Areb.a(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, true, true)) {
        break label474;
      }
      b(paramView, "0");
    }
    for (;;)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbFasong", "MbZhudongBofang", 0, 0, paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "", "");
      return;
      if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (!avmr.a()) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null)) {
        break;
      }
      ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().playMaigcface(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon, 1, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, true);
      break;
      label474:
      area.a().a(this.jdField_a_of_type_Areo);
      localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.name;
      localEmoticonPackage.epId = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
      localEmoticonPackage.jobType = 5;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      paramView.jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      ((avsq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon);
      this.jdField_a_of_type_JavaUtilList.add(paramView);
      paramView.f.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_Areb.a(localEmoticonPackage, false);
    }
  }
  
  private void i(View paramView)
  {
    boolean bool = true;
    Object localObject = (agis)AIOUtils.getHolder(paramView);
    QQAppInterface localQQAppInterface;
    int i;
    if ((((agis)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (((agis)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) && (((agis)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()))
    {
      if (!c(((agis)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
        break label119;
      }
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
      if (((agis)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon == null) {
        break label112;
      }
    }
    label112:
    for (paramView = ((agis)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;; paramView = "")
    {
      avsq.a(localQQAppInterface, "0X800A934", i, paramView);
      return;
    }
    label119:
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694732, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
      return;
    }
    if ((((agis)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMarketFace)) {
      ((MessageForMarketFace)((agis)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage).playProgress = 0.0F;
    }
    ((agis)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
    if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((agis)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage))
    {
      ((agis)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
      if (((agis)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)
      {
        paramView = ((agis)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
        avsq.a(localQQAppInterface, "0X800A933", i, paramView);
      }
    }
    for (;;)
    {
      if (!bool)
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (((agis)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)
        {
          paramView = ((agis)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
          label300:
          avsq.a(localQQAppInterface, "0X800A935", -1, paramView);
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
    agis localagis = (agis)AIOUtils.getHolder(paramView);
    Drawable localDrawable = localagis.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
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
        if ((localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && (localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType == 2) && (avmr.a())) {
          a(localagis);
        }
        if ((((URLDrawable)localDrawable).getStatus() == 1) || ((localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && (localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isAioPreviewExists()))) {
          a(localagis, aagn.a(paramView));
        }
        break;
      }
      do
      {
        return;
        b(localagis, localURLDrawable, str);
        break;
        a(localagis, str);
        break;
      } while ((!(localDrawable instanceof avks)) || (localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon == null) || (!localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isAioPreviewExists()));
      a(localagis, aagn.a(paramView));
      return;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aezf a()
  {
    return new agis();
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    long l = System.currentTimeMillis();
    paramBaseChatItemLayout = (MessageForMarketFace)paramChatMessage;
    agis localagis = (agis)paramaezf;
    this.jdField_b_of_type_JavaUtilSet.add(localagis);
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
      paramaezf = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject2 = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout)localObject2).setId(2131370591);
      paramView = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      paramView.setId(2131366928);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131364441);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131364441);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setOnClickListener(this);
      localObject1 = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).setId(2131363447);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = 8;
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131366928);
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      ((FrameLayout)localObject1).setOnClickListener(this);
      ((FrameLayout)localObject1).setOnTouchListener(paramafce);
      ((FrameLayout)localObject1).setOnLongClickListener(paramafce);
      paramafce = new agit(this, this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).addView(paramafce, -2, -2);
      localObject4 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localObject5 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject5).gravity = 85;
      ((FrameLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject5).setId(2131380934);
      localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(1, 2131363447);
      ((RelativeLayout.LayoutParams)localObject6).addRule(8, 2131363447);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      ((ImageView)localObject5).setOnClickListener(this);
      localObject6 = new BreathAnimationLayout(this.jdField_b_of_type_AndroidContentContext);
      ((BreathAnimationLayout)localObject6).setId(2131371735);
      localPttAudioPlayView = new PttAudioPlayView(this.jdField_b_of_type_AndroidContentContext, 10);
      localPttAudioPlayView.setThemeColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131167031).getDefaultColor());
      localPttAudioPlayView.setId(2131371737);
      localPttAudioPlayView.setPttPauseOrStopDrawable(2130838230);
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
      ((ImageView)localObject7).setImageDrawable((Drawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839443));
      ((ImageView)localObject7).setVisibility(4);
      localObject8 = new PttAudioWaveView(this.jdField_b_of_type_AndroidContentContext);
      ((PttAudioWaveView)localObject8).setShowProgressLine(false);
      ((PttAudioWaveView)localObject8).setMaxTopBottomPadding(4);
      ((PttAudioWaveView)localObject8).setProgressColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131167031).getDefaultColor());
      ((PttAudioWaveView)localObject8).setId(2131371738);
      localObject9 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(1, 2131371737);
      ((RelativeLayout.LayoutParams)localObject9).width = AIOUtils.dp2px(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).height = AIOUtils.dp2px(45.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).leftMargin = ViewUtils.dip2px(9.0F);
      ((RelativeLayout.LayoutParams)localObject9).rightMargin = ViewUtils.dip2px(12.0F);
      ((PttAudioWaveView)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
      ((PttAudioWaveView)localObject8).setCanSupportSlide(false);
      ((PttAudioWaveView)localObject8).setOnClickListener(this);
      localObject9 = new SyncParentPressedRelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      ((RelativeLayout)localObject9).setId(2131371736);
      ((RelativeLayout)localObject9).addView((View)localObject8);
      ((RelativeLayout)localObject9).addView(localPttAudioPlayView);
      ((RelativeLayout)localObject9).addView((View)localObject7);
      localRelativeLayout = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localTriangleView = new TriangleView(this.jdField_b_of_type_AndroidContentContext);
      localObject10 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(9.0F), ViewUtils.dip2px(5.0F));
      ((RelativeLayout.LayoutParams)localObject10).leftMargin = ViewUtils.dip2px(2.0F);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14);
      ((RelativeLayout.LayoutParams)localObject10).addRule(10);
      localTriangleView.setId(2131372765);
      localTriangleView.setRotation(180.0F);
      localTriangleView.setTranslationY(ViewUtils.dip2px(1.0F));
      localTriangleView.setLayoutParams((ViewGroup.LayoutParams)localObject10);
      localRelativeLayout.addView(localTriangleView);
      localObject10 = new RelativeLayout.LayoutParams(-2, ViewUtils.dip2px(29.0F));
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131372765);
      localRelativeLayout.addView((View)localObject9, (ViewGroup.LayoutParams)localObject10);
      ((BreathAnimationLayout)localObject6).addView(localRelativeLayout);
      localObject10 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14, 2131363447);
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131363447);
      ((RelativeLayout.LayoutParams)localObject10).bottomMargin = ViewUtils.dip2px(17.0F);
      ((RelativeLayout)localObject2).addView((View)localObject6, (ViewGroup.LayoutParams)localObject10);
      localObject10 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject10).setId(2131366929);
      localObject11 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject11).addRule(1, 2131363447);
      ((RelativeLayout.LayoutParams)localObject11).addRule(15, 2131363447);
      ((RelativeLayout.LayoutParams)localObject11).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject10, (ViewGroup.LayoutParams)localObject11);
      ((ImageView)localObject10).setOnClickListener(this);
      localObject11 = new DuiButtonImageView(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      ((DuiButtonImageView)localObject11).setId(2131365813);
      localObject12 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject12).addRule(1, 2131363447);
      ((RelativeLayout.LayoutParams)localObject12).addRule(8, 2131363447);
      ((RelativeLayout.LayoutParams)localObject12).setMargins(0, 0, 0, -AIOUtils.dp2px(6.5F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout)localObject2).addView((View)localObject11, (ViewGroup.LayoutParams)localObject12);
      localObject12 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject12).setId(2131370504);
      localObject13 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject13).addRule(1, 2131363447);
      ((RelativeLayout.LayoutParams)localObject13).addRule(8, 2131363447);
      ((RelativeLayout.LayoutParams)localObject13).leftMargin = AIOUtils.dp2px(10.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout)localObject2).addView((View)localObject12, (ViewGroup.LayoutParams)localObject13);
      localObject13 = new TextView(this.jdField_b_of_type_AndroidContentContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      ((TextView)localObject13).setTextSize(12.0F);
      ((TextView)localObject13).setTextColor(-1);
      localLayoutParams.topMargin = AIOUtils.dp2px(8.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((TextView)localObject13).setGravity(17);
      localLayoutParams.addRule(3, 2131370591);
    }
    for (;;)
    {
      try
      {
        ((TextView)localObject13).setBackgroundDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130844661));
        ((TextView)localObject13).setPadding(AIOUtils.dp2px(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
        paramaezf.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramaezf.addView((View)localObject13, localLayoutParams);
        ((ImageView)localObject12).setOnClickListener(this);
        localObject2 = new ProgressBar(this.jdField_b_of_type_AndroidContentContext, null, 0);
        ((ProgressBar)localObject2).setId(2131364468);
      }
      catch (Exception localException2)
      {
        try
        {
          ((ProgressBar)localObject2).setIndeterminateDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839445));
          int i = AIOUtils.dp2px(16.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
          localObject3 = new FrameLayout.LayoutParams(i, i);
          ((FrameLayout.LayoutParams)localObject3).gravity = 17;
          ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          localagis.jdField_e_of_type_AndroidWidgetImageView = paramafce;
          localagis.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject4);
          localagis.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject5);
          localagis.jdField_c_of_type_AndroidWidgetImageView = paramView;
          localagis.d = ((ImageView)localObject10);
          localagis.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView = ((DuiButtonImageView)localObject11);
          localagis.f = ((ImageView)localObject12);
          localagis.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localObject1);
          localagis.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject2);
          localagis.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject13);
          localagis.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)localObject6);
          localagis.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = localPttAudioPlayView;
          localagis.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject8);
          localagis.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject9);
          localagis.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
          localagis.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView = localTriangleView;
          localagis.g = ((ImageView)localObject7);
          if (!c(paramChatMessage)) {
            paramBaseChatItemLayout.playProgress = 0.0F;
          }
          a(localagis, paramChatMessage.uniseq);
          localagis.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          localagis.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramBaseChatItemLayout.playProgress);
          if ((AppSetting.c) && (a(paramChatMessage, localagis.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) && (localagis.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView != null)) {
            localagis.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(amtj.a(2131705590));
          }
          new QueryTask(new agim(this, localagis), new agin(this, localagis, paramBaseChatItemLayout, paramChatMessage, l)).a(paramBaseChatItemLayout.mMarkFaceMessage);
          return paramaezf;
          localException2 = localException2;
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException2);
        }
        catch (Exception localException1)
        {
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException1);
          continue;
        }
      }
      if ((localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) && (localagis.jdField_b_of_type_AndroidWidgetImageView != null) && ((localagis.jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof AnimationDrawable))) {
        localagis.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847042);
      }
      paramaezf = paramView;
      if (AppSetting.c)
      {
        localagis.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        paramaezf = paramView;
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (!bfwr.a(paramChatMessage.issend)) {
        break label103;
      }
      localStringBuilder.append("发出表情");
    }
    for (;;)
    {
      paramChatMessage = (MessageForMarketFace)paramChatMessage;
      if (paramChatMessage.mMarkFaceMessage != null)
      {
        paramChatMessage = ((avsq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramChatMessage.mMarkFaceMessage);
        if (paramChatMessage != null)
        {
          paramChatMessage = paramChatMessage.emoticon;
          if ((paramChatMessage != null) && (paramChatMessage.name != null)) {
            localStringBuilder.append(paramChatMessage.name);
          }
        }
      }
      return localStringBuilder.toString();
      label103:
      localStringBuilder.append("发来表情");
    }
  }
  
  public void a()
  {
    area.a().b(this.jdField_a_of_type_Areo);
    area.a().b(this.jdField_a_of_type_Agir);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((agis)localIterator.next()).a();
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
    if ((paramInt == 2131365382) || (paramInt == 2131362195) || (paramInt == 2131367111) || (paramInt == 2131366827) || (paramInt == 2131371454))
    {
      a(paramInt, paramChatMessage);
      return;
    }
    if (paramInt == 2131371498)
    {
      super.d(paramChatMessage);
      return;
    }
    if (paramInt == 2131371455)
    {
      super.a(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    ((avsq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, new agil(this, paramInt, paramChatMessage));
  }
  
  void a(agis paramagis, URLDrawable paramURLDrawable)
  {
    a(paramagis, paramURLDrawable, "");
  }
  
  void a(agis paramagis, URLDrawable paramURLDrawable, String paramString)
  {
    paramagis.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramagis.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
    paramagis.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramagis.f.setVisibility(8);
    paramagis.jdField_b_of_type_Boolean = false;
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
        if (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) {
          if (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()) {
            paramagis.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          }
        }
      }
      while (!"big_sound".equals(str))
      {
        do
        {
          return;
          paramagis.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847042);
          paramagis.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        } while ((i != 1) || (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.imageType != 3));
        paramagis.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838036);
        paramagis.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramagis.jdField_b_of_type_Boolean = true;
        return;
      }
      if (c(paramagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
      {
        if (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType())
        {
          paramagis.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          paramagis.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          return;
        }
        paramagis.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramURLDrawable = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772267);
        paramagis.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
        paramURLDrawable.start();
        return;
      }
      if (paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType())
      {
        paramagis.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
        paramagis.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
        return;
      }
      paramagis.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847042);
      paramagis.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
  }
  
  public void a(View paramView)
  {
    paramView = (agis)AIOUtils.getHolder(paramView);
    String str1;
    String str2;
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSendFromLocal())
    {
      str1 = this.jdField_b_of_type_AndroidContentContext.getString(2131689947);
      str2 = this.jdField_b_of_type_AndroidContentContext.getString(2131689948);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 41) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)) {
        a((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo);
      }
    }
    do
    {
      return;
      bfur.a(this.jdField_b_of_type_AndroidContentContext, 230, str1, str2, new agiq(this, paramView), new agih(this)).show();
      return;
      paramView = paramView.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
    } while (!(paramView instanceof URLDrawable));
    ((URLDrawable)paramView).restartDownload();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, ScreenUtil.dip2px(10.0F), 0);
  }
  
  protected void a(bgaz parambgaz)
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
        apvb localapvb = apva.a();
        if ((localapvb == null) || (!localapvb.a())) {
          break;
        }
        parambgaz.a(2131371454, this.jdField_b_of_type_AndroidContentContext.getString(2131717656), 2130838979);
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "0X800B114", "0X800B114", EmoticonUtils.getRelatedEmotionReportFromType(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, "", "", "", "");
        return;
      }
    }
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, String paramString, int paramInt)
  {
    bhht localbhht = a();
    if (localbhht != null)
    {
      localbhht.a(this.jdField_b_of_type_AndroidContentContext.getString(2131691793));
      localbhht.show();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect", 0);
    if ((jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)) {
      EmoticonUtils.reportFavAddEmotionEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.eId);
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", paramString, paramInt + "", "");
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
      avsq.a(localQQAppInterface, "0X800A939", paramInt, paramString);
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
    a(6, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localbhht);
    return;
    label299:
    a(6);
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, String paramString, int paramInt1, int paramInt2)
  {
    bhht localbhht = a();
    if (paramInt2 == 2131367111)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "aio_trans_bq", 0, 0, "4", paramString, paramInt1 + "", "");
      if ((2 == jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) && (!this.jdField_a_of_type_Areb.c()))
      {
        ChatActivityUtils.a(this.jdField_b_of_type_AndroidContentContext, 2131689946, 0);
        return;
      }
      jdField_c_of_type_Int = 1;
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_button_forward_aio", 0);
      paramString = this.jdField_b_of_type_AndroidContentContext.getString(2131691796);
    }
    for (paramInt1 = 7;; paramInt1 = 107)
    {
      if (localbhht != null)
      {
        localbhht.a(paramString);
        localbhht.show();
      }
      if (paramEmoticonPackage != null) {
        break;
      }
      a(paramInt1);
      return;
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006449", "0X8006449", 0, 0, "4", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) && (((bfbz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, true).jdField_a_of_type_Boolean))
      {
        ChatActivityUtils.a(this.jdField_b_of_type_AndroidContentContext, 2131696866, 0);
        return;
      }
      paramString = this.jdField_b_of_type_AndroidContentContext.getString(2131691795);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ep_mall", "Clk_button_follow_aio", 0, 0, "", jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "");
    }
    a(paramInt1, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localbhht);
  }
  
  protected void a(MessageForMarketFace paramMessageForMarketFace, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramMessageForMarketFace == null) || (paramPicEmoticonInfo == null) || (paramPicEmoticonInfo.emoticon == null) || (paramPicEmoticonInfo.emoticon.epId == null)) {
      return;
    }
    bjnw localbjnw = (bjnw)bjon.a(this.jdField_b_of_type_AndroidContentContext, null);
    localbjnw.a(this.jdField_b_of_type_AndroidContentContext.getString(2131691791));
    localbjnw.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131691790), 1);
    localbjnw.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131691792), 1);
    localbjnw.c(2131690620);
    localbjnw.a(new agii(this, paramPicEmoticonInfo, localbjnw, paramMessageForMarketFace));
    localbjnw.show();
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if ((paramView != null) && (paramFloat > 0.0F))
    {
      paramXListView = (agis)AIOUtils.getHolder(paramView);
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
      paramXListView = (agis)AIOUtils.getHolder(paramView);
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
      paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847042);
    }
  }
  
  public boolean a(aezf paramaezf)
  {
    return paramaezf instanceof agis;
  }
  
  public boolean a(agis paramagis)
  {
    return paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (agis)AIOUtils.getHolder(paramView);
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
          paramView = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772267);
          paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
          paramView.start();
        }
      }
    }
    return false;
  }
  
  public bgbb[] a(View paramView)
  {
    paramView = (agis)AIOUtils.getHolder(paramView);
    bgaz localbgaz = new bgaz();
    jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (ApolloUtil.a(jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
      return localbgaz.a();
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
            localbgaz.a(2131362195, this.jdField_b_of_type_AndroidContentContext.getString(2131693009), 2130838969);
          }
          a(localbgaz);
          localbgaz.a(2131367111, this.jdField_b_of_type_AndroidContentContext.getString(2131692448), 2130838971);
          a(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbgaz);
          if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 2) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 4)) {
            localbgaz.a(2131366827, this.jdField_b_of_type_AndroidContentContext.getString(2131693016), 2130838947);
          }
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Ap_show_forward", 0);
        }
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
          a(localbgaz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        a(localbgaz, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        super.a(localbgaz, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        if (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 1) {
          b(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbgaz);
        }
        super.c(localbgaz, this.jdField_b_of_type_AndroidContentContext);
        super.e(localbgaz, this.jdField_b_of_type_AndroidContentContext);
      }
      for (;;)
      {
        return localbgaz.a();
        jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
        acvv.a(localbgaz, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
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
      if (localObject != null) {
        ((BaseChatPie)localObject).getUIHandler().obtainMessage(79, null).sendToTarget();
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
    if (paramView.getId() == 2131363447)
    {
      j(paramView);
      return;
    }
    if (paramView.getId() == 2131380934) {
      g(paramView);
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      if ((paramView.getId() == 2131371737) || (paramView.getId() == 2131371738)) {
        i(paramView);
      } else if ((paramView.getId() == 2131366929) || (paramView.getId() == 2131366928)) {
        f(paramView);
      } else if (paramView.getId() == 2131365813) {
        e();
      } else if (paramView.getId() == 2131370504) {
        h(paramView);
      }
    }
  }
  
  protected void f(View paramView)
  {
    paramView = (agis)AIOUtils.getHolder(paramView);
    bhht localbhht = a();
    if (localbhht != null)
    {
      localbhht.a(this.jdField_b_of_type_AndroidContentContext.getString(2131691795));
      localbhht.show();
    }
    ((avsq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, new agig(this, paramView, localbhht));
  }
  
  protected void g(View paramView)
  {
    paramView = (agis)AIOUtils.getHolder(paramView);
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
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694732, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
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
        ((afpc)((BaseChatPie)localObject).getHelper(72)).a(paramChatMessage, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getLoadingDrawable("fromAIO", false));
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
 * Qualified Name:     agif
 * JD-Core Version:    0.7.0.1
 */