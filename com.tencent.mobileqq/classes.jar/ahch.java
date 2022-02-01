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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.11;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.12;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.13;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.14;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.15;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.5;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7;
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
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.model.QueryTask;
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

public class ahch
  extends BaseBubbleBuilder
  implements afzm
{
  public static asbq a;
  public static ChatMessage a;
  public static int c;
  static long jdField_c_of_type_Long;
  ahct jdField_a_of_type_Ahct = new ahct();
  public arup a;
  arvc jdField_a_of_type_Arvc = new ahcq(this);
  public List<ahcu> a;
  public Set<Long> a;
  public Context b;
  Set<ahcu> b;
  Set<Long> jdField_c_of_type_JavaUtilSet = new ArraySet();
  public int d;
  private long d;
  public int e;
  public boolean f = false;
  
  static
  {
    jdField_c_of_type_Int = 1;
  }
  
  public ahch(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_d_of_type_Int = 320;
    this.jdField_e_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Arup = ((arup)paramQQAppInterface.getManager(43));
    if ((this.jdField_b_of_type_AndroidContentContext instanceof SplashActivity)) {
      this.f = true;
    }
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, Handler paramHandler)
  {
    boolean bool = true;
    arro localarro = (arro)paramQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("MarketFaceItemBuilder", 2, "Call getEmoticonDataList from addEmotionToFavorite.");
    }
    List localList = localarro.a();
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
          if (localarro.a(localCustomEmotionData, j))
          {
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramHandler != null) {
              paramHandler.post(new MarketFaceItemBuilder.14(paramContext));
            }
            awmr.c("0", 1);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
            }
            return 0;
          }
          if (paramHandler != null) {
            paramHandler.post(new MarketFaceItemBuilder.15(paramContext));
          }
          awmr.c("2003", 1);
          return 0;
        }
        n = i;
        if (i < localCustomEmotionData.emoId) {
          n = localCustomEmotionData.emoId;
        }
        j += 1;
        m = k;
      }
      if (m >= arrm.jdField_a_of_type_Int) {
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
      paramEmoticon = ((awmr)paramQQAppInterface.getManager(14)).a(paramEmoticon.epId);
      if (paramEmoticon != null) {
        if (paramEmoticon.isAPNG != 2) {
          break label425;
        }
      }
      for (;;)
      {
        paramHandler.isAPNG = bool;
        paramEmoticon = (arrp)paramQQAppInterface.getManager(103);
        if (paramEmoticon != null) {
          paramEmoticon.b(paramHandler, new arqx(paramQQAppInterface, paramContext, paramHandler, null, 0));
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
      i = 2131690876;
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
      paramInt = 2131690877;
      paramString2 = anni.a(2131705255);
      continue;
      paramString2 = anni.a(2131705250);
      paramInt = i;
      continue;
      paramString2 = anni.a(2131705247);
      paramInt = i;
      continue;
      paramString2 = anni.a(2131705257);
      paramInt = i;
    }
  }
  
  private biau a()
  {
    if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a == null) {
        ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a = new biau(this.jdField_b_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a;
    }
    return null;
  }
  
  private String a()
  {
    try
    {
      i = bgnt.a(this.jdField_b_of_type_AndroidContentContext);
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
    this.jdField_a_of_type_Ahct.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_Asbq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a());
    aruo.a().a(this.jdField_a_of_type_Ahct);
    this.jdField_a_of_type_Arup.a(jdField_a_of_type_Asbq.a.epId, arup.jdField_c_of_type_Int);
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
            aufz.a((BaseActivity)paramContext, paramEmoticon, 21, 100500, "biz_src_jc_gif");
            return;
          }
          catch (Exception paramContext) {}
        } while (!QLog.isColorLevel());
        QLog.e("EmosmDetailActivity.operateMarketFaceFromDownLoad", 2, paramContext.getMessage());
        return;
        if (6 == paramInt1 % 1000)
        {
          ThreadManager.post(new MarketFaceItemBuilder.11(paramContext, paramQQAppInterface, paramEmoticon, localHandler), 5, null, true);
          return;
        }
      } while (107 != paramInt1 % 1000);
      bcst.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_follow_send_aio", 0, 0, "", paramEmoticon.epId, "", "");
      asbq.a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, null);
      return;
      if (paramInt2 < 0)
      {
        localHandler.post(new MarketFaceItemBuilder.12(paramContext, paramString));
        if (6 == paramInt1 % 1000) {
          awmr.c("2001", 1);
        }
        QLog.i("MarketFaceItemBuilder", 1, "opType: " + paramInt1 + ",result:" + paramInt2);
        return;
      }
      localHandler.post(new MarketFaceItemBuilder.13(paramInt1, paramContext, paramQQAppInterface, paramEmoticon, paramString));
    } while (6 != paramInt1 % 1000);
    awmr.c("2002", 1);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, asbq paramasbq, SessionInfo paramSessionInfo, biau parambiau)
  {
    a(paramInt, paramContext, paramQQAppInterface, paramEmoticonPackage, paramasbq, paramSessionInfo, parambiau, false);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, asbq paramasbq, SessionInfo paramSessionInfo, biau parambiau, boolean paramBoolean)
  {
    if (paramasbq == null) {
      return;
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.mobileFeetype == 1))
    {
      if ((parambiau != null) && (parambiau.isShowing())) {
        parambiau.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramasbq.a, 0, null, paramSessionInfo, paramBoolean);
      return;
    }
    if ((!bgnt.g(paramContext)) || (paramInt > 1000))
    {
      if ((parambiau != null) && (parambiau.isShowing())) {
        parambiau.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramasbq.a, -404, anni.a(2131705254), paramSessionInfo, paramBoolean);
      return;
    }
    ((anlb)paramQQAppInterface.a(12)).a(paramInt, Integer.valueOf(paramasbq.a.epId).intValue(), paramasbq.a.eId);
  }
  
  private void a(ahcu paramahcu)
  {
    EmoticonPackage localEmoticonPackage;
    if (!this.jdField_a_of_type_Arup.a(paramahcu.jdField_a_of_type_Asbq.a.epId, Boolean.valueOf(false)))
    {
      aruo.a().a(this.jdField_a_of_type_Arvc);
      localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramahcu.jdField_a_of_type_Asbq.a.name;
      localEmoticonPackage.epId = paramahcu.jdField_a_of_type_Asbq.a.epId;
      localEmoticonPackage.jobType = 3;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      if (paramahcu.jdField_e_of_type_Int != -1) {
        break label222;
      }
    }
    label222:
    for (localEmoticonPackage.rscType = awfd.a(paramahcu.jdField_a_of_type_Asbq.a.magicValue);; localEmoticonPackage.rscType = paramahcu.jdField_e_of_type_Int)
    {
      ((awmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramahcu.jdField_a_of_type_Asbq.a);
      paramahcu.jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)paramahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = true;
      this.jdField_a_of_type_JavaUtilList.add(paramahcu);
      paramahcu.f.setVisibility(8);
      paramahcu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_Arup.a(localEmoticonPackage, false);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void a(ahcu paramahcu, long paramLong)
  {
    Animatable localAnimatable = (Animatable)paramahcu.g.getDrawable();
    if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramLong)))
    {
      if (!localAnimatable.isRunning()) {
        localAnimatable.start();
      }
      paramahcu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(4);
      paramahcu.g.setVisibility(0);
      return;
    }
    if (localAnimatable.isRunning()) {
      localAnimatable.stop();
    }
    paramahcu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
    paramahcu.g.setVisibility(4);
  }
  
  private void a(ahcu paramahcu, Rect paramRect)
  {
    AIOEmotionFragment.a(this.jdField_b_of_type_AndroidContentContext, paramahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramRect);
  }
  
  private void a(ahcu paramahcu, URLDrawable paramURLDrawable, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramURLDrawable != null) {
      switch (paramURLDrawable.getStatus())
      {
      default: 
        paramahcu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
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
          if (!awgs.a()) {
            paramahcu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          }
        } while ((arze.a()) && (2 == paramahcu.jdField_a_of_type_Asbq.a.jobType) && (!this.jdField_a_of_type_Arup.f(paramahcu.jdField_a_of_type_Asbq.a.epId)) && (!arze.c()));
        f1 = this.jdField_a_of_type_Arup.a(paramahcu.jdField_a_of_type_Asbq.a.epId);
      } while ((f1 >= 0.0F) && (1.0F != f1));
      paramahcu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramBaseChatItemLayout.setProgressVisable(false);
      return;
      paramahcu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramBaseChatItemLayout.setProgressVisable(false);
    } while (!AppSetting.c);
    paramahcu.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(anni.a(2131705251));
  }
  
  private void a(ahcu paramahcu, String paramString)
  {
    ThreadManager.post(new MarketFaceItemBuilder.5(this, paramString, paramahcu), 5, null, true);
  }
  
  private void a(asbq paramasbq, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      str2 = a();
      if (paramasbq == null) {}
      for (paramasbq = "";; paramasbq = paramasbq.a.epId)
      {
        VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramasbq, paramString);
        return;
      }
    case 3: 
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramasbq == null) {}
      for (paramasbq = "";; paramasbq = paramasbq.a.epId)
      {
        bcst.b(paramString, "CliOper", "", "", "ep_mall", "0X8007187", 0, 0, paramasbq, "", "", "");
        return;
      }
    }
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    String str2 = a();
    if (paramasbq == null) {}
    for (paramasbq = "";; paramasbq = paramasbq.a.epId)
    {
      VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramasbq, paramString, "1", "", "", "", 0, 0, 0, 0);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    bcst.b(paramQQAppInterface, "CliOper", "", "", paramString2, paramString3, paramInt, 0, "", "", "", "");
  }
  
  private void a(ChatMessage paramChatMessage, ahcu paramahcu)
  {
    a(paramChatMessage, paramahcu, "");
  }
  
  private void a(ChatMessage paramChatMessage, ahcu paramahcu, String paramString)
  {
    int i = 0;
    if ((paramahcu.jdField_a_of_type_Asbq.b()) && (!c(paramChatMessage))) {}
    for (boolean bool = false;; bool = true)
    {
      URLDrawable localURLDrawable = paramahcu.jdField_a_of_type_Asbq.a("fromAIO", bool);
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
              localObject2 = paramahcu.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
              if ((localObject2 != null) && (((EmoticonPackage)localObject2).status == 2))
              {
                URLDrawable.removeMemoryCacheByUrl(localURLDrawable.getURL().toString());
                paramString = paramahcu.jdField_a_of_type_Asbq.a("fromAIO", bool);
              }
            }
          }
        }
      }
      for (;;)
      {
        b(paramahcu, paramString);
        paramahcu.d.setVisibility(8);
        paramahcu.c.setVisibility(8);
        paramahcu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
        c(paramChatMessage, paramahcu);
        b(paramChatMessage, paramahcu);
        if (paramString != null) {
          a(paramahcu, paramString, (String)localObject1);
        }
        c(paramahcu);
        return;
        if (!paramString.equals("")) {
          i = 1;
        }
        localObject2 = localObject1;
        if (i != 0)
        {
          URLDrawable.removeMemoryCacheByUrl(localURLDrawable.getURL().toString());
          paramString = paramahcu.jdField_a_of_type_Asbq.a("fromAIO", bool, true, paramahcu);
        }
        else
        {
          paramString = localURLDrawable;
          localObject1 = localObject2;
        }
      }
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
      bglp.a(paramContext, 230, paramString1, paramString2, 2131690582, 2131691441, new ahck(paramEmoticon, paramContext, paramQQAppInterface, paramInt), new ahcl()).show();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EmosmDetailActivity.showCustomMarketFaceTips", 2, paramContext.getMessage());
    }
  }
  
  private void b(ahcu paramahcu)
  {
    if ((4 != paramahcu.jdField_a_of_type_Asbq.a.jobType) || (((MessageForMarketFace)paramahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Arup.a(paramahcu.jdField_a_of_type_Asbq.a.epId, true, true)) {
        break;
      }
      if (!arze.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone: H5MagicSource isnot Intact , and network isnot 2 3 4G or wifi;epId = " + paramahcu.jdField_a_of_type_Asbq.a.epId);
        }
        paramahcu.f.setVisibility(8);
        return;
      }
    } while (-1.0F != this.jdField_a_of_type_Arup.a(paramahcu.jdField_a_of_type_Asbq.a.epId));
    aruo.a().a(this.jdField_a_of_type_Arvc);
    EmoticonPackage localEmoticonPackage = new EmoticonPackage();
    localEmoticonPackage.name = paramahcu.jdField_a_of_type_Asbq.a.name;
    localEmoticonPackage.epId = paramahcu.jdField_a_of_type_Asbq.a.epId;
    localEmoticonPackage.jobType = 5;
    localEmoticonPackage.type = 1;
    localEmoticonPackage.isMagicFaceDownloading = true;
    ((awmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramahcu.jdField_a_of_type_Asbq.a);
    this.jdField_a_of_type_JavaUtilList.add(paramahcu);
    paramahcu.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
    paramahcu.f.setVisibility(8);
    paramahcu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    ((MessageForMarketFace)paramahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
    this.jdField_a_of_type_Arup.a(localEmoticonPackage, false);
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone,start download epId = " + paramahcu.jdField_a_of_type_Asbq.a.epId);
    }
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, localEmoticonPackage.epId, "", "", "");
    return;
    if ((this.f) && (this.jdField_a_of_type_Arup.b()))
    {
      if (!this.jdField_b_of_type_Boolean) {
        paramahcu.f.setVisibility(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source intacat epId = " + paramahcu.jdField_a_of_type_Asbq.a.epId);
      }
    }
    for (;;)
    {
      paramahcu.f.setImageResource(2130838005);
      if ((((MessageForMarketFace)paramahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).isSend()) || (!((MessageForMarketFace)paramahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay) || (!this.jdField_a_of_type_Arup.a()) || (System.currentTimeMillis() - this.jdField_d_of_type_Long <= 3000L) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().p())) {
        break;
      }
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      ((MessageForMarketFace)paramahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      a(paramahcu, "1");
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramahcu.jdField_a_of_type_Asbq.a.epId, "", "", "");
      return;
      paramahcu.f.setVisibility(8);
    }
  }
  
  private void b(ahcu paramahcu, URLDrawable paramURLDrawable)
  {
    int m = 200;
    int j;
    label50:
    int k;
    int n;
    Object localObject;
    if ((paramURLDrawable != null) && (paramahcu.jdField_a_of_type_Asbq.a != null)) {
      if (paramahcu.jdField_a_of_type_Asbq.a.width == 0)
      {
        j = 200;
        if (paramahcu.jdField_a_of_type_Asbq.a.height != 0) {
          break label429;
        }
        k = j;
        i = m;
        if (paramahcu.jdField_a_of_type_Asbq.a.extensionWidth != 0)
        {
          k = j;
          i = m;
          if (paramahcu.jdField_a_of_type_Asbq.a.extensionHeight != 0)
          {
            k = paramahcu.jdField_a_of_type_Asbq.a.extensionWidth;
            i = paramahcu.jdField_a_of_type_Asbq.a.extensionHeight;
          }
        }
        j = k;
        if (k != i) {
          j = i;
        }
        n = (j * this.jdField_e_of_type_Int + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
        i = (this.jdField_e_of_type_Int * i + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
        paramahcu.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(n, i));
        localObject = paramahcu.jdField_a_of_type_AndroidWidgetTextView.getTag();
        if (!(localObject instanceof Integer)) {
          break label530;
        }
      }
    }
    label530:
    for (int i = ((Integer)localObject).intValue();; i = -1)
    {
      if ((paramahcu.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (i != -1))
      {
        String str1 = (String)paramahcu.jdField_a_of_type_AndroidWidgetTextView.getTag(2131363999);
        String str2 = (String)paramahcu.jdField_a_of_type_AndroidWidgetTextView.getTag(2131363998);
        Paint localPaint = new Paint(1);
        localPaint.setTextSize(afur.a(12.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
        localPaint.setTextAlign(Paint.Align.LEFT);
        int i1 = (int)localPaint.measureText("...");
        if (!TextUtils.isEmpty(str1)) {}
        for (j = (int)localPaint.measureText(anni.a(2131705252) + str1);; j = (int)localPaint.measureText(anni.a(2131705248)))
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
          j = paramahcu.jdField_a_of_type_Asbq.a.width;
          break;
          label429:
          m = paramahcu.jdField_a_of_type_Asbq.a.height;
          break label50;
        }
        if (!((String)localObject).equals(""))
        {
          localObject = a(i, (String)localObject + "...", str1);
          paramahcu.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
      }
      paramahcu.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
      a(paramahcu, paramURLDrawable, paramahcu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
      return;
    }
  }
  
  private void b(ChatMessage paramChatMessage, ahcu paramahcu)
  {
    if ((paramahcu.jdField_a_of_type_Asbq.b()) && (paramahcu.jdField_a_of_type_Asbq.c()) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (paramahcu.jdField_a_of_type_Asbq.a() != null)
      {
        paramChatMessage = (RelativeLayout.LayoutParams)paramahcu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
        paramChatMessage.width = afur.a(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
        paramahcu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramahcu.jdField_a_of_type_Asbq.a(), paramChatMessage.width, paramahcu.jdField_a_of_type_Asbq.b());
        if (Build.VERSION.SDK_INT < 19)
        {
          paramChatMessage = (RelativeLayout.LayoutParams)paramahcu.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramahcu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
          paramChatMessage.width = afur.a(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
          localLayoutParams.width = afur.a(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
        }
      }
      int i = paramahcu.jdField_a_of_type_Asbq.c();
      int j = paramahcu.jdField_a_of_type_Asbq.d();
      paramChatMessage = new bcvy(i, 1, 1, afur.a(22.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      paramahcu.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(paramChatMessage);
      paramahcu.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.setDrawColor(i);
      paramahcu.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.postInvalidate();
      paramahcu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(j);
      paramahcu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(j);
    }
  }
  
  private void c(ahcu paramahcu)
  {
    paramahcu.jdField_a_of_type_Boolean = false;
    if ((2 != paramahcu.jdField_a_of_type_Asbq.a.jobType) || (((MessageForMarketFace)paramahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null) || (!awgs.a())) {}
    for (;;)
    {
      return;
      Object localObject;
      if (!this.jdField_a_of_type_Arup.f(paramahcu.jdField_a_of_type_Asbq.a.epId))
      {
        if (!arze.a())
        {
          paramahcu.f.setVisibility(8);
          return;
        }
        if ((!arze.c()) && (!this.jdField_a_of_type_Arup.a(paramahcu.jdField_a_of_type_Asbq.a.epId, Boolean.valueOf(false))) && (-1.0F == this.jdField_a_of_type_Arup.a(paramahcu.jdField_a_of_type_Asbq.a.epId)))
        {
          aruo.a().a(this.jdField_a_of_type_Arvc);
          localObject = new EmoticonPackage();
          ((EmoticonPackage)localObject).name = paramahcu.jdField_a_of_type_Asbq.a.name;
          ((EmoticonPackage)localObject).epId = paramahcu.jdField_a_of_type_Asbq.a.epId;
          ((EmoticonPackage)localObject).jobType = 3;
          ((EmoticonPackage)localObject).rscType = awfd.a(paramahcu.jdField_a_of_type_Asbq.a.magicValue);
          ((EmoticonPackage)localObject).type = 1;
          ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
          ((awmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramahcu.jdField_a_of_type_Asbq.a);
          this.jdField_a_of_type_JavaUtilList.add(paramahcu);
          paramahcu.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
          paramahcu.f.setVisibility(8);
          paramahcu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((MessageForMarketFace)paramahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          this.jdField_a_of_type_Arup.a((EmoticonPackage)localObject, false);
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongXiazai", 0, 0, paramahcu.jdField_a_of_type_Asbq.a.epId, "", "", "");
        }
      }
      else
      {
        if (awfd.a(paramahcu.jdField_a_of_type_Asbq.a.magicValue) == 1) {
          paramahcu.f.setVisibility(8);
        }
        while (((MessageForMarketFace)paramahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay)
        {
          ((MessageForMarketFace)paramahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          localObject = new Emoticon();
          ((Emoticon)localObject).eId = paramahcu.jdField_a_of_type_Asbq.a.eId;
          ((Emoticon)localObject).epId = paramahcu.jdField_a_of_type_Asbq.a.epId;
          ((Emoticon)localObject).magicValue = paramahcu.jdField_a_of_type_Asbq.a.magicValue;
          ((Emoticon)localObject).jobType = paramahcu.jdField_a_of_type_Asbq.a.jobType;
          if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() != null) && (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null) && (awgs.a())) {
            ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a((Emoticon)localObject, 1, ((MessageForMarketFace)paramahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).senderuin, false);
          }
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramahcu.jdField_a_of_type_Asbq.a.epId, "", "", "");
          return;
          if (!this.jdField_b_of_type_Boolean)
          {
            paramahcu.f.setImageResource(2130838005);
            paramahcu.f.setVisibility(0);
          }
        }
      }
    }
  }
  
  private void c(ChatMessage paramChatMessage, ahcu paramahcu)
  {
    if ((paramChatMessage.isFlowMessage) && (paramahcu.jdField_a_of_type_Asbq.a.jobType == 0)) {
      if (!(this.jdField_b_of_type_AndroidContentContext instanceof MultiForwardActivity))
      {
        if (!paramChatMessage.isSend()) {
          break label56;
        }
        paramahcu.c.setImageResource(2130847097);
        paramahcu.c.setVisibility(0);
      }
    }
    label56:
    while ((!paramChatMessage.isDui) || (!DuiButtonImageView.jdField_a_of_type_Boolean) || (axbp.a(paramChatMessage)))
    {
      return;
      paramahcu.d.setImageResource(2130847097);
      paramahcu.d.setVisibility(0);
      return;
    }
    paramahcu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    if ((paramChatMessage.isSend()) || (paramahcu.jdField_a_of_type_Asbq.b()))
    {
      paramahcu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
      paramahcu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      return;
    }
    if ((paramahcu.jdField_a_of_type_Asbq != null) && (paramahcu.jdField_a_of_type_Asbq.a != null) && ((2 == paramahcu.jdField_a_of_type_Asbq.a.jobType) || (4 == paramahcu.jdField_a_of_type_Asbq.a.jobType)))
    {
      paramahcu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
      paramahcu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      return;
    }
    if (!paramChatMessage.hasPlayedDui) {
      paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramahcu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView);
    }
    while (DuiButtonImageView.jdField_a_of_type_Boolean)
    {
      paramahcu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(this);
      paramahcu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(0);
      return;
      paramahcu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.f();
    }
    paramahcu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(null);
    paramahcu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
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
  
  private void d(ahcu paramahcu)
  {
    if ((paramahcu != null) && (paramahcu.jdField_a_of_type_Asbq != null) && (paramahcu.jdField_a_of_type_Asbq.c()) && (paramahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (!this.jdField_c_of_type_JavaUtilSet.contains(Long.valueOf(paramahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))))
    {
      awmr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AB51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramahcu.jdField_a_of_type_Asbq.a.epId);
      this.jdField_c_of_type_JavaUtilSet.add(Long.valueOf(paramahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
    }
  }
  
  private void h(View paramView)
  {
    paramView = (ahcu)afur.a(paramView);
    EmoticonPackage localEmoticonPackage;
    if ((paramView.jdField_a_of_type_Asbq != null) && (paramView.jdField_a_of_type_Asbq.a != null) && (2 == paramView.jdField_a_of_type_Asbq.a.jobType))
    {
      if (!this.jdField_a_of_type_Arup.a(paramView.jdField_a_of_type_Asbq.a.epId, Boolean.valueOf(false)))
      {
        aruo.a().a(this.jdField_a_of_type_Arvc);
        localEmoticonPackage = new EmoticonPackage();
        localEmoticonPackage.name = paramView.jdField_a_of_type_Asbq.a.name;
        localEmoticonPackage.epId = paramView.jdField_a_of_type_Asbq.a.epId;
        localEmoticonPackage.jobType = 3;
        localEmoticonPackage.type = 1;
        localEmoticonPackage.isMagicFaceDownloading = true;
        paramView.jdField_a_of_type_Boolean = false;
        ((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
        ((awmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramView.jdField_a_of_type_Asbq.a);
        this.jdField_a_of_type_JavaUtilList.add(paramView);
        paramView.f.setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_Arup.a(localEmoticonPackage, false);
        bcst.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongBofang", 0, 0, paramView.jdField_a_of_type_Asbq.a.epId, "", "", "");
      }
    }
    else if ((paramView.jdField_a_of_type_Asbq != null) && (paramView.jdField_a_of_type_Asbq.a != null) && (4 == paramView.jdField_a_of_type_Asbq.a.jobType) && (System.currentTimeMillis() - this.jdField_d_of_type_Long > 3000L) && (this.jdField_a_of_type_Arup.a()))
    {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      if (!this.jdField_a_of_type_Arup.a(paramView.jdField_a_of_type_Asbq.a.epId, true, true)) {
        break label474;
      }
      a(paramView, "0");
    }
    for (;;)
    {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbFasong", "MbZhudongBofang", 0, 0, paramView.jdField_a_of_type_Asbq.a.epId, "", "", "");
      return;
      if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (!awgs.a()) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null)) {
        break;
      }
      ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a(paramView.jdField_a_of_type_Asbq.a, 1, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, true);
      break;
      label474:
      aruo.a().a(this.jdField_a_of_type_Arvc);
      localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramView.jdField_a_of_type_Asbq.a.name;
      localEmoticonPackage.epId = paramView.jdField_a_of_type_Asbq.a.epId;
      localEmoticonPackage.jobType = 5;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      paramView.jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      ((awmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramView.jdField_a_of_type_Asbq.a);
      this.jdField_a_of_type_JavaUtilList.add(paramView);
      paramView.f.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_Arup.a(localEmoticonPackage, false);
    }
  }
  
  private void i(View paramView)
  {
    boolean bool = true;
    Object localObject = (ahcu)afur.a(paramView);
    QQAppInterface localQQAppInterface;
    int i;
    if ((((ahcu)localObject).jdField_a_of_type_Asbq != null) && (((ahcu)localObject).jdField_a_of_type_Asbq.b()) && (((ahcu)localObject).jdField_a_of_type_Asbq.c()))
    {
      if (!c(((ahcu)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
        break label119;
      }
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (((ahcu)localObject).jdField_a_of_type_Asbq.a == null) {
        break label112;
      }
    }
    label112:
    for (paramView = ((ahcu)localObject).jdField_a_of_type_Asbq.a.epId;; paramView = "")
    {
      awmr.a(localQQAppInterface, "0X800A934", i, paramView);
      return;
    }
    label119:
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694574, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
      return;
    }
    if ((((ahcu)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMarketFace)) {
      ((MessageForMarketFace)((ahcu)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage).playProgress = 0.0F;
    }
    ((ahcu)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
    if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((ahcu)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage))
    {
      ((ahcu)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (((ahcu)localObject).jdField_a_of_type_Asbq.a != null)
      {
        paramView = ((ahcu)localObject).jdField_a_of_type_Asbq.a.epId;
        awmr.a(localQQAppInterface, "0X800A933", i, paramView);
      }
    }
    for (;;)
    {
      if (!bool)
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (((ahcu)localObject).jdField_a_of_type_Asbq.a != null)
        {
          paramView = ((ahcu)localObject).jdField_a_of_type_Asbq.a.epId;
          label300:
          awmr.a(localQQAppInterface, "0X800A935", -1, paramView);
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
        bctj.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "NewAudioEmoticonVoicePlay", bool, 0L, 0L, (HashMap)localObject, null);
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
    ahcu localahcu = (ahcu)afur.a(paramView);
    Drawable localDrawable = localahcu.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
    URLDrawable localURLDrawable;
    Object localObject;
    if ((localDrawable instanceof URLDrawable))
    {
      localURLDrawable = (URLDrawable)localDrawable;
      localObject = localURLDrawable.getURL().getHost();
      if (!(localURLDrawable.getTag() instanceof Bundle)) {
        break label654;
      }
      localObject = ((Bundle)localURLDrawable.getTag()).getString("display_type");
    }
    label654:
    for (;;)
    {
      switch (((URLDrawable)localDrawable).getStatus())
      {
      default: 
        if ((localahcu.jdField_a_of_type_Asbq != null) && (localahcu.jdField_a_of_type_Asbq.a != null) && (localahcu.jdField_a_of_type_Asbq.a.jobType == 2) && (awgs.a())) {
          a(localahcu);
        }
        if ((((URLDrawable)localDrawable).getStatus() == 1) || ((localahcu.jdField_a_of_type_Asbq != null) && (localahcu.jdField_a_of_type_Asbq.a != null) && (localahcu.jdField_a_of_type_Asbq.e()))) {
          a(localahcu, abga.a(paramView));
        }
        break;
      }
      do
      {
        return;
        String str = "";
        if ((localURLDrawable.getStateTag() instanceof Bundle)) {
          str = ((Bundle)localURLDrawable.getStateTag()).getString("display_type");
        }
        localURLDrawable.restartDownload();
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "msgOnclickListener| URLDrawable restartDownload status=" + localURLDrawable.getStatus());
        }
        a(localahcu, localURLDrawable, str);
        localahcu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        if ((localahcu.jdField_a_of_type_Asbq == null) || (!localahcu.jdField_a_of_type_Asbq.b()) || (!"big_sound".equals(localObject))) {
          break;
        }
        jdField_c_of_type_Long = localahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
        break;
        if ((localahcu.jdField_a_of_type_Asbq == null) || (localahcu.jdField_a_of_type_Asbq.a == null) || (localahcu.jdField_a_of_type_Asbq.a.jobType == 0) || (localahcu.jdField_a_of_type_Asbq.a.jobType == 2) || (localahcu.jdField_a_of_type_Asbq.a.jobType == 4)) {
          break;
        }
        localahcu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        if ("big_sound".equals(localObject))
        {
          if ((localahcu.jdField_a_of_type_Asbq.a == null) || (!localahcu.jdField_a_of_type_Asbq.a.isSound)) {
            break;
          }
          if (c(localahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
          {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694574, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
            break;
          }
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
          break;
        }
        if (!"aio_preview".equals(localObject)) {
          break;
        }
        localObject = localahcu.jdField_a_of_type_Asbq.a("fromAIO", true);
        if (localObject == null) {
          break;
        }
        localahcu.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        localahcu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        a(localahcu, (URLDrawable)localObject);
        if (!localahcu.jdField_a_of_type_Asbq.b()) {
          break;
        }
        jdField_c_of_type_Long = localahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
        break;
      } while ((!(localDrawable instanceof awet)) || (localahcu.jdField_a_of_type_Asbq == null) || (localahcu.jdField_a_of_type_Asbq.a == null) || (!localahcu.jdField_a_of_type_Asbq.e()));
      a(localahcu, abga.a(paramView));
      return;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afwr a()
  {
    return new ahcu();
  }
  
  public View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    long l = System.currentTimeMillis();
    paramBaseChatItemLayout = (MessageForMarketFace)paramChatMessage;
    ahcu localahcu = (ahcu)paramafwr;
    this.jdField_b_of_type_JavaUtilSet.add(localahcu);
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
      paramafwr = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject2 = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout)localObject2).setId(2131370521);
      paramView = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      paramView.setId(2131366853);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131364379);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131364379);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setOnClickListener(this);
      localObject1 = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).setId(2131363395);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = 8;
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131366853);
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      ((FrameLayout)localObject1).setOnClickListener(this);
      ((FrameLayout)localObject1).setOnTouchListener(paramafzq);
      ((FrameLayout)localObject1).setOnLongClickListener(paramafzq);
      paramafzq = new ahcv(this, this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).addView(paramafzq, -2, -2);
      localObject4 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localObject5 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject5).gravity = 85;
      ((FrameLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject5).setId(2131381035);
      localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(1, 2131363395);
      ((RelativeLayout.LayoutParams)localObject6).addRule(8, 2131363395);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      ((ImageView)localObject5).setOnClickListener(this);
      localObject6 = new BreathAnimationLayout(this.jdField_b_of_type_AndroidContentContext);
      ((BreathAnimationLayout)localObject6).setId(2131371663);
      localPttAudioPlayView = new PttAudioPlayView(this.jdField_b_of_type_AndroidContentContext, 10);
      localPttAudioPlayView.setThemeColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131167004).getDefaultColor());
      localPttAudioPlayView.setId(2131371665);
      localPttAudioPlayView.setPttPauseOrStopDrawable(2130838195);
      localObject7 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject7).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject7).leftMargin = afur.a(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).width = afur.a(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).height = afur.a(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      localPttAudioPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject7);
      localPttAudioPlayView.setOnClickListener(this);
      localObject7 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localObject8 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject8).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject8).leftMargin = afur.a(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).width = afur.a(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).height = afur.a(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((ImageView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
      ((ImageView)localObject7).setImageDrawable((Drawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839400));
      ((ImageView)localObject7).setVisibility(4);
      localObject8 = new PttAudioWaveView(this.jdField_b_of_type_AndroidContentContext);
      ((PttAudioWaveView)localObject8).setShowProgressLine(false);
      ((PttAudioWaveView)localObject8).setMaxTopBottomPadding(4);
      ((PttAudioWaveView)localObject8).setProgressColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131167004).getDefaultColor());
      ((PttAudioWaveView)localObject8).setId(2131371666);
      localObject9 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(1, 2131371665);
      ((RelativeLayout.LayoutParams)localObject9).width = afur.a(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).height = afur.a(45.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).leftMargin = bgtn.a(9.0F);
      ((RelativeLayout.LayoutParams)localObject9).rightMargin = bgtn.a(12.0F);
      ((PttAudioWaveView)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
      ((PttAudioWaveView)localObject8).setCanSupportSlide(false);
      ((PttAudioWaveView)localObject8).setOnClickListener(this);
      localObject9 = new SyncParentPressedRelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      ((RelativeLayout)localObject9).setId(2131371664);
      ((RelativeLayout)localObject9).addView((View)localObject8);
      ((RelativeLayout)localObject9).addView(localPttAudioPlayView);
      ((RelativeLayout)localObject9).addView((View)localObject7);
      localRelativeLayout = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localTriangleView = new TriangleView(this.jdField_b_of_type_AndroidContentContext);
      localObject10 = new RelativeLayout.LayoutParams(bgtn.a(9.0F), bgtn.a(5.0F));
      ((RelativeLayout.LayoutParams)localObject10).leftMargin = bgtn.a(2.0F);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14);
      ((RelativeLayout.LayoutParams)localObject10).addRule(10);
      localTriangleView.setId(2131372685);
      localTriangleView.setRotation(180.0F);
      localTriangleView.setTranslationY(bgtn.a(1.0F));
      localTriangleView.setLayoutParams((ViewGroup.LayoutParams)localObject10);
      localRelativeLayout.addView(localTriangleView);
      localObject10 = new RelativeLayout.LayoutParams(-2, bgtn.a(29.0F));
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131372685);
      localRelativeLayout.addView((View)localObject9, (ViewGroup.LayoutParams)localObject10);
      ((BreathAnimationLayout)localObject6).addView(localRelativeLayout);
      localObject10 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14, 2131363395);
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131363395);
      ((RelativeLayout.LayoutParams)localObject10).bottomMargin = bgtn.a(17.0F);
      ((RelativeLayout)localObject2).addView((View)localObject6, (ViewGroup.LayoutParams)localObject10);
      localObject10 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject10).setId(2131366854);
      localObject11 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject11).addRule(1, 2131363395);
      ((RelativeLayout.LayoutParams)localObject11).addRule(15, 2131363395);
      ((RelativeLayout.LayoutParams)localObject11).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject10, (ViewGroup.LayoutParams)localObject11);
      ((ImageView)localObject10).setOnClickListener(this);
      localObject11 = new DuiButtonImageView(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      ((DuiButtonImageView)localObject11).setId(2131365738);
      localObject12 = new RelativeLayout.LayoutParams(afur.a(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), afur.a(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject12).addRule(1, 2131363395);
      ((RelativeLayout.LayoutParams)localObject12).addRule(8, 2131363395);
      ((RelativeLayout.LayoutParams)localObject12).setMargins(0, 0, 0, -afur.a(6.5F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout)localObject2).addView((View)localObject11, (ViewGroup.LayoutParams)localObject12);
      localObject12 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject12).setId(2131370434);
      localObject13 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject13).addRule(1, 2131363395);
      ((RelativeLayout.LayoutParams)localObject13).addRule(8, 2131363395);
      ((RelativeLayout.LayoutParams)localObject13).leftMargin = afur.a(10.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout)localObject2).addView((View)localObject12, (ViewGroup.LayoutParams)localObject13);
      localObject13 = new TextView(this.jdField_b_of_type_AndroidContentContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      ((TextView)localObject13).setTextSize(12.0F);
      ((TextView)localObject13).setTextColor(-1);
      localLayoutParams.topMargin = afur.a(8.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((TextView)localObject13).setGravity(17);
      localLayoutParams.addRule(3, 2131370521);
    }
    for (;;)
    {
      try
      {
        ((TextView)localObject13).setBackgroundDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130844771));
        ((TextView)localObject13).setPadding(afur.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), afur.a(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), afur.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), afur.a(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
        paramafwr.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramafwr.addView((View)localObject13, localLayoutParams);
        ((ImageView)localObject12).setOnClickListener(this);
        localObject2 = new ProgressBar(this.jdField_b_of_type_AndroidContentContext, null, 0);
        ((ProgressBar)localObject2).setId(2131364406);
      }
      catch (Exception localException2)
      {
        try
        {
          ((ProgressBar)localObject2).setIndeterminateDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839402));
          int i = afur.a(16.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
          localObject3 = new FrameLayout.LayoutParams(i, i);
          ((FrameLayout.LayoutParams)localObject3).gravity = 17;
          ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          localahcu.jdField_e_of_type_AndroidWidgetImageView = paramafzq;
          localahcu.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject4);
          localahcu.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject5);
          localahcu.c = paramView;
          localahcu.d = ((ImageView)localObject10);
          localahcu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView = ((DuiButtonImageView)localObject11);
          localahcu.f = ((ImageView)localObject12);
          localahcu.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localObject1);
          localahcu.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject2);
          localahcu.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject13);
          localahcu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)localObject6);
          localahcu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = localPttAudioPlayView;
          localahcu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject8);
          localahcu.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject9);
          localahcu.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
          localahcu.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView = localTriangleView;
          localahcu.g = ((ImageView)localObject7);
          if (!c(paramChatMessage)) {
            paramBaseChatItemLayout.playProgress = 0.0F;
          }
          a(localahcu, paramChatMessage.uniseq);
          localahcu.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          localahcu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramBaseChatItemLayout.playProgress);
          if ((AppSetting.c) && (a(paramChatMessage, localahcu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) && (localahcu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)) {
            localahcu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setContentDescription(anni.a(2131705253));
          }
          new QueryTask(new ahcn(this, localahcu), new ahco(this, localahcu, paramBaseChatItemLayout, paramChatMessage, l)).a(paramBaseChatItemLayout.mMarkFaceMessage);
          return paramafwr;
          localException2 = localException2;
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException2);
        }
        catch (Exception localException1)
        {
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException1);
          continue;
        }
      }
      if ((localahcu.jdField_a_of_type_Asbq != null) && (localahcu.jdField_a_of_type_Asbq.b()) && (localahcu.jdField_b_of_type_AndroidWidgetImageView != null) && ((localahcu.jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof AnimationDrawable))) {
        localahcu.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847117);
      }
      paramafwr = paramView;
      if (AppSetting.c)
      {
        localahcu.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        paramafwr = paramView;
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (!bgnr.a(paramChatMessage.issend)) {
        break label103;
      }
      localStringBuilder.append("发出表情");
    }
    for (;;)
    {
      paramChatMessage = (MessageForMarketFace)paramChatMessage;
      if (paramChatMessage.mMarkFaceMessage != null)
      {
        paramChatMessage = ((awmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramChatMessage.mMarkFaceMessage);
        if (paramChatMessage != null)
        {
          paramChatMessage = paramChatMessage.a;
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
    aruo.a().b(this.jdField_a_of_type_Arvc);
    aruo.a().b(this.jdField_a_of_type_Ahct);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((ahcu)localIterator.next()).a();
    }
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((jdField_a_of_type_Asbq == null) || (jdField_a_of_type_Asbq.a == null))
    {
      QLog.e("MarketFaceItemBuilder", 1, "onMenuItemClicked emoticon is null");
      return;
    }
    if ((paramInt == 2131365308) || (paramInt == 2131362186) || (paramInt == 2131367044) || (paramInt == 2131366752) || (paramInt == 2131371379))
    {
      a(paramInt, paramChatMessage);
      return;
    }
    if (paramInt == 2131371422)
    {
      super.d(paramChatMessage);
      return;
    }
    if (paramInt == 2131371380)
    {
      super.a(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    ((awmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(jdField_a_of_type_Asbq.a.epId, new ahcm(this, paramInt, paramChatMessage));
  }
  
  void a(ahcu paramahcu, URLDrawable paramURLDrawable)
  {
    a(paramahcu, paramURLDrawable, "");
  }
  
  void a(ahcu paramahcu, URLDrawable paramURLDrawable, String paramString)
  {
    paramahcu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramahcu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
    paramahcu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramahcu.f.setVisibility(8);
    paramahcu.jdField_b_of_type_Boolean = false;
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
        if (paramahcu.jdField_a_of_type_Asbq.b()) {
          if (paramahcu.jdField_a_of_type_Asbq.c()) {
            paramahcu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          }
        }
      }
      while (!"big_sound".equals(str))
      {
        do
        {
          return;
          paramahcu.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847117);
          paramahcu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        } while ((i != 1) || (paramahcu.jdField_a_of_type_Asbq.j != 3));
        paramahcu.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838002);
        paramahcu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramahcu.jdField_b_of_type_Boolean = true;
        return;
      }
      if (c(paramahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
      {
        if (paramahcu.jdField_a_of_type_Asbq.c())
        {
          paramahcu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          paramahcu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          return;
        }
        paramahcu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramURLDrawable = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772269);
        paramahcu.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
        paramURLDrawable.start();
        return;
      }
      if (paramahcu.jdField_a_of_type_Asbq.c())
      {
        paramahcu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
        paramahcu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
        return;
      }
      paramahcu.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847117);
      paramahcu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
  }
  
  public void a(View paramView)
  {
    paramView = (ahcu)afur.a(paramView);
    String str1;
    String str2;
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSendFromLocal())
    {
      str1 = this.jdField_b_of_type_AndroidContentContext.getString(2131689926);
      str2 = this.jdField_b_of_type_AndroidContentContext.getString(2131689927);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 41) && (paramView.jdField_a_of_type_Asbq != null) && (paramView.jdField_a_of_type_Asbq.a != null)) {
        a((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_Asbq);
      }
    }
    do
    {
      return;
      bglp.a(this.jdField_b_of_type_AndroidContentContext, 230, str1, str2, new ahcr(this, paramView), new ahcs(this)).show();
      return;
      paramView = paramView.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
    } while (!(paramView instanceof URLDrawable));
    ((URLDrawable)paramView).restartDownload();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, bclx.a(10.0F), 0);
  }
  
  protected void a(bguh parambguh)
  {
    if ((jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (jdField_a_of_type_Asbq.a == null)) {}
    label135:
    for (;;)
    {
      return;
      if (jdField_a_of_type_Asbq.a.jobType == 0) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (!arze.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
          break label135;
        }
        aqmg localaqmg = aqmf.a();
        if ((localaqmg == null) || (!localaqmg.a())) {
          break;
        }
        parambguh.a(2131371379, this.jdField_b_of_type_AndroidContentContext.getString(2131717296), 2130838935);
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X800B114", "0X800B114", arze.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, "", "", "", "");
        return;
      }
    }
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, String paramString, int paramInt)
  {
    biau localbiau = a();
    if (localbiau != null)
    {
      localbiau.a(this.jdField_b_of_type_AndroidContentContext.getString(2131691744));
      localbiau.show();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect", 0);
    if ((jdField_a_of_type_Asbq != null) && (jdField_a_of_type_Asbq.a != null)) {
      arze.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null, jdField_a_of_type_Asbq.a.eId);
    }
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", paramString, paramInt + "", "");
    QQAppInterface localQQAppInterface;
    if ((jdField_a_of_type_Asbq != null) && (jdField_a_of_type_Asbq.c()))
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (jdField_a_of_type_Asbq.a == null) {
        break label268;
      }
    }
    label268:
    for (paramString = jdField_a_of_type_Asbq.a.epId;; paramString = "")
    {
      awmr.a(localQQAppInterface, "0X800A939", paramInt, paramString);
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
    a(6, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_a_of_type_Asbq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localbiau);
    return;
    label299:
    a(6);
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, String paramString, int paramInt1, int paramInt2)
  {
    biau localbiau = a();
    if (paramInt2 == 2131367044)
    {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "aio_trans_bq", 0, 0, "4", paramString, paramInt1 + "", "");
      if ((2 == jdField_a_of_type_Asbq.a.jobType) && (!this.jdField_a_of_type_Arup.c()))
      {
        ChatActivityUtils.a(this.jdField_b_of_type_AndroidContentContext, 2131689925, 0);
        return;
      }
      jdField_c_of_type_Int = 1;
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_button_forward_aio", 0);
      paramString = this.jdField_b_of_type_AndroidContentContext.getString(2131691747);
    }
    for (paramInt1 = 7;; paramInt1 = 107)
    {
      if (localbiau != null)
      {
        localbiau.a(paramString);
        localbiau.show();
      }
      if (paramEmoticonPackage != null) {
        break;
      }
      a(paramInt1);
      return;
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006449", "0X8006449", 0, 0, "4", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((bfsk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean))
      {
        ChatActivityUtils.a(this.jdField_b_of_type_AndroidContentContext, 2131696676, 0);
        return;
      }
      paramString = this.jdField_b_of_type_AndroidContentContext.getString(2131691746);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ep_mall", "Clk_button_follow_aio", 0, 0, "", jdField_a_of_type_Asbq.a.epId, "", "");
    }
    a(paramInt1, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_a_of_type_Asbq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localbiau);
  }
  
  protected void a(MessageForMarketFace paramMessageForMarketFace, asbq paramasbq)
  {
    if ((paramMessageForMarketFace == null) || (paramasbq == null) || (paramasbq.a == null) || (paramasbq.a.epId == null)) {
      return;
    }
    bkho localbkho = (bkho)bkif.a(this.jdField_b_of_type_AndroidContentContext, null);
    localbkho.a(this.jdField_b_of_type_AndroidContentContext.getString(2131691742));
    localbkho.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131691741), 1);
    localbkho.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131691743), 1);
    localbkho.c(2131690582);
    localbkho.a(new ahcj(this, paramasbq, localbkho, paramMessageForMarketFace));
    localbkho.show();
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if ((paramView != null) && (paramFloat > 0.0F))
    {
      paramXListView = (ahcu)afur.a(paramView);
      if ((paramXListView != null) && (paramXListView.jdField_a_of_type_Asbq != null) && (paramXListView.jdField_a_of_type_Asbq.b()) && (paramXListView.jdField_a_of_type_Asbq.c()) && (c(paramChatMessage)))
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
      paramXListView = (ahcu)afur.a(paramView);
      if (!paramXListView.jdField_a_of_type_Asbq.c()) {
        break label66;
      }
      paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
        paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
      }
    }
    for (;;)
    {
      paramView = paramXListView.jdField_a_of_type_Asbq.a("fromAIO", false);
      paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      return;
      label66:
      paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847117);
    }
  }
  
  public boolean a(afwr paramafwr)
  {
    return paramafwr instanceof ahcu;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (ahcu)afur.a(paramView);
    if ((paramXListView == null) || (paramXListView.jdField_a_of_type_Asbq == null) || (paramXListView.jdField_a_of_type_Asbq.a == null)) {
      return false;
    }
    if (paramXListView.jdField_a_of_type_Asbq.b())
    {
      paramView = arze.o.replace("[epId]", paramXListView.jdField_a_of_type_Asbq.a.epId).replace("[eId]", paramXListView.jdField_a_of_type_Asbq.a.eId);
      if (!bgmg.b(paramView))
      {
        if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramChatMessage.uniseq))) {
          return false;
        }
        this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramChatMessage.uniseq));
        a(paramXListView, paramChatMessage.uniseq);
        ThreadManager.getFileThreadHandler().post(new MarketFaceItemBuilder.7(this, paramXListView, paramChatMessage));
        return false;
      }
      if (paramAudioPlayerBase.a(paramView))
      {
        paramView = paramXListView.jdField_a_of_type_Asbq.a("fromAIO", true);
        paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        asbq.a(paramView);
        if (paramXListView.jdField_a_of_type_Asbq.c()) {
          if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
            paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          }
        }
        for (;;)
        {
          return true;
          paramView = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772269);
          paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
          paramView.start();
        }
      }
    }
    return false;
  }
  
  public bguj[] a(View paramView)
  {
    paramView = (ahcu)afur.a(paramView);
    bguh localbguh = new bguh();
    jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (ApolloUtil.a(jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
      return localbguh.a();
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
        if (paramView.jdField_a_of_type_Asbq.a.jobType != 1)
        {
          jdField_a_of_type_Asbq = paramView.jdField_a_of_type_Asbq;
          if (afur.a(1) == 1) {
            localbguh.a(2131362186, this.jdField_b_of_type_AndroidContentContext.getString(2131692945), 2130838927);
          }
          a(localbguh);
          localbguh.a(2131367044, this.jdField_b_of_type_AndroidContentContext.getString(2131692395), 2130838929);
          a(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbguh);
          if ((paramView.jdField_a_of_type_Asbq.a.jobType != 2) && (paramView.jdField_a_of_type_Asbq.a.jobType != 4)) {
            localbguh.a(2131366752, this.jdField_b_of_type_AndroidContentContext.getString(2131692952), 2130838908);
          }
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Ap_show_forward", 0);
        }
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
          a(localbguh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        a(localbguh, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        super.a(localbguh, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        if (paramView.jdField_a_of_type_Asbq.a.jobType != 1) {
          b(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbguh);
        }
        super.c(localbguh, this.jdField_b_of_type_AndroidContentContext);
        super.e(localbguh, this.jdField_b_of_type_AndroidContentContext);
      }
      for (;;)
      {
        return localbguh.a();
        jdField_a_of_type_Asbq = paramView.jdField_a_of_type_Asbq;
        adrm.a(localbguh, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
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
        ((BaseChatPie)localObject).a().obtainMessage(79, null).sendToTarget();
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
    afur.n = true;
    if (super.a()) {
      return;
    }
    if (paramView.getId() == 2131363395)
    {
      j(paramView);
      return;
    }
    if (paramView.getId() == 2131381035) {
      g(paramView);
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      if ((paramView.getId() == 2131371665) || (paramView.getId() == 2131371666)) {
        i(paramView);
      } else if ((paramView.getId() == 2131366854) || (paramView.getId() == 2131366853)) {
        f(paramView);
      } else if (paramView.getId() == 2131365738) {
        e();
      } else if (paramView.getId() == 2131370434) {
        h(paramView);
      }
    }
  }
  
  protected void f(View paramView)
  {
    paramView = (ahcu)afur.a(paramView);
    biau localbiau = a();
    if (localbiau != null)
    {
      localbiau.a(this.jdField_b_of_type_AndroidContentContext.getString(2131691746));
      localbiau.show();
    }
    ((awmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramView.jdField_a_of_type_Asbq.a.epId, new ahci(this, paramView, localbiau));
  }
  
  protected void g(View paramView)
  {
    paramView = (ahcu)afur.a(paramView);
    if ((paramView.jdField_a_of_type_Asbq != null) && (paramView.jdField_a_of_type_Asbq.b()))
    {
      if (c(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694574, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
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
        ((agkh)((BaseChatPie)localObject).a(72)).a(paramChatMessage, jdField_a_of_type_Asbq.a("fromAIO", false));
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
 * Qualified Name:     ahch
 * JD-Core Version:    0.7.0.1
 */