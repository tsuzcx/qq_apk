import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.ClipboardManager;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.RelativeSizeSpan;
import android.text.util.Linkify;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.6;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.util.Pair;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class agda
  extends BaseBubbleBuilder
  implements aeqh, Handler.Callback
{
  public static final LRULinkedHashMap<Long, SpannableString> a;
  private static String jdField_a_of_type_JavaLangString = "ArkApp.TextItemBuilder";
  public static final int c = BaseChatItemLayout.g + BaseChatItemLayout.l;
  protected static final int d = BaseChatItemLayout.h + BaseChatItemLayout.m;
  public static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  public static final int f = BaseChatItemLayout.j + BaseChatItemLayout.o;
  protected View.OnClickListener a;
  protected bemz a;
  private fu jdField_a_of_type_Fu = new agdg(this);
  public Handler b;
  protected View.OnClickListener b;
  
  static
  {
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(50);
  }
  
  public agda(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new agdb(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new agdc(this);
    this.jdField_a_of_type_Bemz = new agdi(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Activity paramActivity, ChatMessage paramChatMessage, String paramString)
  {
    paramChatMessage.msg = a(paramChatMessage.msg, true);
    paramString = a(paramString, true);
    biva.a(null, paramString).b(paramQQAppInterface, paramChatMessage).a(paramActivity, paramQQAppInterface.getAccount());
    bivo.a(paramQQAppInterface, 6, 1);
    return paramString;
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    int k = paramString.length();
    int i = 0;
    if (i < k)
    {
      int j = i;
      if ('\024' == paramString.charAt(i))
      {
        j = i;
        if (i + 1 < k)
        {
          j = i;
          if ('ÿ' == paramString.charAt(i + 1))
          {
            j = i;
            if (i + 2 < k)
            {
              if (!paramBoolean) {
                break label116;
              }
              if (paramString.charAt(i + 2) == '\024') {
                paramString.setCharAt(i + 2, 'ý');
              }
            }
          }
        }
      }
      for (;;)
      {
        j = i + 4;
        i = j + 1;
        break;
        label116:
        if (paramString.charAt(i + 2) == 'ý') {
          paramString.setCharAt(i + 2, '\024');
        }
      }
    }
    return paramString.toString();
  }
  
  public static void a(Message paramMessage, XListView paramXListView)
  {
    long l = paramMessage.getData().getLong("msg_id");
    paramXListView = aepi.a(paramXListView, aepi.a(l, paramXListView.getAdapter()));
    if ((paramXListView != null) && ((paramXListView.getTag() instanceof agdh)))
    {
      paramXListView = (agdh)paramXListView.getTag();
      if (paramXListView.jdField_a_of_type_Long == l)
      {
        if ((paramMessage.obj instanceof SpannableString))
        {
          paramMessage = (SpannableString)paramMessage.obj;
          paramXListView.d.setText(paramMessage);
          ((ETTextView)paramXListView.d).mMagicFont = true;
          if ((paramXListView.d instanceof ETTextView))
          {
            ETTextView localETTextView = (ETTextView)paramXListView.d;
            if (localETTextView.mFont != null) {
              localETTextView.mFont.mText = paramMessage;
            }
          }
        }
        if (((ETTextView)paramXListView.d).isUsingHYFont()) {
          ((ETTextView)paramXListView.d).isParsingMagicFont = false;
        }
        paramXListView.d.requestLayout();
      }
    }
  }
  
  private boolean a(ChatMessage paramChatMessage, agdh paramagdh)
  {
    int i = 0;
    boolean bool2 = false;
    int j;
    boolean bool1;
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) && (paramChatMessage.isShowQIMStyleGroup))
    {
      i = Color.parseColor("#FFFFFFFF");
      j = Color.parseColor("#ff5078f0");
      paramagdh.d.setTextColor(i);
      paramagdh.d.setLinkTextColor(j);
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0);
      bool1 = bool2;
    } while (!aglv.a().a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
    if (!paramChatMessage.isSend()) {
      i = 1;
    }
    if (i != 0) {
      j = Color.parseColor("#ff000000");
    }
    for (i = Color.parseColor("#ff80e9ff");; i = Color.parseColor("#ff5078f0"))
    {
      paramagdh.d.setTextColor(j);
      paramagdh.d.setLinkTextColor(i);
      return true;
      j = Color.parseColor("#FFFFFFFF");
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public aeqh a(View paramView)
  {
    if (a(paramView)) {
      return this;
    }
    return null;
  }
  
  public aeqi a()
  {
    return new agdh();
  }
  
  public SpannableString a(CharSequence paramCharSequence, long paramLong)
  {
    String str1 = banh.g(paramCharSequence.toString());
    if (TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont msg is empty");
      }
      return null;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = anmj.a(null, str1);
    String[] arrayOfString = ((anml)localObject).jdField_a_of_type_ArrayOfJavaLangString;
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "generateMagicFont word segment cost " + (l2 - l1) + "ms; msg length = " + paramCharSequence.length());
    }
    if (!((anml)localObject).jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont so not init");
      }
      return null;
    }
    if (arrayOfString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ChatItemBuilder", 2, "generateMagicFont words = null");
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "generateMagicFont words count = " + arrayOfString.length);
    }
    int i = 0;
    localObject = new ArrayList();
    int j = 0;
    int k;
    if (j < arrayOfString.length)
    {
      while ((i < str1.length()) && (str1.charAt(i) == ' ')) {
        i += 1;
      }
      String str2 = arrayOfString[j];
      k = 0;
      for (;;)
      {
        if ((k >= str2.length()) || (str2.charAt(k) < '一') || (str2.charAt(k) > 40891))
        {
          if (k == str2.length()) {
            ((ArrayList)localObject).add(new Pair(Integer.valueOf(i), Integer.valueOf(str2.length() + i)));
          }
          i += str2.length();
          j += 1;
          break;
        }
        k += 1;
      }
    }
    if (((ArrayList)localObject).size() < 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont words count = 0");
      }
      return null;
    }
    float f1 = 1.5F;
    if (alsf.a() == 18.0F) {
      f1 = 1.3F;
    }
    i = (int)(((ArrayList)localObject).size() * 0.3F + 0.5D);
    j = (int)(((ArrayList)localObject).size() * 0.3F + 0.5D);
    float f2;
    boolean bool1;
    int i1;
    if (fx.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f2 = fx.jdField_c_of_type_Float;
      f1 = fx.d;
      if (alsf.a() == 18.0F)
      {
        f2 = fx.e;
        f1 = fx.jdField_f_of_type_Float;
      }
      bool1 = fx.jdField_f_of_type_Boolean;
      i = (int)(((ArrayList)localObject).size() * fx.jdField_a_of_type_Float + 0.5D);
      j = (int)(((ArrayList)localObject).size() * fx.jdField_b_of_type_Float + 0.5D);
      i1 = fx.jdField_b_of_type_Int;
    }
    for (;;)
    {
      paramCharSequence = new SpannableString(paramCharSequence);
      if (((ArrayList)localObject).size() != 1) {
        break label1076;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont oneWord");
      }
      if ((bool1) && (((Integer)((Pair)((ArrayList)localObject).get(0)).second).intValue() - ((Integer)((Pair)((ArrayList)localObject).get(0)).first).intValue() > 1)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont oneWord switch = " + bool1 + " length = " + (((Integer)((Pair)((ArrayList)localObject).get(0)).second).intValue() - ((Integer)((Pair)((ArrayList)localObject).get(0)).first).intValue()));
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont config not init");
      }
      i1 = 4;
      f2 = f1;
      bool1 = true;
      f1 = 0.7F;
    }
    if (((Integer)((Pair)((ArrayList)localObject).get(0)).second).intValue() - ((Integer)((Pair)((ArrayList)localObject).get(0)).first).intValue() == 2) {}
    label1191:
    for (i = 1;; i = 2)
    {
      int m = 0;
      k = 0;
      int n = i;
      if (k < ((Integer)((Pair)((ArrayList)localObject).get(0)).second).intValue() - ((Integer)((Pair)((ArrayList)localObject).get(0)).first).intValue())
      {
        i = m;
        j = n;
        if (paramLong % (((Integer)((Pair)((ArrayList)localObject).get(0)).second).intValue() - ((Integer)((Pair)((ArrayList)localObject).get(0)).first).intValue() - k) < n) {
          if (m % 2 != 1) {
            break label1523;
          }
        }
      }
      label1076:
      label1508:
      label1523:
      for (float f3 = f1;; f3 = f2)
      {
        paramCharSequence.setSpan(new RelativeSizeSpan(f3), ((Integer)((Pair)((ArrayList)localObject).get(0)).first).intValue() + k, ((Integer)((Pair)((ArrayList)localObject).get(0)).first).intValue() + k + 1, 33);
        n -= 1;
        m += 1;
        i = m;
        j = n;
        if (QLog.isColorLevel())
        {
          QLog.d("ChatItemBuilder", 2, "generateMagicFont oneWord change index = " + ((Pair)((ArrayList)localObject).get(0)).first + k + " changeSize = " + f3);
          j = n;
          i = m;
        }
        paramLong = (25214903917L * paramLong + 11L & 0xFFFFFFFF) >> 16;
        k += 1;
        m = i;
        n = j;
        break;
        int i2 = 0;
        k = j;
        m = 0;
        n = 0;
        j = i;
        i = k;
        k = n;
        if (i2 < ((ArrayList)localObject).size())
        {
          boolean bool2 = false;
          bool1 = bool2;
          if (i1 > 0)
          {
            bool1 = bool2;
            if (i2 % i1 == i1 - 1)
            {
              bool1 = bool2;
              if (m == 0) {
                bool1 = true;
              }
            }
          }
          if ((paramLong % (((ArrayList)localObject).size() - i2) >= j + i) && (!bool1)) {
            break label1508;
          }
          if ((j <= 0) && (i > 0))
          {
            f3 = f1;
            m = j;
            if (f3 == f2) {
              m = j - 1;
            }
            j = i;
            if (f3 == f1) {
              j = i - 1;
            }
            paramCharSequence.setSpan(new RelativeSizeSpan(f3), ((Integer)((Pair)((ArrayList)localObject).get(i2)).first).intValue(), ((Integer)((Pair)((ArrayList)localObject).get(i2)).second).intValue(), 33);
            if (QLog.isColorLevel()) {
              QLog.d("ChatItemBuilder", 2, "generateMagicFont word change: " + ((Pair)((ArrayList)localObject).get(i2)).first + " , " + ((Pair)((ArrayList)localObject).get(i2)).second + " size = " + f3 + " index = " + i2 + " forceChange = " + bool1);
            }
            n = 1;
            i = m;
            k += 1;
            m = n;
          }
        }
        for (;;)
        {
          n = m;
          if (i1 > 0)
          {
            n = m;
            if (i2 % i1 == i1 - 1) {
              n = 0;
            }
          }
          paramLong = (25214903917L * paramLong + 11L & 0xFFFFFFFF) >> 16;
          i2 += 1;
          m = n;
          n = i;
          i = j;
          j = n;
          break;
          if ((i <= 0) && (j > 0))
          {
            f3 = f2;
            break label1191;
          }
          if (k % 2 == 1)
          {
            f3 = f1;
            break label1191;
            return paramCharSequence;
          }
          f3 = f2;
          break label1191;
          n = j;
          j = i;
          i = n;
        }
      }
    }
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    agdh localagdh;
    Object localObject1;
    label159:
    Object localObject2;
    Object localObject3;
    if ((paramaeqi instanceof agdh))
    {
      localagdh = (agdh)paramaeqi;
      if (paramView != null) {
        break label1642;
      }
      paramView = new ImageView(localContext);
      paramView.setId(2131366588);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131364173);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131363112);
      paramView.setContentDescription(alud.a(2131715252));
      paramBaseChatItemLayout.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localObject1 = new ETTextView(localContext);
      banh.a((TextView)localObject1);
      ((ETTextView)localObject1).setTextColor(localContext.getResources().getColorStateList(2131166921));
      ((ETTextView)localObject1).setLinkTextColor(localContext.getResources().getColorStateList(2131166915));
      if (!AppSetting.c) {
        break label1147;
      }
      ((ETTextView)localObject1).setAutoLinkMask(3);
      ((ETTextView)localObject1).setSpannableFactory(bamp.a);
      ((ETTextView)localObject1).setMaxWidth(BaseChatItemLayout.d);
      ((ETTextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
      ((ETTextView)localObject1).setTextAnimationListener(this.jdField_a_of_type_Fu);
      ((ETTextView)localObject1).setId(2131364176);
      localObject2 = new ImageView(localContext);
      ((ImageView)localObject2).setId(2131366589);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131364173);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15, 2131363112);
      ((ImageView)localObject2).setContentDescription(alud.a(2131715254));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = 10;
      paramBaseChatItemLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      ((ImageView)localObject2).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localagdh.d = ((TextView)localObject1);
      localagdh.b = paramView;
      localagdh.c = ((ImageView)localObject2);
      localagdh.jdField_a_of_type_Ajxp = new ajxp();
      localagdh.jdField_a_of_type_Ajxp.a((ajyb)localObject1);
      localagdh.jdField_a_of_type_Ajxp.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
    }
    for (;;)
    {
      ((ETTextView)localagdh.d).setFont(0, paramChatMessage.uniseq);
      localagdh.d.setTypeface(null);
      ((ETTextView)localagdh.d).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      ((ETTextView)localagdh.d).setStrokeColor(false, 0);
      ((ETTextView)localagdh.d).mMagicFont = false;
      ((ETTextView)localagdh.d).setCacheMeasureResult(true);
      localagdh.d.setTypeface(gj.a(paramChatMessage));
      if (!TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))
      {
        paramView = ((ETTextView)localagdh.d).getETLayout();
        if (paramView != null) {
          paramView.jdField_a_of_type_Long = (paramChatMessage.uniseq + 1L);
        }
      }
      localagdh.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      localagdh.d.setGravity(16);
      int j = BaseChatItemLayout.n;
      int i = BaseChatItemLayout.o;
      if (paramChatMessage.isSend())
      {
        j = BaseChatItemLayout.o;
        i = BaseChatItemLayout.n;
      }
      localagdh.d.setPadding(j, BaseChatItemLayout.l, i, BaseChatItemLayout.m);
      localagdh.jdField_a_of_type_Long = paramChatMessage.uniseq;
      paramView = "";
      if ((paramChatMessage instanceof MessageForText))
      {
        paramView = (MessageForText)paramChatMessage;
        if (paramChatMessage.msgtype == -2008) {
          if (paramChatMessage.isSend())
          {
            localagdh.d.setText(localContext.getString(2131719637));
            paramView = "";
          }
        }
      }
      for (;;)
      {
        localObject2 = (bcpg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
        if (bcpg.b(paramChatMessage)) {
          bcpg.a(localagdh.d, paramChatMessage);
        }
        localObject3 = bdzy.a();
        if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) && (!paramChatMessage.isread))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AioVipKeywordHelper", 4, "detectKeyword in TextItemBuilder.getBubbleView()");
          }
          ((bdzy)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramView, localContext, paramChatMessage.isSend());
        }
        localagdh.d.setOnTouchListener(paramaetk);
        localagdh.d.setOnLongClickListener(paramaetk);
        localagdh.jdField_a_of_type_Aetk = paramaetk;
        localagdh.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if ((localagdh.d instanceof AnimationTextView))
        {
          paramView = (AnimationTextView)localagdh.d;
          ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramView, paramaeqi.jdField_b_of_type_Int, paramaeqi.c, false);
          paramView.onDoubleClick = this.jdField_a_of_type_Bemz;
          paramView.onSingleClick = new agdd(this, paramChatMessage.isSend());
        }
        if (localagdh.c != null) {
          localagdh.c.setVisibility(8);
        }
        if (localagdh.b != null) {
          localagdh.b.setVisibility(8);
        }
        paramaeqi = (TextView)paramBaseChatItemLayout.findViewById(2131364204);
        if ((!paramChatMessage.mNeedTimeStamp) || (paramChatMessage.time <= 0L) || (paramaeqi == null) || (paramChatMessage.time == ((Long)paramaeqi.getTag()).longValue())) {
          break label1518;
        }
        if (localagdh.b != null) {
          localagdh.b.setPadding(0, aepi.a(70.0F, localContext.getResources()), 0, 0);
        }
        if (localagdh.c != null) {
          localagdh.c.setPadding(0, aepi.a(80.0F, localContext.getResources()), 0, 0);
        }
        label969:
        if (((paramChatMessage.extraflag != 32768) || (!paramChatMessage.isSendFromLocal())) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramChatMessage))) {
          break label1581;
        }
        i = 1;
        label1003:
        if ((paramChatMessage.isFlowMessage) && (i == 0) && (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)))
        {
          if (!paramChatMessage.isSend()) {
            break label1587;
          }
          if (localagdh.b != null)
          {
            localagdh.b.setImageResource(2130846655);
            localagdh.b.setVisibility(0);
          }
        }
        label1060:
        if (localagdh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null)
        {
          if (!((bcpg)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
            break label1618;
          }
          localagdh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        }
        label1099:
        if (localagdh.jdField_a_of_type_Ajxp != null) {
          localagdh.jdField_a_of_type_Ajxp.b(paramChatMessage);
        }
        return localObject1;
        localagdh = (agdh)a();
        localagdh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
        paramBaseChatItemLayout.setTag(localagdh);
        paramView = null;
        break;
        label1147:
        ((ETTextView)localObject1).setAutoLinkMask(0);
        break label159;
        localagdh.d.setText(localContext.getString(2131719636));
        paramView = "";
        continue;
        a(localagdh, paramChatMessage);
        if (!TextUtils.isEmpty(paramView.sb))
        {
          if (!TextUtils.isEmpty(paramView.sb2))
          {
            localagdh.d.setText(paramView.sb2);
            label1218:
            super.a(localagdh.d, paramChatMessage);
            if (AppSetting.c)
            {
              localObject2 = banh.e(paramChatMessage.msg);
              localObject3 = Spannable.Factory.getInstance().newSpannable((CharSequence)localObject2);
              if (!Linkify.addLinks((Spannable)localObject3, 15)) {
                break label1301;
              }
              localagdh.d.setContentDescription((CharSequence)localObject3);
            }
          }
          for (;;)
          {
            paramView = paramView.sb.toString();
            break;
            localagdh.d.setText(paramView.sb);
            break label1218;
            label1301:
            localagdh.d.setContentDescription((CharSequence)localObject2);
          }
        }
        localagdh.d.setText("");
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "textitem text.sb is null" + paramChatMessage.msgtype);
        }
        paramView = "";
        continue;
        if (!(paramChatMessage instanceof MessageForHiBoom)) {
          break label1417;
        }
        localObject2 = (MessageForHiBoom)paramChatMessage;
        if (((MessageForHiBoom)localObject2).mHiBoomMessage != null)
        {
          localagdh.d.setText(((MessageForHiBoom)localObject2).mHiBoomMessage.text);
          paramView = ((MessageForHiBoom)localObject2).mHiBoomMessage.text;
        }
      }
      label1417:
      if ((paramChatMessage instanceof MessageForPoke))
      {
        localObject2 = (MessageForPoke)paramChatMessage;
        paramView = alud.a(2131715253);
        if (((MessageForPoke)localObject2).name == null) {
          break label1639;
        }
        paramView = "[" + ((MessageForPoke)localObject2).name + "]请用最新版手机QQ查看。";
      }
      label1581:
      label1587:
      label1618:
      label1639:
      for (;;)
      {
        localagdh.d.setText(paramView);
        break;
        localagdh.d.setText(paramChatMessage.msg);
        super.a(localagdh.d, paramChatMessage);
        paramView = paramChatMessage.msg;
        break;
        label1518:
        if (localagdh.b != null) {
          localagdh.b.setPadding(0, aepi.a(30.0F, localContext.getResources()), 0, 0);
        }
        if (localagdh.c == null) {
          break label969;
        }
        localagdh.c.setPadding(0, aepi.a(30.0F, localContext.getResources()), 0, 0);
        break label969;
        i = 0;
        break label1003;
        if (localagdh.c == null) {
          break label1060;
        }
        localagdh.c.setImageResource(2130846655);
        localagdh.c.setVisibility(0);
        break label1060;
        localagdh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        break label1099;
      }
      label1642:
      localObject1 = paramView;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (((paramChatMessage instanceof MessageForText)) || ((paramChatMessage instanceof MessageForReplyText))) {
      return alud.a(2131715251) + banh.e(paramChatMessage.msg);
    }
    return alud.a(2131715249) + paramChatMessage.msg;
  }
  
  public void a()
  {
    super.a();
    ETEngine.getInstance().onAIODestroy();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "";
      }
    }
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131365071: 
    case 2131364912: 
      do
      {
        return;
        localObject1 = "";
        break;
        acjm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "1", "", "", "");
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 6, 0, "", "", "", "");
        return;
      } while (paramChatMessage.msg == null);
      afcq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 2);
      if (paramChatMessage.isMultiMsg)
      {
        aupn.a("0X8009AB7");
        paramInt = 1;
        if ((paramChatMessage instanceof MessageForLongTextMsg)) {
          paramInt = 2;
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D65", "0X8009D65", paramInt, 0, "" + paramInt, "", "", "");
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644A", "0X800644A", 0, 0, "1", "", "", "");
    }
    label515:
    label904:
    label1294:
    for (;;)
    {
      try
      {
        if (!ajxm.a().c()) {
          break label515;
        }
        paramContext = ajxm.a().a();
        if (paramContext == null) {
          break label510;
        }
        if (paramContext.length() != ajxm.a().a()) {
          break label505;
        }
        paramInt = 1;
      }
      catch (Exception paramContext) {}
      if (paramInt != 0)
      {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramContext);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ChatItemBuilder", 2, "Copy message, msg=" + paramContext);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("ChatItemBuilder", 2, paramContext.toString());
        return;
        label505:
        paramInt = 0;
        break label1294;
        label510:
        paramInt = 0;
        continue;
        paramContext = paramChatMessage.msg;
        paramInt = 1;
        continue;
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
      acjm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage.msg, paramChatMessage.uniseq);
      return;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("forward_type", -1);
      if (!(paramChatMessage instanceof MessageForText)) {
        break;
      }
      afcq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 3);
      paramContext = (MessageForText)paramChatMessage;
      if (ajxm.a().c())
      {
        paramContext = ajxm.a().a();
        if (paramContext != null) {
          if (paramContext.length() == ajxm.a().a())
          {
            paramInt = 1;
            label672:
            ((Bundle)localObject2).putString("forward_text", paramContext);
            ((Bundle)localObject2).putInt("selection_mode", this.jdField_b_of_type_Int);
            ((Bundle)localObject2).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            paramContext = new Intent();
            paramContext.putExtras((Bundle)localObject2);
            paramContext.putExtra("direct_send_if_dataline_forward", true);
            aryv.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "1", "", "", "");
            if (paramInt == 0) {
              break label904;
            }
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
          }
        }
      }
      while (paramChatMessage.isMultiMsg)
      {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 1, 0, "1", "", "", "");
        return;
        paramInt = 0;
        break label672;
        paramInt = 0;
        break label672;
        if (paramContext.sb != null) {}
        for (paramContext = paramContext.sb.toString();; paramContext = paramContext.msg)
        {
          paramInt = 1;
          break;
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
      azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_about_translate", 0, 1, 0);
      paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if ((paramChatMessage != null) && (paramChatMessage.length() > 0)) {
        paramContext.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      paramContext.putExtra("url", "http://183.62.127.31/MobileQQ/translate.html");
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramContext);
      return;
      a(paramChatMessage, (String)localObject1);
      afcq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 4);
      bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramChatMessage.istroop);
      if (!paramChatMessage.isMultiMsg) {
        break;
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 1, 0, "1", "", "", "");
      return;
      super.d(paramChatMessage);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 7, 0, "", "", "", "");
      return;
      super.a(paramChatMessage);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 5, 0, "", "", "", "");
      return;
      ajxm.a().a(paramChatMessage);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAC", "0X8009AAC", 2, 0, "", "", "", "");
      return;
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 3, 0, "", "", "", "");
      b(paramChatMessage);
      return;
    }
  }
  
  public void a(aeqi paramaeqi, View paramView, ChatMessage paramChatMessage, anwo paramanwo)
  {
    Object localObject;
    if ((paramChatMessage instanceof MessageForLongTextMsg))
    {
      localObject = (MessageForLongTextMsg)paramChatMessage;
      if ((!((MessageForLongTextMsg)localObject).getExtInfoFromExtStr("long_text_recv_state").equals("2")) && (!((MessageForLongTextMsg)localObject).getExtInfoFromExtStr("long_text_recv_state").equals("3"))) {}
    }
    label47:
    label192:
    label200:
    label246:
    do
    {
      do
      {
        break label47;
        break label47;
        do
        {
          return;
        } while (!(paramaeqi instanceof agdh));
        localObject = (agdh)paramaeqi;
      } while (a(paramChatMessage, (agdh)localObject));
      boolean bool = azmk.b();
      if ((paramanwo.jdField_a_of_type_Int == 0) || (!paramanwo.a()) || (bool))
      {
        paramView = paramView.getResources();
        int i;
        if (paramChatMessage.isSend())
        {
          paramaeqi = paramView.getColorStateList(2131166925);
          ((agdh)localObject).d.setTextColor(paramaeqi);
          if (atlt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
          {
            if (!paramChatMessage.isSend()) {
              break label192;
            }
            i = -1;
            ((agdh)localObject).d.setTextColor(i);
          }
          if (!paramChatMessage.isSend()) {
            break label200;
          }
        }
        for (paramaeqi = paramView.getColorStateList(2131166924);; paramaeqi = paramView.getColorStateList(2131166923))
        {
          ((agdh)localObject).d.setLinkTextColor(paramaeqi);
          return;
          paramaeqi = paramView.getColorStateList(2131166921);
          break;
          i = -16777216;
          break label146;
        }
      }
      ColorStateList.valueOf(paramanwo.jdField_b_of_type_Int);
      if (paramanwo.jdField_b_of_type_Int == 0)
      {
        ((agdh)localObject).d.setTextColor(-16777216);
        ColorStateList.valueOf(-16777216);
        if (paramanwo.c != 0) {
          break label385;
        }
      }
      for (paramaeqi = paramView.getResources().getColorStateList(2131166923);; paramaeqi = ColorStateList.valueOf(paramanwo.c))
      {
        ((agdh)localObject).d.setLinkTextColor(paramaeqi);
        if (!(((agdh)localObject).d instanceof ETTextView)) {
          break;
        }
        if (!paramanwo.jdField_a_of_type_Boolean) {
          break label397;
        }
        ((ETTextView)((agdh)localObject).d).setShadowLayer(3.0F, 0.0F, 0.0F, paramanwo.d);
        ((ETTextView)((agdh)localObject).d).setStrokeColor(true, paramanwo.d);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramanwo.d);
        return;
        ((agdh)localObject).d.setTextColor(paramanwo.jdField_b_of_type_Int);
        break label246;
      }
    } while ((!paramanwo.jdField_b_of_type_Boolean) || (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((agdh)localObject).d.getCurrentTextColor(), 10000.0D * ((agdh)localObject).jdField_a_of_type_Anwo.jdField_a_of_type_Double) != 1));
    label146:
    paramaeqi = (ETTextView)((agdh)localObject).d;
    label385:
    label397:
    float f2 = paramaeqi.getTextSize() * 3.0F / 16.0F;
    float f1 = f2;
    if (f2 > 25.0F) {
      f1 = 25.0F;
    }
    paramaeqi.setTextColor(-1);
    ColorStateList.valueOf(-1);
    paramaeqi.setShadowLayer(f1, 0.0F, 0.0F, paramanwo.d);
  }
  
  public void a(aeqi paramaeqi, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((aepi.g) || (!(paramaeqi instanceof agdh)));
        paramaeqi = (agdh)paramaeqi;
        if (((paramChatMessage.istroop == 3000) || (paramChatMessage.istroop == 1)) && ((!paramChatMessage.isShowQIMStyleGroup) && (!atlt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.h)) && (!azmk.b()))) {
          break;
        }
        localObject1 = new ETFont(0, null, 0.0F);
      } while (!(paramaeqi.d instanceof ETTextView));
      ((ETTextView)paramaeqi.d).setFont((ETFont)localObject1, paramChatMessage.uniseq);
      return;
    } while (!(paramaeqi.d instanceof ETTextView));
    fx localfx = (fx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
    Object localObject1 = localfx.b(paramChatMessage);
    ETTextView localETTextView = (ETTextView)paramaeqi.d;
    localETTextView.setMinWidth(aepi.a(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    if ((!(paramChatMessage instanceof MessageForReplyText)) || (!(paramaeqi instanceof afzr))) {
      localETTextView.setMinHeight(aepi.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    String str = fx.a(paramChatMessage);
    if ((localObject1 != null) && (((fw)localObject1).jdField_b_of_type_Int == 1)) {
      localETTextView.isParsingMagicFont = false;
    }
    label293:
    long l1;
    long l2;
    if ((fx.a(paramChatMessage)) && ((paramChatMessage instanceof MessageForText)))
    {
      ??? = (MessageForText)paramChatMessage;
      paramaeqi = null;
      if (!TextUtils.isEmpty(((MessageForText)???).sb))
      {
        if (TextUtils.isEmpty(((MessageForText)???).sb2)) {
          break label705;
        }
        paramaeqi = ((MessageForText)???).sb2;
      }
      if ((paramaeqi != null) && (banh.a(paramaeqi)))
      {
        l1 = ((MessageForText)paramChatMessage).msgUid;
        l2 = ((MessageForText)paramChatMessage).uniseq;
      }
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
      {
        if (jdField_a_of_type_ComTencentUtilLRULinkedHashMap.containsKey(Long.valueOf(l2)))
        {
          paramaeqi = (SpannableString)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(Long.valueOf(l2));
          if (paramaeqi != null)
          {
            localETTextView.setText(paramaeqi);
            localETTextView.mMagicFont = true;
          }
          if ((localObject1 == null) || (((fw)localObject1).jdField_a_of_type_Int == 0)) {
            break label991;
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(str)) {
            break label762;
          }
          if (fx.jdField_a_of_type_Long == 0L) {
            fx.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("personal_font_last_send_report", 1L);
          }
          if ((fx.jdField_a_of_type_Long < fx.jdField_c_of_type_Long) && (paramChatMessage.time * 1000L > fx.jdField_c_of_type_Long))
          {
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X8007B2B", 0, 0, "" + (((fw)localObject1).jdField_b_of_type_Int - 1), "" + ((fw)localObject1).jdField_a_of_type_Int, "", "");
            fx.jdField_a_of_type_Long = paramChatMessage.time * 1000L;
            paramaeqi = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
            paramaeqi.putLong("personal_font_last_send_report", paramChatMessage.time * 1000L);
            paramaeqi.commit();
          }
          if (((fw)localObject1).jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
            break label946;
          }
          paramaeqi = ((fw)localObject1).jdField_a_of_type_ComEtrumpMixlayoutETFont;
          paramaeqi.setSize(localETTextView.getTextSize());
          if (!TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("font_animation_played"))) {
            break label982;
          }
          localETTextView.shouldStartAnimation = true;
          localETTextView.setFont(paramaeqi, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("VasFont", 2, "updateTextFont  fontId = " + ((fw)localObject1).jdField_a_of_type_Int + "fontType = " + ((fw)localObject1).jdField_b_of_type_Int + "typeface = " + ((fw)localObject1).jdField_a_of_type_AndroidGraphicsTypeface);
          return;
          label705:
          paramaeqi = ((MessageForText)???).sb;
          break label293;
        }
        if ((localObject1 != null) && (((fw)localObject1).jdField_b_of_type_Int == 1)) {
          localETTextView.isParsingMagicFont = true;
        }
        ArkRecommendLogic.a().post(new TextItemBuilder.6(this, paramaeqi, l1, l2));
      }
      label762:
      if (fx.jdField_b_of_type_Long == 0L) {
        fx.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("personal_font_last_receive_report", 1L);
      }
      if ((fx.jdField_b_of_type_Long < fx.jdField_c_of_type_Long) && (paramChatMessage.time * 1000L > fx.jdField_c_of_type_Long))
      {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X8007B2C", 0, 0, "" + (((fw)localObject1).jdField_b_of_type_Int - 1), "" + ((fw)localObject1).jdField_a_of_type_Int, "", "");
        fx.jdField_b_of_type_Long = paramChatMessage.time * 1000L;
        paramaeqi = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
        paramaeqi.putLong("personal_font_last_receive_report", paramChatMessage.time * 1000L);
        paramaeqi.commit();
        continue;
        label946:
        paramaeqi = new ETFont(((fw)localObject1).jdField_a_of_type_Int, ((fw)localObject1).jdField_a_of_type_JavaLangString, localETTextView.getTextSize(), ((fw)localObject1).jdField_b_of_type_Int, ((fw)localObject1).jdField_a_of_type_AndroidGraphicsTypeface);
        continue;
        label982:
        localETTextView.shouldStartAnimation = false;
      }
    }
    label991:
    if (gj.jdField_a_of_type_Int == 4) {
      if (localfx.a(9999))
      {
        localETTextView.setDefaultFont(gj.a(paramChatMessage), paramChatMessage.uniseq);
        label1022:
        if (!QLog.isColorLevel()) {
          break label1092;
        }
        paramChatMessage = new StringBuilder().append("updateTextFont fontinfo = ");
        if (localObject1 != null) {
          break label1094;
        }
      }
    }
    label1092:
    label1094:
    for (paramaeqi = "null";; paramaeqi = ((fw)localObject1).toString())
    {
      QLog.d("VasFont", 2, paramaeqi);
      return;
      gj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break label1022;
      localETTextView.setDefaultFont(gj.a(paramChatMessage), paramChatMessage.uniseq);
      break label1022;
      break;
    }
  }
  
  void a(agdh paramagdh, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {}
    fx localfx;
    do
    {
      do
      {
        return;
      } while ((azmk.b()) || ((1 == paramChatMessage.istroop) && (nav.a(paramChatMessage))));
      localfx = (fx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
      localfx.b(paramChatMessage);
    } while (!localfx.b(paramChatMessage));
    localfx.a(paramChatMessage);
    localfx.a(paramagdh.d);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (aepi.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForText)aepi.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131690042);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131690043);
    } while (!paramView.isSendFromLocal());
    bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new agde(this, paramView), new agdf(this)).show();
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return;
      paramView = paramView.getBackground();
    } while (paramView == null);
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(f, c, e, d);
      return;
    }
    paramView.setPadding(e, c, f, d);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    super.a(paramView, paramChatMessage, paramInt);
    if (paramInt == 1)
    {
      aeqi localaeqi = (aeqi)paramView.getTag();
      if (localaeqi != null) {
        a(localaeqi, paramView, paramChatMessage, localaeqi.jdField_a_of_type_Anwo);
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Drawable localDrawable = paramView.getBackground();
    if (localDrawable != null) {
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (paramView = null;; paramView = jdField_a_of_type_AndroidGraphicsColorFilter)
    {
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
      return;
    }
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aeqi paramaeqi, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaeqi, paramInt1, paramInt2);
  }
  
  protected void a(ChatMessage paramChatMessage, String paramString)
  {
    ajxm localajxm = ajxm.a();
    int i;
    if (localajxm.c())
    {
      localObject = localajxm.a();
      if (localObject != null) {
        if (((String)localObject).length() == localajxm.a())
        {
          i = 1;
          localajxm.d();
        }
      }
    }
    for (;;)
    {
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, (String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label94;
      }
      return;
      i = 0;
      break;
      i = 0;
      break;
      localObject = paramChatMessage.msg;
      i = 1;
    }
    label94:
    Object localObject = new StringBuilder((String)localObject);
    int j = 0;
    while (j < ((StringBuilder)localObject).length())
    {
      if ((((StringBuilder)localObject).codePointAt(j) == 20) && (j < ((StringBuilder)localObject).length() - 1) && (((StringBuilder)localObject).charAt(j + 1) == 'ÿ'))
      {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800588D", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "report save small emoticon amount");
        }
        bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 13, 0, paramChatMessage.istroop);
        return;
      }
      j += 1;
    }
    if (i == 0)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 4, 0, "", "", "", "");
      return;
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAC", 4, 0, "", "", "", "");
  }
  
  public boolean a(aeqi paramaeqi)
  {
    return paramaeqi instanceof agdh;
  }
  
  public bdpk[] a(View paramView)
  {
    paramView = aepi.a(paramView);
    localbdpi = new bdpi();
    if ((paramView != null) && (paramView.istroop == 10007))
    {
      localbdpi.a(2131364912, this.jdField_a_of_type_AndroidContentContext.getString(2131691357), 2130838669);
      return localbdpi.a();
    }
    if ((paramView != null) && (paramView.isMultiMsg))
    {
      localbdpi.a(2131364912, this.jdField_a_of_type_AndroidContentContext.getString(2131691357), 2130838669);
      localbdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
      localbdpi.a(2131366017, this.jdField_a_of_type_AndroidContentContext.getString(2131692401), 2130838677);
      return localbdpi.a();
    }
    if (aoiy.a(paramView)) {
      return localbdpi.a();
    }
    if (ApolloUtil.a(paramView)) {
      return localbdpi.a();
    }
    int i = 0;
    j = 0;
    if ((paramView instanceof MessageForText)) {
      if (TextUtils.isEmpty(((MessageForText)paramView).getExtInfoFromExtStr("sticker_info"))) {
        break label522;
      }
    }
    label522:
    for (i = 1;; i = 0)
    {
      String str = paramView.getExtInfoFromExtStr("key_message_extra_info_flag");
      j = 0;
      try
      {
        int k = Integer.parseInt(str);
        j = k;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("ChatItemBuilder", 1, localThrowable, new Object[0]);
          continue;
          j = 0;
          continue;
          acjm.a(localbdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
      }
      if ((j & 0x2) != 2) {
        break;
      }
      j = 1;
      if (j != 0) {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009B17", "0X8009B17", 0, 0, "", "", "", "");
      }
      if ((paramView instanceof MessageForPoke)) {
        i = 1;
      }
      if (i != 0) {
        break label550;
      }
      if (j == 0) {
        localbdpi.a(2131364912, alud.a(2131715250), 2130838669);
      }
      if ((paramView != null) && (paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
        localbdpi.a(2131375708, this.jdField_a_of_type_AndroidContentContext.getString(2131719152), 2130838683);
      }
      if (j == 0) {
        localbdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
      }
      a(paramView, localbdpi);
      if ((paramView != null) && (paramView.vipBubbleID == 100000L) && (!paramView.isSend())) {
        localbdpi.a(2131361809, this.jdField_a_of_type_AndroidContentContext.getString(2131717648), 2130838656);
      }
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbdpi, paramView);
      if (aepi.a(5) == 1) {
        localbdpi.a(2131366017, this.jdField_a_of_type_AndroidContentContext.getString(2131692401), 2130838677);
      }
      b(paramView, localbdpi);
      super.c(localbdpi, this.jdField_a_of_type_AndroidContentContext);
      super.e(localbdpi, this.jdField_a_of_type_AndroidContentContext);
      return localbdpi.a();
    }
  }
  
  public void b(aeqi paramaeqi, ChatMessage paramChatMessage)
  {
    int i = 0;
    super.b(paramaeqi, paramChatMessage);
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {
      break label15;
    }
    label15:
    agdh localagdh;
    label146:
    label152:
    for (;;)
    {
      return;
      if ((paramaeqi instanceof agdh))
      {
        localagdh = (agdh)paramaeqi;
        if (!(paramChatMessage instanceof MessageForText)) {
          break;
        }
        paramChatMessage = (MessageForText)paramChatMessage;
        paramaeqi = null;
        if (!TextUtils.isEmpty(paramChatMessage.sb)) {
          if (TextUtils.isEmpty(paramChatMessage.sb2)) {
            break label146;
          }
        }
        for (paramaeqi = paramChatMessage.sb2;; paramaeqi = paramChatMessage.sb)
        {
          if ((paramaeqi == null) || (!(paramaeqi instanceof bamp))) {
            break label152;
          }
          paramChatMessage = (bamp)paramaeqi;
          paramaeqi = (bamw[])paramChatMessage.getSpans(0, paramaeqi.length(), bamw.class);
          if ((paramaeqi.length <= 0) || (paramChatMessage.b().length() != 0)) {
            break;
          }
          int j = paramaeqi.length;
          while (i < j)
          {
            paramaeqi[i].a(azkz.a(26.0F));
            i += 1;
          }
        }
      }
    }
    localagdh.d.setText(paramChatMessage);
  }
  
  public void c(View paramView)
  {
    super.c(paramView);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
      {
        ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if ((localChatFragment != null) && (localChatFragment.a() != null) && (localChatFragment.a().a != null)) {
          a(paramMessage, localChatFragment.a().a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agda
 * JD-Core Version:    0.7.0.1
 */