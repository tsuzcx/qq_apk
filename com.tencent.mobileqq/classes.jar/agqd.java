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
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.ClipboardManager;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
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
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.3;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.8;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForWriteTogether;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.util.Pair;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class agqd
  extends BaseBubbleBuilder
  implements aeze, Handler.Callback
{
  public static final LRULinkedHashMap<Long, SpannableString> a;
  private static String jdField_a_of_type_JavaLangString = "ArkApp.TextItemBuilder";
  public static final int c = BaseChatItemLayout.h + BaseChatItemLayout.m;
  protected static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  public static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  public static final int f = BaseChatItemLayout.k + BaseChatItemLayout.p;
  protected View.OnClickListener a;
  private bcne jdField_a_of_type_Bcne;
  protected bhba a;
  private fy jdField_a_of_type_Fy = new agqk(this);
  public Handler b;
  protected View.OnClickListener b;
  
  static
  {
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(50);
  }
  
  public agqd(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new agqe(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new agqf(this);
    this.jdField_a_of_type_Bhba = new agqm(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private static int a(ETTextView paramETTextView, CharSequence paramCharSequence)
  {
    return (int)Math.ceil(paramETTextView.getPaint().measureText(paramCharSequence, 0, paramCharSequence.length()));
  }
  
  @Nullable
  private SpannableString a(CharSequence paramCharSequence, long paramLong, ArrayList<Pair<Integer, Integer>> paramArrayList)
  {
    float f1 = 1.5F;
    if (FontSettingManager.getFontLevel() == 18.0F) {
      f1 = 1.3F;
    }
    int i = (int)(paramArrayList.size() * 0.3F + 0.5D);
    int j = (int)(paramArrayList.size() * 0.3F + 0.5D);
    int k = 4;
    boolean bool = true;
    float f2;
    if (gb.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f1 = gb.jdField_c_of_type_Float;
      f2 = gb.d;
      if (FontSettingManager.getFontLevel() == 18.0F)
      {
        f1 = gb.e;
        f2 = gb.jdField_f_of_type_Float;
      }
      bool = gb.jdField_f_of_type_Boolean;
      i = (int)(paramArrayList.size() * gb.jdField_a_of_type_Float + 0.5D);
      j = (int)(paramArrayList.size() * gb.jdField_b_of_type_Float + 0.5D);
      k = gb.jdField_b_of_type_Int;
    }
    SpannableString localSpannableString;
    for (;;)
    {
      localSpannableString = new SpannableString(paramCharSequence);
      if (paramArrayList.size() != 1) {
        break;
      }
      paramCharSequence = localSpannableString;
      if (a(paramLong, paramArrayList, f1, f2, bool, localSpannableString)) {
        paramCharSequence = null;
      }
      return paramCharSequence;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont config not init");
      }
      f2 = 0.7F;
    }
    a(paramLong, paramArrayList, f1, f2, i, j, k, localSpannableString);
    return localSpannableString;
  }
  
  private BaseChatPie a()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
      return null;
    }
    ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
    if (localChatFragment == null)
    {
      QLog.e("ChatItemBuilder", 1, "[getChatPie] ChatFragment is null");
      return null;
    }
    return localChatFragment.a();
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Activity paramActivity, ChatMessage paramChatMessage, String paramString)
  {
    paramChatMessage.msg = a(paramChatMessage.msg, true);
    paramString = a(paramString, true);
    bkov.a(null, paramString).b(paramQQAppInterface, paramChatMessage).a(paramActivity, paramQQAppInterface.getAccount());
    bkpf.a(paramQQAppInterface, 6, 1);
    return paramString;
  }
  
  private String a(ChatMessage paramChatMessage, Context paramContext, agql paramagql)
  {
    Object localObject = "";
    if ((paramChatMessage instanceof MessageForText))
    {
      localObject = (MessageForText)paramChatMessage;
      if (paramChatMessage.msgtype == -2008)
      {
        if (paramChatMessage.isSend())
        {
          paramagql.d.setText(paramContext.getString(2131718033));
          return "";
        }
        paramagql.d.setText(paramContext.getString(2131718032));
        return "";
      }
      a(paramagql, paramChatMessage);
      if (!android.text.TextUtils.isEmpty(((MessageForText)localObject).sb))
      {
        if (!android.text.TextUtils.isEmpty(((MessageForText)localObject).sb2))
        {
          paramagql.d.setText(((MessageForText)localObject).sb2);
          super.a(paramagql.d, paramChatMessage);
          if (AppSetting.c)
          {
            paramChatMessage = com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramChatMessage.msg);
            paramContext = Spannable.Factory.getInstance().newSpannable(paramChatMessage);
            if (!Linkify.addLinks(paramContext, 15)) {
              break label185;
            }
            paramagql.d.setContentDescription(paramContext);
          }
        }
        for (;;)
        {
          return ((MessageForText)localObject).sb.toString();
          paramagql.d.setText(((MessageForText)localObject).sb);
          break;
          label185:
          paramagql.d.setContentDescription(paramChatMessage);
        }
      }
      paramagql.d.setText("");
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "textitem text.sb is null" + paramChatMessage.msgtype);
      }
      return "";
    }
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramContext = (MessageForHiBoom)paramChatMessage;
      paramChatMessage = (ChatMessage)localObject;
      if (paramContext.mHiBoomMessage != null)
      {
        paramagql.d.setText(paramContext.mHiBoomMessage.text);
        paramChatMessage = paramContext.mHiBoomMessage.text;
      }
      return paramChatMessage;
    }
    if ((paramChatMessage instanceof MessageForPoke))
    {
      paramContext = (MessageForPoke)paramChatMessage;
      paramChatMessage = amtj.a(2131713893);
      if (paramContext.name != null) {
        paramChatMessage = "[" + paramContext.name + "]请用最新版手机QQ查看。";
      }
      paramagql.d.setText(paramChatMessage);
      return paramChatMessage;
    }
    paramagql.d.setText(paramChatMessage.msg);
    super.a(paramagql.d, paramChatMessage);
    return paramChatMessage.msg;
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
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
  
  private void a(int paramInt)
  {
    int i = 1;
    if (paramInt == 0) {
      paramInt = i;
    }
    for (;;)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B155", "0X800B155", paramInt, 0, "", "", "", "");
      return;
      if (paramInt == 1) {
        paramInt = 2;
      } else if (ChatActivityUtils.a(paramInt)) {
        paramInt = 3;
      } else {
        paramInt = 4;
      }
    }
  }
  
  private void a(long paramLong, ArrayList<Pair<Integer, Integer>> paramArrayList, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, SpannableString paramSpannableString)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    float f1;
    label97:
    int m;
    if (k < paramArrayList.size())
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramInt3 > 0)
      {
        bool1 = bool2;
        if (k % paramInt3 == paramInt3 - 1)
        {
          bool1 = bool2;
          if (j == 0) {
            bool1 = true;
          }
        }
      }
      if ((paramLong % (paramArrayList.size() - k) >= paramInt1 + paramInt2) && (!bool1)) {
        break label405;
      }
      if ((paramInt1 <= 0) && (paramInt2 > 0))
      {
        f1 = paramFloat2;
        j = paramInt1;
        if (f1 == paramFloat1) {
          j = paramInt1 - 1;
        }
        paramInt1 = paramInt2;
        if (f1 == paramFloat2) {
          paramInt1 = paramInt2 - 1;
        }
        paramSpannableString.setSpan(new RelativeSizeSpan(f1), ((Integer)((Pair)paramArrayList.get(k)).first).intValue(), ((Integer)((Pair)paramArrayList.get(k)).second).intValue(), 33);
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "generateMagicFont word change: " + ((Pair)paramArrayList.get(k)).first + " , " + ((Pair)paramArrayList.get(k)).second + " size = " + f1 + " index = " + k + " forceChange = " + bool1);
        }
        i += 1;
        int n = 1;
        paramInt2 = paramInt1;
        m = j;
        j = n;
      }
    }
    for (;;)
    {
      paramInt1 = j;
      if (paramInt3 > 0)
      {
        paramInt1 = j;
        if (k % paramInt3 == paramInt3 - 1) {
          paramInt1 = 0;
        }
      }
      paramLong = (25214903917L * paramLong + 11L & 0xFFFFFFFF) >> 16;
      k += 1;
      j = paramInt1;
      paramInt1 = m;
      break;
      if ((paramInt2 <= 0) && (paramInt1 > 0))
      {
        f1 = paramFloat1;
        break label97;
      }
      if (i % 2 == 1)
      {
        f1 = paramFloat2;
        break label97;
        return;
      }
      f1 = paramFloat1;
      break label97;
      label405:
      m = paramInt1;
    }
  }
  
  public static void a(Message paramMessage, XListView paramXListView)
  {
    long l = paramMessage.getData().getLong("msg_id");
    paramXListView = AIOUtils.getViewByPostion(paramXListView, AIOUtils.findMessagePosition(l, paramXListView.getAdapter()));
    if ((paramXListView != null) && ((paramXListView.getTag() instanceof agql)))
    {
      paramXListView = (agql)paramXListView.getTag();
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
  
  private void a(ChatMessage paramChatMessage, aezf paramaezf, agql paramagql)
  {
    if ((paramagql.d instanceof AnimationTextView))
    {
      paramagql = (AnimationTextView)paramagql.d;
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramagql, paramaezf.jdField_b_of_type_Int, paramaezf.c, false);
      paramagql.onDoubleClick = this.jdField_a_of_type_Bhba;
      paramagql.onSingleClick = new agqg(this, paramChatMessage.isSend());
    }
  }
  
  private void a(ChatMessage paramChatMessage, agql paramagql)
  {
    if (this.jdField_a_of_type_Bcne == null) {
      this.jdField_a_of_type_Bcne = new bcne();
    }
    if (this.jdField_a_of_type_Bcne.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ETTextView)paramagql.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem)) {
      return;
    }
    gb localgb = (gb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
    ga localga = localgb.b(paramChatMessage);
    ETTextView localETTextView = (ETTextView)paramagql.d;
    localETTextView.setMinWidth(AIOUtils.dp2px(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    if ((!(paramChatMessage instanceof MessageForReplyText)) || (!(paramagql instanceof agmu))) {
      localETTextView.setMinHeight(AIOUtils.dp2px(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    paramagql = gb.a(paramChatMessage);
    if ((localga != null) && (localga.jdField_b_of_type_Int == 1)) {
      localETTextView.isParsingMagicFont = false;
    }
    if (gb.a(paramChatMessage)) {
      a(paramChatMessage, localga, localETTextView);
    }
    a(paramChatMessage, localgb, localga, localETTextView, paramagql);
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, Context paramContext, agql paramagql)
  {
    if (paramagql.jdField_c_of_type_AndroidWidgetImageView != null) {
      paramagql.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (paramagql.b != null) {
      paramagql.b.setVisibility(8);
    }
    paramBaseChatItemLayout = (TextView)paramBaseChatItemLayout.findViewById(2131364472);
    int i;
    if ((paramChatMessage.mNeedTimeStamp) && (paramChatMessage.time > 0L) && (paramBaseChatItemLayout != null) && (paramChatMessage.time != ((Long)paramBaseChatItemLayout.getTag()).longValue()))
    {
      if (paramagql.b != null) {
        paramagql.b.setPadding(0, AIOUtils.dp2px(70.0F, paramContext.getResources()), 0, 0);
      }
      if (paramagql.jdField_c_of_type_AndroidWidgetImageView != null) {
        paramagql.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.dp2px(80.0F, paramContext.getResources()), 0, 0);
      }
      if (((paramChatMessage.extraflag != 32768) || (!paramChatMessage.isSendFromLocal())) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(paramChatMessage))) {
        break label306;
      }
      i = 1;
      label177:
      if ((paramChatMessage.isFollowMessage()) && (i == 0) && (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isUpComingPrevious))
      {
        if (!paramChatMessage.isSend()) {
          break label312;
        }
        if (paramagql.b != null)
        {
          paramagql.b.setImageResource(2130847022);
          paramagql.b.setVisibility(0);
        }
      }
    }
    label306:
    label312:
    while (paramagql.jdField_c_of_type_AndroidWidgetImageView == null)
    {
      return;
      if (paramagql.b != null) {
        paramagql.b.setPadding(0, AIOUtils.dp2px(30.0F, paramContext.getResources()), 0, 0);
      }
      if (paramagql.jdField_c_of_type_AndroidWidgetImageView == null) {
        break;
      }
      paramagql.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.dp2px(30.0F, paramContext.getResources()), 0, 0);
      break;
      i = 0;
      break label177;
    }
    paramagql.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130847022);
    paramagql.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void a(ChatMessage arg1, ga paramga, ETTextView paramETTextView)
  {
    MessageForText localMessageForText;
    CharSequence localCharSequence;
    if ((??? instanceof MessageForText))
    {
      localMessageForText = (MessageForText)???;
      localCharSequence = null;
      if (!android.text.TextUtils.isEmpty(localMessageForText.sb))
      {
        if (android.text.TextUtils.isEmpty(localMessageForText.sb2)) {
          break label128;
        }
        localCharSequence = localMessageForText.sb2;
      }
    }
    for (;;)
    {
      long l1;
      long l2;
      if ((localCharSequence != null) && (com.tencent.mobileqq.text.TextUtils.hasChnChar(localCharSequence)))
      {
        l1 = ((MessageForText)???).msgUid;
        l2 = ((MessageForText)???).uniseq;
      }
      synchronized (jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
      {
        if (jdField_a_of_type_ComTencentUtilLRULinkedHashMap.containsKey(Long.valueOf(l2)))
        {
          paramga = (SpannableString)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(Long.valueOf(l2));
          if (paramga != null)
          {
            paramETTextView.setText(paramga);
            paramETTextView.mMagicFont = true;
          }
          return;
          label128:
          localCharSequence = localMessageForText.sb;
          continue;
        }
        if ((paramga != null) && (paramga.jdField_b_of_type_Int == 1)) {
          paramETTextView.isParsingMagicFont = true;
        }
        ArkRecommendLogic.a().post(new TextItemBuilder.8(this, localCharSequence, l1, l2));
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, gb paramgb, ga paramga, ETTextView paramETTextView, String paramString)
  {
    if ((paramga != null) && (paramga.jdField_a_of_type_Int != 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(paramString))
      {
        if (gb.jdField_a_of_type_Long == 0L) {
          gb.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("personal_font_last_send_report", 1L);
        }
        if ((gb.jdField_a_of_type_Long < gb.jdField_c_of_type_Long) && (paramChatMessage.time * 1000L > gb.jdField_c_of_type_Long))
        {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X8007B2B", 0, 0, "" + (paramga.jdField_b_of_type_Int - 1), "" + paramga.jdField_a_of_type_Int, "", "");
          gb.jdField_a_of_type_Long = paramChatMessage.time * 1000L;
          paramgb = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
          paramgb.putLong("personal_font_last_send_report", paramChatMessage.time * 1000L);
          paramgb.commit();
        }
        if (paramga.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
          break label501;
        }
        paramgb = paramga.jdField_a_of_type_ComEtrumpMixlayoutETFont;
        paramgb.setSize(paramETTextView.getTextSize());
        label226:
        if (!android.text.TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("font_animation_played"))) {
          break label533;
        }
      }
      label533:
      for (paramETTextView.shouldStartAnimation = true;; paramETTextView.shouldStartAnimation = false)
      {
        paramETTextView.setFont(paramgb, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "updateTextFont  fontId = " + paramga.jdField_a_of_type_Int + "fontType = " + paramga.jdField_b_of_type_Int + "typeface = " + paramga.jdField_a_of_type_AndroidGraphicsTypeface);
        }
        return;
        if (gb.jdField_b_of_type_Long == 0L) {
          gb.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("personal_font_last_receive_report", 1L);
        }
        if ((gb.jdField_b_of_type_Long >= gb.jdField_c_of_type_Long) || (paramChatMessage.time * 1000L <= gb.jdField_c_of_type_Long)) {
          break;
        }
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X8007B2C", 0, 0, "" + (paramga.jdField_b_of_type_Int - 1), "" + paramga.jdField_a_of_type_Int, "", "");
        gb.jdField_b_of_type_Long = paramChatMessage.time * 1000L;
        paramgb = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
        paramgb.putLong("personal_font_last_receive_report", paramChatMessage.time * 1000L);
        paramgb.commit();
        break;
        label501:
        paramgb = new ETFont(paramga.jdField_a_of_type_Int, paramga.jdField_a_of_type_JavaLangString, paramETTextView.getTextSize(), paramga.jdField_b_of_type_Int, paramga.jdField_a_of_type_AndroidGraphicsTypeface);
        break label226;
      }
    }
    if (gm.jdField_a_of_type_Int == 4) {
      if (paramgb.a(9999))
      {
        paramETTextView.setDefaultFont(gm.a(paramChatMessage), paramChatMessage.uniseq);
        label572:
        if (!QLog.isColorLevel()) {
          break label641;
        }
        paramgb = new StringBuilder().append("updateTextFont fontinfo = ");
        if (paramga != null) {
          break label643;
        }
      }
    }
    label641:
    label643:
    for (paramChatMessage = "null";; paramChatMessage = paramga.toString())
    {
      QLog.d("VasFont", 2, paramChatMessage);
      return;
      gm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break label572;
      paramETTextView.setDefaultFont(gm.a(paramChatMessage), paramChatMessage.uniseq);
      break label572;
      break;
    }
  }
  
  private void a(MessageForText paramMessageForText, ETTextView paramETTextView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    paramCharSequence3 = new SpannableStringBuilder(paramCharSequence2).append(paramCharSequence3);
    paramCharSequence3.setSpan(new agqh(this, paramMessageForText, paramETTextView, paramCharSequence1), paramCharSequence2.length(), paramCharSequence3.length(), 33);
    paramETTextView.setTextMsg(paramCharSequence3);
    paramETTextView.setHighlightColor(0);
    paramETTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramETTextView.setFocusable(false);
  }
  
  private boolean a(long paramLong, ArrayList<Pair<Integer, Integer>> paramArrayList, float paramFloat1, float paramFloat2, boolean paramBoolean, SpannableString paramSpannableString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "generateMagicFont oneWord");
    }
    if ((!paramBoolean) || (((Integer)((Pair)paramArrayList.get(0)).second).intValue() - ((Integer)((Pair)paramArrayList.get(0)).first).intValue() <= 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont oneWord switch = " + paramBoolean + " length = " + (((Integer)((Pair)paramArrayList.get(0)).second).intValue() - ((Integer)((Pair)paramArrayList.get(0)).first).intValue()));
      }
      return true;
    }
    if (((Integer)((Pair)paramArrayList.get(0)).second).intValue() - ((Integer)((Pair)paramArrayList.get(0)).first).intValue() == 2) {}
    for (int i = 1;; i = 2)
    {
      int m = 0;
      int k = 0;
      int n = i;
      int j;
      if (k < ((Integer)((Pair)paramArrayList.get(0)).second).intValue() - ((Integer)((Pair)paramArrayList.get(0)).first).intValue())
      {
        i = m;
        j = n;
        if (paramLong % (((Integer)((Pair)paramArrayList.get(0)).second).intValue() - ((Integer)((Pair)paramArrayList.get(0)).first).intValue() - k) < n) {
          if (m % 2 != 1) {
            break label478;
          }
        }
      }
      label478:
      for (float f1 = paramFloat2;; f1 = paramFloat1)
      {
        paramSpannableString.setSpan(new RelativeSizeSpan(f1), ((Integer)((Pair)paramArrayList.get(0)).first).intValue() + k, ((Integer)((Pair)paramArrayList.get(0)).first).intValue() + k + 1, 33);
        n -= 1;
        m += 1;
        i = m;
        j = n;
        if (QLog.isColorLevel())
        {
          QLog.d("ChatItemBuilder", 2, "generateMagicFont oneWord change index = " + ((Pair)paramArrayList.get(0)).first + k + " changeSize = " + f1);
          j = n;
          i = m;
        }
        paramLong = (25214903917L * paramLong + 11L & 0xFFFFFFFF) >> 16;
        k += 1;
        m = i;
        n = j;
        break;
        return false;
      }
    }
  }
  
  private boolean a(aezf paramaezf, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {}
    while ((AIOUtils.isForbidChatFontFunForAIOOpen) || (!(paramaezf instanceof agql))) {
      return true;
    }
    return false;
  }
  
  private boolean a(ChatMessage paramChatMessage, agql paramagql)
  {
    int i = 0;
    boolean bool2 = false;
    int j;
    boolean bool1;
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1)) && (paramChatMessage.isShowQIMStyleGroup))
    {
      i = Color.parseColor("#FFFFFFFF");
      j = Color.parseColor("#ff5078f0");
      paramagql.d.setTextColor(i);
      paramagql.d.setLinkTextColor(j);
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 0);
      bool1 = bool2;
    } while (!ahcd.a().a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
    if (!paramChatMessage.isSend()) {
      i = 1;
    }
    if (i != 0) {
      j = Color.parseColor("#ff000000");
    }
    for (i = Color.parseColor("#ff80e9ff");; i = Color.parseColor("#ff5078f0"))
    {
      paramagql.d.setTextColor(j);
      paramagql.d.setLinkTextColor(i);
      return true;
      j = Color.parseColor("#FFFFFFFF");
    }
  }
  
  private void b(View paramView, ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "C2CMessageFold textItemBuilder flag: " + paramChatMessage.getExtInfoFromExtStr("key_message_extra_info_flag"));
    }
    a(paramChatMessage);
    ETTextView localETTextView;
    MessageForText localMessageForText;
    if (((paramView instanceof ETTextView)) && ((paramChatMessage instanceof MessageForText)) && (agix.a(paramChatMessage)))
    {
      localETTextView = (ETTextView)paramView;
      localMessageForText = (MessageForText)paramChatMessage;
      if (android.text.TextUtils.isEmpty(localMessageForText.sb)) {
        break label216;
      }
      if (android.text.TextUtils.isEmpty(localMessageForText.sb2)) {
        break label207;
      }
      paramView = localMessageForText.sb2;
    }
    for (;;)
    {
      int i = a(localETTextView, paramView);
      int j = BaseChatItemLayout.e - e - f;
      if (i > j)
      {
        String str = this.jdField_a_of_type_AndroidContentContext.getString(2131694307);
        CharSequence localCharSequence = android.text.TextUtils.ellipsize(paramView, localETTextView.getPaint(), j - a(localETTextView, str), TextUtils.TruncateAt.END);
        if (!localETTextView.isUsingFZColorFont2())
        {
          paramChatMessage = localCharSequence;
          if (!localETTextView.isUsingHYFont()) {}
        }
        else
        {
          paramChatMessage = a(localCharSequence, 3);
        }
        a(localMessageForText, localETTextView, paramView, paramChatMessage, str);
      }
      return;
      label207:
      paramView = localMessageForText.sb;
      continue;
      label216:
      paramView = "";
    }
  }
  
  private void b(ChatMessage paramChatMessage, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", -1);
    MessageForText localMessageForText;
    Object localObject;
    int i;
    if ((paramChatMessage instanceof MessageForText))
    {
      afnx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 3);
      localMessageForText = (MessageForText)paramChatMessage;
      if (!akxv.a().c()) {
        break label456;
      }
      localObject = akxv.a().b();
      if (localObject == null) {
        break label451;
      }
      if (((String)localObject).length() != akxv.a().a()) {
        break label446;
      }
      i = 1;
      if (!agix.a(paramChatMessage)) {
        break label556;
      }
      localObject = ((MessageForText)paramChatMessage).sb.toString();
      i = 1;
    }
    label513:
    label519:
    label556:
    for (;;)
    {
      localBundle.putString("forward_text", (String)localObject);
      localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
      localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      boolean bool = localMessageForText instanceof MessageForWriteTogether;
      localBundle.putBooleanArray("forward_is_write_together", new boolean[] { bool });
      int j;
      label176:
      label191:
      String str;
      label206:
      int k;
      if (bool)
      {
        j = ((MessageForWriteTogether)localMessageForText).baseRev;
        if (!bool) {
          break label497;
        }
        localObject = ((MessageForWriteTogether)localMessageForText).padId;
        if (!bool) {
          break label505;
        }
        str = ((MessageForWriteTogether)localMessageForText).token;
        if (!bool) {
          break label513;
        }
        k = 1;
        label214:
        localBundle.putString("forward_source_uin", localMessageForText.frienduin);
        localBundle.putIntArray("forward_write_together_base_rev", new int[] { j });
        localBundle.putStringArray("forward_write_together_pad_id", new String[] { localObject });
        localBundle.putStringArray("forward_write_together_token", new String[] { str });
        localBundle.putInt("forward_write_together_number", k);
        localObject = new Intent();
        ((Intent)localObject).putExtras(localBundle);
        ((Intent)localObject).putExtra("direct_send_if_dataline_forward", true);
        atky.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "1", "", "", "");
        if (i == 0) {
          break label519;
        }
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramChatMessage.isMultiMsg) {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 1, 0, "1", "", "", "");
        }
        return;
        label446:
        i = 0;
        break;
        label451:
        i = 0;
        break;
        label456:
        if (localMessageForText.sb != null) {}
        for (localObject = localMessageForText.sb.toString();; localObject = localMessageForText.msg)
        {
          i = 1;
          break;
        }
        j = 0;
        break label176;
        label497:
        localObject = "";
        break label191;
        label505:
        str = "";
        break label206;
        k = 0;
        break label214;
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      }
    }
  }
  
  private boolean b(ChatMessage paramChatMessage, agql paramagql)
  {
    boolean bool = false;
    if (((paramChatMessage.istroop != 3000) && (paramChatMessage.istroop != 1)) || ((paramChatMessage.isShowQIMStyleGroup) || (auyo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isQimUserOnline) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isQimUserBubbleForm)) || (bbyp.b())))
    {
      ETFont localETFont = new ETFont(0, null, 0.0F);
      if ((paramagql.d instanceof ETTextView)) {
        ((ETTextView)paramagql.d).setFont(localETFont, paramChatMessage.uniseq);
      }
      bool = true;
    }
    return bool;
  }
  
  private void c(ChatMessage paramChatMessage, String paramString)
  {
    paramChatMessage = a(paramChatMessage, paramString, akxv.a());
    if (paramChatMessage != null) {}
    try
    {
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramChatMessage);
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "Copy message, msg=" + paramChatMessage);
      }
      return;
    }
    catch (Exception paramChatMessage)
    {
      QLog.e("ChatItemBuilder", 2, paramChatMessage.toString());
    }
  }
  
  private void e(View paramView)
  {
    if (paramView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null)
    {
      paramView.setVisibility(8);
      return;
    }
    a(localLayoutParams);
    localLayoutParams.addRule(5, 0);
    localLayoutParams.addRule(7, 2131364441);
    localLayoutParams.addRule(3, 2131364441);
    localLayoutParams.rightMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296388) + DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    paramView.setVisibility(0);
  }
  
  private void h(ChatMessage paramChatMessage)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      if (localObject != null)
      {
        localObject = (bdgh)((BaseChatPie)localObject).getHelper(74);
        if ((localObject != null) && ((paramChatMessage instanceof MessageForText))) {
          ((bdgh)localObject).b(((MessageForText)paramChatMessage).sb.toString(), 3);
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public aeze a(View paramView)
  {
    if (a(paramView)) {
      return this;
    }
    return null;
  }
  
  public aezf a()
  {
    return new agql();
  }
  
  public SpannableString a(CharSequence paramCharSequence, long paramLong)
  {
    String str1 = com.tencent.mobileqq.text.TextUtils.replaceEmojiWithSpace(paramCharSequence.toString());
    if (android.text.TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont msg is empty");
      }
      return null;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = aots.a(null, str1);
    String[] arrayOfString = ((aotu)localObject).jdField_a_of_type_ArrayOfJavaLangString;
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "generateMagicFont word segment cost " + (l2 - l1) + "ms; msg length = " + paramCharSequence.length());
    }
    if (!((aotu)localObject).jdField_a_of_type_Boolean)
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
    if (j < arrayOfString.length)
    {
      while ((i < str1.length()) && (str1.charAt(i) == ' ')) {
        i += 1;
      }
      String str2 = arrayOfString[j];
      int k = 0;
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
    return a(paramCharSequence, paramLong, (ArrayList)localObject);
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    agql localagql;
    Object localObject1;
    label155:
    Object localObject2;
    Object localObject3;
    if ((paramaezf instanceof agql))
    {
      localagql = (agql)paramaezf;
      if (paramView != null) {
        break label973;
      }
      localObject1 = new ImageView(localContext);
      ((ImageView)localObject1).setId(2131366928);
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(0, 2131364441);
      paramView.addRule(15, 2131363354);
      ((ImageView)localObject1).setContentDescription(amtj.a(2131713892));
      paramBaseChatItemLayout.addView((View)localObject1, paramView);
      ((ImageView)localObject1).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramView = new ETTextView(localContext);
      com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10(paramView);
      paramView.setTextColor(localContext.getResources().getColorStateList(2131167031));
      paramView.setLinkTextColor(localContext.getResources().getColorStateList(2131167024));
      if (!AppSetting.c) {
        break label937;
      }
      paramView.setAutoLinkMask(3);
      paramView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
      paramView.setMaxWidth(BaseChatItemLayout.e);
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      paramView.setTextAnimationListener(this.jdField_a_of_type_Fy);
      paramView.setId(2131364444);
      localObject2 = new ImageView(localContext);
      ((ImageView)localObject2).setId(2131366929);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131364441);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15, 2131363354);
      ((ImageView)localObject2).setContentDescription(amtj.a(2131713894));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = 10;
      paramBaseChatItemLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      ((ImageView)localObject2).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localagql.d = paramView;
      localagql.b = ((ImageView)localObject1);
      localagql.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
      localagql.jdField_a_of_type_Akxy = new akxy();
      localagql.jdField_a_of_type_Akxy.a(paramView);
      localagql.jdField_a_of_type_Akxy.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
    }
    label937:
    label966:
    label973:
    for (;;)
    {
      ((ETTextView)localagql.d).setFont(0, paramChatMessage.uniseq);
      localagql.d.setTypeface(null);
      ((ETTextView)localagql.d).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      ((ETTextView)localagql.d).setStrokeColor(false, 0);
      ((ETTextView)localagql.d).mMagicFont = false;
      ((ETTextView)localagql.d).setCacheMeasureResult(true);
      localagql.d.setTypeface(gm.a(paramChatMessage));
      if (!android.text.TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))
      {
        localObject1 = ((ETTextView)localagql.d).getETLayout();
        if (localObject1 != null) {
          ((fn)localObject1).jdField_a_of_type_Long = (paramChatMessage.uniseq + 1L);
        }
      }
      localagql.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
      localagql.d.setGravity(16);
      int j = BaseChatItemLayout.o;
      int i = BaseChatItemLayout.p;
      if (paramChatMessage.isSend())
      {
        j = BaseChatItemLayout.p;
        i = BaseChatItemLayout.o;
      }
      localagql.d.setPadding(j, BaseChatItemLayout.m, i, BaseChatItemLayout.n);
      localagql.jdField_a_of_type_Long = paramChatMessage.uniseq;
      localObject1 = a(paramChatMessage, localContext, localagql);
      localObject2 = (bfdm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if (bfdm.b(paramChatMessage)) {
        bfdm.a(localagql.d, paramChatMessage);
      }
      localObject3 = bgny.a();
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000)) && (!paramChatMessage.isread))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in TextItemBuilder.getBubbleView()");
        }
        ((bgny)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, (String)localObject1, localContext, paramChatMessage.isSend());
      }
      localagql.d.setOnTouchListener(paramafce);
      localagql.d.setOnLongClickListener(paramafce);
      localagql.jdField_a_of_type_Afce = paramafce;
      localagql.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      a(paramChatMessage, paramaezf, localagql);
      a(paramChatMessage, paramBaseChatItemLayout, localContext, localagql);
      if (localagql.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null)
      {
        if (((bfdm)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
          localagql.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        }
      }
      else
      {
        label767:
        if (localagql.jdField_a_of_type_Akxy != null) {
          localagql.jdField_a_of_type_Akxy.b(paramChatMessage);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!(this instanceof agua)))
        {
          localagql.jdField_c_of_type_AndroidViewView = super.a(localagql.jdField_c_of_type_AndroidViewView, localagql, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 21.0F));
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin == null)) {
            break label966;
          }
        }
      }
      for (paramaezf = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;; paramaezf = "")
      {
        boolean bool = beeg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramaezf);
        if ((localagql.jdField_a_of_type_AndroidViewView != null) && (bool) && (localagql.jdField_c_of_type_AndroidViewView != null)) {
          localagql.jdField_a_of_type_AndroidViewView.post(new TextItemBuilder.3(this, localagql, paramChatMessage, paramChatMessage));
        }
        return paramView;
        localagql = (agql)a();
        localagql.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
        paramBaseChatItemLayout.setTag(localagql);
        paramView = null;
        break;
        paramView.setAutoLinkMask(0);
        break label155;
        localagql.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        break label767;
      }
    }
  }
  
  public CharSequence a(CharSequence paramCharSequence, int paramInt)
  {
    if ((paramInt > paramCharSequence.length() - 1) || (paramInt <= 0)) {
      return paramCharSequence;
    }
    if ((paramCharSequence instanceof Spanned)) {}
    int i;
    for (Object localObject = (Spanned)paramCharSequence;; localObject = null)
    {
      i = paramCharSequence.length();
      if (localObject != null) {
        break;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramCharSequence, 0, i - paramInt - 1);
      ((StringBuilder)localObject).append(paramCharSequence, i - 1, i);
      return ((StringBuilder)localObject).toString();
    }
    localObject = new SpannableStringBuilder();
    ((SpannableStringBuilder)localObject).append(paramCharSequence, 0, i - paramInt - 1);
    ((SpannableStringBuilder)localObject).append(paramCharSequence, i - 1, i);
    return localObject;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (((paramChatMessage instanceof MessageForText)) || ((paramChatMessage instanceof MessageForReplyText))) {
      return amtj.a(2131713891) + com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramChatMessage.msg);
    }
    return amtj.a(2131713889) + paramChatMessage.msg;
  }
  
  String a(ChatMessage paramChatMessage, String paramString, akxv paramakxv)
  {
    if (paramChatMessage.msg != null)
    {
      afnx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 2);
      int i;
      if (paramChatMessage.isMultiMsg)
      {
        awct.a("0X8009AB7");
        i = 1;
        if ((paramChatMessage instanceof MessageForLongTextMsg)) {
          i = 2;
        }
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D65", "0X8009D65", i, 0, "" + i, "", "", "");
      }
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644A", "0X800644A", 0, 0, "1", "", "", "");
      int j;
      if (paramakxv.c())
      {
        String str = paramakxv.b();
        if (str != null) {
          if (str.length() == paramakxv.a())
          {
            i = 1;
            j = i;
            paramakxv = str;
            if ((paramChatMessage instanceof MessageForText))
            {
              j = i;
              paramakxv = str;
              if (agix.a(paramChatMessage))
              {
                paramakxv = ((MessageForText)paramChatMessage).sb.toString();
                j = 1;
              }
            }
            label210:
            if (j == 0) {
              break label274;
            }
            bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
          }
        }
      }
      for (;;)
      {
        return paramakxv;
        i = 0;
        break;
        i = 0;
        break;
        paramakxv = paramChatMessage.msg;
        j = 1;
        break label210;
        label274:
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
      }
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    ETEngine.getInstance().onAIODestroy();
    if (this.jdField_a_of_type_Bcne != null) {
      this.jdField_a_of_type_Bcne.a();
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      str1 = str2;
      if (android.text.TextUtils.isEmpty(str2)) {
        str1 = "";
      }
    }
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131365382: 
    case 2131365216: 
    case 2131376333: 
    case 2131367094: 
    case 2131366347: 
      do
      {
        do
        {
          return;
          str1 = "";
          break;
          acvv.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "1", "", "", "");
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 6, 0, "", "", "", "");
          return;
          c(paramChatMessage, str1);
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
        acvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage.msg, paramChatMessage.uniseq);
        return;
        b(paramChatMessage, str1);
        return;
        a(paramChatMessage, str1);
        afnx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 4);
        bkpf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramChatMessage.istroop);
      } while (!paramChatMessage.isMultiMsg);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 1, 0, "1", "", "", "");
      return;
    case 2131371498: 
      super.d(paramChatMessage);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 7, 0, "", "", "", "");
      return;
    case 2131371455: 
      super.a(paramChatMessage);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 5, 0, "", "", "", "");
      return;
    case 2131377014: 
      akxv.a().a(paramChatMessage);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 2, 0, "", "", "", "");
      return;
    case 2131376279: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 3, 0, "", "", "", "");
      b(paramChatMessage);
      return;
    }
    h(paramChatMessage);
  }
  
  public void a(aezf paramaezf, View paramView, ChatMessage paramChatMessage, apee paramapee)
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
        } while (!(paramaezf instanceof agql));
        localObject = (agql)paramaezf;
      } while (a(paramChatMessage, (agql)localObject));
      boolean bool = bbyp.b();
      if ((paramapee.jdField_a_of_type_Int == 0) || (!paramapee.a()) || (bool))
      {
        paramView = paramView.getResources();
        int i;
        if (paramChatMessage.isSend())
        {
          paramaezf = paramView.getColorStateList(2131167035);
          ((agql)localObject).d.setTextColor(paramaezf);
          if (auyo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
          {
            if (!paramChatMessage.isSend()) {
              break label192;
            }
            i = -1;
            ((agql)localObject).d.setTextColor(i);
          }
          if (!paramChatMessage.isSend()) {
            break label200;
          }
        }
        for (paramaezf = paramView.getColorStateList(2131167034);; paramaezf = paramView.getColorStateList(2131167033))
        {
          ((agql)localObject).d.setLinkTextColor(paramaezf);
          return;
          paramaezf = paramView.getColorStateList(2131167031);
          break;
          i = -16777216;
          break label146;
        }
      }
      ColorStateList.valueOf(paramapee.jdField_b_of_type_Int);
      if (paramapee.jdField_b_of_type_Int == 0)
      {
        ((agql)localObject).d.setTextColor(-16777216);
        ColorStateList.valueOf(-16777216);
        if (paramapee.c != 0) {
          break label384;
        }
      }
      for (paramaezf = paramView.getResources().getColorStateList(2131167033);; paramaezf = ColorStateList.valueOf(paramapee.c))
      {
        ((agql)localObject).d.setLinkTextColor(paramaezf);
        if (!(((agql)localObject).d instanceof ETTextView)) {
          break;
        }
        if (!paramapee.jdField_a_of_type_Boolean) {
          break label396;
        }
        ((ETTextView)((agql)localObject).d).setShadowLayer(3.0F, 0.0F, 0.0F, paramapee.d);
        ((ETTextView)((agql)localObject).d).setStrokeColor(true, paramapee.d);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramapee.d);
        return;
        ((agql)localObject).d.setTextColor(paramapee.jdField_b_of_type_Int);
        break label246;
      }
    } while ((!paramapee.jdField_b_of_type_Boolean) || (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((agql)localObject).d.getCurrentTextColor(), 10000.0D * ((agql)localObject).jdField_a_of_type_Apee.jdField_a_of_type_Double) != 1));
    label146:
    paramaezf = (ETTextView)((agql)localObject).d;
    label384:
    label396:
    float f2 = paramaezf.getTextSize() * 3.0F / 16.0F;
    float f1 = f2;
    if (f2 > 25.0F) {
      f1 = 25.0F;
    }
    paramaezf.setTextColor(-1);
    ColorStateList.valueOf(-1);
    paramaezf.setShadowLayer(f1, 0.0F, 0.0F, paramapee.d);
  }
  
  public void a(aezf paramaezf, ChatMessage paramChatMessage)
  {
    if (a(paramaezf, paramChatMessage)) {}
    do
    {
      return;
      paramaezf = (agql)paramaezf;
    } while ((b(paramChatMessage, paramaezf)) || (!(paramaezf.d instanceof ETTextView)));
    a(paramChatMessage, paramaezf);
  }
  
  void a(agql paramagql, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {}
    gb localgb;
    do
    {
      do
      {
        return;
      } while ((bbyp.b()) || ((1 == paramChatMessage.istroop) && (nmy.a(paramChatMessage))));
      localgb = (gb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
      localgb.b(paramChatMessage);
    } while (!localgb.b(paramChatMessage));
    localgb.a(paramChatMessage);
    localgb.a(paramagql.d);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.getMessage(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForText)AIOUtils.getMessage(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689947);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689948);
    } while (!paramView.isSendFromLocal());
    bfur.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new agqi(this, paramView), new agqj(this)).show();
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
    if (paramChatMessage.isSend()) {
      paramView.setPadding(f, c, e, d);
    }
    for (;;)
    {
      b(paramView, paramChatMessage);
      return;
      paramView.setPadding(e, c, f, d);
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    super.a(paramView, paramChatMessage, paramInt);
    if (paramInt == 1)
    {
      aezf localaezf = (aezf)paramView.getTag();
      if (localaezf != null) {
        a(localaezf, paramView, paramChatMessage, localaezf.jdField_a_of_type_Apee);
      }
    }
    paramView = (aezf)paramView.getTag();
    if (paramView != null) {
      b(paramView.jdField_a_of_type_AndroidViewView, paramChatMessage);
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aezf paramaezf, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaezf, paramInt1, paramInt2);
  }
  
  protected void a(ChatMessage paramChatMessage, String paramString)
  {
    akxv localakxv = akxv.a();
    if (localakxv.c())
    {
      String str = localakxv.b();
      if (str != null) {
        if (str.length() == localakxv.a())
        {
          i = 1;
          j = i;
          localObject = str;
          if ((paramChatMessage instanceof MessageForText))
          {
            j = i;
            localObject = str;
            if (agix.a(paramChatMessage))
            {
              localObject = ((MessageForText)paramChatMessage).sb.toString();
              j = 1;
            }
          }
          localakxv.d();
        }
      }
    }
    for (int i = j;; i = 1)
    {
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, (String)localObject);
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject)) {
        break label142;
      }
      return;
      i = 0;
      break;
      i = 0;
      break;
      localObject = paramChatMessage.msg;
    }
    label142:
    Object localObject = new StringBuilder((String)localObject);
    int j = 0;
    while (j < ((StringBuilder)localObject).length())
    {
      if ((((StringBuilder)localObject).codePointAt(j) == 20) && (j < ((StringBuilder)localObject).length() - 1) && (((StringBuilder)localObject).charAt(j + 1) == 'ÿ'))
      {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800588D", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "report save small emoticon amount");
        }
        bkpf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 13, 0, paramChatMessage.istroop);
        return;
      }
      j += 1;
    }
    if (i == 0)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 4, 0, "", "", "", "");
      return;
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAC", 4, 0, "", "", "", "");
  }
  
  void a(MessageRecord paramMessageRecord)
  {
    int j = 1;
    if (agix.a(paramMessageRecord))
    {
      i = j;
      if (paramMessageRecord.istroop != 0)
      {
        i = j;
        if (paramMessageRecord.istroop != 1) {
          if (!ChatActivityUtils.a(paramMessageRecord.istroop)) {
            break label63;
          }
        }
      }
    }
    label63:
    for (int i = j;; i = 0)
    {
      if ((paramMessageRecord.isMultiMsg) || (this.jdField_b_of_type_Boolean) || (i == 0)) {
        agix.a(paramMessageRecord);
      }
      return;
    }
  }
  
  public boolean a(aezf paramaezf)
  {
    return paramaezf instanceof agql;
  }
  
  public bgbb[] a(View paramView)
  {
    paramView = AIOUtils.getMessage(paramView);
    localbgaz = new bgaz();
    if ((paramView != null) && (paramView.istroop == 10007))
    {
      localbgaz.a(2131365216, this.jdField_a_of_type_AndroidContentContext.getString(2131691176), 2130838962);
      return localbgaz.a();
    }
    if ((paramView != null) && (paramView.isMultiMsg))
    {
      localbgaz.a(2131365216, this.jdField_a_of_type_AndroidContentContext.getString(2131691176), 2130838962);
      localbgaz.a(2131367094, this.jdField_a_of_type_AndroidContentContext.getString(2131692448), 2130838971);
      localbgaz.a(2131366347, this.jdField_a_of_type_AndroidContentContext.getString(2131692036), 2130838970);
      return localbgaz.a();
    }
    if (apse.a(paramView)) {
      return localbgaz.a();
    }
    if (ApolloUtil.a(paramView)) {
      return localbgaz.a();
    }
    int i = 0;
    j = 0;
    if ((paramView instanceof MessageForText)) {
      if (android.text.TextUtils.isEmpty(((MessageForText)paramView).getExtInfoFromExtStr("sticker_info"))) {
        break label539;
      }
    }
    label539:
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
          acvv.a(localbgaz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
        }
      }
      if ((j & 0x2) != 2) {
        break;
      }
      j = 1;
      if (j != 0) {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009B17", "0X8009B17", 0, 0, "", "", "", "");
      }
      if ((paramView instanceof MessageForPoke)) {
        i = 1;
      }
      if (i != 0) {
        break label566;
      }
      if (j == 0) {
        localbgaz.a(2131365216, amtj.a(2131713890), 2130838962);
      }
      if ((paramView != null) && (paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
        localbgaz.a(2131376333, this.jdField_a_of_type_AndroidContentContext.getString(2131717631), 2130838978);
      }
      if (j == 0) {
        localbgaz.a(2131367094, this.jdField_a_of_type_AndroidContentContext.getString(2131692448), 2130838971);
      }
      a(paramView, localbgaz);
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))) {
        a(localbgaz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView);
      }
      a(localbgaz, paramView);
      if ((aqeg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (d())) {
        b(localbgaz, this.jdField_a_of_type_AndroidContentContext, paramView);
      }
      if (AIOUtils.getAIOMsgMenuDpcConfig(5) == 1) {
        localbgaz.a(2131366347, this.jdField_a_of_type_AndroidContentContext.getString(2131692036), 2130838970);
      }
      super.a(localbgaz, this.jdField_a_of_type_AndroidContentContext, paramView);
      if (((paramView instanceof MessageForText)) || ((paramView instanceof MessageForLongTextMsg))) {
        c(paramView, localbgaz);
      }
      b(paramView, localbgaz);
      super.c(localbgaz, this.jdField_a_of_type_AndroidContentContext);
      super.e(localbgaz, this.jdField_a_of_type_AndroidContentContext);
      return localbgaz.a();
    }
  }
  
  public void b(aezf paramaezf, ChatMessage paramChatMessage)
  {
    int i = 0;
    super.b(paramaezf, paramChatMessage);
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {
      break label15;
    }
    label15:
    agql localagql;
    label146:
    label152:
    for (;;)
    {
      return;
      if ((paramaezf instanceof agql))
      {
        localagql = (agql)paramaezf;
        if (!(paramChatMessage instanceof MessageForText)) {
          break;
        }
        paramChatMessage = (MessageForText)paramChatMessage;
        paramaezf = null;
        if (!android.text.TextUtils.isEmpty(paramChatMessage.sb)) {
          if (android.text.TextUtils.isEmpty(paramChatMessage.sb2)) {
            break label146;
          }
        }
        for (paramaezf = paramChatMessage.sb2;; paramaezf = paramChatMessage.sb)
        {
          if ((paramaezf == null) || (!(paramaezf instanceof QQText))) {
            break label152;
          }
          paramChatMessage = (QQText)paramaezf;
          paramaezf = (QQText.EmoticonSpan[])paramChatMessage.getSpans(0, paramaezf.length(), QQText.EmoticonSpan.class);
          if ((paramaezf.length <= 0) || (paramChatMessage.toPurePlainText().length() != 0)) {
            break;
          }
          int j = paramaezf.length;
          while (i < j)
          {
            paramaezf[i].setSize(ScreenUtil.dip2px(26.0F));
            i += 1;
          }
        }
      }
    }
    localagql.d.setText(paramChatMessage);
  }
  
  protected void b(bgaz parambgaz, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && (parambgaz != null) && (paramContext != null) && (bdgn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      parambgaz.a(2131381228, paramContext.getString(2131719695), 0);
    }
  }
  
  public void c(View paramView)
  {
    super.c(paramView);
  }
  
  protected boolean d()
  {
    Object localObject = a();
    if (localObject == null) {
      return false;
    }
    localObject = (bdgh)((BaseChatPie)localObject).getHelper(74);
    if ((localObject != null) && (((bdgh)localObject).a())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
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
        if ((localChatFragment != null) && (localChatFragment.a() != null) && (localChatFragment.a().listView != null)) {
          a(paramMessage, localChatFragment.a().listView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqd
 * JD-Core Version:    0.7.0.1
 */