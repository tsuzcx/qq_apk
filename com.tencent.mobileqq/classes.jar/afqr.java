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

public class afqr
  extends BaseBubbleBuilder
  implements aeor
{
  public static aptm a;
  public static ChatMessage a;
  public static int c;
  static long jdField_c_of_type_Long;
  afre jdField_a_of_type_Afre = new afre();
  public apnf a;
  apns jdField_a_of_type_Apns = new afrd(this);
  public List<afrf> a;
  public Set<Long> a;
  public Context b;
  Set<afrf> b;
  Set<Long> jdField_c_of_type_JavaUtilSet = new ArraySet();
  public int d;
  private long d;
  public int e;
  public boolean f = false;
  
  static
  {
    jdField_c_of_type_Int = 1;
  }
  
  public afqr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_d_of_type_Int = 320;
    this.jdField_e_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Apnf = ((apnf)paramQQAppInterface.getManager(43));
    if ((this.jdField_b_of_type_AndroidContentContext instanceof SplashActivity)) {
      this.f = true;
    }
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, Handler paramHandler)
  {
    boolean bool = true;
    apke localapke = (apke)paramQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("MarketFaceItemBuilder", 2, "Call getEmoticonDataList from addEmotionToFavorite.");
    }
    List localList = localapke.a();
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
          if (localapke.a(localCustomEmotionData, j))
          {
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramHandler != null) {
              paramHandler.post(new MarketFaceItemBuilder.17(paramContext));
            }
            aube.c("0", 1);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
            }
            return 0;
          }
          if (paramHandler != null) {
            paramHandler.post(new MarketFaceItemBuilder.18(paramContext));
          }
          aube.c("2003", 1);
          return 0;
        }
        n = i;
        if (i < localCustomEmotionData.emoId) {
          n = localCustomEmotionData.emoId;
        }
        j += 1;
        m = k;
      }
      if (m >= apkc.a) {
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
      paramEmoticon = ((aube)paramQQAppInterface.getManager(14)).a(paramEmoticon.epId);
      if (paramEmoticon != null) {
        if (paramEmoticon.isAPNG != 2) {
          break label425;
        }
      }
      for (;;)
      {
        paramHandler.isAPNG = bool;
        paramEmoticon = (apkf)paramQQAppInterface.getManager(103);
        if (paramEmoticon != null) {
          paramEmoticon.b(paramHandler, new apjn(paramQQAppInterface, paramContext, paramHandler, null, 0));
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
      i = 2131691041;
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
      paramInt = 2131691042;
      paramString2 = alpo.a(2131706852);
      continue;
      paramString2 = alpo.a(2131706847);
      paramInt = i;
      continue;
      paramString2 = alpo.a(2131706844);
      paramInt = i;
      continue;
      paramString2 = alpo.a(2131706854);
      paramInt = i;
    }
  }
  
  private bepp a()
  {
    if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a == null) {
        ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a = new bepp(this.jdField_b_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a;
    }
    return null;
  }
  
  private String a()
  {
    try
    {
      i = bdee.a(this.jdField_b_of_type_AndroidContentContext);
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
    this.jdField_a_of_type_Afre.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_Aptm, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a());
    apne.a().a(this.jdField_a_of_type_Afre);
    this.jdField_a_of_type_Apnf.a(jdField_a_of_type_Aptm.a.epId, apnf.jdField_c_of_type_Int);
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
            arum.a((BaseActivity)paramContext, paramEmoticon, 21, 100500, "biz_src_jc_gif");
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
      azmj.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_follow_send_aio", 0, 0, "", paramEmoticon.epId, "", "");
      aptm.a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, null);
      return;
      if (paramInt2 < 0)
      {
        localHandler.post(new MarketFaceItemBuilder.15(paramContext, paramString));
        if (6 == paramInt1 % 1000) {
          aube.c("2001", 1);
        }
        QLog.i("MarketFaceItemBuilder", 1, "opType: " + paramInt1 + ",result:" + paramInt2);
        return;
      }
      localHandler.post(new MarketFaceItemBuilder.16(paramInt1, paramContext, paramQQAppInterface, paramEmoticon, paramString));
    } while (6 != paramInt1 % 1000);
    aube.c("2002", 1);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, aptm paramaptm, SessionInfo paramSessionInfo, bepp parambepp)
  {
    a(paramInt, paramContext, paramQQAppInterface, paramEmoticonPackage, paramaptm, paramSessionInfo, parambepp, false);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, aptm paramaptm, SessionInfo paramSessionInfo, bepp parambepp, boolean paramBoolean)
  {
    if (paramaptm == null) {
      return;
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.mobileFeetype == 1))
    {
      if ((parambepp != null) && (parambepp.isShowing())) {
        parambepp.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramaptm.a, 0, null, paramSessionInfo, paramBoolean);
      return;
    }
    if ((!bdee.g(paramContext)) || (paramInt > 1000))
    {
      if ((parambepp != null) && (parambepp.isShowing())) {
        parambepp.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramaptm.a, -404, alpo.a(2131706851), paramSessionInfo, paramBoolean);
      return;
    }
    ((alna)paramQQAppInterface.a(12)).a(paramInt, Integer.valueOf(paramaptm.a.epId).intValue(), paramaptm.a.eId);
  }
  
  private void a(afrf paramafrf)
  {
    EmoticonPackage localEmoticonPackage;
    if (!this.jdField_a_of_type_Apnf.a(paramafrf.jdField_a_of_type_Aptm.a.epId, Boolean.valueOf(false)))
    {
      apne.a().a(this.jdField_a_of_type_Apns);
      localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramafrf.jdField_a_of_type_Aptm.a.name;
      localEmoticonPackage.epId = paramafrf.jdField_a_of_type_Aptm.a.epId;
      localEmoticonPackage.jobType = 3;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      if (paramafrf.jdField_e_of_type_Int != -1) {
        break label222;
      }
    }
    label222:
    for (localEmoticonPackage.rscType = attl.a(paramafrf.jdField_a_of_type_Aptm.a.magicValue);; localEmoticonPackage.rscType = paramafrf.jdField_e_of_type_Int)
    {
      ((aube)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramafrf.jdField_a_of_type_Aptm.a);
      paramafrf.jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)paramafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = true;
      this.jdField_a_of_type_JavaUtilList.add(paramafrf);
      paramafrf.f.setVisibility(8);
      paramafrf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_Apnf.a(localEmoticonPackage, false);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void a(afrf paramafrf, long paramLong)
  {
    Animatable localAnimatable = (Animatable)paramafrf.g.getDrawable();
    if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramLong)))
    {
      if (!localAnimatable.isRunning()) {
        localAnimatable.start();
      }
      paramafrf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(4);
      paramafrf.g.setVisibility(0);
      return;
    }
    if (localAnimatable.isRunning()) {
      localAnimatable.stop();
    }
    paramafrf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
    paramafrf.g.setVisibility(4);
  }
  
  private void a(afrf paramafrf, Rect paramRect)
  {
    AIOEmotionFragment.a(this.jdField_b_of_type_AndroidContentContext, paramafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramRect);
  }
  
  private void a(afrf paramafrf, String paramString)
  {
    ThreadManager.post(new MarketFaceItemBuilder.8(this, paramString, paramafrf), 5, null, true);
  }
  
  private void a(aptm paramaptm, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      str2 = a();
      if (paramaptm == null) {}
      for (paramaptm = "";; paramaptm = paramaptm.a.epId)
      {
        VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramaptm, paramString);
        return;
      }
    case 3: 
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramaptm == null) {}
      for (paramaptm = "";; paramaptm = paramaptm.a.epId)
      {
        azmj.b(paramString, "CliOper", "", "", "ep_mall", "0X8007187", 0, 0, paramaptm, "", "", "");
        return;
      }
    }
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    String str2 = a();
    if (paramaptm == null) {}
    for (paramaptm = "";; paramaptm = paramaptm.a.epId)
    {
      VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramaptm, paramString, "1", "", "", "", 0, 0, 0, 0);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    azmj.b(paramQQAppInterface, "CliOper", "", "", paramString2, paramString3, paramInt, 0, "", "", "", "");
  }
  
  private void a(ChatMessage paramChatMessage, afrf paramafrf)
  {
    a(paramChatMessage, paramafrf, "");
  }
  
  private void a(ChatMessage paramChatMessage, afrf paramafrf, String paramString)
  {
    if ((paramafrf.jdField_a_of_type_Aptm.b()) && (!c(paramChatMessage))) {}
    for (boolean bool = false;; bool = true)
    {
      Object localObject3 = paramafrf.jdField_a_of_type_Aptm.a("fromAIO", bool);
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
              localObject2 = paramafrf.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
              if ((localObject2 != null) && (((EmoticonPackage)localObject2).status == 2))
              {
                URLDrawable.removeMemoryCacheByUrl(((URLDrawable)localObject3).getURL().toString());
                localObject2 = paramafrf.jdField_a_of_type_Aptm.a("fromAIO", bool);
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
        if ((localObject1 != null) && (paramafrf.jdField_a_of_type_Aptm.a != null)) {
          if (paramafrf.jdField_a_of_type_Aptm.a.width == 0)
          {
            j = 200;
            if (paramafrf.jdField_a_of_type_Aptm.a.height != 0) {
              break label673;
            }
            m = 200;
            k = j;
            i = m;
            if (paramafrf.jdField_a_of_type_Aptm.a.extensionWidth != 0)
            {
              k = j;
              i = m;
              if (paramafrf.jdField_a_of_type_Aptm.a.extensionHeight != 0)
              {
                k = paramafrf.jdField_a_of_type_Aptm.a.extensionWidth;
                i = paramafrf.jdField_a_of_type_Aptm.a.extensionHeight;
              }
            }
            j = k;
            if (k != i) {
              j = i;
            }
            n = (j * this.jdField_e_of_type_Int + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
            i = (this.jdField_e_of_type_Int * i + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
            paramafrf.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(n, i));
            localObject2 = paramafrf.jdField_a_of_type_AndroidWidgetTextView.getTag();
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
          if ((paramafrf.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (i != -1))
          {
            localObject3 = (String)paramafrf.jdField_a_of_type_AndroidWidgetTextView.getTag(2131363791);
            String str = (String)paramafrf.jdField_a_of_type_AndroidWidgetTextView.getTag(2131363790);
            Paint localPaint = new Paint(1);
            localPaint.setTextSize(aekt.a(12.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
            localPaint.setTextAlign(Paint.Align.LEFT);
            int i1 = (int)localPaint.measureText("...");
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {}
            for (j = (int)localPaint.measureText(alpo.a(2131706849) + (String)localObject3);; j = (int)localPaint.measureText(alpo.a(2131706845)))
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
                localObject2 = paramafrf.jdField_a_of_type_Aptm.a("fromAIO", bool, true, paramafrf);
                paramString = (String)localObject1;
                localObject1 = localObject2;
                break;
              }
              j = paramafrf.jdField_a_of_type_Aptm.a.width;
              break label201;
              m = paramafrf.jdField_a_of_type_Aptm.a.height;
              break label219;
            }
            if (!((String)localObject2).equals(""))
            {
              localObject2 = a(i, (String)localObject2 + "...", (String)localObject3);
              paramafrf.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
            }
          }
          paramafrf.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          localObject2 = paramafrf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
          if (localObject1 != null) {}
          switch (((URLDrawable)localObject1).getStatus())
          {
          default: 
            paramafrf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            ((BaseChatItemLayout)localObject2).setProgressVisable(true);
            paramafrf.d.setVisibility(8);
            paramafrf.c.setVisibility(8);
            paramafrf.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
            if ((paramChatMessage.isFlowMessage) && (paramafrf.jdField_a_of_type_Aptm.a.jobType == 0)) {
              if (!(this.jdField_b_of_type_AndroidContentContext instanceof MultiForwardActivity))
              {
                if (!paramChatMessage.isSend()) {
                  break label1309;
                }
                paramafrf.c.setImageResource(2130846582);
                paramafrf.c.setVisibility(0);
              }
            }
            break;
          }
          for (;;)
          {
            if ((paramafrf.jdField_a_of_type_Aptm.b()) && (paramafrf.jdField_a_of_type_Aptm.c()) && ((paramChatMessage instanceof MessageForMarketFace)))
            {
              if (paramafrf.jdField_a_of_type_Aptm.a() != null)
              {
                paramChatMessage = (RelativeLayout.LayoutParams)paramafrf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
                paramChatMessage.width = aekt.a(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
                paramafrf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramafrf.jdField_a_of_type_Aptm.a(), paramChatMessage.width, paramafrf.jdField_a_of_type_Aptm.b());
                if (Build.VERSION.SDK_INT < 19)
                {
                  paramChatMessage = (RelativeLayout.LayoutParams)paramafrf.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
                  localObject2 = (RelativeLayout.LayoutParams)paramafrf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
                  paramChatMessage.width = aekt.a(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
                  ((RelativeLayout.LayoutParams)localObject2).width = aekt.a(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
                }
              }
              i = paramafrf.jdField_a_of_type_Aptm.c();
              j = paramafrf.jdField_a_of_type_Aptm.d();
              paramChatMessage = new azqp(i, 1, 1, aekt.a(22.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
              paramafrf.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(paramChatMessage);
              paramafrf.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView.setDrawColor(i);
              paramafrf.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView.postInvalidate();
              paramafrf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(j);
              paramafrf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(j);
            }
            if (localObject1 != null) {
              a(paramafrf, (URLDrawable)localObject1, paramString);
            }
            c(paramafrf);
            return;
            if (!atva.a()) {
              paramafrf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            }
            if ((apro.a()) && (2 == paramafrf.jdField_a_of_type_Aptm.a.jobType) && (!this.jdField_a_of_type_Apnf.e(paramafrf.jdField_a_of_type_Aptm.a.epId)) && (!apro.c())) {
              break;
            }
            float f1 = this.jdField_a_of_type_Apnf.a(paramafrf.jdField_a_of_type_Aptm.a.epId);
            if ((f1 >= 0.0F) && (1.0F != f1)) {
              break;
            }
            paramafrf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            ((BaseChatItemLayout)localObject2).setProgressVisable(false);
            break;
            paramafrf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            ((BaseChatItemLayout)localObject2).setProgressVisable(false);
            if (!AppSetting.c) {
              break;
            }
            paramafrf.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(alpo.a(2131706848));
            break;
            paramafrf.d.setImageResource(2130846582);
            paramafrf.d.setVisibility(0);
            continue;
            if ((paramChatMessage.isDui) && (DuiButtonImageView.jdField_a_of_type_Boolean) && (!aupu.a(paramChatMessage)))
            {
              paramafrf.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
              if ((paramChatMessage.isSend()) || (paramafrf.jdField_a_of_type_Aptm.b()))
              {
                paramafrf.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
                paramafrf.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
              }
              else if ((paramafrf.jdField_a_of_type_Aptm != null) && (paramafrf.jdField_a_of_type_Aptm.a != null) && ((2 == paramafrf.jdField_a_of_type_Aptm.a.jobType) || (4 == paramafrf.jdField_a_of_type_Aptm.a.jobType)))
              {
                paramafrf.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
                paramafrf.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
              }
              else
              {
                if (!paramChatMessage.hasPlayedDui) {
                  paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramafrf.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView);
                }
                for (;;)
                {
                  if (!DuiButtonImageView.jdField_a_of_type_Boolean) {
                    break label1511;
                  }
                  paramafrf.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(this);
                  paramafrf.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(0);
                  break;
                  paramafrf.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.f();
                }
                paramafrf.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(null);
                paramafrf.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
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
      bdcd.a(paramContext, 230, paramString1, paramString2, 2131690648, 2131691704, new afqw(paramEmoticon, paramContext, paramQQAppInterface, paramInt), new afqy()).show();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EmosmDetailActivity.showCustomMarketFaceTips", 2, paramContext.getMessage());
    }
  }
  
  private void b(afrf paramafrf)
  {
    if ((4 != paramafrf.jdField_a_of_type_Aptm.a.jobType) || (((MessageForMarketFace)paramafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Apnf.a(paramafrf.jdField_a_of_type_Aptm.a.epId, true, true)) {
        break;
      }
      if (!apro.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone: H5MagicSource isnot Intact , and network isnot 2 3 4G or wifi;epId = " + paramafrf.jdField_a_of_type_Aptm.a.epId);
        }
        paramafrf.f.setVisibility(8);
        return;
      }
    } while (-1.0F != this.jdField_a_of_type_Apnf.a(paramafrf.jdField_a_of_type_Aptm.a.epId));
    apne.a().a(this.jdField_a_of_type_Apns);
    EmoticonPackage localEmoticonPackage = new EmoticonPackage();
    localEmoticonPackage.name = paramafrf.jdField_a_of_type_Aptm.a.name;
    localEmoticonPackage.epId = paramafrf.jdField_a_of_type_Aptm.a.epId;
    localEmoticonPackage.jobType = 5;
    localEmoticonPackage.type = 1;
    localEmoticonPackage.isMagicFaceDownloading = true;
    ((aube)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramafrf.jdField_a_of_type_Aptm.a);
    this.jdField_a_of_type_JavaUtilList.add(paramafrf);
    paramafrf.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
    paramafrf.f.setVisibility(8);
    paramafrf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    ((MessageForMarketFace)paramafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
    this.jdField_a_of_type_Apnf.a(localEmoticonPackage, false);
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone,start download epId = " + paramafrf.jdField_a_of_type_Aptm.a.epId);
    }
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, localEmoticonPackage.epId, "", "", "");
    return;
    if ((this.f) && (this.jdField_a_of_type_Apnf.b()))
    {
      if (!this.jdField_b_of_type_Boolean) {
        paramafrf.f.setVisibility(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source intacat epId = " + paramafrf.jdField_a_of_type_Aptm.a.epId);
      }
    }
    for (;;)
    {
      paramafrf.f.setImageResource(2130837910);
      if ((((MessageForMarketFace)paramafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage).isSend()) || (!((MessageForMarketFace)paramafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay) || (!this.jdField_a_of_type_Apnf.a()) || (System.currentTimeMillis() - this.jdField_d_of_type_Long <= 3000L) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().p())) {
        break;
      }
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      ((MessageForMarketFace)paramafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      a(paramafrf, "1");
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramafrf.jdField_a_of_type_Aptm.a.epId, "", "", "");
      return;
      paramafrf.f.setVisibility(8);
    }
  }
  
  private void c(afrf paramafrf)
  {
    paramafrf.jdField_a_of_type_Boolean = false;
    if ((2 != paramafrf.jdField_a_of_type_Aptm.a.jobType) || (((MessageForMarketFace)paramafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null) || (!atva.a())) {}
    for (;;)
    {
      return;
      Object localObject;
      if (!this.jdField_a_of_type_Apnf.e(paramafrf.jdField_a_of_type_Aptm.a.epId))
      {
        if (!apro.a())
        {
          paramafrf.f.setVisibility(8);
          return;
        }
        if ((!apro.c()) && (!this.jdField_a_of_type_Apnf.a(paramafrf.jdField_a_of_type_Aptm.a.epId, Boolean.valueOf(false))) && (-1.0F == this.jdField_a_of_type_Apnf.a(paramafrf.jdField_a_of_type_Aptm.a.epId)))
        {
          apne.a().a(this.jdField_a_of_type_Apns);
          localObject = new EmoticonPackage();
          ((EmoticonPackage)localObject).name = paramafrf.jdField_a_of_type_Aptm.a.name;
          ((EmoticonPackage)localObject).epId = paramafrf.jdField_a_of_type_Aptm.a.epId;
          ((EmoticonPackage)localObject).jobType = 3;
          ((EmoticonPackage)localObject).rscType = attl.a(paramafrf.jdField_a_of_type_Aptm.a.magicValue);
          ((EmoticonPackage)localObject).type = 1;
          ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
          ((aube)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramafrf.jdField_a_of_type_Aptm.a);
          this.jdField_a_of_type_JavaUtilList.add(paramafrf);
          paramafrf.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
          paramafrf.f.setVisibility(8);
          paramafrf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((MessageForMarketFace)paramafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          this.jdField_a_of_type_Apnf.a((EmoticonPackage)localObject, false);
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongXiazai", 0, 0, paramafrf.jdField_a_of_type_Aptm.a.epId, "", "", "");
        }
      }
      else
      {
        if (attl.a(paramafrf.jdField_a_of_type_Aptm.a.magicValue) == 1) {
          paramafrf.f.setVisibility(8);
        }
        while (((MessageForMarketFace)paramafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay)
        {
          ((MessageForMarketFace)paramafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          localObject = new Emoticon();
          ((Emoticon)localObject).eId = paramafrf.jdField_a_of_type_Aptm.a.eId;
          ((Emoticon)localObject).epId = paramafrf.jdField_a_of_type_Aptm.a.epId;
          ((Emoticon)localObject).magicValue = paramafrf.jdField_a_of_type_Aptm.a.magicValue;
          ((Emoticon)localObject).jobType = paramafrf.jdField_a_of_type_Aptm.a.jobType;
          if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() != null) && (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null) && (atva.a())) {
            ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a((Emoticon)localObject, 1, ((MessageForMarketFace)paramafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage).senderuin, false);
          }
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramafrf.jdField_a_of_type_Aptm.a.epId, "", "", "");
          return;
          if (!this.jdField_b_of_type_Boolean)
          {
            paramafrf.f.setImageResource(2130837910);
            paramafrf.f.setVisibility(0);
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
  
  private void d(afrf paramafrf)
  {
    if ((paramafrf != null) && (paramafrf.jdField_a_of_type_Aptm != null) && (paramafrf.jdField_a_of_type_Aptm.c()) && (paramafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (!this.jdField_c_of_type_JavaUtilSet.contains(Long.valueOf(paramafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))))
    {
      aube.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AB51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramafrf.jdField_a_of_type_Aptm.a.epId);
      this.jdField_c_of_type_JavaUtilSet.add(Long.valueOf(paramafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aelt a()
  {
    return new afrf();
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    long l = System.currentTimeMillis();
    paramBaseChatItemLayout = (MessageForMarketFace)paramChatMessage;
    afrf localafrf = (afrf)paramaelt;
    this.jdField_b_of_type_JavaUtilSet.add(localafrf);
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
      paramaelt = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject2 = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout)localObject2).setId(2131370059);
      paramView = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      paramView.setId(2131366582);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131364171);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131364171);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setOnClickListener(this);
      localObject1 = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).setId(2131363207);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = 8;
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131366582);
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      ((FrameLayout)localObject1).setOnClickListener(this);
      ((FrameLayout)localObject1).setOnTouchListener(paramaeov);
      ((FrameLayout)localObject1).setOnLongClickListener(paramaeov);
      paramaeov = new afrg(this, this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).addView(paramaeov, -2, -2);
      localObject4 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localObject5 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject5).gravity = 85;
      ((FrameLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject5).setId(2131380016);
      localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(1, 2131363207);
      ((RelativeLayout.LayoutParams)localObject6).addRule(8, 2131363207);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      ((ImageView)localObject5).setOnClickListener(this);
      localObject6 = new BreathAnimationLayout(this.jdField_b_of_type_AndroidContentContext);
      ((BreathAnimationLayout)localObject6).setId(2131371084);
      localPttAudioPlayView = new PttAudioPlayView(this.jdField_b_of_type_AndroidContentContext, 10);
      localPttAudioPlayView.setThemeColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131166919).getDefaultColor());
      localPttAudioPlayView.setId(2131371086);
      localPttAudioPlayView.setPttPauseOrStopDrawable(2130838100);
      localObject7 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject7).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject7).leftMargin = aekt.a(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).width = aekt.a(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).height = aekt.a(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      localPttAudioPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject7);
      localPttAudioPlayView.setOnClickListener(this);
      localObject7 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localObject8 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject8).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject8).leftMargin = aekt.a(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).width = aekt.a(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).height = aekt.a(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((ImageView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
      ((ImageView)localObject7).setImageDrawable((Drawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839222));
      ((ImageView)localObject7).setVisibility(4);
      localObject8 = new PttAudioWaveView(this.jdField_b_of_type_AndroidContentContext);
      ((PttAudioWaveView)localObject8).setShowProgressLine(false);
      ((PttAudioWaveView)localObject8).setMaxTopBottomPadding(4);
      ((PttAudioWaveView)localObject8).setProgressColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131166919).getDefaultColor());
      ((PttAudioWaveView)localObject8).setId(2131371087);
      localObject9 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(1, 2131371086);
      ((RelativeLayout.LayoutParams)localObject9).width = aekt.a(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).height = aekt.a(45.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).leftMargin = bdkf.a(9.0F);
      ((RelativeLayout.LayoutParams)localObject9).rightMargin = bdkf.a(12.0F);
      ((PttAudioWaveView)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
      ((PttAudioWaveView)localObject8).setCanSupportSlide(false);
      ((PttAudioWaveView)localObject8).setOnClickListener(this);
      localObject9 = new SyncParentPressedRelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      ((RelativeLayout)localObject9).setId(2131371085);
      ((RelativeLayout)localObject9).addView((View)localObject8);
      ((RelativeLayout)localObject9).addView(localPttAudioPlayView);
      ((RelativeLayout)localObject9).addView((View)localObject7);
      localRelativeLayout = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localTriangleView = new TriangleView(this.jdField_b_of_type_AndroidContentContext);
      localObject10 = new RelativeLayout.LayoutParams(bdkf.a(9.0F), bdkf.a(5.0F));
      ((RelativeLayout.LayoutParams)localObject10).leftMargin = bdkf.a(2.0F);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14);
      ((RelativeLayout.LayoutParams)localObject10).addRule(10);
      localTriangleView.setId(2131372087);
      localTriangleView.setRotation(180.0F);
      localTriangleView.setTranslationY(bdkf.a(1.0F));
      localTriangleView.setLayoutParams((ViewGroup.LayoutParams)localObject10);
      localRelativeLayout.addView(localTriangleView);
      localObject10 = new RelativeLayout.LayoutParams(-2, bdkf.a(29.0F));
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131372087);
      localRelativeLayout.addView((View)localObject9, (ViewGroup.LayoutParams)localObject10);
      ((BreathAnimationLayout)localObject6).addView(localRelativeLayout);
      localObject10 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14, 2131363207);
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131363207);
      ((RelativeLayout.LayoutParams)localObject10).bottomMargin = bdkf.a(17.0F);
      ((RelativeLayout)localObject2).addView((View)localObject6, (ViewGroup.LayoutParams)localObject10);
      localObject10 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject10).setId(2131366583);
      localObject11 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject11).addRule(1, 2131363207);
      ((RelativeLayout.LayoutParams)localObject11).addRule(15, 2131363207);
      ((RelativeLayout.LayoutParams)localObject11).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject10, (ViewGroup.LayoutParams)localObject11);
      ((ImageView)localObject10).setOnClickListener(this);
      localObject11 = new DuiButtonImageView(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      ((DuiButtonImageView)localObject11).setId(2131365500);
      localObject12 = new RelativeLayout.LayoutParams(aekt.a(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), aekt.a(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject12).addRule(1, 2131363207);
      ((RelativeLayout.LayoutParams)localObject12).addRule(8, 2131363207);
      ((RelativeLayout.LayoutParams)localObject12).setMargins(0, 0, 0, -aekt.a(6.5F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout)localObject2).addView((View)localObject11, (ViewGroup.LayoutParams)localObject12);
      localObject12 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject12).setId(2131369973);
      localObject13 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject13).addRule(1, 2131363207);
      ((RelativeLayout.LayoutParams)localObject13).addRule(8, 2131363207);
      ((RelativeLayout.LayoutParams)localObject13).leftMargin = aekt.a(10.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout)localObject2).addView((View)localObject12, (ViewGroup.LayoutParams)localObject13);
      localObject13 = new TextView(this.jdField_b_of_type_AndroidContentContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      ((TextView)localObject13).setTextSize(12.0F);
      ((TextView)localObject13).setTextColor(-1);
      localLayoutParams.topMargin = aekt.a(8.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((TextView)localObject13).setGravity(17);
      localLayoutParams.addRule(3, 2131370059);
    }
    for (;;)
    {
      try
      {
        ((TextView)localObject13).setBackgroundDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130844305));
        ((TextView)localObject13).setPadding(aekt.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), aekt.a(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), aekt.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), aekt.a(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
        paramaelt.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramaelt.addView((View)localObject13, localLayoutParams);
        ((ImageView)localObject12).setOnClickListener(this);
        localObject2 = new ProgressBar(this.jdField_b_of_type_AndroidContentContext, null, 0);
        ((ProgressBar)localObject2).setId(2131364198);
      }
      catch (Exception localException2)
      {
        try
        {
          ((ProgressBar)localObject2).setIndeterminateDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839224));
          int i = aekt.a(16.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
          localObject3 = new FrameLayout.LayoutParams(i, i);
          ((FrameLayout.LayoutParams)localObject3).gravity = 17;
          ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          localafrf.jdField_e_of_type_AndroidWidgetImageView = paramaeov;
          localafrf.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject4);
          localafrf.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject5);
          localafrf.c = paramView;
          localafrf.d = ((ImageView)localObject10);
          localafrf.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView = ((DuiButtonImageView)localObject11);
          localafrf.f = ((ImageView)localObject12);
          localafrf.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localObject1);
          localafrf.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject2);
          localafrf.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject13);
          localafrf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)localObject6);
          localafrf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = localPttAudioPlayView;
          localafrf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject8);
          localafrf.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject9);
          localafrf.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
          localafrf.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView = localTriangleView;
          localafrf.g = ((ImageView)localObject7);
          if (!c(paramChatMessage)) {
            paramBaseChatItemLayout.playProgress = 0.0F;
          }
          a(localafrf, paramChatMessage.uniseq);
          localafrf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          localafrf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramBaseChatItemLayout.playProgress);
          if ((AppSetting.c) && (a(paramChatMessage, localafrf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) && (localafrf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)) {
            localafrf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setContentDescription(alpo.a(2131706850));
          }
          new QueryTask(new afqz(this, localafrf), new afra(this, localafrf, paramBaseChatItemLayout, paramChatMessage, l)).a(paramBaseChatItemLayout.mMarkFaceMessage);
          return paramaelt;
          localException2 = localException2;
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException2);
        }
        catch (Exception localException1)
        {
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException1);
          continue;
        }
      }
      if ((localafrf.jdField_a_of_type_Aptm != null) && (localafrf.jdField_a_of_type_Aptm.b()) && (localafrf.jdField_b_of_type_AndroidWidgetImageView != null) && ((localafrf.jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof AnimationDrawable))) {
        localafrf.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846602);
      }
      paramaelt = paramView;
      if (AppSetting.c)
      {
        localafrf.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        paramaelt = paramView;
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (!bdec.a(paramChatMessage.issend)) {
        break label103;
      }
      localStringBuilder.append("发出表情");
    }
    for (;;)
    {
      paramChatMessage = (MessageForMarketFace)paramChatMessage;
      if (paramChatMessage.mMarkFaceMessage != null)
      {
        paramChatMessage = ((aube)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramChatMessage.mMarkFaceMessage);
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
    apne.a().b(this.jdField_a_of_type_Apns);
    apne.a().b(this.jdField_a_of_type_Afre);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((afrf)localIterator.next()).a();
    }
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((jdField_a_of_type_Aptm == null) || (jdField_a_of_type_Aptm.a == null))
    {
      QLog.e("MarketFaceItemBuilder", 1, "onMenuItemClicked emoticon is null");
      return;
    }
    if ((paramInt == 2131365069) || (paramInt == 2131362126) || (paramInt == 2131366766) || (paramInt == 2131366481))
    {
      ((aube)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(jdField_a_of_type_Aptm.a.epId, new afqx(this, paramInt, paramChatMessage));
      return;
    }
    if (paramInt == 2131370842)
    {
      super.d(paramChatMessage);
      return;
    }
    if (paramInt == 2131370799)
    {
      super.a(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  void a(afrf paramafrf, URLDrawable paramURLDrawable)
  {
    a(paramafrf, paramURLDrawable, "");
  }
  
  void a(afrf paramafrf, URLDrawable paramURLDrawable, String paramString)
  {
    paramafrf.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramafrf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
    paramafrf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramafrf.f.setVisibility(8);
    paramafrf.jdField_b_of_type_Boolean = false;
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
        if (paramafrf.jdField_a_of_type_Aptm.b()) {
          if (paramafrf.jdField_a_of_type_Aptm.c()) {
            paramafrf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          }
        }
      }
      while (!"big_sound".equals(str))
      {
        do
        {
          return;
          paramafrf.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846602);
          paramafrf.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        } while ((i != 1) || (paramafrf.jdField_a_of_type_Aptm.j != 3));
        paramafrf.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837907);
        paramafrf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramafrf.jdField_b_of_type_Boolean = true;
        return;
      }
      if (c(paramafrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
      {
        if (paramafrf.jdField_a_of_type_Aptm.c())
        {
          paramafrf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          paramafrf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          return;
        }
        paramafrf.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramURLDrawable = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772259);
        paramafrf.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
        paramURLDrawable.start();
        return;
      }
      if (paramafrf.jdField_a_of_type_Aptm.c())
      {
        paramafrf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
        paramafrf.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
        return;
      }
      paramafrf.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846602);
      paramafrf.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
  }
  
  public void a(View paramView)
  {
    paramView = (afrf)aekt.a(paramView);
    String str1;
    String str2;
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSendFromLocal())
    {
      str1 = this.jdField_b_of_type_AndroidContentContext.getString(2131690042);
      str2 = this.jdField_b_of_type_AndroidContentContext.getString(2131690043);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 41) && (paramView.jdField_a_of_type_Aptm != null) && (paramView.jdField_a_of_type_Aptm.a != null)) {
        a((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_Aptm);
      }
    }
    do
    {
      return;
      bdcd.a(this.jdField_b_of_type_AndroidContentContext, 230, str1, str2, new afqt(this, paramView), new afqu(this)).show();
      return;
      paramView = paramView.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
    } while (!(paramView instanceof URLDrawable));
    ((URLDrawable)paramView).restartDownload();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, azgq.a(10.0F), 0);
  }
  
  protected void a(MessageForMarketFace paramMessageForMarketFace, aptm paramaptm)
  {
    if ((paramMessageForMarketFace == null) || (paramaptm == null) || (paramaptm.a == null) || (paramaptm.a.epId == null)) {
      return;
    }
    bhpy localbhpy = (bhpy)bhql.a(this.jdField_b_of_type_AndroidContentContext, null);
    localbhpy.a(this.jdField_b_of_type_AndroidContentContext.getString(2131692101));
    localbhpy.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131692100), 1);
    localbhpy.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131692102), 1);
    localbhpy.c(2131690648);
    localbhpy.a(new afqv(this, paramaptm, localbhpy, paramMessageForMarketFace));
    localbhpy.show();
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if ((paramView != null) && (paramFloat > 0.0F))
    {
      paramXListView = (afrf)aekt.a(paramView);
      if ((paramXListView != null) && (paramXListView.jdField_a_of_type_Aptm != null) && (paramXListView.jdField_a_of_type_Aptm.b()) && (paramXListView.jdField_a_of_type_Aptm.c()) && (c(paramChatMessage)))
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
      paramXListView = (afrf)aekt.a(paramView);
      if (!paramXListView.jdField_a_of_type_Aptm.c()) {
        break label66;
      }
      paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
        paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
      }
    }
    for (;;)
    {
      paramView = paramXListView.jdField_a_of_type_Aptm.a("fromAIO", false);
      paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      return;
      label66:
      paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846602);
    }
  }
  
  public boolean a(aelt paramaelt)
  {
    return paramaelt instanceof afrf;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer, int paramInt2)
  {
    paramXListView = (afrf)aekt.a(paramView);
    if ((paramXListView == null) || (paramXListView.jdField_a_of_type_Aptm == null) || (paramXListView.jdField_a_of_type_Aptm.a == null)) {
      return false;
    }
    if (paramXListView.jdField_a_of_type_Aptm.b())
    {
      paramView = apro.o.replace("[epId]", paramXListView.jdField_a_of_type_Aptm.a.epId).replace("[eId]", paramXListView.jdField_a_of_type_Aptm.a.eId);
      if (!bdcs.b(paramView))
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
        paramView = paramXListView.jdField_a_of_type_Aptm.a("fromAIO", true);
        paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        aptm.a(paramView);
        if (paramXListView.jdField_a_of_type_Aptm.c()) {
          if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
            paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          }
        }
        for (;;)
        {
          return true;
          paramView = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772259);
          paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
          paramView.start();
        }
      }
    }
    return false;
  }
  
  public bdlb[] a(View paramView)
  {
    paramView = (afrf)aekt.a(paramView);
    bdkz localbdkz = new bdkz();
    jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (ApolloUtil.a(jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
      return localbdkz.a();
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
        if (paramView.jdField_a_of_type_Aptm.a.jobType != 1)
        {
          jdField_a_of_type_Aptm = paramView.jdField_a_of_type_Aptm;
          if (aekt.a(1) == 1) {
            localbdkz.a(2131362126, this.jdField_b_of_type_AndroidContentContext.getString(2131693475), 2130838675);
          }
          localbdkz.a(2131366766, this.jdField_b_of_type_AndroidContentContext.getString(2131692835), 2130838677);
          a(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbdkz);
          if ((paramView.jdField_a_of_type_Aptm.a.jobType != 2) && (paramView.jdField_a_of_type_Aptm.a.jobType != 4)) {
            localbdkz.a(2131366481, this.jdField_b_of_type_AndroidContentContext.getString(2131693484), 2130838656);
          }
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Ap_show_forward", 0);
        }
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
          a(localbdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        a(localbdkz, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        if (paramView.jdField_a_of_type_Aptm.a.jobType != 1) {
          b(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbdkz);
        }
        super.c(localbdkz, this.jdField_b_of_type_AndroidContentContext);
        super.e(localbdkz, this.jdField_b_of_type_AndroidContentContext);
      }
      for (;;)
      {
        return localbdkz.a();
        jdField_a_of_type_Aptm = paramView.jdField_a_of_type_Aptm;
        acex.a(localbdkz, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public void d(View paramView)
  {
    aekt.n = true;
    if (super.a()) {
      return;
    }
    Object localObject3;
    Drawable localDrawable;
    URLDrawable localURLDrawable;
    Object localObject1;
    if (paramView.getId() == 2131363207)
    {
      localObject3 = (afrf)aekt.a(paramView);
      localDrawable = ((afrf)localObject3).jdField_e_of_type_AndroidWidgetImageView.getDrawable();
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
        if ((((afrf)localObject3).jdField_a_of_type_Aptm != null) && (((afrf)localObject3).jdField_a_of_type_Aptm.a != null) && (((afrf)localObject3).jdField_a_of_type_Aptm.a.jobType == 2) && (atva.a())) {
          a((afrf)localObject3);
        }
        if ((((URLDrawable)localDrawable).getStatus() != 1) && ((((afrf)localObject3).jdField_a_of_type_Aptm == null) || (((afrf)localObject3).jdField_a_of_type_Aptm.a == null) || (!((afrf)localObject3).jdField_a_of_type_Aptm.e()))) {
          break;
        }
        a((afrf)localObject3, zen.a(paramView));
        return;
        localObject2 = "";
        if ((localURLDrawable.getStateTag() instanceof Bundle)) {
          localObject2 = ((Bundle)localURLDrawable.getStateTag()).getString("display_type");
        }
        localURLDrawable.restartDownload();
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "msgOnclickListener| URLDrawable restartDownload status=" + localURLDrawable.getStatus());
        }
        a((afrf)localObject3, localURLDrawable, (String)localObject2);
        ((afrf)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        if ((((afrf)localObject3).jdField_a_of_type_Aptm != null) && (((afrf)localObject3).jdField_a_of_type_Aptm.b()) && ("big_sound".equals(localObject1)))
        {
          jdField_c_of_type_Long = ((afrf)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
          continue;
          if ((((afrf)localObject3).jdField_a_of_type_Aptm != null) && (((afrf)localObject3).jdField_a_of_type_Aptm.a != null) && (((afrf)localObject3).jdField_a_of_type_Aptm.a.jobType != 0) && (((afrf)localObject3).jdField_a_of_type_Aptm.a.jobType != 2) && (((afrf)localObject3).jdField_a_of_type_Aptm.a.jobType != 4))
          {
            ((afrf)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            if ("big_sound".equals(localObject1))
            {
              if ((((afrf)localObject3).jdField_a_of_type_Aptm.a != null) && (((afrf)localObject3).jdField_a_of_type_Aptm.a.isSound)) {
                if (c(((afrf)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
                  MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
                } else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
                  QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695680, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
                } else {
                  MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((afrf)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
                }
              }
            }
            else if ("aio_preview".equals(localObject1))
            {
              localObject1 = ((afrf)localObject3).jdField_a_of_type_Aptm.a("fromAIO", true);
              if (localObject1 != null)
              {
                ((afrf)localObject3).jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
                ((afrf)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
                a((afrf)localObject3, (URLDrawable)localObject1);
                if (((afrf)localObject3).jdField_a_of_type_Aptm.b()) {
                  jdField_c_of_type_Long = ((afrf)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
                }
              }
            }
          }
        }
      }
      if ((!(localDrawable instanceof attb)) || (((afrf)localObject3).jdField_a_of_type_Aptm == null) || (((afrf)localObject3).jdField_a_of_type_Aptm.a == null) || (!((afrf)localObject3).jdField_a_of_type_Aptm.e())) {
        break;
      }
      a((afrf)localObject3, zen.a(paramView));
      return;
      if (paramView.getId() == 2131380016)
      {
        localObject1 = (afrf)aekt.a(paramView);
        if ((((afrf)localObject1).jdField_a_of_type_Aptm != null) && (((afrf)localObject1).jdField_a_of_type_Aptm.b()))
        {
          if (!c(((afrf)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
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
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695680, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
            }
            else
            {
              MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((afrf)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
              continue;
              if ((paramView.getId() == 2131371086) || (paramView.getId() == 2131371087))
              {
                localObject2 = (afrf)aekt.a(paramView);
                if ((((afrf)localObject2).jdField_a_of_type_Aptm != null) && (((afrf)localObject2).jdField_a_of_type_Aptm.b()) && (((afrf)localObject2).jdField_a_of_type_Aptm.c()))
                {
                  int i;
                  if (c(((afrf)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage))
                  {
                    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
                    localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                    i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
                    if (((afrf)localObject2).jdField_a_of_type_Aptm.a != null) {}
                    for (localObject1 = ((afrf)localObject2).jdField_a_of_type_Aptm.a.epId;; localObject1 = "")
                    {
                      aube.a((QQAppInterface)localObject3, "0X800A934", i, (String)localObject1);
                      break;
                    }
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
                  {
                    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695680, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
                  }
                  else
                  {
                    if ((((afrf)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMarketFace)) {
                      ((MessageForMarketFace)((afrf)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage).playProgress = 0.0F;
                    }
                    ((afrf)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
                    boolean bool = false;
                    if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((afrf)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage))
                    {
                      bool = true;
                      ((afrf)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
                      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
                      if (((afrf)localObject2).jdField_a_of_type_Aptm.a != null)
                      {
                        localObject1 = ((afrf)localObject2).jdField_a_of_type_Aptm.a.epId;
                        aube.a((QQAppInterface)localObject3, "0X800A933", i, (String)localObject1);
                      }
                    }
                    else
                    {
                      if (!bool)
                      {
                        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                        if (((afrf)localObject2).jdField_a_of_type_Aptm.a == null) {
                          break label1239;
                        }
                        localObject1 = ((afrf)localObject2).jdField_a_of_type_Aptm.a.epId;
                        aube.a((QQAppInterface)localObject3, "0X800A935", -1, (String)localObject1);
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
                      azmz.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "NewAudioEmoticonVoicePlay", bool, 0L, 0L, (HashMap)localObject2, null);
                      break;
                      localObject1 = "";
                      break label1105;
                      localObject1 = "";
                      break label1150;
                    }
                  }
                }
              }
              else if ((paramView.getId() == 2131366583) || (paramView.getId() == 2131366582))
              {
                localObject1 = (afrf)aekt.a(paramView);
                localObject2 = a();
                if (localObject2 != null)
                {
                  ((bepp)localObject2).a(this.jdField_b_of_type_AndroidContentContext.getString(2131692105));
                  ((bepp)localObject2).show();
                }
                ((aube)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(((afrf)localObject1).jdField_a_of_type_Aptm.a.epId, new afqs(this, (afrf)localObject1, (bepp)localObject2));
              }
              else
              {
                if (paramView.getId() != 2131365500) {
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
        } while (paramView.getId() != 2131369973);
        localObject1 = (afrf)aekt.a(paramView);
        if ((((afrf)localObject1).jdField_a_of_type_Aptm != null) && (((afrf)localObject1).jdField_a_of_type_Aptm.a != null) && (2 == ((afrf)localObject1).jdField_a_of_type_Aptm.a.jobType))
        {
          if (this.jdField_a_of_type_Apnf.a(((afrf)localObject1).jdField_a_of_type_Aptm.a.epId, Boolean.valueOf(false))) {
            break;
          }
          apne.a().a(this.jdField_a_of_type_Apns);
          localObject2 = new EmoticonPackage();
          ((EmoticonPackage)localObject2).name = ((afrf)localObject1).jdField_a_of_type_Aptm.a.name;
          ((EmoticonPackage)localObject2).epId = ((afrf)localObject1).jdField_a_of_type_Aptm.a.epId;
          ((EmoticonPackage)localObject2).jobType = 3;
          ((EmoticonPackage)localObject2).type = 1;
          ((EmoticonPackage)localObject2).isMagicFaceDownloading = true;
          ((afrf)localObject1).jdField_a_of_type_Boolean = false;
          ((MessageForMarketFace)((afrf)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          ((aube)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(((afrf)localObject1).jdField_a_of_type_Aptm.a);
          this.jdField_a_of_type_JavaUtilList.add(localObject1);
          ((afrf)localObject1).f.setVisibility(8);
          ((afrf)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          this.jdField_a_of_type_Apnf.a((EmoticonPackage)localObject2, false);
          azmj.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongBofang", 0, 0, ((afrf)localObject1).jdField_a_of_type_Aptm.a.epId, "", "", "");
        }
      } while ((((afrf)localObject1).jdField_a_of_type_Aptm == null) || (((afrf)localObject1).jdField_a_of_type_Aptm.a == null) || (4 != ((afrf)localObject1).jdField_a_of_type_Aptm.a.jobType) || (System.currentTimeMillis() - this.jdField_d_of_type_Long <= 3000L) || (!this.jdField_a_of_type_Apnf.a()));
      label1239:
      label1247:
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_Apnf.a(((afrf)localObject1).jdField_a_of_type_Aptm.a.epId, true, true)) {
        a((afrf)localObject1, "0");
      }
      for (;;)
      {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbFasong", "MbZhudongBofang", 0, 0, ((afrf)localObject1).jdField_a_of_type_Aptm.a.epId, "", "", "");
        break;
        if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (!atva.a()) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null)) {
          break label1692;
        }
        ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a(((afrf)localObject1).jdField_a_of_type_Aptm.a, 1, ((afrf)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, true);
        break label1692;
        apne.a().a(this.jdField_a_of_type_Apns);
        localObject2 = new EmoticonPackage();
        ((EmoticonPackage)localObject2).name = ((afrf)localObject1).jdField_a_of_type_Aptm.a.name;
        ((EmoticonPackage)localObject2).epId = ((afrf)localObject1).jdField_a_of_type_Aptm.a.epId;
        ((EmoticonPackage)localObject2).jobType = 5;
        ((EmoticonPackage)localObject2).type = 1;
        ((EmoticonPackage)localObject2).isMagicFaceDownloading = true;
        ((afrf)localObject1).jdField_a_of_type_Boolean = false;
        ((MessageForMarketFace)((afrf)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
        ((aube)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(((afrf)localObject1).jdField_a_of_type_Aptm.a);
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
        ((afrf)localObject1).f.setVisibility(8);
        ((afrf)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_Apnf.a((EmoticonPackage)localObject2, false);
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
 * Qualified Name:     afqr
 * JD-Core Version:    0.7.0.1
 */