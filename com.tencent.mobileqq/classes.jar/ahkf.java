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
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.7;
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
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.util.Pair;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ahkf
  extends BaseBubbleBuilder
  implements afwq, Handler.Callback
{
  public static final LRULinkedHashMap<Long, SpannableString> a;
  private static String jdField_a_of_type_JavaLangString = "ArkApp.TextItemBuilder";
  public static final int c = BaseChatItemLayout.h + BaseChatItemLayout.m;
  protected static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  public static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  public static final int f = BaseChatItemLayout.k + BaseChatItemLayout.p;
  protected View.OnClickListener a;
  protected bhud a;
  private fz jdField_a_of_type_Fz = new ahkm(this);
  public Handler b;
  protected View.OnClickListener b;
  
  static
  {
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(50);
  }
  
  public ahkf(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahkg(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ahkh(this);
    this.jdField_a_of_type_Bhud = new ahko(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private static int a(ETTextView paramETTextView, CharSequence paramCharSequence)
  {
    return (int)Math.ceil(paramETTextView.getPaint().measureText(paramCharSequence, 0, paramCharSequence.length()));
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Activity paramActivity, ChatMessage paramChatMessage, String paramString)
  {
    paramChatMessage.msg = a(paramChatMessage.msg, true);
    paramString = a(paramString, true);
    bljl.a(null, paramString).b(paramQQAppInterface, paramChatMessage).a(paramActivity, paramQQAppInterface.getAccount());
    bljv.a(paramQQAppInterface, 6, 1);
    return paramString;
  }
  
  private String a(ChatMessage paramChatMessage, Context paramContext, ahkn paramahkn)
  {
    Object localObject = "";
    if ((paramChatMessage instanceof MessageForText))
    {
      localObject = (MessageForText)paramChatMessage;
      if (paramChatMessage.msgtype == -2008)
      {
        if (paramChatMessage.isSend())
        {
          paramahkn.d.setText(paramContext.getString(2131717664));
          return "";
        }
        paramahkn.d.setText(paramContext.getString(2131717663));
        return "";
      }
      a(paramahkn, paramChatMessage);
      if (!TextUtils.isEmpty(((MessageForText)localObject).sb))
      {
        if (!TextUtils.isEmpty(((MessageForText)localObject).sb2))
        {
          paramahkn.d.setText(((MessageForText)localObject).sb2);
          super.a(paramahkn.d, paramChatMessage);
          if (AppSetting.c)
          {
            paramChatMessage = bdol.e(paramChatMessage.msg);
            paramContext = Spannable.Factory.getInstance().newSpannable(paramChatMessage);
            if (!Linkify.addLinks(paramContext, 15)) {
              break label180;
            }
            paramahkn.d.setContentDescription(paramContext);
          }
        }
        for (;;)
        {
          return ((MessageForText)localObject).sb.toString();
          paramahkn.d.setText(((MessageForText)localObject).sb);
          break;
          label180:
          paramahkn.d.setContentDescription(paramChatMessage);
        }
      }
      paramahkn.d.setText("");
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
        paramahkn.d.setText(paramContext.mHiBoomMessage.text);
        paramChatMessage = paramContext.mHiBoomMessage.text;
      }
      return paramChatMessage;
    }
    if ((paramChatMessage instanceof MessageForPoke))
    {
      paramContext = (MessageForPoke)paramChatMessage;
      paramChatMessage = anni.a(2131713552);
      if (paramContext.name != null) {
        paramChatMessage = "[" + paramContext.name + "]请用最新版手机QQ查看。";
      }
      paramahkn.d.setText(paramChatMessage);
      return paramChatMessage;
    }
    paramahkn.d.setText(paramChatMessage.msg);
    super.a(paramahkn.d, paramChatMessage);
    return paramChatMessage.msg;
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
  
  private void a(int paramInt)
  {
    int i = 1;
    if (paramInt == 0) {
      paramInt = i;
    }
    for (;;)
    {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B155", "0X800B155", paramInt, 0, "", "", "", "");
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
  
  public static void a(Message paramMessage, XListView paramXListView)
  {
    long l = paramMessage.getData().getLong("msg_id");
    paramXListView = afur.a(paramXListView, afur.a(l, paramXListView.getAdapter()));
    if ((paramXListView != null) && ((paramXListView.getTag() instanceof ahkn)))
    {
      paramXListView = (ahkn)paramXListView.getTag();
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
  
  private void a(ChatMessage paramChatMessage, afwr paramafwr, ahkn paramahkn)
  {
    if ((paramahkn.d instanceof AnimationTextView))
    {
      paramahkn = (AnimationTextView)paramahkn.d;
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramahkn, paramafwr.jdField_b_of_type_Int, paramafwr.c, false);
      paramahkn.onDoubleClick = this.jdField_a_of_type_Bhud;
      paramahkn.onSingleClick = new ahki(this, paramChatMessage.isSend());
    }
  }
  
  private void a(ChatMessage paramChatMessage, ahkn paramahkn)
  {
    gc localgc = (gc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
    gb localgb = localgc.b(paramChatMessage);
    ETTextView localETTextView = (ETTextView)paramahkn.d;
    localETTextView.setMinWidth(afur.a(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    if ((!(paramChatMessage instanceof MessageForReplyText)) || (!(paramahkn instanceof ahgv))) {
      localETTextView.setMinHeight(afur.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    paramahkn = gc.a(paramChatMessage);
    if ((localgb != null) && (localgb.jdField_b_of_type_Int == 1)) {
      localETTextView.isParsingMagicFont = false;
    }
    if (gc.a(paramChatMessage)) {
      a(paramChatMessage, localgb, localETTextView);
    }
    a(paramChatMessage, localgc, localgb, localETTextView, paramahkn);
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, Context paramContext, ahkn paramahkn)
  {
    if (paramahkn.c != null) {
      paramahkn.c.setVisibility(8);
    }
    if (paramahkn.b != null) {
      paramahkn.b.setVisibility(8);
    }
    paramBaseChatItemLayout = (TextView)paramBaseChatItemLayout.findViewById(2131364410);
    int i;
    if ((paramChatMessage.mNeedTimeStamp) && (paramChatMessage.time > 0L) && (paramBaseChatItemLayout != null) && (paramChatMessage.time != ((Long)paramBaseChatItemLayout.getTag()).longValue()))
    {
      if (paramahkn.b != null) {
        paramahkn.b.setPadding(0, afur.a(70.0F, paramContext.getResources()), 0, 0);
      }
      if (paramahkn.c != null) {
        paramahkn.c.setPadding(0, afur.a(80.0F, paramContext.getResources()), 0, 0);
      }
      if (((paramChatMessage.extraflag != 32768) || (!paramChatMessage.isSendFromLocal())) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramChatMessage))) {
        break label306;
      }
      i = 1;
      label177:
      if ((paramChatMessage.isFlowMessage) && (i == 0) && (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n))
      {
        if (!paramChatMessage.isSend()) {
          break label312;
        }
        if (paramahkn.b != null)
        {
          paramahkn.b.setImageResource(2130847097);
          paramahkn.b.setVisibility(0);
        }
      }
    }
    label306:
    label312:
    while (paramahkn.c == null)
    {
      return;
      if (paramahkn.b != null) {
        paramahkn.b.setPadding(0, afur.a(30.0F, paramContext.getResources()), 0, 0);
      }
      if (paramahkn.c == null) {
        break;
      }
      paramahkn.c.setPadding(0, afur.a(30.0F, paramContext.getResources()), 0, 0);
      break;
      i = 0;
      break label177;
    }
    paramahkn.c.setImageResource(2130847097);
    paramahkn.c.setVisibility(0);
  }
  
  private void a(ChatMessage arg1, gb paramgb, ETTextView paramETTextView)
  {
    MessageForText localMessageForText;
    CharSequence localCharSequence;
    if ((??? instanceof MessageForText))
    {
      localMessageForText = (MessageForText)???;
      localCharSequence = null;
      if (!TextUtils.isEmpty(localMessageForText.sb))
      {
        if (TextUtils.isEmpty(localMessageForText.sb2)) {
          break label128;
        }
        localCharSequence = localMessageForText.sb2;
      }
    }
    for (;;)
    {
      long l1;
      long l2;
      if ((localCharSequence != null) && (bdol.a(localCharSequence)))
      {
        l1 = ((MessageForText)???).msgUid;
        l2 = ((MessageForText)???).uniseq;
      }
      synchronized (jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
      {
        if (jdField_a_of_type_ComTencentUtilLRULinkedHashMap.containsKey(Long.valueOf(l2)))
        {
          paramgb = (SpannableString)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(Long.valueOf(l2));
          if (paramgb != null)
          {
            paramETTextView.setText(paramgb);
            paramETTextView.mMagicFont = true;
          }
          return;
          label128:
          localCharSequence = localMessageForText.sb;
          continue;
        }
        if ((paramgb != null) && (paramgb.jdField_b_of_type_Int == 1)) {
          paramETTextView.isParsingMagicFont = true;
        }
        ArkRecommendLogic.a().post(new TextItemBuilder.7(this, localCharSequence, l1, l2));
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, gc paramgc, gb paramgb, ETTextView paramETTextView, String paramString)
  {
    if ((paramgb != null) && (paramgb.jdField_a_of_type_Int != 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(paramString))
      {
        if (gc.jdField_a_of_type_Long == 0L) {
          gc.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("personal_font_last_send_report", 1L);
        }
        if ((gc.jdField_a_of_type_Long < gc.jdField_c_of_type_Long) && (paramChatMessage.time * 1000L > gc.jdField_c_of_type_Long))
        {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X8007B2B", 0, 0, "" + (paramgb.jdField_b_of_type_Int - 1), "" + paramgb.jdField_a_of_type_Int, "", "");
          gc.jdField_a_of_type_Long = paramChatMessage.time * 1000L;
          paramgc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
          paramgc.putLong("personal_font_last_send_report", paramChatMessage.time * 1000L);
          paramgc.commit();
        }
        if (paramgb.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
          break label489;
        }
        paramgc = paramgb.jdField_a_of_type_ComEtrumpMixlayoutETFont;
        paramgc.setSize(paramETTextView.getTextSize());
        label220:
        if (!TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("font_animation_played"))) {
          break label521;
        }
      }
      label521:
      for (paramETTextView.shouldStartAnimation = true;; paramETTextView.shouldStartAnimation = false)
      {
        paramETTextView.setFont(paramgc, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "updateTextFont  fontId = " + paramgb.jdField_a_of_type_Int + "fontType = " + paramgb.jdField_b_of_type_Int + "typeface = " + paramgb.jdField_a_of_type_AndroidGraphicsTypeface);
        }
        return;
        if (gc.jdField_b_of_type_Long == 0L) {
          gc.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("personal_font_last_receive_report", 1L);
        }
        if ((gc.jdField_b_of_type_Long >= gc.jdField_c_of_type_Long) || (paramChatMessage.time * 1000L <= gc.jdField_c_of_type_Long)) {
          break;
        }
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X8007B2C", 0, 0, "" + (paramgb.jdField_b_of_type_Int - 1), "" + paramgb.jdField_a_of_type_Int, "", "");
        gc.jdField_b_of_type_Long = paramChatMessage.time * 1000L;
        paramgc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
        paramgc.putLong("personal_font_last_receive_report", paramChatMessage.time * 1000L);
        paramgc.commit();
        break;
        label489:
        paramgc = new ETFont(paramgb.jdField_a_of_type_Int, paramgb.jdField_a_of_type_JavaLangString, paramETTextView.getTextSize(), paramgb.jdField_b_of_type_Int, paramgb.jdField_a_of_type_AndroidGraphicsTypeface);
        break label220;
      }
    }
    if (go.jdField_a_of_type_Int == 4) {
      if (paramgc.a(9999))
      {
        paramETTextView.setDefaultFont(go.a(paramChatMessage), paramChatMessage.uniseq);
        label560:
        if (!QLog.isColorLevel()) {
          break label629;
        }
        paramgc = new StringBuilder().append("updateTextFont fontinfo = ");
        if (paramgb != null) {
          break label631;
        }
      }
    }
    label629:
    label631:
    for (paramChatMessage = "null";; paramChatMessage = paramgb.toString())
    {
      QLog.d("VasFont", 2, paramChatMessage);
      return;
      go.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break label560;
      paramETTextView.setDefaultFont(go.a(paramChatMessage), paramChatMessage.uniseq);
      break label560;
      break;
    }
  }
  
  private void a(MessageForText paramMessageForText, ETTextView paramETTextView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    paramCharSequence3 = new SpannableStringBuilder(paramCharSequence2).append(paramCharSequence3);
    paramCharSequence3.setSpan(new ahkj(this, paramMessageForText, paramETTextView, paramCharSequence1), paramCharSequence2.length(), paramCharSequence3.length(), 33);
    paramETTextView.setTextMsg(paramCharSequence3);
    paramETTextView.setHighlightColor(0);
    paramETTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramETTextView.setFocusable(false);
  }
  
  private boolean a(afwr paramafwr, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {}
    while ((afur.g) || (!(paramafwr instanceof ahkn))) {
      return true;
    }
    return false;
  }
  
  private boolean a(ChatMessage paramChatMessage, ahkn paramahkn)
  {
    int i = 0;
    boolean bool2 = false;
    int j;
    boolean bool1;
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) && (paramChatMessage.isShowQIMStyleGroup))
    {
      i = Color.parseColor("#FFFFFFFF");
      j = Color.parseColor("#ff5078f0");
      paramahkn.d.setTextColor(i);
      paramahkn.d.setLinkTextColor(j);
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
    } while (!ahvz.a().a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
    if (!paramChatMessage.isSend()) {
      i = 1;
    }
    if (i != 0) {
      j = Color.parseColor("#ff000000");
    }
    for (i = Color.parseColor("#ff80e9ff");; i = Color.parseColor("#ff5078f0"))
    {
      paramahkn.d.setTextColor(j);
      paramahkn.d.setLinkTextColor(i);
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
    if (((paramView instanceof ETTextView)) && ((paramChatMessage instanceof MessageForText)) && (ahcz.a(paramChatMessage)))
    {
      localETTextView = (ETTextView)paramView;
      localMessageForText = (MessageForText)paramChatMessage;
      if (TextUtils.isEmpty(localMessageForText.sb)) {
        break label217;
      }
      if (TextUtils.isEmpty(localMessageForText.sb2)) {
        break label208;
      }
      paramView = localMessageForText.sb2;
    }
    for (;;)
    {
      int i = a(localETTextView, paramView);
      int j = BaseChatItemLayout.e - e - f;
      if (i > j)
      {
        String str = this.jdField_a_of_type_AndroidContentContext.getString(2131694175);
        CharSequence localCharSequence = TextUtils.ellipsize(paramView, localETTextView.getPaint(), j - a(localETTextView, str), TextUtils.TruncateAt.END);
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
      label208:
      paramView = localMessageForText.sb;
      continue;
      label217:
      paramView = "";
    }
  }
  
  private void b(ChatMessage paramChatMessage, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", -1);
    Object localObject;
    int i;
    if ((paramChatMessage instanceof MessageForText))
    {
      agjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 3);
      localObject = (MessageForText)paramChatMessage;
      if (!alqc.a().c()) {
        break label292;
      }
      localObject = alqc.a().b();
      if (localObject == null) {
        break label287;
      }
      if (((String)localObject).length() != alqc.a().a()) {
        break label282;
      }
      i = 1;
      if (!ahcz.a(paramChatMessage)) {
        break label359;
      }
      localObject = ((MessageForText)paramChatMessage).sb.toString();
      i = 1;
    }
    label282:
    label287:
    label292:
    label359:
    for (;;)
    {
      localBundle.putString("forward_text", (String)localObject);
      localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
      localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      localObject = new Intent();
      ((Intent)localObject).putExtras(localBundle);
      ((Intent)localObject).putExtra("direct_send_if_dataline_forward", true);
      aufz.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "1", "", "", "");
      if (i != 0) {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramChatMessage.isMultiMsg) {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 1, 0, "1", "", "", "");
        }
        return;
        i = 0;
        break;
        i = 0;
        break;
        if (((MessageForText)localObject).sb != null) {}
        for (localObject = ((MessageForText)localObject).sb.toString();; localObject = ((MessageForText)localObject).msg)
        {
          i = 1;
          break;
        }
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      }
    }
  }
  
  private boolean b(ChatMessage paramChatMessage, ahkn paramahkn)
  {
    boolean bool = false;
    if (((paramChatMessage.istroop != 3000) && (paramChatMessage.istroop != 1)) || ((paramChatMessage.isShowQIMStyleGroup) || (avsr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.h)) || (bcnj.b())))
    {
      ETFont localETFont = new ETFont(0, null, 0.0F);
      if ((paramahkn.d instanceof ETTextView)) {
        ((ETTextView)paramahkn.d).setFont(localETFont, paramChatMessage.uniseq);
      }
      bool = true;
    }
    return bool;
  }
  
  private void c(ChatMessage paramChatMessage, String paramString)
  {
    int i;
    if (paramChatMessage.msg != null)
    {
      agjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 2);
      if (paramChatMessage.isMultiMsg)
      {
        awwt.a("0X8009AB7");
        i = 1;
        if ((paramChatMessage instanceof MessageForLongTextMsg)) {
          i = 2;
        }
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D65", "0X8009D65", i, 0, "" + i, "", "", "");
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644A", "0X800644A", 0, 0, "1", "", "", "");
    }
    for (;;)
    {
      try
      {
        if (!alqc.a().c()) {
          continue;
        }
        str = alqc.a().b();
        if (str == null) {
          break label342;
        }
        if (str.length() != alqc.a().a()) {
          break label337;
        }
        i = 1;
        if ((!(paramChatMessage instanceof MessageForText)) || (!ahcz.a(paramChatMessage))) {
          continue;
        }
        paramChatMessage = ((MessageForText)paramChatMessage).sb.toString();
        i = 1;
      }
      catch (Exception paramChatMessage)
      {
        String str;
        if (!QLog.isColorLevel()) {
          break label336;
        }
        QLog.e("ChatItemBuilder", 2, paramChatMessage.toString());
        return;
        paramChatMessage = str;
        continue;
      }
      if (i != 0)
      {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramChatMessage);
        if (QLog.isColorLevel())
        {
          QLog.d("ChatItemBuilder", 2, "Copy message, msg=" + paramChatMessage);
          return;
          paramChatMessage = paramChatMessage.msg;
          i = 1;
        }
      }
      else
      {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
        continue;
      }
      label336:
      return;
      label337:
      i = 0;
      continue;
      label342:
      i = 0;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public afwq a(View paramView)
  {
    if (a(paramView)) {
      return this;
    }
    return null;
  }
  
  public afwr a()
  {
    return new ahkn();
  }
  
  public SpannableString a(CharSequence paramCharSequence, long paramLong)
  {
    String str1 = bdol.g(paramCharSequence.toString());
    if (TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont msg is empty");
      }
      return null;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = apmp.a(null, str1);
    String[] arrayOfString = ((apmr)localObject).jdField_a_of_type_ArrayOfJavaLangString;
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "generateMagicFont word segment cost " + (l2 - l1) + "ms; msg length = " + paramCharSequence.length());
    }
    if (!((apmr)localObject).jdField_a_of_type_Boolean)
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
    if (anll.a() == 18.0F) {
      f1 = 1.3F;
    }
    i = (int)(((ArrayList)localObject).size() * 0.3F + 0.5D);
    j = (int)(((ArrayList)localObject).size() * 0.3F + 0.5D);
    float f2;
    boolean bool1;
    int i1;
    if (gc.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f2 = gc.jdField_c_of_type_Float;
      f1 = gc.d;
      if (anll.a() == 18.0F)
      {
        f2 = gc.e;
        f1 = gc.jdField_f_of_type_Float;
      }
      bool1 = gc.jdField_f_of_type_Boolean;
      i = (int)(((ArrayList)localObject).size() * gc.jdField_a_of_type_Float + 0.5D);
      j = (int)(((ArrayList)localObject).size() * gc.jdField_b_of_type_Float + 0.5D);
      i1 = gc.jdField_b_of_type_Int;
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
  
  public View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    ahkn localahkn;
    Object localObject1;
    label155:
    Object localObject2;
    Object localObject3;
    if ((paramafwr instanceof ahkn))
    {
      localahkn = (ahkn)paramafwr;
      if (paramView != null) {
        break label843;
      }
      localObject1 = new ImageView(localContext);
      ((ImageView)localObject1).setId(2131366853);
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(0, 2131364379);
      paramView.addRule(15, 2131363300);
      ((ImageView)localObject1).setContentDescription(anni.a(2131713551));
      paramBaseChatItemLayout.addView((View)localObject1, paramView);
      ((ImageView)localObject1).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramView = new ETTextView(localContext);
      bdol.a(paramView);
      paramView.setTextColor(localContext.getResources().getColorStateList(2131167004));
      paramView.setLinkTextColor(localContext.getResources().getColorStateList(2131166998));
      if (!AppSetting.c) {
        break label814;
      }
      paramView.setAutoLinkMask(3);
      paramView.setSpannableFactory(bdnt.a);
      paramView.setMaxWidth(BaseChatItemLayout.e);
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      paramView.setTextAnimationListener(this.jdField_a_of_type_Fz);
      paramView.setId(2131364382);
      localObject2 = new ImageView(localContext);
      ((ImageView)localObject2).setId(2131366854);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131364379);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15, 2131363300);
      ((ImageView)localObject2).setContentDescription(anni.a(2131713553));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = 10;
      paramBaseChatItemLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      ((ImageView)localObject2).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localahkn.d = paramView;
      localahkn.b = ((ImageView)localObject1);
      localahkn.c = ((ImageView)localObject2);
      localahkn.jdField_a_of_type_Alqf = new alqf();
      localahkn.jdField_a_of_type_Alqf.a(paramView);
      localahkn.jdField_a_of_type_Alqf.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
    }
    label814:
    label822:
    label843:
    for (;;)
    {
      ((ETTextView)localahkn.d).setFont(0, paramChatMessage.uniseq);
      localahkn.d.setTypeface(null);
      ((ETTextView)localahkn.d).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      ((ETTextView)localahkn.d).setStrokeColor(false, 0);
      ((ETTextView)localahkn.d).mMagicFont = false;
      ((ETTextView)localahkn.d).setCacheMeasureResult(true);
      localahkn.d.setTypeface(go.a(paramChatMessage));
      if (!TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))
      {
        localObject1 = ((ETTextView)localahkn.d).getETLayout();
        if (localObject1 != null) {
          ((fo)localObject1).jdField_a_of_type_Long = (paramChatMessage.uniseq + 1L);
        }
      }
      localahkn.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      localahkn.d.setGravity(16);
      int j = BaseChatItemLayout.o;
      int i = BaseChatItemLayout.p;
      if (paramChatMessage.isSend())
      {
        j = BaseChatItemLayout.p;
        i = BaseChatItemLayout.o;
      }
      localahkn.d.setPadding(j, BaseChatItemLayout.m, i, BaseChatItemLayout.n);
      localahkn.jdField_a_of_type_Long = paramChatMessage.uniseq;
      localObject1 = a(paramChatMessage, localContext, localahkn);
      localObject2 = (bftx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if (bftx.b(paramChatMessage)) {
        bftx.a(localahkn.d, paramChatMessage);
      }
      localObject3 = bhgz.a();
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) && (!paramChatMessage.isread))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in TextItemBuilder.getBubbleView()");
        }
        ((bhgz)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, (String)localObject1, localContext, paramChatMessage.isSend());
      }
      localahkn.d.setOnTouchListener(paramafzq);
      localahkn.d.setOnLongClickListener(paramafzq);
      localahkn.jdField_a_of_type_Afzq = paramafzq;
      localahkn.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      a(paramChatMessage, paramafwr, localahkn);
      a(paramChatMessage, paramBaseChatItemLayout, localContext, localahkn);
      if (localahkn.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null)
      {
        if (!((bftx)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
          break label822;
        }
        localahkn.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      }
      for (;;)
      {
        if (localahkn.jdField_a_of_type_Alqf != null) {
          localahkn.jdField_a_of_type_Alqf.b(paramChatMessage);
        }
        return paramView;
        localahkn = (ahkn)a();
        localahkn.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
        paramBaseChatItemLayout.setTag(localahkn);
        paramView = null;
        break;
        paramView.setAutoLinkMask(0);
        break label155;
        localahkn.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
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
      return anni.a(2131713550) + bdol.e(paramChatMessage.msg);
    }
    return anni.a(2131713548) + paramChatMessage.msg;
  }
  
  public void a()
  {
    super.a();
    ETEngine.getInstance().onAIODestroy();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "";
      }
    }
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131365308: 
    case 2131365147: 
    case 2131376435: 
    case 2131367027: 
    case 2131366271: 
      do
      {
        do
        {
          return;
          str1 = "";
          break;
          adrm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "1", "", "", "");
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 6, 0, "", "", "", "");
          return;
          c(paramChatMessage, str1);
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
        adrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage.msg, paramChatMessage.uniseq);
        return;
        b(paramChatMessage, str1);
        return;
        a(paramChatMessage, str1);
        agjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 4);
        bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramChatMessage.istroop);
      } while (!paramChatMessage.isMultiMsg);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 1, 0, "1", "", "", "");
      return;
    case 2131371422: 
      super.d(paramChatMessage);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 7, 0, "", "", "", "");
      return;
    case 2131371380: 
      super.a(paramChatMessage);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 5, 0, "", "", "", "");
      return;
    case 2131377124: 
      alqc.a().a(paramChatMessage);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 2, 0, "", "", "", "");
      return;
    }
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 3, 0, "", "", "", "");
    b(paramChatMessage);
  }
  
  public void a(afwr paramafwr, View paramView, ChatMessage paramChatMessage, apwt paramapwt)
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
        } while (!(paramafwr instanceof ahkn));
        localObject = (ahkn)paramafwr;
      } while (a(paramChatMessage, (ahkn)localObject));
      boolean bool = bcnj.b();
      if ((paramapwt.jdField_a_of_type_Int == 0) || (!paramapwt.a()) || (bool))
      {
        paramView = paramView.getResources();
        int i;
        if (paramChatMessage.isSend())
        {
          paramafwr = paramView.getColorStateList(2131167008);
          ((ahkn)localObject).d.setTextColor(paramafwr);
          if (avsr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
          {
            if (!paramChatMessage.isSend()) {
              break label192;
            }
            i = -1;
            ((ahkn)localObject).d.setTextColor(i);
          }
          if (!paramChatMessage.isSend()) {
            break label200;
          }
        }
        for (paramafwr = paramView.getColorStateList(2131167007);; paramafwr = paramView.getColorStateList(2131167006))
        {
          ((ahkn)localObject).d.setLinkTextColor(paramafwr);
          return;
          paramafwr = paramView.getColorStateList(2131167004);
          break;
          i = -16777216;
          break label146;
        }
      }
      ColorStateList.valueOf(paramapwt.jdField_b_of_type_Int);
      if (paramapwt.jdField_b_of_type_Int == 0)
      {
        ((ahkn)localObject).d.setTextColor(-16777216);
        ColorStateList.valueOf(-16777216);
        if (paramapwt.c != 0) {
          break label385;
        }
      }
      for (paramafwr = paramView.getResources().getColorStateList(2131167006);; paramafwr = ColorStateList.valueOf(paramapwt.c))
      {
        ((ahkn)localObject).d.setLinkTextColor(paramafwr);
        if (!(((ahkn)localObject).d instanceof ETTextView)) {
          break;
        }
        if (!paramapwt.jdField_a_of_type_Boolean) {
          break label397;
        }
        ((ETTextView)((ahkn)localObject).d).setShadowLayer(3.0F, 0.0F, 0.0F, paramapwt.d);
        ((ETTextView)((ahkn)localObject).d).setStrokeColor(true, paramapwt.d);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramapwt.d);
        return;
        ((ahkn)localObject).d.setTextColor(paramapwt.jdField_b_of_type_Int);
        break label246;
      }
    } while ((!paramapwt.jdField_b_of_type_Boolean) || (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((ahkn)localObject).d.getCurrentTextColor(), 10000.0D * ((ahkn)localObject).jdField_a_of_type_Apwt.jdField_a_of_type_Double) != 1));
    label146:
    paramafwr = (ETTextView)((ahkn)localObject).d;
    label385:
    label397:
    float f2 = paramafwr.getTextSize() * 3.0F / 16.0F;
    float f1 = f2;
    if (f2 > 25.0F) {
      f1 = 25.0F;
    }
    paramafwr.setTextColor(-1);
    ColorStateList.valueOf(-1);
    paramafwr.setShadowLayer(f1, 0.0F, 0.0F, paramapwt.d);
  }
  
  public void a(afwr paramafwr, ChatMessage paramChatMessage)
  {
    if (a(paramafwr, paramChatMessage)) {}
    do
    {
      return;
      paramafwr = (ahkn)paramafwr;
    } while ((b(paramChatMessage, paramafwr)) || (!(paramafwr.d instanceof ETTextView)));
    a(paramChatMessage, paramafwr);
  }
  
  void a(ahkn paramahkn, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {}
    gc localgc;
    do
    {
      do
      {
        return;
      } while ((bcnj.b()) || ((1 == paramChatMessage.istroop) && (njo.a(paramChatMessage))));
      localgc = (gc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
      localgc.b(paramChatMessage);
    } while (!localgc.b(paramChatMessage));
    localgc.a(paramChatMessage);
    localgc.a(paramahkn.d);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (afur.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForText)afur.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689926);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689927);
    } while (!paramView.isSendFromLocal());
    bglp.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ahkk(this, paramView), new ahkl(this)).show();
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
      afwr localafwr = (afwr)paramView.getTag();
      if (localafwr != null) {
        a(localafwr, paramView, paramChatMessage, localafwr.jdField_a_of_type_Apwt);
      }
    }
    paramView = (afwr)paramView.getTag();
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, afwr paramafwr, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramafwr, paramInt1, paramInt2);
  }
  
  protected void a(ChatMessage paramChatMessage, String paramString)
  {
    alqc localalqc = alqc.a();
    if (localalqc.c())
    {
      String str = localalqc.b();
      if (str != null) {
        if (str.length() == localalqc.a())
        {
          i = 1;
          j = i;
          localObject = str;
          if ((paramChatMessage instanceof MessageForText))
          {
            j = i;
            localObject = str;
            if (ahcz.a(paramChatMessage))
            {
              localObject = ((MessageForText)paramChatMessage).sb.toString();
              j = 1;
            }
          }
          localalqc.d();
        }
      }
    }
    for (int i = j;; i = 1)
    {
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, (String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
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
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800588D", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "report save small emoticon amount");
        }
        bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 13, 0, paramChatMessage.istroop);
        return;
      }
      j += 1;
    }
    if (i == 0)
    {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 4, 0, "", "", "", "");
      return;
    }
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAC", 4, 0, "", "", "", "");
  }
  
  void a(MessageRecord paramMessageRecord)
  {
    int j = 1;
    if (ahcz.a(paramMessageRecord))
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
        ahcz.a(paramMessageRecord);
      }
      return;
    }
  }
  
  public boolean a(afwr paramafwr)
  {
    return paramafwr instanceof ahkn;
  }
  
  public bguj[] a(View paramView)
  {
    paramView = afur.a(paramView);
    localbguh = new bguh();
    if ((paramView != null) && (paramView.istroop == 10007))
    {
      localbguh.a(2131365147, this.jdField_a_of_type_AndroidContentContext.getString(2131691137), 2130838920);
      return localbguh.a();
    }
    if ((paramView != null) && (paramView.isMultiMsg))
    {
      localbguh.a(2131365147, this.jdField_a_of_type_AndroidContentContext.getString(2131691137), 2130838920);
      localbguh.a(2131367027, this.jdField_a_of_type_AndroidContentContext.getString(2131692395), 2130838929);
      localbguh.a(2131366271, this.jdField_a_of_type_AndroidContentContext.getString(2131691986), 2130838928);
      return localbguh.a();
    }
    if (aqjq.a(paramView)) {
      return localbguh.a();
    }
    if (ApolloUtil.a(paramView)) {
      return localbguh.a();
    }
    int i = 0;
    j = 0;
    if ((paramView instanceof MessageForText)) {
      if (TextUtils.isEmpty(((MessageForText)paramView).getExtInfoFromExtStr("sticker_info"))) {
        break label484;
      }
    }
    label484:
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
          adrm.a(localbguh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
      }
      if ((j & 0x2) != 2) {
        break;
      }
      j = 1;
      if (j != 0) {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009B17", "0X8009B17", 0, 0, "", "", "", "");
      }
      if ((paramView instanceof MessageForPoke)) {
        i = 1;
      }
      if (i != 0) {
        break label512;
      }
      if (j == 0) {
        localbguh.a(2131365147, anni.a(2131713549), 2130838920);
      }
      if ((paramView != null) && (paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
        localbguh.a(2131376435, this.jdField_a_of_type_AndroidContentContext.getString(2131717283), 2130838934);
      }
      if (j == 0) {
        localbguh.a(2131367027, this.jdField_a_of_type_AndroidContentContext.getString(2131692395), 2130838929);
      }
      a(paramView, localbguh);
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbguh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbguh, paramView);
      if (afur.a(5) == 1) {
        localbguh.a(2131366271, this.jdField_a_of_type_AndroidContentContext.getString(2131691986), 2130838928);
      }
      super.a(localbguh, this.jdField_a_of_type_AndroidContentContext, paramView);
      b(paramView, localbguh);
      super.c(localbguh, this.jdField_a_of_type_AndroidContentContext);
      super.e(localbguh, this.jdField_a_of_type_AndroidContentContext);
      return localbguh.a();
    }
  }
  
  public void b(afwr paramafwr, ChatMessage paramChatMessage)
  {
    int i = 0;
    super.b(paramafwr, paramChatMessage);
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {
      break label15;
    }
    label15:
    ahkn localahkn;
    label146:
    label152:
    for (;;)
    {
      return;
      if ((paramafwr instanceof ahkn))
      {
        localahkn = (ahkn)paramafwr;
        if (!(paramChatMessage instanceof MessageForText)) {
          break;
        }
        paramChatMessage = (MessageForText)paramChatMessage;
        paramafwr = null;
        if (!TextUtils.isEmpty(paramChatMessage.sb)) {
          if (TextUtils.isEmpty(paramChatMessage.sb2)) {
            break label146;
          }
        }
        for (paramafwr = paramChatMessage.sb2;; paramafwr = paramChatMessage.sb)
        {
          if ((paramafwr == null) || (!(paramafwr instanceof bdnt))) {
            break label152;
          }
          paramChatMessage = (bdnt)paramafwr;
          paramafwr = (bdoa[])paramChatMessage.getSpans(0, paramafwr.length(), bdoa.class);
          if ((paramafwr.length <= 0) || (paramChatMessage.b().length() != 0)) {
            break;
          }
          int j = paramafwr.length;
          while (i < j)
          {
            paramafwr[i].a(bclx.a(26.0F));
            i += 1;
          }
        }
      }
    }
    localahkn.d.setText(paramChatMessage);
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
 * Qualified Name:     ahkf
 * JD-Core Version:    0.7.0.1
 */