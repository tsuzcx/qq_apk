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

public class ahlt
  extends BaseBubbleBuilder
  implements agjg
{
  public static asre a;
  public static ChatMessage a;
  public static int c;
  static long jdField_c_of_type_Long;
  ahmf jdField_a_of_type_Ahmf = new ahmf();
  public askd a;
  askq jdField_a_of_type_Askq = new ahmc(this);
  public List<ahmg> a;
  public Set<Long> a;
  public Context b;
  Set<ahmg> b;
  Set<Long> jdField_c_of_type_JavaUtilSet = new ArraySet();
  public int d;
  private long d;
  public int e;
  public boolean f = false;
  
  static
  {
    jdField_c_of_type_Int = 1;
  }
  
  public ahlt(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_d_of_type_Int = 320;
    this.jdField_e_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Askd = ((askd)paramQQAppInterface.getManager(43));
    if ((this.jdField_b_of_type_AndroidContentContext instanceof SplashActivity)) {
      this.f = true;
    }
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, Handler paramHandler)
  {
    boolean bool = true;
    ashc localashc = (ashc)paramQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("MarketFaceItemBuilder", 2, "Call getEmoticonDataList from addEmotionToFavorite.");
    }
    List localList = localashc.a();
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
          if (localashc.a(localCustomEmotionData, j))
          {
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramHandler != null) {
              paramHandler.post(new MarketFaceItemBuilder.14(paramContext));
            }
            axfj.c("0", 1);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
            }
            return 0;
          }
          if (paramHandler != null) {
            paramHandler.post(new MarketFaceItemBuilder.15(paramContext));
          }
          axfj.c("2003", 1);
          return 0;
        }
        n = i;
        if (i < localCustomEmotionData.emoId) {
          n = localCustomEmotionData.emoId;
        }
        j += 1;
        m = k;
      }
      if (m >= asha.jdField_a_of_type_Int) {
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
      paramEmoticon = ((axfj)paramQQAppInterface.getManager(14)).a(paramEmoticon.epId);
      if (paramEmoticon != null) {
        if (paramEmoticon.isAPNG != 2) {
          break label425;
        }
      }
      for (;;)
      {
        paramHandler.isAPNG = bool;
        paramEmoticon = (ashd)paramQQAppInterface.getManager(103);
        if (paramEmoticon != null) {
          paramEmoticon.b(paramHandler, new asgl(paramQQAppInterface, paramContext, paramHandler, null, 0));
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
      paramString2 = anzj.a(2131705362);
      continue;
      paramString2 = anzj.a(2131705357);
      paramInt = i;
      continue;
      paramString2 = anzj.a(2131705354);
      paramInt = i;
      continue;
      paramString2 = anzj.a(2131705364);
      paramInt = i;
    }
  }
  
  private bjbs a()
  {
    if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a == null) {
        ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a = new bjbs(this.jdField_b_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a;
    }
    return null;
  }
  
  private String a()
  {
    try
    {
      i = bhnv.a(this.jdField_b_of_type_AndroidContentContext);
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
    this.jdField_a_of_type_Ahmf.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_Asre, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a());
    askc.a().a(this.jdField_a_of_type_Ahmf);
    this.jdField_a_of_type_Askd.a(jdField_a_of_type_Asre.a.epId, askd.jdField_c_of_type_Int);
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
            auxu.a((BaseActivity)paramContext, paramEmoticon, 21, 100500, "biz_src_jc_gif");
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
      bdll.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_follow_send_aio", 0, 0, "", paramEmoticon.epId, "", "");
      asre.a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, null);
      return;
      if (paramInt2 < 0)
      {
        localHandler.post(new MarketFaceItemBuilder.12(paramContext, paramString));
        if (6 == paramInt1 % 1000) {
          axfj.c("2001", 1);
        }
        QLog.i("MarketFaceItemBuilder", 1, "opType: " + paramInt1 + ",result:" + paramInt2);
        return;
      }
      localHandler.post(new MarketFaceItemBuilder.13(paramInt1, paramContext, paramQQAppInterface, paramEmoticon, paramString));
    } while (6 != paramInt1 % 1000);
    axfj.c("2002", 1);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, asre paramasre, SessionInfo paramSessionInfo, bjbs parambjbs)
  {
    a(paramInt, paramContext, paramQQAppInterface, paramEmoticonPackage, paramasre, paramSessionInfo, parambjbs, false);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, asre paramasre, SessionInfo paramSessionInfo, bjbs parambjbs, boolean paramBoolean)
  {
    if (paramasre == null) {
      return;
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.mobileFeetype == 1))
    {
      if ((parambjbs != null) && (parambjbs.isShowing())) {
        parambjbs.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramasre.a, 0, null, paramSessionInfo, paramBoolean);
      return;
    }
    if ((!bhnv.g(paramContext)) || (paramInt > 1000))
    {
      if ((parambjbs != null) && (parambjbs.isShowing())) {
        parambjbs.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramasre.a, -404, anzj.a(2131705361), paramSessionInfo, paramBoolean);
      return;
    }
    ((anwx)paramQQAppInterface.a(12)).a(paramInt, Integer.valueOf(paramasre.a.epId).intValue(), paramasre.a.eId);
  }
  
  private void a(ahmg paramahmg)
  {
    EmoticonPackage localEmoticonPackage;
    if (!this.jdField_a_of_type_Askd.a(paramahmg.jdField_a_of_type_Asre.a.epId, Boolean.valueOf(false)))
    {
      askc.a().a(this.jdField_a_of_type_Askq);
      localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramahmg.jdField_a_of_type_Asre.a.name;
      localEmoticonPackage.epId = paramahmg.jdField_a_of_type_Asre.a.epId;
      localEmoticonPackage.jobType = 3;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      if (paramahmg.jdField_e_of_type_Int != -1) {
        break label222;
      }
    }
    label222:
    for (localEmoticonPackage.rscType = awxv.a(paramahmg.jdField_a_of_type_Asre.a.magicValue);; localEmoticonPackage.rscType = paramahmg.jdField_e_of_type_Int)
    {
      ((axfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramahmg.jdField_a_of_type_Asre.a);
      paramahmg.jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)paramahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = true;
      this.jdField_a_of_type_JavaUtilList.add(paramahmg);
      paramahmg.f.setVisibility(8);
      paramahmg.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_Askd.a(localEmoticonPackage, false);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void a(ahmg paramahmg, long paramLong)
  {
    Animatable localAnimatable = (Animatable)paramahmg.g.getDrawable();
    if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramLong)))
    {
      if (!localAnimatable.isRunning()) {
        localAnimatable.start();
      }
      paramahmg.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(4);
      paramahmg.g.setVisibility(0);
      return;
    }
    if (localAnimatable.isRunning()) {
      localAnimatable.stop();
    }
    paramahmg.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
    paramahmg.g.setVisibility(4);
  }
  
  private void a(ahmg paramahmg, Rect paramRect)
  {
    AIOEmotionFragment.a(this.jdField_b_of_type_AndroidContentContext, paramahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramRect);
  }
  
  private void a(ahmg paramahmg, URLDrawable paramURLDrawable, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramURLDrawable != null) {
      switch (paramURLDrawable.getStatus())
      {
      default: 
        paramahmg.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
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
          if (!awzk.a()) {
            paramahmg.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          }
        } while ((asos.a()) && (2 == paramahmg.jdField_a_of_type_Asre.a.jobType) && (!this.jdField_a_of_type_Askd.f(paramahmg.jdField_a_of_type_Asre.a.epId)) && (!asos.c()));
        f1 = this.jdField_a_of_type_Askd.a(paramahmg.jdField_a_of_type_Asre.a.epId);
      } while ((f1 >= 0.0F) && (1.0F != f1));
      paramahmg.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramBaseChatItemLayout.setProgressVisable(false);
      return;
      paramahmg.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramBaseChatItemLayout.setProgressVisable(false);
    } while (!AppSetting.c);
    paramahmg.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(anzj.a(2131705358));
  }
  
  private void a(ahmg paramahmg, String paramString)
  {
    ThreadManager.post(new MarketFaceItemBuilder.5(this, paramString, paramahmg), 5, null, true);
  }
  
  private void a(asre paramasre, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      str2 = a();
      if (paramasre == null) {}
      for (paramasre = "";; paramasre = paramasre.a.epId)
      {
        VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramasre, paramString);
        return;
      }
    case 3: 
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramasre == null) {}
      for (paramasre = "";; paramasre = paramasre.a.epId)
      {
        bdll.b(paramString, "CliOper", "", "", "ep_mall", "0X8007187", 0, 0, paramasre, "", "", "");
        return;
      }
    }
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    String str2 = a();
    if (paramasre == null) {}
    for (paramasre = "";; paramasre = paramasre.a.epId)
    {
      VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramasre, paramString, "1", "", "", "", 0, 0, 0, 0);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    bdll.b(paramQQAppInterface, "CliOper", "", "", paramString2, paramString3, paramInt, 0, "", "", "", "");
  }
  
  private void a(ChatMessage paramChatMessage, ahmg paramahmg)
  {
    a(paramChatMessage, paramahmg, "");
  }
  
  private void a(ChatMessage paramChatMessage, ahmg paramahmg, String paramString)
  {
    int i = 0;
    if ((paramahmg.jdField_a_of_type_Asre.b()) && (!c(paramChatMessage))) {}
    for (boolean bool = false;; bool = true)
    {
      URLDrawable localURLDrawable = paramahmg.jdField_a_of_type_Asre.a("fromAIO", bool);
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
              localObject2 = paramahmg.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
              if ((localObject2 != null) && (((EmoticonPackage)localObject2).status == 2))
              {
                URLDrawable.removeMemoryCacheByUrl(localURLDrawable.getURL().toString());
                paramString = paramahmg.jdField_a_of_type_Asre.a("fromAIO", bool);
              }
            }
          }
        }
      }
      for (;;)
      {
        b(paramahmg, paramString);
        paramahmg.d.setVisibility(8);
        paramahmg.c.setVisibility(8);
        paramahmg.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
        c(paramChatMessage, paramahmg);
        b(paramChatMessage, paramahmg);
        if (paramString != null) {
          a(paramahmg, paramString, (String)localObject1);
        }
        c(paramahmg);
        return;
        if (!paramString.equals("")) {
          i = 1;
        }
        localObject2 = localObject1;
        if (i != 0)
        {
          URLDrawable.removeMemoryCacheByUrl(localURLDrawable.getURL().toString());
          paramString = paramahmg.jdField_a_of_type_Asre.a("fromAIO", bool, true, paramahmg);
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
      bhlq.a(paramContext, 230, paramString1, paramString2, 2131690580, 2131691444, new ahlw(paramEmoticon, paramContext, paramQQAppInterface, paramInt), new ahlx()).show();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EmosmDetailActivity.showCustomMarketFaceTips", 2, paramContext.getMessage());
    }
  }
  
  private void b(ahmg paramahmg)
  {
    if ((4 != paramahmg.jdField_a_of_type_Asre.a.jobType) || (((MessageForMarketFace)paramahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Askd.a(paramahmg.jdField_a_of_type_Asre.a.epId, true, true)) {
        break;
      }
      if (!asos.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone: H5MagicSource isnot Intact , and network isnot 2 3 4G or wifi;epId = " + paramahmg.jdField_a_of_type_Asre.a.epId);
        }
        paramahmg.f.setVisibility(8);
        return;
      }
    } while (-1.0F != this.jdField_a_of_type_Askd.a(paramahmg.jdField_a_of_type_Asre.a.epId));
    askc.a().a(this.jdField_a_of_type_Askq);
    EmoticonPackage localEmoticonPackage = new EmoticonPackage();
    localEmoticonPackage.name = paramahmg.jdField_a_of_type_Asre.a.name;
    localEmoticonPackage.epId = paramahmg.jdField_a_of_type_Asre.a.epId;
    localEmoticonPackage.jobType = 5;
    localEmoticonPackage.type = 1;
    localEmoticonPackage.isMagicFaceDownloading = true;
    ((axfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramahmg.jdField_a_of_type_Asre.a);
    this.jdField_a_of_type_JavaUtilList.add(paramahmg);
    paramahmg.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
    paramahmg.f.setVisibility(8);
    paramahmg.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    ((MessageForMarketFace)paramahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
    this.jdField_a_of_type_Askd.a(localEmoticonPackage, false);
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone,start download epId = " + paramahmg.jdField_a_of_type_Asre.a.epId);
    }
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, localEmoticonPackage.epId, "", "", "");
    return;
    if ((this.f) && (this.jdField_a_of_type_Askd.b()))
    {
      if (!this.jdField_b_of_type_Boolean) {
        paramahmg.f.setVisibility(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source intacat epId = " + paramahmg.jdField_a_of_type_Asre.a.epId);
      }
    }
    for (;;)
    {
      paramahmg.f.setImageResource(2130838014);
      if ((((MessageForMarketFace)paramahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage).isSend()) || (!((MessageForMarketFace)paramahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay) || (!this.jdField_a_of_type_Askd.a()) || (System.currentTimeMillis() - this.jdField_d_of_type_Long <= 3000L) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().p())) {
        break;
      }
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      ((MessageForMarketFace)paramahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      a(paramahmg, "1");
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramahmg.jdField_a_of_type_Asre.a.epId, "", "", "");
      return;
      paramahmg.f.setVisibility(8);
    }
  }
  
  private void b(ahmg paramahmg, URLDrawable paramURLDrawable)
  {
    int m = 200;
    int j;
    label50:
    int k;
    int n;
    Object localObject;
    if ((paramURLDrawable != null) && (paramahmg.jdField_a_of_type_Asre.a != null)) {
      if (paramahmg.jdField_a_of_type_Asre.a.width == 0)
      {
        j = 200;
        if (paramahmg.jdField_a_of_type_Asre.a.height != 0) {
          break label429;
        }
        k = j;
        i = m;
        if (paramahmg.jdField_a_of_type_Asre.a.extensionWidth != 0)
        {
          k = j;
          i = m;
          if (paramahmg.jdField_a_of_type_Asre.a.extensionHeight != 0)
          {
            k = paramahmg.jdField_a_of_type_Asre.a.extensionWidth;
            i = paramahmg.jdField_a_of_type_Asre.a.extensionHeight;
          }
        }
        j = k;
        if (k != i) {
          j = i;
        }
        n = (j * this.jdField_e_of_type_Int + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
        i = (this.jdField_e_of_type_Int * i + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
        paramahmg.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(n, i));
        localObject = paramahmg.jdField_a_of_type_AndroidWidgetTextView.getTag();
        if (!(localObject instanceof Integer)) {
          break label530;
        }
      }
    }
    label530:
    for (int i = ((Integer)localObject).intValue();; i = -1)
    {
      if ((paramahmg.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (i != -1))
      {
        String str1 = (String)paramahmg.jdField_a_of_type_AndroidWidgetTextView.getTag(2131364025);
        String str2 = (String)paramahmg.jdField_a_of_type_AndroidWidgetTextView.getTag(2131364024);
        Paint localPaint = new Paint(1);
        localPaint.setTextSize(agej.a(12.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
        localPaint.setTextAlign(Paint.Align.LEFT);
        int i1 = (int)localPaint.measureText("...");
        if (!TextUtils.isEmpty(str1)) {}
        for (j = (int)localPaint.measureText(anzj.a(2131705359) + str1);; j = (int)localPaint.measureText(anzj.a(2131705355)))
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
          j = paramahmg.jdField_a_of_type_Asre.a.width;
          break;
          label429:
          m = paramahmg.jdField_a_of_type_Asre.a.height;
          break label50;
        }
        if (!((String)localObject).equals(""))
        {
          localObject = a(i, (String)localObject + "...", str1);
          paramahmg.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
      }
      paramahmg.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
      a(paramahmg, paramURLDrawable, paramahmg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
      return;
    }
  }
  
  private void b(ChatMessage paramChatMessage, ahmg paramahmg)
  {
    if ((paramahmg.jdField_a_of_type_Asre.b()) && (paramahmg.jdField_a_of_type_Asre.c()) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (paramahmg.jdField_a_of_type_Asre.a() != null)
      {
        paramChatMessage = (RelativeLayout.LayoutParams)paramahmg.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
        paramChatMessage.width = agej.a(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
        paramahmg.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramahmg.jdField_a_of_type_Asre.a(), paramChatMessage.width, paramahmg.jdField_a_of_type_Asre.b());
        if (Build.VERSION.SDK_INT < 19)
        {
          paramChatMessage = (RelativeLayout.LayoutParams)paramahmg.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramahmg.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
          paramChatMessage.width = agej.a(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
          localLayoutParams.width = agej.a(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
        }
      }
      int i = paramahmg.jdField_a_of_type_Asre.c();
      int j = paramahmg.jdField_a_of_type_Asre.d();
      paramChatMessage = new bdor(i, 1, 1, agej.a(22.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      paramahmg.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(paramChatMessage);
      paramahmg.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.setDrawColor(i);
      paramahmg.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.postInvalidate();
      paramahmg.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(j);
      paramahmg.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(j);
    }
  }
  
  private void c(ahmg paramahmg)
  {
    paramahmg.jdField_a_of_type_Boolean = false;
    if ((2 != paramahmg.jdField_a_of_type_Asre.a.jobType) || (((MessageForMarketFace)paramahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null) || (!awzk.a())) {}
    for (;;)
    {
      return;
      Object localObject;
      if (!this.jdField_a_of_type_Askd.f(paramahmg.jdField_a_of_type_Asre.a.epId))
      {
        if (!asos.a())
        {
          paramahmg.f.setVisibility(8);
          return;
        }
        if ((!asos.c()) && (!this.jdField_a_of_type_Askd.a(paramahmg.jdField_a_of_type_Asre.a.epId, Boolean.valueOf(false))) && (-1.0F == this.jdField_a_of_type_Askd.a(paramahmg.jdField_a_of_type_Asre.a.epId)))
        {
          askc.a().a(this.jdField_a_of_type_Askq);
          localObject = new EmoticonPackage();
          ((EmoticonPackage)localObject).name = paramahmg.jdField_a_of_type_Asre.a.name;
          ((EmoticonPackage)localObject).epId = paramahmg.jdField_a_of_type_Asre.a.epId;
          ((EmoticonPackage)localObject).jobType = 3;
          ((EmoticonPackage)localObject).rscType = awxv.a(paramahmg.jdField_a_of_type_Asre.a.magicValue);
          ((EmoticonPackage)localObject).type = 1;
          ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
          ((axfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramahmg.jdField_a_of_type_Asre.a);
          this.jdField_a_of_type_JavaUtilList.add(paramahmg);
          paramahmg.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
          paramahmg.f.setVisibility(8);
          paramahmg.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((MessageForMarketFace)paramahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          this.jdField_a_of_type_Askd.a((EmoticonPackage)localObject, false);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongXiazai", 0, 0, paramahmg.jdField_a_of_type_Asre.a.epId, "", "", "");
        }
      }
      else
      {
        if (awxv.a(paramahmg.jdField_a_of_type_Asre.a.magicValue) == 1) {
          paramahmg.f.setVisibility(8);
        }
        while (((MessageForMarketFace)paramahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay)
        {
          ((MessageForMarketFace)paramahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          localObject = new Emoticon();
          ((Emoticon)localObject).eId = paramahmg.jdField_a_of_type_Asre.a.eId;
          ((Emoticon)localObject).epId = paramahmg.jdField_a_of_type_Asre.a.epId;
          ((Emoticon)localObject).magicValue = paramahmg.jdField_a_of_type_Asre.a.magicValue;
          ((Emoticon)localObject).jobType = paramahmg.jdField_a_of_type_Asre.a.jobType;
          if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() != null) && (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null) && (awzk.a())) {
            ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a((Emoticon)localObject, 1, ((MessageForMarketFace)paramahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage).senderuin, false);
          }
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramahmg.jdField_a_of_type_Asre.a.epId, "", "", "");
          return;
          if (!this.jdField_b_of_type_Boolean)
          {
            paramahmg.f.setImageResource(2130838014);
            paramahmg.f.setVisibility(0);
          }
        }
      }
    }
  }
  
  private void c(ChatMessage paramChatMessage, ahmg paramahmg)
  {
    if ((paramChatMessage.isFlowMessage) && (paramahmg.jdField_a_of_type_Asre.a.jobType == 0)) {
      if (!(this.jdField_b_of_type_AndroidContentContext instanceof MultiForwardActivity))
      {
        if (!paramChatMessage.isSend()) {
          break label56;
        }
        paramahmg.c.setImageResource(2130847114);
        paramahmg.c.setVisibility(0);
      }
    }
    label56:
    while ((!paramChatMessage.isDui) || (!DuiButtonImageView.jdField_a_of_type_Boolean) || (axug.a(paramChatMessage)))
    {
      return;
      paramahmg.d.setImageResource(2130847114);
      paramahmg.d.setVisibility(0);
      return;
    }
    paramahmg.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    if ((paramChatMessage.isSend()) || (paramahmg.jdField_a_of_type_Asre.b()))
    {
      paramahmg.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
      paramahmg.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      return;
    }
    if ((paramahmg.jdField_a_of_type_Asre != null) && (paramahmg.jdField_a_of_type_Asre.a != null) && ((2 == paramahmg.jdField_a_of_type_Asre.a.jobType) || (4 == paramahmg.jdField_a_of_type_Asre.a.jobType)))
    {
      paramahmg.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
      paramahmg.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      return;
    }
    if (!paramChatMessage.hasPlayedDui) {
      paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramahmg.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView);
    }
    while (DuiButtonImageView.jdField_a_of_type_Boolean)
    {
      paramahmg.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(this);
      paramahmg.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(0);
      return;
      paramahmg.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.f();
    }
    paramahmg.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(null);
    paramahmg.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
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
  
  private void d(ahmg paramahmg)
  {
    if ((paramahmg != null) && (paramahmg.jdField_a_of_type_Asre != null) && (paramahmg.jdField_a_of_type_Asre.c()) && (paramahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (!this.jdField_c_of_type_JavaUtilSet.contains(Long.valueOf(paramahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))))
    {
      axfj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AB51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramahmg.jdField_a_of_type_Asre.a.epId);
      this.jdField_c_of_type_JavaUtilSet.add(Long.valueOf(paramahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
    }
  }
  
  private void h(View paramView)
  {
    paramView = (ahmg)agej.a(paramView);
    EmoticonPackage localEmoticonPackage;
    if ((paramView.jdField_a_of_type_Asre != null) && (paramView.jdField_a_of_type_Asre.a != null) && (2 == paramView.jdField_a_of_type_Asre.a.jobType))
    {
      if (!this.jdField_a_of_type_Askd.a(paramView.jdField_a_of_type_Asre.a.epId, Boolean.valueOf(false)))
      {
        askc.a().a(this.jdField_a_of_type_Askq);
        localEmoticonPackage = new EmoticonPackage();
        localEmoticonPackage.name = paramView.jdField_a_of_type_Asre.a.name;
        localEmoticonPackage.epId = paramView.jdField_a_of_type_Asre.a.epId;
        localEmoticonPackage.jobType = 3;
        localEmoticonPackage.type = 1;
        localEmoticonPackage.isMagicFaceDownloading = true;
        paramView.jdField_a_of_type_Boolean = false;
        ((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
        ((axfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramView.jdField_a_of_type_Asre.a);
        this.jdField_a_of_type_JavaUtilList.add(paramView);
        paramView.f.setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_Askd.a(localEmoticonPackage, false);
        bdll.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongBofang", 0, 0, paramView.jdField_a_of_type_Asre.a.epId, "", "", "");
      }
    }
    else if ((paramView.jdField_a_of_type_Asre != null) && (paramView.jdField_a_of_type_Asre.a != null) && (4 == paramView.jdField_a_of_type_Asre.a.jobType) && (System.currentTimeMillis() - this.jdField_d_of_type_Long > 3000L) && (this.jdField_a_of_type_Askd.a()))
    {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      if (!this.jdField_a_of_type_Askd.a(paramView.jdField_a_of_type_Asre.a.epId, true, true)) {
        break label474;
      }
      a(paramView, "0");
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbFasong", "MbZhudongBofang", 0, 0, paramView.jdField_a_of_type_Asre.a.epId, "", "", "");
      return;
      if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (!awzk.a()) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null)) {
        break;
      }
      ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a(paramView.jdField_a_of_type_Asre.a, 1, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, true);
      break;
      label474:
      askc.a().a(this.jdField_a_of_type_Askq);
      localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramView.jdField_a_of_type_Asre.a.name;
      localEmoticonPackage.epId = paramView.jdField_a_of_type_Asre.a.epId;
      localEmoticonPackage.jobType = 5;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      paramView.jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      ((axfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramView.jdField_a_of_type_Asre.a);
      this.jdField_a_of_type_JavaUtilList.add(paramView);
      paramView.f.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_Askd.a(localEmoticonPackage, false);
    }
  }
  
  private void i(View paramView)
  {
    boolean bool = true;
    Object localObject = (ahmg)agej.a(paramView);
    QQAppInterface localQQAppInterface;
    int i;
    if ((((ahmg)localObject).jdField_a_of_type_Asre != null) && (((ahmg)localObject).jdField_a_of_type_Asre.b()) && (((ahmg)localObject).jdField_a_of_type_Asre.c()))
    {
      if (!c(((ahmg)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
        break label119;
      }
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (((ahmg)localObject).jdField_a_of_type_Asre.a == null) {
        break label112;
      }
    }
    label112:
    for (paramView = ((ahmg)localObject).jdField_a_of_type_Asre.a.epId;; paramView = "")
    {
      axfj.a(localQQAppInterface, "0X800A934", i, paramView);
      return;
    }
    label119:
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694616, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      return;
    }
    if ((((ahmg)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMarketFace)) {
      ((MessageForMarketFace)((ahmg)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage).playProgress = 0.0F;
    }
    ((ahmg)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
    if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((ahmg)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage))
    {
      ((ahmg)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (((ahmg)localObject).jdField_a_of_type_Asre.a != null)
      {
        paramView = ((ahmg)localObject).jdField_a_of_type_Asre.a.epId;
        axfj.a(localQQAppInterface, "0X800A933", i, paramView);
      }
    }
    for (;;)
    {
      if (!bool)
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (((ahmg)localObject).jdField_a_of_type_Asre.a != null)
        {
          paramView = ((ahmg)localObject).jdField_a_of_type_Asre.a.epId;
          label300:
          axfj.a(localQQAppInterface, "0X800A935", -1, paramView);
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
        bdmc.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "NewAudioEmoticonVoicePlay", bool, 0L, 0L, (HashMap)localObject, null);
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
    ahmg localahmg = (ahmg)agej.a(paramView);
    Drawable localDrawable = localahmg.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
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
        if ((localahmg.jdField_a_of_type_Asre != null) && (localahmg.jdField_a_of_type_Asre.a != null) && (localahmg.jdField_a_of_type_Asre.a.jobType == 2) && (awzk.a())) {
          a(localahmg);
        }
        if ((((URLDrawable)localDrawable).getStatus() == 1) || ((localahmg.jdField_a_of_type_Asre != null) && (localahmg.jdField_a_of_type_Asre.a != null) && (localahmg.jdField_a_of_type_Asre.e()))) {
          a(localahmg, abke.a(paramView));
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
        a(localahmg, localURLDrawable, str);
        localahmg.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        if ((localahmg.jdField_a_of_type_Asre == null) || (!localahmg.jdField_a_of_type_Asre.b()) || (!"big_sound".equals(localObject))) {
          break;
        }
        jdField_c_of_type_Long = localahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
        break;
        if ((localahmg.jdField_a_of_type_Asre == null) || (localahmg.jdField_a_of_type_Asre.a == null) || (localahmg.jdField_a_of_type_Asre.a.jobType == 0) || (localahmg.jdField_a_of_type_Asre.a.jobType == 2) || (localahmg.jdField_a_of_type_Asre.a.jobType == 4)) {
          break;
        }
        localahmg.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        if ("big_sound".equals(localObject))
        {
          if ((localahmg.jdField_a_of_type_Asre.a == null) || (!localahmg.jdField_a_of_type_Asre.a.isSound)) {
            break;
          }
          if (c(localahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
          {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694616, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
            break;
          }
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
          break;
        }
        if (!"aio_preview".equals(localObject)) {
          break;
        }
        localObject = localahmg.jdField_a_of_type_Asre.a("fromAIO", true);
        if (localObject == null) {
          break;
        }
        localahmg.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        localahmg.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        a(localahmg, (URLDrawable)localObject);
        if (!localahmg.jdField_a_of_type_Asre.b()) {
          break;
        }
        jdField_c_of_type_Long = localahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
        break;
      } while ((!(localDrawable instanceof awxl)) || (localahmg.jdField_a_of_type_Asre == null) || (localahmg.jdField_a_of_type_Asre.a == null) || (!localahmg.jdField_a_of_type_Asre.e()));
      a(localahmg, abke.a(paramView));
      return;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aggl a()
  {
    return new ahmg();
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    long l = System.currentTimeMillis();
    paramBaseChatItemLayout = (MessageForMarketFace)paramChatMessage;
    ahmg localahmg = (ahmg)paramaggl;
    this.jdField_b_of_type_JavaUtilSet.add(localahmg);
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
      paramaggl = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject2 = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout)localObject2).setId(2131370623);
      paramView = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      paramView.setId(2131366904);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131364423);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131364423);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setOnClickListener(this);
      localObject1 = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).setId(2131363418);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = 8;
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131366904);
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      ((FrameLayout)localObject1).setOnClickListener(this);
      ((FrameLayout)localObject1).setOnTouchListener(paramagjk);
      ((FrameLayout)localObject1).setOnLongClickListener(paramagjk);
      paramagjk = new ahmh(this, this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).addView(paramagjk, -2, -2);
      localObject4 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localObject5 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject5).gravity = 85;
      ((FrameLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject5).setId(2131381215);
      localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(1, 2131363418);
      ((RelativeLayout.LayoutParams)localObject6).addRule(8, 2131363418);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      ((ImageView)localObject5).setOnClickListener(this);
      localObject6 = new BreathAnimationLayout(this.jdField_b_of_type_AndroidContentContext);
      ((BreathAnimationLayout)localObject6).setId(2131371771);
      localPttAudioPlayView = new PttAudioPlayView(this.jdField_b_of_type_AndroidContentContext, 10);
      localPttAudioPlayView.setThemeColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131167009).getDefaultColor());
      localPttAudioPlayView.setId(2131371773);
      localPttAudioPlayView.setPttPauseOrStopDrawable(2130838205);
      localObject7 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject7).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject7).leftMargin = agej.a(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).width = agej.a(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).height = agej.a(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      localPttAudioPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject7);
      localPttAudioPlayView.setOnClickListener(this);
      localObject7 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localObject8 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject8).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject8).leftMargin = agej.a(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).width = agej.a(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).height = agej.a(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((ImageView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
      ((ImageView)localObject7).setImageDrawable((Drawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839408));
      ((ImageView)localObject7).setVisibility(4);
      localObject8 = new PttAudioWaveView(this.jdField_b_of_type_AndroidContentContext);
      ((PttAudioWaveView)localObject8).setShowProgressLine(false);
      ((PttAudioWaveView)localObject8).setMaxTopBottomPadding(4);
      ((PttAudioWaveView)localObject8).setProgressColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131167009).getDefaultColor());
      ((PttAudioWaveView)localObject8).setId(2131371774);
      localObject9 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(1, 2131371773);
      ((RelativeLayout.LayoutParams)localObject9).width = agej.a(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).height = agej.a(45.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).leftMargin = bhtq.a(9.0F);
      ((RelativeLayout.LayoutParams)localObject9).rightMargin = bhtq.a(12.0F);
      ((PttAudioWaveView)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
      ((PttAudioWaveView)localObject8).setCanSupportSlide(false);
      ((PttAudioWaveView)localObject8).setOnClickListener(this);
      localObject9 = new SyncParentPressedRelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      ((RelativeLayout)localObject9).setId(2131371772);
      ((RelativeLayout)localObject9).addView((View)localObject8);
      ((RelativeLayout)localObject9).addView(localPttAudioPlayView);
      ((RelativeLayout)localObject9).addView((View)localObject7);
      localRelativeLayout = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localTriangleView = new TriangleView(this.jdField_b_of_type_AndroidContentContext);
      localObject10 = new RelativeLayout.LayoutParams(bhtq.a(9.0F), bhtq.a(5.0F));
      ((RelativeLayout.LayoutParams)localObject10).leftMargin = bhtq.a(2.0F);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14);
      ((RelativeLayout.LayoutParams)localObject10).addRule(10);
      localTriangleView.setId(2131372797);
      localTriangleView.setRotation(180.0F);
      localTriangleView.setTranslationY(bhtq.a(1.0F));
      localTriangleView.setLayoutParams((ViewGroup.LayoutParams)localObject10);
      localRelativeLayout.addView(localTriangleView);
      localObject10 = new RelativeLayout.LayoutParams(-2, bhtq.a(29.0F));
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131372797);
      localRelativeLayout.addView((View)localObject9, (ViewGroup.LayoutParams)localObject10);
      ((BreathAnimationLayout)localObject6).addView(localRelativeLayout);
      localObject10 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14, 2131363418);
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131363418);
      ((RelativeLayout.LayoutParams)localObject10).bottomMargin = bhtq.a(17.0F);
      ((RelativeLayout)localObject2).addView((View)localObject6, (ViewGroup.LayoutParams)localObject10);
      localObject10 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject10).setId(2131366905);
      localObject11 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject11).addRule(1, 2131363418);
      ((RelativeLayout.LayoutParams)localObject11).addRule(15, 2131363418);
      ((RelativeLayout.LayoutParams)localObject11).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject10, (ViewGroup.LayoutParams)localObject11);
      ((ImageView)localObject10).setOnClickListener(this);
      localObject11 = new DuiButtonImageView(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      ((DuiButtonImageView)localObject11).setId(2131365781);
      localObject12 = new RelativeLayout.LayoutParams(agej.a(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), agej.a(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject12).addRule(1, 2131363418);
      ((RelativeLayout.LayoutParams)localObject12).addRule(8, 2131363418);
      ((RelativeLayout.LayoutParams)localObject12).setMargins(0, 0, 0, -agej.a(6.5F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout)localObject2).addView((View)localObject11, (ViewGroup.LayoutParams)localObject12);
      localObject12 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject12).setId(2131370536);
      localObject13 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject13).addRule(1, 2131363418);
      ((RelativeLayout.LayoutParams)localObject13).addRule(8, 2131363418);
      ((RelativeLayout.LayoutParams)localObject13).leftMargin = agej.a(10.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout)localObject2).addView((View)localObject12, (ViewGroup.LayoutParams)localObject13);
      localObject13 = new TextView(this.jdField_b_of_type_AndroidContentContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      ((TextView)localObject13).setTextSize(12.0F);
      ((TextView)localObject13).setTextColor(-1);
      localLayoutParams.topMargin = agej.a(8.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((TextView)localObject13).setGravity(17);
      localLayoutParams.addRule(3, 2131370623);
    }
    for (;;)
    {
      try
      {
        ((TextView)localObject13).setBackgroundDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130844785));
        ((TextView)localObject13).setPadding(agej.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), agej.a(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), agej.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), agej.a(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
        paramaggl.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramaggl.addView((View)localObject13, localLayoutParams);
        ((ImageView)localObject12).setOnClickListener(this);
        localObject2 = new ProgressBar(this.jdField_b_of_type_AndroidContentContext, null, 0);
        ((ProgressBar)localObject2).setId(2131364450);
      }
      catch (Exception localException2)
      {
        try
        {
          ((ProgressBar)localObject2).setIndeterminateDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839410));
          int i = agej.a(16.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
          localObject3 = new FrameLayout.LayoutParams(i, i);
          ((FrameLayout.LayoutParams)localObject3).gravity = 17;
          ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          localahmg.jdField_e_of_type_AndroidWidgetImageView = paramagjk;
          localahmg.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject4);
          localahmg.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject5);
          localahmg.c = paramView;
          localahmg.d = ((ImageView)localObject10);
          localahmg.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView = ((DuiButtonImageView)localObject11);
          localahmg.f = ((ImageView)localObject12);
          localahmg.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localObject1);
          localahmg.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject2);
          localahmg.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject13);
          localahmg.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)localObject6);
          localahmg.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = localPttAudioPlayView;
          localahmg.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject8);
          localahmg.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject9);
          localahmg.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
          localahmg.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView = localTriangleView;
          localahmg.g = ((ImageView)localObject7);
          if (!c(paramChatMessage)) {
            paramBaseChatItemLayout.playProgress = 0.0F;
          }
          a(localahmg, paramChatMessage.uniseq);
          localahmg.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          localahmg.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramBaseChatItemLayout.playProgress);
          if ((AppSetting.c) && (a(paramChatMessage, localahmg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) && (localahmg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)) {
            localahmg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setContentDescription(anzj.a(2131705360));
          }
          new QueryTask(new ahlz(this, localahmg), new ahma(this, localahmg, paramBaseChatItemLayout, paramChatMessage, l)).a(paramBaseChatItemLayout.mMarkFaceMessage);
          return paramaggl;
          localException2 = localException2;
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException2);
        }
        catch (Exception localException1)
        {
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException1);
          continue;
        }
      }
      if ((localahmg.jdField_a_of_type_Asre != null) && (localahmg.jdField_a_of_type_Asre.b()) && (localahmg.jdField_b_of_type_AndroidWidgetImageView != null) && ((localahmg.jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof AnimationDrawable))) {
        localahmg.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847134);
      }
      paramaggl = paramView;
      if (AppSetting.c)
      {
        localahmg.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        paramaggl = paramView;
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (!bhnt.a(paramChatMessage.issend)) {
        break label103;
      }
      localStringBuilder.append("发出表情");
    }
    for (;;)
    {
      paramChatMessage = (MessageForMarketFace)paramChatMessage;
      if (paramChatMessage.mMarkFaceMessage != null)
      {
        paramChatMessage = ((axfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramChatMessage.mMarkFaceMessage);
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
    askc.a().b(this.jdField_a_of_type_Askq);
    askc.a().b(this.jdField_a_of_type_Ahmf);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((ahmg)localIterator.next()).a();
    }
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((jdField_a_of_type_Asre == null) || (jdField_a_of_type_Asre.a == null))
    {
      QLog.e("MarketFaceItemBuilder", 1, "onMenuItemClicked emoticon is null");
      return;
    }
    if ((paramInt == 2131365352) || (paramInt == 2131362195) || (paramInt == 2131367095) || (paramInt == 2131366803) || (paramInt == 2131371486))
    {
      a(paramInt, paramChatMessage);
      return;
    }
    if (paramInt == 2131371530)
    {
      super.d(paramChatMessage);
      return;
    }
    if (paramInt == 2131371487)
    {
      super.a(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    ((axfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(jdField_a_of_type_Asre.a.epId, new ahly(this, paramInt, paramChatMessage));
  }
  
  void a(ahmg paramahmg, URLDrawable paramURLDrawable)
  {
    a(paramahmg, paramURLDrawable, "");
  }
  
  void a(ahmg paramahmg, URLDrawable paramURLDrawable, String paramString)
  {
    paramahmg.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramahmg.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
    paramahmg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramahmg.f.setVisibility(8);
    paramahmg.jdField_b_of_type_Boolean = false;
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
        if (paramahmg.jdField_a_of_type_Asre.b()) {
          if (paramahmg.jdField_a_of_type_Asre.c()) {
            paramahmg.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          }
        }
      }
      while (!"big_sound".equals(str))
      {
        do
        {
          return;
          paramahmg.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847134);
          paramahmg.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        } while ((i != 1) || (paramahmg.jdField_a_of_type_Asre.j != 3));
        paramahmg.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838011);
        paramahmg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramahmg.jdField_b_of_type_Boolean = true;
        return;
      }
      if (c(paramahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
      {
        if (paramahmg.jdField_a_of_type_Asre.c())
        {
          paramahmg.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          paramahmg.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          return;
        }
        paramahmg.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramURLDrawable = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772269);
        paramahmg.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
        paramURLDrawable.start();
        return;
      }
      if (paramahmg.jdField_a_of_type_Asre.c())
      {
        paramahmg.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
        paramahmg.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
        return;
      }
      paramahmg.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847134);
      paramahmg.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
  }
  
  public void a(View paramView)
  {
    paramView = (ahmg)agej.a(paramView);
    String str1;
    String str2;
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSendFromLocal())
    {
      str1 = this.jdField_b_of_type_AndroidContentContext.getString(2131689933);
      str2 = this.jdField_b_of_type_AndroidContentContext.getString(2131689934);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 41) && (paramView.jdField_a_of_type_Asre != null) && (paramView.jdField_a_of_type_Asre.a != null)) {
        a((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_Asre);
      }
    }
    do
    {
      return;
      bhlq.a(this.jdField_b_of_type_AndroidContentContext, 230, str1, str2, new ahmd(this, paramView), new ahme(this)).show();
      return;
      paramView = paramView.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
    } while (!(paramView instanceof URLDrawable));
    ((URLDrawable)paramView).restartDownload();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, bdep.a(10.0F), 0);
  }
  
  protected void a(bhuk parambhuk)
  {
    if ((jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (jdField_a_of_type_Asre.a == null)) {}
    label135:
    for (;;)
    {
      return;
      if (jdField_a_of_type_Asre.a.jobType == 0) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (!asos.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
          break label135;
        }
        arbl localarbl = arbk.a();
        if ((localarbl == null) || (!localarbl.a())) {
          break;
        }
        parambhuk.a(2131371486, this.jdField_b_of_type_AndroidContentContext.getString(2131717424), 2130838945);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X800B114", "0X800B114", asos.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, "", "", "", "");
        return;
      }
    }
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, String paramString, int paramInt)
  {
    bjbs localbjbs = a();
    if (localbjbs != null)
    {
      localbjbs.a(this.jdField_b_of_type_AndroidContentContext.getString(2131691747));
      localbjbs.show();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect", 0);
    if ((jdField_a_of_type_Asre != null) && (jdField_a_of_type_Asre.a != null)) {
      asos.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null, jdField_a_of_type_Asre.a.eId);
    }
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", paramString, paramInt + "", "");
    QQAppInterface localQQAppInterface;
    if ((jdField_a_of_type_Asre != null) && (jdField_a_of_type_Asre.c()))
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (jdField_a_of_type_Asre.a == null) {
        break label268;
      }
    }
    label268:
    for (paramString = jdField_a_of_type_Asre.a.epId;; paramString = "")
    {
      axfj.a(localQQAppInterface, "0X800A939", paramInt, paramString);
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
    a(6, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_a_of_type_Asre, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localbjbs);
    return;
    label299:
    a(6);
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, String paramString, int paramInt1, int paramInt2)
  {
    bjbs localbjbs = a();
    if (paramInt2 == 2131367095)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "aio_trans_bq", 0, 0, "4", paramString, paramInt1 + "", "");
      if ((2 == jdField_a_of_type_Asre.a.jobType) && (!this.jdField_a_of_type_Askd.c()))
      {
        ChatActivityUtils.a(this.jdField_b_of_type_AndroidContentContext, 2131689932, 0);
        return;
      }
      jdField_c_of_type_Int = 1;
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_button_forward_aio", 0);
      paramString = this.jdField_b_of_type_AndroidContentContext.getString(2131691750);
    }
    for (paramInt1 = 7;; paramInt1 = 107)
    {
      if (localbjbs != null)
      {
        localbjbs.a(paramString);
        localbjbs.show();
      }
      if (paramEmoticonPackage != null) {
        break;
      }
      a(paramInt1);
      return;
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006449", "0X8006449", 0, 0, "4", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((bgsl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean))
      {
        ChatActivityUtils.a(this.jdField_b_of_type_AndroidContentContext, 2131696725, 0);
        return;
      }
      paramString = this.jdField_b_of_type_AndroidContentContext.getString(2131691749);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ep_mall", "Clk_button_follow_aio", 0, 0, "", jdField_a_of_type_Asre.a.epId, "", "");
    }
    a(paramInt1, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_a_of_type_Asre, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localbjbs);
  }
  
  protected void a(MessageForMarketFace paramMessageForMarketFace, asre paramasre)
  {
    if ((paramMessageForMarketFace == null) || (paramasre == null) || (paramasre.a == null) || (paramasre.a.epId == null)) {
      return;
    }
    blir localblir = (blir)blji.a(this.jdField_b_of_type_AndroidContentContext, null);
    localblir.a(this.jdField_b_of_type_AndroidContentContext.getString(2131691745));
    localblir.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131691744), 1);
    localblir.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131691746), 1);
    localblir.c(2131690580);
    localblir.a(new ahlv(this, paramasre, localblir, paramMessageForMarketFace));
    localblir.show();
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if ((paramView != null) && (paramFloat > 0.0F))
    {
      paramXListView = (ahmg)agej.a(paramView);
      if ((paramXListView != null) && (paramXListView.jdField_a_of_type_Asre != null) && (paramXListView.jdField_a_of_type_Asre.b()) && (paramXListView.jdField_a_of_type_Asre.c()) && (c(paramChatMessage)))
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
      paramXListView = (ahmg)agej.a(paramView);
      if (!paramXListView.jdField_a_of_type_Asre.c()) {
        break label66;
      }
      paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
        paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
      }
    }
    for (;;)
    {
      paramView = paramXListView.jdField_a_of_type_Asre.a("fromAIO", false);
      paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      return;
      label66:
      paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847134);
    }
  }
  
  public boolean a(aggl paramaggl)
  {
    return paramaggl instanceof ahmg;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (ahmg)agej.a(paramView);
    if ((paramXListView == null) || (paramXListView.jdField_a_of_type_Asre == null) || (paramXListView.jdField_a_of_type_Asre.a == null)) {
      return false;
    }
    if (paramXListView.jdField_a_of_type_Asre.b())
    {
      paramView = asos.o.replace("[epId]", paramXListView.jdField_a_of_type_Asre.a.epId).replace("[eId]", paramXListView.jdField_a_of_type_Asre.a.eId);
      if (!bhmi.b(paramView))
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
        paramView = paramXListView.jdField_a_of_type_Asre.a("fromAIO", true);
        paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        asre.a(paramView);
        if (paramXListView.jdField_a_of_type_Asre.c()) {
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
  
  public bhum[] a(View paramView)
  {
    paramView = (ahmg)agej.a(paramView);
    bhuk localbhuk = new bhuk();
    jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (ApolloUtil.a(jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
      return localbhuk.a();
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
        if (paramView.jdField_a_of_type_Asre.a.jobType != 1)
        {
          jdField_a_of_type_Asre = paramView.jdField_a_of_type_Asre;
          if (agej.a(1) == 1) {
            localbhuk.a(2131362195, this.jdField_b_of_type_AndroidContentContext.getString(2131692954), 2130838937);
          }
          a(localbhuk);
          localbhuk.a(2131367095, this.jdField_b_of_type_AndroidContentContext.getString(2131692400), 2130838939);
          a(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbhuk);
          if ((paramView.jdField_a_of_type_Asre.a.jobType != 2) && (paramView.jdField_a_of_type_Asre.a.jobType != 4)) {
            localbhuk.a(2131366803, this.jdField_b_of_type_AndroidContentContext.getString(2131692961), 2130838919);
          }
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Ap_show_forward", 0);
        }
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
          a(localbhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        a(localbhuk, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        super.a(localbhuk, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        if (paramView.jdField_a_of_type_Asre.a.jobType != 1) {
          b(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbhuk);
        }
        super.c(localbhuk, this.jdField_b_of_type_AndroidContentContext);
        super.e(localbhuk, this.jdField_b_of_type_AndroidContentContext);
      }
      for (;;)
      {
        return localbhuk.a();
        jdField_a_of_type_Asre = paramView.jdField_a_of_type_Asre;
        aean.a(localbhuk, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
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
    agej.n = true;
    if (super.a()) {
      return;
    }
    if (paramView.getId() == 2131363418)
    {
      j(paramView);
      return;
    }
    if (paramView.getId() == 2131381215) {
      g(paramView);
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      if ((paramView.getId() == 2131371773) || (paramView.getId() == 2131371774)) {
        i(paramView);
      } else if ((paramView.getId() == 2131366905) || (paramView.getId() == 2131366904)) {
        f(paramView);
      } else if (paramView.getId() == 2131365781) {
        e();
      } else if (paramView.getId() == 2131370536) {
        h(paramView);
      }
    }
  }
  
  protected void f(View paramView)
  {
    paramView = (ahmg)agej.a(paramView);
    bjbs localbjbs = a();
    if (localbjbs != null)
    {
      localbjbs.a(this.jdField_b_of_type_AndroidContentContext.getString(2131691749));
      localbjbs.show();
    }
    ((axfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramView.jdField_a_of_type_Asre.a.epId, new ahlu(this, paramView, localbjbs));
  }
  
  protected void g(View paramView)
  {
    paramView = (ahmg)agej.a(paramView);
    if ((paramView.jdField_a_of_type_Asre != null) && (paramView.jdField_a_of_type_Asre.b()))
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
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694616, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
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
        ((agti)((BaseChatPie)localObject).a(72)).a(paramChatMessage, jdField_a_of_type_Asre.a("fromAIO", false));
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
 * Qualified Name:     ahlt
 * JD-Core Version:    0.7.0.1
 */