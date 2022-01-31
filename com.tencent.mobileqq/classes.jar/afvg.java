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
import com.tencent.mobileqq.widget.QQToast;
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

public class afvg
  extends BaseBubbleBuilder
  implements aetg
{
  public static apxv a;
  public static ChatMessage a;
  public static int c;
  static long jdField_c_of_type_Long;
  afvt jdField_a_of_type_Afvt = new afvt();
  public apro a;
  apsb jdField_a_of_type_Apsb = new afvs(this);
  public List<afvu> a;
  public Set<Long> a;
  public Context b;
  Set<afvu> b;
  Set<Long> jdField_c_of_type_JavaUtilSet = new ArraySet();
  public int d;
  private long d;
  public int e;
  public boolean f = false;
  
  static
  {
    jdField_c_of_type_Int = 1;
  }
  
  public afvg(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_d_of_type_Int = 320;
    this.jdField_e_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Apro = ((apro)paramQQAppInterface.getManager(43));
    if ((this.jdField_b_of_type_AndroidContentContext instanceof SplashActivity)) {
      this.f = true;
    }
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, Handler paramHandler)
  {
    boolean bool = true;
    apon localapon = (apon)paramQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("MarketFaceItemBuilder", 2, "Call getEmoticonDataList from addEmotionToFavorite.");
    }
    List localList = localapon.a();
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
          if (localapon.a(localCustomEmotionData, j))
          {
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramHandler != null) {
              paramHandler.post(new MarketFaceItemBuilder.17(paramContext));
            }
            aufn.c("0", 1);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
            }
            return 0;
          }
          if (paramHandler != null) {
            paramHandler.post(new MarketFaceItemBuilder.18(paramContext));
          }
          aufn.c("2003", 1);
          return 0;
        }
        n = i;
        if (i < localCustomEmotionData.emoId) {
          n = localCustomEmotionData.emoId;
        }
        j += 1;
        m = k;
      }
      if (m >= apol.a) {
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
      paramEmoticon = ((aufn)paramQQAppInterface.getManager(14)).a(paramEmoticon.epId);
      if (paramEmoticon != null) {
        if (paramEmoticon.isAPNG != 2) {
          break label425;
        }
      }
      for (;;)
      {
        paramHandler.isAPNG = bool;
        paramEmoticon = (apoo)paramQQAppInterface.getManager(103);
        if (paramEmoticon != null) {
          paramEmoticon.b(paramHandler, new apnw(paramQQAppInterface, paramContext, paramHandler, null, 0));
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
      i = 2131691042;
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
      paramInt = 2131691043;
      paramString2 = alud.a(2131706864);
      continue;
      paramString2 = alud.a(2131706859);
      paramInt = i;
      continue;
      paramString2 = alud.a(2131706856);
      paramInt = i;
      continue;
      paramString2 = alud.a(2131706866);
      paramInt = i;
    }
  }
  
  private bety a()
  {
    if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a == null) {
        ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a = new bety(this.jdField_b_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a;
    }
    return null;
  }
  
  private String a()
  {
    try
    {
      i = bdin.a(this.jdField_b_of_type_AndroidContentContext);
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
    this.jdField_a_of_type_Afvt.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_Apxv, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a());
    aprn.a().a(this.jdField_a_of_type_Afvt);
    this.jdField_a_of_type_Apro.a(jdField_a_of_type_Apxv.a.epId, apro.jdField_c_of_type_Int);
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
            aryv.a((BaseActivity)paramContext, paramEmoticon, 21, 100500, "biz_src_jc_gif");
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
      azqs.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_follow_send_aio", 0, 0, "", paramEmoticon.epId, "", "");
      apxv.a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, null);
      return;
      if (paramInt2 < 0)
      {
        localHandler.post(new MarketFaceItemBuilder.15(paramContext, paramString));
        if (6 == paramInt1 % 1000) {
          aufn.c("2001", 1);
        }
        QLog.i("MarketFaceItemBuilder", 1, "opType: " + paramInt1 + ",result:" + paramInt2);
        return;
      }
      localHandler.post(new MarketFaceItemBuilder.16(paramInt1, paramContext, paramQQAppInterface, paramEmoticon, paramString));
    } while (6 != paramInt1 % 1000);
    aufn.c("2002", 1);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, apxv paramapxv, SessionInfo paramSessionInfo, bety parambety)
  {
    a(paramInt, paramContext, paramQQAppInterface, paramEmoticonPackage, paramapxv, paramSessionInfo, parambety, false);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, apxv paramapxv, SessionInfo paramSessionInfo, bety parambety, boolean paramBoolean)
  {
    if (paramapxv == null) {
      return;
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.mobileFeetype == 1))
    {
      if ((parambety != null) && (parambety.isShowing())) {
        parambety.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramapxv.a, 0, null, paramSessionInfo, paramBoolean);
      return;
    }
    if ((!bdin.g(paramContext)) || (paramInt > 1000))
    {
      if ((parambety != null) && (parambety.isShowing())) {
        parambety.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramapxv.a, -404, alud.a(2131706863), paramSessionInfo, paramBoolean);
      return;
    }
    ((alrp)paramQQAppInterface.a(12)).a(paramInt, Integer.valueOf(paramapxv.a.epId).intValue(), paramapxv.a.eId);
  }
  
  private void a(afvu paramafvu)
  {
    EmoticonPackage localEmoticonPackage;
    if (!this.jdField_a_of_type_Apro.a(paramafvu.jdField_a_of_type_Apxv.a.epId, Boolean.valueOf(false)))
    {
      aprn.a().a(this.jdField_a_of_type_Apsb);
      localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramafvu.jdField_a_of_type_Apxv.a.name;
      localEmoticonPackage.epId = paramafvu.jdField_a_of_type_Apxv.a.epId;
      localEmoticonPackage.jobType = 3;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      if (paramafvu.jdField_e_of_type_Int != -1) {
        break label222;
      }
    }
    label222:
    for (localEmoticonPackage.rscType = atxu.a(paramafvu.jdField_a_of_type_Apxv.a.magicValue);; localEmoticonPackage.rscType = paramafvu.jdField_e_of_type_Int)
    {
      ((aufn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramafvu.jdField_a_of_type_Apxv.a);
      paramafvu.jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)paramafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = true;
      this.jdField_a_of_type_JavaUtilList.add(paramafvu);
      paramafvu.f.setVisibility(8);
      paramafvu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_Apro.a(localEmoticonPackage, false);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void a(afvu paramafvu, long paramLong)
  {
    Animatable localAnimatable = (Animatable)paramafvu.g.getDrawable();
    if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramLong)))
    {
      if (!localAnimatable.isRunning()) {
        localAnimatable.start();
      }
      paramafvu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(4);
      paramafvu.g.setVisibility(0);
      return;
    }
    if (localAnimatable.isRunning()) {
      localAnimatable.stop();
    }
    paramafvu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
    paramafvu.g.setVisibility(4);
  }
  
  private void a(afvu paramafvu, Rect paramRect)
  {
    AIOEmotionFragment.a(this.jdField_b_of_type_AndroidContentContext, paramafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramRect);
  }
  
  private void a(afvu paramafvu, String paramString)
  {
    ThreadManager.post(new MarketFaceItemBuilder.8(this, paramString, paramafvu), 5, null, true);
  }
  
  private void a(apxv paramapxv, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      str2 = a();
      if (paramapxv == null) {}
      for (paramapxv = "";; paramapxv = paramapxv.a.epId)
      {
        VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramapxv, paramString);
        return;
      }
    case 3: 
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramapxv == null) {}
      for (paramapxv = "";; paramapxv = paramapxv.a.epId)
      {
        azqs.b(paramString, "CliOper", "", "", "ep_mall", "0X8007187", 0, 0, paramapxv, "", "", "");
        return;
      }
    }
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    String str2 = a();
    if (paramapxv == null) {}
    for (paramapxv = "";; paramapxv = paramapxv.a.epId)
    {
      VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramapxv, paramString, "1", "", "", "", 0, 0, 0, 0);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    azqs.b(paramQQAppInterface, "CliOper", "", "", paramString2, paramString3, paramInt, 0, "", "", "", "");
  }
  
  private void a(ChatMessage paramChatMessage, afvu paramafvu)
  {
    a(paramChatMessage, paramafvu, "");
  }
  
  private void a(ChatMessage paramChatMessage, afvu paramafvu, String paramString)
  {
    if ((paramafvu.jdField_a_of_type_Apxv.b()) && (!c(paramChatMessage))) {}
    for (boolean bool = false;; bool = true)
    {
      Object localObject3 = paramafvu.jdField_a_of_type_Apxv.a("fromAIO", bool);
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
              localObject2 = paramafvu.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
              if ((localObject2 != null) && (((EmoticonPackage)localObject2).status == 2))
              {
                URLDrawable.removeMemoryCacheByUrl(((URLDrawable)localObject3).getURL().toString());
                localObject2 = paramafvu.jdField_a_of_type_Apxv.a("fromAIO", bool);
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
        if ((localObject1 != null) && (paramafvu.jdField_a_of_type_Apxv.a != null)) {
          if (paramafvu.jdField_a_of_type_Apxv.a.width == 0)
          {
            j = 200;
            if (paramafvu.jdField_a_of_type_Apxv.a.height != 0) {
              break label673;
            }
            m = 200;
            k = j;
            i = m;
            if (paramafvu.jdField_a_of_type_Apxv.a.extensionWidth != 0)
            {
              k = j;
              i = m;
              if (paramafvu.jdField_a_of_type_Apxv.a.extensionHeight != 0)
              {
                k = paramafvu.jdField_a_of_type_Apxv.a.extensionWidth;
                i = paramafvu.jdField_a_of_type_Apxv.a.extensionHeight;
              }
            }
            j = k;
            if (k != i) {
              j = i;
            }
            n = (j * this.jdField_e_of_type_Int + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
            i = (this.jdField_e_of_type_Int * i + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
            paramafvu.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(n, i));
            localObject2 = paramafvu.jdField_a_of_type_AndroidWidgetTextView.getTag();
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
          if ((paramafvu.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (i != -1))
          {
            localObject3 = (String)paramafvu.jdField_a_of_type_AndroidWidgetTextView.getTag(2131363793);
            String str = (String)paramafvu.jdField_a_of_type_AndroidWidgetTextView.getTag(2131363792);
            Paint localPaint = new Paint(1);
            localPaint.setTextSize(aepi.a(12.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
            localPaint.setTextAlign(Paint.Align.LEFT);
            int i1 = (int)localPaint.measureText("...");
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {}
            for (j = (int)localPaint.measureText(alud.a(2131706861) + (String)localObject3);; j = (int)localPaint.measureText(alud.a(2131706857)))
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
                localObject2 = paramafvu.jdField_a_of_type_Apxv.a("fromAIO", bool, true, paramafvu);
                paramString = (String)localObject1;
                localObject1 = localObject2;
                break;
              }
              j = paramafvu.jdField_a_of_type_Apxv.a.width;
              break label201;
              m = paramafvu.jdField_a_of_type_Apxv.a.height;
              break label219;
            }
            if (!((String)localObject2).equals(""))
            {
              localObject2 = a(i, (String)localObject2 + "...", (String)localObject3);
              paramafvu.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
            }
          }
          paramafvu.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          localObject2 = paramafvu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
          if (localObject1 != null) {}
          switch (((URLDrawable)localObject1).getStatus())
          {
          default: 
            paramafvu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            ((BaseChatItemLayout)localObject2).setProgressVisable(true);
            paramafvu.d.setVisibility(8);
            paramafvu.c.setVisibility(8);
            paramafvu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
            if ((paramChatMessage.isFlowMessage) && (paramafvu.jdField_a_of_type_Apxv.a.jobType == 0)) {
              if (!(this.jdField_b_of_type_AndroidContentContext instanceof MultiForwardActivity))
              {
                if (!paramChatMessage.isSend()) {
                  break label1309;
                }
                paramafvu.c.setImageResource(2130846655);
                paramafvu.c.setVisibility(0);
              }
            }
            break;
          }
          for (;;)
          {
            if ((paramafvu.jdField_a_of_type_Apxv.b()) && (paramafvu.jdField_a_of_type_Apxv.c()) && ((paramChatMessage instanceof MessageForMarketFace)))
            {
              if (paramafvu.jdField_a_of_type_Apxv.a() != null)
              {
                paramChatMessage = (RelativeLayout.LayoutParams)paramafvu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
                paramChatMessage.width = aepi.a(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
                paramafvu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramafvu.jdField_a_of_type_Apxv.a(), paramChatMessage.width, paramafvu.jdField_a_of_type_Apxv.b());
                if (Build.VERSION.SDK_INT < 19)
                {
                  paramChatMessage = (RelativeLayout.LayoutParams)paramafvu.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
                  localObject2 = (RelativeLayout.LayoutParams)paramafvu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
                  paramChatMessage.width = aepi.a(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
                  ((RelativeLayout.LayoutParams)localObject2).width = aepi.a(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
                }
              }
              i = paramafvu.jdField_a_of_type_Apxv.c();
              j = paramafvu.jdField_a_of_type_Apxv.d();
              paramChatMessage = new azuy(i, 1, 1, aepi.a(22.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
              paramafvu.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(paramChatMessage);
              paramafvu.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView.setDrawColor(i);
              paramafvu.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView.postInvalidate();
              paramafvu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(j);
              paramafvu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(j);
            }
            if (localObject1 != null) {
              a(paramafvu, (URLDrawable)localObject1, paramString);
            }
            c(paramafvu);
            return;
            if (!atzj.a()) {
              paramafvu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            }
            if ((apvx.a()) && (2 == paramafvu.jdField_a_of_type_Apxv.a.jobType) && (!this.jdField_a_of_type_Apro.e(paramafvu.jdField_a_of_type_Apxv.a.epId)) && (!apvx.c())) {
              break;
            }
            float f1 = this.jdField_a_of_type_Apro.a(paramafvu.jdField_a_of_type_Apxv.a.epId);
            if ((f1 >= 0.0F) && (1.0F != f1)) {
              break;
            }
            paramafvu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            ((BaseChatItemLayout)localObject2).setProgressVisable(false);
            break;
            paramafvu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            ((BaseChatItemLayout)localObject2).setProgressVisable(false);
            if (!AppSetting.c) {
              break;
            }
            paramafvu.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(alud.a(2131706860));
            break;
            paramafvu.d.setImageResource(2130846655);
            paramafvu.d.setVisibility(0);
            continue;
            if ((paramChatMessage.isDui) && (DuiButtonImageView.jdField_a_of_type_Boolean) && (!auud.a(paramChatMessage)))
            {
              paramafvu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
              if ((paramChatMessage.isSend()) || (paramafvu.jdField_a_of_type_Apxv.b()))
              {
                paramafvu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
                paramafvu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
              }
              else if ((paramafvu.jdField_a_of_type_Apxv != null) && (paramafvu.jdField_a_of_type_Apxv.a != null) && ((2 == paramafvu.jdField_a_of_type_Apxv.a.jobType) || (4 == paramafvu.jdField_a_of_type_Apxv.a.jobType)))
              {
                paramafvu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
                paramafvu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
              }
              else
              {
                if (!paramChatMessage.hasPlayedDui) {
                  paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramafvu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView);
                }
                for (;;)
                {
                  if (!DuiButtonImageView.jdField_a_of_type_Boolean) {
                    break label1511;
                  }
                  paramafvu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(this);
                  paramafvu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(0);
                  break;
                  paramafvu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.f();
                }
                paramafvu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(null);
                paramafvu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
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
      bdgm.a(paramContext, 230, paramString1, paramString2, 2131690648, 2131691705, new afvl(paramEmoticon, paramContext, paramQQAppInterface, paramInt), new afvn()).show();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EmosmDetailActivity.showCustomMarketFaceTips", 2, paramContext.getMessage());
    }
  }
  
  private void b(afvu paramafvu)
  {
    if ((4 != paramafvu.jdField_a_of_type_Apxv.a.jobType) || (((MessageForMarketFace)paramafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Apro.a(paramafvu.jdField_a_of_type_Apxv.a.epId, true, true)) {
        break;
      }
      if (!apvx.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone: H5MagicSource isnot Intact , and network isnot 2 3 4G or wifi;epId = " + paramafvu.jdField_a_of_type_Apxv.a.epId);
        }
        paramafvu.f.setVisibility(8);
        return;
      }
    } while (-1.0F != this.jdField_a_of_type_Apro.a(paramafvu.jdField_a_of_type_Apxv.a.epId));
    aprn.a().a(this.jdField_a_of_type_Apsb);
    EmoticonPackage localEmoticonPackage = new EmoticonPackage();
    localEmoticonPackage.name = paramafvu.jdField_a_of_type_Apxv.a.name;
    localEmoticonPackage.epId = paramafvu.jdField_a_of_type_Apxv.a.epId;
    localEmoticonPackage.jobType = 5;
    localEmoticonPackage.type = 1;
    localEmoticonPackage.isMagicFaceDownloading = true;
    ((aufn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramafvu.jdField_a_of_type_Apxv.a);
    this.jdField_a_of_type_JavaUtilList.add(paramafvu);
    paramafvu.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
    paramafvu.f.setVisibility(8);
    paramafvu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    ((MessageForMarketFace)paramafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
    this.jdField_a_of_type_Apro.a(localEmoticonPackage, false);
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone,start download epId = " + paramafvu.jdField_a_of_type_Apxv.a.epId);
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, localEmoticonPackage.epId, "", "", "");
    return;
    if ((this.f) && (this.jdField_a_of_type_Apro.b()))
    {
      if (!this.jdField_b_of_type_Boolean) {
        paramafvu.f.setVisibility(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source intacat epId = " + paramafvu.jdField_a_of_type_Apxv.a.epId);
      }
    }
    for (;;)
    {
      paramafvu.f.setImageResource(2130837911);
      if ((((MessageForMarketFace)paramafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).isSend()) || (!((MessageForMarketFace)paramafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay) || (!this.jdField_a_of_type_Apro.a()) || (System.currentTimeMillis() - this.jdField_d_of_type_Long <= 3000L) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().p())) {
        break;
      }
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      ((MessageForMarketFace)paramafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      a(paramafvu, "1");
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramafvu.jdField_a_of_type_Apxv.a.epId, "", "", "");
      return;
      paramafvu.f.setVisibility(8);
    }
  }
  
  private void c(afvu paramafvu)
  {
    paramafvu.jdField_a_of_type_Boolean = false;
    if ((2 != paramafvu.jdField_a_of_type_Apxv.a.jobType) || (((MessageForMarketFace)paramafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null) || (!atzj.a())) {}
    for (;;)
    {
      return;
      Object localObject;
      if (!this.jdField_a_of_type_Apro.e(paramafvu.jdField_a_of_type_Apxv.a.epId))
      {
        if (!apvx.a())
        {
          paramafvu.f.setVisibility(8);
          return;
        }
        if ((!apvx.c()) && (!this.jdField_a_of_type_Apro.a(paramafvu.jdField_a_of_type_Apxv.a.epId, Boolean.valueOf(false))) && (-1.0F == this.jdField_a_of_type_Apro.a(paramafvu.jdField_a_of_type_Apxv.a.epId)))
        {
          aprn.a().a(this.jdField_a_of_type_Apsb);
          localObject = new EmoticonPackage();
          ((EmoticonPackage)localObject).name = paramafvu.jdField_a_of_type_Apxv.a.name;
          ((EmoticonPackage)localObject).epId = paramafvu.jdField_a_of_type_Apxv.a.epId;
          ((EmoticonPackage)localObject).jobType = 3;
          ((EmoticonPackage)localObject).rscType = atxu.a(paramafvu.jdField_a_of_type_Apxv.a.magicValue);
          ((EmoticonPackage)localObject).type = 1;
          ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
          ((aufn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramafvu.jdField_a_of_type_Apxv.a);
          this.jdField_a_of_type_JavaUtilList.add(paramafvu);
          paramafvu.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
          paramafvu.f.setVisibility(8);
          paramafvu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((MessageForMarketFace)paramafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          this.jdField_a_of_type_Apro.a((EmoticonPackage)localObject, false);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongXiazai", 0, 0, paramafvu.jdField_a_of_type_Apxv.a.epId, "", "", "");
        }
      }
      else
      {
        if (atxu.a(paramafvu.jdField_a_of_type_Apxv.a.magicValue) == 1) {
          paramafvu.f.setVisibility(8);
        }
        while (((MessageForMarketFace)paramafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay)
        {
          ((MessageForMarketFace)paramafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          localObject = new Emoticon();
          ((Emoticon)localObject).eId = paramafvu.jdField_a_of_type_Apxv.a.eId;
          ((Emoticon)localObject).epId = paramafvu.jdField_a_of_type_Apxv.a.epId;
          ((Emoticon)localObject).magicValue = paramafvu.jdField_a_of_type_Apxv.a.magicValue;
          ((Emoticon)localObject).jobType = paramafvu.jdField_a_of_type_Apxv.a.jobType;
          if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() != null) && (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null) && (atzj.a())) {
            ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a((Emoticon)localObject, 1, ((MessageForMarketFace)paramafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage).senderuin, false);
          }
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramafvu.jdField_a_of_type_Apxv.a.epId, "", "", "");
          return;
          if (!this.jdField_b_of_type_Boolean)
          {
            paramafvu.f.setImageResource(2130837911);
            paramafvu.f.setVisibility(0);
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
  
  private void d(afvu paramafvu)
  {
    if ((paramafvu != null) && (paramafvu.jdField_a_of_type_Apxv != null) && (paramafvu.jdField_a_of_type_Apxv.c()) && (paramafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (!this.jdField_c_of_type_JavaUtilSet.contains(Long.valueOf(paramafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))))
    {
      aufn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AB51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramafvu.jdField_a_of_type_Apxv.a.epId);
      this.jdField_c_of_type_JavaUtilSet.add(Long.valueOf(paramafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aeqi a()
  {
    return new afvu();
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    long l = System.currentTimeMillis();
    paramBaseChatItemLayout = (MessageForMarketFace)paramChatMessage;
    afvu localafvu = (afvu)paramaeqi;
    this.jdField_b_of_type_JavaUtilSet.add(localafvu);
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
      paramaeqi = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject2 = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout)localObject2).setId(2131370078);
      paramView = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      paramView.setId(2131366588);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131364173);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131364173);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setOnClickListener(this);
      localObject1 = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).setId(2131363207);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = 8;
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131366588);
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      ((FrameLayout)localObject1).setOnClickListener(this);
      ((FrameLayout)localObject1).setOnTouchListener(paramaetk);
      ((FrameLayout)localObject1).setOnLongClickListener(paramaetk);
      paramaetk = new afvv(this, this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).addView(paramaetk, -2, -2);
      localObject4 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localObject5 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject5).gravity = 85;
      ((FrameLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject5).setId(2131380074);
      localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(1, 2131363207);
      ((RelativeLayout.LayoutParams)localObject6).addRule(8, 2131363207);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      ((ImageView)localObject5).setOnClickListener(this);
      localObject6 = new BreathAnimationLayout(this.jdField_b_of_type_AndroidContentContext);
      ((BreathAnimationLayout)localObject6).setId(2131371103);
      localPttAudioPlayView = new PttAudioPlayView(this.jdField_b_of_type_AndroidContentContext, 10);
      localPttAudioPlayView.setThemeColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131166921).getDefaultColor());
      localPttAudioPlayView.setId(2131371105);
      localPttAudioPlayView.setPttPauseOrStopDrawable(2130838101);
      localObject7 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject7).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject7).leftMargin = aepi.a(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).width = aepi.a(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).height = aepi.a(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      localPttAudioPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject7);
      localPttAudioPlayView.setOnClickListener(this);
      localObject7 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localObject8 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject8).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject8).leftMargin = aepi.a(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).width = aepi.a(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).height = aepi.a(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((ImageView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
      ((ImageView)localObject7).setImageDrawable((Drawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839223));
      ((ImageView)localObject7).setVisibility(4);
      localObject8 = new PttAudioWaveView(this.jdField_b_of_type_AndroidContentContext);
      ((PttAudioWaveView)localObject8).setShowProgressLine(false);
      ((PttAudioWaveView)localObject8).setMaxTopBottomPadding(4);
      ((PttAudioWaveView)localObject8).setProgressColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131166921).getDefaultColor());
      ((PttAudioWaveView)localObject8).setId(2131371106);
      localObject9 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(1, 2131371105);
      ((RelativeLayout.LayoutParams)localObject9).width = aepi.a(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).height = aepi.a(45.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).leftMargin = bdoo.a(9.0F);
      ((RelativeLayout.LayoutParams)localObject9).rightMargin = bdoo.a(12.0F);
      ((PttAudioWaveView)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
      ((PttAudioWaveView)localObject8).setCanSupportSlide(false);
      ((PttAudioWaveView)localObject8).setOnClickListener(this);
      localObject9 = new SyncParentPressedRelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      ((RelativeLayout)localObject9).setId(2131371104);
      ((RelativeLayout)localObject9).addView((View)localObject8);
      ((RelativeLayout)localObject9).addView(localPttAudioPlayView);
      ((RelativeLayout)localObject9).addView((View)localObject7);
      localRelativeLayout = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localTriangleView = new TriangleView(this.jdField_b_of_type_AndroidContentContext);
      localObject10 = new RelativeLayout.LayoutParams(bdoo.a(9.0F), bdoo.a(5.0F));
      ((RelativeLayout.LayoutParams)localObject10).leftMargin = bdoo.a(2.0F);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14);
      ((RelativeLayout.LayoutParams)localObject10).addRule(10);
      localTriangleView.setId(2131372107);
      localTriangleView.setRotation(180.0F);
      localTriangleView.setTranslationY(bdoo.a(1.0F));
      localTriangleView.setLayoutParams((ViewGroup.LayoutParams)localObject10);
      localRelativeLayout.addView(localTriangleView);
      localObject10 = new RelativeLayout.LayoutParams(-2, bdoo.a(29.0F));
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131372107);
      localRelativeLayout.addView((View)localObject9, (ViewGroup.LayoutParams)localObject10);
      ((BreathAnimationLayout)localObject6).addView(localRelativeLayout);
      localObject10 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14, 2131363207);
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131363207);
      ((RelativeLayout.LayoutParams)localObject10).bottomMargin = bdoo.a(17.0F);
      ((RelativeLayout)localObject2).addView((View)localObject6, (ViewGroup.LayoutParams)localObject10);
      localObject10 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject10).setId(2131366589);
      localObject11 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject11).addRule(1, 2131363207);
      ((RelativeLayout.LayoutParams)localObject11).addRule(15, 2131363207);
      ((RelativeLayout.LayoutParams)localObject11).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject10, (ViewGroup.LayoutParams)localObject11);
      ((ImageView)localObject10).setOnClickListener(this);
      localObject11 = new DuiButtonImageView(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      ((DuiButtonImageView)localObject11).setId(2131365502);
      localObject12 = new RelativeLayout.LayoutParams(aepi.a(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), aepi.a(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject12).addRule(1, 2131363207);
      ((RelativeLayout.LayoutParams)localObject12).addRule(8, 2131363207);
      ((RelativeLayout.LayoutParams)localObject12).setMargins(0, 0, 0, -aepi.a(6.5F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout)localObject2).addView((View)localObject11, (ViewGroup.LayoutParams)localObject12);
      localObject12 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject12).setId(2131369992);
      localObject13 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject13).addRule(1, 2131363207);
      ((RelativeLayout.LayoutParams)localObject13).addRule(8, 2131363207);
      ((RelativeLayout.LayoutParams)localObject13).leftMargin = aepi.a(10.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout)localObject2).addView((View)localObject12, (ViewGroup.LayoutParams)localObject13);
      localObject13 = new TextView(this.jdField_b_of_type_AndroidContentContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      ((TextView)localObject13).setTextSize(12.0F);
      ((TextView)localObject13).setTextColor(-1);
      localLayoutParams.topMargin = aepi.a(8.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((TextView)localObject13).setGravity(17);
      localLayoutParams.addRule(3, 2131370078);
    }
    for (;;)
    {
      try
      {
        ((TextView)localObject13).setBackgroundDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130844377));
        ((TextView)localObject13).setPadding(aepi.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), aepi.a(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), aepi.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), aepi.a(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
        paramaeqi.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramaeqi.addView((View)localObject13, localLayoutParams);
        ((ImageView)localObject12).setOnClickListener(this);
        localObject2 = new ProgressBar(this.jdField_b_of_type_AndroidContentContext, null, 0);
        ((ProgressBar)localObject2).setId(2131364200);
      }
      catch (Exception localException2)
      {
        try
        {
          ((ProgressBar)localObject2).setIndeterminateDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839225));
          int i = aepi.a(16.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
          localObject3 = new FrameLayout.LayoutParams(i, i);
          ((FrameLayout.LayoutParams)localObject3).gravity = 17;
          ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          localafvu.jdField_e_of_type_AndroidWidgetImageView = paramaetk;
          localafvu.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject4);
          localafvu.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject5);
          localafvu.c = paramView;
          localafvu.d = ((ImageView)localObject10);
          localafvu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView = ((DuiButtonImageView)localObject11);
          localafvu.f = ((ImageView)localObject12);
          localafvu.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localObject1);
          localafvu.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject2);
          localafvu.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject13);
          localafvu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)localObject6);
          localafvu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = localPttAudioPlayView;
          localafvu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject8);
          localafvu.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject9);
          localafvu.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
          localafvu.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView = localTriangleView;
          localafvu.g = ((ImageView)localObject7);
          if (!c(paramChatMessage)) {
            paramBaseChatItemLayout.playProgress = 0.0F;
          }
          a(localafvu, paramChatMessage.uniseq);
          localafvu.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          localafvu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramBaseChatItemLayout.playProgress);
          if ((AppSetting.c) && (a(paramChatMessage, localafvu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) && (localafvu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)) {
            localafvu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setContentDescription(alud.a(2131706862));
          }
          new QueryTask(new afvo(this, localafvu), new afvp(this, localafvu, paramBaseChatItemLayout, paramChatMessage, l)).a(paramBaseChatItemLayout.mMarkFaceMessage);
          return paramaeqi;
          localException2 = localException2;
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException2);
        }
        catch (Exception localException1)
        {
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException1);
          continue;
        }
      }
      if ((localafvu.jdField_a_of_type_Apxv != null) && (localafvu.jdField_a_of_type_Apxv.b()) && (localafvu.jdField_b_of_type_AndroidWidgetImageView != null) && ((localafvu.jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof AnimationDrawable))) {
        localafvu.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846675);
      }
      paramaeqi = paramView;
      if (AppSetting.c)
      {
        localafvu.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        paramaeqi = paramView;
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (!bdil.a(paramChatMessage.issend)) {
        break label103;
      }
      localStringBuilder.append("发出表情");
    }
    for (;;)
    {
      paramChatMessage = (MessageForMarketFace)paramChatMessage;
      if (paramChatMessage.mMarkFaceMessage != null)
      {
        paramChatMessage = ((aufn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramChatMessage.mMarkFaceMessage);
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
    aprn.a().b(this.jdField_a_of_type_Apsb);
    aprn.a().b(this.jdField_a_of_type_Afvt);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((afvu)localIterator.next()).a();
    }
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((jdField_a_of_type_Apxv == null) || (jdField_a_of_type_Apxv.a == null))
    {
      QLog.e("MarketFaceItemBuilder", 1, "onMenuItemClicked emoticon is null");
      return;
    }
    if ((paramInt == 2131365071) || (paramInt == 2131362126) || (paramInt == 2131366776) || (paramInt == 2131366487))
    {
      ((aufn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(jdField_a_of_type_Apxv.a.epId, new afvm(this, paramInt, paramChatMessage));
      return;
    }
    if (paramInt == 2131370861)
    {
      super.d(paramChatMessage);
      return;
    }
    if (paramInt == 2131370818)
    {
      super.a(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  void a(afvu paramafvu, URLDrawable paramURLDrawable)
  {
    a(paramafvu, paramURLDrawable, "");
  }
  
  void a(afvu paramafvu, URLDrawable paramURLDrawable, String paramString)
  {
    paramafvu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramafvu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
    paramafvu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramafvu.f.setVisibility(8);
    paramafvu.jdField_b_of_type_Boolean = false;
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
        if (paramafvu.jdField_a_of_type_Apxv.b()) {
          if (paramafvu.jdField_a_of_type_Apxv.c()) {
            paramafvu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          }
        }
      }
      while (!"big_sound".equals(str))
      {
        do
        {
          return;
          paramafvu.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846675);
          paramafvu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        } while ((i != 1) || (paramafvu.jdField_a_of_type_Apxv.j != 3));
        paramafvu.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837908);
        paramafvu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramafvu.jdField_b_of_type_Boolean = true;
        return;
      }
      if (c(paramafvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
      {
        if (paramafvu.jdField_a_of_type_Apxv.c())
        {
          paramafvu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          paramafvu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          return;
        }
        paramafvu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramURLDrawable = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772260);
        paramafvu.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
        paramURLDrawable.start();
        return;
      }
      if (paramafvu.jdField_a_of_type_Apxv.c())
      {
        paramafvu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
        paramafvu.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
        return;
      }
      paramafvu.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846675);
      paramafvu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
  }
  
  public void a(View paramView)
  {
    paramView = (afvu)aepi.a(paramView);
    String str1;
    String str2;
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSendFromLocal())
    {
      str1 = this.jdField_b_of_type_AndroidContentContext.getString(2131690042);
      str2 = this.jdField_b_of_type_AndroidContentContext.getString(2131690043);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 41) && (paramView.jdField_a_of_type_Apxv != null) && (paramView.jdField_a_of_type_Apxv.a != null)) {
        a((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_Apxv);
      }
    }
    do
    {
      return;
      bdgm.a(this.jdField_b_of_type_AndroidContentContext, 230, str1, str2, new afvi(this, paramView), new afvj(this)).show();
      return;
      paramView = paramView.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
    } while (!(paramView instanceof URLDrawable));
    ((URLDrawable)paramView).restartDownload();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, azkz.a(10.0F), 0);
  }
  
  protected void a(MessageForMarketFace paramMessageForMarketFace, apxv paramapxv)
  {
    if ((paramMessageForMarketFace == null) || (paramapxv == null) || (paramapxv.a == null) || (paramapxv.a.epId == null)) {
      return;
    }
    bhuf localbhuf = (bhuf)bhus.a(this.jdField_b_of_type_AndroidContentContext, null);
    localbhuf.a(this.jdField_b_of_type_AndroidContentContext.getString(2131692102));
    localbhuf.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131692101), 1);
    localbhuf.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131692103), 1);
    localbhuf.c(2131690648);
    localbhuf.a(new afvk(this, paramapxv, localbhuf, paramMessageForMarketFace));
    localbhuf.show();
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if ((paramView != null) && (paramFloat > 0.0F))
    {
      paramXListView = (afvu)aepi.a(paramView);
      if ((paramXListView != null) && (paramXListView.jdField_a_of_type_Apxv != null) && (paramXListView.jdField_a_of_type_Apxv.b()) && (paramXListView.jdField_a_of_type_Apxv.c()) && (c(paramChatMessage)))
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
      paramXListView = (afvu)aepi.a(paramView);
      if (!paramXListView.jdField_a_of_type_Apxv.c()) {
        break label66;
      }
      paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
        paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
      }
    }
    for (;;)
    {
      paramView = paramXListView.jdField_a_of_type_Apxv.a("fromAIO", false);
      paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      return;
      label66:
      paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846675);
    }
  }
  
  public boolean a(aeqi paramaeqi)
  {
    return paramaeqi instanceof afvu;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer, int paramInt2)
  {
    paramXListView = (afvu)aepi.a(paramView);
    if ((paramXListView == null) || (paramXListView.jdField_a_of_type_Apxv == null) || (paramXListView.jdField_a_of_type_Apxv.a == null)) {
      return false;
    }
    if (paramXListView.jdField_a_of_type_Apxv.b())
    {
      paramView = apvx.o.replace("[epId]", paramXListView.jdField_a_of_type_Apxv.a.epId).replace("[eId]", paramXListView.jdField_a_of_type_Apxv.a.eId);
      if (!bdhb.b(paramView))
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
        paramView = paramXListView.jdField_a_of_type_Apxv.a("fromAIO", true);
        paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        apxv.a(paramView);
        if (paramXListView.jdField_a_of_type_Apxv.c()) {
          if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
            paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          }
        }
        for (;;)
        {
          return true;
          paramView = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772260);
          paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
          paramView.start();
        }
      }
    }
    return false;
  }
  
  public bdpk[] a(View paramView)
  {
    paramView = (afvu)aepi.a(paramView);
    bdpi localbdpi = new bdpi();
    jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (ApolloUtil.a(jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
      return localbdpi.a();
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
        if (paramView.jdField_a_of_type_Apxv.a.jobType != 1)
        {
          jdField_a_of_type_Apxv = paramView.jdField_a_of_type_Apxv;
          if (aepi.a(1) == 1) {
            localbdpi.a(2131362126, this.jdField_b_of_type_AndroidContentContext.getString(2131693477), 2130838676);
          }
          localbdpi.a(2131366776, this.jdField_b_of_type_AndroidContentContext.getString(2131692837), 2130838678);
          a(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbdpi);
          if ((paramView.jdField_a_of_type_Apxv.a.jobType != 2) && (paramView.jdField_a_of_type_Apxv.a.jobType != 4)) {
            localbdpi.a(2131366487, this.jdField_b_of_type_AndroidContentContext.getString(2131693486), 2130838657);
          }
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Ap_show_forward", 0);
        }
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
          a(localbdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        a(localbdpi, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        if (paramView.jdField_a_of_type_Apxv.a.jobType != 1) {
          b(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbdpi);
        }
        super.c(localbdpi, this.jdField_b_of_type_AndroidContentContext);
        super.e(localbdpi, this.jdField_b_of_type_AndroidContentContext);
      }
      for (;;)
      {
        return localbdpi.a();
        jdField_a_of_type_Apxv = paramView.jdField_a_of_type_Apxv;
        acjm.a(localbdpi, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public void d(View paramView)
  {
    aepi.n = true;
    if (super.a()) {
      return;
    }
    Object localObject3;
    Drawable localDrawable;
    URLDrawable localURLDrawable;
    Object localObject1;
    if (paramView.getId() == 2131363207)
    {
      localObject3 = (afvu)aepi.a(paramView);
      localDrawable = ((afvu)localObject3).jdField_e_of_type_AndroidWidgetImageView.getDrawable();
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
        if ((((afvu)localObject3).jdField_a_of_type_Apxv != null) && (((afvu)localObject3).jdField_a_of_type_Apxv.a != null) && (((afvu)localObject3).jdField_a_of_type_Apxv.a.jobType == 2) && (atzj.a())) {
          a((afvu)localObject3);
        }
        if ((((URLDrawable)localDrawable).getStatus() != 1) && ((((afvu)localObject3).jdField_a_of_type_Apxv == null) || (((afvu)localObject3).jdField_a_of_type_Apxv.a == null) || (!((afvu)localObject3).jdField_a_of_type_Apxv.e()))) {
          break;
        }
        a((afvu)localObject3, zjc.a(paramView));
        return;
        localObject2 = "";
        if ((localURLDrawable.getStateTag() instanceof Bundle)) {
          localObject2 = ((Bundle)localURLDrawable.getStateTag()).getString("display_type");
        }
        localURLDrawable.restartDownload();
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "msgOnclickListener| URLDrawable restartDownload status=" + localURLDrawable.getStatus());
        }
        a((afvu)localObject3, localURLDrawable, (String)localObject2);
        ((afvu)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        if ((((afvu)localObject3).jdField_a_of_type_Apxv != null) && (((afvu)localObject3).jdField_a_of_type_Apxv.b()) && ("big_sound".equals(localObject1)))
        {
          jdField_c_of_type_Long = ((afvu)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
          continue;
          if ((((afvu)localObject3).jdField_a_of_type_Apxv != null) && (((afvu)localObject3).jdField_a_of_type_Apxv.a != null) && (((afvu)localObject3).jdField_a_of_type_Apxv.a.jobType != 0) && (((afvu)localObject3).jdField_a_of_type_Apxv.a.jobType != 2) && (((afvu)localObject3).jdField_a_of_type_Apxv.a.jobType != 4))
          {
            ((afvu)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            if ("big_sound".equals(localObject1))
            {
              if ((((afvu)localObject3).jdField_a_of_type_Apxv.a != null) && (((afvu)localObject3).jdField_a_of_type_Apxv.a.isSound)) {
                if (c(((afvu)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
                  MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
                } else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
                  QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695682, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
                } else {
                  MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((afvu)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
                }
              }
            }
            else if ("aio_preview".equals(localObject1))
            {
              localObject1 = ((afvu)localObject3).jdField_a_of_type_Apxv.a("fromAIO", true);
              if (localObject1 != null)
              {
                ((afvu)localObject3).jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
                ((afvu)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
                a((afvu)localObject3, (URLDrawable)localObject1);
                if (((afvu)localObject3).jdField_a_of_type_Apxv.b()) {
                  jdField_c_of_type_Long = ((afvu)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
                }
              }
            }
          }
        }
      }
      if ((!(localDrawable instanceof atxk)) || (((afvu)localObject3).jdField_a_of_type_Apxv == null) || (((afvu)localObject3).jdField_a_of_type_Apxv.a == null) || (!((afvu)localObject3).jdField_a_of_type_Apxv.e())) {
        break;
      }
      a((afvu)localObject3, zjc.a(paramView));
      return;
      if (paramView.getId() == 2131380074)
      {
        localObject1 = (afvu)aepi.a(paramView);
        if ((((afvu)localObject1).jdField_a_of_type_Apxv != null) && (((afvu)localObject1).jdField_a_of_type_Apxv.b()))
        {
          if (!c(((afvu)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
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
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695682, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
            }
            else
            {
              MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((afvu)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
              continue;
              if ((paramView.getId() == 2131371105) || (paramView.getId() == 2131371106))
              {
                localObject2 = (afvu)aepi.a(paramView);
                if ((((afvu)localObject2).jdField_a_of_type_Apxv != null) && (((afvu)localObject2).jdField_a_of_type_Apxv.b()) && (((afvu)localObject2).jdField_a_of_type_Apxv.c()))
                {
                  int i;
                  if (c(((afvu)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage))
                  {
                    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
                    localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                    i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
                    if (((afvu)localObject2).jdField_a_of_type_Apxv.a != null) {}
                    for (localObject1 = ((afvu)localObject2).jdField_a_of_type_Apxv.a.epId;; localObject1 = "")
                    {
                      aufn.a((QQAppInterface)localObject3, "0X800A934", i, (String)localObject1);
                      break;
                    }
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
                  {
                    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695682, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
                  }
                  else
                  {
                    if ((((afvu)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMarketFace)) {
                      ((MessageForMarketFace)((afvu)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage).playProgress = 0.0F;
                    }
                    ((afvu)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
                    boolean bool = false;
                    if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((afvu)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage))
                    {
                      bool = true;
                      ((afvu)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
                      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
                      if (((afvu)localObject2).jdField_a_of_type_Apxv.a != null)
                      {
                        localObject1 = ((afvu)localObject2).jdField_a_of_type_Apxv.a.epId;
                        aufn.a((QQAppInterface)localObject3, "0X800A933", i, (String)localObject1);
                      }
                    }
                    else
                    {
                      if (!bool)
                      {
                        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                        if (((afvu)localObject2).jdField_a_of_type_Apxv.a == null) {
                          break label1239;
                        }
                        localObject1 = ((afvu)localObject2).jdField_a_of_type_Apxv.a.epId;
                        aufn.a((QQAppInterface)localObject3, "0X800A935", -1, (String)localObject1);
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
                      azri.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "NewAudioEmoticonVoicePlay", bool, 0L, 0L, (HashMap)localObject2, null);
                      break;
                      localObject1 = "";
                      break label1105;
                      localObject1 = "";
                      break label1150;
                    }
                  }
                }
              }
              else if ((paramView.getId() == 2131366589) || (paramView.getId() == 2131366588))
              {
                localObject1 = (afvu)aepi.a(paramView);
                localObject2 = a();
                if (localObject2 != null)
                {
                  ((bety)localObject2).a(this.jdField_b_of_type_AndroidContentContext.getString(2131692106));
                  ((bety)localObject2).show();
                }
                ((aufn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(((afvu)localObject1).jdField_a_of_type_Apxv.a.epId, new afvh(this, (afvu)localObject1, (bety)localObject2));
              }
              else
              {
                if (paramView.getId() != 2131365502) {
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
        } while (paramView.getId() != 2131369992);
        localObject1 = (afvu)aepi.a(paramView);
        if ((((afvu)localObject1).jdField_a_of_type_Apxv != null) && (((afvu)localObject1).jdField_a_of_type_Apxv.a != null) && (2 == ((afvu)localObject1).jdField_a_of_type_Apxv.a.jobType))
        {
          if (this.jdField_a_of_type_Apro.a(((afvu)localObject1).jdField_a_of_type_Apxv.a.epId, Boolean.valueOf(false))) {
            break;
          }
          aprn.a().a(this.jdField_a_of_type_Apsb);
          localObject2 = new EmoticonPackage();
          ((EmoticonPackage)localObject2).name = ((afvu)localObject1).jdField_a_of_type_Apxv.a.name;
          ((EmoticonPackage)localObject2).epId = ((afvu)localObject1).jdField_a_of_type_Apxv.a.epId;
          ((EmoticonPackage)localObject2).jobType = 3;
          ((EmoticonPackage)localObject2).type = 1;
          ((EmoticonPackage)localObject2).isMagicFaceDownloading = true;
          ((afvu)localObject1).jdField_a_of_type_Boolean = false;
          ((MessageForMarketFace)((afvu)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          ((aufn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(((afvu)localObject1).jdField_a_of_type_Apxv.a);
          this.jdField_a_of_type_JavaUtilList.add(localObject1);
          ((afvu)localObject1).f.setVisibility(8);
          ((afvu)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          this.jdField_a_of_type_Apro.a((EmoticonPackage)localObject2, false);
          azqs.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongBofang", 0, 0, ((afvu)localObject1).jdField_a_of_type_Apxv.a.epId, "", "", "");
        }
      } while ((((afvu)localObject1).jdField_a_of_type_Apxv == null) || (((afvu)localObject1).jdField_a_of_type_Apxv.a == null) || (4 != ((afvu)localObject1).jdField_a_of_type_Apxv.a.jobType) || (System.currentTimeMillis() - this.jdField_d_of_type_Long <= 3000L) || (!this.jdField_a_of_type_Apro.a()));
      label1239:
      label1247:
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_Apro.a(((afvu)localObject1).jdField_a_of_type_Apxv.a.epId, true, true)) {
        a((afvu)localObject1, "0");
      }
      for (;;)
      {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbFasong", "MbZhudongBofang", 0, 0, ((afvu)localObject1).jdField_a_of_type_Apxv.a.epId, "", "", "");
        break;
        if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (!atzj.a()) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null)) {
          break label1692;
        }
        ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a(((afvu)localObject1).jdField_a_of_type_Apxv.a, 1, ((afvu)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, true);
        break label1692;
        aprn.a().a(this.jdField_a_of_type_Apsb);
        localObject2 = new EmoticonPackage();
        ((EmoticonPackage)localObject2).name = ((afvu)localObject1).jdField_a_of_type_Apxv.a.name;
        ((EmoticonPackage)localObject2).epId = ((afvu)localObject1).jdField_a_of_type_Apxv.a.epId;
        ((EmoticonPackage)localObject2).jobType = 5;
        ((EmoticonPackage)localObject2).type = 1;
        ((EmoticonPackage)localObject2).isMagicFaceDownloading = true;
        ((afvu)localObject1).jdField_a_of_type_Boolean = false;
        ((MessageForMarketFace)((afvu)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
        ((aufn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(((afvu)localObject1).jdField_a_of_type_Apxv.a);
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
        ((afvu)localObject1).f.setVisibility(8);
        ((afvu)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_Apro.a((EmoticonPackage)localObject2, false);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_b_of_type_AndroidContentContext;
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvg
 * JD-Core Version:    0.7.0.1
 */