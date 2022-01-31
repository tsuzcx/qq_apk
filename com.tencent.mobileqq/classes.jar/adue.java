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

public class adue
  extends BaseBubbleBuilder
  implements acxf
{
  public static aobp a;
  public static ChatMessage a;
  public static int c;
  static long jdField_c_of_type_Long;
  adur jdField_a_of_type_Adur = new adur();
  public anvx a;
  anwk jdField_a_of_type_Anwk = new aduq(this);
  public List<adus> a;
  public Set<Long> a;
  public Context b;
  Set<adus> b;
  Set<Long> jdField_c_of_type_JavaUtilSet = new ArraySet();
  public int d;
  private long d;
  public int e;
  public boolean f = false;
  
  static
  {
    jdField_c_of_type_Int = 1;
  }
  
  public adue(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_d_of_type_Int = 320;
    this.jdField_e_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Anvx = ((anvx)paramQQAppInterface.getManager(43));
    if ((this.jdField_b_of_type_AndroidContentContext instanceof SplashActivity)) {
      this.f = true;
    }
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, Handler paramHandler)
  {
    boolean bool = true;
    answ localansw = (answ)paramQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("MarketFaceItemBuilder", 2, "Call getEmoticonDataList from addEmotionToFavorite.");
    }
    List localList = localansw.a();
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
          if (localansw.a(localCustomEmotionData, j))
          {
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramHandler != null) {
              paramHandler.post(new MarketFaceItemBuilder.17(paramContext));
            }
            askf.c("0", 1);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
            }
            return 0;
          }
          if (paramHandler != null) {
            paramHandler.post(new MarketFaceItemBuilder.18(paramContext));
          }
          askf.c("2003", 1);
          return 0;
        }
        n = i;
        if (i < localCustomEmotionData.emoId) {
          n = localCustomEmotionData.emoId;
        }
        j += 1;
        m = k;
      }
      if (m >= ansu.a) {
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
      paramEmoticon = ((askf)paramQQAppInterface.getManager(14)).a(paramEmoticon.epId);
      if (paramEmoticon != null) {
        if (paramEmoticon.isAPNG != 2) {
          break label425;
        }
      }
      for (;;)
      {
        paramHandler.isAPNG = bool;
        paramEmoticon = (ansx)paramQQAppInterface.getManager(103);
        if (paramEmoticon != null) {
          paramEmoticon.b(paramHandler, new ansf(paramQQAppInterface, paramContext, paramHandler, null, 0));
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
      paramString2 = ajya.a(2131706480);
      continue;
      paramString2 = ajya.a(2131706475);
      paramInt = i;
      continue;
      paramString2 = ajya.a(2131706472);
      paramInt = i;
      continue;
      paramString2 = ajya.a(2131706482);
      paramInt = i;
    }
  }
  
  private bcqf a()
  {
    if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a == null) {
        ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a = new bcqf(this.jdField_b_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a;
    }
    return null;
  }
  
  private String a()
  {
    try
    {
      i = bbfj.a(this.jdField_b_of_type_AndroidContentContext);
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
    this.jdField_a_of_type_Adur.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_Aobp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a());
    anvw.a().a(this.jdField_a_of_type_Adur);
    this.jdField_a_of_type_Anvx.a(jdField_a_of_type_Aobp.a.epId, anvx.jdField_c_of_type_Int);
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
            aqbe.a((BaseActivity)paramContext, paramEmoticon, 21, 100500, "biz_src_jc_gif");
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
      axqy.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_follow_send_aio", 0, 0, "", paramEmoticon.epId, "", "");
      aobp.a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, null);
      return;
      if (paramInt2 < 0)
      {
        localHandler.post(new MarketFaceItemBuilder.15(paramContext, paramString));
        if (6 == paramInt1 % 1000) {
          askf.c("2001", 1);
        }
        QLog.i("MarketFaceItemBuilder", 1, "opType: " + paramInt1 + ",result:" + paramInt2);
        return;
      }
      localHandler.post(new MarketFaceItemBuilder.16(paramInt1, paramContext, paramQQAppInterface, paramEmoticon, paramString));
    } while (6 != paramInt1 % 1000);
    askf.c("2002", 1);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, aobp paramaobp, SessionInfo paramSessionInfo, bcqf parambcqf)
  {
    a(paramInt, paramContext, paramQQAppInterface, paramEmoticonPackage, paramaobp, paramSessionInfo, parambcqf, false);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, aobp paramaobp, SessionInfo paramSessionInfo, bcqf parambcqf, boolean paramBoolean)
  {
    if (paramaobp == null) {
      return;
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.mobileFeetype == 1))
    {
      if ((parambcqf != null) && (parambcqf.isShowing())) {
        parambcqf.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramaobp.a, 0, null, paramSessionInfo, paramBoolean);
      return;
    }
    if ((!bbfj.g(paramContext)) || (paramInt > 1000))
    {
      if ((parambcqf != null) && (parambcqf.isShowing())) {
        parambcqf.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramaobp.a, -404, ajya.a(2131706479), paramSessionInfo, paramBoolean);
      return;
    }
    ((ajvn)paramQQAppInterface.a(12)).a(paramInt, Integer.valueOf(paramaobp.a.epId).intValue(), paramaobp.a.eId);
  }
  
  private void a(adus paramadus)
  {
    EmoticonPackage localEmoticonPackage;
    if (!this.jdField_a_of_type_Anvx.a(paramadus.jdField_a_of_type_Aobp.a.epId, Boolean.valueOf(false)))
    {
      anvw.a().a(this.jdField_a_of_type_Anwk);
      localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramadus.jdField_a_of_type_Aobp.a.name;
      localEmoticonPackage.epId = paramadus.jdField_a_of_type_Aobp.a.epId;
      localEmoticonPackage.jobType = 3;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      if (paramadus.jdField_e_of_type_Int != -1) {
        break label222;
      }
    }
    label222:
    for (localEmoticonPackage.rscType = ascl.a(paramadus.jdField_a_of_type_Aobp.a.magicValue);; localEmoticonPackage.rscType = paramadus.jdField_e_of_type_Int)
    {
      ((askf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramadus.jdField_a_of_type_Aobp.a);
      paramadus.jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)paramadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = true;
      this.jdField_a_of_type_JavaUtilList.add(paramadus);
      paramadus.f.setVisibility(8);
      paramadus.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_Anvx.a(localEmoticonPackage, false);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void a(adus paramadus, long paramLong)
  {
    Animatable localAnimatable = (Animatable)paramadus.g.getDrawable();
    if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramLong)))
    {
      if (!localAnimatable.isRunning()) {
        localAnimatable.start();
      }
      paramadus.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(4);
      paramadus.g.setVisibility(0);
      return;
    }
    if (localAnimatable.isRunning()) {
      localAnimatable.stop();
    }
    paramadus.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
    paramadus.g.setVisibility(4);
  }
  
  private void a(adus paramadus, Rect paramRect)
  {
    AIOEmotionFragment.a(this.jdField_b_of_type_AndroidContentContext, paramadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramRect);
  }
  
  private void a(adus paramadus, String paramString)
  {
    ThreadManager.post(new MarketFaceItemBuilder.8(this, paramString, paramadus), 5, null, true);
  }
  
  private void a(aobp paramaobp, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      str2 = a();
      if (paramaobp == null) {}
      for (paramaobp = "";; paramaobp = paramaobp.a.epId)
      {
        VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramaobp, paramString);
        return;
      }
    case 3: 
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramaobp == null) {}
      for (paramaobp = "";; paramaobp = paramaobp.a.epId)
      {
        axqy.b(paramString, "CliOper", "", "", "ep_mall", "0X8007187", 0, 0, paramaobp, "", "", "");
        return;
      }
    }
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    String str2 = a();
    if (paramaobp == null) {}
    for (paramaobp = "";; paramaobp = paramaobp.a.epId)
    {
      VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramaobp, paramString, "1", "", "", "", 0, 0, 0, 0);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    axqy.b(paramQQAppInterface, "CliOper", "", "", paramString2, paramString3, paramInt, 0, "", "", "", "");
  }
  
  private void a(ChatMessage paramChatMessage, adus paramadus)
  {
    a(paramChatMessage, paramadus, "");
  }
  
  private void a(ChatMessage paramChatMessage, adus paramadus, String paramString)
  {
    if ((paramadus.jdField_a_of_type_Aobp.b()) && (!c(paramChatMessage))) {}
    for (boolean bool = false;; bool = true)
    {
      Object localObject3 = paramadus.jdField_a_of_type_Aobp.a("fromAIO", bool);
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
              localObject2 = paramadus.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
              if ((localObject2 != null) && (((EmoticonPackage)localObject2).status == 2))
              {
                URLDrawable.removeMemoryCacheByUrl(((URLDrawable)localObject3).getURL().toString());
                localObject2 = paramadus.jdField_a_of_type_Aobp.a("fromAIO", bool);
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
        if ((localObject1 != null) && (paramadus.jdField_a_of_type_Aobp.a != null)) {
          if (paramadus.jdField_a_of_type_Aobp.a.width == 0)
          {
            j = 200;
            if (paramadus.jdField_a_of_type_Aobp.a.height != 0) {
              break label673;
            }
            m = 200;
            k = j;
            i = m;
            if (paramadus.jdField_a_of_type_Aobp.a.extensionWidth != 0)
            {
              k = j;
              i = m;
              if (paramadus.jdField_a_of_type_Aobp.a.extensionHeight != 0)
              {
                k = paramadus.jdField_a_of_type_Aobp.a.extensionWidth;
                i = paramadus.jdField_a_of_type_Aobp.a.extensionHeight;
              }
            }
            j = k;
            if (k != i) {
              j = i;
            }
            n = (j * this.jdField_e_of_type_Int + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
            i = (this.jdField_e_of_type_Int * i + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
            paramadus.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(n, i));
            localObject2 = paramadus.jdField_a_of_type_AndroidWidgetTextView.getTag();
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
          if ((paramadus.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (i != -1))
          {
            localObject3 = (String)paramadus.jdField_a_of_type_AndroidWidgetTextView.getTag(2131363735);
            String str = (String)paramadus.jdField_a_of_type_AndroidWidgetTextView.getTag(2131363734);
            Paint localPaint = new Paint(1);
            localPaint.setTextSize(actj.a(12.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
            localPaint.setTextAlign(Paint.Align.LEFT);
            int i1 = (int)localPaint.measureText("...");
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {}
            for (j = (int)localPaint.measureText(ajya.a(2131706477) + (String)localObject3);; j = (int)localPaint.measureText(ajya.a(2131706473)))
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
                localObject2 = paramadus.jdField_a_of_type_Aobp.a("fromAIO", bool, true, paramadus);
                paramString = (String)localObject1;
                localObject1 = localObject2;
                break;
              }
              j = paramadus.jdField_a_of_type_Aobp.a.width;
              break label201;
              m = paramadus.jdField_a_of_type_Aobp.a.height;
              break label219;
            }
            if (!((String)localObject2).equals(""))
            {
              localObject2 = a(i, (String)localObject2 + "...", (String)localObject3);
              paramadus.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
            }
          }
          paramadus.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          localObject2 = paramadus.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
          if (localObject1 != null) {}
          switch (((URLDrawable)localObject1).getStatus())
          {
          default: 
            paramadus.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            ((BaseChatItemLayout)localObject2).setProgressVisable(true);
            paramadus.d.setVisibility(8);
            paramadus.c.setVisibility(8);
            paramadus.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
            if ((paramChatMessage.isFlowMessage) && (paramadus.jdField_a_of_type_Aobp.a.jobType == 0)) {
              if (!(this.jdField_b_of_type_AndroidContentContext instanceof MultiForwardActivity))
              {
                if (!paramChatMessage.isSend()) {
                  break label1309;
                }
                paramadus.c.setImageResource(2130846203);
                paramadus.c.setVisibility(0);
              }
            }
            break;
          }
          for (;;)
          {
            if ((paramadus.jdField_a_of_type_Aobp.b()) && (paramadus.jdField_a_of_type_Aobp.c()) && ((paramChatMessage instanceof MessageForMarketFace)))
            {
              if (paramadus.jdField_a_of_type_Aobp.a() != null)
              {
                paramChatMessage = (RelativeLayout.LayoutParams)paramadus.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
                paramChatMessage.width = actj.a(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
                paramadus.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramadus.jdField_a_of_type_Aobp.a(), paramChatMessage.width, paramadus.jdField_a_of_type_Aobp.b());
                if (Build.VERSION.SDK_INT < 19)
                {
                  paramChatMessage = (RelativeLayout.LayoutParams)paramadus.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
                  localObject2 = (RelativeLayout.LayoutParams)paramadus.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
                  paramChatMessage.width = actj.a(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
                  ((RelativeLayout.LayoutParams)localObject2).width = actj.a(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
                }
              }
              i = paramadus.jdField_a_of_type_Aobp.c();
              j = paramadus.jdField_a_of_type_Aobp.d();
              paramChatMessage = new axuv(i, 1, 1, actj.a(22.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
              paramadus.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(paramChatMessage);
              paramadus.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView.setDrawColor(i);
              paramadus.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView.postInvalidate();
              paramadus.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(j);
              paramadus.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(j);
            }
            if (localObject1 != null) {
              a(paramadus, (URLDrawable)localObject1, paramString);
            }
            c(paramadus);
            return;
            if (!asea.a()) {
              paramadus.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            }
            if ((anzr.a()) && (2 == paramadus.jdField_a_of_type_Aobp.a.jobType) && (!this.jdField_a_of_type_Anvx.e(paramadus.jdField_a_of_type_Aobp.a.epId)) && (!anzr.c())) {
              break;
            }
            float f1 = this.jdField_a_of_type_Anvx.a(paramadus.jdField_a_of_type_Aobp.a.epId);
            if ((f1 >= 0.0F) && (1.0F != f1)) {
              break;
            }
            paramadus.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            ((BaseChatItemLayout)localObject2).setProgressVisable(false);
            break;
            paramadus.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            ((BaseChatItemLayout)localObject2).setProgressVisable(false);
            if (!AppSetting.d) {
              break;
            }
            paramadus.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(ajya.a(2131706476));
            break;
            paramadus.d.setImageResource(2130846203);
            paramadus.d.setVisibility(0);
            continue;
            if ((paramChatMessage.isDui) && (DuiButtonImageView.jdField_a_of_type_Boolean) && (!asyx.a(paramChatMessage)))
            {
              paramadus.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
              if ((paramChatMessage.isSend()) || (paramadus.jdField_a_of_type_Aobp.b()))
              {
                paramadus.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
                paramadus.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
              }
              else if ((paramadus.jdField_a_of_type_Aobp != null) && (paramadus.jdField_a_of_type_Aobp.a != null) && ((2 == paramadus.jdField_a_of_type_Aobp.a.jobType) || (4 == paramadus.jdField_a_of_type_Aobp.a.jobType)))
              {
                paramadus.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
                paramadus.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
              }
              else
              {
                if (!paramChatMessage.hasPlayedDui) {
                  paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramadus.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView);
                }
                for (;;)
                {
                  if (!DuiButtonImageView.jdField_a_of_type_Boolean) {
                    break label1511;
                  }
                  paramadus.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(this);
                  paramadus.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(0);
                  break;
                  paramadus.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.f();
                }
                paramadus.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(null);
                paramadus.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
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
      bbdj.a(paramContext, 230, paramString1, paramString2, 2131690596, 2131691649, new aduj(paramEmoticon, paramContext, paramQQAppInterface, paramInt), new adul()).show();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EmosmDetailActivity.showCustomMarketFaceTips", 2, paramContext.getMessage());
    }
  }
  
  private void b(adus paramadus)
  {
    if ((4 != paramadus.jdField_a_of_type_Aobp.a.jobType) || (((MessageForMarketFace)paramadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Anvx.a(paramadus.jdField_a_of_type_Aobp.a.epId, true, true)) {
        break;
      }
      if (!anzr.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone: H5MagicSource isnot Intact , and network isnot 2 3 4G or wifi;epId = " + paramadus.jdField_a_of_type_Aobp.a.epId);
        }
        paramadus.f.setVisibility(8);
        return;
      }
    } while (-1.0F != this.jdField_a_of_type_Anvx.a(paramadus.jdField_a_of_type_Aobp.a.epId));
    anvw.a().a(this.jdField_a_of_type_Anwk);
    EmoticonPackage localEmoticonPackage = new EmoticonPackage();
    localEmoticonPackage.name = paramadus.jdField_a_of_type_Aobp.a.name;
    localEmoticonPackage.epId = paramadus.jdField_a_of_type_Aobp.a.epId;
    localEmoticonPackage.jobType = 5;
    localEmoticonPackage.type = 1;
    localEmoticonPackage.isMagicFaceDownloading = true;
    ((askf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramadus.jdField_a_of_type_Aobp.a);
    this.jdField_a_of_type_JavaUtilList.add(paramadus);
    paramadus.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
    paramadus.f.setVisibility(8);
    paramadus.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    ((MessageForMarketFace)paramadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
    this.jdField_a_of_type_Anvx.a(localEmoticonPackage, false);
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone,start download epId = " + paramadus.jdField_a_of_type_Aobp.a.epId);
    }
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, localEmoticonPackage.epId, "", "", "");
    return;
    if ((this.f) && (this.jdField_a_of_type_Anvx.b()))
    {
      if (!this.jdField_b_of_type_Boolean) {
        paramadus.f.setVisibility(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source intacat epId = " + paramadus.jdField_a_of_type_Aobp.a.epId);
      }
    }
    for (;;)
    {
      paramadus.f.setImageResource(2130837714);
      if ((((MessageForMarketFace)paramadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage).isSend()) || (!((MessageForMarketFace)paramadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay) || (!this.jdField_a_of_type_Anvx.a()) || (System.currentTimeMillis() - this.jdField_d_of_type_Long <= 3000L) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().p())) {
        break;
      }
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      ((MessageForMarketFace)paramadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      a(paramadus, "1");
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramadus.jdField_a_of_type_Aobp.a.epId, "", "", "");
      return;
      paramadus.f.setVisibility(8);
    }
  }
  
  private void c(adus paramadus)
  {
    paramadus.jdField_a_of_type_Boolean = false;
    if ((2 != paramadus.jdField_a_of_type_Aobp.a.jobType) || (((MessageForMarketFace)paramadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null) || (!asea.a())) {}
    for (;;)
    {
      return;
      Object localObject;
      if (!this.jdField_a_of_type_Anvx.e(paramadus.jdField_a_of_type_Aobp.a.epId))
      {
        if (!anzr.a())
        {
          paramadus.f.setVisibility(8);
          return;
        }
        if ((!anzr.c()) && (!this.jdField_a_of_type_Anvx.a(paramadus.jdField_a_of_type_Aobp.a.epId, Boolean.valueOf(false))) && (-1.0F == this.jdField_a_of_type_Anvx.a(paramadus.jdField_a_of_type_Aobp.a.epId)))
        {
          anvw.a().a(this.jdField_a_of_type_Anwk);
          localObject = new EmoticonPackage();
          ((EmoticonPackage)localObject).name = paramadus.jdField_a_of_type_Aobp.a.name;
          ((EmoticonPackage)localObject).epId = paramadus.jdField_a_of_type_Aobp.a.epId;
          ((EmoticonPackage)localObject).jobType = 3;
          ((EmoticonPackage)localObject).rscType = ascl.a(paramadus.jdField_a_of_type_Aobp.a.magicValue);
          ((EmoticonPackage)localObject).type = 1;
          ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
          ((askf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramadus.jdField_a_of_type_Aobp.a);
          this.jdField_a_of_type_JavaUtilList.add(paramadus);
          paramadus.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
          paramadus.f.setVisibility(8);
          paramadus.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((MessageForMarketFace)paramadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          this.jdField_a_of_type_Anvx.a((EmoticonPackage)localObject, false);
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongXiazai", 0, 0, paramadus.jdField_a_of_type_Aobp.a.epId, "", "", "");
        }
      }
      else
      {
        if (ascl.a(paramadus.jdField_a_of_type_Aobp.a.magicValue) == 1) {
          paramadus.f.setVisibility(8);
        }
        while (((MessageForMarketFace)paramadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay)
        {
          ((MessageForMarketFace)paramadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          localObject = new Emoticon();
          ((Emoticon)localObject).eId = paramadus.jdField_a_of_type_Aobp.a.eId;
          ((Emoticon)localObject).epId = paramadus.jdField_a_of_type_Aobp.a.epId;
          ((Emoticon)localObject).magicValue = paramadus.jdField_a_of_type_Aobp.a.magicValue;
          ((Emoticon)localObject).jobType = paramadus.jdField_a_of_type_Aobp.a.jobType;
          if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() != null) && (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null) && (asea.a())) {
            ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a((Emoticon)localObject, 1, ((MessageForMarketFace)paramadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage).senderuin, false);
          }
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramadus.jdField_a_of_type_Aobp.a.epId, "", "", "");
          return;
          if (!this.jdField_b_of_type_Boolean)
          {
            paramadus.f.setImageResource(2130837714);
            paramadus.f.setVisibility(0);
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
  
  private void d(adus paramadus)
  {
    if ((paramadus != null) && (paramadus.jdField_a_of_type_Aobp != null) && (paramadus.jdField_a_of_type_Aobp.c()) && (paramadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (!this.jdField_c_of_type_JavaUtilSet.contains(Long.valueOf(paramadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))))
    {
      askf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AB51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramadus.jdField_a_of_type_Aobp.a.epId);
      this.jdField_c_of_type_JavaUtilSet.add(Long.valueOf(paramadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acuj a()
  {
    return new adus();
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    long l = System.currentTimeMillis();
    paramBaseChatItemLayout = (MessageForMarketFace)paramChatMessage;
    adus localadus = (adus)paramacuj;
    this.jdField_b_of_type_JavaUtilSet.add(localadus);
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
      paramacuj = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject2 = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout)localObject2).setId(2131369795);
      paramView = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      paramView.setId(2131366476);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131364109);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131364109);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setOnClickListener(this);
      localObject1 = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).setId(2131363170);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = 8;
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131366476);
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      ((FrameLayout)localObject1).setOnClickListener(this);
      ((FrameLayout)localObject1).setOnTouchListener(paramacxj);
      ((FrameLayout)localObject1).setOnLongClickListener(paramacxj);
      paramacxj = new adut(this, this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).addView(paramacxj, -2, -2);
      localObject4 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localObject5 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject5).gravity = 85;
      ((FrameLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject5).setId(2131379315);
      localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(1, 2131363170);
      ((RelativeLayout.LayoutParams)localObject6).addRule(8, 2131363170);
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
      ((RelativeLayout.LayoutParams)localObject7).leftMargin = actj.a(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).width = actj.a(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).height = actj.a(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      localPttAudioPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject7);
      localPttAudioPlayView.setOnClickListener(this);
      localObject7 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localObject8 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject8).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject8).leftMargin = actj.a(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).width = actj.a(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).height = actj.a(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
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
      ((RelativeLayout.LayoutParams)localObject9).width = actj.a(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).height = actj.a(45.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).leftMargin = bbll.a(9.0F);
      ((RelativeLayout.LayoutParams)localObject9).rightMargin = bbll.a(12.0F);
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
      localObject10 = new RelativeLayout.LayoutParams(bbll.a(9.0F), bbll.a(5.0F));
      ((RelativeLayout.LayoutParams)localObject10).leftMargin = bbll.a(2.0F);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14);
      ((RelativeLayout.LayoutParams)localObject10).addRule(10);
      localTriangleView.setId(2131371769);
      localTriangleView.setRotation(180.0F);
      localTriangleView.setTranslationY(bbll.a(1.0F));
      localTriangleView.setLayoutParams((ViewGroup.LayoutParams)localObject10);
      localRelativeLayout.addView(localTriangleView);
      localObject10 = new RelativeLayout.LayoutParams(-2, bbll.a(29.0F));
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131371769);
      localRelativeLayout.addView((View)localObject9, (ViewGroup.LayoutParams)localObject10);
      ((BreathAnimationLayout)localObject6).addView(localRelativeLayout);
      localObject10 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14, 2131363170);
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131363170);
      ((RelativeLayout.LayoutParams)localObject10).bottomMargin = bbll.a(17.0F);
      ((RelativeLayout)localObject2).addView((View)localObject6, (ViewGroup.LayoutParams)localObject10);
      localObject10 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject10).setId(2131366477);
      localObject11 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject11).addRule(1, 2131363170);
      ((RelativeLayout.LayoutParams)localObject11).addRule(15, 2131363170);
      ((RelativeLayout.LayoutParams)localObject11).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject10, (ViewGroup.LayoutParams)localObject11);
      ((ImageView)localObject10).setOnClickListener(this);
      localObject11 = new DuiButtonImageView(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      ((DuiButtonImageView)localObject11).setId(2131365416);
      localObject12 = new RelativeLayout.LayoutParams(actj.a(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), actj.a(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject12).addRule(1, 2131363170);
      ((RelativeLayout.LayoutParams)localObject12).addRule(8, 2131363170);
      ((RelativeLayout.LayoutParams)localObject12).setMargins(0, 0, 0, -actj.a(6.5F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout)localObject2).addView((View)localObject11, (ViewGroup.LayoutParams)localObject12);
      localObject12 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject12).setId(2131369710);
      localObject13 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject13).addRule(1, 2131363170);
      ((RelativeLayout.LayoutParams)localObject13).addRule(8, 2131363170);
      ((RelativeLayout.LayoutParams)localObject13).leftMargin = actj.a(10.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout)localObject2).addView((View)localObject12, (ViewGroup.LayoutParams)localObject13);
      localObject13 = new TextView(this.jdField_b_of_type_AndroidContentContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      ((TextView)localObject13).setTextSize(12.0F);
      ((TextView)localObject13).setTextColor(-1);
      localLayoutParams.topMargin = actj.a(8.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((TextView)localObject13).setGravity(17);
      localLayoutParams.addRule(3, 2131369795);
    }
    for (;;)
    {
      try
      {
        ((TextView)localObject13).setBackgroundDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130843962));
        ((TextView)localObject13).setPadding(actj.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), actj.a(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), actj.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), actj.a(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
        paramacuj.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramacuj.addView((View)localObject13, localLayoutParams);
        ((ImageView)localObject12).setOnClickListener(this);
        localObject2 = new ProgressBar(this.jdField_b_of_type_AndroidContentContext, null, 0);
        ((ProgressBar)localObject2).setId(2131364136);
      }
      catch (Exception localException2)
      {
        try
        {
          ((ProgressBar)localObject2).setIndeterminateDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839140));
          int i = actj.a(16.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
          localObject3 = new FrameLayout.LayoutParams(i, i);
          ((FrameLayout.LayoutParams)localObject3).gravity = 17;
          ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          localadus.jdField_e_of_type_AndroidWidgetImageView = paramacxj;
          localadus.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject4);
          localadus.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject5);
          localadus.c = paramView;
          localadus.d = ((ImageView)localObject10);
          localadus.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView = ((DuiButtonImageView)localObject11);
          localadus.f = ((ImageView)localObject12);
          localadus.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localObject1);
          localadus.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject2);
          localadus.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject13);
          localadus.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)localObject6);
          localadus.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = localPttAudioPlayView;
          localadus.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject8);
          localadus.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject9);
          localadus.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
          localadus.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView = localTriangleView;
          localadus.g = ((ImageView)localObject7);
          if (!c(paramChatMessage)) {
            paramBaseChatItemLayout.playProgress = 0.0F;
          }
          a(localadus, paramChatMessage.uniseq);
          localadus.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          localadus.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramBaseChatItemLayout.playProgress);
          if ((AppSetting.d) && (a(paramChatMessage, localadus.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) && (localadus.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)) {
            localadus.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setContentDescription(ajya.a(2131706478));
          }
          new QueryTask(new adum(this, localadus), new adun(this, localadus, paramBaseChatItemLayout, paramChatMessage, l)).a(paramBaseChatItemLayout.mMarkFaceMessage);
          return paramacuj;
          localException2 = localException2;
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException2);
        }
        catch (Exception localException1)
        {
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException1);
          continue;
        }
      }
      if ((localadus.jdField_a_of_type_Aobp != null) && (localadus.jdField_a_of_type_Aobp.b()) && (localadus.jdField_b_of_type_AndroidWidgetImageView != null) && ((localadus.jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof AnimationDrawable))) {
        localadus.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846223);
      }
      paramacuj = paramView;
      if (AppSetting.d)
      {
        localadus.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        paramacuj = paramView;
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (!bbfh.a(paramChatMessage.issend)) {
        break label103;
      }
      localStringBuilder.append("发出表情");
    }
    for (;;)
    {
      paramChatMessage = (MessageForMarketFace)paramChatMessage;
      if (paramChatMessage.mMarkFaceMessage != null)
      {
        paramChatMessage = ((askf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramChatMessage.mMarkFaceMessage);
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
    anvw.a().b(this.jdField_a_of_type_Anwk);
    anvw.a().b(this.jdField_a_of_type_Adur);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((adus)localIterator.next()).a();
    }
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((jdField_a_of_type_Aobp == null) || (jdField_a_of_type_Aobp.a == null))
    {
      QLog.e("MarketFaceItemBuilder", 1, "onMenuItemClicked emoticon is null");
      return;
    }
    if ((paramInt == 2131364984) || (paramInt == 2131362121) || (paramInt == 2131366648) || (paramInt == 2131366377))
    {
      ((askf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(jdField_a_of_type_Aobp.a.epId, new aduk(this, paramInt, paramChatMessage));
      return;
    }
    if (paramInt == 2131370536)
    {
      super.d(paramChatMessage);
      return;
    }
    if (paramInt == 2131370493)
    {
      super.a(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  void a(adus paramadus, URLDrawable paramURLDrawable)
  {
    a(paramadus, paramURLDrawable, "");
  }
  
  void a(adus paramadus, URLDrawable paramURLDrawable, String paramString)
  {
    paramadus.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramadus.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
    paramadus.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramadus.f.setVisibility(8);
    paramadus.jdField_b_of_type_Boolean = false;
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
        if (paramadus.jdField_a_of_type_Aobp.b()) {
          if (paramadus.jdField_a_of_type_Aobp.c()) {
            paramadus.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          }
        }
      }
      while (!"big_sound".equals(str))
      {
        do
        {
          return;
          paramadus.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846223);
          paramadus.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        } while ((i != 1) || (paramadus.jdField_a_of_type_Aobp.j != 3));
        paramadus.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837711);
        paramadus.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramadus.jdField_b_of_type_Boolean = true;
        return;
      }
      if (c(paramadus.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
      {
        if (paramadus.jdField_a_of_type_Aobp.c())
        {
          paramadus.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          paramadus.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          return;
        }
        paramadus.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramURLDrawable = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772244);
        paramadus.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
        paramURLDrawable.start();
        return;
      }
      if (paramadus.jdField_a_of_type_Aobp.c())
      {
        paramadus.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
        paramadus.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
        return;
      }
      paramadus.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846223);
      paramadus.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
  }
  
  public void a(View paramView)
  {
    paramView = (adus)actj.a(paramView);
    String str1;
    String str2;
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSendFromLocal())
    {
      str1 = this.jdField_b_of_type_AndroidContentContext.getString(2131689995);
      str2 = this.jdField_b_of_type_AndroidContentContext.getString(2131689996);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 41) && (paramView.jdField_a_of_type_Aobp != null) && (paramView.jdField_a_of_type_Aobp.a != null)) {
        a((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_Aobp);
      }
    }
    do
    {
      return;
      bbdj.a(this.jdField_b_of_type_AndroidContentContext, 230, str1, str2, new adug(this, paramView), new aduh(this)).show();
      return;
      paramView = paramView.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
    } while (!(paramView instanceof URLDrawable));
    ((URLDrawable)paramView).restartDownload();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, axlk.a(10.0F), 0);
  }
  
  protected void a(MessageForMarketFace paramMessageForMarketFace, aobp paramaobp)
  {
    if ((paramMessageForMarketFace == null) || (paramaobp == null) || (paramaobp.a == null) || (paramaobp.a.epId == null)) {
      return;
    }
    bfpc localbfpc = (bfpc)bfpp.a(this.jdField_b_of_type_AndroidContentContext, null);
    localbfpc.a(this.jdField_b_of_type_AndroidContentContext.getString(2131692046));
    localbfpc.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131692045), 1);
    localbfpc.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131692047), 1);
    localbfpc.c(2131690596);
    localbfpc.a(new adui(this, paramaobp, localbfpc, paramMessageForMarketFace));
    localbfpc.show();
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if ((paramView != null) && (paramFloat > 0.0F))
    {
      paramXListView = (adus)actj.a(paramView);
      if ((paramXListView != null) && (paramXListView.jdField_a_of_type_Aobp != null) && (paramXListView.jdField_a_of_type_Aobp.b()) && (paramXListView.jdField_a_of_type_Aobp.c()) && (c(paramChatMessage)))
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
      paramXListView = (adus)actj.a(paramView);
      if (!paramXListView.jdField_a_of_type_Aobp.c()) {
        break label66;
      }
      paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
        paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
      }
    }
    for (;;)
    {
      paramView = paramXListView.jdField_a_of_type_Aobp.a("fromAIO", false);
      paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      return;
      label66:
      paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846223);
    }
  }
  
  public boolean a(acuj paramacuj)
  {
    return paramacuj instanceof adus;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer, int paramInt2)
  {
    paramXListView = (adus)actj.a(paramView);
    if ((paramXListView == null) || (paramXListView.jdField_a_of_type_Aobp == null) || (paramXListView.jdField_a_of_type_Aobp.a == null)) {
      return false;
    }
    if (paramXListView.jdField_a_of_type_Aobp.b())
    {
      paramView = anzr.o.replace("[epId]", paramXListView.jdField_a_of_type_Aobp.a.epId).replace("[eId]", paramXListView.jdField_a_of_type_Aobp.a.eId);
      if (!bbdx.b(paramView))
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
        paramView = paramXListView.jdField_a_of_type_Aobp.a("fromAIO", true);
        paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        aobp.a(paramView);
        if (paramXListView.jdField_a_of_type_Aobp.c()) {
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
  
  public bbmh[] a(View paramView)
  {
    paramView = (adus)actj.a(paramView);
    bbmf localbbmf = new bbmf();
    jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (ApolloUtil.a(jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
      return localbbmf.a();
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
        if (paramView.jdField_a_of_type_Aobp.a.jobType != 1)
        {
          jdField_a_of_type_Aobp = paramView.jdField_a_of_type_Aobp;
          if (actj.a(1) == 1) {
            localbbmf.a(2131362121, this.jdField_b_of_type_AndroidContentContext.getString(2131693374), 2130838604);
          }
          localbbmf.a(2131366648, this.jdField_b_of_type_AndroidContentContext.getString(2131692753), 2130838606);
          a(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbbmf);
          if ((paramView.jdField_a_of_type_Aobp.a.jobType != 2) && (paramView.jdField_a_of_type_Aobp.a.jobType != 4)) {
            localbbmf.a(2131366377, this.jdField_b_of_type_AndroidContentContext.getString(2131693383), 2130838585);
          }
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Ap_show_forward", 0);
        }
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
          a(localbbmf, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        a(localbbmf, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        if (paramView.jdField_a_of_type_Aobp.a.jobType != 1) {
          b(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbbmf);
        }
        super.c(localbbmf, this.jdField_b_of_type_AndroidContentContext);
        super.e(localbbmf, this.jdField_b_of_type_AndroidContentContext);
      }
      for (;;)
      {
        return localbbmf.a();
        jdField_a_of_type_Aobp = paramView.jdField_a_of_type_Aobp;
        aanz.a(localbbmf, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public void d(View paramView)
  {
    actj.n = true;
    if (super.a()) {
      return;
    }
    Object localObject3;
    Drawable localDrawable;
    URLDrawable localURLDrawable;
    Object localObject1;
    if (paramView.getId() == 2131363170)
    {
      localObject3 = (adus)actj.a(paramView);
      localDrawable = ((adus)localObject3).jdField_e_of_type_AndroidWidgetImageView.getDrawable();
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
        if ((((adus)localObject3).jdField_a_of_type_Aobp != null) && (((adus)localObject3).jdField_a_of_type_Aobp.a != null) && (((adus)localObject3).jdField_a_of_type_Aobp.a.jobType == 2) && (asea.a())) {
          a((adus)localObject3);
        }
        if ((((URLDrawable)localDrawable).getStatus() != 1) && ((((adus)localObject3).jdField_a_of_type_Aobp == null) || (((adus)localObject3).jdField_a_of_type_Aobp.a == null) || (!((adus)localObject3).jdField_a_of_type_Aobp.e()))) {
          break;
        }
        a((adus)localObject3, xpu.a(paramView));
        return;
        localObject2 = "";
        if ((localURLDrawable.getStateTag() instanceof Bundle)) {
          localObject2 = ((Bundle)localURLDrawable.getStateTag()).getString("display_type");
        }
        localURLDrawable.restartDownload();
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "msgOnclickListener| URLDrawable restartDownload status=" + localURLDrawable.getStatus());
        }
        a((adus)localObject3, localURLDrawable, (String)localObject2);
        ((adus)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        if ((((adus)localObject3).jdField_a_of_type_Aobp != null) && (((adus)localObject3).jdField_a_of_type_Aobp.b()) && ("big_sound".equals(localObject1)))
        {
          jdField_c_of_type_Long = ((adus)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
          continue;
          if ((((adus)localObject3).jdField_a_of_type_Aobp != null) && (((adus)localObject3).jdField_a_of_type_Aobp.a != null) && (((adus)localObject3).jdField_a_of_type_Aobp.a.jobType != 0) && (((adus)localObject3).jdField_a_of_type_Aobp.a.jobType != 2) && (((adus)localObject3).jdField_a_of_type_Aobp.a.jobType != 4))
          {
            ((adus)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            if ("big_sound".equals(localObject1))
            {
              if ((((adus)localObject3).jdField_a_of_type_Aobp.a != null) && (((adus)localObject3).jdField_a_of_type_Aobp.a.isSound)) {
                if (c(((adus)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
                  MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
                } else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
                  bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695522, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                } else {
                  MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((adus)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
                }
              }
            }
            else if ("aio_preview".equals(localObject1))
            {
              localObject1 = ((adus)localObject3).jdField_a_of_type_Aobp.a("fromAIO", true);
              if (localObject1 != null)
              {
                ((adus)localObject3).jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
                ((adus)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
                a((adus)localObject3, (URLDrawable)localObject1);
                if (((adus)localObject3).jdField_a_of_type_Aobp.b()) {
                  jdField_c_of_type_Long = ((adus)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
                }
              }
            }
          }
        }
      }
      if ((!(localDrawable instanceof ascb)) || (((adus)localObject3).jdField_a_of_type_Aobp == null) || (((adus)localObject3).jdField_a_of_type_Aobp.a == null) || (!((adus)localObject3).jdField_a_of_type_Aobp.e())) {
        break;
      }
      a((adus)localObject3, xpu.a(paramView));
      return;
      if (paramView.getId() == 2131379315)
      {
        localObject1 = (adus)actj.a(paramView);
        if ((((adus)localObject1).jdField_a_of_type_Aobp != null) && (((adus)localObject1).jdField_a_of_type_Aobp.b()))
        {
          if (!c(((adus)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
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
              bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695522, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
            }
            else
            {
              MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((adus)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
              continue;
              if ((paramView.getId() == 2131370775) || (paramView.getId() == 2131370776))
              {
                localObject2 = (adus)actj.a(paramView);
                if ((((adus)localObject2).jdField_a_of_type_Aobp != null) && (((adus)localObject2).jdField_a_of_type_Aobp.b()) && (((adus)localObject2).jdField_a_of_type_Aobp.c()))
                {
                  int i;
                  if (c(((adus)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage))
                  {
                    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
                    localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                    i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
                    if (((adus)localObject2).jdField_a_of_type_Aobp.a != null) {}
                    for (localObject1 = ((adus)localObject2).jdField_a_of_type_Aobp.a.epId;; localObject1 = "")
                    {
                      askf.a((QQAppInterface)localObject3, "0X800A934", i, (String)localObject1);
                      break;
                    }
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
                  {
                    bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695522, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                  }
                  else
                  {
                    if ((((adus)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMarketFace)) {
                      ((MessageForMarketFace)((adus)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage).playProgress = 0.0F;
                    }
                    ((adus)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
                    boolean bool = false;
                    if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((adus)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage))
                    {
                      bool = true;
                      ((adus)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
                      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
                      if (((adus)localObject2).jdField_a_of_type_Aobp.a != null)
                      {
                        localObject1 = ((adus)localObject2).jdField_a_of_type_Aobp.a.epId;
                        askf.a((QQAppInterface)localObject3, "0X800A933", i, (String)localObject1);
                      }
                    }
                    else
                    {
                      if (!bool)
                      {
                        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                        if (((adus)localObject2).jdField_a_of_type_Aobp.a == null) {
                          break label1239;
                        }
                        localObject1 = ((adus)localObject2).jdField_a_of_type_Aobp.a.epId;
                        askf.a((QQAppInterface)localObject3, "0X800A935", -1, (String)localObject1);
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
                      axrn.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "NewAudioEmoticonVoicePlay", bool, 0L, 0L, (HashMap)localObject2, null);
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
                localObject1 = (adus)actj.a(paramView);
                localObject2 = a();
                if (localObject2 != null)
                {
                  ((bcqf)localObject2).a(this.jdField_b_of_type_AndroidContentContext.getString(2131692050));
                  ((bcqf)localObject2).show();
                }
                ((askf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(((adus)localObject1).jdField_a_of_type_Aobp.a.epId, new aduf(this, (adus)localObject1, (bcqf)localObject2));
              }
              else
              {
                if (paramView.getId() != 2131365416) {
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
        } while (paramView.getId() != 2131369710);
        localObject1 = (adus)actj.a(paramView);
        if ((((adus)localObject1).jdField_a_of_type_Aobp != null) && (((adus)localObject1).jdField_a_of_type_Aobp.a != null) && (2 == ((adus)localObject1).jdField_a_of_type_Aobp.a.jobType))
        {
          if (this.jdField_a_of_type_Anvx.a(((adus)localObject1).jdField_a_of_type_Aobp.a.epId, Boolean.valueOf(false))) {
            break;
          }
          anvw.a().a(this.jdField_a_of_type_Anwk);
          localObject2 = new EmoticonPackage();
          ((EmoticonPackage)localObject2).name = ((adus)localObject1).jdField_a_of_type_Aobp.a.name;
          ((EmoticonPackage)localObject2).epId = ((adus)localObject1).jdField_a_of_type_Aobp.a.epId;
          ((EmoticonPackage)localObject2).jobType = 3;
          ((EmoticonPackage)localObject2).type = 1;
          ((EmoticonPackage)localObject2).isMagicFaceDownloading = true;
          ((adus)localObject1).jdField_a_of_type_Boolean = false;
          ((MessageForMarketFace)((adus)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          ((askf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(((adus)localObject1).jdField_a_of_type_Aobp.a);
          this.jdField_a_of_type_JavaUtilList.add(localObject1);
          ((adus)localObject1).f.setVisibility(8);
          ((adus)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          this.jdField_a_of_type_Anvx.a((EmoticonPackage)localObject2, false);
          axqy.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongBofang", 0, 0, ((adus)localObject1).jdField_a_of_type_Aobp.a.epId, "", "", "");
        }
      } while ((((adus)localObject1).jdField_a_of_type_Aobp == null) || (((adus)localObject1).jdField_a_of_type_Aobp.a == null) || (4 != ((adus)localObject1).jdField_a_of_type_Aobp.a.jobType) || (System.currentTimeMillis() - this.jdField_d_of_type_Long <= 3000L) || (!this.jdField_a_of_type_Anvx.a()));
      label1239:
      label1247:
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_Anvx.a(((adus)localObject1).jdField_a_of_type_Aobp.a.epId, true, true)) {
        a((adus)localObject1, "0");
      }
      for (;;)
      {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbFasong", "MbZhudongBofang", 0, 0, ((adus)localObject1).jdField_a_of_type_Aobp.a.epId, "", "", "");
        break;
        if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (!asea.a()) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null)) {
          break label1692;
        }
        ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a(((adus)localObject1).jdField_a_of_type_Aobp.a, 1, ((adus)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, true);
        break label1692;
        anvw.a().a(this.jdField_a_of_type_Anwk);
        localObject2 = new EmoticonPackage();
        ((EmoticonPackage)localObject2).name = ((adus)localObject1).jdField_a_of_type_Aobp.a.name;
        ((EmoticonPackage)localObject2).epId = ((adus)localObject1).jdField_a_of_type_Aobp.a.epId;
        ((EmoticonPackage)localObject2).jobType = 5;
        ((EmoticonPackage)localObject2).type = 1;
        ((EmoticonPackage)localObject2).isMagicFaceDownloading = true;
        ((adus)localObject1).jdField_a_of_type_Boolean = false;
        ((MessageForMarketFace)((adus)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
        ((askf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(((adus)localObject1).jdField_a_of_type_Aobp.a);
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
        ((adus)localObject1).f.setVisibility(8);
        ((adus)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_Anvx.a((EmoticonPackage)localObject2, false);
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
 * Qualified Name:     adue
 * JD-Core Version:    0.7.0.1
 */