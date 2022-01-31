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
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.11;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.15;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.16;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.17;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.18;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.19;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.9;
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

public class adje
  extends BaseBubbleBuilder
  implements acmr
{
  public static anla a;
  public static ChatMessage a;
  public static int c;
  static long c;
  adjs jdField_a_of_type_Adjs = new adjs();
  public anfj a;
  anfw jdField_a_of_type_Anfw = new adjg(this);
  public List<adjt> a;
  public Set<Long> a;
  public Context b;
  Set<adjt> b;
  public int d;
  private long d;
  public int e;
  public boolean f = false;
  
  static
  {
    jdField_c_of_type_Int = 1;
  }
  
  public adje(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_d_of_type_Int = 320;
    this.jdField_e_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Anfj = ((anfj)paramQQAppInterface.getManager(43));
    if ((this.jdField_b_of_type_AndroidContentContext instanceof SplashActivity)) {
      this.f = true;
    }
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, Handler paramHandler)
  {
    boolean bool = true;
    ancg localancg = (ancg)paramQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("MarketFaceItemBuilder", 2, "Call getEmoticonDataList from addEmotionToFavorite.");
    }
    List localList = localancg.a();
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
          if (localancg.a(localCustomEmotionData, j))
          {
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramHandler != null) {
              paramHandler.post(new MarketFaceItemBuilder.18(paramContext));
            }
            arnz.c("0", 1);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
            }
            return 0;
          }
          if (paramHandler != null) {
            paramHandler.post(new MarketFaceItemBuilder.19(paramContext));
          }
          arnz.c("2003", 1);
          return 0;
        }
        n = i;
        if (i < localCustomEmotionData.emoId) {
          n = localCustomEmotionData.emoId;
        }
        j += 1;
        m = k;
      }
      if (m >= ance.a) {
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
      paramEmoticon = ((arnz)paramQQAppInterface.getManager(14)).a(paramEmoticon.epId);
      if (paramEmoticon != null) {
        if (paramEmoticon.isAPNG != 2) {
          break label425;
        }
      }
      for (;;)
      {
        paramHandler.isAPNG = bool;
        paramEmoticon = (anch)paramQQAppInterface.getManager(103);
        if (paramEmoticon != null) {
          paramEmoticon.b(paramHandler, new anbp(paramQQAppInterface, paramContext, paramHandler, null, 0));
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
      i = 2131625416;
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
      paramInt = 2131625417;
      paramString2 = ajjy.a(2131640684);
      continue;
      paramString2 = ajjy.a(2131640679);
      paramInt = i;
      continue;
      paramString2 = ajjy.a(2131640676);
      paramInt = i;
      continue;
      paramString2 = ajjy.a(2131640686);
      paramInt = i;
    }
  }
  
  private bbms a()
  {
    if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a == null) {
        ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a = new bbms(this.jdField_b_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a;
    }
    return null;
  }
  
  private String a()
  {
    try
    {
      i = badq.a(this.jdField_b_of_type_AndroidContentContext);
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
    this.jdField_a_of_type_Adjs.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_Anla, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a());
    anfi.a().a(this.jdField_a_of_type_Adjs);
    this.jdField_a_of_type_Anfj.a(jdField_a_of_type_Anla.a.epId, anfj.jdField_c_of_type_Int);
  }
  
  public static void a(int paramInt1, Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, int paramInt2, String paramString, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramEmoticon == null) {
      QLog.d("MarketFaceItemBuilder", 1, "can not find emoticon");
    }
    label217:
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
            break label217;
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
            aphp.a((BaseActivity)paramContext, paramEmoticon, 21);
            return;
          }
          catch (Exception paramContext) {}
        } while (!QLog.isColorLevel());
        QLog.e("EmosmDetailActivity.operateMarketFaceFromDownLoad", 2, paramContext.getMessage());
        return;
        if (6 == paramInt1 % 1000)
        {
          ThreadManager.post(new MarketFaceItemBuilder.15(paramContext, paramQQAppInterface, paramEmoticon, localHandler), 5, null, true);
          return;
        }
      } while (107 != paramInt1 % 1000);
      awqx.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_follow_send_aio", 0, 0, "", paramEmoticon.epId, "", "");
      anla.a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, null);
      return;
      if (paramInt2 < 0)
      {
        localHandler.post(new MarketFaceItemBuilder.16(paramContext, paramString));
        if (6 == paramInt1 % 1000) {
          arnz.c("2001", 1);
        }
        QLog.i("MarketFaceItemBuilder", 1, "opType: " + paramInt1 + ",result:" + paramInt2);
        return;
      }
      localHandler.post(new MarketFaceItemBuilder.17(paramInt1, paramContext, paramQQAppInterface, paramEmoticon, paramString));
    } while (6 != paramInt1 % 1000);
    arnz.c("2002", 1);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, anla paramanla, SessionInfo paramSessionInfo, bbms parambbms)
  {
    a(paramInt, paramContext, paramQQAppInterface, paramEmoticonPackage, paramanla, paramSessionInfo, parambbms, false);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, anla paramanla, SessionInfo paramSessionInfo, bbms parambbms, boolean paramBoolean)
  {
    if (paramanla == null) {
      return;
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.mobileFeetype == 1))
    {
      if ((parambbms != null) && (parambbms.isShowing())) {
        parambbms.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramanla.a, 0, null, paramSessionInfo, paramBoolean);
      return;
    }
    if ((!badq.g(paramContext)) || (paramInt > 1000))
    {
      if ((parambbms != null) && (parambbms.isShowing())) {
        parambbms.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramanla.a, -404, ajjy.a(2131640683), paramSessionInfo, paramBoolean);
      return;
    }
    ((ajhm)paramQQAppInterface.a(12)).a(paramInt, Integer.valueOf(paramanla.a.epId).intValue(), paramanla.a.eId);
  }
  
  private void a(adjt paramadjt)
  {
    EmoticonPackage localEmoticonPackage;
    if (!this.jdField_a_of_type_Anfj.a(paramadjt.jdField_a_of_type_Anla.a.epId, Boolean.valueOf(false)))
    {
      anfi.a().a(this.jdField_a_of_type_Anfw);
      localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramadjt.jdField_a_of_type_Anla.a.name;
      localEmoticonPackage.epId = paramadjt.jdField_a_of_type_Anla.a.epId;
      localEmoticonPackage.jobType = 3;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      if (paramadjt.jdField_e_of_type_Int != -1) {
        break label222;
      }
    }
    label222:
    for (localEmoticonPackage.rscType = argh.a(paramadjt.jdField_a_of_type_Anla.a.magicValue);; localEmoticonPackage.rscType = paramadjt.jdField_e_of_type_Int)
    {
      ((arnz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramadjt.jdField_a_of_type_Anla.a);
      paramadjt.jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)paramadjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = true;
      this.jdField_a_of_type_JavaUtilList.add(paramadjt);
      paramadjt.f.setVisibility(8);
      paramadjt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_Anfj.a(localEmoticonPackage, false);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void a(adjt paramadjt, long paramLong)
  {
    Animatable localAnimatable = (Animatable)paramadjt.g.getDrawable();
    if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramLong)))
    {
      if (!localAnimatable.isRunning()) {
        localAnimatable.start();
      }
      paramadjt.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(4);
      paramadjt.g.setVisibility(0);
      return;
    }
    if (localAnimatable.isRunning()) {
      localAnimatable.stop();
    }
    paramadjt.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
    paramadjt.g.setVisibility(4);
  }
  
  private void a(adjt paramadjt, Rect paramRect)
  {
    AIOEmotionFragment.a(this.jdField_b_of_type_AndroidContentContext, paramadjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramRect);
  }
  
  private void a(adjt paramadjt, String paramString)
  {
    ThreadManager.post(new MarketFaceItemBuilder.9(this, paramString, paramadjt), 5, null, true);
  }
  
  private void a(anla paramanla, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      str2 = a();
      if (paramanla == null) {}
      for (paramanla = "";; paramanla = paramanla.a.epId)
      {
        VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramanla, paramString);
        return;
      }
    case 3: 
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramanla == null) {}
      for (paramanla = "";; paramanla = paramanla.a.epId)
      {
        awqx.b(paramString, "CliOper", "", "", "ep_mall", "0X8007187", 0, 0, paramanla, "", "", "");
        return;
      }
    }
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    String str2 = a();
    if (paramanla == null) {}
    for (paramanla = "";; paramanla = paramanla.a.epId)
    {
      VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramanla, paramString, "1", "", "", "", 0, 0, 0, 0);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    awqx.b(paramQQAppInterface, "CliOper", "", "", paramString2, paramString3, paramInt, 0, "", "", "", "");
  }
  
  private void a(ChatMessage paramChatMessage, adjt paramadjt)
  {
    a(paramChatMessage, paramadjt, "");
  }
  
  private void a(ChatMessage paramChatMessage, adjt paramadjt, String paramString)
  {
    if ((paramadjt.jdField_a_of_type_Anla.b()) && (!c(paramChatMessage))) {}
    for (boolean bool = false;; bool = true)
    {
      Object localObject3 = paramadjt.jdField_a_of_type_Anla.a("fromAIO", bool);
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
              localObject2 = paramadjt.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
              if ((localObject2 != null) && (((EmoticonPackage)localObject2).status == 2))
              {
                URLDrawable.removeMemoryCacheByUrl(((URLDrawable)localObject3).getURL().toString());
                localObject2 = paramadjt.jdField_a_of_type_Anla.a("fromAIO", bool);
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
        if ((localObject1 != null) && (paramadjt.jdField_a_of_type_Anla.a != null)) {
          if (paramadjt.jdField_a_of_type_Anla.a.width == 0)
          {
            j = 200;
            if (paramadjt.jdField_a_of_type_Anla.a.height != 0) {
              break label673;
            }
            m = 200;
            k = j;
            i = m;
            if (paramadjt.jdField_a_of_type_Anla.a.extensionWidth != 0)
            {
              k = j;
              i = m;
              if (paramadjt.jdField_a_of_type_Anla.a.extensionHeight != 0)
              {
                k = paramadjt.jdField_a_of_type_Anla.a.extensionWidth;
                i = paramadjt.jdField_a_of_type_Anla.a.extensionHeight;
              }
            }
            j = k;
            if (k != i) {
              j = i;
            }
            n = (j * this.jdField_e_of_type_Int + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
            i = (this.jdField_e_of_type_Int * i + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
            paramadjt.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(n, i));
            localObject2 = paramadjt.jdField_a_of_type_AndroidWidgetTextView.getTag();
            if (!(localObject2 instanceof Integer)) {
              break label1465;
            }
          }
        }
        label673:
        label1445:
        label1465:
        for (int i = ((Integer)localObject2).intValue();; i = -1)
        {
          if ((paramadjt.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (i != -1))
          {
            localObject3 = (String)paramadjt.jdField_a_of_type_AndroidWidgetTextView.getTag(2131298181);
            String str = (String)paramadjt.jdField_a_of_type_AndroidWidgetTextView.getTag(2131298180);
            Paint localPaint = new Paint(1);
            localPaint.setTextSize(aciy.a(12.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
            localPaint.setTextAlign(Paint.Align.LEFT);
            int i1 = (int)localPaint.measureText("...");
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {}
            for (j = (int)localPaint.measureText(ajjy.a(2131640681) + (String)localObject3);; j = (int)localPaint.measureText(ajjy.a(2131640677)))
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
                  break label1471;
                }
                URLDrawable.removeMemoryCacheByUrl(((URLDrawable)localObject3).getURL().toString());
                localObject2 = paramadjt.jdField_a_of_type_Anla.a("fromAIO", bool, true, paramadjt);
                paramString = (String)localObject1;
                localObject1 = localObject2;
                break;
              }
              j = paramadjt.jdField_a_of_type_Anla.a.width;
              break label201;
              m = paramadjt.jdField_a_of_type_Anla.a.height;
              break label219;
            }
            if (!((String)localObject2).equals(""))
            {
              localObject2 = a(i, (String)localObject2 + "...", (String)localObject3);
              paramadjt.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
            }
          }
          paramadjt.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          localObject2 = paramadjt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
          if (localObject1 != null) {}
          switch (((URLDrawable)localObject1).getStatus())
          {
          default: 
            paramadjt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            ((BaseChatItemLayout)localObject2).setProgressVisable(true);
            paramadjt.d.setVisibility(8);
            paramadjt.c.setVisibility(8);
            paramadjt.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
            if ((paramChatMessage.isFlowMessage) && (paramadjt.jdField_a_of_type_Anla.a.jobType == 0)) {
              if (!(this.jdField_b_of_type_AndroidContentContext instanceof MultiForwardActivity))
              {
                if (!paramChatMessage.isSend()) {
                  break label1243;
                }
                paramadjt.c.setImageResource(2130846016);
                paramadjt.c.setVisibility(0);
              }
            }
            break;
          }
          for (;;)
          {
            if ((paramadjt.jdField_a_of_type_Anla.b()) && (paramadjt.jdField_a_of_type_Anla.c()) && ((paramChatMessage instanceof MessageForMarketFace)))
            {
              if (paramadjt.jdField_a_of_type_Anla.a() != null)
              {
                paramChatMessage = (RelativeLayout.LayoutParams)paramadjt.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
                paramChatMessage.width = aciy.a(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
                paramadjt.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramadjt.jdField_a_of_type_Anla.a(), paramChatMessage.width, paramadjt.jdField_a_of_type_Anla.b());
              }
              i = paramadjt.jdField_a_of_type_Anla.c();
              j = paramadjt.jdField_a_of_type_Anla.d();
              paramChatMessage = new awur(i, 1, 1, aciy.a(22.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
              paramadjt.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(paramChatMessage);
              paramadjt.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView.setDrawColor(i);
              paramadjt.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView.postInvalidate();
              paramadjt.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(j);
              paramadjt.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(j);
            }
            if (localObject1 != null) {
              a(paramadjt, (URLDrawable)localObject1, paramString);
            }
            c(paramadjt);
            return;
            if (!arhw.a()) {
              paramadjt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            }
            if ((anjd.a()) && (2 == paramadjt.jdField_a_of_type_Anla.a.jobType) && (!this.jdField_a_of_type_Anfj.e(paramadjt.jdField_a_of_type_Anla.a.epId)) && (!anjd.c())) {
              break;
            }
            float f1 = this.jdField_a_of_type_Anfj.a(paramadjt.jdField_a_of_type_Anla.a.epId);
            if ((f1 >= 0.0F) && (1.0F != f1)) {
              break;
            }
            paramadjt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            ((BaseChatItemLayout)localObject2).setProgressVisable(false);
            break;
            paramadjt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            ((BaseChatItemLayout)localObject2).setProgressVisable(false);
            if (!AppSetting.c) {
              break;
            }
            paramadjt.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(ajjy.a(2131640680));
            break;
            label1243:
            paramadjt.d.setImageResource(2130846016);
            paramadjt.d.setVisibility(0);
            continue;
            if ((paramChatMessage.isDui) && (DuiButtonImageView.jdField_a_of_type_Boolean) && (!ascr.a(paramChatMessage)))
            {
              paramadjt.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
              if ((paramChatMessage.isSend()) || (paramadjt.jdField_a_of_type_Anla.b()))
              {
                paramadjt.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
                paramadjt.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
              }
              else if ((paramadjt.jdField_a_of_type_Anla != null) && (paramadjt.jdField_a_of_type_Anla.a != null) && ((2 == paramadjt.jdField_a_of_type_Anla.a.jobType) || (4 == paramadjt.jdField_a_of_type_Anla.a.jobType)))
              {
                paramadjt.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
                paramadjt.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
              }
              else
              {
                if (!paramChatMessage.hasPlayedDui) {
                  paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramadjt.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView);
                }
                for (;;)
                {
                  if (!DuiButtonImageView.jdField_a_of_type_Boolean) {
                    break label1445;
                  }
                  paramadjt.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(this);
                  paramadjt.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(0);
                  break;
                  paramadjt.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.f();
                }
                paramadjt.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(null);
                paramadjt.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
              }
            }
          }
        }
        label1471:
        paramString = (String)localObject2;
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
      babr.a(paramContext, 230, paramString1, paramString2, 2131625035, 2131626073, new adjl(paramEmoticon, paramContext, paramQQAppInterface, paramInt), new adjm()).show();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EmosmDetailActivity.showCustomMarketFaceTips", 2, paramContext.getMessage());
    }
  }
  
  private void b(adjt paramadjt)
  {
    if ((4 != paramadjt.jdField_a_of_type_Anla.a.jobType) || (((MessageForMarketFace)paramadjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Anfj.a(paramadjt.jdField_a_of_type_Anla.a.epId, true, true)) {
        break;
      }
      if (!anjd.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone: H5MagicSource isnot Intact , and network isnot 2 3 4G or wifi;epId = " + paramadjt.jdField_a_of_type_Anla.a.epId);
        }
        paramadjt.f.setVisibility(8);
        return;
      }
    } while (-1.0F != this.jdField_a_of_type_Anfj.a(paramadjt.jdField_a_of_type_Anla.a.epId));
    anfi.a().a(this.jdField_a_of_type_Anfw);
    EmoticonPackage localEmoticonPackage = new EmoticonPackage();
    localEmoticonPackage.name = paramadjt.jdField_a_of_type_Anla.a.name;
    localEmoticonPackage.epId = paramadjt.jdField_a_of_type_Anla.a.epId;
    localEmoticonPackage.jobType = 5;
    localEmoticonPackage.type = 1;
    localEmoticonPackage.isMagicFaceDownloading = true;
    ((arnz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramadjt.jdField_a_of_type_Anla.a);
    this.jdField_a_of_type_JavaUtilList.add(paramadjt);
    paramadjt.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramadjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
    paramadjt.f.setVisibility(8);
    paramadjt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    ((MessageForMarketFace)paramadjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
    this.jdField_a_of_type_Anfj.a(localEmoticonPackage, false);
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone,start download epId = " + paramadjt.jdField_a_of_type_Anla.a.epId);
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, localEmoticonPackage.epId, "", "", "");
    return;
    if ((this.f) && (this.jdField_a_of_type_Anfj.b()))
    {
      if (!this.jdField_b_of_type_Boolean) {
        paramadjt.f.setVisibility(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source intacat epId = " + paramadjt.jdField_a_of_type_Anla.a.epId);
      }
    }
    for (;;)
    {
      paramadjt.f.setImageResource(2130837704);
      if ((((MessageForMarketFace)paramadjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage).isSend()) || (!((MessageForMarketFace)paramadjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay) || (!this.jdField_a_of_type_Anfj.a()) || (System.currentTimeMillis() - this.jdField_d_of_type_Long <= 3000L) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().p())) {
        break;
      }
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      ((MessageForMarketFace)paramadjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      a(paramadjt, "1");
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramadjt.jdField_a_of_type_Anla.a.epId, "", "", "");
      return;
      paramadjt.f.setVisibility(8);
    }
  }
  
  private void c(adjt paramadjt)
  {
    paramadjt.jdField_a_of_type_Boolean = false;
    if ((2 != paramadjt.jdField_a_of_type_Anla.a.jobType) || (((MessageForMarketFace)paramadjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null) || (!arhw.a())) {}
    for (;;)
    {
      return;
      Object localObject;
      if (!this.jdField_a_of_type_Anfj.e(paramadjt.jdField_a_of_type_Anla.a.epId))
      {
        if (!anjd.a())
        {
          paramadjt.f.setVisibility(8);
          return;
        }
        if ((!anjd.c()) && (!this.jdField_a_of_type_Anfj.a(paramadjt.jdField_a_of_type_Anla.a.epId, Boolean.valueOf(false))) && (-1.0F == this.jdField_a_of_type_Anfj.a(paramadjt.jdField_a_of_type_Anla.a.epId)))
        {
          anfi.a().a(this.jdField_a_of_type_Anfw);
          localObject = new EmoticonPackage();
          ((EmoticonPackage)localObject).name = paramadjt.jdField_a_of_type_Anla.a.name;
          ((EmoticonPackage)localObject).epId = paramadjt.jdField_a_of_type_Anla.a.epId;
          ((EmoticonPackage)localObject).jobType = 3;
          ((EmoticonPackage)localObject).rscType = argh.a(paramadjt.jdField_a_of_type_Anla.a.magicValue);
          ((EmoticonPackage)localObject).type = 1;
          ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
          ((arnz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramadjt.jdField_a_of_type_Anla.a);
          this.jdField_a_of_type_JavaUtilList.add(paramadjt);
          paramadjt.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramadjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
          paramadjt.f.setVisibility(8);
          paramadjt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((MessageForMarketFace)paramadjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          this.jdField_a_of_type_Anfj.a((EmoticonPackage)localObject, false);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongXiazai", 0, 0, paramadjt.jdField_a_of_type_Anla.a.epId, "", "", "");
        }
      }
      else
      {
        if (argh.a(paramadjt.jdField_a_of_type_Anla.a.magicValue) == 1) {
          paramadjt.f.setVisibility(8);
        }
        while (((MessageForMarketFace)paramadjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay)
        {
          ((MessageForMarketFace)paramadjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          localObject = new Emoticon();
          ((Emoticon)localObject).eId = paramadjt.jdField_a_of_type_Anla.a.eId;
          ((Emoticon)localObject).epId = paramadjt.jdField_a_of_type_Anla.a.epId;
          ((Emoticon)localObject).magicValue = paramadjt.jdField_a_of_type_Anla.a.magicValue;
          ((Emoticon)localObject).jobType = paramadjt.jdField_a_of_type_Anla.a.jobType;
          if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() != null) && (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null) && (arhw.a())) {
            ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a((Emoticon)localObject, 1, ((MessageForMarketFace)paramadjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage).senderuin, false);
          }
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramadjt.jdField_a_of_type_Anla.a.epId, "", "", "");
          return;
          if (!this.jdField_b_of_type_Boolean)
          {
            paramadjt.f.setImageResource(2130837704);
            paramadjt.f.setVisibility(0);
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
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acju a()
  {
    return new adjt();
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    long l = System.currentTimeMillis();
    paramBaseChatItemLayout = (MessageForMarketFace)paramChatMessage;
    adjt localadjt = (adjt)paramacju;
    this.jdField_b_of_type_JavaUtilSet.add(localadjt);
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
      paramacju = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject2 = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout)localObject2).setId(2131304123);
      paramView = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      paramView.setId(2131300867);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131298552);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131298552);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setOnClickListener(this);
      localObject1 = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).setId(2131297620);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = 8;
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131300867);
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      ((FrameLayout)localObject1).setOnClickListener(this);
      ((FrameLayout)localObject1).setOnTouchListener(paramacmv);
      ((FrameLayout)localObject1).setOnLongClickListener(paramacmv);
      paramacmv = new adju(this, this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).addView(paramacmv, -2, -2);
      localObject4 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localObject5 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject5).gravity = 85;
      ((FrameLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject5).setId(2131313475);
      localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(1, 2131297620);
      ((RelativeLayout.LayoutParams)localObject6).addRule(8, 2131297620);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      ((ImageView)localObject5).setOnClickListener(this);
      localObject6 = new BreathAnimationLayout(this.jdField_b_of_type_AndroidContentContext);
      ((BreathAnimationLayout)localObject6).setId(2131305106);
      localPttAudioPlayView = new PttAudioPlayView(this.jdField_b_of_type_AndroidContentContext, 10);
      localPttAudioPlayView.setThemeColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131101278).getDefaultColor());
      localPttAudioPlayView.setId(2131305108);
      localPttAudioPlayView.setPttPauseOrStopDrawable(2130838036);
      localObject7 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject7).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject7).leftMargin = aciy.a(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).width = aciy.a(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).height = aciy.a(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      localPttAudioPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject7);
      localPttAudioPlayView.setOnClickListener(this);
      localObject7 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localObject8 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject8).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject8).leftMargin = aciy.a(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).width = aciy.a(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).height = aciy.a(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((ImageView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
      ((ImageView)localObject7).setImageDrawable((Drawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839111));
      ((ImageView)localObject7).setVisibility(4);
      localObject8 = new PttAudioWaveView(this.jdField_b_of_type_AndroidContentContext);
      ((PttAudioWaveView)localObject8).setShowProgressLine(false);
      ((PttAudioWaveView)localObject8).setMaxTopBottomPadding(4);
      ((PttAudioWaveView)localObject8).setProgressColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131101278).getDefaultColor());
      ((PttAudioWaveView)localObject8).setId(2131305109);
      localObject9 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(1, 2131305108);
      ((RelativeLayout.LayoutParams)localObject9).width = aciy.a(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).height = aciy.a(45.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).leftMargin = bajq.a(9.0F);
      ((RelativeLayout.LayoutParams)localObject9).rightMargin = bajq.a(12.0F);
      ((PttAudioWaveView)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
      ((PttAudioWaveView)localObject8).setCanSupportSlide(false);
      ((PttAudioWaveView)localObject8).setOnClickListener(this);
      localObject9 = new SyncParentPressedRelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      ((RelativeLayout)localObject9).setId(2131305107);
      ((RelativeLayout)localObject9).addView((View)localObject8);
      ((RelativeLayout)localObject9).addView(localPttAudioPlayView);
      ((RelativeLayout)localObject9).addView((View)localObject7);
      localRelativeLayout = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localTriangleView = new TriangleView(this.jdField_b_of_type_AndroidContentContext);
      localObject10 = new RelativeLayout.LayoutParams(bajq.a(9.0F), bajq.a(5.0F));
      ((RelativeLayout.LayoutParams)localObject10).leftMargin = bajq.a(2.0F);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14);
      ((RelativeLayout.LayoutParams)localObject10).addRule(10);
      localTriangleView.setId(2131306072);
      localTriangleView.setRotation(180.0F);
      localTriangleView.setTranslationY(bajq.a(1.0F));
      localTriangleView.setLayoutParams((ViewGroup.LayoutParams)localObject10);
      localRelativeLayout.addView(localTriangleView);
      localObject10 = new RelativeLayout.LayoutParams(-2, bajq.a(29.0F));
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131306072);
      localRelativeLayout.addView((View)localObject9, (ViewGroup.LayoutParams)localObject10);
      ((BreathAnimationLayout)localObject6).addView(localRelativeLayout);
      localObject10 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14, 2131297620);
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131297620);
      ((RelativeLayout.LayoutParams)localObject10).bottomMargin = bajq.a(17.0F);
      ((RelativeLayout)localObject2).addView((View)localObject6, (ViewGroup.LayoutParams)localObject10);
      localObject10 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject10).setId(2131300868);
      localObject11 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject11).addRule(1, 2131297620);
      ((RelativeLayout.LayoutParams)localObject11).addRule(15, 2131297620);
      ((RelativeLayout.LayoutParams)localObject11).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject10, (ViewGroup.LayoutParams)localObject11);
      ((ImageView)localObject10).setOnClickListener(this);
      localObject11 = new DuiButtonImageView(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      ((DuiButtonImageView)localObject11).setId(2131299837);
      localObject12 = new RelativeLayout.LayoutParams(aciy.a(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), aciy.a(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject12).addRule(1, 2131297620);
      ((RelativeLayout.LayoutParams)localObject12).addRule(8, 2131297620);
      ((RelativeLayout.LayoutParams)localObject12).setMargins(0, 0, 0, -aciy.a(6.5F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout)localObject2).addView((View)localObject11, (ViewGroup.LayoutParams)localObject12);
      localObject12 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject12).setId(2131304038);
      localObject13 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject13).addRule(1, 2131297620);
      ((RelativeLayout.LayoutParams)localObject13).addRule(8, 2131297620);
      ((RelativeLayout.LayoutParams)localObject13).leftMargin = aciy.a(10.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout)localObject2).addView((View)localObject12, (ViewGroup.LayoutParams)localObject13);
      localObject13 = new TextView(this.jdField_b_of_type_AndroidContentContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      ((TextView)localObject13).setTextSize(12.0F);
      ((TextView)localObject13).setTextColor(-1);
      localLayoutParams.topMargin = aciy.a(8.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((TextView)localObject13).setGravity(17);
      localLayoutParams.addRule(3, 2131304123);
    }
    for (;;)
    {
      try
      {
        ((TextView)localObject13).setBackgroundDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130843881));
        ((TextView)localObject13).setPadding(aciy.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), aciy.a(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), aciy.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), aciy.a(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
        paramacju.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramacju.addView((View)localObject13, localLayoutParams);
        ((ImageView)localObject12).setOnClickListener(this);
        localObject2 = new ProgressBar(this.jdField_b_of_type_AndroidContentContext, null, 0);
        ((ProgressBar)localObject2).setId(2131298579);
      }
      catch (Exception localException2)
      {
        try
        {
          ((ProgressBar)localObject2).setIndeterminateDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839113));
          int i = aciy.a(16.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
          localObject3 = new FrameLayout.LayoutParams(i, i);
          ((FrameLayout.LayoutParams)localObject3).gravity = 17;
          ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          localadjt.jdField_e_of_type_AndroidWidgetImageView = paramacmv;
          localadjt.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject4);
          localadjt.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject5);
          localadjt.c = paramView;
          localadjt.d = ((ImageView)localObject10);
          localadjt.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView = ((DuiButtonImageView)localObject11);
          localadjt.f = ((ImageView)localObject12);
          localadjt.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localObject1);
          localadjt.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject2);
          localadjt.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject13);
          localadjt.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)localObject6);
          localadjt.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = localPttAudioPlayView;
          localadjt.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject8);
          localadjt.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject9);
          localadjt.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
          localadjt.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView = localTriangleView;
          localadjt.g = ((ImageView)localObject7);
          if (!c(paramChatMessage)) {
            paramBaseChatItemLayout.playProgress = 0.0F;
          }
          a(localadjt, paramChatMessage.uniseq);
          localadjt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          localadjt.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramBaseChatItemLayout.playProgress);
          if ((AppSetting.c) && (a(paramChatMessage, localadjt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) && (localadjt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)) {
            localadjt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setContentDescription(ajjy.a(2131640682));
          }
          new QueryTask(new adjo(this, localadjt), new adjp(this, localadjt, paramBaseChatItemLayout, paramChatMessage, l)).a(paramBaseChatItemLayout.mMarkFaceMessage);
          return paramacju;
          localException2 = localException2;
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException2);
        }
        catch (Exception localException1)
        {
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException1);
          continue;
        }
      }
      if ((localadjt.jdField_a_of_type_Anla != null) && (localadjt.jdField_a_of_type_Anla.b()) && (localadjt.jdField_b_of_type_AndroidWidgetImageView != null) && ((localadjt.jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof AnimationDrawable))) {
        localadjt.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846036);
      }
      paramacju = paramView;
      if (AppSetting.c)
      {
        localadjt.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        paramacju = paramView;
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (!bado.a(paramChatMessage.issend)) {
        break label103;
      }
      localStringBuilder.append("发出表情");
    }
    for (;;)
    {
      paramChatMessage = (MessageForMarketFace)paramChatMessage;
      if (paramChatMessage.mMarkFaceMessage != null)
      {
        paramChatMessage = ((arnz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramChatMessage.mMarkFaceMessage);
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
    anfi.a().b(this.jdField_a_of_type_Anfw);
    anfi.a().b(this.jdField_a_of_type_Adjs);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((adjt)localIterator.next()).a();
    }
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((jdField_a_of_type_Anla == null) || (jdField_a_of_type_Anla.a == null))
    {
      QLog.e("MarketFaceItemBuilder", 1, "onMenuItemClicked emoticon is null");
      return;
    }
    if ((paramInt == 2131299417) || (paramInt == 2131296581) || (paramInt == 2131301037) || (paramInt == 2131300766))
    {
      ((arnz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(jdField_a_of_type_Anla.a.epId, new adjn(this, paramInt, paramChatMessage));
      return;
    }
    if (paramInt == 2131304871)
    {
      super.d(paramChatMessage);
      return;
    }
    if (paramInt == 2131304829)
    {
      super.a(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  void a(adjt paramadjt, URLDrawable paramURLDrawable)
  {
    a(paramadjt, paramURLDrawable, "");
  }
  
  void a(adjt paramadjt, URLDrawable paramURLDrawable, String paramString)
  {
    paramadjt.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramadjt.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
    paramadjt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramadjt.f.setVisibility(8);
    paramadjt.jdField_b_of_type_Boolean = false;
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
        if (paramadjt.jdField_a_of_type_Anla.b()) {
          if (paramadjt.jdField_a_of_type_Anla.c()) {
            paramadjt.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          }
        }
      }
      while (!"big_sound".equals(str))
      {
        do
        {
          return;
          paramadjt.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846036);
          paramadjt.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        } while ((i != 1) || (paramadjt.jdField_a_of_type_Anla.j != 3));
        paramadjt.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837701);
        paramadjt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramadjt.jdField_b_of_type_Boolean = true;
        return;
      }
      if (c(paramadjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
      {
        if (paramadjt.jdField_a_of_type_Anla.c())
        {
          paramadjt.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          paramadjt.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          return;
        }
        paramadjt.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramURLDrawable = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772243);
        paramadjt.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
        paramURLDrawable.start();
        return;
      }
      if (paramadjt.jdField_a_of_type_Anla.c())
      {
        paramadjt.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
        paramadjt.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
        return;
      }
      paramadjt.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846036);
      paramadjt.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
  }
  
  public void a(View paramView)
  {
    paramView = (adjt)aciy.a(paramView);
    String str1;
    String str2;
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSendFromLocal())
    {
      str1 = this.jdField_b_of_type_AndroidContentContext.getString(2131624443);
      str2 = this.jdField_b_of_type_AndroidContentContext.getString(2131624444);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 41) && (paramView.jdField_a_of_type_Anla != null) && (paramView.jdField_a_of_type_Anla.a != null)) {
        a((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_Anla);
      }
    }
    do
    {
      return;
      babr.a(this.jdField_b_of_type_AndroidContentContext, 230, str1, str2, new adjh(this, paramView), new adji(this)).show();
      return;
      paramView = paramView.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
    } while (!(paramView instanceof URLDrawable));
    ((URLDrawable)paramView).restartDownload();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, awmc.a(10.0F), 0);
  }
  
  protected void a(MessageForMarketFace paramMessageForMarketFace, anla paramanla)
  {
    if ((paramMessageForMarketFace == null) || (paramanla == null) || (paramanla.a == null) || (paramanla.a.epId == null)) {
      return;
    }
    begr localbegr = (begr)behe.a(this.jdField_b_of_type_AndroidContentContext, null);
    localbegr.a(this.jdField_b_of_type_AndroidContentContext.getString(2131626460));
    localbegr.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131626459), 1);
    localbegr.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131626461), 1);
    localbegr.c(2131625035);
    localbegr.a(new adjj(this, paramanla, localbegr, paramMessageForMarketFace));
    localbegr.show();
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if ((paramView != null) && (paramFloat > 0.0F))
    {
      paramXListView = (adjt)aciy.a(paramView);
      if ((paramXListView != null) && (paramXListView.jdField_a_of_type_Anla != null) && (paramXListView.jdField_a_of_type_Anla.b()) && (paramXListView.jdField_a_of_type_Anla.c()) && (c(paramChatMessage)))
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
      paramXListView = (adjt)aciy.a(paramView);
      if (!paramXListView.jdField_a_of_type_Anla.c()) {
        break label66;
      }
      paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
        paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
      }
    }
    for (;;)
    {
      paramView = paramXListView.jdField_a_of_type_Anla.a("fromAIO", false);
      paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      return;
      label66:
      paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846036);
    }
  }
  
  public boolean a(acju paramacju)
  {
    return paramacju instanceof adjt;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer, int paramInt2)
  {
    paramXListView = (adjt)aciy.a(paramView);
    if ((paramXListView == null) || (paramXListView.jdField_a_of_type_Anla == null) || (paramXListView.jdField_a_of_type_Anla.a == null)) {
      return false;
    }
    if (paramXListView.jdField_a_of_type_Anla.b())
    {
      paramView = anjd.o.replace("[epId]", paramXListView.jdField_a_of_type_Anla.a.epId).replace("[eId]", paramXListView.jdField_a_of_type_Anla.a.eId);
      if (!bace.b(paramView))
      {
        if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramChatMessage.uniseq))) {
          return false;
        }
        this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramChatMessage.uniseq));
        a(paramXListView, paramChatMessage.uniseq);
        ThreadManager.getFileThreadHandler().post(new MarketFaceItemBuilder.11(this, paramXListView, paramChatMessage));
        return false;
      }
      if (paramAudioPlayer.a(paramView))
      {
        paramView = paramXListView.jdField_a_of_type_Anla.a("fromAIO", true);
        paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        anla.a(paramView);
        if (paramXListView.jdField_a_of_type_Anla.c()) {
          if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
            paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          }
        }
        for (;;)
        {
          return true;
          paramView = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772243);
          paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
          paramView.start();
        }
      }
    }
    return false;
  }
  
  public bakj[] a(View paramView)
  {
    paramView = (adjt)aciy.a(paramView);
    bakh localbakh = new bakh();
    jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (ApolloUtil.a(jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
      return localbakh.a();
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
        if (paramView.jdField_a_of_type_Anla.a.jobType != 1)
        {
          jdField_a_of_type_Anla = paramView.jdField_a_of_type_Anla;
          if (aciy.a(1) == 1) {
            localbakh.a(2131296581, this.jdField_b_of_type_AndroidContentContext.getString(2131627732), 2130838597);
          }
          localbakh.a(2131301037, this.jdField_b_of_type_AndroidContentContext.getString(2131627114), 2130838599);
          a(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbakh);
          if ((paramView.jdField_a_of_type_Anla.a.jobType != 2) && (paramView.jdField_a_of_type_Anla.a.jobType != 4)) {
            localbakh.a(2131300766, this.jdField_b_of_type_AndroidContentContext.getString(2131627741), 2130838578);
          }
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Ap_show_forward", 0);
        }
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
          a(localbakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        a(localbakh, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        if (paramView.jdField_a_of_type_Anla.a.jobType != 1) {
          b(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbakh);
        }
        super.c(localbakh, this.jdField_b_of_type_AndroidContentContext);
        super.d(localbakh, this.jdField_b_of_type_AndroidContentContext);
      }
      for (;;)
      {
        return localbakh.a();
        jdField_a_of_type_Anla = paramView.jdField_a_of_type_Anla;
        aael.a(localbakh, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public void d(View paramView)
  {
    aciy.n = true;
    if (super.a()) {
      return;
    }
    Object localObject3;
    Drawable localDrawable;
    URLDrawable localURLDrawable;
    Object localObject1;
    if (paramView.getId() == 2131297620)
    {
      localObject3 = (adjt)aciy.a(paramView);
      localDrawable = ((adjt)localObject3).jdField_e_of_type_AndroidWidgetImageView.getDrawable();
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
        if ((((adjt)localObject3).jdField_a_of_type_Anla != null) && (((adjt)localObject3).jdField_a_of_type_Anla.a != null) && (((adjt)localObject3).jdField_a_of_type_Anla.a.jobType == 2) && (arhw.a())) {
          a((adjt)localObject3);
        }
        if ((((URLDrawable)localDrawable).getStatus() != 1) && ((((adjt)localObject3).jdField_a_of_type_Anla == null) || (((adjt)localObject3).jdField_a_of_type_Anla.a == null) || (!((adjt)localObject3).jdField_a_of_type_Anla.e()))) {
          break;
        }
        a((adjt)localObject3, xgx.a(paramView));
        return;
        localObject2 = "";
        if ((localURLDrawable.getStateTag() instanceof Bundle)) {
          localObject2 = ((Bundle)localURLDrawable.getStateTag()).getString("display_type");
        }
        localURLDrawable.restartDownload();
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "msgOnclickListener| URLDrawable restartDownload status=" + localURLDrawable.getStatus());
        }
        a((adjt)localObject3, localURLDrawable, (String)localObject2);
        ((adjt)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        if ((((adjt)localObject3).jdField_a_of_type_Anla != null) && (((adjt)localObject3).jdField_a_of_type_Anla.b()) && ("big_sound".equals(localObject1)))
        {
          jdField_c_of_type_Long = ((adjt)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
          continue;
          if ((((adjt)localObject3).jdField_a_of_type_Anla != null) && (((adjt)localObject3).jdField_a_of_type_Anla.a != null) && (((adjt)localObject3).jdField_a_of_type_Anla.a.jobType != 0) && (((adjt)localObject3).jdField_a_of_type_Anla.a.jobType != 2) && (((adjt)localObject3).jdField_a_of_type_Anla.a.jobType != 4))
          {
            ((adjt)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            if ("big_sound".equals(localObject1))
            {
              if ((((adjt)localObject3).jdField_a_of_type_Anla.a != null) && (((adjt)localObject3).jdField_a_of_type_Anla.a.isSound)) {
                if (c(((adjt)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
                  MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
                } else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
                  bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131629840, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
                } else {
                  MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((adjt)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
                }
              }
            }
            else if ("aio_preview".equals(localObject1))
            {
              localObject1 = ((adjt)localObject3).jdField_a_of_type_Anla.a("fromAIO", true);
              if (localObject1 != null)
              {
                ((adjt)localObject3).jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
                ((adjt)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
                a((adjt)localObject3, (URLDrawable)localObject1);
                if (((adjt)localObject3).jdField_a_of_type_Anla.b()) {
                  jdField_c_of_type_Long = ((adjt)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
                }
              }
            }
          }
        }
      }
      if ((!(localDrawable instanceof arfx)) || (((adjt)localObject3).jdField_a_of_type_Anla == null) || (((adjt)localObject3).jdField_a_of_type_Anla.a == null) || (!((adjt)localObject3).jdField_a_of_type_Anla.e())) {
        break;
      }
      a((adjt)localObject3, xgx.a(paramView));
      return;
      if (paramView.getId() == 2131313475)
      {
        localObject1 = (adjt)aciy.a(paramView);
        if ((((adjt)localObject1).jdField_a_of_type_Anla != null) && (((adjt)localObject1).jdField_a_of_type_Anla.b()))
        {
          if (!c(((adjt)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
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
              bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131629840, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
            }
            else
            {
              MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((adjt)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
              continue;
              if ((paramView.getId() == 2131305108) || (paramView.getId() == 2131305109))
              {
                localObject2 = (adjt)aciy.a(paramView);
                if ((((adjt)localObject2).jdField_a_of_type_Anla != null) && (((adjt)localObject2).jdField_a_of_type_Anla.b()) && (((adjt)localObject2).jdField_a_of_type_Anla.c()))
                {
                  int i;
                  if (c(((adjt)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage))
                  {
                    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
                    localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                    i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
                    if (((adjt)localObject2).jdField_a_of_type_Anla.a != null) {}
                    for (localObject1 = ((adjt)localObject2).jdField_a_of_type_Anla.a.epId;; localObject1 = "")
                    {
                      arnz.a((QQAppInterface)localObject3, "0X800A934", i, (String)localObject1);
                      break;
                    }
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
                  {
                    bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131629840, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
                  }
                  else
                  {
                    if ((((adjt)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMarketFace)) {
                      ((MessageForMarketFace)((adjt)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage).playProgress = 0.0F;
                    }
                    ((adjt)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
                    boolean bool = false;
                    if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((adjt)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage))
                    {
                      bool = true;
                      ((adjt)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
                      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
                      if (((adjt)localObject2).jdField_a_of_type_Anla.a != null)
                      {
                        localObject1 = ((adjt)localObject2).jdField_a_of_type_Anla.a.epId;
                        arnz.a((QQAppInterface)localObject3, "0X800A933", i, (String)localObject1);
                      }
                    }
                    else
                    {
                      if (!bool)
                      {
                        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                        if (((adjt)localObject2).jdField_a_of_type_Anla.a == null) {
                          break label1239;
                        }
                        localObject1 = ((adjt)localObject2).jdField_a_of_type_Anla.a.epId;
                        arnz.a((QQAppInterface)localObject3, "0X800A935", -1, (String)localObject1);
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
                      awrn.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "NewAudioEmoticonVoicePlay", bool, 0L, 0L, (HashMap)localObject2, null);
                      break;
                      localObject1 = "";
                      break label1105;
                      localObject1 = "";
                      break label1150;
                    }
                  }
                }
              }
              else if ((paramView.getId() == 2131300868) || (paramView.getId() == 2131300867))
              {
                localObject1 = (adjt)aciy.a(paramView);
                localObject2 = a();
                if (localObject2 != null)
                {
                  ((bbms)localObject2).a(this.jdField_b_of_type_AndroidContentContext.getString(2131626464));
                  ((bbms)localObject2).show();
                }
                ((arnz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(((adjt)localObject1).jdField_a_of_type_Anla.a.epId, new adjk(this, (adjt)localObject1, (bbms)localObject2));
              }
              else
              {
                if (paramView.getId() != 2131299837) {
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
        } while (paramView.getId() != 2131304038);
        localObject1 = (adjt)aciy.a(paramView);
        if ((((adjt)localObject1).jdField_a_of_type_Anla != null) && (((adjt)localObject1).jdField_a_of_type_Anla.a != null) && (2 == ((adjt)localObject1).jdField_a_of_type_Anla.a.jobType))
        {
          if (this.jdField_a_of_type_Anfj.a(((adjt)localObject1).jdField_a_of_type_Anla.a.epId, Boolean.valueOf(false))) {
            break;
          }
          anfi.a().a(this.jdField_a_of_type_Anfw);
          localObject2 = new EmoticonPackage();
          ((EmoticonPackage)localObject2).name = ((adjt)localObject1).jdField_a_of_type_Anla.a.name;
          ((EmoticonPackage)localObject2).epId = ((adjt)localObject1).jdField_a_of_type_Anla.a.epId;
          ((EmoticonPackage)localObject2).jobType = 3;
          ((EmoticonPackage)localObject2).type = 1;
          ((EmoticonPackage)localObject2).isMagicFaceDownloading = true;
          ((adjt)localObject1).jdField_a_of_type_Boolean = false;
          ((MessageForMarketFace)((adjt)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          ((arnz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(((adjt)localObject1).jdField_a_of_type_Anla.a);
          this.jdField_a_of_type_JavaUtilList.add(localObject1);
          ((adjt)localObject1).f.setVisibility(8);
          ((adjt)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          this.jdField_a_of_type_Anfj.a((EmoticonPackage)localObject2, false);
          awqx.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongBofang", 0, 0, ((adjt)localObject1).jdField_a_of_type_Anla.a.epId, "", "", "");
        }
      } while ((((adjt)localObject1).jdField_a_of_type_Anla == null) || (((adjt)localObject1).jdField_a_of_type_Anla.a == null) || (4 != ((adjt)localObject1).jdField_a_of_type_Anla.a.jobType) || (System.currentTimeMillis() - this.jdField_d_of_type_Long <= 3000L) || (!this.jdField_a_of_type_Anfj.a()));
      label1239:
      label1247:
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_Anfj.a(((adjt)localObject1).jdField_a_of_type_Anla.a.epId, true, true)) {
        a((adjt)localObject1, "0");
      }
      for (;;)
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbFasong", "MbZhudongBofang", 0, 0, ((adjt)localObject1).jdField_a_of_type_Anla.a.epId, "", "", "");
        break;
        if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (!arhw.a()) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null)) {
          break label1692;
        }
        ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a(((adjt)localObject1).jdField_a_of_type_Anla.a, 1, ((adjt)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, true);
        break label1692;
        anfi.a().a(this.jdField_a_of_type_Anfw);
        localObject2 = new EmoticonPackage();
        ((EmoticonPackage)localObject2).name = ((adjt)localObject1).jdField_a_of_type_Anla.a.name;
        ((EmoticonPackage)localObject2).epId = ((adjt)localObject1).jdField_a_of_type_Anla.a.epId;
        ((EmoticonPackage)localObject2).jobType = 5;
        ((EmoticonPackage)localObject2).type = 1;
        ((EmoticonPackage)localObject2).isMagicFaceDownloading = true;
        ((adjt)localObject1).jdField_a_of_type_Boolean = false;
        ((MessageForMarketFace)((adjt)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
        ((arnz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(((adjt)localObject1).jdField_a_of_type_Anla.a);
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
        ((adjt)localObject1).f.setVisibility(8);
        ((adjt)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_Anfj.a((EmoticonPackage)localObject2, false);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_b_of_type_AndroidContentContext;
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = akhu.a(this.jdField_b_of_type_AndroidContentContext);
    }
    if (!bool)
    {
      akhu.a(localBaseActivity, 3, new adjf(this, paramView, localBaseActivity));
      return;
    }
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adje
 * JD-Core Version:    0.7.0.1
 */