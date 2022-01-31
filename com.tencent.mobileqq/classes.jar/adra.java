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

public class adra
  extends BaseBubbleBuilder
  implements acjt, Handler.Callback
{
  public static final LRULinkedHashMap<Long, SpannableString> a;
  private static String jdField_a_of_type_JavaLangString = "ArkApp.TextItemBuilder";
  public static final int c = BaseChatItemLayout.g + BaseChatItemLayout.l;
  protected static final int d = BaseChatItemLayout.h + BaseChatItemLayout.m;
  public static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  public static final int f = BaseChatItemLayout.j + BaseChatItemLayout.o;
  protected View.OnClickListener a;
  protected bbgb a;
  private fs jdField_a_of_type_Fs = new adrg(this);
  public Handler b;
  protected View.OnClickListener b;
  
  static
  {
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(50);
  }
  
  public adra(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adrb(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new adrc(this);
    this.jdField_a_of_type_Bbgb = new adri(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Activity paramActivity, ChatMessage paramChatMessage, String paramString)
  {
    paramChatMessage.msg = a(paramChatMessage.msg, true);
    paramString = a(paramString, true);
    bfhl.a(null, paramString).b(paramQQAppInterface, paramChatMessage).a(paramActivity, paramQQAppInterface.getAccount());
    bfhz.a(paramQQAppInterface, 6, 1);
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
    paramXListView = aciy.a(paramXListView, aciy.a(l, paramXListView.getAdapter()));
    if ((paramXListView != null) && ((paramXListView.getTag() instanceof adrh)))
    {
      paramXListView = (adrh)paramXListView.getTag();
      if (paramXListView.jdField_a_of_type_Long == l)
      {
        if ((paramMessage.obj instanceof SpannableString))
        {
          paramMessage = (SpannableString)paramMessage.obj;
          paramXListView.d.setText(paramMessage);
          ((ETTextView)paramXListView.d).jdField_a_of_type_Boolean = true;
          if ((paramXListView.d instanceof ETTextView))
          {
            ETTextView localETTextView = (ETTextView)paramXListView.d;
            if (localETTextView.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) {
              localETTextView.jdField_a_of_type_ComEtrumpMixlayoutETFont.mText = paramMessage;
            }
          }
        }
        if (((ETTextView)paramXListView.d).d()) {
          ((ETTextView)paramXListView.d).c = false;
        }
        paramXListView.d.requestLayout();
      }
    }
  }
  
  private boolean a(ChatMessage paramChatMessage, adrh paramadrh)
  {
    int i = 0;
    boolean bool2 = false;
    int j;
    boolean bool1;
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) && (paramChatMessage.isShowQIMStyleGroup))
    {
      i = Color.parseColor("#FFFFFFFF");
      j = Color.parseColor("#ff5078f0");
      paramadrh.d.setTextColor(i);
      paramadrh.d.setLinkTextColor(j);
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
    } while (!adzs.a().a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
    if (!paramChatMessage.isSend()) {
      i = 1;
    }
    if (i != 0) {
      j = Color.parseColor("#ff000000");
    }
    for (i = Color.parseColor("#ff80e9ff");; i = Color.parseColor("#ff5078f0"))
    {
      paramadrh.d.setTextColor(j);
      paramadrh.d.setLinkTextColor(i);
      return true;
      j = Color.parseColor("#FFFFFFFF");
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public acjt a(View paramView)
  {
    if (a(paramView)) {
      return this;
    }
    return null;
  }
  
  public acju a()
  {
    return new adrh();
  }
  
  public SpannableString a(CharSequence paramCharSequence, long paramLong)
  {
    String str1 = axku.g(paramCharSequence.toString());
    if (TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont msg is empty");
      }
      return null;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = alcv.a(null, str1);
    String[] arrayOfString = ((alcx)localObject).jdField_a_of_type_ArrayOfJavaLangString;
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "generateMagicFont word segment cost " + (l2 - l1) + "ms; msg length = " + paramCharSequence.length());
    }
    if (!((alcx)localObject).jdField_a_of_type_Boolean)
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
    if (ajia.a() == 18.0F) {
      f1 = 1.3F;
    }
    i = (int)(((ArrayList)localObject).size() * 0.3F + 0.5D);
    j = (int)(((ArrayList)localObject).size() * 0.3F + 0.5D);
    float f2;
    boolean bool1;
    int i1;
    if (fv.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f2 = fv.jdField_c_of_type_Float;
      f1 = fv.d;
      if (ajia.a() == 18.0F)
      {
        f2 = fv.e;
        f1 = fv.jdField_f_of_type_Float;
      }
      bool1 = fv.jdField_f_of_type_Boolean;
      i = (int)(((ArrayList)localObject).size() * fv.jdField_a_of_type_Float + 0.5D);
      j = (int)(((ArrayList)localObject).size() * fv.jdField_b_of_type_Float + 0.5D);
      i1 = fv.jdField_b_of_type_Int;
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
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    adrh localadrh;
    Object localObject1;
    label154:
    Object localObject2;
    Object localObject3;
    if ((paramacju instanceof adrh))
    {
      localadrh = (adrh)paramacju;
      if (paramView != null) {
        break label1637;
      }
      paramView = new ImageView(localContext);
      paramView.setId(2131300867);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131298552);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131297536);
      paramView.setContentDescription(ajjy.a(2131649068));
      paramBaseChatItemLayout.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localObject1 = new ETTextView(localContext);
      ((ETTextView)localObject1).setTextColor(localContext.getResources().getColorStateList(2131101278));
      ((ETTextView)localObject1).setLinkTextColor(localContext.getResources().getColorStateList(2131101272));
      if (!AppSetting.c) {
        break label1142;
      }
      ((ETTextView)localObject1).setAutoLinkMask(3);
      ((ETTextView)localObject1).setSpannableFactory(axkd.a);
      ((ETTextView)localObject1).setMaxWidth(BaseChatItemLayout.d);
      ((ETTextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
      ((ETTextView)localObject1).setTextAnimationListener(this.jdField_a_of_type_Fs);
      ((ETTextView)localObject1).setId(2131298555);
      localObject2 = new ImageView(localContext);
      ((ImageView)localObject2).setId(2131300868);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131298552);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15, 2131297536);
      ((ImageView)localObject2).setContentDescription(ajjy.a(2131649070));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = 10;
      paramBaseChatItemLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      ((ImageView)localObject2).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localadrh.d = ((TextView)localObject1);
      localadrh.b = paramView;
      localadrh.c = ((ImageView)localObject2);
      localadrh.jdField_a_of_type_Ahpa = new ahpa();
      localadrh.jdField_a_of_type_Ahpa.a((ahpm)localObject1);
      localadrh.jdField_a_of_type_Ahpa.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
    }
    for (;;)
    {
      ((ETTextView)localadrh.d).setFont(0, paramChatMessage.uniseq);
      localadrh.d.setTypeface(null);
      ((ETTextView)localadrh.d).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      ((ETTextView)localadrh.d).setStrokeColor(false, 0);
      ((ETTextView)localadrh.d).jdField_a_of_type_Boolean = false;
      ((ETTextView)localadrh.d).setCacheMeasureResult(true);
      localadrh.d.setTypeface(gh.a(paramChatMessage));
      if (!TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))
      {
        paramView = ((ETTextView)localadrh.d).a();
        if (paramView != null) {
          paramView.jdField_a_of_type_Long = (paramChatMessage.uniseq + 1L);
        }
      }
      localadrh.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      localadrh.d.setGravity(16);
      int j = BaseChatItemLayout.n;
      int i = BaseChatItemLayout.o;
      if (paramChatMessage.isSend())
      {
        j = BaseChatItemLayout.o;
        i = BaseChatItemLayout.n;
      }
      localadrh.d.setPadding(j, BaseChatItemLayout.l, i, BaseChatItemLayout.m);
      localadrh.jdField_a_of_type_Long = paramChatMessage.uniseq;
      paramView = "";
      if ((paramChatMessage instanceof MessageForText))
      {
        paramView = (MessageForText)paramChatMessage;
        if (paramChatMessage.msgtype == -2008) {
          if (paramChatMessage.isSend())
          {
            localadrh.d.setText(localContext.getString(2131653304));
            paramView = "";
          }
        }
      }
      for (;;)
      {
        localObject2 = (azks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
        if (azks.b(paramChatMessage)) {
          azks.a(localadrh.d, paramChatMessage);
        }
        localObject3 = batg.a();
        if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) && (!paramChatMessage.isread))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AioVipKeywordHelper", 4, "detectKeyword in TextItemBuilder.getBubbleView()");
          }
          ((batg)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramView, localContext, paramChatMessage.isSend());
        }
        localadrh.d.setOnTouchListener(paramacmv);
        localadrh.d.setOnLongClickListener(paramacmv);
        localadrh.jdField_a_of_type_Acmv = paramacmv;
        localadrh.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if ((localadrh.d instanceof AnimationTextView))
        {
          paramView = (AnimationTextView)localadrh.d;
          ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramView, paramacju.jdField_b_of_type_Int, paramacju.c, false);
          paramView.jdField_a_of_type_Bbgb = this.jdField_a_of_type_Bbgb;
          paramView.jdField_a_of_type_Bbgc = new adrd(this, paramChatMessage.isSend());
        }
        if (localadrh.c != null) {
          localadrh.c.setVisibility(8);
        }
        if (localadrh.b != null) {
          localadrh.b.setVisibility(8);
        }
        paramacju = (TextView)paramBaseChatItemLayout.findViewById(2131298583);
        if ((!paramChatMessage.mNeedTimeStamp) || (paramChatMessage.time <= 0L) || (paramacju == null) || (paramChatMessage.time == ((Long)paramacju.getTag()).longValue())) {
          break label1513;
        }
        if (localadrh.b != null) {
          localadrh.b.setPadding(0, aciy.a(70.0F, localContext.getResources()), 0, 0);
        }
        if (localadrh.c != null) {
          localadrh.c.setPadding(0, aciy.a(80.0F, localContext.getResources()), 0, 0);
        }
        label964:
        if (((paramChatMessage.extraflag != 32768) || (!paramChatMessage.isSendFromLocal())) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramChatMessage))) {
          break label1576;
        }
        i = 1;
        label998:
        if ((paramChatMessage.isFlowMessage) && (i == 0) && (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)))
        {
          if (!paramChatMessage.isSend()) {
            break label1582;
          }
          if (localadrh.b != null)
          {
            localadrh.b.setImageResource(2130846016);
            localadrh.b.setVisibility(0);
          }
        }
        label1055:
        if (localadrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null)
        {
          if (!((azks)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
            break label1613;
          }
          localadrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        }
        label1094:
        if (localadrh.jdField_a_of_type_Ahpa != null) {
          localadrh.jdField_a_of_type_Ahpa.b(paramChatMessage);
        }
        return localObject1;
        localadrh = (adrh)a();
        localadrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
        paramBaseChatItemLayout.setTag(localadrh);
        paramView = null;
        break;
        label1142:
        ((ETTextView)localObject1).setAutoLinkMask(0);
        break label154;
        localadrh.d.setText(localContext.getString(2131653303));
        paramView = "";
        continue;
        a(localadrh, paramChatMessage);
        if (!TextUtils.isEmpty(paramView.sb))
        {
          if (!TextUtils.isEmpty(paramView.sb2))
          {
            localadrh.d.setText(paramView.sb2);
            label1213:
            super.a(localadrh.d, paramChatMessage);
            if (AppSetting.c)
            {
              localObject2 = axku.e(paramChatMessage.msg);
              localObject3 = Spannable.Factory.getInstance().newSpannable((CharSequence)localObject2);
              if (!Linkify.addLinks((Spannable)localObject3, 15)) {
                break label1296;
              }
              localadrh.d.setContentDescription((CharSequence)localObject3);
            }
          }
          for (;;)
          {
            paramView = paramView.sb.toString();
            break;
            localadrh.d.setText(paramView.sb);
            break label1213;
            label1296:
            localadrh.d.setContentDescription((CharSequence)localObject2);
          }
        }
        localadrh.d.setText("");
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "textitem text.sb is null" + paramChatMessage.msgtype);
        }
        paramView = "";
        continue;
        if (!(paramChatMessage instanceof MessageForHiBoom)) {
          break label1412;
        }
        localObject2 = (MessageForHiBoom)paramChatMessage;
        if (((MessageForHiBoom)localObject2).mHiBoomMessage != null)
        {
          localadrh.d.setText(((MessageForHiBoom)localObject2).mHiBoomMessage.text);
          paramView = ((MessageForHiBoom)localObject2).mHiBoomMessage.text;
        }
      }
      label1412:
      if ((paramChatMessage instanceof MessageForPoke))
      {
        localObject2 = (MessageForPoke)paramChatMessage;
        paramView = ajjy.a(2131649069);
        if (((MessageForPoke)localObject2).name == null) {
          break label1634;
        }
        paramView = "[" + ((MessageForPoke)localObject2).name + "]请用最新版手机QQ查看。";
      }
      label1576:
      label1582:
      label1613:
      label1634:
      for (;;)
      {
        localadrh.d.setText(paramView);
        break;
        localadrh.d.setText(paramChatMessage.msg);
        super.a(localadrh.d, paramChatMessage);
        paramView = paramChatMessage.msg;
        break;
        label1513:
        if (localadrh.b != null) {
          localadrh.b.setPadding(0, aciy.a(30.0F, localContext.getResources()), 0, 0);
        }
        if (localadrh.c == null) {
          break label964;
        }
        localadrh.c.setPadding(0, aciy.a(30.0F, localContext.getResources()), 0, 0);
        break label964;
        i = 0;
        break label998;
        if (localadrh.c == null) {
          break label1055;
        }
        localadrh.c.setImageResource(2130846016);
        localadrh.c.setVisibility(0);
        break label1055;
        localadrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        break label1094;
      }
      label1637:
      localObject1 = paramView;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (((paramChatMessage instanceof MessageForText)) || ((paramChatMessage instanceof MessageForReplyText))) {
      return ajjy.a(2131649067) + axku.e(paramChatMessage.msg);
    }
    return ajjy.a(2131649065) + paramChatMessage.msg;
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
    case 2131299417: 
    case 2131299262: 
      do
      {
        return;
        localObject1 = "";
        break;
        aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "1", "", "", "");
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 6, 0, "", "", "", "");
        return;
      } while (paramChatMessage.msg == null);
      if (paramChatMessage.isMultiMsg)
      {
        aryb.a("0X8009AB7");
        paramInt = 1;
        if ((paramChatMessage instanceof MessageForLongTextMsg)) {
          paramInt = 2;
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D65", "0X8009D65", paramInt, 0, "" + paramInt, "", "", "");
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644A", "0X800644A", 0, 0, "1", "", "", "");
    }
    label646:
    label1242:
    for (;;)
    {
      try
      {
        if (!ahox.a().c()) {
          break label502;
        }
        paramContext = ahox.a().a();
        if (paramContext == null) {
          break label497;
        }
        if (paramContext.length() != ahox.a().a()) {
          break label492;
        }
        paramInt = 1;
      }
      catch (Exception paramContext) {}
      if (paramInt != 0)
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
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
        label492:
        paramInt = 0;
        break label1242;
        label497:
        paramInt = 0;
        continue;
        label502:
        paramContext = paramChatMessage.msg;
        paramInt = 1;
        continue;
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
      aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage.msg, paramChatMessage.uniseq);
      return;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("forward_type", -1);
      if (!(paramChatMessage instanceof MessageForText)) {
        break;
      }
      paramContext = (MessageForText)paramChatMessage;
      if (ahox.a().c())
      {
        paramContext = ahox.a().a();
        if (paramContext != null) {
          if (paramContext.length() == ahox.a().a())
          {
            paramInt = 1;
            ((Bundle)localObject2).putString("forward_text", paramContext);
            ((Bundle)localObject2).putInt("selection_mode", this.jdField_b_of_type_Int);
            ((Bundle)localObject2).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            paramContext = new Intent();
            paramContext.putExtras((Bundle)localObject2);
            paramContext.putExtra("direct_send_if_dataline_forward", true);
            aphp.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "1", "", "", "");
            if (paramInt == 0) {
              break label878;
            }
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
          }
        }
      }
      while (paramChatMessage.isMultiMsg)
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 1, 0, "1", "", "", "");
        return;
        paramInt = 0;
        break label646;
        paramInt = 0;
        break label646;
        if (paramContext.sb != null) {}
        for (paramContext = paramContext.sb.toString();; paramContext = paramContext.msg)
        {
          paramInt = 1;
          break;
        }
        label878:
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
      awrn.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_about_translate", 0, 1, 0);
      paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if ((paramChatMessage != null) && (paramChatMessage.length() > 0)) {
        paramContext.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      paramContext.putExtra("url", "http://183.62.127.31/MobileQQ/translate.html");
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramContext);
      return;
      a(paramChatMessage, (String)localObject1);
      if (!paramChatMessage.isMultiMsg) {
        break;
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 1, 0, "1", "", "", "");
      return;
      super.d(paramChatMessage);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 7, 0, "", "", "", "");
      return;
      super.a(paramChatMessage);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 5, 0, "", "", "", "");
      return;
      ahox.a().a(paramChatMessage);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAC", "0X8009AAC", 2, 0, "", "", "", "");
      return;
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 3, 0, "", "", "", "");
      b(paramChatMessage);
      return;
    }
  }
  
  public void a(acju paramacju, View paramView, ChatMessage paramChatMessage, almt paramalmt)
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
        } while (!(paramacju instanceof adrh));
        localObject = (adrh)paramacju;
      } while (a(paramChatMessage, (adrh)localObject));
      boolean bool = awnu.b();
      if ((paramalmt.jdField_a_of_type_Int == 0) || (!paramalmt.a()) || (bool))
      {
        paramView = paramView.getResources();
        int i;
        if (paramChatMessage.isSend())
        {
          paramacju = paramView.getColorStateList(2131101282);
          ((adrh)localObject).d.setTextColor(paramacju);
          if (aqux.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
          {
            if (!paramChatMessage.isSend()) {
              break label192;
            }
            i = -1;
            ((adrh)localObject).d.setTextColor(i);
          }
          if (!paramChatMessage.isSend()) {
            break label200;
          }
        }
        for (paramacju = paramView.getColorStateList(2131101281);; paramacju = paramView.getColorStateList(2131101280))
        {
          ((adrh)localObject).d.setLinkTextColor(paramacju);
          return;
          paramacju = paramView.getColorStateList(2131101278);
          break;
          i = -16777216;
          break label146;
        }
      }
      ColorStateList.valueOf(paramalmt.jdField_b_of_type_Int);
      if (paramalmt.jdField_b_of_type_Int == 0)
      {
        ((adrh)localObject).d.setTextColor(-16777216);
        ColorStateList.valueOf(-16777216);
        if (paramalmt.c != 0) {
          break label385;
        }
      }
      for (paramacju = paramView.getResources().getColorStateList(2131101280);; paramacju = ColorStateList.valueOf(paramalmt.c))
      {
        ((adrh)localObject).d.setLinkTextColor(paramacju);
        if (!(((adrh)localObject).d instanceof ETTextView)) {
          break;
        }
        if (!paramalmt.jdField_a_of_type_Boolean) {
          break label397;
        }
        ((ETTextView)((adrh)localObject).d).setShadowLayer(3.0F, 0.0F, 0.0F, paramalmt.d);
        ((ETTextView)((adrh)localObject).d).setStrokeColor(true, paramalmt.d);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramalmt.d);
        return;
        ((adrh)localObject).d.setTextColor(paramalmt.jdField_b_of_type_Int);
        break label246;
      }
    } while ((!paramalmt.jdField_b_of_type_Boolean) || (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((adrh)localObject).d.getCurrentTextColor(), 10000.0D * ((adrh)localObject).jdField_a_of_type_Almt.jdField_a_of_type_Double) != 1));
    label146:
    paramacju = (ETTextView)((adrh)localObject).d;
    label385:
    label397:
    float f2 = paramacju.getTextSize() * 3.0F / 16.0F;
    float f1 = f2;
    if (f2 > 25.0F) {
      f1 = 25.0F;
    }
    paramacju.setTextColor(-1);
    ColorStateList.valueOf(-1);
    paramacju.setShadowLayer(f1, 0.0F, 0.0F, paramalmt.d);
  }
  
  public void a(acju paramacju, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((aciy.g) || (!(paramacju instanceof adrh)));
        paramacju = (adrh)paramacju;
        if (((paramChatMessage.istroop == 3000) || (paramChatMessage.istroop == 1)) && ((!paramChatMessage.isShowQIMStyleGroup) && (!aqux.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.h)) && (!awnu.b()))) {
          break;
        }
        localObject1 = new ETFont(0, null, 0.0F);
      } while (!(paramacju.d instanceof ETTextView));
      ((ETTextView)paramacju.d).setFont((ETFont)localObject1, paramChatMessage.uniseq);
      return;
    } while (!(paramacju.d instanceof ETTextView));
    fv localfv = (fv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
    Object localObject1 = localfv.b(paramChatMessage);
    ETTextView localETTextView = (ETTextView)paramacju.d;
    localETTextView.setMinWidth(aciy.a(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    if ((!(paramChatMessage instanceof MessageForReplyText)) || (!(paramacju instanceof adnr))) {
      localETTextView.setMinHeight(aciy.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    String str = fv.a(paramChatMessage);
    if ((localObject1 != null) && (((fu)localObject1).jdField_b_of_type_Int == 1)) {
      localETTextView.c = false;
    }
    label293:
    long l1;
    long l2;
    if ((fv.a(paramChatMessage)) && ((paramChatMessage instanceof MessageForText)))
    {
      ??? = (MessageForText)paramChatMessage;
      paramacju = null;
      if (!TextUtils.isEmpty(((MessageForText)???).sb))
      {
        if (TextUtils.isEmpty(((MessageForText)???).sb2)) {
          break label705;
        }
        paramacju = ((MessageForText)???).sb2;
      }
      if ((paramacju != null) && (axku.a(paramacju)))
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
          paramacju = (SpannableString)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(Long.valueOf(l2));
          if (paramacju != null)
          {
            localETTextView.setText(paramacju);
            localETTextView.jdField_a_of_type_Boolean = true;
          }
          if ((localObject1 == null) || (((fu)localObject1).jdField_a_of_type_Int == 0)) {
            break label991;
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(str)) {
            break label762;
          }
          if (fv.jdField_a_of_type_Long == 0L) {
            fv.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("personal_font_last_send_report", 1L);
          }
          if ((fv.jdField_a_of_type_Long < fv.jdField_c_of_type_Long) && (paramChatMessage.time * 1000L > fv.jdField_c_of_type_Long))
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X8007B2B", 0, 0, "" + (((fu)localObject1).jdField_b_of_type_Int - 1), "" + ((fu)localObject1).jdField_a_of_type_Int, "", "");
            fv.jdField_a_of_type_Long = paramChatMessage.time * 1000L;
            paramacju = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
            paramacju.putLong("personal_font_last_send_report", paramChatMessage.time * 1000L);
            paramacju.commit();
          }
          if (((fu)localObject1).jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
            break label946;
          }
          paramacju = ((fu)localObject1).jdField_a_of_type_ComEtrumpMixlayoutETFont;
          paramacju.setSize(localETTextView.getTextSize());
          if (!TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("font_animation_played"))) {
            break label982;
          }
          localETTextView.d = true;
          localETTextView.setFont(paramacju, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("VasFont", 2, "updateTextFont  fontId = " + ((fu)localObject1).jdField_a_of_type_Int + "fontType = " + ((fu)localObject1).jdField_b_of_type_Int + "typeface = " + ((fu)localObject1).jdField_a_of_type_AndroidGraphicsTypeface);
          return;
          label705:
          paramacju = ((MessageForText)???).sb;
          break label293;
        }
        if ((localObject1 != null) && (((fu)localObject1).jdField_b_of_type_Int == 1)) {
          localETTextView.c = true;
        }
        ArkRecommendLogic.a().post(new TextItemBuilder.6(this, paramacju, l1, l2));
      }
      label762:
      if (fv.jdField_b_of_type_Long == 0L) {
        fv.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("personal_font_last_receive_report", 1L);
      }
      if ((fv.jdField_b_of_type_Long < fv.jdField_c_of_type_Long) && (paramChatMessage.time * 1000L > fv.jdField_c_of_type_Long))
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X8007B2C", 0, 0, "" + (((fu)localObject1).jdField_b_of_type_Int - 1), "" + ((fu)localObject1).jdField_a_of_type_Int, "", "");
        fv.jdField_b_of_type_Long = paramChatMessage.time * 1000L;
        paramacju = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
        paramacju.putLong("personal_font_last_receive_report", paramChatMessage.time * 1000L);
        paramacju.commit();
        continue;
        label946:
        paramacju = new ETFont(((fu)localObject1).jdField_a_of_type_Int, ((fu)localObject1).jdField_a_of_type_JavaLangString, localETTextView.getTextSize(), ((fu)localObject1).jdField_b_of_type_Int, ((fu)localObject1).jdField_a_of_type_AndroidGraphicsTypeface);
        continue;
        label982:
        localETTextView.d = false;
      }
    }
    label991:
    if (gh.jdField_a_of_type_Int == 4) {
      if (localfv.a(9999))
      {
        localETTextView.setDefaultFont(gh.a(paramChatMessage), paramChatMessage.uniseq);
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
    for (paramacju = "null";; paramacju = ((fu)localObject1).toString())
    {
      QLog.d("VasFont", 2, paramacju);
      return;
      gh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break label1022;
      localETTextView.setDefaultFont(gh.a(paramChatMessage), paramChatMessage.uniseq);
      break label1022;
      break;
    }
  }
  
  void a(adrh paramadrh, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {}
    fv localfv;
    do
    {
      do
      {
        return;
      } while ((awnu.b()) || ((1 == paramChatMessage.istroop) && (mnf.a(paramChatMessage))));
      localfv = (fv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
      localfv.b(paramChatMessage);
    } while (!localfv.b(paramChatMessage));
    localfv.a(paramChatMessage);
    localfv.a(paramadrh.d);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (aciy.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForText)aciy.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624443);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131624444);
    } while (!paramView.isSendFromLocal());
    babr.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new adre(this, paramView), new adrf(this)).show();
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
      acju localacju = (acju)paramView.getTag();
      if (localacju != null) {
        a(localacju, paramView, paramChatMessage, localacju.jdField_a_of_type_Almt);
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acju paramacju, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacju, paramInt1, paramInt2);
  }
  
  protected void a(ChatMessage paramChatMessage, String paramString)
  {
    ahox localahox = ahox.a();
    String str;
    int i;
    if (localahox.c())
    {
      str = localahox.a();
      if (str != null) {
        if (str.length() == localahox.a())
        {
          i = 1;
          localahox.d();
        }
      }
    }
    for (;;)
    {
      paramChatMessage = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, str);
      if (!TextUtils.isEmpty(paramChatMessage)) {
        break label92;
      }
      return;
      i = 0;
      break;
      i = 0;
      break;
      str = paramChatMessage.msg;
      i = 1;
    }
    label92:
    paramChatMessage = new StringBuilder(paramChatMessage);
    int j = 0;
    for (;;)
    {
      if (j >= paramChatMessage.length()) {
        break label211;
      }
      if ((paramChatMessage.codePointAt(j) == 20) && (j < paramChatMessage.length() - 1) && (paramChatMessage.charAt(j + 1) == 'ÿ'))
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800588D", 0, 0, "", "", "", "");
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ChatItemBuilder", 2, "report save small emoticon amount");
        return;
      }
      j += 1;
    }
    label211:
    if (i == 0)
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 4, 0, "", "", "", "");
      return;
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAC", 4, 0, "", "", "", "");
  }
  
  public boolean a(acju paramacju)
  {
    return paramacju instanceof adrh;
  }
  
  public bakj[] a(View paramView)
  {
    paramView = aciy.a(paramView);
    localbakh = new bakh();
    if ((paramView != null) && (paramView.isMultiMsg))
    {
      localbakh.a(2131299262, this.jdField_a_of_type_AndroidContentContext.getString(2131625727), 2130838590);
      localbakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131627114), 2130838599);
      localbakh.a(2131300328, this.jdField_a_of_type_AndroidContentContext.getString(2131626722), 2130838598);
      return localbakh.a();
    }
    if (alyc.a(paramView)) {
      return localbakh.a();
    }
    if (ApolloUtil.a(paramView)) {
      return localbakh.a();
    }
    int i = 0;
    j = 0;
    if ((paramView instanceof MessageForText)) {
      if (TextUtils.isEmpty(((MessageForText)paramView).getExtInfoFromExtStr("sticker_info"))) {
        break label481;
      }
    }
    label481:
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
          aael.a(localbakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
      }
      if ((j & 0x2) != 2) {
        break;
      }
      j = 1;
      if (j != 0) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009B17", "0X8009B17", 0, 0, "", "", "", "");
      }
      if ((paramView instanceof MessageForPoke)) {
        i = 1;
      }
      if (i != 0) {
        break label509;
      }
      if (j == 0) {
        localbakh.a(2131299262, ajjy.a(2131649066), 2130838590);
      }
      if ((paramView != null) && (paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
        localbakh.a(2131309426, this.jdField_a_of_type_AndroidContentContext.getString(2131652831), 2130838604);
      }
      if (j == 0) {
        localbakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131627114), 2130838599);
      }
      a(paramView, localbakh);
      if ((paramView != null) && (paramView.vipBubbleID == 100000L) && (!paramView.isSend())) {
        localbakh.a(2131296274, this.jdField_a_of_type_AndroidContentContext.getString(2131651461), 2130838577);
      }
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbakh, paramView);
      if (aciy.a(5) == 1) {
        localbakh.a(2131300328, this.jdField_a_of_type_AndroidContentContext.getString(2131626722), 2130838598);
      }
      b(paramView, localbakh);
      super.c(localbakh, this.jdField_a_of_type_AndroidContentContext);
      super.d(localbakh, this.jdField_a_of_type_AndroidContentContext);
      return localbakh.a();
    }
  }
  
  public void b(acju paramacju, ChatMessage paramChatMessage)
  {
    int i = 0;
    super.b(paramacju, paramChatMessage);
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {
      break label15;
    }
    label15:
    adrh localadrh;
    label146:
    label152:
    for (;;)
    {
      return;
      if ((paramacju instanceof adrh))
      {
        localadrh = (adrh)paramacju;
        if (!(paramChatMessage instanceof MessageForText)) {
          break;
        }
        paramChatMessage = (MessageForText)paramChatMessage;
        paramacju = null;
        if (!TextUtils.isEmpty(paramChatMessage.sb)) {
          if (TextUtils.isEmpty(paramChatMessage.sb2)) {
            break label146;
          }
        }
        for (paramacju = paramChatMessage.sb2;; paramacju = paramChatMessage.sb)
        {
          if ((paramacju == null) || (!(paramacju instanceof axkd))) {
            break label152;
          }
          paramChatMessage = (axkd)paramacju;
          paramacju = (axkk[])paramChatMessage.getSpans(0, paramacju.length(), axkk.class);
          if ((paramacju.length <= 0) || (paramChatMessage.b().length() != 0)) {
            break;
          }
          int j = paramacju.length;
          while (i < j)
          {
            paramacju[i].a(awmc.a(26.0F));
            i += 1;
          }
        }
      }
    }
    localadrh.d.setText(paramChatMessage);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adra
 * JD-Core Version:    0.7.0.1
 */