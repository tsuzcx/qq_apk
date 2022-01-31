import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.10;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.14;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.15;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.16;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.17;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.18;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.8;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.aio.item.SyncParentPressedRelativeLayout;
import com.tencent.mobileqq.activity.contact.newfriend.connections.TriangleView;
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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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

public class adug
  extends BaseBubbleBuilder
  implements acxj
{
  public static aobk a;
  public static ChatMessage a;
  public static int c;
  static long jdField_c_of_type_Long;
  adut jdField_a_of_type_Adut = new adut();
  public anvs a;
  anwf jdField_a_of_type_Anwf = new adus(this);
  public List<aduu> a;
  public Set<Long> a;
  public Context b;
  Set<aduu> b;
  Set<Long> jdField_c_of_type_JavaUtilSet = new ArraySet();
  public int d;
  private long d;
  public int e;
  public boolean f = false;
  
  static
  {
    jdField_c_of_type_Int = 1;
  }
  
  public adug(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_d_of_type_Int = 320;
    this.jdField_e_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Anvs = ((anvs)paramQQAppInterface.getManager(43));
    if ((this.jdField_b_of_type_AndroidContentContext instanceof SplashActivity)) {
      this.f = true;
    }
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, Handler paramHandler)
  {
    boolean bool = true;
    ansr localansr = (ansr)paramQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("MarketFaceItemBuilder", 2, "Call getEmoticonDataList from addEmotionToFavorite.");
    }
    List localList = localansr.a();
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
          if (localansr.a(localCustomEmotionData, j))
          {
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramHandler != null) {
              paramHandler.post(new MarketFaceItemBuilder.17(paramContext));
            }
            askd.c("0", 1);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
            }
            return 0;
          }
          if (paramHandler != null) {
            paramHandler.post(new MarketFaceItemBuilder.18(paramContext));
          }
          askd.c("2003", 1);
          return 0;
        }
        n = i;
        if (i < localCustomEmotionData.emoId) {
          n = localCustomEmotionData.emoId;
        }
        j += 1;
        m = k;
      }
      if (m >= ansp.a) {
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
      paramEmoticon = ((askd)paramQQAppInterface.getManager(14)).a(paramEmoticon.epId);
      if (paramEmoticon != null) {
        if (paramEmoticon.isAPNG != 2) {
          break label425;
        }
      }
      for (;;)
      {
        paramHandler.isAPNG = bool;
        paramEmoticon = (anss)paramQQAppInterface.getManager(103);
        if (paramEmoticon != null) {
          paramEmoticon.b(paramHandler, new ansa(paramQQAppInterface, paramContext, paramHandler, null, 0));
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
      i = 2131690988;
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
      paramInt = 2131690989;
      paramString2 = ajyc.a(2131706469);
      continue;
      paramString2 = ajyc.a(2131706464);
      paramInt = i;
      continue;
      paramString2 = ajyc.a(2131706461);
      paramInt = i;
      continue;
      paramString2 = ajyc.a(2131706471);
      paramInt = i;
    }
  }
  
  private bcpq a()
  {
    if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a == null) {
        ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a = new bcpq(this.jdField_b_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a;
    }
    return null;
  }
  
  private String a()
  {
    try
    {
      i = bbev.a(this.jdField_b_of_type_AndroidContentContext);
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
    this.jdField_a_of_type_Adut.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_Aobk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a());
    anvr.a().a(this.jdField_a_of_type_Adut);
    this.jdField_a_of_type_Anvs.a(jdField_a_of_type_Aobk.a.epId, anvs.jdField_c_of_type_Int);
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
            aqbc.a((BaseActivity)paramContext, paramEmoticon, 21, 100500, "biz_src_jc_gif");
            return;
          }
          catch (Exception paramContext) {}
        } while (!QLog.isColorLevel());
        QLog.e("EmosmDetailActivity.operateMarketFaceFromDownLoad", 2, paramContext.getMessage());
        return;
        if (6 == paramInt1 % 1000)
        {
          ThreadManager.post(new MarketFaceItemBuilder.14(paramContext, paramQQAppInterface, paramEmoticon, localHandler), 5, null, true);
          return;
        }
      } while (107 != paramInt1 % 1000);
      axqw.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_follow_send_aio", 0, 0, "", paramEmoticon.epId, "", "");
      aobk.a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, null);
      return;
      if (paramInt2 < 0)
      {
        localHandler.post(new MarketFaceItemBuilder.15(paramContext, paramString));
        if (6 == paramInt1 % 1000) {
          askd.c("2001", 1);
        }
        QLog.i("MarketFaceItemBuilder", 1, "opType: " + paramInt1 + ",result:" + paramInt2);
        return;
      }
      localHandler.post(new MarketFaceItemBuilder.16(paramInt1, paramContext, paramQQAppInterface, paramEmoticon, paramString));
    } while (6 != paramInt1 % 1000);
    askd.c("2002", 1);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, aobk paramaobk, SessionInfo paramSessionInfo, bcpq parambcpq)
  {
    a(paramInt, paramContext, paramQQAppInterface, paramEmoticonPackage, paramaobk, paramSessionInfo, parambcpq, false);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, aobk paramaobk, SessionInfo paramSessionInfo, bcpq parambcpq, boolean paramBoolean)
  {
    if (paramaobk == null) {
      return;
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.mobileFeetype == 1))
    {
      if ((parambcpq != null) && (parambcpq.isShowing())) {
        parambcpq.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramaobk.a, 0, null, paramSessionInfo, paramBoolean);
      return;
    }
    if ((!bbev.g(paramContext)) || (paramInt > 1000))
    {
      if ((parambcpq != null) && (parambcpq.isShowing())) {
        parambcpq.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramaobk.a, -404, ajyc.a(2131706468), paramSessionInfo, paramBoolean);
      return;
    }
    ((ajvp)paramQQAppInterface.a(12)).a(paramInt, Integer.valueOf(paramaobk.a.epId).intValue(), paramaobk.a.eId);
  }
  
  private void a(aduu paramaduu)
  {
    EmoticonPackage localEmoticonPackage;
    if (!this.jdField_a_of_type_Anvs.a(paramaduu.jdField_a_of_type_Aobk.a.epId, Boolean.valueOf(false)))
    {
      anvr.a().a(this.jdField_a_of_type_Anwf);
      localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramaduu.jdField_a_of_type_Aobk.a.name;
      localEmoticonPackage.epId = paramaduu.jdField_a_of_type_Aobk.a.epId;
      localEmoticonPackage.jobType = 3;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      if (paramaduu.jdField_e_of_type_Int != -1) {
        break label222;
      }
    }
    label222:
    for (localEmoticonPackage.rscType = ascj.a(paramaduu.jdField_a_of_type_Aobk.a.magicValue);; localEmoticonPackage.rscType = paramaduu.jdField_e_of_type_Int)
    {
      ((askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramaduu.jdField_a_of_type_Aobk.a);
      paramaduu.jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)paramaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = true;
      this.jdField_a_of_type_JavaUtilList.add(paramaduu);
      paramaduu.f.setVisibility(8);
      paramaduu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_Anvs.a(localEmoticonPackage, false);
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void a(aduu paramaduu, long paramLong)
  {
    Animatable localAnimatable = (Animatable)paramaduu.g.getDrawable();
    if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramLong)))
    {
      if (!localAnimatable.isRunning()) {
        localAnimatable.start();
      }
      paramaduu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(4);
      paramaduu.g.setVisibility(0);
      return;
    }
    if (localAnimatable.isRunning()) {
      localAnimatable.stop();
    }
    paramaduu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
    paramaduu.g.setVisibility(4);
  }
  
  private void a(aduu paramaduu, Rect paramRect)
  {
    AIOEmotionFragment.a(this.jdField_b_of_type_AndroidContentContext, paramaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramRect);
  }
  
  private void a(aduu paramaduu, String paramString)
  {
    ThreadManager.post(new MarketFaceItemBuilder.8(this, paramString, paramaduu), 5, null, true);
  }
  
  private void a(aobk paramaobk, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      str2 = a();
      if (paramaobk == null) {}
      for (paramaobk = "";; paramaobk = paramaobk.a.epId)
      {
        VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramaobk, paramString);
        return;
      }
    case 3: 
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramaobk == null) {}
      for (paramaobk = "";; paramaobk = paramaobk.a.epId)
      {
        axqw.b(paramString, "CliOper", "", "", "ep_mall", "0X8007187", 0, 0, paramaobk, "", "", "");
        return;
      }
    }
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    String str2 = a();
    if (paramaobk == null) {}
    for (paramaobk = "";; paramaobk = paramaobk.a.epId)
    {
      VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramaobk, paramString, "1", "", "", "", 0, 0, 0, 0);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    axqw.b(paramQQAppInterface, "CliOper", "", "", paramString2, paramString3, paramInt, 0, "", "", "", "");
  }
  
  private void a(ChatMessage paramChatMessage, aduu paramaduu)
  {
    a(paramChatMessage, paramaduu, "");
  }
  
  private void a(ChatMessage paramChatMessage, aduu paramaduu, String paramString)
  {
    if ((paramaduu.jdField_a_of_type_Aobk.b()) && (!c(paramChatMessage))) {}
    for (boolean bool = false;; bool = true)
    {
      Object localObject3 = paramaduu.jdField_a_of_type_Aobk.a("fromAIO", bool);
      Object localObject1 = "";
      Object localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (((URLDrawable)localObject3).getStatus() == 1)
        {
          if ((((URLDrawable)localObject3).getStateTag() instanceof Bundle)) {
            localObject1 = ((Bundle)((URLDrawable)localObject3).getStateTag()).getString("display_type");
          }
          localObject2 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = localObject1;
            if (((String)localObject1).equals("aio_preview"))
            {
              localObject2 = paramaduu.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
              if ((localObject2 != null) && (((EmoticonPackage)localObject2).status == 2))
              {
                URLDrawable.removeMemoryCacheByUrl(((URLDrawable)localObject3).getURL().toString());
                localObject2 = paramaduu.jdField_a_of_type_Aobk.a("fromAIO", bool);
                paramString = (String)localObject1;
                localObject1 = localObject2;
              }
            }
          }
        }
      }
      for (;;)
      {
        int j;
        label201:
        int m;
        label219:
        int k;
        int n;
        if ((localObject1 != null) && (paramaduu.jdField_a_of_type_Aobk.a != null)) {
          if (paramaduu.jdField_a_of_type_Aobk.a.width == 0)
          {
            j = 200;
            if (paramaduu.jdField_a_of_type_Aobk.a.height != 0) {
              break label673;
            }
            m = 200;
            k = j;
            i = m;
            if (paramaduu.jdField_a_of_type_Aobk.a.extensionWidth != 0)
            {
              k = j;
              i = m;
              if (paramaduu.jdField_a_of_type_Aobk.a.extensionHeight != 0)
              {
                k = paramaduu.jdField_a_of_type_Aobk.a.extensionWidth;
                i = paramaduu.jdField_a_of_type_Aobk.a.extensionHeight;
              }
            }
            j = k;
            if (k != i) {
              j = i;
            }
            n = (j * this.jdField_e_of_type_Int + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
            i = (this.jdField_e_of_type_Int * i + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
            paramaduu.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(n, i));
            localObject2 = paramaduu.jdField_a_of_type_AndroidWidgetTextView.getTag();
            if (!(localObject2 instanceof Integer)) {
              break label1531;
            }
          }
        }
        label673:
        label1511:
        label1531:
        for (int i = ((Integer)localObject2).intValue();; i = -1)
        {
          if ((paramaduu.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (i != -1))
          {
            localObject3 = (String)paramaduu.jdField_a_of_type_AndroidWidgetTextView.getTag(2131363736);
            String str = (String)paramaduu.jdField_a_of_type_AndroidWidgetTextView.getTag(2131363735);
            Paint localPaint = new Paint(1);
            localPaint.setTextSize(actn.a(12.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
            localPaint.setTextAlign(Paint.Align.LEFT);
            int i1 = (int)localPaint.measureText("...");
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {}
            for (j = (int)localPaint.measureText(ajyc.a(2131706466) + (String)localObject3);; j = (int)localPaint.measureText(ajyc.a(2131706462)))
            {
              m = str.length();
              k = (int)localPaint.measureText(str) + j;
              localObject2 = "";
              while ((k > n) && (m > 0))
              {
                m -= 1;
                localObject2 = str.substring(0, m);
                k = (int)localPaint.measureText((String)localObject2) + i1 + j;
              }
              if (!paramString.equals("")) {}
              for (i = 1;; i = 0)
              {
                localObject2 = localObject1;
                if (i == 0) {
                  break label1537;
                }
                URLDrawable.removeMemoryCacheByUrl(((URLDrawable)localObject3).getURL().toString());
                localObject2 = paramaduu.jdField_a_of_type_Aobk.a("fromAIO", bool, true, paramaduu);
                paramString = (String)localObject1;
                localObject1 = localObject2;
                break;
              }
              j = paramaduu.jdField_a_of_type_Aobk.a.width;
              break label201;
              m = paramaduu.jdField_a_of_type_Aobk.a.height;
              break label219;
            }
            if (!((String)localObject2).equals(""))
            {
              localObject2 = a(i, (String)localObject2 + "...", (String)localObject3);
              paramaduu.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
            }
          }
          paramaduu.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          localObject2 = paramaduu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
          if (localObject1 != null) {}
          switch (((URLDrawable)localObject1).getStatus())
          {
          default: 
            paramaduu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            ((BaseChatItemLayout)localObject2).setProgressVisable(true);
            paramaduu.d.setVisibility(8);
            paramaduu.c.setVisibility(8);
            paramaduu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
            if ((paramChatMessage.isFlowMessage) && (paramaduu.jdField_a_of_type_Aobk.a.jobType == 0)) {
              if (!(this.jdField_b_of_type_AndroidContentContext instanceof MultiForwardActivity))
              {
                if (!paramChatMessage.isSend()) {
                  break label1309;
                }
                paramaduu.c.setImageResource(2130846197);
                paramaduu.c.setVisibility(0);
              }
            }
            break;
          }
          for (;;)
          {
            if ((paramaduu.jdField_a_of_type_Aobk.b()) && (paramaduu.jdField_a_of_type_Aobk.c()) && ((paramChatMessage instanceof MessageForMarketFace)))
            {
              if (paramaduu.jdField_a_of_type_Aobk.a() != null)
              {
                paramChatMessage = (RelativeLayout.LayoutParams)paramaduu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
                paramChatMessage.width = actn.a(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
                paramaduu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramaduu.jdField_a_of_type_Aobk.a(), paramChatMessage.width, paramaduu.jdField_a_of_type_Aobk.b());
                if (Build.VERSION.SDK_INT < 19)
                {
                  paramChatMessage = (RelativeLayout.LayoutParams)paramaduu.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
                  localObject2 = (RelativeLayout.LayoutParams)paramaduu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
                  paramChatMessage.width = actn.a(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
                  ((RelativeLayout.LayoutParams)localObject2).width = actn.a(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
                }
              }
              i = paramaduu.jdField_a_of_type_Aobk.c();
              j = paramaduu.jdField_a_of_type_Aobk.d();
              paramChatMessage = new axut(i, 1, 1, actn.a(22.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
              paramaduu.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(paramChatMessage);
              paramaduu.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView.setDrawColor(i);
              paramaduu.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView.postInvalidate();
              paramaduu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(j);
              paramaduu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(j);
            }
            if (localObject1 != null) {
              a(paramaduu, (URLDrawable)localObject1, paramString);
            }
            c(paramaduu);
            return;
            if (!asdy.a()) {
              paramaduu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            }
            if ((anzm.a()) && (2 == paramaduu.jdField_a_of_type_Aobk.a.jobType) && (!this.jdField_a_of_type_Anvs.e(paramaduu.jdField_a_of_type_Aobk.a.epId)) && (!anzm.c())) {
              break;
            }
            float f1 = this.jdField_a_of_type_Anvs.a(paramaduu.jdField_a_of_type_Aobk.a.epId);
            if ((f1 >= 0.0F) && (1.0F != f1)) {
              break;
            }
            paramaduu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            ((BaseChatItemLayout)localObject2).setProgressVisable(false);
            break;
            paramaduu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            ((BaseChatItemLayout)localObject2).setProgressVisable(false);
            if (!AppSetting.d) {
              break;
            }
            paramaduu.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(ajyc.a(2131706465));
            break;
            paramaduu.d.setImageResource(2130846197);
            paramaduu.d.setVisibility(0);
            continue;
            if ((paramChatMessage.isDui) && (DuiButtonImageView.jdField_a_of_type_Boolean) && (!asyv.a(paramChatMessage)))
            {
              paramaduu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
              if ((paramChatMessage.isSend()) || (paramaduu.jdField_a_of_type_Aobk.b()))
              {
                paramaduu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
                paramaduu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
              }
              else if ((paramaduu.jdField_a_of_type_Aobk != null) && (paramaduu.jdField_a_of_type_Aobk.a != null) && ((2 == paramaduu.jdField_a_of_type_Aobk.a.jobType) || (4 == paramaduu.jdField_a_of_type_Aobk.a.jobType)))
              {
                paramaduu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
                paramaduu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
              }
              else
              {
                if (!paramChatMessage.hasPlayedDui) {
                  paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramaduu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView);
                }
                for (;;)
                {
                  if (!DuiButtonImageView.jdField_a_of_type_Boolean) {
                    break label1511;
                  }
                  paramaduu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(this);
                  paramaduu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(0);
                  break;
                  paramaduu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.f();
                }
                paramaduu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(null);
                paramaduu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
              }
            }
          }
        }
        label1309:
        paramString = (String)localObject2;
        label1537:
        localObject1 = localObject3;
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
      bbcv.a(paramContext, 230, paramString1, paramString2, 2131690596, 2131691649, new adul(paramEmoticon, paramContext, paramQQAppInterface, paramInt), new adun()).show();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EmosmDetailActivity.showCustomMarketFaceTips", 2, paramContext.getMessage());
    }
  }
  
  private void b(aduu paramaduu)
  {
    if ((4 != paramaduu.jdField_a_of_type_Aobk.a.jobType) || (((MessageForMarketFace)paramaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Anvs.a(paramaduu.jdField_a_of_type_Aobk.a.epId, true, true)) {
        break;
      }
      if (!anzm.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone: H5MagicSource isnot Intact , and network isnot 2 3 4G or wifi;epId = " + paramaduu.jdField_a_of_type_Aobk.a.epId);
        }
        paramaduu.f.setVisibility(8);
        return;
      }
    } while (-1.0F != this.jdField_a_of_type_Anvs.a(paramaduu.jdField_a_of_type_Aobk.a.epId));
    anvr.a().a(this.jdField_a_of_type_Anwf);
    EmoticonPackage localEmoticonPackage = new EmoticonPackage();
    localEmoticonPackage.name = paramaduu.jdField_a_of_type_Aobk.a.name;
    localEmoticonPackage.epId = paramaduu.jdField_a_of_type_Aobk.a.epId;
    localEmoticonPackage.jobType = 5;
    localEmoticonPackage.type = 1;
    localEmoticonPackage.isMagicFaceDownloading = true;
    ((askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramaduu.jdField_a_of_type_Aobk.a);
    this.jdField_a_of_type_JavaUtilList.add(paramaduu);
    paramaduu.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
    paramaduu.f.setVisibility(8);
    paramaduu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    ((MessageForMarketFace)paramaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
    this.jdField_a_of_type_Anvs.a(localEmoticonPackage, false);
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone,start download epId = " + paramaduu.jdField_a_of_type_Aobk.a.epId);
    }
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, localEmoticonPackage.epId, "", "", "");
    return;
    if ((this.f) && (this.jdField_a_of_type_Anvs.b()))
    {
      if (!this.jdField_b_of_type_Boolean) {
        paramaduu.f.setVisibility(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source intacat epId = " + paramaduu.jdField_a_of_type_Aobk.a.epId);
      }
    }
    for (;;)
    {
      paramaduu.f.setImageResource(2130837714);
      if ((((MessageForMarketFace)paramaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).isSend()) || (!((MessageForMarketFace)paramaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay) || (!this.jdField_a_of_type_Anvs.a()) || (System.currentTimeMillis() - this.jdField_d_of_type_Long <= 3000L) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().p())) {
        break;
      }
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      ((MessageForMarketFace)paramaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      a(paramaduu, "1");
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramaduu.jdField_a_of_type_Aobk.a.epId, "", "", "");
      return;
      paramaduu.f.setVisibility(8);
    }
  }
  
  private void c(aduu paramaduu)
  {
    paramaduu.jdField_a_of_type_Boolean = false;
    if ((2 != paramaduu.jdField_a_of_type_Aobk.a.jobType) || (((MessageForMarketFace)paramaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null) || (!asdy.a())) {}
    for (;;)
    {
      return;
      Object localObject;
      if (!this.jdField_a_of_type_Anvs.e(paramaduu.jdField_a_of_type_Aobk.a.epId))
      {
        if (!anzm.a())
        {
          paramaduu.f.setVisibility(8);
          return;
        }
        if ((!anzm.c()) && (!this.jdField_a_of_type_Anvs.a(paramaduu.jdField_a_of_type_Aobk.a.epId, Boolean.valueOf(false))) && (-1.0F == this.jdField_a_of_type_Anvs.a(paramaduu.jdField_a_of_type_Aobk.a.epId)))
        {
          anvr.a().a(this.jdField_a_of_type_Anwf);
          localObject = new EmoticonPackage();
          ((EmoticonPackage)localObject).name = paramaduu.jdField_a_of_type_Aobk.a.name;
          ((EmoticonPackage)localObject).epId = paramaduu.jdField_a_of_type_Aobk.a.epId;
          ((EmoticonPackage)localObject).jobType = 3;
          ((EmoticonPackage)localObject).rscType = ascj.a(paramaduu.jdField_a_of_type_Aobk.a.magicValue);
          ((EmoticonPackage)localObject).type = 1;
          ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
          ((askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramaduu.jdField_a_of_type_Aobk.a);
          this.jdField_a_of_type_JavaUtilList.add(paramaduu);
          paramaduu.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
          paramaduu.f.setVisibility(8);
          paramaduu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((MessageForMarketFace)paramaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          this.jdField_a_of_type_Anvs.a((EmoticonPackage)localObject, false);
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongXiazai", 0, 0, paramaduu.jdField_a_of_type_Aobk.a.epId, "", "", "");
        }
      }
      else
      {
        if (ascj.a(paramaduu.jdField_a_of_type_Aobk.a.magicValue) == 1) {
          paramaduu.f.setVisibility(8);
        }
        while (((MessageForMarketFace)paramaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay)
        {
          ((MessageForMarketFace)paramaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          localObject = new Emoticon();
          ((Emoticon)localObject).eId = paramaduu.jdField_a_of_type_Aobk.a.eId;
          ((Emoticon)localObject).epId = paramaduu.jdField_a_of_type_Aobk.a.epId;
          ((Emoticon)localObject).magicValue = paramaduu.jdField_a_of_type_Aobk.a.magicValue;
          ((Emoticon)localObject).jobType = paramaduu.jdField_a_of_type_Aobk.a.jobType;
          if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() != null) && (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null) && (asdy.a())) {
            ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a((Emoticon)localObject, 1, ((MessageForMarketFace)paramaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).senderuin, false);
          }
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramaduu.jdField_a_of_type_Aobk.a.epId, "", "", "");
          return;
          if (!this.jdField_b_of_type_Boolean)
          {
            paramaduu.f.setImageResource(2130837714);
            paramaduu.f.setVisibility(0);
          }
        }
      }
    }
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
  
  private void d(aduu paramaduu)
  {
    if ((paramaduu != null) && (paramaduu.jdField_a_of_type_Aobk != null) && (paramaduu.jdField_a_of_type_Aobk.c()) && (paramaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (!this.jdField_c_of_type_JavaUtilSet.contains(Long.valueOf(paramaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))))
    {
      askd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AB51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramaduu.jdField_a_of_type_Aobk.a.epId);
      this.jdField_c_of_type_JavaUtilSet.add(Long.valueOf(paramaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acun a()
  {
    return new aduu();
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    long l = System.currentTimeMillis();
    paramBaseChatItemLayout = (MessageForMarketFace)paramChatMessage;
    aduu localaduu = (aduu)paramacun;
    this.jdField_b_of_type_JavaUtilSet.add(localaduu);
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
      paramacun = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject2 = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout)localObject2).setId(2131369796);
      paramView = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      paramView.setId(2131366476);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131364110);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131364110);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setOnClickListener(this);
      localObject1 = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).setId(2131363171);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = 8;
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131366476);
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      ((FrameLayout)localObject1).setOnClickListener(this);
      ((FrameLayout)localObject1).setOnTouchListener(paramacxn);
      ((FrameLayout)localObject1).setOnLongClickListener(paramacxn);
      paramacxn = new aduv(this, this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).addView(paramacxn, -2, -2);
      localObject4 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localObject5 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject5).gravity = 85;
      ((FrameLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject5).setId(2131379310);
      localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(1, 2131363171);
      ((RelativeLayout.LayoutParams)localObject6).addRule(8, 2131363171);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      ((ImageView)localObject5).setOnClickListener(this);
      localObject6 = new BreathAnimationLayout(this.jdField_b_of_type_AndroidContentContext);
      ((BreathAnimationLayout)localObject6).setId(2131370773);
      localPttAudioPlayView = new PttAudioPlayView(this.jdField_b_of_type_AndroidContentContext, 10);
      localPttAudioPlayView.setThemeColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131166872).getDefaultColor());
      localPttAudioPlayView.setId(2131370775);
      localPttAudioPlayView.setPttPauseOrStopDrawable(2130838044);
      localObject7 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject7).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject7).leftMargin = actn.a(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).width = actn.a(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).height = actn.a(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      localPttAudioPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject7);
      localPttAudioPlayView.setOnClickListener(this);
      localObject7 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localObject8 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject8).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject8).leftMargin = actn.a(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).width = actn.a(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).height = actn.a(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((ImageView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
      ((ImageView)localObject7).setImageDrawable((Drawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839138));
      ((ImageView)localObject7).setVisibility(4);
      localObject8 = new PttAudioWaveView(this.jdField_b_of_type_AndroidContentContext);
      ((PttAudioWaveView)localObject8).setShowProgressLine(false);
      ((PttAudioWaveView)localObject8).setMaxTopBottomPadding(4);
      ((PttAudioWaveView)localObject8).setProgressColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131166872).getDefaultColor());
      ((PttAudioWaveView)localObject8).setId(2131370776);
      localObject9 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(1, 2131370775);
      ((RelativeLayout.LayoutParams)localObject9).width = actn.a(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).height = actn.a(45.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).leftMargin = bbkx.a(9.0F);
      ((RelativeLayout.LayoutParams)localObject9).rightMargin = bbkx.a(12.0F);
      ((PttAudioWaveView)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
      ((PttAudioWaveView)localObject8).setCanSupportSlide(false);
      ((PttAudioWaveView)localObject8).setOnClickListener(this);
      localObject9 = new SyncParentPressedRelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      ((RelativeLayout)localObject9).setId(2131370774);
      ((RelativeLayout)localObject9).addView((View)localObject8);
      ((RelativeLayout)localObject9).addView(localPttAudioPlayView);
      ((RelativeLayout)localObject9).addView((View)localObject7);
      localRelativeLayout = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localTriangleView = new TriangleView(this.jdField_b_of_type_AndroidContentContext);
      localObject10 = new RelativeLayout.LayoutParams(bbkx.a(9.0F), bbkx.a(5.0F));
      ((RelativeLayout.LayoutParams)localObject10).leftMargin = bbkx.a(2.0F);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14);
      ((RelativeLayout.LayoutParams)localObject10).addRule(10);
      localTriangleView.setId(2131371769);
      localTriangleView.setRotation(180.0F);
      localTriangleView.setTranslationY(bbkx.a(1.0F));
      localTriangleView.setLayoutParams((ViewGroup.LayoutParams)localObject10);
      localRelativeLayout.addView(localTriangleView);
      localObject10 = new RelativeLayout.LayoutParams(-2, bbkx.a(29.0F));
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131371769);
      localRelativeLayout.addView((View)localObject9, (ViewGroup.LayoutParams)localObject10);
      ((BreathAnimationLayout)localObject6).addView(localRelativeLayout);
      localObject10 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14, 2131363171);
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131363171);
      ((RelativeLayout.LayoutParams)localObject10).bottomMargin = bbkx.a(17.0F);
      ((RelativeLayout)localObject2).addView((View)localObject6, (ViewGroup.LayoutParams)localObject10);
      localObject10 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject10).setId(2131366477);
      localObject11 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject11).addRule(1, 2131363171);
      ((RelativeLayout.LayoutParams)localObject11).addRule(15, 2131363171);
      ((RelativeLayout.LayoutParams)localObject11).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject10, (ViewGroup.LayoutParams)localObject11);
      ((ImageView)localObject10).setOnClickListener(this);
      localObject11 = new DuiButtonImageView(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      ((DuiButtonImageView)localObject11).setId(2131365417);
      localObject12 = new RelativeLayout.LayoutParams(actn.a(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), actn.a(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject12).addRule(1, 2131363171);
      ((RelativeLayout.LayoutParams)localObject12).addRule(8, 2131363171);
      ((RelativeLayout.LayoutParams)localObject12).setMargins(0, 0, 0, -actn.a(6.5F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout)localObject2).addView((View)localObject11, (ViewGroup.LayoutParams)localObject12);
      localObject12 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject12).setId(2131369711);
      localObject13 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject13).addRule(1, 2131363171);
      ((RelativeLayout.LayoutParams)localObject13).addRule(8, 2131363171);
      ((RelativeLayout.LayoutParams)localObject13).leftMargin = actn.a(10.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout)localObject2).addView((View)localObject12, (ViewGroup.LayoutParams)localObject13);
      localObject13 = new TextView(this.jdField_b_of_type_AndroidContentContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      ((TextView)localObject13).setTextSize(12.0F);
      ((TextView)localObject13).setTextColor(-1);
      localLayoutParams.topMargin = actn.a(8.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((TextView)localObject13).setGravity(17);
      localLayoutParams.addRule(3, 2131369796);
    }
    for (;;)
    {
      try
      {
        ((TextView)localObject13).setBackgroundDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130843961));
        ((TextView)localObject13).setPadding(actn.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), actn.a(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), actn.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), actn.a(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
        paramacun.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramacun.addView((View)localObject13, localLayoutParams);
        ((ImageView)localObject12).setOnClickListener(this);
        localObject2 = new ProgressBar(this.jdField_b_of_type_AndroidContentContext, null, 0);
        ((ProgressBar)localObject2).setId(2131364137);
      }
      catch (Exception localException2)
      {
        try
        {
          ((ProgressBar)localObject2).setIndeterminateDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839140));
          int i = actn.a(16.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
          localObject3 = new FrameLayout.LayoutParams(i, i);
          ((FrameLayout.LayoutParams)localObject3).gravity = 17;
          ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          localaduu.jdField_e_of_type_AndroidWidgetImageView = paramacxn;
          localaduu.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject4);
          localaduu.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject5);
          localaduu.c = paramView;
          localaduu.d = ((ImageView)localObject10);
          localaduu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView = ((DuiButtonImageView)localObject11);
          localaduu.f = ((ImageView)localObject12);
          localaduu.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localObject1);
          localaduu.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject2);
          localaduu.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject13);
          localaduu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)localObject6);
          localaduu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = localPttAudioPlayView;
          localaduu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject8);
          localaduu.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject9);
          localaduu.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
          localaduu.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView = localTriangleView;
          localaduu.g = ((ImageView)localObject7);
          if (!c(paramChatMessage)) {
            paramBaseChatItemLayout.playProgress = 0.0F;
          }
          a(localaduu, paramChatMessage.uniseq);
          localaduu.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          localaduu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramBaseChatItemLayout.playProgress);
          if ((AppSetting.d) && (a(paramChatMessage, localaduu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) && (localaduu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)) {
            localaduu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setContentDescription(ajyc.a(2131706467));
          }
          new QueryTask(new aduo(this, localaduu), new adup(this, localaduu, paramBaseChatItemLayout, paramChatMessage, l)).a(paramBaseChatItemLayout.mMarkFaceMessage);
          return paramacun;
          localException2 = localException2;
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException2);
        }
        catch (Exception localException1)
        {
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException1);
          continue;
        }
      }
      if ((localaduu.jdField_a_of_type_Aobk != null) && (localaduu.jdField_a_of_type_Aobk.b()) && (localaduu.jdField_b_of_type_AndroidWidgetImageView != null) && ((localaduu.jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof AnimationDrawable))) {
        localaduu.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846217);
      }
      paramacun = paramView;
      if (AppSetting.d)
      {
        localaduu.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        paramacun = paramView;
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (!bbet.a(paramChatMessage.issend)) {
        break label103;
      }
      localStringBuilder.append("发出表情");
    }
    for (;;)
    {
      paramChatMessage = (MessageForMarketFace)paramChatMessage;
      if (paramChatMessage.mMarkFaceMessage != null)
      {
        paramChatMessage = ((askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramChatMessage.mMarkFaceMessage);
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
    anvr.a().b(this.jdField_a_of_type_Anwf);
    anvr.a().b(this.jdField_a_of_type_Adut);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((aduu)localIterator.next()).a();
    }
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((jdField_a_of_type_Aobk == null) || (jdField_a_of_type_Aobk.a == null))
    {
      QLog.e("MarketFaceItemBuilder", 1, "onMenuItemClicked emoticon is null");
      return;
    }
    if ((paramInt == 2131364985) || (paramInt == 2131362122) || (paramInt == 2131366648) || (paramInt == 2131366377))
    {
      ((askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(jdField_a_of_type_Aobk.a.epId, new adum(this, paramInt, paramChatMessage));
      return;
    }
    if (paramInt == 2131370537)
    {
      super.d(paramChatMessage);
      return;
    }
    if (paramInt == 2131370494)
    {
      super.a(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  void a(aduu paramaduu, URLDrawable paramURLDrawable)
  {
    a(paramaduu, paramURLDrawable, "");
  }
  
  void a(aduu paramaduu, URLDrawable paramURLDrawable, String paramString)
  {
    paramaduu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramaduu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
    paramaduu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramaduu.f.setVisibility(8);
    paramaduu.jdField_b_of_type_Boolean = false;
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
        if (paramaduu.jdField_a_of_type_Aobk.b()) {
          if (paramaduu.jdField_a_of_type_Aobk.c()) {
            paramaduu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          }
        }
      }
      while (!"big_sound".equals(str))
      {
        do
        {
          return;
          paramaduu.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846217);
          paramaduu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        } while ((i != 1) || (paramaduu.jdField_a_of_type_Aobk.j != 3));
        paramaduu.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837711);
        paramaduu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramaduu.jdField_b_of_type_Boolean = true;
        return;
      }
      if (c(paramaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
      {
        if (paramaduu.jdField_a_of_type_Aobk.c())
        {
          paramaduu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          paramaduu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          return;
        }
        paramaduu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramURLDrawable = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772244);
        paramaduu.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
        paramURLDrawable.start();
        return;
      }
      if (paramaduu.jdField_a_of_type_Aobk.c())
      {
        paramaduu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
        paramaduu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
        return;
      }
      paramaduu.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846217);
      paramaduu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
  }
  
  public void a(View paramView)
  {
    paramView = (aduu)actn.a(paramView);
    String str1;
    String str2;
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSendFromLocal())
    {
      str1 = this.jdField_b_of_type_AndroidContentContext.getString(2131689995);
      str2 = this.jdField_b_of_type_AndroidContentContext.getString(2131689996);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 41) && (paramView.jdField_a_of_type_Aobk != null) && (paramView.jdField_a_of_type_Aobk.a != null)) {
        a((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_Aobk);
      }
    }
    do
    {
      return;
      bbcv.a(this.jdField_b_of_type_AndroidContentContext, 230, str1, str2, new adui(this, paramView), new aduj(this)).show();
      return;
      paramView = paramView.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
    } while (!(paramView instanceof URLDrawable));
    ((URLDrawable)paramView).restartDownload();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, axli.a(10.0F), 0);
  }
  
  protected void a(MessageForMarketFace paramMessageForMarketFace, aobk paramaobk)
  {
    if ((paramMessageForMarketFace == null) || (paramaobk == null) || (paramaobk.a == null) || (paramaobk.a.epId == null)) {
      return;
    }
    bfol localbfol = (bfol)bfoy.a(this.jdField_b_of_type_AndroidContentContext, null);
    localbfol.a(this.jdField_b_of_type_AndroidContentContext.getString(2131692046));
    localbfol.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131692045), 1);
    localbfol.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131692047), 1);
    localbfol.c(2131690596);
    localbfol.a(new aduk(this, paramaobk, localbfol, paramMessageForMarketFace));
    localbfol.show();
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if ((paramView != null) && (paramFloat > 0.0F))
    {
      paramXListView = (aduu)actn.a(paramView);
      if ((paramXListView != null) && (paramXListView.jdField_a_of_type_Aobk != null) && (paramXListView.jdField_a_of_type_Aobk.b()) && (paramXListView.jdField_a_of_type_Aobk.c()) && (c(paramChatMessage)))
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
      paramXListView = (aduu)actn.a(paramView);
      if (!paramXListView.jdField_a_of_type_Aobk.c()) {
        break label66;
      }
      paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
        paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
      }
    }
    for (;;)
    {
      paramView = paramXListView.jdField_a_of_type_Aobk.a("fromAIO", false);
      paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      return;
      label66:
      paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846217);
    }
  }
  
  public boolean a(acun paramacun)
  {
    return paramacun instanceof aduu;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer, int paramInt2)
  {
    paramXListView = (aduu)actn.a(paramView);
    if ((paramXListView == null) || (paramXListView.jdField_a_of_type_Aobk == null) || (paramXListView.jdField_a_of_type_Aobk.a == null)) {
      return false;
    }
    if (paramXListView.jdField_a_of_type_Aobk.b())
    {
      paramView = anzm.o.replace("[epId]", paramXListView.jdField_a_of_type_Aobk.a.epId).replace("[eId]", paramXListView.jdField_a_of_type_Aobk.a.eId);
      if (!bbdj.b(paramView))
      {
        if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramChatMessage.uniseq))) {
          return false;
        }
        this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramChatMessage.uniseq));
        a(paramXListView, paramChatMessage.uniseq);
        ThreadManager.getFileThreadHandler().post(new MarketFaceItemBuilder.10(this, paramXListView, paramChatMessage));
        return false;
      }
      if (paramAudioPlayer.a(paramView))
      {
        paramView = paramXListView.jdField_a_of_type_Aobk.a("fromAIO", true);
        paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        aobk.a(paramView);
        if (paramXListView.jdField_a_of_type_Aobk.c()) {
          if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
            paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          }
        }
        for (;;)
        {
          return true;
          paramView = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772244);
          paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
          paramView.start();
        }
      }
    }
    return false;
  }
  
  public bblt[] a(View paramView)
  {
    paramView = (aduu)actn.a(paramView);
    bblr localbblr = new bblr();
    jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (ApolloUtil.a(jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
      return localbblr.a();
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
        if (paramView.jdField_a_of_type_Aobk.a.jobType != 1)
        {
          jdField_a_of_type_Aobk = paramView.jdField_a_of_type_Aobk;
          if (actn.a(1) == 1) {
            localbblr.a(2131362122, this.jdField_b_of_type_AndroidContentContext.getString(2131693373), 2130838604);
          }
          localbblr.a(2131366648, this.jdField_b_of_type_AndroidContentContext.getString(2131692752), 2130838606);
          a(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbblr);
          if ((paramView.jdField_a_of_type_Aobk.a.jobType != 2) && (paramView.jdField_a_of_type_Aobk.a.jobType != 4)) {
            localbblr.a(2131366377, this.jdField_b_of_type_AndroidContentContext.getString(2131693382), 2130838585);
          }
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Ap_show_forward", 0);
        }
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
          a(localbblr, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        a(localbblr, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        if (paramView.jdField_a_of_type_Aobk.a.jobType != 1) {
          b(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbblr);
        }
        super.c(localbblr, this.jdField_b_of_type_AndroidContentContext);
        super.e(localbblr, this.jdField_b_of_type_AndroidContentContext);
      }
      for (;;)
      {
        return localbblr.a();
        jdField_a_of_type_Aobk = paramView.jdField_a_of_type_Aobk;
        aaod.a(localbblr, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public void d(View paramView)
  {
    actn.n = true;
    if (super.a()) {
      return;
    }
    Object localObject3;
    Drawable localDrawable;
    URLDrawable localURLDrawable;
    Object localObject1;
    if (paramView.getId() == 2131363171)
    {
      localObject3 = (aduu)actn.a(paramView);
      localDrawable = ((aduu)localObject3).jdField_e_of_type_AndroidWidgetImageView.getDrawable();
      if ((localDrawable instanceof URLDrawable))
      {
        localURLDrawable = (URLDrawable)localDrawable;
        localObject1 = localURLDrawable.getURL().getHost();
        if (!(localURLDrawable.getTag() instanceof Bundle)) {
          break label2132;
        }
        localObject1 = ((Bundle)localURLDrawable.getTag()).getString("display_type");
      }
    }
    label1105:
    label2132:
    for (;;)
    {
      switch (((URLDrawable)localDrawable).getStatus())
      {
      }
      Object localObject2;
      for (;;)
      {
        if ((((aduu)localObject3).jdField_a_of_type_Aobk != null) && (((aduu)localObject3).jdField_a_of_type_Aobk.a != null) && (((aduu)localObject3).jdField_a_of_type_Aobk.a.jobType == 2) && (asdy.a())) {
          a((aduu)localObject3);
        }
        if ((((URLDrawable)localDrawable).getStatus() != 1) && ((((aduu)localObject3).jdField_a_of_type_Aobk == null) || (((aduu)localObject3).jdField_a_of_type_Aobk.a == null) || (!((aduu)localObject3).jdField_a_of_type_Aobk.e()))) {
          break;
        }
        a((aduu)localObject3, xpx.a(paramView));
        return;
        localObject2 = "";
        if ((localURLDrawable.getStateTag() instanceof Bundle)) {
          localObject2 = ((Bundle)localURLDrawable.getStateTag()).getString("display_type");
        }
        localURLDrawable.restartDownload();
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "msgOnclickListener| URLDrawable restartDownload status=" + localURLDrawable.getStatus());
        }
        a((aduu)localObject3, localURLDrawable, (String)localObject2);
        ((aduu)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        if ((((aduu)localObject3).jdField_a_of_type_Aobk != null) && (((aduu)localObject3).jdField_a_of_type_Aobk.b()) && ("big_sound".equals(localObject1)))
        {
          jdField_c_of_type_Long = ((aduu)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
          continue;
          if ((((aduu)localObject3).jdField_a_of_type_Aobk != null) && (((aduu)localObject3).jdField_a_of_type_Aobk.a != null) && (((aduu)localObject3).jdField_a_of_type_Aobk.a.jobType != 0) && (((aduu)localObject3).jdField_a_of_type_Aobk.a.jobType != 2) && (((aduu)localObject3).jdField_a_of_type_Aobk.a.jobType != 4))
          {
            ((aduu)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            if ("big_sound".equals(localObject1))
            {
              if ((((aduu)localObject3).jdField_a_of_type_Aobk.a != null) && (((aduu)localObject3).jdField_a_of_type_Aobk.a.isSound)) {
                if (c(((aduu)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
                  MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
                } else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
                  bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695521, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                } else {
                  MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((aduu)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
                }
              }
            }
            else if ("aio_preview".equals(localObject1))
            {
              localObject1 = ((aduu)localObject3).jdField_a_of_type_Aobk.a("fromAIO", true);
              if (localObject1 != null)
              {
                ((aduu)localObject3).jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
                ((aduu)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
                a((aduu)localObject3, (URLDrawable)localObject1);
                if (((aduu)localObject3).jdField_a_of_type_Aobk.b()) {
                  jdField_c_of_type_Long = ((aduu)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
                }
              }
            }
          }
        }
      }
      if ((!(localDrawable instanceof asbz)) || (((aduu)localObject3).jdField_a_of_type_Aobk == null) || (((aduu)localObject3).jdField_a_of_type_Aobk.a == null) || (!((aduu)localObject3).jdField_a_of_type_Aobk.e())) {
        break;
      }
      a((aduu)localObject3, xpx.a(paramView));
      return;
      if (paramView.getId() == 2131379310)
      {
        localObject1 = (aduu)actn.a(paramView);
        if ((((aduu)localObject1).jdField_a_of_type_Aobk != null) && (((aduu)localObject1).jdField_a_of_type_Aobk.b()))
        {
          if (!c(((aduu)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
            break label755;
          }
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
        }
      }
      label755:
      label1150:
      do
      {
        do
        {
          for (;;)
          {
            super.onClick(paramView);
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
            {
              bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695521, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
            }
            else
            {
              MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((aduu)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
              continue;
              if ((paramView.getId() == 2131370775) || (paramView.getId() == 2131370776))
              {
                localObject2 = (aduu)actn.a(paramView);
                if ((((aduu)localObject2).jdField_a_of_type_Aobk != null) && (((aduu)localObject2).jdField_a_of_type_Aobk.b()) && (((aduu)localObject2).jdField_a_of_type_Aobk.c()))
                {
                  int i;
                  if (c(((aduu)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage))
                  {
                    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
                    localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                    i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
                    if (((aduu)localObject2).jdField_a_of_type_Aobk.a != null) {}
                    for (localObject1 = ((aduu)localObject2).jdField_a_of_type_Aobk.a.epId;; localObject1 = "")
                    {
                      askd.a((QQAppInterface)localObject3, "0X800A934", i, (String)localObject1);
                      break;
                    }
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
                  {
                    bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695521, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                  }
                  else
                  {
                    if ((((aduu)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMarketFace)) {
                      ((MessageForMarketFace)((aduu)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage).playProgress = 0.0F;
                    }
                    ((aduu)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
                    boolean bool = false;
                    if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((aduu)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage))
                    {
                      bool = true;
                      ((aduu)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
                      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
                      if (((aduu)localObject2).jdField_a_of_type_Aobk.a != null)
                      {
                        localObject1 = ((aduu)localObject2).jdField_a_of_type_Aobk.a.epId;
                        askd.a((QQAppInterface)localObject3, "0X800A933", i, (String)localObject1);
                      }
                    }
                    else
                    {
                      if (!bool)
                      {
                        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                        if (((aduu)localObject2).jdField_a_of_type_Aobk.a == null) {
                          break label1239;
                        }
                        localObject1 = ((aduu)localObject2).jdField_a_of_type_Aobk.a.epId;
                        askd.a((QQAppInterface)localObject3, "0X800A935", -1, (String)localObject1);
                      }
                      localObject2 = new HashMap();
                      if (!bool) {
                        break label1247;
                      }
                    }
                    for (localObject1 = "0";; localObject1 = "1")
                    {
                      ((HashMap)localObject2).put("playResult", localObject1);
                      ((HashMap)localObject2).put("playType", "1");
                      axrl.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "NewAudioEmoticonVoicePlay", bool, 0L, 0L, (HashMap)localObject2, null);
                      break;
                      localObject1 = "";
                      break label1105;
                      localObject1 = "";
                      break label1150;
                    }
                  }
                }
              }
              else if ((paramView.getId() == 2131366477) || (paramView.getId() == 2131366476))
              {
                localObject1 = (aduu)actn.a(paramView);
                localObject2 = a();
                if (localObject2 != null)
                {
                  ((bcpq)localObject2).a(this.jdField_b_of_type_AndroidContentContext.getString(2131692050));
                  ((bcpq)localObject2).show();
                }
                ((askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(((aduu)localObject1).jdField_a_of_type_Aobk.a.epId, new aduh(this, (aduu)localObject1, (bcpq)localObject2));
              }
              else
              {
                if (paramView.getId() != 2131365417) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("MarketFaceItemBuilder", 2, "[Doutu] Dui Button Clicked.");
                }
                localObject1 = ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment();
                if (localObject1 != null)
                {
                  localObject1 = ((ChatFragment)localObject1).a();
                  if (localObject1 != null) {
                    ((BaseChatPie)localObject1).a().obtainMessage(79, null).sendToTarget();
                  } else if (QLog.isColorLevel()) {
                    QLog.d("MarketFaceItemBuilder", 2, "[Doutu] curPie is null.");
                  }
                }
                else if (QLog.isColorLevel())
                {
                  QLog.d("MarketFaceItemBuilder", 2, "[Doutu] chatFragment is null.");
                }
              }
            }
          }
        } while (paramView.getId() != 2131369711);
        localObject1 = (aduu)actn.a(paramView);
        if ((((aduu)localObject1).jdField_a_of_type_Aobk != null) && (((aduu)localObject1).jdField_a_of_type_Aobk.a != null) && (2 == ((aduu)localObject1).jdField_a_of_type_Aobk.a.jobType))
        {
          if (this.jdField_a_of_type_Anvs.a(((aduu)localObject1).jdField_a_of_type_Aobk.a.epId, Boolean.valueOf(false))) {
            break;
          }
          anvr.a().a(this.jdField_a_of_type_Anwf);
          localObject2 = new EmoticonPackage();
          ((EmoticonPackage)localObject2).name = ((aduu)localObject1).jdField_a_of_type_Aobk.a.name;
          ((EmoticonPackage)localObject2).epId = ((aduu)localObject1).jdField_a_of_type_Aobk.a.epId;
          ((EmoticonPackage)localObject2).jobType = 3;
          ((EmoticonPackage)localObject2).type = 1;
          ((EmoticonPackage)localObject2).isMagicFaceDownloading = true;
          ((aduu)localObject1).jdField_a_of_type_Boolean = false;
          ((MessageForMarketFace)((aduu)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          ((askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(((aduu)localObject1).jdField_a_of_type_Aobk.a);
          this.jdField_a_of_type_JavaUtilList.add(localObject1);
          ((aduu)localObject1).f.setVisibility(8);
          ((aduu)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          this.jdField_a_of_type_Anvs.a((EmoticonPackage)localObject2, false);
          axqw.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongBofang", 0, 0, ((aduu)localObject1).jdField_a_of_type_Aobk.a.epId, "", "", "");
        }
      } while ((((aduu)localObject1).jdField_a_of_type_Aobk == null) || (((aduu)localObject1).jdField_a_of_type_Aobk.a == null) || (4 != ((aduu)localObject1).jdField_a_of_type_Aobk.a.jobType) || (System.currentTimeMillis() - this.jdField_d_of_type_Long <= 3000L) || (!this.jdField_a_of_type_Anvs.a()));
      label1239:
      label1247:
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_Anvs.a(((aduu)localObject1).jdField_a_of_type_Aobk.a.epId, true, true)) {
        a((aduu)localObject1, "0");
      }
      for (;;)
      {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbFasong", "MbZhudongBofang", 0, 0, ((aduu)localObject1).jdField_a_of_type_Aobk.a.epId, "", "", "");
        break;
        if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (!asdy.a()) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null)) {
          break label1692;
        }
        ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a(((aduu)localObject1).jdField_a_of_type_Aobk.a, 1, ((aduu)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, true);
        break label1692;
        anvr.a().a(this.jdField_a_of_type_Anwf);
        localObject2 = new EmoticonPackage();
        ((EmoticonPackage)localObject2).name = ((aduu)localObject1).jdField_a_of_type_Aobk.a.name;
        ((EmoticonPackage)localObject2).epId = ((aduu)localObject1).jdField_a_of_type_Aobk.a.epId;
        ((EmoticonPackage)localObject2).jobType = 5;
        ((EmoticonPackage)localObject2).type = 1;
        ((EmoticonPackage)localObject2).isMagicFaceDownloading = true;
        ((aduu)localObject1).jdField_a_of_type_Boolean = false;
        ((MessageForMarketFace)((aduu)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
        ((askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(((aduu)localObject1).jdField_a_of_type_Aobk.a);
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
        ((aduu)localObject1).f.setVisibility(8);
        ((aduu)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_Anvs.a((EmoticonPackage)localObject2, false);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_b_of_type_AndroidContentContext;
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adug
 * JD-Core Version:    0.7.0.1
 */